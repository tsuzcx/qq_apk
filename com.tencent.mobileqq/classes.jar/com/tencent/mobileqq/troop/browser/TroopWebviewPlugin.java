package com.tencent.mobileqq.troop.browser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopWebviewPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback
{
  public final byte a;
  protected int a;
  protected Dialog a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected QQProgressDialog a;
  String jdField_a_of_type_JavaLangString;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected boolean a;
  protected int b = -1;
  
  public TroopWebviewPlugin()
  {
    this.jdField_a_of_type_Byte = 5;
    this.mPluginNameSpace = "Troop";
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
  }
  
  private void d()
  {
    this.mRuntime.a().finish();
  }
  
  private void g(String paramString)
  {
    Object localObject = (BaseActivity)this.mRuntime.a();
    a();
    localObject = new QQProgressDialog((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
    ((QQProgressDialog)localObject).a(paramString);
    ((QQProgressDialog)localObject).setCancelable(false);
    ((QQProgressDialog)localObject).setOnDismissListener(new TroopWebviewPlugin.3(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQProgressDialog)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void h(String paramString)
  {
    Object localObject = (BaseActivity)this.mRuntime.a();
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a((Context)localObject, 2131694457, 0).b(((BaseActivity)localObject).getTitleBarHeight());
      return;
    }
    g(((BaseActivity)localObject).getString(2131720319));
    localObject = new Intent((Context)localObject, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("type", 1);
    ((Intent)localObject).putExtra("cfg", paramString);
    startActivityForResult((Intent)localObject, (byte)41);
  }
  
  private void i(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 3);
    localIntent.putExtra("cfg", paramString);
    localActivity.startActivity(localIntent);
  }
  
  private void j(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {}
    for (;;)
    {
      return;
      Intent localIntent = null;
      try
      {
        paramString = new JSONObject(paramString).getString("troopUin");
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        localIntent = new Intent(localActivity, SelectMemberActivity.class);
        localIntent.putExtra("param_groupcode", paramString);
        localIntent.putExtra("param_type", 1);
        localIntent.putExtra("param_subtype", 0);
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_title", this.mRuntime.a().getString(2131693533));
        localIntent.putExtra("param_done_button_wording", this.mRuntime.a().getString(2131694615));
        localIntent.putExtra("param_done_button_highlight_wording", this.mRuntime.a().getString(2131694617));
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_exit_animation", 1);
        localIntent.putExtra("param_max", 100);
        localIntent.putExtra("param_donot_need_contacts", true);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(2130771981, 2130771982);
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = localIntent;
        }
      }
    }
  }
  
  private void k(String paramString)
  {
    int i = 0;
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optString("troopUin", "");
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          JSONObject localJSONObject;
          boolean bool = localJSONObject.optBoolean("closeCurPage", false);
          i = bool;
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = TroopInfoActivity.a(paramString, 9);
            paramString.putString("troop_info_title", localActivity.getString(2131696098));
            paramString.putInt("troop_info_report_from", 1);
            TroopInfoActivity.a(localActivity, paramString, 45);
            localActivity.overridePendingTransition(2130771981, 2130771982);
          }
          if (i == 0) {
            break;
          }
          localActivity.finish();
          return;
        }
        catch (JSONException localJSONException2)
        {
          break label114;
        }
        localJSONException1 = localJSONException1;
        paramString = "";
      }
      label114:
      localJSONException1.printStackTrace();
    }
  }
  
  private void l(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    Object localObject = paramString.split("\\|");
    String str = "";
    if (localObject.length >= 4) {
      str = localObject[3];
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("location", str);
    ((Intent)localObject).putExtra("locationOriginal", paramString);
    localActivity.setResult(-1, (Intent)localObject);
    localActivity.finish();
  }
  
  private void m(String paramString)
  {
    Object localObject = this.mRuntime.a();
    g(((Activity)localObject).getString(2131720324));
    localObject = new Intent((Context)localObject, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("type", 5);
    ((Intent)localObject).putExtra("troop_location", paramString);
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    startActivityForResult((Intent)localObject, (byte)5);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.e(this.TAG, 1, "TroopCreateAvatarActivity 已在725下架");
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString2.replace("\"", "\\\"");
    }
    paramString1 = "javascript:" + paramString1 + "(\"" + str + "\")";
    this.mRuntime.a().loadUrl(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuffer.append("groupCode=" + paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuffer.append("&groupMemberUin=" + paramString2);
    }
    if (paramInt != -1) {
      localStringBuffer.append("&shielded=" + paramInt);
    }
    paramString1 = "mqq://troop_member_card/open_member_recent_chat_view/?" + localStringBuffer.toString();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "jump: " + paramString1);
    }
    this.mRuntime.a().startActivity(new Intent().setData(Uri.parse(paramString1)));
  }
  
  public void b()
  {
    c();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.mRuntime.a(), null);
    localActionSheet.setMainTitle(2131720317);
    localActionSheet.addButton(2131720318, 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnDismissListener(new TroopWebviewPlugin.4(this));
    localActionSheet.setOnButtonClickListener(new TroopWebviewPlugin.5(this));
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.a();
    if (!NetworkUtil.d(localBaseActivity)) {
      QQToast.a(localBaseActivity, 2131694457, 0).b(localBaseActivity.getTitleBarHeight());
    }
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    l(paramString);
  }
  
  public void c(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.a();
    try
    {
      paramString = new JSONObject(paramString).optString("location", "");
      if (!this.jdField_a_of_type_Boolean)
      {
        b(paramString);
        return;
      }
      if (!NetworkUtil.d(localBaseActivity))
      {
        QQToast.a(localBaseActivity, 2131694457, 0).b(localBaseActivity.getTitleBarHeight());
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        b();
        return;
      }
      m(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void callback(Bundle paramBundle)
  {
    int i = 2;
    if (paramBundle == null) {}
    do
    {
      return;
      if (paramBundle.getInt("type") != TroopNotificationConstants.aG) {
        break;
      }
      paramBundle.getBoolean("isSuccess");
      paramBundle.getInt("appid");
      paramBundle.getString("openGroupId");
      paramBundle.getString("token");
      paramBundle = paramBundle.getString("uin");
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG + ".troopTAG_GET_UIN_BY_OPEN_ID", 2, "callback,uin:" + paramBundle);
    return;
    boolean bool;
    String str;
    Object localObject;
    if (paramBundle.getInt("type") == TroopNotificationConstants.at)
    {
      bool = paramBundle.getBoolean("isSuccess");
      int k = paramBundle.getInt("appid");
      str = paramBundle.getString("openGroupId");
      localObject = paramBundle.getString("token");
      int m = paramBundle.getInt("freq");
      int n = paramBundle.getInt("expireTime");
      ArrayList localArrayList = paramBundle.getStringArrayList("apilist");
      int j = paramBundle.getInt("retCode");
      if (!bool)
      {
        switch (j)
        {
        default: 
          i = -100;
        }
        for (;;)
        {
          callJs4OpenApiIfNeeded("init", i, " server retCode:" + j);
          return;
          i = 0;
          continue;
          i = 4;
        }
      }
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null)
      {
        localCustomWebView.saveToken(k, str, (String)localObject, m, n, localArrayList);
        callJs4OpenApiIfNeeded("init", 0, localArrayList.toString());
        return;
      }
      callJs(paramBundle.getString("callback"), new String[] { "webView == null" });
      return;
    }
    if ("troopCreateOpenAIO".equals(paramBundle.getString("type")))
    {
      bool = paramBundle.getBoolean("isSuccess", false);
      localObject = new JSONObject();
      if (bool) {
        str = "0";
      }
      try
      {
        for (;;)
        {
          ((JSONObject)localObject).put("ret", str);
          callJs(paramBundle.getString("callback"), new String[] { ((JSONObject)localObject).toString() });
          return;
          str = "1";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    callJs(paramBundle.getString("callback"), new String[] { "" });
  }
  
  /* Error */
  public void d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: invokevirtual 70	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   7: astore_3
    //   8: new 167	org/json/JSONObject
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: ldc_w 492
    //   21: invokevirtual 174	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 4
    //   26: aload_1
    //   27: ldc_w 494
    //   30: invokevirtual 495	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   33: istore_2
    //   34: aload 4
    //   36: bipush 13
    //   38: invokestatic 236	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   41: astore_1
    //   42: aload_1
    //   43: ldc_w 494
    //   46: iload_2
    //   47: invokevirtual 499	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   50: aload_3
    //   51: aload_1
    //   52: invokestatic 502	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Landroid/content/Context;Landroid/os/Bundle;)V
    //   55: iload_2
    //   56: ifeq +7 -> 63
    //   59: aload_3
    //   60: invokevirtual 75	android/app/Activity:finish	()V
    //   63: return
    //   64: astore_1
    //   65: return
    //   66: astore_1
    //   67: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	TroopWebviewPlugin
    //   0	68	1	paramString	String
    //   33	23	2	bool	boolean
    //   7	53	3	localActivity	Activity
    //   24	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   8	17	64	org/json/JSONException
    //   17	55	66	org/json/JSONException
    //   59	63	66	org/json/JSONException
  }
  
  public void e(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Activity localActivity;
      return;
    }
    catch (JSONException paramString)
    {
      try
      {
        paramString = paramString.getString("url");
        if (paramString != null)
        {
          localActivity = this.mRuntime.a();
          TroopQQBrowserHelper.a(localActivity, localActivity.getIntent().getExtras(), paramString);
        }
        return;
      }
      catch (JSONException paramString) {}
      paramString = paramString;
      return;
    }
  }
  
  public void f(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      try
      {
        paramString = paramString.getString("tags");
        if (!(this.mRuntime.a() instanceof TroopTagViewActivity)) {
          return;
        }
        ((TroopTagViewActivity)this.mRuntime.a()).a(paramString);
        return;
      }
      catch (JSONException paramString) {}
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934618L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934593L) {}
    for (;;)
    {
      return false;
      if (paramLong != 8589934601L) {
        if (paramLong == 2L)
        {
          if (this.b != -1)
          {
            paramString = new JSONObject();
            try
            {
              paramString.put("isBack", this.b);
              a("onGetGroupHeadEditViewBack", paramString.toString());
              this.b = -1;
            }
            catch (JSONException paramString)
            {
              for (;;)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
        else if (paramLong != 16L) {}
      }
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("Troop")) {
      return false;
    }
    addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
    if ("init".equals(paramString3)) {}
    int i;
    int j;
    boolean bool;
    label866:
    long l;
    try
    {
      paramString2 = new JSONObject(paramVarArgs[0]);
      i = paramString2.optInt("appid");
      paramString1 = paramString2.optString("openGroupId");
      paramString2 = paramString2.optString("token");
      if ((TextUtils.isEmpty(i + "")) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
      {
        callJs4OpenApi(paramJsBridgeListener, 4, JsBridgeListener.a(4, null, null));
        return false;
      }
      paramJsBridgeListener = this.mRuntime.a().getUrl();
      j = paramJsBridgeListener.indexOf("?");
      paramString3 = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
      if (j == -1) {}
      for (paramJsBridgeListener = null;; paramJsBridgeListener = paramJsBridgeListener.substring(0, j))
      {
        paramString3.a(i, paramString1, paramString2, paramJsBridgeListener, "init", this);
        break;
      }
      if (paramString3.equals("setTitleButton")) {
        break label2336;
      }
      if (paramString3.equals("commitGroupInfo"))
      {
        h(paramVarArgs[0]);
        break label2336;
      }
      if (paramString3.equals("shareGroup"))
      {
        i(paramVarArgs[0]);
        break label2336;
      }
      if (paramString3.equals("inviteMemberToGroup"))
      {
        j(paramVarArgs[0]);
        break label2336;
      }
      if (paramString3.equals("enterGroupInfoCard"))
      {
        k(paramVarArgs[0]);
        break label2336;
      }
      if (paramString3.equals("modifyTroopLocation"))
      {
        c(paramVarArgs[0]);
        break label2336;
      }
      if (paramString3.equals("finishCreateGroup"))
      {
        d();
        break label2336;
      }
      if (paramString3.equals("insertCreateGroupSuccessMsg")) {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.getString("troopUin");
          paramString1 = paramString2.getString("groupName");
          i = paramString2.optInt("cateId");
          paramString2 = paramString2.optString("callback");
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJsBridgeListener, paramString1, i, paramString2, this);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      if (paramString3.equals("showGroupHeadEditView"))
      {
        a(paramVarArgs[0]);
        break label2336;
      }
      if (paramString3.equals("searchTroop"))
      {
        QQToast.a(this.mRuntime.a(), 0, "该api功能已下架!", 0).a();
        break label2336;
      }
      if (paramString3.equals("didModifyGroupTags"))
      {
        f(paramVarArgs[0]);
        paramJsBridgeListener.a(Boolean.valueOf(true));
        break label2336;
      }
      if (paramString3.equals("openTroopProfileEdit"))
      {
        d(paramVarArgs[0]);
        break label2336;
      }
      if (paramString3.equals("showTroopProfile"))
      {
        QQToast.a(this.mRuntime.a(), 0, "该api功能已下架!", 0).a();
        break label2336;
      }
      if (paramString3.equals("getVersion"))
      {
        paramJsBridgeListener.a("8.5.5.5105");
        break label2336;
      }
      if (paramString3.equals("isNetworkConnected"))
      {
        paramJsBridgeListener.a(Boolean.valueOf(APNUtil.d(CommonDataAdapter.a().a())));
        break label2336;
      }
      if (paramString3.equals("openUrl"))
      {
        e(paramVarArgs[0]);
        break label2336;
      }
      if ((paramString3.equals("setWebDataCache")) || (paramString3.equals("getWebDataCache"))) {
        break label2336;
      }
      if ("getUniqueTitleNewFlag".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if ((this.mRuntime.a().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin() + "_troopManager", 0).getInt("uniqueTitleNewFlag", 0) & 0x2) == 0) {}
          for (bool = true;; bool = false)
          {
            callJs(paramJsBridgeListener, new String[] { "{\"showFlag\":" + bool + "}" });
            return true;
          }
          if (!"setUniqueTitleNewFlag".equals(paramString3)) {
            break label866;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else
      {
        paramJsBridgeListener = this.mRuntime.a().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin() + "_troopManager", 0);
        i = paramJsBridgeListener.getInt("uniqueTitleNewFlag", 0);
        paramJsBridgeListener.edit().putInt("uniqueTitleNewFlag", i | 0x2).commit();
        return true;
      }
    }
    catch (JSONException paramJsBridgeListener) {}
    if ("createDingdong".equals(paramString3))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("troopUin");
        if (paramJsBridgeListener == null) {
          break label2336;
        }
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          paramJsBridgeListener.printStackTrace();
          paramJsBridgeListener = null;
        }
      }
    }
    else if ("updateTroopBindedPubAccount".equals(paramString3))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        l = paramJsBridgeListener.getLong("troopPubAccountUin");
        paramJsBridgeListener = paramJsBridgeListener.getJSONArray("groupCodeList");
        j = paramJsBridgeListener.length();
        if (j > 0)
        {
          paramString1 = new long[j];
          i = 0;
          while (i < j)
          {
            paramString1[i] = paramJsBridgeListener.getLong(i);
            i += 1;
          }
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(l, paramString1);
        }
        if (!QLog.isColorLevel()) {
          break label2336;
        }
        QLog.d("AccountDetailActivity.bindTroop", 2, "updateTroopBindedPubAccount:" + paramVarArgs[0]);
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          break label2336;
        }
      }
      QLog.e("AccountDetailActivity.bindTroop", 2, paramJsBridgeListener.toString());
    }
    else if ("getLastSpeakMessage".equals(paramString3))
    {
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString2.optString("groupCode");
        paramString1 = paramString2.optString("groupMemberUin");
        paramString2 = paramString2.optString("callback");
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJsBridgeListener, paramString1, new TroopWebviewPlugin.1(this, paramString2));
        if (!QLog.isColorLevel()) {
          break label2336;
        }
        QLog.d("TroopWebviewPlugin", 2, "getLastSpeakMessage:" + paramVarArgs[0]);
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
    else if ("openRecentChatView".equals(paramString3))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        a(paramJsBridgeListener.optString("groupCode"), paramJsBridgeListener.optString("groupMemberUin"), paramJsBridgeListener.optInt("shielded"));
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
    else if (!"notifyTroopEnterEffectStatus".equals(paramString3)) {}
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString2.optString("callback");
        paramString3 = paramString2.optJSONArray("groupCodeList");
        paramString1 = new ArrayList();
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          i = 0;
          if (i < paramString3.length())
          {
            if (paramString3.optInt(i) <= 0) {
              break label2338;
            }
            paramString1.add(Integer.valueOf(paramString3.optInt(i)));
            break label2338;
          }
        }
        i = paramString2.optInt("effectId");
        j = paramString2.optInt("svipLevel");
        int k = paramString2.optInt("svipType");
        paramString2 = paramString2.optString("effectName");
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, i, j, k, paramString2);
        super.callJs(paramJsBridgeListener, new String[] { "{\"ret\":0}" });
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      if ("returnToTroopAIO".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopWebviewPlugin", 2, "returnToTroopAIO:" + paramVarArgs[0]);
        }
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("gc");
          paramString1.printStackTrace();
        }
        catch (JSONException paramString1)
        {
          try
          {
            bool = TextUtils.isEmpty(paramJsBridgeListener);
            if (!bool) {
              break label1499;
            }
            return false;
          }
          catch (JSONException paramString1)
          {
            break label1495;
          }
          paramString1 = paramString1;
          paramJsBridgeListener = null;
        }
        label1495:
        label1499:
        if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + Build.MODEL))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Sensor", 2, "meizu mx2 returnToTroopAIO");
          }
          new Handler().postDelayed(new TroopWebviewPlugin.2(this, paramJsBridgeListener), 400L);
          break label2336;
        }
        SensorAPIJavaScript.returnToAio(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.mRuntime.a(), paramJsBridgeListener, true);
        break label2336;
      }
      else
      {
        if ("notifyCreateTroops".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString2.optString("groupCode");
            if (TextUtils.isEmpty(paramJsBridgeListener))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e(this.TAG, 2, "METHOD_NOTIFY_TROOP_CREATE uin empty");
              break;
            }
            paramString1 = paramString2.optString("chat_type");
            paramString2 = paramString2.optString("callback");
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJsBridgeListener, paramString1, paramString2, this);
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (!QLog.isColorLevel()) {
              break label2336;
            }
          }
          QLog.e(this.TAG, 2, "METHOD_NOTIFY_TROOP_CREATE," + paramJsBridgeListener.toString(), paramJsBridgeListener);
          break label2336;
        }
        if ("notifySwitchStatus".equals(paramString3)) {
          for (;;)
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("callback");
              paramString2 = paramJsBridgeListener.optJSONArray("data");
              paramJsBridgeListener = "{\"ret\":0}";
              if ((paramString2 != null) && (paramString2.length() > 0))
              {
                paramString3 = new ArrayList();
                i = 0;
                if (i < paramString2.length())
                {
                  paramVarArgs = paramString2.getJSONObject(i);
                  paramString3.add(paramVarArgs.optString("groupCode") + "," + paramVarArgs.optInt("status"));
                  i += 1;
                  continue;
                }
                this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString3);
                super.callJs(paramString1, new String[] { paramJsBridgeListener });
              }
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e(this.TAG, 1, "notifySwitchStatus error: " + paramJsBridgeListener.toString());
            }
            QLog.e(this.TAG, 1, "notifySwitchStatus dataArray is empty");
            paramJsBridgeListener = "{\"ret\":-1}";
          }
        }
        if ("updateTroopAnnouncement".equals(paramString3)) {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = null;
            paramString3 = this.mRuntime.a();
            paramJsBridgeListener = paramString1;
            if (paramString3 != null)
            {
              paramJsBridgeListener = paramString1;
              if (paramString2.has("lastAnnouncement"))
              {
                paramJsBridgeListener = paramString1;
                if (paramString2.has("groupCode"))
                {
                  l = paramString2.optLong("groupCode");
                  paramJsBridgeListener = paramString2.optString("lastAnnouncement");
                  paramString1 = new Intent();
                  paramString1.putExtra("groupCode", l);
                  paramString1.putExtra("lastAnnouncement", paramJsBridgeListener);
                  paramString1.putExtra("updateFromWeb", true);
                  paramString3.setResult(-1, paramString1);
                }
              }
            }
            if (!QLog.isColorLevel()) {
              break label2336;
            }
            QLog.i(this.TAG, 2, String.format("updateTroopAnnouncement [%s, %s, %s]", new Object[] { paramJsBridgeListener, Boolean.valueOf(paramString2.has("lastAnnouncement")), paramString3 }));
          }
          catch (Throwable paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        if ("updateTroopAutoApprovalSetting".equals(paramString3)) {
          for (;;)
          {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = this.mRuntime.a();
              j = -1;
              i = j;
              if (paramString1 != null)
              {
                i = j;
                if (paramJsBridgeListener.has("autoApprovalSetting"))
                {
                  i = j;
                  if (paramJsBridgeListener.has("groupCode"))
                  {
                    l = paramJsBridgeListener.optLong("groupCode");
                    i = paramJsBridgeListener.optInt("autoApprovalSetting");
                    paramString2 = new Intent();
                    paramString2.putExtra("groupCode", l);
                    if (i != 1) {
                      break label2323;
                    }
                    bool = true;
                    paramString2.putExtra("autoApprovalSetting", bool);
                    paramString2.putExtra("updateFromWeb", true);
                    paramString1.setResult(-1, paramString2);
                  }
                }
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i(this.TAG, 2, String.format("updateAutoApprovalSetting [%s, %s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramJsBridgeListener.has("autoApprovalSetting")), paramString1 }));
            }
            catch (Throwable paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
            label2323:
            bool = false;
          }
        }
        return false;
      }
      label2336:
      return true;
      label2338:
      i += 1;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    Object localObject2 = (BaseActivity)this.mRuntime.a();
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              a();
            } while ((paramIntent == null) || (paramInt != -1));
            paramByte = paramIntent.getIntExtra("retCode", -1);
            Object localObject1 = paramIntent.getStringExtra("troopUin");
            paramIntent = (Intent)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramIntent = "";
            }
            paramInt = TroopCreateLogic.TroopCreateResult.a(paramByte);
            if (paramInt != 0) {
              QQToast.a(this.mRuntime.a(), paramInt, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
            }
            localObject2 = new JSONObject();
            for (;;)
            {
              try
              {
                ((JSONObject)localObject2).put("result", paramByte);
                if (TextUtils.isEmpty(paramIntent)) {
                  continue;
                }
                localObject1 = paramIntent;
                ((JSONObject)localObject2).put("troopUin", localObject1);
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
                continue;
              }
              a("onCreateGroupResult", ((JSONObject)localObject2).toString());
              if (paramByte != 0) {
                break;
              }
              this.jdField_a_of_type_JavaLangString = paramIntent;
              return;
              localObject1 = "";
            }
          } while ((paramIntent == null) || (paramInt != -1));
          a("onGroupInfoModified", paramIntent.getStringExtra("modifiedInfo"));
          return;
        } while ((paramIntent == null) || (paramInt != -1));
        this.b = paramIntent.getIntExtra("isBack", -1);
        return;
      } while (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
      paramIntent = new Intent(this.mRuntime.a(), TroopCreateLogicActivity.class);
      paramIntent.putExtra("type", 4);
      paramIntent.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
      startActivityForResult(paramIntent, (byte)42);
      return;
      paramIntent.getBooleanExtra("has_head", false);
      return;
    } while ((paramIntent == null) || (paramInt != -1));
    paramByte = paramIntent.getIntExtra("errCode", -1);
    boolean bool = paramIntent.getBooleanExtra("isClear", false);
    String str = paramIntent.getStringExtra("location");
    paramInt = paramIntent.getIntExtra("lat", 0);
    int i = paramIntent.getIntExtra("lon", 0);
    if (paramByte == 0)
    {
      if (bool) {
        QQToast.a((Context)localObject2, 2131720316, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
      }
      for (;;)
      {
        paramIntent = new Intent();
        paramIntent.putExtra("location", str);
        paramIntent.putExtra("lat", paramInt);
        paramIntent.putExtra("lon", i);
        ((BaseActivity)localObject2).setResult(-1, paramIntent);
        ((BaseActivity)localObject2).finish();
        return;
        QQToast.a((Context)localObject2, 2131720321, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
      }
    }
    if (paramByte == 1002) {
      paramIntent = ((BaseActivity)localObject2).getString(2131720328);
    }
    for (;;)
    {
      QQToast.a((Context)localObject2, paramIntent, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
      return;
      if (bool) {
        paramIntent = ((BaseActivity)localObject2).getString(2131720315);
      } else {
        paramIntent = ((BaseActivity)localObject2).getString(2131720320);
      }
    }
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_Int = this.mRuntime.a().getIntent().getIntExtra("troop_create_from", 0);
    if (this.jdField_a_of_type_Int != 0) {
      this.mRuntime.a().setResult(-1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void onDestroy()
  {
    if (((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4)) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */