package com.tencent.mobileqq.kandian.biz.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.router.SerializableMap;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoadListener;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJFlutterLikePageAladdinConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/flutter/RIJFlutterUtils;", "", "()V", "FLUTTER_PAGE", "", "FLUTTER_UIN_KEY", "FLUTTER_UIN_SKEY", "KANDIAN_ENTRY_POINT", "KD_MX_FLUTTER_LIKE_JS_BID", "MX_KEY_BID_ID", "MX_KEY_IS_DART_2JS", "MX_KEY_IS_JS_INIT", "MX_KEY_JS_WIDGET_NAME", "MX_KEY_NATIVE_COPY_BUNDLE", "PAGE_OPEN_TIME", "QQ_VERSION", "TAG", "hasPreDownload", "", "getHasPreDownload", "()Z", "setHasPreDownload", "(Z)V", "addCommonParams", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "addMxParams", "data", "deCodeParams", "doFlutterJump", "context", "Landroid/app/Activity;", "useMXFlutter", "setting", "Lcom/tencent/mobileqq/kandian/biz/flutter/FlutterPageSetting;", "jump2FlutterPage", "c", "Landroid/content/Context;", "jumpToMxFlutterPage", "openFlutterPage", "activity", "entryPoint", "openRIJFlutterPage", "pageName", "preDownloadFlutter", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFlutterUtils
{
  public static final RIJFlutterUtils a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFlutterRIJFlutterUtils = new RIJFlutterUtils();
  }
  
  private final HashMap<String, Object> a(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      String str1 = (String)((Map.Entry)localObject).getKey();
      String str2 = (String)((Map.Entry)localObject).getValue();
      localObject = (Map)localHashMap;
      str2 = URLDecoder.decode(str2, "utf-8");
      Intrinsics.checkExpressionValueIsNotNull(str2, "URLDecoder.decode(value, \"utf-8\")");
      ((Map)localObject).put(str1, str2);
    }
    return localHashMap;
  }
  
  private final void a(Activity paramActivity, String paramString1, String paramString2, HashMap<String, Object> paramHashMap, FlutterPageSetting paramFlutterPageSetting)
  {
    boolean bool = PreloadProcHitSession.a("com.tencent.mobileqq:tool");
    SerializableMap localSerializableMap = new SerializableMap();
    localSerializableMap.setMap((Map)paramHashMap);
    paramHashMap = new Intent();
    paramHashMap.putExtra("entry_point", paramString1);
    paramHashMap.putExtra("page_name", paramString2);
    paramString1 = new StringBuilder();
    paramString1.append(String.valueOf(System.currentTimeMillis()));
    paramString1.append("-");
    paramString1.append(hashCode());
    paramHashMap.putExtra("unique_id", paramString1.toString());
    paramHashMap.putExtra("params", (Serializable)localSerializableMap);
    paramHashMap.putExtra("status_bar_transparent", paramFlutterPageSetting.a());
    paramHashMap.putExtra("status_text_dark", paramFlutterPageSetting.b());
    paramHashMap.putExtra("key_extra_support_back_event", paramFlutterPageSetting.c());
    paramHashMap.putExtra("preload_process", bool);
    paramHashMap.putExtra("open_page_time", SystemClock.elapsedRealtime());
    QPublicFragmentActivityForTool.a(paramActivity, paramHashMap, RIJFlutterContainerFragment.class, paramFlutterPageSetting.a());
  }
  
  private final void a(Activity paramActivity, String paramString, HashMap<String, Object> paramHashMap, FlutterPageSetting paramFlutterPageSetting)
  {
    try
    {
      Object localObject = paramHashMap.get("page");
      if (localObject != null)
      {
        a(paramActivity, paramString, (String)localObject, paramHashMap, paramFlutterPageSetting);
        QLog.d("RIJFlutterUtils", 1, "openFlutterPage");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    catch (Exception paramActivity)
    {
      QLog.d("RIJFlutterUtils", 1, paramActivity.getMessage());
    }
  }
  
  private final void a(Activity paramActivity, HashMap<String, String> paramHashMap, boolean paramBoolean, FlutterPageSetting paramFlutterPageSetting)
  {
    HashMap localHashMap = a(paramHashMap);
    a(localHashMap);
    if (paramBoolean) {
      a(paramActivity, localHashMap);
    } else {
      a(paramActivity, "qqKandianWidget", localHashMap, paramFlutterPageSetting);
    }
    paramFlutterPageSetting = new JSONObject();
    if (paramBoolean) {
      paramActivity = "1";
    } else {
      paramActivity = "2";
    }
    paramFlutterPageSetting.put("entryPoint", paramActivity);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800BB2A", "0X800BB2A", 0, 0, "", "", "", paramFlutterPageSetting.toString(), false);
    paramActivity = new StringBuilder();
    paramActivity.append("jump2FlutterPage,data=");
    paramActivity.append(paramHashMap);
    paramActivity.append(", useMXFlutter=");
    paramActivity.append(paramBoolean);
    QLog.d("RIJFlutterUtils", 1, paramActivity.toString());
  }
  
  private final void a(HashMap<String, Object> paramHashMap)
  {
    Object localObject1 = ReadInJoyUtils.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ReadInJoyUtils.getAppRuntime()");
    localObject1 = ((AppRuntime)localObject1).getCurrentUin();
    Object localObject2 = ReadInJoyUtils.a().getManager(2);
    if (localObject2 != null)
    {
      localObject2 = ((TicketManager)localObject2).getSkey((String)localObject1);
      paramHashMap = (Map)paramHashMap;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "uin");
      paramHashMap.put("uin_key", localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "skey");
      paramHashMap.put("skey", localObject2);
      paramHashMap.put("qq_version", "8.7.0");
      paramHashMap.put("page_open_time", Long.valueOf(System.currentTimeMillis()));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type mqq.manager.TicketManager");
  }
  
  private final void b(HashMap<String, Object> paramHashMap)
  {
    paramHashMap = (Map)paramHashMap;
    paramHashMap.put("bidID", "4630");
    Boolean localBoolean = Boolean.valueOf(false);
    paramHashMap.put("isJSEngineInit", localBoolean);
    paramHashMap.put("isDart2JS", localBoolean);
    paramHashMap.put("nativeCopyAppBundle", Boolean.valueOf(MxFlutterResourceLoader.a.a()));
  }
  
  public final void a()
  {
    if (!RIJFlutterLikePageAladdinConfig.a()) {
      return;
    }
    if (jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.a();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        ThreadManager.executeOnSubThread((Runnable)new RIJFlutterUtils.preDownloadFlutter.1(localAppRuntime));
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownloadFlutter error! msg=");
      localStringBuilder.append(localException);
      QLog.d("RIJFlutterUtils", 1, localStringBuilder.toString());
    }
  }
  
  public final void a(@Nullable Activity paramActivity, @NotNull HashMap<String, Object> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "data");
    Object localObject = paramHashMap.get("page");
    if (localObject != null)
    {
      localObject = (String)localObject;
      MxFlutterResourceLoader.a.a("4630", true, (MxFlutterResourceLoadListener)new RIJFlutterUtils.jumpToMxFlutterPage.1(paramActivity, paramHashMap, (String)localObject));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
  }
  
  public final void a(@Nullable Context paramContext, @Nullable HashMap<String, String> paramHashMap, boolean paramBoolean, @NotNull FlutterPageSetting paramFlutterPageSetting)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPageSetting, "setting");
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = (Context)BaseActivity.sTopActivity;
    }
    try
    {
      if (((localContext instanceof Activity)) && (paramHashMap != null))
      {
        a((Activity)localContext, paramHashMap, paramBoolean, paramFlutterPageSetting);
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("jump2FlutterPage error! data=");
      paramContext.append(paramHashMap);
      paramContext.append(", useMXFlutter=");
      paramContext.append(paramBoolean);
      QLog.d("RIJFlutterUtils", 1, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("jump2FlutterPage error! msg=");
      paramHashMap.append(paramContext);
      QLog.d("RIJFlutterUtils", 1, paramHashMap.toString());
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils
 * JD-Core Version:    0.7.0.1
 */