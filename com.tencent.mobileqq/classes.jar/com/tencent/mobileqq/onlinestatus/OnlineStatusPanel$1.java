package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import azbj;
import azca;
import java.util.ArrayList;

class OnlineStatusPanel$1
  implements Runnable
{
  OnlineStatusPanel$1(OnlineStatusPanel paramOnlineStatusPanel) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList(0);
    ArrayList localArrayList2 = new ArrayList(0);
    if (OnlineStatusPanel.a(this.this$0) != null) {
      if (OnlineStatusPanel.a(this.this$0).a() == null) {
        if (OnlineStatusPanel.a(this.this$0).b() != null) {
          break label98;
        }
      }
    }
    for (;;)
    {
      ((Activity)this.this$0.getContext()).runOnUiThread(new OnlineStatusPanel.1.1(this, localArrayList1, localArrayList2));
      return;
      localArrayList1 = OnlineStatusPanel.a(this.this$0).a();
      break;
      label98:
      localArrayList2 = OnlineStatusPanel.a(this.this$0).b();
      continue;
      localArrayList1 = azbj.a().a();
      localArrayList2 = this.this$0.a.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.1
 * JD-Core Version:    0.7.0.1
 */