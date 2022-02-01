package com.tencent.mobileqq.data.troop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TroopMemberCard
  implements Serializable
{
  public static final long MEMBER_DISTANCE_DEFAULT = -1L;
  public static final long MEMBER_DISTANCE_UNKOWN = -1000L;
  private static final long serialVersionUID = 1L;
  public int age;
  public String card;
  public String colorCard;
  public int colorCardId;
  public int credit;
  public List<TroopMemberCard.CustomEntry> customEntryList;
  public long distance = -1L;
  public int gbarCount;
  public String gbarLinkUrl;
  public List<TroopMemberCard.GBarInfo> gbarList;
  public String gbarTitle;
  public String honorList;
  public byte honorRichTag;
  public boolean isAllowModCard;
  public boolean isConcerned;
  public boolean isFriend;
  public boolean isSuperQQ;
  public boolean isSuperVip;
  public boolean isVip;
  public boolean isYearVip;
  public long joinTime;
  public long lastSpeak;
  public String levelName;
  public String location;
  public ArrayList<String> mCurrAccountOrgIds = new ArrayList();
  public int mGroupType;
  public boolean mHasStory = false;
  public boolean mIsShield;
  public TroopMemberCard.MemberGameInfo mMemberGameInfo;
  public ArrayList<String> mOrgIds = new ArrayList();
  public String mPosition;
  public ArrayList<TroopMemberCard.StoryInfo> mStoryInfoList;
  public String mUniqueTitle;
  public int mUniqueTitleExpire;
  public int memberRole;
  public long memberUin;
  public int newRealLevel;
  public String nick;
  public String phoneNumber;
  public int realLevel;
  public String remark;
  public int result;
  public int sex;
  public int titleId;
  public int vipLevel = 26;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopMemberCard
 * JD-Core Version:    0.7.0.1
 */