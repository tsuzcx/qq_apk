package cooperation.thirdpay;

import CardPay.Channel;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import aneu;
import anev;
import anew;
import anex;
import aney;
import anez;
import anfb;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteResultCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class ThirdPayGate
{
  private static final String CARDPAY_IPC_COMMAND_CANCELINSTALLPLUGIN = "cardpay.cancleinstallplugin";
  private static final String CARDPAY_IPC_COMMAND_INSTALLPLUGIN = "cardpay.installplugin";
  private static final String CARDPAY_IPC_COMMAND_OUT = "cardpay.out";
  private static final String CARDPAY_IPC_COMMAND_QUERYPLUGININFO = "cardpay.QueryPluginInfo";
  private static final int CARDPAY_STARTPLUGIN_REQUESTCODE = 4352;
  private static final int FLOW_TIMEOUT = 4097;
  public static final int MAX_QUERY_DL_PLUGIN_TIMEOUT = 5000;
  public static final int MAX_QUERY_INSTALL_PLUGIN_TIMEOUT = 15000;
  private static final String NFCPAY_IPC_COMMAND_REQCHANNEL = "cardpay.reqchannel";
  public static final int PERIOD_QUERY = 1000;
  public static final String Tag = "ThirdPayGate";
  private QWalletPayProgressDialog startDialog;
  
  private void _newInstallPlugin(Activity paramActivity, PluginInterface paramPluginInterface, Bundle paramBundle, String paramString)
  {
    if ((this.startDialog != null) && (!this.startDialog.isShowing())) {
      this.startDialog.show();
    }
    long l = System.currentTimeMillis();
    if (paramPluginInterface != null) {}
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.w("CardPay", 2, "installPlugin null == mPluginInterface || TextUtils.isEmpty(pluginId)");
        return;
      }
      localObject1 = (Channel)paramBundle.getSerializable("channel");
      if (localObject1 == null) {
        throw new IllegalAccessException("channel is null");
      }
    }
    catch (Exception paramPluginInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThirdPayGate", 2, "_newInstallPlugin,", paramPluginInterface);
      }
      Toast.makeText(paramActivity.getApplicationContext(), "启动失败，请重试或者选择其他渠道进行支付！", 1).show();
      if (paramBundle.getBoolean("isactivityfinish")) {
        paramActivity.finish();
      }
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "download-fail", 0, 0, paramString, "by exception", "", "");
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalAccessException("pluginId is empty");
    }
    Object localObject2 = new anew(this, paramBundle, paramActivity);
    localObject2 = DialogUtil.a(paramActivity, 0, "下载失败", "当前网络不给力，下载失败", "取消", "继续下载", new anex(this, paramString, paramPluginInterface, paramActivity, paramBundle), (DialogInterface.OnClickListener)localObject2);
    ((QQCustomDialog)localObject2).setCancelable(false);
    Object localObject1 = new anez(this, paramPluginInterface, paramString, System.currentTimeMillis(), new aney(this, paramString, l, (Channel)localObject1, paramBundle, paramActivity, (QQCustomDialog)localObject2));
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("pluginid", paramString);
    paramPluginInterface.transfer("cardpay.installplugin", (Bundle)localObject2);
    ThreadManager.executeOnSubThread((Runnable)localObject1);
  }
  
  private void _showStartAllTip(Activity paramActivity, PluginInterface paramPluginInterface, Bundle paramBundle, String paramString)
  {
    if ((paramPluginInterface == null) || (paramActivity == null)) {
      if (QLog.isColorLevel()) {
        QLog.w("CardPay", 2, "showDownLoadTip null == mPluginInterface || TextUtils.isEmpty(pluginId)");
      }
    }
    Channel localChannel;
    do
    {
      return;
      localChannel = (Channel)paramBundle.getSerializable("channel");
      if (localChannel != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("CardPay", 2, "showDownLoadTip null == channel");
    return;
    if ((localChannel != null) && (localChannel.pluginSize > 0L))
    {
      float f = new BigDecimal((float)localChannel.pluginSize * 1.0E-006F).setScale(3, 4).floatValue();
      new StringBuilder().append("").append(f).toString();
    }
    this.startDialog.show();
    if (NetworkUtil.g(paramActivity))
    {
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "stardownload", 0, 0, paramString, "", "", "");
      _newInstallPlugin(paramActivity, paramPluginInterface, paramBundle, paramString);
      return;
    }
    this.startDialog.dismiss();
    paramActivity = DialogUtil.a(paramActivity, 0, "", "当前网络不可用，请检查网络设置！", "确定", "", null, new anev(this, paramBundle, paramActivity));
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  private void cancelInstallPlugin(PluginInterface paramPluginInterface, String paramString)
  {
    if ((paramPluginInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("CardPay", 2, "cancelInstallPlugin null == mPluginInterface || TextUtils.isEmpty(pluginId)");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginid", paramString);
    paramPluginInterface.transfer("cardpay.cancleinstallplugin", localBundle);
  }
  
  public static ThirdPayGate getInstance()
  {
    return anfb.a;
  }
  
  private void preStartPlugin(Bundle paramBundle, Activity paramActivity, PluginInterface paramPluginInterface)
  {
    Channel localChannel;
    try
    {
      localChannel = (Channel)paramBundle.getSerializable("channel");
      if (localChannel == null) {
        throw new IllegalAccessException("channel is null");
      }
    }
    catch (Exception paramPluginInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThirdPayGate", 2, "preStartPlugin,", paramPluginInterface);
      }
      if (paramBundle.getBoolean("isactivityfinish")) {
        paramActivity.finish();
      }
      paramBundle = (Channel)paramBundle.getSerializable("channel");
      if (paramBundle == null) {}
    }
    for (paramBundle = paramBundle.payType;; paramBundle = "unknown")
    {
      ReportController.a(null, "P_CliOper", "cardpay", "", "payViaPlugin", "fail", 0, 0, paramBundle + ".apk", "by exception", "", "");
      Toast.makeText(paramActivity.getApplicationContext(), "启动失败，请重试或者选择其他渠道进行支付！", 1).show();
      return;
      if (TextUtils.isEmpty(localChannel.payType)) {
        throw new IllegalAccessException("payType is empty");
      }
      if (this.startDialog != null)
      {
        this.startDialog.dismiss();
        this.startDialog = null;
      }
      this.startDialog = new QWalletPayProgressDialog(paramActivity);
      Object localObject = queryPluginInfo(paramPluginInterface, localChannel.payType + ".apk");
      if ((localObject != null) && (((Bundle)localObject).getBoolean("plugininfo", false)))
      {
        int i = ((Bundle)localObject).getInt("pluginstate");
        if (i == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CardPayGate", 2, "has been installed,start it");
          }
          startPlugin(paramBundle, paramActivity, localChannel.payType + ".apk");
          return;
        }
        if (i == 1) {
          cancelInstallPlugin(paramPluginInterface, localChannel.payType + ".apk");
        }
      }
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "showDownLoadTip", 0, 0, localChannel.payType + ".apk", "", "", "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("has not been installed,show tip activity is null?");
        if (paramActivity != null) {
          break label456;
        }
      }
      label456:
      for (boolean bool = true;; bool = false)
      {
        QLog.i("CardPayGate", 2, bool);
        _showStartAllTip(paramActivity, paramPluginInterface, paramBundle, localChannel.payType + ".apk");
        return;
      }
    }
  }
  
  private Bundle queryPluginInfo(PluginInterface paramPluginInterface, String paramString)
  {
    if ((paramPluginInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("CardPay", 2, "queryPluginInfo null == mPluginInterface || TextUtils.isEmpty(pluginId)");
      }
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("pluginid", paramString);
    return paramPluginInterface.transfer("cardpay.QueryPluginInfo", localBundle);
  }
  
  private void startPlugin(Bundle paramBundle, Activity paramActivity, String paramString)
  {
    for (;;)
    {
      try
      {
        Channel localChannel = (Channel)paramBundle.getSerializable("channel");
        if (localChannel == null) {
          throw new IllegalAccessException("channel is null");
        }
      }
      catch (Exception localException1)
      {
        str = "";
        if (QLog.isColorLevel()) {
          QLog.e("ThirdPayGate", 2, "startPlugin,", localException1);
        }
        paramBundle = new aneu(this, paramBundle, paramActivity);
        ReportController.a(null, "P_CliOper", "cardpay", "", "openplugin", "fail", 0, 0, paramString, "", "", "");
        DialogUtil.a(paramActivity, 0, "", "启动" + str + "支付插件失败", "确定", "", null, paramBundle).show();
        return;
        if (TextUtils.isEmpty(localException1.payType)) {
          throw new IllegalAccessException("payType is empty");
        }
      }
      finally {}
      String str = localException1.channelName;
      try
      {
        IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
        localPluginParams.d = localException1.payType;
        localPluginParams.jdField_b_of_type_JavaLangString = paramString;
        localPluginParams.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("userQqResources", -1);
        ((Intent)localObject).putExtra("useSkinEngine", false);
        ((Intent)localObject).putExtra("pluginId", paramString);
        ((Intent)localObject).putExtra("orderInfo", paramBundle);
        ((Intent)localObject).putExtra("param_plugin_gesturelock", true);
        ((Intent)localObject).putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        localPluginParams.jdField_a_of_type_AndroidContentIntent = ((Intent)localObject);
        if ("NFCPayPlugin.apk".equals(paramString))
        {
          localPluginParams.e = "com.tencent.mobileqq.thirdpay.activity.PayBusCardActivity";
          label300:
          if (localException1.isNFC != 1) {
            break label520;
          }
          localPluginParams.jdField_a_of_type_JavaLangClass = NFCPayPluginProxyActivity.class;
          label317:
          localPluginParams.jdField_b_of_type_Int = 4352;
          localPluginParams.c = 20000;
          localPluginParams.jdField_a_of_type_AndroidAppDialog = this.startDialog;
          localPluginParams.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.i("ThirdPayGate", 2, "startPlugin：" + System.currentTimeMillis());
          }
          localObject = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT <= 10) {
            break label531;
          }
        }
        label520:
        label531:
        for (int i = 4;; i = 0)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("mobileQQ", i);
          if (localObject != null) {
            ((SharedPreferences)localObject).edit().putString("nfc_cur_pluginid", paramString).commit();
          }
          IPluginManager.a(paramActivity, localPluginParams);
          ReportController.a(null, "P_CliOper", "cardpay", "", "openplugin", "suc", 0, 0, localException1.payType, "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ThirdPayGate", 2, "startPlugin end：" + System.currentTimeMillis());
          break;
          localPluginParams.e = "com.tencent.mobileqq.thirdpay.PayMainActivity";
          break label300;
          localPluginParams.jdField_a_of_type_JavaLangClass = ThirdPayPluginProxyActivity.class;
          break label317;
        }
      }
      catch (Exception localException2) {}
    }
  }
  
  public void getPayMethods(PluginInterface paramPluginInterface, RemoteResultCallback paramRemoteResultCallback)
  {
    if ((paramPluginInterface == null) || (paramRemoteResultCallback == null)) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.w("CardPay", 2, "getPayMethods null == mPluginInterface || null == mRemoteCallback");
        }
        return;
      }
      finally {}
      paramPluginInterface.transferAsync("cardpay.reqchannel", new Bundle(), paramRemoteResultCallback);
    }
  }
  
  public void notifyOut(PluginInterface paramPluginInterface)
  {
    if (paramPluginInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CardPay", 2, "notifyOut null == mPluginInterface");
      }
      return;
    }
    paramPluginInterface.transfer("cardpay.out", new Bundle());
  }
  
  public void payViaPlugin(Bundle paramBundle, Activity paramActivity, PluginInterface paramPluginInterface)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThirdPayGate", 2, "payViaPlugin：" + System.currentTimeMillis());
        }
        localObject = ((ActivityManager)paramActivity.getSystemService("activity")).getRunningAppProcesses().iterator();
        if (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (!localRunningAppProcessInfo.processName.equals(paramActivity.getPackageName() + ":cardpay")) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ThirdPayGate", 2, "Kill Process:" + localRunningAppProcessInfo.processName);
          }
          Process.killProcess(localRunningAppProcessInfo.pid);
        }
        localObject = (Channel)paramBundle.getSerializable("channel");
        if (localObject != null)
        {
          localObject = ((Channel)localObject).payType;
          ReportController.a(null, "P_CliOper", "cardpay", "", "payViaPlugin", "tap", 0, 0, (String)localObject + ".apk", "", "", "");
          preStartPlugin(paramBundle, paramActivity, paramPluginInterface);
          return;
        }
      }
      finally {}
      Object localObject = "unknown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.thirdpay.ThirdPayGate
 * JD-Core Version:    0.7.0.1
 */