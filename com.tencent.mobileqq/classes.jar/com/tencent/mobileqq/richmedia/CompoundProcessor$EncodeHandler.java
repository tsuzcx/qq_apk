package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class CompoundProcessor$EncodeHandler
  extends Handler
{
  public CompoundProcessor$EncodeHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage, msg.what = ");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append(",msg.arg1 = ");
    localStringBuilder.append(paramMessage.arg1);
    LOG.a("CompoundProcessor", localStringBuilder.toString());
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        i = paramMessage.arg1;
        if (paramMessage.arg1 != 0) {
          return;
        }
        paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ret is ");
        localStringBuilder.append(i);
        localStringBuilder.append(",targetFile is ");
        localStringBuilder.append(paramMessage);
        LOG.a("CompoundProcessor", localStringBuilder.toString());
        return;
      }
      i = paramMessage.arg1;
      paramMessage = paramMessage.getData();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ret is ");
      localStringBuilder.append(i);
      localStringBuilder.append(",data is ");
      localStringBuilder.append(paramMessage);
      LOG.a("CompoundProcessor", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.CompoundProcessor.EncodeHandler
 * JD-Core Version:    0.7.0.1
 */