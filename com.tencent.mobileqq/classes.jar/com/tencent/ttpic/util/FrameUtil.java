package com.tencent.ttpic.util;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

public class FrameUtil
{
  private static final Frame EMPTY_FRAME = new Frame();
  private static final String TAG = FrameUtil.class.getSimpleName();
  
  public static void clearFrame(Frame paramFrame, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    if (paramFrame == null) {
      return;
    }
    paramFrame.bindFrame(-1, paramInt1, paramInt2, 0.0D);
    GLES20.glClearColor(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    GLES20.glClear(16384);
  }
  
  public static void clearTailFrame(BaseFilter paramBaseFilter, Frame paramFrame)
  {
    int i = getLength(paramBaseFilter);
    while ((i > 0) && (paramFrame != null))
    {
      paramFrame = paramFrame.nextFrame;
      i -= 1;
    }
    if (paramFrame != null) {
      paramFrame.clear();
    }
  }
  
  public static List<BaseFilter> filterChain2List(BaseFilter paramBaseFilter)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramBaseFilter != null)
    {
      BaseFilter localBaseFilter = paramBaseFilter.getmNextFilter();
      paramBaseFilter.setNextFilter(null, null);
      localArrayList.add(paramBaseFilter);
      paramBaseFilter = localBaseFilter;
    }
    return localArrayList;
  }
  
  public static void filterList2Chain(List<BaseFilter> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {}
    for (;;)
    {
      return;
      BaseFilter localBaseFilter = (BaseFilter)paramList.get(0);
      int i = 1;
      while (i < paramList.size())
      {
        localBaseFilter.setNextFilter((BaseFilter)paramList.get(i), null);
        localBaseFilter = (BaseFilter)paramList.get(i);
        i += 1;
      }
    }
  }
  
  public static Frame getLastRenderFrame(Frame paramFrame)
  {
    if (!isValid(paramFrame)) {
      paramFrame = EMPTY_FRAME;
    }
    for (;;)
    {
      return paramFrame;
      Frame localFrame;
      for (Object localObject = paramFrame; isValid((Frame)localObject); localObject = localFrame)
      {
        localFrame = ((Frame)localObject).nextFrame;
        paramFrame = (Frame)localObject;
      }
    }
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
  
  public static Frame getSecondLastRenderFrame(Frame paramFrame)
  {
    Frame localFrame2;
    if ((!isValid(paramFrame)) || (!isValid(paramFrame.nextFrame)))
    {
      localFrame2 = EMPTY_FRAME;
      return localFrame2;
    }
    for (Frame localFrame1 = paramFrame;; localFrame1 = localFrame2)
    {
      localFrame2 = paramFrame;
      if (!isValid(localFrame1)) {
        break;
      }
      localFrame2 = paramFrame;
      if (!isValid(localFrame1.nextFrame)) {
        break;
      }
      localFrame2 = localFrame1.nextFrame;
      paramFrame = localFrame1;
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
  
  public static Frame renderProcessBySwitchFbo(int paramInt1, int paramInt2, int paramInt3, BaseFilter paramBaseFilter, Frame paramFrame1, Frame paramFrame2)
  {
    if (paramFrame1.getTextureId() == paramInt1) {}
    for (;;)
    {
      paramBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramFrame2);
      return paramFrame2;
      paramFrame2 = paramFrame1;
    }
  }
  
  public static Frame rotateCorrect(Frame paramFrame, int paramInt1, int paramInt2, int paramInt3, BaseFilter paramBaseFilter)
  {
    if (paramInt3 == 0) {
      return paramFrame;
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
    paramBaseFilter.setRotationAndFlip(j, 0, 0);
    paramBaseFilter = paramBaseFilter.RenderProcess(paramFrame.getTextureId(), i, paramInt3);
    paramFrame.unlock();
    return paramBaseFilter;
  }
  
  public static Frame rotateCorrect(Frame paramFrame1, int paramInt1, int paramInt2, int paramInt3, BaseFilter paramBaseFilter, Frame paramFrame2)
  {
    if (paramInt3 == 0) {
      return paramFrame1;
    }
    int i = (paramInt3 + 360) % 360;
    if ((i == 90) || (i == 270))
    {
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      paramBaseFilter.setRotationAndFlip(i, 0, 0);
      paramBaseFilter.RenderProcess(paramFrame1.getTextureId(), paramInt1, paramInt3, -1, 0.0D, paramFrame2);
      return paramFrame2;
      paramInt3 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameUtil
 * JD-Core Version:    0.7.0.1
 */