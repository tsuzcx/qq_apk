package com.tencent.tavcut.rendermodel.parser;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter$IdentifyComponentTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "(Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter;)V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
final class LightJsonExporter$IdentifyComponentTypeAdapter
  extends TypeAdapter<IdentifyComponent>
{
  @NotNull
  public IdentifyComponent read(@Nullable JsonReader paramJsonReader)
  {
    paramJsonReader = new Gson().fromJson(paramJsonReader, (Type)IdentifyComponent.class);
    Intrinsics.checkExpressionValueIsNotNull(paramJsonReader, "Gson().fromJson(`in`, Id…ifyComponent::class.java)");
    return (IdentifyComponent)paramJsonReader;
  }
  
  public void write(@Nullable JsonWriter paramJsonWriter, @Nullable IdentifyComponent paramIdentifyComponent)
  {
    Object localObject3 = LightJsonExporter.access$getGson$p(this.this$0);
    Object localObject2 = null;
    if (paramIdentifyComponent != null) {
      localObject1 = paramIdentifyComponent.getData();
    } else {
      localObject1 = null;
    }
    localObject3 = ((Gson)localObject3).toJsonTree(localObject1);
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof JsonObject)) {
      localObject1 = null;
    }
    localObject3 = (JsonObject)localObject1;
    if (localObject3 != null)
    {
      if (paramIdentifyComponent != null) {
        localObject1 = paramIdentifyComponent.getData();
      } else {
        localObject1 = null;
      }
      if ((localObject1 instanceof Priority)) {
        return;
      }
      if (paramIdentifyComponent != null) {
        localObject1 = paramIdentifyComponent.getData();
      } else {
        localObject1 = null;
      }
      if ((localObject1 instanceof EntityIdentifier))
      {
        ((JsonObject)localObject3).addProperty("id", (Number)paramIdentifyComponent.getEntityId());
      }
      else
      {
        if (paramIdentifyComponent != null) {
          localObject1 = paramIdentifyComponent.getId();
        } else {
          localObject1 = null;
        }
        ((JsonObject)localObject3).addProperty("componentID", (Number)localObject1);
        if (paramIdentifyComponent != null) {
          localObject1 = paramIdentifyComponent.getEntityId();
        } else {
          localObject1 = null;
        }
        ((JsonObject)localObject3).addProperty("entityId", (Number)localObject1);
      }
      if (paramIdentifyComponent != null)
      {
        paramIdentifyComponent = paramIdentifyComponent.getRawData();
        if (paramIdentifyComponent != null)
        {
          localObject1 = paramIdentifyComponent.deepCopy();
          if (localObject1 != null)
          {
            paramIdentifyComponent = ((JsonObject)localObject3).entrySet();
            Intrinsics.checkExpressionValueIsNotNull(paramIdentifyComponent, "element.entrySet()");
            paramIdentifyComponent = ((Iterable)paramIdentifyComponent).iterator();
            while (paramIdentifyComponent.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)paramIdentifyComponent.next();
              ((JsonObject)localObject1).add((String)localEntry.getKey(), (JsonElement)localEntry.getValue());
            }
            paramIdentifyComponent = localObject2;
            if (paramJsonWriter != null) {
              paramIdentifyComponent = paramJsonWriter.jsonValue(LightJsonExporter.access$getGson$p(this.this$0).toJson((JsonElement)localObject1));
            }
            if (paramIdentifyComponent != null) {
              return;
            }
          }
        }
      }
      if (paramJsonWriter != null) {
        paramJsonWriter.jsonValue(LightJsonExporter.access$getGson$p(this.this$0).toJson((JsonElement)localObject3));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.parser.LightJsonExporter.IdentifyComponentTypeAdapter
 * JD-Core Version:    0.7.0.1
 */