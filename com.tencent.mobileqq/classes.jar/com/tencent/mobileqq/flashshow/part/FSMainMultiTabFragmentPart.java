package com.tencent.mobileqq.flashshow.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.flashshow.adapter.FSMultiTabFragmentAdapter;
import com.tencent.mobileqq.flashshow.api.bean.FSFolderBean;
import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.api.instance.FSFolderFragmentManager;
import com.tencent.mobileqq.flashshow.bean.FSLayerHeadViewRefreshInfo;
import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.data.FSRecentlyFeedStateData;
import com.tencent.mobileqq.flashshow.events.FSPageSelectEvent;
import com.tencent.mobileqq.flashshow.fragment.FSBaseFragment;
import com.tencent.mobileqq.flashshow.fragment.tab.FSBaseTabFragment;
import com.tencent.mobileqq.flashshow.helper.FSGlobalInfoHelper;
import com.tencent.mobileqq.flashshow.helper.FSGpsHelper;
import com.tencent.mobileqq.flashshow.helper.FSTempRedPointHelper;
import com.tencent.mobileqq.flashshow.ioc.IFSFolderIoc;
import com.tencent.mobileqq.flashshow.ioc.IFSTabFragmentIoc;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.utils.FSInnerProtoUtil;
import com.tencent.mobileqq.flashshow.view.FSMultiTabView;
import com.tencent.mobileqq.flashshow.view.FSPageTurnContainer;
import com.tencent.mobileqq.flashshow.viewmodel.tab.FSMainTabViewModel;
import com.tencent.mobileqq.flashshow.widgets.FSViewPager;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qflash.QFlashBadge.BadgeDisplayInfo;
import qflash.QFlashBadge.BadgeJumpInfo;
import qflash.QFlashBadge.BadgeTypeInfo;
import qflash.QFlashBadge.QFlashBadgeContentInfo;
import qflash.QFlashBadge.QFlashBadgeInfo;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class FSMainMultiTabFragmentPart
  extends FSBasePart
  implements Observer<FSRecentlyFeedStateData>, SimpleEventReceiver, IFSTabFragmentIoc
{
  private TabLayoutCompat a;
  private FSViewPager b;
  private FSMultiTabFragmentAdapter c;
  private final ArrayList<FSMultiTabView> d = new ArrayList();
  private final ArrayList<String> e = new ArrayList();
  private final ArrayList<FSBaseTabFragment> f = new ArrayList();
  private FSMainTabViewModel g;
  private IFSFolderIoc h;
  private int i;
  private int j = -1;
  private int k;
  private int l = 0;
  private boolean m = false;
  private FeedCloudMeta.StUser n;
  private ValueAnimator o;
  private FeedCloudMeta.StFeed p;
  private boolean q;
  
  private void a(FSMainTabInfo paramFSMainTabInfo)
  {
    FSBaseTabFragment localFSBaseTabFragment = FSBaseTabFragment.a(paramFSMainTabInfo, d());
    if (localFSBaseTabFragment != null)
    {
      localFSBaseTabFragment.a(this);
      this.f.add(localFSBaseTabFragment);
      this.e.add(paramFSMainTabInfo.a());
      return;
    }
    QLog.e("FSMainMultiTabFragmentPart", 1, "addTab invalid input data!");
  }
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      b(paramList);
      return;
    }
    QLog.e("FSMainMultiTabFragmentPart", 1, "handleTabInfoRsp() return unexpected data！");
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    FSViewPager localFSViewPager = this.b;
    if (localFSViewPager != null) {
      localFSViewPager.setCurrentItem(paramInt, paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean, FSBaseTabFragment paramFSBaseTabFragment)
  {
    if (paramBoolean) {
      paramFSBaseTabFragment.i();
    }
  }
  
  private void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (!(paramVarArgs[0] instanceof Boolean)) {
        return;
      }
      FSViewPager localFSViewPager = this.b;
      if (localFSViewPager != null) {
        localFSViewPager.setScrollable(((Boolean)paramVarArgs[0]).booleanValue());
      }
      int i1 = 0;
      while (i1 < this.f.size())
      {
        ((FSBaseTabFragment)this.f.get(i1)).g().r().setRefreshEnable(((Boolean)paramVarArgs[0]).booleanValue());
        i1 += 1;
      }
    }
  }
  
  private boolean a(int paramInt, FSBaseTabFragment paramFSBaseTabFragment)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFSBaseTabFragment != null)
    {
      if (paramFSBaseTabFragment.h() == null) {
        return false;
      }
      bool1 = bool2;
      if (paramInt == paramFSBaseTabFragment.h().b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(FSMainTabInfo paramFSMainTabInfo, List<QFlashBadge.QFlashBadgeInfo> paramList)
  {
    if (paramFSMainTabInfo != null)
    {
      if (paramList == null) {
        return false;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QFlashBadge.QFlashBadgeInfo localQFlashBadgeInfo = (QFlashBadge.QFlashBadgeInfo)paramList.next();
        if ((localQFlashBadgeInfo.contentInfo.typeInfo.badgeSubTypeValue.get() == paramFSMainTabInfo.a.sourceType.get()) && (localQFlashBadgeInfo.contentInfo.displayInfo.showBadge.get())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(View paramView)
  {
    this.a = ((TabLayoutCompat)paramView.findViewById(2131433858));
    this.a.setTabTextColors(-16777216, -16777216);
    this.a.setTabMode(1);
    this.a.setTabGravity(1);
    this.a.setSelectedTabIndicatorHeight(0);
    this.a.setupWithViewPager(this.b);
    this.a.setViewPagerTabEventListener(new FSMainMultiTabFragmentPart.1(this));
    m();
  }
  
  private void b(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      u();
      c(paramList);
      d(paramList);
      v();
      return;
    }
    QLog.e("FSMainMultiTabFragmentPart", 1, "initTabLayout invalid input data!");
  }
  
  private void b(Object... paramVarArgs)
  {
    if ((this.a != null) && (paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (!(paramVarArgs[0] instanceof FSLayerHeadViewRefreshInfo)) {
        return;
      }
      paramVarArgs = (FSLayerHeadViewRefreshInfo)paramVarArgs[0];
      int i1 = paramVarArgs.a();
      if (i1 == 3)
      {
        this.a.setAlpha(1.0F - paramVarArgs.b());
        TabLayoutCompat localTabLayoutCompat = this.a;
        localTabLayoutCompat.setTranslationY(localTabLayoutCompat.getHeight() * paramVarArgs.b());
        return;
      }
      if (i1 == 2) {
        d(200);
      }
    }
  }
  
  private void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onPageSelected  mMultiViewPager pos = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , mLastPageSelectPosition = ");
    localStringBuilder.append(this.i);
    QLog.i("FSMainMultiTabFragmentPart", 1, localStringBuilder.toString());
    if (this.f == null) {
      return;
    }
    int i1 = 0;
    while (i1 < this.f.size())
    {
      if (i1 == paramInt) {
        ((FSBaseTabFragment)this.f.get(i1)).onResume();
      } else if (i1 == this.i) {
        ((FSBaseTabFragment)this.f.get(i1)).onStop();
      }
      i1 += 1;
    }
    this.i = paramInt;
    boolean bool;
    if (paramInt == this.f.size() - 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.m = bool;
    d(0);
    SimpleEventBus.getInstance().dispatchEvent(new FSPageSelectEvent(paramInt));
    FSInnerProtoUtil.a(FSTempRedPointHelper.getInstance().getBottomRedPointInfo());
    FSTempRedPointHelper.getInstance().setBottomRedPointValid(false);
    if (this.a != null) {
      b(paramInt);
    }
    this.q = true;
  }
  
  private void c(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if (paramList.size() > 4)
    {
      this.a.setTabMode(0);
      this.a.setTabGravity(1);
      this.a.setScrollableTabMinWidth(-2);
      return;
    }
    this.a.setTabMode(1);
    this.a.setTabGravity(1);
  }
  
  private int d()
  {
    int i1 = this.l;
    this.l = (i1 + 1);
    return i1;
  }
  
  private void d(int paramInt)
  {
    FSThreadUtils.a(new FSMainMultiTabFragmentPart.6(this), paramInt);
  }
  
  private void d(View paramView)
  {
    this.c = new FSMultiTabFragmentAdapter(j().getChildFragmentManager());
    this.b = ((FSViewPager)paramView.findViewById(2131433862));
    this.b.setAdapter(this.c);
    this.b.setOffscreenPageLimit(3);
    n();
    o();
  }
  
  private void d(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.next();
      if (localStTabInfo != null) {
        a(FSMainTabInfo.a(localStTabInfo));
      }
    }
    this.a.setVisibility(0);
    this.c.a(this.f);
    this.c.b(this.e);
    this.c.notifyDataSetChanged();
  }
  
  private void m()
  {
    this.a.a(new FSMainMultiTabFragmentPart.2(this));
  }
  
  private void n()
  {
    this.b.addOnPageChangeListener(new FSMainMultiTabFragmentPart.3(this));
  }
  
  private void o()
  {
    this.b.a(new FSMainMultiTabFragmentPart.4(this));
  }
  
  private void p()
  {
    if (this.n == null)
    {
      QLog.i("FSMainMultiTabFragmentPart", 1, "jumpPersonalPage() -> mCurrentExposeUser is null");
      return;
    }
    FSPersonalDetailBean localFSPersonalDetailBean = new FSPersonalDetailBean(l());
    localFSPersonalDetailBean.setUser(this.n);
    FSNativeLauncher.a(g(), localFSPersonalDetailBean);
    FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.p, null).a(2).b(8).a(this.n.id.get()));
  }
  
  private void q() {}
  
  private void r()
  {
    if (c() == null) {
      return;
    }
    Object localObject = c().getIntent();
    if (localObject != null)
    {
      if (!((Intent)localObject).hasExtra("fs_key_bundle_common_init_bean")) {
        return;
      }
      localObject = ((Intent)localObject).getSerializableExtra("fs_key_bundle_common_init_bean");
      if (!(localObject instanceof FSFolderBean)) {
        return;
      }
      this.j = ((FSFolderBean)localObject).getAssignShowTabType();
    }
  }
  
  private void s()
  {
    FSGpsHelper.a().c();
    this.g = ((FSMainTabViewModel)a(FSMainTabViewModel.class));
    this.g.b().observe(j(), new FSMainMultiTabFragmentPart.5(this));
    this.g.a(FSGpsHelper.a().d(), new FSFolderBean((FSReportBean)D()));
    ViewCompat.setPaddingRelative(this.a, 0, 0, 0, 0);
  }
  
  private void t()
  {
    FSDataCenter.a().a(this);
  }
  
  private void u()
  {
    if (this.j == -1) {
      this.j = FSGlobalInfoHelper.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("firstShowTabSourceType:");
    localStringBuilder.append(this.j);
    QLog.d("FSMainMultiTabFragmentPart", 1, localStringBuilder.toString());
  }
  
  private void v()
  {
    int i1 = this.j;
    if (i1 == -1) {
      return;
    }
    a(i1, false, false);
  }
  
  private void w()
  {
    Object localObject = FSInnerProtoUtil.a(FSTempRedPointHelper.getInstance().getBottomRedPointInfo());
    if (this.f.size() == 0) {
      return;
    }
    if (!FSTempRedPointHelper.getInstance().isBottomRedPointValid()) {
      return;
    }
    String str = ((QFlashBadge.QFlashBadgeInfo)localObject).contentInfo.displayInfo.jumpInfo.jumpLink.get();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    str = Uri.parse(str).getQueryParameter("sourcetype");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    try
    {
      this.j = Integer.parseInt(str);
      v();
      if (!this.q) {
        return;
      }
      if (((QFlashBadge.QFlashBadgeInfo)localObject).contentInfo.typeInfo.badgeSubTypeValue.get() == 1) {
        return;
      }
      localObject = this.f.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((FSBaseTabFragment)((Iterator)localObject).next()).k();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FSMainMultiTabFragmentPart", 1, "parse sourceType error", localException);
    }
  }
  
  public FSMultiTabView a(int paramInt)
  {
    ArrayList localArrayList = this.d;
    if ((localArrayList != null) && (localArrayList.size() > paramInt)) {
      return (FSMultiTabView)this.d.get(paramInt);
    }
    return null;
  }
  
  public String a()
  {
    return "FSMainMultiTabFragmentPart";
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt < 0) {
      return;
    }
    int i1 = 0;
    while (i1 < this.f.size())
    {
      FSBaseTabFragment localFSBaseTabFragment = (FSBaseTabFragment)this.f.get(i1);
      if (a(paramInt, localFSBaseTabFragment))
      {
        a(paramBoolean1, i1);
        a(paramBoolean2, localFSBaseTabFragment);
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    d(paramView);
    b(paramView);
    q();
    r();
    s();
    t();
  }
  
  public void a(FSRecentlyFeedStateData paramFSRecentlyFeedStateData)
  {
    if (paramFSRecentlyFeedStateData != null)
    {
      this.n = ((FeedCloudMeta.StUser)paramFSRecentlyFeedStateData.b.get());
      this.p = ((FeedCloudMeta.StFeed)paramFSRecentlyFeedStateData.a.get());
    }
  }
  
  public void a(IFSFolderIoc paramIFSFolderIoc)
  {
    this.h = paramIFSFolderIoc;
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    IFSFolderIoc localIFSFolderIoc = this.h;
    if (localIFSFolderIoc != null) {
      localIFSFolderIoc.a(paramString, paramVarArgs);
    }
    if (TextUtils.equals(paramString, "event_open_comment"))
    {
      c("comment_panel_show", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_hide_comment"))
    {
      c("comment_panel_dismiss", null);
      return;
    }
    if ((TextUtils.equals(paramString, "event_open_comment_input")) && (paramVarArgs.length == 1))
    {
      c("comment_input_window_show", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_share"))
    {
      c("share_action_show_share_sheet", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_set_viewpager_enable"))
    {
      a(paramVarArgs);
      return;
    }
    if (TextUtils.equals(paramString, "event_layer_head_view_refresh_status")) {
      b(paramVarArgs);
    }
  }
  
  public boolean ah_()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      FSBaseFragment localFSBaseFragment = (FSBaseFragment)localIterator.next();
      if (localFSBaseFragment != null) {
        localFSBaseFragment.onBackEvent();
      }
    }
    return false;
  }
  
  public Object b(String paramString, Object paramObject)
  {
    return super.b(paramString, paramObject);
  }
  
  public void b(int paramInt)
  {
    List localList = FSInnerProtoUtil.a(FSTempRedPointHelper.getInstance().getTabRedPointInfo());
    if (localList == null) {
      return;
    }
    int i1 = 0;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" redPoint size = ");
    ((StringBuilder)localObject).append(localList.size());
    QLog.d("FSMainMultiTabFragmentPart", 1, new Object[] { "updateRedPointInfos selectPosition", ((StringBuilder)localObject).toString() });
    while (i1 < this.f.size())
    {
      localObject = a(i1);
      FSMainTabInfo localFSMainTabInfo = ((FSBaseTabFragment)this.f.get(i1)).h();
      if ((localObject != null) && (localFSMainTabInfo != null) && (localFSMainTabInfo.a != null)) {
        if (i1 == paramInt) {
          ((FSMultiTabView)localObject).c();
        } else if (a(localFSMainTabInfo, localList)) {
          ((FSMultiTabView)localObject).b();
        }
      }
      i1 += 1;
    }
  }
  
  public int e()
  {
    IFSFolderIoc localIFSFolderIoc = this.h;
    if (localIFSFolderIoc == null) {
      return -1;
    }
    return localIFSFolderIoc.e();
  }
  
  public int f()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((IFSFolderIoc)localObject).e() != 0)) {
      return -1;
    }
    localObject = this.b;
    if (localObject != null) {
      return ((FSViewPager)localObject).getCurrentItem();
    }
    return -1;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSLayerHeadViewRefreshInfo.class);
    return localArrayList;
  }
  
  public void k()
  {
    super.k();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      FSBaseFragment localFSBaseFragment = (FSBaseFragment)localIterator.next();
      if (localFSBaseFragment != null) {
        localFSBaseFragment.beforeFinish();
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    paramActivity = this.o;
    if (paramActivity != null)
    {
      paramActivity.removeAllUpdateListeners();
      this.o.cancel();
      this.o = null;
    }
    if (this.f == null) {
      return;
    }
    QLog.d("FSMainMultiTabFragmentPart", 1, "fs_lifecycle onActivityDestroyed");
    paramActivity = this.f.iterator();
    while (paramActivity.hasNext()) {
      ((FSBaseTabFragment)paramActivity.next()).onDestroy();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null)
    {
      if (this.f == null) {
        return;
      }
      int i1 = paramActivity.getCurrentItem();
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityPaused  mMultiViewPagerIndex = ");
      paramActivity.append(i1);
      QLog.d("FSMainMultiTabFragmentPart", 1, paramActivity.toString());
      if (this.f.size() > i1) {
        ((FSBaseTabFragment)this.f.get(i1)).onPause();
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null)
    {
      if (this.f == null) {
        return;
      }
      int i1 = paramActivity.getCurrentItem();
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityResumed  mMultiViewPagerIndex = ");
      paramActivity.append(i1);
      QLog.d("FSMainMultiTabFragmentPart", 1, paramActivity.toString());
      if (FSFolderFragmentManager.a().f())
      {
        if (this.f.size() == 0) {
          return;
        }
        w();
        SimpleEventBus.getInstance().dispatchEvent(new FSPageSelectEvent(this.a.getSelectedTabPosition()));
        FSInnerProtoUtil.a(FSTempRedPointHelper.getInstance().getBottomRedPointInfo());
        FSTempRedPointHelper.getInstance().setBottomRedPointValid(false);
        paramActivity = this.a;
        if (paramActivity != null) {
          b(paramActivity.getSelectedTabPosition());
        }
      }
      if ((this.f.size() > i1) && (i1 >= 0)) {
        ((FSBaseTabFragment)this.f.get(i1)).onResume();
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    super.onActivityPaused(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null)
    {
      if (this.f == null) {
        return;
      }
      int i1 = paramActivity.getCurrentItem();
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityStopped  mMultiViewPagerIndex = ");
      paramActivity.append(i1);
      QLog.d("FSMainMultiTabFragmentPart", 1, paramActivity.toString());
      if (this.f.size() > i1) {
        ((FSBaseTabFragment)this.f.get(i1)).onStop();
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSMainMultiTabFragmentPart
 * JD-Core Version:    0.7.0.1
 */