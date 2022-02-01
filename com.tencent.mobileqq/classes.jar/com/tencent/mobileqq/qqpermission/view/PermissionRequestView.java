package com.tencent.mobileqq.qqpermission.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

public class PermissionRequestView
  extends FrameLayout
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Button c;
  
  public PermissionRequestView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PermissionRequestView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PermissionRequestView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131561267, this);
    a();
  }
  
  private void a(View paramView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372464));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372467));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372463));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131372465));
    this.c = ((Button)findViewById(2131372466));
    PermissionRequestView.1 local1 = new PermissionRequestView.1(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(local1);
    this.c.setOnClickListener(local1);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = this.c;
    setScene(2);
  }
  
  public void setContent(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void setContent(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void setIcon(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void setOnSettingClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void setScene(int paramInt)
  {
    float f3;
    float f1;
    float f2;
    int i;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      f3 = ViewUtils.b(8.0F);
      f1 = ViewUtils.b(7.5F);
      f2 = ViewUtils.b(16.0F);
      paramInt = ViewUtils.b(176.0F);
      i = ViewUtils.b(132.0F);
      this.c.setVisibility(this.jdField_a_of_type_AndroidWidgetButton.getVisibility());
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton = this.c;
    }
    else
    {
      f3 = ViewUtils.b(12.0F);
      f1 = ViewUtils.b(8.0F);
      f2 = ViewUtils.b(16.0F);
      paramInt = ViewUtils.b(256.0F);
      i = ViewUtils.b(192.0F);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(this.jdField_a_of_type_AndroidWidgetButton.getVisibility());
      this.c.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton = this.jdField_b_of_type_AndroidWidgetButton;
    }
    a(this.jdField_a_of_type_AndroidWidgetTextView, (int)f3);
    a(this.jdField_b_of_type_AndroidWidgetTextView, (int)f1);
    a(this.jdField_a_of_type_AndroidWidgetButton, (int)f2);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = i;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.view.PermissionRequestView
 * JD-Core Version:    0.7.0.1
 */