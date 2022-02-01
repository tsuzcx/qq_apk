package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.dating.DatingComment;
import com.tencent.mobileqq.dating.DatingStranger;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.List;

public class DatingInfo
  extends Entity
{
  @notColumn
  private static final int FLAG_MASK_COMMENT_NEW_OVER = 32;
  @notColumn
  private static final int FLAG_MASK_STRANGER_NEW_OVER = 8;
  @notColumn
  private static final int FLAG_MASK_VISIT_NEW_OVER = 2;
  @notColumn
  public static final int TYPE_COMMENT = 1;
  @notColumn
  private List<DatingComment> commentList = new ArrayList(20);
  public String commentPacked;
  @unique
  public String datingId;
  public int datingSubject;
  public long datingTime;
  @notColumn
  public boolean isInit = false;
  @notColumn
  public long lastUpdateTime;
  @notColumn
  private int nPrivateFlag = 0;
  public int owner;
  @notColumn
  public String strDatingTime;
  @notColumn
  private List<DatingStranger> strangerInfos = new ArrayList(20);
  public String strangerInfosPacked;
  @notColumn
  private List<DatingStranger> visitorInfos = new ArrayList(20);
  public String visitorInfosPacked;
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (DatingInfo)paramObject;
    boolean bool1;
    if ((this.datingId != null) || (paramObject.datingId != null))
    {
      String str = this.datingId;
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (!str.equals(paramObject.datingId)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public int hashCode()
  {
    if (TextUtils.isEmpty(this.datingId)) {
      return "".hashCode();
    }
    return this.datingId.hashCode();
  }
  
  public void init()
  {
    long l = this.datingTime;
    if (l == 0L) {
      this.strDatingTime = "";
    } else {
      this.strDatingTime = DatingUtil.a(l, this.datingSubject, false);
    }
    DatingStranger.a(this.visitorInfos, this.visitorInfosPacked);
    this.nPrivateFlag |= 0x2;
    DatingComment.a(this.commentList, this.commentPacked);
    this.nPrivateFlag |= 0x20;
    DatingStranger.a(this.strangerInfos, this.strangerInfosPacked);
    this.nPrivateFlag |= 0x8;
  }
  
  public boolean isDefaultValue()
  {
    return (this.datingSubject == 0) || (this.datingTime == 0L);
  }
  
  protected void prewrite()
  {
    synchronized (this.strangerInfos)
    {
      if ((this.nPrivateFlag & 0x8) == 8) {
        this.strangerInfosPacked = DatingStranger.a(this.strangerInfos);
      } else {
        this.strangerInfosPacked = "";
      }
      synchronized (this.visitorInfos)
      {
        if ((this.nPrivateFlag & 0x2) == 2) {
          this.visitorInfosPacked = DatingStranger.a(this.visitorInfos);
        } else {
          this.visitorInfosPacked = "";
        }
        synchronized (this.commentList)
        {
          if ((this.nPrivateFlag & 0x8) == 8) {
            this.commentPacked = DatingComment.a(this.commentList);
          } else {
            this.commentPacked = "";
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingInfo
 * JD-Core Version:    0.7.0.1
 */