package cooperation.qqpim;

import Override;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Window;
import anzj;
import bjbs;
import blha;
import bmns;
import bmnt;
import bmnu;
import bmob;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class QQPimBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static long a;
  private bjbs jdField_a_of_type_Bjbs;
  private blha jdField_a_of_type_Blha;
  bmob jdField_a_of_type_Bmob = new bmnt(this);
  private QQPimPluginLoadRunnable jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable;
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:tool".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167247);
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 800L)
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_Blha = new blha(this);
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bjbs = new bjbs(this, super.getResources().getDimensionPixelSize(2131299011));
    this.jdField_a_of_type_Bjbs.a(anzj.a(2131709497));
    this.jdField_a_of_type_Bjbs.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bjbs.setOnDismissListener(new bmns(this));
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_Bmob);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing()))
    {
      this.jdField_a_of_type_Bjbs.dismiss();
      this.jdField_a_of_type_Bjbs = null;
    }
    sTopActivity = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramMessage.what)
    {
    }
    Bundle localBundle;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((isFinishing()) || (this.jdField_a_of_type_Bjbs == null));
          this.jdField_a_of_type_Bjbs.a(anzj.a(2131709499));
          this.jdField_a_of_type_Bjbs.show();
          return false;
        } while (isFinishing());
        int i = paramMessage.arg1;
        int j = super.getResources().getDimensionPixelSize(2131299011);
        paramMessage = anzj.a(2131709500);
        if (-4 == i) {
          paramMessage = anzj.a(2131709501);
        }
        for (;;)
        {
          QQToast.a(this.app.getApp(), 1, paramMessage, 0).b(j);
          finish();
          return false;
          if ((-5 == i) || (-1 == i) || (-3 == i) || (-2 == i)) {
            paramMessage = anzj.a(2131709496);
          } else if (-6 == i) {
            paramMessage = anzj.a(2131709498);
          }
        }
      } while (isFinishing());
      localBundle = getIntent().getExtras();
      if (bmnu.i.equals(localBundle.getString(bmnu.o)))
      {
        paramMessage = localObject1;
        if (!a(getApplicationContext())) {
          paramMessage = this.jdField_a_of_type_Bjbs;
        }
        QQPimPluginProxyActivity.a(this, localBundle, paramMessage);
        finish();
        return false;
      }
    } while (!bmnu.j.equals(localBundle.getString(bmnu.o)));
    paramMessage = localObject2;
    if (!a(getApplicationContext())) {
      paramMessage = this.jdField_a_of_type_Bjbs;
    }
    QQPimPluginProxyActivity.b(this, localBundle, paramMessage);
    finish();
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqpim.QQPimBridgeActivity
 * JD-Core Version:    0.7.0.1
 */