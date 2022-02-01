package shark;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ObjectReporter;", "", "heapObject", "Lshark/HeapObject;", "(Lshark/HeapObject;)V", "getHeapObject", "()Lshark/HeapObject;", "labels", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "getLabels", "()Ljava/util/LinkedHashSet;", "leakingReasons", "", "getLeakingReasons", "()Ljava/util/Set;", "likelyLeakingReasons", "getLikelyLeakingReasons$annotations", "()V", "getLikelyLeakingReasons", "notLeakingReasons", "getNotLeakingReasons", "whenInstanceOf", "", "expectedClassName", "block", "Lkotlin/Function2;", "Lshark/HeapObject$HeapInstance;", "Lkotlin/ExtensionFunctionType;", "expectedClass", "Lkotlin/reflect/KClass;", "shark"}, k=1, mv={1, 4, 1})
public final class ObjectReporter
{
  @NotNull
  private final LinkedHashSet<String> a;
  @NotNull
  private final Set<String> b;
  @NotNull
  private final Set<String> c;
  @NotNull
  private final HeapObject d;
  
  public ObjectReporter(@NotNull HeapObject paramHeapObject)
  {
    this.d = paramHeapObject;
    this.a = new LinkedHashSet();
    this.b = ((Set)new LinkedHashSet());
    this.c = ((Set)new LinkedHashSet());
  }
  
  @NotNull
  public final LinkedHashSet<String> a()
  {
    return this.a;
  }
  
  public final void a(@NotNull String paramString, @NotNull Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "expectedClassName");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "block");
    HeapObject localHeapObject = this.d;
    if (((localHeapObject instanceof HeapObject.HeapInstance)) && (((HeapObject.HeapInstance)localHeapObject).a(paramString))) {
      paramFunction2.invoke(this, localHeapObject);
    }
  }
  
  public final void a(@NotNull KClass<? extends Object> paramKClass, @NotNull Function2<? super ObjectReporter, ? super HeapObject.HeapInstance, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "expectedClass");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "block");
    paramKClass = JvmClassMappingKt.getJavaClass(paramKClass).getName();
    Intrinsics.checkExpressionValueIsNotNull(paramKClass, "expectedClass.java.name");
    a(paramKClass, paramFunction2);
  }
  
  @NotNull
  public final Set<String> b()
  {
    return this.b;
  }
  
  @NotNull
  public final Set<String> c()
  {
    return this.c;
  }
  
  @NotNull
  public final HeapObject d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ObjectReporter
 * JD-Core Version:    0.7.0.1
 */