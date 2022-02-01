package com.tencent.tavcut.rendermodel.parser;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter$RenderModelExclusionStrategy;", "Lcom/google/gson/ExclusionStrategy;", "(Lcom/tencent/tavcut/rendermodel/parser/LightJsonExporter;)V", "shouldSkipClass", "", "clazz", "Ljava/lang/Class;", "shouldSkipField", "f", "Lcom/google/gson/FieldAttributes;", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
final class LightJsonExporter$RenderModelExclusionStrategy
  implements ExclusionStrategy
{
  public boolean shouldSkipClass(@Nullable Class<?> paramClass)
  {
    return false;
  }
  
  public boolean shouldSkipField(@Nullable FieldAttributes paramFieldAttributes)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramFieldAttributes != null) {
      localObject1 = paramFieldAttributes.getName();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Set localSet = LightJsonExporter.access$getSKIP_FILED_NAMES$cp();
      localObject1 = localObject2;
      if (paramFieldAttributes != null) {
        localObject1 = paramFieldAttributes.getName();
      }
      return localSet.contains(localObject1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.parser.LightJsonExporter.RenderModelExclusionStrategy
 * JD-Core Version:    0.7.0.1
 */