package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.util.AttributeSet;

public class SpriteVideoView
  extends SpriteGLView
{
  protected int a;
  protected VideoSprite a;
  
  public SpriteVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    a(true);
  }
  
  public SpriteVideoView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 1);
    this.jdField_a_of_type_Int = 0;
    a(paramBoolean);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.j();
  }
  
  public void a(String paramString, int paramInt, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(paramOnFrameEndListener);
  }
  
  public void a(String paramString, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(paramOnFrameEndListener);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite = new SpriteVideoView.1(this, this, getContext(), paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.b = true;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c = true;
    a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
  }
  
  public void setCenterCrop(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.d = paramBoolean;
  }
  
  public void setFilePath(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.b(paramString);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(paramBoolean);
  }
  
  public void setOnPlayedListener(VideoSprite.OnOnPlayedListener paramOnOnPlayedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(paramOnOnPlayedListener);
  }
  
  public void setOnProgressChangedListener(VideoSprite.OnProgressChangedListener paramOnProgressChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(paramOnProgressChangedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView
 * JD-Core Version:    0.7.0.1
 */