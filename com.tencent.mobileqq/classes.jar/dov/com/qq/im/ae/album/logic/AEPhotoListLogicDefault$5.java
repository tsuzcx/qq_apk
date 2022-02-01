package dov.com.qq.im.ae.album.logic;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class AEPhotoListLogicDefault$5
  implements DialogInterface.OnClickListener
{
  AEPhotoListLogicDefault$5(AEPhotoListLogicDefault paramAEPhotoListLogicDefault) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicDefault.5
 * JD-Core Version:    0.7.0.1
 */