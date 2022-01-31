package cooperation.dingdong;

import java.io.Serializable;

public class DingdongPluginDataFactory$ScheduleSummaryData
  implements Serializable
{
  public static final int TYPE_TIM = 0;
  public static final int TYPE_TROOP_NOTICE = 1;
  public String authorUin;
  public long beginTime;
  public long endTime;
  public boolean hasAlarm;
  public String id;
  public String location;
  public String mark;
  public int offsetTime;
  public long sourceId;
  public int specialFlag;
  public String title;
  public int type = 0;
  public String url;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData
 * JD-Core Version:    0.7.0.1
 */