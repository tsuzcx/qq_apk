package cooperation.qqreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqreader.utils.Log;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class QRPluginManager
{
  private static QRPluginManager jdField_a_of_type_CooperationQqreaderQRPluginManager;
  private OnPluginInstallListener.Stub jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener$Stub = new QRPluginManager.1(this);
  private Pair<WeakReference<Context>, Integer> jdField_a_of_type_ComTencentUtilPair;
  
  public static QRPluginManager a()
  {
    if (jdField_a_of_type_CooperationQqreaderQRPluginManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqreaderQRPluginManager == null) {
        jdField_a_of_type_CooperationQqreaderQRPluginManager = new QRPluginManager();
      }
      return jdField_a_of_type_CooperationQqreaderQRPluginManager;
    }
    finally {}
  }
  
  private void a(Context paramContext, int paramInt)
  {
    if (paramInt == 2)
    {
      d(paramContext);
      return;
    }
    c(paramContext);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "P_CliOper", "VIP_QQREADER", "", "0X800604D", "0X800604D", 1, paramInt, "", "", "", "");
  }
  
  private void c(Context paramContext)
  {
    Log.e("QRPluginManager", "load plugin start");
    Intent localIntent = new Intent(paramContext, VipProxyRreLoadReaderProcess.class);
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("params_uin_for_reader", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("is_preload_reader_plugin", false);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.b = "qqreaderplugin.apk";
    localPluginParams.e = "qqreader";
    localPluginParams.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localPluginParams.f = "com.qqreader.ReaderPreloadReaderProcess";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.b(paramContext, localPluginParams);
    Log.e("QRPluginManager", "load plugin end");
  }
  
  private void d(Context paramContext)
  {
    Intent localIntent = new Intent();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    QRJumpAction.a(paramContext, localIntent, "com.qqreader.pureader.EmptyActivity", new QRPluginManager.2(this));
  }
  
  public void a() {}
  
  public void a(Context paramContext) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRPluginManager
 * JD-Core Version:    0.7.0.1
 */