package com.tencent.mobileqq.search.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;

public class NetSearchTemplateBaseView
  extends SearchResultView
{
  public RelativeLayout b;
  public SquareImageView b;
  public ImageView c;
  public TextView e;
  public TextView f;
  
  public NetSearchTemplateBaseView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    Resources localResources = paramViewGroup.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, null, false);
    localLinearLayout.addView(paramViewGroup, new LinearLayout.LayoutParams(-1, -2));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      localLinearLayout.setBackgroundColor(localResources.getColor(2131492947));
      if (c(paramInt)) {
        paramViewGroup.setBackgroundResource(2130838576);
      }
    }
    for (;;)
    {
      localLinearLayout.setClickable(true);
      localLinearLayout.setFocusable(true);
      this.d = localLinearLayout;
      a();
      return;
      paramViewGroup.setBackgroundColor(localResources.getColor(2131492947));
      continue;
      localLinearLayout.setBackgroundColor(localResources.getColor(2131492968));
      if (c(paramInt)) {
        paramViewGroup.setBackgroundResource(2130838575);
      }
    }
  }
  
  private boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return true;
    }
    return false;
  }
  
  protected void a()
  {
    super.a();
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366349));
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366348));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131366350));
    this.c = ((ImageView)paramView.findViewById(2131366351));
    this.e = ((TextView)paramView.findViewById(2131361928));
    this.f = ((TextView)paramView.findViewById(2131366352));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateBaseView
 * JD-Core Version:    0.7.0.1
 */