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
      this.jdField_b_of_type_Int = 2130969408;
      localResources = paramViewGroup.getResources();
      localLinearLayout = new LinearLayout(paramViewGroup.getContext());
      localLinearLayout.setOrientation(1);
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(this.jdField_b_of_type_Int, null, false);
      localLinearLayout.addView(paramViewGroup, new LinearLayout.LayoutParams(-1, -2));
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        localLinearLayout.setBackgroundColor(localResources.getColor(2131492947));
        if (a()) {
          paramViewGroup.setBackgroundResource(2130838576);
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
      this.jdField_b_of_type_Int = 2130969700;
      break;
      this.jdField_b_of_type_Int = 2130969378;
      break;
      this.jdField_b_of_type_Int = 2130970453;
      break;
      this.jdField_b_of_type_Int = 2130970454;
      break;
      this.jdField_b_of_type_Int = 2130969387;
      break;
      paramViewGroup.setBackgroundColor(localResources.getColor(2131492947));
      continue;
      localLinearLayout.setBackgroundColor(localResources.getColor(2131492968));
      if (a()) {
        paramViewGroup.setBackgroundResource(2130838575);
      } else {
        paramViewGroup.setBackgroundColor(localResources.getColor(2131492968));
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
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.d.findViewById(2131362701));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.d.findViewById(2131366346));
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1001: 
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.d.findViewById(2131365186));
      return;
    case 1002: 
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.d.findViewById(2131366563));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.d.findViewById(2131370720));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)this.d.findViewById(2131370721));
      return;
    }
    this.jdField_a_of_type_AndroidViewView = this.d.findViewById(2131363937);
    this.jdField_b_of_type_AndroidViewView = this.d.findViewById(2131366328);
    this.jdField_c_of_type_AndroidViewView = this.d.findViewById(2131366327);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.d.findViewById(2131364741));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.d.findViewById(2131366329));
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