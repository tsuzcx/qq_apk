package com.tencent.mobileqq.camera.adapter;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DeviceInstance
{
  private static final DeviceInstance jdField_a_of_type_ComTencentMobileqqCameraAdapterDeviceInstance = new DeviceInstance();
  private static String jdField_a_of_type_JavaLangString = "DeviceInstance";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "motorola", "mot", "FIH", "Sony Ericsson", "samsung", "HTC", "HUN", "LGE", "alps", "OPPO", "TCL", "LENOVO", "ZTE", "Meizu", "Xiaomi", "HUAWEI", "TIANYU", "sprd", "K-Touch", "YuLong", "CoolPad", "Amazon", "Hisense", "Acer", "GIONEE", "Philips", "asus", "snda.com", "koobee", "AMOI", "Fason", "ainol", "Dell", "dlkjl12389", "haier", "sharp", "BBK", "nubia", "KONKA" };
  private static final String[] b = { "MOTOROLA", "MOTOROLA", "MOTOROLA", "SONYERICSSON", "SAMSUNG", "HTC", "HTC", "LG", "OPPO", "OPPO", "TCL", "LENOVO", "ZTE", "MEIZU", "XIAOMI", "HUAWEI", "TIANYU", "TIANYU", "TIANYU", "COOLPAD", "COOLPAD", "AMAZON", "HISENSE", "ACER", "JINLI", "PHILIPS", "GOOGLE", "SHENGDA", "KUBI", "XIAXIN", "FANSHANG", "AINUO", "DELL", "DPD", "HAIER", "SHARP", "BBK", "NUBIA", "KONKA" };
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private DeviceInstance()
  {
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      if (i >= arrayOfString.length) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(arrayOfString[i].toUpperCase(), b[i]);
      i += 1;
    }
    a();
  }
  
  public static DeviceInstance a()
  {
    return jdField_a_of_type_ComTencentMobileqqCameraAdapterDeviceInstance;
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "****** DeviceInfo  (+) *****");
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BRAND_KEYS.len = ");
      localStringBuilder.append(jdField_a_of_type_ArrayOfJavaLangString.length);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BRAND_NAMES.len = ");
      localStringBuilder.append(b.length);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceTypeName = ");
      localStringBuilder.append(a());
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SubTagName = ");
      localStringBuilder.append(a());
      localStringBuilder.append("_");
      localStringBuilder.append(Build.DISPLAY.replace(" ", "_").toUpperCase());
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MODEL = ");
      localStringBuilder.append(Build.MODEL);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SDK_INT = ");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("BRAND = ");
      localStringBuilder.append(Build.BRAND);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DEVICE = ");
      localStringBuilder.append(Build.DEVICE);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DISPLAY = ");
      localStringBuilder.append(Build.DISPLAY);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HARDWARE = ");
      localStringBuilder.append(Build.HARDWARE);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MANUFACTURER = ");
      localStringBuilder.append(Build.MANUFACTURER);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PRODUCT = ");
      localStringBuilder.append(Build.PRODUCT);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TAGS = ");
      localStringBuilder.append(Build.TAGS);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("USER = ");
      localStringBuilder.append(Build.USER);
      QLog.i(str, 2, localStringBuilder.toString());
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TYPE = ");
      localStringBuilder.append(Build.TYPE);
      QLog.i(str, 2, localStringBuilder.toString());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "****** DeviceInfo (-) *****");
    }
  }
  
  public String a()
  {
    Object localObject;
    if (Build.MODEL.equalsIgnoreCase("K-Touch W619"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("TIANYU"));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
    }
    else if ((Build.MODEL.equalsIgnoreCase("8150")) && (Build.BRAND.equalsIgnoreCase("COOLPAD")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get("COOLPAD"));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilHashMap.get(Build.MANUFACTURER.toUpperCase()));
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(Build.MODEL);
      localObject = ((StringBuilder)localObject).toString();
    }
    return ((String)localObject).replace(" ", "_").replace("+", "").replace("(t)", "");
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("_");
    localStringBuilder.append(Build.DISPLAY.replace(" ", "_").toUpperCase());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.DeviceInstance
 * JD-Core Version:    0.7.0.1
 */