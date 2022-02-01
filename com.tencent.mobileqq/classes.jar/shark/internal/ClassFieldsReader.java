package shark.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import shark.HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord;
import shark.HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord;
import shark.PrimitiveType;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ClassFieldsReader;", "", "identifierByteSize", "", "classFieldBytes", "", "(I[B)V", "readInFlightThreadLocal", "shark/internal/ClassFieldsReader$readInFlightThreadLocal$1", "Lshark/internal/ClassFieldsReader$readInFlightThreadLocal$1;", "classDumpFields", "", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "indexedClass", "Lshark/internal/IndexedObject$IndexedClass;", "classDumpHasReferenceFields", "", "classDumpStaticFields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "read", "R", "initialPosition", "block", "Lkotlin/Function1;", "Lshark/internal/ClassFieldsReader$ReadInFlight;", "Lkotlin/ExtensionFunctionType;", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "ReadInFlight", "shark-graph"}, k=1, mv={1, 4, 1})
public final class ClassFieldsReader
{
  @NotNull
  public static final ClassFieldsReader.Companion a = new ClassFieldsReader.Companion(null);
  private static final int e = PrimitiveType.BOOLEAN.getHprofType();
  private static final int f = PrimitiveType.CHAR.getHprofType();
  private static final int g = PrimitiveType.FLOAT.getHprofType();
  private static final int h = PrimitiveType.DOUBLE.getHprofType();
  private static final int i = PrimitiveType.BYTE.getHprofType();
  private static final int j = PrimitiveType.SHORT.getHprofType();
  private static final int k = PrimitiveType.INT.getHprofType();
  private static final int l = PrimitiveType.LONG.getHprofType();
  private final ClassFieldsReader.readInFlightThreadLocal.1 b;
  private final int c;
  private final byte[] d;
  
  public ClassFieldsReader(int paramInt, @NotNull byte[] paramArrayOfByte)
  {
    this.c = paramInt;
    this.d = paramArrayOfByte;
    this.b = new ClassFieldsReader.readInFlightThreadLocal.1(this);
  }
  
  private final <R> R a(int paramInt, Function1<? super ClassFieldsReader.ReadInFlight, ? extends R> paramFunction1)
  {
    ClassFieldsReader.ReadInFlight localReadInFlight = (ClassFieldsReader.ReadInFlight)this.b.get();
    localReadInFlight.a(paramInt);
    return paramFunction1.invoke(localReadInFlight);
  }
  
  @NotNull
  public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> a(@NotNull IndexedObject.IndexedClass paramIndexedClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedClass, "indexedClass");
    return (List)a(paramIndexedClass.e(), (Function1)ClassFieldsReader.classDumpStaticFields.1.INSTANCE);
  }
  
  @NotNull
  public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> b(@NotNull IndexedObject.IndexedClass paramIndexedClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedClass, "indexedClass");
    return (List)a(paramIndexedClass.e(), (Function1)ClassFieldsReader.classDumpFields.1.INSTANCE);
  }
  
  public final boolean c(@NotNull IndexedObject.IndexedClass paramIndexedClass)
  {
    Intrinsics.checkParameterIsNotNull(paramIndexedClass, "indexedClass");
    return ((Boolean)a(paramIndexedClass.e(), (Function1)new ClassFieldsReader.classDumpHasReferenceFields.1(this))).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ClassFieldsReader
 * JD-Core Version:    0.7.0.1
 */