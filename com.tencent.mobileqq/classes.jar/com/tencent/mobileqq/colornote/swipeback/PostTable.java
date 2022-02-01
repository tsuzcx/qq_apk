package com.tencent.mobileqq.colornote.swipeback;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqoh;
import com.tencent.mobileqq.theme.ThemeUtil;

public class PostTable
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public PostTable(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public PostTable(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.i = 0;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131558951, this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373067));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373068));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373069));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373066));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373065);
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130839314));
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    this.c = paramContext.getDefaultDisplay().getWidth();
    this.d = paramContext.getDefaultDisplay().getHeight();
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297522);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297523);
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * 1.083333F));
    this.jdField_b_of_type_Int = ((int)(this.jdField_b_of_type_Int * 1.0F));
    this.g = (this.d - getResources().getDimensionPixelSize(2131297521));
    this.f = (this.g - this.jdField_a_of_type_Int);
    this.e = this.c;
    this.h = (this.e + this.jdField_b_of_type_Int);
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleX(0.0F);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleY(0.0F);
  }
  
  public void a()
  {
    if (this.i == 0) {
      return;
    }
    if (this.i == 2) {
      f();
    }
    this.jdField_a_of_type_Boolean = true;
    this.i = 0;
    aqoh.a(this.jdField_b_of_type_AndroidWidgetImageView, 300, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
    aqoh.a(this.jdField_a_of_type_AndroidWidgetImageView, 300, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F);
    aqoh.a(this.jdField_a_of_type_AndroidViewView, 300, 1.0F, 1.0F, 1.083333F, 1.0F);
  }
  
  public void a(double paramDouble)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_Boolean = false;
    }
    this.e = (this.c - (int)(this.jdField_b_of_type_Int * paramDouble));
    this.h = (this.c - (int)(this.jdField_b_of_type_Int * paramDouble) + this.jdField_b_of_type_Int);
    layout(this.e, this.f, this.h, this.g);
    invalidate();
  }
  
  public void b()
  {
    if (this.i == 1) {
      return;
    }
    if (this.i == 2) {
      f();
    }
    this.jdField_a_of_type_Boolean = true;
    this.i = 1;
    aqoh.a(this.jdField_a_of_type_AndroidWidgetImageView, 300, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
    aqoh.a(this.jdField_b_of_type_AndroidWidgetImageView, 300, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F);
    aqoh.a(this.jdField_a_of_type_AndroidViewView, 300, 1.0F, 1.0F, 1.0F, 1.083333F);
  }
  
  public void c()
  {
    if (this.i == 2) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    e();
    this.i = 2;
    this.jdField_a_of_type_AndroidViewView.setScaleX(1.0F);
    this.jdField_a_of_type_AndroidViewView.setScaleY(1.083333F);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, this.e, this.f, this.h, this.g);
    if (paramInt2 == 0) {
      layout(this.e, this.f, this.h, this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.swipeback.PostTable
 * JD-Core Version:    0.7.0.1
 */