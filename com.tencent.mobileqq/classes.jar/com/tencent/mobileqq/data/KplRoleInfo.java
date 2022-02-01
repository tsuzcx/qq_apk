package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.RoleInfo;

public class KplRoleInfo
  extends Entity
{
  public static final String KPL_TAG = "KplMessage";
  public static final String MSG_EXT_KEY = "msg_ext_key";
  public String roleName;
  public String roleScore;
  public String roleUrl;
  
  public static KplRoleInfo parseJsonString(String paramString)
  {
    KplRoleInfo localKplRoleInfo = new KplRoleInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localKplRoleInfo.roleName = paramString.optString("roleName");
      localKplRoleInfo.roleScore = paramString.optString("roleScore");
      localKplRoleInfo.roleUrl = paramString.optString("roleUrl");
      return localKplRoleInfo;
    }
    catch (Exception paramString)
    {
      QLog.e("KplRoleInfo", 1, "parseJsonString exception:");
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static KplRoleInfo parseProtoResp(oidb_0xa28.RoleInfo paramRoleInfo)
  {
    KplRoleInfo localKplRoleInfo = new KplRoleInfo();
    localKplRoleInfo.roleName = paramRoleInfo.bytes_role_name.get().toStringUtf8();
    localKplRoleInfo.roleScore = paramRoleInfo.bytes_role_score.get().toStringUtf8();
    localKplRoleInfo.roleUrl = paramRoleInfo.str_role_url.get();
    return localKplRoleInfo;
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("roleName", this.roleName);
      localJSONObject.put("roleScore", this.roleScore);
      localJSONObject.put("roleUrl", this.roleUrl);
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      QLog.e("KplRoleInfo", 1, "toJsonString exception:");
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.KplRoleInfo
 * JD-Core Version:    0.7.0.1
 */