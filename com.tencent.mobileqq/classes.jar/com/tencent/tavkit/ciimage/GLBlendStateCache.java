package com.tencent.tavkit.ciimage;

import android.opengl.GLES20;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Arrays;

class GLBlendStateCache
{
  private static final String TAG = "GLBlendStateCache";
  private boolean isEnabled;
  private final int[] pNames = { 32777, 32777, 34877, 32969, 32968, 32971, 32970 };
  private final int[] params = new int[7];
  
  void cache()
  {
    try
    {
      this.isEnabled = GLES20.glIsEnabled(3042);
      boolean bool = this.isEnabled;
      if (!bool) {
        return;
      }
      int i = 0;
      while (i < this.pNames.length)
      {
        GLES20.glGetIntegerv(this.pNames[i], this.params, i);
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  void restore()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restore: params = ");
      localStringBuilder.append(Arrays.toString(this.params));
      Logger.v("GLBlendStateCache", localStringBuilder.toString());
      if (this.isEnabled)
      {
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(this.params[0]);
        GLES20.glBlendEquationSeparate(this.params[1], this.params[2]);
        GLES20.glBlendFuncSeparate(this.params[3], this.params[4], this.params[5], this.params[6]);
      }
      else
      {
        GLES20.glDisable(3042);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.GLBlendStateCache
 * JD-Core Version:    0.7.0.1
 */