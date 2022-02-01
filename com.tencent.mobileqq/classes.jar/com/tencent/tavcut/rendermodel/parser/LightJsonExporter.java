package com.tencent.tavcut.rendermodel.parser;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.lang.reflect.Type;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "toComponentJson", "", "component", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "toEntityJson", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "toTemplateJson", "model", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "Companion", "IdentifyComponentTypeAdapter", "RenderModelExclusionStrategy", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightJsonExporter
{
  public static final LightJsonExporter.Companion Companion = new LightJsonExporter.Companion(null);
  private static final Set<String> SKIP_FILED_NAMES = SetsKt.setOf(new String[] { "renderScene", "timeLines", "clipsAssets", "painting", "modifyClipsDuration", "seekTolerance", "voiceChangerConfig" });
  private final Gson gson = new GsonBuilder().registerTypeAdapter((Type)IdentifyComponent.class, new LightJsonExporter.IdentifyComponentTypeAdapter(this)).setExclusionStrategies(new ExclusionStrategy[] { (ExclusionStrategy)new LightJsonExporter.RenderModelExclusionStrategy(this) }).setPrettyPrinting().create();
  
  @NotNull
  public final String toComponentJson(@NotNull IdentifyComponent paramIdentifyComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramIdentifyComponent, "component");
    paramIdentifyComponent = this.gson.toJson(paramIdentifyComponent);
    Intrinsics.checkExpressionValueIsNotNull(paramIdentifyComponent, "gson.toJson(component)");
    return paramIdentifyComponent;
  }
  
  @NotNull
  public final String toEntityJson(@NotNull Entity paramEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    paramEntity = this.gson.toJson(paramEntity);
    Intrinsics.checkExpressionValueIsNotNull(paramEntity, "gson.toJson(entity)");
    return paramEntity;
  }
  
  @NotNull
  public final String toTemplateJson(@NotNull RenderModel paramRenderModel)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "model");
    paramRenderModel = this.gson.toJson(paramRenderModel);
    Intrinsics.checkExpressionValueIsNotNull(paramRenderModel, "gson.toJson(model)");
    return paramRenderModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.parser.LightJsonExporter
 * JD-Core Version:    0.7.0.1
 */