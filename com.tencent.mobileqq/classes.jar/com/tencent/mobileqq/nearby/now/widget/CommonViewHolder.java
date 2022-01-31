package com.tencent.mobileqq.nearby.now.widget;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class CommonViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  private SparseArrayCompat jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  @Nullable
  private CommonViewHolder.ItemClickListener jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener;
  
  public CommonViewHolder(View paramView)
  {
    super(paramView);
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
  }
  
  public static CommonViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new CommonViewHolder(LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  public View a(int paramInt)
  {
    View localView2 = (View)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.itemView.findViewById(paramInt);
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public CommonViewHolder a(@IdRes int paramInt1, int paramInt2)
  {
    ((TextView)a(paramInt1)).setTextColor(paramInt2);
    return this;
  }
  
  public CommonViewHolder a(@IdRes int paramInt, CharSequence paramCharSequence)
  {
    ((TextView)a(paramInt)).setText(paramCharSequence);
    return this;
  }
  
  public void a(CommonViewHolder.ItemClickListener paramItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener = paramItemClickListener;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener.a(getPosition(), paramView);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener.b(getPosition(), paramView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonViewHolder
 * JD-Core Version:    0.7.0.1
 */