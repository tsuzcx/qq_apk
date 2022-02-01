package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import java.io.Serializable;
import java.util.List;

public class IEmotionSearchManagerService$EmotionSearchResult
  implements Serializable
{
  public List<EmotionSearchItem> itemList;
  public int nResult;
  public IEmotionSearchManagerService.EmotionSearchTask searchTask;
  
  public IEmotionSearchManagerService$EmotionSearchResult(int paramInt)
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
    IEmotionSearchManagerService.EmotionSearchTask localEmotionSearchTask = this.searchTask;
    if (localEmotionSearchTask == null) {
      return false;
    }
    return localEmotionSearchTask.hasMore;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.EmotionSearchResult
 * JD-Core Version:    0.7.0.1
 */