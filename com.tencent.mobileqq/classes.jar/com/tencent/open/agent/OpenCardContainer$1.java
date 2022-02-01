package com.tencent.open.agent;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;

class OpenCardContainer$1
  extends Handler
{
  OpenCardContainer$1(OpenCardContainer paramOpenCardContainer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SDK_LOGIN.OpenCardContainer", 2, "-->handleMessage MSG_UPDATE");
      }
      OpenCardContainer.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.1
 * JD-Core Version:    0.7.0.1
 */