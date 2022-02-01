package com.tencent.qzonehub.api.contentbox;

import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

public abstract interface IMQMsg
  extends Serializable
{
  public abstract JSONObject convertToJson();
  
  public abstract List getFeeds();
  
  public abstract long getPushTime();
  
  public abstract int isNewStyle();
  
  public abstract boolean isNewStyleCard();
  
  public abstract boolean isRecommGuideCard();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.contentbox.IMQMsg
 * JD-Core Version:    0.7.0.1
 */