package dov.com.tencent.mobileqq.shortvideo;

import ayde;
import bobi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bobi a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bobi parambobi)
  {
    this.a = parambobi;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bobi localbobi = this.a;
      Object localObject;
      int i;
      if (localbobi.k == 3)
      {
        localObject = this.this$0.a(localbobi);
        i = 1;
      }
      while (localObject != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        long l = System.currentTimeMillis();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.mSelfUin = ((MessageRecord)localObject).selfuin;
        localTransferRequest.mPeerUin = ((MessageRecord)localObject).frienduin;
        localTransferRequest.mUinType = ((MessageRecord)localObject).istroop;
        localTransferRequest.mFileType = 20;
        localTransferRequest.mExtraObj = localbobi;
        localTransferRequest.mUniseq = ((MessageRecord)localObject).uniseq;
        localTransferRequest.mIsUp = true;
        localTransferRequest.mBusiType = 0;
        localTransferRequest.mMd5 = localbobi.e;
        localTransferRequest.mLocalPath = (localbobi.h + "QQ_&_MoblieQQ_&_QQ" + localbobi.i + "QQ_&_MoblieQQ_&_QQ" + localbobi.j + "QQ_&_MoblieQQ_&_QQ" + localbobi.g);
        localTransferRequest.mUpCallBack = this.this$0;
        localTransferRequest.mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        ayde.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
        return;
        if (localbobi.k == 4)
        {
          localObject = (MessageForShortVideo)localbobi.a;
          i = 0;
        }
        else
        {
          localObject = null;
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */