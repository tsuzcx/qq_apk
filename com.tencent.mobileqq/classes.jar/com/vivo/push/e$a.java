package com.vivo.push;

import com.vivo.push.b.c;
import com.vivo.push.util.o;

public final class e$a
{
  private IPushActionListener a;
  private c b;
  private IPushActionListener c;
  private Runnable d;
  private Object[] e;
  
  public e$a(c paramc, IPushActionListener paramIPushActionListener)
  {
    this.b = paramc;
    this.a = paramIPushActionListener;
  }
  
  public final void a()
  {
    Runnable localRunnable = this.d;
    if (localRunnable == null)
    {
      o.a("PushClientManager", "task is null");
      return;
    }
    localRunnable.run();
  }
  
  public final void a(int paramInt, Object... paramVarArgs)
  {
    this.e = paramVarArgs;
    paramVarArgs = this.c;
    if (paramVarArgs != null) {
      paramVarArgs.onStateChanged(paramInt);
    }
    paramVarArgs = this.a;
    if (paramVarArgs != null) {
      paramVarArgs.onStateChanged(paramInt);
    }
  }
  
  public final void a(IPushActionListener paramIPushActionListener)
  {
    this.c = paramIPushActionListener;
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.d = paramRunnable;
  }
  
  public final Object[] b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.e.a
 * JD-Core Version:    0.7.0.1
 */