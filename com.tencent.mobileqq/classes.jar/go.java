import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.BitSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class go
{
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[0-9A-Fa-f]+");
  private final WifiManager jdField_a_of_type_AndroidNetWifiWifiManager;
  protected final String a;
  protected final String b = "WPA";
  protected final String c = "nopass";
  
  public go(WifiManager paramWifiManager)
  {
    this.jdField_a_of_type_JavaLangString = "WEP";
    this.jdField_a_of_type_AndroidNetWifiWifiManager = paramWifiManager;
  }
  
  private static WifiConfiguration a(gq paramgq)
  {
    WifiConfiguration localWifiConfiguration = new WifiConfiguration();
    localWifiConfiguration.allowedAuthAlgorithms.clear();
    localWifiConfiguration.allowedGroupCiphers.clear();
    localWifiConfiguration.allowedKeyManagement.clear();
    localWifiConfiguration.allowedPairwiseCiphers.clear();
    localWifiConfiguration.allowedProtocols.clear();
    localWifiConfiguration.SSID = a(paramgq.b(), new int[0]);
    localWifiConfiguration.hiddenSSID = paramgq.a();
    return localWifiConfiguration;
  }
  
  private static Integer a(WifiManager paramWifiManager, String paramString)
  {
    paramWifiManager = paramWifiManager.getConfiguredNetworks();
    if (paramWifiManager == null) {
      return null;
    }
    paramWifiManager = paramWifiManager.iterator();
    while (paramWifiManager.hasNext())
    {
      WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramWifiManager.next();
      if (localWifiConfiguration.SSID.equals(paramString)) {
        return Integer.valueOf(localWifiConfiguration.networkId);
      }
    }
    return null;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          if ((localObject[i].getTypeName().equals("WIFI")) && (localObject[i].isAvailable()) && (localObject[i].isConnected())) {
            return ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getSSID();
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    do
    {
      return str;
      if (paramString.charAt(0) != '"') {
        break;
      }
      str = paramString;
    } while (paramString.charAt(paramString.length() - 1) == '"');
    return '"' + paramString + '"';
  }
  
  private static String a(String paramString, int... paramVarArgs)
  {
    if (a(paramString, paramVarArgs)) {
      return paramString;
    }
    return a(paramString);
  }
  
  private static boolean a(WifiManager paramWifiManager, WifiConfiguration paramWifiConfiguration)
  {
    Integer localInteger = a(paramWifiManager, paramWifiConfiguration.SSID);
    if (localInteger != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BizWifiConfigManager", 2, "Removing old configuration for network " + paramWifiConfiguration.SSID);
      }
      paramWifiManager.removeNetwork(localInteger.intValue());
      if (paramWifiManager.saveConfiguration()) {}
    }
    label163:
    do
    {
      do
      {
        do
        {
          return false;
          int i = paramWifiManager.addNetwork(paramWifiConfiguration);
          if (i < 0) {
            break label163;
          }
          if (!paramWifiManager.enableNetwork(i, true)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BizWifiConfigManager", 2, "Associating to network " + paramWifiConfiguration.SSID);
          }
        } while (!paramWifiManager.saveConfiguration());
        return true;
      } while (!QLog.isColorLevel());
      QLog.d("BizWifiConfigManager", 2, "Failed to enable network " + paramWifiConfiguration.SSID);
      return false;
    } while (!QLog.isColorLevel());
    QLog.d("BizWifiConfigManager", 2, "Unable to add network " + paramWifiConfiguration.SSID);
    return false;
  }
  
  private static boolean a(WifiManager paramWifiManager, gq paramgq)
  {
    WifiConfiguration localWifiConfiguration = a(paramgq);
    localWifiConfiguration.wepKeys[0] = a(paramgq.d(), new int[] { 10, 26, 58 });
    localWifiConfiguration.wepTxKeyIndex = 0;
    localWifiConfiguration.allowedAuthAlgorithms.set(1);
    localWifiConfiguration.allowedKeyManagement.set(0);
    localWifiConfiguration.allowedGroupCiphers.set(2);
    localWifiConfiguration.allowedGroupCiphers.set(3);
    localWifiConfiguration.allowedGroupCiphers.set(0);
    localWifiConfiguration.allowedGroupCiphers.set(1);
    return a(paramWifiManager, localWifiConfiguration);
  }
  
  private static boolean a(CharSequence paramCharSequence, int... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramCharSequence == null) || (!jdField_a_of_type_JavaUtilRegexPattern.matcher(paramCharSequence).matches())) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramVarArgs.length == 0);
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label72;
      }
      int k = paramVarArgs[i];
      bool1 = bool2;
      if (paramCharSequence.length() == k) {
        break;
      }
      i += 1;
    }
    label72:
    return false;
  }
  
  private static boolean b(WifiManager paramWifiManager, gq paramgq)
  {
    WifiConfiguration localWifiConfiguration = a(paramgq);
    localWifiConfiguration.preSharedKey = a(paramgq.d(), new int[] { 64 });
    localWifiConfiguration.allowedAuthAlgorithms.set(0);
    localWifiConfiguration.allowedProtocols.set(0);
    localWifiConfiguration.allowedProtocols.set(1);
    localWifiConfiguration.allowedKeyManagement.set(1);
    localWifiConfiguration.allowedKeyManagement.set(2);
    localWifiConfiguration.allowedPairwiseCiphers.set(1);
    localWifiConfiguration.allowedPairwiseCiphers.set(2);
    localWifiConfiguration.allowedGroupCiphers.set(2);
    localWifiConfiguration.allowedGroupCiphers.set(3);
    return a(paramWifiManager, localWifiConfiguration);
  }
  
  private static boolean c(WifiManager paramWifiManager, gq paramgq)
  {
    paramgq = a(paramgq);
    paramgq.allowedKeyManagement.set(0);
    return a(paramWifiManager, paramgq);
  }
  
  public boolean a(gq paramgq)
  {
    int i;
    if (!this.jdField_a_of_type_AndroidNetWifiWifiManager.isWifiEnabled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("BizWifiConfigManager", 2, "Enabling wi-fi...");
      }
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager.setWifiEnabled(true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BizWifiConfigManager", 2, "Wi-fi enabled");
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidNetWifiWifiManager.isWifiEnabled()) {
        if (i >= 10)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BizWifiConfigManager", 2, "Took too long to enable wi-fi, quitting");
          }
          label84:
          do
          {
            return false;
          } while (!QLog.isColorLevel());
          QLog.d("BizWifiConfigManager", 2, "Wi-fi could not be enabled!");
          return false;
        }
      }
      try
      {
        Thread.sleep(1000L);
        label109:
        i += 1;
        continue;
        String str = paramgq.c();
        if ((TextUtils.isEmpty(str)) || (str.equals("nopass"))) {
          return c(this.jdField_a_of_type_AndroidNetWifiWifiManager, paramgq);
        }
        if (TextUtils.isEmpty(paramgq.d())) {
          break label84;
        }
        if ("WEP".equals(str)) {
          return a(this.jdField_a_of_type_AndroidNetWifiWifiManager, paramgq);
        }
        if (!"WPA".equals(str)) {
          break label84;
        }
        return b(this.jdField_a_of_type_AndroidNetWifiWifiManager, paramgq);
      }
      catch (InterruptedException localInterruptedException)
      {
        break label109;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     go
 * JD-Core Version:    0.7.0.1
 */