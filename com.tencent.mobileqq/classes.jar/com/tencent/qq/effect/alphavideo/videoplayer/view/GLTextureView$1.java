package com.tencent.qq.effect.alphavideo.videoplayer.view;

import com.tencent.qq.effect.utils.LogUtil;

class GLTextureView$1
  implements Runnable
{
  GLTextureView$1(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    GLTextureView.access$000(this.this$0).onWindowResize(this.this$0.getWidth(), this.this$0.getHeight());
    LogUtil.d("GLTextureView", "TextureView mCheckAlphaTask,alpha:" + GLTextureView.access$100(this.this$0));
    if (GLTextureView.access$100(this.this$0) != 1.0F) {
      GLTextureView.access$200(this.this$0, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.GLTextureView.1
 * JD-Core Version:    0.7.0.1
 */