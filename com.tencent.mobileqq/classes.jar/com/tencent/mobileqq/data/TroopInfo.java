package com.tencent.mobileqq.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.qphone.base.util.QLog;
import friendlist.stLevelRankPair;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x787.oidb_0x787.LevelName;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortraitInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopInfo
  extends Entity
  implements Serializable
{
  public static final int ALLOW_UPLOAD_TROOP_ALBUM = 1;
  public static final int ALLOW_UPLOAD_TROOP_FILE = 2;
  public static final int CONFESS_TALK_OPEN_FLAG = 8192;
  public static final int DEL_PIC_REQ = 2;
  public static final int GROUP_CLASS_EXT_TYPE_CLASSMATES = 10011;
  public static final int GROUP_CLASS_EXT_TYPE_GAME = 25;
  public static final int GROUP_CLASS_EXT_TYPE_HOMEWORK = 32;
  public static final int GROUP_CLASS_EXT_TYPE_IGNORE = 0;
  public static final int GROUP_CLASS_EXT_TYPE_OFFICIAL = 10012;
  public static final int GROUP_CLASS_EXT_TYPE_RELATIVES = 10010;
  public static final int GROUP_CLASS_EXT_TYPE_WORKMATES = 10009;
  public static final int MODIFY_ORDER = 0;
  public static final int ONLY_TROOP_MEMBER_INVITE_JOIN_TROOP = 4;
  public static final int PAY_CHOICE_PAY_TO_JOIN_TROOP = 512;
  public static final int PAY_PRIVILEGE_ALL = 448;
  public static final int PAY_PRIVILEGE_DELIVER_GIFT = 32;
  public static final int PAY_PRIVILEGE_GIFT_SETTLEMENT_ABILITY = 256;
  public static final int PAY_PRIVILEGE_GROUP_FEE = 64;
  public static final int PAY_PRIVILEGE_PAY_TO_JOIN_TROOP = 128;
  public static final int QIDIAN_PRIVATE_TROOP_FLAG = 32;
  public static final String QIDIAN_TROOP_MEMBER_DEF_NICK = "群成员";
  public static final int SET_DEFAULT_PIC = 1;
  public static final String TABLE_NAME = "TroopInfoV2";
  public static final int TROOP_GAME_BIND = 2048;
  public static final int TROOP_PRIVILEGE_INVITE_NEED_REVIEW = 101711872;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW = 1048576;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_100 = 67108864;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_50 = 33554432;
  public String Administrator;
  public String adminNameShow;
  public long associatePubAccount;
  public byte cAlbumResult;
  public short cGroupLevel;
  public short cGroupOption;
  public byte cGroupRankSysFlag;
  public byte cGroupRankUserFlag;
  public long dwAdditionalFlag;
  public long dwAppPrivilegeFlag;
  public long dwAuthGroupType;
  public long dwCmdUinJoinTime;
  public long dwCmdUinUinFlag;
  public long dwGagTimeStamp;
  public long dwGagTimeStamp_me;
  public long dwGroupClassExt;
  public long dwGroupFlag;
  public long dwGroupFlagExt;
  public long dwGroupFlagExt3;
  public long dwGroupInfoSeq;
  public long dwGroupLevelSeq;
  public long dwLastBAFTipMsgUniSeq;
  public long dwLastInsertBAFTipTime;
  public long dwOfficeMode;
  public long dwTimeStamp;
  public String fingertroopmemo;
  public boolean hasSetNewTroopHead;
  public boolean hasSetNewTroopName;
  public boolean isNewTroop;
  public int isShowInNearbyTroops = -1;
  public String joinTroopAnswer;
  public String joinTroopQuestion;
  public long lastMsgTime;
  HashMap mCachedLevelMap;
  public boolean mCanSearchByKeywords;
  public boolean mCanSearchByTroopUin;
  public int mComparePartInt;
  public String mCompareSpell;
  public String mGroupClassExtText;
  public String mHeaderUinsNew;
  public String mHeaderUinsOld;
  public long mMemberCardSeq = -1L;
  public boolean mMemberInvitingFlag;
  public long mMemberNumSeq = -1L;
  public long mOldMemberCardSeq = -1L;
  public long mOldMemberNumSeq = -1L;
  public int mQZonePhotoNum;
  public String mRichFingerMemo;
  public String mSomeMemberUins;
  public String mTags;
  public int mTribeStatus;
  public int mTroopAvatarId;
  public int mTroopFileVideoIsWhite;
  public long mTroopFileVideoReqInterval;
  public float mTroopNeedPayNumber = 0.0F;
  public List mTroopPicList;
  public Set mTroopVerifyingPics;
  public int maxAdminNum;
  public int maxInviteMemNum;
  public String memberListToShow;
  public int nTroopGrade;
  public String newTroopName;
  public long newTroopNameTimeStamp;
  public String ownerNameShow;
  public String strLocation;
  public String strQZonePhotoUrls;
  public long timeSec;
  public String topicId;
  public String troopAuthenticateInfo;
  public long troopCreateTime;
  public long troopCreditLevel = 5L;
  public long troopCreditLevelInfo;
  public int troopLat;
  public String troopLevelMap;
  public int troopLon;
  public long troopPrivilegeFlag;
  public int troopTypeExt = -1;
  public String troopcode;
  public short troopface;
  public int troopmask = -1;
  public String troopmemo;
  public String troopname;
  public String troopowneruin;
  public int trooptype;
  @unique
  public String troopuin;
  public String uin;
  public int wClickBAFTipCount;
  public int wInsertBAFTipCount;
  public int wMemberMax;
  public int wMemberNum;
  public int wMemberNumClient;
  public int wSpecialClass;
  
  public static String convertMemberUinListToString(ArrayList paramArrayList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        localStringBuilder.append((String)paramArrayList.next());
        localStringBuilder.append("|");
        i += 1;
        if (i <= paramInt) {}
      }
      else
      {
        return localStringBuilder.toString();
      }
    }
  }
  
  public static List getTags(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\n");
      int i = 0;
      while (i < paramString.length)
      {
        localArrayList.add(paramString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static boolean hasPayPrivilege(long paramLong, int paramInt)
  {
    return ((0x20 | paramLong) & paramInt) != 0L;
  }
  
  public static boolean isAdmin(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.isAdmin());
  }
  
  public static boolean isHomeworkTroop(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.isHomeworkTroop());
  }
  
  public static boolean isQidianPrivateTroop(long paramLong)
  {
    return (0x20 & paramLong) != 0L;
  }
  
  public static boolean isQidianPrivateTroop(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
    return (paramQQAppInterface != null) && (isQidianPrivateTroop(paramQQAppInterface.dwGroupFlagExt3));
  }
  
  public static final boolean isTroopMember(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString) != null;
    }
    return false;
  }
  
  public static boolean isVisitorSpeakEnabled(int paramInt)
  {
    return (paramInt & 0x2000) == 8192;
  }
  
  public static List setAvatarPicId(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait)
  {
    if (paramGroupHeadPortrait.uint32_pic_cnt.get() != paramGroupHeadPortrait.rpt_msg_info.size()) {}
    ArrayList localArrayList = new ArrayList();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_info.get().iterator();
    while (paramGroupHeadPortrait.hasNext()) {
      localArrayList.add(String.valueOf(((oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next()).rpt_uint32_pic_id.get()));
    }
    return localArrayList;
  }
  
  public static String setTags(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramList = (oidb_0x88d.TagRecord)localIterator.next();
          if (!paramList.bytes_tag_value.has()) {
            continue;
          }
          paramList = paramList.bytes_tag_value.get().toStringUtf8();
          try
          {
            paramList = new String(paramList.getBytes("utf-8"));
            localStringBuffer.append(paramList + "\n");
          }
          catch (UnsupportedEncodingException paramList)
          {
            for (;;)
            {
              paramList.printStackTrace();
              paramList = "";
            }
          }
        }
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  public static Set setVerifyingAvatarPicId(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait)
  {
    int i = paramGroupHeadPortrait.uint32_verifying_pic_cnt.get();
    int j = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.size();
    if ((i != j) && (QLog.isColorLevel())) {
      QLog.d("TroopInfo", 2, String.format("wrong data from server! uint32_verifying_pic_cnt = %d not equals rpt_msg_verifyingpic_info's size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    HashSet localHashSet = new HashSet();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.get().iterator();
    while (paramGroupHeadPortrait.hasNext()) {
      localHashSet.add(String.valueOf(((oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next()).rpt_uint32_pic_id.get()));
    }
    return localHashSet;
  }
  
  protected static String troopLevelMapToString(HashMap paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramHashMap.size();
    paramHashMap = paramHashMap.entrySet().iterator();
    int i = 0;
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      int k = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = (String)((Map.Entry)localObject).getValue();
      localStringBuilder.append(k).append("").append((String)localObject);
      if (i != j - 1) {
        localStringBuilder.append("\001");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public boolean canAutoInviteMemIntoTroop(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return Math.min(getMemNumForAutoInviteIntoGroup(paramQQAppInterface), paramInt) > this.wMemberNumClient;
  }
  
  public void coverAdministrators(QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramQQAppInterface == null)) {
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      localStringBuffer.append(str + "|");
    }
    this.Administrator = localStringBuffer.toString();
    ((TroopManager)paramQQAppInterface.getManager(51)).b(this);
  }
  
  public void coverFrom(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    boolean bool2 = true;
    if (paramGroupInfo.uint32_group_grade.has()) {
      this.nTroopGrade = paramGroupInfo.uint32_group_grade.get();
    }
    if (paramGroupInfo.string_group_finger_memo.has())
    {
      this.fingertroopmemo = paramGroupInfo.string_group_finger_memo.get().toStringUtf8();
      if (!paramGroupInfo.string_group_rich_finger_memo.has()) {
        break label595;
      }
      this.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      label72:
      if (!TextUtils.isEmpty(this.mRichFingerMemo)) {
        break label605;
      }
      this.mRichFingerMemo = this.fingertroopmemo;
      label90:
      if ((paramGroupInfo.st_group_ex_info.has()) && (paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.has())) {
        this.mTroopNeedPayNumber = (paramGroupInfo.st_group_ex_info.uint32_money_for_add_group.get() * 0.01F);
      }
      if (paramGroupInfo.uint32_app_privilege_flag.has())
      {
        this.dwAppPrivilegeFlag = paramGroupInfo.uint32_app_privilege_flag.get();
        this.troopPrivilegeFlag = this.dwAppPrivilegeFlag;
      }
      if (paramGroupInfo.uint64_subscription_uin.has()) {
        this.associatePubAccount = paramGroupInfo.uint64_subscription_uin.get();
      }
      if (paramGroupInfo.uint32_group_flagext3.has()) {
        this.dwGroupFlagExt3 = paramGroupInfo.uint32_group_flagext3.get();
      }
      if (paramGroupInfo.uint32_no_finger_open_flag.has())
      {
        if (paramGroupInfo.uint32_no_finger_open_flag.get() != 0) {
          break label630;
        }
        bool1 = true;
        label228:
        this.mCanSearchByKeywords = bool1;
      }
      if (paramGroupInfo.uint32_no_code_finger_open_flag.has())
      {
        if (paramGroupInfo.uint32_no_code_finger_open_flag.get() != 0) {
          break label636;
        }
        bool1 = true;
        label257:
        this.mCanSearchByTroopUin = bool1;
      }
      if (paramGroupInfo.uint32_is_conf_group.has())
      {
        if (paramGroupInfo.uint32_is_conf_group.get() != 1) {
          break label642;
        }
        bool1 = true;
        label287:
        this.isNewTroop = bool1;
      }
      if (paramGroupInfo.uint32_is_modify_conf_group_face.has())
      {
        if (paramGroupInfo.uint32_is_modify_conf_group_face.get() != 1) {
          break label648;
        }
        bool1 = true;
        label317:
        this.hasSetNewTroopHead = bool1;
      }
      if (paramGroupInfo.uint32_is_modify_conf_group_name.has()) {
        if (paramGroupInfo.uint32_is_modify_conf_group_name.get() != 1) {
          break label654;
        }
      }
    }
    label642:
    label648:
    label654:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.hasSetNewTroopName = bool1;
      if (paramGroupInfo.rpt_tag_record.has()) {
        this.mTags = setTags(paramGroupInfo.rpt_tag_record.get());
      }
      if (paramGroupInfo.string_group_class_text.has()) {
        this.mGroupClassExtText = paramGroupInfo.string_group_class_text.get().toStringUtf8();
      }
      oidb_0x88d.GroupGeoInfo localGroupGeoInfo = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
      String str = localGroupGeoInfo.bytes_geocontent.get().toStringUtf8();
      int i = (int)localGroupGeoInfo.int64_latitude.get();
      int j = (int)localGroupGeoInfo.int64_longitude.get();
      if (!TextUtils.isEmpty(str)) {
        this.strLocation = str;
      }
      if (i != 0) {
        this.troopLat = i;
      }
      if (j != 0) {
        this.troopLon = j;
      }
      if (paramGroupInfo.uint32_group_create_time.has()) {
        this.troopCreateTime = paramGroupInfo.uint32_group_create_time.get();
      }
      this.wMemberMax = paramGroupInfo.uint32_group_member_max_num.get();
      this.wMemberNum = paramGroupInfo.uint32_group_member_num.get();
      this.wMemberNumClient = this.wMemberNum;
      this.dwGroupFlagExt = paramGroupInfo.uint32_group_flag_ext.get();
      this.troopTypeExt = paramGroupInfo.uint32_group_type_flag.get();
      this.dwGroupFlag = paramGroupInfo.uint32_group_flag.get();
      if (!isNewTroop()) {
        break label660;
      }
      this.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_conf_group.get();
      return;
      this.fingertroopmemo = "";
      break;
      label595:
      this.mRichFingerMemo = "";
      break label72;
      label605:
      this.mRichFingerMemo = HttpUtil.c(this.mRichFingerMemo);
      this.mRichFingerMemo = HttpUtil.b(this.mRichFingerMemo);
      break label90;
      label630:
      bool1 = false;
      break label228;
      label636:
      bool1 = false;
      break label257;
      bool1 = false;
      break label287;
      bool1 = false;
      break label317;
    }
    label660:
    this.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_normal_group.get();
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    boolean bool2 = false;
    this.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
    this.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
    this.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
    this.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
    this.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
    this.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
    this.dwAdditionalFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("dwAdditionalFlag")));
    this.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
    this.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
    this.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
    this.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
    this.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
    this.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
    this.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
    this.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
    this.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
    this.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
    this.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
    this.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
    this.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
    this.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
    this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
    this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
    this.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
    boolean bool1;
    if (paramCursor.getInt(paramCursor.getColumnIndex("mMemberInvitingFlag")) == 1) {
      bool1 = true;
    }
    for (;;)
    {
      this.mMemberInvitingFlag = bool1;
      this.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      this.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      this.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
      this.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
      this.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
      this.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
      this.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
      this.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      this.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
      this.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      this.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      this.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      this.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      this.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      this.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      this.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      this.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      this.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
      this.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      this.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      this.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      this.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      this.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      this.newTroopName = paramCursor.getString(paramCursor.getColumnIndex("newTroopName"));
      this.newTroopNameTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("newTroopNameTimeStamp"));
      this.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      this.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      this.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      this.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      this.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      this.wMemberNumClient = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNumClient"));
      this.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      this.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
      this.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
      this.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
      this.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
      this.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      this.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      this.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      this.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("mCanSearchByKeywords")) == 1)
      {
        bool1 = true;
        label1290:
        this.mCanSearchByKeywords = bool1;
        if (paramCursor.getInt(paramCursor.getColumnIndex("mCanSearchByTroopUin")) != 1) {
          break label1728;
        }
        bool1 = true;
        label1316:
        this.mCanSearchByTroopUin = bool1;
        if (paramCursor.getInt(paramCursor.getColumnIndex("isNewTroop")) != 1) {
          break label1733;
        }
        bool1 = true;
        label1342:
        this.isNewTroop = bool1;
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasSetNewTroopHead")) != 1) {
          break label1738;
        }
        bool1 = true;
        this.hasSetNewTroopHead = bool1;
        bool1 = bool2;
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasSetNewTroopName")) == 1) {
          bool1 = true;
        }
        this.hasSetNewTroopName = bool1;
      }
      try
      {
        this.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        this.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        this.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        this.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        this.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        this.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        label1516:
        int i = paramCursor.getColumnIndex("troopCreditLevel");
        if (i >= 0) {
          this.troopCreditLevel = paramCursor.getLong(i);
        }
        i = paramCursor.getColumnIndex("troopCreditLevelInfo");
        if (i >= 0) {
          this.troopCreditLevelInfo = paramCursor.getLong(i);
        }
        i = paramCursor.getColumnIndex("dwGroupFlagExt3");
        if (i >= 0) {
          this.dwGroupFlagExt3 = paramCursor.getLong(i);
        }
        i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
        if (i >= 0) {
          this.dwCmdUinJoinTime = paramCursor.getLong(i);
        }
        i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
        if (i >= 0) {
          this.dwLastInsertBAFTipTime = paramCursor.getLong(i);
        }
        i = paramCursor.getColumnIndex("wInsertBAFTipCount");
        if (i >= 0) {
          this.wInsertBAFTipCount = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("wClickBAFTipCount");
        if (i >= 0) {
          this.wClickBAFTipCount = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
        if (i >= 0) {
          this.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
        }
        return true;
        bool1 = false;
        continue;
        bool1 = false;
        break label1290;
        label1728:
        bool1 = false;
        break label1316;
        label1733:
        bool1 = false;
        break label1342;
        label1738:
        bool1 = false;
      }
      catch (Exception localException)
      {
        break label1516;
      }
    }
  }
  
  public int getAdminCount()
  {
    int j = 0;
    if (this.Administrator != null)
    {
      String[] arrayOfString = this.Administrator.split("\\|");
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= arrayOfString.length) {
          break;
        }
        k = i;
        if (!TextUtils.isEmpty(arrayOfString[j])) {
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public String getAdminShow(Context paramContext)
  {
    if (TextUtils.isEmpty(this.adminNameShow)) {
      return paramContext.getString(2131433171);
    }
    return this.adminNameShow;
  }
  
  public String getInviteModeDesWording(Resources paramResources)
  {
    String str = "";
    if ((this.troopPrivilegeFlag & 0x6100000) == 0L) {
      str = paramResources.getString(2131430172);
    }
    while (((this.troopPrivilegeFlag & 0x2000000) != 33554432L) && ((this.troopPrivilegeFlag & 0x4000000) != 67108864L) && ((this.troopPrivilegeFlag & 0x100000) != 1048576L)) {
      return str;
    }
    return paramResources.getString(2131430171);
  }
  
  public String getInviteModeWording(Resources paramResources)
  {
    String str = "";
    int i;
    if ((hasPayPrivilege(this.troopPrivilegeFlag, 128)) && (hasPayPrivilege(this.troopPrivilegeFlag, 512)))
    {
      i = 6;
      if (((i != 1) && (i != 6)) || (isOnlyTroopMemberInviteOption())) {
        break label69;
      }
      str = paramResources.getString(2131430166);
    }
    label69:
    do
    {
      return str;
      i = this.cGroupOption;
      break;
      if ((this.troopPrivilegeFlag & 0x6100000) == 0L) {
        return paramResources.getString(2131430167);
      }
      if ((this.troopPrivilegeFlag & 0x100000) == 1048576L) {
        return paramResources.getString(2131430166);
      }
    } while (((this.troopPrivilegeFlag & 0x4000000) != 67108864L) && ((this.troopPrivilegeFlag & 0x2000000) != 33554432L));
    return paramResources.getString(2131430169);
  }
  
  public int getMemNumForAutoInviteIntoGroup(QQAppInterface paramQQAppInterface)
  {
    int k = 0;
    int i;
    if ((this.troopPrivilegeFlag & 0x100000) == 1048576L) {
      i = -1;
    }
    for (;;)
    {
      if ((isTroopOwner(paramQQAppInterface.c())) || (isTroopAdmin(paramQQAppInterface.c()))) {}
      for (int j = 1;; j = 0)
      {
        if ((hasInviteMemAuth()) || (j != 0))
        {
          if ((i != -1) && (j == 0)) {
            break label120;
          }
          k = this.maxInviteMemNum;
        }
        return k;
        if ((this.troopPrivilegeFlag & 0x2000000) == 33554432L)
        {
          i = 50;
          break;
        }
        if ((this.troopPrivilegeFlag & 0x4000000) != 67108864L) {
          break label129;
        }
        i = 100;
        break;
      }
      label120:
      return Math.min(this.maxInviteMemNum, i);
      label129:
      i = 0;
    }
  }
  
  public String getOwnerOrAdminString(String paramString, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.equals(this.troopowneruin)) {
        return getOwnerShow(paramContext);
      }
    } while ((this.Administrator == null) || (!this.Administrator.contains(paramString)));
    return getAdminShow(paramContext);
  }
  
  public String getOwnerShow(Context paramContext)
  {
    if (TextUtils.isEmpty(this.ownerNameShow)) {
      return paramContext.getString(2131433170);
    }
    return this.ownerNameShow;
  }
  
  public String getPercentage()
  {
    return "66";
  }
  
  public ArrayList getQZonePhotoUrls()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.strQZonePhotoUrls != null)
    {
      String[] arrayOfString = this.strQZonePhotoUrls.split(";");
      localObject1 = localObject2;
      if (arrayOfString != null)
      {
        localObject1 = localObject2;
        if (arrayOfString.length > 0)
        {
          localObject1 = new ArrayList();
          int i = 0;
          while (i < arrayOfString.length)
          {
            if ((arrayOfString[i] != null) && (arrayOfString[i].length() > 0)) {
              ((ArrayList)localObject1).add(arrayOfString[i]);
            }
            i += 1;
          }
        }
      }
    }
    return localObject1;
  }
  
  public List getSomeMemberUins()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mSomeMemberUins != null) && (this.mSomeMemberUins.length() > 0))
    {
      int j = 0;
      int i = this.mSomeMemberUins.indexOf('|', 0);
      int k = this.mSomeMemberUins.length();
      String str2;
      String str1;
      while ((i >= j) && (i < k))
      {
        if (j < i)
        {
          str2 = this.mSomeMemberUins.substring(j, i);
          str1 = str2;
          if (str2 != null) {
            str1 = str2.trim();
          }
          if ((str1 != null) && (str1.length() > 0)) {
            localArrayList.add(str1);
          }
        }
        j = i + 1;
        i = this.mSomeMemberUins.indexOf('|', j);
      }
      if (j < k)
      {
        str2 = this.mSomeMemberUins.substring(j, k);
        str1 = str2;
        if (str2 != null) {
          str1 = str2.trim();
        }
        if ((str1 != null) && (str1.length() > 0)) {
          localArrayList.add(str1);
        }
      }
    }
    return localArrayList;
  }
  
  public String getTableName()
  {
    return "TroopInfoV2";
  }
  
  @SuppressLint({"UseSparseArrays"})
  public HashMap getTroopLevelMap()
  {
    int i = 0;
    if ((this.mCachedLevelMap == null) || (this.mCachedLevelMap.size() == 0))
    {
      try
      {
        if (this.mCachedLevelMap != null) {
          break label224;
        }
        this.mCachedLevelMap = new HashMap();
        if (this.troopLevelMap != null)
        {
          String[] arrayOfString1 = this.troopLevelMap.split("\001");
          for (;;)
          {
            if ((arrayOfString1 != null) && (arrayOfString1.length > 0) && (i < arrayOfString1.length))
            {
              String[] arrayOfString2 = arrayOfString1[i].split("");
              int j = arrayOfString2.length;
              if (j == 2) {}
              try
              {
                this.mCachedLevelMap.put(Integer.valueOf(Integer.parseInt(arrayOfString2[0])), arrayOfString2[1]);
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopInfo", 2, "getTroopLevelMap, catch exception, key: " + arrayOfString2[0] + " value: " + arrayOfString2[1]);
                  }
                }
              }
            }
          }
        }
        if (!QLog.isColorLevel()) {
          break label224;
        }
      }
      finally {}
      QLog.d("Q.getTroopMemberLevelInfo", 2, "getTroopLevelMap:" + this.troopuin + ", create cache");
    }
    label224:
    return this.mCachedLevelMap;
  }
  
  public String getTroopName()
  {
    if (hasSetTroopName()) {
      return this.troopname;
    }
    if (!TextUtils.isEmpty(this.newTroopName))
    {
      if (System.currentTimeMillis() - this.newTroopNameTimeStamp > 86400000L) {
        TroopNameHelper.a(this.troopuin);
      }
      return this.newTroopName;
    }
    TroopNameHelper.a(this.troopuin);
    return this.troopname;
  }
  
  public boolean hasInviteMemAuth()
  {
    boolean bool3 = true;
    if ((hasPayPrivilege(this.troopPrivilegeFlag, 128)) && (hasPayPrivilege(this.troopPrivilegeFlag, 512))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if ((this.mMemberInvitingFlag) || (isAdmin()))
      {
        bool2 = bool3;
        if (!isAdmin())
        {
          bool2 = bool3;
          if (this.cGroupOption == 3)
          {
            bool2 = bool3;
            if (bool1) {}
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(TroopInfo.class.getSimpleName(), 2, "hasInviteMemAuth：mMemberInvitingFlag=" + this.mMemberInvitingFlag + ", mTroopInfoData.isOwnerOrAdim() = " + isAdmin() + ", mTroopInfoData.cGroupOption=" + this.cGroupOption + ", isPayToJoinTroop=" + bool1);
        }
        bool2 = false;
      }
      return bool2;
    }
  }
  
  public boolean hasOrgs()
  {
    return false;
  }
  
  public boolean hasSetTroopHead()
  {
    if (this.isNewTroop) {
      return this.hasSetNewTroopHead;
    }
    return true;
  }
  
  public boolean hasSetTroopName()
  {
    if (this.isNewTroop) {
      return this.hasSetNewTroopName;
    }
    return true;
  }
  
  public boolean isAdmin()
  {
    return ((this.dwAdditionalFlag & 1L) == 1L) || ((this.dwCmdUinUinFlag & 1L) == 1L);
  }
  
  public boolean isAllowCreateDiscuss()
  {
    return (this.troopPrivilegeFlag & 0x8000) == 0L;
  }
  
  public boolean isAllowCreateTempConv()
  {
    return (this.troopPrivilegeFlag & 0x10000) == 0L;
  }
  
  public boolean isGameBind()
  {
    return (this.dwGroupFlagExt3 & 0x800) != 0L;
  }
  
  public boolean isGameTroop()
  {
    return this.dwGroupClassExt == 25L;
  }
  
  public boolean isHomeworkTroop()
  {
    return this.dwGroupClassExt == 32L;
  }
  
  public boolean isNewTroop()
  {
    return this.isNewTroop;
  }
  
  public boolean isOnlyTroopMemberInviteOption()
  {
    return (this.dwGroupFlagExt3 & 0x4) != 0L;
  }
  
  public boolean isQidianPrivateTroop()
  {
    return isQidianPrivateTroop(this.dwGroupFlagExt3);
  }
  
  public boolean isTroopAdmin(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int i;
    if (this.Administrator != null)
    {
      arrayOfString = this.Administrator.split("\\|");
      bool1 = bool2;
      if (arrayOfString != null)
      {
        bool1 = bool2;
        if (arrayOfString.length > 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < arrayOfString.length)
      {
        if ((paramString != null) && (paramString.equals(arrayOfString[i]))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean isTroopOwner(String paramString)
  {
    return (paramString != null) && (paramString.equals(this.troopowneruin));
  }
  
  public ArrayList parseTroopMemeberList()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.memberListToShow != null)
    {
      String[] arrayOfString = this.memberListToShow.split("\\|");
      int i = 0;
      for (;;)
      {
        if (i < arrayOfString.length) {
          try
          {
            localArrayList.add(Long.valueOf(Long.parseLong(arrayOfString[i])));
            i += 1;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("troopInfo_member", 2, "parse error: " + arrayOfString[i]);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void setOnlyTroopMemberInviteOption(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dwGroupFlagExt3 |= 0x4;
      return;
    }
    this.dwGroupFlagExt3 &= 0xFFFFFFFB;
  }
  
  public void setQidianPrivateTroopFlag()
  {
    this.dwGroupFlagExt3 |= 0x20;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public void setTroopLevelMap(List paramList)
  {
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(getTroopLevelMap());
        int i = 0;
        while (i < paramList.size())
        {
          stLevelRankPair localstLevelRankPair = (stLevelRankPair)paramList.get(i);
          localHashMap.put(Integer.valueOf((int)localstLevelRankPair.dwLevel), localstLevelRankPair.strRank);
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap:" + this.troopuin + ", old=" + this.troopLevelMap);
        }
        this.troopLevelMap = troopLevelMapToString(localHashMap);
        this.mCachedLevelMap = localHashMap;
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap:" + this.troopuin + ", new=" + this.troopLevelMap);
        }
      }
      return;
    }
    finally {}
  }
  
  @SuppressLint({"UseSparseArrays"})
  public void setTroopLevelMap787(List paramList)
  {
    if (paramList != null) {}
    try
    {
      if (paramList.size() > 0)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(getTroopLevelMap());
        int i = 0;
        while (i < paramList.size())
        {
          oidb_0x787.LevelName localLevelName = (oidb_0x787.LevelName)paramList.get(i);
          localHashMap.put(Integer.valueOf(localLevelName.uint32_level.get()), localLevelName.str_name.get().toStringUtf8());
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap787:" + this.troopuin + ", old=" + this.troopLevelMap);
        }
        this.troopLevelMap = troopLevelMapToString(localHashMap);
        this.mCachedLevelMap = localHashMap;
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "setTroopLevelMap787:" + this.troopuin + ", new=" + this.troopLevelMap);
        }
      }
      return;
    }
    finally {}
  }
  
  public void updateHeadMemberList(ArrayList paramArrayList)
  {
    paramArrayList.remove(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    this.mHeaderUinsNew = GroupIconHelper.a(paramArrayList, false);
  }
  
  public void updateHeadMemberUins(List paramList)
  {
    int i;
    String str;
    ArrayList localArrayList;
    int j;
    label33:
    oidb_0x899.memberlist localmemberlist;
    if (paramList != null)
    {
      i = paramList.size();
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label149;
      }
      localmemberlist = (oidb_0x899.memberlist)paramList.get(j);
      if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has())) {
        break label78;
      }
    }
    for (;;)
    {
      j += 1;
      break label33;
      i = 0;
      break;
      label78:
      if (!str.equals("" + localmemberlist.uint64_member_uin.get())) {
        localArrayList.add("" + localmemberlist.uint64_member_uin.get());
      }
    }
    label149:
    this.mHeaderUinsNew = GroupIconHelper.a(localArrayList, false);
  }
  
  public void updateQZonePhotoUrls(ArrayList paramArrayList)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    if (paramArrayList != null) {
      i = paramArrayList.size();
    }
    while (j < i)
    {
      String str = (String)paramArrayList.get(j);
      if ((str != null) && (str.length() > 0)) {
        localStringBuilder.append(str).append(";");
      }
      j += 1;
      continue;
      i = 0;
    }
    this.strQZonePhotoUrls = localStringBuilder.toString();
  }
  
  public void updateSomeMemberUins(List paramList)
  {
    int j = 0;
    int i;
    StringBuilder localStringBuilder;
    label30:
    oidb_0x899.memberlist localmemberlist;
    if (paramList != null)
    {
      i = paramList.size();
      localStringBuilder = new StringBuilder();
      new ArrayList();
      if (j >= i) {
        break label97;
      }
      localmemberlist = (oidb_0x899.memberlist)paramList.get(j);
      if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has())) {
        break label75;
      }
    }
    for (;;)
    {
      j += 1;
      break label30;
      i = 0;
      break;
      label75:
      localStringBuilder.append(localmemberlist.uint64_member_uin.get()).append('|');
    }
    label97:
    this.mSomeMemberUins = localStringBuilder.toString();
    if ((i < 6) && (i > 0)) {
      this.wMemberNum = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopInfo
 * JD-Core Version:    0.7.0.1
 */