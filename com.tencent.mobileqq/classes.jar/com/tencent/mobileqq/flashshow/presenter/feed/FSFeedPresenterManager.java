package com.tencent.mobileqq.flashshow.presenter.feed;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSBaseFeedPresenterEvent;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class FSFeedPresenterManager
{
  protected final LinkedHashMap<String, FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>> a = new LinkedHashMap();
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(FSBaseFeedChildPresenter<FeedCloudMeta.StFeed> paramFSBaseFeedChildPresenter)
  {
    if (paramFSBaseFeedChildPresenter == null) {
      return;
    }
    if ((this.a.get(paramFSBaseFeedChildPresenter.getClass().getName()) != null) && (RFApplication.isDebug())) {
      throw new RuntimeException("you can not register Same Class Presenter");
    }
    this.a.put(paramFSBaseFeedChildPresenter.getClass().getName(), paramFSBaseFeedChildPresenter);
  }
  
  public void a(FSBaseFeedPresenterEvent paramFSBaseFeedPresenterEvent)
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (FSBaseFeedChildPresenter)this.a.get(localObject);
      if (localObject != null) {
        ((FSBaseFeedChildPresenter)localObject).a(paramFSBaseFeedPresenterEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedPresenterManager
 * JD-Core Version:    0.7.0.1
 */