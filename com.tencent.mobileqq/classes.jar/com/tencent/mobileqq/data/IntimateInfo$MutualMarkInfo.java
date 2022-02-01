package com.tencent.mobileqq.data;

import awfy;
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
  public long subLevel;
  public int type;
  
  public static MutualMarkInfo copyFrom(oidb_0xcf4.MutualMarkInfo paramMutualMarkInfo)
  {
    int j = 0;
    if (paramMutualMarkInfo == null) {
      return null;
    }
    MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
    int i;
    if (paramMutualMarkInfo.eMutualMarkNewType.has()) {
      i = paramMutualMarkInfo.eMutualMarkNewType.get();
    }
    for (;;)
    {
      localMutualMarkInfo.type = i;
      label59:
      long l;
      if (paramMutualMarkInfo.uint32_level.has())
      {
        i = paramMutualMarkInfo.uint32_level.get();
        localMutualMarkInfo.level = i;
        i = j;
        if (paramMutualMarkInfo.uint32_days.has()) {
          i = paramMutualMarkInfo.uint32_days.get();
        }
        localMutualMarkInfo.days = i;
        if (!paramMutualMarkInfo.uint64_sub_level.has()) {
          break label264;
        }
        l = paramMutualMarkInfo.uint64_sub_level.get();
        localMutualMarkInfo.subLevel = l;
        if (!paramMutualMarkInfo.bytes_grade_resource_info.has()) {}
      }
      try
      {
        localMutualMarkInfo.gradeResourceInfo.mergeFrom(paramMutualMarkInfo.bytes_grade_resource_info.get().toByteArray());
        if ((paramMutualMarkInfo.msg_special_word_info.has()) && (((oidb_0xcf4.SpecialWordInfo)paramMutualMarkInfo.msg_special_word_info.get()).bytes_static_url.has())) {
          localMutualMarkInfo.iconStaticUrl = ((oidb_0xcf4.SpecialWordInfo)paramMutualMarkInfo.msg_special_word_info.get()).bytes_static_url.get().toStringUtf8();
        }
        if ((localMutualMarkInfo.gradeResourceInfo != null) && (localMutualMarkInfo.gradeResourceInfo.bytes_static_url.has())) {
          localMutualMarkInfo.iconStaticUrl = localMutualMarkInfo.gradeResourceInfo.bytes_static_url.get().toStringUtf8();
        }
        localMutualMarkInfo.iconStaticUrl = awfy.c(localMutualMarkInfo.iconStaticUrl);
        return localMutualMarkInfo;
        i = 0;
        continue;
        i = 0;
        break label59;
        label264:
        l = 0L;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.i("IntimateInfo", 1, "parseFrom error:" + localThrowable.getMessage());
          localMutualMarkInfo.gradeResourceInfo = null;
        }
      }
    }
  }
  
  public static MutualMarkInfo copyFromJson(JSONObject paramJSONObject)
  {
    MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
    localMutualMarkInfo.type = paramJSONObject.optInt("type");
    localMutualMarkInfo.level = paramJSONObject.optInt("level");
    localMutualMarkInfo.days = paramJSONObject.optInt("days");
    localMutualMarkInfo.subLevel = paramJSONObject.optInt("subLevel");
    localMutualMarkInfo.iconStaticUrl = paramJSONObject.optString("iconStaticUrl");
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
    return "MutualMarkInfo{type=" + this.type + ", level=" + this.level + ", days=" + this.days + ", subLevel=" + this.subLevel + ", iconStaticUrl=" + this.iconStaticUrl + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */