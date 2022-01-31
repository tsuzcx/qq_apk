package com.tencent.mobileqq.data;

import ajyc;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import aukm;
import ault;
import aulx;
import auma;
import balq;
import balr;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;
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
import nam;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x787.oidb_0x787.LevelName;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GroupFeedsRecord;

public class TroopInfo
  extends aukm
  implements Serializable
{
  public static final int ALLOW_HISTORY_MSG_READ_FOR_NEW_MEMBER = 4;
  public static final int ALLOW_UPLOAD_TROOP_ALBUM = 1;
  public static final int ALLOW_UPLOAD_TROOP_FILE = 2;
  public static final int CONFESS_TALK_OPEN_FLAG = 8192;
  public static final int DEL_PIC_REQ = 2;
  public static final int GROUP_CLASS_EXT_TYPE_CLASSMATES = 10011;
  public static final int GROUP_CLASS_EXT_TYPE_FANS = 27;
  public static final int GROUP_CLASS_EXT_TYPE_GAME = 25;
  public static final int GROUP_CLASS_EXT_TYPE_HOMEWORK = 32;
  public static final int GROUP_CLASS_EXT_TYPE_IGNORE = 0;
  public static final int GROUP_CLASS_EXT_TYPE_OFFICIAL = 10012;
  public static final int GROUP_CLASS_EXT_TYPE_RELATIVES = 10010;
  public static final int GROUP_CLASS_EXT_TYPE_WORKMATES = 10009;
  public static final int KING_TEAM_APPID = 1104466820;
  public static final int KING_TEAM_TROOP_SUBTYPE_BATTLE = 0;
  @Deprecated
  public static final int MODIFY_ORDER = 0;
  public static final int ONLY_TROOP_MEMBER_INVITE_JOIN_TROOP = 4;
  public static final int PAY_CHOICE_PAY_TO_JOIN_TROOP = 512;
  public static final int PAY_PRIVILEGE_ALL = 448;
  public static final int PAY_PRIVILEGE_DELIVER_GIFT = 32;
  public static final int PAY_PRIVILEGE_GIFT_SETTLEMENT_ABILITY = 256;
  public static final int PAY_PRIVILEGE_GROUP_FEE = 64;
  public static final int PAY_PRIVILEGE_PAY_TO_JOIN_TROOP = 128;
  public static final int QIDIAN_PRIVATE_TROOP_FLAG = 32;
  public static final String QIDIAN_TROOP_MEMBER_DEF_NICK = ajyc.a(2131715455);
  public static final int QZONE_TROOP_ENTRANCE = 131072;
  public static final int SET_DEFAULT_PIC = 1;
  public static final String TABLE_NAME = "TroopInfoV2";
  public static final String TAG = "TroopInfo";
  public static final int TROOP_AUTO_APPROVAL = 1048576;
  public static final int TROOP_GAME_BIND = 2048;
  public static final int TROOP_HONOR_AIO_SWITCH = 33554432;
  public static final int TROOP_LISTEN_TOGETHER = 2097152;
  public static final int TROOP_PRIVILEGE_INVITE_NEED_REVIEW = 101711872;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW = 1048576;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_100 = 67108864;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_50 = 33554432;
  public static final int TROOP_SHARE_LOCATION = 67108864;
  public static final int TROOP_SING_TOGETHER = 16777216;
  public static final int TROOP_WATCH_TOGETHER = 4194304;
  public String Administrator;
  public String adminNameShow;
  public int allowMemberAtAll;
  public int allowMemberKick;
  public int allowMemberModifTroopName;
  public long associatePubAccount;
  public byte cAlbumResult;
  public short cGroupLevel;
  public short cGroupOption;
  public byte cGroupRankSysFlag;
  public byte cGroupRankUserFlag;
  public long cmdUinFlagEx2;
  public String dailyNewMemberUins;
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
  public long dwLastBAFTipMsgUniSeq2;
  public long dwLastInsertBAFTipTime;
  public long dwOfficeMode;
  public long dwTimeStamp;
  public int eliminated;
  public int exitTroopReason = 0;
  public String feeds_id;
  public String fingertroopmemo;
  public int gameSwitchStatus;
  public int groupFlagExt4;
  public int groupFreezeReason;
  public boolean hasSetNewTroopHead;
  public boolean hasSetNewTroopName;
  public long hlGuildAppid;
  public int hlGuildBinary = 1;
  public int hlGuildOrgid;
  public long hlGuildSubType;
  public int isAllowHistoryMsgFlag;
  public boolean isNewTroop;
  public int isShowInNearbyTroops = -1;
  public String joinTroopAnswer;
  public String joinTroopQuestion;
  public long lastMsgTime;
  @ault(a=0)
  public long lastShareLbsMsgUniseq;
  public String mAtOrReplyMeUins;
  HashMap<Integer, String> mCachedLevelMap;
  public boolean mCanSearchByKeywords;
  public boolean mCanSearchByTroopUin;
  public int mComparePartInt;
  public String mCompareSpell;
  public String mGroupClassExtText;
  public String mHeaderUinsNew;
  public String mHeaderUinsOld;
  public int mIsFreezed;
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
  @aulx
  public List<TroopClipPic> mTroopPicList = new ArrayList(8);
  public String mTroopPicListJson = "";
  @aulx
  public Set<String> mTroopVerifyingPics = new HashSet();
  public int maxAdminNum;
  public int maxInviteMemNum;
  public String memberListToShow;
  public int nMsgLimitFreq;
  public int nTroopGrade;
  public String newTroopName;
  public long newTroopNameTimeStamp;
  public String oldTroopName;
  public String ownerNameShow;
  public int showGameSwitchStatus;
  public String strLastAnnouncement;
  public String strLocation;
  public String strQZonePhotoUrls;
  public long timeSec;
  public String topicId;
  public String troopAuthenticateInfo;
  public long troopCreateTime;
  public long troopCreditLevel = 5L;
  public long troopCreditLevelInfo;
  public int troopHonorGrayFlag;
  public int troopLat;
  public String troopLevelMap;
  public int troopLon;
  public long troopPrivilegeFlag;
  public int troopRepeatType;
  public int troopTypeExt = -1;
  public String troopcode;
  public short troopface;
  public int troopmask = -1;
  public String troopmemo;
  public String troopname;
  public String troopowneruin;
  public int trooptype;
  @auma
  public String troopuin;
  public long udwCmdUinRingtoneID;
  public String uin;
  public int wClickBAFTipCount;
  public int wInsertBAFTipCount;
  public int wMemberMax;
  public int wMemberNum;
  public int wMemberNumClient;
  public int wSpecialClass;
  
  public static String convertMemberUinListToString(ArrayList<String> paramArrayList, int paramInt)
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
  
  public static List<String> getTags(String paramString)
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
  
  public static boolean hasCover(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return false;
    }
    paramTroopInfo = paramTroopInfo.mTroopPicList.iterator();
    while (paramTroopInfo.hasNext()) {
      if (((TroopClipPic)paramTroopInfo.next()).type == 0) {
        return true;
      }
    }
    return false;
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
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.isAdmin());
  }
  
  public static boolean isCmdUinFlagEx2Open(long paramLong, int paramInt)
  {
    return (paramInt & paramLong) != 0L;
  }
  
  public static boolean isFansTroop(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.isFansTroop());
  }
  
  public static boolean isHomeworkTroop(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
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
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
    return (paramQQAppInterface != null) && (isQidianPrivateTroop(paramQQAppInterface.dwGroupFlagExt3));
  }
  
  public static final boolean isTroopMember(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b(paramString) != null;
    }
    return false;
  }
  
  public static boolean isVisitorSpeakEnabled(int paramInt)
  {
    return (paramInt & 0x2000) == 8192;
  }
  
  public static String setTags(List<oidb_0x88d.TagRecord> paramList)
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
  
  protected static String troopLevelMapToString(HashMap<Integer, String> paramHashMap)
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
  
  public boolean checkFlagExt4(int paramInt)
  {
    return (this.groupFlagExt4 & paramInt) > 0;
  }
  
  public boolean checkFreezeReason(int paramInt)
  {
    return (this.groupFreezeReason & paramInt) > 0;
  }
  
  public void coverAdministrators(QQAppInterface paramQQAppInterface, ArrayList<String> paramArrayList)
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
    ((TroopManager)paramQQAppInterface.getManager(52)).b(this);
  }
  
  public void coverFrom(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    boolean bool2 = false;
    if (paramGroupInfo.uint32_group_grade.has()) {
      this.nTroopGrade = paramGroupInfo.uint32_group_grade.get();
    }
    label72:
    label90:
    boolean bool1;
    label228:
    Object localObject;
    if (paramGroupInfo.string_group_finger_memo.has())
    {
      this.fingertroopmemo = paramGroupInfo.string_group_finger_memo.get().toStringUtf8();
      if (!paramGroupInfo.string_group_rich_finger_memo.has()) {
        break label806;
      }
      this.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      if (!TextUtils.isEmpty(this.mRichFingerMemo)) {
        break label815;
      }
      this.mRichFingerMemo = this.fingertroopmemo;
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
          break label840;
        }
        bool1 = true;
        this.mCanSearchByKeywords = bool1;
      }
      if (paramGroupInfo.uint32_no_code_finger_open_flag.has())
      {
        if (paramGroupInfo.uint32_no_code_finger_open_flag.get() != 0) {
          break label846;
        }
        bool1 = true;
        label257:
        this.mCanSearchByTroopUin = bool1;
      }
      if (paramGroupInfo.uint32_is_conf_group.has())
      {
        if (paramGroupInfo.uint32_is_conf_group.get() != 1) {
          break label852;
        }
        bool1 = true;
        label287:
        this.isNewTroop = bool1;
      }
      if (paramGroupInfo.uint32_is_modify_conf_group_face.has())
      {
        if (paramGroupInfo.uint32_is_modify_conf_group_face.get() != 1) {
          break label858;
        }
        bool1 = true;
        label317:
        this.hasSetNewTroopHead = bool1;
      }
      if (paramGroupInfo.uint32_is_modify_conf_group_name.has())
      {
        bool1 = bool2;
        if (paramGroupInfo.uint32_is_modify_conf_group_name.get() == 1) {
          bool1 = true;
        }
        this.hasSetNewTroopName = bool1;
      }
      if (paramGroupInfo.rpt_tag_record.has()) {
        this.mTags = setTags(paramGroupInfo.rpt_tag_record.get());
      }
      if (paramGroupInfo.string_group_class_text.has()) {
        this.mGroupClassExtText = paramGroupInfo.string_group_class_text.get().toStringUtf8();
      }
      if (paramGroupInfo.uint32_is_allow_recall_msg.has()) {
        this.isAllowHistoryMsgFlag = paramGroupInfo.uint32_is_allow_recall_msg.get();
      }
      localObject = (oidb_0x88d.GroupGeoInfo)paramGroupInfo.group_geo_info.get();
      String str = ((oidb_0x88d.GroupGeoInfo)localObject).bytes_geocontent.get().toStringUtf8();
      int i = (int)((oidb_0x88d.GroupGeoInfo)localObject).int64_latitude.get();
      int j = (int)((oidb_0x88d.GroupGeoInfo)localObject).int64_longitude.get();
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
        break label864;
      }
    }
    label806:
    label815:
    label840:
    label846:
    label852:
    label858:
    label864:
    for (this.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_conf_group.get();; this.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_normal_group.get())
    {
      this.allowMemberModifTroopName = paramGroupInfo.uint32_is_allow_conf_group_member_modify_group_name.get();
      this.allowMemberKick = paramGroupInfo.uint32_is_allow_conf_group_member_nick.get();
      this.allowMemberAtAll = paramGroupInfo.uint32_is_allow_conf_group_member_at_all.get();
      if (((paramGroupInfo.string_long_group_name.has()) && (!this.isNewTroop)) || (this.hasSetNewTroopName))
      {
        localObject = paramGroupInfo.string_long_group_name.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.troopname = ((String)localObject);
          if (this.newTroopName == null) {
            this.newTroopName = ((String)localObject);
          }
        }
      }
      if (paramGroupInfo.uint32_is_group_freeze.has()) {
        this.mIsFreezed = paramGroupInfo.uint32_is_group_freeze.get();
      }
      this.groupFlagExt4 = paramGroupInfo.uint32_group_flagext4.get();
      this.groupFreezeReason = paramGroupInfo.uint32_group_freeze_reason.get();
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("vip_pretty.TroopInfo", 1, "get flag ext4=" + this.groupFlagExt4 + " freeze reason=" + this.groupFreezeReason);
      }
      return;
      this.fingertroopmemo = "";
      break;
      this.mRichFingerMemo = "";
      break label72;
      this.mRichFingerMemo = nam.c(this.mRichFingerMemo);
      this.mRichFingerMemo = nam.b(this.mRichFingerMemo);
      break label90;
      bool1 = false;
      break label228;
      bool1 = false;
      break label257;
      bool1 = false;
      break label287;
      bool1 = false;
      break label317;
    }
  }
  
  public boolean entityByCursor(Cursor paramCursor)
  {
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
    boolean bool;
    if (paramCursor.getInt(paramCursor.getColumnIndex("mMemberInvitingFlag")) == 1) {
      bool = true;
    }
    for (;;)
    {
      this.mMemberInvitingFlag = bool;
      this.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      this.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      this.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
      this.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
      this.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
      this.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
      this.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
      this.mTroopPicListJson = paramCursor.getString(paramCursor.getColumnIndex("mTroopPicListJson"));
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
        bool = true;
        label1306:
        this.mCanSearchByKeywords = bool;
        if (paramCursor.getInt(paramCursor.getColumnIndex("mCanSearchByTroopUin")) != 1) {
          break label2343;
        }
        bool = true;
        label1332:
        this.mCanSearchByTroopUin = bool;
        if (paramCursor.getInt(paramCursor.getColumnIndex("isNewTroop")) != 1) {
          break label2348;
        }
        bool = true;
        label1358:
        this.isNewTroop = bool;
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasSetNewTroopHead")) != 1) {
          break label2353;
        }
        bool = true;
        label1384:
        this.hasSetNewTroopHead = bool;
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasSetNewTroopName")) != 1) {
          break label2358;
        }
        bool = true;
        this.hasSetNewTroopName = bool;
        this.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
        this.feeds_id = paramCursor.getString(paramCursor.getColumnIndex("feeds_id"));
        this.troopRepeatType = paramCursor.getInt(paramCursor.getColumnIndex("troopRepeatType"));
      }
      try
      {
        this.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        this.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        this.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        this.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        this.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        this.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        this.allowMemberAtAll = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberAtAll"));
        this.allowMemberKick = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberKick"));
        this.allowMemberModifTroopName = paramCursor.getInt(paramCursor.getColumnIndex("allowMemberModifTroopName"));
        this.oldTroopName = paramCursor.getString(paramCursor.getColumnIndex("oldTroopName"));
        this.mIsFreezed = paramCursor.getInt(paramCursor.getColumnIndex("mIsFreezed"));
        label1681:
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
        i = paramCursor.getColumnIndex("cmdUinFlagEx2");
        if (i >= 0) {
          this.cmdUinFlagEx2 = paramCursor.getLong(i);
        }
        i = paramCursor.getColumnIndex("udwCmdUinRingtoneID");
        if (i >= 0) {
          this.udwCmdUinRingtoneID = paramCursor.getLong(i);
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
        i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq2");
        if (i >= 0) {
          this.dwLastBAFTipMsgUniSeq2 = paramCursor.getLong(i);
        }
        i = paramCursor.getColumnIndex("dailyNewMemberUins");
        if (i >= 0) {
          this.dailyNewMemberUins = paramCursor.getString(i);
        }
        i = paramCursor.getColumnIndex("exitTroopReason");
        if (i >= 0) {
          this.exitTroopReason = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("eliminated");
        if (i >= 0) {
          this.eliminated = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("strLastAnnouncement");
        if (i >= 0) {
          this.strLastAnnouncement = paramCursor.getString(i);
        }
        i = paramCursor.getColumnIndex("nMsgLimitFreq");
        if (i >= 0) {
          this.nMsgLimitFreq = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("hlGuildAppid");
        if (i > 0) {
          this.hlGuildAppid = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("hlGuildSubType");
        if (i > 0) {
          this.hlGuildSubType = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("mAtOrReplyMeUins");
        if (i >= 0) {
          this.mAtOrReplyMeUins = paramCursor.getString(i);
        }
        i = paramCursor.getColumnIndex("groupFreezeReason");
        if (i >= 0) {
          this.groupFreezeReason = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("groupFlagExt4");
        if (i >= 0) {
          this.groupFlagExt4 = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("troopHonorGrayFlag");
        if (i >= 0) {
          this.troopHonorGrayFlag = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("isAllowHistoryMsgFlag");
        if (i >= 0) {
          this.isAllowHistoryMsgFlag = paramCursor.getInt(i);
        }
        i = paramCursor.getColumnIndex("troopRepeatType");
        if (i >= 0) {
          this.troopRepeatType = paramCursor.getInt(i);
        }
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("TroopInfo", 0, "fightgag._troopinfo.dwGagTimeStamp_me = " + this.dwGagTimeStamp_me + ",troopuin = " + this.troopuin);
        }
        return true;
        bool = false;
        continue;
        bool = false;
        break label1306;
        label2343:
        bool = false;
        break label1332;
        label2348:
        bool = false;
        break label1358;
        label2353:
        bool = false;
        break label1384;
        label2358:
        bool = false;
      }
      catch (Exception localException)
      {
        break label1681;
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
      return paramContext.getString(2131720392);
    }
    return this.adminNameShow;
  }
  
  public String getInviteModeDesWording(Resources paramResources)
  {
    String str = "";
    if ((this.troopPrivilegeFlag & 0x6100000) == 0L) {
      str = paramResources.getString(2131696784);
    }
    while (((this.troopPrivilegeFlag & 0x2000000) != 33554432L) && ((this.troopPrivilegeFlag & 0x4000000) != 67108864L) && ((this.troopPrivilegeFlag & 0x100000) != 1048576L)) {
      return str;
    }
    return paramResources.getString(2131696785);
  }
  
  public String getInviteModeWording(Resources paramResources)
  {
    String str = "";
    int i;
    if ((hasPayPrivilege(this.troopPrivilegeFlag, 128)) && (hasPayPrivilege(this.troopPrivilegeFlag, 512)))
    {
      i = 6;
      if (((i != 1) && (i != 6)) || (isOnlyTroopMemberInviteOption())) {
        break label68;
      }
      str = paramResources.getString(2131696789);
    }
    label68:
    do
    {
      return str;
      i = this.cGroupOption;
      break;
      if ((this.troopPrivilegeFlag & 0x6100000) == 0L) {
        return paramResources.getString(2131696788);
      }
      if ((this.troopPrivilegeFlag & 0x100000) == 1048576L) {
        return paramResources.getString(2131696789);
      }
    } while (((this.troopPrivilegeFlag & 0x4000000) != 67108864L) && ((this.troopPrivilegeFlag & 0x2000000) != 33554432L));
    return paramResources.getString(2131696790);
  }
  
  public String getLatestMemo()
  {
    String str2 = this.strLastAnnouncement;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(this.troopmemo)) {
        str1 = this.troopmemo;
      }
    }
    return str1;
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
      return paramContext.getString(2131720550);
    }
    return this.ownerNameShow;
  }
  
  public String getPercentage()
  {
    return "66";
  }
  
  public ArrayList<String> getQZonePhotoUrls()
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
  
  public List<String> getSomeMemberUins()
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
  public HashMap<Integer, String> getTroopLevelMap()
  {
    int i = 0;
    if ((this.mCachedLevelMap == null) || (this.mCachedLevelMap.size() == 0))
    {
      try
      {
        if (this.mCachedLevelMap != null) {
          break label223;
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
                  if (com.tencent.TMG.utils.QLog.isColorLevel()) {
                    com.tencent.TMG.utils.QLog.d("TroopInfo", 0, "getTroopLevelMap, catch exception, key: " + arrayOfString2[0] + " value: " + arrayOfString2[1]);
                  }
                }
              }
            }
          }
        }
        if (!com.tencent.TMG.utils.QLog.isColorLevel()) {
          break label223;
        }
      }
      finally {}
      com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "getTroopLevelMap:" + this.troopuin + ", create cache");
    }
    label223:
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
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d(TroopInfo.class.getSimpleName(), 0, "hasInviteMemAuth：mMemberInvitingFlag=" + this.mMemberInvitingFlag + ", mTroopInfoData.isOwnerOrAdim() = " + isAdmin() + ", mTroopInfoData.cGroupOption=" + this.cGroupOption + ", isPayToJoinTroop=" + bool1);
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
  
  public boolean isAutoApprovalOpen()
  {
    return (this.dwGroupFlagExt3 & 0x100000) == 1048576L;
  }
  
  public boolean isDisband()
  {
    return this.exitTroopReason == 2;
  }
  
  public boolean isExited()
  {
    return this.exitTroopReason != 0;
  }
  
  public boolean isFansTroop()
  {
    return this.dwGroupClassExt == 27L;
  }
  
  public boolean isGameBind()
  {
    return (this.dwGroupFlagExt3 & 0x800) != 0L;
  }
  
  public boolean isGameTroop()
  {
    return this.dwGroupClassExt == 25L;
  }
  
  public boolean isHistoryMsgReadEnableForNewMember()
  {
    return this.isAllowHistoryMsgFlag == 1;
  }
  
  public boolean isHomeworkTroop()
  {
    return this.dwGroupClassExt == 32L;
  }
  
  public boolean isKicked()
  {
    return this.exitTroopReason == 1;
  }
  
  public boolean isKingBattleTroop()
  {
    boolean bool2 = false;
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("TroopInfo", 0, "hlGuildAppid:" + this.hlGuildAppid + ",subType:" + this.hlGuildSubType);
    }
    boolean bool1 = bool2;
    if (this.hlGuildAppid == 1104466820L)
    {
      bool1 = bool2;
      if (this.hlGuildSubType == 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isListenTogetherOpen()
  {
    return (this.dwGroupFlagExt3 & 0x200000) != 0L;
  }
  
  public boolean isNeedClearAutoApproval()
  {
    return (this.cGroupOption != 2) || ((this.troopPrivilegeFlag & 0x200) == 512L);
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
  
  public boolean isSharingLocation()
  {
    if ((this.dwGroupFlagExt3 & 0x4000000) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("TroopInfo", 2, new Object[] { "isSharingLocation: invoked. ", " is: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean isShowQzoneEntrance()
  {
    return (this.dwGroupFlagExt3 & 0x20000) == 0L;
  }
  
  public boolean isThirdAppBind()
  {
    return this.hlGuildBinary != 1;
  }
  
  public boolean isTogetherBusinessOpen(int paramInt)
  {
    return (this.dwGroupFlagExt3 & paramInt) != 0L;
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
  
  public boolean isTroopHonorOpen()
  {
    return (this.dwGroupFlagExt3 & 0x2000000) == 0L;
  }
  
  public boolean isTroopOwner(String paramString)
  {
    return (paramString != null) && (paramString.equals(this.troopowneruin));
  }
  
  public boolean isUseClassAvatar()
  {
    return (!this.isNewTroop) && ((this.dwGroupFlagExt & 0x20000) != 0L);
  }
  
  public boolean isWatchTogetherOpen()
  {
    return (this.dwGroupFlagExt3 & 0x400000) != 0L;
  }
  
  public boolean messageEnablePreview()
  {
    return !isCmdUinFlagEx2Open(this.cmdUinFlagEx2, 1024);
  }
  
  public boolean messageEnableSound()
  {
    return !isCmdUinFlagEx2Open(this.cmdUinFlagEx2, 2048);
  }
  
  public boolean messageEnableVibrate()
  {
    return !isCmdUinFlagEx2Open(this.cmdUinFlagEx2, 4096);
  }
  
  public ArrayList<Long> parseTroopMemeberList()
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
              if (com.tencent.TMG.utils.QLog.isColorLevel()) {
                com.tencent.TMG.utils.QLog.d("troopInfo_member", 0, "parse error: " + arrayOfString[i]);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void postRead()
  {
    super.postRead();
    ArrayList localArrayList = new ArrayList(8);
    if (!TextUtils.isEmpty(this.mTroopPicListJson)) {}
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.mTroopPicListJson);
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            Object localObject = localJSONArray.getJSONObject(i);
            String str = ((JSONObject)localObject).getString("id");
            localObject = ((JSONObject)localObject).optString("clip");
            if (TextUtils.isEmpty(str)) {
              break label231;
            }
            TroopClipPic localTroopClipPic = new TroopClipPic();
            if (str.equals(String.valueOf(this.mTroopAvatarId))) {
              localTroopClipPic.type = 1;
            }
            localTroopClipPic.id = str;
            localTroopClipPic.clipInfo = ((String)localObject);
            localArrayList.add(localTroopClipPic);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.mTroopPicList.clear();
        this.mTroopPicList.addAll(localArrayList);
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.i("TroopInfo", 0, String.format("postRead troopUin=%s avatarId=%d mTroopPicListJson=%s", new Object[] { this.troopuin, Integer.valueOf(this.mTroopAvatarId), this.mTroopPicListJson }));
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      label231:
      i += 1;
    }
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1271	aukm:prewrite	()V
    //   4: new 1224	org/json/JSONArray
    //   7: dup
    //   8: invokespecial 1272	org/json/JSONArray:<init>	()V
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 248	com/tencent/mobileqq/data/TroopInfo:mTroopPicList	Ljava/util/List;
    //   16: invokeinterface 329 1 0
    //   21: astore_2
    //   22: aload_2
    //   23: invokeinterface 286 1 0
    //   28: ifeq +83 -> 111
    //   31: aload_2
    //   32: invokeinterface 290 1 0
    //   37: checkcast 331	com/tencent/mobileqq/activity/photo/TroopClipPic
    //   40: astore_3
    //   41: aload_3
    //   42: getfield 1247	com/tencent/mobileqq/activity/photo/TroopClipPic:id	Ljava/lang/String;
    //   45: invokestatic 313	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifne -26 -> 22
    //   51: new 1235	org/json/JSONObject
    //   54: dup
    //   55: invokespecial 1273	org/json/JSONObject:<init>	()V
    //   58: astore 4
    //   60: aload 4
    //   62: ldc_w 1233
    //   65: aload_3
    //   66: getfield 1247	com/tencent/mobileqq/activity/photo/TroopClipPic:id	Ljava/lang/String;
    //   69: invokevirtual 1276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload_3
    //   74: getfield 1250	com/tencent/mobileqq/activity/photo/TroopClipPic:clipInfo	Ljava/lang/String;
    //   77: invokestatic 313	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +16 -> 96
    //   83: aload 4
    //   85: ldc_w 1239
    //   88: aload_3
    //   89: getfield 1250	com/tencent/mobileqq/activity/photo/TroopClipPic:clipInfo	Ljava/lang/String;
    //   92: invokevirtual 1276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_1
    //   97: aload 4
    //   99: invokevirtual 1279	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   102: pop
    //   103: goto -81 -> 22
    //   106: astore_2
    //   107: aload_2
    //   108: invokevirtual 1251	org/json/JSONException:printStackTrace	()V
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual 1280	org/json/JSONArray:toString	()Ljava/lang/String;
    //   116: putfield 257	com/tencent/mobileqq/data/TroopInfo:mTroopPicListJson	Ljava/lang/String;
    //   119: invokestatic 694	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   122: ifeq +43 -> 165
    //   125: ldc 61
    //   127: iconst_0
    //   128: ldc_w 1282
    //   131: iconst_3
    //   132: anewarray 1173	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: getfield 866	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: aload_0
    //   145: getfield 820	com/tencent/mobileqq/data/TroopInfo:mTroopAvatarId	I
    //   148: invokestatic 1083	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: dup
    //   153: iconst_2
    //   154: aload_0
    //   155: getfield 257	com/tencent/mobileqq/data/TroopInfo:mTroopPicListJson	Ljava/lang/String;
    //   158: aastore
    //   159: invokestatic 1264	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   162: invokestatic 1267	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: return
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 1268	java/lang/Exception:printStackTrace	()V
    //   171: goto -60 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	TroopInfo
    //   11	102	1	localJSONArray	JSONArray
    //   21	11	2	localIterator	Iterator
    //   106	2	2	localJSONException	JSONException
    //   166	2	2	localException	Exception
    //   40	49	3	localTroopClipPic	TroopClipPic
    //   58	40	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   12	22	106	org/json/JSONException
    //   22	96	106	org/json/JSONException
    //   96	103	106	org/json/JSONException
    //   12	22	166	java/lang/Exception
    //   22	96	166	java/lang/Exception
    //   96	103	166	java/lang/Exception
  }
  
  public void setAutoApprovalOpen(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.dwGroupFlagExt3 |= 0x100000;; this.dwGroupFlagExt3 &= 0xFFEFFFFF)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("TroopInfo", 0, String.format("setAutoApprovalOpen [%s, %s]", new Object[] { Long.valueOf(this.dwGroupFlagExt3), Boolean.valueOf(paramBoolean) }));
      }
      return;
    }
  }
  
  public void setCmdUinFlagEx2(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.cmdUinFlagEx2 |= paramInt;
      return;
    }
    this.cmdUinFlagEx2 &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void setIsListenTogether(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dwGroupFlagExt3 |= 0x200000;
      return;
    }
    this.dwGroupFlagExt3 &= 0xFFDFFFFF;
  }
  
  public void setIsSharingLocation(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dwGroupFlagExt3 |= 0x4000000;
      return;
    }
    this.dwGroupFlagExt3 &= 0xFBFFFFFF;
  }
  
  public void setIsWatchTogether(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dwGroupFlagExt3 |= 0x400000;
      return;
    }
    this.dwGroupFlagExt3 &= 0xFFBFFFFF;
  }
  
  public void setLastMemoData(oidb_0x8f9.GroupFeedsRecord paramGroupFeedsRecord)
  {
    if (paramGroupFeedsRecord != null) {}
    for (;;)
    {
      try
      {
        group_feeds.GroupFeedsMessage localGroupFeedsMessage = (group_feeds.GroupFeedsMessage)paramGroupFeedsRecord.msg_feeds_content.get();
        paramGroupFeedsRecord = balq.a(String.valueOf(paramGroupFeedsRecord.uint32_feeds_type.get()), localGroupFeedsMessage.toByteArray(), true);
        if (paramGroupFeedsRecord == null) {
          continue;
        }
        this.strLastAnnouncement = paramGroupFeedsRecord.c;
      }
      catch (Throwable paramGroupFeedsRecord)
      {
        paramGroupFeedsRecord.printStackTrace();
        this.strLastAnnouncement = "";
        continue;
      }
      if (this.strLastAnnouncement == null) {
        this.strLastAnnouncement = "";
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("TroopInfo", 0, "setLastMemoData : " + this.strLastAnnouncement);
      }
      return;
      this.strLastAnnouncement = "";
      continue;
      this.strLastAnnouncement = "";
    }
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
  
  public void setTogetherBusiness(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.dwGroupFlagExt3 |= paramInt;
      return;
    }
    this.dwGroupFlagExt3 &= (paramInt ^ 0xFFFFFFFF);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public void setTroopLevelMap(List<stLevelRankPair> paramList)
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
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setTroopLevelMap:" + this.troopuin + ", old=" + this.troopLevelMap);
        }
        this.troopLevelMap = troopLevelMapToString(localHashMap);
        this.mCachedLevelMap = localHashMap;
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setTroopLevelMap:" + this.troopuin + ", new=" + this.troopLevelMap);
        }
      }
      return;
    }
    finally {}
  }
  
  @SuppressLint({"UseSparseArrays"})
  public void setTroopLevelMap787(List<oidb_0x787.LevelName> paramList)
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
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setTroopLevelMap787:" + this.troopuin + ", old=" + this.troopLevelMap);
        }
        this.troopLevelMap = troopLevelMapToString(localHashMap);
        this.mCachedLevelMap = localHashMap;
        if (com.tencent.TMG.utils.QLog.isColorLevel()) {
          com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setTroopLevelMap787:" + this.troopuin + ", new=" + this.troopLevelMap);
        }
      }
      return;
    }
    finally {}
  }
  
  public void setUseClassAvatar(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dwGroupFlagExt |= 0x20000;
      return;
    }
    this.dwGroupFlagExt &= 0xFFFDFFFF;
  }
  
  public String toString()
  {
    Object localObject2 = this.troopuin;
    String str = this.newTroopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "[no uin]";
    }
    localObject2 = str;
    if (TextUtils.isEmpty(str)) {
      localObject2 = "[no name]";
    }
    return "TroopInfo: {uin = " + (String)localObject1 + ", name = " + (String)localObject2 + "}";
  }
  
  public void updateHeadMemberList(ArrayList<String> paramArrayList)
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("TroopInfo", 0, "updateHeadMemberList");
    }
    this.mHeaderUinsNew = GroupIconHelper.a(GroupIconHelper.a(paramArrayList, this), false);
  }
  
  public void updateHeadMemberUins(List<oidb_0x899.memberlist> paramList)
  {
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.d("TroopInfo", 0, "updateHeadMemberUins");
    }
    int i;
    ArrayList localArrayList;
    int j;
    label37:
    oidb_0x899.memberlist localmemberlist;
    if (paramList != null)
    {
      i = paramList.size();
      localArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label117;
      }
      localmemberlist = (oidb_0x899.memberlist)paramList.get(j);
      if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has())) {
        break label82;
      }
    }
    for (;;)
    {
      j += 1;
      break label37;
      i = 0;
      break;
      label82:
      localArrayList.add("" + localmemberlist.uint64_member_uin.get());
    }
    label117:
    this.mHeaderUinsNew = GroupIconHelper.a(GroupIconHelper.a(localArrayList, this), false);
  }
  
  public void updateLastMemoFromWeb(String paramString)
  {
    this.strLastAnnouncement = paramString;
    if (this.strLastAnnouncement == null) {
      this.strLastAnnouncement = "";
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("TroopInfo", 0, "updateLastMemoFromWeb : " + this.strLastAnnouncement);
    }
  }
  
  public void updateQZonePhotoUrls(ArrayList<String> paramArrayList)
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
  
  public void updateSomeMemberUins(List<oidb_0x899.memberlist> paramList)
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