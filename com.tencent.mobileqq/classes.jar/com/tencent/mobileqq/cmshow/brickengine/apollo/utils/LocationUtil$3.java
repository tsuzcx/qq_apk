package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.view.View;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import org.json.JSONObject;

final class LocationUtil$3
  implements APICallback
{
  LocationUtil$3(View paramView, DoraemonAPIManager paramDoraemonAPIManager, long paramLong, int paramInt, String paramString) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    LocationUtil.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location login permision code");
  }
  
  public void a(int paramInt, String paramString)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    DoraemonAPIManager localDoraemonAPIManager = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager;
    long l = this.jdField_a_of_type_Long;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("location login failed,");
    localStringBuilder.append(paramString);
    LocationUtil.a(localView, localDoraemonAPIManager, l, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, localStringBuilder.toString());
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LocationUtil.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.LocationUtil.3
 * JD-Core Version:    0.7.0.1
 */