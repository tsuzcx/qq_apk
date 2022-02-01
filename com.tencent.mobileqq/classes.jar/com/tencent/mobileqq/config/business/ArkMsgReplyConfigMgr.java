package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.JsonUtil;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArkMsgReplyConfigMgr
{
  private static volatile ArkMsgReplyConfigMgr jdField_a_of_type_ComTencentMobileqqConfigBusinessArkMsgReplyConfigMgr;
  private LinkedHashMap<String, ArkMsgReplyConfig> jdField_a_of_type_JavaUtilLinkedHashMap;
  
  public static int a(String paramString1, String paramString2)
  {
    if (("com.tencent.structmsg".equals(paramString1)) && ("news".equals(paramString2))) {
      return 11;
    }
    if (("com.tencent.structmsg".equals(paramString1)) && ("video".equals(paramString2))) {
      return 12;
    }
    if (("com.tencent.structmsg".equals(paramString1)) && ("music".equals(paramString2))) {
      return 13;
    }
    if (("com.tencent.map".equals(paramString1)) && ("LocationShare".equals(paramString2))) {
      return 14;
    }
    return 10;
  }
  
  private ArkMsgReplyConfig a(String paramString1, String paramString2)
  {
    ArkMsgReplyConfig localArkMsgReplyConfig = new ArkMsgReplyConfig();
    localArkMsgReplyConfig.a = paramString1;
    localArkMsgReplyConfig.b = paramString2;
    if (!localArkMsgReplyConfig.a()) {
      return null;
    }
    return (ArkMsgReplyConfig)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localArkMsgReplyConfig.a());
  }
  
  public static ArkMsgReplyConfigMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqConfigBusinessArkMsgReplyConfigMgr == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqConfigBusinessArkMsgReplyConfigMgr == null)
      {
        jdField_a_of_type_ComTencentMobileqqConfigBusinessArkMsgReplyConfigMgr = new ArkMsgReplyConfigMgr();
        jdField_a_of_type_ComTencentMobileqqConfigBusinessArkMsgReplyConfigMgr.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        jdField_a_of_type_ComTencentMobileqqConfigBusinessArkMsgReplyConfigMgr.b(jdField_a_of_type_ComTencentMobileqqConfigBusinessArkMsgReplyConfigMgr.a());
      }
      return jdField_a_of_type_ComTencentMobileqqConfigBusinessArkMsgReplyConfigMgr;
    }
    finally {}
  }
  
  private String a(JSONObject paramJSONObject, String paramString)
  {
    String str = paramString;
    try
    {
      if (a(paramString)) {
        str = paramString.substring("jsonpath:".length());
      }
      paramJSONObject = new ArkJSONPath(str).a(JsonUtil.a(paramJSONObject));
      if (paramJSONObject == null)
      {
        ArkAppCenter.c("ArkMsgReplyConfigMgr", "getContentByPath error: object == null");
        return "";
      }
      paramJSONObject = paramJSONObject.toString();
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      ArkAppCenter.c("ArkMsgReplyConfigMgr", "getContentByPath exception");
    }
    return "";
  }
  
  private JSONObject a()
  {
    Object localObject = ArkAiAppCenter.a("kArkMsgReplyConfig");
    try
    {
      localObject = new JSONObject((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      ArkAppCenter.c("ArkMsgReplyConfigMgr", "loadConfig exception");
    }
    return null;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("jsonpath:")) {
      return false;
    }
    return true;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (paramJSONObject == null) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("messageReplyConfig");
      QLog.i("ArkMsgReplyConfigMgr", 1, "ArkMsgReplyConfigMgr=" + paramJSONObject);
    } while (paramJSONObject == null);
    int i = 0;
    label47:
    ArkMsgReplyConfig localArkMsgReplyConfig;
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      localArkMsgReplyConfig = new ArkMsgReplyConfig();
      localArkMsgReplyConfig.a = localJSONObject.optString("app", "");
      localArkMsgReplyConfig.b = localJSONObject.optString("view", "");
      localArkMsgReplyConfig.c = localJSONObject.optString("title", "");
      localArkMsgReplyConfig.d = localJSONObject.optString("tag", "");
      localArkMsgReplyConfig.e = localJSONObject.optString("icon", "");
      localArkMsgReplyConfig.f = localJSONObject.optString("action", "");
      localArkMsgReplyConfig.g = localJSONObject.optString("jumpURL", "");
      if (localArkMsgReplyConfig.a()) {
        break label183;
      }
      ArkAppCenter.c("ArkMsgReplyConfigMgr", "parseConfig, item is invalid");
    }
    for (;;)
    {
      i += 1;
      break label47;
      break;
      label183:
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localArkMsgReplyConfig.a(), localArkMsgReplyConfig);
    }
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (TextUtils.isEmpty(str)) {
      paramJSONObject = "{}";
    }
    ArkAiAppCenter.a("kArkMsgReplyConfig", paramJSONObject);
  }
  
  public LinkedHashMap a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("app", "");
    String str2 = paramJSONObject.optString("view", "");
    ArkMsgReplyConfig localArkMsgReplyConfig = a(str1, str2);
    if (localArkMsgReplyConfig == null)
    {
      ArkAppCenter.c("ArkMsgReplyConfigMgr", "getReplyConfigFromMsg: config is null, return empty map");
      return new LinkedHashMap();
    }
    Object localObject1;
    if (a(localArkMsgReplyConfig.c))
    {
      localObject1 = a(paramJSONObject, localArkMsgReplyConfig.c);
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramJSONObject.optString("prompt", "");
      }
      localObject1 = new LinkedHashMap();
      ((LinkedHashMap)localObject1).put("kArkMsgReplyApp", str1);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyView", str2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTitle", localObject2);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyTag", localArkMsgReplyConfig.d);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyIcon", localArkMsgReplyConfig.e);
      ((LinkedHashMap)localObject1).put("kArkMsgReplyAction", localArkMsgReplyConfig.f);
      if (!a(localArkMsgReplyConfig.g)) {
        break label203;
      }
    }
    label203:
    for (paramJSONObject = a(paramJSONObject, localArkMsgReplyConfig.g);; paramJSONObject = localArkMsgReplyConfig.g)
    {
      ((LinkedHashMap)localObject1).put("kArkMsgReplyJumpUrl", paramJSONObject);
      return localObject1;
      localObject1 = localArkMsgReplyConfig.c;
      break;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    b(paramJSONObject);
    c(paramJSONObject);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ArkMsgReplyConfigMgr
 * JD-Core Version:    0.7.0.1
 */