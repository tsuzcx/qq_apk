package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.facebeauty.FaceParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ToothWhitenFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputMaskTexture;\nuniform sampler2D inputWhiteTeethLutTexture;\n\nuniform lowp float whiteTeeth;\nvoid main()\n{\n    lowp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec4 maskColor = texture2D(inputMaskTexture, textureCoordinate2);\n    lowp vec4 resultColor = color;\n    if(maskColor.a < 0.995)\n    {\n        mediump vec2 quad1;\n        mediump vec2 quad2;\n        mediump vec2 texPos1;\n        mediump vec2 texPos2;\n        mediump float blueColor = color.b * 63.0;\n        quad1.y = floor(floor(blueColor) / 8.0);\n        quad1.x = floor(blueColor) - (quad1.y * 8.0);\n        quad2.y = floor(ceil(blueColor)  / 8.0);\n        quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n        texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n        texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n        texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n        texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n        lowp vec3 newColor1 = texture2D(inputWhiteTeethLutTexture, texPos1).rgb;\n        lowp vec3 newColor2 = texture2D(inputWhiteTeethLutTexture, texPos2).rgb;\n        lowp vec3 newColor = mix(newColor1, newColor2, fract(blueColor));\n        resultColor = vec4(mix(color.rgb, newColor, whiteTeeth * (1.0 - maskColor.a)), 1.0);\n    }\n    gl_FragColor = resultColor;\n}\n";
  private static String LUT_FILE = "assets://luts/teethLUT.png";
  private static final String MASK_COORDS = "assets://mask/coords/toothwhite.tsv";
  private static String MASK_FILE = "assets://mask/images/toothmask.png";
  private static final String TAG = "ToothWhitenFilter";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = position.xy * 0.5 + 0.5;\n    textureCoordinate2 = inputTextureCoordinate.xy;\n}\n";
  private FaceParam faceParam;
  private float[] faceVertices = new float[1380];
  private Bitmap inputWhiteBitmap;
  private Bitmap maskBitmap;
  private int maskHeight;
  private float[] maskTexCoords = new float[1380];
  private int maskWidth;
  private float whiteTeeth = 0.0F;
  
  public ToothWhitenFilter(FaceParam paramFaceParam)
  {
    super(BaseFilter.nativeDecrypt("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = position.xy * 0.5 + 0.5;\n    textureCoordinate2 = inputTextureCoordinate.xy;\n}\n"), BaseFilter.nativeDecrypt("varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputMaskTexture;\nuniform sampler2D inputWhiteTeethLutTexture;\n\nuniform lowp float whiteTeeth;\nvoid main()\n{\n    lowp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec4 maskColor = texture2D(inputMaskTexture, textureCoordinate2);\n    lowp vec4 resultColor = color;\n    if(maskColor.a < 0.995)\n    {\n        mediump vec2 quad1;\n        mediump vec2 quad2;\n        mediump vec2 texPos1;\n        mediump vec2 texPos2;\n        mediump float blueColor = color.b * 63.0;\n        quad1.y = floor(floor(blueColor) / 8.0);\n        quad1.x = floor(blueColor) - (quad1.y * 8.0);\n        quad2.y = floor(ceil(blueColor)  / 8.0);\n        quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n        texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n        texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n        texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n        texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n        lowp vec3 newColor1 = texture2D(inputWhiteTeethLutTexture, texPos1).rgb;\n        lowp vec3 newColor2 = texture2D(inputWhiteTeethLutTexture, texPos2).rgb;\n        lowp vec3 newColor = mix(newColor1, newColor2, fract(blueColor));\n        resultColor = vec4(mix(color.rgb, newColor, whiteTeeth * (1.0 - maskColor.a)), 1.0);\n    }\n    gl_FragColor = resultColor;\n}\n"));
    this.faceParam = paramFaceParam;
    initBitmaps();
    initParams();
  }
  
  private void initBitmaps()
  {
    this.maskBitmap = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(MASK_FILE), 2147483647, 2147483647);
    Bitmap localBitmap = this.maskBitmap;
    if (localBitmap != null)
    {
      this.maskWidth = localBitmap.getWidth();
      this.maskHeight = this.maskBitmap.getHeight();
    }
    this.inputWhiteBitmap = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(LUT_FILE), 2147483647, 2147483647);
  }
  
  private void initMaskCoords()
  {
    this.maskTexCoords = FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.loadTexCoords("assets://mask/coords/toothwhite.tsv"), 2.0F), this.maskWidth, this.maskHeight, this.maskTexCoords);
    addAttribParam("inputTextureCoordinate", this.maskTexCoords, true);
  }
  
  private void initPositions(FaceParam paramFaceParam)
  {
    if (paramFaceParam == null) {
      return;
    }
    int[][] arrayOfInt = paramFaceParam.mFaceOutline;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localArrayList.add(new PointF(arrayOfInt[i][0], arrayOfInt[i][1]));
      i += 1;
    }
    FaceDetectUtil.facePointf83to90(localArrayList);
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(localArrayList, 2.0F), paramFaceParam.width, paramFaceParam.height, this.faceVertices));
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    BitmapUtils.recycle(this.maskBitmap);
    BitmapUtils.recycle(this.inputWhiteBitmap);
    LogUtils.d(TAG, "[clearGLSLSelf] delete texture, recycle bmp");
  }
  
  public void initAttribParams()
  {
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
    setRenderMode(2);
    initMaskCoords();
    initPositions(this.faceParam);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.FloatParam("whiteTeeth", this.whiteTeeth));
    addParam(new UniformParam.TextureBitmapParam("inputMaskTexture", this.maskBitmap, 33986, true));
    addParam(new UniformParam.TextureBitmapParam("inputWhiteTeethLutTexture", this.inputWhiteBitmap, 33987, true));
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("whiteTeeth")) {
      this.whiteTeeth = ((Float)paramMap.get("whiteTeeth")).floatValue();
    }
    this.whiteTeeth /= 200.0F;
    addParam(new UniformParam.FloatParam("whiteTeeth", this.whiteTeeth));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.ToothWhitenFilter
 * JD-Core Version:    0.7.0.1
 */