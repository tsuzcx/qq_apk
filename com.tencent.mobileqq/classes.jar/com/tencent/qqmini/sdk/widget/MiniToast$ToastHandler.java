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
    if (paramMiniToast == null) {
      return;
    }
    MiniToast.access$402(paramMiniToast, false);
    if (MiniToast.access$900(paramMiniToast) != null) {
      MiniToast.access$900(paramMiniToast).cancel();
    }
  }
  
  private void scheduleHideToast(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scheduleNextToast to ");
    localStringBuilder.append(paramLong);
    QMLog.d("QQToast", localStringBuilder.toString());
    removeMessages(2);
    sendEmptyMessageDelayed(2, paramLong);
  }
  
  private void scheduleShowToast(MiniToast paramMiniToast, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scheduleNextToast to ");
    localStringBuilder.append(paramLong);
    QMLog.d("QQToast", localStringBuilder.toString());
    removeMessages(1);
    MiniToast.access$300().add(new WeakReference(paramMiniToast));
    sendEmptyMessageDelayed(1, paramLong);
  }
  
  private void showToastImmediately(MiniToast paramMiniToast)
  {
    if (paramMiniToast == null) {
      return;
    }
    if (!MiniToast.access$400(paramMiniToast))
    {
      MiniToast.access$502(paramMiniToast, System.currentTimeMillis() + MiniToast.access$600(paramMiniToast));
      MiniToast.access$402(paramMiniToast, true);
    }
    paramMiniToast.show();
    int i;
    if (MiniToast.access$700(paramMiniToast) == 0) {
      i = 200;
    } else {
      i = 400;
    }
    long l1 = MiniToast.access$800(paramMiniToast);
    long l2 = i;
    if (l1 + l2 < MiniToast.access$500(paramMiniToast))
    {
      MiniToast.access$300().add(new WeakReference(paramMiniToast));
      scheduleShowToast(paramMiniToast, MiniToast.access$800(paramMiniToast) + l2 - System.currentTimeMillis());
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (QMLog.isColorLevel()) {
        QMLog.d("QQToast", "MSG_HIDE_TOAST received");
      }
      paramMessage = (WeakReference)MiniToast.access$300().poll();
      if (paramMessage == null) {
        return;
      }
      hideToastImmediately((MiniToast)paramMessage.get());
      return;
    }
    if (QMLog.isColorLevel()) {
      QMLog.d("QQToast", "MSG_SHOW_TOAST received");
    }
    paramMessage = (WeakReference)MiniToast.access$300().poll();
    if (paramMessage == null) {
      return;
    }
    showToastImmediately((MiniToast)paramMessage.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniToast.ToastHandler
 * JD-Core Version:    0.7.0.1
 */