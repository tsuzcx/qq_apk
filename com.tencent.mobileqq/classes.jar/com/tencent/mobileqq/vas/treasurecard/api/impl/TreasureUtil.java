package com.tencent.mobileqq.vas.treasurecard.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/treasurecard/api/impl/TreasureUtil;", "", "()V", "getCardState", "", "getSp", "Landroid/content/SharedPreferences;", "isNeedRequest", "", "updateActiveInfo", "", "url", "", "tips", "updateCardState", "cardState", "updateNextReqTime", "nextReqTime", "", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class TreasureUtil
{
  public static final TreasureUtil a = new TreasureUtil();
  
  public final int a()
  {
    return a().getInt("treasure_card", -1);
  }
  
  @NotNull
  public final SharedPreferences a()
  {
    Object localObject = MobileQQ.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TreasureCardFile_");
    localStringBuilder.append(VasUtil.a());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MobileQQ.getContext().ge…ntext.MODE_MULTI_PROCESS)");
    return localObject;
  }
  
  public final void a(int paramInt)
  {
    a().edit().putInt("treasure_card", paramInt).apply();
  }
  
  public final void a(long paramLong)
  {
    a().edit().putLong("tc_next_req_time", paramLong).apply();
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramString2, "tips");
    a().edit().putString("tc_active_url", paramString1).putString("tc_active_tips", paramString2).apply();
  }
  
  public final boolean a()
  {
    long l = a().getLong("tc_next_req_time", 0L);
    return System.currentTimeMillis() / 1000 >= l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.impl.TreasureUtil
 * JD-Core Version:    0.7.0.1
 */