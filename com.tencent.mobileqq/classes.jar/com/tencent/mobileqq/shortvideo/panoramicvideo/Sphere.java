package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Sphere
{
  private static final int sPositionDataSize = 3;
  private static final int sTextureCoordinateDataSize = 2;
  private ShortBuffer indexBuffer;
  private int mNumIndices;
  private FloatBuffer mTexCoordinateBuffer;
  private FloatBuffer mVerticesBuffer;
  
  public Sphere(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = 1.0F / paramInt1;
    float f2 = 1.0F / paramInt2;
    int i3 = paramInt1 + 1;
    int i1 = paramInt2 + 1;
    int k = i3 * i1;
    Object localObject1 = new float[k * 3];
    Object localObject2 = new float[k * 2];
    short[] arrayOfShort = new short[k * 6];
    int m = 0;
    k = 0;
    int i2;
    int i4;
    for (int n = 0; m < i3; n = i2)
    {
      i2 = k;
      i4 = 0;
      k = n;
      n = i2;
      i2 = m;
      m = i3;
      while (i4 < i1)
      {
        float f3 = i4;
        double d1 = 6.283186F * f3 * f2;
        double d2 = Math.cos(d1);
        float f4 = i2;
        float f6 = 3.141593F * f4 * f1;
        double d3 = f6;
        float f5 = (float)(d2 * Math.sin(d3));
        f6 = (float)Math.sin(f6 - 1.570796F);
        float f7 = (float)(Math.sin(d1) * Math.sin(d3));
        i3 = n + 1;
        localObject2[n] = (f3 * f2);
        n = i3 + 1;
        localObject2[i3] = (f4 * f1);
        i3 = k + 1;
        localObject1[k] = (f5 * paramFloat);
        int i5 = i3 + 1;
        localObject1[i3] = (f6 * paramFloat);
        k = i5 + 1;
        localObject1[i5] = (f7 * paramFloat);
        i4 = (short)(i4 + 1);
      }
      i4 = (short)(i2 + 1);
      i2 = k;
      i3 = m;
      m = i4;
      k = n;
    }
    m = 0;
    k = 0;
    while (m < paramInt1)
    {
      for (n = 0; n < paramInt2; n = (short)n)
      {
        i4 = k + 1;
        i3 = m * i1;
        arrayOfShort[k] = ((short)(i3 + n));
        k = i4 + 1;
        i2 = (m + 1) * i1;
        int i = (short)(i2 + n);
        arrayOfShort[i4] = i;
        i4 = k + 1;
        n += 1;
        int j = (short)(i3 + n);
        arrayOfShort[k] = j;
        k = i4 + 1;
        arrayOfShort[i4] = j;
        i3 = k + 1;
        arrayOfShort[k] = i;
        k = i3 + 1;
        arrayOfShort[i3] = ((short)(i2 + n));
      }
      m = (short)(m + 1);
    }
    Object localObject3 = ByteBuffer.allocateDirect(localObject1.length * 4);
    ((ByteBuffer)localObject3).order(ByteOrder.nativeOrder());
    localObject3 = ((ByteBuffer)localObject3).asFloatBuffer();
    ((FloatBuffer)localObject3).put((float[])localObject1);
    ((FloatBuffer)localObject3).position(0);
    localObject1 = ByteBuffer.allocateDirect(localObject2.length * 4);
    ((ByteBuffer)localObject1).order(ByteOrder.nativeOrder());
    localObject1 = ((ByteBuffer)localObject1).asFloatBuffer();
    ((FloatBuffer)localObject1).put((float[])localObject2);
    ((FloatBuffer)localObject1).position(0);
    localObject2 = ByteBuffer.allocateDirect(arrayOfShort.length * 2);
    ((ByteBuffer)localObject2).order(ByteOrder.nativeOrder());
    this.indexBuffer = ((ByteBuffer)localObject2).asShortBuffer();
    this.indexBuffer.put(arrayOfShort);
    this.indexBuffer.position(0);
    this.mTexCoordinateBuffer = ((FloatBuffer)localObject1);
    this.mVerticesBuffer = ((FloatBuffer)localObject3);
    this.mNumIndices = arrayOfShort.length;
  }
  
  public void draw()
  {
    ShortBuffer localShortBuffer = this.indexBuffer;
    if (localShortBuffer != null)
    {
      localShortBuffer.position(0);
      GLES20.glDrawElements(4, this.mNumIndices, 5123, this.indexBuffer);
      return;
    }
    GLES20.glDrawArrays(4, 0, this.mNumIndices);
  }
  
  public FloatBuffer getTexCoordinateBuffer()
  {
    return this.mTexCoordinateBuffer;
  }
  
  public FloatBuffer getVerticesBuffer()
  {
    return this.mVerticesBuffer;
  }
  
  public void uploadTexCoordinateBuffer(int paramInt)
  {
    FloatBuffer localFloatBuffer = getTexCoordinateBuffer();
    if (localFloatBuffer == null) {
      return;
    }
    localFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(paramInt, 2, 5126, false, 0, localFloatBuffer);
    GlUtil.checkGlError("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(paramInt);
    GlUtil.checkGlError("glEnableVertexAttribArray maTextureHandle");
  }
  
  public void uploadVerticesBuffer(int paramInt)
  {
    FloatBuffer localFloatBuffer = getVerticesBuffer();
    if (localFloatBuffer == null) {
      return;
    }
    localFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(paramInt, 3, 5126, false, 0, localFloatBuffer);
    GlUtil.checkGlError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(paramInt);
    GlUtil.checkGlError("glEnableVertexAttribArray maPositionHandle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.Sphere
 * JD-Core Version:    0.7.0.1
 */