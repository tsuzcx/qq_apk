package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;

final class HWReciteItem$AudioUploadCallback
  implements TroopHomeworkHelper.UploadCallback
{
  HWReciteInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo;
  
  public HWReciteItem$AudioUploadCallback(HWReciteItem paramHWReciteItem, HWReciteInfo paramHWReciteInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo = paramHWReciteInfo;
  }
  
  public void a(int paramInt)
  {
    HWReciteItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteHWReciteItem).post(new HWReciteItem.AudioUploadCallback.1(this));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HWReciteItem", 2, "upload onComplete " + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g = 3;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("HWReciteItem", 2, "onError errorCode = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.g = 2;
    HWReciteItem.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteHWReciteItem).post(new HWReciteItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.AudioUploadCallback
 * JD-Core Version:    0.7.0.1
 */