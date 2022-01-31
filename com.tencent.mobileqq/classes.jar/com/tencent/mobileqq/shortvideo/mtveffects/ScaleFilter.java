package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;

public class ScaleFilter
  extends BaseFragmentFilter
{
  public static final String SCALE_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!素材图片\nuniform vec2 inputImageTextureSize;//!窗口大小\nuniform vec2 scaleCenter;//!放大的中心点\nuniform float scaleRate; //!放大率 > 1 放大 ， < 1 缩小\n\n\n//!转换为纹理范围  \nvec2 toTexturePosition(vec2 v2Pos, vec2 v2Size)  \n{  \n    return vec2(float(v2Pos.x / v2Size.x), float(v2Pos.y / v2Size.y));  \n} \n\nvec4 scaleTransition(sampler2D s2DMaterial, vec2 v2Size, vec2 v2TextureCoord, vec2 v2Center, float fRate)\n{\t\n\tif (fRate != 1.0)\n\t{\n\t\tvec2 v2Tmp = v2TextureCoord;\n\t\tv2Tmp.x = (v2TextureCoord.x - v2Center.x) / fRate + v2Center.x;\n\t\tv2Tmp.y = (v2TextureCoord.y - v2Center.y) / fRate + v2Center.y;\n\t\t\n\t\t//!双线性插值\n\t\tv2Tmp = v2Tmp * v2Size;\n\t\tfloat _x = floor(v2Tmp.x);\n\t\tfloat _y = floor(v2Tmp.y);\n\t\tfloat u = v2Tmp.x - _x ;\n\t\tfloat v = v2Tmp.y - _y ;\n\t\t\n\t\tvec4 data_00 = texture2D(s2DMaterial, toTexturePosition(vec2(_x , _y), v2Size));\n\t\tvec4 data_01 = texture2D(s2DMaterial, toTexturePosition(vec2(_x, _y + 1.0), v2Size));\n\t\tvec4 data_10 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y), v2Size));\n\t\tvec4 data_11 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y + 1.0), v2Size));\n\t\treturn (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n\t}\n\telse\n\t{\n\t\treturn texture2D(s2DMaterial, v2TextureCoord);\n\t} \n}\n\nvoid main() \n{\n\tgl_FragColor = scaleTransition(inputImageTexture, inputImageTextureSize, vTextureCoord, scaleCenter, scaleRate);\n}\n";
  private static final String TAG = "ScaleFilter";
  private int mUniInputTexture = -1;
  private int mUniInputTextureSize = -1;
  private int mUniScaleCenter = -1;
  private int mUniScaleRate = -1;
  
  public ScaleFilter()
  {
    super("precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!素材图片\nuniform vec2 inputImageTextureSize;//!窗口大小\nuniform vec2 scaleCenter;//!放大的中心点\nuniform float scaleRate; //!放大率 > 1 放大 ， < 1 缩小\n\n\n//!转换为纹理范围  \nvec2 toTexturePosition(vec2 v2Pos, vec2 v2Size)  \n{  \n    return vec2(float(v2Pos.x / v2Size.x), float(v2Pos.y / v2Size.y));  \n} \n\nvec4 scaleTransition(sampler2D s2DMaterial, vec2 v2Size, vec2 v2TextureCoord, vec2 v2Center, float fRate)\n{\t\n\tif (fRate != 1.0)\n\t{\n\t\tvec2 v2Tmp = v2TextureCoord;\n\t\tv2Tmp.x = (v2TextureCoord.x - v2Center.x) / fRate + v2Center.x;\n\t\tv2Tmp.y = (v2TextureCoord.y - v2Center.y) / fRate + v2Center.y;\n\t\t\n\t\t//!双线性插值\n\t\tv2Tmp = v2Tmp * v2Size;\n\t\tfloat _x = floor(v2Tmp.x);\n\t\tfloat _y = floor(v2Tmp.y);\n\t\tfloat u = v2Tmp.x - _x ;\n\t\tfloat v = v2Tmp.y - _y ;\n\t\t\n\t\tvec4 data_00 = texture2D(s2DMaterial, toTexturePosition(vec2(_x , _y), v2Size));\n\t\tvec4 data_01 = texture2D(s2DMaterial, toTexturePosition(vec2(_x, _y + 1.0), v2Size));\n\t\tvec4 data_10 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y), v2Size));\n\t\tvec4 data_11 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y + 1.0), v2Size));\n\t\treturn (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n\t}\n\telse\n\t{\n\t\treturn texture2D(s2DMaterial, v2TextureCoord);\n\t} \n}\n\nvoid main() \n{\n\tgl_FragColor = scaleTransition(inputImageTexture, inputImageTextureSize, vTextureCoord, scaleCenter, scaleRate);\n}\n");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    int i = getProgram();
    if (i <= 0) {
      return;
    }
    this.mUniInputTexture = GLES20.glGetUniformLocation(i, "inputImageTexture");
    this.mUniInputTextureSize = GLES20.glGetUniformLocation(i, "inputImageTextureSize");
    this.mUniScaleCenter = GLES20.glGetUniformLocation(i, "scaleCenter");
    this.mUniScaleRate = GLES20.glGetUniformLocation(i, "scaleRate");
  }
  
  public boolean process(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramInt < 0) || (paramFloat3 == 1.0F)) {}
    while (!processBegin(paramArrayOfFloat1, paramArrayOfFloat2)) {
      return false;
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    GLES20.glUniform1i(this.mUniInputTexture, 0);
    GLES20.glUniform2f(this.mUniInputTextureSize, this.mOutputWidth, this.mOutputHeight);
    GLES20.glUniform2f(this.mUniScaleCenter, paramFloat1, paramFloat2);
    GLES20.glUniform1f(this.mUniScaleRate, paramFloat3);
    processEnd(false, new int[] { 33984 });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.ScaleFilter
 * JD-Core Version:    0.7.0.1
 */