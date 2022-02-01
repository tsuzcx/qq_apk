package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOptionAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption;", "()V", "deserialize", "p0", "Lcom/google/gson/JsonElement;", "p1", "Ljava/lang/reflect/Type;", "p2", "Lcom/google/gson/JsonDeserializationContext;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PreloadEngineOptionAdapter
  implements JsonDeserializer<PreloadEngineOption>
{
  @NotNull
  public PreloadEngineOption a(@Nullable JsonElement paramJsonElement, @Nullable Type paramType, @Nullable JsonDeserializationContext paramJsonDeserializationContext)
  {
    paramJsonDeserializationContext = "unknown";
    paramType = paramJsonDeserializationContext;
    if (paramJsonElement != null) {}
    try
    {
      paramJsonElement = paramJsonElement.getAsString();
      paramType = paramJsonDeserializationContext;
      if (paramJsonElement != null) {
        paramType = paramJsonElement;
      }
    }
    catch (Exception paramJsonElement)
    {
      for (;;)
      {
        paramType = paramJsonDeserializationContext;
      }
    }
    return PreloadEngineOption.Companion.a(paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.PreloadEngineOptionAdapter
 * JD-Core Version:    0.7.0.1
 */