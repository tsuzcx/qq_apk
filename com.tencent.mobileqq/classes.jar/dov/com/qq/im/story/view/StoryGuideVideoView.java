package dov.com.qq.im.story.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import blbz;
import dov.com.tencent.mobileqq.richmedia.capture.view.FadedButton;
import dov.com.tencent.mobileqq.richmedia.capture.view.GuideVideoView;
import mqq.os.MqqHandler;
import vzo;

public class StoryGuideVideoView
  extends GuideVideoView
{
  public StoryGuideVideoView(Context paramContext, MqqHandler paramMqqHandler)
  {
    super(paramContext, paramMqqHandler);
  }
  
  public void a()
  {
    super.a();
    removeView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton);
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((LinearLayout.LayoutParams)localObject).width, ((LinearLayout.LayoutParams)localObject).height);
    removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    localObject = new RelativeLayout(getContext());
    addView((View)localObject, -1, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton.setBackgroundResource(2130845843);
    localLayoutParams = new RelativeLayout.LayoutParams(blbz.a(40.0F), blbz.a(40.0F));
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(11);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton.setOnClickListener(this);
    int i = vzo.a(getContext(), 17.0F);
    localLayoutParams.setMargins(0, this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingTop() - i, this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight() - i, 0);
    ((RelativeLayout)localObject).addView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewFadedButton);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.story.view.StoryGuideVideoView
 * JD-Core Version:    0.7.0.1
 */