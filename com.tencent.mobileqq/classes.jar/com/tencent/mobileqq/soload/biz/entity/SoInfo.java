package com.tencent.mobileqq.soload.biz.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import java.io.Serializable;
import org.json.JSONObject;

public class SoInfo
  implements Serializable
{
  public SoDetailInfo arm32Info;
  public SoDetailInfo arm64Info;
  public String name;
  public String ver;
  
  private static int compareVersion(String paramString1, String paramString2)
  {
    for (;;)
    {
      int j;
      try
      {
        if (TextUtils.equals(paramString1, paramString2)) {
          return 0;
        }
        paramString1 = paramString1.split("\\.");
        paramString2 = paramString2.split("\\.");
        int m = Math.min(paramString1.length, paramString2.length);
        i = 0;
        j = 0;
        if (i >= m) {
          break label143;
        }
        k = safeParseInt(paramString1[i]) - safeParseInt(paramString2[i]);
        j = k;
        if (k != 0) {
          break label143;
        }
        i += 1;
        j = k;
        continue;
        j = i;
        if (k < paramString1.length)
        {
          if (safeParseInt(paramString1[k]) <= 0) {
            break label156;
          }
          return 1;
        }
        if (j < paramString2.length)
        {
          i = safeParseInt(paramString2[j]);
          if (i > 0) {
            return -1;
          }
          j += 1;
          continue;
        }
        return 0;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        return 1;
      }
      int i = k;
      if (j > 0) {
        i = 1;
      }
      return i;
      label143:
      int k = -1;
      if (j == 0)
      {
        k = i;
        continue;
        label156:
        k += 1;
      }
    }
  }
  
  public static SoInfo create(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    if (paramJSONObject == null) {
      return null;
    }
    String str1 = paramJSONObject.optString("name");
    String str2 = paramJSONObject.optString("ver", "0.0.0");
    Object localObject2 = RelatedFileInfo.create(paramJSONObject.optJSONObject("relatedFile"));
    int i = paramJSONObject.optInt("testFlag");
    int j = paramJSONObject.optInt("flowControl");
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    SoDetailInfo localSoDetailInfo = SoDetailInfo.create(paramJSONObject.optJSONObject("arm32"), str2, (RelatedFileInfo)localObject2, i, bool);
    localObject2 = SoDetailInfo.create(paramJSONObject.optJSONObject("arm64"), str2, (RelatedFileInfo)localObject2, i, bool);
    paramJSONObject = localObject1;
    if (!TextUtils.isEmpty(str1))
    {
      if ((localSoDetailInfo == null) && (localObject2 == null)) {
        return null;
      }
      paramJSONObject = new SoInfo();
      paramJSONObject.name = str1;
      paramJSONObject.ver = str2;
      paramJSONObject.arm32Info = localSoDetailInfo;
      paramJSONObject.arm64Info = ((SoDetailInfo)localObject2);
    }
    return paramJSONObject;
  }
  
  public static int getReportCode(SoInfo paramSoInfo)
  {
    if (paramSoInfo == null) {
      return 1;
    }
    if (SoDataUtil.a())
    {
      if (paramSoInfo.arm64Info == null) {
        return 1;
      }
      return 0;
    }
    if (paramSoInfo.arm32Info == null) {
      return 1;
    }
    return 0;
  }
  
  private static int safeParseInt(String paramString)
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
  
  public SoInfo merge(SoInfo paramSoInfo)
  {
    if (paramSoInfo == null) {
      return this;
    }
    int i = compareVersion(this.ver, paramSoInfo.ver);
    if (i > 0) {
      return this;
    }
    if (i < 0) {
      return paramSoInfo;
    }
    if ((this.arm32Info != null) && (this.arm64Info != null)) {
      return this;
    }
    if ((paramSoInfo.arm32Info != null) && (paramSoInfo.arm64Info != null)) {
      return paramSoInfo;
    }
    if (this.arm32Info == null)
    {
      SoDetailInfo localSoDetailInfo = paramSoInfo.arm32Info;
      if (localSoDetailInfo != null) {
        this.arm32Info = localSoDetailInfo;
      }
    }
    if (this.arm64Info == null)
    {
      paramSoInfo = paramSoInfo.arm64Info;
      if (paramSoInfo != null) {
        this.arm64Info = paramSoInfo;
      }
    }
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SoInfo{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arm32Info=");
    localStringBuilder.append(this.arm32Info);
    localStringBuilder.append(", arm64Info=");
    localStringBuilder.append(this.arm64Info);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.SoInfo
 * JD-Core Version:    0.7.0.1
 */