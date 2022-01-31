package com.tencent.smtt.utils;

import android.widget.TextView;

class TbsLogClient$LogRunnable
  implements Runnable
{
  String mLog = null;
  
  TbsLogClient$LogRunnable(TbsLogClient paramTbsLogClient, String paramString)
  {
    this.mLog = paramString;
  }
  
  public void run()
  {
    if (this.this$0.mView != null) {
      this.this$0.mView.append(this.mLog + "\n");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsLogClient.LogRunnable
 * JD-Core Version:    0.7.0.1
 */