package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemViewHolder
{
  public int a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new SingleItemViewHolder.1(this);
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public TroopCateListProvider.TroopCateInfo a;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View c;
  
  public SingleItemViewHolder(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380104));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380106));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380103));
    this.c = paramView.findViewById(2131380105);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380107);
  }
  
  public void a(Context paramContext, TroopCateListProvider.TroopCateInfo paramTroopCateInfo, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
    this.c.setRotation(0.0F);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopCateInfo.b);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramTroopCateInfo.b);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiTroopCateListProvider$TroopCateInfo = paramTroopCateInfo;
    if (paramTroopCateInfo.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramTroopCateInfo.jdField_a_of_type_Int);
    } else if (paramTroopCateInfo.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramTroopCateInfo.jdField_a_of_type_Int);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramTroopCateInfo.jdField_a_of_type_Boolean) {
      this.c.setVisibility(0);
    } else {
      this.c.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.SingleItemViewHolder
 * JD-Core Version:    0.7.0.1
 */