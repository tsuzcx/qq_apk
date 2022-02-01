package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import org.json.JSONObject;

final class LocationUtil$1
  implements APICallback
{
  LocationUtil$1(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    LocationUtil.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, this.jdField_a_of_type_Double, this.b, this.c, this.d, this.e, this.f, "", paramInt, "location city failed permission");
  }
  
  public void a(int paramInt, String paramString)
  {
    LocationUtil.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, this.jdField_a_of_type_Double, this.b, this.c, this.d, this.e, this.f, "", paramInt, "location city failed");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("city", "");
    LocationUtil.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, this.jdField_a_of_type_Double, this.b, this.c, this.d, this.e, this.f, paramJSONObject, 0, "location success");
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.LocationUtil.1
 * JD-Core Version:    0.7.0.1
 */