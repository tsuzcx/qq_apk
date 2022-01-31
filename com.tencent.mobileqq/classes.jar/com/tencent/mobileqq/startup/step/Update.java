package com.tencent.mobileqq.startup.step;

import ajjy;
import akef;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awoa;
import awpm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class Update
  extends OnceIfSuccessStep
  implements Handler.Callback
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 36, 22, 23, 24, 33, 34, 35 };
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int b;
  private int c;
  
  private int a()
  {
    double d2 = (System.currentTimeMillis() - this.jdField_a_of_type_Long) * 1.0D / this.c * (this.b - this.jdField_a_of_type_Int) + this.jdField_a_of_type_Int;
    double d1;
    if (d2 < this.jdField_a_of_type_Int) {
      d1 = this.jdField_a_of_type_Int;
    }
    do
    {
      return (int)d1;
      d1 = d2;
    } while (d2 <= this.b - 10);
    if (this.jdField_a_of_type_Double < this.b - 10) {}
    for (this.jdField_a_of_type_Double = (this.b - 10);; this.jdField_a_of_type_Double += (this.b - this.jdField_a_of_type_Double) / 10.0D)
    {
      d1 = this.jdField_a_of_type_Double;
      break;
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.jdField_a_of_type_AndroidWidgetProgressBar = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("AutoMonitor", 1, "", localThrowable);
      }
    }
  }
  
  protected boolean doStep()
  {
    this.c = 12500;
    Object localObject;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (Build.VERSION.SDK_INT < 21)
      {
        localObject = System.getProperty("java.vm.version");
        if ((localObject != null) && (!((String)localObject).startsWith("1"))) {
          this.c += 30000;
        }
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(300L);
        bool1 = awpm.b(4, this.mDirector, null).step();
        if (bool1)
        {
          localObject = BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4);
          str1 = "ProcFirstLaunch" + BaseApplicationImpl.processName;
          String str2 = ((SharedPreferences)localObject).getString(str1, "null");
          QLog.i("AutoMonitor", 1, String.format("updateVersion %s %s %s", new Object[] { str1, str2, String.valueOf(AppSetting.g()) }));
          if (!TextUtils.equals(AppSetting.g(), str2))
          {
            BaseApplicationImpl.isCurrentVersionFirstLaunch = true;
            BaseApplicationImpl.sLaunchTime = 0L;
            BaseApplicationImpl.sShowTime = 0L;
            if (TextUtils.isEmpty(str2)) {
              BaseApplicationImpl.isFirstLaunchNew = true;
            }
            awpm.b(27, this.mDirector, null).step();
            if (BaseApplicationImpl.sProcessId != 1) {
              continue;
            }
            if (Looper.getMainLooper() != Looper.myLooper())
            {
              if (this.jdField_a_of_type_AndroidOsHandler == null)
              {
                this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
              }
              boolean bool2 = awpm.b(0, this.mDirector, jdField_a_of_type_ArrayOfInt).step();
              QLog.e("AutoMonitor", 1, "UPDATE_STEPS " + bool2);
              ((SharedPreferences)localObject).edit().putString(str1, AppSetting.g()).commit();
              if (!BaseApplicationImpl.isFirstLaunchNew) {
                akef.a().c(BaseApplicationImpl.getContext());
              }
            }
          }
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        }
        return bool1;
      }
      catch (InterruptedException localInterruptedException)
      {
        String str1;
        localInterruptedException.printStackTrace();
        continue;
        localInterruptedException.edit().putString(str1, AppSetting.g()).commit();
        continue;
      }
      boolean bool1 = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    QLog.i("AutoMonitor", 1, "updateMessage " + paramMessage);
    AppActivity localAppActivity = this.mDirector.a;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      int i;
      do
      {
        do
        {
          do
          {
            return true;
          } while (localAppActivity == null);
          try
          {
            this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localAppActivity.getWindow().getDecorView());
            if (this.jdField_a_of_type_AndroidViewViewGroup != null)
            {
              this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(this.mDirector.a.getApplicationContext(), 2131496837, null));
              this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
              this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131301983));
              this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131303837));
              this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131650115));
              this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            this.jdField_a_of_type_Int = 0;
            this.b = 99;
            return true;
          }
          catch (Throwable paramMessage)
          {
            for (;;)
            {
              QLog.d("AutoMonitor", 1, "", paramMessage);
              a();
            }
          }
          i = a();
          if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
            break;
          }
        } while (this.jdField_a_of_type_AndroidWidgetProgressBar.getProgress() > i);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.mDirector.a.getString(2131626985), new Object[] { Integer.valueOf(i) }));
        }
      } while (i >= 99);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 100L);
      return true;
    }
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Update
 * JD-Core Version:    0.7.0.1
 */