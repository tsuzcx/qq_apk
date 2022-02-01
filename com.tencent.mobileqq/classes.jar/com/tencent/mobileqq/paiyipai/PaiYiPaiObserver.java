package com.tencent.mobileqq.paiyipai;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class PaiYiPaiObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate() called with: type = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], isSuccess = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], data = [");
      localStringBuilder.append(paramObject);
      localStringBuilder.append("]");
      QLog.d("PaiYiPaiObserver", 2, localStringBuilder.toString());
    }
    if (paramInt != 9998) {
      if (paramInt == 9999) {}
    }
    switch (paramInt)
    {
    default: 
    case 1007: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694681, 0).a();
      return;
    case 1006: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694688, 0).a();
      return;
    case 1002: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694686, 0).a();
      return;
    case 1001: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694692, 0).a();
      return;
      a(paramBoolean);
      return;
      a(paramBoolean, ((Integer)paramObject).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.paiyipai.PaiYiPaiObserver
 * JD-Core Version:    0.7.0.1
 */