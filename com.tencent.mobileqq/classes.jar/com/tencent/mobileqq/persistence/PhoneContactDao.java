package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.PhoneContact;

public class PhoneContactDao
  extends OGAbstractDao
{
  public PhoneContactDao()
  {
    this.a = 35;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (PhoneContact)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.mobileNo = paramCursor.getString(paramCursor.getColumnIndex("mobileNo"));
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.bindingDate = paramCursor.getLong(paramCursor.getColumnIndex("bindingDate"));
      paramEntity.isRecommend = paramCursor.getInt(paramCursor.getColumnIndex("isRecommend"));
      paramEntity.nationCode = paramCursor.getString(paramCursor.getColumnIndex("nationCode"));
      paramEntity.mobileCode = paramCursor.getString(paramCursor.getColumnIndex("mobileCode"));
      paramEntity.unifiedCode = paramCursor.getString(paramCursor.getColumnIndex("unifiedCode"));
      paramEntity.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
      paramEntity.originBinder = paramCursor.getLong(paramCursor.getColumnIndex("originBinder"));
      paramEntity.ability = paramCursor.getInt(paramCursor.getColumnIndex("ability"));
      paramEntity.contactID = paramCursor.getInt(paramCursor.getColumnIndex("contactID"));
      paramEntity.faceUrl = paramCursor.getString(paramCursor.getColumnIndex("faceUrl"));
      paramEntity.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramEntity.pinyinAll = paramCursor.getString(paramCursor.getColumnIndex("pinyinAll"));
      paramEntity.pinyinInitial = paramCursor.getString(paramCursor.getColumnIndex("pinyinInitial"));
      paramEntity.lastScanTime = paramCursor.getLong(paramCursor.getColumnIndex("lastScanTime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isUploaded")))
      {
        paramBoolean = true;
        paramEntity.isUploaded = paramBoolean;
        paramEntity.sortWeight = paramCursor.getInt(paramCursor.getColumnIndex("sortWeight"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSendAddReq"))) {
          break label683;
        }
        paramBoolean = true;
        label385:
        paramEntity.hasSendAddReq = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewRecommend"))) {
          break label688;
        }
        paramBoolean = true;
        label410:
        paramEntity.isNewRecommend = paramBoolean;
        paramEntity.highLightTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("highLightTimeStamp"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isHiden"))) {
          break label693;
        }
      }
      label683:
      label688:
      label693:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isHiden = paramBoolean;
        paramEntity.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
        paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
        paramEntity.label = paramCursor.getString(paramCursor.getColumnIndex("label"));
        paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramEntity.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramEntity.eNetworkType = paramCursor.getInt(paramCursor.getColumnIndex("eNetworkType"));
        paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramEntity.sex = paramCursor.getInt(paramCursor.getColumnIndex("sex"));
        paramEntity.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramEntity.samFriend = paramCursor.getInt(paramCursor.getColumnIndex("samFriend"));
        paramEntity.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label385;
        paramBoolean = false;
        break label410;
      }
    }
    int i = paramCursor.getColumnIndex("mobileNo");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("mobileNo", String.class));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label1926;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      label766:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1941;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("name", String.class));
      label800:
      i = paramCursor.getColumnIndex("bindingDate");
      if (i != -1) {
        break label1956;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bindingDate", Long.TYPE));
      label835:
      i = paramCursor.getColumnIndex("isRecommend");
      if (i != -1) {
        break label1971;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isRecommend", Integer.TYPE));
      label870:
      i = paramCursor.getColumnIndex("nationCode");
      if (i != -1) {
        break label1986;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nationCode", String.class));
      label904:
      i = paramCursor.getColumnIndex("mobileCode");
      if (i != -1) {
        break label2001;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mobileCode", String.class));
      label938:
      i = paramCursor.getColumnIndex("unifiedCode");
      if (i != -1) {
        break label2016;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("unifiedCode", String.class));
      label972:
      i = paramCursor.getColumnIndex("nickName");
      if (i != -1) {
        break label2031;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nickName", String.class));
      label1006:
      i = paramCursor.getColumnIndex("originBinder");
      if (i != -1) {
        break label2046;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("originBinder", Long.TYPE));
      label1041:
      i = paramCursor.getColumnIndex("ability");
      if (i != -1) {
        break label2061;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ability", Integer.TYPE));
      label1076:
      i = paramCursor.getColumnIndex("contactID");
      if (i != -1) {
        break label2076;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("contactID", Integer.TYPE));
      label1111:
      i = paramCursor.getColumnIndex("faceUrl");
      if (i != -1) {
        break label2091;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceUrl", String.class));
      label1145:
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label2106;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("remark", String.class));
      label1179:
      i = paramCursor.getColumnIndex("pinyinAll");
      if (i != -1) {
        break label2121;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pinyinAll", String.class));
      label1213:
      i = paramCursor.getColumnIndex("pinyinInitial");
      if (i != -1) {
        break label2136;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pinyinInitial", String.class));
      label1247:
      i = paramCursor.getColumnIndex("lastScanTime");
      if (i != -1) {
        break label2151;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastScanTime", Long.TYPE));
      label1282:
      i = paramCursor.getColumnIndex("isUploaded");
      if (i != -1) {
        break label2166;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isUploaded", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sortWeight");
      if (i != -1) {
        break label2193;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sortWeight", Integer.TYPE));
      label1352:
      i = paramCursor.getColumnIndex("hasSendAddReq");
      if (i != -1) {
        break label2208;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasSendAddReq", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isNewRecommend");
      if (i != -1) {
        break label2235;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isNewRecommend", Boolean.TYPE));
      i = paramCursor.getColumnIndex("highLightTimeStamp");
      if (i != -1) {
        break label2262;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("highLightTimeStamp", Long.TYPE));
      label1457:
      i = paramCursor.getColumnIndex("isHiden");
      if (i != -1) {
        break label2277;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isHiden", Boolean.TYPE));
      i = paramCursor.getColumnIndex("md5");
      if (i != -1) {
        break label2305;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("md5", String.class));
      label1526:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label2320;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("type", Integer.TYPE));
      label1561:
      i = paramCursor.getColumnIndex("label");
      if (i != -1) {
        break label2335;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("label", String.class));
      label1595:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label2350;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1630:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label2366;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iTermType", Integer.TYPE));
      label1665:
      i = paramCursor.getColumnIndex("eNetworkType");
      if (i != -1) {
        break label2381;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("eNetworkType", Integer.TYPE));
      label1700:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label2396;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richTime", Long.TYPE));
      label1735:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label2411;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richBuffer", [B.class));
      label1769:
      i = paramCursor.getColumnIndex("sex");
      if (i != -1) {
        break label2426;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sex", Integer.TYPE));
      label1804:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2441;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Integer.TYPE));
      label1839:
      i = paramCursor.getColumnIndex("samFriend");
      if (i != -1) {
        break label2456;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("samFriend", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label2471;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("abilityBits", Long.TYPE));
      return paramEntity;
      paramEntity.mobileNo = paramCursor.getString(i);
      break;
      label1926:
      paramEntity.uin = paramCursor.getString(i);
      break label766;
      label1941:
      paramEntity.name = paramCursor.getString(i);
      break label800;
      label1956:
      paramEntity.bindingDate = paramCursor.getLong(i);
      break label835;
      label1971:
      paramEntity.isRecommend = paramCursor.getInt(i);
      break label870;
      label1986:
      paramEntity.nationCode = paramCursor.getString(i);
      break label904;
      label2001:
      paramEntity.mobileCode = paramCursor.getString(i);
      break label938;
      label2016:
      paramEntity.unifiedCode = paramCursor.getString(i);
      break label972;
      label2031:
      paramEntity.nickName = paramCursor.getString(i);
      break label1006;
      label2046:
      paramEntity.originBinder = paramCursor.getLong(i);
      break label1041;
      label2061:
      paramEntity.ability = paramCursor.getInt(i);
      break label1076;
      label2076:
      paramEntity.contactID = paramCursor.getInt(i);
      break label1111;
      label2091:
      paramEntity.faceUrl = paramCursor.getString(i);
      break label1145;
      label2106:
      paramEntity.remark = paramCursor.getString(i);
      break label1179;
      label2121:
      paramEntity.pinyinAll = paramCursor.getString(i);
      break label1213;
      label2136:
      paramEntity.pinyinInitial = paramCursor.getString(i);
      break label1247;
      label2151:
      paramEntity.lastScanTime = paramCursor.getLong(i);
      break label1282;
      label2166:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isUploaded = paramBoolean;
        break;
      }
      label2193:
      paramEntity.sortWeight = paramCursor.getInt(i);
      break label1352;
      label2208:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSendAddReq = paramBoolean;
        break;
      }
      label2235:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isNewRecommend = paramBoolean;
        break;
      }
      label2262:
      paramEntity.highLightTimeStamp = paramCursor.getLong(i);
      break label1457;
      label2277:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isHiden = paramBoolean;
        break;
      }
      label2305:
      paramEntity.md5 = paramCursor.getString(i);
      break label1526;
      label2320:
      paramEntity.type = paramCursor.getInt(i);
      break label1561;
      label2335:
      paramEntity.label = paramCursor.getString(i);
      break label1595;
      label2350:
      paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1630;
      label2366:
      paramEntity.iTermType = paramCursor.getInt(i);
      break label1665;
      label2381:
      paramEntity.eNetworkType = paramCursor.getInt(i);
      break label1700;
      label2396:
      paramEntity.richTime = paramCursor.getLong(i);
      break label1735;
      label2411:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label1769;
      label2426:
      paramEntity.sex = paramCursor.getInt(i);
      break label1804;
      label2441:
      paramEntity.age = paramCursor.getInt(i);
      break label1839;
      label2456:
      paramEntity.samFriend = paramCursor.getInt(i);
    }
    label2471:
    paramEntity.abilityBits = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,mobileNo TEXT UNIQUE ,uin TEXT ,name TEXT ,bindingDate INTEGER ,isRecommend INTEGER ,nationCode TEXT ,mobileCode TEXT ,unifiedCode TEXT ,nickName TEXT ,originBinder INTEGER ,ability INTEGER ,contactID INTEGER ,faceUrl TEXT ,remark TEXT ,pinyinAll TEXT ,pinyinInitial TEXT ,lastScanTime INTEGER ,isUploaded INTEGER ,sortWeight INTEGER ,hasSendAddReq INTEGER ,isNewRecommend INTEGER ,highLightTimeStamp INTEGER ,isHiden INTEGER ,md5 TEXT ,type INTEGER ,label TEXT ,detalStatusFlag INTEGER ,iTermType INTEGER ,eNetworkType INTEGER ,richTime INTEGER ,richBuffer BLOB ,sex INTEGER ,age INTEGER ,samFriend INTEGER ,abilityBits INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (PhoneContact)paramEntity;
    paramContentValues.put("mobileNo", paramEntity.mobileNo);
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("bindingDate", Long.valueOf(paramEntity.bindingDate));
    paramContentValues.put("isRecommend", Integer.valueOf(paramEntity.isRecommend));
    paramContentValues.put("nationCode", paramEntity.nationCode);
    paramContentValues.put("mobileCode", paramEntity.mobileCode);
    paramContentValues.put("unifiedCode", paramEntity.unifiedCode);
    paramContentValues.put("nickName", paramEntity.nickName);
    paramContentValues.put("originBinder", Long.valueOf(paramEntity.originBinder));
    paramContentValues.put("ability", Integer.valueOf(paramEntity.ability));
    paramContentValues.put("contactID", Integer.valueOf(paramEntity.contactID));
    paramContentValues.put("faceUrl", paramEntity.faceUrl);
    paramContentValues.put("remark", paramEntity.remark);
    paramContentValues.put("pinyinAll", paramEntity.pinyinAll);
    paramContentValues.put("pinyinInitial", paramEntity.pinyinInitial);
    paramContentValues.put("lastScanTime", Long.valueOf(paramEntity.lastScanTime));
    paramContentValues.put("isUploaded", Boolean.valueOf(paramEntity.isUploaded));
    paramContentValues.put("sortWeight", Integer.valueOf(paramEntity.sortWeight));
    paramContentValues.put("hasSendAddReq", Boolean.valueOf(paramEntity.hasSendAddReq));
    paramContentValues.put("isNewRecommend", Boolean.valueOf(paramEntity.isNewRecommend));
    paramContentValues.put("highLightTimeStamp", Long.valueOf(paramEntity.highLightTimeStamp));
    paramContentValues.put("isHiden", Boolean.valueOf(paramEntity.isHiden));
    paramContentValues.put("md5", paramEntity.md5);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("label", paramEntity.label);
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramEntity.detalStatusFlag));
    paramContentValues.put("iTermType", Integer.valueOf(paramEntity.iTermType));
    paramContentValues.put("eNetworkType", Integer.valueOf(paramEntity.eNetworkType));
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("sex", Integer.valueOf(paramEntity.sex));
    paramContentValues.put("age", Integer.valueOf(paramEntity.age));
    paramContentValues.put("samFriend", Integer.valueOf(paramEntity.samFriend));
    paramContentValues.put("abilityBits", Long.valueOf(paramEntity.abilityBits));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.PhoneContactDao
 * JD-Core Version:    0.7.0.1
 */