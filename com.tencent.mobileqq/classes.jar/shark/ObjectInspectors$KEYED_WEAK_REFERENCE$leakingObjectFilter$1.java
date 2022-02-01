package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import shark.internal.KeyedWeakReferenceMirror;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "heapObject", "Lshark/HeapObject;", "invoke"}, k=3, mv={1, 4, 1})
final class ObjectInspectors$KEYED_WEAK_REFERENCE$leakingObjectFilter$1
  extends Lambda
  implements Function1<HeapObject, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  ObjectInspectors$KEYED_WEAK_REFERENCE$leakingObjectFilter$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull HeapObject paramHeapObject)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapObject, "heapObject");
    Object localObject2 = (Iterable)KeyedWeakReferenceFinder.a.c(paramHeapObject.a());
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    int i;
    boolean bool2;
    for (;;)
    {
      bool1 = ((Iterator)localObject2).hasNext();
      i = 1;
      bool2 = false;
      if (!bool1) {
        break;
      }
      Object localObject3 = ((Iterator)localObject2).next();
      KeyedWeakReferenceMirror localKeyedWeakReferenceMirror = (KeyedWeakReferenceMirror)localObject3;
      if ((!localKeyedWeakReferenceMirror.a()) || (!localKeyedWeakReferenceMirror.b())) {
        i = 0;
      }
      if (i != 0) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (Iterable)localObject1;
    if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
      return false;
    }
    localObject1 = ((Iterable)localObject1).iterator();
    do
    {
      bool1 = bool2;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      if (((KeyedWeakReferenceMirror)((Iterator)localObject1).next()).c().b() == paramHeapObject.b()) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i == 0);
    boolean bool1 = true;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspectors.KEYED_WEAK_REFERENCE.leakingObjectFilter.1
 * JD-Core Version:    0.7.0.1
 */