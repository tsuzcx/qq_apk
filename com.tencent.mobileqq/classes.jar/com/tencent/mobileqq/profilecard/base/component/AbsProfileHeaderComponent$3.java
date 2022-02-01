package com.tencent.mobileqq.profilecard.base.component;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AbsProfileHeaderComponent$3
  extends SVIPObserver
{
  AbsProfileHeaderComponent$3(AbsProfileHeaderComponent paramAbsProfileHeaderComponent) {}
  
  public void onVipStatusChanged()
  {
    if ((AbsProfileHeaderComponent.access$000(this.this$0) != null) && (VipUtils.b(AbsProfileHeaderComponent.access$100(this.this$0))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsProfileHeaderComponent", 2, String.format("onVipStatusChanged mOpenSVipPay=%s", new Object[] { AbsProfileHeaderComponent.access$200(this.this$0) }));
      }
      if (this.this$0.mDelegate != null) {
        this.this$0.mDelegate.requestUpdateCard();
      }
      if ((AbsProfileHeaderComponent.access$300(this.this$0).compareAndSet(true, false)) && (AbsProfileHeaderComponent.access$200(this.this$0).get())) {
        DialogUtil.a(AbsProfileHeaderComponent.access$400(this.this$0), 232, null, HardCodeUtil.a(2131704914), null, HardCodeUtil.a(2131704922), new AbsProfileHeaderComponent.3.1(this), null).show();
      }
      AbsProfileHeaderComponent.access$600(this.this$0).removeObserver(AbsProfileHeaderComponent.access$500(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.3
 * JD-Core Version:    0.7.0.1
 */