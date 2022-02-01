package com.tencent.mobileqq.data;

public class PublishDatingOption$ShopInfo
{
  public int poi = -1;
  public String shopAddr = "";
  public String shopId = "";
  public String shopName = "";
  public String shopPicUrl = "";
  public int shopSp = -1;
  public String shopUrl = "";
  public String shopZone = "";
  
  public PublishDatingOption$ShopInfo(PublishDatingOption paramPublishDatingOption) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shopName：");
    localStringBuilder.append(this.shopName);
    localStringBuilder.append(",shopAddr");
    localStringBuilder.append(this.shopAddr);
    localStringBuilder.append(",shopUrl:");
    localStringBuilder.append(this.shopUrl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublishDatingOption.ShopInfo
 * JD-Core Version:    0.7.0.1
 */