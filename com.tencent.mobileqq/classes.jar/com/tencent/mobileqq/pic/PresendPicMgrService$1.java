package com.tencent.mobileqq.pic;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class PresendPicMgrService$1
  implements UiCallBack
{
  PresendPicMgrService$1(PresendPicMgrService paramPresendPicMgrService, PicReq paramPicReq, PicUploadInfo paramPicUploadInfo) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, PicResult paramPicResult) {}
  
  public void a(int paramInt, ArrayList<PicResult> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, PicResult paramPicResult) {}
  
  public void c(int paramInt, PicResult arg2)
  {
    UpCallBack.SendResult localSendResult = (UpCallBack.SendResult)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g).append(",uuid:").append(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      Logger.a("PresendPicMgrService", "onSend ", ???);
      Logger.a("PresendPicMgrService", "onSend", " SendResult = " + localSendResult);
    }
    for (;;)
    {
      synchronized (PresendPicMgrService.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c = 1;
            Logger.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
            PresendPicMgrService.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService).add(this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(PresendPicMgrService.a(this.jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService));
          localObject2 = (MessageRecord)this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a;
          ((OrderMediaMsgManager)localQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a((MessageRecord)localObject2, null);
          Logger.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
        }
        catch (AccountNotMatchException localAccountNotMatchException) {}
        if (QLog.isColorLevel()) {
          QLog.d("PresendPicMgrService", 2, "no appRuntime");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "onSend SendResult = " + localAccountNotMatchException + ", upload failed");
      }
    }
  }
  
  public void d(int paramInt, PicResult paramPicResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PresendPicMgrService.1
 * JD-Core Version:    0.7.0.1
 */