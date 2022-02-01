package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.tkd.topicsdk.common.BitmapUtils;
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
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @Nullable
  private SavePicTask.DownloadListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureSavePicTask$DownloadListener;
  private final String jdField_a_of_type_JavaLangString;
  
  public SavePicTask(@NotNull Bitmap paramBitmap, @NotNull String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @NotNull
  protected Boolean a(@NotNull Void... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "voids");
    return Boolean.valueOf(BitmapUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_JavaLangString));
  }
  
  public final void a()
  {
    ThreadManagerKt.c((Function0)new SavePicTask.startDownload.1(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    super.onPostExecute(Boolean.valueOf(paramBoolean));
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureSavePicTask$DownloadListener == null) {}
    SavePicTask.DownloadListener localDownloadListener;
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        localDownloadListener = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureSavePicTask$DownloadListener;
      } while (localDownloadListener == null);
      localDownloadListener.a(0L);
      return;
      localDownloadListener = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureSavePicTask$DownloadListener;
    } while (localDownloadListener == null);
    localDownloadListener.a(0);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    SavePicTask.DownloadListener localDownloadListener = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureSavePicTask$DownloadListener;
    if (localDownloadListener != null) {
      localDownloadListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.SavePicTask
 * JD-Core Version:    0.7.0.1
 */