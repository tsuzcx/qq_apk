package com.tencent.mobileqq.data;

import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;

public class MedalInfo
  extends Entity
{
  @notColumn
  public static final int READ_STATE_DEFAULT = 0;
  @notColumn
  public static final int READ_STATE_LOCAL_READ = 2;
  @notColumn
  public static final int READ_STATE_UNREAD = 1;
  @unique
  public int iId;
  public int iLevel;
  public int iLevelCount;
  public int iNoProgress;
  public int iPointLevel1;
  public int iPointLevel2;
  public int iPointLevel3;
  public int iType;
  public int iUnreadLevel1;
  public int iUnreadLevel2;
  public int iUnreadLevel3;
  public long lEndTime;
  public long lObtainTimeLevel1;
  public long lObtainTimeLevel2;
  public long lObtainTimeLevel3;
  public long lSeqLevel1;
  public long lSeqLevel2;
  public long lSeqLevel3;
  public String strDescLevel1;
  public String strDescLevel2;
  public String strDescLevel3;
  public String strDetailUrlLevel1;
  public String strDetailUrlLevel2;
  public String strDetailUrlLevel3;
  public String strName;
  public String strResJson;
  public String strTaskDescLevel1;
  public String strTaskDescLevel2;
  public String strTaskDescLevel3;
  
  public boolean isNewer(MedalInfo paramMedalInfo)
  {
    if (paramMedalInfo == null) {
      return true;
    }
    long l2 = this.lObtainTimeLevel1;
    long l1 = l2;
    if (Utils.b(l2, this.lObtainTimeLevel2) < 0) {
      l1 = this.lObtainTimeLevel2;
    }
    l2 = l1;
    if (Utils.b(l1, this.lObtainTimeLevel3) < 0) {
      l2 = this.lObtainTimeLevel3;
    }
    long l3 = paramMedalInfo.lObtainTimeLevel1;
    l1 = l3;
    if (Utils.b(l3, paramMedalInfo.lObtainTimeLevel2) < 0) {
      l1 = paramMedalInfo.lObtainTimeLevel2;
    }
    l3 = l1;
    if (Utils.b(l1, paramMedalInfo.lObtainTimeLevel3) < 0) {
      l3 = paramMedalInfo.lObtainTimeLevel3;
    }
    return Utils.b(l2, l3) > 0;
  }
  
  public boolean isUnread()
  {
    int i = this.iLevel;
    boolean bool3 = false;
    boolean bool1;
    if (i == 255)
    {
      bool1 = bool3;
      if (this.iUnreadLevel1 != 1) {}
    }
    else
    {
      do
      {
        do
        {
          return true;
          bool1 = bool3;
          if (this.iLevelCount <= 1) {
            break;
          }
          boolean bool2;
          if ((i >= 1) && (this.iUnreadLevel1 == 1)) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          bool1 = bool2;
          if (this.iLevel >= 2) {
            if ((!bool2) && (this.iUnreadLevel2 != 1)) {
              bool1 = false;
            } else {
              bool1 = true;
            }
          }
          if (this.iLevel < 3) {
            break;
          }
        } while (bool1);
        bool1 = bool3;
      } while (this.iUnreadLevel3 == 1);
    }
    return bool1;
  }
  
  public void putReportInfo(ArrayList<MedalID> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = this.iLevel;
    if (i == 255)
    {
      if (this.iUnreadLevel1 == 1) {
        paramArrayList.add(new MedalID(this.iId, 255));
      }
    }
    else
    {
      if ((this.iUnreadLevel1 == 1) && (i >= 1)) {
        paramArrayList.add(new MedalID(this.iId, 1));
      }
      if ((this.iUnreadLevel2 == 1) && (this.iLevel >= 2)) {
        paramArrayList.add(new MedalID(this.iId, 2));
      }
      if ((this.iUnreadLevel3 == 1) && (this.iLevel >= 3)) {
        paramArrayList.add(new MedalID(this.iId, 3));
      }
    }
  }
  
  public void setRead()
  {
    int i = this.iLevel;
    if (i == 255)
    {
      this.iUnreadLevel1 = 2;
      return;
    }
    if (i >= 1) {
      this.iUnreadLevel1 = 2;
    }
    if (this.iLevel >= 2) {
      this.iUnreadLevel2 = 2;
    }
    if (this.iLevel >= 3) {
      this.iUnreadLevel3 = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MedalInfo
 * JD-Core Version:    0.7.0.1
 */