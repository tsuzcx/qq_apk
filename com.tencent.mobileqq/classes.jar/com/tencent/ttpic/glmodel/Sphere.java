package com.tencent.ttpic.glmodel;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.ttpic.util.Maths;
import com.tencent.ttpic.util.VideoBitmapUtil;
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
    paramInt = Math.max(1, Math.min(5, paramInt));
    this.mTotalNumStrips = (Maths.power(2, paramInt - 1) * 5);
    int m = Maths.power(2, paramInt) * 3;
    double d3 = 2.094395102393195D / Maths.power(2, paramInt);
    double d4 = 6.283185307179586D / this.mTotalNumStrips;
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    while (paramInt < this.mTotalNumStrips)
    {
      Object localObject = new float[m * 3];
      float[] arrayOfFloat1 = new float[m * 2];
      float[] arrayOfFloat2 = new float[m * 3];
      double d2 = 1.570796326794897D;
      double d1 = paramInt * d4;
      int i = 0;
      int j = 0;
      int k = 0;
      while (i < m)
      {
        double d5 = paramFloat;
        double d6 = Math.sin(d2);
        double d7 = paramFloat * Math.cos(d2);
        double d8 = Math.sin(d1);
        double d9 = Math.cos(d1);
        arrayOfFloat2[k] = (1.0F / this.mTotalNumStrips * paramInt);
        int n = k + 1;
        localObject[k] = ((float)(d7 * d9));
        arrayOfFloat2[n] = (1.0F / this.mTotalNumStrips * paramInt);
        int i1 = n + 1;
        localObject[n] = ((float)(d5 * d6));
        arrayOfFloat2[i1] = (1.0F / this.mTotalNumStrips * paramInt);
        k = i1 + 1;
        localObject[i1] = ((float)(d7 * d8));
        n = j + 1;
        arrayOfFloat1[j] = ((float)(1.0D - d1 / 6.283185307179586D));
        j = n + 1;
        arrayOfFloat1[n] = ((float)(1.0D - (1.570796326794897D + d2) / 3.141592653589793D));
        d2 -= d3;
        d1 -= d4 / 2.0D;
        d5 = paramFloat;
        d6 = Math.sin(d2);
        d7 = paramFloat * Math.cos(d2);
        d8 = Math.sin(d1);
        d9 = Math.cos(d1);
        arrayOfFloat2[k] = (1.0F / this.mTotalNumStrips * paramInt);
        n = k + 1;
        localObject[k] = ((float)(d7 * d9));
        arrayOfFloat2[n] = (1.0F / this.mTotalNumStrips * paramInt);
        i1 = n + 1;
        localObject[n] = ((float)(d5 * d6));
        arrayOfFloat2[i1] = (1.0F / this.mTotalNumStrips * paramInt);
        k = i1 + 1;
        localObject[i1] = ((float)(d7 * d8));
        n = j + 1;
        arrayOfFloat1[j] = ((float)(1.0D - d1 / 6.283185307179586D));
        j = n + 1;
        arrayOfFloat1[n] = ((float)(1.0D - (1.570796326794897D + d2) / 3.141592653589793D));
        d1 += d4;
        i += 2;
      }
      this.mVertices.add(localObject);
      this.mColors.add(arrayOfFloat2);
      localArrayList.add(arrayOfFloat1);
      localObject = ByteBuffer.allocateDirect(m * 3 * 32);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).put((float[])this.mVertices.get(paramInt));
      ((FloatBuffer)localObject).position(0);
      this.mVertexBuffer.add(localObject);
      localObject = ByteBuffer.allocateDirect(m * 3 * 32);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).put((float[])this.mColors.get(paramInt));
      ((FloatBuffer)localObject).position(0);
      this.mColorBuffer.add(localObject);
      localObject = ByteBuffer.allocateDirect(m * 2 * 32);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).put((float[])localArrayList.get(paramInt));
      ((FloatBuffer)localObject).position(0);
      this.mTextureBuffer.add(localObject);
      paramInt += 1;
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
    if (this.mTextures[0] <= 0) {
      GLES20.glGenTextures(1, this.mTextures, 0);
    }
    if (VideoBitmapUtil.isLegal(paramBitmap))
    {
      GLES20.glBindTexture(3553, this.mTextures[0]);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.glmodel.Sphere
 * JD-Core Version:    0.7.0.1
 */