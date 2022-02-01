package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord;", "", "nameStringId", "", "type", "", "value", "Lshark/ValueHolder;", "(JILshark/ValueHolder;)V", "getNameStringId", "()J", "getType", "()I", "getValue", "()Lshark/ValueHolder;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord
{
  private final long a;
  private final int b;
  @NotNull
  private final ValueHolder c;
  
  public HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$StaticFieldRecord(long paramLong, int paramInt, @NotNull ValueHolder paramValueHolder)
  {
    this.a = paramLong;
    this.b = paramInt;
    this.c = paramValueHolder;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  @NotNull
  public final ValueHolder c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof StaticFieldRecord))
      {
        paramObject = (StaticFieldRecord)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int j = (int)(l ^ l >>> 32);
    int k = this.b;
    ValueHolder localValueHolder = this.c;
    int i;
    if (localValueHolder != null) {
      i = localValueHolder.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StaticFieldRecord(nameStringId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord
 * JD-Core Version:    0.7.0.1
 */