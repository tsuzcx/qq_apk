package cooperation.buscard;

import amqi;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.ReaderCallback;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.jtcode.WlxProxyService;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class BuscardHelper
{
  private static IPluginManager.PluginParams a(Intent paramIntent, String paramString, ServiceConnection paramServiceConnection, boolean paramBoolean)
  {
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
    if (paramBoolean)
    {
      localPluginParams.b = "wlx_jtcode.apk";
      localPluginParams.d = "交通码";
    }
    for (localPluginParams.e = "com.tencent.mobileqq.wlx.service.WlxIpcService";; localPluginParams.e = "com.tenpay.android.qqplugin.ipc.IpcService")
    {
      localPluginParams.jdField_a_of_type_JavaLangString = paramString;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
      return localPluginParams;
      localPluginParams.b = "BuscardPlugin.apk";
      localPluginParams.d = "公交卡";
    }
  }
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BuscardHelper", 4, "createBuscardAppInterface processName=" + paramString);
    }
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.mobileqq.buscard.BuscardAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        try
        {
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("BuscardHelper", 4, "*createBuscardAppInterface load class fail");
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          paramBaseApplicationImpl.printStackTrace();
        }
        paramString = paramString;
        if (QLog.isDevelopLevel()) {
          QLog.d("BuscardHelper", 4, "createBuscardAppInterface 1");
        }
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "BuscardPlugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.buscard.BuscardAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
      do
      {
        return null;
        if (QLog.isDevelopLevel()) {
          QLog.d("BuscardHelper", 4, "createBuscardAppInterface 2");
        }
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (QLog.isDevelopLevel()) {
          QLog.d("BuscardHelper", 4, "createBuscardAppInterface 3");
        }
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    if (paramBaseApplicationImpl == null) {}
    return null;
  }
  
  @TargetApi(19)
  public static void a(Activity paramActivity, NfcAdapter.ReaderCallback paramReaderCallback)
  {
    if ((Build.VERSION.SDK_INT < 19) || (paramActivity == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("presence", 3000);
    NfcAdapter.getDefaultAdapter(paramActivity).enableReaderMode(paramActivity, paramReaderCallback, 131, localBundle);
  }
  
  @TargetApi(19)
  public static void a(Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2) {}
  
  @TargetApi(19)
  public static void a(Activity paramActivity, boolean paramBoolean, String paramString1, String paramString2, NfcAdapter.ReaderCallback paramReaderCallback)
  {
    try
    {
      if (Build.VERSION.SDK_INT < 10) {
        return;
      }
      NfcAdapter localNfcAdapter = NfcAdapter.getDefaultAdapter(paramActivity);
      if ((localNfcAdapter == null) || (!localNfcAdapter.isEnabled()) || (!a(paramActivity)))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("BuscardHelper", 2, "nfcAdapter 不可用");
        return;
      }
      if ((paramBoolean) || (a(paramString1, paramString2)))
      {
        paramString1 = PendingIntent.getActivity(paramActivity, 0, new Intent(paramActivity, paramActivity.getClass()).addFlags(536870912), 0);
        paramString2 = IsoDep.class.getName();
        String[] arrayOfString1 = { NfcV.class.getName() };
        paramReaderCallback = NfcF.class.getName();
        String[] arrayOfString2 = { MifareClassic.class.getName() };
        String[] arrayOfString3 = { NfcA.class.getName() };
        String str = NfcB.class.getName();
        localNfcAdapter.enableForegroundDispatch(paramActivity, paramString1, new IntentFilter[] { new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*") }, new String[][] { { paramString2 }, arrayOfString1, { paramReaderCallback }, arrayOfString2, arrayOfString3, { str } });
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      QLog.e("BuscardHelper", 2, "registerNFCEvent failed");
      return;
    }
    a(paramActivity, paramReaderCallback);
  }
  
  public static void a(String paramString, Activity paramActivity, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardHelper", 4, "before jumpBuscardPlugin ; action=android.nfc.action.TECH_DISCOVERED");
    }
    paramString = "{ \"viewTag\":\"busCard\", \"comeForm\":4, \"appInfo\":\"appid#0|bargainor_id#0|channel#qwallet_gotonfc\", \"userId\":\"" + paramString + "\" }";
    Parcelable localParcelable = paramIntent.getParcelableExtra("android.nfc.extra.TAG");
    paramIntent = new Bundle();
    paramIntent.putString("json", paramString);
    paramIntent.putString("callbackSn", "0");
    paramIntent.putParcelable("android.nfc.extra.TAG", localParcelable);
    paramString = new Intent();
    paramString.setClass(paramActivity, BuscardPluginInstallActivity.class);
    paramString.putExtras(paramIntent);
    paramActivity.startActivity(paramString);
    if (QLog.isDevelopLevel()) {
      QLog.i("BuscardHelper", 4, "after jumpBuscardPlugin");
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent, ServiceConnection paramServiceConnection, boolean paramBoolean)
  {
    Object localObject = (TicketManager)paramAppRuntime.getManager(2);
    if (localObject != null)
    {
      localObject = ((TicketManager)localObject).getSkey(paramAppRuntime.getAccount());
      paramIntent = new Intent(paramIntent);
      if (!paramBoolean) {
        break label138;
      }
      paramIntent.setClass(paramAppRuntime.getApplication(), WlxProxyService.class);
    }
    for (;;)
    {
      paramIntent.putExtra("useSkinEngine", -1);
      paramIntent.putExtra("skey", (String)localObject);
      paramIntent.putExtra("uin", paramAppRuntime.getAccount());
      paramIntent.putExtra("qq_version", DeviceInfoUtil.d());
      paramIntent = a(paramIntent, paramAppRuntime.getAccount(), paramServiceConnection, paramBoolean);
      IPluginManager.b(paramAppRuntime.getApplication(), paramIntent);
      if (QLog.isColorLevel()) {
        QLog.i("BuscardHelper", 2, "launchPluginService");
      }
      return;
      localObject = "";
      break;
      label138:
      paramIntent.setClass(paramAppRuntime.getApplication(), BuscardProxyService.class);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, Intent paramIntent, String paramString)
  {
    Intent localIntent;
    ResultReceiver localResultReceiver;
    IPluginManager localIPluginManager;
    if ((paramIntent != null) && (paramAppRuntime != null))
    {
      localIntent = new Intent(paramIntent);
      localResultReceiver = (ResultReceiver)paramIntent.getParcelableExtra("result");
      localIPluginManager = (IPluginManager)paramAppRuntime.getManager(26);
      if ((localIPluginManager != null) && (localIPluginManager.isReady())) {
        break label100;
      }
      if (QLog.isColorLevel()) {
        QLog.w("BuscardHelper", 2, "loadBuscardService plugin has not ready,return!");
      }
      if (localResultReceiver != null)
      {
        paramAppRuntime = new Bundle();
        paramAppRuntime.putParcelable("nfcIntent", localIntent);
        localResultReceiver.send(-2, paramAppRuntime);
      }
    }
    label100:
    do
    {
      do
      {
        return;
        String str = "BuscardPlugin.apk";
        paramIntent = str;
        if (!TextUtils.isEmpty(paramString))
        {
          paramIntent = str;
          if ("com.tencent.mobileqq.action.wlx.service".equals(paramString)) {
            paramIntent = "wlx_jtcode.apk";
          }
        }
        if (!localIPluginManager.isPlugininstalled(paramIntent)) {
          break;
        }
      } while (localResultReceiver == null);
      paramAppRuntime = new Bundle();
      paramAppRuntime.putParcelable("nfcIntent", localIntent);
      localResultReceiver.send(4, paramAppRuntime);
      return;
      localIPluginManager.installPlugin(paramIntent, new amqi(paramAppRuntime, localIntent));
    } while (!QLog.isColorLevel());
    QLog.i("BuscardHelper", 2, "Plugin not installed,install first.");
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission("android.permission.NFC", "com.tencent.mobileqq");
      if (i == 0) {
        bool = true;
      }
    }
    catch (Throwable paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BuscardHelper", 2, "checkPermission failed");
    }
    return bool;
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString1)) {}
    for (boolean bool1 = false;; bool1 = Boolean.parseBoolean(paramString1))
    {
      paramString1 = Build.MODEL;
      if ((bool1) && (Build.VERSION.SDK_INT >= 19))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString2))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString1))
          {
            bool1 = bool2;
            if (!paramString2.contains(paramString1)) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.buscard.BuscardHelper
 * JD-Core Version:    0.7.0.1
 */