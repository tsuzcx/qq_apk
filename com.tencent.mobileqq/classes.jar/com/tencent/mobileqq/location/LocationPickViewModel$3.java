package com.tencent.mobileqq.location;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.location.ui.LocationPickAdaptor.OnDataLoadStateChangeListener;

class LocationPickViewModel$3
  implements LocationPickAdaptor.OnDataLoadStateChangeListener
{
  LocationPickViewModel$3(LocationPickViewModel paramLocationPickViewModel) {}
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.a.b.setValue(Integer.valueOf(4));
            return;
          }
          this.a.b.setValue(Integer.valueOf(3));
          return;
        }
        this.a.b.setValue(Integer.valueOf(2));
        return;
      }
      this.a.b.setValue(Integer.valueOf(1));
      return;
    }
    this.a.b.setValue(Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationPickViewModel.3
 * JD-Core Version:    0.7.0.1
 */