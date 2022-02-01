package com.tencent.mobileqq.profile;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Vector;

public class CustomCoverFragment$RecycleViewAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public CustomCoverFragment$RecycleViewAdapter(CustomCoverFragment paramCustomCoverFragment) {}
  
  private void a(CustomCoverFragment.ItemViewHolder paramItemViewHolder)
  {
    if (CustomCoverFragment.l(this.a))
    {
      paramItemViewHolder.d.setBackgroundResource(2130852171);
      paramItemViewHolder.d.setTextColor(-8947849);
      paramItemViewHolder.d.setText(2131892679);
      return;
    }
    if ((paramItemViewHolder.a == CustomCoverFragment.f(this.a)) && (CustomCoverFragment.b(this.a)))
    {
      paramItemViewHolder.d.setBackgroundResource(2130852171);
      paramItemViewHolder.d.setTextColor(-8947849);
      paramItemViewHolder.d.setText(2131916325);
      return;
    }
    paramItemViewHolder.d.setBackgroundResource(2130852191);
    paramItemViewHolder.d.setTextColor(-16777216);
    paramItemViewHolder.d.setText(2131892679);
  }
  
  public ProfileCardManager.DefaultCardItem a(int paramInt)
  {
    if ((CustomCoverFragment.d(this.a) != null) && (paramInt > 0))
    {
      paramInt -= 1;
      if ((paramInt < CustomCoverFragment.d(this.a).size()) && (CustomCoverFragment.r(this.a) != null))
      {
        paramInt = ((Integer)CustomCoverFragment.d(this.a).get(paramInt)).intValue();
        return CustomCoverFragment.r(this.a).a(paramInt, false);
      }
    }
    return null;
  }
  
  public int getItemCount()
  {
    int i;
    if (CustomCoverFragment.d(this.a) == null) {
      i = 0;
    } else {
      i = CustomCoverFragment.d(this.a).size();
    }
    return i + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if ((CustomCoverFragment.d(this.a) != null) && (paramInt > CustomCoverFragment.d(this.a).size())) {
      return 2;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    boolean bool = paramViewHolder instanceof CustomCoverFragment.ItemViewHolder;
    Object localObject2 = Integer.valueOf(0);
    Object localObject1;
    if (bool)
    {
      localObject1 = (CustomCoverFragment.ItemViewHolder)paramViewHolder;
      ProfileCardManager.DefaultCardItem localDefaultCardItem = a(paramInt);
      if (localDefaultCardItem != null)
      {
        ((CustomCoverFragment.ItemViewHolder)localObject1).a = localDefaultCardItem.a;
        ((CustomCoverFragment.ItemViewHolder)localObject1).c.setText(localDefaultCardItem.b);
        if (TextUtils.isEmpty(localDefaultCardItem.c))
        {
          ((CustomCoverFragment.ItemViewHolder)localObject1).b.setImageDrawable(CustomCoverFragment.o(this.a));
        }
        else
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = CustomCoverFragment.p(this.a);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = CustomCoverFragment.n(this.a);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = CustomCoverFragment.o(this.a);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = CustomCoverFragment.o(this.a);
          localObject2 = URLDrawable.getDrawable(localDefaultCardItem.c, (URLDrawable.URLDrawableOptions)localObject2);
          ((CustomCoverFragment.ItemViewHolder)localObject1).b.setImageDrawable((Drawable)localObject2);
        }
        ((CustomCoverFragment.ItemViewHolder)localObject1).d.setTag(Integer.valueOf(localDefaultCardItem.a));
        ((CustomCoverFragment.ItemViewHolder)localObject1).b.setTag(Integer.valueOf(localDefaultCardItem.a));
      }
      else
      {
        ((CustomCoverFragment.ItemViewHolder)localObject1).d.setTag(localObject2);
        ((CustomCoverFragment.ItemViewHolder)localObject1).b.setTag(localObject2);
      }
      a((CustomCoverFragment.ItemViewHolder)localObject1);
    }
    else if ((paramViewHolder instanceof CustomCoverFragment.MoreViewHolder))
    {
      localObject1 = (CustomCoverFragment.MoreViewHolder)paramViewHolder;
      if (CustomCoverFragment.h(this.a) == 0)
      {
        CustomCoverFragment.c(this.a, 3);
        CustomCoverFragment.q(this.a);
      }
      if (CustomCoverFragment.h(this.a) == 3)
      {
        ((CustomCoverFragment.MoreViewHolder)localObject1).itemView.setVisibility(0);
        ((CustomCoverFragment.MoreViewHolder)localObject1).a.setTextColor(-16777216);
        ((CustomCoverFragment.MoreViewHolder)localObject1).a.setText(2131886138);
        ((CustomCoverFragment.MoreViewHolder)localObject1).b.setVisibility(8);
      }
      else if (CustomCoverFragment.h(this.a) == 1)
      {
        ((CustomCoverFragment.MoreViewHolder)localObject1).itemView.setVisibility(0);
        ((CustomCoverFragment.MoreViewHolder)localObject1).a.setTextColor(this.a.getResources().getColor(2131166161));
        ((CustomCoverFragment.MoreViewHolder)localObject1).a.setText(2131887667);
        ((CustomCoverFragment.MoreViewHolder)localObject1).b.setVisibility(0);
      }
      else if (CustomCoverFragment.h(this.a) == 2)
      {
        ((CustomCoverFragment.MoreViewHolder)localObject1).itemView.setVisibility(8);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131628434, paramViewGroup, false);
      return new CustomCoverFragment.HeaderViewHolder(this.a, paramViewGroup);
    }
    if (paramInt == 1)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131628435, paramViewGroup, false);
      paramViewGroup = new CustomCoverFragment.ItemViewHolder(this.a, paramViewGroup);
      ((CustomCoverFragment.ItemViewHolder)paramViewGroup).b.getLayoutParams().height = CustomCoverFragment.n(this.a);
      return paramViewGroup;
    }
    if (paramInt == 2)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131628302, paramViewGroup, false);
      return new CustomCoverFragment.MoreViewHolder(this.a, paramViewGroup);
    }
    return null;
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    Object localObject = paramViewHolder.itemView.getLayoutParams();
    if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
    {
      localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
      int i = getItemViewType(paramViewHolder.getLayoutPosition());
      boolean bool = true;
      if (i == 1) {
        bool = false;
      }
      ((StaggeredGridLayoutManager.LayoutParams)localObject).setFullSpan(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.RecycleViewAdapter
 * JD-Core Version:    0.7.0.1
 */