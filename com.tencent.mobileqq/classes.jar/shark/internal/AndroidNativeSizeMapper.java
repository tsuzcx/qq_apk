package shark.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import shark.HeapField;
import shark.HeapGraph;
import shark.HeapObject.HeapClass;
import shark.HeapObject.HeapInstance;
import shark.HeapValue;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/AndroidNativeSizeMapper;", "", "graph", "Lshark/HeapGraph;", "(Lshark/HeapGraph;)V", "mapNativeSizes", "", "", "", "shark"}, k=1, mv={1, 4, 1})
public final class AndroidNativeSizeMapper
{
  private final HeapGraph a;
  
  public AndroidNativeSizeMapper(@NotNull HeapGraph paramHeapGraph)
  {
    this.a = paramHeapGraph;
  }
  
  @NotNull
  public final Map<Long, Integer> a()
  {
    Map localMap = (Map)new LinkedHashMap();
    Object localObject1 = this.a.a("sun.misc.Cleaner");
    if (localObject1 != null)
    {
      Iterator localIterator = ((HeapObject.HeapClass)localObject1).p().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (HeapObject.HeapInstance)localIterator.next();
        HeapField localHeapField = ((HeapObject.HeapInstance)localObject1).b("sun.misc.Cleaner", "thunk");
        Integer localInteger = null;
        if (localHeapField != null)
        {
          localObject2 = localHeapField.c();
          if (localObject2 != null)
          {
            localObject2 = ((HeapValue)localObject2).c();
            break label108;
          }
        }
        Object localObject2 = null;
        label108:
        Object localObject3 = ((HeapObject.HeapInstance)localObject1).b("java.lang.ref.Reference", "referent");
        localObject1 = localInteger;
        if (localObject3 != null)
        {
          localObject3 = ((HeapField)localObject3).c();
          localObject1 = localInteger;
          if (localObject3 != null) {
            localObject1 = ((HeapValue)localObject3).c();
          }
        }
        if ((localObject2 != null) && (localObject1 != null))
        {
          localObject2 = localHeapField.c().e();
          if ((localObject2 instanceof HeapObject.HeapInstance))
          {
            localObject2 = (HeapObject.HeapInstance)localObject2;
            if (((HeapObject.HeapInstance)localObject2).a("libcore.util.NativeAllocationRegistry$CleanerThunk"))
            {
              localObject2 = ((HeapObject.HeapInstance)localObject2).b("libcore.util.NativeAllocationRegistry$CleanerThunk", "this$0");
              if ((localObject2 != null) && (((HeapField)localObject2).c().d()))
              {
                localObject2 = ((HeapField)localObject2).c().e();
                if ((localObject2 instanceof HeapObject.HeapInstance))
                {
                  localObject2 = (HeapObject.HeapInstance)localObject2;
                  if (((HeapObject.HeapInstance)localObject2).a("libcore.util.NativeAllocationRegistry"))
                  {
                    localInteger = (Integer)localMap.get(localObject1);
                    int k = 0;
                    int i;
                    if (localInteger != null) {
                      i = localInteger.intValue();
                    } else {
                      i = 0;
                    }
                    localObject2 = ((HeapObject.HeapInstance)localObject2).b("libcore.util.NativeAllocationRegistry", "size");
                    int j = k;
                    if (localObject2 != null)
                    {
                      localObject2 = ((HeapField)localObject2).c();
                      j = k;
                      if (localObject2 != null)
                      {
                        localObject2 = ((HeapValue)localObject2).b();
                        j = k;
                        if (localObject2 != null) {
                          j = (int)((Long)localObject2).longValue();
                        }
                      }
                    }
                    localMap.put(localObject1, Integer.valueOf(i + j));
                  }
                }
              }
            }
          }
        }
      }
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.AndroidNativeSizeMapper
 * JD-Core Version:    0.7.0.1
 */