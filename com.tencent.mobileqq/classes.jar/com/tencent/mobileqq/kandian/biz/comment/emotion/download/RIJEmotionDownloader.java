package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.IRIJEmotionCache;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJCommonEmotionCache;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJCommonEmotionInfo;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.emotionsize.IRIJEmotionSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class RIJEmotionDownloader
{
  private int a;
  
  private static IRIJEmotionSize a(int paramInt)
  {
    return IRIJEmotionSize.a;
  }
  
  static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(paramString1);
    localStringBuilder.append('_');
    localStringBuilder.append(paramString2);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    ThreadManager.getUIHandler().post(new RIJEmotionDownloader.1());
  }
  
  private static boolean b(long paramLong)
  {
    return System.currentTimeMillis() - paramLong > 0L;
  }
  
  private void c()
  {
    if (!RIJEmotionCacheManager.d())
    {
      new RIJEmotionDownloader.EmotionFileLoader(this, null).a();
      return;
    }
    if (b(RIJEmotionCacheManager.a)) {
      new RIJEmotionDownloader.EmotionNetLoader(this, null).a();
    }
  }
  
  void a(RIJEmotionDownloader.ServerEmotionHolder paramServerEmotionHolder)
  {
    b();
    RIJEmotionCacheManager.a = paramServerEmotionHolder.updateTime;
    paramServerEmotionHolder = paramServerEmotionHolder.serverEmotionTabs.iterator();
    while (paramServerEmotionHolder.hasNext())
    {
      Object localObject = (RIJEmotionDownloader.ServerEmotionTab)paramServerEmotionHolder.next();
      ArrayList localArrayList = new ArrayList();
      IRIJEmotionSize localIRIJEmotionSize = a(((RIJEmotionDownloader.ServerEmotionTab)localObject).size);
      int i = this.a;
      this.a = (i + 1);
      Iterator localIterator = ((RIJEmotionDownloader.ServerEmotionTab)localObject).serverEmotions.iterator();
      while (localIterator.hasNext())
      {
        RIJEmotionDownloader.ServerEmotion localServerEmotion = (RIJEmotionDownloader.ServerEmotion)localIterator.next();
        localArrayList.add(new RIJCommonEmotionInfo(localServerEmotion.id, localServerEmotion.emotionUrl, a(((RIJEmotionDownloader.ServerEmotionTab)localObject).name, localServerEmotion.name), i, localIRIJEmotionSize.h()));
      }
      localObject = new RIJCommonEmotionCache(((RIJEmotionDownloader.ServerEmotionTab)localObject).id, ((RIJEmotionDownloader.ServerEmotionTab)localObject).iconUrl, i, localIRIJEmotionSize);
      ((RIJCommonEmotionCache)localObject).a(localArrayList);
      ((RIJCommonEmotionCache)localObject).d();
      RIJEmotionCacheManager.a((IRIJEmotionCache)localObject);
    }
  }
  
  void b()
  {
    this.a = 1000;
    RIJEmotionCacheManager.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader
 * JD-Core Version:    0.7.0.1
 */