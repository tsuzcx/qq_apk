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
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  @Nullable
  private ILog jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorILog;
  @Nullable
  private IThreadExecutor jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorIThreadExecutor;
  @Nullable
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList<BaseStep> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final LinkedList<BaseStep> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private void c()
  {
    if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      Object localObject2 = (BaseStep)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (((BaseStep)localObject2).a())
      {
        localObject1 = new Automator.4(this, (BaseStep)localObject2);
        if (((BaseStep)localObject2).c())
        {
          ((Runnable)localObject1).run();
          return;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorIThreadExecutor;
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
    Object localObject1 = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject1 != null) {
      ((Runnable)localObject1).run();
    }
  }
  
  @Nullable
  public final ILog a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorILog;
  }
  
  @Nullable
  public final IThreadExecutor a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorIThreadExecutor;
  }
  
  public final void a()
  {
    b(new Automator.3(this));
  }
  
  public final void a(@NotNull BaseStep paramBaseStep)
  {
    b(new Automator.6(this, paramBaseStep));
  }
  
  public final void a(@Nullable ILog paramILog)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorILog = paramILog;
  }
  
  public final void a(@Nullable IThreadExecutor paramIThreadExecutor)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseAutomatorIThreadExecutor = paramIThreadExecutor;
  }
  
  public final void a(@Nullable Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public final void a(@NotNull BaseStep[] paramArrayOfBaseStep, boolean paramBoolean)
  {
    b(new Automator.1(this, paramArrayOfBaseStep, paramBoolean));
  }
  
  public final void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((BaseStep)localIterator.next()).a();
    }
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
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.automator.Automator
 * JD-Core Version:    0.7.0.1
 */