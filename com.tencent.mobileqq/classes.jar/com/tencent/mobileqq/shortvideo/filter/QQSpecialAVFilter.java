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
  private final String TAG = "QQSpecialAVFilter";
  private boolean bwork = false;
  private int fboHeight = -1;
  private int fboWidth = -1;
  private FilterDesc mCurrentDesc;
  private QQAVImageFilter mCurrentFilter;
  private int mFilterTextureFbo = -1;
  private int[] mFilterTextureId = { -1 };
  private QQSpecialAVFilter.MusicWaveformSupporter mMusicWaveformSupporter;
  private QQAVImageFilter mOldFilter;
  private boolean mRenderEditVideoFilterBitmap = false;
  
  public QQSpecialAVFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private QQAVImageFilter getSpecialFilter(int paramInt1, int paramInt2)
  {
    if ((this.mFilterTextureFbo == -1) || (this.mFilterTextureId[0] == -1) || (this.fboWidth != paramInt1) || (this.fboHeight != paramInt2))
    {
      GLES20.glGenTextures(this.mFilterTextureId.length, this.mFilterTextureId, 0);
      this.mFilterTextureFbo = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.mFilterTextureId[0]);
      this.fboWidth = paramInt1;
      this.fboHeight = paramInt2;
    }
    if ((this.mCurrentDesc == null) || (this.mCurrentDesc.id == -1)) {
      return null;
    }
    if (this.mOldFilter != null)
    {
      this.mOldFilter.destroy();
      this.mOldFilter = null;
    }
    if (this.mCurrentFilter == null) {
      switch (this.mCurrentDesc.id)
      {
      }
    }
    for (;;)
    {
      if (this.mCurrentFilter != null) {
        this.mCurrentFilter.init();
      }
      return this.mCurrentFilter;
      this.mCurrentFilter = new MirrorSpecialEffectImageFilter(1006);
      continue;
      this.mCurrentFilter = new MirrorSpecialEffectImageFilter(1016);
      continue;
      this.mCurrentFilter = new QQAVImageBulgeDistortionFilter();
      continue;
      this.mCurrentFilter = new QQAVImageGaussianSelecterBlurFilter();
      continue;
      this.mCurrentFilter = new QQAVImageKaleidoscopeFilter();
      continue;
      this.mCurrentFilter = new QQAVImageGhostFilter();
      continue;
      this.mCurrentFilter = new QQAVImageWrongEraseFilter();
      continue;
      this.mCurrentFilter = new QQAVImageOldTVFilter();
      continue;
      this.mCurrentFilter = new QQAVImageShakeFilter();
      continue;
      this.mCurrentFilter = new QQAVImageSoulFilter();
      continue;
      this.mCurrentFilter = new QQAVImageBoxFilter();
    }
  }
  
  private boolean isSpecialId(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc == null) {}
    while (QQAVImageFilterConstants.getFilterType(paramFilterDesc.id) != 2) {
      return false;
    }
    return true;
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public void onDrawFrame()
  {
    QQAVImageFilter localQQAVImageFilter = getSpecialFilter(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
    int i;
    if ((localQQAVImageFilter != null) && (this.mFilterTextureFbo != -1))
    {
      i = getQQFilterRenderManager().getIntParam("key_orientation_degree");
      if (i != -1) {
        break label209;
      }
      i = 90;
    }
    label163:
    label176:
    label209:
    for (;;)
    {
      localQQAVImageFilter.onOutputSizeChanged(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
      if ((localQQAVImageFilter instanceof MirrorSpecialEffectImageFilter)) {
        ((MirrorSpecialEffectImageFilter)localQQAVImageFilter).setOrientation(i);
      }
      float f;
      if ((localQQAVImageFilter instanceof QQSpecialAVFilter.MusicWaveformShaker))
      {
        if (this.mMusicWaveformSupporter != null) {
          break label163;
        }
        f = getQQFilterRenderManager().getBusinessOperation().getCurrentMusicGain();
        if ((f <= 0.0F) || (f > 1.0F)) {
          break label176;
        }
        ((QQSpecialAVFilter.MusicWaveformShaker)localQQAVImageFilter).setMusicScale(f);
      }
      for (;;)
      {
        localQQAVImageFilter.onDraw2(this.mInputTextureID, this.mFilterTextureFbo);
        this.mOutputTextureID = this.mFilterTextureId[0];
        QQFilterLogManager.setFilterStatus("QQSpecialAVFilter", true);
        this.bwork = true;
        return;
        f = this.mMusicWaveformSupporter.getCurrentMusicGain();
        break;
        ((QQSpecialAVFilter.MusicWaveformShaker)localQQAVImageFilter).setMusicScale(0.0F);
      }
      this.mOutputTextureID = this.mInputTextureID;
      QQFilterLogManager.setFilterStatus("QQSpecialAVFilter", false);
      this.bwork = false;
      return;
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    SLog.d("QQSpecialAVFilter", "special onSurfaceChange ");
    setCurrentId(getQQFilterRenderManager().getBusinessOperation().getCurrentAVFilterIdByType(2));
  }
  
  public void onSurfaceDestroy()
  {
    if (this.mCurrentFilter != null)
    {
      this.mCurrentFilter.destroy();
      this.mCurrentFilter = null;
    }
    if (this.mOldFilter != null)
    {
      this.mOldFilter.destroy();
      this.mOldFilter = null;
    }
    this.mCurrentDesc = null;
    this.bwork = false;
    if (this.mFilterTextureFbo != -1) {
      this.mFilterTextureFbo = -1;
    }
    if (this.mFilterTextureId[0] != -1) {
      this.mFilterTextureId[0] = -1;
    }
  }
  
  public void setCurrentId(FilterDesc paramFilterDesc)
  {
    if (isSpecialId(paramFilterDesc)) {
      this.mCurrentDesc = new FilterDesc(paramFilterDesc.id, paramFilterDesc.predownload, paramFilterDesc.resurl, paramFilterDesc.resMD5, paramFilterDesc.iconurl, paramFilterDesc.iconMD5, paramFilterDesc.name, 2);
    }
    for (this.bwork = true;; this.bwork = false)
    {
      if (this.mCurrentFilter != null)
      {
        this.mOldFilter = this.mCurrentFilter;
        this.mCurrentFilter = null;
      }
      return;
      this.mCurrentDesc = null;
    }
  }
  
  public void setMusicWaveformSupporter(QQSpecialAVFilter.MusicWaveformSupporter paramMusicWaveformSupporter)
  {
    this.mMusicWaveformSupporter = paramMusicWaveformSupporter;
  }
  
  public void setRenderEditVideoFilterBitmap(boolean paramBoolean)
  {
    this.mRenderEditVideoFilterBitmap = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter
 * JD-Core Version:    0.7.0.1
 */