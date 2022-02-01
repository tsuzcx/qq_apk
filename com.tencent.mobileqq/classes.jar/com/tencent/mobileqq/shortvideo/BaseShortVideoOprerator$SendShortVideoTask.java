package com.tencent.mobileqq.shortvideo;

import azjq;
import bcyj;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

class BaseShortVideoOprerator$SendShortVideoTask
  implements Runnable
{
  bcyj a;
  
  public BaseShortVideoOprerator$SendShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bcyj parambcyj)
  {
    this.a = parambcyj;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bcyj localbcyj = this.a;
      Object localObject;
      int i;
      if (!localbcyj.jdField_a_of_type_Boolean)
      {
        localObject = (MessageForShortVideo)localbcyj.jdField_a_of_type_JavaLangObject;
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
          localTransferRequest.mBusiType = localbcyj.jdField_a_of_type_Int;
          localTransferRequest.mMd5 = localbcyj.e;
          localTransferRequest.mLocalPath = (localbcyj.h + "QQ_&_MoblieQQ_&_QQ" + localbcyj.j + "QQ_&_MoblieQQ_&_QQ" + localbcyj.jdField_f_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + localbcyj.jdField_g_of_type_JavaLangString);
          localTransferRequest.mUpCallBack = this.this$0;
          localTransferRequest.mRec = ((MessageRecord)localObject);
          localTransferRequest.mExtraObj = this.a;
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
          if ((!localbcyj.d) && (!localbcyj.jdField_f_of_type_Boolean))
          {
            if (localbcyj.jdField_a_of_type_Boolean) {
              break label468;
            }
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setChangeAndNotify(localObject);
          }
        }
        for (;;)
        {
          azjq.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          azjq.a(this.this$0.jdField_g_of_type_JavaLangString, this.this$0.f, "doSendShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
          return;
          if (localbcyj.jdField_g_of_type_Int == 0)
          {
            localObject = this.this$0.a(localbcyj);
            i = 1;
            break;
          }
          if (localbcyj.jdField_g_of_type_Int != 1) {
            break label484;
          }
          localObject = (MessageForShortVideo)localbcyj.jdField_a_of_type_JavaLangObject;
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
          label468:
          if (i != 0) {
            this.this$0.a((MessageRecord)localObject);
          }
        }
        label484:
        localObject = null;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.SendShortVideoTask
 * JD-Core Version:    0.7.0.1
 */