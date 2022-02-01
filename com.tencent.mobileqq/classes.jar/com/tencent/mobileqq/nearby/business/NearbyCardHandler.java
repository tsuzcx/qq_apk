package com.tencent.mobileqq.nearby.business;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.RespFavorite;
import SummaryCard.RespSummaryCard;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import appoint.define.appoint_define.CommonLabel;
import appoint.define.appoint_define.InterestTag;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.jungle.nearby.nio.proto.nearby.NearbyJumpInfo;
import com.tencent.jungle.nearby.nio.proto.oidb_common.DataCardConfig;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeResultItem;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LimitInfo;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.LbsUtils;
import com.tencent.mobileqq.nearby.api.NearbySPUtil;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagInfoUtils;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.now.protocol.CsTask;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.nowsummarycard.NowSummaryCard.ClientInfo;
import com.tencent.nowsummarycard.NowSummaryCard.GiftInfo;
import com.tencent.nowsummarycard.NowSummaryCard.GroupInfo;
import com.tencent.nowsummarycard.NowSummaryCard.InterestTagInfo;
import com.tencent.nowsummarycard.NowSummaryCard.LocationInfo;
import com.tencent.nowsummarycard.NowSummaryCard.NearbySummaryCardReq;
import com.tencent.nowsummarycard.NowSummaryCard.ReqNearbySummaryCard;
import com.tencent.nowsummarycard.NowSummaryCard.RespNearbySummaryCard;
import com.tencent.nowsummarycard.NowSummaryCard.VoteInfo;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RichHead;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.ReqBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.cmd0x9c5.cmd0x9c5.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.RspBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.ReqBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.RspBody;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.LoginSig;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.ReqBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteInfo;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteResult;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ExtParam;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.LoginSig;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ReqBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.RspBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.StockRsp;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.UserZanInfo;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.WarnMsg;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ZanLimitInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.nearby.nearby_ice_break.IceReq;

public class NearbyCardHandler
  extends BusinessHandler
  implements INearbyCardHandler
{
  public static final String a = "com.tencent.mobileqq.nearby.business.NearbyCardHandler";
  protected Set<String> b;
  private QQAppInterface c;
  private AppInterface d;
  
  public NearbyCardHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.d = paramAppInterface;
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.c = ((QQAppInterface)paramAppInterface);
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString, byte paramByte, ToServiceMsg paramToServiceMsg)
  {
    Object localObject1 = new NowSummaryCard.ReqNearbySummaryCard();
    ((NowSummaryCard.ReqNearbySummaryCard)localObject1).tiny_id.set(paramLong2);
    try
    {
      ((NowSummaryCard.ReqNearbySummaryCard)localObject1).uin.set(Long.valueOf(paramString).longValue());
    }
    catch (Exception localException)
    {
      label38:
      Object localObject2;
      break label38;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getNearbySummaryCard, illegal uin: ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e("NearbyCardHandler", 2, ((StringBuilder)localObject2).toString());
    }
    ((NowSummaryCard.ReqNearbySummaryCard)localObject1).location.set(b());
    ((NowSummaryCard.ReqNearbySummaryCard)localObject1).client_info.set(c());
    ((NowSummaryCard.ReqNearbySummaryCard)localObject1).come_from.set(paramInt2);
    localObject2 = new NowSummaryCard.NearbySummaryCardReq();
    ((NowSummaryCard.NearbySummaryCardReq)localObject2).id.set(paramLong1);
    ((NowSummaryCard.NearbySummaryCardReq)localObject2).id_type.set(paramInt1);
    ((NowSummaryCard.NearbySummaryCardReq)localObject2).gender.set(1L);
    ((NowSummaryCard.NearbySummaryCardReq)localObject2).pb_data.set(ByteStringMicro.copyFrom(((NowSummaryCard.ReqNearbySummaryCard)localObject1).toByteArray()));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start uin:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", tinyId:");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(", nowId:");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(", from:");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.e("NearbyCardHandler", 2, ((StringBuilder)localObject1).toString());
    }
    ProtoUtils.a(this.c, new NearbyCardHandler.2(this, false, paramToServiceMsg), ((NowSummaryCard.NearbySummaryCardReq)localObject2).toByteArray(), "NowSummaryCard.NearbySummaryCardReq");
  }
  
  private void a(boolean paramBoolean, NowSummaryCard.RespNearbySummaryCard paramRespNearbySummaryCard, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("partlyRefresh");
    int j = paramBundle.getInt("comeFromType");
    EntityManager localEntityManager;
    EntityTransaction localEntityTransaction;
    int i;
    if ((paramBoolean) && (paramRespNearbySummaryCard != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uin:");
      ((StringBuilder)localObject1).append(paramRespNearbySummaryCard.uin.get());
      ((StringBuilder)localObject1).append(", tinyId:");
      ((StringBuilder)localObject1).append(paramRespNearbySummaryCard.tiny_id.get());
      ((StringBuilder)localObject1).append(", nickName:");
      ((StringBuilder)localObject1).append(paramRespNearbySummaryCard.nick.get());
      QLog.e("NearbyCardHandler", 1, ((StringBuilder)localObject1).toString());
      localEntityManager = this.c.getEntityManagerFactory().createEntityManager();
      localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
      long l1 = paramBundle.getLong("tinyId", 0L);
      long l2 = paramBundle.getLong("nowId");
      i = paramBundle.getInt("nowUserType");
      if (i == 0) {
        paramBundle = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(l1) });
      } else if (l2 > 0L) {
        paramBundle = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "nowId=?", new String[] { String.valueOf(l2) });
      } else {
        paramBundle = null;
      }
      if (paramBundle == null)
      {
        paramBundle = new NearbyPeopleCard();
      }
      else
      {
        int k = paramBundle.getStatus();
        long l3 = paramBundle.getId();
        localObject1 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject1).isForbidSendGiftMsg = paramBundle.isForbidSendGiftMsg;
        ((NearbyPeopleCard)localObject1).isForbidSendGiftMsgForTribar = paramBundle.isForbidSendGiftMsgForTribar;
        ((NearbyPeopleCard)localObject1).isForbidSendMsg = paramBundle.isForbidSendMsg;
        ((NearbyPeopleCard)localObject1).maskMsgFlag = paramBundle.maskMsgFlag;
        ((NearbyPeopleCard)localObject1).highScoreNum = paramBundle.highScoreNum;
        ((NearbyPeopleCard)localObject1).isForbidSendMsgForTribar = paramBundle.isForbidSendMsgForTribar;
        ((NearbyPeopleCard)localObject1).disableSendGiftBtnTips = paramBundle.disableSendGiftBtnTips;
        ((NearbyPeopleCard)localObject1).disableSendGiftBtnTipsForTribar = paramBundle.disableSendGiftBtnTipsForTribar;
        ((NearbyPeopleCard)localObject1).disableSendMsgBtnTips = paramBundle.disableSendMsgBtnTips;
        ((NearbyPeopleCard)localObject1).disableSendMsgBtnTipsForTribar = paramBundle.disableSendMsgBtnTipsForTribar;
        ((NearbyPeopleCard)localObject1).faceScoreWording = paramBundle.faceScoreWording;
        ((NearbyPeopleCard)localObject1).faceScoreWordingColor = paramBundle.faceScoreWordingColor;
        ((NearbyPeopleCard)localObject1).entryAbility = paramBundle.entryAbility;
        ((NearbyPeopleCard)localObject1).faceScoreTailWordingColor = paramBundle.faceScoreTailWordingColor;
        ((NearbyPeopleCard)localObject1).faceScoreTailWording = paramBundle.faceScoreTailWording;
        ((NearbyPeopleCard)localObject1).faceScoreIconUrl = paramBundle.faceScoreIconUrl;
        ((NearbyPeopleCard)localObject1).entryAbility = paramBundle.entryAbility;
        ((NearbyPeopleCard)localObject1).setStatus(k);
        ((NearbyPeopleCard)localObject1).setId(l3);
        paramBundle = (Bundle)localObject1;
      }
      if (j == 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramBundle.isHostSelf = paramBoolean;
      if (paramBundle.isHostSelf) {
        paramBundle.uin = this.c.getCurrentAccountUin();
      }
      for (;;)
      {
        break;
        if (paramRespNearbySummaryCard.is_friend.get() == 1) {
          paramBundle.uin = String.valueOf(paramRespNearbySummaryCard.uin.get());
        } else {
          paramBundle.uin = "0";
        }
      }
      if (l1 > 0L) {}
      for (paramBundle.tinyId = l1;; paramBundle.tinyId = 0L) {
        for (;;)
        {
          try
          {
            paramBundle.tinyId = Long.valueOf(paramRespNearbySummaryCard.tiny_id.get()).longValue();
          }
          catch (Exception localException4)
          {
            label548:
            Object localObject4;
            Object localObject5;
            Object localObject2;
            Object localObject3;
            StringBuilder localStringBuilder;
            Cursor localCursor;
            break label548;
          }
        }
      }
      paramBundle.nowId = l2;
      paramBundle.nowUserType = i;
      paramBundle.nickname = paramRespNearbySummaryCard.nick.get();
      paramBundle.sign = paramRespNearbySummaryCard.sign.get();
      paramBundle.xuanYan = paramRespNearbySummaryCard.rich_sign.get().toByteArray();
      paramBundle.gender = ((byte)(int)paramRespNearbySummaryCard.gender.get());
      paramBundle.age = paramRespNearbySummaryCard.age.get();
      paramBundle.birthday = ((int)paramRespNearbySummaryCard.birthday.get());
      paramBundle.job = paramRespNearbySummaryCard.profession.get();
      paramBundle.constellation = ((byte)paramRespNearbySummaryCard.constellation.get());
      paramBundle.distance = paramRespNearbySummaryCard.distance.get();
      paramBundle.timeDiff = paramRespNearbySummaryCard.elapse.get();
      paramBundle.company = paramRespNearbySummaryCard.company.get();
      paramBundle.college = paramRespNearbySummaryCard.school.get();
      paramBundle.maritalStatus = ((byte)paramRespNearbySummaryCard.marriage.get());
      paramBundle.collegeId = paramRespNearbySummaryCard.school_id.get();
      paramBundle.nearbyInfo = paramRespNearbySummaryCard.nearby_info.get().toByteArray();
      paramBundle.hometownCountry = ConditionSearchManager.a(paramRespNearbySummaryCard.home_country.get());
      paramBundle.hometownProvice = ConditionSearchManager.a(paramRespNearbySummaryCard.home_province.get());
      paramBundle.hometownCity = ConditionSearchManager.a(paramRespNearbySummaryCard.home_city.get());
      paramBundle.hometownDistrict = ConditionSearchManager.a(paramRespNearbySummaryCard.home_zone.get());
      paramBundle.lastUpdateNickTime = System.currentTimeMillis();
      paramBundle.vTempChatSig = paramRespNearbySummaryCard.temp_chat_sig.get().toByteArray();
      if (paramRespNearbySummaryCard.is_friend.get() == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramBundle.isFriend = paramBoolean;
      paramBundle.chatId = paramRespNearbySummaryCard.chat_id.get();
      paramBundle.nearbyTag = paramRespNearbySummaryCard.nearby_tag;
      paramBundle.commonTag = paramRespNearbySummaryCard.common_tag;
      if (paramRespNearbySummaryCard.is_verified.get() != 0) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramBundle.isVerified = paramBoolean;
      localObject1 = (NowSummaryCard.GroupInfo)paramRespNearbySummaryCard.group_info.get();
      paramBundle.recentlyJoinedGroup = new Pair(Long.valueOf(((NowSummaryCard.GroupInfo)localObject1).group_id.get()), ((NowSummaryCard.GroupInfo)localObject1).group_name.get());
      paramBundle.favoriteSource = j;
      if (paramBundle.vTempChatSig != null)
      {
        if ((paramBundle.vTempChatSig.length == 0) && (!paramBundle.isHostSelf))
        {
          localObject1 = this.c;
          ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_card_get_sig_length_0", 0, 0, ((QQAppInterface)localObject1).getCurrentAccountUin(), String.valueOf(paramBundle.tinyId), "", "");
        }
        if (this.c.getMsgCache().r(String.valueOf(paramBundle.tinyId)) == null) {
          this.c.getMsgCache().g(String.valueOf(paramBundle.tinyId), paramBundle.vTempChatSig);
        }
      }
      else
      {
        localObject1 = this.c;
        ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_card_get_sig_null", 0, 0, ((QQAppInterface)localObject1).getCurrentAccountUin(), String.valueOf(paramBundle.tinyId), "", "");
      }
      localObject1 = paramRespNearbySummaryCard.common_label.get().toByteArray();
      if (localObject1 != null)
      {
        paramBundle.commonLabels = new ArrayList();
        localObject4 = new appoint_define.CommonLabel();
        try
        {
          ((appoint_define.CommonLabel)localObject4).mergeFrom((byte[])localObject1);
          localObject1 = ((appoint_define.CommonLabel)localObject4).rpt_interst_name.get();
          localObject5 = ((appoint_define.CommonLabel)localObject4).rpt_interst_type.get();
          localObject4 = new JSONArray();
          if (((List)localObject1).size() == ((List)localObject5).size())
          {
            i = 0;
            while (i < ((List)localObject1).size())
            {
              localObject5 = ((ByteStringMicro)((List)localObject1).get(i)).toStringUtf8();
              paramBundle.commonLabels.add(localObject5);
              ((JSONArray)localObject4).put(localObject5);
              i += 1;
            }
          }
          paramBundle.commonLabelString = ((JSONArray)localObject4).toString();
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("commonLabel exception:");
            ((StringBuilder)localObject4).append(localException1.getMessage());
            QLog.e("NearbyCardHandler", 2, ((StringBuilder)localObject4).toString());
          }
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("collegeId=");
        ((StringBuilder)localObject2).append(paramRespNearbySummaryCard.school_id.get());
        QLog.i("Q.profilecard.SummaryCard", 4, ((StringBuilder)localObject2).toString());
      }
      paramBundle.updateDisplayPicInfos(paramRespNearbySummaryCard.date_face.get().toByteArray(), null, paramBundle.isHostSelf);
      if ((paramBundle.userFlag & 0x2) != 0L) {
        paramBundle.switchQzone = true;
      } else {
        paramBundle.switchQzone = false;
      }
      if ((paramBundle.userFlag & 0x4) != 0L) {
        paramBundle.switchHobby = true;
      } else {
        paramBundle.switchHobby = false;
      }
      if (!paramBundle.isPhotoUseCache())
      {
        paramBundle.qzonePicUrl_1 = "";
        paramBundle.qzonePicUrl_2 = "";
        paramBundle.qzonePicUrl_3 = "";
      }
      if (paramRespNearbySummaryCard.interest_tag.has())
      {
        l1 = paramRespNearbySummaryCard.interest_tag.flag.get();
        try
        {
          localObject2 = new cmd0x9c5.RspBody();
          ((cmd0x9c5.RspBody)localObject2).mergeFrom(paramRespNearbySummaryCard.interest_tag.tag_info.get().toByteArray());
          paramBundle.updateInterestTags(l1, ((cmd0x9c5.RspBody)localObject2).msg_interest_tags.get());
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            break label1574;
          }
        }
        QLog.i("InterestTag", 2, localException2.toString());
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("Q.profilecard.SummaryCard", 2, "stInterestTag is null");
      }
      label1574:
      if (paramRespNearbySummaryCard.gift_info.has())
      {
        paramBundle.switchGiftVisible = ((NowSummaryCard.GiftInfo)paramRespNearbySummaryCard.gift_info.get()).open_flag.get();
        paramBundle.vGiftInfo = ((NowSummaryCard.GiftInfo)paramRespNearbySummaryCard.gift_info.get()).toByteArray();
      }
      if (paramRespNearbySummaryCard.vote_info.has())
      {
        localObject3 = (NowSummaryCard.VoteInfo)paramRespNearbySummaryCard.vote_info.get();
        paramBundle.likeCount = ((NowSummaryCard.VoteInfo)localObject3).vote_count.get();
        paramBundle.likeCountInc = ((NowSummaryCard.VoteInfo)localObject3).latest_vote_count.get();
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("handleGetSummaryCard likeCount:");
          ((StringBuilder)localObject3).append(paramBundle.likeCount);
          ((StringBuilder)localObject3).append(" newVoteCountInc:");
          ((StringBuilder)localObject3).append(paramBundle.likeCountInc);
          QLog.i("Q.profilecard.SummaryCard", 2, ((StringBuilder)localObject3).toString());
        }
      }
      if (paramBundle.nearbyInfo != null) {
        localObject3 = new nearby.Cmd0x1RspBody();
      }
    }
    try
    {
      ((nearby.Cmd0x1RspBody)localObject3).mergeFrom(paramBundle.nearbyInfo);
      if (j != 51) {
        break label1843;
      }
      if (((nearby.Cmd0x1RspBody)localObject3).uint32_if_mask_msg.get() != 1) {
        break label3870;
      }
      paramBoolean = true;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        label1843:
        label3792:
        label3837:
        continue;
        label1925:
        label3078:
        paramBoolean = false;
        continue;
        paramBoolean = false;
        continue;
        paramBoolean = false;
        continue;
        paramBoolean = false;
        continue;
        paramBoolean = false;
      }
    }
    paramBundle.isForbidSendMsgForTribar = paramBoolean;
    if (((nearby.Cmd0x1RspBody)localObject3).uint32_if_mask_gift.get() == 1)
    {
      paramBoolean = true;
      paramBundle.isForbidSendGiftMsgForTribar = paramBoolean;
      paramBundle.disableSendMsgBtnTipsForTribar = ((nearby.Cmd0x1RspBody)localObject3).bytes_mask_msg_reason.get().toStringUtf8();
      paramBundle.disableSendGiftBtnTipsForTribar = ((nearby.Cmd0x1RspBody)localObject3).bytes_mask_gift_reason.get().toStringUtf8();
      break label1925;
      paramBundle.maskMsgFlag = ((nearby.Cmd0x1RspBody)localObject3).uint32_if_mask_msg.get();
      if (paramBundle.maskMsgFlag != 1) {
        break label3880;
      }
      paramBoolean = true;
      paramBundle.isForbidSendMsg = paramBoolean;
      if (((nearby.Cmd0x1RspBody)localObject3).uint32_if_mask_gift.get() != 1) {
        break label3885;
      }
      paramBoolean = true;
      paramBundle.isForbidSendGiftMsg = paramBoolean;
      paramBundle.disableSendMsgBtnTips = ((nearby.Cmd0x1RspBody)localObject3).bytes_mask_msg_reason.get().toStringUtf8();
      paramBundle.disableSendGiftBtnTips = ((nearby.Cmd0x1RspBody)localObject3).bytes_mask_gift_reason.get().toStringUtf8();
      try
      {
        paramBoolean = QLog.isColorLevel();
        if (paramBoolean)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("handleGetSummaryCard, comeFromType=");
          ((StringBuilder)localObject4).append(j);
          ((StringBuilder)localObject4).append(", maskMsgFlag=");
          ((StringBuilder)localObject4).append(((nearby.Cmd0x1RspBody)localObject3).uint32_if_mask_msg.get());
          ((StringBuilder)localObject4).append(", maskMsgTip=");
          ((StringBuilder)localObject4).append(((nearby.Cmd0x1RspBody)localObject3).bytes_mask_msg_reason.get().toStringUtf8());
          ((StringBuilder)localObject4).append(", curUin=");
          ((StringBuilder)localObject4).append(this.c.getCurrentAccountUin());
          QLog.d("nearby.bindphone", 2, ((StringBuilder)localObject4).toString());
        }
        else
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("handleGetSummaryCard, comeFromType=");
          ((StringBuilder)localObject4).append(j);
          ((StringBuilder)localObject4).append(", maskMsgFlag=");
          ((StringBuilder)localObject4).append(((nearby.Cmd0x1RspBody)localObject3).uint32_if_mask_msg.get());
          ((StringBuilder)localObject4).append(", maskMsgTip=");
          ((StringBuilder)localObject4).append(((nearby.Cmd0x1RspBody)localObject3).bytes_mask_msg_reason.get().toStringUtf8());
          QLog.d("nearby.bindphone", 1, ((StringBuilder)localObject4).toString());
        }
      }
      catch (Exception localException5)
      {
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("log exp:");
          ((StringBuilder)localObject5).append(localException5.toString());
          QLog.e("NearbyCardHandler", 2, ((StringBuilder)localObject5).toString());
        }
      }
      paramBundle.highScoreNum = ((nearby.Cmd0x1RspBody)localObject3).uint32_high_score_num.get();
      if (((nearby.Cmd0x1RspBody)localObject3).bytes_face_score_config.has())
      {
        paramBundle.faceScoreIconUrl = ((oidb_common.DataCardConfig)((nearby.Cmd0x1RspBody)localObject3).bytes_face_score_config.get()).bytes_icon_url.get().toStringUtf8();
        paramBundle.faceScoreTailWording = ((oidb_common.DataCardConfig)((nearby.Cmd0x1RspBody)localObject3).bytes_face_score_config.get()).bytes_tail_wording.get().toStringUtf8();
        paramBundle.faceScoreTailWordingColor = ((oidb_common.DataCardConfig)((nearby.Cmd0x1RspBody)localObject3).bytes_face_score_config.get()).uint32_tail_wording_color.get();
        paramBundle.faceScoreWording = ((oidb_common.DataCardConfig)((nearby.Cmd0x1RspBody)localObject3).bytes_face_score_config.get()).bytes_card_wording.get().toStringUtf8();
        paramBundle.faceScoreWordingColor = ((oidb_common.DataCardConfig)((nearby.Cmd0x1RspBody)localObject3).bytes_face_score_config.get()).uint32_card_wording_color.get();
        paramBundle.entryAbility = ((oidb_common.DataCardConfig)((nearby.Cmd0x1RspBody)localObject3).bytes_face_score_config.get()).uint32_entry_ability.get();
      }
      else
      {
        paramBundle.faceScoreIconUrl = "";
        paramBundle.faceScoreTailWording = "";
        paramBundle.faceScoreTailWordingColor = 0;
        paramBundle.faceScoreWording = "";
        paramBundle.faceScoreWordingColor = 0;
        paramBundle.entryAbility = 0;
      }
      if (((nearby.Cmd0x1RspBody)localObject3).uint32_jump_app_open.get() != 1) {
        break label3890;
      }
      paramBoolean = true;
      paramBundle.isSendMsgBtnDownloadAppOpen = paramBoolean;
      paramBundle.sendMsgBtnDownloadAppTips = ((nearby.Cmd0x1RspBody)localObject3).str_jump_app_result_msg.get();
      paramBundle.tribeAppDownloadPageUrl = ((nearby.Cmd0x1RspBody)localObject3).str_jump_app_url.get();
      paramBundle.addPicBtnDownloadAppTips = ((nearby.Cmd0x1RspBody)localObject3).str_plus_download_app_msg.get();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGetSummaryCard, uin=");
        localStringBuilder.append(paramBundle.uin);
        localStringBuilder.append(", isSendMsgBtnDownloadAppOpen=");
        localStringBuilder.append(paramBundle.isSendMsgBtnDownloadAppOpen);
        localStringBuilder.append(", isAddPicBtnDownloadAppOpen:");
        localStringBuilder.append(paramBundle.isAddPicBtnDownloadAppOpen());
        localStringBuilder.append(", sendMsgBtnDownloadAppTips:");
        localStringBuilder.append(paramBundle.sendMsgBtnDownloadAppTips);
        localStringBuilder.append(", addPicBtnDownloadAppTips=");
        localStringBuilder.append(paramBundle.addPicBtnDownloadAppTips);
        localStringBuilder.append(", tribeAppDownloadPageUrl=");
        localStringBuilder.append(paramBundle.tribeAppDownloadPageUrl);
        QLog.d("Q.nearby.tribeAppDownload", 2, localStringBuilder.toString());
      }
      paramBundle.firstOfficialMsg = ((nearby.Cmd0x1RspBody)localObject3).bytes_official_wording.get().toStringUtf8();
      paramBundle.unverifyGrayTips = ((nearby.Cmd0x1RspBody)localObject3).bytes_aio_grey_tips_wording.get().toStringUtf8();
      if (((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.has())
      {
        paramBundle.guideAppNowTip = ((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.tip_content.get();
        paramBundle.guideAppNowTipLeftBtn = ((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.tip_left_btn.get();
        paramBundle.guideAppNowTipRightBtnInstalled = ((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.tip_right_btn_installed.get();
        paramBundle.guideAppNowTipRightBtnNotInstalled = ((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.tip_right_btn_not_installed.get();
        paramBundle.guideAppNowPackage = ((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.android_app_key.get();
        paramBundle.guideAppNowJumpUri = ((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.jump_uri.get();
        paramBundle.guideAppNowDownloadUrl = ((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.app_download_url.get();
        paramBundle.guideVerifiedDialogTitle = ((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.tip_title.get();
        paramBundle.guideVerifiedDialogRightBtnText = ((nearby.Cmd0x1RspBody)localObject3).nearby_popover_info.tip_right_btn.get();
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("nearby_popover_info=\n");
          ((StringBuilder)localObject3).append("nearCard.guideAppNowTip=");
          ((StringBuilder)localObject3).append(paramBundle.guideAppNowTip);
          ((StringBuilder)localObject3).append("\n");
          ((StringBuilder)localObject3).append("nearCard.guideAppNowTipLeftBtn=");
          ((StringBuilder)localObject3).append(paramBundle.guideAppNowTipLeftBtn);
          ((StringBuilder)localObject3).append("\n");
          ((StringBuilder)localObject3).append("nearCard.guideAppNowTipRightBtnInstall=");
          ((StringBuilder)localObject3).append(paramBundle.guideAppNowTipRightBtnInstalled);
          ((StringBuilder)localObject3).append("\n");
          ((StringBuilder)localObject3).append("nearCard.guideAppNowTipRightBtnNotInstalled=");
          ((StringBuilder)localObject3).append(paramBundle.guideAppNowTipRightBtnNotInstalled);
          ((StringBuilder)localObject3).append("\n");
          ((StringBuilder)localObject3).append("nearCard.guideAppNowPackage=");
          ((StringBuilder)localObject3).append(paramBundle.guideAppNowPackage);
          ((StringBuilder)localObject3).append("\n");
          ((StringBuilder)localObject3).append("nearCard.guideAppNowJumpUri=");
          ((StringBuilder)localObject3).append(paramBundle.guideAppNowJumpUri);
          ((StringBuilder)localObject3).append("\n");
          ((StringBuilder)localObject3).append("nearCard.guideAppNowDownloadUrl=");
          ((StringBuilder)localObject3).append(paramBundle.guideAppNowDownloadUrl);
          ((StringBuilder)localObject3).append("\n");
          ((StringBuilder)localObject3).append("nearCard.guideVerifiedDialogTitle=");
          ((StringBuilder)localObject3).append(paramBundle.guideVerifiedDialogTitle);
          ((StringBuilder)localObject3).append("\n");
          ((StringBuilder)localObject3).append("nearCard.guideVerifiedDialogRightBtnText=");
          ((StringBuilder)localObject3).append(paramBundle.guideVerifiedDialogRightBtnText);
          ((StringBuilder)localObject3).append("\n");
          QLog.i("NearbyCardHandler", 2, ((StringBuilder)localObject3).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("NearbyCardHandler", 2, "(nearbyInfo.nearby_popover_info not has");
        break label3078;
        if (QLog.isColorLevel()) {
          QLog.d("NearbyCardHandler", 2, "decode nearbyInfo failed!");
        }
      }
      paramBundle.nearbyNowDataBytes = paramRespNearbySummaryCard.now_info.get().toByteArray();
      try
      {
        localObject3 = new cmd0xac5.NearbyNowData();
        ((cmd0xac5.NearbyNowData)localObject3).mergeFrom(paramBundle.nearbyNowDataBytes);
        paramRespNearbySummaryCard = (NowSummaryCard.RespNearbySummaryCard)localObject3;
        if (QLog.isColorLevel())
        {
          paramRespNearbySummaryCard = new StringBuilder();
          paramRespNearbySummaryCard.append("handleGetSummaryCard, hasMoreUrl=");
          paramRespNearbySummaryCard.append(((cmd0xac5.NearbyNowData)localObject3).bytes_more_video_url.has());
          paramRespNearbySummaryCard.append(", hasVideoList=");
          paramRespNearbySummaryCard.append(((cmd0xac5.NearbyNowData)localObject3).rpt_msg_now_video_feed.has());
          paramRespNearbySummaryCard.append(", hasAnchorList=");
          paramRespNearbySummaryCard.append(((cmd0xac5.NearbyNowData)localObject3).rpt_msg_now_follow_anchor.has());
          QLog.d("NearbyCardHandler", 2, paramRespNearbySummaryCard.toString());
          paramRespNearbySummaryCard = (NowSummaryCard.RespNearbySummaryCard)localObject3;
        }
      }
      catch (Exception paramRespNearbySummaryCard)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("handleGetSummaryCard, exp:");
          ((StringBuilder)localObject3).append(paramRespNearbySummaryCard.toString());
          QLog.w("NearbyCardHandler", 2, ((StringBuilder)localObject3).toString());
        }
        paramRespNearbySummaryCard = null;
      }
      paramBundle.nearbyNowData = paramRespNearbySummaryCard;
      notifyUI(51, true, paramBundle, bool);
      paramRespNearbySummaryCard = (NearbyCardManager)this.c.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if (j == 51) {
        paramRespNearbySummaryCard.b(paramBundle.uin, SystemClock.elapsedRealtime());
      } else {
        paramRespNearbySummaryCard.a(String.valueOf(paramBundle.tinyId), SystemClock.elapsedRealtime());
      }
      if (QLog.isDevelopLevel())
      {
        paramRespNearbySummaryCard = new StringBuilder();
        paramRespNearbySummaryCard.append(" addProfileCardUpdateTime2Cache tinyId/time: ");
        paramRespNearbySummaryCard.append(paramBundle.tinyId);
        paramRespNearbySummaryCard.append(" ");
        paramRespNearbySummaryCard.append(SystemClock.elapsedRealtime());
        QLog.i("NearbyPeopleProfileActivity", 4, paramRespNearbySummaryCard.toString());
      }
      paramRespNearbySummaryCard = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramBundle.isHostSelf)
      {
        localObject3 = paramRespNearbySummaryCard.g(paramBundle.uin);
        ((Card)localObject3).iVoteIncrement = paramBundle.likeCountInc;
        ((Card)localObject3).lVoteCount = paramBundle.likeCount;
        NearbySPUtil.a(this.c.getAccount(), ((Card)localObject3).lVoteCount, ((Card)localObject3).iVoteIncrement);
        try
        {
          paramRespNearbySummaryCard.a((Card)localObject3);
          NearbySPUtil.b(this.c.getAccount(), "self_school_name", paramBundle.college);
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
      }
      if ((paramBundle.isHostSelf) && (paramBundle.charmLevel > 0)) {
        ((HotChatManager)this.c.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramBundle.charmLevel);
      }
      paramRespNearbySummaryCard.a(paramBundle);
      try
      {
        if (paramBundle.getStatus() == 1000)
        {
          localCursor = localEntityManager.query(false, NearbyPeopleCard.class.getSimpleName(), null, null, null, null, null, null, null);
          if (localCursor != null) {
            paramRespNearbySummaryCard = localCursor;
          }
        }
        try
        {
          i = localCursor.getCount();
          paramRespNearbySummaryCard = localCursor;
          localCursor.moveToFirst();
          if (i > 200)
          {
            while (i > 100)
            {
              paramRespNearbySummaryCard = localCursor;
              localCursor.moveToNext();
              i -= 1;
            }
            paramRespNearbySummaryCard = localCursor;
            i = localCursor.getInt(localCursor.getColumnIndex("_id"));
            paramRespNearbySummaryCard = localCursor;
            localStringBuilder = new StringBuilder();
            paramRespNearbySummaryCard = localCursor;
            localStringBuilder.append("delete from ");
            paramRespNearbySummaryCard = localCursor;
            localStringBuilder.append(NearbyPeopleCard.class.getSimpleName());
            paramRespNearbySummaryCard = localCursor;
            localStringBuilder.append(" where ");
            paramRespNearbySummaryCard = localCursor;
            localStringBuilder.append("_id");
            paramRespNearbySummaryCard = localCursor;
            localStringBuilder.append(" < ");
            paramRespNearbySummaryCard = localCursor;
            localStringBuilder.append(i);
            paramRespNearbySummaryCard = localCursor;
            localStringBuilder.append(";");
            paramRespNearbySummaryCard = localCursor;
            localEntityManager.execSQL(localStringBuilder.toString());
          }
          paramRespNearbySummaryCard = localCursor;
          localEntityManager.persistOrReplace(paramBundle);
          paramBundle = localCursor;
          break label3792;
          if ((paramBundle.getStatus() == 1001) || (paramBundle.getStatus() == 1002)) {
            localEntityManager.update(paramBundle);
          }
          paramBundle = null;
          paramRespNearbySummaryCard = paramBundle;
          localEntityTransaction.commit();
          if (paramBundle != null) {
            paramBundle.close();
          }
          localEntityTransaction.end();
          localEntityManager.close();
          return;
        }
        finally {}
        if (paramRespNearbySummaryCard == null) {
          break label3837;
        }
      }
      finally
      {
        paramRespNearbySummaryCard = null;
      }
      paramRespNearbySummaryCard.close();
      localEntityTransaction.end();
      localEntityManager.close();
      throw paramBundle;
      notifyUI(51, false, null, bool);
    }
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handleGetShowExtTroopListRsp");
    }
    StringBuilder localStringBuilder;
    Object localObject1;
    if ((paramBoolean) && (paramOIDBSSOPkg != null))
    {
      paramObject = paramToServiceMsg.extraData.getString("target_uin");
      localStringBuilder = new StringBuilder();
      localObject1 = new cmd0x8b4.RspBody();
    }
    try
    {
      ((cmd0x8b4.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      paramOIDBSSOPkg = new Object[2];
      paramOIDBSSOPkg[0] = Integer.valueOf(((cmd0x8b4.RspBody)localObject1).uint32_result.get());
      paramOIDBSSOPkg[1] = null;
      if ((paramFromServiceMsg.isSuccess()) && (((cmd0x8b4.RspBody)localObject1).uint32_result.get() == 0))
      {
        if (!((cmd0x8b4.RspBody)localObject1).rpt_group_info.has())
        {
          notifyUI(57, paramBoolean, paramOIDBSSOPkg);
          return;
        }
        paramOIDBSSOPkg = new ArrayList();
        Object localObject2 = ((cmd0x8b4.RspBody)localObject1).rpt_group_info.get();
        localStringBuilder.append("groupInfoList size:");
        localStringBuilder.append(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cmd0x8b4.GroupInfo localGroupInfo = (cmd0x8b4.GroupInfo)((Iterator)localObject2).next();
          paramOIDBSSOPkg.add(new ShowExternalTroop(localGroupInfo));
          localStringBuilder.append("[uint64_gc:");
          localStringBuilder.append(localGroupInfo.uint64_gc.get());
          localStringBuilder.append(",addedTimestamp:");
          localStringBuilder.append(localGroupInfo.uint32_set_display_time.get());
          localStringBuilder.append("], ");
        }
        localObject1 = ((cmd0x8b4.RspBody)localObject1).bytes_text_label.get();
        localObject2 = new ArrayList();
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          ((List)localObject2).add(((ByteStringMicro)((List)localObject1).get(i)).toStringUtf8());
          i += 1;
        }
        notifyUI(57, paramBoolean, new Object[] { Integer.valueOf(0), paramOIDBSSOPkg, localObject2 });
      }
      else
      {
        notifyUI(57, paramBoolean, paramOIDBSSOPkg);
      }
    }
    catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
    {
      break label406;
    }
    catch (NullPointerException paramOIDBSSOPkg)
    {
      label395:
      break label395;
    }
    notifyUI(57, paramBoolean, null);
    break label414;
    label406:
    notifyUI(57, paramBoolean, null);
    label414:
    if (QLog.isColorLevel())
    {
      paramOIDBSSOPkg = new StringBuilder("handleGetShowExtTroopListRsp, handle rsp begin==>");
      paramOIDBSSOPkg.append("|ssoSeq:");
      paramOIDBSSOPkg.append(paramFromServiceMsg.getRequestSsoSeq());
      paramOIDBSSOPkg.append("|ServiceCmd:");
      paramOIDBSSOPkg.append(paramToServiceMsg.getServiceCmd());
      paramOIDBSSOPkg.append("|destUin:");
      paramOIDBSSOPkg.append(paramObject);
      paramOIDBSSOPkg.append("|seTroopArray:");
      paramOIDBSSOPkg.append(localStringBuilder.toString());
      QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, paramOIDBSSOPkg.toString());
    }
    return;
    notifyUI(57, paramBoolean, null);
  }
  
  /* Error */
  private void a(boolean paramBoolean, Object paramObject, Bundle paramBundle, SummaryCard.RespHead paramRespHead)
  {
    // Byte code:
    //   0: ldc_w 933
    //   3: astore 15
    //   5: aload_3
    //   6: ldc 182
    //   8: invokevirtual 188	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   11: istore 12
    //   13: aload_3
    //   14: ldc 190
    //   16: invokevirtual 194	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   19: istore 5
    //   21: iload_1
    //   22: ifeq +7087 -> 7109
    //   25: aload_2
    //   26: checkcast 1233	SummaryCard/RespSummaryCard
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   34: invokevirtual 217	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   37: invokevirtual 223	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   40: astore 27
    //   42: aload 27
    //   44: invokevirtual 229	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   47: astore 28
    //   49: aload 28
    //   51: invokevirtual 234	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   54: aload_3
    //   55: ldc 236
    //   57: lconst_0
    //   58: invokevirtual 240	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   61: lstore 13
    //   63: aload_3
    //   64: ldc 242
    //   66: invokevirtual 245	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   69: pop2
    //   70: aload_3
    //   71: ldc 247
    //   73: invokevirtual 194	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   76: pop
    //   77: new 249	com/tencent/mobileqq/data/NearbyPeopleCard
    //   80: dup
    //   81: invokespecial 263	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   84: astore 16
    //   86: aload_2
    //   87: getfield 1237	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   90: astore 17
    //   92: aload 16
    //   94: aload_2
    //   95: getfield 1240	SummaryCard/RespSummaryCard:lUIN	J
    //   98: invokestatic 256	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   101: putfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   104: lload 13
    //   106: lconst_0
    //   107: lcmp
    //   108: ifle +13 -> 121
    //   111: aload 16
    //   113: lload 13
    //   115: putfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   118: goto +13 -> 131
    //   121: aload 16
    //   123: aload 17
    //   125: getfield 1245	SummaryCard/DateCard:lTinyId	J
    //   128: putfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   131: aload 16
    //   133: aload_3
    //   134: ldc 242
    //   136: invokevirtual 245	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   139: putfield 349	com/tencent/mobileqq/data/NearbyPeopleCard:nowId	J
    //   142: aload 16
    //   144: aload_3
    //   145: ldc 247
    //   147: invokevirtual 194	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   150: putfield 351	com/tencent/mobileqq/data/NearbyPeopleCard:nowUserType	I
    //   153: iload 5
    //   155: ifeq +45 -> 200
    //   158: aload 16
    //   160: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   163: aload_0
    //   164: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   167: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   170: invokevirtual 1248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq +6 -> 179
    //   176: goto +24 -> 200
    //   179: aload 16
    //   181: aload_2
    //   182: getfield 1251	SummaryCard/RespSummaryCard:iVoteCount	I
    //   185: putfield 741	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   188: aload 16
    //   190: aload_2
    //   191: getfield 1254	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   194: putfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   197: goto +89 -> 286
    //   200: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +56 -> 259
    //   206: new 68	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   213: astore_3
    //   214: aload_3
    //   215: ldc_w 1256
    //   218: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_3
    //   223: aload_2
    //   224: getfield 1251	SummaryCard/RespSummaryCard:iVoteCount	I
    //   227: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_3
    //   232: ldc_w 751
    //   235: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_3
    //   240: aload_2
    //   241: getfield 1254	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   244: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: ldc_w 639
    //   251: iconst_2
    //   252: aload_3
    //   253: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload 16
    //   261: aload_2
    //   262: getfield 1251	SummaryCard/RespSummaryCard:iVoteCount	I
    //   265: putfield 741	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   268: aload 16
    //   270: aload_2
    //   271: getfield 1254	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   274: putfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   277: aload 16
    //   279: aload_2
    //   280: getfield 1260	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   283: putfield 1263	com/tencent/mobileqq/data/NearbyPeopleCard:praiseList	Ljava/util/List;
    //   286: aload 16
    //   288: aload_2
    //   289: getfield 1266	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   292: putfield 354	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   295: aload 16
    //   297: aload_2
    //   298: getfield 1269	SummaryCard/RespSummaryCard:vRichSign	[B
    //   301: putfield 370	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   304: aload 16
    //   306: aload 17
    //   308: getfield 1272	SummaryCard/DateCard:bMarriage	B
    //   311: putfield 431	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   314: aload 16
    //   316: aload_2
    //   317: getfield 1275	SummaryCard/RespSummaryCard:bSex	B
    //   320: putfield 374	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   323: aload 16
    //   325: aload_2
    //   326: getfield 1278	SummaryCard/RespSummaryCard:bAge	B
    //   329: putfield 383	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   332: aload 16
    //   334: aload_2
    //   335: getfield 1281	SummaryCard/RespSummaryCard:iBirthday	I
    //   338: putfield 392	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   341: aload 16
    //   343: aload 17
    //   345: getfield 1284	SummaryCard/DateCard:uProfession	J
    //   348: l2i
    //   349: putfield 398	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   352: aload 16
    //   354: aload 17
    //   356: getfield 1287	SummaryCard/DateCard:bConstellation	B
    //   359: putfield 403	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   362: aload 16
    //   364: aload 17
    //   366: getfield 1290	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   369: putfield 408	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   372: aload 16
    //   374: aload 17
    //   376: getfield 1293	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   379: putfield 414	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   382: aload 16
    //   384: aload_2
    //   385: getfield 1296	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   388: putfield 1299	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   391: aload 16
    //   393: aload 17
    //   395: getfield 1302	SummaryCard/DateCard:vDateInfo	[B
    //   398: putfield 1305	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   401: aload 16
    //   403: aload 17
    //   405: getfield 1308	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   408: putfield 419	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   411: aload 16
    //   413: aload 17
    //   415: getfield 1311	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   418: putfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   421: aload 16
    //   423: aload 17
    //   425: getfield 1314	SummaryCard/DateCard:uHomeCountry	J
    //   428: invokestatic 450	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   431: putfield 453	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   434: aload 16
    //   436: aload 17
    //   438: getfield 1317	SummaryCard/DateCard:uHomeProvince	J
    //   441: invokestatic 450	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   444: putfield 459	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   447: aload 16
    //   449: aload 17
    //   451: getfield 1320	SummaryCard/DateCard:uHomeCity	J
    //   454: invokestatic 450	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   457: putfield 465	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   460: aload 16
    //   462: aload 17
    //   464: getfield 1323	SummaryCard/DateCard:uHomeZone	J
    //   467: invokestatic 450	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   470: putfield 471	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   473: aload 16
    //   475: aload_2
    //   476: getfield 1326	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   479: putfield 1329	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   482: aload 16
    //   484: aload_2
    //   485: getfield 1332	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   488: putfield 1335	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   491: aload 16
    //   493: aload_2
    //   494: getfield 1338	SummaryCard/RespSummaryCard:ulShowControl	J
    //   497: putfield 1341	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   500: aload 16
    //   502: aload_2
    //   503: getfield 1344	SummaryCard/RespSummaryCard:lUserFlag	J
    //   506: putfield 652	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   509: aload 16
    //   511: aload_2
    //   512: getfield 1347	SummaryCard/RespSummaryCard:vSeed	[B
    //   515: putfield 1348	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   518: aload 16
    //   520: aload_2
    //   521: getfield 1351	SummaryCard/RespSummaryCard:lCacheControl	J
    //   524: invokevirtual 1354	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   527: aload 16
    //   529: invokestatic 476	java/lang/System:currentTimeMillis	()J
    //   532: putfield 479	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   535: aload 16
    //   537: iload 5
    //   539: putfield 541	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   542: aload 16
    //   544: aload_2
    //   545: getfield 1355	SummaryCard/RespSummaryCard:vTempChatSig	[B
    //   548: putfield 485	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   551: aload 16
    //   553: getfield 485	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   556: ifnull +112 -> 668
    //   559: aload 16
    //   561: getfield 485	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   564: arraylength
    //   565: ifne +62 -> 627
    //   568: aload_0
    //   569: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   572: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   575: aload 16
    //   577: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   580: invokestatic 1360	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   583: ifne +44 -> 627
    //   586: aload_0
    //   587: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   590: astore_3
    //   591: aload_3
    //   592: ldc_w 543
    //   595: ldc_w 545
    //   598: ldc_w 547
    //   601: ldc_w 549
    //   604: ldc_w 551
    //   607: iconst_0
    //   608: iconst_0
    //   609: aload_3
    //   610: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   613: aload 16
    //   615: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   618: ldc_w 547
    //   621: ldc_w 547
    //   624: invokestatic 556	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   627: aload_0
    //   628: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   631: invokevirtual 560	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   634: aload 16
    //   636: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   639: invokevirtual 566	com/tencent/mobileqq/service/message/MessageCache:r	(Ljava/lang/String;)[B
    //   642: ifnonnull +67 -> 709
    //   645: aload_0
    //   646: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   649: invokevirtual 560	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   652: aload 16
    //   654: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   657: aload 16
    //   659: getfield 485	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   662: invokevirtual 570	com/tencent/mobileqq/service/message/MessageCache:g	(Ljava/lang/String;[B)V
    //   665: goto +44 -> 709
    //   668: aload_0
    //   669: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   672: astore_3
    //   673: aload_3
    //   674: ldc_w 543
    //   677: ldc_w 545
    //   680: ldc_w 547
    //   683: ldc_w 549
    //   686: ldc_w 572
    //   689: iconst_0
    //   690: iconst_0
    //   691: aload_3
    //   692: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   695: aload 16
    //   697: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   700: ldc_w 547
    //   703: ldc_w 547
    //   706: invokestatic 556	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   709: aload 16
    //   711: aload 17
    //   713: getfield 1363	SummaryCard/DateCard:uSchoolId	J
    //   716: putfield 437	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   719: aload 16
    //   721: aload 17
    //   723: getfield 1366	SummaryCard/DateCard:vGroupList	[B
    //   726: putfield 1367	com/tencent/mobileqq/data/NearbyPeopleCard:vGroupList	[B
    //   729: aload 16
    //   731: aload 17
    //   733: getfield 1370	SummaryCard/DateCard:vNearbyInfo	[B
    //   736: putfield 443	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   739: aload 16
    //   741: aload 17
    //   743: getfield 1373	SummaryCard/DateCard:vActivityList	[B
    //   746: putfield 1374	com/tencent/mobileqq/data/NearbyPeopleCard:vActivityList	[B
    //   749: aload 16
    //   751: aload_2
    //   752: getfield 1344	SummaryCard/RespSummaryCard:lUserFlag	J
    //   755: putfield 1375	com/tencent/mobileqq/data/NearbyPeopleCard:lUserFlag	J
    //   758: aload 16
    //   760: aload_2
    //   761: getfield 1378	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   764: putfield 1379	com/tencent/mobileqq/data/NearbyPeopleCard:strRemark	Ljava/lang/String;
    //   767: aload_2
    //   768: getfield 1383	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   771: ifnull +15 -> 786
    //   774: aload 16
    //   776: aload_2
    //   777: getfield 1383	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   780: getfield 1388	SummaryCard/HeartInfo:iHeartCount	I
    //   783: putfield 1391	com/tencent/mobileqq/data/NearbyPeopleCard:mHeartNum	I
    //   786: aload_2
    //   787: getfield 1395	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   790: ifnull +30 -> 820
    //   793: aload 16
    //   795: aload_2
    //   796: getfield 1395	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   799: getfield 1400	SummaryCard/TNearbyGodInfo:strJumpUrl	Ljava/lang/String;
    //   802: putfield 1403	com/tencent/mobileqq/data/NearbyPeopleCard:strGodJumpUrl	Ljava/lang/String;
    //   805: aload 16
    //   807: aload_2
    //   808: getfield 1395	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   811: getfield 1406	SummaryCard/TNearbyGodInfo:iIsGodFlag	I
    //   814: putfield 1407	com/tencent/mobileqq/data/NearbyPeopleCard:iIsGodFlag	I
    //   817: goto +42 -> 859
    //   820: invokestatic 635	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   823: ifeq +36 -> 859
    //   826: new 68	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   833: astore_3
    //   834: aload_3
    //   835: ldc_w 1409
    //   838: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload_3
    //   843: aconst_null
    //   844: invokevirtual 1412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: ldc_w 639
    //   851: iconst_2
    //   852: aload_3
    //   853: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   856: invokestatic 985	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   859: aload_2
    //   860: getfield 1415	SummaryCard/RespSummaryCard:vCommLabel	[B
    //   863: astore 18
    //   865: ldc 77
    //   867: astore_3
    //   868: aload 18
    //   870: ifnull +201 -> 1071
    //   873: aload 16
    //   875: new 577	java/util/ArrayList
    //   878: dup
    //   879: invokespecial 578	java/util/ArrayList:<init>	()V
    //   882: putfield 582	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   885: new 584	appoint/define/appoint_define$CommonLabel
    //   888: dup
    //   889: invokespecial 585	appoint/define/appoint_define$CommonLabel:<init>	()V
    //   892: astore 19
    //   894: aload 19
    //   896: aload 18
    //   898: invokevirtual 589	appoint/define/appoint_define$CommonLabel:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   901: pop
    //   902: aload 19
    //   904: getfield 593	appoint/define/appoint_define$CommonLabel:rpt_interst_name	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   907: invokevirtual 598	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   910: astore 18
    //   912: aload 19
    //   914: getfield 601	appoint/define/appoint_define$CommonLabel:rpt_interst_type	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   917: invokevirtual 598	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   920: astore 20
    //   922: new 603	org/json/JSONArray
    //   925: dup
    //   926: invokespecial 604	org/json/JSONArray:<init>	()V
    //   929: astore 19
    //   931: aload 18
    //   933: invokeinterface 609 1 0
    //   938: aload 20
    //   940: invokeinterface 609 1 0
    //   945: if_icmpne +65 -> 1010
    //   948: iconst_0
    //   949: istore 6
    //   951: iload 6
    //   953: aload 18
    //   955: invokeinterface 609 1 0
    //   960: if_icmpge +50 -> 1010
    //   963: aload 18
    //   965: iload 6
    //   967: invokeinterface 612 2 0
    //   972: checkcast 138	com/tencent/mobileqq/pb/ByteStringMicro
    //   975: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   978: astore 20
    //   980: aload 16
    //   982: getfield 582	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   985: aload 20
    //   987: invokeinterface 619 2 0
    //   992: pop
    //   993: aload 19
    //   995: aload 20
    //   997: invokevirtual 623	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1000: pop
    //   1001: iload 6
    //   1003: iconst_1
    //   1004: iadd
    //   1005: istore 6
    //   1007: goto -56 -> 951
    //   1010: aload 16
    //   1012: aload 19
    //   1014: invokevirtual 624	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1017: putfield 627	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1020: goto +51 -> 1071
    //   1023: astore 18
    //   1025: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1028: ifeq +43 -> 1071
    //   1031: new 68	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1038: astore 19
    //   1040: aload 19
    //   1042: ldc_w 629
    //   1045: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 19
    //   1051: aload 18
    //   1053: invokevirtual 632	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1056: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: ldc 77
    //   1062: iconst_2
    //   1063: aload 19
    //   1065: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1068: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1071: invokestatic 635	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1074: ifeq +44 -> 1118
    //   1077: new 68	java/lang/StringBuilder
    //   1080: dup
    //   1081: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1084: astore 18
    //   1086: aload 18
    //   1088: ldc_w 637
    //   1091: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: pop
    //   1095: aload 18
    //   1097: aload 17
    //   1099: getfield 1363	SummaryCard/DateCard:uSchoolId	J
    //   1102: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: ldc_w 639
    //   1109: iconst_4
    //   1110: aload 18
    //   1112: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1118: aload 16
    //   1120: aload_2
    //   1121: getfield 1418	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1124: putfield 1419	com/tencent/mobileqq/data/NearbyPeopleCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1127: aload 16
    //   1129: aload_2
    //   1130: getfield 1423	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1133: putfield 1424	com/tencent/mobileqq/data/NearbyPeopleCard:bHaveVotedCnt	S
    //   1136: aload 16
    //   1138: aload_2
    //   1139: getfield 1427	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1142: putfield 1428	com/tencent/mobileqq/data/NearbyPeopleCard:bAvailVoteCnt	S
    //   1145: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1148: ifeq +80 -> 1228
    //   1151: new 68	java/lang/StringBuilder
    //   1154: dup
    //   1155: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1158: astore 18
    //   1160: aload 18
    //   1162: ldc_w 1430
    //   1165: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload 18
    //   1171: aload_2
    //   1172: getfield 1418	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1175: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload 18
    //   1181: ldc_w 1432
    //   1184: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: pop
    //   1188: aload 18
    //   1190: aload_2
    //   1191: getfield 1423	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1194: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1197: pop
    //   1198: aload 18
    //   1200: ldc_w 1434
    //   1203: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload 18
    //   1209: aload_2
    //   1210: getfield 1427	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1213: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1216: pop
    //   1217: ldc 77
    //   1219: iconst_2
    //   1220: aload 18
    //   1222: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1228: aload_2
    //   1229: getfield 1438	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1232: ifnull +54 -> 1286
    //   1235: aload 16
    //   1237: aload_2
    //   1238: getfield 1438	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1241: getfield 1443	SummaryCard/PanSocialInfo:uCharm	J
    //   1244: putfield 1446	com/tencent/mobileqq/data/NearbyPeopleCard:charm	J
    //   1247: aload 16
    //   1249: aload_2
    //   1250: getfield 1438	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1253: getfield 1449	SummaryCard/PanSocialInfo:uCharmLevel	J
    //   1256: l2i
    //   1257: putfield 1058	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   1260: aload 16
    //   1262: aload_2
    //   1263: getfield 1438	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1266: getfield 1452	SummaryCard/PanSocialInfo:uNextLevelCharm	J
    //   1269: l2i
    //   1270: putfield 1455	com/tencent/mobileqq/data/NearbyPeopleCard:nextThreshold	I
    //   1273: aload 16
    //   1275: aload_2
    //   1276: getfield 1438	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1279: getfield 1458	SummaryCard/PanSocialInfo:uCurLevelCharm	J
    //   1282: l2i
    //   1283: putfield 1461	com/tencent/mobileqq/data/NearbyPeopleCard:curThreshold	I
    //   1286: iload 5
    //   1288: ifeq +29 -> 1317
    //   1291: aload 16
    //   1293: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1296: aload_0
    //   1297: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1300: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1303: invokevirtual 1248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1306: ifeq +6 -> 1312
    //   1309: goto +8 -> 1317
    //   1312: iconst_0
    //   1313: istore_1
    //   1314: goto +5 -> 1319
    //   1317: iconst_1
    //   1318: istore_1
    //   1319: aload 16
    //   1321: aload 17
    //   1323: getfield 1464	SummaryCard/DateCard:vFaces	[B
    //   1326: aload_2
    //   1327: getfield 1468	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   1330: iload_1
    //   1331: invokevirtual 649	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1334: pop
    //   1335: aload 16
    //   1337: aload_2
    //   1338: getfield 1472	SummaryCard/RespSummaryCard:stQiqiVideoInfo	LSummaryCard/QiqiVideoInfo;
    //   1341: getfield 1477	SummaryCard/QiqiVideoInfo:uRoomid	J
    //   1344: putfield 1478	com/tencent/mobileqq/data/NearbyPeopleCard:uRoomid	J
    //   1347: aload_2
    //   1348: getfield 1481	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1351: ifne +12 -> 1363
    //   1354: aload 16
    //   1356: iconst_1
    //   1357: putfield 1484	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1360: goto +9 -> 1369
    //   1363: aload 16
    //   1365: iconst_0
    //   1366: putfield 1484	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1369: aload 4
    //   1371: ifnull +13 -> 1384
    //   1374: aload 16
    //   1376: aload 4
    //   1378: getfield 1489	SummaryCard/RespHead:vCookies	[B
    //   1381: putfield 1490	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   1384: aload 16
    //   1386: getfield 652	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1389: ldc2_w 653
    //   1392: land
    //   1393: lconst_0
    //   1394: lcmp
    //   1395: ifeq +12 -> 1407
    //   1398: aload 16
    //   1400: iconst_1
    //   1401: putfield 657	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1404: goto +9 -> 1413
    //   1407: aload 16
    //   1409: iconst_0
    //   1410: putfield 657	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1413: aload 16
    //   1415: getfield 652	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1418: ldc2_w 658
    //   1421: land
    //   1422: lconst_0
    //   1423: lcmp
    //   1424: ifeq +12 -> 1436
    //   1427: aload 16
    //   1429: iconst_1
    //   1430: putfield 662	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1433: goto +9 -> 1442
    //   1436: aload 16
    //   1438: iconst_0
    //   1439: putfield 662	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1442: aload 16
    //   1444: invokevirtual 665	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1447: istore_1
    //   1448: ldc_w 547
    //   1451: astore 23
    //   1453: iload_1
    //   1454: ifne +168 -> 1622
    //   1457: aload 16
    //   1459: ldc_w 547
    //   1462: putfield 668	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1465: aload 16
    //   1467: ldc_w 547
    //   1470: putfield 671	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1473: aload 16
    //   1475: ldc_w 547
    //   1478: putfield 674	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1481: aload_2
    //   1482: getfield 1494	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1485: astore 4
    //   1487: aload 4
    //   1489: ifnull +133 -> 1622
    //   1492: aload 4
    //   1494: getfield 1499	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1497: ifnull +125 -> 1622
    //   1500: aload 4
    //   1502: getfield 1499	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1505: invokevirtual 1500	java/util/ArrayList:size	()I
    //   1508: ifle +114 -> 1622
    //   1511: iconst_0
    //   1512: istore 6
    //   1514: iload 6
    //   1516: aload 4
    //   1518: getfield 1499	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1521: invokevirtual 1500	java/util/ArrayList:size	()I
    //   1524: if_icmpge +98 -> 1622
    //   1527: iload 6
    //   1529: ifne +27 -> 1556
    //   1532: aload 16
    //   1534: aload 4
    //   1536: getfield 1499	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1539: iload 6
    //   1541: invokevirtual 1501	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1544: checkcast 1503	SummaryCard/PhotoInfo
    //   1547: getfield 1506	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1550: putfield 668	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1553: goto +60 -> 1613
    //   1556: iload 6
    //   1558: iconst_1
    //   1559: if_icmpne +27 -> 1586
    //   1562: aload 16
    //   1564: aload 4
    //   1566: getfield 1499	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1569: iload 6
    //   1571: invokevirtual 1501	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1574: checkcast 1503	SummaryCard/PhotoInfo
    //   1577: getfield 1506	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1580: putfield 671	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1583: goto +30 -> 1613
    //   1586: iload 6
    //   1588: iconst_2
    //   1589: if_icmpne +24 -> 1613
    //   1592: aload 16
    //   1594: aload 4
    //   1596: getfield 1499	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1599: iload 6
    //   1601: invokevirtual 1501	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1604: checkcast 1503	SummaryCard/PhotoInfo
    //   1607: getfield 1506	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1610: putfield 674	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1613: iload 6
    //   1615: iconst_1
    //   1616: iadd
    //   1617: istore 6
    //   1619: goto -105 -> 1514
    //   1622: aload_2
    //   1623: getfield 1438	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1626: astore 4
    //   1628: aload 4
    //   1630: ifnull +38 -> 1668
    //   1633: aload 4
    //   1635: getfield 1509	SummaryCard/PanSocialInfo:uCharmRank	J
    //   1638: lconst_1
    //   1639: lcmp
    //   1640: ifne +12 -> 1652
    //   1643: aload 16
    //   1645: iconst_1
    //   1646: putfield 1512	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1649: goto +9 -> 1658
    //   1652: aload 16
    //   1654: iconst_0
    //   1655: putfield 1512	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1658: aload 16
    //   1660: aload 4
    //   1662: getfield 1515	SummaryCard/PanSocialInfo:strLevelType	Ljava/lang/String;
    //   1665: putfield 1516	com/tencent/mobileqq/data/NearbyPeopleCard:strLevelType	Ljava/lang/String;
    //   1668: aload_2
    //   1669: getfield 1519	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1672: ifnull +29 -> 1701
    //   1675: aload 16
    //   1677: aload_0
    //   1678: aload_2
    //   1679: getfield 1519	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1682: ldc_w 1521
    //   1685: new 1523	GameCenter/RespLastGameInfo
    //   1688: dup
    //   1689: invokespecial 1524	GameCenter/RespLastGameInfo:<init>	()V
    //   1692: invokevirtual 1528	com/tencent/mobileqq/nearby/business/NearbyCardHandler:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1695: checkcast 1523	GameCenter/RespLastGameInfo
    //   1698: invokevirtual 1532	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1701: aload_2
    //   1702: getfield 1438	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1705: astore 4
    //   1707: aload 4
    //   1709: ifnull +14 -> 1723
    //   1712: aload 16
    //   1714: aload 4
    //   1716: getfield 1535	SummaryCard/PanSocialInfo:uChatflag	J
    //   1719: l2i
    //   1720: putfield 1538	com/tencent/mobileqq/data/NearbyPeopleCard:sayHelloFlag	I
    //   1723: new 577	java/util/ArrayList
    //   1726: dup
    //   1727: invokespecial 578	java/util/ArrayList:<init>	()V
    //   1730: astore 29
    //   1732: aload 23
    //   1734: astore 18
    //   1736: aload 15
    //   1738: astore 22
    //   1740: iload 12
    //   1742: istore 11
    //   1744: iload 5
    //   1746: istore 6
    //   1748: aload 16
    //   1750: astore 20
    //   1752: aload_2
    //   1753: astore 21
    //   1755: aload 27
    //   1757: astore 19
    //   1759: aload_3
    //   1760: astore 17
    //   1762: aload_2
    //   1763: getfield 1541	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1766: ifnull +1759 -> 3525
    //   1769: aload 23
    //   1771: astore 18
    //   1773: aload 15
    //   1775: astore 22
    //   1777: iload 12
    //   1779: istore 11
    //   1781: iload 5
    //   1783: istore 6
    //   1785: aload 16
    //   1787: astore 20
    //   1789: aload_2
    //   1790: astore 21
    //   1792: aload 27
    //   1794: astore 19
    //   1796: aload_3
    //   1797: astore 17
    //   1799: aload_2
    //   1800: getfield 1541	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1803: invokevirtual 1500	java/util/ArrayList:size	()I
    //   1806: ifle +1719 -> 3525
    //   1809: iconst_0
    //   1810: istore 8
    //   1812: aload_3
    //   1813: astore 4
    //   1815: aload 16
    //   1817: astore_3
    //   1818: iload 12
    //   1820: istore_1
    //   1821: aload 23
    //   1823: astore 16
    //   1825: aload 16
    //   1827: astore 18
    //   1829: aload 15
    //   1831: astore 22
    //   1833: iload_1
    //   1834: istore 11
    //   1836: iload 5
    //   1838: istore 6
    //   1840: aload_3
    //   1841: astore 20
    //   1843: aload_2
    //   1844: astore 21
    //   1846: aload 27
    //   1848: astore 19
    //   1850: aload 4
    //   1852: astore 17
    //   1854: iload 8
    //   1856: aload_2
    //   1857: getfield 1541	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1860: invokevirtual 1500	java/util/ArrayList:size	()I
    //   1863: if_icmpge +1662 -> 3525
    //   1866: aload_2
    //   1867: getfield 1541	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1870: iload 8
    //   1872: invokevirtual 1501	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1875: checkcast 1542	[B
    //   1878: astore 18
    //   1880: aload 18
    //   1882: ifnonnull +9 -> 1891
    //   1885: iconst_0
    //   1886: istore 6
    //   1888: goto +8 -> 1896
    //   1891: aload 18
    //   1893: arraylength
    //   1894: istore 6
    //   1896: iload 6
    //   1898: bipush 10
    //   1900: if_icmpgt +6 -> 1906
    //   1903: goto +1569 -> 3472
    //   1906: aload 18
    //   1908: iconst_1
    //   1909: invokestatic 1548	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   1912: l2i
    //   1913: istore 7
    //   1915: aload 18
    //   1917: iconst_5
    //   1918: invokestatic 1548	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   1921: pop2
    //   1922: iload 7
    //   1924: ifle +1548 -> 3472
    //   1927: bipush 9
    //   1929: iload 7
    //   1931: iadd
    //   1932: iload 6
    //   1934: if_icmplt +6 -> 1940
    //   1937: goto +1535 -> 3472
    //   1940: iload 7
    //   1942: newarray byte
    //   1944: astore 17
    //   1946: aload 17
    //   1948: iconst_0
    //   1949: aload 18
    //   1951: bipush 9
    //   1953: iload 7
    //   1955: invokestatic 1552	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   1958: new 1554	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   1961: dup
    //   1962: invokespecial 1555	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   1965: astore 30
    //   1967: aload 30
    //   1969: aload 17
    //   1971: invokevirtual 1556	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1974: pop
    //   1975: aload 30
    //   1977: getfield 1559	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1980: invokevirtual 381	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1983: istore 10
    //   1985: new 1561	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry
    //   1988: dup
    //   1989: invokespecial 1562	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:<init>	()V
    //   1992: astore 24
    //   1994: iload 10
    //   1996: ifne +5232 -> 7228
    //   1999: aload 24
    //   2001: aload 30
    //   2003: getfield 1566	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2006: getfield 1571	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2009: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2012: putfield 1573	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:strName	Ljava/lang/String;
    //   2015: aload 24
    //   2017: aload 30
    //   2019: getfield 1566	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2022: getfield 1576	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2025: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2028: putfield 1578	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:strServiceUrl	Ljava/lang/String;
    //   2031: aload 24
    //   2033: aload 30
    //   2035: getfield 1581	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2038: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2041: putfield 1584	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:serviceType	I
    //   2044: new 577	java/util/ArrayList
    //   2047: dup
    //   2048: invokespecial 578	java/util/ArrayList:<init>	()V
    //   2051: astore 31
    //   2053: iconst_0
    //   2054: istore 7
    //   2056: aload 4
    //   2058: astore 17
    //   2060: aload 16
    //   2062: astore 4
    //   2064: iload 7
    //   2066: aload 30
    //   2068: getfield 1566	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2071: getfield 1587	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2074: invokevirtual 1588	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2077: if_icmpge +873 -> 2950
    //   2080: aload 30
    //   2082: getfield 1566	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2085: getfield 1587	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2088: iload 7
    //   2090: invokevirtual 1591	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2093: checkcast 1593	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   2096: astore 23
    //   2098: new 1595	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem
    //   2101: dup
    //   2102: invokespecial 1596	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:<init>	()V
    //   2105: astore 25
    //   2107: aload 25
    //   2109: aload 23
    //   2111: getfield 1599	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2114: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2117: putfield 1601	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strTitle	Ljava/lang/String;
    //   2120: aload 25
    //   2122: aload 23
    //   2124: getfield 1604	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2127: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2130: putfield 1606	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strCoverUrl	Ljava/lang/String;
    //   2133: aload 25
    //   2135: aload 23
    //   2137: getfield 1609	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2140: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2143: putfield 1611	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strJmpUrl	Ljava/lang/String;
    //   2146: aload 25
    //   2148: aload 23
    //   2150: getfield 1614	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2153: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2156: putfield 1616	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strSubInfo	Ljava/lang/String;
    //   2159: aload 25
    //   2161: aload 23
    //   2163: getfield 1619	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2166: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2169: putfield 1621	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strDesc	Ljava/lang/String;
    //   2172: aload 25
    //   2174: aload 23
    //   2176: getfield 1624	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2179: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2182: putfield 1626	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strTitleIconUrl	Ljava/lang/String;
    //   2185: aload 23
    //   2187: getfield 1629	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2190: astore 19
    //   2192: aload 4
    //   2194: astore 21
    //   2196: iload 5
    //   2198: istore 6
    //   2200: aload_3
    //   2201: astore 18
    //   2203: aload_2
    //   2204: astore 16
    //   2206: aload 25
    //   2208: aload 19
    //   2210: invokevirtual 202	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2213: putfield 1632	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:groupCode	J
    //   2216: iload 5
    //   2218: istore 6
    //   2220: aload_3
    //   2221: astore 18
    //   2223: aload_2
    //   2224: astore 16
    //   2226: aload 25
    //   2228: aload 24
    //   2230: getfield 1584	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:serviceType	I
    //   2233: putfield 1633	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:serviceType	I
    //   2236: iload 5
    //   2238: istore 6
    //   2240: aload_3
    //   2241: astore 18
    //   2243: aload_2
    //   2244: astore 16
    //   2246: aload 23
    //   2248: getfield 1636	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2251: invokevirtual 1588	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2254: ifle +4895 -> 7149
    //   2257: iload 5
    //   2259: istore 6
    //   2261: aload_3
    //   2262: astore 18
    //   2264: aload_2
    //   2265: astore 16
    //   2267: new 577	java/util/ArrayList
    //   2270: dup
    //   2271: invokespecial 578	java/util/ArrayList:<init>	()V
    //   2274: astore 26
    //   2276: iconst_0
    //   2277: istore 9
    //   2279: iload 5
    //   2281: istore 6
    //   2283: aload_3
    //   2284: astore 18
    //   2286: aload_2
    //   2287: astore 16
    //   2289: iload 9
    //   2291: aload 23
    //   2293: getfield 1636	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2296: invokevirtual 1588	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2299: if_icmpge +556 -> 2855
    //   2302: iload 5
    //   2304: istore 6
    //   2306: aload_3
    //   2307: astore 18
    //   2309: aload_2
    //   2310: astore 16
    //   2312: aload 23
    //   2314: getfield 1636	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2317: iload 9
    //   2319: invokevirtual 1591	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2322: checkcast 1638	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   2325: astore 32
    //   2327: iload 5
    //   2329: istore 6
    //   2331: aload_3
    //   2332: astore 18
    //   2334: aload_2
    //   2335: astore 16
    //   2337: new 1640	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel
    //   2340: dup
    //   2341: invokespecial 1641	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:<init>	()V
    //   2344: astore 33
    //   2346: iload 5
    //   2348: istore 6
    //   2350: aload 33
    //   2352: aload 32
    //   2354: getfield 1644	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2357: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2360: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2363: putfield 1647	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:strWording	Ljava/lang/String;
    //   2366: aload 32
    //   2368: getfield 1650	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2371: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2374: istore 5
    //   2376: aload_3
    //   2377: astore 20
    //   2379: aload_2
    //   2380: astore 22
    //   2382: iload 5
    //   2384: i2l
    //   2385: lstore 13
    //   2387: aload 15
    //   2389: astore 19
    //   2391: aload 17
    //   2393: astore 18
    //   2395: aload 21
    //   2397: astore 16
    //   2399: iload 6
    //   2401: istore 5
    //   2403: aload 22
    //   2405: astore_3
    //   2406: aload 20
    //   2408: astore_2
    //   2409: aload 33
    //   2411: lload 13
    //   2413: putfield 1653	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:type	J
    //   2416: aload 15
    //   2418: astore 19
    //   2420: aload 17
    //   2422: astore 18
    //   2424: aload 21
    //   2426: astore 16
    //   2428: iload 6
    //   2430: istore 5
    //   2432: aload 22
    //   2434: astore_3
    //   2435: aload 20
    //   2437: astore_2
    //   2438: aload 33
    //   2440: aload 32
    //   2442: getfield 1656	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2445: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2448: i2l
    //   2449: putfield 1659	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:attr	J
    //   2452: aload 15
    //   2454: astore 19
    //   2456: aload 17
    //   2458: astore 18
    //   2460: aload 21
    //   2462: astore 16
    //   2464: iload 6
    //   2466: istore 5
    //   2468: aload 22
    //   2470: astore_3
    //   2471: aload 20
    //   2473: astore_2
    //   2474: new 1661	com/tencent/mobileqq/profilecard/entity/ProfileColor
    //   2477: dup
    //   2478: invokespecial 1662	com/tencent/mobileqq/profilecard/entity/ProfileColor:<init>	()V
    //   2481: astore 34
    //   2483: aload 15
    //   2485: astore 19
    //   2487: aload 17
    //   2489: astore 18
    //   2491: aload 21
    //   2493: astore 16
    //   2495: iload 6
    //   2497: istore 5
    //   2499: aload 22
    //   2501: astore_3
    //   2502: aload 20
    //   2504: astore_2
    //   2505: aload 34
    //   2507: aload 32
    //   2509: getfield 1666	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2512: getfield 1671	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2515: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2518: i2l
    //   2519: putfield 1674	com/tencent/mobileqq/profilecard/entity/ProfileColor:red	J
    //   2522: aload 15
    //   2524: astore 19
    //   2526: aload 17
    //   2528: astore 18
    //   2530: aload 21
    //   2532: astore 16
    //   2534: iload 6
    //   2536: istore 5
    //   2538: aload 22
    //   2540: astore_3
    //   2541: aload 20
    //   2543: astore_2
    //   2544: aload 34
    //   2546: aload 32
    //   2548: getfield 1666	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2551: getfield 1677	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2554: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2557: i2l
    //   2558: putfield 1680	com/tencent/mobileqq/profilecard/entity/ProfileColor:green	J
    //   2561: aload 15
    //   2563: astore 19
    //   2565: aload 17
    //   2567: astore 18
    //   2569: aload 21
    //   2571: astore 16
    //   2573: iload 6
    //   2575: istore 5
    //   2577: aload 22
    //   2579: astore_3
    //   2580: aload 20
    //   2582: astore_2
    //   2583: aload 34
    //   2585: aload 32
    //   2587: getfield 1666	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2590: getfield 1683	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2593: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2596: i2l
    //   2597: putfield 1686	com/tencent/mobileqq/profilecard/entity/ProfileColor:blue	J
    //   2600: aload 15
    //   2602: astore 19
    //   2604: aload 17
    //   2606: astore 18
    //   2608: aload 21
    //   2610: astore 16
    //   2612: iload 6
    //   2614: istore 5
    //   2616: aload 22
    //   2618: astore_3
    //   2619: aload 20
    //   2621: astore_2
    //   2622: aload 33
    //   2624: aload 34
    //   2626: putfield 1690	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:edgingColor	Lcom/tencent/mobileqq/profilecard/entity/ProfileColor;
    //   2629: aload 15
    //   2631: astore 19
    //   2633: aload 17
    //   2635: astore 18
    //   2637: aload 21
    //   2639: astore 16
    //   2641: iload 6
    //   2643: istore 5
    //   2645: aload 22
    //   2647: astore_3
    //   2648: aload 20
    //   2650: astore_2
    //   2651: new 1661	com/tencent/mobileqq/profilecard/entity/ProfileColor
    //   2654: dup
    //   2655: invokespecial 1662	com/tencent/mobileqq/profilecard/entity/ProfileColor:<init>	()V
    //   2658: astore 34
    //   2660: aload 15
    //   2662: astore 19
    //   2664: aload 17
    //   2666: astore 18
    //   2668: aload 21
    //   2670: astore 16
    //   2672: iload 6
    //   2674: istore 5
    //   2676: aload 22
    //   2678: astore_3
    //   2679: aload 20
    //   2681: astore_2
    //   2682: aload 34
    //   2684: aload 32
    //   2686: getfield 1693	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2689: getfield 1671	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2692: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2695: i2l
    //   2696: putfield 1674	com/tencent/mobileqq/profilecard/entity/ProfileColor:red	J
    //   2699: aload 15
    //   2701: astore 19
    //   2703: aload 17
    //   2705: astore 18
    //   2707: aload 21
    //   2709: astore 16
    //   2711: iload 6
    //   2713: istore 5
    //   2715: aload 22
    //   2717: astore_3
    //   2718: aload 20
    //   2720: astore_2
    //   2721: aload 34
    //   2723: aload 32
    //   2725: getfield 1693	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2728: getfield 1677	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2731: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2734: i2l
    //   2735: putfield 1680	com/tencent/mobileqq/profilecard/entity/ProfileColor:green	J
    //   2738: aload 15
    //   2740: astore 19
    //   2742: aload 17
    //   2744: astore 18
    //   2746: aload 21
    //   2748: astore 16
    //   2750: iload 6
    //   2752: istore 5
    //   2754: aload 22
    //   2756: astore_3
    //   2757: aload 20
    //   2759: astore_2
    //   2760: aload 34
    //   2762: aload 32
    //   2764: getfield 1693	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2767: getfield 1683	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2770: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2773: i2l
    //   2774: putfield 1686	com/tencent/mobileqq/profilecard/entity/ProfileColor:blue	J
    //   2777: aload 15
    //   2779: astore 19
    //   2781: aload 17
    //   2783: astore 18
    //   2785: aload 21
    //   2787: astore 16
    //   2789: iload 6
    //   2791: istore 5
    //   2793: aload 22
    //   2795: astore_3
    //   2796: aload 20
    //   2798: astore_2
    //   2799: aload 33
    //   2801: aload 34
    //   2803: putfield 1696	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:textColor	Lcom/tencent/mobileqq/profilecard/entity/ProfileColor;
    //   2806: aload 15
    //   2808: astore 19
    //   2810: aload 17
    //   2812: astore 18
    //   2814: aload 21
    //   2816: astore 16
    //   2818: iload 6
    //   2820: istore 5
    //   2822: aload 22
    //   2824: astore_3
    //   2825: aload 20
    //   2827: astore_2
    //   2828: aload 26
    //   2830: aload 33
    //   2832: invokevirtual 1697	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2835: pop
    //   2836: iload 9
    //   2838: iconst_1
    //   2839: iadd
    //   2840: istore 9
    //   2842: iload 6
    //   2844: istore 5
    //   2846: aload 22
    //   2848: astore_2
    //   2849: aload 20
    //   2851: astore_3
    //   2852: goto -573 -> 2279
    //   2855: iload 5
    //   2857: istore 6
    //   2859: aload_3
    //   2860: astore 20
    //   2862: aload_2
    //   2863: astore 4
    //   2865: aload 15
    //   2867: astore 19
    //   2869: aload 17
    //   2871: astore 18
    //   2873: aload 21
    //   2875: astore 16
    //   2877: iload 6
    //   2879: istore 5
    //   2881: aload 4
    //   2883: astore_3
    //   2884: aload 20
    //   2886: astore_2
    //   2887: aload 25
    //   2889: aload 26
    //   2891: putfield 1700	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:labels	Ljava/util/ArrayList;
    //   2894: goto +3 -> 2897
    //   2897: aload 15
    //   2899: astore 19
    //   2901: aload 17
    //   2903: astore 18
    //   2905: aload 21
    //   2907: astore 16
    //   2909: iload 6
    //   2911: istore 5
    //   2913: aload 4
    //   2915: astore_3
    //   2916: aload 20
    //   2918: astore_2
    //   2919: aload 31
    //   2921: aload 25
    //   2923: invokevirtual 1697	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2926: pop
    //   2927: iload 7
    //   2929: iconst_1
    //   2930: iadd
    //   2931: istore 7
    //   2933: iload 6
    //   2935: istore 5
    //   2937: aload 4
    //   2939: astore_2
    //   2940: aload 20
    //   2942: astore_3
    //   2943: aload 21
    //   2945: astore 4
    //   2947: goto -883 -> 2064
    //   2950: iload 5
    //   2952: istore 7
    //   2954: aload_3
    //   2955: astore 26
    //   2957: aload_2
    //   2958: astore 25
    //   2960: aload 15
    //   2962: astore 19
    //   2964: aload 17
    //   2966: astore 18
    //   2968: aload 4
    //   2970: astore 16
    //   2972: iload 7
    //   2974: istore 5
    //   2976: aload 25
    //   2978: astore_3
    //   2979: aload 26
    //   2981: astore_2
    //   2982: aload 24
    //   2984: aload 31
    //   2986: putfield 1703	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:sProfileSummaryHobbiesItem	Ljava/util/ArrayList;
    //   2989: aload 15
    //   2991: astore 20
    //   2993: aload 17
    //   2995: astore 22
    //   2997: aload 4
    //   2999: astore 23
    //   3001: goto +3 -> 3004
    //   3004: aload 20
    //   3006: astore 19
    //   3008: aload 22
    //   3010: astore 18
    //   3012: aload 23
    //   3014: astore 16
    //   3016: iload 7
    //   3018: istore 5
    //   3020: aload 25
    //   3022: astore_3
    //   3023: aload 26
    //   3025: astore_2
    //   3026: aload 29
    //   3028: aload 24
    //   3030: invokeinterface 619 2 0
    //   3035: pop
    //   3036: aload 20
    //   3038: astore 19
    //   3040: aload 22
    //   3042: astore 18
    //   3044: aload 23
    //   3046: astore 16
    //   3048: iload 7
    //   3050: istore 5
    //   3052: aload 25
    //   3054: astore_3
    //   3055: aload 26
    //   3057: astore_2
    //   3058: aload 20
    //   3060: astore 24
    //   3062: aload 22
    //   3064: astore 21
    //   3066: aload 23
    //   3068: astore 17
    //   3070: iload 7
    //   3072: istore 6
    //   3074: aload 25
    //   3076: astore 15
    //   3078: aload 26
    //   3080: astore 4
    //   3082: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3085: ifeq +409 -> 3494
    //   3088: aload 20
    //   3090: astore 19
    //   3092: aload 22
    //   3094: astore 18
    //   3096: aload 23
    //   3098: astore 16
    //   3100: iload 7
    //   3102: istore 5
    //   3104: aload 25
    //   3106: astore_3
    //   3107: aload 26
    //   3109: astore_2
    //   3110: new 68	java/lang/StringBuilder
    //   3113: dup
    //   3114: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3117: astore 4
    //   3119: aload 20
    //   3121: astore 19
    //   3123: aload 22
    //   3125: astore 18
    //   3127: aload 23
    //   3129: astore 16
    //   3131: iload 7
    //   3133: istore 5
    //   3135: aload 25
    //   3137: astore_3
    //   3138: aload 26
    //   3140: astore_2
    //   3141: aload 4
    //   3143: ldc_w 1705
    //   3146: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3149: pop
    //   3150: aload 20
    //   3152: astore 19
    //   3154: aload 22
    //   3156: astore 18
    //   3158: aload 23
    //   3160: astore 16
    //   3162: iload 7
    //   3164: istore 5
    //   3166: aload 25
    //   3168: astore_3
    //   3169: aload 26
    //   3171: astore_2
    //   3172: aload 4
    //   3174: aload 30
    //   3176: getfield 1581	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3179: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3182: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3185: pop
    //   3186: aload 20
    //   3188: astore 19
    //   3190: aload 22
    //   3192: astore 18
    //   3194: aload 23
    //   3196: astore 16
    //   3198: iload 7
    //   3200: istore 5
    //   3202: aload 25
    //   3204: astore_3
    //   3205: aload 26
    //   3207: astore_2
    //   3208: aload 4
    //   3210: ldc_w 1707
    //   3213: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3216: pop
    //   3217: aload 20
    //   3219: astore 19
    //   3221: aload 22
    //   3223: astore 18
    //   3225: aload 23
    //   3227: astore 16
    //   3229: iload 7
    //   3231: istore 5
    //   3233: aload 25
    //   3235: astore_3
    //   3236: aload 26
    //   3238: astore_2
    //   3239: aload 4
    //   3241: iload 10
    //   3243: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3246: pop
    //   3247: aload 20
    //   3249: astore 19
    //   3251: aload 22
    //   3253: astore 18
    //   3255: aload 23
    //   3257: astore 16
    //   3259: iload 7
    //   3261: istore 5
    //   3263: aload 25
    //   3265: astore_3
    //   3266: aload 26
    //   3268: astore_2
    //   3269: aload 4
    //   3271: ldc_w 1709
    //   3274: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3277: pop
    //   3278: aload 20
    //   3280: astore 19
    //   3282: aload 22
    //   3284: astore 18
    //   3286: aload 23
    //   3288: astore 16
    //   3290: iload 7
    //   3292: istore 5
    //   3294: aload 25
    //   3296: astore_3
    //   3297: aload 26
    //   3299: astore_2
    //   3300: aload 4
    //   3302: aload 30
    //   3304: getfield 1712	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3307: invokevirtual 1412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3310: pop
    //   3311: aload 20
    //   3313: astore 19
    //   3315: aload 22
    //   3317: astore 18
    //   3319: aload 23
    //   3321: astore 16
    //   3323: iload 7
    //   3325: istore 5
    //   3327: aload 25
    //   3329: astore_3
    //   3330: aload 26
    //   3332: astore_2
    //   3333: ldc_w 639
    //   3336: iconst_2
    //   3337: aload 4
    //   3339: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3342: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3345: aload 20
    //   3347: astore 24
    //   3349: aload 22
    //   3351: astore 21
    //   3353: aload 23
    //   3355: astore 17
    //   3357: iload 7
    //   3359: istore 6
    //   3361: aload 25
    //   3363: astore 15
    //   3365: aload 26
    //   3367: astore 4
    //   3369: goto +125 -> 3494
    //   3372: astore 20
    //   3374: goto +33 -> 3407
    //   3377: astore 18
    //   3379: aload 4
    //   3381: astore 17
    //   3383: aload 18
    //   3385: astore 4
    //   3387: aload_2
    //   3388: astore 18
    //   3390: aload_3
    //   3391: astore_2
    //   3392: aload 18
    //   3394: astore_3
    //   3395: aload 17
    //   3397: astore 18
    //   3399: aload 15
    //   3401: astore 19
    //   3403: aload 4
    //   3405: astore 20
    //   3407: aload 19
    //   3409: astore 24
    //   3411: aload 18
    //   3413: astore 21
    //   3415: aload 16
    //   3417: astore 17
    //   3419: iload 5
    //   3421: istore 6
    //   3423: aload_3
    //   3424: astore 15
    //   3426: aload_2
    //   3427: astore 4
    //   3429: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3432: ifeq +62 -> 3494
    //   3435: ldc_w 639
    //   3438: iconst_2
    //   3439: aload 20
    //   3441: invokevirtual 707	java/lang/Exception:toString	()Ljava/lang/String;
    //   3444: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3447: aload 19
    //   3449: astore 24
    //   3451: aload 18
    //   3453: astore 21
    //   3455: aload 16
    //   3457: astore 17
    //   3459: iload 5
    //   3461: istore 6
    //   3463: aload_3
    //   3464: astore 15
    //   3466: aload_2
    //   3467: astore 4
    //   3469: goto +25 -> 3494
    //   3472: aload 15
    //   3474: astore 24
    //   3476: aload 4
    //   3478: astore 21
    //   3480: aload_3
    //   3481: astore 4
    //   3483: aload_2
    //   3484: astore 15
    //   3486: iload 5
    //   3488: istore 6
    //   3490: aload 16
    //   3492: astore 17
    //   3494: iload 8
    //   3496: iconst_1
    //   3497: iadd
    //   3498: istore 8
    //   3500: aload 17
    //   3502: astore 16
    //   3504: iload 6
    //   3506: istore 5
    //   3508: aload 15
    //   3510: astore_2
    //   3511: aload 4
    //   3513: astore_3
    //   3514: aload 24
    //   3516: astore 15
    //   3518: aload 21
    //   3520: astore 4
    //   3522: goto -1697 -> 1825
    //   3525: aload 18
    //   3527: astore_2
    //   3528: new 577	java/util/ArrayList
    //   3531: dup
    //   3532: invokespecial 578	java/util/ArrayList:<init>	()V
    //   3535: astore 4
    //   3537: aload_2
    //   3538: astore_3
    //   3539: aload 21
    //   3541: getfield 1715	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3544: ifnull +410 -> 3954
    //   3547: aload_2
    //   3548: astore_3
    //   3549: aload 21
    //   3551: getfield 1715	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3554: invokevirtual 1500	java/util/ArrayList:size	()I
    //   3557: ifle +397 -> 3954
    //   3560: iconst_0
    //   3561: istore 5
    //   3563: aload_2
    //   3564: astore_3
    //   3565: iload 5
    //   3567: aload 21
    //   3569: getfield 1715	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3572: invokevirtual 1500	java/util/ArrayList:size	()I
    //   3575: if_icmpge +379 -> 3954
    //   3578: aload 21
    //   3580: getfield 1715	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3583: iload 5
    //   3585: invokevirtual 1501	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3588: checkcast 1542	[B
    //   3591: astore_3
    //   3592: aload_3
    //   3593: ifnonnull +9 -> 3602
    //   3596: iconst_0
    //   3597: istore 7
    //   3599: goto +7 -> 3606
    //   3602: aload_3
    //   3603: arraylength
    //   3604: istore 7
    //   3606: iload 7
    //   3608: bipush 10
    //   3610: if_icmpgt +6 -> 3616
    //   3613: goto +332 -> 3945
    //   3616: aload_3
    //   3617: iconst_1
    //   3618: invokestatic 1548	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   3621: l2i
    //   3622: istore 8
    //   3624: aload_3
    //   3625: iconst_5
    //   3626: invokestatic 1548	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   3629: pop2
    //   3630: iload 8
    //   3632: ifle +313 -> 3945
    //   3635: bipush 9
    //   3637: iload 8
    //   3639: iadd
    //   3640: iload 7
    //   3642: if_icmplt +6 -> 3648
    //   3645: goto +300 -> 3945
    //   3648: iload 8
    //   3650: newarray byte
    //   3652: astore 15
    //   3654: aload 15
    //   3656: iconst_0
    //   3657: aload_3
    //   3658: bipush 9
    //   3660: iload 8
    //   3662: invokestatic 1552	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   3665: new 1554	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   3668: dup
    //   3669: invokespecial 1555	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   3672: astore_3
    //   3673: aload_3
    //   3674: aload 15
    //   3676: invokevirtual 1556	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3679: pop
    //   3680: aload_3
    //   3681: getfield 1559	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3684: invokevirtual 381	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3687: istore 7
    //   3689: iload 7
    //   3691: ifne +141 -> 3832
    //   3694: new 1717	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry
    //   3697: dup
    //   3698: invokespecial 1718	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:<init>	()V
    //   3701: astore 15
    //   3703: aload 15
    //   3705: aload_3
    //   3706: getfield 1581	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3709: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3712: putfield 1721	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:nBusiEntryType	I
    //   3715: aload_3
    //   3716: getfield 1725	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3719: ifnull +66 -> 3785
    //   3722: aload 15
    //   3724: aload_3
    //   3725: getfield 1725	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3728: getfield 1730	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3731: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3734: putfield 1733	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strLogoUrl	Ljava/lang/String;
    //   3737: aload 15
    //   3739: aload_3
    //   3740: getfield 1725	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3743: getfield 1736	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3746: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3749: putfield 1737	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strTitle	Ljava/lang/String;
    //   3752: aload 15
    //   3754: aload_3
    //   3755: getfield 1725	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3758: getfield 1740	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3761: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3764: putfield 1743	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strContent	Ljava/lang/String;
    //   3767: aload 15
    //   3769: aload_3
    //   3770: getfield 1725	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3773: getfield 1746	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3776: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3779: putfield 1747	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strJumpUrl	Ljava/lang/String;
    //   3782: goto +29 -> 3811
    //   3785: aload_2
    //   3786: astore_3
    //   3787: aload 15
    //   3789: aload_3
    //   3790: putfield 1733	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strLogoUrl	Ljava/lang/String;
    //   3793: aload 15
    //   3795: aload_3
    //   3796: putfield 1737	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strTitle	Ljava/lang/String;
    //   3799: aload 15
    //   3801: aload_3
    //   3802: putfield 1743	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strContent	Ljava/lang/String;
    //   3805: aload 15
    //   3807: aload_3
    //   3808: putfield 1747	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strJumpUrl	Ljava/lang/String;
    //   3811: aload 15
    //   3813: invokevirtual 1750	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:isEmpty	()Z
    //   3816: ifne +129 -> 3945
    //   3819: aload 4
    //   3821: aload 15
    //   3823: invokeinterface 619 2 0
    //   3828: pop
    //   3829: goto +116 -> 3945
    //   3832: invokestatic 635	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3835: ifeq +110 -> 3945
    //   3838: new 68	java/lang/StringBuilder
    //   3841: dup
    //   3842: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   3845: astore 15
    //   3847: aload 15
    //   3849: ldc_w 1752
    //   3852: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3855: pop
    //   3856: aload 15
    //   3858: aload_3
    //   3859: getfield 1581	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3862: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3865: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3868: pop
    //   3869: aload 15
    //   3871: ldc_w 1754
    //   3874: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3877: pop
    //   3878: aload 15
    //   3880: iload 7
    //   3882: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3885: pop
    //   3886: aload 15
    //   3888: ldc_w 1754
    //   3891: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3894: pop
    //   3895: aload 15
    //   3897: aload_3
    //   3898: getfield 1712	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3901: invokevirtual 1412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3904: pop
    //   3905: ldc_w 639
    //   3908: iconst_4
    //   3909: aload 15
    //   3911: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3914: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3917: goto +28 -> 3945
    //   3920: astore_3
    //   3921: goto +4 -> 3925
    //   3924: astore_3
    //   3925: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3928: ifeq +17 -> 3945
    //   3931: ldc_w 639
    //   3934: iconst_2
    //   3935: aload_3
    //   3936: invokevirtual 707	java/lang/Exception:toString	()Ljava/lang/String;
    //   3939: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3942: goto +3 -> 3945
    //   3945: iload 5
    //   3947: iconst_1
    //   3948: iadd
    //   3949: istore 5
    //   3951: goto -388 -> 3563
    //   3954: aload 20
    //   3956: aload 4
    //   3958: invokevirtual 1758	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   3961: aload 21
    //   3963: getfield 1762	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3966: ifnonnull +22 -> 3988
    //   3969: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3972: ifeq +82 -> 4054
    //   3975: ldc_w 639
    //   3978: iconst_2
    //   3979: ldc_w 709
    //   3982: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3985: goto +69 -> 4054
    //   3988: aload 21
    //   3990: getfield 1762	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3993: getfield 1767	SummaryCard/InterestTagInfo:uFlag	J
    //   3996: lstore 13
    //   3998: new 688	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   4001: dup
    //   4002: invokespecial 689	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   4005: astore_2
    //   4006: aload_2
    //   4007: aload 21
    //   4009: getfield 1762	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   4012: getfield 1768	SummaryCard/InterestTagInfo:vGiftInfo	[B
    //   4015: invokevirtual 693	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4018: pop
    //   4019: aload 20
    //   4021: lload 13
    //   4023: aload_2
    //   4024: getfield 697	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4027: invokevirtual 700	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4030: invokevirtual 704	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   4033: goto +21 -> 4054
    //   4036: astore_2
    //   4037: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4040: ifeq +14 -> 4054
    //   4043: ldc_w 706
    //   4046: iconst_2
    //   4047: aload_2
    //   4048: invokevirtual 707	java/lang/Exception:toString	()Ljava/lang/String;
    //   4051: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4054: aload 21
    //   4056: getfield 1771	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   4059: ifnull +243 -> 4302
    //   4062: new 1773	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody
    //   4065: dup
    //   4066: invokespecial 1774	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:<init>	()V
    //   4069: astore_2
    //   4070: aload_2
    //   4071: aload 21
    //   4073: getfield 1771	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   4076: invokevirtual 1775	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4079: pop
    //   4080: goto +23 -> 4103
    //   4083: astore 4
    //   4085: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4088: ifeq +15 -> 4103
    //   4091: ldc_w 639
    //   4094: iconst_2
    //   4095: aload 4
    //   4097: invokevirtual 707	java/lang/Exception:toString	()Ljava/lang/String;
    //   4100: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4103: aload_2
    //   4104: getfield 1778	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:rpt_msg_wifi_poi_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4107: invokevirtual 700	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4110: astore_2
    //   4111: new 577	java/util/ArrayList
    //   4114: dup
    //   4115: invokespecial 578	java/util/ArrayList:<init>	()V
    //   4118: astore 4
    //   4120: aload_2
    //   4121: ifnull +66 -> 4187
    //   4124: aload_2
    //   4125: invokeinterface 1178 1 0
    //   4130: astore_2
    //   4131: aload_2
    //   4132: invokeinterface 1183 1 0
    //   4137: ifeq +50 -> 4187
    //   4140: aload_2
    //   4141: invokeinterface 1187 1 0
    //   4146: checkcast 1780	tencent/im/oidb/hotchat/Common$WifiPOIInfo
    //   4149: astore 15
    //   4151: aload 15
    //   4153: getfield 1783	tencent/im/oidb/hotchat/Common$WifiPOIInfo:uint32_wifi_poi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4156: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4159: iconst_1
    //   4160: if_icmpne +8 -> 4168
    //   4163: iconst_1
    //   4164: istore_1
    //   4165: goto +5 -> 4170
    //   4168: iconst_0
    //   4169: istore_1
    //   4170: aload 4
    //   4172: aload 15
    //   4174: iload_1
    //   4175: invokestatic 1789	com/tencent/mobileqq/data/HotChatInfo:createHotChat	(Ltencent/im/oidb/hotchat/Common$WifiPOIInfo;Z)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   4178: invokeinterface 619 2 0
    //   4183: pop
    //   4184: goto -53 -> 4131
    //   4187: aload 4
    //   4189: invokeinterface 609 1 0
    //   4194: ifle +47 -> 4241
    //   4197: iconst_0
    //   4198: istore 5
    //   4200: iload 5
    //   4202: aload 4
    //   4204: invokeinterface 609 1 0
    //   4209: if_icmpge +32 -> 4241
    //   4212: aload 4
    //   4214: iload 5
    //   4216: invokeinterface 612 2 0
    //   4221: checkcast 1785	com/tencent/mobileqq/data/HotChatInfo
    //   4224: astore_2
    //   4225: aload_2
    //   4226: ifnull +6 -> 4232
    //   4229: goto +14 -> 4243
    //   4232: iload 5
    //   4234: iconst_1
    //   4235: iadd
    //   4236: istore 5
    //   4238: goto -38 -> 4200
    //   4241: aconst_null
    //   4242: astore_2
    //   4243: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4246: ifeq +43 -> 4289
    //   4249: new 68	java/lang/StringBuilder
    //   4252: dup
    //   4253: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   4256: astore 4
    //   4258: aload 4
    //   4260: ldc_w 1791
    //   4263: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4266: pop
    //   4267: aload 4
    //   4269: aload_2
    //   4270: invokevirtual 1412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4273: pop
    //   4274: ldc_w 639
    //   4277: iconst_2
    //   4278: aload 4
    //   4280: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4283: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4286: goto +3 -> 4289
    //   4289: aload_2
    //   4290: ifnull +28 -> 4318
    //   4293: aload 20
    //   4295: aload_2
    //   4296: invokevirtual 1795	com/tencent/mobileqq/data/NearbyPeopleCard:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   4299: goto +19 -> 4318
    //   4302: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4305: ifeq +13 -> 4318
    //   4308: ldc_w 639
    //   4311: iconst_2
    //   4312: ldc_w 1797
    //   4315: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4318: aload 20
    //   4320: getfield 443	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   4323: ifnull +1223 -> 5546
    //   4326: new 753	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   4329: dup
    //   4330: invokespecial 754	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   4333: astore 4
    //   4335: aload 4
    //   4337: aload 20
    //   4339: getfield 443	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   4342: invokevirtual 755	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4345: pop
    //   4346: iload 6
    //   4348: istore 5
    //   4350: iload 5
    //   4352: bipush 51
    //   4354: if_icmpne +84 -> 4438
    //   4357: aload 4
    //   4359: getfield 758	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4362: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4365: iconst_1
    //   4366: if_icmpne +2887 -> 7253
    //   4369: iconst_1
    //   4370: istore_1
    //   4371: goto +3 -> 4374
    //   4374: aload 20
    //   4376: iload_1
    //   4377: putfield 290	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   4380: aload 4
    //   4382: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4385: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4388: iconst_1
    //   4389: if_icmpne +2869 -> 7258
    //   4392: iconst_1
    //   4393: istore_1
    //   4394: goto +3 -> 4397
    //   4397: aload 20
    //   4399: iload_1
    //   4400: putfield 277	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   4403: aload 20
    //   4405: aload 4
    //   4407: getfield 764	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4410: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4413: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4416: putfield 302	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   4419: aload 20
    //   4421: aload 4
    //   4423: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4426: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4429: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4432: putfield 296	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   4435: goto +91 -> 4526
    //   4438: aload 20
    //   4440: aload 4
    //   4442: getfield 758	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4445: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4448: putfield 284	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4451: aload 20
    //   4453: getfield 284	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4456: iconst_1
    //   4457: if_icmpne +2806 -> 7263
    //   4460: iconst_1
    //   4461: istore_1
    //   4462: goto +3 -> 4465
    //   4465: aload 20
    //   4467: iload_1
    //   4468: putfield 280	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   4471: aload 4
    //   4473: getfield 761	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4476: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4479: iconst_1
    //   4480: if_icmpne +2788 -> 7268
    //   4483: iconst_1
    //   4484: istore_1
    //   4485: goto +3 -> 4488
    //   4488: aload 20
    //   4490: iload_1
    //   4491: putfield 274	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   4494: aload 20
    //   4496: aload 4
    //   4498: getfield 764	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4501: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4504: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4507: putfield 299	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   4510: aload 20
    //   4512: aload 4
    //   4514: getfield 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4517: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4520: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4523: putfield 293	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   4526: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4529: ifeq +105 -> 4634
    //   4532: new 68	java/lang/StringBuilder
    //   4535: dup
    //   4536: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   4539: astore_2
    //   4540: aload_2
    //   4541: ldc_w 769
    //   4544: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4547: pop
    //   4548: aload_2
    //   4549: iload 5
    //   4551: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4554: pop
    //   4555: aload_2
    //   4556: ldc_w 771
    //   4559: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4562: pop
    //   4563: aload_2
    //   4564: aload 4
    //   4566: getfield 758	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4569: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4572: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4575: pop
    //   4576: aload_2
    //   4577: ldc_w 773
    //   4580: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4583: pop
    //   4584: aload_2
    //   4585: aload 4
    //   4587: getfield 764	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4590: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4593: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4596: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4599: pop
    //   4600: aload_2
    //   4601: ldc_w 775
    //   4604: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4607: pop
    //   4608: aload_2
    //   4609: aload_0
    //   4610: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4613: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4616: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4619: pop
    //   4620: ldc_w 777
    //   4623: iconst_2
    //   4624: aload_2
    //   4625: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4628: invokestatic 779	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4631: goto +2642 -> 7273
    //   4634: new 68	java/lang/StringBuilder
    //   4637: dup
    //   4638: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   4641: astore_2
    //   4642: aload_2
    //   4643: ldc_w 769
    //   4646: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4649: pop
    //   4650: aload_2
    //   4651: iload 5
    //   4653: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4656: pop
    //   4657: aload_2
    //   4658: ldc_w 771
    //   4661: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4664: pop
    //   4665: aload_2
    //   4666: aload 4
    //   4668: getfield 758	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4671: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4674: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4677: pop
    //   4678: aload_2
    //   4679: ldc_w 773
    //   4682: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4685: pop
    //   4686: aload_2
    //   4687: aload 4
    //   4689: getfield 764	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4692: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4695: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4698: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4701: pop
    //   4702: ldc_w 777
    //   4705: iconst_1
    //   4706: aload_2
    //   4707: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4710: invokestatic 779	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4713: goto +2560 -> 7273
    //   4716: astore_2
    //   4717: goto +4 -> 4721
    //   4720: astore_2
    //   4721: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4724: ifeq +2549 -> 7273
    //   4727: new 68	java/lang/StringBuilder
    //   4730: dup
    //   4731: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   4734: astore 15
    //   4736: aload 15
    //   4738: ldc_w 781
    //   4741: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4744: pop
    //   4745: aload 15
    //   4747: aload_2
    //   4748: invokevirtual 707	java/lang/Exception:toString	()Ljava/lang/String;
    //   4751: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4754: pop
    //   4755: aload 15
    //   4757: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4760: astore_2
    //   4761: aload 17
    //   4763: iconst_2
    //   4764: aload_2
    //   4765: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4768: goto +3 -> 4771
    //   4771: aload 17
    //   4773: astore_2
    //   4774: aload 20
    //   4776: aload 4
    //   4778: getfield 784	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4781: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4784: putfield 287	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   4787: aload 4
    //   4789: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4792: invokevirtual 791	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   4795: ifeq +147 -> 4942
    //   4798: aload 20
    //   4800: aload 4
    //   4802: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4805: invokevirtual 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4808: checkcast 790	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4811: getfield 795	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4814: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4817: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4820: putfield 320	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   4823: aload 20
    //   4825: aload 4
    //   4827: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4830: invokevirtual 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4833: checkcast 790	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4836: getfield 798	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4839: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4842: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4845: putfield 317	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   4848: aload 20
    //   4850: aload 4
    //   4852: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4855: invokevirtual 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4858: checkcast 790	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4861: getfield 801	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4864: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4867: putfield 314	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   4870: aload 20
    //   4872: aload 4
    //   4874: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4877: invokevirtual 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4880: checkcast 790	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4883: getfield 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4886: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4889: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4892: putfield 305	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   4895: aload 20
    //   4897: aload 4
    //   4899: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4902: invokevirtual 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4905: checkcast 790	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4908: getfield 807	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4911: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4914: putfield 308	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   4917: aload 20
    //   4919: aload 4
    //   4921: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4924: invokevirtual 792	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4927: checkcast 790	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4930: getfield 810	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4933: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4936: putfield 311	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   4939: goto +39 -> 4978
    //   4942: aload 20
    //   4944: aload_3
    //   4945: putfield 320	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   4948: aload 20
    //   4950: aload_3
    //   4951: putfield 317	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   4954: aload 20
    //   4956: iconst_0
    //   4957: putfield 314	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   4960: aload 20
    //   4962: aload_3
    //   4963: putfield 305	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   4966: aload 20
    //   4968: iconst_0
    //   4969: putfield 308	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   4972: aload 20
    //   4974: iconst_0
    //   4975: putfield 311	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   4978: aload 4
    //   4980: getfield 813	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4983: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4986: iconst_1
    //   4987: if_icmpne +2289 -> 7276
    //   4990: iconst_1
    //   4991: istore_1
    //   4992: goto +3 -> 4995
    //   4995: aload 20
    //   4997: iload_1
    //   4998: putfield 816	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   5001: aload 20
    //   5003: aload 4
    //   5005: getfield 819	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5008: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5011: putfield 822	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   5014: aload 20
    //   5016: aload 4
    //   5018: getfield 825	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5021: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5024: putfield 828	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   5027: aload 20
    //   5029: aload 4
    //   5031: getfield 831	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5034: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5037: putfield 834	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   5040: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5043: ifeq +130 -> 5173
    //   5046: new 68	java/lang/StringBuilder
    //   5049: dup
    //   5050: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5053: astore_3
    //   5054: aload_3
    //   5055: ldc_w 836
    //   5058: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5061: pop
    //   5062: aload_3
    //   5063: aload 20
    //   5065: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5068: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5071: pop
    //   5072: aload_3
    //   5073: ldc_w 838
    //   5076: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5079: pop
    //   5080: aload_3
    //   5081: aload 20
    //   5083: getfield 816	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   5086: invokevirtual 841	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5089: pop
    //   5090: aload_3
    //   5091: ldc_w 843
    //   5094: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5097: pop
    //   5098: aload_3
    //   5099: aload 20
    //   5101: invokevirtual 846	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   5104: invokevirtual 841	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5107: pop
    //   5108: aload_3
    //   5109: ldc_w 848
    //   5112: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5115: pop
    //   5116: aload_3
    //   5117: aload 20
    //   5119: getfield 822	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   5122: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5125: pop
    //   5126: aload_3
    //   5127: ldc_w 850
    //   5130: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5133: pop
    //   5134: aload_3
    //   5135: aload 20
    //   5137: getfield 834	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   5140: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5143: pop
    //   5144: aload_3
    //   5145: ldc_w 852
    //   5148: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5151: pop
    //   5152: aload_3
    //   5153: aload 20
    //   5155: getfield 828	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   5158: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5161: pop
    //   5162: ldc_w 854
    //   5165: iconst_2
    //   5166: aload_3
    //   5167: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5170: invokestatic 779	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5173: aload 4
    //   5175: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5178: invokevirtual 873	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:has	()Z
    //   5181: ifeq +324 -> 5505
    //   5184: aload 20
    //   5186: aload 4
    //   5188: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5191: getfield 876	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5194: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5197: putfield 879	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   5200: aload 20
    //   5202: aload 4
    //   5204: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5207: getfield 882	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_left_btn	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5210: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5213: putfield 885	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   5216: aload 20
    //   5218: aload 4
    //   5220: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5223: getfield 888	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5226: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5229: putfield 891	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   5232: aload 20
    //   5234: aload 4
    //   5236: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5239: getfield 894	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_not_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5242: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5245: putfield 897	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   5248: aload 20
    //   5250: aload 4
    //   5252: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5255: getfield 900	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:android_app_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5258: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5261: putfield 903	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   5264: aload 20
    //   5266: aload 4
    //   5268: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5271: getfield 906	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:jump_uri	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5274: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5277: putfield 909	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   5280: aload 20
    //   5282: aload 4
    //   5284: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5287: getfield 912	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:app_download_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5290: invokevirtual 213	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5293: putfield 915	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   5296: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5299: ifeq +247 -> 5546
    //   5302: new 68	java/lang/StringBuilder
    //   5305: dup
    //   5306: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5309: astore_3
    //   5310: aload_3
    //   5311: ldc_w 929
    //   5314: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5317: pop
    //   5318: aload_3
    //   5319: ldc_w 931
    //   5322: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5325: pop
    //   5326: aload_3
    //   5327: aload 20
    //   5329: getfield 879	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   5332: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5335: pop
    //   5336: aload_3
    //   5337: aload 22
    //   5339: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5342: pop
    //   5343: aload_3
    //   5344: ldc_w 935
    //   5347: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5350: pop
    //   5351: aload_3
    //   5352: aload 20
    //   5354: getfield 885	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   5357: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5360: pop
    //   5361: aload_3
    //   5362: aload 22
    //   5364: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5367: pop
    //   5368: aload_3
    //   5369: ldc_w 937
    //   5372: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5375: pop
    //   5376: aload_3
    //   5377: aload 20
    //   5379: getfield 891	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   5382: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5385: pop
    //   5386: aload_3
    //   5387: aload 22
    //   5389: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5392: pop
    //   5393: aload_3
    //   5394: ldc_w 939
    //   5397: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5400: pop
    //   5401: aload_3
    //   5402: aload 20
    //   5404: getfield 897	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   5407: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5410: pop
    //   5411: aload_3
    //   5412: aload 22
    //   5414: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5417: pop
    //   5418: aload_3
    //   5419: ldc_w 941
    //   5422: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5425: pop
    //   5426: aload_3
    //   5427: aload 20
    //   5429: getfield 903	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   5432: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5435: pop
    //   5436: aload_3
    //   5437: aload 22
    //   5439: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5442: pop
    //   5443: aload_3
    //   5444: ldc_w 943
    //   5447: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5450: pop
    //   5451: aload_3
    //   5452: aload 20
    //   5454: getfield 909	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   5457: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5460: pop
    //   5461: aload_3
    //   5462: aload 22
    //   5464: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5467: pop
    //   5468: aload_3
    //   5469: ldc_w 945
    //   5472: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5475: pop
    //   5476: aload_3
    //   5477: aload 20
    //   5479: getfield 915	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   5482: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5485: pop
    //   5486: aload_3
    //   5487: aload 22
    //   5489: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5492: pop
    //   5493: aload_2
    //   5494: iconst_2
    //   5495: aload_3
    //   5496: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5499: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5502: goto +44 -> 5546
    //   5505: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5508: ifeq +38 -> 5546
    //   5511: aload_2
    //   5512: iconst_2
    //   5513: ldc_w 951
    //   5516: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5519: goto +27 -> 5546
    //   5522: goto +6 -> 5528
    //   5525: goto +3 -> 5528
    //   5528: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5531: ifeq +15 -> 5546
    //   5534: aload 17
    //   5536: iconst_2
    //   5537: ldc_w 953
    //   5540: invokestatic 779	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5543: goto +3 -> 5546
    //   5546: aload_0
    //   5547: astore_3
    //   5548: aload 21
    //   5550: getfield 1801	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   5553: ifnull +29 -> 5582
    //   5556: aload 20
    //   5558: aload 21
    //   5560: getfield 1801	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   5563: getfield 1806	SummaryCard/GiftInfo:uOpenFlag	J
    //   5566: putfield 723	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   5569: aload 20
    //   5571: aload 21
    //   5573: getfield 1801	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   5576: getfield 1807	SummaryCard/GiftInfo:vGiftInfo	[B
    //   5579: putfield 727	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   5582: aload 21
    //   5584: getfield 1810	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   5587: ifnull +234 -> 5821
    //   5590: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5593: ifeq +12 -> 5605
    //   5596: aload 17
    //   5598: iconst_2
    //   5599: ldc_w 1812
    //   5602: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5605: new 1814	tencent/im/group/group_member_info$RspGroupCardGetStory
    //   5608: dup
    //   5609: invokespecial 1815	tencent/im/group/group_member_info$RspGroupCardGetStory:<init>	()V
    //   5612: astore_2
    //   5613: aload_2
    //   5614: aload 21
    //   5616: getfield 1810	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   5619: invokevirtual 1816	tencent/im/group/group_member_info$RspGroupCardGetStory:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5622: pop
    //   5623: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5626: ifeq +102 -> 5728
    //   5629: new 68	java/lang/StringBuilder
    //   5632: dup
    //   5633: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5636: astore 4
    //   5638: aload 4
    //   5640: ldc_w 1818
    //   5643: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5646: pop
    //   5647: aload 4
    //   5649: aload_2
    //   5650: getfield 1819	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5653: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5656: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5659: pop
    //   5660: aload 17
    //   5662: iconst_2
    //   5663: aload 4
    //   5665: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5668: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5671: aload_2
    //   5672: getfield 1822	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5675: invokevirtual 975	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5678: ifeq +50 -> 5728
    //   5681: new 68	java/lang/StringBuilder
    //   5684: dup
    //   5685: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5688: astore 4
    //   5690: aload 4
    //   5692: ldc_w 1824
    //   5695: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5698: pop
    //   5699: aload 4
    //   5701: aload_2
    //   5702: getfield 1822	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5705: invokevirtual 700	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5708: invokeinterface 609 1 0
    //   5713: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5716: pop
    //   5717: aload 17
    //   5719: iconst_2
    //   5720: aload 4
    //   5722: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5725: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5728: aload_2
    //   5729: getfield 1819	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5732: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5735: iconst_1
    //   5736: if_icmpne +1545 -> 7281
    //   5739: iconst_1
    //   5740: istore_1
    //   5741: goto +3 -> 5744
    //   5744: aload 20
    //   5746: iload_1
    //   5747: putfield 1827	com/tencent/mobileqq/data/NearbyPeopleCard:mHasStory	Z
    //   5750: aload_2
    //   5751: getfield 1822	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5754: invokevirtual 975	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5757: ifeq +64 -> 5821
    //   5760: aload 20
    //   5762: aload_2
    //   5763: getfield 1822	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5766: invokevirtual 700	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5769: invokevirtual 1830	com/tencent/mobileqq/data/NearbyPeopleCard:addQQStoryList	(Ljava/util/List;)V
    //   5772: goto +49 -> 5821
    //   5775: astore_2
    //   5776: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5779: ifeq +42 -> 5821
    //   5782: new 68	java/lang/StringBuilder
    //   5785: dup
    //   5786: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   5789: astore 4
    //   5791: aload 4
    //   5793: ldc_w 1832
    //   5796: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5799: pop
    //   5800: aload 4
    //   5802: aload_2
    //   5803: invokevirtual 1833	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   5806: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5809: pop
    //   5810: aload 17
    //   5812: iconst_2
    //   5813: aload 4
    //   5815: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5818: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5821: aload 21
    //   5823: getfield 1836	SummaryCard/RespSummaryCard:vNearbyTaskInfo	[B
    //   5826: astore_2
    //   5827: aload_2
    //   5828: ifnull +48 -> 5876
    //   5831: new 1838	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody
    //   5834: dup
    //   5835: invokespecial 1839	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:<init>	()V
    //   5838: astore 4
    //   5840: aload 4
    //   5842: aload_2
    //   5843: invokevirtual 1840	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5846: pop
    //   5847: aload 20
    //   5849: aload 4
    //   5851: getfield 1843	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_finish_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5854: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5857: putfield 1846	com/tencent/mobileqq/data/NearbyPeopleCard:taskFinished	I
    //   5860: aload 20
    //   5862: aload 4
    //   5864: getfield 1849	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_all_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5867: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5870: putfield 1852	com/tencent/mobileqq/data/NearbyPeopleCard:taskTotal	I
    //   5873: goto +3 -> 5876
    //   5876: aload 21
    //   5878: getfield 1855	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   5881: astore_2
    //   5882: aload_2
    //   5883: ifnull +396 -> 6279
    //   5886: aload 20
    //   5888: new 577	java/util/ArrayList
    //   5891: dup
    //   5892: invokespecial 578	java/util/ArrayList:<init>	()V
    //   5895: putfield 1858	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   5898: new 1860	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData
    //   5901: dup
    //   5902: invokespecial 1861	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:<init>	()V
    //   5905: astore 4
    //   5907: aload 4
    //   5909: aload_2
    //   5910: invokevirtual 1862	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5913: pop
    //   5914: aload 4
    //   5916: getfield 1865	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:rpt_msg_now_haiwan	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5919: invokevirtual 700	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5922: astore_2
    //   5923: aload_2
    //   5924: ifnull +355 -> 6279
    //   5927: new 603	org/json/JSONArray
    //   5930: dup
    //   5931: invokespecial 604	org/json/JSONArray:<init>	()V
    //   5934: astore 4
    //   5936: iconst_0
    //   5937: istore 5
    //   5939: iload 5
    //   5941: aload_2
    //   5942: invokeinterface 609 1 0
    //   5947: if_icmpge +273 -> 6220
    //   5950: new 1867	org/json/JSONObject
    //   5953: dup
    //   5954: invokespecial 1868	org/json/JSONObject:<init>	()V
    //   5957: astore 15
    //   5959: new 1870	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem
    //   5962: dup
    //   5963: invokespecial 1871	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:<init>	()V
    //   5966: astore 16
    //   5968: aload 16
    //   5970: aload_2
    //   5971: iload 5
    //   5973: invokeinterface 612 2 0
    //   5978: checkcast 1873	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   5981: getfield 1876	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5984: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5987: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5990: putfield 1878	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   5993: aload 16
    //   5995: getfield 1878	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   5998: invokestatic 1881	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6001: ifne +17 -> 6018
    //   6004: aload 15
    //   6006: ldc_w 1882
    //   6009: aload 16
    //   6011: getfield 1878	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   6014: invokevirtual 1885	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6017: pop
    //   6018: aload 16
    //   6020: aload_2
    //   6021: iload 5
    //   6023: invokeinterface 612 2 0
    //   6028: checkcast 1873	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   6031: getfield 1888	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6034: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6037: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6040: putfield 1891	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   6043: aload 16
    //   6045: getfield 1891	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   6048: invokestatic 1881	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6051: ifne +17 -> 6068
    //   6054: aload 15
    //   6056: ldc_w 1892
    //   6059: aload 16
    //   6061: getfield 1891	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   6064: invokevirtual 1885	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6067: pop
    //   6068: aload 16
    //   6070: aload_2
    //   6071: iload 5
    //   6073: invokeinterface 612 2 0
    //   6078: checkcast 1873	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   6081: getfield 1895	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6084: invokevirtual 365	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6087: invokevirtual 615	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6090: putfield 1897	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   6093: aload 16
    //   6095: getfield 1897	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   6098: invokestatic 1881	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6101: ifne +17 -> 6118
    //   6104: aload 15
    //   6106: ldc_w 1898
    //   6109: aload 16
    //   6111: getfield 1897	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   6114: invokevirtual 1885	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6117: pop
    //   6118: aload 16
    //   6120: aload_2
    //   6121: iload 5
    //   6123: invokeinterface 612 2 0
    //   6128: checkcast 1873	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   6131: getfield 1901	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6134: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6137: putfield 1904	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   6140: aload 15
    //   6142: ldc_w 1905
    //   6145: aload 16
    //   6147: getfield 1904	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   6150: invokevirtual 1908	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   6153: pop
    //   6154: aload 16
    //   6156: aload_2
    //   6157: iload 5
    //   6159: invokeinterface 612 2 0
    //   6164: checkcast 1873	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   6167: getfield 1911	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6170: invokevirtual 339	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6173: putfield 1913	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   6176: aload 15
    //   6178: ldc_w 1914
    //   6181: aload 16
    //   6183: getfield 1913	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   6186: invokevirtual 1908	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   6189: pop
    //   6190: aload 20
    //   6192: getfield 1858	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   6195: aload 16
    //   6197: invokeinterface 619 2 0
    //   6202: pop
    //   6203: aload 4
    //   6205: aload 15
    //   6207: invokevirtual 623	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   6210: pop
    //   6211: iload 5
    //   6213: iconst_1
    //   6214: iadd
    //   6215: istore 5
    //   6217: goto -278 -> 5939
    //   6220: aload 20
    //   6222: aload 4
    //   6224: invokevirtual 624	org/json/JSONArray:toString	()Ljava/lang/String;
    //   6227: putfield 1917	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanInfo	Ljava/lang/String;
    //   6230: goto +49 -> 6279
    //   6233: astore_2
    //   6234: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6237: ifeq +42 -> 6279
    //   6240: new 68	java/lang/StringBuilder
    //   6243: dup
    //   6244: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6247: astore 4
    //   6249: aload 4
    //   6251: ldc_w 1919
    //   6254: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6257: pop
    //   6258: aload 4
    //   6260: aload_2
    //   6261: invokevirtual 632	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6264: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6267: pop
    //   6268: aload 17
    //   6270: iconst_2
    //   6271: aload 4
    //   6273: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6276: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6279: aload 20
    //   6281: aload 21
    //   6283: getfield 1855	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   6286: putfield 959	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   6289: new 961	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   6292: dup
    //   6293: invokespecial 962	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   6296: astore 4
    //   6298: aload 4
    //   6300: aload 21
    //   6302: getfield 1855	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   6305: invokevirtual 963	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6308: pop
    //   6309: aload 4
    //   6311: astore_2
    //   6312: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6315: ifeq +138 -> 6453
    //   6318: new 68	java/lang/StringBuilder
    //   6321: dup
    //   6322: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6325: astore_2
    //   6326: aload_2
    //   6327: ldc_w 965
    //   6330: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6333: pop
    //   6334: aload_2
    //   6335: aload 4
    //   6337: getfield 968	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6340: invokevirtual 969	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   6343: invokevirtual 841	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6346: pop
    //   6347: aload_2
    //   6348: ldc_w 971
    //   6351: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6354: pop
    //   6355: aload_2
    //   6356: aload 4
    //   6358: getfield 974	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   6361: invokevirtual 975	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   6364: invokevirtual 841	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6367: pop
    //   6368: aload_2
    //   6369: ldc_w 977
    //   6372: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6375: pop
    //   6376: aload_2
    //   6377: aload 4
    //   6379: getfield 980	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   6382: invokevirtual 975	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   6385: invokevirtual 841	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6388: pop
    //   6389: aload 17
    //   6391: iconst_2
    //   6392: aload_2
    //   6393: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6396: invokestatic 779	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6399: aload 4
    //   6401: astore_2
    //   6402: goto +51 -> 6453
    //   6405: astore_2
    //   6406: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6409: ifeq +42 -> 6451
    //   6412: new 68	java/lang/StringBuilder
    //   6415: dup
    //   6416: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6419: astore 4
    //   6421: aload 4
    //   6423: ldc_w 982
    //   6426: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6429: pop
    //   6430: aload 4
    //   6432: aload_2
    //   6433: invokevirtual 707	java/lang/Exception:toString	()Ljava/lang/String;
    //   6436: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6439: pop
    //   6440: aload 17
    //   6442: iconst_2
    //   6443: aload 4
    //   6445: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6448: invokestatic 985	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   6451: aconst_null
    //   6452: astore_2
    //   6453: aload 20
    //   6455: aload_2
    //   6456: putfield 989	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   6459: aload_3
    //   6460: bipush 51
    //   6462: iconst_1
    //   6463: aload 20
    //   6465: iload 11
    //   6467: invokevirtual 993	com/tencent/mobileqq/nearby/business/NearbyCardHandler:notifyUI	(IZLjava/lang/Object;Z)V
    //   6470: aload_3
    //   6471: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6474: getstatic 998	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   6477: invokevirtual 1002	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6480: checkcast 1004	com/tencent/mobileqq/nearby/NearbyCardManager
    //   6483: astore_2
    //   6484: iload 6
    //   6486: bipush 51
    //   6488: if_icmpne +18 -> 6506
    //   6491: aload_2
    //   6492: aload 20
    //   6494: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6497: invokestatic 1009	android/os/SystemClock:elapsedRealtime	()J
    //   6500: invokevirtual 1012	com/tencent/mobileqq/nearby/NearbyCardManager:b	(Ljava/lang/String;J)V
    //   6503: goto +18 -> 6521
    //   6506: aload_2
    //   6507: aload 20
    //   6509: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   6512: invokestatic 256	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6515: invokestatic 1009	android/os/SystemClock:elapsedRealtime	()J
    //   6518: invokevirtual 1014	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Ljava/lang/String;J)V
    //   6521: invokestatic 635	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6524: ifeq +56 -> 6580
    //   6527: new 68	java/lang/StringBuilder
    //   6530: dup
    //   6531: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6534: astore_2
    //   6535: aload_2
    //   6536: ldc_w 1016
    //   6539: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6542: pop
    //   6543: aload_2
    //   6544: aload 20
    //   6546: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   6549: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6552: pop
    //   6553: aload_2
    //   6554: ldc_w 1018
    //   6557: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6560: pop
    //   6561: aload_2
    //   6562: invokestatic 1009	android/os/SystemClock:elapsedRealtime	()J
    //   6565: invokevirtual 154	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6568: pop
    //   6569: ldc_w 1020
    //   6572: iconst_4
    //   6573: aload_2
    //   6574: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6577: invokestatic 642	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6580: aload_3
    //   6581: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6584: getstatic 1023	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   6587: invokevirtual 1002	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6590: checkcast 1025	com/tencent/mobileqq/app/FriendsManager
    //   6593: astore_2
    //   6594: invokestatic 1923	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   6597: ifeq +55 -> 6652
    //   6600: aload 17
    //   6602: iconst_5
    //   6603: anewarray 1153	java/lang/Object
    //   6606: dup
    //   6607: iconst_0
    //   6608: ldc_w 1925
    //   6611: aastore
    //   6612: dup
    //   6613: iconst_1
    //   6614: iload 6
    //   6616: invokestatic 1161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6619: aastore
    //   6620: dup
    //   6621: iconst_2
    //   6622: aload 20
    //   6624: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6627: aastore
    //   6628: dup
    //   6629: iconst_3
    //   6630: aload_3
    //   6631: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6634: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6637: aastore
    //   6638: dup
    //   6639: iconst_4
    //   6640: aload 21
    //   6642: getfield 1240	SummaryCard/RespSummaryCard:lUIN	J
    //   6645: invokestatic 347	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6648: aastore
    //   6649: invokestatic 1928	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   6652: iload 6
    //   6654: ifeq +21 -> 6675
    //   6657: aload 20
    //   6659: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6662: aload_3
    //   6663: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6666: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6669: invokevirtual 1248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6672: ifeq +92 -> 6764
    //   6675: aload_2
    //   6676: aload 20
    //   6678: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6681: invokevirtual 1028	com/tencent/mobileqq/app/FriendsManager:g	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   6684: astore 4
    //   6686: aload 4
    //   6688: aload 20
    //   6690: getfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   6693: putfield 1033	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   6696: aload 4
    //   6698: aload 20
    //   6700: getfield 741	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   6703: i2l
    //   6704: putfield 1036	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   6707: aload_3
    //   6708: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6711: invokevirtual 1039	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   6714: aload 4
    //   6716: getfield 1036	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   6719: aload 4
    //   6721: getfield 1033	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   6724: invokestatic 1044	com/tencent/mobileqq/nearby/api/NearbySPUtil:a	(Ljava/lang/String;JI)Z
    //   6727: pop
    //   6728: aload_2
    //   6729: aload 4
    //   6731: invokevirtual 1047	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   6734: pop
    //   6735: aload_3
    //   6736: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6739: invokevirtual 1039	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   6742: ldc_w 1049
    //   6745: aload 20
    //   6747: getfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   6750: invokestatic 1052	com/tencent/mobileqq/nearby/api/NearbySPUtil:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   6753: pop
    //   6754: goto +10 -> 6764
    //   6757: astore 4
    //   6759: aload 4
    //   6761: invokevirtual 1055	java/lang/Exception:printStackTrace	()V
    //   6764: aload_3
    //   6765: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6768: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6771: aload 20
    //   6773: getfield 334	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6776: invokevirtual 1248	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6779: ifeq +32 -> 6811
    //   6782: aload 20
    //   6784: getfield 1058	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   6787: ifle +24 -> 6811
    //   6790: aload_3
    //   6791: getfield 30	com/tencent/mobileqq/nearby/business/NearbyCardHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6794: getstatic 1061	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   6797: invokevirtual 1002	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6800: checkcast 1063	com/tencent/mobileqq/app/HotChatManager
    //   6803: aload 20
    //   6805: getfield 1058	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   6808: invokevirtual 1065	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   6811: aload_2
    //   6812: aload 20
    //   6814: invokevirtual 1068	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   6817: aload 20
    //   6819: invokevirtual 267	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   6822: sipush 1000
    //   6825: if_icmpne +185 -> 7010
    //   6828: aload 19
    //   6830: iconst_0
    //   6831: ldc 249
    //   6833: invokevirtual 1073	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   6836: aconst_null
    //   6837: aconst_null
    //   6838: aconst_null
    //   6839: aconst_null
    //   6840: aconst_null
    //   6841: aconst_null
    //   6842: aconst_null
    //   6843: invokevirtual 1077	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   6846: astore_2
    //   6847: aload_2
    //   6848: ifnull +443 -> 7291
    //   6851: aload_2
    //   6852: invokeinterface 1082 1 0
    //   6857: istore 5
    //   6859: aload_2
    //   6860: invokeinterface 1085 1 0
    //   6865: pop
    //   6866: iload 5
    //   6868: sipush 200
    //   6871: if_icmple +420 -> 7291
    //   6874: iload 5
    //   6876: bipush 100
    //   6878: if_icmple +19 -> 6897
    //   6881: aload_2
    //   6882: invokeinterface 1088 1 0
    //   6887: pop
    //   6888: iload 5
    //   6890: iconst_1
    //   6891: isub
    //   6892: istore 5
    //   6894: goto -20 -> 6874
    //   6897: aload_2
    //   6898: aload_2
    //   6899: ldc_w 1090
    //   6902: invokeinterface 1093 2 0
    //   6907: invokeinterface 1096 2 0
    //   6912: istore 5
    //   6914: new 68	java/lang/StringBuilder
    //   6917: dup
    //   6918: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   6921: astore_3
    //   6922: aload_3
    //   6923: ldc_w 1098
    //   6926: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6929: pop
    //   6930: aload_3
    //   6931: ldc 249
    //   6933: invokevirtual 1073	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   6936: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6939: pop
    //   6940: aload_3
    //   6941: ldc_w 1100
    //   6944: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6947: pop
    //   6948: aload_3
    //   6949: ldc_w 1090
    //   6952: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6955: pop
    //   6956: aload_3
    //   6957: ldc_w 1102
    //   6960: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6963: pop
    //   6964: aload_3
    //   6965: iload 5
    //   6967: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6970: pop
    //   6971: aload_3
    //   6972: ldc_w 1104
    //   6975: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6978: pop
    //   6979: aload_3
    //   6980: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6983: astore 4
    //   6985: aload_2
    //   6986: astore_3
    //   6987: aload 19
    //   6989: aload 4
    //   6991: invokevirtual 1107	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   6994: pop
    //   6995: goto +3 -> 6998
    //   6998: aload_2
    //   6999: astore_3
    //   7000: aload 19
    //   7002: aload 20
    //   7004: invokevirtual 1111	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   7007: goto +35 -> 7042
    //   7010: aload 20
    //   7012: invokevirtual 267	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   7015: sipush 1001
    //   7018: if_icmpeq +14 -> 7032
    //   7021: aload 20
    //   7023: invokevirtual 267	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   7026: sipush 1002
    //   7029: if_icmpne +11 -> 7040
    //   7032: aload 19
    //   7034: aload 20
    //   7036: invokevirtual 1115	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   7039: pop
    //   7040: aconst_null
    //   7041: astore_2
    //   7042: aload_2
    //   7043: astore_3
    //   7044: aload 28
    //   7046: invokevirtual 1118	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   7049: aload_2
    //   7050: ifnull +9 -> 7059
    //   7053: aload_2
    //   7054: invokeinterface 1121 1 0
    //   7059: aload 28
    //   7061: invokevirtual 1124	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   7064: aload 19
    //   7066: invokevirtual 1125	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   7069: return
    //   7070: astore 4
    //   7072: aload_3
    //   7073: astore_2
    //   7074: goto +12 -> 7086
    //   7077: astore 4
    //   7079: goto +5 -> 7084
    //   7082: astore 4
    //   7084: aconst_null
    //   7085: astore_2
    //   7086: aload_2
    //   7087: ifnull +9 -> 7096
    //   7090: aload_2
    //   7091: invokeinterface 1121 1 0
    //   7096: aload 28
    //   7098: invokevirtual 1124	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   7101: aload 19
    //   7103: invokevirtual 1125	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   7106: aload 4
    //   7108: athrow
    //   7109: aload_0
    //   7110: bipush 51
    //   7112: iconst_0
    //   7113: aconst_null
    //   7114: iload 12
    //   7116: invokevirtual 993	com/tencent/mobileqq/nearby/business/NearbyCardHandler:notifyUI	(IZLjava/lang/Object;Z)V
    //   7119: return
    //   7120: astore_2
    //   7121: goto -1593 -> 5528
    //   7124: astore_2
    //   7125: goto -1600 -> 5525
    //   7128: astore_2
    //   7129: goto -1604 -> 5525
    //   7132: astore_2
    //   7133: goto -1611 -> 5522
    //   7136: astore_2
    //   7137: goto -1261 -> 5876
    //   7140: astore 20
    //   7142: iload 6
    //   7144: istore 5
    //   7146: goto +33 -> 7179
    //   7149: iload 5
    //   7151: istore 6
    //   7153: aload_2
    //   7154: astore 4
    //   7156: aload_3
    //   7157: astore 20
    //   7159: goto -4262 -> 2897
    //   7162: astore 20
    //   7164: iload 6
    //   7166: istore 5
    //   7168: aload 18
    //   7170: astore_3
    //   7171: aload 16
    //   7173: astore_2
    //   7174: goto +5 -> 7179
    //   7177: astore 20
    //   7179: aload 4
    //   7181: astore 16
    //   7183: aload_3
    //   7184: astore 4
    //   7186: aload 15
    //   7188: astore 19
    //   7190: aload 17
    //   7192: astore 18
    //   7194: aload_2
    //   7195: astore_3
    //   7196: aload 4
    //   7198: astore_2
    //   7199: goto -3792 -> 3407
    //   7202: astore 18
    //   7204: aload 4
    //   7206: astore 16
    //   7208: aload 18
    //   7210: astore 4
    //   7212: goto -3825 -> 3387
    //   7215: astore 18
    //   7217: aload 4
    //   7219: astore 16
    //   7221: aload 18
    //   7223: astore 4
    //   7225: goto -3838 -> 3387
    //   7228: aload 15
    //   7230: astore 20
    //   7232: aload 4
    //   7234: astore 22
    //   7236: aload 16
    //   7238: astore 23
    //   7240: iload 5
    //   7242: istore 7
    //   7244: aload_2
    //   7245: astore 25
    //   7247: aload_3
    //   7248: astore 26
    //   7250: goto -4246 -> 3004
    //   7253: iconst_0
    //   7254: istore_1
    //   7255: goto -2881 -> 4374
    //   7258: iconst_0
    //   7259: istore_1
    //   7260: goto -2863 -> 4397
    //   7263: iconst_0
    //   7264: istore_1
    //   7265: goto -2800 -> 4465
    //   7268: iconst_0
    //   7269: istore_1
    //   7270: goto -2782 -> 4488
    //   7273: goto -2502 -> 4771
    //   7276: iconst_0
    //   7277: istore_1
    //   7278: goto -2283 -> 4995
    //   7281: iconst_0
    //   7282: istore_1
    //   7283: goto -1539 -> 5744
    //   7286: astore 4
    //   7288: goto -202 -> 7086
    //   7291: goto -293 -> 6998
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7294	0	this	NearbyCardHandler
    //   0	7294	1	paramBoolean	boolean
    //   0	7294	2	paramObject	Object
    //   0	7294	3	paramBundle	Bundle
    //   0	7294	4	paramRespHead	SummaryCard.RespHead
    //   19	7222	5	i	int
    //   949	6216	6	j	int
    //   1913	5330	7	k	int
    //   1810	1851	8	m	int
    //   2277	564	9	n	int
    //   1983	1259	10	i1	int
    //   1742	4724	11	bool1	boolean
    //   11	7104	12	bool2	boolean
    //   61	3961	13	l	long
    //   3	7226	15	localObject1	Object
    //   84	7153	16	localObject2	Object
    //   90	7101	17	localObject3	Object
    //   863	101	18	localObject4	Object
    //   1023	29	18	localException1	Exception
    //   1084	2234	18	localObject5	Object
    //   3377	7	18	localException2	Exception
    //   3388	3805	18	localObject6	Object
    //   7202	7	18	localException3	Exception
    //   7215	7	18	localException4	Exception
    //   892	6297	19	localObject7	Object
    //   920	2426	20	localObject8	Object
    //   3372	1	20	localException5	Exception
    //   3405	3630	20	localRespHead	SummaryCard.RespHead
    //   7140	1	20	localException6	Exception
    //   7157	1	20	localBundle	Bundle
    //   7162	1	20	localException7	Exception
    //   7177	1	20	localException8	Exception
    //   7230	1	20	localObject9	Object
    //   1753	4888	21	localObject10	Object
    //   1738	5497	22	localObject11	Object
    //   1451	5788	23	localObject12	Object
    //   1992	1523	24	localObject13	Object
    //   2105	5141	25	localObject14	Object
    //   2274	4975	26	localObject15	Object
    //   40	1807	27	localEntityManager	EntityManager
    //   47	7050	28	localEntityTransaction	EntityTransaction
    //   1730	1297	29	localArrayList1	ArrayList
    //   1965	1338	30	localcomm	com.tencent.pb.profilecard.SummaryCardBusiEntry.comm
    //   2051	934	31	localArrayList2	ArrayList
    //   2325	438	32	localLabel	com.tencent.pb.profilecard.SummaryCardBusiEntry.Label
    //   2344	487	33	localProfileGroupLabel	com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel
    //   2481	321	34	localProfileColor	com.tencent.mobileqq.profilecard.entity.ProfileColor
    // Exception table:
    //   from	to	target	type
    //   894	948	1023	java/lang/Exception
    //   951	1001	1023	java/lang/Exception
    //   1010	1020	1023	java/lang/Exception
    //   2409	2416	3372	java/lang/Exception
    //   2438	2452	3372	java/lang/Exception
    //   2474	2483	3372	java/lang/Exception
    //   2505	2522	3372	java/lang/Exception
    //   2544	2561	3372	java/lang/Exception
    //   2583	2600	3372	java/lang/Exception
    //   2622	2629	3372	java/lang/Exception
    //   2651	2660	3372	java/lang/Exception
    //   2682	2699	3372	java/lang/Exception
    //   2721	2738	3372	java/lang/Exception
    //   2760	2777	3372	java/lang/Exception
    //   2799	2806	3372	java/lang/Exception
    //   2828	2836	3372	java/lang/Exception
    //   2887	2894	3372	java/lang/Exception
    //   2919	2927	3372	java/lang/Exception
    //   2982	2989	3372	java/lang/Exception
    //   3026	3036	3372	java/lang/Exception
    //   3082	3088	3372	java/lang/Exception
    //   3110	3119	3372	java/lang/Exception
    //   3141	3150	3372	java/lang/Exception
    //   3172	3186	3372	java/lang/Exception
    //   3208	3217	3372	java/lang/Exception
    //   3239	3247	3372	java/lang/Exception
    //   3269	3278	3372	java/lang/Exception
    //   3300	3311	3372	java/lang/Exception
    //   3333	3345	3372	java/lang/Exception
    //   1967	1994	3377	java/lang/Exception
    //   1999	2053	3377	java/lang/Exception
    //   3787	3811	3920	java/lang/Exception
    //   3811	3829	3920	java/lang/Exception
    //   3832	3917	3920	java/lang/Exception
    //   3673	3689	3924	java/lang/Exception
    //   3694	3782	3924	java/lang/Exception
    //   3998	4033	4036	java/lang/Exception
    //   4070	4080	4083	java/lang/Exception
    //   4608	4631	4716	java/lang/Exception
    //   4634	4713	4716	java/lang/Exception
    //   4526	4608	4720	java/lang/Exception
    //   5590	5605	5775	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5605	5728	5775	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5728	5739	5775	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5744	5772	5775	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5907	5923	6233	java/lang/Exception
    //   5927	5936	6233	java/lang/Exception
    //   5939	6018	6233	java/lang/Exception
    //   6018	6068	6233	java/lang/Exception
    //   6068	6118	6233	java/lang/Exception
    //   6118	6211	6233	java/lang/Exception
    //   6220	6230	6233	java/lang/Exception
    //   6289	6309	6405	java/lang/Exception
    //   6312	6399	6405	java/lang/Exception
    //   6735	6754	6757	java/lang/Exception
    //   6987	6995	7070	finally
    //   7000	7007	7070	finally
    //   7044	7049	7070	finally
    //   7010	7032	7077	finally
    //   7032	7040	7077	finally
    //   6817	6847	7082	finally
    //   4335	4346	7120	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4357	4369	7124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4374	4392	7124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4397	4435	7124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4438	4460	7124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4465	4483	7124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4488	4526	7124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4526	4608	7124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4608	4631	7128	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4634	4713	7128	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4721	4761	7128	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4761	4768	7132	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4774	4939	7132	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4942	4978	7132	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4978	4990	7132	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4995	5173	7132	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5173	5502	7132	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5505	5519	7132	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5840	5873	7136	java/lang/Exception
    //   2350	2376	7140	java/lang/Exception
    //   2206	2216	7162	java/lang/Exception
    //   2226	2236	7162	java/lang/Exception
    //   2246	2257	7162	java/lang/Exception
    //   2267	2276	7162	java/lang/Exception
    //   2289	2302	7162	java/lang/Exception
    //   2312	2327	7162	java/lang/Exception
    //   2337	2346	7162	java/lang/Exception
    //   2107	2192	7177	java/lang/Exception
    //   2098	2107	7202	java/lang/Exception
    //   2064	2098	7215	java/lang/Exception
    //   6851	6866	7286	finally
    //   6881	6888	7286	finally
    //   6897	6985	7286	finally
  }
  
  private long b(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      label7:
      break label7;
    }
    return 0L;
  }
  
  private NowSummaryCard.LocationInfo b()
  {
    NowSummaryCard.LocationInfo localLocationInfo = new NowSummaryCard.LocationInfo();
    Object localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
    if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
    {
      localObject = ((SosoLbsInfo)localObject).mLocation;
      long l1 = Double.valueOf(((SosoLocation)localObject).mLat02 * 1000000.0D).longValue();
      long l2 = Double.valueOf(((SosoLocation)localObject).mLon02 * 1000000.0D).longValue();
      localLocationInfo.latitude.set(Long.valueOf(l1).longValue());
      localLocationInfo.longitude.set(Long.valueOf(l2).longValue());
    }
    return localLocationInfo;
  }
  
  private NowSummaryCard.ClientInfo c()
  {
    NowSummaryCard.ClientInfo localClientInfo = new NowSummaryCard.ClientInfo();
    localClientInfo.client_version.set(ByteStringMicro.copyFrom(AppSetting.h().getBytes()));
    localClientInfo.platform.set(2);
    localClientInfo.imei.set(ByteStringMicro.copyFrom(MobileInfoUtil.getImei().getBytes()));
    return localClientInfo;
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = "";
    Object localObject2 = Integer.valueOf(-1);
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      String str;
      if (paramToServiceMsg.extraData == null) {
        str = "";
      } else {
        str = paramToServiceMsg.extraData.getString("key_word");
      }
      if (paramToServiceMsg.extraData != null) {
        paramToServiceMsg.extraData.getInt("tag_type");
      }
      int i;
      if (paramToServiceMsg.extraData == null) {
        i = -1;
      } else {
        i = paramToServiceMsg.extraData.getInt("fetch_start");
      }
      int j;
      if (paramToServiceMsg.extraData == null) {
        j = -1;
      } else {
        j = paramToServiceMsg.extraData.getInt("person_flag");
      }
      cmd0x9c8.RspBody localRspBody = new cmd0x9c8.RspBody();
      int i2 = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (i2 == 0)
      {
        int k;
        if (localRspBody.uint32_tag_type.has()) {
          k = localRspBody.uint32_tag_type.get();
        } else {
          k = -1;
        }
        int m;
        if (localRspBody.uint32_next_pos.has()) {
          m = localRspBody.uint32_next_pos.get();
        } else {
          m = -1;
        }
        if (localRspBody.rpt_msg_tag_list.has()) {
          paramFromServiceMsg = localRspBody.rpt_msg_tag_list.get();
        } else {
          paramFromServiceMsg = null;
        }
        if (localRspBody.rpt_msg_sel_list.has()) {
          paramToServiceMsg = localRspBody.rpt_msg_sel_list.get();
        } else {
          paramToServiceMsg = null;
        }
        paramObject = this.c;
        localObject2 = paramObject.getEntityManagerFactory(paramObject.getAccount()).createEntityManager();
        int n;
        if ((i == 0) && (TextUtils.isEmpty(str)) && (paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty())) {
          n = 1;
        } else {
          n = 0;
        }
        if (n != 0)
        {
          paramObject = new StringBuilder();
          paramObject.append("DELETE FROM ");
          paramObject.append(InterestTagInfo.class.getSimpleName());
          paramObject.append(" WHERE ");
          paramObject.append("tagType = ");
          paramObject.append(k);
          paramObject.append(";");
          ((EntityManager)localObject2).execSQL(paramObject.toString());
          paramObject = this.c.getApplication();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("dating_pref");
          ((StringBuilder)localObject1).append(this.c.getCurrentAccountUin());
          paramObject = paramObject.getSharedPreferences(((StringBuilder)localObject1).toString(), 0).edit();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("list_last_update_time_");
          ((StringBuilder)localObject1).append(k);
          paramObject.putLong(((StringBuilder)localObject1).toString(), NetConnInfoCenter.getServerTimeMillis());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("list_fetch_pos_");
          ((StringBuilder)localObject1).append(k);
          paramObject.putInt(((StringBuilder)localObject1).toString(), m);
          paramObject.commit();
        }
        if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()))
        {
          localObject1 = new ArrayList();
          int i1 = 0;
          for (;;)
          {
            paramObject = localObject1;
            if (i1 >= paramFromServiceMsg.size()) {
              break;
            }
            paramObject = (InterestTagInfo)((IInterestTagInfoUtils)QRoute.api(IInterestTagInfoUtils.class)).convertFrom(paramFromServiceMsg.get(i1));
            if (paramObject != null)
            {
              paramObject.tagType = k;
              ((List)localObject1).add(paramObject);
              if (n != 0) {
                ((EntityManager)localObject2).persist(paramObject);
              }
            }
            i1 += 1;
          }
        }
        paramObject = null;
        ((EntityManager)localObject2).close();
        if ((paramToServiceMsg != null) && (!paramToServiceMsg.isEmpty()))
        {
          localObject1 = new ArrayList();
          n = 0;
          for (;;)
          {
            paramFromServiceMsg = (FromServiceMsg)localObject1;
            if (n >= paramToServiceMsg.size()) {
              break;
            }
            paramFromServiceMsg = (InterestTagInfo)((IInterestTagInfoUtils)QRoute.api(IInterestTagInfoUtils.class)).convertFrom(paramToServiceMsg.get(n));
            if (paramFromServiceMsg != null) {
              ((List)localObject1).add(paramFromServiceMsg);
            }
            n += 1;
          }
        }
        paramFromServiceMsg = null;
        notifyUI(1, true, new Object[] { Integer.valueOf(k), Integer.valueOf(m), paramObject, paramFromServiceMsg, str, Integer.valueOf(i), Integer.valueOf(j), null });
        NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(true), Integer.valueOf(k), Integer.valueOf(m), paramObject, paramFromServiceMsg, str, Integer.valueOf(i), Integer.valueOf(j) });
        return;
      }
      paramToServiceMsg = (ToServiceMsg)localObject1;
      if (localRspBody.str_error.has()) {
        paramToServiceMsg = localRspBody.str_error.get();
      }
      notifyUI(1, false, new Object[] { localObject2, localObject2, null, null, str, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
      NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(false), paramToServiceMsg });
      return;
    }
    notifyUI(1, false, new Object[] { localObject2, localObject2, null, null, "", localObject2, localObject2, HardCodeUtil.a(2131904985) });
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "handleEditProfileCard");
    }
    EntityManager localEntityManager = null;
    Object localObject1 = null;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      cmd0x9c9.RspBody localRspBody = new cmd0x9c9.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      long l2 = SystemClock.elapsedRealtime();
      long l3 = paramToServiceMsg.extraData.getLong("startSaveTime");
      boolean bool1;
      if (paramToServiceMsg.extraData.containsKey("is_head_changed")) {
        bool1 = paramToServiceMsg.extraData.getBoolean("is_head_changed");
      } else {
        bool1 = false;
      }
      paramObject = "";
      label430:
      boolean bool2;
      if (i == 0)
      {
        paramFromServiceMsg = this.c;
        localEntityManager = paramFromServiceMsg.getEntityManagerFactory(paramFromServiceMsg.getAccount()).createEntityManager();
        Object localObject2 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.c.getCurrentAccountUin() });
        paramFromServiceMsg = (FromServiceMsg)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new NearbyPeopleCard();
          ((NearbyPeopleCard)localObject2).uin = this.c.getCurrentAccountUin();
          paramFromServiceMsg = (FromServiceMsg)localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("NearbyPeopleProfileActivity", 2, "handleEditProfileCard get nearbyCard from db is null.");
            paramFromServiceMsg = (FromServiceMsg)localObject2;
          }
        }
        if (paramToServiceMsg.extraData.getBoolean("is_lost_god_flag")) {
          paramFromServiceMsg.godFlag = false;
        }
        if (localRspBody.bytes_rspbody_5ea.has()) {
          localObject1 = localRspBody.bytes_rspbody_5ea.get().toByteArray();
        }
        localObject1 = paramFromServiceMsg.updateEditPicInfos((byte[])localObject1, (PicInfo)paramToServiceMsg.extraData.getParcelable("avatar_picinfo"));
        if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
          NearbySPUtil.b(this.c.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(1));
        }
        localObject1 = paramToServiceMsg.extraData.getByteArray("9c7_body");
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          try
          {
            localObject2 = new cmd0x9c7.ReqBody();
            ((cmd0x9c7.ReqBody)localObject2).mergeFrom((byte[])localObject1);
            try
            {
              paramFromServiceMsg.updateInterestTags(paramFromServiceMsg.tagFlag, ((cmd0x9c7.ReqBody)localObject2).rpt_msg_tags.get());
            }
            catch (Exception localException1) {}
            if (!NearbyCardConstants.a) {
              break label430;
            }
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("rsp_9c7");
            ((StringBuilder)localObject2).append(localException2.getMessage());
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
          }
        }
        if (paramToServiceMsg.extraData.containsKey("key_xuan_yan")) {
          paramFromServiceMsg.xuanYan = paramToServiceMsg.extraData.getByteArray("key_xuan_yan");
        }
        if (paramToServiceMsg.extraData.containsKey("key_new_nickname")) {
          paramFromServiceMsg.nickname = paramToServiceMsg.extraData.getString("key_new_nickname");
        }
        if (paramToServiceMsg.extraData.containsKey("key_marital_status")) {
          paramFromServiceMsg.maritalStatus = paramToServiceMsg.extraData.getByte("key_marital_status");
        }
        NearbyCardManager localNearbyCardManager;
        if (paramToServiceMsg.extraData.containsKey("sex"))
        {
          paramFromServiceMsg.gender = paramToServiceMsg.extraData.getByte("sex");
          localNearbyCardManager = (NearbyCardManager)this.c.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
          if (localNearbyCardManager != null) {
            localNearbyCardManager.c(paramFromServiceMsg.gender);
          }
        }
        if (paramToServiceMsg.extraData.containsKey("birthday"))
        {
          paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
          paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
          paramFromServiceMsg.constellation = ((byte)paramToServiceMsg.extraData.getInt("key_constellation"));
          localNearbyCardManager = (NearbyCardManager)this.c.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
          if (localNearbyCardManager != null) {
            localNearbyCardManager.b(paramFromServiceMsg.age);
          }
        }
        if (paramToServiceMsg.extraData.containsKey("profession")) {
          paramFromServiceMsg.job = paramToServiceMsg.extraData.getInt("profession");
        }
        if (paramToServiceMsg.extraData.containsKey("company")) {
          paramFromServiceMsg.company = paramToServiceMsg.extraData.getString("company");
        }
        if (paramToServiceMsg.extraData.containsKey("college"))
        {
          paramFromServiceMsg.college = paramToServiceMsg.extraData.getString("college");
          try
          {
            NearbySPUtil.b(this.c.getCurrentAccountUin(), "self_school_name", paramFromServiceMsg.college);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        if (paramToServiceMsg.extraData.containsKey("hometown"))
        {
          String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("hometown");
          paramFromServiceMsg.hometownCountry = arrayOfString[0];
          paramFromServiceMsg.hometownProvice = arrayOfString[1];
          paramFromServiceMsg.hometownCity = arrayOfString[2];
          paramFromServiceMsg.hometownDistrict = arrayOfString[3];
        }
        if (paramToServiceMsg.extraData.containsKey("key_qzone_switch"))
        {
          if (paramToServiceMsg.extraData.getShort("key_qzone_switch") == 0) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          paramFromServiceMsg.switchQzone = bool2;
        }
        if (paramToServiceMsg.extraData.containsKey("key_hobby_switch"))
        {
          if (paramToServiceMsg.extraData.getShort("key_hobby_switch") == 0) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          paramFromServiceMsg.switchHobby = bool2;
        }
        if (paramToServiceMsg.extraData.containsKey("key_flower_visible_switch"))
        {
          long l1;
          if (paramToServiceMsg.extraData.getShort("key_flower_visible_switch") == 0) {
            l1 = 0L;
          } else {
            l1 = 1L;
          }
          paramFromServiceMsg.switchGiftVisible = l1;
        }
        if (paramFromServiceMsg.getStatus() == 1000) {
          localEntityManager.persistOrReplace(paramFromServiceMsg);
        } else if ((paramFromServiceMsg.getStatus() == 1001) || (paramFromServiceMsg.getStatus() == 1002)) {
          localEntityManager.update(paramFromServiceMsg);
        }
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = true;
      }
      else
      {
        paramToServiceMsg = paramObject;
        if (localRspBody.str_errorinfo.has()) {
          paramToServiceMsg = localRspBody.str_errorinfo.get();
        }
        bool2 = false;
        paramObject = paramToServiceMsg;
        paramToServiceMsg = localEntityManager;
      }
      notifyUI(3, bool2, new Object[] { paramToServiceMsg, Boolean.valueOf(bool1), paramObject });
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("errorCode", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.d.getCurrentAccountUin(), "actEditNearbyProfile", bool2, l2 - l3, 0L, paramFromServiceMsg, "");
      NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c9_0", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), paramToServiceMsg, paramObject });
      return;
    }
    notifyUI(3, false, null);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    NearbyCmdHelper.e(this, 9, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (i != 0) {
          break label841;
        }
        bool = true;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("rspNearbyCharmEvent,result code：");
          paramFromServiceMsg.append(i);
          paramFromServiceMsg.append(",isSuccess:");
          paramFromServiceMsg.append(bool);
          QLog.d("Q.nearby", 2, paramFromServiceMsg.toString());
        }
        if (bool)
        {
          paramFromServiceMsg = new Oidb_0x686.RspBody();
          i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
          paramFromServiceMsg.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
          bool = paramFromServiceMsg.uint32_config_seq.has();
          int j;
          if (bool)
          {
            j = paramFromServiceMsg.uint32_config_seq.get();
            NearbySPUtil.b(this.d.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(j));
          }
          if (paramFromServiceMsg.uint32_config_time.has())
          {
            j = paramFromServiceMsg.uint32_config_time.get();
            NearbySPUtil.b(this.d.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(j));
          }
          bool = paramFromServiceMsg.msg_rank_config.has();
          Oidb_0x686.CharmEvent localCharmEvent = null;
          if (!bool) {
            break label847;
          }
          paramObject = (Oidb_0x686.NearbyRankConfig)paramFromServiceMsg.msg_rank_config.get();
          if (!paramFromServiceMsg.msg_feed_config.has()) {
            break label852;
          }
          localObject = (Oidb_0x686.NearbyFeedConfig)paramFromServiceMsg.msg_feed_config.get();
          if ((i == 2) && (paramFromServiceMsg.msg_charm_event.has()))
          {
            localCharmEvent = (Oidb_0x686.CharmEvent)paramFromServiceMsg.msg_charm_event.get();
            paramFromServiceMsg = null;
          }
          else
          {
            if ((i != 1) || (!paramFromServiceMsg.msg_notify_event.has())) {
              break label858;
            }
            paramFromServiceMsg = (Oidb_0x686.NearbyCharmNotify)paramFromServiceMsg.msg_notify_event.get();
          }
          NearbyManagerHelper.a(this.c).a(paramToServiceMsg.getUin(), paramObject, localObject, localCharmEvent, paramFromServiceMsg);
          paramToServiceMsg = "";
          int k;
          int m;
          int n;
          int i1;
          if ((localCharmEvent != null) && (localCharmEvent.uint32_pop_flag.get() == 1))
          {
            i = localCharmEvent.uint32_old_charm.get();
            j = localCharmEvent.uint32_old_charm_level.get();
            k = localCharmEvent.uint32_new_charm.get();
            m = localCharmEvent.uint32_new_charm_level.get();
            n = localCharmEvent.uint32_cur_level_threshold.get();
            i1 = localCharmEvent.uint32_next_level_threshold.get();
            paramFromServiceMsg = localCharmEvent.str_tips_content.get();
            if (paramFromServiceMsg != null) {
              break label863;
            }
            notifyUI(60, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramToServiceMsg });
            paramToServiceMsg = "0X80052B1";
            if (k - i < 0) {
              paramToServiceMsg = "0X80052B2";
            }
            AppIntefaceReportWrap.a(this.d, "CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
            return;
          }
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_pop_flag.get() == 1))
          {
            i = paramFromServiceMsg.uint32_old_charm.get();
            j = paramFromServiceMsg.uint32_old_charm_level.get();
            k = paramFromServiceMsg.uint32_new_charm.get();
            m = paramFromServiceMsg.uint32_new_charm_level.get();
            n = paramFromServiceMsg.uint32_cur_level_threshold.get();
            i1 = paramFromServiceMsg.uint32_next_level_threshold.get();
            int i2 = paramFromServiceMsg.uint32_old_prof_percent.get();
            int i3 = paramFromServiceMsg.uint32_new_prof_percent.get();
            paramFromServiceMsg = paramFromServiceMsg.str_tips_content.get();
            paramToServiceMsg = paramFromServiceMsg;
            if (paramFromServiceMsg == null) {
              paramToServiceMsg = "";
            }
            notifyUI(61, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramToServiceMsg });
            paramToServiceMsg = "0X80052AE";
            if (k - i < 0) {
              paramToServiceMsg = "0X80052AF";
            }
            AppIntefaceReportWrap.a(this.d, "CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("NearbyCardHandler", 2, paramToServiceMsg, new Object[0]);
        }
      }
      return;
      label841:
      boolean bool = false;
      continue;
      label847:
      paramObject = null;
      continue;
      label852:
      Object localObject = null;
      continue;
      label858:
      paramFromServiceMsg = null;
      continue;
      label863:
      paramToServiceMsg = paramFromServiceMsg;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("isNearbyPeopleCard")) {
      return;
    }
    long l2 = paramToServiceMsg.extraData.getLong("startFetchTime");
    long l3 = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetSummaryCard() , resp.getResultCode() = ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      QLog.i("Q.profilecard.SummaryCard", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = 0L;
    if (QLog.isDevelopLevel()) {
      l1 = System.currentTimeMillis();
    }
    int i = paramFromServiceMsg.getResultCode();
    StringBuilder localStringBuilder = null;
    Object localObject = null;
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool3 = true;
    boolean bool2 = false;
    if ((bool1) && ((paramObject instanceof RespSummaryCard))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (SummaryCard.RespHead)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new SummaryCard.RespHead());
        if (paramFromServiceMsg == null) {
          break label411;
        }
        localObject = paramFromServiceMsg;
      }
      catch (Exception localException1)
      {
        try
        {
          if (paramFromServiceMsg.iResult != 0) {
            break label411;
          }
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleGetSummaryCard() , SummaryCard.RespHead.iResult = ");
            if (paramFromServiceMsg == null) {
              localObject = "null";
            } else {
              localObject = Integer.valueOf(paramFromServiceMsg.iResult);
            }
            localStringBuilder.append(localObject);
            QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
          }
          localObject = paramFromServiceMsg;
        }
        catch (Exception localException2)
        {
          break label257;
        }
        localException1 = localException1;
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      label257:
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.profilecard.SummaryCard", 2, localException1.toString());
        localObject = paramFromServiceMsg;
        bool1 = bool2;
        break label296;
        localObject = localException1;
      }
      label296:
      a(bool1, paramObject, paramToServiceMsg.extraData, (SummaryCard.RespHead)localObject);
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("errorCode", String.valueOf(i));
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.d.getCurrentAccountUin(), "actGetNearbySummaryCard", bool1, l3 - l2, 0L, paramToServiceMsg, "");
      if (QLog.isDevelopLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetSummaryCard, cost = ");
        paramToServiceMsg.append(System.currentTimeMillis() - l1);
        QLog.i("Q.profilecard.SummaryCard", 4, paramToServiceMsg.toString());
      }
      return;
      label411:
      bool1 = false;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("CardHandler.handleUpdateNearbyPeopleAuthVideo, isSuccess: ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      QLog.d("Q.nearby_people_card.update_auth_video", 2, paramToServiceMsg.toString());
    }
    Object localObject = null;
    boolean bool6 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = bool1;
    paramToServiceMsg = localObject;
    if (bool6)
    {
      bool3 = bool1;
      paramToServiceMsg = localObject;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool1 = bool4;
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg != null)
          {
            bool3 = bool5;
            bool1 = bool4;
            if (paramFromServiceMsg.uint32_result.get() == 0) {
              bool3 = true;
            }
            bool2 = bool3;
            bool1 = bool3;
            if (QLog.isColorLevel())
            {
              bool1 = bool3;
              paramToServiceMsg = new StringBuilder();
              bool1 = bool3;
              paramToServiceMsg.append("CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = ");
              bool1 = bool3;
              paramToServiceMsg.append(paramFromServiceMsg.uint32_result.get());
              bool1 = bool3;
              QLog.d("Q.nearby_people_card.update_auth_video", 2, paramToServiceMsg.toString());
              bool2 = bool3;
            }
          }
          bool3 = bool2;
          paramToServiceMsg = localObject;
          if (bool2)
          {
            bool1 = bool2;
            paramToServiceMsg = ((UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray())).msg_verify_video_info.get();
            bool3 = bool2;
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          bool3 = bool1;
          paramToServiceMsg = localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.update_auth_video", 2, paramFromServiceMsg.toString());
            paramToServiceMsg = localObject;
            bool3 = bool1;
          }
        }
      }
    }
    notifyUI(47, bool3, paramToServiceMsg);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("CardHandler.handleDeleteNearbyPeopleAuthVideo, isSuccess: ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      QLog.d("Q.nearby_people_card.delete_auth_video", 2, paramToServiceMsg.toString());
    }
    boolean bool3 = paramFromServiceMsg.isSuccess();
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool2 = bool5;
    if (bool3)
    {
      bool2 = bool5;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool3 = bool4;
        try
        {
          paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          bool2 = bool5;
          if (paramToServiceMsg != null)
          {
            bool3 = bool4;
            if (paramToServiceMsg.uint32_result.get() == 0) {
              bool1 = true;
            }
            bool3 = bool1;
            bool2 = bool1;
            if (QLog.isColorLevel())
            {
              bool3 = bool1;
              paramFromServiceMsg = new StringBuilder();
              bool3 = bool1;
              paramFromServiceMsg.append("CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = ");
              bool3 = bool1;
              paramFromServiceMsg.append(paramToServiceMsg.uint32_result.get());
              bool3 = bool1;
              QLog.d("Q.nearby_people_card.delete_auth_video", 2, paramFromServiceMsg.toString());
              bool2 = bool1;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          bool2 = bool3;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.delete_auth_video", 2, paramToServiceMsg.toString());
            bool2 = bool3;
          }
        }
      }
    }
    notifyUI(49, bool2, null);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("CardHandler.handleUpdateNearbyPeoplePhotoList(), isSuccess: ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      QLog.d("Q.nearby_people_card.update_photo_list", 2, paramToServiceMsg.toString());
    }
    boolean bool6 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = bool1;
    if (bool6)
    {
      bool3 = bool1;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool1 = bool4;
        try
        {
          paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramToServiceMsg != null)
          {
            bool3 = bool5;
            bool1 = bool4;
            if (paramToServiceMsg.uint32_result.get() == 0) {
              bool3 = true;
            }
            bool2 = bool3;
            bool1 = bool3;
            if (QLog.isColorLevel())
            {
              bool1 = bool3;
              paramFromServiceMsg = new StringBuilder();
              bool1 = bool3;
              paramFromServiceMsg.append("CardHandler.handleUpdateNearbyPeoplePhotoList(), oidbPkg.uint32_result = ");
              bool1 = bool3;
              paramFromServiceMsg.append(paramToServiceMsg.uint32_result.get());
              bool1 = bool3;
              QLog.d("Q.nearby_people_card.update_photo_list", 2, paramFromServiceMsg.toString());
              bool2 = bool3;
            }
          }
          bool3 = bool2;
          if (bool2)
          {
            bool1 = bool2;
            NearbyCardManager.c(this.c);
            bool3 = bool2;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          bool3 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.update_photo_list", 2, paramToServiceMsg.toString());
            bool3 = bool1;
          }
        }
      }
    }
    notifyUI(46, bool3, null);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("CardHandler.handleImportQzonePhotoes(), FromServiceMsg isSuccess: ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramToServiceMsg.toString());
    }
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    boolean bool4 = paramFromServiceMsg.isSuccess();
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    paramToServiceMsg = localObject4;
    if (bool4)
    {
      bool1 = bool3;
      paramToServiceMsg = localObject4;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          bool1 = bool3;
          paramToServiceMsg = localObject4;
          if (paramFromServiceMsg == null) {
            break label386;
          }
          bool1 = bool3;
          paramToServiceMsg = localObject4;
          if (!paramFromServiceMsg.uint32_result.has()) {
            break label386;
          }
          int i = paramFromServiceMsg.uint32_result.get();
          if (i == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramToServiceMsg = localObject1;
          try
          {
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = localObject1;
              paramObject = new StringBuilder();
              paramToServiceMsg = localObject1;
              paramObject.append("oidbPkg.uint32_result = ");
              paramToServiceMsg = localObject1;
              paramObject.append(paramFromServiceMsg.uint32_result.get());
              paramToServiceMsg = localObject1;
              QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramObject.toString());
            }
            paramToServiceMsg = localObject2;
            if (bool1)
            {
              paramToServiceMsg = localObject1;
              paramObject = (UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
              paramToServiceMsg = localObject1;
              paramFromServiceMsg = new Object[5];
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg[0] = paramObject.rpt_msg_headinfo.get();
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg[1] = Integer.valueOf(paramObject.uint32_import_state.get());
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg[2] = Integer.valueOf(paramObject.uint32_import_count.get());
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg[3] = Integer.valueOf(paramObject.uint32_import_rest_count.get());
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg[4] = Integer.valueOf(paramObject.uint32_rest_count_in_qzone.get());
              paramToServiceMsg = paramFromServiceMsg;
            }
          }
          catch (InvalidProtocolBufferMicroException paramObject)
          {
            bool2 = bool1;
            paramFromServiceMsg = paramToServiceMsg;
          }
          bool1 = bool2;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          paramFromServiceMsg = localObject3;
        }
        paramToServiceMsg = paramFromServiceMsg;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramObject.toString());
          paramToServiceMsg = paramFromServiceMsg;
          bool1 = bool2;
        }
      }
    }
    label386:
    notifyUI(48, bool1, paramToServiceMsg);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("CardHandler.handleQueryImportQzonePhotoesStatus(), FromServiceMsg isSuccess: ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, paramToServiceMsg.toString());
    }
    List localList = null;
    Object localObject1 = null;
    Object localObject2 = null;
    UpdatePhotoList.HeadInfo localHeadInfo = null;
    boolean bool4 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    boolean bool1 = bool3;
    paramToServiceMsg = localObject2;
    if (bool4)
    {
      bool1 = bool3;
      paramToServiceMsg = localObject2;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          bool1 = bool3;
          paramToServiceMsg = localObject2;
          if (paramObject == null) {
            break label654;
          }
          bool1 = bool3;
          paramToServiceMsg = localObject2;
          if (!paramObject.uint32_result.has()) {
            break label654;
          }
          int j = paramObject.uint32_result.get();
          if (j == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramToServiceMsg = localList;
          try
          {
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = localList;
              paramFromServiceMsg = new StringBuilder();
              paramToServiceMsg = localList;
              paramFromServiceMsg.append("CardHandler.handleQueryImportQzonePhotoesStatus(), oidbPkg.uint32_result = ");
              paramToServiceMsg = localList;
              paramFromServiceMsg.append(paramObject.uint32_result.get());
              paramToServiceMsg = localList;
              QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, paramFromServiceMsg.toString());
            }
            paramFromServiceMsg = localHeadInfo;
            if (bool1)
            {
              paramToServiceMsg = localList;
              paramFromServiceMsg = (UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
              paramToServiceMsg = localList;
              paramObject = new Object[5];
              paramToServiceMsg = paramObject;
              paramObject[0] = paramFromServiceMsg.rpt_msg_headinfo.get();
              paramToServiceMsg = paramObject;
              paramObject[1] = Integer.valueOf(paramFromServiceMsg.uint32_import_state.get());
              paramToServiceMsg = paramObject;
              paramObject[2] = Integer.valueOf(paramFromServiceMsg.uint32_import_count.get());
              paramToServiceMsg = paramObject;
              paramObject[3] = Integer.valueOf(paramFromServiceMsg.uint32_import_rest_count.get());
              paramToServiceMsg = paramObject;
              paramObject[4] = Integer.valueOf(paramFromServiceMsg.uint32_rest_count_in_qzone.get());
              paramFromServiceMsg = paramObject;
              paramToServiceMsg = paramObject;
              if (QLog.isColorLevel())
              {
                paramToServiceMsg = paramObject;
                paramFromServiceMsg = new StringBuilder();
                paramToServiceMsg = paramObject;
                paramFromServiceMsg.append("CardHandler.handleQueryImportQzonePhotoesStatus(), head_info = ");
                if (paramObject[0] != null)
                {
                  paramToServiceMsg = paramObject;
                  localList = (List)paramObject[0];
                  for (;;)
                  {
                    paramToServiceMsg = paramObject;
                    if (i >= localList.size()) {
                      break;
                    }
                    paramToServiceMsg = paramObject;
                    localHeadInfo = (UpdatePhotoList.HeadInfo)localList.get(i);
                    paramToServiceMsg = paramObject;
                    paramFromServiceMsg.append("head_id = ");
                    paramToServiceMsg = paramObject;
                    paramFromServiceMsg.append(localHeadInfo.uint32_headid.get());
                    paramToServiceMsg = paramObject;
                    paramFromServiceMsg.append(", head_url = ");
                    paramToServiceMsg = paramObject;
                    paramFromServiceMsg.append(localHeadInfo.str_headurl.get());
                    paramToServiceMsg = paramObject;
                    paramFromServiceMsg.append(", is_avatar = ");
                    paramToServiceMsg = paramObject;
                    paramFromServiceMsg.append(localHeadInfo.uint32_is_curhead.get());
                    paramToServiceMsg = paramObject;
                    paramFromServiceMsg.append("|");
                    i += 1;
                  }
                }
                paramToServiceMsg = paramObject;
                paramFromServiceMsg.append(", import_status = ");
                paramToServiceMsg = paramObject;
                paramFromServiceMsg.append(paramObject[1]);
                paramToServiceMsg = paramObject;
                paramFromServiceMsg.append(", imported_count = ");
                paramToServiceMsg = paramObject;
                paramFromServiceMsg.append(paramObject[2]);
                paramToServiceMsg = paramObject;
                paramFromServiceMsg.append(", rest_count = ");
                paramToServiceMsg = paramObject;
                paramFromServiceMsg.append(paramObject[3]);
                paramToServiceMsg = paramObject;
                paramFromServiceMsg.append(", rest_count_in_old_photo_wall = ");
                paramToServiceMsg = paramObject;
                paramFromServiceMsg.append(paramObject[4]);
                paramToServiceMsg = paramObject;
                QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, paramFromServiceMsg.toString());
                paramFromServiceMsg = paramObject;
              }
            }
            paramToServiceMsg = paramFromServiceMsg;
          }
          catch (InvalidProtocolBufferMicroException paramObject)
          {
            bool2 = bool1;
            paramFromServiceMsg = paramToServiceMsg;
          }
          bool1 = bool2;
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          paramFromServiceMsg = localObject1;
        }
        paramToServiceMsg = paramFromServiceMsg;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, paramObject.toString());
          paramToServiceMsg = paramFromServiceMsg;
          bool1 = bool2;
        }
      }
    }
    label654:
    notifyUI(50, bool1, paramToServiceMsg);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp)))
    {
      paramToServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
      bool = true;
    }
    else
    {
      paramToServiceMsg = null;
      bool = false;
    }
    notifyUI(40, bool, new Object[] { str, paramToServiceMsg });
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("nearby_people")) {
      return;
    }
    Object localObject1 = paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = new HashMap();
    paramObject = new Bundle();
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    int k = paramToServiceMsg.extraData.getInt("from");
    paramObject.putString("targetUin", Long.toString(l1));
    paramObject.putString("selfUin", Long.toString(l2));
    paramObject.putInt("favoriteSource", i);
    paramObject.putInt("iCount", j);
    paramObject.putInt("from", k);
    boolean bool;
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)localObject1;
      if (paramToServiceMsg.stHeader.iReplyCode == 0) {
        paramFromServiceMsg.put("param_FailCode", "0");
      }
      for (bool = true;; bool = false)
      {
        break;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("back reqFavorite| result = ");
          ((StringBuilder)localObject1).append(false);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(l1);
          ((StringBuilder)localObject1).append(",replyCode=");
          ((StringBuilder)localObject1).append(paramToServiceMsg.stHeader.iReplyCode);
          QLog.i("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
        }
        paramFromServiceMsg.put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      }
      StatisticCollector.getInstance(this.d.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", bool, 0L, 0L, paramFromServiceMsg, "", false);
      paramToServiceMsg = "Q.profilecard.";
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("back reqFavorite| result = ");
        ((StringBuilder)localObject2).append(false);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(",obj is");
        if (localObject1 != null) {
          paramToServiceMsg = "not RespFavorite";
        } else {
          paramToServiceMsg = "null";
        }
        ((StringBuilder)localObject2).append(paramToServiceMsg);
        QLog.i("Q.profilecard.", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 != null) {
        paramToServiceMsg = "-201";
      } else {
        paramToServiceMsg = "-202";
      }
      paramFromServiceMsg.put("param_FailCode", paramToServiceMsg);
      localObject1 = StatisticCollector.getInstance(this.d.getApp());
      paramToServiceMsg = "Q.profilecard.";
      ((StatisticCollector)localObject1).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramFromServiceMsg, "", false);
      bool = false;
    }
    paramFromServiceMsg = this;
    if (bool)
    {
      l2 = l1;
      if (l2 > 0L)
      {
        localObject1 = paramFromServiceMsg.c.getEntityManagerFactory().createEntityManager();
        localObject2 = (NearbyPeopleCard)((EntityManager)localObject1).find(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(l2) });
        if (localObject2 != null)
        {
          ((NearbyPeopleCard)localObject2).likeCount += j;
          ((NearbyPeopleCard)localObject2).bVoted = 1;
          ((NearbyPeopleCard)localObject2).bAvailVoteCnt = ((short)(((NearbyPeopleCard)localObject2).bAvailVoteCnt - j));
          if (((NearbyPeopleCard)localObject2).bAvailVoteCnt < 0) {
            ((NearbyPeopleCard)localObject2).bAvailVoteCnt = 0;
          }
          ((EntityManager)localObject1).update((Entity)localObject2);
        }
        VoteUtil.a(paramFromServiceMsg.c, l2, j);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("back reqFavorite| result = ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(j);
      QLog.i(paramToServiceMsg, 2, ((StringBuilder)localObject1).toString());
    }
    paramFromServiceMsg.notifyUI(32, bool, paramObject);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handle0x8b4Rsp");
    }
    Object localObject;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000) {
        bool = false;
      } else {
        bool = true;
      }
      localObject = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      localObject = localOIDBSSOPkg;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label76:
      break label76;
    }
    if (QLog.isColorLevel()) {
      QLog.e("NearbyCardHandler", 2, "handle0x8b4Rsp InvalidProtocolBufferMicroException");
    }
    boolean bool = false;
    if (localObject == null) {
      return;
    }
    if ((((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null)) {
      break label142;
    }
    bool = false;
    label142:
    if (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get() == 4) {
      a(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, "CardHandler.queryImportQzonePhotoesStatus()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(4);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5ea_4");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = new Oidb_0x686.ReqBody();
    Object localObject2 = LbsUtils.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((Oidb_0x686.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    int i = ((Integer)NearbySPUtil.a(this.d.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_seq.set(i);
    i = ((Integer)NearbySPUtil.a(this.d.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_time.set(i);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1670);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x686.ReqBody)localObject1).toByteArray()));
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.h());
    localObject1 = createToServiceMsg("OidbSvc.0x686");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reqCharmEvent() uin=");
      ((StringBuilder)localObject2).append(((ToServiceMsg)localObject1).getUin());
      ((StringBuilder)localObject2).append(", type=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", seqNum=");
      ((StringBuilder)localObject2).append(i);
      QLog.d("Charm", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.importQzonePhotoes()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    ((UpdatePhotoList.ReqBody)localObject).uint32_copy_count_from_qzone.set(paramInt1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5ea_3");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    NearbyCmdHelper.a(this, paramLong, paramInt, paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getNearbyLikeLimitInfo, uin=");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(", tinyId=");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(", from=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject3 = ((TicketManager)this.c.getManager(2)).getSkey(this.c.getCurrentAccountUin());
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyLikeLimitManager", 2, "getNearbyLikeLimitInfo, skey==null, return");
      }
      return;
    }
    Object localObject1 = new oidb_0x8e7.ReqBody();
    ((oidb_0x8e7.ReqBody)localObject1).bool_stock.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_is_first.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_warn.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_update_url.set(true);
    if (paramLong1 > 0L) {
      ((oidb_0x8e7.ReqBody)localObject1).uint64_uin.set(paramLong1);
    } else if (paramLong2 > 0L) {
      ((oidb_0x8e7.ReqBody)localObject1).uint64_tinyid.set(paramLong2);
    }
    Object localObject2 = new oidb_0x8e7.LoginSig();
    ((oidb_0x8e7.LoginSig)localObject2).uint32_type.set(1);
    ((oidb_0x8e7.LoginSig)localObject2).bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject3).getBytes()));
    localObject3 = new oidb_0x8e7.ExtParam();
    ((oidb_0x8e7.ExtParam)localObject3).uint32_client.set(1);
    ((oidb_0x8e7.ExtParam)localObject3).uint32_portal.set(paramInt);
    ((oidb_0x8e7.ExtParam)localObject3).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.h().getBytes()));
    ((oidb_0x8e7.ExtParam)localObject3).msg_login_sig.set((MessageMicro)localObject2);
    ((oidb_0x8e7.ReqBody)localObject1).msg_ext_parm.set((MessageMicro)localObject3);
    localObject1 = makeOIDBPkg("OidbSvc.0x8e7_1", 2279, 1, ((oidb_0x8e7.ReqBody)localObject1).toByteArray());
    localObject2 = ((ToServiceMsg)localObject1).extraData;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramLong1);
    ((StringBuilder)localObject3).append("");
    ((Bundle)localObject2).putString("uin", ((StringBuilder)localObject3).toString());
    ((ToServiceMsg)localObject1).extraData.putInt("from", paramInt);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, String.format("nearbyPeopleLike|%d|%d|likeSource=%d", new Object[] { Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putBoolean("nearby_people", true);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    send(localToServiceMsg);
  }
  
  public void a(Bundle paramBundle, ArrayList<Object> paramArrayList, Object[] paramArrayOfObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject2 = (InterestTag[])paramArrayOfObject;
    if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "editProfileCard");
    }
    cmd0x9c9.ReqBody localReqBody = new cmd0x9c9.ReqBody();
    Object localObject1;
    boolean bool;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      UpdatePhotoList.ReqBody localReqBody1 = new UpdatePhotoList.ReqBody();
      Iterator localIterator = paramArrayList.iterator();
      paramBoolean3 = false;
      while (localIterator.hasNext())
      {
        PicInfo localPicInfo = (PicInfo)localIterator.next();
        if (localPicInfo.a >= 0)
        {
          localObject1 = new UpdatePhotoList.RichHead();
          ((UpdatePhotoList.RichHead)localObject1).uint32_headid.set(localPicInfo.a);
          paramArrayOfObject = (Object[])localObject1;
          if (!TextUtils.isEmpty(localPicInfo.g))
          {
            ((UpdatePhotoList.RichHead)localObject1).str_video_id.set(localPicInfo.g);
            paramArrayOfObject = (Object[])localObject1;
          }
        }
        else
        {
          paramArrayOfObject = null;
        }
        if (paramArrayOfObject != null)
        {
          localReqBody1.rpt_msg_rich_headids.add(paramArrayOfObject);
          paramBoolean3 = true;
        }
      }
      if (paramBoolean3)
      {
        paramArrayOfObject = LbsUtils.a(getClass().getSimpleName());
        if (paramArrayOfObject != null) {
          localReqBody1.msg_lbs_info.set(paramArrayOfObject);
        }
        localReqBody.bytes_reqbody_5ea.set(ByteStringMicro.copyFrom(localReqBody1.toByteArray()));
      }
      bool = paramBoolean3;
      if (QLog.isColorLevel())
      {
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append("editProfileCard, photoList = ");
        paramArrayOfObject.append(paramArrayList);
        paramArrayOfObject.append(", isHasNearbyAvatar = ");
        paramArrayOfObject.append(paramBoolean3);
        QLog.d("Q.nearby_people_card.", 2, paramArrayOfObject.toString());
        bool = paramBoolean3;
      }
    }
    else
    {
      bool = false;
    }
    int j;
    int i;
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      localObject1 = new cmd0x9c7.ReqBody();
      ((cmd0x9c7.ReqBody)localObject1).uint32_set_mode.set(0);
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfObject = localObject2[i];
        if (paramArrayOfObject != null) {
          ((cmd0x9c7.ReqBody)localObject1).rpt_msg_tags.add((appoint_define.InterestTag)((IInterestTagUtils)QRoute.api(IInterestTagUtils.class)).convertTo(paramArrayOfObject));
        }
        i += 1;
      }
      localReqBody.bytes_reqbody_9c7.set(ByteStringMicro.copyFrom(((cmd0x9c7.ReqBody)localObject1).toByteArray()));
      paramArrayOfObject = (Object[])localObject1;
      if (NearbyCardConstants.a)
      {
        paramArrayOfObject = (Object[])localObject1;
        if (QLog.isColorLevel())
        {
          paramArrayOfObject = new StringBuilder();
          i = 0;
          while (i < localObject2.length)
          {
            paramArrayOfObject.append(localObject2[i].toString());
            paramArrayOfObject.append(",");
            i += 1;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("editProfileCard, tags = ");
          ((StringBuilder)localObject2).append(paramArrayOfObject.toString());
          QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
          paramArrayOfObject = (Object[])localObject1;
        }
      }
    }
    else
    {
      paramArrayOfObject = null;
    }
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("nick"))
      {
        localObject1 = paramBundle.getString("nick");
        localReqBody.str_nick.set((String)localObject1);
        if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("str_nick|");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
        }
        j = 1;
      }
      else
      {
        j = 0;
      }
      i = j;
      int k;
      if (paramBundle.containsKey("sex"))
      {
        j += 1;
        k = paramBundle.getByte("sex") + 1;
        localReqBody.uint32_gender.set(k);
        i = j;
        if (NearbyCardConstants.a)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("uint32_gender|");
            ((StringBuilder)localObject1).append(k);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            i = j;
          }
        }
      }
      j = i;
      if (paramBundle.containsKey("college"))
      {
        i += 1;
        localObject1 = paramBundle.getString("college");
        localReqBody.str_college.set((String)localObject1);
        j = i;
        if (NearbyCardConstants.a)
        {
          j = i;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("str_college|");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
            j = i;
          }
        }
      }
      i = j;
      if (paramBundle.containsKey("key_constellation"))
      {
        j += 1;
        k = paramBundle.getInt("key_constellation");
        localReqBody.uint32_constellation.set(k);
        i = j;
        if (NearbyCardConstants.a)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("uint32_constellation|");
            ((StringBuilder)localObject1).append(k);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            i = j;
          }
        }
      }
      j = i;
      if (paramBundle.containsKey("birthday"))
      {
        i += 1;
        k = paramBundle.getInt("birthday");
        localReqBody.bytes_birthday.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(k)));
        j = i;
        if (NearbyCardConstants.a)
        {
          j = i;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("bytes_birthday|");
            ((StringBuilder)localObject1).append(k);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            j = i;
          }
        }
      }
      if (paramBundle.containsKey("interests"))
      {
        localObject1 = paramBundle.getByteArray("interests");
        if (localObject1 != null) {
          localReqBody.bytes_reqbody_tag.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
      }
      i = j;
      if (paramBundle.containsKey("hometown"))
      {
        j += 2;
        localObject2 = new byte[12];
        localObject1 = paramBundle.getStringArray("hometown");
        i = 0;
        while (i < 3)
        {
          PkgTools.copyData((byte[])localObject2, i * 4, PkgTools.intToBytes2(ConditionSearchManager.f(localObject1[i])), 4);
          i += 1;
        }
        localReqBody.bytes_hometown.set(ByteStringMicro.copyFrom((byte[])localObject2));
        i = ConditionSearchManager.f(localObject1[3]);
        localReqBody.bytes_hometown_district.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(i)));
        i = j;
        if (NearbyCardConstants.a)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            i = 0;
            while (i < localObject1.length)
            {
              ((StringBuilder)localObject2).append(localObject1[i]);
              ((StringBuilder)localObject2).append(", ");
              i += 1;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("bytes_city_id|");
            ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            i = j;
          }
        }
      }
      j = i;
      if (paramBundle.containsKey("location"))
      {
        k = i + 2;
        localObject2 = new byte[12];
        localObject1 = paramBundle.getStringArray("location");
        i = 0;
        while (i < 3)
        {
          PkgTools.copyData((byte[])localObject2, i * 4, PkgTools.intToBytes2(ConditionSearchManager.f(localObject1[i])), 4);
          i += 1;
        }
        localReqBody.bytes_location.set(ByteStringMicro.copyFrom((byte[])localObject2));
        i = ConditionSearchManager.f(localObject1[3]);
        localReqBody.bytes_location_district.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(i)));
        j = k;
        if (NearbyCardConstants.a)
        {
          j = k;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            i = 0;
            while (i < localObject1.length)
            {
              ((StringBuilder)localObject2).append(localObject1[i]);
              ((StringBuilder)localObject2).append(", ");
              i += 1;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("bytes_location|");
            ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            j = k;
          }
        }
      }
      i = j;
      if (paramBundle.containsKey("age"))
      {
        j += 1;
        i = paramBundle.getInt("age");
        localReqBody.uint32_age.set(i);
        i = j;
        if (NearbyCardConstants.a)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("set birthday|age = ");
            ((StringBuilder)localObject1).append(paramBundle.getInt("age"));
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            i = j;
          }
        }
      }
      j = i;
      if (paramBundle.containsKey("company"))
      {
        i += 1;
        localObject1 = paramBundle.getString("company");
        localReqBody.str_company.set((String)localObject1);
        j = i;
        if (NearbyCardConstants.a)
        {
          j = i;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("str_company|");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
            j = i;
          }
        }
      }
      i = j;
      if (paramBundle.containsKey("key_new_nickname"))
      {
        j += 1;
        localObject1 = paramBundle.getString("key_new_nickname");
        localReqBody.str_stranger_nick.set((String)localObject1);
        i = j;
        if (NearbyCardConstants.a)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("str_stranger_nick|");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
            i = j;
          }
        }
      }
      j = i;
      if (paramBundle.containsKey("key_xuan_yan"))
      {
        i += 1;
        localObject1 = paramBundle.getByteArray("key_xuan_yan");
        if (localObject1 != null) {
          localReqBody.bytes_stranger_declare.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        j = i;
        if (NearbyCardConstants.a)
        {
          j = i;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("str_stranger_declare|");
            if (localObject1 == null) {
              localObject1 = "null";
            } else {
              localObject1 = Integer.valueOf(localObject1.length);
            }
            ((StringBuilder)localObject2).append(localObject1);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
            j = i;
          }
        }
      }
      i = j;
      if (paramBundle.containsKey("key_marital_status"))
      {
        j += 1;
        k = paramBundle.getByte("key_marital_status");
        localReqBody.uint32_love_status.set(k);
        i = j;
        if (NearbyCardConstants.a)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("uint32_love_status|");
            ((StringBuilder)localObject1).append(k);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            i = j;
          }
        }
      }
      j = i;
      if (paramBundle.containsKey("profession"))
      {
        int m = paramBundle.getInt("profession");
        k = i;
        if (NearbyProfileUtil.a(m))
        {
          k = i + 1;
          localReqBody.uint32_profession.set(m);
        }
        j = k;
        if (NearbyCardConstants.a)
        {
          j = k;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("uint32_profession|");
            ((StringBuilder)localObject1).append(m);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            j = k;
          }
        }
      }
      i = j;
      if (paramBundle.containsKey("key_qzone_switch"))
      {
        j += 1;
        k = paramBundle.getShort("key_qzone_switch");
        localReqBody.uint32_qzone_visible.set(k);
        i = j;
        if (NearbyCardConstants.a)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("uint32_qzone_visible|");
            ((StringBuilder)localObject1).append(k);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            i = j;
          }
        }
      }
      j = i;
      if (paramBundle.containsKey("key_hobby_switch"))
      {
        i += 1;
        k = paramBundle.getShort("key_hobby_switch");
        localReqBody.uint32_interest_visible.set(k);
        j = i;
        if (NearbyCardConstants.a)
        {
          j = i;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("uint32_interest_visible|");
            ((StringBuilder)localObject1).append(k);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            j = i;
          }
        }
      }
      i = j;
      if (paramBundle.containsKey("key_flower_visible_switch"))
      {
        j += 1;
        k = paramBundle.getShort("key_flower_visible_switch");
        localReqBody.uint32_gift_visible.set(k);
        i = j;
        if (NearbyCardConstants.a)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("uint32_gift_visible|");
            ((StringBuilder)localObject1).append(k);
            QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
            i = j;
          }
        }
      }
    }
    else
    {
      i = 0;
    }
    localReqBody.uint32_stranger_profile_flag.set(1);
    if (bool) {
      localReqBody.uint32_face_flag.set(1);
    }
    localReqBody.uint32_guide_flag.set(0);
    if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fieldCount|");
      ((StringBuilder)localObject1).append(i + 1);
      QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean4) {
      localObject1 = makeOIDBPkg("OidbSvc.0x9c9_1", 2505, 1, localReqBody.toByteArray());
    } else {
      localObject1 = makeOIDBPkg("OidbSvc.0x9c9_0", 2505, 0, localReqBody.toByteArray());
    }
    if (paramBundle != null) {
      ((ToServiceMsg)localObject1).extraData.putAll(paramBundle);
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      ((ToServiceMsg)localObject1).extraData.putParcelable("avatar_picinfo", (Parcelable)paramArrayList.get(0));
    }
    paramArrayList = ((ToServiceMsg)localObject1).extraData;
    if (paramArrayOfObject == null) {
      paramBundle = null;
    } else {
      paramBundle = paramArrayOfObject.toByteArray();
    }
    paramArrayList.putByteArray("9c7_body", paramBundle);
    ((ToServiceMsg)localObject1).extraData.putBoolean("is_lost_god_flag", paramBoolean1);
    ((ToServiceMsg)localObject1).extraData.putBoolean("is_head_changed", paramBoolean2);
    ((ToServiceMsg)localObject1).extraData.putLong("startSaveTime", SystemClock.elapsedRealtime());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      paramToServiceMsg = new cmd0xb5b.RspBody();
      parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleNotifyFaceChange code:");
      paramFromServiceMsg.append(paramToServiceMsg.result.get());
      paramFromServiceMsg.append("   ");
      paramFromServiceMsg.append(paramToServiceMsg.err_msg.get());
      QLog.i("Q.nearby.now", 1, paramFromServiceMsg.toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby.now", 2, "handleNotifyFaceChange req == null || res == null");
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRandomUserInfo| uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("NewNearbyMyTab", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Oidb_0x66b.ReqBody();
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    localReqBody.rpt_uint64_uins.set(localArrayList);
    localReqBody.uint32_req_nick.set(1);
    localReqBody.uint32_req_stranger_nick.set(1);
    localReqBody.uint32_req_gender.set(1);
    localReqBody.uint32_req_god_flag.set(1);
    localReqBody.uint32_req_age.set(1);
    ((Oidb_0x66b.ReqBody)localObject).bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString = makeOIDBPkg("OidbSvc.0x66b", 1643, 0, ((Oidb_0x66b.ReqBody)localObject).toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    send(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    notifyUI(10, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyCardHandler", 2, "getShowExternalTroopList destUin is null");
      }
      return;
    }
    try
    {
      paramString = paramString.trim();
      long l = Long.parseLong(paramString);
      if (l == 0L) {
        return;
      }
      Object localObject1 = new cmd0x8b4.ReqBody();
      ((cmd0x8b4.ReqBody)localObject1).uint64_dst_uin.set(l);
      ((cmd0x8b4.ReqBody)localObject1).uint32_start.set(paramInt1);
      ((cmd0x8b4.ReqBody)localObject1).uint32_cnt.set(paramInt2);
      Object localObject2 = (TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2228);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject1).toByteArray()));
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
      localObject1 = createToServiceMsg("OidbSvc.0x8b4");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
      ((ToServiceMsg)localObject1).extraData.putString("target_uin", paramString);
      sendPbReq((ToServiceMsg)localObject1);
      if (!QLog.isColorLevel()) {
        break label289;
      }
      localObject2 = new StringBuilder("getShowExternalTroopList, request begin==>");
      ((StringBuilder)localObject2).append("|ssoSeq:");
      ((StringBuilder)localObject2).append(((ToServiceMsg)localObject1).getRequestSsoSeq());
      ((StringBuilder)localObject2).append("|ServiceCmd:");
      ((StringBuilder)localObject2).append(((ToServiceMsg)localObject1).getServiceCmd());
      ((StringBuilder)localObject2).append("|destUin:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (NumberFormatException paramString)
    {
      label274:
      label289:
      break label274;
    }
    if (QLog.isColorLevel()) {
      QLog.e("NearbyCardHandler", 2, "NumberFormatException");
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new cmd0x9c8.ReqBody();
    ((cmd0x9c8.ReqBody)localObject).str_keyword.set(paramString);
    ((cmd0x9c8.ReqBody)localObject).uint32_tag_type.set(paramInt1);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_start.set(paramInt2);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_count.set(paramInt3);
    ((cmd0x9c8.ReqBody)localObject).uint32_match_op.set(paramInt4);
    ((cmd0x9c8.ReqBody)localObject).uint32_personal_info_flag.set(paramInt5);
    localObject = makeOIDBPkg("OidbSvc.0x9c8_0", 2504, 0, ((cmd0x9c8.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_word", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("tag_type", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("fetch_start", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("person_flag", paramInt5);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CardHandler.updateNearbyPeopleAuthVideo(), videoId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",photoId =");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.nearby_people_card.update_auth_video", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1514);
    if (paramBoolean) {
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(6);
    } else {
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(7);
    }
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
    UpdatePhotoList.RichHead localRichHead = new UpdatePhotoList.RichHead();
    localRichHead.uint32_headid.set(paramInt);
    localRichHead.str_video_id.set(paramString);
    localReqBody.msg_verify_video_info.set(localRichHead);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    if (paramBoolean) {
      paramString = createToServiceMsg("OidbSvc.0x5ea_6");
    } else {
      paramString = createToServiceMsg("OidbSvc.0x5ea_7");
    }
    paramString.setTimeout(30000L);
    paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    sendPbReq(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = new nearby_ice_break.IceReq();
    try
    {
      ((nearby_ice_break.IceReq)localObject).uin.set(Long.parseLong(paramString));
      ((nearby_ice_break.IceReq)localObject).tinyid.set(String.valueOf(paramLong));
      new CsTask(this.c).a(13569).b(1).a(new NearbyCardHandler.4(this)).a(new NearbyCardHandler.3(this)).a(((nearby_ice_break.IceReq)localObject).toByteArray());
      return;
    }
    catch (NumberFormatException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendPoBingMsg. error=");
      ((StringBuilder)localObject).append(QLog.getStackTraceString(paramString));
      QLog.i("NearbyCardHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, long paramLong6, boolean paramBoolean3, long paramLong7, int paramInt3)
  {
    long l1 = b(paramString1);
    long l2 = b(paramString2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSummaryCard()");
      localStringBuilder.append(",selfUin = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",destUin = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",comeFromType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",qzoneFeedTimeStamp = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",isFriend = ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(",troopCode = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",troopUin = ");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(",vseed = ");
      localStringBuilder.append(paramArrayOfByte1);
      localStringBuilder.append(",strSearchName = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",lGetControl = ");
      localStringBuilder.append(paramLong4);
      localStringBuilder.append(",nAddFriendSource = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", vSecureSig = ");
      localStringBuilder.append(paramArrayOfByte2);
      localStringBuilder.append(", tinyId = ");
      localStringBuilder.append(paramLong5);
      localStringBuilder.append(", isNearbyPeopleCard = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",uLikeSource = ");
      localStringBuilder.append(paramLong6);
      QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
    }
    paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
    paramString1.extraData.putLong("selfUin", l1);
    paramString1.extraData.putLong("targetUin", l2);
    paramString1.extraData.putInt("comeFromType", paramInt1);
    paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
    paramString1.extraData.putByte("isFriend", paramByte);
    paramString1.extraData.putLong("troopCode", paramLong2);
    paramString1.extraData.putLong("troopUin", paramLong3);
    paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
    paramString1.extraData.putString("strSearchName", paramString3);
    paramString1.extraData.putLong("lGetControl", paramLong4);
    paramString1.extraData.putInt("bReqCommLabel", 1);
    paramString1.extraData.putInt("EAddFriendSource", paramInt2);
    paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
    paramString1.extraData.putLong("tinyId", paramLong5);
    paramString1.extraData.putBoolean("isNearbyPeopleCard", paramBoolean1);
    paramString1.extraData.putBoolean("partlyRefresh", paramBoolean2);
    paramString1.extraData.putLong("startFetchTime", SystemClock.elapsedRealtime());
    paramString1.extraData.putLong("likeSource", paramLong6);
    paramString1.extraData.putLong("nowId", paramLong7);
    paramString1.extraData.putInt("nowUserType", paramInt3);
    if (paramBoolean3)
    {
      send(paramString1);
      return;
    }
    a(paramLong7, paramInt3, paramInt1, paramLong5, paramString2, paramByte, paramString1);
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        ((StringBuilder)localObject1).append(paramArrayList.get(i));
        ((StringBuilder)localObject1).append(", ");
        i += 1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("CardHandler.updateNearbyPeoplePhotoList(), photo_ids = ");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d("Q.nearby_people_card.update_photo_list", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1514);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    Object localObject2 = new UpdatePhotoList.ReqBody();
    ((UpdatePhotoList.ReqBody)localObject2).rpt_uint32_headids.set(paramArrayList);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject2).toByteArray()));
    paramArrayList = createToServiceMsg("OidbSvc.0x5ea_1");
    paramArrayList.setTimeout(30000L);
    paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq(paramArrayList);
  }
  
  public void a(ArrayList<Object> paramArrayList, int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    Object localObject1;
    int i;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("nearbyPeopleLikeNew, reqList.size=");
      if (paramArrayList == null) {
        i = 0;
      } else {
        i = paramArrayList.size();
      }
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", from=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      Object localObject2 = ((TicketManager)this.c.getManager(2)).getSkey(this.c.getCurrentAccountUin());
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, skey is empty, return");
        }
        return;
      }
      localObject1 = new oidb_0x8e6.ReqBody();
      ((oidb_0x8e6.ReqBody)localObject1).uint32_portal.set(paramInt);
      ((oidb_0x8e6.ReqBody)localObject1).uint32_client.set(1);
      ((oidb_0x8e6.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.h().getBytes()));
      Object localObject3 = new oidb_0x8e6.LoginSig();
      ((oidb_0x8e6.LoginSig)localObject3).uint32_type.set(1);
      ((oidb_0x8e6.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      ((oidb_0x8e6.ReqBody)localObject1).msg_login_sig.set((MessageMicro)localObject3);
      localObject3 = new ArrayList();
      int k = paramArrayList.size();
      localObject2 = new StringBuilder();
      i = j;
      while (i < k)
      {
        INearbyLikeLimitManager.LikeItem localLikeItem = (INearbyLikeLimitManager.LikeItem)paramArrayList.get(i);
        if (QLog.isColorLevel())
        {
          ((StringBuilder)localObject2).append(localLikeItem);
          ((StringBuilder)localObject2).append(" | ");
        }
        oidb_0x8e6.VoteInfo localVoteInfo = new oidb_0x8e6.VoteInfo();
        localVoteInfo.uint64_uin.set(localLikeItem.a);
        localVoteInfo.uint32_free_vote_count.set(localLikeItem.b);
        localVoteInfo.uint32_pay_vote_count.set(localLikeItem.c);
        localVoteInfo.uint32_source.set(localLikeItem.e);
        ((ArrayList)localObject3).add(localVoteInfo);
        i += 1;
      }
      ((oidb_0x8e6.ReqBody)localObject1).rpt_vote_info.set((List)localObject3);
      paramArrayList = makeOIDBPkg("OidbSvc.0x8e6_1", 2278, 1, ((oidb_0x8e6.ReqBody)localObject1).toByteArray());
      paramArrayList.extraData.putInt("from", paramInt);
      sendPbReq(paramArrayList);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("nearbyPeopleLikeNew, reqList=[");
        paramArrayList.append(((StringBuilder)localObject2).toString());
        paramArrayList.append("]");
        QLog.d("NearbyLikeLimitManager", 2, paramArrayList.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, reqList is empty, return");
    }
  }
  
  public void a(List<Object> paramList, int paramInt1, int paramInt2)
  {
    NearbyCmdHelper.a(this, 4, paramList, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo");
    }
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    if (parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      paramFromServiceMsg = new oidb_0x5eb.RspBody();
      if (paramToServiceMsg.bytes_rspbody_5eb.has())
      {
        paramToServiceMsg = paramToServiceMsg.bytes_rspbody_5eb.get().toByteArray();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          int i;
          int j;
          if ((paramFromServiceMsg.rpt_msg_uin_data.has()) && (paramFromServiceMsg.rpt_msg_uin_data.size() > 0))
          {
            paramObject = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0);
            paramFromServiceMsg = Long.valueOf(paramObject.uint64_uin.get());
            paramToServiceMsg = paramObject.bytes_stranger_nick.get().toStringUtf8();
            i = paramObject.uint32_gender.get();
            j = paramObject.uint32_age.get();
          }
          else
          {
            paramToServiceMsg = "";
            paramFromServiceMsg = null;
            j = 0;
            i = -1;
          }
          notifyUI(13, true, new Object[] { paramFromServiceMsg, paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
          if (QLog.isDevelopLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append("handleGetRandomUserInfo---->uin =");
            paramObject.append(paramFromServiceMsg);
            paramObject.append("nickName = ");
            paramObject.append(paramToServiceMsg);
            paramObject.append(" gender = ");
            paramObject.append(i);
            paramObject.append("age =");
            paramObject.append(j);
            QLog.d("NewNearbyMyTab", 2, paramObject.toString());
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", paramToServiceMsg);
          }
        }
      }
    }
    notifyUI(13, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(-1), Integer.valueOf(-1) });
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0x8e7.RspBody localRspBody = new oidb_0x8e7.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    String str = paramToServiceMsg.extraData.getString("uin", "");
    int j = paramToServiceMsg.extraData.getInt("from", 509);
    boolean bool = QLog.isColorLevel();
    paramToServiceMsg = "NearbyLikeLimitManager";
    if (bool)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleNearbyLikeLimitInfo, uin=");
      paramFromServiceMsg.append(str);
      paramFromServiceMsg.append(", ret=");
      paramFromServiceMsg.append(i);
      QLog.d("NearbyLikeLimitManager", 2, paramFromServiceMsg.toString());
    }
    if (i == 0) {
      paramFromServiceMsg = paramToServiceMsg;
    }
    for (;;)
    {
      try
      {
        INearbyLikeLimitManager.LimitInfo localLimitInfo = new INearbyLikeLimitManager.LimitInfo();
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.c = localRspBody.bytes_recharge_url.get().toStringUtf8();
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.d = localRspBody.bytes_update_url.get().toStringUtf8();
        paramFromServiceMsg = paramToServiceMsg;
        if (!localRspBody.msg_zan_limit.has()) {
          break label658;
        }
        paramFromServiceMsg = paramToServiceMsg;
        Object localObject = (oidb_0x8e7.ZanLimitInfo)localRspBody.msg_zan_limit.get();
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.a = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_level.get());
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.f = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_can_free_zan_user_limit.get());
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.g = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_total_limit.get());
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.b = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_price.get());
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.i = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_user.get());
        paramFromServiceMsg = paramToServiceMsg;
        ArrayList localArrayList = new ArrayList();
        paramObject = paramToServiceMsg;
        paramFromServiceMsg = paramToServiceMsg;
        INearbyLikeLimitManager.LikeItem localLikeItem;
        long l;
        if (((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.has())
        {
          paramFromServiceMsg = paramToServiceMsg;
          localObject = ((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.get().iterator();
          paramObject = paramToServiceMsg;
          paramFromServiceMsg = paramToServiceMsg;
          if (((Iterator)localObject).hasNext())
          {
            paramFromServiceMsg = paramToServiceMsg;
            paramObject = (oidb_0x8e7.UserZanInfo)((Iterator)localObject).next();
            paramFromServiceMsg = paramToServiceMsg;
            localLikeItem = new INearbyLikeLimitManager.LikeItem();
            paramFromServiceMsg = paramToServiceMsg;
            if (paramObject.uint64_uin.has())
            {
              paramFromServiceMsg = paramToServiceMsg;
              l = paramObject.uint64_uin.get();
              break label659;
            }
            paramFromServiceMsg = paramToServiceMsg;
            if (paramObject.uint64_tinyid.has())
            {
              paramFromServiceMsg = paramToServiceMsg;
              l = paramObject.uint64_tinyid.get();
              break label659;
            }
            l = 0L;
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
        try
        {
          localLikeItem.a = l;
          paramToServiceMsg = paramFromServiceMsg;
          localLikeItem.b = ((int)paramObject.uint64_free_zan.get());
          paramToServiceMsg = paramFromServiceMsg;
          localLikeItem.c = ((int)paramObject.uint64_pay_zan.get());
          paramToServiceMsg = paramFromServiceMsg;
          localLikeItem.d = ((int)paramObject.uint64_pay_stock.get());
          if (l <= 0L) {
            break label662;
          }
          paramToServiceMsg = paramFromServiceMsg;
          localArrayList.add(localLikeItem);
        }
        catch (Exception paramFromServiceMsg)
        {
          break label599;
        }
        paramToServiceMsg = paramObject;
        if (localRspBody.msg_warn.has())
        {
          paramToServiceMsg = paramObject;
          localLimitInfo.e = localRspBody.msg_warn.get();
        }
        paramToServiceMsg = paramObject;
        if (localRspBody.msg_stock_rsp.has())
        {
          paramToServiceMsg = paramObject;
          localLimitInfo.h = ((oidb_0x8e7.StockRsp)localRspBody.msg_stock_rsp.get()).int32_total.get();
        }
        paramToServiceMsg = paramObject;
        ((INearbyLikeLimitManager)this.c.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(localLimitInfo, localArrayList, j);
        try
        {
          notifyUI(16, true, str);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = paramObject;
        }
        notifyUI(16, false, str);
      }
      catch (Exception paramObject)
      {
        paramToServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
      }
      label599:
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleNearbyLikeLimitInfo, ");
        paramObject.append(paramFromServiceMsg.toString());
        QLog.e(paramToServiceMsg, 2, paramObject.toString());
        return;
        notifyUI(16, false, str);
      }
      label658:
      return;
      label659:
      continue;
      label662:
      paramToServiceMsg = paramFromServiceMsg;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m = paramToServiceMsg.extraData.getInt("from", 0);
    paramToServiceMsg = new oidb_0x8e6.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleNearbyPeopleLikeNew, ret=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(", from=");
      paramFromServiceMsg.append(m);
      QLog.d("NearbyLikeLimitManager", 2, paramFromServiceMsg.toString());
    }
    paramFromServiceMsg = new ArrayList();
    if (i == 0)
    {
      i = paramToServiceMsg.uint32_level.get();
      int j = paramToServiceMsg.uint32_can_vote_free_user_count.get();
      int n = paramToServiceMsg.uint32_can_vote_free_count.get();
      paramToServiceMsg.uint32_remain_total.get();
      paramObject = (INearbyLikeLimitManager)this.c.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
      paramToServiceMsg = paramToServiceMsg.rpt_vote_result.get();
      int i1 = paramToServiceMsg.size();
      int k = 0;
      while (k < i1)
      {
        Object localObject = (oidb_0x8e6.VoteResult)paramToServiceMsg.get(k);
        INearbyLikeLimitManager.LikeResultItem localLikeResultItem = new INearbyLikeLimitManager.LikeResultItem();
        localLikeResultItem.a = ((oidb_0x8e6.VoteResult)localObject).uint32_ret.get();
        localLikeResultItem.b = ((oidb_0x8e6.VoteResult)localObject).bytes_err_msg.get().toStringUtf8();
        localLikeResultItem.c = ((oidb_0x8e6.VoteResult)localObject).uint64_uin.get();
        localLikeResultItem.d = ((oidb_0x8e6.VoteResult)localObject).uint32_succ_free_vote_count.get();
        localLikeResultItem.e = ((oidb_0x8e6.VoteResult)localObject).uint32_succ_pay_vote_count.get();
        localLikeResultItem.f = ((oidb_0x8e6.VoteResult)localObject).uint32_vote_count.get();
        localLikeResultItem.g = ((int)((oidb_0x8e6.VoteResult)localObject).uint64_pay_stock.get());
        paramFromServiceMsg.add(localLikeResultItem);
        int i2 = localLikeResultItem.d + localLikeResultItem.e;
        if (localLikeResultItem.a == 0) {
          if ((localLikeResultItem.c > 0L) && (i2 > 0))
          {
            VoteUtil.a(this.c, localLikeResultItem.c, i2);
            localObject = this.c.getEntityManagerFactory().createEntityManager();
            NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject).find(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(localLikeResultItem.c) });
            if (localNearbyPeopleCard != null)
            {
              localNearbyPeopleCard.likeCount += i2;
              localNearbyPeopleCard.bVoted = 1;
              localNearbyPeopleCard.bAvailVoteCnt = ((short)(localNearbyPeopleCard.bAvailVoteCnt - i2));
              if (localNearbyPeopleCard.bAvailVoteCnt < 0) {
                localNearbyPeopleCard.bAvailVoteCnt = 0;
              }
              ((EntityManager)localObject).update(localNearbyPeopleCard);
            }
          }
          else {}
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleNearbyPeopleLikeNew: ");
          ((StringBuilder)localObject).append(localLikeResultItem);
          QLog.d("NearbyLikeLimitManager", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localLikeResultItem.c);
        ((StringBuilder)localObject).append("");
        paramObject.a(((StringBuilder)localObject).toString(), true);
        k += 1;
      }
      paramObject.a(i, j, n);
      notifyUI(17, true, new Object[] { paramFromServiceMsg, Integer.valueOf(m) });
      return;
    }
    notifyUI(17, false, new Object[] { paramFromServiceMsg, Integer.valueOf(m) });
  }
  
  public Set<String> getCommandList()
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add("SummaryCard.ReqSummaryCard");
      this.b.add("OidbSvc.0x9c8_0");
      this.b.add("OidbSvc.0x9c5_0");
      this.b.add("OidbSvc.0x9c9_0");
      this.b.add("OidbSvc.0x9c9_1");
      this.b.add("OidbSvc.0x9c7_0");
      this.b.add("OidbSvc.0x682");
      this.b.add("OidbSvc.0x686");
      this.b.add("OidbSvc.0x5ea_1");
      this.b.add("OidbSvc.0x5ea_3");
      this.b.add("OidbSvc.0x5ea_4");
      this.b.add("SQQzoneSvc.getCover");
      this.b.add("OidbSvc.0x8b4");
      this.b.add("OidbSvc.0x5ea_6");
      this.b.add("OidbSvc.0x5ea_7");
      this.b.add("VisitorSvc.ReqFavorite");
      this.b.add("OidbSvc.0x66b");
      this.b.add("OidbSvc.0x66b");
      this.b.add("OidbSvc.0x66b");
      this.b.add("OidbSvc.0x8e6_1");
      this.b.add("OidbSvc.0x8e7_1");
      this.b.add("OidbSvc.0xb5b");
    }
    return this.b;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return NearbyCardObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
        return;
      }
      String str = paramFromServiceMsg.getServiceCmd();
      if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c8_0".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c5_0".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ((!"OidbSvc.0x9c9_0".equals(str)) && (!"OidbSvc.0x9c9_1".equals(str)))
      {
        if ("OidbSvc.0x9c7_0".equals(str))
        {
          NearbyCmdHelper.c(this, 4, paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x682".equals(str))
        {
          h(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x686".equals(paramFromServiceMsg.getServiceCmd()))
        {
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5ea_1".equals(paramFromServiceMsg.getServiceCmd()))
        {
          m(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5ea_3".equals(paramFromServiceMsg.getServiceCmd()))
        {
          n(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5ea_6".equals(paramFromServiceMsg.getServiceCmd()))
        {
          k(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5ea_7".equals(paramFromServiceMsg.getServiceCmd()))
        {
          l(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5ea_4".equals(paramFromServiceMsg.getServiceCmd()))
        {
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
        {
          p(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
        {
          q(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
        {
          r(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()))
        {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x8e7_1".equals(paramFromServiceMsg.getServiceCmd()))
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x8e6_1".equals(paramFromServiceMsg.getServiceCmd()))
        {
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0xb5b".equals(paramFromServiceMsg.getServiceCmd())) {
          a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.business.NearbyCardHandler
 * JD-Core Version:    0.7.0.1
 */