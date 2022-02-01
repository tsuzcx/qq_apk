package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class DeserializedPackageFragmentImpl$initialize$1
  extends Lambda
  implements Function0<List<? extends Name>>
{
  DeserializedPackageFragmentImpl$initialize$1(DeserializedPackageFragmentImpl paramDeserializedPackageFragmentImpl)
  {
    super(0);
  }
  
  @NotNull
  public final List<Name> invoke()
  {
    Object localObject1 = (Iterable)this.this$0.getClassDataFinder().getAllClassIds();
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      ClassId localClassId = (ClassId)localObject2;
      int i;
      if ((!localClassId.isNestedClass()) && (!ClassDeserializer.Companion.getBLACK_LIST().contains(localClassId))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localCollection.add(localObject2);
      }
    }
    localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localCollection.add(((ClassId)((Iterator)localObject1).next()).getShortClassName());
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl.initialize.1
 * JD-Core Version:    0.7.0.1
 */