package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="uin")
public class Stranger
  extends Entity
{
  public static final int GENDER_FEMALE = 1;
  public static final int GENDER_MALE = 0;
  public static final int GENDER_OTHER = 2;
  public byte age;
  public byte gender;
  public String groupName;
  public String login;
  public byte loginId;
  public String name;
  public String remark;
  public long time;
  @notColumn
  public boolean uiSelected;
  @unique
  public String uin;
  
  public static boolean copyInfo(Stranger paramStranger1, Stranger paramStranger2)
  {
    if ((paramStranger1 == null) || (paramStranger1 == null)) {
      return false;
    }
    paramStranger2.age = paramStranger1.age;
    paramStranger2.gender = paramStranger1.gender;
    paramStranger2.groupName = paramStranger1.groupName;
    paramStranger2.login = paramStranger1.login;
    paramStranger2.time = paramStranger1.time;
    paramStranger2.remark = paramStranger1.remark;
    return true;
  }
  
  public String toString()
  {
    return "Stranger [uin=" + this.uin + ", name=" + this.name + ", age=" + this.age + ", remark=" + this.remark + ", gender=" + this.gender + ", groupName=" + this.groupName + ", login=" + this.login + ", time=" + this.time + ", uiSelected=" + this.uiSelected + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.Stranger
 * JD-Core Version:    0.7.0.1
 */