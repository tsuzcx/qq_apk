package com.tencent.mobileqq.vaswebviewplugin;

import alud;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import apmh;
import apml;
import aprh;
import begz;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import myl;
import ndq;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class VasWebviewJsPlugin
  extends VasBasePlugin
{
  private static final String TAG = "VasWebviewJsPlugin";
  myl authCfg;
  public apmh mOnRemoteResp = new VasWebviewJsPlugin.1(this);
  
  private Method getMethod(Class<?> paramClass, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramClass == null) {
      return localObject2;
    }
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    label26:
    if (i < j)
    {
      localObject2 = arrayOfMethod[i];
      if (!((Method)localObject2).getName().equals(paramString)) {
        break label80;
      }
      localObject1 = localObject2;
    }
    label80:
    for (;;)
    {
      i += 1;
      break label26;
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      return getMethod(paramClass.getSuperclass(), paramString);
    }
  }
  
  public boolean call(String paramString1, String paramString2, String paramString3)
  {
    Method localMethod = getMethod(getClass(), paramString1);
    if (localMethod != null)
    {
      if (paramString2 != null) {}
      try
      {
        if (paramString2.length() > 0) {}
        for (JSONObject localJSONObject = new JSONObject(paramString2);; localJSONObject = new JSONObject())
        {
          if (QLog.isColorLevel()) {
            QLog.i("VasWebviewJsPlugin", 2, "JsHandler call class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + localJSONObject);
          }
          localMethod.invoke(this, new Object[] { localJSONObject, paramString3 });
          return true;
        }
        if (!QLog.isColorLevel()) {
          break label491;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VasWebviewJsPlugin", 2, "args is not json string,class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
        }
        callJsOnError(paramString3, localJSONException.getMessage());
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VasWebviewJsPlugin", 2, "Web Bridge call method IllegalAccessException:" + localIllegalAccessException.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
        }
        callJsOnError(paramString3, "No such method.");
        return false;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VasWebviewJsPlugin", 2, "Web Bridge call method InvocationTargetException:" + localInvocationTargetException.getTargetException().getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
        }
        callJsOnError(paramString3, "No such method.");
        return false;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VasWebviewJsPlugin", 2, "Web Bridge call method Exception:" + localException.getMessage() + "class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
        }
        callJsOnError(paramString3, "No such method.");
        return false;
      }
    }
    else
    {
      QLog.i("VasWebviewJsPlugin", 2, "not found method;class=" + getClass().getSimpleName() + ",methodName=" + paramString1 + ",args=" + paramString2);
    }
    label491:
    callJsOnError(paramString3, "No such method.");
    return false;
  }
  
  public boolean call(String paramString, List<String> paramList)
  {
    Method[] arrayOfMethod = getClass().getDeclaredMethods();
    Object localObject2 = null;
    int j = arrayOfMethod.length;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i < j)
      {
        localObject1 = arrayOfMethod[i];
        if ((!((Method)localObject1).getName().equals(paramString)) || (((Method)localObject1).getParameterTypes().length != paramList.size())) {}
      }
      else
      {
        j = paramList.size();
        i = 0;
        label72:
        if (i >= j) {
          break label165;
        }
      }
      try
      {
        paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
        i += 1;
        break label72;
        i += 1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          if (QLog.isDevelopLevel()) {
            QLog.i("JB", 4, "decode failed: " + (String)paramList.get(i));
          }
        }
      }
    }
    label165:
    if (localObject1 != null) {}
    try
    {
      switch (paramList.size())
      {
      }
      for (;;)
      {
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), paramList.get(4), paramList.get(5) });
        break;
        ((Method)localObject1).invoke(this, new Object[0]);
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0) });
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1) });
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2) });
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3) });
        break;
        ((Method)localObject1).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), paramList.get(4) });
        break;
        if (QLog.isDevelopLevel()) {
          QLog.d("JB", 4, "cannot found match method,maybe your method using args type is NO String? request method:class:" + getClass().getSimpleName() + paramString + " args:" + paramList);
        }
        return false;
      }
      return true;
    }
    catch (IllegalAccessException paramString)
    {
      return false;
    }
    catch (InvocationTargetException paramString)
    {
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void callJsOnError(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasWebviewJsPlugin", 2, "VasWebviewJsPlugin.callJsOnError, msg:" + paramString2);
    }
    super.callJs(paramString1 + "({'result':-1,'message':'" + paramString2 + "'})");
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  public void getDomainIpList(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasWebviewJsPlugin", 2, "getDomainIpList: " + paramJSONObject);
    }
    try
    {
      paramJSONObject = paramJSONObject.getString("domain");
      if (TextUtils.isEmpty(paramJSONObject)) {
        throw new Exception("getDomainIpList host is null");
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VasWebviewJsPlugin", 2, "getDomainIpList failed: " + paramJSONObject.getMessage());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("domain", paramJSONObject);
    sendRemoteReq(apml.a("getDomainIpList", paramString, this.mOnRemoteResp.key, localBundle), false, false);
  }
  
  public void getVipType(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasWebviewJsPlugin", 2, "getVipType: " + paramJSONObject);
    }
    try
    {
      paramJSONObject = paramJSONObject.getString("uin");
      if (!paramJSONObject.equals(this.mRuntime.a().getAccount())) {
        throw new Exception("uin illegal");
      }
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VasWebviewJsPlugin", 2, "getVipType failed: " + paramJSONObject.getMessage());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramJSONObject);
    sendRemoteReq(apml.a("getUserVipType", paramString, this.mOnRemoteResp.key, localBundle), false, false);
  }
  
  protected boolean handleEmojiSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool = true;
    if (paramString1 == null) {
      bool = false;
    }
    do
    {
      return bool;
      if (QLog.isDevelopLevel()) {
        QLog.d("VasWebviewJsPlugin", 4, "handleSchemaRequest:" + ndq.b(paramString1, new String[0]));
      }
    } while (paramString1.startsWith("qqvip:") == true);
    if (!Uri.parse(paramString1).getScheme().equals("qqjsbridge"))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("VasWebviewJsPlugin", 4, "can no do with this url");
      }
      return false;
    }
    Object localObject = new ArrayList(Arrays.asList((paramString1 + "/#").split("/")));
    paramString1 = (String)((ArrayList)localObject).get(2);
    paramString2 = (String)((ArrayList)localObject).get(3);
    if (!"_qqJSBridge_".equals(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasWebviewJsPlugin", 2, "can not handle objectname:" + paramString1);
      }
      return false;
    }
    localObject = ((ArrayList)localObject).subList(4, ((ArrayList)localObject).size() - 1);
    if (QLog.isDevelopLevel()) {
      QLog.d("VasWebviewJsPlugin", 4, "calling " + paramString1 + "." + paramString2 + " args:" + localObject);
    }
    String str = this.mRuntime.a().getUrl();
    if (!this.authCfg.a(str, paramString1 + "." + paramString2)) {
      return false;
    }
    return call(paramString2, (List)localObject);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {}
    for (;;)
    {
      try
      {
        this.onPageStartedTime = System.currentTimeMillis();
        return excuteEvent(paramString, paramLong, paramMap);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      if (paramLong == 8589934594L) {
        this.onPageFinishedTime = System.currentTimeMillis();
      }
    }
    return false;
  }
  
  protected boolean handleThemeAndBubbleSchemaRequest(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {}
    for (;;)
    {
      return false;
      paramString1 = paramString1.trim();
      if (Uri.parse(paramString1).getScheme().equals("qqjsbridge"))
      {
        Object localObject = paramString1.split("/");
        if (localObject.length < 6)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("VasWebviewJsPlugin", 2, "url params error:url=" + paramString1 + ",params num=" + localObject.length);
            return false;
          }
        }
        else
        {
          paramString1 = localObject[2];
          paramString2 = localObject[3];
          String str = localObject[4];
          localObject = localObject[5];
          if (!paramString3.equals(paramString1))
          {
            if (QLog.isColorLevel())
            {
              QLog.i("VasWebviewJsPlugin", 2, "can not handle objectname:" + paramString1);
              return false;
            }
          }
          else {
            try
            {
              paramString3 = URLDecoder.decode((String)localObject, "UTF-8");
              if (QLog.isColorLevel()) {
                QLog.i("VasWebviewJsPlugin", 2, "HandleUrl params objectName=" + paramString1 + ",methodName=" + paramString2 + ",callbackId=" + str + ",jsonParams=" + paramString3);
              }
              localObject = this.mRuntime.a().getUrl();
              if (this.authCfg.a((String)localObject, paramString1 + "." + paramString2)) {
                return call(paramString2, paramString3, str);
              }
            }
            catch (UnsupportedEncodingException paramString1)
            {
              if (QLog.isColorLevel()) {
                QLog.i("VasWebviewJsPlugin", 2, "jsonParams UnsupportedEncodingException,jsonParams=" + (String)localObject);
              }
              paramString1.printStackTrace();
            }
          }
        }
      }
    }
    return false;
  }
  
  void onBindedToClient() {}
  
  public void onCreate()
  {
    super.onCreate();
    if (this.authCfg == null) {
      this.authCfg = myl.a();
    }
    aprh.a().a(this.mOnRemoteResp);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aprh.a().b(this.mOnRemoteResp);
  }
  
  void onDisconnectWithService() {}
  
  void onPushMsg(Bundle paramBundle) {}
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject;
    String str;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel()) {
        QLog.i("VasWebviewJsPlugin", 2, "response:" + (String)localObject);
      }
      if ((localObject != null) && (!"getUserVipType".equals(localObject))) {
        break label197;
      }
    }
    for (;;)
    {
      label197:
      try
      {
        localObject = new JSONObject();
        int i = paramBundle.getInt("type");
        ((JSONObject)localObject).put("result", 0);
        ((JSONObject)localObject).put("message", "ok");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", paramBundle.getString("uin"));
        localJSONObject.put("type", i);
        ((JSONObject)localObject).put("data", localJSONObject);
        super.callJs(str, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (JSONException paramBundle) {}
      if ("getDomainIpList".equals(localObject))
      {
        super.callJs(str, new String[] { paramBundle.getString("result") });
        return;
      }
    }
  }
  
  public void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!aprh.a().a())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), alud.a(2131716447), 0).show();
      }
      QLog.e("VasWebviewJsPlugin", 1, "sendRemoteReq error ipc service not ready");
      return;
    }
    if (paramBoolean1)
    {
      aprh.a().b(paramBundle);
      return;
    }
    aprh.a().a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
 * JD-Core Version:    0.7.0.1
 */