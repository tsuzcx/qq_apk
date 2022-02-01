package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BaseSVReceiveOperator
  implements DownCallBack, IShortVideoOperator
{
  protected Handler a;
  public BaseQQAppInterface a;
  public ShortVideoReq a;
  protected UiCallBack a;
  public String a;
  public String b;
  
  public BaseSVReceiveOperator() {}
  
  public BaseSVReceiveOperator(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new BaseSVReceiveOperator.1(this, Looper.getMainLooper());
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, ShortVideoReq paramShortVideoReq)
  {
    ThreadManager.post(new BaseSVReceiveOperator.2(paramBaseQQAppInterface, paramShortVideoReq), 8, null, false);
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    return null;
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    return null;
  }
  
  public ShortVideoForwardInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return null;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return null;
  }
  
  protected void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    localShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramErrInfo;
    localShortVideoResult.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localShortVideoResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_b_of_type_JavaLangString);
      return;
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    Object localObject = paramShortVideoResult;
    if (paramShortVideoResult == null) {
      localObject = new ShortVideoResult();
    }
    ((ShortVideoResult)localObject).jdField_a_of_type_Int = 0;
    ((ShortVideoResult)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    a(paramInt, 0, localObject);
    paramShortVideoResult = this.jdField_b_of_type_JavaLangString;
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("what:");
    localStringBuilder.append(paramInt);
    Logger.a(paramShortVideoResult, (String)localObject, "handleSuccess", localStringBuilder.toString());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.jdField_a_of_type_Int = 0;
    localShortVideoResult.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localShortVideoResult);
  }
  
  public void a(Message paramMessage)
  {
    String str1 = this.jdField_b_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("what:");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append(",result:");
    localStringBuilder.append(paramMessage.arg1);
    localStringBuilder.append(",obj:");
    localStringBuilder.append(paramMessage.obj);
    Logger.a(str1, str2, "dispatchMessage", localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack == null) {
      return;
    }
    int i = paramMessage.arg1;
    int j = paramMessage.what;
    if (j != 0)
    {
      if (j != 1) {
        return;
      }
      paramMessage = (ShortVideoResult)paramMessage.obj;
      if ((paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer)) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
      }
    }
    else
    {
      paramMessage = (ShortVideoResult)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.a(i, paramMessage);
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
  }
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if (paramDownResult == null)
    {
      paramDownResult = new PicInfoInterface.ErrInfo();
      paramDownResult.jdField_b_of_type_JavaLangString = "result == null";
      paramDownResult.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramDownResult);
      return;
    }
    a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
    Object localObject1 = this.jdField_b_of_type_JavaLangString;
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(paramDownResult.jdField_a_of_type_Int);
    Logger.a((String)localObject1, (String)localObject2, "onDownload", localStringBuilder.toString());
    localObject1 = new ShortVideoResult();
    ((ShortVideoResult)localObject1).jdField_a_of_type_Int = paramDownResult.jdField_a_of_type_Int;
    ((ShortVideoResult)localObject1).jdField_a_of_type_JavaLangObject = paramDownResult;
    if (paramDownResult.jdField_a_of_type_Int == 0)
    {
      a(0, (ShortVideoResult)localObject1);
      return;
    }
    if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo == null)
    {
      localObject1 = new PicInfoInterface.ErrInfo();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramDownResult.jdField_b_of_type_Int);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramDownResult.jdField_a_of_type_JavaLangString);
      ((PicInfoInterface.ErrInfo)localObject1).jdField_b_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      ((PicInfoInterface.ErrInfo)localObject1).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (PicInfoInterface.ErrInfo)localObject1);
      return;
    }
    a(0, paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    Object localObject = this.jdField_b_of_type_JavaLangString;
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(Thread.currentThread().getId());
    Logger.a((String)localObject, str, "downloadShortVideo", localStringBuilder.toString());
    if (a(paramShortVideoDownloadInfo))
    {
      b(paramShortVideoDownloadInfo);
      return;
    }
    localObject = new DownCallBack.DownResult();
    ((DownCallBack.DownResult)localObject).jdField_a_of_type_Int = -1;
    ((DownCallBack.DownResult)localObject).jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramShortVideoDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    a((DownCallBack.DownResult)localObject);
  }
  
  public void a(ShortVideoForwardInfo paramShortVideoForwardInfo) {}
  
  public void a(ShortVideoReq paramShortVideoReq)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = paramShortVideoReq;
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void a(UiCallBack paramUiCallBack) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList<ShortVideoForwardInfo> paramArrayList) {}
  
  boolean a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    if (paramShortVideoDownloadInfo != null)
    {
      String str1 = this.jdField_b_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramShortVideoDownloadInfo);
      Logger.a(str1, str2, "checkShortVideoDownloadInfo", localStringBuilder.toString());
      return paramShortVideoDownloadInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  void b(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    long l = System.currentTimeMillis();
    paramShortVideoDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = paramShortVideoDownloadInfo.jdField_b_of_type_JavaLangString;
    localTransferRequest.mPeerUin = paramShortVideoDownloadInfo.jdField_c_of_type_JavaLangString;
    localTransferRequest.mSecondId = paramShortVideoDownloadInfo.d;
    localTransferRequest.mUinType = paramShortVideoDownloadInfo.jdField_b_of_type_Int;
    localTransferRequest.mUniseq = paramShortVideoDownloadInfo.jdField_a_of_type_Long;
    localTransferRequest.mIsUp = false;
    localTransferRequest.mBusiType = paramShortVideoDownloadInfo.jdField_a_of_type_Int;
    localTransferRequest.mDownMode = paramShortVideoDownloadInfo.f;
    localTransferRequest.mExtraObj = Integer.valueOf(paramShortVideoDownloadInfo.g);
    localTransferRequest.mIsOnlyGetUrl = paramShortVideoDownloadInfo.jdField_b_of_type_Boolean;
    if ((paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1001) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1003) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1005) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1002) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1004) || (paramShortVideoDownloadInfo.jdField_e_of_type_Int == 1006)) {
      localTransferRequest.mMd5 = paramShortVideoDownloadInfo.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack != null) {
      localTransferRequest.mDownCallBack = this;
    }
    switch (paramShortVideoDownloadInfo.jdField_e_of_type_Int)
    {
    default: 
      break;
    case 1006: 
      localTransferRequest.mFileType = 18;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.i);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1005: 
      localTransferRequest.mFileType = 17;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.h);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_c_of_type_Int);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1004: 
      localTransferRequest.mFileType = 16;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.i);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1003: 
      localTransferRequest.mFileType = 9;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.h);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_c_of_type_Int);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1002: 
      localTransferRequest.mFileType = 7;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.i);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1001: 
      localTransferRequest.mFileType = 6;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.h);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_c_of_type_Int);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
    if ((localObject != null) && (((ShortVideoReq)localObject).a != null)) {
      localTransferRequest.mRec = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" startDownloadVideo downloadvideo fileType==");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_e_of_type_Int);
      ((StringBuilder)localObject).append("downloadvideo MD5==");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.jdField_e_of_type_JavaLangString);
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    ((ITransFileController)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    paramShortVideoDownloadInfo = this.jdField_b_of_type_JavaLangString;
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoDownloadInfo, (String)localObject, "doDownloadShortVideo", localStringBuilder.toString());
    paramShortVideoDownloadInfo = this.jdField_b_of_type_JavaLangString;
    localObject = this.jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TransferRequest: ");
    localStringBuilder.append(localTransferRequest.toString());
    Logger.a(paramShortVideoDownloadInfo, (String)localObject, "doDownloadShortVideo.start", localStringBuilder.toString());
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseSVReceiveOperator
 * JD-Core Version:    0.7.0.1
 */