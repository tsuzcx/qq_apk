package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.MobileQQ;

public class NetSearchTemplateBannerTitleView
  extends NetSearchTemplateBaseView
{
  public RelativeLayout a;
  public TextView a;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public TextView h;
  
  public NetSearchTemplateBannerTitleView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    Object localObject = a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378784));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131369955));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368486));
    this.d = ((ImageView)((View)localObject).findViewById(2131365295));
    this.b = ((TextView)((View)localObject).findViewById(2131378309));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378124));
    this.h = ((TextView)((View)localObject).findViewById(2131365536));
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null))
    {
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(((TextView)localObject).getContext().getResources().getColor(2131166982));
      }
      localObject = this.h;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(((TextView)localObject).getContext().getResources().getColor(2131166982));
      }
    }
    else
    {
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#737373"));
      }
      localObject = this.h;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#737373"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBannerTitleView
 * JD-Core Version:    0.7.0.1
 */