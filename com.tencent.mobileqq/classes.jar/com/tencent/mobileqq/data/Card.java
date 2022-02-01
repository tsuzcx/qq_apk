package com.tencent.mobileqq.data;

import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import QQService.VipBaseInfo;
import SummaryCard.AlbumInfo;
import SummaryCard.PhotoInfo;
import SummaryCard.TPraiseInfo;
import SummaryCardTaf.SLabelInfo;
import SummaryCardTaf.summaryCardWzryInfo;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileColor;
import com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesItem;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import tencent.im.oidb.cmd0x703.cmd0x703.PhotoInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.UinPhotoListInfo;

public class Card
  extends Entity
{
  public static final long BIRTHDAY_INVALID = 0L;
  public static final int CONSTELLATION_INVALID = 0;
  public static final short FEMALE = 1;
  public static final int INVALID_STATE = -1;
  public static final short MALE = 0;
  public static final int PROFESSION_DEFAULT = -1;
  private static final String TAG = "Card";
  public static final short UNKNOWN_MALE = -1;
  public long addSrcId;
  public String addSrcName;
  public long addSubSrcId;
  public byte age;
  public boolean allowCalInteractive;
  public boolean allowClick;
  public boolean allowPeopleSee;
  public long authState;
  public short bAvailVoteCnt = -1;
  public byte bBigClubVipOpen;
  public byte[] bCardInfo;
  public short bHaveVotedCnt = 0;
  public byte bHollywoodVipOpen;
  public byte bQQVipOpen;
  public byte bSuperQQOpen;
  public byte bSuperVipOpen;
  public byte bVoted;
  public boolean babyQSwitch;
  public long backgroundColor = 0L;
  public String backgroundUrl = "";
  public byte[] bgType;
  public String bindPhoneInfo;
  private Map<Class<? extends IProfileBusinessInfo>, IProfileBusinessInfo> businessInfoMap;
  public long cardId;
  public int cardType;
  public int category;
  public int clothesId;
  public int constellation = 0;
  @notColumn
  public String coverUrl;
  public String declaration;
  public int defaultCardId;
  public String diyComplicatedInfo;
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
  public int dynamicCardFlag = 0;
  public String encId;
  public int enlargeQzonePic;
  public short extendFriendEntryAddFriend;
  public short extendFriendEntryContact;
  public int extendFriendFlag;
  public short extendFriendQuestion;
  public int extendFriendVoiceDuration;
  public int favoriteSource;
  public long feedPreviewTime;
  public int fontId;
  public int fontType;
  public int gameCardId = 0;
  public int grayNameplateFlag = 0;
  public int greenLevel = 0;
  public boolean hasFakeData = false;
  public String hobbyEntry;
  public int iBigClubVipLevel;
  public int iBigClubVipType;
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
  public int idx;
  public boolean isGreenDiamond = false;
  public boolean isHidePrettyGroutIdentity;
  public boolean isPrettyGroupOwner;
  public boolean isRedDiamond = false;
  public boolean isShowCard;
  public boolean isSuperGreenDiamond = false;
  public boolean isSuperRedDiamond = false;
  public boolean isSuperYellowDiamond = false;
  public boolean isYellowDiamond = false;
  public long lBigClubTemplateId;
  public long lBirthday = 0L;
  public long lCurrentBgId = -1L;
  public long lCurrentStyleId = -1L;
  public long lLoginDays;
  public long lQQMasterLogindays;
  public long lSignModifyTime;
  public long lSuperVipTemplateId;
  public long lUserFlag;
  public long lVisitCount;
  public long lVoteCount;
  public byte[] labelInfoBytes;
  public byte[] lastPraiseInfoList;
  @notColumn
  public ArrayList<TPraiseInfo> lastPraiseInfos;
  public int lhLevel = -1;
  @notColumn
  public cmd0x703.UinPhotoListInfo mPhotoListInfo = null;
  public int mQQLevelType;
  public boolean medalSwitchDisable = false;
  public int nFaceID;
  public int namePlateOfKingDan;
  public boolean namePlateOfKingDanDisplatSwitch;
  public long namePlateOfKingGameId;
  public long namePlateOfKingLoginTime;
  public int nameplateExtId = 0;
  public int nameplateVipType = 0;
  @notColumn
  public int newSchoolStatusFlagForGuide = 1;
  public int popularity;
  public String presentCustourl;
  public String presentDesc;
  public boolean presentSwitch;
  public List<String> presentUrl;
  public String privilegeJumpUrl;
  public String privilegePromptStr;
  @notColumn
  public SparseArray<Integer> profileDisplaySettingStates = new SparseArray(0);
  public String qid;
  public String qidBgUrl;
  public String qidColor;
  public String qidLogoUrl;
  @notColumn
  public final List<PhotoInfo> qzonePhotoList = new CopyOnWriteArrayList();
  public int redLevel = 0;
  public String schoolId;
  public String schoolName;
  public boolean schoolVerifiedFlag;
  public short shGender = -1;
  public boolean showPresent = false;
  public boolean showPublishButton;
  @notColumn
  public String singer;
  @notColumn
  public long songDuration;
  @notColumn
  public String songId;
  @notColumn
  public String songName;
  public String strActiveUrl = "";
  public String strAutoRemark;
  public String strCity;
  public String strCompany;
  public String strContactName;
  public String strCountry;
  public String strCurrentBgUrl;
  public String strDrawerCardUrl = "";
  public String strEmail;
  public String strExtInfo;
  public String strHometownCity;
  public String strHometownCodes;
  public String strHometownCountry;
  public String strHometownDesc;
  public String strHometownProvince;
  public String strLocationCodes;
  public String strLocationDesc;
  public String strLoginDaysDesc;
  public String strMobile;
  public String strNick;
  public String strPersonalNote;
  public String strPromptParams;
  public String strProvince;
  public String strQzoneFeedsDesc;
  public String strQzoneHeader;
  public String strReMark;
  public String strSchool;
  public String strShowName;
  public String strSign;
  public String strSpaceName;
  public String strStatus;
  public String strVoteLimitedNotice;
  public String strWzryHeroUrl = "";
  public String strZipUrl = "";
  public boolean strangerInviteMeGroupOpen = true;
  public boolean strangerVoteOpen;
  @notColumn
  public List<ProfileSummaryHobbiesEntry> summaryEntrys;
  @notColumn
  public short switchLifeAchievement = -1;
  @notColumn
  public short switchMusicBox = -1;
  @notColumn
  public short switchQQCircle = -1;
  @notColumn
  public short switchStickyNote = -1;
  @notColumn
  public short switchWeiShi = -1;
  public byte[] tempChatSig;
  public int templateRet = 0;
  public boolean troopHonorSwitch = true;
  public long uCurMulType;
  public int uFaceTimeStamp;
  @unique
  public String uin;
  public int ulShowControl;
  public long updateTime;
  public byte[] vClosePriv;
  public byte[] vCookies;
  public byte[] vCoverInfo;
  public byte[] vLongNickTopicInfo;
  public byte[] vOpenPriv;
  public byte[] vQQFaceID;
  public byte[] vQzoneCoverInfo;
  public byte[] vQzonePhotos;
  public byte[] vRichSign;
  public byte[] vSeed;
  public String voiceUrl;
  public byte[] wzryHonorInfo;
  public int yellowLevel = 0;
  
  private void parseLabelList(ArrayList<ProfileGroupLabel> paramArrayList, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      ProfileGroupLabel localProfileGroupLabel = new ProfileGroupLabel();
      Iterator localIterator1 = localJSONObject.keys();
      while (localIterator1.hasNext())
      {
        Object localObject = (String)localIterator1.next();
        if (((String)localObject).equals("strWording"))
        {
          localProfileGroupLabel.strWording = localJSONObject.getString((String)localObject);
        }
        else if (((String)localObject).equals("attr"))
        {
          localProfileGroupLabel.attr = localJSONObject.getLong((String)localObject);
        }
        else if (((String)localObject).equals("type"))
        {
          localProfileGroupLabel.type = localJSONObject.getLong((String)localObject);
        }
        else
        {
          ProfileColor localProfileColor;
          Iterator localIterator2;
          String str;
          if (((String)localObject).equals("text_color"))
          {
            localObject = localJSONObject.getString((String)localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localObject = new JSONObject((String)localObject);
              localProfileColor = new ProfileColor();
              localIterator2 = ((JSONObject)localObject).keys();
              while (localIterator2.hasNext())
              {
                str = (String)localIterator2.next();
                if (str.equals("R")) {
                  localProfileColor.red = ((JSONObject)localObject).getLong(str);
                } else if (str.equals("G")) {
                  localProfileColor.green = ((JSONObject)localObject).getLong(str);
                } else if (str.equals("B")) {
                  localProfileColor.blue = ((JSONObject)localObject).getLong(str);
                }
              }
              localProfileGroupLabel.textColor = localProfileColor;
            }
          }
          else if (((String)localObject).equals("edging_color"))
          {
            localObject = localJSONObject.getString((String)localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localObject = new JSONObject((String)localObject);
              localProfileColor = new ProfileColor();
              localIterator2 = ((JSONObject)localObject).keys();
              while (localIterator2.hasNext())
              {
                str = (String)localIterator2.next();
                if (str.equals("R")) {
                  localProfileColor.red = ((JSONObject)localObject).getLong(str);
                } else if (str.equals("G")) {
                  localProfileColor.green = ((JSONObject)localObject).getLong(str);
                } else if (str.equals("B")) {
                  localProfileColor.blue = ((JSONObject)localObject).getLong(str);
                }
              }
              localProfileGroupLabel.edgingColor = localProfileColor;
            }
          }
        }
      }
      paramArrayList.add(localProfileGroupLabel);
      i += 1;
    }
  }
  
  private void parseProfileSummaryHbItem(JSONObject paramJSONObject, Iterator<String> paramIterator, ProfileSummaryHobbiesItem paramProfileSummaryHobbiesItem)
  {
    while (paramIterator.hasNext())
    {
      Object localObject = (String)paramIterator.next();
      if (((String)localObject).equals("strTitle"))
      {
        paramProfileSummaryHobbiesItem.strTitle = paramJSONObject.getString((String)localObject);
      }
      else if (((String)localObject).equals("strCoverUrl"))
      {
        paramProfileSummaryHobbiesItem.strCoverUrl = paramJSONObject.getString((String)localObject);
      }
      else if (((String)localObject).equals("strSubInfo"))
      {
        paramProfileSummaryHobbiesItem.strSubInfo = paramJSONObject.getString((String)localObject);
      }
      else if (((String)localObject).equals("strDesc"))
      {
        paramProfileSummaryHobbiesItem.strDesc = paramJSONObject.getString((String)localObject);
      }
      else if (((String)localObject).equals("serviceType"))
      {
        paramProfileSummaryHobbiesItem.serviceType = paramJSONObject.getInt((String)localObject);
      }
      else if (((String)localObject).equals("service"))
      {
        paramProfileSummaryHobbiesItem.service = paramJSONObject.getInt((String)localObject);
      }
      else if (((String)localObject).equals("strTitleIconUrl"))
      {
        paramProfileSummaryHobbiesItem.strTitleIconUrl = paramJSONObject.getString((String)localObject);
      }
      else if (((String)localObject).equals("strJmpUrl"))
      {
        paramProfileSummaryHobbiesItem.strJmpUrl = paramJSONObject.getString((String)localObject);
      }
      else if (((String)localObject).equals("uint64_group_code"))
      {
        paramProfileSummaryHobbiesItem.groupCode = paramJSONObject.getLong((String)localObject);
      }
      else if ((((String)localObject).equals("labels")) && (!TextUtils.isEmpty(paramJSONObject.getString((String)localObject))))
      {
        localObject = new ArrayList();
        parseLabelList((ArrayList)localObject, new JSONArray(paramJSONObject.getString("labels")));
        paramProfileSummaryHobbiesItem.labels = ((ArrayList)localObject);
      }
    }
  }
  
  public void addQZonePhotoList(AlbumInfo paramAlbumInfo)
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
    if (!this.hasFakeData) {
      this.vQzonePhotos = null;
    }
  }
  
  public void addQZonePhotoList(ArrayList<String> paramArrayList, List<Boolean> paramList)
  {
    int i = 0;
    while ((i < paramArrayList.size()) && (i < 3))
    {
      PhotoInfo localPhotoInfo = new PhotoInfo();
      localPhotoInfo.strPicUrl = ((String)paramArrayList.get(i));
      localPhotoInfo.mapEx = new HashMap();
      Map localMap = localPhotoInfo.mapEx;
      String str;
      if (((Boolean)paramList.get(i)).booleanValue()) {
        str = "1";
      } else {
        str = "0";
      }
      localMap.put("isVideo", str);
      this.qzonePhotoList.add(i, localPhotoInfo);
      i += 1;
    }
    if (this.qzonePhotoList.size() != 0)
    {
      paramArrayList = Parcel.obtain();
      paramArrayList.setDataPosition(0);
      paramArrayList.writeList(this.qzonePhotoList);
      this.vQzonePhotos = paramArrayList.marshall();
      paramArrayList.recycle();
      return;
    }
    if (!this.hasFakeData) {
      this.vQzonePhotos = null;
    }
  }
  
  public boolean checkCoverUrl(byte[] paramArrayOfByte)
  {
    Object localObject = new cmd0x703.UinPhotoListInfo();
    try
    {
      ((cmd0x703.UinPhotoListInfo)localObject).mergeFrom(paramArrayOfByte);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkCoverUrl ");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        QLog.d("SummaryCard", 2, ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public ArrayList<Integer> getBgTypeArray()
  {
    Object localObject = this.bgType;
    if (localObject != null) {
      try
      {
        localObject = (ArrayList)new ObjectInputStream(new ByteArrayInputStream((byte[])localObject)).readObject();
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
  }
  
  public List<ProfileSummaryHobbiesEntry> getBigOrderEntrys()
  {
    if (this.summaryEntrys == null)
    {
      this.summaryEntrys = new ArrayList();
      if (!TextUtils.isEmpty(this.hobbyEntry)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(this.hobbyEntry);
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject1 = localJSONArray.getJSONObject(i);
            if (localJSONObject1 != null)
            {
              ProfileSummaryHobbiesEntry localProfileSummaryHobbiesEntry = new ProfileSummaryHobbiesEntry();
              Iterator localIterator1 = localJSONObject1.keys();
              while (localIterator1.hasNext())
              {
                Object localObject = (String)localIterator1.next();
                if (((String)localObject).equals("strName"))
                {
                  localProfileSummaryHobbiesEntry.strName = localJSONObject1.getString((String)localObject);
                }
                else if (((String)localObject).equals("serviceType"))
                {
                  localProfileSummaryHobbiesEntry.serviceType = localJSONObject1.getInt((String)localObject);
                }
                else if (((String)localObject).equals("strServiceUrl"))
                {
                  localProfileSummaryHobbiesEntry.strServiceUrl = localJSONObject1.getString((String)localObject);
                }
                else if (((String)localObject).equals("strServiceType"))
                {
                  localProfileSummaryHobbiesEntry.strServiceType = localJSONObject1.getString((String)localObject);
                }
                else if (((String)localObject).equals("sProfileSummaryHobbiesItem"))
                {
                  localObject = localJSONObject1.getString((String)localObject);
                  if (!TextUtils.isEmpty((CharSequence)localObject))
                  {
                    localObject = new JSONArray((String)localObject);
                    ArrayList localArrayList = new ArrayList();
                    int j = 0;
                    while (j < ((JSONArray)localObject).length())
                    {
                      JSONObject localJSONObject2 = ((JSONArray)localObject).getJSONObject(j);
                      Iterator localIterator2 = localJSONObject2.keys();
                      ProfileSummaryHobbiesItem localProfileSummaryHobbiesItem = new ProfileSummaryHobbiesItem();
                      parseProfileSummaryHbItem(localJSONObject2, localIterator2, localProfileSummaryHobbiesItem);
                      localArrayList.add(localProfileSummaryHobbiesItem);
                      j += 1;
                    }
                    localProfileSummaryHobbiesEntry.sProfileSummaryHobbiesItem = localArrayList;
                  }
                }
              }
              this.summaryEntrys.add(localProfileSummaryHobbiesEntry);
            }
            i += 1;
          }
          return this.summaryEntrys;
        }
        catch (JSONException localJSONException)
        {
          QLog.e("Card", 2, localJSONException.toString());
        }
      }
    }
  }
  
  public <T extends IProfileBusinessInfo> T getBusinessInfo(Class<? extends IProfileBusinessInfo> paramClass)
  {
    Map localMap = this.businessInfoMap;
    if (localMap != null) {
      paramClass = (IProfileBusinessInfo)localMap.get(paramClass);
    } else {
      paramClass = null;
    }
    if (paramClass != null) {
      return paramClass;
    }
    return null;
  }
  
  public Object[] getCoverData(int paramInt)
  {
    Object localObject1 = this.mPhotoListInfo;
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = localObject1;
      if (this.vCoverInfo != null)
      {
        localObject1 = new cmd0x703.UinPhotoListInfo();
        try
        {
          ((cmd0x703.UinPhotoListInfo)localObject1).mergeFrom(this.vCoverInfo);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getCoverData ");
            ((StringBuilder)localObject3).append(localException.toString());
            QLog.d("SummaryCard", 2, ((StringBuilder)localObject3).toString());
          }
        }
        this.mPhotoListInfo = ((cmd0x703.UinPhotoListInfo)localObject1);
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.d("SummaryCard", 2, String.format("getCoverData uin: %s, cover_flag[%s,%s]", new Object[] { this.uin, Boolean.valueOf(((cmd0x703.UinPhotoListInfo)localObject1).cover_flag.has()), Integer.valueOf(((cmd0x703.UinPhotoListInfo)localObject1).cover_flag.get()) }));
          localObject3 = localObject1;
        }
      }
    }
    localObject1 = null;
    Object localObject2 = null;
    int j = -1;
    int i;
    if ((localObject3 != null) && (((cmd0x703.UinPhotoListInfo)localObject3).rpt_msg_photo_info.get() != null))
    {
      List localList = ((cmd0x703.UinPhotoListInfo)localObject3).rpt_msg_photo_info.get();
      localObject1 = ((cmd0x703.UinPhotoListInfo)localObject3).rpt_selected_id_list.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCoverData infoList:");
        localStringBuilder.append(localList.size());
        QLog.d("SummaryCard", 2, localStringBuilder.toString());
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = (Integer)((List)localObject1).get(0);
        i = j;
        if (localObject1 != null) {
          i = ((Integer)localObject1).intValue();
        }
      }
      else
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("SummaryCard", 2, "getCoverData idList is empty!");
          i = j;
        }
      }
      j = 0;
      while (j < localList.size())
      {
        localObject1 = (cmd0x703.PhotoInfo)localList.get(j);
        int k = ((cmd0x703.PhotoInfo)localObject1).uint32_timestamp.get();
        if ((((cmd0x703.PhotoInfo)localObject1).uint32_id.get() == i) && ((paramInt < k) || (k == 0)))
        {
          localObject2 = ((cmd0x703.PhotoInfo)localObject1).str_url.get();
          j = ((cmd0x703.PhotoInfo)localObject1).uint32_timestamp.get();
          break label416;
        }
        j += 1;
      }
      j = 0;
      label416:
      localObject1 = localObject2;
      if (((cmd0x703.UinPhotoListInfo)localObject3).str_default_photo.has())
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(((cmd0x703.UinPhotoListInfo)localObject3).str_default_photo.get())) {
          localObject1 = ((cmd0x703.UinPhotoListInfo)localObject3).str_default_photo.get();
        }
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localList.size() > 0))
      {
        localObject2 = (cmd0x703.PhotoInfo)localList.get(localList.size() - 1);
        if (paramInt < ((cmd0x703.PhotoInfo)localObject2).uint32_timestamp.get())
        {
          localObject1 = ((cmd0x703.PhotoInfo)localObject2).str_url.get();
          paramInt = ((cmd0x703.PhotoInfo)localObject2).uint32_timestamp.get();
          break label541;
        }
      }
      paramInt = j;
    }
    else
    {
      paramInt = 0;
      i = j;
    }
    label541:
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCoverData selectedId:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" retTime:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" retUrl:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("SummaryCard", 2, ((StringBuilder)localObject2).toString());
    }
    return new Object[] { localObject1, Integer.valueOf(paramInt) };
  }
  
  public List<ProfileLabelInfo> getLabelList()
  {
    Object localObject3 = this.labelInfoBytes;
    Object localObject1 = null;
    Object localObject2 = null;
    if (localObject3 != null) {
      try
      {
        localObject3 = new ByteArrayInputStream((byte[])localObject3);
        ObjectInputStream localObjectInputStream = new ObjectInputStream((InputStream)localObject3);
        localObject1 = (ArrayList)localObjectInputStream.readObject();
        try
        {
          ((ByteArrayInputStream)localObject3).close();
          localObjectInputStream.close();
          ((ByteArrayInputStream)localObject3).close();
          localObjectInputStream.close();
        }
        catch (Exception localException1) {}
        Exception localException2;
        localException2.printStackTrace();
      }
      catch (Exception localException3)
      {
        localObject1 = localException1;
        localException2 = localException3;
      }
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return new ArrayList();
  }
  
  public ArrayList<TPraiseInfo> getLastPraiseInfoList()
  {
    Object localObject = this.lastPraiseInfos;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.lastPraiseInfoList;
    if (localObject != null) {
      try
      {
        this.lastPraiseInfos = ((ArrayList)new ObjectInputStream(new ByteArrayInputStream((byte[])localObject)).readObject());
        localObject = this.lastPraiseInfos;
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
  }
  
  public List<PrivilegeInfo> getPrivilegeCloseInfo()
  {
    Object localObject3 = this.vClosePriv;
    Object localObject1 = null;
    Object localObject2 = null;
    if (localObject3 != null) {
      try
      {
        localObject3 = new ByteArrayInputStream((byte[])localObject3);
        ObjectInputStream localObjectInputStream = new ObjectInputStream((InputStream)localObject3);
        localObject1 = (ArrayList)localObjectInputStream.readObject();
        try
        {
          ((ByteArrayInputStream)localObject3).close();
          localObjectInputStream.close();
          ((ByteArrayInputStream)localObject3).close();
          localObjectInputStream.close();
        }
        catch (Exception localException1) {}
        Exception localException2;
        localException2.printStackTrace();
      }
      catch (Exception localException3)
      {
        localObject1 = localException1;
        localException2 = localException3;
      }
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return new ArrayList();
  }
  
  /* Error */
  public List<PrivilegeInfo> getPrivilegeOpenInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 790	com/tencent/mobileqq/data/Card:vOpenPriv	[B
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: aload 4
    //   12: astore_1
    //   13: aload_2
    //   14: ifnull +144 -> 158
    //   17: new 619	java/io/ObjectInputStream
    //   20: dup
    //   21: new 621	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 624	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: invokespecial 627	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 630	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   39: checkcast 443	java/util/ArrayList
    //   42: astore_3
    //   43: aload_2
    //   44: invokevirtual 774	java/io/ObjectInputStream:close	()V
    //   47: goto +8 -> 55
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 633	java/lang/Exception:printStackTrace	()V
    //   55: aload_3
    //   56: astore_1
    //   57: goto +101 -> 158
    //   60: astore_3
    //   61: goto +14 -> 75
    //   64: astore_3
    //   65: goto +36 -> 101
    //   68: astore_1
    //   69: goto +71 -> 140
    //   72: astore_3
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: astore_1
    //   77: aload_3
    //   78: invokevirtual 791	java/lang/OutOfMemoryError:printStackTrace	()V
    //   81: aload 4
    //   83: astore_1
    //   84: aload_2
    //   85: ifnull +73 -> 158
    //   88: aload_2
    //   89: invokevirtual 774	java/io/ObjectInputStream:close	()V
    //   92: aload 4
    //   94: astore_1
    //   95: goto +63 -> 158
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 633	java/lang/Exception:printStackTrace	()V
    //   107: aload 4
    //   109: astore_1
    //   110: aload_2
    //   111: ifnull +47 -> 158
    //   114: aload_2
    //   115: invokevirtual 774	java/io/ObjectInputStream:close	()V
    //   118: aload 4
    //   120: astore_1
    //   121: goto +37 -> 158
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 633	java/lang/Exception:printStackTrace	()V
    //   129: aload 4
    //   131: astore_1
    //   132: goto +26 -> 158
    //   135: astore_2
    //   136: aload_1
    //   137: astore_3
    //   138: aload_2
    //   139: astore_1
    //   140: aload_3
    //   141: ifnull +15 -> 156
    //   144: aload_3
    //   145: invokevirtual 774	java/io/ObjectInputStream:close	()V
    //   148: goto +8 -> 156
    //   151: astore_2
    //   152: aload_2
    //   153: invokevirtual 633	java/lang/Exception:printStackTrace	()V
    //   156: aload_1
    //   157: athrow
    //   158: aload_1
    //   159: ifnull +5 -> 164
    //   162: aload_1
    //   163: areturn
    //   164: new 443	java/util/ArrayList
    //   167: dup
    //   168: invokespecial 496	java/util/ArrayList:<init>	()V
    //   171: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	Card
    //   12	23	1	localObject1	Object
    //   50	2	1	localException1	Exception
    //   56	1	1	localArrayList1	ArrayList
    //   68	1	1	localObject2	Object
    //   76	45	1	localObject3	Object
    //   124	2	1	localException2	Exception
    //   131	32	1	localObject4	Object
    //   4	111	2	localObject5	Object
    //   135	4	2	localObject6	Object
    //   151	2	2	localException3	Exception
    //   9	47	3	localArrayList2	ArrayList
    //   60	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   64	1	3	localException4	Exception
    //   72	6	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   98	6	3	localException5	Exception
    //   137	8	3	localObject7	Object
    //   6	124	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   43	47	50	java/lang/Exception
    //   35	43	60	java/lang/OutOfMemoryError
    //   35	43	64	java/lang/Exception
    //   17	33	68	finally
    //   17	33	72	java/lang/OutOfMemoryError
    //   17	33	98	java/lang/Exception
    //   88	92	124	java/lang/Exception
    //   114	118	124	java/lang/Exception
    //   35	43	135	finally
    //   77	81	135	finally
    //   103	107	135	finally
    //   144	148	151	java/lang/Exception
  }
  
  public String getProfileCardDesc()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("-->templateRet=");
    localStringBuilder2.append(this.templateRet);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",styleId=");
    localStringBuilder2.append(this.lCurrentStyleId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",backgroundId=");
    localStringBuilder2.append(this.lCurrentBgId);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",backgroundUrl=");
    localStringBuilder2.append(this.backgroundUrl);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",backgroundColor=");
    localStringBuilder2.append(this.backgroundColor);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",ActiveUrl= ");
    localStringBuilder2.append(this.strActiveUrl);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
  
  public List<PhotoInfo> getQZonePhotoList()
  {
    if ((this.qzonePhotoList.size() == 0) && (this.vQzonePhotos != null)) {
      try
      {
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(this.vQzonePhotos, 0, this.vQzonePhotos.length);
        localParcel.setDataPosition(0);
        this.qzonePhotoList.addAll(localParcel.readArrayList(getClass().getClassLoader()));
        localParcel.recycle();
      }
      catch (Exception localException)
      {
        QLog.e("Card", 1, "getQZonePhotoList fail.", localException);
      }
    }
    return this.qzonePhotoList;
  }
  
  public int getVipLevel(EVIPSPEC paramEVIPSPEC)
  {
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      return this.iQQVipLevel;
    }
    if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERQQ) {
      return this.iSuperQQLevel;
    }
    if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) {
      return this.iSuperVipLevel;
    }
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD) {
      return this.iHollywoodVipLevel;
    }
    return -1;
  }
  
  public int getVipType(EVIPSPEC paramEVIPSPEC)
  {
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) {
      return this.iQQVipType;
    }
    if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERQQ) {
      return this.iSuperQQType;
    }
    if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) {
      return this.iSuperVipType;
    }
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD) {
      return this.iHollywoodVipType;
    }
    return -1;
  }
  
  public ArrayList<summaryCardWzryInfo> getWzryHonorInfo()
  {
    Object localObject = this.wzryHonorInfo;
    if (localObject != null) {
      try
      {
        localObject = (ArrayList)new ObjectInputStream(new ByteArrayInputStream((byte[])localObject)).readObject();
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return new ArrayList();
  }
  
  public boolean hasGotPhotoUrl()
  {
    return this.vQzonePhotos != null;
  }
  
  public boolean isNewSchoolStatusWriteForGuide()
  {
    return this.newSchoolStatusFlagForGuide != 0;
  }
  
  public boolean isNoCover()
  {
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo2 = this.mPhotoListInfo;
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo1 = localUinPhotoListInfo2;
    if (localUinPhotoListInfo2 == null)
    {
      getCoverData(0);
      localUinPhotoListInfo1 = this.mPhotoListInfo;
    }
    boolean bool;
    if ((localUinPhotoListInfo1 != null) && (localUinPhotoListInfo1.cover_flag.has()) && (localUinPhotoListInfo1.cover_flag.get() == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SummaryCard", 2, String.format("isNoCover uin: %s, ret: %s", new Object[] { this.uin, Boolean.valueOf(bool) }));
    }
    return bool;
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
  
  public boolean isShowXMan()
  {
    return (this.ulShowControl & 0x40) != 0;
  }
  
  public boolean isShowZan()
  {
    int i = this.ulShowControl;
    boolean bool = true;
    if ((i & 0x1) == 0) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isVipOpen(EVIPSPEC paramEVIPSPEC)
  {
    if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP)
    {
      if (this.bQQVipOpen != 1) {}
    }
    else {
      while (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERQQ ? this.bSuperQQOpen == 1 : paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP ? this.bSuperVipOpen == 1 : paramEVIPSPEC == EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD ? this.bHollywoodVipOpen == 1 : (paramEVIPSPEC == EVIPSPEC.E_SP_BIGCLUB) && (this.bBigClubVipOpen == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public void putBusinessInfo(IProfileBusinessInfo paramIProfileBusinessInfo)
  {
    if (this.businessInfoMap == null) {
      this.businessInfoMap = new HashMap();
    }
    this.businessInfoMap.put(paramIProfileBusinessInfo.getClass(), paramIProfileBusinessInfo);
  }
  
  public void removeBusinessInfo(Class<? extends IProfileBusinessInfo> paramClass)
  {
    Map localMap = this.businessInfoMap;
    if (localMap != null) {
      localMap.remove(paramClass);
    }
  }
  
  public void saveBigOrderEntrys(List<ProfileSummaryHobbiesEntry> paramList)
  {
    Object localObject3 = "serviceType";
    JSONStringer localJSONStringer1 = new JSONStringer();
    this.hobbyEntry = "";
    for (;;)
    {
      try
      {
        localJSONStringer1.array();
        Object localObject1 = paramList.iterator();
        boolean bool = ((Iterator)localObject1).hasNext();
        if (bool) {}
        try
        {
          localObject4 = (ProfileSummaryHobbiesEntry)((Iterator)localObject1).next();
          localJSONStringer1.object().key("strName").value(((ProfileSummaryHobbiesEntry)localObject4).strName).key("strServiceUrl").value(((ProfileSummaryHobbiesEntry)localObject4).strServiceUrl).key("strServiceType").value(((ProfileSummaryHobbiesEntry)localObject4).strServiceType).key((String)localObject3).value(((ProfileSummaryHobbiesEntry)localObject4).serviceType);
          if (((ProfileSummaryHobbiesEntry)localObject4).sProfileSummaryHobbiesItem == null) {
            break label773;
          }
          JSONStringer localJSONStringer2 = new JSONStringer().array();
          localObject4 = ((ProfileSummaryHobbiesEntry)localObject4).sProfileSummaryHobbiesItem.iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (ProfileSummaryHobbiesItem)((Iterator)localObject4).next();
            localJSONStringer2.object().key("strTitle").value(((ProfileSummaryHobbiesItem)localObject5).strTitle).key("strCoverUrl").value(((ProfileSummaryHobbiesItem)localObject5).strCoverUrl).key("strJmpUrl").value(((ProfileSummaryHobbiesItem)localObject5).strJmpUrl).key("strSubInfo").value(((ProfileSummaryHobbiesItem)localObject5).strSubInfo).key("strDesc").value(((ProfileSummaryHobbiesItem)localObject5).strDesc).key((String)localObject3).value(((ProfileSummaryHobbiesItem)localObject5).serviceType).key("service").value(((ProfileSummaryHobbiesItem)localObject5).service).key("strTitleIconUrl").value(((ProfileSummaryHobbiesItem)localObject5).strTitleIconUrl).key("uint64_group_code").value(((ProfileSummaryHobbiesItem)localObject5).groupCode);
            if (((ProfileSummaryHobbiesItem)localObject5).labels == null) {
              break label760;
            }
            JSONStringer localJSONStringer3 = new JSONStringer().array();
            localObject5 = ((ProfileSummaryHobbiesItem)localObject5).labels.iterator();
            if (((Iterator)localObject5).hasNext())
            {
              ProfileGroupLabel localProfileGroupLabel = (ProfileGroupLabel)((Iterator)localObject5).next();
              JSONStringer localJSONStringer4 = new JSONStringer().object();
              localJSONStringer4.key("R").value(localProfileGroupLabel.textColor.red).key("G").value(localProfileGroupLabel.textColor.green).key("B").value(localProfileGroupLabel.textColor.blue);
              localJSONStringer4.endObject();
              JSONStringer localJSONStringer5 = new JSONStringer().object();
              localJSONStringer5.key("R").value(localProfileGroupLabel.edgingColor.red).key("G").value(localProfileGroupLabel.edgingColor.green).key("B").value(localProfileGroupLabel.edgingColor.blue);
              localJSONStringer5.endObject();
              localJSONStringer3.object().key("strWording").value(localProfileGroupLabel.strWording).key("type").value(localProfileGroupLabel.type).key("attr").value(localProfileGroupLabel.attr).key("text_color").value(localJSONStringer4).key("edging_color").value(localJSONStringer5).endObject();
              continue;
            }
            localObject5 = localObject1;
            localJSONStringer3.endArray();
            localJSONStringer2.key("labels").value(localJSONStringer3);
            localObject1 = localObject3;
            localObject3 = localObject5;
            localJSONStringer2.endObject();
            localObject5 = localObject3;
            localObject3 = localObject1;
            localObject1 = localObject5;
            continue;
          }
          localObject4 = localObject1;
          localJSONStringer2.endArray();
          localJSONStringer1.key("sProfileSummaryHobbiesItem").value(localJSONStringer2);
          localObject1 = localObject3;
          localObject3 = localObject4;
          localJSONStringer1.endObject();
          localObject4 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject4;
        }
        catch (JSONException localJSONException1)
        {
          break label704;
        }
        localJSONStringer1.endArray();
        localObject1 = localJSONStringer1.toString();
        this.hobbyEntry = ((String)localObject1);
      }
      catch (JSONException localJSONException2) {}
      label704:
      this.hobbyEntry = "";
      localJSONException2.printStackTrace();
      Object localObject2 = this;
      localObject3 = ((Card)localObject2).summaryEntrys;
      if (localObject3 != null)
      {
        ((List)localObject3).clear();
        if ((paramList != null) && (paramList.size() > 0)) {
          ((Card)localObject2).summaryEntrys.addAll(paramList);
        }
      }
      return;
      label760:
      Object localObject5 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject5;
      continue;
      label773:
      Object localObject4 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  public void savePrivilegeClosedInfo(List<PrivilegeInfo> paramList)
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
  
  public void savePrivilegeOpenedInfo(List<PrivilegeInfo> paramList)
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
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)paramList.next();
      if (localPrivilegeInfo.iType == 113)
      {
        this.bBigClubVipOpen = 1;
        this.iBigClubVipType = localPrivilegeInfo.iFeeType;
        this.iBigClubVipLevel = localPrivilegeInfo.iLevel;
      }
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
  
  public void setLabelList(Map<Long, SLabelInfo> paramMap)
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
  
  public void setLastPraiseInfoList(ArrayList<TPraiseInfo> paramArrayList)
  {
    if (paramArrayList != null) {
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
  
  public void setVipInfo(VipBaseInfo paramVipBaseInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public byte[] setWzryHonorInfo(Object paramObject)
  {
    if (paramObject == null) {
      this.wzryHonorInfo = new byte[0];
    } else {
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
    return null;
  }
  
  public void setXManFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ulShowControl |= 0x40;
      return;
    }
    this.ulShowControl &= 0xFFFFFFBF;
  }
  
  public void updateCoverData(byte[] paramArrayOfByte)
  {
    this.vCoverInfo = paramArrayOfByte;
    this.mPhotoListInfo = null;
    if (QLog.isColorLevel())
    {
      if (paramArrayOfByte == null) {
        paramArrayOfByte = "null";
      } else {
        paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
      }
      QLog.d("SummaryCard", 2, String.format("updateCoverData len: %s", new Object[] { paramArrayOfByte }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.Card
 * JD-Core Version:    0.7.0.1
 */