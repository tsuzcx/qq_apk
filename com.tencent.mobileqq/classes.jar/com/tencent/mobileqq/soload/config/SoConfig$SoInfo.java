package com.tencent.mobileqq.soload.config;

import android.text.TextUtils;
import bbzl;
import java.io.Serializable;
import org.json.JSONObject;

public class SoConfig$SoInfo
  implements Serializable
{
  public SoConfig.SoDetailInfo arm32Info;
  public SoConfig.SoDetailInfo arm64Info;
  public String name;
  public String ver;
  
  private static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        if (TextUtils.equals(paramString1, paramString2)) {
          return 0;
        }
        paramString1 = paramString1.split("\\.");
        paramString2 = paramString2.split("\\.");
        int m = Math.min(paramString1.length, paramString2.length);
        j = 0;
        i = 0;
        k = j;
        if (i >= m) {
          break label137;
        }
        j = a(paramString1[i]) - a(paramString2[i]);
        k = j;
        if (j != 0) {
          break label137;
        }
        i += 1;
        continue;
        j = i;
        if (k < paramString1.length)
        {
          if (a(paramString1[k]) > 0) {
            break label135;
          }
          k += 1;
          continue;
        }
        if (j < paramString2.length)
        {
          i = a(paramString2[j]);
          if (i <= 0) {
            break label148;
          }
          return -1;
        }
        return 0;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
      if (k <= 0) {
        return -1;
      }
      label135:
      return 1;
      label137:
      if (k == 0)
      {
        k = i;
        continue;
        label148:
        j += 1;
      }
    }
  }
  
  public static SoInfo create(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {
      return null;
    }
    String str1 = paramJSONObject.optString("name");
    String str2 = paramJSONObject.optString("ver", "0.0.0");
    Object localObject = SoConfig.RelatedFileInfo.create(paramJSONObject.optJSONObject("relatedFile"));
    int i = paramJSONObject.optInt("testFlag");
    if (paramJSONObject.optInt("flowControl") == 1) {}
    SoConfig.SoDetailInfo localSoDetailInfo;
    for (;;)
    {
      localSoDetailInfo = SoConfig.SoDetailInfo.create(paramJSONObject.optJSONObject("arm32"), str2, (SoConfig.RelatedFileInfo)localObject, i, bool);
      paramJSONObject = SoConfig.SoDetailInfo.create(paramJSONObject.optJSONObject("arm64"), str2, (SoConfig.RelatedFileInfo)localObject, i, bool);
      if ((!TextUtils.isEmpty(str1)) && ((localSoDetailInfo != null) || (paramJSONObject != null))) {
        break;
      }
      return null;
      bool = false;
    }
    localObject = new SoInfo();
    ((SoInfo)localObject).name = str1;
    ((SoInfo)localObject).ver = str2;
    ((SoInfo)localObject).arm32Info = localSoDetailInfo;
    ((SoInfo)localObject).arm64Info = paramJSONObject;
    return localObject;
  }
  
  public static int getReportCode(SoInfo paramSoInfo)
  {
    if (paramSoInfo == null) {}
    do
    {
      do
      {
        return 1;
        if (!bbzl.a()) {
          break;
        }
      } while (paramSoInfo.arm64Info == null);
      return 0;
    } while (paramSoInfo.arm32Info == null);
    return 0;
  }
  
  public SoInfo merge(SoInfo paramSoInfo)
  {
    if (paramSoInfo == null) {}
    do
    {
      do
      {
        int i;
        do
        {
          return this;
          i = a(this.ver, paramSoInfo.ver);
        } while (i > 0);
        if (i < 0) {
          return paramSoInfo;
        }
      } while ((this.arm32Info != null) && (this.arm64Info != null));
      if ((paramSoInfo.arm32Info != null) && (paramSoInfo.arm64Info != null)) {
        return paramSoInfo;
      }
      if ((this.arm32Info == null) && (paramSoInfo.arm32Info != null)) {
        this.arm32Info = paramSoInfo.arm32Info;
      }
    } while ((this.arm64Info != null) || (paramSoInfo.arm64Info == null));
    this.arm64Info = paramSoInfo.arm64Info;
    return this;
  }
  
  public String toString()
  {
    return "SoInfo{name='" + this.name + '\'' + ", arm32Info=" + this.arm32Info + ", arm64Info=" + this.arm64Info + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoConfig.SoInfo
 * JD-Core Version:    0.7.0.1
 */