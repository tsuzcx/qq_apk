package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.AnyThread;
import com.tencent.qqmini.minigame.helper.PreloadStorageHelper;
import com.tencent.qqmini.minigame.helper.PreloadSystemInfoHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/manager/HeavyPluginPreloadManager;", "", "()V", "doPreload", "", "activity", "Landroid/app/Activity;", "appId", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class HeavyPluginPreloadManager
{
  public static final HeavyPluginPreloadManager a = new HeavyPluginPreloadManager();
  
  @JvmStatic
  @AnyThread
  public static final void a(@Nullable Activity paramActivity, @Nullable String paramString)
  {
    if (paramActivity != null)
    {
      PreloadSystemInfoHelper.a(paramActivity);
      PreloadStorageHelper.a((Context)paramActivity, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.HeavyPluginPreloadManager
 * JD-Core Version:    0.7.0.1
 */