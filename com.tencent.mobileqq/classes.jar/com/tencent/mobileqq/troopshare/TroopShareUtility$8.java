package com.tencent.mobileqq.troopshare;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopShareUtility$8
  implements TroopShareUtility.UploadHeaderCallback
{
  TroopShareUtility$8(TroopShareUtility paramTroopShareUtility) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "shareToMobileQQ uploadNewTroopHeader result = " + paramBoolean + ",url = " + paramString);
    }
    if (paramBoolean)
    {
      this.a.d = paramString;
      TroopShareUtility.e(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131715642), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.8
 * JD-Core Version:    0.7.0.1
 */