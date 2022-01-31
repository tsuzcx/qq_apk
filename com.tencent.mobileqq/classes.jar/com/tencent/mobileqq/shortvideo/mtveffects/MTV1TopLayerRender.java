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
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    if (this.mFilter != null)
    {
      this.mFilter.onOutputSizeChanged(paramInt1, paramInt2);
      return;
    }
    this.mFilter = new HorizontialGlitchFilter();
    this.mFilter.init();
    this.mFilter.onOutputSizeChanged(getWidth(), getHeight());
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (this.mFilter != null)
    {
      this.mFilter.destroy();
      this.mFilter = null;
    }
  }
  
  public int process(RenderBuffer paramRenderBuffer, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    paramRenderBuffer.bind();
    if ((this.mDovParam != null) && (this.mDovParam.mShow)) {
      if (!this.mFilter.process(this.mDovParam.mGlitchID, getMaterialTextureID(), getMaterialArea(0), this.mDovParam.mRect, this.mDovParam.mChangeColor, this.mDovParam.mColor, paramArrayOfFloat1, paramArrayOfFloat2)) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (this.mTodayParam != null)
      {
        i = paramInt;
        if (this.mTodayParam.mShow) {
          if ((!this.mFilter.process(this.mTodayParam.mGlitchID, getMaterialTextureID(), getMaterialArea(1), this.mTodayParam.mRect, this.mTodayParam.mChangeColor, this.mTodayParam.mColor, paramArrayOfFloat1, paramArrayOfFloat2)) && (paramInt == 0)) {
            break label174;
          }
        }
      }
      label174:
      for (paramInt = 1;; paramInt = 0)
      {
        i = paramInt;
        paramRenderBuffer.unbind();
        if (i == 0) {
          break label179;
        }
        return paramRenderBuffer.getTexId();
        paramInt = 1;
        break;
      }
      label179:
      return -1;
      paramInt = 0;
    }
  }
  
  public void updateData(MTVBaseFilter.TextParam paramTextParam1, MTVBaseFilter.TextParam paramTextParam2)
  {
    this.mDovParam = paramTextParam1;
    this.mTodayParam = paramTextParam2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MTV1TopLayerRender
 * JD-Core Version:    0.7.0.1
 */