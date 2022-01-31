package com.tencent.ttpic.filter;

import android.graphics.RectF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.Float3fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.Mat4Param;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.ArrayList;
import java.util.List;

public abstract class WMAnimationFilterBase
  extends BaseFilter
{
  private static final String TAG = WMAnimationFilterBase.class.getSimpleName();
  protected List<AnimationTimePoint> mAnimationTimePoints = new ArrayList();
  private int mDuration;
  private long mStartTime;
  
  public WMAnimationFilterBase(WMElement paramWMElement, int paramInt1, int paramInt2, int paramInt3)
  {
    super(VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/WMAnimationVertexShader.dat"), VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/WMAnimationFragmentShader.dat"));
    initParams(paramWMElement, paramInt1, paramInt2, paramInt3);
  }
  
  private void initParams(WMElement paramWMElement, int paramInt1, int paramInt2, int paramInt3)
  {
    addParam(new Param.IntParam("texNeedTransform", 1));
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
    addParam(new Param.Float2fParam("texAnchor", paramWMElement.finalContentRect.left + paramWMElement.width / 2 - paramInt1 / 2, paramWMElement.finalContentRect.top + paramWMElement.height / 2 - paramInt2 / 2));
    addParam(new Param.FloatParam("texScale", 1.0F));
    addParam(new Param.Float3fParam("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new Param.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    this.mStartTime = System.currentTimeMillis();
    this.mDuration = paramInt3;
    initAnimationTimePoints();
  }
  
  protected float getAnimationValue()
  {
    long l = (System.currentTimeMillis() - this.mStartTime) % this.mDuration;
    int i = 1;
    while (i < this.mAnimationTimePoints.size())
    {
      AnimationTimePoint localAnimationTimePoint1 = (AnimationTimePoint)this.mAnimationTimePoints.get(i - 1);
      AnimationTimePoint localAnimationTimePoint2 = (AnimationTimePoint)this.mAnimationTimePoints.get(i);
      if (l <= localAnimationTimePoint2.timePoint)
      {
        float f = (float)(l - localAnimationTimePoint1.timePoint) * 1.0F / (float)(localAnimationTimePoint2.timePoint - localAnimationTimePoint1.timePoint);
        return localAnimationTimePoint1.value + (localAnimationTimePoint2.value - localAnimationTimePoint1.value) * f;
      }
      i += 1;
    }
    return 0.0F;
  }
  
  protected abstract void initAnimationTimePoints();
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setAnimationParams();
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  protected abstract void setAnimationParams();
  
  protected class AnimationTimePoint
  {
    public long timePoint;
    public float value;
    
    AnimationTimePoint(long paramLong, float paramFloat)
    {
      this.timePoint = paramLong;
      this.value = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.WMAnimationFilterBase
 * JD-Core Version:    0.7.0.1
 */