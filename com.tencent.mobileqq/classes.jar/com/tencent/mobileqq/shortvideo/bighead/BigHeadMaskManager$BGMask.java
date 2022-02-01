package com.tencent.mobileqq.shortvideo.bighead;

import android.opengl.GLES20;

public class BigHeadMaskManager$BGMask
{
  public boolean hasValidData = false;
  public boolean last = false;
  public int mTextureId = 0;
  public boolean mUsed = false;
  
  public void destroy()
  {
    int i = this.mTextureId;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.BigHeadMaskManager.BGMask
 * JD-Core Version:    0.7.0.1
 */