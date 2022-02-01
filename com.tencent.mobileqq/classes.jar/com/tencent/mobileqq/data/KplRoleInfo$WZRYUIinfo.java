package com.tencent.mobileqq.data;

import android.text.TextUtils;
import java.io.Serializable;

public class KplRoleInfo$WZRYUIinfo
  implements Serializable
{
  public String nick;
  public int sourceId;
  public int subSourceId;
  public String uin;
  public String verifyMsg;
  
  public static String buildNickName(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("(");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static WZRYUIinfo createInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    WZRYUIinfo localWZRYUIinfo = new WZRYUIinfo();
    localWZRYUIinfo.uin = paramString1;
    localWZRYUIinfo.nick = paramString2;
    localWZRYUIinfo.verifyMsg = paramString3;
    localWZRYUIinfo.sourceId = paramInt1;
    localWZRYUIinfo.subSourceId = paramInt2;
    return localWZRYUIinfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo
 * JD-Core Version:    0.7.0.1
 */