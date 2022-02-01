package com.tencent.mobileqq.hotchat.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONArray;

@QAPI(process={"all"})
public abstract interface IHotChatPostListAdapter
  extends QRouteApi
{
  public abstract void destroy();
  
  public abstract int getCount();
  
  public abstract int getLastPullUpEndIndex();
  
  public abstract boolean isLastPullUpEnded();
  
  public abstract void joinListItemsAndNotify(JSONArray paramJSONArray);
  
  public abstract void setListItemsAndNotify(JSONArray paramJSONArray);
  
  public abstract void setPullUpEnded();
  
  public abstract void setPullUpStarted();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.api.IHotChatPostListAdapter
 * JD-Core Version:    0.7.0.1
 */