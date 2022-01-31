package cooperation.qzone.report.lp;

class LpReportManager$ReportRunner
  implements Runnable
{
  int jdField_a_of_type_Int;
  LpReportInfo jdField_a_of_type_CooperationQzoneReportLpLpReportInfo;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  public LpReportManager$ReportRunner(LpReportManager paramLpReportManager, int paramInt, LpReportInfo paramLpReportInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo = paramLpReportInfo;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void run()
  {
    LpReportManager.access$000(this.this$0, this.jdField_a_of_type_Int, this.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo, this.jdField_a_of_type_Boolean, this.b);
    LpReportManager localLpReportManager = this.this$0;
    localLpReportManager.mRunningTaskNum -= 1;
    LpReportManager.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportManager.ReportRunner
 * JD-Core Version:    0.7.0.1
 */