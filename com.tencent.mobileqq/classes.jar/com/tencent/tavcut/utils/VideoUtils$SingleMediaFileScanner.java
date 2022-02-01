package com.tencent.tavcut.utils;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/utils/VideoUtils$SingleMediaFileScanner;", "Landroid/media/MediaScannerConnection$MediaScannerConnectionClient;", "context", "Landroid/content/Context;", "file", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;)V", "mFile", "msConn", "Landroid/media/MediaScannerConnection;", "onMediaScannerConnected", "", "onScanCompleted", "path", "", "uri", "Landroid/net/Uri;", "start", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
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
      if (localMediaScannerConnection == null) {
        Intrinsics.throwNpe();
      }
      File localFile = this.b;
      if (localFile == null) {
        Intrinsics.throwNpe();
      }
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
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramUri, "uri");
    paramString = this.a;
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    if (paramString.isConnected())
    {
      paramString = this.a;
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      paramString.disconnect();
    }
    this.a = ((MediaScannerConnection)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.VideoUtils.SingleMediaFileScanner
 * JD-Core Version:    0.7.0.1
 */