package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.SpecialWordInfo;

public class IntimateInfo$MutualMarkInfo
{
  public int days;
  public String icon_static_url = "";
  public int level;
  public int type;
  
  public static MutualMarkInfo copyFrom(oidb_0xcf4.MutualMarkInfo paramMutualMarkInfo)
  {
    int j = 0;
    if (paramMutualMarkInfo == null) {
      return null;
    }
    MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
    if (paramMutualMarkInfo.eMutualMarkNewType.has())
    {
      i = paramMutualMarkInfo.eMutualMarkNewType.get();
      localMutualMarkInfo.type = i;
      if (!paramMutualMarkInfo.uint32_level.has()) {
        break label146;
      }
    }
    label146:
    for (int i = paramMutualMarkInfo.uint32_level.get();; i = 0)
    {
      localMutualMarkInfo.level = i;
      i = j;
      if (paramMutualMarkInfo.uint32_days.has()) {
        i = paramMutualMarkInfo.uint32_days.get();
      }
      localMutualMarkInfo.days = i;
      if ((paramMutualMarkInfo.msg_special_word_info.has()) && (((oidb_0xcf4.SpecialWordInfo)paramMutualMarkInfo.msg_special_word_info.get()).bytes_static_url.has())) {
        localMutualMarkInfo.icon_static_url = ((oidb_0xcf4.SpecialWordInfo)paramMutualMarkInfo.msg_special_word_info.get()).bytes_static_url.get().toStringUtf8();
      }
      return localMutualMarkInfo;
      i = 0;
      break;
    }
  }
  
  public static MutualMarkInfo copyFromJson(JSONObject paramJSONObject)
  {
    MutualMarkInfo localMutualMarkInfo = new MutualMarkInfo();
    localMutualMarkInfo.type = paramJSONObject.optInt("type");
    localMutualMarkInfo.level = paramJSONObject.optInt("level");
    localMutualMarkInfo.days = paramJSONObject.optInt("days");
    localMutualMarkInfo.icon_static_url = paramJSONObject.optString("icon_static_url");
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
      localJSONObject.put("icon_static_url", this.icon_static_url);
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
    return "MutualMarkInfo{type=" + this.type + ", level=" + this.level + ", days=" + this.days + ", icon_static_url=" + this.icon_static_url + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.MutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */