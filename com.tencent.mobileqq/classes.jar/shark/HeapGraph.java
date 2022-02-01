package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapGraph;", "", "classCount", "", "getClassCount", "()I", "classes", "Lkotlin/sequences/Sequence;", "Lshark/HeapObject$HeapClass;", "getClasses", "()Lkotlin/sequences/Sequence;", "context", "Lshark/GraphContext;", "getContext", "()Lshark/GraphContext;", "gcRoots", "", "Lshark/GcRoot;", "getGcRoots", "()Ljava/util/List;", "identifierByteSize", "getIdentifierByteSize", "instanceCount", "getInstanceCount", "instances", "Lshark/HeapObject$HeapInstance;", "getInstances", "objectArrayCount", "getObjectArrayCount", "objectArrays", "Lshark/HeapObject$HeapObjectArray;", "getObjectArrays", "objectCount", "getObjectCount", "objects", "Lshark/HeapObject;", "getObjects", "primitiveArrayCount", "getPrimitiveArrayCount", "primitiveArrays", "Lshark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrays", "findClassByName", "className", "", "findObjectById", "objectId", "", "findObjectByIdOrNull", "findObjectByIndex", "objectIndex", "objectExists", "", "shark-graph"}, k=1, mv={1, 4, 1})
public abstract interface HeapGraph
{
  public abstract int a();
  
  @Nullable
  public abstract HeapObject.HeapClass a(@NotNull String paramString);
  
  @NotNull
  public abstract HeapObject a(long paramLong);
  
  @NotNull
  public abstract GraphContext b();
  
  @Nullable
  public abstract HeapObject b(long paramLong);
  
  public abstract int c();
  
  public abstract boolean c(long paramLong);
  
  @NotNull
  public abstract List<GcRoot> d();
  
  @NotNull
  public abstract Sequence<HeapObject> e();
  
  @NotNull
  public abstract Sequence<HeapObject.HeapInstance> f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapGraph
 * JD-Core Version:    0.7.0.1
 */