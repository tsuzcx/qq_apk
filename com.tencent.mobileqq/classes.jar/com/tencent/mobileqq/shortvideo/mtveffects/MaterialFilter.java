package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;

public class MaterialFilter
  extends BaseFragmentFilter
{
  public static final String BOTTOM_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!素材图片\nuniform vec2 inputImageTextureSize;\nuniform vec4 srcRect; //!素材图片的纹理位置 0-1坐标系\nuniform vec4 dstRect; //!素材图片的目标位置 0-1 坐标系 \nuniform vec4 dstColor; //!素材图片颜色替换 x 是否启用 y z w 颜色值 alpha不改变\n\n \n//!点是否在矩形区域内 v4Rect符合Rect的结构标准(top 比 bottom 要大)\nbool isPointInRect(vec2 v2Point, vec4 v4Rect)\n{\n\tif (v2Point.x >= v4Rect.x && v2Point.x <= v4Rect.z && v2Point.y <= v4Rect.y && v2Point.y >= v4Rect.w)\n\t{\n\t\treturn true;\n\t}\n\telse\n\t{\n\t    return false;\n\t}\n}\n//!转换为纹理范围  \nvec2 toTexturePosition(vec2 v2Pos, vec2 v2Size)  \n{  \n    return vec2(float(v2Pos.x / v2Size.x), float(v2Pos.y / v2Size.y));  \n} \n//!获得颜色值 颜色是marterial的v4src部分 绘制到 v4dst后 v2DstCoord处的颜色值 \nvec4 getMaterialColor(sampler2D s2DMaterial, vec4 v4Src, vec4 v4Dst, vec2 v2DstCoord, vec2 materialSize)\n{\n\tvec4 v4Color = vec4(0.0, 0.0, 0.0, 0.0);\n\tif (!isPointInRect(v2DstCoord, v4Dst))\n\t{\n\t\treturn v4Color;\n\t}\n\t\n\tvec2 v2Tmp = v2DstCoord - vec2(v4Dst.x, v4Dst.w);\n\tv2Tmp = v2Tmp / vec2(v4Dst.z - v4Dst.x, v4Dst.y - v4Dst.w);\n\tv2Tmp = v2Tmp * vec2(v4Src.z - v4Src.x, v4Src.y - v4Src.w);\n\tv2Tmp = v2Tmp + vec2(v4Src.x, v4Src.w);\n\t//return texture2D(s2DMaterial, v2Tmp);\n\t//!双线性插值\n\tv2Tmp = v2Tmp * materialSize;\n\tfloat _x = floor(v2Tmp.x);\n\tfloat _y = floor(v2Tmp.y);\n\tfloat u = v2Tmp.x - _x ;\n\tfloat v = v2Tmp.y - _y ;\n\t\n\tvec4 data_00 = texture2D(s2DMaterial, toTexturePosition(vec2(_x , _y), materialSize));\n\tvec4 data_01 = texture2D(s2DMaterial, toTexturePosition(vec2(_x, _y + 1.0), materialSize));\n\tvec4 data_10 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y), materialSize));\n\tvec4 data_11 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y + 1.0), materialSize));\n\treturn (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\n\n\nvoid main() \n{\n\tvec4 v4DstColor = getMaterialColor(inputImageTexture, srcRect, dstRect, vTextureCoord, inputImageTextureSize);\n\tif (dstColor.x > 0.0 && v4DstColor.a > 0.0)\n\t{\n\t\t//!需要颜色替换\n\t\tgl_FragColor = vec4(dstColor.y, dstColor.z, dstColor.w, v4DstColor.a);\n\t}\n\telse\n\t{\n\t\tgl_FragColor = v4DstColor;\n\t}\n\t\n}";
  private static final String TAG = "MaterialFilter";
  private int mUniDstColor = -1;
  private int mUniDstRect = -1;
  private int mUniInputTexture = -1;
  private int mUniInputTextureSize = -1;
  private int mUniSrcRect = -1;
  
  public MaterialFilter()
  {
    super("precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!素材图片\nuniform vec2 inputImageTextureSize;\nuniform vec4 srcRect; //!素材图片的纹理位置 0-1坐标系\nuniform vec4 dstRect; //!素材图片的目标位置 0-1 坐标系 \nuniform vec4 dstColor; //!素材图片颜色替换 x 是否启用 y z w 颜色值 alpha不改变\n\n \n//!点是否在矩形区域内 v4Rect符合Rect的结构标准(top 比 bottom 要大)\nbool isPointInRect(vec2 v2Point, vec4 v4Rect)\n{\n\tif (v2Point.x >= v4Rect.x && v2Point.x <= v4Rect.z && v2Point.y <= v4Rect.y && v2Point.y >= v4Rect.w)\n\t{\n\t\treturn true;\n\t}\n\telse\n\t{\n\t    return false;\n\t}\n}\n//!转换为纹理范围  \nvec2 toTexturePosition(vec2 v2Pos, vec2 v2Size)  \n{  \n    return vec2(float(v2Pos.x / v2Size.x), float(v2Pos.y / v2Size.y));  \n} \n//!获得颜色值 颜色是marterial的v4src部分 绘制到 v4dst后 v2DstCoord处的颜色值 \nvec4 getMaterialColor(sampler2D s2DMaterial, vec4 v4Src, vec4 v4Dst, vec2 v2DstCoord, vec2 materialSize)\n{\n\tvec4 v4Color = vec4(0.0, 0.0, 0.0, 0.0);\n\tif (!isPointInRect(v2DstCoord, v4Dst))\n\t{\n\t\treturn v4Color;\n\t}\n\t\n\tvec2 v2Tmp = v2DstCoord - vec2(v4Dst.x, v4Dst.w);\n\tv2Tmp = v2Tmp / vec2(v4Dst.z - v4Dst.x, v4Dst.y - v4Dst.w);\n\tv2Tmp = v2Tmp * vec2(v4Src.z - v4Src.x, v4Src.y - v4Src.w);\n\tv2Tmp = v2Tmp + vec2(v4Src.x, v4Src.w);\n\t//return texture2D(s2DMaterial, v2Tmp);\n\t//!双线性插值\n\tv2Tmp = v2Tmp * materialSize;\n\tfloat _x = floor(v2Tmp.x);\n\tfloat _y = floor(v2Tmp.y);\n\tfloat u = v2Tmp.x - _x ;\n\tfloat v = v2Tmp.y - _y ;\n\t\n\tvec4 data_00 = texture2D(s2DMaterial, toTexturePosition(vec2(_x , _y), materialSize));\n\tvec4 data_01 = texture2D(s2DMaterial, toTexturePosition(vec2(_x, _y + 1.0), materialSize));\n\tvec4 data_10 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y), materialSize));\n\tvec4 data_11 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y + 1.0), materialSize));\n\treturn (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\n\n\nvoid main() \n{\n\tvec4 v4DstColor = getMaterialColor(inputImageTexture, srcRect, dstRect, vTextureCoord, inputImageTextureSize);\n\tif (dstColor.x > 0.0 && v4DstColor.a > 0.0)\n\t{\n\t\t//!需要颜色替换\n\t\tgl_FragColor = vec4(dstColor.y, dstColor.z, dstColor.w, v4DstColor.a);\n\t}\n\telse\n\t{\n\t\tgl_FragColor = v4DstColor;\n\t}\n\t\n}");
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
    this.mUniDstRect = GLES20.glGetUniformLocation(i, "dstRect");
    this.mUniSrcRect = GLES20.glGetUniformLocation(i, "srcRect");
    this.mUniDstColor = GLES20.glGetUniformLocation(i, "dstColor");
  }
  
  public boolean process(int paramInt1, RectF paramRectF1, RectF paramRectF2, boolean paramBoolean, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 < 0) {
      return false;
    }
    if (!processBegin(paramArrayOfFloat1, paramArrayOfFloat2)) {
      return false;
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt1);
    GLES20.glUniform1i(this.mUniInputTexture, 0);
    GLES20.glUniform2f(this.mUniInputTextureSize, this.mOutputWidth, this.mOutputHeight);
    GLES20.glUniform4f(this.mUniDstRect, paramRectF2.left, paramRectF2.top, paramRectF2.right, paramRectF2.bottom);
    GLES20.glUniform4f(this.mUniSrcRect, paramRectF1.left, paramRectF1.top, paramRectF1.right, paramRectF1.bottom);
    if (paramBoolean) {
      GLES20.glUniform4f(this.mUniDstColor, 1.0F, LayerRenderBase.getRed(paramInt2), LayerRenderBase.getGreen(paramInt2), LayerRenderBase.getBlue(paramInt2));
    } else {
      GLES20.glUniform4f(this.mUniDstColor, 0.0F, 0.0F, 0.0F, 0.0F);
    }
    processEnd(true, new int[] { 33984 });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.MaterialFilter
 * JD-Core Version:    0.7.0.1
 */