package com.tencent.mobileqq.kandian.biz.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.launch.DebugInstaller;
import com.tencent.mobileqq.flutter.router.SerializableMap;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoadListener;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJFlutterLikePageAladdinConfig;
import com.tencent.mobileqq.statistics.QQBeaconReport;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/flutter/RIJFlutterUtils;", "", "()V", "BEACON_REPORT_EVENT_FLUTTER_ENTRY", "", "FLUTTER_PAGE", "FLUTTER_UIN_KEY", "FLUTTER_UIN_SKEY", "KANDIAN_ENTRY_POINT", "KD_MX_FLUTTER_LIKE_JS_BID", "KD_MX_FLUTTER_UGC_VIDEO_SUCCESS_BID", "PAGE_OPEN_TIME", "PRE_DOWNLOAD_BUNDLE", "", "getPRE_DOWNLOAD_BUNDLE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "QQ_VERSION", "TAG", "hasPreDownload", "", "addCommonParams", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "beaconReport", "eventName", "convertMapToStringMap", "decodeParams", "data", "doFlutterJump", "context", "Landroid/app/Activity;", "useMXFlutter", "setting", "Lcom/tencent/mobileqq/kandian/biz/flutter/FlutterPageSetting;", "jump2FlutterPage", "c", "Landroid/content/Context;", "jumpToMxFlutterPage", "openFlutterPage", "activity", "entryPoint", "openRIJFlutterPage", "pageName", "preDownloadBizBundle", "preDownloadFlutter", "preDownloadFlutterActual", "preDownloadFlutterOnDebugMode", "updateFlutterPageSetting", "putWhenAbsent", "K", "V", "key", "value", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)V", "MX_KEY", "MX_VALUE", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFlutterUtils
{
  public static final RIJFlutterUtils a = new RIJFlutterUtils();
  private static boolean b;
  @NotNull
  private static final String[] c = { "4642" };
  
  private final HashMap<String, Object> a(HashMap<String, ?> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      Map localMap;
      if ((localObject instanceof String))
      {
        localMap = (Map)localHashMap;
        localObject = URLDecoder.decode((String)localObject, "utf-8");
        Intrinsics.checkExpressionValueIsNotNull(localObject, "URLDecoder.decode(value, \"utf-8\")");
        localMap.put(str, localObject);
      }
      else
      {
        localMap = (Map)localHashMap;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "value");
        localMap.put(str, localObject);
      }
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
    paramHashMap.putExtra("status_bar_transparent", paramFlutterPageSetting.b());
    paramHashMap.putExtra("status_text_dark", paramFlutterPageSetting.c());
    paramHashMap.putExtra("key_extra_support_back_event", paramFlutterPageSetting.d());
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
  
  private final void a(Activity paramActivity, HashMap<String, ?> paramHashMap, boolean paramBoolean, FlutterPageSetting paramFlutterPageSetting)
  {
    HashMap localHashMap = a(paramHashMap);
    b(localHashMap);
    if (paramBoolean) {
      a(paramActivity, localHashMap);
    } else {
      a(paramActivity, "qqKandianWidget", localHashMap, paramFlutterPageSetting);
    }
    paramFlutterPageSetting = new JSONObject();
    if (paramBoolean) {
      paramActivity = "2";
    } else {
      paramActivity = "1";
    }
    paramFlutterPageSetting.put("entryPoint", paramActivity);
    PublicAccountReportUtils.a(null, "", "0X800BB2A", "0X800BB2A", 0, 0, "", "", "", paramFlutterPageSetting.toString(), false);
    paramActivity = new StringBuilder();
    paramActivity.append("#jump2FlutterPage: data=");
    paramActivity.append(paramHashMap);
    paramActivity.append(", useMXFlutter=");
    paramActivity.append(paramBoolean);
    QLog.d("RIJFlutterUtils", 1, paramActivity.toString());
    a("actKandianFlutterEntry", c(localHashMap));
  }
  
  private final void a(FlutterPageSetting paramFlutterPageSetting)
  {
    paramFlutterPageSetting.a(true);
    paramFlutterPageSetting.b(true);
  }
  
  private final void a(String paramString, HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[beaconReport] eventName = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", params = ");
    localStringBuilder.append(paramHashMap);
    QLog.i("RIJFlutterUtils", 1, localStringBuilder.toString());
    QQBeaconReport.a("0S200MNJT807V3GE", RIJQQAppInterfaceUtil.d(), paramString, true, (Map)paramHashMap, true);
  }
  
  private final <K, V> void a(@NotNull HashMap<K, V> paramHashMap, K paramK, V paramV)
  {
    if ((!paramHashMap.containsKey(paramK)) && (paramK != null)) {
      paramHashMap.put(paramK, paramV);
    }
  }
  
  private final void b()
  {
    String[] arrayOfString = c;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      MxFlutterResourceLoader.a.a(str, true, null);
      i += 1;
    }
  }
  
  private final void b(HashMap<String, Object> paramHashMap)
  {
    Object localObject1 = ReadInJoyUtils.b();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ReadInJoyUtils.getAppRuntime()");
    localObject1 = ((AppRuntime)localObject1).getCurrentUin();
    Object localObject2 = ReadInJoyUtils.b().getManager(2);
    if (localObject2 != null)
    {
      localObject2 = ((TicketManager)localObject2).getSkey((String)localObject1);
      paramHashMap = (Map)paramHashMap;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "uin");
      paramHashMap.put("uin_key", localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "skey");
      paramHashMap.put("skey", localObject2);
      paramHashMap.put("qq_version", "8.8.17");
      paramHashMap.put("page_open_time", Long.valueOf(System.currentTimeMillis()));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type mqq.manager.TicketManager");
  }
  
  private final HashMap<String, String> c(HashMap<?, ?> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramHashMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      ((Map)localHashMap).put(localObject1.toString(), localObject2.toString());
    }
    return localHashMap;
  }
  
  private final boolean c()
  {
    if (DebugInstaller.a())
    {
      b = true;
      ThreadManager.executeOnFileThread((Runnable)RIJFlutterUtils.preDownloadFlutterOnDebugMode.1.a);
      return true;
    }
    return false;
  }
  
  private final void d()
  {
    QLog.d("RIJFlutterUtils", 1, "#preDownloadFlutterActual: begin");
    try
    {
      AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        b = true;
        ThreadManager.executeOnSubThread((Runnable)new RIJFlutterUtils.preDownloadFlutterActual.1(localAppRuntime));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.w("RIJFlutterUtils", 1, "preDownloadFlutterActual error! ", (Throwable)localException);
    }
  }
  
  public final void a()
  {
    b();
    if (!RIJFlutterLikePageAladdinConfig.a()) {
      return;
    }
    if (b)
    {
      MxFlutterResourceLoader.a.e();
      return;
    }
    if (c()) {
      return;
    }
    d();
  }
  
  public final void a(@Nullable Activity paramActivity, @NotNull HashMap<String, Object> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "data");
    if (!paramHashMap.containsKey("flutterPushParams"))
    {
      localObject1 = (Map)paramHashMap;
      ((Map)localObject1).put("flutterPushParams", new HashMap((Map)localObject1));
    }
    a(paramHashMap, "bidID", "4630");
    a(paramHashMap, "isJSEngineInit", Boolean.valueOf(false));
    a(paramHashMap, "isDart2JS", Boolean.valueOf(false));
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("#jumpToMxFlutterPage: begin data=");
    ((StringBuilder)localObject1).append(paramHashMap);
    QLog.d("RIJFlutterUtils", 1, ((StringBuilder)localObject1).toString());
    localObject1 = paramHashMap.get("page");
    if (localObject1 != null)
    {
      localObject1 = (String)localObject1;
      Object localObject2 = paramHashMap.get("bidID");
      if (localObject2 != null)
      {
        localObject2 = (String)localObject2;
        MxFlutterResourceLoader.a.a((String)localObject2, true, (MxFlutterResourceLoadListener)new RIJFlutterUtils.jumpToMxFlutterPage.1(paramActivity, paramHashMap, (String)localObject1));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
  }
  
  public final void a(@Nullable Context paramContext, @Nullable HashMap<String, ?> paramHashMap, boolean paramBoolean, @NotNull FlutterPageSetting paramFlutterPageSetting)
  {
    Intrinsics.checkParameterIsNotNull(paramFlutterPageSetting, "setting");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#jump2FlutterPage: begin data=");
    if (paramHashMap != null) {
      localObject = paramHashMap.toString();
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    QLog.d("RIJFlutterUtils", 1, localStringBuilder.toString());
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = (Context)QBaseActivity.sTopActivity;
    }
    a(paramFlutterPageSetting);
    try
    {
      if (((localObject instanceof Activity)) && (paramHashMap != null))
      {
        a((Activity)localObject, paramHashMap, paramBoolean, paramFlutterPageSetting);
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("#jump2FlutterPage: error! data=");
      paramContext.append(paramHashMap);
      paramContext.append(", useMXFlutter=");
      paramContext.append(paramBoolean);
      QLog.d("RIJFlutterUtils", 1, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("#jump2FlutterPage: error! msg=");
      paramHashMap.append(paramContext);
      QLog.d("RIJFlutterUtils", 1, paramHashMap.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils
 * JD-Core Version:    0.7.0.1
 */