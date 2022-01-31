package org.libpag;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class PAGView$PAGRendererHandler
  extends Handler
{
  public PAGView$PAGRendererHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (!(paramMessage.obj instanceof PAGView)) {}
    PAGView localPAGView;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localPAGView = (PAGView)paramMessage.obj;
          } while (localPAGView == null);
          switch (paramMessage.what)
          {
          default: 
            return;
          }
        } while (PAGView.access$000(localPAGView) == null);
        float f = paramMessage.arg1 / 1.0E+008F;
        PAGView.access$000(localPAGView).setProgress(f);
        PAGView.access$000(localPAGView).flush();
        return;
      } while (PAGView.access$000(localPAGView) == null);
      PAGView.access$000(localPAGView).flush();
      return;
    } while (PAGView.access$100() == null);
    PAGView.access$100().removeCallbacksAndMessages(localPAGView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.libpag.PAGView.PAGRendererHandler
 * JD-Core Version:    0.7.0.1
 */