package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.search.base.view.SearchResultView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import mqq.app.MobileQQ;

public class NetSearchTemplateBaseView
  extends SearchResultView
{
  public SquareImageView a;
  public RelativeLayout b;
  public SquareImageView b;
  public ImageView e;
  public TextView i;
  public TextView j;
  public TextView k;
  
  public NetSearchTemplateBaseView(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramViewGroup.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, null, false), new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setBackgroundResource(2130850581);
    localLinearLayout.setClickable(true);
    localLinearLayout.setFocusable(true);
    this.jdField_b_of_type_AndroidViewView = localLinearLayout;
    a();
  }
  
  protected void a()
  {
    super.a();
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376697));
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368539));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131369401));
    this.e = ((ImageView)paramView.findViewById(2131369331));
    this.i = ((TextView)paramView.findViewById(2131379918));
    this.j = ((TextView)paramView.findViewById(2131379856));
    this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131376555));
    this.k = ((TextView)paramView.findViewById(2131376556));
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null))
    {
      paramView = this.j;
      paramView.setTextColor(paramView.getContext().getResources().getColor(2131166983));
      paramView = this.k;
      paramView.setTextColor(paramView.getContext().getResources().getColor(2131166983));
      return;
    }
    paramView = this.j;
    paramView.setTextColor(paramView.getContext().getResources().getColor(2131167394));
    paramView = this.k;
    paramView.setTextColor(paramView.getContext().getResources().getColor(2131167394));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBaseView
 * JD-Core Version:    0.7.0.1
 */