package com.tencent.mobileqq.qqexpand.fragment;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.feed.EmptyViewHoder;
import com.tencent.mobileqq.qqexpand.feed.ExtendFriendAdvInfoHolder;
import com.tencent.mobileqq.qqexpand.feed.FaceFetch;
import com.tencent.mobileqq.qqexpand.feed.FeedBannerInfo;
import com.tencent.mobileqq.qqexpand.feed.FeedBannerTabItem;
import com.tencent.mobileqq.qqexpand.feed.FeedBannerViewHolder;
import com.tencent.mobileqq.qqexpand.feed.FeedBannerViewHolder.FeedBannerClickListener;
import com.tencent.mobileqq.qqexpand.feed.FeedCampusVerifyHolder;
import com.tencent.mobileqq.qqexpand.feed.FeedCampusVerifyInfo;
import com.tencent.mobileqq.qqexpand.feed.FeedViewHolder;
import com.tencent.mobileqq.qqexpand.feed.FooterViewHolder;
import com.tencent.mobileqq.qqexpand.feed.MiniAppRecommViewHolder;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView.OnClickListener;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendFeedView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendFooterView;
import com.tencent.mobileqq.qqexpand.widget.TabLayout;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
import cooperation.vip.widget.VipGeneralGdtShowView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private MiniAppRecommInfo jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedMiniAppRecommInfo;
  private final StrangerInfo jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo;
  private final FaceFetch jdField_a_of_type_ComTencentMobileqqQqexpandFeedFaceFetch;
  private final FeedBannerViewHolder.FeedBannerClickListener jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder$FeedBannerClickListener;
  private FeedBannerViewHolder jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder;
  private ExtendFriendReporter jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter;
  private final SquareItemClickListener jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener;
  ExtendFriendCampusVerifyTipsView.OnClickListener jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$OnClickListener;
  private final List<StrangerInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private int c = 0;
  
  public RecyclerViewAdapter(FaceFetch paramFaceFetch, SquareItemClickListener paramSquareItemClickListener, FeedBannerViewHolder.FeedBannerClickListener paramFeedBannerClickListener, ExtendFriendCampusVerifyTipsView.OnClickListener paramOnClickListener, RecyclerView paramRecyclerView, Activity paramActivity, int paramInt, GdtAppReceiver paramGdtAppReceiver)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFaceFetch = paramFaceFetch;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramInt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo = new StrangerInfo();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo.mType = 1;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener = paramSquareItemClickListener;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder$FeedBannerClickListener = paramFeedBannerClickListener;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = paramGdtAppReceiver;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(String paramString)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    int j = -1;
    int k = j;
    if (localList != null)
    {
      k = j;
      if (localList.size() > 0)
      {
        int i = 0;
        for (;;)
        {
          k = j;
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break;
          }
          if (paramString.equals(((StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mUin)) {
            j = i;
          }
          i += 1;
        }
      }
    }
    return k;
  }
  
  public StrangerInfo a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      int i = localList.size();
      if ((paramInt >= 0) && (paramInt < i)) {
        return (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    return null;
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
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo.mFooterType = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (paramMiniAppRecommInfo == null) {
        return;
      }
      int j = 0;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(i) instanceof MiniAppRecommInfo))
        {
          this.jdField_a_of_type_JavaUtilList.remove(i);
          i = 1;
          break label73;
        }
        i += 1;
      }
      i = 0;
      label73:
      if (paramMiniAppRecommInfo.appInfoList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedMiniAppRecommInfo = paramMiniAppRecommInfo;
        for (;;)
        {
          k = i;
          if (j >= getItemCount()) {
            break;
          }
          if (getItemViewType(j) == 0)
          {
            this.jdField_a_of_type_JavaUtilList.add(j, paramMiniAppRecommInfo);
            k = 1;
            break;
          }
          j += 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedMiniAppRecommInfo = null;
      int k = i;
      if (k != 0) {
        notifyDataSetChanged();
      }
    }
  }
  
  public void a(FeedBannerTabItem paramFeedBannerTabItem)
  {
    FeedBannerViewHolder localFeedBannerViewHolder = this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder;
    if ((localFeedBannerViewHolder != null) && (localFeedBannerViewHolder.itemView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder.a(paramFeedBannerTabItem);
    }
  }
  
  public void a(ExtendFriendReporter paramExtendFriendReporter)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter = paramExtendFriendReporter;
  }
  
  public void a(List<StrangerInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedMiniAppRecommInfo;
    if (paramList != null) {
      a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    FeedBannerViewHolder localFeedBannerViewHolder = this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder;
    if (localFeedBannerViewHolder != null) {
      localFeedBannerViewHolder.a();
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
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      return i + 1;
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return 0;
      }
    }
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
    int i1 = getItemViewType(paramInt);
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 4)
          {
            if (i1 != 5)
            {
              if (i1 != 6)
              {
                if (i1 != 7) {
                  return;
                }
                paramViewHolder = (FeedCampusVerifyHolder)paramViewHolder;
                localObject = (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
                if (paramInt == 0) {
                  i = this.jdField_a_of_type_Int;
                }
                paramViewHolder.a((StrangerInfo)localObject, i);
                return;
              }
              paramViewHolder = (FeedBannerViewHolder)paramViewHolder;
              localObject = (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
              i = j;
              if (paramInt == 0) {
                i = this.jdField_a_of_type_Int;
              }
              paramViewHolder.a((StrangerInfo)localObject, i);
              return;
            }
            paramViewHolder = (MiniAppRecommViewHolder)paramViewHolder;
            localObject = (MiniAppRecommInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
            i = k;
            if (paramInt == 0) {
              i = this.jdField_a_of_type_Int;
            }
            paramViewHolder.a((MiniAppRecommInfo)localObject, i);
            return;
          }
          paramViewHolder = (ExtendFriendAdvInfoHolder)paramViewHolder;
          localObject = (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          i = m;
          if (paramInt == 0) {
            i = this.jdField_a_of_type_Int;
          }
          paramViewHolder.a(paramViewHolder, (StrangerInfo)localObject, i);
          return;
        }
        paramViewHolder = (EmptyViewHoder)paramViewHolder;
        paramViewHolder.a(paramViewHolder, null, this.c);
        return;
      }
      paramViewHolder = (FooterViewHolder)paramViewHolder;
      paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo);
      return;
    }
    Object localObject = (FeedViewHolder)paramViewHolder;
    paramViewHolder = (StrangerInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    i = n;
    if (paramInt == 0) {
      i = this.jdField_a_of_type_Int;
    }
    ((FeedViewHolder)localObject).a((FeedViewHolder)localObject, paramViewHolder, i);
    SquareItemClickListener localSquareItemClickListener = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener;
    if ((localSquareItemClickListener != null) && (localSquareItemClickListener.c() == paramInt) && (!((FeedViewHolder)localObject).a.b())) {
      ((FeedViewHolder)localObject).a.c();
    } else {
      ((FeedViewHolder)localObject).a.d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendReporter;
    if (localObject != null) {
      ((ExtendFriendReporter)localObject).a(paramViewHolder.mUin);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = new ViewGroup.LayoutParams(-1, -2);
    Object localObject2 = LayoutInflater.from(paramViewGroup.getContext());
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6)
              {
                if (paramInt == 7)
                {
                  paramViewGroup = new ExtendFriendCampusVerifyTipsView(this.jdField_a_of_type_AndroidAppActivity);
                  paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  return new FeedCampusVerifyHolder(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetExtendFriendCampusVerifyTipsView$OnClickListener);
                }
              }
              else
              {
                paramViewGroup = new TabLayout(this.jdField_a_of_type_AndroidAppActivity);
                paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                paramViewGroup = new FeedBannerViewHolder(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder$FeedBannerClickListener);
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder;
                if (localObject1 != null) {
                  ((FeedBannerViewHolder)localObject1).a();
                }
                this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFeedBannerViewHolder = ((FeedBannerViewHolder)paramViewGroup);
                return paramViewGroup;
              }
            }
            else {
              return new MiniAppRecommViewHolder(((LayoutInflater)localObject2).inflate(2131559382, paramViewGroup, false), this.jdField_a_of_type_AndroidAppActivity);
            }
          }
          else
          {
            paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
            paramViewGroup.removeAllViews();
            localObject2 = new VipGeneralGdtShowView(this.jdField_a_of_type_AndroidAppActivity, 2131563035, 3, 1, this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
            if (((VipGeneralGdtShowView)localObject2).a() != null)
            {
              paramViewGroup.addView(((VipGeneralGdtShowView)localObject2).a(), (ViewGroup.LayoutParams)localObject1);
              return new ExtendFriendAdvInfoHolder(paramViewGroup, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener, (VipGeneralGdtShowView)localObject2);
            }
          }
          return null;
        }
        return new EmptyViewHoder(((LayoutInflater)localObject2).inflate(2131561078, paramViewGroup, false), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener, this.b);
      }
      paramViewGroup = new ExtendFriendFooterView(this.jdField_a_of_type_AndroidAppActivity);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return new FooterViewHolder(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener);
    }
    paramViewGroup = new ExtendFriendFeedView(this.jdField_a_of_type_AndroidAppActivity);
    paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    return new FeedViewHolder(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener, this.jdField_a_of_type_ComTencentMobileqqQqexpandFeedFaceFetch, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((paramViewHolder instanceof FeedBannerViewHolder)) {
      ((FeedBannerViewHolder)paramViewHolder).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.RecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */