package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopPhotoController$9
  extends TroopAvatarObserver
{
  TroopPhotoController$9(TroopPhotoController paramTroopPhotoController) {}
  
  protected void onCmdTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (!Utils.a(paramString1, this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onCmdTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
    }
    this.a.a(true);
  }
  
  protected void onGetTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
      return;
    }
    if (paramBoolean)
    {
      if (!Utils.a(paramString1, this.a.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("onGetTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
      }
      if (paramInt1 == 0) {
        this.a.a(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopPhotoController.9
 * JD-Core Version:    0.7.0.1
 */