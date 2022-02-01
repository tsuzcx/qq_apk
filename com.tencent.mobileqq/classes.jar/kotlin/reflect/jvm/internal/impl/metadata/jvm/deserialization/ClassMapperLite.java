package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class ClassMapperLite
{
  public static final ClassMapperLite INSTANCE = new ClassMapperLite();
  private static final Map<String, String> map;
  
  static
  {
    Map localMap = (Map)new LinkedHashMap();
    Object localObject1 = CollectionsKt.listOf(new String[] { "Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D" });
    Object localObject2 = RangesKt.step((IntProgression)CollectionsKt.getIndices((Collection)localObject1), 2);
    int i = ((IntProgression)localObject2).getFirst();
    int j = ((IntProgression)localObject2).getLast();
    int k = ((IntProgression)localObject2).getStep();
    Object localObject3;
    if (k >= 0 ? i <= j : i >= j) {
      for (;;)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("kotlin/");
        ((StringBuilder)localObject2).append((String)((List)localObject1).get(i));
        localObject2 = ((StringBuilder)localObject2).toString();
        int m = i + 1;
        localMap.put(localObject2, ((List)localObject1).get(m));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("kotlin/");
        ((StringBuilder)localObject2).append((String)((List)localObject1).get(i));
        ((StringBuilder)localObject2).append("Array");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append('[');
        ((StringBuilder)localObject3).append((String)((List)localObject1).get(m));
        localMap.put(localObject2, ((StringBuilder)localObject3).toString());
        if (i == j) {
          break;
        }
        i += k;
      }
    }
    localMap.put("kotlin/Unit", "V");
    localObject1 = new ClassMapperLite.map.1.1(localMap);
    ((ClassMapperLite.map.1.1)localObject1).invoke("Any", "java/lang/Object");
    ((ClassMapperLite.map.1.1)localObject1).invoke("Nothing", "java/lang/Void");
    ((ClassMapperLite.map.1.1)localObject1).invoke("Annotation", "java/lang/annotation/Annotation");
    localObject2 = CollectionsKt.listOf(new String[] { "String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum" }).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("java/lang/");
      ((StringBuilder)localObject4).append((String)localObject3);
      ((ClassMapperLite.map.1.1)localObject1).invoke((String)localObject3, ((StringBuilder)localObject4).toString());
    }
    localObject2 = CollectionsKt.listOf(new String[] { "Iterator", "Collection", "List", "Set", "Map", "ListIterator" }).iterator();
    StringBuilder localStringBuilder;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("collections/");
      ((StringBuilder)localObject4).append((String)localObject3);
      localObject4 = ((StringBuilder)localObject4).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("java/util/");
      localStringBuilder.append((String)localObject3);
      ((ClassMapperLite.map.1.1)localObject1).invoke((String)localObject4, localStringBuilder.toString());
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("collections/Mutable");
      ((StringBuilder)localObject4).append((String)localObject3);
      localObject4 = ((StringBuilder)localObject4).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("java/util/");
      localStringBuilder.append((String)localObject3);
      ((ClassMapperLite.map.1.1)localObject1).invoke((String)localObject4, localStringBuilder.toString());
    }
    ((ClassMapperLite.map.1.1)localObject1).invoke("collections/Iterable", "java/lang/Iterable");
    ((ClassMapperLite.map.1.1)localObject1).invoke("collections/MutableIterable", "java/lang/Iterable");
    ((ClassMapperLite.map.1.1)localObject1).invoke("collections/Map.Entry", "java/util/Map$Entry");
    ((ClassMapperLite.map.1.1)localObject1).invoke("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
    i = 0;
    while (i <= 22)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Function");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("kotlin/jvm/functions/Function");
      ((StringBuilder)localObject3).append(i);
      ((ClassMapperLite.map.1.1)localObject1).invoke((String)localObject2, ((StringBuilder)localObject3).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reflect/KFunction");
      ((StringBuilder)localObject2).append(i);
      ((ClassMapperLite.map.1.1)localObject1).invoke(((StringBuilder)localObject2).toString(), "kotlin/reflect/KFunction");
      i += 1;
    }
    localObject2 = CollectionsKt.listOf(new String[] { "Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum" }).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject3);
      ((StringBuilder)localObject4).append(".Companion");
      localObject4 = ((StringBuilder)localObject4).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("kotlin/jvm/internal/");
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append("CompanionObject");
      ((ClassMapperLite.map.1.1)localObject1).invoke((String)localObject4, localStringBuilder.toString());
    }
    map = localMap;
  }
  
  @JvmStatic
  @NotNull
  public static final String mapClass(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "classId");
    Object localObject = (String)map.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append('L');
    ((StringBuilder)localObject).append(StringsKt.replace$default(paramString, '.', '$', false, 4, null));
    ((StringBuilder)localObject).append(';');
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite
 * JD-Core Version:    0.7.0.1
 */