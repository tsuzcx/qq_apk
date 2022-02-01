package com.tencent.mobileqq.data;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DateTips;

public class IntimateInfo$MemoryDayInfo
{
  public long date;
  public int dateType;
  public String iconUrl;
  public int jumpType;
  public String linkColor;
  public String linkUrl;
  public String linkWording;
  public String wording;
  
  public static MemoryDayInfo copyFrom(oidb_0xcf4.DateTips paramDateTips)
  {
    Object localObject2 = null;
    if (paramDateTips == null) {
      return null;
    }
    MemoryDayInfo localMemoryDayInfo = new MemoryDayInfo();
    localMemoryDayInfo.date = NetConnInfoCenter.getServerTimeMillis();
    localMemoryDayInfo.dateType = paramDateTips.eDateType.get();
    if (paramDateTips.bytes_icon_url.has())
    {
      localObject1 = paramDateTips.bytes_icon_url.get().toStringUtf8();
      localMemoryDayInfo.iconUrl = ((String)localObject1);
      if (!paramDateTips.bytes_wording.has()) {
        break label184;
      }
      localObject1 = paramDateTips.bytes_wording.get().toStringUtf8();
      label81:
      localMemoryDayInfo.wording = ((String)localObject1);
      if (!paramDateTips.bytes_link_url.has()) {
        break label189;
      }
      localObject1 = paramDateTips.bytes_link_url.get().toStringUtf8();
      label107:
      localMemoryDayInfo.linkUrl = ((String)localObject1);
      if (!paramDateTips.bytes_link_wording.has()) {
        break label194;
      }
    }
    label184:
    label189:
    label194:
    for (Object localObject1 = paramDateTips.bytes_link_wording.get().toStringUtf8();; localObject1 = null)
    {
      localMemoryDayInfo.linkWording = ((String)localObject1);
      localObject1 = localObject2;
      if (paramDateTips.bytes_link_colour.has()) {
        localObject1 = paramDateTips.bytes_link_colour.get().toStringUtf8();
      }
      localMemoryDayInfo.linkColor = ((String)localObject1);
      localMemoryDayInfo.jumpType = paramDateTips.eJumpType.get();
      return localMemoryDayInfo;
      localObject1 = null;
      break;
      localObject1 = null;
      break label81;
      localObject1 = null;
      break label107;
    }
  }
  
  public static MemoryDayInfo copyFromJson(JSONObject paramJSONObject)
  {
    MemoryDayInfo localMemoryDayInfo = new MemoryDayInfo();
    localMemoryDayInfo.date = paramJSONObject.optInt("date");
    localMemoryDayInfo.dateType = paramJSONObject.optInt("dateType");
    localMemoryDayInfo.iconUrl = paramJSONObject.optString("iconUrl");
    localMemoryDayInfo.wording = paramJSONObject.optString("wording");
    localMemoryDayInfo.linkUrl = paramJSONObject.optString("linkUrl");
    localMemoryDayInfo.linkWording = paramJSONObject.optString("linkWording");
    localMemoryDayInfo.linkColor = paramJSONObject.optString("linkColor");
    localMemoryDayInfo.jumpType = paramJSONObject.optInt("jumpType");
    return localMemoryDayInfo;
  }
  
  public JSONObject getJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("date", this.date);
      localJSONObject.put("dateType", this.dateType);
      localJSONObject.put("iconUrl", this.iconUrl);
      localJSONObject.put("wording", this.wording);
      localJSONObject.put("linkUrl", this.linkUrl);
      localJSONObject.put("linkWording", this.linkWording);
      localJSONObject.put("linkColor", this.linkColor);
      localJSONObject.put("jumpType", this.jumpType);
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
    return "MemoryDayInfo{date=" + this.date + ", dateType='" + this.dateType + '\'' + ", wording='" + this.wording + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", linkUrl='" + this.linkUrl + '\'' + ", linkWording='" + this.linkWording + '\'' + ", linkColor='" + this.linkColor + '\'' + ", jumpType='" + this.jumpType + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo
 * JD-Core Version:    0.7.0.1
 */