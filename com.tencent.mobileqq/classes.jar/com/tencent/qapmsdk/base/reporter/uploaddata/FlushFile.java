package com.tencent.qapmsdk.base.reporter.uploaddata;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadManager.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/FlushFile;", "", "()V", "TAG", "", "looper", "Landroid/os/Looper;", "getLooper", "()Landroid/os/Looper;", "flush", "", "fileName", "metas", "", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/IMetaData;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class FlushFile
{
  public static final FlushFile INSTANCE = new FlushFile();
  @NotNull
  public static final String TAG = "QAPM_base_FlushFile";
  @Nullable
  private static final Looper looper = ThreadManager.Companion.getReporterThreadLooper();
  
  public final void flush(@NotNull String paramString, @NotNull List<? extends IMetaData> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "fileName");
    Intrinsics.checkParameterIsNotNull(paramList, "metas");
    new Handler(ThreadManager.Companion.getLogThreadLooper()).post((Runnable)new FlushFile.flush.1(paramList, paramString));
  }
  
  @Nullable
  public final Looper getLooper()
  {
    return looper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.FlushFile
 * JD-Core Version:    0.7.0.1
 */