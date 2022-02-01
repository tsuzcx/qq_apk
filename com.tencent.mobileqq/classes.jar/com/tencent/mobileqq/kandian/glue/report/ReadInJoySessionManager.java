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
  public static final ReadInJoySessionManager a;
  private static final SimpleDateFormat b;
  private static int c;
  private static String d;
  private static boolean e;
  
  static
  {
    Object localObject1 = new ReadInJoySessionManager();
    a = (ReadInJoySessionManager)localObject1;
    b = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    Object localObject2 = RIJSPUtils.b(((ReadInJoySessionManager)localObject1).a("sceneTraceId"), "");
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "RIJSPUtils.getReadInJoyS…(getDayKey(TRACE_ID), \"\")");
    d = (String)localObject2;
    localObject1 = RIJSPUtils.b(((ReadInJoySessionManager)localObject1).a("sceneSeriesNum"), Integer.valueOf(0));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "RIJSPUtils.getReadInJoyS…getDayKey(SERIES_NUM), 0)");
    c = ((Number)localObject1).intValue();
  }
  
  private final String a(String paramString)
  {
    Object localObject = RIJQQAppInterfaceUtil.e();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJQQAppInterfaceUtil.getAppRuntime()");
    localObject = ((AppRuntime)localObject).getAccount();
    String str = b.format(new Date());
    Intrinsics.checkExpressionValueIsNotNull(str, "DATE_FORMAT.format(Date())");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private final void d()
  {
    Object localObject = RIJQQAppInterfaceUtil.e();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJQQAppInterfaceUtil.getAppRuntime()");
    localObject = ((AppRuntime)localObject).getAccount();
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(String.valueOf(l));
    d = localStringBuilder.toString();
    RIJSPUtils.a(a("sceneTraceId"), d);
    e = false;
  }
  
  private final void e()
  {
    c = b() + 1;
    RIJSPUtils.a(a("sceneSeriesNum"), Integer.valueOf(c));
  }
  
  @NotNull
  public final String a()
  {
    Object localObject = RIJSPUtils.b(a("sceneTraceId"), "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…(getDayKey(TRACE_ID), \"\")");
    return (String)localObject;
  }
  
  public final void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public final int b()
  {
    Object localObject = RIJSPUtils.b(a("sceneSeriesNum"), Integer.valueOf(0));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…Key(\"sceneSeriesNum\"), 0)");
    return ((Number)localObject).intValue();
  }
  
  public final void c()
  {
    if (e)
    {
      d();
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadInJoySessionManager
 * JD-Core Version:    0.7.0.1
 */