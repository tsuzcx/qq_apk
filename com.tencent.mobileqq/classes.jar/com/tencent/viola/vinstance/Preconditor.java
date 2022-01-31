package com.tencent.viola.vinstance;

import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Preconditor
{
  private static final String TAG = "Preconditor";
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
    if (this.failPreconditions == null) {
      return;
    }
    this.failPreconditions.clear();
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
  
  public String getServiceJsCode()
  {
    return this.serviceJsCode;
  }
  
  public void process(boolean paramBoolean)
  {
    label170:
    label171:
    for (;;)
    {
      try
      {
        ViolaLogUtils.d("Preconditor", "precondition, isRetry: " + paramBoolean);
        Object localObject = processInternal(paramBoolean);
        if (localObject == null) {
          return;
        }
        paramBoolean = true;
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          Precondition localPrecondition = (Precondition)((Iterator)localObject).next();
          if (localPrecondition.isSuccess()) {
            break label171;
          }
          addFailPrecondition(localPrecondition);
          paramBoolean = false;
          ViolaLogUtils.e("Preconditor", "precondition error: " + localPrecondition.getClass().getSimpleName());
          break label171;
        }
        ViolaLogUtils.d("Preconditor", "precondition, isSuccess: " + paramBoolean);
        if (this.preconditionListener == null) {
          break label170;
        }
        if (paramBoolean)
        {
          this.preconditionListener.onSuccess();
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        return;
      }
      this.preconditionListener.onError();
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.vinstance.Preconditor
 * JD-Core Version:    0.7.0.1
 */