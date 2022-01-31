package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class BaseTransFileController$ProcHandler
  extends Handler
{
  public BaseTransFileController$ProcHandler(BaseTransFileController paramBaseTransFileController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(BaseTransProcessor paramBaseTransProcessor)
  {
    sendMessage(obtainMessage(0, paramBaseTransProcessor));
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof BaseTransProcessor))) {
      paramMessage = (BaseTransProcessor)paramMessage.obj;
    }
    try
    {
      TransferRequest localTransferRequest = paramMessage.a();
      if ((localTransferRequest != null) && (localTransferRequest.jdField_a_of_type_Long != 0L) && (localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) && ((paramMessage.a instanceof QQAppInterface))) {
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((QQAppInterface)paramMessage.a).a().b(localTransferRequest.c, localTransferRequest.jdField_a_of_type_Int, localTransferRequest.jdField_a_of_type_Long);
      }
    }
    catch (Exception localException)
    {
      label96:
      break label96;
    }
    paramMessage.ap_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransFileController.ProcHandler
 * JD-Core Version:    0.7.0.1
 */