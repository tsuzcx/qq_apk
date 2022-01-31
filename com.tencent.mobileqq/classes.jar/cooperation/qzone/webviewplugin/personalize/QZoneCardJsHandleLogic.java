package cooperation.qzone.webviewplugin.personalize;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneCardJsHandleLogic
{
  public static void a(WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    str2 = "";
    String str1 = "";
    Object localObject1 = str1;
    localObject2 = str2;
    if (paramVarArgs != null)
    {
      localObject1 = str1;
      localObject2 = str2;
      if (paramVarArgs.length > 0) {
        localObject1 = str1;
      }
    }
    try
    {
      localObject2 = new JSONObject(paramVarArgs[0]);
      localObject1 = str1;
      paramVarArgs = ((JSONObject)localObject2).getString("cardid");
      localObject1 = paramVarArgs;
      localObject2 = ((JSONObject)localObject2).getString("cardurl");
      localObject1 = paramVarArgs;
    }
    catch (JSONException paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        localObject2 = str2;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneCardLogic.QZoneCardJsHandleLogicQZonePersonalizePlugin", 4, "handleDownCardMethod js give download cardurl is: " + (String)localObject2 + "\t cardid:" + (String)localObject1);
    }
    paramVarArgs = new Intent("action_personalize_js2qzone");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("cmd", "downloadcard");
    ((Bundle)localObject1).putString("cardDownloadUrl", (String)localObject2);
    paramVarArgs.putExtras((Bundle)localObject1);
    QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), paramVarArgs);
  }
  
  public static void a(WebViewPlugin paramWebViewPlugin, WebViewPlugin.PluginRuntime paramPluginRuntime, String... paramVarArgs)
  {
    String str2 = "";
    String str3 = "";
    String str7 = "";
    long l2 = 0L;
    String str5 = "";
    int n = 0;
    String str4 = "";
    int i1 = 0;
    String str6 = "";
    int i = 0;
    Object localObject3 = "";
    Object localObject4 = "";
    String str1 = "";
    Object localObject6;
    Object localObject5;
    int j;
    Object localObject9;
    int m;
    Object localObject8;
    int k;
    Object localObject7;
    long l1;
    Object localObject2;
    Object localObject1;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localObject6 = localObject4;
      localObject5 = localObject3;
      paramWebViewPlugin = str7;
      j = i;
      localObject9 = str6;
      m = i1;
      localObject8 = str4;
      k = n;
      localObject7 = str5;
      l1 = l2;
      localObject2 = str3;
      localObject1 = str2;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        str2 = localJSONObject.getString("result");
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        str7 = localJSONObject.getString("sPicUrl");
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        str3 = localJSONObject.getString("sSkinId");
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        str4 = localJSONObject.getString("strTraceInfo");
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        str5 = localJSONObject.getString("title");
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        l2 = localJSONObject.getLong("uiSettleTime");
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        n = localJSONObject.getInt("vip_property");
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        i1 = localJSONObject.optInt("type");
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        str6 = localJSONObject.optString("musicurl");
        localObject6 = localObject4;
        localObject5 = localObject3;
        paramWebViewPlugin = str7;
        j = i;
        localObject9 = str6;
        m = i1;
        localObject8 = str4;
        k = n;
        localObject7 = str5;
        l1 = l2;
        localObject2 = str3;
        localObject1 = str2;
        if (localJSONObject.optInt("need_jump") != 1) {
          continue;
        }
        i = 1;
        paramWebViewPlugin = str1;
        paramVarArgs = (String[])localObject4;
        localObject1 = localObject3;
        localObject2 = str7;
        if (i1 == 392)
        {
          localObject6 = localObject4;
          localObject5 = localObject3;
          paramWebViewPlugin = str7;
          j = i;
          localObject9 = str6;
          m = i1;
          localObject8 = str4;
          k = n;
          localObject7 = str5;
          l1 = l2;
          localObject2 = str3;
          localObject1 = str2;
          paramVarArgs = localJSONObject.getString("bgPic");
          localObject6 = localObject4;
          localObject5 = localObject3;
          paramWebViewPlugin = paramVarArgs;
          j = i;
          localObject9 = str6;
          m = i1;
          localObject8 = str4;
          k = n;
          localObject7 = str5;
          l1 = l2;
          localObject2 = str3;
          localObject1 = str2;
          localObject3 = localJSONObject.getString("bgColor");
          localObject6 = localObject4;
          localObject5 = localObject3;
          paramWebViewPlugin = paramVarArgs;
          j = i;
          localObject9 = str6;
          m = i1;
          localObject8 = str4;
          k = n;
          localObject7 = str5;
          l1 = l2;
          localObject2 = str3;
          localObject1 = str2;
          localObject4 = localJSONObject.getString("gradientColorBegin");
          localObject6 = localObject4;
          localObject5 = localObject3;
          paramWebViewPlugin = paramVarArgs;
          j = i;
          localObject9 = str6;
          m = i1;
          localObject8 = str4;
          k = n;
          localObject7 = str5;
          l1 = l2;
          localObject2 = str3;
          localObject1 = str2;
          str7 = localJSONObject.getString("gradientColorEnd");
          paramWebViewPlugin = str7;
          localObject2 = paramVarArgs;
          localObject1 = localObject3;
          paramVarArgs = (String[])localObject4;
        }
        localObject4 = str6;
        j = i1;
        localObject5 = str4;
        k = n;
        localObject6 = str5;
        localObject7 = localObject2;
        localObject8 = str2;
        localObject2 = str3;
        l1 = l2;
        localObject3 = localObject1;
      }
      catch (JSONException paramVarArgs)
      {
        localObject4 = localObject9;
        localObject9 = paramWebViewPlugin;
        i = j;
        paramVarArgs.printStackTrace();
        paramWebViewPlugin = str1;
        paramVarArgs = (String[])localObject6;
        localObject3 = localObject5;
        j = m;
        localObject5 = localObject8;
        localObject6 = localObject7;
        localObject7 = localObject9;
        localObject8 = localObject1;
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneCardLogic.QZoneCardJsHandleLogicQZonePersonalizePlugin", 4, "handleSetSkinFinish result:" + (String)localObject8 + "js give cardurl is: " + (String)localObject7 + "\t cardid:" + (String)localObject2);
      }
      if (((String)localObject8).equals("success"))
      {
        localObject1 = new Intent("action_personalize_js2qzone");
        localObject8 = new Bundle();
        ((Bundle)localObject8).putString("sSkinId", (String)localObject2);
        ((Bundle)localObject8).putLong("lUin", 0L);
        ((Bundle)localObject8).putString("sPicUrl", (String)localObject7);
        ((Bundle)localObject8).putLong("lTime", l1);
        ((Bundle)localObject8).putString("desc", "");
        ((Bundle)localObject8).putString("title", (String)localObject6);
        ((Bundle)localObject8).putInt("vip_property", k);
        ((Bundle)localObject8).putString("strTraceInfo", (String)localObject5);
        ((Bundle)localObject8).putInt("type", j);
        ((Bundle)localObject8).putString("musicurl", (String)localObject4);
        ((Bundle)localObject8).putString("bgColor", (String)localObject3);
        ((Bundle)localObject8).putString("gradientColorBegin", paramVarArgs);
        ((Bundle)localObject8).putString("gradientColorEnd", paramWebViewPlugin);
        ((Bundle)localObject8).putString("cmd", "setcardfinish");
        ((Intent)localObject1).putExtras((Bundle)localObject8);
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneCardLogic.QZoneCardJsHandleLogicQZonePersonalizePlugin", 4, "handleSetSkinFinish broadcast actionString: " + ((Intent)localObject1).getAction() + "to qzone process,card lTime:" + l1 + ",type:" + j + ",musicurl:" + (String)localObject4);
        }
        QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), (Intent)localObject1);
        LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_18", 0, Long.valueOf(paramPluginRuntime.a().getCurrentAccountUin()).longValue());
        if (i != 0) {
          QZoneHelper.a(paramPluginRuntime.a(), QZoneHelper.UserInfo.a(), paramPluginRuntime.a().getAccount(), 0, 0, 256);
        }
      }
      return;
      i = 0;
      continue;
      localObject1 = "";
      j = 0;
      localObject5 = "";
      k = 0;
      localObject6 = "";
      localObject7 = "";
      i = 0;
      paramWebViewPlugin = str1;
      paramVarArgs = (String[])localObject4;
      localObject4 = localObject1;
      l1 = l2;
      localObject2 = str3;
      localObject8 = str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCardJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */