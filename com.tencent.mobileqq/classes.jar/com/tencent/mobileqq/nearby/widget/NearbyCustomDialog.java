package com.tencent.mobileqq.nearby.widget;

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
import com.tencent.mobileqq.app.HardCodeUtil;

public class NearbyCustomDialog
  extends Dialog
{
  protected View.OnClickListener a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected TextView b;
  
  public NearbyCustomDialog(Context paramContext)
  {
    super(paramContext, 2131756189);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new NearbyCustomDialog.1(this);
    a();
  }
  
  private void a()
  {
    setContentView(2131558972);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368067));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378784));
    this.b = ((TextView)findViewById(2131370646));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363750));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368624));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707160));
  }
  
  public NearbyCustomDialog a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public NearbyCustomDialog a(ButtonInfo paramButtonInfo)
  {
    Button localButton = new Button(getContext());
    int i = -1;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = UIUtils.a(getContext(), 10.0F);
    Object localObject;
    if (paramButtonInfo.jdField_a_of_type_JavaLangString != null) {
      localObject = paramButtonInfo.jdField_a_of_type_JavaLangString;
    } else {
      localObject = "";
    }
    localButton.setText((CharSequence)localObject);
    localButton.setTextSize(20.0F);
    if (paramButtonInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localObject = paramButtonInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    } else {
      localObject = getContext().getResources().getDrawable(2130839280);
    }
    localButton.setBackgroundDrawable((Drawable)localObject);
    if (paramButtonInfo.jdField_a_of_type_Int != -1) {
      i = paramButtonInfo.jdField_a_of_type_Int;
    }
    localButton.setTextColor(i);
    localButton.setOnClickListener(new NearbyCustomDialog.2(this, paramButtonInfo));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton, localLayoutParams);
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyCustomDialog
 * JD-Core Version:    0.7.0.1
 */