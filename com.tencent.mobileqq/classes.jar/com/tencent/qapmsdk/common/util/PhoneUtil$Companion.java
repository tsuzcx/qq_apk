package com.tencent.qapmsdk.common.util;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/PhoneUtil$Companion;", "", "()V", "ETH_MAC_ADDRESS", "", "WLAN_MAC_ADDRESS", "deviceId", "height", "", "width", "generateDeviceId", "app", "Landroid/app/Application;", "getDisplayHeight", "context", "Landroid/content/Context;", "getDisplaySize", "getDisplayWidth", "getMacAddress", "getMacAddressFromNetworkInterface", "common_release"}, k=1, mv={1, 1, 15})
public final class PhoneUtil$Companion
{
  private final String getMacAddress(Context paramContext)
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
      paramContext = paramContext.getConnectionInfo();
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
      paramContext = FileUtil.Companion.readOutputFromFile("/sys/class/net/wlan0/address");
      if (((CharSequence)paramContext).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramContext = FileUtil.Companion.readOutputFromFile("/sys/class/net/eth1/address");
        if (((CharSequence)paramContext).length() == 0) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          paramContext = ((Companion)this).getMacAddressFromNetworkInterface();
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
  
  private final String getMacAddressFromNetworkInterface()
  {
    Object localObject2 = null;
    try
    {
      localEnumeration = NetworkInterface.getNetworkInterfaces();
    }
    catch (SocketException localSocketException1)
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
            byte b = arrayOfByte[i];
            Object localObject3 = StringCompanionObject.INSTANCE;
            localObject3 = new Object[1];
            localObject3[0] = Byte.valueOf(b);
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
        catch (SocketException localSocketException2) {}
        localSocketException1 = localSocketException1;
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
  public final String generateDeviceId(@Nullable Application paramApplication)
  {
    localObject3 = "0";
    Object localObject1;
    if ((TextUtils.isEmpty((CharSequence)PhoneUtil.access$getDeviceId$cp())) && (paramApplication != null))
    {
      localObject1 = (Companion)this;
      localObject2 = paramApplication.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.applicationContext");
      localObject1 = ((Companion)localObject1).getMacAddress((Context)localObject2);
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
      label79:
      break label79;
    }
    Object localObject2 = "";
    try
    {
      localObject4 = paramApplication.getApplicationContext().getSystemService("phone");
      paramApplication = (Application)localObject4;
      if (!(localObject4 instanceof TelephonyManager)) {
        paramApplication = null;
      }
      paramApplication = (TelephonyManager)paramApplication;
      if (paramApplication != null)
      {
        paramApplication = paramApplication.getDeviceId();
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
        Object localObject4;
        paramApplication = (Application)localObject3;
      }
    }
    localObject3 = StringUtil.Companion;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(Build.BRAND);
    ((StringBuilder)localObject4).append(Build.MODEL);
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append(paramApplication);
    PhoneUtil.access$setDeviceId$cp(((StringUtil.Companion)localObject3).getMD5(((StringBuilder)localObject4).toString()));
    return PhoneUtil.access$getDeviceId$cp();
    return PhoneUtil.access$getDeviceId$cp();
  }
  
  @JvmStatic
  public final int getDisplayHeight(@Nullable Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    if ((PhoneUtil.access$getHeight$cp() == -1) && (AndroidVersion.Companion.isJellyBeanMr1()))
    {
      Object localObject = paramContext.getSystemService("window");
      paramContext = (Context)localObject;
      if (!(localObject instanceof WindowManager)) {
        paramContext = null;
      }
      paramContext = (WindowManager)paramContext;
      if (paramContext != null)
      {
        paramContext = paramContext.getDefaultDisplay();
        localObject = new Point();
        paramContext.getRealSize((Point)localObject);
        PhoneUtil.access$setHeight$cp(((Point)localObject).y);
      }
    }
    return PhoneUtil.access$getHeight$cp();
  }
  
  @JvmStatic
  @NotNull
  public final String getDisplaySize(@Nullable Context paramContext)
  {
    if (paramContext == null) {
      return "unKnow";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Companion localCompanion = (Companion)this;
    localStringBuilder.append(String.valueOf(localCompanion.getDisplayWidth(paramContext)));
    localStringBuilder.append(",");
    localStringBuilder.append(String.valueOf(localCompanion.getDisplayHeight(paramContext)));
    return localStringBuilder.toString();
  }
  
  @JvmStatic
  public final int getDisplayWidth(@Nullable Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    if ((PhoneUtil.access$getWidth$cp() == -1) && (AndroidVersion.Companion.isJellyBeanMr1()))
    {
      Object localObject = paramContext.getSystemService("window");
      paramContext = (Context)localObject;
      if (!(localObject instanceof WindowManager)) {
        paramContext = null;
      }
      paramContext = (WindowManager)paramContext;
      if (paramContext != null)
      {
        paramContext = paramContext.getDefaultDisplay();
        localObject = new Point();
        paramContext.getRealSize((Point)localObject);
        PhoneUtil.access$setWidth$cp(((Point)localObject).x);
      }
    }
    return PhoneUtil.access$getWidth$cp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.PhoneUtil.Companion
 * JD-Core Version:    0.7.0.1
 */