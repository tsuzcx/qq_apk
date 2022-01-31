package com.tencent.mobileqq.nearby;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class NearbyJsInterface$7
  implements Runnable
{
  NearbyJsInterface$7(NearbyJsInterface paramNearbyJsInterface, String paramString, long paramLong) {}
  
  public void run()
  {
    int j = 0;
    try
    {
      JSONArray localJSONArray = new JSONArray(new JSONObject(this.jdField_a_of_type_JavaLangString).optString("imageArray"));
      int i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("nearby.img.preload", 2, "preloadImage: size=" + localJSONArray.length());
        i = j;
      }
      while (i < localJSONArray.length())
      {
        String str = localJSONArray.getString(i);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
        if (QLog.isColorLevel()) {
          QLog.d("nearby.img.preload", 2, "preloadImg:" + str);
        }
        localURLDrawable.downloadImediatly(false);
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("nearby.img.preload", 2, "preloadImage failed!:" + localException.toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.img.preload", 2, "preloadImage: costTime=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.7
 * JD-Core Version:    0.7.0.1
 */