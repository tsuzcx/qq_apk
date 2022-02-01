package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.HttpURLConnection;

public class DownloadInfo
{
  public static final String XERR_NO = "X-ErrNo";
  public static final String XFAIL_NO = "X-FailNo";
  public final int action;
  public HttpURLConnection conn;
  public byte[] data = null;
  public int domainType;
  public String emosmEPId;
  public String errorDetail;
  public String extra;
  public final File file;
  public String host = null;
  public int httpRespCode = -1;
  public String ip;
  public boolean isHttps;
  public boolean isIPUrl;
  public boolean isOpen304;
  public String reqUrl;
  public String respContentEncoding;
  public int respContentLength;
  public String respContentRead;
  public String respContentType;
  public String respVerifyString = "";
  public String respXErrNo;
  public String respXFailNo;
  public int resultCode = -1;
  public final String urlOriginal;
  
  public DownloadInfo(String paramString, File paramFile, int paramInt)
  {
    this.reqUrl = paramString;
    this.urlOriginal = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(HttpDownloadUtil.PROTOCOL_HTTPS))) {
      this.isHttps = true;
    }
    this.file = paramFile;
    this.action = paramInt;
  }
  
  public void clearParams()
  {
    this.reqUrl = this.urlOriginal;
    this.isIPUrl = false;
    this.host = null;
    this.errorDetail = "";
    this.data = null;
    this.httpRespCode = -1;
    this.respContentLength = 0;
    this.respContentType = null;
    this.respContentEncoding = null;
    this.respContentRead = null;
    this.respXErrNo = null;
    this.respXFailNo = null;
    this.ip = null;
    this.isIPUrl = false;
  }
  
  public String getLoadingTmpPath()
  {
    return this.file.getAbsolutePath() + ".tmp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.DownloadInfo
 * JD-Core Version:    0.7.0.1
 */