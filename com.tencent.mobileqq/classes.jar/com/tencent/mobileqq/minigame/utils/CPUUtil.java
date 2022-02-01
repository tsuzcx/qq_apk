package com.tencent.mobileqq.minigame.utils;

import android.os.Build;
import android.os.SystemProperties;

public class CPUUtil
{
  public static volatile boolean sARMv7Compatible;
  public static volatile boolean sIsX86Emulator;
  
  static
  {
    if (Build.MODEL.contains("Android SDK built for x86")) {
      sIsX86Emulator = true;
    }
    String str1 = System.getProperty("os.arch");
    String str2 = SystemProperties.get("ro.product.cpu.abi");
    if ((Build.CPU_ABI.contains("x86")) || (Build.CPU_ABI2.contains("x86")) || ((str1 != null) && (str1.contains("x86"))) || ((str2 != null) && (str2.contains("x86"))))
    {
      str1 = SystemProperties.get("ro.dalvik.vm.native.bridge");
      if ((str1 != null) && (!str1.equals("0")) && (SystemProperties.getInt("ro.enable.native.bridge.exec", 0) != 0)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.CPUUtil
 * JD-Core Version:    0.7.0.1
 */