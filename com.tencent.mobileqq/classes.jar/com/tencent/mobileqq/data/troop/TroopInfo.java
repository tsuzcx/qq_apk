package com.tencent.mobileqq.data.troop;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x787.oidb_0x787.LevelName;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupSchoolInfo;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.GroupInfoExt;

public class TroopInfo
  extends Entity
  implements Serializable
{
  public static final int ALLOW_HISTORY_MSG_READ_FOR_NEW_MEMBER = 4;
  public static final int ALLOW_UPLOAD_TROOP_ALBUM = 1;
  public static final int ALLOW_UPLOAD_TROOP_FILE = 2;
  public static final int CMDUIN_FLAG_EX3_SHOW_GAME_CARD = 1;
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
  public static final int G_FLAG_EX4_HAS_SCHOOL_GROUP_INFO = 128;
  public static final int G_FLAG_EX4_TROOP_GAME_CARD_ENABLED = 4096;
  public static final int G_FLAG_EX4_TROOP_IS_LIVE = 1024;
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
  public static final String QIDIAN_TROOP_MEMBER_DEF_NICK = HardCodeUtil.a(2131890817);
  public static final int QZONE_TROOP_ENTRANCE = 131072;
  public static final int SET_DEFAULT_PIC = 1;
  public static final String TABLE_NAME = "TroopInfoV2";
  public static final String TAG = "TroopInfo";
  public static final int TROOP_AUTO_APPROVAL = 1048576;
  public static final int TROOP_AVGAME_IS_OPENING = 268435456;
  public static final int TROOP_AVGAME_ONLY_ALLOW_MANAGER_CREATE = 536870912;
  public static final int TROOP_GAME_BIND = 2048;
  public static final int TROOP_HONOR_AIO_SWITCH = 33554432;
  public static final int TROOP_LISTEN_TOGETHER = 2097152;
  public static final long TROOP_NAME_TIME_LIMIT = 86400000L;
  public static final int TROOP_PRIVILEGE_INVITE_NEED_REVIEW = 101711872;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW = 1048576;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_100 = 67108864;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_50 = 33554432;
  public static final int TROOP_SHARE_LOCATION = 67108864;
  public static final int TROOP_SING_TOGETHER = 16777216;
  public static final int TROOP_STUDY_ROOM_OPEN = 256;
  public static final int TROOP_WATCH_TOGETHER = 4194304;
  public static final int TROOP_WRITE_TOGETHER_SWITCH = 1073741824;
  public static final int TYPE_0X810_GROUP_RING_TONG_ID = 9;
  public static final int TYPE_0X810_GROUP_RING_TONG_SWITCH = 2048;
  public static final int TYPE_0X810_GROUP_VIBRATE_SWITCH = 4096;
  public static final int TYPE_0X810_MSG_HIDE_SWITCH = 512;
  public static final int TYPE_0X810_MSG_PREVIEW_SWITCH = 1024;
  public String Administrator;
  public String adminNameShow;
  public int allowMemberAtAll;
  public int allowMemberKick;
  public int allowMemberModifTroopName;
  public long appealDeadline = 0L;
  public long associatePubAccount;
  public byte cAlbumResult = 0;
  public short cGroupLevel;
  public short cGroupOption;
  public byte cGroupRankSysFlag = 0;
  public byte cGroupRankUserFlag = 0;
  public byte cNewGroupRankUserFlag = 0;
  public long cmdUinFlagEx2 = 0L;
  public long cmduinFlagEx3Grocery = 0L;
  public String dailyNewMemberUins;
  public long dwAdditionalFlag;
  public long dwAppPrivilegeFlag = 0L;
  public long dwAuthGroupType = 0L;
  public long dwCmdUinJoinTime;
  public long dwCmdUinUinFlag;
  public long dwGagTimeStamp;
  public long dwGagTimeStamp_me;
  public long dwGroupClassExt;
  public long dwGroupFlag;
  public long dwGroupFlagExt = 0L;
  public long dwGroupFlagExt3 = 0L;
  public long dwGroupInfoSeq = 0L;
  public long dwGroupLevelSeq;
  public long dwLastBAFTipMsgUniSeq;
  public long dwLastBAFTipMsgUniSeq2;
  public long dwLastInsertBAFTipTime;
  public long dwOfficeMode = 0L;
  public long dwTimeStamp = 0L;
  public int eliminated = 0;
  public int exitTroopReason = 0;
  public String feeds_id;
  public String fingertroopmemo;
  public int gameSwitchStatus = 0;
  public int grade;
  @notColumn
  public long groupAllianceid = 0L;
  public String groupCardPrefixIntro;
  public String groupCardPrefixJson;
  public int groupFlagExt4;
  public int groupFreezeReason;
  public boolean hasSetNewTroopHead;
  public boolean hasSetNewTroopName;
  public long hlGuildAppid;
  public int hlGuildBinary = 1;
  public int hlGuildOrgid;
  public long hlGuildSubType;
  public int isAllowHistoryMsgFlag = 0;
  public boolean isNewTroop;
  public int isShowInNearbyTroops = -1;
  public boolean isTroopBlocked = false;
  public String joinTroopAnswer;
  public String joinTroopQuestion;
  public long lastMsgTime = 0L;
  public long lastMsgUpdateMyHonorRichTime;
  public String location;
  public String mAtOrReplyMeUins;
  ConcurrentHashMap<Integer, String> mCachedLevelMap;
  ConcurrentHashMap<Integer, String> mCachedNewLevelMap;
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
  public int mQZonePhotoNum = 0;
  public String mRichFingerMemo;
  public String mSomeMemberUins;
  public String mTags;
  public int mTroopAvatarId;
  public int mTroopFileVideoIsWhite;
  public long mTroopFileVideoReqInterval;
  @notColumn
  public TroopInfoExt mTroopInfoExtObj = new TroopInfoExt();
  public float mTroopNeedPayNumber = 0.0F;
  @notColumn
  public List<TroopClipPic> mTroopPicList = new ArrayList(8);
  public String mTroopPicListJson = "";
  @notColumn
  public Set<String> mTroopVerifyingPics = new HashSet();
  public int maxAdminNum;
  public int maxInviteMemNum;
  public String memberListToShow;
  public String myHonorList;
  public byte myHonorRichFlag;
  public int nMsgLimitFreq = 0;
  public int nTroopGrade;
  public String newTroopLevelMap;
  public String newTroopName;
  public long newTroopNameTimeStamp;
  public String oldTroopName;
  public String ownerNameShow;
  public String school;
  public int showGameSwitchStatus = 0;
  public String strLastAnnouncement = null;
  public String strLocation;
  public String strQZonePhotoUrls;
  public long timeSec;
  public String topicId;
  public String troopAuthenticateInfo;
  public long troopCreateTime;
  public long troopCreditLevel = 5L;
  public long troopCreditLevelInfo = 0L;
  public int troopHonorGrayFlag;
  public byte[] troopInfoExtByte;
  public int troopLat = 0;
  public String troopLevelMap;
  public int troopLon = 0;
  public long troopPrivilegeFlag = 0L;
  public String troopRemark;
  public int troopRepeatType = 0;
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
    int j;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localStringBuilder.append((String)paramArrayList.next());
      localStringBuilder.append("|");
      j = i + 1;
      i = j;
    } while (j <= paramInt);
    return localStringBuilder.toString();
  }
  
  private void coverFrom_TroopLocal(oidb_0x88d.GroupInfo paramGroupInfo)
  {
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
  }
  
  private void coverFrom_TroopMemo(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo.string_group_finger_memo.has()) {
      this.fingertroopmemo = paramGroupInfo.string_group_finger_memo.get().toStringUtf8();
    } else {
      this.fingertroopmemo = "";
    }
    if (paramGroupInfo.string_group_rich_finger_memo.has()) {
      this.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
    } else {
      this.mRichFingerMemo = "";
    }
    if (TextUtils.isEmpty(this.mRichFingerMemo))
    {
      this.mRichFingerMemo = this.fingertroopmemo;
      return;
    }
    this.mRichFingerMemo = TroopInfoUtil.a(this.mRichFingerMemo);
    this.mRichFingerMemo = TroopInfoUtil.b(this.mRichFingerMemo);
  }
  
  private void coverFrom_longGroupName(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (((paramGroupInfo.string_long_group_name.has()) && (!this.isNewTroop)) || (this.hasSetNewTroopName))
    {
      paramGroupInfo = paramGroupInfo.string_long_group_name.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramGroupInfo))
      {
        this.troopname = paramGroupInfo;
        if (this.newTroopName == null) {
          this.newTroopName = paramGroupInfo;
        }
      }
    }
  }
  
  private int entityByCursor_getValue(Cursor paramCursor, String paramString, int paramInt)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if (i > 0) {
      return paramCursor.getInt(i);
    }
    return paramInt;
  }
  
  private long entityByCursor_getValue(Cursor paramCursor, String paramString, long paramLong)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if (i > 0) {
      return paramCursor.getLong(i);
    }
    return paramLong;
  }
  
  private String entityByCursor_getValue(Cursor paramCursor, String paramString1, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (i > 0) {
      return paramCursor.getString(i);
    }
    return paramString2;
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
    return ((paramLong | 0x20) & paramInt) != 0L;
  }
  
  public static boolean isCmdUinFlagEx2Open(long paramLong, int paramInt)
  {
    return (paramLong & paramInt) != 0L;
  }
  
  public static boolean isQidianPrivateTroop(long paramLong)
  {
    return (paramLong & 0x20) != 0L;
  }
  
  public static boolean isVisitorSpeakEnabled(int paramInt)
  {
    return (paramInt & 0x2000) == 8192;
  }
  
  private void postRead_troopInfoExt()
  {
    if (this.troopInfoExtByte != null) {
      try
      {
        oidb_0xef0.GroupInfoExt localGroupInfoExt = new oidb_0xef0.GroupInfoExt();
        localGroupInfoExt.mergeFrom(this.troopInfoExtByte);
        this.mTroopInfoExtObj = TroopInfoExt.parseFromGroupInfoExt(localGroupInfoExt);
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  private void postRead_troopPicList()
  {
    ArrayList localArrayList = new ArrayList(8);
    if (!TextUtils.isEmpty(this.mTroopPicListJson)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.mTroopPicListJson);
        if (localJSONArray.length() > 0)
        {
          int i = 0;
          while (i < localJSONArray.length())
          {
            Object localObject = localJSONArray.getJSONObject(i);
            String str = ((JSONObject)localObject).getString("id");
            localObject = ((JSONObject)localObject).optString("clip");
            if (!TextUtils.isEmpty(str))
            {
              TroopClipPic localTroopClipPic = new TroopClipPic();
              if (str.equals(String.valueOf(this.mTroopAvatarId))) {
                localTroopClipPic.type = 1;
              }
              localTroopClipPic.id = str;
              localTroopClipPic.clipInfo = ((String)localObject);
              localArrayList.add(localTroopClipPic);
            }
            i += 1;
          }
        }
        this.mTroopPicList.clear();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    this.mTroopPicList.addAll(localArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfo", 2, String.format("postRead troopUin=%s avatarId=%d mTroopPicListJson=%s", new Object[] { this.troopuin, Integer.valueOf(this.mTroopAvatarId), this.mTroopPicListJson }));
    }
  }
  
  private void prewrite_troopInfoExt()
  {
    TroopInfoExt localTroopInfoExt = this.mTroopInfoExtObj;
    if (localTroopInfoExt != null) {
      this.troopInfoExtByte = localTroopInfoExt.convToGroupInfoExt().toByteArray();
    }
  }
  
  private void prewrite_troopPicList()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.mTroopPicList.iterator();
      while (localIterator.hasNext())
      {
        TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
        if (!TextUtils.isEmpty(localTroopClipPic.id))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("id", localTroopClipPic.id);
          if (!TextUtils.isEmpty(localTroopClipPic.clipInfo)) {
            localJSONObject.put("clip", localTroopClipPic.clipInfo);
          }
          localJSONArray.put(localJSONObject);
        }
      }
      this.mTroopPicListJson = localJSONArray.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfo", 2, String.format("prewrite troopUin=%s avatarId=%d mTroopPicListJson=%s", new Object[] { this.troopuin, Integer.valueOf(this.mTroopAvatarId), this.mTroopPicListJson }));
    }
  }
  
  public static String setTags(List<oidb_0x88d.TagRecord> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (oidb_0x88d.TagRecord)localIterator.next();
        if (paramList.bytes_tag_value.has())
        {
          paramList = paramList.bytes_tag_value.get().toStringUtf8();
          try
          {
            paramList = new String(paramList.getBytes("utf-8"));
          }
          catch (UnsupportedEncodingException paramList)
          {
            paramList.printStackTrace();
            paramList = "";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramList);
          localStringBuilder.append("\n");
          localStringBuffer.append(localStringBuilder.toString());
        }
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    return localStringBuffer.toString();
  }
  
  protected static String troopLevelMapToString(ConcurrentHashMap<Integer, String> paramConcurrentHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramConcurrentHashMap.size();
    paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
    int i = 0;
    while (paramConcurrentHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramConcurrentHashMap.next();
      int k = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = (String)((Map.Entry)localObject).getValue();
      localStringBuilder.append(k);
      localStringBuilder.append("");
      localStringBuilder.append((String)localObject);
      if (i != j - 1) {
        localStringBuilder.append("\001");
      }
      i += 1;
    }
    return localStringBuilder.toString();
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
    coverFrom_TroopMemo(paramGroupInfo);
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
    boolean bool1 = paramGroupInfo.uint32_no_finger_open_flag.has();
    boolean bool2 = false;
    if (bool1)
    {
      if (paramGroupInfo.uint32_no_finger_open_flag.get() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.mCanSearchByKeywords = bool1;
    }
    if (paramGroupInfo.uint32_no_code_finger_open_flag.has())
    {
      if (paramGroupInfo.uint32_no_code_finger_open_flag.get() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.mCanSearchByTroopUin = bool1;
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
    coverFrom_TroopLocal(paramGroupInfo);
    this.wMemberMax = paramGroupInfo.uint32_group_member_max_num.get();
    this.wMemberNum = paramGroupInfo.uint32_group_member_num.get();
    this.wMemberNumClient = this.wMemberNum;
    this.dwGroupFlagExt = paramGroupInfo.uint32_group_flag_ext.get();
    this.troopTypeExt = paramGroupInfo.uint32_group_type_flag.get();
    this.dwGroupFlag = paramGroupInfo.uint32_group_flag.get();
    if (isNewTroop()) {
      this.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_conf_group.get();
    } else {
      this.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_normal_group.get();
    }
    this.allowMemberModifTroopName = paramGroupInfo.uint32_is_allow_conf_group_member_modify_group_name.get();
    this.allowMemberKick = paramGroupInfo.uint32_is_allow_conf_group_member_nick.get();
    this.allowMemberAtAll = paramGroupInfo.uint32_is_allow_conf_group_member_at_all.get();
    coverFrom_longGroupName(paramGroupInfo);
    if (paramGroupInfo.uint32_is_group_freeze.has()) {
      this.mIsFreezed = paramGroupInfo.uint32_is_group_freeze.get();
    }
    if (paramGroupInfo.uint32_cmduin_flag_ex2.has()) {
      this.cmdUinFlagEx2 = paramGroupInfo.uint32_cmduin_flag_ex2.get();
    }
    if (paramGroupInfo.uint32_cmduin_ringtone_id.has()) {
      this.udwCmdUinRingtoneID = paramGroupInfo.uint32_cmduin_ringtone_id.get();
    }
    if (paramGroupInfo.uint32_cmduin_new_mobile_flag.has()) {
      this.troopmask = paramGroupInfo.uint32_cmduin_new_mobile_flag.get();
    }
    this.groupFlagExt4 = paramGroupInfo.uint32_group_flagext4.get();
    this.groupFreezeReason = paramGroupInfo.uint32_group_freeze_reason.get();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get flag ext4=");
      ((StringBuilder)localObject).append(this.groupFlagExt4);
      ((StringBuilder)localObject).append(" freeze reason=");
      ((StringBuilder)localObject).append(this.groupFreezeReason);
      QLog.d("TroopInfo", 1, ((StringBuilder)localObject).toString());
    }
    if (paramGroupInfo.bytes_group_school_info.has())
    {
      localObject = new oidb_0x89a.GroupSchoolInfo();
      try
      {
        oidb_0x89a.GroupSchoolInfo localGroupSchoolInfo = (oidb_0x89a.GroupSchoolInfo)((oidb_0x89a.GroupSchoolInfo)localObject).mergeFrom(paramGroupInfo.bytes_group_school_info.get().toByteArray());
        localObject = localGroupSchoolInfo;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      if (((oidb_0x89a.GroupSchoolInfo)localObject).bytes_location.has()) {
        this.location = ((oidb_0x89a.GroupSchoolInfo)localObject).bytes_location.get().toStringUtf8();
      }
      if (((oidb_0x89a.GroupSchoolInfo)localObject).uint32_grade.has()) {
        this.grade = ((oidb_0x89a.GroupSchoolInfo)localObject).uint32_grade.get();
      }
      if (((oidb_0x89a.GroupSchoolInfo)localObject).bytes_school.has()) {
        this.school = ((oidb_0x89a.GroupSchoolInfo)localObject).bytes_school.get().toStringUtf8();
      }
    }
    if (paramGroupInfo.uint64_alliance_id.has()) {
      this.groupAllianceid = paramGroupInfo.uint64_alliance_id.get();
    }
    if (paramGroupInfo.st_group_info_ext.has()) {
      this.mTroopInfoExtObj = TroopInfoExt.parseFromGroupInfoExt((oidb_0xef0.GroupInfoExt)paramGroupInfo.st_group_info_ext.get());
    }
    if (paramGroupInfo.uint32_cmduin_flag_ex3_grocery.has()) {
      this.cmduinFlagEx3Grocery = paramGroupInfo.uint32_cmduin_flag_ex3_grocery.get();
    }
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
    this.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
    this.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
    this.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
    this.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
    this.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
    this.cNewGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNewGroupRankUserFlag")));
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
    this.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
    this.school = paramCursor.getString(paramCursor.getColumnIndex("school"));
    this.grade = paramCursor.getInt(paramCursor.getColumnIndex("grade"));
    this.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
    this.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
    this.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
    this.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
    this.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
    this.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
    int i = paramCursor.getInt(paramCursor.getColumnIndex("mMemberInvitingFlag"));
    boolean bool2 = false;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mMemberInvitingFlag = bool1;
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
    this.newTroopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("newTroopLevelMap"));
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
    if (paramCursor.getInt(paramCursor.getColumnIndex("mCanSearchByKeywords")) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mCanSearchByKeywords = bool1;
    if (paramCursor.getInt(paramCursor.getColumnIndex("mCanSearchByTroopUin")) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mCanSearchByTroopUin = bool1;
    if (paramCursor.getInt(paramCursor.getColumnIndex("isNewTroop")) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.isNewTroop = bool1;
    if (paramCursor.getInt(paramCursor.getColumnIndex("hasSetNewTroopHead")) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.hasSetNewTroopHead = bool1;
    if (paramCursor.getInt(paramCursor.getColumnIndex("hasSetNewTroopName")) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.hasSetNewTroopName = bool1;
    this.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
    this.feeds_id = paramCursor.getString(paramCursor.getColumnIndex("feeds_id"));
    this.troopRepeatType = paramCursor.getInt(paramCursor.getColumnIndex("troopRepeatType"));
    this.myHonorList = paramCursor.getString(paramCursor.getColumnIndex("myHonorList"));
    this.myHonorRichFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("myHonorRichFlag")));
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
      label1851:
      this.groupCardPrefixIntro = paramCursor.getString(paramCursor.getColumnIndex("groupCardPrefixIntro"));
      this.groupCardPrefixJson = paramCursor.getString(paramCursor.getColumnIndex("groupCardPrefixJson"));
      this.troopRemark = entityByCursor_getValue(paramCursor, "troopRemark", this.troopRemark);
      this.troopInfoExtByte = paramCursor.getBlob(paramCursor.getColumnIndex("troopInfoExtByte"));
      this.troopCreditLevel = entityByCursor_getValue(paramCursor, "troopCreditLevel", this.troopCreditLevel);
      this.troopCreditLevelInfo = entityByCursor_getValue(paramCursor, "troopCreditLevelInfo", this.troopCreditLevelInfo);
      bool1 = bool2;
      if (paramCursor.getInt(paramCursor.getColumnIndex("isTroopBlocked")) == 1) {
        bool1 = true;
      }
      this.isTroopBlocked = bool1;
      this.appealDeadline = entityByCursor_getValue(paramCursor, "appealDeadline", this.appealDeadline);
      this.dwGroupFlagExt3 = entityByCursor_getValue(paramCursor, "dwGroupFlagExt3", this.dwGroupFlagExt3);
      this.dwCmdUinJoinTime = entityByCursor_getValue(paramCursor, "dwCmdUinJoinTime", this.dwCmdUinJoinTime);
      this.cmdUinFlagEx2 = entityByCursor_getValue(paramCursor, "cmdUinFlagEx2", this.cmdUinFlagEx2);
      this.udwCmdUinRingtoneID = entityByCursor_getValue(paramCursor, "udwCmdUinRingtoneID", this.udwCmdUinRingtoneID);
      this.dwLastInsertBAFTipTime = entityByCursor_getValue(paramCursor, "dwLastInsertBAFTipTime", this.dwLastInsertBAFTipTime);
      this.wInsertBAFTipCount = entityByCursor_getValue(paramCursor, "wInsertBAFTipCount", this.wInsertBAFTipCount);
      this.wClickBAFTipCount = entityByCursor_getValue(paramCursor, "wClickBAFTipCount", this.wClickBAFTipCount);
      this.dwLastBAFTipMsgUniSeq = entityByCursor_getValue(paramCursor, "dwLastBAFTipMsgUniSeq", this.dwLastBAFTipMsgUniSeq);
      this.dwLastBAFTipMsgUniSeq2 = entityByCursor_getValue(paramCursor, "dwLastBAFTipMsgUniSeq2", this.dwLastBAFTipMsgUniSeq2);
      this.dailyNewMemberUins = entityByCursor_getValue(paramCursor, "dailyNewMemberUins", this.dailyNewMemberUins);
      this.exitTroopReason = entityByCursor_getValue(paramCursor, "exitTroopReason", this.exitTroopReason);
      this.eliminated = entityByCursor_getValue(paramCursor, "eliminated", this.eliminated);
      this.strLastAnnouncement = entityByCursor_getValue(paramCursor, "strLastAnnouncement", this.strLastAnnouncement);
      this.nMsgLimitFreq = entityByCursor_getValue(paramCursor, "nMsgLimitFreq", this.nMsgLimitFreq);
      this.hlGuildAppid = entityByCursor_getValue(paramCursor, "hlGuildAppid", this.hlGuildAppid);
      this.hlGuildSubType = entityByCursor_getValue(paramCursor, "hlGuildSubType", this.hlGuildSubType);
      this.mAtOrReplyMeUins = entityByCursor_getValue(paramCursor, "mAtOrReplyMeUins", this.mAtOrReplyMeUins);
      this.groupFreezeReason = entityByCursor_getValue(paramCursor, "groupFreezeReason", this.groupFreezeReason);
      this.groupFlagExt4 = entityByCursor_getValue(paramCursor, "groupFlagExt4", this.groupFlagExt4);
      this.troopHonorGrayFlag = entityByCursor_getValue(paramCursor, "troopHonorGrayFlag", this.troopHonorGrayFlag);
      this.lastMsgUpdateMyHonorRichTime = entityByCursor_getValue(paramCursor, "lastMsgUpdateMyHonorRichTime", this.lastMsgUpdateMyHonorRichTime);
      this.isAllowHistoryMsgFlag = entityByCursor_getValue(paramCursor, "isAllowHistoryMsgFlag", this.isAllowHistoryMsgFlag);
      this.troopRepeatType = entityByCursor_getValue(paramCursor, "troopRepeatType", this.troopRepeatType);
      this.cmduinFlagEx3Grocery = entityByCursor_getValue(paramCursor, "cmduinFlagEx3Grocery", this.cmduinFlagEx3Grocery);
      if (QLog.isColorLevel())
      {
        paramCursor = new StringBuilder();
        paramCursor.append("fightgag._troopinfo.dwGagTimeStamp_me = ");
        paramCursor.append(this.dwGagTimeStamp_me);
        paramCursor.append(",troopuin = ");
        paramCursor.append(this.troopuin);
        QLog.d("TroopInfo", 2, paramCursor.toString());
      }
      return true;
    }
    catch (Exception localException)
    {
      break label1851;
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
  
  public ArrayList<String> getGroupCardPrefix()
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    String str1;
    if (!TextUtils.isEmpty(this.groupCardPrefixJson))
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(this.groupCardPrefixJson);
        i = 0;
        while (i < localJSONArray.length())
        {
          str1 = localJSONArray.getString(i);
          if (!TextUtils.isEmpty(str1)) {
            localArrayList.add(str1);
          }
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break label141;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    else
    {
      String str2 = this.troopuin;
      i = localArrayList.size();
      str1 = this.groupCardPrefixJson;
      Object localObject = str1;
      if (str1 == null) {
        localObject = "";
      }
      QLog.d("TroopInfo", 2, String.format("getPresetNickWords troopUin=%s groupCardPrefix size=%d groupCardPrefixes=%s", new Object[] { str2, Integer.valueOf(i), localObject }));
    }
    label141:
    return localArrayList;
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
  
  public int getMemNumForAutoInviteIntoGroup(String paramString)
  {
    long l = this.troopPrivilegeFlag;
    int i;
    if ((l & 0x100000) == 1048576L) {
      i = -1;
    } else if ((l & 0x2000000) == 33554432L) {
      i = 50;
    } else if ((l & 0x4000000) == 67108864L) {
      i = 100;
    } else {
      i = 0;
    }
    int j;
    if ((!isTroopOwner(paramString)) && (!isTroopAdmin(paramString))) {
      j = 0;
    } else {
      j = 1;
    }
    if ((!hasInviteMemAuth()) && (j == 0)) {
      return 0;
    }
    if ((i != -1) && (j == 0)) {
      return Math.min(this.maxInviteMemNum, i);
    }
    return this.maxInviteMemNum;
  }
  
  public int getMemberNum()
  {
    return this.wMemberNum;
  }
  
  public int getMemberNumClient()
  {
    return this.wMemberNumClient;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public ConcurrentHashMap<Integer, String> getNewTroopLevelMap()
  {
    Object localObject = this.mCachedNewLevelMap;
    if (((localObject == null) || (((ConcurrentHashMap)localObject).size() == 0)) && (this.mCachedNewLevelMap == null))
    {
      this.mCachedNewLevelMap = new ConcurrentHashMap();
      localObject = this.newTroopLevelMap;
      if (localObject != null)
      {
        localObject = ((String)localObject).split("\001");
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          while (i < localObject.length)
          {
            String[] arrayOfString = localObject[i].split("");
            if (arrayOfString.length == 2) {}
            try
            {
              this.mCachedNewLevelMap.put(Integer.valueOf(Integer.parseInt(arrayOfString[0])), arrayOfString[1]);
            }
            catch (Exception localException)
            {
              label107:
              StringBuilder localStringBuilder;
              break label107;
            }
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("getNewTroopLevelMap, catch exception, key: ");
              localStringBuilder.append(arrayOfString[0]);
              localStringBuilder.append(" value: ");
              localStringBuilder.append(arrayOfString[1]);
              QLog.d("TroopInfo", 2, localStringBuilder.toString());
            }
            i += 1;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getNewTroopLevelMap:");
        ((StringBuilder)localObject).append(this.troopuin);
        ((StringBuilder)localObject).append(", create cache");
        QLog.d("TroopInfo", 2, ((StringBuilder)localObject).toString());
      }
    }
    return this.mCachedNewLevelMap;
  }
  
  public String getNewTroopNameOrTroopName()
  {
    if (hasSetTroopName()) {
      return this.troopname;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = BaseApplication.processName;
    if (!TextUtils.isEmpty(this.newTroopName))
    {
      if ((System.currentTimeMillis() - this.newTroopNameTimeStamp > 86400000L) && (!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
        ((ITroopNameHelperService)localAppRuntime.getRuntimeService(ITroopNameHelperService.class, "")).updateTroopName(this.troopuin);
      }
      return this.newTroopName;
    }
    if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
      ((ITroopNameHelperService)localAppRuntime.getRuntimeService(ITroopNameHelperService.class, "")).updateTroopName(this.troopuin);
    }
    return this.troopname;
  }
  
  public List<String> getSomeMemberUins()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.mSomeMemberUins;
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      int i = 0;
      int j = this.mSomeMemberUins.indexOf('|', 0);
      int k = this.mSomeMemberUins.length();
      String str;
      while ((j >= i) && (j < k))
      {
        if (i < j)
        {
          str = this.mSomeMemberUins.substring(i, j);
          localObject = str;
          if (str != null) {
            localObject = str.trim();
          }
          if ((localObject != null) && (((String)localObject).length() > 0)) {
            localArrayList.add(localObject);
          }
        }
        i = j + 1;
        j = this.mSomeMemberUins.indexOf('|', i);
      }
      if (i < k)
      {
        str = this.mSomeMemberUins.substring(i, k);
        localObject = str;
        if (str != null) {
          localObject = str.trim();
        }
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean getStudyRoomOpen()
  {
    return checkFlagExt4(256);
  }
  
  public String getTableName()
  {
    return "TroopInfoV2";
  }
  
  public String getTroopDisplayName()
  {
    if (!TextUtils.isEmpty(this.troopRemark)) {
      return this.troopRemark;
    }
    return getNewTroopNameOrTroopName();
  }
  
  @SuppressLint({"UseSparseArrays"})
  public ConcurrentHashMap<Integer, String> getTroopLevelMap()
  {
    Object localObject = this.mCachedLevelMap;
    if (((localObject == null) || (((ConcurrentHashMap)localObject).size() == 0)) && (this.mCachedLevelMap == null))
    {
      this.mCachedLevelMap = new ConcurrentHashMap();
      localObject = this.troopLevelMap;
      if (localObject != null)
      {
        localObject = ((String)localObject).split("\001");
        if ((localObject != null) && (localObject.length > 0))
        {
          int i = 0;
          while (i < localObject.length)
          {
            String[] arrayOfString = localObject[i].split("");
            if (arrayOfString.length == 2) {}
            try
            {
              this.mCachedLevelMap.put(Integer.valueOf(Integer.parseInt(arrayOfString[0])), arrayOfString[1]);
            }
            catch (Exception localException)
            {
              label107:
              StringBuilder localStringBuilder;
              break label107;
            }
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("getOldTroopLevelMap, catch exception, key: ");
              localStringBuilder.append(arrayOfString[0]);
              localStringBuilder.append(" value: ");
              localStringBuilder.append(arrayOfString[1]);
              QLog.d("TroopInfo", 2, localStringBuilder.toString());
            }
            i += 1;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getOldTroopLevelMap:");
        ((StringBuilder)localObject).append(this.troopuin);
        ((StringBuilder)localObject).append(", create cache");
        QLog.d("TroopInfo", 2, ((StringBuilder)localObject).toString());
      }
    }
    return this.mCachedLevelMap;
  }
  
  public String getTroopUin()
  {
    return this.troopuin;
  }
  
  public boolean hasInviteMemAuth()
  {
    boolean bool;
    if ((hasPayPrivilege(this.troopPrivilegeFlag, 128)) && (hasPayPrivilege(this.troopPrivilegeFlag, 512))) {
      bool = true;
    } else {
      bool = false;
    }
    if (((!this.mMemberInvitingFlag) && (!isAdmin())) || ((!isAdmin()) && (this.cGroupOption == 3) && (!bool)))
    {
      if (QLog.isColorLevel())
      {
        String str = TroopInfo.class.getSimpleName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hasInviteMemAuth：mMemberInvitingFlag=");
        localStringBuilder.append(this.mMemberInvitingFlag);
        localStringBuilder.append(", mTroopInfoData.isOwnerOrAdim() = ");
        localStringBuilder.append(isAdmin());
        localStringBuilder.append(", mTroopInfoData.cGroupOption=");
        localStringBuilder.append(this.cGroupOption);
        localStringBuilder.append(", isPayToJoinTroop=");
        localStringBuilder.append(bool);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return false;
    }
    return true;
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
  
  public boolean hasTroopAssociation()
  {
    return this.groupAllianceid != 0L;
  }
  
  public boolean isAVGameOpen()
  {
    return (this.dwGroupFlagExt3 & 0x10000000) != 0L;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hlGuildAppid:");
      localStringBuilder.append(this.hlGuildAppid);
      localStringBuilder.append(",subType:");
      localStringBuilder.append(this.hlGuildSubType);
      QLog.d("TroopInfo", 2, localStringBuilder.toString());
    }
    return (this.hlGuildAppid == 1104466820L) && (this.hlGuildSubType == 0L);
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
  
  public boolean isNotSetTroopClassInfo()
  {
    return (this.groupFlagExt4 & 0x80) == 0;
  }
  
  public boolean isOnlyAllowManagerCreateAVGame()
  {
    return (this.dwGroupFlagExt3 & 0x20000000) != 0L;
  }
  
  public boolean isOnlyTroopMemberInviteOption()
  {
    return (this.dwGroupFlagExt3 & 0x4) != 0L;
  }
  
  public boolean isOwnerOrAdmin(String paramString)
  {
    return (isTroopOwner(paramString)) || (isTroopAdmin(paramString));
  }
  
  public boolean isQidianPrivateTroop()
  {
    return isQidianPrivateTroop(this.dwGroupFlagExt3);
  }
  
  public boolean isSharingLocation()
  {
    boolean bool;
    if ((this.dwGroupFlagExt3 & 0x4000000) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfo", 2, new Object[] { "isSharingLocation: invoked. ", " is: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean isShowMyGameCardEnabled()
  {
    return (this.cmduinFlagEx3Grocery & 1L) == 0L;
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
    Object localObject = this.Administrator;
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length > 0))
      {
        int i = 0;
        while (i < localObject.length)
        {
          if ((paramString != null) && (paramString.equals(localObject[i]))) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  public boolean isTroopGameCardEnabled()
  {
    return (this.groupFlagExt4 & 0x1000) != 0;
  }
  
  public boolean isTroopHonorOpen()
  {
    return (this.dwGroupFlagExt3 & 0x2000000) == 0L;
  }
  
  public boolean isTroopIlive()
  {
    boolean bool;
    if ((this.groupFlagExt4 & 0x400) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.i("IliveGroup", 1, String.format("isTroopIlive %s", new Object[] { Boolean.valueOf(bool) }));
    return bool;
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
  
  public ArrayList<Long> parseTroopMemeberList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.memberListToShow;
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      int i = 0;
      while (i < localObject.length)
      {
        try
        {
          localArrayList.add(Long.valueOf(Long.parseLong(localObject[i])));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label50:
          StringBuilder localStringBuilder;
          break label50;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse error: ");
          localStringBuilder.append(localObject[i]);
          QLog.d("troopInfo_member", 2, localStringBuilder.toString());
        }
        i += 1;
      }
    }
    else
    {
      return localArrayList;
    }
  }
  
  protected void postRead()
  {
    super.postRead();
    postRead_troopPicList();
    postRead_troopInfoExt();
  }
  
  protected void prewrite()
  {
    super.prewrite();
    prewrite_troopPicList();
    prewrite_troopInfoExt();
  }
  
  public void setAutoApprovalOpen(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.dwGroupFlagExt3 |= 0x100000;
    } else {
      this.dwGroupFlagExt3 &= 0xFFEFFFFF;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfo", 2, String.format("setAutoApprovalOpen [%s, %s]", new Object[] { Long.valueOf(this.dwGroupFlagExt3), Boolean.valueOf(paramBoolean) }));
    }
  }
  
  public void setCmdUinFlagEx2(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      l = this.cmdUinFlagEx2;
      this.cmdUinFlagEx2 = (paramInt | l);
      return;
    }
    long l = this.cmdUinFlagEx2;
    this.cmdUinFlagEx2 = ((paramInt ^ 0xFFFFFFFF) & l);
  }
  
  public void setCmduinFlagEx3Grocer4(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      l = this.cmduinFlagEx3Grocery;
      this.cmduinFlagEx3Grocery = (paramInt | l);
      return;
    }
    long l = this.cmduinFlagEx3Grocery;
    this.cmduinFlagEx3Grocery = ((paramInt ^ 0xFFFFFFFF) & l);
  }
  
  public void setGroupCardPrefix(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null)
    {
      this.groupCardPrefixJson = "";
      return;
    }
    if (paramArrayList.isEmpty())
    {
      this.groupCardPrefixJson = "";
      return;
    }
    Object localObject = new JSONArray();
    try
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2)) {
          ((JSONArray)localObject).put(str2);
        }
      }
      String str1;
      int i;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.groupCardPrefixJson = ((JSONArray)localObject).toString();
      if (QLog.isColorLevel())
      {
        str1 = this.troopuin;
        i = paramArrayList.size();
        localObject = this.groupCardPrefixJson;
        paramArrayList = (ArrayList<String>)localObject;
        if (localObject == null) {
          paramArrayList = "";
        }
        QLog.d("TroopInfo", 2, String.format("setPresetNickWords troopUin=%s groupCardPrefix size=%d groupCardPrefixes=%s", new Object[] { str1, Integer.valueOf(i), paramArrayList }));
      }
    }
  }
  
  public void setGroupFlagExt4(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.groupFlagExt4 |= paramInt;
      return;
    }
    this.groupFlagExt4 &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void setIsAVGameOpen(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dwGroupFlagExt3 |= 0x10000000;
      return;
    }
    this.dwGroupFlagExt3 &= 0xEFFFFFFF;
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
  
  public void setIsTroopLive(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.groupFlagExt4 |= 0x400;
    } else {
      this.groupFlagExt4 &= 0xFFFFFBFF;
    }
    QLog.i("IliveGroup", 1, String.format("setIsTroopLive %s %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isTroopIlive()) }));
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
  
  @SuppressLint({"UseSparseArrays"})
  public void setNewTroopLevelMap(ConcurrentHashMap<Integer, String> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNewTroopLevelMap:");
      localStringBuilder.append(this.troopuin);
      localStringBuilder.append(", old=");
      localStringBuilder.append(this.newTroopLevelMap);
      QLog.d("TroopInfo", 2, localStringBuilder.toString());
    }
    this.newTroopLevelMap = troopLevelMapToString(paramConcurrentHashMap);
    this.mCachedNewLevelMap = paramConcurrentHashMap;
    if (QLog.isColorLevel())
    {
      paramConcurrentHashMap = new StringBuilder();
      paramConcurrentHashMap.append("setNewTroopLevelMap:");
      paramConcurrentHashMap.append(this.troopuin);
      paramConcurrentHashMap.append(", new=");
      paramConcurrentHashMap.append(this.newTroopLevelMap);
      QLog.d("TroopInfo", 2, paramConcurrentHashMap.toString());
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
  
  public void setStudyRoomOpen(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.groupFlagExt4 |= 0x100;
    } else {
      this.groupFlagExt4 &= 0xFFFFFEFF;
    }
    QLog.i("StudyRoom", 2, String.format("setStudyRoomOpen %s %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(getStudyRoomOpen()) }));
  }
  
  public void setTogetherBusiness(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      l = this.dwGroupFlagExt3;
      this.dwGroupFlagExt3 = (paramInt | l);
      return;
    }
    long l = this.dwGroupFlagExt3;
    this.dwGroupFlagExt3 = ((paramInt ^ 0xFFFFFFFF) & l);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public void setTroopLevelMap(ConcurrentHashMap<Integer, String> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOldTroopLevelMap:");
      localStringBuilder.append(this.troopuin);
      localStringBuilder.append(", old=");
      localStringBuilder.append(this.troopLevelMap);
      QLog.d("TroopInfo", 2, localStringBuilder.toString());
    }
    this.troopLevelMap = troopLevelMapToString(paramConcurrentHashMap);
    this.mCachedLevelMap = paramConcurrentHashMap;
    if (QLog.isColorLevel())
    {
      paramConcurrentHashMap = new StringBuilder();
      paramConcurrentHashMap.append("setOldTroopLevelMap:");
      paramConcurrentHashMap.append(this.troopuin);
      paramConcurrentHashMap.append(", new=");
      paramConcurrentHashMap.append(this.troopLevelMap);
      QLog.d("TroopInfo", 2, paramConcurrentHashMap.toString());
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  public void setTroopLevelMap787(List<oidb_0x787.LevelName> paramList1, List<oidb_0x787.LevelName> paramList2)
  {
    int j = 0;
    Object localObject;
    int i;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).putAll(getTroopLevelMap());
      i = 0;
      while (i < paramList1.size())
      {
        oidb_0x787.LevelName localLevelName = (oidb_0x787.LevelName)paramList1.get(i);
        ((ConcurrentHashMap)localObject).put(Integer.valueOf(localLevelName.uint32_level.get()), localLevelName.str_name.get().toStringUtf8());
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramList1 = new StringBuilder();
        paramList1.append("setTroopLevelMap787:");
        paramList1.append(this.troopuin);
        paramList1.append(", old=");
        paramList1.append(this.troopLevelMap);
        QLog.d("TroopInfo", 2, paramList1.toString());
      }
      this.troopLevelMap = troopLevelMapToString((ConcurrentHashMap)localObject);
      this.mCachedLevelMap = ((ConcurrentHashMap)localObject);
      if (QLog.isColorLevel())
      {
        paramList1 = new StringBuilder();
        paramList1.append("setTroopLevelMap787:");
        paramList1.append(this.troopuin);
        paramList1.append(", new=");
        paramList1.append(this.troopLevelMap);
        QLog.d("TroopInfo", 2, paramList1.toString());
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = new ConcurrentHashMap();
      paramList1.putAll(getNewTroopLevelMap());
      i = j;
      while (i < paramList2.size())
      {
        localObject = (oidb_0x787.LevelName)paramList2.get(i);
        paramList1.put(Integer.valueOf(((oidb_0x787.LevelName)localObject).uint32_level.get()), ((oidb_0x787.LevelName)localObject).str_name.get().toStringUtf8());
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramList2 = new StringBuilder();
        paramList2.append("setTroopLevelMap787 new:");
        paramList2.append(this.troopuin);
        paramList2.append(", old=");
        paramList2.append(this.newTroopLevelMap);
        QLog.d("TroopInfo", 2, paramList2.toString());
      }
      this.newTroopLevelMap = troopLevelMapToString(paramList1);
      this.mCachedNewLevelMap = paramList1;
      if (QLog.isColorLevel())
      {
        paramList1 = new StringBuilder();
        paramList1.append("setTroopLevelMap787 new:");
        paramList1.append(this.troopuin);
        paramList1.append(", new=");
        paramList1.append(this.newTroopLevelMap);
        QLog.d("TroopInfo", 2, paramList1.toString());
      }
    }
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
  
  public boolean shouldShowMyGameCard()
  {
    return (isTroopGameCardEnabled()) && (isShowMyGameCardEnabled());
  }
  
  public String toString()
  {
    Object localObject2 = this.troopuin;
    Object localObject3 = this.newTroopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "[no uin]";
    }
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = "[no name]";
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("TroopInfo: {uin = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", name = ");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("}");
    return ((StringBuilder)localObject3).toString();
  }
  
  public void updateHeadMemberList(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfo", 2, "updateHeadMemberList");
    }
    this.mHeaderUinsNew = paramString;
  }
  
  public void updateHeadMemberUins(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfo", 2, "updateHeadMemberUins");
    }
    this.mHeaderUinsNew = paramString;
  }
  
  public void updateLastMemoFromWeb(String paramString)
  {
    this.strLastAnnouncement = paramString;
    if (this.strLastAnnouncement == null) {
      this.strLastAnnouncement = "";
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("updateLastMemoFromWeb : ");
      paramString.append(this.strLastAnnouncement);
      QLog.i("TroopInfo", 2, paramString.toString());
    }
  }
  
  public void updateQZonePhotoUrls(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    int i;
    if (paramArrayList != null) {
      i = paramArrayList.size();
    } else {
      i = 0;
    }
    while (j < i)
    {
      String str = (String)paramArrayList.get(j);
      if ((str != null) && (str.length() > 0))
      {
        localStringBuilder.append(str);
        localStringBuilder.append(";");
      }
      j += 1;
    }
    this.strQZonePhotoUrls = localStringBuilder.toString();
  }
  
  public void updateSomeMemberUins(List<oidb_0x899.memberlist> paramList)
  {
    int j = 0;
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    while (j < i)
    {
      oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)paramList.get(j);
      if ((localmemberlist != null) && (localmemberlist.uint64_member_uin.has()))
      {
        localStringBuilder.append(localmemberlist.uint64_member_uin.get());
        localStringBuilder.append('|');
      }
      j += 1;
    }
    this.mSomeMemberUins = localStringBuilder.toString();
    if ((i < 6) && (i > 0)) {
      this.wMemberNum = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopInfo
 * JD-Core Version:    0.7.0.1
 */