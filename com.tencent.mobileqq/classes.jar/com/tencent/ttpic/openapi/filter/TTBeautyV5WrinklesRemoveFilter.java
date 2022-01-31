package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.List;

public class TTBeautyV5WrinklesRemoveFilter
  extends VideoFilterBase
{
  private static final String CONTENT = "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n    {\n      \"faceExchangeImage\": \"eyemask.jpg\",\n      \"blendAlpha\":1.0,\n      \"featureType\": 0,\n      \"grayScale\": 0,\n      \"blendMode\": 0,\n      \"facePoints\": [\n  156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n      ]\n    }\n  ],\n  \"itemList\": [\n    {\n      \"id\": \"kangxi\",\n      \"frameDuration\": 0,\n      \"frames\": 1,\n      \"height\": 960,\n      \"width\": 720,\n      \"triggerType\": 2,\n      \"playCount\": 0,\n      \"alwaysTriggered\": 1,\n      \"type\": 1,\n      \"position\": [\n        0,\n        0\n      ]\n    }\n  ]\n}\n\n";
  private static final String FOLDER = "assets://realtimeBeauty";
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float width;\nuniform float height;\nuniform float wrinkles;\n\nvec4 smoothSkin(vec4 centralColor)\n{\n     vec4 resultColor = centralColor;\n\n     float x_a = float(width);\n     float y_a = float(height);\n     float mul_x = 1.6 / x_a;\n     float mul_y = 1.6 / y_a;\n\n     vec2 blurCoordinates12 = canvasCoordinate + vec2(0.0 * mul_x,-6.0 * mul_y);\n     vec2 blurCoordinates13 = canvasCoordinate + vec2(-4.0 * mul_x,-4.0 * mul_y);\n     vec2 blurCoordinates14 = canvasCoordinate + vec2(-6.0 * mul_x,0.0 * mul_y);\n     vec2 blurCoordinates15 = canvasCoordinate + vec2(-4.0 * mul_x,4.0 * mul_y);\n     vec2 blurCoordinates16 = canvasCoordinate + vec2(0.0 * mul_x,6.0 * mul_y);\n     vec2 blurCoordinates17 = canvasCoordinate + vec2(4.0 * mul_x,4.0 * mul_y);\n     vec2 blurCoordinates18 = canvasCoordinate + vec2(6.0 * mul_x,0.0 * mul_y);\n     vec2 blurCoordinates19 = canvasCoordinate + vec2(4.0 * mul_x,-4.0 * mul_y);\n\n     float central;\n     float gaussianWeightTotal;\n     float sum;\n     float sample;\n     float distanceFromCentralColor;\n     float gaussianWeight;\n\n     float distanceNormalizationFactor = 3.6;\n\n     central = texture2D(inputImageTexture, canvasCoordinate).g;\n     gaussianWeightTotal = 0.2;\n     sum = central * 0.2;\n\n     sample = texture2D(inputImageTexture, blurCoordinates12).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates13).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates14).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates15).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates16).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates17).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates18).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates19).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sum = sum/gaussianWeightTotal;\n\n     sample = centralColor.g - sum + 0.5;\n\n     for(int i = 0; i < 5; ++i) {\n         if(sample <= 0.5) {\n             sample = sample * sample * 2.0;\n         }\n         else {\n             sample = 1.0 - ((1.0 - sample)*(1.0 - sample) * 2.0);\n         }\n     }\n\n     float aa = 1.0 + pow(sum, 0.3)*0.09;\n     vec3 smoothColor = centralColor.rgb*aa - vec3(sample)*(aa-1.0);// get smooth color\n     smoothColor = clamp(smoothColor,vec3(0.0),vec3(1.0));//make smooth color right\n\n     smoothColor = mix(centralColor.rgb, smoothColor, pow(centralColor.g, 0.33) * pow(centralColor.g, 0.39));\n\n     resultColor = vec4(pow(smoothColor, vec3(0.96)),1.0);\n\n     return resultColor;\n}\n\nvoid main(void) {\n    vec4 origColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 mask1 = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 color0 = origColor;\n    if (mask1.r * wrinkles > 0.01) {\n        color0 = mix(color0, smoothSkin(color0), mask1.r * wrinkles);\n    }\n    gl_FragColor = color0;\n}\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  private String faceImage = "wrinkles2.jpg";
  private int faceImageHeight = 1067;
  private int faceImageWidth = 800;
  private boolean isFaceImageReady;
  private FaceItem item = createFaceItem();
  private float[] texVertices = new float[1380];
  private int[] texture = new int[1];
  private float wrinkles = 0.0F;
  
  public TTBeautyV5WrinklesRemoveFilter()
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float width;\nuniform float height;\nuniform float wrinkles;\n\nvec4 smoothSkin(vec4 centralColor)\n{\n     vec4 resultColor = centralColor;\n\n     float x_a = float(width);\n     float y_a = float(height);\n     float mul_x = 1.6 / x_a;\n     float mul_y = 1.6 / y_a;\n\n     vec2 blurCoordinates12 = canvasCoordinate + vec2(0.0 * mul_x,-6.0 * mul_y);\n     vec2 blurCoordinates13 = canvasCoordinate + vec2(-4.0 * mul_x,-4.0 * mul_y);\n     vec2 blurCoordinates14 = canvasCoordinate + vec2(-6.0 * mul_x,0.0 * mul_y);\n     vec2 blurCoordinates15 = canvasCoordinate + vec2(-4.0 * mul_x,4.0 * mul_y);\n     vec2 blurCoordinates16 = canvasCoordinate + vec2(0.0 * mul_x,6.0 * mul_y);\n     vec2 blurCoordinates17 = canvasCoordinate + vec2(4.0 * mul_x,4.0 * mul_y);\n     vec2 blurCoordinates18 = canvasCoordinate + vec2(6.0 * mul_x,0.0 * mul_y);\n     vec2 blurCoordinates19 = canvasCoordinate + vec2(4.0 * mul_x,-4.0 * mul_y);\n\n     float central;\n     float gaussianWeightTotal;\n     float sum;\n     float sample;\n     float distanceFromCentralColor;\n     float gaussianWeight;\n\n     float distanceNormalizationFactor = 3.6;\n\n     central = texture2D(inputImageTexture, canvasCoordinate).g;\n     gaussianWeightTotal = 0.2;\n     sum = central * 0.2;\n\n     sample = texture2D(inputImageTexture, blurCoordinates12).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates13).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates14).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates15).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates16).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates17).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates18).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates19).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sum = sum/gaussianWeightTotal;\n\n     sample = centralColor.g - sum + 0.5;\n\n     for(int i = 0; i < 5; ++i) {\n         if(sample <= 0.5) {\n             sample = sample * sample * 2.0;\n         }\n         else {\n             sample = 1.0 - ((1.0 - sample)*(1.0 - sample) * 2.0);\n         }\n     }\n\n     float aa = 1.0 + pow(sum, 0.3)*0.09;\n     vec3 smoothColor = centralColor.rgb*aa - vec3(sample)*(aa-1.0);// get smooth color\n     smoothColor = clamp(smoothColor,vec3(0.0),vec3(1.0));//make smooth color right\n\n     smoothColor = mix(centralColor.rgb, smoothColor, pow(centralColor.g, 0.33) * pow(centralColor.g, 0.39));\n\n     resultColor = vec4(pow(smoothColor, vec3(0.96)),1.0);\n\n     return resultColor;\n}\n\nvoid main(void) {\n    vec4 origColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 mask1 = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 color0 = origColor;\n    if (mask1.r * wrinkles > 0.01) {\n        color0 = mix(color0, smoothSkin(color0), mask1.r * wrinkles);\n    }\n    gl_FragColor = color0;\n}\n");
    this.dataPath = "assets://realtimeBeauty";
    initParams();
    setCoordNum(690);
  }
  
  private FaceItem createFaceItem()
  {
    return (FaceItem)VideoTemplateParser.parseVideoMaterial("assets://realtimeBeauty", "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n    {\n      \"faceExchangeImage\": \"eyemask.jpg\",\n      \"blendAlpha\":1.0,\n      \"featureType\": 0,\n      \"grayScale\": 0,\n      \"blendMode\": 0,\n      \"facePoints\": [\n  156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n      ]\n    }\n  ],\n  \"itemList\": [\n    {\n      \"id\": \"kangxi\",\n      \"frameDuration\": 0,\n      \"frames\": 1,\n      \"height\": 960,\n      \"width\": 720,\n      \"triggerType\": 2,\n      \"playCount\": 0,\n      \"alwaysTriggered\": 1,\n      \"type\": 1,\n      \"position\": [\n        0,\n        0\n      ]\n    }\n  ]\n}\n\n", null).getFaceOffItemList().get(0);
  }
  
  private void initFaceImage()
  {
    if ((!this.isFaceImageReady) && (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.faceImage))))
    {
      Bitmap localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.faceImage);
      GlUtil.loadTexture(this.texture[0], localBitmap);
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
      this.isFaceImageReady = true;
    }
  }
  
  private void initFaceTexCoords()
  {
    addAttribParam("inputTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.item.facePoints), 5.0F), this.faceImageWidth, this.faceImageHeight, this.texVertices), true);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.texture.length, this.texture, 0);
  }
  
  public void clearGLSLSelf()
  {
    GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
    this.isFaceImageReady = false;
    super.clearGLSLSelf();
  }
  
  public void initAttribParams()
  {
    addAttribParam("position", this.texVertices, true);
    initFaceTexCoords();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.FloatParam("width", 0.0F));
    addParam(new UniformParam.FloatParam("height", 0.0F));
    addParam(new UniformParam.FloatParam("wrinkles", this.wrinkles));
  }
  
  public boolean needRender()
  {
    updateTextureParams();
    return (this.wrinkles > 0.01F) && (this.isFaceImageReady);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AttributeParam localAttributeParam = getAttribParam("position");
    if ((localAttributeParam == null) || (localAttributeParam.vertices.length / localAttributeParam.perVertexFloat != 690)) {}
    do
    {
      return false;
      localAttributeParam = getAttribParam("inputTextureCoordinate");
    } while ((localAttributeParam == null) || (localAttributeParam.vertices.length / localAttributeParam.perVertexFloat != 690));
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void setWrinklesAlpha(float paramFloat)
  {
    this.wrinkles = paramFloat;
    addParam(new UniformParam.FloatParam("wrinkles", this.wrinkles));
  }
  
  public void updateParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat, true);
    updateTextureParams();
  }
  
  public void updateTextureParams()
  {
    initFaceImage();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.FloatParam("width", paramInt1));
    addParam(new UniformParam.FloatParam("height", paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV5WrinklesRemoveFilter
 * JD-Core Version:    0.7.0.1
 */