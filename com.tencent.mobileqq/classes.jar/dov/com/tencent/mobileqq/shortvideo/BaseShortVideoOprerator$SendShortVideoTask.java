package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  ShortVideoUploadInfo a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    this.a = paramShortVideoUploadInfo;
  }
  
  public void run()
  {
    int i = 0;
    if (this.a == null) {}
    for (;;)
    {
      return;
      ShortVideoUploadInfo localShortVideoUploadInfo = this.a;
      Object localObject;
      if (!localShortVideoUploadInfo.b) {
        localObject = (MessageForShortVideo)localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.mSelfUin = ((MessageRecord)localObject).selfuin;
        localTransferRequest.mPeerUin = ((MessageRecord)localObject).frienduin;
        localTransferRequest.mUinType = ((MessageRecord)localObject).istroop;
        if ((((MessageRecord)localObject).istroop == 0) || (((MessageRecord)localObject).istroop == 1008))
        {
          localTransferRequest.mFileType = 6;
          label117:
          localTransferRequest.mUniseq = ((MessageRecord)localObject).uniseq;
          localTransferRequest.mIsUp = true;
          localTransferRequest.mBusiType = localShortVideoUploadInfo.jdField_a_of_type_Int;
          localTransferRequest.mMd5 = localShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
          localTransferRequest.mLocalPath = (localShortVideoUploadInfo.h + "QQ_&_MoblieQQ_&_QQ" + localShortVideoUploadInfo.i + "QQ_&_MoblieQQ_&_QQ" + localShortVideoUploadInfo.f + "QQ_&_MoblieQQ_&_QQ" + localShortVideoUploadInfo.jdField_g_of_type_JavaLangString);
          localTransferRequest.mUpCallBack = this.this$0;
          localTransferRequest.mRec = ((MessageRecord)localObject);
          localTransferRequest.mExtraObj = this.a;
          localTransferRequest.needSendMsg = localShortVideoUploadInfo.jdField_g_of_type_Boolean;
          ((ITransFileController)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
          if (!localShortVideoUploadInfo.jdField_e_of_type_Boolean)
          {
            if (localShortVideoUploadInfo.b) {
              break label475;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localObject);
          }
        }
        for (;;)
        {
          Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
          return;
          if (localShortVideoUploadInfo.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localShortVideoUploadInfo);
            i = 1;
            break;
          }
          if (localShortVideoUploadInfo.jdField_g_of_type_Int != 1) {
            break label491;
          }
          localObject = (MessageForShortVideo)localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject;
          break;
          if (((MessageRecord)localObject).istroop == 3000)
          {
            localTransferRequest.mFileType = 17;
            break label117;
          }
          if (((MessageRecord)localObject).istroop != 1) {
            break label117;
          }
          localTransferRequest.mFileType = 9;
          break label117;
          label475:
          if (i != 0) {
            this.this$0.a((MessageRecord)localObject);
          }
        }
        label491:
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */