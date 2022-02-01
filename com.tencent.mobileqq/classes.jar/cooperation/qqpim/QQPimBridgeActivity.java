package cooperation.qqpim;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.Iterator;
import java.util.List;

public class QQPimBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static long a;
  QQPimPluginLoadRunnable.IPluginLoadListener b = new QQPimBridgeActivity.2(this);
  private QQProgressDialog c;
  private MqqWeakReferenceHandler d;
  private QQPimPluginLoadRunnable e;
  
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131168376);
    if (System.currentTimeMillis() - a < 800L)
    {
      finish();
      return true;
    }
    this.d = new MqqWeakReferenceHandler(this);
    a = System.currentTimeMillis();
    this.c = new QQProgressDialog(this, super.getResources().getDimensionPixelSize(2131299920));
    this.c.a(HardCodeUtil.a(2131908256));
    this.c.setCanceledOnTouchOutside(false);
    this.c.setOnDismissListener(new QQPimBridgeActivity.1(this));
    paramBundle = this.e;
    if (paramBundle != null) {
      paramBundle.a();
    }
    this.e = new QQPimPluginLoadRunnable(this.b);
    ThreadManager.postImmediately(this.e, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    QQProgressDialog localQQProgressDialog = this.c;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.c.dismiss();
      this.c = null;
    }
    sTopActivity = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        if (!isFinishing())
        {
          i = paramMessage.arg1;
          int j = super.getResources().getDimensionPixelSize(2131299920);
          paramMessage = HardCodeUtil.a(2131908259);
          if (-4 == i) {
            paramMessage = HardCodeUtil.a(2131908260);
          } else if ((-5 != i) && (-1 != i) && (-3 != i) && (-2 != i))
          {
            if (-6 == i) {
              paramMessage = HardCodeUtil.a(2131908257);
            }
          }
          else {
            paramMessage = HardCodeUtil.a(2131908255);
          }
          QQToast.makeText(this.app.getApp(), 1, paramMessage, 0).show(j);
          finish();
          return false;
        }
      }
      else if (!isFinishing())
      {
        Bundle localBundle = getIntent().getExtras();
        boolean bool = QQPimDefineList.j.equals(localBundle.getString(QQPimDefineList.p));
        Object localObject = null;
        paramMessage = null;
        if (bool)
        {
          if (!a(getApplicationContext())) {
            paramMessage = this.c;
          }
          QQPimPluginProxyActivity.a(this, localBundle, paramMessage);
          finish();
          return false;
        }
        if (QQPimDefineList.k.equals(localBundle.getString(QQPimDefineList.p)))
        {
          paramMessage = localObject;
          if (!a(getApplicationContext())) {
            paramMessage = this.c;
          }
          QQPimPluginProxyActivity.b(this, localBundle, paramMessage);
          finish();
          return false;
        }
      }
    }
    else if (!isFinishing())
    {
      paramMessage = this.c;
      if (paramMessage != null)
      {
        paramMessage.a(HardCodeUtil.a(2131908258));
        this.c.show();
      }
    }
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqpim.QQPimBridgeActivity
 * JD-Core Version:    0.7.0.1
 */