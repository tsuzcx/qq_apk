package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ActionInfo;

public class MobileReportManager$ActionInfoBuilder
{
  private int actionId;
  private long actionValue;
  private long operTime;
  
  public MobileReportManager$ActionInfoBuilder(long paramLong, int paramInt)
  {
    this.operTime = paramLong;
    this.actionId = paramInt;
  }
  
  public MobileReportManager$ActionInfoBuilder(long paramLong1, int paramInt, long paramLong2)
  {
    this.operTime = paramLong1;
    this.actionId = paramInt;
    this.actionValue = paramLong2;
  }
  
  public ActionInfo build()
  {
    ActionInfo localActionInfo = new ActionInfo();
    localActionInfo.oper_time = this.operTime;
    localActionInfo.action_id = this.actionId;
    localActionInfo.action_value = this.actionValue;
    return localActionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager.ActionInfoBuilder
 * JD-Core Version:    0.7.0.1
 */