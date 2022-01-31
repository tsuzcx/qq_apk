package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonPackage;

public class EmoticonPackageDao
  extends OGAbstractDao
{
  public EmoticonPackageDao()
  {
    this.a = 54;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (EmoticonPackage)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramEntity.wordingId = paramCursor.getLong(paramCursor.getColumnIndex("wordingId"));
      paramEntity.childEpId = paramCursor.getString(paramCursor.getColumnIndex("childEpId"));
      paramEntity.minQQVersion = paramCursor.getString(paramCursor.getColumnIndex("minQQVersion"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.mark = paramCursor.getString(paramCursor.getColumnIndex("mark"));
      paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramEntity.author = paramCursor.getString(paramCursor.getColumnIndex("author"));
      paramEntity.expiretime = paramCursor.getLong(paramCursor.getColumnIndex("expiretime"));
      paramEntity.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasSound")))
      {
        paramBoolean = true;
        paramEntity.hasSound = paramBoolean;
        paramEntity.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramEntity.kinId = paramCursor.getString(paramCursor.getColumnIndex("kinId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("valid"))) {
          break label1052;
        }
        paramBoolean = true;
        label277:
        paramEntity.valid = paramBoolean;
        paramEntity.downloadCount = paramCursor.getInt(paramCursor.getColumnIndex("downloadCount"));
        paramEntity.mobileFeetype = paramCursor.getInt(paramCursor.getColumnIndex("mobileFeetype"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecommendation"))) {
          break label1057;
        }
        paramBoolean = true;
        label338:
        paramEntity.isRecommendation = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isMagicFaceDownloading"))) {
          break label1062;
        }
        paramBoolean = true;
        label363:
        paramEntity.isMagicFaceDownloading = paramBoolean;
        paramEntity.firstEmotionId = paramCursor.getString(paramCursor.getColumnIndex("firstEmotionId"));
        paramEntity.upperLeftLable = paramCursor.getInt(paramCursor.getColumnIndex("upperLeftLable"));
        paramEntity.localVersion = paramCursor.getInt(paramCursor.getColumnIndex("localVersion"));
        paramEntity.latestVersion = paramCursor.getInt(paramCursor.getColumnIndex("latestVersion"));
        paramEntity.jsonVersion = paramCursor.getInt(paramCursor.getColumnIndex("jsonVersion"));
        paramEntity.updateFlag = paramCursor.getInt(paramCursor.getColumnIndex("updateFlag"));
        paramEntity.updateTip = paramCursor.getString(paramCursor.getColumnIndex("updateTip"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasReadUpdatePage"))) {
          break label1067;
        }
        paramBoolean = true;
        label514:
        paramEntity.hasReadUpdatePage = paramBoolean;
        paramEntity.rscType = paramCursor.getInt(paramCursor.getColumnIndex("rscType"));
        paramEntity.supportSize = paramCursor.getString(paramCursor.getColumnIndex("supportSize"));
        paramEntity.extraFlags = paramCursor.getInt(paramCursor.getColumnIndex("extraFlags"));
        paramEntity.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        paramEntity.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramEntity.isAPNG = paramCursor.getInt(paramCursor.getColumnIndex("isAPNG"));
        paramEntity.copywritingType = paramCursor.getInt(paramCursor.getColumnIndex("copywritingType"));
        paramEntity.diversionName = paramCursor.getString(paramCursor.getColumnIndex("diversionName"));
        paramEntity.copywritingContent = paramCursor.getString(paramCursor.getColumnIndex("copywritingContent"));
        paramEntity.jumpUrl = paramCursor.getString(paramCursor.getColumnIndex("jumpUrl"));
        paramEntity.imageUrl = paramCursor.getString(paramCursor.getColumnIndex("imageUrl"));
        paramEntity.beginTime = paramCursor.getLong(paramCursor.getColumnIndex("beginTime"));
        paramEntity.endTime = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
        paramEntity.buttonWording = paramCursor.getString(paramCursor.getColumnIndex("buttonWording"));
        paramEntity.comeFom = paramCursor.getString(paramCursor.getColumnIndex("comeFom"));
        paramEntity.ipUrl = paramCursor.getString(paramCursor.getColumnIndex("ipUrl"));
        paramEntity.ipName = paramCursor.getString(paramCursor.getColumnIndex("ipName"));
        paramEntity.ipDetail = paramCursor.getString(paramCursor.getColumnIndex("ipDetail"));
        paramEntity.ipOpName = paramCursor.getString(paramCursor.getColumnIndex("ipOpName"));
        paramEntity.ipJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("ipJumpUrl"));
        paramEntity.ipReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipReqTime"));
        paramEntity.ipLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("aio"))) {
          break label1072;
        }
        paramBoolean = true;
        label935:
        paramEntity.aio = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandian"))) {
          break label1077;
        }
        paramBoolean = true;
        label960:
        paramEntity.kandian = paramBoolean;
        paramEntity.richIPReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPReqTime"));
        paramEntity.richIPLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasIpProduct"))) {
          break label1082;
        }
      }
      label1052:
      label1057:
      label1062:
      label1067:
      label1072:
      label1077:
      label1082:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.hasIpProduct = paramBoolean;
        paramEntity.ipSiteInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("ipSiteInfoBytes"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label277;
        paramBoolean = false;
        break label338;
        paramBoolean = false;
        break label363;
        paramBoolean = false;
        break label514;
        paramBoolean = false;
        break label935;
        paramBoolean = false;
        break label960;
      }
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("epId", String.class));
      i = paramCursor.getColumnIndex("wordingId");
      if (i != -1) {
        break label2994;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wordingId", Long.TYPE));
      label1157:
      i = paramCursor.getColumnIndex("childEpId");
      if (i != -1) {
        break label3009;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("childEpId", String.class));
      label1192:
      i = paramCursor.getColumnIndex("minQQVersion");
      if (i != -1) {
        break label3024;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("minQQVersion", String.class));
      label1227:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3039;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("name", String.class));
      label1262:
      i = paramCursor.getColumnIndex("mark");
      if (i != -1) {
        break label3054;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mark", String.class));
      label1297:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label3069;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("type", Integer.TYPE));
      label1332:
      i = paramCursor.getColumnIndex("author");
      if (i != -1) {
        break label3084;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("author", String.class));
      label1367:
      i = paramCursor.getColumnIndex("expiretime");
      if (i != -1) {
        break label3099;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("expiretime", Long.TYPE));
      label1402:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3114;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("status", Integer.TYPE));
      label1437:
      i = paramCursor.getColumnIndex("hasSound");
      if (i != -1) {
        break label3129;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label3156;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("jobType", Integer.TYPE));
      label1507:
      i = paramCursor.getColumnIndex("kinId");
      if (i != -1) {
        break label3171;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("kinId", String.class));
      label1542:
      i = paramCursor.getColumnIndex("valid");
      if (i != -1) {
        break label3186;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("valid", Boolean.TYPE));
      i = paramCursor.getColumnIndex("downloadCount");
      if (i != -1) {
        break label3213;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("downloadCount", Integer.TYPE));
      label1612:
      i = paramCursor.getColumnIndex("mobileFeetype");
      if (i != -1) {
        break label3228;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mobileFeetype", Integer.TYPE));
      label1647:
      i = paramCursor.getColumnIndex("isRecommendation");
      if (i != -1) {
        break label3243;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isRecommendation", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isMagicFaceDownloading");
      if (i != -1) {
        break label3270;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isMagicFaceDownloading", Boolean.TYPE));
      i = paramCursor.getColumnIndex("firstEmotionId");
      if (i != -1) {
        break label3297;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("firstEmotionId", String.class));
      label1752:
      i = paramCursor.getColumnIndex("upperLeftLable");
      if (i != -1) {
        break label3312;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("upperLeftLable", Integer.TYPE));
      label1787:
      i = paramCursor.getColumnIndex("localVersion");
      if (i != -1) {
        break label3327;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("localVersion", Integer.TYPE));
      label1822:
      i = paramCursor.getColumnIndex("latestVersion");
      if (i != -1) {
        break label3342;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("latestVersion", Integer.TYPE));
      label1857:
      i = paramCursor.getColumnIndex("jsonVersion");
      if (i != -1) {
        break label3357;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("jsonVersion", Integer.TYPE));
      label1892:
      i = paramCursor.getColumnIndex("updateFlag");
      if (i != -1) {
        break label3372;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("updateFlag", Integer.TYPE));
      label1927:
      i = paramCursor.getColumnIndex("updateTip");
      if (i != -1) {
        break label3387;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("updateTip", String.class));
      label1962:
      i = paramCursor.getColumnIndex("hasReadUpdatePage");
      if (i != -1) {
        break label3402;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasReadUpdatePage", Boolean.TYPE));
      i = paramCursor.getColumnIndex("rscType");
      if (i != -1) {
        break label3429;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("rscType", Integer.TYPE));
      label2032:
      i = paramCursor.getColumnIndex("supportSize");
      if (i != -1) {
        break label3444;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("supportSize", String.class));
      label2067:
      i = paramCursor.getColumnIndex("extraFlags");
      if (i != -1) {
        break label3459;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extraFlags", Integer.TYPE));
      label2102:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label3474;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("businessExtra", String.class));
      label2137:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label3489;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("subType", Integer.TYPE));
      label2172:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label3504;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isAPNG", Integer.TYPE));
      label2207:
      i = paramCursor.getColumnIndex("copywritingType");
      if (i != -1) {
        break label3519;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("copywritingType", Integer.TYPE));
      label2242:
      i = paramCursor.getColumnIndex("diversionName");
      if (i != -1) {
        break label3534;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diversionName", String.class));
      label2277:
      i = paramCursor.getColumnIndex("copywritingContent");
      if (i != -1) {
        break label3549;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("copywritingContent", String.class));
      label2312:
      i = paramCursor.getColumnIndex("jumpUrl");
      if (i != -1) {
        break label3564;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("jumpUrl", String.class));
      label2347:
      i = paramCursor.getColumnIndex("imageUrl");
      if (i != -1) {
        break label3579;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("imageUrl", String.class));
      label2382:
      i = paramCursor.getColumnIndex("beginTime");
      if (i != -1) {
        break label3594;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("beginTime", Long.TYPE));
      label2417:
      i = paramCursor.getColumnIndex("endTime");
      if (i != -1) {
        break label3609;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("endTime", Long.TYPE));
      label2452:
      i = paramCursor.getColumnIndex("buttonWording");
      if (i != -1) {
        break label3624;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("buttonWording", String.class));
      label2487:
      i = paramCursor.getColumnIndex("comeFom");
      if (i != -1) {
        break label3639;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("comeFom", String.class));
      label2522:
      i = paramCursor.getColumnIndex("ipUrl");
      if (i != -1) {
        break label3654;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipUrl", String.class));
      label2557:
      i = paramCursor.getColumnIndex("ipName");
      if (i != -1) {
        break label3669;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipName", String.class));
      label2592:
      i = paramCursor.getColumnIndex("ipDetail");
      if (i != -1) {
        break label3684;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipDetail", String.class));
      label2627:
      i = paramCursor.getColumnIndex("ipOpName");
      if (i != -1) {
        break label3699;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipOpName", String.class));
      label2662:
      i = paramCursor.getColumnIndex("ipJumpUrl");
      if (i != -1) {
        break label3714;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipJumpUrl", String.class));
      label2697:
      i = paramCursor.getColumnIndex("ipReqTime");
      if (i != -1) {
        break label3729;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipReqTime", Long.TYPE));
      label2732:
      i = paramCursor.getColumnIndex("ipLastReqTime");
      if (i != -1) {
        break label3744;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipLastReqTime", Long.TYPE));
      label2767:
      i = paramCursor.getColumnIndex("aio");
      if (i != -1) {
        break label3759;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("aio", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandian");
      if (i != -1) {
        break label3786;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("kandian", Boolean.TYPE));
      i = paramCursor.getColumnIndex("richIPReqTime");
      if (i != -1) {
        break label3813;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richIPReqTime", Long.TYPE));
      label2872:
      i = paramCursor.getColumnIndex("richIPLastReqTime");
      if (i != -1) {
        break label3828;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richIPLastReqTime", Long.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("hasIpProduct");
      if (i != -1) {
        break label3843;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasIpProduct", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipSiteInfoBytes");
      if (i != -1) {
        break label3871;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipSiteInfoBytes", [B.class));
      return paramEntity;
      paramEntity.epId = paramCursor.getString(i);
      break;
      label2994:
      paramEntity.wordingId = paramCursor.getLong(i);
      break label1157;
      label3009:
      paramEntity.childEpId = paramCursor.getString(i);
      break label1192;
      label3024:
      paramEntity.minQQVersion = paramCursor.getString(i);
      break label1227;
      label3039:
      paramEntity.name = paramCursor.getString(i);
      break label1262;
      label3054:
      paramEntity.mark = paramCursor.getString(i);
      break label1297;
      label3069:
      paramEntity.type = paramCursor.getInt(i);
      break label1332;
      label3084:
      paramEntity.author = paramCursor.getString(i);
      break label1367;
      label3099:
      paramEntity.expiretime = paramCursor.getLong(i);
      break label1402;
      label3114:
      paramEntity.status = paramCursor.getInt(i);
      break label1437;
      label3129:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSound = paramBoolean;
        break;
      }
      label3156:
      paramEntity.jobType = paramCursor.getInt(i);
      break label1507;
      label3171:
      paramEntity.kinId = paramCursor.getString(i);
      break label1542;
      label3186:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.valid = paramBoolean;
        break;
      }
      label3213:
      paramEntity.downloadCount = paramCursor.getInt(i);
      break label1612;
      label3228:
      paramEntity.mobileFeetype = paramCursor.getInt(i);
      break label1647;
      label3243:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRecommendation = paramBoolean;
        break;
      }
      label3270:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isMagicFaceDownloading = paramBoolean;
        break;
      }
      label3297:
      paramEntity.firstEmotionId = paramCursor.getString(i);
      break label1752;
      label3312:
      paramEntity.upperLeftLable = paramCursor.getInt(i);
      break label1787;
      label3327:
      paramEntity.localVersion = paramCursor.getInt(i);
      break label1822;
      label3342:
      paramEntity.latestVersion = paramCursor.getInt(i);
      break label1857;
      label3357:
      paramEntity.jsonVersion = paramCursor.getInt(i);
      break label1892;
      label3372:
      paramEntity.updateFlag = paramCursor.getInt(i);
      break label1927;
      label3387:
      paramEntity.updateTip = paramCursor.getString(i);
      break label1962;
      label3402:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasReadUpdatePage = paramBoolean;
        break;
      }
      label3429:
      paramEntity.rscType = paramCursor.getInt(i);
      break label2032;
      label3444:
      paramEntity.supportSize = paramCursor.getString(i);
      break label2067;
      label3459:
      paramEntity.extraFlags = paramCursor.getInt(i);
      break label2102;
      label3474:
      paramEntity.businessExtra = paramCursor.getString(i);
      break label2137;
      label3489:
      paramEntity.subType = paramCursor.getInt(i);
      break label2172;
      label3504:
      paramEntity.isAPNG = paramCursor.getInt(i);
      break label2207;
      label3519:
      paramEntity.copywritingType = paramCursor.getInt(i);
      break label2242;
      label3534:
      paramEntity.diversionName = paramCursor.getString(i);
      break label2277;
      label3549:
      paramEntity.copywritingContent = paramCursor.getString(i);
      break label2312;
      label3564:
      paramEntity.jumpUrl = paramCursor.getString(i);
      break label2347;
      label3579:
      paramEntity.imageUrl = paramCursor.getString(i);
      break label2382;
      label3594:
      paramEntity.beginTime = paramCursor.getLong(i);
      break label2417;
      label3609:
      paramEntity.endTime = paramCursor.getLong(i);
      break label2452;
      label3624:
      paramEntity.buttonWording = paramCursor.getString(i);
      break label2487;
      label3639:
      paramEntity.comeFom = paramCursor.getString(i);
      break label2522;
      label3654:
      paramEntity.ipUrl = paramCursor.getString(i);
      break label2557;
      label3669:
      paramEntity.ipName = paramCursor.getString(i);
      break label2592;
      label3684:
      paramEntity.ipDetail = paramCursor.getString(i);
      break label2627;
      label3699:
      paramEntity.ipOpName = paramCursor.getString(i);
      break label2662;
      label3714:
      paramEntity.ipJumpUrl = paramCursor.getString(i);
      break label2697;
      label3729:
      paramEntity.ipReqTime = paramCursor.getLong(i);
      break label2732;
      label3744:
      paramEntity.ipLastReqTime = paramCursor.getLong(i);
      break label2767;
      label3759:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.aio = paramBoolean;
        break;
      }
      label3786:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.kandian = paramBoolean;
        break;
      }
      label3813:
      paramEntity.richIPReqTime = paramCursor.getLong(i);
      break label2872;
      label3828:
      paramEntity.richIPLastReqTime = paramCursor.getLong(i);
    }
    label3843:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.hasIpProduct = paramBoolean;
      break;
    }
    label3871:
    paramEntity.ipSiteInfoBytes = paramCursor.getBlob(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,wordingId INTEGER ,childEpId TEXT ,minQQVersion TEXT ,name TEXT ,mark TEXT ,type INTEGER ,author TEXT ,expiretime INTEGER ,status INTEGER ,hasSound INTEGER ,jobType INTEGER ,kinId TEXT ,valid INTEGER ,downloadCount INTEGER ,mobileFeetype INTEGER ,isRecommendation INTEGER ,isMagicFaceDownloading INTEGER ,firstEmotionId TEXT ,upperLeftLable INTEGER ,localVersion INTEGER ,latestVersion INTEGER ,jsonVersion INTEGER default 0 ,updateFlag INTEGER ,updateTip TEXT ,hasReadUpdatePage INTEGER ,rscType INTEGER ,supportSize TEXT ,extraFlags INTEGER ,businessExtra TEXT ,subType INTEGER ,isAPNG INTEGER ,copywritingType INTEGER ,diversionName TEXT ,copywritingContent TEXT ,jumpUrl TEXT ,imageUrl TEXT ,beginTime INTEGER ,endTime INTEGER ,buttonWording TEXT ,comeFom TEXT ,ipUrl TEXT ,ipName TEXT ,ipDetail TEXT ,ipOpName TEXT ,ipJumpUrl TEXT ,ipReqTime INTEGER ,ipLastReqTime INTEGER ,aio INTEGER ,kandian INTEGER ,richIPReqTime INTEGER ,richIPLastReqTime INTEGER ,hasIpProduct INTEGER ,ipSiteInfoBytes BLOB)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (EmoticonPackage)paramEntity;
    paramContentValues.put("epId", paramEntity.epId);
    paramContentValues.put("wordingId", Long.valueOf(paramEntity.wordingId));
    paramContentValues.put("childEpId", paramEntity.childEpId);
    paramContentValues.put("minQQVersion", paramEntity.minQQVersion);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("mark", paramEntity.mark);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("author", paramEntity.author);
    paramContentValues.put("expiretime", Long.valueOf(paramEntity.expiretime));
    paramContentValues.put("status", Integer.valueOf(paramEntity.status));
    paramContentValues.put("hasSound", Boolean.valueOf(paramEntity.hasSound));
    paramContentValues.put("jobType", Integer.valueOf(paramEntity.jobType));
    paramContentValues.put("kinId", paramEntity.kinId);
    paramContentValues.put("valid", Boolean.valueOf(paramEntity.valid));
    paramContentValues.put("downloadCount", Integer.valueOf(paramEntity.downloadCount));
    paramContentValues.put("mobileFeetype", Integer.valueOf(paramEntity.mobileFeetype));
    paramContentValues.put("isRecommendation", Boolean.valueOf(paramEntity.isRecommendation));
    paramContentValues.put("isMagicFaceDownloading", Boolean.valueOf(paramEntity.isMagicFaceDownloading));
    paramContentValues.put("firstEmotionId", paramEntity.firstEmotionId);
    paramContentValues.put("upperLeftLable", Integer.valueOf(paramEntity.upperLeftLable));
    paramContentValues.put("localVersion", Integer.valueOf(paramEntity.localVersion));
    paramContentValues.put("latestVersion", Integer.valueOf(paramEntity.latestVersion));
    paramContentValues.put("jsonVersion", Integer.valueOf(paramEntity.jsonVersion));
    paramContentValues.put("updateFlag", Integer.valueOf(paramEntity.updateFlag));
    paramContentValues.put("updateTip", paramEntity.updateTip);
    paramContentValues.put("hasReadUpdatePage", Boolean.valueOf(paramEntity.hasReadUpdatePage));
    paramContentValues.put("rscType", Integer.valueOf(paramEntity.rscType));
    paramContentValues.put("supportSize", paramEntity.supportSize);
    paramContentValues.put("extraFlags", Integer.valueOf(paramEntity.extraFlags));
    paramContentValues.put("businessExtra", paramEntity.businessExtra);
    paramContentValues.put("subType", Integer.valueOf(paramEntity.subType));
    paramContentValues.put("isAPNG", Integer.valueOf(paramEntity.isAPNG));
    paramContentValues.put("copywritingType", Integer.valueOf(paramEntity.copywritingType));
    paramContentValues.put("diversionName", paramEntity.diversionName);
    paramContentValues.put("copywritingContent", paramEntity.copywritingContent);
    paramContentValues.put("jumpUrl", paramEntity.jumpUrl);
    paramContentValues.put("imageUrl", paramEntity.imageUrl);
    paramContentValues.put("beginTime", Long.valueOf(paramEntity.beginTime));
    paramContentValues.put("endTime", Long.valueOf(paramEntity.endTime));
    paramContentValues.put("buttonWording", paramEntity.buttonWording);
    paramContentValues.put("comeFom", paramEntity.comeFom);
    paramContentValues.put("ipUrl", paramEntity.ipUrl);
    paramContentValues.put("ipName", paramEntity.ipName);
    paramContentValues.put("ipDetail", paramEntity.ipDetail);
    paramContentValues.put("ipOpName", paramEntity.ipOpName);
    paramContentValues.put("ipJumpUrl", paramEntity.ipJumpUrl);
    paramContentValues.put("ipReqTime", Long.valueOf(paramEntity.ipReqTime));
    paramContentValues.put("ipLastReqTime", Long.valueOf(paramEntity.ipLastReqTime));
    paramContentValues.put("aio", Boolean.valueOf(paramEntity.aio));
    paramContentValues.put("kandian", Boolean.valueOf(paramEntity.kandian));
    paramContentValues.put("richIPReqTime", Long.valueOf(paramEntity.richIPReqTime));
    paramContentValues.put("richIPLastReqTime", Long.valueOf(paramEntity.richIPLastReqTime));
    paramContentValues.put("hasIpProduct", Boolean.valueOf(paramEntity.hasIpProduct));
    paramContentValues.put("ipSiteInfoBytes", paramEntity.ipSiteInfoBytes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EmoticonPackageDao
 * JD-Core Version:    0.7.0.1
 */