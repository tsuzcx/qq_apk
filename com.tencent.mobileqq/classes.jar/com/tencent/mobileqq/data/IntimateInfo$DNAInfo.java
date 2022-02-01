package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaInfo;

public class IntimateInfo$DNAInfo
{
  public String iconUrl;
  public String linkColor;
  public String linkUrl;
  public String linkWording;
  public int type;
  public String viceTitle;
  public String wording;
  
  public static DNAInfo copyFrom(oidb_0xcf4.DnaInfo paramDnaInfo)
  {
    if (paramDnaInfo == null) {
      return null;
    }
    DNAInfo localDNAInfo = new DNAInfo();
    int i;
    if (paramDnaInfo.eDnaType.has()) {
      i = paramDnaInfo.eDnaType.get();
    } else {
      i = 0;
    }
    localDNAInfo.type = i;
    boolean bool = paramDnaInfo.bytes_icon_url.has();
    String str2 = "";
    if (bool) {
      str1 = paramDnaInfo.bytes_icon_url.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localDNAInfo.iconUrl = str1;
    if (paramDnaInfo.bytes_wording.has()) {
      str1 = paramDnaInfo.bytes_wording.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localDNAInfo.wording = str1;
    if (paramDnaInfo.bytes_vice_title.has()) {
      str1 = paramDnaInfo.bytes_vice_title.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localDNAInfo.viceTitle = str1;
    if (paramDnaInfo.bytes_link_url.has()) {
      str1 = paramDnaInfo.bytes_link_url.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localDNAInfo.linkUrl = str1;
    if (paramDnaInfo.bytes_link_wording.has()) {
      str1 = paramDnaInfo.bytes_link_wording.get().toStringUtf8();
    } else {
      str1 = "";
    }
    localDNAInfo.linkWording = str1;
    String str1 = str2;
    if (paramDnaInfo.bytes_link_colour.has()) {
      str1 = paramDnaInfo.bytes_link_colour.get().toStringUtf8();
    }
    localDNAInfo.linkColor = str1;
    return localDNAInfo;
  }
  
  public static DNAInfo copyFromJson(JSONObject paramJSONObject)
  {
    DNAInfo localDNAInfo = new DNAInfo();
    localDNAInfo.type = paramJSONObject.optInt("type");
    localDNAInfo.iconUrl = paramJSONObject.optString("iconUrl");
    localDNAInfo.wording = paramJSONObject.optString("wording");
    localDNAInfo.viceTitle = paramJSONObject.optString("viceTitle");
    localDNAInfo.linkUrl = paramJSONObject.optString("linkUrl");
    localDNAInfo.linkWording = paramJSONObject.optString("linkWording");
    localDNAInfo.linkColor = paramJSONObject.optString("linkColor");
    return localDNAInfo;
  }
  
  public JSONObject getJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.type);
      localJSONObject.put("iconUrl", this.iconUrl);
      localJSONObject.put("wording", this.wording);
      localJSONObject.put("viceTitle", this.viceTitle);
      localJSONObject.put("linkUrl", this.linkUrl);
      localJSONObject.put("linkWording", this.linkWording);
      localJSONObject.put("linkColor", this.linkColor);
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
    localStringBuilder.append("DNAInfo{type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.wording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", viceTitle='");
    localStringBuilder.append(this.viceTitle);
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
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.DNAInfo
 * JD-Core Version:    0.7.0.1
 */