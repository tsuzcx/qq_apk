package com.tencent.mobileqq.conditionsearch.data;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AddressData
{
  public static final String a = HardCodeUtil.a(2131898143);
  public HashMap<String, BaseAddress> b = new HashMap(30);
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 6: 
    case 7: 
      return 3;
    case 4: 
    case 5: 
      return 2;
    case 2: 
    case 3: 
      return 1;
    }
    return 0;
  }
  
  private int a(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    int i = paramInt1;
    do
    {
      if (i >= paramInt2) {
        return -1;
      }
      int j = i + 1;
      if (!TextUtils.isEmpty(paramArrayOfString[i]))
      {
        i = j + 1;
        paramInt1 = i;
        if (!TextUtils.isEmpty(paramArrayOfString[j])) {
          return i - 2;
        }
      }
      else
      {
        paramInt1 = j;
      }
      i = paramInt1;
    } while (paramInt1 < paramInt2 - 1);
    return -1;
  }
  
  public void a()
  {
    HashMap localHashMap = this.b;
    if (localHashMap != null)
    {
      localHashMap.clear();
      this.b = null;
    }
  }
  
  public boolean a(AppInterface paramAppInterface, String paramString)
  {
    if (paramString.startsWith(a)) {
      return false;
    }
    String[] arrayOfString = StringUtil.split(paramString, '|');
    if (!paramString.startsWith("#"))
    {
      if (arrayOfString.length < 2) {
        return true;
      }
      int i = arrayOfString.length;
      Object localObject1 = arrayOfString[0];
      Object localObject2 = arrayOfString[1];
      paramString = (BaseAddress)this.b.get(localObject1);
      paramAppInterface = paramString;
      if (paramString == null)
      {
        paramAppInterface = new BaseAddress((String)localObject2, (String)localObject1, a(1));
        this.b.put("0", new BaseAddress("不限", "0", 0));
        this.b.put(localObject1, paramAppInterface);
      }
      int k = a(2, i, arrayOfString);
      if (k == -1) {
        return true;
      }
      int j = k + 1;
      localObject2 = arrayOfString[k];
      k = j + 1;
      String str1 = arrayOfString[j];
      localObject1 = (BaseAddress)paramAppInterface.dataMap.get(localObject2);
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        j = a(k - 1);
        paramString = new BaseAddress(str1, (String)localObject2, j);
        paramAppInterface.dataMap.put("0", new BaseAddress("不限", "0", j));
        paramAppInterface.dataMap.put(localObject2, paramString);
        paramAppInterface.hasProvince = true;
      }
      k = a(k, i, arrayOfString);
      if (k == -1) {
        return true;
      }
      j = k + 1;
      str1 = arrayOfString[k];
      k = j + 1;
      String str2 = arrayOfString[j];
      localObject2 = (BaseAddress)paramString.dataMap.get(str1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        j = a(k - 1);
        localObject1 = new BaseAddress(str2, str1, j);
        paramString.dataMap.put("0", new BaseAddress("不限", "0", j));
        paramString.dataMap.put(str1, localObject1);
        paramAppInterface.hasCity = true;
      }
      i = a(k, i, arrayOfString);
      if (i == -1) {
        return true;
      }
      j = i + 1;
      paramString = arrayOfString[i];
      localObject2 = arrayOfString[j];
      if ((BaseAddress)((BaseAddress)localObject1).dataMap.get(paramString) == null)
      {
        i = a(j + 1 - 1);
        localObject2 = new BaseAddress((String)localObject2, paramString, i);
        ((BaseAddress)localObject1).dataMap.put("0", new BaseAddress("不限", "0", i));
        ((BaseAddress)localObject1).dataMap.put(paramString, localObject2);
        paramAppInterface.hasDistrict = true;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.data.AddressData
 * JD-Core Version:    0.7.0.1
 */