package cooperation.qqpim;

import ajya;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Window;
import bcqf;
import bcql;
import bfnk;
import bgsy;
import bgsz;
import bgta;
import bgth;
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
  private bcqf jdField_a_of_type_Bcqf;
  private bfnk jdField_a_of_type_Bfnk;
  bgth jdField_a_of_type_Bgth = new bgsz(this);
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
    getWindow().setBackgroundDrawableResource(2131167087);
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 800L)
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_Bfnk = new bfnk(this);
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Bcqf = new bcqf(this, super.getResources().getDimensionPixelSize(2131298865));
    this.jdField_a_of_type_Bcqf.a(ajya.a(2131710628));
    this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bcqf.setOnDismissListener(new bgsy(this));
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.a();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_Bgth);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing()))
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      this.jdField_a_of_type_Bcqf = null;
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
          } while ((isFinishing()) || (this.jdField_a_of_type_Bcqf == null));
          this.jdField_a_of_type_Bcqf.a(ajya.a(2131710630));
          this.jdField_a_of_type_Bcqf.show();
          return false;
        } while (isFinishing());
        int i = paramMessage.arg1;
        int j = super.getResources().getDimensionPixelSize(2131298865);
        paramMessage = ajya.a(2131710631);
        if (-4 == i) {
          paramMessage = ajya.a(2131710632);
        }
        for (;;)
        {
          bcql.a(this.app.getApp(), 1, paramMessage, 0).b(j);
          finish();
          return false;
          if ((-5 == i) || (-1 == i) || (-3 == i) || (-2 == i)) {
            paramMessage = ajya.a(2131710627);
          } else if (-6 == i) {
            paramMessage = ajya.a(2131710629);
          }
        }
      } while (isFinishing());
      localBundle = getIntent().getExtras();
      if (bgta.i.equals(localBundle.getString(bgta.o)))
      {
        paramMessage = localObject1;
        if (!a(getApplicationContext())) {
          paramMessage = this.jdField_a_of_type_Bcqf;
        }
        QQPimPluginProxyActivity.a(this, localBundle, paramMessage);
        finish();
        return false;
      }
    } while (!bgta.j.equals(localBundle.getString(bgta.o)));
    paramMessage = localObject2;
    if (!a(getApplicationContext())) {
      paramMessage = this.jdField_a_of_type_Bcqf;
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