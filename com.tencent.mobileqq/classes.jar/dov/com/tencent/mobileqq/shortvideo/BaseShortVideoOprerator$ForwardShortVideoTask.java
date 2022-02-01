package dov.com.tencent.mobileqq.shortvideo;

import azjq;
import bpra;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bpra a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bpra parambpra)
  {
    this.a = parambpra;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bpra localbpra = this.a;
      Object localObject;
      int i;
      if (localbpra.k == 3)
      {
        localObject = this.this$0.a(localbpra);
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
        localTransferRequest.mExtraObj = localbpra;
        localTransferRequest.mUniseq = ((MessageRecord)localObject).uniseq;
        localTransferRequest.mIsUp = true;
        localTransferRequest.mBusiType = 0;
        localTransferRequest.mMd5 = localbpra.e;
        localTransferRequest.mLocalPath = (localbpra.h + "QQ_&_MoblieQQ_&_QQ" + localbpra.i + "QQ_&_MoblieQQ_&_QQ" + localbpra.j + "QQ_&_MoblieQQ_&_QQ" + localbpra.g);
        localTransferRequest.mUpCallBack = this.this$0;
        localTransferRequest.mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        azjq.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
        return;
        if (localbpra.k == 4)
        {
          localObject = (MessageForShortVideo)localbpra.a;
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