package com.tencent.ttpic.filter;

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
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import java.io.File;
import java.util.List;

public class EyeLightenAndPounchFilterReshape
  extends VideoFilterBase
{
  private static final String CONTENT = "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n    {\n      \"faceExchangeImage\": \"eyelightenmask.png\",\n      \"blendAlpha\":1.0,\n      \"featureType\": 0,\n      \"grayScale\": 0,\n      \"blendMode\": 0,\n      \"facePoints\": [\n  156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n      ]\n    }\n  ],\n  \"itemList\": [\n    {\n      \"id\": \"kangxi\",\n      \"frameDuration\": 0,\n      \"frames\": 1,\n      \"height\": 960,\n      \"width\": 720,\n      \"triggerType\": 2,\n      \"playCount\": 0,\n      \"alwaysTriggered\": 1,\n      \"type\": 1,\n      \"position\": [\n        0,\n        0\n      ]\n    }\n  ]\n}\n\n";
  private static final String FOLDER = "assets://realtimeBeauty";
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform float alpha;\nuniform vec2 size;\nuniform vec2 center1;\nuniform vec2 center2;\nuniform float radius1;\nuniform float radius2;\nuniform float width;\nuniform float height;\nuniform float smoothOpacity;\nuniform float contrastOpacity;\nuniform float enhance;\n\nfloat my_smoothstep(float edge0, float edge1, float x) {\n    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\n    return t * t * (3.0 - 2.0 * t);\n}\n\nvoid main(void) {\n    vec4 origColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 color0 = origColor;\n    if (texColor.a <= 0.01) {\n        color0 = vec4(origColor.rgb, 1.0);\n    } else {\n        vec2 curPos = vec2(canvasCoordinate.x * size.x, canvasCoordinate.y * size.y);\n        vec2 step1 = vec2(0.00208, 0.0);\n        vec2 step2 = vec2(0.0, 0.001388);\n        float p = 0.0;\n        float t = 0.0;\n        vec3 sumColor = vec3(0.0, 0.0, 0.0);\n        for(t = -2.0; t < 2.5; t += 1.0) {\n            for(p = -2.0; p < 2.5; p += 1.0) {\n                sumColor += texture2D(inputImageTexture, canvasCoordinate + t * step1 + p * step2).rgb;\n            }\n        }\n        sumColor = sumColor * 0.04;\n        sumColor = clamp(sumColor + (origColor.rgb - sumColor) * 2.8, 0.0, 1.0);\n        sumColor = max(origColor.rgb, sumColor);\n\n        vec2 center = center1;\n        float r = radius1;\n        vec2 cords = vec2(canvasCoordinate.x * width, canvasCoordinate.y * height);\n        float d1 = distance(cords, center1);\n        float d2 = distance(cords, center2);\n        float d = d1;\n        if(d1 > d2) {\n            center = center2;\n            r = radius2;\n            d = d2;\n        }\n        float adj = 1.0 - my_smoothstep(0.5, 1.0, d/r);\n        color0 = mix(origColor, vec4(sumColor, 1.0), adj * alpha * texColor.a);\n    }\n    gl_FragColor = color0;\n}";
  private static final String TAG = EyeLightenAndPounchFilterReshape.class.getSimpleName();
  public static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform vec2 canvasSize;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  private float alphaValue = 0.36F;
  private float contrastOpacity = 0.125F;
  private Bitmap darkenBitmap;
  private float enhance = 1.0F;
  private Bitmap faceBitmap;
  private int faceImageHeight;
  private int faceImageWidth;
  private float[] faceVertices = new float[1380];
  private long frameStartTime;
  private boolean isFaceImageReady;
  private FaceItem item = createFaceItem();
  private int lastIndex = -1;
  private int mRandomGroupValue;
  private int playCount;
  private int sampleSize;
  private boolean sequenceMode = TextUtils.isEmpty(this.item.faceExchangeImage);
  private float smoothOpacity = 0.7F;
  private float[] texVertices = new float[1380];
  private int[] texture = new int[2];
  
  public EyeLightenAndPounchFilterReshape()
  {
    super(BaseFilter.nativeDecrypt("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform vec2 canvasSize;\n\nvoid main(){\n    vec4 framePos = position;\n\n    gl_Position = framePos;\n    canvasCoordinate = vec2(framePos.x * 0.5 + 0.5, framePos.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n"), BaseFilter.nativeDecrypt("precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform float alpha;\nuniform vec2 size;\nuniform vec2 center1;\nuniform vec2 center2;\nuniform float radius1;\nuniform float radius2;\nuniform float width;\nuniform float height;\nuniform float smoothOpacity;\nuniform float contrastOpacity;\nuniform float enhance;\n\nfloat my_smoothstep(float edge0, float edge1, float x) {\n    float t = clamp((x - edge0) / (edge1 - edge0), 0.0, 1.0);\n    return t * t * (3.0 - 2.0 * t);\n}\n\nvoid main(void) {\n    vec4 origColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec4 texColor = texture2D(inputImageTexture2, textureCoordinate);\n    vec4 color0 = origColor;\n    if (texColor.a <= 0.01) {\n        color0 = vec4(origColor.rgb, 1.0);\n    } else {\n        vec2 curPos = vec2(canvasCoordinate.x * size.x, canvasCoordinate.y * size.y);\n        vec2 step1 = vec2(0.00208, 0.0);\n        vec2 step2 = vec2(0.0, 0.001388);\n        float p = 0.0;\n        float t = 0.0;\n        vec3 sumColor = vec3(0.0, 0.0, 0.0);\n        for(t = -2.0; t < 2.5; t += 1.0) {\n            for(p = -2.0; p < 2.5; p += 1.0) {\n                sumColor += texture2D(inputImageTexture, canvasCoordinate + t * step1 + p * step2).rgb;\n            }\n        }\n        sumColor = sumColor * 0.04;\n        sumColor = clamp(sumColor + (origColor.rgb - sumColor) * 2.8, 0.0, 1.0);\n        sumColor = max(origColor.rgb, sumColor);\n\n        vec2 center = center1;\n        float r = radius1;\n        vec2 cords = vec2(canvasCoordinate.x * width, canvasCoordinate.y * height);\n        float d1 = distance(cords, center1);\n        float d2 = distance(cords, center2);\n        float d = d1;\n        if(d1 > d2) {\n            center = center2;\n            r = radius2;\n            d = d2;\n        }\n        float adj = 1.0 - my_smoothstep(0.5, 1.0, d/r);\n        color0 = mix(origColor, vec4(sumColor, 1.0), adj * alpha * texColor.a);\n    }\n    gl_FragColor = color0;\n}"));
    this.dataPath = "assets://realtimeBeauty";
    initParams();
    this.sampleSize = decodeBitmaps();
  }
  
  private FaceItem createFaceItem()
  {
    return (FaceItem)VideoTemplateParser.parseVideoMaterial("assets://realtimeBeauty", "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n    {\n      \"faceExchangeImage\": \"eyelightenmask.png\",\n      \"blendAlpha\":1.0,\n      \"featureType\": 0,\n      \"grayScale\": 0,\n      \"blendMode\": 0,\n      \"facePoints\": [\n  156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n      ]\n    }\n  ],\n  \"itemList\": [\n    {\n      \"id\": \"kangxi\",\n      \"frameDuration\": 0,\n      \"frames\": 1,\n      \"height\": 960,\n      \"width\": 720,\n      \"triggerType\": 2,\n      \"playCount\": 0,\n      \"alwaysTriggered\": 1,\n      \"type\": 1,\n      \"position\": [\n        0,\n        0\n      ]\n    }\n  ]\n}\n\n", null).getFaceOffItemList().get(0);
  }
  
  private int decodeBitmaps()
  {
    this.faceBitmap = BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(this.dataPath + File.separator + this.item.faceExchangeImage), 1);
    this.darkenBitmap = BitmapUtils.decodeSampleBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(this.dataPath + File.separator + "eyedarken.jpg"), 1);
    return 1;
  }
  
  private boolean initFaceImage()
  {
    if (this.isFaceImageReady) {
      return true;
    }
    if (BitmapUtils.isLegal(this.faceBitmap))
    {
      GlUtil.loadTexture(this.texture[0], this.faceBitmap);
      this.faceImageWidth = (this.faceBitmap.getWidth() * this.sampleSize);
      this.faceImageHeight = (this.faceBitmap.getHeight() * this.sampleSize);
      initFaceTexCoords();
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.texture[0], 33986));
      this.isFaceImageReady = true;
    }
    if (BitmapUtils.isLegal(this.darkenBitmap))
    {
      GlUtil.loadTexture(this.texture[1], this.darkenBitmap);
      addParam(new UniformParam.TextureParam("inputImageTexture3", this.texture[1], 33987));
      this.isFaceImageReady = true;
    }
    return this.isFaceImageReady;
  }
  
  private void initFaceTexCoords()
  {
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.item.facePoints), 2.0F), this.faceImageWidth, this.faceImageHeight, this.texVertices));
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
    this.isFaceImageReady = false;
    BitmapUtils.recycle(this.faceBitmap);
    BitmapUtils.recycle(this.darkenBitmap);
    LogUtils.d(TAG, "[clearGLSLSelf] delete texture, recycle bmp");
    super.clearGLSLSelf();
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    initFaceTexCoords();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    this.faceImageWidth = this.item.width;
    this.faceImageHeight = this.item.height;
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.IntParam("enableFaceOff", 1));
    addParam(new UniformParam.FloatParam("alpha", this.alphaValue));
    addParam(new UniformParam.FloatParam("width", 0.0F));
    addParam(new UniformParam.FloatParam("height", 0.0F));
    addParam(new UniformParam.Float2fParam("canvasSize", this.width, this.height));
    addParam(new UniformParam.Mat4Param("posMatRotate", new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F }));
    if (this.item.grayScale > 0) {
      addParam(new UniformParam.FloatParam("enableAlphaFromGray", 1.0F));
    }
    for (;;)
    {
      addParam(new UniformParam.IntParam("blendMode", this.item.blendMode));
      addParam(new UniformParam.FloatParam("smoothOpacity", this.smoothOpacity));
      addParam(new UniformParam.FloatParam("contrastOpacity", this.contrastOpacity));
      float[] arrayOfFloat = new float[2];
      float[] tmp320_319 = arrayOfFloat;
      tmp320_319[0] = 0.0F;
      float[] tmp324_320 = tmp320_319;
      tmp324_320[1] = 0.0F;
      tmp324_320;
      addParam(new UniformParam.FloatsParam("center1", arrayOfFloat));
      addParam(new UniformParam.FloatsParam("center2", arrayOfFloat));
      addParam(new UniformParam.FloatsParam("size", arrayOfFloat));
      addParam(new UniformParam.FloatParam("radius1", 0.0F));
      addParam(new UniformParam.FloatParam("radius2", 0.0F));
      addParam(new UniformParam.FloatParam("enhance", this.enhance));
      return;
      addParam(new UniformParam.FloatParam("enableAlphaFromGray", 0.0F));
    }
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
  
  public boolean needRender()
  {
    return (this.alphaValue > 0.01F) || (this.smoothOpacity > 0.01F);
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
  
  public void setAlphaValue(float paramFloat)
  {
    this.alphaValue = (0.45F * paramFloat);
    addParam(new UniformParam.FloatParam("alpha", this.alphaValue));
  }
  
  public void setPounchEnhance(float paramFloat)
  {
    this.enhance = paramFloat;
    addParam(new UniformParam.FloatParam("enhance", this.enhance));
  }
  
  public void setSmoothOpacity(float paramFloat)
  {
    this.smoothOpacity = paramFloat;
    addParam(new UniformParam.FloatParam("smoothOpacity", this.smoothOpacity));
  }
  
  public void updatePointParams(List<PointF> paramList)
  {
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList), 2.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
    float f1 = AlgoUtils.getDistance((PointF)paramList.get(35), (PointF)paramList.get(39));
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(45), (PointF)paramList.get(49));
    float f3 = Math.max(((PointF)paramList.get(44)).x - ((PointF)paramList.get(43)).x, ((PointF)paramList.get(54)).x - ((PointF)paramList.get(53)).x);
    f1 = (float)Math.pow(Math.abs(f3) / Math.max(f1, f2), 1.0D);
    f1 = (float)((((PointF)paramList.get(44)).x + 0.0F) / this.mFaceDetScale);
    f2 = (float)(((PointF)paramList.get(44)).y / this.mFaceDetScale);
    f3 = (float)((((PointF)paramList.get(54)).x + 0.0F) / this.mFaceDetScale);
    float f4 = (float)(((PointF)paramList.get(54)).y / this.mFaceDetScale);
    float f5 = this.width;
    float f6 = this.height;
    float f7 = (float)(AlgoUtils.getDistance((PointF)paramList.get(39), (PointF)paramList.get(35)) / this.mFaceDetScale / 4.0D);
    float f8 = (float)(AlgoUtils.getDistance((PointF)paramList.get(49), (PointF)paramList.get(45)) / this.mFaceDetScale / 4.0D);
    addParam(new UniformParam.FloatsParam("center1", new float[] { f1, f2 }));
    addParam(new UniformParam.FloatsParam("center2", new float[] { f3, f4 }));
    addParam(new UniformParam.FloatsParam("size", new float[] { f5, f6 }));
    addParam(new UniformParam.FloatParam("radius1", f7));
    addParam(new UniformParam.FloatParam("radius2", f8));
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      updatePointParams(VideoMaterialUtil.copyList(paramObject.facePoints));
      updateTextureParams(paramObject.timestamp);
    }
  }
  
  public void updateTextureParams(long paramLong)
  {
    initFaceImage();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new UniformParam.Float2fParam("canvasSize", paramInt1, paramInt2));
    addParam(new UniformParam.FloatParam("width", paramInt1));
    addParam(new UniformParam.FloatParam("height", paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.EyeLightenAndPounchFilterReshape
 * JD-Core Version:    0.7.0.1
 */