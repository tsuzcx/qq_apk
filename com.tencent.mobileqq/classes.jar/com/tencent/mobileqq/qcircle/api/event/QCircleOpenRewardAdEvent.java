package com.tencent.mobileqq.qcircle.api.event;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleOpenRewardAdEvent
 * JD-Core Version:    0.7.0.1
 */