package com.tencent.mobileqq.magicface.model;

import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ShaderUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;

public class MagicFaceGLDisplayer
{
  private static final short[] I = { 0, 1, 2, 2, 3, 0 };
  private boolean A = false;
  private byte[] B = null;
  private byte[] C = null;
  private byte[] D = null;
  private byte[] E = null;
  private byte[] F = null;
  private byte[] G = null;
  private HashMap<String, ByteBuffer> H = new HashMap();
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k;
  private int l;
  private int m;
  private int n = -1;
  private int o = -1;
  private int p = -1;
  private FloatBuffer q = null;
  private FloatBuffer r = null;
  private ShortBuffer s = null;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private int x = 0;
  private int y = 0;
  private float z = -1.0F;
  
  public MagicFaceGLDisplayer()
  {
    b();
    a();
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject1 = IntBuffer.allocate(1);
    GLES20.glGenTextures(1, (IntBuffer)localObject1);
    int i1 = ((IntBuffer)localObject1).get();
    GLES20.glBindTexture(3553, i1);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    localObject1 = this.H;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramArrayOfByte.length);
    ((StringBuilder)localObject2).append("");
    localObject2 = (ByteBuffer)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
    localObject1 = localObject2;
    if (localObject2 == null) {
      try
      {
        localObject1 = ByteBuffer.allocateDirect(paramArrayOfByte.length);
        localObject2 = this.H;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramArrayOfByte.length);
        localStringBuilder.append("");
        ((HashMap)localObject2).put(localStringBuilder.toString(), localObject1);
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -2015;
      }
    }
    ((ByteBuffer)localObject1).order(ByteOrder.nativeOrder());
    ((ByteBuffer)localObject1).put(paramArrayOfByte);
    ((ByteBuffer)localObject1).position(0);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, (Buffer)localObject1);
    return i1;
  }
  
  private void a(float paramFloat)
  {
    double d1 = paramFloat * 3.14159F / 180.0F;
    paramFloat = (float)Math.sin(d1);
    float f1 = (float)Math.cos(d1);
    float[] arrayOfFloat = new float[16];
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = paramFloat;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (-paramFloat);
    arrayOfFloat[5] = f1;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 1.0F;
    Object localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(arrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    GLES20.glUniformMatrix4fv(this.g, 1, false, (FloatBuffer)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = this.x / this.v * this.w / this.y;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func updateRenderParam, [yCord]=");
      ((StringBuilder)localObject1).append(f1);
      QLog.d("MagicFaceGLDisplayer", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = this.t;
    float f2 = (i1 - this.v) / i1 / 2.0F;
    i1 = this.u;
    float f3 = (i1 - this.w) / i1 / 2.0F;
    Object localObject2 = new float[12];
    localObject2[0] = 1.0F;
    float f4 = -f1;
    localObject2[1] = f4;
    localObject2[2] = 0.0F;
    localObject2[3] = 1.0F;
    localObject2[4] = f1;
    localObject2[5] = 0.0F;
    localObject2[6] = -1.0F;
    localObject2[7] = f1;
    localObject2[8] = 0.0F;
    localObject2[9] = -1.0F;
    localObject2[10] = f4;
    localObject2[11] = 0.0F;
    Object localObject1 = new float[8];
    float f1 = 1.0F - f2;
    localObject1[0] = f1;
    f4 = 1.0F - f3;
    localObject1[1] = f4;
    localObject1[2] = f1;
    localObject1[3] = f3;
    localObject1[4] = f2;
    localObject1[5] = f3;
    localObject1[6] = f2;
    localObject1[7] = f4;
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(localObject2.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.q = localByteBuffer.asFloatBuffer();
    this.q.put((float[])localObject2);
    this.q.position(0);
    localObject2 = ByteBuffer.allocateDirect(localObject1.length * 4);
    ((ByteBuffer)localObject2).order(ByteOrder.nativeOrder());
    this.r = ((ByteBuffer)localObject2).asFloatBuffer();
    this.r.put((float[])localObject1);
    this.r.position(0);
  }
  
  private void b()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(I.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.s = localByteBuffer.asShortBuffer();
    this.s.put(I);
    this.s.position(0);
  }
  
  public void a()
  {
    this.a = ShaderUtil.a("attribute vec4 position;\nattribute mediump vec2 textureCoordinate;\nvarying mediump vec2 coordinate;\nuniform mat4 transformMatrix;\nvoid main()\n{\n   gl_Position = position * transformMatrix; \n   coordinate = textureCoordinate; \n}\n", "precision highp float;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform sampler2D SamplerY_Alpha;\nuniform sampler2D SamplerU_Alpha;\nuniform sampler2D SamplerV_Alpha;\nvarying highp vec2 coordinate;\nvoid main()\n{\n    highp vec3 yuv;\n    highp vec3 rgb;    \n    yuv.x = texture2D(SamplerY, coordinate).r;    \n    yuv.y = texture2D(SamplerU, coordinate).r-0.5;    \n    yuv.z = texture2D(SamplerV, coordinate).r-0.5 ;    \n    rgb = mat3(      1,       1,      1,\n                       0,         -.34414, 1.772,\n                       1.402,     -.71414, 0) * yuv;    \n    highp vec3 yuv_Alpha;\n    highp vec3 rgb_Alpha;    \n    yuv_Alpha.x = texture2D(SamplerY_Alpha, coordinate).r;    \n    yuv_Alpha.y = texture2D(SamplerU_Alpha, coordinate).r-0.5;    \n    yuv_Alpha.z = texture2D(SamplerV_Alpha, coordinate).r-0.5 ;    \n    rgb_Alpha = mat3(      1,       1,      1,\n                       0,         -.34414, 1.772,\n                       1.402,     -.71414, 0) * yuv_Alpha;    \n         if(rgb_Alpha[0]  <= 0.196 ){   \n               rgb_Alpha[0] = 0.0;}   \n         else if(rgb_Alpha[0]  >= 0.922){     \n               rgb_Alpha[0] = 1.0;}  \n    gl_FragColor = vec4(rgb.r * rgb_Alpha.r ,rgb.g * rgb_Alpha.r ,rgb.b * rgb_Alpha.r, rgb_Alpha.r) ;\n}\n");
    GLES20.glUseProgram(this.a);
    this.b = GLES20.glGetAttribLocation(this.a, "position");
    this.c = GLES20.glGetAttribLocation(this.a, "textureCoordinate");
    this.d = GLES20.glGetUniformLocation(this.a, "SamplerY");
    this.e = GLES20.glGetUniformLocation(this.a, "SamplerU");
    this.f = GLES20.glGetUniformLocation(this.a, "SamplerV");
    this.k = GLES20.glGetUniformLocation(this.a, "SamplerY_Alpha");
    this.l = GLES20.glGetUniformLocation(this.a, "SamplerU_Alpha");
    this.m = GLES20.glGetUniformLocation(this.a, "SamplerV_Alpha");
    this.g = GLES20.glGetUniformLocation(this.a, "transformMatrix");
    GLES20.glEnableVertexAttribArray(this.b);
    GLES20.glEnableVertexAttribArray(this.c);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func draw begins, _srcwidth:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",_srcheight:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",_dstWidth:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",_dstHeight:");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(",isFull:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MagicFaceGLDisplayer", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 <= 700) && (paramInt2 <= 900))
    {
      GLES20.glClear(16640);
      this.x = paramInt3;
      this.y = paramInt4;
      this.t = paramInt1;
      this.u = paramInt2;
      this.v = paramInt1;
      this.w = paramInt2;
      if (this.z == -1.0F)
      {
        this.z = paramFloat;
        this.A = paramBoolean;
        a(this.A);
        a(this.z);
      }
      if (this.z != paramFloat)
      {
        this.z = paramFloat;
        a(this.z);
      }
      if (this.A != paramBoolean)
      {
        this.A = paramBoolean;
        a(this.A);
      }
      if ((this.t != this.v) || (this.u != this.w)) {
        a(this.A);
      }
      localObject = this.B;
      if (localObject == null)
      {
        this.B = new byte[this.t * this.u];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.t;
        paramInt3 = this.u;
        if (paramInt1 != paramInt2 * paramInt3) {
          this.B = new byte[paramInt2 * paramInt3];
        }
      }
      localObject = this.C;
      if (localObject == null)
      {
        this.C = new byte[this.t * this.u / 4];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.t;
        paramInt3 = this.u;
        if (paramInt1 != paramInt2 * paramInt3 / 4) {
          this.C = new byte[paramInt2 * paramInt3 / 4];
        }
      }
      localObject = this.D;
      if (localObject == null)
      {
        this.D = new byte[this.t * this.u / 4];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.t;
        paramInt3 = this.u;
        if (paramInt1 != paramInt2 * paramInt3 / 4) {
          this.D = new byte[paramInt2 * paramInt3 / 4];
        }
      }
      localObject = this.E;
      if (localObject == null)
      {
        this.E = new byte[this.t * this.u];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.t;
        paramInt3 = this.u;
        if (paramInt1 != paramInt2 * paramInt3) {
          this.E = new byte[paramInt2 * paramInt3];
        }
      }
      localObject = this.F;
      if (localObject == null)
      {
        this.F = new byte[this.t * this.u / 4];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.t;
        paramInt3 = this.u;
        if (paramInt1 != paramInt2 * paramInt3 / 4) {
          this.F = new byte[paramInt2 * paramInt3 / 4];
        }
      }
      localObject = this.G;
      if (localObject == null)
      {
        this.G = new byte[this.t * this.u / 4];
      }
      else
      {
        paramInt1 = localObject.length;
        paramInt2 = this.t;
        paramInt3 = this.u;
        if (paramInt1 != paramInt2 * paramInt3 / 4) {
          this.G = new byte[paramInt2 * paramInt3 / 4];
        }
      }
    }
    try
    {
      System.arraycopy(paramArrayOfByte1, 0, this.B, 0, this.t * this.u);
      System.arraycopy(paramArrayOfByte1, this.t * this.u, this.C, 0, this.t * this.u / 4);
      System.arraycopy(paramArrayOfByte1, this.t * this.u * 5 / 4, this.D, 0, this.t * this.u / 4);
      System.arraycopy(paramArrayOfByte2, 0, this.E, 0, this.t * this.u);
      System.arraycopy(paramArrayOfByte2, this.t * this.u, this.F, 0, this.t * this.u / 4);
      System.arraycopy(paramArrayOfByte2, this.t * this.u * 5 / 4, this.G, 0, this.t * this.u / 4);
      paramInt1 = this.h;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.i;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.j;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.n;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.o;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      paramInt1 = this.p;
      if (paramInt1 != -1) {
        GLES20.glDeleteTextures(1, new int[] { paramInt1 }, 0);
      }
      this.h = a(this.B, this.t, this.u);
      this.i = a(this.C, this.t / 2, this.u / 2);
      this.j = a(this.D, this.t / 2, this.u / 2);
      this.n = a(this.E, this.t, this.u);
      this.o = a(this.F, this.t / 2, this.u / 2);
      this.p = a(this.G, this.t / 2, this.u / 2);
      if ((this.h != -2015) && (this.i != -2015) && (this.j != -2015) && (this.n != -2015) && (this.o != -2015))
      {
        if (this.p == -2015) {
          return;
        }
        GLES20.glVertexAttribPointer(this.b, 3, 5126, false, 12, this.q);
        GLES20.glVertexAttribPointer(this.c, 2, 5126, false, 8, this.r);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.n);
        GLES20.glUniform1i(this.k, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.o);
        GLES20.glUniform1i(this.l, 1);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.p);
        GLES20.glUniform1i(this.m, 2);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.h);
        GLES20.glUniform1i(this.d, 3);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.i);
        GLES20.glUniform1i(this.e, 4);
        GLES20.glActiveTexture(33989);
        GLES20.glBindTexture(3553, this.j);
        GLES20.glUniform1i(this.f, 5);
        GLES20.glDrawElements(4, I.length, 5123, this.s);
        if (QLog.isColorLevel()) {
          QLog.d("MagicFaceGLDisplayer", 2, "func draw ends");
        }
      }
      return;
    }
    catch (OutOfMemoryError paramArrayOfByte1)
    {
      label1399:
      break label1399;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MagicFaceGLDisplayer", 2, "ooooom happens.");
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLDisplayer", 2, "func draw ends, video size is too big. something must be wrong");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicFaceGLDisplayer
 * JD-Core Version:    0.7.0.1
 */