package com.tencent.mobileqq.kandian.biz.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class RIJRewardTaskLocalRepo$sp$2
  extends Lambda
  implements Function0<SharedPreferences>
{
  public static final 2 INSTANCE = new 2();
  
  RIJRewardTaskLocalRepo$sp$2()
  {
    super(0);
  }
  
  public final SharedPreferences invoke()
  {
    return PreferenceManager.getDefaultSharedPreferences((Context)BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskLocalRepo.sp.2
 * JD-Core Version:    0.7.0.1
 */