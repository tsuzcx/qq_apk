package com.tencent.mobileqq.qqgift.business.qqlive;

import android.view.View;
import com.tencent.mobileqq.widget.QQBlur.onCalculateLocationListener;
import com.tencent.qphone.base.util.QLog;

class QQGiftPanelViewForLive$3
  implements QQBlur.onCalculateLocationListener
{
  QQGiftPanelViewForLive$3(QQGiftPanelViewForLive paramQQGiftPanelViewForLive) {}
  
  public void a(View paramView1, View paramView2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramView1 != null) && (paramView2 != null))
    {
      int[] arrayOfInt = new int[2];
      paramView1.getLocationOnScreen(arrayOfInt);
      paramView1 = new int[2];
      paramView2.getLocationOnScreen(paramView1);
      if (QLog.isColorLevel())
      {
        paramView2 = new StringBuilder();
        paramView2.append("[onLocationCalculate] bgLocationOnWindow:[");
        paramView2.append(paramArrayOfInt1[0]);
        paramView2.append(", ");
        paramView2.append(paramArrayOfInt1[1]);
        paramView2.append("]blurLocationOnWindow:[");
        paramView2.append(paramArrayOfInt2[0]);
        paramView2.append(", ");
        paramView2.append(paramArrayOfInt2[1]);
        paramView2.append("]bgLocationOnScreen:[");
        paramView2.append(arrayOfInt[0]);
        paramView2.append(", ");
        paramView2.append(arrayOfInt[1]);
        paramView2.append("]blurLocationOnScreen:[");
        paramView2.append(paramView1[0]);
        paramView2.append(", ");
        paramView2.append(paramView1[1]);
        paramView2.append("]");
        QLog.i("QQGiftPanelViewImpl", 1, paramView2.toString());
      }
      paramArrayOfInt1[0] = arrayOfInt[0];
      paramArrayOfInt1[1] = arrayOfInt[1];
      paramArrayOfInt2[0] = paramView1[0];
      paramArrayOfInt2[1] = paramView1[1];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewForLive.3
 * JD-Core Version:    0.7.0.1
 */