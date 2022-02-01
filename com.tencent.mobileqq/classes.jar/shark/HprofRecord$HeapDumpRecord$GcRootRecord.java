package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecord$HeapDumpRecord$GcRootRecord;", "Lshark/HprofRecord$HeapDumpRecord;", "gcRoot", "Lshark/GcRoot;", "(Lshark/GcRoot;)V", "getGcRoot", "()Lshark/GcRoot;", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecord$HeapDumpRecord$GcRootRecord
  extends HprofRecord.HeapDumpRecord
{
  @NotNull
  private final GcRoot a;
  
  public HprofRecord$HeapDumpRecord$GcRootRecord(@NotNull GcRoot paramGcRoot)
  {
    super(null);
    this.a = paramGcRoot;
  }
  
  @NotNull
  public final GcRoot a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecord.HeapDumpRecord.GcRootRecord
 * JD-Core Version:    0.7.0.1
 */