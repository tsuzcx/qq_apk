package com.tencent.mobileqq.qqlive.prepare;

import android.text.TextUtils;
import androidx.lifecycle.Observer;

final class QQLiveGamePrepareViewBinderHelper$6
  implements Observer<LocationData>
{
  QQLiveGamePrepareViewBinderHelper$6(IQQLivePrepareView paramIQQLivePrepareView) {}
  
  public void a(LocationData paramLocationData)
  {
    if ((!TextUtils.isEmpty(paramLocationData.b)) && (paramLocationData.a))
    {
      this.a.c(paramLocationData.b);
      return;
    }
    this.a.c("我的位置");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLiveGamePrepareViewBinderHelper.6
 * JD-Core Version:    0.7.0.1
 */