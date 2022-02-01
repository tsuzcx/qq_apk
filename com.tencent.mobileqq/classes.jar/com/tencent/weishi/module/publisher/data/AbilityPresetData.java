package com.tencent.weishi.module.publisher.data;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.light.LightAsset;

public class AbilityPresetData
{
  public static final String KEY_AI_BODY = "ai.body";
  public static final String KEY_AI_CAT_FACE = "ai.catFace";
  public static final String KEY_AI_EXPRESSION = "ai.expression";
  public static final String KEY_AI_FACE = "ai.face";
  public static final String KEY_AI_FACE_3D = "ai.face3d";
  public static final String KEY_AI_GAN = "ai.gan";
  public static final String KEY_AI_GENDER = "ai.gender";
  public static final String KEY_AI_RGB_DEPTH = "ai.rgbDepth";
  public static final String KEY_AI_SEGMENT = "ai.segment";
  public static final String KEY_AI_SEGMENT_HAIR = "ai.segmentHair";
  public static final String KEY_AI_SEGMENT_HAND = "ai.hand";
  public static final String KEY_AI_SEGMENT_SKY = "ai.segmentSky";
  public static final String KEY_MATERIAL_BEAUTY_BODY = "material.beautyBody";
  public static final String KEY_MATERIAL_DEPTH_TYPE = "material.depthType";
  public static final String KEY_MATERIAL_FILTER_CONFIG = "material.filterConfig";
  public static final String KEY_MATERIAL_MASK_PAINT = "material.maskPaint";
  public static final String KEY_MATERIAL_PAG = "material.pag";
  public static final String KEY_MATERIAL_PARTICLE = "material.particle";
  public static final String KEY_MATERIAL_STICKER_3D = "material.sticker3d";
  public static final String KEY_MATERIAL_TOUCH = "material.touch";
  private Map<String, Boolean> mAiParams = new HashMap();
  
  public AbilityPresetData(@Nullable LightAsset paramLightAsset)
  {
    parseData(paramLightAsset);
  }
  
  private void parseData(@Nullable LightAsset paramLightAsset)
  {
    if (paramLightAsset == null) {
      return;
    }
    this.mAiParams.put("ai.face", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.face")));
    this.mAiParams.put("ai.body", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.body")));
    this.mAiParams.put("ai.segment", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.segment")));
    this.mAiParams.put("ai.segmentSky", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.segmentSky")));
    this.mAiParams.put("ai.segmentHair", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.segmentHair")));
    this.mAiParams.put("ai.hand", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.hand")));
    this.mAiParams.put("ai.face3d", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.face3d")));
    this.mAiParams.put("ai.catFace", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.catFace")));
    this.mAiParams.put("ai.gender", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.gender")));
    this.mAiParams.put("ai.rgbDepth", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.rgbDepth")));
    this.mAiParams.put("ai.gan", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.gan")));
    this.mAiParams.put("ai.expression", Boolean.valueOf(paramLightAsset.needRenderAbility("ai.expression")));
    this.mAiParams.put("material.beautyBody", Boolean.valueOf(paramLightAsset.needRenderAbility("material.beautyBody")));
    this.mAiParams.put("material.depthType", Boolean.valueOf(paramLightAsset.needRenderAbility("material.depthType")));
    this.mAiParams.put("material.touch", Boolean.valueOf(paramLightAsset.needRenderAbility("material.touch")));
    this.mAiParams.put("material.pag", Boolean.valueOf(paramLightAsset.needRenderAbility("material.pag")));
    this.mAiParams.put("material.particle", Boolean.valueOf(paramLightAsset.needRenderAbility("material.particle")));
    this.mAiParams.put("material.maskPaint", Boolean.valueOf(paramLightAsset.needRenderAbility("material.maskPaint")));
    this.mAiParams.put("material.sticker3d", Boolean.valueOf(paramLightAsset.needRenderAbility("material.sticker3d")));
    this.mAiParams.put("material.filterConfig", Boolean.valueOf(paramLightAsset.needRenderAbility("material.filterConfig")));
  }
  
  public Map<String, Boolean> getAiParams()
  {
    return this.mAiParams;
  }
  
  public boolean isAiBody()
  {
    return (this.mAiParams.containsKey("ai.body")) && (((Boolean)this.mAiParams.get("ai.body")).booleanValue());
  }
  
  public boolean isAiCatFace()
  {
    return (this.mAiParams.containsKey("ai.catFace")) && (((Boolean)this.mAiParams.get("ai.catFace")).booleanValue());
  }
  
  public boolean isAiExpression()
  {
    return (this.mAiParams.containsKey("ai.expression")) && (((Boolean)this.mAiParams.get("ai.expression")).booleanValue());
  }
  
  public boolean isAiFace()
  {
    return (this.mAiParams.containsKey("ai.face")) && (((Boolean)this.mAiParams.get("ai.face")).booleanValue());
  }
  
  public boolean isAiFace3d()
  {
    return (this.mAiParams.containsKey("ai.face3d")) && (((Boolean)this.mAiParams.get("ai.face3d")).booleanValue());
  }
  
  public boolean isAiGan()
  {
    return (this.mAiParams.containsKey("ai.gan")) && (((Boolean)this.mAiParams.get("ai.gan")).booleanValue());
  }
  
  public boolean isAiGender()
  {
    return (this.mAiParams.containsKey("ai.gender")) && (((Boolean)this.mAiParams.get("ai.gender")).booleanValue());
  }
  
  public boolean isAiRgbDepth()
  {
    return (this.mAiParams.containsKey("ai.rgbDepth")) && (((Boolean)this.mAiParams.get("ai.rgbDepth")).booleanValue());
  }
  
  public boolean isAiSegment()
  {
    return (this.mAiParams.containsKey("ai.segment")) && (((Boolean)this.mAiParams.get("ai.segment")).booleanValue());
  }
  
  public boolean isAiSegmentHair()
  {
    return (this.mAiParams.containsKey("ai.segmentHair")) && (((Boolean)this.mAiParams.get("ai.segmentHair")).booleanValue());
  }
  
  public boolean isAiSegmentHand()
  {
    return (this.mAiParams.containsKey("ai.hand")) && (((Boolean)this.mAiParams.get("ai.hand")).booleanValue());
  }
  
  public boolean isAiSegmentSky()
  {
    return (this.mAiParams.containsKey("ai.segmentSky")) && (((Boolean)this.mAiParams.get("ai.segmentSky")).booleanValue());
  }
  
  public boolean isMaterialBeautyBody()
  {
    return (this.mAiParams.containsKey("material.beautyBody")) && (((Boolean)this.mAiParams.get("material.beautyBody")).booleanValue());
  }
  
  public boolean isMaterialDepthType()
  {
    return (this.mAiParams.containsKey("material.depthType")) && (((Boolean)this.mAiParams.get("material.depthType")).booleanValue());
  }
  
  public boolean isMaterialMaskPaint()
  {
    return (this.mAiParams.containsKey("material.maskPaint")) && (((Boolean)this.mAiParams.get("material.maskPaint")).booleanValue());
  }
  
  public boolean isMaterialPag()
  {
    return (this.mAiParams.containsKey("material.pag")) && (((Boolean)this.mAiParams.get("material.pag")).booleanValue());
  }
  
  public boolean isMaterialParticle()
  {
    return (this.mAiParams.containsKey("material.particle")) && (((Boolean)this.mAiParams.get("material.particle")).booleanValue());
  }
  
  public boolean isMaterialSticker3D()
  {
    return (this.mAiParams.containsKey("material.sticker3d")) && (((Boolean)this.mAiParams.get("material.sticker3d")).booleanValue());
  }
  
  public boolean isMaterialTouch()
  {
    return (this.mAiParams.containsKey("material.touch")) && (((Boolean)this.mAiParams.get("material.touch")).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.data.AbilityPresetData
 * JD-Core Version:    0.7.0.1
 */