package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;

class QQToastNotifier$1
  extends Handler
{
  QQToastNotifier$1(QQToastNotifier paramQQToastNotifier, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQToastNotifier.ToastData localToastData = (QQToastNotifier.ToastData)paramMessage.obj;
    Object localObject = localToastData.msgString;
    if (localObject != null)
    {
      paramMessage = (Message)localObject;
      if (((String)localObject).length() != 0) {}
    }
    else
    {
      try
      {
        paramMessage = this.this$0.mContext.getResources().getString(localToastData.msgId);
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        paramMessage = (Message)localObject;
      }
    }
    if (this.this$0.mToast == null)
    {
      localObject = this.this$0;
      ((QQToastNotifier)localObject).mToast = QQToast.makeText(((QQToastNotifier)localObject).mContext, localToastData.icon, paramMessage, localToastData.duration).create(localToastData.offset);
    }
    else
    {
      try
      {
        localObject = this.this$0.mToast.getView();
        ((TextView)((View)localObject).findViewById(2131447672)).setText(paramMessage);
        ((ImageView)((View)localObject).findViewById(2131447670)).setImageResource(QQToast.getIconRes(localToastData.icon));
        this.this$0.mToast.setDuration(localToastData.duration);
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        this.this$0.mToast = null;
        if (QLog.isColorLevel()) {
          QLog.i("QQToastNotifier", 2, paramMessage.toString());
        }
      }
    }
    if (this.this$0.mToast != null) {
      this.this$0.mToast.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToastNotifier.1
 * JD-Core Version:    0.7.0.1
 */