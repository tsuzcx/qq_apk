package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;

public class NetSearchTemplateUpdatesView
  extends NetSearchTemplateBaseView
{
  public int a;
  public FrameLayout a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public SquareImageView a;
  public ImageView b;
  public ImageView d;
  
  public NetSearchTemplateUpdatesView(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    Object localObject = a(this.c);
    this.b = ((ImageView)((View)localObject).findViewById(2131365430));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368603));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378921));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject).findViewById(2131373155));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((View)localObject).findViewById(2131378213));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368829));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370047));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    localObject = a();
    TextView localTextView1 = b();
    TextView localTextView2 = c();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      if (localObject != null) {
        ((TextView)localObject).setTextColor(((View)localObject).getContext().getResources().getColor(2131166964));
      }
      if (localTextView1 != null) {
        ((TextView)localTextView1).setTextColor(localTextView1.getContext().getResources().getColor(2131166963));
      }
      if (localTextView2 != null) {
        ((TextView)localTextView2).setTextColor(localTextView2.getContext().getResources().getColor(2131166963));
      }
    }
    do
    {
      return;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#262626"));
      }
      if (localTextView1 != null) {
        ((TextView)localTextView1).setTextColor(Color.parseColor("#737373"));
      }
    } while (localTextView2 == null);
    ((TextView)localTextView2).setTextColor(Color.parseColor("#737373"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.NetSearchTemplateUpdatesView
 * JD-Core Version:    0.7.0.1
 */