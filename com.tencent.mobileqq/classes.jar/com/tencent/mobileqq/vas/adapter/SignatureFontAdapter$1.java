package com.tencent.mobileqq.vas.adapter;

import android.os.Handler;
import com.tencent.mobileqq.vas.VasResEngine.VasResController;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class SignatureFontAdapter$1
  implements Observer
{
  SignatureFontAdapter$1(SignatureFontAdapter paramSignatureFontAdapter) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObservable = new StringBuilder();
      paramObservable.append("SignatureFontAdapter type = ");
      paramObservable.append(paramObject);
      QLog.d("SignatureFontAdapter", 2, paramObservable.toString());
    }
    if ((paramObject instanceof Integer))
    {
      int i = ((Integer)paramObject).intValue();
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.a.a.a().sendEmptyMessage(10002);
        return;
      }
      this.a.a.a().sendEmptyMessage(10003);
      return;
    }
    this.a.a.a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureFontAdapter.1
 * JD-Core Version:    0.7.0.1
 */