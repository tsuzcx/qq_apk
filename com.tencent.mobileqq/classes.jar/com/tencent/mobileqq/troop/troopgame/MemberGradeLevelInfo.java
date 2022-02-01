package com.tencent.mobileqq.troop.troopgame;

import android.database.Cursor;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="memberuin")
public class MemberGradeLevelInfo
  extends Entity
  implements Serializable
{
  public int gradeLevel = 0;
  public String memberuin;
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
    this.gradeLevel = paramCursor.getInt(paramCursor.getColumnIndex("gradeLevel"));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("memberuin = ");
    localStringBuilder.append(this.memberuin);
    localStringBuilder.append(", gradeLevel = ");
    localStringBuilder.append(this.gradeLevel);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo
 * JD-Core Version:    0.7.0.1
 */