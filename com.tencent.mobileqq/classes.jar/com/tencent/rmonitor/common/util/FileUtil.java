package com.tencent.rmonitor.common.util;

import android.app.Application;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/FileUtil;", "", "()V", "Companion", "IStreamListener", "MmapFile", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class FileUtil
{
  public static final FileUtil.Companion a = new FileUtil.Companion(null);
  private static final String b = "RMonitor_common_FileUtil";
  private static String c = "";
  private static String d;
  @Nullable
  private static Application e;
  
  @JvmStatic
  @Nullable
  public static final File a(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    return a.a(paramFile1, paramFile2);
  }
  
  @JvmStatic
  @NotNull
  public static final String a(@NotNull InputStream paramInputStream, int paramInt)
  {
    return a.a(paramInputStream, paramInt);
  }
  
  @JvmStatic
  @Nullable
  public static final ArrayList<File> a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return a.a(paramString1, paramString2);
  }
  
  @JvmStatic
  public static final void a(@Nullable File paramFile)
  {
    a.a(paramFile);
  }
  
  @JvmStatic
  public static final boolean a(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    return a.a(paramString1, paramString2, paramBoolean);
  }
  
  @JvmStatic
  public static final boolean a(@Nullable List<String> paramList, @NotNull String paramString, boolean paramBoolean)
  {
    return a.a(paramList, paramString, paramBoolean);
  }
  
  @JvmStatic
  public static final boolean b(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    return a.b(paramString1, paramString2, paramBoolean);
  }
  
  @JvmStatic
  public static final boolean c(@Nullable String paramString)
  {
    return a.a(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final String d(@Nullable String paramString)
  {
    return a.b(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final String e()
  {
    return a.b();
  }
  
  @JvmStatic
  public static final boolean e(@NotNull String paramString)
  {
    return a.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */