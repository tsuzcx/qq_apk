package com.tencent.mobileqq.kandian.base.automator;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Automator
{
  private ArrayList<BaseStep> a = new ArrayList();
  private final LinkedList<BaseStep> b = new LinkedList();
  private final Handler c = new Handler(Looper.getMainLooper());
  @Nullable
  private ILog d;
  @Nullable
  private IThreadExecutor e;
  @Nullable
  private Runnable f;
  
  private void e()
  {
    if (!this.b.isEmpty())
    {
      Object localObject2 = (BaseStep)this.b.removeFirst();
      if (((BaseStep)localObject2).a())
      {
        localObject1 = new Automator.4(this, (BaseStep)localObject2);
        if (((BaseStep)localObject2).i())
        {
          ((Runnable)localObject1).run();
          return;
        }
        localObject2 = this.e;
        if (localObject2 != null)
        {
          ((IThreadExecutor)localObject2).a((Runnable)localObject1);
          return;
        }
        new Thread((Runnable)localObject1).start();
        return;
      }
      b(new Automator.5(this, (BaseStep)localObject2));
      return;
    }
    Object localObject1 = this.f;
    if (localObject1 != null) {
      ((Runnable)localObject1).run();
    }
  }
  
  @Nullable
  public final ILog a()
  {
    return this.d;
  }
  
  public final void a(@NotNull BaseStep paramBaseStep)
  {
    b(new Automator.6(this, paramBaseStep));
  }
  
  public final void a(@Nullable ILog paramILog)
  {
    this.d = paramILog;
  }
  
  public final void a(@Nullable IThreadExecutor paramIThreadExecutor)
  {
    this.e = paramIThreadExecutor;
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    this.f = paramRunnable;
  }
  
  public final void a(@NotNull BaseStep[] paramArrayOfBaseStep, boolean paramBoolean)
  {
    b(new Automator.1(this, paramArrayOfBaseStep, paramBoolean));
  }
  
  @Nullable
  public final IThreadExecutor b()
  {
    return this.e;
  }
  
  public void b(@NotNull Runnable paramRunnable)
  {
    int i;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramRunnable.run();
      return;
    }
    this.c.post(paramRunnable);
  }
  
  public final void c()
  {
    b(new Automator.3(this));
  }
  
  public final void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BaseStep)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.Automator
 * JD-Core Version:    0.7.0.1
 */