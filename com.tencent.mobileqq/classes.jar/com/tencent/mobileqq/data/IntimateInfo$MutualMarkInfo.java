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
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.SpecialWordInfo;

public class IntimateInfo$MutualMarkInfo
{
  public int days;
  public mutualmark.ResourceInfo gradeResourceInfo = new mutualmark.ResourceInfo();
  public String iconStaticUrl = "";
  public int level;
  public String maxVersion = "";
  public String minVersion = "";
  public long subLevel;
  public int type;
  
  public static MutualMarkInfo copyFrom(oidb_0xcf4.MutualMarkInfo paramMutualMarkInfo)
  {
    if (paramMutualMarkInfo == null) {
      return null;
    }
    MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
    boolean bool = paramMutualMarkInfo.eMutualMarkNewType.has();
    int j = 0;
    if (bool) {
      i = paramMutualMarkInfo.eMutualMarkNewType.get();
    } else {
      i = 0;
    }
    localMutualMarkInfo.type = i;
    if (paramMutualMarkInfo.uint32_level.has()) {
      i = paramMutualMarkInfo.uint32_level.get();
    } else {
      i = 0;
    }
    localMutualMarkInfo.level = i;
    int i = j;
    if (paramMutualMarkInfo.uint32_days.has()) {
      i = paramMutualMarkInfo.uint32_days.get();
    }
    localMutualMarkInfo.days = i;
    long l;
    if (paramMutualMarkInfo.uint64_sub_level.has()) {
      l = paramMutualMarkInfo.uint64_sub_level.get();
    } else {
      l = 0L;
    }
    localMutualMarkInfo.subLevel = l;
    if (paramMutualMarkInfo.bytes_grade_resource_info.has()) {
      try
      {
        localMutualMarkInfo.gradeResourceInfo.mergeFrom(paramMutualMarkInfo.bytes_grade_resource_info.get().toByteArray());
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseFrom error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.i("IntimateInfo", 1, localStringBuilder.toString());
        localMutualMarkInfo.gradeResourceInfo = null;
      }
    }
    if ((paramMutualMarkInfo.msg_special_word_info.has()) && (((oidb_0xcf4.SpecialWordInfo)paramMutualMarkInfo.msg_special_word_info.get()).bytes_static_url.has())) {
      localMutualMarkInfo.iconStaticUrl = ((oidb_0xcf4.SpecialWordInfo)paramMutualMarkInfo.msg_special_word_info.get()).bytes_static_url.get().toStringUtf8();
    }
    mutualmark.ResourceInfo localResourceInfo = localMutualMarkInfo.gradeResourceInfo;
    if ((localResourceInfo != null) && (localResourceInfo.bytes_static_url.has()) && (!TextUtils.isEmpty(localMutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8()))) {
      localMutualMarkInfo.iconStaticUrl = localMutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8();
    }
    localMutualMarkInfo.iconStaticUrl = MutualMarkUtils.b(localMutualMarkInfo.iconStaticUrl);
    if ((paramMutualMarkInfo.bytes_min_ver.has()) && (!TextUtils.isEmpty(paramMutualMarkInfo.bytes_min_ver.get().toStringUtf8()))) {
      localMutualMarkInfo.minVersion = paramMutualMarkInfo.bytes_min_ver.get().toStringUtf8();
    }
    if ((paramMutualMarkInfo.bytes_max_ver.has()) && (!TextUtils.isEmpty(paramMutualMarkInfo.bytes_max_ver.get().toStringUtf8()))) {
      localMutualMarkInfo.maxVersion = paramMutualMarkInfo.bytes_max_ver.get().toStringUtf8();
    }
    if (!MutualMarkUtils.a(localMutualMarkInfo.minVersion, localMutualMarkInfo.maxVersion))
    {
      QLog.i("IntimateInfo", 1, "oidb_0xcf4.MutualMarkInfo，isCurrentVersionShouldShow=false");
      return null;
    }
    return localMutualMarkInfo;
  }
  
  public static MutualMarkInfo copyFromJson(JSONObject paramJSONObject)
  {
    MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
    localMutualMarkInfo.type = paramJSONObject.optInt("type");
    localMutualMarkInfo.level = paramJSONObject.optInt("level");
    localMutualMarkInfo.days = paramJSONObject.optInt("days");
    localMutualMarkInfo.subLevel = paramJSONObject.optInt("subLevel");
    localMutualMarkInfo.iconStaticUrl = paramJSONObject.optString("iconStaticUrl");
    localMutualMarkInfo.minVersion = paramJSONObject.optString("minVersion");
    localMutualMarkInfo.maxVersion = paramJSONObject.optString("maxVersion");
    return localMutualMarkInfo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */