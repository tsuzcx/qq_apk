package shark.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import shark.HeapObject.HeapObjectArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"skippablePrimitiveWrapperArrayTypes", "", "", "isSkippablePrimitiveWrapperArray", "", "Lshark/HeapObject$HeapObjectArray;", "(Lshark/HeapObject$HeapObjectArray;)Z", "shark"}, k=2, mv={1, 4, 1})
public final class PathFinderKt
{
  private static final List<String> a;
  
  static
  {
    Object localObject = (Iterable)SetsKt.setOf(new KClass[] { Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE) });
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      KClass localKClass = (KClass)((Iterator)localObject).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(JvmClassMappingKt.getJavaObjectType(localKClass).getName());
      localStringBuilder.append("[]");
      localCollection.add(localStringBuilder.toString());
    }
    a = (List)localCollection;
  }
  
  public static final boolean a(@NotNull HeapObject.HeapObjectArray paramHeapObjectArray)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapObjectArray, "$this$isSkippablePrimitiveWrapperArray");
    return a.contains(paramHeapObjectArray.h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.PathFinderKt
 * JD-Core Version:    0.7.0.1
 */