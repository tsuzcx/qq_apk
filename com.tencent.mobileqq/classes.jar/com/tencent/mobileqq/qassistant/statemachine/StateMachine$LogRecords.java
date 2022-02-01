package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import java.util.Vector;

class StateMachine$LogRecords
{
  private Vector<StateMachine.LogRec> a = new Vector();
  private int b = 20;
  private int c = 0;
  private int d = 0;
  private boolean e = false;
  
  void a(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
  {
    try
    {
      this.d += 1;
      if (this.a.size() < this.b)
      {
        this.a.add(new StateMachine.LogRec(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3));
      }
      else
      {
        StateMachine.LogRec localLogRec = (StateMachine.LogRec)this.a.get(this.c);
        this.c += 1;
        if (this.c >= this.b) {
          this.c = 0;
        }
        localLogRec.a(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3);
      }
      return;
    }
    finally {}
  }
  
  boolean a()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void b()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.LogRecords
 * JD-Core Version:    0.7.0.1
 */