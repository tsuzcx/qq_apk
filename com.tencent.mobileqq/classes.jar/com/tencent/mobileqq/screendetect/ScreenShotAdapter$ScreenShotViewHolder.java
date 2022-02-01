package com.tencent.mobileqq.screendetect;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;

public class ScreenShotAdapter$ScreenShotViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public final TextView a;
  private ScreenShotAdapter.OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener;
  public RecentDynamicAvatarView a;
  
  public ScreenShotAdapter$ScreenShotViewHolder(ScreenShotAdapter paramScreenShotAdapter, View paramView, ScreenShotAdapter.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368343));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371877));
    this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener = paramOnHolderItemClickListener;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener != null) && (ScreenShotAdapter.a(this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter)))
    {
      this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener.a(paramView, getAdapterPosition() - 1);
    }
    else
    {
      ScreenShotAdapter.OnHolderItemClickListener localOnHolderItemClickListener = this.jdField_a_of_type_ComTencentMobileqqScreendetectScreenShotAdapter$OnHolderItemClickListener;
      if (localOnHolderItemClickListener != null) {
        localOnHolderItemClickListener.a(paramView, getAdapterPosition());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotAdapter.ScreenShotViewHolder
 * JD-Core Version:    0.7.0.1
 */