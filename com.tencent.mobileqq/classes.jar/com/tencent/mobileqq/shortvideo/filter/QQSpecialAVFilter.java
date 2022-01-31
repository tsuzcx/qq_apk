package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.MirrorSpecialEffectImageFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageBoxFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageBulgeDistortionFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageGaussianSelecterBlurFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageGhostFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageKaleidoscopeFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageOldTVFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageShakeFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageSoulFilter;
import com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageWrongEraseFilter;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.sveffects.SLog;

public class QQSpecialAVFilter
  extends QQBaseFilter
{
  private QQAVImageFilter jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  private QQSpecialAVFilter.MusicWaveformSupporter jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQSpecialAVFilter$MusicWaveformSupporter;
  private final String jdField_a_of_type_JavaLangString = "QQSpecialAVFilter";
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = { -1 };
  private QQAVImageFilter jdField_b_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter;
  private boolean jdField_b_of_type_Boolean = false;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  
  public QQSpecialAVFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private QQAVImageFilter a(int paramInt1, int paramInt2)
  {
    if ((this.e == -1) || (this.jdField_a_of_type_ArrayOfInt[0] == -1) || (this.f != paramInt1) || (this.g != paramInt2))
    {
      GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      this.e = AVGLUtils.a(paramInt1, paramInt2, this.jdField_a_of_type_ArrayOfInt[0]);
      this.f = paramInt1;
      this.g = paramInt2;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.jdField_b_of_type_Int == -1)) {
      return null;
    }
    if (this.jdField_b_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter != null)
    {
      this.jdField_b_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter.destroy();
      this.jdField_b_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter == null) {
      switch (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter != null) {
        this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter.init();
      }
      return this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new MirrorSpecialEffectImageFilter(1006);
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new MirrorSpecialEffectImageFilter(1016);
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageBulgeDistortionFilter();
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageGaussianSelecterBlurFilter();
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageKaleidoscopeFilter();
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageGhostFilter();
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageWrongEraseFilter();
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageOldTVFilter();
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageShakeFilter();
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageSoulFilter();
      continue;
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new QQAVImageBoxFilter();
    }
  }
  
  private boolean a(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc == null) {}
    while (QQAVImageFilterConstants.a(paramFilterDesc.jdField_b_of_type_Int) != 2) {
      return false;
    }
    return true;
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    if (a(paramFilterDesc)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = new FilterDesc(paramFilterDesc.jdField_b_of_type_Int, paramFilterDesc.jdField_d_of_type_Int, paramFilterDesc.jdField_a_of_type_JavaLangString, paramFilterDesc.jdField_b_of_type_JavaLangString, paramFilterDesc.c, paramFilterDesc.jdField_d_of_type_JavaLangString, paramFilterDesc.e, 2);
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter != null)
      {
        this.jdField_b_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter;
        this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = null;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    }
  }
  
  public void a(QQSpecialAVFilter.MusicWaveformSupporter paramMusicWaveformSupporter)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQSpecialAVFilter$MusicWaveformSupporter = paramMusicWaveformSupporter;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    SLog.d("QQSpecialAVFilter", "special onSurfaceChange ");
    a(a().a(2));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = null;
    }
    if (this.jdField_b_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter != null)
    {
      this.jdField_b_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter.destroy();
      this.jdField_b_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    this.jdField_a_of_type_Boolean = false;
    if (this.e != -1) {
      this.e = -1;
    }
    if (this.jdField_a_of_type_ArrayOfInt[0] != -1) {
      this.jdField_a_of_type_ArrayOfInt[0] = -1;
    }
  }
  
  public void h()
  {
    QQAVImageFilter localQQAVImageFilter = a(a().f(), a().g());
    int i;
    if ((localQQAVImageFilter != null) && (this.e != -1))
    {
      i = a().a("key_orientation_degree");
      if (i != -1) {
        break label206;
      }
      i = 90;
    }
    label160:
    label173:
    label206:
    for (;;)
    {
      localQQAVImageFilter.onOutputSizeChanged(a().f(), a().g());
      if ((localQQAVImageFilter instanceof MirrorSpecialEffectImageFilter)) {
        ((MirrorSpecialEffectImageFilter)localQQAVImageFilter).a(i);
      }
      float f1;
      if ((localQQAVImageFilter instanceof QQSpecialAVFilter.MusicWaveformShaker))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQSpecialAVFilter$MusicWaveformSupporter != null) {
          break label160;
        }
        f1 = a().a();
        if ((f1 <= 0.0F) || (f1 > 1.0F)) {
          break label173;
        }
        ((QQSpecialAVFilter.MusicWaveformShaker)localQQAVImageFilter).a(f1);
      }
      for (;;)
      {
        localQQAVImageFilter.onDraw2(this.jdField_a_of_type_Int, this.e);
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ArrayOfInt[0];
        QQFilterLogManager.a("QQSpecialAVFilter", true);
        this.jdField_a_of_type_Boolean = true;
        return;
        f1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQSpecialAVFilter$MusicWaveformSupporter.a();
        break;
        ((QQSpecialAVFilter.MusicWaveformShaker)localQQAVImageFilter).a(0.0F);
      }
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      QQFilterLogManager.a("QQSpecialAVFilter", false);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public boolean i_()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter
 * JD-Core Version:    0.7.0.1
 */