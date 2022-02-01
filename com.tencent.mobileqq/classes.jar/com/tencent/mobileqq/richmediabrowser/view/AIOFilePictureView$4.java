package com.tencent.mobileqq.richmediabrowser.view;

import android.content.Context;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.utils.FileSizeFormat;
import java.util.Locale;

class AIOFilePictureView$4
  implements MessageQueue.IdleHandler
{
  AIOFilePictureView$4(AIOFilePictureView paramAIOFilePictureView) {}
  
  public boolean queueIdle()
  {
    AIOFilePictureData localAIOFilePictureData = this.a.k.r();
    if (localAIOFilePictureData != null)
    {
      AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
      if ((localAIOFilePictureModel.a(localAIOFilePictureData, 20)) && (localAIOFilePictureModel.c(localAIOFilePictureData, 20) == null))
      {
        if ((localAIOFilePictureData.r) && (MessageRecordInfo.b(localAIOFilePictureData.u)))
        {
          this.a.g(true);
          this.a.a();
        }
        else if (localAIOFilePictureData.t)
        {
          this.a.g(false);
        }
        else
        {
          this.a.g(true);
        }
        this.a.a(String.format(Locale.CHINA, this.a.c.getString(2131915747), new Object[] { FileSizeFormat.a(localAIOFilePictureData.s) }));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.4
 * JD-Core Version:    0.7.0.1
 */