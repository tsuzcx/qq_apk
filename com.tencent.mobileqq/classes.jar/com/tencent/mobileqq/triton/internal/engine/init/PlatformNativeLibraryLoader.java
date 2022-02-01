package com.tencent.mobileqq.triton.internal.engine.init;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/engine/init/PlatformNativeLibraryLoader;", "", "()V", "TAG", "", "engineLibs", "", "loadEngineNativeLibrary", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/EnginePackage;", "loadOneLibrary", "", "name", "optional", "", "list", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class PlatformNativeLibraryLoader
{
  public static final PlatformNativeLibraryLoader INSTANCE = new PlatformNativeLibraryLoader();
  private static final String TAG = "TritonNativeLibraryLoader";
  private static final List<String> engineLibs = CollectionsKt.listOf(new String[] { "c++_shared", "freetypejni", "v8jni", "triton" });
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private final void loadOneLibrary(String paramString, boolean paramBoolean, EnginePackage paramEnginePackage, List<NativeLibraryLoadStatistic> paramList)
  {
    File localFile = paramEnginePackage.getEngineNativeLibrary(paramString);
    paramEnginePackage = (TritonException)null;
    long l1 = System.currentTimeMillis();
    if (localFile != null) {}
    try
    {
      System.load(localFile.getAbsolutePath());
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        if (paramEnginePackage != null) {
          break;
        }
        bool = true;
        paramList.add(new NativeLibraryLoadStatistic(bool, paramString, localFile, paramBoolean, l2 - l1, paramEnginePackage));
        if (paramEnginePackage == null) {
          return;
        }
        if (paramBoolean) {
          break label173;
        }
        Logger.e("TritonNativeLibraryLoader", paramEnginePackage.getMessage(), (Throwable)paramEnginePackage);
        throw ((Throwable)paramEnginePackage);
        System.loadLibrary(paramString);
      }
    }
    catch (UnsatisfiedLinkError paramEnginePackage)
    {
      for (;;)
      {
        paramEnginePackage = (TritonException)new TritonInitException("failed to load library [" + paramString + "] file:[" + localFile + "] " + paramEnginePackage.getMessage(), ErrorCodes.NATIVE_LOAD_LIBRARY, (Throwable)paramEnginePackage);
        continue;
        boolean bool = false;
      }
      label173:
      Logger.i$default("TritonNativeLibraryLoader", "optional library load failed, " + paramEnginePackage.getMessage(), null, 4, null);
    }
  }
  
  @NotNull
  public final List<NativeLibraryLoadStatistic> loadEngineNativeLibrary(@NotNull EnginePackage paramEnginePackage)
  {
    Intrinsics.checkParameterIsNotNull(paramEnginePackage, "enginePackage");
    List localList = (List)new ArrayList();
    Iterator localIterator = ((Iterable)engineLibs).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      INSTANCE.loadOneLibrary(str, false, paramEnginePackage, localList);
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.PlatformNativeLibraryLoader
 * JD-Core Version:    0.7.0.1
 */