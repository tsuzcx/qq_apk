package com.tencent.mobileqq.portal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PortalManager$PortalConfig
  extends PortalManager.TimerConfig
{
  public String actEndWording;
  public String activityTime;
  List awardConfigList = new ArrayList();
  public String bgImg;
  public String bgMd5;
  public int cardCnt;
  public int continuousRecord;
  public String countDownTips;
  public int countGrab;
  public long countTime;
  public transient int currentCountGrab;
  public String emptyMsg;
  public String grabMsg;
  public int hbCnt;
  public String hotAddMsg;
  public String hotImg;
  public String hotMd5;
  public String hotPublicId;
  public String hotTopic;
  public String hotUrl;
  public int id;
  public boolean isHit;
  public String leftCloudImageMD5;
  public String leftCloudImageUrl;
  List logoList = new ArrayList();
  public int mode;
  public String nextActTime;
  public long realBegin;
  public long realEnd;
  public String rightCloudImageMD5;
  public String rightCloudImageURL;
  public String rightMsg;
  public long scrollTime;
  public String shareImageMD5;
  public String shareImageUrl;
  public String shareStarImageMD5;
  public String shareStarImageUrl;
  public String shareWording = "";
  public long showSharePageTime;
  public String starGuiderPhotoMD5;
  public String starGuiderPhotoURL;
  public int starLucytype;
  public int starNoLucyType;
  public transient int starShareType = -1;
  public transient int starShareTypeReqState = 0;
  public String structMsgContentForScore = "";
  public String structMsgContentForStar = "";
  public String structMsgTitleForScore = "";
  public String structMsgTitleForStar = "";
  public String summaryForScore = "";
  public String summaryForStar = "";
  public int type;
  public int useFlag;
  public long useTime;
  public String wishingMsg;
  
  public PortalManager$PortalConfig()
  {
    super(null);
  }
  
  public PortalManager.AwardConfig findRealAwardConfigById(long paramLong)
  {
    if ((this.awardConfigList != null) && (!this.awardConfigList.isEmpty()))
    {
      Iterator localIterator = this.awardConfigList.iterator();
      while (localIterator.hasNext())
      {
        PortalManager.AwardConfig localAwardConfig = (PortalManager.AwardConfig)localIterator.next();
        if ((localAwardConfig != null) && (localAwardConfig.awardId == paramLong)) {
          return localAwardConfig;
        }
      }
    }
    return null;
  }
  
  public boolean isOver(long paramLong)
  {
    return (this.useTime != 0L) && (paramLong > this.useTime + this.countTime);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(this.id);
    localStringBuilder.append(", type=").append(this.type);
    localStringBuilder.append(", mode=").append(this.mode);
    localStringBuilder.append(", countTime=").append(this.countTime);
    localStringBuilder.append(", realBegin=").append(this.realBegin);
    localStringBuilder.append(", realEnd=").append(this.realEnd);
    localStringBuilder.append(", useFlag=").append(this.useFlag);
    localStringBuilder.append(", logoList=").append(this.logoList);
    localStringBuilder.append(", awardConfigList=").append(this.awardConfigList);
    localStringBuilder.append(", starLucytype=").append(this.starLucytype);
    localStringBuilder.append(", starNoLucyType=").append(this.starNoLucyType);
    localStringBuilder.append(", shareType=").append(this.starShareType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.PortalConfig
 * JD-Core Version:    0.7.0.1
 */