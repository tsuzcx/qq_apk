package com.tencent.mobileqq.theme.diy;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

final class ThemeBackground$3
  implements View.OnLayoutChangeListener
{
  ThemeBackground$3(int paramInt, ThemeBackground paramThemeBackground) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeBackground", 2, "onLayoutChange bgType:" + this.val$bgType + " isAnimate:" + ThemeUtil.isHorizontalAnimate() + " view width:" + paramView.getWidth() + " height:" + paramView.getHeight());
    }
    if (paramView.getHeight() > 0)
    {
      paramView.removeOnLayoutChangeListener(this);
      ThemeBackground.access$100(paramView, this.val$bgType, this.val$themeBackground);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground.3
 * JD-Core Version:    0.7.0.1
 */