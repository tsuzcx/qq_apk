package com.tencent.mobileqq.kandian.base.report;

import java.io.Serializable;

public class AppConfigInfo
  implements Serializable
{
  public String appCode;
  public String appName;
  public String appPackageName;
  public String appPath;
  public boolean isAbsolutePath = false;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appName = ");
    localStringBuilder.append(this.appName);
    localStringBuilder.append("\nappCode = ");
    localStringBuilder.append(this.appCode);
    localStringBuilder.append("\nappPackageName = ");
    localStringBuilder.append(this.appPackageName);
    localStringBuilder.append("\nappPath = ");
    localStringBuilder.append(this.appPath);
    localStringBuilder.append("\nisAbsolutePath = ");
    String str;
    if (this.isAbsolutePath) {
      str = "1";
    } else {
      str = "0";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.AppConfigInfo
 * JD-Core Version:    0.7.0.1
 */