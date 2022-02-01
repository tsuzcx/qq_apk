package com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer;

import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUBaseFilter;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUOESBaseFilter;

public class FilterFactory
{
  public static GPUBaseFilter a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 102)
      {
        if (paramInt != 106) {
          return new GPUBaseFilter();
        }
        return new GPUImagePixelationFilter();
      }
      return new GPUOESBaseFilter();
    }
    return new GPUDrawPartFilter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer.FilterFactory
 * JD-Core Version:    0.7.0.1
 */