package com.tencent.tavcut.rendermodel.parser;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/parser/TemplateParser;", "", "()V", "COMPONENT_ID_INVALID", "", "KEY_COMPONENT_ID", "", "KEY_ENTITY_ID", "TAG", "exporter", "Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter;", "gson", "Lcom/google/gson/Gson;", "reader", "Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader;", "dumpInputSource", "inputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "dumpJson", "model", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "component", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "fromFile", "jsonFile", "Ljava/io/File;", "fromJson", "json", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TemplateParser
{
  public static final int COMPONENT_ID_INVALID = -1;
  public static final TemplateParser INSTANCE = new TemplateParser();
  @NotNull
  public static final String KEY_COMPONENT_ID = "componentID";
  @NotNull
  public static final String KEY_ENTITY_ID = "entityId";
  private static final String TAG = "TemplateParser";
  private static final LightJsonExporter exporter = new LightJsonExporter();
  private static final Gson gson = new Gson();
  private static final LightJsonReader reader = new LightJsonReader();
  
  @NotNull
  public final String dumpInputSource(@NotNull InputSource paramInputSource)
  {
    Intrinsics.checkParameterIsNotNull(paramInputSource, "inputSource");
    paramInputSource = gson.toJson(MapsKt.mapOf(TuplesKt.to(paramInputSource.key, paramInputSource)));
    Intrinsics.checkExpressionValueIsNotNull(paramInputSource, "gson.toJson(mapOf(inputSource.key to inputSource))");
    return paramInputSource;
  }
  
  @NotNull
  public final String dumpJson(@NotNull RenderModel paramRenderModel)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "model");
    return exporter.toTemplateJson(paramRenderModel);
  }
  
  @NotNull
  public final String dumpJson(@NotNull IdentifyComponent paramIdentifyComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramIdentifyComponent, "component");
    return exporter.toComponentJson(paramIdentifyComponent);
  }
  
  @NotNull
  public final String dumpJson(@NotNull Entity paramEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return exporter.toEntityJson(paramEntity);
  }
  
  @Nullable
  public final RenderModel fromFile(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "jsonFile");
    try
    {
      if (paramFile.exists())
      {
        RenderModel localRenderModel = reader.readRenderModel(new JsonReader((Reader)new FileReader(paramFile)));
        return localRenderModel;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromFile() called with: jsonFile = ");
      localStringBuilder.append(paramFile);
      Log.e("TemplateParser", localStringBuilder.toString(), (Throwable)localException);
    }
    return null;
  }
  
  @NotNull
  public final RenderModel fromJson(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "json");
    return reader.readRenderModel(new JsonReader((Reader)new StringReader(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.parser.TemplateParser
 * JD-Core Version:    0.7.0.1
 */