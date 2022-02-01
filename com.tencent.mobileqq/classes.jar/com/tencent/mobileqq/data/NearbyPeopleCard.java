package com.tencent.mobileqq.data;

import GameCenter.RespLastGameInfo;
import SummaryCard.TPraiseInfo;
import SummaryCard.TVideoHeadInfo;
import android.os.Parcel;
import android.text.TextUtils;
import apbd;
import appoint.define.appoint_define.InterestTag;
import awkq;
import awoe;
import aymd;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
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
  public String addPicBtnDownloadAppTips = "";
  public int age;
  public String aioDistanceAndTime;
  public short bAvailVoteCnt;
  public short bHaveVotedCnt;
  public String bVideoHeadUrl;
  public byte bVoted;
  public int birthday;
  public String busiEntry;
  public long charm;
  public int charmLevel;
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
  public byte gender = -1;
  public boolean godFlag;
  public String guideAppNowDownloadUrl;
  public String guideAppNowJumpUri;
  public String guideAppNowPackage;
  public String guideAppNowTip;
  public String guideAppNowTipLeftBtn;
  public String guideAppNowTipRightBtnInstalled;
  public String guideAppNowTipRightBtnNotInstalled;
  public String hiWanInfo;
  public List<NearbyPeopleCard.HiWanItem> hiWanList;
  public int highScoreNum;
  public String hometownCity;
  public String hometownCountry;
  public String hometownDistrict;
  public String hometownProvice;
  @notColumn
  public HotChatInfo hotInfo;
  public int iIsGodFlag;
  @notColumn
  public List<awoe> interestTags;
  public boolean isForbidSendGiftMsg;
  public boolean isForbidSendGiftMsgForTribar;
  public boolean isForbidSendMsg;
  public boolean isForbidSendMsgForTribar;
  public boolean isPhotoUseCache;
  public boolean isSendMsgBtnDownloadAppOpen = true;
  public int job;
  public long lUserFlag;
  public long lastUpdateNickTime;
  public int likeCount;
  public int likeCountInc;
  public boolean mHasStory;
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
  public List<aymd> profileBusiEntry;
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
  public long tinyId;
  public String tribeAppDownloadPageUrl = "";
  public long uRoomid;
  public long uiShowControl;
  public String uin;
  public long ulShowControl;
  public long userFlag;
  public byte[] vActivityList;
  public byte[] vCookies;
  public byte[] vGiftInfo;
  public byte[] vGroupList;
  public byte[] vSeed;
  public byte[] vTempChatSig;
  public String videoDetails;
  public boolean videoHeadFlag;
  public PicInfo videoInfo;
  public byte[] xuanYan;
  
  public void addOrUpdateBuisEntry(aymd paramaymd)
  {
    int k = 0;
    if (paramaymd == null) {
      return;
    }
    int m = paramaymd.jdField_a_of_type_Int;
    if (this.profileBusiEntry == null) {
      getBusiEntrys();
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.profileBusiEntry.size())
      {
        if (((aymd)this.profileBusiEntry.get(i)).jdField_a_of_type_Int == m)
        {
          j = 1;
          this.profileBusiEntry.remove(i);
          this.profileBusiEntry.add(paramaymd);
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        this.profileBusiEntry.add(paramaymd);
        return;
      }
      i += 1;
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
  
  public List<aymd> getBusiEntrys()
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
          aymd localaymd = new aymd();
          localaymd.jdField_a_of_type_Int = localJSONObject.getInt("nBusiEntryType");
          localaymd.jdField_a_of_type_JavaLangString = localJSONObject.getString("strLogoUrl");
          localaymd.b = localJSONObject.getString("strTitle");
          localaymd.c = localJSONObject.getString("strContent");
          localaymd.d = localJSONObject.getString("strJumpUrl");
          if (localaymd.a()) {
            break label178;
          }
          this.profileBusiEntry.add(localaymd);
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
  
  public awoe getCommonTagInfos()
  {
    if (this.commonLabels == null) {
      return null;
    }
    awoe localawoe = new awoe(8);
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
        localawoe.jdField_a_of_type_JavaUtilArrayList.add(localInterestTagInfo);
      }
    }
    return localawoe;
  }
  
  public List<String> getQQStoryList()
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
  
  public awoe getTagInfos(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 11) || (this.interestTags == null) || (this.interestTags.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.interestTags.iterator();
    while (localIterator.hasNext())
    {
      awoe localawoe = (awoe)localIterator.next();
      if ((localawoe != null) && (localawoe.jdField_a_of_type_Int == paramInt)) {
        return localawoe;
      }
    }
    return null;
  }
  
  public void getTagInfos(awoe[] paramArrayOfawoe)
  {
    if ((paramArrayOfawoe == null) || (paramArrayOfawoe.length <= 0)) {
      return;
    }
    int j = paramArrayOfawoe.length;
    int i = 0;
    label15:
    awoe localawoe1;
    if (i < j)
    {
      localawoe1 = paramArrayOfawoe[i];
      if (localawoe1 != null) {
        break label37;
      }
    }
    for (;;)
    {
      i += 1;
      break label15;
      break;
      label37:
      awoe localawoe2 = getTagInfos(localawoe1.jdField_a_of_type_Int);
      localawoe1.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((localawoe2 != null) && (localawoe2.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localawoe1.jdField_a_of_type_JavaUtilArrayList.addAll(localawoe2.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public boolean hasInterestTag()
  {
    if ((this.interestTags == null) || (this.interestTags.isEmpty())) {
      return false;
    }
    Iterator localIterator = this.interestTags.iterator();
    while (localIterator.hasNext())
    {
      awoe localawoe = (awoe)localIterator.next();
      if ((localawoe.jdField_a_of_type_JavaUtilArrayList != null) && (!localawoe.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean hasInterestTag(int paramInt, long paramLong)
  {
    Object localObject = getTagInfos(paramInt);
    if (localObject != null)
    {
      localObject = ((awoe)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
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
    return (!StringUtil.isEmpty(this.qzonePicUrl_1)) || (!StringUtil.isEmpty(this.qzonePicUrl_2)) || (!StringUtil.isEmpty(this.qzonePicUrl_3));
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
  
  public void postRead()
  {
    super.postRead();
    if (TextUtils.isEmpty(this.tagInfo))
    {
      this.interestTags = null;
      if (!TextUtils.isEmpty(this.picInfo)) {
        break label243;
      }
      this.picList = null;
      label34:
      if (!TextUtils.isEmpty(this.videoDetails)) {
        break label257;
      }
      this.videoInfo = null;
      label49:
      this.hiWanList = new ArrayList();
      if (!TextUtils.isEmpty(this.hiWanInfo)) {
        break label339;
      }
      this.hiWanList = null;
      label75:
      this.commonLabels = new ArrayList();
      if (!TextUtils.isEmpty(this.commonLabelString)) {
        break label545;
      }
      this.commonLabels = null;
      label101:
      if (!TextUtils.isEmpty(this.strHotChatInfo)) {
        break label631;
      }
      this.hotInfo = null;
    }
    label257:
    label545:
    try
    {
      label116:
      this.nearbyNowData = new cmd0xac5.NearbyNowData();
      this.nearbyNowData.mergeFrom(this.nearbyNowDataBytes);
      return;
    }
    catch (Exception localException2)
    {
      label243:
      label631:
      this.nearbyNowData = null;
      label339:
      return;
    }
    this.interestTags = new ArrayList();
    for (;;)
    {
      int i;
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          for (;;)
          {
            try
            {
              JSONArray localJSONArray1 = new JSONArray(this.tagInfo);
              i = 0;
              if (i >= localJSONArray1.length()) {
                break;
              }
              localObject = localJSONArray1.getJSONObject(i);
              if (localObject == null) {
                break label649;
              }
              localObject = awoe.a((JSONObject)localObject);
              if (localObject == null) {
                break label649;
              }
              this.interestTags.add(localObject);
            }
            catch (Exception localException1)
            {
              if (QLog.isDevelopLevel())
              {
                localException1.printStackTrace();
                break;
              }
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("Q.nearby_people_card.", 2, localException1.toString());
            break;
            this.picList = PicInfo.a(this.picInfo);
            break label34;
            try
            {
              JSONObject localJSONObject = new JSONObject(this.videoDetails);
              this.videoInfo = new PicInfo();
              if (localJSONObject.has("videoUrl")) {
                this.videoInfo.d = localJSONObject.getString("videoUrl");
              }
              if (!localJSONObject.has("bigPicUrl")) {
                break label49;
              }
              this.videoInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("bigPicUrl");
            }
            catch (JSONException localJSONException1)
            {
              localJSONException1.printStackTrace();
            }
          }
          break label49;
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
            if (!QLog.isDevelopLevel()) {
              break label75;
            }
          }
          catch (JSONException localJSONException2) {}
        }
        QLog.i("Q.nearby_people_card.", 4, "hiWanList convertFrom exception : " + localJSONException2.getMessage());
        break label75;
        try
        {
          JSONArray localJSONArray3 = new JSONArray(this.commonLabelString);
          i = 0;
          while (i < localJSONArray3.length())
          {
            localObject = localJSONArray3.getString(i);
            this.commonLabels.add(localObject);
            i += 1;
          }
          if (!QLog.isDevelopLevel()) {
            break label101;
          }
        }
        catch (JSONException localJSONException3) {}
      }
      QLog.i("Q.nearby_people_card.", 4, "hiWanList convertFrom exception : " + localJSONException3.getMessage());
      break label101;
      updateHotChatInfo(this.strHotChatInfo);
      break label116;
      label649:
      i += 1;
    }
  }
  
  public void prewrite()
  {
    super.prewrite();
  }
  
  public void removeBuisEntry(aymd paramaymd)
  {
    if (paramaymd == null) {}
    for (;;)
    {
      return;
      int j = paramaymd.jdField_a_of_type_Int;
      if (this.profileBusiEntry == null) {
        getBusiEntrys();
      }
      int i = 0;
      while (i < this.profileBusiEntry.size())
      {
        if (((aymd)this.profileBusiEntry.get(i)).jdField_a_of_type_Int == j)
        {
          this.profileBusiEntry.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void saveBusiEntrys(List<aymd> paramList)
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
          aymd localaymd = (aymd)paramList.get(j);
          if ((localaymd != null) && (!localaymd.a())) {
            localJSONStringer.object().key("nBusiEntryType").value(localaymd.jdField_a_of_type_Int).key("strLogoUrl").value(localaymd.jdField_a_of_type_JavaLangString).key("strTitle").value(localaymd.b).key("strContent").value(localaymd.c).key("strJumpUrl").value(localaymd.d).endObject();
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
  
  public void setPhotoUseCache(long paramLong)
  {
    if ((1L & paramLong) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.isPhotoUseCache = bool;
      return;
    }
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
    Object localObject;
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
      if (paramTVideoHeadInfo.vMsg != null) {
        localObject = new oidb_0x74b.RspBody();
      }
    }
    for (;;)
    {
      try
      {
        ((oidb_0x74b.RspBody)localObject).mergeFrom(paramTVideoHeadInfo.vMsg);
        j = i;
        if (!((oidb_0x74b.RspBody)localObject).rpt_msg_uin_head_list.has()) {
          break label1125;
        }
        paramTVideoHeadInfo = ((oidb_0x74b.OneUinHeadInfo)((oidb_0x74b.RspBody)localObject).rpt_msg_uin_head_list.get().get(0)).rpt_msg_head_list.get();
        j = i;
        if (paramTVideoHeadInfo == null) {
          break label1125;
        }
        paramTVideoHeadInfo = paramTVideoHeadInfo.iterator();
        j = i;
        if (!paramTVideoHeadInfo.hasNext()) {
          break label1125;
        }
        localObject = (oidb_0x74b.HeadInfo)paramTVideoHeadInfo.next();
        if (((oidb_0x74b.HeadInfo)localObject).uint32_type.get() != 17) {
          continue;
        }
        if (((oidb_0x74b.HeadInfo)localObject).uint32_id.has()) {
          i = ((oidb_0x74b.HeadInfo)localObject).uint32_id.get();
        }
        if (((oidb_0x74b.HeadInfo)localObject).rpt_videoheadlist.has())
        {
          paramTVideoHeadInfo = ((oidb_0x74b.HeadInfo)localObject).rpt_videoheadlist.get();
          j = i;
          if (paramTVideoHeadInfo == null) {
            break label1125;
          }
          paramTVideoHeadInfo = paramTVideoHeadInfo.iterator();
          j = i;
          if (!paramTVideoHeadInfo.hasNext()) {
            break label1125;
          }
          localObject = (oidb_0x74b.VideoHeadInfo)paramTVideoHeadInfo.next();
          if (((oidb_0x74b.VideoHeadInfo)localObject).uint32_video_size.get() != 640) {
            continue;
          }
          paramTVideoHeadInfo = ((oidb_0x74b.VideoHeadInfo)localObject).str_url.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos|basicVideoUrl: " + paramTVideoHeadInfo + " ,basicVideoId:" + i + ",videoHeadFlag:" + this.videoHeadFlag + ",isMySelf:" + paramBoolean);
          }
          if (!TextUtils.isEmpty(paramTVideoHeadInfo)) {
            this.bVideoHeadUrl = paramTVideoHeadInfo;
          }
          if (paramArrayOfByte != null) {
            continue;
          }
          return null;
        }
      }
      catch (InvalidProtocolBufferMicroException paramTVideoHeadInfo)
      {
        paramTVideoHeadInfo.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.nearby_people_card.", 2, ".onNearbyCardDownload(), parse vedio head info fail.");
        continue;
        paramTVideoHeadInfo = null;
        continue;
        paramTVideoHeadInfo = new GetPhotoList.RspBody();
        if (paramArrayOfByte != null) {}
        try
        {
          paramTVideoHeadInfo.mergeFrom(paramArrayOfByte);
          if (!paramTVideoHeadInfo.rpt_msg_uin_heads.has()) {
            continue;
          }
          paramArrayOfByte = (GetPhotoList.HeadInfo)((GetPhotoList.UinHeadInfo)paramTVideoHeadInfo.rpt_msg_uin_heads.get().get(0)).msg_verify_video_info.get();
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
            if (QLog.isColorLevel()) {
              QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, videoUrl:" + this.videoInfo.d + ", bigPicUrl:" + this.videoInfo.jdField_a_of_type_JavaLangString);
            }
            paramTVideoHeadInfo = ((GetPhotoList.UinHeadInfo)paramTVideoHeadInfo.rpt_msg_uin_heads.get().get(0)).rpt_msg_headinfo.get();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder().append("head size = ");
              if (paramTVideoHeadInfo != null) {
                continue;
              }
              paramArrayOfByte = "null";
              QLog.d("Q.nearby_people_card.", 2, paramArrayOfByte);
            }
            if ((paramTVideoHeadInfo == null) || (paramTVideoHeadInfo.isEmpty())) {
              continue;
            }
            this.picList = new ArrayList();
            localObject = new JSONArray();
            int k = Math.min(18, paramTVideoHeadInfo.size());
            i = 0;
            if (i >= k) {
              continue;
            }
            GetPhotoList.HeadInfo localHeadInfo = (GetPhotoList.HeadInfo)paramTVideoHeadInfo.get(i);
            PicInfo localPicInfo = new PicInfo();
            localPicInfo.jdField_a_of_type_Int = localHeadInfo.uint32_headid.get();
            localPicInfo.jdField_a_of_type_JavaLangString = localHeadInfo.str_headurl.get();
            localPicInfo.b = (localPicInfo.jdField_a_of_type_JavaLangString + "250");
            if ((i == 0) || (paramBoolean))
            {
              if (!localHeadInfo.str_video_url.has()) {
                continue;
              }
              paramArrayOfByte = localHeadInfo.str_video_url.get();
              localPicInfo.d = paramArrayOfByte;
              if (!localHeadInfo.str_video_id.has()) {
                continue;
              }
              paramArrayOfByte = localHeadInfo.str_video_id.get();
              localPicInfo.f = paramArrayOfByte;
              if (!localHeadInfo.uint32_video_size.has()) {
                continue;
              }
              j = localHeadInfo.uint32_video_size.get();
              if (!TextUtils.isEmpty(localPicInfo.d)) {
                localPicInfo.e = apbd.b(localPicInfo.d);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, videoUrlSize:" + j);
              }
            }
            this.picList.add(localPicInfo);
            paramArrayOfByte = localPicInfo.a();
            if (paramArrayOfByte != null) {
              ((JSONArray)localObject).put(paramArrayOfByte);
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, picInfo:" + localPicInfo);
            }
            i += 1;
            continue;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.nearby_people_card.", 2, ".onNearbyCardDownload(), parse head info fail.");
          continue;
          this.videoInfo = null;
          this.videoDetails = "";
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.nearby_people_card.", 2, "updateDisplayPicInfos, videoInfo is null .");
          continue;
          paramArrayOfByte = Integer.valueOf(paramTVideoHeadInfo.size());
          continue;
          paramArrayOfByte = null;
          continue;
          paramArrayOfByte = null;
          continue;
          j = 0;
          continue;
        }
        if (((JSONArray)localObject).length() > 0) {}
      }
      for (paramArrayOfByte = "";; paramArrayOfByte = ((JSONArray)localObject).toString())
      {
        this.picInfo = paramArrayOfByte;
        return this.picList;
      }
      label1125:
      paramTVideoHeadInfo = null;
      i = j;
    }
  }
  
  public List<PicInfo> updateEditPicInfos(byte[] paramArrayOfByte, PicInfo paramPicInfo)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return null;
      Object localObject = new UpdatePhotoList.RspBody();
      try
      {
        ((UpdatePhotoList.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (((UpdatePhotoList.RspBody)localObject).rpt_msg_headinfo.has())
        {
          paramArrayOfByte = ((UpdatePhotoList.RspBody)localObject).rpt_msg_headinfo.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.isEmpty())) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby_people_card.", 2, "edit head size = " + paramArrayOfByte.size() + ",extraPicInfo:" + paramPicInfo);
          }
          this.picList = new ArrayList();
          localObject = new JSONArray();
          i = 0;
          Iterator localIterator = paramArrayOfByte.iterator();
          if (localIterator.hasNext())
          {
            UpdatePhotoList.HeadInfo localHeadInfo = (UpdatePhotoList.HeadInfo)localIterator.next();
            PicInfo localPicInfo = new PicInfo();
            if (!localHeadInfo.uint32_headid.has()) {
              break label619;
            }
            j = localHeadInfo.uint32_headid.get();
            localPicInfo.jdField_a_of_type_Int = j;
            if (!localHeadInfo.str_headurl.has()) {
              break label625;
            }
            paramArrayOfByte = localHeadInfo.str_headurl.get();
            localPicInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
            if (TextUtils.isEmpty(localPicInfo.jdField_a_of_type_JavaLangString)) {}
            for (paramArrayOfByte = "";; paramArrayOfByte = localPicInfo.jdField_a_of_type_JavaLangString + "250")
            {
              localPicInfo.b = paramArrayOfByte;
              if ((!localHeadInfo.str_video_url.has()) || (!localHeadInfo.str_video_id.has())) {
                break;
              }
              localPicInfo.d = localHeadInfo.str_video_url.get();
              localPicInfo.e = apbd.b(localPicInfo.d);
              localPicInfo.f = localHeadInfo.str_video_id.get();
              if ((paramPicInfo == null) || (paramPicInfo.jdField_a_of_type_Int != localPicInfo.jdField_a_of_type_Int) || (TextUtils.isEmpty(localPicInfo.d))) {
                break label631;
              }
              boolean bool = localPicInfo.e.equals(paramPicInfo.e);
              if (bool) {
                break label631;
              }
              try
              {
                FileUtils.copyFile(paramPicInfo.e, localPicInfo.e);
                i = 1;
                this.picList.add(localPicInfo);
                paramArrayOfByte = localPicInfo.a();
                if (paramArrayOfByte != null) {
                  ((JSONArray)localObject).put(paramArrayOfByte);
                }
                if (!QLog.isColorLevel()) {
                  break label611;
                }
                QLog.d("Q.nearby_people_card.", 2, "picInfo = " + localPicInfo);
              }
              catch (Exception paramArrayOfByte)
              {
                if (!QLog.isColorLevel()) {
                  break label631;
                }
              }
            }
            QLog.d("Q.nearby_people_card.", 2, "copy videoHead exception:" + paramArrayOfByte.getMessage());
            break label631;
          }
          else
          {
            if ((!this.videoHeadFlag) && (i != 0))
            {
              this.videoHeadFlag = true;
              if (QLog.isColorLevel()) {
                QLog.d("Q.nearby_people_card.", 2, "rsp_5ea,set videoHeadFlag true");
              }
            }
            if (((JSONArray)localObject).length() <= 0) {}
            for (paramArrayOfByte = "";; paramArrayOfByte = ((JSONArray)localObject).toString())
            {
              this.picInfo = paramArrayOfByte;
              return this.picList;
            }
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          if ((awkq.a) && (QLog.isColorLevel())) {
            QLog.d("Q.nearby_people_card.", 2, "rsp_5ea" + paramArrayOfByte.toString());
          }
          this.picInfo = "";
          continue;
          continue;
          label611:
          continue;
          paramArrayOfByte = null;
          continue;
          label619:
          int j = -1;
          continue;
          label625:
          paramArrayOfByte = "";
          continue;
          label631:
          int i = 1;
        }
      }
    }
  }
  
  public void updateHotChatInfo(HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {
      this.hotInfo = null;
    }
    for (;;)
    {
      return;
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
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.nearby_people_card.", 2, "convertHotChatInfo2Json : " + paramHotChatInfo.toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.nearby_people_card.", 2, "convertHotChatInfo2Json error.");
          }
        }
      }
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
      if (paramString.has("troopCode")) {
        this.hotInfo.troopCode = paramString.getString("troopCode");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.", 2, "convert2HotChatInfoFromJson error.");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.", 2, "convert2HotChatInfoFromJson: " + this.hotInfo);
    }
  }
  
  public void updateInterestTags(long paramLong, List<appoint_define.InterestTag> paramList)
  {
    this.tagFlag = paramLong;
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (this.interestTags != null) {
        this.interestTags.clear();
      }
      if ((this.interestTags != null) && (this.interestTags.size() != 0)) {
        break label254;
      }
      this.tagInfo = "";
    }
    for (;;)
    {
      if (QLog.isDevelopLevel())
      {
        paramList = new StringBuilder();
        paramList.append("updateInterestTags,");
        if ((this.interestTags != null) && (this.interestTags.size() > 0))
        {
          paramList.append(this.interestTags.size()).append(", {");
          Object localObject1 = this.interestTags.iterator();
          for (;;)
          {
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label357;
              }
              paramList.append(((awoe)((Iterator)localObject1).next()).toString()).append(",");
              continue;
              if (this.interestTags == null) {
                this.interestTags = new ArrayList(paramList.size());
              }
              for (;;)
              {
                paramList = paramList.iterator();
                while (paramList.hasNext())
                {
                  localObject1 = awoe.a((appoint_define.InterestTag)paramList.next());
                  if (localObject1 != null) {
                    this.interestTags.add(localObject1);
                  }
                }
                break;
                this.interestTags.clear();
              }
              try
              {
                label254:
                paramList = new JSONArray();
                localObject1 = this.interestTags.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  Object localObject2 = (awoe)((Iterator)localObject1).next();
                  if ((localObject2 != null) && (((awoe)localObject2).jdField_a_of_type_JavaUtilArrayList.size() != 0))
                  {
                    localObject2 = ((awoe)localObject2).a();
                    if (localObject2 != null) {
                      paramList.put(localObject2);
                    }
                  }
                }
              }
              catch (OutOfMemoryError paramList)
              {
                System.gc();
                this.tagInfo = "";
              }
            }
            this.tagInfo = paramList.toString();
            break;
          }
          label357:
          paramList.append("}");
        }
        QLog.i("InterestTag", 4, paramList.toString());
      }
    }
  }
  
  public void updateInterestTags(List<appoint_define.InterestTag> paramList)
  {
    updateInterestTags(this.tagFlag, paramList);
  }
  
  public void updateLastGameInfo(RespLastGameInfo paramRespLastGameInfo)
  {
    if ((paramRespLastGameInfo == null) || (paramRespLastGameInfo.iResult != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SummaryCard", 2, "handleGetSummaryCard|updateLastGameInfo|info = null or info.iResult != 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SummaryCard", 2, "updateLastGameInfo|info.bShowGameLogo = " + paramRespLastGameInfo.bShowGameLogo + "|info.bNative = " + paramRespLastGameInfo.bNative + "|info.sLogoUrl = " + paramRespLastGameInfo.sLogoUrl);
    }
    if (paramRespLastGameInfo.bShowGameLogo)
    {
      this.nLastGameFlag |= 0x1;
      if (paramRespLastGameInfo.bNative) {}
      for (this.nLastGameFlag |= 0x2;; this.nLastGameFlag &= 0xFFFFFFFD)
      {
        this.strProfileUrl = paramRespLastGameInfo.sProfileUrl;
        return;
      }
    }
    this.nLastGameFlag &= 0xFFFFFFFE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.NearbyPeopleCard
 * JD-Core Version:    0.7.0.1
 */