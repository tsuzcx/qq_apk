package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.feeds.api.IRIJSubscriptionFeeds;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionFeed
{
  public int a = -1;
  public int b = 0;
  public String c = "";
  public long d = 0L;
  public List<SubscriptionFeedItem> e = new ArrayList();
  public WeakReference<MessageRecord> f = null;
  
  public void a()
  {
    if (((IRIJSubscriptionFeeds)QRoute.api(IRIJSubscriptionFeeds.class)).clearUnreadMsg(this.c)) {
      this.b = 0;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (SubscriptionFeed)paramObject;
      String str = this.c;
      if (str != null) {
        return str.equals(paramObject.c);
      }
      return paramObject.c == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.c;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed
 * JD-Core Version:    0.7.0.1
 */