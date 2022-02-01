package com.tencent.mobileqq.mini.entry;

public abstract class MiniAppExposureManager$BaseExposureReport
{
  private volatile boolean hasReport;
  
  public void handleReport()
  {
    if (hasReport()) {
      return;
    }
    report();
    setHasReport(true);
  }
  
  public boolean hasReport()
  {
    return this.hasReport;
  }
  
  public abstract void report();
  
  public void setHasReport(boolean paramBoolean)
  {
    this.hasReport = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
 * JD-Core Version:    0.7.0.1
 */