package com.tencent.rmonitor.common.util;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/StackUtil;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public class StackUtil
{
  public static final StackUtil.Companion a = new StackUtil.Companion(null);
  private static final ArrayList<String> b = CollectionsKt.arrayListOf(new String[] { "libcore.io", "com.tencent.rmonitor.io", "java.io", "dalvik.system", "android.os" });
  
  @JvmStatic
  @NotNull
  public static final String getCurrentThreadName()
  {
    return a.a();
  }
  
  @JvmStatic
  @NotNull
  public static final String getThrowableStack()
  {
    return a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.StackUtil
 * JD-Core Version:    0.7.0.1
 */