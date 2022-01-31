package cooperation.qqpim;

import alpo;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Window;
import bepp;
import bhoe;
import bitx;
import bity;
import bitz;
import biug;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Iterator;
import java.util.List;

public class QQPimBridgeActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static long a;
  private bepp jdField_a_of_type_Bepp;
  private bhoe jdField_a_of_type_Bhoe;
  biug jdField_a_of_type_Biug = new bity(this);
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
    getWindow().setBackgroundDrawableResource(2131167138);
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 800L)
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_Bhoe = new bhoe(this);
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bepp = new bepp(this, super.getResources().getDimensionPixelSize(2131298914));
    this.jdField_a_of_type_Bepp.a(alpo.a(2131711000));
    this.jdField_a_of_type_Bepp.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bepp.setOnDismissListener(new bitx(this));
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_Biug);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing()))
    {
      this.jdField_a_of_type_Bepp.dismiss();
      this.jdField_a_of_type_Bepp = null;
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
          } while ((isFinishing()) || (this.jdField_a_of_type_Bepp == null));
          this.jdField_a_of_type_Bepp.a(alpo.a(2131711002));
          this.jdField_a_of_type_Bepp.show();
          return false;
        } while (isFinishing());
        int i = paramMessage.arg1;
        int j = super.getResources().getDimensionPixelSize(2131298914);
        paramMessage = alpo.a(2131711003);
        if (-4 == i) {
          paramMessage = alpo.a(2131711004);
        }
        for (;;)
        {
          QQToast.a(this.app.getApp(), 1, paramMessage, 0).b(j);
          finish();
          return false;
          if ((-5 == i) || (-1 == i) || (-3 == i) || (-2 == i)) {
            paramMessage = alpo.a(2131710999);
          } else if (-6 == i) {
            paramMessage = alpo.a(2131711001);
          }
        }
      } while (isFinishing());
      localBundle = getIntent().getExtras();
      if (bitz.i.equals(localBundle.getString(bitz.o)))
      {
        paramMessage = localObject1;
        if (!a(getApplicationContext())) {
          paramMessage = this.jdField_a_of_type_Bepp;
        }
        QQPimPluginProxyActivity.a(this, localBundle, paramMessage);
        finish();
        return false;
      }
    } while (!bitz.j.equals(localBundle.getString(bitz.o)));
    paramMessage = localObject2;
    if (!a(getApplicationContext())) {
      paramMessage = this.jdField_a_of_type_Bepp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimBridgeActivity
 * JD-Core Version:    0.7.0.1
 */