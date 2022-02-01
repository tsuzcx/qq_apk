package com.tencent.mobileqq.profile.stickynote.publish.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.stickynote.publish.bean.BackgroundSelectBean;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class BackgroundSelectorAdapter
  extends RecyclerView.Adapter<BackgroundSelectorAdapter.BackgroundSelectorViewHolder>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private BackgroundSelectorAdapter.OnSelectListener jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter$OnSelectListener;
  private List<BackgroundSelectBean> jdField_a_of_type_JavaUtilList;
  
  public BackgroundSelectorAdapter(List<BackgroundSelectBean> paramList, Context paramContext, BackgroundSelectorAdapter.OnSelectListener paramOnSelectListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter$OnSelectListener = paramOnSelectListener;
  }
  
  public BackgroundSelectorAdapter.BackgroundSelectorViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new BackgroundSelectorAdapter.BackgroundSelectorViewHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561539, paramViewGroup, false));
  }
  
  public void a(BackgroundSelectorAdapter.BackgroundSelectorViewHolder paramBackgroundSelectorViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt) || (((BackgroundSelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    while ((paramBackgroundSelectorViewHolder == null) || (paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView == null))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramBackgroundSelectorViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    paramBackgroundSelectorViewHolder.jdField_a_of_type_Boolean = ((BackgroundSelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean;
    paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBackground(((BackgroundSelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    if (paramBackgroundSelectorViewHolder.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = paramInt;
      paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter$OnSelectListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter$OnSelectListener.a((BackgroundSelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
    for (;;)
    {
      a(paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView, paramBackgroundSelectorViewHolder.jdField_a_of_type_Boolean);
      paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setOnClickListener(new BackgroundSelectorAdapter.1(this, paramInt));
      break;
      paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.width = AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.setMargins(AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
    }
    else
    {
      return;
    }
    paramRoundedImageView.height = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.width = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramRoundedImageView.setMargins(AIOUtils.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.adapter.BackgroundSelectorAdapter
 * JD-Core Version:    0.7.0.1
 */