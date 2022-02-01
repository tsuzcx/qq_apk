package com.tencent.tkd.topicsdk.framework;

import android.os.Handler;
import com.tencent.tkd.topicsdk.interfaces.ThreadType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"dbThread", "", "runnable", "Lkotlin/Function0;", "fileThread", "networkThread", "normalThread", "uiThread", "delay", "", "topicsdk-framework_release"}, k=2, mv={1, 1, 16})
public final class ThreadManagerKt
{
  public static final void a(long paramLong, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    ThreadManager.a.a().postDelayed((Runnable)new ThreadManagerKt.sam.java_lang_Runnable.0(paramFunction0), paramLong);
  }
  
  public static final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    ThreadManager.a.a().post((Runnable)new ThreadManagerKt.sam.java_lang_Runnable.0(paramFunction0));
  }
  
  public static final void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    ThreadManager.a.a(ThreadType.NORMAL, paramFunction0);
  }
  
  public static final void c(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    ThreadManager.a.a(ThreadType.FILE, paramFunction0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.ThreadManagerKt
 * JD-Core Version:    0.7.0.1
 */