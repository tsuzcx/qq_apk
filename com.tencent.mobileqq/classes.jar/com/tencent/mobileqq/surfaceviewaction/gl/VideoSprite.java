package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import azze;
import baaa;
import baac;
import baaj;
import baak;
import baao;
import baap;
import baaq;
import baar;
import baas;
import baay;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class VideoSprite
  extends baaj
  implements SurfaceTexture.OnFrameAvailableListener, baac, baak, Runnable
{
  protected static final short[] b;
  protected SurfaceTexture a;
  public MediaPlayer a;
  public Handler a;
  protected Surface a;
  public baaa a;
  protected baaq a;
  public baar a;
  protected int[] a;
  protected azze b;
  public SpriteGLView b;
  protected String b;
  protected ShortBuffer b;
  public boolean b;
  protected FloatBuffer c;
  public boolean c;
  protected float[] c;
  protected FloatBuffer d;
  public boolean d;
  protected float[] d;
  protected FloatBuffer e;
  protected boolean e;
  protected float[] e;
  protected boolean f;
  protected float[] f;
  protected int g;
  public boolean g;
  protected float h;
  protected int h;
  protected boolean h;
  protected int i;
  protected boolean i;
  protected int j;
  public boolean j;
  protected int k;
  protected boolean k;
  protected int l;
  protected int m;
  public int n;
  public int o;
  
  static
  {
    jdField_b_of_type_ArrayOfShort = new short[] { 0, 1, 2, 0, 2, 3 };
  }
  
  public VideoSprite(SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    this.jdField_c_of_type_ArrayOfFloat = new float[] { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
    this.jdField_h_of_type_Float = 0.5F;
    this.jdField_a_of_type_ArrayOfInt = new int[1];
    this.jdField_f_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Azze = new azze(0.0F, 0.0F);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (float f1 = 0.5F;; f1 = 1.0F)
    {
      this.jdField_h_of_type_Float = f1;
      this.jdField_d_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, this.jdField_h_of_type_Float, 0.0F, 0.0F, 1.0F, this.jdField_h_of_type_Float, 1.0F, 0.0F, 1.0F };
      this.jdField_e_of_type_ArrayOfFloat = new float[] { this.jdField_h_of_type_Float, 1.0F, 0.0F, 1.0F, this.jdField_h_of_type_Float, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new baao(this, null));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new baap(this, null));
      paramSpriteGLView.a(this);
      paramSpriteGLView.b(new VideoSprite.1(this));
      return;
    }
  }
  
  private void k()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_b_of_type_ArrayOfShort.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_b_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
    this.jdField_b_of_type_JavaNioShortBuffer.put(jdField_b_of_type_ArrayOfShort);
    this.jdField_b_of_type_JavaNioShortBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.jdField_c_of_type_ArrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_e_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_e_of_type_JavaNioFloatBuffer.put(this.jdField_c_of_type_ArrayOfFloat);
    this.jdField_e_of_type_JavaNioFloatBuffer.position(0);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {}
    do
    {
      return;
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.jdField_d_of_type_ArrayOfFloat.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.jdField_c_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
      this.jdField_c_of_type_JavaNioFloatBuffer.put(this.jdField_d_of_type_ArrayOfFloat);
      this.jdField_c_of_type_JavaNioFloatBuffer.position(0);
      localByteBuffer = ByteBuffer.allocateDirect(this.jdField_e_of_type_ArrayOfFloat.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.jdField_d_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
      this.jdField_d_of_type_JavaNioFloatBuffer.put(this.jdField_e_of_type_ArrayOfFloat);
      this.jdField_d_of_type_JavaNioFloatBuffer.position(0);
      GLES20.glActiveTexture(33984);
      GLES20.glGenTextures(1, this.jdField_a_of_type_ArrayOfInt, 0);
      d("Texture generate");
      GLES20.glBindTexture(36197, this.jdField_a_of_type_ArrayOfInt[0]);
      d("Texture bind");
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_ArrayOfInt[0]);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      if (this.jdField_a_of_type_AndroidViewSurface != null) {
        this.jdField_a_of_type_AndroidViewSurface.release();
      }
      this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("VideoSprite", 2, QLog.getStackTraceString(localException));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      try
      {
        int i1 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        return i1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, "getCurrentTime: " + QLog.getStackTraceString(localException));
        }
      }
    }
    return 0;
  }
  
  protected String a()
  {
    return baay.a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "VertexShaderVideo.glsl");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(null);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(null);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(null);
    }
    catch (Exception localException2)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
            this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
            this.jdField_h_of_type_Boolean = false;
            this.jdField_a_of_type_Baaa = null;
            this.jdField_a_of_type_Baaq = null;
            this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new VideoSprite.4(this));
            this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(this);
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
            return;
            localException1 = localException1;
            if (QLog.isColorLevel())
            {
              QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException1));
              continue;
              localException2 = localException2;
              if (QLog.isColorLevel()) {
                QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException2));
              }
            }
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException3));
            }
          }
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    float f4;
    label45:
    float f1;
    label62:
    float f2;
    if (this.jdField_a_of_type_Float != 0.0F)
    {
      f3 = this.jdField_a_of_type_Float / this.jdField_h_of_type_Float;
      if (this.jdField_b_of_type_Float == 0.0F) {
        break label322;
      }
      f4 = this.jdField_b_of_type_Float;
      if (!this.jdField_b_of_type_Boolean) {
        break label332;
      }
      f1 = this.jdField_e_of_type_Float * b();
      f2 = f1;
      if (this.jdField_d_of_type_Boolean)
      {
        f2 = f1;
        if (this.jdField_b_of_type_Boolean)
        {
          f2 = f1;
          if (paramInt1 / f3 < paramInt2 / f4) {
            f2 = f1 * (paramInt2 * f3 / (paramInt1 * f4));
          }
        }
      }
      f4 = paramInt1 / this.jdField_h_of_type_Float / f3 * f2 * f4 / paramInt2;
      a(this.jdField_b_of_type_Azze);
      if (!this.jdField_c_of_type_Boolean) {
        break label356;
      }
      f1 = this.jdField_b_of_type_Azze.jdField_a_of_type_Float * b() / this.jdField_h_of_type_Float / paramInt1;
      label171:
      if (!this.jdField_c_of_type_Boolean) {
        break label385;
      }
    }
    label385:
    for (float f3 = this.jdField_b_of_type_Azze.jdField_b_of_type_Float * b() / this.jdField_h_of_type_Float / paramInt2;; f3 = (this.jdField_b_of_type_Azze.jdField_b_of_type_Float * b() - paramInt2 / 2) / this.jdField_h_of_type_Float / paramInt2)
    {
      this.jdField_c_of_type_ArrayOfFloat[0] = (-f2 + f1);
      this.jdField_c_of_type_ArrayOfFloat[1] = (f4 + f3);
      this.jdField_c_of_type_ArrayOfFloat[2] = (-f2 + f1);
      this.jdField_c_of_type_ArrayOfFloat[3] = (-f4 + f3);
      this.jdField_c_of_type_ArrayOfFloat[4] = (f2 + f1);
      this.jdField_c_of_type_ArrayOfFloat[5] = (-f4 + f3);
      this.jdField_c_of_type_ArrayOfFloat[6] = (f1 + f2);
      this.jdField_c_of_type_ArrayOfFloat[7] = (f3 + f4);
      this.jdField_e_of_type_JavaNioFloatBuffer.put(this.jdField_c_of_type_ArrayOfFloat);
      this.jdField_e_of_type_JavaNioFloatBuffer.position(0);
      return;
      f3 = this.n;
      break;
      label322:
      f4 = this.o;
      break label45;
      label332:
      f1 = this.jdField_e_of_type_Float * b() * (this.jdField_h_of_type_Float * f3) / paramInt1;
      break label62;
      label356:
      f1 = (this.jdField_b_of_type_Azze.jdField_a_of_type_Float * b() - paramInt1 / 2) / this.jdField_h_of_type_Float / paramInt1;
      break label171;
    }
  }
  
  public void a(baaa parambaaa)
  {
    this.jdField_a_of_type_Baaa = parambaaa;
  }
  
  public void a(baaq parambaaq)
  {
    this.jdField_a_of_type_Baaq = parambaaq;
  }
  
  public void a(baar parambaar)
  {
    this.jdField_a_of_type_Baar = parambaar;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "playVideo with seek: " + paramString);
    }
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new VideoSprite.2(this, paramString, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  protected String b()
  {
    return baay.a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShaderVideo.glsl");
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "pause");
    }
    try
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (!this.jdField_k_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        this.jdField_k_of_type_Boolean = true;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "pause: " + QLog.getStackTraceString(localException));
    }
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_e_of_type_JavaNioFloatBuffer == null) {
      return;
    }
    a(paramInt1, paramInt2);
    GLES20.glEnableVertexAttribArray(this.jdField_j_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_j_of_type_Int, 2, 5126, false, 0, this.jdField_e_of_type_JavaNioFloatBuffer);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glUniform1i(this.jdField_g_of_type_Int, 0);
    GLES20.glEnableVertexAttribArray(this.jdField_h_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_h_of_type_Int, 4, 5126, false, 0, this.jdField_c_of_type_JavaNioFloatBuffer);
    if (this.jdField_f_of_type_Boolean)
    {
      GLES20.glUniform1i(this.l, 1);
      GLES20.glEnableVertexAttribArray(this.jdField_i_of_type_Int);
      GLES20.glVertexAttribPointer(this.jdField_i_of_type_Int, 4, 5126, false, 0, this.jdField_d_of_type_JavaNioFloatBuffer);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(this.jdField_k_of_type_Int, 1, false, this.jdField_f_of_type_ArrayOfFloat, 0);
      GLES20.glDrawElements(4, jdField_b_of_type_ArrayOfShort.length, 5123, this.jdField_b_of_type_JavaNioShortBuffer);
      GLES20.glDisableVertexAttribArray(this.jdField_j_of_type_Int);
      GLES20.glDisableVertexAttribArray(this.jdField_h_of_type_Int);
      GLES20.glDisableVertexAttribArray(this.jdField_i_of_type_Int);
      return;
      GLES20.glUniform1i(this.l, 0);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "resume");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (this.jdField_k_of_type_Boolean)) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_k_of_type_Boolean = false;
        return;
      }
      catch (Exception localException) {}
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        c(this.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
  
  /* Error */
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 297	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_h_of_type_Boolean	Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: getfield 418	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:m	I
    //   18: invokestatic 421	android/opengl/GLES20:glUseProgram	(I)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 423	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_e_of_type_Boolean	Z
    //   27: istore 9
    //   29: iload 9
    //   31: ifeq +54 -> 85
    //   34: aload_0
    //   35: getfield 215	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   38: invokevirtual 426	android/graphics/SurfaceTexture:updateTexImage	()V
    //   41: aload_0
    //   42: getfield 215	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   45: aload_0
    //   46: getfield 68	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_f_of_type_ArrayOfFloat	[F
    //   49: invokevirtual 430	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 423	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_e_of_type_Boolean	Z
    //   57: aload_0
    //   58: getfield 432	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_i_of_type_Boolean	Z
    //   61: ifeq +24 -> 85
    //   64: aload_0
    //   65: getfield 301	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_Baaq	Lbaaq;
    //   68: ifnull +17 -> 85
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 432	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_i_of_type_Boolean	Z
    //   76: aload_0
    //   77: getfield 301	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_Baaq	Lbaaq;
    //   80: invokeinterface 436 1 0
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_0
    //   88: iload_1
    //   89: iload_2
    //   90: invokevirtual 438	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:b	(II)V
    //   93: return
    //   94: astore 8
    //   96: aload_0
    //   97: monitorexit
    //   98: aload 8
    //   100: athrow
    //   101: astore 8
    //   103: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -54 -> 52
    //   109: ldc 241
    //   111: iconst_2
    //   112: aload 8
    //   114: invokestatic 245	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   117: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: goto -68 -> 52
    //   123: astore 8
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 8
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	VideoSprite
    //   0	130	1	paramInt1	int
    //   0	130	2	paramInt2	int
    //   0	130	3	paramInt3	int
    //   0	130	4	paramInt4	int
    //   0	130	5	paramInt5	int
    //   0	130	6	paramInt6	int
    //   0	130	7	paramInt7	int
    //   0	130	8	paramArrayOfFloat	float[]
    //   27	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	94	finally
    //   12	14	94	finally
    //   96	98	94	finally
    //   34	52	101	java/lang/Exception
    //   23	29	123	finally
    //   34	52	123	finally
    //   52	85	123	finally
    //   85	87	123	finally
    //   103	120	123	finally
    //   125	127	123	finally
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "playVideo: " + paramString);
    }
    if (((this.jdField_b_of_type_JavaLangString == null) || (!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (!this.jdField_g_of_type_Boolean)) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
    catch (Exception localException2)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
            this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
            this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new baas(this, null));
            this.jdField_b_of_type_JavaLangString = paramString;
            return;
            localException1 = localException1;
            if (QLog.isColorLevel())
            {
              QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(localException1));
              continue;
              localException2 = localException2;
              if (QLog.isColorLevel()) {
                QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(localException2));
              }
            }
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VideoSprite", 2, "playVideo Exception: " + QLog.getStackTraceString(localException3));
            }
            if (this.jdField_a_of_type_Baaa != null) {
              this.jdField_a_of_type_Baaa.a();
            }
          }
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_AndroidMediaMediaPlayer == null;
  }
  
  public void d()
  {
    i();
    k();
    l();
    h();
  }
  
  public void d(String paramString)
  {
    for (;;)
    {
      int i1 = GLES20.glGetError();
      if (i1 == 0) {
        break;
      }
      Log.e("SurfaceTest", paramString + ": glError " + GLUtils.getEGLErrorString(i1));
    }
  }
  
  public void e()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (this.jdField_a_of_type_AndroidViewSurface != null) {
            this.jdField_a_of_type_AndroidViewSurface.release();
          }
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("VideoSprite", 2, "onDestroy->mMediaPlayer.pause(): " + QLog.getStackTraceString(localException1));
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoSprite", 2, "onDestroy->release surface: " + QLog.getStackTraceString(localException2));
          }
        }
      }
    }
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "playVideo");
    }
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new VideoSprite.3(this));
  }
  
  protected void i()
  {
    String str1 = a();
    String str2 = b();
    try
    {
      this.m = baay.a(str1, str2);
      GLES20.glUseProgram(this.m);
      this.jdField_g_of_type_Int = GLES20.glGetUniformLocation(this.m, "texture");
      this.jdField_h_of_type_Int = GLES20.glGetAttribLocation(this.m, "vTexCoordinate");
      this.jdField_i_of_type_Int = GLES20.glGetAttribLocation(this.m, "vTexAlphaCoordinate");
      this.jdField_j_of_type_Int = GLES20.glGetAttribLocation(this.m, "vPosition");
      this.jdField_k_of_type_Int = GLES20.glGetUniformLocation(this.m, "textureTransform");
      this.l = GLES20.glGetUniformLocation(this.m, "v_isAlpha");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VideoSprite", 2, "setupGraphics: " + QLog.getStackTraceString(localException));
      }
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "stop");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean) || (this.jdField_k_of_type_Boolean))) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_g_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
      this.jdField_k_of_type_Boolean = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_e_of_type_Boolean = true;
      if (!this.jdField_h_of_type_Boolean)
      {
        this.jdField_i_of_type_Boolean = true;
        this.jdField_h_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  public void run()
  {
    int i2;
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_Baar != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 33L);
      i2 = 0;
    }
    try
    {
      i1 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      this.jdField_a_of_type_Baar.a(i1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.e("VideoSprite", 2, "run: " + QLog.getStackTraceString(localException));
          i1 = i2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
 * JD-Core Version:    0.7.0.1
 */