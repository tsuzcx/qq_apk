package com.tencent.mobileqq.search.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;

public class SearchResultFromNetView
  extends SearchResultView
{
  private int jdField_a_of_type_Int;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private TroopLabelLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  public View b;
  public ImageView b;
  private TextView b;
  public View c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public SearchResultFromNetView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    Resources localResources;
    LinearLayout localLinearLayout;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_b_of_type_Int = 2130969409;
      localResources = paramViewGroup.getResources();
      localLinearLayout = new LinearLayout(paramViewGroup.getContext());
      localLinearLayout.setOrientation(1);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(this.jdField_b_of_type_Int, null, false);
      localLinearLayout.addView(paramViewGroup, new LinearLayout.LayoutParams(-1, -2));
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        localLinearLayout.setBackgroundColor(localResources.getColor(2131492948));
        if (a()) {
          paramViewGroup.setBackgroundResource(2130838580);
        }
      }
      break;
    }
    for (;;)
    {
      localLinearLayout.setClickable(true);
      localLinearLayout.setFocusable(true);
      this.d = localLinearLayout;
      a();
      return;
      this.jdField_b_of_type_Int = 2130969714;
      break;
      this.jdField_b_of_type_Int = 2130969379;
      break;
      this.jdField_b_of_type_Int = 2130970494;
      break;
      this.jdField_b_of_type_Int = 2130970495;
      break;
      this.jdField_b_of_type_Int = 2130969388;
      break;
      paramViewGroup.setBackgroundColor(localResources.getColor(2131492948));
      continue;
      localLinearLayout.setBackgroundColor(localResources.getColor(2131492969));
      if (a()) {
        paramViewGroup.setBackgroundResource(2130838579);
      } else {
        paramViewGroup.setBackgroundColor(localResources.getColor(2131492969));
      }
    }
  }
  
  public TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public TroopLabelLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.d.findViewById(2131362719));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.d.findViewById(2131366373));
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1001: 
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.d.findViewById(2131365208));
      return;
    case 1002: 
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.d.findViewById(2131366587));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.d.findViewById(2131370860));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)this.d.findViewById(2131370861));
      return;
    }
    this.jdField_a_of_type_AndroidViewView = this.d.findViewById(2131363960);
    this.jdField_b_of_type_AndroidViewView = this.d.findViewById(2131366355);
    this.jdField_c_of_type_AndroidViewView = this.d.findViewById(2131366354);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.d.findViewById(2131364763));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.d.findViewById(2131366356));
  }
  
  public boolean a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return true;
    }
    return false;
  }
  
  public TextView b()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  public ImageView c()
  {
    return this.jdField_c_of_type_AndroidWidgetImageView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchResultFromNetView
 * JD-Core Version:    0.7.0.1
 */