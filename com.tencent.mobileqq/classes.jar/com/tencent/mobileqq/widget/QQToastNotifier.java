package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

public class QQToastNotifier
{
  private static final int MSG_SHOW_TOAST = 1;
  private Handler handler = new QQToastNotifier.1(this, Looper.getMainLooper());
  Context mContext = BaseApplication.getContext();
  Toast mToast = null;
  
  public QQToastNotifier(Context paramContext) {}
  
  public void cancelQQToast()
  {
    Toast localToast = this.mToast;
    if (localToast != null) {
      localToast.cancel();
    }
  }
  
  public void notifyUser(int paramInt)
  {
    notifyUser(paramInt, 0, 0, 0);
  }
  
  public void notifyUser(int paramInt1, int paramInt2)
  {
    notifyUser(paramInt1, paramInt2, 0, 0);
  }
  
  public void notifyUser(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    QQToastNotifier.ToastData localToastData = new QQToastNotifier.ToastData(null);
    localToastData.icon = paramInt4;
    localToastData.msgId = paramInt1;
    localToastData.duration = paramInt3;
    localToastData.offset = paramInt2;
    localMessage.obj = localToastData;
    this.handler.removeMessages(1);
    this.handler.sendMessage(localMessage);
  }
  
  public void notifyUser(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    QQToastNotifier.ToastData localToastData = new QQToastNotifier.ToastData(null);
    localToastData.icon = paramInt3;
    localToastData.msgString = paramString;
    localToastData.duration = paramInt2;
    localToastData.offset = paramInt1;
    localMessage.obj = localToastData;
    this.handler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToastNotifier
 * JD-Core Version:    0.7.0.1
 */