package com.tencent.mobileqq.filter;

import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;

public class FilterFactory
{
  public static GPUBaseFilter a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 106)
      {
        if (paramInt != 112)
        {
          if (paramInt != 101)
          {
            if (paramInt != 102) {
              return new GPUBaseFilter();
            }
            return new GPUOESBaseFilter();
          }
          return new GPUBaseFilter();
        }
        return new GPUOESMovieFilter();
      }
      return new GPUImagePixelationFilter();
    }
    return new GPUDrawPartFilter();
  }
  
  public static boolean a(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filter.FilterFactory
 * JD-Core Version:    0.7.0.1
 */