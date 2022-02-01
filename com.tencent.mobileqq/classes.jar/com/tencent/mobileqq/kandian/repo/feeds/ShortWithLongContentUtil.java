package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.longcontentinfoupdater.LongContentInfoUpdater;

public class ShortWithLongContentUtil
{
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    LongContentInfoUpdater localLongContentInfoUpdater = LongContentInfoUpdater.b(paramAbsBaseArticleInfo);
    if (localLongContentInfoUpdater == null) {
      return;
    }
    localLongContentInfoUpdater.a(paramAbsBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ShortWithLongContentUtil
 * JD-Core Version:    0.7.0.1
 */