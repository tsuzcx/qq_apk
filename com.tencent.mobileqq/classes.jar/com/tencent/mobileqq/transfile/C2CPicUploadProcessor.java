package com.tencent.mobileqq.transfile;

import ahsj;
import aklj;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import anud;
import anvx;
import anyz;
import azla;
import azlb;
import bbob;
import bcrg;
import bcsa;
import bdqa;
import blkh;
import boqd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.NewServiceTicket;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicInfoExt;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicRspExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class C2CPicUploadProcessor
  extends BasePicUploadProcessor
{
  public static final String TAG = "C2CPicUploadProcessor";
  protected QQAppInterface app;
  private boolean isStoryPhoto;
  protected TransFileController mController;
  protected byte[] mExtendInfo;
  protected boolean mIsOpenUpEnable;
  protected CSDataHighwayHead.LoginSigHead mLoginSigHead;
  protected byte[] mOpenUpTicket;
  private int mPreSendDots;
  private byte[] mSessionKey;
  private byte[] mSigSession;
  private BaseTransProcessor.StepInfo mStepTransLeft = new BaseTransProcessor.StepInfo();
  private BaseTransProcessor.StepInfo mStepTransPre = new BaseTransProcessor.StepInfo();
  anyz messageObserver = new C2CPicUploadProcessor.6(this);
  private MessageForPic picMsg;
  public boolean uploadSuccess;
  
  public C2CPicUploadProcessor() {}
  
  public C2CPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.mController = paramTransFileController;
    this.app = ((QQAppInterface)this.app);
    this.file.fileType = this.mUiRequest.mFileType;
    this.file.uniseq = this.mUiRequest.mUniseq;
    this.file.actionType = 0;
    this.file.friendUin = this.mUiRequest.mPeerUin;
    this.file.uinType = 0;
    this.file.processorDoReportSelf = true;
    this.mProxyIpList = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(3);
    this.mIsOpenUpEnable = OpenUpConfig.isOpenUpEnable;
    this.mPreSendDots = OpenUpConfig.getPreSendDots(BaseApplication.getContext());
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForPic)))
    {
      this.isStoryPhoto = ((MessageForPic)this.mUiRequest.mRec).isStoryPhoto;
      if (this.isStoryPhoto) {
        this.picMsg = ((MessageForPic)this.mUiRequest.mRec);
      }
    }
  }
  
  private im_msg_body.RichText constructRichText()
  {
    label900:
    label914:
    for (int i = 1;; i = 0)
    {
      im_msg_body.RichText localRichText;
      for (;;)
      {
        Object localObject3;
        try
        {
          localRichText = new im_msg_body.RichText();
          Object localObject4 = new im_msg_body.NotOnlineImage();
          changeRichText();
          ((im_msg_body.NotOnlineImage)localObject4).file_path.set(ByteStringMicro.copyFromUtf8(this.mFileName));
          if (this.file.uuidPath != null) {
            ((im_msg_body.NotOnlineImage)localObject4).download_path.set(ByteStringMicro.copyFromUtf8(this.file.uuidPath));
          }
          if (this.file.serverPath != null) {
            ((im_msg_body.NotOnlineImage)localObject4).res_id.set(ByteStringMicro.copyFromUtf8(this.file.serverPath));
          }
          ((im_msg_body.NotOnlineImage)localObject4).file_len.set((int)this.mFileSize);
          ((im_msg_body.NotOnlineImage)localObject4).pic_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
          ((im_msg_body.NotOnlineImage)localObject4).pic_height.set(this.mHeight);
          ((im_msg_body.NotOnlineImage)localObject4).pic_width.set(this.mWidth);
          Object localObject1 = ((im_msg_body.NotOnlineImage)localObject4).original;
          if (!this.mIsRawPic) {
            break label914;
          }
          ((PBUInt32Field)localObject1).set(i);
          Object localObject5 = this.mUiRequest.mRec;
          Object localObject6;
          if (MessageForPic.class.isInstance(localObject5))
          {
            localObject6 = (MessageForPic)localObject5;
            ((im_msg_body.NotOnlineImage)localObject4).uint32_show_len.set(((MessageForPic)localObject6).mShowLength);
            ((im_msg_body.NotOnlineImage)localObject4).uint32_download_len.set(((MessageForPic)localObject6).mDownloadLength);
            ((im_msg_body.NotOnlineImage)localObject4).img_type.set(((MessageForPic)localObject6).imageType);
            if (((MessageForPic)localObject6).picExtraData != null)
            {
              localObject3 = ((MessageForPic)localObject6).picExtraData.getOfflineImageResvAttr();
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
              ((NotOnlineImageExtPb.ResvAttr)localObject1).uint32_source.set(i);
              ((im_msg_body.NotOnlineImage)localObject4).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
            }
          }
          else
          {
            ((im_msg_body.NotOnlineImage)localObject4).biz_type.set(getReportBizType());
            if (QLog.isColorLevel()) {
              logRichMediaEvent("busiTypeStat", "uiBusiType:" + this.mUiRequest.mBusiType + " protoBusiType:" + ((im_msg_body.NotOnlineImage)localObject4).biz_type.get());
            }
            localObject1 = new im_msg_body.Elem();
            if (!anud.a((MessageRecord)localObject5)) {
              break label871;
            }
            localObject3 = new im_msg_body.CommonElem();
            ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(3);
            localObject5 = new hummer_commelem.MsgElemInfo_servtype3();
            ((hummer_commelem.MsgElemInfo_servtype3)localObject5).flash_c2c_pic.set((MessageMicro)localObject4);
            ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject5).toByteArray()));
            ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject3);
            localRichText.elems.add((MessageMicro)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("flash", 2, "C2CPicUploadProcessor constructPicRichText send flash");
            }
            localObject1 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(anvx.a(2131700794)));
            localObject3 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject3).text.set((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            localObject5 = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
            if (!(localObject5 instanceof MessageForStructing)) {
              break;
            }
            localObject3 = (MessageForStructing)localObject5;
            if ((((MessageForStructing)localObject3).structingMsg == null) || (!(((MessageForStructing)localObject3).structingMsg instanceof StructMsgForImageShare))) {
              break;
            }
            localObject6 = (StructMsgForImageShare)((MessageForStructing)localObject3).structingMsg;
            localObject4 = ((StructMsgForImageShare)localObject6).getFirstImageElement();
            if (localObject4 == null) {
              break;
            }
            ((bdqa)localObject4).ae = this.mMd5Str;
            if (this.mResid != null) {
              break label892;
            }
            localObject1 = this.mUuid;
            ((bdqa)localObject4).ad = ((String)localObject1);
            ((bdqa)localObject4).d = this.mFileSize;
            ((bdqa)localObject4).e = ((MessageRecord)localObject5).time;
            if (!ahsj.b(((StructMsgForImageShare)localObject6).mMsgActionData)) {
              break label900;
            }
            localObject5 = ((bdqa)localObject4).ac;
            ((bdqa)localObject4).ac = "";
            localObject1 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
            ((bdqa)localObject4).ac = ((String)localObject5);
            if ((TextUtils.isEmpty(((MessageForStructing)localObject3).frienduin)) || (localObject1 == null)) {
              break;
            }
            localObject3 = new im_msg_body.RichMsg();
            ((im_msg_body.RichMsg)localObject3).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject3);
            localRichText.elems.add((MessageMicro)localObject1);
            break;
          }
          localObject3 = new NotOnlineImageExtPb.ResvAttr();
          localObject1 = localObject3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("picExtra", 4, "imageBizType: 0");
          localObject1 = localObject3;
          continue;
          localException.not_online_image.set((MessageMicro)localObject4);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error", localException);
          }
          localException.printStackTrace();
          return null;
        }
        label871:
        localRichText.elems.add(localException);
        continue;
        label892:
        Object localObject2 = this.mResid;
        continue;
        localObject2 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
      }
      return localRichText;
    }
  }
  
  private void doDSReport(boolean paramBoolean, String paramString)
  {
    Object localObject1 = null;
    if (this.mUiRequest.mRec != null) {
      localObject1 = this.mUiRequest.mRec;
    }
    long l1;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)))
    {
      l1 = ((MessageForPic)localObject1).DSKey;
      if (l1 != 0L) {
        break label53;
      }
    }
    label53:
    Object[] arrayOfObject;
    do
    {
      return;
      arrayOfObject = (Object[])this.app.getMsgCache().b.remove(Long.valueOf(l1));
    } while (arrayOfObject == null);
    String str2 = (String)arrayOfObject[0];
    ((MessageForPic)localObject1).SpeedInfo = paramString;
    Object localObject2 = paramString.split(";");
    Object localObject3 = localObject2[0];
    localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    localObject3 = ((String)localObject3).split("_");
    Object localObject5 = ((String)localObject1).split("_");
    localObject1 = ((String)localObject2).split("_");
    long l2 = Long.valueOf(localObject3[4]).longValue();
    long l3 = Long.valueOf(localObject1[4]).longValue();
    long l4 = Long.valueOf(localObject5[4]).longValue();
    localObject2 = str2.split(";");
    localObject3 = localObject2[0];
    localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    localObject3 = ((String)localObject3).split("_");
    localObject1 = ((String)localObject1).split("_");
    localObject2 = ((String)localObject2).split("_");
    long l5 = Long.valueOf(localObject3[4]).longValue();
    long l6 = Long.valueOf(localObject2[4]).longValue();
    long l7 = Long.valueOf(localObject1[4]).longValue();
    localObject2 = (String)this.mReportInfo.get("param_BdhTrans");
    long l8 = Long.valueOf(localObject1[4]).longValue() - ((Integer)arrayOfObject[4]).intValue();
    Object localObject4;
    String str1;
    int k;
    int j;
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      localObject2 = ((String)localObject2).split(";");
      localObject1 = localObject2[0];
      localObject4 = localObject2[2].split(":")[1];
      localObject1 = localObject2[3].split(":")[1];
      str1 = localObject2[4].split(":")[1];
      localObject3 = localObject2[5].split(":")[1];
      localObject2 = localObject2[6].split(":")[1];
      l1 = Long.valueOf(localObject5[4]).longValue() - Integer.valueOf((String)localObject1).intValue();
      k = (int)((float)this.file.fileSize / ((float)l1 / 1000.0F) / 1000.0F);
      j = (int)((float)this.file.fileSize / ((float)l8 / 1000.0F) / 1000.0F);
      if ((localObject1 == null) || (l1 < l8)) {
        break label1295;
      }
    }
    label1287:
    label1295:
    for (int i = 0;; i = 1)
    {
      String str3 = (String)arrayOfObject[2];
      int m = this.app.getMsgCache().a();
      localObject5 = new SimpleDateFormat("MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()));
      StringBuilder localStringBuilder = new StringBuilder(anvx.a(2131700793)).append("发了第").append(m).append("张").append("\n");
      localStringBuilder.append("时间:").append((String)localObject5).append("\n");
      localStringBuilder.append("图片大小:").append(this.file.fileSize).append("bytes\n");
      localObject5 = localStringBuilder.append("老通道传输:").append(l8).append("ms,").append("速度:");
      if (l8 == 0L) {
        j = 0;
      }
      ((StringBuilder)localObject5).append(j).append("kbps").append("\n");
      localObject5 = localStringBuilder.append("新通道传输:").append(l1).append("ms,").append("速度:");
      if (l1 == 0L)
      {
        j = 0;
        label727:
        ((StringBuilder)localObject5).append(j).append("kbps").append("\n");
        if (i == 0) {
          break label1271;
        }
        localObject5 = "结果:新通道传输较快\n";
        label756:
        localStringBuilder.append((String)localObject5);
        localStringBuilder.append("老通道 Step:").append("申请").append(l5).append("ms_").append("传输").append(l7).append("ms_").append("消息").append(l6).append("ms").append("\n");
        localStringBuilder.append("新通道 Step:").append("申请").append(l2).append("ms_").append("传输").append(l4).append("ms_").append("消息").append(l3).append("ms").append("\n");
        localStringBuilder.append("群图Info:").append("接入:").append(arrayOfObject[3]).append("ms;").append("架平:").append(arrayOfObject[4]).append("ms").append("\n");
        localObject4 = localStringBuilder.append("新通道info:").append("接入:").append((String)localObject4).append("ms;").append("架平:");
        if (localObject1 == null) {
          break label1279;
        }
        label987:
        ((StringBuilder)localObject4).append((String)localObject1).append("ms").append("\n");
        localObject4 = localStringBuilder.append("Channel:");
        if (this.mChannelStatus != 1) {
          break label1287;
        }
      }
      for (localObject1 = "Tcp";; localObject1 = "Http")
      {
        ((StringBuilder)localObject4).append((String)localObject1).append("\n");
        localStringBuilder.append("网络:").append(str1).append("\n");
        localStringBuilder.append("Host:").append((String)localObject3).append("\n");
        localStringBuilder.append("连接数:").append((String)localObject2).append("\n");
        localObject1 = bcsa.a(this.app, this.app.getCurrentAccountUin(), str3, str3, 1, (byte)1, (byte)0, (short)0, localStringBuilder.toString());
        this.app.getMessageFacade().addAndSendMessage((MessageRecord)localObject1, null);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_c2cSpeed", String.valueOf(l1));
        ((HashMap)localObject1).put("param_grpSpeed", String.valueOf(l8));
        ((HashMap)localObject1).put("param_c2cInfo", paramString);
        ((HashMap)localObject1).put("param_grpInfo", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSFResult", paramBoolean, l1, this.mFileSize, (HashMap)localObject1, "");
        return;
        l1 = this.reportTimeTrans;
        long l9 = this.reportTimePicCache;
        localObject3 = null;
        localObject1 = String.valueOf(l9);
        localObject2 = null;
        str1 = null;
        localObject4 = null;
        break;
        j = k;
        break label727;
        label1271:
        localObject5 = "结果:老通道传输较快\n";
        break label756;
        label1279:
        localObject1 = "";
        break label987;
      }
    }
  }
  
  private void parseExtInfo(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      Object localObject = new CSDataHighwayHead.PicRspExtInfo();
      try
      {
        ((CSDataHighwayHead.PicRspExtInfo)localObject).mergeFrom(paramArrayOfByte);
        if (((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.has())
        {
          paramArrayOfByte = ((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.get().toByteArray();
          localObject = new byte[paramArrayOfByte.length];
          System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> byte_skey.length:" + paramArrayOfByte.length);
          }
          Cryptor localCryptor = new Cryptor();
          if (this.mSessionKey != null)
          {
            localObject = localCryptor.decrypt((byte[])localObject, 0, paramArrayOfByte.length, this.mSessionKey);
            if ((localObject != null) && (localObject.length > 36))
            {
              if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> result.length:" + localObject.length);
              }
              paramArrayOfByte = new byte[localObject.length];
              System.arraycopy(localObject, 0, paramArrayOfByte, 0, localObject.length);
              int j = ByteBuffer.wrap(paramArrayOfByte).getShort(34);
              localObject = new char[j];
              while (i < j)
              {
                localObject[i] = ((char)paramArrayOfByte[(i + 36)]);
                i += 1;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, paramArrayOfByte.getMessage());
          }
        }
        paramArrayOfByte = String.valueOf((char[])localObject);
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> fileIdStr:" + paramArrayOfByte);
        }
        this.file.serverPath = paramArrayOfByte;
        this.mResid = paramArrayOfByte;
        this.file.uuidPath = paramArrayOfByte;
        this.mUuid = paramArrayOfByte;
      }
    }
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
  
  private void sendFileNotBlockCallThread()
  {
    this.mController.mHandler.post(new C2CPicUploadProcessor.2(this));
  }
  
  public int checkParam()
  {
    Object localObject = getTransferRequest();
    if ((localObject != null) && (((TransferRequest)localObject).mIsFastForward))
    {
      if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
        this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
      }
      return 0;
    }
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    localObject = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      setError(9302, getExpStackString(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = getFile((String)localObject);
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
    localObject = FileUtils.estimateFileType((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((((String)localObject).contains(FileUtils.unKnownFileTypeMark)) || (!FileUtils.isPicFileByExt((String)localObject)))
      {
        setError(9072, (String)localObject, getClientReason((String)localObject), null);
        onError();
        new Handler(Looper.getMainLooper()).post(new C2CPicUploadProcessor.1(this));
        return -1;
      }
      this.mExtName = ((String)localObject);
    }
    if (l >= PicUploadFileSizeLimit.getLimitC2C())
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
        aklj.a(l, this.mFileSize, this.mIsPicSecondTransfered, d);
        if ((d >= 0.0D) && (d <= 1.0D)) {
          this.mReportInfo.put("param_AIOPercent", d + "");
        }
        this.mReportInfo.put("param_AIODuration", l + "");
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "doReport ,mStartTime = " + this.mStartTime + ",mEnterAioTime = " + this.mEnterAioTime + ",finishTime  = " + paramLong2 + ", aioDuration = " + l + ", duration = " + paramLong1 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.mUiRequest.myPresendInvalid + ",Percent = " + d);
        }
      }
      reportForIpv6(true, paramLong1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.mReportInfo.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, paramLong1, this.mFileSize, localHashMap, "");
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
      this.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
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
      localObject1 = "Q.richmedia." + RichMediaUtil.getUinDesc(this.mUiRequest.mUinType) + "." + RichMediaUtil.getFileType(this.mUiRequest.mFileType);
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
      localObject2 = this.mStepTransPre.getReportInfo(21) + ";" + this.mStepTransLeft.getReportInfo(22);
      if (QLog.isColorLevel())
      {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> stepParam: " + (String)localObject1);
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> openUpSetpParam: " + (String)localObject2);
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mStepUrl: " + this.mStepUrl.toString() + ";mStepTrans: " + this.mStepTrans.toString() + ";mStepMsg: " + this.mStepMsg.toString() + ";mStepTransPre: " + this.mStepTransPre.toString() + ";mStepTransLeft: " + this.mStepTransLeft.toString() + ";");
      }
      String str;
      if (!paramBoolean)
      {
        str = (String)this.mReportInfo.get("param_reason");
        if (!"connError_unreachable".equalsIgnoreCase(str)) {
          break label517;
        }
      }
      label517:
      do
      {
        this.mReportInfo.put("param_reason", "N_1");
        while (this.mUiRequest.mBusiType == 1030)
        {
          return;
          if ("connError_noroute".equalsIgnoreCase(str)) {
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
        Log.i("AutoMonitor", "SendC2CPic, cost=" + (this.mStepTrans.finishTime - this.mStepTrans.startTime) / 1000000L);
        this.mReportInfo.put("param_step", localObject1);
        this.mReportInfo.put("param_openUpStep", localObject2);
        localObject2 = this.mReportInfo;
        if (this.mResid != null) {
          break label1069;
        }
        localObject1 = this.mUuid;
        label725:
        ((HashMap)localObject2).put("param_uuid", localObject1);
        this.mReportInfo.put("param_toUin", this.mUiRequest.mPeerUin);
        this.mReportInfo.put("param_picmd5", this.mFileName);
        this.mReportInfo.put("param_isPresend", this.mUiRequest.mIsPresend + "");
        this.mReportInfo.put("param_isSecondTrans", this.mIsPicSecondTransfered + "");
        this.mReportInfo.put("param_PhoneType", aklj.a() + "");
        this.mReportInfo.put("param_NetType", NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
        this.mReportInfo.put("param_IsRawPic", this.mIsRawPic + "");
        this.mReportInfo.put("param_quickHttp", String.valueOf(this.mSendByQuickHttp));
        this.mReportInfo.put("param_picType", String.valueOf(this.mPicType));
        this.mReportInfo.put("param_busi", String.valueOf(this.mUiRequest.mBusiType));
        this.mReportInfo.put("param_openUp", String.valueOf(this.mIsOpenUpEnable));
        localObject1 = this.mReportInfo;
        if (!this.mUiRequest.isQzonePic) {
          break label1078;
        }
      }
      label1069:
      label1078:
      for (int i = 1;; i = 0)
      {
        ((HashMap)localObject1).put("param_source_type", String.valueOf(i));
        checkFailCodeReport(paramBoolean);
        doRealReport(paramBoolean, l2, l1);
        return;
        i = 1;
        break;
        localObject1 = this.mResid;
        break label725;
      }
    }
  }
  
  protected void doStart()
  {
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
    if (this.mIsOpenUpEnable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mIsOpenUpEnable: " + this.mIsOpenUpEnable);
      }
      this.mOpenUpTicket = makeOpenUpTicket();
      this.mLoginSigHead = makeLoginSigHead();
      this.mExtendInfo = makeExtendInfo();
      if ((this.mOpenUpTicket != null) && (this.mLoginSigHead != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.mOpenUpTicket + " mLoginSigHead:" + this.mLoginSigHead);
        }
        sendRequest();
        sendFileBDH();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> set mIsOpenUpEnable false");
      }
      this.mIsOpenUpEnable = false;
      sendRequest();
      return;
    }
    sendRequest();
  }
  
  File getFile(String paramString)
  {
    return new File(paramString);
  }
  
  protected String getReportTAG()
  {
    if (this.mChannelStatus == 1) {
      return "actC2CPicUploadV2";
    }
    return "actC2CPicUploadV1";
  }
  
  void internal_retry()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((this.mResid != null) || (this.mUuid != null))
    {
      if (this.mTransferedSize >= this.mFileSize)
      {
        sendMsg();
        return;
      }
      sendFileNotBlockCallThread();
      return;
    }
    start();
  }
  
  protected byte[] makeExtendInfo()
  {
    int j = 6;
    int k = 3;
    CSDataHighwayHead.PicInfoExt localPicInfoExt = new CSDataHighwayHead.PicInfoExt();
    localPicInfoExt.uint32_busi_type.set(1);
    localPicInfoExt.uint32_src_term.set(5);
    localPicInfoExt.uint32_plat_type.set(9);
    int i = j;
    switch (NetworkCenter.getInstance().getNetType())
    {
    default: 
      i = j;
    case 2: 
      Object localObject = NetworkCenter.getInstance().getApnType();
      j = i;
      if (localObject != null)
      {
        j = i;
        if (((String)localObject).contains("wap")) {
          j = 5;
        }
      }
      localPicInfoExt.uint32_net_type.set(j);
      localObject = this.mUiRequest.mRec;
      if (MessageForPic.class.isInstance(localObject)) {
        localPicInfoExt.uint32_img_type.set(((MessageForPic)localObject).imageType);
      }
      localPicInfoExt.uint32_app_pic_type.set(1);
      localPicInfoExt.uint32_pic_width.set(this.mWidth);
      localPicInfoExt.uint32_pic_height.set(this.mHeight);
      if (!this.mIsRawPic) {
        break;
      }
    }
    for (i = k;; i = 1)
    {
      localPicInfoExt.uint32_pic_flag.set(i);
      return localPicInfoExt.toByteArray();
      i = 3;
      break;
      i = 7;
      break;
      i = 8;
      break;
    }
  }
  
  protected CSDataHighwayHead.LoginSigHead makeLoginSigHead()
  {
    CSDataHighwayHead.LoginSigHead localLoginSigHead = new CSDataHighwayHead.LoginSigHead();
    Object localObject1 = (TicketManager)this.app.getManager(2);
    if ((localObject1 != null) && (!TextUtils.isEmpty(this.app.getAccount())))
    {
      localObject1 = ((TicketManager)localObject1).getA2(this.app.getAccount());
      if (localObject1 == null) {
        break label103;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).getBytes("utf-8");
        if ((localObject1 == null) || (localObject1.length == 0)) {
          return null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return null;
      }
      localLoginSigHead.bytes_loginsig.set(ByteStringMicro.copyFrom(localUnsupportedEncodingException));
      localLoginSigHead.uint32_loginsig_type.set(8);
      return localLoginSigHead;
      label103:
      Object localObject2 = null;
    }
  }
  
  protected byte[] makeOpenUpTicket()
  {
    this.mSessionKey = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey();
    if ((this.mSessionKey == null) || (this.mSessionKey.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> sessionKey is null ");
      }
    }
    byte[] arrayOfByte;
    do
    {
      long l1;
      long l2;
      int i;
      int j;
      for (;;)
      {
        return null;
        this.mSigSession = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session();
        if ((this.mSigSession == null) || (this.mSigSession.length == 0))
        {
          if (QLog.isColorLevel())
          {
            QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> signature is null ");
            return null;
          }
        }
        else {
          try
          {
            l1 = Long.valueOf(this.mUiRequest.mSelfUin).longValue();
            localObject2 = this.mUiRequest.mPeerUin;
            Object localObject1 = localObject2;
            if (((String)localObject2).startsWith("+")) {
              localObject1 = ((String)localObject2).substring(1);
            }
            l2 = Long.valueOf((String)localObject1).longValue();
            i = (int)this.mFileSize;
            j = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = this.mLocalMd5;
            if ((localObject1 == null) || (localObject1.length == 0))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("C2CPicUploadProcessor", 2, "md5 is null ");
              return null;
            }
          }
          catch (Exception localException)
          {
            QLog.e("C2CPicUploadProcessor", 2, "makeOpenUpTicket error", localException);
            return null;
          }
        }
      }
      localObject2 = ByteBuffer.allocate(localException.length + 56 + 8);
      ((ByteBuffer)localObject2).putInt(0, 1).putLong(4, l1).putLong(12, l2).putInt(20, i).putInt(24, j);
      localObject2 = ((ByteBuffer)localObject2).array();
      System.arraycopy(localException, 0, localObject2, 28, localException.length);
      arrayOfByte = new Cryptor().encrypt((byte[])localObject2, this.mSessionKey);
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CPicUploadProcessor", 2, "ukey is null ");
    return null;
    Object localObject2 = new CSDataHighwayHead.NewServiceTicket();
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_ukey.set(ByteStringMicro.copyFrom(arrayOfByte));
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_signature.set(ByteStringMicro.copyFrom(this.mSigSession));
    return ((CSDataHighwayHead.NewServiceTicket)localObject2).toByteArray();
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    super.onBusiProtoResp(paramRichProtoReq, paramRichProtoResp);
    onC2CBusiProtoResp(paramRichProtoReq, paramRichProtoResp);
  }
  
  protected void onC2CBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    FileMsg localFileMsg;
    String str;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result != 0) {
          break label430;
        }
        reportQuickSend(paramRichProtoReq.isExist);
        if (paramRichProtoReq.isExist)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp picUpResp.isExist.");
          }
          this.mIsPicSecondTransfered = true;
          this.file.transferedSize = this.file.fileSize;
          localFileMsg = this.file;
          str = paramRichProtoReq.mResid;
          localFileMsg.serverPath = str;
          this.mResid = str;
          localFileMsg = this.file;
          paramRichProtoReq = paramRichProtoReq.mUuid;
          localFileMsg.uuidPath = paramRichProtoReq;
          this.mUuid = paramRichProtoReq;
          if (this.mIsOpenUpEnable) {
            if ((!this.mTrans.isFinish.get()) || (!this.mTrans.isSuccess.get()))
            {
              this.mTrans.cancelTransaction();
              sendMsg();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            sendMsg();
          }
        }
        sendMessageToUpdate(1002);
        if (checkContinueSend()) {
          break label248;
        }
      }
    }
    label248:
    do
    {
      do
      {
        return;
      } while ((this.mIsOpenUpEnable) && (this.mTrans.isFinish.get()) && (this.mTrans.isSuccess.get()));
      if (!this.mIsOpenUpEnable)
      {
        localFileMsg = this.file;
        str = paramRichProtoReq.mResid;
        localFileMsg.serverPath = str;
        this.mResid = str;
        localFileMsg = this.file;
        str = paramRichProtoReq.mUuid;
        localFileMsg.uuidPath = str;
        this.mUuid = str;
      }
      for (;;)
      {
        this.mUkey = paramRichProtoReq.mUkey;
        this.mStartOffset = paramRichProtoReq.startOffset;
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
        }
        this.mChannelStatus = 1;
        if (!this.mIsOpenUpEnable) {
          break label423;
        }
        if (this.mTrans == null) {
          break;
        }
        this.mTrans.continueTrans();
        this.mStepTransLeft.logStartTime();
        break;
        this.mStepTrans.startTime = 0L;
        this.mStepTrans.logStartTime();
      }
      sendFileBDH();
      break;
      log("<BDH_LOG> onBusiProtoResp() error : " + paramRichProtoReq.result + " ,select HTTP channel");
      this.mChannelStatus = 2;
    } while ((this.mIsOpenUpEnable) && (this.mTrans.isFinish.get()) && (this.mTrans.isSuccess.get()));
    label423:
    label430:
    if ((this.mIsOpenUpEnable) && (this.mTrans != null)) {
      this.app.getHwEngine().cancelTransactionTask(this.mTrans);
    }
    onError();
  }
  
  void onError()
  {
    super.onError();
    if (this.errCode != 9333) {
      sendMessageToUpdate(1005);
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      azlb localazlb = new azlb();
      localazlb.jdField_a_of_type_Int = -1;
      localazlb.b = this.errCode;
      localazlb.jdField_a_of_type_JavaLangString = this.errDesc;
      this.mUiRequest.mUpCallBack.onSend(localazlb);
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    String str;
    if (this.mUiRequest.mUpCallBack != null)
    {
      azlb localazlb = new azlb();
      localazlb.jdField_a_of_type_Int = 0;
      localazlb.jdField_a_of_type_Long = this.mFileSize;
      localazlb.d = this.mMd5Str;
      if (this.mResid == null)
      {
        str = this.mUuid;
        localazlb.c = str;
        if (this.mUiRequest.isShareImageByServer) {
          localazlb.jdField_a_of_type_JavaLangObject = getImageInfo();
        }
        this.mUiRequest.mUpCallBack.onSend(localazlb);
      }
    }
    for (;;)
    {
      sendMessageToUpdate(1003);
      if (this.mRichProtoReq != null)
      {
        RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
        this.mRichProtoReq = null;
      }
      return;
      str = this.mResid;
      break;
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
      this.mServerRollbackCount = 0;
      this.mTryCount = 0;
      if (this.mChannelStatus != 1)
      {
        this.mResid = null;
        this.mUuid = null;
        this.mTransferedSize = 0L;
      }
      this.mUkey = null;
      this.mReqUrlCount = 0;
      this.errCode = 0;
      this.errDesc = "";
      this.sscmObject.a();
      resetStatictisInfo();
      this.mController.mHandler.post(new C2CPicUploadProcessor.5(this));
    }
    return 0;
  }
  
  public void sendFileBDH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.mTrans + "  this:" + this);
    }
    if (this.mIsOpenUpEnable) {
      this.mStepTransPre.logStartTime();
    }
    while (this.mTrans != null)
    {
      return;
      this.mStepTrans.logStartTime();
    }
    Object localObject = HexUtil.hexStr2Bytes(this.mUkey);
    C2CPicUploadProcessor.3 local3 = new C2CPicUploadProcessor.3(this, SystemClock.uptimeMillis());
    if (this.mIsOpenUpEnable) {}
    for (this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 4, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mOpenUpTicket, this.mLocalMd5, local3, this.mPreSendDots, this.mExtendInfo, this.mLoginSigHead);; this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 1, this.mUiRequest.mLocalPath, (int)this.mStartOffset, (byte[])localObject, this.mLocalMd5, local3))
    {
      localObject = new C2CPicUploadProcessor.4(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
      int i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 1);
      }
      if (i == 0) {
        break;
      }
      setError(i, "SubmitError.", "", this.mStepTrans);
      onError();
      return;
    }
  }
  
  protected void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (this.isStoryPhoto) {
      boqd.a(this.picMsg, paramInt, getProgress());
    }
  }
  
  void sendMsg()
  {
    if (!canDoNextStep())
    {
      log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.mChannelStatus);
      return;
    }
    Object localObject1 = this.mUiRequest.mRec;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).DSKey != 0L))
    {
      onSuccess();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if ((!this.needSendMsg) || (this.mUiRequest.mIsPresend))
    {
      if (this.mUiRequest.mIsPresend) {
        ((MessageForPic)this.mUiRequest.mRec).mPresendTransferedSize = this.mTransferedSize;
      }
      localObject1 = constructRichText();
      if (localObject1 == null)
      {
        setError(9368, "constructpberror", null, this.mStepMsg);
        onError();
        return;
      }
      if (this.mUiRequest.mUpCallBack != null) {
        this.mUiRequest.mUpCallBack.attachRichText2Msg((im_msg_body.RichText)localObject1);
      }
      if ((this.mUiRequest.mIsPresend) && (this.mIsPicSecondTransfered)) {
        ((MessageForPic)this.mUiRequest.mRec).mPresendTransferedSize = 0L;
      }
      addInfoToMsg();
      onSuccess();
      return;
    }
    this.mStepMsg.logStartTime();
    Object localObject2 = constructRichText();
    if (localObject2 == null)
    {
      setError(9368, "constructpberror", null, this.mStepMsg);
      onError();
      return;
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject1 = this.mUiRequest.mUpCallBack.attachRichText2Msg((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label468;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label441;
      }
    }
    label441:
    for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      setError(9368, "msgtypeError", (String)localObject1, this.mStepMsg);
      onError();
      return;
      if (this.mUiRequest.mRec != null)
      {
        localObject1 = this.mUiRequest.mRec;
        break;
      }
      localObject1 = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      break;
    }
    label468:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.mFileSize;
      if (((MessageForPic)localObject1).isBlessPic)
      {
        ((MessageForPic)localObject1).uuid = this.mResid;
        this.app.getMsgHandler().notifyUI(999, true, ((MessageRecord)localObject1).frienduin);
        return;
      }
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepMsg);
      onError();
      return;
    }
    addInfoToMsg();
    ((bbob)this.app.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a((MessageRecord)localObject1, this.messageObserver, this);
  }
  
  protected void sendRequest()
  {
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPicUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPicUpReq.secondUin = this.mUiRequest.mSecondId;
    localPicUpReq.uinType = this.mUiRequest.mUinType;
    localPicUpReq.fileName = this.mFileName;
    localPicUpReq.fileSize = this.mFileSize;
    localPicUpReq.md5 = this.mLocalMd5;
    localPicUpReq.width = this.mWidth;
    localPicUpReq.height = this.mHeight;
    boolean bool;
    if (this.mUiRequest.mUinType == 1006)
    {
      bool = true;
      localPicUpReq.isContact = bool;
      localPicUpReq.isRaw = this.mIsRawPic;
      localRichProtoReq.callback = this;
      localRichProtoReq.protoKey = "c2c_pic_up";
      localRichProtoReq.reqs.add(localPicUpReq);
      localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
      changeRequest(localPicUpReq);
      MessageRecord localMessageRecord = this.mUiRequest.mRec;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localPicUpReq.picType = ((MessageForPic)localMessageRecord).imageType;
        this.mPicType = ((MessageForPic)localMessageRecord).imageType;
      }
      if (isAppValid()) {
        break label249;
      }
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    label249:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", localRichProtoReq.toString());
      }
    } while (!canDoNextStep());
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public void start()
  {
    super.start();
    doStart();
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
    bdqa localbdqa;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
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
            ((MessageForPic)localObject).size = this.mFileSize;
            if (this.mResid == null) {}
            for (str = this.mUuid;; str = this.mResid)
            {
              ((MessageForPic)localObject).uuid = str;
              ((MessageForPic)localObject).serial();
              this.app.getMessageFacade().updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
              return;
            }
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localbdqa = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localbdqa == null);
    localbdqa.ae = this.mMd5Str;
    if (this.mResid == null) {}
    for (String str = this.mUuid;; str = this.mResid)
    {
      localbdqa.ad = str;
      localbdqa.d = this.mFileSize;
      localbdqa.e = localMessageRecord.time;
      ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
      this.app.getMessageFacade().updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */