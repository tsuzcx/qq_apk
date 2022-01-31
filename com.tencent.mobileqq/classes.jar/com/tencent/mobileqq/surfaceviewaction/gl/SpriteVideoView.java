package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.util.AttributeSet;
import aycd;
import aycu;
import aycv;

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
  
  public void a(String paramString, int paramInt, aycd paramaycd)
  {
    this.a.a(paramString, paramInt);
    this.a.a(paramaycd);
  }
  
  public void a(String paramString, aycd paramaycd)
  {
    this.a.c(paramString);
    this.a.a(paramaycd);
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
  
  public void setOnPlayedListener(aycu paramaycu)
  {
    this.a.a(paramaycu);
  }
  
  public void setOnProgressChangedListener(aycv paramaycv)
  {
    this.a.a(paramaycv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView
 * JD-Core Version:    0.7.0.1
 */