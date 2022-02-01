package com.tencent.mobileqq.emosm.web;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class MessengerService$IncomingHandler$18
  implements URLDrawable.URLDrawableListener
{
  MessengerService$IncomingHandler$18(MessengerService.IncomingHandler paramIncomingHandler, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle url onLoadCanceled:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle url failed:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IPC_CMD_PRELOAD_IMAGE", 2, "handle url down:" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.18
 * JD-Core Version:    0.7.0.1
 */