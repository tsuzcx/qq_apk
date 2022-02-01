package com.tencent.mobileqq.onlinestatus.location;

import android.text.TextUtils;

public class LocationInfo
{
  public double a;
  public int a;
  public long a;
  public String a;
  public double b;
  public String b;
  public double c;
  public String c;
  
  public LocationInfo(double paramDouble1, double paramDouble2, String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    if (a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, paramString2))
    {
      this.jdField_a_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, String paramString)
  {
    return (Math.abs(paramDouble1) > 0.0001D) && (Math.abs(paramDouble2) > 0.0001D) && (!TextUtils.isEmpty(paramString));
  }
  
  public static boolean a(LocationInfo paramLocationInfo, double paramDouble1, double paramDouble2, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramLocationInfo == null) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramString == null);
          if (!paramString.equals(paramLocationInfo.jdField_c_of_type_JavaLangString)) {
            return true;
          }
          bool1 = bool2;
        } while (Math.abs(paramDouble1) < 0.0001D);
        bool1 = bool2;
      } while (Math.abs(paramDouble2) < 0.0001D);
      if (Math.abs(paramLocationInfo.jdField_a_of_type_Double - paramDouble1) > 0.001D) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(paramLocationInfo.jdField_b_of_type_Double - paramDouble2) <= 0.001D);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("mLatitude:").append(this.jdField_a_of_type_Double);
    localStringBuilder.append(" mLongitude:").append(this.jdField_b_of_type_Double);
    localStringBuilder.append(" mDirection:").append(this.jdField_c_of_type_Double);
    localStringBuilder.append(" mPoiName:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mPoiAddr:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" adCode:").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" mUpdateTime:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" mValidFlag:").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationInfo
 * JD-Core Version:    0.7.0.1
 */