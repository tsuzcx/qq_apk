package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;

class SpriteVideoView$1
  extends VideoSprite
{
  SpriteVideoView$1(SpriteVideoView paramSpriteVideoView, SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramContext, paramBoolean);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.this$0.b == 0) {
      this.this$0.b = paramInt2;
    }
    super.a(paramInt1, this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView.1
 * JD-Core Version:    0.7.0.1
 */