package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import shark.HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord;
import shark.HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord;
import shark.PrimitiveType;
import shark.ValueHolder;
import shark.ValueHolder.BooleanHolder;
import shark.ValueHolder.ByteHolder;
import shark.ValueHolder.CharHolder;
import shark.ValueHolder.DoubleHolder;
import shark.ValueHolder.FloatHolder;
import shark.ValueHolder.IntHolder;
import shark.ValueHolder.LongHolder;
import shark.ValueHolder.ReferenceHolder;
import shark.ValueHolder.ShortHolder;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/FieldValuesReader;", "", "record", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "identifierByteSize", "", "(Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;I)V", "position", "readBoolean", "", "readByte", "", "readChar", "", "readDouble", "", "readFloat", "", "readId", "", "readInt", "readLong", "readShort", "", "readValue", "Lshark/ValueHolder;", "field", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord$FieldRecord;", "Companion", "shark-graph"}, k=1, mv={1, 4, 1})
public final class FieldValuesReader
{
  @NotNull
  public static final FieldValuesReader.Companion a = new FieldValuesReader.Companion(null);
  private static final int e = PrimitiveType.BOOLEAN.getHprofType();
  private static final int f = PrimitiveType.CHAR.getHprofType();
  private static final int g = PrimitiveType.FLOAT.getHprofType();
  private static final int h = PrimitiveType.DOUBLE.getHprofType();
  private static final int i = PrimitiveType.BYTE.getHprofType();
  private static final int j = PrimitiveType.SHORT.getHprofType();
  private static final int k = PrimitiveType.INT.getHprofType();
  private static final int l = PrimitiveType.LONG.getHprofType();
  private int b;
  private final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord c;
  private final int d;
  
  public FieldValuesReader(@NotNull HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord paramInstanceDumpRecord, int paramInt)
  {
    this.c = paramInstanceDumpRecord;
    this.d = paramInt;
  }
  
  private final long a()
  {
    int m = this.d;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 4)
        {
          if (m == 8) {
            return f();
          }
          throw ((Throwable)new IllegalArgumentException("ID Length must be 1, 2, 4, or 8"));
        }
        m = d();
      }
      else
      {
        m = e();
      }
    }
    else {
      m = c();
    }
    return m;
  }
  
  private final boolean b()
  {
    byte[] arrayOfByte = this.c.d();
    int m = this.b;
    int n = arrayOfByte[m];
    this.b = (m + 1);
    boolean bool = false;
    if (n != (byte)0) {
      bool = true;
    }
    return bool;
  }
  
  private final byte c()
  {
    byte[] arrayOfByte = this.c.d();
    int m = this.b;
    byte b1 = arrayOfByte[m];
    this.b = (m + 1);
    return b1;
  }
  
  private final int d()
  {
    int m = ByteSubArrayKt.b(this.c.d(), this.b);
    this.b += 4;
    return m;
  }
  
  private final short e()
  {
    short s = ByteSubArrayKt.a(this.c.d(), this.b);
    this.b += 2;
    return s;
  }
  
  private final long f()
  {
    long l1 = ByteSubArrayKt.c(this.c.d(), this.b);
    this.b += 8;
    return l1;
  }
  
  private final float g()
  {
    FloatCompanionObject localFloatCompanionObject = FloatCompanionObject.INSTANCE;
    return Float.intBitsToFloat(d());
  }
  
  private final double h()
  {
    DoubleCompanionObject localDoubleCompanionObject = DoubleCompanionObject.INSTANCE;
    return Double.longBitsToDouble(f());
  }
  
  private final char i()
  {
    String str = new String(this.c.d(), this.b, 2, Charsets.UTF_16BE);
    this.b += 2;
    return str.charAt(0);
  }
  
  @NotNull
  public final ValueHolder a(@NotNull HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord paramFieldRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramFieldRecord, "field");
    int m = paramFieldRecord.b();
    if (m == 2) {
      return (ValueHolder)new ValueHolder.ReferenceHolder(a());
    }
    if (m == e) {
      return (ValueHolder)new ValueHolder.BooleanHolder(b());
    }
    if (m == f) {
      return (ValueHolder)new ValueHolder.CharHolder(i());
    }
    if (m == g) {
      return (ValueHolder)new ValueHolder.FloatHolder(g());
    }
    if (m == h) {
      return (ValueHolder)new ValueHolder.DoubleHolder(h());
    }
    if (m == i) {
      return (ValueHolder)new ValueHolder.ByteHolder(c());
    }
    if (m == j) {
      return (ValueHolder)new ValueHolder.ShortHolder(e());
    }
    if (m == k) {
      return (ValueHolder)new ValueHolder.IntHolder(d());
    }
    if (m == l) {
      return (ValueHolder)new ValueHolder.LongHolder(f());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown type ");
    localStringBuilder.append(paramFieldRecord.b());
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.FieldValuesReader
 * JD-Core Version:    0.7.0.1
 */