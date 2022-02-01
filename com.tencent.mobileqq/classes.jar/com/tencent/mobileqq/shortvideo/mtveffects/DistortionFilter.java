package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;

public class DistortionFilter
  extends BaseFragmentFilter
{
  public static final String BOTTOM_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!畸变图片\nuniform vec2 inputImageTextureSize;\nuniform vec4 distortionParam; //!畸变参数：x < 0 is pincushion distortion,  >=0 is barrel distortion 例如：(1.2,0.5, 1.0) z: scale factor\nuniform vec2 distortionCenter; //!畸变中心\n\n \n\n\nvoid main() \n{\n    vec2 dstPos;  \n    float fDistance = sqrt((vTextureCoord.x - distortionCenter.x) * (vTextureCoord.x - distortionCenter.x) + (vTextureCoord.y - distortionCenter.y) * (vTextureCoord.y - distortionCenter.y));\n    float fDistanceNew = fDistance * (1.0 + distortionParam.x * (fDistance * fDistance) + distortionParam.y * (fDistance * fDistance * fDistance * fDistance));\n    float fTheta = atan(vTextureCoord.x - distortionCenter.x, vTextureCoord.y - distortionCenter.y);\n    float fDistortionX = sin(fTheta) * fDistanceNew * distortionParam.z;\n    float fDistortionY = cos(fTheta) * fDistanceNew * distortionParam.z;\n    dstPos.x = fDistortionX + distortionCenter.x;\n\tdstPos.y = fDistortionY + distortionCenter.y;\n       \n    gl_FragColor = texture2D(inputImageTexture, dstPos);\n\t\n}\n";
  private static final String TAG = "DistortionFilter";
  private int mUniDistortionCenter = -1;
  private int mUniDistortionParam = -1;
  private int mUniInputTexture = -1;
  private int mUniInputTextureSize = -1;
  
  public DistortionFilter()
  {
    super("precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!畸变图片\nuniform vec2 inputImageTextureSize;\nuniform vec4 distortionParam; //!畸变参数：x < 0 is pincushion distortion,  >=0 is barrel distortion 例如：(1.2,0.5, 1.0) z: scale factor\nuniform vec2 distortionCenter; //!畸变中心\n\n \n\n\nvoid main() \n{\n    vec2 dstPos;  \n    float fDistance = sqrt((vTextureCoord.x - distortionCenter.x) * (vTextureCoord.x - distortionCenter.x) + (vTextureCoord.y - distortionCenter.y) * (vTextureCoord.y - distortionCenter.y));\n    float fDistanceNew = fDistance * (1.0 + distortionParam.x * (fDistance * fDistance) + distortionParam.y * (fDistance * fDistance * fDistance * fDistance));\n    float fTheta = atan(vTextureCoord.x - distortionCenter.x, vTextureCoord.y - distortionCenter.y);\n    float fDistortionX = sin(fTheta) * fDistanceNew * distortionParam.z;\n    float fDistortionY = cos(fTheta) * fDistanceNew * distortionParam.z;\n    dstPos.x = fDistortionX + distortionCenter.x;\n\tdstPos.y = fDistortionY + distortionCenter.y;\n       \n    gl_FragColor = texture2D(inputImageTexture, dstPos);\n\t\n}\n");
  }
  
  protected void onInitialized()
  {
    super.onInitialized();
    int i = getProgram();
    if (i <= 0) {
      return;
    }
    this.mUniInputTexture = GLES20.glGetUniformLocation(i, "inputImageTexture");
    this.mUniInputTextureSize = GLES20.glGetUniformLocation(i, "inputImageTextureSize");
    this.mUniDistortionParam = GLES20.glGetUniformLocation(i, "distortionParam");
    this.mUniDistortionCenter = GLES20.glGetUniformLocation(i, "distortionCenter");
  }
  
  public boolean process(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt < 0) {
      return false;
    }
    if (!processBegin(paramArrayOfFloat1, paramArrayOfFloat2)) {
      return false;
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    GLES20.glUniform1i(this.mUniInputTexture, 0);
    GLES20.glUniform2f(this.mUniInputTextureSize, this.mOutputWidth, this.mOutputHeight);
    GLES20.glUniform4f(this.mUniDistortionParam, paramFloat1, paramFloat2, paramFloat3, 0.0F);
    GLES20.glUniform2f(this.mUniDistortionCenter, paramFloat4, paramFloat5);
    processEnd(true, new int[] { 33984 });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.DistortionFilter
 * JD-Core Version:    0.7.0.1
 */