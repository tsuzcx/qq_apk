package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.internal.ClassFieldsReader;
import shark.internal.FieldValuesReader;
import shark.internal.HprofInMemoryIndex;
import shark.internal.IndexedObject;
import shark.internal.IndexedObject.IndexedClass;
import shark.internal.IndexedObject.IndexedInstance;
import shark.internal.IndexedObject.IndexedObjectArray;
import shark.internal.IndexedObject.IndexedPrimitiveArray;
import shark.internal.LruCache;
import shark.internal.hppc.IntObjectPair;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofHeapGraph;", "Lshark/CloseableHeapGraph;", "header", "Lshark/HprofHeader;", "reader", "Lshark/RandomAccessHprofReader;", "index", "Lshark/internal/HprofInMemoryIndex;", "(Lshark/HprofHeader;Lshark/RandomAccessHprofReader;Lshark/internal/HprofInMemoryIndex;)V", "classCount", "", "getClassCount", "()I", "classes", "Lkotlin/sequences/Sequence;", "Lshark/HeapObject$HeapClass;", "getClasses", "()Lkotlin/sequences/Sequence;", "context", "Lshark/GraphContext;", "getContext", "()Lshark/GraphContext;", "gcRoots", "", "Lshark/GcRoot;", "getGcRoots", "()Ljava/util/List;", "identifierByteSize", "getIdentifierByteSize", "instanceCount", "getInstanceCount", "instances", "Lshark/HeapObject$HeapInstance;", "getInstances", "javaLangObjectClass", "objectArrayCount", "getObjectArrayCount", "objectArrays", "Lshark/HeapObject$HeapObjectArray;", "getObjectArrays", "objectCache", "Lshark/internal/LruCache;", "", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "objectCount", "getObjectCount", "objects", "Lshark/HeapObject;", "getObjects", "primitiveArrayCount", "getPrimitiveArrayCount", "primitiveArrays", "Lshark/HeapObject$HeapPrimitiveArray;", "getPrimitiveArrays", "classDumpFields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "indexedClass", "Lshark/internal/IndexedObject$IndexedClass;", "classDumpFields$shark_graph", "classDumpHasReferenceFields", "", "classDumpHasReferenceFields$shark_graph", "classDumpStaticFields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "classDumpStaticFields$shark_graph", "className", "", "classId", "className$shark_graph", "close", "", "createFieldValuesReader", "Lshark/internal/FieldValuesReader;", "record", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "createFieldValuesReader$shark_graph", "fieldName", "fieldRecord", "fieldName$shark_graph", "findClassByName", "findObjectById", "objectId", "findObjectByIdOrNull", "findObjectByIndex", "objectIndex", "lruCacheStats", "objectExists", "readClassDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "indexedObject", "readClassDumpRecord$shark_graph", "readInstanceDumpRecord", "Lshark/internal/IndexedObject$IndexedInstance;", "readInstanceDumpRecord$shark_graph", "readObjectArrayByteSize", "Lshark/internal/IndexedObject$IndexedObjectArray;", "readObjectArrayByteSize$shark_graph", "readObjectArrayDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readObjectArrayDumpRecord$shark_graph", "readObjectRecord", "T", "Lshark/internal/IndexedObject;", "readBlock", "Lkotlin/Function1;", "Lshark/HprofRecordReader;", "Lkotlin/ExtensionFunctionType;", "(JLshark/internal/IndexedObject;Lkotlin/jvm/functions/Function1;)Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "readPrimitiveArrayByteSize", "Lshark/internal/IndexedObject$IndexedPrimitiveArray;", "readPrimitiveArrayByteSize$shark_graph", "readPrimitiveArrayDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readPrimitiveArrayDumpRecord$shark_graph", "staticFieldName", "staticFieldName$shark_graph", "wrapIndexedObject", "Companion", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HprofHeapGraph
  implements CloseableHeapGraph
{
  @NotNull
  public static final HprofHeapGraph.Companion a = new HprofHeapGraph.Companion(null);
  private static int h = 3000;
  @NotNull
  private final GraphContext b;
  private final LruCache<Long, HprofRecord.HeapDumpRecord.ObjectRecord> c;
  private final HeapObject.HeapClass d;
  private final HprofHeader e;
  private final RandomAccessHprofReader f;
  private final HprofInMemoryIndex g;
  
  public HprofHeapGraph(@NotNull HprofHeader paramHprofHeader, @NotNull RandomAccessHprofReader paramRandomAccessHprofReader, @NotNull HprofInMemoryIndex paramHprofInMemoryIndex)
  {
    this.e = paramHprofHeader;
    this.f = paramRandomAccessHprofReader;
    this.g = paramHprofInMemoryIndex;
    this.b = new GraphContext();
    this.c = new LruCache(h);
    this.d = a("java.lang.Object");
  }
  
  private final HeapObject a(int paramInt, IndexedObject paramIndexedObject, long paramLong)
  {
    if ((paramIndexedObject instanceof IndexedObject.IndexedClass)) {
      return (HeapObject)new HeapObject.HeapClass(this, (IndexedObject.IndexedClass)paramIndexedObject, paramLong, paramInt);
    }
    if ((paramIndexedObject instanceof IndexedObject.IndexedInstance)) {
      return (HeapObject)new HeapObject.HeapInstance(this, (IndexedObject.IndexedInstance)paramIndexedObject, paramLong, paramInt);
    }
    if ((paramIndexedObject instanceof IndexedObject.IndexedObjectArray)) {
      return (HeapObject)new HeapObject.HeapObjectArray(this, (IndexedObject.IndexedObjectArray)paramIndexedObject, paramLong, paramInt);
    }
    if ((paramIndexedObject instanceof IndexedObject.IndexedPrimitiveArray)) {
      return (HeapObject)new HeapObject.HeapPrimitiveArray(this, (IndexedObject.IndexedPrimitiveArray)paramIndexedObject, paramLong, paramInt);
    }
    throw new NoWhenBranchMatchedException();
  }
  
  private final <T extends HprofRecord.HeapDumpRecord.ObjectRecord> T a(long paramLong, IndexedObject paramIndexedObject, Function1<? super HprofRecordReader, ? extends T> paramFunction1)
  {
    HprofRecord.HeapDumpRecord.ObjectRecord localObjectRecord = (HprofRecord.HeapDumpRecord.ObjectRecord)this.c.a(Long.valueOf(paramLong));
    if (localObjectRecord != null) {
      return localObjectRecord;
    }
    paramIndexedObject = (HprofRecord.HeapDumpRecord.ObjectRecord)this.f.a(paramIndexedObject.a(), paramIndexedObject.b(), (Function1)new HprofHeapGraph.readObjectRecord.1(paramFunction1));
    this.c.a(Long.valueOf(paramLong), paramIndexedObject);
    return paramIndexedObject;
  }
  
  public int a()
  {
    return this.e.c();
  }
  
  @NotNull
  public final String a(long paramLong, @NotNull HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord paramFieldRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramFieldRecord, "fieldRecord");
    return this.g.a(paramLong, paramFieldRecord.a());
  }
  
  @NotNull
  public final String a(long paramLong, @NotNull HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord paramStaticFieldRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramStaticFieldRecord, "fieldRecord");
    return this.g.a(paramLong, paramStaticFieldRecord.a());
  }
  
  @NotNull
  public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> a(@NotNull IndexedObject.IndexedClass paramIndexedClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedClass, "indexedClass");
    return this.g.i().a(paramIndexedClass);
  }
  
  @Nullable
  public HeapObject.HeapClass a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    Object localObject = paramString;
    if (this.e.b() != HprofVersion.ANDROID)
    {
      int i = StringsKt.indexOf$default((CharSequence)paramString, '[', 0, false, 6, null);
      localObject = paramString;
      if (i != -1)
      {
        int j = (paramString.length() - i) / 2;
        paramString = paramString.substring(0, i);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(StringsKt.repeat((CharSequence)"[", j));
        switch (paramString.hashCode())
        {
        default: 
          break;
        case 109413500: 
          if (paramString.equals("short")) {
            paramString = Character.valueOf('S');
          }
          break;
        case 97526364: 
          if (paramString.equals("float")) {
            paramString = Character.valueOf('F');
          }
          break;
        case 3327612: 
          if (paramString.equals("long")) {
            paramString = Character.valueOf('J');
          }
          break;
        case 3052374: 
          if (paramString.equals("char")) {
            paramString = Character.valueOf('C');
          }
          break;
        case 3039496: 
          if (paramString.equals("byte")) {
            paramString = Character.valueOf('B');
          }
          break;
        case 104431: 
          if (paramString.equals("int")) {
            paramString = Character.valueOf('I');
          }
          break;
        case -1325958191: 
          if (paramString.equals("double")) {
            paramString = Character.valueOf('D');
          }
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append('L');
        localStringBuilder.append(paramString);
        localStringBuilder.append(';');
        paramString = localStringBuilder.toString();
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString = this.g.a((String)localObject);
    if (paramString == null) {
      return null;
    }
    paramString = a(paramString.longValue());
    if (paramString != null) {
      return (HeapObject.HeapClass)paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type shark.HeapObject.HeapClass");
  }
  
  @NotNull
  public HeapObject a(long paramLong)
  {
    Object localObject = b(paramLong);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Object id ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" not found in heap dump.");
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord a(long paramLong, @NotNull IndexedObject.IndexedClass paramIndexedClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedClass, "indexedObject");
    return (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord)a(paramLong, (IndexedObject)paramIndexedClass, (Function1)HprofHeapGraph.readClassDumpRecord.1.INSTANCE);
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord a(long paramLong, @NotNull IndexedObject.IndexedInstance paramIndexedInstance)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedInstance, "indexedObject");
    return (HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord)a(paramLong, (IndexedObject)paramIndexedInstance, (Function1)HprofHeapGraph.readInstanceDumpRecord.1.INSTANCE);
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord a(long paramLong, @NotNull IndexedObject.IndexedObjectArray paramIndexedObjectArray)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedObjectArray, "indexedObject");
    return (HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord)a(paramLong, (IndexedObject)paramIndexedObjectArray, (Function1)HprofHeapGraph.readObjectArrayDumpRecord.1.INSTANCE);
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord a(long paramLong, @NotNull IndexedObject.IndexedPrimitiveArray paramIndexedPrimitiveArray)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedPrimitiveArray, "indexedObject");
    return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)a(paramLong, (IndexedObject)paramIndexedPrimitiveArray, (Function1)HprofHeapGraph.readPrimitiveArrayDumpRecord.1.INSTANCE);
  }
  
  @NotNull
  public final FieldValuesReader a(@NotNull HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord paramInstanceDumpRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramInstanceDumpRecord, "record");
    return new FieldValuesReader(paramInstanceDumpRecord, a());
  }
  
  public final int b(long paramLong, @NotNull IndexedObject.IndexedObjectArray paramIndexedObjectArray)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedObjectArray, "indexedObject");
    HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord localObjectArrayDumpRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord)this.c.a(Long.valueOf(paramLong));
    int i;
    if (localObjectArrayDumpRecord != null) {
      i = localObjectArrayDumpRecord.d().length;
    }
    for (int j = a();; j = a())
    {
      return i * j;
      paramLong = paramIndexedObjectArray.a();
      long l1 = a();
      long l2 = PrimitiveType.INT.getByteSize();
      long l3 = PrimitiveType.INT.getByteSize();
      i = ((Number)this.f.a(paramLong + l1 + l2, l3, (Function1)HprofHeapGraph.readObjectArrayByteSize.thinRecordSize.1.INSTANCE)).intValue();
    }
  }
  
  public final int b(long paramLong, @NotNull IndexedObject.IndexedPrimitiveArray paramIndexedPrimitiveArray)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedPrimitiveArray, "indexedObject");
    HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord localPrimitiveArrayDumpRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)this.c.a(Long.valueOf(paramLong));
    if (localPrimitiveArrayDumpRecord != null)
    {
      int i;
      int j;
      if ((localPrimitiveArrayDumpRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump))
      {
        i = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump)localPrimitiveArrayDumpRecord).c().length;
        j = PrimitiveType.BOOLEAN.getByteSize();
      }
      for (;;)
      {
        return i * j;
        if ((localPrimitiveArrayDumpRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump))
        {
          i = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump)localPrimitiveArrayDumpRecord).c().length;
          j = PrimitiveType.CHAR.getByteSize();
        }
        else if ((localPrimitiveArrayDumpRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump))
        {
          i = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump)localPrimitiveArrayDumpRecord).c().length;
          j = PrimitiveType.FLOAT.getByteSize();
        }
        else if ((localPrimitiveArrayDumpRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump))
        {
          i = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump)localPrimitiveArrayDumpRecord).c().length;
          j = PrimitiveType.DOUBLE.getByteSize();
        }
        else if ((localPrimitiveArrayDumpRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump))
        {
          i = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump)localPrimitiveArrayDumpRecord).c().length;
          j = PrimitiveType.BYTE.getByteSize();
        }
        else if ((localPrimitiveArrayDumpRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump))
        {
          i = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump)localPrimitiveArrayDumpRecord).c().length;
          j = PrimitiveType.SHORT.getByteSize();
        }
        else if ((localPrimitiveArrayDumpRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump))
        {
          i = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump)localPrimitiveArrayDumpRecord).c().length;
          j = PrimitiveType.INT.getByteSize();
        }
        else
        {
          if (!(localPrimitiveArrayDumpRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump)) {
            break;
          }
          i = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump)localPrimitiveArrayDumpRecord).c().length;
          j = PrimitiveType.LONG.getByteSize();
        }
      }
      throw new NoWhenBranchMatchedException();
    }
    paramLong = paramIndexedPrimitiveArray.a();
    long l1 = a();
    long l2 = PrimitiveType.INT.getByteSize();
    return ((Number)this.f.a(paramLong + l1 + l2, PrimitiveType.INT.getByteSize(), (Function1)HprofHeapGraph.readPrimitiveArrayByteSize.size.1.INSTANCE)).intValue() * paramIndexedPrimitiveArray.c().getByteSize();
  }
  
  @NotNull
  public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> b(@NotNull IndexedObject.IndexedClass paramIndexedClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedClass, "indexedClass");
    return this.g.i().b(paramIndexedClass);
  }
  
  @NotNull
  public GraphContext b()
  {
    return this.b;
  }
  
  @Nullable
  public HeapObject b(long paramLong)
  {
    Object localObject = this.d;
    if ((localObject != null) && (paramLong == ((HeapObject.HeapClass)localObject).b())) {
      return (HeapObject)this.d;
    }
    localObject = this.g.b(paramLong);
    if (localObject != null) {
      return a(((IntObjectPair)localObject).a(), (IndexedObject)((IntObjectPair)localObject).b(), paramLong);
    }
    return null;
  }
  
  public int c()
  {
    return this.g.b();
  }
  
  public boolean c(long paramLong)
  {
    return this.g.c(paramLong);
  }
  
  public final boolean c(@NotNull IndexedObject.IndexedClass paramIndexedClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedClass, "indexedClass");
    return this.g.i().c(paramIndexedClass);
  }
  
  public void close()
  {
    this.f.close();
  }
  
  @NotNull
  public final String d(long paramLong)
  {
    Object localObject2 = this.g.a(paramLong);
    Object localObject1 = localObject2;
    if (this.e.b() != HprofVersion.ANDROID)
    {
      Object localObject3 = (CharSequence)localObject2;
      localObject1 = localObject2;
      if (StringsKt.startsWith$default((CharSequence)localObject3, '[', false, 2, null))
      {
        int i = StringsKt.lastIndexOf$default((CharSequence)localObject3, '[', 0, false, 6, null);
        localObject1 = (CharSequence)"[]";
        int j = i + 1;
        localObject1 = StringsKt.repeat((CharSequence)localObject1, j);
        char c1 = ((String)localObject2).charAt(j);
        if (c1 != 'F')
        {
          if (c1 != 'L')
          {
            if (c1 != 'S')
            {
              if (c1 != 'Z')
              {
                if (c1 != 'I')
                {
                  if (c1 != 'J')
                  {
                    switch (c1)
                    {
                    default: 
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("Unexpected type char ");
                      ((StringBuilder)localObject1).append(c1);
                      throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString().toString()));
                    case 'D': 
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("double");
                      ((StringBuilder)localObject2).append((String)localObject1);
                      return ((StringBuilder)localObject2).toString();
                    case 'C': 
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("char");
                      ((StringBuilder)localObject2).append((String)localObject1);
                      return ((StringBuilder)localObject2).toString();
                    }
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("byte");
                    ((StringBuilder)localObject2).append((String)localObject1);
                    return ((StringBuilder)localObject2).toString();
                  }
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("long");
                  ((StringBuilder)localObject2).append((String)localObject1);
                  return ((StringBuilder)localObject2).toString();
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("int");
                ((StringBuilder)localObject2).append((String)localObject1);
                return ((StringBuilder)localObject2).toString();
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("boolean");
              ((StringBuilder)localObject2).append((String)localObject1);
              return ((StringBuilder)localObject2).toString();
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("short");
            ((StringBuilder)localObject2).append((String)localObject1);
            return ((StringBuilder)localObject2).toString();
          }
          localObject3 = new StringBuilder();
          j = ((String)localObject2).length();
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).substring(i + 2, j - 1);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append((String)localObject1);
            return ((StringBuilder)localObject3).toString();
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("float");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    return localObject1;
  }
  
  @NotNull
  public List<GcRoot> d()
  {
    return this.g.h();
  }
  
  @NotNull
  public Sequence<HeapObject> e()
  {
    Ref.IntRef localIntRef = new Ref.IntRef();
    localIntRef.element = 0;
    return SequencesKt.map(this.g.g(), (Function1)new HprofHeapGraph.objects.1(this, localIntRef));
  }
  
  @NotNull
  public Sequence<HeapObject.HeapInstance> f()
  {
    Ref.IntRef localIntRef = new Ref.IntRef();
    localIntRef.element = g();
    return SequencesKt.map(this.g.d(), (Function1)new HprofHeapGraph.instances.1(this, localIntRef));
  }
  
  public int g()
  {
    return this.g.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofHeapGraph
 * JD-Core Version:    0.7.0.1
 */