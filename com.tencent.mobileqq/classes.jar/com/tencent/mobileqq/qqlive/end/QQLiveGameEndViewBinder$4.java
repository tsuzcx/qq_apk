package com.tencent.mobileqq.qqlive.end;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;

class QQLiveGameEndViewBinder$4
  implements Observer<Long>
{
  QQLiveGameEndViewBinder$4(QQLiveGameEndViewBinder paramQQLiveGameEndViewBinder, IQQLiveEndView paramIQQLiveEndView) {}
  
  public void a(Long paramLong)
  {
    this.a.setLiveTime(paramLong.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.end.QQLiveGameEndViewBinder.4
 * JD-Core Version:    0.7.0.1
 */