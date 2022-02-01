package com.tencent.mobileqq.mini.entry.search.comm;

import NS_STORE_APP_SEARCH.MiniAppSearch.StHotWatching;
import com.tencent.mobileqq.pb.PBStringField;

public class LiveInfo
  implements ItemInfo
{
  public String mHotWords;
  public String mJumpUrl;
  private int position;
  
  public LiveInfo(MiniAppSearch.StHotWatching paramStHotWatching)
  {
    this.mHotWords = paramStHotWatching.hotWords.get();
    this.mJumpUrl = paramStHotWatching.url.get();
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getType()
  {
    return 3;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.comm.LiveInfo
 * JD-Core Version:    0.7.0.1
 */