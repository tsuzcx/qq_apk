package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/OnHprofRecordTagListener$Companion$invoke$1", "Lshark/OnHprofRecordTagListener;", "onHprofRecord", "", "tag", "Lshark/HprofRecordTag;", "length", "", "reader", "Lshark/HprofRecordReader;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class OnHprofRecordTagListener$Companion$invoke$1
  implements OnHprofRecordTagListener
{
  public void a(@NotNull HprofRecordTag paramHprofRecordTag, long paramLong, @NotNull HprofRecordReader paramHprofRecordReader)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecordTag, "tag");
    Intrinsics.checkParameterIsNotNull(paramHprofRecordReader, "reader");
    this.b.invoke(paramHprofRecordTag, Long.valueOf(paramLong), paramHprofRecordReader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.OnHprofRecordTagListener.Companion.invoke.1
 * JD-Core Version:    0.7.0.1
 */