package dov.com.tencent.mobileqq.activity.richmedia.view;

import alin;
import android.annotation.TargetApi;
import android.content.Intent;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import bcif;
import bcig;
import bcij;
import bpzw;
import bpzy;
import bqaa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class GLVideoClipUtil
{
  private static long jdField_a_of_type_Long;
  public static String a;
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(jdField_c_of_type_Int).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static long jdField_b_of_type_Long;
  private static float[] jdField_b_of_type_ArrayOfFloat;
  private static final int jdField_c_of_type_Int;
  private static int q = -1;
  public int a;
  private bqaa jdField_a_of_type_Bqaa = new bqaa(this, null);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[2];
  public int b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private final int[] jdField_c_of_type_ArrayOfInt = new int[256];
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j = 125;
  private final int k = 256;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int r;
  private int s;
  private int t;
  private int u;
  
  static
  {
    jdField_a_of_type_JavaLangString = "precision mediump float;varying vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerUV;\nuniform float blackField;\nuniform float whiteField;\nuniform float nightMode;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nfloat fieldWidth;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.zy= texture2D(SamplerUV,texturecoordinateOut).ra-vec2(0.5, 0.5);\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nfieldWidth = whiteField - blackField;\nif (nightMode > 0.0) {\nrgb.r *= 255.0;\nrgb.r -= blackField;\nrgb.r /= fieldWidth;\nrgb.g *= 255.0;\nrgb.g -= blackField;\nrgb.g /= fieldWidth;\nrgb.b *= 255.0;\nrgb.b -= blackField;\nrgb.b /= fieldWidth;\nrgb.r = min(1.0, max(0.0, rgb.r));\nrgb.g = min(1.0, max(0.0, rgb.g));\nrgb.b = min(1.0, max(0.0, rgb.b));\n}\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n";
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
    jdField_c_of_type_Int = jdField_a_of_type_ArrayOfFloat.length * 4 + jdField_b_of_type_ArrayOfFloat.length * 4;
  }
  
  private int a()
  {
    return 6410;
  }
  
  private int a(byte[] paramArrayOfByte)
  {
    try
    {
      int i1 = memoryCopy(paramArrayOfByte);
      return i1;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -200;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    float[] arrayOfFloat = new float[16];
    float[] tmp8_6 = arrayOfFloat;
    tmp8_6[0] = 0.0F;
    float[] tmp12_8 = tmp8_6;
    tmp12_8[1] = 1.0F;
    float[] tmp16_12 = tmp12_8;
    tmp16_12[2] = 0.0F;
    float[] tmp20_16 = tmp16_12;
    tmp20_16[3] = 0.0F;
    float[] tmp24_20 = tmp20_16;
    tmp24_20[4] = 1.0F;
    float[] tmp28_24 = tmp24_20;
    tmp28_24[5] = 0.0F;
    float[] tmp32_28 = tmp28_24;
    tmp32_28[6] = 0.0F;
    float[] tmp37_32 = tmp32_28;
    tmp37_32[7] = 0.0F;
    float[] tmp42_37 = tmp37_32;
    tmp42_37[8] = 0.0F;
    float[] tmp47_42 = tmp42_37;
    tmp47_42[9] = 0.0F;
    float[] tmp52_47 = tmp47_42;
    tmp52_47[10] = 1.0F;
    float[] tmp57_52 = tmp52_47;
    tmp57_52[11] = 0.0F;
    float[] tmp62_57 = tmp57_52;
    tmp62_57[12] = 0.0F;
    float[] tmp67_62 = tmp62_57;
    tmp67_62[13] = 0.0F;
    float[] tmp72_67 = tmp67_62;
    tmp72_67[14] = 0.0F;
    float[] tmp77_72 = tmp72_67;
    tmp77_72[15] = 1.0F;
    tmp77_72;
    boolean bool1 = bcif.d(bcif.e);
    boolean bool2 = bcif.b(bcif.f);
    if ((paramBoolean) && ((bool1) || (bool2)) && (alin.jdField_a_of_type_Int == 1)) {
      System.arraycopy(arrayOfFloat, 0, this.jdField_c_of_type_ArrayOfFloat, 0, arrayOfFloat.length);
    }
    for (;;)
    {
      float f1 = (1.0F - paramInt1 * 1.0F / this.s) / 2.0F;
      float f2 = (paramInt1 * 1.0F / this.s + 1.0F) / 2.0F;
      float f3 = (1.0F - paramInt2 * 1.0F / this.r) / 2.0F;
      float f4 = (paramInt2 * 1.0F / this.r + 1.0F) / 2.0F;
      arrayOfFloat = jdField_b_of_type_ArrayOfFloat;
      paramInt1 = jdField_b_of_type_ArrayOfFloat.length;
      System.arraycopy(new float[] { f1, f4, f2, f4, f2, f3, f1, f3 }, 0, arrayOfFloat, 0, paramInt1);
      return;
      bool1 = bcif.d(bcif.g);
      if (bool1) {
        paramBoolean = false;
      }
      if ((bool1) && (alin.jdField_a_of_type_Int == 2)) {
        Matrix.multiplyMM(this.jdField_c_of_type_ArrayOfFloat, 0, new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F }, 0, arrayOfFloat, 0);
      } else if (paramBoolean) {
        Matrix.multiplyMM(this.jdField_c_of_type_ArrayOfFloat, 0, new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F }, 0, arrayOfFloat, 0);
      } else {
        Matrix.multiplyMM(this.jdField_c_of_type_ArrayOfFloat, 0, new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F }, 0, arrayOfFloat, 0);
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    if ((this.r <= 0) || (this.s <= 0))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        throw new GLVideoClipUtil.GLClipOldLibException("checkDataLength: mPreviewWidth=" + this.r + " mPreviewHeight=" + this.s);
      }
    }
    else
    {
      long l1 = this.r * this.s * 3 / 2;
      if (l1 != paramInt)
      {
        bqaa localbqaa = this.jdField_a_of_type_Bqaa;
        localbqaa.jdField_a_of_type_Int += 1;
        bool = true;
        if (this.jdField_a_of_type_Bqaa.jdField_a_of_type_Int >= 3) {
          throw new GLVideoClipUtil.GLClipOldLibException("checkDataLength: dataSize=" + l1 + " length=" + paramInt + "prev*preh=" + this.r + " * " + this.s);
        }
      }
      else
      {
        this.jdField_a_of_type_Bqaa.jdField_a_of_type_Int = 0;
      }
    }
    return bool;
  }
  
  private native int allocNativeMemory(int paramInt1, int paramInt2, int paramInt3, ByteBuffer[] paramArrayOfByteBuffer);
  
  private int b()
  {
    try
    {
      int i1 = getNativeSize();
      return i1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return -200;
  }
  
  private void b()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_b_of_type_ArrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    d();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.jdField_b_of_type_ArrayOfInt[1]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    d();
  }
  
  public static boolean b()
  {
    return q > 0;
  }
  
  private void c()
  {
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    this.d = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerY");
    this.e = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "SamplerUV");
    this.f = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "position");
    this.g = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "textureCoordinateIn");
    this.l = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "blackField");
    this.m = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "whiteField");
    this.n = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "nightMode");
    this.h = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "uSTMatrix");
  }
  
  private boolean c()
  {
    if ((this.r > 0) && (this.s > 0)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoClipUtil", 2, "checkPreviewSize: mPreviewWidth=" + this.r + " mPreviewHeight=" + this.s);
    }
    return false;
  }
  
  private void d()
  {
    int i1 = GLES20.glGetError();
    if ((i1 != 0) && (i1 != 0) && (QLog.isColorLevel())) {
      QLog.d("GLVideoClipUtil", 2, "glError error = " + i1);
    }
  }
  
  private void e()
  {
    int i1 = this.r * this.s;
    int i2 = i1 / 2;
    try
    {
      i1 = allocNativeMemory(i1 + i2, i1, i2, this.jdField_a_of_type_ArrayOfJavaNioByteBuffer);
      if (i1 != 0) {
        throw new GLVideoClipUtil.GLClipOldLibException("allocNativeMemory:err=" + i1);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        i1 = -200;
      }
    }
  }
  
  private native int getNativeSize();
  
  private native int initClipSpec(int paramInt1, int paramInt2);
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    bcij localbcij = bcig.a().a();
    int i4 = paramInt1;
    int i3 = paramInt2;
    int i2 = paramInt3;
    int i1 = paramInt4;
    if (localbcij != null)
    {
      QLog.d("GLVideoClipUtil", 2, "allocateNativeBuffer[CameraControl-]: Width=" + localbcij.jdField_a_of_type_Int + " Height=" + localbcij.jdField_b_of_type_Int + " width1" + paramInt1 + " height1" + paramInt2);
      i4 = paramInt1;
      i3 = paramInt2;
      i2 = paramInt3;
      i1 = paramInt4;
      if (localbcij.jdField_a_of_type_Int > 0)
      {
        i4 = paramInt1;
        i3 = paramInt2;
        i2 = paramInt3;
        i1 = paramInt4;
        if (localbcij.jdField_b_of_type_Int > 0) {
          if (localbcij.jdField_a_of_type_Int == paramInt1)
          {
            i4 = paramInt1;
            i3 = paramInt2;
            i2 = paramInt3;
            i1 = paramInt4;
            if (localbcij.jdField_b_of_type_Int == paramInt2) {}
          }
          else
          {
            if ((paramInt1 != paramInt4) || (paramInt2 != paramInt3)) {
              break label285;
            }
            paramInt2 = localbcij.jdField_b_of_type_Int;
            paramInt1 = localbcij.jdField_a_of_type_Int;
          }
        }
      }
    }
    for (;;)
    {
      i4 = localbcij.jdField_a_of_type_Int;
      i3 = localbcij.jdField_b_of_type_Int;
      QLog.d("GLVideoClipUtil", 2, "allocateNativeBuffer[Adjust]: clipwidth=" + paramInt2 + " clipheight=" + paramInt1);
      i1 = paramInt1;
      i2 = paramInt2;
      try
      {
        paramInt1 = initClipSpec(i4, i3);
        if (paramInt1 != 0)
        {
          throw new GLVideoClipUtil.GLClipOldLibException("initClipSpec:err=" + paramInt1);
          label285:
          if (paramInt4 * 1.0F / paramInt3 > localbcij.jdField_a_of_type_Int * 1.0F / localbcij.jdField_b_of_type_Int)
          {
            paramInt1 = (int)(localbcij.jdField_a_of_type_Int * paramInt3 * 1.0F / paramInt4);
            paramInt2 = paramInt1 - paramInt1 % 16;
            paramInt1 = localbcij.jdField_a_of_type_Int;
            continue;
          }
          paramInt2 = localbcij.jdField_b_of_type_Int;
          paramInt1 = (int)(localbcij.jdField_b_of_type_Int * paramInt4 * 1.0F / paramInt3);
          paramInt1 -= paramInt1 % 16;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
          paramInt1 = -200;
        }
        this.r = i4;
        this.s = i3;
        this.t = i2;
        this.u = i1;
        c();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        e();
        a(i2, i1, paramBoolean);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      i1 = paramArrayOfByte.length;
      if (i1 > 0) {
        break label50;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GLVideoClipUtil", 2, "checkDataLength[invalid source data]: dataLength=" + i1);
      }
    }
    label50:
    label99:
    label126:
    int[] arrayOfInt;
    do
    {
      do
      {
        boolean bool;
        do
        {
          return;
          i1 = -1;
          break;
          bool = c();
          if (!a(i1)) {
            break label99;
          }
        } while (!QLog.isColorLevel());
        QLog.d("GLVideoClipUtil", 2, "checkPreviewSize[copyDataToByteBuffer]:sizeError=true res=" + bool);
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label126;
        }
      } while (!QLog.isColorLevel());
      QLog.d("GLVideoClipUtil", 2, "checkPreviewSize[copyDataToByteBuffer]: mInitedPreviewSize=false");
      return;
      i3 = a(paramArrayOfByte);
      i2 = i3;
      if (i3 == -4)
      {
        e();
        i2 = a(paramArrayOfByte);
      }
      if (i2 != 0) {
        throw new GLVideoClipUtil.GLClipOldLibException("memoryCopy[Afterfix]:err=" + i2 + "  length=" + i1 + " NativeSize=" + b());
      }
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].position(0);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].position(0);
      arrayOfInt = ShortVideoUtils.a();
      if (arrayOfInt[0] != 1) {
        break label672;
      }
      this.jdField_b_of_type_Int += 1;
    } while (this.jdField_b_of_type_Int % 8 != 0);
    long l1 = SystemClock.uptimeMillis();
    this.i = (this.r * this.s * (100 - arrayOfInt[1]) / 100);
    this.j = arrayOfInt[2];
    Arrays.fill(this.jdField_c_of_type_ArrayOfInt, 0);
    int i1 = 1;
    while (i1 < this.s)
    {
      i2 = 1;
      while (i2 < this.r)
      {
        arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
        i3 = paramArrayOfByte[(this.r * i1 + i2)] & 0xFF;
        arrayOfInt[i3] += 64;
        i2 += 8;
      }
      i1 += 8;
    }
    int i2 = 255;
    i1 = 255;
    int i3 = 0;
    if (i1 >= 51)
    {
      i3 += this.jdField_c_of_type_ArrayOfInt[i1];
      if (i3 < this.i) {}
    }
    for (;;)
    {
      this.o = 0;
      this.p = i1;
      if (this.p <= this.j)
      {
        jdField_b_of_type_Long = 0L;
        if (jdField_a_of_type_Long == 0L) {
          jdField_a_of_type_Long = System.currentTimeMillis();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label670;
        }
        QLog.d("GLVideoClipUtil", 2, "blackField = " + 0 + ", whiteField = " + i1 + ", cost = " + (SystemClock.uptimeMillis() - l1));
        return;
        i2 = i1;
        i1 -= 1;
        break;
        if ((jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - jdField_a_of_type_Long >= 1500L))
        {
          paramArrayOfByte = new Intent("tencent.video.q2v.nightMode");
          paramArrayOfByte.putExtra("dark_mode_value", true);
          BaseApplicationImpl.getApplication().sendBroadcast(paramArrayOfByte);
          jdField_a_of_type_Long = -1L;
          jdField_b_of_type_Long = 0L;
          continue;
          if (jdField_a_of_type_Long > 0L) {
            jdField_a_of_type_Long = 0L;
          }
          if (jdField_b_of_type_Long == 0L)
          {
            jdField_b_of_type_Long = System.currentTimeMillis();
          }
          else if ((jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - jdField_b_of_type_Long >= 2000L))
          {
            paramArrayOfByte = new Intent("tencent.video.q2v.nightMode");
            paramArrayOfByte.putExtra("dark_mode_value", false);
            BaseApplicationImpl.getApplication().sendBroadcast(paramArrayOfByte);
            jdField_b_of_type_Long = -1L;
          }
        }
      }
      label670:
      break;
      label672:
      q = -1;
      return;
      i1 = i2;
    }
  }
  
  @TargetApi(9)
  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i1 = jdField_a_of_type_JavaNioFloatBuffer.capacity();
    jdField_a_of_type_JavaNioFloatBuffer.limit(i1);
    jdField_a_of_type_JavaNioFloatBuffer.position(0);
    jdField_a_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
    jdField_a_of_type_JavaNioFloatBuffer.put(jdField_b_of_type_ArrayOfFloat);
    jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glGenBuffers(1, paramArrayOfInt, 0);
    GLES20.glBindBuffer(34962, paramArrayOfInt[0]);
    GLES20.glBufferData(34962, jdField_c_of_type_Int, jdField_a_of_type_JavaNioFloatBuffer, 35044);
    GLES20.glVertexAttribPointer(paramInt1, 2, 5126, false, 0, 0);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 0, jdField_a_of_type_ArrayOfFloat.length * 4);
    GLES20.glEnableVertexAttribArray(paramInt2);
    d();
  }
  
  public boolean a()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glEnable(2884);
    GLES20.glFrontFace(2305);
    GLES20.glCullFace(1029);
    d();
    this.jdField_a_of_type_Int = bpzy.a("precision highp float;\nattribute vec4 position;\nattribute vec4 textureCoordinateIn;\nuniform   mat4 uSTMatrix;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = (uSTMatrix * textureCoordinateIn).xy;\ngl_Position = position;\n}\n", jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int == 0)
    {
      CameraGLSurfaceView.a("GLVideoHelper.createShaderProgram: mGLProgram=" + this.jdField_a_of_type_Int);
      return false;
    }
    c();
    d();
    a(this.jdField_a_of_type_ArrayOfInt, this.f, this.g);
    GLES20.glGenTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
    b();
    GLES20.glViewport(0, 0, this.t, this.u);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    int i1;
    boolean bool;
    do
    {
      return paramBoolean;
      d();
      GLES20.glActiveTexture(33984);
      if (!paramBoolean)
      {
        GLES20.glTexImage2D(3553, 0, 6409, this.r, this.s, 0, 6409, 5121, null);
        d();
      }
      GLES20.glTexSubImage2D(3553, 0, 0, 0, this.r, this.s, 6409, 5121, this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0]);
      d();
      GLES20.glUniform1i(this.d, 0);
      i1 = a();
      GLES20.glActiveTexture(33985);
      bool = paramBoolean;
      if (!paramBoolean)
      {
        GLES20.glTexImage2D(3553, 0, i1, this.r / 2, this.s / 2, 0, i1, 5121, null);
        d();
        bool = true;
      }
      GLES20.glTexSubImage2D(3553, 0, 0, 0, this.r / 2, this.s / 2, i1, 5121, this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1]);
      d();
      GLES20.glUniform1i(this.e, 1);
      GLES20.glUniform1f(this.l, this.o);
      GLES20.glUniform1f(this.m, this.p);
      GLES20.glUniform1f(this.n, -1.0F);
      GLES20.glUniformMatrix4fv(this.h, 1, false, this.jdField_c_of_type_ArrayOfFloat, 0);
      GLES20.glDrawArrays(6, 0, 4);
      i1 = GLES20.glGetError();
      paramBoolean = bool;
    } while (i1 == 0);
    bpzw.a("glError:err=" + i1 + " errname=" + bpzw.a(i1));
    return bool;
  }
  
  public native int memoryCopy(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil
 * JD-Core Version:    0.7.0.1
 */