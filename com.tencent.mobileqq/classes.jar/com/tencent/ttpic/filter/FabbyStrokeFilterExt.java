package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.filter.blurmaskfilter.OptimGaussianMaskFilter;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.trigger.FabbyStrokeExtTriggerCtrlItem.FabbyExtModel;
import com.tencent.ttpic.util.VideoFilterFactory.SEGMENT_STROKE_TRIGGER_STYLE;
import com.tencent.ttpic.util.VideoFilterFactory.SEGMENT_STROKE_TRIGGER_TYPE;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FabbyStrokeFilterExt
  extends FabbyStrokeFilter
{
  static final String ALPHA_ERZHI = "precision lowp float;\n \n varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;//image\n uniform sampler2D inputImageTexture2;//mask\n uniform sampler2D inputImageTexture3; \nuniform vec4 strokeColor; \nuniform int useBg; \n void main()\n {\n     vec4 v1 = texture2D(inputImageTexture, textureCoordinate);\n     vec4 v2 = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 curStrokeClor=strokeColor;\n     if(useBg==1){       curStrokeClor=texture2D(inputImageTexture3, textureCoordinate);       }     if(v2.r<0.1){       if (v1.a < 0.7) {\n         gl_FragColor = vec4(0.0,0.0,0.0,0.0);\n       }\n       else {\n         gl_FragColor = vec4(curStrokeClor.rgb,1.0);\n       }\n     }     else{       gl_FragColor=v1;     } }";
  private final float[] ZERO_COLOR = { 0.0F, 0.0F, 0.0F, 0.0F };
  private BaseFilter copyFilter;
  private OptimGaussianMaskFilter gaussianMaskFilter;
  private String itemId;
  private FabbyStrokeFilterExt mCurrentFilter = this;
  private int mFrameHeight = 0;
  private int mFrameWidth = 0;
  private int mMaskTextureID = -1;
  private FabbyOutlineLightFilter mOutLineLightFilter;
  private Map<String, StickerItem> mStickerItemsMap;
  private boolean renderEnded;
  
  static
  {
    FRAGMENT_SHADER = "precision mediump float; \nvarying mediump vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \nuniform sampler2D inputImageTexture3; \nuniform float stepX; \nuniform float stepY; \nuniform float strokeGapInPixel; \nuniform float strokeWidthInPixel; \nuniform vec4 strokeColor; \nuniform int useBg; \nuniform int useMaskAlpha; \nfloat alphaForStep(float step_x, float step_y, float weight) { \n   float step_x45 = step_x * 0.7071; \n   float step_y45 = step_y * 0.7071; \n   vec4 v3_10 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y+step_y)); \n   vec4 v3_11 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45)); \n   vec4 v3_12 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x, textureCoordinate.y)); \n   vec4 v3_13 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_14 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y-step_y)); \n   vec4 v3_15 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_16 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x, textureCoordinate.y)); \n   vec4 v3_17 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45)); \n   float temp = step(0.3, v3_10.r); \n   temp = step(0.3, v3_11.r + temp); \n   temp = step(0.3, v3_12.r + temp); \n   temp = step(0.3, v3_13.r + temp); \n   temp = step(0.3, v3_14.r + temp); \n   temp = step(0.3, v3_15.r + temp); \n   temp = step(0.3, v3_16.r + temp); \n   float alpha = step(0.3, v3_17.r + temp); \n   return alpha * weight; \n} \nvoid main() \n{ \n   vec4 v1 = texture2D(inputImageTexture, textureCoordinate); \n   vec4 v2 = texture2D(inputImageTexture2, textureCoordinate); \n   vec4 bg = vec4(0.0, 0.0, 0.0, 0.0); \n   float mask = v2.r; \n   if (mask < 0.1) { \n       float x = stepX * strokeGapInPixel; \n       float y = stepY * strokeGapInPixel; \n       float innerAlpha = alphaForStep(x, y, 1.0); \n       if (innerAlpha > 0.3) { \n           gl_FragColor = bg; \n       } else { \n           x += stepX * strokeWidthInPixel; \n           y += stepY * strokeWidthInPixel; \n           float outterAlpha = alphaForStep(x, y, 1.0); \n           if (outterAlpha > 0.3) { \n               if (useBg == 0) {\n                   if(useMaskAlpha > 0){\n                       vec4 v3 = texture2D(inputImageTexture3, textureCoordinate);\n                       gl_FragColor=mix(bg,strokeColor,v3.a);\n                   }\n                   else{\n                       gl_FragColor = strokeColor; \n                   }\n               } else { \n                   gl_FragColor = texture2D(inputImageTexture3, textureCoordinate); \n               } \n           } else { \n               gl_FragColor = bg; \n           } \n       } \n   } else { \n       gl_FragColor = v1; \n   } \n }";
  }
  
  public FabbyStrokeFilterExt(List<StickerItem> paramList)
  {
    addParam(new UniformParam.IntParam("useMaskAlpha", 0));
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      this.mStickerItemsMap = new HashMap();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)paramList.next();
        this.mStickerItemsMap.put(localStickerItem.id, localStickerItem);
      }
    }
  }
  
  private void initOutlineFilter()
  {
    if (this.mOutLineLightFilter == null)
    {
      this.mOutLineLightFilter = new FabbyOutlineLightFilter();
      this.mOutLineLightFilter.apply();
    }
  }
  
  private void initSmoothFilter(int paramInt1, int paramInt2, float paramFloat)
  {
    if ((paramInt1 >= 10) && (paramInt2 >= 10))
    {
      if (paramFloat < 2.0F) {
        return;
      }
      if (this.gaussianMaskFilter == null)
      {
        float f = paramFloat;
        if (paramFloat > 15.0F) {
          f = 15.0F;
        }
        this.gaussianMaskFilter = new OptimGaussianMaskFilter(true, f, false, true);
        this.gaussianMaskFilter.applyFilterChain(false, paramInt1, paramInt2);
        this.copyFilter = new BaseFilter("precision lowp float;\n \n varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;//image\n uniform sampler2D inputImageTexture2;//mask\n uniform sampler2D inputImageTexture3; \nuniform vec4 strokeColor; \nuniform int useBg; \n void main()\n {\n     vec4 v1 = texture2D(inputImageTexture, textureCoordinate);\n     vec4 v2 = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 curStrokeClor=strokeColor;\n     if(useBg==1){       curStrokeClor=texture2D(inputImageTexture3, textureCoordinate);       }     if(v2.r<0.1){       if (v1.a < 0.7) {\n         gl_FragColor = vec4(0.0,0.0,0.0,0.0);\n       }\n       else {\n         gl_FragColor = vec4(curStrokeClor.rgb,1.0);\n       }\n     }     else{       gl_FragColor=v1;     } }");
        this.copyFilter.addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
        this.copyFilter.addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
        this.copyFilter.addParam(new UniformParam.IntParam("useBg", 0));
        this.copyFilter.addParam(new UniformParam.Float4fParam("strokeColor", 0.0F, 0.0F, 0.0F, 0.0F));
        this.copyFilter.apply();
        paramInt1 = this.mMaskTextureID;
        if (paramInt1 >= 0)
        {
          Object localObject = this.gaussianMaskFilter;
          if (localObject != null) {
            ((OptimGaussianMaskFilter)localObject).setMaskTextureId(paramInt1);
          }
          localObject = this.copyFilter;
          if (localObject != null) {
            ((BaseFilter)localObject).addParam(new UniformParam.TextureParam("inputImageTexture2", this.mMaskTextureID, 33986));
          }
        }
      }
    }
  }
  
  private void smoothStroke(int paramInt1, int paramInt2, Frame paramFrame, float paramFloat)
  {
    if (this.gaussianMaskFilter == null) {
      initSmoothFilter(paramInt1, paramInt2, paramFloat);
    }
    this.gaussianMaskFilter.updateVideoSize(paramInt1, paramInt2);
    Frame localFrame1 = FrameBufferCache.getInstance().get(paramInt1, paramInt2);
    Frame localFrame2 = this.gaussianMaskFilter.RenderProcess(paramFrame, localFrame1);
    if (localFrame2 != paramFrame) {
      this.copyFilter.RenderProcess(localFrame2.getTextureId(), localFrame2.width, localFrame2.height, -1, 0.0D, paramFrame);
    }
    localFrame1.unlock();
  }
  
  private void useOutlineFilter(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      initOutlineFilter();
      this.mCurrentFilter = this.mOutLineLightFilter;
      return;
    }
    this.mCurrentFilter = this;
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    this.mFrameWidth = paramInt2;
    this.mFrameHeight = paramInt3;
    Object localObject = this.ZERO_COLOR;
    StickerItem localStickerItem = this.item;
    float f2 = 0.0F;
    float f1;
    if (localStickerItem != null)
    {
      f2 = (float)this.item.strokeGap * Math.min(paramInt2, paramInt3);
      f1 = (float)this.item.strokeWidth * Math.min(paramInt2, paramInt3);
      localObject = this.item.strokeColor;
    }
    else
    {
      f1 = 0.0F;
    }
    this.mCurrentFilter.setStrokeGapInPixel(f2);
    this.mCurrentFilter.setStrokeWidthInPixel(f1);
    this.mCurrentFilter.setStrokeColor((float[])localObject);
    localObject = this.mCurrentFilter;
    if (localObject == this)
    {
      super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
      if ((this.item != null) && (this.item.strokeType == VideoFilterFactory.SEGMENT_STROKE_TRIGGER_TYPE.MASK_LINE_STROKE.type)) {
        smoothStroke(paramInt2, paramInt3, paramFrame, f1 / 3.0F);
      }
    }
    else
    {
      ((FabbyStrokeFilterExt)localObject).RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
    }
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    Object localObject = this.gaussianMaskFilter;
    if (localObject != null) {
      ((OptimGaussianMaskFilter)localObject).clear();
    }
    localObject = this.copyFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).clearGLSLSelf();
    }
    localObject = this.mOutLineLightFilter;
    if (localObject != null) {
      ((FabbyOutlineLightFilter)localObject).clearGLSLSelf();
    }
  }
  
  public void reset()
  {
    this.item = null;
    this.mCurrentFilter = this;
  }
  
  public void setStrokeColor(float[] paramArrayOfFloat)
  {
    super.setStrokeColor(paramArrayOfFloat);
    BaseFilter localBaseFilter = this.copyFilter;
    if (localBaseFilter != null) {
      localBaseFilter.addParam(new UniformParam.Float4fParam("strokeColor", paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]));
    }
  }
  
  public void setmMaskTex(int paramInt)
  {
    super.setmMaskTex(paramInt);
    this.mMaskTextureID = paramInt;
    Object localObject = this.mCurrentFilter;
    if (localObject != this) {
      ((FabbyStrokeFilterExt)localObject).setmMaskTex(paramInt);
    }
    localObject = this.gaussianMaskFilter;
    if (localObject != null) {
      ((OptimGaussianMaskFilter)localObject).setMaskTextureId(paramInt);
    }
    localObject = this.copyFilter;
    if (localObject != null) {
      ((BaseFilter)localObject).addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
    }
  }
  
  public void updateRenderParams(Object paramObject)
  {
    if ((paramObject instanceof FabbyStrokeExtTriggerCtrlItem.FabbyExtModel))
    {
      paramObject = (FabbyStrokeExtTriggerCtrlItem.FabbyExtModel)paramObject;
      this.itemId = paramObject.itemId;
      this.frameIndex = paramObject.frameIndex;
      this.renderEnded = paramObject.renderEnded;
    }
  }
  
  public void updateTextureParam(PTDetectInfo paramPTDetectInfo)
  {
    Map localMap = this.mStickerItemsMap;
    int j = 0;
    if ((localMap != null) && (paramPTDetectInfo != null))
    {
      this.item = ((StickerItem)localMap.get(this.itemId));
      if (this.item != null)
      {
        boolean bool2 = this.renderEnded;
        int k = 1;
        boolean bool1 = true;
        if (bool2)
        {
          this.mCurrentFilter = this;
          this.item = null;
        }
        else if (this.item.strokeType == VideoFilterFactory.SEGMENT_STROKE_TRIGGER_TYPE.NONE.type)
        {
          this.item.strokeColor = this.ZERO_COLOR;
          this.item.strokeWidth = 0.0D;
          this.item.strokeGap = 0.0D;
          this.mCurrentFilter = this;
        }
        else if (this.item.strokeType == VideoFilterFactory.SEGMENT_STROKE_TRIGGER_TYPE.ALL_LINE_STROKE.type)
        {
          if (this.item.strokeStyle != VideoFilterFactory.SEGMENT_STROKE_TRIGGER_STYLE.OUTLIGHT_LINE.style) {
            bool1 = false;
          }
          useOutlineFilter(bool1);
        }
        else if (this.item.strokeType == VideoFilterFactory.SEGMENT_STROKE_TRIGGER_TYPE.MASK_LINE_STROKE.type)
        {
          if (this.gaussianMaskFilter == null)
          {
            float f1 = (float)this.item.strokeWidth;
            float f2 = Math.min(this.mFrameWidth, this.mFrameHeight);
            initSmoothFilter(this.mFrameWidth, this.mFrameHeight, f1 * f2 / 3.0F);
          }
          i = updateStrokeBitmap(paramPTDetectInfo);
          paramPTDetectInfo = this.copyFilter;
          if (paramPTDetectInfo != null) {
            paramPTDetectInfo.addParam(new UniformParam.TextureParam("inputImageTexture3", i, 33987));
          }
          if (this.item.strokeStyle == VideoFilterFactory.SEGMENT_STROKE_TRIGGER_STYLE.OUTLIGHT_LINE.style) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          useOutlineFilter(bool1);
          paramPTDetectInfo = this.mCurrentFilter;
          if (paramPTDetectInfo != this) {
            paramPTDetectInfo.addParam(new UniformParam.TextureParam("inputImageTexture3", i, 33987));
          }
          i = k;
          if (this.item.strokeStyle != VideoFilterFactory.SEGMENT_STROKE_TRIGGER_STYLE.MASK_COLOR.style) {
            break label363;
          }
          j = 1;
          i = k;
          break label363;
        }
        int i = 0;
        label363:
        this.mCurrentFilter.addParam(new UniformParam.IntParam("useMaskAlpha", i));
        this.mCurrentFilter.addParam(new UniformParam.IntParam("useBg", j));
        paramPTDetectInfo = this.copyFilter;
        if (paramPTDetectInfo != null) {
          paramPTDetectInfo.addParam(new UniformParam.IntParam("useBg", j));
        }
      }
      return;
    }
    this.mCurrentFilter.addParam(new UniformParam.IntParam("useBg", 0));
    this.mCurrentFilter.addParam(new UniformParam.IntParam("useMaskAlpha", 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyStrokeFilterExt
 * JD-Core Version:    0.7.0.1
 */