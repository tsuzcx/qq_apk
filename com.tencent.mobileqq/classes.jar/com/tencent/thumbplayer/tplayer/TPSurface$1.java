package com.tencent.thumbplayer.tplayer;

import com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils;
import com.tencent.thumbplayer.api.ITPSurfaceListener;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSurfaceCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo;

class TPSurface$1
  implements ITPNativePlayerSurfaceCallback
{
  TPSurface$1(TPSurface paramTPSurface) {}
  
  public void onRenderInfo(TPNativePlayerSurfaceRenderInfo paramTPNativePlayerSurfaceRenderInfo)
  {
    ITPSurfaceListener localITPSurfaceListener = TPSurface.access$000(this.this$0);
    if (localITPSurfaceListener != null) {
      localITPSurfaceListener.onRenderInfo(TPThumbPlayerUtils.convert2TPPlayerSurfaceRenderInfo(paramTPNativePlayerSurfaceRenderInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPSurface.1
 * JD-Core Version:    0.7.0.1
 */