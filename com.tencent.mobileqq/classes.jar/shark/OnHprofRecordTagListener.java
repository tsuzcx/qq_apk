package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/OnHprofRecordTagListener;", "", "onHprofRecord", "", "tag", "Lshark/HprofRecordTag;", "length", "", "reader", "Lshark/HprofRecordReader;", "Companion", "shark-hprof"}, k=1, mv={1, 4, 1})
public abstract interface OnHprofRecordTagListener
{
  @NotNull
  public static final OnHprofRecordTagListener.Companion a = OnHprofRecordTagListener.Companion.a;
  
  public abstract void a(@NotNull HprofRecordTag paramHprofRecordTag, long paramLong, @NotNull HprofRecordReader paramHprofRecordReader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.OnHprofRecordTagListener
 * JD-Core Version:    0.7.0.1
 */