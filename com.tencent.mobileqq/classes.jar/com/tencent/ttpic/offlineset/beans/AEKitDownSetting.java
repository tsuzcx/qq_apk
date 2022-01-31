package com.tencent.ttpic.offlineset.beans;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class AEKitDownSetting
{
  public List<AEKitDownSetting.DownResInfo> AEKitSDKSetting;
  
  private static boolean compareArr(int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null)) {
      bool1 = true;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramArrayOfInt1.length != paramArrayOfInt2.length);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfInt1.length) {
        break label82;
      }
      if (paramBoolean)
      {
        bool1 = bool2;
        if (paramArrayOfInt1[i] < paramArrayOfInt2[i]) {
          break;
        }
      }
      while (paramArrayOfInt1[i] != paramArrayOfInt2[i])
      {
        return true;
        if (paramArrayOfInt1[i] > paramArrayOfInt2[i]) {
          return false;
        }
      }
      i += 1;
    }
    label82:
    return true;
  }
  
  private static boolean needUpdate(String paramString, AEKitDownSetting.DownResInfo paramDownResInfo)
  {
    boolean bool = true;
    if ((paramDownResInfo == null) || (paramString == null)) {}
    do
    {
      return false;
      paramString = parseVer(paramString);
    } while (paramString == null);
    int[] arrayOfInt = parseVer(paramDownResInfo.minAppVer);
    paramDownResInfo = parseVer(paramDownResInfo.maxAppVer);
    if ((compareArr(paramString, arrayOfInt, true)) && (compareArr(paramString, paramDownResInfo, false))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static int[] parseVer(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("\\.");
    if ((paramString == null) || (paramString.length != 3)) {
      return null;
    }
    int[] arrayOfInt = new int[3];
    int i = 0;
    while (i < paramString.length) {
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        i += 1;
      }
      catch (Throwable paramString)
      {
        return null;
      }
    }
    return arrayOfInt;
  }
  
  public AEKitDownSetting.DownResInfo getDownResInfo(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (this.AEKitSDKSetting == null)) {}
    for (;;)
    {
      return null;
      Iterator localIterator = this.AEKitSDKSetting.iterator();
      AEKitDownSetting.DownResInfo localDownResInfo;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localDownResInfo = (AEKitDownSetting.DownResInfo)localIterator.next();
      } while ((localDownResInfo == null) || (!paramString1.equals(localDownResInfo.res_id)));
      for (paramString1 = localDownResInfo; needUpdate(paramString2, paramString1); paramString1 = null)
      {
        if (needUpdate(paramString2, paramString1)) {}
        for (;;)
        {
          return paramString1;
          paramString1 = null;
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.AEKitDownSetting
 * JD-Core Version:    0.7.0.1
 */