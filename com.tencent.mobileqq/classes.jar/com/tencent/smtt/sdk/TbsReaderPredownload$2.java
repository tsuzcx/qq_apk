package com.tencent.smtt.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;

class TbsReaderPredownload$2
  extends Handler
{
  TbsReaderPredownload$2(TbsReaderPredownload paramTbsReaderPredownload, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.this$0.mFileDownloads.isEmpty()) || (this.this$0.mDownloadPaused));
      paramMessage = (String)this.this$0.mFileDownloads.removeFirst();
      this.this$0.mPluginExt = paramMessage;
    } while (this.this$0.requestPlugin(paramMessage));
    this.this$0.notifyCallback(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderPredownload.2
 * JD-Core Version:    0.7.0.1
 */