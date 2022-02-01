package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey;", "()V", "deserialize", "p0", "Lcom/google/gson/JsonElement;", "p1", "Ljava/lang/reflect/Type;", "p2", "Lcom/google/gson/JsonDeserializationContext;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandModuleAdapter
  implements JsonDeserializer<ExpandModuleKey>
{
  @NotNull
  public ExpandModuleKey a(@Nullable JsonElement paramJsonElement, @Nullable Type paramType, @Nullable JsonDeserializationContext paramJsonDeserializationContext)
  {
    paramJsonDeserializationContext = "Unknown";
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
    return ExpandModuleKey.Companion.a(paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.ExpandModuleAdapter
 * JD-Core Version:    0.7.0.1
 */