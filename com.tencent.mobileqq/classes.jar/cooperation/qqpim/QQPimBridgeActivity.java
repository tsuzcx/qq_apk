package cooperation.qqpim;

import ajjy;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Window;
import bbms;
import bbmy;
import beez;
import bfkp;
import bfkq;
import bfkr;
import bfky;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.List;

public class QQPimBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static long a;
  private bbms jdField_a_of_type_Bbms;
  private beez jdField_a_of_type_Beez;
  bfky jdField_a_of_type_Bfky = new bfkq(this);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131101491);
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 800L)
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_Beez = new beez(this);
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bbms = new bbms(this, super.getResources().getDimensionPixelSize(2131167766));
    this.jdField_a_of_type_Bbms.a(ajjy.a(2131644829));
    this.jdField_a_of_type_Bbms.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bbms.setOnDismissListener(new bfkp(this));
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_Bfky);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()))
    {
      this.jdField_a_of_type_Bbms.dismiss();
      this.jdField_a_of_type_Bbms = null;
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
          } while ((isFinishing()) || (this.jdField_a_of_type_Bbms == null));
          this.jdField_a_of_type_Bbms.a(ajjy.a(2131644831));
          this.jdField_a_of_type_Bbms.show();
          return false;
        } while (isFinishing());
        int i = paramMessage.arg1;
        int j = super.getResources().getDimensionPixelSize(2131167766);
        paramMessage = ajjy.a(2131644832);
        if (-4 == i) {
          paramMessage = ajjy.a(2131644833);
        }
        for (;;)
        {
          bbmy.a(this.app.getApp(), 1, paramMessage, 0).b(j);
          finish();
          return false;
          if ((-5 == i) || (-1 == i) || (-3 == i) || (-2 == i)) {
            paramMessage = ajjy.a(2131644828);
          } else if (-6 == i) {
            paramMessage = ajjy.a(2131644830);
          }
        }
      } while (isFinishing());
      localBundle = getIntent().getExtras();
      if (bfkr.i.equals(localBundle.getString(bfkr.o)))
      {
        paramMessage = localObject1;
        if (!a(getApplicationContext())) {
          paramMessage = this.jdField_a_of_type_Bbms;
        }
        QQPimPluginProxyActivity.a(this, localBundle, paramMessage);
        finish();
        return false;
      }
    } while (!bfkr.j.equals(localBundle.getString(bfkr.o)));
    paramMessage = localObject2;
    if (!a(getApplicationContext())) {
      paramMessage = this.jdField_a_of_type_Bbms;
    }
    QQPimPluginProxyActivity.b(this, localBundle, paramMessage);
    finish();
    return false;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimBridgeActivity
 * JD-Core Version:    0.7.0.1
 */