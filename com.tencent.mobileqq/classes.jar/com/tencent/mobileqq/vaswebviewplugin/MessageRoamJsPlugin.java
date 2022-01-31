package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import aphy;
import apic;
import becq;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageRoamJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String ACTION = "action";
  public static final String DATA = "data";
  public static final String DEVLOCKISOPEN = "devlockIsOpen";
  public static final String DEVLOCKSTATUS = "devLockStatus";
  public static final String ERROEMESSAGE = "errorMessage";
  public static final String ISSETPASSWORD = "isSetPassword";
  public static final int NOT_VERIFY_PASSWORD = 3000;
  public static final String PKGNAME = "msgRoam";
  public static final String RESULT = "result";
  public static final int RESULT_CODE = 2000;
  public static final String SECURITYPHONENUMBER = "hasSecurityPhoneNumber";
  private static final String TAG = "MessageRoamJsPlugin";
  public static final String TYPE = "type";
  public static final String USERTYPE = "userType";
  public static final String VERIFICATION = "verification";
  public static final String listenPswEventUrl = "http://clientui.3g.qq.com/mqqapi/im/roam";
  Activity browserActivity = null;
  BrowserAppInterface browserAppInterface = null;
  Context context = null;
  public String listenCallback;
  
  public MessageRoamJsPlugin()
  {
    this.mPluginNameSpace = "msgRoam";
  }
  
  private boolean handleAddListenPswEvent(String paramString)
  {
    this.listenCallback = paramString;
    return true;
  }
  
  private boolean handleGetRoam(String paramString)
  {
    sendRemoteReq(apic.a("getRoam", paramString, this.mOnRemoteResp.key, new Bundle()), false, false);
    return true;
  }
  
  private boolean handleRemoveListenPswEvent(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("result", "0");
        localJSONObject.put("errorMessage", "success");
        callJs(paramString, new String[] { localJSONObject.toString() });
        return true;
      }
      catch (JSONException localJSONException1) {}
      try
      {
        localJSONObject.put("result", "-1");
        localJSONObject.put("errorMessage", "handleRemoveListenPswEvent , JSONException,encode json is error");
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  private boolean handleSetRoam(int paramInt, String paramString)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("MessageRoamJsPlugin", 2, "handleSetRoam messageRoamType: " + paramInt);
    }
    String str = "success";
    Object localObject;
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5))
    {
      localObject = this.context.getSharedPreferences("vip_message_roam_banner_file", 4);
      if (localObject != null)
      {
        ((SharedPreferences)localObject).edit().putInt("message_roam_flag" + this.browserAppInterface.getCurrentAccountUin(), paramInt).commit();
        paramInt = 0;
      }
    }
    for (;;)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", paramInt);
      ((JSONObject)localObject).put("errorMessage", str);
      callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
      return true;
      log("SharedPreferences is null");
      str = "SharedPreferences is null";
      paramInt = i;
      continue;
      log("messageRoamType is error , = " + paramInt);
      str = "messageRoamType is error";
      paramInt = i;
    }
  }
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageRoamJsPlugin", 2, paramString);
    }
  }
  
  private void setAuthMode(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageRoamJsPlugin", 2, "setAuthMode mode: " + paramInt);
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("result", -1);
    if ((paramInt == 1) || (paramInt == 0))
    {
      SharedPreferences localSharedPreferences = this.context.getSharedPreferences("vip_message_roam_banner_file", 4);
      if (localSharedPreferences != null)
      {
        localSharedPreferences.edit().putInt("auth_mode_" + this.browserAppInterface.getCurrentAccountUin(), paramInt).commit();
        localJSONObject.put("result", 0);
      }
    }
    for (;;)
    {
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
      localJSONObject.put("errorMessage", "authmode illeage");
    }
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934600L)
    {
      if (((Integer)paramMap.get("resultCode")).intValue() == 2000)
      {
        paramString = (Intent)paramMap.get("data");
        if (paramString != null)
        {
          paramString = paramString.getCharSequenceExtra("result");
          if (paramString == null) {
            return false;
          }
          log("listenCallback = " + this.listenCallback + "result = " + paramString.toString());
          callJs(this.listenCallback, new String[] { paramString.toString().trim() });
          return true;
        }
      }
    }
    else if ((paramLong == 8589934601L) && ((paramString.startsWith("http://mapp.3g.qq.com/touch/psw/verify.jsp")) || (paramString.startsWith("http://mapp.3g.qq.com/touch/psw/create.jsp"))))
    {
      this.browserActivity.setResult(3000);
      this.browserActivity.finish();
      return true;
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("msgRoam"))) {
      log("handleJsRequest returned, pkgName=" + paramString2);
    }
    for (;;)
    {
      return false;
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1 == null) {}
      }
      catch (JSONException paramJsBridgeListener)
      {
        try
        {
          for (;;)
          {
            paramJsBridgeListener = paramString1.optString("callback");
            try
            {
              log("handleJsRequest:method:" + paramString3 + ",callback" + paramJsBridgeListener + ", json:" + paramString1.toString());
              if (paramString3.equals("setRoam"))
              {
                boolean bool = handleSetRoam(paramString1.getInt("type"), paramJsBridgeListener);
                return bool;
                paramJsBridgeListener = paramJsBridgeListener;
                log("failed to parse json str,json=" + null);
                paramJsBridgeListener.printStackTrace();
                paramString1 = null;
              }
              else if (paramString3.equals("getRoam"))
              {
                handleGetRoam(paramJsBridgeListener);
              }
              else if (paramString3.equals("addListenPswEvent"))
              {
                handleAddListenPswEvent(paramJsBridgeListener);
              }
            }
            catch (Exception paramString1) {}
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramJsBridgeListener = null;
          }
        }
        log("handleJsRequest exception:" + paramString1.toString());
        try
        {
          paramString1 = new JSONObject();
          paramString1.put("result", -1);
          paramString1.put("errorMessage", "exception");
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
        if (paramString3.equals("removeListenPswEvent"))
        {
          handleRemoveListenPswEvent(paramJsBridgeListener);
        }
        else if ("setAuthMode".equals(paramString3))
        {
          paramString1 = paramString1.getString("authMode");
          if ("devlock".equals(paramString1)) {
            setAuthMode(paramJsBridgeListener, 1);
          } else if ("password".equals(paramString1)) {
            setAuthMode(paramJsBridgeListener, 0);
          }
        }
        else
        {
          log("unimplement method" + paramString3);
        }
      }
    }
    return true;
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    paramString2 = null;
    if (!paramString1.startsWith("http://clientui.3g.qq.com/mqqapi/im/roam")) {}
    do
    {
      return false;
      try
      {
        paramString1 = Uri.parse(paramString1);
        localObject2 = paramString1.getQueryParameter("src_type");
        localObject1 = paramString1.getQueryParameter("version");
        str = paramString1.getQueryParameter("action");
        paramString1 = paramString1.getQueryParameter("pwd");
        paramString2 = str;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          try
          {
            ((JSONObject)localObject2).put("action", paramString2);
            ((JSONObject)localObject1).putOpt("data", localObject2);
            ((JSONObject)localObject1).put("result", i);
            ((JSONObject)localObject1).put("errorMessage", paramString1);
            paramString1 = new Intent();
            paramString1.putExtra("result", ((JSONObject)localObject1).toString());
            this.browserActivity.setResult(2000, paramString1);
            this.browserActivity.finish();
            return true;
          }
          catch (JSONException paramString1) {}
          paramString1 = paramString1;
          paramString1.printStackTrace();
          String str = null;
          Object localObject1 = null;
          Object localObject2 = null;
          paramString1 = paramString2;
          paramString2 = str;
          continue;
          int i = -1;
          paramString1 = "action is not open,reset,close";
          log("action is not open,reset,close");
          continue;
          try
          {
            ((JSONObject)localObject1).put("result", "-1");
            ((JSONObject)localObject1).put("errorMessage", "JSONException,encode json is error");
            paramString1.printStackTrace();
          }
          catch (JSONException paramString2)
          {
            for (;;)
            {
              paramString2.printStackTrace();
            }
          }
          paramString1 = "success";
          i = 0;
        }
      }
      log("srcType = " + (String)localObject2 + " , version = " + (String)localObject1 + " , action = " + paramString2);
    } while ((localObject2 == null) || (localObject1 == null) || (paramString2 == null));
    if ((paramString2.equals("open")) || (paramString2.equals("reset")) || (paramString2.equals("close")) || (paramString2.equals("history")))
    {
      notifyGetMsgRoam(paramString1);
      if (!paramString2.equals("reset")) {
        break label398;
      }
      this.context.getSharedPreferences("vip_message_roam_banner_file", 4).edit().putInt("message_roam_is_set_password" + this.browserAppInterface.getCurrentAccountUin(), 1).commit();
      paramString1 = "success";
      i = 0;
      localObject1 = new JSONObject();
      localObject2 = new JSONObject();
    }
  }
  
  public void notifyGetMsgRoam(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pwd", paramString);
    sendRemoteReq(apic.a("notifyGetMsgRoam", "notifyGetMsgRoam", this.mOnRemoteResp.key, localBundle), true, false);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof BrowserAppInterface))) {
      this.browserAppInterface = ((BrowserAppInterface)this.mRuntime.a());
    }
    this.browserActivity = this.mRuntime.a();
    this.context = this.mRuntime.a().getApplicationContext();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.context = null;
    this.browserActivity = null;
    this.browserAppInterface = null;
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle != null) {
      try
      {
        if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
        {
          Object localObject = paramBundle.getString("cmd");
          String str = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          log("onResponse,callback=" + str + ",cmd=" + (String)localObject + ",respbundle=" + paramBundle);
          if ((localObject != null) && ("getRoam".equals(localObject)))
          {
            localObject = new JSONObject();
            JSONObject localJSONObject = new JSONObject();
            if (paramBundle == null)
            {
              ((JSONObject)localObject).put("result", -1);
              ((JSONObject)localObject).put("errorMessage", "invalid data, response data is null");
            }
            for (;;)
            {
              log("onResponse, callJs: " + ((JSONObject)localObject).toString());
              callJs(str, new String[] { ((JSONObject)localObject).toString() });
              return;
              localJSONObject.put("type", paramBundle.getInt("type"));
              localJSONObject.put("userType", paramBundle.getInt("userType"));
              localJSONObject.put("isSetPassword", paramBundle.getInt("isSetPassword"));
              localJSONObject.put("devlockIsOpen", paramBundle.getBoolean("devlockIsOpen"));
              localJSONObject.put("verification", paramBundle.getString("verification"));
              localJSONObject.put("hasSecurityPhoneNumber", paramBundle.getBoolean("hasSecurityPhoneNumber"));
              ((JSONObject)localObject).putOpt("data", localJSONObject);
              ((JSONObject)localObject).put("result", paramBundle.getInt("result"));
              ((JSONObject)localObject).put("errorMessage", paramBundle.getString("errorMessage"));
            }
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin
 * JD-Core Version:    0.7.0.1
 */