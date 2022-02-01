package com.tencent.mobileqq.kandian.biz.comment.emotion;

import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import java.util.ArrayList;
import java.util.List;

public class RIJEmotionListProvider
  implements EmoticonListProvider
{
  public List<EmotionPanelInfo> getEmotionPanelInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new EmotionPanelInfo(7, 7, null));
    RIJEmotionCacheManager.a(localArrayList);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.RIJEmotionListProvider
 * JD-Core Version:    0.7.0.1
 */