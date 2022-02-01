package com.tencent.mobileqq.kandian.glue.webplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler;
import com.tencent.mobileqq.kandian.biz.comment.WebCommentEditorHandler.OpenEditorParams;
import com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyMessagesActivity;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.GetEncryptUinAction;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.JsMethodAction;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.OpenTKPublisherAction;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ReadInJoyJsMethodActionController;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ReadInjoyWebShareHelperAction;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ShowPictureAction;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.TweetTopicEntranceShouldShowAction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyWebviewPlugin
  extends WebViewPlugin
  implements IReadInJoyWebViewPlugin
{
  public Bundle b;
  TroopMemberApiClient c = null;
  ReadInjoyWebShareHelperAction d;
  private String e = null;
  
  public ReadInJoyWebviewPlugin()
  {
    this.mPluginNameSpace = "readinjoy";
    ReadInJoyJsMethodActionController.a.a(this);
    h();
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int i = paramIntent.getIntExtra("extra_private_letter_count", 0);
    callJs(this.e, new String[] { Integer.toString(i) });
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    callJs(paramString1, new String[] { RIJJumpUtils.a(paramInt, paramString2).toString() });
  }
  
  private void a(String paramString, Exception paramException)
  {
    if (QLog.isColorLevel())
    {
      paramException.printStackTrace();
      QLog.e("ReadInJoyWebviewPlugin", 2, paramException.getMessage());
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 1);
      localJSONObject.put("msg", paramException.getMessage());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("(");
      localStringBuilder.append(localJSONObject.toString());
      localStringBuilder.append(");");
      super.callJs(localStringBuilder.toString());
      return;
    }
    catch (JSONException paramString)
    {
      label99:
      break label99;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyWebviewPlugin", 2, paramException.getMessage());
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("callback");
    this.c.l(new ReadInJoyWebviewPlugin.1(this, paramJSONObject));
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    this.b.clear();
    long l = new BigInteger(paramJSONObject.getString("feeds_id")).longValue();
    this.b.putLong("feeds_id", Long.valueOf(l).longValue());
    int i = paramJSONObject.optInt("feeds_type", 1);
    this.b.putInt("feeds_type", Integer.valueOf(i).intValue());
    a(DataFactory.a("ipc_kandian_socialfeeds_update", paramString, 0, this.b), false, false);
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return true;
    }
    if (this.d == null) {
      this.d = new ReadInjoyWebShareHelperAction(this, this.c);
    }
    this.d.a(paramArrayOfString[0]);
    return false;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    RIJJumpUtils.a(this.mRuntime.d(), paramJSONObject, new ReadInJoyWebviewPlugin.2(this, paramJSONObject.optString("callback")));
  }
  
  private void c(@NotNull JSONObject paramJSONObject)
  {
    if (this.mRuntime.d() == null) {
      return;
    }
    String str = paramJSONObject.optString("callback");
    Bundle localBundle = new Bundle();
    localBundle.putInt("comment_to_reply_contain_link", paramJSONObject.optInt("report_comment_link_reply", 2));
    localBundle.putBoolean("need_intercept", false);
    WebCommentEditorHandler.OpenEditorParams localOpenEditorParams = new WebCommentEditorHandler.OpenEditorParams();
    localOpenEditorParams.a = this.mRuntime.d();
    localOpenEditorParams.b = paramJSONObject;
    localOpenEditorParams.c = 0;
    localOpenEditorParams.d = str;
    localOpenEditorParams.e = SwiftWebViewUtils.a(10, WebViewUtil.a(this));
    localOpenEditorParams.f = localBundle;
    WebCommentEditorHandler.a(localOpenEditorParams);
  }
  
  private void d(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("callback");
    this.c.a(paramJSONObject, new ReadInJoyWebviewPlugin.3(this, str));
  }
  
  private void e(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        String str2 = paramJSONObject.getString("callback");
        localObject1 = str2;
        String str3 = paramJSONObject.getString("skinId");
        localObject1 = str2;
        boolean bool = paramJSONObject.has("skinUrl");
        if (bool)
        {
          localObject1 = str2;
          localObject2 = paramJSONObject.optString("skinUrl");
          localObject1 = str2;
          if (!paramJSONObject.has("skinName")) {
            break label318;
          }
          localObject1 = str2;
          str1 = paramJSONObject.optString("skinName");
          localObject1 = str2;
          if (!paramJSONObject.has("seq")) {
            break label326;
          }
          localObject1 = str2;
          l1 = paramJSONObject.optLong("seq");
          localObject1 = str2;
          if (!paramJSONObject.has("startTime")) {
            break label332;
          }
          localObject1 = str2;
          l2 = paramJSONObject.optLong("startTime");
          localObject1 = str2;
          if (!paramJSONObject.has("endTime")) {
            break label338;
          }
          localObject1 = str2;
          l3 = paramJSONObject.optLong("endTime");
          localObject1 = str2;
          if (!paramJSONObject.has("volumeIsOn")) {
            break label344;
          }
          localObject1 = str2;
          i = paramJSONObject.optInt("volumeIsOn");
          localObject1 = str2;
          this.c.a(str3, l1, (String)localObject2, str1, l2, l3, i, new ReadInJoyWebviewPlugin.4(this, str2));
          localObject1 = str2;
          QLog.d("ReadInJoyWebviewPlugin", 4, "send set skin cmd to service");
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setSkinAndSound error ");
        ((StringBuilder)localObject2).append(paramJSONObject.toString());
        QLog.w("ReadInJoyWebviewPlugin", 1, ((StringBuilder)localObject2).toString());
        callJs(localObject1, new String[] { "{\"retCode\":-1}" });
        return;
      }
      Object localObject2 = "";
      continue;
      label318:
      String str1 = "";
      continue;
      label326:
      long l1 = 0L;
      continue;
      label332:
      long l2 = 0L;
      continue;
      label338:
      long l3 = 0L;
      continue;
      label344:
      int i = 0;
    }
  }
  
  private void f(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = paramJSONObject.getString("callback");
      localObject1 = localObject2;
      String str1 = paramJSONObject.getString("skinId");
      localObject1 = localObject2;
      String str2 = paramJSONObject.getString("skinUrl");
      localObject1 = localObject2;
      String str3 = paramJSONObject.getString("skinName");
      localObject1 = localObject2;
      long l1 = paramJSONObject.getLong("seq");
      localObject1 = localObject2;
      long l2 = paramJSONObject.getLong("startTime");
      localObject1 = localObject2;
      long l3 = paramJSONObject.getLong("endTime");
      localObject1 = localObject2;
      this.c.a(str1, l1, str2, str3, l2, l3, new ReadInJoyWebviewPlugin.5(this, (String)localObject2));
      localObject1 = localObject2;
      QLog.d("ReadInJoyWebviewPlugin", 4, "send notifyLoadSkin cmd to service");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyLoadSkin error ");
      ((StringBuilder)localObject2).append(paramJSONObject.toString());
      QLog.w("ReadInJoyWebviewPlugin", 1, ((StringBuilder)localObject2).toString());
      callJs(localObject1, new String[] { "{\"retCode\":-1}" });
    }
  }
  
  private void g(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    try
    {
      paramJSONObject = paramJSONObject.getString("callback");
      localJSONObject = paramJSONObject;
      this.c.j(new ReadInJoyWebviewPlugin.6(this, paramJSONObject));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("readSkinAndSound error ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.w("ReadInJoyWebviewPlugin", 1, localStringBuilder.toString());
      callJs(localJSONObject, new String[] { "{\"retCode\":-1}" });
    }
  }
  
  private void h()
  {
    Object localObject = new TweetTopicEntranceShouldShowAction();
    ReadInJoyJsMethodActionController.a.a((JsMethodAction)localObject);
    localObject = new OpenTKPublisherAction();
    ReadInJoyJsMethodActionController.a.a((JsMethodAction)localObject);
    localObject = new GetEncryptUinAction();
    ReadInJoyJsMethodActionController.a.a((JsMethodAction)localObject);
    ReadInJoyJsMethodActionController.a.a(new ShowPictureAction());
  }
  
  private void h(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    try
    {
      String str1 = paramJSONObject.getString("callback");
      localObject1 = str1;
      String str2 = paramJSONObject.getString("skinId");
      localObject2 = "";
      localObject1 = str1;
      if (paramJSONObject.has("skinUrl"))
      {
        localObject1 = str1;
        localObject2 = paramJSONObject.optString("skinUrl");
      }
      localObject1 = str1;
      this.c.d(str2, (String)localObject2, new ReadInJoyWebviewPlugin.7(this, str1));
      localObject1 = str1;
      QLog.d("ReadInJoyWebviewPlugin", 4, "send cancelLoadSkin cmd to service");
      return;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cancelLoadSkin error ");
      ((StringBuilder)localObject2).append(paramJSONObject.toString());
      QLog.w("ReadInJoyWebviewPlugin", 1, ((StringBuilder)localObject2).toString());
      callJs(localObject1, new String[] { "{\"retCode\":-1}" });
    }
  }
  
  private void i()
  {
    Intent localIntent = new Intent(this.mRuntime.d(), ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    startActivityForResult(localIntent, (byte)0);
  }
  
  public int a(byte paramByte, boolean paramBoolean)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.d());
    if ((localObject instanceof WebUiUtils.QQBrowserBaseActivityInterface)) {
      localObject = (WebUiUtils.QQBrowserBaseActivityInterface)localObject;
    } else {
      localObject = null;
    }
    paramByte = 2;
    if (localObject != null) {
      paramByte = ((WebUiUtils.QQBrowserBaseActivityInterface)localObject).switchRequestCode(this, (byte)2, true);
    }
    return paramByte;
  }
  
  public AppRuntime a()
  {
    return this.mRuntime.c();
  }
  
  protected void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.d().getApplicationContext(), HardCodeUtil.a(2131910339), 0).show();
      }
    }
    else
    {
      if (paramBoolean1)
      {
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
        return;
      }
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
    }
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = null;
    try
    {
      String str = paramJSONObject.optString("callback");
      if (str != null)
      {
        localObject = str;
        if (TextUtils.equals("socialize_feeds_update", paramString))
        {
          localObject = str;
          a(paramJSONObject, str);
        }
        else
        {
          localObject = str;
          if (TextUtils.equals("openPrivateLetter", paramString))
          {
            localObject = str;
            this.e = str;
            localObject = str;
            i();
          }
        }
      }
      else
      {
        localObject = str;
        throw new Exception("need callback");
      }
    }
    catch (Exception paramString)
    {
      a(localObject, paramString);
    }
    return true;
  }
  
  @Nullable
  public Object b()
  {
    return this.mRuntime.a();
  }
  
  @Nullable
  public String c()
  {
    return ((WebViewFragment)this.mRuntime.f()).getUin();
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    super.callJs(paramString, paramVarArgs);
  }
  
  @Nullable
  public String d()
  {
    return ((SwiftBrowserShareMenuHandler)((WebViewFragment)this.mRuntime.f()).getComponentProvider().a(4)).n;
  }
  
  @Nullable
  public Activity e()
  {
    return this.mRuntime.d();
  }
  
  @Nullable
  public String f()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.d());
    boolean bool = localObject instanceof WebUiUtils.WebUiMethodInterface;
    String str = null;
    if (bool) {
      localObject = (WebUiUtils.WebUiMethodInterface)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null) {
      str = ((WebUiUtils.WebUiMethodInterface)localObject).getCurrentUrl();
    }
    return str;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "do updateSocialFeedsInfo all");
    }
    this.b.putLong("feeds_id", -1L);
    this.b.putLong("feeds_type", 1L);
    a(DataFactory.a("ipc_kandian_socialfeeds_update", "", 0, this.b), false, false);
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 16777216L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleJsRequest, url=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", pkgName=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", methodName=");
      ((StringBuilder)localObject1).append(paramString3);
      QLog.d("ReadInJoyWebviewPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if ("readinjoy".equals(paramString2))
      {
        if (paramString3 == null) {
          return false;
        }
        if ("showShareReadInJoyMenu".equals(paramString3))
        {
          if (a(paramVarArgs)) {
            return false;
          }
        }
        else
        {
          localObject1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
          if (localObject1 == null) {
            return true;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleJsRequest JSON = ");
            ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
            QLog.d("ReadInJoyWebviewPlugin", 2, ((StringBuilder)localObject2).toString());
          }
          if ((TextUtils.equals("socialize_feeds_update", paramString3)) || (TextUtils.equals("openPrivateLetter", paramString3))) {
            break label405;
          }
          Object localObject2 = ReadInJoyJsMethodActionController.a.a(paramString3);
          if (localObject2 != null) {
            return ((JsMethodAction)localObject2).a(this.c, this.mRuntime.d(), paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
          }
          if ("readSkinAndSound".equals(paramString3))
          {
            g((JSONObject)localObject1);
            return true;
          }
          if ("notifyLoadSkin".equals(paramString3))
          {
            f((JSONObject)localObject1);
            return true;
          }
          if ("cancelLoadSkin".equals(paramString3))
          {
            h((JSONObject)localObject1);
            return true;
          }
          if ("setSkinAndSound".equals(paramString3))
          {
            e((JSONObject)localObject1);
            return true;
          }
          if ("showCommentEditorNative".equals(paramString3))
          {
            c((JSONObject)localObject1);
            return true;
          }
          if ("getALDConfig".equals(paramString3))
          {
            d((JSONObject)localObject1);
            return true;
          }
          if ("showLevelDialog".equalsIgnoreCase(paramString3))
          {
            b((JSONObject)localObject1);
            return true;
          }
          if ("getCommentEmotionData".equalsIgnoreCase(paramString3)) {
            a((JSONObject)localObject1);
          }
        }
        return true;
        label405:
        bool1 = a(paramString3, (JSONObject)localObject1);
      }
    }
    return bool1;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    Log.d("ReadInJoyWebviewPlugin", "onActivityResult()");
    if (paramByte != 0)
    {
      if ((paramByte != 1) && (paramByte != 2))
      {
        if (paramByte != 10) {
          return;
        }
        WebCommentEditorHandler.a(paramInt, paramIntent, new ReadInJoyWebviewPlugin.MyEditorResultReceiver(this));
        return;
      }
      ReadInjoyWebShareHelperAction localReadInjoyWebShareHelperAction = this.d;
      if (localReadInjoyWebShareHelperAction != null) {
        localReadInjoyWebShareHelperAction.a(paramIntent, paramByte, paramInt);
      }
    }
    else
    {
      a(paramIntent);
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.b = new Bundle();
    this.c = TroopMemberApiClient.a();
    this.c.e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g();
    this.c.f();
    ReadInjoyWebShareHelperAction localReadInjoyWebShareHelperAction = this.d;
    if (localReadInjoyWebShareHelperAction != null) {
      localReadInjoyWebShareHelperAction.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */