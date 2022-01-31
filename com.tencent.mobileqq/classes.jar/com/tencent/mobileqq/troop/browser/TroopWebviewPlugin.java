package com.tencent.mobileqq.troop.browser;

import ajas;
import ajat;
import ajau;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopWebviewPlugin
  extends WebViewPlugin
  implements TroopMemberApiClient.Callback
{
  public final byte a;
  protected int a;
  public Dialog a;
  public TroopMemberApiClient a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public QQProgressDialog a;
  String jdField_a_of_type_JavaLangString;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected boolean a;
  protected int b = -1;
  
  public TroopWebviewPlugin()
  {
    this.jdField_a_of_type_Byte = 5;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
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
    ((QQProgressDialog)localObject).setOnDismissListener(new ajas(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = ((QQProgressDialog)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void h(String paramString)
  {
    Object localObject = (BaseActivity)this.mRuntime.a();
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a((Context)localObject, 2131433213, 0).b(((BaseActivity)localObject).getTitleBarHeight());
      return;
    }
    g(((BaseActivity)localObject).getString(2131435549));
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
        localIntent.putExtra("param_title", this.mRuntime.a().getString(2131433671));
        localIntent.putExtra("param_done_button_wording", this.mRuntime.a().getString(2131433016));
        localIntent.putExtra("param_done_button_highlight_wording", this.mRuntime.a().getString(2131435046));
        localIntent.putExtra("param_only_friends", true);
        localIntent.putExtra("param_exit_animation", 1);
        localIntent.putExtra("param_max", 10);
        localIntent.putExtra("param_donot_need_contacts", true);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(2131034123, 2131034124);
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
            paramString.putString("troop_info_title", localActivity.getString(2131429857));
            paramString.putInt("troop_info_report_from", 1);
            TroopInfoActivity.a(localActivity, paramString, 45);
            localActivity.overridePendingTransition(2131034123, 2131034124);
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
    g(((Activity)localObject).getString(2131435556));
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
  
  public void a(Bundle paramBundle)
  {
    int i = 2;
    if (paramBundle == null) {}
    do
    {
      return;
      if (paramBundle.getInt("type") != 84) {
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
    if (paramBundle.getInt("type") == 71)
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
        localCustomWebView.a(k, str, (String)localObject, m, n, localArrayList);
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
    localActionSheet.a(2131435554);
    localActionSheet.a(2131435555, 3);
    localActionSheet.c(2131433015);
    localActionSheet.setOnDismissListener(new ajat(this));
    localActionSheet.a(new ajau(this));
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void b(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.a();
    if (!NetworkUtil.d(localBaseActivity)) {
      QQToast.a(localBaseActivity, 2131433213, 0).b(localBaseActivity.getTitleBarHeight());
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
        QQToast.a(localBaseActivity, 2131433213, 0).b(localBaseActivity.getTitleBarHeight());
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
    //   18: ldc_w 479
    //   21: invokevirtual 174	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 4
    //   26: aload_1
    //   27: ldc_w 481
    //   30: invokevirtual 482	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   33: istore_2
    //   34: aload 4
    //   36: bipush 13
    //   38: invokestatic 236	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Ljava/lang/String;I)Landroid/os/Bundle;
    //   41: astore_1
    //   42: aload_1
    //   43: ldc_w 481
    //   46: iload_2
    //   47: invokevirtual 486	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   50: aload_3
    //   51: aload_1
    //   52: invokestatic 489	com/tencent/mobileqq/activity/TroopInfoActivity:a	(Landroid/content/Context;Landroid/os/Bundle;)V
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
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
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
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_0
    //   3: istore 6
    //   5: iconst_0
    //   6: istore 7
    //   8: iconst_0
    //   9: istore 9
    //   11: aload_3
    //   12: ldc 36
    //   14: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifne +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: aload 4
    //   25: aload_1
    //   26: invokevirtual 535	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:addOpenApiListenerIfNeeded	(Ljava/lang/String;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;)V
    //   29: ldc_w 343
    //   32: aload 4
    //   34: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +156 -> 193
    //   40: new 167	org/json/JSONObject
    //   43: dup
    //   44: aload 5
    //   46: iconst_0
    //   47: aaload
    //   48: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   51: astore_3
    //   52: aload_3
    //   53: ldc_w 296
    //   56: invokevirtual 538	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   59: istore 6
    //   61: aload_3
    //   62: ldc_w 298
    //   65: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore_2
    //   69: aload_3
    //   70: ldc_w 301
    //   73: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_3
    //   77: new 310	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   84: iload 6
    //   86: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: ldc 221
    //   91: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   100: ifne +17 -> 117
    //   103: aload_2
    //   104: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +10 -> 117
    //   110: aload_3
    //   111: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifeq +17 -> 131
    //   117: aload_0
    //   118: aload_1
    //   119: iconst_4
    //   120: iconst_4
    //   121: aconst_null
    //   122: aconst_null
    //   123: invokestatic 545	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(ILjava/lang/Object;Ljava/lang/String;)Ljava/lang/String;
    //   126: invokevirtual 549	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:callJs4OpenApi	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;ILjava/lang/String;)V
    //   129: iconst_0
    //   130: ireturn
    //   131: aload_0
    //   132: getfield 65	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   135: invokevirtual 354	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   138: invokevirtual 552	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   141: astore_1
    //   142: aload_1
    //   143: ldc_w 554
    //   146: invokevirtual 557	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   149: istore 7
    //   151: aload_0
    //   152: getfield 34	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   155: astore 4
    //   157: iload 7
    //   159: iconst_m1
    //   160: if_icmpne +22 -> 182
    //   163: aconst_null
    //   164: astore_1
    //   165: aload 4
    //   167: iload 6
    //   169: aload_2
    //   170: aload_3
    //   171: aload_1
    //   172: ldc_w 343
    //   175: aload_0
    //   176: invokevirtual 562	com/tencent/biz/troop/TroopMemberApiClient:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   179: goto +1700 -> 1879
    //   182: aload_1
    //   183: iconst_0
    //   184: iload 7
    //   186: invokevirtual 566	java/lang/String:substring	(II)Ljava/lang/String;
    //   189: astore_1
    //   190: goto -25 -> 165
    //   193: aload 4
    //   195: ldc_w 568
    //   198: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +1678 -> 1879
    //   204: aload 4
    //   206: ldc_w 570
    //   209: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   212: ifeq +14 -> 226
    //   215: aload_0
    //   216: aload 5
    //   218: iconst_0
    //   219: aaload
    //   220: invokespecial 572	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:h	(Ljava/lang/String;)V
    //   223: goto +1656 -> 1879
    //   226: aload 4
    //   228: ldc_w 574
    //   231: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +14 -> 248
    //   237: aload_0
    //   238: aload 5
    //   240: iconst_0
    //   241: aaload
    //   242: invokespecial 576	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:i	(Ljava/lang/String;)V
    //   245: goto +1634 -> 1879
    //   248: aload 4
    //   250: ldc_w 578
    //   253: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   256: ifeq +14 -> 270
    //   259: aload_0
    //   260: aload 5
    //   262: iconst_0
    //   263: aaload
    //   264: invokespecial 580	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:j	(Ljava/lang/String;)V
    //   267: goto +1612 -> 1879
    //   270: aload 4
    //   272: ldc_w 582
    //   275: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifeq +14 -> 292
    //   281: aload_0
    //   282: aload 5
    //   284: iconst_0
    //   285: aaload
    //   286: invokespecial 584	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:k	(Ljava/lang/String;)V
    //   289: goto +1590 -> 1879
    //   292: aload 4
    //   294: ldc_w 586
    //   297: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   300: ifeq +14 -> 314
    //   303: aload_0
    //   304: aload 5
    //   306: iconst_0
    //   307: aaload
    //   308: invokevirtual 588	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:c	(Ljava/lang/String;)V
    //   311: goto +1568 -> 1879
    //   314: aload 4
    //   316: ldc_w 590
    //   319: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   322: ifeq +10 -> 332
    //   325: aload_0
    //   326: invokespecial 592	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:d	()V
    //   329: goto +1550 -> 1879
    //   332: aload 4
    //   334: ldc_w 594
    //   337: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   340: ifeq +71 -> 411
    //   343: new 167	org/json/JSONObject
    //   346: dup
    //   347: aload 5
    //   349: iconst_0
    //   350: aaload
    //   351: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   354: astore_3
    //   355: aload_3
    //   356: ldc 171
    //   358: invokevirtual 174	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore_1
    //   362: aload_3
    //   363: ldc_w 596
    //   366: invokevirtual 174	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   369: astore_2
    //   370: aload_3
    //   371: ldc_w 598
    //   374: invokevirtual 538	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   377: istore 6
    //   379: aload_3
    //   380: ldc_w 364
    //   383: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   386: astore_3
    //   387: aload_0
    //   388: getfield 34	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   391: aload_1
    //   392: aload_2
    //   393: iload 6
    //   395: aload_3
    //   396: aload_0
    //   397: invokevirtual 601	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   400: goto +1479 -> 1879
    //   403: astore_1
    //   404: aload_1
    //   405: invokevirtual 218	org/json/JSONException:printStackTrace	()V
    //   408: goto +1471 -> 1879
    //   411: aload 4
    //   413: ldc_w 603
    //   416: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   419: ifeq +14 -> 433
    //   422: aload_0
    //   423: aload 5
    //   425: iconst_0
    //   426: aaload
    //   427: invokevirtual 604	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:a	(Ljava/lang/String;)V
    //   430: goto +1449 -> 1879
    //   433: aload 4
    //   435: ldc_w 606
    //   438: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   441: ifeq +25 -> 466
    //   444: aload_0
    //   445: getfield 65	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   448: invokevirtual 70	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   451: iconst_0
    //   452: ldc_w 608
    //   455: iconst_0
    //   456: invokestatic 611	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   459: invokevirtual 614	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   462: pop
    //   463: goto +1416 -> 1879
    //   466: aload 4
    //   468: ldc_w 616
    //   471: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   474: ifeq +22 -> 496
    //   477: aload_0
    //   478: aload 5
    //   480: iconst_0
    //   481: aaload
    //   482: invokevirtual 618	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:f	(Ljava/lang/String;)V
    //   485: aload_1
    //   486: iconst_1
    //   487: invokestatic 624	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   490: invokevirtual 627	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   493: goto +1386 -> 1879
    //   496: aload 4
    //   498: ldc_w 629
    //   501: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   504: ifeq +14 -> 518
    //   507: aload_0
    //   508: aload 5
    //   510: iconst_0
    //   511: aaload
    //   512: invokevirtual 631	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:d	(Ljava/lang/String;)V
    //   515: goto +1364 -> 1879
    //   518: aload 4
    //   520: ldc_w 633
    //   523: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   526: ifeq +25 -> 551
    //   529: aload_0
    //   530: getfield 65	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   533: invokevirtual 70	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   536: iconst_0
    //   537: ldc_w 608
    //   540: iconst_0
    //   541: invokestatic 611	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   544: invokevirtual 614	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   547: pop
    //   548: goto +1331 -> 1879
    //   551: aload 4
    //   553: ldc_w 635
    //   556: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   559: ifeq +13 -> 572
    //   562: aload_1
    //   563: ldc_w 637
    //   566: invokevirtual 627	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   569: goto +1310 -> 1879
    //   572: aload 4
    //   574: ldc_w 639
    //   577: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   580: ifeq +22 -> 602
    //   583: aload_1
    //   584: invokestatic 644	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   587: invokevirtual 647	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   590: invokestatic 650	com/tencent/open/base/APNUtil:d	(Landroid/content/Context;)Z
    //   593: invokestatic 624	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   596: invokevirtual 627	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   599: goto +1280 -> 1879
    //   602: aload 4
    //   604: ldc_w 652
    //   607: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   610: ifeq +14 -> 624
    //   613: aload_0
    //   614: aload 5
    //   616: iconst_0
    //   617: aaload
    //   618: invokevirtual 654	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:e	(Ljava/lang/String;)V
    //   621: goto +1258 -> 1879
    //   624: aload 4
    //   626: ldc_w 656
    //   629: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   632: ifne +1247 -> 1879
    //   635: aload 4
    //   637: ldc_w 658
    //   640: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   643: ifne +1236 -> 1879
    //   646: ldc_w 660
    //   649: aload 4
    //   651: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   654: ifeq +127 -> 781
    //   657: new 167	org/json/JSONObject
    //   660: dup
    //   661: aload 5
    //   663: iconst_0
    //   664: aaload
    //   665: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   668: ldc_w 364
    //   671: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   674: astore_1
    //   675: aload_0
    //   676: getfield 65	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   679: invokevirtual 70	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   682: new 310	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   689: aload_0
    //   690: getfield 65	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   693: invokevirtual 663	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   696: invokevirtual 668	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   699: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: ldc_w 670
    //   705: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: iconst_0
    //   712: invokevirtual 674	android/app/Activity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   715: ldc_w 676
    //   718: iconst_0
    //   719: invokeinterface 681 3 0
    //   724: iconst_2
    //   725: iand
    //   726: ifne +6 -> 732
    //   729: iconst_1
    //   730: istore 9
    //   732: aload_0
    //   733: aload_1
    //   734: iconst_1
    //   735: anewarray 259	java/lang/String
    //   738: dup
    //   739: iconst_0
    //   740: new 310	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   747: ldc_w 683
    //   750: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: iload 9
    //   755: invokevirtual 686	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   758: ldc_w 688
    //   761: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: aastore
    //   768: invokevirtual 370	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   771: iconst_1
    //   772: ireturn
    //   773: astore_1
    //   774: aload_1
    //   775: invokevirtual 218	org/json/JSONException:printStackTrace	()V
    //   778: goto +1101 -> 1879
    //   781: ldc_w 690
    //   784: aload 4
    //   786: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   789: ifeq +82 -> 871
    //   792: aload_0
    //   793: getfield 65	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   796: invokevirtual 70	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   799: new 310	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   806: aload_0
    //   807: getfield 65	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   810: invokevirtual 663	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   813: invokevirtual 668	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   816: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: ldc_w 670
    //   822: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: iconst_0
    //   829: invokevirtual 674	android/app/Activity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   832: astore_1
    //   833: aload_1
    //   834: ldc_w 676
    //   837: iconst_0
    //   838: invokeinterface 681 3 0
    //   843: istore 6
    //   845: aload_1
    //   846: invokeinterface 694 1 0
    //   851: ldc_w 676
    //   854: iload 6
    //   856: iconst_2
    //   857: ior
    //   858: invokeinterface 699 3 0
    //   863: invokeinterface 702 1 0
    //   868: pop
    //   869: iconst_1
    //   870: ireturn
    //   871: ldc_w 704
    //   874: aload 4
    //   876: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   879: ifeq +36 -> 915
    //   882: new 167	org/json/JSONObject
    //   885: dup
    //   886: aload 5
    //   888: iconst_0
    //   889: aaload
    //   890: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   893: ldc 171
    //   895: invokevirtual 174	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   898: astore_1
    //   899: aload_1
    //   900: ifnull +979 -> 1879
    //   903: iconst_1
    //   904: ireturn
    //   905: astore_1
    //   906: aload_1
    //   907: invokevirtual 218	org/json/JSONException:printStackTrace	()V
    //   910: aload_2
    //   911: astore_1
    //   912: goto -13 -> 899
    //   915: ldc_w 706
    //   918: aload 4
    //   920: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   923: ifeq +144 -> 1067
    //   926: new 167	org/json/JSONObject
    //   929: dup
    //   930: aload 5
    //   932: iconst_0
    //   933: aaload
    //   934: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   937: astore_1
    //   938: aload_1
    //   939: ldc_w 708
    //   942: invokevirtual 712	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   945: lstore 10
    //   947: aload_1
    //   948: ldc_w 714
    //   951: invokevirtual 718	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   954: astore_1
    //   955: aload_1
    //   956: invokevirtual 723	org/json/JSONArray:length	()I
    //   959: istore 7
    //   961: iload 7
    //   963: ifle +44 -> 1007
    //   966: iload 7
    //   968: newarray long
    //   970: astore_2
    //   971: iload 6
    //   973: iload 7
    //   975: if_icmpge +22 -> 997
    //   978: aload_2
    //   979: iload 6
    //   981: aload_1
    //   982: iload 6
    //   984: invokevirtual 726	org/json/JSONArray:getLong	(I)J
    //   987: lastore
    //   988: iload 6
    //   990: iconst_1
    //   991: iadd
    //   992: istore 6
    //   994: goto -23 -> 971
    //   997: aload_0
    //   998: getfield 34	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1001: lload 10
    //   1003: aload_2
    //   1004: invokevirtual 729	com/tencent/biz/troop/TroopMemberApiClient:a	(J[J)V
    //   1007: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1010: ifeq +869 -> 1879
    //   1013: ldc_w 731
    //   1016: iconst_2
    //   1017: new 310	java/lang/StringBuilder
    //   1020: dup
    //   1021: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1024: ldc_w 733
    //   1027: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: aload 5
    //   1032: iconst_0
    //   1033: aaload
    //   1034: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: goto +836 -> 1879
    //   1046: astore_1
    //   1047: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1050: ifeq +829 -> 1879
    //   1053: ldc_w 731
    //   1056: iconst_2
    //   1057: aload_1
    //   1058: invokevirtual 734	org/json/JSONException:toString	()Ljava/lang/String;
    //   1061: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1064: goto +815 -> 1879
    //   1067: ldc_w 736
    //   1070: aload 4
    //   1072: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1075: ifeq +104 -> 1179
    //   1078: new 167	org/json/JSONObject
    //   1081: dup
    //   1082: aload 5
    //   1084: iconst_0
    //   1085: aaload
    //   1086: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1089: astore_3
    //   1090: aload_3
    //   1091: ldc_w 738
    //   1094: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1097: astore_1
    //   1098: aload_3
    //   1099: ldc_w 740
    //   1102: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1105: astore_2
    //   1106: aload_3
    //   1107: ldc_w 364
    //   1110: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1113: astore_3
    //   1114: aload_0
    //   1115: getfield 34	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1118: aload_1
    //   1119: aload_2
    //   1120: new 742	ajaq
    //   1123: dup
    //   1124: aload_0
    //   1125: aload_3
    //   1126: invokespecial 744	ajaq:<init>	(Lcom/tencent/mobileqq/troop/browser/TroopWebviewPlugin;Ljava/lang/String;)V
    //   1129: invokevirtual 747	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   1132: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1135: ifeq +744 -> 1879
    //   1138: ldc_w 749
    //   1141: iconst_2
    //   1142: new 310	java/lang/StringBuilder
    //   1145: dup
    //   1146: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1149: ldc_w 751
    //   1152: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: aload 5
    //   1157: iconst_0
    //   1158: aaload
    //   1159: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1168: goto +711 -> 1879
    //   1171: astore_1
    //   1172: aload_1
    //   1173: invokevirtual 218	org/json/JSONException:printStackTrace	()V
    //   1176: goto +703 -> 1879
    //   1179: ldc_w 753
    //   1182: aload 4
    //   1184: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1187: ifeq +51 -> 1238
    //   1190: new 167	org/json/JSONObject
    //   1193: dup
    //   1194: aload 5
    //   1196: iconst_0
    //   1197: aaload
    //   1198: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1201: astore_1
    //   1202: aload_0
    //   1203: aload_1
    //   1204: ldc_w 738
    //   1207: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1210: aload_1
    //   1211: ldc_w 740
    //   1214: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1217: aload_1
    //   1218: ldc_w 755
    //   1221: invokevirtual 538	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1224: invokevirtual 757	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1227: goto +652 -> 1879
    //   1230: astore_1
    //   1231: aload_1
    //   1232: invokevirtual 218	org/json/JSONException:printStackTrace	()V
    //   1235: goto +644 -> 1879
    //   1238: ldc_w 759
    //   1241: aload 4
    //   1243: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1246: ifeq +98 -> 1344
    //   1249: new 167	org/json/JSONObject
    //   1252: dup
    //   1253: aload 5
    //   1255: iconst_0
    //   1256: aaload
    //   1257: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1260: astore_2
    //   1261: aload_2
    //   1262: ldc_w 364
    //   1265: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1268: astore_1
    //   1269: aload_2
    //   1270: ldc_w 761
    //   1273: invokevirtual 538	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1276: istore 6
    //   1278: aload_2
    //   1279: ldc_w 763
    //   1282: invokevirtual 538	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1285: istore 7
    //   1287: aload_2
    //   1288: ldc_w 765
    //   1291: invokevirtual 538	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1294: istore 8
    //   1296: aload_2
    //   1297: ldc_w 767
    //   1300: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1303: astore_2
    //   1304: aload_0
    //   1305: getfield 34	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1308: iload 6
    //   1310: iload 7
    //   1312: iload 8
    //   1314: aload_2
    //   1315: invokevirtual 770	com/tencent/biz/troop/TroopMemberApiClient:a	(IIILjava/lang/String;)V
    //   1318: aload_0
    //   1319: aload_1
    //   1320: iconst_1
    //   1321: anewarray 259	java/lang/String
    //   1324: dup
    //   1325: iconst_0
    //   1326: ldc_w 772
    //   1329: aastore
    //   1330: invokespecial 773	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1333: goto +546 -> 1879
    //   1336: astore_1
    //   1337: aload_1
    //   1338: invokevirtual 218	org/json/JSONException:printStackTrace	()V
    //   1341: goto +538 -> 1879
    //   1344: ldc_w 775
    //   1347: aload 4
    //   1349: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1352: ifeq +175 -> 1527
    //   1355: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1358: ifeq +33 -> 1391
    //   1361: ldc_w 749
    //   1364: iconst_2
    //   1365: new 310	java/lang/StringBuilder
    //   1368: dup
    //   1369: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1372: ldc_w 777
    //   1375: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: aload 5
    //   1380: iconst_0
    //   1381: aaload
    //   1382: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1388: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1391: new 167	org/json/JSONObject
    //   1394: dup
    //   1395: aload 5
    //   1397: iconst_0
    //   1398: aaload
    //   1399: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1402: ldc_w 779
    //   1405: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1408: astore_1
    //   1409: aload_1
    //   1410: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1413: istore 9
    //   1415: iload 9
    //   1417: ifeq +12 -> 1429
    //   1420: iconst_0
    //   1421: ireturn
    //   1422: astore_2
    //   1423: aconst_null
    //   1424: astore_1
    //   1425: aload_2
    //   1426: invokevirtual 218	org/json/JSONException:printStackTrace	()V
    //   1429: ldc_w 781
    //   1432: new 310	java/lang/StringBuilder
    //   1435: dup
    //   1436: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1439: getstatic 786	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1442: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1445: ldc_w 788
    //   1448: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: getstatic 791	android/os/Build:MODEL	Ljava/lang/String;
    //   1454: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1460: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1463: ifeq +45 -> 1508
    //   1466: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1469: ifeq +13 -> 1482
    //   1472: ldc_w 793
    //   1475: iconst_2
    //   1476: ldc_w 795
    //   1479: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1482: new 797	android/os/Handler
    //   1485: dup
    //   1486: invokespecial 798	android/os/Handler:<init>	()V
    //   1489: new 800	ajar
    //   1492: dup
    //   1493: aload_0
    //   1494: aload_1
    //   1495: invokespecial 801	ajar:<init>	(Lcom/tencent/mobileqq/troop/browser/TroopWebviewPlugin;Ljava/lang/String;)V
    //   1498: ldc2_w 802
    //   1501: invokevirtual 807	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   1504: pop
    //   1505: goto +374 -> 1879
    //   1508: aload_0
    //   1509: getfield 34	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1512: aload_0
    //   1513: getfield 65	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1516: invokevirtual 70	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1519: aload_1
    //   1520: iconst_1
    //   1521: invokestatic 813	com/tencent/biz/game/SensorAPIJavaScript:returnToAio	(Lcom/tencent/biz/troop/TroopMemberApiClient;Landroid/app/Activity;Ljava/lang/String;Z)V
    //   1524: goto +355 -> 1879
    //   1527: ldc_w 815
    //   1530: aload 4
    //   1532: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1535: ifeq +122 -> 1657
    //   1538: new 167	org/json/JSONObject
    //   1541: dup
    //   1542: aload 5
    //   1544: iconst_0
    //   1545: aaload
    //   1546: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1549: astore_3
    //   1550: aload_3
    //   1551: ldc_w 738
    //   1554: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1557: astore_1
    //   1558: aload_1
    //   1559: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1562: ifeq +23 -> 1585
    //   1565: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1568: ifeq +313 -> 1881
    //   1571: aload_0
    //   1572: getfield 314	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:TAG	Ljava/lang/String;
    //   1575: iconst_2
    //   1576: ldc_w 817
    //   1579: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1582: goto +299 -> 1881
    //   1585: aload_3
    //   1586: ldc_w 819
    //   1589: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1592: astore_2
    //   1593: aload_3
    //   1594: ldc_w 364
    //   1597: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1600: astore_3
    //   1601: aload_0
    //   1602: getfield 34	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1605: aload_1
    //   1606: aload_2
    //   1607: aload_3
    //   1608: aload_0
    //   1609: invokevirtual 822	com/tencent/biz/troop/TroopMemberApiClient:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/troop/TroopMemberApiClient$Callback;)V
    //   1612: goto +267 -> 1879
    //   1615: astore_1
    //   1616: invokestatic 308	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1619: ifeq +260 -> 1879
    //   1622: aload_0
    //   1623: getfield 314	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:TAG	Ljava/lang/String;
    //   1626: iconst_2
    //   1627: new 310	java/lang/StringBuilder
    //   1630: dup
    //   1631: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1634: ldc_w 824
    //   1637: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: aload_1
    //   1641: invokevirtual 734	org/json/JSONException:toString	()Ljava/lang/String;
    //   1644: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1647: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1650: aload_1
    //   1651: invokestatic 827	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1654: goto +225 -> 1879
    //   1657: ldc_w 829
    //   1660: aload 4
    //   1662: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1665: ifeq +207 -> 1872
    //   1668: new 167	org/json/JSONObject
    //   1671: dup
    //   1672: aload 5
    //   1674: iconst_0
    //   1675: aaload
    //   1676: invokespecial 169	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1679: astore_1
    //   1680: aload_1
    //   1681: ldc_w 364
    //   1684: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1687: astore_2
    //   1688: aload_1
    //   1689: ldc_w 831
    //   1692: invokevirtual 834	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1695: astore_3
    //   1696: ldc_w 772
    //   1699: astore_1
    //   1700: aload_3
    //   1701: ifnull +153 -> 1854
    //   1704: aload_3
    //   1705: invokevirtual 723	org/json/JSONArray:length	()I
    //   1708: ifle +146 -> 1854
    //   1711: new 361	java/util/ArrayList
    //   1714: dup
    //   1715: invokespecial 835	java/util/ArrayList:<init>	()V
    //   1718: astore 4
    //   1720: iload 7
    //   1722: istore 6
    //   1724: iload 6
    //   1726: aload_3
    //   1727: invokevirtual 723	org/json/JSONArray:length	()I
    //   1730: if_icmpge +64 -> 1794
    //   1733: aload_3
    //   1734: iload 6
    //   1736: invokevirtual 839	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1739: astore 5
    //   1741: aload 4
    //   1743: new 310	java/lang/StringBuilder
    //   1746: dup
    //   1747: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1750: aload 5
    //   1752: ldc_w 738
    //   1755: invokevirtual 540	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1758: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: ldc_w 841
    //   1764: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: aload 5
    //   1769: ldc_w 843
    //   1772: invokevirtual 538	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1775: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1778: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1781: invokevirtual 846	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1784: pop
    //   1785: iload 6
    //   1787: iconst_1
    //   1788: iadd
    //   1789: istore 6
    //   1791: goto -67 -> 1724
    //   1794: aload_0
    //   1795: getfield 34	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   1798: aload 4
    //   1800: invokevirtual 849	com/tencent/biz/troop/TroopMemberApiClient:a	(Ljava/util/ArrayList;)V
    //   1803: aload_0
    //   1804: aload_2
    //   1805: iconst_1
    //   1806: anewarray 259	java/lang/String
    //   1809: dup
    //   1810: iconst_0
    //   1811: aload_1
    //   1812: aastore
    //   1813: invokespecial 773	com/tencent/mobileqq/webview/swift/WebViewPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1816: goto +63 -> 1879
    //   1819: astore_1
    //   1820: aload_0
    //   1821: getfield 314	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:TAG	Ljava/lang/String;
    //   1824: iconst_1
    //   1825: new 310	java/lang/StringBuilder
    //   1828: dup
    //   1829: invokespecial 311	java/lang/StringBuilder:<init>	()V
    //   1832: ldc_w 851
    //   1835: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: aload_1
    //   1839: invokevirtual 852	java/lang/Exception:toString	()Ljava/lang/String;
    //   1842: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1848: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1851: goto +28 -> 1879
    //   1854: aload_0
    //   1855: getfield 314	com/tencent/mobileqq/troop/browser/TroopWebviewPlugin:TAG	Ljava/lang/String;
    //   1858: iconst_1
    //   1859: ldc_w 854
    //   1862: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1865: ldc_w 856
    //   1868: astore_1
    //   1869: goto -66 -> 1803
    //   1872: iconst_0
    //   1873: ireturn
    //   1874: astore_2
    //   1875: goto -450 -> 1425
    //   1878: astore_1
    //   1879: iconst_1
    //   1880: ireturn
    //   1881: iconst_0
    //   1882: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1883	0	this	TroopWebviewPlugin
    //   0	1883	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	1883	2	paramString1	String
    //   0	1883	3	paramString2	String
    //   0	1883	4	paramString3	String
    //   0	1883	5	paramVarArgs	String[]
    //   3	1787	6	i	int
    //   6	1715	7	j	int
    //   1294	19	8	k	int
    //   9	1407	9	bool	boolean
    //   945	57	10	l	long
    // Exception table:
    //   from	to	target	type
    //   343	400	403	org/json/JSONException
    //   657	675	773	org/json/JSONException
    //   675	729	773	org/json/JSONException
    //   732	771	773	org/json/JSONException
    //   882	899	905	org/json/JSONException
    //   926	961	1046	org/json/JSONException
    //   966	971	1046	org/json/JSONException
    //   978	988	1046	org/json/JSONException
    //   997	1007	1046	org/json/JSONException
    //   1007	1043	1046	org/json/JSONException
    //   1078	1168	1171	org/json/JSONException
    //   1190	1227	1230	org/json/JSONException
    //   1249	1333	1336	org/json/JSONException
    //   1391	1409	1422	org/json/JSONException
    //   1538	1582	1615	org/json/JSONException
    //   1585	1612	1615	org/json/JSONException
    //   1668	1696	1819	java/lang/Exception
    //   1704	1720	1819	java/lang/Exception
    //   1724	1785	1819	java/lang/Exception
    //   1794	1803	1819	java/lang/Exception
    //   1803	1816	1819	java/lang/Exception
    //   1854	1865	1819	java/lang/Exception
    //   1409	1415	1874	org/json/JSONException
    //   40	117	1878	org/json/JSONException
    //   117	129	1878	org/json/JSONException
    //   131	157	1878	org/json/JSONException
    //   165	179	1878	org/json/JSONException
    //   182	190	1878	org/json/JSONException
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
        QQToast.a((Context)localObject2, 2131435559, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
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
        QQToast.a((Context)localObject2, 2131435557, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
      }
    }
    if (paramByte == 1002) {
      paramIntent = ((BaseActivity)localObject2).getString(2131435561);
    }
    for (;;)
    {
      QQToast.a((Context)localObject2, paramIntent, 0).b(((BaseActivity)localObject2).getTitleBarHeight());
      return;
      if (bool) {
        paramIntent = ((BaseActivity)localObject2).getString(2131435560);
      } else {
        paramIntent = ((BaseActivity)localObject2).getString(2131435558);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */