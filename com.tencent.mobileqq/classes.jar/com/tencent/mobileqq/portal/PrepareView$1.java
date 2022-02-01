package com.tencent.mobileqq.portal;

import android.os.CountDownTimer;
import android.widget.TextView;

class PrepareView$1
  extends CountDownTimer
{
  PrepareView$1(PrepareView paramPrepareView, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    PrepareView.a(this.a).setText("00");
    PrepareView.b(this.a).setText("00");
    this.a.a();
  }
  
  public void onTick(long paramLong)
  {
    int j = (int)(paramLong / 1000L);
    int i = j / 60;
    j %= 60;
    Object localObject1 = Integer.toString(i);
    Object localObject2 = Integer.toString(j);
    if (i < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(Integer.toString(i));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (j < 10)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(Integer.toString(j));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    PrepareView.a(this.a).setText((CharSequence)localObject1);
    PrepareView.b(this.a).setText((CharSequence)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PrepareView.1
 * JD-Core Version:    0.7.0.1
 */