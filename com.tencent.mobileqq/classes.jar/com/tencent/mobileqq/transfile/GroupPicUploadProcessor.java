package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
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
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class GroupPicUploadProcessor
  extends BasePicUploadProcessor
{
  public static final String TAG = "GroupPicUploadProcessor";
  protected boolean isStoryPhoto = false;
  BaseTransFileController mController;
  long mFileID;
  boolean mHasVirtualStarted = false;
  boolean mIsGroup = true;
  MediaMessageObserver messageObserver = new GroupPicUploadProcessor.5(this);
  protected MessageForPic picMsg;
  protected long startTime = -1L;
  
  public GroupPicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.mController = paramBaseTransFileController;
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForPic)))
    {
      this.isStoryPhoto = ((MessageForPic)this.mUiRequest.mRec).isStoryPhoto;
      if (this.isStoryPhoto) {
        this.picMsg = ((MessageForPic)this.mUiRequest.mRec);
      }
    }
  }
  
  private int getReportSource()
  {
    int i = this.mUiRequest.mBusiType;
    if (i != 1027)
    {
      switch (i)
      {
      default: 
        return 200;
      case 1009: 
        return 104;
      case 1008: 
        return 105;
      case 1007: 
        return 101;
      }
      return 103;
    }
    return 106;
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
    Object localObject1;
    try
    {
      Object localObject4 = this.mUiRequest.mRec;
      localObject1 = getCustomFace((MessageRecord)localObject4);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uiBusiType:");
        ((StringBuilder)localObject2).append(this.mUiRequest.mBusiType);
        ((StringBuilder)localObject2).append(" protoBusiType:");
        ((StringBuilder)localObject2).append(((im_msg_body.CustomFace)localObject1).biz_type.get());
        logRichMediaEvent("busiTypeStat", ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new im_msg_body.RichText();
      Object localObject3 = new im_msg_body.Elem();
      if (FlashPicHelper.a((MessageRecord)localObject4))
      {
        localObject4 = new im_msg_body.CommonElem();
        ((im_msg_body.CommonElem)localObject4).uint32_service_type.set(3);
        hummer_commelem.MsgElemInfo_servtype3 localMsgElemInfo_servtype3 = new hummer_commelem.MsgElemInfo_servtype3();
        localMsgElemInfo_servtype3.flash_troop_pic.set((MessageMicro)localObject1);
        ((im_msg_body.CommonElem)localObject4).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype3.toByteArray()));
        ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject4);
        ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("flash", 2, "GroupPicUploadProcessor constructPicRichText send flash");
        }
        localObject1 = new im_msg_body.Text();
        ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.a(2131899535)));
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).text.set((MessageMicro)localObject1);
        ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject3);
      }
      else
      {
        ((im_msg_body.Elem)localObject3).custom_face.set((MessageMicro)localObject1);
        ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject3);
      }
      localObject3 = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      localObject1 = localObject2;
      if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing((MessageRecord)localObject3))
      {
        ((IMsgStructing)QRoute.api(IMsgStructing.class)).uploadPicConstructRichText((MessageRecord)localObject3, this.mMd5Str, this.mFileName, this.mFileSize, Long.valueOf(this.mFileID), (im_msg_body.RichText)localObject2);
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      localObject1 = null;
      if (QLog.isColorLevel()) {
        QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
      }
      localException.printStackTrace();
    }
    return localObject1;
  }
  
  @NonNull
  protected CustomFaceExtPb.ResvAttr constructResvAttr(MessageForPic paramMessageForPic)
  {
    CustomFaceExtPb.ResvAttr localResvAttr;
    Object localObject;
    if (paramMessageForPic.picExtraData != null)
    {
      localResvAttr = paramMessageForPic.picExtraData.getCustomFaceResvAttr();
      localObject = localResvAttr;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("imageBizType: ");
        ((StringBuilder)localObject).append(paramMessageForPic.picExtraData.imageBizType);
        QLog.d("picExtra", 4, ((StringBuilder)localObject).toString());
        localObject = localResvAttr;
      }
    }
    else
    {
      localResvAttr = new CustomFaceExtPb.ResvAttr();
      localObject = localResvAttr;
      if (QLog.isColorLevel())
      {
        QLog.d("picExtra", 4, "imageBizType: 0");
        localObject = localResvAttr;
      }
    }
    int i = getPicSourceReport(paramMessageForPic, this.mUiRequest.mPicSendSource);
    if (QLog.isColorLevel())
    {
      paramMessageForPic = new StringBuilder();
      paramMessageForPic.append("source: ");
      paramMessageForPic.append(i);
      QLog.d("picExtra", 4, paramMessageForPic.toString());
    }
    ((CustomFaceExtPb.ResvAttr)localObject).uint32_source.set(i);
    return localObject;
  }
  
  protected int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    int i = this.mUiRequest.mUinType;
    if ((i != 1) && (i != 1026)) {
      this.mIsGroup = false;
    } else {
      this.mIsGroup = true;
    }
    Object localObject1 = getTransferRequest();
    if ((localObject1 != null) && (((TransferRequest)localObject1).mIsFastForward))
    {
      if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
        this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
      }
      return 0;
    }
    localObject1 = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("filePath null")), null, null);
      onError();
      return -1;
    }
    Object localObject2 = new File((String)localObject1);
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
        new Handler(Looper.getMainLooper()).post(new GroupPicUploadProcessor.1(this));
        return -1;
      }
    }
    if (l >= ((IPicBus)QRoute.api(IPicBus.class)).getGroupPicSizeLimit())
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
          localObject = this.mProcessorReport.mReportInfo;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(d1);
          localStringBuilder.append("");
          ((HashMap)localObject).put("param_AIOPercent", localStringBuilder.toString());
        }
        Object localObject = this.mProcessorReport.mReportInfo;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        ((HashMap)localObject).put("param_AIODuration", localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doReport ,mStartTime = ");
          ((StringBuilder)localObject).append(this.mProcessorReport.mStartTime);
          ((StringBuilder)localObject).append(",mEnterAioTime = ");
          ((StringBuilder)localObject).append(this.mEnterAioTime);
          ((StringBuilder)localObject).append(",finishTime  = ");
          ((StringBuilder)localObject).append(paramLong2);
          ((StringBuilder)localObject).append(", aioDuration = ");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(", duration = ");
          ((StringBuilder)localObject).append(paramLong1);
          ((StringBuilder)localObject).append("processor:");
          ((StringBuilder)localObject).append(this);
          ((StringBuilder)localObject).append(",mUiRequest.myPresendInvalid = ");
          ((StringBuilder)localObject).append(this.mUiRequest.myPresendInvalid);
          ((StringBuilder)localObject).append(",Percent = ");
          ((StringBuilder)localObject).append(d1);
          QLog.d("GroupPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
        }
      }
      this.mProcessorReport.reportForIpv6(true, paramLong1, true, getReportTAG());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, paramLong1, this.mFileSize, this.mProcessorReport.mReportInfo, "");
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
  
  protected void doStart(boolean paramBoolean)
  {
    if (!paramBoolean) {
      sendMessageToUpdate(1001);
    }
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
    sendRequest();
  }
  
  protected void fillMessageRecord(im_msg_body.RichText paramRichText, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      MessageForPic localMessageForPic = (MessageForPic)paramMessageRecord;
      localMessageForPic.richText = paramRichText;
      localMessageForPic.size = this.mFileSize;
    }
    if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing(paramMessageRecord)) {
      ((MessageForRichText)paramMessageRecord).richText = paramRichText;
    }
  }
  
  protected im_msg_body.CustomFace getCustomFace(MessageRecord paramMessageRecord)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
  
  protected UpCallBack.SendResult getSendResult()
  {
    UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
    localSendResult.e = this.mFileSize;
    localSendResult.g = this.mMd5Str;
    localSendResult.f = this.mFileName;
    localSendResult.d = this.mUiRequest.mLocalPath;
    localSendResult.h = this.mFileID;
    if (this.mUiRequest.isShareImageByServer) {
      localSendResult.l = getImageInfo();
    }
    return localSendResult;
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
  
  void onError()
  {
    super.onError();
    if (this.mProcessorReport.errCode != 9333) {
      sendMessageToUpdate(1005);
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.a = -1;
      localSendResult.b = this.mProcessorReport.errCode;
      localSendResult.c = this.mProcessorReport.errDesc;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
  }
  
  protected void onGroupBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=");
          localStringBuilder.append(this.mProcessorReport.mSendByQuickHttp);
          QLog.e("http_sideway", 2, localStringBuilder.toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        if ((paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp))
        {
          paramRichProtoReq = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq;
          if (paramRichProtoReq.result == 0)
          {
            reportQuickSend(paramRichProtoReq.isExist);
            if (paramRichProtoReq.isExist)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp GroupPicUpResp.isExist.");
              }
              this.mIsPicSecondTransfered = true;
              this.file.transferedSize = this.file.fileSize;
              this.mFileID = paramRichProtoReq.groupFileID;
              this.mIpList = paramRichProtoReq.mIpList;
              sendMsg();
            }
            else
            {
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
          }
          else
          {
            paramRichProtoResp = new StringBuilder();
            paramRichProtoResp.append("<BDH_LOG> onBusiProtoResp() error : ");
            paramRichProtoResp.append(paramRichProtoReq.result);
            paramRichProtoResp.append(" ,select HTTP channel");
            log(paramRichProtoResp.toString());
            this.mChannelStatus = 2;
            onError();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mUiRequest.mUpCallBack != null) {
      this.mUiRequest.mUpCallBack.b(getSendResult());
    } else {
      updateMessageDataBaseContent(true);
    }
    sendMessageToUpdate(1003);
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
      if (this.mChannelStatus != 1)
      {
        this.mTransferedSize = 0L;
        this.mUkey = null;
      }
      this.mServerRollbackCount = 0;
      this.mTryCount = 0;
      this.mReqUrlCount = 0;
      this.mProcessorReport.errCode = 0;
      this.mProcessorReport.errDesc = "";
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> Transaction submit:sendFile:");
      ((StringBuilder)localObject).append(this.mTrans);
      ((StringBuilder)localObject).append("  this:");
      ((StringBuilder)localObject).append(this);
      QLog.d("GroupPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mTrans != null) {
      return;
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    Object localObject = HexUtil.hexStr2Bytes(this.mUkey);
    GroupPicUploadProcessor.2 local2 = new GroupPicUploadProcessor.2(this);
    this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 2, this.mUiRequest.mLocalPath, (int)this.mStartOffset, (byte[])localObject, this.mLocalMd5, local2);
    localObject = new GroupPicUploadProcessor.3(this);
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
      ((StringBuilder)localObject).append(2);
      QLog.d("GroupPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 0)
    {
      setError(i, "SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  void sendGroupMsg()
  {
    if ((this.needSendMsg) && (!this.mUiRequest.mIsPresend))
    {
      Object localObject2 = constructPicRichText();
      if (localObject2 == null)
      {
        setError(9368, "constructpberror", null, this.mProcessorReport.mStepMsg);
        onError();
        return;
      }
      if (!isAppValid())
      {
        setError(9366, "illegal app", null, this.mProcessorReport.mStepMsg);
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
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing((MessageRecord)localObject1))))
      {
        fillMessageRecord((im_msg_body.RichText)localObject2, (MessageRecord)localObject1);
        addInfoToMsg();
        ((IOrderMediaMsgService)this.app.getRuntimeService(IOrderMediaMsgService.class, "")).sendOrderMsg((MessageRecord)localObject1, this.messageObserver, this);
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Mr_");
      if (localObject1 == null)
      {
        localObject1 = "null";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(((MessageRecord)localObject1).msgtype);
        localObject1 = localStringBuilder.toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      setError(9368, "msgtypeError", ((StringBuilder)localObject2).toString(), this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    if (this.mUiRequest.mIsPresend) {
      ((MessageForPic)this.mUiRequest.mRec).mPresendTransferedSize = this.mTransferedSize;
    }
    Object localObject1 = constructPicRichText();
    if (localObject1 == null)
    {
      setError(9368, "constructpberror", null, this.mProcessorReport.mStepMsg);
      onError();
    }
    else
    {
      if (!isAppValid())
      {
        setError(9366, "illegal app", null, this.mProcessorReport.mStepMsg);
        onError();
        return;
      }
      if (this.mUiRequest.mUpCallBack != null) {
        this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject1);
      }
    }
    if ((this.mUiRequest.mIsPresend) && (this.mIsPicSecondTransfered)) {
      ((MessageForPic)this.mUiRequest.mRec).mPresendTransferedSize = 0L;
    }
    addInfoToMsg();
    onSuccess();
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
    StringBuilder localStringBuilder;
    if (!canDoNextStep())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = ");
      localStringBuilder.append(this.mChannelStatus);
      log(localStringBuilder.toString());
      return;
    }
    this.mProcessorReport.mStepMsg.logStartTime();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TestPicSend finish upload,currentTime = ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(",processor = ");
      localStringBuilder.append(this);
      QLog.d("GroupPicUploadProcessor", 2, localStringBuilder.toString());
    }
    sendGroupMsg();
  }
  
  protected void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
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
    Object localObject = this.mUiRequest.mRec;
    if (MessageForPic.class.isInstance(localObject))
    {
      localObject = (MessageForPic)localObject;
      localPicUpReq.picType = ((MessageForPic)localObject).imageType;
      this.mPicType = ((MessageForPic)localObject).imageType;
    }
    localPicUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPicUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPicUpReq.secondUin = this.mUiRequest.mSecondId;
    localPicUpReq.uinType = this.mUiRequest.mUinType;
    if (this.mUiRequest.mUinType == 1026)
    {
      localPicUpReq.uinType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("GroupPicUploadProcessor", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "grp_pic_up";
    localRichProtoReq.reqs.add(localPicUpReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
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
  
  protected void setMtype()
  {
    int i = this.mUiRequest.mFileType;
    if ((this.mNetReq instanceof HttpNetReq))
    {
      if (this.mIsGroup)
      {
        if (i == 2) {
          return;
        }
        ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("picGu", ((HttpNetReq)this.mNetReq).mReqUrl);
        return;
      }
      if (i == 2) {
        return;
      }
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("picDu", ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void start()
  {
    super.start();
    doStart(false);
  }
  
  public void updateMessageData(MessageRecord paramMessageRecord)
  {
    Object localObject;
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localObject = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject).path = this.mUiRequest.mLocalPath;
      ((MessageForPic)localObject).size = this.mFileSize;
      ((MessageForPic)localObject).uuid = this.mFileName;
      ((MessageForPic)localObject).groupFileID = this.mFileID;
      ((MessageForPic)localObject).md5 = this.mMd5Str;
      ((MessageForPic)localObject).type = 1;
      ((MessageForPic)localObject).serial();
      ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, paramMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
      return;
    }
    if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing(paramMessageRecord))
    {
      IMsgStructing localIMsgStructing = (IMsgStructing)QRoute.api(IMsgStructing.class);
      AppInterface localAppInterface = this.app;
      String str = this.mMd5Str;
      if (this.mResid == null) {
        localObject = this.mUuid;
      } else {
        localObject = this.mResid;
      }
      localIMsgStructing.updateMsgAfterUpload(localAppInterface, paramMessageRecord, str, (String)localObject, this.mFileSize, Long.valueOf(this.mFileID), this.mUiRequest.mPeerUin, this.mUiRequest.mUinType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */