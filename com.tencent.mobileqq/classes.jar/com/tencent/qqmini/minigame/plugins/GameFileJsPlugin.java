package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsPlugin
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/plugins/GameFileJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "()V", "TAG", "", "fileManager", "Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;", "downloadWithCache", "req", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "onCreate", "", "miniAppContext", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "reportDownloadWithCache", "timeCost", "", "responseCode", "", "url", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameFileJsPlugin
  extends BaseJsPlugin
{
  private final String TAG = "ImageJsPlugin";
  private MiniAppFileManager fileManager;
  
  private final void reportDownloadWithCache(long paramLong, int paramInt, String paramString)
  {
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    if (this.mIsMiniGame) {}
    for (String str = "1";; str = "0")
    {
      MiniReportManager.reportEventType(localMiniAppInfo, 1044, null, null, null, paramInt, str, paramLong, paramString);
      return;
    }
  }
  
  @JsEvent({"downloadWithCache"})
  @Nullable
  public final String downloadWithCache(@NotNull RequestEvent paramRequestEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestEvent, "req");
    ThreadManager.executeOnDiskIOThreadPool((Runnable)new GameFileJsPlugin.downloadWithCache.doDownload.1(this, paramRequestEvent));
    return "";
  }
  
  public void onCreate(@Nullable IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    if (this.mMiniAppInfo != null)
    {
      this.fileManager = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class));
      paramIMiniAppContext = this.fileManager;
      if (paramIMiniAppContext == null) {
        Intrinsics.throwNpe();
      }
      paramIMiniAppContext.setStorageLimit(this.mMiniAppInfo.usrFileSizeLimit);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.GameFileJsPlugin
 * JD-Core Version:    0.7.0.1
 */