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
  public static final STextureRender.Companion a;
  private int jdField_a_of_type_Int;
  private final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private final float[] jdField_a_of_type_ArrayOfFloat = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private int jdField_b_of_type_Int = -1;
  private final float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int;
  private final float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private int d;
  private int e;
  private int f;
  
  static
  {
    jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateSTextureRender$Companion = new STextureRender.Companion(null);
  }
  
  public STextureRender()
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    Intrinsics.checkExpressionValueIsNotNull(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.jdField_a_of_type_JavaNioFloatBuffer = localFloatBuffer;
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfFloat).position(0);
    Matrix.setIdentityM(this.jdField_c_of_type_ArrayOfFloat, 0);
  }
  
  private final int a(int paramInt, String paramString)
  {
    int i = GLES30.glCreateShader(paramInt);
    GLES30.glShaderSource(i, paramString);
    GLES30.glCompileShader(i);
    paramString = new int[1];
    GLES30.glGetShaderiv(i, 35713, paramString, 0);
    paramInt = i;
    if (paramString[0] == 0)
    {
      GLES30.glDeleteShader(i);
      paramInt = 0;
    }
    return paramInt;
  }
  
  private final int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    if (i == 0) {
      return 0;
    }
    int j = a(35632, paramString2);
    if (j == 0) {
      return 0;
    }
    int k = GLES30.glCreateProgram();
    GLES30.glAttachShader(k, i);
    GLES30.glAttachShader(k, j);
    GLES30.glLinkProgram(k);
    paramString1 = new int[1];
    GLES30.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("STextureRender", "Could not link program: ");
      Log.e("STextureRender", GLES30.glGetProgramInfoLog(k));
      GLES30.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  private final void a(String paramString)
  {
    Ref.IntRef localIntRef = new Ref.IntRef();
    int i = GLES30.glGetError();
    localIntRef.element = i;
    if (i == 0) {
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
    return this.jdField_b_of_type_Int;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_Int = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      this.e = GLES30.glGetAttribLocation(i, "aPosition");
      this.f = GLES30.glGetAttribLocation(this.jdField_a_of_type_Int, "aTextureCoord");
      this.jdField_c_of_type_Int = GLES30.glGetUniformLocation(this.jdField_a_of_type_Int, "uMVPMatrix");
      this.d = GLES30.glGetUniformLocation(this.jdField_a_of_type_Int, "uSTMatrix");
      int[] arrayOfInt = new int[1];
      GLES30.glGenTextures(1, arrayOfInt, 0);
      this.jdField_b_of_type_Int = arrayOfInt[0];
      GLES30.glBindTexture(36197, this.jdField_b_of_type_Int);
      GLES30.glTexParameterf(36197, 10241, 9728);
      GLES30.glTexParameterf(36197, 10240, 9729);
      GLES30.glTexParameteri(36197, 10242, 33071);
      GLES30.glTexParameteri(36197, 10243, 33071);
      return;
    }
    throw ((Throwable)new RuntimeException("failed creating program"));
  }
  
  public final void a(@NotNull SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTexture, "st");
    a("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.jdField_c_of_type_ArrayOfFloat);
    if (paramBoolean)
    {
      paramSurfaceTexture = this.jdField_c_of_type_ArrayOfFloat;
      paramSurfaceTexture[5] = (-paramSurfaceTexture[5]);
      paramSurfaceTexture[13] = (1.0F - paramSurfaceTexture[13]);
    }
    GLES30.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES30.glClear(16384);
    GLES30.glUseProgram(this.jdField_a_of_type_Int);
    GLES30.glActiveTexture(33984);
    GLES30.glBindTexture(36197, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES30.glVertexAttribPointer(this.e, 3, 5126, false, 20, (Buffer)this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES30.glEnableVertexAttribArray(this.e);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(3);
    GLES30.glVertexAttribPointer(this.f, 2, 5126, false, 20, (Buffer)this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES30.glEnableVertexAttribArray(this.f);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    GLES30.glUniformMatrix4fv(this.jdField_c_of_type_Int, 1, false, this.jdField_b_of_type_ArrayOfFloat, 0);
    GLES30.glUniformMatrix4fv(this.d, 1, false, this.jdField_c_of_type_ArrayOfFloat, 0);
    GLES30.glDrawArrays(5, 0, 4);
    GLES30.glBindTexture(36197, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.STextureRender
 * JD-Core Version:    0.7.0.1
 */