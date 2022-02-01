package shark.internal;

import java.util.EnumSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.Ref.LongRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.HprofHeader;
import shark.HprofRecordTag;
import shark.HprofRecordTag.Companion;
import shark.OnHprofRecordTagListener;
import shark.OnHprofRecordTagListener.Companion;
import shark.ProguardMapping;
import shark.StreamingHprofReader;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/HprofInMemoryIndex$Companion;", "", "()V", "byteSizeForUnsigned", "", "maxValue", "", "indexHprof", "Lshark/internal/HprofInMemoryIndex;", "reader", "Lshark/StreamingHprofReader;", "hprofHeader", "Lshark/HprofHeader;", "proguardMapping", "Lshark/ProguardMapping;", "indexedGcRootTags", "", "Lshark/HprofRecordTag;", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HprofInMemoryIndex$Companion
{
  private final int a(long paramLong)
  {
    int i = 0;
    while (paramLong != 0L)
    {
      paramLong >>= 8;
      i += 1;
    }
    return i;
  }
  
  @NotNull
  public final HprofInMemoryIndex a(@NotNull StreamingHprofReader paramStreamingHprofReader, @NotNull HprofHeader paramHprofHeader, @Nullable ProguardMapping paramProguardMapping, @NotNull Set<? extends HprofRecordTag> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramStreamingHprofReader, "reader");
    Intrinsics.checkParameterIsNotNull(paramHprofHeader, "hprofHeader");
    Intrinsics.checkParameterIsNotNull(paramSet, "indexedGcRootTags");
    Object localObject1 = new Ref.LongRef();
    ((Ref.LongRef)localObject1).element = 0L;
    Object localObject2 = new Ref.LongRef();
    ((Ref.LongRef)localObject2).element = 0L;
    Ref.LongRef localLongRef1 = new Ref.LongRef();
    localLongRef1.element = 0L;
    Ref.LongRef localLongRef2 = new Ref.LongRef();
    localLongRef2.element = 0L;
    Ref.IntRef localIntRef1 = new Ref.IntRef();
    localIntRef1.element = 0;
    Ref.IntRef localIntRef2 = new Ref.IntRef();
    localIntRef2.element = 0;
    Ref.IntRef localIntRef3 = new Ref.IntRef();
    localIntRef3.element = 0;
    Ref.IntRef localIntRef4 = new Ref.IntRef();
    localIntRef4.element = 0;
    Ref.IntRef localIntRef5 = new Ref.IntRef();
    localIntRef5.element = 0;
    Object localObject3 = EnumSet.of((Enum)HprofRecordTag.CLASS_DUMP, (Enum)HprofRecordTag.INSTANCE_DUMP, (Enum)HprofRecordTag.OBJECT_ARRAY_DUMP, (Enum)HprofRecordTag.PRIMITIVE_ARRAY_DUMP);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "EnumSet.of(CLASS_DUMP, I…MP, PRIMITIVE_ARRAY_DUMP)");
    localObject3 = (Set)localObject3;
    OnHprofRecordTagListener.Companion localCompanion = OnHprofRecordTagListener.a;
    long l = paramStreamingHprofReader.a((Set)localObject3, (OnHprofRecordTagListener)new HprofInMemoryIndex.Companion.indexHprof..inlined.invoke.1(localIntRef1, (Ref.LongRef)localObject1, localIntRef5, localIntRef2, (Ref.LongRef)localObject2, localIntRef3, localLongRef1, localIntRef4, localLongRef2));
    localObject3 = (Companion)this;
    int i = ((Companion)localObject3).a(((Ref.LongRef)localObject1).element);
    int j = ((Companion)localObject3).a(((Ref.LongRef)localObject2).element);
    int k = ((Companion)localObject3).a(localLongRef1.element);
    int m = ((Companion)localObject3).a(localLongRef2.element);
    boolean bool;
    if (paramHprofHeader.c() == 8) {
      bool = true;
    } else {
      bool = false;
    }
    localObject1 = new HprofInMemoryIndex.Builder(bool, l, localIntRef1.element, localIntRef2.element, localIntRef3.element, localIntRef4.element, i, j, k, m, localIntRef5.element);
    localObject2 = EnumSet.of((Enum)HprofRecordTag.STRING_IN_UTF8, new HprofRecordTag[] { HprofRecordTag.LOAD_CLASS, HprofRecordTag.CLASS_DUMP, HprofRecordTag.INSTANCE_DUMP, HprofRecordTag.OBJECT_ARRAY_DUMP, HprofRecordTag.PRIMITIVE_ARRAY_DUMP });
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "EnumSet.of(\n        STRI…MITIVE_ARRAY_DUMP\n      )");
    paramStreamingHprofReader.a(SetsKt.plus((Set)localObject2, (Iterable)CollectionsKt.intersect((Iterable)HprofRecordTag.Companion.a(), (Iterable)paramSet)), (OnHprofRecordTagListener)localObject1);
    return ((HprofInMemoryIndex.Builder)localObject1).a(paramProguardMapping, paramHprofHeader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.HprofInMemoryIndex.Companion
 * JD-Core Version:    0.7.0.1
 */