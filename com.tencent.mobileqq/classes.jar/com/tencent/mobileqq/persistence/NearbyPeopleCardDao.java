package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public class NearbyPeopleCardDao
  extends OGAbstractDao
{
  public NearbyPeopleCardDao()
  {
    this.a = 102;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (NearbyPeopleCard)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.tinyId = paramCursor.getLong(paramCursor.getColumnIndex("tinyId"));
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.strRemark = paramCursor.getString(paramCursor.getColumnIndex("strRemark"));
      paramEntity.nickname = paramCursor.getString(paramCursor.getColumnIndex("nickname"));
      paramEntity.gender = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("gender")));
      paramEntity.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
      paramEntity.birthday = paramCursor.getInt(paramCursor.getColumnIndex("birthday"));
      paramEntity.constellation = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("constellation")));
      paramEntity.distance = paramCursor.getString(paramCursor.getColumnIndex("distance"));
      paramEntity.timeDiff = paramCursor.getString(paramCursor.getColumnIndex("timeDiff"));
      paramEntity.aioDistanceAndTime = paramCursor.getString(paramCursor.getColumnIndex("aioDistanceAndTime"));
      paramEntity.likeCount = paramCursor.getInt(paramCursor.getColumnIndex("likeCount"));
      paramEntity.likeCountInc = paramCursor.getInt(paramCursor.getColumnIndex("likeCountInc"));
      paramEntity.oldPhotoCount = paramCursor.getInt(paramCursor.getColumnIndex("oldPhotoCount"));
      paramEntity.dateInfo = paramCursor.getBlob(paramCursor.getColumnIndex("dateInfo"));
      paramEntity.ulShowControl = paramCursor.getLong(paramCursor.getColumnIndex("ulShowControl"));
      paramEntity.xuanYan = paramCursor.getBlob(paramCursor.getColumnIndex("xuanYan"));
      paramEntity.maritalStatus = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("maritalStatus")));
      paramEntity.job = paramCursor.getInt(paramCursor.getColumnIndex("job"));
      paramEntity.company = paramCursor.getString(paramCursor.getColumnIndex("company"));
      paramEntity.college = paramCursor.getString(paramCursor.getColumnIndex("college"));
      paramEntity.hometownCountry = paramCursor.getString(paramCursor.getColumnIndex("hometownCountry"));
      paramEntity.hometownProvice = paramCursor.getString(paramCursor.getColumnIndex("hometownProvice"));
      paramEntity.hometownCity = paramCursor.getString(paramCursor.getColumnIndex("hometownCity"));
      paramEntity.hometownDistrict = paramCursor.getString(paramCursor.getColumnIndex("hometownDistrict"));
      paramEntity.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
      paramEntity.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramEntity.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramEntity.qzoneFeed = paramCursor.getString(paramCursor.getColumnIndex("qzoneFeed"));
      paramEntity.qzoneName = paramCursor.getString(paramCursor.getColumnIndex("qzoneName"));
      paramEntity.qzonePicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_1"));
      paramEntity.qzonePicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_2"));
      paramEntity.qzonePicUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("qzonePicUrl_3"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isPhotoUseCache")))
      {
        paramBoolean = true;
        paramEntity.isPhotoUseCache = paramBoolean;
        paramEntity.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
        paramEntity.vTempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("vTempChatSig"));
        paramEntity.vGroupList = paramCursor.getBlob(paramCursor.getColumnIndex("vGroupList"));
        paramEntity.nearbyInfo = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyInfo"));
        paramEntity.vActivityList = paramCursor.getBlob(paramCursor.getColumnIndex("vActivityList"));
        paramEntity.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
        paramEntity.iIsGodFlag = paramCursor.getInt(paramCursor.getColumnIndex("iIsGodFlag"));
        paramEntity.strGodJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("strGodJumpUrl"));
        paramEntity.mHeartNum = paramCursor.getInt(paramCursor.getColumnIndex("mHeartNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchQzone"))) {
          break label1991;
        }
        paramBoolean = true;
        label821:
        paramEntity.switchQzone = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
          break label1996;
        }
        paramBoolean = true;
        label846:
        paramEntity.switchHobby = paramBoolean;
        paramEntity.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
        paramEntity.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
        paramEntity.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
          break label2001;
        }
        paramBoolean = true;
        label925:
        paramEntity.godFlag = paramBoolean;
        paramEntity.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
        paramEntity.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
        paramEntity.lastUpdateNickTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateNickTime"));
        paramEntity.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        paramEntity.switchGiftVisible = paramCursor.getLong(paramCursor.getColumnIndex("switchGiftVisible"));
        paramEntity.vGiftInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vGiftInfo"));
        paramEntity.sayHelloFlag = paramCursor.getInt(paramCursor.getColumnIndex("sayHelloFlag"));
        paramEntity.charm = paramCursor.getLong(paramCursor.getColumnIndex("charm"));
        paramEntity.charmLevel = paramCursor.getInt(paramCursor.getColumnIndex("charmLevel"));
        paramEntity.nextThreshold = paramCursor.getInt(paramCursor.getColumnIndex("nextThreshold"));
        paramEntity.curThreshold = paramCursor.getInt(paramCursor.getColumnIndex("curThreshold"));
        paramEntity.profPercent = paramCursor.getInt(paramCursor.getColumnIndex("profPercent"));
        paramEntity.taskFinished = paramCursor.getInt(paramCursor.getColumnIndex("taskFinished"));
        paramEntity.taskTotal = paramCursor.getInt(paramCursor.getColumnIndex("taskTotal"));
        paramEntity.hiWanInfo = paramCursor.getString(paramCursor.getColumnIndex("hiWanInfo"));
        paramEntity.commonLabelString = paramCursor.getString(paramCursor.getColumnIndex("commonLabelString"));
        paramEntity.tagFlag = paramCursor.getLong(paramCursor.getColumnIndex("tagFlag"));
        paramEntity.tagInfo = paramCursor.getString(paramCursor.getColumnIndex("tagInfo"));
        paramEntity.picInfo = paramCursor.getString(paramCursor.getColumnIndex("picInfo"));
        paramEntity.videoDetails = paramCursor.getString(paramCursor.getColumnIndex("videoDetails"));
        paramEntity.strFreshNewsInfo = paramCursor.getString(paramCursor.getColumnIndex("strFreshNewsInfo"));
        paramEntity.strHotChatInfo = paramCursor.getString(paramCursor.getColumnIndex("strHotChatInfo"));
        paramEntity.uRoomid = paramCursor.getLong(paramCursor.getColumnIndex("uRoomid"));
        paramEntity.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramEntity.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramEntity.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramEntity.collegeId = paramCursor.getLong(paramCursor.getColumnIndex("collegeId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label2006;
        }
        paramBoolean = true;
        label1461:
        paramEntity.videoHeadFlag = paramBoolean;
        paramEntity.bVideoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("bVideoHeadUrl"));
        paramEntity.faceScoreWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreWordingColor"));
        paramEntity.faceScoreWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreWording"));
        paramEntity.faceScoreTailWordingColor = paramCursor.getInt(paramCursor.getColumnIndex("faceScoreTailWordingColor"));
        paramEntity.faceScoreTailWording = paramCursor.getString(paramCursor.getColumnIndex("faceScoreTailWording"));
        paramEntity.faceScoreIconUrl = paramCursor.getString(paramCursor.getColumnIndex("faceScoreIconUrl"));
        paramEntity.entryAbility = paramCursor.getInt(paramCursor.getColumnIndex("entryAbility"));
        paramEntity.strLevelType = paramCursor.getString(paramCursor.getColumnIndex("strLevelType"));
        paramEntity.maskMsgFlag = paramCursor.getInt(paramCursor.getColumnIndex("maskMsgFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsg"))) {
          break label2011;
        }
        paramBoolean = true;
        label1658:
        paramEntity.isForbidSendMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsg"))) {
          break label2016;
        }
        paramBoolean = true;
        label1684:
        paramEntity.isForbidSendGiftMsg = paramBoolean;
        paramEntity.disableSendMsgBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTips"));
        paramEntity.disableSendGiftBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTips"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsgForTribar"))) {
          break label2021;
        }
        paramBoolean = true;
        label1748:
        paramEntity.isForbidSendMsgForTribar = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar"))) {
          break label2026;
        }
        paramBoolean = true;
        label1774:
        paramEntity.isForbidSendGiftMsgForTribar = paramBoolean;
        paramEntity.disableSendMsgBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
        paramEntity.disableSendGiftBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
        paramEntity.highScoreNum = paramCursor.getInt(paramCursor.getColumnIndex("highScoreNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mHasStory"))) {
          break label2031;
        }
        paramBoolean = true;
        label1857:
        paramEntity.mHasStory = paramBoolean;
        paramEntity.mQQStoryData = paramCursor.getBlob(paramCursor.getColumnIndex("mQQStoryData"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen"))) {
          break label2036;
        }
      }
      label1991:
      label1996:
      label2001:
      label2006:
      label2011:
      label2016:
      label2021:
      label2026:
      label2031:
      label2036:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isSendMsgBtnDownloadAppOpen = paramBoolean;
        paramEntity.sendMsgBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips"));
        paramEntity.addPicBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("addPicBtnDownloadAppTips"));
        paramEntity.tribeAppDownloadPageUrl = paramCursor.getString(paramCursor.getColumnIndex("tribeAppDownloadPageUrl"));
        paramEntity.nearbyNowDataBytes = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyNowDataBytes"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label821;
        paramBoolean = false;
        break label846;
        paramBoolean = false;
        break label925;
        paramBoolean = false;
        break label1461;
        paramBoolean = false;
        break label1658;
        paramBoolean = false;
        break label1684;
        paramBoolean = false;
        break label1748;
        paramBoolean = false;
        break label1774;
        paramBoolean = false;
        break label1857;
      }
    }
    int i = paramCursor.getColumnIndex("tinyId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("tinyId", Long.TYPE));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label5728;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      label2111:
      i = paramCursor.getColumnIndex("strRemark");
      if (i != -1) {
        break label5743;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strRemark", String.class));
      label2146:
      i = paramCursor.getColumnIndex("nickname");
      if (i != -1) {
        break label5758;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nickname", String.class));
      label2181:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label5773;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gender", Byte.TYPE));
      label2216:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label5789;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Integer.TYPE));
      label2251:
      i = paramCursor.getColumnIndex("birthday");
      if (i != -1) {
        break label5804;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("birthday", Integer.TYPE));
      label2286:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label5819;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("constellation", Byte.TYPE));
      label2321:
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label5835;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distance", String.class));
      label2356:
      i = paramCursor.getColumnIndex("timeDiff");
      if (i != -1) {
        break label5850;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timeDiff", String.class));
      label2391:
      i = paramCursor.getColumnIndex("aioDistanceAndTime");
      if (i != -1) {
        break label5865;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("aioDistanceAndTime", String.class));
      label2426:
      i = paramCursor.getColumnIndex("likeCount");
      if (i != -1) {
        break label5880;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("likeCount", Integer.TYPE));
      label2461:
      i = paramCursor.getColumnIndex("likeCountInc");
      if (i != -1) {
        break label5895;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("likeCountInc", Integer.TYPE));
      label2496:
      i = paramCursor.getColumnIndex("oldPhotoCount");
      if (i != -1) {
        break label5910;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("oldPhotoCount", Integer.TYPE));
      label2531:
      i = paramCursor.getColumnIndex("dateInfo");
      if (i != -1) {
        break label5925;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dateInfo", [B.class));
      label2566:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label5940;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ulShowControl", Long.TYPE));
      label2601:
      i = paramCursor.getColumnIndex("xuanYan");
      if (i != -1) {
        break label5955;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("xuanYan", [B.class));
      label2636:
      i = paramCursor.getColumnIndex("maritalStatus");
      if (i != -1) {
        break label5970;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("maritalStatus", Byte.TYPE));
      label2671:
      i = paramCursor.getColumnIndex("job");
      if (i != -1) {
        break label5986;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("job", Integer.TYPE));
      label2706:
      i = paramCursor.getColumnIndex("company");
      if (i != -1) {
        break label6001;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("company", String.class));
      label2741:
      i = paramCursor.getColumnIndex("college");
      if (i != -1) {
        break label6016;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("college", String.class));
      label2776:
      i = paramCursor.getColumnIndex("hometownCountry");
      if (i != -1) {
        break label6031;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownCountry", String.class));
      label2811:
      i = paramCursor.getColumnIndex("hometownProvice");
      if (i != -1) {
        break label6046;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownProvice", String.class));
      label2846:
      i = paramCursor.getColumnIndex("hometownCity");
      if (i != -1) {
        break label6061;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownCity", String.class));
      label2881:
      i = paramCursor.getColumnIndex("hometownDistrict");
      if (i != -1) {
        break label6076;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownDistrict", String.class));
      label2916:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label6091;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCookies", [B.class));
      label2951:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label6106;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bVoted", Byte.TYPE));
      label2986:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label6122;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label3021:
      i = paramCursor.getColumnIndex("qzoneFeed");
      if (i != -1) {
        break label6137;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneFeed", String.class));
      label3056:
      i = paramCursor.getColumnIndex("qzoneName");
      if (i != -1) {
        break label6152;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneName", String.class));
      label3091:
      i = paramCursor.getColumnIndex("qzonePicUrl_1");
      if (i != -1) {
        break label6167;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzonePicUrl_1", String.class));
      label3126:
      i = paramCursor.getColumnIndex("qzonePicUrl_2");
      if (i != -1) {
        break label6182;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzonePicUrl_2", String.class));
      label3161:
      i = paramCursor.getColumnIndex("qzonePicUrl_3");
      if (i != -1) {
        break label6197;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzonePicUrl_3", String.class));
      label3196:
      i = paramCursor.getColumnIndex("isPhotoUseCache");
      if (i != -1) {
        break label6212;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label6239;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vSeed", [B.class));
      label3266:
      i = paramCursor.getColumnIndex("vTempChatSig");
      if (i != -1) {
        break label6254;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vTempChatSig", [B.class));
      label3301:
      i = paramCursor.getColumnIndex("vGroupList");
      if (i != -1) {
        break label6269;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vGroupList", [B.class));
      label3336:
      i = paramCursor.getColumnIndex("nearbyInfo");
      if (i != -1) {
        break label6284;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nearbyInfo", [B.class));
      label3371:
      i = paramCursor.getColumnIndex("vActivityList");
      if (i != -1) {
        break label6299;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vActivityList", [B.class));
      label3406:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label6314;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lUserFlag", Long.TYPE));
      label3441:
      i = paramCursor.getColumnIndex("iIsGodFlag");
      if (i != -1) {
        break label6329;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iIsGodFlag", Integer.TYPE));
      label3476:
      i = paramCursor.getColumnIndex("strGodJumpUrl");
      if (i != -1) {
        break label6344;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGodJumpUrl", String.class));
      label3511:
      i = paramCursor.getColumnIndex("mHeartNum");
      if (i != -1) {
        break label6359;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mHeartNum", Integer.TYPE));
      label3546:
      i = paramCursor.getColumnIndex("switchQzone");
      if (i != -1) {
        break label6374;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("switchQzone", Boolean.TYPE));
      i = paramCursor.getColumnIndex("switchHobby");
      if (i != -1) {
        break label6401;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("switchHobby", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uiShowControl");
      if (i != -1) {
        break label6428;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uiShowControl", Long.TYPE));
      label3651:
      i = paramCursor.getColumnIndex("userFlag");
      if (i != -1) {
        break label6443;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("userFlag", Long.TYPE));
      label3686:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label6458;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("busiEntry", String.class));
      label3721:
      i = paramCursor.getColumnIndex("godFlag");
      if (i != -1) {
        break label6473;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("godFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label6500;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label3791:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label6515;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strProfileUrl", String.class));
      label3826:
      i = paramCursor.getColumnIndex("lastUpdateNickTime");
      if (i != -1) {
        break label6530;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastUpdateNickTime", Long.TYPE));
      label3861:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label6545;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label3898:
      i = paramCursor.getColumnIndex("switchGiftVisible");
      if (i != -1) {
        break label6560;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("switchGiftVisible", Long.TYPE));
      label3935:
      i = paramCursor.getColumnIndex("vGiftInfo");
      if (i != -1) {
        break label6575;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vGiftInfo", [B.class));
      label3972:
      i = paramCursor.getColumnIndex("sayHelloFlag");
      if (i != -1) {
        break label6590;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sayHelloFlag", Integer.TYPE));
      label4009:
      i = paramCursor.getColumnIndex("charm");
      if (i != -1) {
        break label6605;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("charm", Long.TYPE));
      label4046:
      i = paramCursor.getColumnIndex("charmLevel");
      if (i != -1) {
        break label6620;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("charmLevel", Integer.TYPE));
      label4083:
      i = paramCursor.getColumnIndex("nextThreshold");
      if (i != -1) {
        break label6635;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nextThreshold", Integer.TYPE));
      label4120:
      i = paramCursor.getColumnIndex("curThreshold");
      if (i != -1) {
        break label6650;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("curThreshold", Integer.TYPE));
      label4157:
      i = paramCursor.getColumnIndex("profPercent");
      if (i != -1) {
        break label6665;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("profPercent", Integer.TYPE));
      label4194:
      i = paramCursor.getColumnIndex("taskFinished");
      if (i != -1) {
        break label6680;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("taskFinished", Integer.TYPE));
      label4231:
      i = paramCursor.getColumnIndex("taskTotal");
      if (i != -1) {
        break label6695;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("taskTotal", Integer.TYPE));
      label4268:
      i = paramCursor.getColumnIndex("hiWanInfo");
      if (i != -1) {
        break label6710;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hiWanInfo", String.class));
      label4305:
      i = paramCursor.getColumnIndex("commonLabelString");
      if (i != -1) {
        break label6725;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("commonLabelString", String.class));
      label4342:
      i = paramCursor.getColumnIndex("tagFlag");
      if (i != -1) {
        break label6740;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tagFlag", Long.TYPE));
      label4379:
      i = paramCursor.getColumnIndex("tagInfo");
      if (i != -1) {
        break label6755;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tagInfo", String.class));
      label4416:
      i = paramCursor.getColumnIndex("picInfo");
      if (i != -1) {
        break label6770;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("picInfo", String.class));
      label4453:
      i = paramCursor.getColumnIndex("videoDetails");
      if (i != -1) {
        break label6785;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoDetails", String.class));
      label4490:
      i = paramCursor.getColumnIndex("strFreshNewsInfo");
      if (i != -1) {
        break label6800;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strFreshNewsInfo", String.class));
      label4527:
      i = paramCursor.getColumnIndex("strHotChatInfo");
      if (i != -1) {
        break label6815;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strHotChatInfo", String.class));
      label4564:
      i = paramCursor.getColumnIndex("uRoomid");
      if (i != -1) {
        break label6830;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uRoomid", Long.TYPE));
      label4601:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label6845;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label4638:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label6860;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label4675:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label6875;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label4712:
      i = paramCursor.getColumnIndex("collegeId");
      if (i != -1) {
        break label6890;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("collegeId", Long.TYPE));
      label4749:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label6905;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bVideoHeadUrl");
      if (i != -1) {
        break label6932;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bVideoHeadUrl", String.class));
      label4823:
      i = paramCursor.getColumnIndex("faceScoreWordingColor");
      if (i != -1) {
        break label6947;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
      label4860:
      i = paramCursor.getColumnIndex("faceScoreWording");
      if (i != -1) {
        break label6962;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreWording", String.class));
      label4897:
      i = paramCursor.getColumnIndex("faceScoreTailWordingColor");
      if (i != -1) {
        break label6977;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
      label4934:
      i = paramCursor.getColumnIndex("faceScoreTailWording");
      if (i != -1) {
        break label6992;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreTailWording", String.class));
      label4971:
      i = paramCursor.getColumnIndex("faceScoreIconUrl");
      if (i != -1) {
        break label7007;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreIconUrl", String.class));
      label5008:
      i = paramCursor.getColumnIndex("entryAbility");
      if (i != -1) {
        break label7022;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("entryAbility", Integer.TYPE));
      label5045:
      i = paramCursor.getColumnIndex("strLevelType");
      if (i != -1) {
        break label7037;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLevelType", String.class));
      label5082:
      i = paramCursor.getColumnIndex("maskMsgFlag");
      if (i != -1) {
        break label7052;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("maskMsgFlag", Integer.TYPE));
      label5119:
      i = paramCursor.getColumnIndex("isForbidSendMsg");
      if (i != -1) {
        break label7067;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsg");
      if (i != -1) {
        break label7094;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTips");
      if (i != -1) {
        break label7121;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("disableSendMsgBtnTips", String.class));
      label5230:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTips");
      if (i != -1) {
        break label7136;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("disableSendGiftBtnTips", String.class));
      label5267:
      i = paramCursor.getColumnIndex("isForbidSendMsgForTribar");
      if (i != -1) {
        break label7151;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar");
      if (i != -1) {
        break label7178;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
      if (i != -1) {
        break label7205;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
      label5378:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
      if (i != -1) {
        break label7220;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
      label5415:
      i = paramCursor.getColumnIndex("highScoreNum");
      if (i != -1) {
        break label7235;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("highScoreNum", Integer.TYPE));
      label5452:
      i = paramCursor.getColumnIndex("mHasStory");
      if (i != -1) {
        break label7250;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mHasStory", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQStoryData");
      if (i != -1) {
        break label7277;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mQQStoryData", [B.class));
      label5526:
      i = paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
      if (i != -1) {
        break label7292;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips");
      if (i != -1) {
        break label7320;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
      label5600:
      i = paramCursor.getColumnIndex("addPicBtnDownloadAppTips");
      if (i != -1) {
        break label7335;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addPicBtnDownloadAppTips", String.class));
      label5637:
      i = paramCursor.getColumnIndex("tribeAppDownloadPageUrl");
      if (i != -1) {
        break label7350;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tribeAppDownloadPageUrl", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("nearbyNowDataBytes");
      if (i != -1) {
        break label7365;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nearbyNowDataBytes", [B.class));
      return paramEntity;
      paramEntity.tinyId = paramCursor.getLong(i);
      break;
      label5728:
      paramEntity.uin = paramCursor.getString(i);
      break label2111;
      label5743:
      paramEntity.strRemark = paramCursor.getString(i);
      break label2146;
      label5758:
      paramEntity.nickname = paramCursor.getString(i);
      break label2181;
      label5773:
      paramEntity.gender = ((byte)paramCursor.getShort(i));
      break label2216;
      label5789:
      paramEntity.age = paramCursor.getInt(i);
      break label2251;
      label5804:
      paramEntity.birthday = paramCursor.getInt(i);
      break label2286;
      label5819:
      paramEntity.constellation = ((byte)paramCursor.getShort(i));
      break label2321;
      label5835:
      paramEntity.distance = paramCursor.getString(i);
      break label2356;
      label5850:
      paramEntity.timeDiff = paramCursor.getString(i);
      break label2391;
      label5865:
      paramEntity.aioDistanceAndTime = paramCursor.getString(i);
      break label2426;
      label5880:
      paramEntity.likeCount = paramCursor.getInt(i);
      break label2461;
      label5895:
      paramEntity.likeCountInc = paramCursor.getInt(i);
      break label2496;
      label5910:
      paramEntity.oldPhotoCount = paramCursor.getInt(i);
      break label2531;
      label5925:
      paramEntity.dateInfo = paramCursor.getBlob(i);
      break label2566;
      label5940:
      paramEntity.ulShowControl = paramCursor.getLong(i);
      break label2601;
      label5955:
      paramEntity.xuanYan = paramCursor.getBlob(i);
      break label2636;
      label5970:
      paramEntity.maritalStatus = ((byte)paramCursor.getShort(i));
      break label2671;
      label5986:
      paramEntity.job = paramCursor.getInt(i);
      break label2706;
      label6001:
      paramEntity.company = paramCursor.getString(i);
      break label2741;
      label6016:
      paramEntity.college = paramCursor.getString(i);
      break label2776;
      label6031:
      paramEntity.hometownCountry = paramCursor.getString(i);
      break label2811;
      label6046:
      paramEntity.hometownProvice = paramCursor.getString(i);
      break label2846;
      label6061:
      paramEntity.hometownCity = paramCursor.getString(i);
      break label2881;
      label6076:
      paramEntity.hometownDistrict = paramCursor.getString(i);
      break label2916;
      label6091:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label2951;
      label6106:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label2986;
      label6122:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label3021;
      label6137:
      paramEntity.qzoneFeed = paramCursor.getString(i);
      break label3056;
      label6152:
      paramEntity.qzoneName = paramCursor.getString(i);
      break label3091;
      label6167:
      paramEntity.qzonePicUrl_1 = paramCursor.getString(i);
      break label3126;
      label6182:
      paramEntity.qzonePicUrl_2 = paramCursor.getString(i);
      break label3161;
      label6197:
      paramEntity.qzonePicUrl_3 = paramCursor.getString(i);
      break label3196;
      label6212:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isPhotoUseCache = paramBoolean;
        break;
      }
      label6239:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label3266;
      label6254:
      paramEntity.vTempChatSig = paramCursor.getBlob(i);
      break label3301;
      label6269:
      paramEntity.vGroupList = paramCursor.getBlob(i);
      break label3336;
      label6284:
      paramEntity.nearbyInfo = paramCursor.getBlob(i);
      break label3371;
      label6299:
      paramEntity.vActivityList = paramCursor.getBlob(i);
      break label3406;
      label6314:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label3441;
      label6329:
      paramEntity.iIsGodFlag = paramCursor.getInt(i);
      break label3476;
      label6344:
      paramEntity.strGodJumpUrl = paramCursor.getString(i);
      break label3511;
      label6359:
      paramEntity.mHeartNum = paramCursor.getInt(i);
      break label3546;
      label6374:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.switchQzone = paramBoolean;
        break;
      }
      label6401:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.switchHobby = paramBoolean;
        break;
      }
      label6428:
      paramEntity.uiShowControl = paramCursor.getLong(i);
      break label3651;
      label6443:
      paramEntity.userFlag = paramCursor.getLong(i);
      break label3686;
      label6458:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label3721;
      label6473:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.godFlag = paramBoolean;
        break;
      }
      label6500:
      paramEntity.nLastGameFlag = paramCursor.getInt(i);
      break label3791;
      label6515:
      paramEntity.strProfileUrl = paramCursor.getString(i);
      break label3826;
      label6530:
      paramEntity.lastUpdateNickTime = paramCursor.getLong(i);
      break label3861;
      label6545:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label3898;
      label6560:
      paramEntity.switchGiftVisible = paramCursor.getLong(i);
      break label3935;
      label6575:
      paramEntity.vGiftInfo = paramCursor.getBlob(i);
      break label3972;
      label6590:
      paramEntity.sayHelloFlag = paramCursor.getInt(i);
      break label4009;
      label6605:
      paramEntity.charm = paramCursor.getLong(i);
      break label4046;
      label6620:
      paramEntity.charmLevel = paramCursor.getInt(i);
      break label4083;
      label6635:
      paramEntity.nextThreshold = paramCursor.getInt(i);
      break label4120;
      label6650:
      paramEntity.curThreshold = paramCursor.getInt(i);
      break label4157;
      label6665:
      paramEntity.profPercent = paramCursor.getInt(i);
      break label4194;
      label6680:
      paramEntity.taskFinished = paramCursor.getInt(i);
      break label4231;
      label6695:
      paramEntity.taskTotal = paramCursor.getInt(i);
      break label4268;
      label6710:
      paramEntity.hiWanInfo = paramCursor.getString(i);
      break label4305;
      label6725:
      paramEntity.commonLabelString = paramCursor.getString(i);
      break label4342;
      label6740:
      paramEntity.tagFlag = paramCursor.getLong(i);
      break label4379;
      label6755:
      paramEntity.tagInfo = paramCursor.getString(i);
      break label4416;
      label6770:
      paramEntity.picInfo = paramCursor.getString(i);
      break label4453;
      label6785:
      paramEntity.videoDetails = paramCursor.getString(i);
      break label4490;
      label6800:
      paramEntity.strFreshNewsInfo = paramCursor.getString(i);
      break label4527;
      label6815:
      paramEntity.strHotChatInfo = paramCursor.getString(i);
      break label4564;
      label6830:
      paramEntity.uRoomid = paramCursor.getLong(i);
      break label4601;
      label6845:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label4638;
      label6860:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label4675;
      label6875:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label4712;
      label6890:
      paramEntity.collegeId = paramCursor.getLong(i);
      break label4749;
      label6905:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.videoHeadFlag = paramBoolean;
        break;
      }
      label6932:
      paramEntity.bVideoHeadUrl = paramCursor.getString(i);
      break label4823;
      label6947:
      paramEntity.faceScoreWordingColor = paramCursor.getInt(i);
      break label4860;
      label6962:
      paramEntity.faceScoreWording = paramCursor.getString(i);
      break label4897;
      label6977:
      paramEntity.faceScoreTailWordingColor = paramCursor.getInt(i);
      break label4934;
      label6992:
      paramEntity.faceScoreTailWording = paramCursor.getString(i);
      break label4971;
      label7007:
      paramEntity.faceScoreIconUrl = paramCursor.getString(i);
      break label5008;
      label7022:
      paramEntity.entryAbility = paramCursor.getInt(i);
      break label5045;
      label7037:
      paramEntity.strLevelType = paramCursor.getString(i);
      break label5082;
      label7052:
      paramEntity.maskMsgFlag = paramCursor.getInt(i);
      break label5119;
      label7067:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendMsg = paramBoolean;
        break;
      }
      label7094:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendGiftMsg = paramBoolean;
        break;
      }
      label7121:
      paramEntity.disableSendMsgBtnTips = paramCursor.getString(i);
      break label5230;
      label7136:
      paramEntity.disableSendGiftBtnTips = paramCursor.getString(i);
      break label5267;
      label7151:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendMsgForTribar = paramBoolean;
        break;
      }
      label7178:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendGiftMsgForTribar = paramBoolean;
        break;
      }
      label7205:
      paramEntity.disableSendMsgBtnTipsForTribar = paramCursor.getString(i);
      break label5378;
      label7220:
      paramEntity.disableSendGiftBtnTipsForTribar = paramCursor.getString(i);
      break label5415;
      label7235:
      paramEntity.highScoreNum = paramCursor.getInt(i);
      break label5452;
      label7250:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mHasStory = paramBoolean;
        break;
      }
      label7277:
      paramEntity.mQQStoryData = paramCursor.getBlob(i);
      break label5526;
      label7292:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isSendMsgBtnDownloadAppOpen = paramBoolean;
        break;
      }
      label7320:
      paramEntity.sendMsgBtnDownloadAppTips = paramCursor.getString(i);
      break label5600;
      label7335:
      paramEntity.addPicBtnDownloadAppTips = paramCursor.getString(i);
      break label5637;
      label7350:
      paramEntity.tribeAppDownloadPageUrl = paramCursor.getString(i);
    }
    label7365:
    paramEntity.nearbyNowDataBytes = paramCursor.getBlob(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,maskMsgFlag INTEGER ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (NearbyPeopleCard)paramEntity;
    paramContentValues.put("tinyId", Long.valueOf(paramEntity.tinyId));
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("strRemark", paramEntity.strRemark);
    paramContentValues.put("nickname", paramEntity.nickname);
    paramContentValues.put("gender", Byte.valueOf(paramEntity.gender));
    paramContentValues.put("age", Integer.valueOf(paramEntity.age));
    paramContentValues.put("birthday", Integer.valueOf(paramEntity.birthday));
    paramContentValues.put("constellation", Byte.valueOf(paramEntity.constellation));
    paramContentValues.put("distance", paramEntity.distance);
    paramContentValues.put("timeDiff", paramEntity.timeDiff);
    paramContentValues.put("aioDistanceAndTime", paramEntity.aioDistanceAndTime);
    paramContentValues.put("likeCount", Integer.valueOf(paramEntity.likeCount));
    paramContentValues.put("likeCountInc", Integer.valueOf(paramEntity.likeCountInc));
    paramContentValues.put("oldPhotoCount", Integer.valueOf(paramEntity.oldPhotoCount));
    paramContentValues.put("dateInfo", paramEntity.dateInfo);
    paramContentValues.put("ulShowControl", Long.valueOf(paramEntity.ulShowControl));
    paramContentValues.put("xuanYan", paramEntity.xuanYan);
    paramContentValues.put("maritalStatus", Byte.valueOf(paramEntity.maritalStatus));
    paramContentValues.put("job", Integer.valueOf(paramEntity.job));
    paramContentValues.put("company", paramEntity.company);
    paramContentValues.put("college", paramEntity.college);
    paramContentValues.put("hometownCountry", paramEntity.hometownCountry);
    paramContentValues.put("hometownProvice", paramEntity.hometownProvice);
    paramContentValues.put("hometownCity", paramEntity.hometownCity);
    paramContentValues.put("hometownDistrict", paramEntity.hometownDistrict);
    paramContentValues.put("vCookies", paramEntity.vCookies);
    paramContentValues.put("bVoted", Byte.valueOf(paramEntity.bVoted));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramEntity.feedPreviewTime));
    paramContentValues.put("qzoneFeed", paramEntity.qzoneFeed);
    paramContentValues.put("qzoneName", paramEntity.qzoneName);
    paramContentValues.put("qzonePicUrl_1", paramEntity.qzonePicUrl_1);
    paramContentValues.put("qzonePicUrl_2", paramEntity.qzonePicUrl_2);
    paramContentValues.put("qzonePicUrl_3", paramEntity.qzonePicUrl_3);
    paramContentValues.put("isPhotoUseCache", Boolean.valueOf(paramEntity.isPhotoUseCache));
    paramContentValues.put("vSeed", paramEntity.vSeed);
    paramContentValues.put("vTempChatSig", paramEntity.vTempChatSig);
    paramContentValues.put("vGroupList", paramEntity.vGroupList);
    paramContentValues.put("nearbyInfo", paramEntity.nearbyInfo);
    paramContentValues.put("vActivityList", paramEntity.vActivityList);
    paramContentValues.put("lUserFlag", Long.valueOf(paramEntity.lUserFlag));
    paramContentValues.put("iIsGodFlag", Integer.valueOf(paramEntity.iIsGodFlag));
    paramContentValues.put("strGodJumpUrl", paramEntity.strGodJumpUrl);
    paramContentValues.put("mHeartNum", Integer.valueOf(paramEntity.mHeartNum));
    paramContentValues.put("switchQzone", Boolean.valueOf(paramEntity.switchQzone));
    paramContentValues.put("switchHobby", Boolean.valueOf(paramEntity.switchHobby));
    paramContentValues.put("uiShowControl", Long.valueOf(paramEntity.uiShowControl));
    paramContentValues.put("userFlag", Long.valueOf(paramEntity.userFlag));
    paramContentValues.put("busiEntry", paramEntity.busiEntry);
    paramContentValues.put("godFlag", Boolean.valueOf(paramEntity.godFlag));
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramEntity.nLastGameFlag));
    paramContentValues.put("strProfileUrl", paramEntity.strProfileUrl);
    paramContentValues.put("lastUpdateNickTime", Long.valueOf(paramEntity.lastUpdateNickTime));
    paramContentValues.put("favoriteSource", Integer.valueOf(paramEntity.favoriteSource));
    paramContentValues.put("switchGiftVisible", Long.valueOf(paramEntity.switchGiftVisible));
    paramContentValues.put("vGiftInfo", paramEntity.vGiftInfo);
    paramContentValues.put("sayHelloFlag", Integer.valueOf(paramEntity.sayHelloFlag));
    paramContentValues.put("charm", Long.valueOf(paramEntity.charm));
    paramContentValues.put("charmLevel", Integer.valueOf(paramEntity.charmLevel));
    paramContentValues.put("nextThreshold", Integer.valueOf(paramEntity.nextThreshold));
    paramContentValues.put("curThreshold", Integer.valueOf(paramEntity.curThreshold));
    paramContentValues.put("profPercent", Integer.valueOf(paramEntity.profPercent));
    paramContentValues.put("taskFinished", Integer.valueOf(paramEntity.taskFinished));
    paramContentValues.put("taskTotal", Integer.valueOf(paramEntity.taskTotal));
    paramContentValues.put("hiWanInfo", paramEntity.hiWanInfo);
    paramContentValues.put("commonLabelString", paramEntity.commonLabelString);
    paramContentValues.put("tagFlag", Long.valueOf(paramEntity.tagFlag));
    paramContentValues.put("tagInfo", paramEntity.tagInfo);
    paramContentValues.put("picInfo", paramEntity.picInfo);
    paramContentValues.put("videoDetails", paramEntity.videoDetails);
    paramContentValues.put("strFreshNewsInfo", paramEntity.strFreshNewsInfo);
    paramContentValues.put("strHotChatInfo", paramEntity.strHotChatInfo);
    paramContentValues.put("uRoomid", Long.valueOf(paramEntity.uRoomid));
    paramContentValues.put("strVoteLimitedNotice", paramEntity.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramEntity.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramEntity.bAvailVoteCnt));
    paramContentValues.put("collegeId", Long.valueOf(paramEntity.collegeId));
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramEntity.videoHeadFlag));
    paramContentValues.put("bVideoHeadUrl", paramEntity.bVideoHeadUrl);
    paramContentValues.put("faceScoreWordingColor", Integer.valueOf(paramEntity.faceScoreWordingColor));
    paramContentValues.put("faceScoreWording", paramEntity.faceScoreWording);
    paramContentValues.put("faceScoreTailWordingColor", Integer.valueOf(paramEntity.faceScoreTailWordingColor));
    paramContentValues.put("faceScoreTailWording", paramEntity.faceScoreTailWording);
    paramContentValues.put("faceScoreIconUrl", paramEntity.faceScoreIconUrl);
    paramContentValues.put("entryAbility", Integer.valueOf(paramEntity.entryAbility));
    paramContentValues.put("strLevelType", paramEntity.strLevelType);
    paramContentValues.put("maskMsgFlag", Integer.valueOf(paramEntity.maskMsgFlag));
    paramContentValues.put("isForbidSendMsg", Boolean.valueOf(paramEntity.isForbidSendMsg));
    paramContentValues.put("isForbidSendGiftMsg", Boolean.valueOf(paramEntity.isForbidSendGiftMsg));
    paramContentValues.put("disableSendMsgBtnTips", paramEntity.disableSendMsgBtnTips);
    paramContentValues.put("disableSendGiftBtnTips", paramEntity.disableSendGiftBtnTips);
    paramContentValues.put("isForbidSendMsgForTribar", Boolean.valueOf(paramEntity.isForbidSendMsgForTribar));
    paramContentValues.put("isForbidSendGiftMsgForTribar", Boolean.valueOf(paramEntity.isForbidSendGiftMsgForTribar));
    paramContentValues.put("disableSendMsgBtnTipsForTribar", paramEntity.disableSendMsgBtnTipsForTribar);
    paramContentValues.put("disableSendGiftBtnTipsForTribar", paramEntity.disableSendGiftBtnTipsForTribar);
    paramContentValues.put("highScoreNum", Integer.valueOf(paramEntity.highScoreNum));
    paramContentValues.put("mHasStory", Boolean.valueOf(paramEntity.mHasStory));
    paramContentValues.put("mQQStoryData", paramEntity.mQQStoryData);
    paramContentValues.put("isSendMsgBtnDownloadAppOpen", Boolean.valueOf(paramEntity.isSendMsgBtnDownloadAppOpen));
    paramContentValues.put("sendMsgBtnDownloadAppTips", paramEntity.sendMsgBtnDownloadAppTips);
    paramContentValues.put("addPicBtnDownloadAppTips", paramEntity.addPicBtnDownloadAppTips);
    paramContentValues.put("tribeAppDownloadPageUrl", paramEntity.tribeAppDownloadPageUrl);
    paramContentValues.put("nearbyNowDataBytes", paramEntity.nearbyNowDataBytes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.NearbyPeopleCardDao
 * JD-Core Version:    0.7.0.1
 */