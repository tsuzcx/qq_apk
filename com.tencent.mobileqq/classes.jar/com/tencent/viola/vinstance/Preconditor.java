package com.tencent.viola.vinstance;

import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Preconditor
{
  private static final String TAG = "Preconditor";
  private PreconditionAdapter adapter;
  private CountDownLatch countDownLatch;
  private List<Precondition> failPreconditions;
  private Preconditor.PreconditionListener preconditionListener;
  private List<Precondition> preconditions = new ArrayList();
  private String serviceJsCode;
  
  public Preconditor(List<Precondition> paramList, PreconditionAdapter paramPreconditionAdapter)
  {
    if (paramList != null) {
      this.preconditions.addAll(paramList);
    }
    this.preconditions.add(new ServiceJsPrecondition(paramPreconditionAdapter, this));
    this.preconditions.add(new SdkInitPrecondition(paramPreconditionAdapter, this));
    this.countDownLatch = new CountDownLatch(this.preconditions.size());
    this.adapter = paramPreconditionAdapter;
  }
  
  private void addFailPrecondition(Precondition paramPrecondition)
  {
    if (this.failPreconditions == null) {
      this.failPreconditions = new ArrayList();
    }
    this.failPreconditions.add(paramPrecondition);
  }
  
  private void clearFailPrecondition()
  {
    List localList = this.failPreconditions;
    if (localList == null) {
      return;
    }
    localList.clear();
  }
  
  private List<Precondition> getPreconditions(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.failPreconditions;
    }
    return this.preconditions;
  }
  
  private List<Precondition> processInternal(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(getPreconditions(paramBoolean));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((Precondition)localIterator.next()).onProcess();
    }
    if (!paramBoolean)
    {
      this.countDownLatch.await();
      return localArrayList;
    }
    clearFailPrecondition();
    this.countDownLatch = new CountDownLatch(localArrayList.size());
    this.countDownLatch.await();
    return localArrayList;
  }
  
  void countDown()
  {
    this.countDownLatch.countDown();
  }
  
  public PreconditionAdapter getAdapter()
  {
    return this.adapter;
  }
  
  public String getServiceJsCode()
  {
    return this.serviceJsCode;
  }
  
  public void process(boolean paramBoolean)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("precondition, isRetry: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ViolaLogUtils.d("Preconditor", ((StringBuilder)localObject).toString());
      localObject = processInternal(paramBoolean);
      if (localObject == null) {
        return;
      }
      paramBoolean = true;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Precondition localPrecondition = (Precondition)((Iterator)localObject).next();
        if (!localPrecondition.isSuccess())
        {
          addFailPrecondition(localPrecondition);
          paramBoolean = false;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("precondition error: ");
          localStringBuilder.append(localPrecondition.getClass().getSimpleName());
          ViolaLogUtils.e("Preconditor", localStringBuilder.toString());
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("precondition, isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ViolaLogUtils.d("Preconditor", ((StringBuilder)localObject).toString());
      if (this.preconditionListener != null)
      {
        if (paramBoolean)
        {
          this.preconditionListener.onSuccess();
          return;
        }
        this.preconditionListener.onError();
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public void setPreconditionListener(Preconditor.PreconditionListener paramPreconditionListener)
  {
    this.preconditionListener = paramPreconditionListener;
  }
  
  public void setServiceJsCode(String paramString)
  {
    this.serviceJsCode = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.vinstance.Preconditor
 * JD-Core Version:    0.7.0.1
 */