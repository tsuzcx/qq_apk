package com.tencent.tavcut.creator;

import com.tencent.tavcut.composition.model.component.AudioEffect;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.Camera;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.Image;
import com.tencent.tavcut.composition.model.component.LUTFilter;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.PAGAsset.PagScaleMode;
import com.tencent.tavcut.composition.model.component.PAGAsset.Replacement;
import com.tencent.tavcut.composition.model.component.PostEffect;
import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.composition.model.component.Quat;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.SingleMedia;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.Transition;
import com.tencent.tavcut.composition.model.component.Vec2;
import com.tencent.tavcut.composition.model.component.Vec3;
import com.tencent.tavcut.utils.ScreenTransformUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/creator/ComponentCreator;", "Lcom/tencent/tavcut/creator/IComponentCreator;", "()V", "createAdjustPostEffect", "Lcom/tencent/tavcut/composition/model/component/PostEffect;", "sharpness", "", "brightness", "contrast", "hue", "highlights", "shadows", "saturation", "temperature", "createAudioEffect", "Lcom/tencent/tavcut/composition/model/component/AudioEffect;", "preset", "", "createAudioSource", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "resourceId", "volume", "", "speed", "createCamera", "Lcom/tencent/tavcut/composition/model/component/Camera;", "key", "createCustomGraph", "Lcom/tencent/tavcut/composition/model/component/CustomGraph;", "createEffectPAGAsset", "Lcom/tencent/tavcut/composition/model/component/PAGAsset;", "usage", "scaleMode", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$PagScaleMode;", "replaceIndex", "createEntityIdentifier", "Lcom/tencent/tavcut/composition/model/component/EntityIdentifier;", "name", "createImage", "Lcom/tencent/tavcut/composition/model/component/Image;", "durationUs", "", "createLutFilter", "Lcom/tencent/tavcut/composition/model/component/LUTFilter;", "intensity", "createPAGAsset", "replacement", "", "Lcom/tencent/tavcut/composition/model/component/PAGAsset$Replacement;", "createPriority", "Lcom/tencent/tavcut/composition/model/component/Priority;", "priority", "createScreenTransform", "Lcom/tencent/tavcut/composition/model/component/ScreenTransform;", "scale", "anchorPointX", "anchorPointY", "width", "height", "rotate", "createScreenTransformPinToEdge", "anchor", "Lcom/tencent/tavcut/composition/model/component/Rect;", "createScript", "Lcom/tencent/tavcut/composition/model/component/Script;", "createSingleMedia", "Lcom/tencent/tavcut/composition/model/component/SingleMedia;", "index", "createTimeOffset", "Lcom/tencent/tavcut/composition/model/component/TimeOffset;", "startOffsetUs", "createTransition", "Lcom/tencent/tavcut/composition/model/component/Transition;", "firstLayerIndex", "lastLayerIndex", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class ComponentCreator
  implements IComponentCreator
{
  public static final ComponentCreator a = new ComponentCreator();
  
  @NotNull
  public AudioSource a(@NotNull String paramString, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resourceId");
    return new AudioSource(null, null, Boolean.valueOf(true), "AudioSource", null, Float.valueOf(paramFloat2), null, Float.valueOf(paramFloat1), null, null, paramString, null, 2899, null);
  }
  
  @NotNull
  public EntityIdentifier a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return new EntityIdentifier("EntityIdentifier", paramString, null, null, 12, null);
  }
  
  @NotNull
  public Image a(@NotNull String paramString, long paramLong, @NotNull PAGAsset.PagScaleMode paramPagScaleMode)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resourceId");
    Intrinsics.checkParameterIsNotNull(paramPagScaleMode, "scaleMode");
    return new Image(null, Boolean.valueOf(true), null, Integer.valueOf(paramPagScaleMode.getValue()), paramString, "Image", Long.valueOf(paramLong), null, null, 389, null);
  }
  
  @NotNull
  public LUTFilter a(@NotNull String paramString, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resourceId");
    return new LUTFilter(null, null, Boolean.valueOf(true), "LUTFilter", paramString, null, null, Float.valueOf(paramFloat), null, 355, null);
  }
  
  @NotNull
  public PAGAsset a(@NotNull String paramString, int paramInt, @NotNull List<PAGAsset.Replacement> paramList, @NotNull PAGAsset.PagScaleMode paramPagScaleMode)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resourceId");
    Intrinsics.checkParameterIsNotNull(paramList, "replacement");
    Intrinsics.checkParameterIsNotNull(paramPagScaleMode, "scaleMode");
    return new PAGAsset(null, null, Boolean.valueOf(true), "PAGAsset", null, paramString, Integer.valueOf(paramInt), null, paramList, Integer.valueOf(paramPagScaleMode.getValue()), null, 1171, null);
  }
  
  @NotNull
  public PostEffect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    return new PostEffect(null, null, Boolean.valueOf(true), "PostEffect", "adjustment", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), null, 8195, null);
  }
  
  @NotNull
  public ScreenTransform a()
  {
    Vec3 localVec31 = new Vec3(0.0F, 0.0F, 0.0F, null, 8, null);
    Quat localQuat = new Quat(0.0F, 0.0F, 0.0F, 1.0F, null, 16, null);
    Vec3 localVec32 = new Vec3(1.0F, 1.0F, 1.0F, null, 8, null);
    Rect localRect1 = new Rect(-1.0F, 1.0F, 1.0F, -1.0F, null, 16, null);
    Rect localRect2 = new Rect(0.0F, 0.0F, 0.0F, 0.0F, null, 16, null);
    Vec2 localVec2 = new Vec2(0.0F, 0.0F, null, 4, null);
    Boolean localBoolean = Boolean.valueOf(true);
    return new ScreenTransform(null, null, localBoolean, "ScreenTransform", localRect1, localRect2, localVec2, null, null, null, localBoolean, localVec31, localQuat, localVec32, null, localBoolean, null, null, 213891, null);
  }
  
  @NotNull
  public ScreenTransform a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Vec3 localVec31 = new Vec3(0.0F, 0.0F, 0.0F, null, 8, null);
    Quat localQuat = ScreenTransformUtilsKt.a(paramFloat6);
    Vec3 localVec32 = new Vec3(paramFloat5, paramFloat5, 1.0F, null, 8, null);
    Rect localRect1 = new Rect(paramFloat1, paramFloat2, paramFloat1, paramFloat2, null, 16, null);
    paramFloat1 = -paramFloat3;
    paramFloat2 = 2;
    Rect localRect2 = new Rect(paramFloat1 / paramFloat2, paramFloat4 / paramFloat2, paramFloat3 / paramFloat2, -paramFloat4 / paramFloat2, null, 16, null);
    Vec2 localVec2 = new Vec2(0.0F, 0.0F, null, 4, null);
    Boolean localBoolean = Boolean.valueOf(true);
    return new ScreenTransform(null, null, localBoolean, "ScreenTransform", localRect1, localRect2, localVec2, null, null, null, localBoolean, localVec31, localQuat, localVec32, null, localBoolean, null, null, 213891, null);
  }
  
  @NotNull
  public ScreenTransform a(float paramFloat1, float paramFloat2, @NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "anchor");
    Vec3 localVec31 = new Vec3(0.0F, 0.0F, 0.0F, null, 8, null);
    Quat localQuat = ScreenTransformUtilsKt.a(paramFloat2);
    Vec3 localVec32 = new Vec3(paramFloat1, paramFloat1, 1.0F, null, 8, null);
    Rect localRect = new Rect(0.0F, 0.0F, 0.0F, 0.0F, null, 16, null);
    Vec2 localVec2 = new Vec2(0.0F, 0.0F, null, 4, null);
    Boolean localBoolean = Boolean.valueOf(true);
    return new ScreenTransform(null, null, localBoolean, "ScreenTransform", paramRect, localRect, localVec2, null, null, null, localBoolean, localVec31, localQuat, localVec32, null, localBoolean, null, null, 213891, null);
  }
  
  @NotNull
  public SingleMedia a(int paramInt)
  {
    return new SingleMedia(null, null, Boolean.valueOf(true), "SingleMedia", Integer.valueOf(paramInt), null, null, 99, null);
  }
  
  @NotNull
  public TimeOffset a(long paramLong1, long paramLong2)
  {
    return new TimeOffset(null, null, Boolean.valueOf(true), "TimeOffset", Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(0), null, null, 387, null);
  }
  
  @NotNull
  public Transition a(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resourceId");
    return a(paramString, paramLong, 0, 1);
  }
  
  @NotNull
  public Transition a(@NotNull String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resourceId");
    return new Transition(null, null, Boolean.valueOf(true), "Transition", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Long.valueOf(paramLong), null, null, 771, null);
  }
  
  @NotNull
  public Camera b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return new Camera(null, Boolean.valueOf(true), null, paramString, "Camera", null, null, 101, null);
  }
  
  @NotNull
  public Priority b(int paramInt)
  {
    return new Priority(null, null, null, null, Integer.valueOf(paramInt), null, 47, null);
  }
  
  @NotNull
  public AudioEffect c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "preset");
    return new AudioEffect(null, null, Boolean.valueOf(true), "AudioEffect", paramString, null, null, 99, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.creator.ComponentCreator
 * JD-Core Version:    0.7.0.1
 */