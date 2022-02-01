package com.tencent.timi.game.tim.api.impl;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.env.ServerEnv;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class TimiGameTimApiImpl$sp$2
  extends Lambda
  implements Function0<SharedPreferences>
{
  public static final 2 INSTANCE = new 2();
  
  TimiGameTimApiImpl$sp$2()
  {
    super(0);
  }
  
  public final SharedPreferences invoke()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tg_common_im_");
    localStringBuilder.append(ServerEnv.c());
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl.sp.2
 * JD-Core Version:    0.7.0.1
 */