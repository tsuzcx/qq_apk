package com.tencent.mobileqq.vip;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import dualsim.common.IKingCardInterface.OnChangeListener;
import dualsim.common.OrderCheckResult;
import mqq.app.AppRuntime;

class KCWraperV2$KingCardListener
  implements IKingCardInterface.OnChangeListener
{
  public void onChanged(OrderCheckResult paramOrderCheckResult)
  {
    if (QLog.isColorLevel()) {
      QLog.e("KC.KCWraperV2", 1, "state changed");
    }
    Object localObject = VasUtil.a();
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((AppRuntime)localObject).getAccount();
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramOrderCheckResult != null)) {
      KCWraper.a((String)localObject, paramOrderCheckResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2.KingCardListener
 * JD-Core Version:    0.7.0.1
 */