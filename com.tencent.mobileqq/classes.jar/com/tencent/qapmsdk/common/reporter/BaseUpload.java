package com.tencent.qapmsdk.common.reporter;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/reporter/BaseUpload;", "", "()V", "addLost", "", "plugin", "", "code", "resp", "", "category", "getProtocol", "url", "Ljava/net/URL;", "isSucceeded", "", "request", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public abstract class BaseUpload
{
  public static final BaseUpload.Companion Companion = new BaseUpload.Companion(null);
  public static final int PROTOCOL_HTTP = 0;
  public static final int PROTOCOL_HTTPS = 1;
  
  public abstract void addLost(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2);
  
  public final int getProtocol(@Nullable URL paramURL)
  {
    int i = 1;
    int j = 1;
    if (paramURL != null)
    {
      i = j;
      if (Intrinsics.areEqual(paramURL.getProtocol(), "http")) {
        i = 0;
      }
    }
    return i;
  }
  
  public boolean isSucceeded(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resp");
    return true;
  }
  
  public abstract void request();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.reporter.BaseUpload
 * JD-Core Version:    0.7.0.1
 */