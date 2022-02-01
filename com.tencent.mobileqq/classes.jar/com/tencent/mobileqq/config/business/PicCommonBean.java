package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PicCommonBean
{
  public boolean a = true;
  public int b = 8;
  public long c = 100000000L;
  public int d = 7;
  public long e = 16777216L;
  public long f = 16777216L;
  public int g = -1;
  
  public static PicCommonBean a(QConfItem[] paramArrayOfQConfItem)
  {
    PicCommonBean localPicCommonBean = new PicCommonBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfQConfItem[i];
        if (localObject != null)
        {
          localObject = ((QConfItem)localObject).b;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localPicCommonBean);
            b(localJSONObject, localPicCommonBean);
            c(localJSONObject, localPicCommonBean);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse: ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(" bean:");
            localStringBuilder.append(localPicCommonBean);
            QLog.i("PicCommonBean", 2, localStringBuilder.toString());
          }
        }
        i += 1;
      }
    }
    if (localPicCommonBean.b < 0) {
      localPicCommonBean.b = 8;
    }
    if (localPicCommonBean.c < 0L) {
      localPicCommonBean.c = 100000000L;
    }
    if (localPicCommonBean.d < 1) {
      localPicCommonBean.c = 7L;
    }
    return localPicCommonBean;
  }
  
  private static void a(JSONObject paramJSONObject, PicCommonBean paramPicCommonBean)
  {
    paramJSONObject = paramJSONObject.getJSONObject("regionDecode");
    if (paramJSONObject.has("ramThreshold")) {
      paramPicCommonBean.b = paramJSONObject.optInt("ramThreshold");
    }
    if (paramJSONObject.has("pxThreshold")) {
      paramPicCommonBean.c = paramJSONObject.optLong("pxThreshold");
    }
    if (paramJSONObject.has("threadCount")) {
      paramPicCommonBean.d = paramJSONObject.optInt("threadCount");
    }
    if (paramJSONObject.has("needRegionDecode")) {
      paramPicCommonBean.a = paramJSONObject.optBoolean("needRegionDecode");
    }
  }
  
  private static void b(JSONObject paramJSONObject, PicCommonBean paramPicCommonBean)
  {
    paramJSONObject = paramJSONObject.getJSONObject("uploadLimit");
    if (paramJSONObject.has("c2c")) {
      paramPicCommonBean.e = paramJSONObject.optInt("c2c");
    }
    if (paramJSONObject.has("group")) {
      paramPicCommonBean.f = paramJSONObject.optInt("group");
    }
  }
  
  private static void c(JSONObject paramJSONObject, PicCommonBean paramPicCommonBean)
  {
    paramJSONObject = paramJSONObject.getJSONObject("switchEXIF");
    if (paramJSONObject.has("switch")) {
      paramPicCommonBean.g = paramJSONObject.optInt("switch");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PicCommonBean{needRegionDecode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ramThreshold=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", pxThreshold=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", threadCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", C2C_FileSize_Limit=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", GROUP_FileSize_Limit=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", EXIF_SWITCH=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicCommonBean
 * JD-Core Version:    0.7.0.1
 */