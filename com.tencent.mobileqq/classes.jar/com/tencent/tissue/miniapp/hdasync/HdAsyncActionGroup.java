package com.tencent.tissue.miniapp.hdasync;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class HdAsyncActionGroup
{
  private AtomicInteger actionCount = new AtomicInteger(0);
  private LinkedList<HdAsyncActionGroup.ActionArray> actionList = new LinkedList();
  
  public boolean allActionFinish()
  {
    boolean bool = false;
    if (this.actionCount.get() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  protected void append(HdAsyncActionGroup paramHdAsyncActionGroup)
  {
    if (paramHdAsyncActionGroup != null)
    {
      this.actionCount.addAndGet(paramHdAsyncActionGroup.actionCount.get());
      this.actionList.addAll(paramHdAsyncActionGroup.actionList);
    }
  }
  
  protected void both(HdAsyncAction... paramVarArgs)
  {
    HdAsyncActionGroup.ActionArray localActionArray = new HdAsyncActionGroup.ActionArray(this);
    localActionArray.array = paramVarArgs;
    this.actionCount.addAndGet(paramVarArgs.length);
    this.actionList.add(localActionArray);
  }
  
  protected void both(HdAsyncCountDownAction... paramVarArgs)
  {
    HdAsyncActionGroup.ActionArray localActionArray = new HdAsyncActionGroup.ActionArray(this);
    localActionArray.array = paramVarArgs;
    this.actionCount.addAndGet(paramVarArgs.length);
    this.actionList.add(localActionArray);
  }
  
  public void clear()
  {
    if (this.actionList != null) {
      this.actionList.clear();
    }
  }
  
  protected void delay(HdAsyncAction paramHdAsyncAction, long paramLong)
  {
    this.actionCount.incrementAndGet();
    paramHdAsyncAction.delay = paramLong;
    HdAsyncActionGroup.ActionArray localActionArray = new HdAsyncActionGroup.ActionArray(this);
    localActionArray.array = new HdAsyncAction[1];
    localActionArray.array[0] = paramHdAsyncAction;
    this.actionList.add(localActionArray);
  }
  
  public void finishOneAction()
  {
    this.actionCount.decrementAndGet();
  }
  
  public HdAsyncActionGroup.ActionArray poll()
  {
    if (!this.actionList.isEmpty()) {
      return (HdAsyncActionGroup.ActionArray)this.actionList.poll();
    }
    return null;
  }
  
  protected void then(HdAsyncAction paramHdAsyncAction)
  {
    this.actionCount.incrementAndGet();
    HdAsyncActionGroup.ActionArray localActionArray = new HdAsyncActionGroup.ActionArray(this);
    localActionArray.array = new HdAsyncAction[1];
    localActionArray.array[0] = paramHdAsyncAction;
    this.actionList.add(localActionArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.hdasync.HdAsyncActionGroup
 * JD-Core Version:    0.7.0.1
 */