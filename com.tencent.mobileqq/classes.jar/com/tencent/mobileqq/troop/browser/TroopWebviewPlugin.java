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
import com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi;
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
  protected QQProgressDialog a;
  protected int b;
  String c;
  protected int d = -1;
  protected Dialog e;
  protected boolean f;
  public final byte g = 5;
  AtomicBoolean h = new AtomicBoolean(false);
  TroopMemberApiClient i = null;
  QQCustomDialog j;
  
  public TroopWebviewPlugin()
  {
    this.mPluginNameSpace = "Troop";
  }
  
  private void c()
  {
    Dialog localDialog = this.e;
    if (localDialog != null)
    {
      if (localDialog.isShowing()) {
        this.e.dismiss();
      }
      this.e = null;
    }
  }
  
  private void d()
  {
    this.mRuntime.d().finish();
  }
  
  private void g(String paramString)
  {
    Object localObject = (QBaseActivity)this.mRuntime.d();
    a();
    localObject = new QQProgressDialog((Context)localObject, ((QBaseActivity)localObject).getTitleBarHeight());
    ((QQProgressDialog)localObject).a(paramString);
    ((QQProgressDialog)localObject).setCancelable(false);
    ((QQProgressDialog)localObject).setOnDismissListener(new TroopWebviewPlugin.3(this));
    this.a = ((QQProgressDialog)localObject);
    this.a.show();
  }
  
  private void h(String paramString)
  {
    Object localObject = (QBaseActivity)this.mRuntime.d();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText((Context)localObject, 2131892102, 0).show(((QBaseActivity)localObject).getTitleBarHeight());
      return;
    }
    g(((QBaseActivity)localObject).getString(2131917680));
    localObject = new Intent((Context)localObject, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("type", 1);
    ((Intent)localObject).putExtra("cfg", paramString);
    startActivityForResult((Intent)localObject, (byte)41);
  }
  
  private void i(String paramString)
  {
    Activity localActivity = this.mRuntime.d();
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 3);
    localIntent.putExtra("cfg", paramString);
    localActivity.startActivity(localIntent);
  }
  
  private void j(String paramString)
  {
    Activity localActivity = this.mRuntime.d();
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
    localIntent.putExtra("param_title", this.mRuntime.d().getString(2131891041));
    localIntent.putExtra("param_done_button_wording", this.mRuntime.d().getString(2131892267));
    localIntent.putExtra("param_done_button_highlight_wording", this.mRuntime.d().getString(2131892269));
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_max", 100);
    localIntent.putExtra("param_donot_need_contacts", true);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(localActivity, localIntent);
    localActivity.overridePendingTransition(2130771996, 2130771997);
  }
  
  private void k(String paramString)
  {
    String str2 = "";
    Activity localActivity = this.mRuntime.d();
    if (localActivity == null) {
      return;
    }
    int k = 0;
    String str1 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      str1 = str2;
      paramString = localJSONObject.optString("troopUin", "");
      str1 = paramString;
      boolean bool = localJSONObject.optBoolean("closeCurPage", false);
      k = bool;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = str1;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = TroopInfoUIUtil.a(paramString, 9);
      paramString.putString("troop_info_title", localActivity.getString(2131893880));
      paramString.putInt("troop_info_report_from", 1);
      ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfileForResult(localActivity, paramString, 45);
      localActivity.overridePendingTransition(2130771996, 2130771997);
    }
    if (k != 0) {
      localActivity.finish();
    }
  }
  
  private void l(String paramString)
  {
    Activity localActivity = this.mRuntime.d();
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
    Object localObject = this.mRuntime.d();
    g(((Activity)localObject).getString(2131917685));
    localObject = new Intent((Context)localObject, TroopCreateLogicActivity.class);
    ((Intent)localObject).putExtra("type", 5);
    ((Intent)localObject).putExtra("troop_location", paramString);
    ((Intent)localObject).putExtra("troop_uin", this.c);
    startActivityForResult((Intent)localObject, (byte)5);
  }
  
  void a()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if (localQQProgressDialog != null)
    {
      if (localQQProgressDialog.isShowing()) {
        this.a.dismiss();
      }
      this.a = null;
    }
  }
  
  public void a(String paramString)
  {
    QLog.e(this.mTAG, 1, "TroopCreateAvatarActivity 已在725下架");
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
      paramString2 = this.mTAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump: ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d(paramString2, 2, ((StringBuilder)localObject).toString());
    }
    this.mRuntime.d().startActivity(new Intent().setData(Uri.parse(paramString1)));
  }
  
  public void b()
  {
    c();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.mRuntime.d(), null);
    localActionSheet.setMainTitle(2131917678);
    localActionSheet.addButton(2131917679, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnDismissListener(new TroopWebviewPlugin.4(this));
    localActionSheet.setOnButtonClickListener(new TroopWebviewPlugin.5(this));
    this.e = localActionSheet;
    this.e.show();
  }
  
  public void b(String paramString)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)this.mRuntime.d();
    if (!NetworkUtil.isNetSupport(localQBaseActivity))
    {
      QQToast.makeText(localQBaseActivity, 2131892102, 0).show(localQBaseActivity.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    l(paramString);
  }
  
  public void c(String paramString)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)this.mRuntime.d();
    try
    {
      paramString = new JSONObject(paramString).optString("location", "");
      if (!this.f)
      {
        b(paramString);
        return;
      }
      if (!NetworkUtil.isNetSupport(localQBaseActivity))
      {
        QQToast.makeText(localQBaseActivity, 2131892102, 0).show(localQBaseActivity.getTitleBarHeight());
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
    int m = paramBundle.getInt("type");
    int n = TroopObserver.TYPE_GET_UIN_BY_OPEN_ID;
    int k = 2;
    Object localObject1;
    Object localObject2;
    if (m == n)
    {
      paramBundle.getBoolean("isSuccess");
      paramBundle.getInt("appid");
      paramBundle.getString("openGroupId");
      paramBundle.getString("token");
      paramBundle = paramBundle.getString("uin");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.mTAG);
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
        n = paramBundle.getInt("appid");
        localObject1 = paramBundle.getString("openGroupId");
        localObject2 = paramBundle.getString("token");
        int i1 = paramBundle.getInt("freq");
        int i2 = paramBundle.getInt("expireTime");
        ArrayList localArrayList = paramBundle.getStringArrayList("apilist");
        m = paramBundle.getInt("retCode");
        if (!bool)
        {
          if (m != 0) {}
          switch (m)
          {
          default: 
            k = -100;
            break;
          case 1000: 
          case 1001: 
          case 1002: 
          case 1003: 
          case 1005: 
          case 1006: 
            k = 4;
            break;
            k = 0;
          }
          paramBundle = new StringBuilder();
          paramBundle.append(" server retCode:");
          paramBundle.append(m);
          callJs4OpenApiIfNeeded("init", k, paramBundle.toString());
          return;
        }
        CustomWebView localCustomWebView = this.mRuntime.a();
        if (localCustomWebView != null)
        {
          localCustomWebView.saveToken(n, (String)localObject1, (String)localObject2, i1, i2, localArrayList);
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
    Activity localActivity = this.mRuntime.d();
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
        Activity localActivity = this.mRuntime.d();
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
      if (!(this.mRuntime.d() instanceof TroopTagViewActivity)) {
        return;
      }
      ((TroopTagViewActivity)this.mRuntime.d()).a(paramString);
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
    if ((paramLong != 8589934593L) && (paramLong != 8589934601L) && (paramLong == 2L) && (this.d != -1))
    {
      paramString = new JSONObject();
      try
      {
        paramString.put("isBack", this.d);
        a("onGetGroupHeadEditViewBack", paramString.toString());
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      this.d = -1;
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
    int k;
    try
    {
      paramString2 = new JSONObject(paramVarArgs[0]);
      k = paramString2.optInt("appid");
      paramString1 = paramString2.optString("openGroupId");
      paramString2 = paramString2.optString("token");
      paramString3 = new StringBuilder();
      paramString3.append(k);
      paramString3.append("");
      if ((!TextUtils.isEmpty(paramString3.toString())) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        paramJsBridgeListener = this.mRuntime.a().getUrl();
        m = paramJsBridgeListener.indexOf("?");
        paramString3 = this.i;
        if (m == -1) {
          paramJsBridgeListener = null;
        } else {
          paramJsBridgeListener = paramJsBridgeListener.substring(0, m);
        }
        paramString3.a(k, paramString1, paramString2, paramJsBridgeListener, "init", this);
        return true;
      }
      callJs4OpenApi(paramJsBridgeListener, 4, JsBridgeListener.a(4, null, null));
      return false;
    }
    catch (JSONException paramJsBridgeListener)
    {
      int m;
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
        k = paramString2.optInt("cateId");
        paramString2 = paramString2.optString("callback");
        this.i.a(paramJsBridgeListener, paramString1, k, paramString2, this);
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
      QQToast.makeText(this.mRuntime.d(), 0, "该api功能已下架!", 0).show();
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
      QQToast.makeText(this.mRuntime.d(), 0, "该api功能已下架!", 0).show();
      return true;
    }
    if (paramString3.equals("getVersion"))
    {
      paramJsBridgeListener.a("8.8.17.5770");
      return true;
    }
    if (paramString3.equals("isNetworkConnected"))
    {
      paramJsBridgeListener.a(Boolean.valueOf(APNUtil.k(CommonDataAdapter.a().b())));
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
        paramString1 = this.mRuntime.d();
        paramString2 = new StringBuilder();
        paramString2.append(this.mRuntime.b().getCurrentAccountUin());
        paramString2.append("_troopManager");
        if ((paramString1.getSharedPreferences(paramString2.toString(), 0).getInt("uniqueTitleNewFlag", 0) & 0x2) != 0) {
          break label2401;
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
        paramJsBridgeListener = this.mRuntime.d();
        paramString1 = new StringBuilder();
        paramString1.append(this.mRuntime.b().getCurrentAccountUin());
        paramString1.append("_troopManager");
        paramJsBridgeListener = paramJsBridgeListener.getSharedPreferences(paramString1.toString(), 0);
        k = paramJsBridgeListener.getInt("uniqueTitleNewFlag", 0);
        paramJsBridgeListener.edit().putInt("uniqueTitleNewFlag", k | 0x2).commit();
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
          m = paramJsBridgeListener.length();
          if (m > 0)
          {
            paramString1 = new long[m];
            k = 0;
            while (k < m)
            {
              paramString1[k] = paramJsBridgeListener.getLong(k);
              k += 1;
            }
            this.i.a(l, paramString1);
          }
          if (!QLog.isColorLevel()) {
            break label2394;
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
            break label2394;
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
          this.i.a(paramJsBridgeListener, paramString1, new TroopWebviewPlugin.1(this, paramString2));
          if (!QLog.isColorLevel()) {
            break label2394;
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
              k = 0;
              label1336:
              if (k < paramString3.length())
              {
                if (paramString3.optInt(k) <= 0) {
                  break label2407;
                }
                paramString1.add(Integer.valueOf(paramString3.optInt(k)));
                break label2407;
              }
            }
            k = paramString2.optInt("effectId");
            m = paramString2.optInt("svipLevel");
            int n = paramString2.optInt("svipType");
            paramString2 = paramString2.optString("effectName");
            this.i.a(paramString1, k, m, n, paramString2);
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
            SensorAPIJavaScript.returnToAio(this.i, this.mRuntime.d(), paramJsBridgeListener, true);
            return true;
          }
        }
        if ("notifyCreateTroops".equals(paramString3))
        {
          try
          {
            paramString3 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString3.optString("groupCode");
            if (TextUtils.isEmpty(paramJsBridgeListener))
            {
              if (!QLog.isColorLevel()) {
                break label2416;
              }
              QLog.e(this.mTAG, 2, "METHOD_NOTIFY_TROOP_CREATE uin empty");
              return false;
            }
            paramString1 = paramString3.optString("chat_type");
            paramString2 = paramString3.optString("callback");
            paramString3 = paramString3.optString("package_id");
            this.i.a(paramJsBridgeListener, paramString1, paramString3, paramString2, this);
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            if (!QLog.isColorLevel()) {
              break label2394;
            }
          }
          paramString1 = this.mTAG;
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
                k = 0;
                while (k < paramString2.length())
                {
                  paramVarArgs = paramString2.getJSONObject(k);
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(paramVarArgs.optString("groupCode"));
                  localStringBuilder.append(",");
                  localStringBuilder.append(paramVarArgs.optInt("status"));
                  paramString3.add(localStringBuilder.toString());
                  k += 1;
                }
                this.i.a(paramString3);
              }
              else
              {
                QLog.e(this.mTAG, 1, "notifySwitchStatus dataArray is empty");
                paramJsBridgeListener = "{\"ret\":-1}";
              }
              super.callJs(paramString1, new String[] { paramJsBridgeListener });
              return true;
            }
            catch (Exception paramJsBridgeListener)
            {
              paramString1 = this.mTAG;
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
              paramString2 = this.mRuntime.d();
              if ((paramString2 == null) || (!paramString1.has("lastAnnouncement")) || (!paramString1.has("groupCode"))) {
                break label2418;
              }
              l = paramString1.optLong("groupCode");
              paramJsBridgeListener = paramString1.optString("lastAnnouncement");
              paramString3 = new Intent();
              paramString3.putExtra("groupCode", l);
              paramString3.putExtra("lastAnnouncement", paramJsBridgeListener);
              paramString3.putExtra("updateFromWeb", true);
              paramString2.setResult(-1, paramString3);
              label2153:
              if (!QLog.isColorLevel()) {
                break label2394;
              }
              QLog.i(this.mTAG, 2, String.format("updateTroopAnnouncement [%s, %s, %s]", new Object[] { paramJsBridgeListener, Boolean.valueOf(paramString1.has("lastAnnouncement")), paramString2 }));
              return true;
            }
            catch (Throwable paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
              return true;
            }
          } else {
            if (!"updateTroopAutoApprovalSetting".equals(paramString3)) {
              break label2396;
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
        paramString1 = this.mRuntime.d();
        if ((paramString1 == null) || (!paramJsBridgeListener.has("autoApprovalSetting")) || (!paramJsBridgeListener.has("groupCode"))) {
          break label2429;
        }
        l = paramJsBridgeListener.optLong("groupCode");
        k = paramJsBridgeListener.optInt("autoApprovalSetting");
        paramString2 = new Intent();
        paramString2.putExtra("groupCode", l);
        if (k != 1) {
          break label2423;
        }
        bool = true;
        paramString2.putExtra("autoApprovalSetting", bool);
        paramString2.putExtra("updateFromWeb", true);
        paramString1.setResult(-1, paramString2);
        if (QLog.isColorLevel())
        {
          QLog.i(this.mTAG, 2, String.format("updateAutoApprovalSetting [%s, %s, %s]", new Object[] { Integer.valueOf(k), Boolean.valueOf(paramJsBridgeListener.has("autoApprovalSetting")), paramString1 }));
          return true;
        }
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      label2394:
      return true;
      label2396:
      return false;
      label2401:
      bool = false;
      break;
      label2407:
      k += 1;
      break label1336;
      label2416:
      return false;
      label2418:
      paramJsBridgeListener = null;
      break label2153;
      label2423:
      bool = false;
      continue;
      label2429:
      k = -1;
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    Object localObject = (QBaseActivity)this.mRuntime.d();
    String str1;
    boolean bool;
    if (paramByte != 5)
    {
      switch (paramByte)
      {
      default: 
        return;
      case 45: 
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        paramIntent = new Intent(this.mRuntime.d(), TroopCreateLogicActivity.class);
        paramIntent.putExtra("type", 4);
        paramIntent.putExtra("troop_uin", this.c);
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
          this.d = paramIntent.getIntExtra("isBack", -1);
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
        str1 = paramIntent.getStringExtra("troopUin");
        bool = TextUtils.isEmpty(str1);
        String str2 = "";
        if (bool) {
          str1 = "";
        }
        paramInt = TroopCreateInfo.TroopCreateResult.a(paramByte);
        paramIntent = paramIntent.getStringExtra("errMsg");
        if ((paramInt != 0) && (!((ICreateTroopBlackListUtilApi)QRoute.api(ICreateTroopBlackListUtilApi.class)).checkAndHandleCreateGroupBlackListResult(this.mRuntime.d(), (AppInterface)this.mRuntime.c(), paramIntent, paramByte))) {
          QQToast.makeText(this.mRuntime.d(), paramInt, 0).show(((QBaseActivity)localObject).getTitleBarHeight());
        }
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("result", paramByte);
          paramIntent = str2;
          if (!TextUtils.isEmpty(str1)) {
            paramIntent = str1;
          }
          ((JSONObject)localObject).put("troopUin", paramIntent);
        }
        catch (JSONException paramIntent)
        {
          paramIntent.printStackTrace();
        }
        a("onCreateGroupResult", ((JSONObject)localObject).toString());
        if (paramByte != 0) {
          return;
        }
        this.c = str1;
      }
    }
    else if (paramIntent != null)
    {
      if (paramInt != -1) {
        return;
      }
      paramByte = paramIntent.getIntExtra("errCode", -1);
      bool = paramIntent.getBooleanExtra("isClear", false);
      str1 = paramIntent.getStringExtra("location");
      paramInt = paramIntent.getIntExtra("lat", 0);
      int k = paramIntent.getIntExtra("lon", 0);
      if (paramByte == 0)
      {
        if (bool) {
          QQToast.makeText((Context)localObject, 2131917677, 0).show(((QBaseActivity)localObject).getTitleBarHeight());
        } else {
          QQToast.makeText((Context)localObject, 2131917682, 0).show(((QBaseActivity)localObject).getTitleBarHeight());
        }
        paramIntent = new Intent();
        paramIntent.putExtra("location", str1);
        paramIntent.putExtra("lat", paramInt);
        paramIntent.putExtra("lon", k);
        ((QBaseActivity)localObject).setResult(-1, paramIntent);
        ((QBaseActivity)localObject).finish();
        return;
      }
      if (paramByte == 1002) {
        paramIntent = ((QBaseActivity)localObject).getString(2131917689);
      } else if (bool) {
        paramIntent = ((QBaseActivity)localObject).getString(2131917676);
      } else {
        paramIntent = ((QBaseActivity)localObject).getString(2131917681);
      }
      QQToast.makeText((Context)localObject, paramIntent, 0).show(((QBaseActivity)localObject).getTitleBarHeight());
    }
  }
  
  public void onCreate()
  {
    this.b = this.mRuntime.d().getIntent().getIntExtra("troop_create_from", 0);
    if (this.b != 0) {
      this.mRuntime.d().setResult(-1);
    }
    if (this.h.compareAndSet(false, true))
    {
      this.i = TroopMemberApiClient.a();
      this.i.e();
    }
  }
  
  public void onDestroy()
  {
    int k = this.b;
    if (this.h.get()) {
      this.i.f();
    }
    QQCustomDialog localQQCustomDialog = this.j;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.j = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */