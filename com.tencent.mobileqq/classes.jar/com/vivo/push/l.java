package com.vivo.push;

import android.content.Context;
import com.vivo.push.b.n;

public abstract class l
  implements Runnable
{
  protected Context a;
  private int b = -1;
  private o c;
  
  public l(o paramo)
  {
    this.c = paramo;
    this.b = paramo.b();
    if (this.b >= 0)
    {
      this.a = e.a().h();
      return;
    }
    throw new IllegalArgumentException("PushTask need a > 0 task id.");
  }
  
  public final int a()
  {
    return this.b;
  }
  
  protected abstract void a(o paramo);
  
  public final void run()
  {
    Context localContext = this.a;
    if ((localContext != null) && (!(this.c instanceof n)))
    {
      StringBuilder localStringBuilder = new StringBuilder("[执行指令]");
      localStringBuilder.append(this.c);
      com.vivo.push.util.o.a(localContext, localStringBuilder.toString());
    }
    a(this.c);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("{");
    Object localObject = this.c;
    if (localObject == null) {
      localObject = "[null]";
    } else {
      localObject = ((o)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.l
 * JD-Core Version:    0.7.0.1
 */