package com.tencent.mobileqq.qqlive.prepare;

import androidx.lifecycle.Observer;

final class QQLiveGamePrepareViewBinderHelper$5
  implements Observer<Integer>
{
  QQLiveGamePrepareViewBinderHelper$5(IQQLivePrepareView paramIQQLivePrepareView, PrepareFragmentViewModel paramPrepareFragmentViewModel) {}
  
  public void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1) {
      this.a.b();
    } else if (paramInteger.intValue() == 2) {
      this.a.a();
    }
    this.a.a(this.b.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLiveGamePrepareViewBinderHelper.5
 * JD-Core Version:    0.7.0.1
 */