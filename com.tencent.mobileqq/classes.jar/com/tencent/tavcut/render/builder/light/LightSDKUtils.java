package com.tencent.tavcut.render.builder.light;

import android.annotation.SuppressLint;
import com.tencent.tavcut.config.DynamicSoConfig;
import com.tencent.tavcut.render.log.TavLogger;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/builder/light/LightSDKUtils;", "", "()V", "SO_SUFFIX", "", "TAG", "<set-?>", "", "isSoLoaded", "()Z", "loadSo", "soPath", "soName", "dynamicSoConfigs", "", "Lcom/tencent/tavcut/config/DynamicSoConfig;", "tryInstallSo", "absolutePath", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class LightSDKUtils
{
  public static final LightSDKUtils a = new LightSDKUtils();
  private static boolean b;
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private final boolean a(String paramString)
  {
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (((File)localObject).isFile()))
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tryInstallSo : ");
        ((StringBuilder)localObject).append(paramString);
        TavLogger.c("LightSDKUtils", ((StringBuilder)localObject).toString());
        System.load(paramString);
        return true;
      }
      catch (NullPointerException paramString) {}catch (UnsatisfiedLinkError paramString)
      {
        break label109;
      }
      catch (SecurityException paramString)
      {
        break label144;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NullPointerException:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      TavLogger.e("LightSDKUtils", ((StringBuilder)localObject).toString());
      return false;
      label109:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("UnsatisfiedLinkError:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      TavLogger.e("LightSDKUtils", ((StringBuilder)localObject).toString());
      return false;
      label144:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SecurityException:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      TavLogger.e("LightSDKUtils", ((StringBuilder)localObject).toString());
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("file not exist:");
    ((StringBuilder)localObject).append(paramString);
    TavLogger.e("LightSDKUtils", ((StringBuilder)localObject).toString());
    return false;
  }
  
  private final boolean a(String paramString1, String paramString2)
  {
    if (StringsKt.endsWith$default(paramString1, ".so", false, 2, null)) {
      return a(paramString1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return a(localStringBuilder.toString());
  }
  
  public final boolean a()
  {
    return b;
  }
  
  public final boolean a(@NotNull List<DynamicSoConfig> paramList)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramList, "dynamicSoConfigs");
      boolean bool = true;
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        DynamicSoConfig localDynamicSoConfig = (DynamicSoConfig)paramList.next();
        if (localDynamicSoConfig.c()) {
          bool &= a.a(localDynamicSoConfig.a(), localDynamicSoConfig.b());
        }
      }
      b = bool;
      bool = b;
      return bool;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.builder.light.LightSDKUtils
 * JD-Core Version:    0.7.0.1
 */