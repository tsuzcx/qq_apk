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
    String str;
    if (paramDnaInfo.eDnaType.has())
    {
      i = paramDnaInfo.eDnaType.get();
      localDNAInfo.type = i;
      if (!paramDnaInfo.bytes_icon_url.has()) {
        break label200;
      }
      str = paramDnaInfo.bytes_icon_url.get().toStringUtf8();
      label58:
      localDNAInfo.iconUrl = str;
      if (!paramDnaInfo.bytes_wording.has()) {
        break label206;
      }
      str = paramDnaInfo.bytes_wording.get().toStringUtf8();
      label84:
      localDNAInfo.wording = str;
      if (!paramDnaInfo.bytes_vice_title.has()) {
        break label212;
      }
      str = paramDnaInfo.bytes_vice_title.get().toStringUtf8();
      label110:
      localDNAInfo.viceTitle = str;
      if (!paramDnaInfo.bytes_link_url.has()) {
        break label218;
      }
      str = paramDnaInfo.bytes_link_url.get().toStringUtf8();
      label136:
      localDNAInfo.linkUrl = str;
      if (!paramDnaInfo.bytes_link_wording.has()) {
        break label224;
      }
      str = paramDnaInfo.bytes_link_wording.get().toStringUtf8();
      label162:
      localDNAInfo.linkWording = str;
      if (!paramDnaInfo.bytes_link_colour.has()) {
        break label230;
      }
    }
    label200:
    label206:
    label212:
    label218:
    label224:
    label230:
    for (paramDnaInfo = paramDnaInfo.bytes_link_colour.get().toStringUtf8();; paramDnaInfo = "")
    {
      localDNAInfo.linkColor = paramDnaInfo;
      return localDNAInfo;
      i = 0;
      break;
      str = "";
      break label58;
      str = "";
      break label84;
      str = "";
      break label110;
      str = "";
      break label136;
      str = "";
      break label162;
    }
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
    return "DNAInfo{type=" + this.type + ", iconUrl='" + this.iconUrl + '\'' + ", wording='" + this.wording + '\'' + ", viceTitle='" + this.viceTitle + '\'' + ", linkUrl='" + this.linkUrl + '\'' + ", linkWording='" + this.linkWording + '\'' + ", linkColor='" + this.linkColor + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.DNAInfo
 * JD-Core Version:    0.7.0.1
 */