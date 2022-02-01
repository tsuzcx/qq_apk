package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicTransFile.IPicUploadPro;
import com.tencent.mobileqq.pic.operator.AioQuickSendPicOperator;
import com.tencent.mobileqq.pic.operator.AioQuickSendPicOperator.QuickSendObject;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService.IMsgSendingListener;
import com.tencent.mobileqq.statistics.RichMediaBugReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExplicitError;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import msf.msgsvc.msg_ctrl.MsgCtrl;

public class BasePicUploadProcessor
  extends BaseUploadProcessor
  implements Handler.Callback, IPicTransFile.IPicUploadPro, IOrderMediaMsgService.IMsgSendingListener
{
  public static final int DELAY_SHOW_PROGRESS_TIME = 2000;
  public static final int SEND_PIC_AREA_LIMIT = 200000000;
  public static final int SEND_PIC_LENGTH_LIMIT = 30000;
  private static final int SHOW_PROGRESS = -255;
  private static final String TAG = "BasePicUploadProcessor";
  Handler handler;
  protected AioQuickSendPicOperator.QuickSendObject mQuickSendObject;
  protected boolean uploadSuccess = false;
  
  public BasePicUploadProcessor() {}
  
  public BasePicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.handler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.mQuickSendObject = AioQuickSendPicOperator.a(paramTransferRequest.mRec, paramTransferRequest);
  }
  
  private void handleQuickSendFailed()
  {
    if (isDynamicPic())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleQuickSendFailed:");
        localStringBuilder.append(getMessageForPic());
        QLog.d("BasePicUploadProcessor", 2, localStringBuilder.toString());
      }
      ((IPicHelper)QRoute.api(IPicHelper.class)).getDrawable(getMessageForPic(), 65537, null, null).downloadImediatly();
    }
  }
  
  public static void reportActPSdoneAioDuration(long paramLong1, long paramLong2, boolean paramBoolean, double paramDouble)
  {
    Object localObject = new HashMap();
    if ((paramLong1 <= 86400000L) && (paramDouble >= 0.0D) && (paramDouble <= 1.0D))
    {
      int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
      int j = DeviceInfoUtil.O();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_netType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_aio_duration", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_second_trans", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_phone_type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_pic_filesize", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDouble);
      localStringBuilder.append("");
      ((HashMap)localObject).put("param_optimizePercent", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPSdoneaioduration", false, 0L, 0L, (HashMap)localObject, "", false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportActPSdoneAioDuration,aioduration =");
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append(",filesize = ");
        ((StringBuilder)localObject).append(paramLong2);
        ((StringBuilder)localObject).append(",isSecondTrans = ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(",phoneType = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",percent = ");
        ((StringBuilder)localObject).append(paramDouble);
        QLog.d("BasePicUploadProcessor", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BasePicUploadProcessor", 2, "reportActPSdoneAioDuration,invalid arg,return!");
    }
  }
  
  protected void addInfoToMsg()
  {
    try
    {
      if ((!ZhuoXusManager.a().i()) && (!ZhuoXusManager.a().k()) && (!ZhuoXusManager.a().j()))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("BasePicUploadProcessor", 2, "a , s close !");
        return;
      }
      if (this.mUiRequest == null) {
        return;
      }
      if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForPic)))
      {
        msg_ctrl.MsgCtrl localMsgCtrl = ((IDep)QRoute.api(IDep.class)).getMsgCtrlForPicMsg(this.mUiRequest.mLocalPath);
        if (localMsgCtrl != null)
        {
          ((MessageForPic)this.mUiRequest.mRec).msgCtrl = localMsgCtrl;
          this.mProcessorReport.mReportInfo.put("param_amc", "1");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return;
  }
  
  public int cancel()
  {
    if (this.mQuickSendObject != null) {
      handleQuickSendFailed();
    }
    return super.cancel();
  }
  
  protected void changeRequest(RichProto.RichProtoReq.PicUpReq paramPicUpReq)
  {
    Object localObject = this.mQuickSendObject;
    if ((localObject != null) && (!((AioQuickSendPicOperator.QuickSendObject)localObject).d))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("changeRequest,file Size:");
        ((StringBuilder)localObject).append(paramPicUpReq.fileSize);
        ((StringBuilder)localObject).append(" md5:");
        ((StringBuilder)localObject).append(paramPicUpReq.md5);
        ((StringBuilder)localObject).append(" busiType:");
        ((StringBuilder)localObject).append(this.mUiRequest.mBusiType);
        ((StringBuilder)localObject).append(" quickSendObject:");
        ((StringBuilder)localObject).append(this.mQuickSendObject);
        QLog.d("BasePicUploadProcessor", 2, ((StringBuilder)localObject).toString());
      }
      paramPicUpReq.fileSize = this.mQuickSendObject.b;
      paramPicUpReq.md5 = HexUtil.hexStr2Bytes(this.mQuickSendObject.a);
      if (this.mUiRequest.mBusiType == 1042) {
        paramPicUpReq.typeHotPic = 1;
      }
    }
  }
  
  protected void changeRichText()
  {
    Object localObject = this.mQuickSendObject;
    if ((localObject != null) && (!((AioQuickSendPicOperator.QuickSendObject)localObject).d))
    {
      this.mFileSize = this.mQuickSendObject.b;
      this.mMd5Str = this.mQuickSendObject.a;
      this.mLocalMd5 = HexUtil.hexStr2Bytes(this.mMd5Str);
      if (getClass().equals(GroupPicUploadProcessor.class))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.mMd5Str);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(this.mExtName);
        this.mFileName = ((StringBuilder)localObject).toString();
      }
    }
  }
  
  protected boolean checkContinueSend()
  {
    if (this.mUiRequest.mIsFastForward)
    {
      this.mProcessorReport.setError(9333, "Server MD5 fast forward missed", null, null);
      onError();
      return false;
    }
    AioQuickSendPicOperator.QuickSendObject localQuickSendObject = this.mQuickSendObject;
    if ((localQuickSendObject != null) && (!localQuickSendObject.d))
    {
      this.mQuickSendObject.d = true;
      if (QLog.isColorLevel()) {
        QLog.d("BasePicUploadProcessor", 2, "QuickSendFail");
      }
      sendRequest();
      return false;
    }
    return true;
  }
  
  protected boolean checkFileStandard(boolean paramBoolean)
  {
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      this.mProcessorReport.setError(9041, "No Local MD5", null, null);
      onError();
      return false;
    }
    if ((paramBoolean) && ((this.mHeight == 0) || (this.mWidth == 0)))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = 1;
      BaseImageUtil.a(this.mUiRequest.mLocalPath, localOptions);
      this.mHeight = localOptions.outHeight;
      this.mWidth = localOptions.outWidth;
      Object localObject = this.mUiRequest.mExtraObj;
      if ((localObject != null) && ((localObject instanceof TransferRequest.PicUpExtraInfo)) && (((TransferRequest.PicUpExtraInfo)localObject).mIsRaw) && (RichMediaUtil.isPicLandscape(this.mUiRequest.mLocalPath)))
      {
        this.mHeight = localOptions.outWidth;
        this.mWidth = localOptions.outHeight;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("raw pic is Landscape,swap w,h; options.outWidth = ");
          ((StringBuilder)localObject).append(localOptions.outWidth);
          ((StringBuilder)localObject).append(",options.outHeight = ");
          ((StringBuilder)localObject).append(localOptions.outHeight);
          ((StringBuilder)localObject).append(",mWidth = ");
          ((StringBuilder)localObject).append(this.mWidth);
          ((StringBuilder)localObject).append(",mHeight = ");
          ((StringBuilder)localObject).append(this.mHeight);
          logRichMediaEvent("doStart", ((StringBuilder)localObject).toString());
        }
      }
    }
    if (this.mRaf == null)
    {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        this.mRaf = null;
      }
      if (this.mRaf == null)
      {
        this.mProcessorReport.setError(9303, "read file error", null, null);
        onError();
        return false;
      }
    }
    if (((this.mUiRequest.mRec instanceof MessageForPic)) && ((this.mHeight > 30000) || (this.mWidth > 30000) || (this.mWidth * this.mHeight > 200000000)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFileStandard fail，mHeight:");
        localStringBuilder.append(this.mHeight);
        localStringBuilder.append(" mWidth:");
        localStringBuilder.append(this.mWidth);
        QLog.d("BasePicUploadProcessor", 2, localStringBuilder.toString());
      }
      this.mProcessorReport.setError(90632, "PicOverStandard", null, null);
      onError();
      return false;
    }
    return true;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (this.mProcessorReport.errCode != 9333)
    {
      super.doReport(paramBoolean);
      if (!QLog.isColorLevel()) {
        return;
      }
      if (ConfigManager.mUseHardCodeIp == 1)
      {
        RichMediaBugReport.a("BDH_UPLOAD_USE_HARDCORD_IP", (String)this.mProcessorReport.mReportInfo.get("serverip"));
        ConfigManager.mUseHardCodeIp = 0;
      }
    }
  }
  
  public int[] getImageInfo()
  {
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = ((int)this.mFileSize);
    arrayOfInt[1] = PicBusUtil.c(this.mUiRequest.mLocalPath);
    arrayOfInt[2] = this.mWidth;
    arrayOfInt[3] = this.mHeight;
    arrayOfInt[4] = 0;
    int i = BaseImageUtil.d(this.mUiRequest.mLocalPath);
    if ((i == 90) || (270 == i))
    {
      arrayOfInt[2] = this.mHeight;
      arrayOfInt[3] = this.mWidth;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rotateDegree : ");
    localStringBuilder.append(i);
    localStringBuilder.append(", params[2] : ");
    localStringBuilder.append(arrayOfInt[2]);
    localStringBuilder.append(" params[3] : ");
    localStringBuilder.append(arrayOfInt[3]);
    QLog.d("BasePicUploadProcessor", 1, localStringBuilder.toString());
    return arrayOfInt;
  }
  
  protected MessageForPic getMessageForPic()
  {
    MessageRecord localMessageRecord = this.mUiRequest.mRec;
    if ((localMessageRecord instanceof MessageForPic)) {
      return (MessageForPic)localMessageRecord;
    }
    if (((IMsgStructing)QRoute.api(IMsgStructing.class)).isMessageForStructing(localMessageRecord)) {
      return ((IMsgStructing)QRoute.api(IMsgStructing.class)).getMessageForPic(localMessageRecord);
    }
    return null;
  }
  
  protected int getPicSourceReport(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    paramInt = 6;
    int i = this.mUiRequest.mBusiType;
    if ((i != 1009) && (i != 1031) && (i != 1048)) {}
    switch (i)
    {
    default: 
      break;
    case 1053: 
      paramInt = 7;
      break;
    case 1052: 
      paramInt = 2;
      break;
    case 1051: 
      paramInt = 3;
      break;
    case 1050: 
      paramInt = 1;
      break;
      paramInt = 4;
    }
    if (QLog.isColorLevel())
    {
      paramMessageForPic = new StringBuilder();
      paramMessageForPic.append("getPicSourceReport:");
      paramMessageForPic.append(this.mUiRequest.mBusiType);
      paramMessageForPic.append(" source:");
      paramMessageForPic.append(paramInt);
      QLog.d("BasePicUploadProcessor", 2, paramMessageForPic.toString());
    }
    return paramInt;
  }
  
  protected int getReportBizType()
  {
    int i = this.mUiRequest.mBusiType;
    if (i != 1027)
    {
      if (i != 1031)
      {
        if (i != 1034) {
          if (i != 1037) {
            if (i == 1038) {}
          }
        }
        switch (i)
        {
        default: 
          return 0;
        case 1008: 
          return 2;
        case 1007: 
          return 3;
        case 1006: 
          return 5;
          return 9;
          return 8;
          return 7;
        }
      }
      return 4;
    }
    return 6;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.file.status < 1002) {
      sendMessageToUpdate(1002);
    }
    return true;
  }
  
  protected boolean isDynamicPic()
  {
    MessageForPic localMessageForPic = getMessageForPic();
    return (localMessageForPic != null) && (localMessageForPic.imageType == 2000);
  }
  
  public boolean isUploadSuccess()
  {
    return this.uploadSuccess;
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.handler.removeMessages(-255);
  }
  
  void onError()
  {
    super.onError();
    AioQuickSendPicOperator.QuickSendObject localQuickSendObject = this.mQuickSendObject;
    if ((localQuickSendObject != null) && (localQuickSendObject.d)) {
      handleQuickSendFailed();
    }
    this.handler.removeMessages(-255);
    if (this.mUiRequest != null) {
      ((IDep)QRoute.api(IDep.class)).reportEmotionPicMonitor(this.mUiRequest.mRec, String.valueOf(this.mProcessorReport.errCode), true);
    }
  }
  
  public void onSendBegin(MessageRecord paramMessageRecord)
  {
    sendMessageToUpdate(1003);
  }
  
  public void onSendEnd(boolean paramBoolean, long paramLong) {}
  
  void onSuccess()
  {
    super.onSuccess();
    this.handler.removeMessages(-255);
    Object localObject = this.mQuickSendObject;
    if (localObject != null)
    {
      localObject = ((AioQuickSendPicOperator.QuickSendObject)localObject).a;
      if (!this.mQuickSendObject.d)
      {
        if (localObject != null)
        {
          localObject = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL((String)localObject, 65537);
          if (localObject != null) {
            localObject = ((URL)localObject).toString();
          } else {
            localObject = null;
          }
          if (!AbsDownloader.hasFile((String)localObject))
          {
            String str = AbsDownloader.getFilePath((String)localObject);
            if (isDynamicPic())
            {
              localObject = this.mUiRequest.mLocalPath;
            }
            else
            {
              localObject = this.mQuickSendObject.a;
              localObject = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL((String)localObject, 65537);
              if (localObject != null) {
                localObject = ((URL)localObject).toString();
              } else {
                localObject = null;
              }
              if (AbsDownloader.hasFile((String)localObject)) {
                localObject = AbsDownloader.getFilePath((String)localObject);
              } else {
                localObject = this.mUiRequest.mLocalPath;
              }
            }
            boolean bool = FileUtils.copyFile((String)localObject, str);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("quick send copy file:");
              ((StringBuilder)localObject).append(this.mUiRequest.mLocalPath);
              ((StringBuilder)localObject).append(" to:");
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append(" ret:");
              ((StringBuilder)localObject).append(bool);
              QLog.d("BasePicUploadProcessor", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      else {
        handleQuickSendFailed();
      }
    }
    if (this.mUiRequest != null) {
      ((IDep)QRoute.api(IDep.class)).reportEmotionPicMonitor(this.mUiRequest.mRec, null, true);
    }
  }
  
  public void pause()
  {
    this.handler.removeMessages(-255);
  }
  
  protected void reportForServerMonitor(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    String str2 = this.mFileName;
    String str1;
    if (this.mResid == null) {
      str1 = this.mUuid;
    } else {
      str1 = this.mResid;
    }
    reportForServerMonitor("actRichMediaNetMonitor_picUp", paramBoolean, paramInt, paramString1, paramString2, str2, str1, null);
  }
  
  protected void reportQuickSend(boolean paramBoolean)
  {
    Object localObject = this.mQuickSendObject;
    if ((localObject != null) && (!((AioQuickSendPicOperator.QuickSendObject)localObject).d))
    {
      HashMap localHashMap = new HashMap();
      if (paramBoolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localHashMap.put("param_succ_flag", localObject);
      if (this.mUiRequest.mBusiType == 1042) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "HotPicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
    }
  }
  
  protected void sendRequest() {}
  
  public void setError(int paramInt, String paramString1, String paramString2, StepInfo paramStepInfo)
  {
    this.mProcessorReport.setError(paramInt, paramString1, paramString2, paramStepInfo);
    PicUploadExplicitError.uploadFailUpdateMsg(this.mUiRequest.mRec, paramInt, paramString1, paramString2);
  }
  
  public void start()
  {
    super.start();
    this.handler.sendEmptyMessageDelayed(-255, 2000L);
  }
  
  void updateMessageData(MessageRecord paramMessageRecord) {}
  
  public void updateMessageDataBaseContent(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.mUiRequest.mRec != null)
    {
      localMessageRecord = this.mUiRequest.mRec;
    }
    else
    {
      localMessageRecord = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
    }
    if (localMessageRecord == null)
    {
      logRichMediaEvent("updateDb", "msg null");
      return;
    }
    if (localMessageRecord.isMultiMsg)
    {
      logRichMediaEvent("updateDb", "is multiMsg");
      return;
    }
    updateMessageData(localMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */