package com.tencent.replacemonitor.replace.st;

import com.tencent.tmassistant.st.a;
import java.util.Map;

public abstract class ReplaceBaseLog
  extends a
{
  public String downloadUrl;
  public Map<String, String> externalParams;
  public boolean isTDownloadApp;
  public String packageName;
  public String traceId;
  public int versionCode;
  public long yybApkId;
  public long yybAppId;
  
  public String build()
  {
    return this.packageName + "|" + this.versionCode + "|" + filterSplitStr(this.downloadUrl) + "|" + this.yybApkId + "|" + this.yybAppId + "|" + this.traceId + "|" + this.isTDownloadApp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.st.ReplaceBaseLog
 * JD-Core Version:    0.7.0.1
 */