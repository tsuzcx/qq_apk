package cooperation.jtcode;

import alvi;
import alvk;
import alvl;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardPluginRemoteCommand;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class JtcodePluginInstallActivity
  extends BaseActivity
{
  public long a;
  private alvl jdField_a_of_type_Alvl;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new alvk(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  protected QWalletPayProgressDialog a;
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("load plugin cost time info:");
  private boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  
  public JtcodePluginInstallActivity()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private String a(String paramString, Intent paramIntent)
  {
    return "com.tencent.mobileqq.wlx.activity.BlankActivity";
  }
  
  private void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("JtcodePluginInstallActivity", 4, "initPluginManager");
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(26));
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step2:initPluginManager app.getManager cost=" + (l2 - l1));
    a(true);
    l1 = System.currentTimeMillis();
    ThreadManager.post(new alvi(this), 8, null, false);
    l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step3:initPluginManager post runnable cost=" + (l2 - l1) + ";post time=" + l2);
  }
  
  private void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled("wlx_jtcode.apk"))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step7:goPlugin plugin has installed, cost=" + (System.currentTimeMillis() - l));
      b();
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step7:goPlugin plugin has not installed, cost=" + (System.currentTimeMillis() - l));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("wlx_jtcode.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
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
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.setMessage("正在加载应用");
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      a(false);
      finish();
      return;
    }
    long l1 = System.currentTimeMillis();
    if (getIntent() != null) {}
    for (Intent localIntent = getIntent();; localIntent = new Intent())
    {
      localIntent.putExtra("skey", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("skey_type", "2");
      localIntent.putExtra("font_level", FontSettingManager.a());
      if (this.jdField_b_of_type_JavaLangString != null) {
        localIntent.putExtra("pay_result", this.jdField_b_of_type_JavaLangString);
      }
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("useSkinEngine", true);
      localIntent.putExtra("qq_version", DeviceInfoUtil.d());
      localIntent.putExtra("params_remote_connect_at_launch", true);
      localIntent.addFlags(67108864);
      long l2 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step8:launchJtcodePlugin put cost=" + (l2 - l1));
      l1 = System.currentTimeMillis();
      localIntent.putExtra("plugin_lunch_costtime_info", this.jdField_a_of_type_JavaLangStringBuilder.toString());
      localIntent.putExtra("plugin_lunch_start", this.jdField_b_of_type_Long);
      localIntent.putExtra("plugin_openActivity_start", l1);
      localIntent.putExtra("plugin_is_installed", this.jdField_b_of_type_Boolean);
      localIntent.putExtra("guid", HexUtil.a(NetConnInfoCenter.GUID));
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
      localPluginParams.jdField_b_of_type_JavaLangString = "wlx_jtcode.apk";
      localPluginParams.d = "wlx_jtcode";
      localPluginParams.jdField_a_of_type_AndroidAppDialog = null;
      localPluginParams.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      localPluginParams.e = a(this.jdField_a_of_type_JavaLangString, localIntent);
      localPluginParams.jdField_a_of_type_JavaLangClass = JtcodeProxyActivity.a(a(this.jdField_a_of_type_JavaLangString, localIntent));
      localPluginParams.jdField_b_of_type_Int = 19;
      localPluginParams.c = 15000;
      localPluginParams.jdField_a_of_type_Boolean = false;
      localPluginParams.f = null;
      IPluginManager.a(this, localPluginParams);
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step10:launchJtcodePlugin openActivityForResult cost=" + (l2 - l1));
      l1 = System.currentTimeMillis();
      BuscardPluginRemoteCommand.a();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      localIntent = new Intent();
      localIntent.putExtra("ret", "ok");
      setResult(-1, localIntent);
      this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step11:launchJtcodePlugin finish cost=" + (System.currentTimeMillis() - l1));
      if (QLog.isDevelopLevel()) {
        QLog.i("JtcodePluginInstallActivity", 2, "Jtcode lunch cost info ===========" + this.jdField_a_of_type_JavaLangStringBuilder.toString());
      }
      finish();
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      finish();
      return false;
    }
    paramBundle = (TicketManager)this.app.getManager(2);
    if (paramBundle != null) {
      this.jdField_c_of_type_JavaLangString = paramBundle.getSkey(this.app.getCurrentAccountUin());
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("bridge.plugin.onresume.broadcast");
      this.jdField_a_of_type_Alvl = new alvl(this, null);
      registerReceiver(this.jdField_a_of_type_Alvl, paramBundle);
      Intent localIntent = getIntent();
      if (localIntent != null)
      {
        this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("just_install", false);
        paramBundle = localIntent.getStringExtra("options");
        if (paramBundle == null) {}
      }
      try
      {
        this.jdField_a_of_type_JavaLangString = new JSONObject(paramBundle).optString("tag");
        this.jdField_b_of_type_JavaLangString = localIntent.getDataString();
        this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step1:doOnCreate cost=" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
        a();
        return true;
        this.jdField_c_of_type_JavaLangString = "";
      }
      catch (Exception paramBundle)
      {
        while (!QLog.isDevelopLevel()) {}
        localStringBuilder = new StringBuilder().append("mPluginManager.queryPlugin->error:");
        if (paramBundle == null) {
          break label293;
        }
      }
    }
    if (paramBundle.getMessage() != null) {}
    label293:
    for (paramBundle = paramBundle.getMessage();; paramBundle = "null")
    {
      QLog.e("JtcodePluginInstallActivity", 4, paramBundle);
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    StringBuilder localStringBuilder;
    try
    {
      if (this.jdField_a_of_type_Alvl != null) {
        unregisterReceiver(this.jdField_a_of_type_Alvl);
      }
      a(false);
      super.doOnDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isDevelopLevel()) {}
      localStringBuilder = new StringBuilder().append("doOnDestroy->error:");
      if (localThrowable == null) {
        break label79;
      }
    }
    if (localThrowable.getMessage() != null) {}
    label79:
    for (String str = localThrowable.getMessage();; str = "null")
    {
      QLog.e("JtcodePluginInstallActivity", 4, str);
      break;
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("JtcodePluginInstallActivity", 4, "onActivityResult:requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.jtcode.JtcodePluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */