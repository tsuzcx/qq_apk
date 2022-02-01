package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.mutualmark.mutualmark.ResourceInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.PrefetchMutualMarkInfo;

public class IntimateInfo$PrefetchMutualMarkInfo
  extends IntimateInfo.MutualMarkInfo
{
  public int currentDays;
  
  public static PrefetchMutualMarkInfo copyFrom(oidb_0xcf4.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo)
  {
    if (paramPrefetchMutualMarkInfo == null) {
      return null;
    }
    PrefetchMutualMarkInfo localPrefetchMutualMarkInfo = new PrefetchMutualMarkInfo();
    boolean bool = paramPrefetchMutualMarkInfo.eMutualMarkNewType.has();
    int j = 0;
    if (bool) {
      i = paramPrefetchMutualMarkInfo.eMutualMarkNewType.get();
    } else {
      i = 0;
    }
    localPrefetchMutualMarkInfo.type = i;
    if (paramPrefetchMutualMarkInfo.uint32_level.has()) {
      i = paramPrefetchMutualMarkInfo.uint32_level.get();
    } else {
      i = 0;
    }
    localPrefetchMutualMarkInfo.level = i;
    if (paramPrefetchMutualMarkInfo.uint32_days.has()) {
      i = paramPrefetchMutualMarkInfo.uint32_days.get();
    } else {
      i = 0;
    }
    localPrefetchMutualMarkInfo.days = i;
    int i = j;
    if (paramPrefetchMutualMarkInfo.uint32_current_days.has()) {
      i = paramPrefetchMutualMarkInfo.uint32_current_days.get();
    }
    localPrefetchMutualMarkInfo.currentDays = i;
    long l;
    if (paramPrefetchMutualMarkInfo.uint64_sub_level.has()) {
      l = paramPrefetchMutualMarkInfo.uint64_sub_level.get();
    } else {
      l = 0L;
    }
    localPrefetchMutualMarkInfo.subLevel = l;
    if (paramPrefetchMutualMarkInfo.bytes_grade_resource_info.has()) {
      try
      {
        localPrefetchMutualMarkInfo.gradeResourceInfo.mergeFrom(paramPrefetchMutualMarkInfo.bytes_grade_resource_info.get().toByteArray());
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseFrom error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.i("IntimateInfo", 1, localStringBuilder.toString());
        localPrefetchMutualMarkInfo.gradeResourceInfo = null;
      }
    }
    if ((localPrefetchMutualMarkInfo.gradeResourceInfo != null) && (localPrefetchMutualMarkInfo.gradeResourceInfo.bytes_static_url.has()) && (!TextUtils.isEmpty(localPrefetchMutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8()))) {
      localPrefetchMutualMarkInfo.iconStaticUrl = localPrefetchMutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8();
    }
    localPrefetchMutualMarkInfo.iconStaticUrl = MutualMarkUtils.g(localPrefetchMutualMarkInfo.iconStaticUrl);
    if ((paramPrefetchMutualMarkInfo.bytes_min_ver.has()) && (!TextUtils.isEmpty(paramPrefetchMutualMarkInfo.bytes_min_ver.get().toStringUtf8()))) {
      localPrefetchMutualMarkInfo.minVersion = paramPrefetchMutualMarkInfo.bytes_min_ver.get().toStringUtf8();
    }
    if ((paramPrefetchMutualMarkInfo.bytes_max_ver.has()) && (!TextUtils.isEmpty(paramPrefetchMutualMarkInfo.bytes_max_ver.get().toStringUtf8()))) {
      localPrefetchMutualMarkInfo.maxVersion = paramPrefetchMutualMarkInfo.bytes_max_ver.get().toStringUtf8();
    }
    if (!MutualMarkUtils.b(localPrefetchMutualMarkInfo.minVersion, localPrefetchMutualMarkInfo.maxVersion))
    {
      QLog.i("IntimateInfo", 1, "oidb_0xcf4.PrefetchMutualMarkInfo，isCurrentVersionShouldShow=false");
      return null;
    }
    return localPrefetchMutualMarkInfo;
  }
  
  public static PrefetchMutualMarkInfo copyFromJson(JSONObject paramJSONObject)
  {
    PrefetchMutualMarkInfo localPrefetchMutualMarkInfo = new PrefetchMutualMarkInfo();
    localPrefetchMutualMarkInfo.type = paramJSONObject.optInt("type");
    localPrefetchMutualMarkInfo.level = paramJSONObject.optInt("level");
    localPrefetchMutualMarkInfo.days = paramJSONObject.optInt("days");
    localPrefetchMutualMarkInfo.currentDays = paramJSONObject.optInt("currentDays");
    localPrefetchMutualMarkInfo.subLevel = paramJSONObject.optInt("subLevel");
    localPrefetchMutualMarkInfo.iconStaticUrl = paramJSONObject.optString("iconStaticUrl");
    localPrefetchMutualMarkInfo.minVersion = paramJSONObject.optString("minVersion");
    localPrefetchMutualMarkInfo.maxVersion = paramJSONObject.optString("maxVersion");
    return localPrefetchMutualMarkInfo;
  }
  
  public JSONObject getJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.type);
      localJSONObject.put("level", this.level);
      localJSONObject.put("days", this.days);
      localJSONObject.put("subLevel", this.subLevel);
      localJSONObject.put("currentDays", this.currentDays);
      localJSONObject.put("iconStaticUrl", this.iconStaticUrl);
      localJSONObject.put("minVersion", this.minVersion);
      localJSONObject.put("maxVersion", this.maxVersion);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MutualMarkInfo{type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", level=");
    localStringBuilder.append(this.level);
    localStringBuilder.append(", days=");
    localStringBuilder.append(this.days);
    localStringBuilder.append(", currentDays=");
    localStringBuilder.append(this.currentDays);
    localStringBuilder.append(", subLevel=");
    localStringBuilder.append(this.subLevel);
    localStringBuilder.append(", iconStaticUrl=");
    localStringBuilder.append(this.iconStaticUrl);
    localStringBuilder.append(", minVersion=");
    localStringBuilder.append(this.minVersion);
    localStringBuilder.append(", maxVersion=");
    localStringBuilder.append(this.maxVersion);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */