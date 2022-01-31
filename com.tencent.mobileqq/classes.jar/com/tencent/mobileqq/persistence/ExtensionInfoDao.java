package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ExtensionInfo;

public class ExtensionInfoDao
  extends OGAbstractDao
{
  public ExtensionInfoDao()
  {
    this.a = 63;
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
          break label1218;
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
          break label1223;
        }
        paramBoolean = true;
        label698:
        paramEntity.hasRemindChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindLoverChat"))) {
          break label1228;
        }
        paramBoolean = true;
        label723:
        paramEntity.hasRemindLoverChat = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindPraise"))) {
          break label1233;
        }
        paramBoolean = true;
        label748:
        paramEntity.hasRemindPraise = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasRemindQzoneVisit"))) {
          break label1238;
        }
        paramBoolean = true;
        label773:
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
        paramEntity.loverChatLevel = paramCursor.getInt(paramCursor.getColumnIndex("loverChatLevel"));
        paramEntity.loverChatDays = paramCursor.getInt(paramCursor.getColumnIndex("loverChatDays"));
        paramEntity.loverLastChatTime = paramCursor.getLong(paramCursor.getColumnIndex("loverLastChatTime"));
        paramEntity.loverFlag = paramCursor.getInt(paramCursor.getColumnIndex("loverFlag"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("loverTransFlag"))) {
          break label1243;
        }
      }
      label1218:
      label1223:
      label1228:
      label1233:
      label1238:
      label1243:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.loverTransFlag = paramBoolean;
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
        paramBoolean = false;
        break label773;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("pendantId");
      if (i != -1) {
        break label3492;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pendantId", Long.TYPE));
      label1318:
      i = paramCursor.getColumnIndex("pendantDiyId");
      if (i != -1) {
        break label3507;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pendantDiyId", Integer.TYPE));
      label1353:
      i = paramCursor.getColumnIndex("uVipFont");
      if (i != -1) {
        break label3522;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uVipFont", Long.TYPE));
      label1388:
      i = paramCursor.getColumnIndex("vipFontType");
      if (i != -1) {
        break label3537;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("vipFontType", Integer.TYPE));
      label1423:
      i = paramCursor.getColumnIndex("magicFont");
      if (i != -1) {
        break label3552;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("magicFont", Integer.TYPE));
      label1458:
      i = paramCursor.getColumnIndex("lastUpdateTime");
      if (i != -1) {
        break label3567;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastUpdateTime", Long.TYPE));
      label1493:
      i = paramCursor.getColumnIndex("fontEffect");
      if (i != -1) {
        break label3582;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("fontEffect", Integer.TYPE));
      label1528:
      i = paramCursor.getColumnIndex("fontEffectLastUpdateTime");
      if (i != -1) {
        break label3597;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("fontEffectLastUpdateTime", Long.TYPE));
      label1563:
      i = paramCursor.getColumnIndex("faceId");
      if (i != -1) {
        break label3612;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceId", Integer.TYPE));
      label1598:
      i = paramCursor.getColumnIndex("faceIdUpdateTime");
      if (i != -1) {
        break label3627;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceIdUpdateTime", Long.TYPE));
      label1633:
      i = paramCursor.getColumnIndex("colorRingId");
      if (i != -1) {
        break label3642;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("colorRingId", Long.TYPE));
      label1668:
      i = paramCursor.getColumnIndex("commingRingId");
      if (i != -1) {
        break label3657;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("commingRingId", Long.TYPE));
      label1703:
      i = paramCursor.getColumnIndex("timestamp");
      if (i != -1) {
        break label3672;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timestamp", Long.TYPE));
      label1738:
      i = paramCursor.getColumnIndex("richTime");
      if (i != -1) {
        break label3687;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richTime", Long.TYPE));
      label1773:
      i = paramCursor.getColumnIndex("richBuffer");
      if (i != -1) {
        break label3702;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("richBuffer", [B.class));
      label1808:
      i = paramCursor.getColumnIndex("feedType");
      if (i != -1) {
        break label3717;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedType", Integer.TYPE));
      label1843:
      i = paramCursor.getColumnIndex("feedTime");
      if (i != -1) {
        break label3732;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedTime", Long.TYPE));
      label1878:
      i = paramCursor.getColumnIndex("feedContent");
      if (i != -1) {
        break label3747;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedContent", String.class));
      label1913:
      i = paramCursor.getColumnIndex("feedHasPhoto");
      if (i != -1) {
        break label3762;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("feedHasPhoto", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isAdded2C2C");
      if (i != -1) {
        break label3789;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isAdded2C2C", Boolean.TYPE));
      i = paramCursor.getColumnIndex("chatInputType");
      if (i != -1) {
        break label3816;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("chatInputType", Integer.TYPE));
      label2018:
      i = paramCursor.getColumnIndex("showC2CPanel");
      if (i != -1) {
        break label3831;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("showC2CPanel", Integer.TYPE));
      label2053:
      i = paramCursor.getColumnIndex("pttChangeVoiceType");
      if (i != -1) {
        break label3846;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("pttChangeVoiceType", Integer.TYPE));
      label2088:
      i = paramCursor.getColumnIndex("audioPanelType");
      if (i != -1) {
        break label3861;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("audioPanelType", Integer.TYPE));
      label2123:
      i = paramCursor.getColumnIndex("chatHotLevel");
      if (i != -1) {
        break label3876;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("chatHotLevel", Integer.TYPE));
      label2158:
      i = paramCursor.getColumnIndex("chatDays");
      if (i != -1) {
        break label3891;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("chatDays", Integer.TYPE));
      label2193:
      i = paramCursor.getColumnIndex("praiseHotLevel");
      if (i != -1) {
        break label3906;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("praiseHotLevel", Integer.TYPE));
      label2228:
      i = paramCursor.getColumnIndex("praiseDays");
      if (i != -1) {
        break label3921;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("praiseDays", Integer.TYPE));
      label2263:
      i = paramCursor.getColumnIndex("bestIntimacyType");
      if (i != -1) {
        break label3936;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bestIntimacyType", Integer.TYPE));
      label2298:
      i = paramCursor.getColumnIndex("bestIntimacyDays");
      if (i != -1) {
        break label3951;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bestIntimacyDays", Integer.TYPE));
      label2333:
      i = paramCursor.getColumnIndex("lastpraiseTime");
      if (i != -1) {
        break label3966;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastpraiseTime", Long.TYPE));
      label2368:
      i = paramCursor.getColumnIndex("lastChatTime");
      if (i != -1) {
        break label3981;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastChatTime", Long.TYPE));
      label2403:
      i = paramCursor.getColumnIndex("qzoneVisitType");
      if (i != -1) {
        break label3996;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneVisitType", Integer.TYPE));
      label2438:
      i = paramCursor.getColumnIndex("qzoneHotDays");
      if (i != -1) {
        break label4011;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("qzoneHotDays", Integer.TYPE));
      label2473:
      i = paramCursor.getColumnIndex("lastQzoneVisitTime");
      if (i != -1) {
        break label4026;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastQzoneVisitTime", Long.TYPE));
      label2508:
      i = paramCursor.getColumnIndex("hasRemindChat");
      if (i != -1) {
        break label4041;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasRemindChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindLoverChat");
      if (i != -1) {
        break label4068;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasRemindLoverChat", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindPraise");
      if (i != -1) {
        break label4095;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasRemindPraise", Boolean.TYPE));
      i = paramCursor.getColumnIndex("hasRemindQzoneVisit");
      if (i != -1) {
        break label4122;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasRemindQzoneVisit", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isGrayTipRemind");
      if (i != -1) {
        break label4149;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isGrayTipRemind", Integer.TYPE));
      label2683:
      i = paramCursor.getColumnIndex("isGrayTipMultiRemind");
      if (i != -1) {
        break label4164;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isGrayTipMultiRemind", Integer.TYPE));
      label2718:
      i = paramCursor.getColumnIndex("apolloVipFlag");
      if (i != -1) {
        break label4179;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloVipFlag", Integer.TYPE));
      label2753:
      i = paramCursor.getColumnIndex("apolloVipLevel");
      if (i != -1) {
        break label4194;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloVipLevel", Integer.TYPE));
      label2788:
      i = paramCursor.getColumnIndex("apolloStatus");
      if (i != -1) {
        break label4209;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloStatus", Integer.TYPE));
      label2823:
      i = paramCursor.getColumnIndex("apolloLocalTS");
      if (i != -1) {
        break label4224;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloLocalTS", Long.TYPE));
      label2858:
      i = paramCursor.getColumnIndex("apolloServerTS");
      if (i != -1) {
        break label4239;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloServerTS", Long.TYPE));
      label2893:
      i = paramCursor.getColumnIndex("apolloUpdateTime");
      if (i != -1) {
        break label4254;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloUpdateTime", Long.TYPE));
      label2928:
      i = paramCursor.getColumnIndex("apolloDataBuffer");
      if (i != -1) {
        break label4269;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloDataBuffer", String.class));
      label2963:
      i = paramCursor.getColumnIndex("uinType");
      if (i != -1) {
        break label4284;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uinType", Integer.TYPE));
      label2998:
      i = paramCursor.getColumnIndex("apolloHistoryDress");
      if (i != -1) {
        break label4299;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("apolloHistoryDress", String.class));
      label3033:
      i = paramCursor.getColumnIndex("latestPLUpdateTimestamp");
      if (i != -1) {
        break label4314;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("latestPLUpdateTimestamp", Long.TYPE));
      label3068:
      i = paramCursor.getColumnIndex("lastPullPLNewsTimestamp");
      if (i != -1) {
        break label4329;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastPullPLNewsTimestamp", Long.TYPE));
      label3105:
      i = paramCursor.getColumnIndex("lastPLNewsTimestamp");
      if (i != -1) {
        break label4344;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastPLNewsTimestamp", Long.TYPE));
      label3142:
      i = paramCursor.getColumnIndex("medalUpdateTimestamp");
      if (i != -1) {
        break label4359;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("medalUpdateTimestamp", Long.TYPE));
      label3179:
      i = paramCursor.getColumnIndex("lastMedalTimestamp");
      if (i != -1) {
        break label4374;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("lastMedalTimestamp", Long.TYPE));
      label3216:
      i = paramCursor.getColumnIndex("diyFontTimestampBytes");
      if (i != -1) {
        break label4389;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyFontTimestampBytes", [B.class));
      label3253:
      i = paramCursor.getColumnIndex("diyFontConfigBytes");
      if (i != -1) {
        break label4404;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("diyFontConfigBytes", [B.class));
      label3290:
      i = paramCursor.getColumnIndex("loverChatLevel");
      if (i != -1) {
        break label4419;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("loverChatLevel", Integer.TYPE));
      label3327:
      i = paramCursor.getColumnIndex("loverChatDays");
      if (i != -1) {
        break label4434;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("loverChatDays", Integer.TYPE));
      label3364:
      i = paramCursor.getColumnIndex("loverLastChatTime");
      if (i != -1) {
        break label4449;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("loverLastChatTime", Long.TYPE));
      label3401:
      i = paramCursor.getColumnIndex("loverFlag");
      if (i != -1) {
        break label4464;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("loverFlag", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("loverTransFlag");
      if (i != -1) {
        break label4479;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("loverTransFlag", Boolean.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label3492:
      paramEntity.pendantId = paramCursor.getLong(i);
      break label1318;
      label3507:
      paramEntity.pendantDiyId = paramCursor.getInt(i);
      break label1353;
      label3522:
      paramEntity.uVipFont = paramCursor.getLong(i);
      break label1388;
      label3537:
      paramEntity.vipFontType = paramCursor.getInt(i);
      break label1423;
      label3552:
      paramEntity.magicFont = paramCursor.getInt(i);
      break label1458;
      label3567:
      paramEntity.lastUpdateTime = paramCursor.getLong(i);
      break label1493;
      label3582:
      paramEntity.fontEffect = paramCursor.getInt(i);
      break label1528;
      label3597:
      paramEntity.fontEffectLastUpdateTime = paramCursor.getLong(i);
      break label1563;
      label3612:
      paramEntity.faceId = paramCursor.getInt(i);
      break label1598;
      label3627:
      paramEntity.faceIdUpdateTime = paramCursor.getLong(i);
      break label1633;
      label3642:
      paramEntity.colorRingId = paramCursor.getLong(i);
      break label1668;
      label3657:
      paramEntity.commingRingId = paramCursor.getLong(i);
      break label1703;
      label3672:
      paramEntity.timestamp = paramCursor.getLong(i);
      break label1738;
      label3687:
      paramEntity.richTime = paramCursor.getLong(i);
      break label1773;
      label3702:
      paramEntity.richBuffer = paramCursor.getBlob(i);
      break label1808;
      label3717:
      paramEntity.feedType = paramCursor.getInt(i);
      break label1843;
      label3732:
      paramEntity.feedTime = paramCursor.getLong(i);
      break label1878;
      label3747:
      paramEntity.feedContent = paramCursor.getString(i);
      break label1913;
      label3762:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.feedHasPhoto = paramBoolean;
        break;
      }
      label3789:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isAdded2C2C = paramBoolean;
        break;
      }
      label3816:
      paramEntity.chatInputType = paramCursor.getInt(i);
      break label2018;
      label3831:
      paramEntity.showC2CPanel = paramCursor.getInt(i);
      break label2053;
      label3846:
      paramEntity.pttChangeVoiceType = paramCursor.getInt(i);
      break label2088;
      label3861:
      paramEntity.audioPanelType = paramCursor.getInt(i);
      break label2123;
      label3876:
      paramEntity.chatHotLevel = paramCursor.getInt(i);
      break label2158;
      label3891:
      paramEntity.chatDays = paramCursor.getInt(i);
      break label2193;
      label3906:
      paramEntity.praiseHotLevel = paramCursor.getInt(i);
      break label2228;
      label3921:
      paramEntity.praiseDays = paramCursor.getInt(i);
      break label2263;
      label3936:
      paramEntity.bestIntimacyType = paramCursor.getInt(i);
      break label2298;
      label3951:
      paramEntity.bestIntimacyDays = paramCursor.getInt(i);
      break label2333;
      label3966:
      paramEntity.lastpraiseTime = paramCursor.getLong(i);
      break label2368;
      label3981:
      paramEntity.lastChatTime = paramCursor.getLong(i);
      break label2403;
      label3996:
      paramEntity.qzoneVisitType = paramCursor.getInt(i);
      break label2438;
      label4011:
      paramEntity.qzoneHotDays = paramCursor.getInt(i);
      break label2473;
      label4026:
      paramEntity.lastQzoneVisitTime = paramCursor.getLong(i);
      break label2508;
      label4041:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindChat = paramBoolean;
        break;
      }
      label4068:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindLoverChat = paramBoolean;
        break;
      }
      label4095:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindPraise = paramBoolean;
        break;
      }
      label4122:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasRemindQzoneVisit = paramBoolean;
        break;
      }
      label4149:
      paramEntity.isGrayTipRemind = paramCursor.getInt(i);
      break label2683;
      label4164:
      paramEntity.isGrayTipMultiRemind = paramCursor.getInt(i);
      break label2718;
      label4179:
      paramEntity.apolloVipFlag = paramCursor.getInt(i);
      break label2753;
      label4194:
      paramEntity.apolloVipLevel = paramCursor.getInt(i);
      break label2788;
      label4209:
      paramEntity.apolloStatus = paramCursor.getInt(i);
      break label2823;
      label4224:
      paramEntity.apolloLocalTS = paramCursor.getLong(i);
      break label2858;
      label4239:
      paramEntity.apolloServerTS = paramCursor.getLong(i);
      break label2893;
      label4254:
      paramEntity.apolloUpdateTime = paramCursor.getLong(i);
      break label2928;
      label4269:
      paramEntity.apolloDataBuffer = paramCursor.getString(i);
      break label2963;
      label4284:
      paramEntity.uinType = paramCursor.getInt(i);
      break label2998;
      label4299:
      paramEntity.apolloHistoryDress = paramCursor.getString(i);
      break label3033;
      label4314:
      paramEntity.latestPLUpdateTimestamp = paramCursor.getLong(i);
      break label3068;
      label4329:
      paramEntity.lastPullPLNewsTimestamp = paramCursor.getLong(i);
      break label3105;
      label4344:
      paramEntity.lastPLNewsTimestamp = paramCursor.getLong(i);
      break label3142;
      label4359:
      paramEntity.medalUpdateTimestamp = paramCursor.getLong(i);
      break label3179;
      label4374:
      paramEntity.lastMedalTimestamp = paramCursor.getLong(i);
      break label3216;
      label4389:
      paramEntity.diyFontTimestampBytes = paramCursor.getBlob(i);
      break label3253;
      label4404:
      paramEntity.diyFontConfigBytes = paramCursor.getBlob(i);
      break label3290;
      label4419:
      paramEntity.loverChatLevel = paramCursor.getInt(i);
      break label3327;
      label4434:
      paramEntity.loverChatDays = paramCursor.getInt(i);
      break label3364;
      label4449:
      paramEntity.loverLastChatTime = paramCursor.getLong(i);
      break label3401;
      label4464:
      paramEntity.loverFlag = paramCursor.getInt(i);
    }
    label4479:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.loverTransFlag = paramBoolean;
      return paramEntity;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,pendantId INTEGER ,pendantDiyId INTEGER ,uVipFont INTEGER ,vipFontType INTEGER ,magicFont INTEGER ,lastUpdateTime INTEGER ,fontEffect INTEGER ,fontEffectLastUpdateTime INTEGER ,faceId INTEGER ,faceIdUpdateTime INTEGER ,colorRingId INTEGER ,commingRingId INTEGER ,timestamp INTEGER ,richTime INTEGER ,richBuffer BLOB ,feedType INTEGER ,feedTime INTEGER ,feedContent TEXT ,feedHasPhoto INTEGER ,isAdded2C2C INTEGER ,chatInputType INTEGER ,showC2CPanel INTEGER ,pttChangeVoiceType INTEGER ,audioPanelType INTEGER ,chatHotLevel INTEGER ,chatDays INTEGER ,praiseHotLevel INTEGER ,praiseDays INTEGER ,bestIntimacyType INTEGER ,bestIntimacyDays INTEGER ,lastpraiseTime INTEGER ,lastChatTime INTEGER ,qzoneVisitType INTEGER ,qzoneHotDays INTEGER ,lastQzoneVisitTime INTEGER ,hasRemindChat INTEGER ,hasRemindLoverChat INTEGER ,hasRemindPraise INTEGER ,hasRemindQzoneVisit INTEGER ,isGrayTipRemind INTEGER ,isGrayTipMultiRemind INTEGER ,apolloVipFlag INTEGER ,apolloVipLevel INTEGER ,apolloStatus INTEGER ,apolloLocalTS INTEGER ,apolloServerTS INTEGER ,apolloUpdateTime INTEGER ,apolloDataBuffer TEXT ,uinType INTEGER ,apolloHistoryDress TEXT ,latestPLUpdateTimestamp INTEGER ,lastPullPLNewsTimestamp INTEGER ,lastPLNewsTimestamp INTEGER ,medalUpdateTimestamp INTEGER ,lastMedalTimestamp INTEGER ,diyFontTimestampBytes BLOB ,diyFontConfigBytes BLOB ,loverChatLevel INTEGER ,loverChatDays INTEGER ,loverLastChatTime INTEGER ,loverFlag INTEGER ,loverTransFlag INTEGER)");
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
    paramContentValues.put("hasRemindLoverChat", Boolean.valueOf(paramEntity.hasRemindLoverChat));
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
    paramContentValues.put("loverChatLevel", Integer.valueOf(paramEntity.loverChatLevel));
    paramContentValues.put("loverChatDays", Integer.valueOf(paramEntity.loverChatDays));
    paramContentValues.put("loverLastChatTime", Long.valueOf(paramEntity.loverLastChatTime));
    paramContentValues.put("loverFlag", Integer.valueOf(paramEntity.loverFlag));
    paramContentValues.put("loverTransFlag", Boolean.valueOf(paramEntity.loverTransFlag));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ExtensionInfoDao
 * JD-Core Version:    0.7.0.1
 */