package shark;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.internal.IndexedObject.IndexedInstance;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapObject$HeapInstance;", "Lshark/HeapObject;", "hprofGraph", "Lshark/HprofHeapGraph;", "indexedObject", "Lshark/internal/IndexedObject$IndexedInstance;", "objectId", "", "objectIndex", "", "(Lshark/HprofHeapGraph;Lshark/internal/IndexedObject$IndexedInstance;JI)V", "byteSize", "getByteSize", "()I", "graph", "Lshark/HeapGraph;", "getGraph", "()Lshark/HeapGraph;", "getIndexedObject$shark_graph", "()Lshark/internal/IndexedObject$IndexedInstance;", "instanceClass", "Lshark/HeapObject$HeapClass;", "getInstanceClass", "()Lshark/HeapObject$HeapClass;", "instanceClassId", "getInstanceClassId", "()J", "instanceClassName", "", "getInstanceClassName", "()Ljava/lang/String;", "instanceClassSimpleName", "getInstanceClassSimpleName", "isPrimitiveWrapper", "", "()Z", "getObjectId", "getObjectIndex", "recordSize", "getRecordSize", "get", "Lshark/HeapField;", "declaringClassName", "fieldName", "declaringClass", "Lkotlin/reflect/KClass;", "", "instanceOf", "className", "expectedClass", "readAsJavaString", "readField", "readFields", "Lkotlin/sequences/Sequence;", "readRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "toString", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HeapObject$HeapInstance
  extends HeapObject
{
  private final HprofHeapGraph b;
  @NotNull
  private final IndexedObject.IndexedInstance c;
  private final long d;
  private final int e;
  
  public HeapObject$HeapInstance(@NotNull HprofHeapGraph paramHprofHeapGraph, @NotNull IndexedObject.IndexedInstance paramIndexedInstance, long paramLong, int paramInt)
  {
    super(null);
    this.b = paramHprofHeapGraph;
    this.c = paramIndexedInstance;
    this.d = paramLong;
    this.e = paramInt;
  }
  
  @Nullable
  public final HeapField a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "declaringClassName");
    Intrinsics.checkParameterIsNotNull(paramString2, "fieldName");
    Iterator localIterator = n().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      HeapField localHeapField = (HeapField)localObject;
      int i;
      if ((Intrinsics.areEqual(localHeapField.a().h(), paramString1)) && (Intrinsics.areEqual(localHeapField.b(), paramString2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramString1 = localObject;
        break label95;
      }
    }
    paramString1 = null;
    label95:
    return (HeapField)paramString1;
  }
  
  @Nullable
  public final HeapField a(@NotNull KClass<? extends Object> paramKClass, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "declaringClass");
    Intrinsics.checkParameterIsNotNull(paramString, "fieldName");
    paramKClass = JvmClassMappingKt.getJavaClass(paramKClass).getName();
    Intrinsics.checkExpressionValueIsNotNull(paramKClass, "declaringClass.java.name");
    return a(paramKClass, paramString);
  }
  
  @NotNull
  public HeapGraph a()
  {
    return (HeapGraph)this.b;
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    Iterator localIterator = k().n().iterator();
    while (localIterator.hasNext()) {
      if (Intrinsics.areEqual(((HeapObject.HeapClass)localIterator.next()).h(), paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(@NotNull HeapObject.HeapClass paramHeapClass)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapClass, "expectedClass");
    Iterator localIterator = k().n().iterator();
    int i;
    do
    {
      boolean bool = localIterator.hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      if (((HeapObject.HeapClass)localIterator.next()).b() == paramHeapClass.b()) {
        i = 1;
      }
    } while (i == 0);
    return true;
    return false;
  }
  
  public long b()
  {
    return this.d;
  }
  
  @Nullable
  public final HeapField b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "declaringClassName");
    Intrinsics.checkParameterIsNotNull(paramString2, "fieldName");
    return a(paramString1, paramString2);
  }
  
  @Nullable
  public final HeapField b(@NotNull KClass<? extends Object> paramKClass, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "declaringClass");
    Intrinsics.checkParameterIsNotNull(paramString, "fieldName");
    return a(paramKClass, paramString);
  }
  
  public int d()
  {
    return (int)this.c.b();
  }
  
  public final boolean h()
  {
    return HeapObject.g().contains(j());
  }
  
  public final int i()
  {
    return k().i();
  }
  
  @NotNull
  public final String j()
  {
    return this.b.d(this.c.c());
  }
  
  @NotNull
  public final HeapObject.HeapClass k()
  {
    HeapObject localHeapObject = this.b.a(this.c.c());
    if (localHeapObject != null) {
      return (HeapObject.HeapClass)localHeapObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type shark.HeapObject.HeapClass");
  }
  
  public final long l()
  {
    return this.c.c();
  }
  
  @NotNull
  public HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord m()
  {
    return this.b.a(b(), this.c);
  }
  
  @NotNull
  public final Sequence<HeapField> n()
  {
    Lazy localLazy = LazyKt.lazy((Function0)new HeapObject.HeapInstance.readFields.fieldReader.2(this));
    return SequencesKt.flatten(SequencesKt.map(k().n(), (Function1)new HeapObject.HeapInstance.readFields.1(this, localLazy, null)));
  }
  
  @Nullable
  public final String o()
  {
    boolean bool = Intrinsics.areEqual(j(), "java.lang.String");
    HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump localCharArrayDump = null;
    if ((bool ^ true)) {
      return null;
    }
    Object localObject1 = b("java.lang.String", "count");
    if (localObject1 != null)
    {
      localObject1 = ((HeapField)localObject1).c();
      if (localObject1 != null)
      {
        localObject1 = ((HeapValue)localObject1).a();
        break label64;
      }
    }
    localObject1 = null;
    label64:
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == 0)) {
      return "";
    }
    Object localObject2 = b("java.lang.String", "value");
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((HeapField)localObject2).c().e();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    HprofRecord.HeapDumpRecord.ObjectRecord localObjectRecord = ((HeapObject)localObject2).c();
    if ((localObjectRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump))
    {
      Object localObject3 = b("java.lang.String", "offset");
      localObject2 = localCharArrayDump;
      if (localObject3 != null)
      {
        localObject3 = ((HeapField)localObject3).c();
        localObject2 = localCharArrayDump;
        if (localObject3 != null) {
          localObject2 = ((HeapValue)localObject3).a();
        }
      }
      if ((localObject1 != null) && (localObject2 != null))
      {
        int i = ((Integer)localObject2).intValue();
        int j = ((Integer)localObject1).intValue();
        localCharArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump)localObjectRecord;
        if (i + j > localCharArrayDump.c().length)
        {
          i = localCharArrayDump.c().length;
        }
        else
        {
          i = ((Integer)localObject2).intValue();
          i = ((Integer)localObject1).intValue() + i;
        }
        localObject1 = ArraysKt.copyOfRange(localCharArrayDump.c(), ((Integer)localObject2).intValue(), i);
      }
      else
      {
        localObject1 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump)localObjectRecord).c();
      }
      return new String((char[])localObject1);
    }
    if ((localObjectRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump))
    {
      localObject1 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump)localObjectRecord).c();
      localObject2 = Charset.forName("UTF-8");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "Charset.forName(\"UTF-8\")");
      return new String((byte[])localObject1, (Charset)localObject2);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("'value' field ");
    localObject2 = b("java.lang.String", "value");
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((StringBuilder)localObject1).append(((HeapField)localObject2).c());
    ((StringBuilder)localObject1).append(" was expected to be either");
    ((StringBuilder)localObject1).append(" a char or byte array in string instance with id ");
    ((StringBuilder)localObject1).append(b());
    throw ((Throwable)new UnsupportedOperationException(((StringBuilder)localObject1).toString()));
  }
  
  @NotNull
  public final IndexedObject.IndexedInstance p()
  {
    return this.c;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("instance @");
    localStringBuilder.append(b());
    localStringBuilder.append(" of ");
    localStringBuilder.append(j());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapObject.HeapInstance
 * JD-Core Version:    0.7.0.1
 */