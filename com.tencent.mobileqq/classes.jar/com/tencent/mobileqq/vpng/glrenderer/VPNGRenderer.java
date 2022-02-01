package com.tencent.mobileqq.vpng.glrenderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.surfaceviewaction.util.GLUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class VPNGRenderer
  extends GLRenderer
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final short[] m = { 0, 1, 2, 0, 2, 3 };
  private ShortBuffer A;
  private float[] B = new float[16];
  private SurfaceTexture C;
  private MediaPlayer.OnCompletionListener D;
  private String E;
  private int F;
  private int G;
  private volatile boolean H;
  private boolean I;
  private boolean J;
  private long K;
  private Renderable L;
  private boolean M;
  private int N = 0;
  private LiveRoomGiftCallback O;
  private boolean P;
  private String Q;
  private String R;
  public MediaPlayer e;
  private boolean f = false;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private float[] l = { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  private FloatBuffer n;
  private FloatBuffer o;
  private float[] p;
  private float[] q;
  private float[] r;
  private float[] s;
  private float[] t;
  private float[] u;
  private float[] v;
  private float[] w;
  private int[] x = new int[1];
  private int y;
  private FloatBuffer z;
  
  VPNGRenderer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    l();
  }
  
  private void a(String paramString)
  {
    Object localObject = this.E;
    if (((localObject == null) || (!((String)localObject).equals(paramString)) || (!this.H) || (this.P)) && (this.e != null))
    {
      int i1 = this.N;
      if (i1 == 0) {
        localObject = this.t;
      } else if (i1 == 1) {
        localObject = this.r;
      } else {
        localObject = this.w;
      }
      this.p = ((float[])localObject);
      i1 = this.N;
      if (i1 == 0) {
        localObject = this.u;
      } else if (i1 == 1) {
        localObject = this.s;
      } else {
        localObject = this.v;
      }
      this.q = ((float[])localObject);
      this.e.reset();
      if (this.P)
      {
        this.P = false;
        this.K = 0L;
        r();
      }
      MediaPlayer.OnCompletionListener localOnCompletionListener;
      try
      {
        this.e.setDataSource(paramString);
        this.e.prepare();
        this.F = this.e.getVideoWidth();
        this.G = this.e.getVideoHeight();
        this.e.start();
        this.H = true;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playVideo Exception: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("VPNGRenderer", 2, localStringBuilder.toString());
        localOnCompletionListener = this.D;
        if (localOnCompletionListener == null) {
          break label270;
        }
      }
      localOnCompletionListener.onCompletion(this.e);
    }
    else if (this.H)
    {
      j();
    }
    label270:
    this.E = paramString;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    float f2 = this.F;
    float f1 = this.G;
    int i1 = this.N;
    if ((i1 != 1) && (i1 != 0)) {
      f1 /= 2.0F;
    } else {
      f2 /= 2.0F;
    }
    float f7 = paramInt1;
    float f5 = f7 / f2;
    float f3 = 1.0F;
    float f6 = paramInt2;
    float f4 = f1 * f5 / f6;
    paramInt1 = this.N;
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      f3 = f5;
      if (f2 * f6 >= f1 * f7) {
        f3 = f6 / f1;
      }
      f2 = f2 * f3 / f7;
      f4 = f1 * f3 / f6;
      f3 = f2;
    }
    float[] arrayOfFloat = this.l;
    f1 = -f3;
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = f4;
    arrayOfFloat[2] = f1;
    f1 = -f4;
    arrayOfFloat[3] = f1;
    arrayOfFloat[4] = f3;
    arrayOfFloat[5] = f1;
    arrayOfFloat[6] = f3;
    arrayOfFloat[7] = f4;
    this.z.put(arrayOfFloat);
    this.z.position(0);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.z == null) {
      return;
    }
    b(paramInt1, paramInt2);
    GLES20.glEnableVertexAttribArray(this.j);
    GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 0, this.z);
    GLES20.glBindTexture(3553, this.x[0]);
    GLES20.glUniform1i(this.g, 0);
    GLES20.glEnableVertexAttribArray(this.h);
    GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 0, this.n);
    GLES20.glEnableVertexAttribArray(this.i);
    GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 0, this.o);
    GLES20.glUniformMatrix4fv(this.k, 1, false, this.B, 0);
    GLES20.glDrawElements(4, m.length, 5123, this.A);
    GLES20.glDisableVertexAttribArray(this.j);
    GLES20.glDisableVertexAttribArray(this.h);
    GLES20.glDisableVertexAttribArray(this.i);
  }
  
  private void l()
  {
    this.t = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.0F };
    this.u = new float[] { 0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.s = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.0F };
    this.r = new float[] { 0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.p = this.t;
    this.q = this.u;
    this.v = new float[] { 0.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F, 1.0F };
    this.w = new float[] { 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.5F };
    this.e = new ReportMediaPlayer();
    this.e.setOnCompletionListener(new VPNGRenderer.1(this));
    this.e.setOnErrorListener(new VPNGRenderer.2(this));
    a(new VPNGRenderer.3(this));
  }
  
  private void m()
  {
    try
    {
      if ((this.H) && (this.e != null) && (!this.e.isPlaying()))
      {
        this.e.start();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playVideo(");
      localStringBuilder.append(this.E);
      localStringBuilder.append("): ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("VPNGRenderer", 1, localStringBuilder.toString());
    }
  }
  
  /* Error */
  private void n()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 291	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:I	Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: getfield 255	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:y	I
    //   18: invokestatic 294	android/opengl/GLES20:glUseProgram	(I)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 73	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:f	Z
    //   27: ifeq +93 -> 120
    //   30: aload_0
    //   31: getfield 102	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:e	Landroid/media/MediaPlayer;
    //   34: ifnull +86 -> 120
    //   37: aload_0
    //   38: getfield 296	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:C	Landroid/graphics/SurfaceTexture;
    //   41: ifnull +79 -> 120
    //   44: aload_0
    //   45: getfield 102	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:e	Landroid/media/MediaPlayer;
    //   48: invokevirtual 285	android/media/MediaPlayer:isPlaying	()Z
    //   51: ifeq +69 -> 120
    //   54: aload_0
    //   55: getfield 296	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:C	Landroid/graphics/SurfaceTexture;
    //   58: invokevirtual 301	android/graphics/SurfaceTexture:updateTexImage	()V
    //   61: aload_0
    //   62: getfield 296	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:C	Landroid/graphics/SurfaceTexture;
    //   65: aload_0
    //   66: getfield 80	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:B	[F
    //   69: invokevirtual 305	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 73	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:f	Z
    //   77: goto +43 -> 120
    //   80: astore_1
    //   81: goto +54 -> 135
    //   84: astore_1
    //   85: new 149	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   92: astore_2
    //   93: aload_2
    //   94: ldc_w 307
    //   97: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_2
    //   102: aload_1
    //   103: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: ldc 163
    //   112: iconst_2
    //   113: aload_2
    //   114: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 309	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:c	I
    //   127: aload_0
    //   128: getfield 311	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:d	I
    //   131: invokespecial 313	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:c	(II)V
    //   134: return
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	VPNGRenderer
    //   80	1	1	localObject1	Object
    //   84	54	1	localException	Exception
    //   139	4	1	localObject2	Object
    //   92	22	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   23	77	80	finally
    //   85	120	80	finally
    //   120	122	80	finally
    //   135	137	80	finally
    //   23	77	84	java/lang/Exception
    //   2	11	139	finally
    //   12	14	139	finally
    //   140	142	139	finally
  }
  
  private void o()
  {
    String str1;
    if (!TextUtils.isEmpty(this.Q)) {
      str1 = this.Q;
    } else {
      str1 = "attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}";
    }
    String str2;
    if (!TextUtils.isEmpty(this.R)) {
      str2 = this.R;
    } else {
      str2 = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    vec4 color = texture2D(texture, v_TexCoordinate);\n    float r = texture2D(texture, v_TexAlphaCoordinate).r;\n    float g = texture2D(texture, v_TexAlphaCoordinate).g;\n    float b = texture2D(texture, v_TexAlphaCoordinate).b;\n    float alpha = min(r, min(g, b)) * texture2D(texture, v_TexAlphaCoordinate).a;\n    gl_FragColor = color;\n    gl_FragColor.a = gl_FragColor.a * alpha;\n    gl_FragColor.r = gl_FragColor.r * alpha;\n    gl_FragColor.g = gl_FragColor.g * alpha;\n    gl_FragColor.b = gl_FragColor.b * alpha;\n}";
    }
    this.y = GLUtil.a(str1, str2);
    GLES20.glUseProgram(this.y);
    this.g = GLES20.glGetUniformLocation(this.y, "texture");
    this.h = GLES20.glGetAttribLocation(this.y, "vTexCoordinate");
    this.i = GLES20.glGetAttribLocation(this.y, "vTexAlphaCoordinate");
    this.j = GLES20.glGetAttribLocation(this.y, "vPosition");
    this.k = GLES20.glGetUniformLocation(this.y, "textureTransform");
  }
  
  private void p()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(m.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.A = localByteBuffer.asShortBuffer();
    this.A.put(m);
    this.A.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.l.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.z = localByteBuffer.asFloatBuffer();
    this.z.put(this.l);
    this.z.position(0);
  }
  
  private void q()
  {
    if (this.e == null) {
      return;
    }
    r();
    GLES20.glActiveTexture(33984);
    GLES20.glGenTextures(1, this.x, 0);
    GLES20.glBindTexture(36197, this.x[0]);
    this.C = new SurfaceTexture(this.x[0]);
    this.C.setOnFrameAvailableListener(this);
    Surface localSurface = new Surface(this.C);
    try
    {
      this.e.setSurface(localSurface);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupTexture(");
      localStringBuilder.append(this.E);
      localStringBuilder.append("): ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("VPNGRenderer", 1, localStringBuilder.toString());
    }
    localSurface.release();
  }
  
  private void r()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.p.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.n = localByteBuffer.asFloatBuffer();
    this.n.put(this.p);
    this.n.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.q.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.o = localByteBuffer.asFloatBuffer();
    this.o.put(this.q);
    this.o.position(0);
  }
  
  void a(Renderable paramRenderable)
  {
    this.L = paramRenderable;
  }
  
  public void a(String paramString, int paramInt, LiveRoomGiftCallback paramLiveRoomGiftCallback)
  {
    this.N = paramInt;
    this.E = paramString;
    this.O = paramLiveRoomGiftCallback;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.Q = paramString1;
    this.R = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.P = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }
  
  public void c()
  {
    b();
    Object localObject = this.C;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).release();
      this.C = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      try
      {
        ((MediaPlayer)localObject).stop();
        this.e.release();
        this.e.setOnCompletionListener(null);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("release: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("VPNGRenderer", 2, localStringBuilder.toString());
      }
      this.e = null;
      this.I = false;
      LiveRoomGiftCallback localLiveRoomGiftCallback = this.O;
      if (localLiveRoomGiftCallback != null) {
        localLiveRoomGiftCallback.onCall(6, "");
      }
    }
    super.c();
  }
  
  public void d()
  {
    o();
    p();
    q();
    m();
    this.L.onDrawBegin();
  }
  
  public void e()
  {
    if (this.b == null) {
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 0.0F);
    } else {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    }
    GLES20.glClear(16640);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(1, 771);
    n();
    GLES20.glFinish();
  }
  
  public void f() {}
  
  public void g()
  {
    try
    {
      if (this.e != null)
      {
        this.e.pause();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("VPNGRenderer", 2, localStringBuilder.toString());
    }
  }
  
  public void h()
  {
    a(this.E);
  }
  
  public void i()
  {
    this.a = true;
    MediaPlayer localMediaPlayer = this.e;
    if (localMediaPlayer != null)
    {
      try
      {
        localMediaPlayer.pause();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pauseVideo: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("VPNGRenderer", 2, localStringBuilder.toString());
      }
      LiveRoomGiftCallback localLiveRoomGiftCallback = this.O;
      if (localLiveRoomGiftCallback != null) {
        localLiveRoomGiftCallback.onCall(3, "");
      }
    }
  }
  
  public void j()
  {
    this.a = false;
    if (this.H)
    {
      MediaPlayer localMediaPlayer = this.e;
      if (localMediaPlayer != null) {
        try
        {
          localMediaPlayer.start();
          return;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("resumeVideo: ");
          localStringBuilder.append(localException.getMessage());
          QLog.e("VPNGRenderer", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void k()
  {
    this.M = true;
    MediaPlayer localMediaPlayer = this.e;
    if (localMediaPlayer != null) {
      localMediaPlayer.setVolume(0.0F, 0.0F);
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.f = true;
      this.I = true;
      if (this.K == 0L)
      {
        this.K = System.currentTimeMillis();
        if (this.O != null) {
          this.O.onCall(4, "");
        }
      }
      else if (this.O != null)
      {
        this.O.onCall(5, "");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer
 * JD-Core Version:    0.7.0.1
 */