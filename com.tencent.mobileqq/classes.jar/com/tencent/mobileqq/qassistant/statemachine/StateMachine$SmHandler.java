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
    StateMachine localStateMachine;
    StringBuilder localStringBuilder;
    while (i >= 0)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localStateMachine = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("moveTempStackToStateStack: i=");
        localStringBuilder.append(i);
        localStringBuilder.append(",j=");
        localStringBuilder.append(j);
        localStateMachine.a(localStringBuilder.toString());
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[j] = this.jdField_b_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[i];
      j += 1;
      i -= 1;
    }
    this.jdField_a_of_type_Int = (j - 1);
    if (this.jdField_b_of_type_Boolean)
    {
      localStateMachine = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveTempStackToStateStack: X mStateStackTop=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(",startingIndex=");
      localStringBuilder.append(k);
      localStringBuilder.append(",Top=");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_a_of_type_Int].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
      localStateMachine.a(localStringBuilder.toString());
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
    StringBuilder localStringBuilder;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("processMsg: ");
      localStringBuilder.append(((StateMachine.SmHandler.StateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
      ((StateMachine)localObject1).a(localStringBuilder.toString());
    }
    Object localObject1 = localObject2;
    if (a(paramMessage)) {
      a(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$QuittingState);
    } else {
      for (;;)
      {
        localObject2 = localObject1;
        if (((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a(paramMessage)) {
          break;
        }
        localObject2 = ((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
        if (localObject2 == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.b(paramMessage);
          break;
        }
        localObject1 = localObject2;
        if (this.jdField_b_of_type_Boolean)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("processMsg: ");
          localStringBuilder.append(((StateMachine.SmHandler.StateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
          ((StateMachine)localObject1).a(localStringBuilder.toString());
          localObject1 = localObject2;
        }
      }
    }
    if (localObject2 != null) {
      return ((StateMachine.SmHandler.StateInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState;
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
    if (this.jdField_b_of_type_Boolean)
    {
      paramState = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(",curStateInfo: ");
      localStringBuilder.append(localObject);
      paramState.a(localStringBuilder.toString());
    }
    return localObject;
  }
  
  private final StateMachine.SmHandler.StateInfo a(State paramState1, State paramState2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addStateInternal: E state=");
      localStringBuilder.append(paramState1.a());
      localStringBuilder.append(",parent=");
      if (paramState2 == null) {
        localObject1 = "";
      } else {
        localObject1 = paramState2.a();
      }
      localStringBuilder.append((String)localObject1);
      ((StateMachine)localObject2).a(localStringBuilder.toString());
    }
    if (paramState2 != null)
    {
      localObject1 = (StateMachine.SmHandler.StateInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramState2);
      if (localObject1 == null) {
        paramState2 = a(paramState2, null);
      } else {
        paramState2 = (State)localObject1;
      }
    }
    else
    {
      paramState2 = null;
    }
    Object localObject2 = (StateMachine.SmHandler.StateInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramState1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StateMachine.SmHandler.StateInfo(this, null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramState1, localObject1);
    }
    if ((((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo != null) && (((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo != paramState2)) {
      throw new RuntimeException("state already added");
    }
    ((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState = paramState1;
    ((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo = paramState2;
    ((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean)
    {
      paramState1 = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      paramState2 = new StringBuilder();
      paramState2.append("addStateInternal: X stateInfo: ");
      paramState2.append(localObject1);
      paramState1.a(paramState2.toString());
    }
    return localObject1;
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
      if (this.jdField_b_of_type_Boolean)
      {
        StateMachine localStateMachine = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invokeEnterMethods: ");
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[paramInt].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
        localStateMachine.a(localStringBuilder.toString());
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[paramInt].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[paramInt].jdField_a_of_type_Boolean = true;
      paramInt += 1;
    }
  }
  
  private final void a(Message paramMessage)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deferMessage: msg=");
      localStringBuilder.append(paramMessage.what);
      ((StateMachine)localObject).a(localStringBuilder.toString());
    }
    Object localObject = obtainMessage();
    ((Message)localObject).copyFrom(paramMessage);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
  }
  
  private final void a(IState paramIState)
  {
    this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState = ((State)paramIState);
    if (this.jdField_b_of_type_Boolean)
    {
      paramIState = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transitionTo: destState=");
      localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState.a());
      paramIState.a(localStringBuilder.toString());
    }
  }
  
  private final void a(State paramState)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      StateMachine localStateMachine = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setInitialState: initialState=");
      localStringBuilder.append(paramState.a());
      localStateMachine.a(localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState = paramState;
  }
  
  private void a(State paramState, Message paramMessage)
  {
    State localState = this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_a_of_type_Int].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a(this.jdField_a_of_type_AndroidOsMessage)) && (paramMessage.obj != jdField_a_of_type_JavaLangObject)) {
      i = 1;
    } else {
      i = 0;
    }
    StateMachine localStateMachine;
    Message localMessage;
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$LogRecords.a())
    {
      if (this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState != null)
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$LogRecords;
        localStateMachine = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
        localMessage = this.jdField_a_of_type_AndroidOsMessage;
        paramMessage.a(localStateMachine, localMessage, localStateMachine.a(localMessage), paramState, localState, this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState);
      }
    }
    else if (i != 0)
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$LogRecords;
      localStateMachine = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      localMessage = this.jdField_a_of_type_AndroidOsMessage;
      paramMessage.a(localStateMachine, localMessage, localStateMachine.a(localMessage), paramState, localState, this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState);
    }
    paramState = this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState;
    paramMessage = paramState;
    if (paramState != null)
    {
      for (;;)
      {
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("handleMessage: new destination call exit/enter");
        }
        a(a(paramState));
        a(a());
        c();
        paramMessage = this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState;
        if (paramState == paramMessage) {
          break;
        }
        paramState = paramMessage;
      }
      this.jdField_b_of_type_ComTencentMobileqqQassistantStatemachineState = null;
      paramMessage = paramState;
    }
    if (paramMessage != null)
    {
      if (paramMessage == this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$QuittingState)
      {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.b();
        a();
        return;
      }
      if (paramMessage == this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$HaltingState) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a();
      }
    }
  }
  
  private final void a(StateMachine.SmHandler.StateInfo paramStateInfo)
  {
    for (;;)
    {
      int i = this.jdField_a_of_type_Int;
      if (i < 0) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
      if (localObject[i] == paramStateInfo) {
        break;
      }
      localObject = localObject[i].jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState;
      if (this.jdField_b_of_type_Boolean)
      {
        StateMachine localStateMachine = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invokeExitMethods: ");
        localStringBuilder.append(((State)localObject).a());
        localStateMachine.a(localStringBuilder.toString());
      }
      ((State)localObject).b();
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
      i = this.jdField_a_of_type_Int;
      localObject[i].jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = (i - 1);
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
    Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    int j = 0;
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (StateMachine.SmHandler.StateInfo)((Iterator)localObject2).next();
      int i = 0;
      while (localObject1 != null)
      {
        localObject1 = ((StateMachine.SmHandler.StateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
        i += 1;
      }
      if (j < i) {
        j = i;
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("completeConstruction: maxDepth=");
      ((StringBuilder)localObject2).append(j);
      ((StateMachine)localObject1).a(((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo = new StateMachine.SmHandler.StateInfo[j];
    this.jdField_b_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo = new StateMachine.SmHandler.StateInfo[j];
    d();
    sendMessageAtFrontOfQueue(obtainMessage(-2, jdField_a_of_type_JavaLangObject));
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine.a("completeConstruction: X");
    }
  }
  
  private final void c()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i >= 0)
    {
      Message localMessage = (Message)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_Boolean)
      {
        StateMachine localStateMachine = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("moveDeferredMessageAtFrontOfQueue; what=");
        localStringBuilder.append(localMessage.what);
        localStateMachine.a(localStringBuilder.toString());
      }
      sendMessageAtFrontOfQueue(localMessage);
      i -= 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private final void d()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupInitialStateStack: E mInitialState=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState.a());
      ((StateMachine)localObject).a(localStringBuilder.toString());
    }
    Object localObject = (StateMachine.SmHandler.StateInfo)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineState);
    for (int i = 0;; i = this.jdField_b_of_type_Int + 1)
    {
      this.jdField_b_of_type_Int = i;
      if (localObject == null) {
        break;
      }
      this.jdField_b_of_type_ArrayOfComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo[this.jdField_b_of_type_Int] = localObject;
      localObject = ((StateMachine.SmHandler.StateInfo)localObject).jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine$SmHandler$StateInfo;
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
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage: E msg.what=");
        localStringBuilder.append(paramMessage.what);
        ((StateMachine)localObject).a(localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidOsMessage = paramMessage;
      Object localObject = null;
      boolean bool = this.c;
      if (bool)
      {
        localObject = a(paramMessage);
      }
      else
      {
        if ((bool) || (this.jdField_a_of_type_AndroidOsMessage.what != -2) || (this.jdField_a_of_type_AndroidOsMessage.obj != jdField_a_of_type_JavaLangObject)) {
          break label150;
        }
        this.c = true;
        a(0);
      }
      a((State)localObject, paramMessage);
      if (this.jdField_b_of_type_Boolean)
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqQassistantStatemachineStateMachine;
        if (paramMessage != null)
        {
          paramMessage.a("handleMessage: X");
          return;
          label150:
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("StateMachine.handleMessage: The start method not called, received msg: ");
          ((StringBuilder)localObject).append(paramMessage);
          throw new RuntimeException(((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.SmHandler
 * JD-Core Version:    0.7.0.1
 */