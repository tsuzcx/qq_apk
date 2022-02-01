package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.voicechange.VoiceChangeParams.IOnCompressFinish;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import dov.com.qq.im.editipc.PeakIpcController;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class GroupPicUploadProcessor
  extends BasePicUploadProcessor
  implements VoiceChangeParams.IOnCompressFinish
{
  public static final boolean NEW_STORE_FLAG = true;
  public static final String TAG = "GroupPicUploadProcessor";
  QQAppInterface app;
  private boolean isStoryPhoto = false;
  TransFileControllerImpl mController;
  long mFileID;
  boolean mHasVirtualStarted = false;
  boolean mIsGroup = true;
  MessageObserver messageObserver = new GroupPicUploadProcessor.5(this);
  private MessageForPic picMsg;
  private long startTime = -1L;
  public boolean uploadSuccess = false;
  
  public GroupPicUploadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.mController = paramTransFileControllerImpl;
    this.app = ((QQAppInterface)this.app);
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForPic)))
    {
      this.isStoryPhoto = ((MessageForPic)this.mUiRequest.mRec).isStoryPhoto;
      if (this.isStoryPhoto) {
        this.picMsg = ((MessageForPic)this.mUiRequest.mRec);
      }
    }
  }
  
  private im_msg_body.Elem constructQQ18HeadInfoElem()
  {
    Object localObject = (ClassicHeadActivityManager)this.app.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localObject != null) && (((ClassicHeadActivityManager)localObject).a()) && (((ClassicHeadActivityManager)localObject).a() == 1L))
    {
      localObject = ((ClassicHeadActivityManager)localObject).a();
      if (localObject != null)
      {
        int i = ((Setting)localObject).systemHeadID;
        int j = ((Setting)localObject).bHeadType;
        localObject = new im_msg_body.Elem();
        im_msg_body.CommonElem localCommonElem = new im_msg_body.CommonElem();
        localCommonElem.uint32_service_type.set(13);
        hummer_commelem.MsgElemInfo_servtype13 localMsgElemInfo_servtype13 = new hummer_commelem.MsgElemInfo_servtype13();
        localMsgElemInfo_servtype13.uint32_sys_head_id.set(i);
        localMsgElemInfo_servtype13.uint32_head_flag.set(j);
        localCommonElem.bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype13.toByteArray()));
        ((im_msg_body.Elem)localObject).common_elem.set(localCommonElem);
        return localObject;
      }
    }
    return null;
  }
  
  private void fillPttRichTextExtraValue(im_msg_body.RichText paramRichText, MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt != null) && (paramRichText != null))
    {
      paramRichText.ptt.uint32_format.set(paramMessageForPtt.voiceType);
      paramRichText.ptt.uint32_time.set(Utils.a(paramMessageForPtt.voiceLength));
    }
  }
  
  private int getReportSource()
  {
    switch (this.mUiRequest.mBusiType)
    {
    default: 
      return 200;
    case 1008: 
      return 105;
    case 1007: 
      return 101;
    case 1009: 
      return 104;
    case 1006: 
      return 103;
    }
    return 106;
  }
  
  public static int ipToLong(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int j = arrayOfByte[2];
      int k = arrayOfByte[1];
      int m = arrayOfByte[0];
      return m << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private void resetStatictisInfo()
  {
    this.file.stepSig.reset();
    this.file.stepUrl.reset();
    this.file.stepTrans.reset();
    this.file.stepNotify.reset();
    FileMsg localFileMsg = this.file;
    long l = System.nanoTime();
    localFileMsg.startTime = l;
    this.mStartTime = l;
    this.file.endTime = 0L;
  }
  
  public int cancel()
  {
    return super.cancel();
  }
  
  public int checkParam()
  {
    super.checkParam();
    return doCheckParam();
  }
  
  protected im_msg_body.RichText constructPicRichText()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject4 = new im_msg_body.CustomFace();
        ((im_msg_body.CustomFace)localObject4).uint32_file_id.set((int)this.mFileID);
        if ((this.mIpList != null) && (this.mIpList.size() > 0))
        {
          localObject1 = (ServerAddr)this.mIpList.get(0);
          ((im_msg_body.CustomFace)localObject4).uint32_server_ip.set(ipToLong(((ServerAddr)localObject1).mIp));
          ((im_msg_body.CustomFace)localObject4).uint32_server_port.set(((ServerAddr)localObject1).port);
        }
        changeRichText();
        ((im_msg_body.CustomFace)localObject4).uint32_file_type.set(Integer.valueOf(66).intValue());
        ((im_msg_body.CustomFace)localObject4).uint32_useful.set(1);
        if (this.app.getSessionKey() != null) {
          ((im_msg_body.CustomFace)localObject4).bytes_signature.set(ByteStringMicro.copyFrom(this.app.getSessionKey()));
        }
        ((im_msg_body.CustomFace)localObject4).bytes_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
        ((im_msg_body.CustomFace)localObject4).str_file_path.set(this.mFileName);
        Object localObject1 = ((im_msg_body.CustomFace)localObject4).uint32_origin;
        if (!this.mIsRawPic) {
          break label1110;
        }
        i = 1;
        ((PBUInt32Field)localObject1).set(i);
        localObject5 = this.mUiRequest.mRec;
        if (MessageForPic.class.isInstance(localObject5))
        {
          localObject6 = (MessageForPic)localObject5;
          ((im_msg_body.CustomFace)localObject4).uint32_show_len.set(((MessageForPic)localObject6).mShowLength);
          ((im_msg_body.CustomFace)localObject4).uint32_download_len.set(((MessageForPic)localObject6).mDownloadLength);
          ((im_msg_body.CustomFace)localObject4).image_type.set(((MessageForPic)localObject6).imageType);
          if (((MessageForPic)localObject6).picExtraData != null)
          {
            localObject3 = ((MessageForPic)localObject6).picExtraData.getCustomFaceResvAttr();
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              QLog.d("picExtra", 4, "imageBizType: " + ((MessageForPic)localObject6).picExtraData.imageBizType);
              localObject1 = localObject3;
            }
            i = getPicSourceReport((MessageForPic)localObject6, this.mUiRequest.mPicSendSource);
            if (QLog.isColorLevel()) {
              QLog.d("picExtra", 4, "source: " + i);
            }
            ((CustomFaceExtPb.ResvAttr)localObject1).uint32_source.set(i);
            ((im_msg_body.CustomFace)localObject4).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
          }
        }
        else
        {
          ((im_msg_body.CustomFace)localObject4).biz_type.set(getReportBizType());
          ((im_msg_body.CustomFace)localObject4).uint32_width.set(this.mWidth);
          ((im_msg_body.CustomFace)localObject4).uint32_height.set(this.mHeight);
          ((im_msg_body.CustomFace)localObject4).uint32_size.set((int)this.mFileSize);
          ((im_msg_body.CustomFace)localObject4).uint32_source.set(getReportSource());
          if (QLog.isColorLevel()) {
            logRichMediaEvent("busiTypeStat", "uiBusiType:" + this.mUiRequest.mBusiType + " protoBusiType:" + ((im_msg_body.CustomFace)localObject4).biz_type.get());
          }
          localObject3 = new im_msg_body.RichText();
          localObject1 = new im_msg_body.Elem();
          if (!HotChatHelper.a((MessageRecord)localObject5)) {
            break label928;
          }
          ((im_msg_body.Elem)localObject1).hc_flash_pic.set((MessageMicro)localObject4);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
          localObject1 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.a(2131705377)));
          localObject4 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject1);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
          localObject1 = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
          if ((localObject1 instanceof MessageForStructing))
          {
            localObject4 = (MessageForStructing)localObject1;
            if ((((MessageForStructing)localObject4).structingMsg != null) && ((((MessageForStructing)localObject4).structingMsg instanceof StructMsgForImageShare)))
            {
              localObject6 = (StructMsgForImageShare)((MessageForStructing)localObject4).structingMsg;
              localObject5 = ((StructMsgForImageShare)localObject6).getFirstImageElement();
              if (localObject5 != null)
              {
                ((StructMsgItemImage)localObject5).ae = this.mMd5Str;
                ((StructMsgItemImage)localObject5).ad = this.mFileName;
                ((StructMsgItemImage)localObject5).c = this.mFileID;
                ((StructMsgItemImage)localObject5).e = ((MessageRecord)localObject1).time;
                ((StructMsgItemImage)localObject5).d = this.mFileSize;
                if (!AIOGallerySceneWithBusiness.b(((StructMsgForImageShare)localObject6).mMsgActionData)) {
                  break label1096;
                }
                localObject6 = ((StructMsgItemImage)localObject5).ac;
                ((StructMsgItemImage)localObject5).ac = "";
                localObject1 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
                ((StructMsgItemImage)localObject5).ac = ((String)localObject6);
                if ((!TextUtils.isEmpty(((MessageForStructing)localObject4).frienduin)) && (localObject1 != null))
                {
                  localObject4 = new im_msg_body.RichMsg();
                  ((im_msg_body.RichMsg)localObject4).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
                  localObject1 = new im_msg_body.Elem();
                  ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject4);
                  ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
                }
              }
            }
          }
          localObject1 = constructQQ18HeadInfoElem();
          if ((localObject3 == null) || (((im_msg_body.RichText)localObject3).elems == null) || (localObject1 == null)) {
            break label1108;
          }
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
          if (!QLog.isColorLevel()) {
            break label1108;
          }
          QLog.e("GroupPicUploadProcessor", 2, "QQ 18 constructPicRichText add richtext common_elem headid and type");
          break label1108;
        }
        localObject3 = new CustomFaceExtPb.ResvAttr();
        localObject1 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("picExtra", 4, "imageBizType: 0");
        localObject1 = localObject3;
        continue;
        if (!FlashPicHelper.a((MessageRecord)localObject5)) {
          break label1076;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      label928:
      Object localObject5 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject5).uint32_service_type.set(3);
      Object localObject6 = new hummer_commelem.MsgElemInfo_servtype3();
      ((hummer_commelem.MsgElemInfo_servtype3)localObject6).flash_troop_pic.set((MessageMicro)localObject4);
      ((im_msg_body.CommonElem)localObject5).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject6).toByteArray()));
      localException.common_elem.set((MessageMicro)localObject5);
      ((im_msg_body.RichText)localObject3).elems.add(localException);
      if (QLog.isColorLevel()) {
        QLog.d("flash", 2, "GroupPicUploadProcessor constructPicRichText send flash");
      }
      Object localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.a(2131705376)));
      Object localObject4 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject2);
      ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
      continue;
      label1076:
      ((im_msg_body.Elem)localObject2).custom_face.set((MessageMicro)localObject4);
      ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
      continue;
      label1096:
      localObject2 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
      continue;
      label1108:
      return localObject3;
      label1110:
      int i = 0;
    }
  }
  
  protected int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    switch (this.mUiRequest.mUinType)
    {
    }
    for (this.mIsGroup = false;; this.mIsGroup = true)
    {
      localObject = getTransferRequest();
      if ((localObject == null) || (!((TransferRequest)localObject).mIsFastForward)) {
        break;
      }
      if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
        this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
      }
      return 0;
    }
    Object localObject = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      setError(9302, getExpStackString(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = new File((String)localObject);
    if (!localFile.exists())
    {
      setError(9042, getExpStackString(new Exception("sendFile not exist " + (String)localObject)));
      onError();
      return -1;
    }
    if (!localFile.canRead())
    {
      setError(9070, getExpStackString(new Exception("sendFile not readable " + this.file.filePath)));
      onError();
      return -1;
    }
    long l = localFile.length();
    this.file.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      setError(9071, getExpStackString(new Exception("file size 0 " + (String)localObject)));
      onError();
      return -1;
    }
    localObject = FileUtils.b((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((((String)localObject).contains(FileUtils.jdField_a_of_type_JavaLangString)) || (!FileUtils.g((String)localObject)))
      {
        setError(9072, (String)localObject, getClientReason((String)localObject), null);
        onError();
        new Handler(Looper.getMainLooper()).post(new GroupPicUploadProcessor.1(this));
        return -1;
      }
      this.mExtName = ((String)localObject);
    }
    if (l >= PicUploadFileSizeLimit.getLimitGroup())
    {
      setError(9063, (String)localObject, getClientReason((String)localObject), null);
      onError();
      return -1;
    }
    if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
      this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
    }
    return 0;
  }
  
  protected void doRealReport(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (paramBoolean)
    {
      collectChnlCostReport();
      if (this.mUiRequest.mIsPresend)
      {
        long l = 0L;
        if (this.mEnterAioTime != 0L) {
          l = (paramLong2 - this.mEnterAioTime) / 1000000L;
        }
        if (this.mUiRequest.myPresendInvalid) {
          l = paramLong1;
        }
        double d = l / paramLong1;
        StatisticConstants.a(l, this.mFileSize, this.mIsPicSecondTransfered, d);
        if ((d >= 0.0D) && (d <= 1.0D)) {
          this.mReportInfo.put("param_AIOPercent", d + "");
        }
        this.mReportInfo.put("param_AIODuration", l + "");
        if (QLog.isColorLevel()) {
          QLog.d("GroupPicUploadProcessor", 2, "doReport ,mStartTime = " + this.mStartTime + ",mEnterAioTime = " + this.mEnterAioTime + ",finishTime  = " + paramLong2 + ", aioDuration = " + l + ", duration = " + paramLong1 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.mUiRequest.myPresendInvalid + ",Percent = " + d);
        }
      }
      reportForIpv6(true, paramLong1);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, paramLong1, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      super.doReport(paramBoolean);
      return;
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.remove("param_url");
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mReportInfo.put("param_uniseq", String.valueOf(this.mUiRequest.mUniseq));
      reportForIpv6(false, paramLong1);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, paramLong1, this.mFileSize, this.mReportInfo, "");
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!paramBoolean)
    {
      localObject1 = "Q.richmedia." + TransFileUtil.getUinDesc(this.mUiRequest.mUinType) + "." + RichMediaUtil.getFileType(this.mUiRequest.mFileType);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.mUiRequest.mUniseq + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.errCode + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.errDesc);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if ((!paramBoolean) && (this.shouldMsgReportSucc == 1))
    {
      this.mStepMsg.result = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      localObject1 = this.mStepUrl.getReportInfo(1) + ";" + this.mStepTrans.getReportInfo(2) + ";" + this.mStepMsg.getReportInfo(3);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (!paramBoolean)
      {
        localObject2 = (String)this.mReportInfo.get("param_reason");
        if (!"connError_unreachable".equalsIgnoreCase((String)localObject2)) {
          break label345;
        }
      }
      label345:
      do
      {
        this.mReportInfo.put("param_reason", "N_1");
        while (this.mUiRequest.mBusiType == 1030)
        {
          return;
          if ("connError_noroute".equalsIgnoreCase((String)localObject2)) {
            this.mReportInfo.put("param_reason", "N_2");
          }
        }
      } while (((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) || (this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0)));
      int j = this.mReportedFlag;
      long l1;
      long l2;
      if (paramBoolean)
      {
        i = 2;
        this.mReportedFlag = (i | j);
        this.mEndTime = System.currentTimeMillis();
        l1 = System.nanoTime();
        l2 = (l1 - this.mStartTime) / 1000000L;
        Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.mStepTrans.finishTime - this.mStepTrans.startTime) / 1000000L);
        this.mReportInfo.put("param_step", localObject1);
        this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
        this.mReportInfo.put("param_fileid", String.valueOf(this.mFileID));
        this.mReportInfo.put("param_picmd5", this.mFileName);
        this.mReportInfo.put("param_isPresend", this.mUiRequest.mIsPresend + "");
        this.mReportInfo.put("param_isSecondTrans", this.mIsPicSecondTransfered + "");
        this.mReportInfo.put("param_PhoneType", StatisticConstants.a() + "");
        this.mReportInfo.put("param_NetType", NetworkUtil.a(BaseApplication.getContext()) + "");
        this.mReportInfo.put("param_IsRawPic", this.mIsRawPic + "");
        this.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
        this.mReportInfo.put("param_quickHttp", String.valueOf(this.mSendByQuickHttp));
        this.mReportInfo.put("param_picType", String.valueOf(this.mPicType));
        this.mReportInfo.put("param_busi", String.valueOf(this.mUiRequest.mBusiType));
        localObject1 = this.mReportInfo;
        if (!this.mUiRequest.isQzonePic) {
          break label870;
        }
      }
      label870:
      for (int i = 1;; i = 0)
      {
        ((HashMap)localObject1).put("param_source_type", String.valueOf(i));
        doRealReport(paramBoolean, l2, l1);
        return;
        i = 1;
        break;
      }
    }
  }
  
  protected void doStart(boolean paramBoolean)
  {
    if (!paramBoolean) {
      sendMessageToUpdate(1001);
    }
    sendMessageToUpdate(1000);
    this.file.closeInputStream();
    sendMessageToUpdate(1001);
    TransferRequest localTransferRequest = getTransferRequest();
    if ((localTransferRequest != null) && (localTransferRequest.mIsFastForward))
    {
      this.mWidth = localTransferRequest.mFastForwardWidth;
      this.mHeight = localTransferRequest.mFastForwardHeight;
      this.mFileSize = localTransferRequest.mFastForwardFileSize;
      this.mLocalMd5 = HexUtil.hexStr2Bytes(localTransferRequest.mMd5);
      this.mFileName = localTransferRequest.mMd5;
      this.mMd5Str = this.mFileName;
      this.file.fileMd5 = this.mFileName;
      this.mFileName = (this.mFileName + "." + this.mExtName);
      this.app.getHwEngine().preConnect();
      sendRequest();
    }
    while (!checkFileStandard(true)) {
      return;
    }
    this.app.getHwEngine().preConnect();
    sendRequest();
  }
  
  protected String getReportTAG()
  {
    if (this.mIsGroup)
    {
      if (this.mChannelStatus == 1) {
        return "actGroupPicUploadV2";
      }
      return "actGroupPicUploadV1";
    }
    if (this.mChannelStatus == 1) {
      return "actDiscussPicUploadV2";
    }
    return "actDiscussPicUpload";
  }
  
  void inter_retry()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((this.mUkey != null) && (this.mFileID != 0L))
    {
      if (this.mTransferedSize >= this.mFileSize)
      {
        sendMsg();
        return;
      }
      if ((this.mChannelStatus == 1) && (this.mTrans != null))
      {
        log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.app.getHwEngine().resumeTransactionTask(this.mTrans);
        return;
      }
      start();
      return;
    }
    start();
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    super.onBusiProtoResp(paramRichProtoReq, paramRichProtoResp);
    onGroupBusiProtoResp(paramRichProtoReq, paramRichProtoResp);
  }
  
  /* Error */
  public void onCompressFinished(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   6: iconst_1
    //   7: putfield 1128	com/tencent/mobileqq/transfile/TransferRequest:mPttCompressFinish	Z
    //   10: aload_0
    //   11: getfield 65	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   14: getfield 71	com/tencent/mobileqq/transfile/TransferRequest:mRec	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 185	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 194	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 188	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 37	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:mHasVirtualStarted	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokevirtual 277	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:doCheckParam	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual 1130	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:doStart	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokevirtual 277	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:doCheckParam	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokevirtual 1130	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:doStart	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	GroupPicUploadProcessor
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
  }
  
  void onError()
  {
    super.onError();
    if (this.errCode != 9333) {
      sendMessageToUpdate(1005);
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.errCode;
      localSendResult.jdField_a_of_type_JavaLangString = this.errDesc;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    if (this.mUiRequest.mIsPttPreSend) {
      PttPreSendManager.a(this.app).a(getKey());
    }
  }
  
  protected void onGroupBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    int i;
    if (paramRichProtoResp != null)
    {
      i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mSendByQuickHttp);
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if ((paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp))
        {
          paramRichProtoReq = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq;
          if (paramRichProtoReq.result != 0) {
            break label295;
          }
          reportQuickSend(paramRichProtoReq.isExist);
          if (!paramRichProtoReq.isExist) {
            break label203;
          }
          if (QLog.isColorLevel()) {
            QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp GroupPicUpResp.isExist.");
          }
          this.mIsPicSecondTransfered = true;
          this.file.transferedSize = this.file.fileSize;
          this.mFileID = paramRichProtoReq.groupFileID;
          this.mIpList = paramRichProtoReq.mIpList;
          sendMsg();
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label203:
      sendMessageToUpdate(1002);
      if (!checkContinueSend()) {
        return;
      }
      this.mFileID = paramRichProtoReq.groupFileID;
      this.mUkey = paramRichProtoReq.mUkey;
      this.mIpList = paramRichProtoReq.mIpList;
      this.mTransferedSize = paramRichProtoReq.transferedSize;
      this.mBlockSize = paramRichProtoReq.blockSize;
      this.mStartOffset = paramRichProtoReq.startOffset;
      this.mChannelStatus = 1;
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
      }
      sendFileBDH();
    }
    label295:
    log("<BDH_LOG> onBusiProtoResp() error : " + paramRichProtoReq.result + " ,select HTTP channel");
    this.mChannelStatus = 2;
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Long = this.mFileSize;
      localSendResult.d = this.mMd5Str;
      localSendResult.c = this.mFileName;
      localSendResult.jdField_b_of_type_JavaLangString = this.mUiRequest.mLocalPath;
      localSendResult.jdField_b_of_type_Long = this.mFileID;
      if (this.mUiRequest.isShareImageByServer) {
        localSendResult.jdField_a_of_type_JavaLangObject = getImageInfo();
      }
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    for (;;)
    {
      sendMessageToUpdate(1003);
      return;
      updateMessageDataBaseContent(true);
    }
  }
  
  public void pause()
  {
    super.pause();
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("pause", "");
      }
      sendMessageToUpdate(1006);
      if (this.mRichProtoReq != null)
      {
        RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
        this.mRichProtoReq = null;
      }
    }
    switch (this.mChannelStatus)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        log("<BDH_LOG> pause() BUT current status is INIT");
        return;
        log("<BDH_LOG> pause() pause HTTP channel");
      } while (this.mNetReq == null);
      this.mNetEngine.cancelReq(this.mNetReq);
      this.mNetReq = null;
      return;
    }
    if (this.mTrans != null)
    {
      log("<BDH_LOG> pause() pause BDH channel, transation id=" + this.mTrans.getTransationId());
      this.app.getHwEngine().stopTransactionTask(this.mTrans);
      return;
    }
    log("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  public int resume()
  {
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      sendMessageToUpdate(1002);
      if (this.mChannelStatus != 1)
      {
        this.mTransferedSize = 0L;
        this.mUkey = null;
      }
      this.mServerRollbackCount = 0;
      this.mTryCount = 0;
      this.mReqUrlCount = 0;
      this.errCode = 0;
      this.errDesc = "";
      this.sscmObject.a();
      resetStatictisInfo();
      this.mController.mHandler.post(new GroupPicUploadProcessor.4(this));
    }
    return 0;
  }
  
  public void sendFileBDH()
  {
    if (this.startTime == -1L) {
      this.startTime = SystemClock.uptimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.mTrans + "  this:" + this);
    }
    if (this.mTrans != null) {}
    int i;
    do
    {
      return;
      this.mStepTrans.logStartTime();
      Object localObject = HexUtil.hexStr2Bytes(this.mUkey);
      GroupPicUploadProcessor.2 local2 = new GroupPicUploadProcessor.2(this);
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 2, this.mUiRequest.mLocalPath, (int)this.mStartOffset, (byte[])localObject, this.mLocalMd5, local2);
      localObject = new GroupPicUploadProcessor.3(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
      i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 2);
      }
    } while (i == 0);
    setError(i, "SubmitError.", "", this.mStepTrans);
    onError();
  }
  
  void sendGroupMsg()
  {
    if ((!this.needSendMsg) || (this.mUiRequest.mIsPresend))
    {
      if (this.mUiRequest.mIsPresend) {
        ((MessageForPic)this.mUiRequest.mRec).mPresendTransferedSize = this.mTransferedSize;
      }
      localObject1 = constructPicRichText();
      if (localObject1 == null)
      {
        setError(9368, "constructpberror", null, this.mStepMsg);
        onError();
      }
      for (;;)
      {
        if ((this.mUiRequest.mIsPresend) && (this.mIsPicSecondTransfered)) {
          ((MessageForPic)this.mUiRequest.mRec).mPresendTransferedSize = 0L;
        }
        addInfoToMsg();
        onSuccess();
        return;
        if (!isAppValid())
        {
          setError(9366, "illegal app", null, this.mStepMsg);
          onError();
          return;
        }
        if (this.mUiRequest.mUpCallBack != null) {
          this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = constructPicRichText();
    if (localObject2 == null)
    {
      setError(9368, "constructpberror", null, this.mStepMsg);
      onError();
      return;
    }
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepMsg);
      onError();
      return;
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject1 = this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label402;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label375;
      }
    }
    label375:
    for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      setError(9368, "msgtypeError", (String)localObject1, this.mStepMsg);
      onError();
      return;
      if (this.mUiRequest.mRec != null)
      {
        localObject1 = this.mUiRequest.mRec;
        break;
      }
      localObject1 = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      break;
    }
    label402:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.mFileSize;
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    addInfoToMsg();
    ((OrderMediaMsgManager)this.app.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a((MessageRecord)localObject1, this.messageObserver, this);
  }
  
  protected void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (this.isStoryPhoto) {
      PeakIpcController.a(this.picMsg, paramInt, getProgress());
    }
  }
  
  void sendMsg()
  {
    if (!canDoNextStep())
    {
      log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.mChannelStatus);
      return;
    }
    this.mStepMsg.logStartTime();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    sendGroupMsg();
  }
  
  protected void sendRequest()
  {
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.fileName = this.mFileName;
    localPicUpReq.fileSize = this.mFileSize;
    localPicUpReq.md5 = this.mLocalMd5;
    localPicUpReq.width = this.mWidth;
    localPicUpReq.height = this.mHeight;
    localPicUpReq.isRaw = this.mIsRawPic;
    localPicUpReq.busiType = this.mUiRequest.mBusiType;
    changeRequest(localPicUpReq);
    MessageRecord localMessageRecord = this.mUiRequest.mRec;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      localPicUpReq.picType = ((MessageForPic)localMessageRecord).imageType;
      this.mPicType = ((MessageForPic)localMessageRecord).imageType;
    }
    localPicUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPicUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPicUpReq.secondUin = this.mUiRequest.mSecondId;
    localPicUpReq.uinType = this.mUiRequest.mUinType;
    if (this.mUiRequest.mUinType == 1026)
    {
      localPicUpReq.uinType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "grp_pic_up";
    localRichProtoReq.reqs.add(localPicUpReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", localRichProtoReq.toString());
      }
    } while (!canDoNextStep());
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  protected void setMtype()
  {
    int i = this.mUiRequest.mFileType;
    if ((this.mNetReq instanceof HttpNetReq))
    {
      if (!this.mIsGroup) {
        break label58;
      }
      if (i != 2) {
        break label31;
      }
    }
    label31:
    label58:
    while (i == 2)
    {
      return;
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("picGu", ((HttpNetReq)this.mNetReq).mReqUrl);
      return;
    }
    ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("picDu", ((HttpNetReq)this.mNetReq).mReqUrl);
  }
  
  public void start()
  {
    super.start();
    doStart(false);
  }
  
  public void updateMessageDataBaseContent(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.mUiRequest.mRec != null)
    {
      localMessageRecord = this.mUiRequest.mRec;
      if (localMessageRecord != null) {
        break label78;
      }
      logRichMediaEvent("updateDb", "msg null");
    }
    label78:
    Object localObject;
    StructMsgItemImage localStructMsgItemImage;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
          logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            logRichMediaEvent("updateDb", "is multiMsg");
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.mUiRequest.mLocalPath;
            ((MessageForPic)localObject).size = this.mFileSize;
            ((MessageForPic)localObject).uuid = this.mFileName;
            ((MessageForPic)localObject).groupFileID = this.mFileID;
            ((MessageForPic)localObject).md5 = this.mMd5Str;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localStructMsgItemImage == null);
    localStructMsgItemImage.ae = this.mMd5Str;
    localStructMsgItemImage.ad = this.mFileName;
    localStructMsgItemImage.d = this.mFileSize;
    localStructMsgItemImage.c = this.mFileID;
    localStructMsgItemImage.e = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */