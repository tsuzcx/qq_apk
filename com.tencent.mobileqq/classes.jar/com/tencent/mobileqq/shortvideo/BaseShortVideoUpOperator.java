package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoUpOperator
  implements UpCallBack, IShortVideoOperator
{
  protected Handler a;
  public BaseQQAppInterface a;
  public MessageRecord a;
  public ShortVideoReq a;
  protected UiCallBack a;
  public String a;
  public String b;
  
  public BaseShortVideoUpOperator() {}
  
  public BaseShortVideoUpOperator(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new BaseShortVideoUpOperator.1(this, Looper.getMainLooper());
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
      Logger.b(this.b, this.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_a_of_type_JavaLangString, paramErrInfo.b);
      return;
    }
    Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
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
    paramShortVideoResult = this.b;
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("what:");
    localStringBuilder.append(paramInt);
    Logger.a(paramShortVideoResult, (String)localObject, "handleSuccess", localStringBuilder.toString());
  }
  
  public void a(Message paramMessage)
  {
    Object localObject1 = this.b;
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("what:");
    ((StringBuilder)localObject2).append(paramMessage.what);
    ((StringBuilder)localObject2).append(",result:");
    ((StringBuilder)localObject2).append(paramMessage.arg1);
    ((StringBuilder)localObject2).append(",obj:");
    ((StringBuilder)localObject2).append(paramMessage.obj);
    Logger.a((String)localObject1, str, "dispatchMessage", ((StringBuilder)localObject2).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack == null) {
      return;
    }
    int i = paramMessage.arg1;
    int j = paramMessage.what;
    if (j != 2)
    {
      if (j != 3) {
        return;
      }
      localObject2 = paramMessage.obj;
      str = null;
      localObject1 = str;
      if (localObject2 == null) {}
    }
    try
    {
      localObject1 = (ArrayList)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.a(i, (ArrayList)localObject1);
      return;
      paramMessage = (ShortVideoResult)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack.b(i, paramMessage);
      return;
    }
    catch (ClassCastException paramMessage)
    {
      for (;;)
      {
        localObject1 = str;
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).updateMediaMsgByUniseq(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    ((IOrderMediaMsgService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsg(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    String str1 = this.b;
    String str2 = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(Thread.currentThread().getId());
    Logger.a(str1, str2, "forwardShortVideo", localStringBuilder.toString());
    if (a(paramShortVideoForwardInfo))
    {
      ThreadManager.getSubThreadHandler().post(new ForwardShortVideoTask(this, paramShortVideoForwardInfo));
      return;
    }
    if (paramShortVideoForwardInfo != null) {
      a(3, paramShortVideoForwardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
    }
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    String str1 = this.b;
    String str2 = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(Thread.currentThread().getId());
    Logger.a(str1, str2, "sendShortVideo", localStringBuilder.toString());
    if (a(paramShortVideoUploadInfo))
    {
      ThreadManager.getSubThreadHandler().post(new SendShortVideoTask(this, paramShortVideoUploadInfo));
      return;
    }
    if (paramShortVideoUploadInfo != null) {
      a(2, paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
    }
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = paramUiCallBack;
  }
  
  public void a(ArrayList<ShortVideoForwardInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("multiForwardShortVideo start:");
      localStringBuilder.append(Thread.currentThread().getId());
      QLog.d("BaseShortVideoOprerator", 2, localStringBuilder.toString());
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ThreadManager.getSubThreadHandler().post(new MultiForwardShortVideoTask(this, paramArrayList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
    }
    a(3, -1, null);
  }
  
  boolean a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    if (paramShortVideoForwardInfo != null)
    {
      String str1 = this.b;
      String str2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramShortVideoForwardInfo);
      Logger.a(str1, str2, "checkShortVideoForwardInfo", localStringBuilder.toString());
      return paramShortVideoForwardInfo.a();
    }
    Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    if (paramShortVideoUploadInfo != null)
    {
      String str1 = this.b;
      String str2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramShortVideoUploadInfo);
      Logger.a(str1, str2, "checkShortVideoUploadInfo", localStringBuilder.toString());
      return paramShortVideoUploadInfo.a();
    }
    Logger.b(this.b, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(2, null);
      return;
    }
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      a(paramSendResult);
      localObject = new ShortVideoResult();
      ((ShortVideoResult)localObject).jdField_a_of_type_Int = 0;
      ((ShortVideoResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
      a(2, (ShortVideoResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).b = paramSendResult.jdField_a_of_type_JavaLangString;
    a(2, (PicInfoInterface.ErrInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoUpOperator
 * JD-Core Version:    0.7.0.1
 */