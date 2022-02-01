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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("start copy from ");
    ((StringBuilder)localObject1).append(this.val$info.path);
    QMLog.i("VideoJsProxyImpl", ((StringBuilder)localObject1).toString());
    localObject1 = ((MiniAppFileManager)VideoJsProxyDefault.access$500(this.this$0).getManager(MiniAppFileManager.class)).getTmpPath(this.val$suffix);
    if (((String)localObject1).contains(" "))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("wrong copy path ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QMLog.w("VideoJsProxyImpl", ((StringBuilder)localObject2).toString());
      localObject1 = ((MiniAppFileManager)VideoJsProxyDefault.access$500(this.this$0).getManager(MiniAppFileManager.class)).getWxFilePath(this.val$info.path);
      VideoJsProxyDefault.access$600(this.this$0, (String)localObject1, this.val$info.fileSize, this.val$info, this.val$bridgeInfo);
      return;
    }
    Object localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    if (FileUtils.copyFile(new File(this.val$info.path), (File)localObject2))
    {
      localObject2 = this.val$info;
      ((LocalMediaInfo)localObject2).path = ((String)localObject1);
      VideoJsProxyDefault.access$700(this.this$0, (LocalMediaInfo)localObject2, this.val$changeSize, this.val$bridgeInfo);
      return;
    }
    QMLog.w("VideoJsProxyImpl", "copy file failed");
    localObject1 = ((MiniAppFileManager)VideoJsProxyDefault.access$500(this.this$0).getManager(MiniAppFileManager.class)).getWxFilePath(this.val$info.path);
    VideoJsProxyDefault.access$600(this.this$0, (String)localObject1, this.val$info.fileSize, this.val$info, this.val$bridgeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.4
 * JD-Core Version:    0.7.0.1
 */