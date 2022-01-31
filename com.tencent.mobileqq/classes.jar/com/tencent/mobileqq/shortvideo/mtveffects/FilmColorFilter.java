package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;

public class FilmColorFilter
  extends BaseFragmentFilter
{
  public static final String FILM_FRAGMENT_SHADER = "precision highp float;\n\nvarying highp vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\n\nuniform float  u_time;\n\nconst float intensity = 0.06;\n\n// 杂点函数\nfloat randColorFun(vec2 co)\n{\n   return fract(sin(dot(co.xy, vec2(12.9898,78.233))) * 43758.5453);\n}\n\nvec2 getRandCoordinate( vec2 vTextureCoord)\n{\n   vec2 uv = vTextureCoord.xy;\n   float waveu = sin((uv.y + u_time/150.0) * 20.0) * 0.009;\n   return uv + vec2(waveu, 0);\n}\n\nvoid main()\n{\n   highp vec4 textureColor = texture2D(inputImageTexture, vTextureCoord);\n   highp vec2 randCoordinate = getRandCoordinate(vTextureCoord);\n   float randColor = randColorFun(randCoordinate)*intensity;\n    \n   // 全色图先处理下\n   float blueColor = textureColor.b * 63.0;\n   \n   highp vec2 quad1;\n   quad1.y = floor(floor(blueColor) / 8.0);\n   quad1.x = floor(blueColor) - (quad1.y * 8.0);\n   \n   highp vec2 quad2;\n   quad2.y = floor(ceil(blueColor) / 8.0);\n   quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n   \n   highp vec2 texPos1;\n   texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n   texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n   \n   highp vec2 texPos2;\n   texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n   texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n   \n   lowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n   lowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n   \n   lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    \n   // 单色杂点，统一加randColor\n   newColor.r = max(0.0, min(1.0, (newColor.r + randColor)));\n   newColor.g = max(0.0, min(1.0, (newColor.g + randColor)));\n   newColor.b = max(0.0, min(1.0, (newColor.b + randColor)));\n    \n   gl_FragColor = vec4(newColor.rgb, textureColor.w);\n   \n}";
  private static final String TAG = "FilmFilter";
  private int mUniInputTexture = -1;
  private int mUniInputTexture2 = -1;
  
  public FilmColorFilter()
  {
    super("precision highp float;\n\nvarying highp vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\n\nuniform float  u_time;\n\nconst float intensity = 0.06;\n\n// 杂点函数\nfloat randColorFun(vec2 co)\n{\n   return fract(sin(dot(co.xy, vec2(12.9898,78.233))) * 43758.5453);\n}\n\nvec2 getRandCoordinate( vec2 vTextureCoord)\n{\n   vec2 uv = vTextureCoord.xy;\n   float waveu = sin((uv.y + u_time/150.0) * 20.0) * 0.009;\n   return uv + vec2(waveu, 0);\n}\n\nvoid main()\n{\n   highp vec4 textureColor = texture2D(inputImageTexture, vTextureCoord);\n   highp vec2 randCoordinate = getRandCoordinate(vTextureCoord);\n   float randColor = randColorFun(randCoordinate)*intensity;\n    \n   // 全色图先处理下\n   float blueColor = textureColor.b * 63.0;\n   \n   highp vec2 quad1;\n   quad1.y = floor(floor(blueColor) / 8.0);\n   quad1.x = floor(blueColor) - (quad1.y * 8.0);\n   \n   highp vec2 quad2;\n   quad2.y = floor(ceil(blueColor) / 8.0);\n   quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n   \n   highp vec2 texPos1;\n   texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n   texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n   \n   highp vec2 texPos2;\n   texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n   texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n   \n   lowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n   lowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n   \n   lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    \n   // 单色杂点，统一加randColor\n   newColor.r = max(0.0, min(1.0, (newColor.r + randColor)));\n   newColor.g = max(0.0, min(1.0, (newColor.g + randColor)));\n   newColor.b = max(0.0, min(1.0, (newColor.b + randColor)));\n    \n   gl_FragColor = vec4(newColor.rgb, textureColor.w);\n   \n}");
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
  }
  
  public boolean process(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    while (!processBegin(paramArrayOfFloat1, paramArrayOfFloat2)) {
      return false;
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt1);
    GLES20.glUniform1i(this.mUniInputTexture, 0);
    if (paramInt2 >= 0)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(this.mTextureType, paramInt2);
      GLES20.glUniform1i(this.mUniInputTexture2, 1);
    }
    if (paramInt2 >= 0) {
      processEnd(false, new int[] { 33984, 33985 });
    }
    for (;;)
    {
      return true;
      processEnd(false, new int[] { 33984 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.FilmColorFilter
 * JD-Core Version:    0.7.0.1
 */