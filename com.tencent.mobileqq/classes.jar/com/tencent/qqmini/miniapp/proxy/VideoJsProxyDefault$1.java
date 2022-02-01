package com.tencent.qqmini.miniapp.proxy;

import android.app.Activity;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

class VideoJsProxyDefault$1
  implements Runnable
{
  VideoJsProxyDefault$1(VideoJsProxyDefault paramVideoJsProxyDefault, Activity paramActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, VideoJsProxyDefault.BridgeInfo paramBridgeInfo) {}
  
  public void run()
  {
    DialogUtil.createCustomDialog(this.val$context, 230, "视频选择", "请选择获取视频方式", "相册", "拍摄", new VideoJsProxyDefault.1.1(this), new VideoJsProxyDefault.1.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.1
 * JD-Core Version:    0.7.0.1
 */