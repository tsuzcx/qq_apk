package com.tencent.qapmsdk.common.util;

import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadManager.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/AsyncSPEditor;", "", "editor", "Landroid/content/SharedPreferences$Editor;", "(Landroid/content/SharedPreferences$Editor;)V", "apply", "", "commit", "", "putBoolean", "key", "", "value", "putFloat", "", "putInt", "", "putLong", "", "putString", "CommitRunnable", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class AsyncSPEditor
{
  public static final AsyncSPEditor.Companion Companion = new AsyncSPEditor.Companion(null);
  private static final String TAG = "QAPM_common_AsyncSPEditor";
  private final SharedPreferences.Editor editor;
  
  public AsyncSPEditor(@Nullable SharedPreferences.Editor paramEditor)
  {
    this.editor = paramEditor;
  }
  
  public final void apply()
  {
    commit();
  }
  
  public final boolean commit()
  {
    SharedPreferences.Editor localEditor = this.editor;
    if (localEditor != null) {
      new Handler(ThreadManager.Companion.getMonitorThreadLooper()).post((Runnable)new AsyncSPEditor.CommitRunnable(this, localEditor));
    }
    return true;
  }
  
  @NotNull
  public final AsyncSPEditor putBoolean(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    SharedPreferences.Editor localEditor = this.editor;
    if (localEditor != null) {
      localEditor.putBoolean(paramString, paramBoolean);
    }
    return this;
  }
  
  @NotNull
  public final AsyncSPEditor putFloat(@NotNull String paramString, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    SharedPreferences.Editor localEditor = this.editor;
    if (localEditor != null) {
      localEditor.putFloat(paramString, paramFloat);
    }
    return this;
  }
  
  @NotNull
  public final AsyncSPEditor putInt(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    SharedPreferences.Editor localEditor = this.editor;
    if (localEditor != null) {
      localEditor.putInt(paramString, paramInt);
    }
    return this;
  }
  
  @NotNull
  public final AsyncSPEditor putLong(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    SharedPreferences.Editor localEditor = this.editor;
    if (localEditor != null) {
      localEditor.putLong(paramString, paramLong);
    }
    return this;
  }
  
  @NotNull
  public final AsyncSPEditor putString(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    SharedPreferences.Editor localEditor = this.editor;
    if (localEditor != null) {
      localEditor.putString(paramString1, paramString2);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.AsyncSPEditor
 * JD-Core Version:    0.7.0.1
 */