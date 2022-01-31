package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.TroopInfo;

public class TroopInfoDao
  extends OGAbstractDao
{
  public TroopInfoDao()
  {
    this.a = 89;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (TroopInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramEntity.troopuin = paramCursor.getString(paramCursor.getColumnIndex("troopuin"));
      paramEntity.troopcode = paramCursor.getString(paramCursor.getColumnIndex("troopcode"));
      paramEntity.troopowneruin = paramCursor.getString(paramCursor.getColumnIndex("troopowneruin"));
      paramEntity.troopname = paramCursor.getString(paramCursor.getColumnIndex("troopname"));
      paramEntity.newTroopName = paramCursor.getString(paramCursor.getColumnIndex("newTroopName"));
      paramEntity.newTroopNameTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("newTroopNameTimeStamp"));
      paramEntity.troopface = paramCursor.getShort(paramCursor.getColumnIndex("troopface"));
      paramEntity.troopmemo = paramCursor.getString(paramCursor.getColumnIndex("troopmemo"));
      paramEntity.fingertroopmemo = paramCursor.getString(paramCursor.getColumnIndex("fingertroopmemo"));
      paramEntity.mRichFingerMemo = paramCursor.getString(paramCursor.getColumnIndex("mRichFingerMemo"));
      paramEntity.troopmask = paramCursor.getInt(paramCursor.getColumnIndex("troopmask"));
      paramEntity.trooptype = paramCursor.getInt(paramCursor.getColumnIndex("trooptype"));
      paramEntity.troopCreateTime = paramCursor.getLong(paramCursor.getColumnIndex("troopCreateTime"));
      paramEntity.dwGroupFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlag"));
      paramEntity.cGroupOption = paramCursor.getShort(paramCursor.getColumnIndex("cGroupOption"));
      paramEntity.wMemberMax = paramCursor.getInt(paramCursor.getColumnIndex("wMemberMax"));
      paramEntity.maxAdminNum = paramCursor.getInt(paramCursor.getColumnIndex("maxAdminNum"));
      paramEntity.wSpecialClass = paramCursor.getInt(paramCursor.getColumnIndex("wSpecialClass"));
      paramEntity.cGroupLevel = paramCursor.getShort(paramCursor.getColumnIndex("cGroupLevel"));
      paramEntity.wMemberNum = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNum"));
      paramEntity.wMemberNumClient = paramCursor.getInt(paramCursor.getColumnIndex("wMemberNumClient"));
      paramEntity.Administrator = paramCursor.getString(paramCursor.getColumnIndex("Administrator"));
      paramEntity.dwGroupClassExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupClassExt"));
      paramEntity.mGroupClassExtText = paramCursor.getString(paramCursor.getColumnIndex("mGroupClassExtText"));
      paramEntity.dwGroupFlagExt = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt"));
      paramEntity.dwAuthGroupType = paramCursor.getLong(paramCursor.getColumnIndex("dwAuthGroupType"));
      paramEntity.troopAuthenticateInfo = paramCursor.getString(paramCursor.getColumnIndex("troopAuthenticateInfo"));
      paramEntity.dwGroupInfoSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupInfoSeq"));
      paramEntity.mMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberNumSeq"));
      paramEntity.mOldMemberNumSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberNumSeq"));
      paramEntity.mMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mMemberCardSeq"));
      paramEntity.mOldMemberCardSeq = paramCursor.getLong(paramCursor.getColumnIndex("mOldMemberCardSeq"));
      paramEntity.dwGroupLevelSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupLevelSeq"));
      paramEntity.cGroupRankSysFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankSysFlag")));
      paramEntity.cGroupRankUserFlag = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cGroupRankUserFlag")));
      paramEntity.troopLevelMap = paramCursor.getString(paramCursor.getColumnIndex("troopLevelMap"));
      paramEntity.joinTroopQuestion = paramCursor.getString(paramCursor.getColumnIndex("joinTroopQuestion"));
      paramEntity.joinTroopAnswer = paramCursor.getString(paramCursor.getColumnIndex("joinTroopAnswer"));
      paramEntity.cAlbumResult = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cAlbumResult")));
      paramEntity.dwTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwTimeStamp"));
      paramEntity.strQZonePhotoUrls = paramCursor.getString(paramCursor.getColumnIndex("strQZonePhotoUrls"));
      paramEntity.mQZonePhotoNum = paramCursor.getInt(paramCursor.getColumnIndex("mQZonePhotoNum"));
      paramEntity.strLocation = paramCursor.getString(paramCursor.getColumnIndex("strLocation"));
      paramEntity.troopLat = paramCursor.getInt(paramCursor.getColumnIndex("troopLat"));
      paramEntity.troopLon = paramCursor.getInt(paramCursor.getColumnIndex("troopLon"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("mMemberInvitingFlag")))
      {
        paramBoolean = true;
        paramEntity.mMemberInvitingFlag = paramBoolean;
        paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
        paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
        paramEntity.mSomeMemberUins = paramCursor.getString(paramCursor.getColumnIndex("mSomeMemberUins"));
        paramEntity.mHeaderUinsOld = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsOld"));
        paramEntity.mHeaderUinsNew = paramCursor.getString(paramCursor.getColumnIndex("mHeaderUinsNew"));
        paramEntity.mTags = paramCursor.getString(paramCursor.getColumnIndex("mTags"));
        paramEntity.mTroopAvatarId = paramCursor.getInt(paramCursor.getColumnIndex("mTroopAvatarId"));
        paramEntity.nTroopGrade = paramCursor.getInt(paramCursor.getColumnIndex("nTroopGrade"));
        paramEntity.isShowInNearbyTroops = paramCursor.getInt(paramCursor.getColumnIndex("isShowInNearbyTroops"));
        paramEntity.dwGagTimeStamp = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp"));
        paramEntity.dwGagTimeStamp_me = paramCursor.getLong(paramCursor.getColumnIndex("dwGagTimeStamp_me"));
        paramEntity.dwCmdUinUinFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinUinFlag"));
        paramEntity.dwAdditionalFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAdditionalFlag"));
        paramEntity.troopTypeExt = paramCursor.getInt(paramCursor.getColumnIndex("troopTypeExt"));
        paramEntity.ownerNameShow = paramCursor.getString(paramCursor.getColumnIndex("ownerNameShow"));
        paramEntity.adminNameShow = paramCursor.getString(paramCursor.getColumnIndex("adminNameShow"));
        paramEntity.dwOfficeMode = paramCursor.getLong(paramCursor.getColumnIndex("dwOfficeMode"));
        paramEntity.dwGroupFlagExt3 = paramCursor.getLong(paramCursor.getColumnIndex("dwGroupFlagExt3"));
        paramEntity.memberListToShow = paramCursor.getString(paramCursor.getColumnIndex("memberListToShow"));
        paramEntity.troopPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("troopPrivilegeFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isNewTroop"))) {
          break label1707;
        }
        paramBoolean = true;
        label1286:
        paramEntity.isNewTroop = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopHead"))) {
          break label1712;
        }
        paramBoolean = true;
        label1312:
        paramEntity.hasSetNewTroopHead = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasSetNewTroopName"))) {
          break label1717;
        }
        paramBoolean = true;
        label1338:
        paramEntity.hasSetNewTroopName = paramBoolean;
        paramEntity.maxInviteMemNum = paramCursor.getInt(paramCursor.getColumnIndex("maxInviteMemNum"));
        paramEntity.lastMsgTime = paramCursor.getLong(paramCursor.getColumnIndex("lastMsgTime"));
        paramEntity.mTroopNeedPayNumber = paramCursor.getFloat(paramCursor.getColumnIndex("mTroopNeedPayNumber"));
        paramEntity.troopCreditLevel = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevel"));
        paramEntity.troopCreditLevelInfo = paramCursor.getLong(paramCursor.getColumnIndex("troopCreditLevelInfo"));
        paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(paramCursor.getColumnIndex("dwAppPrivilegeFlag"));
        paramEntity.topicId = paramCursor.getString(paramCursor.getColumnIndex("topicId"));
        paramEntity.associatePubAccount = paramCursor.getLong(paramCursor.getColumnIndex("associatePubAccount"));
        paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(paramCursor.getColumnIndex("mTroopFileVideoReqInterval"));
        paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(paramCursor.getColumnIndex("mTroopFileVideoIsWhite"));
        paramEntity.mTribeStatus = paramCursor.getInt(paramCursor.getColumnIndex("mTribeStatus"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByKeywords"))) {
          break label1722;
        }
        paramBoolean = true;
        label1573:
        paramEntity.mCanSearchByKeywords = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("mCanSearchByTroopUin"))) {
          break label1727;
        }
      }
      label1707:
      label1712:
      label1717:
      label1722:
      label1727:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.mCanSearchByTroopUin = paramBoolean;
        paramEntity.dwCmdUinJoinTime = paramCursor.getLong(paramCursor.getColumnIndex("dwCmdUinJoinTime"));
        paramEntity.dwLastInsertBAFTipTime = paramCursor.getLong(paramCursor.getColumnIndex("dwLastInsertBAFTipTime"));
        paramEntity.wInsertBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wInsertBAFTipCount"));
        paramEntity.wClickBAFTipCount = paramCursor.getInt(paramCursor.getColumnIndex("wClickBAFTipCount"));
        paramEntity.dwLastBAFTipMsgUniSeq = paramCursor.getLong(paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1286;
        paramBoolean = false;
        break label1312;
        paramBoolean = false;
        break label1338;
        paramBoolean = false;
        break label1573;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label4936;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timeSec", Long.TYPE));
      label1802:
      i = paramCursor.getColumnIndex("troopuin");
      if (i != -1) {
        break label4951;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopuin", String.class));
      label1837:
      i = paramCursor.getColumnIndex("troopcode");
      if (i != -1) {
        break label4966;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopcode", String.class));
      label1872:
      i = paramCursor.getColumnIndex("troopowneruin");
      if (i != -1) {
        break label4981;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopowneruin", String.class));
      label1907:
      i = paramCursor.getColumnIndex("troopname");
      if (i != -1) {
        break label4996;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopname", String.class));
      label1942:
      i = paramCursor.getColumnIndex("newTroopName");
      if (i != -1) {
        break label5011;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("newTroopName", String.class));
      label1977:
      i = paramCursor.getColumnIndex("newTroopNameTimeStamp");
      if (i != -1) {
        break label5026;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("newTroopNameTimeStamp", Long.TYPE));
      label2012:
      i = paramCursor.getColumnIndex("troopface");
      if (i != -1) {
        break label5041;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopface", Short.TYPE));
      label2047:
      i = paramCursor.getColumnIndex("troopmemo");
      if (i != -1) {
        break label5056;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopmemo", String.class));
      label2082:
      i = paramCursor.getColumnIndex("fingertroopmemo");
      if (i != -1) {
        break label5071;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("fingertroopmemo", String.class));
      label2117:
      i = paramCursor.getColumnIndex("mRichFingerMemo");
      if (i != -1) {
        break label5086;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mRichFingerMemo", String.class));
      label2152:
      i = paramCursor.getColumnIndex("troopmask");
      if (i != -1) {
        break label5101;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopmask", Integer.TYPE));
      label2187:
      i = paramCursor.getColumnIndex("trooptype");
      if (i != -1) {
        break label5116;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("trooptype", Integer.TYPE));
      label2222:
      i = paramCursor.getColumnIndex("troopCreateTime");
      if (i != -1) {
        break label5131;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopCreateTime", Long.TYPE));
      label2257:
      i = paramCursor.getColumnIndex("dwGroupFlag");
      if (i != -1) {
        break label5146;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupFlag", Long.TYPE));
      label2292:
      i = paramCursor.getColumnIndex("cGroupOption");
      if (i != -1) {
        break label5161;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cGroupOption", Short.TYPE));
      label2327:
      i = paramCursor.getColumnIndex("wMemberMax");
      if (i != -1) {
        break label5176;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wMemberMax", Integer.TYPE));
      label2362:
      i = paramCursor.getColumnIndex("maxAdminNum");
      if (i != -1) {
        break label5191;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("maxAdminNum", Integer.TYPE));
      label2397:
      i = paramCursor.getColumnIndex("wSpecialClass");
      if (i != -1) {
        break label5206;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wSpecialClass", Integer.TYPE));
      label2432:
      i = paramCursor.getColumnIndex("cGroupLevel");
      if (i != -1) {
        break label5221;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cGroupLevel", Short.TYPE));
      label2467:
      i = paramCursor.getColumnIndex("wMemberNum");
      if (i != -1) {
        break label5236;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wMemberNum", Integer.TYPE));
      label2502:
      i = paramCursor.getColumnIndex("wMemberNumClient");
      if (i != -1) {
        break label5251;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wMemberNumClient", Integer.TYPE));
      label2537:
      i = paramCursor.getColumnIndex("Administrator");
      if (i != -1) {
        break label5266;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("Administrator", String.class));
      label2572:
      i = paramCursor.getColumnIndex("dwGroupClassExt");
      if (i != -1) {
        break label5281;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupClassExt", Long.TYPE));
      label2607:
      i = paramCursor.getColumnIndex("mGroupClassExtText");
      if (i != -1) {
        break label5296;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mGroupClassExtText", String.class));
      label2642:
      i = paramCursor.getColumnIndex("dwGroupFlagExt");
      if (i != -1) {
        break label5311;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupFlagExt", Long.TYPE));
      label2677:
      i = paramCursor.getColumnIndex("dwAuthGroupType");
      if (i != -1) {
        break label5326;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwAuthGroupType", Long.TYPE));
      label2712:
      i = paramCursor.getColumnIndex("troopAuthenticateInfo");
      if (i != -1) {
        break label5341;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopAuthenticateInfo", String.class));
      label2747:
      i = paramCursor.getColumnIndex("dwGroupInfoSeq");
      if (i != -1) {
        break label5356;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupInfoSeq", Long.TYPE));
      label2782:
      i = paramCursor.getColumnIndex("mMemberNumSeq");
      if (i != -1) {
        break label5371;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mMemberNumSeq", Long.TYPE));
      label2817:
      i = paramCursor.getColumnIndex("mOldMemberNumSeq");
      if (i != -1) {
        break label5386;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mOldMemberNumSeq", Long.TYPE));
      label2852:
      i = paramCursor.getColumnIndex("mMemberCardSeq");
      if (i != -1) {
        break label5401;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mMemberCardSeq", Long.TYPE));
      label2887:
      i = paramCursor.getColumnIndex("mOldMemberCardSeq");
      if (i != -1) {
        break label5416;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mOldMemberCardSeq", Long.TYPE));
      label2922:
      i = paramCursor.getColumnIndex("dwGroupLevelSeq");
      if (i != -1) {
        break label5431;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupLevelSeq", Long.TYPE));
      label2957:
      i = paramCursor.getColumnIndex("cGroupRankSysFlag");
      if (i != -1) {
        break label5446;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cGroupRankSysFlag", Byte.TYPE));
      label2992:
      i = paramCursor.getColumnIndex("cGroupRankUserFlag");
      if (i != -1) {
        break label5462;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cGroupRankUserFlag", Byte.TYPE));
      label3027:
      i = paramCursor.getColumnIndex("troopLevelMap");
      if (i != -1) {
        break label5478;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopLevelMap", String.class));
      label3062:
      i = paramCursor.getColumnIndex("joinTroopQuestion");
      if (i != -1) {
        break label5493;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("joinTroopQuestion", String.class));
      label3097:
      i = paramCursor.getColumnIndex("joinTroopAnswer");
      if (i != -1) {
        break label5508;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("joinTroopAnswer", String.class));
      label3132:
      i = paramCursor.getColumnIndex("cAlbumResult");
      if (i != -1) {
        break label5523;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("cAlbumResult", Byte.TYPE));
      label3167:
      i = paramCursor.getColumnIndex("dwTimeStamp");
      if (i != -1) {
        break label5539;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwTimeStamp", Long.TYPE));
      label3202:
      i = paramCursor.getColumnIndex("strQZonePhotoUrls");
      if (i != -1) {
        break label5554;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strQZonePhotoUrls", String.class));
      label3237:
      i = paramCursor.getColumnIndex("mQZonePhotoNum");
      if (i != -1) {
        break label5569;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mQZonePhotoNum", Integer.TYPE));
      label3272:
      i = paramCursor.getColumnIndex("strLocation");
      if (i != -1) {
        break label5584;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("strLocation", String.class));
      label3307:
      i = paramCursor.getColumnIndex("troopLat");
      if (i != -1) {
        break label5599;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopLat", Integer.TYPE));
      label3342:
      i = paramCursor.getColumnIndex("troopLon");
      if (i != -1) {
        break label5614;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopLon", Integer.TYPE));
      label3377:
      i = paramCursor.getColumnIndex("mMemberInvitingFlag");
      if (i != -1) {
        break label5629;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mMemberInvitingFlag", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label5656;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label3447:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label5671;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mCompareSpell", String.class));
      label3482:
      i = paramCursor.getColumnIndex("mSomeMemberUins");
      if (i != -1) {
        break label5686;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mSomeMemberUins", String.class));
      label3517:
      i = paramCursor.getColumnIndex("mHeaderUinsOld");
      if (i != -1) {
        break label5701;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mHeaderUinsOld", String.class));
      label3552:
      i = paramCursor.getColumnIndex("mHeaderUinsNew");
      if (i != -1) {
        break label5716;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mHeaderUinsNew", String.class));
      label3587:
      i = paramCursor.getColumnIndex("mTags");
      if (i != -1) {
        break label5731;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTags", String.class));
      label3624:
      i = paramCursor.getColumnIndex("mTroopAvatarId");
      if (i != -1) {
        break label5746;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTroopAvatarId", Integer.TYPE));
      label3661:
      i = paramCursor.getColumnIndex("nTroopGrade");
      if (i != -1) {
        break label5761;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("nTroopGrade", Integer.TYPE));
      label3698:
      i = paramCursor.getColumnIndex("isShowInNearbyTroops");
      if (i != -1) {
        break label5776;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isShowInNearbyTroops", Integer.TYPE));
      label3735:
      i = paramCursor.getColumnIndex("dwGagTimeStamp");
      if (i != -1) {
        break label5791;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGagTimeStamp", Long.TYPE));
      label3772:
      i = paramCursor.getColumnIndex("dwGagTimeStamp_me");
      if (i != -1) {
        break label5806;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGagTimeStamp_me", Long.TYPE));
      label3809:
      i = paramCursor.getColumnIndex("dwCmdUinUinFlag");
      if (i != -1) {
        break label5821;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwCmdUinUinFlag", Long.TYPE));
      label3846:
      i = paramCursor.getColumnIndex("dwAdditionalFlag");
      if (i != -1) {
        break label5836;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwAdditionalFlag", Long.TYPE));
      label3883:
      i = paramCursor.getColumnIndex("troopTypeExt");
      if (i != -1) {
        break label5851;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopTypeExt", Integer.TYPE));
      label3920:
      i = paramCursor.getColumnIndex("ownerNameShow");
      if (i != -1) {
        break label5866;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ownerNameShow", String.class));
      label3957:
      i = paramCursor.getColumnIndex("adminNameShow");
      if (i != -1) {
        break label5881;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("adminNameShow", String.class));
      label3994:
      i = paramCursor.getColumnIndex("dwOfficeMode");
      if (i != -1) {
        break label5896;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwOfficeMode", Long.TYPE));
      label4031:
      i = paramCursor.getColumnIndex("dwGroupFlagExt3");
      if (i != -1) {
        break label5911;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwGroupFlagExt3", Long.TYPE));
      label4068:
      i = paramCursor.getColumnIndex("memberListToShow");
      if (i != -1) {
        break label5926;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("memberListToShow", String.class));
      label4105:
      i = paramCursor.getColumnIndex("troopPrivilegeFlag");
      if (i != -1) {
        break label5941;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopPrivilegeFlag", Long.TYPE));
      label4142:
      i = paramCursor.getColumnIndex("isNewTroop");
      if (i != -1) {
        break label5956;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isNewTroop", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopHead");
      if (i != -1) {
        break label5983;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasSetNewTroopHead", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasSetNewTroopName");
      if (i != -1) {
        break label6010;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasSetNewTroopName", Boolean.TYPE));
      i = paramCursor.getColumnIndex("maxInviteMemNum");
      if (i != -1) {
        break label6037;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("maxInviteMemNum", Integer.TYPE));
      label4290:
      i = paramCursor.getColumnIndex("lastMsgTime");
      if (i != -1) {
        break label6052;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastMsgTime", Long.TYPE));
      label4327:
      i = paramCursor.getColumnIndex("mTroopNeedPayNumber");
      if (i != -1) {
        break label6067;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTroopNeedPayNumber", Float.TYPE));
      label4364:
      i = paramCursor.getColumnIndex("troopCreditLevel");
      if (i != -1) {
        break label6082;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopCreditLevel", Long.TYPE));
      label4401:
      i = paramCursor.getColumnIndex("troopCreditLevelInfo");
      if (i != -1) {
        break label6097;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("troopCreditLevelInfo", Long.TYPE));
      label4438:
      i = paramCursor.getColumnIndex("dwAppPrivilegeFlag");
      if (i != -1) {
        break label6112;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwAppPrivilegeFlag", Long.TYPE));
      label4475:
      i = paramCursor.getColumnIndex("topicId");
      if (i != -1) {
        break label6127;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("topicId", String.class));
      label4512:
      i = paramCursor.getColumnIndex("associatePubAccount");
      if (i != -1) {
        break label6142;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("associatePubAccount", Long.TYPE));
      label4549:
      i = paramCursor.getColumnIndex("mTroopFileVideoReqInterval");
      if (i != -1) {
        break label6157;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTroopFileVideoReqInterval", Long.TYPE));
      label4586:
      i = paramCursor.getColumnIndex("mTroopFileVideoIsWhite");
      if (i != -1) {
        break label6172;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTroopFileVideoIsWhite", Integer.TYPE));
      label4623:
      i = paramCursor.getColumnIndex("mTribeStatus");
      if (i != -1) {
        break label6187;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mTribeStatus", Integer.TYPE));
      label4660:
      i = paramCursor.getColumnIndex("mCanSearchByKeywords");
      if (i != -1) {
        break label6202;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mCanSearchByKeywords", Boolean.TYPE));
      i = paramCursor.getColumnIndex("mCanSearchByTroopUin");
      if (i != -1) {
        break label6229;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mCanSearchByTroopUin", Boolean.TYPE));
      i = paramCursor.getColumnIndex("dwCmdUinJoinTime");
      if (i != -1) {
        break label6257;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwCmdUinJoinTime", Long.TYPE));
      label4771:
      i = paramCursor.getColumnIndex("dwLastInsertBAFTipTime");
      if (i != -1) {
        break label6272;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwLastInsertBAFTipTime", Long.TYPE));
      label4808:
      i = paramCursor.getColumnIndex("wInsertBAFTipCount");
      if (i != -1) {
        break label6287;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wInsertBAFTipCount", Integer.TYPE));
      label4845:
      i = paramCursor.getColumnIndex("wClickBAFTipCount");
      if (i != -1) {
        break label6302;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("wClickBAFTipCount", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("dwLastBAFTipMsgUniSeq");
      if (i != -1) {
        break label6317;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("dwLastBAFTipMsgUniSeq", Long.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label4936:
      paramEntity.timeSec = paramCursor.getLong(i);
      break label1802;
      label4951:
      paramEntity.troopuin = paramCursor.getString(i);
      break label1837;
      label4966:
      paramEntity.troopcode = paramCursor.getString(i);
      break label1872;
      label4981:
      paramEntity.troopowneruin = paramCursor.getString(i);
      break label1907;
      label4996:
      paramEntity.troopname = paramCursor.getString(i);
      break label1942;
      label5011:
      paramEntity.newTroopName = paramCursor.getString(i);
      break label1977;
      label5026:
      paramEntity.newTroopNameTimeStamp = paramCursor.getLong(i);
      break label2012;
      label5041:
      paramEntity.troopface = paramCursor.getShort(i);
      break label2047;
      label5056:
      paramEntity.troopmemo = paramCursor.getString(i);
      break label2082;
      label5071:
      paramEntity.fingertroopmemo = paramCursor.getString(i);
      break label2117;
      label5086:
      paramEntity.mRichFingerMemo = paramCursor.getString(i);
      break label2152;
      label5101:
      paramEntity.troopmask = paramCursor.getInt(i);
      break label2187;
      label5116:
      paramEntity.trooptype = paramCursor.getInt(i);
      break label2222;
      label5131:
      paramEntity.troopCreateTime = paramCursor.getLong(i);
      break label2257;
      label5146:
      paramEntity.dwGroupFlag = paramCursor.getLong(i);
      break label2292;
      label5161:
      paramEntity.cGroupOption = paramCursor.getShort(i);
      break label2327;
      label5176:
      paramEntity.wMemberMax = paramCursor.getInt(i);
      break label2362;
      label5191:
      paramEntity.maxAdminNum = paramCursor.getInt(i);
      break label2397;
      label5206:
      paramEntity.wSpecialClass = paramCursor.getInt(i);
      break label2432;
      label5221:
      paramEntity.cGroupLevel = paramCursor.getShort(i);
      break label2467;
      label5236:
      paramEntity.wMemberNum = paramCursor.getInt(i);
      break label2502;
      label5251:
      paramEntity.wMemberNumClient = paramCursor.getInt(i);
      break label2537;
      label5266:
      paramEntity.Administrator = paramCursor.getString(i);
      break label2572;
      label5281:
      paramEntity.dwGroupClassExt = paramCursor.getLong(i);
      break label2607;
      label5296:
      paramEntity.mGroupClassExtText = paramCursor.getString(i);
      break label2642;
      label5311:
      paramEntity.dwGroupFlagExt = paramCursor.getLong(i);
      break label2677;
      label5326:
      paramEntity.dwAuthGroupType = paramCursor.getLong(i);
      break label2712;
      label5341:
      paramEntity.troopAuthenticateInfo = paramCursor.getString(i);
      break label2747;
      label5356:
      paramEntity.dwGroupInfoSeq = paramCursor.getLong(i);
      break label2782;
      label5371:
      paramEntity.mMemberNumSeq = paramCursor.getLong(i);
      break label2817;
      label5386:
      paramEntity.mOldMemberNumSeq = paramCursor.getLong(i);
      break label2852;
      label5401:
      paramEntity.mMemberCardSeq = paramCursor.getLong(i);
      break label2887;
      label5416:
      paramEntity.mOldMemberCardSeq = paramCursor.getLong(i);
      break label2922;
      label5431:
      paramEntity.dwGroupLevelSeq = paramCursor.getLong(i);
      break label2957;
      label5446:
      paramEntity.cGroupRankSysFlag = ((byte)paramCursor.getShort(i));
      break label2992;
      label5462:
      paramEntity.cGroupRankUserFlag = ((byte)paramCursor.getShort(i));
      break label3027;
      label5478:
      paramEntity.troopLevelMap = paramCursor.getString(i);
      break label3062;
      label5493:
      paramEntity.joinTroopQuestion = paramCursor.getString(i);
      break label3097;
      label5508:
      paramEntity.joinTroopAnswer = paramCursor.getString(i);
      break label3132;
      label5523:
      paramEntity.cAlbumResult = ((byte)paramCursor.getShort(i));
      break label3167;
      label5539:
      paramEntity.dwTimeStamp = paramCursor.getLong(i);
      break label3202;
      label5554:
      paramEntity.strQZonePhotoUrls = paramCursor.getString(i);
      break label3237;
      label5569:
      paramEntity.mQZonePhotoNum = paramCursor.getInt(i);
      break label3272;
      label5584:
      paramEntity.strLocation = paramCursor.getString(i);
      break label3307;
      label5599:
      paramEntity.troopLat = paramCursor.getInt(i);
      break label3342;
      label5614:
      paramEntity.troopLon = paramCursor.getInt(i);
      break label3377;
      label5629:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mMemberInvitingFlag = paramBoolean;
        break;
      }
      label5656:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label3447;
      label5671:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label3482;
      label5686:
      paramEntity.mSomeMemberUins = paramCursor.getString(i);
      break label3517;
      label5701:
      paramEntity.mHeaderUinsOld = paramCursor.getString(i);
      break label3552;
      label5716:
      paramEntity.mHeaderUinsNew = paramCursor.getString(i);
      break label3587;
      label5731:
      paramEntity.mTags = paramCursor.getString(i);
      break label3624;
      label5746:
      paramEntity.mTroopAvatarId = paramCursor.getInt(i);
      break label3661;
      label5761:
      paramEntity.nTroopGrade = paramCursor.getInt(i);
      break label3698;
      label5776:
      paramEntity.isShowInNearbyTroops = paramCursor.getInt(i);
      break label3735;
      label5791:
      paramEntity.dwGagTimeStamp = paramCursor.getLong(i);
      break label3772;
      label5806:
      paramEntity.dwGagTimeStamp_me = paramCursor.getLong(i);
      break label3809;
      label5821:
      paramEntity.dwCmdUinUinFlag = paramCursor.getLong(i);
      break label3846;
      label5836:
      paramEntity.dwAdditionalFlag = paramCursor.getLong(i);
      break label3883;
      label5851:
      paramEntity.troopTypeExt = paramCursor.getInt(i);
      break label3920;
      label5866:
      paramEntity.ownerNameShow = paramCursor.getString(i);
      break label3957;
      label5881:
      paramEntity.adminNameShow = paramCursor.getString(i);
      break label3994;
      label5896:
      paramEntity.dwOfficeMode = paramCursor.getLong(i);
      break label4031;
      label5911:
      paramEntity.dwGroupFlagExt3 = paramCursor.getLong(i);
      break label4068;
      label5926:
      paramEntity.memberListToShow = paramCursor.getString(i);
      break label4105;
      label5941:
      paramEntity.troopPrivilegeFlag = paramCursor.getLong(i);
      break label4142;
      label5956:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isNewTroop = paramBoolean;
        break;
      }
      label5983:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSetNewTroopHead = paramBoolean;
        break;
      }
      label6010:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSetNewTroopName = paramBoolean;
        break;
      }
      label6037:
      paramEntity.maxInviteMemNum = paramCursor.getInt(i);
      break label4290;
      label6052:
      paramEntity.lastMsgTime = paramCursor.getLong(i);
      break label4327;
      label6067:
      paramEntity.mTroopNeedPayNumber = paramCursor.getFloat(i);
      break label4364;
      label6082:
      paramEntity.troopCreditLevel = paramCursor.getLong(i);
      break label4401;
      label6097:
      paramEntity.troopCreditLevelInfo = paramCursor.getLong(i);
      break label4438;
      label6112:
      paramEntity.dwAppPrivilegeFlag = paramCursor.getLong(i);
      break label4475;
      label6127:
      paramEntity.topicId = paramCursor.getString(i);
      break label4512;
      label6142:
      paramEntity.associatePubAccount = paramCursor.getLong(i);
      break label4549;
      label6157:
      paramEntity.mTroopFileVideoReqInterval = paramCursor.getLong(i);
      break label4586;
      label6172:
      paramEntity.mTroopFileVideoIsWhite = paramCursor.getInt(i);
      break label4623;
      label6187:
      paramEntity.mTribeStatus = paramCursor.getInt(i);
      break label4660;
      label6202:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.mCanSearchByKeywords = paramBoolean;
        break;
      }
      label6229:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.mCanSearchByTroopUin = paramBoolean;
        break;
      }
      label6257:
      paramEntity.dwCmdUinJoinTime = paramCursor.getLong(i);
      break label4771;
      label6272:
      paramEntity.dwLastInsertBAFTipTime = paramCursor.getLong(i);
      break label4808;
      label6287:
      paramEntity.wInsertBAFTipCount = paramCursor.getInt(i);
      break label4845;
      label6302:
      paramEntity.wClickBAFTipCount = paramCursor.getInt(i);
    }
    label6317:
    paramEntity.dwLastBAFTipMsgUniSeq = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT ,timeSec INTEGER ,troopuin TEXT UNIQUE ,troopcode TEXT ,troopowneruin TEXT ,troopname TEXT ,newTroopName TEXT ,newTroopNameTimeStamp INTEGER ,troopface INTEGER ,troopmemo TEXT ,fingertroopmemo TEXT ,mRichFingerMemo TEXT ,troopmask INTEGER ,trooptype INTEGER ,troopCreateTime INTEGER ,dwGroupFlag INTEGER ,cGroupOption INTEGER ,wMemberMax INTEGER ,maxAdminNum INTEGER ,wSpecialClass INTEGER ,cGroupLevel INTEGER ,wMemberNum INTEGER ,wMemberNumClient INTEGER ,Administrator TEXT ,dwGroupClassExt INTEGER ,mGroupClassExtText TEXT ,dwGroupFlagExt INTEGER ,dwAuthGroupType INTEGER ,troopAuthenticateInfo TEXT ,dwGroupInfoSeq INTEGER ,mMemberNumSeq INTEGER ,mOldMemberNumSeq INTEGER ,mMemberCardSeq INTEGER ,mOldMemberCardSeq INTEGER ,dwGroupLevelSeq INTEGER ,cGroupRankSysFlag INTEGER ,cGroupRankUserFlag INTEGER ,troopLevelMap TEXT ,joinTroopQuestion TEXT ,joinTroopAnswer TEXT ,cAlbumResult INTEGER ,dwTimeStamp INTEGER ,strQZonePhotoUrls TEXT ,mQZonePhotoNum INTEGER ,strLocation TEXT ,troopLat INTEGER ,troopLon INTEGER ,mMemberInvitingFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mSomeMemberUins TEXT ,mHeaderUinsOld TEXT ,mHeaderUinsNew TEXT ,mTags TEXT ,mTroopAvatarId INTEGER ,nTroopGrade INTEGER ,isShowInNearbyTroops INTEGER ,dwGagTimeStamp INTEGER ,dwGagTimeStamp_me INTEGER ,dwCmdUinUinFlag INTEGER ,dwAdditionalFlag INTEGER ,troopTypeExt INTEGER ,ownerNameShow TEXT ,adminNameShow TEXT ,dwOfficeMode INTEGER ,dwGroupFlagExt3 INTEGER ,memberListToShow TEXT ,troopPrivilegeFlag INTEGER ,isNewTroop INTEGER ,hasSetNewTroopHead INTEGER ,hasSetNewTroopName INTEGER ,maxInviteMemNum INTEGER ,lastMsgTime INTEGER ,mTroopNeedPayNumber REAL ,troopCreditLevel INTEGER ,troopCreditLevelInfo INTEGER ,dwAppPrivilegeFlag INTEGER ,topicId TEXT ,associatePubAccount INTEGER ,mTroopFileVideoReqInterval INTEGER ,mTroopFileVideoIsWhite INTEGER ,mTribeStatus INTEGER ,mCanSearchByKeywords INTEGER ,mCanSearchByTroopUin INTEGER ,dwCmdUinJoinTime INTEGER ,dwLastInsertBAFTipTime INTEGER ,wInsertBAFTipCount INTEGER ,wClickBAFTipCount INTEGER ,dwLastBAFTipMsgUniSeq INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (TroopInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("timeSec", Long.valueOf(paramEntity.timeSec));
    paramContentValues.put("troopuin", paramEntity.troopuin);
    paramContentValues.put("troopcode", paramEntity.troopcode);
    paramContentValues.put("troopowneruin", paramEntity.troopowneruin);
    paramContentValues.put("troopname", paramEntity.troopname);
    paramContentValues.put("newTroopName", paramEntity.newTroopName);
    paramContentValues.put("newTroopNameTimeStamp", Long.valueOf(paramEntity.newTroopNameTimeStamp));
    paramContentValues.put("troopface", Short.valueOf(paramEntity.troopface));
    paramContentValues.put("troopmemo", paramEntity.troopmemo);
    paramContentValues.put("fingertroopmemo", paramEntity.fingertroopmemo);
    paramContentValues.put("mRichFingerMemo", paramEntity.mRichFingerMemo);
    paramContentValues.put("troopmask", Integer.valueOf(paramEntity.troopmask));
    paramContentValues.put("trooptype", Integer.valueOf(paramEntity.trooptype));
    paramContentValues.put("troopCreateTime", Long.valueOf(paramEntity.troopCreateTime));
    paramContentValues.put("dwGroupFlag", Long.valueOf(paramEntity.dwGroupFlag));
    paramContentValues.put("cGroupOption", Short.valueOf(paramEntity.cGroupOption));
    paramContentValues.put("wMemberMax", Integer.valueOf(paramEntity.wMemberMax));
    paramContentValues.put("maxAdminNum", Integer.valueOf(paramEntity.maxAdminNum));
    paramContentValues.put("wSpecialClass", Integer.valueOf(paramEntity.wSpecialClass));
    paramContentValues.put("cGroupLevel", Short.valueOf(paramEntity.cGroupLevel));
    paramContentValues.put("wMemberNum", Integer.valueOf(paramEntity.wMemberNum));
    paramContentValues.put("wMemberNumClient", Integer.valueOf(paramEntity.wMemberNumClient));
    paramContentValues.put("Administrator", paramEntity.Administrator);
    paramContentValues.put("dwGroupClassExt", Long.valueOf(paramEntity.dwGroupClassExt));
    paramContentValues.put("mGroupClassExtText", paramEntity.mGroupClassExtText);
    paramContentValues.put("dwGroupFlagExt", Long.valueOf(paramEntity.dwGroupFlagExt));
    paramContentValues.put("dwAuthGroupType", Long.valueOf(paramEntity.dwAuthGroupType));
    paramContentValues.put("troopAuthenticateInfo", paramEntity.troopAuthenticateInfo);
    paramContentValues.put("dwGroupInfoSeq", Long.valueOf(paramEntity.dwGroupInfoSeq));
    paramContentValues.put("mMemberNumSeq", Long.valueOf(paramEntity.mMemberNumSeq));
    paramContentValues.put("mOldMemberNumSeq", Long.valueOf(paramEntity.mOldMemberNumSeq));
    paramContentValues.put("mMemberCardSeq", Long.valueOf(paramEntity.mMemberCardSeq));
    paramContentValues.put("mOldMemberCardSeq", Long.valueOf(paramEntity.mOldMemberCardSeq));
    paramContentValues.put("dwGroupLevelSeq", Long.valueOf(paramEntity.dwGroupLevelSeq));
    paramContentValues.put("cGroupRankSysFlag", Byte.valueOf(paramEntity.cGroupRankSysFlag));
    paramContentValues.put("cGroupRankUserFlag", Byte.valueOf(paramEntity.cGroupRankUserFlag));
    paramContentValues.put("troopLevelMap", paramEntity.troopLevelMap);
    paramContentValues.put("joinTroopQuestion", paramEntity.joinTroopQuestion);
    paramContentValues.put("joinTroopAnswer", paramEntity.joinTroopAnswer);
    paramContentValues.put("cAlbumResult", Byte.valueOf(paramEntity.cAlbumResult));
    paramContentValues.put("dwTimeStamp", Long.valueOf(paramEntity.dwTimeStamp));
    paramContentValues.put("strQZonePhotoUrls", paramEntity.strQZonePhotoUrls);
    paramContentValues.put("mQZonePhotoNum", Integer.valueOf(paramEntity.mQZonePhotoNum));
    paramContentValues.put("strLocation", paramEntity.strLocation);
    paramContentValues.put("troopLat", Integer.valueOf(paramEntity.troopLat));
    paramContentValues.put("troopLon", Integer.valueOf(paramEntity.troopLon));
    paramContentValues.put("mMemberInvitingFlag", Boolean.valueOf(paramEntity.mMemberInvitingFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("mSomeMemberUins", paramEntity.mSomeMemberUins);
    paramContentValues.put("mHeaderUinsOld", paramEntity.mHeaderUinsOld);
    paramContentValues.put("mHeaderUinsNew", paramEntity.mHeaderUinsNew);
    paramContentValues.put("mTags", paramEntity.mTags);
    paramContentValues.put("mTroopAvatarId", Integer.valueOf(paramEntity.mTroopAvatarId));
    paramContentValues.put("nTroopGrade", Integer.valueOf(paramEntity.nTroopGrade));
    paramContentValues.put("isShowInNearbyTroops", Integer.valueOf(paramEntity.isShowInNearbyTroops));
    paramContentValues.put("dwGagTimeStamp", Long.valueOf(paramEntity.dwGagTimeStamp));
    paramContentValues.put("dwGagTimeStamp_me", Long.valueOf(paramEntity.dwGagTimeStamp_me));
    paramContentValues.put("dwCmdUinUinFlag", Long.valueOf(paramEntity.dwCmdUinUinFlag));
    paramContentValues.put("dwAdditionalFlag", Long.valueOf(paramEntity.dwAdditionalFlag));
    paramContentValues.put("troopTypeExt", Integer.valueOf(paramEntity.troopTypeExt));
    paramContentValues.put("ownerNameShow", paramEntity.ownerNameShow);
    paramContentValues.put("adminNameShow", paramEntity.adminNameShow);
    paramContentValues.put("dwOfficeMode", Long.valueOf(paramEntity.dwOfficeMode));
    paramContentValues.put("dwGroupFlagExt3", Long.valueOf(paramEntity.dwGroupFlagExt3));
    paramContentValues.put("memberListToShow", paramEntity.memberListToShow);
    paramContentValues.put("troopPrivilegeFlag", Long.valueOf(paramEntity.troopPrivilegeFlag));
    paramContentValues.put("isNewTroop", Boolean.valueOf(paramEntity.isNewTroop));
    paramContentValues.put("hasSetNewTroopHead", Boolean.valueOf(paramEntity.hasSetNewTroopHead));
    paramContentValues.put("hasSetNewTroopName", Boolean.valueOf(paramEntity.hasSetNewTroopName));
    paramContentValues.put("maxInviteMemNum", Integer.valueOf(paramEntity.maxInviteMemNum));
    paramContentValues.put("lastMsgTime", Long.valueOf(paramEntity.lastMsgTime));
    paramContentValues.put("mTroopNeedPayNumber", Float.valueOf(paramEntity.mTroopNeedPayNumber));
    paramContentValues.put("troopCreditLevel", Long.valueOf(paramEntity.troopCreditLevel));
    paramContentValues.put("troopCreditLevelInfo", Long.valueOf(paramEntity.troopCreditLevelInfo));
    paramContentValues.put("dwAppPrivilegeFlag", Long.valueOf(paramEntity.dwAppPrivilegeFlag));
    paramContentValues.put("topicId", paramEntity.topicId);
    paramContentValues.put("associatePubAccount", Long.valueOf(paramEntity.associatePubAccount));
    paramContentValues.put("mTroopFileVideoReqInterval", Long.valueOf(paramEntity.mTroopFileVideoReqInterval));
    paramContentValues.put("mTroopFileVideoIsWhite", Integer.valueOf(paramEntity.mTroopFileVideoIsWhite));
    paramContentValues.put("mTribeStatus", Integer.valueOf(paramEntity.mTribeStatus));
    paramContentValues.put("mCanSearchByKeywords", Boolean.valueOf(paramEntity.mCanSearchByKeywords));
    paramContentValues.put("mCanSearchByTroopUin", Boolean.valueOf(paramEntity.mCanSearchByTroopUin));
    paramContentValues.put("dwCmdUinJoinTime", Long.valueOf(paramEntity.dwCmdUinJoinTime));
    paramContentValues.put("dwLastInsertBAFTipTime", Long.valueOf(paramEntity.dwLastInsertBAFTipTime));
    paramContentValues.put("wInsertBAFTipCount", Integer.valueOf(paramEntity.wInsertBAFTipCount));
    paramContentValues.put("wClickBAFTipCount", Integer.valueOf(paramEntity.wClickBAFTipCount));
    paramContentValues.put("dwLastBAFTipMsgUniSeq", Long.valueOf(paramEntity.dwLastBAFTipMsgUniSeq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.TroopInfoDao
 * JD-Core Version:    0.7.0.1
 */