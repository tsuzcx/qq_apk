package com.tencent.mobileqq.portal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PortalManager$PortalConfig
  extends PortalManager.TimerConfig
{
  public String actEndWording;
  public String activityTime;
  List<PortalManager.AwardConfig> awardConfigList = new ArrayList();
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
  public boolean isHit = false;
  public String leftCloudImageMD5;
  public String leftCloudImageUrl;
  List<PortalManager.LogoConfig> logoList = new ArrayList();
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
    Object localObject = this.awardConfigList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.awardConfigList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PortalManager.AwardConfig localAwardConfig = (PortalManager.AwardConfig)((Iterator)localObject).next();
        if ((localAwardConfig != null) && (localAwardConfig.awardId == paramLong)) {
          return localAwardConfig;
        }
      }
    }
    return null;
  }
  
  public boolean isOver(long paramLong)
  {
    long l = this.useTime;
    return (l != 0L) && (paramLong > l + this.countTime);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", mode=");
    localStringBuilder.append(this.mode);
    localStringBuilder.append(", countTime=");
    localStringBuilder.append(this.countTime);
    localStringBuilder.append(", realBegin=");
    localStringBuilder.append(this.realBegin);
    localStringBuilder.append(", realEnd=");
    localStringBuilder.append(this.realEnd);
    localStringBuilder.append(", useFlag=");
    localStringBuilder.append(this.useFlag);
    localStringBuilder.append(", logoList=");
    localStringBuilder.append(this.logoList);
    localStringBuilder.append(", awardConfigList=");
    localStringBuilder.append(this.awardConfigList);
    localStringBuilder.append(", starLucytype=");
    localStringBuilder.append(this.starLucytype);
    localStringBuilder.append(", starNoLucyType=");
    localStringBuilder.append(this.starNoLucyType);
    localStringBuilder.append(", shareType=");
    localStringBuilder.append(this.starShareType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.PortalConfig
 * JD-Core Version:    0.7.0.1
 */