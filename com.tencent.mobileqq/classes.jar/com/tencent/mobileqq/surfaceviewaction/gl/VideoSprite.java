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
import com.tencent.mobileqq.surfaceviewaction.Point;
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
  protected static final short[] b;
  protected SurfaceTexture a;
  protected MediaPlayer a;
  protected Handler a;
  protected Surface a;
  protected FrameSprite.OnFrameEndListener a;
  protected VideoSprite.OnOnPlayedListener a;
  protected VideoSprite.OnProgressChangedListener a;
  protected int[] a;
  protected Point b;
  protected SpriteGLView b;
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
  protected boolean g;
  protected float h;
  protected int h;
  protected boolean h;
  protected int i;
  protected boolean i;
  protected int j;
  protected boolean j;
  protected int k;
  protected boolean k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  
  static
  {
    jdField_b_of_type_ArrayOfShort = new short[] { 0, 1, 2, 0, 2, 3 };
  }
  
  public VideoSprite(SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_ArrayOfFloat = new float[] { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
    float f1 = 0.5F;
    this.jdField_h_of_type_Float = 0.5F;
    this.jdField_a_of_type_ArrayOfInt = new int[1];
    this.jdField_f_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint = new Point(0.0F, 0.0F);
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      f1 = 1.0F;
    }
    this.jdField_h_of_type_Float = f1;
    f1 = this.jdField_h_of_type_Float;
    this.jdField_d_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, f1, 0.0F, 0.0F, 1.0F, f1, 1.0F, 0.0F, 1.0F };
    this.jdField_e_of_type_ArrayOfFloat = new float[] { f1, 1.0F, 0.0F, 1.0F, f1, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new VideoSprite.CompletionListener(this, null));
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new VideoSprite.ErrorListener(this, null));
    paramSpriteGLView.a(this);
    paramSpriteGLView.b(new VideoSprite.1(this));
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
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return;
    }
    Object localObject = ByteBuffer.allocateDirect(this.jdField_d_of_type_ArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.jdField_c_of_type_JavaNioFloatBuffer = ((ByteBuffer)localObject).asFloatBuffer();
    this.jdField_c_of_type_JavaNioFloatBuffer.put(this.jdField_d_of_type_ArrayOfFloat);
    this.jdField_c_of_type_JavaNioFloatBuffer.position(0);
    localObject = ByteBuffer.allocateDirect(this.jdField_e_of_type_ArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.jdField_d_of_type_JavaNioFloatBuffer = ((ByteBuffer)localObject).asFloatBuffer();
    this.jdField_d_of_type_JavaNioFloatBuffer.put(this.jdField_e_of_type_ArrayOfFloat);
    this.jdField_d_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glGenTextures(1, this.jdField_a_of_type_ArrayOfInt, 0);
    d("Texture generate");
    GLES20.glBindTexture(36197, this.jdField_a_of_type_ArrayOfInt[0]);
    d("Texture bind");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    localObject = this.jdField_a_of_type_AndroidViewSurface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSprite", 2, QLog.getStackTraceString(localException));
      }
    }
  }
  
  public int a()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null) {
      try
      {
        int i1 = localMediaPlayer.getCurrentPosition();
        return i1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCurrentTime: ");
          localStringBuilder.append(QLog.getStackTraceString(localException));
          QLog.e("VideoSprite", 2, localStringBuilder.toString());
        }
      }
    }
    return 0;
  }
  
  protected String a()
  {
    Context localContext = this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("shaders");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("VertexShaderVideo.glsl");
    return GLUtil.a(localContext, localStringBuilder.toString());
  }
  
  public void a()
  {
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localMediaPlayer != null)
    {
      try
      {
        localMediaPlayer.setOnCompletionListener(null);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(null);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(null);
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException1));
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException2));
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException3)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException3));
        }
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener = null;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener = null;
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new VideoSprite.4(this));
      this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(this);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Float != 0.0F) {
      f3 = this.jdField_a_of_type_Float / this.jdField_h_of_type_Float;
    } else {
      f3 = this.n;
    }
    if (this.jdField_b_of_type_Float != 0.0F) {
      f4 = this.jdField_b_of_type_Float;
    } else {
      f4 = this.o;
    }
    if (this.jdField_b_of_type_Boolean) {
      f1 = this.jdField_e_of_type_Float * b();
    } else {
      f1 = this.jdField_e_of_type_Float * b() * (this.jdField_h_of_type_Float * f3) / paramInt1;
    }
    float f2 = f1;
    if (this.jdField_d_of_type_Boolean)
    {
      f2 = f1;
      if (this.jdField_b_of_type_Boolean)
      {
        f5 = paramInt1;
        f6 = f5 / f3;
        float f7 = paramInt2;
        f2 = f1;
        if (f6 < f7 / f4) {
          f2 = f1 * (f7 * f3 / (f5 * f4));
        }
      }
    }
    float f1 = paramInt1;
    float f5 = f1 / this.jdField_h_of_type_Float / f3;
    float f3 = paramInt2;
    float f4 = f4 * (f5 * f2) / f3;
    a(this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint);
    if (this.jdField_c_of_type_Boolean) {
      f1 = this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.jdField_a_of_type_Float * b() / this.jdField_h_of_type_Float / f1;
    } else {
      f1 = (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.jdField_a_of_type_Float * b() - paramInt1 / 2) / this.jdField_h_of_type_Float / f1;
    }
    if (this.jdField_c_of_type_Boolean) {
      f3 = this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.jdField_b_of_type_Float * b() / this.jdField_h_of_type_Float / f3;
    } else {
      f3 = (this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionPoint.jdField_b_of_type_Float * b() - paramInt2 / 2) / this.jdField_h_of_type_Float / f3;
    }
    float[] arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
    float f6 = -f2 + f1;
    arrayOfFloat[0] = f6;
    f5 = f4 + f3;
    arrayOfFloat[1] = f5;
    arrayOfFloat[2] = f6;
    f3 = -f4 + f3;
    arrayOfFloat[3] = f3;
    f1 = f2 + f1;
    arrayOfFloat[4] = f1;
    arrayOfFloat[5] = f3;
    arrayOfFloat[6] = f1;
    arrayOfFloat[7] = f5;
    this.jdField_e_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
    this.jdField_e_of_type_JavaNioFloatBuffer.position(0);
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
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playVideo with seek: ");
      localStringBuilder.append(paramString);
      QLog.d("VideoSprite", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new VideoSprite.2(this, paramString, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  protected String b()
  {
    Context localContext = this.jdField_b_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("shaders");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("FragmentShaderVideo.glsl");
    return GLUtil.a(localContext, localStringBuilder.toString());
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
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pause: ");
        localStringBuilder.append(QLog.getStackTraceString(localException));
        QLog.e("VideoSprite", 2, localStringBuilder.toString());
      }
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
    else
    {
      GLES20.glUniform1i(this.l, 0);
    }
    GLES20.glUniformMatrix4fv(this.jdField_k_of_type_Int, 1, false, this.jdField_f_of_type_ArrayOfFloat, 0);
    GLES20.glDrawElements(4, jdField_b_of_type_ArrayOfShort.length, 5123, this.jdField_b_of_type_JavaNioShortBuffer);
    GLES20.glDisableVertexAttribArray(this.jdField_j_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.jdField_h_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.jdField_i_of_type_Int);
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
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((localObject == null) || (this.jdField_k_of_type_Boolean)) {}
    try
    {
      ((MediaPlayer)localObject).start();
      this.jdField_k_of_type_Boolean = false;
      return;
    }
    catch (Exception localException) {}
    localObject = this.jdField_b_of_type_JavaLangString;
    if (localObject != null) {
      c((String)localObject);
    }
    return;
  }
  
  /* Error */
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 305	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_h_of_type_Boolean	Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: getfield 420	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:m	I
    //   18: invokestatic 423	android/opengl/GLES20:glUseProgram	(I)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 66	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_e_of_type_Boolean	Z
    //   27: istore 9
    //   29: iload 9
    //   31: ifeq +76 -> 107
    //   34: aload_0
    //   35: getfield 223	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   38: invokevirtual 426	android/graphics/SurfaceTexture:updateTexImage	()V
    //   41: aload_0
    //   42: getfield 223	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   45: aload_0
    //   46: getfield 76	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_f_of_type_ArrayOfFloat	[F
    //   49: invokevirtual 430	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   52: goto +22 -> 74
    //   55: astore 8
    //   57: invokestatic 247	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +14 -> 74
    //   63: ldc 249
    //   65: iconst_2
    //   66: aload 8
    //   68: invokestatic 253	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   71: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 66	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_e_of_type_Boolean	Z
    //   79: aload_0
    //   80: getfield 432	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_i_of_type_Boolean	Z
    //   83: ifeq +24 -> 107
    //   86: aload_0
    //   87: getfield 309	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener	Lcom/tencent/mobileqq/surfaceviewaction/gl/VideoSprite$OnOnPlayedListener;
    //   90: ifnull +17 -> 107
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 432	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_i_of_type_Boolean	Z
    //   98: aload_0
    //   99: getfield 309	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener	Lcom/tencent/mobileqq/surfaceviewaction/gl/VideoSprite$OnOnPlayedListener;
    //   102: invokeinterface 436 1 0
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_0
    //   110: iload_1
    //   111: iload_2
    //   112: invokevirtual 438	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:b	(II)V
    //   115: return
    //   116: astore 8
    //   118: aload_0
    //   119: monitorexit
    //   120: aload 8
    //   122: athrow
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
    //   34	52	55	java/lang/Exception
    //   23	29	116	finally
    //   34	52	116	finally
    //   57	74	116	finally
    //   74	107	116	finally
    //   107	109	116	finally
    //   118	120	116	finally
    //   2	11	123	finally
    //   12	14	123	finally
    //   125	127	123	finally
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playVideo: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VideoSprite", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_b_of_type_JavaLangString;
    if ((localObject == null) || (!((String)localObject).equals(paramString)) || (!this.jdField_g_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if (localObject != null)
      {
        StringBuilder localStringBuilder;
        try
        {
          ((MediaPlayer)localObject).stop();
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("playVideo Exception: ");
            localStringBuilder.append(QLog.getStackTraceString(localException1));
            QLog.e("VideoSprite", 2, localStringBuilder.toString());
          }
        }
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("playVideo Exception: ");
            localStringBuilder.append(QLog.getStackTraceString(localException2));
            QLog.e("VideoSprite", 2, localStringBuilder.toString());
          }
        }
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new VideoSprite.PreparedListener(this, null));
        }
        catch (Exception localException3)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("playVideo Exception: ");
            localStringBuilder.append(QLog.getStackTraceString(localException3));
            QLog.e("VideoSprite", 2, localStringBuilder.toString());
          }
          FrameSprite.OnFrameEndListener localOnFrameEndListener = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlFrameSprite$OnFrameEndListener;
          if (localOnFrameEndListener != null) {
            localOnFrameEndListener.a();
          }
        }
      }
    }
    this.jdField_b_of_type_JavaLangString = paramString;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(GLUtils.getEGLErrorString(i1));
      Log.e("SurfaceTest", localStringBuilder.toString());
    }
  }
  
  public void e()
  {
    StringBuilder localStringBuilder;
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      }
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy->mMediaPlayer.pause(): ");
        localStringBuilder.append(QLog.getStackTraceString(localException1));
        QLog.e("VideoSprite", 2, localStringBuilder.toString());
      }
    }
    try
    {
      if (this.jdField_a_of_type_AndroidViewSurface != null) {
        this.jdField_a_of_type_AndroidViewSurface.release();
      }
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy->release surface: ");
        localStringBuilder.append(QLog.getStackTraceString(localException2));
        QLog.e("VideoSprite", 2, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
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
    String str = a();
    Object localObject = b();
    try
    {
      this.m = GLUtil.a(str, (String)localObject);
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setupGraphics: ");
      ((StringBuilder)localObject).append(QLog.getStackTraceString(localException));
      QLog.e("VideoSprite", 2, ((StringBuilder)localObject).toString());
    }
    GLES20.glUseProgram(this.m);
    this.jdField_g_of_type_Int = GLES20.glGetUniformLocation(this.m, "texture");
    this.jdField_h_of_type_Int = GLES20.glGetAttribLocation(this.m, "vTexCoordinate");
    this.jdField_i_of_type_Int = GLES20.glGetAttribLocation(this.m, "vTexAlphaCoordinate");
    this.jdField_j_of_type_Int = GLES20.glGetAttribLocation(this.m, "vPosition");
    this.jdField_k_of_type_Int = GLES20.glGetUniformLocation(this.m, "textureTransform");
    this.l = GLES20.glGetUniformLocation(this.m, "v_isAlpha");
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
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnProgressChangedListener != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 33L);
      int i2 = 0;
      int i1;
      try
      {
        i1 = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      }
      catch (Exception localException)
      {
        i1 = i2;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run: ");
          localStringBuilder.append(QLog.getStackTraceString(localException));
          QLog.e("VideoSprite", 2, localStringBuilder.toString());
          i1 = i2;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnProgressChangedListener.a(i1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
 * JD-Core Version:    0.7.0.1
 */