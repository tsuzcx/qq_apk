package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import org.json.JSONObject;

class FileJsPlugin$4
  implements Runnable
{
  FileJsPlugin$4(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener, JSONObject paramJSONObject) {}
  
  public void run()
  {
    MiniappDownloadUtil.getInstance().download(this.val$finalUrl, this.val$filePath, false, this.val$listener, Downloader.DownloadMode.OkHttpMode, this.val$headerObj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */