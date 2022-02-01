package com.tencent.mobileqq.stranger.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="uin")
public class Stranger
  extends Entity
{
  public byte age;
  public byte gender;
  public String groupName;
  public String login;
  public byte loginId;
  public String name;
  public String remark;
  public long time;
  @unique
  public String uin;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Stranger{uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.age);
    localStringBuilder.append(", remark='");
    localStringBuilder.append(this.remark);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gender=");
    localStringBuilder.append(this.gender);
    localStringBuilder.append(", groupName='");
    localStringBuilder.append(this.groupName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", login='");
    localStringBuilder.append(this.login);
    localStringBuilder.append('\'');
    localStringBuilder.append(", loginId=");
    localStringBuilder.append(this.loginId);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stranger.data.Stranger
 * JD-Core Version:    0.7.0.1
 */