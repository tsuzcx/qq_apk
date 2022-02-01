package com.tencent.mobileqq.data;

import android.util.Base64;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;

public class IntimateInfo$CommonBody
{
  public int cmd;
  public byte[] rspBodyContent;
  
  public static CommonBody copyFrom(oidb_0xcf4.CommonBody paramCommonBody)
  {
    if (paramCommonBody == null) {
      return null;
    }
    CommonBody localCommonBody = new CommonBody();
    int i;
    if (paramCommonBody.uint32_oidb_cmd.has())
    {
      i = paramCommonBody.uint32_oidb_cmd.get();
      localCommonBody.cmd = i;
      if (!paramCommonBody.string_oidb_body.has()) {
        break label70;
      }
    }
    label70:
    for (paramCommonBody = paramCommonBody.string_oidb_body.get().toByteArray();; paramCommonBody = null)
    {
      localCommonBody.rspBodyContent = paramCommonBody;
      return localCommonBody;
      i = 0;
      break;
    }
  }
  
  public static CommonBody copyFromJson(JSONObject paramJSONObject)
  {
    CommonBody localCommonBody = new CommonBody();
    localCommonBody.cmd = paramJSONObject.optInt("cmd");
    localCommonBody.rspBodyContent = Base64.decode(paramJSONObject.optString("rspBodyContent"), 0);
    return localCommonBody;
  }
  
  public JSONObject getJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", this.cmd);
      localJSONObject.put("rspBodyContent", Base64.encodeToString(this.rspBodyContent, 0));
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
    return "CommonBody{cmd=" + this.cmd + ", rspBodyContent=" + this.rspBodyContent.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.CommonBody
 * JD-Core Version:    0.7.0.1
 */