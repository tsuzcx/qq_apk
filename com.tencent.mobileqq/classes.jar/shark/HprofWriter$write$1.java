package shark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lokio/BufferedSink;", "invoke"}, k=3, mv={1, 4, 1})
final class HprofWriter$write$1
  extends Lambda
  implements Function1<BufferedSink, Unit>
{
  HprofWriter$write$1(HprofWriter paramHprofWriter, HprofRecord paramHprofRecord)
  {
    super(1);
  }
  
  public final void invoke(@NotNull BufferedSink paramBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSink, "$receiver");
    HprofWriter.a(this.this$0, paramBufferedSink, ((HprofRecord.StringRecord)this.$record).a());
    paramBufferedSink.writeUtf8(((HprofRecord.StringRecord)this.$record).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofWriter.write.1
 * JD-Core Version:    0.7.0.1
 */