package shark.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.HeapField;
import shark.HeapObject.HeapInstance;
import shark.HeapValue;
import shark.ValueHolder.ReferenceHolder;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/KeyedWeakReferenceMirror$Companion;", "", "()V", "UNKNOWN_LEGACY", "", "fromInstance", "Lshark/internal/KeyedWeakReferenceMirror;", "weakRef", "Lshark/HeapObject$HeapInstance;", "heapDumpUptimeMillis", "", "(Lshark/HeapObject$HeapInstance;Ljava/lang/Long;)Lshark/internal/KeyedWeakReferenceMirror;", "shark"}, k=1, mv={1, 4, 1})
public final class KeyedWeakReferenceMirror$Companion
{
  @NotNull
  public final KeyedWeakReferenceMirror a(@NotNull HeapObject.HeapInstance paramHeapInstance, @Nullable Long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapInstance, "weakRef");
    String str1 = paramHeapInstance.j();
    Object localObject2 = null;
    long l1;
    Object localObject1;
    if (paramLong != null)
    {
      l1 = paramLong.longValue();
      localObject1 = paramHeapInstance.b(str1, "watchUptimeMillis");
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((HeapField)localObject1).c().b();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = Long.valueOf(l1 - ((Long)localObject1).longValue());
    }
    else
    {
      localObject1 = null;
    }
    if (paramLong != null)
    {
      localObject2 = paramHeapInstance.b(str1, "retainedUptimeMillis");
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((HeapField)localObject2).c().b();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      long l2 = ((Long)localObject2).longValue();
      l1 = -1L;
      if (l2 != -1L) {
        l1 = paramLong.longValue() - l2;
      }
      localObject2 = Long.valueOf(l1);
    }
    paramLong = paramHeapInstance.b(str1, "key");
    if (paramLong == null) {
      Intrinsics.throwNpe();
    }
    String str2 = paramLong.c().f();
    if (str2 == null) {
      Intrinsics.throwNpe();
    }
    paramLong = paramHeapInstance.b(str1, "description");
    if (paramLong == null) {
      paramLong = paramHeapInstance.b(str1, "name");
    }
    if (paramLong != null)
    {
      paramLong = paramLong.c();
      if (paramLong != null)
      {
        paramLong = paramLong.f();
        if (paramLong != null) {
          break label241;
        }
      }
    }
    paramLong = "Unknown (legacy)";
    label241:
    paramHeapInstance = paramHeapInstance.b("java.lang.ref.Reference", "referent");
    if (paramHeapInstance == null) {
      Intrinsics.throwNpe();
    }
    paramHeapInstance = paramHeapInstance.c().g();
    if (paramHeapInstance != null) {
      return new KeyedWeakReferenceMirror((ValueHolder.ReferenceHolder)paramHeapInstance, str2, paramLong, (Long)localObject1, (Long)localObject2);
    }
    throw new TypeCastException("null cannot be cast to non-null type shark.ValueHolder.ReferenceHolder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.KeyedWeakReferenceMirror.Companion
 * JD-Core Version:    0.7.0.1
 */