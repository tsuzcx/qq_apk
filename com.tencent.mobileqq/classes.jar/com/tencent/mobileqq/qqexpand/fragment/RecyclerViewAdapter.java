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
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import cooperation.vip.widget.VipGeneralGdtShowView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  ExtendFriendCampusVerifyTipsView.OnClickListener a;
  private final FaceFetch b;
  private final SquareItemClickListener c;
  private final FeedBannerViewHolder.FeedBannerClickListener d;
  private final List<StrangerInfo> e;
  private final StrangerInfo f;
  private boolean g;
  private ExtendFriendReporter h;
  private final RecyclerView i;
  private final Activity j;
  private int k;
  private int l = 0;
  private MiniAppRecommInfo m;
  private int n = 0;
  private FeedBannerViewHolder o;
  private final GdtAppReceiver p;
  
  public RecyclerViewAdapter(FaceFetch paramFaceFetch, SquareItemClickListener paramSquareItemClickListener, FeedBannerViewHolder.FeedBannerClickListener paramFeedBannerClickListener, ExtendFriendCampusVerifyTipsView.OnClickListener paramOnClickListener, RecyclerView paramRecyclerView, Activity paramActivity, int paramInt, GdtAppReceiver paramGdtAppReceiver)
  {
    this.b = paramFaceFetch;
    this.i = paramRecyclerView;
    this.j = paramActivity;
    this.l = paramInt;
    this.e = new ArrayList();
    this.f = new StrangerInfo();
    this.f.mType = 1;
    this.c = paramSquareItemClickListener;
    this.d = paramFeedBannerClickListener;
    this.a = paramOnClickListener;
    this.k = 0;
    this.p = paramGdtAppReceiver;
  }
  
  public int a(String paramString)
  {
    List localList = this.e;
    int i2 = -1;
    int i3 = i2;
    if (localList != null)
    {
      i3 = i2;
      if (localList.size() > 0)
      {
        int i1 = 0;
        for (;;)
        {
          i3 = i2;
          if (i1 >= this.e.size()) {
            break;
          }
          if (paramString.equals(((StrangerInfo)this.e.get(i1)).mUin)) {
            i2 = i1;
          }
          i1 += 1;
        }
      }
    }
    return i3;
  }
  
  public List<StrangerInfo> a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(int paramInt, StrangerInfo paramStrangerInfo)
  {
    this.e.add(paramInt, paramStrangerInfo);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.f.mFooterType = paramInt;
    if ((paramBoolean) && (!this.e.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo)
  {
    if (this.e != null)
    {
      if (paramMiniAppRecommInfo == null) {
        return;
      }
      int i2 = 0;
      int i1 = 0;
      while (i1 < this.e.size())
      {
        if (((StrangerInfo)this.e.get(i1) instanceof MiniAppRecommInfo))
        {
          this.e.remove(i1);
          i1 = 1;
          break label73;
        }
        i1 += 1;
      }
      i1 = 0;
      label73:
      if (paramMiniAppRecommInfo.appInfoList.size() > 0)
      {
        this.m = paramMiniAppRecommInfo;
        for (;;)
        {
          i3 = i1;
          if (i2 >= getItemCount()) {
            break;
          }
          if (getItemViewType(i2) == 0)
          {
            this.e.add(i2, paramMiniAppRecommInfo);
            i3 = 1;
            break;
          }
          i2 += 1;
        }
      }
      this.m = null;
      int i3 = i1;
      if (i3 != 0) {
        notifyDataSetChanged();
      }
    }
  }
  
  public void a(FeedBannerTabItem paramFeedBannerTabItem)
  {
    FeedBannerViewHolder localFeedBannerViewHolder = this.o;
    if ((localFeedBannerViewHolder != null) && (localFeedBannerViewHolder.itemView != null)) {
      this.o.a(paramFeedBannerTabItem);
    }
  }
  
  public void a(ExtendFriendReporter paramExtendFriendReporter)
  {
    this.h = paramExtendFriendReporter;
  }
  
  public void a(List<StrangerInfo> paramList)
  {
    this.e.addAll(paramList);
    paramList = this.m;
    if (paramList != null) {
      a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int b()
  {
    return this.e.size();
  }
  
  public StrangerInfo b(int paramInt)
  {
    List localList = this.e;
    if (localList != null)
    {
      int i1 = localList.size();
      if ((paramInt >= 0) && (paramInt < i1)) {
        return (StrangerInfo)this.e.get(paramInt);
      }
    }
    return null;
  }
  
  public void c()
  {
    this.e.clear();
  }
  
  public void c(int paramInt)
  {
    this.e.remove(paramInt);
  }
  
  public void d()
  {
    FeedBannerViewHolder localFeedBannerViewHolder = this.o;
    if (localFeedBannerViewHolder != null) {
      localFeedBannerViewHolder.a();
    }
  }
  
  public void d(int paramInt)
  {
    this.n = paramInt;
  }
  
  public int getItemCount()
  {
    if (this.g) {}
    for (int i1 = this.e.size();; i1 = this.e.size())
    {
      return i1 + 1;
      if (this.e.isEmpty()) {
        return 0;
      }
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.e.size() == 0) {
      return 2;
    }
    if (paramInt < this.e.size())
    {
      if ((this.e.get(paramInt) instanceof MiniAppRecommInfo)) {
        return 5;
      }
      if ((this.e.get(paramInt) instanceof FeedBannerInfo)) {
        return 6;
      }
      if ((this.e.get(paramInt) instanceof FeedCampusVerifyInfo)) {
        return 7;
      }
      if (((StrangerInfo)this.e.get(paramInt)).mAlumbasicdata != null) {
        return 4;
      }
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i6 = getItemViewType(paramInt);
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i1 = 0;
    if (i6 != 0)
    {
      if (i6 != 1)
      {
        if (i6 != 2)
        {
          if (i6 != 4)
          {
            if (i6 != 5)
            {
              if (i6 != 6)
              {
                if (i6 != 7) {
                  return;
                }
                paramViewHolder = (FeedCampusVerifyHolder)paramViewHolder;
                localObject = (StrangerInfo)this.e.get(paramInt);
                if (paramInt == 0) {
                  i1 = this.k;
                }
                paramViewHolder.a((StrangerInfo)localObject, i1);
                return;
              }
              paramViewHolder = (FeedBannerViewHolder)paramViewHolder;
              localObject = (StrangerInfo)this.e.get(paramInt);
              i1 = i2;
              if (paramInt == 0) {
                i1 = this.k;
              }
              paramViewHolder.a((StrangerInfo)localObject, i1);
              return;
            }
            paramViewHolder = (MiniAppRecommViewHolder)paramViewHolder;
            localObject = (MiniAppRecommInfo)this.e.get(paramInt);
            i1 = i3;
            if (paramInt == 0) {
              i1 = this.k;
            }
            paramViewHolder.a((MiniAppRecommInfo)localObject, i1);
            return;
          }
          paramViewHolder = (ExtendFriendAdvInfoHolder)paramViewHolder;
          localObject = (StrangerInfo)this.e.get(paramInt);
          i1 = i4;
          if (paramInt == 0) {
            i1 = this.k;
          }
          paramViewHolder.a(paramViewHolder, (StrangerInfo)localObject, i1);
          return;
        }
        paramViewHolder = (EmptyViewHoder)paramViewHolder;
        paramViewHolder.a(paramViewHolder, null, this.n);
        return;
      }
      paramViewHolder = (FooterViewHolder)paramViewHolder;
      paramViewHolder.a(paramViewHolder, this.f);
      return;
    }
    Object localObject = (FeedViewHolder)paramViewHolder;
    paramViewHolder = (StrangerInfo)this.e.get(paramInt);
    i1 = i5;
    if (paramInt == 0) {
      i1 = this.k;
    }
    ((FeedViewHolder)localObject).a((FeedViewHolder)localObject, paramViewHolder, i1);
    SquareItemClickListener localSquareItemClickListener = this.c;
    if ((localSquareItemClickListener != null) && (localSquareItemClickListener.i() == paramInt) && (!((FeedViewHolder)localObject).k.d())) {
      ((FeedViewHolder)localObject).k.e();
    } else {
      ((FeedViewHolder)localObject).k.f();
    }
    localObject = this.h;
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
                  paramViewGroup = new ExtendFriendCampusVerifyTipsView(this.j);
                  paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  return new FeedCampusVerifyHolder(paramViewGroup, this.a);
                }
              }
              else
              {
                paramViewGroup = new TabLayout(this.j);
                paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                paramViewGroup = new FeedBannerViewHolder(paramViewGroup, this.d);
                localObject1 = this.o;
                if (localObject1 != null) {
                  ((FeedBannerViewHolder)localObject1).a();
                }
                this.o = ((FeedBannerViewHolder)paramViewGroup);
                return paramViewGroup;
              }
            }
            else {
              return new MiniAppRecommViewHolder(((LayoutInflater)localObject2).inflate(2131625348, paramViewGroup, false), this.j);
            }
          }
          else
          {
            paramViewGroup = new ExtendFriendFeedView(this.j);
            paramViewGroup.removeAllViews();
            localObject2 = new VipGeneralGdtShowView(this.j, 2131629649, 3, 1, this.p);
            if (((VipGeneralGdtShowView)localObject2).a() != null)
            {
              paramViewGroup.addView(((VipGeneralGdtShowView)localObject2).a(), (ViewGroup.LayoutParams)localObject1);
              return new ExtendFriendAdvInfoHolder(paramViewGroup, this.j, this.c, (VipGeneralGdtShowView)localObject2);
            }
          }
          return null;
        }
        return new EmptyViewHoder(((LayoutInflater)localObject2).inflate(2131627426, paramViewGroup, false), this.i, this.k, this.c, this.l);
      }
      paramViewGroup = new ExtendFriendFooterView(this.j);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      return new FooterViewHolder(paramViewGroup, this.c);
    }
    paramViewGroup = new ExtendFriendFeedView(this.j);
    paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    return new FeedViewHolder(paramViewGroup, this.c, this.b, this.j);
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((paramViewHolder instanceof FeedBannerViewHolder)) {
      ((FeedBannerViewHolder)paramViewHolder).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.RecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */