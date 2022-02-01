package com.tencent.mobileqq.nearby.guide;

import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class NearbyGuideActivity$1
  extends TransProcessorHandler
{
  NearbyGuideActivity$1(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    int j = paramMessage.what;
    int i = 0;
    if (j != 1002)
    {
      if (j != 1003)
      {
        if (j != 1005) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.upload_local_photo", 2, "NearbyGuideActivity.mPicUploadHandler.handleMessage(), upload fail.");
        }
        this.a.dismissProcessDialog();
        this.a.showToast(HardCodeUtil.a(2131905054));
        this.a.updateAvatar(true, null);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("NearbyGuideActivity.mPicUploadHandler.handleMessage(), upload success. photo_id = ");
        paramMessage.append(NearbyPeoplePhotoUploadProcessor.mPhotoId);
        QLog.d("Q.nearby_people_card.upload_local_photo", 2, paramMessage.toString());
      }
      i = NearbyPeoplePhotoUploadProcessor.mPhotoId;
      if (i >= 0) {
        this.a.mUploadPhotoIds.set(0, Integer.valueOf(i));
      }
      paramMessage = this.a;
      paramMessage.saveProfileInfo(paramMessage.mUploadPhotoIds);
      return;
    }
    if (localFileMsg.fileSize > 0L) {
      i = (int)(localFileMsg.transferedSize * 100L / localFileMsg.fileSize);
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder();
      paramMessage.append("NearbyGuideActivity .mPicUploadHandler.handleMessage, send process : ");
      paramMessage.append(i);
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, paramMessage.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.1
 * JD-Core Version:    0.7.0.1
 */