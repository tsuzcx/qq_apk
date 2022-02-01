package com.tencent.mobileqq.extendfriend.fragment;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.extendfriend.bean.EmptyViewHoder;
import com.tencent.mobileqq.extendfriend.bean.ExtendFriendAdvInfoHolder;
import com.tencent.mobileqq.extendfriend.bean.FaceFetch;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerInfo;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerTabItem;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerViewHolder;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerViewHolder.FeedBannerClickListener;
import com.tencent.mobileqq.extendfriend.bean.FeedCampusVerifyHolder;
import com.tencent.mobileqq.extendfriend.bean.FeedCampusVerifyInfo;
import com.tencent.mobileqq.extendfriend.bean.FeedViewHolder;
import com.tencent.mobileqq.extendfriend.bean.FooterViewHolder;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommViewHolder;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFooterView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.widget.VipGeneralGdtShowView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private FaceFetch jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFaceFetch;
  private FeedBannerViewHolder.FeedBannerClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder$FeedBannerClickListener;
  private FeedBannerViewHolder jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder;
  private MiniAppRecommInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo;
  private StrangerInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo;
  private ExtendFriendReporter jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter;
  private SquareItemClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener;
  ExtendFriendCampusVerifyTipsView.OnClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$OnClickListener;
  private List<StrangerInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private int c = 0;
  
  public RecyclerViewAdapter(FaceFetch paramFaceFetch, SquareItemClickListener paramSquareItemClickListener, FeedBannerViewHolder.FeedBannerClickListener paramFeedBannerClickListener, ExtendFriendCampusVerifyTipsView.OnClickListener paramOnClickListener, RecyclerView paramRecyclerView, Activity paramActivity, int paramInt, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFaceFetch = paramFaceFetch;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo = new StrangerInfo();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo.mType = 1;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener = paramSquareItemClickListener;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder$FeedBannerClickListener = paramFeedBannerClickListener;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = paramGdtAppReceiver;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(String paramString)
  {
    int j = -1;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        j = -1;
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramString.equals(((StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mUin)) {
            j = i;
          }
          i += 1;
        }
        i = j;
      }
    }
    return i;
  }
  
  public StrangerInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < i) {
          localObject1 = (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public List<StrangerInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, StrangerInfo paramStrangerInfo)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramStrangerInfo);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo.mFooterType = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(FeedBannerTabItem paramFeedBannerTabItem)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder.itemView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder.a(paramFeedBannerTabItem);
    }
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo)
  {
    int k = 1;
    int j = 0;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramMiniAppRecommInfo == null)) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(i) instanceof MiniAppRecommInfo)) {
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
    }
    for (i = 1;; i = 0)
    {
      if (paramMiniAppRecommInfo.appInfoList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo = paramMiniAppRecommInfo;
        label81:
        if (j >= getItemCount()) {
          break label139;
        }
        if (getItemViewType(j) == 0)
        {
          this.jdField_a_of_type_JavaUtilList.add(j, paramMiniAppRecommInfo);
          i = k;
        }
      }
      label139:
      for (;;)
      {
        if (i == 0) {
          break label140;
        }
        notifyDataSetChanged();
        return;
        i += 1;
        break;
        j += 1;
        break label81;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo = null;
      }
      label140:
      break;
    }
  }
  
  public void a(ExtendFriendReporter paramExtendFriendReporter)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter = paramExtendFriendReporter;
  }
  
  public void a(List<StrangerInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramInt);
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return 2;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof MiniAppRecommInfo)) {
        return 5;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof FeedBannerInfo)) {
        return 6;
      }
      if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof FeedCampusVerifyInfo)) {
        return 7;
      }
      if (((StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mAlumbasicdata != null) {
        return 4;
      }
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      Object localObject1 = (FeedViewHolder)paramViewHolder;
      Object localObject2 = (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((FeedViewHolder)localObject1).a((FeedViewHolder)localObject1, (StrangerInfo)localObject2, i);
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.c() == paramInt) && (!((FeedViewHolder)localObject1).a.b())) {
        ((FeedViewHolder)localObject1).a.c();
      }
      while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendReporter.a(((StrangerInfo)localObject2).mUin);
        break;
        ((FeedViewHolder)localObject1).a.d();
      }
      localObject1 = (FooterViewHolder)paramViewHolder;
      ((FooterViewHolder)localObject1).a((FooterViewHolder)localObject1, this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo);
      continue;
      localObject1 = (EmptyViewHoder)paramViewHolder;
      ((EmptyViewHoder)localObject1).a((EmptyViewHoder)localObject1, null, this.c);
      continue;
      localObject1 = (MiniAppRecommViewHolder)paramViewHolder;
      localObject2 = (MiniAppRecommInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = j;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((MiniAppRecommViewHolder)localObject1).a((MiniAppRecommInfo)localObject2, i);
      continue;
      localObject1 = (ExtendFriendAdvInfoHolder)paramViewHolder;
      localObject2 = (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = k;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((ExtendFriendAdvInfoHolder)localObject1).a((ExtendFriendAdvInfoHolder)localObject1, (StrangerInfo)localObject2, i);
      continue;
      localObject1 = (FeedBannerViewHolder)paramViewHolder;
      localObject2 = (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = m;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((FeedBannerViewHolder)localObject1).a((StrangerInfo)localObject2, i);
      continue;
      localObject1 = (FeedCampusVerifyHolder)paramViewHolder;
      localObject2 = (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      i = n;
      if (paramInt == 0) {
        i = this.jdField_a_of_type_Int;
      }
      ((FeedCampusVerifyHolder)localObject1).a((StrangerInfo)localObject2, i);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    Object localObject = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 3: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
      do
      {
        return null;
        paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new FeedViewHolder(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener, this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFaceFetch, this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup = new ExtendFriendFooterView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.setLayoutParams(localLayoutParams);
        return new FooterViewHolder(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener);
        return new EmptyViewHoder(((LayoutInflater)localObject).inflate(2131561213, paramViewGroup, false), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener, this.b);
        paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
        paramViewGroup.removeAllViews();
        localObject = new VipGeneralGdtShowView(this.jdField_a_of_type_AndroidAppActivity, 2131563211, 3, 1, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      } while (((VipGeneralGdtShowView)localObject).a() == null);
      paramViewGroup.addView(((VipGeneralGdtShowView)localObject).a(), localLayoutParams);
      return new ExtendFriendAdvInfoHolder(paramViewGroup, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener, (VipGeneralGdtShowView)localObject);
    case 5: 
      return new MiniAppRecommViewHolder(((LayoutInflater)localObject).inflate(2131559508, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity);
    case 6: 
      paramViewGroup = new TabLayout(this.jdField_a_of_type_AndroidAppActivity);
      paramViewGroup.setLayoutParams(localLayoutParams);
      paramViewGroup = new FeedBannerViewHolder(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder$FeedBannerClickListener);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanFeedBannerViewHolder = ((FeedBannerViewHolder)paramViewGroup);
      return paramViewGroup;
    }
    paramViewGroup = new ExtendFriendCampusVerifyTipsView(this.jdField_a_of_type_AndroidAppActivity);
    paramViewGroup.setLayoutParams(localLayoutParams);
    return new FeedCampusVerifyHolder(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView$OnClickListener);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((paramViewHolder instanceof FeedBannerViewHolder)) {
      ((FeedBannerViewHolder)paramViewHolder).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.RecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */