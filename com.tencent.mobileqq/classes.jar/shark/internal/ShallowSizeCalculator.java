package shark.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject;
import shark.HeapObject.HeapClass;
import shark.HeapObject.HeapInstance;
import shark.HeapObject.HeapObjectArray;
import shark.HeapObject.HeapPrimitiveArray;
import shark.HeapValue;
import shark.HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ShallowSizeCalculator;", "", "graph", "Lshark/HeapGraph;", "(Lshark/HeapGraph;)V", "computeShallowSize", "", "objectId", "", "shark"}, k=1, mv={1, 4, 1})
public final class ShallowSizeCalculator
{
  private final HeapGraph a;
  
  public ShallowSizeCalculator(@NotNull HeapGraph paramHeapGraph)
  {
    this.a = paramHeapGraph;
  }
  
  public final int a(long paramLong)
  {
    Object localObject1 = this.a.a(paramLong);
    boolean bool = localObject1 instanceof HeapObject.HeapInstance;
    HeapObject.HeapInstance localHeapInstance = null;
    long[] arrayOfLong = null;
    int i = 0;
    int j;
    if (bool)
    {
      localHeapInstance = (HeapObject.HeapInstance)localObject1;
      if (Intrinsics.areEqual(localHeapInstance.j(), "java.lang.String"))
      {
        Object localObject2 = localHeapInstance.b("java.lang.String", "value");
        localObject1 = arrayOfLong;
        if (localObject2 != null)
        {
          localObject2 = ((HeapField)localObject2).c();
          localObject1 = arrayOfLong;
          if (localObject2 != null) {
            localObject1 = ((HeapValue)localObject2).c();
          }
        }
        j = localHeapInstance.i();
        if (localObject1 != null) {
          i = a(((Long)localObject1).longValue());
        }
        return j + i;
      }
      return localHeapInstance.i();
    }
    if ((localObject1 instanceof HeapObject.HeapObjectArray))
    {
      localObject1 = (HeapObject.HeapObjectArray)localObject1;
      if (PathFinderKt.a((HeapObject.HeapObjectArray)localObject1))
      {
        arrayOfLong = ((HeapObject.HeapObjectArray)localObject1).j().d();
        int n = arrayOfLong.length * this.a.a();
        int k = arrayOfLong.length;
        i = 0;
        for (;;)
        {
          localObject1 = localHeapInstance;
          if (i >= k) {
            break;
          }
          paramLong = arrayOfLong[i];
          if (paramLong != 0L) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0)
          {
            localObject1 = Long.valueOf(paramLong);
            break;
          }
          i += 1;
        }
        if (localObject1 != null)
        {
          int i1 = a(((Long)localObject1).longValue());
          int i2 = arrayOfLong.length;
          i = 0;
          for (j = 0; i < i2; j = k)
          {
            int m;
            if (arrayOfLong[i] != 0L) {
              m = 1;
            } else {
              m = 0;
            }
            k = j;
            if (m != 0) {
              k = j + 1;
            }
            i += 1;
          }
          return n + i1 * j;
        }
        return n;
      }
      return ((HeapObject.HeapObjectArray)localObject1).i();
    }
    if ((localObject1 instanceof HeapObject.HeapPrimitiveArray)) {
      return ((HeapObject.HeapPrimitiveArray)localObject1).h();
    }
    if ((localObject1 instanceof HeapObject.HeapClass)) {
      return ((HeapObject)localObject1).d();
    }
    localObject1 = new NoWhenBranchMatchedException();
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ShallowSizeCalculator
 * JD-Core Version:    0.7.0.1
 */