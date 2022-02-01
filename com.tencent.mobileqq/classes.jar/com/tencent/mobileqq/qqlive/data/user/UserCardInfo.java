package com.tencent.mobileqq.qqlive.data.user;

public class UserCardInfo
  extends LiveUserInfo
{
  public int clientType = 0;
  public long explicitUid = 0L;
  public String fromAppName = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserCardInfo{explicitUid=");
    localStringBuilder.append(this.explicitUid);
    localStringBuilder.append(", clientType=");
    localStringBuilder.append(this.clientType);
    localStringBuilder.append(", fromAppName='");
    localStringBuilder.append(this.fromAppName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid=");
    localStringBuilder.append(this.uid);
    localStringBuilder.append(", headUrl='");
    localStringBuilder.append(this.headUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nick='");
    localStringBuilder.append(this.nick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sex=");
    localStringBuilder.append(this.sex);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.user.UserCardInfo
 * JD-Core Version:    0.7.0.1
 */