package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;

public class ExtensionInfoDao
  extends OGAbstractDao
{
  public ExtensionInfoDao()
  {
    this.a = 58;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (ExtensionInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.pendantId = paramCursor.getLong(paramCursor.getColumnIndex("pendantId"));
      paramEntity.pendantDiyId = paramCursor.getInt(paramCursor.getColumnIndex("pendantDiyId"));
      paramEntity.uVipFont = paramCursor.getLong(paramCursor.getColumnIndex("uVipFont"));
      paramEntity.vipFontType = paramCursor.getInt(paramCursor.getColumnIndex("vipFontType"));
      paramEntity.magicFont = paramCursor.getInt(paramCursor.getColumnIndex("magicFont"));
      paramEntity.lastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("lastUpdateTime"));
      paramEntity.fontEffect = paramCursor.getInt(paramCursor.getColumnIndex("fontEffect"));
      paramEntity.fontEffectLastUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("fontEffectLastUpdateTime"));
      paramEntity.faceId = paramCursor.getInt(paramCursor.getColumnIndex("faceId"));
      paramEntity.faceIdUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("faceIdUpdateTime"));
      paramEntity.colorRingId = paramCursor.getLong(paramCursor.getColumnIndex("colorRingId"));
      paramEntity.commingRingId = paramCursor.getLong(paramCursor.getColumnIndex("commingRingId"));
      paramEntity.timestamp = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
      paramEntity.richTime = paramCursor.getLong(paramCursor.getColumnIndex("richTime"));
      paramEntity.richBuffer = paramCursor.getBlob(paramCursor.getColumnIndex("richBuffer"));
      paramEntity.feedType = paramCursor.getInt(paramCursor.getColumnIndex("feedType"));
      paramEntity.feedTime = paramCursor.getLong(paramCursor.getColumnIndex("feedTime"));
      paramEntity.feedContent = paramCursor.getString(paramCursor.getColumnIndex("feedContent"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("feedHasPhoto")))
      {
        paramBoolean = true;
        paramEntity.feedHasPhoto = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAdded2C2C"))) {
          break label1116;
        }
        paramBoolean = true;
        label403:
        paramEntity.isAdded2C2C = paramBoolean;
        paramEntity.chatInputType = paramCursor.getInt(paramCursor.getColumnIndex("chatInputType"));
        paramEntity.showC2CPanel = paramCursor.getInt(paramCursor.getColumnIndex("showC2CPanel"));
        paramEntity.pttChangeVoiceType = paramCursor.getInt(paramCursor.getColumnIndex("pttChangeVoiceType"));
        paramEntity.audioPanelType = paramCursor.getInt(paramCursor.getColumnIndex("audioPanelType"));
        paramEntity.chatHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("chatHotLevel"));
        paramEntity.chatDays = paramCursor.getInt(paramCursor.getColumnIndex("chatDays"));
        paramEntity.praiseHotLevel = paramCursor.getInt(paramCursor.getColumnIndex("praiseHotLevel"));
        paramEntity.praiseDays = paramCursor.getInt(paramCursor.getColumnIndex("praiseDays"));
        paramEntity.bestIntimacyType = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyType"));
        paramEntity.bestIntimacyDays = paramCursor.getInt(paramCursor.getColumnIndex("bestIntimacyDays"));
        paramEntity.lastpraiseTime = paramCursor.getLong(paramCursor.getColumnIndex("lastpraiseTime"));
        paramEntity.lastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("lastChatTime"));
        paramEntity.qzoneVisitType = paramCursor.getInt(paramCursor.getColumnIndex("qzoneVisitType"));
        paramEntity.qzoneHotDays = paramCursor.getInt(paramCursor.getColumnIndex("qzoneHotDays"));
        paramEntity.lastQzoneVisitTime = paramCursor.getLong(paramCursor.getColumnIndex("lastQzoneVisitTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindChat"))) {
          break label1121;
        }
        paramBoolean = true;
        label698:
        paramEntity.hasRemindChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindPraise"))) {
          break label1126;
        }
        paramBoolean = true;
        label723:
        paramEntity.hasRemindPraise = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindQzoneVisit"))) {
          break label1131;
        }
        paramBoolean = true;
        label748:
        paramEntity.hasRemindQzoneVisit = paramBoolean;
        paramEntity.isGrayTipRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipRemind"));
        paramEntity.isGrayTipMultiRemind = paramCursor.getInt(paramCursor.getColumnIndex("isGrayTipMultiRemind"));
        paramEntity.apolloVipFlag = paramCursor.getInt(paramCursor.getColumnIndex("apolloVipFlag"));
        paramEntity.apolloVipLevel = paramCursor.getInt(paramCursor.getColumnIndex("apolloVipLevel"));
        paramEntity.apolloStatus = paramCursor.getInt(paramCursor.getColumnIndex("apolloStatus"));
        paramEntity.apolloLocalTS = paramCursor.getLong(paramCursor.getColumnIndex("apolloLocalTS"));
        paramEntity.apolloServerTS = paramCursor.getLong(paramCursor.getColumnIndex("apolloServerTS"));
        paramEntity.apolloUpdateTime = paramCursor.getLong(paramCursor.getColumnIndex("apolloUpdateTime"));
        paramEntity.apolloDataBuffer = paramCursor.getString(paramCursor.getColumnIndex("apolloDataBuffer"));
        paramEntity.uinType = paramCursor.getInt(paramCursor.getColumnIndex("uinType"));
        paramEntity.apolloHistoryDress = paramCursor.getString(paramCursor.getColumnIndex("apolloHistoryDress"));
        paramEntity.latestPLUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("latestPLUpdateTimestamp"));
        paramEntity.lastPullPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPullPLNewsTimestamp"));
        paramEntity.lastPLNewsTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastPLNewsTimestamp"));
        paramEntity.medalUpdateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("medalUpdateTimestamp"));
        paramEntity.lastMedalTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("lastMedalTimestamp"));
        paramEntity.diyFontTimestampBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontTimestampBytes"));
        paramEntity.diyFontConfigBytes = paramCursor.getBlob(paramCursor.getColumnIndex("diyFontConfigBytes"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isQzoneLover"))) {
          break label1136;
        }
      }
      label1116:
      label1121:
      label1126:
      label1131:
      label1136:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isQzoneLover = paramBoolean;
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label403;
        paramBoolean = false;
        break label698;
        paramBoolean = false;
        break label723;
        paramBoolean = false;
        break label748;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label3200;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pendantId", Long.TYPE));
      label1211:
      i = paramCursor.getColumnIndex("pendantDiyId");
      if (i != -1) {
        break label3215;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pendantDiyId", Integer.TYPE));
      label1246:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label3230;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uVipFont", Long.TYPE));
      label1281:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label3245;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vipFontType", Integer.TYPE));
      label1316:
      i = paramCursor.getColumnIndex("magicFont");
      if (i != -1) {
        break label3260;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("magicFont", Integer.TYPE));
      label1351:
      i = paramCursor.getColumnIndex("lastUpdateTime");
      if (i != -1) {
        break label3275;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastUpdateTime", Long.TYPE));
      label1386:
      i = paramCursor.getColumnIndex("fontEffect");
      if (i != -1) {
        break label3290;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("fontEffect", Integer.TYPE));
      label1421:
      i = paramCursor.getColumnIndex("fontEffectLastUpdateTime");
      if (i != -1) {
        break label3305;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("fontEffectLastUpdateTime", Long.TYPE));
      label1456:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label3320;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceId", Integer.TYPE));
      label1491:
      i = paramCursor.getColumnIndex("faceIdUpdateTime");
      if (i != -1) {
        break label3335;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceIdUpdateTime", Long.TYPE));
      label1526:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label3350;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("colorRingId", Long.TYPE));
      label1561:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label3365;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("commingRingId", Long.TYPE));
      label1596:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label3380;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timestamp", Long.TYPE));
      label1631:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label3395;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richTime", Long.TYPE));
      label1666:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label3410;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richBuffer", [B.class));
      label1701:
      i = paramCursor.getColumnIndex("feedType");
      if (i != -1) {
        break label3425;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedType", Integer.TYPE));
      label1736:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label3440;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedTime", Long.TYPE));
      label1771:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label3455;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedContent", String.class));
      label1806:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label3470;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label3497;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label3524;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("chatInputType", Integer.TYPE));
      label1911:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label3539;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showC2CPanel", Integer.TYPE));
      label1946:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label3554;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label1981:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label3569;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("audioPanelType", Integer.TYPE));
      label2016:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label3584;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("chatHotLevel", Integer.TYPE));
      label2051:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label3599;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("chatDays", Integer.TYPE));
      label2086:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label3614;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label2121:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label3629;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("praiseDays", Integer.TYPE));
      label2156:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label3644;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label2191:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label3659;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label2226:
      i = paramCursor.getColumnIndex("lastpraiseTime");
      if (i != -1) {
        break label3674;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastpraiseTime", Long.TYPE));
      label2261:
      i = paramCursor.getColumnIndex("lastChatTime");
      if (i != -1) {
        break label3689;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastChatTime", Long.TYPE));
      label2296:
      i = paramCursor.getColumnIndex("qzoneVisitType");
      if (i != -1) {
        break label3704;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneVisitType", Integer.TYPE));
      label2331:
      i = paramCursor.getColumnIndex("qzoneHotDays");
      if (i != -1) {
        break label3719;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneHotDays", Integer.TYPE));
      label2366:
      i = paramCursor.getColumnIndex("lastQzoneVisitTime");
      if (i != -1) {
        break label3734;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastQzoneVisitTime", Long.TYPE));
      label2401:
      i = paramCursor.getColumnIndex("hasRemindChat");
      if (i != -1) {
        break label3749;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasRemindChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindPraise");
      if (i != -1) {
        break label3776;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasRemindPraise", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindQzoneVisit");
      if (i != -1) {
        break label3803;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasRemindQzoneVisit", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGrayTipRemind");
      if (i != -1) {
        break label3830;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isGrayTipRemind", Integer.TYPE));
      label2541:
      i = paramCursor.getColumnIndex("isGrayTipMultiRemind");
      if (i != -1) {
        break label3845;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isGrayTipMultiRemind", Integer.TYPE));
      label2576:
      i = paramCursor.getColumnIndex("apolloVipFlag");
      if (i != -1) {
        break label3860;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloVipFlag", Integer.TYPE));
      label2611:
      i = paramCursor.getColumnIndex("apolloVipLevel");
      if (i != -1) {
        break label3875;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloVipLevel", Integer.TYPE));
      label2646:
      i = paramCursor.getColumnIndex("apolloStatus");
      if (i != -1) {
        break label3890;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloStatus", Integer.TYPE));
      label2681:
      i = paramCursor.getColumnIndex("apolloLocalTS");
      if (i != -1) {
        break label3905;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloLocalTS", Long.TYPE));
      label2716:
      i = paramCursor.getColumnIndex("apolloServerTS");
      if (i != -1) {
        break label3920;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloServerTS", Long.TYPE));
      label2751:
      i = paramCursor.getColumnIndex("apolloUpdateTime");
      if (i != -1) {
        break label3935;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloUpdateTime", Long.TYPE));
      label2786:
      i = paramCursor.getColumnIndex("apolloDataBuffer");
      if (i != -1) {
        break label3950;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloDataBuffer", String.class));
      label2821:
      i = paramCursor.getColumnIndex("uinType");
      if (i != -1) {
        break label3965;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uinType", Integer.TYPE));
      label2856:
      i = paramCursor.getColumnIndex("apolloHistoryDress");
      if (i != -1) {
        break label3980;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloHistoryDress", String.class));
      label2891:
      i = paramCursor.getColumnIndex("latestPLUpdateTimestamp");
      if (i != -1) {
        break label3995;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("latestPLUpdateTimestamp", Long.TYPE));
      label2926:
      i = paramCursor.getColumnIndex("lastPullPLNewsTimestamp");
      if (i != -1) {
        break label4010;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastPullPLNewsTimestamp", Long.TYPE));
      label2961:
      i = paramCursor.getColumnIndex("lastPLNewsTimestamp");
      if (i != -1) {
        break label4025;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastPLNewsTimestamp", Long.TYPE));
      label2998:
      i = paramCursor.getColumnIndex("medalUpdateTimestamp");
      if (i != -1) {
        break label4040;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("medalUpdateTimestamp", Long.TYPE));
      label3035:
      i = paramCursor.getColumnIndex("lastMedalTimestamp");
      if (i != -1) {
        break label4055;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastMedalTimestamp", Long.TYPE));
      label3072:
      i = paramCursor.getColumnIndex("diyFontTimestampBytes");
      if (i != -1) {
        break label4070;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyFontTimestampBytes", [B.class));
      label3109:
      i = paramCursor.getColumnIndex("diyFontConfigBytes");
      if (i != -1) {
        break label4085;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyFontConfigBytes", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("isQzoneLover");
      if (i != -1) {
        break label4100;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isQzoneLover", Boolean.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label3200:
      paramEntity.pendantId = paramCursor.getLong(i);
      break label1211;
      label3215:
      paramEntity.pendantDiyId = paramCursor.getInt(i);
      break label1246;
      label3230:
      paramEntity.uVipFont = paramCursor.getLong(i);
      break label1281;
      label3245:
      paramEntity.vipFontType = paramCursor.getInt(i);
      break label1316;
      label3260:
      paramEntity.magicFont = paramCursor.getInt(i);
      break label1351;
      label3275:
      paramEntity.lastUpdateTime = paramCursor.getLong(i);
      break label1386;
      label3290:
      paramEntity.fontEffect = paramCursor.getInt(i);
      break label1421;
      label3305:
      paramEntity.fontEffectLastUpdateTime = paramCursor.getLong(i);
      break label1456;
      label3320:
      paramEntity.faceId = paramCursor.getInt(i);
      break label1491;
      label3335:
      paramEntity.faceIdUpdateTime = paramCursor.getLong(i);
      break label1526;
      label3350:
      paramEntity.colorRingId = paramCursor.getLong(i);
      break label1561;
      label3365:
      paramEntity.commingRingId = paramCursor.getLong(i);
      break label1596;
      label3380:
      paramEntity.timestamp = paramCursor.getLong(i);
      break label1631;
      label3395:
      paramEntity.richTime = paramCursor.getLong(i);
      break label1666;
      label3410:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label1701;
      label3425:
      paramEntity.feedType = paramCursor.getInt(i);
      break label1736;
      label3440:
      paramEntity.feedTime = paramCursor.getLong(i);
      break label1771;
      label3455:
      paramEntity.feedContent = paramCursor.getString(i);
      break label1806;
      label3470:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.feedHasPhoto = paramBoolean;
        break;
      }
      label3497:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isAdded2C2C = paramBoolean;
        break;
      }
      label3524:
      paramEntity.chatInputType = paramCursor.getInt(i);
      break label1911;
      label3539:
      paramEntity.showC2CPanel = paramCursor.getInt(i);
      break label1946;
      label3554:
      paramEntity.pttChangeVoiceType = paramCursor.getInt(i);
      break label1981;
      label3569:
      paramEntity.audioPanelType = paramCursor.getInt(i);
      break label2016;
      label3584:
      paramEntity.chatHotLevel = paramCursor.getInt(i);
      break label2051;
      label3599:
      paramEntity.chatDays = paramCursor.getInt(i);
      break label2086;
      label3614:
      paramEntity.praiseHotLevel = paramCursor.getInt(i);
      break label2121;
      label3629:
      paramEntity.praiseDays = paramCursor.getInt(i);
      break label2156;
      label3644:
      paramEntity.bestIntimacyType = paramCursor.getInt(i);
      break label2191;
      label3659:
      paramEntity.bestIntimacyDays = paramCursor.getInt(i);
      break label2226;
      label3674:
      paramEntity.lastpraiseTime = paramCursor.getLong(i);
      break label2261;
      label3689:
      paramEntity.lastChatTime = paramCursor.getLong(i);
      break label2296;
      label3704:
      paramEntity.qzoneVisitType = paramCursor.getInt(i);
      break label2331;
      label3719:
      paramEntity.qzoneHotDays = paramCursor.getInt(i);
      break label2366;
      label3734:
      paramEntity.lastQzoneVisitTime = paramCursor.getLong(i);
      break label2401;
      label3749:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindChat = paramBoolean;
        break;
      }
      label3776:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindPraise = paramBoolean;
        break;
      }
      label3803:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindQzoneVisit = paramBoolean;
        break;
      }
      label3830:
      paramEntity.isGrayTipRemind = paramCursor.getInt(i);
      break label2541;
      label3845:
      paramEntity.isGrayTipMultiRemind = paramCursor.getInt(i);
      break label2576;
      label3860:
      paramEntity.apolloVipFlag = paramCursor.getInt(i);
      break label2611;
      label3875:
      paramEntity.apolloVipLevel = paramCursor.getInt(i);
      break label2646;
      label3890:
      paramEntity.apolloStatus = paramCursor.getInt(i);
      break label2681;
      label3905:
      paramEntity.apolloLocalTS = paramCursor.getLong(i);
      break label2716;
      label3920:
      paramEntity.apolloServerTS = paramCursor.getLong(i);
      break label2751;
      label3935:
      paramEntity.apolloUpdateTime = paramCursor.getLong(i);
      break label2786;
      label3950:
      paramEntity.apolloDataBuffer = paramCursor.getString(i);
      break label2821;
      label3965:
      paramEntity.uinType = paramCursor.getInt(i);
      break label2856;
      label3980:
      paramEntity.apolloHistoryDress = paramCursor.getString(i);
      break label2891;
      label3995:
      paramEntity.latestPLUpdateTimestamp = paramCursor.getLong(i);
      break label2926;
      label4010:
      paramEntity.lastPullPLNewsTimestamp = paramCursor.getLong(i);
      break label2961;
      label4025:
      paramEntity.lastPLNewsTimestamp = paramCursor.getLong(i);
      break label2998;
      label4040:
      paramEntity.medalUpdateTimestamp = paramCursor.getLong(i);
      break label3035;
      label4055:
      paramEntity.lastMedalTimestamp = paramCursor.getLong(i);
      break label3072;
      label4070:
      paramEntity.diyFontTimestampBytes = paramCursor.getBlob(i);
      break label3109;
      label4085:
      paramEntity.diyFontConfigBytes = paramCursor.getBlob(i);
    }
    label4100:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.isQzoneLover = paramBoolean;
      return paramEntity;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,pendantDiyId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,magicFont INTEGER ,lastUpdateTime INTEGER ,fontEffect INTEGER ,fontEffectLastUpdateTime INTEGER ,faceId INTEGER ,faceIdUpdateTime INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedType INTEGER ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,lastpraiseTime INTEGER ,lastChatTime INTEGER ,qzoneVisitType INTEGER ,qzoneHotDays INTEGER ,lastQzoneVisitTime INTEGER ,hasRemindChat INTEGER ,hasRemindPraise INTEGER ,hasRemindQzoneVisit INTEGER ,isGrayTipRemind INTEGER ,isGrayTipMultiRemind INTEGER ,apolloVipFlag INTEGER ,apolloVipLevel INTEGER ,apolloStatus INTEGER ,apolloLocalTS INTEGER ,apolloServerTS INTEGER ,apolloUpdateTime INTEGER ,apolloDataBuffer TEXT ,uinType INTEGER ,apolloHistoryDress TEXT ,latestPLUpdateTimestamp INTEGER ,lastPullPLNewsTimestamp INTEGER ,lastPLNewsTimestamp INTEGER ,medalUpdateTimestamp INTEGER ,lastMedalTimestamp INTEGER ,diyFontTimestampBytes BLOB ,diyFontConfigBytes BLOB ,isQzoneLover INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ExtensionInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("pendantId", Long.valueOf(paramEntity.pendantId));
    paramContentValues.put("pendantDiyId", Integer.valueOf(paramEntity.pendantDiyId));
    paramContentValues.put("uVipFont", Long.valueOf(paramEntity.uVipFont));
    paramContentValues.put("vipFontType", Integer.valueOf(paramEntity.vipFontType));
    paramContentValues.put("magicFont", Integer.valueOf(paramEntity.magicFont));
    paramContentValues.put("lastUpdateTime", Long.valueOf(paramEntity.lastUpdateTime));
    paramContentValues.put("fontEffect", Integer.valueOf(paramEntity.fontEffect));
    paramContentValues.put("fontEffectLastUpdateTime", Long.valueOf(paramEntity.fontEffectLastUpdateTime));
    paramContentValues.put("faceId", Integer.valueOf(paramEntity.faceId));
    paramContentValues.put("faceIdUpdateTime", Long.valueOf(paramEntity.faceIdUpdateTime));
    paramContentValues.put("colorRingId", Long.valueOf(paramEntity.colorRingId));
    paramContentValues.put("commingRingId", Long.valueOf(paramEntity.commingRingId));
    paramContentValues.put("timestamp", Long.valueOf(paramEntity.timestamp));
    paramContentValues.put("richTime", Long.valueOf(paramEntity.richTime));
    paramContentValues.put("richBuffer", paramEntity.richBuffer);
    paramContentValues.put("feedType", Integer.valueOf(paramEntity.feedType));
    paramContentValues.put("feedTime", Long.valueOf(paramEntity.feedTime));
    paramContentValues.put("feedContent", paramEntity.feedContent);
    paramContentValues.put("feedHasPhoto", Boolean.valueOf(paramEntity.feedHasPhoto));
    paramContentValues.put("isAdded2C2C", Boolean.valueOf(paramEntity.isAdded2C2C));
    paramContentValues.put("chatInputType", Integer.valueOf(paramEntity.chatInputType));
    paramContentValues.put("showC2CPanel", Integer.valueOf(paramEntity.showC2CPanel));
    paramContentValues.put("pttChangeVoiceType", Integer.valueOf(paramEntity.pttChangeVoiceType));
    paramContentValues.put("audioPanelType", Integer.valueOf(paramEntity.audioPanelType));
    paramContentValues.put("chatHotLevel", Integer.valueOf(paramEntity.chatHotLevel));
    paramContentValues.put("chatDays", Integer.valueOf(paramEntity.chatDays));
    paramContentValues.put("praiseHotLevel", Integer.valueOf(paramEntity.praiseHotLevel));
    paramContentValues.put("praiseDays", Integer.valueOf(paramEntity.praiseDays));
    paramContentValues.put("bestIntimacyType", Integer.valueOf(paramEntity.bestIntimacyType));
    paramContentValues.put("bestIntimacyDays", Integer.valueOf(paramEntity.bestIntimacyDays));
    paramContentValues.put("lastpraiseTime", Long.valueOf(paramEntity.lastpraiseTime));
    paramContentValues.put("lastChatTime", Long.valueOf(paramEntity.lastChatTime));
    paramContentValues.put("qzoneVisitType", Integer.valueOf(paramEntity.qzoneVisitType));
    paramContentValues.put("qzoneHotDays", Integer.valueOf(paramEntity.qzoneHotDays));
    paramContentValues.put("lastQzoneVisitTime", Long.valueOf(paramEntity.lastQzoneVisitTime));
    paramContentValues.put("hasRemindChat", Boolean.valueOf(paramEntity.hasRemindChat));
    paramContentValues.put("hasRemindPraise", Boolean.valueOf(paramEntity.hasRemindPraise));
    paramContentValues.put("hasRemindQzoneVisit", Boolean.valueOf(paramEntity.hasRemindQzoneVisit));
    paramContentValues.put("isGrayTipRemind", Integer.valueOf(paramEntity.isGrayTipRemind));
    paramContentValues.put("isGrayTipMultiRemind", Integer.valueOf(paramEntity.isGrayTipMultiRemind));
    paramContentValues.put("apolloVipFlag", Integer.valueOf(paramEntity.apolloVipFlag));
    paramContentValues.put("apolloVipLevel", Integer.valueOf(paramEntity.apolloVipLevel));
    paramContentValues.put("apolloStatus", Integer.valueOf(paramEntity.apolloStatus));
    paramContentValues.put("apolloLocalTS", Long.valueOf(paramEntity.apolloLocalTS));
    paramContentValues.put("apolloServerTS", Long.valueOf(paramEntity.apolloServerTS));
    paramContentValues.put("apolloUpdateTime", Long.valueOf(paramEntity.apolloUpdateTime));
    paramContentValues.put("apolloDataBuffer", paramEntity.apolloDataBuffer);
    paramContentValues.put("uinType", Integer.valueOf(paramEntity.uinType));
    paramContentValues.put("apolloHistoryDress", paramEntity.apolloHistoryDress);
    paramContentValues.put("latestPLUpdateTimestamp", Long.valueOf(paramEntity.latestPLUpdateTimestamp));
    paramContentValues.put("lastPullPLNewsTimestamp", Long.valueOf(paramEntity.lastPullPLNewsTimestamp));
    paramContentValues.put("lastPLNewsTimestamp", Long.valueOf(paramEntity.lastPLNewsTimestamp));
    paramContentValues.put("medalUpdateTimestamp", Long.valueOf(paramEntity.medalUpdateTimestamp));
    paramContentValues.put("lastMedalTimestamp", Long.valueOf(paramEntity.lastMedalTimestamp));
    paramContentValues.put("diyFontTimestampBytes", paramEntity.diyFontTimestampBytes);
    paramContentValues.put("diyFontConfigBytes", paramEntity.diyFontConfigBytes);
    paramContentValues.put("isQzoneLover", Boolean.valueOf(paramEntity.isQzoneLover));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ExtensionInfoDao
 * JD-Core Version:    0.7.0.1
 */