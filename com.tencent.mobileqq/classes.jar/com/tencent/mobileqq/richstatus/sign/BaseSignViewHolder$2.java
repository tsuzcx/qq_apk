package com.tencent.mobileqq.richstatus.sign;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

class BaseSignViewHolder$2
  implements Observer
{
  BaseSignViewHolder$2(BaseSignViewHolder paramBaseSignViewHolder) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      if (((Integer)paramObject).intValue() != 3) {
        return;
      }
      paramObservable = this.a.a();
      if ((paramObservable != null) && (!paramObservable.a.get()) && (this.a.b == true) && (this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (!this.a.c) && (!this.a.d))
      {
        if (QLog.isColorLevel())
        {
          paramObservable = new StringBuilder();
          paramObservable.append("update tplId=");
          paramObservable.append(this.a.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
          QLog.i("BaseSignViewHolder", 2, paramObservable.toString());
        }
        ThreadManager.getUIHandlerV2().removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().post(this.a.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder.2
 * JD-Core Version:    0.7.0.1
 */