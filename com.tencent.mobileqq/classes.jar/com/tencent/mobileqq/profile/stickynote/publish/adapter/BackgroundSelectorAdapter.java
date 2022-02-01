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
    return new BackgroundSelectorAdapter.BackgroundSelectorViewHolder(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561380, paramViewGroup, false));
  }
  
  public void a(BackgroundSelectorAdapter.BackgroundSelectorViewHolder paramBackgroundSelectorViewHolder, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > paramInt) && (((BackgroundSelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (paramBackgroundSelectorViewHolder != null) && (paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView != null))
    {
      paramBackgroundSelectorViewHolder.jdField_a_of_type_Boolean = ((BackgroundSelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean;
      paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBackground(((BackgroundSelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
      if (paramBackgroundSelectorViewHolder.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Int = paramInt;
        paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(AIOUtils.b(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localObject = this.jdField_a_of_type_ComTencentMobileqqProfileStickynotePublishAdapterBackgroundSelectorAdapter$OnSelectListener;
        if (localObject != null) {
          ((BackgroundSelectorAdapter.OnSelectListener)localObject).a((BackgroundSelectBean)this.jdField_a_of_type_JavaUtilList.get(paramInt));
        }
      }
      else
      {
        paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setBorderWidth(AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setCornerRadius(AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      }
      a(paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView, paramBackgroundSelectorViewHolder.jdField_a_of_type_Boolean);
      paramBackgroundSelectorViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundedImageView.setOnClickListener(new BackgroundSelectorAdapter.1(this, paramInt));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramBackgroundSelectorViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(RoundedImageView paramRoundedImageView, boolean paramBoolean)
  {
    if (paramRoundedImageView != null)
    {
      paramRoundedImageView = (ViewGroup.MarginLayoutParams)paramRoundedImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramRoundedImageView.height = AIOUtils.b(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.width = AIOUtils.b(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRoundedImageView.setMargins(AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        return;
      }
      paramRoundedImageView.height = AIOUtils.b(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramRoundedImageView.width = AIOUtils.b(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramRoundedImageView.setMargins(AIOUtils.b(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.adapter.BackgroundSelectorAdapter
 * JD-Core Version:    0.7.0.1
 */