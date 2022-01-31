package com.tencent.mobileqq.troopinfo;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class TroopInfoData
  implements Serializable
{
  public static final int INVITE_MODE_ANYONE_ENTRY_WITHOUT_REVIEW = 5;
  public static final int INVITE_MODE_ANYONE_ENTRY_WITH_PAYMENT = 6;
  public static final int INVITE_MODE_ENABLE_INVATE_WITHOUT_REVIEW = 2;
  public static final int INVITE_MODE_ENABLE_INVATE_WITHOUT_REVIEW_MEM_COUNT_IN_100 = 8;
  public static final int INVITE_MODE_ENABLE_INVATE_WITHOUT_REVIEW_MEM_COUNT_IN_50 = 7;
  public static final int INVITE_MODE_ENABLE_INVATE_WITH_REVIEW = 3;
  public static final int INVITE_MODE_NO_ENTRY = 4;
  public static final int INVITE_MODE_UNABLE_INVATE = 1;
  public static final String TAG = "TroopInfoData";
  public String Administrator;
  public boolean bAdmin;
  public boolean bOwner;
  public short cGroupOption;
  public byte cGroupRankSysFlag;
  public int cityId;
  public String currentTroopLocationStruct = "";
  public long dwAuthGroupType;
  public long dwGroupClassExt = -1L;
  public long dwGroupFlagExt;
  public boolean hasSetNewTroopHead;
  public boolean hasSetNewTroopName;
  public int inviteMode;
  public String inviteModeDescription;
  public boolean isMember;
  public boolean isNewTroop;
  public boolean isOnlyTroopMemberInvite;
  public boolean isQidianPrivateTroop;
  public int isShowInNearbyTroops = -1;
  public boolean mMemberInvitingFlag;
  public int mNewGroupActivityNum;
  public int mNewTroopNotificationNum;
  public long mPoiId;
  public String mRichFingerMemo;
  public String mStrJoinAnswer;
  public String mStrJoinQuestion;
  public String mTroopClassExtText;
  public long mTroopCreateTime;
  public float mTroopNeedPayNumber = 0.0F;
  public int mTroopPrivilegeFlag;
  public int modifyCount = 5;
  public int nActiveMemberNum;
  public int nGroupFlagExt;
  public int nNewFileMsgNum;
  public int nNewPhotoNum;
  public int nStatOption;
  public int nTroopGrade;
  public int nTroopMask;
  public int nTroopMaskToSet;
  public int nUnreadFileMsgnum;
  public int nUnreadMsgNum;
  private int nViewExtraFlag;
  public String newTroopName;
  public int pa;
  public long publicAccountUin;
  public String remark;
  public long tribeId;
  public String tribeName;
  public int tribeStatus;
  public String troopAuthen;
  public String troopAuthenticateInfo;
  public String troopCard;
  public String troopClass;
  public String troopCode;
  public long troopInterestId;
  public String troopInterestName;
  public String troopIntro;
  public int troopLat;
  public String troopLocation;
  public int troopLon;
  public int troopMemberMaxNum;
  public String troopMemo;
  public String troopName;
  public String troopOwnerNick;
  public List troopPhotos;
  public List troopTags;
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
  
  public void coverFrom(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    boolean bool2 = true;
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
    boolean bool1;
    if (paramGroupInfo.uint32_group_flagext3.has())
    {
      if ((paramGroupInfo.uint32_group_flagext3.get() & 0x4) != 0)
      {
        bool1 = true;
        this.isOnlyTroopMemberInvite = bool1;
        if ((paramGroupInfo.uint32_group_flagext3.get() & 0x20) == 0) {
          break label803;
        }
        bool1 = true;
        label311:
        this.isQidianPrivateTroop = bool1;
      }
    }
    else
    {
      if (paramGroupInfo.uint32_is_conf_group.has())
      {
        if (paramGroupInfo.uint32_is_conf_group.get() != 1) {
          break label808;
        }
        bool1 = true;
        label339:
        this.isNewTroop = bool1;
      }
      if (paramGroupInfo.uint32_is_modify_conf_group_face.has())
      {
        if (paramGroupInfo.uint32_is_modify_conf_group_face.get() != 1) {
          break label813;
        }
        bool1 = true;
        label367:
        this.hasSetNewTroopHead = bool1;
      }
      if (paramGroupInfo.uint32_is_modify_conf_group_name.has())
      {
        if (paramGroupInfo.uint32_is_modify_conf_group_name.get() != 1) {
          break label818;
        }
        bool1 = bool2;
        label396:
        this.hasSetNewTroopName = bool1;
      }
      if ((paramGroupInfo.st_group_ex_info.has()) && (paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.has())) {
        this.mTroopNeedPayNumber = (paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.get() * 0.01F);
      }
      if (paramGroupInfo.string_group_class_text.has()) {
        this.mTroopClassExtText = paramGroupInfo.string_group_class_text.get().toStringUtf8();
      }
      if (paramGroupInfo.group_geo_info.has())
      {
        oidb_0x88d.GroupGeoInfo localGroupGeoInfo = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
        if (localGroupGeoInfo.bytes_geocontent.has())
        {
          String str = localGroupGeoInfo.bytes_geocontent.get().toStringUtf8();
          if (!TextUtils.isEmpty(str)) {
            this.troopLocation = str;
          }
        }
        int i;
        if (localGroupGeoInfo.int64_latitude.has())
        {
          i = (int)localGroupGeoInfo.int64_latitude.get();
          if (i != 0) {
            this.troopLat = i;
          }
        }
        if (localGroupGeoInfo.int64_longitude.has())
        {
          i = (int)localGroupGeoInfo.int64_longitude.get();
          if (i != 0) {
            this.troopLon = i;
          }
        }
        if (localGroupGeoInfo.uint32_cityid.has()) {
          this.cityId = localGroupGeoInfo.uint32_cityid.get();
        }
      }
      if (!paramGroupInfo.string_group_finger_memo.has()) {
        break label823;
      }
      this.troopIntro = paramGroupInfo.string_group_finger_memo.get().toStringUtf8();
      label634:
      if (!paramGroupInfo.string_group_rich_finger_memo.has()) {
        break label832;
      }
      this.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      label658:
      if (!TextUtils.isEmpty(this.mRichFingerMemo)) {
        break label841;
      }
    }
    for (this.mRichFingerMemo = this.troopIntro;; this.mRichFingerMemo = HttpUtil.b(this.mRichFingerMemo))
    {
      if (paramGroupInfo.uint32_group_create_time.has()) {
        this.mTroopCreateTime = paramGroupInfo.uint32_group_create_time.get();
      }
      if (paramGroupInfo.uint32_group_flag_ext.has()) {
        this.nGroupFlagExt = paramGroupInfo.uint32_group_flag_ext.get();
      }
      if (paramGroupInfo.uint64_group_owner.has()) {
        this.troopowneruin = ("" + paramGroupInfo.uint64_group_owner.get());
      }
      if (paramGroupInfo.string_group_name.has())
      {
        this.troopName = paramGroupInfo.string_group_name.get().toStringUtf8();
        if (this.newTroopName == null) {
          this.newTroopName = this.troopName;
        }
      }
      return;
      bool1 = false;
      break;
      label803:
      bool1 = false;
      break label311;
      label808:
      bool1 = false;
      break label339;
      label813:
      bool1 = false;
      break label367;
      label818:
      bool1 = false;
      break label396;
      label823:
      this.troopIntro = "";
      break label634;
      label832:
      this.mRichFingerMemo = "";
      break label658;
      label841:
      this.mRichFingerMemo = HttpUtil.c(this.mRichFingerMemo);
    }
  }
  
  public int getStatOption()
  {
    if (this.nStatOption == 0) {
      switch (this.pa)
      {
      }
    }
    for (;;)
    {
      return this.nStatOption;
      this.nStatOption = 10;
      continue;
      this.nStatOption = 11;
      continue;
      this.nStatOption = 12;
      continue;
      this.nStatOption = 26;
      continue;
      this.nStatOption = 14;
      continue;
      this.nStatOption = 19;
      continue;
      this.nStatOption = 21;
      continue;
      this.nStatOption = 31;
      continue;
      this.nStatOption = 3;
      continue;
      this.nStatOption = 24;
      continue;
      this.nStatOption = 18;
      continue;
      this.nStatOption = 13;
      continue;
      this.nStatOption = 15;
      continue;
      this.nStatOption = 30;
      continue;
      this.nStatOption = 38;
      continue;
      this.nStatOption = 85;
    }
  }
  
  public String getTroopOwnerName()
  {
    if (!TextUtils.isEmpty(this.troopOwnerNick)) {}
    for (String str1 = this.troopOwnerNick;; str1 = this.troopowneruin)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = "";
      }
      return str2;
    }
  }
  
  public boolean isFetchedTroopOwnerUin()
  {
    return !TextUtils.isEmpty(this.troopowneruin);
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
    return ((this.nGroupFlagExt & 0x80000) != 0) || ((this.nGroupFlagExt & 0x4000) != 0);
  }
  
  public boolean isShowActivityGrade()
  {
    return (this.dwGroupFlagExt & 0x800000) == 8388608L;
  }
  
  public boolean isShowInNearbyTroops()
  {
    if (this.isShowInNearbyTroops == -1) {
      if ((this.dwGroupFlagExt & 0x8000000) == 134217728L) {}
    }
    while (this.isShowInNearbyTroops == 0)
    {
      return true;
      return false;
    }
    return false;
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
    String[] arrayOfString;
    int j;
    int i;
    if ((!this.bAdmin) && (!TextUtils.isEmpty(this.Administrator)))
    {
      arrayOfString = this.Administrator.split("\\|");
      if (arrayOfString != null)
      {
        j = arrayOfString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          this.bAdmin = true;
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void updateForTroopChatSetting(TroopInfo paramTroopInfo, Resources paramResources, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfoData", 2, "updateTroopInfoData(), troopinfo = " + paramTroopInfo);
    }
    long l = System.currentTimeMillis();
    int i;
    int j;
    if (paramTroopInfo != null)
    {
      this.troopCode = paramTroopInfo.troopcode;
      if (paramTroopInfo.troopuin != null) {
        this.troopUin = paramTroopInfo.troopuin;
      }
      this.troopface = paramTroopInfo.troopface;
      this.troopName = paramTroopInfo.troopname;
      this.newTroopName = paramTroopInfo.getTroopName();
      this.cGroupOption = paramTroopInfo.cGroupOption;
      this.isOnlyTroopMemberInvite = paramTroopInfo.isOnlyTroopMemberInviteOption();
      this.isQidianPrivateTroop = paramTroopInfo.isQidianPrivateTroop();
      this.troopMemo = paramTroopInfo.troopmemo;
      this.troopIntro = paramTroopInfo.fingertroopmemo;
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
      this.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
      this.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      this.mTroopPrivilegeFlag = ((int)paramTroopInfo.troopPrivilegeFlag);
      this.mTroopNeedPayNumber = paramTroopInfo.mTroopNeedPayNumber;
      this.publicAccountUin = paramTroopInfo.associatePubAccount;
      i = 0;
      if ((!TroopInfo.hasPayPrivilege(paramTroopInfo.troopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(paramTroopInfo.troopPrivilegeFlag, 512))) {
        break label603;
      }
      this.troopAuthen = paramResources.getString(2131433679);
      i = 6;
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
      if ((paramTroopInfo.dwGroupFlagExt & 0x80) != 0L) {
        break label753;
      }
      j = 1;
      label437:
      if (i != 3) {
        break label759;
      }
      this.inviteModeDescription = paramResources.getString(2131430173);
      this.inviteMode = 4;
      label459:
      if (paramTroopInfo.cAlbumResult != 33) {
        break label963;
      }
    }
    label963:
    for (this.nViewExtraFlag &= 0xFFFFFFFB;; this.nViewExtraFlag |= 0x4)
    {
      this.troopPhotos = paramTroopInfo.getQZonePhotoUrls();
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
      this.isShowInNearbyTroops = paramTroopInfo.isShowInNearbyTroops;
      if (QLog.isColorLevel()) {
        QLog.i("TroopInfoData", 2, "updateTroopInfoData: time = " + (System.currentTimeMillis() - l));
      }
      return;
      label603:
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        this.troopAuthen = paramResources.getString(2131433680);
        this.dwGroupFlagExt |= 0x80;
        break;
      }
      i = paramTroopInfo.cGroupOption;
      switch (paramTroopInfo.cGroupOption)
      {
      default: 
        break;
      case 1: 
        this.troopAuthen = paramResources.getString(2131433676);
        break;
      case 2: 
        this.troopAuthen = paramResources.getString(2131433678);
        break;
      case 4: 
        this.troopAuthen = paramResources.getString(2131433682);
        break;
      case 5: 
        this.troopAuthen = paramResources.getString(2131433683);
        break;
      case 3: 
        this.troopAuthen = paramResources.getString(2131433681);
        break;
        label753:
        j = 0;
        break label437;
        label759:
        if (i == 1)
        {
          this.inviteModeDescription = paramResources.getString(2131430174);
          this.inviteMode = 5;
          break label459;
        }
        if (j != 0)
        {
          if (i == 6)
          {
            this.inviteModeDescription = paramResources.getString(2131430175);
            this.inviteMode = 6;
            break label459;
          }
          this.inviteModeDescription = paramTroopInfo.getInviteModeDesWording(paramResources);
          if ((paramTroopInfo.troopPrivilegeFlag & 0x100000) == 1048576L)
          {
            this.inviteMode = 2;
            break label459;
          }
          if ((paramTroopInfo.troopPrivilegeFlag & 0x6100000) == 0L)
          {
            this.inviteMode = 3;
            break label459;
          }
          if ((paramTroopInfo.troopPrivilegeFlag & 0x2000000) == 33554432L)
          {
            this.inviteMode = 7;
            break label459;
          }
          if ((paramTroopInfo.troopPrivilegeFlag & 0x4000000) == 67108864L)
          {
            this.inviteMode = 8;
            break label459;
          }
          if (!this.isOnlyTroopMemberInvite) {
            break label459;
          }
          this.inviteMode = 8;
          this.inviteModeDescription = paramResources.getString(2131430171);
          break label459;
        }
        this.inviteModeDescription = paramResources.getString(2131430170);
        this.inviteMode = 1;
        break label459;
      }
    }
  }
  
  public void updateForTroopInfo(TroopInfo paramTroopInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfoData", 2, "updateTroopInfoData(), troopinfo = " + paramTroopInfo);
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
      this.newTroopName = paramTroopInfo.getTroopName();
      this.cGroupOption = paramTroopInfo.cGroupOption;
      this.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
      this.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      this.troopMemo = paramTroopInfo.troopmemo;
      this.troopIntro = paramTroopInfo.fingertroopmemo;
      this.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
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
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfoData", 2, "updateTroopInfoData: time = " + (System.currentTimeMillis() - l));
    }
  }
  
  public void updateOwnerFlag(String paramString)
  {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troopinfo.TroopInfoData
 * JD-Core Version:    0.7.0.1
 */