package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.NearbyPeopleCard;

public class NearbyPeopleCardDao
  extends OGAbstractDao
{
  public NearbyPeopleCardDao()
  {
    this.a = 101;
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
          break label1972;
        }
        paramBoolean = true;
        label821:
        paramEntity.switchQzone = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("switchHobby"))) {
          break label1977;
        }
        paramBoolean = true;
        label846:
        paramEntity.switchHobby = paramBoolean;
        paramEntity.uiShowControl = paramCursor.getLong(paramCursor.getColumnIndex("uiShowControl"));
        paramEntity.userFlag = paramCursor.getLong(paramCursor.getColumnIndex("userFlag"));
        paramEntity.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("godFlag"))) {
          break label1982;
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
          break label1987;
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
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsg"))) {
          break label1992;
        }
        paramBoolean = true;
        label1639:
        paramEntity.isForbidSendMsg = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsg"))) {
          break label1997;
        }
        paramBoolean = true;
        label1665:
        paramEntity.isForbidSendGiftMsg = paramBoolean;
        paramEntity.disableSendMsgBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTips"));
        paramEntity.disableSendGiftBtnTips = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTips"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendMsgForTribar"))) {
          break label2002;
        }
        paramBoolean = true;
        label1729:
        paramEntity.isForbidSendMsgForTribar = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar"))) {
          break label2007;
        }
        paramBoolean = true;
        label1755:
        paramEntity.isForbidSendGiftMsgForTribar = paramBoolean;
        paramEntity.disableSendMsgBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar"));
        paramEntity.disableSendGiftBtnTipsForTribar = paramCursor.getString(paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar"));
        paramEntity.highScoreNum = paramCursor.getInt(paramCursor.getColumnIndex("highScoreNum"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mHasStory"))) {
          break label2012;
        }
        paramBoolean = true;
        label1838:
        paramEntity.mHasStory = paramBoolean;
        paramEntity.mQQStoryData = paramCursor.getBlob(paramCursor.getColumnIndex("mQQStoryData"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen"))) {
          break label2017;
        }
      }
      label1972:
      label1977:
      label1982:
      label1987:
      label1992:
      label1997:
      label2002:
      label2007:
      label2012:
      label2017:
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
        break label1639;
        paramBoolean = false;
        break label1665;
        paramBoolean = false;
        break label1729;
        paramBoolean = false;
        break label1755;
        paramBoolean = false;
        break label1838;
      }
    }
    int i = paramCursor.getColumnIndex("tinyId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("tinyId", Long.TYPE));
      i = paramCursor.getColumnIndex("uin");
      if (i != -1) {
        break label5672;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      label2092:
      i = paramCursor.getColumnIndex("strRemark");
      if (i != -1) {
        break label5687;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strRemark", String.class));
      label2127:
      i = paramCursor.getColumnIndex("nickname");
      if (i != -1) {
        break label5702;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nickname", String.class));
      label2162:
      i = paramCursor.getColumnIndex("gender");
      if (i != -1) {
        break label5717;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("gender", Byte.TYPE));
      label2197:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label5733;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Integer.TYPE));
      label2232:
      i = paramCursor.getColumnIndex("birthday");
      if (i != -1) {
        break label5748;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("birthday", Integer.TYPE));
      label2267:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label5763;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("constellation", Byte.TYPE));
      label2302:
      i = paramCursor.getColumnIndex("distance");
      if (i != -1) {
        break label5779;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("distance", String.class));
      label2337:
      i = paramCursor.getColumnIndex("timeDiff");
      if (i != -1) {
        break label5794;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timeDiff", String.class));
      label2372:
      i = paramCursor.getColumnIndex("aioDistanceAndTime");
      if (i != -1) {
        break label5809;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("aioDistanceAndTime", String.class));
      label2407:
      i = paramCursor.getColumnIndex("likeCount");
      if (i != -1) {
        break label5824;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("likeCount", Integer.TYPE));
      label2442:
      i = paramCursor.getColumnIndex("likeCountInc");
      if (i != -1) {
        break label5839;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("likeCountInc", Integer.TYPE));
      label2477:
      i = paramCursor.getColumnIndex("oldPhotoCount");
      if (i != -1) {
        break label5854;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("oldPhotoCount", Integer.TYPE));
      label2512:
      i = paramCursor.getColumnIndex("dateInfo");
      if (i != -1) {
        break label5869;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dateInfo", [B.class));
      label2547:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label5884;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ulShowControl", Long.TYPE));
      label2582:
      i = paramCursor.getColumnIndex("xuanYan");
      if (i != -1) {
        break label5899;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("xuanYan", [B.class));
      label2617:
      i = paramCursor.getColumnIndex("maritalStatus");
      if (i != -1) {
        break label5914;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("maritalStatus", Byte.TYPE));
      label2652:
      i = paramCursor.getColumnIndex("job");
      if (i != -1) {
        break label5930;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("job", Integer.TYPE));
      label2687:
      i = paramCursor.getColumnIndex("company");
      if (i != -1) {
        break label5945;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("company", String.class));
      label2722:
      i = paramCursor.getColumnIndex("college");
      if (i != -1) {
        break label5960;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("college", String.class));
      label2757:
      i = paramCursor.getColumnIndex("hometownCountry");
      if (i != -1) {
        break label5975;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownCountry", String.class));
      label2792:
      i = paramCursor.getColumnIndex("hometownProvice");
      if (i != -1) {
        break label5990;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownProvice", String.class));
      label2827:
      i = paramCursor.getColumnIndex("hometownCity");
      if (i != -1) {
        break label6005;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownCity", String.class));
      label2862:
      i = paramCursor.getColumnIndex("hometownDistrict");
      if (i != -1) {
        break label6020;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hometownDistrict", String.class));
      label2897:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label6035;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCookies", [B.class));
      label2932:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label6050;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bVoted", Byte.TYPE));
      label2967:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label6066;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label3002:
      i = paramCursor.getColumnIndex("qzoneFeed");
      if (i != -1) {
        break label6081;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneFeed", String.class));
      label3037:
      i = paramCursor.getColumnIndex("qzoneName");
      if (i != -1) {
        break label6096;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneName", String.class));
      label3072:
      i = paramCursor.getColumnIndex("qzonePicUrl_1");
      if (i != -1) {
        break label6111;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzonePicUrl_1", String.class));
      label3107:
      i = paramCursor.getColumnIndex("qzonePicUrl_2");
      if (i != -1) {
        break label6126;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzonePicUrl_2", String.class));
      label3142:
      i = paramCursor.getColumnIndex("qzonePicUrl_3");
      if (i != -1) {
        break label6141;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzonePicUrl_3", String.class));
      label3177:
      i = paramCursor.getColumnIndex("isPhotoUseCache");
      if (i != -1) {
        break label6156;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isPhotoUseCache", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label6183;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vSeed", [B.class));
      label3247:
      i = paramCursor.getColumnIndex("vTempChatSig");
      if (i != -1) {
        break label6198;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vTempChatSig", [B.class));
      label3282:
      i = paramCursor.getColumnIndex("vGroupList");
      if (i != -1) {
        break label6213;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vGroupList", [B.class));
      label3317:
      i = paramCursor.getColumnIndex("nearbyInfo");
      if (i != -1) {
        break label6228;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nearbyInfo", [B.class));
      label3352:
      i = paramCursor.getColumnIndex("vActivityList");
      if (i != -1) {
        break label6243;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vActivityList", [B.class));
      label3387:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label6258;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lUserFlag", Long.TYPE));
      label3422:
      i = paramCursor.getColumnIndex("iIsGodFlag");
      if (i != -1) {
        break label6273;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iIsGodFlag", Integer.TYPE));
      label3457:
      i = paramCursor.getColumnIndex("strGodJumpUrl");
      if (i != -1) {
        break label6288;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGodJumpUrl", String.class));
      label3492:
      i = paramCursor.getColumnIndex("mHeartNum");
      if (i != -1) {
        break label6303;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mHeartNum", Integer.TYPE));
      label3527:
      i = paramCursor.getColumnIndex("switchQzone");
      if (i != -1) {
        break label6318;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("switchQzone", Boolean.TYPE));
      i = paramCursor.getColumnIndex("switchHobby");
      if (i != -1) {
        break label6345;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("switchHobby", Boolean.TYPE));
      i = paramCursor.getColumnIndex("uiShowControl");
      if (i != -1) {
        break label6372;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uiShowControl", Long.TYPE));
      label3632:
      i = paramCursor.getColumnIndex("userFlag");
      if (i != -1) {
        break label6387;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("userFlag", Long.TYPE));
      label3667:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label6402;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("busiEntry", String.class));
      label3702:
      i = paramCursor.getColumnIndex("godFlag");
      if (i != -1) {
        break label6417;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("godFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label6444;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label3772:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label6459;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strProfileUrl", String.class));
      label3807:
      i = paramCursor.getColumnIndex("lastUpdateNickTime");
      if (i != -1) {
        break label6474;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastUpdateNickTime", Long.TYPE));
      label3842:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label6489;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label3879:
      i = paramCursor.getColumnIndex("switchGiftVisible");
      if (i != -1) {
        break label6504;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("switchGiftVisible", Long.TYPE));
      label3916:
      i = paramCursor.getColumnIndex("vGiftInfo");
      if (i != -1) {
        break label6519;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vGiftInfo", [B.class));
      label3953:
      i = paramCursor.getColumnIndex("sayHelloFlag");
      if (i != -1) {
        break label6534;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sayHelloFlag", Integer.TYPE));
      label3990:
      i = paramCursor.getColumnIndex("charm");
      if (i != -1) {
        break label6549;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("charm", Long.TYPE));
      label4027:
      i = paramCursor.getColumnIndex("charmLevel");
      if (i != -1) {
        break label6564;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("charmLevel", Integer.TYPE));
      label4064:
      i = paramCursor.getColumnIndex("nextThreshold");
      if (i != -1) {
        break label6579;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nextThreshold", Integer.TYPE));
      label4101:
      i = paramCursor.getColumnIndex("curThreshold");
      if (i != -1) {
        break label6594;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("curThreshold", Integer.TYPE));
      label4138:
      i = paramCursor.getColumnIndex("profPercent");
      if (i != -1) {
        break label6609;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("profPercent", Integer.TYPE));
      label4175:
      i = paramCursor.getColumnIndex("taskFinished");
      if (i != -1) {
        break label6624;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("taskFinished", Integer.TYPE));
      label4212:
      i = paramCursor.getColumnIndex("taskTotal");
      if (i != -1) {
        break label6639;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("taskTotal", Integer.TYPE));
      label4249:
      i = paramCursor.getColumnIndex("hiWanInfo");
      if (i != -1) {
        break label6654;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hiWanInfo", String.class));
      label4286:
      i = paramCursor.getColumnIndex("commonLabelString");
      if (i != -1) {
        break label6669;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("commonLabelString", String.class));
      label4323:
      i = paramCursor.getColumnIndex("tagFlag");
      if (i != -1) {
        break label6684;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tagFlag", Long.TYPE));
      label4360:
      i = paramCursor.getColumnIndex("tagInfo");
      if (i != -1) {
        break label6699;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tagInfo", String.class));
      label4397:
      i = paramCursor.getColumnIndex("picInfo");
      if (i != -1) {
        break label6714;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("picInfo", String.class));
      label4434:
      i = paramCursor.getColumnIndex("videoDetails");
      if (i != -1) {
        break label6729;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoDetails", String.class));
      label4471:
      i = paramCursor.getColumnIndex("strFreshNewsInfo");
      if (i != -1) {
        break label6744;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strFreshNewsInfo", String.class));
      label4508:
      i = paramCursor.getColumnIndex("strHotChatInfo");
      if (i != -1) {
        break label6759;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strHotChatInfo", String.class));
      label4545:
      i = paramCursor.getColumnIndex("uRoomid");
      if (i != -1) {
        break label6774;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uRoomid", Long.TYPE));
      label4582:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label6789;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label4619:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label6804;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label4656:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label6819;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label4693:
      i = paramCursor.getColumnIndex("collegeId");
      if (i != -1) {
        break label6834;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("collegeId", Long.TYPE));
      label4730:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label6849;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("bVideoHeadUrl");
      if (i != -1) {
        break label6876;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bVideoHeadUrl", String.class));
      label4804:
      i = paramCursor.getColumnIndex("faceScoreWordingColor");
      if (i != -1) {
        break label6891;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreWordingColor", Integer.TYPE));
      label4841:
      i = paramCursor.getColumnIndex("faceScoreWording");
      if (i != -1) {
        break label6906;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreWording", String.class));
      label4878:
      i = paramCursor.getColumnIndex("faceScoreTailWordingColor");
      if (i != -1) {
        break label6921;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreTailWordingColor", Integer.TYPE));
      label4915:
      i = paramCursor.getColumnIndex("faceScoreTailWording");
      if (i != -1) {
        break label6936;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreTailWording", String.class));
      label4952:
      i = paramCursor.getColumnIndex("faceScoreIconUrl");
      if (i != -1) {
        break label6951;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceScoreIconUrl", String.class));
      label4989:
      i = paramCursor.getColumnIndex("entryAbility");
      if (i != -1) {
        break label6966;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("entryAbility", Integer.TYPE));
      label5026:
      i = paramCursor.getColumnIndex("strLevelType");
      if (i != -1) {
        break label6981;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLevelType", String.class));
      label5063:
      i = paramCursor.getColumnIndex("isForbidSendMsg");
      if (i != -1) {
        break label6996;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isForbidSendMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsg");
      if (i != -1) {
        break label7023;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isForbidSendGiftMsg", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTips");
      if (i != -1) {
        break label7050;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("disableSendMsgBtnTips", String.class));
      label5174:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTips");
      if (i != -1) {
        break label7065;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("disableSendGiftBtnTips", String.class));
      label5211:
      i = paramCursor.getColumnIndex("isForbidSendMsgForTribar");
      if (i != -1) {
        break label7080;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isForbidSendMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isForbidSendGiftMsgForTribar");
      if (i != -1) {
        break label7107;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isForbidSendGiftMsgForTribar", Boolean.TYPE));
      i = paramCursor.getColumnIndex("disableSendMsgBtnTipsForTribar");
      if (i != -1) {
        break label7134;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("disableSendMsgBtnTipsForTribar", String.class));
      label5322:
      i = paramCursor.getColumnIndex("disableSendGiftBtnTipsForTribar");
      if (i != -1) {
        break label7149;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("disableSendGiftBtnTipsForTribar", String.class));
      label5359:
      i = paramCursor.getColumnIndex("highScoreNum");
      if (i != -1) {
        break label7164;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("highScoreNum", Integer.TYPE));
      label5396:
      i = paramCursor.getColumnIndex("mHasStory");
      if (i != -1) {
        break label7179;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mHasStory", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mQQStoryData");
      if (i != -1) {
        break label7206;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mQQStoryData", [B.class));
      label5470:
      i = paramCursor.getColumnIndex("isSendMsgBtnDownloadAppOpen");
      if (i != -1) {
        break label7221;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSendMsgBtnDownloadAppOpen", Boolean.TYPE));
      i = paramCursor.getColumnIndex("sendMsgBtnDownloadAppTips");
      if (i != -1) {
        break label7249;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("sendMsgBtnDownloadAppTips", String.class));
      label5544:
      i = paramCursor.getColumnIndex("addPicBtnDownloadAppTips");
      if (i != -1) {
        break label7264;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addPicBtnDownloadAppTips", String.class));
      label5581:
      i = paramCursor.getColumnIndex("tribeAppDownloadPageUrl");
      if (i != -1) {
        break label7279;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tribeAppDownloadPageUrl", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("nearbyNowDataBytes");
      if (i != -1) {
        break label7294;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nearbyNowDataBytes", [B.class));
      return paramEntity;
      paramEntity.tinyId = paramCursor.getLong(i);
      break;
      label5672:
      paramEntity.uin = paramCursor.getString(i);
      break label2092;
      label5687:
      paramEntity.strRemark = paramCursor.getString(i);
      break label2127;
      label5702:
      paramEntity.nickname = paramCursor.getString(i);
      break label2162;
      label5717:
      paramEntity.gender = ((byte)paramCursor.getShort(i));
      break label2197;
      label5733:
      paramEntity.age = paramCursor.getInt(i);
      break label2232;
      label5748:
      paramEntity.birthday = paramCursor.getInt(i);
      break label2267;
      label5763:
      paramEntity.constellation = ((byte)paramCursor.getShort(i));
      break label2302;
      label5779:
      paramEntity.distance = paramCursor.getString(i);
      break label2337;
      label5794:
      paramEntity.timeDiff = paramCursor.getString(i);
      break label2372;
      label5809:
      paramEntity.aioDistanceAndTime = paramCursor.getString(i);
      break label2407;
      label5824:
      paramEntity.likeCount = paramCursor.getInt(i);
      break label2442;
      label5839:
      paramEntity.likeCountInc = paramCursor.getInt(i);
      break label2477;
      label5854:
      paramEntity.oldPhotoCount = paramCursor.getInt(i);
      break label2512;
      label5869:
      paramEntity.dateInfo = paramCursor.getBlob(i);
      break label2547;
      label5884:
      paramEntity.ulShowControl = paramCursor.getLong(i);
      break label2582;
      label5899:
      paramEntity.xuanYan = paramCursor.getBlob(i);
      break label2617;
      label5914:
      paramEntity.maritalStatus = ((byte)paramCursor.getShort(i));
      break label2652;
      label5930:
      paramEntity.job = paramCursor.getInt(i);
      break label2687;
      label5945:
      paramEntity.company = paramCursor.getString(i);
      break label2722;
      label5960:
      paramEntity.college = paramCursor.getString(i);
      break label2757;
      label5975:
      paramEntity.hometownCountry = paramCursor.getString(i);
      break label2792;
      label5990:
      paramEntity.hometownProvice = paramCursor.getString(i);
      break label2827;
      label6005:
      paramEntity.hometownCity = paramCursor.getString(i);
      break label2862;
      label6020:
      paramEntity.hometownDistrict = paramCursor.getString(i);
      break label2897;
      label6035:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label2932;
      label6050:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label2967;
      label6066:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label3002;
      label6081:
      paramEntity.qzoneFeed = paramCursor.getString(i);
      break label3037;
      label6096:
      paramEntity.qzoneName = paramCursor.getString(i);
      break label3072;
      label6111:
      paramEntity.qzonePicUrl_1 = paramCursor.getString(i);
      break label3107;
      label6126:
      paramEntity.qzonePicUrl_2 = paramCursor.getString(i);
      break label3142;
      label6141:
      paramEntity.qzonePicUrl_3 = paramCursor.getString(i);
      break label3177;
      label6156:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isPhotoUseCache = paramBoolean;
        break;
      }
      label6183:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label3247;
      label6198:
      paramEntity.vTempChatSig = paramCursor.getBlob(i);
      break label3282;
      label6213:
      paramEntity.vGroupList = paramCursor.getBlob(i);
      break label3317;
      label6228:
      paramEntity.nearbyInfo = paramCursor.getBlob(i);
      break label3352;
      label6243:
      paramEntity.vActivityList = paramCursor.getBlob(i);
      break label3387;
      label6258:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label3422;
      label6273:
      paramEntity.iIsGodFlag = paramCursor.getInt(i);
      break label3457;
      label6288:
      paramEntity.strGodJumpUrl = paramCursor.getString(i);
      break label3492;
      label6303:
      paramEntity.mHeartNum = paramCursor.getInt(i);
      break label3527;
      label6318:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.switchQzone = paramBoolean;
        break;
      }
      label6345:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.switchHobby = paramBoolean;
        break;
      }
      label6372:
      paramEntity.uiShowControl = paramCursor.getLong(i);
      break label3632;
      label6387:
      paramEntity.userFlag = paramCursor.getLong(i);
      break label3667;
      label6402:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label3702;
      label6417:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.godFlag = paramBoolean;
        break;
      }
      label6444:
      paramEntity.nLastGameFlag = paramCursor.getInt(i);
      break label3772;
      label6459:
      paramEntity.strProfileUrl = paramCursor.getString(i);
      break label3807;
      label6474:
      paramEntity.lastUpdateNickTime = paramCursor.getLong(i);
      break label3842;
      label6489:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label3879;
      label6504:
      paramEntity.switchGiftVisible = paramCursor.getLong(i);
      break label3916;
      label6519:
      paramEntity.vGiftInfo = paramCursor.getBlob(i);
      break label3953;
      label6534:
      paramEntity.sayHelloFlag = paramCursor.getInt(i);
      break label3990;
      label6549:
      paramEntity.charm = paramCursor.getLong(i);
      break label4027;
      label6564:
      paramEntity.charmLevel = paramCursor.getInt(i);
      break label4064;
      label6579:
      paramEntity.nextThreshold = paramCursor.getInt(i);
      break label4101;
      label6594:
      paramEntity.curThreshold = paramCursor.getInt(i);
      break label4138;
      label6609:
      paramEntity.profPercent = paramCursor.getInt(i);
      break label4175;
      label6624:
      paramEntity.taskFinished = paramCursor.getInt(i);
      break label4212;
      label6639:
      paramEntity.taskTotal = paramCursor.getInt(i);
      break label4249;
      label6654:
      paramEntity.hiWanInfo = paramCursor.getString(i);
      break label4286;
      label6669:
      paramEntity.commonLabelString = paramCursor.getString(i);
      break label4323;
      label6684:
      paramEntity.tagFlag = paramCursor.getLong(i);
      break label4360;
      label6699:
      paramEntity.tagInfo = paramCursor.getString(i);
      break label4397;
      label6714:
      paramEntity.picInfo = paramCursor.getString(i);
      break label4434;
      label6729:
      paramEntity.videoDetails = paramCursor.getString(i);
      break label4471;
      label6744:
      paramEntity.strFreshNewsInfo = paramCursor.getString(i);
      break label4508;
      label6759:
      paramEntity.strHotChatInfo = paramCursor.getString(i);
      break label4545;
      label6774:
      paramEntity.uRoomid = paramCursor.getLong(i);
      break label4582;
      label6789:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label4619;
      label6804:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label4656;
      label6819:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label4693;
      label6834:
      paramEntity.collegeId = paramCursor.getLong(i);
      break label4730;
      label6849:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.videoHeadFlag = paramBoolean;
        break;
      }
      label6876:
      paramEntity.bVideoHeadUrl = paramCursor.getString(i);
      break label4804;
      label6891:
      paramEntity.faceScoreWordingColor = paramCursor.getInt(i);
      break label4841;
      label6906:
      paramEntity.faceScoreWording = paramCursor.getString(i);
      break label4878;
      label6921:
      paramEntity.faceScoreTailWordingColor = paramCursor.getInt(i);
      break label4915;
      label6936:
      paramEntity.faceScoreTailWording = paramCursor.getString(i);
      break label4952;
      label6951:
      paramEntity.faceScoreIconUrl = paramCursor.getString(i);
      break label4989;
      label6966:
      paramEntity.entryAbility = paramCursor.getInt(i);
      break label5026;
      label6981:
      paramEntity.strLevelType = paramCursor.getString(i);
      break label5063;
      label6996:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendMsg = paramBoolean;
        break;
      }
      label7023:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendGiftMsg = paramBoolean;
        break;
      }
      label7050:
      paramEntity.disableSendMsgBtnTips = paramCursor.getString(i);
      break label5174;
      label7065:
      paramEntity.disableSendGiftBtnTips = paramCursor.getString(i);
      break label5211;
      label7080:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendMsgForTribar = paramBoolean;
        break;
      }
      label7107:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isForbidSendGiftMsgForTribar = paramBoolean;
        break;
      }
      label7134:
      paramEntity.disableSendMsgBtnTipsForTribar = paramCursor.getString(i);
      break label5322;
      label7149:
      paramEntity.disableSendGiftBtnTipsForTribar = paramCursor.getString(i);
      break label5359;
      label7164:
      paramEntity.highScoreNum = paramCursor.getInt(i);
      break label5396;
      label7179:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mHasStory = paramBoolean;
        break;
      }
      label7206:
      paramEntity.mQQStoryData = paramCursor.getBlob(i);
      break label5470;
      label7221:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isSendMsgBtnDownloadAppOpen = paramBoolean;
        break;
      }
      label7249:
      paramEntity.sendMsgBtnDownloadAppTips = paramCursor.getString(i);
      break label5544;
      label7264:
      paramEntity.addPicBtnDownloadAppTips = paramCursor.getString(i);
      break label5581;
      label7279:
      paramEntity.tribeAppDownloadPageUrl = paramCursor.getString(i);
    }
    label7294:
    paramEntity.nearbyNowDataBytes = paramCursor.getBlob(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,tinyId INTEGER ,uin TEXT ,strRemark TEXT ,nickname TEXT ,gender INTEGER ,age INTEGER ,birthday INTEGER ,constellation INTEGER ,distance TEXT ,timeDiff TEXT ,aioDistanceAndTime TEXT ,likeCount INTEGER ,likeCountInc INTEGER ,oldPhotoCount INTEGER ,dateInfo BLOB ,ulShowControl INTEGER ,xuanYan BLOB ,maritalStatus INTEGER ,job INTEGER ,company TEXT ,college TEXT ,hometownCountry TEXT ,hometownProvice TEXT ,hometownCity TEXT ,hometownDistrict TEXT ,vCookies BLOB ,bVoted INTEGER ,feedPreviewTime INTEGER ,qzoneFeed TEXT ,qzoneName TEXT ,qzonePicUrl_1 TEXT ,qzonePicUrl_2 TEXT ,qzonePicUrl_3 TEXT ,isPhotoUseCache INTEGER ,vSeed BLOB ,vTempChatSig BLOB ,vGroupList BLOB ,nearbyInfo BLOB ,vActivityList BLOB ,lUserFlag INTEGER ,iIsGodFlag INTEGER ,strGodJumpUrl TEXT ,mHeartNum INTEGER ,switchQzone INTEGER ,switchHobby INTEGER ,uiShowControl INTEGER ,userFlag INTEGER ,busiEntry TEXT ,godFlag INTEGER ,nLastGameFlag INTEGER ,strProfileUrl TEXT ,lastUpdateNickTime INTEGER ,favoriteSource INTEGER ,switchGiftVisible INTEGER ,vGiftInfo BLOB ,sayHelloFlag INTEGER ,charm INTEGER ,charmLevel INTEGER ,nextThreshold INTEGER ,curThreshold INTEGER ,profPercent INTEGER ,taskFinished INTEGER ,taskTotal INTEGER ,hiWanInfo TEXT ,commonLabelString TEXT ,tagFlag INTEGER ,tagInfo TEXT ,picInfo TEXT ,videoDetails TEXT ,strFreshNewsInfo TEXT ,strHotChatInfo TEXT ,uRoomid INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,collegeId INTEGER ,videoHeadFlag INTEGER ,bVideoHeadUrl TEXT ,faceScoreWordingColor INTEGER ,faceScoreWording TEXT ,faceScoreTailWordingColor INTEGER ,faceScoreTailWording TEXT ,faceScoreIconUrl TEXT ,entryAbility INTEGER ,strLevelType TEXT ,isForbidSendMsg INTEGER ,isForbidSendGiftMsg INTEGER ,disableSendMsgBtnTips TEXT ,disableSendGiftBtnTips TEXT ,isForbidSendMsgForTribar INTEGER ,isForbidSendGiftMsgForTribar INTEGER ,disableSendMsgBtnTipsForTribar TEXT ,disableSendGiftBtnTipsForTribar TEXT ,highScoreNum INTEGER ,mHasStory INTEGER ,mQQStoryData BLOB ,isSendMsgBtnDownloadAppOpen INTEGER ,sendMsgBtnDownloadAppTips TEXT ,addPicBtnDownloadAppTips TEXT ,tribeAppDownloadPageUrl TEXT ,nearbyNowDataBytes BLOB)");
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