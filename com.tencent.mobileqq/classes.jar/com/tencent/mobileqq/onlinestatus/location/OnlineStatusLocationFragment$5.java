package com.tencent.mobileqq.onlinestatus.location;

import aobu;
import com.tencent.mobileqq.location.ui.LocationMapWidget;

class OnlineStatusLocationFragment$5
  implements Runnable
{
  OnlineStatusLocationFragment$5(OnlineStatusLocationFragment paramOnlineStatusLocationFragment) {}
  
  public void run()
  {
    if (OnlineStatusLocationFragment.a(this.this$0) != null)
    {
      OnlineStatusLocationFragment.a(this.this$0).onStop();
      OnlineStatusLocationFragment.a(this.this$0).onDestroy();
      OnlineStatusLocationFragment.a(this.this$0, null);
    }
    if (this.this$0.a != null) {
      this.this$0.a = null;
    }
    if (OnlineStatusLocationFragment.a(this.this$0) != null) {
      OnlineStatusLocationFragment.a(this.this$0).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment.5
 * JD-Core Version:    0.7.0.1
 */