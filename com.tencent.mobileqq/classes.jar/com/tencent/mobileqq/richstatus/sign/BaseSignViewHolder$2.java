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
      paramObservable = this.a.g();
      if ((paramObservable != null) && (!paramObservable.a.get()) && (this.a.I == true) && (this.a.w != null) && (!this.a.J) && (!this.a.K))
      {
        if (QLog.isColorLevel())
        {
          paramObservable = new StringBuilder();
          paramObservable.append("update tplId=");
          paramObservable.append(this.a.w.tplId);
          QLog.i("BaseSignViewHolder", 2, paramObservable.toString());
        }
        ThreadManager.getUIHandlerV2().removeCallbacks(this.a.P);
        ThreadManager.getUIHandlerV2().post(this.a.P);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder.2
 * JD-Core Version:    0.7.0.1
 */