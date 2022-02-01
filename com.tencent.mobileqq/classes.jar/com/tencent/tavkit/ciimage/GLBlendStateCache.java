package com.tencent.tavkit.ciimage;

import android.opengl.GLES20;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Arrays;

class GLBlendStateCache
{
  private static final String TAG = "GLBlendStateCache";
  private final int[] pNames = { 32777, 32777, 34877, 32969, 32968, 32971, 32970 };
  private final int[] params = new int[7];
  
  void cache()
  {
    int i = 0;
    try
    {
      while (i < this.pNames.length)
      {
        GLES20.glGetIntegerv(this.pNames[i], this.params, i);
        i += 1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void restore()
  {
    try
    {
      Logger.v("GLBlendStateCache", "restore: params = " + Arrays.toString(this.params));
      GLES20.glEnable(3042);
      GLES20.glBlendEquation(this.params[0]);
      GLES20.glBlendEquationSeparate(this.params[1], this.params[2]);
      GLES20.glBlendFuncSeparate(this.params[3], this.params[4], this.params[5], this.params[6]);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.GLBlendStateCache
 * JD-Core Version:    0.7.0.1
 */