package com.tencent.xaction.api.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.xaction.api.base.BaseAnim;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/BaseAnimAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lcom/google/gson/JsonDeserializer;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class BaseAnimAdapter
  implements JsonDeserializer<BaseAnim>, JsonSerializer<BaseAnim>
{
  @NotNull
  public JsonElement a(@Nullable BaseAnim paramBaseAnim, @NotNull Type paramType, @NotNull JsonSerializationContext paramJsonSerializationContext)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "typeOfSrc");
    Intrinsics.checkParameterIsNotNull(paramJsonSerializationContext, "context");
    paramBaseAnim = paramJsonSerializationContext.serialize(paramBaseAnim);
    Intrinsics.checkExpressionValueIsNotNull(paramBaseAnim, "context.serialize(src)");
    return paramBaseAnim;
  }
  
  @Nullable
  public BaseAnim a(@NotNull JsonElement paramJsonElement, @NotNull Type paramType, @NotNull JsonDeserializationContext paramJsonDeserializationContext)
  {
    Intrinsics.checkParameterIsNotNull(paramJsonElement, "json");
    Intrinsics.checkParameterIsNotNull(paramType, "typeOfT");
    Intrinsics.checkParameterIsNotNull(paramJsonDeserializationContext, "context");
    paramType = paramJsonElement.getAsJsonObject().get("type");
    Intrinsics.checkExpressionValueIsNotNull(paramType, "jsonObject[\"type\"]");
    paramType = paramType.getAsString();
    paramType = (Class)GsonAdapter.a.a().get(paramType);
    if (paramType != null) {
      return (BaseAnim)paramJsonDeserializationContext.deserialize(paramJsonElement, (Type)paramType);
    }
    return (BaseAnim)new BaseAnimAdapter.deserialize.1();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.util.BaseAnimAdapter
 * JD-Core Version:    0.7.0.1
 */