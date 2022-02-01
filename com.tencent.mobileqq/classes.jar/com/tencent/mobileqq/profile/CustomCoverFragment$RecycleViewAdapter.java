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
    if (CustomCoverFragment.c(this.a))
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850380);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131694952);
      return;
    }
    if ((paramItemViewHolder.jdField_a_of_type_Int == CustomCoverFragment.a(this.a)) && (CustomCoverFragment.a(this.a)))
    {
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850380);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131718817);
      return;
    }
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850400);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131694952);
  }
  
  public ProfileCardManager.DefaultCardItem a(int paramInt)
  {
    if ((CustomCoverFragment.a(this.a) != null) && (paramInt > 0))
    {
      paramInt -= 1;
      if ((paramInt < CustomCoverFragment.a(this.a).size()) && (CustomCoverFragment.a(this.a) != null))
      {
        paramInt = ((Integer)CustomCoverFragment.a(this.a).get(paramInt)).intValue();
        return CustomCoverFragment.a(this.a).a(paramInt, false);
      }
    }
    return null;
  }
  
  public int getItemCount()
  {
    int i;
    if (CustomCoverFragment.a(this.a) == null) {
      i = 0;
    } else {
      i = CustomCoverFragment.a(this.a).size();
    }
    return i + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if ((CustomCoverFragment.a(this.a) != null) && (paramInt > CustomCoverFragment.a(this.a).size())) {
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
        ((CustomCoverFragment.ItemViewHolder)localObject1).jdField_a_of_type_Int = localDefaultCardItem.jdField_a_of_type_Int;
        ((CustomCoverFragment.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localDefaultCardItem.jdField_a_of_type_JavaLangString);
        if (TextUtils.isEmpty(localDefaultCardItem.b))
        {
          ((CustomCoverFragment.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(CustomCoverFragment.a(this.a));
        }
        else
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = CustomCoverFragment.f(this.a);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = CustomCoverFragment.e(this.a);
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = CustomCoverFragment.a(this.a);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = CustomCoverFragment.a(this.a);
          localObject2 = URLDrawable.getDrawable(localDefaultCardItem.b, (URLDrawable.URLDrawableOptions)localObject2);
          ((CustomCoverFragment.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        }
        ((CustomCoverFragment.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(localDefaultCardItem.jdField_a_of_type_Int));
        ((CustomCoverFragment.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localDefaultCardItem.jdField_a_of_type_Int));
      }
      else
      {
        ((CustomCoverFragment.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(localObject2);
        ((CustomCoverFragment.ItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
      }
      a((CustomCoverFragment.ItemViewHolder)localObject1);
    }
    else if ((paramViewHolder instanceof CustomCoverFragment.MoreViewHolder))
    {
      localObject1 = (CustomCoverFragment.MoreViewHolder)paramViewHolder;
      if (CustomCoverFragment.c(this.a) == 0)
      {
        CustomCoverFragment.c(this.a, 3);
        CustomCoverFragment.a(this.a);
      }
      if (CustomCoverFragment.c(this.a) == 3)
      {
        ((CustomCoverFragment.MoreViewHolder)localObject1).itemView.setVisibility(0);
        ((CustomCoverFragment.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        ((CustomCoverFragment.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131689530);
        ((CustomCoverFragment.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else if (CustomCoverFragment.c(this.a) == 1)
      {
        ((CustomCoverFragment.MoreViewHolder)localObject1).itemView.setVisibility(0);
        ((CustomCoverFragment.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165695));
        ((CustomCoverFragment.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131690747);
        ((CustomCoverFragment.MoreViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else if (CustomCoverFragment.c(this.a) == 2)
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
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131562008, paramViewGroup, false);
      return new CustomCoverFragment.HeaderViewHolder(this.a, paramViewGroup);
    }
    if (paramInt == 1)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131562009, paramViewGroup, false);
      paramViewGroup = new CustomCoverFragment.ItemViewHolder(this.a, paramViewGroup);
      ((CustomCoverFragment.ItemViewHolder)paramViewGroup).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = CustomCoverFragment.e(this.a);
      return paramViewGroup;
    }
    if (paramInt == 2)
    {
      paramViewGroup = this.a.getActivity().getLayoutInflater().inflate(2131561884, paramViewGroup, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.RecycleViewAdapter
 * JD-Core Version:    0.7.0.1
 */