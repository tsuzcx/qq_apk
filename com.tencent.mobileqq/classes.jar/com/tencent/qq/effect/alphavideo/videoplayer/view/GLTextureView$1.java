package com.tencent.qq.effect.alphavideo.videoplayer.view;

import com.tencent.qq.effect.utils.LogUtil;

class GLTextureView$1
  implements Runnable
{
  GLTextureView$1(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    GLTextureView.access$000(this.this$0).onWindowResize(this.this$0.getWidth(), this.this$0.getHeight());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextureView mCheckAlphaTask,alpha:");
    localStringBuilder.append(GLTextureView.access$100(this.this$0));
    LogUtil.d("GLTextureView", localStringBuilder.toString());
    if (GLTextureView.access$100(this.this$0) != 1.0F) {
      GLTextureView.access$200(this.this$0, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.GLTextureView.1
 * JD-Core Version:    0.7.0.1
 */