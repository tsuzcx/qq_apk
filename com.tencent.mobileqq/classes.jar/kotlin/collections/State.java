package kotlin.collections;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/State;", "", "(Ljava/lang/String;I)V", "Ready", "NotReady", "Done", "Failed", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
 enum State
{
  static
  {
    State localState1 = new State("Ready", 0);
    Ready = localState1;
    State localState2 = new State("NotReady", 1);
    NotReady = localState2;
    State localState3 = new State("Done", 2);
    Done = localState3;
    State localState4 = new State("Failed", 3);
    Failed = localState4;
    $VALUES = new State[] { localState1, localState2, localState3, localState4 };
  }
  
  private State() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.State
 * JD-Core Version:    0.7.0.1
 */