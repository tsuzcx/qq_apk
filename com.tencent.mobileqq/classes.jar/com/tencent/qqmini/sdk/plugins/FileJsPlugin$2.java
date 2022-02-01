package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import java.util.Map;
import org.json.JSONObject;

class FileJsPlugin$2
  implements Runnable
{
  FileJsPlugin$2(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2, String paramString3, MiniAppFileManager paramMiniAppFileManager, int paramInt, JSONObject paramJSONObject, String paramString4, Map paramMap) {}
  
  public void run()
  {
    FileJsPlugin.2.1 local1 = new FileJsPlugin.2.1(this);
    ((DownloaderProxy)ProxyManager.get(DownloaderProxy.class)).download(this.val$downloadUrl, this.val$header, this.val$filePath, 60, local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */