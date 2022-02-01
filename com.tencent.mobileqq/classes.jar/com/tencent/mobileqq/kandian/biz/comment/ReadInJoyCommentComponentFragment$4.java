package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ReadInJoyCommentComponentFragment$4
  implements Runnable
{
  ReadInJoyCommentComponentFragment$4(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString) {}
  
  public void run()
  {
    if (!new File(this.a).exists())
    {
      this.this$0.g();
      localObject = this.this$0;
      ((ReadInJoyCommentComponentFragment)localObject).a(1, ((ReadInJoyCommentComponentFragment)localObject).getString(2131915349));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startUploadPic file not exist, path=");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("ReadInJoyCommentComponentFragment", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = (ITransFileController)ReadInJoyCommentComponentFragment.b(this.this$0).app.getRuntimeService(ITransFileController.class);
    this.this$0.S.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    ((ITransFileController)localObject).addHandle(this.this$0.S);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mCommandId = 10;
    localTransferRequest.mLocalPath = this.a;
    localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mFileType = 24;
    localTransferRequest.mRichTag = "KandianUGCPicUpload";
    ((ITransFileController)localObject).transferAsync(localTransferRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.4
 * JD-Core Version:    0.7.0.1
 */