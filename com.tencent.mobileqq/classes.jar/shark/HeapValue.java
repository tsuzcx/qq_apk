package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapValue;", "", "graph", "Lshark/HeapGraph;", "holder", "Lshark/ValueHolder;", "(Lshark/HeapGraph;Lshark/ValueHolder;)V", "asBoolean", "", "getAsBoolean", "()Ljava/lang/Boolean;", "asByte", "", "getAsByte", "()Ljava/lang/Byte;", "asChar", "", "getAsChar", "()Ljava/lang/Character;", "asDouble", "", "getAsDouble", "()Ljava/lang/Double;", "asFloat", "", "getAsFloat", "()Ljava/lang/Float;", "asInt", "", "getAsInt", "()Ljava/lang/Integer;", "asLong", "", "getAsLong", "()Ljava/lang/Long;", "asNonNullObjectId", "getAsNonNullObjectId", "asObject", "Lshark/HeapObject;", "getAsObject", "()Lshark/HeapObject;", "asObjectId", "getAsObjectId", "asShort", "", "getAsShort", "()Ljava/lang/Short;", "getGraph", "()Lshark/HeapGraph;", "getHolder", "()Lshark/ValueHolder;", "isNonNullReference", "()Z", "isNullReference", "readAsJavaString", "", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HeapValue
{
  @NotNull
  private final HeapGraph a;
  @NotNull
  private final ValueHolder b;
  
  public HeapValue(@NotNull HeapGraph paramHeapGraph, @NotNull ValueHolder paramValueHolder)
  {
    this.a = paramHeapGraph;
    this.b = paramValueHolder;
  }
  
  @Nullable
  public final Integer a()
  {
    ValueHolder localValueHolder = this.b;
    if ((localValueHolder instanceof ValueHolder.IntHolder)) {
      return Integer.valueOf(((ValueHolder.IntHolder)localValueHolder).a());
    }
    return null;
  }
  
  @Nullable
  public final Long b()
  {
    ValueHolder localValueHolder = this.b;
    if ((localValueHolder instanceof ValueHolder.LongHolder)) {
      return Long.valueOf(((ValueHolder.LongHolder)localValueHolder).a());
    }
    return null;
  }
  
  @Nullable
  public final Long c()
  {
    ValueHolder localValueHolder = this.b;
    if (((localValueHolder instanceof ValueHolder.ReferenceHolder)) && (!((ValueHolder.ReferenceHolder)localValueHolder).a())) {
      return Long.valueOf(((ValueHolder.ReferenceHolder)this.b).b());
    }
    return null;
  }
  
  public final boolean d()
  {
    ValueHolder localValueHolder = this.b;
    return ((localValueHolder instanceof ValueHolder.ReferenceHolder)) && (!((ValueHolder.ReferenceHolder)localValueHolder).a());
  }
  
  @Nullable
  public final HeapObject e()
  {
    ValueHolder localValueHolder = this.b;
    if (((localValueHolder instanceof ValueHolder.ReferenceHolder)) && (!((ValueHolder.ReferenceHolder)localValueHolder).a())) {
      return this.a.a(((ValueHolder.ReferenceHolder)this.b).b());
    }
    return null;
  }
  
  @Nullable
  public final String f()
  {
    Object localObject3 = this.b;
    boolean bool = localObject3 instanceof ValueHolder.ReferenceHolder;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = localObject2;
      if (!((ValueHolder.ReferenceHolder)localObject3).a())
      {
        localObject3 = this.a.b(((ValueHolder.ReferenceHolder)this.b).b());
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((HeapObject)localObject3).f();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((HeapObject.HeapInstance)localObject3).o();
          }
        }
      }
    }
    return localObject1;
  }
  
  @NotNull
  public final ValueHolder g()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapValue
 * JD-Core Version:    0.7.0.1
 */