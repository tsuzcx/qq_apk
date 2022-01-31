package com.tencent.mobileqq.surfaceviewaction.gl;

import aiqg;
import android.content.Context;
import android.util.AttributeSet;

public class SpriteVideoView
  extends SpriteGLView
{
  public int a;
  protected VideoSprite a;
  
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
    this.a.j();
  }
  
  public void a(String paramString, int paramInt, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.a.a(paramString, paramInt);
    this.a.a(paramOnFrameEndListener);
  }
  
  public void a(String paramString, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.a.b(paramString);
    this.a.a(paramOnFrameEndListener);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.a = new aiqg(this, this, getContext(), paramBoolean);
    this.a.a = true;
    this.a.c = true;
    a(this.a);
  }
  
  public void setCenterCrop(boolean paramBoolean)
  {
    this.a.d = paramBoolean;
  }
  
  public void setFilePath(String paramString)
  {
    this.a.a(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView
 * JD-Core Version:    0.7.0.1
 */