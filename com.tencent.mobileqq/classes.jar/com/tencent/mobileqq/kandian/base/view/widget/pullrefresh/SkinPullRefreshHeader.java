package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.widget.IPullRefreshHeader;

public class SkinPullRefreshHeader
  extends RelativeLayout
  implements IPullRefreshHeader
{
  private static final int jdField_b_of_type_Int = Color.parseColor("#f7f7f7");
  private int jdField_a_of_type_Int = 0;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { Color.parseColor("#59000000"), 0 });
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View jdField_b_of_type_AndroidViewView;
  
  public SkinPullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setBackgroundColor(jdField_b_of_type_Int);
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
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
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
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      setBackgroundColor(jdField_b_of_type_Int);
      paramDrawable = this.jdField_a_of_type_AndroidViewView;
      if (paramDrawable != null)
      {
        if (paramBoolean)
        {
          paramDrawable.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
          return;
        }
        paramDrawable.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719252);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376346));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376344));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376341);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376347);
    c(0L);
  }
  
  public void setAdTabVisibility(boolean paramBoolean)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
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
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.SkinPullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */