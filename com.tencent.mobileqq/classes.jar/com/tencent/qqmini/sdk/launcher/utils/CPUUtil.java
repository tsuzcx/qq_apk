package com.tencent.qqmini.sdk.launcher.utils;

import android.os.Build;

public class CPUUtil
{
  public static volatile boolean sARMv7Compatible = false;
  public static volatile boolean sIsX86Emulator = false;
  
  static
  {
    if (Build.MODEL.contains("Android SDK built for x86")) {
      sIsX86Emulator = true;
    }
    String str1 = System.getProperty("os.arch");
    String str2 = OSUtils.getSystemProperty("ro.product.cpu.abi", "");
    if ((Build.CPU_ABI.contains("x86")) || (Build.CPU_ABI2.contains("x86")) || ((str1 != null) && (str1.contains("x86"))) || ((str2 != null) && (str2.contains("x86"))))
    {
      str1 = OSUtils.getSystemProperty("ro.dalvik.vm.native.bridge", "");
      if ((str1 != null) && (!str1.equals("0")) && (OSUtils.getSystemProperty("ro.enable.native.bridge.exec", "0").equals("0"))) {
        sIsX86Emulator = true;
      }
    }
    str1 = Build.CPU_ABI;
    str2 = Build.CPU_ABI2;
    if ((!sIsX86Emulator) && ((checkCPUABIStringV7(str1).booleanValue()) || (checkCPUABIStringV7(str2).booleanValue()))) {
      sARMv7Compatible = true;
    }
  }
  
  private static Boolean checkCPUABIStringV7(String paramString)
  {
    if ((paramString.equalsIgnoreCase("armeabi-v7a")) || (paramString.equalsIgnoreCase("arm64-v8a"))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.CPUUtil
 * JD-Core Version:    0.7.0.1
 */