package com.tencent.ttpic.util;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.ttpic.filter.VideoFilterBase;

public class FrameUtil
{
  private static final Frame EMPTY_FRAME = new Frame();
  private static final String TAG = FrameUtil.class.getSimpleName();
  
  public static void clearFrame(Frame paramFrame, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (paramFrame == null) {
      return;
    }
    paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    GLES20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    GLES20.glClear(16384);
  }
  
  public static Frame getLastRenderFrame(Frame paramFrame)
  {
    Frame localFrame;
    if (!isValid(paramFrame)) {
      localFrame = EMPTY_FRAME;
    }
    for (;;)
    {
      return localFrame;
      localFrame = paramFrame;
      while (isValid(paramFrame))
      {
        localFrame = paramFrame;
        paramFrame = paramFrame.nextFrame;
      }
    }
  }
  
  public static int getLength(BaseFilter paramBaseFilter)
  {
    int i = 0;
    while (paramBaseFilter != null)
    {
      i += 1;
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
    return i;
  }
  
  public static int getLength(Frame paramFrame)
  {
    int i = 0;
    while ((paramFrame != null) && (paramFrame.getTextureId() > 0))
    {
      i += 1;
      paramFrame = paramFrame.nextFrame;
    }
    return i;
  }
  
  public static Frame getSecondLastRenderFrame(Frame paramFrame)
  {
    Object localObject;
    if ((!isValid(paramFrame)) || (!isValid(paramFrame.nextFrame)))
    {
      localObject = EMPTY_FRAME;
      return localObject;
    }
    Frame localFrame = paramFrame;
    for (;;)
    {
      localObject = localFrame;
      if (!isValid(paramFrame)) {
        break;
      }
      localObject = localFrame;
      if (!isValid(paramFrame.nextFrame)) {
        break;
      }
      localFrame = paramFrame;
      paramFrame = paramFrame.nextFrame;
    }
  }
  
  public static boolean isValid(Frame paramFrame)
  {
    return (paramFrame != null) && (paramFrame.getTextureId() != 0);
  }
  
  public static void printFilterList(BaseFilter paramBaseFilter)
  {
    Log.d(TAG, "[FILTER] BEGIN");
    int i = 0;
    while (paramBaseFilter != null)
    {
      Log.d(TAG, "[FILTER] " + i + " " + paramBaseFilter);
      paramBaseFilter = paramBaseFilter.getmNextFilter();
      i += 1;
    }
    Log.d(TAG, "[FILTER] END");
  }
  
  public static Frame renderProcessByCopy(int paramInt1, int paramInt2, int paramInt3, VideoFilterBase paramVideoFilterBase, BaseFilter paramBaseFilter, Frame paramFrame1, Frame paramFrame2)
  {
    Frame localFrame = paramFrame1;
    if (paramFrame1.getTextureId() == paramInt1) {
      localFrame = paramFrame2;
    }
    paramBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, localFrame);
    paramVideoFilterBase.OnDrawFrameGLSL();
    paramVideoFilterBase.renderTexture(paramInt1, paramInt2, paramInt3);
    return localFrame;
  }
  
  public static Frame renderProcessBySwitchFbo(int paramInt1, int paramInt2, int paramInt3, BaseFilter paramBaseFilter, Frame paramFrame1, Frame paramFrame2)
  {
    Frame localFrame = paramFrame1;
    if (paramFrame1.getTextureId() == paramInt1) {
      localFrame = paramFrame2;
    }
    paramBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, localFrame);
    return localFrame;
  }
  
  public static Frame rotateCorrect(Frame paramFrame1, int paramInt1, int paramInt2, int paramInt3, BaseFilter paramBaseFilter, Frame paramFrame2)
  {
    if (paramInt3 == 0) {
      return paramFrame1;
    }
    int j = (paramInt3 + 360) % 360;
    int i;
    if (j != 90)
    {
      i = paramInt1;
      paramInt3 = paramInt2;
      if (j != 270) {}
    }
    else
    {
      paramInt3 = paramInt1;
      i = paramInt2;
    }
    BenchUtil.benchStart("[VideoFilterList] mRotationFilter before");
    paramBaseFilter.nativeSetRotationAndFlip(j, 0, 0);
    paramBaseFilter.RenderProcess(paramFrame1.getTextureId(), i, paramInt3, -1, 0.0D, paramFrame2);
    BenchUtil.benchEnd("[VideoFilterList] mRotationFilter before");
    return paramFrame2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameUtil
 * JD-Core Version:    0.7.0.1
 */