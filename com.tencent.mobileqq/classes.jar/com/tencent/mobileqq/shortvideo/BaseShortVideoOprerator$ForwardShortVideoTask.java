package com.tencent.mobileqq.shortvideo;

import afoa;
import ayde;
import bbqj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

class BaseShortVideoOprerator$ForwardShortVideoTask
  implements Runnable
{
  bbqj a;
  
  public BaseShortVideoOprerator$ForwardShortVideoTask(BaseShortVideoOprerator paramBaseShortVideoOprerator, bbqj parambbqj)
  {
    this.a = parambbqj;
  }
  
  public void run()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      bbqj localbbqj = this.a;
      long l = localbbqj.jdField_a_of_type_Long;
      int j = localbbqj.p;
      Object localObject;
      int i;
      if (localbbqj.k == 3)
      {
        localObject = this.this$0.a(localbbqj);
        i = 1;
      }
      while (localObject != null)
      {
        afoa.a().a(((MessageRecord)localObject).uniseq, l, j);
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        l = System.currentTimeMillis();
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.mSelfUin = ((MessageRecord)localObject).selfuin;
        localTransferRequest.mPeerUin = ((MessageRecord)localObject).frienduin;
        localTransferRequest.mUinType = ((MessageRecord)localObject).istroop;
        localTransferRequest.mFileType = 20;
        localTransferRequest.mExtraObj = localbbqj;
        localTransferRequest.mUniseq = ((MessageRecord)localObject).uniseq;
        localTransferRequest.mIsUp = true;
        localTransferRequest.mBusiType = 0;
        localTransferRequest.mMd5 = localbbqj.e;
        localTransferRequest.mLocalPath = (localbbqj.h + "QQ_&_MoblieQQ_&_QQ" + localbbqj.i + "QQ_&_MoblieQQ_&_QQ" + localbbqj.j + "QQ_&_MoblieQQ_&_QQ" + localbbqj.g);
        localTransferRequest.mUpCallBack = this.this$0;
        localTransferRequest.mRec = this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
        if (i != 0) {
          this.this$0.a((MessageRecord)localObject, localbbqj.b);
        }
        ayde.a(this.this$0.g, this.this$0.f, "doForwardShortVideo", "cost:" + (System.currentTimeMillis() - l));
        ayde.a(this.this$0.g, this.this$0.f, "doForwardShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
        return;
        if (localbbqj.k == 4)
        {
          localObject = (MessageForShortVideo)localbbqj.jdField_a_of_type_JavaLangObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator.ForwardShortVideoTask
 * JD-Core Version:    0.7.0.1
 */