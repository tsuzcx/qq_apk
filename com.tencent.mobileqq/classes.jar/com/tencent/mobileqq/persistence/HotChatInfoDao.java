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
    paramEntity = (HotChatInfo)paramEntity;
    boolean bool = true;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.troopCode = paramCursor.getString(paramCursor.getColumnIndex("troopCode"));
      paramEntity.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
      paramEntity.troopUin = paramCursor.getString(paramCursor.getColumnIndex("troopUin"));
      paramEntity.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramEntity.memberCount = paramCursor.getInt(paramCursor.getColumnIndex("memberCount"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasJoined"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.hasJoined = paramBoolean;
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isWifiHotChat"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isWifiHotChat = paramBoolean;
      paramEntity.uuid = paramCursor.getString(paramCursor.getColumnIndex("uuid"));
      paramEntity.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
      paramEntity.hotThemeGroupFlag = paramCursor.getInt(paramCursor.getColumnIndex("hotThemeGroupFlag"));
      paramEntity.detail = paramCursor.getString(paramCursor.getColumnIndex("detail"));
      paramEntity.state = paramCursor.getInt(paramCursor.getColumnIndex("state"));
      paramEntity.leftTime = paramCursor.getLong(paramCursor.getColumnIndex("leftTime"));
      paramEntity.ruState = paramCursor.getInt(paramCursor.getColumnIndex("ruState"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("supportFlashPic"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.supportFlashPic = paramBoolean;
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("supportDemo"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.supportDemo = paramBoolean;
      paramEntity.adminLevel = paramCursor.getInt(paramCursor.getColumnIndex("adminLevel"));
      paramEntity.joinUrl = paramCursor.getString(paramCursor.getColumnIndex("joinUrl"));
      paramEntity.hotChatType = paramCursor.getInt(paramCursor.getColumnIndex("hotChatType"));
      paramEntity.memo = paramCursor.getString(paramCursor.getColumnIndex("memo"));
      paramEntity.memoUrl = paramCursor.getString(paramCursor.getColumnIndex("memoUrl"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("memoShowed"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.memoShowed = paramBoolean;
      paramEntity.userCreate = paramCursor.getInt(paramCursor.getColumnIndex("userCreate"));
      paramEntity.strAdminUins = paramCursor.getString(paramCursor.getColumnIndex("strAdminUins"));
      paramEntity.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
      paramEntity.pkFlag = paramCursor.getInt(paramCursor.getColumnIndex("pkFlag"));
      paramEntity.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
      paramEntity.lLastMsgSeq = paramCursor.getLong(paramCursor.getColumnIndex("lLastMsgSeq"));
      paramEntity.extra1 = paramCursor.getString(paramCursor.getColumnIndex("extra1"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isFavorite"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isFavorite = paramBoolean;
      paramEntity.mFissionRoomNum = paramCursor.getInt(paramCursor.getColumnIndex("mFissionRoomNum"));
      paramEntity.praiseCount = paramCursor.getLong(paramCursor.getColumnIndex("praiseCount"));
      paramEntity.uint32_group_flag_ext2 = paramCursor.getInt(paramCursor.getColumnIndex("uint32_group_flag_ext2"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isGameRoom"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isGameRoom = paramBoolean;
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isRobotHotChat"))) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
      paramEntity.isRobotHotChat = paramBoolean;
      paramEntity.robotUin = paramCursor.getLong(paramCursor.getColumnIndex("robotUin"));
      paramEntity.apolloGameId = paramCursor.getInt(paramCursor.getColumnIndex("apolloGameId"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("name");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
    } else {
      paramEntity.name = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("troopCode");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopCode", String.class));
    } else {
      paramEntity.troopCode = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("signature");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("signature", String.class));
    } else {
      paramEntity.signature = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("troopUin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("troopUin", String.class));
    } else {
      paramEntity.troopUin = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("faceId");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceId", Integer.TYPE));
    } else {
      paramEntity.faceId = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("memberCount");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memberCount", Integer.TYPE));
    } else {
      paramEntity.memberCount = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("hasJoined");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasJoined", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.hasJoined = paramBoolean;
    }
    i = paramCursor.getColumnIndex("isWifiHotChat");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isWifiHotChat", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isWifiHotChat = paramBoolean;
    }
    i = paramCursor.getColumnIndex("uuid");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uuid", String.class));
    } else {
      paramEntity.uuid = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("iconUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iconUrl", String.class));
    } else {
      paramEntity.iconUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("hotThemeGroupFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hotThemeGroupFlag", Integer.TYPE));
    } else {
      paramEntity.hotThemeGroupFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("detail");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("detail", String.class));
    } else {
      paramEntity.detail = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("state");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("state", Integer.TYPE));
    } else {
      paramEntity.state = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("leftTime");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("leftTime", Long.TYPE));
    } else {
      paramEntity.leftTime = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("ruState");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ruState", Integer.TYPE));
    } else {
      paramEntity.ruState = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("supportFlashPic");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("supportFlashPic", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.supportFlashPic = paramBoolean;
    }
    i = paramCursor.getColumnIndex("supportDemo");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("supportDemo", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.supportDemo = paramBoolean;
    }
    i = paramCursor.getColumnIndex("adminLevel");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("adminLevel", Integer.TYPE));
    } else {
      paramEntity.adminLevel = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("joinUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("joinUrl", String.class));
    } else {
      paramEntity.joinUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("hotChatType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hotChatType", Integer.TYPE));
    } else {
      paramEntity.hotChatType = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("memo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memo", String.class));
    } else {
      paramEntity.memo = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("memoUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memoUrl", String.class));
    } else {
      paramEntity.memoUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("memoShowed");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("memoShowed", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.memoShowed = paramBoolean;
    }
    i = paramCursor.getColumnIndex("userCreate");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("userCreate", Integer.TYPE));
    } else {
      paramEntity.userCreate = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("strAdminUins");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strAdminUins", String.class));
    } else {
      paramEntity.strAdminUins = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("ownerUin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ownerUin", String.class));
    } else {
      paramEntity.ownerUin = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("pkFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pkFlag", Integer.TYPE));
    } else {
      paramEntity.pkFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("subType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("subType", Integer.TYPE));
    } else {
      paramEntity.subType = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("lLastMsgSeq");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lLastMsgSeq", Long.TYPE));
    } else {
      paramEntity.lLastMsgSeq = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("extra1");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extra1", String.class));
    } else {
      paramEntity.extra1 = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("isFavorite");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isFavorite", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isFavorite = paramBoolean;
    }
    i = paramCursor.getColumnIndex("mFissionRoomNum");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mFissionRoomNum", Integer.TYPE));
    } else {
      paramEntity.mFissionRoomNum = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("praiseCount");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("praiseCount", Long.TYPE));
    } else {
      paramEntity.praiseCount = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("uint32_group_flag_ext2");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uint32_group_flag_ext2", Integer.TYPE));
    } else {
      paramEntity.uint32_group_flag_ext2 = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("isGameRoom");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isGameRoom", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isGameRoom = paramBoolean;
    }
    i = paramCursor.getColumnIndex("isRobotHotChat");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRobotHotChat", Boolean.TYPE));
    }
    else
    {
      i = paramCursor.getShort(i);
      paramBoolean = true;
      if (1 != i) {
        paramBoolean = false;
      }
      paramEntity.isRobotHotChat = paramBoolean;
    }
    i = paramCursor.getColumnIndex("robotUin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("robotUin", Long.TYPE));
    } else {
      paramEntity.robotUin = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("apolloGameId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("apolloGameId", Integer.TYPE));
      return paramEntity;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.HotChatInfoDao
 * JD-Core Version:    0.7.0.1
 */