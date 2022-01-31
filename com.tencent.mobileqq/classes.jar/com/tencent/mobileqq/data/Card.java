package com.tencent.mobileqq.data;

import GameCenter.GameLogoUrl;
import GameCenter.RespLastGameInfo;
import QQService.EVIPSPEC;
import QQService.TagInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCard.AlbumInfo;
import SummaryCardTaf.SLabelInfo;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import SummaryCardTaf.cardDiyTextInfo;
import android.os.Parcel;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileColor;
import com.tencent.mobileqq.profile.ProfileGroupLabel;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profile.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import tencent.im.group.group_member_info.InfoCardVideoInfo;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.CardInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.PhotoInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.UinPhotoListInfo;

public class Card
  extends Entity
{
  public static final long BIRTHDAY_INVALID = 0L;
  public static final int CONSTELLATION_INVALID = 0;
  public static final short FEMALE = 1;
  public static final short MALE = 0;
  public static final int PROFESSION_DEFAULT = -1;
  public static final short UNKNOWN_MALE = -1;
  public long addSrcId;
  public String addSrcName;
  public long addSubSrcId;
  public byte age;
  public boolean allowCalInteractive;
  public boolean allowClick;
  public boolean allowPeopleSee;
  public boolean autoPlayMusicPendant;
  public short bAvailVoteCnt;
  public byte[] bCardInfo;
  public byte bFavorited;
  public short bHaveVotedCnt;
  public byte bHollywoodVipOpen;
  public byte bQQVipOpen;
  public byte bQzoneInfo;
  public byte bRead = 2;
  public byte bSingle;
  public byte bSuperQQOpen;
  public byte bSuperVipOpen;
  public byte bVoted;
  public byte bWeiboInfo;
  public boolean babyQSwitch;
  public long backgroundColor;
  public String backgroundUrl = "";
  public byte[] bgType;
  public String bindPhoneInfo;
  public String busiEntry;
  public byte cSqqLevel;
  public int cardType;
  public int constellation = 0;
  public String declaration;
  public String diyDefaultText;
  public String diyText;
  public float diyTextDegree;
  public int diyTextFontId;
  public float diyTextHeight;
  public float diyTextLocX;
  public float diyTextLocY;
  public float diyTextScale = 1.0F;
  public float diyTextTransparency;
  public float diyTextWidth;
  public int dynamicCardFlag;
  public byte eUserIdentityType;
  public String encId;
  public short extendFriendEntryAddFriend;
  public short extendFriendEntryContact;
  public int extendFriendFlag;
  public int extendFriendVoiceDuration;
  public int favoriteSource;
  public long feedPreviewTime;
  public int greenLevel;
  public String hobbyEntry;
  public int iCampusIsSigned;
  public int iFaceNum;
  public int iHollywoodVipLevel;
  public int iHollywoodVipType;
  public int iMedalCount;
  public int iNewCount;
  public int iProfession = -1;
  public int iQQLevel;
  public int iQQVipLevel;
  public int iQQVipType;
  public int iSuperQQLevel;
  public int iSuperQQType;
  public int iSuperVipLevel;
  public int iSuperVipType;
  public int iUpgradeCount;
  public int iVoteIncrement;
  public int iXManScene1DelayTime;
  public int iXManScene2DelayTime;
  public boolean isGreenDiamond;
  public boolean isRedDiamond;
  public boolean isShowCard;
  public boolean isSuperGreenDiamond;
  public boolean isSuperRedDiamond;
  public boolean isSuperYellowDiamond;
  public boolean isYellowDiamond;
  public long lBirthday = 0L;
  public long lCampusCollegeID;
  public long lCampusLastModifySchoolTime;
  public long lCampusSchoolID;
  public long lCardShowNum;
  public long lCurrentBgId = -1L;
  public long lCurrentStyleId = -1L;
  public long lLoginDays;
  public long lQQMasterLogindays;
  public long lSignModifyTime;
  public long lUserFlag;
  public long lVisitCount;
  public long lVoteCount;
  public byte[] labelInfoBytes;
  public byte[] lastPraiseInfoList;
  @notColumn
  public ArrayList lastPraiseInfos;
  public String lightalkId;
  public String lightalkNick;
  public String location;
  @notColumn
  public boolean mHasStory;
  public int mNowShowFlag;
  public String mNowShowIconUrl;
  public String mNowShowJumpUrl;
  @notColumn
  public byte[] mQQStoryData;
  public boolean medalSwitchDisable;
  public int nCampusEnrolYear;
  public int nCampusSchoolFlag;
  public int nCampusStatus;
  public int nFaceID;
  public int nLastGameFlag;
  public int nSameFriendsNum;
  public int nStarFansFlag;
  public int namePlateOfKingDan;
  public boolean namePlateOfKingDanDisplatSwitch;
  public long namePlateOfKingGameId;
  public long namePlateOfKingLoginTime;
  public byte olympicTorch;
  @notColumn
  public PersonalityLabel personalityLabel;
  public int popularity;
  public String privilegeJumpUrl;
  public String privilegePromptStr;
  @notColumn
  public List profileBusiEntry;
  public String pyFaceUrl;
  @notColumn
  public ArrayList qzonePhotoList = new ArrayList();
  public int redLevel;
  @Deprecated
  public short shAge;
  public short shDuration;
  public short shGender = -1;
  public short shType;
  public boolean showLightalk;
  public boolean showOnlineFriends;
  public boolean showRedPointMusicPendant;
  public String starFansJumpUrl;
  public String strActiveUrl = "";
  public String strAutoRemark;
  public String strCampusAcademy;
  public String strCampusClass;
  public String strCampusCollege;
  public String strCampusName;
  public String strCampusSchool;
  public String strCertificationInfo;
  public String strCity;
  public String strCompany;
  public String strCompanySame;
  public String strContactName;
  public String strCountry;
  public String strCurrentBgUrl;
  public String strDrawerCardUrl = "";
  public String strEmail;
  public String strExtInfo;
  public String strGameAppid_1;
  public String strGameAppid_2;
  public String strGameAppid_3;
  public String strGameAppid_4;
  public String strGameLogoKey_1;
  public String strGameLogoKey_2;
  public String strGameLogoKey_3;
  public String strGameLogoKey_4;
  public String strGameLogoUrl_1;
  public String strGameLogoUrl_2;
  public String strGameLogoUrl_3;
  public String strGameLogoUrl_4;
  public String strGameName_1;
  public String strGameName_2;
  public String strGameName_3;
  public String strGameName_4;
  public String strHometownCodes;
  public String strHometownDesc;
  public String strJoinHexAlbumFileKey;
  public String strLastCampusFeeds;
  public String strLocationCodes;
  public String strLocationDesc;
  public String strLoginDaysDesc;
  public String strMobile;
  public String strNick;
  public String strPersonalNote;
  public String strProfileUrl;
  public String strPromptParams;
  public String strProvince;
  public String strQzoneFeedsDesc;
  public String strQzoneHeader;
  public String strReMark;
  public String strRespMusicInfo;
  public String strSchool;
  public String strSchoolSame;
  public String strShowName;
  public String strSign;
  public String strSpaceName;
  public String strStarLogoUrl;
  public String strStarLvUrl_0;
  public String strStarLvUrl_1;
  public String strStarLvUrl_2;
  public String strStarPicUrl_0;
  public String strStarPicUrl_1;
  public String strStarPicUrl_2;
  public String strStatus;
  public String strTroopName;
  public String strTroopNick;
  public String strUrl = "";
  public String strVoiceFilekey;
  public String strVoteLimitedNotice;
  public String strWzryHeroUrl = "";
  public String strZipUrl = "";
  @notColumn
  public List summaryEntrys;
  @notColumn
  public short switch_comic = -1;
  @notColumn
  public short switch_disable_personality_label = -1;
  @notColumn
  public short switch_eat = -1;
  @notColumn
  public short switch_education = -1;
  @notColumn
  public short switch_interest = -1;
  @notColumn
  public short switch_joined_troop = -1;
  @notColumn
  public short switch_ktv = -1;
  @notColumn
  public short switch_music = -1;
  @notColumn
  public short switch_now = -1;
  @notColumn
  public short switch_radio = -1;
  @notColumn
  public short switch_reader = -1;
  @notColumn
  public short switch_recent_activity = -1;
  @notColumn
  public short switch_star = -1;
  @notColumn
  public short switch_using_tim = -1;
  @notColumn
  public short switch_weishi = -1;
  public byte[] tagInfosByte;
  public byte[] tempChatSig;
  public int templateRet;
  public long uAccelerateMultiple;
  public int uFaceTimeStamp;
  @unique
  public String uin;
  public int ulShowControl;
  public long updateTime;
  public byte[] vBackground;
  public byte[] vClosePriv;
  public byte[] vContent;
  public byte[] vCookies;
  public byte[] vCoverInfo;
  public byte[] vOpenPriv;
  public byte[] vPersonalityLabelV2;
  public byte[] vQQFaceID;
  public byte[] vQzoneCoverInfo;
  public byte[] vQzonePhotos;
  public byte[] vRichSign;
  public byte[] vSeed;
  public boolean videoHeadFlag;
  public String videoHeadUrl;
  public boolean visibleMusicPendant;
  public String voiceUrl;
  public byte[] wzryHonorInfo;
  public int yellowLevel;
  
  public void addHeadPortrait(byte[] paramArrayOfByte)
  {
    String str2 = HexUtil.bytes2HexStr(paramArrayOfByte);
    if (noAlbumPics()) {}
    for (String str1 = ""; !noAlbumPics(); str1 = this.strJoinHexAlbumFileKey)
    {
      this.strJoinHexAlbumFileKey = (HexUtil.bytes2HexStr(paramArrayOfByte) + ";" + str1);
      return;
    }
    this.strJoinHexAlbumFileKey = str2;
  }
  
  public void addOrUpdateBuisEntry(ProfileBusiEntry paramProfileBusiEntry)
  {
    int k = 0;
    if (paramProfileBusiEntry == null) {
      return;
    }
    int m = paramProfileBusiEntry.jdField_a_of_type_Int;
    if (this.profileBusiEntry == null) {
      getBusiEntrys();
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.profileBusiEntry.size())
      {
        if (((ProfileBusiEntry)this.profileBusiEntry.get(i)).jdField_a_of_type_Int == m)
        {
          j = 1;
          this.profileBusiEntry.remove(i);
          this.profileBusiEntry.add(paramProfileBusiEntry);
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        this.profileBusiEntry.add(paramProfileBusiEntry);
        return;
      }
      i += 1;
    }
  }
  
  public void addQQStoryList(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if (((group_member_info.InfoCardVideoInfo)paramList.get(i)).cover.has())
      {
        String str = ((group_member_info.InfoCardVideoInfo)paramList.get(i)).cover.get().toStringUtf8();
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
      }
      i += 1;
    }
    if (localArrayList.size() != 0)
    {
      paramList = Parcel.obtain();
      paramList.setDataPosition(0);
      paramList.writeList(localArrayList);
      this.mQQStoryData = paramList.marshall();
      paramList.recycle();
      return;
    }
    this.mQQStoryData = null;
  }
  
  public void addQzonePhotoList(AlbumInfo paramAlbumInfo)
  {
    int i = 0;
    while (i < paramAlbumInfo.vPhotos.size())
    {
      this.qzonePhotoList.add(paramAlbumInfo.vPhotos.get(i));
      i += 1;
    }
    if (this.qzonePhotoList.size() != 0)
    {
      paramAlbumInfo = Parcel.obtain();
      paramAlbumInfo.setDataPosition(0);
      paramAlbumInfo.writeList(this.qzonePhotoList);
      this.vQzonePhotos = paramAlbumInfo.marshall();
      paramAlbumInfo.recycle();
      return;
    }
    this.vQzonePhotos = null;
  }
  
  public void appendPortrait(List paramList)
  {
    if (!noAlbumPics())
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        this.strJoinHexAlbumFileKey = (this.strJoinHexAlbumFileKey + ";" + str);
      }
    }
    this.strJoinHexAlbumFileKey = CardHandler.b(paramList);
  }
  
  public void appendPortrait(byte[] paramArrayOfByte)
  {
    String str2 = HexUtil.bytes2HexStr(paramArrayOfByte);
    if (noAlbumPics()) {}
    for (String str1 = ""; !noAlbumPics(); str1 = this.strJoinHexAlbumFileKey)
    {
      this.strJoinHexAlbumFileKey = (str1 + ";" + HexUtil.bytes2HexStr(paramArrayOfByte));
      return;
    }
    this.strJoinHexAlbumFileKey = str2;
  }
  
  public boolean checkCoverUrl(byte[] paramArrayOfByte)
  {
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo = new cmd0x703.UinPhotoListInfo();
    try
    {
      localUinPhotoListInfo.mergeFrom(paramArrayOfByte);
      return true;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SummaryCard", 2, "checkCoverUrl " + paramArrayOfByte.toString());
      }
    }
    return false;
  }
  
  public ArrayList getBgTypeArray()
  {
    if (this.bgType != null) {
      try
      {
        ArrayList localArrayList = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.bgType)).readObject();
        return localArrayList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
  }
  
  public List getBigOrderEntrys()
  {
    if (this.summaryEntrys == null)
    {
      this.summaryEntrys = new ArrayList();
      if (TextUtils.isEmpty(this.hobbyEntry)) {}
    }
    for (;;)
    {
      int i;
      JSONObject localJSONObject1;
      ProfileSummaryHobbiesEntry localProfileSummaryHobbiesEntry;
      Object localObject1;
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.hobbyEntry);
        i = 0;
        if (i < localJSONArray1.length())
        {
          localJSONObject1 = localJSONArray1.getJSONObject(i);
          if (localJSONObject1 == null) {
            break label1151;
          }
          localProfileSummaryHobbiesEntry = new ProfileSummaryHobbiesEntry();
          Iterator localIterator1 = localJSONObject1.keys();
          if (!localIterator1.hasNext()) {
            break label1139;
          }
          localObject1 = (String)localIterator1.next();
          if (((String)localObject1).equals("strName"))
          {
            localProfileSummaryHobbiesEntry.jdField_a_of_type_JavaLangString = localJSONObject1.getString((String)localObject1);
            continue;
          }
        }
        else
        {
          return this.summaryEntrys;
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        }
      }
      if (((String)localObject1).equals("serviceType"))
      {
        localProfileSummaryHobbiesEntry.jdField_a_of_type_Int = localJSONObject1.getInt((String)localObject1);
      }
      else if (((String)localObject1).equals("strServiceUrl"))
      {
        localProfileSummaryHobbiesEntry.jdField_b_of_type_JavaLangString = localJSONObject1.getString((String)localObject1);
      }
      else if (((String)localObject1).equals("strServiceType"))
      {
        localProfileSummaryHobbiesEntry.c = localJSONObject1.getString((String)localObject1);
      }
      else if (((String)localObject1).equals("sProfileSummaryHobbiesItem"))
      {
        localObject1 = localJSONObject1.getString((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JSONArray((String)localObject1);
          ArrayList localArrayList = new ArrayList();
          int j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            JSONObject localJSONObject2 = ((JSONArray)localObject1).getJSONObject(j);
            Iterator localIterator2 = localJSONObject2.keys();
            ProfileSummaryHobbiesItem localProfileSummaryHobbiesItem = new ProfileSummaryHobbiesItem();
            while (localIterator2.hasNext())
            {
              Object localObject2 = (String)localIterator2.next();
              if (((String)localObject2).equals("strTitle"))
              {
                localProfileSummaryHobbiesItem.jdField_a_of_type_JavaLangString = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("strCoverUrl"))
              {
                localProfileSummaryHobbiesItem.jdField_b_of_type_JavaLangString = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("strSubInfo"))
              {
                localProfileSummaryHobbiesItem.d = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("strDesc"))
              {
                localProfileSummaryHobbiesItem.e = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("serviceType"))
              {
                localProfileSummaryHobbiesItem.jdField_a_of_type_Int = localJSONObject2.getInt((String)localObject2);
              }
              else if (((String)localObject2).equals("service"))
              {
                localProfileSummaryHobbiesItem.jdField_b_of_type_Int = localJSONObject2.getInt((String)localObject2);
              }
              else if (((String)localObject2).equals("strTitleIconUrl"))
              {
                localProfileSummaryHobbiesItem.f = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("strJmpUrl"))
              {
                localProfileSummaryHobbiesItem.c = localJSONObject2.getString((String)localObject2);
              }
              else if (((String)localObject2).equals("uint64_group_code"))
              {
                localProfileSummaryHobbiesItem.jdField_a_of_type_Long = localJSONObject2.getLong((String)localObject2);
              }
              else if ((((String)localObject2).equals("labels")) && (!TextUtils.isEmpty(localJSONObject2.getString((String)localObject2))))
              {
                localObject2 = new ArrayList();
                JSONArray localJSONArray2 = new JSONArray(localJSONObject2.getString("labels"));
                int k = 0;
                while (k < localJSONArray2.length())
                {
                  JSONObject localJSONObject3 = localJSONArray2.getJSONObject(k);
                  ProfileGroupLabel localProfileGroupLabel = new ProfileGroupLabel();
                  Iterator localIterator3 = localJSONObject3.keys();
                  while (localIterator3.hasNext())
                  {
                    Object localObject3 = (String)localIterator3.next();
                    if (((String)localObject3).equals("strWording"))
                    {
                      localProfileGroupLabel.jdField_a_of_type_JavaLangString = localJSONObject3.getString((String)localObject3);
                    }
                    else if (((String)localObject3).equals("attr"))
                    {
                      localProfileGroupLabel.jdField_b_of_type_Long = localJSONObject3.getLong((String)localObject3);
                    }
                    else if (((String)localObject3).equals("type"))
                    {
                      localProfileGroupLabel.jdField_a_of_type_Long = localJSONObject3.getLong((String)localObject3);
                    }
                    else
                    {
                      ProfileColor localProfileColor;
                      Iterator localIterator4;
                      String str;
                      if (((String)localObject3).equals("text_color"))
                      {
                        localObject3 = localJSONObject3.getString((String)localObject3);
                        if (!TextUtils.isEmpty((CharSequence)localObject3))
                        {
                          localObject3 = new JSONObject((String)localObject3);
                          localProfileColor = new ProfileColor();
                          localIterator4 = ((JSONObject)localObject3).keys();
                          while (localIterator4.hasNext())
                          {
                            str = (String)localIterator4.next();
                            if (str.equals("R")) {
                              localProfileColor.jdField_a_of_type_Long = ((JSONObject)localObject3).getLong(str);
                            } else if (str.equals("G")) {
                              localProfileColor.jdField_b_of_type_Long = ((JSONObject)localObject3).getLong(str);
                            } else if (str.equals("B")) {
                              localProfileColor.c = ((JSONObject)localObject3).getLong(str);
                            }
                          }
                          localProfileGroupLabel.jdField_a_of_type_ComTencentMobileqqProfileProfileColor = localProfileColor;
                        }
                      }
                      else if (((String)localObject3).equals("edging_color"))
                      {
                        localObject3 = localJSONObject3.getString((String)localObject3);
                        if (!TextUtils.isEmpty((CharSequence)localObject3))
                        {
                          localObject3 = new JSONObject((String)localObject3);
                          localProfileColor = new ProfileColor();
                          localIterator4 = ((JSONObject)localObject3).keys();
                          while (localIterator4.hasNext())
                          {
                            str = (String)localIterator4.next();
                            if (str.equals("R")) {
                              localProfileColor.jdField_a_of_type_Long = ((JSONObject)localObject3).getLong(str);
                            } else if (str.equals("G")) {
                              localProfileColor.jdField_b_of_type_Long = ((JSONObject)localObject3).getLong(str);
                            } else if (str.equals("B")) {
                              localProfileColor.c = ((JSONObject)localObject3).getLong(str);
                            }
                          }
                          localProfileGroupLabel.jdField_b_of_type_ComTencentMobileqqProfileProfileColor = localProfileColor;
                        }
                      }
                    }
                  }
                  ((ArrayList)localObject2).add(localProfileGroupLabel);
                  k += 1;
                }
                localProfileSummaryHobbiesItem.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
              }
            }
            localArrayList.add(localProfileSummaryHobbiesItem);
            j += 1;
          }
          localProfileSummaryHobbiesEntry.jdField_a_of_type_JavaUtilArrayList = localArrayList;
          continue;
          label1139:
          this.summaryEntrys.add(localProfileSummaryHobbiesEntry);
          label1151:
          i += 1;
        }
      }
    }
  }
  
  public List getBusiEntrys()
  {
    if (this.profileBusiEntry == null)
    {
      this.profileBusiEntry = new ArrayList();
      if (TextUtils.isEmpty(this.busiEntry)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.busiEntry);
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label178;
          }
          ProfileBusiEntry localProfileBusiEntry = new ProfileBusiEntry();
          localProfileBusiEntry.jdField_a_of_type_Int = localJSONObject.getInt("nBusiEntryType");
          localProfileBusiEntry.jdField_a_of_type_JavaLangString = localJSONObject.getString("strLogoUrl");
          localProfileBusiEntry.jdField_b_of_type_JavaLangString = localJSONObject.getString("strTitle");
          localProfileBusiEntry.c = localJSONObject.getString("strContent");
          localProfileBusiEntry.d = localJSONObject.getString("strJumpUrl");
          if (localProfileBusiEntry.a()) {
            break label178;
          }
          this.profileBusiEntry.add(localProfileBusiEntry);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        }
      }
      return this.profileBusiEntry;
      label178:
      i += 1;
    }
  }
  
  public BusinessCard getCardInfo()
  {
    Oidb_0x43c.CardInfo localCardInfo = new Oidb_0x43c.CardInfo();
    BusinessCard localBusinessCard = new BusinessCard();
    if (this.bCardInfo != null) {}
    try
    {
      localCardInfo.mergeFrom(this.bCardInfo);
      BusinessCardServlet.a(localBusinessCard, localCardInfo);
      return localBusinessCard;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SummaryCard", 2, "getCardInfo " + localInvalidProtocolBufferMicroException.toString());
      }
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    return localBusinessCard;
  }
  
  public Object[] getCoverData(int paramInt)
  {
    Object localObject3 = null;
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo;
    if (this.vCoverInfo != null) {
      localUinPhotoListInfo = new cmd0x703.UinPhotoListInfo();
    }
    for (;;)
    {
      try
      {
        localUinPhotoListInfo.mergeFrom(this.vCoverInfo);
        if ((localUinPhotoListInfo != null) && (localUinPhotoListInfo.rpt_msg_photo_info.get() != null))
        {
          Object localObject4 = localUinPhotoListInfo.rpt_msg_photo_info.get();
          Object localObject1 = localUinPhotoListInfo.rpt_selected_id_list.get();
          if (QLog.isColorLevel()) {
            QLog.d("SummaryCard", 2, "getCoverData infoList:" + ((List)localObject4).size());
          }
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            i = ((Integer)((List)localObject1).get(0)).intValue();
            j = 0;
            if (j >= ((List)localObject4).size()) {
              continue;
            }
            localObject3 = (cmd0x703.PhotoInfo)((List)localObject4).get(j);
            if ((((cmd0x703.PhotoInfo)localObject3).uint32_id.get() != i) || (paramInt >= ((cmd0x703.PhotoInfo)localObject3).uint32_timestamp.get())) {
              continue;
            }
            localObject1 = ((cmd0x703.PhotoInfo)localObject3).str_url.get();
            j = ((cmd0x703.PhotoInfo)localObject3).uint32_timestamp.get();
            if ((!localUinPhotoListInfo.str_default_photo.has()) || (TextUtils.isEmpty(localUinPhotoListInfo.str_default_photo.get()))) {
              continue;
            }
            localObject1 = localUinPhotoListInfo.str_default_photo.get();
            m = i;
            k = j;
            localObject3 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              m = i;
              k = j;
              localObject3 = localObject1;
              if (((List)localObject4).size() > 0)
              {
                localObject4 = (cmd0x703.PhotoInfo)((List)localObject4).get(((List)localObject4).size() - 1);
                m = i;
                k = j;
                localObject3 = localObject1;
                if (paramInt < ((cmd0x703.PhotoInfo)localObject4).uint32_timestamp.get())
                {
                  localObject3 = ((cmd0x703.PhotoInfo)localObject4).str_url.get();
                  k = ((cmd0x703.PhotoInfo)localObject4).uint32_timestamp.get();
                  m = i;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("SummaryCard", 2, "getCoverData selectedId:" + m + " retTime:" + k + " retUrl:" + (String)localObject3);
            }
            return new Object[] { localObject3, Integer.valueOf(k) };
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SummaryCard", 2, "getCoverData " + localInvalidProtocolBufferMicroException.toString());
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SummaryCard", 2, "getCoverData idList is empty!");
        }
        int i = -1;
        continue;
        j += 1;
        continue;
        continue;
        int j = 0;
        Object localObject2 = null;
        continue;
      }
      int m = -1;
      int k = 0;
    }
  }
  
  public String getHeadFileHexKey()
  {
    String str = null;
    LinkedList localLinkedList = CardHandler.a(this.strJoinHexAlbumFileKey);
    if (localLinkedList.size() > 0) {
      str = (String)localLinkedList.get(0);
    }
    return str;
  }
  
  public List getLabelList()
  {
    Object localObject2 = null;
    if (this.labelInfoBytes != null) {}
    for (;;)
    {
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.labelInfoBytes);
        ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
        localObject1 = (ArrayList)localObjectInputStream.readObject();
        localObject2.printStackTrace();
      }
      catch (Exception localException2)
      {
        try
        {
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          if (localObject1 == null) {
            break label76;
          }
          return localObject1;
        }
        catch (Exception localException1)
        {
          break label69;
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
      label69:
      continue;
      label76:
      return new ArrayList();
      Object localObject1 = null;
    }
  }
  
  public ArrayList getLastPraiseInfoList()
  {
    if (this.lastPraiseInfos != null) {
      return this.lastPraiseInfos;
    }
    if (this.lastPraiseInfoList != null) {
      try
      {
        this.lastPraiseInfos = ((ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.lastPraiseInfoList)).readObject());
        ArrayList localArrayList = this.lastPraiseInfos;
        return localArrayList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
  }
  
  public int getLocalPicKeysCount()
  {
    if ((this.strJoinHexAlbumFileKey == null) || (this.strJoinHexAlbumFileKey.length() == 0)) {
      return 0;
    }
    return CardHandler.a(this.strJoinHexAlbumFileKey).size();
  }
  
  public PersonalityLabel getPersonalityLabel()
  {
    if ((this.personalityLabel == null) && (this.vPersonalityLabelV2 != null))
    {
      this.personalityLabel = PersonalityLabel.convertFromBytes(this.vPersonalityLabelV2);
      if (this.personalityLabel == null) {
        this.vPersonalityLabelV2 = null;
      }
    }
    return this.personalityLabel;
  }
  
  public int getPicCountInAlbum()
  {
    return this.iFaceNum;
  }
  
  public List getPrivilegeCloseInfo()
  {
    Object localObject2 = null;
    if (this.vClosePriv != null) {}
    for (;;)
    {
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(this.vClosePriv);
        ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
        localObject1 = (ArrayList)localObjectInputStream.readObject();
        localObject2.printStackTrace();
      }
      catch (Exception localException2)
      {
        try
        {
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          localByteArrayInputStream.close();
          localObjectInputStream.close();
          if (localObject1 == null) {
            break label76;
          }
          return localObject1;
        }
        catch (Exception localException1)
        {
          break label69;
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
      label69:
      continue;
      label76:
      return new ArrayList();
      Object localObject1 = null;
    }
  }
  
  /* Error */
  public List getPrivilegeOpenInfo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 821	com/tencent/mobileqq/data/Card:vOpenPriv	[B
    //   6: ifnull +171 -> 177
    //   9: new 516	java/io/ObjectInputStream
    //   12: dup
    //   13: new 518	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: getfield 821	com/tencent/mobileqq/data/Card:vOpenPriv	[B
    //   21: invokespecial 520	java/io/ByteArrayInputStream:<init>	([B)V
    //   24: invokespecial 523	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 526	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   34: checkcast 337	java/util/ArrayList
    //   37: astore_3
    //   38: aload_3
    //   39: astore_1
    //   40: aload_2
    //   41: ifnull +9 -> 50
    //   44: aload_2
    //   45: invokevirtual 791	java/io/ObjectInputStream:close	()V
    //   48: aload_3
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +102 -> 153
    //   54: aload_1
    //   55: areturn
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   61: aload_3
    //   62: astore_1
    //   63: goto -13 -> 50
    //   66: astore_3
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_2
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   75: aload_2
    //   76: ifnull +101 -> 177
    //   79: aload_2
    //   80: invokevirtual 791	java/io/ObjectInputStream:close	()V
    //   83: aconst_null
    //   84: astore_1
    //   85: goto -35 -> 50
    //   88: astore_1
    //   89: aload_1
    //   90: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   93: aconst_null
    //   94: astore_1
    //   95: goto -45 -> 50
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 822	java/lang/OutOfMemoryError:printStackTrace	()V
    //   107: aload_2
    //   108: ifnull +69 -> 177
    //   111: aload_2
    //   112: invokevirtual 791	java/io/ObjectInputStream:close	()V
    //   115: aconst_null
    //   116: astore_1
    //   117: goto -67 -> 50
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   125: aconst_null
    //   126: astore_1
    //   127: goto -77 -> 50
    //   130: astore_3
    //   131: aload_1
    //   132: astore_2
    //   133: aload_3
    //   134: astore_1
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 791	java/io/ObjectInputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_2
    //   146: aload_2
    //   147: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   150: goto -7 -> 143
    //   153: new 337	java/util/ArrayList
    //   156: dup
    //   157: invokespecial 338	java/util/ArrayList:<init>	()V
    //   160: areturn
    //   161: astore_3
    //   162: aload_1
    //   163: astore_2
    //   164: aload_3
    //   165: astore_1
    //   166: goto -31 -> 135
    //   169: astore_3
    //   170: goto -69 -> 101
    //   173: astore_3
    //   174: goto -105 -> 69
    //   177: aconst_null
    //   178: astore_1
    //   179: goto -129 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	Card
    //   1	54	1	localObject1	Object
    //   56	2	1	localException1	Exception
    //   62	23	1	localObject2	Object
    //   88	2	1	localException2	Exception
    //   94	23	1	localObject3	Object
    //   120	2	1	localException3	Exception
    //   126	53	1	localObject4	Object
    //   27	113	2	localObject5	Object
    //   145	2	2	localException4	Exception
    //   163	1	2	localObject6	Object
    //   37	25	3	localArrayList	ArrayList
    //   66	6	3	localException5	Exception
    //   98	6	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   130	4	3	localObject7	Object
    //   161	4	3	localObject8	Object
    //   169	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   173	1	3	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   44	48	56	java/lang/Exception
    //   9	28	66	java/lang/Exception
    //   79	83	88	java/lang/Exception
    //   9	28	98	java/lang/OutOfMemoryError
    //   111	115	120	java/lang/Exception
    //   9	28	130	finally
    //   139	143	145	java/lang/Exception
    //   30	38	161	finally
    //   71	75	161	finally
    //   103	107	161	finally
    //   30	38	169	java/lang/OutOfMemoryError
    //   30	38	173	java/lang/Exception
  }
  
  public String getProfileCardDesc()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->templateRet=" + this.templateRet);
    localStringBuilder.append(",styleId=" + this.lCurrentStyleId);
    localStringBuilder.append(",backgroundId=" + this.lCurrentBgId);
    localStringBuilder.append(",backgroundUrl=" + this.backgroundUrl);
    localStringBuilder.append(",backgroundColor=" + this.backgroundColor);
    localStringBuilder.append(",ActiveUrl= " + this.strActiveUrl);
    return localStringBuilder.toString();
  }
  
  public List getQQStoryList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = localArrayList;
    Object localObject2;
    Object localObject3;
    if (this.mQQStoryData != null)
    {
      localObject2 = localArrayList;
      localObject3 = localArrayList;
    }
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject2 = localArrayList;
      localObject3 = localArrayList;
      localParcel.unmarshall(this.mQQStoryData, 0, this.mQQStoryData.length);
      localObject2 = localArrayList;
      localObject3 = localArrayList;
      localParcel.setDataPosition(0);
      localObject2 = localArrayList;
      localObject3 = localArrayList;
      localObject1 = localParcel.readArrayList(getClass().getClassLoader());
      localObject2 = localObject1;
      localObject3 = localObject1;
      localParcel.recycle();
    }
    catch (Exception localException)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.i("SummaryCard, getQQStoryList:", 2, localException.toString());
      return localObject2;
    }
    catch (Error localError)
    {
      do
      {
        localObject1 = localException;
      } while (!QLog.isColorLevel());
      QLog.i("SummaryCard, getQQStoryList:", 2, localError.toString());
    }
    return localObject1;
    return localException;
  }
  
  public List getQZonePhotoList()
  {
    if ((this.qzonePhotoList.size() == 0) && (this.vQzonePhotos != null)) {}
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(this.vQzonePhotos, 0, this.vQzonePhotos.length);
      localParcel.setDataPosition(0);
      this.qzonePhotoList = localParcel.readArrayList(getClass().getClassLoader());
      localParcel.recycle();
      return this.qzonePhotoList;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, localException.toString());
        }
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, localError.toString());
        }
      }
    }
  }
  
  public RichStatus getRichStatus()
  {
    if ((this.vRichSign == null) || (this.vRichSign.length == 0))
    {
      if ((this.lSignModifyTime <= 0L) && (!TextUtils.isEmpty(this.strSign)))
      {
        localRichStatus = new RichStatus(this.strSign);
        localRichStatus.time = this.lSignModifyTime;
        return localRichStatus;
      }
      return null;
    }
    RichStatus localRichStatus = RichStatus.parseStatus(this.vRichSign);
    localRichStatus.time = this.lSignModifyTime;
    return localRichStatus;
  }
  
  public String getStrJoinHexAlbumFileKey()
  {
    return this.strJoinHexAlbumFileKey;
  }
  
  public ArrayList getTagInfoArray()
  {
    if (this.tagInfosByte != null) {
      try
      {
        ArrayList localArrayList3 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.tagInfosByte)).readObject();
        if (localArrayList3 != null)
        {
          int i = 0;
          for (;;)
          {
            ArrayList localArrayList1 = localArrayList3;
            if (i >= localArrayList3.size()) {
              break;
            }
            ((TagInfo)localArrayList3.get(i)).iTagId = new BigInteger(Long.toString(((TagInfo)localArrayList3.get(i)).iTagId)).longValue();
            i += 1;
          }
        }
        localArrayList2 = new ArrayList();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    ArrayList localArrayList2;
    return localArrayList2;
  }
  
  public int getVipLevel(EVIPSPEC paramEVIPSPEC)
  {
    int i = -1;
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      i = this.iQQVipLevel;
    }
    do
    {
      return i;
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERQQ) {
        return this.iSuperQQLevel;
      }
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) {
        return this.iSuperVipLevel;
      }
    } while (paramEVIPSPEC != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD);
    return this.iHollywoodVipLevel;
  }
  
  public int getVipType(EVIPSPEC paramEVIPSPEC)
  {
    int i = -1;
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      i = this.iQQVipType;
    }
    do
    {
      return i;
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERQQ) {
        return this.iSuperQQType;
      }
      if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) {
        return this.iSuperVipType;
      }
    } while (paramEVIPSPEC != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD);
    return this.iHollywoodVipType;
  }
  
  public ArrayList getWzryHonorInfo()
  {
    if (this.wzryHonorInfo != null) {
      try
      {
        ArrayList localArrayList = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.wzryHonorInfo)).readObject();
        return localArrayList;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
  }
  
  public boolean hasCardInfo()
  {
    return this.bCardInfo != null;
  }
  
  public boolean hasGotPhotoUrl()
  {
    return this.vQzonePhotos != null;
  }
  
  public boolean isOpenRecentPlayingGamesByNative()
  {
    return (this.nLastGameFlag & 0x2) == 2;
  }
  
  public boolean isPhotoUseCache()
  {
    return (this.ulShowControl & 0x20) != 0;
  }
  
  public boolean isShowFeeds()
  {
    return (this.ulShowControl & 0x4) != 0;
  }
  
  public boolean isShowPhoto()
  {
    return (this.ulShowControl & 0x10) != 0;
  }
  
  public boolean isShowQStarFans()
  {
    return true;
  }
  
  public boolean isShowRecentPlayingGames()
  {
    return (this.nLastGameFlag & 0x1) == 1;
  }
  
  public boolean isShowVoice()
  {
    return (this.ulShowControl & 0x8) != 0;
  }
  
  public boolean isShowXMan()
  {
    return (this.ulShowControl & 0x10) != 0;
  }
  
  public boolean isShowZan()
  {
    return (this.ulShowControl & 0x1) != 0;
  }
  
  public boolean isVipOpen(EVIPSPEC paramEVIPSPEC)
  {
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      if (this.bQQVipOpen != 1) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (paramEVIPSPEC != EVIPSPEC.E_SP_SUPERQQ) {
            break;
          }
        } while (this.bSuperQQOpen == 1);
        return false;
        if (paramEVIPSPEC != EVIPSPEC.E_SP_SUPERVIP) {
          break;
        }
      } while (this.bSuperVipOpen == 1);
      return false;
      if (paramEVIPSPEC != EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD) {
        break;
      }
    } while (this.bHollywoodVipOpen == 1);
    return false;
    return false;
  }
  
  public boolean noAlbumPics()
  {
    return getPicCountInAlbum() == 0;
  }
  
  public void removeBuisEntry(ProfileBusiEntry paramProfileBusiEntry)
  {
    if (paramProfileBusiEntry == null) {}
    for (;;)
    {
      return;
      int j = paramProfileBusiEntry.jdField_a_of_type_Int;
      if (this.profileBusiEntry == null) {
        getBusiEntrys();
      }
      int i = 0;
      while (i < this.profileBusiEntry.size())
      {
        if (((ProfileBusiEntry)this.profileBusiEntry.get(i)).jdField_a_of_type_Int == j)
        {
          this.profileBusiEntry.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void removePortrait(byte[] paramArrayOfByte)
  {
    LinkedList localLinkedList = CardHandler.a(this.strJoinHexAlbumFileKey);
    if (localLinkedList.remove(HexUtil.bytes2HexStr(paramArrayOfByte)))
    {
      this.iFaceNum -= 1;
      this.strJoinHexAlbumFileKey = CardHandler.b(localLinkedList);
    }
  }
  
  public void saveBigOrderEntrys(List paramList)
  {
    JSONStringer localJSONStringer1 = new JSONStringer();
    this.hobbyEntry = "";
    JSONStringer localJSONStringer2;
    label139:
    JSONStringer localJSONStringer3;
    try
    {
      localJSONStringer1.array();
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        Object localObject1 = (ProfileSummaryHobbiesEntry)localIterator.next();
        localJSONStringer1.object().key("strName").value(((ProfileSummaryHobbiesEntry)localObject1).jdField_a_of_type_JavaLangString).key("strServiceUrl").value(((ProfileSummaryHobbiesEntry)localObject1).jdField_b_of_type_JavaLangString).key("strServiceType").value(((ProfileSummaryHobbiesEntry)localObject1).c).key("serviceType").value(((ProfileSummaryHobbiesEntry)localObject1).jdField_a_of_type_Int);
        if (((ProfileSummaryHobbiesEntry)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
        {
          localJSONStringer2 = new JSONStringer().array();
          localObject1 = ((ProfileSummaryHobbiesEntry)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (ProfileSummaryHobbiesItem)((Iterator)localObject1).next();
            localJSONStringer2.object().key("strTitle").value(((ProfileSummaryHobbiesItem)localObject2).jdField_a_of_type_JavaLangString).key("strCoverUrl").value(((ProfileSummaryHobbiesItem)localObject2).jdField_b_of_type_JavaLangString).key("strJmpUrl").value(((ProfileSummaryHobbiesItem)localObject2).c).key("strSubInfo").value(((ProfileSummaryHobbiesItem)localObject2).d).key("strDesc").value(((ProfileSummaryHobbiesItem)localObject2).e).key("serviceType").value(((ProfileSummaryHobbiesItem)localObject2).jdField_a_of_type_Int).key("service").value(((ProfileSummaryHobbiesItem)localObject2).jdField_b_of_type_Int).key("strTitleIconUrl").value(((ProfileSummaryHobbiesItem)localObject2).f).key("uint64_group_code").value(((ProfileSummaryHobbiesItem)localObject2).jdField_a_of_type_Long);
            if (((ProfileSummaryHobbiesItem)localObject2).jdField_a_of_type_JavaUtilArrayList != null)
            {
              localJSONStringer3 = new JSONStringer().array();
              localObject2 = ((ProfileSummaryHobbiesItem)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  ProfileGroupLabel localProfileGroupLabel = (ProfileGroupLabel)((Iterator)localObject2).next();
                  JSONStringer localJSONStringer4 = new JSONStringer().object();
                  localJSONStringer4.key("R").value(localProfileGroupLabel.jdField_a_of_type_ComTencentMobileqqProfileProfileColor.jdField_a_of_type_Long).key("G").value(localProfileGroupLabel.jdField_a_of_type_ComTencentMobileqqProfileProfileColor.jdField_b_of_type_Long).key("B").value(localProfileGroupLabel.jdField_a_of_type_ComTencentMobileqqProfileProfileColor.c);
                  localJSONStringer4.endObject();
                  JSONStringer localJSONStringer5 = new JSONStringer().object();
                  localJSONStringer5.key("R").value(localProfileGroupLabel.jdField_b_of_type_ComTencentMobileqqProfileProfileColor.jdField_a_of_type_Long).key("G").value(localProfileGroupLabel.jdField_b_of_type_ComTencentMobileqqProfileProfileColor.jdField_b_of_type_Long).key("B").value(localProfileGroupLabel.jdField_b_of_type_ComTencentMobileqqProfileProfileColor.c);
                  localJSONStringer5.endObject();
                  localJSONStringer3.object().key("strWording").value(localProfileGroupLabel.jdField_a_of_type_JavaLangString).key("type").value(localProfileGroupLabel.jdField_a_of_type_Long).key("attr").value(localProfileGroupLabel.jdField_b_of_type_Long).key("text_color").value(localJSONStringer4).key("edging_color").value(localJSONStringer5).endObject();
                  continue;
                  if (this.summaryEntrys == null) {
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      this.hobbyEntry = "";
      localJSONException.printStackTrace();
    }
    for (;;)
    {
      this.summaryEntrys.clear();
      if ((paramList != null) && (paramList.size() > 0)) {
        this.summaryEntrys.addAll(paramList);
      }
      return;
      localJSONStringer3.endArray();
      localJSONStringer2.key("labels").value(localJSONStringer3);
      localJSONStringer2.endObject();
      break label139;
      localJSONStringer2.endArray();
      localJSONException.key("sProfileSummaryHobbiesItem").value(localJSONStringer2);
      localJSONException.endObject();
      break;
      localJSONException.endArray();
      this.hobbyEntry = localJSONException.toString();
    }
  }
  
  public void saveBusiEntrys(List paramList)
  {
    JSONStringer localJSONStringer = new JSONStringer();
    int i;
    if (paramList == null)
    {
      i = 0;
      if (i <= 0) {
        break label210;
      }
    }
    for (;;)
    {
      try
      {
        localJSONStringer.array();
        int j = 0;
        if (j < i)
        {
          ProfileBusiEntry localProfileBusiEntry = (ProfileBusiEntry)paramList.get(j);
          if ((localProfileBusiEntry != null) && (!localProfileBusiEntry.a())) {
            localJSONStringer.object().key("nBusiEntryType").value(localProfileBusiEntry.jdField_a_of_type_Int).key("strLogoUrl").value(localProfileBusiEntry.jdField_a_of_type_JavaLangString).key("strTitle").value(localProfileBusiEntry.jdField_b_of_type_JavaLangString).key("strContent").value(localProfileBusiEntry.c).key("strJumpUrl").value(localProfileBusiEntry.d).endObject();
          }
          j += 1;
          continue;
          i = paramList.size();
          break;
        }
        localJSONStringer.endArray();
        this.busiEntry = localJSONStringer.toString();
      }
      catch (JSONException localJSONException)
      {
        label210:
        this.busiEntry = "";
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
        continue;
      }
      if (this.profileBusiEntry != null)
      {
        this.profileBusiEntry.clear();
        if ((paramList != null) && (paramList.size() > 0)) {
          this.profileBusiEntry.addAll(paramList);
        }
      }
      return;
      this.busiEntry = "";
    }
  }
  
  public void saveCardInfo(BusinessCard paramBusinessCard)
  {
    if (paramBusinessCard == null) {
      return;
    }
    Oidb_0x43c.CardInfo localCardInfo = new Oidb_0x43c.CardInfo();
    localCardInfo.card_id.set(ByteStringMicro.copyFromUtf8(paramBusinessCard.cardId));
    if (!TextUtils.isEmpty(paramBusinessCard.picUrl)) {
      localCardInfo.pic_url.set(paramBusinessCard.picUrl);
    }
    if (!TextUtils.isEmpty(paramBusinessCard.cardName)) {
      localCardInfo.name.set(paramBusinessCard.cardName);
    }
    if (!TextUtils.isEmpty(paramBusinessCard.company)) {
      localCardInfo.company.set(paramBusinessCard.company);
    }
    Object localObject = paramBusinessCard.qqNum.iterator();
    String str;
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      localCardInfo.uins.add(Long.valueOf(Long.parseLong(str)));
    }
    localObject = paramBusinessCard.mobilesNum.iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      localCardInfo.mobiles.add(str);
    }
    paramBusinessCard = paramBusinessCard.descs.iterator();
    while (paramBusinessCard.hasNext())
    {
      localObject = (String)paramBusinessCard.next();
      localCardInfo.descs.add(localObject);
    }
    this.bCardInfo = localCardInfo.toByteArray();
  }
  
  public void savePrivilegeClosedInfo(List paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramList);
      this.vClosePriv = localByteArrayOutputStream.toByteArray();
      localObjectOutputStream.flush();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      return;
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void savePrivilegeOpenedInfo(List paramList)
  {
    if (paramList == null) {
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramList);
      this.vOpenPriv = localByteArrayOutputStream.toByteArray();
      localObjectOutputStream.flush();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      localObjectOutputStream.close();
      return;
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public byte[] setBgType(Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      this.bgType = localByteArrayOutputStream.toByteArray();
      paramObject = this.bgType;
      return paramObject;
    }
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public void setFeedsShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x4;
      return;
    }
    this.ulShowControl &= 0xFFFFFFFB;
  }
  
  public void setLabelList(Map paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject2 = (Map.Entry)paramMap.next();
        localObject1 = (Long)((Map.Entry)localObject2).getKey();
        localObject2 = (SLabelInfo)((Map.Entry)localObject2).getValue();
        localArrayList.add(new ProfileLabelInfo((Long)localObject1, Long.valueOf(((SLabelInfo)localObject2).likeit), ((SLabelInfo)localObject2).name));
      }
    }
    try
    {
      paramMap = new ByteArrayOutputStream();
      localObject1 = new ObjectOutputStream(paramMap);
      ((ObjectOutputStream)localObject1).writeObject(localArrayList);
      this.labelInfoBytes = paramMap.toByteArray();
      ((ObjectOutputStream)localObject1).flush();
      paramMap.close();
      ((ObjectOutputStream)localObject1).close();
      paramMap.close();
      ((ObjectOutputStream)localObject1).close();
      return;
    }
    catch (IOException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public void setLastPraiseInfoList(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {}
    try
    {
      this.lastPraiseInfos = paramArrayList;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramArrayList);
      localObjectOutputStream.flush();
      this.lastPraiseInfoList = localByteArrayOutputStream.toByteArray();
      return;
    }
    catch (IOException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  public void setPhotoShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x10;
      return;
    }
    this.ulShowControl &= 0xFFFFFFEF;
  }
  
  public void setPhotoUseCacheFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x20;
      return;
    }
    this.ulShowControl &= 0xFFFFFFDF;
  }
  
  public void setStrJoinHexAlbumFileKey(String paramString)
  {
    this.strJoinHexAlbumFileKey = paramString;
    if ((paramString == null) || ("".equals(paramString))) {
      this.strJoinHexAlbumFileKey = ";";
    }
  }
  
  public byte[] setTagInfosByte(Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      this.tagInfosByte = localByteArrayOutputStream.toByteArray();
      paramObject = this.tagInfosByte;
      return paramObject;
    }
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public void setVipInfo(VipBaseInfo paramVipBaseInfo)
  {
    byte b2 = 1;
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label318;
        }
        b1 = 1;
        this.bQQVipOpen = b1;
        this.iQQVipType = localVipOpenInfo.iVipType;
        this.iQQVipLevel = localVipOpenInfo.iVipLevel;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(2));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label323;
        }
        b1 = 1;
        label102:
        this.bSuperQQOpen = b1;
        this.iSuperQQType = localVipOpenInfo.iVipType;
        this.iSuperQQLevel = localVipOpenInfo.iVipLevel;
      }
      localVipOpenInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
      if (localVipOpenInfo != null)
      {
        if (!localVipOpenInfo.bOpen) {
          break label328;
        }
        b1 = 1;
        label158:
        this.bSuperVipOpen = b1;
        this.iSuperVipType = localVipOpenInfo.iVipType;
        this.iSuperVipLevel = localVipOpenInfo.iVipLevel;
      }
      if (QLog.isColorLevel()) {
        QLog.d("card", 2, "setVipInfo bSuperVipOpen=" + this.bSuperVipOpen + ",bQQVipOpen=" + this.bQQVipOpen + ",VipLevel=" + this.iQQVipLevel + "card = " + this + ",uin = " + this.uin);
      }
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(4));
      if (paramVipBaseInfo != null) {
        if (!paramVipBaseInfo.bOpen) {
          break label333;
        }
      }
    }
    label318:
    label323:
    label328:
    label333:
    for (byte b1 = b2;; b1 = 0)
    {
      this.bHollywoodVipOpen = b1;
      this.iHollywoodVipType = paramVipBaseInfo.iVipType;
      this.iHollywoodVipLevel = paramVipBaseInfo.iVipLevel;
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label102;
      b1 = 0;
      break label158;
    }
  }
  
  public void setVoiceShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x8;
      return;
    }
    this.ulShowControl &= 0xFFFFFFF7;
  }
  
  public byte[] setWzryHonorInfo(Object paramObject)
  {
    if (paramObject == null) {
      this.wzryHonorInfo = new byte[0];
    }
    for (;;)
    {
      return null;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
        localObjectOutputStream.writeObject(paramObject);
        localObjectOutputStream.flush();
        this.wzryHonorInfo = localByteArrayOutputStream.toByteArray();
        paramObject = this.wzryHonorInfo;
        return paramObject;
      }
      catch (IOException paramObject)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public void setXManFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x10;
      return;
    }
    this.ulShowControl &= 0xFFFFFFEF;
  }
  
  public void setZanShowFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x1;
      return;
    }
    this.ulShowControl &= 0xFFFFFFFE;
  }
  
  public boolean shouldShowJoinedTroop()
  {
    return (this.ulShowControl & 0x40) == 0;
  }
  
  public void updateCardTemplate(QQAppInterface paramQQAppInterface, String paramString, SSummaryCardRsp paramSSummaryCardRsp)
  {
    HashMap localHashMap = new HashMap();
    if (paramSSummaryCardRsp != null)
    {
      if (paramSSummaryCardRsp.res < 0)
      {
        QLog.e("SummaryCard", 1, "getSummaryCard template res < 0");
        VasMonitorHandler.a(paramQQAppInterface, "individual_v2_personalcard_get_fail", "" + paramSSummaryCardRsp.res, "personalcard get template = null", null, 0.0F);
        return;
      }
      this.templateRet = paramSSummaryCardRsp.res;
      this.lCurrentStyleId = paramSSummaryCardRsp.styleid;
      this.backgroundUrl = paramSSummaryCardRsp.bgurl;
      this.lCurrentBgId = paramSSummaryCardRsp.bgid;
      this.backgroundColor = paramSSummaryCardRsp.color;
      this.dynamicCardFlag = paramSSummaryCardRsp.dynamicCardFlag;
      this.strZipUrl = paramSSummaryCardRsp.strZipUrl;
      this.strActiveUrl = paramSSummaryCardRsp.strActiveCardUrl;
      this.strDrawerCardUrl = paramSSummaryCardRsp.strDrawerCard;
      this.strWzryHeroUrl = paramSSummaryCardRsp.strWzryHeroUrl;
      this.strExtInfo = paramSSummaryCardRsp.extInfo;
      this.cardType = paramSSummaryCardRsp.cardType;
      this.diyDefaultText = paramSSummaryCardRsp.strDiyDefaultText;
      Object localObject = paramSSummaryCardRsp.bgtype;
      if (localObject != null) {
        setBgType(localObject);
      }
      if ((paramSSummaryCardRsp.label != null) && (paramSSummaryCardRsp.label.label != null)) {
        setLabelList(paramSSummaryCardRsp.label.label);
      }
      setWzryHonorInfo(paramSSummaryCardRsp.wzryInfo);
      if (paramSSummaryCardRsp.stDiyText != null)
      {
        this.diyTextFontId = paramSSummaryCardRsp.stDiyText.iFontId;
        this.diyText = paramSSummaryCardRsp.stDiyText.strText;
        this.diyTextScale = paramSSummaryCardRsp.stDiyText.fScaling;
        this.diyTextDegree = paramSSummaryCardRsp.stDiyText.fRotationAngle;
        this.diyTextTransparency = paramSSummaryCardRsp.stDiyText.fTransparency;
        if (!TextUtils.isEmpty(paramSSummaryCardRsp.stDiyText.strPoint))
        {
          localObject = paramSSummaryCardRsp.stDiyText.strPoint.split("_");
          if (localObject.length < 4) {}
        }
      }
      try
      {
        this.diyTextLocX = Float.parseFloat(localObject[0]);
        this.diyTextLocY = Float.parseFloat(localObject[1]);
        this.diyTextWidth = Float.parseFloat(localObject[2]);
        this.diyTextHeight = Float.parseFloat(localObject[3]);
        localHashMap.put("param_FailCode", "0");
        localHashMap.put("param_templateRet", String.valueOf(paramSSummaryCardRsp.res));
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, "updateCardTemplate templateInfo-->" + getProfileCardDesc());
        }
        StatisticCollector.a(paramQQAppInterface.getApp()).a(paramString, "profileCardGet", true, 0L, 0L, localHashMap, "", false);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Card", 1, "set card with diy text response:", localException);
        }
      }
    }
    QLog.i("SummaryCard", 1, "updateCardTemplate templateInfo is null");
    VasMonitorHandler.a(paramQQAppInterface, "individual_v2_personalcard_get_fail", "personalcard_get_template_null", "personalcard get template = null", null, 0.0F);
    localHashMap.put("param_FailCode", "-101");
    localHashMap.put("param_templateRet", "0");
    StatisticCollector.a(paramQQAppInterface.getApp()).a(paramString, "profileCardGet", false, 0L, 0L, localHashMap, "", false);
  }
  
  public void updateLastGameInfo(RespLastGameInfo paramRespLastGameInfo)
  {
    int k = 0;
    if ((paramRespLastGameInfo == null) || (paramRespLastGameInfo.iResult != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SummaryCard", 2, "handleGetSummaryCard|updateLastGameInfo|info = null or info.iResult = 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bShowGameLogo = " + paramRespLastGameInfo.bShowGameLogo);
    }
    if (paramRespLastGameInfo.bShowGameLogo)
    {
      this.nLastGameFlag |= 0x1;
      if (paramRespLastGameInfo.bNative) {
        this.nLastGameFlag |= 0x2;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bNative = " + paramRespLastGameInfo.bNative);
        }
        this.strProfileUrl = paramRespLastGameInfo.sProfileUrl;
        if (QLog.isColorLevel()) {
          QLog.i("SummaryCard", 2, "updateLastGameInfo|info.stGameLogoInfo = " + paramRespLastGameInfo.stGameLogoInfo);
        }
        int i;
        label196:
        int j;
        label271:
        GameLogoUrl localGameLogoUrl;
        label294:
        String str1;
        String str2;
        String str3;
        String str4;
        if (paramRespLastGameInfo.stGameLogoInfo != null)
        {
          i = paramRespLastGameInfo.stGameLogoInfo.size();
          if (QLog.isColorLevel()) {
            QLog.i("SummaryCard", 2, "updateLastGameInfo|size = " + i);
          }
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.i("SummaryCard", 2, "updateLastGameInfo|info.sLogoUrl = " + paramRespLastGameInfo.sLogoUrl);
            j = k;
          }
          if (j >= 4) {
            break;
          }
          if (j >= i) {
            break label526;
          }
          localGameLogoUrl = (GameLogoUrl)paramRespLastGameInfo.stGameLogoInfo.get(j);
          k = j + 1;
          str1 = "strGameLogoUrl_" + String.valueOf(k);
          str2 = "strGameLogoKey_" + String.valueOf(k);
          str3 = "strGameName_" + String.valueOf(k);
          str4 = "strGameAppid_" + String.valueOf(k);
          if (localGameLogoUrl == null) {
            break label532;
          }
        }
        try
        {
          getClass().getField(str1).set(this, paramRespLastGameInfo.sLogoUrl + localGameLogoUrl.sLogoName);
          getClass().getField(str2).set(this, localGameLogoUrl.sLogoMd5);
          getClass().getField(str3).set(this, localGameLogoUrl.sGameName);
          getClass().getField(str4).set(this, localGameLogoUrl.sAppid);
          for (;;)
          {
            j += 1;
            break label271;
            this.nLastGameFlag &= 0xFFFFFFFD;
            break;
            i = 0;
            break label196;
            label526:
            localGameLogoUrl = null;
            break label294;
            label532:
            if (QLog.isColorLevel()) {
              QLog.i("SummaryCard", 2, "updateLastGameInfo index" + j + "logo is null reset game info");
            }
            getClass().getField(str1).set(this, "");
            getClass().getField(str2).set(this, "");
            getClass().getField(str3).set(this, "");
            getClass().getField(str4).set(this, "");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SummaryCard", 2, "updateLastGameInfo get logo index=" + j + " exception");
            }
            localException.printStackTrace();
          }
        }
      }
    }
    this.nLastGameFlag &= 0xFFFFFFFE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.Card
 * JD-Core Version:    0.7.0.1
 */