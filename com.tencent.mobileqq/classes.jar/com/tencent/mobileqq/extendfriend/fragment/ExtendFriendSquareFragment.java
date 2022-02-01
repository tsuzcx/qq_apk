package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerConfBean.BannerItem;
import com.tencent.mobileqq.extendfriend.ExpandDTParamBuilder;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerInfo;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerTabItem;
import com.tencent.mobileqq.extendfriend.bean.FeedCampusVerifyInfo;
import com.tencent.mobileqq.extendfriend.bean.FeedViewHolder;
import com.tencent.mobileqq.extendfriend.bean.MatchFeedInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.pulltorefresh.ILoadingLayout;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.OnRefreshListener2;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.TipsType;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import com.tencent.mobileqq.extendfriend.wiget.WrapContentLinearLayoutManager;
import com.tencent.mobileqq.nearby.anim.NearbyZanAnimLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ExtendFriendSquareFragment
  extends ExtendFriendBaseFragment
  implements PullToRefreshBase.OnRefreshListener2<RecyclerView>, ExtendFriendCampusVerifyTipsView.OnClickListener
{
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ExtendFriendSquareFragment.2(this);
  private FeedBannerInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo = new FeedBannerInfo();
  private MatchFeedInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo = new MatchFeedInfo();
  private ExtendFriendReporter jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendSquareFragment.1(this);
  private ExtendFriendBottomBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView;
  private ExtendFriendSearchBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private WeakReferenceHandler b;
  public long e;
  public boolean e;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  public int h;
  private boolean h;
  public int i;
  private boolean i;
  private boolean j;
  private int jdField_k_of_type_Int = 1;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int = -1;
  private boolean jdField_m_of_type_Boolean = false;
  private int n;
  
  public ExtendFriendSquareFragment()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 480;
    this.jdField_e_of_type_Long = -1L;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
    Object localObject = new FeedBannerTabItem();
    ((FeedBannerTabItem)localObject).jdField_a_of_type_Int = 0;
    ((FeedBannerTabItem)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131698767);
    ((FeedBannerTabItem)localObject).jdField_b_of_type_Int = -20771;
    ((FeedBannerTabItem)localObject).jdField_c_of_type_Int = -31578;
    ((FeedBannerTabItem)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    localObject = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        ExtendFriendBannerConfBean.BannerItem localBannerItem = (ExtendFriendBannerConfBean.BannerItem)((Iterator)localObject).next();
        FeedBannerTabItem localFeedBannerTabItem = new FeedBannerTabItem();
        localFeedBannerTabItem.jdField_a_of_type_JavaLangString = localBannerItem.title;
        localFeedBannerTabItem.jdField_a_of_type_Long = localBannerItem.id;
        localFeedBannerTabItem.jdField_b_of_type_JavaLangString = localBannerItem.subTitle;
        if ("0".equals(localBannerItem.type)) {
          localFeedBannerTabItem.jdField_a_of_type_Int = 0;
        }
        for (;;)
        {
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
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendSquareFragment", 2, "parse banner color " + localException);
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo.jdField_a_of_type_JavaUtilArrayList.add(localFeedBannerTabItem);
          break;
          if ("1".equals(localBannerItem.type)) {
            localFeedBannerTabItem.jdField_a_of_type_Int = 1;
          } else if ("2".equals(localBannerItem.type)) {
            localFeedBannerTabItem.jdField_a_of_type_Int = 2;
          } else if ("3".equals(localBannerItem.type)) {
            localFeedBannerTabItem.jdField_a_of_type_Int = 3;
          } else {
            localFeedBannerTabItem.jdField_a_of_type_Int = -1;
          }
        }
      }
    }
  }
  
  private void a(int paramInt, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "updateSearchBarState scrollY: " + paramInt + "  speed: " + paramFloat);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null)
    {
      if (paramInt >= this.jdField_i_of_type_Int) {
        break label95;
      }
      if (paramInt <= this.n / 2) {
        break label85;
      }
      if (paramFloat > 0.0F) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.b();
      }
    }
    for (;;)
    {
      d(false);
      return;
      label85:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.a();
      continue;
      label95:
      if (paramFloat < -5.0F) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.a();
      } else if (paramFloat > 0.5D) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.b();
      }
    }
  }
  
  private void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, "voice_tab");
    VideoReport.setPageParams(paramView, new ExpandDTParamBuilder().a());
    QLog.i("ExtendFriendSquareFragment", 1, "reportDaTongRegister");
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendSquareFragment", 2, String.format("updateAddFrdState count=%d", new Object[] { Integer.valueOf(paramList.size()) }));
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        int i1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a((String)localObject);
        if (i1 >= 0)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(i1);
          if ((localObject != null) && (!((StrangerInfo)localObject).mAddFriendVerified))
          {
            ((StrangerInfo)localObject).mAddFriendVerified = true;
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyItemChanged(i1);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if ((!isAdded()) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter == null)) {
      return;
    }
    paramString = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getTag(2131376816);
    if ((paramString != null) && ((paramString instanceof Integer))) {}
    for (int i1 = ((Integer)paramString).intValue();; i1 = 0)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter;
      int i2;
      if (paramBoolean1)
      {
        i2 = 0;
        paramString.c(i2);
        if ((paramBoolean1) && (paramList != null)) {
          break label300;
        }
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(1, true);
        }
        if (this.jdField_k_of_type_Int != 0) {
          break label284;
        }
        paramInt = 2131694730;
        label134:
        if (i1 == 1)
        {
          if (this.jdField_k_of_type_Int != 0) {
            break label292;
          }
          paramInt = 2131694730;
        }
        label152:
        a(getString(paramInt), 1);
        label163:
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.getItemCount() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyDataSetChanged();
        if ((!this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null))
        {
          if (!paramBoolean1) {
            break label635;
          }
          paramInt = 2131698831;
          label211:
          if (i1 != 1) {
            break label651;
          }
          if (!paramBoolean1) {
            break label643;
          }
          paramInt = 2131698810;
        }
      }
      label643:
      label651:
      for (;;)
      {
        paramString = getResources().getString(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false).setRefreshResultLabel(paramString);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
        j(0);
        this.g = false;
        h();
        b(true);
        return;
        i2 = 1;
        break;
        label284:
        paramInt = 2131698829;
        break label134;
        label292:
        paramInt = 2131698809;
        break label152;
        label300:
        this.jdField_i_of_type_Boolean = paramBoolean2;
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.jdField_a_of_type_Boolean = paramBoolean3;
        this.jdField_b_of_type_Boolean = paramBoolean4;
        this.jdField_l_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_Int = paramMatchFeedInfo.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_b_of_type_Int = paramMatchFeedInfo.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_c_of_type_Int = paramMatchFeedInfo.jdField_c_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_JavaUtilList.addAll(paramMatchFeedInfo.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_JavaUtilList);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.jdField_i_of_type_Boolean), this.jdField_a_of_type_ArrayOfByte, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_l_of_type_Int), Integer.valueOf(paramMatchFeedInfo.jdField_a_of_type_Int), Integer.valueOf(paramMatchFeedInfo.jdField_b_of_type_Int) }));
        }
        if (!this.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a();
          p();
        }
        if (this.jdField_i_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(2, false);
        }
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
          if (paramString != null)
          {
            this.jdField_f_of_type_Long = System.currentTimeMillis();
            this.jdField_m_of_type_Int = Calendar.getInstance().get(6);
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131719530), TimeFormatterUtils.a(this.jdField_f_of_type_Long, true, "yyyy-MM-dd") }));
          }
        }
        q();
        break label163;
        label635:
        paramInt = 2131698829;
        break label211;
        paramInt = 2131698809;
      }
    }
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool2 = false;
    List localList = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(2);
    boolean bool1 = bool2;
    int i1;
    int i2;
    Object localObject;
    if (ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData != null)
    {
      bool1 = bool2;
      if (ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_a_of_type_JavaUtilList != null)
      {
        bool1 = bool2;
        if (ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          if (!paramBoolean) {
            break label567;
          }
          paramString = ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.a();
          if ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList.size() <= 0) || (!localList.contains(paramString.jdField_a_of_type_JavaLangString))) {
            break label561;
          }
          bool1 = true;
          if (bool1)
          {
            this.jdField_a_of_type_Boolean = ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_a_of_type_Boolean;
            this.jdField_b_of_type_Boolean = ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_b_of_type_Boolean;
            this.jdField_l_of_type_Int = ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_a_of_type_Int;
            this.jdField_i_of_type_Boolean = paramString.jdField_a_of_type_Boolean;
            this.jdField_a_of_type_ArrayOfByte = paramString.jdField_a_of_type_ArrayOfByte;
            this.jdField_f_of_type_Long = paramString.jdField_a_of_type_Long;
            this.jdField_m_of_type_Int = paramString.jdField_a_of_type_Int;
            this.jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
            i1 = paramString.jdField_b_of_type_Int;
            i2 = paramString.jdField_c_of_type_Int;
            if (paramString.jdField_a_of_type_JavaUtilList.size() > 0)
            {
              localObject = (StrangerInfo)paramString.jdField_a_of_type_JavaUtilList.get(0);
              if (!(localObject instanceof MatchFeedInfo)) {
                break label603;
              }
              localObject = (MatchFeedInfo)localObject;
              if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo != localObject)
              {
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_Int = ((MatchFeedInfo)localObject).jdField_a_of_type_Int;
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_b_of_type_Int = ((MatchFeedInfo)localObject).jdField_b_of_type_Int;
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_c_of_type_Int = ((MatchFeedInfo)localObject).jdField_c_of_type_Int;
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_JavaUtilList.clear();
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_JavaUtilList.addAll(((MatchFeedInfo)localObject).jdField_a_of_type_JavaUtilList);
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_JavaUtilList);
              }
            }
            label315:
            if (paramBoolean)
            {
              int i3 = localList.indexOf(this.jdField_b_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, i3);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter != null)
            {
              if (!this.jdField_i_of_type_Boolean) {
                break label621;
              }
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(2, false);
            }
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(paramString.jdField_a_of_type_JavaUtilList);
      p();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyDataSetChanged();
      if (Math.abs(System.currentTimeMillis() - this.jdField_f_of_type_Long) < 60000L) {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.postDelayed(new ExtendFriendSquareFragment.9(this, i1, i2), 100L);
      }
      h();
      b(true);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
        if (paramString != null) {
          paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131719530), TimeFormatterUtils.a(this.jdField_f_of_type_Long, true, "yyyy-MM-dd") }));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendSquareFragment", 2, String.format("loadCacheData result=%b ts=%d tag=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(this.jdField_f_of_type_Long), this.jdField_b_of_type_JavaLangString }));
      }
      return bool1;
      label561:
      bool1 = false;
      break;
      label567:
      paramString = ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.a(paramString);
      if ((paramString != null) && (paramString.jdField_a_of_type_JavaUtilList.size() > 0)) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
      label603:
      if (!(localObject instanceof FeedBannerInfo)) {
        break label315;
      }
      localObject = (FeedBannerInfo)localObject;
      break label315;
      label621:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(0, false);
    }
  }
  
  private boolean b()
  {
    if (this.jdField_m_of_type_Int < 0) {}
    while (Calendar.getInstance().get(6) == this.jdField_m_of_type_Int) {
      return false;
    }
    return true;
  }
  
  private void j(int paramInt)
  {
    int i1 = 1;
    ILoadingLayout localILoadingLayout = this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a(true, false);
    if (paramInt == 1) {
      if (i1 == 0) {
        break label59;
      }
    }
    label59:
    for (i1 = 2131698811;; i1 = 2131698830)
    {
      localILoadingLayout.setRefreshingLabel(getResources().getString(i1));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setTag(2131376816, Integer.valueOf(paramInt));
      return;
      i1 = 0;
      break;
    }
  }
  
  private void n()
  {
    if ((!isAdded()) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter == null)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_j_of_type_Boolean);
      if (!NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView == null);
    j(1);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.d())
    {
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setRefreshing();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(0, true);
    return;
    this.jdField_k_of_type_Int = 0;
    o();
  }
  
  private void o()
  {
    a(false, this.jdField_b_of_type_JavaLangString, false, null, false, false, 0, null, null);
  }
  
  private void p()
  {
    ExtendFriendManager localExtendFriendManager;
    boolean bool;
    Object localObject1;
    int i2;
    label144:
    Object localObject2;
    FeedBannerTabItem localFeedBannerTabItem;
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (ExtendFriendManager.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)))
    {
      if (this.jdField_j_of_type_Int != 0) {
        break label544;
      }
      localExtendFriendManager = (ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      bool = localExtendFriendManager.i();
      if (localExtendFriendManager.e() != 0) {
        break label469;
      }
      i1 = 1;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner limitChatSwitch=%s mTabPos=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jdField_j_of_type_Int) }));
      }
      if ((!bool) || (i1 == 0)) {
        break label582;
      }
      this.jdField_k_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(0);
      if (!(localObject1 instanceof FeedBannerInfo)) {
        break label474;
      }
      localObject1 = (FeedBannerInfo)localObject1;
      i2 = 0;
      i1 = i2;
      if (((FeedBannerInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject2 = ((FeedBannerInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localFeedBannerTabItem = (FeedBannerTabItem)((Iterator)localObject2).next();
            if (localFeedBannerTabItem.jdField_a_of_type_Int == 0)
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
                localFeedBannerTabItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_JavaUtilList);
              }
              localObject2 = localFeedBannerTabItem;
              if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_c_of_type_Int > 0)
              {
                if (((FeedBannerInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.size() > 1)
                {
                  localFeedBannerTabItem.jdField_b_of_type_JavaLangString = String.format(getResources().getString(2131698764), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_c_of_type_Int) });
                  localObject2 = localFeedBannerTabItem;
                }
              }
              else
              {
                label303:
                i1 = i2;
                if (localObject2 != null) {
                  this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a((FeedBannerTabItem)localObject2);
                }
              }
            }
          }
        }
      }
    }
    label544:
    label582:
    for (int i1 = i2;; i1 = 0)
    {
      bool = localExtendFriendManager.h();
      i2 = localExtendFriendManager.f();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("refreshFeedBanner needShowVerifyTips=%s verifyStatus=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i2) }));
      }
      if (this.jdField_k_of_type_Boolean)
      {
        i2 = 1;
        label378:
        if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(i2) instanceof FeedCampusVerifyInfo))
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.b(i2);
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 != 0) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyDataSetChanged();
        }
        if ((this.jdField_k_of_type_Boolean) && (!this.jdField_l_of_type_Boolean))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
          this.jdField_l_of_type_Boolean = true;
        }
        return;
        label469:
        i1 = 0;
        break;
        label474:
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(0, this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerInfo;
        i2 = 1;
        break label144;
        localFeedBannerTabItem.jdField_b_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_c_of_type_Int + getString(2131698792));
        localObject2 = localFeedBannerTabItem;
        break label303;
        i2 = 0;
        break label378;
        if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(0) instanceof FeedBannerInfo))
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.b(0);
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
      }
      localObject2 = null;
      break label303;
    }
  }
  
  private void q()
  {
    if (ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData == null) {
      ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData = new CacheData();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter != null)
    {
      localObject = new CacheData.TagCache();
      ((CacheData.TagCache)localObject).jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a());
      ((CacheData.TagCache)localObject).jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      ((CacheData.TagCache)localObject).jdField_a_of_type_Int = this.jdField_m_of_type_Int;
      ((CacheData.TagCache)localObject).jdField_a_of_type_Boolean = this.jdField_i_of_type_Boolean;
      ((CacheData.TagCache)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((CacheData.TagCache)localObject).jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((CacheData.TagCache)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      if (((CacheData.TagCache)localObject).jdField_b_of_type_Int < 0) {
        ((CacheData.TagCache)localObject).jdField_b_of_type_Int = 0;
      }
      View localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(((CacheData.TagCache)localObject).jdField_b_of_type_Int);
      if (localView != null) {
        ((CacheData.TagCache)localObject).jdField_c_of_type_Int = localView.getTop();
      }
      ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
      ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.jdField_a_of_type_Int = this.jdField_l_of_type_Int;
      ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.a((CacheData.TagCache)localObject, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_l_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      if (ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData != null) {
        break label221;
      }
    }
    label221:
    for (Object localObject = "null";; localObject = ExtendFriendManager.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentCacheData.toString())
    {
      QLog.i("ExtendFriendSquareFragment", 2, String.format("saveCacheData %s", new Object[] { localObject }));
      return;
    }
  }
  
  private void r()
  {
    List localList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager != null) {
      localList = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(2);
    }
    if (localList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
      this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.post(new ExtendFriendSquareFragment.10(this));
    }
  }
  
  protected int a()
  {
    return 1031;
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onPullDownToRefresh  mRecyclerViewScrollY:" + this.jdField_h_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, "onPullDownToRefresh state:" + paramPullToRefreshBase.a() + " lastCacheOk:" + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.hasMessages(10))
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(10);
      f();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if ((paramPullToRefreshBase.a() == PullToRefreshBase.State.MANUAL_REFRESHING) && (this.jdField_j_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.b();
    }
    for (;;)
    {
      a(this.jdField_h_of_type_Int, 0.0F);
      return;
      if (NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        a(false);
        k();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(0, true);
      }
      else
      {
        this.jdField_k_of_type_Int = 0;
        o();
      }
    }
  }
  
  public void a(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    ExtendFriendCampusVerifyTipsView.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("requestSquareStrangerList loadMore=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.jdField_h_of_type_Boolean = paramBoolean;
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendHandler != null)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long, ExtendFriendManager.jdField_a_of_type_JavaLangString, true);
      this.g = true;
    }
    if (!paramBoolean) {}
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if ((paramBoolean1) || (paramBoolean2)) {
      q();
    }
  }
  
  public void an_()
  {
    super.an_();
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
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener.a();
      ExtendFriendReport.a().b(2);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
  }
  
  protected int b()
  {
    return this.jdField_l_of_type_Int;
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onPullUpToRefresh  mRecyclerViewScrollY:" + this.jdField_h_of_type_Int);
    }
  }
  
  public void b(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    p();
  }
  
  protected void c()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    Object localObject2 = null;
    ArrayList localArrayList = null;
    Object localObject1 = localObject2;
    boolean bool2 = bool3;
    int i1;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager != null)
    {
      localObject1 = localObject2;
      bool2 = bool3;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter != null)
      {
        i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
        int i2 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findLastVisibleItemPosition();
        localObject1 = localArrayList;
        bool2 = bool1;
        if (i1 <= i2)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(i1);
          localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForPosition(i1);
          if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof FeedViewHolder)))
          {
            localObject2 = (FeedViewHolder)localObject2;
            localObject1 = a(((StrangerInfo)localObject1).mUin, ((StrangerInfo)localObject1).mNickName, ((FeedViewHolder)localObject2).a);
            ((FeedViewHolder)localObject2).a.setImageDrawable((Drawable)localObject1);
          }
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break;
      if ((localObject1 instanceof FeedBannerInfo))
      {
        localObject1 = ((FeedBannerInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FeedBannerTabItem)((Iterator)localObject1).next();
            if (((FeedBannerTabItem)localObject2).jdField_a_of_type_Int == 0)
            {
              bool1 = true;
              localArrayList = ((FeedBannerTabItem)localObject2).jdField_a_of_type_JavaUtilArrayList;
              break;
              if (this.jdField_k_of_type_Boolean)
              {
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(bool2);
                this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a((List)localObject1);
              }
              return;
            }
          }
        }
      }
    }
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager == null) {}
    int i1;
    View localView;
    do
    {
      return 0;
      i1 = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition();
      localView = this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findViewByPosition(i1);
    } while (localView == null);
    return localView.getHeight() * i1 - (localView.getTop() - AIOUtils.a(11.0F, getResources()));
  }
  
  public void d(boolean paramBoolean)
  {
    if ((!this.jdField_e_of_type_Boolean) || (paramBoolean))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.getHeight());
      }
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      n();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 1031)
    {
      m();
      a(true, true);
      if (paramInt2 == 8193) {
        l();
      }
      this.jdField_c_of_type_Int = -1;
    }
    do
    {
      do
      {
        return;
        if ((paramInt1 != 1) || (paramInt2 != -1)) {
          break;
        }
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(this.jdField_b_of_type_Int);
      } while ((paramIntent == null) || (paramIntent.mAddFriendVerified));
      paramIntent.mAddFriendVerified = true;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyItemChanged(this.jdField_b_of_type_Int);
      return;
      if ((paramInt1 == 2) && (paramInt2 == -1))
      {
        a(false, true);
        return;
      }
    } while ((paramInt1 != 3) || (paramInt2 != -1) || (paramIntent == null));
    if (paramIntent.getBooleanExtra("has_entered_profile", false)) {
      a(true, true);
    }
    if (paramIntent.hasExtra("add_frd_list")) {
      a(paramIntent.getStringArrayListExtra("add_frd_list"));
    }
    if (paramIntent.hasExtra("remain_match_count"))
    {
      paramInt1 = paramIntent.getIntExtra("remain_match_count", 0);
      if (paramInt1 != this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_Int = paramInt1;
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update remainMatchCount=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_a_of_type_Int) }));
        }
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramIntent.hasExtra("limit_chat_duration"))
      {
        paramInt2 = paramIntent.getIntExtra("limit_chat_duration", 0);
        if (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_b_of_type_Int = paramInt2;
          paramInt1 = i1;
          if (QLog.isColorLevel())
          {
            QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update limitChatDuration=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMatchFeedInfo.jdField_b_of_type_Int) }));
            paramInt1 = i1;
          }
        }
      }
      while ((paramInt1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter != null)) {
        return;
      }
      break;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    }
    this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter = new ExtendFriendReporter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreateView");
    }
    this.jdField_m_of_type_Boolean = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
    this.n = AIOUtils.a(35.0F, getResources());
    this.jdField_i_of_type_Int = AIOUtils.a(160.0F, getResources());
    paramLayoutInflater = paramLayoutInflater.inflate(2131561241, null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131373699));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    if (!this.jdField_m_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.jdField_a_of_type_Int = AIOUtils.a(35.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.jdField_b_of_type_Int = AIOUtils.a(-35.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setHeaderLayout(this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new WrapContentLinearLayoutManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setId(2131376816);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new ExtendFriendSquareFragment.3(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewItemDecoration = new RecyclerViewItemDecoration(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new ExtendFriendSquareFragment.4(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter = new RecyclerViewAdapter(this, this, this, this, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    if (this.jdField_m_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(AIOUtils.a(0.0F, getResources()));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqNearbyAnimNearbyZanAnimLayout = ((NearbyZanAnimLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131368400));
      paramViewGroup = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131365312);
      paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ExtendFriendSquareFragment.5(this, paramViewGroup));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView = ((ExtendFriendSearchBarView)paramLayoutInflater.findViewById(2131377575));
      if (this.jdField_m_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setItemClickListener(new ExtendFriendSquareFragment.6(this));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView = ((ExtendFriendBottomBarView)paramLayoutInflater.findViewById(2131363785));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.setOnClickListener(new ExtendFriendSquareFragment.7(this));
      a(paramViewGroup);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(AIOUtils.a(35.0F, getResources()));
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter.a();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.b();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendHandler = null;
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
      if ((!bool) || (l1 > 60000L) || (b()))
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_b_of_type_JavaLangString = ExtendFriendManager.jdField_a_of_type_JavaLangString;
        List localList = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(2);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(11);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(11, 500L);
        this.jdField_f_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("onResume loadSuccess=%s interval=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) }));
        }
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new ExtendFriendSquareFragment.8(this), 100L);
      }
    }
    for (;;)
    {
      a(this.jdField_h_of_type_Int, 0.0F);
      ExpandReportUtils.a("expose#voice_tab#view", true, -1L, -1L, null, true, true);
      return;
      this.jdField_j_of_type_Boolean = true;
      break;
      if (b())
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(11);
        this.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(11, 500L);
      }
      else
      {
        p();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment
 * JD-Core Version:    0.7.0.1
 */