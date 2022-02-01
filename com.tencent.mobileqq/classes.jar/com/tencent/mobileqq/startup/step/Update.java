package com.tencent.mobileqq.startup.step;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Environment;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.multilanguage.MultiLanguageEngine;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppActivity;

public class Update
  extends Step
  implements Handler.Callback
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 36, 23, 24, 25, 33, 34, 35 };
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
    double d1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Double.isNaN(d1);
    double d2 = this.c;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    int i = this.b;
    int j = this.jdField_a_of_type_Int;
    d2 = i - j;
    Double.isNaN(d2);
    double d3 = j;
    Double.isNaN(d3);
    d2 = d1 * d2 + d3;
    if (d2 < j)
    {
      d1 = j;
    }
    else
    {
      d1 = d2;
      if (d2 > i - 10)
      {
        d1 = this.jdField_a_of_type_Double;
        if (d1 < i - 10)
        {
          this.jdField_a_of_type_Double = (i - 10);
        }
        else
        {
          d2 = i;
          Double.isNaN(d2);
          this.jdField_a_of_type_Double = (d1 + (d2 - d1) / 10.0D);
        }
        d1 = this.jdField_a_of_type_Double;
      }
    }
    return (int)d1;
  }
  
  private void a()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup != null)
    {
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout != null) {
        try
        {
          localViewGroup.removeView(localRelativeLayout);
        }
        catch (Throwable localThrowable)
        {
          QLog.d("AutoMonitor", 1, "", localThrowable);
        }
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  protected boolean doStep()
  {
    this.c = 13500;
    boolean bool1;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      if (Build.VERSION.SDK_INT < 21)
      {
        String str = System.getProperty("java.vm.version");
        if ((str != null) && (!str.startsWith("1")))
        {
          this.c += 30000;
          try
          {
            Thread.sleep(300L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      bool1 = Step.AmStepFactory.b(4, this.mDirector, null).step();
    }
    else
    {
      bool1 = true;
    }
    if (bool1)
    {
      localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ProcFirstLaunch");
      ((StringBuilder)localObject2).append(BaseApplicationImpl.processName);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = ((SharedPreferences)localObject1).getString((String)localObject2, "null");
      QLog.i("AutoMonitor", 1, String.format("updateVersion %s %s %s", new Object[] { localObject2, localObject3, String.valueOf(AppSetting.g()) }));
      if (!TextUtils.equals(AppSetting.g(), (CharSequence)localObject3))
      {
        AutomatorHelper.b = true;
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || ("null".equals(localObject3)))
        {
          AutomatorHelper.a = true;
          com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch.k = true;
        }
        Step.AmStepFactory.b(27, this.mDirector, null).step();
        if (BaseApplicationImpl.sProcessId == 1)
        {
          boolean bool2;
          if (!((SharedPreferences)localObject1).getBoolean("HasDelSharppSo", false))
          {
            QLog.d("DelSharpp", 1, "start del sharpp");
            try
            {
              Object localObject4 = Environment.getExternalStorageDirectory().getAbsolutePath();
              localObject3 = new String[8];
              Object localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(BaseApplicationImpl.getContext().getFilesDir().getParent());
              ((StringBuilder)localObject5).append("/txlib/libTcHevcDec.so");
              localObject3[0] = ((StringBuilder)localObject5).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(BaseApplicationImpl.getContext().getApplicationInfo().nativeLibraryDir);
              ((StringBuilder)localObject5).append("/libTcHevcDec.so");
              localObject3[1] = ((StringBuilder)localObject5).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(BaseApplicationImpl.getContext().getFilesDir());
              ((StringBuilder)localObject5).append("/pddata/prd/early/qq.android.qav.sov8_826");
              localObject3[2] = ((StringBuilder)localObject5).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append((String)localObject4);
              ((StringBuilder)localObject5).append("/Tencent/MobileQQ/pddata/prd/early/qq.android.qav.sov8_826");
              localObject3[3] = ((StringBuilder)localObject5).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append((String)localObject4);
              ((StringBuilder)localObject5).append("/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/pddata/prd/early/qq.android.qav.sov8_826");
              localObject3[4] = ((StringBuilder)localObject5).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append(BaseApplicationImpl.getContext().getFilesDir().getParent());
              ((StringBuilder)localObject5).append("/txlib/cmshow/libTcHevcDec.so");
              localObject3[5] = ((StringBuilder)localObject5).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append((String)localObject4);
              ((StringBuilder)localObject5).append("/Tencent/MobileQQ/pddata/prd/early/android.qq.apollo.jsc800");
              localObject3[6] = ((StringBuilder)localObject5).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append((String)localObject4);
              ((StringBuilder)localObject5).append("/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/pddata/prd/early/android.qq.apollo.jsc800");
              localObject3[7] = ((StringBuilder)localObject5).toString();
              int j = localObject3.length;
              int i = 0;
              while (i < j)
              {
                localObject4 = localObject3[i];
                localObject5 = new File((String)localObject4);
                if (((File)localObject5).exists())
                {
                  bool2 = ((File)localObject5).delete();
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("exist");
                  ((StringBuilder)localObject5).append((String)localObject4);
                  QLog.d("DelSharpp", 1, ((StringBuilder)localObject5).toString());
                }
                else
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append("not exist");
                  ((StringBuilder)localObject5).append((String)localObject4);
                  QLog.d("DelSharpp", 1, ((StringBuilder)localObject5).toString());
                  bool2 = true;
                }
                if (!bool2)
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append(" del fail");
                  ((StringBuilder)localObject5).append((String)localObject4);
                  QLog.d("DelSharpp", 1, ((StringBuilder)localObject5).toString());
                }
                else
                {
                  localObject5 = new StringBuilder();
                  ((StringBuilder)localObject5).append(" del succ");
                  ((StringBuilder)localObject5).append((String)localObject4);
                  QLog.d("DelSharpp", 1, ((StringBuilder)localObject5).toString());
                }
                i += 1;
              }
              QLog.d("DelSharpp", 1, "has del sharpp");
            }
            catch (Throwable localThrowable)
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("Fail to del files.");
              ((StringBuilder)localObject4).append(localThrowable);
              QLog.e("DelSharpp", 1, ((StringBuilder)localObject4).toString());
              QLog.d("DelSharpp", 1, "end del sharpp");
              ((SharedPreferences)localObject1).edit().putBoolean("HasDelSharppSo", true).commit();
            }
          }
          if (Looper.getMainLooper() != Looper.myLooper())
          {
            if (this.jdField_a_of_type_AndroidOsHandler == null)
            {
              this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
            }
            bool2 = Step.AmStepFactory.b(0, this.mDirector, jdField_a_of_type_ArrayOfInt).step();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("UPDATE_STEPS ");
            localStringBuilder.append(bool2);
            QLog.e("AutoMonitor", 1, localStringBuilder.toString());
            ((SharedPreferences)localObject1).edit().putString((String)localObject2, AppSetting.g()).commit();
            if (!AutomatorHelper.a) {
              MultiLanguageEngine.a().c(BaseApplicationImpl.getContext());
            }
          }
        }
        else
        {
          ((SharedPreferences)localObject1).edit().putString((String)localObject2, AppSetting.g()).commit();
        }
      }
    }
    Object localObject1 = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject1 != null)
    {
      ((Handler)localObject1).removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    return bool1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateMessage ");
    ((StringBuilder)localObject).append(paramMessage);
    QLog.i("AutoMonitor", 1, ((StringBuilder)localObject).toString());
    localObject = this.mDirector.a;
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return true;
        }
        a();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        return true;
      }
      i = a();
      paramMessage = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (paramMessage != null)
      {
        if (paramMessage.getProgress() > i) {
          return true;
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      }
      paramMessage = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramMessage != null) {
        paramMessage.setText(String.format(this.mDirector.a.getString(2131692489), new Object[] { Integer.valueOf(i) }));
      }
      if (i < 99)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 100L);
        return true;
      }
    }
    else
    {
      if (localObject == null) {
        return true;
      }
      try
      {
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((Activity)localObject).getWindow().getDecorView());
        if (this.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(this.mDirector.a.getApplicationContext(), 2131562850, null));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368260));
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370395));
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715675));
          this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      catch (Throwable paramMessage)
      {
        QLog.d("AutoMonitor", 1, "", paramMessage);
        a();
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = 0;
      this.b = 99;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Update
 * JD-Core Version:    0.7.0.1
 */