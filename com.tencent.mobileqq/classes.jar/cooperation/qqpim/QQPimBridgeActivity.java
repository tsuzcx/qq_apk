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
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  QQPimPluginLoadRunnable.IPluginLoadListener jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener = new QQPimBridgeActivity.2(this);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167333);
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 800L)
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getResources().getDimensionPixelSize(2131299168));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131710569));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new QQPimBridgeActivity.1(this));
    paramBundle = this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable;
    if (paramBundle != null) {
      paramBundle.a();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$IPluginLoadListener);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
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
          int j = super.getResources().getDimensionPixelSize(2131299168);
          paramMessage = HardCodeUtil.a(2131710572);
          if (-4 == i) {
            paramMessage = HardCodeUtil.a(2131710573);
          } else if ((-5 != i) && (-1 != i) && (-3 != i) && (-2 != i))
          {
            if (-6 == i) {
              paramMessage = HardCodeUtil.a(2131710570);
            }
          }
          else {
            paramMessage = HardCodeUtil.a(2131710568);
          }
          QQToast.a(this.app.getApp(), 1, paramMessage, 0).b(j);
          finish();
          return false;
        }
      }
      else if (!isFinishing())
      {
        Bundle localBundle = getIntent().getExtras();
        boolean bool = QQPimDefineList.i.equals(localBundle.getString(QQPimDefineList.o));
        Object localObject = null;
        paramMessage = null;
        if (bool)
        {
          if (!a(getApplicationContext())) {
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
          }
          QQPimPluginProxyActivity.a(this, localBundle, paramMessage);
          finish();
          return false;
        }
        if (QQPimDefineList.j.equals(localBundle.getString(QQPimDefineList.o)))
        {
          paramMessage = localObject;
          if (!a(getApplicationContext())) {
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
          }
          QQPimPluginProxyActivity.b(this, localBundle, paramMessage);
          finish();
          return false;
        }
      }
    }
    else if (!isFinishing())
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (paramMessage != null)
      {
        paramMessage.a(HardCodeUtil.a(2131710571));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimBridgeActivity
 * JD-Core Version:    0.7.0.1
 */