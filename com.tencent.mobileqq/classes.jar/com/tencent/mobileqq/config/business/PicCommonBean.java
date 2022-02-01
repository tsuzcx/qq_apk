package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PicCommonBean
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public long c;
  
  public PicCommonBean()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 8;
    this.jdField_a_of_type_Long = 100000000L;
    this.jdField_b_of_type_Int = 7;
    this.jdField_b_of_type_Long = 16777216L;
    this.jdField_c_of_type_Long = 16777216L;
    this.jdField_c_of_type_Int = -1;
  }
  
  public static PicCommonBean a(QConfItem[] paramArrayOfQConfItem)
  {
    PicCommonBean localPicCommonBean = new PicCommonBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfQConfItem[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((QConfItem)localObject).a;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localPicCommonBean);
            b(localJSONObject, localPicCommonBean);
            c(localJSONObject, localPicCommonBean);
            if (QLog.isColorLevel()) {
              QLog.i("PicCommonBean", 2, "parse: " + (String)localObject + " bean:" + localPicCommonBean);
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    if (localPicCommonBean.jdField_a_of_type_Int < 0) {
      localPicCommonBean.jdField_a_of_type_Int = 8;
    }
    if (localPicCommonBean.jdField_a_of_type_Long < 0L) {
      localPicCommonBean.jdField_a_of_type_Long = 100000000L;
    }
    if (localPicCommonBean.jdField_b_of_type_Int < 1) {
      localPicCommonBean.jdField_a_of_type_Long = 7L;
    }
    return localPicCommonBean;
  }
  
  private static void a(JSONObject paramJSONObject, PicCommonBean paramPicCommonBean)
  {
    paramJSONObject = paramJSONObject.getJSONObject("regionDecode");
    if (paramJSONObject.has("ramThreshold")) {
      paramPicCommonBean.jdField_a_of_type_Int = paramJSONObject.optInt("ramThreshold");
    }
    if (paramJSONObject.has("pxThreshold")) {
      paramPicCommonBean.jdField_a_of_type_Long = paramJSONObject.optLong("pxThreshold");
    }
    if (paramJSONObject.has("threadCount")) {
      paramPicCommonBean.jdField_b_of_type_Int = paramJSONObject.optInt("threadCount");
    }
    if (paramJSONObject.has("needRegionDecode")) {
      paramPicCommonBean.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needRegionDecode");
    }
  }
  
  private static void b(JSONObject paramJSONObject, PicCommonBean paramPicCommonBean)
  {
    paramJSONObject = paramJSONObject.getJSONObject("uploadLimit");
    if (paramJSONObject.has("c2c")) {
      paramPicCommonBean.jdField_b_of_type_Long = paramJSONObject.optInt("c2c");
    }
    if (paramJSONObject.has("group")) {
      paramPicCommonBean.jdField_c_of_type_Long = paramJSONObject.optInt("group");
    }
  }
  
  private static void c(JSONObject paramJSONObject, PicCommonBean paramPicCommonBean)
  {
    paramJSONObject = paramJSONObject.getJSONObject("switchEXIF");
    if (paramJSONObject.has("switch")) {
      paramPicCommonBean.jdField_c_of_type_Int = paramJSONObject.optInt("switch");
    }
  }
  
  public String toString()
  {
    return "PicCommonBean{needRegionDecode=" + this.jdField_a_of_type_Boolean + ", ramThreshold=" + this.jdField_a_of_type_Int + ", pxThreshold=" + this.jdField_a_of_type_Long + ", threadCount=" + this.jdField_b_of_type_Int + ", C2C_FileSize_Limit=" + this.jdField_b_of_type_Long + ", GROUP_FileSize_Limit=" + this.jdField_c_of_type_Long + ", EXIF_SWITCH=" + this.jdField_c_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicCommonBean
 * JD-Core Version:    0.7.0.1
 */