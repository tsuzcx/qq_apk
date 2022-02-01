package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class GPUOESMovieFilter
  extends GPUBaseFilter
{
  private static float HALF = 0.5F;
  private static final String MOVIE_FRAG_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nuniform int v_isAlpha;\nuniform float real_half;\nuniform float x_add_margin;\n\nvoid main () {\n    if(v_TexCoordinate.x  > x_add_margin && v_TexCoordinate.x  < real_half - x_add_margin\n    && v_TexCoordinate.y  > 0.0 && v_TexCoordinate.y  < 1.0) {\n        vec4 color;\n        color = texture2D(texture, v_TexCoordinate);\n        float alpha = 1.0;\n        if (v_isAlpha == 1) {\n            alpha = texture2D(texture, v_TexAlphaCoordinate).g;\n        }\n        gl_FragColor = color;\n        gl_FragColor.a = gl_FragColor.a * alpha;\n        gl_FragColor.r = gl_FragColor.r * alpha;\n        gl_FragColor.g = gl_FragColor.g * alpha;\n        gl_FragColor.b = gl_FragColor.b * alpha;\n    } else {\n        gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n    } \n}";
  private static final String MOVIE_VERTEX_SHADER = "attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}\n";
  public static final String TAG = "GPUOESMovieFilter";
  private static final short[] sDrawOrder = { 0, 1, 2, 0, 2, 3 };
  public float height;
  private ShortBuffer mDrawListBuffer;
  private boolean mIsSupportAlpha = true;
  private int mPositionHandle;
  private int mRealHalfHandle;
  private float[] mSquareCoords = { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  private int mSupportAlphaHandle;
  private int mTextureAlphaCoordinateHandle;
  private FloatBuffer mTextureBuffer;
  private FloatBuffer mTextureBuffer2;
  private int mTextureCoordinateHandle;
  private float[] mTextureCoords;
  private float[] mTextureCoords2;
  private int mTextureParamHandle;
  private int mTextureTranformHandle;
  private FloatBuffer mVertexBuffer;
  private int mXAddMarginHandle;
  public int opacity = 255;
  public float rotate = 0.0F;
  public float scale = 1.0F;
  public float width;
  public float x;
  public float y;
  
  public GPUOESMovieFilter()
  {
    super("attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nuniform int v_isAlpha;\nuniform float real_half;\nuniform float x_add_margin;\n\nvoid main () {\n    if(v_TexCoordinate.x  > x_add_margin && v_TexCoordinate.x  < real_half - x_add_margin\n    && v_TexCoordinate.y  > 0.0 && v_TexCoordinate.y  < 1.0) {\n        vec4 color;\n        color = texture2D(texture, v_TexCoordinate);\n        float alpha = 1.0;\n        if (v_isAlpha == 1) {\n            alpha = texture2D(texture, v_TexAlphaCoordinate).g;\n        }\n        gl_FragColor = color;\n        gl_FragColor.a = gl_FragColor.a * alpha;\n        gl_FragColor.r = gl_FragColor.r * alpha;\n        gl_FragColor.g = gl_FragColor.g * alpha;\n        gl_FragColor.b = gl_FragColor.b * alpha;\n    } else {\n        gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n    } \n}");
    this.mTextureType = 36197;
    this.mFilterType = 102;
    float f = HALF;
    this.mTextureCoords = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, f, 0.0F, 0.0F, 1.0F, f, 1.0F, 0.0F, 1.0F };
    this.mTextureCoords2 = new float[] { f, 1.0F, 0.0F, 1.0F, f, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  }
  
  private void setupGraphics()
  {
    int i = getProgram();
    GLES20.glUseProgram(i);
    this.mTextureParamHandle = GLES20.glGetUniformLocation(i, "texture");
    this.mTextureCoordinateHandle = GLES20.glGetAttribLocation(i, "vTexCoordinate");
    this.mTextureAlphaCoordinateHandle = GLES20.glGetAttribLocation(i, "vTexAlphaCoordinate");
    this.mPositionHandle = GLES20.glGetAttribLocation(i, "vPosition");
    this.mTextureTranformHandle = GLES20.glGetUniformLocation(i, "textureTransform");
    this.mSupportAlphaHandle = GLES20.glGetUniformLocation(i, "v_isAlpha");
    this.mRealHalfHandle = GLES20.glGetUniformLocation(i, "real_half");
    this.mXAddMarginHandle = GLES20.glGetUniformLocation(i, "x_add_margin");
  }
  
  private void setupTexture()
  {
    FloatBuffer localFloatBuffer = this.mTextureBuffer;
    if ((localFloatBuffer != null) && (this.mTextureBuffer2 != null))
    {
      localFloatBuffer.clear();
      this.mTextureBuffer.put(this.mTextureCoords);
      this.mTextureBuffer.position(0);
      this.mTextureBuffer2.clear();
      this.mTextureBuffer2.put(this.mTextureCoords2);
      this.mTextureBuffer2.position(0);
      return;
    }
    this.mTextureBuffer = GlUtil.createFloatBuffer(this.mTextureCoords);
    this.mTextureBuffer2 = GlUtil.createFloatBuffer(this.mTextureCoords2);
  }
  
  private void setupVertexBuffer()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(sDrawOrder.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.mDrawListBuffer = localByteBuffer.asShortBuffer();
    this.mDrawListBuffer.put(sDrawOrder);
    this.mDrawListBuffer.position(0);
    this.mVertexBuffer = GlUtil.createFloatBuffer(this.mSquareCoords);
  }
  
  public void adjustVideo(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((this.mOutputHeight != 0) && (this.mOutputWidth != 0))
    {
      paramFloat1 = paramFloat1 / HALF / (this.mOutputHeight * 1.0F / this.mOutputWidth);
      if (paramFloat1 > 1.0F) {
        f1 = 1.0F;
      } else {
        f1 = paramFloat1;
      }
      if (paramFloat1 > 1.0F) {
        paramFloat1 = 1.0F / paramFloat1;
      } else {
        paramFloat1 = 1.0F;
      }
    }
    else
    {
      paramFloat1 = 1.0F;
      f1 = 1.0F;
    }
    float f2 = HALF;
    float f3 = f2 * 0.5F * (1.0F - f1);
    float f4 = (1.0F - paramFloat1) * 0.5F;
    paramFloat2 = f2 * paramFloat2 * f1;
    paramFloat3 = paramFloat1 * paramFloat3;
    float[] arrayOfFloat = this.mTextureCoords;
    float f1 = f3 + paramFloat2;
    arrayOfFloat[0] = f1;
    paramFloat1 = 1.0F - f4 + paramFloat3;
    arrayOfFloat[1] = paramFloat1;
    arrayOfFloat[4] = f1;
    paramFloat3 = f4 + paramFloat3;
    arrayOfFloat[5] = paramFloat3;
    arrayOfFloat[8] = (f2 - f3 + paramFloat2);
    arrayOfFloat[9] = paramFloat3;
    arrayOfFloat[12] = (f2 - f3 + paramFloat2);
    arrayOfFloat[13] = paramFloat1;
    arrayOfFloat = this.mTextureCoords2;
    arrayOfFloat[0] = (f2 + f3 + paramFloat2);
    arrayOfFloat[1] = paramFloat1;
    arrayOfFloat[4] = (f2 + f3 + paramFloat2);
    arrayOfFloat[5] = paramFloat3;
    paramFloat2 = 1.0F - f3 + paramFloat2;
    arrayOfFloat[8] = paramFloat2;
    arrayOfFloat[9] = paramFloat3;
    arrayOfFloat[12] = paramFloat2;
    arrayOfFloat[13] = paramFloat1;
    setupTexture();
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat)
  {
    if (this.mVertexBuffer == null) {
      return;
    }
    float[] arrayOfFloat = paramArrayOfFloat;
    if (paramArrayOfFloat == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    GLES20.glUseProgram(getProgram());
    GLES20.glEnableVertexAttribArray(this.mPositionHandle);
    GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 0, this.mVertexBuffer);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    GLES20.glUniform1i(this.mTextureParamHandle, 0);
    float f1 = HALF;
    float f2 = arrayOfFloat[0];
    GLES20.glUniform1f(this.mRealHalfHandle, f1 * f2);
    GLES20.glUniform1f(this.mXAddMarginHandle, arrayOfFloat[0] / this.mOutputWidth * 2.0F);
    GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandle);
    GLES20.glVertexAttribPointer(this.mTextureCoordinateHandle, 4, 5126, false, 0, this.mTextureBuffer);
    if (this.mIsSupportAlpha)
    {
      GLES20.glUniform1i(this.mSupportAlphaHandle, 1);
      GLES20.glEnableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
      GLES20.glVertexAttribPointer(this.mTextureAlphaCoordinateHandle, 4, 5126, false, 0, this.mTextureBuffer2);
    }
    else
    {
      GLES20.glUniform1i(this.mSupportAlphaHandle, 0);
    }
    GLES20.glUniformMatrix4fv(this.mTextureTranformHandle, 1, false, arrayOfFloat, 0);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(1, 771);
    GLES20.glDrawElements(4, sDrawOrder.length, 5123, this.mDrawListBuffer);
    GLES20.glDisableVertexAttribArray(this.mPositionHandle);
    GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandle);
    GLES20.glDisableVertexAttribArray(this.mTextureAlphaCoordinateHandle);
  }
  
  protected void onInitialized()
  {
    setupGraphics();
    setupVertexBuffer();
    setupTexture();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter
 * JD-Core Version:    0.7.0.1
 */