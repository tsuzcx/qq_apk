package dov.com.tencent.mobileqq.shortvideo;

import ayde;
import bobp;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  bobp a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bobp parambobp)
  {
    this.a = parambobp;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bobp localbobp = this.a;
      Object localObject;
      int i;
      if (!localbobp.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localbobp.jdField_a_of_type_JavaLangObject;
        i = 0;
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
          localTransferRequest.mBusiType = localbobp.jdField_a_of_type_Int;
          localTransferRequest.mMd5 = localbobp.e;
          localTransferRequest.mLocalPath = (localbobp.h + "QQ_&_MoblieQQ_&_QQ" + localbobp.i + "QQ_&_MoblieQQ_&_QQ" + localbobp.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localbobp.jdField_g_of_type_JavaLangString);
          localTransferRequest.mUpCallBack = this.this$0;
          localTransferRequest.mRec = ((MessageRecord)localObject);
          localTransferRequest.mExtraObj = this.a;
          localTransferRequest.needSendMsg = localbobp.jdField_f_of_type_Boolean;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
          if (!localbobp.d)
          {
            if (localbobp.jdField_a_of_type_Boolean) {
              break label470;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setChangeAndNotify(localObject);
          }
        }
        for (;;)
        {
          ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doSendShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
          return;
          if (localbobp.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localbobp);
            i = 1;
            break;
          }
          if (localbobp.jdField_g_of_type_Int != 1) {
            break label486;
          }
          localObject = (MessageForShortVideo)localbobp.jdField_a_of_type_JavaLangObject;
          i = 0;
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
          label470:
          if (i != 0) {
            this.this$0.a((MessageRecord)localObject);
          }
        }
        label486:
        localObject = null;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */