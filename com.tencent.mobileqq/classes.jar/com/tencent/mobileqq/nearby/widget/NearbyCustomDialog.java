package com.tencent.mobileqq.nearby.widget;

import aezj;
import aezk;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;

public class NearbyCustomDialog
  extends Dialog
{
  protected View.OnClickListener a;
  protected ImageView a;
  public LinearLayout a;
  protected RelativeLayout a;
  public TextView a;
  public TextView b;
  
  public NearbyCustomDialog(Context paramContext)
  {
    super(paramContext, 2131624515);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aezj(this);
    a();
  }
  
  private void a()
  {
    setContentView(2130968849);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364033));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363360));
    this.b = ((TextView)findViewById(2131364034));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364035));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363154));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("关闭");
  }
  
  public NearbyCustomDialog a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
    return this;
  }
  
  public NearbyCustomDialog a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public NearbyCustomDialog a(ButtonInfo paramButtonInfo)
  {
    Button localButton = new Button(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = UIUtils.a(getContext(), 10.0F);
    Object localObject;
    if (paramButtonInfo.jdField_a_of_type_JavaLangString != null)
    {
      localObject = paramButtonInfo.jdField_a_of_type_JavaLangString;
      localButton.setText((CharSequence)localObject);
      localButton.setTextSize(20.0F);
      if (paramButtonInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label134;
      }
      localObject = paramButtonInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label76:
      localButton.setBackgroundDrawable((Drawable)localObject);
      if (paramButtonInfo.jdField_a_of_type_Int == -1) {
        break label150;
      }
    }
    label134:
    label150:
    for (int i = paramButtonInfo.jdField_a_of_type_Int;; i = -1)
    {
      localButton.setTextColor(i);
      localButton.setOnClickListener(new aezk(this, paramButtonInfo));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton, localLayoutParams);
      return this;
      localObject = "";
      break;
      localObject = getContext().getResources().getDrawable(2130838487);
      break label76;
    }
  }
  
  public NearbyCustomDialog a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    return this;
  }
  
  public NearbyCustomDialog b(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyCustomDialog
 * JD-Core Version:    0.7.0.1
 */