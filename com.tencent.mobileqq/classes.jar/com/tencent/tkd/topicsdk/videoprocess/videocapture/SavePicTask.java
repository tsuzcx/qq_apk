package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.tkd.topicsdk.common.CompressUtils;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/SavePicTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "bitmap", "Landroid/graphics/Bitmap;", "path", "", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "downloadListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/SavePicTask$DownloadListener;", "getDownloadListener", "()Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/SavePicTask$DownloadListener;", "setDownloadListener", "(Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/SavePicTask$DownloadListener;)V", "doInBackground", "voids", "", "([Ljava/lang/Void;)Ljava/lang/Boolean;", "onPostExecute", "", "result", "onPreExecute", "startDownload", "DownloadListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SavePicTask
  extends AsyncTask<Void, Void, Boolean>
{
  @Nullable
  private SavePicTask.DownloadListener a;
  private final Bitmap b;
  private final String c;
  
  public SavePicTask(@NotNull Bitmap paramBitmap, @NotNull String paramString)
  {
    this.b = paramBitmap;
    this.c = paramString;
  }
  
  @NotNull
  protected Boolean a(@NotNull Void... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "voids");
    boolean bool;
    if (CompressUtils.a(this.b, this.c, null, 0, 12, null) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public final void a()
  {
    ThreadManagerKt.c((Function0)new SavePicTask.startDownload.1(this));
  }
  
  public final void a(@Nullable SavePicTask.DownloadListener paramDownloadListener)
  {
    this.a = paramDownloadListener;
  }
  
  protected void a(boolean paramBoolean)
  {
    super.onPostExecute(Boolean.valueOf(paramBoolean));
    SavePicTask.DownloadListener localDownloadListener = this.a;
    if (localDownloadListener == null) {
      return;
    }
    if (paramBoolean)
    {
      if (localDownloadListener != null) {
        localDownloadListener.a(0L);
      }
    }
    else if (localDownloadListener != null) {
      localDownloadListener.b(0L);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    SavePicTask.DownloadListener localDownloadListener = this.a;
    if (localDownloadListener != null) {
      localDownloadListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.SavePicTask
 * JD-Core Version:    0.7.0.1
 */