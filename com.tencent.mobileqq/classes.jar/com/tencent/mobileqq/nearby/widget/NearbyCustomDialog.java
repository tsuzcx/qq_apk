package com.tencent.mobileqq.nearby.widget;

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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class NearbyCustomDialog
  extends ReportDialog
{
  protected View.OnClickListener a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected TextView b;
  
  public NearbyCustomDialog(Context paramContext)
  {
    super(paramContext, 2131755842);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new NearbyCustomDialog.1(this);
    a();
  }
  
  private void a()
  {
    setContentView(2131559078);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368315));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379432));
    this.b = ((TextView)findViewById(2131371012));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363822));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368898));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131707135));
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
      localButton.setOnClickListener(new NearbyCustomDialog.2(this, paramButtonInfo));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton, localLayoutParams);
      return this;
      localObject = "";
      break;
      localObject = getContext().getResources().getDrawable(2130839424);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyCustomDialog
 * JD-Core Version:    0.7.0.1
 */