package com.tencent.tavcut.rendermodel.parser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.tavcut.composition.model.component.TimeRange;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/rendermodel/parser/LightJsonReader$timeRangeDecoder$1", "Lcom/google/gson/JsonDeserializer;", "Lcom/tencent/tavcut/composition/model/component/TimeRange;", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightJsonReader$timeRangeDecoder$1
  implements JsonDeserializer<TimeRange>
{
  @NotNull
  public TimeRange deserialize(@Nullable JsonElement paramJsonElement, @Nullable Type paramType, @Nullable JsonDeserializationContext paramJsonDeserializationContext)
  {
    if (paramJsonElement != null) {
      paramJsonElement = paramJsonElement.getAsJsonObject();
    } else {
      paramJsonElement = null;
    }
    if (paramJsonElement != null)
    {
      paramType = paramJsonElement.get("startTime");
      Intrinsics.checkExpressionValueIsNotNull(paramType, "it.get(\"startTime\")");
      long l = paramType.getAsLong();
      paramJsonElement = paramJsonElement.get("duration");
      Intrinsics.checkExpressionValueIsNotNull(paramJsonElement, "it.get(\"duration\")");
      return new TimeRange(l, paramJsonElement.getAsLong(), null, 4, null);
    }
    return new TimeRange(0L, 0L, null, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.parser.LightJsonReader.timeRangeDecoder.1
 * JD-Core Version:    0.7.0.1
 */