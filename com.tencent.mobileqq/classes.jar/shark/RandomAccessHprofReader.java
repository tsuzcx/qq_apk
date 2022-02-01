package shark;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/RandomAccessHprofReader;", "Ljava/io/Closeable;", "source", "Lshark/RandomAccessSource;", "hprofHeader", "Lshark/HprofHeader;", "(Lshark/RandomAccessSource;Lshark/HprofHeader;)V", "buffer", "Lokio/Buffer;", "reader", "Lshark/HprofRecordReader;", "close", "", "readRecord", "T", "recordPosition", "", "recordSize", "withRecordReader", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(JJLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class RandomAccessHprofReader
  implements Closeable
{
  @NotNull
  public static final RandomAccessHprofReader.Companion a = new RandomAccessHprofReader.Companion(null);
  private final Buffer b;
  private final HprofRecordReader c;
  private final RandomAccessSource d;
  
  private RandomAccessHprofReader(RandomAccessSource paramRandomAccessSource, HprofHeader paramHprofHeader)
  {
    this.d = paramRandomAccessSource;
    this.b = new Buffer();
    this.c = new HprofRecordReader(paramHprofHeader, (BufferedSource)this.b);
  }
  
  public final <T> T a(long paramLong1, long paramLong2, @NotNull Function1<? super HprofRecordReader, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "withRecordReader");
    int j = 1;
    int i;
    if (paramLong2 > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = paramLong1;
      while (paramLong2 > 0L)
      {
        long l2 = this.d.a(this.b, l1, paramLong2);
        if (l2 > 0L) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          l1 += l2;
          paramLong2 -= l2;
        }
        else
        {
          paramFunction1 = new StringBuilder();
          paramFunction1.append("Requested ");
          paramFunction1.append(paramLong2);
          paramFunction1.append(" bytes after reading ");
          paramFunction1.append(l1 - paramLong1);
          paramFunction1.append(", got 0 bytes instead.");
          throw ((Throwable)new IllegalStateException(paramFunction1.toString().toString()));
        }
      }
      paramFunction1 = paramFunction1.invoke(this.c);
      if (this.b.size() == 0L) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0) {
        return paramFunction1;
      }
      paramFunction1 = new StringBuilder();
      paramFunction1.append("Buffer not fully consumed: ");
      paramFunction1.append(this.b.size());
      paramFunction1.append(" bytes left");
      throw ((Throwable)new IllegalStateException(paramFunction1.toString().toString()));
    }
    paramFunction1 = new StringBuilder();
    paramFunction1.append("recordSize ");
    paramFunction1.append(paramLong2);
    paramFunction1.append(" must be > 0");
    paramFunction1 = (Throwable)new IllegalArgumentException(paramFunction1.toString().toString());
    for (;;)
    {
      throw paramFunction1;
    }
  }
  
  public void close()
  {
    this.d.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.RandomAccessHprofReader
 * JD-Core Version:    0.7.0.1
 */