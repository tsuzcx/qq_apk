package com.tencent.rmonitor.fd.utils;

import com.tencent.rmonitor.fd.dump.data.FdHeapData;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.HeapField;
import shark.HeapObject;
import shark.HeapObject.HeapInstance;
import shark.HeapValue;
import shark.Hprof;
import shark.Hprof.Companion;
import shark.HprofHeapGraph;
import shark.HprofHeapGraph.Companion;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/fd/utils/SharkUtil;", "", "()V", "TAG", "", "getHprofHeapGraph", "Lcom/tencent/rmonitor/fd/dump/data/FdHeapData;", "dumpFile", "Ljava/io/File;", "getInstanceField", "Lshark/HeapObject$HeapInstance;", "instance", "declaringClass", "filedName", "getIntField", "", "getStringField", "writeFile", "", "filePath", "input", "Ljava/io/InputStream;", "isAppend", "", "rmonitor-memory_release"}, k=1, mv={1, 1, 15})
public final class SharkUtil
{
  public static final SharkUtil a = new SharkUtil();
  
  @JvmStatic
  public static final int a(@Nullable HeapObject.HeapInstance paramHeapInstance, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filedName");
    if (paramHeapInstance != null)
    {
      paramHeapInstance = paramHeapInstance.b(paramHeapInstance.j(), paramString);
      if (paramHeapInstance != null)
      {
        paramHeapInstance = paramHeapInstance.c();
        if (paramHeapInstance != null)
        {
          paramHeapInstance = paramHeapInstance.a();
          if (paramHeapInstance != null) {
            return paramHeapInstance.intValue();
          }
        }
      }
    }
    return -1;
  }
  
  @JvmStatic
  public static final int a(@Nullable HeapObject.HeapInstance paramHeapInstance, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "declaringClass");
    Intrinsics.checkParameterIsNotNull(paramString2, "filedName");
    if (paramHeapInstance != null)
    {
      paramHeapInstance = paramHeapInstance.b(paramString1, paramString2);
      if (paramHeapInstance != null)
      {
        paramHeapInstance = paramHeapInstance.c();
        if (paramHeapInstance != null)
        {
          paramHeapInstance = paramHeapInstance.a();
          if (paramHeapInstance != null) {
            return paramHeapInstance.intValue();
          }
        }
      }
    }
    return -1;
  }
  
  @JvmStatic
  @NotNull
  public static final FdHeapData a(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "dumpFile");
    paramFile = Hprof.a.a(paramFile);
    return new FdHeapData(paramFile, HprofHeapGraph.Companion.a(HprofHeapGraph.a, paramFile, null, null, 6, null));
  }
  
  @JvmStatic
  @NotNull
  public static final String b(@Nullable HeapObject.HeapInstance paramHeapInstance, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filedName");
    if (paramHeapInstance != null)
    {
      paramHeapInstance = paramHeapInstance.b(paramHeapInstance.j(), paramString);
      if (paramHeapInstance != null)
      {
        paramHeapInstance = paramHeapInstance.c();
        if (paramHeapInstance != null)
        {
          paramHeapInstance = paramHeapInstance.f();
          if (paramHeapInstance != null) {
            return paramHeapInstance;
          }
        }
      }
    }
    return "";
  }
  
  @JvmStatic
  @NotNull
  public static final String b(@NotNull HeapObject.HeapInstance paramHeapInstance, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapInstance, "instance");
    Intrinsics.checkParameterIsNotNull(paramString1, "declaringClass");
    Intrinsics.checkParameterIsNotNull(paramString2, "filedName");
    paramHeapInstance = paramHeapInstance.b(paramString1, paramString2);
    if (paramHeapInstance != null)
    {
      paramHeapInstance = paramHeapInstance.c();
      if (paramHeapInstance != null)
      {
        paramHeapInstance = paramHeapInstance.f();
        if (paramHeapInstance != null) {
          return paramHeapInstance;
        }
      }
    }
    return "";
  }
  
  @JvmStatic
  @Nullable
  public static final HeapObject.HeapInstance c(@NotNull HeapObject.HeapInstance paramHeapInstance, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramHeapInstance, "instance");
    Intrinsics.checkParameterIsNotNull(paramString1, "declaringClass");
    Intrinsics.checkParameterIsNotNull(paramString2, "filedName");
    paramHeapInstance = paramHeapInstance.b(paramString1, paramString2);
    if (paramHeapInstance != null)
    {
      paramHeapInstance = paramHeapInstance.c();
      if (paramHeapInstance != null)
      {
        paramHeapInstance = paramHeapInstance.e();
        if (paramHeapInstance != null) {
          return paramHeapInstance.f();
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.utils.SharkUtil
 * JD-Core Version:    0.7.0.1
 */