package com.tencent.mobileqq.writetogether.statemachine.core;

import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class StateMachine<E extends Enum>
{
  private String a = "EditorStateMachine";
  private SparseArrayCompat<StateProcessor<E>> b;
  private SparseArrayCompat<List<E>> c;
  private E d;
  private E e;
  
  public StateMachine(E paramE, String paramString)
  {
    this.d = paramE;
    paramE = new StringBuilder();
    paramE.append(this.a);
    paramE.append(".");
    paramE.append(paramString);
    this.a = paramE.toString();
  }
  
  private void a(E paramE, List<E> paramList)
  {
    if (this.c == null) {
      this.c = new SparseArrayCompat();
    }
    this.c.put(paramE.ordinal(), paramList);
  }
  
  private boolean c(E paramE)
  {
    List localList = (List)this.c.get(paramE.ordinal());
    return (localList != null) && (localList.contains(this.d)) && (this.d != paramE);
  }
  
  public E a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    StateProcessor localStateProcessor = b(this.d);
    if (localStateProcessor != null) {
      localStateProcessor.a(paramInt);
    }
  }
  
  public void a(StateProcessor<E> paramStateProcessor)
  {
    if (this.b == null) {
      this.b = new SparseArrayCompat();
    }
    this.b.put(((Enum)paramStateProcessor.c()).ordinal(), paramStateProcessor);
    a((Enum)paramStateProcessor.c(), paramStateProcessor.d());
  }
  
  public void a(E paramE)
  {
    a(paramE, null);
  }
  
  public void a(E paramE, String paramString)
  {
    Object localObject;
    if (c(paramE))
    {
      localObject = b(paramE);
      if ((localObject == null) || (!((StateProcessor)localObject).b())) {
        this.e = this.d;
      }
      this.d = paramE;
      paramE = b(this.e);
      if (paramE != null) {
        paramE.a();
      }
      if (localObject != null)
      {
        ((StateProcessor)localObject).f = paramString;
        ((StateProcessor)localObject).a(this.e);
      }
      if (QLog.isColorLevel())
      {
        paramE = this.a;
        paramString = new StringBuilder();
        paramString.append("[setState] from: ");
        paramString.append(this.e);
        paramString.append(" -> to: ");
        paramString.append(this.d);
        QLog.d(paramE, 2, paramString.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setState] not allowed state trans: from: ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(" -> to: ");
      ((StringBuilder)localObject).append(paramE);
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public <T extends StateProcessor<E>> T b(E paramE)
  {
    return (StateProcessor)this.b.get(paramE.ordinal());
  }
  
  public E b()
  {
    return this.e;
  }
  
  public void c()
  {
    a(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.core.StateMachine
 * JD-Core Version:    0.7.0.1
 */