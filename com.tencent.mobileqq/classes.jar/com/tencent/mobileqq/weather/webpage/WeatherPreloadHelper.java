package com.tencent.mobileqq.weather.webpage;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/weather/webpage/WeatherPreloadHelper;", "", "()V", "DATE_FORMAT", "", "MAX_PRELOAD_TIME", "", "PRELOAD_RESULT_ERROR_CANNOT_GET_APP", "PRELOAD_RESULT_ERROR_HAS_NO_UNREAD", "PRELOAD_RESULT_ERROR_HAS_WEB_PROCESS", "PRELOAD_RESULT_ERROR_LOW_PERF_DEVICE", "PRELOAD_RESULT_ERROR_NOT_NEW", "PRELOAD_RESULT_ERROR_NOT_OPEN_THREE_DAY", "PRELOAD_RESULT_ERROR_OTHER_WHEN_START_PROCESS", "PRELOAD_RESULT_ERROR_PARAM_WPM", "PRELOAD_RESULT_ERROR_PRELOAD_CLOSE", "PRELOAD_RESULT_ERROR_TODAY_PRELOAD_TO_MUCH", "PRELOAD_RESULT_NEVER", "PRELOAD_RESULT_SUCCESS", "PRELOAD_TIME_ZERO", "SP_PRELOAD_DATA_INDEX", "SP_PRELOAD_INFO_INDEX", "SP_PRELOAD_INFO_LIST_SIZE", "SP_PRELOAD_INFO_SPLIT", "START_WEB_PROCESS_DEFAULT_FROM", "STEP_ARK_LOAD", "STEP_CLICK", "STEP_GET_MESSAGE", "STEP_ON_CREATE", "STEP_TAG", "STEP_WEB_LOAD_END", "STEP_WEB_LOAD_START", "TAG", "THREE_DAY", "checkNeedPreload", "context", "Landroid/content/Context;", "app", "Lcom/tencent/common/app/AppInterface;", "getTodayLastPreloadResult", "getTodayPreloadTimes", "hasUnreadArkMsg", "", "Lmqq/app/AppRuntime;", "isToady", "dateString", "logInfo", "", "msg", "preloadWebProcess", "preloadWebProcessAsync", "from", "recordStep", "step", "ext", "saveAndReportPreloadResult", "preloadResult", "saveTodayPreloadTimes", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherPreloadHelper
{
  public static final WeatherPreloadHelper a = new WeatherPreloadHelper();
  
  private final int a(Context paramContext, AppInterface paramAppInterface)
  {
    if (!WeatherPreloadWebPageConfigProcessor.a.a()) {
      return -3001;
    }
    if (!a((AppRuntime)paramAppInterface)) {
      return -3004;
    }
    if (DeviceInfoUtils.isLowPerfDevice())
    {
      WeatherDCReportHelper.a().a(paramAppInterface, "new_folder_noprestart_lowsystem");
      return -3003;
    }
    paramContext = (Long)BaseSharedPreUtil.b(paramContext, paramAppInterface.getCurrentAccountUin(), "key_last_open_weather_page", Long.valueOf(0L));
    long l = System.currentTimeMillis();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "lastOpenTime");
    if (l - paramContext.longValue() > 259200000)
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("lastOpenTime unable lastOpenTime ：");
      paramAppInterface.append(paramContext);
      b(paramAppInterface.toString());
      return -3002;
    }
    if (c(paramAppInterface) >= 3) {
      return -3005;
    }
    return 0;
  }
  
  private final void a()
  {
    Object localObject3 = MobileQQ.context;
    if (localObject3 == null)
    {
      b("preloadWebProcess context error");
      return;
    }
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject1 != null) && ((localObject1 instanceof BaseToolAppInterface)))
    {
      if (!((BaseToolAppInterface)localObject1).isLogin())
      {
        b("preloadWebProcess not login");
        return;
      }
      Object localObject2 = ((AppRuntime)localObject1).getRuntimeService(IWebProcessManagerService.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.getRuntimeService(IW…va, ProcessConstant.MAIN)");
      localObject2 = (IWebProcessManagerService)localObject2;
      if ((localObject2 != null) && ((localObject2 instanceof IWebProcessManagerService)))
      {
        Context localContext = (Context)localObject3;
        localObject3 = (AppInterface)localObject1;
        int i = a(localContext, (AppInterface)localObject3);
        if (i != 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("preloadWebProcess no need result ");
          ((StringBuilder)localObject1).append(i);
          b(((StringBuilder)localObject1).toString());
          a((AppInterface)localObject3, i);
          return;
        }
        b("preloadWebProcess");
        ((IWebProcessManagerService)localObject2).startWebProcess(-1, (WebProcessStartListener)new WeatherPreloadHelper.preloadWebProcess.1((AppRuntime)localObject1, ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist()));
        return;
      }
      b("preloadWebProcess wpm error");
      a((AppInterface)localObject1, -2000);
      return;
    }
    b("preloadWebProcess app error");
  }
  
  @JvmStatic
  public static final void a(int paramInt)
  {
    WeatherPreloadHelper localWeatherPreloadHelper = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloadWebProcessAsync from = ");
    localStringBuilder.append(paramInt);
    localWeatherPreloadHelper.b(localStringBuilder.toString());
    ThreadManager.excute((Runnable)WeatherPreloadHelper.preloadWebProcessAsync.1.a, 128, null, false);
  }
  
  @JvmStatic
  public static final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ext");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    QLog.i("WeatherStep", 1, localStringBuilder.toString());
  }
  
  private final void a(AppInterface paramAppInterface, int paramInt)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
    Context localContext = (Context)MobileQQ.context;
    String str = paramAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localSimpleDateFormat.format(new Date()));
    localStringBuilder.append('|');
    localStringBuilder.append(paramInt);
    BaseSharedPreUtil.a(localContext, str, true, "key_last_preload_web_result", localStringBuilder.toString());
    if ((paramInt == -2000) || (paramInt == -3005) || (paramInt == -4001)) {
      WeatherDCReportHelper.a().a(paramAppInterface, "new_folder_prestart_fail_others", Integer.valueOf(paramInt));
    }
  }
  
  @JvmStatic
  public static final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "dateString");
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    Calendar localCalendar1 = (Calendar)null;
    Calendar localCalendar2;
    try
    {
      Date localDate = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse(paramString);
      localCalendar2 = Calendar.getInstance();
      paramString = localCalendar1;
      try
      {
        Intrinsics.checkExpressionValueIsNotNull(localCalendar2, "calendarLast");
        paramString = localCalendar1;
        localCalendar2.setTime(localDate);
        paramString = localCalendar1;
        localCalendar1 = Calendar.getInstance();
        paramString = localCalendar1;
        Intrinsics.checkExpressionValueIsNotNull(localCalendar1, "calendarNow");
        paramString = localCalendar1;
        localCalendar1.setTime(new Date());
        paramString = localCalendar1;
      }
      catch (Throwable localThrowable1) {}
      QLog.i("WeatherPreloadHelper", 1, "isToady", localThrowable2);
    }
    catch (Throwable localThrowable2)
    {
      localCalendar2 = localCalendar1;
      paramString = localCalendar1;
    }
    return (localCalendar2 != null) && (paramString != null) && (localCalendar2.get(0) == paramString.get(0)) && (localCalendar2.get(1) == paramString.get(1)) && (localCalendar2.get(6) == paramString.get(6));
  }
  
  private final boolean a(AppRuntime paramAppRuntime)
  {
    Object localObject = paramAppRuntime.getRuntimeService(IConversationFacade.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IC…va, ProcessConstant.MAIN)");
    localObject = (IConversationFacade)localObject;
    if (localObject != null) {
      localObject = Integer.valueOf(((IConversationFacade)localObject).getUnreadCount("2658655094", 1008));
    } else {
      localObject = null;
    }
    int j = ((Integer)localObject).intValue();
    if ((j > 0) && ((paramAppRuntime instanceof BaseQQAppInterface)))
    {
      paramAppRuntime = ((IMessageFacade)((BaseQQAppInterface)paramAppRuntime).getRuntimeService(IMessageFacade.class)).getAIOList("2658655094", 1008);
      int i = paramAppRuntime.size() - 1;
      j = Math.max(0, paramAppRuntime.size() - j);
      if (i >= j) {
        for (;;)
        {
          if (WeatherWebPageHelper.a.a((Entity)paramAppRuntime.get(i))) {
            return true;
          }
          if (i == j) {
            break;
          }
          i -= 1;
        }
      }
    }
    return false;
  }
  
  private final void b(AppInterface paramAppInterface)
  {
    Object localObject = MobileQQ.sMobileQQ;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.sMobileQQ");
    ((MobileQQ)localObject).getAllAccounts();
    int i = c(paramAppInterface);
    localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
    Context localContext = (Context)MobileQQ.context;
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((SimpleDateFormat)localObject).format(new Date()));
    localStringBuilder.append('|');
    localStringBuilder.append(i + 1);
    BaseSharedPreUtil.a(localContext, paramAppInterface, true, "key_last_preload_web_process", localStringBuilder.toString());
  }
  
  private final void b(String paramString)
  {
    QLog.i("WeatherPreloadHelper", 1, paramString);
  }
  
  private final int c(AppInterface paramAppInterface)
  {
    paramAppInterface = (String)BaseSharedPreUtil.b((Context)MobileQQ.context, paramAppInterface.getCurrentAccountUin(), "key_last_preload_web_process", "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTodayPreInfoTimes ：");
    ((StringBuilder)localObject).append(paramAppInterface);
    b(((StringBuilder)localObject).toString());
    localObject = (CharSequence)paramAppInterface;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return 0;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "preloadString");
    localObject = StringsKt.split$default((CharSequence)localObject, new String[] { "|" }, false, 0, 6, null);
    if ((((List)localObject).size() == 2) && (!TextUtils.isEmpty((CharSequence)((List)localObject).get(0))))
    {
      if (TextUtils.isEmpty((CharSequence)((List)localObject).get(1))) {
        return 0;
      }
      if (!a((String)((List)localObject).get(0))) {
        return 0;
      }
      paramAppInterface = (Integer)null;
      try
      {
        localObject = Integer.valueOf((String)((List)localObject).get(1));
        paramAppInterface = (AppInterface)localObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("WeatherPreloadHelper", 1, "getPreInfoTimes", localThrowable);
      }
      if (paramAppInterface == null) {
        return 0;
      }
      return paramAppInterface.intValue();
    }
    return 0;
  }
  
  public final int a(@Nullable AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return -5000;
    }
    paramAppInterface = (String)BaseSharedPreUtil.b((Context)MobileQQ.context, paramAppInterface.getCurrentAccountUin(), "key_last_preload_web_result", "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTodayLastPreloadResult ：");
    ((StringBuilder)localObject).append(paramAppInterface);
    b(((StringBuilder)localObject).toString());
    localObject = (CharSequence)paramAppInterface;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return -1000;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "preloadString");
    localObject = StringsKt.split$default((CharSequence)localObject, new String[] { "|" }, false, 0, 6, null);
    if ((((List)localObject).size() == 2) && (!TextUtils.isEmpty((CharSequence)((List)localObject).get(0))))
    {
      if (TextUtils.isEmpty((CharSequence)((List)localObject).get(1))) {
        return -1000;
      }
      if (!a((String)((List)localObject).get(0))) {
        return -1000;
      }
      paramAppInterface = (Integer)null;
      try
      {
        localObject = Integer.valueOf((String)((List)localObject).get(1));
        paramAppInterface = (AppInterface)localObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("WeatherPreloadHelper", 1, "getTodayLastPreloadResult", localThrowable);
      }
      if (paramAppInterface == null) {
        return -1000;
      }
      return paramAppInterface.intValue();
    }
    return -1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherPreloadHelper
 * JD-Core Version:    0.7.0.1
 */