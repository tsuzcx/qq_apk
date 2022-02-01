package com.tencent.rmonitor.common.util;

import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.thread.ThreadManager.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/AsyncSPEditor;", "", "editor", "Landroid/content/SharedPreferences$Editor;", "(Landroid/content/SharedPreferences$Editor;)V", "apply", "", "commit", "", "putBoolean", "key", "", "value", "putFloat", "", "putInt", "", "putLong", "", "putString", "CommitRunnable", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class AsyncSPEditor
{
  public static final AsyncSPEditor.Companion a = new AsyncSPEditor.Companion(null);
  private final SharedPreferences.Editor b;
  
  public AsyncSPEditor(@Nullable SharedPreferences.Editor paramEditor)
  {
    this.b = paramEditor;
  }
  
  @NotNull
  public final AsyncSPEditor a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    SharedPreferences.Editor localEditor = this.b;
    if (localEditor != null) {
      localEditor.putInt(paramString, paramInt);
    }
    return this;
  }
  
  @NotNull
  public final AsyncSPEditor a(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    SharedPreferences.Editor localEditor = this.b;
    if (localEditor != null) {
      localEditor.putLong(paramString, paramLong);
    }
    return this;
  }
  
  @NotNull
  public final AsyncSPEditor a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    SharedPreferences.Editor localEditor = this.b;
    if (localEditor != null) {
      localEditor.putString(paramString1, paramString2);
    }
    return this;
  }
  
  @NotNull
  public final AsyncSPEditor a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    SharedPreferences.Editor localEditor = this.b;
    if (localEditor != null) {
      localEditor.putBoolean(paramString, paramBoolean);
    }
    return this;
  }
  
  public final boolean a()
  {
    SharedPreferences.Editor localEditor = this.b;
    if (localEditor != null) {
      new Handler(ThreadManager.a.a()).post((Runnable)new AsyncSPEditor.CommitRunnable(this, localEditor));
    }
    return true;
  }
  
  public final void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.AsyncSPEditor
 * JD-Core Version:    0.7.0.1
 */