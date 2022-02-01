package com.tencent.mobileqq.data;

import QQService.UserProfile;
import QQService.VipBaseInfo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="lEctID,type")
public class CardProfile
  extends Entity
{
  public static final int TYPE_FAVORITE = 3;
  public static final int TYPE_VISITOR = 1;
  public static final int TYPE_VOTER = 2;
  public byte bAage;
  public long bAvailableCnt;
  public byte bCloseNeighborVote;
  public byte bConstellation = 0;
  public byte bFavorite;
  public byte bFavoritedMe;
  public short bIsLastVoteCharged;
  public byte bMutualFriends;
  public byte bSex;
  public byte bSingle;
  public long bTodayVotedCnt;
  public byte bVote;
  public short bVoteCnt;
  public long dwLikeCustomId;
  public int eUserIdentityType;
  public long lEctID;
  public int lTime;
  public int nFaceNum;
  public short payVoteCount;
  public short shIntroType;
  public VipBaseInfo stVipInfo = null;
  public String strNick;
  @notColumn
  public String strTime = "";
  public int type = 1;
  public long uSource;
  public byte[] vC2CSign = null;
  public byte[] vFaceID;
  public byte[] vIntroContent;
  public byte[] vRichSign = null;
  public short wFace;
  
  public static String tableName()
  {
    return "CardProfilev4";
  }
  
  public CardProfile clone()
  {
    CardProfile localCardProfile = new CardProfile();
    localCardProfile.bAage = this.bAage;
    localCardProfile.bFavorite = this.bFavorite;
    localCardProfile.bFavoritedMe = this.bFavoritedMe;
    localCardProfile.bSex = this.bSex;
    localCardProfile.bSingle = this.bSingle;
    localCardProfile.bVote = this.bVote;
    localCardProfile.eUserIdentityType = this.eUserIdentityType;
    localCardProfile.lEctID = this.lEctID;
    localCardProfile.lTime = this.lTime;
    localCardProfile.bConstellation = this.bConstellation;
    localCardProfile.stVipInfo = this.stVipInfo;
    localCardProfile.type = this.type;
    localCardProfile.nFaceNum = this.nFaceNum;
    localCardProfile.shIntroType = this.shIntroType;
    localCardProfile.strNick = this.strNick;
    localCardProfile.vFaceID = this.vFaceID;
    localCardProfile.vIntroContent = this.vIntroContent;
    localCardProfile.wFace = this.wFace;
    localCardProfile.vC2CSign = this.vC2CSign;
    localCardProfile.bVoteCnt = this.bVoteCnt;
    localCardProfile.uSource = this.uSource;
    localCardProfile.bAvailableCnt = this.bAvailableCnt;
    localCardProfile.bTodayVotedCnt = this.bTodayVotedCnt;
    localCardProfile.bCloseNeighborVote = this.bCloseNeighborVote;
    localCardProfile.bMutualFriends = this.bMutualFriends;
    localCardProfile.dwLikeCustomId = this.dwLikeCustomId;
    localCardProfile.bIsLastVoteCharged = this.bIsLastVoteCharged;
    localCardProfile.vRichSign = this.vRichSign;
    int i = this.lTime;
    if (i > 0) {
      localCardProfile.strTime = TimeFormatterUtils.a(i * 1000L, true, "yyyy-MM-dd");
    }
    return localCardProfile;
  }
  
  public String getSimpleZanInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder("zanInfo:");
    localStringBuilder.append(",");
    localStringBuilder.append("uin");
    localStringBuilder.append("=");
    localStringBuilder.append(this.lEctID);
    localStringBuilder.append(",");
    localStringBuilder.append("t");
    localStringBuilder.append("=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(",");
    localStringBuilder.append("n");
    localStringBuilder.append("=");
    localStringBuilder.append(this.strNick);
    localStringBuilder.append(",");
    localStringBuilder.append("bVC");
    localStringBuilder.append("=");
    localStringBuilder.append(this.bVoteCnt);
    localStringBuilder.append(",");
    localStringBuilder.append("bAailC");
    localStringBuilder.append("=");
    localStringBuilder.append(this.bAvailableCnt);
    localStringBuilder.append(",");
    localStringBuilder.append("bTVC");
    localStringBuilder.append("=");
    localStringBuilder.append(this.bTodayVotedCnt);
    localStringBuilder.append(",");
    localStringBuilder.append("bClose");
    localStringBuilder.append("=");
    localStringBuilder.append(this.bCloseNeighborVote);
    localStringBuilder.append(",");
    localStringBuilder.append("bCharged");
    localStringBuilder.append("=");
    localStringBuilder.append(this.bIsLastVoteCharged);
    localStringBuilder.append(",");
    localStringBuilder.append("payVC");
    localStringBuilder.append("=");
    localStringBuilder.append(this.payVoteCount);
    localStringBuilder.append(",");
    localStringBuilder.append("bMutual");
    localStringBuilder.append("=");
    localStringBuilder.append(this.bMutualFriends);
    return localStringBuilder.toString();
  }
  
  public String getTableName()
  {
    return tableName();
  }
  
  public void readFrom(UserProfile paramUserProfile)
  {
    this.bAage = paramUserProfile.bAge;
    this.bFavorite = paramUserProfile.bFavorited;
    this.bFavoritedMe = paramUserProfile.bFavoritedMe;
    this.bSex = paramUserProfile.bSex;
    this.bSingle = paramUserProfile.bSingle;
    this.bVote = paramUserProfile.bVote;
    this.eUserIdentityType = paramUserProfile.eUserIdentityType;
    this.lEctID = paramUserProfile.lEctID;
    this.lTime = paramUserProfile.lTime;
    this.nFaceNum = paramUserProfile.nFaceNum;
    this.shIntroType = paramUserProfile.shIntroType;
    this.strNick = paramUserProfile.strNick;
    this.vFaceID = paramUserProfile.vFaceID;
    this.vIntroContent = paramUserProfile.vIntroContent;
    this.wFace = paramUserProfile.wFace;
    this.vRichSign = paramUserProfile.vRichSign;
    this.bConstellation = paramUserProfile.bConstellation;
    this.stVipInfo = paramUserProfile.stVipInfo;
    this.vC2CSign = paramUserProfile.vC2CSign;
    this.bVoteCnt = paramUserProfile.bVoteCnt;
    this.bAvailableCnt = paramUserProfile.bAvailableCnt;
    this.bTodayVotedCnt = paramUserProfile.bTodayVotedCnt;
    int i = this.lTime;
    if (i > 0) {
      this.strTime = TimeFormatterUtils.a(i * 1000L, true, "yyyy-MM-dd");
    }
    this.uSource = paramUserProfile.uSource;
    this.bCloseNeighborVote = ((byte)paramUserProfile.bCloseNeighborVote);
    this.dwLikeCustomId = paramUserProfile.dwLikeCustomId;
    this.bIsLastVoteCharged = paramUserProfile.bIsLastVoteCharged;
    this.payVoteCount = paramUserProfile.bTollVoteCnt;
    this.bMutualFriends = ((byte)paramUserProfile.bMutualFriends);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CardProfile");
    localStringBuilder.append(",");
    localStringBuilder.append("lEctID");
    localStringBuilder.append(":");
    localStringBuilder.append(this.lEctID);
    localStringBuilder.append(",");
    localStringBuilder.append("strNick");
    localStringBuilder.append(":");
    localStringBuilder.append(this.strNick);
    localStringBuilder.append(",");
    localStringBuilder.append("bVC");
    localStringBuilder.append(":");
    localStringBuilder.append(this.bVoteCnt);
    localStringBuilder.append(",");
    localStringBuilder.append("bAailC");
    localStringBuilder.append(":");
    localStringBuilder.append(this.bAvailableCnt);
    localStringBuilder.append(",");
    localStringBuilder.append("bTVC");
    localStringBuilder.append(":");
    localStringBuilder.append(this.bTodayVotedCnt);
    localStringBuilder.append(",");
    localStringBuilder.append("bClose");
    localStringBuilder.append(":");
    localStringBuilder.append(this.bCloseNeighborVote);
    localStringBuilder.append(",");
    localStringBuilder.append("strTime");
    localStringBuilder.append(":");
    localStringBuilder.append(this.strTime);
    localStringBuilder.append(",");
    localStringBuilder.append("type");
    localStringBuilder.append(":");
    localStringBuilder.append(this.type);
    localStringBuilder.append(",");
    localStringBuilder.append("bMutual");
    localStringBuilder.append("=");
    localStringBuilder.append(this.bMutualFriends);
    return localStringBuilder.toString();
  }
  
  public void updateTime(long paramLong)
  {
    this.lTime = ((int)paramLong);
    this.strTime = TimeFormatterUtils.a(paramLong * 1000L, true, "yyyy-MM-dd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.CardProfile
 * JD-Core Version:    0.7.0.1
 */