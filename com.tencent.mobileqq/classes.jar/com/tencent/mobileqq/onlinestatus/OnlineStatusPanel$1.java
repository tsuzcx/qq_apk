package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import auja;
import java.util.ArrayList;

class OnlineStatusPanel$1
  implements Runnable
{
  OnlineStatusPanel$1(OnlineStatusPanel paramOnlineStatusPanel) {}
  
  public void run()
  {
    ArrayList localArrayList = auja.a().a();
    ((Activity)this.this$0.getContext()).runOnUiThread(new OnlineStatusPanel.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.1
 * JD-Core Version:    0.7.0.1
 */