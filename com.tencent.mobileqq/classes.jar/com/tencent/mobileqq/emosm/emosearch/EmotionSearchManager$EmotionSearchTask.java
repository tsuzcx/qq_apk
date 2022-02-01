package com.tencent.mobileqq.emosm.emosearch;

import com.tencent.mobileqq.utils.StringUtil;
import java.io.Serializable;

public class EmotionSearchManager$EmotionSearchTask
  implements Serializable
{
  public static final int EMOTION_SEARCH_TASK_TYPE_HOT_PIC = 0;
  public static final int EMOTION_SEARCH_TASK_TYPE_SEARCH = 1;
  int buildver = 0;
  boolean hasMore = true;
  String searchKeyWords;
  int startIndex;
  int taskType;
  
  public EmotionSearchManager$EmotionSearchTask(int paramInt)
  {
    this(paramInt, null);
  }
  
  public EmotionSearchManager$EmotionSearchTask(int paramInt, String paramString)
  {
    this.taskType = paramInt;
    this.searchKeyWords = paramString;
  }
  
  public boolean checkIsThisTask(int paramInt, String paramString)
  {
    if (paramInt == this.taskType)
    {
      paramInt = 1;
      if (!StringUtil.a(this.searchKeyWords)) {
        break label40;
      }
    }
    label40:
    for (boolean bool = StringUtil.a(paramString);; bool = this.searchKeyWords.equalsIgnoreCase(paramString))
    {
      if ((paramInt == 0) || (!bool)) {
        break label52;
      }
      return true;
      paramInt = 0;
      break;
    }
    label52:
    return false;
  }
  
  public boolean isSame(EmotionSearchTask paramEmotionSearchTask)
  {
    if (paramEmotionSearchTask == null) {
      return false;
    }
    return checkIsThisTask(paramEmotionSearchTask.taskType, paramEmotionSearchTask.searchKeyWords);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.emosearch.EmotionSearchManager.EmotionSearchTask
 * JD-Core Version:    0.7.0.1
 */