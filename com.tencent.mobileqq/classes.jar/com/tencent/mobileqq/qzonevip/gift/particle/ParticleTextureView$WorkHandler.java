package com.tencent.mobileqq.qzonevip.gift.particle;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ParticleTextureView$WorkHandler
  extends Handler
{
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  
  public ParticleTextureView$WorkHandler(ParticleTextureView paramParticleTextureView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage: MSG_REFRESH_VIEW size = ");
          paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.jdField_a_of_type_JavaUtilArrayList.size());
          QLog.i("ParticleTextureView", 1, paramMessage.toString());
          if ((this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.jdField_a_of_type_JavaUtilArrayList.size() > 0) || (!this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.jdField_a_of_type_Boolean)) {
            this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.d();
          }
        }
        else
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView;
          paramMessage.c += 1;
          this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.a();
          if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.a())
          {
            ParticleTextureView.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView, 2);
            return;
          }
          ParticleTextureView.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView, 4);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.c = 0;
        QLog.i("ParticleTextureView", 1, "handleMessage: MSG_ADD_DATA");
        this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap);
        ParticleTextureView.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView, 4);
      }
    }
    else
    {
      QLog.i("ParticleTextureView", 1, "handleMessage: MSG_INIT_DATA");
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.a();
      ParticleTextureView.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView.WorkHandler
 * JD-Core Version:    0.7.0.1
 */