package com.tencent.mobileqq.flutter.channel.kandian;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/flutter/channel/kandian/RIJChannelFlutterUtils;", "", "()V", "KEY_BIGT_REPORT", "", "METHOD_BEACON_REPORT", "METHOD_BIGT_REPORT", "METHOD_SCHEMA_JUMP", "METHOD_VIOLA_JUMP", "TAG", "methodsMap", "", "Lkotlin/Function1;", "", "getMethodsMap", "()Ljava/util/Map;", "beaconReport", "arguments", "convertMapToStringMap", "", "params", "getAccount", "registerMethods", "report", "schemaJump", "violaJump", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelFlutterUtils
{
  public static final RIJChannelFlutterUtils a;
  @NotNull
  private static final Map<String, Function1<Object, Unit>> b;
  
  static
  {
    RIJChannelFlutterUtils localRIJChannelFlutterUtils = new RIJChannelFlutterUtils();
    a = localRIJChannelFlutterUtils;
    b = (Map)new LinkedHashMap();
    localRIJChannelFlutterUtils.c();
  }
  
  private final Map<String, String> a(Map<?, ?> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      ((Map)localHashMap).put(String.valueOf(localObject1), String.valueOf(localObject2));
    }
    return (Map)localHashMap;
  }
  
  private final void a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = URLDecoder.decode((String)paramObject, "utf-8");
      ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl((Context)BaseApplicationImpl.getContext(), paramObject);
    }
  }
  
  private final void b(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = new JSONObject((String)paramObject);
      String str = paramObject.optString("viola_page_url");
      paramObject = paramObject.optJSONObject("viola_page_data");
      IRIJJumpUtils localIRIJJumpUtils = (IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class);
      Context localContext = (Context)BaseApplicationImpl.getContext();
      if (paramObject != null) {
        paramObject = paramObject.toString();
      } else {
        paramObject = null;
      }
      localIRIJJumpUtils.jumpToViola(localContext, "", str, paramObject);
    }
  }
  
  private final void c()
  {
    Map localMap = b;
    RIJChannelFlutterUtils localRIJChannelFlutterUtils = (RIJChannelFlutterUtils)this;
    localMap.put("method_schema_jump", new RIJChannelFlutterUtils.registerMethods.1(localRIJChannelFlutterUtils));
    b.put("method_bigt_report", new RIJChannelFlutterUtils.registerMethods.2(localRIJChannelFlutterUtils));
    b.put("method_viola_jump", new RIJChannelFlutterUtils.registerMethods.3(localRIJChannelFlutterUtils));
    b.put("method_beacon_report", new RIJChannelFlutterUtils.registerMethods.4(localRIJChannelFlutterUtils));
  }
  
  private final void c(Object paramObject)
  {
    if ((paramObject instanceof Map)) {
      try
      {
        localObject = ((Map)paramObject).get("key_bigt_report");
        if (localObject != null)
        {
          localObject = (String)localObject;
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", (String)localObject, (String)localObject, 0, 0, "", "", "", new JSONObject((Map)paramObject).toString(), false);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
      catch (Exception paramObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report error! e =");
        ((StringBuilder)localObject).append(paramObject.getMessage());
        QLog.d("RIJChannelFlutterUtils", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private final void d(Object paramObject)
  {
    if ((paramObject instanceof Map)) {}
    for (;;)
    {
      try
      {
        localObject = ((Map)paramObject).get("event_name");
        if (localObject == null) {
          localObject = "";
        }
        if (localObject != null)
        {
          String str = (String)localObject;
          if (TextUtils.isEmpty((CharSequence)str))
          {
            QLog.i("RIJChannelFlutterUtils", 1, "[beaconReport] eventName is empty.");
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[beaconReport] eventName = ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", params = ");
          ((StringBuilder)localObject).append(paramObject);
          QLog.i("RIJChannelFlutterUtils", 1, ((StringBuilder)localObject).toString());
          localObject = b();
          if (localObject == null) {
            break label176;
          }
          QQBeaconReport.a("0S200MNJT807V3GE", (String)localObject, str, true, a((Map)paramObject), true);
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
      catch (Exception paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[beaconReport] exception = ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.e("RIJChannelFlutterUtils", 1, ((StringBuilder)localObject).toString());
      }
      return;
      label176:
      Object localObject = "";
    }
  }
  
  @NotNull
  public final Map<String, Function1<Object, Unit>> a()
  {
    return b;
  }
  
  @Nullable
  public final String b()
  {
    Object localObject1 = (AppRuntime)null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).getRuntime();
    }
    localObject2 = "0";
    if (localObject1 == null) {
      return "0";
    }
    String str = ((AppRuntime)localObject1).getAccount();
    localObject1 = localObject2;
    if (str != null) {
      localObject1 = str;
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.kandian.RIJChannelFlutterUtils
 * JD-Core Version:    0.7.0.1
 */