package com.tencent.ttpic.offlineset.beans;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class AEKitDownSetting
{
  public List<AEKitDownSetting.DownResInfo> AEKitSDKSetting;
  
  private static boolean compareArr(int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    if (paramArrayOfInt1 != null)
    {
      if (paramArrayOfInt2 == null) {
        return true;
      }
      if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfInt1.length)
      {
        if (paramBoolean)
        {
          if (paramArrayOfInt1[i] < paramArrayOfInt2[i]) {
            return false;
          }
        }
        else if (paramArrayOfInt1[i] > paramArrayOfInt2[i]) {
          return false;
        }
        if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
          return true;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private static boolean needUpdate(String paramString, AEKitDownSetting.DownResInfo paramDownResInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramDownResInfo != null)
    {
      if (paramString == null) {
        return false;
      }
      paramString = parseVer(paramString);
      if (paramString == null) {
        return false;
      }
      int[] arrayOfInt = parseVer(paramDownResInfo.minAppVer);
      paramDownResInfo = parseVer(paramDownResInfo.maxAppVer);
      bool1 = bool2;
      if (compareArr(paramString, arrayOfInt, true))
      {
        bool1 = bool2;
        if (compareArr(paramString, paramDownResInfo, false)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static int[] parseVer(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String[] arrayOfString = paramString.split("\\.");
    int i;
    if (arrayOfString != null)
    {
      if (arrayOfString.length < 3) {
        return null;
      }
      paramString = new int[arrayOfString.length];
      i = 0;
    }
    for (;;)
    {
      if (i < paramString.length) {
        if (i >= arrayOfString.length) {
          return paramString;
        }
      }
      try
      {
        paramString[i] = Integer.parseInt(arrayOfString[i]);
        i += 1;
      }
      catch (Throwable localThrowable) {}
    }
    return paramString;
    return null;
    return paramString;
  }
  
  public AEKitDownSetting.DownResInfo getDownResInfo(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString1 != null)
    {
      localObject1 = localObject2;
      if (paramString2 != null)
      {
        localObject1 = this.AEKitSDKSetting;
        if (localObject1 == null) {
          return null;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (AEKitDownSetting.DownResInfo)localIterator.next();
          if ((localObject1 != null) && (paramString1.equals(((AEKitDownSetting.DownResInfo)localObject1).res_id)))
          {
            paramString1 = (String)localObject1;
            break label79;
          }
        }
        paramString1 = null;
        label79:
        if (!needUpdate(paramString2, paramString1)) {
          return null;
        }
        localObject1 = localObject2;
        if (needUpdate(paramString2, paramString1)) {
          localObject1 = paramString1;
        }
      }
    }
    return localObject1;
  }
  
  public String getResInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString1 = getDownResInfo(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.getResInfo(paramString2, paramString3, paramString4, paramString5);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.AEKitDownSetting
 * JD-Core Version:    0.7.0.1
 */