package cooperation.qzone.report.lp;

class LpReportManager$ReportRunner
  implements Runnable
{
  LpReportInfo info;
  boolean isNeedSample;
  boolean isReportNow;
  int subtype;
  
  public LpReportManager$ReportRunner(LpReportManager paramLpReportManager, int paramInt, LpReportInfo paramLpReportInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.subtype = paramInt;
    this.info = paramLpReportInfo;
    this.isNeedSample = paramBoolean1;
    this.isReportNow = paramBoolean2;
  }
  
  public void run()
  {
    LpReportManager.access$000(this.this$0, this.subtype, this.info, this.isNeedSample, this.isReportNow);
    LpReportManager localLpReportManager = this.this$0;
    localLpReportManager.mRunningTaskNum -= 1;
    LpReportManager.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportManager.ReportRunner
 * JD-Core Version:    0.7.0.1
 */