package com.tencent.mobileqq.filemanager.util;

import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class FilePathUtil$1
  implements MediaScannerConnection.OnScanCompletedListener
{
  public void onScanCompleted(String paramString, Uri paramUri)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("FilePathUtil<FileAssistant>", 1, "MediaScannerConnection Scanned:\n" + paramString + ":\nuri=" + paramUri);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FilePathUtil.1
 * JD-Core Version:    0.7.0.1
 */