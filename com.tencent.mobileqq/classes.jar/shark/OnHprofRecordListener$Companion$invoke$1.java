package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/OnHprofRecordListener$Companion$invoke$1", "Lshark/OnHprofRecordListener;", "onHprofRecord", "", "position", "", "record", "Lshark/HprofRecord;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class OnHprofRecordListener$Companion$invoke$1
  implements OnHprofRecordListener
{
  public void a(long paramLong, @NotNull HprofRecord paramHprofRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecord, "record");
    this.a.invoke(Long.valueOf(paramLong), paramHprofRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.OnHprofRecordListener.Companion.invoke.1
 * JD-Core Version:    0.7.0.1
 */