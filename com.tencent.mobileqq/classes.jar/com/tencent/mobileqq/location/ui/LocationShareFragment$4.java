package com.tencent.mobileqq.location.ui;

import com.tencent.mobileqq.location.net.LocationHandler;

class LocationShareFragment$4
  implements Runnable
{
  LocationShareFragment$4(LocationShareFragment paramLocationShareFragment) {}
  
  public void run()
  {
    LocationHandler.a().c();
    if (LocationShareFragment.a(this.this$0) != null)
    {
      LocationShareFragment.a(this.this$0).onStop();
      LocationShareFragment.a(this.this$0).onDestroy();
      LocationShareFragment.a(this.this$0, null);
    }
    if (LocationShareFragment.a(this.this$0) != null) {
      LocationShareFragment.a(this.this$0, null);
    }
    if (LocationShareFragment.a(this.this$0) != null)
    {
      LocationShareFragment.a(this.this$0).a();
      LocationShareFragment.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareFragment.4
 * JD-Core Version:    0.7.0.1
 */