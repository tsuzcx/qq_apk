package com.tencent.mobileqq.troop.troopcard;

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
    if ((VisitorTroopCardPresenter.a(this.a) != null) && (VisitorTroopCardPresenter.a(this.a) != null))
    {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        return;
      }
      if (!VisitorTroopCardPresenter.a(this.a).isFinishing())
      {
        if (VisitorTroopCardPresenter.a(this.a)) {
          return;
        }
        VisitorTroopCardPresenter.a(this.a).d();
        if (VisitorTroopCardPresenter.a(this.a) != null) {
          VisitorTroopCardPresenter.a(this.a).removeCallbacksAndMessages(null);
        }
        if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null) && (!paramOpenID.openID.equals(VisitorTroopCardPresenter.a(this.a)))) {
          VisitorTroopCardPresenter.a(this.a).aQ_();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardPresenter.2
 * JD-Core Version:    0.7.0.1
 */