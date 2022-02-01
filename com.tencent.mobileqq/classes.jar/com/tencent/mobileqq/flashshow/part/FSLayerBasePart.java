package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.mobileqq.flashshow.events.FSFeedEvent;
import com.tencent.mobileqq.flashshow.preload.FSVideoPreloadManager;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSToastUtil;
import com.tencent.mobileqq.flashshow.view.FSPageTurnContainer;
import com.tencent.mobileqq.flashshow.widgets.comment.FSPanelLoadingView;
import com.tencent.mobileqq.flashshow.widgets.fault.FSFaultHintView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.util.EventControlUtils;
import java.util.ArrayList;
import java.util.List;

public class FSLayerBasePart
  extends FSBasePart
  implements SimpleEventReceiver
{
  protected FSPageTurnContainer a;
  protected FSLayerPageAdapter b;
  protected int c = -1;
  protected int d = -1;
  protected FSFaultHintView e;
  protected FSPanelLoadingView f;
  
  private void a(long paramLong, String paramString)
  {
    p();
    if (a(paramLong))
    {
      s().clearData();
      s().notifyDataSetChanged();
      a(paramString);
      return;
    }
    if (t())
    {
      a(paramString);
      return;
    }
    FSToastUtil.a(paramLong, FSToastUtil.c, paramString, 1);
  }
  
  private boolean a(long paramLong)
  {
    return false;
  }
  
  private void b(boolean paramBoolean, FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    paramFSFeedSelectInfo = new FSLayerBasePart.5(this, paramFSFeedSelectInfo);
    long l;
    if (paramBoolean) {
      l = 0L;
    } else {
      l = 200L;
    }
    FSThreadUtils.a(paramFSFeedSelectInfo, l);
  }
  
  private void d()
  {
    e();
    this.b.setEnableHookDataObserver(m());
    this.b.registerAdapterDataObserver(new FSLayerBasePart.1(this));
  }
  
  private void e()
  {
    this.a.getViewPager2().registerOnPageChangeCallback(new FSLayerBasePart.2(this));
    this.a.setOnLoadDataCallback(new FSLayerBasePart.3(this));
  }
  
  private void f()
  {
    FSLayerPageAdapter localFSLayerPageAdapter = this.b;
    if ((localFSLayerPageAdapter != null) && (localFSLayerPageAdapter.getDataList() != null))
    {
      if (this.b.getDataList().size() <= this.d) {
        return;
      }
      c("layer_notify_part_update_feed", (FSFeedData)this.b.getDataList().get(this.d));
    }
  }
  
  private void u()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((FSLayerPageAdapter)localObject).getDataList() != null))
    {
      if (this.b.getDataList().isEmpty()) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("handleAdapterNotifyDataSetChanged");
      if (!EventControlUtils.a(((StringBuilder)localObject).toString(), 200L)) {
        return;
      }
      QLog.i(a(), 1, "handleAdapterNotifyDataSetChanged");
      localObject = this.a;
      if (localObject == null) {
        return;
      }
      a(false, new FSFeedSelectInfo(((FSPageTurnContainer)localObject).getViewPager2().getCurrentItem()));
    }
  }
  
  public String a()
  {
    return "FSLayerBasePart";
  }
  
  protected void a(int paramInt)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle mLayerPageContainer onPageSelected  position = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" , mLastFeedPos = ");
    localStringBuilder.append(this.c);
    QLog.d(str, 1, localStringBuilder.toString());
    int i = this.d;
    if (i != -1)
    {
      this.c = i;
      b(true, new FSFeedSelectInfo(this.c));
    }
    this.d = paramInt;
    if (n()) {
      a(false, new FSFeedSelectInfo(this.d));
    }
    f();
    if (this.d == 0)
    {
      c("tag_show_msg_bubble", null);
      return;
    }
    c("tag_hide_msg_bubble", null);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((FSPageTurnContainer)paramView.findViewById(2131433854));
    this.b = new FSLayerPageAdapter();
    this.b.a(c());
    this.a.getViewPager2().setAdapter(this.b);
    this.e = ((FSFaultHintView)paramView.findViewById(2131433848));
    this.f = ((FSPanelLoadingView)paramView.findViewById(2131433853));
    d();
  }
  
  protected void a(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    if (this.b == null) {
      return;
    }
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle notifyOnFeedUnselected | selectInfo = ");
    localStringBuilder.append(paramFSFeedSelectInfo);
    localStringBuilder.append(" | pageId = ");
    localStringBuilder.append(i());
    QLog.i(str, 1, localStringBuilder.toString());
    this.b.e(paramFSFeedSelectInfo);
  }
  
  protected void a(FSFeedEvent paramFSFeedEvent)
  {
    if (paramFSFeedEvent == null) {
      return;
    }
    d(paramFSFeedEvent);
    b(paramFSFeedEvent);
    c(paramFSFeedEvent);
  }
  
  protected void a(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listUIStateData = ");
    localStringBuilder.append(paramUIStateData.c());
    QLog.d(str, 1, localStringBuilder.toString());
    if (r() != null)
    {
      if (s() == null) {
        return;
      }
      int i = paramUIStateData.c();
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i != 2) && (i != 3))
          {
            if (i == 4)
            {
              QLog.e(a(), 1, "handleFeedsRsp() return error status");
              if (paramUIStateData.f() == null) {
                str = FSHardCodeUtil.a(2131889723);
              } else {
                str = paramUIStateData.f();
              }
              a(paramUIStateData.g(), str);
            }
          }
          else
          {
            str = a();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleFeedsRsp() return success  , size = ");
            localStringBuilder.append(((List)paramUIStateData.e()).size());
            localStringBuilder.append(" , isLoadMore = ");
            localStringBuilder.append(paramUIStateData.i());
            localStringBuilder.append(" , isFinish = ");
            localStringBuilder.append(paramUIStateData.h());
            QLog.i(str, 1, localStringBuilder.toString());
            b(paramUIStateData);
          }
        }
        else
        {
          QLog.d(a(), 1, "handleLoadState()");
          o();
        }
      }
      else
      {
        QLog.e(a(), 1, "handleEmptyState() return empty data");
        q();
      }
      if (i != 1)
      {
        this.a.a(paramUIStateData.h() ^ true);
        this.a.b(paramUIStateData.h() ^ true);
      }
    }
  }
  
  protected void a(String paramString)
  {
    FSFaultHintView localFSFaultHintView = this.e;
    if (localFSFaultHintView != null) {
      localFSFaultHintView.b(paramString);
    }
    paramString = this.a;
    if (paramString != null) {
      paramString.e();
    }
    c("layer_notify_part_hide_bottom_input_view", null);
  }
  
  protected void a(boolean paramBoolean, FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    paramFSFeedSelectInfo = new FSLayerBasePart.4(this, paramFSFeedSelectInfo);
    long l;
    if (paramBoolean) {
      l = 0L;
    } else {
      l = 200L;
    }
    FSThreadUtils.a(paramFSFeedSelectInfo, l);
  }
  
  protected void b(FSFeedEvent paramFSFeedEvent)
  {
    if (paramFSFeedEvent.getStatus() == 1)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        if (this.a == null) {
          return;
        }
        boolean bool = ((FSLayerPageAdapter)localObject).b(paramFSFeedEvent.getFeedId());
        localObject = a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleFSFeedEvent removeFeed  feedId = ");
        localStringBuilder.append(paramFSFeedEvent.getFeedId());
        localStringBuilder.append(" | result = ");
        localStringBuilder.append(bool);
        QLog.i((String)localObject, 1, localStringBuilder.toString());
        if (bool) {
          a(false, new FSFeedSelectInfo(this.a.getViewPager2().getCurrentItem()));
        }
      }
    }
  }
  
  protected void b(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    p();
    FSFaultHintView localFSFaultHintView = this.e;
    if (localFSFaultHintView == null) {
      return;
    }
    localFSFaultHintView.c();
    this.a.f();
    if (paramUIStateData.i())
    {
      c(paramUIStateData);
    }
    else
    {
      this.b.setDatas((ArrayList)paramUIStateData.e());
      if (this.b.getDataList().size() == 0) {
        return;
      }
      if (this.a.getViewPager2().getCurrentItem() != 0) {
        this.a.getViewPager2().setCurrentItem(0, false);
      }
    }
    FSVideoPreloadManager.a().a((List)paramUIStateData.e());
  }
  
  protected void b(boolean paramBoolean) {}
  
  protected void c(FSFeedEvent paramFSFeedEvent) {}
  
  protected void c(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    this.b.addAll((List)paramUIStateData.e());
  }
  
  protected void d(FSFeedEvent paramFSFeedEvent)
  {
    if (this.b != null)
    {
      if (this.a == null) {
        return;
      }
      boolean bool2 = false;
      boolean bool1;
      if (paramFSFeedEvent.getStatus() == 1)
      {
        bool1 = this.b.a(paramFSFeedEvent.getFeedId());
      }
      else
      {
        bool1 = bool2;
        if (paramFSFeedEvent.getStatus() == 2)
        {
          bool1 = bool2;
          if (TextUtils.equals(i(), "pg_ks_following_page")) {
            bool1 = this.b.c(paramFSFeedEvent.getUin());
          }
        }
      }
      if (!bool1) {
        return;
      }
      String str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyFeedDeleteChangeBefore needRemove , event : ");
      localStringBuilder.append(paramFSFeedEvent.toString());
      QLog.i(str, 1, localStringBuilder.toString());
      a(new FSFeedSelectInfo(this.a.getViewPager2().getCurrentItem()).a(1));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSFeedEvent.class);
    return localArrayList;
  }
  
  protected boolean m()
  {
    return false;
  }
  
  protected boolean n()
  {
    return this.c != -1;
  }
  
  protected void o()
  {
    if (!t()) {
      return;
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((FSFaultHintView)localObject).c();
    }
    localObject = this.f;
    if (localObject != null) {
      ((FSPanelLoadingView)localObject).a();
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onActivityDestroyed  mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    QLog.d(str, 1, localStringBuilder.toString());
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.b();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onActivityPaused  mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    QLog.d(str, 1, localStringBuilder.toString());
    super.onActivityPaused(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.b(new FSFeedSelectInfo(this.d));
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onActivityResumed  mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    QLog.d(str, 1, localStringBuilder.toString());
    super.onActivityResumed(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.a(new FSFeedSelectInfo(this.d));
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onActivityStopped  mCurrentFeedPos = ");
    localStringBuilder.append(this.d);
    QLog.d(str, 1, localStringBuilder.toString());
    super.onActivityStopped(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.c(new FSFeedSelectInfo(this.d));
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSFeedEvent)) {
      a((FSFeedEvent)paramSimpleBaseEvent);
    }
  }
  
  protected void p()
  {
    FSPanelLoadingView localFSPanelLoadingView = this.f;
    if (localFSPanelLoadingView != null) {
      localFSPanelLoadingView.b();
    }
  }
  
  protected void q()
  {
    p();
    if (t()) {
      a("");
    }
  }
  
  public FSPageTurnContainer r()
  {
    return this.a;
  }
  
  public FSLayerPageAdapter s()
  {
    return this.b;
  }
  
  protected boolean t()
  {
    return s().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSLayerBasePart
 * JD-Core Version:    0.7.0.1
 */