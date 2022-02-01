package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import java.util.Locale;

class AIOFilePictureView$5
  implements MessageQueue.IdleHandler
{
  AIOFilePictureView$5(AIOFilePictureView paramAIOFilePictureView) {}
  
  public boolean queueIdle()
  {
    AIOFilePictureData localAIOFilePictureData = this.a.a.a();
    if (localAIOFilePictureData != null)
    {
      AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
      if ((localAIOFilePictureModel.a(localAIOFilePictureData, 20)) && (localAIOFilePictureModel.a(localAIOFilePictureData, 20) == null))
      {
        if ((!localAIOFilePictureData.g) || (!MessageRecordInfo.a(localAIOFilePictureData.d))) {
          break label116;
        }
        this.a.f(true);
        this.a.updateUI();
      }
    }
    for (;;)
    {
      this.a.a(String.format(Locale.CHINA, this.a.mContext.getString(2131695009), new Object[] { FileUtil.a(localAIOFilePictureData.e) }));
      return false;
      label116:
      if (localAIOFilePictureData.h) {
        this.a.f(false);
      } else {
        this.a.f(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.5
 * JD-Core Version:    0.7.0.1
 */