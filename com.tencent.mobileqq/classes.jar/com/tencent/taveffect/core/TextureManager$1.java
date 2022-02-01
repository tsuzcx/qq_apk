package com.tencent.taveffect.core;

import android.util.Log;

class TextureManager$1
  implements VideoFrameListener
{
  TextureManager$1(TextureManager paramTextureManager) {}
  
  public void onStickerTextureProcess(TAVTextureInfo paramTAVTextureInfo, RenderParams paramRenderParams)
  {
    if (TextureManager.access$000(this.this$0))
    {
      Log.e("TextureManager", "onStickerTextureProcess:texture manager is released");
      return;
    }
    TextureManager.access$400(this.this$0).setParams(paramRenderParams.getVertexMatrix(), paramRenderParams.getTextureMatrix(), paramRenderParams.getRectangle(), paramRenderParams.getOpacity());
    TextureManager.access$400(this.this$0).setRendererWidth(paramRenderParams.getRenderWidth());
    TextureManager.access$400(this.this$0).setRendererHeight(paramRenderParams.getRenderHeight());
    TextureManager.access$400(this.this$0).applyFilter(paramTAVTextureInfo);
  }
  
  public void onVideoTextureProcess(TAVTextureInfo paramTAVTextureInfo, RenderParams paramRenderParams)
  {
    if (TextureManager.access$000(this.this$0))
    {
      Log.e("TextureManager", "onVideoTextureProcess:texture manager is released");
      return;
    }
    TAVFilterGroup localTAVFilterGroup;
    if (TextureManager.access$100(this.this$0) != null) {
      localTAVFilterGroup = TextureManager.access$100(this.this$0);
    } else {
      localTAVFilterGroup = TextureManager.access$200(this.this$0);
    }
    localTAVFilterGroup.setParams(paramRenderParams.getVertexMatrix(), paramRenderParams.getTextureMatrix(), paramRenderParams.getRectangle(), paramRenderParams.getOpacity());
    localTAVFilterGroup.setRendererWidth(paramRenderParams.getRenderWidth());
    localTAVFilterGroup.setRendererHeight(paramRenderParams.getRenderHeight());
    localTAVFilterGroup.applyFilter(paramTAVTextureInfo);
    try
    {
      if (TextureManager.access$300(this.this$0) != null)
      {
        TextureManager.access$300(this.this$0).release();
        TextureManager.access$302(this.this$0, null);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.taveffect.core.TextureManager.1
 * JD-Core Version:    0.7.0.1
 */