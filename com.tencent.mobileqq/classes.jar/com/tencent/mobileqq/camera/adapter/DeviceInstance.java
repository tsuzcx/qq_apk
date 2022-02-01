package com.tencent.mobileqq.camera.adapter;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DeviceInstance
{
  private static String a = "DeviceInstance";
  private static final String[] c = { "motorola", "mot", "FIH", "Sony Ericsson", "samsung", "HTC", "HUN", "LGE", "alps", "OPPO", "TCL", "LENOVO", "ZTE", "Meizu", "Xiaomi", "HUAWEI", "TIANYU", "sprd", "K-Touch", "YuLong", "CoolPad", "Amazon", "Hisense", "Acer", "GIONEE", "Philips", "asus", "snda.com", "koobee", "AMOI", "Fason", "ainol", "Dell", "dlkjl12389", "haier", "sharp", "BBK", "nubia", "KONKA" };
  private static final String[] d = { "MOTOROLA", "MOTOROLA", "MOTOROLA", "SONYERICSSON", "SAMSUNG", "HTC", "HTC", "LG", "OPPO", "OPPO", "TCL", "LENOVO", "ZTE", "MEIZU", "XIAOMI", "HUAWEI", "TIANYU", "TIANYU", "TIANYU", "COOLPAD", "COOLPAD", "AMAZON", "HISENSE", "ACER", "JINLI", "PHILIPS", "GOOGLE", "SHENGDA", "KUBI", "XIAXIN", "FANSHANG", "AINUO", "DELL", "DPD", "HAIER", "SHARP", "BBK", "NUBIA", "KONKA" };
  private static final DeviceInstance e = new DeviceInstance();
  private HashMap<String, String> b = new HashMap();
  
  private DeviceInstance()
  {
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = c;
      if (i >= arrayOfString.length) {
        break;
      }
      this.b.put(arrayOfString[i].toUpperCase(), d[i]);
      i += 1;
    }
    d();
  }
  
  public static DeviceInstance a()
  {
    return e;
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      QLog.i(a, 2, "****** DeviceInfo  (+) *****");
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BRAND_KEYS.len = ");
      localStringBuilder.append(c.length);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BRAND_NAMES.len = ");
      localStringBuilder.append(d.length);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceTypeName = ");
      localStringBuilder.append(b());
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SubTagName = ");
      localStringBuilder.append(b());
      localStringBuilder.append("_");
      localStringBuilder.append(Build.DISPLAY.replace(" ", "_").toUpperCase());
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MODEL = ");
      localStringBuilder.append(Build.MODEL);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SDK_INT = ");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BRAND = ");
      localStringBuilder.append(Build.BRAND);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DEVICE = ");
      localStringBuilder.append(Build.DEVICE);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DISPLAY = ");
      localStringBuilder.append(Build.DISPLAY);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HARDWARE = ");
      localStringBuilder.append(Build.HARDWARE);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MANUFACTURER = ");
      localStringBuilder.append(Build.MANUFACTURER);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PRODUCT = ");
      localStringBuilder.append(Build.PRODUCT);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TAGS = ");
      localStringBuilder.append(Build.TAGS);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("USER = ");
      localStringBuilder.append(Build.USER);
      QLog.i(str, 2, localStringBuilder.toString());
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TYPE = ");
      localStringBuilder.append(Build.TYPE);
      QLog.i(str, 2, localStringBuilder.toString());
      QLog.i(a, 2, "****** DeviceInfo (-) *****");
    }
  }
  
  public String b()
  {
    Object localObject;
    if (Build.MODEL.equalsIgnoreCase("K-Touch W619"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)this.b.get("TIANYU"));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
    }
    else if ((Build.MODEL.equalsIgnoreCase("8150")) && (Build.BRAND.equalsIgnoreCase("COOLPAD")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)this.b.get("COOLPAD"));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)this.b.get(Build.MANUFACTURER.toUpperCase()));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
    }
    return ((String)localObject).replace(" ", "_").replace("+", "").replace("(t)", "");
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("_");
    localStringBuilder.append(Build.DISPLAY.replace(" ", "_").toUpperCase());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.DeviceInstance
 * JD-Core Version:    0.7.0.1
 */