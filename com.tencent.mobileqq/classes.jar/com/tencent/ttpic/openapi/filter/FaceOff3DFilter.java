package com.tencent.ttpic.openapi.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import java.io.File;
import java.util.List;

public class FaceOff3DFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = "//Need Sync FaceOffFragmentShaderExt.dat\n\nprecision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying float pointVisValue;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\n\nuniform float alpha;\nuniform int enableFaceOff;\nuniform float enableAlphaFromGray;\nuniform float enableAlphaFromGrayNew;\nuniform int blendMode;\nuniform int blendIris;\nuniform float level1;\nuniform float level2;\nuniform float filterSkin;\n\nuniform vec2 size;\nuniform vec2 center1;\nuniform vec2 center2;\nuniform float radius1;\nuniform float radius2;\n\nuniform int leftEyeClosed; // deprecated\nuniform int rightEyeClosed; // deprecated\nuniform float leftEyeCloseAlpha;\nuniform float rightEyeCloseAlpha;\n\nvec3 blendColorWithMode(vec4 texColor, vec4 canvasColor, int colorBlendMode)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    vec3 resultFore = texColor.rgb;\n    if (colorBlendMode <= 1){ //default, since used most, put on top\n\n    } else if (colorBlendMode == 2) {  //multiply\n        resultFore = canvasColor.rgb * texColor.rgb;\n    } else if (colorBlendMode == 3){    //screen\n        resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n    } else if (colorBlendMode == 4){    //overlay\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (canvasColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (canvasColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (canvasColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 5){    //hardlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (texColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 6){    //softlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n        if (texColor.r >= 0.5) {\n            resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n        }\n    } else if (colorBlendMode == 7){    //divide\n        resultFore = vOne;\n        if (texColor.r > 0.0) {\n            resultFore.r = canvasColor.r / texColor.r;\n        }\n        if (texColor.g > 0.0) {\n            resultFore.g = canvasColor.g / texColor.g;\n        }\n        if (texColor.b > 0.0) {\n            resultFore.b = canvasColor.b / texColor.b;\n        }\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 8){    //add\n        resultFore = canvasColor.rgb + texColor.rgb;\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 9){    //substract\n        resultFore = canvasColor.rgb - texColor.rgb;\n        resultFore = max(vZero, resultFore);\n    } else if (colorBlendMode == 10){   //diff\n        resultFore = abs(canvasColor.rgb - texColor.rgb);\n    } else if (colorBlendMode == 11){   //darken\n        resultFore = min(canvasColor.rgb, texColor.rgb);\n    } else if (blendMode == 12){   //lighten\n        resultFore = max(canvasColor.rgb, texColor.rgb);\n    }\n    return resultFore;\n}\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor) {\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    if (blendMode <= 12) {\n        resultFore = blendColorWithMode(texColor, canvasColor, blendMode);\n    } else if (blendMode == 13){   //highlight for lips\n        if (texColor.a > 0.0001) {\n            if(canvasColor.r >= level1) {\n                texColor.rgb = vec3(1.0, 1.0, 1.0);\n                //if(canvasColor.r < 0.6) {\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05;\n                //}\n            } else if (canvasColor.r >= level2) {\n               if (level1 > level2) {\n                   float f = (canvasColor.r - level2) / (level1 - level2);\n                   texColor.rgb = texColor.rgb + (vOne - texColor.rgb) * f;\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05 * f;\n               }\n            }\n        }\n        resultFore = canvasColor.rgb * texColor.rgb;\n        resultFore = clamp(resultFore, 0.0001, 0.9999);\n    } else if (blendMode == 14){   // iris\n         vec2 curPos = vec2(canvasCoordinate.x * size.x, canvasCoordinate.y * size.y);\n         float dist1 = sqrt((curPos.x - center1.x) * (curPos.x - center1.x) + (curPos.y - center1.y) * (curPos.y - center1.y));\n         float dist2 = sqrt((curPos.x - center2.x) * (curPos.x - center2.x) + (curPos.y - center2.y) * (curPos.y - center2.y));\n         if (dist1 < radius1 && leftEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center1.x) / radius1 / 2.0;\n             float _y = (curPos.y - center1.y) / radius1 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * leftEyeCloseAlpha;\n         } else if (dist2 < radius2 && rightEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center2.x) / radius2 / 2.0;\n             float _y = (curPos.y - center2.y) / radius2 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * rightEyeCloseAlpha;\n         } else {\n            texColor.a = 0.0;\n         }\n         //resultFore = texColor.rgb;\n         //texColor.a = 1.0;\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n    return resultColor;\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 grayColor = texture2D(inputImageTexture3, grayTextureCoordinate);\n    vec4 maskColor = texture2D(inputImageTexture5, grayTextureCoordinate);\n\n    if (enableFaceOff == 1) {\n        if (texColor.a > 0.0) {\n            texColor = texColor / vec4(texColor.a, texColor.a, texColor.a, 1.0);\n        }\n        if(enableAlphaFromGray > 0.0){\n            float grayAlpha = (1.0 - mix(maskColor.r, grayColor.r, enableAlphaFromGrayNew));\n            texColor.a = texColor.a * grayAlpha * alpha;\n        } else {\n            texColor.a = texColor.a * alpha;\n        }\n    }\n\n    float confidence = smoothstep(0.7, 1.0, pointVisValue);\n\n    texColor.a = texColor.a * confidence;\n\n//    if(confidence >= 0.0){\n//            texColor.a = texColor.a * confidence;\n//    }\n\n    texColor.rgb = texColor.rgb * texColor.a;\n    float skin_p = clamp((canvasColor.r - 0.2) * 4.0, 0.0, 1.0);\n    texColor.a *= mix(1.0, skin_p, filterSkin);\n\n    gl_FragColor = blendColor(texColor, canvasColor);\n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputGrayTextureCoordinate;\nattribute float pointsVisValue;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying float pointVisValue;\n\nuniform vec2 canvasSize;\nuniform float positionRotate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    grayTextureCoordinate = inputGrayTextureCoordinate;\n    pointVisValue = pointsVisValue;\n}";
  private static final PointF ZERO_POINT = new PointF(0.0F, 0.0F);
  private Frame copyFrame = new Frame();
  private Face3DCosmeticFilter cosmetic3DFilter = new Face3DCosmeticFilter();
  private byte[] data = null;
  private PTDetectInfo detectInfo;
  private float[] face3dTexCoords = new float[1380];
  protected int faceImageHeight;
  protected int faceImageWidth;
  private float[] faceVertices = new float[1380];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private PointF irisCenterL = new PointF(0.0F, 0.0F);
  private PointF irisCenterR = new PointF(0.0F, 0.0F);
  private float irisRadiusL;
  private float irisRadiusR;
  private boolean isFaceImageReady;
  private boolean isGrayImageReady;
  private boolean isIrisImageReady;
  protected FaceItem item;
  private int lastIndex = -1;
  public float level1 = 0.0F;
  public float level2 = 0.0F;
  public int levelCount = 0;
  byte[] mData = null;
  float percent1 = 0.05F;
  float percent2 = 0.15F;
  float[] pointVis = new float[''];
  private float[] pointVisVertices = new float[1380];
  private boolean sequenceMode;
  public double sumg = 0.0D;
  public double sumr = 0.0D;
  private float[] texVertices = new float[1380];
  protected int[] texture = new int[4];
  private boolean triggered;
  
  public FaceOff3DFilter(FaceItem paramFaceItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.FACEOFF));
    this.item = paramFaceItem;
    this.cosmetic3DFilter.setCosParam(paramFaceItem);
    this.dataPath = paramString;
    this.sequenceMode = TextUtils.isEmpty(paramFaceItem.faceExchangeImage);
    initParams();
  }
  
  private float getAverageGreen(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    Object localObject = this.data;
    if (localObject != null)
    {
      if (localObject.length < paramInt2 * paramInt1 * 4) {
        return 0.0F;
      }
      int j = (int)(((PointF)paramList.get(66)).x - ((PointF)paramList.get(65)).x);
      int n = (int)(((PointF)paramList.get(69)).y - ((PointF)paramList.get(78)).y);
      int m = (int)((PointF)paramList.get(65)).x;
      int i = (int)((PointF)paramList.get(78)).y;
      if ((m < paramInt1) && (i < paramInt2) && (j > 0))
      {
        if (n <= 0) {
          return 0.0F;
        }
        int k = m;
        if (m < 0) {
          k = 0;
        }
        m = i;
        if (i < 0) {
          m = 0;
        }
        i = j;
        if (k + j > paramInt1) {
          i = paramInt1 - k;
        }
        j = n;
        if (m + n > paramInt2) {
          j = paramInt2 - m;
        }
        int i1 = i * j;
        paramList = new byte[i1 * 4];
        paramInt2 = 0;
        while (paramInt2 < j)
        {
          n = 0;
          while (n < i)
          {
            int i2 = (paramInt2 * i + n) * 4;
            int i3 = ((paramInt2 + m) * paramInt1 + n + k) * 4;
            localObject = this.data;
            paramList[i2] = localObject[i3];
            paramList[(i2 + 1)] = localObject[(i3 + 1)];
            paramList[(i2 + 2)] = localObject[(i3 + 2)];
            paramList[(i2 + 3)] = localObject[(i3 + 3)];
            n += 1;
          }
          paramInt2 += 1;
        }
        localObject = new int[256];
        this.sumg = 0.0D;
        this.sumr = 0.0D;
        paramInt1 = 0;
        for (;;)
        {
          paramInt2 = 255;
          if (paramInt1 >= j) {
            break;
          }
          paramInt2 = 0;
          while (paramInt2 < i)
          {
            m = (paramInt1 * i + paramInt2) * 4;
            k = paramList[m] & 0xFF;
            d1 = this.sumr;
            d2 = k;
            Double.isNaN(d2);
            this.sumr = (d1 + d2);
            m = paramList[(m + 1)];
            d1 = this.sumg;
            d2 = m & 0xFF;
            Double.isNaN(d2);
            this.sumg = (d1 + d2);
            localObject[k] += 1;
            paramInt2 += 1;
          }
          paramInt1 += 1;
        }
        double d2 = this.sumg;
        double d1 = i1;
        Double.isNaN(d1);
        this.sumg = (d2 / d1);
        d2 = this.sumr;
        Double.isNaN(d1);
        this.sumr = (d2 / d1);
        this.levelCount = 0;
        paramInt1 = 255;
        while (paramInt1 >= 0)
        {
          this.levelCount += localObject[paramInt1];
          if (this.levelCount >= i1 * this.percent1)
          {
            this.level1 = paramInt1;
            break;
          }
          paramInt1 -= 1;
        }
        this.levelCount = 0;
        paramInt1 = paramInt2;
        while (paramInt1 >= 0)
        {
          this.levelCount += localObject[paramInt1];
          if (this.levelCount >= i1 * this.percent2)
          {
            this.level2 = paramInt1;
            break;
          }
          paramInt1 -= 1;
        }
        return (float)this.sumr;
      }
    }
    return 0.0F;
  }
  
  private boolean initGrayImage()
  {
    if (this.isGrayImageReady) {
      return true;
    }
    Object localObject2 = VideoMemoryManager.getInstance().loadImage(this.item.featureType);
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(FaceOffUtil.FeatureType.MASK);
    Object localObject1 = localObject2;
    if (!BitmapUtils.isLegal((Bitmap)localObject2))
    {
      localObject1 = localObject2;
      if (VideoMemoryManager.getInstance().isForceLoadFromSdCard()) {
        localObject1 = FaceOffUtil.getGrayBitmap(this.item.featureType);
      }
    }
    localObject2 = localBitmap;
    if (!BitmapUtils.isLegal(localBitmap))
    {
      localObject2 = localBitmap;
      if (VideoMemoryManager.getInstance().isForceLoadFromSdCard()) {
        localObject2 = FaceOffUtil.getGrayBitmap(FaceOffUtil.FeatureType.MASK);
      }
    }
    int i = VideoMemoryManager.getInstance().getSampleSize();
    if ((BitmapUtils.isLegal((Bitmap)localObject1)) && (BitmapUtils.isLegal((Bitmap)localObject2)))
    {
      GlUtil.loadTexture(this.texture[1], (Bitmap)localObject1);
      this.grayImageWidth = (((Bitmap)localObject1).getWidth() * i);
      this.grayImageHeight = (((Bitmap)localObject1).getHeight() * i);
      initGrayTexCoords();
      addParam(new UniformParam.TextureParam("inputImageTexture3", this.texture[1], 33987));
      GlUtil.loadTexture(this.texture[3], (Bitmap)localObject2);
      addParam(new UniformParam.TextureParam("inputImageTexture5", this.texture[3], 33989));
      this.isGrayImageReady = true;
    }
    return this.isGrayImageReady;
  }
  
  private void initGrayTexCoords()
  {
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoordsForFaceOffFilter(FaceOffUtil.getGrayCoords(this.item.featureType), 5.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
  }
  
  private boolean initIrisImage()
  {
    if (this.isIrisImageReady) {
      return true;
    }
    Object localObject2 = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.irisImage);
    Object localObject1 = localObject2;
    if (!BitmapUtils.isLegal((Bitmap)localObject2))
    {
      localObject1 = localObject2;
      if (VideoMemoryManager.getInstance().isForceLoadFromSdCard())
      {
        localObject1 = AEModule.getContext();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.dataPath);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(this.item.irisImage);
        localObject1 = BitmapUtils.decodeSampleBitmap((Context)localObject1, ((StringBuilder)localObject2).toString(), 1);
      }
    }
    if (BitmapUtils.isLegal((Bitmap)localObject1))
    {
      GlUtil.loadTexture(this.texture[2], (Bitmap)localObject1);
      addParam(new UniformParam.TextureParam("inputImageTexture4", this.texture[2], 33988));
      this.isIrisImageReady = true;
    }
    return this.isIrisImageReady;
  }
  
  private void update3DFaceImage(int paramInt)
  {
    PTDetectInfo localPTDetectInfo = this.detectInfo;
    if (localPTDetectInfo != null)
    {
      if (localPTDetectInfo.face3DVerticesArray == null) {
        return;
      }
      if (!AlgoUtils.isFace3DPointsValid(this.detectInfo.face3DVerticesArray)) {
        return;
      }
      boolean bool = GlUtil.curBlendModeEnabled;
      GlUtil.setBlendMode(false);
      this.cosmetic3DFilter.updatePreview(this.detectInfo);
      this.cosmetic3DFilter.RenderProcess(paramInt, this.width, this.height, -1, 0.0D, this.copyFrame);
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.copyFrame.getTextureId(), 33986));
      GlUtil.setBlendMode(bool);
    }
  }
  
  private void update3DPointParams()
  {
    Object localObject = this.detectInfo;
    if (localObject != null)
    {
      if (((PTDetectInfo)localObject).face3DVerticesArray == null) {
        return;
      }
      if (!AlgoUtils.isFace3DPointsValid(this.detectInfo.face3DVerticesArray)) {
        return;
      }
      localObject = FaceOffUtil.getFullCoordsForFaceOffFilter(VideoMaterial.copyList(this.detectInfo.facePoints), 5.0F);
      double d1 = this.width;
      double d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      int i = (int)(d1 * d2);
      d1 = this.height;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      FaceOffUtil.initMaterialFaceTexCoords((List)localObject, i, (int)(d1 * d2), this.face3dTexCoords);
      addAttribParam(new AttributeParam("inputTextureCoordinate", this.face3dTexCoords, 2));
    }
  }
  
  private void updateMouthOpenFactor(List<PointF> paramList)
  {
    if (this.item.grayScale == 2)
    {
      float f3 = AlgoUtils.getDistance((PointF)paramList.get(65), (PointF)paramList.get(66));
      float f2 = AlgoUtils.getDistance((PointF)paramList.get(73), (PointF)paramList.get(81));
      float f1 = 0.0F;
      if (f3 > 0.0F)
      {
        f1 = f3 * 0.1F;
        f1 = Math.max(0.0F, Math.min(1.0F, (f2 - f1) / f1));
      }
      addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", Math.min(1.0F, f1 + 0.002F)));
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    this.cosmetic3DFilter.ApplyGLSLFilter();
    int[] arrayOfInt = this.texture;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public boolean canUseBlendMode()
  {
    FaceItem localFaceItem = this.item;
    return (localFaceItem != null) && (localFaceItem.blendMode < 2);
  }
  
  public void clearGLSLSelf()
  {
    int[] arrayOfInt = this.texture;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.cosmetic3DFilter.clearGLSLSelf();
    this.detectInfo = null;
    this.copyFrame.clear();
    super.clearGLSLSelf();
  }
  
  public FaceItem getFaceOffItem()
  {
    return this.item;
  }
  
  public int getNextFrame(int paramInt)
  {
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if (BitmapUtils.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[0], localBitmap);
      this.isFaceImageReady = true;
      return this.texture[0];
    }
    VideoMemoryManager.getInstance().recycleBitmap(this.item.id, localBitmap);
    return -1;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    initFaceTexCoords();
    initGrayTexCoords();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  protected boolean initFaceImage()
  {
    if (this.isFaceImageReady)
    {
      update3DFaceImage(this.texture[0]);
      return true;
    }
    Object localObject2 = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.faceExchangeImage);
    VideoMemoryManager.getInstance().getSampleSize();
    Object localObject1 = localObject2;
    if (!BitmapUtils.isLegal((Bitmap)localObject2))
    {
      localObject1 = localObject2;
      if (VideoMemoryManager.getInstance().isForceLoadFromSdCard())
      {
        localObject1 = AEModule.getContext();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.dataPath);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(this.item.faceExchangeImage);
        localObject1 = BitmapUtils.decodeSampleBitmap((Context)localObject1, ((StringBuilder)localObject2).toString(), 1);
      }
    }
    if (BitmapUtils.isLegal((Bitmap)localObject1))
    {
      GlUtil.loadTexture(this.texture[0], (Bitmap)localObject1);
      update3DFaceImage(this.texture[0]);
      this.isFaceImageReady = true;
    }
    return this.isFaceImageReady;
  }
  
  protected void initFaceTexCoords()
  {
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoordsForFaceOffFilter(FaceOffUtil.genPoints(this.item.facePoints), 5.0F), this.faceImageWidth, this.faceImageHeight, this.texVertices));
  }
  
  public void initParams()
  {
    this.faceImageWidth = this.item.width;
    this.faceImageHeight = this.item.height;
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
    addParam(new UniformParam.IntParam("enableFaceOff", 1));
    addParam(new UniformParam.FloatParam("alpha", this.item.blendAlpha));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Mat4Param("posMatRotate", new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F }));
    addParam(new UniformParam.FloatParam("enableAlphaFromGray", this.item.grayScale));
    addParam(new UniformParam.FloatParam("filterSkin", this.item.filterSkin));
    addAttribParam("pointsVisValue", this.pointVisVertices);
    if (this.item.grayScale > 0) {
      addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", 1.0F));
    } else {
      addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", 0.0F));
    }
    addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
    addParam(new UniformParam.IntParam("blendIris", this.item.blendIris));
    if (this.item.blendMode == 13)
    {
      addParam(new UniformParam.FloatParam("level1", 0.0F));
      addParam(new UniformParam.FloatParam("level2", 0.0F));
    }
    if (this.item.blendMode == 14)
    {
      this.isIrisImageReady = false;
      addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
      float[] arrayOfFloat = new float[2];
      float[] tmp439_438 = arrayOfFloat;
      tmp439_438[0] = 0.0F;
      float[] tmp443_439 = tmp439_438;
      tmp443_439[1] = 0.0F;
      tmp443_439;
      addParam(new UniformParam.FloatsParam("center1", arrayOfFloat));
      addParam(new UniformParam.FloatsParam("center2", arrayOfFloat));
      addParam(new UniformParam.FloatsParam("size", arrayOfFloat));
      addParam(new UniformParam.FloatParam("radius1", 0.0F));
      addParam(new UniformParam.FloatParam("radius2", 0.0F));
      addParam(new UniformParam.FloatParam("leftEyeClosed", 0.0F));
      addParam(new UniformParam.FloatParam("rightEyeClosed", 0.0F));
      addParam(new UniformParam.FloatParam("leftEyeCloseAlpha", 1.0F));
      addParam(new UniformParam.FloatParam("rightEyeCloseAlpha", 1.0F));
      return;
    }
    this.isIrisImageReady = true;
  }
  
  public boolean isRenderReady()
  {
    if ((this.triggered) && (this.isFaceImageReady) && (this.isGrayImageReady))
    {
      PTDetectInfo localPTDetectInfo = this.detectInfo;
      if ((localPTDetectInfo != null) && (AlgoUtils.isFace3DPointsValid(localPTDetectInfo.face3DVerticesArray))) {
        return true;
      }
    }
    return false;
  }
  
  public float[] mat4RotationYXZ(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat = new float[16];
    float[] tmp8_6 = arrayOfFloat;
    tmp8_6[0] = 1.0F;
    float[] tmp12_8 = tmp8_6;
    tmp12_8[1] = 0.0F;
    float[] tmp16_12 = tmp12_8;
    tmp16_12[2] = 0.0F;
    float[] tmp20_16 = tmp16_12;
    tmp20_16[3] = 0.0F;
    float[] tmp24_20 = tmp20_16;
    tmp24_20[4] = 0.0F;
    float[] tmp28_24 = tmp24_20;
    tmp28_24[5] = 1.0F;
    float[] tmp32_28 = tmp28_24;
    tmp32_28[6] = 0.0F;
    float[] tmp37_32 = tmp32_28;
    tmp37_32[7] = 0.0F;
    float[] tmp42_37 = tmp37_32;
    tmp42_37[8] = 0.0F;
    float[] tmp47_42 = tmp42_37;
    tmp47_42[9] = 0.0F;
    float[] tmp52_47 = tmp47_42;
    tmp52_47[10] = 1.0F;
    float[] tmp57_52 = tmp52_47;
    tmp57_52[11] = 0.0F;
    float[] tmp62_57 = tmp57_52;
    tmp62_57[12] = 0.0F;
    float[] tmp67_62 = tmp62_57;
    tmp67_62[13] = 0.0F;
    float[] tmp72_67 = tmp67_62;
    tmp72_67[14] = 0.0F;
    float[] tmp77_72 = tmp72_67;
    tmp77_72[15] = 1.0F;
    tmp77_72;
    double d = paramFloat1;
    paramFloat1 = (float)Math.cos(d);
    float f1 = (float)Math.sin(d);
    d = paramFloat2;
    paramFloat2 = (float)Math.cos(d);
    float f2 = (float)Math.sin(d);
    d = paramFloat3;
    paramFloat3 = (float)Math.cos(d);
    float f3 = (float)Math.sin(d);
    float f4 = paramFloat2 * paramFloat3;
    tmp8_6[0] = (f1 * f2 * f3 + f4);
    tmp8_6[1] = (paramFloat1 * f3);
    tmp8_6[2] = (paramFloat2 * f1 * f3 - paramFloat3 * f2);
    tmp8_6[3] = 0.0F;
    tmp8_6[4] = (paramFloat3 * f1 * f2 - paramFloat2 * f3);
    tmp8_6[5] = (paramFloat3 * paramFloat1);
    tmp8_6[6] = (f4 * f1 + f3 * f2);
    tmp8_6[7] = 0.0F;
    tmp8_6[8] = (f2 * paramFloat1);
    tmp8_6[9] = (-f1);
    tmp8_6[10] = (paramFloat1 * paramFloat2);
    tmp8_6[11] = 0.0F;
    tmp8_6[12] = 0.0F;
    tmp8_6[13] = 0.0F;
    tmp8_6[14] = 0.0F;
    tmp8_6[15] = 1.0F;
    return tmp8_6;
  }
  
  public void reset() {}
  
  public void setCosAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.data = paramArrayOfByte;
  }
  
  public void updatePointParams(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    Object localObject = FaceOffUtil.getFullCoordsForFaceOffFilter(VideoMaterial.copyList(paramList), 5.0F);
    this.pointVis = FaceOffUtil.getFullPointsVisForFaceOffFilter(paramArrayOfFloat);
    double d1 = this.width;
    double d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int i = (int)(d1 * d2);
    d1 = this.height;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    setPositions(FaceOffUtil.initFacePositions((List)localObject, i, (int)(d1 * d2), this.faceVertices));
    setCoordNum(690);
    paramArrayOfFloat = FaceOffUtil.initPointVis(this.pointVis, this.pointVisVertices);
    if (paramArrayOfFloat != null) {
      addAttribParam("pointsVisValue", paramArrayOfFloat);
    }
    if (this.item.blendMode == 13)
    {
      d1 = this.width;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      i = (int)(d1 * d2);
      d1 = this.height;
      d2 = this.mFaceDetScale;
      Double.isNaN(d1);
      getAverageGreen(paramList, i, (int)(d1 * d2));
      addParam(new UniformParam.FloatParam("level1", this.level1 / 255.0F));
      addParam(new UniformParam.FloatParam("level2", this.level2 / 255.0F));
    }
    if (this.item.blendMode == 14)
    {
      paramArrayOfFloat = new PointF(((PointF)paramList.get(44)).x, ((PointF)paramList.get(44)).y);
      localObject = new PointF(((PointF)paramList.get(54)).x, ((PointF)paramList.get(54)).y);
      PointF localPointF1 = (PointF)paramList.get(39);
      PointF localPointF2 = (PointF)paramList.get(35);
      PointF localPointF3 = (PointF)paramList.get(49);
      PointF localPointF4 = (PointF)paramList.get(45);
      float f2 = AlgoUtils.getDistance(localPointF1, localPointF2) * 0.26F;
      float f1 = AlgoUtils.getDistance(localPointF3, localPointF4) * 0.26F;
      if ((AlgoUtils.getDistance(this.irisCenterL, ZERO_POINT) >= 0.001D) && (AlgoUtils.getDistance(this.irisCenterR, ZERO_POINT) >= 0.001D))
      {
        d1 = Math.min(this.width, this.height);
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        f3 = (float)(d1 * d2);
        d1 = (float)(Math.pow((float)Math.sqrt(Math.pow(paramArrayOfFloat.x - this.irisCenterL.x, 2.0D) + Math.pow(paramArrayOfFloat.y - this.irisCenterL.y, 2.0D)) / f3, 2.0D) * 65536.0D + 1.0D);
        Double.isNaN(d1);
        Double.isNaN(d1);
        f4 = (float)(d1 / (d1 + 1.5D));
        d2 = this.irisCenterL.x;
        d1 = f4;
        Double.isNaN(d1);
        d1 = 1.0D - d1;
        Double.isNaN(d2);
        d3 = paramArrayOfFloat.x * f4;
        Double.isNaN(d3);
        paramArrayOfFloat.x = ((float)(d2 * d1 + d3));
        d2 = this.irisCenterL.y;
        Double.isNaN(d2);
        d3 = paramArrayOfFloat.y * f4;
        Double.isNaN(d3);
        paramArrayOfFloat.y = ((float)(d2 * d1 + d3));
        d2 = this.irisRadiusL;
        Double.isNaN(d2);
        d3 = f2 * f4;
        Double.isNaN(d3);
        f2 = (float)(d2 * d1 + d3);
        this.irisCenterL = new PointF(paramArrayOfFloat.x, paramArrayOfFloat.y);
        this.irisRadiusL = f2;
        d1 = (float)(Math.pow((float)Math.sqrt(Math.pow(((PointF)localObject).x - this.irisCenterR.x, 2.0D) + Math.pow(((PointF)localObject).y - this.irisCenterR.y, 2.0D)) / f3, 2.0D) * 65536.0D + 1.0D);
        Double.isNaN(d1);
        Double.isNaN(d1);
        f3 = (float)(d1 / (1.5D + d1));
        d2 = this.irisCenterR.x;
        d1 = f3;
        Double.isNaN(d1);
        d1 = 1.0D - d1;
        Double.isNaN(d2);
        d3 = ((PointF)localObject).x * f3;
        Double.isNaN(d3);
        ((PointF)localObject).x = ((float)(d2 * d1 + d3));
        d2 = this.irisCenterR.y;
        Double.isNaN(d2);
        d3 = ((PointF)localObject).y * f3;
        Double.isNaN(d3);
        ((PointF)localObject).y = ((float)(d2 * d1 + d3));
        d2 = this.irisRadiusR;
        Double.isNaN(d2);
        d3 = f1 * f3;
        Double.isNaN(d3);
        f1 = (float)(d2 * d1 + d3);
        this.irisCenterR = new PointF(((PointF)localObject).x, ((PointF)localObject).y);
        this.irisRadiusR = f1;
      }
      else
      {
        this.irisCenterL = new PointF(paramArrayOfFloat.x, paramArrayOfFloat.y);
        this.irisCenterR = new PointF(((PointF)localObject).x, ((PointF)localObject).y);
        this.irisRadiusL = f2;
        this.irisRadiusR = f1;
      }
      localPointF1 = (PointF)paramList.get(41);
      localPointF2 = (PointF)paramList.get(37);
      d1 = f2;
      Double.isNaN(d1);
      f2 = (float)(d1 * 2.0D);
      d2 = Math.max(0.0D, AlgoUtils.getDistance(localPointF1, localPointF2) / f2 - 0.04F);
      double d3 = 0.36F;
      Double.isNaN(d3);
      f2 = (float)Math.min(1.0D, d2 / d3);
      localPointF1 = (PointF)paramList.get(47);
      paramList = (PointF)paramList.get(51);
      d2 = f1;
      Double.isNaN(d2);
      f1 = (float)(d2 * 2.0D);
      double d4 = Math.max(0.0D, AlgoUtils.getDistance(paramList, localPointF1) / f1 - 0.04F);
      Double.isNaN(d3);
      f1 = (float)Math.min(1.0D, d4 / d3);
      d3 = paramArrayOfFloat.x;
      d4 = this.mFaceDetScale;
      Double.isNaN(d3);
      paramArrayOfFloat.x = ((float)(d3 / d4));
      d3 = paramArrayOfFloat.y;
      d4 = this.mFaceDetScale;
      Double.isNaN(d3);
      paramArrayOfFloat.y = ((float)(d3 / d4));
      d3 = ((PointF)localObject).x;
      d4 = this.mFaceDetScale;
      Double.isNaN(d3);
      ((PointF)localObject).x = ((float)(d3 / d4));
      d3 = ((PointF)localObject).y;
      d4 = this.mFaceDetScale;
      Double.isNaN(d3);
      ((PointF)localObject).y = ((float)(d3 / d4));
      d3 = this.mFaceDetScale;
      Double.isNaN(d1);
      float f3 = (float)(d1 / d3);
      d1 = this.mFaceDetScale;
      Double.isNaN(d2);
      float f4 = (float)(d2 / d1);
      addParam(new UniformParam.Float2fParam("center1", paramArrayOfFloat.x, paramArrayOfFloat.y));
      addParam(new UniformParam.Float2fParam("center2", ((PointF)localObject).x, ((PointF)localObject).y));
      addParam(new UniformParam.Float2fParam("size", this.width, this.height));
      addParam(new UniformParam.FloatParam("radius1", f3));
      addParam(new UniformParam.FloatParam("radius2", f4));
      addParam(new UniformParam.FloatParam("leftEyeCloseAlpha", f2));
      addParam(new UniformParam.FloatParam("rightEyeCloseAlpha", f1));
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      this.detectInfo = paramObject;
      this.triggered = (CollectionUtils.isEmpty(paramObject.facePoints) ^ true);
      if (!this.triggered)
      {
        this.lastIndex = -1;
        return;
      }
      List localList = VideoMaterial.copyList(paramObject.facePoints);
      float[] arrayOfFloat = paramObject.pointsVis;
      updateMouthOpenFactor(localList);
      updatePointParams(localList, arrayOfFloat);
      update3DPointParams();
      updateTextureParams(paramObject.timestamp, paramObject.frameIndex);
    }
  }
  
  public void updateRandomGroupValue(int paramInt) {}
  
  public void updateTextureParams(long paramLong, int paramInt)
  {
    boolean bool1 = initGrayImage();
    boolean bool2 = initIrisImage();
    if (bool1)
    {
      if (!bool2) {
        return;
      }
      if (this.sequenceMode)
      {
        if (paramInt == this.lastIndex)
        {
          if (this.isFaceImageReady) {
            update3DFaceImage(this.texture[0]);
          }
          return;
        }
        int i = getNextFrame(paramInt);
        if (i <= 0)
        {
          if (this.isFaceImageReady) {
            update3DFaceImage(this.texture[0]);
          }
          return;
        }
        update3DFaceImage(i);
        this.lastIndex = paramInt;
        return;
      }
      initFaceImage();
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.cosmetic3DFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FaceOff3DFilter
 * JD-Core Version:    0.7.0.1
 */