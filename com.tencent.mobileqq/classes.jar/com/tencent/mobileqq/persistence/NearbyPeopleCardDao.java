package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public class NearbyPeopleCardDao
  extends OGAbstractDao
{
  public NearbyPeopleCardDao()
  {
    this.columnLen = 111;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (NearbyPeopleCard)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.tinyId = paramCursor.getLong(paramCursor.getColumnIndex("tinyId"));
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.nowId = paramCursor.getLong(paramCursor.getColumnIndex("nowId"));
      paramEntity.nowUserType = paramCursor.getInt(paramCursor.getColumnIndex("nowUserType"));
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
          break label2162;
        }
        paramBoolean = true;
        label857:
        paramEntity.switchQzone = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
          break label2167;
        }
        paramBoolean = true;
        label882:
        paramEntity.switchHobby = paramBoolean;
        paramEntity.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
        paramEntity.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
        paramEntity.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
          break label2172;
        }
        paramBoolean = true;
        label961:
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
          break label2177;
        }
        paramBoolean = true;
        label1499:
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
          break label2182;
        }
        paramBoolean = true;
        label1696:
        paramEntity.isForbidSendMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsg"))) {
          break label2187;
        }
        paramBoolean = true;
        label1722:
        paramEntity.isForbidSendGiftMsg = paramBoolean;
        paramEntity.disableSendMsgBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTips"));
        paramEntity.disableSendGiftBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTips"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsgForTribar"))) {
          break label2192;
        }
        paramBoolean = true;
        label1786:
        paramEntity.isForbidSendMsgForTribar = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar"))) {
          break label2197;
        }
        paramBoolean = true;
        label1812:
        paramEntity.isForbidSendGiftMsgForTribar = paramBoolean;
        paramEntity.disableSendMsgBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
        paramEntity.disableSendGiftBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
        paramEntity.highScoreNum = paramCursor.getInt(paramCursor.getColumnIndex("highScoreNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mHasStory"))) {
          break label2202;
        }
        paramBoolean = true;
        label1895:
        paramEntity.mHasStory = paramBoolean;
        paramEntity.mQQStoryData = paramCursor.getBlob(paramCursor.getColumnIndex("mQQStoryData"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen"))) {
          break label2207;
        }
      }
      label2177:
      label2182:
      label2187:
      label2192:
      label2197:
      label2202:
      label2207:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isSendMsgBtnDownloadAppOpen = paramBoolean;
        paramEntity.sendMsgBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips"));
        paramEntity.addPicBtnDownloadAppTips = paramCursor.getString(paramCursor.getColumnIndex("addPicBtnDownloadAppTips"));
        paramEntity.tribeAppDownloadPageUrl = paramCursor.getString(paramCursor.getColumnIndex("tribeAppDownloadPageUrl"));
        paramEntity.nearbyNowDataBytes = paramCursor.getBlob(paramCursor.getColumnIndex("nearbyNowDataBytes"));
        paramEntity.guideAppNowTip = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTip"));
        paramEntity.guideAppNowTipLeftBtn = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipLeftBtn"));
        paramEntity.guideAppNowTipRightBtnInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled"));
        paramEntity.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled"));
        paramEntity.guideAppNowPackage = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowPackage"));
        paramEntity.guideAppNowJumpUri = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowJumpUri"));
        paramEntity.guideAppNowDownloadUrl = paramCursor.getString(paramCursor.getColumnIndex("guideAppNowDownloadUrl"));
        return paramEntity;
        paramBoolean = false;
        break;
        label2162:
        paramBoolean = false;
        break label857;
        label2167:
        paramBoolean = false;
        break label882;
        label2172:
        paramBoolean = false;
        break label961;
        paramBoolean = false;
        break label1499;
        paramBoolean = false;
        break label1696;
        paramBoolean = false;
        break label1722;
        paramBoolean = false;
        break label1786;
        paramBoolean = false;
        break label1812;
        paramBoolean = false;
        break label1895;
      }
    }
    int i = paramCursor.getColumnIndex("tinyId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tinyId", Long.TYPE));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label6232;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
      label2282:
      i = paramCursor.getColumnIndex("nowId");
      if (i != -1) {
        break label6247;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nowId", Long.TYPE));
      label2317:
      i = paramCursor.getColumnIndex("nowUserType");
      if (i != -1) {
        break label6262;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nowUserType", Integer.TYPE));
      label2352:
      i = paramCursor.getColumnIndex("strRemark");
      if (i != -1) {
        break label6277;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strRemark", String.class));
      label2387:
      i = paramCursor.getColumnIndex("nickname");
      if (i != -1) {
        break label6292;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nickname", String.class));
      label2422:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label6307;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gender", Byte.TYPE));
      label2457:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label6323;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Integer.TYPE));
      label2492:
      i = paramCursor.getColumnIndex("birthday");
      if (i != -1) {
        break label6338;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("birthday", Integer.TYPE));
      label2527:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label6353;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellation", Byte.TYPE));
      label2562:
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label6369;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("distance", String.class));
      label2597:
      i = paramCursor.getColumnIndex("timeDiff");
      if (i != -1) {
        break label6384;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timeDiff", String.class));
      label2632:
      i = paramCursor.getColumnIndex("aioDistanceAndTime");
      if (i != -1) {
        break label6399;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("aioDistanceAndTime", String.class));
      label2667:
      i = paramCursor.getColumnIndex("likeCount");
      if (i != -1) {
        break label6414;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("likeCount", Integer.TYPE));
      label2702:
      i = paramCursor.getColumnIndex("likeCountInc");
      if (i != -1) {
        break label6429;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("likeCountInc", Integer.TYPE));
      label2737:
      i = paramCursor.getColumnIndex("oldPhotoCount");
      if (i != -1) {
        break label6444;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("oldPhotoCount", Integer.TYPE));
      label2772:
      i = paramCursor.getColumnIndex("dateInfo");
      if (i != -1) {
        break label6459;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dateInfo", [B.class));
      label2807:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label6474;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ulShowControl", Long.TYPE));
      label2842:
      i = paramCursor.getColumnIndex("xuanYan");
      if (i != -1) {
        break label6489;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("xuanYan", [B.class));
      label2877:
      i = paramCursor.getColumnIndex("maritalStatus");
      if (i != -1) {
        break label6504;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maritalStatus", Byte.TYPE));
      label2912:
      i = paramCursor.getColumnIndex("job");
      if (i != -1) {
        break label6520;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("job", Integer.TYPE));
      label2947:
      i = paramCursor.getColumnIndex("company");
      if (i != -1) {
        break label6535;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("company", String.class));
      label2982:
      i = paramCursor.getColumnIndex("college");
      if (i != -1) {
        break label6550;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("college", String.class));
      label3017:
      i = paramCursor.getColumnIndex("hometownCountry");
      if (i != -1) {
        break label6565;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownCountry", String.class));
      label3052:
      i = paramCursor.getColumnIndex("hometownProvice");
      if (i != -1) {
        break label6580;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownProvice", String.class));
      label3087:
      i = paramCursor.getColumnIndex("hometownCity");
      if (i != -1) {
        break label6595;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownCity", String.class));
      label3122:
      i = paramCursor.getColumnIndex("hometownDistrict");
      if (i != -1) {
        break label6610;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownDistrict", String.class));
      label3157:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label6625;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCookies", [B.class));
      label3192:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label6640;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bVoted", Byte.TYPE));
      label3227:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label6656;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedPreviewTime", Long.TYPE));
      label3262:
      i = paramCursor.getColumnIndex("qzoneFeed");
      if (i != -1) {
        break label6671;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneFeed", String.class));
      label3297:
      i = paramCursor.getColumnIndex("qzoneName");
      if (i != -1) {
        break label6686;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneName", String.class));
      label3332:
      i = paramCursor.getColumnIndex("qzonePicUrl_1");
      if (i != -1) {
        break label6701;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzonePicUrl_1", String.class));
      label3367:
      i = paramCursor.getColumnIndex("qzonePicUrl_2");
      if (i != -1) {
        break label6716;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzonePicUrl_2", String.class));
      label3402:
      i = paramCursor.getColumnIndex("qzonePicUrl_3");
      if (i != -1) {
        break label6731;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzonePicUrl_3", String.class));
      label3437:
      i = paramCursor.getColumnIndex("isPhotoUseCache");
      if (i != -1) {
        break label6746;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label6773;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vSeed", [B.class));
      label3507:
      i = paramCursor.getColumnIndex("vTempChatSig");
      if (i != -1) {
        break label6788;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vTempChatSig", [B.class));
      label3542:
      i = paramCursor.getColumnIndex("vGroupList");
      if (i != -1) {
        break label6803;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vGroupList", [B.class));
      label3577:
      i = paramCursor.getColumnIndex("nearbyInfo");
      if (i != -1) {
        break label6818;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nearbyInfo", [B.class));
      label3612:
      i = paramCursor.getColumnIndex("vActivityList");
      if (i != -1) {
        break label6833;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vActivityList", [B.class));
      label3647:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label6848;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lUserFlag", Long.TYPE));
      label3682:
      i = paramCursor.getColumnIndex("iIsGodFlag");
      if (i != -1) {
        break label6863;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iIsGodFlag", Integer.TYPE));
      label3717:
      i = paramCursor.getColumnIndex("strGodJumpUrl");
      if (i != -1) {
        break label6878;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGodJumpUrl", String.class));
      label3752:
      i = paramCursor.getColumnIndex("mHeartNum");
      if (i != -1) {
        break label6893;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHeartNum", Integer.TYPE));
      label3787:
      i = paramCursor.getColumnIndex("switchQzone");
      if (i != -1) {
        break label6908;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("switchQzone", Boolean.TYPE));
      i = paramCursor.getColumnIndex("switchHobby");
      if (i != -1) {
        break label6935;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("switchHobby", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uiShowControl");
      if (i != -1) {
        break label6962;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uiShowControl", Long.TYPE));
      label3892:
      i = paramCursor.getColumnIndex("userFlag");
      if (i != -1) {
        break label6977;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("userFlag", Long.TYPE));
      label3927:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label6992;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("busiEntry", String.class));
      label3962:
      i = paramCursor.getColumnIndex("godFlag");
      if (i != -1) {
        break label7007;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("godFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label7034;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label4032:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label7049;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strProfileUrl", String.class));
      label4069:
      i = paramCursor.getColumnIndex("lastUpdateNickTime");
      if (i != -1) {
        break label7064;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastUpdateNickTime", Long.TYPE));
      label4106:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label7079;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("favoriteSource", Integer.TYPE));
      label4143:
      i = paramCursor.getColumnIndex("switchGiftVisible");
      if (i != -1) {
        break label7094;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("switchGiftVisible", Long.TYPE));
      label4180:
      i = paramCursor.getColumnIndex("vGiftInfo");
      if (i != -1) {
        break label7109;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vGiftInfo", [B.class));
      label4217:
      i = paramCursor.getColumnIndex("sayHelloFlag");
      if (i != -1) {
        break label7124;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sayHelloFlag", Integer.TYPE));
      label4254:
      i = paramCursor.getColumnIndex("charm");
      if (i != -1) {
        break label7139;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("charm", Long.TYPE));
      label4291:
      i = paramCursor.getColumnIndex("charmLevel");
      if (i != -1) {
        break label7154;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("charmLevel", Integer.TYPE));
      label4328:
      i = paramCursor.getColumnIndex("nextThreshold");
      if (i != -1) {
        break label7169;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nextThreshold", Integer.TYPE));
      label4365:
      i = paramCursor.getColumnIndex("curThreshold");
      if (i != -1) {
        break label7184;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("curThreshold", Integer.TYPE));
      label4402:
      i = paramCursor.getColumnIndex("profPercent");
      if (i != -1) {
        break label7199;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("profPercent", Integer.TYPE));
      label4439:
      i = paramCursor.getColumnIndex("taskFinished");
      if (i != -1) {
        break label7214;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("taskFinished", Integer.TYPE));
      label4476:
      i = paramCursor.getColumnIndex("taskTotal");
      if (i != -1) {
        break label7229;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("taskTotal", Integer.TYPE));
      label4513:
      i = paramCursor.getColumnIndex("hiWanInfo");
      if (i != -1) {
        break label7244;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hiWanInfo", String.class));
      label4550:
      i = paramCursor.getColumnIndex("commonLabelString");
      if (i != -1) {
        break label7259;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("commonLabelString", String.class));
      label4587:
      i = paramCursor.getColumnIndex("tagFlag");
      if (i != -1) {
        break label7274;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tagFlag", Long.TYPE));
      label4624:
      i = paramCursor.getColumnIndex("tagInfo");
      if (i != -1) {
        break label7289;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tagInfo", String.class));
      label4661:
      i = paramCursor.getColumnIndex("picInfo");
      if (i != -1) {
        break label7304;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("picInfo", String.class));
      label4698:
      i = paramCursor.getColumnIndex("videoDetails");
      if (i != -1) {
        break label7319;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("videoDetails", String.class));
      label4735:
      i = paramCursor.getColumnIndex("strFreshNewsInfo");
      if (i != -1) {
        break label7334;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strFreshNewsInfo", String.class));
      label4772:
      i = paramCursor.getColumnIndex("strHotChatInfo");
      if (i != -1) {
        break label7349;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHotChatInfo", String.class));
      label4809:
      i = paramCursor.getColumnIndex("uRoomid");
      if (i != -1) {
        break label7364;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uRoomid", Long.TYPE));
      label4846:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label7379;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strVoteLimitedNotice", String.class));
      label4883:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label7394;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label4920:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label7409;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label4957:
      i = paramCursor.getColumnIndex("collegeId");
      if (i != -1) {
        break label7424;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("collegeId", Long.TYPE));
      label4994:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label7439;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bVideoHeadUrl");
      if (i != -1) {
        break label7466;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bVideoHeadUrl", String.class));
      label5068:
      i = paramCursor.getColumnIndex("faceScoreWordingColor");
      if (i != -1) {
        break label7481;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
      label5105:
      i = paramCursor.getColumnIndex("faceScoreWording");
      if (i != -1) {
        break label7496;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreWording", String.class));
      label5142:
      i = paramCursor.getColumnIndex("faceScoreTailWordingColor");
      if (i != -1) {
        break label7511;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
      label5179:
      i = paramCursor.getColumnIndex("faceScoreTailWording");
      if (i != -1) {
        break label7526;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreTailWording", String.class));
      label5216:
      i = paramCursor.getColumnIndex("faceScoreIconUrl");
      if (i != -1) {
        break label7541;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreIconUrl", String.class));
      label5253:
      i = paramCursor.getColumnIndex("entryAbility");
      if (i != -1) {
        break label7556;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("entryAbility", Integer.TYPE));
      label5290:
      i = paramCursor.getColumnIndex("strLevelType");
      if (i != -1) {
        break label7571;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLevelType", String.class));
      label5327:
      i = paramCursor.getColumnIndex("maskMsgFlag");
      if (i != -1) {
        break label7586;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maskMsgFlag", Integer.TYPE));
      label5364:
      i = paramCursor.getColumnIndex("isForbidSendMsg");
      if (i != -1) {
        break label7601;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsg");
      if (i != -1) {
        break label7628;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTips");
      if (i != -1) {
        break label7655;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendMsgBtnTips", String.class));
      label5475:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTips");
      if (i != -1) {
        break label7670;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendGiftBtnTips", String.class));
      label5512:
      i = paramCursor.getColumnIndex("isForbidSendMsgForTribar");
      if (i != -1) {
        break label7685;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar");
      if (i != -1) {
        break label7712;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
      if (i != -1) {
        break label7739;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
      label5623:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
      if (i != -1) {
        break label7754;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
      label5660:
      i = paramCursor.getColumnIndex("highScoreNum");
      if (i != -1) {
        break label7769;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("highScoreNum", Integer.TYPE));
      label5697:
      i = paramCursor.getColumnIndex("mHasStory");
      if (i != -1) {
        break label7784;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHasStory", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQStoryData");
      if (i != -1) {
        break label7811;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mQQStoryData", [B.class));
      label5771:
      i = paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
      if (i != -1) {
        break label7826;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips");
      if (i != -1) {
        break label7854;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
      label5845:
      i = paramCursor.getColumnIndex("addPicBtnDownloadAppTips");
      if (i != -1) {
        break label7869;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addPicBtnDownloadAppTips", String.class));
      label5882:
      i = paramCursor.getColumnIndex("tribeAppDownloadPageUrl");
      if (i != -1) {
        break label7884;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tribeAppDownloadPageUrl", String.class));
      label5919:
      i = paramCursor.getColumnIndex("nearbyNowDataBytes");
      if (i != -1) {
        break label7899;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nearbyNowDataBytes", [B.class));
      label5956:
      i = paramCursor.getColumnIndex("guideAppNowTip");
      if (i != -1) {
        break label7914;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTip", String.class));
      label5993:
      i = paramCursor.getColumnIndex("guideAppNowTipLeftBtn");
      if (i != -1) {
        break label7929;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTipLeftBtn", String.class));
      label6030:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled");
      if (i != -1) {
        break label7944;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTipRightBtnInstalled", String.class));
      label6067:
      i = paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled");
      if (i != -1) {
        break label7959;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTipRightBtnNotInstalled", String.class));
      label6104:
      i = paramCursor.getColumnIndex("guideAppNowPackage");
      if (i != -1) {
        break label7974;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowPackage", String.class));
      label6141:
      i = paramCursor.getColumnIndex("guideAppNowJumpUri");
      if (i != -1) {
        break label7989;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowJumpUri", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("guideAppNowDownloadUrl");
      if (i != -1) {
        break label8004;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowDownloadUrl", String.class));
      return paramEntity;
      paramEntity.tinyId = paramCursor.getLong(i);
      break;
      label6232:
      paramEntity.uin = paramCursor.getString(i);
      break label2282;
      label6247:
      paramEntity.nowId = paramCursor.getLong(i);
      break label2317;
      label6262:
      paramEntity.nowUserType = paramCursor.getInt(i);
      break label2352;
      label6277:
      paramEntity.strRemark = paramCursor.getString(i);
      break label2387;
      label6292:
      paramEntity.nickname = paramCursor.getString(i);
      break label2422;
      label6307:
      paramEntity.gender = ((byte)paramCursor.getShort(i));
      break label2457;
      label6323:
      paramEntity.age = paramCursor.getInt(i);
      break label2492;
      label6338:
      paramEntity.birthday = paramCursor.getInt(i);
      break label2527;
      label6353:
      paramEntity.constellation = ((byte)paramCursor.getShort(i));
      break label2562;
      label6369:
      paramEntity.distance = paramCursor.getString(i);
      break label2597;
      label6384:
      paramEntity.timeDiff = paramCursor.getString(i);
      break label2632;
      label6399:
      paramEntity.aioDistanceAndTime = paramCursor.getString(i);
      break label2667;
      label6414:
      paramEntity.likeCount = paramCursor.getInt(i);
      break label2702;
      label6429:
      paramEntity.likeCountInc = paramCursor.getInt(i);
      break label2737;
      label6444:
      paramEntity.oldPhotoCount = paramCursor.getInt(i);
      break label2772;
      label6459:
      paramEntity.dateInfo = paramCursor.getBlob(i);
      break label2807;
      label6474:
      paramEntity.ulShowControl = paramCursor.getLong(i);
      break label2842;
      label6489:
      paramEntity.xuanYan = paramCursor.getBlob(i);
      break label2877;
      label6504:
      paramEntity.maritalStatus = ((byte)paramCursor.getShort(i));
      break label2912;
      label6520:
      paramEntity.job = paramCursor.getInt(i);
      break label2947;
      label6535:
      paramEntity.company = paramCursor.getString(i);
      break label2982;
      label6550:
      paramEntity.college = paramCursor.getString(i);
      break label3017;
      label6565:
      paramEntity.hometownCountry = paramCursor.getString(i);
      break label3052;
      label6580:
      paramEntity.hometownProvice = paramCursor.getString(i);
      break label3087;
      label6595:
      paramEntity.hometownCity = paramCursor.getString(i);
      break label3122;
      label6610:
      paramEntity.hometownDistrict = paramCursor.getString(i);
      break label3157;
      label6625:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label3192;
      label6640:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label3227;
      label6656:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label3262;
      label6671:
      paramEntity.qzoneFeed = paramCursor.getString(i);
      break label3297;
      label6686:
      paramEntity.qzoneName = paramCursor.getString(i);
      break label3332;
      label6701:
      paramEntity.qzonePicUrl_1 = paramCursor.getString(i);
      break label3367;
      label6716:
      paramEntity.qzonePicUrl_2 = paramCursor.getString(i);
      break label3402;
      label6731:
      paramEntity.qzonePicUrl_3 = paramCursor.getString(i);
      break label3437;
      label6746:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isPhotoUseCache = paramBoolean;
        break;
      }
      label6773:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label3507;
      label6788:
      paramEntity.vTempChatSig = paramCursor.getBlob(i);
      break label3542;
      label6803:
      paramEntity.vGroupList = paramCursor.getBlob(i);
      break label3577;
      label6818:
      paramEntity.nearbyInfo = paramCursor.getBlob(i);
      break label3612;
      label6833:
      paramEntity.vActivityList = paramCursor.getBlob(i);
      break label3647;
      label6848:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label3682;
      label6863:
      paramEntity.iIsGodFlag = paramCursor.getInt(i);
      break label3717;
      label6878:
      paramEntity.strGodJumpUrl = paramCursor.getString(i);
      break label3752;
      label6893:
      paramEntity.mHeartNum = paramCursor.getInt(i);
      break label3787;
      label6908:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.switchQzone = paramBoolean;
        break;
      }
      label6935:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.switchHobby = paramBoolean;
        break;
      }
      label6962:
      paramEntity.uiShowControl = paramCursor.getLong(i);
      break label3892;
      label6977:
      paramEntity.userFlag = paramCursor.getLong(i);
      break label3927;
      label6992:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label3962;
      label7007:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.godFlag = paramBoolean;
        break;
      }
      label7034:
      paramEntity.nLastGameFlag = paramCursor.getInt(i);
      break label4032;
      label7049:
      paramEntity.strProfileUrl = paramCursor.getString(i);
      break label4069;
      label7064:
      paramEntity.lastUpdateNickTime = paramCursor.getLong(i);
      break label4106;
      label7079:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label4143;
      label7094:
      paramEntity.switchGiftVisible = paramCursor.getLong(i);
      break label4180;
      label7109:
      paramEntity.vGiftInfo = paramCursor.getBlob(i);
      break label4217;
      label7124:
      paramEntity.sayHelloFlag = paramCursor.getInt(i);
      break label4254;
      label7139:
      paramEntity.charm = paramCursor.getLong(i);
      break label4291;
      label7154:
      paramEntity.charmLevel = paramCursor.getInt(i);
      break label4328;
      label7169:
      paramEntity.nextThreshold = paramCursor.getInt(i);
      break label4365;
      label7184:
      paramEntity.curThreshold = paramCursor.getInt(i);
      break label4402;
      label7199:
      paramEntity.profPercent = paramCursor.getInt(i);
      break label4439;
      label7214:
      paramEntity.taskFinished = paramCursor.getInt(i);
      break label4476;
      label7229:
      paramEntity.taskTotal = paramCursor.getInt(i);
      break label4513;
      label7244:
      paramEntity.hiWanInfo = paramCursor.getString(i);
      break label4550;
      label7259:
      paramEntity.commonLabelString = paramCursor.getString(i);
      break label4587;
      label7274:
      paramEntity.tagFlag = paramCursor.getLong(i);
      break label4624;
      label7289:
      paramEntity.tagInfo = paramCursor.getString(i);
      break label4661;
      label7304:
      paramEntity.picInfo = paramCursor.getString(i);
      break label4698;
      label7319:
      paramEntity.videoDetails = paramCursor.getString(i);
      break label4735;
      label7334:
      paramEntity.strFreshNewsInfo = paramCursor.getString(i);
      break label4772;
      label7349:
      paramEntity.strHotChatInfo = paramCursor.getString(i);
      break label4809;
      label7364:
      paramEntity.uRoomid = paramCursor.getLong(i);
      break label4846;
      label7379:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label4883;
      label7394:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label4920;
      label7409:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label4957;
      label7424:
      paramEntity.collegeId = paramCursor.getLong(i);
      break label4994;
      label7439:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.videoHeadFlag = paramBoolean;
        break;
      }
      label7466:
      paramEntity.bVideoHeadUrl = paramCursor.getString(i);
      break label5068;
      label7481:
      paramEntity.faceScoreWordingColor = paramCursor.getInt(i);
      break label5105;
      label7496:
      paramEntity.faceScoreWording = paramCursor.getString(i);
      break label5142;
      label7511:
      paramEntity.faceScoreTailWordingColor = paramCursor.getInt(i);
      break label5179;
      label7526:
      paramEntity.faceScoreTailWording = paramCursor.getString(i);
      break label5216;
      label7541:
      paramEntity.faceScoreIconUrl = paramCursor.getString(i);
      break label5253;
      label7556:
      paramEntity.entryAbility = paramCursor.getInt(i);
      break label5290;
      label7571:
      paramEntity.strLevelType = paramCursor.getString(i);
      break label5327;
      label7586:
      paramEntity.maskMsgFlag = paramCursor.getInt(i);
      break label5364;
      label7601:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendMsg = paramBoolean;
        break;
      }
      label7628:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendGiftMsg = paramBoolean;
        break;
      }
      label7655:
      paramEntity.disableSendMsgBtnTips = paramCursor.getString(i);
      break label5475;
      label7670:
      paramEntity.disableSendGiftBtnTips = paramCursor.getString(i);
      break label5512;
      label7685:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendMsgForTribar = paramBoolean;
        break;
      }
      label7712:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendGiftMsgForTribar = paramBoolean;
        break;
      }
      label7739:
      paramEntity.disableSendMsgBtnTipsForTribar = paramCursor.getString(i);
      break label5623;
      label7754:
      paramEntity.disableSendGiftBtnTipsForTribar = paramCursor.getString(i);
      break label5660;
      label7769:
      paramEntity.highScoreNum = paramCursor.getInt(i);
      break label5697;
      label7784:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mHasStory = paramBoolean;
        break;
      }
      label7811:
      paramEntity.mQQStoryData = paramCursor.getBlob(i);
      break label5771;
      label7826:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isSendMsgBtnDownloadAppOpen = paramBoolean;
        break;
      }
      label7854:
      paramEntity.sendMsgBtnDownloadAppTips = paramCursor.getString(i);
      break label5845;
      label7869:
      paramEntity.addPicBtnDownloadAppTips = paramCursor.getString(i);
      break label5882;
      label7884:
      paramEntity.tribeAppDownloadPageUrl = paramCursor.getString(i);
      break label5919;
      label7899:
      paramEntity.nearbyNowDataBytes = paramCursor.getBlob(i);
      break label5956;
      label7914:
      paramEntity.guideAppNowTip = paramCursor.getString(i);
      break label5993;
      label7929:
      paramEntity.guideAppNowTipLeftBtn = paramCursor.getString(i);
      break label6030;
      label7944:
      paramEntity.guideAppNowTipRightBtnInstalled = paramCursor.getString(i);
      break label6067;
      label7959:
      paramEntity.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(i);
      break label6104;
      label7974:
      paramEntity.guideAppNowPackage = paramCursor.getString(i);
      break label6141;
      label7989:
      paramEntity.guideAppNowJumpUri = paramCursor.getString(i);
    }
    label8004:
    paramEntity.guideAppNowDownloadUrl = paramCursor.getString(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (NearbyPeopleCard)paramEntity;
    paramContentValues.put("tinyId", Long.valueOf(paramEntity.tinyId));
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("nowId", Long.valueOf(paramEntity.nowId));
    paramContentValues.put("nowUserType", Integer.valueOf(paramEntity.nowUserType));
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
    paramContentValues.put("guideAppNowTip", paramEntity.guideAppNowTip);
    paramContentValues.put("guideAppNowTipLeftBtn", paramEntity.guideAppNowTipLeftBtn);
    paramContentValues.put("guideAppNowTipRightBtnInstalled", paramEntity.guideAppNowTipRightBtnInstalled);
    paramContentValues.put("guideAppNowTipRightBtnNotInstalled", paramEntity.guideAppNowTipRightBtnNotInstalled);
    paramContentValues.put("guideAppNowPackage", paramEntity.guideAppNowPackage);
    paramContentValues.put("guideAppNowJumpUri", paramEntity.guideAppNowJumpUri);
    paramContentValues.put("guideAppNowDownloadUrl", paramEntity.guideAppNowDownloadUrl);
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,nowId INTEGER ,nowUserType INTEGER ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,maskMsgFlag INTEGER ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB ,guideAppNowTip TEXT ,guideAppNowTipLeftBtn TEXT ,guideAppNowTipRightBtnInstalled TEXT ,guideAppNowTipRightBtnNotInstalled TEXT ,guideAppNowPackage TEXT ,guideAppNowJumpUri TEXT ,guideAppNowDownloadUrl TEXT)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.NearbyPeopleCardDao
 * JD-Core Version:    0.7.0.1
 */