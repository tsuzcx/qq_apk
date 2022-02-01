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
    int j = 0;
    if (paramPrefetchMutualMarkInfo == null) {
      return null;
    }
    PrefetchMutualMarkInfo localPrefetchMutualMarkInfo = new PrefetchMutualMarkInfo();
    int i;
    if (paramPrefetchMutualMarkInfo.eMutualMarkNewType.has()) {
      i = paramPrefetchMutualMarkInfo.eMutualMarkNewType.get();
    }
    for (;;)
    {
      localPrefetchMutualMarkInfo.type = i;
      label59:
      label83:
      long l;
      if (paramPrefetchMutualMarkInfo.uint32_level.has())
      {
        i = paramPrefetchMutualMarkInfo.uint32_level.get();
        localPrefetchMutualMarkInfo.level = i;
        if (!paramPrefetchMutualMarkInfo.uint32_days.has()) {
          break label360;
        }
        i = paramPrefetchMutualMarkInfo.uint32_days.get();
        localPrefetchMutualMarkInfo.days = i;
        i = j;
        if (paramPrefetchMutualMarkInfo.uint32_current_days.has()) {
          i = paramPrefetchMutualMarkInfo.uint32_current_days.get();
        }
        localPrefetchMutualMarkInfo.currentDays = i;
        if (!paramPrefetchMutualMarkInfo.uint64_sub_level.has()) {
          break label365;
        }
        l = paramPrefetchMutualMarkInfo.uint64_sub_level.get();
        localPrefetchMutualMarkInfo.subLevel = l;
        if (!paramPrefetchMutualMarkInfo.bytes_grade_resource_info.has()) {}
      }
      try
      {
        localPrefetchMutualMarkInfo.gradeResourceInfo.mergeFrom(paramPrefetchMutualMarkInfo.bytes_grade_resource_info.get().toByteArray());
        if ((localPrefetchMutualMarkInfo.gradeResourceInfo != null) && (localPrefetchMutualMarkInfo.gradeResourceInfo.bytes_static_url.has()) && (!TextUtils.isEmpty(localPrefetchMutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8()))) {
          localPrefetchMutualMarkInfo.iconStaticUrl = localPrefetchMutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8();
        }
        localPrefetchMutualMarkInfo.iconStaticUrl = MutualMarkUtils.b(localPrefetchMutualMarkInfo.iconStaticUrl);
        if ((paramPrefetchMutualMarkInfo.bytes_min_ver.has()) && (!TextUtils.isEmpty(paramPrefetchMutualMarkInfo.bytes_min_ver.get().toStringUtf8()))) {
          localPrefetchMutualMarkInfo.minVersion = paramPrefetchMutualMarkInfo.bytes_min_ver.get().toStringUtf8();
        }
        if ((paramPrefetchMutualMarkInfo.bytes_max_ver.has()) && (!TextUtils.isEmpty(paramPrefetchMutualMarkInfo.bytes_max_ver.get().toStringUtf8()))) {
          localPrefetchMutualMarkInfo.maxVersion = paramPrefetchMutualMarkInfo.bytes_max_ver.get().toStringUtf8();
        }
        if (!MutualMarkUtils.a(localPrefetchMutualMarkInfo.minVersion, localPrefetchMutualMarkInfo.maxVersion))
        {
          QLog.i("IntimateInfo", 1, "oidb_0xcf4.PrefetchMutualMarkInfo，isCurrentVersionShouldShow=false");
          return null;
          i = 0;
          continue;
          i = 0;
          break label59;
          label360:
          i = 0;
          break label83;
          label365:
          l = 0L;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.i("IntimateInfo", 1, "parseFrom error:" + localThrowable.getMessage());
          localPrefetchMutualMarkInfo.gradeResourceInfo = null;
        }
      }
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
    return "MutualMarkInfo{type=" + this.type + ", level=" + this.level + ", days=" + this.days + ", currentDays=" + this.currentDays + ", subLevel=" + this.subLevel + ", iconStaticUrl=" + this.iconStaticUrl + ", minVersion=" + this.minVersion + ", maxVersion=" + this.maxVersion + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */