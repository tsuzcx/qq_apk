package com.tencent.mobileqq.triton.statistic;

import com.tencent.mobileqq.triton.exception.TritonException;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "", "success", "", "name", "", "file", "Ljava/io/File;", "isOptional", "loadTimeMs", "", "loadException", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "(ZLjava/lang/String;Ljava/io/File;ZJLcom/tencent/mobileqq/triton/exception/TritonException;)V", "getFile", "()Ljava/io/File;", "()Z", "getLoadException", "()Lcom/tencent/mobileqq/triton/exception/TritonException;", "getLoadTimeMs", "()J", "getName", "()Ljava/lang/String;", "getSuccess", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class NativeLibraryLoadStatistic
{
  @Nullable
  private final File file;
  private final boolean isOptional;
  @Nullable
  private final TritonException loadException;
  private final long loadTimeMs;
  @NotNull
  private final String name;
  private final boolean success;
  
  public NativeLibraryLoadStatistic(boolean paramBoolean1, @NotNull String paramString, @Nullable File paramFile, boolean paramBoolean2, long paramLong, @Nullable TritonException paramTritonException)
  {
    this.success = paramBoolean1;
    this.name = paramString;
    this.file = paramFile;
    this.isOptional = paramBoolean2;
    this.loadTimeMs = paramLong;
    this.loadException = paramTritonException;
  }
  
  public final boolean component1()
  {
    return this.success;
  }
  
  @NotNull
  public final String component2()
  {
    return this.name;
  }
  
  @Nullable
  public final File component3()
  {
    return this.file;
  }
  
  public final boolean component4()
  {
    return this.isOptional;
  }
  
  public final long component5()
  {
    return this.loadTimeMs;
  }
  
  @Nullable
  public final TritonException component6()
  {
    return this.loadException;
  }
  
  @NotNull
  public final NativeLibraryLoadStatistic copy(boolean paramBoolean1, @NotNull String paramString, @Nullable File paramFile, boolean paramBoolean2, long paramLong, @Nullable TritonException paramTritonException)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return new NativeLibraryLoadStatistic(paramBoolean1, paramString, paramFile, paramBoolean2, paramLong, paramTritonException);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof NativeLibraryLoadStatistic))
      {
        paramObject = (NativeLibraryLoadStatistic)paramObject;
        if ((this.success != paramObject.success) || (!Intrinsics.areEqual(this.name, paramObject.name)) || (!Intrinsics.areEqual(this.file, paramObject.file)) || (this.isOptional != paramObject.isOptional) || (this.loadTimeMs != paramObject.loadTimeMs) || (!Intrinsics.areEqual(this.loadException, paramObject.loadException))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @Nullable
  public final File getFile()
  {
    return this.file;
  }
  
  @Nullable
  public final TritonException getLoadException()
  {
    return this.loadException;
  }
  
  public final long getLoadTimeMs()
  {
    return this.loadTimeMs;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  public final boolean getSuccess()
  {
    return this.success;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isOptional()
  {
    return this.isOptional;
  }
  
  @NotNull
  public String toString()
  {
    return "NativeLibraryLoadStatistic(success=" + this.success + ", name=" + this.name + ", file=" + this.file + ", isOptional=" + this.isOptional + ", loadTimeMs=" + this.loadTimeMs + ", loadException=" + this.loadException + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic
 * JD-Core Version:    0.7.0.1
 */