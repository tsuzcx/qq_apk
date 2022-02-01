package com.tencent.mobileqq.shortvideo.panoramicvideo.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class BufferUtils
{
  public static FloatBuffer getFloatBuffer(float[] paramArrayOfFloat, int paramInt)
  {
    paramArrayOfFloat = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(paramArrayOfFloat);
    paramArrayOfFloat.position(paramInt);
    return paramArrayOfFloat;
  }
  
  public static ShortBuffer getShortBuffer(short[] paramArrayOfShort, int paramInt)
  {
    paramArrayOfShort = ByteBuffer.allocateDirect(paramArrayOfShort.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer().put(paramArrayOfShort);
    paramArrayOfShort.position(paramInt);
    return paramArrayOfShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.utils.BufferUtils
 * JD-Core Version:    0.7.0.1
 */