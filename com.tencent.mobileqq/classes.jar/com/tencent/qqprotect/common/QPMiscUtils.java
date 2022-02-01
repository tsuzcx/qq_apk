package com.tencent.qqprotect.common;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectCommon.QQProtectQueryHead;
import com.tencent.kingkong.DataReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import mqq.app.MobileQQ;

public class QPMiscUtils
  extends BaseQPMiscUtils
{
  public static volatile int a = -1;
  
  public static int a()
  {
    Object localObject = DeviceInfoUtil.a(MobileQQ.sMobileQQ);
    try
    {
      localObject = ((String)localObject).split("\\.");
      int i = Integer.parseInt(localObject[0]);
      int j = Integer.parseInt(localObject[1]);
      int k = Integer.parseInt(localObject[2]);
      return k << 8 | i << 24 | 0x0 | j << 16;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public static QQProtectCommon.QQProtectQueryHead a(int paramInt)
  {
    try
    {
      localQQProtectQueryHead = new QQProtectCommon.QQProtectQueryHead();
      localQQProtectQueryHead.uint32_sec_cmd.set(paramInt);
      localObject2 = QQDeviceInfo.getIMEI("641d5d");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localQQProtectQueryHead.bytes_imei.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      localQQProtectQueryHead.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
      localObject1 = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject1 == null) {
        break label247;
      }
      localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    }
    catch (Throwable localThrowable)
    {
      QQProtectCommon.QQProtectQueryHead localQQProtectQueryHead;
      Object localObject1;
      StringBuilder localStringBuilder;
      label151:
      localThrowable.printStackTrace();
      return null;
    }
    localQQProtectQueryHead.string_uin.set((String)localObject2);
    localQQProtectQueryHead.os_version.set(Build.VERSION.SDK_INT);
    paramInt = a();
    localQQProtectQueryHead.qq_version.set(paramInt);
    Object localObject2 = localQQProtectQueryHead.cpu_arch;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.CPU_ABI);
    localStringBuilder.append("#");
    if (b())
    {
      localObject1 = "1";
      localStringBuilder.append((String)localObject1);
      ((PBStringField)localObject2).set(localStringBuilder.toString());
      localQQProtectQueryHead.rom_info.set(Build.MODEL);
      localObject1 = localQQProtectQueryHead.root;
      if (!a()) {
        break label267;
      }
      paramInt = 1;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject1).set(paramInt);
      localQQProtectQueryHead.brand_info.set(Build.BRAND);
      localQQProtectQueryHead.manufacturer.set(Build.MANUFACTURER);
      localQQProtectQueryHead.package_name.set(a());
      localQQProtectQueryHead.app_id.set(AppSetting.a());
      return localQQProtectQueryHead;
      label247:
      String str = null;
      localObject2 = str;
      if (str != null) {
        break;
      }
      localObject2 = "";
      break;
      str = "0";
      break label151;
      label267:
      paramInt = 0;
    }
  }
  
  public static String a(int paramInt)
  {
    return String.format("%d.%d.%d", new Object[] { Integer.valueOf(paramInt >> 24), Integer.valueOf((0xFF0000 & paramInt) >> 16), Integer.valueOf((paramInt & 0xFF00) >> 8) });
  }
  
  public static boolean a()
  {
    bool1 = DataReport.a();
    if (!bool1)
    {
      String[] arrayOfString = new String[3];
      int i = 0;
      arrayOfString[0] = "/system/sbin/";
      arrayOfString[1] = "/sbin/";
      arrayOfString[2] = "/vendor/bin/";
      try
      {
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("su");
          boolean bool2 = new File(localStringBuilder.toString()).exists();
          if (bool2) {
            return true;
          }
          i += 1;
        }
        return bool1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static String b()
  {
    return a(33751040);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == 1) {}
    try
    {
      return QQDeviceInfo.getIMEI("641d5d");
    }
    catch (Exception localException)
    {
      String str;
      break label35;
    }
    if (paramInt == 2) {
      return QQDeviceInfo.getMAC("641d5d");
    }
    if (paramInt == 3)
    {
      str = QQDeviceInfo.getIMSI("641d5d");
      return str;
    }
    label35:
    return null;
  }
  
  public static boolean b()
  {
    String str = System.getProperty("os.arch");
    return (str != null) && (str.contains("64"));
  }
  
  public static String c()
  {
    return a(a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.common.QPMiscUtils
 * JD-Core Version:    0.7.0.1
 */