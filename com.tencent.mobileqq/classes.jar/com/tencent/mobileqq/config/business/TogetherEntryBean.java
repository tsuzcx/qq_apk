package com.tencent.mobileqq.config.business;

import android.graphics.Color;
import com.tencent.mobileqq.together.TogetherEntryData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

public class TogetherEntryBean
{
  public int a;
  public ArrayList<TogetherEntryData> a;
  public boolean a;
  
  public TogetherEntryBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(4);
  }
  
  public static TogetherEntryBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      TogetherEntryBean localTogetherEntryBean = new TogetherEntryBean();
      paramString = new JSONObject(paramString);
      localTogetherEntryBean.jdField_a_of_type_Boolean = paramString.optBoolean("showEntrance", false);
      localTogetherEntryBean.jdField_a_of_type_Int = paramString.optInt("bannerInterval", 10);
      paramString = paramString.optJSONArray("array");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          JSONObject localJSONObject = (JSONObject)paramString.get(i);
          TogetherEntryData localTogetherEntryData = new TogetherEntryData();
          localTogetherEntryData.jdField_b_of_type_Int = localJSONObject.optInt("id");
          localTogetherEntryData.jdField_c_of_type_Int = localJSONObject.optInt("order");
          localTogetherEntryData.a = localJSONObject.optString("title");
          localTogetherEntryData.jdField_b_of_type_JavaLangString = localJSONObject.optString("subTitle");
          localTogetherEntryData.d = Color.parseColor(localJSONObject.optString("bgColor"));
          localTogetherEntryData.jdField_c_of_type_JavaLangString = localJSONObject.optString("imageUrl");
          localTogetherEntryBean.jdField_a_of_type_JavaUtilArrayList.add(localTogetherEntryData);
          i += 1;
        }
      }
      Collections.sort(localTogetherEntryBean.jdField_a_of_type_JavaUtilArrayList, new TogetherEntryBean.1());
      QLog.d("TogetherEntryConfProcessor", 2, "confBean = " + localTogetherEntryBean.toString());
      return localTogetherEntryBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TogetherEntryConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public String toString()
  {
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TogetherEntryBean
 * JD-Core Version:    0.7.0.1
 */