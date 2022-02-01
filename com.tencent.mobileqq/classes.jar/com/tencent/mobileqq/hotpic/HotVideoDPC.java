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
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("StringToInt Exception! ");
        localStringBuilder.append(paramString);
        QLog.d("HotVideoDPC", 2, localStringBuilder.toString());
      }
    }
    return paramInt;
  }
  
  public static HotVideoDPC a()
  {
    HotVideoDPC localHotVideoDPC = jdField_a_of_type_ComTencentMobileqqHotpicHotVideoDPC;
    if ((localHotVideoDPC == null) || (localHotVideoDPC.jdField_a_of_type_Boolean)) {
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
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoDPC", 2, "loadHotVideoDPC!");
    }
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.HotVCfg.name());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("loadHotVideoDPC dpcValue: ");
    ((StringBuilder)localObject).append(str);
    QLog.i("HotVideoDPC", 2, ((StringBuilder)localObject).toString());
    boolean bool1 = TextUtils.isEmpty(str);
    int i1 = 256;
    boolean bool2 = true;
    int i;
    if (!bool1) {
      try
      {
        localObject = str.split("\\|");
        int m;
        int n;
        if ((localObject != null) && (localObject.length >= 3))
        {
          i = a(localObject[0], 0);
          k = i;
          try
          {
            j = a(localObject[1], 0);
            try
            {
              k = a(localObject[2], 256);
              m = i;
              n = j;
            }
            catch (Exception localException1)
            {
              break label272;
            }
            if (localException2 == null) {
              break label209;
            }
          }
          catch (Exception localException2)
          {
            i = k;
          }
        }
        else if (localException2.length == 1)
        {
          i = a(localException2[0], 0);
          try
          {
            QLog.i("HotVideoDPC", 2, "loadHotVideoDPC configs.length == 1");
            j = i;
            i = 1;
            k = i1;
          }
          catch (Exception localException3)
          {
            j = 1;
          }
        }
        for (;;)
        {
          break;
          label209:
          if ((localException3 == null) || (localException3.length != 2)) {
            break label312;
          }
          j = a(localException3[0], 0);
          k = j;
          i = a(localException3[1], 0);
          try
          {
            QLog.i("HotVideoDPC", 2, "loadHotVideoDPC configs.length == 2");
            k = i1;
          }
          catch (Exception localException4)
          {
            k = i;
            i = j;
            j = k;
          }
        }
        label272:
        i = 1;
      }
      catch (Exception localException5)
      {
        i = 0;
        j = 1;
        k = i1;
        m = i;
        n = j;
        if (QLog.isColorLevel())
        {
          QLog.e("HotVideoDPC", 2, "loadHotVideoDPC exception:", localException5);
          n = j;
          m = i;
          k = i1;
        }
        i = n;
        j = m;
      }
    }
    label312:
    int j = 0;
    int k = i1;
    HotVideoDPC localHotVideoDPC = new HotVideoDPC();
    localHotVideoDPC.jdField_a_of_type_Int = j;
    localHotVideoDPC.b = i;
    localHotVideoDPC.c = k;
    bool1 = bool2;
    if (str != null) {
      if (str.isEmpty()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    localHotVideoDPC.jdField_a_of_type_Boolean = bool1;
    return localHotVideoDPC;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hotVideoSwitch: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" hotVideoBlurSwitch: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" hotVideoBlurMemory: ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotVideoDPC
 * JD-Core Version:    0.7.0.1
 */