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
      break label39;
      System.loadLibrary(paramString);
    }
    catch (UnsatisfiedLinkError paramEnginePackage)
    {
      label39:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to load library [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] file:[");
      localStringBuilder.append(localFile);
      localStringBuilder.append("] ");
      localStringBuilder.append(paramEnginePackage.getMessage());
      paramEnginePackage = (TritonException)new TritonInitException(localStringBuilder.toString(), ErrorCodes.NATIVE_LOAD_LIBRARY, (Throwable)paramEnginePackage);
    }
    long l2 = System.currentTimeMillis();
    boolean bool;
    if (paramEnginePackage == null) {
      bool = true;
    } else {
      bool = false;
    }
    paramList.add(new NativeLibraryLoadStatistic(bool, paramString, localFile, paramBoolean, l2 - l1, paramEnginePackage));
    if (paramEnginePackage != null)
    {
      if (paramBoolean)
      {
        paramString = new StringBuilder();
        paramString.append("optional library load failed, ");
        paramString.append(paramEnginePackage.getMessage());
        Logger.i$default("TritonNativeLibraryLoader", paramString.toString(), null, 4, null);
        return;
      }
      paramString = paramEnginePackage.getMessage();
      paramEnginePackage = (Throwable)paramEnginePackage;
      Logger.e("TritonNativeLibraryLoader", paramString, paramEnginePackage);
      throw paramEnginePackage;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.init.PlatformNativeLibraryLoader
 * JD-Core Version:    0.7.0.1
 */