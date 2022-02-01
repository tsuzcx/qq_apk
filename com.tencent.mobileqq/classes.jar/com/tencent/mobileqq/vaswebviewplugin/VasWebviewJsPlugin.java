package com.tencent.mobileqq.vaswebviewplugin;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class VasWebviewJsPlugin
  extends VasBasePlugin
{
  private static final String TAG = "VasWebviewJsPlugin";
  AuthorizeConfig authCfg;
  public OnRemoteRespObserver mOnRemoteResp = new VasWebviewJsPlugin.1(this);
  
  private Method getMethod(Class<?> paramClass, String paramString)
  {
    Object localObject = null;
    if (paramClass == null) {
      return null;
    }
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (localMethod.getName().equals(paramString)) {
        localObject = localMethod;
      }
      i += 1;
    }
    if (localObject == null) {
      return getMethod(paramClass.getSuperclass(), paramString);
    }
    return localObject;
  }
  
  public boolean call(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = getMethod(getClass(), paramString1);
    if (localObject != null)
    {
      if (paramString2 != null) {}
      try
      {
        JSONObject localJSONObject;
        if (paramString2.length() > 0) {
          localJSONObject = new JSONObject(paramString2);
        } else {
          localJSONObject = new JSONObject();
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("JsHandler call class=");
          localStringBuilder2.append(getClass().getSimpleName());
          localStringBuilder2.append(",methodName=");
          localStringBuilder2.append(paramString1);
          localStringBuilder2.append(",args=");
          localStringBuilder2.append(localJSONObject);
          QLog.i("VasWebviewJsPlugin", 2, localStringBuilder2.toString());
        }
        ((Method)localObject).invoke(this, new Object[] { localJSONObject, paramString3 });
        return true;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Web Bridge call method Exception:");
          ((StringBuilder)localObject).append(localException.getMessage());
          ((StringBuilder)localObject).append("class=");
          ((StringBuilder)localObject).append(getClass().getSimpleName());
          ((StringBuilder)localObject).append(",methodName=");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(",args=");
          ((StringBuilder)localObject).append(paramString2);
          QLog.i("VasWebviewJsPlugin", 2, ((StringBuilder)localObject).toString());
        }
        callJsOnError(paramString3, "No such method.");
        return false;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Web Bridge call method InvocationTargetException:");
          ((StringBuilder)localObject).append(localInvocationTargetException.getTargetException().getMessage());
          ((StringBuilder)localObject).append("class=");
          ((StringBuilder)localObject).append(getClass().getSimpleName());
          ((StringBuilder)localObject).append(",methodName=");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(",args=");
          ((StringBuilder)localObject).append(paramString2);
          QLog.i("VasWebviewJsPlugin", 2, ((StringBuilder)localObject).toString());
        }
        callJsOnError(paramString3, "No such method.");
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Web Bridge call method IllegalAccessException:");
          ((StringBuilder)localObject).append(localIllegalAccessException.getMessage());
          ((StringBuilder)localObject).append("class=");
          ((StringBuilder)localObject).append(getClass().getSimpleName());
          ((StringBuilder)localObject).append(",methodName=");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(",args=");
          ((StringBuilder)localObject).append(paramString2);
          QLog.i("VasWebviewJsPlugin", 2, ((StringBuilder)localObject).toString());
        }
        callJsOnError(paramString3, "No such method.");
        return false;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("args is not json string,class=");
          ((StringBuilder)localObject).append(getClass().getSimpleName());
          ((StringBuilder)localObject).append(",methodName=");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(",args=");
          ((StringBuilder)localObject).append(paramString2);
          QLog.i("VasWebviewJsPlugin", 2, ((StringBuilder)localObject).toString());
        }
        callJsOnError(paramString3, localJSONException.getMessage());
        return false;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("not found method;class=");
      localStringBuilder1.append(getClass().getSimpleName());
      localStringBuilder1.append(",methodName=");
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append(",args=");
      localStringBuilder1.append(paramString2);
      QLog.i("VasWebviewJsPlugin", 2, localStringBuilder1.toString());
    }
    callJsOnError(paramString3, "No such method.");
    return false;
  }
  
  public boolean call(String paramString, List<String> paramList)
  {
    Method[] arrayOfMethod = getClass().getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      localObject = arrayOfMethod[i];
      if ((((Method)localObject).getName().equals(paramString)) && (((Method)localObject).getParameterTypes().length == paramList.size())) {
        break label68;
      }
      i += 1;
    }
    Object localObject = null;
    label68:
    j = paramList.size();
    i = 0;
    while (i < j)
    {
      try
      {
        paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decode failed: ");
          localStringBuilder.append((String)paramList.get(i));
          QLog.i("JB", 4, localStringBuilder.toString());
        }
      }
      i += 1;
    }
    if (localObject != null) {}
    try
    {
      i = paramList.size();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5)
                {
                  ((Method)localObject).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), paramList.get(4), paramList.get(5) });
                  return true;
                }
                ((Method)localObject).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), paramList.get(4) });
                return true;
              }
              ((Method)localObject).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3) });
              return true;
            }
            ((Method)localObject).invoke(this, new Object[] { paramList.get(0), paramList.get(1), paramList.get(2) });
            return true;
          }
          ((Method)localObject).invoke(this, new Object[] { paramList.get(0), paramList.get(1) });
          return true;
        }
        ((Method)localObject).invoke(this, new Object[] { paramList.get(0) });
        return true;
      }
      ((Method)localObject).invoke(this, new Object[0]);
      return true;
    }
    catch (IllegalAccessException|InvocationTargetException|Exception paramString) {}
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot found match method,maybe your method using args type is NO String? request method:class:");
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" args:");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("JB", 4, ((StringBuilder)localObject).toString());
    }
    return false;
    return false;
  }
  
  public void callJsOnError(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("VasWebviewJsPlugin.callJsOnError, msg:");
      localStringBuilder.append(paramString2);
      QLog.d("VasWebviewJsPlugin", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("({'result':-1,'message':'");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("'})");
    super.callJs(localStringBuilder.toString());
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return false;
  }
  
  public void getDomainIpList(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDomainIpList: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("VasWebviewJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramJSONObject = paramJSONObject.getString("domain");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("domain", paramJSONObject);
        sendRemoteReq(DataFactory.a("getDomainIpList", paramString, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
        return;
      }
      throw new Exception("getDomainIpList host is null");
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDomainIpList failed: ");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        QLog.e("VasWebviewJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  public void getVipType(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVipType: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("VasWebviewJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramJSONObject = paramJSONObject.getString("uin");
      if (paramJSONObject.equals(this.mRuntime.b().getAccount()))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("uin", paramJSONObject);
        sendRemoteReq(DataFactory.a("getUserVipType", paramString, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
        return;
      }
      throw new Exception("uin illegal");
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getVipType failed: ");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        QLog.e("VasWebviewJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  protected boolean handleEmojiSchemaRequest(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("handleSchemaRequest:");
      paramString2.append(Util.b(paramString1, new String[0]));
      QLog.d("VasWebviewJsPlugin", 4, paramString2.toString());
    }
    if (paramString1.startsWith("qqvip:") == true) {
      return true;
    }
    if (!Uri.parse(paramString1).getScheme().equals("qqjsbridge"))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("VasWebviewJsPlugin", 4, "can no do with this url");
      }
      return false;
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("/#");
    Object localObject1 = new ArrayList(Arrays.asList(paramString2.toString().split("/")));
    paramString1 = (String)((ArrayList)localObject1).get(2);
    paramString2 = (String)((ArrayList)localObject1).get(3);
    if (!"_qqJSBridge_".equals(paramString1))
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("can not handle objectname:");
        paramString2.append(paramString1);
        QLog.i("VasWebviewJsPlugin", 2, paramString2.toString());
      }
      return false;
    }
    localObject1 = ((ArrayList)localObject1).subList(4, ((ArrayList)localObject1).size() - 1);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("calling ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(".");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" args:");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("VasWebviewJsPlugin", 4, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.mRuntime.a().getUrl();
    AuthorizeConfig localAuthorizeConfig = this.authCfg;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    if (!localAuthorizeConfig.a((String)localObject2, localStringBuilder.toString())) {
      return false;
    }
    return call(paramString2, (List)localObject1);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {}
    try
    {
      this.onPageStartedTime = System.currentTimeMillis();
      break label33;
      if (paramLong == 8589934594L) {
        this.onPageFinishedTime = System.currentTimeMillis();
      }
      label33:
      boolean bool = excuteEvent(paramString, paramLong, paramMap);
      return bool;
    }
    catch (Exception paramString)
    {
      label46:
      break label46;
    }
    paramString.printStackTrace();
    return false;
  }
  
  protected boolean handleThemeAndBubbleSchemaRequest(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return false;
    }
    paramString1 = paramString1.trim();
    if (!Uri.parse(paramString1).getScheme().equals("qqjsbridge")) {
      return false;
    }
    Object localObject = paramString1.split("/");
    if (localObject.length < 6)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("url params error:url=");
        paramString2.append(paramString1);
        paramString2.append(",params num=");
        paramString2.append(localObject.length);
        QLog.i("VasWebviewJsPlugin", 2, paramString2.toString());
      }
      return false;
    }
    paramString1 = localObject[2];
    paramString2 = localObject[3];
    String str = localObject[4];
    localObject = localObject[5];
    if (!paramString3.equals(paramString1))
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("can not handle objectname:");
        paramString2.append(paramString1);
        QLog.i("VasWebviewJsPlugin", 2, paramString2.toString());
      }
      return false;
    }
    try
    {
      paramString3 = URLDecoder.decode((String)localObject, "UTF-8");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("HandleUrl params objectName=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(",methodName=");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(",callbackId=");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(",jsonParams=");
        ((StringBuilder)localObject).append(paramString3);
        QLog.i("VasWebviewJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.mRuntime.a().getUrl();
      AuthorizeConfig localAuthorizeConfig = this.authCfg;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (!localAuthorizeConfig.a((String)localObject, localStringBuilder.toString())) {
        return false;
      }
      return call(paramString2, paramString3, str);
    }
    catch (UnsupportedEncodingException paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("jsonParams UnsupportedEncodingException,jsonParams=");
        paramString2.append((String)localObject);
        QLog.i("VasWebviewJsPlugin", 2, paramString2.toString());
      }
      paramString1.printStackTrace();
    }
    return false;
  }
  
  void onBindedToClient() {}
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.authCfg == null) {
      this.authCfg = AuthorizeConfig.a();
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mOnRemoteResp);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mOnRemoteResp);
  }
  
  void onDisconnectWithService() {}
  
  void onPushMsg(Bundle paramBundle) {}
  
  protected void onResponse(Bundle paramBundle)
  {
    Object localObject1;
    String str;
    Object localObject2;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject1 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("response:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("VasWebviewJsPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 != null) && (!"getUserVipType".equals(localObject1))) {}
    }
    try
    {
      localObject1 = new JSONObject();
      int i = paramBundle.getInt("type");
      ((JSONObject)localObject1).put("result", 0);
      ((JSONObject)localObject1).put("message", "ok");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("uin", paramBundle.getString("uin"));
      ((JSONObject)localObject2).put("type", i);
      ((JSONObject)localObject1).put("data", localObject2);
      super.callJs(str, new String[] { ((JSONObject)localObject1).toString() });
      return;
    }
    catch (JSONException paramBundle) {}
    if ("getDomainIpList".equals(localObject1)) {
      super.callJs(str, new String[] { paramBundle.getString("result") });
    }
    return;
  }
  
  public void sendRemoteReq(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131913261), 0).show();
      }
      QLog.e("VasWebviewJsPlugin", 1, "sendRemoteReq error ipc service not ready");
      return;
    }
    if (paramBoolean1)
    {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
      return;
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
 * JD-Core Version:    0.7.0.1
 */