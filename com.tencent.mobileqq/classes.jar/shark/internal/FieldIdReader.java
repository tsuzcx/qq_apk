package shark.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import shark.HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/FieldIdReader;", "", "record", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "identifierByteSize", "", "(Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;I)V", "position", "readByteId", "", "index", "array", "", "readId", "readIntId", "readLongId", "readShortId", "skipBytes", "", "count", "and", "", "other", "shark"}, k=1, mv={1, 4, 1})
public final class FieldIdReader
{
  private int a;
  private final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord b;
  private final int c;
  
  public FieldIdReader(@NotNull HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord paramInstanceDumpRecord, int paramInt)
  {
    this.b = paramInstanceDumpRecord;
    this.c = paramInt;
  }
  
  private final long a(int paramInt, byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[paramInt];
  }
  
  private final long b(int paramInt, byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[paramInt] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF;
  }
  
  private final long c(int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramInt + 1;
    paramInt = paramArrayOfByte[paramInt];
    int j = i + 1;
    return (paramInt & 0xFF) << 24 | (paramArrayOfByte[i] & 0xFF) << 16 | (paramArrayOfByte[j] & 0xFF) << 8 | paramArrayOfByte[(j + 1)] & 0xFF;
  }
  
  private final long d(int paramInt, byte[] paramArrayOfByte)
  {
    int i = paramInt + 1;
    long l1 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l2 = paramArrayOfByte[i];
    i = paramInt + 1;
    long l3 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l4 = paramArrayOfByte[i];
    i = paramInt + 1;
    long l5 = paramArrayOfByte[paramInt];
    paramInt = i + 1;
    long l6 = paramArrayOfByte[i];
    long l7 = paramArrayOfByte[paramInt];
    return paramArrayOfByte[(paramInt + 1)] & 0xFF | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  public final long a()
  {
    int i = this.c;
    long l;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8) {
            l = d(this.a, this.b.d());
          } else {
            throw ((Throwable)new IllegalStateException("ID Length must be 1, 2, 4, or 8".toString()));
          }
        }
        else {
          l = c(this.a, this.b.d());
        }
      }
      else {
        l = b(this.a, this.b.d());
      }
    }
    else {
      l = a(this.a, this.b.d());
    }
    this.a += this.c;
    return l;
  }
  
  public final void a(int paramInt)
  {
    this.a += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.FieldIdReader
 * JD-Core Version:    0.7.0.1
 */