package com.tencent.richmediabrowser.download;

import com.android.volley.VolleyError;

public class DownloadError
  extends VolleyError
{
  public static final String URL_IS_NULL = "url is null";
  public String errorMessage;
  
  public DownloadError(String paramString)
  {
    this.errorMessage = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.download.DownloadError
 * JD-Core Version:    0.7.0.1
 */