package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      super.callJs(sCallbackJs, new String[] { ((JSONObject)localObject).toString() });
      return true;
    }
    return false;
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|uin", method="selectMember")
  public void openSelectMember(String paramString1, String paramString2)
  {
    sCallbackJs = paramString1;
    paramString2 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopMemberListActivityLaunchIntent(BaseApplication.getContext(), paramString2, 14);
    paramString2.putExtra("param_is_pop_up_style", true);
    paramString2.putExtra("custom_title_name", BaseApplication.getContext().getString(2131697747));
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
    if (paramString3.equals(this.mRuntime.a().getCurrentAccountUin()))
    {
      Object localObject = (IAnonymousIPC)RemoteProxy.getProxy(AnonymousIPC.class);
      if (!((IAnonymousIPC)localObject).isAnonymous(paramString2))
      {
        super.callJs(sCallbackJs, new String[] { "" });
        return;
      }
      paramString1 = ((IAnonymousIPC)localObject).getNickname(paramString2);
      paramString3 = ((IAnonymousIPC)localObject).getAvatarID(paramString2);
      paramString2 = ((IAnonymousIPC)localObject).getRankColor(paramString2);
      if (paramString1 != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("name=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("&id=");
        ((StringBuilder)localObject).append(paramString3);
        ((StringBuilder)localObject).append("&color=");
        ((StringBuilder)localObject).append(paramString2);
        paramString1 = ((StringBuilder)localObject).toString();
        try
        {
          paramString2 = MessageDigest.getInstance("MD5");
          paramString3 = QVipGiftProcessor.a().anonymousFlag;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("&key=");
          ((StringBuilder)localObject).append(paramString3);
          paramString2 = new String(Hex.encodeHex(paramString2.digest(((StringBuilder)localObject).toString().getBytes("utf-8"))));
          paramString3 = new StringBuilder();
          paramString3.append("{anonymousInfo:\"");
          paramString3.append(paramString1);
          paramString3.append("\",sign:\"");
          paramString3.append(paramString2);
          paramString3.append("\"}");
          paramString1 = paramString3.toString();
          super.callJs(sCallbackJs, new String[] { paramString1 });
          return;
        }
        catch (Exception paramString1)
        {
          super.callJsOnError(sCallbackJs, paramString1.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin
 * JD-Core Version:    0.7.0.1
 */