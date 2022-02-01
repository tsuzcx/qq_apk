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
    byte[] arrayOfByte = null;
    if (paramCommonBody == null) {
      return null;
    }
    CommonBody localCommonBody = new CommonBody();
    int i;
    if (paramCommonBody.uint32_oidb_cmd.has()) {
      i = paramCommonBody.uint32_oidb_cmd.get();
    } else {
      i = 0;
    }
    localCommonBody.cmd = i;
    if (paramCommonBody.string_oidb_body.has()) {
      arrayOfByte = paramCommonBody.string_oidb_body.get().toByteArray();
    }
    localCommonBody.rspBodyContent = arrayOfByte;
    return localCommonBody;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommonBody{cmd=");
    localStringBuilder.append(this.cmd);
    localStringBuilder.append(", rspBodyContent=");
    localStringBuilder.append(this.rspBodyContent.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.CommonBody
 * JD-Core Version:    0.7.0.1
 */