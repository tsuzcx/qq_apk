package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.util.Pair;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.ArrayList;
import java.util.Iterator;

class ReadinjoySPEventReport$ScreenFeedsInfo
{
  public ArrayList<Pair<AbsBaseArticleInfo, Float>> a = new ArrayList();
  public long b;
  public long c;
  
  private ReadinjoySPEventReport$ScreenFeedsInfo(ReadinjoySPEventReport paramReadinjoySPEventReport) {}
  
  public ArrayList<Long> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(((AbsBaseArticleInfo)((Pair)localIterator.next()).first).mArticleID));
    }
    return localArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("screenInfo : \n");
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      localStringBuilder.append("【");
      localStringBuilder.append(((AbsBaseArticleInfo)localPair.first).mTitle);
      localStringBuilder.append("】");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ScreenFeedsInfo
 * JD-Core Version:    0.7.0.1
 */