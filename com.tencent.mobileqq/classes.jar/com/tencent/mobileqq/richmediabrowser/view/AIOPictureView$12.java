package com.tencent.mobileqq.richmediabrowser.view;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureModel;

class AIOPictureView$12
  implements MessageQueue.IdleHandler
{
  AIOPictureView$12(AIOPictureView paramAIOPictureView) {}
  
  public boolean queueIdle()
  {
    AIOPictureData localAIOPictureData = this.a.a();
    AIOPictureModel localAIOPictureModel = new AIOPictureModel();
    if ((localAIOPictureData != null) && (localAIOPictureModel.a(localAIOPictureData, 4)) && (localAIOPictureModel.a(localAIOPictureData, 4) == null))
    {
      this.a.f(true);
      this.a.updateUI();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.12
 * JD-Core Version:    0.7.0.1
 */