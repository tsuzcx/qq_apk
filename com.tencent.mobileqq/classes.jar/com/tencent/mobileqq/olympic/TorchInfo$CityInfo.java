package com.tencent.mobileqq.olympic;

import java.io.Serializable;

public class TorchInfo$CityInfo
  implements Serializable, Cloneable
{
  public long city_id;
  public String city_name;
  public long city_pic_id;
  public String city_pic_md5;
  public String city_pic_url;
  public String cons_pic_md5;
  public String cons_pic_url;
  
  protected Object clone()
  {
    try
    {
      CityInfo localCityInfo = (CityInfo)super.clone();
      return localCityInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("(");
    localStringBuilder.append("city_id=").append(this.city_id).append(",");
    localStringBuilder.append("city_name=").append(this.city_name).append(",");
    localStringBuilder.append("city_pic_id=").append(this.city_pic_id).append(",");
    localStringBuilder.append("city_pic_md5=").append(this.city_pic_md5).append(",");
    localStringBuilder.append("cons_pic_url=").append(this.cons_pic_url).append(",");
    localStringBuilder.append("cons_pic_md5=").append(this.cons_pic_md5);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.TorchInfo.CityInfo
 * JD-Core Version:    0.7.0.1
 */