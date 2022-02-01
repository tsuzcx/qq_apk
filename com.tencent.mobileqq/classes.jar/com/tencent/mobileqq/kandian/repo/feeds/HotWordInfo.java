package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordItem;

public class HotWordInfo
{
  public List<HotWordItem> a;
  
  public static HotWordInfo a(articlesummary.HotWordInfo paramHotWordInfo)
  {
    HotWordInfo localHotWordInfo = new HotWordInfo();
    if ((paramHotWordInfo != null) && (paramHotWordInfo.rpt_hot_word_item.has()))
    {
      localHotWordInfo.a = new ArrayList(paramHotWordInfo.rpt_hot_word_item.size());
      paramHotWordInfo = paramHotWordInfo.rpt_hot_word_item.get().iterator();
      while (paramHotWordInfo.hasNext())
      {
        HotWordItem localHotWordItem = HotWordItem.a((articlesummary.HotWordItem)paramHotWordInfo.next());
        localHotWordInfo.a.add(localHotWordItem);
      }
    }
    return localHotWordInfo;
  }
  
  public byte[] a()
  {
    articlesummary.HotWordInfo localHotWordInfo = new articlesummary.HotWordInfo();
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((HotWordItem)localIterator.next()).a());
      }
      localHotWordInfo.rpt_hot_word_item.set((List)localObject);
    }
    return localHotWordInfo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo
 * JD-Core Version:    0.7.0.1
 */