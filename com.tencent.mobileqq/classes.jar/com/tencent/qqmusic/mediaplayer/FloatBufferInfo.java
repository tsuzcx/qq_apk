package com.tencent.qqmusic.mediaplayer;

public class FloatBufferInfo
{
  public int bufferSize;
  public float[] floatBuffer;
  public float[] tempFloatBuffer;
  
  public void appendFloat(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfFloat != null) && (paramInt1 >= 0) && (paramInt2 > 0) && (paramInt1 + paramInt2 <= paramArrayOfFloat.length))
    {
      setFloatBufferCapacity(this.bufferSize + paramInt2);
      System.arraycopy(paramArrayOfFloat, paramInt1, this.floatBuffer, this.bufferSize, paramInt2);
    }
  }
  
  public FloatBufferInfo copy(FloatBufferInfo paramFloatBufferInfo)
  {
    paramFloatBufferInfo.bufferSize = this.bufferSize;
    paramFloatBufferInfo.floatBuffer = this.floatBuffer;
    paramFloatBufferInfo.tempFloatBuffer = this.tempFloatBuffer;
    return paramFloatBufferInfo;
  }
  
  public void fillFloat(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat != null) && (paramInt > 0))
    {
      if (paramInt > paramArrayOfFloat.length) {
        return;
      }
      this.floatBuffer = paramArrayOfFloat;
      this.bufferSize = paramInt;
    }
  }
  
  public void setFloatBufferCapacity(int paramInt)
  {
    float[] arrayOfFloat = this.floatBuffer;
    if ((arrayOfFloat == null) || (arrayOfFloat.length < paramInt)) {
      this.floatBuffer = new float[paramInt];
    }
  }
  
  public void setTempFloatBufferCapacity(int paramInt)
  {
    float[] arrayOfFloat = this.tempFloatBuffer;
    if ((arrayOfFloat == null) || (arrayOfFloat.length < paramInt)) {
      this.tempFloatBuffer = new float[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.FloatBufferInfo
 * JD-Core Version:    0.7.0.1
 */