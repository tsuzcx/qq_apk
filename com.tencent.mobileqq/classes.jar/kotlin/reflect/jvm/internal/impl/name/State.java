package kotlin.reflect.jvm.internal.impl.name;

 enum State
{
  static
  {
    State localState1 = new State("BEGINNING", 0);
    BEGINNING = localState1;
    State localState2 = new State("MIDDLE", 1);
    MIDDLE = localState2;
    State localState3 = new State("AFTER_DOT", 2);
    AFTER_DOT = localState3;
    $VALUES = new State[] { localState1, localState2, localState3 };
  }
  
  private State() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.name.State
 * JD-Core Version:    0.7.0.1
 */