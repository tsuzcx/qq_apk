package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import java.util.ArrayList;

class OnlineStatusPanel$2
  implements Runnable
{
  OnlineStatusPanel$2(OnlineStatusPanel paramOnlineStatusPanel, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList(0);
    ArrayList localArrayList = new ArrayList(0);
    Object localObject2;
    if (OnlineStatusPanel.a(this.this$0) != null)
    {
      if (OnlineStatusPanel.a(this.this$0).d() != null) {
        localObject1 = OnlineStatusPanel.a(this.this$0).d();
      }
      if (OnlineStatusPanel.a(this.this$0).e() == null)
      {
        localObject2 = localObject1;
        localObject1 = localArrayList;
      }
      else
      {
        localArrayList = OnlineStatusPanel.a(this.this$0).e();
        localObject2 = localObject1;
        localObject1 = localArrayList;
      }
    }
    else
    {
      localObject2 = OnLineStatusHelper.a().b();
      localObject1 = this.this$0.b.a;
    }
    ((Activity)this.this$0.getContext()).runOnUiThread(new OnlineStatusPanel.2.1(this, (ArrayList)localObject2, (ArrayList)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.2
 * JD-Core Version:    0.7.0.1
 */