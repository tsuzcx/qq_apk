package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.util.AttributeSet;

public class SpriteVideoView
  extends SpriteGLView
{
  protected VideoSprite a;
  protected int b = 0;
  
  public SpriteVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(true);
  }
  
  public SpriteVideoView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 1);
    a(paramBoolean);
  }
  
  public void a()
  {
    this.a.w();
  }
  
  public void a(String paramString, int paramInt, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.a.a(paramString, paramInt);
    this.a.a(paramOnFrameEndListener);
  }
  
  public void a(String paramString, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.a.c(paramString);
    this.a.a(paramOnFrameEndListener);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.a = new SpriteVideoView.1(this, this, getContext(), paramBoolean);
    VideoSprite localVideoSprite = this.a;
    localVideoSprite.s = true;
    localVideoSprite.t = true;
    a(localVideoSprite);
  }
  
  public void setCenterCrop(boolean paramBoolean)
  {
    this.a.u = paramBoolean;
  }
  
  public void setFilePath(String paramString)
  {
    this.a.b(paramString);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setOnPlayedListener(VideoSprite.OnOnPlayedListener paramOnOnPlayedListener)
  {
    this.a.a(paramOnOnPlayedListener);
  }
  
  public void setOnProgressChangedListener(VideoSprite.OnProgressChangedListener paramOnProgressChangedListener)
  {
    this.a.a(paramOnProgressChangedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView
 * JD-Core Version:    0.7.0.1
 */