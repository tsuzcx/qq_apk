package com.tencent.mobileqq.data;

import android.text.TextUtils;
import aphw;
import apia;
import apib;
import awge;
import awhp;
import awhs;
import java.util.ArrayList;
import java.util.List;

public class DatingInfo
  extends awge
{
  @awhp
  private static final int FLAG_MASK_COMMENT_NEW_OVER = 32;
  @awhp
  private static final int FLAG_MASK_STRANGER_NEW_OVER = 8;
  @awhp
  private static final int FLAG_MASK_VISIT_NEW_OVER = 2;
  @awhp
  public static final int TYPE_COMMENT = 1;
  @awhp
  private List<aphw> commentList = new ArrayList(20);
  public String commentPacked;
  @awhs
  public String datingId;
  public int datingSubject;
  public long datingTime;
  @awhp
  public boolean isInit;
  @awhp
  public long lastUpdateTime;
  @awhp
  private int nPrivateFlag;
  public int owner;
  @awhp
  public String strDatingTime;
  @awhp
  private List<apia> strangerInfos = new ArrayList(20);
  public String strangerInfosPacked;
  @awhp
  private List<apia> visitorInfos = new ArrayList(20);
  public String visitorInfosPacked;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (DatingInfo)paramObject;
    } while (((this.datingId != null) || (paramObject.datingId != null)) && ((this.datingId == null) || (!this.datingId.equals(paramObject.datingId))));
    return true;
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
    if (this.datingTime == 0L) {}
    for (this.strDatingTime = "";; this.strDatingTime = apib.a(this.datingTime, this.datingSubject, false))
    {
      apia.a(this.visitorInfos, this.visitorInfosPacked);
      this.nPrivateFlag |= 0x2;
      aphw.a(this.commentList, this.commentPacked);
      this.nPrivateFlag |= 0x20;
      apia.a(this.strangerInfos, this.strangerInfosPacked);
      this.nPrivateFlag |= 0x8;
      return;
    }
  }
  
  public boolean isDefaultValue()
  {
    boolean bool = false;
    if ((this.datingSubject == 0) || (this.datingTime == 0L)) {
      bool = true;
    }
    return bool;
  }
  
  public void prewrite()
  {
    for (;;)
    {
      synchronized (this.strangerInfos)
      {
        if ((this.nPrivateFlag & 0x8) == 8)
        {
          this.strangerInfosPacked = apia.a(this.strangerInfos);
          synchronized (this.visitorInfos)
          {
            if ((this.nPrivateFlag & 0x2) == 2) {
              this.visitorInfosPacked = apia.a(this.visitorInfos);
            }
          }
        }
      }
      synchronized (this.commentList)
      {
        if ((this.nPrivateFlag & 0x8) == 8)
        {
          this.commentPacked = aphw.a(this.commentList);
          return;
          this.strangerInfosPacked = "";
          continue;
          localObject1 = finally;
          throw localObject1;
          this.visitorInfosPacked = "";
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        this.commentPacked = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingInfo
 * JD-Core Version:    0.7.0.1
 */