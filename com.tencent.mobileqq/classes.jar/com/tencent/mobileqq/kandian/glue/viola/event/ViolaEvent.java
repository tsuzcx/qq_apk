package com.tencent.mobileqq.kandian.glue.viola.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import org.json.JSONObject;

public class ViolaEvent
  extends SimpleBaseEvent
{
  public JSONObject data;
  public String eventName;
  
  public ViolaEvent(String paramString, JSONObject paramJSONObject)
  {
    this.eventName = paramString;
    this.data = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent
 * JD-Core Version:    0.7.0.1
 */