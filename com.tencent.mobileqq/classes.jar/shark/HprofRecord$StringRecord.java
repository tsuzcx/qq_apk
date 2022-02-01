package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$StringRecord;", "Lshark/HprofRecord;", "id", "", "string", "", "(JLjava/lang/String;)V", "getId", "()J", "getString", "()Ljava/lang/String;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$StringRecord
  extends HprofRecord
{
  private final long a;
  @NotNull
  private final String b;
  
  public HprofRecord$StringRecord(long paramLong, @NotNull String paramString)
  {
    super(null);
    this.a = paramLong;
    this.b = paramString;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.StringRecord
 * JD-Core Version:    0.7.0.1
 */