package com.tencent.rmonitor.common.util;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/DeviceUtil;", "", "()V", "ETH_MAC_ADDRESS", "", "KEY_VERSION_EMUI", "KEY_VERSION_MIUI", "KEY_VERSION_OPPO", "KEY_VERSION_SMARTISAN", "KEY_VERSION_VIVO", "ROM_EMUI", "ROM_FLYME", "ROM_MIUI", "ROM_OPPO", "ROM_QIKU", "ROM_SMARTISAN", "ROM_VIVO", "TAG", "WLAN_MAC_ADDRESS", "deviceId", "height", "", "romName", "romVersion", "width", "check", "", "rom", "generateDeviceId", "app", "Landroid/app/Application;", "getDisplayHeight", "context", "Landroid/content/Context;", "getDisplaySize", "getDisplayWidth", "getMacAddress", "getMacAddressFromNetworkInterface", "getProp", "name", "is360", "isEmui", "isFlyme", "isMiui", "isOppo", "isSmartisan", "isVivo", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DeviceUtil
{
  public static final DeviceUtil a = new DeviceUtil();
  private static String b = "";
  private static int c = -1;
  private static int d = -1;
  
  private final String a()
  {
    Object localObject2 = null;
    try
    {
      localEnumeration = NetworkMonitor.getNetworkInterfaces();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          Enumeration localEnumeration;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "interfaceElement");
          byte[] arrayOfByte = ((NetworkInterface)localObject1).getHardwareAddress();
          if (arrayOfByte == null) {
            continue;
          }
          int i = arrayOfByte.length;
          int j = 0;
          if (i == 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            continue;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          int k = arrayOfByte.length;
          i = 0;
          if (i < k)
          {
            byte b1 = arrayOfByte[i];
            Object localObject3 = StringCompanionObject.INSTANCE;
            localObject3 = new Object[1];
            localObject3[0] = Byte.valueOf(b1);
            localObject3 = String.format("%02X:", Arrays.copyOf((Object[])localObject3, localObject3.length));
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "java.lang.String.format(format, *args)");
            localStringBuilder.append((String)localObject3);
            i += 1;
            continue;
          }
          i = j;
          if (((CharSequence)localStringBuilder).length() > 0) {
            i = 1;
          }
          if (i != 0) {
            localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          }
          if (!Intrinsics.areEqual(((NetworkInterface)localObject1).getName(), "wlan0")) {
            continue;
          }
          Object localObject1 = localStringBuilder.toString();
          return localObject1;
        }
        catch (SocketException localSocketException) {}
        localException = localException;
      }
    }
    localEnumeration = null;
    localObject1 = localObject2;
    if (localEnumeration != null)
    {
      localObject1 = localObject2;
      if (localEnumeration.hasMoreElements()) {
        localObject1 = (NetworkInterface)localEnumeration.nextElement();
      }
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public static final String a(@Nullable Application paramApplication)
  {
    localObject3 = "0";
    Object localObject1;
    if ((TextUtils.isEmpty((CharSequence)b)) && (paramApplication != null))
    {
      localObject1 = a;
      localObject2 = paramApplication.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.applicationContext");
      localObject1 = ((DeviceUtil)localObject1).a((Context)localObject2);
      if (localObject1 == null) {
        localObject1 = "";
      }
    }
    try
    {
      localObject2 = paramApplication.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.applicationContext");
      localObject2 = Settings.Secure.getString(((Context)localObject2).getContentResolver(), "android_id");
    }
    catch (Throwable localThrowable)
    {
      label77:
      break label77;
    }
    Object localObject2 = "";
    try
    {
      Object localObject4 = paramApplication.getApplicationContext().getSystemService("phone");
      paramApplication = localObject4;
      if (!(localObject4 instanceof TelephonyManager)) {
        paramApplication = null;
      }
      paramApplication = (TelephonyManager)paramApplication;
      if (paramApplication != null)
      {
        paramApplication = PhoneInfoMonitor.getDeviceId(paramApplication);
        if (paramApplication != null) {}
      }
      else
      {
        paramApplication = "";
      }
    }
    catch (SecurityException|Throwable paramApplication)
    {
      for (;;)
      {
        paramApplication = (Application)localObject3;
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(Build.BRAND);
    ((StringBuilder)localObject3).append(Build.MODEL);
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(paramApplication);
    b = StringUtil.b(((StringBuilder)localObject3).toString());
    return b;
    return b;
  }
  
  private final String a(Context paramContext)
  {
    Object localObject = paramContext.getSystemService("wifi");
    paramContext = (Context)localObject;
    if (!(localObject instanceof WifiManager)) {
      paramContext = null;
    }
    paramContext = (WifiManager)paramContext;
    if (paramContext != null) {}
    try
    {
      paramContext = NetworkMonitor.getConnectionInfo(paramContext);
    }
    catch (Throwable paramContext)
    {
      label38:
      int j;
      int i;
      break label38;
    }
    paramContext = null;
    if (paramContext != null)
    {
      localObject = paramContext.getMacAddress();
      j = 1;
      if (localObject != null)
      {
        localObject = (Iterable)CollectionsKt.listOf(new String[] { "", "02:00:00:00:00:00" });
        if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
        do
        {
          while (!((Iterator)localObject).hasNext())
          {
            i = 0;
            break;
            localObject = ((Iterable)localObject).iterator();
          }
        } while (!Intrinsics.areEqual((String)((Iterator)localObject).next(), paramContext.getMacAddress()));
        i = 1;
        if (i == 0) {
          return paramContext.getMacAddress();
        }
      }
      paramContext = FileUtil.a.b("/sys/class/net/wlan0/address");
      if (((CharSequence)paramContext).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramContext = FileUtil.a.b("/sys/class/net/eth1/address");
        if (((CharSequence)paramContext).length() == 0) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          paramContext = a();
          if (paramContext != null) {
            return paramContext;
          }
          paramContext = "02:00:00:00:00:00";
        }
      }
      return paramContext;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */