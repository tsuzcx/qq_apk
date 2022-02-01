package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.ProgramTools;
import com.tencent.aekit.openrender.util.ProgramTools.ProgramInfo;
import java.nio.FloatBuffer;

public class GPUBaseFilter
{
  public static final int FILTER_BASE = 100;
  public static final int FLOAT_SIZE_BYTES = 4;
  public static final int MOSAIC_FILTER_ID = 106;
  public static final String NO_FILTER_FRAGMENT_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";
  public static final int NO_FILTER_ID = 101;
  public static final int NO_FILTER_ID_OES = 102;
  public static final String NO_FILTER_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n";
  private static final String TAG = "GPUBaseFilter";
  public static final float[] TEXUTURE_COORDS = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  public static float[] VERTEXT_COORDS = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  protected int mFilterType = 101;
  private final String mFragmentShader;
  private boolean mIsInitialized;
  protected int mOutputHeight;
  protected int mOutputWidth;
  private int mProgram;
  public int mTextureType = 3553;
  private FloatBuffer mUserTextureCoord = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  private final String mVertexShader;
  
  public GPUBaseFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
  }
  
  public GPUBaseFilter(String paramString1, String paramString2)
  {
    this.mVertexShader = paramString1;
    this.mFragmentShader = paramString2;
    this.mTextureType = 3553;
    this.mFilterType = 101;
  }
  
  public static float[] caculateAbsoluteMvpMatrix(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt1 / paramInt3;
    float f2 = paramInt2 / paramInt4;
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.scaleM(arrayOfFloat, 0, f1, f2, 1.0F);
    return arrayOfFloat;
  }
  
  public static float[] caculateCenterCropMvpMatrix(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt3;
    float f2 = paramInt4;
    float f3 = f1 / f2;
    float f4 = paramInt1 / paramInt2;
    if (f3 < f4)
    {
      f1 = f4 * f2 / f1;
    }
    else
    {
      if (f3 > f4)
      {
        f2 = f1 / (f4 * f2);
        f1 = 1.0F;
        break label73;
      }
      f1 = 1.0F;
    }
    f2 = 1.0F;
    label73:
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.scaleM(arrayOfFloat, 0, f1, f2, 1.0F);
    return arrayOfFloat;
  }
  
  public static float[] caculateFitCenterMvpMatrix(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt3;
    float f2 = paramInt4;
    float f3 = f1 / f2;
    float f4 = paramInt1 / paramInt2;
    if (f3 > f4)
    {
      f1 = f4 * f2 / f1;
    }
    else
    {
      if (f3 < f4)
      {
        f2 = f1 / (f4 * f2);
        f1 = 1.0F;
        break label73;
      }
      f1 = 1.0F;
    }
    f2 = 1.0F;
    label73:
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.scaleM(arrayOfFloat, 0, f1, f2, 1.0F);
    return arrayOfFloat;
  }
  
  public static void checkGlError(String paramString)
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
      localStringBuilder.append(i);
      new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public static void checkLocation(int paramInt, String paramString)
  {
    if (paramInt < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to locate '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' in program");
      new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public void destroy()
  {
    this.mIsInitialized = false;
    GLES20.glDeleteProgram(this.mProgram);
    this.mProgram = 0;
    onDestroy();
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    checkGlError("onDrawFrame start");
    int m = getProgram();
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null)
    {
      paramArrayOfFloat1 = new float[16];
      Matrix.setIdentityM(paramArrayOfFloat1, 0);
    }
    GLES20.glUseProgram(m);
    checkGlError("glUseProgram");
    int i = GLES20.glGetAttribLocation(m, "aPosition");
    checkLocation(i, "aPosition");
    int j = GLES20.glGetAttribLocation(m, "aTextureCoord");
    checkLocation(j, "aTextureCoord");
    int k = GLES20.glGetUniformLocation(m, "uMVPMatrix");
    checkLocation(k, "uMVPMatrix");
    m = GLES20.glGetUniformLocation(m, "uTextureMatrix");
    checkLocation(m, "uTextureMatrix");
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, VERTEXT_BUF);
    checkGlError("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(i);
    checkGlError("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, this.mUserTextureCoord);
    checkGlError("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    checkGlError("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(k, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(m, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    onDrawTexture();
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, 0);
  }
  
  public int getFilterType()
  {
    return this.mFilterType;
  }
  
  public int getProgram()
  {
    return this.mProgram;
  }
  
  public void init()
  {
    if (this.mIsInitialized) {
      return;
    }
    Object localObject = ProgramTools.createProgram(this.mVertexShader, this.mFragmentShader);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("failed creating program ");
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      new RuntimeException(((StringBuilder)localObject).toString());
      return;
    }
    this.mProgram = ((ProgramTools.ProgramInfo)localObject).programId;
    this.mIsInitialized = true;
    onInitialized();
  }
  
  public void initForce()
  {
    this.mIsInitialized = false;
    init();
  }
  
  public boolean isInitialized()
  {
    return this.mIsInitialized;
  }
  
  protected void onDestroy() {}
  
  protected void onDrawTexture() {}
  
  protected void onInitialized() {}
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
  }
  
  public void setUserTextureCoords(float[] paramArrayOfFloat)
  {
    this.mUserTextureCoord.position(0);
    this.mUserTextureCoord.put(paramArrayOfFloat);
    this.mUserTextureCoord.position(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GPUBaseFilter
 * JD-Core Version:    0.7.0.1
 */