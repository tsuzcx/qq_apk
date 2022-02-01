package com.tencent.mobileqq.flashshow.widgets.feed;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.ioc.IFSFeedIoc;
import com.tencent.mobileqq.flashshow.manager.IFSLayerScrollerStatus;
import com.tencent.mobileqq.flashshow.presenter.feed.FSBaseFeedChildPresenter;
import com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildBarragePresenter;
import com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildBottomInfoPresenter;
import com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildDebugInfoPresenter;
import com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildDoublePraisePresenter;
import com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildHeaderPresenter;
import com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildInteractPresenter;
import com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildVideoPresenter;
import com.tencent.mobileqq.flashshow.presenter.feed.FSFeedPresenterManager;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FSLayerFeedItemView
  extends FSBaseWidgetView<FSFeedData>
  implements IFSLayerScrollerStatus
{
  private static ArrayList<Class<? extends FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>>> d = new ArrayList(Arrays.asList(new Class[] { FSFeedChildBottomInfoPresenter.class, FSFeedChildBarragePresenter.class, FSFeedChildHeaderPresenter.class, FSFeedChildInteractPresenter.class, FSFeedChildVideoPresenter.class, FSFeedChildDoublePraisePresenter.class, FSFeedChildDebugInfoPresenter.class }));
  private HashMap<Class, FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>> a;
  private IFSFeedIoc b;
  private FSFeedPresenterManager c = null;
  private boolean e;
  
  public FSLayerFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (paramView == null)
    {
      QLog.d("FSLayerFeedItemView", 1, "[notifyInitView] root view should not be null.");
      return;
    }
    paramContext = getPresenterMaps().entrySet().iterator();
    while (paramContext.hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)paramContext.next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.a(paramView);
      }
    }
  }
  
  private void a(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    FSDataCenter.a().a(paramStFeed, false);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.a(paramStFeed, paramInt);
      }
    }
  }
  
  private void b()
  {
    FSFeedPresenterManager localFSFeedPresenterManager = this.c;
    if (localFSFeedPresenterManager == null) {
      return;
    }
    localFSFeedPresenterManager.a();
  }
  
  private void c()
  {
    if (this.e) {
      return;
    }
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.a(this.b);
      }
    }
    this.e = true;
  }
  
  private void d()
  {
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.b();
      }
    }
  }
  
  private void e()
  {
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.c();
      }
    }
  }
  
  private void f()
  {
    HashMap localHashMap = getPresenterMaps();
    this.c = new FSFeedPresenterManager();
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)localClass.newInstance();
        this.c.a(localFSBaseFeedChildPresenter);
        localFSBaseFeedChildPresenter.a(this.c);
        localHashMap.put(localClass, localFSBaseFeedChildPresenter);
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    QLog.d("FSLayerFeedItemView", 1, "fs_lifecycle onDestroy");
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.a();
      }
    }
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Iterator localIterator = getPresenterMaps().entrySet().iterator();
    while (localIterator.hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)localIterator.next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.a(paramInt1, paramFloat, paramInt2);
      }
    }
  }
  
  protected void a(FSFeedData paramFSFeedData, int paramInt)
  {
    if (paramFSFeedData != null)
    {
      if (paramFSFeedData.b() == null) {
        return;
      }
      a(paramFSFeedData.b());
      c();
      a(paramFSFeedData.b(), paramInt);
    }
  }
  
  public void a(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onResumed  selectInfo = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("FSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.a(paramFSFeedSelectInfo);
      }
    }
  }
  
  public void b(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onPaused  selectInfo = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("FSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.b(paramFSFeedSelectInfo);
      }
    }
  }
  
  public void c(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onPaused  selectInfo = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("FSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.c(paramFSFeedSelectInfo);
      }
    }
  }
  
  public void d(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onFeedSelected  selectInfo = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("FSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.d(paramFSFeedSelectInfo);
      }
    }
  }
  
  public void e(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle onFeedUnSelected  selectInfo = ");
    ((StringBuilder)localObject).append(paramFSFeedSelectInfo);
    ((StringBuilder)localObject).append(" , itemView.dataPosInList = ");
    ((StringBuilder)localObject).append(this.dataPosInList);
    QLog.d("FSLayerFeedItemView", 1, ((StringBuilder)localObject).toString());
    localObject = getPresenterMaps().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      FSBaseFeedChildPresenter localFSBaseFeedChildPresenter = (FSBaseFeedChildPresenter)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localFSBaseFeedChildPresenter != null) {
        localFSBaseFeedChildPresenter.e(paramFSFeedSelectInfo);
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131624805;
  }
  
  public HashMap<Class, FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>> getPresenterMaps()
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    QLog.d("FSLayerFeedItemView", 1, "[onAttachedToWindow] current view item attached to window.");
    super.onAttachedToWindow();
    d();
  }
  
  protected void onDetachedFromWindow()
  {
    QLog.d("FSLayerFeedItemView", 1, "[onAttachedToWindow] current view item detached to window.");
    super.onDetachedFromWindow();
    e();
    b();
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    f();
    a(paramContext, paramView);
  }
  
  public void setFeedIoc(IFSFeedIoc paramIFSFeedIoc)
  {
    this.b = paramIFSFeedIoc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.feed.FSLayerFeedItemView
 * JD-Core Version:    0.7.0.1
 */