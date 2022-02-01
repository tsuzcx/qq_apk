package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/ReadInJoySessionManager;", "", "()V", "DATE_FORMAT", "Ljava/text/SimpleDateFormat;", "SERIES_NUM", "", "TRACE_ID", "hasArticleData", "", "getHasArticleData", "()Z", "setHasArticleData", "(Z)V", "sceneSeriesNum", "", "sceneTraceId", "getDayKey", "key", "getSceneSeriesNum", "getSceneTraceID", "updateSceneSeriesNum", "", "updateSceneTraceId", "updateSceneTraceIdAndSeriesNum", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoySessionManager
{
  private static int jdField_a_of_type_Int;
  public static final ReadInJoySessionManager a;
  private static String jdField_a_of_type_JavaLangString;
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    Object localObject1 = new ReadInJoySessionManager();
    jdField_a_of_type_ComTencentMobileqqKandianGlueReportReadInJoySessionManager = (ReadInJoySessionManager)localObject1;
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    Object localObject2 = RIJSPUtils.a(((ReadInJoySessionManager)localObject1).a("sceneTraceId"), "");
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "RIJSPUtils.getReadInJoyS…(getDayKey(TRACE_ID), \"\")");
    jdField_a_of_type_JavaLangString = (String)localObject2;
    localObject1 = RIJSPUtils.a(((ReadInJoySessionManager)localObject1).a("sceneSeriesNum"), Integer.valueOf(0));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "RIJSPUtils.getReadInJoyS…getDayKey(SERIES_NUM), 0)");
    jdField_a_of_type_Int = ((Number)localObject1).intValue();
  }
  
  private final String a(String paramString)
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJQQAppInterfaceUtil.getAppRuntime()");
    localObject = ((AppRuntime)localObject).getAccount();
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date());
    Intrinsics.checkExpressionValueIsNotNull(str, "DATE_FORMAT.format(Date())");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private final void b()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJQQAppInterfaceUtil.getAppRuntime()");
    localObject = ((AppRuntime)localObject).getAccount();
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(String.valueOf(l));
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    RIJSPUtils.a(a("sceneTraceId"), jdField_a_of_type_JavaLangString);
    jdField_a_of_type_Boolean = false;
  }
  
  private final void c()
  {
    jdField_a_of_type_Int = a() + 1;
    RIJSPUtils.a(a("sceneSeriesNum"), Integer.valueOf(jdField_a_of_type_Int));
  }
  
  public final int a()
  {
    Object localObject = RIJSPUtils.a(a("sceneSeriesNum"), Integer.valueOf(0));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…Key(\"sceneSeriesNum\"), 0)");
    return ((Number)localObject).intValue();
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = RIJSPUtils.a(a("sceneTraceId"), "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…(getDayKey(TRACE_ID), \"\")");
    return (String)localObject;
  }
  
  public final void a()
  {
    if (jdField_a_of_type_Boolean)
    {
      b();
      c();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadInJoySessionManager
 * JD-Core Version:    0.7.0.1
 */