package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class IndividuationPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "individuation";
  public static final String Business_Activity = "0";
  public static final String Business_Bubble = "200";
  public static final String Business_ChagBg = "500";
  public static final String Business_ColorRing = "900";
  public static final String Business_Emoji = "100";
  public static final String Business_Emoji_Detail = "101";
  public static final String Business_Font = "300";
  public static final String Business_Pendant = "400";
  public static final String Business_Profilecard = "700";
  public static final String Business_Suit = "800";
  public static final String Business_Theme = "600";
  public static final String Business_funcall = "1000";
  public static final String Method_IsSupportFont = "isSupportFont";
  public static final String Method_OpenPage = "openPage";
  public static final String Method_setRightButton = "setRightButton";
  public static final int RIGHTBUTTON_TYPE_FONT = 2;
  public static final int RIGHTBUTTON_TYPE_WEB = 1;
  public static final int RequestCode_ThemeMall = 0;
  public static final byte Start_Activity_Request_Code_ChatBg = 1;
  public static final String TAG = "IndividuationPlugin";
  protected Activity mActivity;
  private BrowserAppInterface mBrowserApp;
  
  public IndividuationPlugin()
  {
    this.mPluginNameSpace = "individuation";
  }
  
  protected void getFontType(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = new Bundle();
    super.sendRemoteReq(DataFactory.a("isSupportFont", paramString, this.mOnRemoteResp.key, paramJSONObject), false, true);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(",pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(",method=");
      paramJsBridgeListener.append(paramString3);
      QLog.i("IndividuationPlugin", 2, paramJsBridgeListener.toString());
    }
    if ((paramString1 != null) && ("individuation".equals(paramString2)) && (paramString3 != null))
    {
      try
      {
        paramVarArgs = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramVarArgs == null) {
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("handleJsRequest JSON = ");
          paramJsBridgeListener.append(paramVarArgs.toString());
          QLog.d("IndividuationPlugin", 2, paramJsBridgeListener.toString());
        }
        paramString2 = paramVarArgs.optString("callback");
        if ("openPage".equals(paramString3))
        {
          paramJsBridgeListener = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramJsBridgeListener = "";
          }
          openPage(paramVarArgs, paramJsBridgeListener);
          return true;
        }
        if ("isSupportFont".equals(paramString3))
        {
          if (TextUtils.isEmpty(paramString2))
          {
            QLog.e("IndividuationPlugin", 1, "callback id is null, so return");
            return true;
          }
          getFontType(paramVarArgs, paramString2);
          return true;
        }
        if ("setRightButton".equals(paramString3))
        {
          setRightButton(paramVarArgs);
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("No such method: ");
          paramJsBridgeListener.append(paramString3);
          paramJsBridgeListener.append(", url=");
          paramJsBridgeListener.append(paramString1);
          QLog.d("IndividuationPlugin", 2, paramJsBridgeListener.toString());
          return true;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IndividuationPlugin", 2, paramJsBridgeListener.getMessage());
        }
      }
      return true;
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.a();
    this.mBrowserApp = ((BrowserAppInterface)this.mRuntime.a());
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void openPage(JSONObject paramJSONObject, String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramJSONObject.getString("business");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("openPage, business=");
          localStringBuilder.append((String)localObject);
          QLog.i("IndividuationPlugin", 2, localStringBuilder.toString());
        }
        boolean bool = "600".equals(localObject);
        if (bool)
        {
          if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
            break label1217;
          }
          i = 1;
          ThemeReporter.a(null, "theme_detail", "205", 150, 1, i, ThemeUtil.getUserCurrentThemeId(this.mRuntime.a()), ThemeUtil.getUserCurrentThemeVersion(this.mRuntime.a()), "2", "");
          if (!BaseApplicationImpl.IS_SUPPORT_THEME)
          {
            Toast.makeText(this.mActivity.getApplicationContext(), this.mActivity.getString(2131719620), 0).show();
            return;
          }
          if (!Utils.a())
          {
            Toast.makeText(this.mActivity.getApplicationContext(), this.mActivity.getString(2131718574), 0).show();
            return;
          }
          paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
          paramJSONObject.putExtra("updateFlag", false);
          VasWebviewUtil.b(this.mActivity, IndividuationUrlHelper.a(this.mActivity, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, paramJSONObject, true, 0);
          return;
        }
        bool = "500".equals(localObject);
        if (bool)
        {
          paramJSONObject = new Intent();
          paramJSONObject.putExtra("bg_replace_entrance", 8);
          paramJSONObject.putExtra("selfSet_leftViewText", this.mActivity.getString(2131690706));
          paramJSONObject.putExtra("hide_left_button", false);
          paramJSONObject.putExtra("show_right_close_button", false);
          paramJSONObject.putExtra("url", IndividuationUrlHelper.a(this.mActivity, "background", ""));
          paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramJSONObject.putExtra("vasUsePreWebview", true);
          VasWebviewUtil.b(this.mRuntime.a(), IndividuationUrlHelper.a(this.mRuntime.a(), "background", ""), 33554432L, paramJSONObject, true, 1);
          ReportController.b(null, "CliOper", "", "", "0X8004E0D", "0X8004E0D", 0, 0, "", "", "", "");
          return;
        }
        if ("200".equals(localObject))
        {
          paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
          paramJSONObject.putExtra("updateFlag", false);
          VasWebviewUtil.b(this.mActivity, IndividuationUrlHelper.a(this.mActivity, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramJSONObject, false, -1);
          return;
        }
        if ("100".equals(localObject))
        {
          paramJSONObject = new Bundle();
          super.sendRemoteReq(DataFactory.a("openEmojiMall", paramString, this.mOnRemoteResp.key, paramJSONObject), true, true);
          return;
        }
        bool = "101".equals(localObject);
        if (bool)
        {
          paramJSONObject = paramJSONObject.getString("detailId");
          localObject = new Bundle();
          ((Bundle)localObject).putString("pkgId", paramJSONObject);
          ((Bundle)localObject).putBoolean("isQFace", Boolean.valueOf(false).booleanValue());
          super.sendRemoteReq(DataFactory.a("openEmojiDetail", paramString, this.mOnRemoteResp.key, (Bundle)localObject), true, true);
          return;
        }
        if ("400".equals(localObject))
        {
          if (!Utils.a())
          {
            Toast.makeText(this.mActivity.getApplicationContext(), this.mActivity.getString(2131718574), 0).show();
            return;
          }
          paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
          paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
          paramJSONObject.putExtra("hide_left_button", false);
          paramJSONObject.putExtra("show_right_close_button", false);
          paramJSONObject.putExtra("url", IndividuationUrlHelper.a(this.mActivity, "pendant", ""));
          paramJSONObject.putExtra("business", 512L);
          paramJSONObject.putExtra("vasUsePreWebview", true);
          VasWebviewUtil.a(512L, paramJSONObject);
          paramJSONObject.putExtra("isShowAd", false);
          this.mActivity.startActivity(paramJSONObject);
          ReportController.b(null, "CliOper", "", "", "PendantMarket", "WebEntrance", 0, 0, "", "", "", "");
          return;
        }
        if ("300".equals(localObject))
        {
          paramJSONObject = new Bundle();
          sendRemoteReq(DataFactory.a("openFontSetting", paramString, this.mOnRemoteResp.key, paramJSONObject), true, true);
          return;
        }
        if ("700".equals(localObject))
        {
          paramJSONObject = new Bundle();
          super.sendRemoteReq(DataFactory.a("openProfileCard", paramString, this.mOnRemoteResp.key, paramJSONObject), true, true);
          return;
        }
        if ("800".equals(localObject))
        {
          paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
          paramJSONObject.putExtra("hide_left_button", false);
          paramJSONObject.putExtra("show_right_close_button", false);
          paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
          VasWebviewUtil.b(this.mActivity, IndividuationUrlHelper.a(this.mActivity, "suit", "mvip.gongneng.android.gxsuit"), 262144L, paramJSONObject, false, -1);
          return;
        }
        if ("900".equals(localObject))
        {
          paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
          paramJSONObject.putExtra("hide_left_button", false);
          paramJSONObject.putExtra("show_right_close_button", false);
          paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
          VasWebviewUtil.b(this.mActivity, IndividuationUrlHelper.a(this.mActivity, "ring", "mvip.gongneng.anroid.individuation.web"), 4194304L, paramJSONObject, false, -1);
          return;
        }
        if ("0".equals(localObject))
        {
          paramString = new Intent(this.mActivity, QQBrowserActivity.class);
          paramJSONObject = URLDecoder.decode(paramJSONObject.getString("detailId"), "UTF-8").replace("{uin}", this.mBrowserApp.getCurrentAccountUin()).replace("{client}", "androidQQ").replace("{version}", "8.7.0.5295").replace("{platformId}", "2").replace("{device}", Build.DEVICE).replace("{system}", Build.VERSION.RELEASE).replace("{systemInt}", Integer.toString(Build.VERSION.SDK_INT)).replace("{adtag}", "mvip.gongneng.anroid.individuation.web").replace("{updateFlag}", "false").replace("{density}", ThemeUtil.getThemeDensity(this.mBrowserApp.getApplication().getApplicationContext()));
          paramString.putExtra("url", paramJSONObject);
          VasWebviewUtil.b(this.mActivity, paramJSONObject, -1L, paramString, false, -1);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("Unknown business: ");
          paramJSONObject.append((String)localObject);
          QLog.d("IndividuationPlugin", 2, paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IndividuationPlugin", 2, paramJSONObject.getMessage());
        }
      }
      return;
      label1217:
      int i = -40;
    }
  }
  
  public void setRightButton(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("type")) {
          break label149;
        }
        i = paramJSONObject.getInt("type");
        boolean bool = paramJSONObject.has("text");
        String str2 = "";
        if (!bool) {
          break label154;
        }
        str1 = paramJSONObject.getString("text");
        if (paramJSONObject.has("url")) {
          str2 = paramJSONObject.getString("url");
        }
        if ((i == 1) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
          return;
        }
        if (i == 2)
        {
          paramJSONObject = (WebViewFragment)this.mRuntime.a();
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.getSwiftTitleUI().c;
            paramJSONObject.setVisibility(0);
            paramJSONObject.setText(2131694950);
            paramJSONObject.setOnClickListener(new IndividuationPlugin.1(this));
            return;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return;
      label149:
      int i = -1;
      continue;
      label154:
      String str1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin
 * JD-Core Version:    0.7.0.1
 */