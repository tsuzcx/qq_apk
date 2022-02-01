package com.tencent.rmonitor.base.upload;

import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/upload/BaseUpload;", "", "()V", "getProtocol", "", "url", "Ljava/net/URL;", "request", "", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract class BaseUpload
{
  public static final BaseUpload.Companion c = new BaseUpload.Companion(null);
  
  public final int a(@Nullable URL paramURL)
  {
    int i = 1;
    if (paramURL != null) {
      i = true ^ Intrinsics.areEqual(paramURL.getProtocol(), "http");
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.upload.BaseUpload
 * JD-Core Version:    0.7.0.1
 */