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
import anvx;
import bisl;
import bkyc;
import bmdi;
import bmdj;
import bmdk;
import bmdr;
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
  private bisl jdField_a_of_type_Bisl;
  private bkyc jdField_a_of_type_Bkyc;
  bmdr jdField_a_of_type_Bmdr = new bmdj(this);
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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167296);
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 800L)
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_Bkyc = new bkyc(this);
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bisl = new bisl(this, super.getResources().getDimensionPixelSize(2131299080));
    this.jdField_a_of_type_Bisl.a(anvx.a(2131710076));
    this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bisl.setOnDismissListener(new bmdi(this));
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_Bmdr);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()))
    {
      this.jdField_a_of_type_Bisl.dismiss();
      this.jdField_a_of_type_Bisl = null;
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
          } while ((isFinishing()) || (this.jdField_a_of_type_Bisl == null));
          this.jdField_a_of_type_Bisl.a(anvx.a(2131710078));
          this.jdField_a_of_type_Bisl.show();
          return false;
        } while (isFinishing());
        int i = paramMessage.arg1;
        int j = super.getResources().getDimensionPixelSize(2131299080);
        paramMessage = anvx.a(2131710079);
        if (-4 == i) {
          paramMessage = anvx.a(2131710080);
        }
        for (;;)
        {
          QQToast.a(this.app.getApp(), 1, paramMessage, 0).b(j);
          finish();
          return false;
          if ((-5 == i) || (-1 == i) || (-3 == i) || (-2 == i)) {
            paramMessage = anvx.a(2131710075);
          } else if (-6 == i) {
            paramMessage = anvx.a(2131710077);
          }
        }
      } while (isFinishing());
      localBundle = getIntent().getExtras();
      if (bmdk.i.equals(localBundle.getString(bmdk.o)))
      {
        paramMessage = localObject1;
        if (!a(getApplicationContext())) {
          paramMessage = this.jdField_a_of_type_Bisl;
        }
        QQPimPluginProxyActivity.a(this, localBundle, paramMessage);
        finish();
        return false;
      }
    } while (!bmdk.j.equals(localBundle.getString(bmdk.o)));
    paramMessage = localObject2;
    if (!a(getApplicationContext())) {
      paramMessage = this.jdField_a_of_type_Bisl;
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