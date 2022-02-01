package com.tencent.weishi.module.publisher.model;

import android.text.TextUtils;
import com.tencent.weishi.module.publisher.interfaces.WeishiBeautyRealConfig.TYPE;
import com.tencent.weseevideo.model.utils.FileUtils;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weishi/module/publisher/model/AIModelConfig;", "", "()V", "AI_AGENT_TYPE_3DMM", "", "AI_AGENT_TYPE_ACE_3D", "AI_AGENT_TYPE_AGE", "AI_AGENT_TYPE_BG_SEG", "AI_AGENT_TYPE_BODY", "AI_AGENT_TYPE_CAT", "AI_AGENT_TYPE_DEPTH", "AI_AGENT_TYPE_FACE", "AI_AGENT_TYPE_FULL_BODY", "AI_AGENT_TYPE_GENDER", "AI_AGENT_TYPE_HAIR", "AI_AGENT_TYPE_HAND", "AI_AGENT_TYPE_SKY", "AI_AGE_ENABLE", "AI_FACE_ENABLE", "AI_GENDER_ENABLE", "AI_HAND_ENABLE", "AI_MODEL_AGENT_MAP", "", "getAI_MODEL_AGENT_MAP", "()Ljava/util/Map;", "setAI_MODEL_AGENT_MAP", "(Ljava/util/Map;)V", "AI_SEGMENTATION_BG_ENABLE", "AI_SEGMENTATION_BG_FOLLOWFACE", "AI_SEGMENTATION_BG_MODELLEVEL", "AI_SEGMENTATION_HAIR_ENABLE", "AI_SEGMENTATION_HAIR_MODELLEVEL", "AI_SEGMENTATION_SKY_ENABLE", "AI_SEGMENTATION_SKY_MODELLEVEL", "AI_SMILE_ENABLE", "BASICBODYBEAUTY_ENABLE", "BASICFACEBEAUTY_ENABLE", "BASICLUT_ENABLE", "BEAUTY_ENABLEFACECOLORWHITE", "BEAUTY_EYELIGHTEN", "BEAUTY_FACEFEATURE", "BEAUTY_FACE_KEY_MAP", "Lcom/tencent/weishi/module/publisher/interfaces/WeishiBeautyRealConfig$TYPE;", "getBEAUTY_FACE_KEY_MAP", "setBEAUTY_FACE_KEY_MAP", "BEAUTY_IMAGECONTRASTALPHA", "BEAUTY_REMOVEEYEBAGS", "BEAUTY_REMOVELAWLINE", "BEAUTY_REMOVEWRINKLE", "BEAUTY_SKINCOLOR", "BEAUTY_TOOTHWHITEN", "BODY_LEGSTRETCH", "BODY_THINBODYSTRENGTH", "BODY_THINSHOULDERSTRENGTH", "BODY_WAISTSTRENGTH", "DEFAULT_EXTERNAL_RENDER_KEY", "DENOISE_ENABLE", "LIQUEFACTION_BASIC3", "MATERIALBODYBEAUTY_ENABLE", "MATERIALFACEBEAUTY_ENABLE", "MATERIALLUT_ENABLE", "SMOOTHVERSION", "SMOOTH_CURVEADJUSTALPHA", "getSMOOTH_CURVEADJUSTALPHA", "()Ljava/lang/String;", "SMOOTH_FOLLOWFACE", "SMOOTH_IMAGECONTRASTALPHA", "getSMOOTH_IMAGECONTRASTALPHA", "SMOOTH_SHARPEN", "SMOOTH_SMOOTH", "STRETCH_CHIN", "STRETCH_ENLARGEEYE", "STRETCH_EYEANGLE", "STRETCH_EYEDISTANCE", "STRETCH_FOREHEAD", "STRETCH_MOUTHHEIGHT", "STRETCH_MOUTHPOSITION", "STRETCH_MOUTHSIZE", "STRETCH_MOUTHWIDTH", "STRETCH_NOSEHEIGHT", "STRETCH_NOSEWING", "STRETCH_SHORTFACE", "STRETCH_THINFACE", "STRETCH_THINNOSE", "STRETCH_VFACE", "STROKE_COLOR", "STROKE_ENABLE", "STROKE_GAP", "STROKE_WIDTH", "aiModelPathMap", "Ljava/util/HashMap;", "aiModelPathMap$annotations", "covertToCameraConfig", "", "beautyFace", "", "Lkotlin/collections/HashMap;", "covertValue", "", "value", "getAIModelPathMap", "getAiModelAgentMap", "getSingleAIModelPath", "modelName", "setLightAIModelPath", "", "modelPath", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class AIModelConfig
{
  @NotNull
  public static final String AI_AGENT_TYPE_3DMM = "k3D_MM_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_ACE_3D = "Ace_3d_Engine";
  @NotNull
  public static final String AI_AGENT_TYPE_AGE = "AGE_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_BG_SEG = "BG_SEG_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_BODY = "BODY_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_CAT = "CAT_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_DEPTH = "DEPTH_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_FACE = "FACE_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_FULL_BODY = "FULL_BODY_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_GENDER = "GENDER_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_HAIR = "HAIR_SEG_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_HAND = "HAND_AGENT";
  @NotNull
  public static final String AI_AGENT_TYPE_SKY = "SKY_SEG_AGENT";
  @NotNull
  public static final String AI_AGE_ENABLE = "ai.age.enable";
  @NotNull
  public static final String AI_FACE_ENABLE = "ai.face.enable";
  @NotNull
  public static final String AI_GENDER_ENABLE = "ai.gender.enable";
  @NotNull
  public static final String AI_HAND_ENABLE = "ai.hand.enable";
  @NotNull
  private static Map<String, String> AI_MODEL_AGENT_MAP;
  @NotNull
  public static final String AI_SEGMENTATION_BG_ENABLE = "ai.segmentation.bg.enable";
  @NotNull
  public static final String AI_SEGMENTATION_BG_FOLLOWFACE = "ai.segmentation.bg.followFace";
  @NotNull
  public static final String AI_SEGMENTATION_BG_MODELLEVEL = "ai.segmentation.bg.modelLevel";
  @NotNull
  public static final String AI_SEGMENTATION_HAIR_ENABLE = "ai.segmentation.hair.enable";
  @NotNull
  public static final String AI_SEGMENTATION_HAIR_MODELLEVEL = "ai.segmentation.hair.modelLevel";
  @NotNull
  public static final String AI_SEGMENTATION_SKY_ENABLE = "ai.segmentation.sky.enable";
  @NotNull
  public static final String AI_SEGMENTATION_SKY_MODELLEVEL = "ai.segmentation.sky.modelLevel";
  @NotNull
  public static final String AI_SMILE_ENABLE = "ai.smile.enable";
  @NotNull
  public static final String BASICBODYBEAUTY_ENABLE = "basicBodyBeauty.enable";
  @NotNull
  public static final String BASICFACEBEAUTY_ENABLE = "basicFaceBeauty.enable";
  @NotNull
  public static final String BASICLUT_ENABLE = "basicLUT.enable";
  @NotNull
  public static final String BEAUTY_ENABLEFACECOLORWHITE = "beauty.enableFaceColorWhite";
  @NotNull
  public static final String BEAUTY_EYELIGHTEN = "beauty.eyeLighten";
  @NotNull
  public static final String BEAUTY_FACEFEATURE = "beauty.faceFeature";
  @NotNull
  private static Map<WeishiBeautyRealConfig.TYPE, String> BEAUTY_FACE_KEY_MAP;
  @NotNull
  public static final String BEAUTY_IMAGECONTRASTALPHA = "beauty.imageContrastAlpha";
  @NotNull
  public static final String BEAUTY_REMOVEEYEBAGS = "beauty.removeEyeBags";
  @NotNull
  public static final String BEAUTY_REMOVELAWLINE = "beauty.removeLawLine";
  @NotNull
  public static final String BEAUTY_REMOVEWRINKLE = "beauty.removeWrinkle";
  @NotNull
  public static final String BEAUTY_SKINCOLOR = "beauty.skinColor";
  @NotNull
  public static final String BEAUTY_TOOTHWHITEN = "beauty.toothWhiten";
  @NotNull
  public static final String BODY_LEGSTRETCH = "body.legStretch";
  @NotNull
  public static final String BODY_THINBODYSTRENGTH = "body.thinBodyStrength";
  @NotNull
  public static final String BODY_THINSHOULDERSTRENGTH = "body.thinShoulderStrength";
  @NotNull
  public static final String BODY_WAISTSTRENGTH = "body.waistStrength";
  @NotNull
  public static final String DEFAULT_EXTERNAL_RENDER_KEY = "default_external_render_key";
  @NotNull
  public static final String DENOISE_ENABLE = "denoise.enable";
  public static final AIModelConfig INSTANCE = new AIModelConfig();
  @NotNull
  public static final String LIQUEFACTION_BASIC3 = "liquefaction.basic3";
  @NotNull
  public static final String MATERIALBODYBEAUTY_ENABLE = "materialBodyBeauty.enable";
  @NotNull
  public static final String MATERIALFACEBEAUTY_ENABLE = "materialFaceBeauty.enable";
  @NotNull
  public static final String MATERIALLUT_ENABLE = "materialLUT.enable";
  @NotNull
  public static final String SMOOTHVERSION = "smoothVersion";
  @NotNull
  private static final String SMOOTH_CURVEADJUSTALPHA = "smooth.curveAdjustAlpha";
  @NotNull
  public static final String SMOOTH_FOLLOWFACE = "smooth.followFace";
  @NotNull
  private static final String SMOOTH_IMAGECONTRASTALPHA = "beauty.imageContrastAlpha";
  @NotNull
  public static final String SMOOTH_SHARPEN = "smooth.sharpen";
  @NotNull
  public static final String SMOOTH_SMOOTH = "smooth.smooth";
  @NotNull
  public static final String STRETCH_CHIN = "stretch.chin";
  @NotNull
  public static final String STRETCH_ENLARGEEYE = "stretch.enlargeEye";
  @NotNull
  public static final String STRETCH_EYEANGLE = "stretch.eyeAngle";
  @NotNull
  public static final String STRETCH_EYEDISTANCE = "stretch.eyeDistance";
  @NotNull
  public static final String STRETCH_FOREHEAD = "stretch.forehead";
  @NotNull
  public static final String STRETCH_MOUTHHEIGHT = "stretch.mouthHeight";
  @NotNull
  public static final String STRETCH_MOUTHPOSITION = "stretch.mouthPosition";
  @NotNull
  public static final String STRETCH_MOUTHSIZE = "stretch.mouthSize";
  @NotNull
  public static final String STRETCH_MOUTHWIDTH = "stretch.mouthWidth";
  @NotNull
  public static final String STRETCH_NOSEHEIGHT = "stretch.noseHeight";
  @NotNull
  public static final String STRETCH_NOSEWING = "stretch.noseWing";
  @NotNull
  public static final String STRETCH_SHORTFACE = "stretch.shortFace";
  @NotNull
  public static final String STRETCH_THINFACE = "stretch.thinFace";
  @NotNull
  public static final String STRETCH_THINNOSE = "stretch.thinNose";
  @NotNull
  public static final String STRETCH_VFACE = "stretch.vFace";
  @NotNull
  public static final String STROKE_COLOR = "stroke.color";
  @NotNull
  public static final String STROKE_ENABLE = "stroke.enable";
  @NotNull
  public static final String STROKE_GAP = "stroke.gap";
  @NotNull
  public static final String STROKE_WIDTH = "stroke.width";
  private static final HashMap<String, String> aiModelPathMap;
  
  static
  {
    BEAUTY_FACE_KEY_MAP = (Map)new EnumMap(WeishiBeautyRealConfig.TYPE.class);
    AI_MODEL_AGENT_MAP = (Map)new HashMap();
    aiModelPathMap = new HashMap();
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.BEAUTY, "smooth.smooth");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.REMOVE_WRINKLES, "beauty.removeWrinkle");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.REMOVE_WRINKLES2, "beauty.removeLawLine");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.REMOVE_POUNCH, "beauty.removeEyeBags");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.EYE_LIGHTEN, "beauty.eyeLighten");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.WUGUANLITI, "beauty.faceFeature");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.TOOTH_WHITEN, "beauty.toothWhiten");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.COLOR_TONE, "beauty.skinColor");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.BASIC3, "liquefaction.basic3");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.FACE_V, "stretch.vFace");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.CHIN, "stretch.chin");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.FACE_THIN, "stretch.thinFace");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.FACE_SHORTEN, "stretch.shortFace");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.EYE, "stretch.enlargeEye");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.NOSE, "stretch.thinNose");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.FOREHEAD, "stretch.forehead");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.EYE_DISTANCE, "stretch.eyeDistance");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.EYE_ANGLE, "stretch.eyeAngle");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.NOSE_WING, "stretch.noseWing");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.NOSE_POSITION, "stretch.noseHeight");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.MOUTH_SHAPE, "stretch.mouthSize");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.LIPS_THICKNESS, "stretch.mouthHeight");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.LONG_LEG, "body.legStretch");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.SLIM_WAIST, "body.waistStrength");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.THIN_BODY, "body.thinBodyStrength");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.THIN_SHOULDER, "body.thinShoulderStrength");
    BEAUTY_FACE_KEY_MAP.put(WeishiBeautyRealConfig.TYPE.CONTRAST_RATIO, SMOOTH_IMAGECONTRASTALPHA);
    AI_MODEL_AGENT_MAP.put("ai.face", "FACE_AGENT");
    AI_MODEL_AGENT_MAP.put("ai.hand", "HAND_AGENT");
    AI_MODEL_AGENT_MAP.put("ai.catFace", "CAT_AGENT");
    AI_MODEL_AGENT_MAP.put("ai.segment", "BG_SEG_AGENT");
    AI_MODEL_AGENT_MAP.put("ai.body", "FULL_BODY_AGENT");
    AI_MODEL_AGENT_MAP.put("ai.gender", "GENDER_AGENT");
    AI_MODEL_AGENT_MAP.put("ai.face3d", "k3D_MM_AGENT");
    AI_MODEL_AGENT_MAP.put("ai.rgbDepth", "DEPTH_AGENT");
    AI_MODEL_AGENT_MAP.put("ai.segmentHair", "HAIR_SEG_AGENT");
    AI_MODEL_AGENT_MAP.put("ai.segmentSky", "SKY_SEG_AGENT");
    AI_MODEL_AGENT_MAP.put("material.sticker3d", "Ace_3d_Engine");
  }
  
  @JvmStatic
  @NotNull
  public static final Map<String, String> covertToCameraConfig(@NotNull HashMap<WeishiBeautyRealConfig.TYPE, Integer> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "beautyFace");
    Map localMap = (Map)new HashMap();
    paramHashMap = paramHashMap.entrySet();
    Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "beautyFace.entries");
    paramHashMap = paramHashMap.iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      Object localObject = (WeishiBeautyRealConfig.TYPE)localEntry.getKey();
      localObject = (String)BEAUTY_FACE_KEY_MAP.get(localObject);
      if (localObject != null)
      {
        int i = ((Number)localEntry.getValue()).intValue();
        localMap.put(localObject, String.valueOf(INSTANCE.covertValue(i)));
      }
    }
    return localMap;
  }
  
  private final float covertValue(int paramInt)
  {
    return paramInt / 100.0F;
  }
  
  @JvmStatic
  @NotNull
  public static final HashMap<String, String> getAIModelPathMap()
  {
    return aiModelPathMap;
  }
  
  @JvmStatic
  @NotNull
  public static final Map<String, String> getAiModelAgentMap()
  {
    return AI_MODEL_AGENT_MAP;
  }
  
  @JvmStatic
  @Nullable
  public static final String getSingleAIModelPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "modelName");
    if ((!TextUtils.isEmpty((CharSequence)paramString)) && (aiModelPathMap.containsKey(paramString))) {
      return (String)aiModelPathMap.get(paramString);
    }
    return "";
  }
  
  @JvmStatic
  public static final void setLightAIModelPath(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "modelName");
    Intrinsics.checkParameterIsNotNull(paramString2, "modelPath");
    if ((!TextUtils.isEmpty((CharSequence)paramString1)) && (FileUtils.exists(paramString2))) {
      ((Map)aiModelPathMap).put(paramString1, paramString2);
    }
  }
  
  @NotNull
  public final Map<String, String> getAI_MODEL_AGENT_MAP()
  {
    return AI_MODEL_AGENT_MAP;
  }
  
  @NotNull
  public final Map<WeishiBeautyRealConfig.TYPE, String> getBEAUTY_FACE_KEY_MAP()
  {
    return BEAUTY_FACE_KEY_MAP;
  }
  
  @NotNull
  public final String getSMOOTH_CURVEADJUSTALPHA()
  {
    return SMOOTH_CURVEADJUSTALPHA;
  }
  
  @NotNull
  public final String getSMOOTH_IMAGECONTRASTALPHA()
  {
    return SMOOTH_IMAGECONTRASTALPHA;
  }
  
  public final void setAI_MODEL_AGENT_MAP(@NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "<set-?>");
    AI_MODEL_AGENT_MAP = paramMap;
  }
  
  public final void setBEAUTY_FACE_KEY_MAP(@NotNull Map<WeishiBeautyRealConfig.TYPE, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "<set-?>");
    BEAUTY_FACE_KEY_MAP = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.model.AIModelConfig
 * JD-Core Version:    0.7.0.1
 */