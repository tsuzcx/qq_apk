package com.tencent.mobileqq.transfile;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;

class ForwardImageProcessor$1
  extends TransProcessorHandler
{
  ForwardImageProcessor$1(ForwardImageProcessor paramForwardImageProcessor) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((i == 2002) || ((ForwardImageProcessor.access$000(this.this$0).equals(localFileMsg.mUin)) && (localFileMsg.fileType == 1) && (i != 2002)))
    {
      if ((localFileMsg.forwardTaskKey == null) || (!localFileMsg.forwardTaskKey.equals(ForwardImageProcessor.access$100(this.this$0)))) {
        return;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      ForwardImageProcessor.access$200(this.this$0);
      continue;
      if (FileUtils.fileExistsAndNotEmpty(ForwardImageProcessor.access$300(this.this$0)))
      {
        ForwardImageProcessor.access$400(this.this$0).getTransFileController().removeHandle(this);
        ForwardImageProcessor.access$500(this.this$0);
      }
      else
      {
        ForwardImageProcessor.access$200(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardImageProcessor.1
 * JD-Core Version:    0.7.0.1
 */