package com.tencent.mobileqq.conditionsearch.data;

import ajyc;
import android.text.TextUtils;
import bbjw;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AddressData
{
  public static final String a;
  public HashMap<String, BaseAddress> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131699868);
  }
  
  public AddressData()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(30);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    default: 
      return 0;
    case 2: 
    case 3: 
      return 1;
    case 4: 
    case 5: 
      return 2;
    }
    return 3;
  }
  
  private int a(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    for (;;)
    {
      if (paramInt1 >= paramInt2) {}
      do
      {
        return -1;
        int i = paramInt1 + 1;
        if (!TextUtils.isEmpty(paramArrayOfString[paramInt1]))
        {
          int j = i + 1;
          paramInt1 = j;
          if (!TextUtils.isEmpty(paramArrayOfString[i])) {
            return j - 2;
          }
        }
        else
        {
          paramInt1 = i;
        }
      } while (paramInt1 >= paramInt2 - 1);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  public boolean a(AppInterface paramAppInterface, String paramString)
  {
    if (paramString.startsWith(jdField_a_of_type_JavaLangString)) {
      return false;
    }
    Object localObject2 = bbjw.a(paramString, '|');
    if ((paramString.startsWith("#")) || (localObject2.length < 2)) {
      return true;
    }
    int i = localObject2.length;
    paramString = localObject2[0];
    Object localObject1 = localObject2[1];
    paramAppInterface = (BaseAddress)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramAppInterface == null)
    {
      paramAppInterface = new BaseAddress((String)localObject1, paramString, a(1));
      this.jdField_a_of_type_JavaUtilHashMap.put("0", new BaseAddress("不限", "0", 0));
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramAppInterface);
    }
    for (;;)
    {
      int k = a(2, i, (String[])localObject2);
      if (k == -1) {
        return true;
      }
      int j = k + 1;
      localObject1 = localObject2[k];
      k = j + 1;
      String str1 = localObject2[j];
      paramString = (BaseAddress)paramAppInterface.dataMap.get(localObject1);
      if (paramString == null)
      {
        j = a(k - 1);
        paramString = new BaseAddress(str1, (String)localObject1, j);
        paramAppInterface.dataMap.put("0", new BaseAddress("不限", "0", j));
        paramAppInterface.dataMap.put(localObject1, paramString);
        paramAppInterface.hasProvince = true;
      }
      for (;;)
      {
        k = a(k, i, (String[])localObject2);
        if (k == -1) {
          return true;
        }
        j = k + 1;
        str1 = localObject2[k];
        k = j + 1;
        String str2 = localObject2[j];
        localObject1 = (BaseAddress)paramString.dataMap.get(str1);
        if (localObject1 == null)
        {
          j = a(k - 1);
          localObject1 = new BaseAddress(str2, str1, j);
          paramString.dataMap.put("0", new BaseAddress("不限", "0", j));
          paramString.dataMap.put(str1, localObject1);
          paramAppInterface.hasCity = true;
        }
        for (paramString = (String)localObject1;; paramString = (String)localObject1)
        {
          i = a(k, i, (String[])localObject2);
          if (i == -1) {
            return true;
          }
          j = i + 1;
          localObject1 = localObject2[i];
          localObject2 = localObject2[j];
          if ((BaseAddress)paramString.dataMap.get(localObject1) == null)
          {
            i = a(j + 1 - 1);
            localObject2 = new BaseAddress((String)localObject2, (String)localObject1, i);
            paramString.dataMap.put("0", new BaseAddress("不限", "0", i));
            paramString.dataMap.put(localObject1, localObject2);
            paramAppInterface.hasDistrict = true;
          }
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.data.AddressData
 * JD-Core Version:    0.7.0.1
 */