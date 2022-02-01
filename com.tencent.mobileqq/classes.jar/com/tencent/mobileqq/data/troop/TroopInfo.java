package com.tencent.mobileqq.data.troop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import anvx;
import bglm;
import bgln;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.data.TroopInfoStub;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;
import friendlist.stLevelRankPair;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GroupFeedsRecord;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.GroupInfoExt;

public class TroopInfo
  extends Entity
  implements TroopInfoStub, Serializable
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
  public static final String QIDIAN_TROOP_MEMBER_DEF_NICK = anvx.a(2131714819);
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
  public static final int TROOP_PRIVILEGE_INVITE_NEED_REVIEW = 101711872;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW = 1048576;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_100 = 67108864;
  public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_50 = 33554432;
  public static final int TROOP_SHARE_LOCATION = 67108864;
  public static final int TROOP_SING_TOGETHER = 16777216;
  public static final int TROOP_STUDY_ROOM_OPEN = 256;
  public static final int TROOP_WATCH_TOGETHER = 4194304;
  public static final int TROOP_WRITE_TOGETHER_SWITCH = 1073741824;
  public String Administrator;
  public String adminNameShow;
  public int allowMemberAtAll;
  public int allowMemberKick;
  public int allowMemberModifTroopName;
  public long appealDeadline;
  public long associatePubAccount;
  public byte cAlbumResult;
  public short cGroupLevel;
  public short cGroupOption;
  public byte cGroupRankSysFlag;
  public byte cGroupRankUserFlag;
  public byte cNewGroupRankUserFlag;
  public long cmdUinFlagEx2;
  public long cmduinFlagEx3Grocery;
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
  public int grade;
  @notColumn
  public long groupAllianceid;
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
  public int isAllowHistoryMsgFlag;
  public boolean isNewTroop;
  public int isShowInNearbyTroops = -1;
  public boolean isTroopBlocked;
  public String joinTroopAnswer;
  public String joinTroopQuestion;
  public long lastMsgTime;
  @defaultValue(defaultInteger=0)
  public long lastShareLbsMsgUniseq;
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
  public int mQZonePhotoNum;
  public String mRichFingerMemo;
  public String mSomeMemberUins;
  public String mTags;
  public int mTribeStatus;
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
  public int nMsgLimitFreq;
  public int nTroopGrade;
  public String newTroopLevelMap;
  public String newTroopName;
  public long newTroopNameTimeStamp;
  public String oldTroopName;
  public String ownerNameShow;
  public String school;
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
  public byte[] troopInfoExtByte;
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
    if (paramGroupInfo.string_group_finger_memo.has())
    {
      this.fingertroopmemo = paramGroupInfo.string_group_finger_memo.get().toStringUtf8();
      if (!paramGroupInfo.string_group_rich_finger_memo.has()) {
        break label77;
      }
    }
    label77:
    for (this.mRichFingerMemo = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();; this.mRichFingerMemo = "")
    {
      if (!TextUtils.isEmpty(this.mRichFingerMemo)) {
        break label87;
      }
      this.mRichFingerMemo = this.fingertroopmemo;
      return;
      this.fingertroopmemo = "";
      break;
    }
    label87:
    this.mRichFingerMemo = HttpUtil.removeHtmlTags(this.mRichFingerMemo);
    this.mRichFingerMemo = HttpUtil.unEscape(this.mRichFingerMemo);
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
      paramInt = paramCursor.getInt(i);
    }
    return paramInt;
  }
  
  private long entityByCursor_getValue(Cursor paramCursor, String paramString, long paramLong)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if (i > 0) {
      paramLong = paramCursor.getLong(i);
    }
    return paramLong;
  }
  
  private String entityByCursor_getValue(Cursor paramCursor, String paramString1, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (i > 0) {
      paramString2 = paramCursor.getString(i);
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
    return ((0x20 | paramLong) & paramInt) != 0L;
  }
  
  public static boolean isAdmin(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
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
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.isFansTroop());
  }
  
  public static boolean isHomeworkTroop(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
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
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    return (paramQQAppInterface != null) && (isQidianPrivateTroop(paramQQAppInterface.dwGroupFlagExt3));
  }
  
  public static final boolean isTroopMember(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b(paramString) != null;
    }
    return false;
  }
  
  public static boolean isVisitorSpeakEnabled(int paramInt)
  {
    return (paramInt & 0x2000) == 8192;
  }
  
  private void postRead_troopInfoExt()
  {
    if (this.troopInfoExtByte != null) {}
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
  
  private void postRead_troopPicList()
  {
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
              break label227;
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
      label227:
      i += 1;
    }
  }
  
  private void prewrite_troopInfoExt()
  {
    if (this.mTroopInfoExtObj != null) {
      this.troopInfoExtByte = this.mTroopInfoExtObj.convToGroupInfoExt().toByteArray();
    }
  }
  
  /* Error */
  private void prewrite_troopPicList()
  {
    // Byte code:
    //   0: new 553	org/json/JSONArray
    //   3: dup
    //   4: invokespecial 632	org/json/JSONArray:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 281	com/tencent/mobileqq/data/troop/TroopInfo:mTroopPicList	Ljava/util/List;
    //   12: invokeinterface 481 1 0
    //   17: astore_2
    //   18: aload_2
    //   19: invokeinterface 324 1 0
    //   24: ifeq +83 -> 107
    //   27: aload_2
    //   28: invokeinterface 328 1 0
    //   33: checkcast 483	com/tencent/mobileqq/activity/photo/TroopClipPic
    //   36: astore_3
    //   37: aload_3
    //   38: getfield 585	com/tencent/mobileqq/activity/photo/TroopClipPic:id	Ljava/lang/String;
    //   41: invokestatic 388	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   44: ifne -26 -> 18
    //   47: new 567	org/json/JSONObject
    //   50: dup
    //   51: invokespecial 633	org/json/JSONObject:<init>	()V
    //   54: astore 4
    //   56: aload 4
    //   58: ldc_w 565
    //   61: aload_3
    //   62: getfield 585	com/tencent/mobileqq/activity/photo/TroopClipPic:id	Ljava/lang/String;
    //   65: invokevirtual 637	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload_3
    //   70: getfield 588	com/tencent/mobileqq/activity/photo/TroopClipPic:clipInfo	Ljava/lang/String;
    //   73: invokestatic 388	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne +16 -> 92
    //   79: aload 4
    //   81: ldc_w 571
    //   84: aload_3
    //   85: getfield 588	com/tencent/mobileqq/activity/photo/TroopClipPic:clipInfo	Ljava/lang/String;
    //   88: invokevirtual 637	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload_1
    //   93: aload 4
    //   95: invokevirtual 640	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   98: pop
    //   99: goto -81 -> 18
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 589	org/json/JSONException:printStackTrace	()V
    //   107: aload_0
    //   108: aload_1
    //   109: invokevirtual 641	org/json/JSONArray:toString	()Ljava/lang/String;
    //   112: putfield 290	com/tencent/mobileqq/data/troop/TroopInfo:mTroopPicListJson	Ljava/lang/String;
    //   115: invokestatic 601	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   118: ifeq +43 -> 161
    //   121: ldc 69
    //   123: iconst_0
    //   124: ldc_w 643
    //   127: iconst_3
    //   128: anewarray 605	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_0
    //   134: getfield 607	com/tencent/mobileqq/data/troop/TroopInfo:troopuin	Ljava/lang/String;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload_0
    //   141: getfield 577	com/tencent/mobileqq/data/troop/TroopInfo:mTroopAvatarId	I
    //   144: invokestatic 612	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: aload_0
    //   151: getfield 290	com/tencent/mobileqq/data/troop/TroopInfo:mTroopPicListJson	Ljava/lang/String;
    //   154: aastore
    //   155: invokestatic 616	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokestatic 620	com/tencent/TMG/utils/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: return
    //   162: astore_2
    //   163: aload_2
    //   164: invokevirtual 621	java/lang/Exception:printStackTrace	()V
    //   167: goto -60 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	TroopInfo
    //   7	102	1	localJSONArray	JSONArray
    //   17	11	2	localIterator	Iterator
    //   102	2	2	localJSONException	JSONException
    //   162	2	2	localException	Exception
    //   36	49	3	localTroopClipPic	TroopClipPic
    //   54	40	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   8	18	102	org/json/JSONException
    //   18	92	102	org/json/JSONException
    //   92	99	102	org/json/JSONException
    //   8	18	162	java/lang/Exception
    //   18	92	162	java/lang/Exception
    //   92	99	162	java/lang/Exception
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
    ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this);
  }
  
  public void coverFrom(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    boolean bool2 = false;
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
    boolean bool1;
    if (paramGroupInfo.uint32_no_finger_open_flag.has())
    {
      if (paramGroupInfo.uint32_no_finger_open_flag.get() == 0)
      {
        bool1 = true;
        this.mCanSearchByKeywords = bool1;
      }
    }
    else
    {
      if (paramGroupInfo.uint32_no_code_finger_open_flag.has())
      {
        if (paramGroupInfo.uint32_no_code_finger_open_flag.get() != 0) {
          break label764;
        }
        bool1 = true;
        label192:
        this.mCanSearchByTroopUin = bool1;
      }
      if (paramGroupInfo.uint32_is_conf_group.has())
      {
        if (paramGroupInfo.uint32_is_conf_group.get() != 1) {
          break label769;
        }
        bool1 = true;
        label220:
        this.isNewTroop = bool1;
      }
      if (paramGroupInfo.uint32_is_modify_conf_group_face.has())
      {
        if (paramGroupInfo.uint32_is_modify_conf_group_face.get() != 1) {
          break label774;
        }
        bool1 = true;
        label248:
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
      if (!isNewTroop()) {
        break label779;
      }
    }
    label769:
    label774:
    label779:
    for (this.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_conf_group.get();; this.maxInviteMemNum = paramGroupInfo.uint32_auto_agree_join_group_user_num_for_normal_group.get())
    {
      this.allowMemberModifTroopName = paramGroupInfo.uint32_is_allow_conf_group_member_modify_group_name.get();
      this.allowMemberKick = paramGroupInfo.uint32_is_allow_conf_group_member_nick.get();
      this.allowMemberAtAll = paramGroupInfo.uint32_is_allow_conf_group_member_at_all.get();
      coverFrom_longGroupName(paramGroupInfo);
      if (paramGroupInfo.uint32_is_group_freeze.has()) {
        this.mIsFreezed = paramGroupInfo.uint32_is_group_freeze.get();
      }
      this.groupFlagExt4 = paramGroupInfo.uint32_group_flagext4.get();
      this.groupFreezeReason = paramGroupInfo.uint32_group_freeze_reason.get();
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("vip_pretty.TroopInfo", 1, "get flag ext4=" + this.groupFlagExt4 + " freeze reason=" + this.groupFreezeReason);
      }
      Object localObject;
      if (paramGroupInfo.bytes_group_school_info.has()) {
        localObject = new oidb_0x89a.GroupSchoolInfo();
      }
      try
      {
        oidb_0x89a.GroupSchoolInfo localGroupSchoolInfo = (oidb_0x89a.GroupSchoolInfo)((oidb_0x89a.GroupSchoolInfo)localObject).mergeFrom(paramGroupInfo.bytes_group_school_info.get().toByteArray());
        localObject = localGroupSchoolInfo;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
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
      if (paramGroupInfo.uint64_alliance_id.has()) {
        this.groupAllianceid = paramGroupInfo.uint64_alliance_id.get();
      }
      if (paramGroupInfo.st_group_info_ext.has()) {
        this.mTroopInfoExtObj = TroopInfoExt.parseFromGroupInfoExt((oidb_0xef0.GroupInfoExt)paramGroupInfo.st_group_info_ext.get());
      }
      if (paramGroupInfo.uint32_cmduin_flag_ex3_grocery.has()) {
        this.cmduinFlagEx3Grocery = paramGroupInfo.uint32_cmduin_flag_ex3_grocery.get();
      }
      return;
      bool1 = false;
      break;
      label764:
      bool1 = false;
      break label192;
      bool1 = false;
      break label220;
      bool1 = false;
      break label248;
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
      if (paramCursor.getInt(paramCursor.getColumnIndex("mCanSearchByKeywords")) == 1)
      {
        bool = true;
        label1402:
        this.mCanSearchByKeywords = bool;
        if (paramCursor.getInt(paramCursor.getColumnIndex("mCanSearchByTroopUin")) != 1) {
          break label2355;
        }
        bool = true;
        label1428:
        this.mCanSearchByTroopUin = bool;
        if (paramCursor.getInt(paramCursor.getColumnIndex("isNewTroop")) != 1) {
          break label2360;
        }
        bool = true;
        label1454:
        this.isNewTroop = bool;
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasSetNewTroopHead")) != 1) {
          break label2365;
        }
        bool = true;
        label1480:
        this.hasSetNewTroopHead = bool;
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasSetNewTroopName")) != 1) {
          break label2370;
        }
        bool = true;
        label1506:
        this.hasSetNewTroopName = bool;
        this.eliminated = paramCursor.getInt(paramCursor.getColumnIndex("eliminated"));
        this.feeds_id = paramCursor.getString(paramCursor.getColumnIndex("feeds_id"));
        this.troopRepeatType = paramCursor.getInt(paramCursor.getColumnIndex("troopRepeatType"));
        this.myHonorList = paramCursor.getString(paramCursor.getColumnIndex("myHonorList"));
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
        label1796:
        this.groupCardPrefixIntro = paramCursor.getString(paramCursor.getColumnIndex("groupCardPrefixIntro"));
        this.groupCardPrefixJson = paramCursor.getString(paramCursor.getColumnIndex("groupCardPrefixJson"));
        this.troopInfoExtByte = paramCursor.getBlob(paramCursor.getColumnIndex("troopInfoExtByte"));
        this.troopCreditLevel = entityByCursor_getValue(paramCursor, "troopCreditLevel", this.troopCreditLevel);
        this.troopCreditLevelInfo = entityByCursor_getValue(paramCursor, "troopCreditLevelInfo", this.troopCreditLevelInfo);
        if (paramCursor.getInt(paramCursor.getColumnIndex("isTroopBlocked")) == 1) {}
        for (bool = true;; bool = false)
        {
          this.isTroopBlocked = bool;
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
          this.isAllowHistoryMsgFlag = entityByCursor_getValue(paramCursor, "isAllowHistoryMsgFlag", this.isAllowHistoryMsgFlag);
          this.troopRepeatType = entityByCursor_getValue(paramCursor, "troopRepeatType", this.troopRepeatType);
          this.cmduinFlagEx3Grocery = entityByCursor_getValue(paramCursor, "cmduinFlagEx3Grocery", this.cmduinFlagEx3Grocery);
          if (com.tencent.TMG.utils.QLog.isColorLevel()) {
            com.tencent.TMG.utils.QLog.d("TroopInfo", 0, "fightgag._troopinfo.dwGagTimeStamp_me = " + this.dwGagTimeStamp_me + ",troopuin = " + this.troopuin);
          }
          return true;
          bool = false;
          break;
          bool = false;
          break label1402;
          label2355:
          bool = false;
          break label1428;
          label2360:
          bool = false;
          break label1454;
          label2365:
          bool = false;
          break label1480;
          label2370:
          bool = false;
          break label1506;
        }
      }
      catch (Exception localException)
      {
        break label1796;
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
      return paramContext.getString(2131719465);
    }
    return this.adminNameShow;
  }
  
  public int getFansTroopStarId()
  {
    if (this.mTroopInfoExtObj != null) {
      return this.mTroopInfoExtObj.star_id;
    }
    return 0;
  }
  
  public ArrayList<String> getGroupCardPrefix()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.groupCardPrefixJson)) {}
    for (;;)
    {
      int i;
      String str2;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.groupCardPrefixJson);
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            str2 = localJSONArray.getString(i);
            if (TextUtils.isEmpty(str2)) {
              break label147;
            }
            localArrayList.add(str2);
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel())
      {
        str2 = this.troopuin;
        i = localArrayList.size();
        if (this.groupCardPrefixJson != null) {
          break label139;
        }
      }
      label139:
      for (String str1 = "";; str1 = this.groupCardPrefixJson)
      {
        com.tencent.TMG.utils.QLog.d("TroopInfo", 0, String.format("getPresetNickWords troopUin=%s groupCardPrefix size=%d groupCardPrefixes=%s", new Object[] { str2, Integer.valueOf(i), str1 }));
        return localArrayList;
      }
      label147:
      i += 1;
    }
  }
  
  public String getInviteModeDesWording(Resources paramResources)
  {
    String str = "";
    if ((this.troopPrivilegeFlag & 0x6100000) == 0L) {
      str = paramResources.getString(2131696226);
    }
    while (((this.troopPrivilegeFlag & 0x2000000) != 33554432L) && ((this.troopPrivilegeFlag & 0x4000000) != 67108864L) && ((this.troopPrivilegeFlag & 0x100000) != 1048576L)) {
      return str;
    }
    return paramResources.getString(2131696227);
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
      str = paramResources.getString(2131696231);
    }
    label69:
    do
    {
      return str;
      i = this.cGroupOption;
      break;
      if ((this.troopPrivilegeFlag & 0x6100000) == 0L) {
        return paramResources.getString(2131696230);
      }
      if ((this.troopPrivilegeFlag & 0x100000) == 1048576L) {
        return paramResources.getString(2131696231);
      }
    } while (((this.troopPrivilegeFlag & 0x4000000) != 67108864L) && ((this.troopPrivilegeFlag & 0x2000000) != 33554432L));
    return paramResources.getString(2131696232);
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
      if ((isTroopOwner(paramQQAppInterface.getCurrentUin())) || (isTroopAdmin(paramQQAppInterface.getCurrentUin()))) {}
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
    if (((this.mCachedNewLevelMap == null) || (this.mCachedNewLevelMap.size() == 0)) && (this.mCachedNewLevelMap == null))
    {
      this.mCachedNewLevelMap = new ConcurrentHashMap();
      if (this.newTroopLevelMap != null)
      {
        String[] arrayOfString1 = this.newTroopLevelMap.split("\001");
        if ((arrayOfString1 != null) && (arrayOfString1.length > 0))
        {
          int i = 0;
          for (;;)
          {
            if (i < arrayOfString1.length)
            {
              String[] arrayOfString2 = arrayOfString1[i].split("");
              if (arrayOfString2.length == 2) {}
              try
              {
                this.mCachedNewLevelMap.put(Integer.valueOf(Integer.parseInt(arrayOfString2[0])), arrayOfString2[1]);
                i += 1;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  if (com.tencent.TMG.utils.QLog.isColorLevel()) {
                    com.tencent.TMG.utils.QLog.d("TroopInfo", 0, "getNewTroopLevelMap, catch exception, key: " + arrayOfString2[0] + " value: " + arrayOfString2[1]);
                  }
                }
              }
            }
          }
        }
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "getNewTroopLevelMap:" + this.troopuin + ", create cache");
      }
    }
    return this.mCachedNewLevelMap;
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
      return paramContext.getString(2131719687);
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
  
  public boolean getStudyRoomOpen()
  {
    return checkFlagExt4(256);
  }
  
  public String getTableName()
  {
    return "TroopInfoV2";
  }
  
  @SuppressLint({"UseSparseArrays"})
  public ConcurrentHashMap<Integer, String> getTroopLevelMap()
  {
    if (((this.mCachedLevelMap == null) || (this.mCachedLevelMap.size() == 0)) && (this.mCachedLevelMap == null))
    {
      this.mCachedLevelMap = new ConcurrentHashMap();
      if (this.troopLevelMap != null)
      {
        String[] arrayOfString1 = this.troopLevelMap.split("\001");
        if ((arrayOfString1 != null) && (arrayOfString1.length > 0))
        {
          int i = 0;
          for (;;)
          {
            if (i < arrayOfString1.length)
            {
              String[] arrayOfString2 = arrayOfString1[i].split("");
              if (arrayOfString2.length == 2) {}
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
                    com.tencent.TMG.utils.QLog.d("TroopInfo", 0, "getOldTroopLevelMap, catch exception, key: " + arrayOfString2[0] + " value: " + arrayOfString2[1]);
                  }
                }
              }
            }
          }
        }
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "getOldTroopLevelMap:" + this.troopuin + ", create cache");
      }
    }
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
  
  public String getTroopUin()
  {
    return this.troopuin;
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
    if ((this.dwGroupFlagExt3 & 0x4000000) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d("TroopInfo", 2, new Object[] { "isSharingLocation: invoked. ", " is: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean isShowMyGameCardEnabled()
  {
    return (this.cmduinFlagEx3Grocery & 1L) == 0L;
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
    if ((this.groupFlagExt4 & 0x400) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.TMG.utils.QLog.i("IliveGroup", 1, String.format("isTroopIlive %s", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
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
    postRead_troopPicList();
    postRead_troopInfoExt();
  }
  
  public void prewrite()
  {
    super.prewrite();
    prewrite_troopPicList();
    prewrite_troopInfoExt();
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
  
  public void setCmduinFlagEx3Grocer4(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.cmduinFlagEx3Grocery |= paramInt;
      return;
    }
    this.cmduinFlagEx3Grocery &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void setGroupCardPrefix(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      this.groupCardPrefixJson = "";
    }
    for (;;)
    {
      return;
      if (paramArrayList.isEmpty())
      {
        this.groupCardPrefixJson = "";
        return;
      }
      localObject = new JSONArray();
      try
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!TextUtils.isEmpty(str)) {
            ((JSONArray)localObject).put(str);
          }
        }
        if (!com.tencent.TMG.utils.QLog.isColorLevel()) {}
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.groupCardPrefixJson = ((JSONArray)localObject).toString();
      }
    }
    Object localObject = this.troopuin;
    int i = paramArrayList.size();
    if (this.groupCardPrefixJson == null) {}
    for (paramArrayList = "";; paramArrayList = this.groupCardPrefixJson)
    {
      com.tencent.TMG.utils.QLog.d("TroopInfo", 0, String.format("setPresetNickWords troopUin=%s groupCardPrefix size=%d groupCardPrefixes=%s", new Object[] { localObject, Integer.valueOf(i), paramArrayList }));
      return;
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
    if (paramBoolean) {}
    for (this.groupFlagExt4 |= 0x400;; this.groupFlagExt4 &= 0xFFFFFBFF)
    {
      com.tencent.TMG.utils.QLog.i("IliveGroup", 1, String.format("setIsTroopLive %s %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(isTroopIlive()) }));
      return;
    }
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
        paramGroupFeedsRecord = bglm.a(String.valueOf(paramGroupFeedsRecord.uint32_feeds_type.get()), localGroupFeedsMessage.toByteArray(), true);
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
  
  @SuppressLint({"UseSparseArrays"})
  public void setNewTroopLevelMap(List<stLevelRankPair> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.putAll(getNewTroopLevelMap());
      int i = 0;
      while (i < paramList.size())
      {
        stLevelRankPair localstLevelRankPair = (stLevelRankPair)paramList.get(i);
        localConcurrentHashMap.put(Integer.valueOf((int)localstLevelRankPair.dwLevel), localstLevelRankPair.strRank);
        i += 1;
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setNewTroopLevelMap:" + this.troopuin + ", old=" + this.newTroopLevelMap);
      }
      this.newTroopLevelMap = troopLevelMapToString(localConcurrentHashMap);
      this.mCachedNewLevelMap = localConcurrentHashMap;
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setNewTroopLevelMap:" + this.troopuin + ", new=" + this.newTroopLevelMap);
      }
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
    if (paramBoolean) {}
    for (this.groupFlagExt4 |= 0x100;; this.groupFlagExt4 &= 0xFFFFFEFF)
    {
      com.tencent.TMG.utils.QLog.i("StudyRoom", 0, String.format("setStudyRoomOpen %s %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(getStudyRoomOpen()) }));
      return;
    }
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
    if ((paramList != null) && (paramList.size() > 0))
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.putAll(getTroopLevelMap());
      int i = 0;
      while (i < paramList.size())
      {
        stLevelRankPair localstLevelRankPair = (stLevelRankPair)paramList.get(i);
        localConcurrentHashMap.put(Integer.valueOf((int)localstLevelRankPair.dwLevel), localstLevelRankPair.strRank);
        i += 1;
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setOldTroopLevelMap:" + this.troopuin + ", old=" + this.troopLevelMap);
      }
      this.troopLevelMap = troopLevelMapToString(localConcurrentHashMap);
      this.mCachedLevelMap = localConcurrentHashMap;
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setOldTroopLevelMap:" + this.troopuin + ", new=" + this.troopLevelMap);
      }
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  public void setTroopLevelMap787(List<oidb_0x787.LevelName> paramList1, List<oidb_0x787.LevelName> paramList2)
  {
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
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setTroopLevelMap787:" + this.troopuin + ", old=" + this.troopLevelMap);
      }
      this.troopLevelMap = troopLevelMapToString((ConcurrentHashMap)localObject);
      this.mCachedLevelMap = ((ConcurrentHashMap)localObject);
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setTroopLevelMap787:" + this.troopuin + ", new=" + this.troopLevelMap);
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = new ConcurrentHashMap();
      paramList1.putAll(getNewTroopLevelMap());
      i = 0;
      while (i < paramList2.size())
      {
        localObject = (oidb_0x787.LevelName)paramList2.get(i);
        paramList1.put(Integer.valueOf(((oidb_0x787.LevelName)localObject).uint32_level.get()), ((oidb_0x787.LevelName)localObject).str_name.get().toStringUtf8());
        i += 1;
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setTroopLevelMap787 new:" + this.troopuin + ", old=" + this.newTroopLevelMap);
      }
      this.newTroopLevelMap = troopLevelMapToString(paramList1);
      this.mCachedNewLevelMap = paramList1;
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("Q.getTroopMemberLevelInfo", 0, "setTroopLevelMap787 new:" + this.troopuin + ", new=" + this.newTroopLevelMap);
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
        break label118;
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
    label118:
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
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopInfo
 * JD-Core Version:    0.7.0.1
 */