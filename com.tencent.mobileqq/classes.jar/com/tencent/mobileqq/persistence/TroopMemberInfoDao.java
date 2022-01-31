package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class TroopMemberInfoDao
  extends OGAbstractDao
{
  public TroopMemberInfoDao()
  {
    this.a = 46;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (TroopMemberInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramEntity.memberuin = paramCursor.getString(paramCursor.getColumnIndex("memberuin"));
      paramEntity.friendnick = paramCursor.getString(paramCursor.getColumnIndex("friendnick"));
      paramEntity.pyAll_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_friendnick"));
      paramEntity.pyFirst_friendnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_friendnick"));
      paramEntity.troopnick = paramCursor.getString(paramCursor.getColumnIndex("troopnick"));
      paramEntity.pyAll_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyAll_troopnick"));
      paramEntity.pyFirst_troopnick = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_troopnick"));
      paramEntity.autoremark = paramCursor.getString(paramCursor.getColumnIndex("autoremark"));
      paramEntity.pyAll_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyAll_autoremark"));
      paramEntity.pyFirst_autoremark = paramCursor.getString(paramCursor.getColumnIndex("pyFirst_autoremark"));
      paramEntity.troopremark = paramCursor.getString(paramCursor.getColumnIndex("troopremark"));
      paramEntity.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
      paramEntity.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
      paramEntity.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramEntity.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramEntity.sex = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sex")));
      paramEntity.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramEntity.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
      paramEntity.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
      paramEntity.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
      paramEntity.level = paramCursor.getInt(paramCursor.getColumnIndex("level"));
      paramEntity.realLevel = paramCursor.getInt(paramCursor.getColumnIndex("realLevel"));
      paramEntity.mGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("mGlamourLevel"));
      paramEntity.hotChatGlamourLevel = paramCursor.getInt(paramCursor.getColumnIndex("hotChatGlamourLevel"));
      paramEntity.globalTroopLevel = paramCursor.getInt(paramCursor.getColumnIndex("globalTroopLevel"));
      paramEntity.join_time = paramCursor.getLong(paramCursor.getColumnIndex("join_time"));
      paramEntity.last_active_time = paramCursor.getLong(paramCursor.getColumnIndex("last_active_time"));
      paramEntity.active_point = paramCursor.getLong(paramCursor.getColumnIndex("active_point"));
      paramEntity.credit_level = paramCursor.getLong(paramCursor.getColumnIndex("credit_level"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isTroopFollowed")))
      {
        paramBoolean = true;
        paramEntity.isTroopFollowed = paramBoolean;
        paramEntity.distance = paramCursor.getInt(paramCursor.getColumnIndex("distance"));
        paramEntity.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
        paramEntity.gagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("gagTimeStamp"));
        paramEntity.distanceToSelf = paramCursor.getDouble(paramCursor.getColumnIndex("distanceToSelf"));
        paramEntity.distanceToSelfUpdateTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mIsShielded"))) {
          break label869;
        }
      }
      label869:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.mIsShielded = paramBoolean;
        paramEntity.mUniqueTitle = paramCursor.getString(paramCursor.getColumnIndex("mUniqueTitle"));
        paramEntity.mUniqueTitleExpire = paramCursor.getInt(paramCursor.getColumnIndex("mUniqueTitleExpire"));
        paramEntity.tribeLevel = paramCursor.getInt(paramCursor.getColumnIndex("tribeLevel"));
        paramEntity.tribePoint = paramCursor.getInt(paramCursor.getColumnIndex("tribePoint"));
        paramEntity.commonFrdCnt = paramCursor.getInt(paramCursor.getColumnIndex("commonFrdCnt"));
        paramEntity.hwIdentity = paramCursor.getInt(paramCursor.getColumnIndex("hwIdentity"));
        paramEntity.hwCourse = paramCursor.getString(paramCursor.getColumnIndex("hwCourse"));
        paramEntity.hwName = paramCursor.getString(paramCursor.getColumnIndex("hwName"));
        paramEntity.recommendRemark = paramCursor.getString(paramCursor.getColumnIndex("recommendRemark"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("troopuin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("troopuin", String.class));
      i = paramCursor.getColumnIndex("memberuin");
      if (i != -1) {
        break label2484;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memberuin", String.class));
      label942:
      i = paramCursor.getColumnIndex("friendnick");
      if (i != -1) {
        break label2499;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("friendnick", String.class));
      label976:
      i = paramCursor.getColumnIndex("pyAll_friendnick");
      if (i != -1) {
        break label2514;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyAll_friendnick", String.class));
      label1010:
      i = paramCursor.getColumnIndex("pyFirst_friendnick");
      if (i != -1) {
        break label2529;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFirst_friendnick", String.class));
      label1044:
      i = paramCursor.getColumnIndex("troopnick");
      if (i != -1) {
        break label2544;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopnick", String.class));
      label1078:
      i = paramCursor.getColumnIndex("pyAll_troopnick");
      if (i != -1) {
        break label2559;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyAll_troopnick", String.class));
      label1112:
      i = paramCursor.getColumnIndex("pyFirst_troopnick");
      if (i != -1) {
        break label2574;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFirst_troopnick", String.class));
      label1146:
      i = paramCursor.getColumnIndex("autoremark");
      if (i != -1) {
        break label2589;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("autoremark", String.class));
      label1180:
      i = paramCursor.getColumnIndex("pyAll_autoremark");
      if (i != -1) {
        break label2604;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyAll_autoremark", String.class));
      label1214:
      i = paramCursor.getColumnIndex("pyFirst_autoremark");
      if (i != -1) {
        break label2619;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFirst_autoremark", String.class));
      label1248:
      i = paramCursor.getColumnIndex("troopremark");
      if (i != -1) {
        break label2634;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopremark", String.class));
      label1282:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label2649;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("alias", String.class));
      label1316:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label2664;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("datetime", Long.TYPE));
      label1351:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label2679;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceid", Short.TYPE));
      label1386:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2694;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Byte.TYPE));
      label1421:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label2710;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sex", Byte.TYPE));
      label1456:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label2726;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("status", Byte.TYPE));
      label1491:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label2742;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1526:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label2757;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1561:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label2772;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1596:
      i = paramCursor.getColumnIndex("level");
      if (i != -1) {
        break label2787;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("level", Integer.TYPE));
      label1631:
      i = paramCursor.getColumnIndex("realLevel");
      if (i != -1) {
        break label2802;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("realLevel", Integer.TYPE));
      label1666:
      i = paramCursor.getColumnIndex("mGlamourLevel");
      if (i != -1) {
        break label2817;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mGlamourLevel", Integer.TYPE));
      label1701:
      i = paramCursor.getColumnIndex("hotChatGlamourLevel");
      if (i != -1) {
        break label2832;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hotChatGlamourLevel", Integer.TYPE));
      label1736:
      i = paramCursor.getColumnIndex("globalTroopLevel");
      if (i != -1) {
        break label2847;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("globalTroopLevel", Integer.TYPE));
      label1771:
      i = paramCursor.getColumnIndex("join_time");
      if (i != -1) {
        break label2862;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("join_time", Long.TYPE));
      label1806:
      i = paramCursor.getColumnIndex("last_active_time");
      if (i != -1) {
        break label2877;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("last_active_time", Long.TYPE));
      label1841:
      i = paramCursor.getColumnIndex("active_point");
      if (i != -1) {
        break label2892;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("active_point", Long.TYPE));
      label1876:
      i = paramCursor.getColumnIndex("credit_level");
      if (i != -1) {
        break label2907;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("credit_level", Long.TYPE));
      label1911:
      i = paramCursor.getColumnIndex("isTroopFollowed");
      if (i != -1) {
        break label2922;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isTroopFollowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label2949;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distance", Integer.TYPE));
      label1981:
      i = paramCursor.getColumnIndex("msgseq");
      if (i != -1) {
        break label2964;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("msgseq", Long.TYPE));
      label2016:
      i = paramCursor.getColumnIndex("gagTimeStamp");
      if (i != -1) {
        break label2979;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gagTimeStamp", Long.TYPE));
      label2051:
      i = paramCursor.getColumnIndex("distanceToSelf");
      if (i != -1) {
        break label2994;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distanceToSelf", Double.TYPE));
      label2086:
      i = paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp");
      if (i != -1) {
        break label3009;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distanceToSelfUpdateTimeStamp", Long.TYPE));
      label2121:
      i = paramCursor.getColumnIndex("mIsShielded");
      if (i != -1) {
        break label3024;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mIsShielded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mUniqueTitle");
      if (i != -1) {
        break label3052;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mUniqueTitle", String.class));
      label2190:
      i = paramCursor.getColumnIndex("mUniqueTitleExpire");
      if (i != -1) {
        break label3067;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mUniqueTitleExpire", Integer.TYPE));
      label2225:
      i = paramCursor.getColumnIndex("tribeLevel");
      if (i != -1) {
        break label3082;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tribeLevel", Integer.TYPE));
      label2260:
      i = paramCursor.getColumnIndex("tribePoint");
      if (i != -1) {
        break label3097;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tribePoint", Integer.TYPE));
      label2295:
      i = paramCursor.getColumnIndex("commonFrdCnt");
      if (i != -1) {
        break label3112;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("commonFrdCnt", Integer.TYPE));
      label2330:
      i = paramCursor.getColumnIndex("hwIdentity");
      if (i != -1) {
        break label3127;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hwIdentity", Integer.TYPE));
      label2365:
      i = paramCursor.getColumnIndex("hwCourse");
      if (i != -1) {
        break label3142;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hwCourse", String.class));
      label2399:
      i = paramCursor.getColumnIndex("hwName");
      if (i != -1) {
        break label3157;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hwName", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("recommendRemark");
      if (i != -1) {
        break label3172;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("recommendRemark", String.class));
      return paramEntity;
      paramEntity.troopuin = paramCursor.getString(i);
      break;
      label2484:
      paramEntity.memberuin = paramCursor.getString(i);
      break label942;
      label2499:
      paramEntity.friendnick = paramCursor.getString(i);
      break label976;
      label2514:
      paramEntity.pyAll_friendnick = paramCursor.getString(i);
      break label1010;
      label2529:
      paramEntity.pyFirst_friendnick = paramCursor.getString(i);
      break label1044;
      label2544:
      paramEntity.troopnick = paramCursor.getString(i);
      break label1078;
      label2559:
      paramEntity.pyAll_troopnick = paramCursor.getString(i);
      break label1112;
      label2574:
      paramEntity.pyFirst_troopnick = paramCursor.getString(i);
      break label1146;
      label2589:
      paramEntity.autoremark = paramCursor.getString(i);
      break label1180;
      label2604:
      paramEntity.pyAll_autoremark = paramCursor.getString(i);
      break label1214;
      label2619:
      paramEntity.pyFirst_autoremark = paramCursor.getString(i);
      break label1248;
      label2634:
      paramEntity.troopremark = paramCursor.getString(i);
      break label1282;
      label2649:
      paramEntity.alias = paramCursor.getString(i);
      break label1316;
      label2664:
      paramEntity.datetime = paramCursor.getLong(i);
      break label1351;
      label2679:
      paramEntity.faceid = paramCursor.getShort(i);
      break label1386;
      label2694:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label1421;
      label2710:
      paramEntity.sex = ((byte)paramCursor.getShort(i));
      break label1456;
      label2726:
      paramEntity.status = ((byte)paramCursor.getShort(i));
      break label1491;
      label2742:
      paramEntity.qqVipInfo = paramCursor.getInt(i);
      break label1526;
      label2757:
      paramEntity.superQqInfo = paramCursor.getInt(i);
      break label1561;
      label2772:
      paramEntity.superVipInfo = paramCursor.getInt(i);
      break label1596;
      label2787:
      paramEntity.level = paramCursor.getInt(i);
      break label1631;
      label2802:
      paramEntity.realLevel = paramCursor.getInt(i);
      break label1666;
      label2817:
      paramEntity.mGlamourLevel = paramCursor.getInt(i);
      break label1701;
      label2832:
      paramEntity.hotChatGlamourLevel = paramCursor.getInt(i);
      break label1736;
      label2847:
      paramEntity.globalTroopLevel = paramCursor.getInt(i);
      break label1771;
      label2862:
      paramEntity.join_time = paramCursor.getLong(i);
      break label1806;
      label2877:
      paramEntity.last_active_time = paramCursor.getLong(i);
      break label1841;
      label2892:
      paramEntity.active_point = paramCursor.getLong(i);
      break label1876;
      label2907:
      paramEntity.credit_level = paramCursor.getLong(i);
      break label1911;
      label2922:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isTroopFollowed = paramBoolean;
        break;
      }
      label2949:
      paramEntity.distance = paramCursor.getInt(i);
      break label1981;
      label2964:
      paramEntity.msgseq = paramCursor.getLong(i);
      break label2016;
      label2979:
      paramEntity.gagTimeStamp = paramCursor.getLong(i);
      break label2051;
      label2994:
      paramEntity.distanceToSelf = paramCursor.getDouble(i);
      break label2086;
      label3009:
      paramEntity.distanceToSelfUpdateTimeStamp = paramCursor.getLong(i);
      break label2121;
      label3024:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.mIsShielded = paramBoolean;
        break;
      }
      label3052:
      paramEntity.mUniqueTitle = paramCursor.getString(i);
      break label2190;
      label3067:
      paramEntity.mUniqueTitleExpire = paramCursor.getInt(i);
      break label2225;
      label3082:
      paramEntity.tribeLevel = paramCursor.getInt(i);
      break label2260;
      label3097:
      paramEntity.tribePoint = paramCursor.getInt(i);
      break label2295;
      label3112:
      paramEntity.commonFrdCnt = paramCursor.getInt(i);
      break label2330;
      label3127:
      paramEntity.hwIdentity = paramCursor.getInt(i);
      break label2365;
      label3142:
      paramEntity.hwCourse = paramCursor.getString(i);
      break label2399;
      label3157:
      paramEntity.hwName = paramCursor.getString(i);
    }
    label3172:
    paramEntity.recommendRemark = paramCursor.getString(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopuin TEXT ,memberuin TEXT ,friendnick TEXT ,pyAll_friendnick TEXT ,pyFirst_friendnick TEXT ,troopnick TEXT ,pyAll_troopnick TEXT ,pyFirst_troopnick TEXT ,autoremark TEXT ,pyAll_autoremark TEXT ,pyFirst_autoremark TEXT ,troopremark TEXT ,alias TEXT ,datetime INTEGER ,faceid INTEGER ,age INTEGER ,sex INTEGER ,status INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,level INTEGER ,realLevel INTEGER ,mGlamourLevel INTEGER ,hotChatGlamourLevel INTEGER ,globalTroopLevel INTEGER ,join_time INTEGER ,last_active_time INTEGER ,active_point INTEGER ,credit_level INTEGER ,isTroopFollowed INTEGER ,distance INTEGER ,msgseq INTEGER ,gagTimeStamp INTEGER ,distanceToSelf REAL ,distanceToSelfUpdateTimeStamp INTEGER ,mIsShielded INTEGER ,mUniqueTitle TEXT ,mUniqueTitleExpire INTEGER ,tribeLevel INTEGER ,tribePoint INTEGER ,commonFrdCnt INTEGER ,hwIdentity INTEGER ,hwCourse TEXT ,hwName TEXT ,recommendRemark TEXT,UNIQUE(troopuin,memberuin) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopMemberInfo)paramEntity;
    paramContentValues.put("troopuin", paramEntity.troopuin);
    paramContentValues.put("memberuin", paramEntity.memberuin);
    paramContentValues.put("friendnick", paramEntity.friendnick);
    paramContentValues.put("pyAll_friendnick", paramEntity.pyAll_friendnick);
    paramContentValues.put("pyFirst_friendnick", paramEntity.pyFirst_friendnick);
    paramContentValues.put("troopnick", paramEntity.troopnick);
    paramContentValues.put("pyAll_troopnick", paramEntity.pyAll_troopnick);
    paramContentValues.put("pyFirst_troopnick", paramEntity.pyFirst_troopnick);
    paramContentValues.put("autoremark", paramEntity.autoremark);
    paramContentValues.put("pyAll_autoremark", paramEntity.pyAll_autoremark);
    paramContentValues.put("pyFirst_autoremark", paramEntity.pyFirst_autoremark);
    paramContentValues.put("troopremark", paramEntity.troopremark);
    paramContentValues.put("alias", paramEntity.alias);
    paramContentValues.put("datetime", Long.valueOf(paramEntity.datetime));
    paramContentValues.put("faceid", Short.valueOf(paramEntity.faceid));
    paramContentValues.put("age", Byte.valueOf(paramEntity.age));
    paramContentValues.put("sex", Byte.valueOf(paramEntity.sex));
    paramContentValues.put("status", Byte.valueOf(paramEntity.status));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramEntity.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramEntity.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramEntity.superVipInfo));
    paramContentValues.put("level", Integer.valueOf(paramEntity.level));
    paramContentValues.put("realLevel", Integer.valueOf(paramEntity.realLevel));
    paramContentValues.put("mGlamourLevel", Integer.valueOf(paramEntity.mGlamourLevel));
    paramContentValues.put("hotChatGlamourLevel", Integer.valueOf(paramEntity.hotChatGlamourLevel));
    paramContentValues.put("globalTroopLevel", Integer.valueOf(paramEntity.globalTroopLevel));
    paramContentValues.put("join_time", Long.valueOf(paramEntity.join_time));
    paramContentValues.put("last_active_time", Long.valueOf(paramEntity.last_active_time));
    paramContentValues.put("active_point", Long.valueOf(paramEntity.active_point));
    paramContentValues.put("credit_level", Long.valueOf(paramEntity.credit_level));
    paramContentValues.put("isTroopFollowed", Boolean.valueOf(paramEntity.isTroopFollowed));
    paramContentValues.put("distance", Integer.valueOf(paramEntity.distance));
    paramContentValues.put("msgseq", Long.valueOf(paramEntity.msgseq));
    paramContentValues.put("gagTimeStamp", Long.valueOf(paramEntity.gagTimeStamp));
    paramContentValues.put("distanceToSelf", Double.valueOf(paramEntity.distanceToSelf));
    paramContentValues.put("distanceToSelfUpdateTimeStamp", Long.valueOf(paramEntity.distanceToSelfUpdateTimeStamp));
    paramContentValues.put("mIsShielded", Boolean.valueOf(paramEntity.mIsShielded));
    paramContentValues.put("mUniqueTitle", paramEntity.mUniqueTitle);
    paramContentValues.put("mUniqueTitleExpire", Integer.valueOf(paramEntity.mUniqueTitleExpire));
    paramContentValues.put("tribeLevel", Integer.valueOf(paramEntity.tribeLevel));
    paramContentValues.put("tribePoint", Integer.valueOf(paramEntity.tribePoint));
    paramContentValues.put("commonFrdCnt", Integer.valueOf(paramEntity.commonFrdCnt));
    paramContentValues.put("hwIdentity", Integer.valueOf(paramEntity.hwIdentity));
    paramContentValues.put("hwCourse", paramEntity.hwCourse);
    paramContentValues.put("hwName", paramEntity.hwName);
    paramContentValues.put("recommendRemark", paramEntity.recommendRemark);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.TroopMemberInfoDao
 * JD-Core Version:    0.7.0.1
 */