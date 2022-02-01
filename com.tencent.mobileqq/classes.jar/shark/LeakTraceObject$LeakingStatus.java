package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTraceObject$LeakingStatus;", "", "(Ljava/lang/String;I)V", "NOT_LEAKING", "LEAKING", "UNKNOWN", "shark"}, k=1, mv={1, 4, 1})
public enum LeakTraceObject$LeakingStatus
{
  static
  {
    LeakingStatus localLeakingStatus1 = new LeakingStatus("NOT_LEAKING", 0);
    NOT_LEAKING = localLeakingStatus1;
    LeakingStatus localLeakingStatus2 = new LeakingStatus("LEAKING", 1);
    LEAKING = localLeakingStatus2;
    LeakingStatus localLeakingStatus3 = new LeakingStatus("UNKNOWN", 2);
    UNKNOWN = localLeakingStatus3;
    $VALUES = new LeakingStatus[] { localLeakingStatus1, localLeakingStatus2, localLeakingStatus3 };
  }
  
  private LeakTraceObject$LeakingStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTraceObject.LeakingStatus
 * JD-Core Version:    0.7.0.1
 */