package com.tencent.mobileqq.filemanager.util;

import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class QQFilePathUtil$1
  implements MediaScannerConnection.OnScanCompletedListener
{
  public void onScanCompleted(String paramString, Uri paramUri)
  {
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MediaScannerConnection Scanned:\n");
      localStringBuilder.append(paramString);
      localStringBuilder.append(":\nuri=");
      localStringBuilder.append(paramUri);
      QLog.i("FilePathUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFilePathUtil.1
 * JD-Core Version:    0.7.0.1
 */