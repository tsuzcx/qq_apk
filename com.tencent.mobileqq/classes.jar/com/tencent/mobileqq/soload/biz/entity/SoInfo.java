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
    try
    {
      if (TextUtils.equals(paramString1, paramString2)) {
        return 0;
      }
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
      SoInfo.CompareModel localCompareModel = getIndex(paramString1, paramString2);
      if (localCompareModel.diff == 0) {
        return compareVersionInner(localCompareModel, paramString1, paramString2);
      }
      int i = localCompareModel.diff;
      if (i > 0) {
        return 1;
      }
      return -1;
    }
    catch (Throwable paramString1) {}
    return 1;
  }
  
  private static int compareVersionInner(SoInfo.CompareModel paramCompareModel, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = paramCompareModel.index;
    while (i < paramArrayOfString1.length)
    {
      if (safeParseInt(paramArrayOfString1[i]) > 0) {
        return 1;
      }
      i += 1;
    }
    i = paramCompareModel.index;
    while (i < paramArrayOfString2.length)
    {
      if (safeParseInt(paramArrayOfString2[i]) > 0) {
        return -1;
      }
      i += 1;
    }
    return 0;
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
  
  private static SoInfo.CompareModel getIndex(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    SoInfo.CompareModel localCompareModel = new SoInfo.CompareModel(null);
    int i = Math.min(paramArrayOfString1.length, paramArrayOfString2.length);
    while (localCompareModel.index < i)
    {
      int j = safeParseInt(paramArrayOfString1[localCompareModel.index]) - safeParseInt(paramArrayOfString2[localCompareModel.index]);
      localCompareModel.diff = j;
      if (j != 0) {
        break;
      }
      localCompareModel.index += 1;
    }
    return localCompareModel;
  }
  
  public static int getReportCode(SoInfo paramSoInfo)
  {
    if (paramSoInfo == null) {
      return 1;
    }
    if (SoDataUtil.c())
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
  
  private SoInfo mergeWhenVersionEqual(SoInfo paramSoInfo)
  {
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
    return mergeWhenVersionEqual(paramSoInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.SoInfo
 * JD-Core Version:    0.7.0.1
 */