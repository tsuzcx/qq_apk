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
    AIOFilePictureData localAIOFilePictureData = this.a.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if (localAIOFilePictureData != null)
    {
      AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
      if ((localAIOFilePictureModel.a(localAIOFilePictureData, 20)) && (localAIOFilePictureModel.a(localAIOFilePictureData, 20) == null))
      {
        if ((localAIOFilePictureData.g) && (MessageRecordInfo.a(localAIOFilePictureData.d)))
        {
          this.a.g(true);
          this.a.a();
        }
        else if (localAIOFilePictureData.h)
        {
          this.a.g(false);
        }
        else
        {
          this.a.g(true);
        }
        this.a.a(String.format(Locale.CHINA, this.a.jdField_a_of_type_AndroidContentContext.getString(2131718255), new Object[] { FileSizeFormat.a(localAIOFilePictureData.e) }));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.4
 * JD-Core Version:    0.7.0.1
 */