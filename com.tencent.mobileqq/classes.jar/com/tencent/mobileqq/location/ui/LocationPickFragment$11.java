package com.tencent.mobileqq.location.ui;

import arat;

class LocationPickFragment$11
  implements Runnable
{
  LocationPickFragment$11(LocationPickFragment paramLocationPickFragment) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.11
 * JD-Core Version:    0.7.0.1
 */