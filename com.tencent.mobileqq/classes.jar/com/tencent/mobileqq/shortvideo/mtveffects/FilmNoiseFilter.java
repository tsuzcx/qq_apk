package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import java.util.ArrayList;

public class FilmNoiseFilter
  extends BaseFragmentFilter
{
  public static final int MAX_NOISE_COUNT = 4;
  public static final String NOISE_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!素材图片\nuniform vec2 noiseSize;//!噪点大小\nuniform vec4 noise1; //!x 绘制长度 y 起始位置 z 目标x w 目标y\nuniform vec4 noise2; //!x 绘制长度 y 起始位置 z 目标x w 目标y\nuniform vec4 noise3; //!x 绘制长度 y 起始位置 z 目标x w 目标y\nuniform vec4 noise4; //!x 绘制长度 y 起始位置 z 目标x w 目标y\n\n \n//!点是否在矩形区域内 v4Rect符合Rect的结构标准(top 比 bottom 要大)\nbool isPointInRect(vec2 v2Point, vec4 v4Rect)\n{\n\tif (v2Point.x >= v4Rect.x && v2Point.x <= v4Rect.z && v2Point.y <= v4Rect.y && v2Point.y >= v4Rect.w)\n\t{\n\t\treturn true;\n\t}\n\telse\n\t{\n\t    return false;\n\t}\n}\n//!转换为纹理范围  \nvec2 toTexturePosition(vec2 v2Pos, vec2 v2Size)  \n{  \n    return vec2(float(v2Pos.x / v2Size.x), float(v2Pos.y / v2Size.y));  \n} \n//!获得颜色值 颜色是marterial的v4src部分 绘制到 v4dst后 v2DstCoord处的颜色值 \nvec4 getMaterialColor(sampler2D s2DMaterial, vec4 v4Src, vec4 v4Dst, vec2 v2DstCoord)\n{\t\n\tvec2 v2Tmp = v2DstCoord - vec2(v4Dst.x, v4Dst.w);\n\tv2Tmp = v2Tmp / vec2(v4Dst.z - v4Dst.x, v4Dst.y - v4Dst.w);\n\tv2Tmp = v2Tmp * vec2(v4Src.z - v4Src.x, v4Src.y - v4Src.w);\n\tv2Tmp = v2Tmp + vec2(v4Src.x, v4Src.w);\n\treturn texture2D(s2DMaterial, v2Tmp);\n\t//!双线性插值\n\t/*v2Tmp = v2Tmp * materialSize;\n\tfloat _x = floor(v2Tmp.x);\n\tfloat _y = floor(v2Tmp.y);\n\tfloat u = v2Tmp.x - _x ;\n\tfloat v = v2Tmp.y - _y ;\n\t\n\tvec4 data_00 = texture2D(s2DMaterial, toTexturePosition(vec2(_x , _y), materialSize));\n\tvec4 data_01 = texture2D(s2DMaterial, toTexturePosition(vec2(_x, _y + 1.0), materialSize));\n\tvec4 data_10 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y), materialSize));\n\tvec4 data_11 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y + 1.0), materialSize));\n\treturn (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;*/\n}\n\nbool noiseColor(sampler2D s2DMaterial, out vec4 v4OutColor, vec2 v2TexCoord, float fSrcX, float fLength, float fDstX, float fDstY, float fWidth, float fHeight)\n{\n\tif (!isPointInRect(v2TexCoord, vec4(fDstX, fDstY, fDstX + fWidth, fDstY - fHeight)))\n\t{\n\t\treturn false;\n\t}\n\t\n\tv4OutColor = getMaterialColor(s2DMaterial, vec4(fSrcX, 1, fSrcX + fLength, 0), vec4(fDstX, fDstY, fDstX + fWidth, fDstY - fHeight), v2TexCoord);\n\treturn true;\n}\n\nvoid main() \n{\n\tvec4 v4Color = vec4(0.0, 0.0, 0.0, 0.0);\n\tbool bRet = false;\n\t\n\tif (noise1.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise1.y, noise1.x, noise1.z, noise1.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\tif (noise2.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise2.y, noise2.x, noise2.z, noise2.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\tif (noise3.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise3.y, noise3.x, noise3.z, noise3.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\tif (noise4.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise4.y, noise4.x, noise4.z, noise4.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\t\n\tgl_FragColor = v4Color;\n}\n\n";
  private static final String TAG = "FilmFilter";
  private ArrayList<FilmFilter.NoiseItem> mListItems;
  private int mUniInputTexture = -1;
  private int mUniNoise1 = -1;
  private int mUniNoise2 = -1;
  private int mUniNoise3 = -1;
  private int mUniNoise4 = -1;
  private int mUniNoiseSize = -1;
  
  public FilmNoiseFilter()
  {
    super("precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!素材图片\nuniform vec2 noiseSize;//!噪点大小\nuniform vec4 noise1; //!x 绘制长度 y 起始位置 z 目标x w 目标y\nuniform vec4 noise2; //!x 绘制长度 y 起始位置 z 目标x w 目标y\nuniform vec4 noise3; //!x 绘制长度 y 起始位置 z 目标x w 目标y\nuniform vec4 noise4; //!x 绘制长度 y 起始位置 z 目标x w 目标y\n\n \n//!点是否在矩形区域内 v4Rect符合Rect的结构标准(top 比 bottom 要大)\nbool isPointInRect(vec2 v2Point, vec4 v4Rect)\n{\n\tif (v2Point.x >= v4Rect.x && v2Point.x <= v4Rect.z && v2Point.y <= v4Rect.y && v2Point.y >= v4Rect.w)\n\t{\n\t\treturn true;\n\t}\n\telse\n\t{\n\t    return false;\n\t}\n}\n//!转换为纹理范围  \nvec2 toTexturePosition(vec2 v2Pos, vec2 v2Size)  \n{  \n    return vec2(float(v2Pos.x / v2Size.x), float(v2Pos.y / v2Size.y));  \n} \n//!获得颜色值 颜色是marterial的v4src部分 绘制到 v4dst后 v2DstCoord处的颜色值 \nvec4 getMaterialColor(sampler2D s2DMaterial, vec4 v4Src, vec4 v4Dst, vec2 v2DstCoord)\n{\t\n\tvec2 v2Tmp = v2DstCoord - vec2(v4Dst.x, v4Dst.w);\n\tv2Tmp = v2Tmp / vec2(v4Dst.z - v4Dst.x, v4Dst.y - v4Dst.w);\n\tv2Tmp = v2Tmp * vec2(v4Src.z - v4Src.x, v4Src.y - v4Src.w);\n\tv2Tmp = v2Tmp + vec2(v4Src.x, v4Src.w);\n\treturn texture2D(s2DMaterial, v2Tmp);\n\t//!双线性插值\n\t/*v2Tmp = v2Tmp * materialSize;\n\tfloat _x = floor(v2Tmp.x);\n\tfloat _y = floor(v2Tmp.y);\n\tfloat u = v2Tmp.x - _x ;\n\tfloat v = v2Tmp.y - _y ;\n\t\n\tvec4 data_00 = texture2D(s2DMaterial, toTexturePosition(vec2(_x , _y), materialSize));\n\tvec4 data_01 = texture2D(s2DMaterial, toTexturePosition(vec2(_x, _y + 1.0), materialSize));\n\tvec4 data_10 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y), materialSize));\n\tvec4 data_11 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y + 1.0), materialSize));\n\treturn (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;*/\n}\n\nbool noiseColor(sampler2D s2DMaterial, out vec4 v4OutColor, vec2 v2TexCoord, float fSrcX, float fLength, float fDstX, float fDstY, float fWidth, float fHeight)\n{\n\tif (!isPointInRect(v2TexCoord, vec4(fDstX, fDstY, fDstX + fWidth, fDstY - fHeight)))\n\t{\n\t\treturn false;\n\t}\n\t\n\tv4OutColor = getMaterialColor(s2DMaterial, vec4(fSrcX, 1, fSrcX + fLength, 0), vec4(fDstX, fDstY, fDstX + fWidth, fDstY - fHeight), v2TexCoord);\n\treturn true;\n}\n\nvoid main() \n{\n\tvec4 v4Color = vec4(0.0, 0.0, 0.0, 0.0);\n\tbool bRet = false;\n\t\n\tif (noise1.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise1.y, noise1.x, noise1.z, noise1.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\tif (noise2.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise2.y, noise2.x, noise2.z, noise2.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\tif (noise3.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise3.y, noise3.x, noise3.z, noise3.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\tif (noise4.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise4.y, noise4.x, noise4.z, noise4.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\t\n\tgl_FragColor = v4Color;\n}\n\n");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mListItems = null;
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    int i = getProgram();
    if (i <= 0) {
      return;
    }
    this.mUniInputTexture = GLES20.glGetUniformLocation(i, "inputImageTexture");
    this.mUniNoiseSize = GLES20.glGetUniformLocation(i, "noiseSize");
    this.mUniNoise1 = GLES20.glGetUniformLocation(i, "noise1");
    this.mUniNoise2 = GLES20.glGetUniformLocation(i, "noise2");
    this.mUniNoise3 = GLES20.glGetUniformLocation(i, "noise3");
    this.mUniNoise4 = GLES20.glGetUniformLocation(i, "noise4");
  }
  
  public boolean process(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramInt < 0) || (this.mListItems == null) || (this.mListItems.size() == 0)) {}
    while (!processBegin(paramArrayOfFloat1, paramArrayOfFloat2)) {
      return false;
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    GLES20.glUniform1i(this.mUniInputTexture, 0);
    float f1 = ((FilmFilter.NoiseItem)this.mListItems.get(0)).mDstRect.width();
    float f2 = Math.abs(((FilmFilter.NoiseItem)this.mListItems.get(0)).mDstRect.height());
    GLES20.glUniform2f(this.mUniNoiseSize, f1, f2);
    paramInt = 0;
    if (paramInt < this.mListItems.size())
    {
      paramArrayOfFloat1 = (FilmFilter.NoiseItem)this.mListItems.get(paramInt);
      if (paramInt == 0) {
        GLES20.glUniform4f(this.mUniNoise1, paramArrayOfFloat1.mSrcLength, paramArrayOfFloat1.mSrcX, paramArrayOfFloat1.mDstRect.left, paramArrayOfFloat1.mDstRect.top);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (paramInt == 1) {
          GLES20.glUniform4f(this.mUniNoise2, paramArrayOfFloat1.mSrcLength, paramArrayOfFloat1.mSrcX, paramArrayOfFloat1.mDstRect.left, paramArrayOfFloat1.mDstRect.top);
        } else if (paramInt == 2) {
          GLES20.glUniform4f(this.mUniNoise3, paramArrayOfFloat1.mSrcLength, paramArrayOfFloat1.mSrcX, paramArrayOfFloat1.mDstRect.left, paramArrayOfFloat1.mDstRect.top);
        } else if (paramInt == 3) {
          GLES20.glUniform4f(this.mUniNoise4, paramArrayOfFloat1.mSrcLength, paramArrayOfFloat1.mSrcX, paramArrayOfFloat1.mDstRect.left, paramArrayOfFloat1.mDstRect.top);
        }
      }
    }
    processEnd(true, new int[] { 33984 });
    return true;
  }
  
  public void updateData(ArrayList<FilmFilter.NoiseItem> paramArrayList)
  {
    this.mListItems = paramArrayList;
    if ((this.mListItems != null) && (this.mListItems.size() < 4))
    {
      int j = this.mListItems.size();
      int i = 0;
      while (i < 4 - j)
      {
        this.mListItems.add(new FilmFilter.NoiseItem());
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.FilmNoiseFilter
 * JD-Core Version:    0.7.0.1
 */