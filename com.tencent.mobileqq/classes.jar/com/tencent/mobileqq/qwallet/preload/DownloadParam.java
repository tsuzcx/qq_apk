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
    return "DownloadParam{url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", md5Time=" + this.md5Time + ", isForceUnzip=" + this.isForceUnzip + ", headers=" + this.headers + ", md5ForChecked=" + this.md5ForChecked + ", filePos=" + this.filePos + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.DownloadParam
 * JD-Core Version:    0.7.0.1
 */