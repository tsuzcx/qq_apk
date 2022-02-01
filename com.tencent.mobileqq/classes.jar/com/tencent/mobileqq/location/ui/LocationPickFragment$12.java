package com.tencent.mobileqq.location.ui;

class LocationPickFragment$12
  implements Runnable
{
  LocationPickFragment$12(LocationPickFragment paramLocationPickFragment) {}
  
  public void run()
  {
    if (LocationPickFragment.f(this.this$0) != null)
    {
      LocationPickFragment.f(this.this$0).onStop();
      LocationPickFragment.f(this.this$0).onDestroy();
      LocationPickFragment.a(this.this$0, null);
    }
    if (LocationPickFragment.b(this.this$0) != null)
    {
      LocationPickFragment.b(this.this$0).g();
      LocationPickFragment.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.12
 * JD-Core Version:    0.7.0.1
 */