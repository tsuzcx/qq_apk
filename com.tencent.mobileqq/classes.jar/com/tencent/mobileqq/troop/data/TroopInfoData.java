package com.tencent.mobileqq.troop.data;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupSchoolInfo;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.GroupInfoExt;

public class TroopInfoData
  implements Serializable
{
  public static final int FLAG_EXT4_PRETTY_GROUP = 1;
  public static final int FLAG_EXT4_SUPER_PRETTY_GROUP = 2;
  public static final int FREZEE_REASON_PRETTY_TROOP_FLAG = 2;
  public static final int INVITE_MODE_ANYONE_ENTRY_WITHOUT_REVIEW = 5;
  public static final int INVITE_MODE_ANYONE_ENTRY_WITH_PAYMENT = 6;
  public static final int INVITE_MODE_ENABLE_INVATE_WITHOUT_REVIEW = 2;
  public static final int INVITE_MODE_ENABLE_INVATE_WITHOUT_REVIEW_MEM_COUNT_IN_100 = 8;
  public static final int INVITE_MODE_ENABLE_INVATE_WITHOUT_REVIEW_MEM_COUNT_IN_50 = 7;
  public static final int INVITE_MODE_ENABLE_INVATE_WITH_REVIEW = 3;
  public static final int INVITE_MODE_NO_ENTRY = 4;
  public static final int INVITE_MODE_UNABLE_INVATE = 1;
  public static final int MEMBER_POWER_EXPAND = 1;
  public static final String TAG = "TroopInfoData";
  public String Administrator;
  public int allowMemberAtAll;
  public int allowMemberKick;
  public int allowMemberModifTroopName;
  public boolean bAdmin;
  public boolean bOwner;
  public short cGroupOption;
  public byte cGroupRankSysFlag = 0;
  public int cityId;
  public String currentTroopLocationStruct = "";
  public long dwAuthGroupType = 0L;
  public long dwGroupClassExt = -1L;
  public long dwGroupFlagExt = 0L;
  public int grade;
  public long groupAllianceid = 0L;
  public int groupFlagExt4;
  public int groupFreezeReason;
  public boolean hasSetNewTroopHead;
  public boolean hasSetNewTroopName;
  public int inviteMode;
  public String inviteModeDescription;
  public boolean isMember;
  public boolean isNewTroop;
  public boolean isOnlyTroopMemberInvite;
  public boolean isQidianPrivateTroop;
  public int isShowInNearbyTroops = -1;
  public boolean isUseClassAvatar;
  public String location;
  public int mIsFreezed;
  public boolean mMemberInvitingFlag;
  public int mNewGroupActivityNum = 0;
  public int mNewTroopNotificationNum = 0;
  public long mPoiId;
  public String mRichFingerMemo;
  public String mStrJoinAnswer;
  public String mStrJoinQuestion;
  public String mTroopClassExtText;
  public long mTroopCreateTime;
  public TroopInfoExt mTroopInfoExtObj = new TroopInfoExt();
  public float mTroopNeedPayNumber = 0.0F;
  public int mTroopPrivilegeFlag = 0;
  public int modifyCount = 5;
  public int nActiveMemberNum;
  public int nGroupFlagExt;
  public int nNewFileMsgNum = 0;
  public int nNewPhotoNum = 0;
  public int nStatOption;
  public int nTroopGrade;
  public int nTroopMask;
  public int nTroopMaskToSet;
  public int nUnreadFileMsgnum = 0;
  public int nUnreadMsgNum = 0;
  private int nViewExtraFlag;
  public String newTroopName;
  public int pa;
  public long publicAccountUin;
  public String remark;
  public String school;
  public long tribeId;
  public String tribeName;
  public int tribeStatus;
  public String troopAuthen;
  public String troopAuthenticateInfo;
  public String troopCard;
  public String troopClass;
  public String troopCode;
  public String troopColorNick;
  public int troopColorNickId;
  public long troopInterestId;
  public String troopInterestName;
  public String troopIntro;
  public int troopLat = 0;
  public String troopLocation;
  public int troopLon = 0;
  public int troopMemberMaxNum;
  public String troopMemo;
  public String troopName;
  public String troopOwnerNick;
  public List<String> troopPhotos;
  public List<String> troopTags;
  public int troopTypeExt = -1;
  public String troopUin;
  public short troopface;
  public String troopowneruin;
  public int wMemberNum;
  
  public TroopInfoData()
  {
    this.nViewExtraFlag |= 0x4;
    this.nViewExtraFlag |= 0x2;
  }
  
  public boolean canInviteMember()
  {
    return (this.bOwner) || (this.bAdmin) || (this.mMemberInvitingFlag);
  }
  
  public boolean checkFlagExt4(int paramInt)
  {
    return (paramInt & this.groupFlagExt4) > 0;
  }
  
  public boolean checkFreezeReason(int paramInt)
  {
    return (paramInt & this.groupFreezeReason) > 0;
  }
  
  public void coverFrom(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo.uint32_group_grade.has()) {
      this.nTroopGrade = paramGroupInfo.uint32_group_grade.get();
    }
    if (paramGroupInfo.rpt_tag_record.has()) {
      this.troopTags = TroopInfo.getTags(TroopInfo.setTags(paramGroupInfo.rpt_tag_record.get()));
    }
    if (paramGroupInfo.uint32_group_member_max_num.has()) {
      this.troopMemberMaxNum = paramGroupInfo.uint32_group_member_max_num.get();
    }
    if (paramGroupInfo.uint32_active_member_num.has()) {
      this.nActiveMemberNum = paramGroupInfo.uint32_active_member_num.get();
    }
    if (paramGroupInfo.uint32_group_flag_ext.has()) {
      this.dwGroupFlagExt = paramGroupInfo.uint32_group_flag_ext.get();
    }
    if (paramGroupInfo.uint32_certification_type.has()) {
      this.dwAuthGroupType = paramGroupInfo.uint32_certification_type.get();
    }
    if (paramGroupInfo.string_certification_text.has()) {
      this.troopAuthenticateInfo = paramGroupInfo.string_certification_text.get().toStringUtf8();
    }
    if (paramGroupInfo.uint32_group_class_ext.has()) {
      this.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
    }
    if (paramGroupInfo.uint32_group_member_num.has()) {
      this.wMemberNum = paramGroupInfo.uint32_group_member_num.get();
    }
    if (paramGroupInfo.uint32_group_type_flag.has()) {
      this.troopTypeExt = paramGroupInfo.uint32_group_type_flag.get();
    }
    if (paramGroupInfo.uint32_app_privilege_flag.has()) {
      this.mTroopPrivilegeFlag = paramGroupInfo.uint32_app_privilege_flag.get();
    }
    if (paramGroupInfo.uint64_subscription_uin.has()) {
      this.publicAccountUin = paramGroupInfo.uint64_subscription_uin.get();
    }
    boolean bool1 = paramGroupInfo.uint32_group_flagext3.has();
    boolean bool2 = false;
    if (bool1)
    {
      if ((paramGroupInfo.uint32_group_flagext3.get() & 0x4) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.isOnlyTroopMemberInvite = bool1;
      if ((paramGroupInfo.uint32_group_flagext3.get() & 0x20) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.isQidianPrivateTroop = bool1;
    }
    if (paramGroupInfo.uint32_is_conf_group.has())
    {
      if (paramGroupInfo.uint32_is_conf_group.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.isNewTroop = bool1;
    }
    if (paramGroupInfo.uint32_is_modify_conf_group_face.has())
    {
      if (paramGroupInfo.uint32_is_modify_conf_group_face.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.hasSetNewTroopHead = bool1;
    }
    if (paramGroupInfo.uint32_is_modify_conf_group_name.has())
    {
      if (paramGroupInfo.uint32_is_modify_conf_group_name.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.hasSetNewTroopName = bool1;
    }
    bool1 = bool2;
    if (!this.isNewTroop)
    {
      bool1 = bool2;
      if ((this.dwGroupFlagExt & 0x20000) != 0L) {
        bool1 = true;
      }
    }
    this.isUseClassAvatar = bool1;
    QLog.isColorLevel();
    if ((paramGroupInfo.st_group_ex_info.has()) && (paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.has())) {
      this.mTroopNeedPayNumber = (paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.get() * 0.01F);
    }
    if (paramGroupInfo.string_group_class_text.has()) {
      this.mTroopClassExtText = paramGroupInfo.string_group_class_text.get().toStringUtf8();
    }
    Object localObject1;
    Object localObject2;
    if (paramGroupInfo.group_geo_info.has())
    {
      localObject1 = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
      if (((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.has())
      {
        localObject2 = ((oidb_0x88d.GroupGeoInfo)localObject1).bytes_geocontent.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.troopLocation = ((String)localObject2);
        }
      }
      int i;
      if (((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.has())
      {
        i = (int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_latitude.get();
        if (i != 0) {
          this.troopLat = i;
        }
      }
      if (((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.has())
      {
        i = (int)((oidb_0x88d.GroupGeoInfo)localObject1).int64_longitude.get();
        if (i != 0) {
          this.troopLon = i;
        }
      }
      if (((oidb_0x88d.GroupGeoInfo)localObject1).uint32_cityid.has()) {
        this.cityId = ((oidb_0x88d.GroupGeoInfo)localObject1).uint32_cityid.get();
      }
    }
    if (paramGroupInfo.string_group_finger_memo.has()) {
      this.troopIntro = paramGroupInfo.string_group_finger_memo.get().toStringUtf8();
    } else {
      this.troopIntro = "";
    }
    if (paramGroupInfo.bytes_group_school_info.has())
    {
      localObject1 = new oidb_0x89a.GroupSchoolInfo();
      try
      {
        localObject2 = (oidb_0x89a.GroupSchoolInfo)((oidb_0x89a.GroupSchoolInfo)localObject1).mergeFrom(paramGroupInfo.bytes_group_school_info.get().toByteArray());
        localObject1 = localObject2;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      if (((oidb_0x89a.GroupSchoolInfo)localObject1).bytes_location.has()) {
        this.location = ((oidb_0x89a.GroupSchoolInfo)localObject1).bytes_location.get().toStringUtf8();
      }
      if (((oidb_0x89a.GroupSchoolInfo)localObject1).uint32_grade.has()) {
        this.grade = ((oidb_0x89a.GroupSchoolInfo)localObject1).uint32_grade.get();
      }
      if (((oidb_0x89a.GroupSchoolInfo)localObject1).bytes_school.has()) {
        this.school = ((oidb_0x89a.GroupSchoolInfo)localObject1).bytes_school.get().toStringUtf8();
      }
    }
    if (paramGroupInfo.string_group_rich_finger_memo.has()) {
      this.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
    } else {
      this.mRichFingerMemo = "";
    }
    if (TextUtils.isEmpty(this.mRichFingerMemo))
    {
      this.mRichFingerMemo = this.troopIntro;
    }
    else
    {
      this.mRichFingerMemo = HttpUtil.removeHtmlTags(this.mRichFingerMemo);
      this.mRichFingerMemo = HttpUtil.unEscape(this.mRichFingerMemo);
    }
    if (paramGroupInfo.uint32_group_create_time.has()) {
      this.mTroopCreateTime = paramGroupInfo.uint32_group_create_time.get();
    }
    if (paramGroupInfo.uint32_group_flag_ext.has()) {
      this.nGroupFlagExt = paramGroupInfo.uint32_group_flag_ext.get();
    }
    if (paramGroupInfo.uint64_group_owner.has())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramGroupInfo.uint64_group_owner.get());
      this.troopowneruin = ((StringBuilder)localObject1).toString();
    }
    if (paramGroupInfo.string_long_group_name.has())
    {
      localObject1 = paramGroupInfo.string_long_group_name.get().toStringUtf8();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.troopName = ((String)localObject1);
        if ((this.newTroopName == null) || (!this.isNewTroop) || (this.hasSetNewTroopName)) {
          this.newTroopName = this.troopName;
        }
      }
      else
      {
        QLog.e("TroopInfoData", 1, "string_long_group_name is empty");
      }
    }
    if ((paramGroupInfo.string_group_name.has()) && (TextUtils.isEmpty(this.troopName)))
    {
      this.troopName = paramGroupInfo.string_group_name.get().toStringUtf8();
      if (this.newTroopName == null) {
        this.newTroopName = this.troopName;
      }
    }
    this.allowMemberModifTroopName = paramGroupInfo.uint32_is_allow_conf_group_member_modify_group_name.get();
    this.allowMemberKick = paramGroupInfo.uint32_is_allow_conf_group_member_nick.get();
    this.allowMemberAtAll = paramGroupInfo.uint32_is_allow_conf_group_member_at_all.get();
    if (paramGroupInfo.uint32_is_group_freeze.has()) {
      this.mIsFreezed = paramGroupInfo.uint32_is_group_freeze.get();
    }
    this.groupFlagExt4 = paramGroupInfo.uint32_group_flagext4.get();
    this.groupFreezeReason = paramGroupInfo.uint32_group_freeze_reason.get();
    if (paramGroupInfo.uint64_alliance_id.has()) {
      this.groupAllianceid = paramGroupInfo.uint64_alliance_id.get();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("coverFrom(), troopUin: ");
      ((StringBuilder)localObject1).append(this.troopUin);
      ((StringBuilder)localObject1).append(" groupAllianceid = ");
      ((StringBuilder)localObject1).append(this.groupAllianceid);
      QLog.i("TroopInfoData", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramGroupInfo.st_group_info_ext.has()) {
      this.mTroopInfoExtObj = TroopInfoExt.parseFromGroupInfoExt((oidb_0xef0.GroupInfoExt)paramGroupInfo.st_group_info_ext.get());
    }
  }
  
  public int getFansTroopStarId()
  {
    TroopInfoExt localTroopInfoExt = this.mTroopInfoExtObj;
    if (localTroopInfoExt != null) {
      return localTroopInfoExt.starId;
    }
    return 0;
  }
  
  public String getInviteModeDesWording(TroopInfo paramTroopInfo, Resources paramResources)
  {
    String str2 = "";
    String str1 = str2;
    if (paramTroopInfo != null)
    {
      if (paramResources == null) {
        return "";
      }
      if ((paramTroopInfo.troopPrivilegeFlag & 0x6100000) == 0L) {
        return paramResources.getString(2131696498);
      }
      if (((paramTroopInfo.troopPrivilegeFlag & 0x2000000) != 33554432L) && ((paramTroopInfo.troopPrivilegeFlag & 0x4000000) != 67108864L))
      {
        str1 = str2;
        if ((paramTroopInfo.troopPrivilegeFlag & 0x100000) != 1048576L) {}
      }
      else
      {
        str1 = paramResources.getString(2131696499);
      }
    }
    return str1;
  }
  
  public ArrayList<String> getQZonePhotoUrls(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && (paramTroopInfo.strQZonePhotoUrls != null))
    {
      String[] arrayOfString = paramTroopInfo.strQZonePhotoUrls.split(";");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        for (;;)
        {
          paramTroopInfo = localArrayList;
          if (i >= arrayOfString.length) {
            break;
          }
          if ((arrayOfString[i] != null) && (arrayOfString[i].length() > 0)) {
            localArrayList.add(arrayOfString[i]);
          }
          i += 1;
        }
      }
    }
    paramTroopInfo = null;
    return paramTroopInfo;
  }
  
  public int getStatOption()
  {
    if (this.nStatOption == 0)
    {
      int i = this.pa;
      if (i != 2)
      {
        if (i != 23)
        {
          if (i != 27)
          {
            if (i != 32)
            {
              if (i != 4)
              {
                if (i != 5)
                {
                  if (i != 6)
                  {
                    if (i != 10)
                    {
                      if (i != 11)
                      {
                        if (i != 34)
                        {
                          if (i != 35)
                          {
                            if (i != 112)
                            {
                              if (i != 113) {
                                switch (i)
                                {
                                default: 
                                  switch (i)
                                  {
                                  default: 
                                    switch (i)
                                    {
                                    default: 
                                      break;
                                    case 30001: 
                                    case 30002: 
                                    case 30003: 
                                    case 30004: 
                                    case 30005: 
                                    case 30006: 
                                    case 30007: 
                                    case 30008: 
                                    case 30009: 
                                    case 30010: 
                                    case 30011: 
                                    case 30012: 
                                    case 30013: 
                                    case 30014: 
                                    case 30015: 
                                    case 30016: 
                                    case 30017: 
                                    case 30018: 
                                    case 30019: 
                                    case 30020: 
                                      this.nStatOption = i;
                                    }
                                    break;
                                  case 110: 
                                    this.nStatOption = 10026;
                                    break;
                                  case 109: 
                                    this.nStatOption = 10022;
                                    break;
                                  case 108: 
                                    this.nStatOption = 10020;
                                    break;
                                  case 107: 
                                    this.nStatOption = 10018;
                                    break;
                                  case 106: 
                                    this.nStatOption = 10013;
                                    break;
                                  case 105: 
                                    this.nStatOption = 10012;
                                    break;
                                  case 104: 
                                    this.nStatOption = 10011;
                                    break;
                                  case 103: 
                                    this.nStatOption = 10010;
                                    break;
                                  case 102: 
                                    this.nStatOption = 10008;
                                    break;
                                  case 101: 
                                    this.nStatOption = 10009;
                                  }
                                  break;
                                case 21: 
                                  this.nStatOption = 10003;
                                  break;
                                case 20: 
                                  this.nStatOption = 13;
                                  break;
                                case 19: 
                                  this.nStatOption = 26;
                                  break;
                                case 18: 
                                  this.nStatOption = 24;
                                  break;
                                case 17: 
                                  this.nStatOption = 10001;
                                  break;
                                case 16: 
                                  this.nStatOption = 18;
                                  break;
                                case 15: 
                                  this.nStatOption = 10;
                                  break;
                                case 14: 
                                  this.nStatOption = 19;
                                  break;
                                }
                              } else {
                                this.nStatOption = 10032;
                              }
                            }
                            else {
                              this.nStatOption = 10033;
                            }
                          }
                          else {
                            this.nStatOption = 10004;
                          }
                        }
                        else {
                          this.nStatOption = 85;
                        }
                      }
                      else {
                        this.nStatOption = 12;
                      }
                    }
                    else {
                      this.nStatOption = 11;
                    }
                  }
                  else {
                    this.nStatOption = 3;
                  }
                }
                else {
                  this.nStatOption = 21;
                }
              }
              else {
                this.nStatOption = 10015;
              }
            }
            else {
              this.nStatOption = 38;
            }
          }
          else {
            this.nStatOption = 10002;
          }
        }
        else {
          this.nStatOption = 30;
        }
      }
      else {
        this.nStatOption = 31;
      }
    }
    return this.nStatOption;
  }
  
  public String getTroopOwnerName()
  {
    String str1;
    if (!TextUtils.isEmpty(this.troopOwnerNick)) {
      str1 = this.troopOwnerNick;
    } else {
      str1 = this.troopowneruin;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = "";
    }
    return str2;
  }
  
  public boolean hasTroopAssociation()
  {
    return this.groupAllianceid != 0L;
  }
  
  public boolean isFansTroop()
  {
    return this.dwGroupClassExt == 27L;
  }
  
  public boolean isFetchedTroopOwnerUin()
  {
    return TextUtils.isEmpty(this.troopowneruin) ^ true;
  }
  
  public boolean isGameTroop()
  {
    return this.dwGroupClassExt == 25L;
  }
  
  public boolean isHideTroop()
  {
    return (this.dwGroupFlagExt & 0x10000000) == 268435456L;
  }
  
  public boolean isHomeworkTroop()
  {
    return this.dwGroupClassExt == 32L;
  }
  
  public boolean isOwnerOrAdim()
  {
    return (this.bOwner) || (this.bAdmin);
  }
  
  public boolean isPhotoAndFileVisible()
  {
    int i = this.nGroupFlagExt;
    return ((0x80000 & i) != 0) || ((i & 0x4000) != 0);
  }
  
  public boolean isShowActivityGrade()
  {
    return (this.dwGroupFlagExt & 0x800000) == 8388608L;
  }
  
  public boolean isShowInNearbyTroops()
  {
    int i = this.isShowInNearbyTroops;
    if (i == -1) {
      return (this.dwGroupFlagExt & 0x8000000) != 134217728L;
    }
    return i == 0;
  }
  
  public boolean isTroopAPPVisible()
  {
    return (this.nViewExtraFlag & 0x8) == 8;
  }
  
  public boolean isTroopBBSVisible()
  {
    return (this.nViewExtraFlag & 0x1) == 1;
  }
  
  public boolean isTroopFileVisible()
  {
    return (this.nViewExtraFlag & 0x2) == 2;
  }
  
  public boolean isTroopPhotosVisible()
  {
    return (this.nViewExtraFlag & 0x4) == 4;
  }
  
  public void setTroopAppVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nViewExtraFlag |= 0x8;
      return;
    }
    this.nViewExtraFlag &= 0xFFFFFFF7;
  }
  
  public void setTroopBBSVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nViewExtraFlag |= 0x1;
      return;
    }
    this.nViewExtraFlag &= 0xFFFFFFFE;
  }
  
  public void setTroopFileVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nViewExtraFlag |= 0x2;
      return;
    }
    this.nViewExtraFlag &= 0xFFFFFFFD;
  }
  
  public void updateAdminFlag(String paramString)
  {
    this.bAdmin = paramString.equals(this.troopowneruin);
    if ((!this.bAdmin) && (!TextUtils.isEmpty(this.Administrator)))
    {
      String[] arrayOfString = this.Administrator.split("\\|");
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramString))
          {
            this.bAdmin = true;
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void updateForTroopChatSetting(TroopInfo paramTroopInfo, Resources paramResources, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateForTroopChatSetting(), troopinfo = ");
      localStringBuilder.append(paramTroopInfo);
      QLog.i("TroopInfoData", 2, localStringBuilder.toString());
    }
    long l = System.currentTimeMillis();
    if (paramTroopInfo != null)
    {
      this.troopCode = paramTroopInfo.troopcode;
      if (paramTroopInfo.troopuin != null) {
        this.troopUin = paramTroopInfo.troopuin;
      }
      this.troopface = paramTroopInfo.troopface;
      this.troopName = paramTroopInfo.troopname;
      this.newTroopName = paramTroopInfo.getNewTroopNameOrTroopName();
      this.cGroupOption = paramTroopInfo.cGroupOption;
      this.isOnlyTroopMemberInvite = paramTroopInfo.isOnlyTroopMemberInviteOption();
      this.isQidianPrivateTroop = paramTroopInfo.isQidianPrivateTroop();
      this.troopMemo = paramTroopInfo.troopmemo;
      this.troopIntro = paramTroopInfo.fingertroopmemo;
      this.location = paramTroopInfo.location;
      this.grade = paramTroopInfo.grade;
      this.school = paramTroopInfo.school;
      this.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
      if (paramTroopInfo.mGroupClassExtText != null) {
        this.mTroopClassExtText = paramTroopInfo.mGroupClassExtText;
      }
      this.mTroopCreateTime = paramTroopInfo.troopCreateTime;
      this.wMemberNum = paramTroopInfo.wMemberNum;
      this.troopMemberMaxNum = paramTroopInfo.wMemberMax;
      this.isNewTroop = paramTroopInfo.isNewTroop;
      this.hasSetNewTroopHead = paramTroopInfo.hasSetNewTroopHead;
      this.hasSetNewTroopName = paramTroopInfo.hasSetNewTroopName;
      this.isUseClassAvatar = paramTroopInfo.isUseClassAvatar();
      QLog.isColorLevel();
      this.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
      this.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      this.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      this.mTroopNeedPayNumber = paramTroopInfo.mTroopNeedPayNumber;
      this.publicAccountUin = paramTroopInfo.associatePubAccount;
      this.allowMemberAtAll = paramTroopInfo.allowMemberAtAll;
      this.allowMemberModifTroopName = paramTroopInfo.allowMemberModifTroopName;
      this.allowMemberKick = paramTroopInfo.allowMemberKick;
      int i;
      int j;
      if ((TroopInfo.hasPayPrivilege(paramTroopInfo.troopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(paramTroopInfo.troopPrivilegeFlag, 512)))
      {
        this.troopAuthen = paramResources.getString(2131719926);
        i = 6;
      }
      else if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        this.troopAuthen = paramResources.getString(2131719917);
        this.dwGroupFlagExt |= 0x80;
        i = 0;
      }
      else
      {
        i = paramTroopInfo.cGroupOption;
        j = paramTroopInfo.cGroupOption;
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j == 5) {
                  this.troopAuthen = paramResources.getString(2131719919);
                }
              }
              else {
                this.troopAuthen = paramResources.getString(2131719920);
              }
            }
            else {
              this.troopAuthen = paramResources.getString(2131719925);
            }
          }
          else {
            this.troopAuthen = paramResources.getString(2131719923);
          }
        }
        else {
          this.troopAuthen = paramResources.getString(2131719918);
        }
      }
      if (!Utils.a(this.troopowneruin, paramTroopInfo.troopowneruin))
      {
        this.troopowneruin = paramTroopInfo.troopowneruin;
        this.troopOwnerNick = null;
        updateOwnerFlag(paramString);
      }
      if (!Utils.a(this.Administrator, paramTroopInfo.Administrator))
      {
        this.Administrator = paramTroopInfo.Administrator;
        updateAdminFlag(paramString);
      }
      if ((!this.bOwner) && ((paramTroopInfo.dwAdditionalFlag & 1L) == 1L)) {
        this.bOwner = true;
      }
      if ((!this.bAdmin) && ((paramTroopInfo.dwCmdUinUinFlag & 1L) == 1L)) {
        this.bAdmin = true;
      }
      this.mMemberInvitingFlag = paramTroopInfo.mMemberInvitingFlag;
      this.troopface = paramTroopInfo.troopface;
      this.cGroupRankSysFlag = paramTroopInfo.cGroupRankSysFlag;
      if ((paramTroopInfo.dwGroupFlagExt & 0x80) == 0L) {
        j = 1;
      } else {
        j = 0;
      }
      if (i == 3)
      {
        this.inviteModeDescription = paramResources.getString(2131696500);
        this.inviteMode = 4;
      }
      else if (i == 1)
      {
        this.inviteModeDescription = paramResources.getString(2131696497);
        this.inviteMode = 5;
      }
      else if (j != 0)
      {
        if (i == 6)
        {
          this.inviteModeDescription = paramResources.getString(2131696496);
          this.inviteMode = 6;
        }
        else
        {
          this.inviteModeDescription = getInviteModeDesWording(paramTroopInfo, paramResources);
          if ((paramTroopInfo.troopPrivilegeFlag & 0x100000) == 1048576L)
          {
            this.inviteMode = 2;
          }
          else if ((paramTroopInfo.troopPrivilegeFlag & 0x6100000) == 0L)
          {
            this.inviteMode = 3;
          }
          else if ((paramTroopInfo.troopPrivilegeFlag & 0x2000000) == 33554432L)
          {
            this.inviteMode = 7;
          }
          else if ((paramTroopInfo.troopPrivilegeFlag & 0x4000000) == 67108864L)
          {
            this.inviteMode = 8;
          }
          else if (this.isOnlyTroopMemberInvite)
          {
            this.inviteMode = 8;
            this.inviteModeDescription = paramResources.getString(2131696499);
          }
        }
      }
      else
      {
        this.inviteModeDescription = paramResources.getString(2131696501);
        this.inviteMode = 1;
      }
      if (paramTroopInfo.cAlbumResult == 33) {
        this.nViewExtraFlag &= 0xFFFFFFFB;
      } else {
        this.nViewExtraFlag |= 0x4;
      }
      this.troopPhotos = getQZonePhotoUrls(paramTroopInfo);
      this.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.dwAuthGroupType = paramTroopInfo.dwAuthGroupType;
      this.nTroopGrade = paramTroopInfo.nTroopGrade;
      this.troopLocation = paramTroopInfo.strLocation;
      if ((paramTroopInfo.troopLat != 0) && (paramTroopInfo.troopLon != 0))
      {
        this.troopLat = paramTroopInfo.troopLat;
        this.troopLon = paramTroopInfo.troopLon;
      }
      this.mIsFreezed = paramTroopInfo.mIsFreezed;
      this.isShowInNearbyTroops = paramTroopInfo.isShowInNearbyTroops;
    }
    if (QLog.isColorLevel())
    {
      paramTroopInfo = new StringBuilder();
      paramTroopInfo.append("updateForTroopChatSetting: time = ");
      paramTroopInfo.append(System.currentTimeMillis() - l);
      QLog.i("TroopInfoData", 2, paramTroopInfo.toString());
    }
  }
  
  public void updateForTroopInfo(TroopInfo paramTroopInfo, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTroopInfoData(), troopinfo = ");
      localStringBuilder.append(paramTroopInfo);
      QLog.i("TroopInfoData", 2, localStringBuilder.toString());
    }
    long l = System.currentTimeMillis();
    if (paramTroopInfo != null)
    {
      if (paramTroopInfo.troopuin != null) {
        this.troopUin = paramTroopInfo.troopuin;
      }
      this.troopCode = paramTroopInfo.troopcode;
      this.troopface = paramTroopInfo.troopface;
      this.troopName = paramTroopInfo.troopname;
      this.newTroopName = paramTroopInfo.getNewTroopNameOrTroopName();
      this.cGroupOption = paramTroopInfo.cGroupOption;
      this.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
      this.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      this.troopMemo = paramTroopInfo.troopmemo;
      this.troopIntro = paramTroopInfo.fingertroopmemo;
      this.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.location = paramTroopInfo.location;
      this.grade = paramTroopInfo.grade;
      this.school = paramTroopInfo.school;
      if ((this.troopClass == null) || (this.dwGroupClassExt != paramTroopInfo.dwGroupClassExt))
      {
        this.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
        this.troopClass = null;
      }
      if (this.mTroopClassExtText == null) {
        this.mTroopClassExtText = paramTroopInfo.mGroupClassExtText;
      }
      this.isNewTroop = paramTroopInfo.isNewTroop;
      this.hasSetNewTroopHead = paramTroopInfo.hasSetNewTroopHead;
      this.hasSetNewTroopName = paramTroopInfo.hasSetNewTroopName;
      this.isUseClassAvatar = paramTroopInfo.isUseClassAvatar();
      QLog.isColorLevel();
      if (!Utils.a(this.troopowneruin, paramTroopInfo.troopowneruin))
      {
        this.troopowneruin = paramTroopInfo.troopowneruin;
        this.troopOwnerNick = null;
        updateOwnerFlag(paramString);
      }
      if (!Utils.a(this.Administrator, paramTroopInfo.Administrator))
      {
        this.Administrator = paramTroopInfo.Administrator;
        updateAdminFlag(paramString);
      }
      if ((!this.bOwner) && ((paramTroopInfo.dwAdditionalFlag & 1L) == 1L)) {
        this.bOwner = true;
      }
      if ((!this.bAdmin) && ((paramTroopInfo.dwCmdUinUinFlag & 1L) == 1L)) {
        this.bAdmin = true;
      }
      this.troopLocation = paramTroopInfo.strLocation;
      if ((paramTroopInfo.troopLat != 0) && (paramTroopInfo.troopLon != 0))
      {
        this.troopLat = paramTroopInfo.troopLat;
        this.troopLon = paramTroopInfo.troopLon;
      }
      this.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.dwAuthGroupType = paramTroopInfo.dwAuthGroupType;
      this.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      this.mTroopNeedPayNumber = paramTroopInfo.mTroopNeedPayNumber;
      this.troopTags = TroopInfo.getTags(paramTroopInfo.mTags);
      this.isShowInNearbyTroops = paramTroopInfo.isShowInNearbyTroops;
      this.troopTypeExt = paramTroopInfo.troopTypeExt;
      this.wMemberNum = paramTroopInfo.wMemberNum;
      this.publicAccountUin = paramTroopInfo.associatePubAccount;
      this.allowMemberKick = paramTroopInfo.allowMemberKick;
      this.allowMemberModifTroopName = paramTroopInfo.allowMemberModifTroopName;
      this.allowMemberAtAll = paramTroopInfo.allowMemberAtAll;
      this.mIsFreezed = paramTroopInfo.mIsFreezed;
    }
    if (QLog.isColorLevel())
    {
      paramTroopInfo = new StringBuilder();
      paramTroopInfo.append("updateTroopInfoData: time = ");
      paramTroopInfo.append(System.currentTimeMillis() - l);
      QLog.i("TroopInfoData", 2, paramTroopInfo.toString());
    }
  }
  
  public void updateOwnerFlag(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateOwnerFlag currentAccountUin = ");
      localStringBuilder.append(paramString);
      QLog.d("TroopInfoData", 2, localStringBuilder.toString());
    }
    this.bOwner = Utils.a(paramString, this.troopowneruin);
  }
  
  public void updateTroopAdmMemberNum(String paramString1, int paramInt, String paramString2, Resources paramResources)
  {
    this.Administrator = paramString1;
    updateAdminFlag(paramString2);
    this.wMemberNum = paramInt;
  }
  
  public void updateTroopOwner(String paramString1, String paramString2)
  {
    this.troopowneruin = paramString1;
    this.troopOwnerNick = null;
    updateAdminFlag(paramString2);
    updateOwnerFlag(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopInfoData
 * JD-Core Version:    0.7.0.1
 */