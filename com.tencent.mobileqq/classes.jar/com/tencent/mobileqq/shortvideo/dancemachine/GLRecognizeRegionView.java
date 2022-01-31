package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GLRecognizeRegionView
{
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private GLFrameImage jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage;
  private GLImageView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private GLRecognizeRegionView.MatchStatusShow jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow;
  private GLRecognizeRegionView.StatusListener jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$StatusListener;
  private GLViewContext jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private GLFrameImage jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage;
  private GLImageView jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private List jdField_b_of_type_JavaUtilList;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private TranslateAnimation jdField_c_of_type_AndroidViewAnimationTranslateAnimation;
  private GLFrameImage jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage;
  private GLImageView jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private List jdField_c_of_type_JavaUtilList;
  private RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF();
  private TranslateAnimation jdField_d_of_type_AndroidViewAnimationTranslateAnimation;
  private GLImageView jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private RectF e = new RectF();
  
  public GLRecognizeRegionView(GLViewContext paramGLViewContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext = paramGLViewContext;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(paramGLViewContext, paramString);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(paramGLViewContext, paramString);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(paramGLViewContext, paramString);
    this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(paramGLViewContext, paramString);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage = new GLFrameImage(paramGLViewContext, paramString);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage = new GLFrameImage(paramGLViewContext, paramString);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage = new GLFrameImage(paramGLViewContext, paramString);
    c();
  }
  
  private void d()
  {
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    RectF localRectF = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a_();
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(localLinearInterpolator);
    localRectF = this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a_();
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(localLinearInterpolator);
    localRectF = this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a_();
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(localLinearInterpolator);
    localRectF = this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a_();
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(f1, localRectF.left, f2, localRectF.top);
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(localLinearInterpolator);
    e();
  }
  
  private void d(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.c(paramInt);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(true);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.e();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.c(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(true);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.e();
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(false);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.e();
    }
    for (;;)
    {
      e(paramInt);
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(true);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.e();
    }
  }
  
  private void e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView);
    localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView);
    localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView);
    localArrayList.add(this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView);
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  private void e(int paramInt)
  {
    RectF localRectF = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localRectF != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.b(localRectF);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.d(localRectF);
      }
      return;
      localRectF = this.jdField_c_of_type_AndroidGraphicsRectF;
      continue;
      localRectF = this.jdField_d_of_type_AndroidGraphicsRectF;
      continue;
      localRectF = this.e;
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(a((GlView)this.jdField_a_of_type_JavaUtilList.get(i), 75, 1));
      i += 1;
    }
    this.jdField_b_of_type_JavaUtilList = localArrayList;
  }
  
  private void g()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(a((GlView)this.jdField_a_of_type_JavaUtilList.get(i), 75, 2));
      i += 1;
    }
    this.jdField_c_of_type_JavaUtilList = localArrayList;
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(false);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(false);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(false);
  }
  
  public AnimationSet a(GlView paramGlView, int paramInt1, int paramInt2)
  {
    float f1 = paramGlView.jdField_c_of_type_AndroidGraphicsRectF.left;
    float f2 = paramGlView.jdField_c_of_type_AndroidGraphicsRectF.top;
    float f3 = paramGlView.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.b();
    AnimationSet localAnimationSet = new AnimationSet(true);
    int i = 0;
    if (i < paramInt2)
    {
      if (i == 0) {}
      for (paramGlView = new TranslateAnimation(f1, f1 - 10.0F * f3, f2, f2 - 18.0F * f3);; paramGlView = new TranslateAnimation(0.0F, -10.0F * f3, 0.0F, -18.0F * f3))
      {
        paramGlView.setDuration(paramInt1);
        paramGlView.setStartOffset(i * 4 * paramInt1);
        paramGlView.setFillEnabled(true);
        paramGlView.setFillBefore(false);
        paramGlView.setFillAfter(true);
        localAnimationSet.addAnimation(paramGlView);
        paramGlView = new TranslateAnimation(0.0F, 20.0F * f3, 0.0F, 36.0F * f3);
        paramGlView.setStartOffset(i * 4 * paramInt1 + paramInt1 * 1);
        paramGlView.setDuration(paramInt1);
        paramGlView.setFillEnabled(true);
        paramGlView.setFillBefore(false);
        paramGlView.setFillAfter(true);
        localAnimationSet.addAnimation(paramGlView);
        paramGlView = new TranslateAnimation(0.0F, 0.0F, 0.0F, -23.0F * f3);
        paramGlView.setStartOffset(i * 4 * paramInt1 + paramInt1 * 2);
        paramGlView.setDuration(paramInt1);
        paramGlView.setFillEnabled(true);
        paramGlView.setFillBefore(false);
        paramGlView.setFillAfter(true);
        localAnimationSet.addAnimation(paramGlView);
        paramGlView = new TranslateAnimation(0.0F, -10.0F * f3, 0.0F, 5.0F * f3);
        paramGlView.setStartOffset(i * 4 * paramInt1 + paramInt1 * 3);
        paramGlView.setDuration(paramInt1);
        paramGlView.setFillEnabled(true);
        paramGlView.setFillBefore(false);
        paramGlView.setFillAfter(true);
        localAnimationSet.addAnimation(paramGlView);
        i += 1;
        break;
      }
    }
    return localAnimationSet;
  }
  
  public GLRecognizeRegionView.MatchStatusShow a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (GLRecognizeRegionView.MatchStatusShow localMatchStatusShow = (GLRecognizeRegionView.MatchStatusShow)this.jdField_a_of_type_JavaUtilArrayList.remove(0);; localMatchStatusShow = new GLRecognizeRegionView.MatchStatusShow())
    {
      localMatchStatusShow.a();
      return localMatchStatusShow;
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
      this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_c_of_type_AndroidViewAnimationTranslateAnimation);
      this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_d_of_type_AndroidViewAnimationTranslateAnimation);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > -1)
    {
      GLRecognizeRegionView.MatchStatusShow localMatchStatusShow = a();
      localMatchStatusShow.a = paramInt;
      this.jdField_a_of_type_JavaUtilLinkedList.add(localMatchStatusShow);
    }
  }
  
  public void a(RectF paramRectF)
  {
    if (!this.jdField_a_of_type_AndroidGraphicsRectF.equals(paramRectF))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
      float f = DisplayUtils.a(82.0F);
      RectF localRectF = new RectF();
      localRectF.left = paramRectF.left;
      localRectF.top = paramRectF.top;
      localRectF.right = (localRectF.left + f);
      localRectF.bottom = (localRectF.top + f);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b(localRectF);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d(localRectF);
      localRectF.left = paramRectF.left;
      localRectF.top = (paramRectF.bottom - f);
      localRectF.right = (paramRectF.left + f);
      localRectF.bottom = paramRectF.bottom;
      this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b(localRectF);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d(localRectF);
      localRectF.left = (paramRectF.right - f);
      localRectF.top = paramRectF.top;
      localRectF.right = paramRectF.right;
      localRectF.bottom = (paramRectF.top + f);
      this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b(localRectF);
      this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d(localRectF);
      localRectF.left = (paramRectF.right - f);
      localRectF.top = (paramRectF.bottom - f);
      localRectF.right = paramRectF.right;
      localRectF.bottom = paramRectF.bottom;
      this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b(localRectF);
      this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d(localRectF);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(this.jdField_a_of_type_AndroidGraphicsRectF);
      d();
    }
  }
  
  public void a(GLRecognizeRegionView.MatchStatusShow paramMatchStatusShow)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramMatchStatusShow);
  }
  
  public void a(GLRecognizeRegionView.StatusListener paramStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$StatusListener = paramStatusListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(0, paramString1);
    localArrayList.add(1, paramString2);
    localArrayList.add(2, paramString3);
    localArrayList.add(3, paramString4);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(false);
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() != paramList.size()) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        GLImageView localGLImageView = (GLImageView)this.jdField_a_of_type_JavaUtilList.get(i);
        localGLImageView.e();
        localGLImageView.a((Animation)paramList.get(i));
        i += 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.f_(paramBoolean);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.f_(paramBoolean);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.f_(paramBoolean);
    this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.f_(paramBoolean);
  }
  
  public void b()
  {
    int i = 1;
    a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.a()))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow = null;
      h();
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow == null) {
        h();
      }
      this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a();
      this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a();
      return;
    }
    Object localObject = (GLRecognizeRegionView.MatchStatusShow)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow != null)
    {
      if (((GLRecognizeRegionView.MatchStatusShow)localObject).a <= this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.a) {
        break label390;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.b();
      a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow = ((GLRecognizeRegionView.MatchStatusShow)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      if (i != 0)
      {
        d(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.a);
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$StatusListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$StatusListener.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.a);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.b();
        this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a((Animation)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.c();
        if (localObject != null) {
          this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a((Animation)localObject);
        }
        localObject = GLRecognizeRegionView.MatchStatusShow.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a((Animation)localObject);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.a == 2)
        {
          f();
          a(this.jdField_b_of_type_JavaUtilList);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.a == 3)
        {
          g();
          a(this.jdField_c_of_type_JavaUtilList);
        }
        c(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.a);
        break;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow = ((GLRecognizeRegionView.MatchStatusShow)localObject);
        continue;
      }
      DanceLog.a("GLRecognizeRegionView", "newMessageItem=false  mCurrentMessage=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.a() + " topMessage=" + ((GLRecognizeRegionView.MatchStatusShow)localObject).a() + this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow.b());
      break;
      label390:
      i = 0;
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.b().width();
    GLImage localGLImage = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a(1);
    int j = (i - DisplayUtils.a(localGLImage.b())) / 2;
    this.jdField_c_of_type_AndroidGraphicsRectF.set(j, paramInt, i - j, DisplayUtils.a(localGLImage.c()) + paramInt);
    localGLImage = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a(2);
    j = (i - DisplayUtils.a(localGLImage.b())) / 2;
    this.jdField_d_of_type_AndroidGraphicsRectF.set(j, paramInt, i - j, DisplayUtils.a(localGLImage.c()) + paramInt);
    localGLImage = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a(3);
    j = (i - DisplayUtils.a(localGLImage.b())) / 2;
    this.e.set(j, paramInt, i - j, DisplayUtils.a(localGLImage.c()) + paramInt);
  }
  
  public void b(RectF paramRectF)
  {
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.b(paramRectF);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.d(paramRectF);
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(paramString);
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(0, paramString1);
    localArrayList.add(1, paramString2);
    localArrayList.add(2, paramString3);
    localArrayList.add(3, paramString4);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a(localArrayList);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a(0);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.b();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLRecognizeRegionView$MatchStatusShow = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(int paramInt)
  {
    ResourceManager.GamingResource localGamingResource = ResourceManager.a().a;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(localGamingResource.r);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(localGamingResource.p);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(localGamingResource.q);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a(localGamingResource.s);
  }
  
  public void c(RectF paramRectF)
  {
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.b(paramRectF);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.d(paramRectF);
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(paramString);
  }
  
  public void c(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(0, paramString1);
    localArrayList.add(1, paramString2);
    localArrayList.add(2, paramString3);
    localArrayList.add(3, paramString4);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a(localArrayList);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.a(0);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.b();
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLFrameImage.f_(false);
  }
  
  public void d(String paramString)
  {
    this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLRecognizeRegionView
 * JD-Core Version:    0.7.0.1
 */