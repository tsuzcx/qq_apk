package cooperation.buscard;

import alsf;
import alud;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import bdgk;
import bety;
import bilw;
import bilx;
import bily;
import biqn;
import biqw;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.proxy.QWalletNFCProxyActivity;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class BuscardPluginInstallActivity
  extends BaseActivity
{
  public long a;
  private bety jdField_a_of_type_Bety;
  private bilx jdField_a_of_type_Bilx;
  private biqn jdField_a_of_type_Biqn;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new bilw(this);
  protected QWalletPayProgressDialog a;
  private String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("load plugin cost time info:");
  private boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String c = "";
  
  public BuscardPluginInstallActivity()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private String a(String paramString, Intent paramIntent)
  {
    StringBuffer localStringBuffer = new StringBuffer("com.tenpay.android.qqplugin.activity.");
    if ((paramString == null) && (this.jdField_b_of_type_JavaLangString != null)) {
      localStringBuffer.append("RedepositActivity");
    }
    if (("experience".equals(paramString)) || ("recharge".equals(paramString))) {
      localStringBuffer.append("BusCardActivity");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if ("load".equals(paramString))
      {
        localStringBuffer.append("RedepositActivity");
      }
      else if ("friends".equals(paramString))
      {
        localStringBuffer.append("BusCardActivity");
        if (paramIntent != null) {
          paramIntent.putExtra("buscard_plugin_from", "FriendsActivity");
        }
      }
      else if ("replace_load".equals(paramString))
      {
        localStringBuffer.append("RedepositActivity");
        if (paramIntent != null) {
          paramIntent.putExtra("buscard_plugin_from", "FriendsActivity");
        }
      }
      else
      {
        localStringBuffer.append("BusCardActivity");
      }
    }
  }
  
  private void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "initPluginManager");
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Biqn = ((biqn)this.app.getManager(27));
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step2:initPluginManager app.getManager cost=" + (l2 - l1));
    a(true);
    l1 = System.currentTimeMillis();
    BuscardPluginInstallActivity.1 local1 = new BuscardPluginInstallActivity.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
    l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step3:initPluginManager post runnable cost=" + (l2 - l1) + ";post time=" + l2);
  }
  
  private void a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "goPlugin " + paramString);
    }
    try
    {
      localObject1 = getApplicationContext();
      if (BridgeHelper.a("BuscardPlugin.apk", this.app.getCurrentAccountUin(), (Context)localObject1)) {
        if (getIntent() != null)
        {
          localIntent = getIntent();
          localIntent.putExtra("skey", this.c);
          localIntent.putExtra("skey_type", "2");
          localIntent.putExtra("qq_version", bdgk.c());
          localIntent.putExtra("params_remote_connect_at_launch", true);
          localIntent.addFlags(67108864);
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("mPluginType", 1);
          ((JSONObject)localObject2).put("mPluginID", "BuscardPlugin.apk");
          ((JSONObject)localObject2).put("mPluginName", PluginInfo.f);
          ((JSONObject)localObject2).put("mConponentName", a(this.jdField_a_of_type_JavaLangString, localIntent));
          ((JSONObject)localObject2).put("mProxyActivityClass", QWalletNFCProxyActivity.class.getName());
          ((JSONObject)localObject2).put("mRequestCode", 19);
          ((JSONObject)localObject2).put("mTimeOut", 15000);
          ((JSONObject)localObject2).put("mDialogDismissBySDK", false);
          ((JSONObject)localObject2).put("skey", this.c);
          ((JSONObject)localObject2).put("skey_type", 2);
          ((JSONObject)localObject2).put("font_level", alsf.a());
          localObject2 = ((JSONObject)localObject2).toString();
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Object localObject1;
        for (;;)
        {
          Object localObject2;
          localObject3 = BridgeHelper.a((Context)localObject1, this.app.getCurrentAccountUin()).a("buscard_pluginNewNfcAPIFlag");
          localObject1 = BridgeHelper.a((Context)localObject1, this.app.getCurrentAccountUin()).a("buscard_pluginNewNfcAPIBlackModel");
          localIntent.putExtra("buscard_pluginNewNfcAPIFlag", (String)localObject3);
          localIntent.putExtra("buscard_pluginNewNfcAPIBlackModel", (String)localObject1);
          BridgeHelper.a(this, this.app, localIntent, (String)localObject2, "BuscardPlugin.apk", PluginInfo.f);
          bily.a();
          return;
          Intent localIntent = new Intent();
        }
        localThrowable1 = localThrowable1;
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder().append("go brigde Plugin failed;where=").append(paramString).append("; app.getCurrentAccountUin()=");
          if (this.app.getCurrentAccountUin() != null)
          {
            paramString = this.app.getCurrentAccountUin();
            localObject1 = ((StringBuilder)localObject1).append(paramString).append("; error=");
            if ((localThrowable1 == null) || (localThrowable1.getMessage() == null)) {
              break label637;
            }
            paramString = localThrowable1.getMessage();
            QLog.i("BuscardPluginInstallActivity", 4, paramString);
          }
        }
        else
        {
          long l2 = System.currentTimeMillis();
          this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step6:goPlugin isPluginLaunchModeBridge() cost=" + (l2 - l1) + ";start time=" + l1);
          l1 = System.currentTimeMillis();
          if (!this.jdField_a_of_type_Biqn.isPlugininstalled("BuscardPlugin.apk")) {
            break label644;
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step7:goPlugin plugin has installed, cost=" + (System.currentTimeMillis() - l1));
          b();
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject3;
          if (QLog.isDevelopLevel())
          {
            localObject3 = new StringBuilder().append("go brigde Plugin failed; error=");
            if ((localThrowable2 != null) && (localThrowable2.getMessage() != null)) {}
            for (String str = localThrowable2.getMessage();; str = "null")
            {
              QLog.i("BuscardPluginInstallActivity", 4, str);
              break;
            }
            paramString = "null";
            continue;
            label637:
            paramString = "null";
          }
        }
        label644:
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step7:goPlugin plugin has not installed, cost=" + (System.currentTimeMillis() - l1));
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Biqn.installPlugin("BuscardPlugin.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener);
      }
    }
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
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.setMessage(alud.a(2131701622));
      this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.show();
      return;
    }
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog.dismiss();
    this.jdField_a_of_type_CooperationQwalletPluginQWalletPayProgressDialog = null;
  }
  
  private void b()
  {
    long l1 = System.currentTimeMillis();
    Intent localIntent;
    if (getIntent() != null) {
      localIntent = getIntent();
    }
    Object localObject2;
    for (;;)
    {
      localIntent.putExtra("skey", this.c);
      localIntent.putExtra("skey_type", "2");
      localIntent.putExtra("font_level", alsf.a());
      if (this.jdField_b_of_type_JavaLangString != null) {
        localIntent.putExtra("pay_result", this.jdField_b_of_type_JavaLangString);
      }
      localIntent.putExtra("param_plugin_gesturelock", true);
      localIntent.putExtra("useSkinEngine", true);
      localIntent.putExtra("qq_version", bdgk.c());
      localIntent.putExtra("params_remote_connect_at_launch", true);
      localIntent.addFlags(67108864);
      long l2 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step8:launchBuscardPlugin put cost=" + (l2 - l1));
      l1 = System.currentTimeMillis();
      try
      {
        Object localObject1 = BridgeHelper.a(getApplicationContext(), this.app.getCurrentAccountUin()).a("buscard_pluginNewNfcAPIFlag");
        localObject2 = BridgeHelper.a(getApplicationContext(), this.app.getCurrentAccountUin()).a("buscard_pluginNewNfcAPIBlackModel");
        localIntent.putExtra("buscard_pluginNewNfcAPIFlag", (String)localObject1);
        localIntent.putExtra("buscard_pluginNewNfcAPIBlackModel", (String)localObject2);
        l2 = System.currentTimeMillis();
        this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step9:launchBuscardPlugin gray control cost=" + (l2 - l1));
        l1 = System.currentTimeMillis();
        localIntent.putExtra("plugin_lunch_costtime_info", this.jdField_a_of_type_JavaLangStringBuilder.toString());
        localIntent.putExtra("plugin_lunch_start", this.jdField_b_of_type_Long);
        localIntent.putExtra("plugin_openActivity_start", l1);
        localIntent.putExtra("plugin_is_installed", this.jdField_b_of_type_Boolean);
        localObject1 = new biqw(1);
        ((biqw)localObject1).jdField_b_of_type_JavaLangString = "BuscardPlugin.apk";
        ((biqw)localObject1).d = "BuscardPlugin";
        ((biqw)localObject1).jdField_a_of_type_AndroidAppDialog = null;
        ((biqw)localObject1).jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
        ((biqw)localObject1).jdField_a_of_type_AndroidContentIntent = localIntent;
        ((biqw)localObject1).e = a(this.jdField_a_of_type_JavaLangString, localIntent);
        ((biqw)localObject1).jdField_a_of_type_JavaLangClass = QWalletNFCProxyActivity.class;
        ((biqw)localObject1).jdField_b_of_type_Int = 19;
        ((biqw)localObject1).c = 15000;
        ((biqw)localObject1).jdField_b_of_type_Boolean = false;
        ((biqw)localObject1).f = null;
        biqn.a(this, (biqw)localObject1);
        l2 = System.currentTimeMillis();
        this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step10:launchBuscardPlugin openActivityForResult cost=" + (l2 - l1));
        l1 = System.currentTimeMillis();
        bily.a();
        if (this.jdField_a_of_type_Bety != null)
        {
          this.jdField_a_of_type_Bety.dismiss();
          this.jdField_a_of_type_Bety = null;
        }
        localIntent = new Intent();
        localIntent.putExtra("ret", "ok");
        setResult(-1, localIntent);
        this.jdField_a_of_type_JavaLangStringBuilder.append(" ==step11:launchBuscardPlugin finish cost=" + (System.currentTimeMillis() - l1));
        if (QLog.isDevelopLevel()) {
          QLog.i("BuscardPluginInstallActivity", 2, "buscard lunch cost info ===========" + this.jdField_a_of_type_JavaLangStringBuilder.toString());
        }
        finish();
        return;
        localIntent = new Intent();
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isDevelopLevel()) {}
        localObject2 = new StringBuilder().append("go brigde Plugin failed; error=");
        if (localThrowable == null) {
          break label655;
        }
      }
    }
    if (localThrowable.getMessage() != null) {}
    label655:
    for (String str = localThrowable.getMessage();; str = "null")
    {
      QLog.i("BuscardPluginInstallActivity", 4, str);
      break;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
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
      this.c = paramBundle.getSkey(this.app.getCurrentAccountUin());
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("bridge.plugin.onresume.broadcast");
      this.jdField_a_of_type_Bilx = new bilx(this, null);
      registerReceiver(this.jdField_a_of_type_Bilx, paramBundle);
      Intent localIntent = getIntent();
      if (localIntent != null)
      {
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
        this.c = "";
      }
      catch (Exception paramBundle)
      {
        while (!QLog.isDevelopLevel()) {}
        localStringBuilder = new StringBuilder().append("mPluginManager.queryPlugin->error:");
        if (paramBundle == null) {
          break label281;
        }
      }
    }
    if (paramBundle.getMessage() != null) {}
    label281:
    for (paramBundle = paramBundle.getMessage();; paramBundle = "null")
    {
      QLog.e("BuscardPluginInstallActivity", 4, paramBundle);
      break;
    }
  }
  
  public void doOnDestroy()
  {
    StringBuilder localStringBuilder;
    try
    {
      if (this.jdField_a_of_type_Bilx != null) {
        unregisterReceiver(this.jdField_a_of_type_Bilx);
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
      QLog.e("BuscardPluginInstallActivity", 4, str);
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardPluginInstallActivity", 4, "onActivityResult:requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
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
 * Qualified Name:     cooperation.buscard.BuscardPluginInstallActivity
 * JD-Core Version:    0.7.0.1
 */