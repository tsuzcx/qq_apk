package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import org.json.JSONObject;

public class QCircleOpenRewardAdEvent
  extends SimpleBaseEvent
{
  public JSONObject mParams;
  
  public QCircleOpenRewardAdEvent(JSONObject paramJSONObject)
  {
    this.mParams = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleOpenRewardAdEvent
 * JD-Core Version:    0.7.0.1
 */