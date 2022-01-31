package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import aiba;
import aibb;
import aibc;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLScoreBoard;
import com.tencent.mobileqq.shortvideo.dancemachine.GLTextView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GameNumberResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ShareResource;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.util.List;
import java.util.Random;

public class DanceScoreFilter
  extends DanceBaseFilter
{
  private float jdField_a_of_type_Float = 0.0F;
  private long jdField_a_of_type_Long;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private GLScoreBoard jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard;
  private GLTextView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView;
  private ResourceManager jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager = ResourceManager.a();
  private String jdField_a_of_type_JavaLangString = "";
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private long jdField_b_of_type_Long = 0L;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private int e;
  private int f;
  private final int g = 4000;
  
  public DanceScoreFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private Animation a()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(300L);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new aiba(this));
    return localAnimationSet;
  }
  
  private Animation a(int paramInt1, int paramInt2)
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().a();
    AnimationSet localAnimationSet = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(DisplayUtils.a(50.0F) * f1, DisplayUtils.a(50.0F) * f1, -paramInt1 * f1, f1 * paramInt2);
    localTranslateAnimation.setDuration(1000L);
    localTranslateAnimation.setInterpolator(new BounceInterpolator());
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setAnimationListener(new aibb(this));
    localAnimationSet.setStartOffset(300L);
    return localAnimationSet;
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().b();
    int i = ((Rect)localObject).width();
    int j = ((Rect)localObject).height();
    localObject = new RectF(0.0F, 0.0F, i, j);
    float f2 = (i - this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a()) / 2.0F;
    float f1 = this.jdField_a_of_type_Float;
    float f3 = this.jdField_b_of_type_Float - this.jdField_a_of_type_Float;
    if (f3 <= this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a()) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a((int)f3);
    }
    for (;;)
    {
      ((RectF)localObject).set(f2, f1, i - f2, this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a() + f1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.b((RectF)localObject);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.d((RectF)localObject);
      return;
      f1 += (f3 - this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a()) / 2.0F;
    }
  }
  
  private Animation b()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(1.8F, 1.0F, 1.8F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(600L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject).setDuration(600L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setAnimationListener(new aibc(this));
    return localAnimationSet;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    float f2 = 99.599998F;
    float f3 = 0.0F;
    long l = SystemClock.elapsedRealtime();
    float f1;
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long < l) && (paramInt1 > 0))
    {
      l -= this.jdField_a_of_type_Long;
      if (l <= paramInt1) {
        break label323;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(true);
        this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_c_of_type_AndroidViewAnimationAnimation);
        paramInt1 = ResourceManager.a().a().size();
        float f5 = paramInt2 * 1.0F / (paramInt1 * 50);
        this.jdField_a_of_type_JavaUtilRandom.setSeed(System.nanoTime());
        float f4 = this.jdField_a_of_type_JavaUtilRandom.nextInt(10) + 100.0F * f5 * 2.0F;
        f1 = f4;
        if (f4 > 97.0F)
        {
          this.jdField_a_of_type_JavaUtilRandom.setSeed(System.nanoTime());
          f1 = (this.jdField_a_of_type_JavaUtilRandom.nextFloat() - 0.14F) * 3.0F + 97.0F;
        }
        if (f5 != 0.0F) {
          break label348;
        }
        f1 = f3;
      }
    }
    label323:
    label348:
    for (;;)
    {
      f1 = (int)(f1 * 10.0F) / 10.0F;
      if (f1 > 99.599998F) {
        f1 = f2;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.f();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a("你的分数超过了", 7, -1);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a("" + f1 + "%", 4, -18322);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a("的用户", 3, -1);
        a();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.h_(true);
        this.jdField_a_of_type_JavaLangString = (f1 + "");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.d(paramInt2);
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.a();
          return;
          paramInt1 = (int)(paramInt2 * ((float)l / paramInt1));
          this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.d(paramInt1);
        }
      }
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GameNumberResource.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().b();
    paramInt1 = ((Rect)localObject).width();
    paramInt2 = ((Rect)localObject).height();
    localObject = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ShareResource.f);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ShareResource.g);
    int i = this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b().c();
    int j = this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b().b();
    double d1 = i / j;
    if (!Double.isNaN(d1))
    {
      i = paramInt1 - DisplayUtils.a(50.0F) * 2;
      j = (int)(d1 * i);
      paramInt2 = (paramInt2 - j) / 2;
      localObject = new RectF(DisplayUtils.a(50.0F), paramInt2, paramInt1 - DisplayUtils.a(50.0F), paramInt2 + j);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject);
      this.e = j;
      this.f = paramInt2;
      RectF localRectF = new RectF(((RectF)localObject).left + i * 0.06F, ((RectF)localObject).top + j * 0.45F, ((RectF)localObject).right - i * 0.06F, ((RectF)localObject).top + j * 0.74F);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.e(DisplayUtils.a(0.0F));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.a(localRectF);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.b(0.0F);
      this.jdField_a_of_type_Float = (((RectF)localObject).top + j * 0.74F);
      this.jdField_b_of_type_Float = (((RectF)localObject).top + j * 0.84F);
      paramInt1 = (int)(i * 0.18F);
      float f1 = ((RectF)localObject).left;
      float f2 = i;
      float f3 = ((RectF)localObject).top;
      float f4 = j;
      float f5 = ((RectF)localObject).left;
      float f6 = i;
      float f7 = paramInt1;
      float f8 = ((RectF)localObject).top;
      float f9 = j;
      localObject = new RectF(f1 + f2 * 0.41F, f3 + f4 * 0.16F, f6 * 0.41F + f5 + f7, paramInt1 + (f9 * 0.16F + f8));
      this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject);
      this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject);
    }
    a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.e();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.e();
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.e();
    this.jdField_a_of_type_AndroidViewAnimationAnimation = a();
    this.jdField_c_of_type_AndroidViewAnimationAnimation = b();
    this.jdField_b_of_type_AndroidViewAnimationAnimation = a(this.e, this.f);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(true);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(false);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.h_(true);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(false);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.h_(false);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.d = false;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard = new GLScoreBoard(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    ResourceManager.GameNumberResource localGameNumberResource = ResourceManager.a().jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GameNumberResource;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.a(localGameNumberResource.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLScoreBoard.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView = new GLTextView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a(DisplayUtils.a(32.0F));
  }
  
  public void e()
  {
    super.e();
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    if (this.jdField_a_of_type_Boolean) {
      c(1500, this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a.a);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLTextView.a();
    if (this.jdField_c_of_type_Boolean)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.jdField_a_of_type_Long;
      long l3 = this.jdField_b_of_type_Long;
      if ((1050L - (l1 - l2) <= 0L) && (l1 - l3 >= 4000L) && (!this.d))
      {
        QQDanceEventHandler localQQDanceEventHandler = a().a();
        if (localQQDanceEventHandler != null) {
          localQQDanceEventHandler.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a.a, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        }
        GLFrameImage.f();
        DanceLog.b("GLFrameImage", "DanceScoreFilter[onDrawFrame]:temporaryReleaseTextureCache");
        this.d = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceScoreFilter
 * JD-Core Version:    0.7.0.1
 */