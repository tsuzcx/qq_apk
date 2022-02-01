package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassMemberScope$enumEntryIndex$1
  extends Lambda
  implements Function0<Map<Name, ? extends JavaField>>
{
  LazyJavaClassMemberScope$enumEntryIndex$1(LazyJavaClassMemberScope paramLazyJavaClassMemberScope)
  {
    super(0);
  }
  
  @NotNull
  public final Map<Name, JavaField> invoke()
  {
    Object localObject2 = (Iterable)LazyJavaClassMemberScope.access$getJClass$p(this.this$0).getFields();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((JavaField)localObject3).isEnumEntry()) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10)), 16));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((JavaField)localObject3).getName(), localObject3);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.enumEntryIndex.1
 * JD-Core Version:    0.7.0.1
 */