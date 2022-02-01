package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public class NearbyPeopleCardDao
  extends OGAbstractDao
{
  public NearbyPeopleCardDao()
  {
    this.columnLen = 117;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
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
      paramEntity.sign = paramCursor.getString(paramCursor.getColumnIndex("sign"));
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
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isPhotoUseCache"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
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
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("switchQzone"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.switchQzone = paramBoolean;
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.switchHobby = paramBoolean;
      paramEntity.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
      paramEntity.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
      paramEntity.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
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
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
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
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsg"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isForbidSendMsg = paramBoolean;
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsg"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isForbidSendGiftMsg = paramBoolean;
      paramEntity.disableSendMsgBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTips"));
      paramEntity.disableSendGiftBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTips"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsgForTribar"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isForbidSendMsgForTribar = paramBoolean;
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isForbidSendGiftMsgForTribar = paramBoolean;
      paramEntity.disableSendMsgBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
      paramEntity.disableSendGiftBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
      paramEntity.highScoreNum = paramCursor.getInt(paramCursor.getColumnIndex("highScoreNum"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mHasStory"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.mHasStory = paramBoolean;
      paramEntity.mQQStoryData = paramCursor.getBlob(paramCursor.getColumnIndex("mQQStoryData"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
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
      paramEntity.guideVerifiedDialogTitle = paramCursor.getString(paramCursor.getColumnIndex("guideVerifiedDialogTitle"));
      paramEntity.guideVerifiedDialogRightBtnText = paramCursor.getString(paramCursor.getColumnIndex("guideVerifiedDialogRightBtnText"));
      paramEntity.firstOfficialMsg = paramCursor.getString(paramCursor.getColumnIndex("firstOfficialMsg"));
      paramEntity.unverifyGrayTips = paramCursor.getString(paramCursor.getColumnIndex("unverifyGrayTips"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isVerified"))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isVerified = paramBoolean;
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("tinyId");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tinyId", Long.TYPE));
    } else {
      paramEntity.tinyId = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", String.class));
    } else {
      paramEntity.uin = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("nowId");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nowId", Long.TYPE));
    } else {
      paramEntity.nowId = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("nowUserType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nowUserType", Integer.TYPE));
    } else {
      paramEntity.nowUserType = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("strRemark");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strRemark", String.class));
    } else {
      paramEntity.strRemark = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("nickname");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nickname", String.class));
    } else {
      paramEntity.nickname = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("gender");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("gender", Byte.TYPE));
    } else {
      paramEntity.gender = ((byte)paramCursor.getShort(i));
    }
    i = paramCursor.getColumnIndex("age");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("age", Integer.TYPE));
    } else {
      paramEntity.age = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("birthday");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("birthday", Integer.TYPE));
    } else {
      paramEntity.birthday = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("sign");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sign", String.class));
    } else {
      paramEntity.sign = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("constellation");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("constellation", Byte.TYPE));
    } else {
      paramEntity.constellation = ((byte)paramCursor.getShort(i));
    }
    i = paramCursor.getColumnIndex("distance");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("distance", String.class));
    } else {
      paramEntity.distance = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("timeDiff");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timeDiff", String.class));
    } else {
      paramEntity.timeDiff = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("aioDistanceAndTime");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("aioDistanceAndTime", String.class));
    } else {
      paramEntity.aioDistanceAndTime = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("likeCount");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("likeCount", Integer.TYPE));
    } else {
      paramEntity.likeCount = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("likeCountInc");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("likeCountInc", Integer.TYPE));
    } else {
      paramEntity.likeCountInc = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("oldPhotoCount");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("oldPhotoCount", Integer.TYPE));
    } else {
      paramEntity.oldPhotoCount = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("dateInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("dateInfo", [B.class));
    } else {
      paramEntity.dateInfo = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("ulShowControl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ulShowControl", Long.TYPE));
    } else {
      paramEntity.ulShowControl = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("xuanYan");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("xuanYan", [B.class));
    } else {
      paramEntity.xuanYan = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("maritalStatus");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maritalStatus", Byte.TYPE));
    } else {
      paramEntity.maritalStatus = ((byte)paramCursor.getShort(i));
    }
    i = paramCursor.getColumnIndex("job");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("job", Integer.TYPE));
    } else {
      paramEntity.job = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("company");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("company", String.class));
    } else {
      paramEntity.company = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("college");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("college", String.class));
    } else {
      paramEntity.college = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("hometownCountry");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownCountry", String.class));
    } else {
      paramEntity.hometownCountry = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("hometownProvice");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownProvice", String.class));
    } else {
      paramEntity.hometownProvice = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("hometownCity");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownCity", String.class));
    } else {
      paramEntity.hometownCity = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("hometownDistrict");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hometownDistrict", String.class));
    } else {
      paramEntity.hometownDistrict = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("vCookies");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vCookies", [B.class));
    } else {
      paramEntity.vCookies = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("bVoted");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bVoted", Byte.TYPE));
    } else {
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
    }
    i = paramCursor.getColumnIndex("feedPreviewTime");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("feedPreviewTime", Long.TYPE));
    } else {
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("qzoneFeed");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneFeed", String.class));
    } else {
      paramEntity.qzoneFeed = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("qzoneName");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzoneName", String.class));
    } else {
      paramEntity.qzoneName = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("qzonePicUrl_1");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzonePicUrl_1", String.class));
    } else {
      paramEntity.qzonePicUrl_1 = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("qzonePicUrl_2");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzonePicUrl_2", String.class));
    } else {
      paramEntity.qzonePicUrl_2 = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("qzonePicUrl_3");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("qzonePicUrl_3", String.class));
    } else {
      paramEntity.qzonePicUrl_3 = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("isPhotoUseCache");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isPhotoUseCache = paramBoolean;
    }
    i = paramCursor.getColumnIndex("vSeed");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vSeed", [B.class));
    } else {
      paramEntity.vSeed = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("vTempChatSig");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vTempChatSig", [B.class));
    } else {
      paramEntity.vTempChatSig = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("vGroupList");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vGroupList", [B.class));
    } else {
      paramEntity.vGroupList = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("nearbyInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nearbyInfo", [B.class));
    } else {
      paramEntity.nearbyInfo = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("vActivityList");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vActivityList", [B.class));
    } else {
      paramEntity.vActivityList = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("lUserFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lUserFlag", Long.TYPE));
    } else {
      paramEntity.lUserFlag = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("iIsGodFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iIsGodFlag", Integer.TYPE));
    } else {
      paramEntity.iIsGodFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("strGodJumpUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGodJumpUrl", String.class));
    } else {
      paramEntity.strGodJumpUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("mHeartNum");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHeartNum", Integer.TYPE));
    } else {
      paramEntity.mHeartNum = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("switchQzone");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("switchQzone", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.switchQzone = paramBoolean;
    }
    i = paramCursor.getColumnIndex("switchHobby");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("switchHobby", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.switchHobby = paramBoolean;
    }
    i = paramCursor.getColumnIndex("uiShowControl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uiShowControl", Long.TYPE));
    } else {
      paramEntity.uiShowControl = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("userFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("userFlag", Long.TYPE));
    } else {
      paramEntity.userFlag = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("busiEntry");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("busiEntry", String.class));
    } else {
      paramEntity.busiEntry = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("godFlag");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("godFlag", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.godFlag = paramBoolean;
    }
    i = paramCursor.getColumnIndex("nLastGameFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nLastGameFlag", Integer.TYPE));
    } else {
      paramEntity.nLastGameFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("strProfileUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strProfileUrl", String.class));
    } else {
      paramEntity.strProfileUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("lastUpdateNickTime");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lastUpdateNickTime", Long.TYPE));
    } else {
      paramEntity.lastUpdateNickTime = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("favoriteSource");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("favoriteSource", Integer.TYPE));
    } else {
      paramEntity.favoriteSource = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("switchGiftVisible");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("switchGiftVisible", Long.TYPE));
    } else {
      paramEntity.switchGiftVisible = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("vGiftInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("vGiftInfo", [B.class));
    } else {
      paramEntity.vGiftInfo = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("sayHelloFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sayHelloFlag", Integer.TYPE));
    } else {
      paramEntity.sayHelloFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("charm");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("charm", Long.TYPE));
    } else {
      paramEntity.charm = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("charmLevel");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("charmLevel", Integer.TYPE));
    } else {
      paramEntity.charmLevel = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("nextThreshold");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nextThreshold", Integer.TYPE));
    } else {
      paramEntity.nextThreshold = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("curThreshold");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("curThreshold", Integer.TYPE));
    } else {
      paramEntity.curThreshold = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("profPercent");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("profPercent", Integer.TYPE));
    } else {
      paramEntity.profPercent = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("taskFinished");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("taskFinished", Integer.TYPE));
    } else {
      paramEntity.taskFinished = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("taskTotal");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("taskTotal", Integer.TYPE));
    } else {
      paramEntity.taskTotal = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("hiWanInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hiWanInfo", String.class));
    } else {
      paramEntity.hiWanInfo = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("commonLabelString");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("commonLabelString", String.class));
    } else {
      paramEntity.commonLabelString = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("tagFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tagFlag", Long.TYPE));
    } else {
      paramEntity.tagFlag = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("tagInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tagInfo", String.class));
    } else {
      paramEntity.tagInfo = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("picInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("picInfo", String.class));
    } else {
      paramEntity.picInfo = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("videoDetails");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("videoDetails", String.class));
    } else {
      paramEntity.videoDetails = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("strFreshNewsInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strFreshNewsInfo", String.class));
    } else {
      paramEntity.strFreshNewsInfo = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("strHotChatInfo");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strHotChatInfo", String.class));
    } else {
      paramEntity.strHotChatInfo = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("uRoomid");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uRoomid", Long.TYPE));
    } else {
      paramEntity.uRoomid = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("strVoteLimitedNotice");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strVoteLimitedNotice", String.class));
    } else {
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("bHaveVotedCnt");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bHaveVotedCnt", Short.TYPE));
    } else {
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
    }
    i = paramCursor.getColumnIndex("bAvailVoteCnt");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bAvailVoteCnt", Short.TYPE));
    } else {
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
    }
    i = paramCursor.getColumnIndex("collegeId");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("collegeId", Long.TYPE));
    } else {
      paramEntity.collegeId = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("videoHeadFlag");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("videoHeadFlag", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.videoHeadFlag = paramBoolean;
    }
    i = paramCursor.getColumnIndex("bVideoHeadUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("bVideoHeadUrl", String.class));
    } else {
      paramEntity.bVideoHeadUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("faceScoreWordingColor");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
    } else {
      paramEntity.faceScoreWordingColor = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("faceScoreWording");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreWording", String.class));
    } else {
      paramEntity.faceScoreWording = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("faceScoreTailWordingColor");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
    } else {
      paramEntity.faceScoreTailWordingColor = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("faceScoreTailWording");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreTailWording", String.class));
    } else {
      paramEntity.faceScoreTailWording = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("faceScoreIconUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("faceScoreIconUrl", String.class));
    } else {
      paramEntity.faceScoreIconUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("entryAbility");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("entryAbility", Integer.TYPE));
    } else {
      paramEntity.entryAbility = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("strLevelType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strLevelType", String.class));
    } else {
      paramEntity.strLevelType = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("maskMsgFlag");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("maskMsgFlag", Integer.TYPE));
    } else {
      paramEntity.maskMsgFlag = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("isForbidSendMsg");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isForbidSendMsg = paramBoolean;
    }
    i = paramCursor.getColumnIndex("isForbidSendGiftMsg");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isForbidSendGiftMsg = paramBoolean;
    }
    i = paramCursor.getColumnIndex("disableSendMsgBtnTips");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendMsgBtnTips", String.class));
    } else {
      paramEntity.disableSendMsgBtnTips = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("disableSendGiftBtnTips");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendGiftBtnTips", String.class));
    } else {
      paramEntity.disableSendGiftBtnTips = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("isForbidSendMsgForTribar");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isForbidSendMsgForTribar = paramBoolean;
    }
    i = paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isForbidSendGiftMsgForTribar = paramBoolean;
    }
    i = paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
    } else {
      paramEntity.disableSendMsgBtnTipsForTribar = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
    } else {
      paramEntity.disableSendGiftBtnTipsForTribar = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("highScoreNum");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("highScoreNum", Integer.TYPE));
    } else {
      paramEntity.highScoreNum = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("mHasStory");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mHasStory", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.mHasStory = paramBoolean;
    }
    i = paramCursor.getColumnIndex("mQQStoryData");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mQQStoryData", [B.class));
    } else {
      paramEntity.mQQStoryData = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
    }
    else
    {
      if (1 == paramCursor.getShort(i)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramEntity.isSendMsgBtnDownloadAppOpen = paramBoolean;
    }
    i = paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
    } else {
      paramEntity.sendMsgBtnDownloadAppTips = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("addPicBtnDownloadAppTips");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("addPicBtnDownloadAppTips", String.class));
    } else {
      paramEntity.addPicBtnDownloadAppTips = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("tribeAppDownloadPageUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tribeAppDownloadPageUrl", String.class));
    } else {
      paramEntity.tribeAppDownloadPageUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("nearbyNowDataBytes");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("nearbyNowDataBytes", [B.class));
    } else {
      paramEntity.nearbyNowDataBytes = paramCursor.getBlob(i);
    }
    i = paramCursor.getColumnIndex("guideAppNowTip");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTip", String.class));
    } else {
      paramEntity.guideAppNowTip = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("guideAppNowTipLeftBtn");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTipLeftBtn", String.class));
    } else {
      paramEntity.guideAppNowTipLeftBtn = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("guideAppNowTipRightBtnInstalled");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTipRightBtnInstalled", String.class));
    } else {
      paramEntity.guideAppNowTipRightBtnInstalled = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("guideAppNowTipRightBtnNotInstalled");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowTipRightBtnNotInstalled", String.class));
    } else {
      paramEntity.guideAppNowTipRightBtnNotInstalled = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("guideAppNowPackage");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowPackage", String.class));
    } else {
      paramEntity.guideAppNowPackage = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("guideAppNowJumpUri");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowJumpUri", String.class));
    } else {
      paramEntity.guideAppNowJumpUri = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("guideAppNowDownloadUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideAppNowDownloadUrl", String.class));
    } else {
      paramEntity.guideAppNowDownloadUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("guideVerifiedDialogTitle");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideVerifiedDialogTitle", String.class));
    } else {
      paramEntity.guideVerifiedDialogTitle = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("guideVerifiedDialogRightBtnText");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("guideVerifiedDialogRightBtnText", String.class));
    } else {
      paramEntity.guideVerifiedDialogRightBtnText = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("firstOfficialMsg");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("firstOfficialMsg", String.class));
    } else {
      paramEntity.firstOfficialMsg = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("unverifyGrayTips");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("unverifyGrayTips", String.class));
    } else {
      paramEntity.unverifyGrayTips = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("isVerified");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isVerified", Boolean.TYPE));
      return paramEntity;
    }
    i = paramCursor.getShort(i);
    paramBoolean = true;
    if (1 != i) {
      paramBoolean = false;
    }
    paramEntity.isVerified = paramBoolean;
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
    paramContentValues.put("sign", paramEntity.sign);
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
    paramContentValues.put("guideVerifiedDialogTitle", paramEntity.guideVerifiedDialogTitle);
    paramContentValues.put("guideVerifiedDialogRightBtnText", paramEntity.guideVerifiedDialogRightBtnText);
    paramContentValues.put("firstOfficialMsg", paramEntity.firstOfficialMsg);
    paramContentValues.put("unverifyGrayTips", paramEntity.unverifyGrayTips);
    paramContentValues.put("isVerified", Boolean.valueOf(paramEntity.isVerified));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,nowId INTEGER ,nowUserType INTEGER ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,sign TEXT ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,maskMsgFlag INTEGER ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB ,guideAppNowTip TEXT ,guideAppNowTipLeftBtn TEXT ,guideAppNowTipRightBtnInstalled TEXT ,guideAppNowTipRightBtnNotInstalled TEXT ,guideAppNowPackage TEXT ,guideAppNowJumpUri TEXT ,guideAppNowDownloadUrl TEXT ,guideVerifiedDialogTitle TEXT ,guideVerifiedDialogRightBtnText TEXT ,firstOfficialMsg TEXT ,unverifyGrayTips TEXT ,isVerified INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.NearbyPeopleCardDao
 * JD-Core Version:    0.7.0.1
 */