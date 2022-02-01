package com.tencent.mobileqq.unifiedname;

import android.text.TextUtils;
import java.util.List;

public class MQQProfileNameTranslator
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    switch (paramInt1)
    {
    default: 
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
      paramMQQProfileName.b.clear();
      return;
    case 10: 
      h(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, paramMQQProfileName);
      return;
    }
    a(paramArrayOfString, paramMQQProfileName);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.b.clear();
    if (paramInt == 2)
    {
      MQQName localMQQName;
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        paramMQQProfileName.a.a = 1;
        paramMQQProfileName.a.b = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localMQQName = new MQQName();
          localMQQName.a = 4;
          localMQQName.b = paramArrayOfString[4];
          paramMQQProfileName.b.add(localMQQName);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.a = 3;
          localMQQName.b = paramArrayOfString[3];
          paramMQQProfileName.b.add(localMQQName);
        }
      }
      else if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.a.a = 4;
        paramMQQProfileName.a.b = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.a = 3;
          localMQQName.b = paramArrayOfString[3];
          paramMQQProfileName.b.add(localMQQName);
        }
      }
      else
      {
        paramMQQProfileName.a.a = 0;
        paramMQQProfileName.a.b = paramArrayOfString[0];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.a = 3;
          localMQQName.b = paramArrayOfString[3];
          paramMQQProfileName.b.add(localMQQName);
        }
      }
    }
    else if (paramInt == 1)
    {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        paramMQQProfileName.a.a = 1;
        paramMQQProfileName.a.b = paramArrayOfString[1];
        return;
      }
      if (!TextUtils.isEmpty(paramArrayOfString[6]))
      {
        paramMQQProfileName.a.a = 6;
        paramMQQProfileName.a.b = paramArrayOfString[6];
        return;
      }
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
    }
  }
  
  public static void a(String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.b.clear();
    MQQName localMQQName;
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      paramMQQProfileName.a.a = 4;
      paramMQQProfileName.a.b = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localMQQName = new MQQName();
        localMQQName.a = 3;
        localMQQName.b = paramArrayOfString[3];
        paramMQQProfileName.b.add(localMQQName);
      }
    }
    else
    {
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localMQQName = new MQQName();
        localMQQName.a = 3;
        localMQQName.b = paramArrayOfString[3];
        paramMQQProfileName.b.add(localMQQName);
      }
    }
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.b.clear();
      if (!TextUtils.isEmpty(paramArrayOfString[6]))
      {
        paramMQQProfileName.a.a = 6;
        paramMQQProfileName.a.b = paramArrayOfString[6];
        return;
      }
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
    }
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.b.clear();
    if (paramInt == 2)
    {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.a.a = 4;
        paramMQQProfileName.a.b = paramArrayOfString[4];
        return;
      }
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
      if (!TextUtils.isEmpty(paramArrayOfString[2]))
      {
        MQQName localMQQName = new MQQName();
        localMQQName.a = 2;
        localMQQName.b = paramArrayOfString[2];
        paramMQQProfileName.b.add(localMQQName);
      }
    }
    else if (paramInt == 1)
    {
      if (!TextUtils.isEmpty(paramArrayOfString[2]))
      {
        paramMQQProfileName.a.a = 2;
        paramMQQProfileName.a.b = paramArrayOfString[2];
        return;
      }
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
    }
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    paramMQQProfileName.b.clear();
    MQQName localMQQName;
    if (paramInt == 2)
    {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramMQQProfileName.a.a = 4;
        paramMQQProfileName.a.b = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.a = 3;
          localMQQName.b = paramArrayOfString[3];
          paramMQQProfileName.b.add(localMQQName);
        }
      }
      else
      {
        paramMQQProfileName.a.a = 0;
        paramMQQProfileName.a.b = paramArrayOfString[0];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localMQQName = new MQQName();
          localMQQName.a = 3;
          localMQQName.b = paramArrayOfString[3];
          paramMQQProfileName.b.add(localMQQName);
        }
      }
    }
    else
    {
      if (paramInt == 1)
      {
        localMQQName = new MQQName();
        localMQQName.a = 0;
        localMQQName.b = paramArrayOfString[0];
        paramMQQProfileName.b.add(localMQQName);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          paramMQQProfileName.a.a = 3;
          paramMQQProfileName.a.b = paramArrayOfString[3];
          return;
        }
        paramMQQProfileName.a.a = 0;
        paramMQQProfileName.a.b = paramArrayOfString[0];
        return;
      }
      if (paramInt == 3)
      {
        localMQQName = new MQQName();
        localMQQName.a = 7;
        localMQQName.b = paramArrayOfString[0];
        paramMQQProfileName.b.add(localMQQName);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          paramMQQProfileName.a.a = 3;
          paramMQQProfileName.a.b = paramArrayOfString[3];
          return;
        }
        paramMQQProfileName.a.a = 0;
        paramMQQProfileName.a.b = paramArrayOfString[0];
      }
    }
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
      paramMQQProfileName.b.clear();
    }
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.b.clear();
      if (!TextUtils.isEmpty(paramArrayOfString[5]))
      {
        paramMQQProfileName.a.a = 5;
        paramMQQProfileName.a.b = paramArrayOfString[5];
        return;
      }
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
    }
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.b.clear();
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        paramMQQProfileName.a.a = 3;
        paramMQQProfileName.a.b = paramArrayOfString[3];
        return;
      }
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
    }
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, MQQProfileName paramMQQProfileName)
  {
    if (paramInt == 2)
    {
      a(paramArrayOfString, paramMQQProfileName);
      return;
    }
    if (paramInt == 1)
    {
      paramMQQProfileName.a.a = 0;
      paramMQQProfileName.a.b = paramArrayOfString[0];
      paramMQQProfileName.b.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedname.MQQProfileNameTranslator
 * JD-Core Version:    0.7.0.1
 */