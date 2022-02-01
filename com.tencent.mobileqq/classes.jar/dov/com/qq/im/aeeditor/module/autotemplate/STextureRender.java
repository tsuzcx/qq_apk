package dov.com.qq.im.aeeditor.module.autotemplate;

import android.graphics.SurfaceTexture;
import android.opengl.GLES30;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/autotemplate/STextureRender;", "", "()V", "mMVPMatrix", "", "mProgram", "", "mSTMatrix", "mTextureId", "mTriangleVertices", "Ljava/nio/FloatBuffer;", "mTriangleVerticesData", "maPositionHandle", "maTextureHandle", "muMVPMatrixHandle", "muSTMatrixHandle", "changeFragmentShader", "", "fragmentShader", "", "checkGlError", "op", "createProgram", "vertexSource", "fragmentSource", "drawFrame", "st", "Landroid/graphics/SurfaceTexture;", "invert", "", "getTextureId", "loadShader", "shaderType", "source", "surfaceCreated", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class STextureRender
{
  public static final STextureRender.Companion a = new STextureRender.Companion(null);
  private final float[] b = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private final FloatBuffer c;
  private final float[] d = new float[16];
  private final float[] e = new float[16];
  private int f;
  private int g = -1;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public STextureRender()
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(this.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Intrinsics.checkExpressionValueIsNotNull(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.c = localFloatBuffer;
    this.c.put(this.b).position(0);
    Matrix.setIdentityM(this.e, 0);
  }
  
  private final int a(int paramInt, String paramString)
  {
    int m = GLES30.glCreateShader(paramInt);
    GLES30.glShaderSource(m, paramString);
    GLES30.glCompileShader(m);
    paramString = new int[1];
    GLES30.glGetShaderiv(m, 35713, paramString, 0);
    paramInt = m;
    if (paramString[0] == 0)
    {
      GLES30.glDeleteShader(m);
      paramInt = 0;
    }
    return paramInt;
  }
  
  private final int a(String paramString1, String paramString2)
  {
    int m = a(35633, paramString1);
    if (m == 0) {
      return 0;
    }
    int n = a(35632, paramString2);
    if (n == 0) {
      return 0;
    }
    int i1 = GLES30.glCreateProgram();
    GLES30.glAttachShader(i1, m);
    GLES30.glAttachShader(i1, n);
    GLES30.glLinkProgram(i1);
    paramString1 = new int[1];
    GLES30.glGetProgramiv(i1, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("STextureRender", "Could not link program: ");
      Log.e("STextureRender", GLES30.glGetProgramInfoLog(i1));
      GLES30.glDeleteProgram(i1);
      return 0;
    }
    return i1;
  }
  
  private final void a(String paramString)
  {
    Ref.IntRef localIntRef = new Ref.IntRef();
    int m = GLES30.glGetError();
    localIntRef.element = m;
    if (m == 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": glError ");
    localStringBuilder.append(localIntRef.element);
    Log.e("STextureRender", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": glError ");
    localStringBuilder.append(localIntRef.element);
    throw ((Throwable)new RuntimeException(localStringBuilder.toString()));
  }
  
  public final int a()
  {
    return this.g;
  }
  
  public final void a(@NotNull SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "st");
    a("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.e);
    if (paramBoolean)
    {
      paramSurfaceTexture = this.e;
      paramSurfaceTexture[5] = (-paramSurfaceTexture[5]);
      paramSurfaceTexture[13] = (1.0F - paramSurfaceTexture[13]);
    }
    GLES30.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES30.glClear(16384);
    GLES30.glUseProgram(this.f);
    GLES30.glActiveTexture(33984);
    GLES30.glBindTexture(36197, this.g);
    this.c.position(0);
    GLES30.glVertexAttribPointer(this.j, 3, 5126, false, 20, (Buffer)this.c);
    GLES30.glEnableVertexAttribArray(this.j);
    this.c.position(3);
    GLES30.glVertexAttribPointer(this.k, 2, 5126, false, 20, (Buffer)this.c);
    GLES30.glEnableVertexAttribArray(this.k);
    Matrix.setIdentityM(this.d, 0);
    GLES30.glUniformMatrix4fv(this.h, 1, false, this.d, 0);
    GLES30.glUniformMatrix4fv(this.i, 1, false, this.e, 0);
    GLES30.glDrawArrays(5, 0, 4);
    GLES30.glBindTexture(36197, 0);
  }
  
  public final void b()
  {
    this.f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    int m = this.f;
    if (m != 0)
    {
      this.j = GLES30.glGetAttribLocation(m, "aPosition");
      this.k = GLES30.glGetAttribLocation(this.f, "aTextureCoord");
      this.h = GLES30.glGetUniformLocation(this.f, "uMVPMatrix");
      this.i = GLES30.glGetUniformLocation(this.f, "uSTMatrix");
      int[] arrayOfInt = new int[1];
      GLES30.glGenTextures(1, arrayOfInt, 0);
      this.g = arrayOfInt[0];
      GLES30.glBindTexture(36197, this.g);
      GLES30.glTexParameterf(36197, 10241, 9728);
      GLES30.glTexParameterf(36197, 10240, 9729);
      GLES30.glTexParameteri(36197, 10242, 33071);
      GLES30.glTexParameteri(36197, 10243, 33071);
      return;
    }
    throw ((Throwable)new RuntimeException("failed creating program"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.STextureRender
 * JD-Core Version:    0.7.0.1
 */