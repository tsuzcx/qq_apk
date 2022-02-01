package com.tencent.mobileqq.shortvideo.mtveffects;

import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class MTV1TopLayerRender
  extends LayerRenderBase
{
  public static final int MATERIAL_ID_DOV_TEXT = 0;
  public static final int MATERIAL_ID_TODAY_TEXT = 1;
  private MTVBaseFilter.TextParam mDovParam;
  private HorizontialGlitchFilter mFilter;
  private MTVBaseFilter.TextParam mTodayParam;
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramInt1, paramInt2);
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      HorizontialGlitchFilter localHorizontialGlitchFilter = this.mFilter;
      if (localHorizontialGlitchFilter != null)
      {
        localHorizontialGlitchFilter.onOutputSizeChanged(paramInt1, paramInt2);
        return;
      }
      this.mFilter = new HorizontialGlitchFilter();
      this.mFilter.init();
      this.mFilter.onOutputSizeChanged(getWidth(), getHeight());
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    HorizontialGlitchFilter localHorizontialGlitchFilter = this.mFilter;
    if (localHorizontialGlitchFilter != null)
    {
      localHorizontialGlitchFilter.destroy();
      this.mFilter = null;
    }
  }
  
  public int process(RenderBuffer paramRenderBuffer, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    paramRenderBuffer.bind();
    MTVBaseFilter.TextParam localTextParam = this.mDovParam;
    if ((localTextParam != null) && (localTextParam.mShow) && (this.mFilter.process(this.mDovParam.mGlitchID, getMaterialTextureID(), getMaterialArea(0), this.mDovParam.mRect, this.mDovParam.mChangeColor, this.mDovParam.mColor, paramArrayOfFloat1, paramArrayOfFloat2))) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    localTextParam = this.mTodayParam;
    int i = paramInt;
    if (localTextParam != null)
    {
      i = paramInt;
      if (localTextParam.mShow) {
        if ((!this.mFilter.process(this.mTodayParam.mGlitchID, getMaterialTextureID(), getMaterialArea(1), this.mTodayParam.mRect, this.mTodayParam.mChangeColor, this.mTodayParam.mColor, paramArrayOfFloat1, paramArrayOfFloat2)) && (paramInt == 0)) {
          i = 0;
        } else {
          i = 1;
        }
      }
    }
    paramRenderBuffer.unbind();
    if (i != 0) {
      return paramRenderBuffer.getTexId();
    }
    return -1;
  }
  
  public void updateData(MTVBaseFilter.TextParam paramTextParam1, MTVBaseFilter.TextParam paramTextParam2)
  {
    this.mDovParam = paramTextParam1;
    this.mTodayParam = paramTextParam2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTV1TopLayerRender
 * JD-Core Version:    0.7.0.1
 */