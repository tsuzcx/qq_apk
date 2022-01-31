package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;
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
    if (paramPrefetchMutualMarkInfo.eMutualMarkNewType.has())
    {
      i = paramPrefetchMutualMarkInfo.eMutualMarkNewType.get();
      localPrefetchMutualMarkInfo.type = i;
      if (!paramPrefetchMutualMarkInfo.uint32_level.has()) {
        break label117;
      }
      i = paramPrefetchMutualMarkInfo.uint32_level.get();
      label57:
      localPrefetchMutualMarkInfo.level = i;
      if (!paramPrefetchMutualMarkInfo.uint32_days.has()) {
        break label122;
      }
    }
    label117:
    label122:
    for (int i = paramPrefetchMutualMarkInfo.uint32_days.get();; i = 0)
    {
      localPrefetchMutualMarkInfo.days = i;
      i = j;
      if (paramPrefetchMutualMarkInfo.uint32_current_days.has()) {
        i = paramPrefetchMutualMarkInfo.uint32_current_days.get();
      }
      localPrefetchMutualMarkInfo.currentDays = i;
      return localPrefetchMutualMarkInfo;
      i = 0;
      break;
      i = 0;
      break label57;
    }
  }
  
  public static PrefetchMutualMarkInfo copyFromJson(JSONObject paramJSONObject)
  {
    PrefetchMutualMarkInfo localPrefetchMutualMarkInfo = new PrefetchMutualMarkInfo();
    localPrefetchMutualMarkInfo.type = paramJSONObject.optInt("type");
    localPrefetchMutualMarkInfo.level = paramJSONObject.optInt("level");
    localPrefetchMutualMarkInfo.days = paramJSONObject.optInt("days");
    localPrefetchMutualMarkInfo.currentDays = paramJSONObject.optInt("currentDays");
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
      localJSONObject.put("currentDays", this.currentDays);
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
    return "MutualMarkInfo{type=" + this.type + ", level=" + this.level + ", days=" + this.days + ", currentDays=" + this.currentDays + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */