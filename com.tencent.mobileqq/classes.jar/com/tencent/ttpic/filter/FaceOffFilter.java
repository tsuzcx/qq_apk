package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.UniformParam.Float2fParam;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
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
import com.tencent.ttpic.openapi.manager.FaceOffFilterManager;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FaceOffFilter
  extends VideoFilterBase
{
  private static final int CHANGE_BITMAP = 1;
  public static final String FRAGMENT_SHADER = "//Need Sync FaceOffFragmentShaderExt.dat\n\nprecision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying vec2 modelTextureCoordinate;\nvarying float pointVisValue;\nvarying float opacityValue;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\n\nuniform float alpha;\nuniform int enableFaceOff;\nuniform float enableNoseOcclusion;\nuniform float enableAlphaFromGray;\nuniform float enableAlphaFromGrayNew;\nuniform int blendMode;\nuniform int blendIris;\nuniform float level1;\nuniform float level2;\n\nuniform vec2 size;\nuniform vec2 center1;\nuniform vec2 center2;\nuniform float radius1;\nuniform float radius2;\n\nuniform int leftEyeClosed; // deprecated\nuniform int rightEyeClosed; // deprecated\nuniform float leftEyeCloseAlpha;\nuniform float rightEyeCloseAlpha;\nuniform float useMaterialLipsMask;\nuniform float useLipsRGBA;\nuniform vec4 lipsRGBA; \n\nvec3 blendColorWithMode(vec4 texColor, vec4 canvasColor, int colorBlendMode)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    vec3 resultFore = texColor.rgb;\n    if (colorBlendMode <= 1){ //default, since used most, put on top\n\n    } else if (colorBlendMode == 2) {  //multiply\n        resultFore = canvasColor.rgb * texColor.rgb;\n    } else if (colorBlendMode == 3){    //screen\n        resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n    } else if (colorBlendMode == 4){    //overlay\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (canvasColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (canvasColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (canvasColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 5){    //hardlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n        if (texColor.r >= 0.5) {\n            resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n        }\n    } else if (colorBlendMode == 6){    //softlight\n        resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n        if (texColor.r >= 0.5) {\n            resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n        }\n        if (texColor.g >= 0.5) {\n            resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n        }\n        if (texColor.b >= 0.5) {\n            resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n        }\n    } else if (colorBlendMode == 7){    //divide\n        resultFore = vOne;\n        if (texColor.r > 0.0) {\n            resultFore.r = canvasColor.r / texColor.r;\n        }\n        if (texColor.g > 0.0) {\n            resultFore.g = canvasColor.g / texColor.g;\n        }\n        if (texColor.b > 0.0) {\n            resultFore.b = canvasColor.b / texColor.b;\n        }\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 8){    //add\n        resultFore = canvasColor.rgb + texColor.rgb;\n        resultFore = min(vOne, resultFore);\n    } else if (colorBlendMode == 9){    //substract\n        resultFore = canvasColor.rgb - texColor.rgb;\n        resultFore = max(vZero, resultFore);\n    } else if (colorBlendMode == 10){   //diff\n        resultFore = abs(canvasColor.rgb - texColor.rgb);\n    } else if (colorBlendMode == 11){   //darken\n        resultFore = min(canvasColor.rgb, texColor.rgb);\n    } else if (blendMode == 12){   //lighten\n        resultFore = max(canvasColor.rgb, texColor.rgb);\n    }\n    return resultFore;\n}\n\nvec4 blendColor(vec4 texColor, vec4 canvasColor) {\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    if (blendMode <= 12) {\n        resultFore = blendColorWithMode(texColor, canvasColor, blendMode);\n    } else if (blendMode == 13){   //highlight for lips\n        if (texColor.a > 0.0001) {\n            if(canvasColor.r >= level1) {\n                texColor.rgb = vec3(1.0, 1.0, 1.0);\n                //if(canvasColor.r < 0.6) {\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05;\n                //}\n            } else if (canvasColor.r >= level2) {\n               if (level1 > level2) {\n                   float f = (canvasColor.r - level2) / (level1 - level2);\n                   texColor.rgb = texColor.rgb + (vOne - texColor.rgb) * f;\n                   canvasColor.rgb = canvasColor.rgb + (vOne - canvasColor.rgb) * 0.05 * f;\n               }\n            }\n        }\n        resultFore = canvasColor.rgb * texColor.rgb;\n        resultFore = clamp(resultFore, 0.0001, 0.9999);\n    } else if (blendMode == 14){   // iris\n         vec2 curPos = vec2(canvasCoordinate.x * size.x, canvasCoordinate.y * size.y);\n         float dist1 = sqrt((curPos.x - center1.x) * (curPos.x - center1.x) + (curPos.y - center1.y) * (curPos.y - center1.y));\n         float dist2 = sqrt((curPos.x - center2.x) * (curPos.x - center2.x) + (curPos.y - center2.y) * (curPos.y - center2.y));\n         if (dist1 < radius1 && leftEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center1.x) / radius1 / 2.0;\n             float _y = (curPos.y - center1.y) / radius1 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * leftEyeCloseAlpha;\n         } else if (dist2 < radius2 && rightEyeCloseAlpha >= 0.01) {\n             float _x = (curPos.x - center2.x) / radius2 / 2.0;\n             float _y = (curPos.y - center2.y) / radius2 / 2.0;\n             vec4 irisColor = texture2D(inputImageTexture4, vec2(_x * 0.72 + 0.5, _y * 0.72 + 0.5));\n             if (irisColor.a > 0.0) {\n                 irisColor = irisColor / vec4(irisColor.a, irisColor.a, irisColor.a, 1.0);\n             }\n             resultFore = blendColorWithMode(irisColor, canvasColor, blendIris);\n             texColor.a = texColor.a * irisColor.a * rightEyeCloseAlpha;\n         } else {\n            texColor.a = 0.0;\n         }\n         //resultFore = texColor.rgb;\n         //texColor.a = 1.0;\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n    return resultColor;\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\n\n    float grayAlpha = 1.0; \n    if (texColor.a > 0.0) {\n        texColor = texColor / vec4(texColor.a, texColor.a, texColor.a, 1.0);\n    }\n    if(enableAlphaFromGray > 0.0){\n        vec4 grayColor = texture2D(inputImageTexture3, grayTextureCoordinate);\n        grayAlpha = 1.0 - grayColor.g;\n    }\n    if (useMaterialLipsMask > 0.0) { \n        vec4 lipsColor = texture2D(inputImageTexture5, modelTextureCoordinate);\n        if (lipsColor.g > 0.01) { \n           texColor = mix(texColor, lipsRGBA, useLipsRGBA); \n           grayAlpha = mix(lipsColor.g, lipsColor.r, enableAlphaFromGrayNew); \n        } \n    } \n    texColor.a = texColor.a * alpha * grayAlpha; \n\n    float confidence = smoothstep(0.7, 1.0, pointVisValue) * opacityValue;\n\n    texColor.a = texColor.a * confidence;\n\n        vec4 screenNoseColor = texture2D(inputImageTexture7, canvasCoordinate);\n        texColor.a = texColor.a * mix(1.0, screenNoseColor.a, enableNoseOcclusion); \n\n//    if(confidence >= 0.0){\n//            texColor.a = texColor.a * confidence;\n//    }\n\n    texColor.rgb = texColor.rgb * texColor.a;\n\n    gl_FragColor = blendColor(texColor, canvasColor);\n    //gl_FragColor = vec4(canvasColor.rgb * opacityValue, 1.0);\n }\n";
  private static final int MERGE_BITMAP = 1;
  private static final int NONE_BITMAP = -1;
  private static final int NORMAL_BITMAP = 1;
  private static final String TAG = FaceOffFilter.class.getSimpleName();
  public static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nattribute vec2 inputGrayTextureCoordinate;\nattribute vec2 inputModelTextureCoordinate;\nattribute float pointsVisValue;\nattribute float opacity;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying vec2 grayTextureCoordinate;\nvarying vec2 modelTextureCoordinate;\nvarying float pointVisValue;\nvarying float opacityValue;\n\nuniform vec2 canvasSize;\nuniform float positionRotate;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    grayTextureCoordinate = inputGrayTextureCoordinate;\n    modelTextureCoordinate = inputModelTextureCoordinate;\n    pointVisValue = pointsVisValue;\n    opacityValue = opacity;\n}\n";
  private static final PointF ZERO_POINT = new PointF(0.0F, 0.0F);
  private byte[] data = null;
  private int faceBitmapType = -1;
  private int faceCount = -1;
  protected int faceImageHeight;
  protected int faceImageWidth;
  private int faceIndex = -1;
  private Bitmap faceInitBitmap = null;
  private float[] faceVertices = new float[FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2];
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2];
  private PointF irisCenterL = new PointF(0.0F, 0.0F);
  private PointF irisCenterR = new PointF(0.0F, 0.0F);
  private float irisRadiusL;
  private float irisRadiusR;
  private boolean isChangeFirstFace = false;
  private boolean isChangeImage;
  private boolean isDefaultImageReady;
  private boolean isFaceImageReady;
  private boolean isGrayImageReady;
  private boolean isIrisImageReady;
  private boolean isLipsStyleMaskReady;
  private boolean isleftCheekChange = false;
  private boolean isleftEyeShadowChange = false;
  private boolean islipsChange = false;
  private boolean isrightCheekChange = false;
  private boolean isrightEyeShadowChange = false;
  protected FaceItem item;
  private int lastIndex = -1;
  private SparseArray<Bitmap> leftCheekBmpList;
  private int leftCheekIndex = 0;
  private SparseArray<Bitmap> leftShadowBmpList;
  private int leftShadowIndex = 0;
  private float level1 = 0.0F;
  private float level2 = 0.0F;
  private int levelCount = 0;
  private SparseArray<Bitmap> lipsBmpList;
  private int lipsIndex = 0;
  byte[] mData = null;
  private Bitmap mergeBitmap = null;
  private float[] modelVertices = new float[FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2];
  private float[] opacity = new float[''];
  private float percent1 = 0.05F;
  private float percent2 = 0.15F;
  private float[] pointOpacity = new float[FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2];
  private float[] pointVis = new float[''];
  private float[] pointVisVertices = new float[FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2];
  private SparseArray<Bitmap> rightCheekBmpList;
  private int rightCheekIndex = 0;
  private SparseArray<Bitmap> rightShadowBmpList;
  private int rightShadowIndex = 0;
  private boolean sameBitmap = false;
  private boolean sequenceMode;
  private double sumg = 0.0D;
  private double sumr = 0.0D;
  private float[] texVertices = new float[FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2];
  protected int[] texture = new int[6];
  
  public FaceOffFilter(FaceItem paramFaceItem, String paramString)
  {
    super(ShaderManager.getInstance().getShader(ShaderCreateFactory.PROGRAM_TYPE.FACEOFFV2));
    this.item = paramFaceItem;
    this.dataPath = paramString;
    this.sequenceMode = TextUtils.isEmpty(paramFaceItem.faceExchangeImage);
    initParams();
  }
  
  private void changeMakeup(float[] paramArrayOfFloat)
  {
    float f2 = 0.0F;
    if ((!isFaceExchangeImageDir(this.item.faceExchangeImage)) || (this.faceIndex != 0)) {}
    label496:
    do
    {
      do
      {
        return;
      } while (getChangeSwitch() == 1);
      int i = 121;
      float f1 = 0.0F;
      while (i < 131)
      {
        f1 += paramArrayOfFloat[i];
        i += 1;
      }
      if (f1 / 10.0F < 0.5D) {
        this.isrightEyeShadowChange = true;
      }
      for (;;)
      {
        i = 111;
        f1 = 0.0F;
        while (i < 121)
        {
          f1 += paramArrayOfFloat[i];
          i += 1;
        }
        if (this.isrightEyeShadowChange)
        {
          this.rightShadowIndex = FaceOffFilterManager.getInstance().getRandomIndex(4);
          FaceOffFilterManager.getInstance().setUpdateStatus(4, true);
          this.isrightEyeShadowChange = false;
          this.isChangeImage = true;
        }
      }
      if (f1 / 10.0F < 0.5D) {
        this.isleftEyeShadowChange = true;
      }
      for (;;)
      {
        i = 65;
        f1 = f2;
        while (i < 72)
        {
          f1 += paramArrayOfFloat[i];
          i += 1;
        }
        if (this.isleftEyeShadowChange)
        {
          this.leftShadowIndex = FaceOffFilterManager.getInstance().getRandomIndex(3);
          FaceOffFilterManager.getInstance().setUpdateStatus(3, true);
          this.isleftEyeShadowChange = false;
          this.isChangeImage = true;
        }
      }
      i = 75;
      while (i < 80)
      {
        f1 += paramArrayOfFloat[i];
        i += 1;
      }
      if (f1 / 12.0F < 0.5D)
      {
        this.islipsChange = true;
        if ((float)(paramArrayOfFloat[124] * 0.5D + paramArrayOfFloat[123] * 0.5D + paramArrayOfFloat[61] * 0.5D + paramArrayOfFloat[61] * 2.0F + paramArrayOfFloat[62] + paramArrayOfFloat[18] * 0.5D + paramArrayOfFloat[17] * 0.5D + paramArrayOfFloat[16] * 0.5D) / 6.0F >= 0.7D) {
          break label496;
        }
        this.isrightCheekChange = true;
      }
      for (;;)
      {
        if ((float)(paramArrayOfFloat[114] * 0.5D + paramArrayOfFloat[113] * 0.5D + paramArrayOfFloat[57] * 0.5D + paramArrayOfFloat[56] + paramArrayOfFloat[57] * 2.0F + paramArrayOfFloat[0] * 0.5D + paramArrayOfFloat[1] * 0.5D + paramArrayOfFloat[2] * 0.5D) / 6.0F >= 0.7D) {
          break label535;
        }
        this.isleftCheekChange = true;
        return;
        if (!this.islipsChange) {
          break;
        }
        this.lipsIndex = FaceOffFilterManager.getInstance().getRandomIndex(0);
        FaceOffFilterManager.getInstance().setUpdateStatus(0, true);
        this.islipsChange = false;
        this.isChangeImage = true;
        break;
        if (this.isrightCheekChange)
        {
          this.rightCheekIndex = FaceOffFilterManager.getInstance().getRandomIndex(2);
          FaceOffFilterManager.getInstance().setUpdateStatus(2, true);
          this.isrightCheekChange = false;
          this.isChangeImage = true;
        }
      }
    } while (!this.isleftCheekChange);
    label535:
    this.leftCheekIndex = FaceOffFilterManager.getInstance().getRandomIndex(1);
    FaceOffFilterManager.getInstance().setUpdateStatus(1, true);
    this.isleftCheekChange = false;
    this.isChangeImage = true;
  }
  
  private float[] getAllVisiblePointsVis()
  {
    float[] arrayOfFloat = new float[90];
    Arrays.fill(arrayOfFloat, 1.0F);
    return arrayOfFloat;
  }
  
  private float getAverageGreen(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if ((this.data == null) || (this.data.length < paramInt2 * paramInt1 * 4)) {
      return 0.0F;
    }
    int i = (int)(((PointF)paramList.get(66)).x - ((PointF)paramList.get(65)).x);
    int m = (int)(((PointF)paramList.get(69)).y - ((PointF)paramList.get(78)).y);
    int j = (int)((PointF)paramList.get(65)).x;
    int k = (int)((PointF)paramList.get(78)).y;
    if ((j >= paramInt1) || (k >= paramInt2) || (i <= 0) || (m <= 0)) {
      return 0.0F;
    }
    if (j < 0) {
      j = 0;
    }
    for (;;)
    {
      if (k < 0) {
        k = 0;
      }
      for (;;)
      {
        if (j + i > paramInt1) {
          i = paramInt1 - j;
        }
        for (;;)
        {
          if (k + m > paramInt2) {
            paramInt2 -= k;
          }
          for (;;)
          {
            paramList = new byte[i * paramInt2 * 4];
            m = 0;
            while (m < paramInt2)
            {
              int n = 0;
              while (n < i)
              {
                int i1 = (m * i + n) * 4;
                int i2 = ((m + k) * paramInt1 + n + j) * 4;
                paramList[i1] = this.data[i2];
                paramList[(i1 + 1)] = this.data[(i2 + 1)];
                paramList[(i1 + 2)] = this.data[(i2 + 2)];
                paramList[(i1 + 3)] = this.data[(i2 + 3)];
                n += 1;
              }
              m += 1;
            }
            int[] arrayOfInt = new int[256];
            this.sumg = 0.0D;
            this.sumr = 0.0D;
            paramInt1 = 0;
            while (paramInt1 < paramInt2)
            {
              j = 0;
              while (j < i)
              {
                k = paramList[((paramInt1 * i + j) * 4)] & 0xFF;
                this.sumr += k;
                m = paramList[((paramInt1 * i + j) * 4 + 1)];
                this.sumg += (m & 0xFF);
                arrayOfInt[k] += 1;
                j += 1;
              }
              paramInt1 += 1;
            }
            this.sumg /= i * paramInt2;
            this.sumr /= i * paramInt2;
            this.levelCount = 0;
            paramInt1 = 255;
            if (paramInt1 >= 0)
            {
              this.levelCount += arrayOfInt[paramInt1];
              if (this.levelCount >= paramInt2 * i * this.percent1) {
                this.level1 = paramInt1;
              }
            }
            else
            {
              this.levelCount = 0;
              paramInt1 = 255;
            }
            for (;;)
            {
              if (paramInt1 >= 0)
              {
                this.levelCount += arrayOfInt[paramInt1];
                if (this.levelCount >= paramInt2 * i * this.percent2) {
                  this.level2 = paramInt1;
                }
              }
              else
              {
                return (float)this.sumr;
                paramInt1 -= 1;
                break;
              }
              paramInt1 -= 1;
            }
            paramInt2 = m;
          }
        }
      }
    }
  }
  
  private int getChangeSwitch()
  {
    return FaceOffFilterManager.getInstance().getChangeSwitch();
  }
  
  private int getShelterSwitch()
  {
    return FaceOffFilterManager.getInstance().getShelterSwitch();
  }
  
  private boolean initDefaultImage()
  {
    if (TextUtils.isEmpty(this.item.faceExchangeImage)) {
      return true;
    }
    if (this.isDefaultImageReady) {
      return true;
    }
    if (isFaceExchangeImageDir(this.item.faceExchangeImage)) {}
    for (Object localObject = this.dataPath + File.separator + this.item.faceExchangeImage + ".png";; localObject = this.dataPath + File.separator + this.item.faceExchangeImage)
    {
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, 1);
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        GlUtil.loadTexture(this.texture[4], (Bitmap)localObject);
        this.isDefaultImageReady = true;
      }
      return this.isDefaultImageReady;
    }
  }
  
  private boolean initGrayImage()
  {
    if (this.isGrayImageReady) {
      return true;
    }
    Object localObject2 = VideoMemoryManager.getInstance().loadImage(this.item.featureType);
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(FaceOffUtil.FEATURE_TYPE.LIPS_MASK);
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
        localObject2 = FaceOffUtil.getGrayBitmap(FaceOffUtil.FEATURE_TYPE.LIPS_MASK);
      }
    }
    VideoMemoryManager.getInstance().getSampleSize();
    if ((BitmapUtils.isLegal((Bitmap)localObject1)) && (BitmapUtils.isLegal((Bitmap)localObject2)))
    {
      GlUtil.loadTexture(this.texture[1], (Bitmap)localObject1);
      this.grayImageWidth = ((Bitmap)localObject1).getWidth();
      this.grayImageHeight = ((Bitmap)localObject1).getHeight();
      initGrayTexCoords();
      addParam(new UniformParam.TextureParam("inputImageTexture3", this.texture[1], 33987));
      if (this.item.grayScale == 2)
      {
        GlUtil.loadTexture(this.texture[3], (Bitmap)localObject2);
        addParam(new UniformParam.TextureParam("inputImageTexture5", this.texture[3], 33989));
        addParam(new UniformParam.FloatParam("useMaterialLipsMask", 1.0F));
      }
      this.isGrayImageReady = true;
    }
    return this.isGrayImageReady;
  }
  
  private void initGrayTexCoords()
  {
    addAttribParam("inputGrayTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords_v2(FaceOffUtil.getFullCoords_v2(FaceOffUtil.getGrayCoords(this.item.featureType), 2.0F, 0.0F, this.item.faceExchangeImageDisableFaceCrop), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
  }
  
  private boolean initIrisImage()
  {
    if (this.isIrisImageReady) {
      return true;
    }
    Bitmap localBitmap2 = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.irisImage);
    Bitmap localBitmap1 = localBitmap2;
    if (!BitmapUtils.isLegal(localBitmap2))
    {
      localBitmap1 = localBitmap2;
      if (VideoMemoryManager.getInstance().isForceLoadFromSdCard()) {
        localBitmap1 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.irisImage, 1);
      }
    }
    if (BitmapUtils.isLegal(localBitmap1))
    {
      GlUtil.loadTexture(this.texture[2], localBitmap1);
      addParam(new UniformParam.TextureParam("inputImageTexture4", this.texture[2], 33988));
      this.isIrisImageReady = true;
    }
    return this.isIrisImageReady;
  }
  
  private void initLipsStyleMaskImage()
  {
    if (this.item.grayScale == 1) {}
    Bitmap localBitmap1;
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.item.lipsStyleMask)) || (this.isLipsStyleMaskReady));
      Bitmap localBitmap2 = VideoMemoryManager.getInstance().loadImage(this.item.id, this.item.lipsStyleMask);
      localBitmap1 = localBitmap2;
      if (BitmapUtils.isLegal(localBitmap2)) {
        break;
      }
      localBitmap1 = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.lipsStyleMask);
    } while (!BitmapUtils.isLegal(localBitmap1));
    GlUtil.loadTexture(this.texture[3], localBitmap1);
    addParam(new UniformParam.TextureParam("inputImageTexture5", this.texture[3], 33989));
    addParam(new UniformParam.FloatParam("useMaterialLipsMask", 1.0F));
    this.isLipsStyleMaskReady = true;
  }
  
  private boolean isFaceExchangeImageDir(String paramString)
  {
    return (paramString != null) && (!paramString.equals("")) && (!paramString.toLowerCase().contains(".png")) && (!paramString.toLowerCase().contains(".jpg"));
  }
  
  private void loadBitmap()
  {
    if (isFaceExchangeImageDir(this.item.faceExchangeImage))
    {
      this.faceInitBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.faceExchangeImage + ".png", 1);
      this.lipsBmpList = new SparseArray();
      this.rightCheekBmpList = new SparseArray();
      this.rightShadowBmpList = new SparseArray();
      this.leftCheekBmpList = new SparseArray();
      this.leftShadowBmpList = new SparseArray();
      int i = 0;
      int j = 0;
      Bitmap localBitmap;
      while (i < 5)
      {
        localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.faceExchangeImage + "/lips/lips_" + i + ".png", 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal(localBitmap), "lipsBmp is illegal");
        if (BitmapUtils.isLegal(localBitmap))
        {
          this.lipsBmpList.put(i, localBitmap);
          j = i;
        }
        i += 1;
      }
      i = 0;
      int k = 0;
      while (i < 5)
      {
        localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.faceExchangeImage + "/right_cheeks/right_cheeks_" + i + ".png", 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal(localBitmap), "rightCheekBmp is illegal");
        if (BitmapUtils.isLegal(localBitmap))
        {
          this.rightCheekBmpList.put(i, localBitmap);
          k = i;
        }
        i += 1;
      }
      i = 0;
      int m = 0;
      while (i < 5)
      {
        localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.faceExchangeImage + "/left_cheeks/left_cheeks_" + i + ".png", 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal(localBitmap), "leftCheekBmp is illegal");
        if (BitmapUtils.isLegal(localBitmap))
        {
          this.leftCheekBmpList.put(i, localBitmap);
          m = i;
        }
        i += 1;
      }
      i = 0;
      int n = 0;
      while (i < 1)
      {
        localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.faceExchangeImage + "/right_eyeshadow/right_eyeshadow_" + i + ".png", 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal(localBitmap), "rightShadowBmp is illegal");
        if (BitmapUtils.isLegal(localBitmap))
        {
          this.rightShadowBmpList.put(i, localBitmap);
          n = i;
        }
        i += 1;
      }
      i = 0;
      int i1 = 0;
      while (i < 1)
      {
        localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.faceExchangeImage + "/left_eyeshadow/left_eyeshadow_" + i + ".png", 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal(localBitmap), "leftShadowBmp is illegal");
        if (BitmapUtils.isLegal(localBitmap))
        {
          this.leftShadowBmpList.put(i, localBitmap);
          i1 = i;
        }
        i += 1;
      }
      FaceOffFilterManager.getInstance().setMaterialsMaxCount(0, j + 1);
      FaceOffFilterManager.getInstance().setMaterialsMaxCount(1, m + 1);
      FaceOffFilterManager.getInstance().setMaterialsMaxCount(2, k + 1);
      FaceOffFilterManager.getInstance().setMaterialsMaxCount(3, i1 + 1);
      FaceOffFilterManager.getInstance().setMaterialsMaxCount(4, n + 1);
    }
  }
  
  private Bitmap mergeBitmap(ArrayList<Bitmap> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((Bitmap)((Iterator)localObject).next() == null) {
        return null;
      }
    }
    localObject = Bitmap.createBitmap(((Bitmap)paramArrayList.get(0)).getWidth(), ((Bitmap)paramArrayList.get(0)).getHeight(), ((Bitmap)paramArrayList.get(0)).getConfig());
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    localCanvas.drawBitmap((Bitmap)paramArrayList.get(0), new Matrix(), null);
    int j = paramArrayList.size();
    int i = 1;
    while (i < j)
    {
      localCanvas.drawBitmap((Bitmap)paramArrayList.get(i), 0.0F, 0.0F, null);
      i += 1;
    }
    return localObject;
  }
  
  private void recycleBitmapList(SparseArray<Bitmap> paramSparseArray)
  {
    if ((paramSparseArray != null) && (paramSparseArray.size() > 0))
    {
      int i = 0;
      while (i < paramSparseArray.size())
      {
        Bitmap localBitmap = (Bitmap)paramSparseArray.get(paramSparseArray.keyAt(i));
        if (BitmapUtils.isLegal(localBitmap)) {
          localBitmap.recycle();
        }
        i += 1;
      }
    }
  }
  
  private void updateMouthOpenFactor(List<PointF> paramList)
  {
    float f1 = AlgoUtils.getDistance((PointF)paramList.get(65), (PointF)paramList.get(66));
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(73), (PointF)paramList.get(81));
    if (f1 > 0.0F) {}
    for (f1 = Math.max(0.0F, Math.min(1.0F, (f2 - f1 * 0.1F) / (f1 * 0.1F)));; f1 = 0.0F)
    {
      addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", Math.min(1.0F, f1 + 0.002F)));
      return;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.texture.length, this.texture, 0);
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item != null) && (this.item.blendMode < 2);
  }
  
  public void clearGLSLSelf()
  {
    GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
    recycleBitmapList(this.lipsBmpList);
    recycleBitmapList(this.rightCheekBmpList);
    recycleBitmapList(this.rightShadowBmpList);
    recycleBitmapList(this.leftCheekBmpList);
    recycleBitmapList(this.leftShadowBmpList);
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
    initModelTexCoords();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 3);
  }
  
  protected void initFaceImage()
  {
    if (TextUtils.isEmpty(this.item.faceExchangeImage)) {
      return;
    }
    if (this.faceIndex != 0)
    {
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[4], 33986));
      this.faceBitmapType = 1;
      this.sameBitmap = false;
      return;
    }
    Bitmap localBitmap = null;
    Object localObject = null;
    int i = VideoMemoryManager.getInstance().getSampleSize();
    if ((this.isFaceImageReady) && (!this.isChangeImage) && (isFaceExchangeImageDir(this.item.faceExchangeImage)))
    {
      if (this.isChangeFirstFace)
      {
        if (!BitmapUtils.isLegal(this.faceInitBitmap)) {
          this.faceInitBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.faceExchangeImage + ".png", 1);
        }
        if (this.mergeBitmap != null) {
          this.mergeBitmap.recycle();
        }
        if (BitmapUtils.isLegal(this.faceInitBitmap))
        {
          this.mergeBitmap = this.faceInitBitmap;
          localObject = this.faceInitBitmap;
        }
        this.isChangeFirstFace = false;
      }
      for (;;)
      {
        this.faceBitmapType = 1;
        this.sameBitmap = false;
        if (!this.sameBitmap) {
          break;
        }
        if (!this.isFaceImageReady) {
          initFaceTexCoords();
        }
        this.isFaceImageReady = true;
        label236:
        addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
        return;
        localObject = localBitmap;
        if (this.mergeBitmap != null) {
          localObject = this.mergeBitmap;
        }
      }
    }
    if (!isFaceExchangeImageDir(this.item.faceExchangeImage)) {
      if (this.faceBitmapType == 1)
      {
        this.sameBitmap = true;
        localObject = null;
      }
    }
    for (;;)
    {
      this.faceBitmapType = 1;
      break;
      this.sameBitmap = false;
      localObject = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.faceExchangeImage);
      if ((!BitmapUtils.isLegal((Bitmap)localObject)) && (VideoMemoryManager.getInstance().isForceLoadFromSdCard()))
      {
        localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.faceExchangeImage, 1);
        i = 1;
        continue;
        localObject = new ArrayList();
        if (this.lipsBmpList != null)
        {
          localBitmap = (Bitmap)this.lipsBmpList.get(this.lipsIndex);
          if (BitmapUtils.isLegal(localBitmap)) {
            ((ArrayList)localObject).add(localBitmap);
          }
        }
        if (this.rightCheekBmpList != null)
        {
          localBitmap = (Bitmap)this.rightCheekBmpList.get(this.rightCheekIndex);
          if (BitmapUtils.isLegal(localBitmap)) {
            ((ArrayList)localObject).add(localBitmap);
          }
        }
        if (this.rightShadowBmpList != null)
        {
          localBitmap = (Bitmap)this.rightShadowBmpList.get(this.rightShadowIndex);
          if (BitmapUtils.isLegal(localBitmap)) {
            ((ArrayList)localObject).add(localBitmap);
          }
        }
        if (this.leftCheekBmpList != null)
        {
          localBitmap = (Bitmap)this.leftCheekBmpList.get(this.leftCheekIndex);
          if (BitmapUtils.isLegal(localBitmap)) {
            ((ArrayList)localObject).add(localBitmap);
          }
        }
        if (this.leftShadowBmpList != null)
        {
          localBitmap = (Bitmap)this.leftShadowBmpList.get(this.leftShadowIndex);
          if (BitmapUtils.isLegal(localBitmap)) {
            ((ArrayList)localObject).add(localBitmap);
          }
        }
        localObject = mergeBitmap((ArrayList)localObject);
        if (this.mergeBitmap != null) {
          this.mergeBitmap.recycle();
        }
        this.mergeBitmap = ((Bitmap)localObject);
        this.isChangeImage = false;
        this.faceBitmapType = 1;
        this.sameBitmap = false;
        break;
        if (!BitmapUtils.isLegal((Bitmap)localObject)) {
          break label236;
        }
        GlUtil.loadTexture(this.texture[0], (Bitmap)localObject);
        ((Bitmap)localObject).recycle();
        if (!this.isFaceImageReady)
        {
          this.faceImageWidth = (((Bitmap)localObject).getWidth() * i);
          this.faceImageHeight = (((Bitmap)localObject).getHeight() * i);
          initFaceTexCoords();
        }
        this.isFaceImageReady = true;
        break label236;
      }
    }
  }
  
  protected void initFaceTexCoords()
  {
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords_v2(FaceOffUtil.getFullCoords_v2(FaceOffUtil.genPoints(this.item.facePoints), 2.0F, 0.0F, this.item.faceExchangeImageDisableFaceCrop), this.faceImageWidth, this.faceImageHeight, this.texVertices));
  }
  
  protected void initModelTexCoords()
  {
    addAttribParam("inputModelTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords_v2(FaceOffUtil.getFullCoords_v2(FaceOffUtil.genPoints(Arrays.asList(FaceOffUtil.COSMETIC_MODEL_IMAGE_FACEPOINTS)), 2.0F, 0.0F, this.item.faceExchangeImageDisableFaceCrop), 800, 1067, this.modelVertices));
  }
  
  public void initParams()
  {
    this.faceImageWidth = this.item.width;
    this.faceImageHeight = this.item.height;
    loadBitmap();
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
    addParam(new UniformParam.TextureParam("inputImageTexture6", 0, 33990));
    addParam(new UniformParam.TextureParam("inputImageTexture7", 0, 33991));
    addParam(new UniformParam.FloatParam("enableNoseOcclusion", 0.0F));
    addParam(new UniformParam.IntParam("enableFaceOff", 1));
    addParam(new UniformParam.FloatParam("alpha", this.item.blendAlpha));
    addParam(new UniformParam.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new UniformParam.Mat4Param("posMatRotate", new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F }));
    addParam(new UniformParam.FloatParam("enableAlphaFromGray", this.item.grayScale));
    addAttribParam("pointsVisValue", this.pointVisVertices);
    addAttribParam("opacity", this.pointOpacity);
    addParam(new UniformParam.FloatParam("enableAlphaFromGrayNew", 0.0F));
    addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
    addParam(new UniformParam.IntParam("blendIris", this.item.blendIris));
    addParam(new UniformParam.FloatParam("useMaterialLipsMask", 0.0F));
    if ((this.item.lipsRGBA != null) && (this.item.lipsRGBA.length == 4))
    {
      addParam(new UniformParam.FloatParam("useLipsRGBA", 1.0F));
      addParam(new UniformParam.Float4fParam("lipsRGBA", this.item.lipsRGBA[0], this.item.lipsRGBA[1], this.item.lipsRGBA[2], this.item.lipsRGBA[3]));
    }
    for (;;)
    {
      if (this.item.blendMode == 13)
      {
        addParam(new UniformParam.FloatParam("level1", 0.0F));
        addParam(new UniformParam.FloatParam("level2", 0.0F));
      }
      if (this.item.blendMode != 14) {
        break;
      }
      this.isIrisImageReady = false;
      addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
      float[] arrayOfFloat = new float[2];
      float[] tmp560_559 = arrayOfFloat;
      tmp560_559[0] = 0.0F;
      float[] tmp564_560 = tmp560_559;
      tmp564_560[1] = 0.0F;
      tmp564_560;
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
      addParam(new UniformParam.FloatParam("useLipsRGBA", 0.0F));
      addParam(new UniformParam.Float4fParam("lipsRGBA", 0.0F, 0.0F, 0.0F, 0.0F));
    }
    this.isIrisImageReady = true;
  }
  
  public boolean isRenderReady()
  {
    return (this.isFaceImageReady) && (this.isGrayImageReady);
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
    float f1 = (float)Math.cos(paramFloat1);
    paramFloat1 = (float)Math.sin(paramFloat1);
    float f2 = (float)Math.cos(paramFloat2);
    paramFloat2 = (float)Math.sin(paramFloat2);
    float f3 = (float)Math.cos(paramFloat3);
    paramFloat3 = (float)Math.sin(paramFloat3);
    arrayOfFloat[0] = (f2 * f3 + paramFloat1 * paramFloat2 * paramFloat3);
    arrayOfFloat[1] = (f1 * paramFloat3);
    arrayOfFloat[2] = (f2 * paramFloat1 * paramFloat3 - f3 * paramFloat2);
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (f3 * paramFloat1 * paramFloat2 - f2 * paramFloat3);
    arrayOfFloat[5] = (f1 * f3);
    arrayOfFloat[6] = (f3 * f2 * paramFloat1 + paramFloat3 * paramFloat2);
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = (paramFloat2 * f1);
    arrayOfFloat[9] = (-paramFloat1);
    arrayOfFloat[10] = (f1 * f2);
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 1.0F;
    return arrayOfFloat;
  }
  
  public void reset()
  {
    this.sameBitmap = false;
    this.faceBitmapType = -1;
  }
  
  public void resetLastFrameIndex()
  {
    this.lastIndex = -1;
  }
  
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
  
  public void updateFrameIndex(int paramInt)
  {
    if ((!initGrayImage()) || (!initIrisImage()) || (!initDefaultImage())) {}
    int i;
    do
    {
      do
      {
        return;
        if (!this.sequenceMode) {
          break;
        }
      } while (paramInt == this.lastIndex);
      i = getNextFrame(paramInt);
    } while (i <= 0);
    addParam(new UniformParam.TextureParam("inputImageTexture2", i, 33986));
    this.lastIndex = paramInt;
    return;
    initFaceImage();
  }
  
  public void updatePointParams(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    Object localObject1 = VideoMaterialUtil.copyList(paramList);
    Object localObject2 = FaceOffUtil.getFullCoords_v2((List)localObject1, 2.0F, -paramFloat, this.item.faceExchangeImageDisableFaceCrop);
    this.pointVis = FaceOffUtil.getFullPointsVisForFaceOffFilter_v2((List)localObject1, paramArrayOfFloat, -paramFloat);
    label135:
    PointF localPointF1;
    float f1;
    if (this.item.faceExchangeImageDisableFaceCrop)
    {
      if (this.opacity == null) {
        this.opacity = new float[''];
      }
      Arrays.fill(this.opacity, 1.0F);
      setPositions(FaceOffUtil.initFacePositions_v2((List)localObject2, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
      setCoordNum(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 3);
      if (getShelterSwitch() != 1) {
        break label886;
      }
      paramArrayOfFloat = FaceOffUtil.getFullPointsVisForFaceOffFilter_v2((List)localObject1, getAllVisiblePointsVis(), -paramFloat);
      paramArrayOfFloat = FaceOffUtil.initPointVis_v2(paramArrayOfFloat, this.pointVisVertices);
      localObject1 = FaceOffUtil.initPointVis_v2(this.opacity, this.pointOpacity);
      if (paramArrayOfFloat != null) {
        addAttribParam("pointsVisValue", paramArrayOfFloat);
      }
      if (localObject1 != null) {
        addAttribParam("opacity", (float[])localObject1);
      }
      if (this.item.blendMode == 13)
      {
        getAverageGreen(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale));
        addParam(new UniformParam.FloatParam("level1", this.level1 / 255.0F));
        addParam(new UniformParam.FloatParam("level2", this.level2 / 255.0F));
      }
      if (this.item.blendMode == 14)
      {
        paramArrayOfFloat = new PointF(((PointF)paramList.get(44)).x, ((PointF)paramList.get(44)).y);
        localObject1 = new PointF(((PointF)paramList.get(54)).x, ((PointF)paramList.get(54)).y);
        localObject2 = (PointF)paramList.get(39);
        localPointF1 = (PointF)paramList.get(35);
        PointF localPointF2 = (PointF)paramList.get(49);
        PointF localPointF3 = (PointF)paramList.get(45);
        f1 = 0.26F * AlgoUtils.getDistance((PointF)localObject2, localPointF1);
        paramFloat = AlgoUtils.getDistance(localPointF2, localPointF3) * 0.26F;
        if ((AlgoUtils.getDistance(this.irisCenterL, ZERO_POINT) >= 0.001D) && (AlgoUtils.getDistance(this.irisCenterR, ZERO_POINT) >= 0.001D)) {
          break label894;
        }
        this.irisCenterL = new PointF(paramArrayOfFloat.x, paramArrayOfFloat.y);
        this.irisCenterR = new PointF(((PointF)localObject1).x, ((PointF)localObject1).y);
        this.irisRadiusL = f1;
      }
    }
    for (this.irisRadiusR = paramFloat;; this.irisRadiusR = paramFloat)
    {
      localObject2 = (PointF)paramList.get(41);
      localPointF1 = (PointF)paramList.get(37);
      float f2 = (float)(f1 * 2.0D);
      f2 = (float)Math.min(1.0D, Math.max(0.0D, AlgoUtils.getDistance((PointF)localObject2, localPointF1) / f2 - 0.04F) / (0.4F - 0.04F));
      localObject2 = (PointF)paramList.get(47);
      paramList = (PointF)paramList.get(51);
      float f3 = (float)(paramFloat * 2.0D);
      f3 = (float)Math.min(1.0D, Math.max(0.0D, AlgoUtils.getDistance(paramList, (PointF)localObject2) / f3 - 0.04F) / (0.4F - 0.04F));
      paramArrayOfFloat.x = ((float)(paramArrayOfFloat.x / this.mFaceDetScale));
      paramArrayOfFloat.y = ((float)(paramArrayOfFloat.y / this.mFaceDetScale));
      ((PointF)localObject1).x = ((float)(((PointF)localObject1).x / this.mFaceDetScale));
      ((PointF)localObject1).y = ((float)(((PointF)localObject1).y / this.mFaceDetScale));
      f1 = (float)(f1 / this.mFaceDetScale);
      paramFloat = (float)(paramFloat / this.mFaceDetScale);
      addParam(new UniformParam.Float2fParam("center1", paramArrayOfFloat.x, paramArrayOfFloat.y));
      addParam(new UniformParam.Float2fParam("center2", ((PointF)localObject1).x, ((PointF)localObject1).y));
      addParam(new UniformParam.Float2fParam("size", this.width, this.height));
      addParam(new UniformParam.FloatParam("radius1", f1));
      addParam(new UniformParam.FloatParam("radius2", paramFloat));
      addParam(new UniformParam.FloatParam("leftEyeCloseAlpha", f2));
      addParam(new UniformParam.FloatParam("rightEyeCloseAlpha", f3));
      return;
      this.opacity = FaceOffUtil.getFullOpacityForFaceOffFilter_v2(paramList, -paramFloat);
      break;
      label886:
      paramArrayOfFloat = this.pointVis;
      break label135;
      label894:
      f2 = (float)(Math.min(this.width, this.height) * this.mFaceDetScale);
      f3 = (float)(1.0D + 65536.0D * Math.pow((float)Math.sqrt(Math.pow(paramArrayOfFloat.x - this.irisCenterL.x, 2.0D) + Math.pow(paramArrayOfFloat.y - this.irisCenterL.y, 2.0D)) / f2, 2.0D));
      f3 = (float)(f3 / (f3 + 1.5D));
      paramArrayOfFloat.x = ((float)(this.irisCenterL.x * (1.0D - f3) + paramArrayOfFloat.x * f3));
      paramArrayOfFloat.y = ((float)(this.irisCenterL.y * (1.0D - f3) + paramArrayOfFloat.y * f3));
      f1 = (float)(this.irisRadiusL * (1.0D - f3) + f1 * f3);
      this.irisCenterL = new PointF(paramArrayOfFloat.x, paramArrayOfFloat.y);
      this.irisRadiusL = f1;
      f2 = (float)(Math.pow((float)Math.sqrt(Math.pow(((PointF)localObject1).x - this.irisCenterR.x, 2.0D) + Math.pow(((PointF)localObject1).y - this.irisCenterR.y, 2.0D)) / f2, 2.0D) * 65536.0D + 1.0D);
      f2 = (float)(f2 / (f2 + 1.5D));
      ((PointF)localObject1).x = ((float)(this.irisCenterR.x * (1.0D - f2) + ((PointF)localObject1).x * f2));
      ((PointF)localObject1).y = ((float)(this.irisCenterR.y * (1.0D - f2) + ((PointF)localObject1).y * f2));
      double d1 = this.irisRadiusR;
      double d2 = f2;
      paramFloat = (float)(paramFloat * f2 + d1 * (1.0D - d2));
      this.irisCenterR = new PointF(((PointF)localObject1).x, ((PointF)localObject1).y);
    }
  }
  
  public void updatePreview(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    int j = 1;
    List localList;
    float[] arrayOfFloat;
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if (!CollectionUtils.isEmpty(paramObject.facePoints))
      {
        localList = VideoMaterialUtil.copyList(paramObject.facePoints);
        this.faceIndex = paramInt2;
        if (paramInt1 == this.faceCount) {
          break label224;
        }
        this.isChangeFirstFace = true;
        this.faceCount = paramInt1;
        this.isFaceImageReady = false;
        arrayOfFloat = paramObject.pointsVis;
        updateMouthOpenFactor(localList);
        if ((paramObject.realPhoneAngle != 90.0F) && (paramObject.realPhoneAngle != 270.0F)) {
          break label232;
        }
        paramInt2 = Float.valueOf(paramObject.realPhoneAngle - paramObject.phoneAngle).intValue();
        if (paramInt2 != 0)
        {
          paramInt1 = j;
          if (paramInt2 != 90) {}
        }
        else
        {
          paramInt1 = -1;
        }
        paramInt2 = 0;
      }
    }
    for (;;)
    {
      updatePointParams(localList, arrayOfFloat, paramInt1 * paramObject.faceAngles[paramInt2]);
      changeMakeup(this.pointVis);
      updateFrameIndex(paramInt3);
      initLipsStyleMaskImage();
      if ((paramObject.noseOcclusionFrame == null) || (this.item.faceExchangeImageDisableFaceCrop)) {
        break label283;
      }
      addParam(new UniformParam.TextureParam("inputImageTexture7", paramObject.noseOcclusionFrame.getTextureId(), 33991));
      addParam(new UniformParam.FloatParam("enableNoseOcclusion", 1.0F));
      return;
      label224:
      this.isChangeFirstFace = false;
      break;
      label232:
      paramInt1 = Float.valueOf(paramObject.phoneAngle - paramObject.realPhoneAngle).intValue();
      if ((paramInt1 == 90) || (paramInt1 == 180) || (paramInt1 == -180))
      {
        paramInt2 = 1;
        paramInt1 = -1;
      }
      else
      {
        paramInt2 = 1;
        paramInt1 = i;
      }
    }
    label283:
    addParam(new UniformParam.FloatParam("enableNoseOcclusion", 0.0F));
  }
  
  public void updateRandomGroupValue(int paramInt) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceOffFilter
 * JD-Core Version:    0.7.0.1
 */