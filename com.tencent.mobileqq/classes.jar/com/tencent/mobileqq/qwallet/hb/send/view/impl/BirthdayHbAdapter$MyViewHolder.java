package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qwallet.utils.impl.QWalletUIUtils;

public class BirthdayHbAdapter$MyViewHolder
  extends RecyclerView.ViewHolder
{
  TextView a;
  TextView b;
  
  public BirthdayHbAdapter$MyViewHolder(BirthdayHbAdapter paramBirthdayHbAdapter, View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(R.id.cK));
    this.b = ((TextView)paramView.findViewById(R.id.cQ));
    paramBirthdayHbAdapter = QWalletUIUtils.a();
    if (paramBirthdayHbAdapter != null) {
      this.a.setTypeface(paramBirthdayHbAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.BirthdayHbAdapter.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */