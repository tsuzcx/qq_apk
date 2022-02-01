package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;

class MobileReportManager$1
  implements Runnable
{
  MobileReportManager$1(MobileReportManager paramMobileReportManager, ReportKey paramReportKey, ItemInfo paramItemInfo) {}
  
  public void run()
  {
    MobileReportManager.access$100(this.this$0).reportByKey(this.val$reportKey, this.val$item);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager.1
 * JD-Core Version:    0.7.0.1
 */