package com.tencent.qqmini.minigame.helper;

import android.content.Context;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/helper/PreloadStorageHelper;", "", "()V", "preload", "", "context", "Landroid/content/Context;", "appId", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class PreloadStorageHelper
{
  public static final PreloadStorageHelper a = new PreloadStorageHelper();
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool((Runnable)new PreloadStorageHelper.preload.1(new WeakReference(paramContext), paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.helper.PreloadStorageHelper
 * JD-Core Version:    0.7.0.1
 */