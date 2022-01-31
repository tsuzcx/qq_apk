package com.tencent.mobileqq.vas;

public abstract class VasQuickUpdateEngine$PendingTask
{
  public long bid;
  public String from;
  public String scid;
  
  public boolean equals(PendingTask paramPendingTask)
  {
    return (this.bid == paramPendingTask.bid) && (this.scid.equals(paramPendingTask.scid));
  }
  
  public abstract void run(VasQuickUpdateEngine paramVasQuickUpdateEngine);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine.PendingTask
 * JD-Core Version:    0.7.0.1
 */