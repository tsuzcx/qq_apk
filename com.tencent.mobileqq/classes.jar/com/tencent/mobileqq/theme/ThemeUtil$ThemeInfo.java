package com.tencent.mobileqq.theme;

import java.io.Serializable;
import org.json.JSONArray;

public class ThemeUtil$ThemeInfo
  implements Serializable
{
  public String downloadUrl = "";
  public long downsize;
  public int fileNum;
  public boolean isVoiceTheme;
  public String seriesID;
  public long size;
  public long startTime;
  public String status = "1";
  public JSONArray themeArray;
  public String themeId = "";
  public String version = "200";
  public int zipVer;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ThemeInfo.class.getName());
    localStringBuilder.append("{");
    localStringBuilder.append("themeId=");
    localStringBuilder.append(this.themeId);
    localStringBuilder.append("zipVer=");
    localStringBuilder.append(this.zipVer);
    localStringBuilder.append(",status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(",downsize=");
    localStringBuilder.append(this.downsize);
    localStringBuilder.append(",size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(",version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(",isVoiceTheme=");
    localStringBuilder.append(this.isVoiceTheme);
    localStringBuilder.append(",fileNum=");
    localStringBuilder.append(this.fileNum);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo
 * JD-Core Version:    0.7.0.1
 */