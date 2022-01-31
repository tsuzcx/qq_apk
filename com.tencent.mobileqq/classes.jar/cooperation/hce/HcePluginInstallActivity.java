package cooperation.hce;

import abwu;
import abwx;
import abxc;
import alud;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import bhsp;
import bipz;
import biqa;
import biqb;
import biqn;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;

public class HcePluginInstallActivity
  extends BaseActivity
{
  private abwu jdField_a_of_type_Abwu = new biqa(this);
  private abwx jdField_a_of_type_Abwx;
  private biqn jdField_a_of_type_Biqn;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new bipz(this);
  protected QWalletPayProgressDialog a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  private void a()
  {
    abxc.a();
    this.jdField_a_of_type_Abwx = abxc.a(this, 4, "1106788359");
  }
  
  private void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HcePluginInstallActivity", 4, "goPlugin " + paramString);
    }
    if (this.jdField_a_of_type_Biqn.isPlugininstalled("vfc_plugin.apk"))
    {
      c();
      return;
    }
    this.jdField_a_of_type_Biqn.installPlugin("vfc_plugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
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
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.setMessage(alud.a(2131705828));
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
    this.jdField_a_of_type_Biqn = ((biqn)this.app.getManager(27));
    this.b = bhsp.a("0e8bd1");
    a(true);
    ThreadManagerV2.executeOnSubThread(new HcePluginInstallActivity.1(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaLangString = "";
    if (!a(getApplicationContext()))
    {
      QQToast.a(getApplicationContext(), 2131694779, 0).a();
      d();
    }
    while (this.jdField_a_of_type_Abwx == null) {
      return;
    }
    this.jdField_a_of_type_Abwx.a("loginSilent", null, this.jdField_a_of_type_Abwu);
  }
  
  private void d()
  {
    try
    {
      QWalletHelper.launchVfcPlugin(this, this.app, this.jdField_a_of_type_JavaLangString, this.b, biqb.a());
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
    if (this.jdField_a_of_type_Abwx != null) {
      this.jdField_a_of_type_Abwx.b();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.hce.HcePluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */