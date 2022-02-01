package com.tencent.qqmini.miniapp.proxy;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;
import java.io.File;

class VideoJsProxyDefault$4
  implements Runnable
{
  VideoJsProxyDefault$4(VideoJsProxyDefault paramVideoJsProxyDefault, LocalMediaInfo paramLocalMediaInfo, String paramString, VideoJsProxyDefault.BridgeInfo paramBridgeInfo, boolean paramBoolean) {}
  
  public void run()
  {
    QMLog.i("VideoJsProxyImpl", "start copy from " + this.val$info.path);
    String str = ((MiniAppFileManager)VideoJsProxyDefault.access$500(this.this$0).getManager(MiniAppFileManager.class)).getTmpPath(this.val$suffix);
    if (str.contains(" "))
    {
      QMLog.w("VideoJsProxyImpl", "wrong copy path " + str);
      str = ((MiniAppFileManager)VideoJsProxyDefault.access$500(this.this$0).getManager(MiniAppFileManager.class)).getWxFilePath(this.val$info.path);
      VideoJsProxyDefault.access$600(this.this$0, str, this.val$info.fileSize, this.val$info, this.val$bridgeInfo);
      return;
    }
    File localFile = new File(str);
    if (localFile.exists()) {
      localFile.delete();
    }
    if (FileUtils.copyFile(new File(this.val$info.path), localFile))
    {
      this.val$info.path = str;
      VideoJsProxyDefault.access$700(this.this$0, this.val$info, this.val$changeSize, this.val$bridgeInfo);
      return;
    }
    QMLog.w("VideoJsProxyImpl", "copy file failed");
    str = ((MiniAppFileManager)VideoJsProxyDefault.access$500(this.this$0).getManager(MiniAppFileManager.class)).getWxFilePath(this.val$info.path);
    VideoJsProxyDefault.access$600(this.this$0, str, this.val$info.fileSize, this.val$info, this.val$bridgeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.4
 * JD-Core Version:    0.7.0.1
 */