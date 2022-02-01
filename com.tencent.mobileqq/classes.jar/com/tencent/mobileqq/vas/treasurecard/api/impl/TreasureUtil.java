package com.tencent.mobileqq.vas.treasurecard.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/treasurecard/api/impl/TreasureUtil;", "", "()V", "clearSimCache", "", "getCardState", "", "getSp", "Landroid/content/SharedPreferences;", "isNeedActiveReq", "", "activeReqInterval", "", "isNeedRequest", "if4ReqInterval", "updateActiveInfo", "url", "", "tips", "updateActiveLastTime", "lastActiveTime", "updateCardState", "cardState", "updateFlowThreshold", "flowThreshold", "flowThresholdText", "updateNextReqTime", "nextReqTime", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class TreasureUtil
{
  public static final TreasureUtil a = new TreasureUtil();
  
  public final int a()
  {
    return c().getInt("treasure_card", -1);
  }
  
  public final void a(int paramInt)
  {
    c().edit().putInt("treasure_card", paramInt).apply();
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "flowThresholdText");
    Object localObject = c().edit();
    ((SharedPreferences.Editor)localObject).putInt("flowThreshold", paramInt);
    ((SharedPreferences.Editor)localObject).putString("flowThresholdText", paramString);
    ((SharedPreferences.Editor)localObject).apply();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateFlowThreshold flowThreshold:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" flowThresholdText:");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("treasureCard", 2, ((StringBuilder)localObject).toString());
  }
  
  public final void a(long paramLong)
  {
    c().edit().putLong("tc_next_req_time", paramLong).apply();
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "tips");
    c().edit().putString("tc_active_url", paramString1).putString("tc_active_tips", paramString2).apply();
  }
  
  public final void b()
  {
    a(0L);
    b(0L);
    a(-1);
    a("", "");
  }
  
  public final void b(long paramLong)
  {
    c().edit().putLong("tc_last_active_time", paramLong).apply();
  }
  
  @NotNull
  public final SharedPreferences c()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("TreasureCardFile_", 4);
    Intrinsics.checkExpressionValueIsNotNull(localSharedPreferences, "MobileQQ.getContext().ge…ntext.MODE_MULTI_PROCESS)");
    return localSharedPreferences;
  }
  
  public final boolean c(long paramLong)
  {
    long l1 = c().getLong("tc_next_req_time", 0L);
    long l2 = System.currentTimeMillis() / 1000;
    if (l2 < l1) {
      return false;
    }
    a(l2 + paramLong);
    return true;
  }
  
  public final boolean d(long paramLong)
  {
    long l1 = c().getLong("tc_last_active_time", 0L);
    long l2 = System.currentTimeMillis() / 1000;
    if (l2 < l1 + paramLong) {
      return true;
    }
    b(l2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.TreasureUtil
 * JD-Core Version:    0.7.0.1
 */