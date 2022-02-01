package com.tencent.mobileqq.kandian.biz.comment;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyCommentComponentFragment$5
  extends TransProcessorHandler
{
  ReadInJoyCommentComponentFragment$5(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg != null) && (localFileMsg.fileType == 24))
    {
      if (localFileMsg.commandId != 10) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1004: 
      case 1005: 
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentComponentFragment", 2, "mTransProcessorHandler send error or cancel!");
        }
        this.a.g();
        paramMessage = this.a;
        paramMessage.a(1, paramMessage.getString(2131915349));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "mTransProcessorHandler send finished!");
      }
    }
    try
    {
      ReadInJoyCommentComponentFragment.c(this.a).m = true;
      ReadInJoyCommentComponentFragment.c(this.a).n = localFileMsg.fileUrl;
      ReadInJoyCommentComponentFragment.c(this.a).o = localFileMsg.fileMd5;
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("mTransProcessorHandler url=");
        paramMessage.append(ReadInJoyCommentComponentFragment.c(this.a).n);
        paramMessage.append(", md5=");
        paramMessage.append(ReadInJoyCommentComponentFragment.c(this.a).o);
        QLog.d("ReadInJoyCommentComponentFragment", 2, paramMessage.toString());
      }
      label220:
      this.a.g();
      ReadInJoyCommentComponentFragment.b(this.a).setResult(-1, ReadInJoyCommentComponentFragment.d(this.a));
      ReadInJoyCommentComponentFragment.b(this.a).finish();
      return;
    }
    catch (Exception paramMessage)
    {
      break label220;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.5
 * JD-Core Version:    0.7.0.1
 */