package com.tencent.mobileqq.vas.VasResEngine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

class VasResController$2
  implements Runnable
{
  VasResController$2(VasResController paramVasResController, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    String[] arrayOfString = this.this$0.a(this.a);
    Message localMessage = VasResController.a(this.this$0).obtainMessage();
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 1);
    localBundle.putStringArray("pngs", arrayOfString);
    localBundle.putInt("interval", this.b);
    localBundle.putInt("repeatTimes", this.c);
    localMessage.setData(localBundle);
    localMessage.what = 10001;
    VasResController.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResController.2
 * JD-Core Version:    0.7.0.1
 */