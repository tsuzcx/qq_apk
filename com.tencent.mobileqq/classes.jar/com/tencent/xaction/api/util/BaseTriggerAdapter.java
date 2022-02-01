package com.tencent.xaction.api.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.xaction.trigger.BaseTrigger;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/BaseTriggerAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/tencent/xaction/trigger/BaseTrigger;", "Lcom/google/gson/JsonDeserializer;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class BaseTriggerAdapter
  implements JsonDeserializer<BaseTrigger>, JsonSerializer<BaseTrigger>
{
  @NotNull
  public JsonElement a(@Nullable BaseTrigger paramBaseTrigger, @NotNull Type paramType, @NotNull JsonSerializationContext paramJsonSerializationContext)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "typeOfSrc");
    Intrinsics.checkParameterIsNotNull(paramJsonSerializationContext, "context");
    paramBaseTrigger = paramJsonSerializationContext.serialize(paramBaseTrigger);
    Intrinsics.checkExpressionValueIsNotNull(paramBaseTrigger, "context.serialize(src)");
    return paramBaseTrigger;
  }
  
  @Nullable
  public BaseTrigger a(@NotNull JsonElement paramJsonElement, @NotNull Type paramType, @NotNull JsonDeserializationContext paramJsonDeserializationContext)
  {
    Intrinsics.checkParameterIsNotNull(paramJsonElement, "json");
    Intrinsics.checkParameterIsNotNull(paramType, "typeOfT");
    Intrinsics.checkParameterIsNotNull(paramJsonDeserializationContext, "context");
    paramType = paramJsonElement.getAsJsonObject().get("type");
    Intrinsics.checkExpressionValueIsNotNull(paramType, "jsonObject[\"type\"]");
    paramType = paramType.getAsString();
    paramType = (Class)GsonAdapter.a.b().get(paramType);
    if (paramType != null) {
      return (BaseTrigger)paramJsonDeserializationContext.deserialize(paramJsonElement, (Type)paramType);
    }
    return (BaseTrigger)new BaseTriggerAdapter.deserialize.1();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.util.BaseTriggerAdapter
 * JD-Core Version:    0.7.0.1
 */