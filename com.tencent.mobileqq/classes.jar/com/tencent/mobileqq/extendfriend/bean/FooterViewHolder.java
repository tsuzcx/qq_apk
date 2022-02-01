package com.tencent.mobileqq.extendfriend.bean;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.extendfriend.fragment.SquareItemClickListener;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FooterViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareItemClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener;
  
  public FooterViewHolder(View paramView, SquareItemClickListener paramSquareItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener = paramSquareItemClickListener;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380790));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(ProfileGuideDialogUtils.a);
  }
  
  public void a(FooterViewHolder paramFooterViewHolder, StrangerInfo paramStrangerInfo)
  {
    String str = "";
    boolean bool = false;
    switch (paramStrangerInfo.mFooterType)
    {
    default: 
      paramStrangerInfo = str;
    }
    for (;;)
    {
      paramFooterViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStrangerInfo);
      paramFooterViewHolder.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramStrangerInfo = HardCodeUtil.a(2131704734);
      continue;
      paramStrangerInfo = HardCodeUtil.a(2131704736);
      bool = true;
      continue;
      paramStrangerInfo = HardCodeUtil.a(2131704735);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentSquareItemClickListener.d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.FooterViewHolder
 * JD-Core Version:    0.7.0.1
 */