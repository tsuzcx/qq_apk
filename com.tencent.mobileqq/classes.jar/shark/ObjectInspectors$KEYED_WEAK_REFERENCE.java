package shark;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import shark.internal.KeyedWeakReferenceMirror;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ObjectInspectors$KEYED_WEAK_REFERENCE;", "Lshark/ObjectInspectors;", "leakingObjectFilter", "Lkotlin/Function1;", "Lshark/HeapObject;", "", "getLeakingObjectFilter$shark", "()Lkotlin/jvm/functions/Function1;", "inspect", "", "reporter", "Lshark/ObjectReporter;", "shark"}, k=1, mv={1, 4, 1})
final class ObjectInspectors$KEYED_WEAK_REFERENCE
  extends ObjectInspectors
{
  @NotNull
  private final Function1<HeapObject, Boolean> leakingObjectFilter = (Function1)ObjectInspectors.KEYED_WEAK_REFERENCE.leakingObjectFilter.1.INSTANCE;
  
  ObjectInspectors$KEYED_WEAK_REFERENCE()
  {
    super(str, i, null);
  }
  
  @NotNull
  public Function1<HeapObject, Boolean> getLeakingObjectFilter$shark()
  {
    return this.leakingObjectFilter;
  }
  
  public void inspect(@NotNull ObjectReporter paramObjectReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramObjectReporter, "reporter");
    Object localObject1 = paramObjectReporter.d().a();
    localObject1 = KeyedWeakReferenceFinder.a.c((HeapGraph)localObject1);
    long l = paramObjectReporter.d().b();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      KeyedWeakReferenceMirror localKeyedWeakReferenceMirror = (KeyedWeakReferenceMirror)localIterator.next();
      if (localKeyedWeakReferenceMirror.c().b() == l)
      {
        Object localObject2 = (Collection)paramObjectReporter.b();
        int i;
        if (((CharSequence)localKeyedWeakReferenceMirror.e()).length() > 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("ObjectWatcher was watching this because ");
          ((StringBuilder)localObject1).append(localKeyedWeakReferenceMirror.e());
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = "ObjectWatcher was watching this";
        }
        ((Collection)localObject2).add(localObject1);
        localObject1 = (Collection)paramObjectReporter.a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("key = ");
        ((StringBuilder)localObject2).append(localKeyedWeakReferenceMirror.d());
        ((Collection)localObject1).add(((StringBuilder)localObject2).toString());
        if (localKeyedWeakReferenceMirror.f() != null)
        {
          localObject1 = (Collection)paramObjectReporter.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("watchDurationMillis = ");
          ((StringBuilder)localObject2).append(localKeyedWeakReferenceMirror.f());
          ((Collection)localObject1).add(((StringBuilder)localObject2).toString());
        }
        if (localKeyedWeakReferenceMirror.g() != null)
        {
          localObject1 = (Collection)paramObjectReporter.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("retainedDurationMillis = ");
          ((StringBuilder)localObject2).append(localKeyedWeakReferenceMirror.g());
          ((Collection)localObject1).add(((StringBuilder)localObject2).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectInspectors.KEYED_WEAK_REFERENCE
 * JD-Core Version:    0.7.0.1
 */