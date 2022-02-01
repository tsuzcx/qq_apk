package com.tencent.mobileqq.emosm.web;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class MessengerService$IncomingHandler$17
  implements URLDrawable.URLDrawableListener
{
  MessengerService$IncomingHandler$17(MessengerService.IncomingHandler paramIncomingHandler, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("handle url onLoadCanceled:");
      paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("handle url failed:");
      paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("handle url down:");
      paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, paramURLDrawable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.17
 * JD-Core Version:    0.7.0.1
 */