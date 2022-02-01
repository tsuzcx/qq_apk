package com.tencent.qqmini.miniapp.proxy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class VideoJsProxyDefault$1$1
  implements DialogInterface.OnClickListener
{
  VideoJsProxyDefault$1$1(VideoJsProxyDefault.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoJsProxyDefault.access$000(this.this$1.this$0, this.this$1.val$context, this.this$1.val$duration, this.this$1.val$compressed, this.this$1.val$isFront, this.this$1.val$bridgeInfo);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.1.1
 * JD-Core Version:    0.7.0.1
 */