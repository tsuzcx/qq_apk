package com.tencent.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Map;

public class RendererUtils
{
  private static final float DEGREE_TO_RADIAN = 0.01745329F;
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D tex_sampler;\nuniform float alpha;\nuniform vec4 bkg;\nvarying vec2 v_texcoord;\nvoid main() {\nvec4 color = texture2D(tex_sampler, v_texcoord);\ngl_FragColor = vec4(color.r*alpha + bkg.r*(1.0-alpha), color.g*alpha + bkg.g*(1.0-alpha), color.b*alpha + bkg.b*(1.0-alpha), 1.0);\n}\n";
  private static final String FRAGMENT_SHADER_ALPHA = "precision mediump float;\nuniform sampler2D tex_sampler;\nuniform float alpha;\nuniform vec4 bkg;\nvarying vec2 v_texcoord;\nvoid main() {\nvec4 color = texture2D(tex_sampler, v_texcoord);\ngl_FragColor = vec4(color.r*alpha + bkg.r*(1.0-alpha), color.g*alpha + bkg.g*(1.0-alpha), color.b*alpha + bkg.b*(1.0-alpha), color.a);\n}\n";
  private static final float[] POS_VERTICES = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] TEX_VERTICES = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private static final String VERTEX_SHADER = "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n";
  
  public static void checkGlError(String paramString)
  {
    if (!AEOpenRenderConfig.isEnableLog()) {}
    for (;;)
    {
      return;
      int i = GLES20.glGetError();
      if (i != 0)
      {
        LogUtils.e("RendererUtils", paramString + ": glError " + i);
        paramString = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
        int j = paramString.length;
        i = 0;
        while (i < j)
        {
          LogUtils.e("SS     ", paramString[i].toString());
          i += 1;
        }
      }
    }
  }
  
  public static void clearTexture(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = paramInt;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    checkGlError("glDeleteTextures");
  }
  
  public static RendererUtils.FilterContext createFilterProgram(String paramString1, String paramString2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n";
    }
    int i = loadShader(35633, str);
    if (i == 0) {}
    int j;
    do
    {
      return null;
      j = loadShader(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      checkGlError("glAttachShader");
      GLES20.glAttachShader(k, j);
      checkGlError("glAttachShader");
      GLES20.glLinkProgram(k);
      GLES20.glDeleteShader(i);
      GLES20.glDeleteShader(j);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(k, 35714, paramString1, 0);
      if (paramString1[0] != 1)
      {
        paramString1 = GLES20.glGetProgramInfoLog(k);
        GLES20.glDeleteProgram(k);
        throw new RuntimeException("Could not link program: " + paramString1);
      }
    }
    paramString2 = new RendererUtils.FilterContext();
    paramString2.texSamplerHandle = GLES20.glGetUniformLocation(k, "tex_sampler");
    paramString2.texCoordHandle = GLES20.glGetAttribLocation(k, "a_texcoord");
    paramString2.posCoordHandle = GLES20.glGetAttribLocation(k, "a_position");
    paramString1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null) {
      paramString1 = TEX_VERTICES;
    }
    paramString2.texVertices = createVerticesBuffer(paramString1);
    paramString1 = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null) {
      paramString1 = POS_VERTICES;
    }
    paramString2.posVertices = createVerticesBuffer(paramString1);
    paramString2.shaderProgram = k;
    return paramString2;
  }
  
  public static RendererUtils.RenderContext createProgram()
  {
    return createProgram(POS_VERTICES, TEX_VERTICES, false);
  }
  
  private static RendererUtils.RenderContext createProgram(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean)
  {
    int i = loadShader(35633, "attribute vec4 a_position;\nattribute vec2 a_texcoord;\nvarying vec2 v_texcoord;\nvoid main() {\n  gl_Position = a_position;\n  v_texcoord = a_texcoord;\n}\n");
    if (i == 0) {}
    int j;
    do
    {
      return null;
      j = loadShader(35632, "precision mediump float;\nuniform sampler2D tex_sampler;\nuniform float alpha;\nuniform vec4 bkg;\nvarying vec2 v_texcoord;\nvoid main() {\nvec4 color = texture2D(tex_sampler, v_texcoord);\ngl_FragColor = vec4(color.r*alpha + bkg.r*(1.0-alpha), color.g*alpha + bkg.g*(1.0-alpha), color.b*alpha + bkg.b*(1.0-alpha), color.a);\n}\n");
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      checkGlError("glAttachShader");
      GLES20.glAttachShader(k, j);
      checkGlError("glAttachShader");
      GLES20.glLinkProgram(k);
      GLES20.glDeleteShader(i);
      GLES20.glDeleteShader(j);
      localObject = new int[1];
      GLES20.glGetProgramiv(k, 35714, (int[])localObject, 0);
      if (localObject[0] != 1)
      {
        paramArrayOfFloat1 = GLES20.glGetProgramInfoLog(k);
        GLES20.glDeleteProgram(k);
        throw new RuntimeException("Could not link program: " + paramArrayOfFloat1);
      }
    }
    Object localObject = new RendererUtils.RenderContext();
    RendererUtils.RenderContext.access$702((RendererUtils.RenderContext)localObject, GLES20.glGetUniformLocation(k, "tex_sampler"));
    RendererUtils.RenderContext.access$802((RendererUtils.RenderContext)localObject, GLES20.glGetUniformLocation(k, "alpha"));
    RendererUtils.RenderContext.access$902((RendererUtils.RenderContext)localObject, GLES20.glGetUniformLocation(k, "bkg"));
    RendererUtils.RenderContext.access$402((RendererUtils.RenderContext)localObject, GLES20.glGetAttribLocation(k, "a_texcoord"));
    RendererUtils.RenderContext.access$602((RendererUtils.RenderContext)localObject, GLES20.glGetAttribLocation(k, "a_position"));
    RendererUtils.RenderContext.access$502((RendererUtils.RenderContext)localObject, createVerticesBuffer(paramArrayOfFloat2));
    RendererUtils.RenderContext.access$002((RendererUtils.RenderContext)localObject, createVerticesBuffer(paramArrayOfFloat1));
    RendererUtils.RenderContext.access$302((RendererUtils.RenderContext)localObject, k);
    RendererUtils.RenderContext.access$202((RendererUtils.RenderContext)localObject, paramBoolean);
    return localObject;
  }
  
  public static RendererUtils.RenderContext createProgramWithBlend()
  {
    return createProgram(POS_VERTICES, TEX_VERTICES, true);
  }
  
  public static int createTexture()
  {
    int[] arrayOfInt = new int[1];
    GlUtil.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    checkGlError("glGenTextures");
    return arrayOfInt[0];
  }
  
  public static int createTexture(Bitmap paramBitmap)
  {
    int i = createTexture();
    GLES20.glBindTexture(3553, i);
    try
    {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      GLES20.glTexParameteri(3553, 10240, 9729);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      checkGlError("texImage2D");
      return i;
    }
    catch (IllegalArgumentException paramBitmap)
    {
      for (;;)
      {
        paramBitmap.printStackTrace();
      }
    }
  }
  
  private static FloatBuffer createVerticesBuffer(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 8) {
      throw new RuntimeException("Number of vertices should be four.");
    }
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat).position(0);
    return localFloatBuffer;
  }
  
  public static void deleteProgram(int paramInt)
  {
    GLES20.glDeleteProgram(paramInt);
  }
  
  private static float[] getFitVertices(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = paramInt1 / paramInt2;
    f = paramInt3 / paramInt4 / f;
    float[] arrayOfFloat = new float[8];
    System.arraycopy(POS_VERTICES, 0, arrayOfFloat, 0, arrayOfFloat.length);
    if (f > 1.0F)
    {
      arrayOfFloat[0] /= f;
      arrayOfFloat[2] /= f;
      arrayOfFloat[4] /= f;
      arrayOfFloat[6] /= f;
      return arrayOfFloat;
    }
    arrayOfFloat[1] *= f;
    arrayOfFloat[3] *= f;
    arrayOfFloat[5] *= f;
    arrayOfFloat[7] = (f * arrayOfFloat[7]);
    return arrayOfFloat;
  }
  
  private static int loadShader(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    if (i != 0)
    {
      GLES20.glShaderSource(i, paramString);
      GLES20.glCompileShader(i);
      paramString = new int[1];
      GLES20.glGetShaderiv(i, 35713, paramString, 0);
      if (paramString[0] == 0)
      {
        paramString = GLES20.glGetShaderInfoLog(i);
        GLES20.glDeleteShader(i);
        throw new RuntimeException("Could not compile shader " + paramInt + ":" + paramString);
      }
    }
    return i;
  }
  
  public static void renderBackground()
  {
    GLES20.glClearColor(0.2226563F, 0.2226563F, 0.2226563F, 1.0F);
    GLES20.glClear(16384);
  }
  
  public static void renderBackground(int paramInt)
  {
    if (paramInt != -1) {
      GLES20.glClearColor(Color.red(paramInt) / 255.0F, Color.green(paramInt) / 255.0F, Color.blue(paramInt) / 255.0F, Color.alpha(paramInt) / 255.0F);
    }
    for (;;)
    {
      GLES20.glClear(16384);
      return;
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
  }
  
  public static void renderTexture(RendererUtils.RenderContext paramRenderContext, int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glUseProgram(RendererUtils.RenderContext.access$300(paramRenderContext));
    if (GLES20.glGetError() != 0)
    {
      createProgram();
      checkGlError("createProgram");
    }
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    checkGlError("glViewport");
    if (RendererUtils.RenderContext.access$200(paramRenderContext))
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
    for (;;)
    {
      GLES20.glVertexAttribPointer(RendererUtils.RenderContext.access$400(paramRenderContext), 2, 5126, false, 0, RendererUtils.RenderContext.access$500(paramRenderContext));
      GLES20.glEnableVertexAttribArray(RendererUtils.RenderContext.access$400(paramRenderContext));
      GLES20.glVertexAttribPointer(RendererUtils.RenderContext.access$600(paramRenderContext), 2, 5126, false, 0, RendererUtils.RenderContext.access$000(paramRenderContext));
      GLES20.glEnableVertexAttribArray(RendererUtils.RenderContext.access$600(paramRenderContext));
      checkGlError("vertex attribute setup");
      GLES20.glActiveTexture(33984);
      checkGlError("glActiveTexture");
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glTexParameteri(3553, 10240, 9729);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      checkGlError("glBindTexture");
      GLES20.glUniform1i(RendererUtils.RenderContext.access$700(paramRenderContext), 0);
      GLES20.glUniform1f(RendererUtils.RenderContext.access$800(paramRenderContext), RendererUtils.RenderContext.access$100(paramRenderContext));
      GLES20.glUniform4f(RendererUtils.RenderContext.access$900(paramRenderContext), 0.203125F, 0.203125F, 0.2148438F, 1.0F);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glFinish();
      return;
      GLES20.glDisable(3042);
    }
  }
  
  public static void renderTexture(RendererUtils.RenderContext paramRenderContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RendererUtils.RenderContext.access$202(paramRenderContext, paramBoolean);
    renderTexture(paramRenderContext, paramInt1, paramInt2, paramInt3);
  }
  
  public static void renderTexture2FBO(RendererUtils.FilterContext paramFilterContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glActiveTexture(33984);
    checkGlError("glActiveTexture");
    GLES20.glBindTexture(3553, paramInt2);
    checkGlError("glBindTexture");
    GLES20.glTexImage2D(3553, 0, 6408, paramInt3, paramInt4, 0, 6408, 5121, null);
    checkGlError("glTexImage2D");
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt2, 0);
    checkGlError("glFramebufferTexture2D");
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    checkGlError("glViewport");
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glUseProgram(paramFilterContext.shaderProgram);
    if (GLES20.glGetError() != 0) {
      checkGlError("createProgram");
    }
    GLES20.glVertexAttribPointer(paramFilterContext.texCoordHandle, 2, 5126, false, 0, paramFilterContext.texVertices);
    GLES20.glEnableVertexAttribArray(paramFilterContext.texCoordHandle);
    GLES20.glVertexAttribPointer(paramFilterContext.posCoordHandle, 2, 5126, false, 0, paramFilterContext.posVertices);
    GLES20.glEnableVertexAttribArray(paramFilterContext.posCoordHandle);
    checkGlError("vertex attribute setup");
    GLES20.glUniform1i(paramFilterContext.texSamplerHandle, 0);
    checkGlError("glUniform1i");
    GLES20.glActiveTexture(33984);
    checkGlError("glActiveTexture");
    GLES20.glBindTexture(3553, paramInt1);
    checkGlError("glBindTexture");
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glFinish();
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    checkGlError("glBindFramebuffer");
    deleteProgram(paramFilterContext.shaderProgram);
  }
  
  public static Bitmap saveTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    saveTextureToBitmap(paramInt1, paramInt2, paramInt3, localBitmap);
    return localBitmap;
  }
  
  public static Bitmap saveTexture(Frame paramFrame)
  {
    Object localObject;
    if (paramFrame == null) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = Bitmap.createBitmap(paramFrame.width, paramFrame.height, Bitmap.Config.ARGB_8888);
      localObject = localBitmap;
    } while (localBitmap == null);
    saveTextureToBitmap(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, localBitmap);
    return localBitmap;
  }
  
  public static QImage saveTexture2QImage(int paramInt1, int paramInt2, int paramInt3)
  {
    return saveTexture2QImageWithShare(paramInt1, paramInt2, paramInt3, BitmapUtils.currentShareIndex);
  }
  
  public static QImage saveTexture2QImageWithShare(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 < 0)
    {
      if (DeviceAttrs.getInstance().gpuWorkaroundForTU880)
      {
        GLES20.glActiveTexture(33984);
        checkGlError("glActiveTexture");
        GLES20.glBindTexture(3553, paramInt1);
        checkGlError("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
        checkGlError("glTexImage2D");
      }
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
      checkGlError("glBindFramebuffer");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      checkGlError("glFramebufferTexture2D");
      checkGlError("glReadPixels");
      QImage localQImage = GLSLRender.nativeCopyTexture(paramInt2, paramInt3);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
      checkGlError("glBindFramebuffer");
      return localQImage;
    }
    return GLSLRender.nativeCopyTextureWithShare(paramInt2, paramInt3, paramInt1, paramInt4);
  }
  
  public static Bitmap saveTextureTo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    GLES20.glReadPixels(paramInt4, paramInt5, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    checkGlError("glReadPixels");
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    return localBitmap;
  }
  
  public static void saveTextureToBitmap(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    saveTextureToBitmapWithShare(paramInt1, paramInt2, paramInt3, paramBitmap, BitmapUtils.currentShareIndex);
  }
  
  public static void saveTextureToBitmapWithShare(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, int paramInt4)
  {
    if (paramInt4 < 0)
    {
      if (DeviceAttrs.getInstance().gpuWorkaroundForTU880)
      {
        GLES20.glActiveTexture(33984);
        checkGlError("glActiveTexture");
        GLES20.glBindTexture(3553, paramInt1);
        checkGlError("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
        checkGlError("glTexImage2D");
      }
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
      checkGlError("glBindFramebuffer");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      checkGlError("glFramebufferTexture2D");
      checkGlError("glReadPixels");
      GLSLRender.nativeCopyPixelToBitmap(paramBitmap);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
      checkGlError("glBindFramebuffer");
      return;
    }
    GLSLRender.nativeCopyPixelToBitmapWithShare(paramBitmap, paramInt1, paramInt4);
  }
  
  public static ByteBuffer saveTextureToByteBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    checkGlError("glBindFramebuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    checkGlError("glFramebufferTexture2D");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    GLES20.glReadPixels(paramInt4, paramInt5, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    checkGlError("glReadPixels");
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    return localByteBuffer;
  }
  
  public static void saveTextureToRgbBuffer(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if (BitmapUtils.currentShareIndex < 0)
    {
      GLES20.glBindFramebuffer(36160, paramInt4);
      checkGlError("glBindFramebuffer");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      checkGlError("glFramebufferTexture2D");
      GLSLRender.nativeToRGBData(paramArrayOfByte, paramInt2, paramInt3);
      GLES20.glBindFramebuffer(36160, 0);
      checkGlError("glBindFramebuffer");
      return;
    }
    GLSLRender.nativePushDataFromTexture(paramArrayOfByte, paramInt2, paramInt3, BitmapUtils.currentShareIndex);
  }
  
  public static void saveTextureToRgbBufferByShare(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    GLSLRender.nativeCopyTexturToDataWithShare(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setRenderToAlpha(RendererUtils.RenderContext paramRenderContext, int paramInt)
  {
    RendererUtils.RenderContext.access$102(paramRenderContext, paramInt / 255.0F);
  }
  
  public static void setRenderToFit(RendererUtils.RenderContext paramRenderContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RendererUtils.RenderContext.access$002(paramRenderContext, createVerticesBuffer(getFitVertices(paramInt1, paramInt2, paramInt3, paramInt4)));
  }
  
  public static void setRenderToFlip(RendererUtils.RenderContext paramRenderContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat1 = getFitVertices(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = (int)paramFloat1 / 180;
    if (paramInt1 % 2 != 0)
    {
      arrayOfFloat1[0] = (-arrayOfFloat1[0]);
      arrayOfFloat1[4] = arrayOfFloat1[0];
      arrayOfFloat1[2] = (-arrayOfFloat1[2]);
      arrayOfFloat1[6] = arrayOfFloat1[2];
    }
    paramInt2 = (int)paramFloat2 / 180;
    if (paramInt2 % 2 != 0)
    {
      arrayOfFloat1[1] = (-arrayOfFloat1[1]);
      arrayOfFloat1[3] = arrayOfFloat1[1];
      arrayOfFloat1[5] = (-arrayOfFloat1[5]);
      arrayOfFloat1[7] = arrayOfFloat1[5];
    }
    float[] arrayOfFloat2 = new float[8];
    System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, arrayOfFloat2.length);
    float f1;
    if (paramFloat1 % 180.0F != 0.0F)
    {
      f1 = (paramFloat1 - paramInt1 * 180) * 0.01745329F;
      paramFloat1 = (float)Math.cos(f1);
      f1 = (float)Math.sin(f1);
      float f2 = 5.0F / (arrayOfFloat1[0] * f1 + 5.0F);
      arrayOfFloat2[0] = (arrayOfFloat1[0] * paramFloat1 * f2);
      arrayOfFloat1[1] *= f2;
      arrayOfFloat2[4] = arrayOfFloat2[0];
      arrayOfFloat2[5] = (f2 * arrayOfFloat1[5]);
      f1 = 5.0F / (f1 * arrayOfFloat1[2] + 5.0F);
      arrayOfFloat2[2] = (paramFloat1 * arrayOfFloat1[2] * f1);
      arrayOfFloat1[3] *= f1;
      arrayOfFloat2[6] = arrayOfFloat2[2];
      arrayOfFloat2[7] = (f1 * arrayOfFloat1[7]);
    }
    if (paramFloat2 % 180.0F != 0.0F)
    {
      paramFloat2 = (paramFloat2 - paramInt2 * 180) * 0.01745329F;
      paramFloat1 = (float)Math.cos(paramFloat2);
      paramFloat2 = (float)Math.sin(paramFloat2);
      f1 = 5.0F / (arrayOfFloat1[1] * paramFloat2 + 5.0F);
      arrayOfFloat1[0] *= f1;
      arrayOfFloat2[1] = (arrayOfFloat1[1] * paramFloat1 * f1);
      arrayOfFloat2[2] = (f1 * arrayOfFloat1[2]);
      arrayOfFloat2[3] = arrayOfFloat2[1];
      paramFloat2 = 5.0F / (paramFloat2 * arrayOfFloat1[5] + 5.0F);
      arrayOfFloat1[4] *= paramFloat2;
      arrayOfFloat2[5] = (paramFloat1 * arrayOfFloat1[5] * paramFloat2);
      arrayOfFloat1[6] *= paramFloat2;
      arrayOfFloat2[7] = arrayOfFloat2[5];
    }
    RendererUtils.RenderContext.access$002(paramRenderContext, createVerticesBuffer(arrayOfFloat2));
  }
  
  public static void setRenderToRotate(RendererUtils.RenderContext paramRenderContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    paramFloat = -paramFloat * 0.01745329F;
    float f2 = (float)Math.cos(paramFloat);
    float f3 = (float)Math.sin(paramFloat);
    paramFloat = paramInt1 * f2;
    float f1 = paramInt1 * f3;
    f2 *= paramInt2;
    f3 *= paramInt2;
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (-paramFloat + f3);
    arrayOfFloat[1] = (-f1 - f2);
    arrayOfFloat[2] = (f3 + paramFloat);
    arrayOfFloat[3] = (f1 - f2);
    arrayOfFloat[4] = (-arrayOfFloat[2]);
    arrayOfFloat[5] = (-arrayOfFloat[3]);
    arrayOfFloat[6] = (-arrayOfFloat[0]);
    arrayOfFloat[7] = (-arrayOfFloat[1]);
    paramFloat = Math.max(Math.abs(arrayOfFloat[0]), Math.abs(arrayOfFloat[2]));
    f1 = Math.max(Math.abs(arrayOfFloat[1]), Math.abs(arrayOfFloat[3]));
    paramFloat = Math.min(paramInt3 / paramFloat, paramInt4 / f1);
    paramInt1 = 0;
    while (paramInt1 < 8)
    {
      arrayOfFloat[paramInt1] *= paramFloat / paramInt3;
      paramInt2 = paramInt1 + 1;
      arrayOfFloat[paramInt2] *= paramFloat / paramInt4;
      paramInt1 += 2;
    }
    RendererUtils.RenderContext.access$002(paramRenderContext, createVerticesBuffer(arrayOfFloat));
  }
  
  public static void setRenderToScale(RendererUtils.RenderContext paramRenderContext, RectF paramRectF)
  {
    RendererUtils.RenderContext.access$002(paramRenderContext, createVerticesBuffer(new float[] { paramRectF.left * 2.0F - 1.0F, 1.0F - paramRectF.bottom * 2.0F, paramRectF.right * 2.0F - 1.0F, 1.0F - paramRectF.bottom * 2.0F, paramRectF.left * 2.0F - 1.0F, 1.0F - paramRectF.top * 2.0F, paramRectF.right * 2.0F - 1.0F, 1.0F - paramRectF.top * 2.0F }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.view.RendererUtils
 * JD-Core Version:    0.7.0.1
 */