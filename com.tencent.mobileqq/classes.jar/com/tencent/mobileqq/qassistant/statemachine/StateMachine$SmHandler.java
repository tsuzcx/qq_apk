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
  private static final Object c = new Object();
  private boolean a = false;
  private boolean b = false;
  private Message d;
  private StateMachine.LogRecords e = new StateMachine.LogRecords(null);
  private boolean f;
  private StateMachine.SmHandler.StateInfo[] g;
  private int h = -1;
  private StateMachine.SmHandler.StateInfo[] i;
  private int j;
  private StateMachine.SmHandler.HaltingState k = new StateMachine.SmHandler.HaltingState(this, null);
  private StateMachine.SmHandler.QuittingState l = new StateMachine.SmHandler.QuittingState(this, null);
  private StateMachine m;
  private HashMap<State, StateMachine.SmHandler.StateInfo> n = new HashMap();
  private State o;
  private State p;
  private ArrayList<Message> q = new ArrayList();
  
  private StateMachine$SmHandler(Looper paramLooper, StateMachine paramStateMachine)
  {
    super(paramLooper);
    this.m = paramStateMachine;
    a(this.k, null);
    a(this.l, null);
  }
  
  private final State a(Message paramMessage)
  {
    Object localObject2 = this.g[this.h];
    StringBuilder localStringBuilder;
    if (this.b)
    {
      localObject1 = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("processMsg: ");
      localStringBuilder.append(((StateMachine.SmHandler.StateInfo)localObject2).a.d());
      ((StateMachine)localObject1).a(localStringBuilder.toString());
    }
    Object localObject1 = localObject2;
    if (c(paramMessage)) {
      a(this.l);
    } else {
      for (;;)
      {
        localObject2 = localObject1;
        if (((StateMachine.SmHandler.StateInfo)localObject1).a.a(paramMessage)) {
          break;
        }
        localObject2 = ((StateMachine.SmHandler.StateInfo)localObject1).b;
        if (localObject2 == null)
        {
          this.m.b(paramMessage);
          break;
        }
        localObject1 = localObject2;
        if (this.b)
        {
          localObject1 = this.m;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("processMsg: ");
          localStringBuilder.append(((StateMachine.SmHandler.StateInfo)localObject2).a.d());
          ((StateMachine)localObject1).a(localStringBuilder.toString());
          localObject1 = localObject2;
        }
      }
    }
    if (localObject2 != null) {
      return ((StateMachine.SmHandler.StateInfo)localObject2).a;
    }
    return null;
  }
  
  private final StateMachine.SmHandler.StateInfo a(State paramState)
  {
    this.j = 0;
    paramState = (StateMachine.SmHandler.StateInfo)this.n.get(paramState);
    Object localObject;
    do
    {
      localObject = this.i;
      int i1 = this.j;
      this.j = (i1 + 1);
      localObject[i1] = paramState;
      localObject = paramState.b;
      if (localObject == null) {
        break;
      }
      paramState = (State)localObject;
    } while (!((StateMachine.SmHandler.StateInfo)localObject).c);
    if (this.b)
    {
      paramState = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=");
      localStringBuilder.append(this.j);
      localStringBuilder.append(",curStateInfo: ");
      localStringBuilder.append(localObject);
      paramState.a(localStringBuilder.toString());
    }
    return localObject;
  }
  
  private final StateMachine.SmHandler.StateInfo a(State paramState1, State paramState2)
  {
    if (this.b)
    {
      localObject2 = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addStateInternal: E state=");
      localStringBuilder.append(paramState1.d());
      localStringBuilder.append(",parent=");
      if (paramState2 == null) {
        localObject1 = "";
      } else {
        localObject1 = paramState2.d();
      }
      localStringBuilder.append((String)localObject1);
      ((StateMachine)localObject2).a(localStringBuilder.toString());
    }
    if (paramState2 != null)
    {
      localObject1 = (StateMachine.SmHandler.StateInfo)this.n.get(paramState2);
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
    Object localObject2 = (StateMachine.SmHandler.StateInfo)this.n.get(paramState1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StateMachine.SmHandler.StateInfo(this, null);
      this.n.put(paramState1, localObject1);
    }
    if ((((StateMachine.SmHandler.StateInfo)localObject1).b != null) && (((StateMachine.SmHandler.StateInfo)localObject1).b != paramState2)) {
      throw new RuntimeException("state already added");
    }
    ((StateMachine.SmHandler.StateInfo)localObject1).a = paramState1;
    ((StateMachine.SmHandler.StateInfo)localObject1).b = paramState2;
    ((StateMachine.SmHandler.StateInfo)localObject1).c = false;
    if (this.b)
    {
      paramState1 = this.m;
      paramState2 = new StringBuilder();
      paramState2.append("addStateInternal: X stateInfo: ");
      paramState2.append(localObject1);
      paramState1.a(paramState2.toString());
    }
    return localObject1;
  }
  
  private final void a()
  {
    if (StateMachine.a(this.m) != null)
    {
      getLooper().quit();
      StateMachine.a(this.m, null);
    }
    StateMachine.a(this.m, null);
    this.m = null;
    this.d = null;
    this.e.b();
    this.g = null;
    this.i = null;
    this.n.clear();
    this.o = null;
    this.p = null;
    this.q.clear();
    this.a = true;
  }
  
  private final void a(int paramInt)
  {
    while (paramInt <= this.h)
    {
      if (this.b)
      {
        StateMachine localStateMachine = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invokeEnterMethods: ");
        localStringBuilder.append(this.g[paramInt].a.d());
        localStateMachine.a(localStringBuilder.toString());
      }
      this.g[paramInt].a.b();
      this.g[paramInt].c = true;
      paramInt += 1;
    }
  }
  
  private final void a(IState paramIState)
  {
    this.p = ((State)paramIState);
    if (this.b)
    {
      paramIState = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transitionTo: destState=");
      localStringBuilder.append(this.p.d());
      paramIState.a(localStringBuilder.toString());
    }
  }
  
  private void a(State paramState, Message paramMessage)
  {
    State localState = this.g[this.h].a;
    int i1;
    if ((this.m.d(this.d)) && (paramMessage.obj != c)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    StateMachine localStateMachine;
    Message localMessage;
    if (this.e.a())
    {
      if (this.p != null)
      {
        paramMessage = this.e;
        localStateMachine = this.m;
        localMessage = this.d;
        paramMessage.a(localStateMachine, localMessage, localStateMachine.e(localMessage), paramState, localState, this.p);
      }
    }
    else if (i1 != 0)
    {
      paramMessage = this.e;
      localStateMachine = this.m;
      localMessage = this.d;
      paramMessage.a(localStateMachine, localMessage, localStateMachine.e(localMessage), paramState, localState, this.p);
    }
    paramState = this.p;
    paramMessage = paramState;
    if (paramState != null)
    {
      for (;;)
      {
        if (this.b) {
          this.m.a("handleMessage: new destination call exit/enter");
        }
        a(a(paramState));
        a(d());
        c();
        paramMessage = this.p;
        if (paramState == paramMessage) {
          break;
        }
        paramState = paramMessage;
      }
      this.p = null;
      paramMessage = paramState;
    }
    if (paramMessage != null)
    {
      if (paramMessage == this.l)
      {
        this.m.c();
        a();
        return;
      }
      if (paramMessage == this.k) {
        this.m.b();
      }
    }
  }
  
  private final void a(StateMachine.SmHandler.StateInfo paramStateInfo)
  {
    for (;;)
    {
      int i1 = this.h;
      if (i1 < 0) {
        break;
      }
      Object localObject = this.g;
      if (localObject[i1] == paramStateInfo) {
        break;
      }
      localObject = localObject[i1].a;
      if (this.b)
      {
        StateMachine localStateMachine = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invokeExitMethods: ");
        localStringBuilder.append(((State)localObject).d());
        localStateMachine.a(localStringBuilder.toString());
      }
      ((State)localObject).c();
      localObject = this.g;
      i1 = this.h;
      localObject[i1].c = false;
      this.h = (i1 - 1);
    }
  }
  
  private final void b()
  {
    if (this.b) {
      this.m.a("completeConstruction: E");
    }
    Object localObject2 = this.n.values().iterator();
    int i2 = 0;
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (StateMachine.SmHandler.StateInfo)((Iterator)localObject2).next();
      int i1 = 0;
      while (localObject1 != null)
      {
        localObject1 = ((StateMachine.SmHandler.StateInfo)localObject1).b;
        i1 += 1;
      }
      if (i2 < i1) {
        i2 = i1;
      }
    }
    if (this.b)
    {
      localObject1 = this.m;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("completeConstruction: maxDepth=");
      ((StringBuilder)localObject2).append(i2);
      ((StateMachine)localObject1).a(((StringBuilder)localObject2).toString());
    }
    this.g = new StateMachine.SmHandler.StateInfo[i2];
    this.i = new StateMachine.SmHandler.StateInfo[i2];
    e();
    sendMessageAtFrontOfQueue(obtainMessage(-2, c));
    if (this.b) {
      this.m.a("completeConstruction: X");
    }
  }
  
  private final void b(Message paramMessage)
  {
    if (this.b)
    {
      localObject = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deferMessage: msg=");
      localStringBuilder.append(paramMessage.what);
      ((StateMachine)localObject).a(localStringBuilder.toString());
    }
    Object localObject = obtainMessage();
    ((Message)localObject).copyFrom(paramMessage);
    this.q.add(localObject);
  }
  
  private final void b(State paramState)
  {
    if (this.b)
    {
      StateMachine localStateMachine = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setInitialState: initialState=");
      localStringBuilder.append(paramState.d());
      localStateMachine.a(localStringBuilder.toString());
    }
    this.o = paramState;
  }
  
  private final void c()
  {
    int i1 = this.q.size() - 1;
    while (i1 >= 0)
    {
      Message localMessage = (Message)this.q.get(i1);
      if (this.b)
      {
        StateMachine localStateMachine = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("moveDeferredMessageAtFrontOfQueue; what=");
        localStringBuilder.append(localMessage.what);
        localStateMachine.a(localStringBuilder.toString());
      }
      sendMessageAtFrontOfQueue(localMessage);
      i1 -= 1;
    }
    this.q.clear();
  }
  
  private final boolean c(Message paramMessage)
  {
    return (paramMessage.what == -1) && (paramMessage.obj == c);
  }
  
  private final int d()
  {
    int i3 = this.h + 1;
    int i1 = this.j - 1;
    int i2 = i3;
    StateMachine localStateMachine;
    StringBuilder localStringBuilder;
    while (i1 >= 0)
    {
      if (this.b)
      {
        localStateMachine = this.m;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("moveTempStackToStateStack: i=");
        localStringBuilder.append(i1);
        localStringBuilder.append(",j=");
        localStringBuilder.append(i2);
        localStateMachine.a(localStringBuilder.toString());
      }
      this.g[i2] = this.i[i1];
      i2 += 1;
      i1 -= 1;
    }
    this.h = (i2 - 1);
    if (this.b)
    {
      localStateMachine = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveTempStackToStateStack: X mStateStackTop=");
      localStringBuilder.append(this.h);
      localStringBuilder.append(",startingIndex=");
      localStringBuilder.append(i3);
      localStringBuilder.append(",Top=");
      localStringBuilder.append(this.g[this.h].a.d());
      localStateMachine.a(localStringBuilder.toString());
    }
    return i3;
  }
  
  private final void e()
  {
    if (this.b)
    {
      localObject = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupInitialStateStack: E mInitialState=");
      localStringBuilder.append(this.o.d());
      ((StateMachine)localObject).a(localStringBuilder.toString());
    }
    Object localObject = (StateMachine.SmHandler.StateInfo)this.n.get(this.o);
    for (int i1 = 0;; i1 = this.j + 1)
    {
      this.j = i1;
      if (localObject == null) {
        break;
      }
      this.i[this.j] = localObject;
      localObject = ((StateMachine.SmHandler.StateInfo)localObject).b;
    }
    this.h = -1;
    d();
  }
  
  private final IState f()
  {
    return this.g[this.h].a;
  }
  
  private final void g()
  {
    if (this.b) {
      this.m.a("quit:");
    }
    sendMessage(obtainMessage(-1, c));
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (!this.a)
    {
      if (this.b)
      {
        localObject = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage: E msg.what=");
        localStringBuilder.append(paramMessage.what);
        ((StateMachine)localObject).a(localStringBuilder.toString());
      }
      this.d = paramMessage;
      Object localObject = null;
      boolean bool = this.f;
      if (bool)
      {
        localObject = a(paramMessage);
      }
      else
      {
        if ((bool) || (this.d.what != -2) || (this.d.obj != c)) {
          break label150;
        }
        this.f = true;
        a(0);
      }
      a((State)localObject, paramMessage);
      if (this.b)
      {
        paramMessage = this.m;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.SmHandler
 * JD-Core Version:    0.7.0.1
 */