package cooperation.qzone.report;

class QzoneReportManager$ProcessRunner
  implements Runnable
{
  String mData;
  int mType;
  
  public QzoneReportManager$ProcessRunner(QzoneReportManager paramQzoneReportManager, int paramInt, String paramString)
  {
    this.mType = paramInt;
    this.mData = paramString;
  }
  
  public void run()
  {
    QzoneReportManager localQzoneReportManager = this.this$0;
    localQzoneReportManager.mRunningTaskNum -= 1;
    QzoneReportManager.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.QzoneReportManager.ProcessRunner
 * JD-Core Version:    0.7.0.1
 */