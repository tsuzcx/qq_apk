package com.tencent.mobileqq.surfaceviewaction.gl;

import ahxm;
import ahxo;
import ahxp;
import ahxq;
import ahxs;
import ahxt;
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
import com.tencent.mobileqq.surfaceviewaction.util.GLUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class VideoSprite
  extends Sprite
  implements SurfaceTexture.OnFrameAvailableListener, GLTextureView.OnSurfaceChangedListener, SpriteGLView.IVideoTimeGetter, Runnable
{
  public static final short[] b;
  public int a;
  protected SurfaceTexture a;
  public MediaPlayer a;
  public Handler a;
  protected Surface a;
  public FrameSprite.OnFrameEndListener a;
  protected VideoSprite.OnOnPlayedListener a;
  protected VideoSprite.OnProgressChangedListener a;
  public boolean a;
  public int[] a;
  public SpriteGLView b;
  public String b;
  public ShortBuffer b;
  public int c;
  public FloatBuffer c;
  public boolean c;
  protected float[] c;
  public int d;
  public FloatBuffer d;
  public boolean d;
  protected float[] d;
  public int e;
  public FloatBuffer e;
  protected boolean e;
  protected float[] e;
  public int f;
  public boolean f;
  public float[] f;
  protected float g;
  public int g;
  public boolean g;
  public int h;
  protected boolean h;
  public int i;
  protected boolean i;
  public int j;
  public boolean j;
  protected boolean k;
  
  static
  {
    jdField_b_of_type_ArrayOfShort = new short[] { 0, 1, 2, 0, 2, 3 };
  }
  
  public VideoSprite(SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    this.jdField_c_of_type_ArrayOfFloat = new float[] { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
    this.jdField_g_of_type_Float = 0.5F;
    this.jdField_a_of_type_ArrayOfInt = new int[1];
    this.jdField_f_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (float f1 = 0.5F;; f1 = 1.0F)
    {
      this.jdField_g_of_type_Float = f1;
      this.jdField_d_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, this.jdField_g_of_type_Float, 0.0F, 0.0F, 1.0F, this.jdField_g_of_type_Float, 1.0F, 0.0F, 1.0F };
      this.jdField_e_of_type_ArrayOfFloat = new float[] { this.jdField_g_of_type_Float, 1.0F, 0.0F, 1.0F, this.jdField_g_of_type_Float, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new ahxm(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new ahxo(this));
      paramSpriteGLView.a(this);
      paramSpriteGLView.b(new ahxp(this));
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
      c("Texture generate");
      GLES20.glBindTexture(36197, this.jdField_a_of_type_ArrayOfInt[0]);
      c("Texture bind");
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
        int m = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        return m;
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
    return GLUtil.a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "VertexShaderVideo.glsl");
  }
  
  public void a()
  {
    i();
    k();
    l();
    h();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    float f4;
    label35:
    float f1;
    label52:
    float f2;
    if (this.jdField_a_of_type_Float != 0.0F)
    {
      f3 = this.jdField_a_of_type_Float / this.jdField_g_of_type_Float;
      if (this.jdField_b_of_type_Float == 0.0F) {
        break label298;
      }
      f4 = this.jdField_b_of_type_Float;
      if (!this.jdField_a_of_type_Boolean) {
        break label308;
      }
      f1 = this.jdField_e_of_type_Float * a();
      f2 = f1;
      if (this.jdField_d_of_type_Boolean)
      {
        f2 = f1;
        if (this.jdField_a_of_type_Boolean)
        {
          f2 = f1;
          if (paramInt1 / f3 < paramInt2 / f4) {
            f2 = f1 * (paramInt2 * f3 / (paramInt1 * f4));
          }
        }
      }
      f4 = paramInt1 / this.jdField_g_of_type_Float / f3 * f2 * f4 / paramInt2;
      if (!this.jdField_c_of_type_Boolean) {
        break label332;
      }
      f1 = this.jdField_c_of_type_Float * a() / this.jdField_g_of_type_Float / paramInt1;
      label150:
      if (!this.jdField_c_of_type_Boolean) {
        break label358;
      }
    }
    label298:
    label308:
    label332:
    label358:
    for (float f3 = this.jdField_d_of_type_Float * a() / this.jdField_g_of_type_Float / paramInt2;; f3 = (this.jdField_d_of_type_Float * a() - paramInt2 / 2) / this.jdField_g_of_type_Float / paramInt2)
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
      f3 = this.jdField_i_of_type_Int;
      break;
      f4 = this.jdField_j_of_type_Int;
      break label35;
      f1 = this.jdField_e_of_type_Float * a() * (this.jdField_g_of_type_Float * f3) / paramInt1;
      break label52;
      f1 = (this.jdField_c_of_type_Float * a() - paramInt1 / 2) / this.jdField_g_of_type_Float / paramInt1;
      break label150;
    }
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = paramOnFrameEndListener;
  }
  
  public void a(VideoSprite.OnOnPlayedListener paramOnOnPlayedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener = paramOnOnPlayedListener;
  }
  
  public void a(VideoSprite.OnProgressChangedListener paramOnProgressChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnProgressChangedListener = paramOnProgressChangedListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "playVideo with seek: " + paramString);
    }
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new ahxq(this, paramString, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidMediaMediaPlayer == null;
  }
  
  public String b()
  {
    return GLUtil.a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), "troop" + File.separator + "shaders" + File.separator + "FragmentShaderVideo.glsl");
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(null);
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
            this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
            this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener = null;
            this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new ahxt(this));
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
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_e_of_type_JavaNioFloatBuffer == null) {
      return;
    }
    a(paramInt1, paramInt2);
    GLES20.glEnableVertexAttribArray(this.jdField_e_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_e_of_type_Int, 2, 5126, false, 0, this.jdField_e_of_type_JavaNioFloatBuffer);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glUniform1i(this.jdField_a_of_type_Int, 0);
    GLES20.glEnableVertexAttribArray(this.jdField_c_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_c_of_type_Int, 4, 5126, false, 0, this.jdField_c_of_type_JavaNioFloatBuffer);
    if (this.jdField_f_of_type_Boolean)
    {
      GLES20.glUniform1i(this.jdField_g_of_type_Int, 1);
      GLES20.glEnableVertexAttribArray(this.jdField_d_of_type_Int);
      GLES20.glVertexAttribPointer(this.jdField_d_of_type_Int, 4, 5126, false, 0, this.jdField_d_of_type_JavaNioFloatBuffer);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(this.jdField_f_of_type_Int, 1, false, this.jdField_f_of_type_ArrayOfFloat, 0);
      GLES20.glDrawElements(4, jdField_b_of_type_ArrayOfShort.length, 5123, this.jdField_b_of_type_JavaNioShortBuffer);
      GLES20.glDisableVertexAttribArray(this.jdField_e_of_type_Int);
      GLES20.glDisableVertexAttribArray(this.jdField_c_of_type_Int);
      GLES20.glDisableVertexAttribArray(this.jdField_d_of_type_Int);
      return;
      GLES20.glUniform1i(this.jdField_g_of_type_Int, 0);
    }
  }
  
  public void b(String paramString)
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
            this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
            this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
            this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
            this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
            this.jdField_g_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 33L);
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
            if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener.a();
            }
          }
        }
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    try
    {
      if (this.jdField_a_of_type_AndroidViewSurface != null) {
        this.jdField_a_of_type_AndroidViewSurface.release();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, "onDestroy->release surface: " + QLog.getStackTraceString(localException));
        }
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
    //   3: getfield 331	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_h_of_type_Boolean	Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: getfield 423	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_h_of_type_Int	I
    //   18: invokestatic 426	android/opengl/GLES20:glUseProgram	(I)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 428	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_e_of_type_Boolean	Z
    //   27: istore 9
    //   29: iload 9
    //   31: ifeq +54 -> 85
    //   34: aload_0
    //   35: getfield 202	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   38: invokevirtual 431	android/graphics/SurfaceTexture:updateTexImage	()V
    //   41: aload_0
    //   42: getfield 202	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   45: aload_0
    //   46: getfield 63	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_f_of_type_ArrayOfFloat	[F
    //   49: invokevirtual 435	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 428	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_e_of_type_Boolean	Z
    //   57: aload_0
    //   58: getfield 437	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_i_of_type_Boolean	Z
    //   61: ifeq +24 -> 85
    //   64: aload_0
    //   65: getfield 307	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener	Lcom/tencent/mobileqq/surfaceviewaction/gl/VideoSprite$OnOnPlayedListener;
    //   68: ifnull +17 -> 85
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 437	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_i_of_type_Boolean	Z
    //   76: aload_0
    //   77: getfield 307	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener	Lcom/tencent/mobileqq/surfaceviewaction/gl/VideoSprite$OnOnPlayedListener;
    //   80: invokeinterface 440 1 0
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_0
    //   88: iload_1
    //   89: iload_2
    //   90: invokevirtual 442	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:b	(II)V
    //   93: return
    //   94: astore 8
    //   96: aload_0
    //   97: monitorexit
    //   98: aload 8
    //   100: athrow
    //   101: astore 8
    //   103: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq -54 -> 52
    //   109: ldc 228
    //   111: iconst_2
    //   112: aload 8
    //   114: invokestatic 232	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   117: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    for (;;)
    {
      int m = GLES20.glGetError();
      if (m == 0) {
        break;
      }
      Log.e("SurfaceTest", paramString + ": glError " + GLUtils.getEGLErrorString(m));
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "pause");
    }
    try
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (!this.k) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        this.k = true;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoSprite", 2, "pause: " + QLog.getStackTraceString(localException));
    }
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "resume");
    }
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (this.k)) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.k = false;
        return;
      }
      catch (Exception localException) {}
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        b(this.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "playVideo");
    }
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new ahxs(this));
  }
  
  public void i()
  {
    String str1 = a();
    String str2 = b();
    try
    {
      this.jdField_h_of_type_Int = GLUtil.a(str1, str2);
      GLES20.glUseProgram(this.jdField_h_of_type_Int);
      this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(this.jdField_h_of_type_Int, "texture");
      this.jdField_c_of_type_Int = GLES20.glGetAttribLocation(this.jdField_h_of_type_Int, "vTexCoordinate");
      this.jdField_d_of_type_Int = GLES20.glGetAttribLocation(this.jdField_h_of_type_Int, "vTexAlphaCoordinate");
      this.jdField_e_of_type_Int = GLES20.glGetAttribLocation(this.jdField_h_of_type_Int, "vPosition");
      this.jdField_f_of_type_Int = GLES20.glGetUniformLocation(this.jdField_h_of_type_Int, "textureTransform");
      this.jdField_g_of_type_Int = GLES20.glGetUniformLocation(this.jdField_h_of_type_Int, "v_isAlpha");
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
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_Boolean) || (this.k))) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_g_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
      this.k = false;
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
    int n;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 33L);
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnProgressChangedListener != null) {
        n = 0;
      }
    }
    try
    {
      m = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnProgressChangedListener.a(m);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int m = n;
        if (QLog.isColorLevel())
        {
          QLog.e("VideoSprite", 2, "run: " + QLog.getStackTraceString(localException));
          m = n;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
 * JD-Core Version:    0.7.0.1
 */