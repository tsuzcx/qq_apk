package com.tencent.ttpic.filter;

import android.content.Context;
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
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
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
  private static final String TAG = "FaceOffFilter";
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
    if (isFaceExchangeImageDir(this.item.faceExchangeImage))
    {
      if (this.faceIndex != 0) {
        return;
      }
      if (getChangeSwitch() == 1) {
        return;
      }
      float f2 = 0.0F;
      int i = 121;
      float f1 = 0.0F;
      while (i < 131)
      {
        f1 += paramArrayOfFloat[i];
        i += 1;
      }
      if (f1 / 10.0F < 0.5D)
      {
        this.isrightEyeShadowChange = true;
      }
      else if (this.isrightEyeShadowChange)
      {
        this.rightShadowIndex = FaceOffFilterManager.getInstance().getRandomIndex(4);
        FaceOffFilterManager.getInstance().setUpdateStatus(4, true);
        this.isrightEyeShadowChange = false;
        this.isChangeImage = true;
      }
      i = 111;
      f1 = 0.0F;
      while (i < 121)
      {
        f1 += paramArrayOfFloat[i];
        i += 1;
      }
      if (f1 / 10.0F < 0.5D)
      {
        this.isleftEyeShadowChange = true;
      }
      else if (this.isleftEyeShadowChange)
      {
        this.leftShadowIndex = FaceOffFilterManager.getInstance().getRandomIndex(3);
        FaceOffFilterManager.getInstance().setUpdateStatus(3, true);
        this.isleftEyeShadowChange = false;
        this.isChangeImage = true;
      }
      i = 65;
      f1 = f2;
      while (i < 72)
      {
        f1 += paramArrayOfFloat[i];
        i += 1;
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
      }
      else if (this.islipsChange)
      {
        this.lipsIndex = FaceOffFilterManager.getInstance().getRandomIndex(0);
        FaceOffFilterManager.getInstance().setUpdateStatus(0, true);
        this.islipsChange = false;
        this.isChangeImage = true;
      }
      double d1 = paramArrayOfFloat[124];
      Double.isNaN(d1);
      double d2 = paramArrayOfFloat[123];
      Double.isNaN(d2);
      double d3 = paramArrayOfFloat[61];
      Double.isNaN(d3);
      double d4 = paramArrayOfFloat[61] * 2.0F;
      Double.isNaN(d4);
      double d5 = paramArrayOfFloat[62];
      Double.isNaN(d5);
      double d6 = paramArrayOfFloat[18];
      Double.isNaN(d6);
      double d7 = paramArrayOfFloat[17];
      Double.isNaN(d7);
      double d8 = paramArrayOfFloat[16];
      Double.isNaN(d8);
      if ((float)(d1 * 0.5D + d2 * 0.5D + d3 * 0.5D + d4 + d5 + d6 * 0.5D + d7 * 0.5D + d8 * 0.5D) / 6.0F < 0.7D)
      {
        this.isrightCheekChange = true;
      }
      else if (this.isrightCheekChange)
      {
        this.rightCheekIndex = FaceOffFilterManager.getInstance().getRandomIndex(2);
        FaceOffFilterManager.getInstance().setUpdateStatus(2, true);
        this.isrightCheekChange = false;
        this.isChangeImage = true;
      }
      d1 = paramArrayOfFloat[114];
      Double.isNaN(d1);
      d2 = paramArrayOfFloat[113];
      Double.isNaN(d2);
      d3 = paramArrayOfFloat[57];
      Double.isNaN(d3);
      d4 = paramArrayOfFloat[56];
      Double.isNaN(d4);
      d5 = paramArrayOfFloat[57] * 2.0F;
      Double.isNaN(d5);
      d6 = paramArrayOfFloat[0];
      Double.isNaN(d6);
      d7 = paramArrayOfFloat[1];
      Double.isNaN(d7);
      d8 = paramArrayOfFloat[2];
      Double.isNaN(d8);
      if ((float)(d1 * 0.5D + d2 * 0.5D + d3 * 0.5D + d4 + d5 + d6 * 0.5D + d7 * 0.5D + d8 * 0.5D) / 6.0F < 0.7D)
      {
        this.isleftCheekChange = true;
        return;
      }
      if (this.isleftCheekChange)
      {
        this.leftCheekIndex = FaceOffFilterManager.getInstance().getRandomIndex(1);
        FaceOffFilterManager.getInstance().setUpdateStatus(1, true);
        this.isleftCheekChange = false;
        this.isChangeImage = true;
      }
    }
  }
  
  private float[] getAllVisiblePointsVis()
  {
    float[] arrayOfFloat = new float[90];
    Arrays.fill(arrayOfFloat, 1.0F);
    return arrayOfFloat;
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
    String str;
    if (isFaceExchangeImageDir(this.item.faceExchangeImage))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.dataPath);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.item.faceExchangeImage);
      str = ".png";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.dataPath);
      ((StringBuilder)localObject).append(File.separator);
      str = this.item.faceExchangeImage;
    }
    ((StringBuilder)localObject).append(str);
    Object localObject = ((StringBuilder)localObject).toString();
    localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, 1);
    if (BitmapUtils.isLegal((Bitmap)localObject))
    {
      GlUtil.loadTexture(this.texture[4], (Bitmap)localObject);
      this.isDefaultImageReady = true;
    }
    return this.isDefaultImageReady;
  }
  
  private boolean initGrayImage()
  {
    if (this.isGrayImageReady) {
      return true;
    }
    Object localObject2 = VideoMemoryManager.getInstance().loadImage(this.item.featureType);
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(FaceOffUtil.FeatureType.LIPS_MASK);
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
        localObject2 = FaceOffUtil.getGrayBitmap(FaceOffUtil.FeatureType.LIPS_MASK);
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
  
  private void initLipsStyleMaskImage()
  {
    if (this.item.grayScale == 1) {
      return;
    }
    if (TextUtils.isEmpty(this.item.lipsStyleMask)) {
      return;
    }
    if (this.isLipsStyleMaskReady) {
      return;
    }
    Bitmap localBitmap2 = VideoMemoryManager.getInstance().loadImage(this.item.id, this.item.lipsStyleMask);
    Bitmap localBitmap1 = localBitmap2;
    if (!BitmapUtils.isLegal(localBitmap2))
    {
      localBitmap2 = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.lipsStyleMask);
      localBitmap1 = localBitmap2;
      if (!BitmapUtils.isLegal(localBitmap2)) {
        return;
      }
    }
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
      Object localObject = AEModule.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.dataPath);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(this.item.faceExchangeImage);
      localStringBuilder.append(".png");
      this.faceInitBitmap = BitmapUtils.decodeSampleBitmap((Context)localObject, localStringBuilder.toString(), 1);
      this.lipsBmpList = new SparseArray();
      this.rightCheekBmpList = new SparseArray();
      this.rightShadowBmpList = new SparseArray();
      this.leftCheekBmpList = new SparseArray();
      this.leftShadowBmpList = new SparseArray();
      int i = 0;
      int j = 0;
      while (i < 5)
      {
        localObject = AEModule.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.dataPath);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(this.item.faceExchangeImage);
        localStringBuilder.append("/lips/lips_");
        localStringBuilder.append(i);
        localStringBuilder.append(".png");
        localObject = BitmapUtils.decodeSampleBitmap((Context)localObject, localStringBuilder.toString(), 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal((Bitmap)localObject), "lipsBmp is illegal");
        if (BitmapUtils.isLegal((Bitmap)localObject))
        {
          this.lipsBmpList.put(i, localObject);
          j = i;
        }
        i += 1;
      }
      i = 0;
      int k = 0;
      while (i < 5)
      {
        localObject = AEModule.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.dataPath);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(this.item.faceExchangeImage);
        localStringBuilder.append("/right_cheeks/right_cheeks_");
        localStringBuilder.append(i);
        localStringBuilder.append(".png");
        localObject = BitmapUtils.decodeSampleBitmap((Context)localObject, localStringBuilder.toString(), 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal((Bitmap)localObject), "rightCheekBmp is illegal");
        if (BitmapUtils.isLegal((Bitmap)localObject))
        {
          this.rightCheekBmpList.put(i, localObject);
          k = i;
        }
        i += 1;
      }
      i = 0;
      int m = 0;
      while (i < 5)
      {
        localObject = AEModule.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.dataPath);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(this.item.faceExchangeImage);
        localStringBuilder.append("/left_cheeks/left_cheeks_");
        localStringBuilder.append(i);
        localStringBuilder.append(".png");
        localObject = BitmapUtils.decodeSampleBitmap((Context)localObject, localStringBuilder.toString(), 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal((Bitmap)localObject), "leftCheekBmp is illegal");
        if (BitmapUtils.isLegal((Bitmap)localObject))
        {
          this.leftCheekBmpList.put(i, localObject);
          m = i;
        }
        i += 1;
      }
      i = 0;
      int n = 0;
      while (i < 1)
      {
        localObject = AEModule.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.dataPath);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(this.item.faceExchangeImage);
        localStringBuilder.append("/right_eyeshadow/right_eyeshadow_");
        localStringBuilder.append(i);
        localStringBuilder.append(".png");
        localObject = BitmapUtils.decodeSampleBitmap((Context)localObject, localStringBuilder.toString(), 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal((Bitmap)localObject), "rightShadowBmp is illegal");
        if (BitmapUtils.isLegal((Bitmap)localObject))
        {
          this.rightShadowBmpList.put(i, localObject);
          n = i;
        }
        i += 1;
      }
      i = 0;
      int i1 = 0;
      while (i < 1)
      {
        localObject = AEModule.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.dataPath);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(this.item.faceExchangeImage);
        localStringBuilder.append("/left_eyeshadow/left_eyeshadow_");
        localStringBuilder.append(i);
        localStringBuilder.append(".png");
        localObject = BitmapUtils.decodeSampleBitmap((Context)localObject, localStringBuilder.toString(), 1);
        AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal((Bitmap)localObject), "leftShadowBmp is illegal");
        if (BitmapUtils.isLegal((Bitmap)localObject))
        {
          this.leftShadowBmpList.put(i, localObject);
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
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
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
    return null;
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
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
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
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int j = VideoMemoryManager.getInstance().getSampleSize();
    int i;
    if ((this.isFaceImageReady) && (!this.isChangeImage) && (isFaceExchangeImageDir(this.item.faceExchangeImage)))
    {
      if (this.isChangeFirstFace)
      {
        if (!BitmapUtils.isLegal(this.faceInitBitmap))
        {
          localObject2 = AEModule.getContext();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.dataPath);
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append(this.item.faceExchangeImage);
          ((StringBuilder)localObject3).append(".png");
          this.faceInitBitmap = BitmapUtils.decodeSampleBitmap((Context)localObject2, ((StringBuilder)localObject3).toString(), 1);
        }
        localObject2 = this.mergeBitmap;
        if (localObject2 != null) {
          ((Bitmap)localObject2).recycle();
        }
        if (BitmapUtils.isLegal(this.faceInitBitmap))
        {
          localObject1 = this.faceInitBitmap;
          this.mergeBitmap = ((Bitmap)localObject1);
        }
        this.isChangeFirstFace = false;
      }
      else
      {
        localObject3 = this.mergeBitmap;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
      this.faceBitmapType = 1;
      this.sameBitmap = false;
      i = j;
    }
    else if (!isFaceExchangeImageDir(this.item.faceExchangeImage))
    {
      if (this.faceBitmapType == 1)
      {
        this.sameBitmap = true;
        localObject1 = localObject3;
        i = j;
      }
      else
      {
        this.sameBitmap = false;
        localObject2 = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.faceExchangeImage);
        localObject1 = localObject2;
        i = j;
        if (!BitmapUtils.isLegal((Bitmap)localObject2))
        {
          localObject1 = localObject2;
          i = j;
          if (VideoMemoryManager.getInstance().isForceLoadFromSdCard())
          {
            localObject1 = AEModule.getContext();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.dataPath);
            ((StringBuilder)localObject2).append(File.separator);
            ((StringBuilder)localObject2).append(this.item.faceExchangeImage);
            localObject1 = BitmapUtils.decodeSampleBitmap((Context)localObject1, ((StringBuilder)localObject2).toString(), 1);
            i = 1;
          }
        }
      }
      this.faceBitmapType = 1;
    }
    else
    {
      localObject1 = new ArrayList();
      localObject2 = this.lipsBmpList;
      if (localObject2 != null)
      {
        localObject2 = (Bitmap)((SparseArray)localObject2).get(this.lipsIndex);
        if (BitmapUtils.isLegal((Bitmap)localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      localObject2 = this.rightCheekBmpList;
      if (localObject2 != null)
      {
        localObject2 = (Bitmap)((SparseArray)localObject2).get(this.rightCheekIndex);
        if (BitmapUtils.isLegal((Bitmap)localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      localObject2 = this.rightShadowBmpList;
      if (localObject2 != null)
      {
        localObject2 = (Bitmap)((SparseArray)localObject2).get(this.rightShadowIndex);
        if (BitmapUtils.isLegal((Bitmap)localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      localObject2 = this.leftCheekBmpList;
      if (localObject2 != null)
      {
        localObject2 = (Bitmap)((SparseArray)localObject2).get(this.leftCheekIndex);
        if (BitmapUtils.isLegal((Bitmap)localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      localObject2 = this.leftShadowBmpList;
      if (localObject2 != null)
      {
        localObject2 = (Bitmap)((SparseArray)localObject2).get(this.leftShadowIndex);
        if (BitmapUtils.isLegal((Bitmap)localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      localObject1 = mergeBitmap((ArrayList)localObject1);
      localObject2 = this.mergeBitmap;
      if (localObject2 != null) {
        ((Bitmap)localObject2).recycle();
      }
      this.mergeBitmap = ((Bitmap)localObject1);
      this.isChangeImage = false;
      this.faceBitmapType = 1;
      this.sameBitmap = false;
      i = j;
    }
    if (this.sameBitmap)
    {
      if (!this.isFaceImageReady) {
        initFaceTexCoords();
      }
      this.isFaceImageReady = true;
    }
    else if (BitmapUtils.isLegal((Bitmap)localObject1))
    {
      GlUtil.loadTexture(this.texture[0], (Bitmap)localObject1);
      ((Bitmap)localObject1).recycle();
      if (!this.isFaceImageReady)
      {
        this.faceImageWidth = (((Bitmap)localObject1).getWidth() * i);
        this.faceImageHeight = (((Bitmap)localObject1).getHeight() * i);
        initFaceTexCoords();
      }
      this.isFaceImageReady = true;
    }
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
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
    else
    {
      addParam(new UniformParam.FloatParam("useLipsRGBA", 0.0F));
      addParam(new UniformParam.Float4fParam("lipsRGBA", 0.0F, 0.0F, 0.0F, 0.0F));
    }
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
      float[] tmp596_595 = arrayOfFloat;
      tmp596_595[0] = 0.0F;
      float[] tmp600_596 = tmp596_595;
      tmp600_596[1] = 0.0F;
      tmp600_596;
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
    if ((initGrayImage()) && (initIrisImage()))
    {
      if (!initDefaultImage()) {
        return;
      }
      if (this.sequenceMode)
      {
        if (paramInt == this.lastIndex) {
          return;
        }
        int i = getNextFrame(paramInt);
        if (i <= 0) {
          return;
        }
        addParam(new UniformParam.TextureParam("inputImageTexture2", i, 33986));
        this.lastIndex = paramInt;
        return;
      }
      initFaceImage();
    }
  }
  
  public void updatePointParams(List<PointF> paramList1, List<PointF> paramList2, float[] paramArrayOfFloat, float paramFloat)
  {
    Object localObject = VideoMaterial.copyList(paramList1);
    paramFloat = -paramFloat;
    this.pointVis = FaceOffUtil.getFullPointsVisForFaceOffFilter_v2((List)localObject, paramArrayOfFloat, paramFloat);
    if (this.item.faceExchangeImageDisableFaceCrop)
    {
      if (this.opacity == null) {
        this.opacity = new float[''];
      }
      Arrays.fill(this.opacity, 1.0F);
    }
    else
    {
      this.opacity = FaceOffUtil.getFullOpacityForFaceOffFilter_v2(paramList1, paramFloat);
    }
    double d1 = this.width;
    double d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    int i = (int)(d1 * d2);
    d1 = this.height;
    d2 = this.mFaceDetScale;
    Double.isNaN(d1);
    setPositions(FaceOffUtil.initFacePositions_v2(paramList2, i, (int)(d1 * d2), this.faceVertices));
    setCoordNum(FaceOffUtil.NO_HOLE_TRIANGLE_COUNT_V2 * 3);
    if (getShelterSwitch() == 1) {
      paramList2 = FaceOffUtil.getFullPointsVisForFaceOffFilter_v2((List)localObject, getAllVisiblePointsVis(), paramFloat);
    } else {
      paramList2 = this.pointVis;
    }
    paramList2 = FaceOffUtil.initPointVis_v2(paramList2, this.pointVisVertices);
    paramArrayOfFloat = FaceOffUtil.initPointVis_v2(this.opacity, this.pointOpacity);
    if (paramList2 != null) {
      addAttribParam("pointsVisValue", paramList2);
    }
    if (paramArrayOfFloat != null) {
      addAttribParam("opacity", paramArrayOfFloat);
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
      getAverageGreen(paramList1, i, (int)(d1 * d2));
      addParam(new UniformParam.FloatParam("level1", this.level1 / 255.0F));
      addParam(new UniformParam.FloatParam("level2", this.level2 / 255.0F));
    }
    if (this.item.blendMode == 14)
    {
      paramList2 = new PointF(((PointF)paramList1.get(44)).x, ((PointF)paramList1.get(44)).y);
      paramArrayOfFloat = new PointF(((PointF)paramList1.get(54)).x, ((PointF)paramList1.get(54)).y);
      localObject = (PointF)paramList1.get(39);
      PointF localPointF1 = (PointF)paramList1.get(35);
      PointF localPointF2 = (PointF)paramList1.get(49);
      PointF localPointF3 = (PointF)paramList1.get(45);
      float f1 = AlgoUtils.getDistance((PointF)localObject, localPointF1) * 0.26F;
      paramFloat = AlgoUtils.getDistance(localPointF2, localPointF3) * 0.26F;
      if ((AlgoUtils.getDistance(this.irisCenterL, ZERO_POINT) >= 0.001D) && (AlgoUtils.getDistance(this.irisCenterR, ZERO_POINT) >= 0.001D))
      {
        d1 = Math.min(this.width, this.height);
        d2 = this.mFaceDetScale;
        Double.isNaN(d1);
        f2 = (float)(d1 * d2);
        d1 = (float)(Math.pow((float)Math.sqrt(Math.pow(paramList2.x - this.irisCenterL.x, 2.0D) + Math.pow(paramList2.y - this.irisCenterL.y, 2.0D)) / f2, 2.0D) * 65536.0D + 1.0D);
        Double.isNaN(d1);
        Double.isNaN(d1);
        f3 = (float)(d1 / (d1 + 1.5D));
        d2 = this.irisCenterL.x;
        d1 = f3;
        Double.isNaN(d1);
        d1 = 1.0D - d1;
        Double.isNaN(d2);
        d3 = paramList2.x * f3;
        Double.isNaN(d3);
        paramList2.x = ((float)(d2 * d1 + d3));
        d2 = this.irisCenterL.y;
        Double.isNaN(d2);
        d3 = paramList2.y * f3;
        Double.isNaN(d3);
        paramList2.y = ((float)(d2 * d1 + d3));
        d2 = this.irisRadiusL;
        Double.isNaN(d2);
        d3 = f1 * f3;
        Double.isNaN(d3);
        f1 = (float)(d2 * d1 + d3);
        this.irisCenterL = new PointF(paramList2.x, paramList2.y);
        this.irisRadiusL = f1;
        d1 = (float)(Math.pow((float)Math.sqrt(Math.pow(paramArrayOfFloat.x - this.irisCenterR.x, 2.0D) + Math.pow(paramArrayOfFloat.y - this.irisCenterR.y, 2.0D)) / f2, 2.0D) * 65536.0D + 1.0D);
        Double.isNaN(d1);
        Double.isNaN(d1);
        f2 = (float)(d1 / (1.5D + d1));
        d2 = this.irisCenterR.x;
        d1 = f2;
        Double.isNaN(d1);
        d1 = 1.0D - d1;
        Double.isNaN(d2);
        d3 = paramArrayOfFloat.x * f2;
        Double.isNaN(d3);
        paramArrayOfFloat.x = ((float)(d2 * d1 + d3));
        d2 = this.irisCenterR.y;
        Double.isNaN(d2);
        d3 = paramArrayOfFloat.y * f2;
        Double.isNaN(d3);
        paramArrayOfFloat.y = ((float)(d2 * d1 + d3));
        d2 = this.irisRadiusR;
        Double.isNaN(d2);
        d3 = paramFloat * f2;
        Double.isNaN(d3);
        paramFloat = (float)(d2 * d1 + d3);
        this.irisCenterR = new PointF(paramArrayOfFloat.x, paramArrayOfFloat.y);
        this.irisRadiusR = paramFloat;
      }
      else
      {
        this.irisCenterL = new PointF(paramList2.x, paramList2.y);
        this.irisCenterR = new PointF(paramArrayOfFloat.x, paramArrayOfFloat.y);
        this.irisRadiusL = f1;
        this.irisRadiusR = paramFloat;
      }
      localObject = (PointF)paramList1.get(41);
      localPointF1 = (PointF)paramList1.get(37);
      d1 = f1;
      Double.isNaN(d1);
      f1 = (float)(d1 * 2.0D);
      d2 = Math.max(0.0D, AlgoUtils.getDistance((PointF)localObject, localPointF1) / f1 - 0.04F);
      double d3 = 0.36F;
      Double.isNaN(d3);
      f1 = (float)Math.min(1.0D, d2 / d3);
      localObject = (PointF)paramList1.get(47);
      paramList1 = (PointF)paramList1.get(51);
      d2 = paramFloat;
      Double.isNaN(d2);
      paramFloat = (float)(d2 * 2.0D);
      double d4 = Math.max(0.0D, AlgoUtils.getDistance(paramList1, (PointF)localObject) / paramFloat - 0.04F);
      Double.isNaN(d3);
      paramFloat = (float)Math.min(1.0D, d4 / d3);
      d3 = paramList2.x;
      d4 = this.mFaceDetScale;
      Double.isNaN(d3);
      paramList2.x = ((float)(d3 / d4));
      d3 = paramList2.y;
      d4 = this.mFaceDetScale;
      Double.isNaN(d3);
      paramList2.y = ((float)(d3 / d4));
      d3 = paramArrayOfFloat.x;
      d4 = this.mFaceDetScale;
      Double.isNaN(d3);
      paramArrayOfFloat.x = ((float)(d3 / d4));
      d3 = paramArrayOfFloat.y;
      d4 = this.mFaceDetScale;
      Double.isNaN(d3);
      paramArrayOfFloat.y = ((float)(d3 / d4));
      d3 = this.mFaceDetScale;
      Double.isNaN(d1);
      float f2 = (float)(d1 / d3);
      d1 = this.mFaceDetScale;
      Double.isNaN(d2);
      float f3 = (float)(d2 / d1);
      addParam(new UniformParam.Float2fParam("center1", paramList2.x, paramList2.y));
      addParam(new UniformParam.Float2fParam("center2", paramArrayOfFloat.x, paramArrayOfFloat.y));
      addParam(new UniformParam.Float2fParam("size", this.width, this.height));
      addParam(new UniformParam.FloatParam("radius1", f2));
      addParam(new UniformParam.FloatParam("radius2", f3));
      addParam(new UniformParam.FloatParam("leftEyeCloseAlpha", f1));
      addParam(new UniformParam.FloatParam("rightEyeCloseAlpha", paramFloat));
    }
  }
  
  public void updatePreview(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      PTDetectInfo localPTDetectInfo = (PTDetectInfo)paramObject;
      if (!CollectionUtils.isEmpty(localPTDetectInfo.facePoints))
      {
        List localList = VideoMaterial.copyList(localPTDetectInfo.facePoints);
        this.faceIndex = paramInt2;
        int k = this.faceCount;
        int j = 0;
        int i = 0;
        paramInt2 = 1;
        if (paramInt1 != k)
        {
          this.isChangeFirstFace = true;
          this.faceCount = paramInt1;
          this.isFaceImageReady = false;
        }
        else
        {
          this.isChangeFirstFace = false;
        }
        float[] arrayOfFloat = localPTDetectInfo.pointsVis;
        updateMouthOpenFactor(localList);
        if ((localPTDetectInfo.realPhoneAngle != 90.0F) && (localPTDetectInfo.realPhoneAngle != 270.0F))
        {
          paramInt1 = Float.valueOf(localPTDetectInfo.phoneAngle - localPTDetectInfo.realPhoneAngle).intValue();
          if ((paramInt1 != 90) && (paramInt1 != 180) && (paramInt1 != -180)) {
            paramInt1 = 1;
          } else {
            paramInt1 = 1;
          }
        }
        else
        {
          for (;;)
          {
            paramInt2 = -1;
            break;
            k = Float.valueOf(localPTDetectInfo.realPhoneAngle - localPTDetectInfo.phoneAngle).intValue();
            paramInt1 = i;
            if (k != 0)
            {
              paramInt1 = j;
              if (k != 90) {
                break;
              }
              paramInt1 = i;
            }
          }
        }
        if (this.item.faceExchangeImageDisableFaceCrop) {
          paramObject = localPTDetectInfo.noCropFaceoffPoints;
        } else {
          paramObject = localPTDetectInfo.normalFaceoffPoints;
        }
        updatePointParams(localList, paramObject, arrayOfFloat, paramInt2 * localPTDetectInfo.faceAngles[paramInt1]);
        changeMakeup(this.pointVis);
        updateFrameIndex(paramInt3);
        initLipsStyleMaskImage();
        if ((localPTDetectInfo.noseOcclusionFrame != null) && (!this.item.faceExchangeImageDisableFaceCrop))
        {
          addParam(new UniformParam.TextureParam("inputImageTexture7", localPTDetectInfo.noseOcclusionFrame.getTextureId(), 33991));
          addParam(new UniformParam.FloatParam("enableNoseOcclusion", 1.0F));
          return;
        }
        addParam(new UniformParam.FloatParam("enableNoseOcclusion", 0.0F));
      }
    }
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