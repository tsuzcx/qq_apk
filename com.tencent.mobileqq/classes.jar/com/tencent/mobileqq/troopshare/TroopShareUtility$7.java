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
      TroopShareUtility localTroopShareUtility = this.a;
      localTroopShareUtility.f = paramString;
      TroopShareUtility.f(localTroopShareUtility);
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131913035), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.7
 * JD-Core Version:    0.7.0.1
 */