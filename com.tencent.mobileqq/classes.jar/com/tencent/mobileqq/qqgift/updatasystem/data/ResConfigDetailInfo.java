package com.tencent.mobileqq.qqgift.updatasystem.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResConfigDetailInfo
  implements Serializable
{
  @SerializedName("static")
  public String defaultName;
  @SerializedName("name")
  public String name;
  @SerializedName("type")
  public String type;
  
  public ResConfigDetailInfo() {}
  
  public ResConfigDetailInfo(String paramString1, String paramString2, String paramString3)
  {
    this.name = paramString1;
    this.type = paramString2;
    this.defaultName = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResConfigDetailInfo{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", defaultName='");
    localStringBuilder.append(this.defaultName);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.data.ResConfigDetailInfo
 * JD-Core Version:    0.7.0.1
 */