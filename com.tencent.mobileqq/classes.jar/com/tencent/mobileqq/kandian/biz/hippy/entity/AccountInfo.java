package com.tencent.mobileqq.kandian.biz.hippy.entity;

public class AccountInfo
{
  public String appid;
  public String headUrl;
  public String nickName;
  public String qqNum;
  public String skey;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AccountInfo{qqNum='");
    localStringBuilder.append(this.qqNum);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headUrl='");
    localStringBuilder.append(this.headUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", skey='");
    localStringBuilder.append(this.skey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", appid='");
    localStringBuilder.append(this.appid);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.entity.AccountInfo
 * JD-Core Version:    0.7.0.1
 */