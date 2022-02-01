package com.tencent.mobileqq.guild.webview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.webview.methods.AddGuildMethod;
import com.tencent.mobileqq.guild.webview.methods.CheckGuildTabOpenMethod;
import com.tencent.mobileqq.guild.webview.methods.FetchGuildIdByInvitedMethod;
import com.tencent.mobileqq.guild.webview.methods.OpenGuildAIOMethod;
import com.tencent.mobileqq.guild.webview.methods.OpenGuildPageByInvitedMethod;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QQGuildJsPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  private static final Map<String, QQGuildJsPlugin.Method> a;
  private BaseQQAppInterface b;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("addGuild", new AddGuildMethod());
    localHashMap.put("openGuildPageByInvited", new OpenGuildPageByInvitedMethod());
    localHashMap.put("fetchGuildIdByInvited", new FetchGuildIdByInvitedMethod());
    localHashMap.put("openGuildAIO", new OpenGuildAIOMethod());
    localHashMap.put("checkGuildTabOpen", new CheckGuildTabOpenMethod());
    a = Collections.unmodifiableMap(localHashMap);
  }
  
  private boolean a(String paramString)
  {
    if (!QQGuildUtil.a(paramString)) {
      return false;
    }
    int i = paramString.indexOf("://qun.qq.com/qqweb/qunpro");
    if (i < 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Url is not contains GUILD_URL_PART! url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("QQGuildJsPlugin", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mqqguild://guild");
    ((StringBuilder)localObject).append(paramString.substring(i + 26));
    localObject = ((StringBuilder)localObject).toString();
    localObject = JumpParser.a(this.b, this.mRuntime.d(), (String)localObject);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Url can't parse to JumpAction! url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("QQGuildJsPlugin", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    ((JumpAction)localObject).c("webview");
    ((JumpAction)localObject).c = paramString;
    ((JumpAction)localObject).a();
    return true;
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramString2);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("&&");
      localStringBuilder2.append(paramString1);
      localStringBuilder2.append("(");
      localStringBuilder2.append(localJSONObject.toString());
      localStringBuilder2.append(");");
      super.callJs(localStringBuilder2.toString());
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGuildJsPlugin", 2, localException.getMessage());
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("callbackId->");
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append(" errorMsg: ");
      localStringBuilder1.append(paramString2);
      QLog.e("QQGuildJsPlugin", 2, localStringBuilder1.toString());
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildJsPlugin", 2, new Object[] { "getWebViewEventByNameSpace-> ", paramString });
    }
    return 0L;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildJsPlugin", 2, new Object[] { "getWebViewEventByNameSpace-> ", paramString });
    }
    return 4294967295L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQGuildJsPlugin", 4, new Object[] { "handleEvent-> ", paramString, " type: ", Long.toBinaryString(paramLong), " info: ", String.valueOf(paramMap) });
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("guild".equals(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGuildJsPlugin", 2, new Object[] { "handleJsRequest-> ", "url: ", paramString1, paramString2, " method:", paramString3, " args:", Arrays.toString(paramVarArgs) });
      }
      paramJsBridgeListener = (QQGuildJsPlugin.Method)a.get(paramString3);
      if (paramJsBridgeListener != null) {
        return paramJsBridgeListener.a(this, paramString1, paramString2, paramString3, paramVarArgs);
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.getString("callback");
        boolean bool = "addGuildInternal".equals(paramString3);
        if (bool)
        {
          paramString2 = new Bundle();
          paramString2.putString("key", paramJsBridgeListener.optString("key"));
          paramString2.putString("joinSig", paramJsBridgeListener.optString("joinSig"));
          paramString2.putInt("from", paramJsBridgeListener.optInt("from"));
          paramJsBridgeListener = QIPCClientHelper.getInstance();
        }
        try
        {
          paramJsBridgeListener.callServer("module_ipc_server_guild", "addGuildInternal", paramString2, new QQGuildJsPlugin.1(this, paramString1));
          return true;
        }
        catch (Exception paramJsBridgeListener) {}
        bool = "handleGuildOpenResult".equals(paramString3);
        if (bool)
        {
          paramString1 = new Bundle();
          paramString1.putString("packageId", paramJsBridgeListener.optString("packageId"));
          if (paramJsBridgeListener.has("gamedata")) {
            paramString1.putString("gamedata", paramJsBridgeListener.optJSONObject("gamedata").toString());
          }
          QIPCClientHelper.getInstance().callServer("module_ipc_server_guild", "handleGuildOpenResult", paramString1, null);
          return true;
        }
        if (!"handleEnterToGroup".equals(paramString3)) {
          break label378;
        }
        paramString1 = new Bundle();
        paramString1.putString("packageId", paramJsBridgeListener.optString("packageId"));
        paramString1.putString("troopUin", paramJsBridgeListener.optString("groupUin"));
        QIPCClientHelper.getInstance().callServer("module_ipc_server_guild", "handleEnterToTroop", paramString1, null);
        return true;
      }
      catch (Exception paramJsBridgeListener) {}
      QLog.e("QQGuildJsPlugin", 1, "handleJsRequest exception=", paramJsBridgeListener);
      label378:
      return true;
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildJsPlugin", 2, new Object[] { "handleSchemaRequest-> ", paramString1, " scheme:", paramString2 });
    }
    if (a(paramString1))
    {
      QQGuildUIUtil.b(this.mRuntime.d(), 2000);
      return true;
    }
    return false;
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildJsPlugin", 2, new Object[] { "isNeedPreCreatePlugin-> ", paramString1, " schema: ", paramString2 });
    }
    return paramString1.contains("://qun.qq.com/qqweb/qunpro");
  }
  
  protected void onActivityReady()
  {
    super.onActivityReady();
    AppRuntime localAppRuntime = this.mRuntime.c();
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      this.b = ((BaseQQAppInterface)localAppRuntime);
    }
  }
  
  protected void onCreate()
  {
    this.mPluginNameSpace = "guild";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.QQGuildJsPlugin
 * JD-Core Version:    0.7.0.1
 */