package com.tencent.mobileqq.weather.webpage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.temp.api.IArkMessage;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.weather.util.WeatherHelper;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WeatherWebPageHelper;", "", "()V", "AD_CODE_KEY", "", "AD_CODE_VALUE_EMPTY", "AREA_ID_VALUE_EMPTY", "AUTHOR_STATUS_DENIED", "", "AUTHOR_STATUS_GRANTED", "BASE_URL", "BUSINESS_ID_KEY", "FRAGMENT_CLASS", "KEY_IS_TRANSPARENT_TITLE", "KEY_URL_NOT_SHORT", "REPORT_ACTION_OPEN_WEB_EXT3_VERSION", "SCENE_KEY", "SCENE_VALUE_DRAWER", "SCENE_VALUE_SHARE", "TAG", "VALUE_URL_NOT_SHORT", "WEATHER_ARK_DEFAULT_HEIGHT", "WEATHER_ARK_MIN_VERSION", "WEATHER_ARK_NAME", "WEATHER_ARK_NO_PULL_MATE", "WEATHER_ARK_VIEW", "WEATHER_GDT_BIZ_ID", "WEATHER_SCHEME_HEAD", "encodedDeviceInfo", "addPermissionStatus", "", "context", "Landroid/content/Context;", "waterfallArk", "Lcom/tencent/mobileqq/weather/webpage/WaterfallArk;", "asyncInitGdtDeviceInfo", "buildDrawerArk", "areaId", "buildNoPushWaterArk", "adCode", "buildShareWaterFallArk", "messageArk", "shareUrl", "checkShareUrlIsError", "", "clearUnRead", "accountUin", "app", "Lcom/tencent/common/app/AppInterface;", "getAdCodeFromArkAppMessage", "ark", "getDrawerWeatherWebUrl", "height", "getGdtDeviceInfoBase64", "getLastUnreadWaterfallArk", "Lcom/tencent/mobileqq/ark/temp/api/IArkMessage;", "getShareWeatherWebUrl", "getWaterFallArkFromChatMessage", "arkMessage", "getWeatherWebUrl", "hasFollowWeather", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isFollow", "hideRedPointIfRequested", "record", "Lcom/tencent/mobileqq/data/MessageRecord;", "isNewWeatherPushMsg", "mr", "Lcom/tencent/mobileqq/persistence/Entity;", "openWeatherByScheme", "scheme", "openWeatherWebPage", "businessId", "reportClickPublicAccountEvent", "publicAccountUin", "mainActionType", "subActionType", "actinType", "startNewWeatherWebPageActivity", "isShare", "isFromDrawer", "drawerAreaId", "startNewWeatherWebPageActivityByFollowState", "from", "url", "startWeatherWebPageActivity", "transformUrlToScheme", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebPageHelper
{
  public static final WeatherWebPageHelper a;
  private static String a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper = new WeatherWebPageHelper();
  }
  
  private final IArkMessage a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return null;
    }
    List localList = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).getAIOList("2658655094", 1008);
    int i = localList.size() - 1;
    while (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      paramAppInterface = localMessageRecord;
      if ((localMessageRecord instanceof Message)) {
        paramAppInterface = ((Message)localMessageRecord).lastMsg;
      }
      if ((paramAppInterface instanceof IArkMessage)) {
        return (IArkMessage)paramAppInterface;
      }
      i -= 1;
    }
    return null;
  }
  
  private final WaterfallArk a(IArkMessage paramIArkMessage)
  {
    try
    {
      if (!TextUtils.isEmpty((CharSequence)paramIArkMessage.getMetaList()))
      {
        Object localObject = new JSONObject(paramIArkMessage.getMetaList()).optJSONObject("weather").optJSONObject("waterfall_ark");
        paramIArkMessage = ((JSONObject)localObject).optString("app");
        String str1 = ((JSONObject)localObject).optString("meta");
        String str2 = ((JSONObject)localObject).optString("view");
        localObject = ((JSONObject)localObject).optString("ver");
        Intrinsics.checkExpressionValueIsNotNull(paramIArkMessage, "app");
        Intrinsics.checkExpressionValueIsNotNull(str1, "meta");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ver");
        Intrinsics.checkExpressionValueIsNotNull(str2, "view");
        paramIArkMessage = new WaterfallArk(paramIArkMessage, str1, (String)localObject, str2);
        return paramIArkMessage;
      }
    }
    catch (Throwable paramIArkMessage)
    {
      QLog.d("WeatherWebPageHelper", 1, paramIArkMessage, new Object[0]);
    }
    return null;
  }
  
  @JvmStatic
  @Nullable
  public static final WaterfallArk a(@Nullable WaterfallArk paramWaterfallArk, @Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("WeatherWebPageHelper", 1, "buildShareWaterFallArk shareUrl == null");
      return paramWaterfallArk;
    }
    Object localObject1 = URLUtil.a(paramString);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "URLUtil.getArgumentsFromURL(shareUrl)");
    String str = (String)((Map)localObject1).get("adcode");
    if (str == null) {
      str = "";
    }
    localObject1 = (String)((Map)localObject1).get("scene");
    if (localObject1 == null) {
      localObject1 = "1";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{\"qq_weather\": {\"adcode\": ");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(",\"scene\": ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("}}");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildShareWaterFallArk shareUrl == ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" adcode = ");
    localStringBuilder.append(str);
    localStringBuilder.append(" scene = ");
    localStringBuilder.append((String)localObject1);
    QLog.i("WeatherWebPageHelper", 1, localStringBuilder.toString());
    if (paramWaterfallArk == null) {
      return new WaterfallArk("com.tencent.weather_v2", (String)localObject2, "1.0.0.1", "qq_weather");
    }
    paramWaterfallArk.a((String)localObject2);
    return paramWaterfallArk;
  }
  
  @JvmStatic
  @Nullable
  public static final String a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gdt device info for weather 2.0 retrieved: ");
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      QLog.d("WeatherWebPageHelper", 2, localStringBuilder.toString());
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  private final String a(WaterfallArk paramWaterfallArk)
  {
    try
    {
      paramWaterfallArk = new JSONObject(paramWaterfallArk.b()).optJSONObject("qq_weather").optString("adcode", "");
      Intrinsics.checkExpressionValueIsNotNull(paramWaterfallArk, "weather.optString(\"adcode\", \"\")");
      return paramWaterfallArk;
    }
    catch (Throwable paramWaterfallArk)
    {
      QLog.d("WeatherWebPageHelper", 1, paramWaterfallArk, new Object[0]);
    }
    return "";
  }
  
  @JvmStatic
  @Nullable
  public static final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqqapi://forward/url?src_type=web&version=1&url_prefix=");
      Charset localCharset = Charset.forName("UTF-8");
      Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(charsetName)");
      paramString = paramString.getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      paramString = Base64Util.encode(paramString, 0);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "Base64Util.encode(url.to…8\")), Base64Util.DEFAULT)");
      localStringBuilder.append(new String(paramString, Charsets.UTF_8));
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.i("WeatherWebPageHelper", 1, "transFormUrlToScheme", paramString);
    }
    return null;
  }
  
  @JvmStatic
  public static final void a()
  {
    ThreadManager.getSubThreadHandler().post((Runnable)WeatherWebPageHelper.asyncInitGdtDeviceInfo.1.a);
  }
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext, @NotNull AppInterface paramAppInterface, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper.a(paramAppInterface, (Function1)new WeatherWebPageHelper.startNewWeatherWebPageActivityByFollowState.1(paramContext, paramAppInterface, paramInt, paramString));
  }
  
  private final void a(Context paramContext, WaterfallArk paramWaterfallArk)
  {
    int i;
    if (WeatherHelper.a(paramContext)) {
      i = 1;
    } else {
      i = 2;
    }
    paramContext = new JSONObject(paramWaterfallArk.b());
    paramContext.put("qq_weather", paramContext.optJSONObject("qq_weather").put("author_status", i));
    paramContext = paramContext.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "appMetaObj.toString()");
    paramWaterfallArk.a(paramContext);
  }
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "scheme");
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.setData(Uri.parse(paramString));
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    paramContext.startActivity(localIntent);
  }
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "adCode");
    Intrinsics.checkParameterIsNotNull(paramString2, "businessId");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("openWeatherWebPage: adcode, ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", businessId, ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("WeatherWebPageHelper", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = a(jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper, paramString1, 0, 2, null);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("{\"qq_weather\": {\"adcode\": ");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(",\"scene\": 1}}");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = QRoute.api(IWebProcessPreload.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "QRoute.api(IWebProcessPreload::class.java)");
    boolean bool = ((IWebProcessPreload)localObject3).isWebProcessExist();
    paramContext = new ActivityURIRequest(paramContext, "/base/browser");
    localObject3 = paramContext.extra();
    ((Bundle)localObject3).putString("url", (String)localObject1);
    ((Bundle)localObject3).putBoolean("isTransparentTitle", true);
    ((Bundle)localObject3).putString("fragment_class", WeatherWebViewFragment.class.getName());
    ((Bundle)localObject3).putString("appName", "com.tencent.weather_v2");
    ((Bundle)localObject3).putString("appView", "qq_weather");
    ((Bundle)localObject3).putString("appVersion", "1.0.0.1");
    ((Bundle)localObject3).putString("appMeta", (String)localObject2);
    ((Bundle)localObject3).putString("adCode", paramString1);
    ((Bundle)localObject3).putLong("start_click_time", System.currentTimeMillis());
    ((Bundle)localObject3).putBoolean("webProcessExist", bool);
    ((Bundle)localObject3).putBoolean("is_from_share", true);
    ((Bundle)localObject3).putBoolean("is_to_ark", true);
    ((Bundle)localObject3).putString("big_brother_source_key", "biz_src_gzh_weather");
    QRoute.startUri((URIRequest)paramContext, null);
    WeatherDCReportHelper.a().a(MobileQQ.sMobileQQ.waitAppRuntime(null), "new_folder_apicall", new String[] { "AND", "", paramString2 });
  }
  
  private final void a(AppInterface paramAppInterface, Function1<? super Integer, Unit> paramFunction1)
  {
    paramAppInterface = paramAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "app.getRuntimeService(IP…ava, ProcessConstant.ALL)");
    paramAppInterface = (IPublicAccountDataManager)paramAppInterface;
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = paramAppInterface.findAccountDetailInfoCache("2658655094");
    if ((IPublicAccountDetail)localObjectRef.element == null)
    {
      ThreadManager.excute((Runnable)new WeatherWebPageHelper.hasFollowWeather.1(localObjectRef, paramAppInterface, paramFunction1), 32, null, true);
      return;
    }
    paramAppInterface = (IPublicAccountDetail)localObjectRef.element;
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "accountDetail");
    if (paramAppInterface.getFollowType() == 1)
    {
      paramFunction1.invoke(Integer.valueOf(1));
      return;
    }
    paramFunction1.invoke(Integer.valueOf(2));
  }
  
  @JvmStatic
  public static final void a(@NotNull MessageRecord paramMessageRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "record");
    if ((paramMessageRecord instanceof IArkMessage))
    {
      Object localObject1 = jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper.a((IArkMessage)paramMessageRecord);
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((WaterfallArk)localObject1).b();
      } else {
        localObject1 = null;
      }
      JSONObject localJSONObject = new JSONObject((String)localObject1).optJSONObject("qq_weather");
      localObject1 = localObject2;
      if (localJSONObject != null) {
        localObject1 = Boolean.valueOf(localJSONObject.optBoolean("hide_red_point"));
      }
      boolean bool;
      if (localObject1 != null) {
        bool = ((Boolean)localObject1).booleanValue();
      } else {
        bool = false;
      }
      if (bool) {
        paramMessageRecord.isread = true;
      }
    }
  }
  
  private final void a(String paramString, AppInterface paramAppInterface)
  {
    if (paramString != null) {
      try
      {
        paramString = (BaseQQAppInterface)null;
        if ((paramAppInterface instanceof BaseQQAppInterface))
        {
          paramString = (BaseQQAppInterface)paramAppInterface;
        }
        else
        {
          paramAppInterface = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if ((paramAppInterface instanceof BaseQQAppInterface)) {
            paramString = (BaseQQAppInterface)paramAppInterface;
          }
        }
        if (paramString != null)
        {
          paramString = (IMessageFacade)paramString.getRuntimeService(IMessageFacade.class);
          if (paramString != null)
          {
            paramString.setReaded("2658655094", 1008, true, true);
            return;
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.d("WeatherWebPageHelper", 1, paramString, new Object[0]);
      }
    }
  }
  
  @JvmStatic
  public static final boolean a(@NotNull Context paramContext, @NotNull AppInterface paramAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    return a(paramContext, paramAppInterface, false, "", false, "");
  }
  
  @JvmStatic
  public static final boolean a(@NotNull Context paramContext, @Nullable AppInterface paramAppInterface, boolean paramBoolean1, @Nullable String paramString1, boolean paramBoolean2, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    long l1 = System.currentTimeMillis();
    Object localObject1 = URLUtil.a(paramString1);
    String str2 = (String)((Map)localObject1).get("adcode");
    String str1 = (String)((Map)localObject1).get("businessId");
    if ((paramBoolean1) && (jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper.a(paramString1))) {
      paramBoolean1 = false;
    }
    Object localObject4 = jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper.a(paramAppInterface);
    Object localObject2 = (WaterfallArk)null;
    if (localObject4 != null) {
      localObject2 = jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper.a((IArkMessage)localObject4);
    }
    Object localObject3;
    if (paramBoolean1)
    {
      localObject1 = a((WaterfallArk)localObject2, paramString1);
      localObject3 = localObject4;
    }
    else if (paramBoolean2)
    {
      localObject1 = jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper.b(paramString2);
      localObject3 = (IArkMessage)null;
    }
    else
    {
      localObject3 = localObject4;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper.a(str2);
        localObject3 = localObject4;
      }
    }
    if (localObject1 != null)
    {
      jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper.a(paramContext, (WaterfallArk)localObject1);
      boolean bool = ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist();
      localObject2 = jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper.a((WaterfallArk)localObject1);
      if (paramBoolean1) {
        paramString1 = b(jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper, paramString1, 0, 2, null);
      } else if (paramBoolean2) {
        paramString1 = c(jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper, paramString2, 0, 2, null);
      } else {
        paramString1 = a(jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper, (String)localObject2, 0, 2, null);
      }
      paramString2 = new ActivityURIRequest(paramContext, "/base/browser");
      localObject4 = paramString2.extra();
      ((Bundle)localObject4).putString("url", paramString1);
      ((Bundle)localObject4).putBoolean("isTransparentTitle", true);
      ((Bundle)localObject4).putString("fragment_class", WeatherWebViewFragment.class.getName());
      ((Bundle)localObject4).putString("appName", ((WaterfallArk)localObject1).a());
      ((Bundle)localObject4).putString("appView", ((WaterfallArk)localObject1).d());
      ((Bundle)localObject4).putString("appVersion", ((WaterfallArk)localObject1).c());
      ((Bundle)localObject4).putString("appMeta", ((WaterfallArk)localObject1).b());
      ((Bundle)localObject4).putString("adCode", (String)localObject2);
      ((Bundle)localObject4).putLong("start_click_time", l1);
      ((Bundle)localObject4).putBoolean("webProcessExist", bool);
      ((Bundle)localObject4).putBoolean("is_from_share", paramBoolean1);
      ((Bundle)localObject4).putBoolean("is_from_drawer", paramBoolean2);
      ((Bundle)localObject4).putBoolean("is_to_ark", true);
      ((Bundle)localObject4).putString("big_brother_source_key", "biz_src_gzh_weather");
      QRoute.startUri((URIRequest)paramString2, null);
      if (localObject3 != null)
      {
        paramString2 = jdField_a_of_type_ComTencentMobileqqWeatherWebpageWeatherWebPageHelper;
        if (localObject3 != null) {
          paramString2.a(((MessageRecord)localObject3).selfuin, paramAppInterface);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.data.MessageRecord");
        }
      }
      if (paramAppInterface != null) {
        BaseSharedPreUtil.a(paramContext, paramAppInterface.getCurrentAccountUin(), true, "key_last_open_weather_page", Long.valueOf(System.currentTimeMillis()));
      }
      paramContext = new StringBuilder();
      paramContext.append("isWebProcessExist = ");
      paramContext.append(bool);
      paramContext.append(" isFromShare = ");
      paramContext.append(paramBoolean1);
      paramContext.append(" isFromDrawer ");
      paramContext.append(paramBoolean2);
      paramContext.append(" url = ");
      paramContext.append(paramString1);
      WeatherPreloadHelper.a(2, paramContext.toString());
      if (bool)
      {
        WeatherDCReportHelper.a().a(paramAppInterface, "new_folder_prestart_open", "1");
      }
      else
      {
        int i = WeatherPreloadHelper.a.a(paramAppInterface);
        paramContext = WeatherDCReportHelper.a();
        paramString1 = new StringBuilder();
        paramString1.append(i);
        paramString1.append("|1");
        paramContext.a(paramAppInterface, "new_folder_noprestart_open", paramString1.toString());
      }
      if (str1 != null) {
        WeatherDCReportHelper.a().a((AppRuntime)paramAppInterface, "new_folder_apicall", new String[] { "AND", "", str1 });
      }
      if (localObject3 != null)
      {
        l1 = NetConnInfoCenter.getServerTime();
        if (localObject3 != null)
        {
          long l2 = ((MessageRecord)localObject3).time;
          WeatherDCReportHelper.a().a(paramAppInterface, "new_folder_push_open_timegap", Long.valueOf(l1 - l2));
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.data.MessageRecord");
        }
      }
      return true;
    }
    return false;
  }
  
  @JvmStatic
  public static final void b(@NotNull Context paramContext, @NotNull AppInterface paramAppInterface, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramAppInterface, "app");
    if (!a(paramContext, paramAppInterface, true, paramString, false, ""))
    {
      paramAppInterface = new Intent();
      paramString = new Bundle();
      QRouteApi localQRouteApi = QRoute.api(IChatActivityApi.class);
      Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IChatActivityApi::class.java)");
      paramAppInterface.setComponent(new ComponentName(paramContext, ((IChatActivityApi)localQRouteApi).getChatActivityClass()));
      paramString.putString("uin", "2658655094");
      paramString.putInt("uintype", 1008);
      paramString.putString("uinname", "QQ天气");
      paramAppInterface.putExtras(paramString);
      paramAppInterface.setFlags(67108864);
      paramAppInterface.putExtra("jump_from", paramInt);
      paramContext.startActivity(paramAppInterface);
    }
  }
  
  @NotNull
  public final WaterfallArk a(@Nullable String paramString)
  {
    QLog.i("WeatherWebPageHelper", 1, "buildNoPushWaterArk");
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\"qq_weather\": {\"adcode\": ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",\"scene\": 1}}");
      paramString = localStringBuilder.toString();
      if (paramString != null) {}
    }
    else
    {
      paramString = (WeatherWebPageHelper)this;
      paramString = "{\"qq_weather\": {}}";
    }
    return new WaterfallArk("com.tencent.weather_v2", paramString, "1.0.0.1", "qq_weather");
  }
  
  @NotNull
  public final String a(@Nullable String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      localObject = "0";
    }
    paramString = new StringBuilder();
    paramString.append("https://weather.mp.qq.com/pages/aio?_wv=1090533159&_wwv=196612&not_short=1&height=");
    paramString.append(paramInt);
    paramString.append("&adcode=");
    paramString.append((String)localObject);
    paramString = paramString.toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getWeatherWebUrl -> url: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WeatherWebPageHelper", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public final void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    ReportController.b(null, "P_CliOper", paramString2, "", paramString3, paramString4, 0, 0, paramString1, "", "", "");
  }
  
  public final boolean a(@Nullable Entity paramEntity)
  {
    boolean bool3 = paramEntity instanceof IArkMessage;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramEntity = a((IArkMessage)paramEntity);
      bool1 = bool2;
      if (paramEntity != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)paramEntity.a()))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty((CharSequence)paramEntity.d()))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty((CharSequence)paramEntity.c()))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty((CharSequence)paramEntity.b())) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final boolean a(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("WeatherWebPageHelper", 1, "checkShareUrlParam false shareUrl == null");
      return true;
    }
    Object localObject2 = URLUtil.a(paramString);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "URLUtil.getArgumentsFromURL(shareUrl)");
    Object localObject1 = (String)((Map)localObject2).get("adcode");
    localObject2 = (String)((Map)localObject2).get("scene");
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"0".equals(localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      return false;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkShareUrlParam false  shareUrl == ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(' ');
    QLog.i("WeatherWebPageHelper", 1, ((StringBuilder)localObject1).toString());
    return true;
  }
  
  @NotNull
  public final WaterfallArk b(@Nullable String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      localObject = "0";
    }
    paramString = new StringBuilder();
    paramString.append("{\"qq_weather\": {\"area_id\": ");
    paramString.append((String)localObject);
    paramString.append(",\"scene\": 3}}");
    paramString = paramString.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("buildDrawerArk appMeta == ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("WeatherWebPageHelper", 1, ((StringBuilder)localObject).toString());
    return new WaterfallArk("com.tencent.weather_v2", paramString, "1.0.0.1", "qq_weather");
  }
  
  @NotNull
  public final String b(@Nullable String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&height=");
    localStringBuilder.append(paramInt);
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildShareWeatherWebUrl ");
    localStringBuilder.append(paramString);
    QLog.i("WeatherWebPageHelper", 1, localStringBuilder.toString());
    return paramString;
  }
  
  @NotNull
  public final String c(@Nullable String paramString, int paramInt)
  {
    String str = paramString;
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      str = "0";
    }
    paramString = new StringBuilder();
    paramString.append("https://weather.mp.qq.com/pages/aio?_wv=1090533159&_wwv=196612&not_short=1&height=");
    paramString.append(paramInt);
    paramString.append("&area_id=");
    paramString.append(str);
    return paramString.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebPageHelper
 * JD-Core Version:    0.7.0.1
 */