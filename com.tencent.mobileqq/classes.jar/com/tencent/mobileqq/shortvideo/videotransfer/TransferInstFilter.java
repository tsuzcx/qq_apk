package com.tencent.mobileqq.shortvideo.videotransfer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.FloatBuffer;

public class TransferInstFilter
  extends GPUBaseFilter
{
  private static final float[] BLURWEIGHTS = { 0.041555F, 0.041348F, 0.040733F, 0.039728F, 0.038363F, 0.036676F, 0.034715F, 0.032532F, 0.030183F, 0.027726F, 0.025215F, 0.022704F, 0.020239F, 0.017863F, 0.015609F, 0.013504F, 0.011566F, 0.009808F, 0.008235F, 0.006845F, 0.005633F };
  public static final String DEFAULT_FRAGMENT_SHADER = "precision highp float;\n\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform vec2 inputImageTextureSize;\nuniform vec2 inputImageTexture2Size;\nuniform vec2 timeRange; //start, duration\nuniform float time;\n\nvoid main() {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n";
  public static final String DEFAULT_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\ngl_Position = uMVPMatrix * position;\ntextureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n}";
  private static final String TAG = "TransferInstFilter";
  private static final FloatBuffer TEXTURE_BUF;
  private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  private int iResolution = -1;
  private int mAttrMVPMatrix = -1;
  private int mAttrPosition = -1;
  private int mAttrTextureCoord = -1;
  private int mAttrTextureMatrix = -1;
  private float[] mCommonFloats = new float[4];
  private int mCurrentTimeMs = 0;
  private float[] mDefaultMvpMatirx;
  private float[] mDefaultTextureMatirx;
  private int mEndTimeMs = 0;
  private int mInputTextureID;
  private int mOffsetLocation = -1;
  private int mOutputTextureID;
  private RenderBuffer mRenderFBO;
  private int mSampleSizeLoc = -1;
  private int mStartTimeMs = 0;
  private int mUniCommonParam = -1;
  private int mUniCurrentTime = -1;
  private int mUniInputTexture = -1;
  private int mUniInputTexture2 = -1;
  private int mUniInputTexture2Size = -1;
  private int mUniInputTextureSize = -1;
  private int mUniTimeRange = -1;
  private int mWeightsLoc = -1;
  private int shaderID;
  
  static
  {
    TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  }
  
  public TransferInstFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void destroy()
  {
    super.destroy();
    RenderBuffer localRenderBuffer = this.mRenderFBO;
    if (localRenderBuffer != null)
    {
      localRenderBuffer.destroy();
      this.mRenderFBO = null;
    }
  }
  
  public boolean drawTexture(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    paramInt1 = this.mCurrentTimeMs;
    if (paramInt1 <= this.mEndTimeMs)
    {
      if (paramInt1 < this.mStartTimeMs) {
        return false;
      }
      checkGlError("onDrawFrame start");
      float[] arrayOfFloat = paramArrayOfFloat1;
      if (paramArrayOfFloat1 == null) {
        arrayOfFloat = this.mDefaultTextureMatirx;
      }
      paramArrayOfFloat1 = paramArrayOfFloat2;
      if (paramArrayOfFloat2 == null) {
        paramArrayOfFloat1 = this.mDefaultMvpMatirx;
      }
      paramInt1 = getProgram();
      if (paramInt1 > 0)
      {
        paramArrayOfFloat2 = this.mRenderFBO;
        if (paramArrayOfFloat2 == null) {
          return false;
        }
        paramArrayOfFloat2.bind();
        GLES20.glUseProgram(paramInt1);
        GLES20.glVertexAttribPointer(this.mAttrPosition, 2, 5126, false, 8, VERTEXT_BUF);
        checkGlError("glVertexAttribPointer mAttrPosition");
        GLES20.glEnableVertexAttribArray(this.mAttrPosition);
        checkGlError("glEnableVertexAttribArray mAttrPosition");
        GLES20.glVertexAttribPointer(this.mAttrTextureCoord, 2, 5126, false, 8, TEXTURE_BUF);
        checkGlError("glVertexAttribPointer mAttrTextureCoord");
        GLES20.glEnableVertexAttribArray(this.mAttrTextureCoord);
        checkGlError("glEnableVertexAttribArray mAttrTextureCoord");
        paramInt1 = this.mAttrMVPMatrix;
        if (paramInt1 >= 0)
        {
          GLES20.glUniformMatrix4fv(paramInt1, 1, false, paramArrayOfFloat1, 0);
          checkGlError("glUniformMatrix4fv mAttrMVPMatrix");
        }
        paramInt1 = this.mAttrTextureMatrix;
        if (paramInt1 >= 0)
        {
          GLES20.glUniformMatrix4fv(paramInt1, 1, false, arrayOfFloat, 0);
          checkGlError("glUniformMatrix4fv mAttrTextureMatrix");
        }
        if (this.mInputTextureID >= 0)
        {
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(this.mTextureType, this.mInputTextureID);
          GLES20.glUniform1i(this.mUniInputTexture, 0);
        }
        if (paramInt2 >= 0)
        {
          GLES20.glActiveTexture(33985);
          GLES20.glBindTexture(this.mTextureType, paramInt2);
          GLES20.glUniform1i(this.mUniInputTexture2, 1);
        }
        paramInt1 = this.mUniInputTextureSize;
        if (paramInt1 >= 0)
        {
          GLES20.glUniform2f(paramInt1, this.mOutputWidth, this.mOutputHeight);
          checkGlError("glUniform2f mUniInputTextureSize");
        }
        paramInt1 = this.mUniInputTexture2Size;
        if (paramInt1 >= 0)
        {
          GLES20.glUniform2f(paramInt1, this.mOutputWidth, this.mOutputHeight);
          checkGlError("glUniform2f mUniInputTexture2Size");
        }
        paramInt1 = this.iResolution;
        if (paramInt1 >= 0)
        {
          GLES20.glUniform3f(paramInt1, this.mOutputWidth, this.mOutputHeight, 0.0F);
          checkGlError("glUniform2f iResolution");
        }
        if (this.shaderID == 4)
        {
          paramInt1 = this.mOffsetLocation;
          if (paramInt1 >= 0) {
            GLES20.glUniform2f(paramInt1, 1.0F / this.mOutputWidth, 1.0F / this.mOutputHeight);
          }
          paramInt1 = this.mWeightsLoc;
          if (paramInt1 >= 0)
          {
            paramArrayOfFloat1 = BLURWEIGHTS;
            GLES20.glUniform1fv(paramInt1, paramArrayOfFloat1.length, FloatBuffer.wrap(paramArrayOfFloat1));
          }
        }
        GLES20.glUniform1f(this.mUniCurrentTime, this.mCurrentTimeMs);
        checkGlError("glUniform2f mUniCurrentTime");
        paramInt1 = this.mUniTimeRange;
        int i = this.mStartTimeMs;
        GLES20.glUniform2f(paramInt1, i, this.mEndTimeMs - i);
        checkGlError("glUniform2f mUniTimeRange");
        paramInt1 = this.mUniCommonParam;
        paramArrayOfFloat1 = this.mCommonFloats;
        GLES20.glUniform4f(paramInt1, paramArrayOfFloat1[0], paramArrayOfFloat1[1], paramArrayOfFloat1[2], paramArrayOfFloat1[3]);
        onDrawTexture();
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.mAttrPosition);
        GLES20.glDisableVertexAttribArray(this.mAttrTextureCoord);
        if (paramInt2 >= 0)
        {
          GLES20.glActiveTexture(33985);
          GLES20.glBindTexture(this.mTextureType, 0);
        }
        if (this.mInputTextureID >= 0)
        {
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(this.mTextureType, 0);
        }
        setOutputTextureID(this.mRenderFBO.getTexId());
        this.mRenderFBO.unbind();
        return true;
      }
    }
    return false;
  }
  
  public int getOutputTextureID()
  {
    return this.mOutputTextureID;
  }
  
  public int getShaderID()
  {
    return this.shaderID;
  }
  
  protected void onInitialized()
  {
    this.mDefaultTextureMatirx = new float[16];
    Matrix.setIdentityM(this.mDefaultTextureMatirx, 0);
    this.mDefaultMvpMatirx = new float[16];
    Matrix.setIdentityM(this.mDefaultMvpMatirx, 0);
    int i = getProgram();
    if (i <= 0) {
      return;
    }
    GLES20.glUseProgram(i);
    this.mAttrPosition = GLES20.glGetAttribLocation(i, "position");
    checkLocation(this.mAttrPosition, "position");
    this.mAttrTextureCoord = GLES20.glGetAttribLocation(i, "inputTextureCoordinate");
    checkLocation(this.mAttrTextureCoord, "inputTextureCoordinate");
    this.mAttrMVPMatrix = GLES20.glGetUniformLocation(i, "uMVPMatrix");
    checkLocation(this.mAttrMVPMatrix, "uMVPMatrix");
    this.mAttrTextureMatrix = GLES20.glGetUniformLocation(i, "uTextureMatrix");
    checkLocation(this.mAttrTextureMatrix, "uTextureMatrix");
    this.mUniInputTexture = GLES20.glGetUniformLocation(i, "inputImageTexture");
    checkLocation(this.mUniInputTexture, "inputImageTexture");
    this.mUniInputTexture2 = GLES20.glGetUniformLocation(i, "inputImageTexture2");
    checkLocation(this.mUniInputTexture2, "inputImageTexture2");
    this.mUniInputTextureSize = GLES20.glGetUniformLocation(i, "inputImageTextureSize");
    this.mUniInputTexture2Size = GLES20.glGetUniformLocation(i, "inputImageTexture2Size");
    this.mUniTimeRange = GLES20.glGetUniformLocation(i, "timeRange");
    checkLocation(this.mUniTimeRange, "timeRange");
    this.mUniCurrentTime = GLES20.glGetUniformLocation(i, "time");
    checkLocation(this.mUniCurrentTime, "time");
    this.iResolution = GLES20.glGetUniformLocation(i, "iResolution");
    checkLocation(this.mUniCurrentTime, "iResolution");
    this.mUniCommonParam = GLES20.glGetUniformLocation(i, "commonParamVec4");
    checkLocation(this.mUniCommonParam, "commonParamVec4");
    if (this.shaderID == 4)
    {
      this.mOffsetLocation = GLES20.glGetUniformLocation(i, "texelOffset");
      this.mWeightsLoc = GLES20.glGetUniformLocation(i, "weight");
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    RenderBuffer localRenderBuffer = this.mRenderFBO;
    if ((localRenderBuffer == null) || (localRenderBuffer.getWidth() != paramInt1) || (this.mRenderFBO.getHeight() != paramInt2)) {
      this.mRenderFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
  }
  
  public void setInputTextureID(int paramInt)
  {
    this.mInputTextureID = paramInt;
  }
  
  public void setOutputTextureID(int paramInt)
  {
    this.mOutputTextureID = paramInt;
  }
  
  public void setShaderID(int paramInt)
  {
    this.shaderID = paramInt;
  }
  
  public void updateData(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mCurrentTimeMs = paramInt3;
    this.mStartTimeMs = paramInt1;
    this.mEndTimeMs = paramInt2;
    float[] arrayOfFloat = this.mCommonFloats;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[2] = paramFloat3;
    arrayOfFloat[3] = paramFloat4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferInstFilter
 * JD-Core Version:    0.7.0.1
 */