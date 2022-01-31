package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.Serializable;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RankTitleConfig;

public class RankTitleConfig
  implements Serializable
{
  public String firstTitle;
  public int listType;
  public String secondTitle;
  
  public RankTitleConfig(int paramInt, String paramString1, String paramString2)
  {
    this.listType = paramInt;
    this.firstTitle = paramString1;
    this.secondTitle = paramString2;
  }
  
  public RankTitleConfig(Oidb_0x686.RankTitleConfig paramRankTitleConfig)
  {
    if (paramRankTitleConfig != null)
    {
      if (paramRankTitleConfig.uint32_listtype.has()) {
        this.listType = paramRankTitleConfig.uint32_listtype.get();
      }
      if (paramRankTitleConfig.str_first_title.has()) {
        this.firstTitle = paramRankTitleConfig.str_first_title.get();
      }
      if (paramRankTitleConfig.str_second_title.has()) {
        this.secondTitle = paramRankTitleConfig.str_second_title.get();
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listType:");
    localStringBuilder.append(this.listType);
    localStringBuilder.append(",firstTitle:");
    localStringBuilder.append(this.firstTitle);
    localStringBuilder.append(",secondTitle:");
    localStringBuilder.append(this.secondTitle);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.RankTitleConfig
 * JD-Core Version:    0.7.0.1
 */