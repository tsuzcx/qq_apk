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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareToMobileQQ uploadNewTroopHeader result = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopShareUtility", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.a;
      ((TroopShareUtility)localObject).f = paramString;
      TroopShareUtility.e((TroopShareUtility)localObject);
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131913038), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.8
 * JD-Core Version:    0.7.0.1
 */