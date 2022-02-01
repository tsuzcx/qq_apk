package com.tencent.mobileqq.troop.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.qphone.base.util.QLog;

public class TroopAvatarUtilApiImpl
  implements ITroopAvatarUtilApi
{
  public String getArtWork(String paramString)
  {
    if (isAvatarUrl(paramString)) {
      return paramString + 0;
    }
    return null;
  }
  
  public String getAvatarAddress(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      QLog.d("TroopAvatarUtilApiImpl", 1, "getAvatarAddress troopUin is empty");
    }
    do
    {
      return "https://p.qlogo.cn/gh/dir/file/";
      if (1 == paramInt) {
        return "https://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2 + "_" + paramString1);
      }
    } while (paramInt != 0);
    return "https://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2);
  }
  
  public String getThumbPhoto(String paramString)
  {
    if (isAvatarUrl(paramString)) {
      return paramString + 140;
    }
    return null;
  }
  
  public boolean isAvatarUrl(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("https://p.qlogo.cn/gh/");
  }
  
  public boolean isNumeric(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (((paramString.length() > 1) && (paramString.startsWith("+"))) || (paramString.startsWith("-"))) {}
    for (int i = 1;; i = 0)
    {
      int j = paramString.length();
      int k;
      do
      {
        k = j - 1;
        if (k < i) {
          break;
        }
        j = k;
      } while (Character.isDigit(paramString.charAt(k)));
      return false;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopAvatarUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */