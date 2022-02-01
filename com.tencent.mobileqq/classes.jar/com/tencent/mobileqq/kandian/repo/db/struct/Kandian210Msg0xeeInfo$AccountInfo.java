package com.tencent.mobileqq.kandian.repo.db.struct;

import java.io.Serializable;

public class Kandian210Msg0xeeInfo$AccountInfo
  implements Serializable
{
  public long uin;
  public String userIconURL;
  public String username;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", username='");
    localStringBuilder.append(this.username);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userIconURL='");
    localStringBuilder.append(this.userIconURL);
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.AccountInfo
 * JD-Core Version:    0.7.0.1
 */