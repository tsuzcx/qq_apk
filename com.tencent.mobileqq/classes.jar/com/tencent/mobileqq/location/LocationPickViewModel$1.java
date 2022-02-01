package com.tencent.mobileqq.location;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.location.ui.LocationPickAdaptor;
import com.tencent.mobileqq.widget.QQToast;

class LocationPickViewModel$1
  implements Runnable
{
  LocationPickViewModel$1(LocationPickViewModel paramLocationPickViewModel) {}
  
  public void run()
  {
    if (LocationPickViewModel.a(this.this$0).getCount() <= 0) {
      this.this$0.b.setValue(Integer.valueOf(2));
    }
    QQToast.makeText(LocationPickViewModel.b(this.this$0), 1, 2131891397, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationPickViewModel.1
 * JD-Core Version:    0.7.0.1
 */