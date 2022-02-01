package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

public class Core
  implements Runnable
{
  public Core(Cranberry paramCranberry, Context paramContext, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Cranberry localCranberry = this.d;
    ??? = this.a;
    boolean bool2 = this.b;
    int j = this.c;
    localCranberry.g.getClass();
    Object localObject3 = Date.b((Context)???, "403");
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        bool1 = Boolean.valueOf((String)localObject3).booleanValue();
      }
    }
    finally
    {
      boolean bool1;
      label65:
      int i;
      StringBuilder localStringBuilder;
      break label65;
    }
    bool1 = true;
    i = 0;
    while (i < localCranberry.d.s)
    {
      localObject3 = localCranberry.a((Context)???, bool2, bool1, j);
      localCranberry.a((Chestnut)localObject3, true);
      int k = ((Chestnut)localObject3).d;
      if ((k == 0) || (k == -30014)) {
        break;
      }
      i += 1;
    }
    if (bool1)
    {
      localObject3 = localCranberry.g;
      localObject3.getClass();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(false);
      ((Date)localObject3).a((Context)???, "403", localStringBuilder.toString(), true);
    }
    synchronized (localCranberry.j)
    {
      localCranberry.j.set(Boolean.FALSE);
      localCranberry.j.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Core
 * JD-Core Version:    0.7.0.1
 */