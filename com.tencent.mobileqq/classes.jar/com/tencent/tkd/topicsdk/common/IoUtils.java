package com.tencent.tkd.topicsdk.common;

import java.io.Closeable;
import kotlin.Metadata;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.IoUtils
 * JD-Core Version:    0.7.0.1
 */