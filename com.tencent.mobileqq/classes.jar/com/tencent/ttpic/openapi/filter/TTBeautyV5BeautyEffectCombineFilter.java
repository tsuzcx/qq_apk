package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
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

public class TTBeautyV5BeautyEffectCombineFilter
  extends VideoFilterBase
{
  private static final String CONTENT = "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n    {\n      \"faceExchangeImage\": \"eyemask.jpg\",\n      \"blendAlpha\":1.0,\n      \"featureType\": 0,\n      \"grayScale\": 0,\n      \"blendMode\": 0,\n      \"facePoints\": [\n  156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n      ]\n    }\n  ],\n  \"itemList\": [\n    {\n      \"id\": \"kangxi\",\n      \"frameDuration\": 0,\n      \"frames\": 1,\n      \"height\": 960,\n      \"width\": 720,\n      \"triggerType\": 2,\n      \"playCount\": 0,\n      \"alwaysTriggered\": 1,\n      \"type\": 1,\n      \"position\": [\n        0,\n        0\n      ]\n    }\n  ]\n}\n\n";
  private static final String FOLDER = "assets://realtimeBeauty";
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform float alpha;\nuniform float width;\nuniform float height;\nuniform float smoothOpacity;\nuniform float contrastOpacity;\nuniform float wrinkles;\nuniform float wrinkles_flw;\n// for eye pouch\nuniform vec2 cgcrLeft;\nuniform vec2 cgcrRight;\nuniform vec3 rgbLeft;\nuniform vec3 rgbRight;\n\nvec4 smoothSkin(vec4 centralColor)\n{\n     vec4 resultColor = centralColor;\n\n     float x_a = float(width);\n     float y_a = float(height);\n     float mul_x = 1.6 / x_a;\n     float mul_y = 1.6 / y_a;\n\n     vec2 blurCoordinates12 = canvasCoordinate + vec2(0.0 * mul_x,-6.0 * mul_y);\n     vec2 blurCoordinates13 = canvasCoordinate + vec2(-4.0 * mul_x,-4.0 * mul_y);\n     vec2 blurCoordinates14 = canvasCoordinate + vec2(-6.0 * mul_x,0.0 * mul_y);\n     vec2 blurCoordinates15 = canvasCoordinate + vec2(-4.0 * mul_x,4.0 * mul_y);\n     vec2 blurCoordinates16 = canvasCoordinate + vec2(0.0 * mul_x,6.0 * mul_y);\n     vec2 blurCoordinates17 = canvasCoordinate + vec2(4.0 * mul_x,4.0 * mul_y);\n     vec2 blurCoordinates18 = canvasCoordinate + vec2(6.0 * mul_x,0.0 * mul_y);\n     vec2 blurCoordinates19 = canvasCoordinate + vec2(4.0 * mul_x,-4.0 * mul_y);\n\n     float central;\n     float gaussianWeightTotal;\n     float sum;\n     float sample;\n     float distanceFromCentralColor;\n     float gaussianWeight;\n\n     float distanceNormalizationFactor = 3.6;\n\n     central = texture2D(inputImageTexture, canvasCoordinate).g;\n     gaussianWeightTotal = 0.2;\n     sum = central * 0.2;\n\n     sample = texture2D(inputImageTexture, blurCoordinates12).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates13).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates14).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates15).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates16).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates17).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates18).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates19).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sum = sum/gaussianWeightTotal;\n\n     sample = centralColor.g - sum + 0.5;\n\n     for(int i = 0; i < 5; ++i) {\n         if(sample <= 0.5) {\n             sample = sample * sample * 2.0;\n         }\n         else {\n             sample = 1.0 - ((1.0 - sample)*(1.0 - sample) * 2.0);\n         }\n     }\n\n     float aa = 1.0 + pow(sum, 0.3)*0.09;\n     vec3 smoothColor = centralColor.rgb*aa - vec3(sample)*(aa-1.0);// get smooth color\n     smoothColor = clamp(smoothColor,vec3(0.0),vec3(1.0));//make smooth color right\n\n     smoothColor = mix(centralColor.rgb, smoothColor, pow(centralColor.g, 0.33) * pow(centralColor.g, 0.39));\n\n     resultColor = vec4(pow(smoothColor, vec3(0.96)),1.0);\n\n     return resultColor;\n}\n\nvoid main(void) {\n    vec4 origColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 mask1 = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 mask3 = texture2D(inputImageTexture5, textureCoordinate);\n    vec4 color0 = origColor;\n    if(alpha * mask1.g > 0.01) { // 亮眼\n        vec2 step1 = vec2(0.002083, 0.0);\n        vec2 step2 = vec2(0.0, 0.001389);\n        vec3 sumColor = vec3(0.0, 0.0, 0.0);\n        for(float t = -1.0; t < 1.5; t += 1.0) {\n            for(float p = -1.0; p < 1.5; p += 1.0) {\n                sumColor += texture2D(inputImageTexture, canvasCoordinate + t * step1 + p * step2).rgb;\n            }\n        }\n        sumColor = sumColor / 9.0;\n        sumColor = clamp(sumColor + (color0.rgb - sumColor) * 3.0, 0.0, 1.0);\n        sumColor = max(color0.rgb, sumColor);\n        color0 = mix(color0, vec4(sumColor, color0.a), alpha * mask1.g);\n    }\n    if (mask1.r * wrinkles > 0.01) {  // 去皱\n        color0 = mix(color0, smoothSkin(color0), mask1.r * wrinkles);\n    }\n    if (mask3.r * wrinkles_flw > 0.01) {  // 去法令纹 \n        color0 = mix(color0, smoothSkin(color0), mask3.r * wrinkles_flw);\n    }\n    vec4 mask2 = texture2D(inputImageTexture3, textureCoordinate);\n    float contrast = 1.0;\n    if (mask2.g > 0.03) { // 眼眉加深\n        contrast += mask2.g * contrastOpacity;\n    }\n    if (smoothOpacity * (mask2.r - mask2.g) > 0.02) { // 祛眼袋\n        vec4 eyePouchSmooth = texture2D(inputImageTexture4, canvasCoordinate);\n        eyePouchSmooth = color0 + clamp(vec4(rgbLeft,1.0)-eyePouchSmooth, 0.0, 1.0);\n        float cg = (-81085.0*color0.r*255.0+112000.0*color0.g*255.0-30915.0*color0.b*255.0)/256000.0+128.0-cgcrLeft.x;\n        float cr = (-37797.0*color0.r*255.0-74203.0*color0.g*255.0+112000.0*color0.b*255.0)/256000.0+128.0-cgcrLeft.y;\n        float v = max(sqrt(cg*cg+cr*cr)-100.0, 0.0);\n        float a0 = pow(2.718281828459, -v/4.0)*smoothOpacity*mask2.r*1.0;\n        color0 = color0 + a0 * (eyePouchSmooth - color0);\n    }\n    if (smoothOpacity * (mask2.b - mask2.g) > 0.02) { // 祛眼袋\n        vec4 eyePouchSmooth = texture2D(inputImageTexture4, canvasCoordinate);\n        eyePouchSmooth = color0 + clamp(vec4(rgbRight,1.0)-eyePouchSmooth, 0.0, 1.0);\n        float cg = (-81085.0*color0.r*255.0+112000.0*color0.g*255.0-30915.0*color0.b*255.0)/256000.0+128.0-cgcrRight.x;\n        float cr = (-37797.0*color0.r*255.0-74203.0*color0.g*255.0+112000.0*color0.b*255.0)/256000.0+128.0-cgcrRight.y;\n        float v = max(sqrt(cg*cg+cr*cr)-100.0, 0.0);\n        float a0 = pow(2.718281828459, -v/4.0)*smoothOpacity*mask2.b*1.0;\n        color0 = color0 + a0 * (eyePouchSmooth - color0);\n    }\n    color0 = vec4(clamp(mix(vec3(0.5), color0.rgb, contrast), vec3(0.0), vec3(1.0)), color0.a);\n    gl_FragColor = color0;\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  private static final int faceImageHeight = 1067;
  private static final int faceImageWidth = 800;
  private float alphaValue = 0.1575F;
  private boolean isMaskImage1Ready;
  private boolean isMaskImage2Ready;
  private boolean isMaskImage3Ready;
  private FaceItem item = createFaceItem();
  private String maskImage1 = "eyemask.jpg";
  private String maskImage2 = "eyedarken.jpg";
  private String maskImage3 = "wrinkles2.jpg";
  private float smoothOpacity = 0.4F;
  private float[] texVertices = new float[1380];
  private int[] texture = new int[3];
  private float wrinkles = 0.0F;
  private float wrinklesFlw = 0.0F;
  
  public TTBeautyV5BeautyEffectCombineFilter()
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform float alpha;\nuniform float width;\nuniform float height;\nuniform float smoothOpacity;\nuniform float contrastOpacity;\nuniform float wrinkles;\nuniform float wrinkles_flw;\n// for eye pouch\nuniform vec2 cgcrLeft;\nuniform vec2 cgcrRight;\nuniform vec3 rgbLeft;\nuniform vec3 rgbRight;\n\nvec4 smoothSkin(vec4 centralColor)\n{\n     vec4 resultColor = centralColor;\n\n     float x_a = float(width);\n     float y_a = float(height);\n     float mul_x = 1.6 / x_a;\n     float mul_y = 1.6 / y_a;\n\n     vec2 blurCoordinates12 = canvasCoordinate + vec2(0.0 * mul_x,-6.0 * mul_y);\n     vec2 blurCoordinates13 = canvasCoordinate + vec2(-4.0 * mul_x,-4.0 * mul_y);\n     vec2 blurCoordinates14 = canvasCoordinate + vec2(-6.0 * mul_x,0.0 * mul_y);\n     vec2 blurCoordinates15 = canvasCoordinate + vec2(-4.0 * mul_x,4.0 * mul_y);\n     vec2 blurCoordinates16 = canvasCoordinate + vec2(0.0 * mul_x,6.0 * mul_y);\n     vec2 blurCoordinates17 = canvasCoordinate + vec2(4.0 * mul_x,4.0 * mul_y);\n     vec2 blurCoordinates18 = canvasCoordinate + vec2(6.0 * mul_x,0.0 * mul_y);\n     vec2 blurCoordinates19 = canvasCoordinate + vec2(4.0 * mul_x,-4.0 * mul_y);\n\n     float central;\n     float gaussianWeightTotal;\n     float sum;\n     float sample;\n     float distanceFromCentralColor;\n     float gaussianWeight;\n\n     float distanceNormalizationFactor = 3.6;\n\n     central = texture2D(inputImageTexture, canvasCoordinate).g;\n     gaussianWeightTotal = 0.2;\n     sum = central * 0.2;\n\n     sample = texture2D(inputImageTexture, blurCoordinates12).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates13).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates14).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates15).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates16).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates17).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates18).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sample = texture2D(inputImageTexture, blurCoordinates19).g;\n     distanceFromCentralColor = min(abs(central - sample) * distanceNormalizationFactor, 1.0);\n     gaussianWeight = 0.1 * (1.0 - distanceFromCentralColor);\n     gaussianWeightTotal += gaussianWeight;\n     sum += sample * gaussianWeight;\n\n     sum = sum/gaussianWeightTotal;\n\n     sample = centralColor.g - sum + 0.5;\n\n     for(int i = 0; i < 5; ++i) {\n         if(sample <= 0.5) {\n             sample = sample * sample * 2.0;\n         }\n         else {\n             sample = 1.0 - ((1.0 - sample)*(1.0 - sample) * 2.0);\n         }\n     }\n\n     float aa = 1.0 + pow(sum, 0.3)*0.09;\n     vec3 smoothColor = centralColor.rgb*aa - vec3(sample)*(aa-1.0);// get smooth color\n     smoothColor = clamp(smoothColor,vec3(0.0),vec3(1.0));//make smooth color right\n\n     smoothColor = mix(centralColor.rgb, smoothColor, pow(centralColor.g, 0.33) * pow(centralColor.g, 0.39));\n\n     resultColor = vec4(pow(smoothColor, vec3(0.96)),1.0);\n\n     return resultColor;\n}\n\nvoid main(void) {\n    vec4 origColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 mask1 = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 mask3 = texture2D(inputImageTexture5, textureCoordinate);\n    vec4 color0 = origColor;\n    if(alpha * mask1.g > 0.01) { // 亮眼\n        vec2 step1 = vec2(0.002083, 0.0);\n        vec2 step2 = vec2(0.0, 0.001389);\n        vec3 sumColor = vec3(0.0, 0.0, 0.0);\n        for(float t = -1.0; t < 1.5; t += 1.0) {\n            for(float p = -1.0; p < 1.5; p += 1.0) {\n                sumColor += texture2D(inputImageTexture, canvasCoordinate + t * step1 + p * step2).rgb;\n            }\n        }\n        sumColor = sumColor / 9.0;\n        sumColor = clamp(sumColor + (color0.rgb - sumColor) * 3.0, 0.0, 1.0);\n        sumColor = max(color0.rgb, sumColor);\n        color0 = mix(color0, vec4(sumColor, color0.a), alpha * mask1.g);\n    }\n    if (mask1.r * wrinkles > 0.01) {  // 去皱\n        color0 = mix(color0, smoothSkin(color0), mask1.r * wrinkles);\n    }\n    if (mask3.r * wrinkles_flw > 0.01) {  // 去法令纹 \n        color0 = mix(color0, smoothSkin(color0), mask3.r * wrinkles_flw);\n    }\n    vec4 mask2 = texture2D(inputImageTexture3, textureCoordinate);\n    float contrast = 1.0;\n    if (mask2.g > 0.03) { // 眼眉加深\n        contrast += mask2.g * contrastOpacity;\n    }\n    if (smoothOpacity * (mask2.r - mask2.g) > 0.02) { // 祛眼袋\n        vec4 eyePouchSmooth = texture2D(inputImageTexture4, canvasCoordinate);\n        eyePouchSmooth = color0 + clamp(vec4(rgbLeft,1.0)-eyePouchSmooth, 0.0, 1.0);\n        float cg = (-81085.0*color0.r*255.0+112000.0*color0.g*255.0-30915.0*color0.b*255.0)/256000.0+128.0-cgcrLeft.x;\n        float cr = (-37797.0*color0.r*255.0-74203.0*color0.g*255.0+112000.0*color0.b*255.0)/256000.0+128.0-cgcrLeft.y;\n        float v = max(sqrt(cg*cg+cr*cr)-100.0, 0.0);\n        float a0 = pow(2.718281828459, -v/4.0)*smoothOpacity*mask2.r*1.0;\n        color0 = color0 + a0 * (eyePouchSmooth - color0);\n    }\n    if (smoothOpacity * (mask2.b - mask2.g) > 0.02) { // 祛眼袋\n        vec4 eyePouchSmooth = texture2D(inputImageTexture4, canvasCoordinate);\n        eyePouchSmooth = color0 + clamp(vec4(rgbRight,1.0)-eyePouchSmooth, 0.0, 1.0);\n        float cg = (-81085.0*color0.r*255.0+112000.0*color0.g*255.0-30915.0*color0.b*255.0)/256000.0+128.0-cgcrRight.x;\n        float cr = (-37797.0*color0.r*255.0-74203.0*color0.g*255.0+112000.0*color0.b*255.0)/256000.0+128.0-cgcrRight.y;\n        float v = max(sqrt(cg*cg+cr*cr)-100.0, 0.0);\n        float a0 = pow(2.718281828459, -v/4.0)*smoothOpacity*mask2.b*1.0;\n        color0 = color0 + a0 * (eyePouchSmooth - color0);\n    }\n    color0 = vec4(clamp(mix(vec3(0.5), color0.rgb, contrast), vec3(0.0), vec3(1.0)), color0.a);\n    gl_FragColor = color0;\n}\n");
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
    Bitmap localBitmap;
    if ((!this.isMaskImage1Ready) && (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.maskImage1))))
    {
      localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.maskImage1);
      GlUtil.loadTexture(this.texture[0], localBitmap);
      initFaceTexCoords();
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
      this.isMaskImage1Ready = true;
    }
    if ((!this.isMaskImage2Ready) && (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.maskImage2))))
    {
      localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.maskImage2);
      GlUtil.loadTexture(this.texture[1], localBitmap);
      addParam(new UniformParam.TextureParam("inputImageTexture3", this.texture[1], 33987));
      this.isMaskImage2Ready = true;
    }
    if ((!this.isMaskImage3Ready) && (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.maskImage3))))
    {
      localBitmap = VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.maskImage3);
      GlUtil.loadTexture(this.texture[2], localBitmap);
      addParam(new UniformParam.TextureParam("inputImageTexture5", this.texture[2], 33989));
      this.isMaskImage3Ready = true;
    }
  }
  
  private void initFaceTexCoords()
  {
    addAttribParam("inputTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.item.facePoints), 5.0F), 800, 1067, this.texVertices), true);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    int[] arrayOfInt = this.texture;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
  }
  
  public void clearGLSLSelf()
  {
    int[] arrayOfInt = this.texture;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.isMaskImage1Ready = false;
    this.isMaskImage2Ready = false;
    this.isMaskImage3Ready = false;
    super.clearGLSLSelf();
  }
  
  public float getSmoothOpacity()
  {
    return this.smoothOpacity;
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
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
    addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
    addParam(new UniformParam.FloatParam("alpha", this.alphaValue));
    addParam(new UniformParam.FloatParam("width", 0.0F));
    addParam(new UniformParam.FloatParam("height", 0.0F));
    addParam(new UniformParam.FloatParam("smoothOpacity", this.smoothOpacity));
    addParam(new UniformParam.FloatParam("wrinkles", this.wrinkles));
    addParam(new UniformParam.FloatParam("wrinkles_flw", this.wrinklesFlw));
    addParam(new UniformParam.FloatParam("contrastOpacity", 0.03F));
    addParam(new UniformParam.FloatsParam("cgcrLeft", new float[] { 0.0F, 0.0F }));
    addParam(new UniformParam.FloatsParam("cgcrRight", new float[] { 0.0F, 0.0F }));
    addParam(new UniformParam.FloatsParam("rgbLeft", new float[] { 0.0F, 0.0F, 0.0F }));
    addParam(new UniformParam.FloatsParam("rgbRight", new float[] { 0.0F, 0.0F, 0.0F }));
  }
  
  public boolean needRender()
  {
    updateTextureParams();
    return (this.isMaskImage1Ready) && (this.isMaskImage2Ready) && (this.isMaskImage3Ready) && ((this.alphaValue > 0.01F) || (this.smoothOpacity > 0.01F) || (this.wrinkles > 0.01F) || (this.wrinklesFlw > 0.01F));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AttributeParam localAttributeParam = getAttribParam("position");
    if (localAttributeParam != null)
    {
      if (localAttributeParam.vertices.length / localAttributeParam.perVertexFloat != 690) {
        return false;
      }
      localAttributeParam = getAttribParam("inputTextureCoordinate");
      if (localAttributeParam != null)
      {
        if (localAttributeParam.vertices.length / localAttributeParam.perVertexFloat != 690) {
          return false;
        }
        return super.renderTexture(paramInt1, paramInt2, paramInt3);
      }
    }
    return false;
  }
  
  public void setAlphaValue(float paramFloat)
  {
    this.alphaValue = (paramFloat * 0.45F);
    addParam(new UniformParam.FloatParam("alpha", this.alphaValue));
  }
  
  public void setEyePouchSmoothImage(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture4", paramInt, 33988));
  }
  
  public void setSmoothOpacity(float paramFloat) {}
  
  public void setWrinkles(float paramFloat)
  {
    this.wrinkles = paramFloat;
    addParam(new UniformParam.FloatParam("wrinkles", this.wrinkles));
  }
  
  public void setWrinkles_flw(float paramFloat)
  {
    this.wrinklesFlw = paramFloat;
    addParam(new UniformParam.FloatParam("wrinkles_flw", this.wrinklesFlw));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV5BeautyEffectCombineFilter
 * JD-Core Version:    0.7.0.1
 */