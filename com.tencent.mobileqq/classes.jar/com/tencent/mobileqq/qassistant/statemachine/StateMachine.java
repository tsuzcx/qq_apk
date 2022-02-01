package com.tencent.mobileqq.qassistant.statemachine;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class StateMachine
{
  private String a;
  private StateMachine.SmHandler b;
  private HandlerThread c;
  
  protected StateMachine(String paramString)
  {
    this.c = new HandlerThread(paramString);
    this.c.start();
    a(paramString, this.c.getLooper());
  }
  
  private void a(String paramString, Looper paramLooper)
  {
    this.a = paramString;
    this.b = new StateMachine.SmHandler(paramLooper, this, null);
  }
  
  public final Message a(int paramInt, Object paramObject)
  {
    return Message.obtain(this.b, paramInt, paramObject);
  }
  
  protected final IState a()
  {
    StateMachine.SmHandler localSmHandler = this.b;
    if (localSmHandler == null) {
      return null;
    }
    return StateMachine.SmHandler.b(localSmHandler);
  }
  
  protected String a(int paramInt)
  {
    return null;
  }
  
  protected final void a(Message paramMessage)
  {
    StateMachine.SmHandler.a(this.b, paramMessage);
  }
  
  protected final void a(IState paramIState)
  {
    StateMachine.SmHandler.a(this.b, paramIState);
  }
  
  protected final void a(State paramState)
  {
    StateMachine.SmHandler.a(this.b, paramState, null);
  }
  
  protected void a(String paramString)
  {
    Log.d(this.a, paramString);
  }
  
  public final Message b(int paramInt)
  {
    return Message.obtain(this.b, paramInt);
  }
  
  protected void b() {}
  
  public final void b(int paramInt, Object paramObject)
  {
    StateMachine.SmHandler localSmHandler = this.b;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(a(paramInt, paramObject));
  }
  
  protected void b(Message paramMessage)
  {
    if (StateMachine.SmHandler.c(this.b))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" - unhandledMessage: msg.what=");
      localStringBuilder.append(paramMessage.what);
      b(localStringBuilder.toString());
    }
  }
  
  protected final void b(State paramState)
  {
    StateMachine.SmHandler.a(this.b, paramState);
  }
  
  protected void b(String paramString)
  {
    Log.e(this.a, paramString);
  }
  
  protected void c() {}
  
  public final void c(int paramInt)
  {
    StateMachine.SmHandler localSmHandler = this.b;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(b(paramInt));
  }
  
  protected void c(Message paramMessage) {}
  
  protected final void d()
  {
    StateMachine.SmHandler localSmHandler = this.b;
    if (localSmHandler == null) {
      return;
    }
    StateMachine.SmHandler.d(localSmHandler);
  }
  
  protected boolean d(Message paramMessage)
  {
    return true;
  }
  
  protected String e(Message paramMessage)
  {
    return "";
  }
  
  public void e()
  {
    StateMachine.SmHandler localSmHandler = this.b;
    if (localSmHandler == null) {
      return;
    }
    StateMachine.SmHandler.e(localSmHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine
 * JD-Core Version:    0.7.0.1
 */