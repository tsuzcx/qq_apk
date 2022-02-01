package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qqmini/minigame/plugins/GameFileJsPlugin$downloadWithCache$doDownload$1$1", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;", "onDownloadFailed", "", "statusCode", "", "errorMsg", "", "onDownloadHeadersReceived", "headers", "", "", "onDownloadProgress", "progress", "", "totalBytesWritten", "", "totalBytesExpectedToWrite", "onDownloadSucceed", "filePath", "result", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class GameFileJsPlugin$downloadWithCache$doDownload$1$1
  implements DownloaderProxy.DownloadListener
{
  GameFileJsPlugin$downloadWithCache$doDownload$1$1(long paramLong, String paramString1, String paramString2) {}
  
  public void onDownloadFailed(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    long l = System.currentTimeMillis() - this.$startMS;
    String str = GameFileJsPlugin.access$getTAG$p(this.this$0.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doDownloadWithCache failed [timecost = ");
    localStringBuilder.append(l);
    localStringBuilder.append("ms], url:");
    localStringBuilder.append(this.$url);
    QMLog.i(str, localStringBuilder.toString());
    this.this$0.$req.fail(paramString);
    paramString = this.this$0.this$0;
    str = this.$url;
    Intrinsics.checkExpressionValueIsNotNull(str, "url");
    GameFileJsPlugin.access$reportDownloadWithCache(paramString, l, paramInt, str);
  }
  
  public void onDownloadHeadersReceived(int paramInt, @NotNull Map<String, ? extends List<String>> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "headers");
  }
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, @NotNull String paramString, @NotNull DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    Intrinsics.checkParameterIsNotNull(paramDownloadResult, "result");
    long l = System.currentTimeMillis() - this.$startMS;
    paramString = GameFileJsPlugin.access$getTAG$p(this.this$0.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doDownloadWithCache success [timecost = ");
    localStringBuilder.append(l);
    localStringBuilder.append("ms] url:");
    localStringBuilder.append(this.$url);
    localStringBuilder.append(", save to file:");
    localStringBuilder.append(this.$tmpFilePath);
    QMLog.i(paramString, localStringBuilder.toString());
    paramString = new JSONObject();
    try
    {
      paramString.put("statusCode", paramDownloadResult.httpStatusCode);
      paramDownloadResult = GameFileJsPlugin.access$getFileManager$p(this.this$0.this$0);
      if (paramDownloadResult == null) {
        Intrinsics.throwNpe();
      }
      paramString.put("tempFilePath", paramDownloadResult.getWxFilePath(this.$tmpFilePath));
      this.this$0.$req.ok(paramString);
      paramString = this.this$0.this$0;
      paramDownloadResult = this.$url;
      Intrinsics.checkExpressionValueIsNotNull(paramDownloadResult, "url");
      GameFileJsPlugin.access$reportDownloadWithCache(paramString, l, paramInt, paramDownloadResult);
      return;
    }
    catch (JSONException paramString)
    {
      paramDownloadResult = GameFileJsPlugin.access$getTAG$p(this.this$0.this$0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doDownloadWithCache exception, url:");
      localStringBuilder.append(this.$url);
      QMLog.i(paramDownloadResult, localStringBuilder.toString(), (Throwable)paramString);
      this.this$0.$req.fail("download exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.GameFileJsPlugin.downloadWithCache.doDownload.1.1
 * JD-Core Version:    0.7.0.1
 */