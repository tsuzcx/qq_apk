package com.tencent.ttpic.filter;

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
import com.tencent.ttpic.openapi.filter.FaceFeatureParam;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.List;

public class FaceFeatureAndTeethWhitenFilterV2
  extends VideoFilterBase
{
  private static final String CONTENT = "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n  {\n    \"faceExchangeImage\": \"beauty_normal.png\",\n    \"blendAlpha\":1.0,\n    \"featureType\": 0,\n    \"grayScale\": 0,\n\t\"blendMode\": 1,\n\t\"facePoints\": [\n156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n    ]\n  },\n  {\n    \"faceExchangeImage\": \"beauty_normal.png\",\n    \"blendAlpha\":1.0,\n    \"featureType\": 0,\n    \"grayScale\": 0,\n  \"blendMode\": 1,\n  \"facePoints\": [\n156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  316.7892813733, 740.1230207274,\n  482.1595615246, 740.1741778528,\n  335.2009744312, 773.4835566598999,\n  364.4336175502, 789.0742996567,\n  399.51278929299997, 796.8696711550999,\n  434.5919610358, 788.0998782194,\n  464.7990255921, 771.5347137853,\n  436.38733253419997, 766.6626065987999,\n  400.4616321676, 771.5347137853,\n  362.7405603026, 766.6626065987999,\n  346.8940316788, 716.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 710.2764921035999,\n  454.08038978179997, 716.2764921035999,\n  436.38733253419997, 733.8416565377,\n  400.4872107303, 735.7904994122999,\n  362.6894031772, 733.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n    ]\n  }\n  \n  ]\n}\n\n";
  private static final String FOLDER = "assets://realtimeBeauty";
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate; // facefeature \nvarying vec2 textureCoordinate2; // lips \n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\n\nuniform float alphaNormal;\nuniform float alphaMultiply;\nuniform float alphaSoftlight;\nuniform float alphaNormal2;\nuniform float toothWhiten;\nuniform float alphaLips;\nuniform float alphaMixLips;\n\nvec4 blendColor6(vec4 texColor, vec4 canvasColor)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n    if (texColor.r >= 0.5) {\n       resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n    }\n    if (texColor.g >= 0.5) {\n        resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n    }\n    if (texColor.b >= 0.5) {\n        resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n    resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n    return resultColor;\n}\n\nvec4 blendColor2(vec4 texColor, vec4 canvasColor)\n{\n    vec4 resultColor = vec4(canvasColor.rgb * texColor.rgb, texColor.a);\n    resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n    return resultColor;\n}\n\nvec4 blendColor1(vec4 texColor, vec4 canvasColor)\n{\n    vec4 resultColor = vec4(texColor.rgb * 1.0 + canvasColor.rgb * (1.0 - texColor.a), 1.0);\n    return resultColor;\n}\n\nvec3 lut(vec4 inputColor, sampler2D lutTexture) {\n  mediump vec2 quad1;\n  mediump vec2 quad2;\n  mediump vec2 texPos1;\n  mediump vec2 texPos2;\n  mediump float blueColor = inputColor.b * 63.0;\n  quad1.y = floor(floor(blueColor) / 8.0);\n  quad1.x = floor(blueColor) - (quad1.y * 8.0);\n  quad2.y = floor(ceil(blueColor)  / 8.0);\n  quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n  texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  lowp vec3 newColor1 = texture2D(lutTexture, texPos1).rgb;\n  lowp vec3 newColor2 = texture2D(lutTexture, texPos2).rgb;\n  return mix(newColor1, newColor2, fract(blueColor));\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 softLightTexColor = texture2D(inputImageTexture2, clamp(textureCoordinate * 0.5, vec2(0.0), vec2(0.5)) + vec2(0.5, 0.0));\n    vec4 multiplyTexColor = texture2D(inputImageTexture2, clamp(textureCoordinate * 0.5, vec2(0.0), vec2(0.5)));\n    vec4 normalTexColor = texture2D(inputImageTexture2, clamp(textureCoordinate * 0.5, vec2(0.0), vec2(0.5)) + vec2(0.0, 0.5));\n    vec4 normalTexColor2 = texture2D(inputImageTexture2, clamp(textureCoordinate * 0.5, vec2(0.0), vec2(0.5)) + vec2(0.5, 0.5));\n    vec4 toothLipsMaskColor = texture2D(inputImageTexture3, textureCoordinate2);\n    \n    vec4 resultColor = canvasColor;\n    if (toothWhiten * toothLipsMaskColor.b > 0.01) {\n      resultColor = vec4(mix(resultColor.rgb, lut(resultColor, inputImageTexture4), toothWhiten * toothLipsMaskColor.b), resultColor.a);\n    }\n    float lipsMaskAlpha = mix(toothLipsMaskColor.g, toothLipsMaskColor.r, alphaMixLips); \n    if (alphaLips * lipsMaskAlpha > 0.01) {\n      resultColor = vec4(mix(resultColor.rgb, lut(resultColor, inputImageTexture5), alphaLips * lipsMaskAlpha), resultColor.a);\n    }\n\n    softLightTexColor = softLightTexColor * alphaSoftlight;\n    multiplyTexColor = multiplyTexColor * alphaMultiply;\n    normalTexColor = normalTexColor * alphaNormal;\n    normalTexColor2 = normalTexColor2 * alphaNormal2;\n\n    \n    if (softLightTexColor.a > 0.01) {\n      resultColor = blendColor6(softLightTexColor, resultColor);\n    }\n    if (multiplyTexColor.a > 0.01) {\n      resultColor = blendColor2(multiplyTexColor, resultColor);\n    }\n    if (normalTexColor.a > 0.01) {\n      resultColor = blendColor1(normalTexColor, resultColor);\n    }\n    if (normalTexColor2.a > 0.01) {\n      resultColor = blendColor1(normalTexColor2, resultColor);\n    }\n\n    gl_FragColor = resultColor;\n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate; // facefeature \nattribute vec2 inputTextureCoordinate2; // lips \nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate; // facefeature \nvarying vec2 textureCoordinate2; // lips \n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    textureCoordinate2 = inputTextureCoordinate2;\n}\n";
  private static final int faceImageHeight = 1067;
  private static final int faceImageWidth = 800;
  public static final String toothLipsMask = "lipsMask.png";
  public static final String toothLut = "teeth.png";
  private float alphaLips = 0.0F;
  private double alphaMouthCloseRatio = 0.0D;
  private float alphaMultiply = 0.8F;
  private float alphaNormal = 0.8F;
  private float alphaNormal2 = 0.0F;
  private float alphaSoftlight = 0.8F;
  private float alphaToothWhiten = 0.0F;
  private float factorNormal = 1.0F;
  private boolean isMergeImageReady;
  private boolean isToothWhitenLutReady;
  private boolean isToothWhitenMaskReady;
  private FaceItem item;
  private FaceItem item2;
  private String mergeImage = "beauty_common_merge.png";
  private float[] texVertices = new float[1380];
  private float[] texVertices2 = new float[1380];
  private int[] texture = new int[3];
  
  public FaceFeatureAndTeethWhitenFilterV2()
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate; // facefeature \nattribute vec2 inputTextureCoordinate2; // lips \nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate; // facefeature \nvarying vec2 textureCoordinate2; // lips \n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n    textureCoordinate2 = inputTextureCoordinate2;\n}\n", "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate; // facefeature \nvarying vec2 textureCoordinate2; // lips \n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\n\nuniform float alphaNormal;\nuniform float alphaMultiply;\nuniform float alphaSoftlight;\nuniform float alphaNormal2;\nuniform float toothWhiten;\nuniform float alphaLips;\nuniform float alphaMixLips;\n\nvec4 blendColor6(vec4 texColor, vec4 canvasColor)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n    if (texColor.r >= 0.5) {\n       resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n    }\n    if (texColor.g >= 0.5) {\n        resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n    }\n    if (texColor.b >= 0.5) {\n        resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n    resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n    return resultColor;\n}\n\nvec4 blendColor2(vec4 texColor, vec4 canvasColor)\n{\n    vec4 resultColor = vec4(canvasColor.rgb * texColor.rgb, texColor.a);\n    resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n    return resultColor;\n}\n\nvec4 blendColor1(vec4 texColor, vec4 canvasColor)\n{\n    vec4 resultColor = vec4(texColor.rgb * 1.0 + canvasColor.rgb * (1.0 - texColor.a), 1.0);\n    return resultColor;\n}\n\nvec3 lut(vec4 inputColor, sampler2D lutTexture) {\n  mediump vec2 quad1;\n  mediump vec2 quad2;\n  mediump vec2 texPos1;\n  mediump vec2 texPos2;\n  mediump float blueColor = inputColor.b * 63.0;\n  quad1.y = floor(floor(blueColor) / 8.0);\n  quad1.x = floor(blueColor) - (quad1.y * 8.0);\n  quad2.y = floor(ceil(blueColor)  / 8.0);\n  quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n  texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  lowp vec3 newColor1 = texture2D(lutTexture, texPos1).rgb;\n  lowp vec3 newColor2 = texture2D(lutTexture, texPos2).rgb;\n  return mix(newColor1, newColor2, fract(blueColor));\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 softLightTexColor = texture2D(inputImageTexture2, clamp(textureCoordinate * 0.5, vec2(0.0), vec2(0.5)) + vec2(0.5, 0.0));\n    vec4 multiplyTexColor = texture2D(inputImageTexture2, clamp(textureCoordinate * 0.5, vec2(0.0), vec2(0.5)));\n    vec4 normalTexColor = texture2D(inputImageTexture2, clamp(textureCoordinate * 0.5, vec2(0.0), vec2(0.5)) + vec2(0.0, 0.5));\n    vec4 normalTexColor2 = texture2D(inputImageTexture2, clamp(textureCoordinate * 0.5, vec2(0.0), vec2(0.5)) + vec2(0.5, 0.5));\n    vec4 toothLipsMaskColor = texture2D(inputImageTexture3, textureCoordinate2);\n    \n    vec4 resultColor = canvasColor;\n    if (toothWhiten * toothLipsMaskColor.b > 0.01) {\n      resultColor = vec4(mix(resultColor.rgb, lut(resultColor, inputImageTexture4), toothWhiten * toothLipsMaskColor.b), resultColor.a);\n    }\n    float lipsMaskAlpha = mix(toothLipsMaskColor.g, toothLipsMaskColor.r, alphaMixLips); \n    if (alphaLips * lipsMaskAlpha > 0.01) {\n      resultColor = vec4(mix(resultColor.rgb, lut(resultColor, inputImageTexture5), alphaLips * lipsMaskAlpha), resultColor.a);\n    }\n\n    softLightTexColor = softLightTexColor * alphaSoftlight;\n    multiplyTexColor = multiplyTexColor * alphaMultiply;\n    normalTexColor = normalTexColor * alphaNormal;\n    normalTexColor2 = normalTexColor2 * alphaNormal2;\n\n    \n    if (softLightTexColor.a > 0.01) {\n      resultColor = blendColor6(softLightTexColor, resultColor);\n    }\n    if (multiplyTexColor.a > 0.01) {\n      resultColor = blendColor2(multiplyTexColor, resultColor);\n    }\n    if (normalTexColor.a > 0.01) {\n      resultColor = blendColor1(normalTexColor, resultColor);\n    }\n    if (normalTexColor2.a > 0.01) {\n      resultColor = blendColor1(normalTexColor2, resultColor);\n    }\n\n    gl_FragColor = resultColor;\n }\n");
    createFaceItem();
    this.dataPath = "assets://realtimeBeauty";
    initParams();
    setCoordNum(690);
    setRenderMode(1);
  }
  
  private void createFaceItem()
  {
    VideoMaterial localVideoMaterial = VideoTemplateParser.parseVideoMaterial("assets://realtimeBeauty", "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n  {\n    \"faceExchangeImage\": \"beauty_normal.png\",\n    \"blendAlpha\":1.0,\n    \"featureType\": 0,\n    \"grayScale\": 0,\n\t\"blendMode\": 1,\n\t\"facePoints\": [\n156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n    ]\n  },\n  {\n    \"faceExchangeImage\": \"beauty_normal.png\",\n    \"blendAlpha\":1.0,\n    \"featureType\": 0,\n    \"grayScale\": 0,\n  \"blendMode\": 1,\n  \"facePoints\": [\n156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  316.7892813733, 740.1230207274,\n  482.1595615246, 740.1741778528,\n  335.2009744312, 773.4835566598999,\n  364.4336175502, 789.0742996567,\n  399.51278929299997, 796.8696711550999,\n  434.5919610358, 788.0998782194,\n  464.7990255921, 771.5347137853,\n  436.38733253419997, 766.6626065987999,\n  400.4616321676, 771.5347137853,\n  362.7405603026, 766.6626065987999,\n  346.8940316788, 716.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 710.2764921035999,\n  454.08038978179997, 716.2764921035999,\n  436.38733253419997, 733.8416565377,\n  400.4872107303, 735.7904994122999,\n  362.6894031772, 733.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n    ]\n  }\n  \n  ]\n}\n\n", null);
    this.item = ((FaceItem)localVideoMaterial.getFaceOffItemList().get(0));
    this.item2 = ((FaceItem)localVideoMaterial.getFaceOffItemList().get(1));
  }
  
  private void initFaceImage()
  {
    if ((!this.isMergeImageReady) && (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.mergeImage))))
    {
      GlUtil.loadTexture(this.texture[0], VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.mergeImage));
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
      this.isMergeImageReady = true;
    }
    if ((!this.isToothWhitenMaskReady) && (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap("lipsMask.png"))))
    {
      GlUtil.loadTexture(this.texture[1], VideoMemoryManager.getInstance().getBeautyCacheBitmap("lipsMask.png"));
      addParam(new UniformParam.TextureParam("inputImageTexture3", this.texture[1], 33987));
      this.isToothWhitenMaskReady = true;
    }
    if ((!this.isToothWhitenLutReady) && (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap("teeth.png"))))
    {
      GlUtil.loadTexture(this.texture[2], VideoMemoryManager.getInstance().getBeautyCacheBitmap("teeth.png"));
      addParam(new UniformParam.TextureParam("inputImageTexture4", this.texture[2], 33988));
      this.isToothWhitenLutReady = true;
    }
  }
  
  private void initFaceTexCoords()
  {
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.item.facePoints), 5.0F), 800, 1067, this.texVertices));
  }
  
  private void initFaceTexCoords2()
  {
    addAttribParam("inputTextureCoordinate2", FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.item2.facePoints), 5.0F), 800, 1067, this.texVertices2));
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.texture.length, this.texture, 0);
  }
  
  public void clearGLSLSelf()
  {
    GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
    this.isMergeImageReady = false;
    this.isToothWhitenMaskReady = false;
    this.isToothWhitenLutReady = false;
    super.clearGLSLSelf();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    initFaceTexCoords();
    initFaceTexCoords2();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
    addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
    addParam(new UniformParam.FloatParam("alphaNormal", this.alphaNormal * this.factorNormal));
    addParam(new UniformParam.FloatParam("alphaNormal2", this.alphaNormal2 * this.factorNormal));
    addParam(new UniformParam.FloatParam("alphaMultiply", this.alphaMultiply));
    addParam(new UniformParam.FloatParam("alphaSoftlight", this.alphaSoftlight));
    addParam(new UniformParam.FloatParam("toothWhiten", (float)(this.alphaToothWhiten * this.alphaMouthCloseRatio)));
    addParam(new UniformParam.FloatParam("alphaLips", this.alphaLips));
    addParam(new UniformParam.FloatParam("alphaMixLips", 0.0F));
  }
  
  public boolean needRender()
  {
    updateTextureParams();
    return (this.isMergeImageReady) && (this.isToothWhitenLutReady) && (this.isToothWhitenMaskReady) && ((this.alphaMultiply > 0.01F) || (this.alphaSoftlight > 0.01F) || (this.alphaNormal * this.factorNormal > 0.01F) || (this.alphaNormal2 * this.factorNormal > 0.01F) || (this.alphaToothWhiten > 0.01F) || (this.alphaLips > 0.01F));
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
  
  public void resetCosDefaultEffect()
  {
    setNormalAlphaValue(0.8F);
    setNormal2AlphaValue(0.8F);
    setSoftlightAlphaValue(0.8F);
    setMultiplyAlphaValue(0.8F);
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    this.alphaNormal = paramFaceFeatureParam.faceFeatureNormalAdjustValue;
    this.alphaMultiply = paramFaceFeatureParam.faceFeatureMultiplyAdjustValue;
    this.alphaSoftlight = paramFaceFeatureParam.faceFeatureSoftlightAdjustValue;
    this.alphaNormal2 = paramFaceFeatureParam.faceFeatureNormal2AdjustValue;
    addParam(new UniformParam.FloatParam("alphaNormal", this.alphaNormal * this.factorNormal));
    addParam(new UniformParam.FloatParam("alphaNormal2", this.alphaNormal2 * this.factorNormal));
    addParam(new UniformParam.FloatParam("alphaMultiply", this.alphaMultiply));
    addParam(new UniformParam.FloatParam("alphaSoftlight", this.alphaSoftlight));
    this.isMergeImageReady = false;
    this.mergeImage = paramFaceFeatureParam.faceFeatureMergeImage;
    initFaceImage();
  }
  
  public void setLipsLutAlpha(int paramInt)
  {
    this.alphaLips = (paramInt / 100.0F);
    addParam(new UniformParam.FloatParam("alphaLips", this.alphaLips));
  }
  
  public void setLipsLutTexture(int paramInt)
  {
    if (paramInt > 0)
    {
      addParam(new UniformParam.TextureParam("inputImageTexture5", paramInt, 33989));
      return;
    }
    addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
    setLipsLutAlpha(0);
  }
  
  public void setMultiplyAlphaValue(float paramFloat)
  {
    this.alphaMultiply = paramFloat;
    addParam(new UniformParam.FloatParam("alphaMultiply", this.alphaMultiply));
  }
  
  public void setNormal2AlphaValue(float paramFloat)
  {
    this.alphaNormal2 = paramFloat;
    addParam(new UniformParam.FloatParam("alphaNormal2", this.alphaNormal2 * this.factorNormal));
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    this.factorNormal = paramFloat;
    setNormalAlphaValue(this.alphaNormal);
    setNormal2AlphaValue(this.alphaNormal2);
  }
  
  public void setNormalAlphaValue(float paramFloat)
  {
    this.alphaNormal = paramFloat;
    addParam(new UniformParam.FloatParam("alphaNormal", this.alphaNormal * this.factorNormal));
  }
  
  public void setSoftlightAlphaValue(float paramFloat)
  {
    this.alphaSoftlight = paramFloat;
    addParam(new UniformParam.FloatParam("alphaSoftlight", this.alphaSoftlight));
  }
  
  public void setToothWhitenAlphaValue(float paramFloat)
  {
    this.alphaToothWhiten = (0.5F * paramFloat);
    addParam(new UniformParam.FloatParam("toothWhiten", (float)(this.alphaToothWhiten * this.alphaMouthCloseRatio)));
  }
  
  public void updateParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    setPositions(paramArrayOfFloat);
    updatePointParams(paramList);
    updateTextureParams();
  }
  
  public void updatePointParams(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.alphaMouthCloseRatio = ((AlgoUtils.getDistance((PointF)paramList.get(81), (PointF)paramList.get(73)) / this.mFaceDetScale - 10.0D) / 20.0D);
    this.alphaMouthCloseRatio = Math.max(Math.min(this.alphaMouthCloseRatio, 1.0D), 0.0D);
    addParam(new UniformParam.FloatParam("toothWhiten", (float)(this.alphaToothWhiten * this.alphaMouthCloseRatio)));
    float f1 = AlgoUtils.getDistance((PointF)paramList.get(65), (PointF)paramList.get(66));
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(73), (PointF)paramList.get(81));
    if (f1 <= 0.0F)
    {
      addParam(new UniformParam.FloatParam("alphaMixLips", 0.0F));
      return;
    }
    addParam(new UniformParam.FloatParam("alphaMixLips", Math.max(0.0F, Math.min(1.0F, (f2 - f1 * 0.1F) / (f1 * 0.1F)))));
  }
  
  public void updateTextureParams()
  {
    initFaceImage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceFeatureAndTeethWhitenFilterV2
 * JD-Core Version:    0.7.0.1
 */