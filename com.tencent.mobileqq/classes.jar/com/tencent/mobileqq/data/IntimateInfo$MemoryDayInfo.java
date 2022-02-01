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
    if (paramDateTips.bytes_icon_url.has()) {
      localObject1 = paramDateTips.bytes_icon_url.get().toStringUtf8();
    } else {
      localObject1 = null;
    }
    localMemoryDayInfo.iconUrl = ((String)localObject1);
    if (paramDateTips.bytes_wording.has()) {
      localObject1 = paramDateTips.bytes_wording.get().toStringUtf8();
    } else {
      localObject1 = null;
    }
    localMemoryDayInfo.wording = ((String)localObject1);
    if (paramDateTips.bytes_link_url.has()) {
      localObject1 = paramDateTips.bytes_link_url.get().toStringUtf8();
    } else {
      localObject1 = null;
    }
    localMemoryDayInfo.linkUrl = ((String)localObject1);
    if (paramDateTips.bytes_link_wording.has()) {
      localObject1 = paramDateTips.bytes_link_wording.get().toStringUtf8();
    } else {
      localObject1 = null;
    }
    localMemoryDayInfo.linkWording = ((String)localObject1);
    Object localObject1 = localObject2;
    if (paramDateTips.bytes_link_colour.has()) {
      localObject1 = paramDateTips.bytes_link_colour.get().toStringUtf8();
    }
    localMemoryDayInfo.linkColor = ((String)localObject1);
    localMemoryDayInfo.jumpType = paramDateTips.eJumpType.get();
    return localMemoryDayInfo;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MemoryDayInfo{date=");
    localStringBuilder.append(this.date);
    localStringBuilder.append(", dateType='");
    localStringBuilder.append(this.dateType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.wording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", linkUrl='");
    localStringBuilder.append(this.linkUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", linkWording='");
    localStringBuilder.append(this.linkWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", linkColor='");
    localStringBuilder.append(this.linkColor);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpType='");
    localStringBuilder.append(this.jumpType);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo
 * JD-Core Version:    0.7.0.1
 */