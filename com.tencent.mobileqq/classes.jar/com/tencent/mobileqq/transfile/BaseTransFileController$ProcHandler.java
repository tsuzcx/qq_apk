package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseTransFileController$ProcHandler
  extends Handler
{
  public static final int RUN = 0;
  
  public BaseTransFileController$ProcHandler(BaseTransFileController paramBaseTransFileController) {}
  
  public BaseTransFileController$ProcHandler(BaseTransFileController paramBaseTransFileController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof BaseTransProcessor))) {
      paramMessage = (BaseTransProcessor)paramMessage.obj;
    }
    try
    {
      TransferRequest localTransferRequest = paramMessage.getTransferRequest();
      if ((localTransferRequest != null) && (localTransferRequest.mUniseq != 0L) && (localTransferRequest.mRec == null) && ((paramMessage.app instanceof QQAppInterface))) {
        localTransferRequest.mRec = ((QQAppInterface)paramMessage.app).getMessageFacade().queryMsgItemByUniseq(localTransferRequest.mPeerUin, localTransferRequest.mUinType, localTransferRequest.mUniseq);
      }
    }
    catch (Exception localException)
    {
      label96:
      break label96;
    }
    paramMessage.start();
  }
  
  public void startProcessor(BaseTransProcessor paramBaseTransProcessor)
  {
    sendMessage(obtainMessage(0, paramBaseTransProcessor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransFileController.ProcHandler
 * JD-Core Version:    0.7.0.1
 */