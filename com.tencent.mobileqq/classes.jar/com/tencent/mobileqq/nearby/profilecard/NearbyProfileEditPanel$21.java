package com.tencent.mobileqq.nearby.profilecard;

import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class NearbyProfileEditPanel$21
  extends TransProcessorHandler
{
  NearbyProfileEditPanel$21(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
    case 1003: 
      do
      {
        do
        {
          return;
        } while (localFileMsg.fileType != 8);
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = " + NearbyPeoplePhotoUploadProcessor.mPhotoId);
        }
      } while (NearbyProfileEditPanel.a(this.a) == null);
      NearbyProfileEditPanel.a(this.a).a = NearbyPeoplePhotoUploadProcessor.mPhotoId;
      NearbyProfileEditPanel.d(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
    }
    this.a.a.b();
    this.a.a.b(HardCodeUtil.a(2131707310));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.21
 * JD-Core Version:    0.7.0.1
 */