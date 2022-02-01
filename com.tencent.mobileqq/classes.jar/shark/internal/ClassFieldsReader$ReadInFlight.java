package shark.internal;

import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;
import shark.PrimitiveType;
import shark.PrimitiveType.Companion;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ClassFieldsReader$ReadInFlight;", "", "(Lshark/internal/ClassFieldsReader;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "readBoolean", "", "readByte", "", "readChar", "", "readDouble", "", "readFloat", "", "readId", "", "readInt", "readLong", "readShort", "", "readUnsignedByte", "readUnsignedShort", "readValue", "Lshark/ValueHolder;", "type", "skipStaticFields", "", "shark-graph"}, k=1, mv={1, 4, 1})
final class ClassFieldsReader$ReadInFlight
{
  private int b;
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  @NotNull
  public final ValueHolder b(int paramInt)
  {
    if (paramInt == 2) {
      return (ValueHolder)new ValueHolder.ReferenceHolder(i());
    }
    if (paramInt == ClassFieldsReader.a()) {
      return (ValueHolder)new ValueHolder.BooleanHolder(j());
    }
    if (paramInt == ClassFieldsReader.b()) {
      return (ValueHolder)new ValueHolder.CharHolder(k());
    }
    if (paramInt == ClassFieldsReader.c()) {
      return (ValueHolder)new ValueHolder.FloatHolder(l());
    }
    if (paramInt == ClassFieldsReader.d()) {
      return (ValueHolder)new ValueHolder.DoubleHolder(m());
    }
    if (paramInt == ClassFieldsReader.e()) {
      return (ValueHolder)new ValueHolder.ByteHolder(c());
    }
    if (paramInt == ClassFieldsReader.f()) {
      return (ValueHolder)new ValueHolder.ShortHolder(f());
    }
    if (paramInt == ClassFieldsReader.g()) {
      return (ValueHolder)new ValueHolder.IntHolder(d());
    }
    if (paramInt == ClassFieldsReader.h()) {
      return (ValueHolder)new ValueHolder.LongHolder(e());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown type ");
    localStringBuilder.append(paramInt);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
  
  public final void b()
  {
    int k = g();
    int i = 0;
    while (i < k)
    {
      this.b += ClassFieldsReader.a(this.a);
      int j = h();
      int m = this.b;
      if (j == 2) {
        j = ClassFieldsReader.a(this.a);
      } else {
        j = ((Number)MapsKt.getValue(PrimitiveType.Companion.a(), Integer.valueOf(j))).intValue();
      }
      this.b = (m + j);
      i += 1;
    }
  }
  
  public final byte c()
  {
    byte[] arrayOfByte = ClassFieldsReader.b(this.a);
    int i = this.b;
    this.b = (i + 1);
    return arrayOfByte[i];
  }
  
  public final int d()
  {
    byte[] arrayOfByte = ClassFieldsReader.b(this.a);
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = ClassFieldsReader.b(this.a);
    int j = this.b;
    this.b = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = ClassFieldsReader.b(this.a);
    int k = this.b;
    this.b = (k + 1);
    k = arrayOfByte[k];
    arrayOfByte = ClassFieldsReader.b(this.a);
    int m = this.b;
    this.b = (m + 1);
    return (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
  }
  
  public final long e()
  {
    byte[] arrayOfByte = ClassFieldsReader.b(this.a);
    int i = this.b;
    this.b = (i + 1);
    long l1 = arrayOfByte[i];
    arrayOfByte = ClassFieldsReader.b(this.a);
    i = this.b;
    this.b = (i + 1);
    long l2 = arrayOfByte[i];
    arrayOfByte = ClassFieldsReader.b(this.a);
    i = this.b;
    this.b = (i + 1);
    long l3 = arrayOfByte[i];
    arrayOfByte = ClassFieldsReader.b(this.a);
    i = this.b;
    this.b = (i + 1);
    long l4 = arrayOfByte[i];
    arrayOfByte = ClassFieldsReader.b(this.a);
    i = this.b;
    this.b = (i + 1);
    long l5 = arrayOfByte[i];
    arrayOfByte = ClassFieldsReader.b(this.a);
    i = this.b;
    this.b = (i + 1);
    long l6 = arrayOfByte[i];
    arrayOfByte = ClassFieldsReader.b(this.a);
    i = this.b;
    this.b = (i + 1);
    long l7 = arrayOfByte[i];
    arrayOfByte = ClassFieldsReader.b(this.a);
    i = this.b;
    this.b = (i + 1);
    return (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | 0xFF & arrayOfByte[i];
  }
  
  public final short f()
  {
    byte[] arrayOfByte = ClassFieldsReader.b(this.a);
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = ClassFieldsReader.b(this.a);
    int j = this.b;
    this.b = (j + 1);
    return (short)((i & 0xFF) << 8 | arrayOfByte[j] & 0xFF);
  }
  
  public final int g()
  {
    return f() & 0xFFFF;
  }
  
  public final int h()
  {
    return c() & 0xFF;
  }
  
  public final long i()
  {
    int i = ClassFieldsReader.a(this.a);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8) {
            return e();
          }
          throw ((Throwable)new IllegalArgumentException("ID Length must be 1, 2, 4, or 8"));
        }
        i = d();
      }
      else
      {
        i = f();
      }
    }
    else {
      i = c();
    }
    return i;
  }
  
  public final boolean j()
  {
    return c() != 0;
  }
  
  public final char k()
  {
    return (char)f();
  }
  
  public final float l()
  {
    FloatCompanionObject localFloatCompanionObject = FloatCompanionObject.INSTANCE;
    return Float.intBitsToFloat(d());
  }
  
  public final double m()
  {
    DoubleCompanionObject localDoubleCompanionObject = DoubleCompanionObject.INSTANCE;
    return Double.longBitsToDouble(e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ClassFieldsReader.ReadInFlight
 * JD-Core Version:    0.7.0.1
 */