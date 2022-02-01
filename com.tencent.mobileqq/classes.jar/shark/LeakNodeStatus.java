package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakNodeStatus;", "", "(Ljava/lang/String;I)V", "NOT_LEAKING", "LEAKING", "UNKNOWN", "shark"}, k=1, mv={1, 4, 1})
public enum LeakNodeStatus
{
  static
  {
    LeakNodeStatus localLeakNodeStatus1 = new LeakNodeStatus("NOT_LEAKING", 0);
    NOT_LEAKING = localLeakNodeStatus1;
    LeakNodeStatus localLeakNodeStatus2 = new LeakNodeStatus("LEAKING", 1);
    LEAKING = localLeakNodeStatus2;
    LeakNodeStatus localLeakNodeStatus3 = new LeakNodeStatus("UNKNOWN", 2);
    UNKNOWN = localLeakNodeStatus3;
    $VALUES = new LeakNodeStatus[] { localLeakNodeStatus1, localLeakNodeStatus2, localLeakNodeStatus3 };
  }
  
  private LeakNodeStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakNodeStatus
 * JD-Core Version:    0.7.0.1
 */