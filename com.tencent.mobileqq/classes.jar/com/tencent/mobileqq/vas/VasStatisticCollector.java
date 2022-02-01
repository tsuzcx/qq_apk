package com.tencent.mobileqq.vas;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.statistics.QQUserAction;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/VasStatisticCollector;", "", "()V", "APP_KEY", "", "TAG", "hit", "", "calculateHit", "i", "", "calculateHit$vas_temp_api_release", "isHit", "report", "", "eventCode", "elapse", "", "params", "", "Lkotlin/Pair;", "(Ljava/lang/String;J[Lkotlin/Pair;)V", "", "reportReal", "isReal", "isImmediately", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class VasStatisticCollector
{
  public static final VasStatisticCollector a;
  private static final boolean b;
  
  static
  {
    VasStatisticCollector localVasStatisticCollector = new VasStatisticCollector();
    a = localVasStatisticCollector;
    UserAction.registerTunnel(new TunnelInfo("00000TEDPU36RWUZ", AppSetting.h(), "1000"));
    b = localVasStatisticCollector.a(100);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, long paramLong, @Nullable Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    if (!b) {
      return;
    }
    a(paramString, paramMap, paramLong, false, false, 24, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, long paramLong, @NotNull Pair<String, String>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "params");
    if (!b) {
      return;
    }
    a(paramString, paramLong, MapsKt.toMutableMap(MapsKt.toMap(paramVarArgs)));
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, @Nullable Map<String, String> paramMap, long paramLong)
  {
    a(paramString, paramMap, paramLong, false, false, 24, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, @Nullable Map<String, String> paramMap, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("eventCode=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", elapse=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", params=");
      ((StringBuilder)localObject).append(String.valueOf(paramMap));
      QLog.e("VasStatisticCollector", 1, ((StringBuilder)localObject).toString());
    }
    if (paramMap == null)
    {
      paramMap = new HashMap();
      paramMap.put("qquin", VasUtil.e());
      paramMap.put("cost_time", String.valueOf(paramLong));
      paramMap.put("consume_time", String.valueOf(paramLong));
      QQUserAction.a("00000TEDPU36RWUZ", paramString, true, paramLong, -1L, (Map)paramMap, paramBoolean1, paramBoolean2);
      return;
    }
    Object localObject = VasUtil.e();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "VasUtil.getCurrentUin()");
    paramMap.put("qquin", localObject);
    paramMap.put("cost_time", String.valueOf(paramLong));
    paramMap.put("consume_time", String.valueOf(paramLong));
    QQUserAction.a("00000TEDPU36RWUZ", paramString, true, paramLong, -1L, paramMap, paramBoolean1, paramBoolean2);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void a(@NotNull String paramString, @NotNull Pair<String, String>... paramVarArgs)
  {
    a(paramString, 0L, paramVarArgs, 2, null);
  }
  
  @JvmStatic
  public static final boolean a()
  {
    return b;
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void b(@NotNull String paramString, long paramLong, @NotNull Pair<String, String>... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventCode");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "params");
    a(paramString, MapsKt.toMutableMap(MapsKt.toMap(paramVarArgs)), paramLong, false, false, 24, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void b(@NotNull String paramString, @NotNull Pair<String, String>... paramVarArgs)
  {
    b(paramString, 0L, paramVarArgs, 2, null);
  }
  
  public final boolean a(int paramInt)
  {
    double d1 = paramInt;
    double d2 = Math.random();
    Double.isNaN(d1);
    return MathKt.roundToInt(Math.floor(d1 * d2)) == paramInt / 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasStatisticCollector
 * JD-Core Version:    0.7.0.1
 */