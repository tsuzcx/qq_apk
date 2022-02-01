package com.tencent.mobileqq.location;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.location.ui.LocationPickController;

final class LocationShareViewBinder$5
  implements Observer<Integer>
{
  LocationShareViewBinder$5(LocationPickController paramLocationPickController) {}
  
  public void a(Integer paramInteger)
  {
    int i = paramInteger.intValue();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            this.a.e();
            return;
          }
          this.a.d();
          return;
        }
        this.a.c();
        return;
      }
      this.a.a();
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareViewBinder.5
 * JD-Core Version:    0.7.0.1
 */