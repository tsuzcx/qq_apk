package com.tencent.mobileqq.kandian.biz.comment;

import android.os.Message;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyCommentComponentFragment$4
  extends TransProcessorHandler
{
  ReadInJoyCommentComponentFragment$4(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
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
        this.a.f();
        paramMessage = this.a;
        paramMessage.a(1, paramMessage.getString(2131717876));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "mTransProcessorHandler send finished!");
      }
    }
    try
    {
      ReadInJoyCommentComponentFragment.a(this.a).c = true;
      ReadInJoyCommentComponentFragment.a(this.a).f = localFileMsg.fileUrl;
      ReadInJoyCommentComponentFragment.a(this.a).g = localFileMsg.fileMd5;
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("mTransProcessorHandler url=");
        paramMessage.append(ReadInJoyCommentComponentFragment.a(this.a).f);
        paramMessage.append(", md5=");
        paramMessage.append(ReadInJoyCommentComponentFragment.a(this.a).g);
        QLog.d("ReadInJoyCommentComponentFragment", 2, paramMessage.toString());
      }
      label220:
      this.a.f();
      ReadInJoyCommentComponentFragment.a(this.a).setResult(-1, ReadInJoyCommentComponentFragment.a(this.a));
      ReadInJoyCommentComponentFragment.a(this.a).finish();
      return;
    }
    catch (Exception paramMessage)
    {
      break label220;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.4
 * JD-Core Version:    0.7.0.1
 */