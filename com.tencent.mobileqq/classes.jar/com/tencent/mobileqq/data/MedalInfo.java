package com.tencent.mobileqq.data;

import awbv;
import awdg;
import awdj;
import bdal;
import com.tencent.mobileqq.medalwall.MedalID;
import java.util.ArrayList;

public class MedalInfo
  extends awbv
{
  @awdg
  public static final int READ_STATE_DEFAULT = 0;
  @awdg
  public static final int READ_STATE_LOCAL_READ = 2;
  @awdg
  public static final int READ_STATE_UNREAD = 1;
  @awdj
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
    if (bdal.b(l2, this.lObtainTimeLevel2) < 0) {
      l1 = this.lObtainTimeLevel2;
    }
    l2 = l1;
    if (bdal.b(l1, this.lObtainTimeLevel3) < 0) {
      l2 = this.lObtainTimeLevel3;
    }
    long l3 = paramMedalInfo.lObtainTimeLevel1;
    l1 = l3;
    if (bdal.b(l3, paramMedalInfo.lObtainTimeLevel2) < 0) {
      l1 = paramMedalInfo.lObtainTimeLevel2;
    }
    l3 = l1;
    if (bdal.b(l1, paramMedalInfo.lObtainTimeLevel3) < 0) {
      l3 = paramMedalInfo.lObtainTimeLevel3;
    }
    if (bdal.b(l2, l3) > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isUnread()
  {
    boolean bool3 = false;
    boolean bool1 = true;
    if (this.iLevel == 255) {
      if (this.iUnreadLevel1 != 1) {}
    }
    do
    {
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
      bool1 = bool3;
    } while (this.iLevelCount <= 1);
    if (this.iLevel >= 1) {
      if (this.iUnreadLevel1 == 1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      label57:
      boolean bool2 = bool1;
      if (this.iLevel >= 2) {
        if ((!bool1) && (this.iUnreadLevel2 != 1)) {
          break label110;
        }
      }
      label110:
      for (bool2 = true;; bool2 = false)
      {
        if (this.iLevel < 3) {
          break label115;
        }
        if (!bool2)
        {
          bool1 = bool3;
          if (this.iUnreadLevel3 != 1) {
            break;
          }
        }
        return true;
        bool1 = false;
        break label57;
      }
      label115:
      return bool2;
      bool1 = false;
    }
  }
  
  public void putReportInfo(ArrayList<MedalID> paramArrayList)
  {
    if (paramArrayList == null) {}
    do
    {
      do
      {
        return;
        if (this.iLevel != 255) {
          break;
        }
      } while (this.iUnreadLevel1 != 1);
      paramArrayList.add(new MedalID(this.iId, 255));
      return;
      if ((this.iUnreadLevel1 == 1) && (this.iLevel >= 1)) {
        paramArrayList.add(new MedalID(this.iId, 1));
      }
      if ((this.iUnreadLevel2 == 1) && (this.iLevel >= 2)) {
        paramArrayList.add(new MedalID(this.iId, 2));
      }
    } while ((this.iUnreadLevel3 != 1) || (this.iLevel < 3));
    paramArrayList.add(new MedalID(this.iId, 3));
  }
  
  public void setRead()
  {
    if (this.iLevel == 255) {
      this.iUnreadLevel1 = 2;
    }
    do
    {
      return;
      if (this.iLevel >= 1) {
        this.iUnreadLevel1 = 2;
      }
      if (this.iLevel >= 2) {
        this.iUnreadLevel2 = 2;
      }
    } while (this.iLevel < 3);
    this.iUnreadLevel3 = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.MedalInfo
 * JD-Core Version:    0.7.0.1
 */