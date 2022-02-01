package com.tencent.ttpic.openapi.model;

public class TriggerActionItem
{
  public String id;
  public long mActionDelay;
  public TriggerExpression mTriggerExpression;
  
  public TriggerActionItem() {}
  
  public TriggerActionItem(long paramLong)
  {
    this.mTriggerExpression = new TriggerExpression(1);
    this.mActionDelay = paramLong;
  }
  
  public TriggerActionItem(TriggerExpression paramTriggerExpression, long paramLong)
  {
    this.mTriggerExpression = paramTriggerExpression;
    this.mActionDelay = paramLong;
  }
  
  public int getTriggerType()
  {
    TriggerExpression localTriggerExpression = this.mTriggerExpression;
    if (localTriggerExpression != null) {
      return localTriggerExpression.mTriggerType;
    }
    return -1;
  }
  
  public boolean isTriggered()
  {
    TriggerExpression localTriggerExpression = this.mTriggerExpression;
    if (localTriggerExpression != null) {
      return localTriggerExpression.isTriggered();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TriggerActionItem
 * JD-Core Version:    0.7.0.1
 */