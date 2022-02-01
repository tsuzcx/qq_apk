package shark;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord;", "id", "", "stackTraceSerialNumber", "", "superclassId", "classLoaderId", "signersId", "protectionDomainId", "instanceSize", "staticFields", "", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "fields", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "(JIJJJJILjava/util/List;Ljava/util/List;)V", "getClassLoaderId", "()J", "getFields", "()Ljava/util/List;", "getId", "getInstanceSize", "()I", "getProtectionDomainId", "getSignersId", "getStackTraceSerialNumber", "getStaticFields", "getSuperclassId", "FieldRecord", "StaticFieldRecord", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord
  extends HprofRecord.HeapDumpRecord.ObjectRecord
{
  private final long a;
  private final int b;
  private final long c;
  private final long d;
  private final long e;
  private final long f;
  private final int g;
  @NotNull
  private final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> h;
  @NotNull
  private final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> i;
  
  public HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt2, @NotNull List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> paramList, @NotNull List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> paramList1)
  {
    super(null);
    this.a = paramLong1;
    this.b = paramInt1;
    this.c = paramLong2;
    this.d = paramLong3;
    this.e = paramLong4;
    this.f = paramLong5;
    this.g = paramInt2;
    this.h = paramList;
    this.i = paramList1;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public final long d()
  {
    return this.d;
  }
  
  public final long e()
  {
    return this.e;
  }
  
  public final long f()
  {
    return this.f;
  }
  
  public final int g()
  {
    return this.g;
  }
  
  @NotNull
  public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord> h()
  {
    return this.h;
  }
  
  @NotNull
  public final List<HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord> i()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord
 * JD-Core Version:    0.7.0.1
 */