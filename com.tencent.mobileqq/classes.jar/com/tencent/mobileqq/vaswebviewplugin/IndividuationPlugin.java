package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import aser;
import asev;
import bdll;
import beip;
import bhjx;
import bhyk;
import binq;
import bioy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
    super.sendRemoteReq(asev.a("isSupportFont", paramString, this.mOnRemoteResp.key, paramJSONObject), false, true);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.i("IndividuationPlugin", 2, "handleJsRequest, url=" + paramString1 + ",pkgName=" + paramString2 + ",method=" + paramString3);
    }
    boolean bool1;
    if ((paramString1 == null) || (!"individuation".equals(paramString2)) || (paramString3 == null)) {
      bool1 = false;
    }
    label189:
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          try
          {
            paramVarArgs = WebViewPlugin.getJsonFromJSBridge(paramString1);
            bool1 = bool2;
            if (paramVarArgs != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("IndividuationPlugin", 2, "handleJsRequest JSON = " + paramVarArgs.toString());
              }
              paramString2 = paramVarArgs.optString("callback");
              if (!"openPage".equals(paramString3)) {
                break label189;
              }
              paramJsBridgeListener = paramString2;
              if (TextUtils.isEmpty(paramString2)) {
                paramJsBridgeListener = "";
              }
              openPage(paramVarArgs, paramJsBridgeListener);
              return true;
            }
          }
          catch (Exception paramJsBridgeListener)
          {
            bool1 = bool2;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("IndividuationPlugin", 2, paramJsBridgeListener.getMessage());
      return true;
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
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("IndividuationPlugin", 2, "No such method: " + paramString3 + ", url=" + paramString1);
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.a();
    this.mBrowserApp = ((BrowserAppInterface)this.mRuntime.a());
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle == null) {}
    int j;
    String str2;
    String str1;
    Bundle localBundle;
    Object localObject;
    do
    {
      return;
      j = paramBundle.getInt("respkey", 0);
      str2 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      localBundle = paramBundle.getBundle("request");
      localObject = paramBundle.getBundle("response");
    } while ((localObject == null) || (j != this.mOnRemoteResp.key) || (str2 == null));
    if ("openProfileCard".equals(str2))
    {
      ((Bundle)localObject).getInt("isCache", 1);
      paramBundle = new Intent(this.mActivity, QQBrowserActivity.class);
      paramBundle.putExtra("uin", this.mRuntime.a().getAccount());
      paramBundle.putExtra("isShowAd", false);
      paramBundle.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramBundle.putExtra("url", bhyk.a(this.mActivity, "card", "inside.myIndividuationWeb"));
      this.mActivity.startActivity(paramBundle);
      return;
    }
    if ("openEmojiMall".equals(str2))
    {
      paramBundle = ((Bundle)localObject).getString("curChatUin");
      i = ((Bundle)localObject).getInt("curChatType", 0);
      EmojiHomeUiPlugin.openEmojiHomePage2(this.mActivity, this.mBrowserApp.getCurrentAccountUin(), 3, paramBundle, i);
      return;
    }
    if ("openEmojiDetail".equals(str2))
    {
      paramBundle = ((Bundle)localObject).getString("curChatUin");
      i = ((Bundle)localObject).getInt("curChatType", 0);
      localObject = localBundle.getString("pkgId");
      boolean bool = localBundle.getBoolean("isQFace");
      EmojiHomeUiPlugin.openEmojiDetailPage2(this.mActivity, this.mBrowserApp.getCurrentAccountUin(), 4, (String)localObject, Boolean.valueOf(bool).booleanValue(), i, paramBundle);
      return;
    }
    if ("openFontSetting".equals(str2))
    {
      if (((Bundle)localObject).getBoolean("feature"))
      {
        paramBundle = new Intent(this.mActivity, QQBrowserActivity.class);
        paramBundle.putExtra("hide_left_button", false);
        paramBundle.putExtra("show_right_close_button", false);
        paramBundle.putExtra("startOpenPageTime", System.currentTimeMillis());
        VasWebviewUtil.openQQBrowserWithoutAD(this.mActivity, bhyk.a(this.mActivity, "font", ""), 4096L, paramBundle, false, -1);
        return;
      }
      paramBundle = new Intent(this.mActivity, ChatTextSizeSettingActivity.class);
      this.mActivity.startActivity(paramBundle);
      return;
    }
    if ("isSupportFont".equals(str2))
    {
      if (((Bundle)localObject).getBoolean("feature")) {
        i = 1;
      }
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("result", i);
        super.callJs(str1, new String[] { paramBundle.toString() });
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    super.onResponse(paramBundle);
  }
  
  protected void openPage(JSONObject paramJSONObject, String paramString)
  {
    for (int i = 1;; i = -40) {
      try
      {
        localObject = paramJSONObject.getString("business");
        if (QLog.isColorLevel()) {
          QLog.i("IndividuationPlugin", 2, "openPage, business=" + (String)localObject);
        }
        if ("600".equals(localObject))
        {
          if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
            continue;
          }
          beip.a(null, "theme_detail", "205", 150, 1, i, ThemeUtil.getUserCurrentThemeId(this.mRuntime.a()), ThemeUtil.getUserCurrentThemeVersion(this.mRuntime.a()), "2", "");
          if (!BaseApplicationImpl.IS_SUPPORT_THEME)
          {
            Toast.makeText(this.mActivity.getApplicationContext(), this.mActivity.getString(2131718687), 0).show();
            return;
          }
          if (!bhjx.a())
          {
            Toast.makeText(this.mActivity.getApplicationContext(), this.mActivity.getString(2131717719), 0).show();
            return;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("IndividuationPlugin", 2, paramJSONObject.getMessage());
          return;
          paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
          paramJSONObject.putExtra("updateFlag", false);
          VasWebviewUtil.openQQBrowserWithoutAD(this.mActivity, bhyk.a(this.mActivity, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, paramJSONObject, true, 0);
          return;
          if ("500".equals(localObject))
          {
            paramJSONObject = new Intent();
            paramJSONObject.putExtra("bg_replace_entrance", 8);
            paramJSONObject.putExtra("selfSet_leftViewText", this.mActivity.getString(2131690559));
            paramJSONObject.putExtra("hide_left_button", false);
            paramJSONObject.putExtra("show_right_close_button", false);
            paramJSONObject.putExtra("url", bhyk.a(this.mActivity, "background", ""));
            paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
            paramJSONObject.putExtra("vasUsePreWebview", true);
            VasWebviewUtil.openQQBrowserWithoutAD(this.mRuntime.a(), bhyk.a(this.mRuntime.a(), "background", ""), 33554432L, paramJSONObject, true, 1);
            bdll.b(null, "CliOper", "", "", "0X8004E0D", "0X8004E0D", 0, 0, "", "", "", "");
            return;
          }
          if ("200".equals(localObject))
          {
            paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
            paramJSONObject.putExtra("updateFlag", false);
            VasWebviewUtil.openQQBrowserWithoutAD(this.mActivity, bhyk.a(this.mActivity, "bubble", "mvip.gongneng.android.bubble.index_dynamic_tab"), 64L, paramJSONObject, false, -1);
            return;
          }
          if ("100".equals(localObject))
          {
            paramJSONObject = new Bundle();
            super.sendRemoteReq(asev.a("openEmojiMall", paramString, this.mOnRemoteResp.key, paramJSONObject), true, true);
            return;
          }
          if ("101".equals(localObject))
          {
            paramJSONObject = paramJSONObject.getString("detailId");
            localObject = new Bundle();
            ((Bundle)localObject).putString("pkgId", paramJSONObject);
            ((Bundle)localObject).putBoolean("isQFace", Boolean.valueOf(false).booleanValue());
            super.sendRemoteReq(asev.a("openEmojiDetail", paramString, this.mOnRemoteResp.key, (Bundle)localObject), true, true);
            return;
          }
          if ("400".equals(localObject))
          {
            if (!bhjx.a())
            {
              Toast.makeText(this.mActivity.getApplicationContext(), this.mActivity.getString(2131717719), 0).show();
              return;
            }
            paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
            paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
            paramJSONObject.putExtra("hide_left_button", false);
            paramJSONObject.putExtra("show_right_close_button", false);
            paramJSONObject.putExtra("url", bhyk.a(this.mActivity, "pendant", ""));
            paramJSONObject.putExtra("business", 512L);
            paramJSONObject.putExtra("vasUsePreWebview", true);
            VasWebviewUtil.insertVasWbPluginToIntent(512L, paramJSONObject);
            paramJSONObject.putExtra("isShowAd", false);
            this.mActivity.startActivity(paramJSONObject);
            bdll.b(null, "CliOper", "", "", "PendantMarket", "WebEntrance", 0, 0, "", "", "", "");
            return;
          }
          if ("300".equals(localObject))
          {
            paramJSONObject = new Bundle();
            sendRemoteReq(asev.a("openFontSetting", paramString, this.mOnRemoteResp.key, paramJSONObject), true, true);
            return;
          }
          if ("700".equals(localObject))
          {
            paramJSONObject = new Bundle();
            super.sendRemoteReq(asev.a("openProfileCard", paramString, this.mOnRemoteResp.key, paramJSONObject), true, true);
            return;
          }
          if ("800".equals(localObject))
          {
            paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
            paramJSONObject.putExtra("hide_left_button", false);
            paramJSONObject.putExtra("show_right_close_button", false);
            paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
            VasWebviewUtil.openQQBrowserWithoutAD(this.mActivity, bhyk.a(this.mActivity, "suit", "mvip.gongneng.android.gxsuit"), 262144L, paramJSONObject, false, -1);
            return;
          }
          if ("900".equals(localObject))
          {
            paramJSONObject = new Intent(this.mActivity, QQBrowserActivity.class);
            paramJSONObject.putExtra("hide_left_button", false);
            paramJSONObject.putExtra("show_right_close_button", false);
            paramJSONObject.putExtra("startOpenPageTime", System.currentTimeMillis());
            VasWebviewUtil.openQQBrowserWithoutAD(this.mActivity, bhyk.a(this.mActivity, "ring", "mvip.gongneng.anroid.individuation.web"), 4194304L, paramJSONObject, false, -1);
            return;
          }
          if ("0".equals(localObject))
          {
            paramString = new Intent(this.mActivity, QQBrowserActivity.class);
            paramJSONObject = URLDecoder.decode(paramJSONObject.getString("detailId"), "UTF-8").replace("{uin}", this.mBrowserApp.getCurrentAccountUin()).replace("{client}", "androidQQ").replace("{version}", "8.4.5.4745").replace("{platformId}", "2").replace("{device}", Build.DEVICE).replace("{system}", Build.VERSION.RELEASE).replace("{systemInt}", Integer.toString(Build.VERSION.SDK_INT)).replace("{adtag}", "mvip.gongneng.anroid.individuation.web").replace("{updateFlag}", "false").replace("{density}", ThemeUtil.getThemeDensity(this.mBrowserApp.getApplication().getApplicationContext()));
            paramString.putExtra("url", paramJSONObject);
            VasWebviewUtil.openQQBrowserWithoutAD(this.mActivity, paramJSONObject, -1L, paramString, false, -1);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("IndividuationPlugin", 2, "Unknown business: " + (String)localObject);
          }
        }
        return;
      }
    }
  }
  
  public void setRightButton(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("type")) {
          break label130;
        }
        i = paramJSONObject.getInt("type");
        if (!paramJSONObject.has("text")) {
          break label135;
        }
        str = paramJSONObject.getString("text");
        if (!paramJSONObject.has("url")) {
          break label141;
        }
        paramJSONObject = paramJSONObject.getString("url");
        if ((i == 1) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject))) {
          return;
        }
        if (i == 2)
        {
          paramJSONObject = this.mRuntime.a();
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.mSwiftTitleUI.c;
            paramJSONObject.setVisibility(0);
            paramJSONObject.setText(2131694407);
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
      label130:
      int i = -1;
      continue;
      label135:
      String str = "";
      continue;
      label141:
      paramJSONObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin
 * JD-Core Version:    0.7.0.1
 */