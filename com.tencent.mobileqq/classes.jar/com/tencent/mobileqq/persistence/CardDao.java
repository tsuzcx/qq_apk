package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;

public class CardDao
  extends OGAbstractDao
{
  public CardDao()
  {
    this.a = 220;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Card)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.strNick = paramCursor.getString(paramCursor.getColumnIndex("strNick"));
      paramEntity.shGender = paramCursor.getShort(paramCursor.getColumnIndex("shGender"));
      paramEntity.shAge = paramCursor.getShort(paramCursor.getColumnIndex("shAge"));
      paramEntity.nFaceID = paramCursor.getInt(paramCursor.getColumnIndex("nFaceID"));
      paramEntity.strCertificationInfo = paramCursor.getString(paramCursor.getColumnIndex("strCertificationInfo"));
      paramEntity.shType = paramCursor.getShort(paramCursor.getColumnIndex("shType"));
      paramEntity.vContent = paramCursor.getBlob(paramCursor.getColumnIndex("vContent"));
      paramEntity.strSign = paramCursor.getString(paramCursor.getColumnIndex("strSign"));
      paramEntity.strCompany = paramCursor.getString(paramCursor.getColumnIndex("strCompany"));
      paramEntity.strSchool = paramCursor.getString(paramCursor.getColumnIndex("strSchool"));
      paramEntity.uFaceTimeStamp = paramCursor.getInt(paramCursor.getColumnIndex("uFaceTimeStamp"));
      paramEntity.vQQFaceID = paramCursor.getBlob(paramCursor.getColumnIndex("vQQFaceID"));
      paramEntity.strReMark = paramCursor.getString(paramCursor.getColumnIndex("strReMark"));
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bWeiboInfo")));
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQzoneInfo")));
      paramEntity.nSameFriendsNum = paramCursor.getInt(paramCursor.getColumnIndex("nSameFriendsNum"));
      paramEntity.strCompanySame = paramCursor.getString(paramCursor.getColumnIndex("strCompanySame"));
      paramEntity.strSchoolSame = paramCursor.getString(paramCursor.getColumnIndex("strSchoolSame"));
      paramEntity.lCardShowNum = paramCursor.getLong(paramCursor.getColumnIndex("lCardShowNum"));
      paramEntity.bSingle = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSingle")));
      paramEntity.lVisitCount = paramCursor.getLong(paramCursor.getColumnIndex("lVisitCount"));
      paramEntity.lVoteCount = paramCursor.getLong(paramCursor.getColumnIndex("lVoteCount"));
      paramEntity.tagInfosByte = paramCursor.getBlob(paramCursor.getColumnIndex("tagInfosByte"));
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("eUserIdentityType")));
      paramEntity.vBackground = paramCursor.getBlob(paramCursor.getColumnIndex("vBackground"));
      paramEntity.labelInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("labelInfoBytes"));
      paramEntity.age = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("age")));
      paramEntity.constellation = paramCursor.getInt(paramCursor.getColumnIndex("constellation"));
      paramEntity.pyFaceUrl = paramCursor.getString(paramCursor.getColumnIndex("pyFaceUrl"));
      paramEntity.location = paramCursor.getString(paramCursor.getColumnIndex("location"));
      paramEntity.bVoted = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bVoted")));
      paramEntity.bFavorited = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFavorited")));
      paramEntity.iVoteIncrement = paramCursor.getInt(paramCursor.getColumnIndex("iVoteIncrement"));
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(paramCursor.getColumnIndex("strJoinHexAlbumFileKey"));
      paramEntity.iFaceNum = paramCursor.getInt(paramCursor.getColumnIndex("iFaceNum"));
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cSqqLevel")));
      paramEntity.iQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQLevel"));
      paramEntity.strProvince = paramCursor.getString(paramCursor.getColumnIndex("strProvince"));
      paramEntity.strCity = paramCursor.getString(paramCursor.getColumnIndex("strCity"));
      paramEntity.strCountry = paramCursor.getString(paramCursor.getColumnIndex("strCountry"));
      paramEntity.lBirthday = paramCursor.getLong(paramCursor.getColumnIndex("lBirthday"));
      paramEntity.strLocationCodes = paramCursor.getString(paramCursor.getColumnIndex("strLocationCodes"));
      paramEntity.strLocationDesc = paramCursor.getString(paramCursor.getColumnIndex("strLocationDesc"));
      paramEntity.strHometownCodes = paramCursor.getString(paramCursor.getColumnIndex("strHometownCodes"));
      paramEntity.strHometownDesc = paramCursor.getString(paramCursor.getColumnIndex("strHometownDesc"));
      paramEntity.strEmail = paramCursor.getString(paramCursor.getColumnIndex("strEmail"));
      paramEntity.strPersonalNote = paramCursor.getString(paramCursor.getColumnIndex("strPersonalNote"));
      paramEntity.iProfession = paramCursor.getInt(paramCursor.getColumnIndex("iProfession"));
      paramEntity.bindPhoneInfo = paramCursor.getString(paramCursor.getColumnIndex("bindPhoneInfo"));
      paramEntity.bCardInfo = paramCursor.getBlob(paramCursor.getColumnIndex("bCardInfo"));
      paramEntity.strTroopName = paramCursor.getString(paramCursor.getColumnIndex("strTroopName"));
      paramEntity.strTroopNick = paramCursor.getString(paramCursor.getColumnIndex("strTroopNick"));
      paramEntity.strMobile = paramCursor.getString(paramCursor.getColumnIndex("strMobile"));
      paramEntity.strContactName = paramCursor.getString(paramCursor.getColumnIndex("strContactName"));
      paramEntity.ulShowControl = paramCursor.getInt(paramCursor.getColumnIndex("ulShowControl"));
      paramEntity.feedPreviewTime = paramCursor.getLong(paramCursor.getColumnIndex("feedPreviewTime"));
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(paramCursor.getColumnIndex("strQzoneFeedsDesc"));
      paramEntity.strSpaceName = paramCursor.getString(paramCursor.getColumnIndex("strSpaceName"));
      paramEntity.strQzoneHeader = paramCursor.getString(paramCursor.getColumnIndex("strQzoneHeader"));
      paramEntity.vQzonePhotos = paramCursor.getBlob(paramCursor.getColumnIndex("vQzonePhotos"));
      paramEntity.vQzoneCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vQzoneCoverInfo"));
      paramEntity.strStatus = paramCursor.getString(paramCursor.getColumnIndex("strStatus"));
      paramEntity.strAutoRemark = paramCursor.getString(paramCursor.getColumnIndex("strAutoRemark"));
      paramEntity.vSeed = paramCursor.getBlob(paramCursor.getColumnIndex("vSeed"));
      paramEntity.vCookies = paramCursor.getBlob(paramCursor.getColumnIndex("vCookies"));
      paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bQQVipOpen")));
      paramEntity.iQQVipType = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipType"));
      paramEntity.iQQVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iQQVipLevel"));
      paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperVipOpen")));
      paramEntity.iSuperVipType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipType"));
      paramEntity.iSuperVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperVipLevel"));
      paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSuperQQOpen")));
      paramEntity.iSuperQQType = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQType"));
      paramEntity.iSuperQQLevel = paramCursor.getInt(paramCursor.getColumnIndex("iSuperQQLevel"));
      paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHollywoodVipOpen")));
      paramEntity.iHollywoodVipType = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipType"));
      paramEntity.iHollywoodVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("iHollywoodVipLevel"));
      paramEntity.strShowName = paramCursor.getString(paramCursor.getColumnIndex("strShowName"));
      paramEntity.strVoiceFilekey = paramCursor.getString(paramCursor.getColumnIndex("strVoiceFilekey"));
      paramEntity.shDuration = paramCursor.getShort(paramCursor.getColumnIndex("shDuration"));
      paramEntity.bRead = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bRead")));
      paramEntity.strUrl = paramCursor.getString(paramCursor.getColumnIndex("strUrl"));
      paramEntity.vRichSign = paramCursor.getBlob(paramCursor.getColumnIndex("vRichSign"));
      paramEntity.lSignModifyTime = paramCursor.getLong(paramCursor.getColumnIndex("lSignModifyTime"));
      paramEntity.nLastGameFlag = paramCursor.getInt(paramCursor.getColumnIndex("nLastGameFlag"));
      paramEntity.strGameLogoUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_1"));
      paramEntity.strGameLogoUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_2"));
      paramEntity.strGameLogoUrl_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_3"));
      paramEntity.strGameLogoUrl_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoUrl_4"));
      paramEntity.strGameLogoKey_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_1"));
      paramEntity.strGameLogoKey_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_2"));
      paramEntity.strGameLogoKey_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_3"));
      paramEntity.strGameLogoKey_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameLogoKey_4"));
      paramEntity.strGameName_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_1"));
      paramEntity.strGameName_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_2"));
      paramEntity.strGameName_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_3"));
      paramEntity.strGameName_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameName_4"));
      paramEntity.strGameAppid_1 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_1"));
      paramEntity.strGameAppid_2 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_2"));
      paramEntity.strGameAppid_3 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_3"));
      paramEntity.strGameAppid_4 = paramCursor.getString(paramCursor.getColumnIndex("strGameAppid_4"));
      paramEntity.strProfileUrl = paramCursor.getString(paramCursor.getColumnIndex("strProfileUrl"));
      paramEntity.nStarFansFlag = paramCursor.getInt(paramCursor.getColumnIndex("nStarFansFlag"));
      paramEntity.strStarPicUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_0"));
      paramEntity.strStarPicUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_1"));
      paramEntity.strStarPicUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarPicUrl_2"));
      paramEntity.strStarLvUrl_0 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_0"));
      paramEntity.strStarLvUrl_1 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_1"));
      paramEntity.strStarLvUrl_2 = paramCursor.getString(paramCursor.getColumnIndex("strStarLvUrl_2"));
      paramEntity.strStarLogoUrl = paramCursor.getString(paramCursor.getColumnIndex("strStarLogoUrl"));
      paramEntity.starFansJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("starFansJumpUrl"));
      paramEntity.lUserFlag = paramCursor.getLong(paramCursor.getColumnIndex("lUserFlag"));
      paramEntity.lLoginDays = paramCursor.getLong(paramCursor.getColumnIndex("lLoginDays"));
      paramEntity.strLoginDaysDesc = paramCursor.getString(paramCursor.getColumnIndex("strLoginDaysDesc"));
      paramEntity.lQQMasterLogindays = paramCursor.getLong(paramCursor.getColumnIndex("lQQMasterLogindays"));
      paramEntity.iXManScene1DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene1DelayTime"));
      paramEntity.iXManScene2DelayTime = paramCursor.getInt(paramCursor.getColumnIndex("iXManScene2DelayTime"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("allowPeopleSee")))
      {
        paramBoolean = true;
        paramEntity.allowPeopleSee = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowCalInteractive"))) {
          break label4299;
        }
        paramBoolean = true;
        label2266:
        paramEntity.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4304;
        }
        paramBoolean = true;
        label2292:
        paramEntity.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4309;
        }
        paramBoolean = true;
        label2318:
        paramEntity.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4314;
        }
        paramBoolean = true;
        label2344:
        paramEntity.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showLightalk"))) {
          break label4319;
        }
        paramBoolean = true;
        label2370:
        paramEntity.showLightalk = paramBoolean;
        paramEntity.lightalkNick = paramCursor.getString(paramCursor.getColumnIndex("lightalkNick"));
        paramEntity.lightalkId = paramCursor.getString(paramCursor.getColumnIndex("lightalkId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4324;
        }
        paramBoolean = true;
        label2434:
        paramEntity.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4329;
        }
        paramBoolean = true;
        label2460:
        paramEntity.isRedDiamond = paramBoolean;
        paramEntity.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4334;
        }
        paramBoolean = true;
        label2505:
        paramEntity.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4339;
        }
        paramBoolean = true;
        label2531:
        paramEntity.isYellowDiamond = paramBoolean;
        paramEntity.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4344;
        }
        paramBoolean = true;
        label2576:
        paramEntity.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4349;
        }
        paramBoolean = true;
        label2602:
        paramEntity.isGreenDiamond = paramBoolean;
        paramEntity.greenLevel = paramCursor.getInt(paramCursor.getColumnIndex("greenLevel"));
        paramEntity.uAccelerateMultiple = paramCursor.getLong(paramCursor.getColumnIndex("uAccelerateMultiple"));
        paramEntity.strRespMusicInfo = paramCursor.getString(paramCursor.getColumnIndex("strRespMusicInfo"));
        paramEntity.templateRet = paramCursor.getInt(paramCursor.getColumnIndex("templateRet"));
        paramEntity.lCurrentStyleId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentStyleId"));
        paramEntity.lCurrentBgId = paramCursor.getLong(paramCursor.getColumnIndex("lCurrentBgId"));
        paramEntity.backgroundUrl = paramCursor.getString(paramCursor.getColumnIndex("backgroundUrl"));
        paramEntity.backgroundColor = paramCursor.getLong(paramCursor.getColumnIndex("backgroundColor"));
        paramEntity.dynamicCardFlag = paramCursor.getInt(paramCursor.getColumnIndex("dynamicCardFlag"));
        paramEntity.strZipUrl = paramCursor.getString(paramCursor.getColumnIndex("strZipUrl"));
        paramEntity.strActiveUrl = paramCursor.getString(paramCursor.getColumnIndex("strActiveUrl"));
        paramEntity.strDrawerCardUrl = paramCursor.getString(paramCursor.getColumnIndex("strDrawerCardUrl"));
        paramEntity.strWzryHeroUrl = paramCursor.getString(paramCursor.getColumnIndex("strWzryHeroUrl"));
        paramEntity.wzryHonorInfo = paramCursor.getBlob(paramCursor.getColumnIndex("wzryHonorInfo"));
        paramEntity.strExtInfo = paramCursor.getString(paramCursor.getColumnIndex("strExtInfo"));
        paramEntity.strCurrentBgUrl = paramCursor.getString(paramCursor.getColumnIndex("strCurrentBgUrl"));
        paramEntity.bgType = paramCursor.getBlob(paramCursor.getColumnIndex("bgType"));
        paramEntity.encId = paramCursor.getString(paramCursor.getColumnIndex("encId"));
        paramEntity.busiEntry = paramCursor.getString(paramCursor.getColumnIndex("busiEntry"));
        paramEntity.favoriteSource = paramCursor.getInt(paramCursor.getColumnIndex("favoriteSource"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("visibleMusicPendant"))) {
          break label4354;
        }
        paramBoolean = true;
        label3008:
        paramEntity.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4359;
        }
        paramBoolean = true;
        label3034:
        paramEntity.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4364;
        }
        paramBoolean = true;
        label3060:
        paramEntity.showRedPointMusicPendant = paramBoolean;
        paramEntity.privilegePromptStr = paramCursor.getString(paramCursor.getColumnIndex("privilegePromptStr"));
        paramEntity.privilegeJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("privilegeJumpUrl"));
        paramEntity.vOpenPriv = paramCursor.getBlob(paramCursor.getColumnIndex("vOpenPriv"));
        paramEntity.vClosePriv = paramCursor.getBlob(paramCursor.getColumnIndex("vClosePriv"));
        paramEntity.addSrcName = paramCursor.getString(paramCursor.getColumnIndex("addSrcName"));
        paramEntity.addSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSrcId"));
        paramEntity.addSubSrcId = paramCursor.getLong(paramCursor.getColumnIndex("addSubSrcId"));
        paramEntity.strVoteLimitedNotice = paramCursor.getString(paramCursor.getColumnIndex("strVoteLimitedNotice"));
        paramEntity.bHaveVotedCnt = paramCursor.getShort(paramCursor.getColumnIndex("bHaveVotedCnt"));
        paramEntity.bAvailVoteCnt = paramCursor.getShort(paramCursor.getColumnIndex("bAvailVoteCnt"));
        paramEntity.olympicTorch = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("olympicTorch")));
        paramEntity.mNowShowFlag = paramCursor.getInt(paramCursor.getColumnIndex("mNowShowFlag"));
        paramEntity.mNowShowIconUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowIconUrl"));
        paramEntity.mNowShowJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("mNowShowJumpUrl"));
        paramEntity.vCoverInfo = paramCursor.getBlob(paramCursor.getColumnIndex("vCoverInfo"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("videoHeadFlag"))) {
          break label4369;
        }
        paramBoolean = true;
        label3372:
        paramEntity.videoHeadFlag = paramBoolean;
        paramEntity.videoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("videoHeadUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("medalSwitchDisable"))) {
          break label4374;
        }
        paramBoolean = true;
        label3417:
        paramEntity.medalSwitchDisable = paramBoolean;
        paramEntity.iMedalCount = paramCursor.getInt(paramCursor.getColumnIndex("iMedalCount"));
        paramEntity.iNewCount = paramCursor.getInt(paramCursor.getColumnIndex("iNewCount"));
        paramEntity.iUpgradeCount = paramCursor.getInt(paramCursor.getColumnIndex("iUpgradeCount"));
        paramEntity.strPromptParams = paramCursor.getString(paramCursor.getColumnIndex("strPromptParams"));
        paramEntity.hobbyEntry = paramCursor.getString(paramCursor.getColumnIndex("hobbyEntry"));
        paramEntity.lastPraiseInfoList = paramCursor.getBlob(paramCursor.getColumnIndex("lastPraiseInfoList"));
        paramEntity.tempChatSig = paramCursor.getBlob(paramCursor.getColumnIndex("tempChatSig"));
        paramEntity.strCampusName = paramCursor.getString(paramCursor.getColumnIndex("strCampusName"));
        paramEntity.strCampusAcademy = paramCursor.getString(paramCursor.getColumnIndex("strCampusAcademy"));
        paramEntity.iCampusIsSigned = paramCursor.getInt(paramCursor.getColumnIndex("iCampusIsSigned"));
        paramEntity.namePlateOfKingGameId = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingGameId"));
        paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(paramCursor.getColumnIndex("namePlateOfKingLoginTime"));
        paramEntity.namePlateOfKingDan = paramCursor.getInt(paramCursor.getColumnIndex("namePlateOfKingDan"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch"))) {
          break label4379;
        }
        paramBoolean = true;
        label3690:
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        paramEntity.vPersonalityLabelV2 = paramCursor.getBlob(paramCursor.getColumnIndex("vPersonalityLabelV2"));
        paramEntity.cardType = paramCursor.getInt(paramCursor.getColumnIndex("cardType"));
        paramEntity.diyText = paramCursor.getString(paramCursor.getColumnIndex("diyText"));
        paramEntity.diyTextFontId = paramCursor.getInt(paramCursor.getColumnIndex("diyTextFontId"));
        paramEntity.diyTextWidth = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextWidth"));
        paramEntity.diyTextHeight = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextHeight"));
        paramEntity.diyTextLocX = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocX"));
        paramEntity.diyTextLocY = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextLocY"));
        paramEntity.diyTextDegree = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextDegree"));
        paramEntity.diyTextScale = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextScale"));
        paramEntity.diyTextTransparency = paramCursor.getFloat(paramCursor.getColumnIndex("diyTextTransparency"));
        paramEntity.diyDefaultText = paramCursor.getString(paramCursor.getColumnIndex("diyDefaultText"));
        paramEntity.nCampusStatus = paramCursor.getInt(paramCursor.getColumnIndex("nCampusStatus"));
        paramEntity.lCampusLastModifySchoolTime = paramCursor.getLong(paramCursor.getColumnIndex("lCampusLastModifySchoolTime"));
        paramEntity.lCampusSchoolID = paramCursor.getLong(paramCursor.getColumnIndex("lCampusSchoolID"));
        paramEntity.lCampusCollegeID = paramCursor.getLong(paramCursor.getColumnIndex("lCampusCollegeID"));
        paramEntity.nCampusSchoolFlag = paramCursor.getInt(paramCursor.getColumnIndex("nCampusSchoolFlag"));
        paramEntity.nCampusEnrolYear = paramCursor.getInt(paramCursor.getColumnIndex("nCampusEnrolYear"));
        paramEntity.strCampusSchool = paramCursor.getString(paramCursor.getColumnIndex("strCampusSchool"));
        paramEntity.strCampusCollege = paramCursor.getString(paramCursor.getColumnIndex("strCampusCollege"));
        paramEntity.strCampusClass = paramCursor.getString(paramCursor.getColumnIndex("strCampusClass"));
        paramEntity.strLastCampusFeeds = paramCursor.getString(paramCursor.getColumnIndex("strLastCampusFeeds"));
        paramEntity.popularity = paramCursor.getInt(paramCursor.getColumnIndex("popularity"));
        paramEntity.declaration = paramCursor.getString(paramCursor.getColumnIndex("declaration"));
        paramEntity.voiceUrl = paramCursor.getString(paramCursor.getColumnIndex("voiceUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isShowCard"))) {
          break label4384;
        }
      }
      label4354:
      label4359:
      label4364:
      label4369:
      label4374:
      label4379:
      label4384:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isShowCard = paramBoolean;
        paramEntity.updateTime = paramCursor.getLong(paramCursor.getColumnIndex("updateTime"));
        paramEntity.extendFriendFlag = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendFlag"));
        paramEntity.extendFriendVoiceDuration = paramCursor.getInt(paramCursor.getColumnIndex("extendFriendVoiceDuration"));
        paramEntity.extendFriendEntryContact = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryContact"));
        paramEntity.extendFriendEntryAddFriend = paramCursor.getShort(paramCursor.getColumnIndex("extendFriendEntryAddFriend"));
        return paramEntity;
        paramBoolean = false;
        break;
        label4299:
        paramBoolean = false;
        break label2266;
        label4304:
        paramBoolean = false;
        break label2292;
        label4309:
        paramBoolean = false;
        break label2318;
        label4314:
        paramBoolean = false;
        break label2344;
        label4319:
        paramBoolean = false;
        break label2370;
        label4324:
        paramBoolean = false;
        break label2434;
        label4329:
        paramBoolean = false;
        break label2460;
        label4334:
        paramBoolean = false;
        break label2505;
        label4339:
        paramBoolean = false;
        break label2531;
        label4344:
        paramBoolean = false;
        break label2576;
        label4349:
        paramBoolean = false;
        break label2602;
        paramBoolean = false;
        break label3008;
        paramBoolean = false;
        break label3034;
        paramBoolean = false;
        break label3060;
        paramBoolean = false;
        break label3372;
        paramBoolean = false;
        break label3417;
        paramBoolean = false;
        break label3690;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label12442;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strNick", String.class));
      label4459:
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label12457;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shGender", Short.TYPE));
      label4494:
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label12472;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shAge", Short.TYPE));
      label4529:
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label12487;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nFaceID", Integer.TYPE));
      label4564:
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label12502;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCertificationInfo", String.class));
      label4599:
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label12517;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shType", Short.TYPE));
      label4634:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label12532;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vContent", [B.class));
      label4669:
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label12547;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSign", String.class));
      label4704:
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label12562;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCompany", String.class));
      label4739:
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label12577;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSchool", String.class));
      label4774:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label12592;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      label4809:
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label12607;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vQQFaceID", [B.class));
      label4844:
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label12622;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strReMark", String.class));
      label4879:
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label12637;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bWeiboInfo", Byte.TYPE));
      label4914:
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label12653;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bQzoneInfo", Byte.TYPE));
      label4949:
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label12669;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      label4984:
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label12684;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCompanySame", String.class));
      label5019:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label12699;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSchoolSame", String.class));
      label5054:
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label12714;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCardShowNum", Long.TYPE));
      label5089:
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label12729;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSingle", Byte.TYPE));
      label5124:
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label12745;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lVisitCount", Long.TYPE));
      label5159:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label12760;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lVoteCount", Long.TYPE));
      label5194:
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label12775;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tagInfosByte", [B.class));
      label5229:
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label12790;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("eUserIdentityType", Byte.TYPE));
      label5264:
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label12806;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vBackground", [B.class));
      label5299:
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label12821;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("labelInfoBytes", [B.class));
      label5334:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label12836;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Byte.TYPE));
      label5369:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label12852;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("constellation", Integer.TYPE));
      label5404:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label12867;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFaceUrl", String.class));
      label5439:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label12882;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("location", String.class));
      label5474:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label12897;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bVoted", Byte.TYPE));
      label5509:
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label12913;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bFavorited", Byte.TYPE));
      label5544:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label12929;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iVoteIncrement", Integer.TYPE));
      label5579:
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label12944;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      label5614:
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label12959;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iFaceNum", Integer.TYPE));
      label5649:
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label12974;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cSqqLevel", Byte.TYPE));
      label5684:
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label12990;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iQQLevel", Integer.TYPE));
      label5719:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label13005;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strProvince", String.class));
      label5754:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label13020;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCity", String.class));
      label5789:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label13035;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCountry", String.class));
      label5824:
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label13050;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lBirthday", Long.TYPE));
      label5859:
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label13065;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLocationCodes", String.class));
      label5894:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label13080;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLocationDesc", String.class));
      label5929:
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label13095;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strHometownCodes", String.class));
      label5964:
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label13110;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strHometownDesc", String.class));
      label5999:
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label13125;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strEmail", String.class));
      label6034:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label13140;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strPersonalNote", String.class));
      label6069:
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label13155;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iProfession", Integer.TYPE));
      label6104:
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label13170;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bindPhoneInfo", String.class));
      label6139:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label13185;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bCardInfo", [B.class));
      label6174:
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label13200;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strTroopName", String.class));
      label6209:
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label13215;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strTroopNick", String.class));
      label6246:
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label13230;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strMobile", String.class));
      label6283:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label13245;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strContactName", String.class));
      label6320:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label13260;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ulShowControl", Integer.TYPE));
      label6357:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label13275;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label6394:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label13290;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strQzoneFeedsDesc", String.class));
      label6431:
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label13305;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSpaceName", String.class));
      label6468:
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label13320;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strQzoneHeader", String.class));
      label6505:
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label13335;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vQzonePhotos", [B.class));
      label6542:
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label13350;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vQzoneCoverInfo", [B.class));
      label6579:
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label13365;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStatus", String.class));
      label6616:
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label13380;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strAutoRemark", String.class));
      label6653:
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label13395;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vSeed", [B.class));
      label6690:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label13410;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCookies", [B.class));
      label6727:
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label13425;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label6764:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label13441;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iQQVipType", Integer.TYPE));
      label6801:
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label13456;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iQQVipLevel", Integer.TYPE));
      label6838:
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label13471;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      label6875:
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label13487;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperVipType", Integer.TYPE));
      label6912:
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label13502;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label6949:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label13517;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      label6986:
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label13533;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperQQType", Integer.TYPE));
      label7023:
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label13548;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label7060:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label13563;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      label7097:
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label13579;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      label7134:
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label13594;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      label7171:
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label13609;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strShowName", String.class));
      label7208:
      i = paramCursor.getColumnIndex("strVoiceFilekey");
      if (i != -1) {
        break label13624;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strVoiceFilekey", String.class));
      label7245:
      i = paramCursor.getColumnIndex("shDuration");
      if (i != -1) {
        break label13639;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shDuration", Short.TYPE));
      label7282:
      i = paramCursor.getColumnIndex("bRead");
      if (i != -1) {
        break label13654;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bRead", Byte.TYPE));
      label7319:
      i = paramCursor.getColumnIndex("strUrl");
      if (i != -1) {
        break label13670;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strUrl", String.class));
      label7356:
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label13685;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vRichSign", [B.class));
      label7393:
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label13700;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lSignModifyTime", Long.TYPE));
      label7430:
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label13715;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label7467:
      i = paramCursor.getColumnIndex("strGameLogoUrl_1");
      if (i != -1) {
        break label13730;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_1", String.class));
      label7504:
      i = paramCursor.getColumnIndex("strGameLogoUrl_2");
      if (i != -1) {
        break label13745;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_2", String.class));
      label7541:
      i = paramCursor.getColumnIndex("strGameLogoUrl_3");
      if (i != -1) {
        break label13760;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_3", String.class));
      label7578:
      i = paramCursor.getColumnIndex("strGameLogoUrl_4");
      if (i != -1) {
        break label13775;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_4", String.class));
      label7615:
      i = paramCursor.getColumnIndex("strGameLogoKey_1");
      if (i != -1) {
        break label13790;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_1", String.class));
      label7652:
      i = paramCursor.getColumnIndex("strGameLogoKey_2");
      if (i != -1) {
        break label13805;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_2", String.class));
      label7689:
      i = paramCursor.getColumnIndex("strGameLogoKey_3");
      if (i != -1) {
        break label13820;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_3", String.class));
      label7726:
      i = paramCursor.getColumnIndex("strGameLogoKey_4");
      if (i != -1) {
        break label13835;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_4", String.class));
      label7763:
      i = paramCursor.getColumnIndex("strGameName_1");
      if (i != -1) {
        break label13850;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_1", String.class));
      label7800:
      i = paramCursor.getColumnIndex("strGameName_2");
      if (i != -1) {
        break label13865;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_2", String.class));
      label7837:
      i = paramCursor.getColumnIndex("strGameName_3");
      if (i != -1) {
        break label13880;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_3", String.class));
      label7874:
      i = paramCursor.getColumnIndex("strGameName_4");
      if (i != -1) {
        break label13895;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_4", String.class));
      label7911:
      i = paramCursor.getColumnIndex("strGameAppid_1");
      if (i != -1) {
        break label13910;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_1", String.class));
      label7948:
      i = paramCursor.getColumnIndex("strGameAppid_2");
      if (i != -1) {
        break label13925;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_2", String.class));
      label7985:
      i = paramCursor.getColumnIndex("strGameAppid_3");
      if (i != -1) {
        break label13940;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_3", String.class));
      label8022:
      i = paramCursor.getColumnIndex("strGameAppid_4");
      if (i != -1) {
        break label13955;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_4", String.class));
      label8059:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label13970;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strProfileUrl", String.class));
      label8096:
      i = paramCursor.getColumnIndex("nStarFansFlag");
      if (i != -1) {
        break label13985;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nStarFansFlag", Integer.TYPE));
      label8133:
      i = paramCursor.getColumnIndex("strStarPicUrl_0");
      if (i != -1) {
        break label14000;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarPicUrl_0", String.class));
      label8170:
      i = paramCursor.getColumnIndex("strStarPicUrl_1");
      if (i != -1) {
        break label14015;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarPicUrl_1", String.class));
      label8207:
      i = paramCursor.getColumnIndex("strStarPicUrl_2");
      if (i != -1) {
        break label14030;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarPicUrl_2", String.class));
      label8244:
      i = paramCursor.getColumnIndex("strStarLvUrl_0");
      if (i != -1) {
        break label14045;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLvUrl_0", String.class));
      label8281:
      i = paramCursor.getColumnIndex("strStarLvUrl_1");
      if (i != -1) {
        break label14060;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLvUrl_1", String.class));
      label8318:
      i = paramCursor.getColumnIndex("strStarLvUrl_2");
      if (i != -1) {
        break label14075;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLvUrl_2", String.class));
      label8355:
      i = paramCursor.getColumnIndex("strStarLogoUrl");
      if (i != -1) {
        break label14090;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLogoUrl", String.class));
      label8392:
      i = paramCursor.getColumnIndex("starFansJumpUrl");
      if (i != -1) {
        break label14105;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("starFansJumpUrl", String.class));
      label8429:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label14120;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lUserFlag", Long.TYPE));
      label8466:
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label14135;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lLoginDays", Long.TYPE));
      label8503:
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label14150;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLoginDaysDesc", String.class));
      label8540:
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label14165;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label8577:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label14180;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      label8614:
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label14195;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      label8651:
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label14210;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label14237;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label14264;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label14291;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label14318;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showLightalk");
      if (i != -1) {
        break label14345;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showLightalk", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lightalkNick");
      if (i != -1) {
        break label14372;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lightalkNick", String.class));
      label8910:
      i = paramCursor.getColumnIndex("lightalkId");
      if (i != -1) {
        break label14387;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lightalkId", String.class));
      label8947:
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label14402;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label14429;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label14456;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("redLevel", Integer.TYPE));
      label9058:
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label14471;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label14498;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label14525;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("yellowLevel", Integer.TYPE));
      label9169:
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label14540;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label14567;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label14594;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("greenLevel", Integer.TYPE));
      label9280:
      i = paramCursor.getColumnIndex("uAccelerateMultiple");
      if (i != -1) {
        break label14609;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uAccelerateMultiple", Long.TYPE));
      label9317:
      i = paramCursor.getColumnIndex("strRespMusicInfo");
      if (i != -1) {
        break label14624;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strRespMusicInfo", String.class));
      label9354:
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label14639;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("templateRet", Integer.TYPE));
      label9391:
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label14654;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCurrentStyleId", Long.TYPE));
      label9428:
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label14669;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCurrentBgId", Long.TYPE));
      label9465:
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label14684;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("backgroundUrl", String.class));
      label9502:
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label14699;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("backgroundColor", Long.TYPE));
      label9539:
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label14714;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      label9576:
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label14729;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strZipUrl", String.class));
      label9613:
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label14744;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strActiveUrl", String.class));
      label9650:
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label14759;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strDrawerCardUrl", String.class));
      label9687:
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label14774;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strWzryHeroUrl", String.class));
      label9724:
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label14789;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wzryHonorInfo", [B.class));
      label9761:
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label14804;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strExtInfo", String.class));
      label9798:
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label14819;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCurrentBgUrl", String.class));
      label9835:
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label14834;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bgType", [B.class));
      label9872:
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label14849;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("encId", String.class));
      label9909:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label14864;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("busiEntry", String.class));
      label9946:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label14879;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label9983:
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label14894;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label14921;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label14948;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label14975;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("privilegePromptStr", String.class));
      label10131:
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label14990;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("privilegeJumpUrl", String.class));
      label10168:
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label15005;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vOpenPriv", [B.class));
      label10205:
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label15020;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vClosePriv", [B.class));
      label10242:
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label15035;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addSrcName", String.class));
      label10279:
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label15050;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addSrcId", Long.TYPE));
      label10316:
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label15065;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addSubSrcId", Long.TYPE));
      label10353:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label15080;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label10390:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label15095;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label10427:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label15110;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label10464:
      i = paramCursor.getColumnIndex("olympicTorch");
      if (i != -1) {
        break label15125;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("olympicTorch", Byte.TYPE));
      label10501:
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label15141;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mNowShowFlag", Integer.TYPE));
      label10538:
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label15156;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mNowShowIconUrl", String.class));
      label10575:
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label15171;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mNowShowJumpUrl", String.class));
      label10612:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label15186;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCoverInfo", [B.class));
      label10649:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label15201;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("videoHeadUrl");
      if (i != -1) {
        break label15228;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoHeadUrl", String.class));
      label10723:
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label15243;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label15270;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iMedalCount", Integer.TYPE));
      label10797:
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label15285;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iNewCount", Integer.TYPE));
      label10834:
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label15300;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iUpgradeCount", Integer.TYPE));
      label10871:
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label15315;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strPromptParams", String.class));
      label10908:
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label15330;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hobbyEntry", String.class));
      label10945:
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label15345;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastPraiseInfoList", [B.class));
      label10982:
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label15360;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tempChatSig", [B.class));
      label11019:
      i = paramCursor.getColumnIndex("strCampusName");
      if (i != -1) {
        break label15375;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusName", String.class));
      label11056:
      i = paramCursor.getColumnIndex("strCampusAcademy");
      if (i != -1) {
        break label15390;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusAcademy", String.class));
      label11093:
      i = paramCursor.getColumnIndex("iCampusIsSigned");
      if (i != -1) {
        break label15405;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iCampusIsSigned", Integer.TYPE));
      label11130:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label15420;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label11167:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label15435;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label11204:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label15450;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label11241:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label15465;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label15492;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vPersonalityLabelV2", [B.class));
      label11315:
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label15507;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cardType", Integer.TYPE));
      label11352:
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label15522;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyText", String.class));
      label11389:
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label15537;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextFontId", Integer.TYPE));
      label11426:
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label15552;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextWidth", Float.TYPE));
      label11463:
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label15567;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextHeight", Float.TYPE));
      label11500:
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label15582;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextLocX", Float.TYPE));
      label11537:
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label15597;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextLocY", Float.TYPE));
      label11574:
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label15612;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextDegree", Float.TYPE));
      label11611:
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label15627;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextScale", Float.TYPE));
      label11648:
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label15642;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextTransparency", Float.TYPE));
      label11685:
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label15657;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyDefaultText", String.class));
      label11722:
      i = paramCursor.getColumnIndex("nCampusStatus");
      if (i != -1) {
        break label15672;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nCampusStatus", Integer.TYPE));
      label11759:
      i = paramCursor.getColumnIndex("lCampusLastModifySchoolTime");
      if (i != -1) {
        break label15687;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCampusLastModifySchoolTime", Long.TYPE));
      label11796:
      i = paramCursor.getColumnIndex("lCampusSchoolID");
      if (i != -1) {
        break label15702;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCampusSchoolID", Long.TYPE));
      label11833:
      i = paramCursor.getColumnIndex("lCampusCollegeID");
      if (i != -1) {
        break label15717;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCampusCollegeID", Long.TYPE));
      label11870:
      i = paramCursor.getColumnIndex("nCampusSchoolFlag");
      if (i != -1) {
        break label15732;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nCampusSchoolFlag", Integer.TYPE));
      label11907:
      i = paramCursor.getColumnIndex("nCampusEnrolYear");
      if (i != -1) {
        break label15747;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nCampusEnrolYear", Integer.TYPE));
      label11944:
      i = paramCursor.getColumnIndex("strCampusSchool");
      if (i != -1) {
        break label15762;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusSchool", String.class));
      label11981:
      i = paramCursor.getColumnIndex("strCampusCollege");
      if (i != -1) {
        break label15777;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusCollege", String.class));
      label12018:
      i = paramCursor.getColumnIndex("strCampusClass");
      if (i != -1) {
        break label15792;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusClass", String.class));
      label12055:
      i = paramCursor.getColumnIndex("strLastCampusFeeds");
      if (i != -1) {
        break label15807;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLastCampusFeeds", String.class));
      label12092:
      i = paramCursor.getColumnIndex("popularity");
      if (i != -1) {
        break label15822;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("popularity", Integer.TYPE));
      label12129:
      i = paramCursor.getColumnIndex("declaration");
      if (i != -1) {
        break label15837;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("declaration", String.class));
      label12166:
      i = paramCursor.getColumnIndex("voiceUrl");
      if (i != -1) {
        break label15852;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("voiceUrl", String.class));
      label12203:
      i = paramCursor.getColumnIndex("isShowCard");
      if (i != -1) {
        break label15867;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isShowCard", Boolean.TYPE));
      i = paramCursor.getColumnIndex("updateTime");
      if (i != -1) {
        break label15895;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("updateTime", Long.TYPE));
      label12277:
      i = paramCursor.getColumnIndex("extendFriendFlag");
      if (i != -1) {
        break label15910;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extendFriendFlag", Integer.TYPE));
      label12314:
      i = paramCursor.getColumnIndex("extendFriendVoiceDuration");
      if (i != -1) {
        break label15925;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extendFriendVoiceDuration", Integer.TYPE));
      label12351:
      i = paramCursor.getColumnIndex("extendFriendEntryContact");
      if (i != -1) {
        break label15940;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extendFriendEntryContact", Short.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("extendFriendEntryAddFriend");
      if (i != -1) {
        break label15955;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extendFriendEntryAddFriend", Short.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label12442:
      paramEntity.strNick = paramCursor.getString(i);
      break label4459;
      label12457:
      paramEntity.shGender = paramCursor.getShort(i);
      break label4494;
      label12472:
      paramEntity.shAge = paramCursor.getShort(i);
      break label4529;
      label12487:
      paramEntity.nFaceID = paramCursor.getInt(i);
      break label4564;
      label12502:
      paramEntity.strCertificationInfo = paramCursor.getString(i);
      break label4599;
      label12517:
      paramEntity.shType = paramCursor.getShort(i);
      break label4634;
      label12532:
      paramEntity.vContent = paramCursor.getBlob(i);
      break label4669;
      label12547:
      paramEntity.strSign = paramCursor.getString(i);
      break label4704;
      label12562:
      paramEntity.strCompany = paramCursor.getString(i);
      break label4739;
      label12577:
      paramEntity.strSchool = paramCursor.getString(i);
      break label4774;
      label12592:
      paramEntity.uFaceTimeStamp = paramCursor.getInt(i);
      break label4809;
      label12607:
      paramEntity.vQQFaceID = paramCursor.getBlob(i);
      break label4844;
      label12622:
      paramEntity.strReMark = paramCursor.getString(i);
      break label4879;
      label12637:
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label4914;
      label12653:
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label4949;
      label12669:
      paramEntity.nSameFriendsNum = paramCursor.getInt(i);
      break label4984;
      label12684:
      paramEntity.strCompanySame = paramCursor.getString(i);
      break label5019;
      label12699:
      paramEntity.strSchoolSame = paramCursor.getString(i);
      break label5054;
      label12714:
      paramEntity.lCardShowNum = paramCursor.getLong(i);
      break label5089;
      label12729:
      paramEntity.bSingle = ((byte)paramCursor.getShort(i));
      break label5124;
      label12745:
      paramEntity.lVisitCount = paramCursor.getLong(i);
      break label5159;
      label12760:
      paramEntity.lVoteCount = paramCursor.getLong(i);
      break label5194;
      label12775:
      paramEntity.tagInfosByte = paramCursor.getBlob(i);
      break label5229;
      label12790:
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5264;
      label12806:
      paramEntity.vBackground = paramCursor.getBlob(i);
      break label5299;
      label12821:
      paramEntity.labelInfoBytes = paramCursor.getBlob(i);
      break label5334;
      label12836:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label5369;
      label12852:
      paramEntity.constellation = paramCursor.getInt(i);
      break label5404;
      label12867:
      paramEntity.pyFaceUrl = paramCursor.getString(i);
      break label5439;
      label12882:
      paramEntity.location = paramCursor.getString(i);
      break label5474;
      label12897:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label5509;
      label12913:
      paramEntity.bFavorited = ((byte)paramCursor.getShort(i));
      break label5544;
      label12929:
      paramEntity.iVoteIncrement = paramCursor.getInt(i);
      break label5579;
      label12944:
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label5614;
      label12959:
      paramEntity.iFaceNum = paramCursor.getInt(i);
      break label5649;
      label12974:
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label5684;
      label12990:
      paramEntity.iQQLevel = paramCursor.getInt(i);
      break label5719;
      label13005:
      paramEntity.strProvince = paramCursor.getString(i);
      break label5754;
      label13020:
      paramEntity.strCity = paramCursor.getString(i);
      break label5789;
      label13035:
      paramEntity.strCountry = paramCursor.getString(i);
      break label5824;
      label13050:
      paramEntity.lBirthday = paramCursor.getLong(i);
      break label5859;
      label13065:
      paramEntity.strLocationCodes = paramCursor.getString(i);
      break label5894;
      label13080:
      paramEntity.strLocationDesc = paramCursor.getString(i);
      break label5929;
      label13095:
      paramEntity.strHometownCodes = paramCursor.getString(i);
      break label5964;
      label13110:
      paramEntity.strHometownDesc = paramCursor.getString(i);
      break label5999;
      label13125:
      paramEntity.strEmail = paramCursor.getString(i);
      break label6034;
      label13140:
      paramEntity.strPersonalNote = paramCursor.getString(i);
      break label6069;
      label13155:
      paramEntity.iProfession = paramCursor.getInt(i);
      break label6104;
      label13170:
      paramEntity.bindPhoneInfo = paramCursor.getString(i);
      break label6139;
      label13185:
      paramEntity.bCardInfo = paramCursor.getBlob(i);
      break label6174;
      label13200:
      paramEntity.strTroopName = paramCursor.getString(i);
      break label6209;
      label13215:
      paramEntity.strTroopNick = paramCursor.getString(i);
      break label6246;
      label13230:
      paramEntity.strMobile = paramCursor.getString(i);
      break label6283;
      label13245:
      paramEntity.strContactName = paramCursor.getString(i);
      break label6320;
      label13260:
      paramEntity.ulShowControl = paramCursor.getInt(i);
      break label6357;
      label13275:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label6394;
      label13290:
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(i);
      break label6431;
      label13305:
      paramEntity.strSpaceName = paramCursor.getString(i);
      break label6468;
      label13320:
      paramEntity.strQzoneHeader = paramCursor.getString(i);
      break label6505;
      label13335:
      paramEntity.vQzonePhotos = paramCursor.getBlob(i);
      break label6542;
      label13350:
      paramEntity.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label6579;
      label13365:
      paramEntity.strStatus = paramCursor.getString(i);
      break label6616;
      label13380:
      paramEntity.strAutoRemark = paramCursor.getString(i);
      break label6653;
      label13395:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label6690;
      label13410:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label6727;
      label13425:
      paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label6764;
      label13441:
      paramEntity.iQQVipType = paramCursor.getInt(i);
      break label6801;
      label13456:
      paramEntity.iQQVipLevel = paramCursor.getInt(i);
      break label6838;
      label13471:
      paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label6875;
      label13487:
      paramEntity.iSuperVipType = paramCursor.getInt(i);
      break label6912;
      label13502:
      paramEntity.iSuperVipLevel = paramCursor.getInt(i);
      break label6949;
      label13517:
      paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label6986;
      label13533:
      paramEntity.iSuperQQType = paramCursor.getInt(i);
      break label7023;
      label13548:
      paramEntity.iSuperQQLevel = paramCursor.getInt(i);
      break label7060;
      label13563:
      paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label7097;
      label13579:
      paramEntity.iHollywoodVipType = paramCursor.getInt(i);
      break label7134;
      label13594:
      paramEntity.iHollywoodVipLevel = paramCursor.getInt(i);
      break label7171;
      label13609:
      paramEntity.strShowName = paramCursor.getString(i);
      break label7208;
      label13624:
      paramEntity.strVoiceFilekey = paramCursor.getString(i);
      break label7245;
      label13639:
      paramEntity.shDuration = paramCursor.getShort(i);
      break label7282;
      label13654:
      paramEntity.bRead = ((byte)paramCursor.getShort(i));
      break label7319;
      label13670:
      paramEntity.strUrl = paramCursor.getString(i);
      break label7356;
      label13685:
      paramEntity.vRichSign = paramCursor.getBlob(i);
      break label7393;
      label13700:
      paramEntity.lSignModifyTime = paramCursor.getLong(i);
      break label7430;
      label13715:
      paramEntity.nLastGameFlag = paramCursor.getInt(i);
      break label7467;
      label13730:
      paramEntity.strGameLogoUrl_1 = paramCursor.getString(i);
      break label7504;
      label13745:
      paramEntity.strGameLogoUrl_2 = paramCursor.getString(i);
      break label7541;
      label13760:
      paramEntity.strGameLogoUrl_3 = paramCursor.getString(i);
      break label7578;
      label13775:
      paramEntity.strGameLogoUrl_4 = paramCursor.getString(i);
      break label7615;
      label13790:
      paramEntity.strGameLogoKey_1 = paramCursor.getString(i);
      break label7652;
      label13805:
      paramEntity.strGameLogoKey_2 = paramCursor.getString(i);
      break label7689;
      label13820:
      paramEntity.strGameLogoKey_3 = paramCursor.getString(i);
      break label7726;
      label13835:
      paramEntity.strGameLogoKey_4 = paramCursor.getString(i);
      break label7763;
      label13850:
      paramEntity.strGameName_1 = paramCursor.getString(i);
      break label7800;
      label13865:
      paramEntity.strGameName_2 = paramCursor.getString(i);
      break label7837;
      label13880:
      paramEntity.strGameName_3 = paramCursor.getString(i);
      break label7874;
      label13895:
      paramEntity.strGameName_4 = paramCursor.getString(i);
      break label7911;
      label13910:
      paramEntity.strGameAppid_1 = paramCursor.getString(i);
      break label7948;
      label13925:
      paramEntity.strGameAppid_2 = paramCursor.getString(i);
      break label7985;
      label13940:
      paramEntity.strGameAppid_3 = paramCursor.getString(i);
      break label8022;
      label13955:
      paramEntity.strGameAppid_4 = paramCursor.getString(i);
      break label8059;
      label13970:
      paramEntity.strProfileUrl = paramCursor.getString(i);
      break label8096;
      label13985:
      paramEntity.nStarFansFlag = paramCursor.getInt(i);
      break label8133;
      label14000:
      paramEntity.strStarPicUrl_0 = paramCursor.getString(i);
      break label8170;
      label14015:
      paramEntity.strStarPicUrl_1 = paramCursor.getString(i);
      break label8207;
      label14030:
      paramEntity.strStarPicUrl_2 = paramCursor.getString(i);
      break label8244;
      label14045:
      paramEntity.strStarLvUrl_0 = paramCursor.getString(i);
      break label8281;
      label14060:
      paramEntity.strStarLvUrl_1 = paramCursor.getString(i);
      break label8318;
      label14075:
      paramEntity.strStarLvUrl_2 = paramCursor.getString(i);
      break label8355;
      label14090:
      paramEntity.strStarLogoUrl = paramCursor.getString(i);
      break label8392;
      label14105:
      paramEntity.starFansJumpUrl = paramCursor.getString(i);
      break label8429;
      label14120:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label8466;
      label14135:
      paramEntity.lLoginDays = paramCursor.getLong(i);
      break label8503;
      label14150:
      paramEntity.strLoginDaysDesc = paramCursor.getString(i);
      break label8540;
      label14165:
      paramEntity.lQQMasterLogindays = paramCursor.getLong(i);
      break label8577;
      label14180:
      paramEntity.iXManScene1DelayTime = paramCursor.getInt(i);
      break label8614;
      label14195:
      paramEntity.iXManScene2DelayTime = paramCursor.getInt(i);
      break label8651;
      label14210:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowPeopleSee = paramBoolean;
        break;
      }
      label14237:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowCalInteractive = paramBoolean;
        break;
      }
      label14264:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showOnlineFriends = paramBoolean;
        break;
      }
      label14291:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowClick = paramBoolean;
        break;
      }
      label14318:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.babyQSwitch = paramBoolean;
        break;
      }
      label14345:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showLightalk = paramBoolean;
        break;
      }
      label14372:
      paramEntity.lightalkNick = paramCursor.getString(i);
      break label8910;
      label14387:
      paramEntity.lightalkId = paramCursor.getString(i);
      break label8947;
      label14402:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperRedDiamond = paramBoolean;
        break;
      }
      label14429:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRedDiamond = paramBoolean;
        break;
      }
      label14456:
      paramEntity.redLevel = paramCursor.getInt(i);
      break label9058;
      label14471:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label14498:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isYellowDiamond = paramBoolean;
        break;
      }
      label14525:
      paramEntity.yellowLevel = paramCursor.getInt(i);
      break label9169;
      label14540:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label14567:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isGreenDiamond = paramBoolean;
        break;
      }
      label14594:
      paramEntity.greenLevel = paramCursor.getInt(i);
      break label9280;
      label14609:
      paramEntity.uAccelerateMultiple = paramCursor.getLong(i);
      break label9317;
      label14624:
      paramEntity.strRespMusicInfo = paramCursor.getString(i);
      break label9354;
      label14639:
      paramEntity.templateRet = paramCursor.getInt(i);
      break label9391;
      label14654:
      paramEntity.lCurrentStyleId = paramCursor.getLong(i);
      break label9428;
      label14669:
      paramEntity.lCurrentBgId = paramCursor.getLong(i);
      break label9465;
      label14684:
      paramEntity.backgroundUrl = paramCursor.getString(i);
      break label9502;
      label14699:
      paramEntity.backgroundColor = paramCursor.getLong(i);
      break label9539;
      label14714:
      paramEntity.dynamicCardFlag = paramCursor.getInt(i);
      break label9576;
      label14729:
      paramEntity.strZipUrl = paramCursor.getString(i);
      break label9613;
      label14744:
      paramEntity.strActiveUrl = paramCursor.getString(i);
      break label9650;
      label14759:
      paramEntity.strDrawerCardUrl = paramCursor.getString(i);
      break label9687;
      label14774:
      paramEntity.strWzryHeroUrl = paramCursor.getString(i);
      break label9724;
      label14789:
      paramEntity.wzryHonorInfo = paramCursor.getBlob(i);
      break label9761;
      label14804:
      paramEntity.strExtInfo = paramCursor.getString(i);
      break label9798;
      label14819:
      paramEntity.strCurrentBgUrl = paramCursor.getString(i);
      break label9835;
      label14834:
      paramEntity.bgType = paramCursor.getBlob(i);
      break label9872;
      label14849:
      paramEntity.encId = paramCursor.getString(i);
      break label9909;
      label14864:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label9946;
      label14879:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label9983;
      label14894:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.visibleMusicPendant = paramBoolean;
        break;
      }
      label14921:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label14948:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label14975:
      paramEntity.privilegePromptStr = paramCursor.getString(i);
      break label10131;
      label14990:
      paramEntity.privilegeJumpUrl = paramCursor.getString(i);
      break label10168;
      label15005:
      paramEntity.vOpenPriv = paramCursor.getBlob(i);
      break label10205;
      label15020:
      paramEntity.vClosePriv = paramCursor.getBlob(i);
      break label10242;
      label15035:
      paramEntity.addSrcName = paramCursor.getString(i);
      break label10279;
      label15050:
      paramEntity.addSrcId = paramCursor.getLong(i);
      break label10316;
      label15065:
      paramEntity.addSubSrcId = paramCursor.getLong(i);
      break label10353;
      label15080:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label10390;
      label15095:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label10427;
      label15110:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label10464;
      label15125:
      paramEntity.olympicTorch = ((byte)paramCursor.getShort(i));
      break label10501;
      label15141:
      paramEntity.mNowShowFlag = paramCursor.getInt(i);
      break label10538;
      label15156:
      paramEntity.mNowShowIconUrl = paramCursor.getString(i);
      break label10575;
      label15171:
      paramEntity.mNowShowJumpUrl = paramCursor.getString(i);
      break label10612;
      label15186:
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
      break label10649;
      label15201:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.videoHeadFlag = paramBoolean;
        break;
      }
      label15228:
      paramEntity.videoHeadUrl = paramCursor.getString(i);
      break label10723;
      label15243:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.medalSwitchDisable = paramBoolean;
        break;
      }
      label15270:
      paramEntity.iMedalCount = paramCursor.getInt(i);
      break label10797;
      label15285:
      paramEntity.iNewCount = paramCursor.getInt(i);
      break label10834;
      label15300:
      paramEntity.iUpgradeCount = paramCursor.getInt(i);
      break label10871;
      label15315:
      paramEntity.strPromptParams = paramCursor.getString(i);
      break label10908;
      label15330:
      paramEntity.hobbyEntry = paramCursor.getString(i);
      break label10945;
      label15345:
      paramEntity.lastPraiseInfoList = paramCursor.getBlob(i);
      break label10982;
      label15360:
      paramEntity.tempChatSig = paramCursor.getBlob(i);
      break label11019;
      label15375:
      paramEntity.strCampusName = paramCursor.getString(i);
      break label11056;
      label15390:
      paramEntity.strCampusAcademy = paramCursor.getString(i);
      break label11093;
      label15405:
      paramEntity.iCampusIsSigned = paramCursor.getInt(i);
      break label11130;
      label15420:
      paramEntity.namePlateOfKingGameId = paramCursor.getLong(i);
      break label11167;
      label15435:
      paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label11204;
      label15450:
      paramEntity.namePlateOfKingDan = paramCursor.getInt(i);
      break label11241;
      label15465:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label15492:
      paramEntity.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label11315;
      label15507:
      paramEntity.cardType = paramCursor.getInt(i);
      break label11352;
      label15522:
      paramEntity.diyText = paramCursor.getString(i);
      break label11389;
      label15537:
      paramEntity.diyTextFontId = paramCursor.getInt(i);
      break label11426;
      label15552:
      paramEntity.diyTextWidth = paramCursor.getFloat(i);
      break label11463;
      label15567:
      paramEntity.diyTextHeight = paramCursor.getFloat(i);
      break label11500;
      label15582:
      paramEntity.diyTextLocX = paramCursor.getFloat(i);
      break label11537;
      label15597:
      paramEntity.diyTextLocY = paramCursor.getFloat(i);
      break label11574;
      label15612:
      paramEntity.diyTextDegree = paramCursor.getFloat(i);
      break label11611;
      label15627:
      paramEntity.diyTextScale = paramCursor.getFloat(i);
      break label11648;
      label15642:
      paramEntity.diyTextTransparency = paramCursor.getFloat(i);
      break label11685;
      label15657:
      paramEntity.diyDefaultText = paramCursor.getString(i);
      break label11722;
      label15672:
      paramEntity.nCampusStatus = paramCursor.getInt(i);
      break label11759;
      label15687:
      paramEntity.lCampusLastModifySchoolTime = paramCursor.getLong(i);
      break label11796;
      label15702:
      paramEntity.lCampusSchoolID = paramCursor.getLong(i);
      break label11833;
      label15717:
      paramEntity.lCampusCollegeID = paramCursor.getLong(i);
      break label11870;
      label15732:
      paramEntity.nCampusSchoolFlag = paramCursor.getInt(i);
      break label11907;
      label15747:
      paramEntity.nCampusEnrolYear = paramCursor.getInt(i);
      break label11944;
      label15762:
      paramEntity.strCampusSchool = paramCursor.getString(i);
      break label11981;
      label15777:
      paramEntity.strCampusCollege = paramCursor.getString(i);
      break label12018;
      label15792:
      paramEntity.strCampusClass = paramCursor.getString(i);
      break label12055;
      label15807:
      paramEntity.strLastCampusFeeds = paramCursor.getString(i);
      break label12092;
      label15822:
      paramEntity.popularity = paramCursor.getInt(i);
      break label12129;
      label15837:
      paramEntity.declaration = paramCursor.getString(i);
      break label12166;
      label15852:
      paramEntity.voiceUrl = paramCursor.getString(i);
      break label12203;
      label15867:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isShowCard = paramBoolean;
        break;
      }
      label15895:
      paramEntity.updateTime = paramCursor.getLong(i);
      break label12277;
      label15910:
      paramEntity.extendFriendFlag = paramCursor.getInt(i);
      break label12314;
      label15925:
      paramEntity.extendFriendVoiceDuration = paramCursor.getInt(i);
      break label12351;
      label15940:
      paramEntity.extendFriendEntryContact = paramCursor.getShort(i);
    }
    label15955:
    paramEntity.extendFriendEntryAddFriend = paramCursor.getShort(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,strVoiceFilekey TEXT ,shDuration INTEGER ,bRead INTEGER ,strUrl TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,nLastGameFlag INTEGER ,strGameLogoUrl_1 TEXT ,strGameLogoUrl_2 TEXT ,strGameLogoUrl_3 TEXT ,strGameLogoUrl_4 TEXT ,strGameLogoKey_1 TEXT ,strGameLogoKey_2 TEXT ,strGameLogoKey_3 TEXT ,strGameLogoKey_4 TEXT ,strGameName_1 TEXT ,strGameName_2 TEXT ,strGameName_3 TEXT ,strGameName_4 TEXT ,strGameAppid_1 TEXT ,strGameAppid_2 TEXT ,strGameAppid_3 TEXT ,strGameAppid_4 TEXT ,strProfileUrl TEXT ,nStarFansFlag INTEGER ,strStarPicUrl_0 TEXT ,strStarPicUrl_1 TEXT ,strStarPicUrl_2 TEXT ,strStarLvUrl_0 TEXT ,strStarLvUrl_1 TEXT ,strStarLvUrl_2 TEXT ,strStarLogoUrl TEXT ,starFansJumpUrl TEXT ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,showLightalk INTEGER ,lightalkNick TEXT ,lightalkId TEXT ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,uAccelerateMultiple INTEGER ,strRespMusicInfo TEXT ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,olympicTorch INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,videoHeadFlag INTEGER ,videoHeadUrl TEXT ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,strCampusName TEXT ,strCampusAcademy TEXT ,iCampusIsSigned INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,nCampusStatus INTEGER ,lCampusLastModifySchoolTime INTEGER ,lCampusSchoolID INTEGER ,lCampusCollegeID INTEGER ,nCampusSchoolFlag INTEGER ,nCampusEnrolYear INTEGER ,strCampusSchool TEXT ,strCampusCollege TEXT ,strCampusClass TEXT ,strLastCampusFeeds TEXT ,popularity INTEGER ,declaration TEXT ,voiceUrl TEXT ,isShowCard INTEGER ,updateTime INTEGER ,extendFriendFlag INTEGER ,extendFriendVoiceDuration INTEGER ,extendFriendEntryContact INTEGER ,extendFriendEntryAddFriend INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Card)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("strNick", paramEntity.strNick);
    paramContentValues.put("shGender", Short.valueOf(paramEntity.shGender));
    paramContentValues.put("shAge", Short.valueOf(paramEntity.shAge));
    paramContentValues.put("nFaceID", Integer.valueOf(paramEntity.nFaceID));
    paramContentValues.put("strCertificationInfo", paramEntity.strCertificationInfo);
    paramContentValues.put("shType", Short.valueOf(paramEntity.shType));
    paramContentValues.put("vContent", paramEntity.vContent);
    paramContentValues.put("strSign", paramEntity.strSign);
    paramContentValues.put("strCompany", paramEntity.strCompany);
    paramContentValues.put("strSchool", paramEntity.strSchool);
    paramContentValues.put("uFaceTimeStamp", Integer.valueOf(paramEntity.uFaceTimeStamp));
    paramContentValues.put("vQQFaceID", paramEntity.vQQFaceID);
    paramContentValues.put("strReMark", paramEntity.strReMark);
    paramContentValues.put("bWeiboInfo", Byte.valueOf(paramEntity.bWeiboInfo));
    paramContentValues.put("bQzoneInfo", Byte.valueOf(paramEntity.bQzoneInfo));
    paramContentValues.put("nSameFriendsNum", Integer.valueOf(paramEntity.nSameFriendsNum));
    paramContentValues.put("strCompanySame", paramEntity.strCompanySame);
    paramContentValues.put("strSchoolSame", paramEntity.strSchoolSame);
    paramContentValues.put("lCardShowNum", Long.valueOf(paramEntity.lCardShowNum));
    paramContentValues.put("bSingle", Byte.valueOf(paramEntity.bSingle));
    paramContentValues.put("lVisitCount", Long.valueOf(paramEntity.lVisitCount));
    paramContentValues.put("lVoteCount", Long.valueOf(paramEntity.lVoteCount));
    paramContentValues.put("tagInfosByte", paramEntity.tagInfosByte);
    paramContentValues.put("eUserIdentityType", Byte.valueOf(paramEntity.eUserIdentityType));
    paramContentValues.put("vBackground", paramEntity.vBackground);
    paramContentValues.put("labelInfoBytes", paramEntity.labelInfoBytes);
    paramContentValues.put("age", Byte.valueOf(paramEntity.age));
    paramContentValues.put("constellation", Integer.valueOf(paramEntity.constellation));
    paramContentValues.put("pyFaceUrl", paramEntity.pyFaceUrl);
    paramContentValues.put("location", paramEntity.location);
    paramContentValues.put("bVoted", Byte.valueOf(paramEntity.bVoted));
    paramContentValues.put("bFavorited", Byte.valueOf(paramEntity.bFavorited));
    paramContentValues.put("iVoteIncrement", Integer.valueOf(paramEntity.iVoteIncrement));
    paramContentValues.put("strJoinHexAlbumFileKey", paramEntity.strJoinHexAlbumFileKey);
    paramContentValues.put("iFaceNum", Integer.valueOf(paramEntity.iFaceNum));
    paramContentValues.put("cSqqLevel", Byte.valueOf(paramEntity.cSqqLevel));
    paramContentValues.put("iQQLevel", Integer.valueOf(paramEntity.iQQLevel));
    paramContentValues.put("strProvince", paramEntity.strProvince);
    paramContentValues.put("strCity", paramEntity.strCity);
    paramContentValues.put("strCountry", paramEntity.strCountry);
    paramContentValues.put("lBirthday", Long.valueOf(paramEntity.lBirthday));
    paramContentValues.put("strLocationCodes", paramEntity.strLocationCodes);
    paramContentValues.put("strLocationDesc", paramEntity.strLocationDesc);
    paramContentValues.put("strHometownCodes", paramEntity.strHometownCodes);
    paramContentValues.put("strHometownDesc", paramEntity.strHometownDesc);
    paramContentValues.put("strEmail", paramEntity.strEmail);
    paramContentValues.put("strPersonalNote", paramEntity.strPersonalNote);
    paramContentValues.put("iProfession", Integer.valueOf(paramEntity.iProfession));
    paramContentValues.put("bindPhoneInfo", paramEntity.bindPhoneInfo);
    paramContentValues.put("bCardInfo", paramEntity.bCardInfo);
    paramContentValues.put("strTroopName", paramEntity.strTroopName);
    paramContentValues.put("strTroopNick", paramEntity.strTroopNick);
    paramContentValues.put("strMobile", paramEntity.strMobile);
    paramContentValues.put("strContactName", paramEntity.strContactName);
    paramContentValues.put("ulShowControl", Integer.valueOf(paramEntity.ulShowControl));
    paramContentValues.put("feedPreviewTime", Long.valueOf(paramEntity.feedPreviewTime));
    paramContentValues.put("strQzoneFeedsDesc", paramEntity.strQzoneFeedsDesc);
    paramContentValues.put("strSpaceName", paramEntity.strSpaceName);
    paramContentValues.put("strQzoneHeader", paramEntity.strQzoneHeader);
    paramContentValues.put("vQzonePhotos", paramEntity.vQzonePhotos);
    paramContentValues.put("vQzoneCoverInfo", paramEntity.vQzoneCoverInfo);
    paramContentValues.put("strStatus", paramEntity.strStatus);
    paramContentValues.put("strAutoRemark", paramEntity.strAutoRemark);
    paramContentValues.put("vSeed", paramEntity.vSeed);
    paramContentValues.put("vCookies", paramEntity.vCookies);
    paramContentValues.put("bQQVipOpen", Byte.valueOf(paramEntity.bQQVipOpen));
    paramContentValues.put("iQQVipType", Integer.valueOf(paramEntity.iQQVipType));
    paramContentValues.put("iQQVipLevel", Integer.valueOf(paramEntity.iQQVipLevel));
    paramContentValues.put("bSuperVipOpen", Byte.valueOf(paramEntity.bSuperVipOpen));
    paramContentValues.put("iSuperVipType", Integer.valueOf(paramEntity.iSuperVipType));
    paramContentValues.put("iSuperVipLevel", Integer.valueOf(paramEntity.iSuperVipLevel));
    paramContentValues.put("bSuperQQOpen", Byte.valueOf(paramEntity.bSuperQQOpen));
    paramContentValues.put("iSuperQQType", Integer.valueOf(paramEntity.iSuperQQType));
    paramContentValues.put("iSuperQQLevel", Integer.valueOf(paramEntity.iSuperQQLevel));
    paramContentValues.put("bHollywoodVipOpen", Byte.valueOf(paramEntity.bHollywoodVipOpen));
    paramContentValues.put("iHollywoodVipType", Integer.valueOf(paramEntity.iHollywoodVipType));
    paramContentValues.put("iHollywoodVipLevel", Integer.valueOf(paramEntity.iHollywoodVipLevel));
    paramContentValues.put("strShowName", paramEntity.strShowName);
    paramContentValues.put("strVoiceFilekey", paramEntity.strVoiceFilekey);
    paramContentValues.put("shDuration", Short.valueOf(paramEntity.shDuration));
    paramContentValues.put("bRead", Byte.valueOf(paramEntity.bRead));
    paramContentValues.put("strUrl", paramEntity.strUrl);
    paramContentValues.put("vRichSign", paramEntity.vRichSign);
    paramContentValues.put("lSignModifyTime", Long.valueOf(paramEntity.lSignModifyTime));
    paramContentValues.put("nLastGameFlag", Integer.valueOf(paramEntity.nLastGameFlag));
    paramContentValues.put("strGameLogoUrl_1", paramEntity.strGameLogoUrl_1);
    paramContentValues.put("strGameLogoUrl_2", paramEntity.strGameLogoUrl_2);
    paramContentValues.put("strGameLogoUrl_3", paramEntity.strGameLogoUrl_3);
    paramContentValues.put("strGameLogoUrl_4", paramEntity.strGameLogoUrl_4);
    paramContentValues.put("strGameLogoKey_1", paramEntity.strGameLogoKey_1);
    paramContentValues.put("strGameLogoKey_2", paramEntity.strGameLogoKey_2);
    paramContentValues.put("strGameLogoKey_3", paramEntity.strGameLogoKey_3);
    paramContentValues.put("strGameLogoKey_4", paramEntity.strGameLogoKey_4);
    paramContentValues.put("strGameName_1", paramEntity.strGameName_1);
    paramContentValues.put("strGameName_2", paramEntity.strGameName_2);
    paramContentValues.put("strGameName_3", paramEntity.strGameName_3);
    paramContentValues.put("strGameName_4", paramEntity.strGameName_4);
    paramContentValues.put("strGameAppid_1", paramEntity.strGameAppid_1);
    paramContentValues.put("strGameAppid_2", paramEntity.strGameAppid_2);
    paramContentValues.put("strGameAppid_3", paramEntity.strGameAppid_3);
    paramContentValues.put("strGameAppid_4", paramEntity.strGameAppid_4);
    paramContentValues.put("strProfileUrl", paramEntity.strProfileUrl);
    paramContentValues.put("nStarFansFlag", Integer.valueOf(paramEntity.nStarFansFlag));
    paramContentValues.put("strStarPicUrl_0", paramEntity.strStarPicUrl_0);
    paramContentValues.put("strStarPicUrl_1", paramEntity.strStarPicUrl_1);
    paramContentValues.put("strStarPicUrl_2", paramEntity.strStarPicUrl_2);
    paramContentValues.put("strStarLvUrl_0", paramEntity.strStarLvUrl_0);
    paramContentValues.put("strStarLvUrl_1", paramEntity.strStarLvUrl_1);
    paramContentValues.put("strStarLvUrl_2", paramEntity.strStarLvUrl_2);
    paramContentValues.put("strStarLogoUrl", paramEntity.strStarLogoUrl);
    paramContentValues.put("starFansJumpUrl", paramEntity.starFansJumpUrl);
    paramContentValues.put("lUserFlag", Long.valueOf(paramEntity.lUserFlag));
    paramContentValues.put("lLoginDays", Long.valueOf(paramEntity.lLoginDays));
    paramContentValues.put("strLoginDaysDesc", paramEntity.strLoginDaysDesc);
    paramContentValues.put("lQQMasterLogindays", Long.valueOf(paramEntity.lQQMasterLogindays));
    paramContentValues.put("iXManScene1DelayTime", Integer.valueOf(paramEntity.iXManScene1DelayTime));
    paramContentValues.put("iXManScene2DelayTime", Integer.valueOf(paramEntity.iXManScene2DelayTime));
    paramContentValues.put("allowPeopleSee", Boolean.valueOf(paramEntity.allowPeopleSee));
    paramContentValues.put("allowCalInteractive", Boolean.valueOf(paramEntity.allowCalInteractive));
    paramContentValues.put("showOnlineFriends", Boolean.valueOf(paramEntity.showOnlineFriends));
    paramContentValues.put("allowClick", Boolean.valueOf(paramEntity.allowClick));
    paramContentValues.put("babyQSwitch", Boolean.valueOf(paramEntity.babyQSwitch));
    paramContentValues.put("showLightalk", Boolean.valueOf(paramEntity.showLightalk));
    paramContentValues.put("lightalkNick", paramEntity.lightalkNick);
    paramContentValues.put("lightalkId", paramEntity.lightalkId);
    paramContentValues.put("isSuperRedDiamond", Boolean.valueOf(paramEntity.isSuperRedDiamond));
    paramContentValues.put("isRedDiamond", Boolean.valueOf(paramEntity.isRedDiamond));
    paramContentValues.put("redLevel", Integer.valueOf(paramEntity.redLevel));
    paramContentValues.put("isSuperYellowDiamond", Boolean.valueOf(paramEntity.isSuperYellowDiamond));
    paramContentValues.put("isYellowDiamond", Boolean.valueOf(paramEntity.isYellowDiamond));
    paramContentValues.put("yellowLevel", Integer.valueOf(paramEntity.yellowLevel));
    paramContentValues.put("isSuperGreenDiamond", Boolean.valueOf(paramEntity.isSuperGreenDiamond));
    paramContentValues.put("isGreenDiamond", Boolean.valueOf(paramEntity.isGreenDiamond));
    paramContentValues.put("greenLevel", Integer.valueOf(paramEntity.greenLevel));
    paramContentValues.put("uAccelerateMultiple", Long.valueOf(paramEntity.uAccelerateMultiple));
    paramContentValues.put("strRespMusicInfo", paramEntity.strRespMusicInfo);
    paramContentValues.put("templateRet", Integer.valueOf(paramEntity.templateRet));
    paramContentValues.put("lCurrentStyleId", Long.valueOf(paramEntity.lCurrentStyleId));
    paramContentValues.put("lCurrentBgId", Long.valueOf(paramEntity.lCurrentBgId));
    paramContentValues.put("backgroundUrl", paramEntity.backgroundUrl);
    paramContentValues.put("backgroundColor", Long.valueOf(paramEntity.backgroundColor));
    paramContentValues.put("dynamicCardFlag", Integer.valueOf(paramEntity.dynamicCardFlag));
    paramContentValues.put("strZipUrl", paramEntity.strZipUrl);
    paramContentValues.put("strActiveUrl", paramEntity.strActiveUrl);
    paramContentValues.put("strDrawerCardUrl", paramEntity.strDrawerCardUrl);
    paramContentValues.put("strWzryHeroUrl", paramEntity.strWzryHeroUrl);
    paramContentValues.put("wzryHonorInfo", paramEntity.wzryHonorInfo);
    paramContentValues.put("strExtInfo", paramEntity.strExtInfo);
    paramContentValues.put("strCurrentBgUrl", paramEntity.strCurrentBgUrl);
    paramContentValues.put("bgType", paramEntity.bgType);
    paramContentValues.put("encId", paramEntity.encId);
    paramContentValues.put("busiEntry", paramEntity.busiEntry);
    paramContentValues.put("favoriteSource", Integer.valueOf(paramEntity.favoriteSource));
    paramContentValues.put("visibleMusicPendant", Boolean.valueOf(paramEntity.visibleMusicPendant));
    paramContentValues.put("autoPlayMusicPendant", Boolean.valueOf(paramEntity.autoPlayMusicPendant));
    paramContentValues.put("showRedPointMusicPendant", Boolean.valueOf(paramEntity.showRedPointMusicPendant));
    paramContentValues.put("privilegePromptStr", paramEntity.privilegePromptStr);
    paramContentValues.put("privilegeJumpUrl", paramEntity.privilegeJumpUrl);
    paramContentValues.put("vOpenPriv", paramEntity.vOpenPriv);
    paramContentValues.put("vClosePriv", paramEntity.vClosePriv);
    paramContentValues.put("addSrcName", paramEntity.addSrcName);
    paramContentValues.put("addSrcId", Long.valueOf(paramEntity.addSrcId));
    paramContentValues.put("addSubSrcId", Long.valueOf(paramEntity.addSubSrcId));
    paramContentValues.put("strVoteLimitedNotice", paramEntity.strVoteLimitedNotice);
    paramContentValues.put("bHaveVotedCnt", Short.valueOf(paramEntity.bHaveVotedCnt));
    paramContentValues.put("bAvailVoteCnt", Short.valueOf(paramEntity.bAvailVoteCnt));
    paramContentValues.put("olympicTorch", Byte.valueOf(paramEntity.olympicTorch));
    paramContentValues.put("mNowShowFlag", Integer.valueOf(paramEntity.mNowShowFlag));
    paramContentValues.put("mNowShowIconUrl", paramEntity.mNowShowIconUrl);
    paramContentValues.put("mNowShowJumpUrl", paramEntity.mNowShowJumpUrl);
    paramContentValues.put("vCoverInfo", paramEntity.vCoverInfo);
    paramContentValues.put("videoHeadFlag", Boolean.valueOf(paramEntity.videoHeadFlag));
    paramContentValues.put("videoHeadUrl", paramEntity.videoHeadUrl);
    paramContentValues.put("medalSwitchDisable", Boolean.valueOf(paramEntity.medalSwitchDisable));
    paramContentValues.put("iMedalCount", Integer.valueOf(paramEntity.iMedalCount));
    paramContentValues.put("iNewCount", Integer.valueOf(paramEntity.iNewCount));
    paramContentValues.put("iUpgradeCount", Integer.valueOf(paramEntity.iUpgradeCount));
    paramContentValues.put("strPromptParams", paramEntity.strPromptParams);
    paramContentValues.put("hobbyEntry", paramEntity.hobbyEntry);
    paramContentValues.put("lastPraiseInfoList", paramEntity.lastPraiseInfoList);
    paramContentValues.put("tempChatSig", paramEntity.tempChatSig);
    paramContentValues.put("strCampusName", paramEntity.strCampusName);
    paramContentValues.put("strCampusAcademy", paramEntity.strCampusAcademy);
    paramContentValues.put("iCampusIsSigned", Integer.valueOf(paramEntity.iCampusIsSigned));
    paramContentValues.put("namePlateOfKingGameId", Long.valueOf(paramEntity.namePlateOfKingGameId));
    paramContentValues.put("namePlateOfKingLoginTime", Long.valueOf(paramEntity.namePlateOfKingLoginTime));
    paramContentValues.put("namePlateOfKingDan", Integer.valueOf(paramEntity.namePlateOfKingDan));
    paramContentValues.put("namePlateOfKingDanDisplatSwitch", Boolean.valueOf(paramEntity.namePlateOfKingDanDisplatSwitch));
    paramContentValues.put("vPersonalityLabelV2", paramEntity.vPersonalityLabelV2);
    paramContentValues.put("cardType", Integer.valueOf(paramEntity.cardType));
    paramContentValues.put("diyText", paramEntity.diyText);
    paramContentValues.put("diyTextFontId", Integer.valueOf(paramEntity.diyTextFontId));
    paramContentValues.put("diyTextWidth", Float.valueOf(paramEntity.diyTextWidth));
    paramContentValues.put("diyTextHeight", Float.valueOf(paramEntity.diyTextHeight));
    paramContentValues.put("diyTextLocX", Float.valueOf(paramEntity.diyTextLocX));
    paramContentValues.put("diyTextLocY", Float.valueOf(paramEntity.diyTextLocY));
    paramContentValues.put("diyTextDegree", Float.valueOf(paramEntity.diyTextDegree));
    paramContentValues.put("diyTextScale", Float.valueOf(paramEntity.diyTextScale));
    paramContentValues.put("diyTextTransparency", Float.valueOf(paramEntity.diyTextTransparency));
    paramContentValues.put("diyDefaultText", paramEntity.diyDefaultText);
    paramContentValues.put("nCampusStatus", Integer.valueOf(paramEntity.nCampusStatus));
    paramContentValues.put("lCampusLastModifySchoolTime", Long.valueOf(paramEntity.lCampusLastModifySchoolTime));
    paramContentValues.put("lCampusSchoolID", Long.valueOf(paramEntity.lCampusSchoolID));
    paramContentValues.put("lCampusCollegeID", Long.valueOf(paramEntity.lCampusCollegeID));
    paramContentValues.put("nCampusSchoolFlag", Integer.valueOf(paramEntity.nCampusSchoolFlag));
    paramContentValues.put("nCampusEnrolYear", Integer.valueOf(paramEntity.nCampusEnrolYear));
    paramContentValues.put("strCampusSchool", paramEntity.strCampusSchool);
    paramContentValues.put("strCampusCollege", paramEntity.strCampusCollege);
    paramContentValues.put("strCampusClass", paramEntity.strCampusClass);
    paramContentValues.put("strLastCampusFeeds", paramEntity.strLastCampusFeeds);
    paramContentValues.put("popularity", Integer.valueOf(paramEntity.popularity));
    paramContentValues.put("declaration", paramEntity.declaration);
    paramContentValues.put("voiceUrl", paramEntity.voiceUrl);
    paramContentValues.put("isShowCard", Boolean.valueOf(paramEntity.isShowCard));
    paramContentValues.put("updateTime", Long.valueOf(paramEntity.updateTime));
    paramContentValues.put("extendFriendFlag", Integer.valueOf(paramEntity.extendFriendFlag));
    paramContentValues.put("extendFriendVoiceDuration", Integer.valueOf(paramEntity.extendFriendVoiceDuration));
    paramContentValues.put("extendFriendEntryContact", Short.valueOf(paramEntity.extendFriendEntryContact));
    paramContentValues.put("extendFriendEntryAddFriend", Short.valueOf(paramEntity.extendFriendEntryAddFriend));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.CardDao
 * JD-Core Version:    0.7.0.1
 */