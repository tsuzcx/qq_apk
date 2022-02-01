package com.tencent.mobileqq.kandian.glue.webplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEntranceUtils;
import com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyMessagesActivity;
import com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.GetEncryptUinAction;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.JsMethodAction;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.OpenTKPublisherAction;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.ReadInJoyJsMethodActionController;
import com.tencent.mobileqq.kandian.glue.webplugin.jsMethodAction.TweetTopicEntranceShouldShowAction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyWebviewPlugin
  extends WebViewPlugin
  implements IReadInJoyWebViewPlugin
{
  public Bundle a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  ReadInjoyWebShareHelper jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper;
  private String jdField_a_of_type_JavaLangString = null;
  
  public ReadInJoyWebviewPlugin()
  {
    this.mPluginNameSpace = "readinjoy";
    ReadInJoyJsMethodActionController.a.a(this);
    b();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    String str1 = paramIntent.getStringExtra("arg_callback");
    String str2 = paramIntent.getStringExtra("arg_result_json");
    Parcelable localParcelable = null;
    Object localObject = localParcelable;
    if (str2 != null) {}
    try
    {
      localObject = new JSONObject(str2);
    }
    catch (JSONException localJSONException)
    {
      label45:
      break label45;
    }
    QLog.e("ReadInJoyWebviewPlugin", 1, "handleCommentEditorNativeResult result parse error.");
    localObject = localParcelable;
    if (localObject == null) {
      return;
    }
    if (paramInt != -1) {}
    try
    {
      ((JSONObject)localObject).put("retCode", -1);
      ((JSONObject)localObject).put("commentId", 0);
    }
    catch (JSONException paramIntent)
    {
      label85:
      break label85;
    }
    QLog.e("ReadInJoyWebviewPlugin", 1, "handleCommentEditorNativeResult put user cancel result error.");
    callJs(str1, new String[] { ((JSONObject)localObject).toString() });
    return;
    localParcelable = paramIntent.getParcelableExtra("comment_create_data");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a((JSONObject)localObject, localParcelable, new ReadInJoyWebviewPlugin.8(this, paramInt, paramIntent, str1));
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
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.j(new ReadInJoyWebviewPlugin.1(this, paramJSONObject));
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle.clear();
    long l = new BigInteger(paramJSONObject.getString("feeds_id")).longValue();
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_id", Long.valueOf(l).longValue());
    int i = paramJSONObject.optInt("feeds_type", 1);
    this.jdField_a_of_type_AndroidOsBundle.putInt("feeds_type", Integer.valueOf(i).intValue());
    a(DataFactory.a("ipc_kandian_socialfeeds_update", paramString, 0, this.jdField_a_of_type_AndroidOsBundle), false, false);
  }
  
  private boolean a(String paramString, int paramInt, Intent paramIntent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    try
    {
      paramString = new JSONObject(paramString);
      bool1 = bool3;
      int i = paramString.optInt("errorCode");
      bool1 = bool3;
      paramString = paramString.optString("comment");
      bool1 = bool2;
      if (i == -4097)
      {
        bool1 = true;
        bool2 = true;
        ReadInJoyCommentEntrance.a(new ReadInJoyWebviewPlugin.9(this, paramInt, paramIntent, paramString));
        bool1 = bool2;
      }
      return bool1;
    }
    catch (JSONException paramString) {}
    return bool1;
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper = new ReadInjoyWebShareHelper(this, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient);
    }
    if (paramArrayOfString == null) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper.a(paramArrayOfString[0]);
    return false;
  }
  
  private void b()
  {
    Object localObject = new TweetTopicEntranceShouldShowAction();
    ReadInJoyJsMethodActionController.a.a((JsMethodAction)localObject);
    localObject = new OpenTKPublisherAction();
    ReadInJoyJsMethodActionController.a.a((JsMethodAction)localObject);
    localObject = new GetEncryptUinAction();
    ReadInJoyJsMethodActionController.a.a((JsMethodAction)localObject);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    RIJJumpUtils.a(this.mRuntime.a(), paramJSONObject, new ReadInJoyWebviewPlugin.2(this, paramJSONObject.optString("callback")));
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this.mRuntime.a(), ReadInJoyMessagesActivity.class);
    localIntent.setFlags(67108864);
    startActivityForResult(localIntent, (byte)0);
  }
  
  private void c(@NotNull JSONObject paramJSONObject)
  {
    if (this.mRuntime.a() == null) {
      return;
    }
    String str1 = paramJSONObject.optString("callback");
    boolean bool1 = paramJSONObject.optBoolean("enableAnonymous", false);
    boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
    int i = paramJSONObject.optInt("maxLength", -1);
    int j = paramJSONObject.optInt("commentType", 0);
    int k = paramJSONObject.optInt("sourceType", 0);
    int m = paramJSONObject.optInt("openAt", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("defaultCommentAtLevel");
    Object localObject1 = paramJSONObject.optString("placeholder");
    try
    {
      localObject2 = new String(Base64Util.decode((String)localObject1, 0));
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      Object localObject2;
      label117:
      break label117;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showCommentEditorNative | comment_placeholder decode error! | comment_placeholder: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.e("ReadInJoyWebviewPlugin", 1, ((StringBuilder)localObject2).toString());
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showCommentEditorNative | comment_placeholder after decode: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ReadInJoyWebviewPlugin", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = paramJSONObject.optString("defaultTxt");
    try
    {
      localObject3 = new String(Base64Util.decode((String)localObject2, 0));
      localObject2 = localObject3;
    }
    catch (Exception localException2)
    {
      Object localObject3;
      label228:
      String str2;
      int n;
      int i1;
      String str5;
      String str3;
      long l;
      String str4;
      Intent localIntent;
      break label228;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("showCommentEditorNative | defaultTxt decode error! | defaultTxt: ");
    ((StringBuilder)localObject3).append((String)localObject2);
    QLog.e("ReadInJoyWebviewPlugin", 1, ((StringBuilder)localObject3).toString());
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("showCommentEditorNative | defaultTxt after decode: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.d("ReadInJoyWebviewPlugin", 2, ((StringBuilder)localObject3).toString());
    }
    localObject3 = paramJSONObject.optString("rowkey");
    str2 = paramJSONObject.optString("articleId");
    n = paramJSONObject.optInt("scene");
    i1 = paramJSONObject.optInt("entry");
    str5 = paramJSONObject.optString("businessInfo");
    str3 = paramJSONObject.optString("firstCommentId");
    l = paramJSONObject.optLong("repliedSubAuthorId");
    str4 = paramJSONObject.optString("repliedSubCommentId");
    localIntent = new Intent();
    if (paramJSONObject.has("isPgcAuthor")) {
      localIntent.putExtra("comment_is_pgc_author", paramJSONObject.optBoolean("isPgcAuthor"));
    }
    localIntent.putExtra("comment_to_reply_contain_link", paramJSONObject.optInt("report_comment_link_reply", 2));
    localIntent.putExtra("comment_type", false);
    localIntent.putExtra("arg_comment_enable_anonymous", bool1);
    localIntent.putExtra("arg_comment_placeholder", (String)localObject1);
    localIntent.putExtra("arg_comment_default_txt", (String)localObject2);
    localIntent.putExtra("arg_comment_max_length", i);
    localIntent.putExtra("arg_comment_comment_type", j);
    localIntent.putExtra("arg_comment_source_type", k);
    localIntent.putExtra("arg_callback", str1);
    localIntent.putExtra("arg_comment_open_at", m);
    localIntent.putExtra("comment_can_biu", bool2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("need_intercept", false);
    if (localJSONArray != null) {
      localIntent.putExtra("arg_comment_default_comment_at", localJSONArray.toString());
    }
    if (str3.isEmpty())
    {
      paramJSONObject = new FirstCommentCreateData(i1, str5);
      paramJSONObject.b((String)localObject3);
      paramJSONObject.c(str2);
      paramJSONObject.b(n);
      localIntent.putExtra("comment_create_data", paramJSONObject);
    }
    else
    {
      paramJSONObject = new SubCommentCreateData(i1, str5);
      paramJSONObject.a(str3);
      paramJSONObject.b((String)localObject3);
      paramJSONObject.c(str2);
      paramJSONObject.a(l);
      paramJSONObject.e(str4);
      paramJSONObject.b(n);
      localIntent.putExtra("comment_create_data", paramJSONObject);
    }
    ((IRIJCommentEntranceUtils)QRoute.api(IRIJCommentEntranceUtils.class)).startForResult(this.mRuntime.a(), localIntent, SwiftWebViewUtils.a(10, WebViewUtil.a(this)));
  }
  
  private void d(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("callback");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJSONObject, new ReadInJoyWebviewPlugin.3(this, str));
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
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(str3, l1, (String)localObject2, str1, l2, l3, i, new ReadInJoyWebviewPlugin.4(this, str2));
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
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(str1, l1, str2, str3, l2, l3, new ReadInJoyWebviewPlugin.5(this, (String)localObject2));
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
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.h(new ReadInJoyWebviewPlugin.6(this, paramJSONObject));
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
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(str2, (String)localObject2, new ReadInJoyWebviewPlugin.7(this, str1));
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
  
  public int a(byte paramByte, boolean paramBoolean)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
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
  
  @Nullable
  public Activity a()
  {
    return this.mRuntime.a();
  }
  
  @Nullable
  public Object a()
  {
    return this.mRuntime.a();
  }
  
  @Nullable
  public String a()
  {
    return ((WebViewFragment)this.mRuntime.a()).getUin();
  }
  
  public AppRuntime a()
  {
    return this.mRuntime.a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyWebviewPlugin", 2, "do updateSocialFeedsInfo all");
    }
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_id", -1L);
    this.jdField_a_of_type_AndroidOsBundle.putLong("feeds_type", 1L);
    a(DataFactory.a("ipc_kandian_socialfeeds_update", "", 0, this.jdField_a_of_type_AndroidOsBundle), false, false);
  }
  
  protected void a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (paramBoolean2) {
        Toast.makeText(this.mRuntime.a().getApplicationContext(), HardCodeUtil.a(2131712765), 0).show();
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
            this.jdField_a_of_type_JavaLangString = str;
            localObject = str;
            c();
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
  public String b()
  {
    return ((SwiftBrowserShareMenuHandler)((WebViewFragment)this.mRuntime.a()).getComponentProvider().a(4)).jdField_a_of_type_JavaLangString;
  }
  
  @Nullable
  public String c()
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
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
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    super.callJs(paramString, paramVarArgs);
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
            return ((JsMethodAction)localObject2).a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.mRuntime.a(), paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
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
    if ((paramByte == 0) && (paramIntent != null))
    {
      paramInt = paramIntent.getIntExtra("extra_private_letter_count", 0);
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { Integer.toString(paramInt) });
      return;
    }
    if ((paramByte != 1) && (paramByte != 2))
    {
      if (paramByte == 10) {
        a(paramInt, paramIntent);
      }
    }
    else
    {
      ReadInjoyWebShareHelper localReadInjoyWebShareHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper;
      if (localReadInjoyWebShareHelper != null) {
        localReadInjoyWebShareHelper.a(paramIntent, paramByte, paramInt);
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    ReadInjoyWebShareHelper localReadInjoyWebShareHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper;
    if (localReadInjoyWebShareHelper != null) {
      localReadInjoyWebShareHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */