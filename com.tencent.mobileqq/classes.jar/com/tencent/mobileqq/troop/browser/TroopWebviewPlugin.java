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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.TroopCreateResult;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
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
  implements ITroopMemberApiClientApi.Callback
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
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null)
    {
      if (localDialog.isShowing()) {
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
    Object localObject = (QBaseActivity)this.mRuntime.a();
    a();
    localObject = new QQProgressDialog((Context)localObject, ((QBaseActivity)localObject).getTitleBarHeight());
    ((QQProgressDialog)localObject).a(paramString);
    ((QQProgressDialog)localObject).setCancelable(false);
    ((QQProgressDialog)localObject).setOnDismissListener(new TroopWebviewPlugin.3(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQProgressDialog)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void h(String paramString)
  {
    Object localObject = (QBaseActivity)this.mRuntime.a();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a((Context)localObject, 2131694422, 0).b(((QBaseActivity)localObject).getTitleBarHeight());
      return;
    }
    g(((QBaseActivity)localObject).getString(2131720059));
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
    if (localActivity == null) {
      return;
    }
    Intent localIntent = null;
    try
    {
      paramString = new JSONObject(paramString).getString("troopUin");
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = localIntent;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localIntent = new Intent();
    localIntent.putExtra("param_groupcode", paramString);
    localIntent.putExtra("param_type", 1);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_title", this.mRuntime.a().getString(2131693488));
    localIntent.putExtra("param_done_button_wording", this.mRuntime.a().getString(2131694583));
    localIntent.putExtra("param_done_button_highlight_wording", this.mRuntime.a().getString(2131694585));
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_max", 100);
    localIntent.putExtra("param_donot_need_contacts", true);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(localActivity, localIntent);
    localActivity.overridePendingTransition(2130771993, 2130771994);
  }
  
  private void k(String paramString)
  {
    String str2 = "";
    Activity localActivity = this.mRuntime.a();
    if (localActivity == null) {
      return;
    }
    int i = 0;
    String str1 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      str1 = str2;
      paramString = localJSONObject.optString("troopUin", "");
      str1 = paramString;
      boolean bool = localJSONObject.optBoolean("closeCurPage", false);
      i = bool;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = str1;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = TroopInfoUIUtil.a(paramString, 9);
      paramString.putString("troop_info_title", localActivity.getString(2131696115));
      paramString.putInt("troop_info_report_from", 1);
      ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfileForResult(localActivity, paramString, 45);
      localActivity.overridePendingTransition(2130771993, 2130771994);
    }
    if (i != 0) {
      localActivity.finish();
    }
  }
  
  private void l(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    Object localObject = paramString.split("\\|");
    if (localObject.length >= 4) {
      localObject = localObject[3];
    } else {
      localObject = "";
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("location", (String)localObject);
    localIntent.putExtra("locationOriginal", paramString);
    localActivity.setResult(-1, localIntent);
    localActivity.finish();
  }
  
  private void m(String paramString)
  {
    Object localObject = this.mRuntime.a();
    g(((Activity)localObject).getString(2131720064));
    localObject = new Intent((Context)localObject, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("type", 5);
    ((Intent)localObject).putExtra("troop_location", paramString);
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    startActivityForResult((Intent)localObject, (byte)5);
  }
  
  void a()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      if (localQQProgressDialog.isShowing()) {
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
    paramString2 = new StringBuilder();
    paramString2.append("javascript:");
    paramString2.append(paramString1);
    paramString2.append("(\"");
    paramString2.append(str);
    paramString2.append("\")");
    paramString1 = paramString2.toString();
    this.mRuntime.a().loadUrl(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new StringBuffer();
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupCode=");
      localStringBuilder.append(paramString1);
      ((StringBuffer)localObject).append(localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new StringBuilder();
      paramString1.append("&groupMemberUin=");
      paramString1.append(paramString2);
      ((StringBuffer)localObject).append(paramString1.toString());
    }
    if (paramInt != -1)
    {
      paramString1 = new StringBuilder();
      paramString1.append("&shielded=");
      paramString1.append(paramInt);
      ((StringBuffer)localObject).append(paramString1.toString());
    }
    paramString1 = new StringBuilder();
    paramString1.append("mqq://troop_member_card/open_member_recent_chat_view/?");
    paramString1.append(((StringBuffer)localObject).toString());
    paramString1 = paramString1.toString();
    if (QLog.isColorLevel())
    {
      paramString2 = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump: ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
    }
    this.mRuntime.a().startActivity(new Intent().setData(Uri.parse(paramString1)));
  }
  
  public void b()
  {
    c();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.mRuntime.a(), null);
    localActionSheet.setMainTitle(2131720057);
    localActionSheet.addButton(2131720058, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnDismissListener(new TroopWebviewPlugin.4(this));
    localActionSheet.setOnButtonClickListener(new TroopWebviewPlugin.5(this));
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b(String paramString)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)this.mRuntime.a();
    if (!NetworkUtil.isNetSupport(localQBaseActivity))
    {
      QQToast.a(localQBaseActivity, 2131694422, 0).b(localQBaseActivity.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    l(paramString);
  }
  
  public void c(String paramString)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)this.mRuntime.a();
    try
    {
      paramString = new JSONObject(paramString).optString("location", "");
      if (!this.jdField_a_of_type_Boolean)
      {
        b(paramString);
        return;
      }
      if (!NetworkUtil.isNetSupport(localQBaseActivity))
      {
        QQToast.a(localQBaseActivity, 2131694422, 0).b(localQBaseActivity.getTitleBarHeight());
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
    if (paramBundle == null) {
      return;
    }
    int j = paramBundle.getInt("type");
    int k = TroopObserver.TYPE_GET_UIN_BY_OPEN_ID;
    int i = 2;
    Object localObject1;
    Object localObject2;
    if (j == k)
    {
      paramBundle.getBoolean("isSuccess");
      paramBundle.getInt("appid");
      paramBundle.getString("openGroupId");
      paramBundle.getString("token");
      paramBundle = paramBundle.getString("uin");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.TAG);
        ((StringBuilder)localObject1).append(".troopTAG_GET_UIN_BY_OPEN_ID");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("callback,uin:");
        ((StringBuilder)localObject2).append(paramBundle);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      boolean bool;
      if (paramBundle.getInt("type") == TroopObserver.TYPE_NOTIFY_TROOP_OPEN_API_TOKEN_VERIFY)
      {
        bool = paramBundle.getBoolean("isSuccess");
        k = paramBundle.getInt("appid");
        localObject1 = paramBundle.getString("openGroupId");
        localObject2 = paramBundle.getString("token");
        int m = paramBundle.getInt("freq");
        int n = paramBundle.getInt("expireTime");
        ArrayList localArrayList = paramBundle.getStringArrayList("apilist");
        j = paramBundle.getInt("retCode");
        if (!bool)
        {
          if (j != 0) {}
          switch (j)
          {
          default: 
            i = -100;
            break;
          case 1000: 
          case 1001: 
          case 1002: 
          case 1003: 
          case 1005: 
          case 1006: 
            i = 4;
            break;
            i = 0;
          }
          paramBundle = new StringBuilder();
          paramBundle.append(" server retCode:");
          paramBundle.append(j);
          callJs4OpenApiIfNeeded("init", i, paramBundle.toString());
          return;
        }
        CustomWebView localCustomWebView = this.mRuntime.a();
        if (localCustomWebView != null)
        {
          localCustomWebView.saveToken(k, (String)localObject1, (String)localObject2, m, n, localArrayList);
          callJs4OpenApiIfNeeded("init", 0, localArrayList.toString());
          return;
        }
        callJs(paramBundle.getString("callback"), new String[] { "webView == null" });
        return;
      }
      if ("troopCreateOpenAIO".equals(paramBundle.getString("type")))
      {
        bool = paramBundle.getBoolean("isSuccess", false);
        localObject2 = new JSONObject();
        if (!bool) {
          break label508;
        }
        localObject1 = "0";
      }
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject2).put("ret", localObject1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      callJs(paramBundle.getString("callback"), new String[] { ((JSONObject)localObject2).toString() });
      return;
      callJs(paramBundle.getString("callback"), new String[] { "" });
      return;
      label508:
      String str = "1";
    }
  }
  
  public void d(String paramString)
  {
    Activity localActivity = this.mRuntime.a();
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("troopCode");
      boolean bool = paramString.getBoolean("returnMsgList");
      paramString = TroopInfoUIUtil.a(str, 13);
      paramString.putBoolean("returnMsgList", bool);
      ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(localActivity, paramString);
      if (bool) {
        localActivity.finish();
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void e(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("url");
      if (paramString != null)
      {
        Activity localActivity = this.mRuntime.a();
        TroopQQBrowserHelper.a(localActivity, localActivity.getIntent().getExtras(), paramString);
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void f(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("tags");
      if (!(this.mRuntime.a() instanceof TroopTagViewActivity)) {
        return;
      }
      ((TroopTagViewActivity)this.mRuntime.a()).a(paramString);
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934618L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong != 8589934593L) && (paramLong != 8589934601L) && (paramLong == 2L) && (this.b != -1))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("isBack", this.b);
        a("onGetGroupHeadEditViewBack", paramString.toString());
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      this.b = -1;
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("Troop")) {
      return false;
    }
    addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
    boolean bool = "init".equals(paramString3);
    paramString2 = null;
    paramString1 = null;
    if (bool) {}
    int i;
    try
    {
      paramString2 = new JSONObject(paramVarArgs[0]);
      i = paramString2.optInt("appid");
      paramString1 = paramString2.optString("openGroupId");
      paramString2 = paramString2.optString("token");
      paramString3 = new StringBuilder();
      paramString3.append(i);
      paramString3.append("");
      if ((!TextUtils.isEmpty(paramString3.toString())) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        paramJsBridgeListener = this.mRuntime.a().getUrl();
        j = paramJsBridgeListener.indexOf("?");
        paramString3 = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
        if (j == -1) {
          paramJsBridgeListener = null;
        } else {
          paramJsBridgeListener = paramJsBridgeListener.substring(0, j);
        }
        paramString3.a(i, paramString1, paramString2, paramJsBridgeListener, "init", this);
        return true;
      }
      callJs4OpenApi(paramJsBridgeListener, 4, JsBridgeListener.a(4, null, null));
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      int j;
      long l;
      return true;
    }
    if (paramString3.equals("setTitleButton")) {
      return true;
    }
    if (paramString3.equals("commitGroupInfo"))
    {
      h(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("shareGroup"))
    {
      i(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("inviteMemberToGroup"))
    {
      j(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("enterGroupInfoCard"))
    {
      k(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("modifyTroopLocation"))
    {
      c(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("finishCreateGroup"))
    {
      d();
      return true;
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
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    if (paramString3.equals("showGroupHeadEditView"))
    {
      a(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("searchTroop"))
    {
      QQToast.a(this.mRuntime.a(), 0, "该api功能已下架!", 0).a();
      return true;
    }
    if (paramString3.equals("didModifyGroupTags"))
    {
      f(paramVarArgs[0]);
      paramJsBridgeListener.a(Boolean.valueOf(true));
      return true;
    }
    if (paramString3.equals("openTroopProfileEdit"))
    {
      d(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("showTroopProfile"))
    {
      QQToast.a(this.mRuntime.a(), 0, "该api功能已下架!", 0).a();
      return true;
    }
    if (paramString3.equals("getVersion"))
    {
      paramJsBridgeListener.a("8.7.0.5295");
      return true;
    }
    if (paramString3.equals("isNetworkConnected"))
    {
      paramJsBridgeListener.a(Boolean.valueOf(APNUtil.d(CommonDataAdapter.a().a())));
      return true;
    }
    if (paramString3.equals("openUrl"))
    {
      e(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("setWebDataCache")) {
      return true;
    }
    if (paramString3.equals("getWebDataCache")) {
      return true;
    }
    if ("getUniqueTitleNewFlag".equals(paramString3))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
        paramString1 = this.mRuntime.a();
        paramString2 = new StringBuilder();
        paramString2.append(this.mRuntime.a().getCurrentAccountUin());
        paramString2.append("_troopManager");
        if ((paramString1.getSharedPreferences(paramString2.toString(), 0).getInt("uniqueTitleNewFlag", 0) & 0x2) != 0) {
          break label2385;
        }
        bool = true;
        paramString1 = new StringBuilder();
        paramString1.append("{\"showFlag\":");
        paramString1.append(bool);
        paramString1.append("}");
        callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    else
    {
      if ("setUniqueTitleNewFlag".equals(paramString3))
      {
        paramJsBridgeListener = this.mRuntime.a();
        paramString1 = new StringBuilder();
        paramString1.append(this.mRuntime.a().getCurrentAccountUin());
        paramString1.append("_troopManager");
        paramJsBridgeListener = paramJsBridgeListener.getSharedPreferences(paramString1.toString(), 0);
        i = paramJsBridgeListener.getInt("uniqueTitleNewFlag", 0);
        paramJsBridgeListener.edit().putInt("uniqueTitleNewFlag", i | 0x2).commit();
        return true;
      }
      if ("createDingdong".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("troopUin");
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          paramJsBridgeListener = paramString1;
        }
        if (paramJsBridgeListener != null) {
          return true;
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
            break label2378;
          }
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("updateTroopBindedPubAccount:");
          paramJsBridgeListener.append(paramVarArgs[0]);
          QLog.d("AccountDetailActivity.bindTroop", 2, paramJsBridgeListener.toString());
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label2378;
          }
        }
        QLog.e("AccountDetailActivity.bindTroop", 2, paramJsBridgeListener.toString());
        return true;
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
            break label2378;
          }
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("getLastSpeakMessage:");
          paramJsBridgeListener.append(paramVarArgs[0]);
          QLog.d("TroopWebviewPlugin", 2, paramJsBridgeListener.toString());
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      else
      {
        if ("openRecentChatView".equals(paramString3)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            a(paramJsBridgeListener.optString("groupCode"), paramJsBridgeListener.optString("groupMemberUin"), paramJsBridgeListener.optInt("shielded"));
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
        if ("notifyTroopEnterEffectStatus".equals(paramString3)) {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString2.optString("callback");
            paramString3 = paramString2.optJSONArray("groupCodeList");
            paramString1 = new ArrayList();
            if ((paramString3 != null) && (paramString3.length() > 0))
            {
              i = 0;
              label1336:
              if (i < paramString3.length())
              {
                if (paramString3.optInt(i) <= 0) {
                  break label2391;
                }
                paramString1.add(Integer.valueOf(paramString3.optInt(i)));
                break label2391;
              }
            }
            i = paramString2.optInt("effectId");
            j = paramString2.optInt("svipLevel");
            int k = paramString2.optInt("svipType");
            paramString2 = paramString2.optString("effectName");
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString1, i, j, k, paramString2);
            super.callJs(paramJsBridgeListener, new String[] { "{\"ret\":0}" });
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return true;
          }
        }
        if ("returnToTroopAIO".equals(paramString3))
        {
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("returnToTroopAIO:");
            paramJsBridgeListener.append(paramVarArgs[0]);
            QLog.d("TroopWebviewPlugin", 2, paramJsBridgeListener.toString());
          }
          paramJsBridgeListener = paramString2;
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]).optString("gc");
            paramJsBridgeListener = paramString1;
            bool = TextUtils.isEmpty(paramString1);
            paramJsBridgeListener = paramString1;
            if (bool) {
              return false;
            }
          }
          catch (JSONException paramString1)
          {
            paramString1.printStackTrace();
            paramString1 = new StringBuilder();
            paramString1.append(Build.MANUFACTURER);
            paramString1.append("_");
            paramString1.append(Build.MODEL);
            if ("Meizu_M040".equals(paramString1.toString()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Sensor", 2, "meizu mx2 returnToTroopAIO");
              }
              new Handler().postDelayed(new TroopWebviewPlugin.2(this, paramJsBridgeListener), 400L);
              return true;
            }
            SensorAPIJavaScript.returnToAio(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient, this.mRuntime.a(), paramJsBridgeListener, true);
            return true;
          }
        }
        if ("notifyCreateTroops".equals(paramString3))
        {
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString2.optString("groupCode");
            if (TextUtils.isEmpty(paramJsBridgeListener))
            {
              if (!QLog.isColorLevel()) {
                break label2400;
              }
              QLog.e(this.TAG, 2, "METHOD_NOTIFY_TROOP_CREATE uin empty");
              return false;
            }
            paramString1 = paramString2.optString("chat_type");
            paramString2 = paramString2.optString("callback");
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramJsBridgeListener, paramString1, paramString2, this);
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (!QLog.isColorLevel()) {
              break label2378;
            }
          }
          paramString1 = this.TAG;
          paramString2 = new StringBuilder();
          paramString2.append("METHOD_NOTIFY_TROOP_CREATE,");
          paramString2.append(paramJsBridgeListener.toString());
          QLog.e(paramString1, 2, paramString2.toString(), paramJsBridgeListener);
          return true;
        }
        else
        {
          if ("notifySwitchStatus".equals(paramString3)) {
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
                while (i < paramString2.length())
                {
                  paramVarArgs = paramString2.getJSONObject(i);
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(paramVarArgs.optString("groupCode"));
                  localStringBuilder.append(",");
                  localStringBuilder.append(paramVarArgs.optInt("status"));
                  paramString3.add(localStringBuilder.toString());
                  i += 1;
                }
                this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString3);
              }
              else
              {
                QLog.e(this.TAG, 1, "notifySwitchStatus dataArray is empty");
                paramJsBridgeListener = "{\"ret\":-1}";
              }
              super.callJs(paramString1, new String[] { paramJsBridgeListener });
              return true;
            }
            catch (Exception paramJsBridgeListener)
            {
              paramString1 = this.TAG;
              paramString2 = new StringBuilder();
              paramString2.append("notifySwitchStatus error: ");
              paramString2.append(paramJsBridgeListener.toString());
              QLog.e(paramString1, 1, paramString2.toString());
              return true;
            }
          }
          if ("updateTroopAnnouncement".equals(paramString3)) {
            try
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramString2 = this.mRuntime.a();
              if ((paramString2 == null) || (!paramString1.has("lastAnnouncement")) || (!paramString1.has("groupCode"))) {
                break label2402;
              }
              l = paramString1.optLong("groupCode");
              paramJsBridgeListener = paramString1.optString("lastAnnouncement");
              paramString3 = new Intent();
              paramString3.putExtra("groupCode", l);
              paramString3.putExtra("lastAnnouncement", paramJsBridgeListener);
              paramString3.putExtra("updateFromWeb", true);
              paramString2.setResult(-1, paramString3);
              label2137:
              if (!QLog.isColorLevel()) {
                break label2378;
              }
              QLog.i(this.TAG, 2, String.format("updateTroopAnnouncement [%s, %s, %s]", new Object[] { paramJsBridgeListener, Boolean.valueOf(paramString1.has("lastAnnouncement")), paramString2 }));
              return true;
            }
            catch (Throwable paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              return true;
            }
          } else {
            if (!"updateTroopAutoApprovalSetting".equals(paramString3)) {
              break label2380;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = this.mRuntime.a();
        if ((paramString1 == null) || (!paramJsBridgeListener.has("autoApprovalSetting")) || (!paramJsBridgeListener.has("groupCode"))) {
          break label2413;
        }
        l = paramJsBridgeListener.optLong("groupCode");
        i = paramJsBridgeListener.optInt("autoApprovalSetting");
        paramString2 = new Intent();
        paramString2.putExtra("groupCode", l);
        if (i != 1) {
          break label2407;
        }
        bool = true;
        paramString2.putExtra("autoApprovalSetting", bool);
        paramString2.putExtra("updateFromWeb", true);
        paramString1.setResult(-1, paramString2);
        if (QLog.isColorLevel())
        {
          QLog.i(this.TAG, 2, String.format("updateAutoApprovalSetting [%s, %s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramJsBridgeListener.has("autoApprovalSetting")), paramString1 }));
          return true;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      label2378:
      return true;
      label2380:
      return false;
      label2385:
      bool = false;
      break;
      label2391:
      i += 1;
      break label1336;
      label2400:
      return false;
      label2402:
      paramJsBridgeListener = null;
      break label2137;
      label2407:
      bool = false;
      continue;
      label2413:
      i = -1;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    Object localObject2 = (QBaseActivity)this.mRuntime.a();
    boolean bool;
    if (paramByte != 5)
    {
      switch (paramByte)
      {
      default: 
        return;
      case 45: 
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          return;
        }
        paramIntent = new Intent(this.mRuntime.a(), TroopCreateLogicActivity.class);
        paramIntent.putExtra("type", 4);
        paramIntent.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
        startActivityForResult(paramIntent, (byte)42);
        return;
      case 44: 
        paramIntent.getBooleanExtra("has_head", false);
        return;
      case 43: 
        if (paramIntent != null)
        {
          if (paramInt != -1) {
            return;
          }
          this.b = paramIntent.getIntExtra("isBack", -1);
          return;
        }
        return;
      case 42: 
        if (paramIntent != null)
        {
          if (paramInt != -1) {
            return;
          }
          a("onGroupInfoModified", paramIntent.getStringExtra("modifiedInfo"));
          return;
        }
        return;
      }
      a();
      if (paramIntent != null)
      {
        if (paramInt != -1) {
          return;
        }
        paramByte = paramIntent.getIntExtra("retCode", -1);
        paramIntent = paramIntent.getStringExtra("troopUin");
        bool = TextUtils.isEmpty(paramIntent);
        Object localObject1 = "";
        if (bool) {
          paramIntent = "";
        }
        paramInt = TroopCreateInfo.TroopCreateResult.a(paramByte);
        if (paramInt != 0) {
          QQToast.a(this.mRuntime.a(), paramInt, 0).b(((QBaseActivity)localObject2).getTitleBarHeight());
        }
        localObject2 = new JSONObject();
        try
        {
          ((JSONObject)localObject2).put("result", paramByte);
          if (!TextUtils.isEmpty(paramIntent)) {
            localObject1 = paramIntent;
          }
          ((JSONObject)localObject2).put("troopUin", localObject1);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        a("onCreateGroupResult", ((JSONObject)localObject2).toString());
        if (paramByte != 0) {
          return;
        }
        this.jdField_a_of_type_JavaLangString = paramIntent;
      }
    }
    else if (paramIntent != null)
    {
      if (paramInt != -1) {
        return;
      }
      paramByte = paramIntent.getIntExtra("errCode", -1);
      bool = paramIntent.getBooleanExtra("isClear", false);
      String str = paramIntent.getStringExtra("location");
      paramInt = paramIntent.getIntExtra("lat", 0);
      int i = paramIntent.getIntExtra("lon", 0);
      if (paramByte == 0)
      {
        if (bool) {
          QQToast.a((Context)localObject2, 2131720056, 0).b(((QBaseActivity)localObject2).getTitleBarHeight());
        } else {
          QQToast.a((Context)localObject2, 2131720061, 0).b(((QBaseActivity)localObject2).getTitleBarHeight());
        }
        paramIntent = new Intent();
        paramIntent.putExtra("location", str);
        paramIntent.putExtra("lat", paramInt);
        paramIntent.putExtra("lon", i);
        ((QBaseActivity)localObject2).setResult(-1, paramIntent);
        ((QBaseActivity)localObject2).finish();
        return;
      }
      if (paramByte == 1002) {
        paramIntent = ((QBaseActivity)localObject2).getString(2131720068);
      } else if (bool) {
        paramIntent = ((QBaseActivity)localObject2).getString(2131720055);
      } else {
        paramIntent = ((QBaseActivity)localObject2).getString(2131720060);
      }
      QQToast.a((Context)localObject2, paramIntent, 0).b(((QBaseActivity)localObject2).getTitleBarHeight());
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
    int i = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */