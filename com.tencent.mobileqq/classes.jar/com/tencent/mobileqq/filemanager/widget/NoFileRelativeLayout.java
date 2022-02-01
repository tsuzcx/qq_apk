package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aufr;
import becr;

public class NoFileRelativeLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int = 0;
  Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  int jdField_b_of_type_Int = 0;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public NoFileRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NoFileRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NoFileRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560825, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramAttributeSet.findViewById(2131372042));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramAttributeSet.findViewById(2131378672));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramAttributeSet.findViewById(2131378683));
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aufr(this);
    becr.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramAttributeSet.findViewById(2131368524));
    this.jdField_a_of_type_AndroidViewView = paramAttributeSet.findViewById(2131379258);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void setGone()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void setImageViewBackGround(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void setLayoutParams(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 20)) {}
    while ((this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == paramInt2)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - 20);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
  }
  
  public void setText(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void setTextLeftDrawable(int paramInt)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  public void setTopViewHeight(float paramFloat)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.weight = paramFloat;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout
 * JD-Core Version:    0.7.0.1
 */