package com.tencent.xaction.api.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.drawable.DefaultDrawable.DefaultDrawableState;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/BaseDrawableAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "Lcom/google/gson/JsonDeserializer;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class BaseDrawableAdapter
  implements JsonDeserializer<DecorDrawableState>, JsonSerializer<DecorDrawableState>
{
  @NotNull
  public JsonElement a(@Nullable DecorDrawableState paramDecorDrawableState, @NotNull Type paramType, @NotNull JsonSerializationContext paramJsonSerializationContext)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "typeOfSrc");
    Intrinsics.checkParameterIsNotNull(paramJsonSerializationContext, "context");
    paramDecorDrawableState = paramJsonSerializationContext.serialize(paramDecorDrawableState);
    Intrinsics.checkExpressionValueIsNotNull(paramDecorDrawableState, "context.serialize(src)");
    return paramDecorDrawableState;
  }
  
  @Nullable
  public DecorDrawableState a(@NotNull JsonElement paramJsonElement, @NotNull Type paramType, @NotNull JsonDeserializationContext paramJsonDeserializationContext)
  {
    Intrinsics.checkParameterIsNotNull(paramJsonElement, "json");
    Intrinsics.checkParameterIsNotNull(paramType, "typeOfT");
    Intrinsics.checkParameterIsNotNull(paramJsonDeserializationContext, "context");
    paramType = paramJsonElement.getAsJsonObject().get("type");
    Intrinsics.checkExpressionValueIsNotNull(paramType, "jsonObject[\"type\"]");
    paramType = paramType.getAsString();
    paramType = (String)GsonAdapter.a.c().get(paramType);
    if (paramType != null) {
      try
      {
        paramJsonElement = (DecorDrawableState)paramJsonDeserializationContext.deserialize(paramJsonElement, (Type)Class.forName(paramType));
        return paramJsonElement;
      }
      catch (ClassNotFoundException paramJsonElement)
      {
        paramJsonElement.printStackTrace();
        return (DecorDrawableState)new DefaultDrawable.DefaultDrawableState();
      }
    }
    return (DecorDrawableState)new DefaultDrawable.DefaultDrawableState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.util.BaseDrawableAdapter
 * JD-Core Version:    0.7.0.1
 */