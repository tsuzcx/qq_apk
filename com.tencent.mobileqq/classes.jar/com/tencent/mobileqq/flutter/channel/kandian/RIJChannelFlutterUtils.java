package com.tencent.mobileqq.flutter.channel.kandian;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/flutter/channel/kandian/RIJChannelFlutterUtils;", "", "()V", "KEY_BIGT_REPORT", "", "METHOD_BIGT_REPORT", "METHOD_SCHEMA_JUMP", "METHOD_VIOLA_JUMP", "TAG", "methodsMap", "", "Lkotlin/Function1;", "", "getMethodsMap", "()Ljava/util/Map;", "registerMethods", "report", "arguments", "schemaJump", "violaJump", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelFlutterUtils
{
  public static final RIJChannelFlutterUtils a;
  @NotNull
  private static final Map<String, Function1<Object, Unit>> a;
  
  static
  {
    RIJChannelFlutterUtils localRIJChannelFlutterUtils = new RIJChannelFlutterUtils();
    jdField_a_of_type_ComTencentMobileqqFlutterChannelKandianRIJChannelFlutterUtils = localRIJChannelFlutterUtils;
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    localRIJChannelFlutterUtils.a();
  }
  
  private final void a()
  {
    Map localMap = jdField_a_of_type_JavaUtilMap;
    RIJChannelFlutterUtils localRIJChannelFlutterUtils = (RIJChannelFlutterUtils)this;
    localMap.put("method_schema_jump", new RIJChannelFlutterUtils.registerMethods.1(localRIJChannelFlutterUtils));
    jdField_a_of_type_JavaUtilMap.put("method_bigt_report", new RIJChannelFlutterUtils.registerMethods.2(localRIJChannelFlutterUtils));
    jdField_a_of_type_JavaUtilMap.put("method_viola_jump", new RIJChannelFlutterUtils.registerMethods.3(localRIJChannelFlutterUtils));
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
  
  @NotNull
  public final Map<String, Function1<Object, Unit>> a()
  {
    return jdField_a_of_type_JavaUtilMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.kandian.RIJChannelFlutterUtils
 * JD-Core Version:    0.7.0.1
 */