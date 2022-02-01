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
  private static final short[] jdField_a_of_type_ArrayOfShort = { 0, 1, 2, 0, 2, 3 };
  private long jdField_a_of_type_Long;
  private MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
  public MediaPlayer a;
  private Renderable jdField_a_of_type_ComTencentMobileqqVpngGlrendererRenderable;
  private LiveRoomGiftCallback jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback;
  private String jdField_a_of_type_JavaLangString;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer;
  private float[] jdField_a_of_type_ArrayOfFloat = { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private SurfaceTexture jdField_b_of_type_AndroidGraphicsSurfaceTexture;
  private String jdField_b_of_type_JavaLangString;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private boolean jdField_b_of_type_Boolean = false;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private FloatBuffer jdField_c_of_type_JavaNioFloatBuffer;
  private volatile boolean jdField_c_of_type_Boolean;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private float[] jdField_d_of_type_ArrayOfFloat;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private float[] jdField_e_of_type_ArrayOfFloat;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private float[] jdField_f_of_type_ArrayOfFloat;
  private int jdField_g_of_type_Int;
  private float[] jdField_g_of_type_ArrayOfFloat;
  private int jdField_h_of_type_Int;
  private float[] jdField_h_of_type_ArrayOfFloat;
  private int jdField_i_of_type_Int;
  private float[] jdField_i_of_type_ArrayOfFloat;
  private int jdField_j_of_type_Int;
  private float[] jdField_j_of_type_ArrayOfFloat = new float[16];
  private int k = 0;
  
  VPNGRenderer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    k();
  }
  
  private void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (((localObject == null) || (!((String)localObject).equals(paramString)) || (!this.jdField_c_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      int m = this.k;
      if (m == 0) {
        localObject = this.jdField_f_of_type_ArrayOfFloat;
      } else if (m == 1) {
        localObject = this.jdField_d_of_type_ArrayOfFloat;
      } else {
        localObject = this.jdField_i_of_type_ArrayOfFloat;
      }
      this.jdField_b_of_type_ArrayOfFloat = ((float[])localObject);
      m = this.k;
      if (m == 0) {
        localObject = this.jdField_g_of_type_ArrayOfFloat;
      } else if (m == 1) {
        localObject = this.jdField_e_of_type_ArrayOfFloat;
      } else {
        localObject = this.jdField_h_of_type_ArrayOfFloat;
      }
      this.jdField_c_of_type_ArrayOfFloat = ((float[])localObject);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Long = 0L;
        q();
      }
      MediaPlayer.OnCompletionListener localOnCompletionListener;
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
        this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_c_of_type_Boolean = true;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playVideo Exception: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("VPNGRenderer", 2, localStringBuilder.toString());
        localOnCompletionListener = this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
        if (localOnCompletionListener == null) {
          break label270;
        }
      }
      localOnCompletionListener.onCompletion(this.jdField_a_of_type_AndroidMediaMediaPlayer);
    }
    else if (this.jdField_c_of_type_Boolean)
    {
      j();
    }
    label270:
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    float f2 = this.jdField_i_of_type_Int;
    float f1 = this.jdField_j_of_type_Int;
    int m = this.k;
    if ((m != 1) && (m != 0)) {
      f1 /= 2.0F;
    } else {
      f2 /= 2.0F;
    }
    float f7 = paramInt1;
    float f5 = f7 / f2;
    float f3 = 1.0F;
    float f6 = paramInt2;
    float f4 = f1 * f5 / f6;
    paramInt1 = this.k;
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
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
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
    this.jdField_c_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
    this.jdField_c_of_type_JavaNioFloatBuffer.position(0);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_JavaNioFloatBuffer == null) {
      return;
    }
    b(paramInt1, paramInt2);
    GLES20.glEnableVertexAttribArray(this.jdField_f_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_f_of_type_Int, 2, 5126, false, 0, this.jdField_c_of_type_JavaNioFloatBuffer);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glUniform1i(this.jdField_c_of_type_Int, 0);
    GLES20.glEnableVertexAttribArray(this.jdField_d_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_d_of_type_Int, 2, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(this.jdField_e_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_e_of_type_Int, 2, 5126, false, 0, this.jdField_b_of_type_JavaNioFloatBuffer);
    GLES20.glUniformMatrix4fv(this.jdField_g_of_type_Int, 1, false, this.jdField_j_of_type_ArrayOfFloat, 0);
    GLES20.glDrawElements(4, jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
    GLES20.glDisableVertexAttribArray(this.jdField_f_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.jdField_d_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.jdField_e_of_type_Int);
  }
  
  private void k()
  {
    this.jdField_f_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.0F };
    this.jdField_g_of_type_ArrayOfFloat = new float[] { 0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_e_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 1.0F };
    this.jdField_d_of_type_ArrayOfFloat = new float[] { 0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
    this.jdField_b_of_type_ArrayOfFloat = this.jdField_f_of_type_ArrayOfFloat;
    this.jdField_c_of_type_ArrayOfFloat = this.jdField_g_of_type_ArrayOfFloat;
    this.jdField_h_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F, 1.0F };
    this.jdField_i_of_type_ArrayOfFloat = new float[] { 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.5F };
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new ReportMediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new VPNGRenderer.1(this));
    a(new VPNGRenderer.2(this));
  }
  
  private void l()
  {
    try
    {
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (!this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playVideo(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("): ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("VPNGRenderer", 1, localStringBuilder.toString());
    }
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 254	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_d_of_type_Boolean	Z
    //   6: ifne +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: getfield 60	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_h_of_type_Int	I
    //   18: invokestatic 257	android/opengl/GLES20:glUseProgram	(I)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 46	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_b_of_type_Boolean	Z
    //   27: ifeq +93 -> 120
    //   30: aload_0
    //   31: getfield 83	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   34: ifnull +86 -> 120
    //   37: aload_0
    //   38: getfield 259	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_b_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   41: ifnull +79 -> 120
    //   44: aload_0
    //   45: getfield 83	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   48: invokevirtual 247	android/media/MediaPlayer:isPlaying	()Z
    //   51: ifeq +69 -> 120
    //   54: aload_0
    //   55: getfield 259	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_b_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   58: invokevirtual 264	android/graphics/SurfaceTexture:updateTexImage	()V
    //   61: aload_0
    //   62: getfield 259	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_b_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   65: aload_0
    //   66: getfield 53	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_j_of_type_ArrayOfFloat	[F
    //   69: invokevirtual 268	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 46	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_b_of_type_Boolean	Z
    //   77: goto +43 -> 120
    //   80: astore_1
    //   81: goto +54 -> 135
    //   84: astore_1
    //   85: new 131	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   92: astore_2
    //   93: aload_2
    //   94: ldc_w 270
    //   97: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_2
    //   102: aload_1
    //   103: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: ldc 145
    //   112: iconst_2
    //   113: aload_2
    //   114: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 272	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_a_of_type_Int	I
    //   127: aload_0
    //   128: getfield 274	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:jdField_b_of_type_Int	I
    //   131: invokespecial 276	com/tencent/mobileqq/vpng/glrenderer/VPNGRenderer:c	(II)V
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
  
  private void n()
  {
    String str1;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      str1 = this.jdField_b_of_type_JavaLangString;
    } else {
      str1 = "attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}";
    }
    String str2;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      str2 = this.jdField_c_of_type_JavaLangString;
    } else {
      str2 = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    vec4 color = texture2D(texture, v_TexCoordinate);\n    float r = texture2D(texture, v_TexAlphaCoordinate).r;\n    float g = texture2D(texture, v_TexAlphaCoordinate).g;\n    float b = texture2D(texture, v_TexAlphaCoordinate).b;\n    float alpha = min(r, min(g, b)) * texture2D(texture, v_TexAlphaCoordinate).a;\n    gl_FragColor = color;\n    gl_FragColor.a = gl_FragColor.a * alpha;\n    gl_FragColor.r = gl_FragColor.r * alpha;\n    gl_FragColor.g = gl_FragColor.g * alpha;\n    gl_FragColor.b = gl_FragColor.b * alpha;\n}";
    }
    this.jdField_h_of_type_Int = GLUtil.a(str1, str2);
    GLES20.glUseProgram(this.jdField_h_of_type_Int);
    this.jdField_c_of_type_Int = GLES20.glGetUniformLocation(this.jdField_h_of_type_Int, "texture");
    this.jdField_d_of_type_Int = GLES20.glGetAttribLocation(this.jdField_h_of_type_Int, "vTexCoordinate");
    this.jdField_e_of_type_Int = GLES20.glGetAttribLocation(this.jdField_h_of_type_Int, "vTexAlphaCoordinate");
    this.jdField_f_of_type_Int = GLES20.glGetAttribLocation(this.jdField_h_of_type_Int, "vPosition");
    this.jdField_g_of_type_Int = GLES20.glGetUniformLocation(this.jdField_h_of_type_Int, "textureTransform");
  }
  
  private void o()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfShort.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
    this.jdField_a_of_type_JavaNioShortBuffer.put(jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_c_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_c_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_c_of_type_JavaNioFloatBuffer.position(0);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return;
    }
    q();
    GLES20.glActiveTexture(33984);
    GLES20.glGenTextures(1, this.jdField_a_of_type_ArrayOfInt, 0);
    GLES20.glBindTexture(36197, this.jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_b_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_b_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    Surface localSurface = new Surface(this.jdField_b_of_type_AndroidGraphicsSurfaceTexture);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(localSurface);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupTexture(");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("): ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("VPNGRenderer", 1, localStringBuilder.toString());
    }
    localSurface.release();
  }
  
  private void q()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.jdField_b_of_type_ArrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.jdField_c_of_type_ArrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_b_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_b_of_type_JavaNioFloatBuffer.put(this.jdField_c_of_type_ArrayOfFloat);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
  
  void a(Renderable paramRenderable)
  {
    this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererRenderable = paramRenderable;
  }
  
  public void a(String paramString, int paramInt, LiveRoomGiftCallback paramLiveRoomGiftCallback)
  {
    this.k = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback = paramLiveRoomGiftCallback;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    b();
    Object localObject = this.jdField_b_of_type_AndroidGraphicsSurfaceTexture;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).release();
      this.jdField_b_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    localObject = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if (localObject != null)
    {
      try
      {
        ((MediaPlayer)localObject).stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(null);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("release: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("VPNGRenderer", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_d_of_type_Boolean = false;
      LiveRoomGiftCallback localLiveRoomGiftCallback = this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback;
      if (localLiveRoomGiftCallback != null) {
        localLiveRoomGiftCallback.onCall(6, "");
      }
    }
    super.c();
  }
  
  public void d()
  {
    n();
    o();
    p();
    l();
    this.jdField_a_of_type_ComTencentMobileqqVpngGlrendererRenderable.onDrawBegin();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null) {
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 0.0F);
    } else {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    }
    GLES20.glClear(16640);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(1, 771);
    m();
    GLES20.glFinish();
  }
  
  public void f() {}
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
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
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void i()
  {
    this.jdField_a_of_type_Boolean = true;
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
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
      LiveRoomGiftCallback localLiveRoomGiftCallback = this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback;
      if (localLiveRoomGiftCallback != null) {
        localLiveRoomGiftCallback.onCall(3, "");
      }
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean)
    {
      MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
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
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback != null) {
          this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback.onCall(4, "");
        }
      }
      else if (this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback != null)
      {
        this.jdField_a_of_type_CooperationLiveroomLiveRoomGiftCallback.onCall(5, "");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer
 * JD-Core Version:    0.7.0.1
 */