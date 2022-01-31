package com.tencent.qqmini.proxyimpl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class VideoJsProxyImpl$2$2
  implements DialogInterface.OnClickListener
{
  VideoJsProxyImpl$2$2(VideoJsProxyImpl.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoJsProxyImpl.access$300(this.this$1.this$0, this.this$1.val$context, this.this$1.val$duration, this.this$1.val$compressed);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.2.2
 * JD-Core Version:    0.7.0.1
 */