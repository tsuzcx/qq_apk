package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import android.graphics.RectF;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class DanceTestFilter
  extends DanceBaseFilter
{
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private GLImageView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private GLImageView b;
  private GLImageView c;
  private GLImageView d;
  
  public DanceTestFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a("/sdcard/start.png");
    RectF localRectF = new RectF(DisplayUtils.a(180.0F), DisplayUtils.a(0.0F), DisplayUtils.a(500.0F), DisplayUtils.a(300.0F));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b(localRectF);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d(localRectF);
    localRectF = new RectF(DisplayUtils.a(180.0F), DisplayUtils.a(300.0F), DisplayUtils.a(420.0F), DisplayUtils.a(600.0F));
    this.b.a("/sdcard/start.png");
    this.b.b(localRectF);
    this.b.d(localRectF);
    localRectF = new RectF(DisplayUtils.a(180.0F), DisplayUtils.a(300.0F), DisplayUtils.a(420.0F), DisplayUtils.a(600.0F));
    this.c.a("/sdcard/start.png");
    this.c.b(localRectF);
    this.c.d(localRectF);
    localRectF = new RectF(DisplayUtils.a(180.0F), DisplayUtils.a(600.0F), DisplayUtils.a(420.0F), DisplayUtils.a(900.0F));
    this.d.a("/sdcard/start.png");
    this.d.b(localRectF);
    this.d.d(localRectF);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.b = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.c = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.d = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.2F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(350L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setRepeatMode(2);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.5F, 1.5F, 0.5F, 1.5F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setRepeatMode(2);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(1500L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(2);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(500.0F, 500.0F, 0.0F, 1440.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(1500L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setRepeatMode(2);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setRepeatCount(-1);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.f_(true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.b.f_(true);
    this.b.a(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.b.a();
    this.c.f_(true);
    this.c.a(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    this.c.a();
    this.d.f_(true);
    this.d.a(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
    this.d.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceTestFilter
 * JD-Core Version:    0.7.0.1
 */