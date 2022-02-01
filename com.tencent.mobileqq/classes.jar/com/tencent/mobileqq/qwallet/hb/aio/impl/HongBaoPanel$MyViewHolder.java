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
  HongBaoPanel.OnHolderItemClickListener a;
  ImageView b;
  TextView c;
  ImageView d;
  RelativeLayout e;
  
  public HongBaoPanel$MyViewHolder(HongBaoPanel paramHongBaoPanel, View paramView, HongBaoPanel.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.a = paramOnHolderItemClickListener;
    paramView.setOnClickListener(this);
    if (paramHongBaoPanel.i)
    {
      paramOnHolderItemClickListener = paramView.getLayoutParams();
      paramOnHolderItemClickListener.height += paramHongBaoPanel.l + 5;
    }
    this.b = ((ImageView)paramView.findViewById(R.id.Q));
    this.c = ((TextView)paramView.findViewById(R.id.ac));
    if (HongBaoPanel.e(paramHongBaoPanel)) {
      this.c.setTextColor(HongBaoPanel.f(paramHongBaoPanel));
    }
    this.e = ((RelativeLayout)paramView.findViewById(R.id.U));
    this.d = ((ImageView)paramView.findViewById(R.id.aq));
  }
  
  public void onClick(View paramView)
  {
    HongBaoPanel.OnHolderItemClickListener localOnHolderItemClickListener = this.a;
    if (localOnHolderItemClickListener != null) {
      localOnHolderItemClickListener.a(paramView, getPosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */