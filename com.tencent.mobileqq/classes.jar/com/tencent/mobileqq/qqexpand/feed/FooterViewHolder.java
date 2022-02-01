package com.tencent.mobileqq.qqexpand.feed;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.fragment.SquareItemClickListener;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;

public class FooterViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final SquareItemClickListener jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener;
  
  public FooterViewHolder(View paramView, SquareItemClickListener paramSquareItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener = paramSquareItemClickListener;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380053));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(ProfileGuideDialogUtils.a);
  }
  
  public void a(FooterViewHolder paramFooterViewHolder, StrangerInfo paramStrangerInfo)
  {
    int i = paramStrangerInfo.mFooterType;
    boolean bool = false;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          paramStrangerInfo = "";
        } else {
          paramStrangerInfo = HardCodeUtil.a(2131704811);
        }
      }
      else
      {
        paramStrangerInfo = HardCodeUtil.a(2131704812);
        bool = true;
      }
    }
    else {
      paramStrangerInfo = HardCodeUtil.a(2131704810);
    }
    paramFooterViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStrangerInfo);
    paramFooterViewHolder.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentSquareItemClickListener;
    if (paramView != null) {
      paramView.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.FooterViewHolder
 * JD-Core Version:    0.7.0.1
 */