package com.tencent.qqmini.sdk.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;

class MiniToast$ToastHandler
  extends Handler
{
  static final int MSG_HIDE_TOAST = 2;
  static final int MSG_SHOW_TOAST = 1;
  
  private MiniToast$ToastHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void hideToastImmediately(MiniToast paramMiniToast)
  {
    if (paramMiniToast == null) {}
    do
    {
      return;
      MiniToast.access$402(paramMiniToast, false);
    } while (MiniToast.access$900(paramMiniToast) == null);
    MiniToast.access$900(paramMiniToast).cancel();
  }
  
  private void scheduleHideToast(long paramLong)
  {
    QMLog.d("QQToast", "scheduleNextToast to " + paramLong);
    removeMessages(2);
    sendEmptyMessageDelayed(2, paramLong);
  }
  
  private void scheduleShowToast(MiniToast paramMiniToast, long paramLong)
  {
    QMLog.d("QQToast", "scheduleNextToast to " + paramLong);
    removeMessages(1);
    MiniToast.access$300().add(new WeakReference(paramMiniToast));
    sendEmptyMessageDelayed(1, paramLong);
  }
  
  private void showToastImmediately(MiniToast paramMiniToast)
  {
    if (paramMiniToast == null) {}
    for (;;)
    {
      return;
      if (!MiniToast.access$400(paramMiniToast))
      {
        MiniToast.access$502(paramMiniToast, System.currentTimeMillis() + MiniToast.access$600(paramMiniToast));
        MiniToast.access$402(paramMiniToast, true);
      }
      paramMiniToast.show();
      if (MiniToast.access$700(paramMiniToast) == 0) {}
      for (int i = 200; MiniToast.access$800(paramMiniToast) + i < MiniToast.access$500(paramMiniToast); i = 400)
      {
        MiniToast.access$300().add(new WeakReference(paramMiniToast));
        long l = MiniToast.access$800(paramMiniToast);
        scheduleShowToast(paramMiniToast, i + l - System.currentTimeMillis());
        return;
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        if (QMLog.isColorLevel()) {
          QMLog.d("QQToast", "MSG_SHOW_TOAST received");
        }
        paramMessage = (WeakReference)MiniToast.access$300().poll();
      } while (paramMessage == null);
      showToastImmediately((MiniToast)paramMessage.get());
      return;
      if (QMLog.isColorLevel()) {
        QMLog.d("QQToast", "MSG_HIDE_TOAST received");
      }
      paramMessage = (WeakReference)MiniToast.access$300().poll();
    } while (paramMessage == null);
    hideToastImmediately((MiniToast)paramMessage.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniToast.ToastHandler
 * JD-Core Version:    0.7.0.1
 */