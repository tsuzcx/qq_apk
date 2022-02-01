package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;

public class ShapeFilter
  extends BaseFragmentFilter
{
  private static final String SHAPE_FRAGMENT_SHADER = "precision highp float;\n\nvarying highp vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;\nuniform sampler2D maskTexture;\n\nvoid main() {\n    if(all(equal(texture2D(maskTexture, vTextureCoord), vec4(0,0,0,0))))\n    {\n       gl_FragColor = vec4(0,0,0,0);\n    }\n    else{\n       gl_FragColor = texture2D(inputImageTexture, vTextureCoord);\n   }\n}\n";
  private static final String TAG = "ShapeFilter";
  private int mUniInputTexture = -1;
  private int mUniMaskTexture = -1;
  
  public ShapeFilter()
  {
    super("precision highp float;\n\nvarying highp vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;\nuniform sampler2D maskTexture;\n\nvoid main() {\n    if(all(equal(texture2D(maskTexture, vTextureCoord), vec4(0,0,0,0))))\n    {\n       gl_FragColor = vec4(0,0,0,0);\n    }\n    else{\n       gl_FragColor = texture2D(inputImageTexture, vTextureCoord);\n   }\n}\n");
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    int i = getProgram();
    if (i <= 0) {
      return;
    }
    this.mUniInputTexture = GLES20.glGetUniformLocation(i, "inputImageTexture");
    this.mUniMaskTexture = GLES20.glGetUniformLocation(i, "maskTexture");
  }
  
  public boolean process(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 < 0) {}
    while (!processBegin(paramArrayOfFloat2, paramArrayOfFloat1)) {
      return false;
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt1);
    GLES20.glUniform1i(this.mUniInputTexture, 0);
    if (paramInt2 >= 0)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(this.mTextureType, paramInt2);
      GLES20.glUniform1i(this.mUniMaskTexture, 1);
    }
    if (paramInt2 >= 0) {
      processEnd(true, new int[] { 33984, 33985 });
    }
    for (;;)
    {
      return true;
      processEnd(true, new int[] { 33984 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.ShapeFilter
 * JD-Core Version:    0.7.0.1
 */