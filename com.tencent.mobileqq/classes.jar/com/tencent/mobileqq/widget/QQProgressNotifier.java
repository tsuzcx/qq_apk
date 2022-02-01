package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class QQProgressNotifier
  implements DialogInterface.OnCancelListener, Handler.Callback
{
  protected QQProgressDialog d;
  protected final WeakReference<Activity> e;
  int f;
  protected final Handler g;
  protected final ArrayList<DialogInterface.OnCancelListener> h;
  
  public QQProgressNotifier(Activity paramActivity)
  {
    this(paramActivity, -1);
  }
  
  public QQProgressNotifier(Activity paramActivity, int paramInt)
  {
    this.e = new WeakReference(paramActivity);
    this.f = paramInt;
    this.h = new ArrayList();
    this.g = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, paramString, paramInt2, null);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Activity localActivity = (Activity)this.e.get();
    if (localActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
      }
      return;
    }
    if ((paramOnCancelListener != null) && (!this.h.contains(paramOnCancelListener))) {
      this.h.add(paramOnCancelListener);
    }
    this.g.removeMessages(1);
    this.g.removeMessages(2);
    if ((paramInt1 == 0) && (paramInt2 > 0))
    {
      paramOnCancelListener = Message.obtain();
      paramOnCancelListener.what = 1;
      paramOnCancelListener.arg1 = paramInt1;
      paramOnCancelListener.arg2 = 0;
      paramOnCancelListener.obj = paramString;
      this.g.sendMessageDelayed(paramOnCancelListener, paramInt2);
      return;
    }
    if (this.d == null)
    {
      int i = this.f;
      if (i > 0) {
        this.d = new QQProgressDialog(localActivity, 0, i, 17);
      } else {
        this.d = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299920));
      }
    }
    if (this.h.isEmpty()) {
      this.d.setOnCancelListener(null);
    } else {
      this.d.setOnCancelListener(this);
    }
    if (paramInt1 == 0)
    {
      if ((paramString != null) && (!"".equals(paramString.trim()))) {
        this.d.a(paramString);
      } else {
        this.d.a(localActivity.getString(2131916272));
      }
      this.d.a(false);
      this.d.b(true);
      if (localActivity.isFinishing())
      {
        if (QLog.isDevelopLevel())
        {
          paramString = new StringBuilder();
          paramString.append("[");
          paramString.append(localActivity.isFinishing());
          paramString.append("]");
          QLog.d("QQProgressNotifier", 4, paramString.toString());
        }
      }
      else {
        this.d.show();
      }
    }
    else
    {
      if ((paramInt1 != 2) && (paramInt1 != 4) && (paramInt1 != 6))
      {
        this.d.a(paramString);
        this.d.d(2130839806);
      }
      else
      {
        this.d.a(paramString);
        this.d.d(2130839791);
      }
      this.d.a(true);
      this.d.b(false);
      if (!this.d.isShowing()) {
        if (localActivity.isFinishing())
        {
          if (QLog.isDevelopLevel())
          {
            paramString = new StringBuilder();
            paramString.append("[");
            paramString.append(localActivity.isFinishing());
            paramString.append("]");
            QLog.d("QQProgressNotifier", 4, paramString.toString());
          }
        }
        else {
          this.d.show();
        }
      }
      paramString = Message.obtain();
      paramString.what = 2;
      paramString.arg1 = paramInt1;
      paramOnCancelListener = this.g;
      long l;
      if (paramInt2 > 0) {
        l = paramInt2;
      } else {
        l = 1000L;
      }
      paramOnCancelListener.sendMessageDelayed(paramString, l);
    }
  }
  
  public void b()
  {
    this.g.removeMessages(1);
    this.g.removeMessages(2);
    try
    {
      if ((this.d != null) && (this.d.isShowing())) {
        this.d.dismiss();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.h.clear();
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Activity localActivity = (Activity)this.e.get();
    if (localActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQProgressNotifier", 2, "show baseActivity is null");
      }
      return;
    }
    a(paramInt1, localActivity.getString(paramInt2), paramInt3);
  }
  
  public boolean c()
  {
    QQProgressDialog localQQProgressDialog = this.d;
    return (localQQProgressDialog != null) && (localQQProgressDialog.isShowing());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      a(paramMessage.arg1, (String)paramMessage.obj, paramMessage.arg2);
      return true;
    }
    if (paramMessage.what == 2)
    {
      b();
      if ((paramMessage.arg1 == 3) || (paramMessage.arg1 == 4) || (paramMessage.arg1 == 6) || (paramMessage.arg1 == 5))
      {
        Activity localActivity = (Activity)this.e.get();
        if (localActivity != null)
        {
          if ((paramMessage.arg1 != 6) && (paramMessage.arg1 != 5))
          {
            localActivity.setResult(-1);
          }
          else
          {
            paramMessage = new Intent();
            paramMessage.putExtra("isNeedFinish", true);
            localActivity.setResult(-1, paramMessage);
          }
          localActivity.finish();
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQProgressNotifier", 2, "handleMessage baseActivity is null");
        }
      }
    }
    return true;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProgressNotifier", 4, "onCancel");
    }
    if (this.h.size() > 0)
    {
      paramDialogInterface = this.h.iterator();
      while (paramDialogInterface.hasNext())
      {
        DialogInterface.OnCancelListener localOnCancelListener = (DialogInterface.OnCancelListener)paramDialogInterface.next();
        if (localOnCancelListener != null) {
          localOnCancelListener.onCancel(this.d);
        }
      }
    }
    this.h.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQProgressNotifier
 * JD-Core Version:    0.7.0.1
 */