package com.tencent.mobileqq.troop.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.qphone.base.util.QLog;

public class TroopAvatarUtilApiImpl
  implements ITroopAvatarUtilApi
{
  public String getArtWork(String paramString)
  {
    if (isAvatarUrl(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(0);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public String getAvatarAddress(String paramString1, String paramString2, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString2);
    String str = "https://p.qlogo.cn/gh/dir/file/";
    if (bool)
    {
      QLog.d("TroopAvatarUtilApiImpl", 1, "getAvatarAddress troopUin is empty");
      return "https://p.qlogo.cn/gh/dir/file/";
    }
    if (1 == paramInt)
    {
      str = "https://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      return str.replace("file", localStringBuilder.toString());
    }
    paramString1 = str;
    if (paramInt == 0) {
      paramString1 = "https://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2);
    }
    return paramString1;
  }
  
  public String getThumbPhoto(String paramString)
  {
    if (isAvatarUrl(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(140);
      return localStringBuilder.toString();
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
    int i;
    if (((paramString.length() > 1) && (paramString.startsWith("+"))) || (paramString.startsWith("-"))) {
      i = 1;
    } else {
      i = 0;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopAvatarUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */