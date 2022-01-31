package com.tencent.mobileqq.data;

import android.text.TextUtils;
import awge;
import awhp;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="discussionUin,memberUin")
public class DiscussionMemberInfo
  extends awge
{
  public long dataTime;
  public String discussionUin;
  @awhp
  public String displayedNamePinyinFirst;
  public byte flag;
  public String inteRemark;
  public long inteRemarkSource;
  public String memberName;
  public String memberUin;
  
  public String getDiscussionMemberName()
  {
    if (!TextUtils.isEmpty(this.inteRemark)) {}
    for (String str1 = this.inteRemark;; str1 = this.memberName)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = this.memberUin;
      }
      return str2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.DiscussionMemberInfo
 * JD-Core Version:    0.7.0.1
 */