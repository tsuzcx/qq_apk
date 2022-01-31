package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoUtil;
import java.util.List;
import java.util.Map;

public class SimpleEffectVideoFilter
  extends VideoFilterBase
{
  public static final String LOOKUP_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n";
  public static final String LOOKUP_TABLE_FILE_NAME = "filterEffect.lut";
  public static final String LOOKUP_VERTEX_SHADER = "attribute vec4 position; \nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
  private String mDataPath;
  
  public SimpleEffectVideoFilter(String paramString)
  {
    super("attribute vec4 position; \nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}", "varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n", null);
    this.mDataPath = paramString;
    initParams();
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {}
    for (paramString = VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString), 2147483647, 2147483647);; paramString = VideoBitmapUtil.decodeSampledBitmapFromFile(paramString, 2147483647, 2147483647))
    {
      String str = paramString;
      if (!VideoBitmapUtil.isLegal(paramString)) {
        str = null;
      }
      return str;
    }
  }
  
  public void initParams()
  {
    addParam(new Param.TextureBitmapParam("inputImageTexture2", getBitmap(this.mDataPath + "/" + "filterEffect.lut"), 33986, true));
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.SimpleEffectVideoFilter
 * JD-Core Version:    0.7.0.1
 */