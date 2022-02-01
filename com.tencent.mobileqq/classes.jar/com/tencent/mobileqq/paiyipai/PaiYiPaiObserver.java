package com.tencent.mobileqq.paiyipai;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class PaiYiPaiObserver
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiObserver", 2, "onUpdate() called with: type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], data = [" + paramObject + "]");
    }
    switch (paramInt)
    {
    case 1003: 
    case 1004: 
    case 1005: 
    default: 
      return;
    case 1001: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694714, 0).a();
      return;
    case 1002: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694709, 0).a();
      return;
    case 1006: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694710, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694705, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.paiyipai.PaiYiPaiObserver
 * JD-Core Version:    0.7.0.1
 */