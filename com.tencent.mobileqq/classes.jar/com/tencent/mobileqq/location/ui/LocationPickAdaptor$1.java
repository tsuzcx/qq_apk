package com.tencent.mobileqq.location.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import java.util.List;

class LocationPickAdaptor$1
  implements LocationPoiDataFromMapHelper.OnPoiListUpdateListener
{
  LocationPickAdaptor$1(LocationPickAdaptor paramLocationPickAdaptor, String paramString) {}
  
  public void a(List<LocationRoom.Venue> paramList)
  {
    int i;
    if ((LocationPickAdaptor.a(this.b) != null) && (LocationPickAdaptor.a(this.b).size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    LocationPickAdaptor.a(this.b, paramList);
    this.b.notifyDataSetChanged();
    LocationPickAdaptor.a(this.b, TextUtils.isEmpty(this.a));
    if ((LocationPickAdaptor.a(this.b).size() > 0) && (TextUtils.isEmpty(this.a)))
    {
      if (i == 0) {
        this.b.b(0);
      }
    }
    else if (LocationPickAdaptor.b(this.b) != null)
    {
      paramList = LocationPickAdaptor.b(this.b);
      if (LocationPickAdaptor.a(this.b).size() > 0) {
        i = 3;
      } else {
        i = 2;
      }
      paramList.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickAdaptor.1
 * JD-Core Version:    0.7.0.1
 */