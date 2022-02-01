package com.tencent.mobileqq.conditionsearch.widget;

import android.os.Vibrator;
import android.view.View;
import com.tencent.mobileqq.app.utils.SoundAndVibrateUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

class TimeSelectView$5
  implements AdapterView.OnItemSelectedListener
{
  TimeSelectView$5(TimeSelectView paramTimeSelectView) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TimeSelectView.a(this.a, paramView, 1);
    TimeSelectView.a(this.a, paramView, true);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt)
        {
          TimeSelectView.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
          TimeSelectView.a(this.a, paramAdapterView.getChildAt(paramInt), false);
        }
        paramInt += 1;
      }
    }
    if ((!TimeSelectView.d(this.a)) && (this.a.b != null))
    {
      this.a.b.vibrate(SoundAndVibrateUtils.g, -1);
      if (QLog.isColorLevel())
      {
        paramAdapterView = new StringBuilder();
        paramAdapterView.append("hasVibrator: ");
        paramAdapterView.append(this.a.b.hasVibrator());
        paramAdapterView.append("Vibrator vibrate! ");
        paramAdapterView.append(TimeSelectView.d(this.a));
        QLog.d("TimeSelectView", 1, paramAdapterView.toString());
      }
    }
    TimeSelectView.a(this.a, false);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.5
 * JD-Core Version:    0.7.0.1
 */