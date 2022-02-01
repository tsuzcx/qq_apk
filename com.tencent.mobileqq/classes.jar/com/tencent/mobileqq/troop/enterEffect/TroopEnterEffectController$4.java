package com.tencent.mobileqq.troop.enterEffect;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class TroopEnterEffectController$4
  extends CallBacker
{
  TroopEnterEffectController$4(TroopEnterEffectController paramTroopEnterEffectController) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 25L) && (paramString1.startsWith("groupeffect_item_")) && (paramInt1 == 0))
    {
      paramInt1 = TroopEnterEffectController.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "download Res callback success id = " + paramInt1);
      }
      if (paramInt1 > 0)
      {
        paramString1 = (TroopEnterEffectController.TroopEnterEffectData)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
        this.a.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
        if (paramString1 == null) {
          break label154;
        }
        if (TroopGiftUtil.a(new File(TroopEnterEffectController.jdField_a_of_type_JavaLangString + paramInt1))) {
          this.a.jdField_a_of_type_AndroidOsHandler.post(new TroopEnterEffectController.4.1(this, paramInt1, paramString1));
        }
      }
    }
    return;
    label154:
    QLog.e("TroopEnterEffect.Controller", 1, "mResDownloadCallback effectData = null id = " + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.4
 * JD-Core Version:    0.7.0.1
 */