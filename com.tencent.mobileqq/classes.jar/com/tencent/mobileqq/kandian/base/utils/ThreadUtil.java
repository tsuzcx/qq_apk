package com.tencent.mobileqq.kandian.base.utils;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/ThreadUtil;", "", "()V", "runOnUIThread", "", "runnable", "Ljava/lang/Runnable;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ThreadUtil
{
  public static final ThreadUtil a = new ThreadUtil();
  
  @JvmStatic
  public static final void a(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      paramRunnable.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */