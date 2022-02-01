package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import aucy;
import audj;
import avsq;
import aycl;
import aycm;
import baho;
import bcel;
import bcjc;
import bfvo;
import bjng;
import bkkh;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExplicitError;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import msf.msgsvc.msg_ctrl.MsgCtrl;

public class BasePicUploadProcessor
  extends BaseUploadProcessor
  implements Handler.Callback, baho
{
  public static final int DELAY_SHOW_PROGRESS_TIME = 2000;
  public static final int SEND_PIC_AREA_LIMIT = 200000000;
  public static final int SEND_PIC_LENGTH_LIMIT = 30000;
  private static final int SHOW_PROGRESS = -255;
  private static final String TAG = "BasePicUploadProcessor";
  Handler handler;
  protected aycm mQuickSendObject;
  
  public BasePicUploadProcessor() {}
  
  public BasePicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.handler = new bjng(Looper.getMainLooper(), this);
    this.mQuickSendObject = aycl.a(paramTransferRequest.mRec, paramTransferRequest);
  }
  
  private void handleQuickSendFailed()
  {
    if (isDynamicPic())
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "handleQuickSendFailed:" + getMessageForPic());
      }
      URLDrawableHelper.getDrawable(getMessageForPic(), 65537, null, null).downloadImediatly();
    }
  }
  
  protected void addInfoToMsg()
  {
    try
    {
      if ((!audj.a().f()) && (!audj.a().h()) && (!audj.a().g()))
      {
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("BasePicUploadProcessor", 0, "a , s close !");
        }
      }
      else if ((this.mUiRequest != null) && (this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForPic)))
      {
        msg_ctrl.MsgCtrl localMsgCtrl = aucy.a(this.mUiRequest.mLocalPath);
        if (localMsgCtrl != null)
        {
          ((MessageForPic)this.mUiRequest.mRec).msgCtrl = localMsgCtrl;
          this.mReportInfo.put("param_amc", "1");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
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
    if ((this.mQuickSendObject != null) && (!this.mQuickSendObject.jdField_a_of_type_Boolean))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "changeRequest,file Size:" + paramPicUpReq.fileSize + " md5:" + paramPicUpReq.md5 + " busiType:" + this.mUiRequest.mBusiType + " quickSendObject:" + this.mQuickSendObject);
      }
      paramPicUpReq.fileSize = this.mQuickSendObject.jdField_a_of_type_Long;
      paramPicUpReq.md5 = HexUtil.hexStr2Bytes(this.mQuickSendObject.jdField_a_of_type_JavaLangString);
      if (this.mUiRequest.mBusiType == 1042) {
        paramPicUpReq.typeHotPic = 1;
      }
    }
  }
  
  protected void changeRichText()
  {
    if ((this.mQuickSendObject != null) && (!this.mQuickSendObject.jdField_a_of_type_Boolean))
    {
      this.mFileSize = this.mQuickSendObject.jdField_a_of_type_Long;
      this.mMd5Str = this.mQuickSendObject.jdField_a_of_type_JavaLangString;
      this.mLocalMd5 = HexUtil.hexStr2Bytes(this.mMd5Str);
      if (getClass().equals(GroupPicUploadProcessor.class)) {
        this.mFileName = (this.mMd5Str + "." + this.mExtName);
      }
    }
  }
  
  protected boolean checkContinueSend()
  {
    if (this.mUiRequest.mIsFastForward)
    {
      setError(9333, "Server MD5 fast forward missed");
      onError();
      return false;
    }
    if ((this.mQuickSendObject != null) && (!this.mQuickSendObject.jdField_a_of_type_Boolean))
    {
      this.mQuickSendObject.jdField_a_of_type_Boolean = true;
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "QuickSendFail");
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
      setError(9041, "No Local MD5");
      onError();
      return false;
    }
    if ((paramBoolean) && ((this.mHeight == 0) || (this.mWidth == 0)))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = 1;
      bfvo.a(this.mUiRequest.mLocalPath, localOptions);
      this.mHeight = localOptions.outHeight;
      this.mWidth = localOptions.outWidth;
      Object localObject = this.mUiRequest.mExtraObj;
      if ((localObject != null) && ((localObject instanceof TransferRequest.PicUpExtraInfo)) && (((TransferRequest.PicUpExtraInfo)localObject).mIsRaw) && (RichMediaUtil.isPicLandscape(this.mUiRequest.mLocalPath)))
      {
        this.mHeight = localOptions.outWidth;
        this.mWidth = localOptions.outHeight;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          logRichMediaEvent("doStart", "raw pic is Landscape,swap w,h; options.outWidth = " + localOptions.outWidth + ",options.outHeight = " + localOptions.outHeight + ",mWidth = " + this.mWidth + ",mHeight = " + this.mHeight);
        }
      }
    }
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
        if (this.mRaf == null)
        {
          setError(9303, "read file error");
          onError();
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.mRaf = null;
        }
      }
    }
    if (((this.mUiRequest.mRec instanceof MessageForPic)) && ((this.mHeight > 30000) || (this.mWidth > 30000) || (this.mWidth * this.mHeight > 200000000)))
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "checkFileStandard fail，mHeight:" + this.mHeight + " mWidth:" + this.mWidth);
      }
      setError(90632, "PicOverStandard");
      onError();
      return false;
    }
    return true;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if (this.errCode != 9333)
    {
      super.doReport(paramBoolean);
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        break label22;
      }
    }
    label22:
    while (ConfigManager.mUseHardCodeIp != 1) {
      return;
    }
    bcel.a("BDH_UPLOAD_USE_HARDCORD_IP", (String)this.mReportInfo.get("serverip"));
    ConfigManager.mUseHardCodeIp = 0;
  }
  
  public int[] getImageInfo()
  {
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = ((int)this.mFileSize);
    arrayOfInt[1] = bkkh.a(this.mUiRequest.mLocalPath);
    arrayOfInt[2] = this.mWidth;
    arrayOfInt[3] = this.mHeight;
    arrayOfInt[4] = 0;
    int i = bfvo.a(this.mUiRequest.mLocalPath);
    if ((i == 90) || (270 == i))
    {
      arrayOfInt[2] = this.mHeight;
      arrayOfInt[3] = this.mWidth;
    }
    com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 1, "rotateDegree : " + i + ", params[2] : " + arrayOfInt[2] + " params[3] : " + arrayOfInt[3]);
    return arrayOfInt;
  }
  
  protected MessageForPic getMessageForPic()
  {
    Object localObject = this.mUiRequest.mRec;
    if ((localObject instanceof MessageForPic)) {
      localObject = (MessageForPic)localObject;
    }
    MessageForPic localMessageForPic;
    do
    {
      return localObject;
      if (!(localObject instanceof MessageForStructing)) {
        break;
      }
      localObject = (MessageForStructing)localObject;
      if ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare))) {
        break;
      }
      localObject = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
      if (localObject == null) {
        break;
      }
      localMessageForPic = ((bcjc)localObject).a;
      localObject = localMessageForPic;
    } while (localMessageForPic != null);
    return null;
  }
  
  protected int getPicSourceReport(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    paramInt = 6;
    switch (this.mUiRequest.mBusiType)
    {
    }
    for (;;)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "getPicSourceReport:" + this.mUiRequest.mBusiType + " source:" + paramInt);
      }
      return paramInt;
      paramInt = 2;
      continue;
      paramInt = 4;
      continue;
      paramInt = 1;
      continue;
      paramInt = 3;
      continue;
      paramInt = 7;
    }
  }
  
  protected int getReportBizType()
  {
    switch (this.mUiRequest.mBusiType)
    {
    default: 
      return 0;
    case 1008: 
      return 2;
    case 1007: 
      return 3;
    case 1009: 
    case 1031: 
      return 4;
    case 1006: 
      return 5;
    case 1027: 
      return 6;
    case 1034: 
      return 7;
    case 1037: 
      return 8;
    }
    return 9;
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
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.handler.removeMessages(-255);
  }
  
  void onError()
  {
    super.onError();
    if ((this.mQuickSendObject != null) && (this.mQuickSendObject.jdField_a_of_type_Boolean)) {
      handleQuickSendFailed();
    }
    this.handler.removeMessages(-255);
    if (this.mUiRequest != null)
    {
      if (!avsq.b(this.mUiRequest.mRec)) {
        break label67;
      }
      avsq.b(String.valueOf(this.errCode), 3);
    }
    label67:
    while (!avsq.a(this.mUiRequest.mRec)) {
      return;
    }
    avsq.b(String.valueOf(this.errCode), 2);
  }
  
  public void onSendBegin(MessageRecord paramMessageRecord)
  {
    sendMessageToUpdate(1003);
  }
  
  public void onSendEnd(boolean paramBoolean, long paramLong) {}
  
  void onSuccess()
  {
    Object localObject2 = null;
    super.onSuccess();
    this.handler.removeMessages(-255);
    if (this.mQuickSendObject != null)
    {
      localObject1 = this.mQuickSendObject.jdField_a_of_type_JavaLangString;
      if (this.mQuickSendObject.jdField_a_of_type_Boolean) {
        break label236;
      }
      if (localObject1 != null)
      {
        localObject1 = URLDrawableHelper.getURL((String)localObject1, 65537);
        if (localObject1 == null) {
          break label264;
        }
      }
    }
    label264:
    for (Object localObject1 = ((URL)localObject1).toString();; localObject1 = null)
    {
      if (!AbsDownloader.hasFile((String)localObject1))
      {
        String str = AbsDownloader.getFilePath((String)localObject1);
        if (!isDynamicPic()) {
          break label183;
        }
        localObject1 = this.mUiRequest.mLocalPath;
        boolean bool = FileUtils.copyFile((String)localObject1, str);
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("BasePicUploadProcessor", 2, "quick send copy file:" + this.mUiRequest.mLocalPath + " to:" + str + " ret:" + bool);
        }
      }
      label155:
      if (this.mUiRequest != null)
      {
        if (!avsq.b(this.mUiRequest.mRec)) {
          break label243;
        }
        avsq.b("0", 3);
      }
      label183:
      label236:
      label243:
      while (!avsq.a(this.mUiRequest.mRec))
      {
        return;
        URL localURL = URLDrawableHelper.getURL(this.mQuickSendObject.jdField_a_of_type_JavaLangString, 65537);
        localObject1 = localObject2;
        if (localURL != null) {
          localObject1 = localURL.toString();
        }
        if (AbsDownloader.hasFile((String)localObject1))
        {
          localObject1 = AbsDownloader.getFilePath((String)localObject1);
          break;
        }
        localObject1 = this.mUiRequest.mLocalPath;
        break;
        handleQuickSendFailed();
        break label155;
      }
      avsq.b("0", 2);
      return;
    }
  }
  
  public void pause()
  {
    this.handler.removeMessages(-255);
  }
  
  protected void reportForServerMonitor(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    String str2 = this.mFileName;
    if (this.mResid == null) {}
    for (String str1 = this.mUuid;; str1 = this.mResid)
    {
      reportForServerMonitor("actRichMediaNetMonitor_picUp", paramBoolean, paramInt, paramString1, paramString2, str2, str1, null);
      return;
    }
  }
  
  protected void reportQuickSend(boolean paramBoolean)
  {
    HashMap localHashMap;
    if ((this.mQuickSendObject != null) && (!this.mQuickSendObject.jdField_a_of_type_Boolean))
    {
      localHashMap = new HashMap();
      if (!paramBoolean) {
        break label95;
      }
    }
    label95:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_succ_flag", str);
      if (this.mUiRequest.mBusiType == 1042) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "HotPicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PicQuickSend", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  protected void sendRequest() {}
  
  public void setError(int paramInt, String paramString1, String paramString2, BaseTransProcessor.StepInfo paramStepInfo)
  {
    super.setError(paramInt, paramString1, paramString2, paramStepInfo);
    PicUploadExplicitError.uploadFailUpdateMsg(this.mUiRequest.mRec, paramInt, paramString1, paramString2);
  }
  
  public void start()
  {
    super.start();
    this.handler.sendEmptyMessageDelayed(-255, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */