package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressTask;
import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressTask.VideoCompressTaskListener;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.Callback;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.VideoCompressListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/VideoCompressor;", "Lcom/tencent/tkd/topicsdk/interfaces/IVideoCompressor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancel", "", "checkNeedCompress", "path", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "needCompress", "compress", "listener", "Lcom/tencent/tkd/topicsdk/interfaces/IVideoCompressor$VideoCompressListener;", "Lcom/tencent/tkd/topicsdk/interfaces/IVideoCompressor$Callback;", "restart", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoCompressor
  implements IVideoCompressor
{
  private final Context a;
  
  public VideoCompressor(@NotNull Context paramContext)
  {
    this.a = paramContext;
  }
  
  private final void a(String paramString, Function1<? super Boolean, Unit> paramFunction1)
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      paramFunction1.invoke(Boolean.valueOf(false));
      return;
    }
    ThreadManagerKt.c((Function0)new VideoCompressor.checkNeedCompress.1(paramString, paramFunction1));
  }
  
  public void a(@NotNull String paramString, @NotNull IVideoCompressor.Callback paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramCallback, "callback");
    a(paramString, (Function1)new VideoCompressor.needCompress.1(paramCallback));
  }
  
  public void a(@NotNull String paramString, @NotNull IVideoCompressor.VideoCompressListener paramVideoCompressListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramVideoCompressListener, "listener");
    new VideoCompressTask(this.a, (VideoCompressTask.VideoCompressTaskListener)new VideoCompressor.compress.task.1(paramVideoCompressListener)).execute(new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.VideoCompressor
 * JD-Core Version:    0.7.0.1
 */