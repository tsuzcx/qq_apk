package cooperation.qzone.webviewplugin;

import aadf;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.RelativeLayout;
import bfur;
import bfwv;
import bgve;
import bgvf;
import bgzq;
import bhht;
import bhwo;
import bibw;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.share.WXShareFromQZHelper.WXShareListener;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneAuthorizeConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneWebViewJsHandleLogic
{
  public static final String ACTION_PICK_GAME_MATES = "qzone.pickgamemates";
  private static final String JS_CALL_CARE_SPECIAL_FAMOUS_SPACE_METHOD = "UpdateFamousSpaceVpageOptions";
  public static final String STR_GAMEMATES = "gamemates";
  public static final String TAG = "QZoneWebViewJsHandleLogic";
  static String mShareMsgCallback;
  static CustomWebView webview;
  static WXShareFromQZHelper.WXShareListener wxShareListener = new QZoneWebViewJsHandleLogic.1();
  
  public static String appendQueryParameter(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    String str = paramString2 + '=';
    int i = paramString1.indexOf(str);
    int j;
    if (i != -1)
    {
      if (i == 0) {}
      do
      {
        i = paramString1.indexOf(str, str.length() + i);
        break;
        j = paramString1.charAt(i - 1);
      } while ((j != 63) && (j != 35) && (j != 38));
    }
    int k;
    if (i > -1)
    {
      k = i + str.length();
      j = k;
      if (j < paramString1.length())
      {
        int m = paramString1.charAt(j);
        if ((m != 38) && (m != 35)) {}
      }
      else
      {
        if ((!paramString2.equals("_wv")) || (i <= paramString1.indexOf('#'))) {
          break label188;
        }
        paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
      }
    }
    for (;;)
    {
      return paramString1;
      j += 1;
      break;
      label188:
      paramString1 = paramString1.substring(0, k) + paramString3 + paramString1.substring(j);
      continue;
      paramString1 = Uri.parse(paramString1).buildUpon().appendQueryParameter(paramString2, paramString3).toString();
    }
  }
  
  public static String appendWVParameter(String paramString, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        String str = Uri.parse(paramString).getQueryParameter("_wv");
        if (str == null) {
          return appendQueryParameter(paramString, "_wv", String.valueOf(paramInt));
        }
        if (paramBoolean)
        {
          str = appendQueryParameter(paramString, "_wv", String.valueOf(Integer.valueOf(str).intValue() | paramInt));
          return str;
        }
      }
      catch (Exception localException) {}
    }
    return paramString;
  }
  
  private static boolean checkScheme(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString).getScheme();
      if (("mqzone".equals(paramString)) || ("mqzonev2".equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean disPatchMethod(WebViewPlugin paramWebViewPlugin, bgve parambgve, String paramString, String... paramVarArgs)
  {
    if ("updateFeedContainer".equalsIgnoreCase(paramString)) {
      updateFeedContainer(parambgve, paramVarArgs);
    }
    do
    {
      return true;
      if ("SendGiftFinished".equalsIgnoreCase(paramString))
      {
        handleSendGift(parambgve, paramVarArgs);
        return true;
      }
      if ("sendGiftSuccess".equalsIgnoreCase(paramString))
      {
        handleSendGiftSuccess(parambgve, paramVarArgs);
        return true;
      }
      if ("openAppDetail".equalsIgnoreCase(paramString))
      {
        handleOpenAppDetail(parambgve, paramVarArgs);
        return true;
      }
      if ("Schema".equalsIgnoreCase(paramString))
      {
        handleSchema(paramWebViewPlugin, parambgve, paramVarArgs);
        return true;
      }
      if (!"refreshFeeds".equals(paramString)) {
        break;
      }
    } while (parambgve.a() == null);
    doRefreshFeed(parambgve.a());
    return true;
    if ("UpdateFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      handleCareSpecialFamousSpace(parambgve, paramVarArgs[0]);
      return true;
    }
    if ("clickWeiShiWidget".equalsIgnoreCase(paramString))
    {
      handleClickWeiShiWidget(parambgve, paramVarArgs);
      return true;
    }
    if ("showFamousSpaceVpageOptions".equalsIgnoreCase(paramString))
    {
      handleShowFollowActionSheet(parambgve, paramVarArgs);
      return true;
    }
    if ("updateNativeIsSpecialFollow".equalsIgnoreCase(paramString))
    {
      handleUpdateIsSpecialFollow(parambgve, paramVarArgs);
      return true;
    }
    if ("ShareToWXMiniProgram".equals(paramString))
    {
      shareMiniProgramFromQzone(parambgve, paramVarArgs);
      return true;
    }
    if ("pickGameMates".equals(paramString))
    {
      handleGameMates(parambgve, paramVarArgs);
      return true;
    }
    return false;
  }
  
  public static void doRefreshFeed(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SignInSbumited");
    if (paramActivity != null) {
      paramActivity.sendBroadcast(localIntent);
    }
  }
  
  private static void goToDownloadWeiShiApp(Context paramContext)
  {
    Intent localIntent;
    if (paramContext != null)
    {
      String str1 = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromMarket", "market://details?id=com.tencent.weishi");
      if (!TextUtils.isEmpty(str1))
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(str1));
        QZoneHelper.addSource(localIntent);
      }
    }
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      String str2;
      do
      {
        str2 = QzoneConfig.getInstance().getConfig("MiniVideo", "DownloadWeishiFromURL", "https://android.myapp.com/myapp/detail.htm?apkName=com.tencent.weishi");
      } while (TextUtils.isEmpty(str2));
      localIntent.setData(Uri.parse(str2));
      try
      {
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, "goToDownloadWeishi catch an exception.", paramContext);
      }
    }
  }
  
  /* Error */
  private static void handleCareSpecialFamousSpace(bgve parambgve, String paramString)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_0
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: new 274	org/json/JSONObject
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 275	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: aload 5
    //   19: ldc_w 277
    //   22: invokevirtual 280	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   25: istore_2
    //   26: aload 5
    //   28: ldc_w 282
    //   31: invokevirtual 285	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore_1
    //   35: aload 5
    //   37: ldc_w 287
    //   40: invokevirtual 280	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   43: istore 4
    //   45: iload 4
    //   47: istore_3
    //   48: new 211	android/content/Intent
    //   51: dup
    //   52: invokespecial 212	android/content/Intent:<init>	()V
    //   55: astore 5
    //   57: aload 5
    //   59: ldc_w 289
    //   62: invokevirtual 218	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   65: pop
    //   66: aload 5
    //   68: ldc_w 277
    //   71: iload_2
    //   72: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   75: pop
    //   76: aload 5
    //   78: ldc_w 282
    //   81: aload_1
    //   82: invokestatic 299	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   85: invokevirtual 302	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   88: pop
    //   89: aload 5
    //   91: ldc_w 304
    //   94: ldc_w 306
    //   97: invokevirtual 309	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   100: pop
    //   101: aload 5
    //   103: ldc_w 287
    //   106: iload_3
    //   107: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   110: pop
    //   111: aload_0
    //   112: invokevirtual 176	bgve:a	()Landroid/app/Activity;
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull -111 -> 6
    //   120: aload_0
    //   121: aload 5
    //   123: invokevirtual 224	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   126: return
    //   127: astore 5
    //   129: ldc_w 311
    //   132: astore_1
    //   133: iconst_m1
    //   134: istore_2
    //   135: aload 5
    //   137: invokevirtual 314	org/json/JSONException:printStackTrace	()V
    //   140: goto -92 -> 48
    //   143: astore 5
    //   145: ldc_w 311
    //   148: astore_1
    //   149: goto -14 -> 135
    //   152: astore 5
    //   154: goto -19 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	parambgve	bgve
    //   0	157	1	paramString	String
    //   25	110	2	i	int
    //   1	106	3	j	int
    //   43	3	4	k	int
    //   15	107	5	localObject	Object
    //   127	9	5	localJSONException1	JSONException
    //   143	1	5	localJSONException2	JSONException
    //   152	1	5	localJSONException3	JSONException
    // Exception table:
    //   from	to	target	type
    //   7	26	127	org/json/JSONException
    //   26	35	143	org/json/JSONException
    //   35	45	152	org/json/JSONException
  }
  
  private static void handleClickWeiShiWidget(bgve parambgve, String... paramVarArgs)
  {
    Activity localActivity;
    if ((parambgve != null) && (parambgve.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localActivity = parambgve.a();
      if (bfwv.a(localActivity, "com.tencent.weishi"))
      {
        parambgve = "";
        try
        {
          paramVarArgs = new JSONObject(paramVarArgs[0]).optString("schema");
          parambgve = paramVarArgs;
          if (!TextUtils.isEmpty(paramVarArgs))
          {
            parambgve = paramVarArgs;
            Intent localIntent = new Intent();
            parambgve = paramVarArgs;
            localIntent.setAction("android.intent.action.VIEW");
            parambgve = paramVarArgs;
            localIntent.setData(Uri.parse(paramVarArgs));
            parambgve = paramVarArgs;
            QZoneHelper.addSource(localIntent);
            parambgve = paramVarArgs;
            List localList = localActivity.getPackageManager().queryIntentActivities(localIntent, 65536);
            if (localList == null) {
              break label177;
            }
            parambgve = paramVarArgs;
            if (localList.size() <= 0) {
              break label177;
            }
            parambgve = paramVarArgs;
            localActivity.startActivity(localIntent);
          }
          for (;;)
          {
            parambgve = paramVarArgs;
            if (!QLog.isColorLevel()) {
              break;
            }
            parambgve = paramVarArgs;
            QLog.d("QZoneWebViewJsHandleLogic", 1, "weishi schema is " + paramVarArgs);
            return;
            label177:
            parambgve = paramVarArgs;
            goToDownloadWeiShiApp(localActivity);
          }
          goToDownloadWeiShiApp(localActivity);
        }
        catch (Exception paramVarArgs)
        {
          QLog.e("QZoneWebViewJsHandleLogic", 1, "handleClickWeiShiWidget catch an exception. weishi schema is " + parambgve, paramVarArgs);
          return;
        }
      }
    }
  }
  
  private static void handleGameMates(bgve parambgve, String... paramVarArgs)
  {
    if ((parambgve != null) && (parambgve.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      parambgve = new Intent("qzone.pickgamemates");
      parambgve.putExtra("gamemates", paramVarArgs[0]);
      BaseApplicationImpl.getApplication().sendBroadcast(parambgve);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "handleGameMates = " + paramVarArgs[0]);
      }
    }
  }
  
  private static void handleOpenAppDetail(bgve parambgve, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject2).getString("packName");
        Object localObject1 = ((JSONObject)localObject2).getString("taskAppId");
        String str1 = ((JSONObject)localObject2).getString("appId");
        String str2 = ((JSONObject)localObject2).getString("taskApkId");
        String str3 = ((JSONObject)localObject2).getString("via");
        String str4 = ((JSONObject)localObject2).getString("versionCode");
        String str5 = ((JSONObject)localObject2).getString("channel");
        localObject2 = ((JSONObject)localObject2).getString("from");
        int j = 3;
        int i = j;
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            i = Integer.parseInt((String)localObject2);
          }
          localObject2 = new StringBuilder();
          if (!TextUtils.isEmpty(str1)) {
            ((StringBuilder)localObject2).append(bibw.b).append("=").append(str1);
          }
          if (!TextUtils.isEmpty(paramVarArgs)) {
            ((StringBuilder)localObject2).append("&").append(bibw.f).append("=").append(paramVarArgs);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ((StringBuilder)localObject2).append("&").append(bibw.c).append("=").append((String)localObject1);
          }
          if (!TextUtils.isEmpty(str2)) {
            ((StringBuilder)localObject2).append("&").append(bibw.d).append("=").append(str2);
          }
          if (!TextUtils.isEmpty(str3)) {
            ((StringBuilder)localObject2).append("&").append(bibw.i).append("=").append(str3);
          }
          if (!TextUtils.isEmpty(str4)) {
            ((StringBuilder)localObject2).append("&").append(bibw.e).append("=").append(str4);
          }
          if (!TextUtils.isEmpty(str5)) {
            ((StringBuilder)localObject2).append("&").append(bibw.B).append("=").append(str5);
          }
          paramVarArgs = ((StringBuilder)localObject2).toString();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("from", i);
          ((Bundle)localObject1).putString("schemaUrl", paramVarArgs);
          QZoneHelper.addSource((Bundle)localObject1);
          bhwo.a(parambgve.a(), (Bundle)localObject1);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.e("QZoneWebViewJsHandleLogic", 2, "from 错误", localNumberFormatException);
              i = j;
            }
          }
        }
        return;
      }
      catch (JSONException parambgve)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZoneWebViewJsHandleLogic", 2, "json 解析异常", parambgve);
        }
      }
    }
  }
  
  private static void handlePublishMoodSilently(bgve parambgve, String[] paramArrayOfString)
  {
    if ((parambgve != null) && (parambgve.a() != null) && (paramArrayOfString != null) && (paramArrayOfString.length > 0)) {}
    try
    {
      Object localObject3 = new JSONObject(paramArrayOfString[0]);
      String str2 = (String)((JSONObject)localObject3).opt("content");
      String str1 = (String)((JSONObject)localObject3).opt("videoPath");
      int j = ((JSONObject)localObject3).optInt("issynctoweibo");
      paramArrayOfString = ((JSONObject)localObject3).getJSONObject("lbsinfo");
      if (paramArrayOfString != null)
      {
        paramArrayOfString.optDouble("lbs_x");
        paramArrayOfString.optDouble("lbs_y");
        paramArrayOfString.optInt("lbs_type");
        paramArrayOfString.optString("lbs_nm");
        throw new NullPointerException();
      }
      paramArrayOfString = null;
      Object localObject1 = ((JSONObject)localObject3).getJSONObject("source");
      if (localObject1 != null) {
        paramArrayOfString = ((JSONObject)localObject1).optString("subtype");
      }
      HashMap localHashMap = new HashMap();
      Object localObject2 = ((JSONObject)localObject3).getJSONObject("extend_info");
      int i;
      if (localObject2 != null)
      {
        localObject1 = ((JSONObject)localObject2).optString("checkinfall");
        i = ((JSONObject)localObject2).optInt("comm_self_define_tail_id");
        localHashMap.put("checkinfall", localObject1);
        localHashMap.put("comm_self_define_tail_id", String.valueOf(i));
      }
      ArrayList localArrayList = new ArrayList();
      localObject1 = null;
      Object localObject4 = ((JSONObject)localObject3).getJSONObject("right_info");
      if (localObject4 != null)
      {
        localObject2 = ((JSONObject)localObject4).optString("ugc_right");
        localObject4 = ((JSONObject)localObject4).optJSONArray("allow_uins");
        localObject1 = localObject2;
        if (localObject4 != null)
        {
          i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= ((JSONArray)localObject4).length()) {
              break;
            }
            localArrayList.add((String)((JSONArray)localObject4).get(i));
            i += 1;
          }
        }
      }
      localObject2 = new HashMap();
      localObject3 = ((JSONObject)localObject3).getJSONObject("stored_extend_info");
      if (localObject3 != null) {
        ((HashMap)localObject2).put("event_tags", ((JSONObject)localObject3).optString("event_tags"));
      }
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).add(str1);
      QZoneHelper.UserInfo.getInstance().qzone_uin = parambgve.a().getCurrentAccountUin();
      QZoneHelper.publishPictureMoodSilently(str2, (ArrayList)localObject3, j, null, paramArrayOfString, (String)localObject1, localArrayList, (HashMap)localObject2, localHashMap, "value.videoSign", 2);
      return;
    }
    catch (Exception parambgve)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QZoneWebViewJsHandleLogic", 2, "handlePickQzoneAlbum,decode param error");
    }
  }
  
  private static void handleSchema(WebViewPlugin paramWebViewPlugin, bgve parambgve, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (parambgve == null) || (paramVarArgs.length <= 0)) {}
    Object localObject5;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    int i;
    label398:
    label718:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject5 = new JSONObject(paramVarArgs[0]);
              localObject1 = ((JSONObject)localObject5).optString("schema");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              paramVarArgs = parambgve.a().getUrl();
              if (!QzoneAuthorizeConfig.getInstance().hasJsApiRight(paramVarArgs, (String)localObject1))
              {
                QLog.e("QZoneWebViewJsHandleLogic", 1, "has no right handle this jsapi");
                return;
              }
            }
            catch (JSONException paramWebViewPlugin)
            {
              paramWebViewPlugin.printStackTrace();
              QLog.e("QZoneWebViewJsHandleLogic", 1, "handleSchema", paramWebViewPlugin);
              return;
            }
            paramVarArgs = ((JSONObject)localObject5).optJSONObject("dealparam");
            if (paramVarArgs == null) {
              break label1100;
            }
            localObject2 = paramVarArgs.optString("url");
            paramVarArgs = paramVarArgs.optString("blogurl", "");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
              break label1085;
            }
            localObject3 = (String)localObject1 + "&url=" + (String)localObject2;
            localObject1 = localObject2;
            localObject2 = localObject3;
            if (QLog.isColorLevel()) {
              QLog.d("QZoneWebViewPlugin", 2, " handleSchema scheme:" + (String)localObject2);
            }
            localObject4 = null;
            if (parambgve != null) {
              localObject4 = parambgve.a();
            }
            localObject3 = localObject4;
            if (localObject4 != null)
            {
              localObject3 = localObject4;
              if ((localObject4 instanceof BasePluginActivity)) {
                localObject3 = ((BasePluginActivity)localObject4).getOutActivity();
              }
            }
            localObject4 = localObject3;
            if (localObject3 != null)
            {
              localObject4 = localObject3;
              if ((localObject3 instanceof BasePluginActivity)) {
                localObject4 = ((BasePluginActivity)localObject3).getOutActivity();
              }
            }
            bool = ((String)localObject2).startsWith("mqzone://arouse/userhome");
            if (bool)
            {
              if (localObject4 == null) {
                continue;
              }
              try
              {
                if (((String)localObject2).indexOf("uin=") != -1)
                {
                  paramWebViewPlugin = ((String)localObject2).substring(((String)localObject2).indexOf("uin=") + 4, ((String)localObject2).length());
                  QZoneHelper.forwardToUserHome((Context)localObject4, QZoneHelper.UserInfo.getInstance(), paramWebViewPlugin, 0, 0, 0);
                  return;
                }
              }
              catch (Exception paramWebViewPlugin)
              {
                paramWebViewPlugin.printStackTrace();
                return;
              }
            }
          }
          if (!((String)localObject2).startsWith("mqzone://arouse/webtofeeddetail")) {
            break;
          }
        } while (localObject4 == null);
        parambgve = parambgve.a((Activity)localObject4);
        if (!(parambgve instanceof bgvf)) {
          break label1116;
        }
        i = ((bgvf)parambgve).switchRequestCode(paramWebViewPlugin, (byte)3);
        if (TextUtils.isEmpty(paramVarArgs))
        {
          QZoneHelper.forwardToDetail((Activity)localObject4, QZoneHelper.UserInfo.getInstance(), (String)localObject1, i);
          return;
        }
        QZoneHelper.forwardToDetail((Activity)localObject4, QZoneHelper.UserInfo.getInstance(), (String)localObject1, i, paramVarArgs);
        return;
        if (!((String)localObject2).startsWith("mqzone://arouse/detail")) {
          break;
        }
      } while (localObject4 == null);
      paramVarArgs = Uri.parse((String)localObject2);
      localObject1 = paramVarArgs.getQueryParameter("uin");
      localObject2 = paramVarArgs.getQueryParameter("appid");
      localObject3 = paramVarArgs.getQueryParameter("cellid");
      localObject5 = paramVarArgs.getQueryParameter("subid");
      Object localObject6 = paramVarArgs.getQueryParameter("source");
      String str1 = paramVarArgs.getQueryParameter("cookie");
      String str2 = paramVarArgs.getQueryParameter("local_city_feedindex");
      String str3 = paramVarArgs.getQueryParameter("ugckey");
      String str4 = paramVarArgs.getQueryParameter("feedData");
      String str5 = paramVarArgs.getQueryParameter("needShowBottom");
      String str6 = paramVarArgs.getQueryParameter("urlForTodayInHistory");
      String str7 = paramVarArgs.getQueryParameter("buttonText");
      Bundle localBundle = new Bundle();
      if (localObject6 != null) {
        localBundle.putString("source", (String)localObject6);
      }
      if (str1 != null) {
        localBundle.putString("cookie", str1);
      }
      if (str2 != null) {
        localBundle.putString("local_city_feedindex", str2);
      }
      if (str3 != null) {
        localBundle.putString("ugckey", str3);
      }
      if (str4 != null) {
        localBundle.putString("local_city_feedData", str4);
      }
      if (str5 != null) {
        localBundle.putString("show_share_btn", str5);
      }
      if (str6 != null) {
        localBundle.putString("share_url", str6);
      }
      if (str7 != null) {
        localBundle.putString("share_btn_text", str7);
      }
      localObject6 = parambgve.a((Activity)localObject4);
      if (!(localObject6 instanceof bgvf)) {
        break label1121;
      }
      i = ((bgvf)localObject6).switchRequestCode(paramWebViewPlugin, (byte)3);
      paramWebViewPlugin = QZoneHelper.UserInfo.getInstance();
      paramWebViewPlugin.qzone_uin = parambgve.a().getAccount();
      parambgve = new Bundle();
      parambgve.putString("source", paramVarArgs.getQueryParameter("source"));
      parambgve.putString("bypassparam", paramVarArgs.getQueryParameter("bypassparam"));
      parambgve.putAll(localBundle);
      QZoneHelper.forwardToDetail((Activity)localObject4, paramWebViewPlugin, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject5, i, parambgve);
      return;
      if (!"mqzone://arouse/dynamicnickname".equalsIgnoreCase((String)localObject2)) {
        break;
      }
    } while ((parambgve == null) || (parambgve.a() == null) || (parambgve.a() == null));
    QZoneHelper.forwardToQZoneFlashNickNameSetting(parambgve.a(), parambgve.a().getAccount());
    return;
    if (((String)localObject2).startsWith("mqzone://arouse/uploadphoto"))
    {
      QZoneHelper.forwardToUploadPhoto(paramWebViewPlugin, parambgve, parambgve.a(), parambgve.a().getAccount(), (String)localObject2);
      return;
    }
    if ((((String)localObject2).startsWith("mqzone://arouse/facade")) || (((String)localObject2).startsWith("mqzonev2://arouse/facade")))
    {
      jumpQzoneScheme(parambgve.a(), (String)localObject2, 81, parambgve);
      return;
    }
    if (((String)localObject2).startsWith("mqzone://arouse/moodVoiceRecord"))
    {
      QZoneHelper.forwardToOpenRecordPanel(paramWebViewPlugin, parambgve, parambgve.a(), parambgve.a().getAccount(), (String)localObject2);
      return;
    }
    paramVarArgs = new Intent("action_js2qzone");
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("cmd", "Schema");
    ((Bundle)localObject1).putString("schema", (String)localObject2);
    if (((JSONObject)localObject5).optInt("showQzoneProgressDialog", 1) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramVarArgs.putExtras((Bundle)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "handleSchema actionString: " + paramVarArgs.getAction() + "scheme:" + (String)localObject2);
      }
      if (((String)localObject2).startsWith("mqzone://arouse/openvideolayer"))
      {
        i = QZoneWebViewPlugin.generateRequestCode(paramWebViewPlugin, parambgve, 4);
        QZoneHelper.forwardToQzoneTransluentActivity((Activity)localObject4, QZoneHelper.UserInfo.getInstance(), paramVarArgs, i, bool);
        return;
      }
      QZoneHelper.forwardToQzoneTransluentActivity((Activity)localObject4, QZoneHelper.UserInfo.getInstance(), paramVarArgs, -1, bool);
      return;
      label1085:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      label1100:
      localObject3 = null;
      localObject2 = localObject1;
      paramVarArgs = null;
      localObject1 = localObject3;
      break;
      label1116:
      i = 3;
      break label398;
      label1121:
      i = 3;
      break label718;
    }
  }
  
  private static void handleSendGift(bgve parambgve, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
        if (((JSONObject)localObject).getInt("success") == 1)
        {
          paramVarArgs = ((JSONObject)localObject).getJSONArray("uins");
          JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("birthdays");
          String str = ((JSONObject)localObject).getString("giftmessage");
          int j = ((JSONObject)localObject).optInt("giftid");
          if ((paramVarArgs != null) && (paramVarArgs.length() > 0) && (localJSONArray != null) && (localJSONArray.length() == paramVarArgs.length()))
          {
            if ((((JSONObject)localObject).has("toast")) && (((JSONObject)localObject).getBoolean("toast"))) {
              QQToast.a(parambgve.a(), 2, 2131689525, 0).a();
            }
            localObject = new long[paramVarArgs.length()];
            long[] arrayOfLong = new long[localJSONArray.length()];
            int i = 0;
            while (i < paramVarArgs.length())
            {
              localObject[i] = paramVarArgs.getLong(i);
              arrayOfLong[i] = localJSONArray.getLong(i);
              i += 1;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("key_msg_type", 2);
            localIntent.putExtra("key_friend_list", (long[])localObject);
            localIntent.putExtra("key_time_list", arrayOfLong);
            localIntent.putExtra("key_msg_content", str);
            localIntent.putExtra("key_gift_id", j);
            parambgve.a().setResult(-1, localIntent);
            parambgve.a().finish();
            if (QLog.isColorLevel())
            {
              QLog.d("QZoneWebViewJsHandleLogic", 2, "the giftid is " + j + "\n the giftmessage is" + str + "\n the uins are: " + paramVarArgs.toString() + "\n the birthdays are: " + localJSONArray.toString());
              return;
            }
          }
        }
      }
      catch (JSONException parambgve)
      {
        QLog.e("QZoneWebViewJsHandleLogic", 1, parambgve, new Object[0]);
      }
    }
  }
  
  private static void handleSendGiftSuccess(bgve parambgve, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      return;
    }
    try
    {
      LocalMultiProcConfig.putString("BirthdayGiftSendSuccessList", new JSONObject(paramVarArgs[0]).optString("uins"));
      return;
    }
    catch (JSONException parambgve)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, parambgve, new Object[0]);
    }
  }
  
  private static void handleShowFollowActionSheet(bgve parambgve, String... paramVarArgs)
  {
    if ((parambgve != null) && (parambgve.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      int i = new JSONObject(paramVarArgs[0]).optInt("followStatus");
      parambgve = new Intent("showFollowActionSheet");
      parambgve.putExtra("followStatus", i);
      BaseApplicationImpl.getApplication().sendBroadcast(parambgve);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "followStatus = " + i);
      }
      return;
    }
    catch (Exception parambgve)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, "handleShowFollowActionSheet catch an exception. ", parambgve);
    }
  }
  
  private static void handleUpdateIsSpecialFollow(bgve parambgve, String... paramVarArgs)
  {
    if ((parambgve != null) && (parambgve.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      int i = new JSONObject(paramVarArgs[0]).optInt("isSpecialFollow", -1);
      parambgve = new Intent("updateIsSpecialFollow");
      parambgve.putExtra("isSpecialFollow", i);
      BaseApplicationImpl.getApplication().sendBroadcast(parambgve);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewJsHandleLogic", 1, "followStatus = " + i);
      }
      return;
    }
    catch (Exception parambgve)
    {
      QLog.e("QZoneWebViewJsHandleLogic", 1, "handleUpdateIsSpecialFollow catch an exception. ", parambgve);
    }
  }
  
  static void handleUrl(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("handleUrl", 2, "browse url fail:" + paramString);
      }
    }
    do
    {
      return;
      paramString = appendWVParameter(paramString, 7, false);
      Intent localIntent = new Intent(BaseApplication.getContext(), QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("fromQZone", true);
      localIntent.putExtra("injectrecommend", true);
      localIntent.setData(Uri.parse(paramString));
      localIntent.addFlags(268435456);
      localIntent.putExtra("source_name", BaseApplicationImpl.getContext().getString(2131716848));
      paramContext.startActivity(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("handleurl", 2, "jump to browser: " + paramString);
  }
  
  private static int jumpQzoneScheme(Context paramContext, String paramString, int paramInt, bgve parambgve)
  {
    int i = 2;
    if (paramContext == null) {
      return 5;
    }
    if (checkScheme(paramString)) {
      if (supportJumpToQzone(paramContext, paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "simpleSchemeJump");
        }
        simpleSchemeJump(paramContext, Uri.parse(paramString));
        paramInt = 1;
      }
    }
    for (;;)
    {
      return paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneWebViewPlugin", 2, "showQzoneAppDownloadDialog");
      }
      showQzoneAppDownloadDialog(paramContext, parambgve);
      paramInt = i;
      continue;
      if (URLUtil.isNetworkUrl(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QZoneWebViewPlugin", 2, "isNetworkUrl do nothing");
        }
        paramInt = 5;
      }
      else
      {
        paramInt = 5;
      }
    }
  }
  
  static void shareMiniProgramFromQzone(bgve parambgve, String... paramVarArgs)
  {
    if ((parambgve != null) && (parambgve.a() != null) && (paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject1 = parambgve.a(parambgve.a());
        if ((localObject1 != null) && ((localObject1 instanceof bgzq)))
        {
          localObject1 = ((bgzq)localObject1).getShare().a();
          if ((localObject1 != null) && (((bhht)localObject1).isShowing())) {
            ((bhht)localObject1).dismiss();
          }
        }
        webview = parambgve.a();
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        mShareMsgCallback = ((JSONObject)localObject2).optString("callback");
        paramVarArgs = ((JSONObject)localObject2).optString("webpageUrl");
        ((JSONObject)localObject2).optInt("miniprogramType");
        localObject1 = ((JSONObject)localObject2).optString("userName");
        String str1 = ((JSONObject)localObject2).optString("path");
        String str2 = ((JSONObject)localObject2).optString("title");
        String str3 = ((JSONObject)localObject2).optString("description");
        localObject2 = ((JSONObject)localObject2).optString("picUrl");
        HashMap localHashMap = new HashMap(1);
        paramVarArgs = new QZoneWebViewJsHandleLogic.2(parambgve, localHashMap, str2, str3, paramVarArgs, str1, (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramVarArgs.run();
          return;
        }
        ThreadManager.post(new QZoneWebViewJsHandleLogic.3((String)localObject2, localHashMap, parambgve, paramVarArgs), 8, null, false);
        return;
      }
      catch (Exception parambgve)
      {
        QZLog.e("QZoneWebViewJsHandleLogic", "shareMiniProgramFromQzone error", parambgve);
      }
    }
  }
  
  public static void showQzoneAppDownloadDialog(Context paramContext, bgve parambgve)
  {
    parambgve = bfur.a(paramContext, 0);
    parambgve.setMessage(paramContext.getString(2131718951));
    parambgve.setPositiveButton(paramContext.getString(2131691695), new QZoneWebViewJsHandleLogic.4(paramContext));
    parambgve.setNegativeButton(paramContext.getString(2131693011), new QZoneWebViewJsHandleLogic.5(parambgve));
    try
    {
      if (!parambgve.isShowing()) {
        parambgve.show();
      }
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("showQzoneAppDownloadDialog", 2, "mDialog.show() exception", paramContext);
    }
  }
  
  static void simpleSchemeJump(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent();
    localIntent.setData(paramUri);
    localIntent.setPackage("com.qzone");
    paramContext.startActivity(localIntent);
  }
  
  public static boolean supportJumpToQzone(Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo("com.qzone", 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.versionCode >= paramInt) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  private static void updateFeedContainer(bgve parambgve, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (new JSONObject(paramVarArgs[0]).getInt("height") <= 0)
          {
            if (!(parambgve.a().getParent() instanceof RelativeLayout)) {
              continue;
            }
            ((RelativeLayout)parambgve.a().getParent()).setVisibility(8);
          }
        }
        catch (JSONException parambgve)
        {
          QLog.e("QZoneWebViewJsHandleLogic", 1, parambgve, new Object[0]);
          return;
        }
      }
    } while (!(parambgve.a().getParent() instanceof RelativeLayout));
    ((RelativeLayout)parambgve.a().getParent()).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic
 * JD-Core Version:    0.7.0.1
 */