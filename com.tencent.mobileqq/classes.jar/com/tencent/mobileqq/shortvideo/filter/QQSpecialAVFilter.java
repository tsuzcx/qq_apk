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
      localObject = this.mFilterTextureId;
      GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
      this.mFilterTextureFbo = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.mFilterTextureId[0]);
      this.fboWidth = paramInt1;
      this.fboHeight = paramInt2;
    }
    Object localObject = this.mCurrentDesc;
    if (localObject != null)
    {
      if (((FilterDesc)localObject).id == -1) {
        return null;
      }
      localObject = this.mOldFilter;
      if (localObject != null)
      {
        ((QQAVImageFilter)localObject).destroy();
        this.mOldFilter = null;
      }
      if (this.mCurrentFilter == null)
      {
        switch (this.mCurrentDesc.id)
        {
        default: 
          break;
        case 1016: 
          this.mCurrentFilter = new MirrorSpecialEffectImageFilter(1016);
          break;
        case 1015: 
          this.mCurrentFilter = new QQAVImageBoxFilter();
          break;
        case 1014: 
          this.mCurrentFilter = new QQAVImageSoulFilter();
          break;
        case 1013: 
          this.mCurrentFilter = new QQAVImageShakeFilter();
          break;
        case 1012: 
          this.mCurrentFilter = new QQAVImageOldTVFilter();
          break;
        case 1011: 
          this.mCurrentFilter = new QQAVImageWrongEraseFilter();
          break;
        case 1010: 
          this.mCurrentFilter = new QQAVImageGhostFilter();
          break;
        case 1009: 
          this.mCurrentFilter = new QQAVImageKaleidoscopeFilter();
          break;
        case 1008: 
          this.mCurrentFilter = new QQAVImageGaussianSelecterBlurFilter();
          break;
        case 1007: 
          this.mCurrentFilter = new QQAVImageBulgeDistortionFilter();
          break;
        case 1006: 
          this.mCurrentFilter = new MirrorSpecialEffectImageFilter(1006);
        }
        localObject = this.mCurrentFilter;
        if (localObject != null) {
          ((QQAVImageFilter)localObject).init();
        }
      }
      return this.mCurrentFilter;
    }
    return null;
  }
  
  private boolean isSpecialId(FilterDesc paramFilterDesc)
  {
    boolean bool = false;
    if (paramFilterDesc == null) {
      return false;
    }
    if (QQAVImageFilterConstants.getFilterType(paramFilterDesc.id) == 2) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public void onDrawFrame()
  {
    QQAVImageFilter localQQAVImageFilter = getSpecialFilter(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
    if ((localQQAVImageFilter != null) && (this.mFilterTextureFbo != -1))
    {
      int j = getQQFilterRenderManager().getIntParam("key_orientation_degree");
      int i = j;
      if (j == -1) {
        i = 90;
      }
      localQQAVImageFilter.onOutputSizeChanged(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
      if ((localQQAVImageFilter instanceof MirrorSpecialEffectImageFilter)) {
        ((MirrorSpecialEffectImageFilter)localQQAVImageFilter).setOrientation(i);
      }
      if ((localQQAVImageFilter instanceof QQSpecialAVFilter.MusicWaveformShaker))
      {
        QQSpecialAVFilter.MusicWaveformSupporter localMusicWaveformSupporter = this.mMusicWaveformSupporter;
        float f;
        if (localMusicWaveformSupporter == null) {
          f = getQQFilterRenderManager().getBusinessOperation().getCurrentMusicGain();
        } else {
          f = localMusicWaveformSupporter.getCurrentMusicGain();
        }
        if ((f > 0.0F) && (f <= 1.0F)) {
          ((QQSpecialAVFilter.MusicWaveformShaker)localQQAVImageFilter).setMusicScale(f);
        } else {
          ((QQSpecialAVFilter.MusicWaveformShaker)localQQAVImageFilter).setMusicScale(0.0F);
        }
      }
      localQQAVImageFilter.onDraw2(this.mInputTextureID, this.mFilterTextureFbo);
      this.mOutputTextureID = this.mFilterTextureId[0];
      QQFilterLogManager.setFilterStatus("QQSpecialAVFilter", true);
      this.bwork = true;
      return;
    }
    this.mOutputTextureID = this.mInputTextureID;
    QQFilterLogManager.setFilterStatus("QQSpecialAVFilter", false);
    this.bwork = false;
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    SLog.d("QQSpecialAVFilter", "special onSurfaceChange ");
    setCurrentId(getQQFilterRenderManager().getBusinessOperation().getCurrentAVFilterIdByType(2));
  }
  
  public void onSurfaceDestroy()
  {
    Object localObject = this.mCurrentFilter;
    if (localObject != null)
    {
      ((QQAVImageFilter)localObject).destroy();
      this.mCurrentFilter = null;
    }
    localObject = this.mOldFilter;
    if (localObject != null)
    {
      ((QQAVImageFilter)localObject).destroy();
      this.mOldFilter = null;
    }
    this.mCurrentDesc = null;
    this.bwork = false;
    if (this.mFilterTextureFbo != -1) {
      this.mFilterTextureFbo = -1;
    }
    localObject = this.mFilterTextureId;
    if (localObject[0] != -1) {
      localObject[0] = -1;
    }
  }
  
  public void setCurrentId(FilterDesc paramFilterDesc)
  {
    if (isSpecialId(paramFilterDesc))
    {
      this.mCurrentDesc = new FilterDesc(paramFilterDesc.id, paramFilterDesc.predownload, paramFilterDesc.resurl, paramFilterDesc.resMD5, paramFilterDesc.iconurl, paramFilterDesc.iconMD5, paramFilterDesc.name, 2);
      this.bwork = true;
    }
    else
    {
      this.mCurrentDesc = null;
      this.bwork = false;
    }
    paramFilterDesc = this.mCurrentFilter;
    if (paramFilterDesc != null)
    {
      this.mOldFilter = paramFilterDesc;
      this.mCurrentFilter = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter
 * JD-Core Version:    0.7.0.1
 */