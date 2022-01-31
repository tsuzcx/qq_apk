package com.tencent.mobileqq.shortvideo.dancemachine.filter;

import ahmp;
import ahmq;
import ahmr;
import ahms;
import ahmt;
import ahmu;
import ahmv;
import ahmw;
import ahmx;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImage;
import com.tencent.mobileqq.shortvideo.dancemachine.GLImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.GLMaskImageView;
import com.tencent.mobileqq.shortvideo.dancemachine.GLProgressBar;
import com.tencent.mobileqq.shortvideo.dancemachine.GLViewContext;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.DancePosture;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GeneralResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ScanResource;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.StartResource;
import com.tencent.mobileqq.shortvideo.dancemachine.TrAsyncTextureLoad;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.filter.QQFaceDanceMechineFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.util.List;
import java.util.TreeSet;

public class DanceReadyFilter
  extends DanceBaseFilter
{
  private long jdField_a_of_type_Long = 0L;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private GLLittleBoy jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy;
  private GLMaskImageView jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView;
  private GLProgressBar jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar;
  private ResourceManager jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager;
  TreeSet jdField_a_of_type_JavaUtilTreeSet = new TreeSet(new ahmx(this));
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = 0L;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private boolean jdField_c_of_type_Boolean = false;
  private Animation jdField_d_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private int jdField_e_of_type_Int = 3;
  private Animation jdField_e_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_e_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private int jdField_f_of_type_Int = 3;
  private Animation jdField_f_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_f_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private final int jdField_g_of_type_Int = 2000;
  private Animation jdField_g_of_type_AndroidViewAnimationAnimation;
  private GLImageView jdField_g_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
  private int h;
  private int i;
  
  public DanceReadyFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private Animation a()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setAnimationListener(new ahmq(this));
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(600L);
    ((Animation)localObject).setStartOffset(100L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setDuration(600L);
    ((Animation)localObject).setStartOffset(100L);
    ((Animation)localObject).setAnimationListener(new ahmr(this));
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setStartOffset(700L);
    return localAnimationSet;
  }
  
  private Animation a(int paramInt1, int paramInt2)
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().a();
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -paramInt1 * f1, f1 * paramInt2);
    localTranslateAnimation.setDuration(2000L);
    localTranslateAnimation.setRepeatCount(-1);
    return localTranslateAnimation;
  }
  
  private Animation a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(300L);
      localScaleAnimation.setStartOffset(300L);
      localScaleAnimation.setFillEnabled(true);
      localScaleAnimation.setFillAfter(true);
      localScaleAnimation.setAnimationListener(new ahmu(this));
      return localScaleAnimation;
    }
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setFillEnabled(true);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new ahmv(this));
    return localScaleAnimation;
  }
  
  private void a()
  {
    ResourceManager.DancePosture localDancePosture = new ResourceManager.DancePosture();
    if (QmcfManager.a().a() == 2) {
      localDancePosture.jdField_a_of_type_JavaLangString = "C";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy.a(localDancePosture);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy.i();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy.a(2, true);
      return;
      if (QQFaceDanceMechineFilter.jdField_a_of_type_Boolean)
      {
        localDancePosture.jdField_a_of_type_JavaLangString = "F";
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy.g = true;
      }
    }
  }
  
  private void a(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long < l) && (paramInt > 0))
    {
      l -= this.jdField_a_of_type_Long;
      if (l <= paramInt) {
        break label57;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a();
      return;
      label57:
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(l);
    }
  }
  
  private Animation b()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new AlphaAnimation(1.0F, 1.0F);
    ((Animation)localObject).setDuration(300L);
    ((Animation)localObject).setAnimationListener(new ahms(this));
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setStartOffset(300L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(true);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 1.04F, 1.0F, 1.04F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(450L);
    ((Animation)localObject).setStartOffset(500L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 1.29F, 1.0F, 1.29F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(150L);
    ((Animation)localObject).setStartOffset(950L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.6F);
    ((Animation)localObject).setDuration(150L);
    ((Animation)localObject).setStartOffset(950L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 0.13F, 1.0F, 1.29F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setStartOffset(1100L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.5F);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setStartOffset(1100L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new ScaleAnimation(1.0F, 10.5F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setStartOffset(1200L);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject).setFillEnabled(true);
    ((Animation)localObject).setFillBefore(false);
    ((Animation)localObject).setDuration(100L);
    ((Animation)localObject).setStartOffset(1200L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setStartOffset(300L);
    localAnimationSet.setFillEnabled(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new ahmt(this));
    localAnimationSet.setStartOffset(300L);
    return localAnimationSet;
  }
  
  private Animation c()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillAfter(true);
    return localAlphaAnimation;
  }
  
  private Animation d()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new ahmw(this));
    localAlphaAnimation.setStartOffset(100L);
    return localAlphaAnimation;
  }
  
  private void i()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void j()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
  }
  
  public TreeSet a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy == null) {
      return super.a();
    }
    this.jdField_a_of_type_JavaUtilTreeSet.clear();
    this.jdField_a_of_type_JavaUtilTreeSet.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy);
    return this.jdField_a_of_type_JavaUtilTreeSet;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    DanceLog.a("DanceReadyFilter", "onCloseClicked begin...");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().c();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(0);
    DanceLog.a("DanceReadyFilter", "onCloseClicked end...");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a().b();
    paramInt1 = ((Rect)localObject1).width();
    paramInt2 = ((Rect)localObject1).height();
    Object localObject2 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    label108:
    int j;
    int k;
    double d1;
    label473:
    label504:
    int m;
    int n;
    if (QQFaceDanceMechineFilter.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.d;
      this.jdField_e_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a((String)localObject1);
      this.jdField_e_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject2);
      this.jdField_e_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject2);
      if (!QQFaceDanceMechineFilter.jdField_a_of_type_Boolean) {
        break label1141;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.e;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.b((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.b);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.b().c() != 0)
      {
        j = (int)(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.b().c() / this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.b().b() * paramInt1);
        localObject1 = new RectF(0.0F, -j, paramInt1, 0.0F);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.b((RectF)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.d((RectF)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.h_(true);
        this.h = j;
        this.i = paramInt2;
      }
      j = paramInt1 - DisplayUtils.a(215.0F) * 2;
      k = (paramInt2 - j) / 2;
      localObject1 = new RectF(DisplayUtils.a(215.0F), k, paramInt1 - DisplayUtils.a(215.0F), j + k);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a((String)this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ReadyResource.jdField_a_of_type_JavaUtilList.get(2));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject1);
      localObject1 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
      this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GeneralResource.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject1);
      this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject1);
      localObject1 = new RectF(DisplayUtils.a(92.0F), DisplayUtils.a(0.0F), paramInt1 - DisplayUtils.a(92.0F), DisplayUtils.a(300.0F));
      this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ReadyResource.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject1);
      this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject1);
      j = (int)(paramInt2 * 0.1D);
      double d2 = paramInt2;
      if (!QQFaceDanceMechineFilter.jdField_a_of_type_Boolean) {
        break label1156;
      }
      d1 = 0.04D;
      k = (int)(d1 * d2);
      localObject2 = this.jdField_f_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
      if (!QQFaceDanceMechineFilter.jdField_a_of_type_Boolean) {
        break label1163;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.k;
      ((GLImageView)localObject2).a((String)localObject1);
      m = this.jdField_f_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b().c();
      n = this.jdField_f_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b().b();
      d1 = m / n;
      if (!Double.isNaN(d1))
      {
        m = (int)(k / d1);
        n = (paramInt1 - m) / 2;
        localObject1 = new RectF(n, j, m + n, k + j);
        this.jdField_f_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject1);
        this.jdField_f_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject1);
      }
      j = (int)(paramInt2 * 0.9D);
      k = (int)(paramInt2 * 0.03D);
      localObject2 = this.jdField_g_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView;
      if (!QQFaceDanceMechineFilter.jdField_a_of_type_Boolean) {
        break label1178;
      }
    }
    label1156:
    label1163:
    label1178:
    for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.j;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.h)
    {
      ((GLImageView)localObject2).a((String)localObject1);
      m = this.jdField_g_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b().c();
      n = this.jdField_g_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b().b();
      d1 = m / n;
      if (!Double.isNaN(d1))
      {
        m = (int)(k / d1);
        n = (paramInt1 - m) / 2;
        localObject1 = new RectF(n, j, m + n, j + k);
        this.jdField_g_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject1);
        this.jdField_g_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject1);
      }
      j = paramInt1 - DisplayUtils.a(7.0F) * 2;
      this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$StartResource.jdField_a_of_type_JavaLangString);
      k = this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b().c();
      m = this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b().b();
      k = (int)(k / m * j);
      m = (paramInt2 - k) / 2;
      localObject1 = new RectF(DisplayUtils.a(7.0F), m, j + DisplayUtils.a(7.0F), k + m);
      this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.b((RectF)localObject1);
      this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.d((RectF)localObject1);
      paramInt2 = (int)(paramInt2 * 0.85D);
      float f1 = DisplayUtils.a(14.0F);
      localObject1 = new RectF(DisplayUtils.a(128.0F), paramInt2, paramInt1 - DisplayUtils.a(128.0F), paramInt2 + f1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a((RectF)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.b((RectF)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.f);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.g);
      paramInt1 = DisplayUtils.a(8.0F);
      j = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a().b();
      float f2 = 14.0F / this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a().c();
      j = DisplayUtils.a((int)(j * f2));
      localObject1 = new RectF(DisplayUtils.a(128.0F), paramInt2, DisplayUtils.a(128.0F) + j, paramInt2 + f1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.c((RectF)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(paramInt1, j - paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(2000);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(0L);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(new ahmp(this));
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.jdField_a_of_type_JavaLangString;
      break;
      label1141:
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.c;
      break label108;
      d1 = 0.08D;
      break label473;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource.i;
      break label504;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy.i();
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.d();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.a(0L);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.e();
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.e();
    this.jdField_e_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.e();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.e();
    this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.e();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.e();
    this.jdField_e_of_type_Int = 3;
    this.jdField_f_of_type_Int = 3;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(false);
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(false);
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(false);
    this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(false);
    this.jdField_e_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.h_(true);
    this.jdField_f_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(true);
    this.jdField_g_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.h_(true);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar.h_(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = a();
    this.jdField_b_of_type_AndroidViewAnimationAnimation = b();
    this.jdField_c_of_type_AndroidViewAnimationAnimation = a(false);
    this.jdField_d_of_type_AndroidViewAnimationAnimation = a(true);
    this.jdField_e_of_type_AndroidViewAnimationAnimation = c();
    this.jdField_f_of_type_AndroidViewAnimationAnimation = d();
    this.jdField_g_of_type_AndroidViewAnimationAnimation = a(this.h, this.i);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.a(this.jdField_g_of_type_AndroidViewAnimationAnimation);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a((String)this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ReadyResource.jdField_a_of_type_JavaUtilList.get(2));
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    DanceLog.a("DanceReadyFilter", "rollbackStatusCallOnInitFilter end...");
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager = ResourceManager.a();
    this.jdField_e_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView = new GLMaskImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_MASK_GL_VIEW_FRAGMENT_MASK");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy = new GLLittleBoy(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLProgressBar = new GLProgressBar(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_f_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    this.jdField_g_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView = new GLImageView(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineFilterDanceManagerFilter.a(), "GL_VIEW_VERTEX_GL_VIEW_FRAGMENT");
    a();
  }
  
  public void e()
  {
    super.e();
    j();
  }
  
  public void h()
  {
    super.h();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLLittleBoy.c()) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      i();
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLMaskImageView.a();
    this.jdField_e_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_f_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_g_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    if (this.jdField_a_of_type_Boolean) {
      a(2000);
    }
    this.jdField_c_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    this.jdField_d_of_type_ComTencentMobileqqShortvideoDancemachineGLImageView.a();
    TrAsyncTextureLoad.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.filter.DanceReadyFilter
 * JD-Core Version:    0.7.0.1
 */