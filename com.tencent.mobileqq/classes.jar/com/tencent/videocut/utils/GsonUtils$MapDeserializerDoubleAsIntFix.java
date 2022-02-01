package com.tencent.videocut.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/GsonUtils$MapDeserializerDoubleAsIntFix;", "Lcom/google/gson/JsonDeserializer;", "", "", "", "()V", "deserialize", "jsonElement", "Lcom/google/gson/JsonElement;", "type", "Ljava/lang/reflect/Type;", "jsonDeserializationContext", "Lcom/google/gson/JsonDeserializationContext;", "read", "input", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class GsonUtils$MapDeserializerDoubleAsIntFix
  implements JsonDeserializer<Map<String, ? extends Object>>
{
  @NotNull
  public static final MapDeserializerDoubleAsIntFix a = new MapDeserializerDoubleAsIntFix();
  
  @Nullable
  public final Object a(@NotNull JsonElement paramJsonElement)
  {
    Intrinsics.checkNotNullParameter(paramJsonElement, "input");
    Object localObject1;
    Object localObject2;
    if (paramJsonElement.isJsonArray())
    {
      localObject1 = (List)new ArrayList();
      paramJsonElement = paramJsonElement.getAsJsonArray();
      Intrinsics.checkNotNullExpressionValue(paramJsonElement, "input.asJsonArray");
      paramJsonElement = paramJsonElement.iterator();
      while (paramJsonElement.hasNext())
      {
        localObject2 = (JsonElement)paramJsonElement.next();
        Intrinsics.checkNotNullExpressionValue(localObject2, "anArr");
        ((List)localObject1).add(a((JsonElement)localObject2));
      }
      return localObject1;
    }
    if (paramJsonElement.isJsonObject())
    {
      localObject1 = (Map)new LinkedTreeMap();
      paramJsonElement = paramJsonElement.getAsJsonObject();
      Intrinsics.checkNotNullExpressionValue(paramJsonElement, "input.asJsonObject");
      paramJsonElement = paramJsonElement.entrySet();
      Intrinsics.checkNotNullExpressionValue(paramJsonElement, "obj.entrySet()");
      paramJsonElement = paramJsonElement.iterator();
      while (paramJsonElement.hasNext())
      {
        localObject2 = (Map.Entry)paramJsonElement.next();
        ((Map)localObject1).put((String)((Map.Entry)localObject2).getKey(), a((JsonElement)((Map.Entry)localObject2).getValue()));
      }
      return localObject1;
    }
    if (paramJsonElement.isJsonPrimitive())
    {
      paramJsonElement = paramJsonElement.getAsJsonPrimitive();
      Intrinsics.checkNotNullExpressionValue(paramJsonElement, "input.asJsonPrimitive");
      if (paramJsonElement.isBoolean()) {
        return Boolean.valueOf(paramJsonElement.getAsBoolean());
      }
      if (paramJsonElement.isString()) {
        return paramJsonElement.getAsString();
      }
      if (paramJsonElement.isNumber())
      {
        paramJsonElement = paramJsonElement.getAsNumber();
        Intrinsics.checkNotNullExpressionValue(paramJsonElement, "prim.asNumber");
        if (Math.ceil(paramJsonElement.doubleValue()) == paramJsonElement.longValue()) {
          return Long.valueOf(paramJsonElement.longValue());
        }
        return Double.valueOf(paramJsonElement.doubleValue());
      }
    }
    return null;
  }
  
  @Nullable
  public Map<String, Object> a(@NotNull JsonElement paramJsonElement, @NotNull Type paramType, @NotNull JsonDeserializationContext paramJsonDeserializationContext)
  {
    Intrinsics.checkNotNullParameter(paramJsonElement, "jsonElement");
    Intrinsics.checkNotNullParameter(paramType, "type");
    Intrinsics.checkNotNullParameter(paramJsonDeserializationContext, "jsonDeserializationContext");
    return (Map)a(paramJsonElement);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.GsonUtils.MapDeserializerDoubleAsIntFix
 * JD-Core Version:    0.7.0.1
 */