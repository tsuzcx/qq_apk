package com.tencent.qqmini.minigame.plugins;

import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.qqmini.minigame.GameJsService;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.utils.OpenDataDomainUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameFileJsPlugin$downloadWithCache$doDownload$1
  implements Runnable
{
  GameFileJsPlugin$downloadWithCache$doDownload$1(GameFileJsPlugin paramGameFileJsPlugin, RequestEvent paramRequestEvent) {}
  
  public final void run()
  {
    long l;
    try
    {
      Object localObject1 = new JSONObject(this.$req.jsonParams);
      l = System.currentTimeMillis();
      localObject1 = ((JSONObject)localObject1).optString("url");
      if (!URLUtil.isValidUrl((String)localObject1))
      {
        this.$req.fail("invalid url");
        return;
      }
      if (!GameFileJsPlugin.access$getMIsMiniGame$p(this.this$0)) {
        break label125;
      }
      localObject2 = this.$req.jsService;
      if (localObject2 == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.qqmini.minigame.GameJsService");
      }
    }
    catch (JSONException localJSONException)
    {
      this.$req.fail("downloadWithCache exception");
      return;
    }
    if ((((GameJsService)localObject2).getContextType() == ScriptContextType.OPEN_DATA) && (!OpenDataDomainUtil.getInstance().isDomainValid(localJSONException)))
    {
      this.$req.fail("invalid url");
      return;
    }
    label125:
    Object localObject2 = GameFileJsPlugin.access$getFileManager$p(this.this$0);
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((MiniAppFileManager)localObject2).getTmpPathByUrl(localJSONException);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(localJSONException, null, (String)localObject2, 60, (DownloaderProxy.DownloadListener)new GameFileJsPlugin.downloadWithCache.doDownload.1.1(this, l, localJSONException, (String)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.GameFileJsPlugin.downloadWithCache.doDownload.1
 * JD-Core Version:    0.7.0.1
 */