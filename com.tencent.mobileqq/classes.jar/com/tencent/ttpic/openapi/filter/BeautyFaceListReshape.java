package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.filter.EyeLightenAndPounchFilterReshape;
import com.tencent.ttpic.filter.FaceFeatureFilterReshape;
import com.tencent.ttpic.openapi.PTDetectInfo.Builder;
import com.tencent.ttpic.openapi.facedetect.FaceDetector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeautyFaceListReshape
{
  public static final String TAG = BeautyFaceListReshape.class.getName();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame1 = new Frame();
  private Frame mCopyFrame2 = new Frame();
  private EyeLightenAndPounchFilterReshape mEyeLightenFilter = new EyeLightenAndPounchFilterReshape();
  private Frame mEyeLightenFrame = new Frame();
  private FaceFeatureFilterReshape mFaceFeatureFilter = new FaceFeatureFilterReshape();
  private Frame mFaceFeatureFrame = new Frame();
  private Frame mRemovePounchFrame = new Frame();
  
  public void clear()
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.clearGLSLSelf();
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.clearGLSLSelf();
    }
    this.mCopyFilter.ClearGLSL();
    this.mRemovePounchFrame.clear();
    this.mEyeLightenFrame.clear();
    this.mFaceFeatureFrame.clear();
    this.mCopyFrame1.clear();
    this.mCopyFrame2.clear();
  }
  
  public void initial()
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.ApplyGLSLFilter();
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.ApplyGLSLFilter();
    }
    this.mCopyFilter.apply();
  }
  
  public Frame render(Frame paramFrame, List<List<PointF>> paramList, List<float[]> paramList1, FaceDetector paramFaceDetector, Set<Integer> paramSet, int paramInt, long paramLong)
  {
    if (paramFaceDetector != null) {}
    for (Map localMap = paramFaceDetector.getFaceActionCounter();; localMap = null)
    {
      BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
      paramFaceDetector = paramFrame;
      int i;
      float[] arrayOfFloat;
      if (this.mFaceFeatureFilter != null)
      {
        paramFaceDetector = paramFrame;
        if (this.mFaceFeatureFilter.needRender())
        {
          this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mFaceFeatureFrame);
          i = 0;
          while (i < paramList.size())
          {
            paramFaceDetector = (List)paramList.get(i);
            arrayOfFloat = (float[])paramList1.get(i);
            paramFaceDetector = new PTDetectInfo.Builder().facePoints(paramFaceDetector).faceAngles(arrayOfFloat).faceActionCounter(localMap).triggeredExpression(paramSet).phoneAngle(paramInt).timestamp(paramLong).build();
            this.mFaceFeatureFilter.updatePreview(paramFaceDetector);
            this.mFaceFeatureFilter.OnDrawFrameGLSL();
            this.mFaceFeatureFilter.renderTexture(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
            i += 1;
          }
          paramFaceDetector = this.mFaceFeatureFrame;
        }
      }
      BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
      BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
      paramFrame = paramFaceDetector;
      if (this.mEyeLightenFilter != null)
      {
        paramFrame = paramFaceDetector;
        if (this.mEyeLightenFilter.needRender())
        {
          this.mCopyFilter.RenderProcess(paramFaceDetector.getTextureId(), paramFaceDetector.width, paramFaceDetector.height, -1, 0.0D, this.mEyeLightenFrame);
          i = 0;
          while (i < paramList.size())
          {
            paramFrame = (List)paramList.get(i);
            arrayOfFloat = (float[])paramList1.get(i);
            paramFrame = new PTDetectInfo.Builder().facePoints(paramFrame).faceAngles(arrayOfFloat).faceActionCounter(localMap).triggeredExpression(paramSet).phoneAngle(paramInt).timestamp(paramLong).build();
            this.mEyeLightenFilter.updatePreview(paramFrame);
            this.mEyeLightenFilter.OnDrawFrameGLSL();
            this.mEyeLightenFilter.renderTexture(paramFaceDetector.getTextureId(), paramFaceDetector.width, paramFaceDetector.height);
            i += 1;
          }
          paramFrame = this.mEyeLightenFrame;
        }
      }
      BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
      return paramFrame;
    }
  }
  
  public void setEyeLightenAlpha(float paramFloat)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setAlphaValue(paramFloat);
    }
  }
  
  public void setFaceFeatherAlpha(float paramFloat)
  {
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setAlphaValue(paramFloat);
    }
  }
  
  public void setPounchEnhance(float paramFloat)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setPounchEnhance(paramFloat);
    }
  }
  
  public void setRemovePounchAlpha(float paramFloat)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setSmoothOpacity(paramFloat);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.setRenderMode(paramInt);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.setRenderMode(paramInt);
    }
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (this.mEyeLightenFilter != null) {
      this.mEyeLightenFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    if (this.mFaceFeatureFilter != null) {
      this.mFaceFeatureFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BeautyFaceListReshape
 * JD-Core Version:    0.7.0.1
 */