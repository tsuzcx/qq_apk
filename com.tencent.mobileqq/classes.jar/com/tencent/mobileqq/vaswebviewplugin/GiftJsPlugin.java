package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.BrowserUtils;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.AnonymousIPC;
import com.tencent.mobileqq.vas.ipc.remote.IAnonymousIPC;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import java.security.MessageDigest;
import java.util.Map;
import org.apache.commons.codec.binary.Hex;
import org.json.JSONException;
import org.json.JSONObject;

public class GiftJsPlugin
  extends VasWebviewJsPluginV2
{
  public static final String BUSINESS_NAME = "GiftJsPlugin";
  public static final String TAG = "GiftJsPlugin";
  public static String sCallbackJs = "";
  public static String sTroopUin = "";
  
  public GiftJsPlugin()
  {
    super("GiftJsPlugin");
  }
  
  public static void openGiftBrowser(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str1 = QVipGiftProcessor.a().troopAioUrl;
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {}
    for (int i = 1;; i = 0)
    {
      String str2 = TroopGiftAioPanelData.b(paramString);
      sTroopUin = paramString;
      BrowserUtils.a(paramContext, str1.replace("{troopUin}", paramString).replace("{themeMode}", i + "").replace("{uin}", str2));
      return;
    }
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey("requestCode")) && (paramMap.containsKey("data")) && (((Integer)paramMap.get("requestCode")).intValue() == 12006))
    {
      Object localObject = (Intent)paramMap.get("data");
      paramString = ((Intent)localObject).getStringExtra("member_uin");
      paramMap = ((Intent)localObject).getStringExtra("member_nickname");
      localObject = ((Intent)localObject).getStringExtra("troop_uin");
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        TroopGiftAioPanelData.b((String)localObject, paramString);
      }
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("uin", paramString);
        ((JSONObject)localObject).put("nick", paramMap);
        super.callJs(sCallbackJs, new String[] { ((JSONObject)localObject).toString() });
        return true;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    return false;
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|uin", method="selectMember")
  public void openSelectMember(String paramString1, String paramString2)
  {
    sCallbackJs = paramString1;
    paramString2 = TroopMemberListActivity.a(BaseApplication.getContext(), paramString2, 14);
    paramString2.putExtra("param_is_pop_up_style", true);
    paramString2.putExtra("custom_title_name", BaseApplication.getContext().getString(2131697741));
    paramString2.setFlags(603979776);
    this.mRuntime.a().startActivityForResult(paramString2, 12006);
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localAppInterface instanceof BrowserAppInterface)) {
      paramString2.putExtra("troop_gift_from", localAppInterface.getCurrentAccountUin());
    }
    this.mRuntime.a().startActivityForResult(paramString2, 12006);
    try
    {
      super.callJs(paramString1);
      return;
    }
    catch (Exception paramString2)
    {
      super.callJsOnError(paramString1, paramString2.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|troopUin|uin", method="getAnonymousInfo")
  public void transferAnonymousInfo(String paramString1, String paramString2, String paramString3)
  {
    sCallbackJs = paramString1;
    IAnonymousIPC localIAnonymousIPC;
    if (paramString3.equals(this.mRuntime.a().getCurrentAccountUin()))
    {
      localIAnonymousIPC = (IAnonymousIPC)RemoteProxy.getProxy(AnonymousIPC.class);
      if (localIAnonymousIPC.isAnonymous(paramString2)) {
        break label59;
      }
      super.callJs(sCallbackJs, new String[] { "" });
    }
    label59:
    do
    {
      return;
      paramString1 = localIAnonymousIPC.getNickname(paramString2);
      paramString3 = localIAnonymousIPC.getAvatarID(paramString2);
      paramString2 = localIAnonymousIPC.getRankColor(paramString2);
    } while (paramString1 == null);
    paramString1 = "name=" + paramString1 + "&id=" + paramString3 + "&color=" + paramString2;
    try
    {
      paramString2 = MessageDigest.getInstance("MD5");
      paramString3 = QVipGiftProcessor.a().anonymousFlag;
      paramString2 = new String(Hex.encodeHex(paramString2.digest((paramString1 + "&key=" + paramString3).getBytes("utf-8"))));
      paramString1 = "{anonymousInfo:\"" + paramString1 + "\",sign:\"" + paramString2 + "\"}";
      super.callJs(sCallbackJs, new String[] { paramString1 });
      return;
    }
    catch (Exception paramString1)
    {
      super.callJsOnError(sCallbackJs, paramString1.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin
 * JD-Core Version:    0.7.0.1
 */