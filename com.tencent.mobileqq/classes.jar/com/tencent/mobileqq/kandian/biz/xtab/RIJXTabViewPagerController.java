package com.tencent.mobileqq.kandian.biz.xtab;

import android.content.Context;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeReporter;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;", "", "tabFrame", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame;", "tabBar", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar;", "(Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabFrame;Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar;)V", "TAG", "", "onPageChangeListener", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController$onPageChangeListener$1", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController$onPageChangeListener$1;", "tabChannelCoverInfoList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "viewPager", "Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager;", "getViewPager", "()Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager;", "viewPager$delegate", "Lkotlin/Lazy;", "viewPagerAdapter", "Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;", "getViewPagerAdapter", "()Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;", "viewPagerAdapter$delegate", "getChannelCover", "index", "", "getCurrentChannelCover", "getCurrentFragment", "Lcom/tencent/mobileqq/app/QBaseFragment;", "getCurrentIndex", "getFragment", "getIndexByChannelID", "channelID", "getRecommendIndex", "handleTabBarOnPageSelected", "", "tabInfo", "onDestroy", "context", "Landroid/content/Context;", "onEnterKDTab", "onExitKDTab", "resetData", "setCurrentItem", "setCurrentItemByChannelID", "switch2RecommendFragment", "switchToDefaultChannel", "tryHandleBadgeOnPageSelected", "tryHandleGuideBadgeOnPageSelected", "updateChannelList", "channelList", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabViewPagerController
{
  private final String a;
  private final List<TabChannelCoverInfo> b;
  private final Lazy c;
  private final Lazy d;
  private final RIJXTabViewPagerController.onPageChangeListener.1 e;
  private final RIJXTabFrame f;
  private final RIJXTabBar g;
  
  public RIJXTabViewPagerController(@NotNull RIJXTabFrame paramRIJXTabFrame, @NotNull RIJXTabBar paramRIJXTabBar)
  {
    this.f = paramRIJXTabFrame;
    this.g = paramRIJXTabBar;
    this.a = "RIJXTabViewPagerController";
    this.b = ((List)new ArrayList());
    RIJChannelStayTimeMonitor.INSTANCE.startMonitor();
    this.c = LazyKt.lazy((Function0)new RIJXTabViewPagerController.viewPagerAdapter.2(this));
    this.d = LazyKt.lazy((Function0)new RIJXTabViewPagerController.viewPager.2(this));
    this.e = new RIJXTabViewPagerController.onPageChangeListener.1(this);
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    int i;
    if ((paramInt2 != TabChannelCoverInfo.TYPE_CHANNEL_XTAB_FRIEND_CONFIG) && (paramInt2 != TabChannelCoverInfo.TYPE_CHANNEL_XTAB_KD_COMMUNITY_CONFIG) && (RIJXTabBadgeStore.b(paramInt2) != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    QBaseFragment localQBaseFragment = c(paramInt1);
    Object localObject = localQBaseFragment;
    if (!(localQBaseFragment instanceof ReadInJoyBaseFragment)) {
      localObject = null;
    }
    localObject = (ReadInJoyBaseFragment)localObject;
    if (localObject != null)
    {
      ((ReadInJoyBaseFragment)localObject).a(3);
      ThreadManager.getUIHandler().postDelayed((Runnable)new RIJXTabViewPagerController.tryHandleBadgeOnPageSelected.1(this, paramInt2), 500L);
    }
  }
  
  private final void a(int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    ThreadManager.getUIHandler().post((Runnable)new RIJXTabViewPagerController.handleTabBarOnPageSelected.1(this, paramTabChannelCoverInfo, paramInt));
  }
  
  private final void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int i = paramTabChannelCoverInfo.mChannelCoverId;
    if (paramTabChannelCoverInfo.needBadgeGuide)
    {
      if (!RIJXTabBadgeStore.a.d(i)) {
        return;
      }
      RIJXTabBadgeReporter.b(i);
      ThreadManager.getUIHandler().postDelayed((Runnable)new RIJXTabViewPagerController.tryHandleGuideBadgeOnPageSelected.1(this, i), 500L);
    }
  }
  
  private final int e(int paramInt)
  {
    Object localObject = this.b.iterator();
    int i = 0;
    int j;
    while (((Iterator)localObject).hasNext())
    {
      if (((TabChannelCoverInfo)((Iterator)localObject).next()).mChannelCoverId == paramInt) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        break label63;
      }
      i += 1;
    }
    i = -1;
    label63:
    if (i >= 0)
    {
      j = i;
      if (i < this.b.size()) {}
    }
    else
    {
      j = j();
    }
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getIndexByChannelID,channelID=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",index=");
    localStringBuilder.append(j);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    return j;
  }
  
  private final ReadInJoyChannelViewPager.CustomFragmentPagerAdapter h()
  {
    return (ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)this.c.getValue();
  }
  
  private final ReadInJoyChannelViewPager i()
  {
    return (ReadInJoyChannelViewPager)this.d.getValue();
  }
  
  private final int j()
  {
    Iterator localIterator = this.b.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j;
      if (((TabChannelCoverInfo)localIterator.next()).mChannelCoverId == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        break label59;
      }
      i += 1;
    }
    i = -1;
    label59:
    if (i == -1) {
      return 0;
    }
    return i;
  }
  
  public final void a()
  {
    i().post((Runnable)new RIJXTabViewPagerController.resetData.1(this));
  }
  
  public final void a(int paramInt)
  {
    b(e(paramInt));
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    RIJChannelStayTimeMonitor.INSTANCE.endMonitor();
    i().clearOnPageChangeListeners();
    if (((paramContext instanceof SplashActivity)) && (!((SplashActivity)paramContext).isFinishing())) {
      h().a();
    }
  }
  
  public final void a(@NotNull List<? extends TabChannelCoverInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "channelList");
    this.b.clear();
    this.b.addAll((Collection)paramList);
    this.g.a(this.b, this);
    h().a(this.b);
    a(RIJXTabConfigHandler.INSTANCE.getDefaultEnterTabId());
    i().post((Runnable)new RIJXTabViewPagerController.updateChannelList.1(this));
    QLog.d(this.a, 1, "updateViewPager!");
  }
  
  public final void b()
  {
    i().post((Runnable)new RIJXTabViewPagerController.onEnterKDTab.1(this));
  }
  
  public final void b(int paramInt)
  {
    int i;
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      i = paramInt;
    } else {
      i = j();
    }
    i().setCurrentItem(i, true);
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCurrentItem,index=");
    localStringBuilder.append(paramInt);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  @Nullable
  public final QBaseFragment c(int paramInt)
  {
    return h().a(paramInt);
  }
  
  public final void c()
  {
    i().post((Runnable)new RIJXTabViewPagerController.onExitKDTab.1(this));
  }
  
  @Nullable
  public final TabChannelCoverInfo d(int paramInt)
  {
    return (TabChannelCoverInfo)CollectionsKt.getOrNull(this.b, paramInt);
  }
  
  public final void d()
  {
    b(e(RIJXTabConfigHandler.INSTANCE.getDefaultEnterTabId()));
  }
  
  @Nullable
  public final QBaseFragment e()
  {
    return h().d();
  }
  
  public final int f()
  {
    return i().getCurrentItem();
  }
  
  @Nullable
  public final TabChannelCoverInfo g()
  {
    return (TabChannelCoverInfo)CollectionsKt.getOrNull(this.b, i().getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController
 * JD-Core Version:    0.7.0.1
 */