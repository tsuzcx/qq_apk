package com.tencent.mobileqq.troop.createNewTroop;

import aimr;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class CateListAdapter$SingleItemViewHolder
{
  int jdField_a_of_type_Int;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aimr(this);
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public TextView a;
  public View b;
  public TextView b;
  public View c;
  
  public CateListAdapter$SingleItemViewHolder(View paramView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368268));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368270));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368272));
    this.c = paramView.findViewById(2131368271);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368269);
  }
  
  public void a(Context paramContext, TroopCateListProvider.TroopCateInfo paramTroopCateInfo, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
    this.c.setRotation(0.0F);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopCateInfo.b);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramTroopCateInfo.b);
    if (paramTroopCateInfo.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramTroopCateInfo.jdField_a_of_type_Int);
      if (TextUtils.isEmpty(paramTroopCateInfo.c)) {
        break label168;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramTroopCateInfo.c);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(paramTroopCateInfo.c);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label112:
      if (!paramTroopCateInfo.jdField_a_of_type_Boolean) {
        break label180;
      }
      this.c.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      return;
      if (paramTroopCateInfo.jdField_a_of_type_Int == 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramTroopCateInfo.jdField_a_of_type_Int);
      break;
      label168:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label112;
      label180:
      this.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.CateListAdapter.SingleItemViewHolder
 * JD-Core Version:    0.7.0.1
 */