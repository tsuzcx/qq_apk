package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.FaceOffUtil;
import java.util.List;

public class TTBeautyV5FaceFeatureFilter
  extends VideoFilterBase
{
  private static final String CONTENT = "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n  {\n    \"faceExchangeImage\": \"beauty_normal.png\",\n    \"blendAlpha\":1.0,\n    \"featureType\": 0,\n    \"grayScale\": 0,\n\t\"blendMode\": 1,\n\t\"facePoints\": [\n156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n    ]\n  }\n  \n  ]\n}\n\n";
  private static final String FOLDER = "assets://realtimeBeauty";
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\n\nuniform float alphaNormal;\nuniform float alphaMultiply;\nuniform float alphaSoftlight;\n\nvec4 blendColor6(vec4 texColor, vec4 canvasColor)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n    if (texColor.r >= 0.5) {\n       resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n    }\n    if (texColor.g >= 0.5) {\n        resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n    }\n    if (texColor.b >= 0.5) {\n        resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n\n    resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n\n    return resultColor;\n}\n\nvec4 blendColor2(vec4 texColor, vec4 canvasColor)\n{\n    vec4 resultColor = vec4(canvasColor.rgb * texColor.rgb, texColor.a);\n    resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n    return resultColor;\n}\n\nvec4 blendColor1(vec4 texColor, vec4 canvasColor)\n{\n    vec4 resultColor = vec4(texColor.rgb * 1.0 + canvasColor.rgb * (1.0 - texColor.a), 1.0);\n    return resultColor;\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 softLightTexColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 multiplyTexColor = texture2D(inputImageTexture3, textureCoordinate);\n    vec4 normalTexColor = texture2D(inputImageTexture4, textureCoordinate);\n\n    softLightTexColor = softLightTexColor * alphaSoftlight;\n    multiplyTexColor = multiplyTexColor * alphaMultiply;\n    normalTexColor = normalTexColor * alphaNormal;\n\n    vec4 resultColor = canvasColor;\n    if (softLightTexColor.a > 0.01) {\n      resultColor = blendColor6(softLightTexColor, resultColor);\n    }\n    if (multiplyTexColor.a > 0.01) {\n      resultColor = blendColor2(multiplyTexColor, resultColor);\n    }\n    if (normalTexColor.a > 0.01) {\n      resultColor = blendColor1(normalTexColor, resultColor);\n    }\n\n    gl_FragColor = resultColor;\n }\n";
  public static final String VERTEX_SHADER = "mee295x1920234593x1953849961x1702240357x1881158755x1953067887x997093225x1953784074x1969383794x1981834612x540173157x1970302569x2019906676x1701999988x1919905603x1634625892x171664756x2037539190x543649385x845374838x1851876128x1131635062x1685221231x1952542313x1980382053x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x168442725x1684631414x1767992608x2066294894x538976266x1600939808x1769172816x1852795252x1881160992x1953067887x997093225x538976266x1851876128x1131635062x1685221231x1952542313x540876901x845374838x1936683048x1869182057x544747118x774905898x539697205x741682736x1936683040x1869182057x544812654x774905898x539697205x691351088x538970683x1702109216x1920300152x1869562725x1852400754x543519841x1852383293x1416918384x1970567269x1866687858x1768190575x1702125934x8194619x";
  private float alphaMultiply = 0.8F;
  private float alphaNormal = 0.8F;
  private float alphaSoftlight = 0.8F;
  private int faceImageHeight = 1067;
  private int faceImageWidth = 800;
  private float factorNormal = 1.0F;
  private boolean isMultiplyImageReady;
  private boolean isNormalImageReady;
  private boolean isSoftLiteImageReady;
  private FaceItem item = createFaceItem();
  private String multiplyImage = "beauty_multiply.png";
  private String normalImage = "beauty_normal.png";
  private String softlightImage = "beauty_softlight.png";
  private float[] texVertices = new float[1380];
  private int[] texture = new int[3];
  
  public TTBeautyV5FaceFeatureFilter()
  {
    super(BaseFilter.nativeDecrypt("mee295x1920234593x1953849961x1702240357x1881158755x1953067887x997093225x1953784074x1969383794x1981834612x540173157x1970302569x2019906676x1701999988x1919905603x1634625892x171664756x2037539190x543649385x845374838x1851876128x1131635062x1685221231x1952542313x1980382053x1769566817x1981835118x540173157x1954047348x1130721909x1685221231x1952542313x168442725x1684631414x1767992608x2066294894x538976266x1600939808x1769172816x1852795252x1881160992x1953067887x997093225x538976266x1851876128x1131635062x1685221231x1952542313x540876901x845374838x1936683048x1869182057x544747118x774905898x539697205x741682736x1936683040x1869182057x544812654x774905898x539697205x691351088x538970683x1702109216x1920300152x1869562725x1852400754x543519841x1852383293x1416918384x1970567269x1866687858x1768190575x1702125934x8194619x"), BaseFilter.nativeDecrypt("precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\n\nuniform float alphaNormal;\nuniform float alphaMultiply;\nuniform float alphaSoftlight;\n\nvec4 blendColor6(vec4 texColor, vec4 canvasColor)\n{\n    vec3 vOne = vec3(1.0, 1.0, 1.0);\n    vec3 vZero = vec3(0.0, 0.0, 0.0);\n    //revert pre multiply\n    if(texColor.a > 0.0){\n       texColor.rgb = texColor.rgb / texColor.a;\n    }\n    vec3 resultFore = texColor.rgb;\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n    if (texColor.r >= 0.5) {\n       resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n    }\n    if (texColor.g >= 0.5) {\n        resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n    }\n    if (texColor.b >= 0.5) {\n        resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n    }\n    //pre multiply for glBlendFunc\n    vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n\n    resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n\n    return resultColor;\n}\n\nvec4 blendColor2(vec4 texColor, vec4 canvasColor)\n{\n    vec4 resultColor = vec4(canvasColor.rgb * texColor.rgb, texColor.a);\n    resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n    return resultColor;\n}\n\nvec4 blendColor1(vec4 texColor, vec4 canvasColor)\n{\n    vec4 resultColor = vec4(texColor.rgb * 1.0 + canvasColor.rgb * (1.0 - texColor.a), 1.0);\n    return resultColor;\n}\n\nvoid main(void) {\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 softLightTexColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 multiplyTexColor = texture2D(inputImageTexture3, textureCoordinate);\n    vec4 normalTexColor = texture2D(inputImageTexture4, textureCoordinate);\n\n    softLightTexColor = softLightTexColor * alphaSoftlight;\n    multiplyTexColor = multiplyTexColor * alphaMultiply;\n    normalTexColor = normalTexColor * alphaNormal;\n\n    vec4 resultColor = canvasColor;\n    if (softLightTexColor.a > 0.01) {\n      resultColor = blendColor6(softLightTexColor, resultColor);\n    }\n    if (multiplyTexColor.a > 0.01) {\n      resultColor = blendColor2(multiplyTexColor, resultColor);\n    }\n    if (normalTexColor.a > 0.01) {\n      resultColor = blendColor1(normalTexColor, resultColor);\n    }\n\n    gl_FragColor = resultColor;\n }\n"));
    this.dataPath = "assets://realtimeBeauty";
    initParams();
    setCoordNum(690);
    setRenderMode(1);
  }
  
  private FaceItem createFaceItem()
  {
    return (FaceItem)VideoTemplateParser.parseVideoMaterial("assets://realtimeBeauty", "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n  {\n    \"faceExchangeImage\": \"beauty_normal.png\",\n    \"blendAlpha\":1.0,\n    \"featureType\": 0,\n    \"grayScale\": 0,\n\t\"blendMode\": 1,\n\t\"facePoints\": [\n156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n    ]\n  }\n  \n  ]\n}\n\n", null).getFaceOffItemList().get(0);
  }
  
  private boolean initFaceImage()
  {
    if (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.softlightImage)))
    {
      if (!this.isSoftLiteImageReady)
      {
        GlUtil.loadTexture(this.texture[0], VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.softlightImage));
        this.isSoftLiteImageReady = true;
      }
      initFaceTexCoords();
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
    }
    if (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.multiplyImage)))
    {
      if (!this.isMultiplyImageReady)
      {
        GlUtil.loadTexture(this.texture[1], VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.multiplyImage));
        this.isMultiplyImageReady = true;
      }
      addParam(new UniformParam.TextureParam("inputImageTexture3", this.texture[1], 33987));
    }
    if (BitmapUtils.isLegal(VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.normalImage)))
    {
      if (!this.isNormalImageReady)
      {
        GlUtil.loadTexture(this.texture[2], VideoMemoryManager.getInstance().getBeautyCacheBitmap(this.normalImage));
        this.isNormalImageReady = true;
      }
      addParam(new UniformParam.TextureParam("inputImageTexture4", this.texture[2], 33988));
    }
    return (this.isSoftLiteImageReady) && (this.isMultiplyImageReady) && (this.isNormalImageReady);
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
    this.isSoftLiteImageReady = false;
    this.isMultiplyImageReady = false;
    this.isNormalImageReady = false;
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
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
    addParam(new UniformParam.FloatParam("alphaNormal", this.alphaNormal * this.factorNormal));
    addParam(new UniformParam.FloatParam("alphaMultiply", this.alphaMultiply));
    addParam(new UniformParam.FloatParam("alphaSoftlight", this.alphaSoftlight));
  }
  
  public boolean needRender()
  {
    updateTextureParams();
    return (this.isSoftLiteImageReady) && (this.isMultiplyImageReady) && (this.isNormalImageReady);
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
    setMultiplyAlphaValue(0.8F);
    setSoftlightAlphaValue(0.8F);
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    this.alphaNormal = paramFaceFeatureParam.faceFeatureNormalAdjustValue;
    this.alphaMultiply = paramFaceFeatureParam.faceFeatureMultiplyAdjustValue;
    this.alphaSoftlight = paramFaceFeatureParam.faceFeatureSoftlightAdjustValue;
    addParam(new UniformParam.FloatParam("alphaNormal", this.alphaNormal * this.factorNormal));
    addParam(new UniformParam.FloatParam("alphaMultiply", this.alphaMultiply));
    addParam(new UniformParam.FloatParam("alphaSoftlight", this.alphaSoftlight));
    if ((this.normalImage == null) || (!this.normalImage.equals(paramFaceFeatureParam.faceFeatureNormalImage)))
    {
      this.isNormalImageReady = false;
      this.normalImage = paramFaceFeatureParam.faceFeatureNormalImage;
    }
    if ((this.softlightImage == null) || (!this.softlightImage.equals(paramFaceFeatureParam.faceFeatureSoftlightImage)))
    {
      this.isSoftLiteImageReady = false;
      this.softlightImage = paramFaceFeatureParam.faceFeatureSoftlightImage;
    }
    if ((this.multiplyImage == null) || (!this.multiplyImage.equals(paramFaceFeatureParam.faceFeatureMultiplyImage)))
    {
      this.isMultiplyImageReady = false;
      this.multiplyImage = paramFaceFeatureParam.faceFeatureMultiplyImage;
    }
    initFaceImage();
  }
  
  public void setMultiplyAlphaValue(float paramFloat)
  {
    this.alphaMultiply = paramFloat;
    addParam(new UniformParam.FloatParam("alphaMultiply", this.alphaMultiply));
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    this.factorNormal = paramFloat;
    setNormalAlphaValue(this.alphaNormal);
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
  
  public void updateParam(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat, true);
    updateTextureParams();
  }
  
  public void updateTextureParams()
  {
    initFaceImage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV5FaceFeatureFilter
 * JD-Core Version:    0.7.0.1
 */