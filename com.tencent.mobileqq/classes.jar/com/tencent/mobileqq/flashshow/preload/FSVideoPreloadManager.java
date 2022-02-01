package com.tencent.mobileqq.flashshow.preload;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FSVideoPreloadManager
{
  private static String a = "FSVideoPreloadManager";
  private static volatile FSVideoPreloadManager b;
  private ConcurrentHashMap<String, String> c = new ConcurrentHashMap();
  private FSVideoPreloadHelper d = new FSVideoPreloadHelper(RFApplication.getApplication().hashCode());
  
  public static FSVideoPreloadManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new FSVideoPreloadManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void b(List<FSFeedData> paramList)
  {
    try
    {
      paramList = paramList.iterator();
      Object localObject1;
      Object localObject2;
      while (paramList.hasNext())
      {
        localObject1 = ((FSFeedData)paramList.next()).b();
        if (this.c.containsKey(((FeedCloudMeta.StFeed)localObject1).id.get())) {
          return;
        }
        localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start preload feed content:");
        localStringBuilder.append(((FeedCloudMeta.StFeed)localObject1).content.get());
        QLog.d((String)localObject2, 1, localStringBuilder.toString());
        this.d.a((FeedCloudMeta.StFeed)localObject1);
        this.c.put(((FeedCloudMeta.StFeed)localObject1).id.get(), ((FeedCloudMeta.StFeed)localObject1).id.get());
      }
      return;
    }
    catch (Exception paramList)
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start preload ex:");
      ((StringBuilder)localObject2).append(paramList.getMessage());
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(List<FSFeedData> paramList)
  {
    FSThreadUtils.d(new FSVideoPreloadManager.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.preload.FSVideoPreloadManager
 * JD-Core Version:    0.7.0.1
 */