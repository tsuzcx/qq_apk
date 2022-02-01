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
    int i = paramMessage.what;
    if (i != 1003)
    {
      if (i != 1005) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.upload_local_photo", 2, "Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload fail.");
      }
      this.a.a.dismissWaittingDialog();
      this.a.a.showToast(HardCodeUtil.a(2131707335));
      return;
    }
    if (localFileMsg.fileType == 8)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("Q.nearby_people_card..mPicUploadHandler.handleMessage(), upload success. photo_id = ");
        paramMessage.append(NearbyPeoplePhotoUploadProcessor.mPhotoId);
        QLog.i("Q.nearby_people_card.upload_local_photo", 2, paramMessage.toString());
      }
      if (NearbyProfileEditPanel.a(this.a) != null)
      {
        NearbyProfileEditPanel.a(this.a).a = NearbyPeoplePhotoUploadProcessor.mPhotoId;
        NearbyProfileEditPanel.d(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.21
 * JD-Core Version:    0.7.0.1
 */