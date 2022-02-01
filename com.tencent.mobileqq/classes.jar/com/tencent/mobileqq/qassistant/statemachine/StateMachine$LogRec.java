package com.tencent.mobileqq.qassistant.statemachine;

import android.os.Message;
import android.text.TextUtils;
import java.util.Calendar;

public class StateMachine$LogRec
{
  private StateMachine a;
  private long b;
  private int c;
  private String d;
  private IState e;
  private IState f;
  private IState g;
  
  StateMachine$LogRec(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
  {
    a(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3);
  }
  
  public void a(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
  {
    this.a = paramStateMachine;
    this.b = System.currentTimeMillis();
    int i;
    if (paramMessage != null) {
      i = paramMessage.what;
    } else {
      i = 0;
    }
    this.c = i;
    this.d = paramString;
    this.e = paramIState1;
    this.f = paramIState2;
    this.g = paramIState3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time=");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.b);
    localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
    localStringBuilder.append(" processed=");
    localObject = this.e;
    String str = "<null>";
    if (localObject == null) {
      localObject = "<null>";
    } else {
      localObject = ((IState)localObject).d();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" org=");
    localObject = this.f;
    if (localObject == null) {
      localObject = "<null>";
    } else {
      localObject = ((IState)localObject).d();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" dest=");
    localObject = this.g;
    if (localObject == null) {
      localObject = str;
    } else {
      localObject = ((IState)localObject).d();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" what=");
    localObject = this.a;
    if (localObject != null) {
      localObject = ((StateMachine)localObject).a(this.c);
    } else {
      localObject = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder.append(this.c);
      localStringBuilder.append("(0x");
      localStringBuilder.append(Integer.toHexString(this.c));
      localStringBuilder.append(")");
    }
    else
    {
      localStringBuilder.append((String)localObject);
    }
    if (!TextUtils.isEmpty(this.d))
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.d);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.LogRec
 * JD-Core Version:    0.7.0.1
 */