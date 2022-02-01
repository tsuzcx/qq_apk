package com.tencent.mobileqq.data;

import GameCenter.RespLastGameInfo;
import SummaryCard.TPraiseInfo;
import SummaryCard.TVideoHeadInfo;
import android.os.Parcel;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.nearby.business.NearbyCardConstants;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileBusiEntry;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import tencent.im.group.group_member_info.InfoCardVideoInfo;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.RspBody;
import tencent.im.oidb.cmd0x5e9.GetPhotoList.UinHeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.HeadInfo;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

public class NearbyPeopleCard
  extends Entity
{
  private static final String TAG = "Q.nearby_people_card.";
  public String addPicBtnDownloadAppTips = "";
  public int age;
  public String aioDistanceAndTime;
  public short bAvailVoteCnt = 0;
  public short bHaveVotedCnt = 0;
  public String bVideoHeadUrl;
  public byte bVoted;
  public int birthday;
  public String busiEntry;
  public long charm;
  public int charmLevel;
  @notColumn
  public long chatId;
  public String college;
  public long collegeId;
  public String commonLabelString;
  @notColumn
  public List<String> commonLabels;
  public String company;
  public byte constellation;
  public int curThreshold;
  public byte[] dateInfo;
  public String disableSendGiftBtnTips = "";
  public String disableSendGiftBtnTipsForTribar = "";
  public String disableSendMsgBtnTips = "";
  public String disableSendMsgBtnTipsForTribar = "";
  public String distance;
  public int entryAbility;
  public String faceScoreIconUrl;
  public String faceScoreTailWording;
  public int faceScoreTailWordingColor;
  public String faceScoreWording;
  public int faceScoreWordingColor;
  public int favoriteSource;
  public long feedPreviewTime;
  public String firstOfficialMsg;
  public byte gender = -1;
  public boolean godFlag = false;
  public String guideAppNowDownloadUrl;
  public String guideAppNowJumpUri;
  public String guideAppNowPackage;
  public String guideAppNowTip;
  public String guideAppNowTipLeftBtn;
  public String guideAppNowTipRightBtnInstalled;
  public String guideAppNowTipRightBtnNotInstalled;
  public String guideVerifiedDialogRightBtnText;
  public String guideVerifiedDialogTitle;
  public String hiWanInfo;
  public List<NearbyPeopleCard.HiWanItem> hiWanList;
  public int highScoreNum = 0;
  public String hometownCity;
  public String hometownCountry;
  public String hometownDistrict;
  public String hometownProvice;
  @notColumn
  public HotChatInfo hotInfo;
  public int iIsGodFlag;
  @notColumn
  public List<InterestTag> interestTags;
  public boolean isForbidSendGiftMsg = false;
  public boolean isForbidSendGiftMsgForTribar = false;
  public boolean isForbidSendMsg = false;
  public boolean isForbidSendMsgForTribar = false;
  @notColumn
  public boolean isFriend;
  @notColumn
  public boolean isHostSelf;
  public boolean isPhotoUseCache;
  public boolean isSendMsgBtnDownloadAppOpen = true;
  public int job;
  public long lUserFlag = 0L;
  public long lastUpdateNickTime;
  public int likeCount;
  public int likeCountInc;
  public boolean mHasStory = false;
  public int mHeartNum;
  public byte[] mQQStoryData;
  public byte maritalStatus;
  public int maskMsgFlag;
  public int nLastGameFlag;
  public byte[] nearbyInfo;
  @notColumn
  public cmd0xac5.NearbyNowData nearbyNowData;
  public byte[] nearbyNowDataBytes;
  public int nextThreshold;
  public String nickname;
  public long nowId;
  public int nowUserType;
  public int oldPhotoCount;
  public String picInfo;
  @notColumn
  public List<PicInfo> picList;
  @notColumn
  public List<TPraiseInfo> praiseList;
  public int profPercent;
  @notColumn
  public List<ProfileBusiEntry> profileBusiEntry;
  public String qzoneFeed;
  public String qzoneName;
  public String qzonePicUrl_1;
  public String qzonePicUrl_2;
  public String qzonePicUrl_3;
  public int sayHelloFlag;
  public String sendMsgBtnDownloadAppTips = "";
  public String strFreshNewsInfo;
  public String strGodJumpUrl;
  public String strHotChatInfo;
  public String strLevelType;
  public String strProfileUrl;
  public String strRemark;
  public String strVoteLimitedNotice;
  public long switchGiftVisible;
  public boolean switchHobby;
  public boolean switchQzone;
  public long tagFlag;
  public String tagInfo;
  public int taskFinished;
  public int taskTotal;
  public String timeDiff;
  public long tinyId = 0L;
  public String tribeAppDownloadPageUrl = "";
  public long uRoomid;
  public long uiShowControl;
  public String uin;
  public long ulShowControl = 0L;
  public String unverifyGrayTips;
  public long userFlag;
  public byte[] vActivityList;
  public byte[] vCookies;
  public byte[] vGiftInfo;
  public byte[] vGroupList;
  public byte[] vSeed;
  public byte[] vTempChatSig;
  public String videoDetails;
  public boolean videoHeadFlag = false;
  public PicInfo videoInfo;
  public byte[] xuanYan;
  
  public void addOrUpdateBuisEntry(ProfileBusiEntry paramProfileBusiEntry)
  {
    if (paramProfileBusiEntry == null) {
      return;
    }
    int m = paramProfileBusiEntry.nBusiEntryType;
    if (this.profileBusiEntry == null) {
      getBusiEntrys();
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.profileBusiEntry.size()) {
        break;
      }
      if (((ProfileBusiEntry)this.profileBusiEntry.get(i)).nBusiEntryType == m)
      {
        this.profileBusiEntry.remove(i);
        this.profileBusiEntry.add(paramProfileBusiEntry);
        j = 1;
        break;
      }
      i += 1;
    }
    if (j == 0) {
      this.profileBusiEntry.add(paramProfileBusiEntry);
    }
  }
  
  public void addQQStoryList(List<group_member_info.InfoCardVideoInfo> paramList)
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
  
  public List<ProfileBusiEntry> getBusiEntrys()
  {
    if (this.profileBusiEntry == null)
    {
      this.profileBusiEntry = new ArrayList();
      if (!TextUtils.isEmpty(this.busiEntry)) {
        try
        {
          JSONArray localJSONArray = new JSONArray(this.busiEntry);
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            if (localJSONObject != null)
            {
              ProfileBusiEntry localProfileBusiEntry = new ProfileBusiEntry();
              localProfileBusiEntry.nBusiEntryType = localJSONObject.getInt("nBusiEntryType");
              localProfileBusiEntry.strLogoUrl = localJSONObject.getString("strLogoUrl");
              localProfileBusiEntry.strTitle = localJSONObject.getString("strTitle");
              localProfileBusiEntry.strContent = localJSONObject.getString("strContent");
              localProfileBusiEntry.strJumpUrl = localJSONObject.getString("strJumpUrl");
              if (!localProfileBusiEntry.isEmpty()) {
                this.profileBusiEntry.add(localProfileBusiEntry);
              }
            }
            i += 1;
          }
          return this.profileBusiEntry;
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.SummaryCard", 2, localJSONException.toString());
          }
        }
      }
    }
  }
  
  public InterestTag getCommonTagInfos()
  {
    if (this.commonLabels == null) {
      return null;
    }
    InterestTag localInterestTag = new InterestTag(8);
    Iterator localIterator = this.commonLabels.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str != null)
      {
        InterestTagInfo localInterestTagInfo = new InterestTagInfo();
        localInterestTagInfo.tagBgColor = "#dcebff";
        localInterestTagInfo.tagTextColor = "#4b83d3";
        localInterestTagInfo.tagIconUrl = "";
        localInterestTagInfo.tagName = str;
        localInterestTag.jdField_a_of_type_JavaUtilArrayList.add(localInterestTagInfo);
      }
    }
    return localInterestTag;
  }
  
  public boolean getIsHostSelf(String paramString)
  {
    this.isHostSelf = TextUtils.equals(this.uin, paramString);
    return this.isHostSelf;
  }
  
  public List<String> getQQStoryList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = localArrayList;
    if (this.mQQStoryData != null)
    {
      Object localObject1 = localArrayList;
      Object localObject2 = localArrayList;
      try
      {
        Parcel localParcel = Parcel.obtain();
        localObject1 = localArrayList;
        localObject2 = localArrayList;
        localParcel.unmarshall(this.mQQStoryData, 0, this.mQQStoryData.length);
        localObject1 = localArrayList;
        localObject2 = localArrayList;
        localParcel.setDataPosition(0);
        localObject1 = localArrayList;
        localObject2 = localArrayList;
        localObject3 = localParcel.readArrayList(getClass().getClassLoader());
        localObject1 = localObject3;
        localObject2 = localObject3;
        localParcel.recycle();
        return localObject3;
      }
      catch (Error localError)
      {
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.i("SummaryCard, getQQStoryList:", 2, localError.toString());
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject3 = localError;
        if (QLog.isColorLevel())
        {
          QLog.i("SummaryCard, getQQStoryList:", 2, localException.toString());
          localObject3 = localError;
        }
      }
    }
    return localObject3;
  }
  
  public List<String> getQZonePhotoList()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.qzonePicUrl_1)) {
      localArrayList.add(this.qzonePicUrl_1);
    }
    if (!TextUtils.isEmpty(this.qzonePicUrl_2)) {
      localArrayList.add(this.qzonePicUrl_2);
    }
    if (!TextUtils.isEmpty(this.qzonePicUrl_3)) {
      localArrayList.add(this.qzonePicUrl_3);
    }
    return localArrayList;
  }
  
  public String getSafetyUin()
  {
    if ((!TextUtils.isEmpty(this.uin)) && (!"0".equals(this.uin))) {
      return this.uin;
    }
    return String.valueOf(this.tinyId);
  }
  
  public InterestTag getTagInfos(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 1)
    {
      localObject1 = localObject2;
      if (paramInt <= 11)
      {
        Object localObject3 = this.interestTags;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          if (((List)localObject3).size() == 0) {
            return null;
          }
          localObject3 = this.interestTags.iterator();
          do
          {
            localObject1 = localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (InterestTag)((Iterator)localObject3).next();
          } while ((localObject1 == null) || (((InterestTag)localObject1).jdField_a_of_type_Int != paramInt));
        }
      }
    }
    return localObject1;
  }
  
  public void getTagInfos(InterestTag[] paramArrayOfInterestTag)
  {
    if (paramArrayOfInterestTag != null)
    {
      if (paramArrayOfInterestTag.length <= 0) {
        return;
      }
      int j = paramArrayOfInterestTag.length;
      int i = 0;
      while (i < j)
      {
        InterestTag localInterestTag1 = paramArrayOfInterestTag[i];
        if (localInterestTag1 != null)
        {
          InterestTag localInterestTag2 = getTagInfos(localInterestTag1.jdField_a_of_type_Int);
          localInterestTag1.jdField_a_of_type_JavaUtilArrayList.clear();
          if ((localInterestTag2 != null) && (localInterestTag2.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
            localInterestTag1.jdField_a_of_type_JavaUtilArrayList.addAll(localInterestTag2.jdField_a_of_type_JavaUtilArrayList);
          }
        }
        i += 1;
      }
    }
  }
  
  public boolean hasInterestTag()
  {
    Object localObject = this.interestTags;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return false;
      }
      localObject = this.interestTags.iterator();
      while (((Iterator)localObject).hasNext())
      {
        InterestTag localInterestTag = (InterestTag)((Iterator)localObject).next();
        if ((localInterestTag.jdField_a_of_type_JavaUtilArrayList != null) && (!localInterestTag.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasInterestTag(int paramInt, long paramLong)
  {
    Object localObject = getTagInfos(paramInt);
    if (localObject != null)
    {
      localObject = ((InterestTag)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((InterestTagInfo)((Iterator)localObject).next()).tagId == paramLong) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean hasQzonePhotoUrl()
  {
    return (!StringUtil.a(this.qzonePicUrl_1)) || (!StringUtil.a(this.qzonePicUrl_2)) || (!StringUtil.a(this.qzonePicUrl_3));
  }
  
  public boolean isAddPicBtnDownloadAppOpen()
  {
    return (this.uiShowControl & 0x200) != 0L;
  }
  
  public boolean isAuthUser()
  {
    return (this.userFlag & 0x20) != 0L;
  }
  
  public boolean isFuXiaoJin()
  {
    return (this.userFlag & 0x200) != 0L;
  }
  
  public boolean isOpenRecentPlayingGamesByNative()
  {
    return (this.nLastGameFlag & 0x2) == 2;
  }
  
  public boolean isPhotoUseCache()
  {
    return this.isPhotoUseCache;
  }
  
  protected void postRead()
  {
    super.postRead();
    boolean bool = TextUtils.isEmpty(this.tagInfo);
    int j = 0;
    int i;
    Object localObject;
    if (bool)
    {
      this.interestTags = null;
    }
    else
    {
      this.interestTags = new ArrayList();
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.tagInfo);
        i = 0;
        while (i < localJSONArray1.length())
        {
          localObject = localJSONArray1.getJSONObject(i);
          if (localObject != null)
          {
            localObject = (InterestTag)((IInterestTagUtils)QRoute.api(IInterestTagUtils.class)).convertFromJSONObject((JSONObject)localObject);
            if (localObject != null) {
              this.interestTags.add(localObject);
            }
          }
          i += 1;
        }
        if (!TextUtils.isEmpty(this.picInfo)) {
          break label173;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isDevelopLevel()) {
          localException1.printStackTrace();
        } else if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, localException1.toString());
        }
      }
    }
    this.picList = null;
    break label184;
    label173:
    this.picList = PicInfo.a(this.picInfo);
    label184:
    if (TextUtils.isEmpty(this.videoDetails)) {
      this.videoInfo = null;
    } else {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.videoDetails);
        this.videoInfo = new PicInfo();
        if (localJSONObject.has("videoUrl")) {
          this.videoInfo.d = localJSONObject.getString("videoUrl");
        }
        if (localJSONObject.has("bigPicUrl")) {
          this.videoInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("bigPicUrl");
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    this.hiWanList = new ArrayList();
    if (TextUtils.isEmpty(this.hiWanInfo)) {
      this.hiWanList = null;
    } else {
      try
      {
        JSONArray localJSONArray2 = new JSONArray(this.hiWanInfo);
        i = 0;
        while (i < localJSONArray2.length())
        {
          localObject = localJSONArray2.getJSONObject(i);
          NearbyPeopleCard.HiWanItem localHiWanItem = new NearbyPeopleCard.HiWanItem();
          if (((JSONObject)localObject).has("title")) {
            localHiWanItem.title = ((JSONObject)localObject).getString("title");
          }
          if (((JSONObject)localObject).has("icon")) {
            localHiWanItem.icon = ((JSONObject)localObject).getString("icon");
          }
          if (((JSONObject)localObject).has("url")) {
            localHiWanItem.url = ((JSONObject)localObject).getString("url");
          }
          if (((JSONObject)localObject).has("status")) {
            localHiWanItem.status = ((JSONObject)localObject).getInt("status");
          }
          if (((JSONObject)localObject).has("type")) {
            localHiWanItem.type = ((JSONObject)localObject).getInt("type");
          }
          this.hiWanList.add(localHiWanItem);
          i += 1;
        }
        this.commonLabels = new ArrayList();
      }
      catch (JSONException localJSONException2)
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("hiWanList convertFrom exception : ");
          ((StringBuilder)localObject).append(localJSONException2.getMessage());
          QLog.i("Q.nearby_people_card.", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
    if (TextUtils.isEmpty(this.commonLabelString)) {
      this.commonLabels = null;
    } else {
      try
      {
        JSONArray localJSONArray3 = new JSONArray(this.commonLabelString);
        i = j;
        while (i < localJSONArray3.length())
        {
          localObject = localJSONArray3.getString(i);
          this.commonLabels.add(localObject);
          i += 1;
        }
        if (!TextUtils.isEmpty(this.strHotChatInfo)) {
          break label691;
        }
      }
      catch (JSONException localJSONException3)
      {
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("hiWanList convertFrom exception : ");
          ((StringBuilder)localObject).append(localJSONException3.getMessage());
          QLog.i("Q.nearby_people_card.", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
    this.hotInfo = null;
    break label699;
    label691:
    updateHotChatInfo(this.strHotChatInfo);
    try
    {
      label699:
      this.nearbyNowData = new cmd0xac5.NearbyNowData();
      this.nearbyNowData.mergeFrom(this.nearbyNowDataBytes);
      return;
    }
    catch (Exception localException2)
    {
      label723:
      break label723;
    }
    this.nearbyNowData = null;
  }
  
  protected void prewrite()
  {
    super.prewrite();
  }
  
  public void removeBuisEntry(ProfileBusiEntry paramProfileBusiEntry)
  {
    if (paramProfileBusiEntry == null) {
      return;
    }
    int j = paramProfileBusiEntry.nBusiEntryType;
    if (this.profileBusiEntry == null) {
      getBusiEntrys();
    }
    int i = 0;
    while (i < this.profileBusiEntry.size())
    {
      if (((ProfileBusiEntry)this.profileBusiEntry.get(i)).nBusiEntryType == j)
      {
        this.profileBusiEntry.remove(i);
        return;
      }
      i += 1;
    }
  }
  
  public void saveBusiEntrys(List<ProfileBusiEntry> paramList)
  {
    Object localObject = new JSONStringer();
    int j = 0;
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    if (i > 0) {}
    for (;;)
    {
      try
      {
        ((JSONStringer)localObject).array();
        if (j < i)
        {
          ProfileBusiEntry localProfileBusiEntry = (ProfileBusiEntry)paramList.get(j);
          if ((localProfileBusiEntry == null) || (localProfileBusiEntry.isEmpty())) {
            continue;
          }
          ((JSONStringer)localObject).object().key("nBusiEntryType").value(localProfileBusiEntry.nBusiEntryType).key("strLogoUrl").value(localProfileBusiEntry.strLogoUrl).key("strTitle").value(localProfileBusiEntry.strTitle).key("strContent").value(localProfileBusiEntry.strContent).key("strJumpUrl").value(localProfileBusiEntry.strJumpUrl).endObject();
          continue;
        }
        ((JSONStringer)localObject).endArray();
        this.busiEntry = ((JSONStringer)localObject).toString();
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      this.busiEntry = "";
      continue;
      this.busiEntry = "";
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, ((JSONException)localObject).toString());
      }
      localObject = this.profileBusiEntry;
      if (localObject != null)
      {
        ((List)localObject).clear();
        if ((paramList != null) && (paramList.size() > 0)) {
          this.profileBusiEntry.addAll(paramList);
        }
      }
      return;
      j += 1;
    }
  }
  
  public void setPhotoUseCache(long paramLong)
  {
    boolean bool;
    if ((paramLong & 1L) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    this.isPhotoUseCache = bool;
  }
  
  public boolean shouldShowHobby()
  {
    return (this.uiShowControl & 0x20) == 0L;
  }
  
  public boolean shouldShowLikeBtn()
  {
    return (this.uiShowControl & 0x4) != 0L;
  }
  
  public boolean shouldShowQzoneFeed()
  {
    return (this.uiShowControl & 1L) != 0L;
  }
  
  public boolean shouldShowSendMsg()
  {
    return (this.uiShowControl & 0x100) == 0L;
  }
  
  public List<PicInfo> updateDisplayPicInfos(byte[] paramArrayOfByte, TVideoHeadInfo paramTVideoHeadInfo, boolean paramBoolean)
  {
    int i = -1;
    int j = i;
    if (paramTVideoHeadInfo != null)
    {
      if ((!this.videoHeadFlag) && (paramTVideoHeadInfo.iNearbyFlag == 1))
      {
        this.videoHeadFlag = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos|set videoHeadFlag true");
        }
      }
      j = i;
      if (paramTVideoHeadInfo.vMsg != null)
      {
        localObject1 = new oidb_0x74b.RspBody();
        try
        {
          ((oidb_0x74b.RspBody)localObject1).mergeFrom(paramTVideoHeadInfo.vMsg);
        }
        catch (InvalidProtocolBufferMicroException paramTVideoHeadInfo)
        {
          paramTVideoHeadInfo.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.", 2, ".onNearbyCardDownload(), parse vedio head info fail.");
          }
        }
        j = i;
        if (((oidb_0x74b.RspBody)localObject1).rpt_msg_uin_head_list.has())
        {
          paramTVideoHeadInfo = ((oidb_0x74b.OneUinHeadInfo)((oidb_0x74b.RspBody)localObject1).rpt_msg_uin_head_list.get().get(0)).rpt_msg_head_list.get();
          j = i;
          if (paramTVideoHeadInfo != null)
          {
            paramTVideoHeadInfo = paramTVideoHeadInfo.iterator();
            do
            {
              j = i;
              if (!paramTVideoHeadInfo.hasNext()) {
                break;
              }
              localObject1 = (oidb_0x74b.HeadInfo)paramTVideoHeadInfo.next();
            } while (((oidb_0x74b.HeadInfo)localObject1).uint32_type.get() != 17);
            if (((oidb_0x74b.HeadInfo)localObject1).uint32_id.has()) {
              i = ((oidb_0x74b.HeadInfo)localObject1).uint32_id.get();
            }
            if (((oidb_0x74b.HeadInfo)localObject1).rpt_videoheadlist.has()) {
              paramTVideoHeadInfo = ((oidb_0x74b.HeadInfo)localObject1).rpt_videoheadlist.get();
            } else {
              paramTVideoHeadInfo = null;
            }
            j = i;
            if (paramTVideoHeadInfo != null)
            {
              paramTVideoHeadInfo = paramTVideoHeadInfo.iterator();
              do
              {
                j = i;
                if (!paramTVideoHeadInfo.hasNext()) {
                  break;
                }
                localObject1 = (oidb_0x74b.VideoHeadInfo)paramTVideoHeadInfo.next();
              } while (((oidb_0x74b.VideoHeadInfo)localObject1).uint32_video_size.get() != 640);
              paramTVideoHeadInfo = ((oidb_0x74b.VideoHeadInfo)localObject1).str_url.get();
              break label307;
            }
          }
        }
      }
    }
    paramTVideoHeadInfo = null;
    i = j;
    label307:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateDisplayPicInfos|basicVideoUrl: ");
      ((StringBuilder)localObject1).append(paramTVideoHeadInfo);
      ((StringBuilder)localObject1).append(" ,basicVideoId:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(",videoHeadFlag:");
      ((StringBuilder)localObject1).append(this.videoHeadFlag);
      ((StringBuilder)localObject1).append(",isMySelf:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(paramTVideoHeadInfo)) {
      this.bVideoHeadUrl = paramTVideoHeadInfo;
    }
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject1 = new GetPhotoList.RspBody();
    if (paramArrayOfByte != null) {}
    try
    {
      ((GetPhotoList.RspBody)localObject1).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label442:
      Object localObject2;
      int k;
      break label442;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.", 2, ".onNearbyCardDownload(), parse head info fail.");
    }
    if (!((GetPhotoList.RspBody)localObject1).rpt_msg_uin_heads.has()) {
      return null;
    }
    paramArrayOfByte = (GetPhotoList.HeadInfo)((GetPhotoList.UinHeadInfo)((GetPhotoList.RspBody)localObject1).rpt_msg_uin_heads.get().get(0)).msg_verify_video_info.get();
    paramTVideoHeadInfo = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.get() != null) && (!TextUtils.isEmpty(((GetPhotoList.HeadInfo)paramArrayOfByte.get()).str_video_id.get())))
    {
      this.videoInfo = new PicInfo();
      this.videoInfo.f = ((GetPhotoList.HeadInfo)paramArrayOfByte.get()).str_video_id.get();
      this.videoInfo.d = paramArrayOfByte.str_video_url.get();
      this.videoInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte.str_headurl.get();
      paramArrayOfByte = this.videoInfo.a();
      if (paramArrayOfByte != null) {
        this.videoDetails = paramArrayOfByte.toString();
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("updateDisplayPicInfos, videoUrl:");
        paramArrayOfByte.append(this.videoInfo.d);
        paramArrayOfByte.append(", bigPicUrl:");
        paramArrayOfByte.append(this.videoInfo.jdField_a_of_type_JavaLangString);
        QLog.d("Q.nearby_people_card.", 2, paramArrayOfByte.toString());
      }
    }
    else
    {
      this.videoInfo = null;
      this.videoDetails = "";
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, videoInfo is null .");
      }
    }
    localObject1 = ((GetPhotoList.UinHeadInfo)((GetPhotoList.RspBody)localObject1).rpt_msg_uin_heads.get().get(0)).rpt_msg_headinfo.get();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("head size = ");
      if (localObject1 == null) {
        paramArrayOfByte = "null";
      } else {
        paramArrayOfByte = Integer.valueOf(((List)localObject1).size());
      }
      ((StringBuilder)localObject2).append(paramArrayOfByte);
      QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      if (((List)localObject1).isEmpty()) {
        return null;
      }
      this.picList = new ArrayList();
      localObject2 = new JSONArray();
      k = Math.min(18, ((List)localObject1).size());
      i = 0;
      while (i < k)
      {
        GetPhotoList.HeadInfo localHeadInfo = (GetPhotoList.HeadInfo)((List)localObject1).get(i);
        PicInfo localPicInfo = new PicInfo();
        localPicInfo.jdField_a_of_type_Int = localHeadInfo.uint32_headid.get();
        localPicInfo.jdField_a_of_type_JavaLangString = localHeadInfo.str_headurl.get();
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append(localPicInfo.jdField_a_of_type_JavaLangString);
        paramArrayOfByte.append("250");
        localPicInfo.b = paramArrayOfByte.toString();
        if ((i == 0) || (paramBoolean))
        {
          if (localHeadInfo.str_video_url.has()) {
            paramArrayOfByte = localHeadInfo.str_video_url.get();
          } else {
            paramArrayOfByte = null;
          }
          localPicInfo.d = paramArrayOfByte;
          if (localHeadInfo.str_video_id.has()) {
            paramArrayOfByte = localHeadInfo.str_video_id.get();
          } else {
            paramArrayOfByte = null;
          }
          localPicInfo.f = paramArrayOfByte;
          if (localHeadInfo.uint32_video_size.has()) {
            j = localHeadInfo.uint32_video_size.get();
          } else {
            j = 0;
          }
          if (!TextUtils.isEmpty(localPicInfo.d)) {
            localPicInfo.e = DynamicAvatarDownloadManager.b(localPicInfo.d);
          }
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("updateDisplayPicInfos, videoUrlSize:");
            paramArrayOfByte.append(j);
            QLog.d("Q.nearby_people_card.", 2, paramArrayOfByte.toString());
          }
        }
        this.picList.add(localPicInfo);
        paramArrayOfByte = localPicInfo.a();
        if (paramArrayOfByte != null) {
          ((JSONArray)localObject2).put(paramArrayOfByte);
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("updateDisplayPicInfos, picInfo:");
          paramArrayOfByte.append(localPicInfo);
          QLog.d("Q.nearby_people_card.", 2, paramArrayOfByte.toString());
        }
        i += 1;
      }
      if (((JSONArray)localObject2).length() <= 0) {
        paramArrayOfByte = paramTVideoHeadInfo;
      } else {
        paramArrayOfByte = ((JSONArray)localObject2).toString();
      }
      this.picInfo = paramArrayOfByte;
      return this.picList;
    }
    return null;
  }
  
  public List<PicInfo> updateEditPicInfos(byte[] paramArrayOfByte, PicInfo paramPicInfo)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject1 = new UpdatePhotoList.RspBody();
    for (;;)
    {
      try
      {
        ((UpdatePhotoList.RspBody)localObject1).mergeFrom(paramArrayOfByte);
        if (!((UpdatePhotoList.RspBody)localObject1).rpt_msg_headinfo.has()) {
          break label673;
        }
        paramArrayOfByte = ((UpdatePhotoList.RspBody)localObject1).rpt_msg_headinfo.get();
        if (paramArrayOfByte != null)
        {
          if (paramArrayOfByte.isEmpty()) {
            return null;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("edit head size = ");
            ((StringBuilder)localObject1).append(paramArrayOfByte.size());
            ((StringBuilder)localObject1).append(",extraPicInfo:");
            ((StringBuilder)localObject1).append(paramPicInfo);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
          }
          this.picList = new ArrayList();
          localObject1 = new JSONArray();
          int i = 0;
          Iterator localIterator = paramArrayOfByte.iterator();
          if (localIterator.hasNext())
          {
            Object localObject2 = (UpdatePhotoList.HeadInfo)localIterator.next();
            PicInfo localPicInfo = new PicInfo();
            if (!((UpdatePhotoList.HeadInfo)localObject2).uint32_headid.has()) {
              break label678;
            }
            j = ((UpdatePhotoList.HeadInfo)localObject2).uint32_headid.get();
            localPicInfo.jdField_a_of_type_Int = j;
            if (!((UpdatePhotoList.HeadInfo)localObject2).str_headurl.has()) {
              break label684;
            }
            paramArrayOfByte = ((UpdatePhotoList.HeadInfo)localObject2).str_headurl.get();
            localPicInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (TextUtils.isEmpty(localPicInfo.jdField_a_of_type_JavaLangString))
            {
              paramArrayOfByte = "";
            }
            else
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append(localPicInfo.jdField_a_of_type_JavaLangString);
              paramArrayOfByte.append("250");
              paramArrayOfByte = paramArrayOfByte.toString();
            }
            localPicInfo.b = paramArrayOfByte;
            j = i;
            if (((UpdatePhotoList.HeadInfo)localObject2).str_video_url.has())
            {
              j = i;
              if (((UpdatePhotoList.HeadInfo)localObject2).str_video_id.has())
              {
                localPicInfo.d = ((UpdatePhotoList.HeadInfo)localObject2).str_video_url.get();
                localPicInfo.e = DynamicAvatarDownloadManager.b(localPicInfo.d);
                localPicInfo.f = ((UpdatePhotoList.HeadInfo)localObject2).str_video_id.get();
                if ((paramPicInfo == null) || (paramPicInfo.jdField_a_of_type_Int != localPicInfo.jdField_a_of_type_Int) || (TextUtils.isEmpty(localPicInfo.d))) {
                  break label690;
                }
                boolean bool = localPicInfo.e.equals(paramPicInfo.e);
                if (bool) {
                  break label690;
                }
                try
                {
                  FileUtils.copyFile(paramPicInfo.e, localPicInfo.e);
                }
                catch (Exception paramArrayOfByte)
                {
                  if (!QLog.isColorLevel()) {
                    break label690;
                  }
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("copy videoHead exception:");
                ((StringBuilder)localObject2).append(paramArrayOfByte.getMessage());
                QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
                break label690;
              }
            }
            this.picList.add(localPicInfo);
            paramArrayOfByte = localPicInfo.a();
            if (paramArrayOfByte != null) {
              ((JSONArray)localObject1).put(paramArrayOfByte);
            }
            i = j;
            if (!QLog.isColorLevel()) {
              continue;
            }
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("picInfo = ");
            paramArrayOfByte.append(localPicInfo);
            QLog.d("Q.nearby_people_card.", 2, paramArrayOfByte.toString());
            i = j;
            continue;
          }
          if ((!this.videoHeadFlag) && (i != 0))
          {
            this.videoHeadFlag = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.nearby_people_card.", 2, "rsp_5ea,set videoHeadFlag true");
            }
          }
          if (((JSONArray)localObject1).length() <= 0) {
            paramArrayOfByte = "";
          } else {
            paramArrayOfByte = ((JSONArray)localObject1).toString();
          }
          this.picInfo = paramArrayOfByte;
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
        {
          paramPicInfo = new StringBuilder();
          paramPicInfo.append("rsp_5ea");
          paramPicInfo.append(paramArrayOfByte.toString());
          QLog.d("Q.nearby_people_card.", 2, paramPicInfo.toString());
        }
        this.picInfo = "";
      }
      return this.picList;
      label673:
      paramArrayOfByte = null;
      continue;
      label678:
      int j = -1;
      continue;
      label684:
      paramArrayOfByte = "";
      continue;
      label690:
      j = 1;
    }
  }
  
  public void updateHotChatInfo(HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null)
    {
      this.hotInfo = null;
      return;
    }
    this.hotInfo = paramHotChatInfo;
    paramHotChatInfo = new JSONObject();
    try
    {
      paramHotChatInfo.put("name", this.hotInfo.name);
      paramHotChatInfo.put("subType", this.hotInfo.subType);
      paramHotChatInfo.put("joinUrl", this.hotInfo.joinUrl);
      paramHotChatInfo.put("troopUin", this.hotInfo.troopUin);
      paramHotChatInfo.put("troopCode", this.hotInfo.troopCode);
      this.strHotChatInfo = paramHotChatInfo.toString();
    }
    catch (JSONException localJSONException)
    {
      label109:
      StringBuilder localStringBuilder;
      break label109;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "convertHotChatInfo2Json error.");
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertHotChatInfo2Json : ");
      localStringBuilder.append(paramHotChatInfo.toString());
      QLog.i("Q.nearby_people_card.", 2, localStringBuilder.toString());
    }
  }
  
  public void updateHotChatInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.hotInfo = null;
    }
    this.hotInfo = new HotChatInfo();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("name")) {
        this.hotInfo.name = paramString.getString("name");
      }
      if (paramString.has("subType")) {
        this.hotInfo.subType = paramString.getInt("subType");
      }
      if (paramString.has("joinUrl")) {
        this.hotInfo.joinUrl = paramString.getString("joinUrl");
      }
      if (paramString.has("troopUin")) {
        this.hotInfo.troopUin = paramString.getString("troopUin");
      }
      if (!paramString.has("troopCode")) {
        break label170;
      }
      this.hotInfo.troopCode = paramString.getString("troopCode");
    }
    catch (JSONException paramString)
    {
      label155:
      label170:
      break label155;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.", 2, "convert2HotChatInfoFromJson error.");
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("convert2HotChatInfoFromJson: ");
      paramString.append(this.hotInfo);
      QLog.d("Q.nearby_people_card.", 2, paramString.toString());
    }
  }
  
  public void updateInterestTags(long paramLong, List<appoint_define.InterestTag> paramList)
  {
    this.tagFlag = paramLong;
    Object localObject1;
    if ((paramList != null) && (paramList.size() != 0))
    {
      localObject1 = this.interestTags;
      if (localObject1 == null) {
        this.interestTags = new ArrayList(paramList.size());
      } else {
        ((List)localObject1).clear();
      }
      paramList = paramList.iterator();
    }
    while (paramList.hasNext())
    {
      localObject1 = (appoint_define.InterestTag)paramList.next();
      localObject1 = (InterestTag)((IInterestTagUtils)QRoute.api(IInterestTagUtils.class)).convertFrom(localObject1);
      if (localObject1 != null)
      {
        this.interestTags.add(localObject1);
        continue;
        paramList = this.interestTags;
        if (paramList != null) {
          paramList.clear();
        }
      }
    }
    paramList = this.interestTags;
    if ((paramList != null) && (paramList.size() != 0)) {}
    try
    {
      paramList = new JSONArray();
      localObject1 = this.interestTags.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (InterestTag)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((InterestTag)localObject2).jdField_a_of_type_JavaUtilArrayList.size() != 0))
        {
          localObject2 = ((InterestTag)localObject2).a();
          if (localObject2 != null) {
            paramList.put(localObject2);
          }
        }
      }
      this.tagInfo = paramList.toString();
    }
    catch (OutOfMemoryError paramList)
    {
      label256:
      label274:
      break label256;
    }
    System.gc();
    this.tagInfo = "";
    break label274;
    this.tagInfo = "";
    if (QLog.isDevelopLevel())
    {
      paramList = new StringBuilder();
      paramList.append("updateInterestTags,");
      localObject1 = this.interestTags;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramList.append(this.interestTags.size());
        paramList.append(", {");
        localObject1 = this.interestTags.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramList.append(((InterestTag)((Iterator)localObject1).next()).toString());
          paramList.append(",");
        }
        paramList.append("}");
      }
      QLog.i("InterestTag", 4, paramList.toString());
    }
  }
  
  public void updateInterestTags(List<appoint_define.InterestTag> paramList)
  {
    updateInterestTags(this.tagFlag, paramList);
  }
  
  public void updateLastGameInfo(RespLastGameInfo paramRespLastGameInfo)
  {
    if ((paramRespLastGameInfo != null) && (paramRespLastGameInfo.iResult == 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateLastGameInfo|info.bShowGameLogo = ");
        localStringBuilder.append(paramRespLastGameInfo.bShowGameLogo);
        localStringBuilder.append("|info.bNative = ");
        localStringBuilder.append(paramRespLastGameInfo.bNative);
        localStringBuilder.append("|info.sLogoUrl = ");
        localStringBuilder.append(paramRespLastGameInfo.sLogoUrl);
        QLog.i("SummaryCard", 2, localStringBuilder.toString());
      }
      if (paramRespLastGameInfo.bShowGameLogo)
      {
        this.nLastGameFlag |= 0x1;
        if (paramRespLastGameInfo.bNative) {
          this.nLastGameFlag |= 0x2;
        } else {
          this.nLastGameFlag &= 0xFFFFFFFD;
        }
        this.strProfileUrl = paramRespLastGameInfo.sProfileUrl;
        return;
      }
      this.nLastGameFlag &= 0xFFFFFFFE;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SummaryCard", 2, "handleGetSummaryCard|updateLastGameInfo|info = null or info.iResult != 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.NearbyPeopleCard
 * JD-Core Version:    0.7.0.1
 */