package com.tencent.qplus.swingworker;

public abstract interface SchedulingRule
{
  public abstract boolean isConflicting(SchedulingRule paramSchedulingRule);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.SchedulingRule
 * JD-Core Version:    0.7.0.1
 */