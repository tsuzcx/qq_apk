package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

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
    if ((paramMessage.what == 0) && (paramMessage.obj != null) && ((paramMessage.obj instanceof BaseTransProcessor)))
    {
      paramMessage = (BaseTransProcessor)paramMessage.obj;
      this.this$0.fillTransRequestMessage(paramMessage);
      paramMessage.start();
    }
  }
  
  public void startProcessor(BaseTransProcessor paramBaseTransProcessor)
  {
    sendMessage(obtainMessage(0, paramBaseTransProcessor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransFileController.ProcHandler
 * JD-Core Version:    0.7.0.1
 */