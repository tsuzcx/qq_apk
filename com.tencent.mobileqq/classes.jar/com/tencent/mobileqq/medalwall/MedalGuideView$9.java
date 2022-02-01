package com.tencent.mobileqq.medalwall;

import android.widget.ImageButton;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class MedalGuideView$9
  implements PopupWindow.OnDismissListener
{
  MedalGuideView$9(MedalGuideView paramMedalGuideView) {}
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onDismiss  endOfAnim: %s", new Object[] { Boolean.valueOf(this.a.s) }));
    }
    MedalGuideView localMedalGuideView = this.a;
    localMedalGuideView.s = true;
    localMedalGuideView.h.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView.9
 * JD-Core Version:    0.7.0.1
 */