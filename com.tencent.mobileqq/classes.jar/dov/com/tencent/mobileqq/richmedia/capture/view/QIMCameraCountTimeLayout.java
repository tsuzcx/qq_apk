package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

public class QIMCameraCountTimeLayout
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  
  public QIMCameraCountTimeLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QIMCameraCountTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QIMCameraCountTimeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844409);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(6.0F), ViewUtils.dip2px(6.0F));
    localLayoutParams.gravity = 16;
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0秒");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165370);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167363));
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = ViewUtils.dip2px(4.0F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  public void setDotView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramInt);
  }
  
  public void setIsCircleStyle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public void setTextShadow(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165370);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Boolean) {
        break label35;
      }
    }
    label35:
    for (Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772225);; localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772007))
    {
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCountTimeLayout
 * JD-Core Version:    0.7.0.1
 */