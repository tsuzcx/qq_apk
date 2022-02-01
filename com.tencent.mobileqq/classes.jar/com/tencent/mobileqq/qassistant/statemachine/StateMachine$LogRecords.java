package com.tencent.mobileqq.qassistant.statemachine;

import java.util.Vector;

class StateMachine$LogRecords
{
  private int jdField_a_of_type_Int = 20;
  private Vector<StateMachine.LogRec> jdField_a_of_type_JavaUtilVector = new Vector();
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  private int c = 0;
  
  void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilVector.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void a(StateMachine paramStateMachine, android.os.Message paramMessage, java.lang.String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 26	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:c	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 26	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:c	I
    //   12: aload_0
    //   13: getfield 20	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   16: invokevirtual 39	java/util/Vector:size	()I
    //   19: aload_0
    //   20: getfield 22	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:jdField_a_of_type_Int	I
    //   23: if_icmpge +30 -> 53
    //   26: aload_0
    //   27: getfield 20	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   30: new 41	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRec
    //   33: dup
    //   34: aload_1
    //   35: aload_2
    //   36: aload_3
    //   37: aload 4
    //   39: aload 5
    //   41: aload 6
    //   43: invokespecial 43	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRec:<init>	(Lcom/tencent/mobileqq/qassistant/statemachine/StateMachine;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mobileqq/qassistant/statemachine/IState;Lcom/tencent/mobileqq/qassistant/statemachine/IState;Lcom/tencent/mobileqq/qassistant/statemachine/IState;)V
    //   46: invokevirtual 47	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   49: pop
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: getfield 20	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   57: aload_0
    //   58: getfield 24	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:b	I
    //   61: invokevirtual 51	java/util/Vector:get	(I)Ljava/lang/Object;
    //   64: checkcast 41	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRec
    //   67: astore 7
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 24	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:b	I
    //   74: iconst_1
    //   75: iadd
    //   76: putfield 24	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:b	I
    //   79: aload_0
    //   80: getfield 24	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:b	I
    //   83: aload_0
    //   84: getfield 22	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:jdField_a_of_type_Int	I
    //   87: if_icmplt +8 -> 95
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 24	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRecords:b	I
    //   95: aload 7
    //   97: aload_1
    //   98: aload_2
    //   99: aload_3
    //   100: aload 4
    //   102: aload 5
    //   104: aload 6
    //   106: invokevirtual 53	com/tencent/mobileqq/qassistant/statemachine/StateMachine$LogRec:a	(Lcom/tencent/mobileqq/qassistant/statemachine/StateMachine;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mobileqq/qassistant/statemachine/IState;Lcom/tencent/mobileqq/qassistant/statemachine/IState;Lcom/tencent/mobileqq/qassistant/statemachine/IState;)V
    //   109: goto -59 -> 50
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	LogRecords
    //   0	117	1	paramStateMachine	StateMachine
    //   0	117	2	paramMessage	android.os.Message
    //   0	117	3	paramString	java.lang.String
    //   0	117	4	paramIState1	IState
    //   0	117	5	paramIState2	IState
    //   0	117	6	paramIState3	IState
    //   67	29	7	localLogRec	StateMachine.LogRec
    // Exception table:
    //   from	to	target	type
    //   2	50	112	finally
    //   53	95	112	finally
    //   95	109	112	finally
  }
  
  boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.LogRecords
 * JD-Core Version:    0.7.0.1
 */