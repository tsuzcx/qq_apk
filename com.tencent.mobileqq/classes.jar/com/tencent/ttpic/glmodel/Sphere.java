package com.tencent.ttpic.glmodel;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class Sphere
{
  private static final int AMOUNT_OF_NUMBERS_PER_TEXTURE_POINT = 2;
  private static final int AMOUNT_OF_NUMBERS_PER_VERTEX_POINT = 3;
  private static final int MAXIMUM_ALLOWED_DEPTH = 5;
  private static final int NUM_FLOATS_PER_TEXTURE = 2;
  private static final int NUM_FLOATS_PER_VERTEX = 3;
  private static final int PER_FLOAT_BYTE = 4;
  private static final int VERTEX_MAGIC_NUMBER = 5;
  private final List<FloatBuffer> mColorBuffer = new ArrayList();
  private final List<float[]> mColors = new ArrayList();
  private final List<FloatBuffer> mTextureBuffer = new ArrayList();
  private final int[] mTextures = new int[1];
  private final int mTotalNumStrips;
  private final List<FloatBuffer> mVertexBuffer = new ArrayList();
  private final List<float[]> mVertices = new ArrayList();
  
  public Sphere(int paramInt, float paramFloat)
  {
    int i = java.lang.Math.max(1, java.lang.Math.min(5, paramInt));
    this.mTotalNumStrips = (com.tencent.ttpic.baseutils.math.Math.power(2, i - 1) * 5);
    paramInt = com.tencent.ttpic.baseutils.math.Math.power(2, i) * 3;
    double d1 = com.tencent.ttpic.baseutils.math.Math.power(2, i);
    Double.isNaN(d1);
    d1 = 2.094395102393195D / d1;
    double d2 = this.mTotalNumStrips;
    Double.isNaN(d2);
    d2 = 6.283185307179586D / d2;
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < this.mTotalNumStrips)
    {
      int k = paramInt * 3;
      float[] arrayOfFloat1 = new float[k];
      int j = paramInt * 2;
      Object localObject = new float[j];
      float[] arrayOfFloat2 = new float[k];
      double d3 = i;
      Double.isNaN(d3);
      d3 *= d2;
      double d4 = 1.570796326794897D;
      int m = 0;
      int i1 = 0;
      int i2;
      for (int n = 0; m < paramInt; n = i2 + 1)
      {
        double d5 = paramFloat;
        double d6 = java.lang.Math.sin(d4);
        Double.isNaN(d5);
        double d7 = java.lang.Math.cos(d4);
        Double.isNaN(d5);
        d7 *= d5;
        double d8 = java.lang.Math.sin(d3);
        double d9 = java.lang.Math.cos(d3);
        i2 = this.mTotalNumStrips;
        float f1 = 1.0F / i2;
        float f2 = i;
        arrayOfFloat2[i1] = (f1 * f2);
        int i3 = i1 + 1;
        arrayOfFloat1[i1] = ((float)(d7 * d9));
        arrayOfFloat2[i3] = (1.0F / i2 * f2);
        int i4 = i3 + 1;
        arrayOfFloat1[i3] = ((float)(d5 * d6));
        arrayOfFloat2[i4] = (1.0F / i2 * f2);
        i1 = i4 + 1;
        arrayOfFloat1[i4] = ((float)(d7 * d8));
        i2 = n + 1;
        localObject[n] = ((float)(1.0D - d3 / 6.283185307179586D));
        n = i2 + 1;
        localObject[i2] = ((float)(1.0D - (d4 + 1.570796326794897D) / 3.141592653589793D));
        d4 -= d1;
        d3 -= d2 / 2.0D;
        d6 = java.lang.Math.sin(d4);
        Double.isNaN(d5);
        d7 = java.lang.Math.cos(d4);
        Double.isNaN(d5);
        d7 = d5 * d7;
        d8 = java.lang.Math.sin(d3);
        d9 = java.lang.Math.cos(d3);
        i2 = this.mTotalNumStrips;
        arrayOfFloat2[i1] = (1.0F / i2 * f2);
        i3 = i1 + 1;
        arrayOfFloat1[i1] = ((float)(d7 * d9));
        arrayOfFloat2[i3] = (1.0F / i2 * f2);
        i4 = i3 + 1;
        arrayOfFloat1[i3] = ((float)(d6 * d5));
        arrayOfFloat2[i4] = (1.0F / i2 * f2);
        i1 = i4 + 1;
        arrayOfFloat1[i4] = ((float)(d7 * d8));
        i2 = n + 1;
        localObject[n] = ((float)(1.0D - d3 / 6.283185307179586D));
        localObject[i2] = ((float)(1.0D - (d4 + 1.570796326794897D) / 3.141592653589793D));
        d3 += d2;
        m += 2;
      }
      this.mVertices.add(arrayOfFloat1);
      this.mColors.add(arrayOfFloat2);
      localArrayList.add(localObject);
      k *= 32;
      localObject = ByteBuffer.allocateDirect(k);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).put((float[])this.mVertices.get(i));
      ((FloatBuffer)localObject).position(0);
      this.mVertexBuffer.add(localObject);
      localObject = ByteBuffer.allocateDirect(k);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).put((float[])this.mColors.get(i));
      ((FloatBuffer)localObject).position(0);
      this.mColorBuffer.add(localObject);
      localObject = ByteBuffer.allocateDirect(j * 32);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).put((float[])localArrayList.get(i));
      ((FloatBuffer)localObject).position(0);
      this.mTextureBuffer.add(localObject);
      i += 1;
    }
  }
  
  public void draw(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.mTextures[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(paramInt4, 0);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glEnableVertexAttribArray(paramInt2);
    GLES20.glFrontFace(2304);
    paramInt4 = 0;
    while (paramInt4 < this.mTotalNumStrips)
    {
      GLES20.glVertexAttribPointer(paramInt1, 3, 5126, false, 12, (Buffer)this.mVertexBuffer.get(paramInt4));
      GLES20.glVertexAttribPointer(paramInt3, 2, 5126, false, 8, (Buffer)this.mColorBuffer.get(paramInt4));
      GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 8, (Buffer)this.mTextureBuffer.get(paramInt4));
      GLES20.glDrawArrays(5, 0, ((float[])this.mVertices.get(paramInt4)).length / 3);
      paramInt4 += 1;
    }
    GLES20.glFinish();
  }
  
  public void draw(GL10 paramGL10)
  {
    paramGL10.glBindTexture(3553, this.mTextures[0]);
    paramGL10.glEnableClientState(32884);
    paramGL10.glEnableClientState(32888);
    paramGL10.glFrontFace(2304);
    int i = 0;
    while (i < this.mTotalNumStrips)
    {
      paramGL10.glVertexPointer(3, 5126, 0, (Buffer)this.mVertexBuffer.get(i));
      paramGL10.glTexCoordPointer(2, 5126, 0, (Buffer)this.mTextureBuffer.get(i));
      paramGL10.glDrawArrays(5, 0, ((float[])this.mVertices.get(i)).length / 3);
      i += 1;
    }
    paramGL10.glDisableClientState(32884);
    paramGL10.glDisableClientState(32888);
  }
  
  public void loadGLTexture(Bitmap paramBitmap)
  {
    int[] arrayOfInt = this.mTextures;
    if (arrayOfInt[0] <= 0) {
      GLES20.glGenTextures(1, arrayOfInt, 0);
    }
    if (BitmapUtils.isLegal(paramBitmap))
    {
      GLES20.glBindTexture(3553, this.mTextures[0]);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.glmodel.Sphere
 * JD-Core Version:    0.7.0.1
 */