package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import azhq;
import java.util.ArrayList;

class OnlineStatusPanel$2
  implements Runnable
{
  OnlineStatusPanel$2(OnlineStatusPanel paramOnlineStatusPanel, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList1 = azhq.a().a();
    ArrayList localArrayList2 = this.this$0.a.a;
    ((Activity)this.this$0.getContext()).runOnUiThread(new OnlineStatusPanel.2.1(this, localArrayList1, localArrayList1, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.2
 * JD-Core Version:    0.7.0.1
 */