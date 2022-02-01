package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.utils.StringUtil;
import java.io.Serializable;

public class IEmotionSearchManagerService$EmotionSearchTask
  implements Serializable
{
  public static final int EMOTION_SEARCH_TASK_TYPE_HOT_PIC = 0;
  public static final int EMOTION_SEARCH_TASK_TYPE_SEARCH = 1;
  public int buildver = 0;
  public boolean hasMore = true;
  public String searchKeyWords;
  public int startIndex;
  public int taskType;
  
  public IEmotionSearchManagerService$EmotionSearchTask(int paramInt)
  {
    this(paramInt, null);
  }
  
  public IEmotionSearchManagerService$EmotionSearchTask(int paramInt, String paramString)
  {
    this.taskType = paramInt;
    this.searchKeyWords = paramString;
  }
  
  public boolean checkIsThisTask(int paramInt, String paramString)
  {
    if (paramInt == this.taskType) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    boolean bool;
    if (StringUtil.isEmpty(this.searchKeyWords)) {
      bool = StringUtil.isEmpty(paramString);
    } else {
      bool = this.searchKeyWords.equalsIgnoreCase(paramString);
    }
    return (paramInt != 0) && (bool);
  }
  
  public boolean isSame(EmotionSearchTask paramEmotionSearchTask)
  {
    if (paramEmotionSearchTask == null) {
      return false;
    }
    return checkIsThisTask(paramEmotionSearchTask.taskType, paramEmotionSearchTask.searchKeyWords);
  }
  
  public void setHasMore(boolean paramBoolean)
  {
    this.hasMore = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.EmotionSearchTask
 * JD-Core Version:    0.7.0.1
 */