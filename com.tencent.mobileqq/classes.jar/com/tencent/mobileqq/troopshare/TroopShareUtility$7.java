package com.tencent.mobileqq.troopshare;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class TroopShareUtility$7
  implements TroopShareUtility.UploadHeaderCallback
{
  TroopShareUtility$7(TroopShareUtility paramTroopShareUtility) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.d = paramString;
      TroopShareUtility.f(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131715639), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.7
 * JD-Core Version:    0.7.0.1
 */