package cooperation.hce;

import Override;
import admy;
import adnb;
import adng;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.MotionEvent;
import anzj;
import blhc;
import bmer;
import bmes;
import bmet;
import bmgk;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;

public class HcePluginInstallActivity
  extends BaseActivity
{
  private admy jdField_a_of_type_Admy = new bmes(this);
  private adnb jdField_a_of_type_Adnb;
  private bmgk jdField_a_of_type_Bmgk;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new bmer(this);
  protected QWalletPayProgressDialog a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  private void a()
  {
    adng.a();
    this.jdField_a_of_type_Adnb = adng.a(this, 4, "1106788359");
  }
  
  private void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "goPlugin " + paramString);
    }
    if (this.jdField_a_of_type_Bmgk.isPlugininstalled("vfc_plugin.apk"))
    {
      c();
      return;
    }
    this.jdField_a_of_type_Bmgk.installPlugin("vfc_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = super.isFinishing();
    if (paramBoolean) {
      if (!bool)
      {
        if (this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) {
          break label28;
        }
        this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      }
    }
    label28:
    while ((this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog == null) || (!this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.isShowing()))
    {
      return;
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = new QWalletPayProgressDialog(this);
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.setMessage(anzj.a(2131704336));
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          if (paramContext[i].getState() == NetworkInfo.State.CONNECTED) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "initPluginManager");
    }
    this.jdField_a_of_type_Bmgk = ((bmgk)this.app.getManager(27));
    this.b = blhc.a("0e8bd1");
    a(true);
    ThreadManagerV2.executeOnSubThread(new HcePluginInstallActivity.1(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaLangString = "";
    if (!a(getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131693974, 0).a();
      d();
    }
    while (this.jdField_a_of_type_Adnb == null) {
      return;
    }
    this.jdField_a_of_type_Adnb.a("loginSilent", null, this.jdField_a_of_type_Admy);
  }
  
  private void d()
  {
    try
    {
      QWalletHelper.launchVfcPlugin(this, this.app, this.jdField_a_of_type_JavaLangString, this.b, bmet.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HcePluginInstallActivity", 1, localThrowable, new Object[0]);
      return;
    }
    finally
    {
      finish();
    }
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
    a();
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Adnb != null) {
      this.jdField_a_of_type_Adnb.b();
    }
    a(false);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "onActivityResult:requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if ((paramInt1 != 1) || (paramInt2 == 0)) {}
    for (;;)
    {
      if ((paramInt1 == 19) && ((paramInt2 == 20) || (paramInt2 == 4865))) {
        finish();
      }
      return;
      a("onActivityResult");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.hce.HcePluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */