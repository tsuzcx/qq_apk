package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.resource.BeautyResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.DpcSwitcher;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;

public class QQBeautyFilter
  extends QQBaseFilter
{
  public static int e = -1;
  private float jdField_a_of_type_Float = 1.0F;
  private BeautyRender jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private int f = 0;
  private int g = 0;
  
  public QQBeautyFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender == null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = new BeautyRender(SdkContext.a().a(), SdkContext.a().a().a().a());
      int i = e;
      if (i >= 0) {
        a(i);
      }
    }
    this.jdField_a_of_type_Float = SdkContext.a().a().a();
  }
  
  private boolean b()
  {
    if (!SdkContext.a().a().a()) {}
    while ((this.jdField_b_of_type_Boolean) || (QmcfManager.a().a()) || (a().e() == 3)) {
      return false;
    }
    return true;
  }
  
  private boolean c()
  {
    boolean bool = true;
    int i = a().e();
    if ((i == 1) || (i == 2)) {
      bool = false;
    }
    return bool;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      float f1 = paramFloat / 100.0F;
      if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.setBeautyLevel(f1 * this.jdField_a_of_type_Float);
        if (SLog.a()) {
          SLog.c("FilterBeauty", "setBeautyLevel " + paramFloat + " rate: " + this.jdField_a_of_type_Float);
        }
      }
      return;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (((this.g != paramInt1) || (this.g != paramInt2)) && (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
  }
  
  public boolean f_()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender == null)
    {
      a();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null) && (b()))
    {
      boolean bool = c();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.setNeedSkinColor(bool);
      this.f = a().f();
      this.g = a().g();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.process(this.jdField_a_of_type_Int, -1, this.f, this.g).getTextureId();
      QQFilterLogManager.a("QQBeautyFilter", true);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    QQFilterLogManager.a("QQBeautyFilter", false);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQBeautyFilter
 * JD-Core Version:    0.7.0.1
 */