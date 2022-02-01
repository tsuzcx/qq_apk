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
    if (QLog.isColorLevel()) {
      QLog.d("SignatureFontAdapter", 2, "SignatureFontAdapter type = " + paramObject);
    }
    if ((paramObject instanceof Integer))
    {
      switch (((Integer)paramObject).intValue())
      {
      default: 
        return;
      case 1: 
        this.a.a.a().sendEmptyMessage(10003);
        return;
      }
      this.a.a.a().sendEmptyMessage(10002);
      return;
    }
    this.a.a.a().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adapter.SignatureFontAdapter.1
 * JD-Core Version:    0.7.0.1
 */