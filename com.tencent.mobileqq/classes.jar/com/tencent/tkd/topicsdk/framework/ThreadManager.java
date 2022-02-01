package com.tencent.tkd.topicsdk.framework;

import android.os.Handler;
import android.os.Looper;
import com.tencent.tkd.topicsdk.interfaces.IThreadManager;
import com.tencent.tkd.topicsdk.interfaces.ThreadType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/ThreadManager;", "", "()V", "impl", "Lcom/tencent/tkd/topicsdk/interfaces/IThreadManager;", "getImpl", "()Lcom/tencent/tkd/topicsdk/interfaces/IThreadManager;", "setImpl", "(Lcom/tencent/tkd/topicsdk/interfaces/IThreadManager;)V", "uiHandler", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "init", "", "post", "threadType", "Lcom/tencent/tkd/topicsdk/interfaces/ThreadType;", "runnable", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class ThreadManager
{
  @NotNull
  public static IThreadManager a;
  public static final ThreadManager b = new ThreadManager();
  @NotNull
  private static final Handler c = new Handler(Looper.getMainLooper());
  
  @NotNull
  public final Handler a()
  {
    return c;
  }
  
  public final void a(@NotNull IThreadManager paramIThreadManager)
  {
    Intrinsics.checkParameterIsNotNull(paramIThreadManager, "impl");
    a = paramIThreadManager;
  }
  
  public final void a(@NotNull ThreadType paramThreadType, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramThreadType, "threadType");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    IThreadManager localIThreadManager = a;
    if (localIThreadManager == null) {
      Intrinsics.throwUninitializedPropertyAccessException("impl");
    }
    localIThreadManager.a(paramThreadType, (Runnable)new ThreadManagerKt.sam.java_lang_Runnable.0(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.ThreadManager
 * JD-Core Version:    0.7.0.1
 */