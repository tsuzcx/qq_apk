package com.tencent.mobileqq.location.ui;

import atnf;

class LocationPickFragment$12
  implements Runnable
{
  LocationPickFragment$12(LocationPickFragment paramLocationPickFragment) {}
  
  public void run()
  {
    if (LocationPickFragment.a(this.this$0) != null)
    {
      LocationPickFragment.a(this.this$0).onStop();
      LocationPickFragment.a(this.this$0).onDestroy();
      LocationPickFragment.a(this.this$0, null);
    }
    if (LocationPickFragment.a(this.this$0) != null)
    {
      LocationPickFragment.a(this.this$0).a();
      LocationPickFragment.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.12
 * JD-Core Version:    0.7.0.1
 */