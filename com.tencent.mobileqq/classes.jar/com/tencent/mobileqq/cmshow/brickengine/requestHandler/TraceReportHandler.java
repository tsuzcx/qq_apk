package com.tencent.mobileqq.cmshow.brickengine.requestHandler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.statistics.trace.TraceMappingIml;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/requestHandler/TraceReportHandler;", "Lcom/tencent/mobileqq/apollo/channel/IRequestHandler;", "mSpriteContext", "Lcom/tencent/mobileqq/apollo/script/SpriteContext;", "(Lcom/tencent/mobileqq/apollo/script/SpriteContext;)V", "getMSpriteContext", "()Lcom/tencent/mobileqq/apollo/script/SpriteContext;", "setMSpriteContext", "getHandlePriority", "", "handleCmd", "Lcom/tencent/mobileqq/apollo/channel/HandleResult;", "jsState", "", "cmd", "", "reqData", "handleTraceBegin", "handleTraceEnd", "handleTraceLog", "handleTraceSpanBegin", "handleTraceSpanEnd", "onVerifyCm3d", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class TraceReportHandler
  implements IRequestHandler
{
  @NotNull
  private SpriteContext a;
  
  private final HandleResult a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      TraceReportUtil.a(paramString.optInt("featureId"), paramString.optString("receiveUin"));
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "handleTraceBegin:", paramString);
    }
    return null;
  }
  
  private final boolean a()
  {
    if (TextUtils.isEmpty((CharSequence)ApolloConstant.M)) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ApolloConstant.N);
    localStringBuilder.append("cm3d.js");
    return new File(localStringBuilder.toString()).exists();
  }
  
  private final HandleResult b(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("featureId");
      if ((i == TraceReportUtil.a(1)) || (i == TraceReportUtil.a(2))) {
        TraceReportUtil.a(i, null, new int[] { TraceMappingIml.a(i, false, this.a.b, -1, true) });
      }
      TraceReportUtil.b(i);
      if ((i == TraceReportUtil.a(1)) || (i == TraceReportUtil.a(2)))
      {
        TraceReportUtil.a(TraceReportUtil.a(this.a.d), false);
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "handleTraceEnd:", paramString);
    }
    return null;
  }
  
  private final HandleResult c(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        j = ((JSONObject)localObject).optInt("featureId");
        k = ((JSONObject)localObject).optInt("spanId");
        paramString = ((JSONObject)localObject).optString("msg");
        l2 = ((JSONObject)localObject).optLong("timestamp");
        localObject = ((JSONObject)localObject).optString("spanDesc");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        l1 = 0L;
        if (bool) {
          break label131;
        }
        i = ApolloUtilImpl.getSpriteSpanExtKey(k);
        if (i <= 0) {
          break label128;
        }
        l1 = ApolloUtilImpl.getFirstIntegerFromStr((String)localObject);
      }
      catch (Throwable paramString)
      {
        int j;
        int k;
        long l2;
        QLog.e("[cmshow][scripted]SpriteActionScript", 1, "handleTraceSpanBegin:", paramString);
      }
      TraceReportUtil.a(j, null, k, -100, l2, i, l1, new Object[] { paramString });
      return null;
      label128:
      continue;
      label131:
      long l1 = 0L;
      int i = 0;
    }
  }
  
  private final HandleResult d(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        j = ((JSONObject)localObject).optInt("featureId");
        k = ((JSONObject)localObject).optInt("spanId");
        m = ((JSONObject)localObject).optInt("errCode");
        paramString = ((JSONObject)localObject).optString("msg");
        l2 = ((JSONObject)localObject).optLong("timestamp");
        localObject = ((JSONObject)localObject).optString("spanDesc");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        l1 = 0L;
        if (bool) {
          break label171;
        }
        i = ApolloUtilImpl.getSpriteSpanExtKey(k);
        if (i <= 0) {
          break label168;
        }
        l1 = ApolloUtilImpl.getFirstIntegerFromStr((String)localObject);
      }
      catch (Throwable paramString)
      {
        int j;
        int k;
        int m;
        long l2;
        QLog.e("[cmshow][scripted]SpriteActionScript", 1, "handleTraceSpanEnd:", paramString);
      }
      TraceReportUtil.a(j, null, k, m, l2, i, l1, new Object[] { paramString });
      if ((m == 57) && (!a()))
      {
        QLog.w("[cmshow][scripted]SpriteAioScript", 1, "[onScriptNotExists], redownload base.zip");
        ApolloContentUpdateHandler.a((AppInterface)ApolloUtilImpl.getQQApp());
      }
      return null;
      label168:
      continue;
      label171:
      long l1 = 0L;
      int i = 0;
    }
  }
  
  private final HandleResult e(String paramString)
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
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "handleTraceLog:", paramString);
    }
    return null;
  }
  
  public int a()
  {
    return 300;
  }
  
  @Nullable
  public HandleResult a(long paramLong, @Nullable String paramString1, @Nullable String paramString2)
  {
    Object localObject = null;
    HandleResult localHandleResult = (HandleResult)null;
    if (Intrinsics.areEqual("cs.trace_begin.local", paramString1))
    {
      paramString1 = localObject;
      if (paramString2 != null) {
        paramString1 = a(paramString2);
      }
    }
    for (;;)
    {
      return paramString1;
      if (Intrinsics.areEqual("cs.trace_end.local", paramString1))
      {
        paramString1 = localObject;
        if (paramString2 != null) {
          paramString1 = b(paramString2);
        }
      }
      else if (Intrinsics.areEqual("cs.trace_span_begin.local", paramString1))
      {
        paramString1 = localObject;
        if (paramString2 != null) {
          paramString1 = c(paramString2);
        }
      }
      else if (Intrinsics.areEqual("cs.trace_span_end.local", paramString1))
      {
        paramString1 = localObject;
        if (paramString2 != null) {
          paramString1 = d(paramString2);
        }
      }
      else
      {
        if (!Intrinsics.areEqual("cs.trace_log.local", paramString1)) {
          break;
        }
        paramString1 = localObject;
        if (paramString2 != null) {
          paramString1 = e(paramString2);
        }
      }
    }
    return localHandleResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.requestHandler.TraceReportHandler
 * JD-Core Version:    0.7.0.1
 */