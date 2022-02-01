package com.tencent.tkd.topicsdk.common;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/IoUtils;", "", "()V", "closeSilently", "", "closeable", "Ljava/io/Closeable;", "copy", "input", "Ljava/io/InputStream;", "outPut", "Ljava/io/OutputStream;", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class IoUtils
{
  public static final IoUtils a = new IoUtils();
  
  public final void a(@Nullable Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public final void a(@NotNull InputStream paramInputStream, @NotNull OutputStream paramOutputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "input");
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "outPut");
    byte[] arrayOfByte = new byte[4096];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      return;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream = (Throwable)paramInputStream;
    }
    for (;;)
    {
      throw paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.IoUtils
 * JD-Core Version:    0.7.0.1
 */