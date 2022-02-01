package com.tencent.xaction;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/XActionImpl$Companion$downloadFromUrl$1", "Lcom/tencent/mobileqq/vip/DownloadListener;", "onDone", "", "task", "Lcom/tencent/mobileqq/vip/DownloadTask;", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class XActionImpl$Companion$downloadFromUrl$1
  extends DownloadListener
{
  XActionImpl$Companion$downloadFromUrl$1(Function2 paramFunction2, String paramString1, String paramString2) {}
  
  public void onDone(@NotNull DownloadTask paramDownloadTask)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloadTask, "task");
    if (paramDownloadTask.e() == 3)
    {
      this.a.invoke("success", this.b);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downloadFromUrl :");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" status:");
    localStringBuilder.append(paramDownloadTask.e());
    QLog.d("XActionImpl", 1, localStringBuilder.toString());
    this.a.invoke("failed", this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XActionImpl.Companion.downloadFromUrl.1
 * JD-Core Version:    0.7.0.1
 */