package com.tencent.mobileqq.vas.theme.diy;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

final class ThemeBackground$7
  implements View.OnLayoutChangeListener
{
  ThemeBackground$7(int paramInt, ThemeBackground paramThemeBackground) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayoutChange bgType:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" isAnimate:");
      localStringBuilder.append(ThemeUtil.isHorizontalAnimate());
      localStringBuilder.append(" view width:");
      localStringBuilder.append(paramView.getWidth());
      localStringBuilder.append(" height:");
      localStringBuilder.append(paramView.getHeight());
      QLog.d("ThemeBackground", 2, localStringBuilder.toString());
    }
    if (paramView.getHeight() > 0)
    {
      paramView.removeOnLayoutChangeListener(this);
      ThemeBackground.a(paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.7
 * JD-Core Version:    0.7.0.1
 */