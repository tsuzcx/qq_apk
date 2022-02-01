package com.tencent.mobileqq.flashshow.presenter.feed;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.mobileqq.flashshow.events.FSSeekEvent;
import com.tencent.mobileqq.flashshow.ioc.IFSFeedIoc;
import com.tencent.mobileqq.flashshow.manager.IFSLayerScrollerStatus;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSBaseFeedPresenterEvent;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;

public abstract class FSBaseFeedChildPresenter<T>
  implements SimpleEventReceiver, IFSLayerScrollerStatus
{
  protected IFSFeedIoc a;
  protected T b;
  protected int c;
  protected FSFeedPresenterManager d;
  protected View e;
  
  private void a(FSSeekEvent paramFSSeekEvent)
  {
    Object localObject = this.b;
    if (!(localObject instanceof FeedCloudMeta.StFeed)) {
      return;
    }
    if (!((FeedCloudMeta.StFeed)localObject).id.get().equals(paramFSSeekEvent.mFeedId)) {
      return;
    }
    a(paramFSSeekEvent.mIsOnSeek);
  }
  
  private Object f()
  {
    View localView = this.e;
    if (!(localView instanceof FSBaseWidgetView)) {
      return null;
    }
    return ((FSBaseWidgetView)localView).getReportBean();
  }
  
  public void a() {}
  
  public void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void a(@NonNull View paramView)
  {
    this.e = paramView;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void a(FSFeedSelectInfo paramFSFeedSelectInfo) {}
  
  public void a(IFSFeedIoc paramIFSFeedIoc)
  {
    this.a = paramIFSFeedIoc;
  }
  
  public void a(FSFeedPresenterManager paramFSFeedPresenterManager)
  {
    this.d = paramFSFeedPresenterManager;
  }
  
  protected void a(FSBaseFeedPresenterEvent paramFSBaseFeedPresenterEvent) {}
  
  public void a(T paramT, int paramInt)
  {
    this.b = paramT;
    this.c = paramInt;
  }
  
  protected void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void b(FSFeedSelectInfo paramFSFeedSelectInfo) {}
  
  public void b(FSBaseFeedPresenterEvent paramFSBaseFeedPresenterEvent)
  {
    FSFeedPresenterManager localFSFeedPresenterManager = this.d;
    if (localFSFeedPresenterManager == null) {
      return;
    }
    localFSFeedPresenterManager.a(paramFSBaseFeedPresenterEvent);
  }
  
  public void c() {}
  
  public void c(FSFeedSelectInfo paramFSFeedSelectInfo) {}
  
  public String d()
  {
    return e().getPageId();
  }
  
  public void d(FSFeedSelectInfo paramFSFeedSelectInfo) {}
  
  public FSReportBean e()
  {
    Object localObject = f();
    if (!(localObject instanceof FSReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("FSBaseFeedChildPresenter", 1, "getReportBean but FSReportBean is null");
        return new FSReportBean();
      }
      QLog.e("FSBaseFeedChildPresenter", 1, "getReportBean but FSReportBean is null , debug");
      throw new RuntimeException("getReportBean but FSReportBean is null");
    }
    return (FSReportBean)localObject;
  }
  
  public void e(FSFeedSelectInfo paramFSFeedSelectInfo) {}
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSSeekEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSSeekEvent)) {
      a((FSSeekEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSBaseFeedChildPresenter
 * JD-Core Version:    0.7.0.1
 */