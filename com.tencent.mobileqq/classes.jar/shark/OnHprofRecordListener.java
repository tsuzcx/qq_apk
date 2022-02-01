package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/OnHprofRecordListener;", "", "onHprofRecord", "", "position", "", "record", "Lshark/HprofRecord;", "Companion", "shark-hprof"}, k=1, mv={1, 4, 1})
public abstract interface OnHprofRecordListener
{
  @NotNull
  public static final OnHprofRecordListener.Companion g = OnHprofRecordListener.Companion.a;
  
  public abstract void a(long paramLong, @NotNull HprofRecord paramHprofRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.OnHprofRecordListener
 * JD-Core Version:    0.7.0.1
 */