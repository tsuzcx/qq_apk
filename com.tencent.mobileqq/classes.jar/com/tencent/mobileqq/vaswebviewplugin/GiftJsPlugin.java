package com.tencent.mobileqq.vaswebviewplugin;

import aail;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import arkl;
import bhlm;
import bifw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;
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
    String str1 = arkl.a().troopAioUrl;
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {}
    for (int i = 1;; i = 0)
    {
      String str2 = aail.b(paramString);
      sTroopUin = paramString;
      bhlm.a(paramContext, str1.replace("{troopUin}", paramString).replace("{themeMode}", i + "").replace("{uin}", str2));
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
        aail.b((String)localObject, paramString);
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
    paramString2.putExtra("custom_title_name", BaseApplication.getContext().getString(2131697487));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin
 * JD-Core Version:    0.7.0.1
 */