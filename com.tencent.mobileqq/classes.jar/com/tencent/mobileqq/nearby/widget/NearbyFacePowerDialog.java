package com.tencent.mobileqq.nearby.widget;

import afmr;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class NearbyFacePowerDialog
  extends Dialog
{
  protected View.OnClickListener a;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected ImageView b;
  protected TextView b;
  
  public NearbyFacePowerDialog(Context paramContext)
  {
    super(paramContext, 2131624516);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afmr(this);
    a();
  }
  
  private void a()
  {
    setContentView(2130969113);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365234);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365235));
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://qpic.url.cn/feeds_pic/Q3auHgzwzM5s0d0QdGBTvzxPH9XHPUOzWzKIDiaGPp8Qu1gGTukeE2g/", URLDrawable.URLDrawableOptions.obtain());
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localURLDrawable);
    localURLDrawable = URLDrawable.getDrawable("https://qpic.url.cn/feeds_pic/f9KibbMErfmUUtmMsHmZ2PjzlzWuo1lmDFAkwHHBroa8/", URLDrawable.URLDrawableOptions.obtain());
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localURLDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363378));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364058));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365237));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363172));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("关闭");
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyFacePowerDialog
 * JD-Core Version:    0.7.0.1
 */