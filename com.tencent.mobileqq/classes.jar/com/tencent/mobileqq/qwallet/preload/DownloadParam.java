package com.tencent.mobileqq.qwallet.preload;

import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.List;

public class DownloadParam
  implements Serializable
{
  public static final int FILE_POS_INNER = 1;
  public static final int FILE_POS_SDCARD = 0;
  public String filePath;
  public int filePos = 0;
  public List<Pair<String, String>> headers;
  public boolean isFlowControl = false;
  public boolean isForceUnzip = false;
  public boolean isPreDownload = false;
  public String md5 = "";
  public String md5ForChecked = "";
  public long md5Time = 0L;
  public String url;
  public boolean useQWalletConfig = false;
  
  public void standardlize()
  {
    if (PreloadStaticApi.a) {
      this.filePos = 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownloadParam{url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5Time=");
    localStringBuilder.append(this.md5Time);
    localStringBuilder.append(", isForceUnzip=");
    localStringBuilder.append(this.isForceUnzip);
    localStringBuilder.append(", headers=");
    localStringBuilder.append(this.headers);
    localStringBuilder.append(", md5ForChecked=");
    localStringBuilder.append(this.md5ForChecked);
    localStringBuilder.append(", filePos=");
    localStringBuilder.append(this.filePos);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.DownloadParam
 * JD-Core Version:    0.7.0.1
 */