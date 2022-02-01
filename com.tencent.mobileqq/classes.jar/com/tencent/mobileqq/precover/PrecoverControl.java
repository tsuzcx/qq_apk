package com.tencent.mobileqq.precover;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class PrecoverControl
{
  public int a;
  public String a;
  public boolean a;
  public int b = 3;
  public int c = 1000;
  public int d = 3600;
  public int e = 1;
  public int f = 5;
  
  public PrecoverControl()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  private static int a(String paramString, int paramInt)
  {
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0) {
        return paramInt;
      }
    }
    catch (Throwable paramString)
    {
      return paramInt;
    }
    return i;
  }
  
  public static PrecoverControl a()
  {
    PrecoverControl localPrecoverControl1 = new PrecoverControl();
    str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.precover.name());
    localPrecoverControl1.jdField_a_of_type_JavaLangString = str;
    localPrecoverControl1.jdField_a_of_type_Boolean = true;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        if (arrayOfString.length >= 6)
        {
          localPrecoverControl1.jdField_a_of_type_Boolean = false;
          localPrecoverControl1.jdField_a_of_type_Int = a(arrayOfString[0], 0);
          localPrecoverControl1.b = a(arrayOfString[1], 3);
          localPrecoverControl1.c = a(arrayOfString[2], 1000);
          localPrecoverControl1.d = a(arrayOfString[3], 3600);
          localPrecoverControl1.e = a(arrayOfString[4], 1);
          localPrecoverControl1.f = a(arrayOfString[5], 5);
          if ((localPrecoverControl1.jdField_a_of_type_Int != 0) && (localPrecoverControl1.jdField_a_of_type_Int != 1) && (localPrecoverControl1.jdField_a_of_type_Int != 2)) {
            localPrecoverControl1.jdField_a_of_type_Int = 0;
          }
          if ((localPrecoverControl1.e != 0) && (localPrecoverControl1.e != 1)) {
            localPrecoverControl1.e = 1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("PrecoverControl", 1, "create Exception:" + localException.toString());
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        PrecoverControl localPrecoverControl2 = new PrecoverControl();
        localPrecoverControl2.jdField_a_of_type_JavaLangString = str;
        localPrecoverControl2.jdField_a_of_type_Boolean = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localPrecoverControl1);
    }
    return localPrecoverControl1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.jdField_a_of_type_Boolean).append(", network=").append(this.jdField_a_of_type_Int).append(", itemRetry=").append(this.b).append(", totalRetry=").append(this.c).append(", lbsExpire=").append(this.d).append(", open=").append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.precover.PrecoverControl
 * JD-Core Version:    0.7.0.1
 */