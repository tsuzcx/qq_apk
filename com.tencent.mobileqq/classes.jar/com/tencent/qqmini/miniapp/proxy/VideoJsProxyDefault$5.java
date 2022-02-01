package com.tencent.qqmini.miniapp.proxy;

import com.tencent.qqmini.miniapp.util.VideoCompress.Listener;
import com.tencent.qqmini.miniapp.util.VideoCompress.Option;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;
import java.io.File;
import java.util.Locale;

class VideoJsProxyDefault$5
  implements VideoCompress.Listener
{
  VideoJsProxyDefault$5(VideoJsProxyDefault paramVideoJsProxyDefault, long paramLong, VideoCompress.Option paramOption, LocalMediaInfo paramLocalMediaInfo, String paramString, VideoJsProxyDefault.BridgeInfo paramBridgeInfo) {}
  
  public void onFailure(String paramString)
  {
    paramString = paramString.split("\n");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      QMLog.w("VideoJsProxyImpl", "onFailure: " + str);
      i += 1;
    }
    if (this.val$option.scale > 0)
    {
      VideoJsProxyDefault.access$700(this.this$0, this.val$info, false, this.val$bridgeInfo);
      return;
    }
    paramString = ((MiniAppFileManager)VideoJsProxyDefault.access$500(this.this$0).getManager(MiniAppFileManager.class)).getWxFilePath(this.val$info.path);
    VideoJsProxyDefault.access$600(this.this$0, paramString, this.val$info.fileSize, this.val$info, this.val$bridgeInfo);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    QMLog.d("VideoJsProxyImpl", "compress finish " + paramBoolean + " " + (System.currentTimeMillis() - this.val$now));
  }
  
  public void onProgress(String paramString, float paramFloat)
  {
    if (paramFloat * 100.0F < 100.0F) {
      VideoJsProxyDefault.access$800(this.this$0, "正在压缩 " + String.format(Locale.getDefault(), "%.0f%%", new Object[] { Float.valueOf(100.0F * paramFloat) }));
    }
  }
  
  public void onStart()
  {
    QMLog.d("VideoJsProxyImpl", "compress start");
  }
  
  public void onSuccess(String paramString)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("VideoJsProxyImpl", "compress success " + paramString);
    }
    if (this.val$option.scale > 0)
    {
      paramString = this.val$info;
      paramString.mediaWidth /= this.val$option.scale;
      paramString = this.val$info;
      paramString.mediaHeight /= this.val$option.scale;
    }
    paramString = ((MiniAppFileManager)VideoJsProxyDefault.access$500(this.this$0).getManager(MiniAppFileManager.class)).getWxFilePath(this.val$outPath);
    VideoJsProxyDefault.access$600(this.this$0, paramString, new File(this.val$outPath).length(), this.val$info, this.val$bridgeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.5
 * JD-Core Version:    0.7.0.1
 */