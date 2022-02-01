package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
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
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class C2CPicUploadProcessor
  extends BasePicUploadProcessor
{
  public static final String TAG = "C2CPicUploadProcessor";
  private boolean isStoryPhoto = false;
  protected BaseTransFileController mController;
  protected byte[] mExtendInfo;
  protected boolean mIsOpenUpEnable;
  protected CSDataHighwayHead.LoginSigHead mLoginSigHead;
  protected byte[] mOpenUpTicket;
  private int mPreSendDots;
  private byte[] mSessionKey;
  private byte[] mSigSession;
  private StepInfo mStepTransLeft = new StepInfo();
  private StepInfo mStepTransPre = new StepInfo();
  MediaMessageObserver messageObserver = new C2CPicUploadProcessor.6(this);
  private MessageForPic picMsg;
  
  public C2CPicUploadProcessor() {}
  
  public C2CPicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.mController = paramBaseTransFileController;
    this.file.fileType = this.mUiRequest.mFileType;
    this.file.uniseq = this.mUiRequest.mUniseq;
    this.file.actionType = 0;
    this.file.friendUin = this.mUiRequest.mPeerUin;
    this.file.uinType = 0;
    this.file.processorDoReportSelf = true;
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
    for (;;)
    {
      Object localObject1;
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        Object localObject3 = new im_msg_body.NotOnlineImage();
        changeRichText();
        ((im_msg_body.NotOnlineImage)localObject3).file_path.set(ByteStringMicro.copyFromUtf8(this.mFileName));
        if (this.file.uuidPath != null) {
          ((im_msg_body.NotOnlineImage)localObject3).download_path.set(ByteStringMicro.copyFromUtf8(this.file.uuidPath));
        }
        if (this.file.serverPath != null) {
          ((im_msg_body.NotOnlineImage)localObject3).res_id.set(ByteStringMicro.copyFromUtf8(this.file.serverPath));
        }
        ((im_msg_body.NotOnlineImage)localObject3).file_len.set((int)this.mFileSize);
        ((im_msg_body.NotOnlineImage)localObject3).pic_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
        ((im_msg_body.NotOnlineImage)localObject3).pic_height.set(this.mHeight);
        ((im_msg_body.NotOnlineImage)localObject3).pic_width.set(this.mWidth);
        localObject1 = ((im_msg_body.NotOnlineImage)localObject3).original;
        if (!this.mIsRawPic) {
          break label823;
        }
        i = 1;
        ((PBUInt32Field)localObject1).set(i);
        Object localObject4 = this.mUiRequest.mRec;
        if (MessageForPic.class.isInstance(localObject4))
        {
          MessageForPic localMessageForPic = (MessageForPic)localObject4;
          ((im_msg_body.NotOnlineImage)localObject3).uint32_show_len.set(localMessageForPic.mShowLength);
          ((im_msg_body.NotOnlineImage)localObject3).uint32_download_len.set(localMessageForPic.mDownloadLength);
          ((im_msg_body.NotOnlineImage)localObject3).img_type.set(localMessageForPic.imageType);
          localObject1 = localMessageForPic.picExtraData;
          if (localObject1 != null)
          {
            localObject2 = localMessageForPic.picExtraData.getOfflineImageResvAttr();
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("imageBizType: ");
              ((StringBuilder)localObject1).append(localMessageForPic.picExtraData.imageBizType);
              QLog.d("picExtra", 4, ((StringBuilder)localObject1).toString());
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject2 = new NotOnlineImageExtPb.ResvAttr();
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("picExtra", 4, "imageBizType: 0");
              localObject1 = localObject2;
            }
          }
          i = getPicSourceReport(localMessageForPic, this.mUiRequest.mPicSendSource);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("source: ");
            ((StringBuilder)localObject2).append(i);
            QLog.d("picExtra", 4, ((StringBuilder)localObject2).toString());
          }
          ((NotOnlineImageExtPb.ResvAttr)localObject1).uint32_source.set(i);
          ((im_msg_body.NotOnlineImage)localObject3).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
        }
        ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(getReportBizType());
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("uiBusiType:");
          ((StringBuilder)localObject1).append(this.mUiRequest.mBusiType);
          ((StringBuilder)localObject1).append(" protoBusiType:");
          ((StringBuilder)localObject1).append(((im_msg_body.NotOnlineImage)localObject3).biz_type.get());
          logRichMediaEvent("busiTypeStat", ((StringBuilder)localObject1).toString());
        }
        localObject1 = new im_msg_body.Elem();
        if (FlashPicHelper.a((MessageRecord)localObject4))
        {
          localObject2 = new im_msg_body.CommonElem();
          ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(3);
          localObject4 = new hummer_commelem.MsgElemInfo_servtype3();
          ((hummer_commelem.MsgElemInfo_servtype3)localObject4).flash_c2c_pic.set((MessageMicro)localObject3);
          ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject4).toByteArray()));
          ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject2);
          localRichText.elems.add((MessageMicro)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "C2CPicUploadProcessor constructPicRichText send flash");
          }
          localObject1 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.a(2131701512)));
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject2);
        }
        else
        {
          ((im_msg_body.Elem)localObject1).not_online_image.set((MessageMicro)localObject3);
          localRichText.elems.add((MessageMicro)localObject1);
        }
        Object localObject2 = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
        localObject1 = localRichText;
        if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing((MessageRecord)localObject2))
        {
          localObject3 = (IMsgStructing)QRoute.api(IMsgStructing.class);
          localObject4 = this.mMd5Str;
          if (this.mResid == null) {
            localObject1 = this.mUuid;
          } else {
            localObject1 = this.mResid;
          }
          ((IMsgStructing)localObject3).uploadPicConstructRichText((MessageRecord)localObject2, (String)localObject4, (String)localObject1, this.mFileSize, null, localRichText);
          return localRichText;
        }
      }
      catch (Exception localException)
      {
        localObject1 = null;
        if (QLog.isColorLevel()) {
          QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
      }
      return localObject1;
      label823:
      int i = 0;
    }
  }
  
  private void parseExtInfo(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      Object localObject1 = new CSDataHighwayHead.PicRspExtInfo();
      try
      {
        ((CSDataHighwayHead.PicRspExtInfo)localObject1).mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, paramArrayOfByte.getMessage());
        }
      }
      if (!((CSDataHighwayHead.PicRspExtInfo)localObject1).bytes_skey.has()) {
        return;
      }
      paramArrayOfByte = ((CSDataHighwayHead.PicRspExtInfo)localObject1).bytes_skey.get().toByteArray();
      localObject1 = new byte[paramArrayOfByte.length];
      int j = paramArrayOfByte.length;
      int i = 0;
      System.arraycopy(paramArrayOfByte, 0, localObject1, 0, j);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("<BDH_LOG> byte_skey.length:");
        ((StringBuilder)localObject2).append(paramArrayOfByte.length);
        QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new Cryptor();
      byte[] arrayOfByte = this.mSessionKey;
      if (arrayOfByte != null)
      {
        paramArrayOfByte = ((Cryptor)localObject2).decrypt((byte[])localObject1, 0, paramArrayOfByte.length, arrayOfByte);
        if (paramArrayOfByte != null)
        {
          if (paramArrayOfByte.length <= 36) {
            return;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("<BDH_LOG> result.length:");
            ((StringBuilder)localObject1).append(paramArrayOfByte.length);
            QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = new byte[paramArrayOfByte.length];
          System.arraycopy(paramArrayOfByte, 0, localObject1, 0, paramArrayOfByte.length);
          j = ByteBuffer.wrap((byte[])localObject1).getShort(34);
          paramArrayOfByte = new char[j];
          while (i < j)
          {
            paramArrayOfByte[i] = ((char)localObject1[(i + 36)]);
            i += 1;
          }
          paramArrayOfByte = String.valueOf(paramArrayOfByte);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("<BDH_LOG> fileIdStr:");
            ((StringBuilder)localObject1).append(paramArrayOfByte);
            QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject1).toString());
          }
          this.file.serverPath = paramArrayOfByte;
          this.mResid = paramArrayOfByte;
          this.file.uuidPath = paramArrayOfByte;
          this.mUuid = paramArrayOfByte;
        }
      }
    }
  }
  
  private void resetStatictisInfo()
  {
    this.file.stepSig.reset();
    this.file.stepUrl.reset();
    this.file.stepTrans.reset();
    this.file.stepNotify.reset();
    ProcessorReport localProcessorReport = this.mProcessorReport;
    FileMsg localFileMsg = this.file;
    long l = System.nanoTime();
    localFileMsg.startTime = l;
    localProcessorReport.mStartTime = l;
    this.file.endTime = 0L;
  }
  
  private void sendFileNotBlockCallThread()
  {
    this.mController.mHandler.post(new C2CPicUploadProcessor.2(this));
  }
  
  public int checkParam()
  {
    Object localObject1 = getTransferRequest();
    if ((localObject1 != null) && (((TransferRequest)localObject1).mIsFastForward))
    {
      if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
        this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
      }
      return 0;
    }
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    localObject1 = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("filePath null")), null, null);
      onError();
      return -1;
    }
    Object localObject2 = getFile((String)localObject1);
    StringBuilder localStringBuilder;
    if (!((File)localObject2).exists())
    {
      localObject2 = this.mProcessorReport;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendFile not exist ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(9042, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
      onError();
      return -1;
    }
    if (!((File)localObject2).canRead())
    {
      localObject1 = this.mProcessorReport;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendFile not readable ");
      ((StringBuilder)localObject2).append(this.file.filePath);
      ((ProcessorReport)localObject1).setError(9070, getExpStackString(new Exception(((StringBuilder)localObject2).toString())), null, null);
      onError();
      return -1;
    }
    long l = ((File)localObject2).length();
    this.file.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      localObject2 = this.mProcessorReport;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("file size 0 ");
      localStringBuilder.append((String)localObject1);
      ((ProcessorReport)localObject2).setError(9071, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
      onError();
      return -1;
    }
    localObject1 = FileUtils.estimateFileType((String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      if ((!((String)localObject1).contains(FileUtils.unKnownFileTypeMark)) && (FileUtils.isPicFileByExt((String)localObject1)))
      {
        this.mExtName = ((String)localObject1);
      }
      else
      {
        localObject2 = this.mProcessorReport;
        setError(9072, (String)localObject1, ProcessorReport.getClientReason((String)localObject1), null);
        onError();
        new Handler(Looper.getMainLooper()).post(new C2CPicUploadProcessor.1(this));
        return -1;
      }
    }
    if (l >= ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit())
    {
      localObject2 = this.mProcessorReport;
      setError(9063, (String)localObject1, ProcessorReport.getClientReason((String)localObject1), null);
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
        long l;
        if (this.mEnterAioTime != 0L) {
          l = (paramLong2 - this.mEnterAioTime) / 1000000L;
        } else {
          l = 0L;
        }
        if (this.mUiRequest.myPresendInvalid) {
          l = paramLong1;
        }
        double d1 = l;
        double d2 = paramLong1;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        reportActPSdoneAioDuration(l, this.mFileSize, this.mIsPicSecondTransfered, d1);
        if ((d1 >= 0.0D) && (d1 <= 1.0D))
        {
          localObject1 = this.mProcessorReport.mReportInfo;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(d1);
          ((StringBuilder)localObject2).append("");
          ((HashMap)localObject1).put("param_AIOPercent", ((StringBuilder)localObject2).toString());
        }
        localObject1 = this.mProcessorReport.mReportInfo;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("");
        ((HashMap)localObject1).put("param_AIODuration", ((StringBuilder)localObject2).toString());
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("doReport ,mStartTime = ");
          ((StringBuilder)localObject1).append(this.mProcessorReport.mStartTime);
          ((StringBuilder)localObject1).append(",mEnterAioTime = ");
          ((StringBuilder)localObject1).append(this.mEnterAioTime);
          ((StringBuilder)localObject1).append(",finishTime  = ");
          ((StringBuilder)localObject1).append(paramLong2);
          ((StringBuilder)localObject1).append(", aioDuration = ");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append(", duration = ");
          ((StringBuilder)localObject1).append(paramLong1);
          ((StringBuilder)localObject1).append("processor:");
          ((StringBuilder)localObject1).append(this);
          ((StringBuilder)localObject1).append(",mUiRequest.myPresendInvalid = ");
          ((StringBuilder)localObject1).append(this.mUiRequest.myPresendInvalid);
          ((StringBuilder)localObject1).append(",Percent = ");
          ((StringBuilder)localObject1).append(d1);
          QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject1).toString());
        }
      }
      this.mProcessorReport.reportForIpv6(true, paramLong1, true, getReportTAG());
      Object localObject1 = new HashMap();
      Object localObject2 = this.mProcessorReport.mReportInfo.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(localEntry.getKey(), localEntry.getValue());
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, paramLong1, this.mFileSize, (HashMap)localObject1, "");
    }
    else
    {
      if (this.mProcessorReport.errCode != -9527) {
        this.mProcessorReport.mReportInfo.remove("param_rspHeader");
      }
      this.mProcessorReport.mReportInfo.remove("param_url");
      this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
      this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
      this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mProcessorReport.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
      this.mProcessorReport.mReportInfo.put("param_uniseq", String.valueOf(this.mUiRequest.mUniseq));
      this.mProcessorReport.reportForIpv6(false, paramLong1, true, getReportTAG());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, paramLong1, this.mFileSize, this.mProcessorReport.mReportInfo, "");
    }
    setReportFlag();
    super.doReport(paramBoolean);
  }
  
  protected void doReport(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void doStart()
  {
    sendMessageToUpdate(1000);
    this.file.closeInputStream();
    sendMessageToUpdate(1001);
    Object localObject = getTransferRequest();
    if ((localObject != null) && (((TransferRequest)localObject).mIsFastForward))
    {
      this.mWidth = ((TransferRequest)localObject).mFastForwardWidth;
      this.mHeight = ((TransferRequest)localObject).mFastForwardHeight;
      this.mFileSize = ((TransferRequest)localObject).mFastForwardFileSize;
      this.mLocalMd5 = HexUtil.hexStr2Bytes(((TransferRequest)localObject).mMd5);
      this.mFileName = ((TransferRequest)localObject).mMd5;
      this.mMd5Str = this.mFileName;
      this.file.fileMd5 = this.mFileName;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mFileName);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(this.mExtName);
      this.mFileName = ((StringBuilder)localObject).toString();
      this.app.getHwEngine().preConnect();
      sendRequest();
      return;
    }
    if (!checkFileStandard(true)) {
      return;
    }
    this.app.getHwEngine().preConnect();
    if (this.mIsOpenUpEnable)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<BDH_LOG> mIsOpenUpEnable: ");
        ((StringBuilder)localObject).append(this.mIsOpenUpEnable);
        QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
      }
      this.mOpenUpTicket = makeOpenUpTicket();
      this.mLoginSigHead = makeLoginSigHead();
      this.mExtendInfo = makeExtendInfo();
      if ((this.mOpenUpTicket != null) && (this.mLoginSigHead != null))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("<BDH_LOG> mOpenUpTicket: ");
          ((StringBuilder)localObject).append(this.mOpenUpTicket);
          ((StringBuilder)localObject).append(" mLoginSigHead:");
          ((StringBuilder)localObject).append(this.mLoginSigHead);
          QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
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
    if ((this.mResid == null) && (this.mUuid == null))
    {
      start();
      return;
    }
    if (this.mTransferedSize >= this.mFileSize)
    {
      sendMsg();
      return;
    }
    sendFileNotBlockCallThread();
  }
  
  protected byte[] makeExtendInfo()
  {
    CSDataHighwayHead.PicInfoExt localPicInfoExt = new CSDataHighwayHead.PicInfoExt();
    Object localObject = localPicInfoExt.uint32_busi_type;
    int k = 1;
    ((PBUInt32Field)localObject).set(1);
    localPicInfoExt.uint32_src_term.set(5);
    localPicInfoExt.uint32_plat_type.set(9);
    int i = NetworkCenter.getInstance().getNetType();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label82;
        }
        if (i == 4) {}
      }
      else
      {
        i = 6;
        break label90;
      }
      i = 8;
      break label90;
      label82:
      i = 7;
    }
    else
    {
      i = 3;
    }
    label90:
    localObject = NetworkCenter.getInstance().getApnType();
    int j = i;
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
    i = k;
    if (this.mIsRawPic) {
      i = 3;
    }
    localPicInfoExt.uint32_pic_flag.set(i);
    return localPicInfoExt.toByteArray();
  }
  
  protected CSDataHighwayHead.LoginSigHead makeLoginSigHead()
  {
    CSDataHighwayHead.LoginSigHead localLoginSigHead = new CSDataHighwayHead.LoginSigHead();
    Object localObject = (TicketManager)this.app.getManager(2);
    if ((localObject != null) && (!TextUtils.isEmpty(this.app.getAccount())))
    {
      localObject = ((TicketManager)localObject).getA2(this.app.getAccount());
      byte[] arrayOfByte;
      if (localObject != null) {
        try
        {
          localObject = ((String)localObject).getBytes("utf-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
          return null;
        }
      } else {
        arrayOfByte = null;
      }
      if (arrayOfByte != null)
      {
        if (arrayOfByte.length == 0) {
          return null;
        }
        localLoginSigHead.bytes_loginsig.set(ByteStringMicro.copyFrom(arrayOfByte));
        localLoginSigHead.uint32_loginsig_type.set(8);
        return localLoginSigHead;
      }
    }
    return null;
  }
  
  protected byte[] makeOpenUpTicket()
  {
    this.mSessionKey = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey();
    Object localObject1 = this.mSessionKey;
    if ((localObject1 != null) && (localObject1.length != 0))
    {
      this.mSigSession = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session();
      localObject1 = this.mSigSession;
      if ((localObject1 != null) && (localObject1.length != 0)) {
        try
        {
          long l1 = Long.valueOf(this.mUiRequest.mSelfUin).longValue();
          Object localObject2 = this.mUiRequest.mPeerUin;
          localObject1 = localObject2;
          if (((String)localObject2).startsWith("+")) {
            localObject1 = ((String)localObject2).substring(1);
          }
          long l2 = Long.valueOf((String)localObject1).longValue();
          int i = (int)this.mFileSize;
          int j = (int)(System.currentTimeMillis() / 1000L);
          localObject1 = this.mLocalMd5;
          if ((localObject1 != null) && (localObject1.length != 0))
          {
            localObject2 = ByteBuffer.allocate(localObject1.length + 56 + 8);
            ((ByteBuffer)localObject2).putInt(0, 1).putLong(4, l1).putLong(12, l2).putInt(20, i).putInt(24, j);
            localObject2 = ((ByteBuffer)localObject2).array();
            System.arraycopy(localObject1, 0, localObject2, 28, localObject1.length);
            localObject1 = new Cryptor().encrypt((byte[])localObject2, this.mSessionKey);
            if ((localObject1 != null) && (localObject1.length != 0))
            {
              localObject2 = new CSDataHighwayHead.NewServiceTicket();
              ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_ukey.set(ByteStringMicro.copyFrom((byte[])localObject1));
              ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_signature.set(ByteStringMicro.copyFrom(this.mSigSession));
              return ((CSDataHighwayHead.NewServiceTicket)localObject2).toByteArray();
            }
            if (QLog.isColorLevel()) {
              QLog.e("C2CPicUploadProcessor", 2, "ukey is null ");
            }
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.e("C2CPicUploadProcessor", 2, "md5 is null ");
          }
          return null;
        }
        catch (Exception localException)
        {
          QLog.e("C2CPicUploadProcessor", 2, "makeOpenUpTicket error", localException);
          return null;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> signature is null ");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> sessionKey is null ");
    }
    return null;
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    super.onBusiProtoResp(paramRichProtoReq, paramRichProtoResp);
    onC2CBusiProtoResp(paramRichProtoReq, paramRichProtoResp);
  }
  
  protected void onC2CBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          reportQuickSend(paramRichProtoReq.isExist);
          FileMsg localFileMsg;
          String str;
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
            if (this.mIsOpenUpEnable)
            {
              if ((!this.mTrans.isFinish.get()) || (!this.mTrans.isSuccess.get()))
              {
                this.mTrans.cancelTransaction();
                sendMsg();
              }
            }
            else {
              sendMsg();
            }
          }
          else
          {
            sendMessageToUpdate(1002);
            if (!checkContinueSend()) {
              return;
            }
            if ((this.mIsOpenUpEnable) && (this.mTrans.isFinish.get()) && (this.mTrans.isSuccess.get())) {
              return;
            }
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
            else
            {
              this.mProcessorReport.mStepTrans.startTime = 0L;
              this.mProcessorReport.mStepTrans.logStartTime();
            }
            this.mUkey = paramRichProtoReq.mUkey;
            this.mStartOffset = paramRichProtoReq.startOffset;
            if (QLog.isColorLevel()) {
              QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
            }
            this.mChannelStatus = 1;
            if (this.mIsOpenUpEnable)
            {
              if (this.mTrans != null)
              {
                this.mTrans.continueTrans();
                this.mStepTransLeft.logStartTime();
              }
            }
            else {
              sendFileBDH();
            }
          }
          i += 1;
        }
        else
        {
          paramRichProtoResp = new StringBuilder();
          paramRichProtoResp.append("<BDH_LOG> onBusiProtoResp() error : ");
          paramRichProtoResp.append(paramRichProtoReq.result);
          paramRichProtoResp.append(" ,select HTTP channel");
          log(paramRichProtoResp.toString());
          this.mChannelStatus = 2;
          if ((!this.mIsOpenUpEnable) || (!this.mTrans.isFinish.get()) || (!this.mTrans.isSuccess.get()))
          {
            if ((this.mIsOpenUpEnable) && (this.mTrans != null)) {
              this.app.getHwEngine().cancelTransactionTask(this.mTrans);
            }
            onError();
          }
        }
      }
    }
  }
  
  void onError()
  {
    super.onError();
    if (this.mProcessorReport.errCode != 9333) {
      sendMessageToUpdate(1005);
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.b = this.mProcessorReport.errCode;
      localSendResult.jdField_a_of_type_JavaLangString = this.mProcessorReport.errDesc;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.mFileSize;
      localSendResult.d = this.mMd5Str;
      String str;
      if (this.mResid == null) {
        str = this.mUuid;
      } else {
        str = this.mResid;
      }
      localSendResult.c = str;
      if (this.mUiRequest.isShareImageByServer) {
        localSendResult.jdField_a_of_type_JavaLangObject = getImageInfo();
      }
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    else
    {
      updateMessageDataBaseContent(true);
    }
    sendMessageToUpdate(1003);
    if (this.mRichProtoReq != null)
    {
      RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
      this.mRichProtoReq = null;
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
      int i = this.mChannelStatus;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          log("<BDH_LOG> pause() pause HTTP channel");
          if (this.mNetReq != null)
          {
            this.mNetEngine.cancelReq(this.mNetReq);
            this.mNetReq = null;
          }
        }
        else
        {
          if (this.mTrans != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("<BDH_LOG> pause() pause BDH channel, transation id=");
            localStringBuilder.append(this.mTrans.getTransationId());
            log(localStringBuilder.toString());
            this.app.getHwEngine().stopTransactionTask(this.mTrans);
            return;
          }
          log("<BDH_LOG> pause() pause BDH channel, but trans == null");
        }
      }
      else {
        log("<BDH_LOG> pause() BUT current status is INIT");
      }
    }
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
      this.mProcessorReport.errCode = 0;
      this.mProcessorReport.errDesc = "";
      this.sscmObject.a();
      resetStatictisInfo();
      this.mController.mHandler.post(new C2CPicUploadProcessor.5(this));
    }
    return 0;
  }
  
  public void sendFileBDH()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> Transaction submit:sendFile:");
      ((StringBuilder)localObject).append(this.mTrans);
      ((StringBuilder)localObject).append("  this:");
      ((StringBuilder)localObject).append(this);
      QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mIsOpenUpEnable) {
      this.mStepTransPre.logStartTime();
    } else {
      this.mProcessorReport.mStepTrans.logStartTime();
    }
    if (this.mTrans != null) {
      return;
    }
    Object localObject = HexUtil.hexStr2Bytes(this.mUkey);
    C2CPicUploadProcessor.3 local3 = new C2CPicUploadProcessor.3(this, SystemClock.uptimeMillis());
    if (this.mIsOpenUpEnable) {
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 4, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mOpenUpTicket, this.mLocalMd5, local3, this.mPreSendDots, this.mExtendInfo, this.mLoginSigHead);
    } else {
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 1, this.mUiRequest.mLocalPath, (int)this.mStartOffset, (byte[])localObject, this.mLocalMd5, local3);
    }
    localObject = new C2CPicUploadProcessor.4(this);
    this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
    int i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> Transaction submit RetCode:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" T_ID:");
      ((StringBuilder)localObject).append(this.mTrans.getTransationId());
      ((StringBuilder)localObject).append(" UniSeq:");
      ((StringBuilder)localObject).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject).append(" MD5:");
      ((StringBuilder)localObject).append(this.mMd5Str);
      ((StringBuilder)localObject).append(" uuid:");
      ((StringBuilder)localObject).append(this.mUuid);
      ((StringBuilder)localObject).append(" Path:");
      ((StringBuilder)localObject).append(this.mTrans.filePath);
      ((StringBuilder)localObject).append(" Cmd:");
      ((StringBuilder)localObject).append(1);
      QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 0)
    {
      setError(i, "SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  protected void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (this.isStoryPhoto) {
      ((IPeakIpcController)QRoute.api(IPeakIpcController.class)).updatePeakVideoAndPicStatus(this.picMsg, paramInt, getProgress());
    }
  }
  
  void sendMsg()
  {
    if (!canDoNextStep())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = ");
      ((StringBuilder)localObject1).append(this.mChannelStatus);
      log(((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = this.mUiRequest.mRec;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).DSKey != 0L))
    {
      onSuccess();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TestPicSend finish upload,currentTime = ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(",processor = ");
      ((StringBuilder)localObject1).append(this);
      QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if ((this.needSendMsg) && (!this.mUiRequest.mIsPresend))
    {
      this.mProcessorReport.mStepMsg.logStartTime();
      Object localObject2 = constructRichText();
      if (localObject2 == null)
      {
        setError(9368, "constructpberror", null, this.mProcessorReport.mStepMsg);
        onError();
        return;
      }
      if (this.mUiRequest.mUpCallBack != null) {
        localObject1 = this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject2);
      } else if (this.mUiRequest.mRec != null) {
        localObject1 = this.mUiRequest.mRec;
      } else {
        localObject1 = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      }
      Object localObject3;
      if (localObject1 != null)
      {
        boolean bool = localObject1 instanceof MessageForPic;
        if ((bool) || (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing((MessageRecord)localObject1)))
        {
          if (bool)
          {
            localObject3 = (MessageForPic)localObject1;
            ((MessageForPic)localObject3).richText = ((im_msg_body.RichText)localObject2);
            ((MessageForPic)localObject3).size = this.mFileSize;
            if (((MessageForPic)localObject3).isBlessPic)
            {
              ((MessageForPic)localObject3).uuid = this.mResid;
              ((IMessageHandler)this.app.getRuntimeService(IMessageHandler.class, "")).notifyUI((BaseQQAppInterface)this.app, 999, true, ((MessageRecord)localObject1).frienduin);
              return;
            }
          }
          if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing((MessageRecord)localObject1)) {
            ((MessageForRichText)localObject1).richText = ((im_msg_body.RichText)localObject2);
          }
          if (!isAppValid())
          {
            setError(9366, "illegal app", null, this.mProcessorReport.mStepMsg);
            onError();
            return;
          }
          addInfoToMsg();
          ((IOrderMediaMsgService)this.app.getRuntimeService(IOrderMediaMsgService.class, "")).sendOrderMsg((MessageRecord)localObject1, this.messageObserver, this);
          return;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Mr_");
      if (localObject1 == null)
      {
        localObject1 = "null";
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject1).msgtype);
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      setError(9368, "msgtypeError", ((StringBuilder)localObject2).toString(), this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    if (this.mUiRequest.mIsPresend) {
      ((MessageForPic)this.mUiRequest.mRec).mPresendTransferedSize = this.mTransferedSize;
    }
    localObject1 = constructRichText();
    if (localObject1 == null)
    {
      setError(9368, "constructpberror", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    if (this.mUiRequest.mUpCallBack != null) {
      this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject1);
    }
    if ((this.mUiRequest.mIsPresend) && (this.mIsPicSecondTransfered)) {
      ((MessageForPic)this.mUiRequest.mRec).mPresendTransferedSize = 0L;
    }
    addInfoToMsg();
    onSuccess();
  }
  
  protected void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
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
    if (this.mUiRequest.mUinType == 1006) {
      bool = true;
    } else {
      bool = false;
    }
    localPicUpReq.isContact = bool;
    localPicUpReq.isRaw = this.mIsRawPic;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "c2c_pic_up";
    localRichProtoReq.reqs.add(localPicUpReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    changeRequest(localPicUpReq);
    Object localObject = this.mUiRequest.mRec;
    if (MessageForPic.class.isInstance(localObject))
    {
      localObject = (MessageForPic)localObject;
      localPicUpReq.picType = ((MessageForPic)localObject).imageType;
      this.mPicType = ((MessageForPic)localObject).imageType;
    }
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (QLog.isColorLevel()) {
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    }
    if (!canDoNextStep()) {
      return;
    }
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public void start()
  {
    super.start();
    doStart();
  }
  
  public void updateMessageData(MessageRecord paramMessageRecord)
  {
    Object localObject;
    String str1;
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localObject = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject).size = this.mFileSize;
      if (this.mResid == null) {
        str1 = this.mUuid;
      } else {
        str1 = this.mResid;
      }
      ((MessageForPic)localObject).uuid = str1;
      ((MessageForPic)localObject).serial();
      ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, paramMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
      return;
    }
    if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing(paramMessageRecord))
    {
      localObject = (IMsgStructing)QRoute.api(IMsgStructing.class);
      AppInterface localAppInterface = this.app;
      String str2 = this.mMd5Str;
      if (this.mResid == null) {
        str1 = this.mUuid;
      } else {
        str1 = this.mResid;
      }
      ((IMsgStructing)localObject).updateMsgAfterUpload(localAppInterface, paramMessageRecord, str2, str1, this.mFileSize, null, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */