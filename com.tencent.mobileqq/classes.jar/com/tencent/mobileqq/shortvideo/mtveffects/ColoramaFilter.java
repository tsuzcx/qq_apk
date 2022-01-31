package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;

public class ColoramaFilter
  extends BaseFragmentFilter
{
  public static final String COLORAMA_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!视频图片\nuniform sampler2D inputImageTexture2;//!素材图片\nuniform vec4 paletteRect; //!调色板位置\nuniform vec4 coloramaParam;//!色光参数 ： 起始位置（起始相位） 长度 循环次数\n\nvec4 toGrayValue(vec4 v4Src)\n{\n\tfloat fGray = 0.299 * v4Src.r + 0.587 * v4Src.g + 0.114 * v4Src.b;\n\t\n\treturn vec4(fGray, fGray, fGray, v4Src.a);\n}\n\nvoid main() \n{\n\tvec4 v4Gray = toGrayValue(texture2D(inputImageTexture, vTextureCoord));\n\t//!起始位置 去中间值\n\tvec2 v2Pos = vec2(paletteRect.x, (paletteRect.y + paletteRect.w) / 2.0);\n\tfloat fTmp = v4Gray.r * coloramaParam.y * coloramaParam.z;\n\t\n\tfTmp = mod(fTmp, coloramaParam.y);\n\tif (fTmp == 0.0)\n\t{\n\t\t//!边界\n\t\tif (v2Pos.x > 0.5 * coloramaParam.y)\n\t\t{\t\n\t\t\tv2Pos.x = coloramaParam.y;\n\t\t}else\n\t\t{\n\t\t\tv2Pos.x = 0.0;\n\t\t}\n\t}\n\telse\n\t{\n\t\tv2Pos.x = fTmp;\n\t}\n\n\tv2Pos.x = v2Pos.x + coloramaParam.x;\n\t\n\tvec4 v4PaletteColor = texture2D(inputImageTexture2, v2Pos);\n\tv4PaletteColor.a = v4Gray.a;\n\tgl_FragColor = v4PaletteColor;\n}\n\n";
  private static final String TAG = "ColoramaFilter";
  private int mUniInputTexture = -1;
  private int mUniInputTexture2 = -1;
  private int mUniPaletteRect = -1;
  private int mUniParam = -1;
  
  public ColoramaFilter()
  {
    super("precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!视频图片\nuniform sampler2D inputImageTexture2;//!素材图片\nuniform vec4 paletteRect; //!调色板位置\nuniform vec4 coloramaParam;//!色光参数 ： 起始位置（起始相位） 长度 循环次数\n\nvec4 toGrayValue(vec4 v4Src)\n{\n\tfloat fGray = 0.299 * v4Src.r + 0.587 * v4Src.g + 0.114 * v4Src.b;\n\t\n\treturn vec4(fGray, fGray, fGray, v4Src.a);\n}\n\nvoid main() \n{\n\tvec4 v4Gray = toGrayValue(texture2D(inputImageTexture, vTextureCoord));\n\t//!起始位置 去中间值\n\tvec2 v2Pos = vec2(paletteRect.x, (paletteRect.y + paletteRect.w) / 2.0);\n\tfloat fTmp = v4Gray.r * coloramaParam.y * coloramaParam.z;\n\t\n\tfTmp = mod(fTmp, coloramaParam.y);\n\tif (fTmp == 0.0)\n\t{\n\t\t//!边界\n\t\tif (v2Pos.x > 0.5 * coloramaParam.y)\n\t\t{\t\n\t\t\tv2Pos.x = coloramaParam.y;\n\t\t}else\n\t\t{\n\t\t\tv2Pos.x = 0.0;\n\t\t}\n\t}\n\telse\n\t{\n\t\tv2Pos.x = fTmp;\n\t}\n\n\tv2Pos.x = v2Pos.x + coloramaParam.x;\n\t\n\tvec4 v4PaletteColor = texture2D(inputImageTexture2, v2Pos);\n\tv4PaletteColor.a = v4Gray.a;\n\tgl_FragColor = v4PaletteColor;\n}\n\n");
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    int i = getProgram();
    if (i <= 0) {
      return;
    }
    this.mUniInputTexture = GLES20.glGetUniformLocation(i, "inputImageTexture");
    this.mUniInputTexture2 = GLES20.glGetUniformLocation(i, "inputImageTexture2");
    this.mUniPaletteRect = GLES20.glGetUniformLocation(i, "paletteRect");
    this.mUniParam = GLES20.glGetUniformLocation(i, "coloramaParam");
  }
  
  public boolean process(int paramInt1, int paramInt2, RectF paramRectF, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramRectF == null)) {}
    while (!processBegin(paramArrayOfFloat1, paramArrayOfFloat2)) {
      return false;
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt1);
    GLES20.glUniform1i(this.mUniInputTexture, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(this.mTextureType, paramInt2);
    GLES20.glUniform1i(this.mUniInputTexture2, 1);
    GLES20.glUniform4f(this.mUniPaletteRect, paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
    GLES20.glUniform4f(this.mUniParam, paramFloat1, paramFloat2, paramFloat3, 0.0F);
    processEnd(false, new int[] { 33984, 33985 });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.ColoramaFilter
 * JD-Core Version:    0.7.0.1
 */