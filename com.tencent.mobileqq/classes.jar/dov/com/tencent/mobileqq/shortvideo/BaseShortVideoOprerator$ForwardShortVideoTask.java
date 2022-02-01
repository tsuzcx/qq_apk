package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  ShortVideoForwardInfo a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    this.a = paramShortVideoForwardInfo;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      ShortVideoForwardInfo localShortVideoForwardInfo = this.a;
      Object localObject;
      int i;
      if (localShortVideoForwardInfo.k == 3)
      {
        localObject = this.this$0.a(localShortVideoForwardInfo);
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
        localTransferRequest.mExtraObj = localShortVideoForwardInfo;
        localTransferRequest.mUniseq = ((MessageRecord)localObject).uniseq;
        localTransferRequest.mIsUp = true;
        localTransferRequest.mBusiType = 0;
        localTransferRequest.mMd5 = localShortVideoForwardInfo.e;
        localTransferRequest.mLocalPath = (localShortVideoForwardInfo.h + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.i + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.j + "QQ_&_MoblieQQ_&_QQ" + localShortVideoForwardInfo.g);
        localTransferRequest.mUpCallBack = this.this$0;
        localTransferRequest.mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        ((ITransFileController)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject);
        }
        Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        Logger.a(this.this$0.b, this.this$0.jdField_a_of_type_JavaLangString, "doForwardShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
        return;
        if (localShortVideoForwardInfo.k == 4)
        {
          localObject = (MessageForShortVideo)localShortVideoForwardInfo.a;
          i = 0;
        }
        else
        {
          i = 0;
          localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */