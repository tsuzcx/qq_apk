package shark;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.internal.IndexedObject.IndexedClass;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapObject$HeapClass;", "Lshark/HeapObject;", "hprofGraph", "Lshark/HprofHeapGraph;", "indexedObject", "Lshark/internal/IndexedObject$IndexedClass;", "objectId", "", "objectIndex", "", "(Lshark/HprofHeapGraph;Lshark/internal/IndexedObject$IndexedClass;JI)V", "classHierarchy", "Lkotlin/sequences/Sequence;", "getClassHierarchy", "()Lkotlin/sequences/Sequence;", "directInstances", "Lshark/HeapObject$HeapInstance;", "getDirectInstances", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "hasReferenceInstanceFields", "", "getHasReferenceInstanceFields", "()Z", "instanceByteSize", "getInstanceByteSize", "()I", "instances", "getInstances", "isArrayClass", "isObjectArrayClass", "isPrimitiveArrayClass", "isPrimitiveWrapperClass", "name", "", "getName", "()Ljava/lang/String;", "objectArrayInstances", "Lshark/HeapObject$HeapObjectArray;", "getObjectArrayInstances", "getObjectId", "()J", "getObjectIndex", "primitiveArrayInstances", "Lshark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrayInstances", "recordSize", "getRecordSize", "simpleName", "getSimpleName", "subclasses", "getSubclasses", "superclass", "getSuperclass", "()Lshark/HeapObject$HeapClass;", "get", "Lshark/HeapField;", "fieldName", "instanceFieldName", "fieldRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "readFieldsByteSize", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readRecordFields", "", "readRecordStaticFields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "readStaticField", "readStaticFields", "subclassOf", "superclassOf", "subclass", "toString", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HeapObject$HeapClass
  extends HeapObject
{
  private final HprofHeapGraph b;
  private final IndexedObject.IndexedClass c;
  private final long d;
  private final int e;
  
  public HeapObject$HeapClass(@NotNull HprofHeapGraph paramHprofHeapGraph, @NotNull IndexedObject.IndexedClass paramIndexedClass, long paramLong, int paramInt)
  {
    super(null);
    this.b = paramHprofHeapGraph;
    this.c = paramIndexedClass;
    this.d = paramLong;
    this.e = paramInt;
  }
  
  @NotNull
  public final String a(@NotNull HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord paramFieldRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramFieldRecord, "fieldRecord");
    return this.b.a(b(), paramFieldRecord);
  }
  
  @Nullable
  public final HeapField a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "fieldName");
    Iterator localIterator = r().iterator();
    while (localIterator.hasNext())
    {
      HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord localStaticFieldRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord)localIterator.next();
      if (Intrinsics.areEqual(this.b.a(b(), localStaticFieldRecord), paramString)) {
        return new HeapField(this, paramString, new HeapValue((HeapGraph)this.b, localStaticFieldRecord.c()));
      }
    }
    return null;
  }
  
  @NotNull
  public HeapGraph a()
  {
    return (HeapGraph)this.b;
  }
  
  public final boolean a(@NotNull HeapClass paramHeapClass)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapClass, "superclass");
    if (paramHeapClass.b() != b())
    {
      Iterator localIterator = n().iterator();
      while (localIterator.hasNext())
      {
        if (((HeapClass)localIterator.next()).b() == paramHeapClass.b()) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          i = 1;
          break label75;
        }
      }
      int i = 0;
      label75:
      if (i != 0) {
        return true;
      }
    }
    return false;
  }
  
  public long b()
  {
    return this.d;
  }
  
  @Nullable
  public final HeapField b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "fieldName");
    return a(paramString);
  }
  
  public int d()
  {
    return (int)this.c.b();
  }
  
  @NotNull
  public final String h()
  {
    return this.b.d(b());
  }
  
  public final int i()
  {
    return this.c.d();
  }
  
  public final boolean j()
  {
    return this.b.c(this.c);
  }
  
  public final boolean k()
  {
    return StringsKt.endsWith$default(h(), "[]", false, 2, null);
  }
  
  public final int l()
  {
    Iterator localIterator = ((Iterable)s()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord localFieldRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord)localIterator.next();
      int j;
      if (localFieldRecord.b() == 2) {
        j = this.b.a();
      } else {
        j = ((Number)MapsKt.getValue(PrimitiveType.Companion.a(), Integer.valueOf(localFieldRecord.b()))).intValue();
      }
      i += j;
    }
    return i;
  }
  
  @Nullable
  public final HeapClass m()
  {
    if (this.c.c() == 0L) {
      return null;
    }
    HeapObject localHeapObject = this.b.a(this.c.c());
    if (localHeapObject != null) {
      return (HeapClass)localHeapObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type shark.HeapObject.HeapClass");
  }
  
  @NotNull
  public final Sequence<HeapClass> n()
  {
    return SequencesKt.generateSequence(this, (Function1)HeapObject.HeapClass.classHierarchy.1.INSTANCE);
  }
  
  @NotNull
  public final Sequence<HeapObject.HeapInstance> o()
  {
    if (!k()) {
      return SequencesKt.filter(this.b.f(), (Function1)new HeapObject.HeapClass.instances.1(this));
    }
    return SequencesKt.emptySequence();
  }
  
  @NotNull
  public final Sequence<HeapObject.HeapInstance> p()
  {
    return SequencesKt.filter(this.b.f(), (Function1)new HeapObject.HeapClass.directInstances.1(this));
  }
  
  @NotNull
  public HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord q()
  {
    return this.b.a(b(), this.c);
  }
  
  @NotNull
  public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> r()
  {
    return this.b.a(this.c);
  }
  
  @NotNull
  public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> s()
  {
    return this.b.b(this.c);
  }
  
  @NotNull
  public final Sequence<HeapField> t()
  {
    return SequencesKt.map(CollectionsKt.asSequence((Iterable)r()), (Function1)new HeapObject.HeapClass.readStaticFields.1(this));
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ");
    localStringBuilder.append(h());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapClass
 * JD-Core Version:    0.7.0.1
 */