package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class StateMachine$SmHandler
  extends Handler
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int = -1;
  private Message jdField_a_of_type_AndroidOsMessage;
  private State jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState;
  private StateMachine.LogRecords jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$LogRecords = new StateMachine.LogRecords(null);
  private StateMachine.SmHandler.HaltingState jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$HaltingState = new StateMachine.SmHandler.HaltingState(this, null);
  private StateMachine.SmHandler.QuittingState jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$QuittingState = new StateMachine.SmHandler.QuittingState(this, null);
  private StateMachine jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
  private ArrayList<Message> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<State, StateMachine.SmHandler.StateInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private StateMachine.SmHandler.StateInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
  private int jdField_b_of_type_Int;
  private State jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState;
  private boolean jdField_b_of_type_Boolean = false;
  private StateMachine.SmHandler.StateInfo[] jdField_b_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
  private boolean c;
  
  private StateMachine$SmHandler(Looper paramLooper, StateMachine paramStateMachine)
  {
    super(paramLooper);
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine = paramStateMachine;
    a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$HaltingState, null);
    a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$QuittingState, null);
  }
  
  private final int a()
  {
    int k = this.jdField_a_of_type_Int + 1;
    int i = this.jdField_b_of_type_Int - 1;
    int j = k;
    while (i >= 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("moveTempStackToStateStack: i=" + i + ",j=" + j);
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[j] = this.jdField_b_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[i];
      j += 1;
      i -= 1;
    }
    this.jdField_a_of_type_Int = (j - 1);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("moveTempStackToStateStack: X mStateStackTop=" + this.jdField_a_of_type_Int + ",startingIndex=" + k + ",Top=" + this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_a_of_type_Int].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
    }
    return k;
  }
  
  private final IState a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_a_of_type_Int].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState;
  }
  
  private final State a(Message paramMessage)
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_a_of_type_Int];
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("processMsg: " + ((StateMachine.SmHandler.StateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
    }
    Object localObject1 = localObject2;
    if (a(paramMessage)) {
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$QuittingState);
    }
    while (localObject2 != null)
    {
      return ((StateMachine.SmHandler.StateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState;
      do
      {
        localObject1 = localObject2;
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("processMsg: " + ((StateMachine.SmHandler.StateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (localObject1.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a(paramMessage)) {
          break;
        }
        localObject2 = localObject1.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
      } while (localObject2 != null);
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.b(paramMessage);
    }
    return null;
  }
  
  private final StateMachine.SmHandler.StateInfo a(State paramState)
  {
    this.jdField_b_of_type_Int = 0;
    paramState = (StateMachine.SmHandler.StateInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramState);
    Object localObject;
    do
    {
      localObject = this.jdField_b_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
      int i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (i + 1);
      localObject[i] = paramState;
      localObject = paramState.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
      if (localObject == null) {
        break;
      }
      paramState = (State)localObject;
    } while (!((StateMachine.SmHandler.StateInfo)localObject).jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.jdField_b_of_type_Int + ",curStateInfo: " + localObject);
    }
    return localObject;
  }
  
  private final StateMachine.SmHandler.StateInfo a(State paramState1, State paramState2)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      StringBuilder localStringBuilder = new StringBuilder().append("addStateInternal: E state=").append(paramState1.a()).append(",parent=");
      if (paramState2 == null)
      {
        localObject1 = "";
        ((StateMachine)localObject2).a((String)localObject1);
      }
    }
    else
    {
      if (paramState2 == null) {
        break label216;
      }
      localObject1 = (StateMachine.SmHandler.StateInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramState2);
      if (localObject1 != null) {
        break label211;
      }
      paramState2 = a(paramState2, null);
    }
    for (;;)
    {
      localObject2 = (StateMachine.SmHandler.StateInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramState1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new StateMachine.SmHandler.StateInfo(this, null);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramState1, localObject1);
      }
      if ((((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo != null) && (((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo != paramState2))
      {
        throw new RuntimeException("state already added");
        localObject1 = paramState2.a();
        break;
      }
      ((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState = paramState1;
      ((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo = paramState2;
      ((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("addStateInternal: X stateInfo: " + localObject1);
      }
      return localObject1;
      label211:
      paramState2 = (State)localObject1;
      continue;
      label216:
      paramState2 = null;
    }
  }
  
  private final void a()
  {
    if (StateMachine.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine) != null)
    {
      getLooper().quit();
      StateMachine.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine, null);
    }
    StateMachine.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine, null);
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine = null;
    this.jdField_a_of_type_AndroidOsMessage = null;
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$LogRecords.a();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo = null;
    this.jdField_b_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState = null;
    this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Boolean = true;
  }
  
  private final void a(int paramInt)
  {
    while (paramInt <= this.jdField_a_of_type_Int)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("invokeEnterMethods: " + this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[paramInt].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[paramInt].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[paramInt].jdField_a_of_type_Boolean = true;
      paramInt += 1;
    }
  }
  
  private final void a(Message paramMessage)
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("deferMessage: msg=" + paramMessage.what);
    }
    Message localMessage = obtainMessage();
    localMessage.copyFrom(paramMessage);
    this.jdField_a_of_type_JavaUtilArrayList.add(localMessage);
  }
  
  private final void a(IState paramIState)
  {
    this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState = ((State)paramIState);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("transitionTo: destState=" + this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState.a());
    }
  }
  
  private final void a(State paramState)
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("setInitialState: initialState=" + paramState.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState = paramState;
  }
  
  private void a(State paramState, Message paramMessage)
  {
    State localState = this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_a_of_type_Int].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a(this.jdField_a_of_type_AndroidOsMessage)) && (paramMessage.obj != jdField_a_of_type_JavaLangObject))
    {
      i = 1;
      if (!this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$LogRecords.a()) {
        break label159;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState != null) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$LogRecords.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine, this.jdField_a_of_type_AndroidOsMessage, this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a(this.jdField_a_of_type_AndroidOsMessage), paramState, localState, this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState);
      }
    }
    for (;;)
    {
      paramState = this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState;
      paramMessage = paramState;
      if (paramState == null) {
        break label206;
      }
      for (;;)
      {
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("handleMessage: new destination call exit/enter");
        }
        a(a(paramState));
        a(a());
        c();
        if (paramState == this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState) {
          break;
        }
        paramState = this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState;
      }
      i = 0;
      break;
      label159:
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$LogRecords.a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine, this.jdField_a_of_type_AndroidOsMessage, this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a(this.jdField_a_of_type_AndroidOsMessage), paramState, localState, this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState);
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState = null;
    paramMessage = paramState;
    label206:
    if (paramMessage != null)
    {
      if (paramMessage != this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$QuittingState) {
        break label230;
      }
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.b();
      a();
    }
    label230:
    while (paramMessage != this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$HaltingState) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a();
  }
  
  private final void a(StateMachine.SmHandler.StateInfo paramStateInfo)
  {
    while ((this.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_a_of_type_Int] != paramStateInfo))
    {
      State localState = this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_a_of_type_Int].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("invokeExitMethods: " + localState.a());
      }
      localState.b();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_a_of_type_Int].jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int -= 1;
    }
  }
  
  private final boolean a(Message paramMessage)
  {
    return (paramMessage.what == -1) && (paramMessage.obj == jdField_a_of_type_JavaLangObject);
  }
  
  private final void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("completeConstruction: E");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      StateMachine.SmHandler.StateInfo localStateInfo = (StateMachine.SmHandler.StateInfo)localIterator.next();
      j = 0;
      while (localStateInfo != null)
      {
        localStateInfo = localStateInfo.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
        j += 1;
      }
      if (i >= j) {
        break label168;
      }
    }
    for (;;)
    {
      i = j;
      break;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("completeConstruction: maxDepth=" + i);
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo = new StateMachine.SmHandler.StateInfo[i];
      this.jdField_b_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo = new StateMachine.SmHandler.StateInfo[i];
      d();
      sendMessageAtFrontOfQueue(obtainMessage(-2, jdField_a_of_type_JavaLangObject));
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("completeConstruction: X");
      }
      return;
      label168:
      j = i;
    }
  }
  
  private final void c()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i >= 0)
    {
      Message localMessage = (Message)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
      }
      sendMessageAtFrontOfQueue(localMessage);
      i -= 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private final void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("setupInitialStateStack: E mInitialState=" + this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
    }
    StateMachine.SmHandler.StateInfo localStateInfo = (StateMachine.SmHandler.StateInfo)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState);
    for (this.jdField_b_of_type_Int = 0; localStateInfo != null; this.jdField_b_of_type_Int += 1)
    {
      this.jdField_b_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_b_of_type_Int] = localStateInfo;
      localStateInfo = localStateInfo.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
    }
    this.jdField_a_of_type_Int = -1;
    a();
  }
  
  private final void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("quit:");
    }
    sendMessage(obtainMessage(-1, jdField_a_of_type_JavaLangObject));
  }
  
  public final void handleMessage(Message paramMessage)
  {
    State localState;
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("handleMessage: E msg.what=" + paramMessage.what);
      }
      this.jdField_a_of_type_AndroidOsMessage = paramMessage;
      localState = null;
      if (!this.c) {
        break label95;
      }
      localState = a(paramMessage);
    }
    for (;;)
    {
      a(localState, paramMessage);
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine != null)) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("handleMessage: X");
      }
      return;
      label95:
      if ((this.c) || (this.jdField_a_of_type_AndroidOsMessage.what != -2) || (this.jdField_a_of_type_AndroidOsMessage.obj != jdField_a_of_type_JavaLangObject)) {
        break;
      }
      this.c = true;
      a(0);
    }
    throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.SmHandler
 * JD-Core Version:    0.7.0.1
 */