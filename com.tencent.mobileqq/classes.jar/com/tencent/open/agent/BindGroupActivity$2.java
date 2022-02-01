package com.tencent.open.agent;

import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class BindGroupActivity$2
  extends OpenIdObserver
{
  BindGroupActivity$2(BindGroupActivity paramBindGroupActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->onGetOpenId, isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" data: ");
      localStringBuilder.append(paramOpenID.toString());
      QLog.d("BindGroupActivity", 2, localStringBuilder.toString());
    }
    if (!this.a.isFinishing())
    {
      if (this.a.x) {
        return;
      }
      this.a.v.hide();
      if (this.a.w != null) {
        this.a.w.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "openIdObserver success");
        }
        this.a.p = paramOpenID.openID;
        if (!paramOpenID.openID.equals(this.a.o))
        {
          this.a.b();
          return;
        }
        this.a.a();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BindGroupActivity", 2, "openIdObserver fail");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.2
 * JD-Core Version:    0.7.0.1
 */