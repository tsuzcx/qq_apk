package com.tencent.mobileqq.emosm.emosearch;

import java.io.Serializable;
import java.util.List;

public class EmotionSearchManager$EmotionSearchResult
  implements Serializable
{
  List<EmotionSearchItem> itemList;
  int nResult;
  EmotionSearchManager.EmotionSearchTask searchTask;
  
  public EmotionSearchManager$EmotionSearchResult(int paramInt)
  {
    this.nResult = paramInt;
  }
  
  public List<EmotionSearchItem> getItemList()
  {
    return this.itemList;
  }
  
  public int getResult()
  {
    return this.nResult;
  }
  
  public boolean isHasMore()
  {
    if (this.searchTask == null) {
      return false;
    }
    return this.searchTask.hasMore;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.EmotionSearchManager.EmotionSearchResult
 * JD-Core Version:    0.7.0.1
 */