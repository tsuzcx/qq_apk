package com.tencent.mobileqq.cmshow.engine.script.plugin;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.statistics.trace.TraceMappingIml;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/TraceReportPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "spriteContext", "Lcom/tencent/mobileqq/apollo/script/SpriteContext;", "(Lcom/tencent/mobileqq/apollo/script/SpriteContext;)V", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleEvent", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "handleJsError", "reqData", "handleTraceBegin", "handleTraceEnd", "handleTraceLog", "handleTraceSpanBegin", "handleTraceSpanEnd", "observedEvents", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class TraceReportPlugin
  implements IEventPlugin
{
  @Deprecated
  public static final TraceReportPlugin.Companion a = new TraceReportPlugin.Companion(null);
  @NotNull
  private static final List<String> e = CollectionsKt.listOf(new String[] { "cs.trace_begin.local", "cs.trace_end.local", "cs.trace_log.local", "cs.trace_span_begin.local", "cs.trace_span_end.local", "cs.xy_error_info.local" });
  @NotNull
  private final PluginCmdConstant.PlugPriority c;
  private final SpriteContext d;
  
  public TraceReportPlugin(@NotNull SpriteContext paramSpriteContext)
  {
    this.d = paramSpriteContext;
    this.c = PluginCmdConstant.PlugPriority.DATA;
  }
  
  private final String b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTraceBegin, reqData: ");
      localStringBuilder.append(paramString);
      QLog.i("[cmshow][TraceReportPlugin]", 1, localStringBuilder.toString());
    }
    try
    {
      paramString = new JSONObject(paramString);
      TraceReportUtil.a(paramString.optInt("featureId"), paramString.optString("receiveUin"));
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow][TraceReportPlugin]", 1, "handleTraceBegin:", paramString);
    }
    return null;
  }
  
  private final String c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTraceEnd, reqData: ");
      localStringBuilder.append(paramString);
      QLog.i("[cmshow][TraceReportPlugin]", 1, localStringBuilder.toString());
    }
    for (;;)
    {
      try
      {
        j = new JSONObject(paramString).optInt("featureId");
        if (j == TraceReportUtil.c(1)) {
          break label144;
        }
        if (j != TraceReportUtil.c(2)) {
          break label139;
        }
      }
      catch (Throwable paramString)
      {
        int j;
        QLog.e("[cmshow][TraceReportPlugin]", 1, "handleTraceEnd:", paramString);
      }
      if (i != 0) {
        TraceReportUtil.a(j, null, new int[] { TraceMappingIml.a(j, false, this.d.d, -1, true) });
      }
      TraceReportUtil.b(j);
      if (i != 0)
      {
        TraceReportUtil.a(TraceReportUtil.c(this.d.i), false);
        return null;
      }
      return null;
      label139:
      int i = 0;
      continue;
      label144:
      i = 1;
    }
  }
  
  private final String d(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleTraceSpanBegin, reqData:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("[cmshow][TraceReportPlugin]", 1, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        j = ((JSONObject)localObject).optInt("featureId");
        k = ((JSONObject)localObject).optInt("spanId");
        paramString = ((JSONObject)localObject).optString("msg");
        l2 = ((JSONObject)localObject).optLong("timestamp");
        localObject = ((JSONObject)localObject).optString("spanDesc");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        l1 = 0L;
        if (bool) {
          break label172;
        }
        i = ApolloUtilImpl.getSpriteSpanExtKey(k);
        if (i <= 0) {
          break label169;
        }
        l1 = ApolloUtilImpl.getFirstIntegerFromStr((String)localObject);
      }
      catch (Throwable paramString)
      {
        int j;
        int k;
        long l2;
        QLog.e("[cmshow][TraceReportPlugin]", 1, "handleTraceSpanBegin:", paramString);
      }
      TraceReportUtil.a(j, null, k, -100, l2, i, l1, new Object[] { paramString });
      return null;
      label169:
      continue;
      label172:
      long l1 = 0L;
      int i = 0;
    }
  }
  
  private final String e(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleTraceSpanEnd, reqData:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("[cmshow][TraceReportPlugin]", 1, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        j = ((JSONObject)localObject).optInt("featureId");
        k = ((JSONObject)localObject).optInt("spanId");
        m = ((JSONObject)localObject).optInt("errCode");
        paramString = ((JSONObject)localObject).optString("msg");
        l2 = ((JSONObject)localObject).optLong("timestamp");
        localObject = ((JSONObject)localObject).optString("spanDesc");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        l1 = 0L;
        if (bool) {
          break label181;
        }
        i = ApolloUtilImpl.getSpriteSpanExtKey(k);
        if (i <= 0) {
          break label178;
        }
        l1 = ApolloUtilImpl.getFirstIntegerFromStr((String)localObject);
      }
      catch (Throwable paramString)
      {
        int j;
        int k;
        int m;
        long l2;
        QLog.e("[cmshow][TraceReportPlugin]", 1, "handleTraceSpanEnd:", paramString);
      }
      TraceReportUtil.a(j, null, k, m, l2, i, l1, new Object[] { paramString });
      return null;
      label178:
      continue;
      label181:
      long l1 = 0L;
      int i = 0;
    }
  }
  
  private final String f(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("featureId");
      int j = paramString.optInt("spanId");
      String str = paramString.optString("msg");
      TraceReportUtil.a(i, j, -100, paramString.optLong("timestamp"), new Object[] { str });
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow][TraceReportPlugin]", 1, "handleTraceLog:", paramString);
    }
    return null;
  }
  
  private final String g(String paramString)
  {
    try
    {
      QLog.d("[cmshow][TraceReportPlugin]", 1, new Object[] { "handleJsError mSpriteFrom:", Integer.valueOf(this.d.i) });
      paramString = new JSONObject(paramString).optString("data");
      TraceReportUtil.a(TraceReportUtil.c(this.d.i), 1000, 50, new Object[] { paramString });
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow][TraceReportPlugin]", 1, "handleJsError:", (Throwable)paramString);
    }
    return null;
  }
  
  @NotNull
  public PluginCmdConstant.PlugPriority a()
  {
    return this.c;
  }
  
  @Nullable
  public String a(@NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "argument");
    String str = paramArgument.f();
    switch (str.hashCode())
    {
    default: 
      break;
    case 1845576411: 
      if (str.equals("cs.trace_span_end.local")) {
        return e(paramArgument.e());
      }
      break;
    case 1439065070: 
      if (str.equals("cs.trace_begin.local")) {
        return b(paramArgument.e());
      }
      break;
    case 1183980393: 
      if (str.equals("cs.trace_span_begin.local")) {
        return d(paramArgument.e());
      }
      break;
    case 146460745: 
      if (str.equals("cs.trace_log.local")) {
        return f(paramArgument.e());
      }
      break;
    case -196613984: 
      if (str.equals("cs.trace_end.local")) {
        return c(paramArgument.e());
      }
      break;
    case -857476158: 
      if (str.equals("cs.xy_error_info.local")) {
        return g(paramArgument.e());
      }
      break;
    }
    return null;
  }
  
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    return IEventPlugin.DefaultImpls.a(this, paramString);
  }
  
  @NotNull
  public List<String> c()
  {
    return e;
  }
  
  public boolean d()
  {
    return IEventPlugin.DefaultImpls.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.TraceReportPlugin
 * JD-Core Version:    0.7.0.1
 */