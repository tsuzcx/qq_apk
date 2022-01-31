package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.arithmetic.data.HWGuideItem;
import java.util.ArrayList;

public class HomeworkGuideFragment$ContentViewHolder
{
  public int a;
  public ImageView a;
  public TextView a;
  
  public HomeworkGuideFragment$ContentViewHolder(HomeworkGuideFragment paramHomeworkGuideFragment) {}
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366616));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368380));
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((HWGuideItem)HomeworkGuideFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiHomeworkGuideFragment).get(this.jdField_a_of_type_Int)).b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.HomeworkGuideFragment.ContentViewHolder
 * JD-Core Version:    0.7.0.1
 */