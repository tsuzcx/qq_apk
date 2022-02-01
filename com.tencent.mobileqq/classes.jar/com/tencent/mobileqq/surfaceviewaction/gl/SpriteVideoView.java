package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.util.AttributeSet;
import bdyy;
import bdzo;
import bdzp;

public class SpriteVideoView
  extends SpriteGLView
{
  protected int a;
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
  
  public void a(String paramString, int paramInt, bdyy parambdyy)
  {
    this.a.a(paramString, paramInt);
    this.a.a(parambdyy);
  }
  
  public void a(String paramString, bdyy parambdyy)
  {
    this.a.c(paramString);
    this.a.a(parambdyy);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.a = new SpriteVideoView.1(this, this, getContext(), paramBoolean);
    this.a.b = true;
    this.a.c = true;
    a(this.a);
  }
  
  public void setCenterCrop(boolean paramBoolean)
  {
    this.a.d = paramBoolean;
  }
  
  public void setFilePath(String paramString)
  {
    this.a.b(paramString);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setOnPlayedListener(bdzo parambdzo)
  {
    this.a.a(parambdzo);
  }
  
  public void setOnProgressChangedListener(bdzp parambdzp)
  {
    this.a.a(parambdzp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView
 * JD-Core Version:    0.7.0.1
 */