package com.tencent.videocut.utils;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/VideoUtils$SingleMediaFileScanner;", "Landroid/media/MediaScannerConnection$MediaScannerConnectionClient;", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;)V", "mFile", "msConn", "Landroid/media/MediaScannerConnection;", "onMediaScannerConnected", "", "onScanCompleted", "path", "", "uri", "Landroid/net/Uri;", "start", "lib_utils_release"}, k=1, mv={1, 4, 2})
final class VideoUtils$SingleMediaFileScanner
  implements MediaScannerConnection.MediaScannerConnectionClient
{
  private MediaScannerConnection a;
  private File b;
  
  public void onMediaScannerConnected()
  {
    try
    {
      MediaScannerConnection localMediaScannerConnection = this.a;
      Intrinsics.checkNotNull(localMediaScannerConnection);
      File localFile = this.b;
      Intrinsics.checkNotNull(localFile);
      localMediaScannerConnection.scanFile(localFile.getAbsolutePath(), null);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void onScanCompleted(@NotNull String paramString, @NotNull Uri paramUri)
  {
    Intrinsics.checkNotNullParameter(paramString, "path");
    Intrinsics.checkNotNullParameter(paramUri, "uri");
    paramString = this.a;
    Intrinsics.checkNotNull(paramString);
    if (paramString.isConnected())
    {
      paramString = this.a;
      Intrinsics.checkNotNull(paramString);
      paramString.disconnect();
    }
    this.a = ((MediaScannerConnection)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.VideoUtils.SingleMediaFileScanner
 * JD-Core Version:    0.7.0.1
 */