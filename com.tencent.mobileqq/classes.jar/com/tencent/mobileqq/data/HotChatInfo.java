package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.hotchat.api.IHotChatInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody.WifiPOIInfo;

public class HotChatInfo
  extends Entity
  implements HotChatInfoStub, IHotChatInfo, Serializable, Cloneable
{
  public static final int RU_STATE_DELETED = 1;
  public static final int RU_STATE_NORMAL = 0;
  public static final int STATE_FORCE_PULL_TROOP_MSG = 8;
  public static final int STATE_HOT_CHAT_IS_DISBANDED = 7;
  public static final int STATE_JOINED = 0;
  public static final int STATE_KICK_OUT = 6;
  public static final int STATE_LEFT_AS_OVERCOUNT = 9;
  public static final int STATE_LEFT_LONG_TIME_NOT_SAY = 1;
  public static final int STATE_LEFT_LONG_WAY_TO_GO = 3;
  public static final int STATE_LEFT_NORMAL = 4;
  public static final int STATE_SHELL = 5;
  public static final int SUB_TYPE_PTT = 1;
  private static final long serialVersionUID = 4511795799007124151L;
  public int adminLevel;
  @notColumn
  public List<String> adminUins = new ArrayList();
  public int apolloGameId;
  public String detail;
  public String extra1;
  public int faceId;
  public boolean hasJoined;
  public int hotChatType;
  public int hotThemeGroupFlag;
  public String iconUrl;
  public boolean isFavorite = false;
  public boolean isGameRoom = false;
  public boolean isRobotHotChat = false;
  public boolean isWifiHotChat;
  public String joinUrl;
  public long lLastMsgSeq;
  public long leftTime;
  public int mFissionRoomNum;
  @notColumn
  private boolean mHasRedPoint = false;
  @notColumn
  private long mLastUpdateRedPointTime = 0L;
  public int memberCount;
  public String memo;
  public boolean memoShowed;
  public String memoUrl;
  public String name;
  public String ownerUin;
  public int pkFlag;
  public long praiseCount = 0L;
  public long robotUin;
  public int ruState = 0;
  public String signature;
  public int state = 4;
  public String strAdminUins;
  public int subType;
  public boolean supportDemo;
  public boolean supportFlashPic;
  public String troopCode;
  @unique
  public String troopUin;
  public int uint32_group_flag_ext2;
  public int userCreate;
  public String uuid;
  
  public static HotChatInfo createHotChat(JSONObject paramJSONObject)
  {
    HotChatInfo localHotChatInfo = new HotChatInfo();
    localHotChatInfo.faceId = paramJSONObject.getInt("face_id");
    localHotChatInfo.memberCount = paramJSONObject.getInt("visitor_num");
    localHotChatInfo.troopUin = paramJSONObject.getString("group_code");
    localHotChatInfo.troopCode = paramJSONObject.getString("group_uin");
    boolean bool;
    if (paramJSONObject.getInt("wifi_poi_type") == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localHotChatInfo.isWifiHotChat = bool;
    localHotChatInfo.name = paramJSONObject.getString("name");
    localHotChatInfo.signature = paramJSONObject.getString("sig");
    if (paramJSONObject.getInt("is_member") > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localHotChatInfo.hasJoined = bool;
    localHotChatInfo.uuid = paramJSONObject.getString("uid");
    localHotChatInfo.iconUrl = paramJSONObject.getString("face_url");
    localHotChatInfo.hotThemeGroupFlag = paramJSONObject.getInt("hot_theme_group_flag");
    localHotChatInfo.supportFlashPic = false;
    localHotChatInfo.supportDemo = false;
    localHotChatInfo.ownerUin = "";
    localHotChatInfo.pkFlag = 0;
    localHotChatInfo.subType = 0;
    localHotChatInfo.lLastMsgSeq = 0L;
    localHotChatInfo.extra1 = "";
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "createHotChat_JSONObject", new Object[] { localHotChatInfo });
    }
    return localHotChatInfo;
  }
  
  public static HotChatInfo createHotChat(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean)
  {
    return createHotChat(paramWifiPOIInfo, paramBoolean, 0);
  }
  
  public static HotChatInfo createHotChat(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt)
  {
    HotChatInfo localHotChatInfo = new HotChatInfo();
    localHotChatInfo.faceId = paramWifiPOIInfo.uint32_face_id.get();
    localHotChatInfo.memberCount = paramWifiPOIInfo.uint32_visitor_num.get();
    localHotChatInfo.troopUin = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_code.get()));
    localHotChatInfo.troopCode = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_uin.get()));
    localHotChatInfo.isWifiHotChat = paramBoolean;
    localHotChatInfo.name = paramWifiPOIInfo.bytes_name.get().toStringUtf8();
    localHotChatInfo.signature = paramWifiPOIInfo.bytes_sig.get().toStringUtf8();
    if (paramWifiPOIInfo.uint32_is_member.get() > 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localHotChatInfo.hasJoined = paramBoolean;
    localHotChatInfo.uuid = paramWifiPOIInfo.bytes_uid.get().toStringUtf8();
    localHotChatInfo.iconUrl = paramWifiPOIInfo.face_url.get();
    localHotChatInfo.hotThemeGroupFlag = paramWifiPOIInfo.hot_theme_group_flag.get();
    if ((paramWifiPOIInfo.uint32_special_flag.get() & 0x1) != 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localHotChatInfo.supportFlashPic = paramBoolean;
    if ((paramInt & 0x2) != 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localHotChatInfo.supportDemo = paramBoolean;
    localHotChatInfo.adminLevel = paramWifiPOIInfo.uint32_is_admin.get();
    localHotChatInfo.joinUrl = paramWifiPOIInfo.string_join_group_url.get();
    localHotChatInfo.hotChatType = paramWifiPOIInfo.uint32_group_type_flag.get();
    localHotChatInfo.userCreate = paramWifiPOIInfo.uint32_is_user_create.get();
    localHotChatInfo.ownerUin = String.valueOf(paramWifiPOIInfo.uint64_owner_uin.get());
    localHotChatInfo.pkFlag = paramWifiPOIInfo.uint32_tv_pk_flag.get();
    long l2 = paramWifiPOIInfo.uint64_favorites_time.get();
    long l1 = 0L;
    if (l2 > 0L) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localHotChatInfo.isFavorite = paramBoolean;
    localHotChatInfo.subType = paramWifiPOIInfo.uint32_sub_type.get();
    localHotChatInfo.lLastMsgSeq = paramWifiPOIInfo.uint64_last_msg_seq.get();
    localHotChatInfo.mFissionRoomNum = paramWifiPOIInfo.uint32_group_id.get();
    if (paramWifiPOIInfo.uint64_praise_nums.has()) {
      l1 = paramWifiPOIInfo.uint64_praise_nums.get();
    }
    localHotChatInfo.praiseCount = l1;
    localHotChatInfo.uint32_group_flag_ext2 = paramWifiPOIInfo.uint32_group_flag_ext2.get();
    if ((paramWifiPOIInfo.uint32_is_robot_group.has()) && (paramWifiPOIInfo.uint32_is_robot_group.get() == 1)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localHotChatInfo.isRobotHotChat = paramBoolean;
    localHotChatInfo.robotUin = paramWifiPOIInfo.uint64_robot_uin.get();
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "createHotChat_WifiPOIInfo", new Object[] { localHotChatInfo });
    }
    return localHotChatInfo;
  }
  
  public static HotChatInfo createHotChat(submsgtype0xdd.MsgBody.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt)
  {
    HotChatInfo localHotChatInfo = new HotChatInfo();
    localHotChatInfo.faceId = paramWifiPOIInfo.uint32_face_id.get();
    localHotChatInfo.memberCount = paramWifiPOIInfo.uint32_visitor_num.get();
    localHotChatInfo.troopUin = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_code.get()));
    localHotChatInfo.troopCode = String.valueOf(Utils.a(paramWifiPOIInfo.uint32_group_uin.get()));
    localHotChatInfo.isWifiHotChat = paramBoolean;
    localHotChatInfo.name = paramWifiPOIInfo.bytes_name.get().toStringUtf8();
    localHotChatInfo.signature = paramWifiPOIInfo.bytes_sig.get().toStringUtf8();
    if (paramWifiPOIInfo.uint32_is_member.get() > 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localHotChatInfo.hasJoined = paramBoolean;
    localHotChatInfo.uuid = paramWifiPOIInfo.bytes_uid.get().toStringUtf8();
    localHotChatInfo.iconUrl = paramWifiPOIInfo.string_face_url.get();
    localHotChatInfo.hotThemeGroupFlag = paramWifiPOIInfo.uint32_hot_theme_group_flag.get();
    if ((paramWifiPOIInfo.uint32_special_flag.get() & 0x1) != 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localHotChatInfo.supportFlashPic = paramBoolean;
    if ((paramInt & 0x2) != 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localHotChatInfo.supportDemo = paramBoolean;
    localHotChatInfo.adminLevel = paramWifiPOIInfo.uint32_is_admin.get();
    localHotChatInfo.joinUrl = paramWifiPOIInfo.string_join_group_url.get();
    localHotChatInfo.hotChatType = paramWifiPOIInfo.uint32_group_type_flag.get();
    localHotChatInfo.userCreate = paramWifiPOIInfo.uint32_is_user_create.get();
    localHotChatInfo.ownerUin = String.valueOf(paramWifiPOIInfo.uint64_owner_uin.get());
    localHotChatInfo.pkFlag = paramWifiPOIInfo.uint32_tv_pk_flag.get();
    long l2 = paramWifiPOIInfo.uint64_favorites_time.get();
    long l1 = 0L;
    if (l2 > 0L) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    localHotChatInfo.isFavorite = paramBoolean;
    localHotChatInfo.subType = paramWifiPOIInfo.uint32_sub_type.get();
    localHotChatInfo.lLastMsgSeq = paramWifiPOIInfo.uint64_last_msg_seq.get();
    localHotChatInfo.mFissionRoomNum = paramWifiPOIInfo.uint32_group_id.get();
    if (paramWifiPOIInfo.uint64_praise_nums.has()) {
      l1 = paramWifiPOIInfo.uint64_praise_nums.get();
    }
    localHotChatInfo.praiseCount = l1;
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", "createHotChat_WifiPOIInfo", new Object[] { localHotChatInfo });
    }
    return localHotChatInfo;
  }
  
  public static RecentUser createRecentUser(HotChatInfo paramHotChatInfo, boolean paramBoolean)
  {
    RecentUser localRecentUser = new RecentUser();
    localRecentUser.displayName = paramHotChatInfo.name;
    localRecentUser.lastmsgtime = NetConnInfoCenter.getServerTime();
    if (paramBoolean)
    {
      localRecentUser.setType(1);
      localRecentUser.uin = AppConstants.WIFI_HOT_CHAT_UIN;
    }
    else
    {
      localRecentUser.setType(1);
      localRecentUser.uin = paramHotChatInfo.troopUin;
    }
    localRecentUser.troopUin = paramHotChatInfo.troopUin;
    localRecentUser.lFlag = 1L;
    return localRecentUser;
  }
  
  public static Common.WifiPOIInfo createWifiPOIInfo(HotChatInfo paramHotChatInfo)
  {
    Common.WifiPOIInfo localWifiPOIInfo = new Common.WifiPOIInfo();
    for (;;)
    {
      try
      {
        if (paramHotChatInfo.name != null) {
          localWifiPOIInfo.bytes_name.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.name));
        }
        if (paramHotChatInfo.signature != null) {
          localWifiPOIInfo.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.signature));
        }
        localWifiPOIInfo.uint32_face_id.set(paramHotChatInfo.faceId);
        localWifiPOIInfo.uint32_group_code.set(Utils.a(Long.parseLong(paramHotChatInfo.troopUin)));
        localWifiPOIInfo.uint32_group_uin.set(Utils.a(Long.parseLong(paramHotChatInfo.troopCode)));
        localWifiPOIInfo.uint32_visitor_num.set(paramHotChatInfo.memberCount);
        Object localObject = localWifiPOIInfo.uint32_is_member;
        if (!paramHotChatInfo.hasJoined) {
          break label462;
        }
        i = 1;
        ((PBUInt32Field)localObject).set(i);
        if (paramHotChatInfo.uuid != null) {
          localWifiPOIInfo.bytes_uid.set(ByteStringMicro.copyFromUtf8(paramHotChatInfo.uuid));
        }
        localObject = localWifiPOIInfo.uint32_wifi_poi_type;
        if (!paramHotChatInfo.isWifiHotChat) {
          break label467;
        }
        i = 1;
        ((PBUInt32Field)localObject).set(i);
        if (!TextUtils.isEmpty(paramHotChatInfo.iconUrl)) {
          localWifiPOIInfo.face_url.set(paramHotChatInfo.iconUrl);
        }
        localWifiPOIInfo.hot_theme_group_flag.set(paramHotChatInfo.hotThemeGroupFlag);
        localObject = localWifiPOIInfo.uint32_special_flag;
        if (!paramHotChatInfo.supportFlashPic) {
          break label472;
        }
        i = 1;
        ((PBUInt32Field)localObject).set(i);
        localWifiPOIInfo.uint32_is_admin.set(paramHotChatInfo.adminLevel);
        if (paramHotChatInfo.joinUrl != null) {
          localWifiPOIInfo.string_join_group_url.set(paramHotChatInfo.joinUrl);
        }
        localWifiPOIInfo.uint32_group_type_flag.set(paramHotChatInfo.hotChatType);
        localWifiPOIInfo.uint32_is_user_create.set(paramHotChatInfo.userCreate);
        localWifiPOIInfo.uint64_owner_uin.set(TroopFileHandler.a(paramHotChatInfo.ownerUin));
        localWifiPOIInfo.uint32_tv_pk_flag.set(paramHotChatInfo.pkFlag);
        localObject = localWifiPOIInfo.uint64_favorites_time;
        if (!paramHotChatInfo.isFavorite) {
          break label477;
        }
        l = 100L;
        ((PBUInt64Field)localObject).set(l);
        localWifiPOIInfo.uint32_sub_type.set(paramHotChatInfo.subType);
        localWifiPOIInfo.uint64_last_msg_seq.set(paramHotChatInfo.lLastMsgSeq);
        localWifiPOIInfo.uint64_praise_nums.set(paramHotChatInfo.praiseCount);
        localWifiPOIInfo.uint32_group_id.set(paramHotChatInfo.mFissionRoomNum);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          NearbyUtils.a("PttShow", "createWifiPOIInfo", new Object[] { localException.toString() });
        }
      }
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", "createWifiPOIInfo", new Object[] { paramHotChatInfo });
      }
      return localWifiPOIInfo;
      label462:
      int i = 0;
      continue;
      label467:
      i = 2;
      continue;
      label472:
      i = 0;
      continue;
      label477:
      long l = 0L;
    }
  }
  
  public static String pack(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put((String)paramList.next());
      }
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static List<String> unPack(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        String str = (String)paramString.get(i);
        if (!TextUtils.isEmpty(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void clearRedPoint()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (l > this.mLastUpdateRedPointTime)
    {
      this.mHasRedPoint = false;
      this.mLastUpdateRedPointTime = l;
    }
  }
  
  public HotChatInfo clone()
  {
    try
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)super.clone();
      return localHotChatInfo;
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public String getJoinUrl()
  {
    return this.joinUrl;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getOwnerUin()
  {
    return this.ownerUin;
  }
  
  public String getTribeId()
  {
    if (!isBuLuoHotChat()) {
      return "";
    }
    Matcher localMatcher = Pattern.compile("(\\d+)").matcher(this.uuid);
    if (localMatcher.find()) {
      return localMatcher.group();
    }
    return "";
  }
  
  public String getTroopUin()
  {
    return this.troopUin;
  }
  
  public int getUserCreate()
  {
    return this.userCreate;
  }
  
  public boolean hasPostRedPoint()
  {
    return this.mHasRedPoint;
  }
  
  public boolean isBuLuoHotChat()
  {
    if (TextUtils.isEmpty(this.uuid)) {
      return false;
    }
    return Pattern.compile("(\\d+)(-T-)").matcher(this.uuid).find();
  }
  
  public boolean isOwnerOrAdmin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.equals(this.ownerUin))
    {
      List localList = this.adminUins;
      if ((localList == null) || (!localList.contains(paramString))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isPKHotChat()
  {
    return this.pkFlag > 0;
  }
  
  public boolean isPttShowRoom()
  {
    return this.subType == 1;
  }
  
  public boolean need2ReqRedPoint()
  {
    return this.mLastUpdateRedPointTime == 0L;
  }
  
  public void onExit(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("Q.hotchat", new Object[] { "onExit", Integer.valueOf(paramInt) });
    }
    this.state = paramInt;
    this.leftTime = System.currentTimeMillis();
    this.extra1 = "";
  }
  
  protected void postRead()
  {
    super.postRead();
    if (!TextUtils.isEmpty(this.strAdminUins)) {
      this.adminUins = unPack(this.strAdminUins);
    }
  }
  
  protected void prewrite()
  {
    super.prewrite();
    List localList = this.adminUins;
    if ((localList != null) && (localList.size() > 0)) {
      this.strAdminUins = pack(this.adminUins);
    }
  }
  
  public void setHasRedPoint()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (l > this.mLastUpdateRedPointTime)
    {
      this.mHasRedPoint = true;
      this.mLastUpdateRedPointTime = l;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    localStringBuilder.append("HotChatInfo [name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", troopCode=");
    localStringBuilder.append(this.troopCode);
    localStringBuilder.append(", signature=");
    localStringBuilder.append(this.signature);
    localStringBuilder.append(", troopUin=");
    localStringBuilder.append(this.troopUin);
    localStringBuilder.append(", faceId=");
    localStringBuilder.append(this.faceId);
    localStringBuilder.append(", memberCount=");
    localStringBuilder.append(this.memberCount);
    localStringBuilder.append(", hasJoined=");
    localStringBuilder.append(this.hasJoined);
    localStringBuilder.append(", isWifiHotChat=");
    localStringBuilder.append(this.isWifiHotChat);
    localStringBuilder.append(", uuid=");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append(", detail=");
    localStringBuilder.append(this.detail);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.state);
    localStringBuilder.append(", leftTime=");
    localStringBuilder.append(this.leftTime);
    localStringBuilder.append(",face_url=");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append(", hot_theme_group_flag=");
    localStringBuilder.append(this.hotThemeGroupFlag);
    localStringBuilder.append(", supportFlashPic=");
    localStringBuilder.append(this.supportFlashPic);
    localStringBuilder.append(", supportDemo=");
    localStringBuilder.append(this.supportDemo);
    localStringBuilder.append(",adminLevel=");
    localStringBuilder.append(this.adminLevel);
    localStringBuilder.append(",joinUrl=");
    localStringBuilder.append(this.joinUrl);
    localStringBuilder.append(",hotChatType=");
    localStringBuilder.append(this.hotChatType);
    localStringBuilder.append(",memo=");
    localStringBuilder.append(this.memo);
    localStringBuilder.append(",memoUrl=");
    localStringBuilder.append(this.memoUrl);
    localStringBuilder.append(",userCreate=");
    localStringBuilder.append(this.userCreate);
    localStringBuilder.append(",strAdminUins=");
    localStringBuilder.append(this.strAdminUins);
    localStringBuilder.append(",ownerUin=");
    localStringBuilder.append(this.ownerUin);
    localStringBuilder.append(",pkFlag=");
    localStringBuilder.append(this.pkFlag);
    localStringBuilder.append(", subType=");
    localStringBuilder.append(this.subType);
    localStringBuilder.append(", lLastMsgSeq=");
    localStringBuilder.append(this.lLastMsgSeq);
    localStringBuilder.append(", extral=");
    localStringBuilder.append(this.extra1);
    localStringBuilder.append(", mFissionRoomNum=");
    localStringBuilder.append(this.mFissionRoomNum);
    localStringBuilder.append(", praiseCount=");
    localStringBuilder.append(this.praiseCount);
    localStringBuilder.append(", uint32_group_flag_ext2=");
    localStringBuilder.append(this.uint32_group_flag_ext2);
    localStringBuilder.append(", apolloGameId=");
    localStringBuilder.append(this.apolloGameId);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void updateHotChatInfo(HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo != null)
    {
      if (paramHotChatInfo == this) {
        return;
      }
      this.troopCode = paramHotChatInfo.troopCode;
      this.state = 0;
      this.faceId = paramHotChatInfo.faceId;
      this.isWifiHotChat = paramHotChatInfo.isWifiHotChat;
      this.memberCount = paramHotChatInfo.memberCount;
      this.signature = paramHotChatInfo.signature;
      this.uuid = paramHotChatInfo.uuid;
      this.name = paramHotChatInfo.name;
      this.iconUrl = paramHotChatInfo.iconUrl;
      this.supportFlashPic = paramHotChatInfo.supportFlashPic;
      this.adminLevel = paramHotChatInfo.adminLevel;
      this.hotChatType = paramHotChatInfo.hotChatType;
      this.userCreate = paramHotChatInfo.userCreate;
      this.hotThemeGroupFlag = paramHotChatInfo.hotThemeGroupFlag;
      this.joinUrl = paramHotChatInfo.joinUrl;
      this.supportDemo = paramHotChatInfo.supportDemo;
      this.ownerUin = paramHotChatInfo.ownerUin;
      this.pkFlag = paramHotChatInfo.pkFlag;
      this.subType = paramHotChatInfo.subType;
      this.lLastMsgSeq = paramHotChatInfo.lLastMsgSeq;
      this.mFissionRoomNum = paramHotChatInfo.mFissionRoomNum;
      this.praiseCount = paramHotChatInfo.praiseCount;
      this.uint32_group_flag_ext2 = paramHotChatInfo.uint32_group_flag_ext2;
      if (this.apolloGameId <= 0)
      {
        int i = paramHotChatInfo.apolloGameId;
        if (i > 0) {
          this.apolloGameId = i;
        }
      }
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("PttShow", new Object[] { "updateHotChatInfo", paramHotChatInfo });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.HotChatInfo
 * JD-Core Version:    0.7.0.1
 */