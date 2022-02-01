package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqpay.ui.R.id;

class HongBaoPanel$MyViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  HongBaoPanel.OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$OnHolderItemClickListener;
  ImageView b;
  
  public HongBaoPanel$MyViewHolder(HongBaoPanel paramHongBaoPanel, View paramView, HongBaoPanel.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$OnHolderItemClickListener = paramOnHolderItemClickListener;
    paramView.setOnClickListener(this);
    if (paramHongBaoPanel.a)
    {
      paramOnHolderItemClickListener = paramView.getLayoutParams();
      paramOnHolderItemClickListener.height += paramHongBaoPanel.b + 5;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(R.id.L));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(R.id.X));
    if (HongBaoPanel.a(paramHongBaoPanel)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(HongBaoPanel.a(paramHongBaoPanel));
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(R.id.P));
    this.b = ((ImageView)paramView.findViewById(R.id.aj));
  }
  
  public void onClick(View paramView)
  {
    HongBaoPanel.OnHolderItemClickListener localOnHolderItemClickListener = this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioImplHongBaoPanel$OnHolderItemClickListener;
    if (localOnHolderItemClickListener != null) {
      localOnHolderItemClickListener.a(paramView, getPosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */