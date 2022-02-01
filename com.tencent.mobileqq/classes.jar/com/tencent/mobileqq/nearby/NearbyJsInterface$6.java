package com.tencent.mobileqq.nearby;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class NearbyJsInterface$6
  implements Runnable
{
  NearbyJsInterface$6(NearbyJsInterface paramNearbyJsInterface, String paramString, long paramLong) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        localJSONArray = new JSONArray(new JSONObject(this.a).optString("imageArray"));
        if (!QLog.isColorLevel()) {
          break label230;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadImage: size=");
        ((StringBuilder)localObject).append(localJSONArray.length());
        QLog.d("nearby.img.preload", 2, ((StringBuilder)localObject).toString());
      }
      catch (Exception localException)
      {
        JSONArray localJSONArray;
        URLDrawable localURLDrawable;
        StringBuilder localStringBuilder2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadImage failed!:");
        ((StringBuilder)localObject).append(localException.toString());
        QLog.e("nearby.img.preload", 2, ((StringBuilder)localObject).toString());
        if (!QLog.isColorLevel()) {
          continue;
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("preloadImage: costTime=");
        localStringBuilder1.append(System.currentTimeMillis() - this.b);
        QLog.d("nearby.img.preload", 2, localStringBuilder1.toString());
        return;
      }
      if (i < localJSONArray.length())
      {
        localObject = localJSONArray.getString(i);
        localURLDrawable = URLDrawable.getDrawable((String)localObject, URLDrawable.URLDrawableOptions.obtain());
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("preloadImg:");
          localStringBuilder2.append((String)localObject);
          QLog.d("nearby.img.preload", 2, localStringBuilder2.toString());
        }
        localURLDrawable.downloadImediatly(false);
        i += 1;
      }
      else
      {
        label230:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface.6
 * JD-Core Version:    0.7.0.1
 */