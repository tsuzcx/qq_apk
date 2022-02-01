package com.tencent.tavcut.rendermodel;

import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.properties.Properties;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/RenderModel;", "", "renderScene", "Lcom/tencent/tavcut/rendermodel/RenderScene;", "root", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "inputSources", "", "", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "painting", "Lcom/tencent/tavcut/model/Painting;", "clipsAssets", "", "Lcom/tencent/tavcut/model/ClipSource;", "modifyClipsDuration", "", "seekTolerance", "", "properties", "Lcom/tencent/tavcut/rendermodel/properties/Properties;", "audioAssets", "", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "timeLines", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "maxDuration", "", "componentLevel", "voiceChangerConfig", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "(Lcom/tencent/tavcut/rendermodel/RenderScene;Lcom/tencent/tavcut/rendermodel/entity/Entity;Ljava/util/Map;Lcom/tencent/tavcut/model/Painting;Ljava/util/List;ZILcom/tencent/tavcut/rendermodel/properties/Properties;Ljava/util/Map;Ljava/util/List;JILjava/util/List;)V", "getAudioAssets", "()Ljava/util/Map;", "getClipsAssets", "()Ljava/util/List;", "getComponentLevel", "()I", "getInputSources", "getMaxDuration", "()J", "getModifyClipsDuration", "()Z", "getPainting", "()Lcom/tencent/tavcut/model/Painting;", "getProperties", "()Lcom/tencent/tavcut/rendermodel/properties/Properties;", "getRenderScene", "()Lcom/tencent/tavcut/rendermodel/RenderScene;", "getRoot", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getSeekTolerance", "getTimeLines", "getVoiceChangerConfig", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getDurationMs", "hashCode", "toString", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class RenderModel
{
  public static final int CAMERA_COMPONENT_LEVEL = 3;
  public static final RenderModel.Companion Companion = new RenderModel.Companion(null);
  private static final String DEFAULT_BG_COLOR = "#00000000";
  private static final Painting DEFAULT_PAINTING = new Painting(DEFAULT_SIZE, null, BackgroundFillMode.SOLID_COLOR, null, "#00000000", null, null, 106, null);
  @NotNull
  private static final Size DEFAULT_SIZE = new Size(Integer.valueOf(720), Integer.valueOf(1280), null, 4, null);
  public static final int DEFAULT_TEMPLATE_HEIGHT = 1280;
  public static final int DEFAULT_TEMPLATE_WIDTH = 720;
  public static final long DURATION_UNLIMITED = -1L;
  @NotNull
  private final Map<String, AudioSource> audioAssets;
  @NotNull
  private final List<ClipSource> clipsAssets;
  private final int componentLevel;
  @NotNull
  private final Map<String, InputSource> inputSources;
  private final long maxDuration;
  private final boolean modifyClipsDuration;
  @NotNull
  private final Painting painting;
  @Nullable
  private final Properties properties;
  @NotNull
  private final RenderScene renderScene;
  @Nullable
  private final Entity root;
  private final int seekTolerance;
  @NotNull
  private final List<Timeline> timeLines;
  @Nullable
  private final List<VoiceEnum> voiceChangerConfig;
  
  public RenderModel()
  {
    this(null, null, null, null, null, false, 0, null, null, null, 0L, 0, null, 8191, null);
  }
  
  public RenderModel(@NotNull RenderScene paramRenderScene, @Nullable Entity paramEntity, @NotNull Map<String, InputSource> paramMap, @NotNull Painting paramPainting, @NotNull List<ClipSource> paramList, boolean paramBoolean, int paramInt1, @Nullable Properties paramProperties, @NotNull Map<String, AudioSource> paramMap1, @NotNull List<Timeline> paramList1, long paramLong, int paramInt2, @Nullable List<? extends VoiceEnum> paramList2)
  {
    this.renderScene = paramRenderScene;
    this.root = paramEntity;
    this.inputSources = paramMap;
    this.painting = paramPainting;
    this.clipsAssets = paramList;
    this.modifyClipsDuration = paramBoolean;
    this.seekTolerance = paramInt1;
    this.properties = paramProperties;
    this.audioAssets = paramMap1;
    this.timeLines = paramList1;
    this.maxDuration = paramLong;
    this.componentLevel = paramInt2;
    this.voiceChangerConfig = paramList2;
  }
  
  @NotNull
  public final RenderScene component1()
  {
    return this.renderScene;
  }
  
  @NotNull
  public final List<Timeline> component10()
  {
    return this.timeLines;
  }
  
  public final long component11()
  {
    return this.maxDuration;
  }
  
  public final int component12()
  {
    return this.componentLevel;
  }
  
  @Nullable
  public final List<VoiceEnum> component13()
  {
    return this.voiceChangerConfig;
  }
  
  @Nullable
  public final Entity component2()
  {
    return this.root;
  }
  
  @NotNull
  public final Map<String, InputSource> component3()
  {
    return this.inputSources;
  }
  
  @NotNull
  public final Painting component4()
  {
    return this.painting;
  }
  
  @NotNull
  public final List<ClipSource> component5()
  {
    return this.clipsAssets;
  }
  
  public final boolean component6()
  {
    return this.modifyClipsDuration;
  }
  
  public final int component7()
  {
    return this.seekTolerance;
  }
  
  @Nullable
  public final Properties component8()
  {
    return this.properties;
  }
  
  @NotNull
  public final Map<String, AudioSource> component9()
  {
    return this.audioAssets;
  }
  
  @NotNull
  public final RenderModel copy(@NotNull RenderScene paramRenderScene, @Nullable Entity paramEntity, @NotNull Map<String, InputSource> paramMap, @NotNull Painting paramPainting, @NotNull List<ClipSource> paramList, boolean paramBoolean, int paramInt1, @Nullable Properties paramProperties, @NotNull Map<String, AudioSource> paramMap1, @NotNull List<Timeline> paramList1, long paramLong, int paramInt2, @Nullable List<? extends VoiceEnum> paramList2)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderScene, "renderScene");
    Intrinsics.checkParameterIsNotNull(paramMap, "inputSources");
    Intrinsics.checkParameterIsNotNull(paramPainting, "painting");
    Intrinsics.checkParameterIsNotNull(paramList, "clipsAssets");
    Intrinsics.checkParameterIsNotNull(paramMap1, "audioAssets");
    Intrinsics.checkParameterIsNotNull(paramList1, "timeLines");
    return new RenderModel(paramRenderScene, paramEntity, paramMap, paramPainting, paramList, paramBoolean, paramInt1, paramProperties, paramMap1, paramList1, paramLong, paramInt2, paramList2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof RenderModel))
      {
        paramObject = (RenderModel)paramObject;
        if ((Intrinsics.areEqual(this.renderScene, paramObject.renderScene)) && (Intrinsics.areEqual(this.root, paramObject.root)) && (Intrinsics.areEqual(this.inputSources, paramObject.inputSources)) && (Intrinsics.areEqual(this.painting, paramObject.painting)) && (Intrinsics.areEqual(this.clipsAssets, paramObject.clipsAssets)) && (this.modifyClipsDuration == paramObject.modifyClipsDuration) && (this.seekTolerance == paramObject.seekTolerance) && (Intrinsics.areEqual(this.properties, paramObject.properties)) && (Intrinsics.areEqual(this.audioAssets, paramObject.audioAssets)) && (Intrinsics.areEqual(this.timeLines, paramObject.timeLines)) && (this.maxDuration == paramObject.maxDuration) && (this.componentLevel == paramObject.componentLevel) && (Intrinsics.areEqual(this.voiceChangerConfig, paramObject.voiceChangerConfig))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final Map<String, AudioSource> getAudioAssets()
  {
    return this.audioAssets;
  }
  
  @NotNull
  public final List<ClipSource> getClipsAssets()
  {
    return this.clipsAssets;
  }
  
  public final int getComponentLevel()
  {
    return this.componentLevel;
  }
  
  public final long getDurationMs()
  {
    return 0L;
  }
  
  @NotNull
  public final Map<String, InputSource> getInputSources()
  {
    return this.inputSources;
  }
  
  public final long getMaxDuration()
  {
    return this.maxDuration;
  }
  
  public final boolean getModifyClipsDuration()
  {
    return this.modifyClipsDuration;
  }
  
  @NotNull
  public final Painting getPainting()
  {
    return this.painting;
  }
  
  @Nullable
  public final Properties getProperties()
  {
    return this.properties;
  }
  
  @NotNull
  public final RenderScene getRenderScene()
  {
    return this.renderScene;
  }
  
  @Nullable
  public final Entity getRoot()
  {
    return this.root;
  }
  
  public final int getSeekTolerance()
  {
    return this.seekTolerance;
  }
  
  @NotNull
  public final List<Timeline> getTimeLines()
  {
    return this.timeLines;
  }
  
  @Nullable
  public final List<VoiceEnum> getVoiceChangerConfig()
  {
    return this.voiceChangerConfig;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RenderModel(renderScene=");
    localStringBuilder.append(this.renderScene);
    localStringBuilder.append(", root=");
    localStringBuilder.append(this.root);
    localStringBuilder.append(", inputSources=");
    localStringBuilder.append(this.inputSources);
    localStringBuilder.append(", painting=");
    localStringBuilder.append(this.painting);
    localStringBuilder.append(", clipsAssets=");
    localStringBuilder.append(this.clipsAssets);
    localStringBuilder.append(", modifyClipsDuration=");
    localStringBuilder.append(this.modifyClipsDuration);
    localStringBuilder.append(", seekTolerance=");
    localStringBuilder.append(this.seekTolerance);
    localStringBuilder.append(", properties=");
    localStringBuilder.append(this.properties);
    localStringBuilder.append(", audioAssets=");
    localStringBuilder.append(this.audioAssets);
    localStringBuilder.append(", timeLines=");
    localStringBuilder.append(this.timeLines);
    localStringBuilder.append(", maxDuration=");
    localStringBuilder.append(this.maxDuration);
    localStringBuilder.append(", componentLevel=");
    localStringBuilder.append(this.componentLevel);
    localStringBuilder.append(", voiceChangerConfig=");
    localStringBuilder.append(this.voiceChangerConfig);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.RenderModel
 * JD-Core Version:    0.7.0.1
 */