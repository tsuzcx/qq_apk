package com.tencent.mobileqq.kandian.biz.xtab;

import android.content.Context;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeReporter;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController;", "", "viewPager", "Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager;", "viewPagerAdapter", "Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;", "tabBar", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar;", "(Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager;Lcom/tencent/mobileqq/kandian/biz/tab/ReadInJoyChannelViewPager$CustomFragmentPagerAdapter;Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabBar;)V", "account", "", "onPageChangeListener", "com/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController$onPageChangeListener$1", "Lcom/tencent/mobileqq/kandian/biz/xtab/RIJXTabViewPagerController$onPageChangeListener$1;", "tabChannelCoverInfoList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "getTabChannelCoverInfoList", "()Ljava/util/List;", "tag", "getChannelCover", "index", "", "getCurrentChannelCover", "getCurrentFragment", "Lcom/tencent/mobileqq/app/QBaseFragment;", "getCurrentIndex", "getFragment", "getIndexByChannelID", "channelID", "getRecommendIndex", "handleGuideBadgeOnPageSelected", "", "tabInfo", "init", "needHandleBadgeOnPageSelected", "", "onDestroy", "context", "Landroid/content/Context;", "onTabChange", "setCurrentItem", "setCurrentItemByChannelID", "switch2RecommendFragment", "switchToDefaultChannel", "updateViewPager", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabViewPagerController
{
  private final ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private final ReadInJoyChannelViewPager jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager;
  private final RIJXTabBar jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar;
  private final RIJXTabViewPagerController.onPageChangeListener.1 jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController$onPageChangeListener$1;
  private String jdField_a_of_type_JavaLangString;
  @NotNull
  private final List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private final String b;
  
  public RIJXTabViewPagerController(@NotNull ReadInJoyChannelViewPager paramReadInJoyChannelViewPager, @NotNull ReadInJoyChannelViewPager.CustomFragmentPagerAdapter paramCustomFragmentPagerAdapter, @NotNull RIJXTabBar paramRIJXTabBar)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager = paramReadInJoyChannelViewPager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter = paramCustomFragmentPagerAdapter;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar = paramRIJXTabBar;
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_JavaLangString = "0";
    this.b = "RIJXTabViewPagerController";
    this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController$onPageChangeListener$1 = new RIJXTabViewPagerController.onPageChangeListener.1(this);
  }
  
  private final int a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
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
      if (i < this.jdField_a_of_type_JavaUtilList.size()) {}
    }
    else
    {
      j = b();
    }
    localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getIndexByChannelID,channelID=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",index=");
    localStringBuilder.append(j);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    return j;
  }
  
  private final void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if ((paramTabChannelCoverInfo.needBadgeGuide) && (RIJXTabBadgeStore.a.a(paramTabChannelCoverInfo.mChannelCoverId)))
    {
      RIJXTabBadgeReporter.b(paramTabChannelCoverInfo.mChannelCoverId);
      ThreadManager.getUIHandler().postDelayed((Runnable)new RIJXTabViewPagerController.handleGuideBadgeOnPageSelected..inlined.apply.lambda.1(paramTabChannelCoverInfo, this), 500L);
    }
  }
  
  private final boolean a(int paramInt)
  {
    return (paramInt != TabChannelCoverInfo.TYPE_CHANNEL_XTAB_FRIEND_CONFIG) && (paramInt != TabChannelCoverInfo.TYPE_CHANNEL_XTAB_KD_COMMUNITY_CONFIG) && (RIJXTabBadgeStore.a(paramInt) != null);
  }
  
  private final int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
  
  public final int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.getCurrentItem();
  }
  
  @Nullable
  public final QBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
  }
  
  @Nullable
  public final QBaseFragment a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
  }
  
  @Nullable
  public final TabChannelCoverInfo a()
  {
    return (TabChannelCoverInfo)CollectionsKt.getOrNull(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.getCurrentItem());
  }
  
  @Nullable
  public final TabChannelCoverInfo a(int paramInt)
  {
    return (TabChannelCoverInfo)CollectionsKt.getOrNull(this.jdField_a_of_type_JavaUtilList, paramInt);
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabViewPagerController$onPageChangeListener$1);
    ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).startMonitor();
  }
  
  public final void a(int paramInt)
  {
    b(a(paramInt));
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).endMonitor();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.clearOnPageChangeListeners();
    if (((paramContext instanceof SplashActivity)) && (!((SplashActivity)paramContext).isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
    }
  }
  
  public final void b()
  {
    if (!StringsKt.equals(RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_JavaLangString, true)) {
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.post((Runnable)new RIJXTabViewPagerController.onTabChange.1(this));
  }
  
  public final void b(int paramInt)
  {
    int i;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      i = paramInt;
    } else {
      i = b();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.setCurrentItem(i, true);
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCurrentItem,index=");
    localStringBuilder.append(paramInt);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public final void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll((Collection)RIJXTabFrameUtils.getChannelCoverList());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizXtabRIJXTabBar.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
    a(((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).getDefaultEnterTabId());
    String str = RIJQQAppInterfaceUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(str, "RIJQQAppInterfaceUtil.getAccount()");
    this.jdField_a_of_type_JavaLangString = str;
    QLog.d(this.b, 1, "updateViewPager!");
  }
  
  public final void d()
  {
    int j = b();
    int i = j;
    if (j == -1) {
      i = a(((IRIJXTabConfigHandler)QRoute.api(IRIJXTabConfigHandler.class)).getDefaultEnterTabId());
    }
    b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabViewPagerController
 * JD-Core Version:    0.7.0.1
 */