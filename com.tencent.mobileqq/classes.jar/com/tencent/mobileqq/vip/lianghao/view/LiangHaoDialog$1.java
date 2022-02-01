package com.tencent.mobileqq.vip.lianghao.view;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LiangHaoDialog$1
  implements View.OnClickListener
{
  LiangHaoDialog$1(LiangHaoDialog paramLiangHaoDialog) {}
  
  public void onClick(View paramView)
  {
    LiangHaoDialog.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.view.LiangHaoDialog.1
 * JD-Core Version:    0.7.0.1
 */