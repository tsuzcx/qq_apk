package shark.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.GcRoot;
import shark.ProguardMapping;
import shark.internal.hppc.IntObjectPair;
import shark.internal.hppc.LongLongPair;
import shark.internal.hppc.LongLongScatterMap;
import shark.internal.hppc.LongObjectPair;
import shark.internal.hppc.LongObjectScatterMap;
import shark.internal.hppc.TuplesKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/HprofInMemoryIndex;", "", "positionSize", "", "hprofStringCache", "Lshark/internal/hppc/LongObjectScatterMap;", "", "classNames", "Lshark/internal/hppc/LongLongScatterMap;", "classIndex", "Lshark/internal/SortedBytesMap;", "instanceIndex", "objectArrayIndex", "primitiveArrayIndex", "gcRoots", "", "Lshark/GcRoot;", "proguardMapping", "Lshark/ProguardMapping;", "bytesForClassSize", "bytesForInstanceSize", "bytesForObjectArraySize", "bytesForPrimitiveArraySize", "useForwardSlashClassPackageSeparator", "", "classFieldsReader", "Lshark/internal/ClassFieldsReader;", "classFieldsIndexSize", "(ILshark/internal/hppc/LongObjectScatterMap;Lshark/internal/hppc/LongLongScatterMap;Lshark/internal/SortedBytesMap;Lshark/internal/SortedBytesMap;Lshark/internal/SortedBytesMap;Lshark/internal/SortedBytesMap;Ljava/util/List;Lshark/ProguardMapping;IIIIZLshark/internal/ClassFieldsReader;I)V", "classCount", "getClassCount", "()I", "getClassFieldsReader", "()Lshark/internal/ClassFieldsReader;", "instanceCount", "getInstanceCount", "objectArrayCount", "getObjectArrayCount", "primitiveArrayCount", "getPrimitiveArrayCount", "classId", "", "className", "(Ljava/lang/String;)Ljava/lang/Long;", "fieldName", "id", "hprofStringById", "indexedClassSequence", "Lkotlin/sequences/Sequence;", "Lshark/internal/hppc/LongObjectPair;", "Lshark/internal/IndexedObject$IndexedClass;", "indexedInstanceSequence", "Lshark/internal/IndexedObject$IndexedInstance;", "indexedObjectArraySequence", "Lshark/internal/IndexedObject$IndexedObjectArray;", "indexedObjectOrNull", "Lshark/internal/hppc/IntObjectPair;", "Lshark/internal/IndexedObject;", "objectId", "indexedObjectSequence", "indexedPrimitiveArraySequence", "Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "objectAtIndex", "index", "objectIdIsIndexed", "readClass", "Lshark/internal/ByteSubArray;", "Builder", "Companion", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HprofInMemoryIndex
{
  @NotNull
  public static final HprofInMemoryIndex.Companion a = new HprofInMemoryIndex.Companion(null);
  private final int b;
  private final LongObjectScatterMap<String> c;
  private final LongLongScatterMap d;
  private final SortedBytesMap e;
  private final SortedBytesMap f;
  private final SortedBytesMap g;
  private final SortedBytesMap h;
  private final List<GcRoot> i;
  private final ProguardMapping j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final boolean o;
  @NotNull
  private final ClassFieldsReader p;
  private final int q;
  
  private HprofInMemoryIndex(int paramInt1, LongObjectScatterMap<String> paramLongObjectScatterMap, LongLongScatterMap paramLongLongScatterMap, SortedBytesMap paramSortedBytesMap1, SortedBytesMap paramSortedBytesMap2, SortedBytesMap paramSortedBytesMap3, SortedBytesMap paramSortedBytesMap4, List<? extends GcRoot> paramList, ProguardMapping paramProguardMapping, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, ClassFieldsReader paramClassFieldsReader, int paramInt6)
  {
    this.b = paramInt1;
    this.c = paramLongObjectScatterMap;
    this.d = paramLongLongScatterMap;
    this.e = paramSortedBytesMap1;
    this.f = paramSortedBytesMap2;
    this.g = paramSortedBytesMap3;
    this.h = paramSortedBytesMap4;
    this.i = paramList;
    this.j = paramProguardMapping;
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
    this.n = paramInt5;
    this.o = paramBoolean;
    this.p = paramClassFieldsReader;
    this.q = paramInt6;
  }
  
  private final IndexedObject.IndexedClass a(ByteSubArray paramByteSubArray)
  {
    return new IndexedObject.IndexedClass(paramByteSubArray.a(this.b), paramByteSubArray.b(), paramByteSubArray.c(), paramByteSubArray.a(this.k), (int)paramByteSubArray.a(this.q));
  }
  
  private final String d(long paramLong)
  {
    Object localObject = (String)this.c.a(paramLong);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Hprof string ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" not in cache");
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
  }
  
  public final int a()
  {
    return this.e.a();
  }
  
  @Nullable
  public final Long a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    Object localObject1 = paramString;
    if (this.o) {
      localObject1 = StringsKt.replace$default(paramString, '.', '/', false, 4, null);
    }
    Iterator localIterator = this.c.b().iterator();
    Object localObject2;
    do
    {
      boolean bool = localIterator.hasNext();
      localObject2 = null;
      if (!bool) {
        break;
      }
      paramString = localIterator.next();
    } while (!Intrinsics.areEqual((String)((LongObjectPair)paramString).b(), localObject1));
    break label89;
    paramString = null;
    label89:
    paramString = (LongObjectPair)paramString;
    if (paramString != null) {
      localObject1 = Long.valueOf(paramString.a());
    } else {
      localObject1 = null;
    }
    paramString = localObject2;
    if (localObject1 != null)
    {
      long l1 = ((Number)localObject1).longValue();
      localObject1 = this.d.b().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramString = ((Iterator)localObject1).next();
        int i1;
        if (((LongLongPair)paramString).b() == l1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 != 0) {
          break label192;
        }
      }
      paramString = null;
      label192:
      localObject1 = (LongLongPair)paramString;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = Long.valueOf(((LongLongPair)localObject1).a());
      }
    }
    return paramString;
  }
  
  @NotNull
  public final String a(long paramLong)
  {
    Object localObject1 = d(this.d.b(paramLong));
    Object localObject2 = this.j;
    if (localObject2 != null)
    {
      localObject2 = ((ProguardMapping)localObject2).a((String)localObject1);
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (this.o) {
      localObject2 = StringsKt.replace$default((String)localObject1, '/', '.', false, 4, null);
    }
    return localObject2;
  }
  
  @NotNull
  public final String a(long paramLong1, long paramLong2)
  {
    String str1 = d(paramLong2);
    if (this.j != null)
    {
      String str2 = d(this.d.b(paramLong1));
      str2 = this.j.a(str2, str1);
      if (str2 != null) {
        return str2;
      }
    }
    return str1;
  }
  
  public final int b()
  {
    return this.f.a();
  }
  
  @Nullable
  public final IntObjectPair<IndexedObject> b(long paramLong)
  {
    int i1 = this.e.b(paramLong);
    if (i1 >= 0) {
      return TuplesKt.a(i1, a(this.e.a(i1)));
    }
    i1 = this.f.b(paramLong);
    ByteSubArray localByteSubArray;
    if (i1 >= 0)
    {
      localByteSubArray = this.f.a(i1);
      return TuplesKt.a(this.e.a() + i1, new IndexedObject.IndexedInstance(localByteSubArray.a(this.b), localByteSubArray.b(), localByteSubArray.a(this.l)));
    }
    i1 = this.g.b(paramLong);
    if (i1 >= 0)
    {
      localByteSubArray = this.g.a(i1);
      return TuplesKt.a(this.e.a() + this.f.a() + i1, new IndexedObject.IndexedObjectArray(localByteSubArray.a(this.b), localByteSubArray.b(), localByteSubArray.a(this.m)));
    }
    i1 = this.h.b(paramLong);
    if (i1 >= 0)
    {
      localByteSubArray = this.h.a(i1);
      return TuplesKt.a(this.e.a() + this.f.a() + i1 + this.h.a(), new IndexedObject.IndexedPrimitiveArray(localByteSubArray.a(this.b), shark.PrimitiveType.values()[localByteSubArray.a()], localByteSubArray.a(this.n)));
    }
    return null;
  }
  
  @NotNull
  public final Sequence<LongObjectPair<IndexedObject.IndexedClass>> c()
  {
    return SequencesKt.map(this.e.b(), (Function1)new HprofInMemoryIndex.indexedClassSequence.1(this));
  }
  
  public final boolean c(long paramLong)
  {
    if (this.e.a(paramLong) != null) {
      return true;
    }
    if (this.f.a(paramLong) != null) {
      return true;
    }
    if (this.g.a(paramLong) != null) {
      return true;
    }
    return this.h.a(paramLong) != null;
  }
  
  @NotNull
  public final Sequence<LongObjectPair<IndexedObject.IndexedInstance>> d()
  {
    return SequencesKt.map(this.f.b(), (Function1)new HprofInMemoryIndex.indexedInstanceSequence.1(this));
  }
  
  @NotNull
  public final Sequence<LongObjectPair<IndexedObject.IndexedObjectArray>> e()
  {
    return SequencesKt.map(this.g.b(), (Function1)new HprofInMemoryIndex.indexedObjectArraySequence.1(this));
  }
  
  @NotNull
  public final Sequence<LongObjectPair<IndexedObject.IndexedPrimitiveArray>> f()
  {
    return SequencesKt.map(this.h.b(), (Function1)new HprofInMemoryIndex.indexedPrimitiveArraySequence.1(this));
  }
  
  @NotNull
  public final Sequence<LongObjectPair<IndexedObject>> g()
  {
    return SequencesKt.plus(SequencesKt.plus(SequencesKt.plus(c(), d()), e()), f());
  }
  
  @NotNull
  public final List<GcRoot> h()
  {
    return this.i;
  }
  
  @NotNull
  public final ClassFieldsReader i()
  {
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.HprofInMemoryIndex
 * JD-Core Version:    0.7.0.1
 */