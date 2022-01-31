package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Card;

public class CardDao
  extends OGAbstractDao
{
  public CardDao()
  {
    this.a = 211;
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
          break label4121;
        }
        paramBoolean = true;
        label2266:
        paramEntity.allowCalInteractive = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showOnlineFriends"))) {
          break label4126;
        }
        paramBoolean = true;
        label2292:
        paramEntity.showOnlineFriends = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("allowClick"))) {
          break label4131;
        }
        paramBoolean = true;
        label2318:
        paramEntity.allowClick = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("babyQSwitch"))) {
          break label4136;
        }
        paramBoolean = true;
        label2344:
        paramEntity.babyQSwitch = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showLightalk"))) {
          break label4141;
        }
        paramBoolean = true;
        label2370:
        paramEntity.showLightalk = paramBoolean;
        paramEntity.lightalkNick = paramCursor.getString(paramCursor.getColumnIndex("lightalkNick"));
        paramEntity.lightalkId = paramCursor.getString(paramCursor.getColumnIndex("lightalkId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperRedDiamond"))) {
          break label4146;
        }
        paramBoolean = true;
        label2434:
        paramEntity.isSuperRedDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRedDiamond"))) {
          break label4151;
        }
        paramBoolean = true;
        label2460:
        paramEntity.isRedDiamond = paramBoolean;
        paramEntity.redLevel = paramCursor.getInt(paramCursor.getColumnIndex("redLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperYellowDiamond"))) {
          break label4156;
        }
        paramBoolean = true;
        label2505:
        paramEntity.isSuperYellowDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isYellowDiamond"))) {
          break label4161;
        }
        paramBoolean = true;
        label2531:
        paramEntity.isYellowDiamond = paramBoolean;
        paramEntity.yellowLevel = paramCursor.getInt(paramCursor.getColumnIndex("yellowLevel"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isSuperGreenDiamond"))) {
          break label4166;
        }
        paramBoolean = true;
        label2576:
        paramEntity.isSuperGreenDiamond = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isGreenDiamond"))) {
          break label4171;
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
          break label4176;
        }
        paramBoolean = true;
        label3008:
        paramEntity.visibleMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("autoPlayMusicPendant"))) {
          break label4181;
        }
        paramBoolean = true;
        label3034:
        paramEntity.autoPlayMusicPendant = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("showRedPointMusicPendant"))) {
          break label4186;
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
          break label4191;
        }
        paramBoolean = true;
        label3372:
        paramEntity.videoHeadFlag = paramBoolean;
        paramEntity.videoHeadUrl = paramCursor.getString(paramCursor.getColumnIndex("videoHeadUrl"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("medalSwitchDisable"))) {
          break label4196;
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
          break label4201;
        }
      }
      label4121:
      label4126:
      label4131:
      label4136:
      label4141:
      label4146:
      label4151:
      label4156:
      label4161:
      label4166:
      label4171:
      label4176:
      label4181:
      label4186:
      label4191:
      label4196:
      label4201:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
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
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label2266;
        paramBoolean = false;
        break label2292;
        paramBoolean = false;
        break label2318;
        paramBoolean = false;
        break label2344;
        paramBoolean = false;
        break label2370;
        paramBoolean = false;
        break label2434;
        paramBoolean = false;
        break label2460;
        paramBoolean = false;
        break label2505;
        paramBoolean = false;
        break label2531;
        paramBoolean = false;
        break label2576;
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
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("strNick");
      if (i != -1) {
        break label11926;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strNick", String.class));
      label4276:
      i = paramCursor.getColumnIndex("shGender");
      if (i != -1) {
        break label11941;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shGender", Short.TYPE));
      label4311:
      i = paramCursor.getColumnIndex("shAge");
      if (i != -1) {
        break label11956;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shAge", Short.TYPE));
      label4346:
      i = paramCursor.getColumnIndex("nFaceID");
      if (i != -1) {
        break label11971;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nFaceID", Integer.TYPE));
      label4381:
      i = paramCursor.getColumnIndex("strCertificationInfo");
      if (i != -1) {
        break label11986;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCertificationInfo", String.class));
      label4416:
      i = paramCursor.getColumnIndex("shType");
      if (i != -1) {
        break label12001;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shType", Short.TYPE));
      label4451:
      i = paramCursor.getColumnIndex("vContent");
      if (i != -1) {
        break label12016;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vContent", [B.class));
      label4486:
      i = paramCursor.getColumnIndex("strSign");
      if (i != -1) {
        break label12031;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSign", String.class));
      label4521:
      i = paramCursor.getColumnIndex("strCompany");
      if (i != -1) {
        break label12046;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCompany", String.class));
      label4556:
      i = paramCursor.getColumnIndex("strSchool");
      if (i != -1) {
        break label12061;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSchool", String.class));
      label4591:
      i = paramCursor.getColumnIndex("uFaceTimeStamp");
      if (i != -1) {
        break label12076;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uFaceTimeStamp", Integer.TYPE));
      label4626:
      i = paramCursor.getColumnIndex("vQQFaceID");
      if (i != -1) {
        break label12091;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vQQFaceID", [B.class));
      label4661:
      i = paramCursor.getColumnIndex("strReMark");
      if (i != -1) {
        break label12106;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strReMark", String.class));
      label4696:
      i = paramCursor.getColumnIndex("bWeiboInfo");
      if (i != -1) {
        break label12121;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bWeiboInfo", Byte.TYPE));
      label4731:
      i = paramCursor.getColumnIndex("bQzoneInfo");
      if (i != -1) {
        break label12137;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bQzoneInfo", Byte.TYPE));
      label4766:
      i = paramCursor.getColumnIndex("nSameFriendsNum");
      if (i != -1) {
        break label12153;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nSameFriendsNum", Integer.TYPE));
      label4801:
      i = paramCursor.getColumnIndex("strCompanySame");
      if (i != -1) {
        break label12168;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCompanySame", String.class));
      label4836:
      i = paramCursor.getColumnIndex("strSchoolSame");
      if (i != -1) {
        break label12183;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSchoolSame", String.class));
      label4871:
      i = paramCursor.getColumnIndex("lCardShowNum");
      if (i != -1) {
        break label12198;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCardShowNum", Long.TYPE));
      label4906:
      i = paramCursor.getColumnIndex("bSingle");
      if (i != -1) {
        break label12213;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSingle", Byte.TYPE));
      label4941:
      i = paramCursor.getColumnIndex("lVisitCount");
      if (i != -1) {
        break label12229;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lVisitCount", Long.TYPE));
      label4976:
      i = paramCursor.getColumnIndex("lVoteCount");
      if (i != -1) {
        break label12244;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lVoteCount", Long.TYPE));
      label5011:
      i = paramCursor.getColumnIndex("tagInfosByte");
      if (i != -1) {
        break label12259;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tagInfosByte", [B.class));
      label5046:
      i = paramCursor.getColumnIndex("eUserIdentityType");
      if (i != -1) {
        break label12274;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("eUserIdentityType", Byte.TYPE));
      label5081:
      i = paramCursor.getColumnIndex("vBackground");
      if (i != -1) {
        break label12290;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vBackground", [B.class));
      label5116:
      i = paramCursor.getColumnIndex("labelInfoBytes");
      if (i != -1) {
        break label12305;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("labelInfoBytes", [B.class));
      label5151:
      i = paramCursor.getColumnIndex("age");
      if (i != -1) {
        break label12320;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("age", Byte.TYPE));
      label5186:
      i = paramCursor.getColumnIndex("constellation");
      if (i != -1) {
        break label12336;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("constellation", Integer.TYPE));
      label5221:
      i = paramCursor.getColumnIndex("pyFaceUrl");
      if (i != -1) {
        break label12351;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pyFaceUrl", String.class));
      label5256:
      i = paramCursor.getColumnIndex("location");
      if (i != -1) {
        break label12366;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("location", String.class));
      label5291:
      i = paramCursor.getColumnIndex("bVoted");
      if (i != -1) {
        break label12381;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bVoted", Byte.TYPE));
      label5326:
      i = paramCursor.getColumnIndex("bFavorited");
      if (i != -1) {
        break label12397;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bFavorited", Byte.TYPE));
      label5361:
      i = paramCursor.getColumnIndex("iVoteIncrement");
      if (i != -1) {
        break label12413;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iVoteIncrement", Integer.TYPE));
      label5396:
      i = paramCursor.getColumnIndex("strJoinHexAlbumFileKey");
      if (i != -1) {
        break label12428;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strJoinHexAlbumFileKey", String.class));
      label5431:
      i = paramCursor.getColumnIndex("iFaceNum");
      if (i != -1) {
        break label12443;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iFaceNum", Integer.TYPE));
      label5466:
      i = paramCursor.getColumnIndex("cSqqLevel");
      if (i != -1) {
        break label12458;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cSqqLevel", Byte.TYPE));
      label5501:
      i = paramCursor.getColumnIndex("iQQLevel");
      if (i != -1) {
        break label12474;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iQQLevel", Integer.TYPE));
      label5536:
      i = paramCursor.getColumnIndex("strProvince");
      if (i != -1) {
        break label12489;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strProvince", String.class));
      label5571:
      i = paramCursor.getColumnIndex("strCity");
      if (i != -1) {
        break label12504;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCity", String.class));
      label5606:
      i = paramCursor.getColumnIndex("strCountry");
      if (i != -1) {
        break label12519;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCountry", String.class));
      label5641:
      i = paramCursor.getColumnIndex("lBirthday");
      if (i != -1) {
        break label12534;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lBirthday", Long.TYPE));
      label5676:
      i = paramCursor.getColumnIndex("strLocationCodes");
      if (i != -1) {
        break label12549;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLocationCodes", String.class));
      label5711:
      i = paramCursor.getColumnIndex("strLocationDesc");
      if (i != -1) {
        break label12564;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLocationDesc", String.class));
      label5746:
      i = paramCursor.getColumnIndex("strHometownCodes");
      if (i != -1) {
        break label12579;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strHometownCodes", String.class));
      label5781:
      i = paramCursor.getColumnIndex("strHometownDesc");
      if (i != -1) {
        break label12594;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strHometownDesc", String.class));
      label5816:
      i = paramCursor.getColumnIndex("strEmail");
      if (i != -1) {
        break label12609;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strEmail", String.class));
      label5851:
      i = paramCursor.getColumnIndex("strPersonalNote");
      if (i != -1) {
        break label12624;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strPersonalNote", String.class));
      label5886:
      i = paramCursor.getColumnIndex("iProfession");
      if (i != -1) {
        break label12639;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iProfession", Integer.TYPE));
      label5921:
      i = paramCursor.getColumnIndex("bindPhoneInfo");
      if (i != -1) {
        break label12654;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bindPhoneInfo", String.class));
      label5956:
      i = paramCursor.getColumnIndex("bCardInfo");
      if (i != -1) {
        break label12669;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bCardInfo", [B.class));
      label5991:
      i = paramCursor.getColumnIndex("strTroopName");
      if (i != -1) {
        break label12684;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strTroopName", String.class));
      label6026:
      i = paramCursor.getColumnIndex("strTroopNick");
      if (i != -1) {
        break label12699;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strTroopNick", String.class));
      label6063:
      i = paramCursor.getColumnIndex("strMobile");
      if (i != -1) {
        break label12714;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strMobile", String.class));
      label6100:
      i = paramCursor.getColumnIndex("strContactName");
      if (i != -1) {
        break label12729;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strContactName", String.class));
      label6137:
      i = paramCursor.getColumnIndex("ulShowControl");
      if (i != -1) {
        break label12744;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ulShowControl", Integer.TYPE));
      label6174:
      i = paramCursor.getColumnIndex("feedPreviewTime");
      if (i != -1) {
        break label12759;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedPreviewTime", Long.TYPE));
      label6211:
      i = paramCursor.getColumnIndex("strQzoneFeedsDesc");
      if (i != -1) {
        break label12774;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strQzoneFeedsDesc", String.class));
      label6248:
      i = paramCursor.getColumnIndex("strSpaceName");
      if (i != -1) {
        break label12789;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strSpaceName", String.class));
      label6285:
      i = paramCursor.getColumnIndex("strQzoneHeader");
      if (i != -1) {
        break label12804;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strQzoneHeader", String.class));
      label6322:
      i = paramCursor.getColumnIndex("vQzonePhotos");
      if (i != -1) {
        break label12819;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vQzonePhotos", [B.class));
      label6359:
      i = paramCursor.getColumnIndex("vQzoneCoverInfo");
      if (i != -1) {
        break label12834;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vQzoneCoverInfo", [B.class));
      label6396:
      i = paramCursor.getColumnIndex("strStatus");
      if (i != -1) {
        break label12849;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStatus", String.class));
      label6433:
      i = paramCursor.getColumnIndex("strAutoRemark");
      if (i != -1) {
        break label12864;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strAutoRemark", String.class));
      label6470:
      i = paramCursor.getColumnIndex("vSeed");
      if (i != -1) {
        break label12879;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vSeed", [B.class));
      label6507:
      i = paramCursor.getColumnIndex("vCookies");
      if (i != -1) {
        break label12894;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCookies", [B.class));
      label6544:
      i = paramCursor.getColumnIndex("bQQVipOpen");
      if (i != -1) {
        break label12909;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bQQVipOpen", Byte.TYPE));
      label6581:
      i = paramCursor.getColumnIndex("iQQVipType");
      if (i != -1) {
        break label12925;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iQQVipType", Integer.TYPE));
      label6618:
      i = paramCursor.getColumnIndex("iQQVipLevel");
      if (i != -1) {
        break label12940;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iQQVipLevel", Integer.TYPE));
      label6655:
      i = paramCursor.getColumnIndex("bSuperVipOpen");
      if (i != -1) {
        break label12955;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSuperVipOpen", Byte.TYPE));
      label6692:
      i = paramCursor.getColumnIndex("iSuperVipType");
      if (i != -1) {
        break label12971;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperVipType", Integer.TYPE));
      label6729:
      i = paramCursor.getColumnIndex("iSuperVipLevel");
      if (i != -1) {
        break label12986;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperVipLevel", Integer.TYPE));
      label6766:
      i = paramCursor.getColumnIndex("bSuperQQOpen");
      if (i != -1) {
        break label13001;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSuperQQOpen", Byte.TYPE));
      label6803:
      i = paramCursor.getColumnIndex("iSuperQQType");
      if (i != -1) {
        break label13017;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperQQType", Integer.TYPE));
      label6840:
      i = paramCursor.getColumnIndex("iSuperQQLevel");
      if (i != -1) {
        break label13032;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iSuperQQLevel", Integer.TYPE));
      label6877:
      i = paramCursor.getColumnIndex("bHollywoodVipOpen");
      if (i != -1) {
        break label13047;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHollywoodVipOpen", Byte.TYPE));
      label6914:
      i = paramCursor.getColumnIndex("iHollywoodVipType");
      if (i != -1) {
        break label13063;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iHollywoodVipType", Integer.TYPE));
      label6951:
      i = paramCursor.getColumnIndex("iHollywoodVipLevel");
      if (i != -1) {
        break label13078;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iHollywoodVipLevel", Integer.TYPE));
      label6988:
      i = paramCursor.getColumnIndex("strShowName");
      if (i != -1) {
        break label13093;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strShowName", String.class));
      label7025:
      i = paramCursor.getColumnIndex("strVoiceFilekey");
      if (i != -1) {
        break label13108;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strVoiceFilekey", String.class));
      label7062:
      i = paramCursor.getColumnIndex("shDuration");
      if (i != -1) {
        break label13123;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("shDuration", Short.TYPE));
      label7099:
      i = paramCursor.getColumnIndex("bRead");
      if (i != -1) {
        break label13138;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bRead", Byte.TYPE));
      label7136:
      i = paramCursor.getColumnIndex("strUrl");
      if (i != -1) {
        break label13154;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strUrl", String.class));
      label7173:
      i = paramCursor.getColumnIndex("vRichSign");
      if (i != -1) {
        break label13169;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vRichSign", [B.class));
      label7210:
      i = paramCursor.getColumnIndex("lSignModifyTime");
      if (i != -1) {
        break label13184;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lSignModifyTime", Long.TYPE));
      label7247:
      i = paramCursor.getColumnIndex("nLastGameFlag");
      if (i != -1) {
        break label13199;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nLastGameFlag", Integer.TYPE));
      label7284:
      i = paramCursor.getColumnIndex("strGameLogoUrl_1");
      if (i != -1) {
        break label13214;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_1", String.class));
      label7321:
      i = paramCursor.getColumnIndex("strGameLogoUrl_2");
      if (i != -1) {
        break label13229;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_2", String.class));
      label7358:
      i = paramCursor.getColumnIndex("strGameLogoUrl_3");
      if (i != -1) {
        break label13244;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_3", String.class));
      label7395:
      i = paramCursor.getColumnIndex("strGameLogoUrl_4");
      if (i != -1) {
        break label13259;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoUrl_4", String.class));
      label7432:
      i = paramCursor.getColumnIndex("strGameLogoKey_1");
      if (i != -1) {
        break label13274;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_1", String.class));
      label7469:
      i = paramCursor.getColumnIndex("strGameLogoKey_2");
      if (i != -1) {
        break label13289;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_2", String.class));
      label7506:
      i = paramCursor.getColumnIndex("strGameLogoKey_3");
      if (i != -1) {
        break label13304;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_3", String.class));
      label7543:
      i = paramCursor.getColumnIndex("strGameLogoKey_4");
      if (i != -1) {
        break label13319;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameLogoKey_4", String.class));
      label7580:
      i = paramCursor.getColumnIndex("strGameName_1");
      if (i != -1) {
        break label13334;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_1", String.class));
      label7617:
      i = paramCursor.getColumnIndex("strGameName_2");
      if (i != -1) {
        break label13349;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_2", String.class));
      label7654:
      i = paramCursor.getColumnIndex("strGameName_3");
      if (i != -1) {
        break label13364;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_3", String.class));
      label7691:
      i = paramCursor.getColumnIndex("strGameName_4");
      if (i != -1) {
        break label13379;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameName_4", String.class));
      label7728:
      i = paramCursor.getColumnIndex("strGameAppid_1");
      if (i != -1) {
        break label13394;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_1", String.class));
      label7765:
      i = paramCursor.getColumnIndex("strGameAppid_2");
      if (i != -1) {
        break label13409;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_2", String.class));
      label7802:
      i = paramCursor.getColumnIndex("strGameAppid_3");
      if (i != -1) {
        break label13424;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_3", String.class));
      label7839:
      i = paramCursor.getColumnIndex("strGameAppid_4");
      if (i != -1) {
        break label13439;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strGameAppid_4", String.class));
      label7876:
      i = paramCursor.getColumnIndex("strProfileUrl");
      if (i != -1) {
        break label13454;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strProfileUrl", String.class));
      label7913:
      i = paramCursor.getColumnIndex("nStarFansFlag");
      if (i != -1) {
        break label13469;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nStarFansFlag", Integer.TYPE));
      label7950:
      i = paramCursor.getColumnIndex("strStarPicUrl_0");
      if (i != -1) {
        break label13484;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarPicUrl_0", String.class));
      label7987:
      i = paramCursor.getColumnIndex("strStarPicUrl_1");
      if (i != -1) {
        break label13499;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarPicUrl_1", String.class));
      label8024:
      i = paramCursor.getColumnIndex("strStarPicUrl_2");
      if (i != -1) {
        break label13514;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarPicUrl_2", String.class));
      label8061:
      i = paramCursor.getColumnIndex("strStarLvUrl_0");
      if (i != -1) {
        break label13529;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLvUrl_0", String.class));
      label8098:
      i = paramCursor.getColumnIndex("strStarLvUrl_1");
      if (i != -1) {
        break label13544;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLvUrl_1", String.class));
      label8135:
      i = paramCursor.getColumnIndex("strStarLvUrl_2");
      if (i != -1) {
        break label13559;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLvUrl_2", String.class));
      label8172:
      i = paramCursor.getColumnIndex("strStarLogoUrl");
      if (i != -1) {
        break label13574;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strStarLogoUrl", String.class));
      label8209:
      i = paramCursor.getColumnIndex("starFansJumpUrl");
      if (i != -1) {
        break label13589;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("starFansJumpUrl", String.class));
      label8246:
      i = paramCursor.getColumnIndex("lUserFlag");
      if (i != -1) {
        break label13604;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lUserFlag", Long.TYPE));
      label8283:
      i = paramCursor.getColumnIndex("lLoginDays");
      if (i != -1) {
        break label13619;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lLoginDays", Long.TYPE));
      label8320:
      i = paramCursor.getColumnIndex("strLoginDaysDesc");
      if (i != -1) {
        break label13634;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLoginDaysDesc", String.class));
      label8357:
      i = paramCursor.getColumnIndex("lQQMasterLogindays");
      if (i != -1) {
        break label13649;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lQQMasterLogindays", Long.TYPE));
      label8394:
      i = paramCursor.getColumnIndex("iXManScene1DelayTime");
      if (i != -1) {
        break label13664;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iXManScene1DelayTime", Integer.TYPE));
      label8431:
      i = paramCursor.getColumnIndex("iXManScene2DelayTime");
      if (i != -1) {
        break label13679;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iXManScene2DelayTime", Integer.TYPE));
      label8468:
      i = paramCursor.getColumnIndex("allowPeopleSee");
      if (i != -1) {
        break label13694;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("allowPeopleSee", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowCalInteractive");
      if (i != -1) {
        break label13721;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("allowCalInteractive", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showOnlineFriends");
      if (i != -1) {
        break label13748;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showOnlineFriends", Boolean.TYPE));
      i = paramCursor.getColumnIndex("allowClick");
      if (i != -1) {
        break label13775;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("allowClick", Boolean.TYPE));
      i = paramCursor.getColumnIndex("babyQSwitch");
      if (i != -1) {
        break label13802;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("babyQSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showLightalk");
      if (i != -1) {
        break label13829;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showLightalk", Boolean.TYPE));
      i = paramCursor.getColumnIndex("lightalkNick");
      if (i != -1) {
        break label13856;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lightalkNick", String.class));
      label8727:
      i = paramCursor.getColumnIndex("lightalkId");
      if (i != -1) {
        break label13871;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lightalkId", String.class));
      label8764:
      i = paramCursor.getColumnIndex("isSuperRedDiamond");
      if (i != -1) {
        break label13886;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSuperRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isRedDiamond");
      if (i != -1) {
        break label13913;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isRedDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("redLevel");
      if (i != -1) {
        break label13940;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("redLevel", Integer.TYPE));
      label8875:
      i = paramCursor.getColumnIndex("isSuperYellowDiamond");
      if (i != -1) {
        break label13955;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSuperYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isYellowDiamond");
      if (i != -1) {
        break label13982;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isYellowDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("yellowLevel");
      if (i != -1) {
        break label14009;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("yellowLevel", Integer.TYPE));
      label8986:
      i = paramCursor.getColumnIndex("isSuperGreenDiamond");
      if (i != -1) {
        break label14024;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSuperGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGreenDiamond");
      if (i != -1) {
        break label14051;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isGreenDiamond", Boolean.TYPE));
      i = paramCursor.getColumnIndex("greenLevel");
      if (i != -1) {
        break label14078;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("greenLevel", Integer.TYPE));
      label9097:
      i = paramCursor.getColumnIndex("uAccelerateMultiple");
      if (i != -1) {
        break label14093;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uAccelerateMultiple", Long.TYPE));
      label9134:
      i = paramCursor.getColumnIndex("strRespMusicInfo");
      if (i != -1) {
        break label14108;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strRespMusicInfo", String.class));
      label9171:
      i = paramCursor.getColumnIndex("templateRet");
      if (i != -1) {
        break label14123;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("templateRet", Integer.TYPE));
      label9208:
      i = paramCursor.getColumnIndex("lCurrentStyleId");
      if (i != -1) {
        break label14138;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCurrentStyleId", Long.TYPE));
      label9245:
      i = paramCursor.getColumnIndex("lCurrentBgId");
      if (i != -1) {
        break label14153;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCurrentBgId", Long.TYPE));
      label9282:
      i = paramCursor.getColumnIndex("backgroundUrl");
      if (i != -1) {
        break label14168;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("backgroundUrl", String.class));
      label9319:
      i = paramCursor.getColumnIndex("backgroundColor");
      if (i != -1) {
        break label14183;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("backgroundColor", Long.TYPE));
      label9356:
      i = paramCursor.getColumnIndex("dynamicCardFlag");
      if (i != -1) {
        break label14198;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dynamicCardFlag", Integer.TYPE));
      label9393:
      i = paramCursor.getColumnIndex("strZipUrl");
      if (i != -1) {
        break label14213;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strZipUrl", String.class));
      label9430:
      i = paramCursor.getColumnIndex("strActiveUrl");
      if (i != -1) {
        break label14228;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strActiveUrl", String.class));
      label9467:
      i = paramCursor.getColumnIndex("strDrawerCardUrl");
      if (i != -1) {
        break label14243;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strDrawerCardUrl", String.class));
      label9504:
      i = paramCursor.getColumnIndex("strWzryHeroUrl");
      if (i != -1) {
        break label14258;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strWzryHeroUrl", String.class));
      label9541:
      i = paramCursor.getColumnIndex("wzryHonorInfo");
      if (i != -1) {
        break label14273;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wzryHonorInfo", [B.class));
      label9578:
      i = paramCursor.getColumnIndex("strExtInfo");
      if (i != -1) {
        break label14288;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strExtInfo", String.class));
      label9615:
      i = paramCursor.getColumnIndex("strCurrentBgUrl");
      if (i != -1) {
        break label14303;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCurrentBgUrl", String.class));
      label9652:
      i = paramCursor.getColumnIndex("bgType");
      if (i != -1) {
        break label14318;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bgType", [B.class));
      label9689:
      i = paramCursor.getColumnIndex("encId");
      if (i != -1) {
        break label14333;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("encId", String.class));
      label9726:
      i = paramCursor.getColumnIndex("busiEntry");
      if (i != -1) {
        break label14348;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("busiEntry", String.class));
      label9763:
      i = paramCursor.getColumnIndex("favoriteSource");
      if (i != -1) {
        break label14363;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("favoriteSource", Integer.TYPE));
      label9800:
      i = paramCursor.getColumnIndex("visibleMusicPendant");
      if (i != -1) {
        break label14378;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("visibleMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("autoPlayMusicPendant");
      if (i != -1) {
        break label14405;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("autoPlayMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("showRedPointMusicPendant");
      if (i != -1) {
        break label14432;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showRedPointMusicPendant", Boolean.TYPE));
      i = paramCursor.getColumnIndex("privilegePromptStr");
      if (i != -1) {
        break label14459;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("privilegePromptStr", String.class));
      label9948:
      i = paramCursor.getColumnIndex("privilegeJumpUrl");
      if (i != -1) {
        break label14474;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("privilegeJumpUrl", String.class));
      label9985:
      i = paramCursor.getColumnIndex("vOpenPriv");
      if (i != -1) {
        break label14489;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vOpenPriv", [B.class));
      label10022:
      i = paramCursor.getColumnIndex("vClosePriv");
      if (i != -1) {
        break label14504;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vClosePriv", [B.class));
      label10059:
      i = paramCursor.getColumnIndex("addSrcName");
      if (i != -1) {
        break label14519;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addSrcName", String.class));
      label10096:
      i = paramCursor.getColumnIndex("addSrcId");
      if (i != -1) {
        break label14534;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addSrcId", Long.TYPE));
      label10133:
      i = paramCursor.getColumnIndex("addSubSrcId");
      if (i != -1) {
        break label14549;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("addSubSrcId", Long.TYPE));
      label10170:
      i = paramCursor.getColumnIndex("strVoteLimitedNotice");
      if (i != -1) {
        break label14564;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strVoteLimitedNotice", String.class));
      label10207:
      i = paramCursor.getColumnIndex("bHaveVotedCnt");
      if (i != -1) {
        break label14579;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHaveVotedCnt", Short.TYPE));
      label10244:
      i = paramCursor.getColumnIndex("bAvailVoteCnt");
      if (i != -1) {
        break label14594;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bAvailVoteCnt", Short.TYPE));
      label10281:
      i = paramCursor.getColumnIndex("olympicTorch");
      if (i != -1) {
        break label14609;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("olympicTorch", Byte.TYPE));
      label10318:
      i = paramCursor.getColumnIndex("mNowShowFlag");
      if (i != -1) {
        break label14625;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mNowShowFlag", Integer.TYPE));
      label10355:
      i = paramCursor.getColumnIndex("mNowShowIconUrl");
      if (i != -1) {
        break label14640;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mNowShowIconUrl", String.class));
      label10392:
      i = paramCursor.getColumnIndex("mNowShowJumpUrl");
      if (i != -1) {
        break label14655;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mNowShowJumpUrl", String.class));
      label10429:
      i = paramCursor.getColumnIndex("vCoverInfo");
      if (i != -1) {
        break label14670;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vCoverInfo", [B.class));
      label10466:
      i = paramCursor.getColumnIndex("videoHeadFlag");
      if (i != -1) {
        break label14685;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoHeadFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("videoHeadUrl");
      if (i != -1) {
        break label14712;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("videoHeadUrl", String.class));
      label10540:
      i = paramCursor.getColumnIndex("medalSwitchDisable");
      if (i != -1) {
        break label14727;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("medalSwitchDisable", Boolean.TYPE));
      i = paramCursor.getColumnIndex("iMedalCount");
      if (i != -1) {
        break label14754;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iMedalCount", Integer.TYPE));
      label10614:
      i = paramCursor.getColumnIndex("iNewCount");
      if (i != -1) {
        break label14769;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iNewCount", Integer.TYPE));
      label10651:
      i = paramCursor.getColumnIndex("iUpgradeCount");
      if (i != -1) {
        break label14784;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iUpgradeCount", Integer.TYPE));
      label10688:
      i = paramCursor.getColumnIndex("strPromptParams");
      if (i != -1) {
        break label14799;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strPromptParams", String.class));
      label10725:
      i = paramCursor.getColumnIndex("hobbyEntry");
      if (i != -1) {
        break label14814;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hobbyEntry", String.class));
      label10762:
      i = paramCursor.getColumnIndex("lastPraiseInfoList");
      if (i != -1) {
        break label14829;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastPraiseInfoList", [B.class));
      label10799:
      i = paramCursor.getColumnIndex("tempChatSig");
      if (i != -1) {
        break label14844;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("tempChatSig", [B.class));
      label10836:
      i = paramCursor.getColumnIndex("strCampusName");
      if (i != -1) {
        break label14859;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusName", String.class));
      label10873:
      i = paramCursor.getColumnIndex("strCampusAcademy");
      if (i != -1) {
        break label14874;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusAcademy", String.class));
      label10910:
      i = paramCursor.getColumnIndex("iCampusIsSigned");
      if (i != -1) {
        break label14889;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("iCampusIsSigned", Integer.TYPE));
      label10947:
      i = paramCursor.getColumnIndex("namePlateOfKingGameId");
      if (i != -1) {
        break label14904;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingGameId", Long.TYPE));
      label10984:
      i = paramCursor.getColumnIndex("namePlateOfKingLoginTime");
      if (i != -1) {
        break label14919;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingLoginTime", Long.TYPE));
      label11021:
      i = paramCursor.getColumnIndex("namePlateOfKingDan");
      if (i != -1) {
        break label14934;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingDan", Integer.TYPE));
      label11058:
      i = paramCursor.getColumnIndex("namePlateOfKingDanDisplatSwitch");
      if (i != -1) {
        break label14949;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("namePlateOfKingDanDisplatSwitch", Boolean.TYPE));
      i = paramCursor.getColumnIndex("vPersonalityLabelV2");
      if (i != -1) {
        break label14977;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vPersonalityLabelV2", [B.class));
      label11132:
      i = paramCursor.getColumnIndex("cardType");
      if (i != -1) {
        break label14992;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cardType", Integer.TYPE));
      label11169:
      i = paramCursor.getColumnIndex("diyText");
      if (i != -1) {
        break label15007;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyText", String.class));
      label11206:
      i = paramCursor.getColumnIndex("diyTextFontId");
      if (i != -1) {
        break label15022;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextFontId", Integer.TYPE));
      label11243:
      i = paramCursor.getColumnIndex("diyTextWidth");
      if (i != -1) {
        break label15037;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextWidth", Float.TYPE));
      label11280:
      i = paramCursor.getColumnIndex("diyTextHeight");
      if (i != -1) {
        break label15052;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextHeight", Float.TYPE));
      label11317:
      i = paramCursor.getColumnIndex("diyTextLocX");
      if (i != -1) {
        break label15067;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextLocX", Float.TYPE));
      label11354:
      i = paramCursor.getColumnIndex("diyTextLocY");
      if (i != -1) {
        break label15082;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextLocY", Float.TYPE));
      label11391:
      i = paramCursor.getColumnIndex("diyTextDegree");
      if (i != -1) {
        break label15097;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextDegree", Float.TYPE));
      label11428:
      i = paramCursor.getColumnIndex("diyTextScale");
      if (i != -1) {
        break label15112;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextScale", Float.TYPE));
      label11465:
      i = paramCursor.getColumnIndex("diyTextTransparency");
      if (i != -1) {
        break label15127;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyTextTransparency", Float.TYPE));
      label11502:
      i = paramCursor.getColumnIndex("diyDefaultText");
      if (i != -1) {
        break label15142;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyDefaultText", String.class));
      label11539:
      i = paramCursor.getColumnIndex("nCampusStatus");
      if (i != -1) {
        break label15157;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nCampusStatus", Integer.TYPE));
      label11576:
      i = paramCursor.getColumnIndex("lCampusLastModifySchoolTime");
      if (i != -1) {
        break label15172;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCampusLastModifySchoolTime", Long.TYPE));
      label11613:
      i = paramCursor.getColumnIndex("lCampusSchoolID");
      if (i != -1) {
        break label15187;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCampusSchoolID", Long.TYPE));
      label11650:
      i = paramCursor.getColumnIndex("lCampusCollegeID");
      if (i != -1) {
        break label15202;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lCampusCollegeID", Long.TYPE));
      label11687:
      i = paramCursor.getColumnIndex("nCampusSchoolFlag");
      if (i != -1) {
        break label15217;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nCampusSchoolFlag", Integer.TYPE));
      label11724:
      i = paramCursor.getColumnIndex("nCampusEnrolYear");
      if (i != -1) {
        break label15232;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nCampusEnrolYear", Integer.TYPE));
      label11761:
      i = paramCursor.getColumnIndex("strCampusSchool");
      if (i != -1) {
        break label15247;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusSchool", String.class));
      label11798:
      i = paramCursor.getColumnIndex("strCampusCollege");
      if (i != -1) {
        break label15262;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusCollege", String.class));
      label11835:
      i = paramCursor.getColumnIndex("strCampusClass");
      if (i != -1) {
        break label15277;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strCampusClass", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("strLastCampusFeeds");
      if (i != -1) {
        break label15292;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLastCampusFeeds", String.class));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label11926:
      paramEntity.strNick = paramCursor.getString(i);
      break label4276;
      label11941:
      paramEntity.shGender = paramCursor.getShort(i);
      break label4311;
      label11956:
      paramEntity.shAge = paramCursor.getShort(i);
      break label4346;
      label11971:
      paramEntity.nFaceID = paramCursor.getInt(i);
      break label4381;
      label11986:
      paramEntity.strCertificationInfo = paramCursor.getString(i);
      break label4416;
      label12001:
      paramEntity.shType = paramCursor.getShort(i);
      break label4451;
      label12016:
      paramEntity.vContent = paramCursor.getBlob(i);
      break label4486;
      label12031:
      paramEntity.strSign = paramCursor.getString(i);
      break label4521;
      label12046:
      paramEntity.strCompany = paramCursor.getString(i);
      break label4556;
      label12061:
      paramEntity.strSchool = paramCursor.getString(i);
      break label4591;
      label12076:
      paramEntity.uFaceTimeStamp = paramCursor.getInt(i);
      break label4626;
      label12091:
      paramEntity.vQQFaceID = paramCursor.getBlob(i);
      break label4661;
      label12106:
      paramEntity.strReMark = paramCursor.getString(i);
      break label4696;
      label12121:
      paramEntity.bWeiboInfo = ((byte)paramCursor.getShort(i));
      break label4731;
      label12137:
      paramEntity.bQzoneInfo = ((byte)paramCursor.getShort(i));
      break label4766;
      label12153:
      paramEntity.nSameFriendsNum = paramCursor.getInt(i);
      break label4801;
      label12168:
      paramEntity.strCompanySame = paramCursor.getString(i);
      break label4836;
      label12183:
      paramEntity.strSchoolSame = paramCursor.getString(i);
      break label4871;
      label12198:
      paramEntity.lCardShowNum = paramCursor.getLong(i);
      break label4906;
      label12213:
      paramEntity.bSingle = ((byte)paramCursor.getShort(i));
      break label4941;
      label12229:
      paramEntity.lVisitCount = paramCursor.getLong(i);
      break label4976;
      label12244:
      paramEntity.lVoteCount = paramCursor.getLong(i);
      break label5011;
      label12259:
      paramEntity.tagInfosByte = paramCursor.getBlob(i);
      break label5046;
      label12274:
      paramEntity.eUserIdentityType = ((byte)paramCursor.getShort(i));
      break label5081;
      label12290:
      paramEntity.vBackground = paramCursor.getBlob(i);
      break label5116;
      label12305:
      paramEntity.labelInfoBytes = paramCursor.getBlob(i);
      break label5151;
      label12320:
      paramEntity.age = ((byte)paramCursor.getShort(i));
      break label5186;
      label12336:
      paramEntity.constellation = paramCursor.getInt(i);
      break label5221;
      label12351:
      paramEntity.pyFaceUrl = paramCursor.getString(i);
      break label5256;
      label12366:
      paramEntity.location = paramCursor.getString(i);
      break label5291;
      label12381:
      paramEntity.bVoted = ((byte)paramCursor.getShort(i));
      break label5326;
      label12397:
      paramEntity.bFavorited = ((byte)paramCursor.getShort(i));
      break label5361;
      label12413:
      paramEntity.iVoteIncrement = paramCursor.getInt(i);
      break label5396;
      label12428:
      paramEntity.strJoinHexAlbumFileKey = paramCursor.getString(i);
      break label5431;
      label12443:
      paramEntity.iFaceNum = paramCursor.getInt(i);
      break label5466;
      label12458:
      paramEntity.cSqqLevel = ((byte)paramCursor.getShort(i));
      break label5501;
      label12474:
      paramEntity.iQQLevel = paramCursor.getInt(i);
      break label5536;
      label12489:
      paramEntity.strProvince = paramCursor.getString(i);
      break label5571;
      label12504:
      paramEntity.strCity = paramCursor.getString(i);
      break label5606;
      label12519:
      paramEntity.strCountry = paramCursor.getString(i);
      break label5641;
      label12534:
      paramEntity.lBirthday = paramCursor.getLong(i);
      break label5676;
      label12549:
      paramEntity.strLocationCodes = paramCursor.getString(i);
      break label5711;
      label12564:
      paramEntity.strLocationDesc = paramCursor.getString(i);
      break label5746;
      label12579:
      paramEntity.strHometownCodes = paramCursor.getString(i);
      break label5781;
      label12594:
      paramEntity.strHometownDesc = paramCursor.getString(i);
      break label5816;
      label12609:
      paramEntity.strEmail = paramCursor.getString(i);
      break label5851;
      label12624:
      paramEntity.strPersonalNote = paramCursor.getString(i);
      break label5886;
      label12639:
      paramEntity.iProfession = paramCursor.getInt(i);
      break label5921;
      label12654:
      paramEntity.bindPhoneInfo = paramCursor.getString(i);
      break label5956;
      label12669:
      paramEntity.bCardInfo = paramCursor.getBlob(i);
      break label5991;
      label12684:
      paramEntity.strTroopName = paramCursor.getString(i);
      break label6026;
      label12699:
      paramEntity.strTroopNick = paramCursor.getString(i);
      break label6063;
      label12714:
      paramEntity.strMobile = paramCursor.getString(i);
      break label6100;
      label12729:
      paramEntity.strContactName = paramCursor.getString(i);
      break label6137;
      label12744:
      paramEntity.ulShowControl = paramCursor.getInt(i);
      break label6174;
      label12759:
      paramEntity.feedPreviewTime = paramCursor.getLong(i);
      break label6211;
      label12774:
      paramEntity.strQzoneFeedsDesc = paramCursor.getString(i);
      break label6248;
      label12789:
      paramEntity.strSpaceName = paramCursor.getString(i);
      break label6285;
      label12804:
      paramEntity.strQzoneHeader = paramCursor.getString(i);
      break label6322;
      label12819:
      paramEntity.vQzonePhotos = paramCursor.getBlob(i);
      break label6359;
      label12834:
      paramEntity.vQzoneCoverInfo = paramCursor.getBlob(i);
      break label6396;
      label12849:
      paramEntity.strStatus = paramCursor.getString(i);
      break label6433;
      label12864:
      paramEntity.strAutoRemark = paramCursor.getString(i);
      break label6470;
      label12879:
      paramEntity.vSeed = paramCursor.getBlob(i);
      break label6507;
      label12894:
      paramEntity.vCookies = paramCursor.getBlob(i);
      break label6544;
      label12909:
      paramEntity.bQQVipOpen = ((byte)paramCursor.getShort(i));
      break label6581;
      label12925:
      paramEntity.iQQVipType = paramCursor.getInt(i);
      break label6618;
      label12940:
      paramEntity.iQQVipLevel = paramCursor.getInt(i);
      break label6655;
      label12955:
      paramEntity.bSuperVipOpen = ((byte)paramCursor.getShort(i));
      break label6692;
      label12971:
      paramEntity.iSuperVipType = paramCursor.getInt(i);
      break label6729;
      label12986:
      paramEntity.iSuperVipLevel = paramCursor.getInt(i);
      break label6766;
      label13001:
      paramEntity.bSuperQQOpen = ((byte)paramCursor.getShort(i));
      break label6803;
      label13017:
      paramEntity.iSuperQQType = paramCursor.getInt(i);
      break label6840;
      label13032:
      paramEntity.iSuperQQLevel = paramCursor.getInt(i);
      break label6877;
      label13047:
      paramEntity.bHollywoodVipOpen = ((byte)paramCursor.getShort(i));
      break label6914;
      label13063:
      paramEntity.iHollywoodVipType = paramCursor.getInt(i);
      break label6951;
      label13078:
      paramEntity.iHollywoodVipLevel = paramCursor.getInt(i);
      break label6988;
      label13093:
      paramEntity.strShowName = paramCursor.getString(i);
      break label7025;
      label13108:
      paramEntity.strVoiceFilekey = paramCursor.getString(i);
      break label7062;
      label13123:
      paramEntity.shDuration = paramCursor.getShort(i);
      break label7099;
      label13138:
      paramEntity.bRead = ((byte)paramCursor.getShort(i));
      break label7136;
      label13154:
      paramEntity.strUrl = paramCursor.getString(i);
      break label7173;
      label13169:
      paramEntity.vRichSign = paramCursor.getBlob(i);
      break label7210;
      label13184:
      paramEntity.lSignModifyTime = paramCursor.getLong(i);
      break label7247;
      label13199:
      paramEntity.nLastGameFlag = paramCursor.getInt(i);
      break label7284;
      label13214:
      paramEntity.strGameLogoUrl_1 = paramCursor.getString(i);
      break label7321;
      label13229:
      paramEntity.strGameLogoUrl_2 = paramCursor.getString(i);
      break label7358;
      label13244:
      paramEntity.strGameLogoUrl_3 = paramCursor.getString(i);
      break label7395;
      label13259:
      paramEntity.strGameLogoUrl_4 = paramCursor.getString(i);
      break label7432;
      label13274:
      paramEntity.strGameLogoKey_1 = paramCursor.getString(i);
      break label7469;
      label13289:
      paramEntity.strGameLogoKey_2 = paramCursor.getString(i);
      break label7506;
      label13304:
      paramEntity.strGameLogoKey_3 = paramCursor.getString(i);
      break label7543;
      label13319:
      paramEntity.strGameLogoKey_4 = paramCursor.getString(i);
      break label7580;
      label13334:
      paramEntity.strGameName_1 = paramCursor.getString(i);
      break label7617;
      label13349:
      paramEntity.strGameName_2 = paramCursor.getString(i);
      break label7654;
      label13364:
      paramEntity.strGameName_3 = paramCursor.getString(i);
      break label7691;
      label13379:
      paramEntity.strGameName_4 = paramCursor.getString(i);
      break label7728;
      label13394:
      paramEntity.strGameAppid_1 = paramCursor.getString(i);
      break label7765;
      label13409:
      paramEntity.strGameAppid_2 = paramCursor.getString(i);
      break label7802;
      label13424:
      paramEntity.strGameAppid_3 = paramCursor.getString(i);
      break label7839;
      label13439:
      paramEntity.strGameAppid_4 = paramCursor.getString(i);
      break label7876;
      label13454:
      paramEntity.strProfileUrl = paramCursor.getString(i);
      break label7913;
      label13469:
      paramEntity.nStarFansFlag = paramCursor.getInt(i);
      break label7950;
      label13484:
      paramEntity.strStarPicUrl_0 = paramCursor.getString(i);
      break label7987;
      label13499:
      paramEntity.strStarPicUrl_1 = paramCursor.getString(i);
      break label8024;
      label13514:
      paramEntity.strStarPicUrl_2 = paramCursor.getString(i);
      break label8061;
      label13529:
      paramEntity.strStarLvUrl_0 = paramCursor.getString(i);
      break label8098;
      label13544:
      paramEntity.strStarLvUrl_1 = paramCursor.getString(i);
      break label8135;
      label13559:
      paramEntity.strStarLvUrl_2 = paramCursor.getString(i);
      break label8172;
      label13574:
      paramEntity.strStarLogoUrl = paramCursor.getString(i);
      break label8209;
      label13589:
      paramEntity.starFansJumpUrl = paramCursor.getString(i);
      break label8246;
      label13604:
      paramEntity.lUserFlag = paramCursor.getLong(i);
      break label8283;
      label13619:
      paramEntity.lLoginDays = paramCursor.getLong(i);
      break label8320;
      label13634:
      paramEntity.strLoginDaysDesc = paramCursor.getString(i);
      break label8357;
      label13649:
      paramEntity.lQQMasterLogindays = paramCursor.getLong(i);
      break label8394;
      label13664:
      paramEntity.iXManScene1DelayTime = paramCursor.getInt(i);
      break label8431;
      label13679:
      paramEntity.iXManScene2DelayTime = paramCursor.getInt(i);
      break label8468;
      label13694:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowPeopleSee = paramBoolean;
        break;
      }
      label13721:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowCalInteractive = paramBoolean;
        break;
      }
      label13748:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showOnlineFriends = paramBoolean;
        break;
      }
      label13775:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.allowClick = paramBoolean;
        break;
      }
      label13802:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.babyQSwitch = paramBoolean;
        break;
      }
      label13829:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showLightalk = paramBoolean;
        break;
      }
      label13856:
      paramEntity.lightalkNick = paramCursor.getString(i);
      break label8727;
      label13871:
      paramEntity.lightalkId = paramCursor.getString(i);
      break label8764;
      label13886:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperRedDiamond = paramBoolean;
        break;
      }
      label13913:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRedDiamond = paramBoolean;
        break;
      }
      label13940:
      paramEntity.redLevel = paramCursor.getInt(i);
      break label8875;
      label13955:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperYellowDiamond = paramBoolean;
        break;
      }
      label13982:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isYellowDiamond = paramBoolean;
        break;
      }
      label14009:
      paramEntity.yellowLevel = paramCursor.getInt(i);
      break label8986;
      label14024:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSuperGreenDiamond = paramBoolean;
        break;
      }
      label14051:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isGreenDiamond = paramBoolean;
        break;
      }
      label14078:
      paramEntity.greenLevel = paramCursor.getInt(i);
      break label9097;
      label14093:
      paramEntity.uAccelerateMultiple = paramCursor.getLong(i);
      break label9134;
      label14108:
      paramEntity.strRespMusicInfo = paramCursor.getString(i);
      break label9171;
      label14123:
      paramEntity.templateRet = paramCursor.getInt(i);
      break label9208;
      label14138:
      paramEntity.lCurrentStyleId = paramCursor.getLong(i);
      break label9245;
      label14153:
      paramEntity.lCurrentBgId = paramCursor.getLong(i);
      break label9282;
      label14168:
      paramEntity.backgroundUrl = paramCursor.getString(i);
      break label9319;
      label14183:
      paramEntity.backgroundColor = paramCursor.getLong(i);
      break label9356;
      label14198:
      paramEntity.dynamicCardFlag = paramCursor.getInt(i);
      break label9393;
      label14213:
      paramEntity.strZipUrl = paramCursor.getString(i);
      break label9430;
      label14228:
      paramEntity.strActiveUrl = paramCursor.getString(i);
      break label9467;
      label14243:
      paramEntity.strDrawerCardUrl = paramCursor.getString(i);
      break label9504;
      label14258:
      paramEntity.strWzryHeroUrl = paramCursor.getString(i);
      break label9541;
      label14273:
      paramEntity.wzryHonorInfo = paramCursor.getBlob(i);
      break label9578;
      label14288:
      paramEntity.strExtInfo = paramCursor.getString(i);
      break label9615;
      label14303:
      paramEntity.strCurrentBgUrl = paramCursor.getString(i);
      break label9652;
      label14318:
      paramEntity.bgType = paramCursor.getBlob(i);
      break label9689;
      label14333:
      paramEntity.encId = paramCursor.getString(i);
      break label9726;
      label14348:
      paramEntity.busiEntry = paramCursor.getString(i);
      break label9763;
      label14363:
      paramEntity.favoriteSource = paramCursor.getInt(i);
      break label9800;
      label14378:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.visibleMusicPendant = paramBoolean;
        break;
      }
      label14405:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.autoPlayMusicPendant = paramBoolean;
        break;
      }
      label14432:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.showRedPointMusicPendant = paramBoolean;
        break;
      }
      label14459:
      paramEntity.privilegePromptStr = paramCursor.getString(i);
      break label9948;
      label14474:
      paramEntity.privilegeJumpUrl = paramCursor.getString(i);
      break label9985;
      label14489:
      paramEntity.vOpenPriv = paramCursor.getBlob(i);
      break label10022;
      label14504:
      paramEntity.vClosePriv = paramCursor.getBlob(i);
      break label10059;
      label14519:
      paramEntity.addSrcName = paramCursor.getString(i);
      break label10096;
      label14534:
      paramEntity.addSrcId = paramCursor.getLong(i);
      break label10133;
      label14549:
      paramEntity.addSubSrcId = paramCursor.getLong(i);
      break label10170;
      label14564:
      paramEntity.strVoteLimitedNotice = paramCursor.getString(i);
      break label10207;
      label14579:
      paramEntity.bHaveVotedCnt = paramCursor.getShort(i);
      break label10244;
      label14594:
      paramEntity.bAvailVoteCnt = paramCursor.getShort(i);
      break label10281;
      label14609:
      paramEntity.olympicTorch = ((byte)paramCursor.getShort(i));
      break label10318;
      label14625:
      paramEntity.mNowShowFlag = paramCursor.getInt(i);
      break label10355;
      label14640:
      paramEntity.mNowShowIconUrl = paramCursor.getString(i);
      break label10392;
      label14655:
      paramEntity.mNowShowJumpUrl = paramCursor.getString(i);
      break label10429;
      label14670:
      paramEntity.vCoverInfo = paramCursor.getBlob(i);
      break label10466;
      label14685:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.videoHeadFlag = paramBoolean;
        break;
      }
      label14712:
      paramEntity.videoHeadUrl = paramCursor.getString(i);
      break label10540;
      label14727:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.medalSwitchDisable = paramBoolean;
        break;
      }
      label14754:
      paramEntity.iMedalCount = paramCursor.getInt(i);
      break label10614;
      label14769:
      paramEntity.iNewCount = paramCursor.getInt(i);
      break label10651;
      label14784:
      paramEntity.iUpgradeCount = paramCursor.getInt(i);
      break label10688;
      label14799:
      paramEntity.strPromptParams = paramCursor.getString(i);
      break label10725;
      label14814:
      paramEntity.hobbyEntry = paramCursor.getString(i);
      break label10762;
      label14829:
      paramEntity.lastPraiseInfoList = paramCursor.getBlob(i);
      break label10799;
      label14844:
      paramEntity.tempChatSig = paramCursor.getBlob(i);
      break label10836;
      label14859:
      paramEntity.strCampusName = paramCursor.getString(i);
      break label10873;
      label14874:
      paramEntity.strCampusAcademy = paramCursor.getString(i);
      break label10910;
      label14889:
      paramEntity.iCampusIsSigned = paramCursor.getInt(i);
      break label10947;
      label14904:
      paramEntity.namePlateOfKingGameId = paramCursor.getLong(i);
      break label10984;
      label14919:
      paramEntity.namePlateOfKingLoginTime = paramCursor.getLong(i);
      break label11021;
      label14934:
      paramEntity.namePlateOfKingDan = paramCursor.getInt(i);
      break label11058;
      label14949:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.namePlateOfKingDanDisplatSwitch = paramBoolean;
        break;
      }
      label14977:
      paramEntity.vPersonalityLabelV2 = paramCursor.getBlob(i);
      break label11132;
      label14992:
      paramEntity.cardType = paramCursor.getInt(i);
      break label11169;
      label15007:
      paramEntity.diyText = paramCursor.getString(i);
      break label11206;
      label15022:
      paramEntity.diyTextFontId = paramCursor.getInt(i);
      break label11243;
      label15037:
      paramEntity.diyTextWidth = paramCursor.getFloat(i);
      break label11280;
      label15052:
      paramEntity.diyTextHeight = paramCursor.getFloat(i);
      break label11317;
      label15067:
      paramEntity.diyTextLocX = paramCursor.getFloat(i);
      break label11354;
      label15082:
      paramEntity.diyTextLocY = paramCursor.getFloat(i);
      break label11391;
      label15097:
      paramEntity.diyTextDegree = paramCursor.getFloat(i);
      break label11428;
      label15112:
      paramEntity.diyTextScale = paramCursor.getFloat(i);
      break label11465;
      label15127:
      paramEntity.diyTextTransparency = paramCursor.getFloat(i);
      break label11502;
      label15142:
      paramEntity.diyDefaultText = paramCursor.getString(i);
      break label11539;
      label15157:
      paramEntity.nCampusStatus = paramCursor.getInt(i);
      break label11576;
      label15172:
      paramEntity.lCampusLastModifySchoolTime = paramCursor.getLong(i);
      break label11613;
      label15187:
      paramEntity.lCampusSchoolID = paramCursor.getLong(i);
      break label11650;
      label15202:
      paramEntity.lCampusCollegeID = paramCursor.getLong(i);
      break label11687;
      label15217:
      paramEntity.nCampusSchoolFlag = paramCursor.getInt(i);
      break label11724;
      label15232:
      paramEntity.nCampusEnrolYear = paramCursor.getInt(i);
      break label11761;
      label15247:
      paramEntity.strCampusSchool = paramCursor.getString(i);
      break label11798;
      label15262:
      paramEntity.strCampusCollege = paramCursor.getString(i);
      break label11835;
      label15277:
      paramEntity.strCampusClass = paramCursor.getString(i);
    }
    label15292:
    paramEntity.strLastCampusFeeds = paramCursor.getString(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,strNick TEXT ,shGender INTEGER ,shAge INTEGER ,nFaceID INTEGER ,strCertificationInfo TEXT ,shType INTEGER ,vContent BLOB ,strSign TEXT ,strCompany TEXT ,strSchool TEXT ,uFaceTimeStamp INTEGER ,vQQFaceID BLOB ,strReMark TEXT ,bWeiboInfo INTEGER ,bQzoneInfo INTEGER ,nSameFriendsNum INTEGER ,strCompanySame TEXT ,strSchoolSame TEXT ,lCardShowNum INTEGER ,bSingle INTEGER ,lVisitCount INTEGER ,lVoteCount INTEGER ,tagInfosByte BLOB ,eUserIdentityType INTEGER ,vBackground BLOB ,labelInfoBytes BLOB ,age INTEGER ,constellation INTEGER ,pyFaceUrl TEXT ,location TEXT ,bVoted INTEGER ,bFavorited INTEGER ,iVoteIncrement INTEGER ,strJoinHexAlbumFileKey TEXT ,iFaceNum INTEGER ,cSqqLevel INTEGER ,iQQLevel INTEGER ,strProvince TEXT ,strCity TEXT ,strCountry TEXT ,lBirthday INTEGER ,strLocationCodes TEXT ,strLocationDesc TEXT ,strHometownCodes TEXT ,strHometownDesc TEXT ,strEmail TEXT ,strPersonalNote TEXT ,iProfession INTEGER ,bindPhoneInfo TEXT ,bCardInfo BLOB ,strTroopName TEXT ,strTroopNick TEXT ,strMobile TEXT ,strContactName TEXT ,ulShowControl INTEGER ,feedPreviewTime INTEGER ,strQzoneFeedsDesc TEXT ,strSpaceName TEXT ,strQzoneHeader TEXT ,vQzonePhotos BLOB ,vQzoneCoverInfo BLOB ,strStatus TEXT ,strAutoRemark TEXT ,vSeed BLOB ,vCookies BLOB ,bQQVipOpen INTEGER ,iQQVipType INTEGER ,iQQVipLevel INTEGER ,bSuperVipOpen INTEGER ,iSuperVipType INTEGER ,iSuperVipLevel INTEGER ,bSuperQQOpen INTEGER ,iSuperQQType INTEGER ,iSuperQQLevel INTEGER ,bHollywoodVipOpen INTEGER ,iHollywoodVipType INTEGER ,iHollywoodVipLevel INTEGER ,strShowName TEXT ,strVoiceFilekey TEXT ,shDuration INTEGER ,bRead INTEGER ,strUrl TEXT ,vRichSign BLOB ,lSignModifyTime INTEGER ,nLastGameFlag INTEGER ,strGameLogoUrl_1 TEXT ,strGameLogoUrl_2 TEXT ,strGameLogoUrl_3 TEXT ,strGameLogoUrl_4 TEXT ,strGameLogoKey_1 TEXT ,strGameLogoKey_2 TEXT ,strGameLogoKey_3 TEXT ,strGameLogoKey_4 TEXT ,strGameName_1 TEXT ,strGameName_2 TEXT ,strGameName_3 TEXT ,strGameName_4 TEXT ,strGameAppid_1 TEXT ,strGameAppid_2 TEXT ,strGameAppid_3 TEXT ,strGameAppid_4 TEXT ,strProfileUrl TEXT ,nStarFansFlag INTEGER ,strStarPicUrl_0 TEXT ,strStarPicUrl_1 TEXT ,strStarPicUrl_2 TEXT ,strStarLvUrl_0 TEXT ,strStarLvUrl_1 TEXT ,strStarLvUrl_2 TEXT ,strStarLogoUrl TEXT ,starFansJumpUrl TEXT ,lUserFlag INTEGER ,lLoginDays INTEGER ,strLoginDaysDesc TEXT ,lQQMasterLogindays INTEGER ,iXManScene1DelayTime INTEGER ,iXManScene2DelayTime INTEGER ,allowPeopleSee INTEGER ,allowCalInteractive INTEGER ,showOnlineFriends INTEGER ,allowClick INTEGER ,babyQSwitch INTEGER ,showLightalk INTEGER ,lightalkNick TEXT ,lightalkId TEXT ,isSuperRedDiamond INTEGER ,isRedDiamond INTEGER ,redLevel INTEGER ,isSuperYellowDiamond INTEGER ,isYellowDiamond INTEGER ,yellowLevel INTEGER ,isSuperGreenDiamond INTEGER ,isGreenDiamond INTEGER ,greenLevel INTEGER ,uAccelerateMultiple INTEGER ,strRespMusicInfo TEXT ,templateRet INTEGER ,lCurrentStyleId INTEGER ,lCurrentBgId INTEGER ,backgroundUrl TEXT ,backgroundColor INTEGER ,dynamicCardFlag INTEGER ,strZipUrl TEXT ,strActiveUrl TEXT ,strDrawerCardUrl TEXT ,strWzryHeroUrl TEXT ,wzryHonorInfo BLOB ,strExtInfo TEXT ,strCurrentBgUrl TEXT ,bgType BLOB ,encId TEXT ,busiEntry TEXT ,favoriteSource INTEGER ,visibleMusicPendant INTEGER ,autoPlayMusicPendant INTEGER ,showRedPointMusicPendant INTEGER ,privilegePromptStr TEXT ,privilegeJumpUrl TEXT ,vOpenPriv BLOB ,vClosePriv BLOB ,addSrcName TEXT ,addSrcId INTEGER ,addSubSrcId INTEGER ,strVoteLimitedNotice TEXT ,bHaveVotedCnt INTEGER ,bAvailVoteCnt INTEGER ,olympicTorch INTEGER ,mNowShowFlag INTEGER ,mNowShowIconUrl TEXT ,mNowShowJumpUrl TEXT ,vCoverInfo BLOB ,videoHeadFlag INTEGER ,videoHeadUrl TEXT ,medalSwitchDisable INTEGER ,iMedalCount INTEGER ,iNewCount INTEGER ,iUpgradeCount INTEGER ,strPromptParams TEXT ,hobbyEntry TEXT ,lastPraiseInfoList BLOB ,tempChatSig BLOB ,strCampusName TEXT ,strCampusAcademy TEXT ,iCampusIsSigned INTEGER ,namePlateOfKingGameId INTEGER ,namePlateOfKingLoginTime INTEGER ,namePlateOfKingDan INTEGER ,namePlateOfKingDanDisplatSwitch INTEGER ,vPersonalityLabelV2 BLOB ,cardType INTEGER ,diyText TEXT ,diyTextFontId INTEGER ,diyTextWidth REAL ,diyTextHeight REAL ,diyTextLocX REAL ,diyTextLocY REAL ,diyTextDegree REAL ,diyTextScale REAL ,diyTextTransparency REAL ,diyDefaultText TEXT ,nCampusStatus INTEGER ,lCampusLastModifySchoolTime INTEGER ,lCampusSchoolID INTEGER ,lCampusCollegeID INTEGER ,nCampusSchoolFlag INTEGER ,nCampusEnrolYear INTEGER ,strCampusSchool TEXT ,strCampusCollege TEXT ,strCampusClass TEXT ,strLastCampusFeeds TEXT)");
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.CardDao
 * JD-Core Version:    0.7.0.1
 */