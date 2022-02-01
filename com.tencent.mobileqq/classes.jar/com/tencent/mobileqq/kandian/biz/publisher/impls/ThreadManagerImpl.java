package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.tkd.topicsdk.interfaces.IThreadManager;
import com.tencent.tkd.topicsdk.interfaces.ThreadType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ThreadManagerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IThreadManager;", "()V", "post", "", "threadType", "Lcom/tencent/tkd/topicsdk/interfaces/ThreadType;", "runnable", "Ljava/lang/Runnable;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ThreadManagerImpl
  implements IThreadManager
{
  public void a(@NotNull ThreadType paramThreadType, @NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramThreadType, "threadType");
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    int i = ThreadManagerImpl.WhenMappings.$EnumSwitchMapping$0[paramThreadType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          ThreadManagerV2.executeOnNetWorkThread(paramRunnable);
          return;
        }
        ThreadManagerV2.executeOnFileThread(paramRunnable);
        return;
      }
      ThreadManagerV2.executeOnSubThread(paramRunnable);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ThreadManagerImpl
 * JD-Core Version:    0.7.0.1
 */