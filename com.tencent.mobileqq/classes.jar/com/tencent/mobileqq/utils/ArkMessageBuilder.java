package com.tencent.mobileqq.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkMessageBuilder
{
  public static MessageForArkApp a(Bundle paramBundle, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    ArkAppMessage localArkAppMessage = new ArkAppMessage();
    localArkAppMessage.appMinVersion = "0.0.0.1";
    localArkAppMessage.appName = "com.tencent.structmsg";
    localArkAppMessage.appView = a(paramBundle.getInt("req_type"));
    Object localObject = ArkAppCacheMgr.getApplicationFromManifest(localArkAppMessage.appName, localArkAppMessage.appMinVersion);
    if (localObject != null)
    {
      localArkAppMessage.appDesc = ((String)((Map)localObject).get("desc"));
      localArkAppMessage.appMinVersion = ((String)((Map)localObject).get("version"));
    }
    if (TextUtils.isEmpty(localArkAppMessage.appDesc)) {
      localArkAppMessage.appDesc = localArkAppMessage.appName;
    }
    String str = paramBundle.getString("title");
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = localArkAppMessage.appDesc;
    }
    localArkAppMessage.promptText = String.format(HardCodeUtil.a(2131898906), new Object[] { localObject });
    localArkAppMessage.metaList = QQCustomArkDialog.a(paramBundle, localArkAppMessage.appName);
    localArkAppMessage.config = a();
    paramBundle = MessageRecordFactory.a(paramQQAppInterface, paramString1, paramString2, paramInt, localArkAppMessage);
    paramBundle.msgData = localArkAppMessage.toBytes();
    paramBundle.parse();
    return paramBundle;
  }
  
  public static String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("forward", 1);
      localJSONObject.put("autosize", 1);
      localJSONObject.put("type", "normal");
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ArkMessageBuilder", 1, "getConfigValue", localJSONException);
    }
    return localJSONObject.toString();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 2) {
      return "music";
    }
    if (paramInt == 4) {
      return "video";
    }
    return "news";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ArkMessageBuilder
 * JD-Core Version:    0.7.0.1
 */