package com.tencent.qqperf.config;

import android.text.TextUtils;
import org.json.JSONObject;

public class APMModuleConfig
{
  public static final JSONObject EMPTY = new JSONObject();
  public float evenRatio = 0.01F;
  public int maxReport = 10;
  public int stackDepth = 6;
  public String strategy = "";
  public int threshold = 100;
  public float userRatio = 0.001F;
  
  public boolean canOpenPlugin()
  {
    return this.userRatio > Math.random();
  }
  
  @Deprecated
  public final String getOldStrategy(String paramString)
  {
    String str = this.strategy;
    if (TextUtils.isEmpty(str)) {
      return paramString;
    }
    return str;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("threshold=");
    localStringBuilder.append(this.threshold);
    localStringBuilder.append(", maxReport=");
    localStringBuilder.append(this.maxReport);
    localStringBuilder.append(", userRatio=");
    localStringBuilder.append(this.userRatio);
    localStringBuilder.append(", evenRatio=");
    localStringBuilder.append(this.evenRatio);
    localStringBuilder.append(", stackDepth=");
    localStringBuilder.append(this.stackDepth);
    localStringBuilder.append(", strategy='");
    localStringBuilder.append(this.strategy);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.config.APMModuleConfig
 * JD-Core Version:    0.7.0.1
 */