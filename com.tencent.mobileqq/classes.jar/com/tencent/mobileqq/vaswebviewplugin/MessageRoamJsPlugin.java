package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageRoamJsPlugin
  extends VasWebviewJsPlugin
  implements IPreCreatePluginChecker
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
  public String listenCallback = null;
  
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
    sendRemoteReq(DataFactory.a("getRoam", paramString, this.mOnRemoteResp.key, new Bundle()), false, false);
    return true;
  }
  
  private boolean handleRemoveListenPswEvent(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", "0");
      localJSONObject.put("errorMessage", "success");
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        localJSONObject.put("result", "-1");
        localJSONObject.put("errorMessage", "handleRemoveListenPswEvent , JSONException,encode json is error");
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      localJSONException1.printStackTrace();
    }
    callJs(paramString, new String[] { localJSONObject.toString() });
    return true;
  }
  
  private boolean handleSetRoam(int paramInt, String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleSetRoam messageRoamType: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MessageRoamJsPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    int i = -1;
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("messageRoamType is error , = ");
      ((StringBuilder)localObject1).append(paramInt);
      log(((StringBuilder)localObject1).toString());
      localObject1 = "messageRoamType is error";
      paramInt = i;
    }
    else
    {
      localObject1 = this.context.getSharedPreferences("vip_message_roam_banner_file", 4);
      if (localObject1 != null)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("message_roam_flag");
        ((StringBuilder)localObject2).append(this.browserAppInterface.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), paramInt).commit();
        localObject1 = "success";
        paramInt = 0;
      }
      else
      {
        log("SharedPreferences is null");
        localObject1 = "SharedPreferences is null";
        paramInt = i;
      }
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("result", paramInt);
    ((JSONObject)localObject2).put("errorMessage", localObject1);
    callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
    return true;
  }
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageRoamJsPlugin", 2, paramString);
    }
  }
  
  private void setAuthMode(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setAuthMode mode: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MessageRoamJsPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("result", -1);
    if ((paramInt != 1) && (paramInt != 0))
    {
      ((JSONObject)localObject1).put("errorMessage", "authmode illeage");
    }
    else
    {
      Object localObject2 = this.context.getSharedPreferences("vip_message_roam_banner_file", 4);
      if (localObject2 != null)
      {
        localObject2 = ((SharedPreferences)localObject2).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("auth_mode_");
        localStringBuilder.append(this.browserAppInterface.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), paramInt).commit();
        ((JSONObject)localObject1).put("result", 0);
      }
    }
    callJs(paramString, new String[] { ((JSONObject)localObject1).toString() });
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
          paramMap = new StringBuilder();
          paramMap.append("listenCallback = ");
          paramMap.append(this.listenCallback);
          paramMap.append("result = ");
          paramMap.append(paramString.toString());
          log(paramMap.toString());
          callJs(this.listenCallback, new String[] { paramString.toString().trim() });
          return true;
        }
      }
    }
    else if ((paramLong == 8589934601L) && ((paramString.contains("mapp.3g.qq.com/touch/psw/create.jsp")) || (paramString.contains("mapp.3g.qq.com/touch/psw/verify.jsp"))))
    {
      this.browserActivity.setResult(3000);
      this.browserActivity.finish();
      return true;
    }
    return false;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 1L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase("msgRoam")))
    {
      paramJsBridgeListener = null;
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
      }
      catch (JSONException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("failed to parse json str,json=");
        paramString2.append(null);
        log(paramString2.toString());
        paramString1.printStackTrace();
        paramString1 = null;
      }
      if (paramString1 == null) {
        return false;
      }
      try
      {
        paramString2 = paramString1.optString("callback");
        paramJsBridgeListener = paramString2;
        paramVarArgs = new StringBuilder();
        paramJsBridgeListener = paramString2;
        paramVarArgs.append("handleJsRequest:method:");
        paramJsBridgeListener = paramString2;
        paramVarArgs.append(paramString3);
        paramJsBridgeListener = paramString2;
        paramVarArgs.append(",callback");
        paramJsBridgeListener = paramString2;
        paramVarArgs.append(paramString2);
        paramJsBridgeListener = paramString2;
        paramVarArgs.append(", json:");
        paramJsBridgeListener = paramString2;
        paramVarArgs.append(paramString1.toString());
        paramJsBridgeListener = paramString2;
        log(paramVarArgs.toString());
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("setRoam"))
        {
          paramJsBridgeListener = paramString2;
          return handleSetRoam(paramString1.getInt("type"), paramString2);
        }
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("getRoam"))
        {
          paramJsBridgeListener = paramString2;
          handleGetRoam(paramString2);
          return true;
        }
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("addListenPswEvent"))
        {
          paramJsBridgeListener = paramString2;
          handleAddListenPswEvent(paramString2);
          return true;
        }
        paramJsBridgeListener = paramString2;
        if (paramString3.equals("removeListenPswEvent"))
        {
          paramJsBridgeListener = paramString2;
          handleRemoveListenPswEvent(paramString2);
          return true;
        }
        paramJsBridgeListener = paramString2;
        if ("setAuthMode".equals(paramString3))
        {
          paramJsBridgeListener = paramString2;
          paramString1 = paramString1.getString("authMode");
          paramJsBridgeListener = paramString2;
          if ("devlock".equals(paramString1))
          {
            paramJsBridgeListener = paramString2;
            setAuthMode(paramString2, 1);
            return true;
          }
          paramJsBridgeListener = paramString2;
          if ("password".equals(paramString1))
          {
            paramJsBridgeListener = paramString2;
            setAuthMode(paramString2, 0);
            return true;
          }
        }
        else
        {
          paramJsBridgeListener = paramString2;
          paramString1 = new StringBuilder();
          paramJsBridgeListener = paramString2;
          paramString1.append("unimplement method");
          paramJsBridgeListener = paramString2;
          paramString1.append(paramString3);
          paramJsBridgeListener = paramString2;
          log(paramString1.toString());
          return true;
        }
      }
      catch (Exception paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("handleJsRequest exception:");
        paramString2.append(paramString1.toString());
        log(paramString2.toString());
        try
        {
          paramString1 = new JSONObject();
          paramString1.put("result", -1);
          paramString1.put("errorMessage", "exception");
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      return true;
    }
    paramJsBridgeListener = new StringBuilder();
    paramJsBridgeListener.append("handleJsRequest returned, pkgName=");
    paramJsBridgeListener.append(paramString2);
    log(paramJsBridgeListener.toString());
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool = paramString1.startsWith("http://clientui.3g.qq.com/mqqapi/im/roam");
    int i = 0;
    if (!bool) {
      return false;
    }
    Object localObject1 = null;
    String str;
    Object localObject2;
    try
    {
      paramString1 = Uri.parse(paramString1);
      str = paramString1.getQueryParameter("src_type");
      localObject2 = paramString1.getQueryParameter("version");
      paramString2 = paramString1.getQueryParameter("action");
      paramString1 = paramString1.getQueryParameter("pwd");
      localObject1 = str;
      str = paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      str = null;
      paramString1 = str;
      paramString2 = paramString1;
      localObject2 = paramString1;
    }
    paramString1 = new StringBuilder();
    paramString1.append("srcType = ");
    paramString1.append((String)localObject1);
    paramString1.append(" , version = ");
    paramString1.append((String)localObject2);
    paramString1.append(" , action = ");
    paramString1.append(paramString2);
    log(paramString1.toString());
    if ((localObject1 != null) && (localObject2 != null) && (paramString2 != null))
    {
      if ((!paramString2.equals("open")) && (!paramString2.equals("reset")) && (!paramString2.equals("close")) && (!paramString2.equals("history")))
      {
        i = -1;
        paramString1 = "action is not open,reset,close";
        log("action is not open,reset,close");
      }
      else
      {
        notifyGetMsgRoam(str);
        if (paramString2.equals("reset"))
        {
          paramString1 = this.context.getSharedPreferences("vip_message_roam_banner_file", 4).edit();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("message_roam_is_set_password");
          ((StringBuilder)localObject1).append(this.browserAppInterface.getCurrentAccountUin());
          paramString1.putInt(((StringBuilder)localObject1).toString(), 1).commit();
        }
        paramString1 = "success";
      }
      localObject1 = new JSONObject();
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("action", paramString2);
        ((JSONObject)localObject1).putOpt("data", localObject2);
        ((JSONObject)localObject1).put("result", i);
        ((JSONObject)localObject1).put("errorMessage", paramString1);
      }
      catch (JSONException paramString1)
      {
        try
        {
          ((JSONObject)localObject1).put("result", "-1");
          ((JSONObject)localObject1).put("errorMessage", "JSONException,encode json is error");
        }
        catch (JSONException paramString2)
        {
          paramString2.printStackTrace();
        }
        paramString1.printStackTrace();
      }
      paramString1 = new Intent();
      paramString1.putExtra("result", ((JSONObject)localObject1).toString());
      this.browserActivity.setResult(2000, paramString1);
      this.browserActivity.finish();
      return true;
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return (paramString1.startsWith("http://clientui.3g.qq.com/mqqapi/im/roam")) || (paramString1.startsWith("https://mapp.3g.qq.com/touch/psw/verify.jsp")) || (paramString1.startsWith("https://mapp.3g.qq.com/touch/psw/create.jsp"));
  }
  
  public void notifyGetMsgRoam(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("pwd", paramString);
    sendRemoteReq(DataFactory.a("notifyGetMsgRoam", "notifyGetMsgRoam", this.mOnRemoteResp.key, localBundle), true, false);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if ((this.mRuntime.b() != null) && ((this.mRuntime.b() instanceof BrowserAppInterface))) {
      this.browserAppInterface = ((BrowserAppInterface)this.mRuntime.b());
    }
    this.browserActivity = this.mRuntime.d();
    this.context = this.mRuntime.d().getApplicationContext();
  }
  
  protected void onDestroy()
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
          Object localObject1 = paramBundle.getString("cmd");
          String str = paramBundle.getString("callbackid");
          paramBundle = paramBundle.getBundle("response");
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onResponse,callback=");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(",cmd=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(",respbundle=");
          ((StringBuilder)localObject2).append(paramBundle);
          log(((StringBuilder)localObject2).toString());
          if ((localObject1 != null) && ("getRoam".equals(localObject1)))
          {
            localObject1 = new JSONObject();
            localObject2 = new JSONObject();
            if (paramBundle == null)
            {
              ((JSONObject)localObject1).put("result", -1);
              ((JSONObject)localObject1).put("errorMessage", "invalid data, response data is null");
            }
            else
            {
              ((JSONObject)localObject2).put("type", paramBundle.getInt("type"));
              ((JSONObject)localObject2).put("userType", paramBundle.getInt("userType"));
              ((JSONObject)localObject2).put("isSetPassword", paramBundle.getInt("isSetPassword"));
              ((JSONObject)localObject2).put("devlockIsOpen", paramBundle.getBoolean("devlockIsOpen"));
              ((JSONObject)localObject2).put("verification", paramBundle.getString("verification"));
              ((JSONObject)localObject2).put("hasSecurityPhoneNumber", paramBundle.getBoolean("hasSecurityPhoneNumber"));
              ((JSONObject)localObject1).putOpt("data", localObject2);
              ((JSONObject)localObject1).put("result", paramBundle.getInt("result"));
              ((JSONObject)localObject1).put("errorMessage", paramBundle.getString("errorMessage"));
            }
            paramBundle = new StringBuilder();
            paramBundle.append("onResponse, callJs: ");
            paramBundle.append(((JSONObject)localObject1).toString());
            log(paramBundle.toString());
            callJs(str, new String[] { ((JSONObject)localObject1).toString() });
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin
 * JD-Core Version:    0.7.0.1
 */