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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.packageName);
    localStringBuilder.append("|");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append("|");
    localStringBuilder.append(filterSplitStr(this.downloadUrl));
    localStringBuilder.append("|");
    localStringBuilder.append(this.yybApkId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.yybAppId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.traceId);
    localStringBuilder.append("|");
    localStringBuilder.append(this.isTDownloadApp);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.st.ReplaceBaseLog
 * JD-Core Version:    0.7.0.1
 */