package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import cooperation.qzone.LbsDataV2.PoiList;

public class QcircleLbsEvent
  extends SimpleBaseEvent
{
  public LbsDataV2.PoiList mPoiList;
  
  public QcircleLbsEvent(LbsDataV2.PoiList paramPoiList)
  {
    this.mPoiList = paramPoiList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QcircleLbsEvent
 * JD-Core Version:    0.7.0.1
 */