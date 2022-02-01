package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public enum CoroutineScheduler$WorkerState
{
  static
  {
    WorkerState localWorkerState1 = new WorkerState("CPU_ACQUIRED", 0);
    CPU_ACQUIRED = localWorkerState1;
    WorkerState localWorkerState2 = new WorkerState("BLOCKING", 1);
    BLOCKING = localWorkerState2;
    WorkerState localWorkerState3 = new WorkerState("PARKING", 2);
    PARKING = localWorkerState3;
    WorkerState localWorkerState4 = new WorkerState("DORMANT", 3);
    DORMANT = localWorkerState4;
    WorkerState localWorkerState5 = new WorkerState("TERMINATED", 4);
    TERMINATED = localWorkerState5;
    $VALUES = new WorkerState[] { localWorkerState1, localWorkerState2, localWorkerState3, localWorkerState4, localWorkerState5 };
  }
  
  private CoroutineScheduler$WorkerState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState
 * JD-Core Version:    0.7.0.1
 */