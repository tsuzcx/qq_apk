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
  private static final int[] i = { 37, 24, 25, 26, 34, 35, 36 };
  private RelativeLayout a;
  private ProgressBar b;
  private TextView c;
  private Handler d;
  private long e;
  private int f;
  private int g;
  private double h;
  private int j;
  private ViewGroup k;
  
  private void a()
  {
    ViewGroup localViewGroup = this.k;
    if (localViewGroup != null)
    {
      RelativeLayout localRelativeLayout = this.a;
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
    this.k = null;
    this.a = null;
    this.b = null;
    this.c = null;
  }
  
  private int b()
  {
    double d1 = System.currentTimeMillis() - this.e;
    Double.isNaN(d1);
    double d2 = this.j;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    int m = this.g;
    int n = this.f;
    d2 = m - n;
    Double.isNaN(d2);
    double d3 = n;
    Double.isNaN(d3);
    d2 = d1 * d2 + d3;
    if (d2 < n)
    {
      d1 = n;
    }
    else
    {
      d1 = d2;
      if (d2 > m - 10)
      {
        d1 = this.h;
        if (d1 < m - 10)
        {
          this.h = (m - 10);
        }
        else
        {
          d2 = m;
          Double.isNaN(d2);
          this.h = (d1 + (d2 - d1) / 10.0D);
        }
        d1 = this.h;
      }
    }
    return (int)d1;
  }
  
  protected boolean doStep()
  {
    this.j = 13500;
    boolean bool1;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      this.d = new Handler(Looper.getMainLooper(), this);
      this.d.sendEmptyMessage(1);
      if (Build.VERSION.SDK_INT < 21)
      {
        String str = System.getProperty("java.vm.version");
        if ((str != null) && (!str.startsWith("1")))
        {
          this.j += 30000;
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
      QLog.i("AutoMonitor", 1, String.format("updateVersion %s %s %s", new Object[] { localObject2, localObject3, String.valueOf(AppSetting.i()) }));
      if (!TextUtils.equals(AppSetting.i(), (CharSequence)localObject3))
      {
        AutomatorHelper.b = true;
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || ("null".equals(localObject3)))
        {
          AutomatorHelper.a = true;
          com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch.r = true;
        }
        Step.AmStepFactory.b(28, this.mDirector, null).step();
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
              int n = localObject3.length;
              int m = 0;
              while (m < n)
              {
                localObject4 = localObject3[m];
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
                m += 1;
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
            if (this.d == null)
            {
              this.d = new Handler(Looper.getMainLooper(), this);
              this.d.sendEmptyMessage(1);
            }
            bool2 = Step.AmStepFactory.b(0, this.mDirector, i).step();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("UPDATE_STEPS ");
            localStringBuilder.append(bool2);
            QLog.e("AutoMonitor", 1, localStringBuilder.toString());
            ((SharedPreferences)localObject1).edit().putString((String)localObject2, AppSetting.i()).commit();
            if (!AutomatorHelper.a) {
              MultiLanguageEngine.a().c(BaseApplicationImpl.getContext());
            }
          }
        }
        else
        {
          ((SharedPreferences)localObject1).edit().putString((String)localObject2, AppSetting.i()).commit();
        }
      }
    }
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      ((Handler)localObject1).removeMessages(2);
      this.d.sendEmptyMessage(3);
    }
    return bool1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateMessage ");
    ((StringBuilder)localObject).append(paramMessage);
    QLog.i("AutoMonitor", 1, ((StringBuilder)localObject).toString());
    localObject = this.mDirector.e;
    int m = paramMessage.what;
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3) {
          return true;
        }
        a();
        this.d.removeMessages(2);
        return true;
      }
      m = b();
      paramMessage = this.b;
      if (paramMessage != null)
      {
        if (paramMessage.getProgress() > m) {
          return true;
        }
        this.b.setProgress(m);
      }
      paramMessage = this.c;
      if (paramMessage != null) {
        paramMessage.setText(String.format(this.mDirector.e.getString(2131889477), new Object[] { Integer.valueOf(m) }));
      }
      if (m < 99)
      {
        this.d.sendEmptyMessageDelayed(2, 100L);
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
        this.k = ((ViewGroup)((Activity)localObject).getWindow().getDecorView());
        if (this.k != null)
        {
          this.a = ((RelativeLayout)View.inflate(this.mDirector.e.getApplicationContext(), 2131629302, null));
          this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          this.b = ((ProgressBar)this.a.findViewById(2131435131));
          this.c = ((TextView)this.a.findViewById(2131437663));
          this.c.setText(HardCodeUtil.a(2131913143));
          this.k.addView(this.a);
        }
      }
      catch (Throwable paramMessage)
      {
        QLog.d("AutoMonitor", 1, "", paramMessage);
        a();
      }
      this.d.sendEmptyMessage(2);
      this.e = System.currentTimeMillis();
      this.f = 0;
      this.g = 99;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Update
 * JD-Core Version:    0.7.0.1
 */