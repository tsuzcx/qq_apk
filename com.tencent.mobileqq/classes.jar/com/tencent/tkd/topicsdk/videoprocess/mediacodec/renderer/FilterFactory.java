package com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer;

import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUBaseFilter;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUOESBaseFilter;

public class FilterFactory
{
  public static GPUBaseFilter a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new GPUBaseFilter();
    case 102: 
      return new GPUOESBaseFilter();
    case 0: 
      return new GPUDrawPartFilter();
    }
    return new GPUImagePixelationFilter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer.FilterFactory
 * JD-Core Version:    0.7.0.1
 */