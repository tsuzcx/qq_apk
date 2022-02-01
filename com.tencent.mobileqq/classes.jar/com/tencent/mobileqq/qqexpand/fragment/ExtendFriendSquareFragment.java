package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.qqexpand.bean.feed.CacheData;
import com.tencent.mobileqq.qqexpand.bean.feed.CacheData.TagCache;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchFeedInfo;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean.BannerItem;
import com.tencent.mobileqq.qqexpand.feed.FeedBannerInfo;
import com.tencent.mobileqq.qqexpand.feed.FeedBannerTabItem;
import com.tencent.mobileqq.qqexpand.feed.FeedViewHolder;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView.OnClickListener;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView.TipsType;
import com.tencent.mobileqq.qqexpand.widget.WrapContentLinearLayoutManager;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.ILoadingLayout;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener2;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ExtendFriendSquareFragment
  extends ExtendFriendBaseFragment
  implements ExtendFriendCampusVerifyTipsView.OnClickListener, PullToRefreshBase.OnRefreshListener2<RecyclerView>
{
  private final FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new ExtendFriendSquareFragment.1(this);
  private final MatchFeedInfo jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo = new MatchFeedInfo();
  private final FeedBannerInfo jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerInfo = new FeedBannerInfo();
  private ExtendFriendReporter jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter;
  private final ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExtendFriendSquareFragment.2(this);
  private ExtendFriendBottomBarView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendBottomBarView;
  private ExpandSearchBarView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private WeakReferenceHandler b;
  public long e;
  public boolean e;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  public int i;
  private boolean i;
  public int j;
  private boolean j;
  private int jdField_k_of_type_Int = 1;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = false;
  private int m = -1;
  private int n;
  
  public ExtendFriendSquareFragment()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 480;
    this.jdField_e_of_type_Long = -1L;
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateSearchBarState scrollY: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  speed: ");
      ((StringBuilder)localObject).append(paramFloat);
      QLog.i("ExtendFriendSquareFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView;
    if (localObject != null) {
      if (paramInt < this.jdField_j_of_type_Int)
      {
        if (paramInt > this.n / 2)
        {
          if (paramFloat > 0.0F) {
            ((ExpandSearchBarView)localObject).b();
          }
        }
        else {
          ((ExpandSearchBarView)localObject).a();
        }
      }
      else if (paramFloat < -5.0F) {
        ((ExpandSearchBarView)localObject).a();
      } else if (paramFloat > 0.5D) {
        ((ExpandSearchBarView)localObject).b();
      }
    }
    d(false);
  }
  
  private void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(paramView, "voice_tab");
    VideoReport.setPageParams(paramView, new ExpandDTParamBuilder().a());
    QLog.i("ExtendFriendSquareFragment", 1, "reportDaTongRegister");
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, String.format("updateAddFrdState count=%d", new Object[] { Integer.valueOf(paramList.size()) }));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a((String)localObject);
      if (i1 >= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(i1);
        if ((localObject != null) && (!((StrangerInfo)localObject).mAddFriendVerified))
        {
          ((StrangerInfo)localObject).mAddFriendVerified = true;
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyItemChanged(i1);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if (isAdded())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter == null) {
        return;
      }
      paramString = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getTag(2131376308);
      int i1;
      if ((paramString != null) && ((paramString instanceof Integer))) {
        i1 = ((Integer)paramString).intValue();
      } else {
        i1 = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.c(paramBoolean1 ^ true);
      int i2 = 2131698905;
      if ((paramBoolean1) && (paramList != null))
      {
        this.jdField_i_of_type_Boolean = paramBoolean2;
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.jdField_a_of_type_Boolean = paramBoolean3;
        this.jdField_b_of_type_Boolean = paramBoolean4;
        this.jdField_l_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_Int = paramMatchFeedInfo.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_b_of_type_Int = paramMatchFeedInfo.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_c_of_type_Int = paramMatchFeedInfo.jdField_c_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_JavaUtilList.addAll(paramMatchFeedInfo.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.jdField_i_of_type_Boolean), this.jdField_a_of_type_ArrayOfByte, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_l_of_type_Int), Integer.valueOf(paramMatchFeedInfo.jdField_a_of_type_Int), Integer.valueOf(paramMatchFeedInfo.jdField_b_of_type_Int) }));
        }
        if (!this.h)
        {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a();
          p();
        }
        if (this.jdField_i_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(2, false);
        }
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
          if (paramString != null)
          {
            this.jdField_f_of_type_Long = System.currentTimeMillis();
            this.m = Calendar.getInstance().get(6);
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131719248), TimeFormatterUtils.a(this.jdField_f_of_type_Long, true, "yyyy-MM-dd") }));
          }
        }
        q();
      }
      else
      {
        if (this.h) {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(1, true);
        }
        if (this.jdField_k_of_type_Int == 0) {
          paramInt = 2131694709;
        } else {
          paramInt = 2131698905;
        }
        if (i1 == 1) {
          if (this.jdField_k_of_type_Int == 0) {
            paramInt = 2131694709;
          } else {
            paramInt = 2131698885;
          }
        }
        a(getString(paramInt), 1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.getItemCount() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyDataSetChanged();
      if ((!this.h) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView != null))
      {
        paramInt = i2;
        if (paramBoolean1) {
          paramInt = 2131698907;
        }
        if (i1 == 1) {
          if (paramBoolean1) {
            paramInt = 2131698886;
          } else {
            paramInt = 2131698885;
          }
        }
        paramString = getResources().getString(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(paramString);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.b();
        j(0);
      }
      this.g = false;
      h();
      c(true);
    }
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a(2);
    Object localObject2 = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if ((localObject2 != null) && (((CacheData)localObject2).jdField_a_of_type_JavaUtilList != null) && (((CacheData)localObject2).jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Object localObject1;
      if (paramBoolean)
      {
        localObject1 = ((CacheData)localObject2).a();
        paramString = (String)localObject1;
        if (localObject1 != null)
        {
          paramString = (String)localObject1;
          if (((CacheData.TagCache)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
          {
            paramString = (String)localObject1;
            if (!localList.contains(((CacheData.TagCache)localObject1).jdField_a_of_type_JavaLangString)) {}
          }
        }
      }
      boolean bool;
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        bool = true;
        break;
        do
        {
          do
          {
            bool = false;
            break;
            localObject1 = ((CacheData)localObject2).a(paramString);
            paramString = (String)localObject1;
          } while (localObject1 == null);
          paramString = (String)localObject1;
        } while (((CacheData.TagCache)localObject1).jdField_a_of_type_JavaUtilList.size() <= 0);
      }
      if (bool)
      {
        this.jdField_a_of_type_Boolean = ((CacheData)localObject2).jdField_a_of_type_Boolean;
        this.jdField_b_of_type_Boolean = ((CacheData)localObject2).jdField_b_of_type_Boolean;
        this.jdField_l_of_type_Int = ((CacheData)localObject2).jdField_a_of_type_Int;
        this.jdField_i_of_type_Boolean = paramString.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ArrayOfByte = paramString.jdField_a_of_type_ArrayOfByte;
        this.jdField_f_of_type_Long = paramString.jdField_a_of_type_Long;
        this.m = paramString.jdField_a_of_type_Int;
        this.jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        int i1 = paramString.jdField_b_of_type_Int;
        int i2 = paramString.jdField_c_of_type_Int;
        if (paramString.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localObject1 = (StrangerInfo)paramString.jdField_a_of_type_JavaUtilList.get(0);
          if ((localObject1 instanceof MatchFeedInfo))
          {
            localObject1 = (MatchFeedInfo)localObject1;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo;
            if (localObject2 != localObject1)
            {
              ((MatchFeedInfo)localObject2).jdField_a_of_type_Int = ((MatchFeedInfo)localObject1).jdField_a_of_type_Int;
              this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_b_of_type_Int = ((MatchFeedInfo)localObject1).jdField_b_of_type_Int;
              this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_c_of_type_Int = ((MatchFeedInfo)localObject1).jdField_c_of_type_Int;
              this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_JavaUtilList.clear();
              this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_JavaUtilList.addAll(((MatchFeedInfo)localObject1).jdField_a_of_type_JavaUtilList);
              this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_JavaUtilList);
            }
          }
        }
        if (paramBoolean)
        {
          int i3 = localList.indexOf(this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.setSearchTags((ArrayList)localList, i3);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter != null)
        {
          if (this.jdField_i_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(2, false);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(0, false);
          }
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a();
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(paramString.jdField_a_of_type_JavaUtilList);
          p();
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyDataSetChanged();
          if (Math.abs(System.currentTimeMillis() - this.jdField_f_of_type_Long) < 60000L) {
            this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new ExtendFriendSquareFragment.9(this, i1, i2), 100L);
          }
          h();
          c(true);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
          if (paramString != null) {
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131719248), TimeFormatterUtils.a(this.jdField_f_of_type_Long, true, "yyyy-MM-dd") }));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendSquareFragment", 2, String.format("loadCacheData result=%b ts=%d tag=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.jdField_f_of_type_Long), this.jdField_b_of_type_JavaLangString }));
      }
      return bool;
    }
    return false;
  }
  
  private boolean b()
  {
    int i1 = this.m;
    boolean bool = false;
    if (i1 < 0) {
      return false;
    }
    if (Calendar.getInstance().get(6) != this.m) {
      bool = true;
    }
    return bool;
  }
  
  private void j(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView;
    int i1 = 0;
    localObject = ((PullToRefreshRecyclerView)localObject).a(true, false);
    if (paramInt == 1) {
      i1 = 1;
    }
    if (i1 != 0) {
      i1 = 2131698887;
    } else {
      i1 = 2131698906;
    }
    ((ILoadingLayout)localObject).setRefreshingLabel(getResources().getString(i1));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setTag(2131376308, Integer.valueOf(paramInt));
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    Object localObject = new FeedBannerTabItem();
    ((FeedBannerTabItem)localObject).jdField_a_of_type_Int = 0;
    ((FeedBannerTabItem)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131698843);
    ((FeedBannerTabItem)localObject).jdField_b_of_type_Int = -20771;
    ((FeedBannerTabItem)localObject).jdField_c_of_type_Int = -31578;
    ((FeedBannerTabItem)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ExpandBannerConfBean.BannerItem localBannerItem = (ExpandBannerConfBean.BannerItem)((Iterator)localObject).next();
        FeedBannerTabItem localFeedBannerTabItem = new FeedBannerTabItem();
        localFeedBannerTabItem.jdField_a_of_type_JavaLangString = localBannerItem.title;
        localFeedBannerTabItem.jdField_a_of_type_Long = localBannerItem.id;
        localFeedBannerTabItem.jdField_b_of_type_JavaLangString = localBannerItem.subTitle;
        if ("0".equals(localBannerItem.type)) {
          localFeedBannerTabItem.jdField_a_of_type_Int = 0;
        } else if ("1".equals(localBannerItem.type)) {
          localFeedBannerTabItem.jdField_a_of_type_Int = 1;
        } else if ("2".equals(localBannerItem.type)) {
          localFeedBannerTabItem.jdField_a_of_type_Int = 2;
        } else if ("3".equals(localBannerItem.type)) {
          localFeedBannerTabItem.jdField_a_of_type_Int = 3;
        } else {
          localFeedBannerTabItem.jdField_a_of_type_Int = -1;
        }
        localFeedBannerTabItem.d = localBannerItem.schemeOrUrl;
        localFeedBannerTabItem.jdField_c_of_type_JavaLangString = localBannerItem.iconUrl;
        localFeedBannerTabItem.jdField_a_of_type_OrgJsonJSONObject = localBannerItem.extra;
        try
        {
          if (localBannerItem.bgBeginColor != null) {
            localFeedBannerTabItem.jdField_b_of_type_Int = Color.parseColor(localBannerItem.bgBeginColor);
          }
          if (localBannerItem.bgEndColor != null) {
            localFeedBannerTabItem.jdField_c_of_type_Int = Color.parseColor(localBannerItem.bgEndColor);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse banner color ");
            localStringBuilder.append(localException);
            QLog.d("ExtendFriendSquareFragment", 2, localStringBuilder.toString());
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList.add(localFeedBannerTabItem);
      }
    }
  }
  
  private void n()
  {
    if (isAdded())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter == null) {
        return;
      }
      if (this.jdField_j_of_type_Boolean) {
        return;
      }
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          j(1);
          if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.d())
          {
            b(false);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setRefreshing();
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(0, true);
        }
      }
      else
      {
        this.jdField_k_of_type_Int = 0;
        o();
      }
    }
  }
  
  private void o()
  {
    a(false, this.jdField_b_of_type_JavaLangString, false, null, false, false, 0, null, null);
  }
  
  private void p()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void q()
  {
    IExpandManager localIExpandManager = (IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    Object localObject2 = localIExpandManager.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new CacheData();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter != null)
    {
      localObject2 = new CacheData.TagCache();
      ((CacheData.TagCache)localObject2).jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a());
      ((CacheData.TagCache)localObject2).jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      ((CacheData.TagCache)localObject2).jdField_a_of_type_Int = this.m;
      ((CacheData.TagCache)localObject2).jdField_a_of_type_Boolean = this.jdField_i_of_type_Boolean;
      ((CacheData.TagCache)localObject2).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((CacheData.TagCache)localObject2).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((CacheData.TagCache)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      if (((CacheData.TagCache)localObject2).jdField_b_of_type_Int < 0) {
        ((CacheData.TagCache)localObject2).jdField_b_of_type_Int = 0;
      }
      View localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(((CacheData.TagCache)localObject2).jdField_b_of_type_Int);
      if (localView != null) {
        ((CacheData.TagCache)localObject2).jdField_c_of_type_Int = localView.getTop();
      }
      ((CacheData)localObject1).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      ((CacheData)localObject1).jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
      ((CacheData)localObject1).jdField_a_of_type_Int = this.jdField_l_of_type_Int;
      ((CacheData)localObject1).a((CacheData.TagCache)localObject2, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_l_of_type_Int);
    }
    localIExpandManager.a((CacheData)localObject1);
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        localObject1 = "null";
      } else {
        localObject1 = ((CacheData)localObject1).toString();
      }
      QLog.i("ExtendFriendSquareFragment", 2, String.format("saveCacheData %s", new Object[] { localObject1 }));
    }
  }
  
  private void r()
  {
    List localList;
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager != null) {
      localList = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a(2);
    } else {
      localList = null;
    }
    if (localList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.setSearchTags((ArrayList)localList, 0);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.post(new ExtendFriendSquareFragment.10(this));
    }
  }
  
  protected int a()
  {
    return 1031;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "limitchat enter match");
    }
    if (a())
    {
      ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DD", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, "onMatchItemClick, showExtendFriendQuestionDialog");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandTabFragment$OnTabRequiredListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandTabFragment$OnTabRequiredListener.a();
      ExtendFriendReport.a().b(2);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
  }
  
  public void a(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    ExtendFriendCampusVerifyTipsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPullDownToRefresh  mRecyclerViewScrollY:");
      localStringBuilder.append(this.jdField_i_of_type_Int);
      QLog.d("ExtendFriendSquareFragment", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPullDownToRefresh state:");
      localStringBuilder.append(paramPullToRefreshBase.a());
      localStringBuilder.append(" lastCacheOk:");
      localStringBuilder.append(this.jdField_j_of_type_Boolean);
      QLog.i("ExtendFriendSquareFragment", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
      f();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if ((paramPullToRefreshBase.a() == PullToRefreshBase.State.MANUAL_REFRESHING) && (this.jdField_j_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.b();
    }
    else if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
    {
      b(false);
      j();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(0, true);
    }
    else
    {
      this.jdField_k_of_type_Int = 0;
      o();
    }
    a(this.jdField_i_of_type_Int, 0.0F);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if ((paramBoolean1) || (paramBoolean2)) {
      q();
    }
  }
  
  protected int b()
  {
    return this.jdField_l_of_type_Int;
  }
  
  public void b(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    p();
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel())
    {
      paramPullToRefreshBase = new StringBuilder();
      paramPullToRefreshBase.append("onPullUpToRefresh  mRecyclerViewScrollY:");
      paramPullToRefreshBase.append(this.jdField_i_of_type_Int);
      QLog.d("ExtendFriendSquareFragment", 2, paramPullToRefreshBase.toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("requestSquareStrangerList loadMore=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.h = paramBoolean;
    if (!this.h)
    {
      this.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkIExpandHandler != null)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkIExpandHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, "推荐", true);
      this.g = true;
    }
  }
  
  protected void c()
  {
    LinearLayoutManager localLinearLayoutManager = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
    boolean bool3 = false;
    boolean bool1 = false;
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool2 = bool3;
    Object localObject2 = localObject3;
    if (localLinearLayoutManager != null)
    {
      bool2 = bool3;
      localObject2 = localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter != null)
      {
        int i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
        int i2 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
        for (;;)
        {
          bool2 = bool1;
          localObject2 = localObject1;
          if (i1 > i2) {
            break;
          }
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(i1);
          localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(i1);
          if ((localObject3 != null) && (localObject2 != null) && ((localObject2 instanceof FeedViewHolder)))
          {
            localObject2 = (FeedViewHolder)localObject2;
            localObject3 = a(((StrangerInfo)localObject3).mUin, ((StrangerInfo)localObject3).mNickName, ((FeedViewHolder)localObject2).a);
            ((FeedViewHolder)localObject2).a.setImageDrawable((Drawable)localObject3);
            bool2 = bool1;
            localObject2 = localObject1;
          }
          else
          {
            bool2 = bool1;
            localObject2 = localObject1;
            if ((localObject3 instanceof FeedBannerInfo))
            {
              localObject3 = ((FeedBannerInfo)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
              do
              {
                bool2 = bool1;
                localObject2 = localObject1;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject2 = (FeedBannerTabItem)((Iterator)localObject3).next();
              } while (((FeedBannerTabItem)localObject2).jdField_a_of_type_Int != 0);
              localObject2 = ((FeedBannerTabItem)localObject2).jdField_a_of_type_JavaUtilArrayList;
              bool2 = true;
            }
          }
          i1 += 1;
          bool1 = bool2;
          localObject1 = localObject2;
        }
      }
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendBottomBarView.a(bool2);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendBottomBarView.a((List)localObject2);
    }
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) {
      return 0;
    }
    int i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
    View localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(i1);
    if (localView != null) {
      return i1 * localView.getHeight() - (localView.getTop() - AIOUtils.b(11.0F, getResources()));
    }
    return 0;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_Boolean) || (paramBoolean))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView != null) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.getHeight());
      }
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 11) {
      n();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 1031)
    {
      l();
      a(true, true);
      if (paramInt2 == 8193) {
        k();
      }
      this.d = -1;
      return;
    }
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(this.jdField_c_of_type_Int);
      if ((paramIntent != null) && (!paramIntent.mAddFriendVerified))
      {
        paramIntent.mAddFriendVerified = true;
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyItemChanged(this.jdField_c_of_type_Int);
      }
    }
    else
    {
      if ((paramInt1 == 2) && (paramInt2 == -1))
      {
        a(false, true);
        return;
      }
      if ((paramInt1 == 3) && (paramInt2 == -1) && (paramIntent != null))
      {
        if (paramIntent.getBooleanExtra("has_entered_profile", false)) {
          a(true, true);
        }
        if (paramIntent.hasExtra("add_frd_list")) {
          a(paramIntent.getStringArrayListExtra("add_frd_list"));
        }
        if (paramIntent.hasExtra("remain_match_count"))
        {
          paramInt1 = paramIntent.getIntExtra("remain_match_count", 0);
          if (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_Int)
          {
            this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_Int = paramInt1;
            if (QLog.isColorLevel()) {
              QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update remainMatchCount=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_a_of_type_Int) }));
            }
          }
        }
        if (paramIntent.hasExtra("limit_chat_duration"))
        {
          paramInt1 = paramIntent.getIntExtra("limit_chat_duration", 0);
          if (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_b_of_type_Int)
          {
            this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_b_of_type_Int = paramInt1;
            if (QLog.isColorLevel()) {
              QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update limitChatDuration=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanMatchMatchFeedInfo.jdField_b_of_type_Int) }));
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
      ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    }
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter = new ExtendFriendReporter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    m();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreateView");
    }
    this.n = AIOUtils.b(35.0F, getResources());
    this.jdField_j_of_type_Int = AIOUtils.b(160.0F, getResources());
    paramLayoutInflater = paramLayoutInflater.inflate(2131561093, null);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131373271));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new WrapContentLinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131376308);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new ExtendFriendSquareFragment.3(this));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewItemDecoration = new RecyclerViewItemDecoration(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new ExtendFriendSquareFragment.4(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter = new RecyclerViewAdapter(this, this, this, this, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 0, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(AIOUtils.b(0.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNearbyZanAnimLayout = ((NearbyZanAnimLayout)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.findViewById(2131368151));
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.findViewById(2131365187);
    if (paramViewGroup != null) {
      paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ExtendFriendSquareFragment.5(this, paramViewGroup));
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView = ((ExpandSearchBarView)paramLayoutInflater.findViewById(2131377019));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.setItemClickListener(new ExtendFriendSquareFragment.6(this));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendBottomBarView = ((ExtendFriendBottomBarView)paramLayoutInflater.findViewById(2131363715));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetPulltorefreshExtrasPullToRefreshRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendBottomBarView.setOnClickListener(new ExtendFriendSquareFragment.7(this));
    a(paramViewGroup);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onDestroy");
    }
    super.onDestroy();
    ExtendFriendReporter localExtendFriendReporter = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter;
    if (localExtendFriendReporter != null)
    {
      localExtendFriendReporter.a();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkIExpandHandler = null;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onResume");
    }
    super.onResume();
    if ((!this.jdField_f_of_type_Boolean) && (isAdded()))
    {
      boolean bool = a(true, null);
      long l1 = System.currentTimeMillis() - this.jdField_f_of_type_Long;
      if ((bool) && (l1 <= 60000L) && (!b()))
      {
        this.jdField_j_of_type_Boolean = true;
      }
      else
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_b_of_type_JavaLangString = "推荐";
        List localList = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a(2);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.setSearchTags((ArrayList)localList, 0);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(11);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(11, 500L);
      }
      this.jdField_f_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("onResume loadSuccess=%s interval=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) }));
      }
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new ExtendFriendSquareFragment.8(this), 100L);
    }
    else if (b())
    {
      this.jdField_j_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(11);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(11, 500L);
    }
    else
    {
      p();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyDataSetChanged();
    }
    a(this.jdField_i_of_type_Int, 0.0F);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#voice_tab#view", true, -1L, -1L, null, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment
 * JD-Core Version:    0.7.0.1
 */