package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import java.util.ArrayList;

class OnlineStatusPanel$1
  implements Runnable
{
  OnlineStatusPanel$1(OnlineStatusPanel paramOnlineStatusPanel) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList(0);
    ArrayList localArrayList = new ArrayList(0);
    Object localObject2;
    if (OnlineStatusPanel.a(this.this$0) != null)
    {
      if (OnlineStatusPanel.a(this.this$0).a() != null) {
        localObject1 = OnlineStatusPanel.a(this.this$0).a();
      }
      if (OnlineStatusPanel.a(this.this$0).b() == null)
      {
        localObject2 = localObject1;
        localObject1 = localArrayList;
      }
      else
      {
        localArrayList = OnlineStatusPanel.a(this.this$0).b();
        localObject2 = localObject1;
        localObject1 = localArrayList;
      }
    }
    else
    {
      localObject2 = OnLineStatusHelper.a().a();
      localObject1 = this.this$0.a.a;
    }
    ((Activity)this.this$0.getContext()).runOnUiThread(new OnlineStatusPanel.1.1(this, (ArrayList)localObject2, (ArrayList)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.1
 * JD-Core Version:    0.7.0.1
 */