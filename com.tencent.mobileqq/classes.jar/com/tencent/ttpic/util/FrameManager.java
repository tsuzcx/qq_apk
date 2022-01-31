package com.tencent.ttpic.util;

import android.util.SparseArray;
import com.tencent.filter.Frame;

public class FrameManager
{
  private static FrameManager instance = new FrameManager();
  public SparseArray<Frame> frameSparseArray = new SparseArray();
  
  public static FrameManager getInstance()
  {
    return instance;
  }
  
  public Frame getFrameByTex(int paramInt)
  {
    Frame localFrame2 = (Frame)this.frameSparseArray.get(paramInt);
    Frame localFrame1 = localFrame2;
    if (localFrame2 == null)
    {
      localFrame1 = new Frame();
      this.frameSparseArray.put(paramInt, localFrame1);
    }
    return localFrame1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.FrameManager
 * JD-Core Version:    0.7.0.1
 */