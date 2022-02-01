package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class PullRefreshHeader
  extends RelativeLayout
  implements IPullRefreshHeader
{
  private int jdField_a_of_type_Int = 0;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int jdField_b_of_type_Int = 0;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  
  public PullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject == null) {
      return;
    }
    localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    if (this.jdField_a_of_type_Int == 0)
    {
      a((RelativeLayout.LayoutParams)localObject, 10);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
    }
    else
    {
      a((RelativeLayout.LayoutParams)localObject, 12);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  @TargetApi(17)
  public static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.removeRule(paramInt);
      return;
    }
    paramLayoutParams.addRule(12, 0);
  }
  
  private void b(int paramInt)
  {
    if (paramInt != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    }
  }
  
  private void d(long paramLong)
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    if (paramLong != 0L)
    {
      localTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s%s", new Object[] { this.jdField_a_of_type_AndroidContentContext.getString(2131719248), TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd") }));
      int i = this.f;
      if (i >= 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
      }
    }
    else
    {
      localTextView.setVisibility(8);
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          localObject = "";
        }
        else
        {
          getResources().getDrawable(2130849865);
          localObject = getResources().getString(2131719247);
        }
      }
      else
      {
        getResources().getDrawable(2130849864);
        localObject = getResources().getString(2131719247);
      }
    }
    else
    {
      getResources().getDrawable(2130849866);
      localObject = getResources().getString(2131719253);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    b(this.e);
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    Drawable localDrawable;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          localDrawable = null;
        } else {
          localDrawable = getResources().getDrawable(2130849865);
        }
      }
      else {
        localDrawable = getResources().getDrawable(2130849864);
      }
    }
    else {
      localDrawable = getResources().getDrawable(2130849866);
    }
    Object localObject = paramString;
    if (localDrawable != null)
    {
      paramInt = (int)this.jdField_a_of_type_AndroidWidgetTextView.getTextSize() + 2;
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[O]");
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString);
      localObject = new SpannableString(((StringBuilder)localObject).toString());
      ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, 3, 17);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    b(this.e);
    paramString = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719249);
      b(this.d);
      label17:
      d(paramLong);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719252);
    b(this.c);
    d(paramLong);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.g == 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849862);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839429);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719250);
    }
    else
    {
      if (this.g == 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849863);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839430);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719251);
    }
    b(this.jdField_b_of_type_Int);
    d(paramLong);
  }
  
  public void f()
  {
    ProgressBar localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  protected void onAttachedToWindow() {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365169));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131376345));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376342));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376344));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376350));
    if (this.jdField_a_of_type_Int != 0) {
      a();
    }
    if (this.g != 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839431);
    }
    c(0L);
  }
  
  public void setArrowColor(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setHeaderBgColor(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  @TargetApi(16)
  public void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(paramDrawable);
      return;
    }
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setHeaderBgRes(int paramInt)
  {
    setBackgroundResource(paramInt);
  }
  
  public void setPullType(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a();
    }
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */