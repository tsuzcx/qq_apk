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
  protected static final short[] O = { 0, 1, 2, 0, 2, 3 };
  protected boolean E = false;
  protected int F;
  protected int G;
  protected int H;
  protected int I;
  protected int J;
  protected int K;
  protected VideoSprite.OnProgressChangedListener L;
  protected VideoSprite.OnOnPlayedListener M;
  protected float[] N = { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  protected SpriteGLView P;
  protected FloatBuffer Q;
  protected FloatBuffer R;
  protected float S;
  protected boolean T;
  protected float[] U;
  protected float[] V;
  protected int[] W;
  protected int X;
  protected FloatBuffer Y;
  protected ShortBuffer Z;
  protected float[] aa;
  protected SurfaceTexture ab;
  protected MediaPlayer ac;
  protected FrameSprite.OnFrameEndListener ad;
  protected String ae;
  protected int af;
  protected int ag;
  protected boolean ah;
  protected boolean ai;
  protected boolean aj;
  protected Handler ak;
  protected boolean al;
  protected boolean am;
  protected Surface an;
  protected Point ao;
  public boolean s = false;
  public boolean t = false;
  public boolean u = false;
  
  public VideoSprite(SpriteGLView paramSpriteGLView, Context paramContext, boolean paramBoolean)
  {
    float f = 0.5F;
    this.S = 0.5F;
    this.W = new int[1];
    this.aa = new float[16];
    this.ak = new Handler(Looper.getMainLooper());
    this.ao = new Point(0.0F, 0.0F);
    this.P = paramSpriteGLView;
    this.l = true;
    this.T = paramBoolean;
    if (!paramBoolean) {
      f = 1.0F;
    }
    this.S = f;
    f = this.S;
    this.U = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, f, 0.0F, 0.0F, 1.0F, f, 1.0F, 0.0F, 1.0F };
    this.V = new float[] { f, 1.0F, 0.0F, 1.0F, f, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
    this.ac = new MediaPlayer();
    this.ac.setOnCompletionListener(new VideoSprite.CompletionListener(this, null));
    this.ac.setOnErrorListener(new VideoSprite.ErrorListener(this, null));
    paramSpriteGLView.a(this);
    paramSpriteGLView.b(new VideoSprite.1(this));
  }
  
  private void x()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(O.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.Z = localByteBuffer.asShortBuffer();
    this.Z.put(O);
    this.Z.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.N.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.Y = localByteBuffer.asFloatBuffer();
    this.Y.put(this.N);
    this.Y.position(0);
  }
  
  private void y()
  {
    if (this.ac == null) {
      return;
    }
    Object localObject = ByteBuffer.allocateDirect(this.U.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.Q = ((ByteBuffer)localObject).asFloatBuffer();
    this.Q.put(this.U);
    this.Q.position(0);
    localObject = ByteBuffer.allocateDirect(this.V.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.R = ((ByteBuffer)localObject).asFloatBuffer();
    this.R.put(this.V);
    this.R.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glGenTextures(1, this.W, 0);
    d("Texture generate");
    GLES20.glBindTexture(36197, this.W[0]);
    d("Texture bind");
    this.ab = new SurfaceTexture(this.W[0]);
    this.ab.setOnFrameAvailableListener(this);
    localObject = this.an;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    this.an = new Surface(this.ab);
    try
    {
      this.ac.setSurface(this.an);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSprite", 2, QLog.getStackTraceString(localException));
      }
    }
  }
  
  public void a()
  {
    v();
    x();
    y();
    r();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    this.q = paramInt1;
    this.r = paramInt2;
    if (this.b != 0.0F) {
      f3 = this.b / this.S;
    } else {
      f3 = this.af;
    }
    if (this.c != 0.0F) {
      f4 = this.c;
    } else {
      f4 = this.ag;
    }
    if (this.s) {
      f1 = this.f * d();
    } else {
      f1 = this.f * d() * (this.S * f3) / paramInt1;
    }
    float f2 = f1;
    if (this.u)
    {
      f2 = f1;
      if (this.s)
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
    float f5 = f1 / this.S / f3;
    float f3 = paramInt2;
    float f4 = f4 * (f5 * f2) / f3;
    a(this.ao);
    if (this.t) {
      f1 = this.ao.a * d() / this.S / f1;
    } else {
      f1 = (this.ao.a * d() - paramInt1 / 2) / this.S / f1;
    }
    if (this.t) {
      f3 = this.ao.b * d() / this.S / f3;
    } else {
      f3 = (this.ao.b * d() - paramInt2 / 2) / this.S / f3;
    }
    float[] arrayOfFloat = this.N;
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
    this.Y.put(arrayOfFloat);
    this.Y.position(0);
  }
  
  public void a(FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    this.ad = paramOnFrameEndListener;
  }
  
  public void a(VideoSprite.OnOnPlayedListener paramOnOnPlayedListener)
  {
    this.M = paramOnOnPlayedListener;
  }
  
  public void a(VideoSprite.OnProgressChangedListener paramOnProgressChangedListener)
  {
    this.L = paramOnProgressChangedListener;
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
    this.P.b(new VideoSprite.2(this, paramString, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.al = paramBoolean;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if (this.Y == null) {
      return;
    }
    a(paramInt1, paramInt2);
    GLES20.glEnableVertexAttribArray(this.I);
    GLES20.glVertexAttribPointer(this.I, 2, 5126, false, 0, this.Y);
    GLES20.glBindTexture(3553, this.W[0]);
    GLES20.glUniform1i(this.F, 0);
    GLES20.glEnableVertexAttribArray(this.G);
    GLES20.glVertexAttribPointer(this.G, 4, 5126, false, 0, this.Q);
    if (this.T)
    {
      GLES20.glUniform1i(this.K, 1);
      GLES20.glEnableVertexAttribArray(this.H);
      GLES20.glVertexAttribPointer(this.H, 4, 5126, false, 0, this.R);
    }
    else
    {
      GLES20.glUniform1i(this.K, 0);
    }
    GLES20.glUniformMatrix4fv(this.J, 1, false, this.aa, 0);
    GLES20.glDrawElements(4, O.length, 5123, this.Z);
    GLES20.glDisableVertexAttribArray(this.I);
    GLES20.glDisableVertexAttribArray(this.G);
    GLES20.glDisableVertexAttribArray(this.H);
  }
  
  public void b(String paramString)
  {
    this.ae = paramString;
  }
  
  public int c()
  {
    MediaPlayer localMediaPlayer = this.ac;
    if (localMediaPlayer != null) {
      try
      {
        int i = localMediaPlayer.getCurrentPosition();
        return i;
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
  
  /* Error */
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 396	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:ai	Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: getfield 398	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:X	I
    //   18: invokestatic 401	android/opengl/GLES20:glUseProgram	(I)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 88	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:E	Z
    //   27: istore 9
    //   29: iload 9
    //   31: ifeq +77 -> 108
    //   34: aload_0
    //   35: getfield 251	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:ab	Landroid/graphics/SurfaceTexture;
    //   38: invokevirtual 404	android/graphics/SurfaceTexture:updateTexImage	()V
    //   41: aload_0
    //   42: getfield 251	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:ab	Landroid/graphics/SurfaceTexture;
    //   45: aload_0
    //   46: getfield 98	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:aa	[F
    //   49: invokevirtual 408	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   52: goto +23 -> 75
    //   55: astore 8
    //   57: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +15 -> 75
    //   63: ldc_w 277
    //   66: iconst_2
    //   67: aload 8
    //   69: invokestatic 281	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   72: invokestatic 393	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 88	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:E	Z
    //   80: aload_0
    //   81: getfield 410	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:aj	Z
    //   84: ifeq +24 -> 108
    //   87: aload_0
    //   88: getfield 322	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:M	Lcom/tencent/mobileqq/surfaceviewaction/gl/VideoSprite$OnOnPlayedListener;
    //   91: ifnull +17 -> 108
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 410	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:aj	Z
    //   99: aload_0
    //   100: getfield 322	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:M	Lcom/tencent/mobileqq/surfaceviewaction/gl/VideoSprite$OnOnPlayedListener;
    //   103: invokeinterface 414 1 0
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_0
    //   111: iload_1
    //   112: iload_2
    //   113: invokevirtual 416	com/tencent/mobileqq/surfaceviewaction/gl/VideoSprite:b	(II)V
    //   116: return
    //   117: astore 8
    //   119: aload_0
    //   120: monitorexit
    //   121: aload 8
    //   123: athrow
    //   124: astore 8
    //   126: aload_0
    //   127: monitorexit
    //   128: aload 8
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	VideoSprite
    //   0	131	1	paramInt1	int
    //   0	131	2	paramInt2	int
    //   0	131	3	paramInt3	int
    //   0	131	4	paramInt4	int
    //   0	131	5	paramInt5	int
    //   0	131	6	paramInt6	int
    //   0	131	7	paramInt7	int
    //   0	131	8	paramArrayOfFloat	float[]
    //   27	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   34	52	55	java/lang/Exception
    //   23	29	117	finally
    //   34	52	117	finally
    //   57	75	117	finally
    //   75	108	117	finally
    //   108	110	117	finally
    //   119	121	117	finally
    //   2	11	124	finally
    //   12	14	124	finally
    //   126	128	124	finally
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
    Object localObject = this.ae;
    if ((localObject == null) || (!((String)localObject).equals(paramString)) || (!this.ah))
    {
      localObject = this.ac;
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
          this.ac.reset();
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
          this.ac.setDataSource(paramString);
          this.ac.prepareAsync();
          this.ac.setOnPreparedListener(new VideoSprite.PreparedListener(this, null));
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
          FrameSprite.OnFrameEndListener localOnFrameEndListener = this.ad;
          if (localOnFrameEndListener != null) {
            localOnFrameEndListener.a();
          }
        }
      }
    }
    this.ae = paramString;
  }
  
  public void d(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(GLUtils.getEGLErrorString(i));
      Log.e("SurfaceTest", localStringBuilder.toString());
    }
  }
  
  public void dr_()
  {
    StringBuilder localStringBuilder;
    try
    {
      if (this.ac != null) {
        this.ac.pause();
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
      if (this.an != null) {
        this.an.release();
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
    this.ak.removeCallbacksAndMessages(null);
  }
  
  public void f()
  {
    MediaPlayer localMediaPlayer = this.ac;
    if (localMediaPlayer != null)
    {
      try
      {
        localMediaPlayer.setOnCompletionListener(null);
        this.ac.setOnErrorListener(null);
        this.ac.setOnPreparedListener(null);
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException1));
        }
      }
      try
      {
        this.ac.stop();
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException2));
        }
      }
      try
      {
        this.ac.release();
      }
      catch (Exception localException3)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoSprite", 2, QLog.getStackTraceString(localException3));
        }
      }
      this.ac = null;
      this.ai = false;
      this.ad = null;
      this.M = null;
      this.P.b(new VideoSprite.4(this));
      this.P.b(this);
      this.ak.removeCallbacksAndMessages(null);
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "pause");
    }
    try
    {
      if ((this.ac != null) && (!this.am) && (this.ac.isPlaying()))
      {
        this.ac.pause();
        this.am = true;
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
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "resume");
    }
    Object localObject = this.ac;
    if ((localObject == null) || (this.am)) {}
    try
    {
      ((MediaPlayer)localObject).start();
      this.am = false;
      return;
    }
    catch (Exception localException) {}
    localObject = this.ae;
    if (localObject != null) {
      c((String)localObject);
    }
    return;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.E = true;
      if (!this.ai)
      {
        this.aj = true;
        this.ai = true;
      }
      return;
    }
    finally {}
  }
  
  protected void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "playVideo");
    }
    this.P.b(new VideoSprite.3(this));
  }
  
  public void run()
  {
    if ((this.ac != null) && (this.L != null))
    {
      this.ak.postDelayed(this, 33L);
      int j = 0;
      int i;
      try
      {
        i = this.ac.getCurrentPosition();
      }
      catch (Exception localException)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run: ");
          localStringBuilder.append(QLog.getStackTraceString(localException));
          QLog.e("VideoSprite", 2, localStringBuilder.toString());
          i = j;
        }
      }
      this.L.a(i);
    }
  }
  
  public boolean s()
  {
    return this.ac == null;
  }
  
  protected String t()
  {
    Context localContext = this.P.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("shaders");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("VertexShaderVideo.glsl");
    return GLUtil.a(localContext, localStringBuilder.toString());
  }
  
  protected String u()
  {
    Context localContext = this.P.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("shaders");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("FragmentShaderVideo.glsl");
    return GLUtil.a(localContext, localStringBuilder.toString());
  }
  
  protected void v()
  {
    String str = t();
    Object localObject = u();
    try
    {
      this.X = GLUtil.a(str, (String)localObject);
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setupGraphics: ");
      ((StringBuilder)localObject).append(QLog.getStackTraceString(localException));
      QLog.e("VideoSprite", 2, ((StringBuilder)localObject).toString());
    }
    GLES20.glUseProgram(this.X);
    this.F = GLES20.glGetUniformLocation(this.X, "texture");
    this.G = GLES20.glGetAttribLocation(this.X, "vTexCoordinate");
    this.H = GLES20.glGetAttribLocation(this.X, "vTexAlphaCoordinate");
    this.I = GLES20.glGetAttribLocation(this.X, "vPosition");
    this.J = GLES20.glGetUniformLocation(this.X, "textureTransform");
    this.K = GLES20.glGetUniformLocation(this.X, "v_isAlpha");
  }
  
  public void w()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSprite", 2, "stop");
    }
    if ((this.ac != null) && ((this.ah) || (this.ai) || (this.am))) {}
    try
    {
      this.ac.stop();
      this.ah = false;
      this.ai = false;
      this.am = false;
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite
 * JD-Core Version:    0.7.0.1
 */