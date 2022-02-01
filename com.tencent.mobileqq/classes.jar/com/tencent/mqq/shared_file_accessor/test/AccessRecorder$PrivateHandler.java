package com.tencent.mqq.shared_file_accessor.test;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.FileWriter;
import java.io.IOException;

class AccessRecorder$PrivateHandler
  extends Handler
{
  public static final int MSG_FLUSH_AFTER_LONG_TIME = 1;
  public static final int MSG_WRITE = 0;
  
  public AccessRecorder$PrivateHandler(AccessRecorder paramAccessRecorder, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void write(String paramString)
  {
    if (AccessRecorder.access$100(this.this$0) == null) {
      return;
    }
    try
    {
      AccessRecorder.access$100(this.this$0).write(paramString);
      AccessRecorder.access$100(this.this$0).flush();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return;
    case 0: 
      write((String)???.obj);
      return;
    }
    synchronized (this.this$0)
    {
      sendMessage(Message.obtain(this, 0, AccessRecorder.access$000(this.this$0).toString()));
      AccessRecorder.access$000(this.this$0).setLength(0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.test.AccessRecorder.PrivateHandler
 * JD-Core Version:    0.7.0.1
 */