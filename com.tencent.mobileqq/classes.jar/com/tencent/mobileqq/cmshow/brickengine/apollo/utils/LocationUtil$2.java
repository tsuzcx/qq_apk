package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import org.json.JSONObject;

final class LocationUtil$2
  implements APICallback
{
  LocationUtil$2(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, int paramInt) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    LocationUtil.a(this.a, this.b, this.c, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location permision code");
  }
  
  public void a(int paramInt, String paramString)
  {
    View localView = this.a;
    DoraemonAPIManager localDoraemonAPIManager = this.b;
    long l = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("location failed,");
    localStringBuilder.append(paramString);
    LocationUtil.a(localView, localDoraemonAPIManager, l, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, localStringBuilder.toString());
  }
  
  public void a(JSONObject paramJSONObject)
  {
    double d1 = paramJSONObject.optDouble("altitude", 0.0D);
    double d2 = paramJSONObject.optDouble("latitude", 0.0D);
    double d3 = paramJSONObject.optDouble("longitude", 0.0D);
    double d4 = paramJSONObject.optDouble("horizontalAccuracy", 0.0D);
    paramJSONObject.optDouble("verticalAccuracy", 0.0D);
    paramJSONObject.optDouble("accuracy", 0.0D);
    double d5 = paramJSONObject.optDouble("speed", 0.0D);
    if (this.d == 1)
    {
      LocationUtil.a(this.a, this.b, this.c, d4, d2, d3, d5, d1, 0.0D);
      return;
    }
    LocationUtil.a(this.a, this.b, this.c, d4, d2, d3, d5, d1, 0.0D, "", 0, "location success");
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.LocationUtil.2
 * JD-Core Version:    0.7.0.1
 */