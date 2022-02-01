package shark.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.Ref.LongRef;
import org.jetbrains.annotations.NotNull;
import shark.HprofRecordReader;
import shark.HprofRecordTag;
import shark.OnHprofRecordTagListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/OnHprofRecordTagListener$Companion$invoke$1", "Lshark/OnHprofRecordTagListener;", "onHprofRecord", "", "tag", "Lshark/HprofRecordTag;", "length", "", "reader", "Lshark/HprofRecordReader;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofInMemoryIndex$Companion$indexHprof$$inlined$invoke$1
  implements OnHprofRecordTagListener
{
  public HprofInMemoryIndex$Companion$indexHprof$$inlined$invoke$1(Ref.IntRef paramIntRef1, Ref.LongRef paramLongRef1, Ref.IntRef paramIntRef2, Ref.IntRef paramIntRef3, Ref.LongRef paramLongRef2, Ref.IntRef paramIntRef4, Ref.LongRef paramLongRef3, Ref.IntRef paramIntRef5, Ref.LongRef paramLongRef4) {}
  
  public void a(@NotNull HprofRecordTag paramHprofRecordTag, long paramLong, @NotNull HprofRecordReader paramHprofRecordReader)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecordTag, "tag");
    Intrinsics.checkParameterIsNotNull(paramHprofRecordReader, "reader");
    paramLong = paramHprofRecordReader.a();
    int k = HprofInMemoryIndex.Companion.WhenMappings.$EnumSwitchMapping$0[paramHprofRecordTag.ordinal()];
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4) {
            return;
          }
          paramHprofRecordTag = this.i;
          paramHprofRecordTag.element += 1;
          paramHprofRecordReader.G();
          paramHprofRecordTag = this.j;
          paramHprofRecordTag.element = Math.max(paramHprofRecordTag.element, paramHprofRecordReader.a() - paramLong);
          return;
        }
        paramHprofRecordTag = this.g;
        paramHprofRecordTag.element += 1;
        paramHprofRecordReader.F();
        paramHprofRecordTag = this.h;
        paramHprofRecordTag.element = Math.max(paramHprofRecordTag.element, paramHprofRecordReader.a() - paramLong);
        return;
      }
      paramHprofRecordTag = this.e;
      paramHprofRecordTag.element += 1;
      paramHprofRecordReader.D();
      paramHprofRecordTag = this.f;
      paramHprofRecordTag.element = Math.max(paramHprofRecordTag.element, paramHprofRecordReader.a() - paramLong);
      return;
    }
    paramHprofRecordTag = this.b;
    paramHprofRecordTag.element += 1;
    paramHprofRecordReader.z();
    long l = paramHprofRecordReader.a();
    paramHprofRecordReader.B();
    paramHprofRecordReader.C();
    paramHprofRecordTag = this.c;
    paramHprofRecordTag.element = Math.max(paramHprofRecordTag.element, paramHprofRecordReader.a() - paramLong);
    paramHprofRecordTag = this.d;
    paramHprofRecordTag.element += (int)(paramHprofRecordReader.a() - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.HprofInMemoryIndex.Companion.indexHprof..inlined.invoke.1
 * JD-Core Version:    0.7.0.1
 */