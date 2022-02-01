package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import NS_USER_ACTION_REPORT.PageInfo;
import NS_USER_ACTION_REPORT.TraceInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import java.util.ArrayList;

class MobileReportManager$UserActionReportBuilder
{
  private ArrayList<ItemInfo> itemInfos = new ArrayList();
  private MobileReportManager.ReportKey reportKey;
  
  public UserActionReportBuilder addItemInfo(ItemInfo paramItemInfo)
  {
    this.itemInfos.add(paramItemInfo);
    return this;
  }
  
  public UserActionReport build()
  {
    UserActionReport localUserActionReport = new UserActionReport();
    Object localObject = new PageInfo();
    ((PageInfo)localObject).appid = this.reportKey.pageAppId;
    ((PageInfo)localObject).page_id = this.reportKey.pageId;
    ((PageInfo)localObject).item_infos = this.itemInfos;
    localUserActionReport.page_info = ((PageInfo)localObject);
    localObject = new TraceInfo();
    ((TraceInfo)localObject).trace_id = this.reportKey.traceId;
    ((TraceInfo)localObject).trace_num = this.reportKey.traceNum;
    ((TraceInfo)localObject).trace_detail = this.reportKey.buildTraceDetail();
    localUserActionReport.trace_info = ((TraceInfo)localObject);
    return localUserActionReport;
  }
  
  public UserActionReportBuilder setReportKey(MobileReportManager.ReportKey paramReportKey)
  {
    this.reportKey = paramReportKey;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager.UserActionReportBuilder
 * JD-Core Version:    0.7.0.1
 */