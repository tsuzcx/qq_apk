package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Friends;

public class FriendsDao
  extends OGAbstractDao
{
  public FriendsDao()
  {
    this.a = 43;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Friends)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.remark = paramCursor.getString(paramCursor.getColumnIndex("remark"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.faceid = paramCursor.getShort(paramCursor.getColumnIndex("faceid"));
      paramEntity.status = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("status")));
      paramEntity.sqqtype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqtype")));
      paramEntity.cSpecialFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSpecialFlag")));
      paramEntity.groupid = paramCursor.getInt(paramCursor.getColumnIndex("groupid"));
      paramEntity.memberLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("memberLevel")));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isMqqOnLine")))
      {
        paramBoolean = true;
        paramEntity.isMqqOnLine = paramBoolean;
        paramEntity.sqqOnLineState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("sqqOnLineState")));
        paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("detalStatusFlag")));
        paramEntity.datetime = paramCursor.getLong(paramCursor.getColumnIndex("datetime"));
        paramEntity.alias = paramCursor.getString(paramCursor.getColumnIndex("alias"));
        paramEntity.gathtertype = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gathtertype")));
        paramEntity.smartRemark = paramCursor.getString(paramCursor.getColumnIndex("smartRemark"));
        paramEntity.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
        paramEntity.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
        paramEntity.recommReason = paramCursor.getString(paramCursor.getColumnIndex("recommReason"));
        paramEntity.signature = paramCursor.getString(paramCursor.getColumnIndex("signature"));
        paramEntity.isIphoneOnline = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isIphoneOnline")));
        paramEntity.isRemark = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isRemark")));
        paramEntity.iTermType = paramCursor.getInt(paramCursor.getColumnIndex("iTermType"));
        paramEntity.qqVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("qqVipInfo"));
        paramEntity.superQqInfo = paramCursor.getInt(paramCursor.getColumnIndex("superQqInfo"));
        paramEntity.superVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("superVipInfo"));
        paramEntity.hollywoodVipInfo = paramCursor.getInt(paramCursor.getColumnIndex("hollywoodVipInfo"));
        paramEntity.lastLoginType = paramCursor.getLong(paramCursor.getColumnIndex("lastLoginType"));
        paramEntity.showLoginClient = paramCursor.getLong(paramCursor.getColumnIndex("showLoginClient"));
        paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
        paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
        paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramEntity.cNetwork = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cNetwork")));
        paramEntity.eNetwork = paramCursor.getInt(paramCursor.getColumnIndex("eNetwork"));
        paramEntity.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramEntity.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label823;
        }
      }
      label823:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramEntity.strMasterUin = paramCursor.getString(paramCursor.getColumnIndex("strMasterUin"));
        paramEntity.multiFlags = paramCursor.getInt(paramCursor.getColumnIndex("multiFlags"));
        paramEntity.friendType = paramCursor.getInt(paramCursor.getColumnIndex("friendType"));
        paramEntity.abilityBits = paramCursor.getLong(paramCursor.getColumnIndex("abilityBits"));
        return paramEntity;
        paramBoolean = false;
        break;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("remark");
      if (i != -1) {
        break label2340;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("remark", String.class));
      label896:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label2355;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("name", String.class));
      label930:
      i = paramCursor.getColumnIndex("faceid");
      if (i != -1) {
        break label2370;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceid", Short.TYPE));
      label965:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label2385;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("status", Byte.TYPE));
      label1000:
      i = paramCursor.getColumnIndex("sqqtype");
      if (i != -1) {
        break label2401;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sqqtype", Byte.TYPE));
      label1035:
      i = paramCursor.getColumnIndex("cSpecialFlag");
      if (i != -1) {
        break label2417;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cSpecialFlag", Byte.TYPE));
      label1070:
      i = paramCursor.getColumnIndex("groupid");
      if (i != -1) {
        break label2433;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("groupid", Integer.TYPE));
      label1105:
      i = paramCursor.getColumnIndex("memberLevel");
      if (i != -1) {
        break label2448;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memberLevel", Byte.TYPE));
      label1140:
      i = paramCursor.getColumnIndex("isMqqOnLine");
      if (i != -1) {
        break label2464;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isMqqOnLine", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sqqOnLineState");
      if (i != -1) {
        break label2491;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sqqOnLineState", Byte.TYPE));
      label1210:
      i = paramCursor.getColumnIndex("detalStatusFlag");
      if (i != -1) {
        break label2507;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("detalStatusFlag", Byte.TYPE));
      label1245:
      i = paramCursor.getColumnIndex("datetime");
      if (i != -1) {
        break label2523;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("datetime", Long.TYPE));
      label1280:
      i = paramCursor.getColumnIndex("alias");
      if (i != -1) {
        break label2538;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("alias", String.class));
      label1314:
      i = paramCursor.getColumnIndex("gathtertype");
      if (i != -1) {
        break label2553;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gathtertype", Byte.TYPE));
      label1349:
      i = paramCursor.getColumnIndex("smartRemark");
      if (i != -1) {
        break label2569;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("smartRemark", String.class));
      label1383:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label2584;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Integer.TYPE));
      label1418:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label2599;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gender", Byte.TYPE));
      label1453:
      i = paramCursor.getColumnIndex("recommReason");
      if (i != -1) {
        break label2615;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("recommReason", String.class));
      label1487:
      i = paramCursor.getColumnIndex("signature");
      if (i != -1) {
        break label2630;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("signature", String.class));
      label1521:
      i = paramCursor.getColumnIndex("isIphoneOnline");
      if (i != -1) {
        break label2645;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isIphoneOnline", Byte.TYPE));
      label1556:
      i = paramCursor.getColumnIndex("isRemark");
      if (i != -1) {
        break label2661;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isRemark", Byte.TYPE));
      label1591:
      i = paramCursor.getColumnIndex("iTermType");
      if (i != -1) {
        break label2677;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iTermType", Integer.TYPE));
      label1626:
      i = paramCursor.getColumnIndex("qqVipInfo");
      if (i != -1) {
        break label2692;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qqVipInfo", Integer.TYPE));
      label1661:
      i = paramCursor.getColumnIndex("superQqInfo");
      if (i != -1) {
        break label2707;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superQqInfo", Integer.TYPE));
      label1696:
      i = paramCursor.getColumnIndex("superVipInfo");
      if (i != -1) {
        break label2722;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("superVipInfo", Integer.TYPE));
      label1731:
      i = paramCursor.getColumnIndex("hollywoodVipInfo");
      if (i != -1) {
        break label2737;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hollywoodVipInfo", Integer.TYPE));
      label1766:
      i = paramCursor.getColumnIndex("lastLoginType");
      if (i != -1) {
        break label2752;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastLoginType", Long.TYPE));
      label1801:
      i = paramCursor.getColumnIndex("showLoginClient");
      if (i != -1) {
        break label2767;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showLoginClient", Long.TYPE));
      label1836:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label2782;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richTime", Long.TYPE));
      label1871:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label2797;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richBuffer", [B.class));
      label1905:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label2812;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label1940:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label2827;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mCompareSpell", String.class));
      label1974:
      i = paramCursor.getColumnIndex("cNetwork");
      if (i != -1) {
        break label2842;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cNetwork", Byte.TYPE));
      label2009:
      i = paramCursor.getColumnIndex("eNetwork");
      if (i != -1) {
        break label2858;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("eNetwork", Integer.TYPE));
      label2044:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label2873;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label2079:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label2888;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label2114:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label2903;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label2149:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label2918;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("strMasterUin");
      if (i != -1) {
        break label2946;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strMasterUin", String.class));
      label2218:
      i = paramCursor.getColumnIndex("multiFlags");
      if (i != -1) {
        break label2961;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("multiFlags", Integer.TYPE));
      label2253:
      i = paramCursor.getColumnIndex("friendType");
      if (i != -1) {
        break label2976;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("friendType", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("abilityBits");
      if (i != -1) {
        break label2991;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("abilityBits", Long.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label2340:
      paramEntity.remark = paramCursor.getString(i);
      break label896;
      label2355:
      paramEntity.name = paramCursor.getString(i);
      break label930;
      label2370:
      paramEntity.faceid = paramCursor.getShort(i);
      break label965;
      label2385:
      paramEntity.status = ((byte)paramCursor.getShort(i));
      break label1000;
      label2401:
      paramEntity.sqqtype = ((byte)paramCursor.getShort(i));
      break label1035;
      label2417:
      paramEntity.cSpecialFlag = ((byte)paramCursor.getShort(i));
      break label1070;
      label2433:
      paramEntity.groupid = paramCursor.getInt(i);
      break label1105;
      label2448:
      paramEntity.memberLevel = ((byte)paramCursor.getShort(i));
      break label1140;
      label2464:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isMqqOnLine = paramBoolean;
        break;
      }
      label2491:
      paramEntity.sqqOnLineState = ((byte)paramCursor.getShort(i));
      break label1210;
      label2507:
      paramEntity.detalStatusFlag = ((byte)paramCursor.getShort(i));
      break label1245;
      label2523:
      paramEntity.datetime = paramCursor.getLong(i);
      break label1280;
      label2538:
      paramEntity.alias = paramCursor.getString(i);
      break label1314;
      label2553:
      paramEntity.gathtertype = ((byte)paramCursor.getShort(i));
      break label1349;
      label2569:
      paramEntity.smartRemark = paramCursor.getString(i);
      break label1383;
      label2584:
      paramEntity.age = paramCursor.getInt(i);
      break label1418;
      label2599:
      paramEntity.gender = ((byte)paramCursor.getShort(i));
      break label1453;
      label2615:
      paramEntity.recommReason = paramCursor.getString(i);
      break label1487;
      label2630:
      paramEntity.signature = paramCursor.getString(i);
      break label1521;
      label2645:
      paramEntity.isIphoneOnline = ((byte)paramCursor.getShort(i));
      break label1556;
      label2661:
      paramEntity.isRemark = ((byte)paramCursor.getShort(i));
      break label1591;
      label2677:
      paramEntity.iTermType = paramCursor.getInt(i);
      break label1626;
      label2692:
      paramEntity.qqVipInfo = paramCursor.getInt(i);
      break label1661;
      label2707:
      paramEntity.superQqInfo = paramCursor.getInt(i);
      break label1696;
      label2722:
      paramEntity.superVipInfo = paramCursor.getInt(i);
      break label1731;
      label2737:
      paramEntity.hollywoodVipInfo = paramCursor.getInt(i);
      break label1766;
      label2752:
      paramEntity.lastLoginType = paramCursor.getLong(i);
      break label1801;
      label2767:
      paramEntity.showLoginClient = paramCursor.getLong(i);
      break label1836;
      label2782:
      paramEntity.richTime = paramCursor.getLong(i);
      break label1871;
      label2797:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label1905;
      label2812:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label1940;
      label2827:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label1974;
      label2842:
      paramEntity.cNetwork = ((byte)paramCursor.getShort(i));
      break label2009;
      label2858:
      paramEntity.eNetwork = paramCursor.getInt(i);
      break label2044;
      label2873:
      paramEntity.namePlateOfKingGameId = paramCursor.getLong(i);
      break label2079;
      label2888:
      paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label2114;
      label2903:
      paramEntity.namePlateOfKingDan = paramCursor.getInt(i);
      break label2149;
      label2918:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label2946:
      paramEntity.strMasterUin = paramCursor.getString(i);
      break label2218;
      label2961:
      paramEntity.multiFlags = paramCursor.getInt(i);
      break label2253;
      label2976:
      paramEntity.friendType = paramCursor.getInt(i);
    }
    label2991:
    paramEntity.abilityBits = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,remark TEXT ,name TEXT ,faceid INTEGER ,status INTEGER ,sqqtype INTEGER ,cSpecialFlag INTEGER ,groupid INTEGER ,memberLevel INTEGER ,isMqqOnLine INTEGER ,sqqOnLineState INTEGER ,detalStatusFlag INTEGER ,datetime INTEGER ,alias TEXT ,gathtertype INTEGER ,smartRemark TEXT ,age INTEGER ,gender INTEGER ,recommReason TEXT ,signature TEXT ,isIphoneOnline INTEGER ,isRemark INTEGER ,iTermType INTEGER ,qqVipInfo INTEGER ,superQqInfo INTEGER ,superVipInfo INTEGER ,hollywoodVipInfo INTEGER ,lastLoginType INTEGER ,showLoginClient INTEGER ,richTime INTEGER ,richBuffer BLOB ,mComparePartInt INTEGER ,mCompareSpell TEXT ,cNetwork INTEGER ,eNetwork INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,strMasterUin TEXT ,multiFlags INTEGER ,friendType INTEGER ,abilityBits INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Friends)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("remark", paramEntity.remark);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("faceid", Short.valueOf(paramEntity.faceid));
    paramContentValues.put("status", Byte.valueOf(paramEntity.status));
    paramContentValues.put("sqqtype", Byte.valueOf(paramEntity.sqqtype));
    paramContentValues.put("cSpecialFlag", Byte.valueOf(paramEntity.cSpecialFlag));
    paramContentValues.put("groupid", Integer.valueOf(paramEntity.groupid));
    paramContentValues.put("memberLevel", Byte.valueOf(paramEntity.memberLevel));
    paramContentValues.put("isMqqOnLine", Boolean.valueOf(paramEntity.isMqqOnLine));
    paramContentValues.put("sqqOnLineState", Byte.valueOf(paramEntity.sqqOnLineState));
    paramContentValues.put("detalStatusFlag", Byte.valueOf(paramEntity.detalStatusFlag));
    paramContentValues.put("datetime", Long.valueOf(paramEntity.datetime));
    paramContentValues.put("alias", paramEntity.alias);
    paramContentValues.put("gathtertype", Byte.valueOf(paramEntity.gathtertype));
    paramContentValues.put("smartRemark", paramEntity.smartRemark);
    paramContentValues.put("age", Integer.valueOf(paramEntity.age));
    paramContentValues.put("gender", Byte.valueOf(paramEntity.gender));
    paramContentValues.put("recommReason", paramEntity.recommReason);
    paramContentValues.put("signature", paramEntity.signature);
    paramContentValues.put("isIphoneOnline", Byte.valueOf(paramEntity.isIphoneOnline));
    paramContentValues.put("isRemark", Byte.valueOf(paramEntity.isRemark));
    paramContentValues.put("iTermType", Integer.valueOf(paramEntity.iTermType));
    paramContentValues.put("qqVipInfo", Integer.valueOf(paramEntity.qqVipInfo));
    paramContentValues.put("superQqInfo", Integer.valueOf(paramEntity.superQqInfo));
    paramContentValues.put("superVipInfo", Integer.valueOf(paramEntity.superVipInfo));
    paramContentValues.put("hollywoodVipInfo", Integer.valueOf(paramEntity.hollywoodVipInfo));
    paramContentValues.put("lastLoginType", Long.valueOf(paramEntity.lastLoginType));
    paramContentValues.put("showLoginClient", Long.valueOf(paramEntity.showLoginClient));
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("cNetwork", Byte.valueOf(paramEntity.cNetwork));
    paramContentValues.put("eNetwork", Integer.valueOf(paramEntity.eNetwork));
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramEntity.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramEntity.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramEntity.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramEntity.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("strMasterUin", paramEntity.strMasterUin);
    paramContentValues.put("multiFlags", Integer.valueOf(paramEntity.multiFlags));
    paramContentValues.put("friendType", Integer.valueOf(paramEntity.friendType));
    paramContentValues.put("abilityBits", Long.valueOf(paramEntity.abilityBits));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.FriendsDao
 * JD-Core Version:    0.7.0.1
 */