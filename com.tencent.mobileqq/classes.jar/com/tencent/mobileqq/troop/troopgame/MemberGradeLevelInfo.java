package com.tencent.mobileqq.troop.troopgame;

import android.database.Cursor;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="memberuin")
public class MemberGradeLevelInfo
  extends Entity
  implements Serializable
{
  public int gradeLevel;
  public String memberuin;
  
  public boolean entityByCursor(Cursor paramCursor)
  {
    this.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
    this.gradeLevel = paramCursor.getInt(paramCursor.getColumnIndex("gradeLevel"));
    return true;
  }
  
  @NonNull
  public String toString()
  {
    return "memberuin = " + this.memberuin + ", gradeLevel = " + this.gradeLevel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo
 * JD-Core Version:    0.7.0.1
 */