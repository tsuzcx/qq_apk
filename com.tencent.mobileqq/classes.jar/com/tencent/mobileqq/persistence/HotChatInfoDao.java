package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.HotChatInfo;

public class HotChatInfoDao
  extends OGAbstractDao
{
  public HotChatInfoDao()
  {
    this.columnLen = 38;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (HotChatInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.troopCode = paramCursor.getString(paramCursor.getColumnIndex("troopCode"));
      paramEntity.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
      paramEntity.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramEntity.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramEntity.memberCount = paramCursor.getInt(paramCursor.getColumnIndex("memberCount"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasJoined")))
      {
        paramBoolean = true;
        paramEntity.hasJoined = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isWifiHotChat"))) {
          break label764;
        }
        paramBoolean = true;
        label169:
        paramEntity.isWifiHotChat = paramBoolean;
        paramEntity.uuid = paramCursor.getString(paramCursor.getColumnIndex("uuid"));
        paramEntity.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        paramEntity.hotThemeGroupFlag = paramCursor.getInt(paramCursor.getColumnIndex("hotThemeGroupFlag"));
        paramEntity.detail = paramCursor.getString(paramCursor.getColumnIndex("detail"));
        paramEntity.state = paramCursor.getInt(paramCursor.getColumnIndex("state"));
        paramEntity.leftTime = paramCursor.getLong(paramCursor.getColumnIndex("leftTime"));
        paramEntity.ruState = paramCursor.getInt(paramCursor.getColumnIndex("ruState"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportFlashPic"))) {
          break label769;
        }
        paramBoolean = true;
        label320:
        paramEntity.supportFlashPic = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("supportDemo"))) {
          break label774;
        }
        paramBoolean = true;
        label345:
        paramEntity.supportDemo = paramBoolean;
        paramEntity.adminLevel = paramCursor.getInt(paramCursor.getColumnIndex("adminLevel"));
        paramEntity.joinUrl = paramCursor.getString(paramCursor.getColumnIndex("joinUrl"));
        paramEntity.hotChatType = paramCursor.getInt(paramCursor.getColumnIndex("hotChatType"));
        paramEntity.memo = paramCursor.getString(paramCursor.getColumnIndex("memo"));
        paramEntity.memoUrl = paramCursor.getString(paramCursor.getColumnIndex("memoUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("memoShowed"))) {
          break label779;
        }
        paramBoolean = true;
        label460:
        paramEntity.memoShowed = paramBoolean;
        paramEntity.userCreate = paramCursor.getInt(paramCursor.getColumnIndex("userCreate"));
        paramEntity.strAdminUins = paramCursor.getString(paramCursor.getColumnIndex("strAdminUins"));
        paramEntity.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
        paramEntity.pkFlag = paramCursor.getInt(paramCursor.getColumnIndex("pkFlag"));
        paramEntity.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramEntity.lLastMsgSeq = paramCursor.getLong(paramCursor.getColumnIndex("lLastMsgSeq"));
        paramEntity.extra1 = paramCursor.getString(paramCursor.getColumnIndex("extra1"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isFavorite"))) {
          break label784;
        }
        paramBoolean = true;
        label611:
        paramEntity.isFavorite = paramBoolean;
        paramEntity.mFissionRoomNum = paramCursor.getInt(paramCursor.getColumnIndex("mFissionRoomNum"));
        paramEntity.praiseCount = paramCursor.getLong(paramCursor.getColumnIndex("praiseCount"));
        paramEntity.uint32_group_flag_ext2 = paramCursor.getInt(paramCursor.getColumnIndex("uint32_group_flag_ext2"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGameRoom"))) {
          break label789;
        }
        paramBoolean = true;
        label690:
        paramEntity.isGameRoom = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRobotHotChat"))) {
          break label794;
        }
      }
      label769:
      label774:
      label779:
      label784:
      label789:
      label794:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isRobotHotChat = paramBoolean;
        paramEntity.robotUin = paramCursor.getLong(paramCursor.getColumnIndex("robotUin"));
        paramEntity.apolloGameId = paramCursor.getInt(paramCursor.getColumnIndex("apolloGameId"));
        return paramEntity;
        paramBoolean = false;
        break;
        label764:
        paramBoolean = false;
        break label169;
        paramBoolean = false;
        break label320;
        paramBoolean = false;
        break label345;
        paramBoolean = false;
        break label460;
        paramBoolean = false;
        break label611;
        paramBoolean = false;
        break label690;
      }
    }
    int i = paramCursor.getColumnIndex("name");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
      i = paramCursor.getColumnIndex("troopCode");
      if (i != -1) {
        break label2133;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCode", String.class));
      label867:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label2148;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("signature", String.class));
      label901:
      i = paramCursor.getColumnIndex("troopUin");
      if (i != -1) {
        break label2163;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopUin", String.class));
      label935:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label2178;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceId", Integer.TYPE));
      label970:
      i = paramCursor.getColumnIndex("memberCount");
      if (i != -1) {
        break label2193;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberCount", Integer.TYPE));
      label1005:
      i = paramCursor.getColumnIndex("hasJoined");
      if (i != -1) {
        break label2208;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasJoined", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isWifiHotChat");
      if (i != -1) {
        break label2235;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isWifiHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uuid");
      if (i != -1) {
        break label2262;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uuid", String.class));
      label1109:
      i = paramCursor.getColumnIndex("iconUrl");
      if (i != -1) {
        break label2277;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iconUrl", String.class));
      label1143:
      i = paramCursor.getColumnIndex("hotThemeGroupFlag");
      if (i != -1) {
        break label2292;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hotThemeGroupFlag", Integer.TYPE));
      label1178:
      i = paramCursor.getColumnIndex("detail");
      if (i != -1) {
        break label2307;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("detail", String.class));
      label1212:
      i = paramCursor.getColumnIndex("state");
      if (i != -1) {
        break label2322;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("state", Integer.TYPE));
      label1247:
      i = paramCursor.getColumnIndex("leftTime");
      if (i != -1) {
        break label2337;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("leftTime", Long.TYPE));
      label1282:
      i = paramCursor.getColumnIndex("ruState");
      if (i != -1) {
        break label2352;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ruState", Integer.TYPE));
      label1317:
      i = paramCursor.getColumnIndex("supportFlashPic");
      if (i != -1) {
        break label2367;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("supportFlashPic", Boolean.TYPE));
      i = paramCursor.getColumnIndex("supportDemo");
      if (i != -1) {
        break label2394;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("supportDemo", Boolean.TYPE));
      i = paramCursor.getColumnIndex("adminLevel");
      if (i != -1) {
        break label2421;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("adminLevel", Integer.TYPE));
      label1422:
      i = paramCursor.getColumnIndex("joinUrl");
      if (i != -1) {
        break label2436;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("joinUrl", String.class));
      label1456:
      i = paramCursor.getColumnIndex("hotChatType");
      if (i != -1) {
        break label2451;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hotChatType", Integer.TYPE));
      label1491:
      i = paramCursor.getColumnIndex("memo");
      if (i != -1) {
        break label2466;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memo", String.class));
      label1525:
      i = paramCursor.getColumnIndex("memoUrl");
      if (i != -1) {
        break label2481;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memoUrl", String.class));
      label1559:
      i = paramCursor.getColumnIndex("memoShowed");
      if (i != -1) {
        break label2496;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memoShowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("userCreate");
      if (i != -1) {
        break label2523;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("userCreate", Integer.TYPE));
      label1629:
      i = paramCursor.getColumnIndex("strAdminUins");
      if (i != -1) {
        break label2538;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strAdminUins", String.class));
      label1663:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label2553;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ownerUin", String.class));
      label1697:
      i = paramCursor.getColumnIndex("pkFlag");
      if (i != -1) {
        break label2568;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pkFlag", Integer.TYPE));
      label1732:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label2583;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("subType", Integer.TYPE));
      label1767:
      i = paramCursor.getColumnIndex("lLastMsgSeq");
      if (i != -1) {
        break label2598;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lLastMsgSeq", Long.TYPE));
      label1802:
      i = paramCursor.getColumnIndex("extra1");
      if (i != -1) {
        break label2613;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extra1", String.class));
      label1836:
      i = paramCursor.getColumnIndex("isFavorite");
      if (i != -1) {
        break label2628;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isFavorite", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mFissionRoomNum");
      if (i != -1) {
        break label2655;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mFissionRoomNum", Integer.TYPE));
      label1906:
      i = paramCursor.getColumnIndex("praiseCount");
      if (i != -1) {
        break label2670;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("praiseCount", Long.TYPE));
      label1941:
      i = paramCursor.getColumnIndex("uint32_group_flag_ext2");
      if (i != -1) {
        break label2685;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uint32_group_flag_ext2", Integer.TYPE));
      label1976:
      i = paramCursor.getColumnIndex("isGameRoom");
      if (i != -1) {
        break label2700;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGameRoom", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRobotHotChat");
      if (i != -1) {
        break label2727;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRobotHotChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("robotUin");
      if (i != -1) {
        break label2755;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("robotUin", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("apolloGameId");
      if (i != -1) {
        break label2770;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("apolloGameId", Integer.TYPE));
      return paramEntity;
      paramEntity.name = paramCursor.getString(i);
      break;
      label2133:
      paramEntity.troopCode = paramCursor.getString(i);
      break label867;
      label2148:
      paramEntity.signature = paramCursor.getString(i);
      break label901;
      label2163:
      paramEntity.troopUin = paramCursor.getString(i);
      break label935;
      label2178:
      paramEntity.faceId = paramCursor.getInt(i);
      break label970;
      label2193:
      paramEntity.memberCount = paramCursor.getInt(i);
      break label1005;
      label2208:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasJoined = paramBoolean;
        break;
      }
      label2235:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isWifiHotChat = paramBoolean;
        break;
      }
      label2262:
      paramEntity.uuid = paramCursor.getString(i);
      break label1109;
      label2277:
      paramEntity.iconUrl = paramCursor.getString(i);
      break label1143;
      label2292:
      paramEntity.hotThemeGroupFlag = paramCursor.getInt(i);
      break label1178;
      label2307:
      paramEntity.detail = paramCursor.getString(i);
      break label1212;
      label2322:
      paramEntity.state = paramCursor.getInt(i);
      break label1247;
      label2337:
      paramEntity.leftTime = paramCursor.getLong(i);
      break label1282;
      label2352:
      paramEntity.ruState = paramCursor.getInt(i);
      break label1317;
      label2367:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.supportFlashPic = paramBoolean;
        break;
      }
      label2394:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.supportDemo = paramBoolean;
        break;
      }
      label2421:
      paramEntity.adminLevel = paramCursor.getInt(i);
      break label1422;
      label2436:
      paramEntity.joinUrl = paramCursor.getString(i);
      break label1456;
      label2451:
      paramEntity.hotChatType = paramCursor.getInt(i);
      break label1491;
      label2466:
      paramEntity.memo = paramCursor.getString(i);
      break label1525;
      label2481:
      paramEntity.memoUrl = paramCursor.getString(i);
      break label1559;
      label2496:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.memoShowed = paramBoolean;
        break;
      }
      label2523:
      paramEntity.userCreate = paramCursor.getInt(i);
      break label1629;
      label2538:
      paramEntity.strAdminUins = paramCursor.getString(i);
      break label1663;
      label2553:
      paramEntity.ownerUin = paramCursor.getString(i);
      break label1697;
      label2568:
      paramEntity.pkFlag = paramCursor.getInt(i);
      break label1732;
      label2583:
      paramEntity.subType = paramCursor.getInt(i);
      break label1767;
      label2598:
      paramEntity.lLastMsgSeq = paramCursor.getLong(i);
      break label1802;
      label2613:
      paramEntity.extra1 = paramCursor.getString(i);
      break label1836;
      label2628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isFavorite = paramBoolean;
        break;
      }
      label2655:
      paramEntity.mFissionRoomNum = paramCursor.getInt(i);
      break label1906;
      label2670:
      paramEntity.praiseCount = paramCursor.getLong(i);
      break label1941;
      label2685:
      paramEntity.uint32_group_flag_ext2 = paramCursor.getInt(i);
      break label1976;
      label2700:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isGameRoom = paramBoolean;
        break;
      }
      label2727:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isRobotHotChat = paramBoolean;
        break;
      }
      label2755:
      paramEntity.robotUin = paramCursor.getLong(i);
    }
    label2770:
    paramEntity.apolloGameId = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (HotChatInfo)paramEntity;
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("troopCode", paramEntity.troopCode);
    paramContentValues.put("signature", paramEntity.signature);
    paramContentValues.put("troopUin", paramEntity.troopUin);
    paramContentValues.put("faceId", Integer.valueOf(paramEntity.faceId));
    paramContentValues.put("memberCount", Integer.valueOf(paramEntity.memberCount));
    paramContentValues.put("hasJoined", Boolean.valueOf(paramEntity.hasJoined));
    paramContentValues.put("isWifiHotChat", Boolean.valueOf(paramEntity.isWifiHotChat));
    paramContentValues.put("uuid", paramEntity.uuid);
    paramContentValues.put("iconUrl", paramEntity.iconUrl);
    paramContentValues.put("hotThemeGroupFlag", Integer.valueOf(paramEntity.hotThemeGroupFlag));
    paramContentValues.put("detail", paramEntity.detail);
    paramContentValues.put("state", Integer.valueOf(paramEntity.state));
    paramContentValues.put("leftTime", Long.valueOf(paramEntity.leftTime));
    paramContentValues.put("ruState", Integer.valueOf(paramEntity.ruState));
    paramContentValues.put("supportFlashPic", Boolean.valueOf(paramEntity.supportFlashPic));
    paramContentValues.put("supportDemo", Boolean.valueOf(paramEntity.supportDemo));
    paramContentValues.put("adminLevel", Integer.valueOf(paramEntity.adminLevel));
    paramContentValues.put("joinUrl", paramEntity.joinUrl);
    paramContentValues.put("hotChatType", Integer.valueOf(paramEntity.hotChatType));
    paramContentValues.put("memo", paramEntity.memo);
    paramContentValues.put("memoUrl", paramEntity.memoUrl);
    paramContentValues.put("memoShowed", Boolean.valueOf(paramEntity.memoShowed));
    paramContentValues.put("userCreate", Integer.valueOf(paramEntity.userCreate));
    paramContentValues.put("strAdminUins", paramEntity.strAdminUins);
    paramContentValues.put("ownerUin", paramEntity.ownerUin);
    paramContentValues.put("pkFlag", Integer.valueOf(paramEntity.pkFlag));
    paramContentValues.put("subType", Integer.valueOf(paramEntity.subType));
    paramContentValues.put("lLastMsgSeq", Long.valueOf(paramEntity.lLastMsgSeq));
    paramContentValues.put("extra1", paramEntity.extra1);
    paramContentValues.put("isFavorite", Boolean.valueOf(paramEntity.isFavorite));
    paramContentValues.put("mFissionRoomNum", Integer.valueOf(paramEntity.mFissionRoomNum));
    paramContentValues.put("praiseCount", Long.valueOf(paramEntity.praiseCount));
    paramContentValues.put("uint32_group_flag_ext2", Integer.valueOf(paramEntity.uint32_group_flag_ext2));
    paramContentValues.put("isGameRoom", Boolean.valueOf(paramEntity.isGameRoom));
    paramContentValues.put("isRobotHotChat", Boolean.valueOf(paramEntity.isRobotHotChat));
    paramContentValues.put("robotUin", Long.valueOf(paramEntity.robotUin));
    paramContentValues.put("apolloGameId", Integer.valueOf(paramEntity.apolloGameId));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT ,troopCode TEXT ,signature TEXT ,troopUin TEXT UNIQUE ,faceId INTEGER ,memberCount INTEGER ,hasJoined INTEGER ,isWifiHotChat INTEGER ,uuid TEXT ,iconUrl TEXT ,hotThemeGroupFlag INTEGER ,detail TEXT ,state INTEGER ,leftTime INTEGER ,ruState INTEGER ,supportFlashPic INTEGER ,supportDemo INTEGER ,adminLevel INTEGER ,joinUrl TEXT ,hotChatType INTEGER ,memo TEXT ,memoUrl TEXT ,memoShowed INTEGER ,userCreate INTEGER ,strAdminUins TEXT ,ownerUin TEXT ,pkFlag INTEGER ,subType INTEGER ,lLastMsgSeq INTEGER ,extra1 TEXT ,isFavorite INTEGER ,mFissionRoomNum INTEGER ,praiseCount INTEGER ,uint32_group_flag_ext2 INTEGER ,isGameRoom INTEGER ,isRobotHotChat INTEGER ,robotUin INTEGER ,apolloGameId INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.HotChatInfoDao
 * JD-Core Version:    0.7.0.1
 */