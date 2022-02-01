package com.tencent.rmonitor.common.util;

import android.os.Build.VERSION;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/AndroidVersion$Companion;", "", "()V", "isOverHoneycomb", "", "isOverIceScreamSandwich", "isOverJellyBean", "isOverJellyBeanMr1", "isOverKitKat", "isOverKitKatWatch", "isOverL", "isOverM", "isOverN", "isOverO", "isOverP", "isOverQ", "isOverR", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class AndroidVersion$Companion
{
  @JvmStatic
  public final boolean a()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  @JvmStatic
  public final boolean b()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  @JvmStatic
  public final boolean c()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  @JvmStatic
  public final boolean d()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  @JvmStatic
  public final boolean e()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  @JvmStatic
  public final boolean f()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  @JvmStatic
  public final boolean g()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  @JvmStatic
  public final boolean h()
  {
    return Build.VERSION.SDK_INT >= 28;
  }
  
  @JvmStatic
  public final boolean i()
  {
    return Build.VERSION.SDK_INT >= 30;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.AndroidVersion.Companion
 * JD-Core Version:    0.7.0.1
 */