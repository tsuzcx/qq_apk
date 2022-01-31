package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class TroopMemberInfoDao
  extends OGAbstractDao
{
  public TroopMemberInfoDao()
  {
    this.a = 47;
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
          break label887;
        }
      }
      label887:
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
        paramEntity.isShowQZone = paramCursor.getInt(paramCursor.getColumnIndex("isShowQZone"));
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
        break label2537;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memberuin", String.class));
      label960:
      i = paramCursor.getColumnIndex("friendnick");
      if (i != -1) {
        break label2552;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("friendnick", String.class));
      label994:
      i = paramCursor.getColumnIndex("pyAll_friendnick");
      if (i != -1) {
        break label2567;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyAll_friendnick", String.class));
      label1028:
      i = paramCursor.getColumnIndex("pyFirst_friendnick");
      if (i != -1) {
        break label2582;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFirst_friendnick", String.class));
      label1062:
      i = paramCursor.getColumnIndex("troopnick");
      if (i != -1) {
        break label2597;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopnick", String.class));
      label1096:
      i = paramCursor.getColumnIndex("pyAll_troopnick");
      if (i != -1) {
        break label2612;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyAll_troopnick", String.class));
      label1130:
      i = paramCursor.getColumnIndex("pyFirst_troopnick");
      if (i != -1) {
        break label2627;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFirst_troopnick", String.class));
      label1164:
      i = paramCursor.getColumnIndex("autoremark");
      if (i != -1) {
        break label2642;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("autoremark", String.class));
      label1198:
      i = paramCursor.getColumnIndex("pyAll_autoremark");
      if (i != -1) {
        break label2657;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyAll_autoremark", String.class));
      label1232:
      i = paramCursor.getColumnIndex("pyFirst_autoremark");
      if (i != -1) {
        break label2672;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFirst_autoremark", String.class));
      label1266:
      i = paramCursor.getColumnIndex("troopremark");
      if (i != -1) {
        break label2687;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopremark", String.class));
      label1300:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label2702;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("alias", String.class));
      label1334:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label2717;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("datetime", Long.TYPE));
      label1369:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label2732;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceid", Short.TYPE));
      label1404:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2747;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Byte.TYPE));
      label1439:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label2763;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sex", Byte.TYPE));
      label1474:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label2779;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("status", Byte.TYPE));
      label1509:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label2795;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1544:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label2810;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1579:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label2825;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1614:
      i = paramCursor.getColumnIndex("level");
      if (i != -1) {
        break label2840;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("level", Integer.TYPE));
      label1649:
      i = paramCursor.getColumnIndex("realLevel");
      if (i != -1) {
        break label2855;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("realLevel", Integer.TYPE));
      label1684:
      i = paramCursor.getColumnIndex("mGlamourLevel");
      if (i != -1) {
        break label2870;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mGlamourLevel", Integer.TYPE));
      label1719:
      i = paramCursor.getColumnIndex("hotChatGlamourLevel");
      if (i != -1) {
        break label2885;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hotChatGlamourLevel", Integer.TYPE));
      label1754:
      i = paramCursor.getColumnIndex("globalTroopLevel");
      if (i != -1) {
        break label2900;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("globalTroopLevel", Integer.TYPE));
      label1789:
      i = paramCursor.getColumnIndex("join_time");
      if (i != -1) {
        break label2915;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("join_time", Long.TYPE));
      label1824:
      i = paramCursor.getColumnIndex("last_active_time");
      if (i != -1) {
        break label2930;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("last_active_time", Long.TYPE));
      label1859:
      i = paramCursor.getColumnIndex("active_point");
      if (i != -1) {
        break label2945;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("active_point", Long.TYPE));
      label1894:
      i = paramCursor.getColumnIndex("credit_level");
      if (i != -1) {
        break label2960;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("credit_level", Long.TYPE));
      label1929:
      i = paramCursor.getColumnIndex("isTroopFollowed");
      if (i != -1) {
        break label2975;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isTroopFollowed", Boolean.TYPE));
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label3002;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distance", Integer.TYPE));
      label1999:
      i = paramCursor.getColumnIndex("msgseq");
      if (i != -1) {
        break label3017;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("msgseq", Long.TYPE));
      label2034:
      i = paramCursor.getColumnIndex("gagTimeStamp");
      if (i != -1) {
        break label3032;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gagTimeStamp", Long.TYPE));
      label2069:
      i = paramCursor.getColumnIndex("distanceToSelf");
      if (i != -1) {
        break label3047;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distanceToSelf", Double.TYPE));
      label2104:
      i = paramCursor.getColumnIndex("distanceToSelfUpdateTimeStamp");
      if (i != -1) {
        break label3062;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distanceToSelfUpdateTimeStamp", Long.TYPE));
      label2139:
      i = paramCursor.getColumnIndex("mIsShielded");
      if (i != -1) {
        break label3077;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mIsShielded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mUniqueTitle");
      if (i != -1) {
        break label3105;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mUniqueTitle", String.class));
      label2208:
      i = paramCursor.getColumnIndex("mUniqueTitleExpire");
      if (i != -1) {
        break label3120;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mUniqueTitleExpire", Integer.TYPE));
      label2243:
      i = paramCursor.getColumnIndex("tribeLevel");
      if (i != -1) {
        break label3135;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tribeLevel", Integer.TYPE));
      label2278:
      i = paramCursor.getColumnIndex("tribePoint");
      if (i != -1) {
        break label3150;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tribePoint", Integer.TYPE));
      label2313:
      i = paramCursor.getColumnIndex("commonFrdCnt");
      if (i != -1) {
        break label3165;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("commonFrdCnt", Integer.TYPE));
      label2348:
      i = paramCursor.getColumnIndex("hwIdentity");
      if (i != -1) {
        break label3180;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hwIdentity", Integer.TYPE));
      label2383:
      i = paramCursor.getColumnIndex("hwCourse");
      if (i != -1) {
        break label3195;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hwCourse", String.class));
      label2417:
      i = paramCursor.getColumnIndex("hwName");
      if (i != -1) {
        break label3210;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hwName", String.class));
      label2451:
      i = paramCursor.getColumnIndex("recommendRemark");
      if (i != -1) {
        break label3225;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("recommendRemark", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isShowQZone");
      if (i != -1) {
        break label3240;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isShowQZone", Integer.TYPE));
      return paramEntity;
      paramEntity.troopuin = paramCursor.getString(i);
      break;
      label2537:
      paramEntity.memberuin = paramCursor.getString(i);
      break label960;
      label2552:
      paramEntity.friendnick = paramCursor.getString(i);
      break label994;
      label2567:
      paramEntity.pyAll_friendnick = paramCursor.getString(i);
      break label1028;
      label2582:
      paramEntity.pyFirst_friendnick = paramCursor.getString(i);
      break label1062;
      label2597:
      paramEntity.troopnick = paramCursor.getString(i);
      break label1096;
      label2612:
      paramEntity.pyAll_troopnick = paramCursor.getString(i);
      break label1130;
      label2627:
      paramEntity.pyFirst_troopnick = paramCursor.getString(i);
      break label1164;
      label2642:
      paramEntity.autoremark = paramCursor.getString(i);
      break label1198;
      label2657:
      paramEntity.pyAll_autoremark = paramCursor.getString(i);
      break label1232;
      label2672:
      paramEntity.pyFirst_autoremark = paramCursor.getString(i);
      break label1266;
      label2687:
      paramEntity.troopremark = paramCursor.getString(i);
      break label1300;
      label2702:
      paramEntity.alias = paramCursor.getString(i);
      break label1334;
      label2717:
      paramEntity.datetime = paramCursor.getLong(i);
      break label1369;
      label2732:
      paramEntity.faceid = paramCursor.getShort(i);
      break label1404;
      label2747:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label1439;
      label2763:
      paramEntity.sex = ((byte)paramCursor.getShort(i));
      break label1474;
      label2779:
      paramEntity.status = ((byte)paramCursor.getShort(i));
      break label1509;
      label2795:
      paramEntity.qqVipInfo = paramCursor.getInt(i);
      break label1544;
      label2810:
      paramEntity.superQqInfo = paramCursor.getInt(i);
      break label1579;
      label2825:
      paramEntity.superVipInfo = paramCursor.getInt(i);
      break label1614;
      label2840:
      paramEntity.level = paramCursor.getInt(i);
      break label1649;
      label2855:
      paramEntity.realLevel = paramCursor.getInt(i);
      break label1684;
      label2870:
      paramEntity.mGlamourLevel = paramCursor.getInt(i);
      break label1719;
      label2885:
      paramEntity.hotChatGlamourLevel = paramCursor.getInt(i);
      break label1754;
      label2900:
      paramEntity.globalTroopLevel = paramCursor.getInt(i);
      break label1789;
      label2915:
      paramEntity.join_time = paramCursor.getLong(i);
      break label1824;
      label2930:
      paramEntity.last_active_time = paramCursor.getLong(i);
      break label1859;
      label2945:
      paramEntity.active_point = paramCursor.getLong(i);
      break label1894;
      label2960:
      paramEntity.credit_level = paramCursor.getLong(i);
      break label1929;
      label2975:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isTroopFollowed = paramBoolean;
        break;
      }
      label3002:
      paramEntity.distance = paramCursor.getInt(i);
      break label1999;
      label3017:
      paramEntity.msgseq = paramCursor.getLong(i);
      break label2034;
      label3032:
      paramEntity.gagTimeStamp = paramCursor.getLong(i);
      break label2069;
      label3047:
      paramEntity.distanceToSelf = paramCursor.getDouble(i);
      break label2104;
      label3062:
      paramEntity.distanceToSelfUpdateTimeStamp = paramCursor.getLong(i);
      break label2139;
      label3077:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.mIsShielded = paramBoolean;
        break;
      }
      label3105:
      paramEntity.mUniqueTitle = paramCursor.getString(i);
      break label2208;
      label3120:
      paramEntity.mUniqueTitleExpire = paramCursor.getInt(i);
      break label2243;
      label3135:
      paramEntity.tribeLevel = paramCursor.getInt(i);
      break label2278;
      label3150:
      paramEntity.tribePoint = paramCursor.getInt(i);
      break label2313;
      label3165:
      paramEntity.commonFrdCnt = paramCursor.getInt(i);
      break label2348;
      label3180:
      paramEntity.hwIdentity = paramCursor.getInt(i);
      break label2383;
      label3195:
      paramEntity.hwCourse = paramCursor.getString(i);
      break label2417;
      label3210:
      paramEntity.hwName = paramCursor.getString(i);
      break label2451;
      label3225:
      paramEntity.recommendRemark = paramCursor.getString(i);
    }
    label3240:
    paramEntity.isShowQZone = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,troopuin TEXT ,memberuin TEXT ,friendnick TEXT ,pyAll_friendnick TEXT ,pyFirst_friendnick TEXT ,troopnick TEXT ,pyAll_troopnick TEXT ,pyFirst_troopnick TEXT ,autoremark TEXT ,pyAll_autoremark TEXT ,pyFirst_autoremark TEXT ,troopremark TEXT ,alias TEXT ,datetime INTEGER ,faceid INTEGER ,age INTEGER ,sex INTEGER ,status INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,level INTEGER ,realLevel INTEGER ,mGlamourLevel INTEGER ,hotChatGlamourLevel INTEGER ,globalTroopLevel INTEGER ,join_time INTEGER ,last_active_time INTEGER ,active_point INTEGER ,credit_level INTEGER ,isTroopFollowed INTEGER ,distance INTEGER ,msgseq INTEGER ,gagTimeStamp INTEGER ,distanceToSelf REAL ,distanceToSelfUpdateTimeStamp INTEGER ,mIsShielded INTEGER ,mUniqueTitle TEXT ,mUniqueTitleExpire INTEGER ,tribeLevel INTEGER ,tribePoint INTEGER ,commonFrdCnt INTEGER ,hwIdentity INTEGER ,hwCourse TEXT ,hwName TEXT ,recommendRemark TEXT ,isShowQZone INTEGER,UNIQUE(troopuin,memberuin) ON CONFLICT IGNORE)");
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
    paramContentValues.put("isShowQZone", Integer.valueOf(paramEntity.isShowQZone));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.TroopMemberInfoDao
 * JD-Core Version:    0.7.0.1
 */