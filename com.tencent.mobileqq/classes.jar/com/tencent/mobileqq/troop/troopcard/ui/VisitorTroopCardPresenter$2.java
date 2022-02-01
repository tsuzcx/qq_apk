package com.tencent.mobileqq.troop.troopcard.ui;

import android.os.Handler;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class VisitorTroopCardPresenter$2
  extends BaseMessageObserver
{
  VisitorTroopCardPresenter$2(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((VisitorTroopCardPresenter.c(this.a) != null) && (VisitorTroopCardPresenter.d(this.a) != null))
    {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        return;
      }
      if (!VisitorTroopCardPresenter.a(this.a).isFinishing())
      {
        if (VisitorTroopCardPresenter.e(this.a)) {
          return;
        }
        VisitorTroopCardPresenter.b(this.a).e();
        if (VisitorTroopCardPresenter.f(this.a) != null) {
          VisitorTroopCardPresenter.f(this.a).removeCallbacksAndMessages(null);
        }
        if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null) && (!paramOpenID.openID.equals(VisitorTroopCardPresenter.g(this.a)))) {
          VisitorTroopCardPresenter.b(this.a).c();
        }
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",data=");
    localStringBuilder.append(paramObject);
    QLog.d("openid", 2, localStringBuilder.toString());
    a(paramBoolean, (OpenID)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardPresenter.2
 * JD-Core Version:    0.7.0.1
 */