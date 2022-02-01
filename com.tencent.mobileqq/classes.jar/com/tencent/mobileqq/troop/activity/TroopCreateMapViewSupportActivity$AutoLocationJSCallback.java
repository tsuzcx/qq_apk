package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView.AutoLocationCallback;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateMapViewSupportActivity$AutoLocationJSCallback
  implements AutoLocationMapView.AutoLocationCallback
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<TroopCreateMapViewSupportActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public void a(int paramInt, GeoPoint paramGeoPoint)
  {
    TroopCreateMapViewSupportActivity localTroopCreateMapViewSupportActivity = (TroopCreateMapViewSupportActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localTroopCreateMapViewSupportActivity == null) {
      return;
    }
    localTroopCreateMapViewSupportActivity.stopTitleProgress();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("result", paramInt);
        if (paramGeoPoint != null)
        {
          paramInt = paramGeoPoint.getLatitudeE6();
          double d1 = paramInt;
          Double.isNaN(d1);
          d1 /= 1000000.0D;
          paramInt = paramGeoPoint.getLongitudeE6();
          double d2 = paramInt;
          Double.isNaN(d2);
          d2 /= 1000000.0D;
          localJSONObject.put("latitude", d1);
          localJSONObject.put("longitude", d2);
        }
      }
      catch (JSONException paramGeoPoint)
      {
        paramGeoPoint.printStackTrace();
      }
      localTroopCreateMapViewSupportActivity.a(this.jdField_a_of_type_JavaLangString, localJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateMapViewSupportActivity.AutoLocationJSCallback
 * JD-Core Version:    0.7.0.1
 */