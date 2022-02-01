package com.tencent.smtt.sdk;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.smtt.utils.TbsLog;

final class TbsDownloader$1
  implements c.a
{
  TbsDownloader$1(TbsDownloadConfig paramTbsDownloadConfig) {}
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Execute command [1000](");
    localStringBuilder.append(paramString);
    localStringBuilder.append("), force tbs downloader request");
    TbsLog.i("TbsDownload", localStringBuilder.toString());
    paramString = this.a.mPreferences.edit();
    paramString.putLong("last_check", 0L);
    paramString.apply();
    paramString.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader.1
 * JD-Core Version:    0.7.0.1
 */