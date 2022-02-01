package com.tencent.mobileqq.hotpic;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class HotVideoDPC
{
  public static HotVideoDPC a;
  public int a;
  public boolean a;
  public int b = 1;
  public int c = 256;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqHotpicHotVideoDPC = null;
  }
  
  public HotVideoDPC()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static int a()
  {
    HotVideoDPC localHotVideoDPC = a();
    if (localHotVideoDPC != null) {
      return localHotVideoDPC.c;
    }
    return 256;
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      return paramInt;
      try
      {
        int i = Integer.valueOf(paramString).intValue();
        return i;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("HotVideoDPC", 2, "StringToInt Exception! " + paramString);
    return paramInt;
  }
  
  public static HotVideoDPC a()
  {
    if ((jdField_a_of_type_ComTencentMobileqqHotpicHotVideoDPC == null) || (jdField_a_of_type_ComTencentMobileqqHotpicHotVideoDPC.jdField_a_of_type_Boolean)) {
      jdField_a_of_type_ComTencentMobileqqHotpicHotVideoDPC = b();
    }
    return jdField_a_of_type_ComTencentMobileqqHotpicHotVideoDPC;
  }
  
  public static boolean a()
  {
    HotVideoDPC localHotVideoDPC = a();
    return (localHotVideoDPC != null) && (localHotVideoDPC.b == 1);
  }
  
  public static HotVideoDPC b()
  {
    int i1 = 256;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoDPC", 2, "loadHotVideoDPC!");
    }
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.HotVCfg.name());
    QLog.i("HotVideoDPC", 2, "loadHotVideoDPC dpcValue: " + str);
    int i;
    int j;
    int m;
    int k;
    label131:
    int n;
    if (!TextUtils.isEmpty(str))
    {
      try
      {
        localObject = str.split("\\|");
        if ((localObject != null) && (localObject.length >= 3)) {
          i = a(localObject[0], 0);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            Object localObject;
            i = a(localObject[1], 0);
          }
          catch (Exception localException5)
          {
            i = 1;
            j = k;
            continue;
          }
          try
          {
            QLog.i("HotVideoDPC", 2, "loadHotVideoDPC configs.length == 2");
            j = i;
            i = 256;
          }
          catch (Exception localException6)
          {
            j = k;
            continue;
          }
          localException1 = localException1;
          j = 0;
          i = 1;
          m = i;
          n = i1;
          k = j;
          if (QLog.isColorLevel())
          {
            QLog.e("HotVideoDPC", 2, "loadHotVideoDPC exception:", localException1);
            m = i;
            n = i1;
            k = j;
          }
        }
      }
      try
      {
        j = a(localObject[1], 0);
      }
      catch (Exception localException2)
      {
        j = i;
        i = 1;
        break label283;
      }
      try
      {
        m = a(localObject[2], 256);
        k = i;
        i = m;
      }
      catch (Exception localException3)
      {
        k = i;
        i = j;
        j = k;
        break label283;
        break label131;
      }
      n = i;
      m = j;
    }
    for (;;)
    {
      for (;;)
      {
        localObject = new HotVideoDPC();
        ((HotVideoDPC)localObject).jdField_a_of_type_Int = k;
        ((HotVideoDPC)localObject).b = m;
        ((HotVideoDPC)localObject).c = n;
        if ((str == null) || (str.isEmpty())) {
          bool = true;
        }
        ((HotVideoDPC)localObject).jdField_a_of_type_Boolean = bool;
        return localObject;
        if ((localObject != null) && (localObject.length == 1)) {
          j = a(localObject[0], 0);
        }
        try
        {
          QLog.i("HotVideoDPC", 2, "loadHotVideoDPC configs.length == 1");
          k = j;
          i = 256;
          j = 1;
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            label283:
            i = 1;
          }
          i = 256;
          k = 0;
          j = 1;
        }
      }
      if ((localObject != null) && (localObject.length == 2)) {
        k = a(localObject[0], 0);
      }
      m = 1;
      k = 0;
      n = i1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hotVideoSwitch: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" hotVideoBlurSwitch: ").append(this.b);
    localStringBuilder.append(" hotVideoBlurMemory: ").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoDPC
 * JD-Core Version:    0.7.0.1
 */