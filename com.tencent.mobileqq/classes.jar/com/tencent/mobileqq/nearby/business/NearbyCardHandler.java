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
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected Set<String> a;
  
  public NearbyCardHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    }
  }
  
  private long a(String paramString)
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
  
  private NowSummaryCard.ClientInfo a()
  {
    NowSummaryCard.ClientInfo localClientInfo = new NowSummaryCard.ClientInfo();
    localClientInfo.client_version.set(ByteStringMicro.copyFrom(AppSetting.f().getBytes()));
    localClientInfo.platform.set(2);
    localClientInfo.imei.set(ByteStringMicro.copyFrom(MobileInfoUtil.getImei().getBytes()));
    return localClientInfo;
  }
  
  private NowSummaryCard.LocationInfo a()
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
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getNearbySummaryCard, illegal uin: ");
    ((StringBuilder)localObject2).append(paramString);
    QLog.e("NearbyCardHandler", 1, ((StringBuilder)localObject2).toString());
    ((NowSummaryCard.ReqNearbySummaryCard)localObject1).location.set(a());
    ((NowSummaryCard.ReqNearbySummaryCard)localObject1).client_info.set(a());
    ((NowSummaryCard.ReqNearbySummaryCard)localObject1).come_from.set(paramInt2);
    localObject2 = new NowSummaryCard.NearbySummaryCardReq();
    ((NowSummaryCard.NearbySummaryCardReq)localObject2).id.set(paramLong1);
    ((NowSummaryCard.NearbySummaryCardReq)localObject2).id_type.set(paramInt1);
    ((NowSummaryCard.NearbySummaryCardReq)localObject2).gender.set(1L);
    ((NowSummaryCard.NearbySummaryCardReq)localObject2).pb_data.set(ByteStringMicro.copyFrom(((NowSummaryCard.ReqNearbySummaryCard)localObject1).toByteArray()));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("start uin:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", tinyId:");
    ((StringBuilder)localObject1).append(paramLong2);
    ((StringBuilder)localObject1).append(", nowId:");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(", from:");
    ((StringBuilder)localObject1).append(paramInt2);
    QLog.e("NearbyCardHandler", 1, ((StringBuilder)localObject1).toString());
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new NearbyCardHandler.2(this, false, paramToServiceMsg), ((NowSummaryCard.NearbySummaryCardReq)localObject2).toByteArray(), "NowSummaryCard.NearbySummaryCardReq");
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
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
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
        paramBundle.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
            label558:
            Object localObject4;
            Object localObject5;
            Object localObject2;
            Object localObject3;
            StringBuilder localStringBuilder;
            Cursor localCursor;
            break label558;
          }
        }
      }
      paramBundle.nowId = l2;
      paramBundle.nowUserType = i;
      paramBundle.nickname = paramRespNearbySummaryCard.nick.get();
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
      paramBundle.favoriteSource = j;
      if (paramBundle.vTempChatSig != null)
      {
        if ((paramBundle.vTempChatSig.length == 0) && (!paramBundle.isHostSelf))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_card_get_sig_length_0", 0, 0, ((QQAppInterface)localObject1).getCurrentAccountUin(), String.valueOf(paramBundle.tinyId), "", "");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().m(String.valueOf(paramBundle.tinyId)) == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().g(String.valueOf(paramBundle.tinyId), paramBundle.vTempChatSig);
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
            break label1493;
          }
        }
        QLog.i("InterestTag", 2, localException2.toString());
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("Q.profilecard.SummaryCard", 2, "stInterestTag is null");
      }
      label1493:
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
        break label1762;
      }
      if (((nearby.Cmd0x1RspBody)localObject3).uint32_if_mask_msg.get() != 1) {
        break label3791;
      }
      paramBoolean = true;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        label1762:
        continue;
        label1844:
        label2997:
        paramBoolean = false;
        label3713:
        label3758:
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
      break label1844;
      paramBundle.maskMsgFlag = ((nearby.Cmd0x1RspBody)localObject3).uint32_if_mask_msg.get();
      if (paramBundle.maskMsgFlag != 1) {
        break label3801;
      }
      paramBoolean = true;
      paramBundle.isForbidSendMsg = paramBoolean;
      if (((nearby.Cmd0x1RspBody)localObject3).uint32_if_mask_gift.get() != 1) {
        break label3806;
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
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
        break label3811;
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
        break label2997;
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
      paramRespNearbySummaryCard = (NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
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
      paramRespNearbySummaryCard = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramBundle.isHostSelf)
      {
        localObject3 = paramRespNearbySummaryCard.b(paramBundle.uin);
        ((Card)localObject3).iVoteIncrement = paramBundle.likeCountInc;
        ((Card)localObject3).lVoteCount = paramBundle.likeCount;
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), ((Card)localObject3).lVoteCount, ((Card)localObject3).iVoteIncrement);
        try
        {
          paramRespNearbySummaryCard.a((Card)localObject3);
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_school_name", paramBundle.college);
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
      }
      if ((paramBundle.isHostSelf) && (paramBundle.charmLevel > 0)) {
        ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramBundle.charmLevel);
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
          break label3713;
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
          break label3758;
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
    //   0: ldc_w 958
    //   3: astore 15
    //   5: aload_3
    //   6: ldc_w 257
    //   9: invokevirtual 263	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   12: istore 12
    //   14: aload_3
    //   15: ldc_w 265
    //   18: invokevirtual 269	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   21: istore 5
    //   23: iload_1
    //   24: ifeq +7094 -> 7118
    //   27: aload_2
    //   28: checkcast 1258	SummaryCard/RespSummaryCard
    //   31: astore_2
    //   32: aload_0
    //   33: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   36: invokevirtual 292	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   39: invokevirtual 298	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   42: astore 27
    //   44: aload 27
    //   46: invokevirtual 304	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   49: astore 28
    //   51: aload 28
    //   53: invokevirtual 309	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   56: aload_3
    //   57: ldc_w 311
    //   60: lconst_0
    //   61: invokevirtual 315	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   64: lstore 13
    //   66: aload_3
    //   67: ldc_w 317
    //   70: invokevirtual 319	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   73: pop2
    //   74: aload_3
    //   75: ldc_w 321
    //   78: invokevirtual 269	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   81: pop
    //   82: new 323	com/tencent/mobileqq/data/NearbyPeopleCard
    //   85: dup
    //   86: invokespecial 335	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   89: astore 16
    //   91: aload_2
    //   92: getfield 1262	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   95: astore 17
    //   97: aload 16
    //   99: aload_2
    //   100: getfield 1265	SummaryCard/RespSummaryCard:lUIN	J
    //   103: invokestatic 328	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   106: putfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   109: lload 13
    //   111: lconst_0
    //   112: lcmp
    //   113: ifle +13 -> 126
    //   116: aload 16
    //   118: lload 13
    //   120: putfield 416	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   123: goto +13 -> 136
    //   126: aload 16
    //   128: aload 17
    //   130: getfield 1270	SummaryCard/DateCard:lTinyId	J
    //   133: putfield 416	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   136: aload 16
    //   138: aload_3
    //   139: ldc_w 317
    //   142: invokevirtual 319	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   145: putfield 418	com/tencent/mobileqq/data/NearbyPeopleCard:nowId	J
    //   148: aload 16
    //   150: aload_3
    //   151: ldc_w 321
    //   154: invokevirtual 269	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   157: putfield 420	com/tencent/mobileqq/data/NearbyPeopleCard:nowUserType	I
    //   160: iload 5
    //   162: ifeq +45 -> 207
    //   165: aload 16
    //   167: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   170: aload_0
    //   171: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   174: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   177: invokevirtual 1273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   180: ifeq +6 -> 186
    //   183: goto +24 -> 207
    //   186: aload 16
    //   188: aload_2
    //   189: getfield 1276	SummaryCard/RespSummaryCard:iVoteCount	I
    //   192: putfield 765	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   195: aload 16
    //   197: aload_2
    //   198: getfield 1279	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   201: putfield 771	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   204: goto +89 -> 293
    //   207: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +56 -> 266
    //   213: new 167	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   220: astore_3
    //   221: aload_3
    //   222: ldc_w 1281
    //   225: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_3
    //   230: aload_2
    //   231: getfield 1276	SummaryCard/RespSummaryCard:iVoteCount	I
    //   234: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_3
    //   239: ldc_w 775
    //   242: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_3
    //   247: aload_2
    //   248: getfield 1279	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   251: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc_w 661
    //   258: iconst_2
    //   259: aload_3
    //   260: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: aload 16
    //   268: aload_2
    //   269: getfield 1276	SummaryCard/RespSummaryCard:iVoteCount	I
    //   272: putfield 765	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   275: aload 16
    //   277: aload_2
    //   278: getfield 1279	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   281: putfield 771	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   284: aload 16
    //   286: aload_2
    //   287: getfield 1285	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   290: putfield 1288	com/tencent/mobileqq/data/NearbyPeopleCard:praiseList	Ljava/util/List;
    //   293: aload 16
    //   295: aload_2
    //   296: getfield 1291	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   299: putfield 423	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   302: aload 16
    //   304: aload_2
    //   305: getfield 1294	SummaryCard/RespSummaryCard:vRichSign	[B
    //   308: putfield 434	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   311: aload 16
    //   313: aload 17
    //   315: getfield 1297	SummaryCard/DateCard:bMarriage	B
    //   318: putfield 492	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   321: aload 16
    //   323: aload_2
    //   324: getfield 1300	SummaryCard/RespSummaryCard:bSex	B
    //   327: putfield 438	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   330: aload 16
    //   332: aload_2
    //   333: getfield 1303	SummaryCard/RespSummaryCard:bAge	B
    //   336: putfield 447	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   339: aload 16
    //   341: aload_2
    //   342: getfield 1306	SummaryCard/RespSummaryCard:iBirthday	I
    //   345: putfield 453	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   348: aload 16
    //   350: aload 17
    //   352: getfield 1309	SummaryCard/DateCard:uProfession	J
    //   355: l2i
    //   356: putfield 459	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   359: aload 16
    //   361: aload 17
    //   363: getfield 1312	SummaryCard/DateCard:bConstellation	B
    //   366: putfield 464	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   369: aload 16
    //   371: aload 17
    //   373: getfield 1315	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   376: putfield 469	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   379: aload 16
    //   381: aload 17
    //   383: getfield 1318	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   386: putfield 475	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   389: aload 16
    //   391: aload_2
    //   392: getfield 1321	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   395: putfield 1324	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   398: aload 16
    //   400: aload 17
    //   402: getfield 1327	SummaryCard/DateCard:vDateInfo	[B
    //   405: putfield 1330	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   408: aload 16
    //   410: aload 17
    //   412: getfield 1333	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   415: putfield 480	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   418: aload 16
    //   420: aload 17
    //   422: getfield 1336	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   425: putfield 486	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   428: aload 16
    //   430: aload 17
    //   432: getfield 1339	SummaryCard/DateCard:uHomeCountry	J
    //   435: invokestatic 511	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   438: putfield 514	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   441: aload 16
    //   443: aload 17
    //   445: getfield 1342	SummaryCard/DateCard:uHomeProvince	J
    //   448: invokestatic 511	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   451: putfield 520	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   454: aload 16
    //   456: aload 17
    //   458: getfield 1345	SummaryCard/DateCard:uHomeCity	J
    //   461: invokestatic 511	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   464: putfield 526	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   467: aload 16
    //   469: aload 17
    //   471: getfield 1348	SummaryCard/DateCard:uHomeZone	J
    //   474: invokestatic 511	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   477: putfield 532	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   480: aload 16
    //   482: aload_2
    //   483: getfield 1351	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   486: putfield 1354	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   489: aload 16
    //   491: aload_2
    //   492: getfield 1357	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   495: putfield 1360	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   498: aload 16
    //   500: aload_2
    //   501: getfield 1363	SummaryCard/RespSummaryCard:ulShowControl	J
    //   504: putfield 1366	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   507: aload 16
    //   509: aload_2
    //   510: getfield 1369	SummaryCard/RespSummaryCard:lUserFlag	J
    //   513: putfield 674	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   516: aload 16
    //   518: aload_2
    //   519: getfield 1372	SummaryCard/RespSummaryCard:vSeed	[B
    //   522: putfield 1373	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   525: aload 16
    //   527: aload_2
    //   528: getfield 1376	SummaryCard/RespSummaryCard:lCacheControl	J
    //   531: invokevirtual 1379	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   534: aload 16
    //   536: invokestatic 537	java/lang/System:currentTimeMillis	()J
    //   539: putfield 540	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   542: aload 16
    //   544: iload 5
    //   546: putfield 558	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   549: aload 16
    //   551: aload_2
    //   552: getfield 1380	SummaryCard/RespSummaryCard:vTempChatSig	[B
    //   555: putfield 546	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   558: aload 16
    //   560: getfield 546	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   563: ifnull +112 -> 675
    //   566: aload 16
    //   568: getfield 546	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   571: arraylength
    //   572: ifne +62 -> 634
    //   575: aload_0
    //   576: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   579: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   582: aload 16
    //   584: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   587: invokestatic 1385	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   590: ifne +44 -> 634
    //   593: aload_0
    //   594: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   597: astore_3
    //   598: aload_3
    //   599: ldc_w 560
    //   602: ldc_w 562
    //   605: ldc_w 564
    //   608: ldc_w 566
    //   611: ldc_w 568
    //   614: iconst_0
    //   615: iconst_0
    //   616: aload_3
    //   617: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   620: aload 16
    //   622: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   625: ldc_w 564
    //   628: ldc_w 564
    //   631: invokestatic 574	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload_0
    //   635: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   638: invokevirtual 578	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   641: aload 16
    //   643: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   646: invokevirtual 584	com/tencent/mobileqq/service/message/MessageCache:m	(Ljava/lang/String;)[B
    //   649: ifnonnull +67 -> 716
    //   652: aload_0
    //   653: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   656: invokevirtual 578	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   659: aload 16
    //   661: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   664: aload 16
    //   666: getfield 546	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   669: invokevirtual 588	com/tencent/mobileqq/service/message/MessageCache:g	(Ljava/lang/String;[B)V
    //   672: goto +44 -> 716
    //   675: aload_0
    //   676: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   679: astore_3
    //   680: aload_3
    //   681: ldc_w 560
    //   684: ldc_w 562
    //   687: ldc_w 564
    //   690: ldc_w 566
    //   693: ldc_w 590
    //   696: iconst_0
    //   697: iconst_0
    //   698: aload_3
    //   699: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   702: aload 16
    //   704: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   707: ldc_w 564
    //   710: ldc_w 564
    //   713: invokestatic 574	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   716: aload 16
    //   718: aload 17
    //   720: getfield 1388	SummaryCard/DateCard:uSchoolId	J
    //   723: putfield 498	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   726: aload 16
    //   728: aload 17
    //   730: getfield 1391	SummaryCard/DateCard:vGroupList	[B
    //   733: putfield 1392	com/tencent/mobileqq/data/NearbyPeopleCard:vGroupList	[B
    //   736: aload 16
    //   738: aload 17
    //   740: getfield 1395	SummaryCard/DateCard:vNearbyInfo	[B
    //   743: putfield 504	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   746: aload 16
    //   748: aload 17
    //   750: getfield 1398	SummaryCard/DateCard:vActivityList	[B
    //   753: putfield 1399	com/tencent/mobileqq/data/NearbyPeopleCard:vActivityList	[B
    //   756: aload 16
    //   758: aload_2
    //   759: getfield 1369	SummaryCard/RespSummaryCard:lUserFlag	J
    //   762: putfield 1400	com/tencent/mobileqq/data/NearbyPeopleCard:lUserFlag	J
    //   765: aload 16
    //   767: aload_2
    //   768: getfield 1403	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   771: putfield 1404	com/tencent/mobileqq/data/NearbyPeopleCard:strRemark	Ljava/lang/String;
    //   774: aload_2
    //   775: getfield 1408	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   778: ifnull +15 -> 793
    //   781: aload 16
    //   783: aload_2
    //   784: getfield 1408	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   787: getfield 1413	SummaryCard/HeartInfo:iHeartCount	I
    //   790: putfield 1416	com/tencent/mobileqq/data/NearbyPeopleCard:mHeartNum	I
    //   793: aload_2
    //   794: getfield 1420	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   797: ifnull +30 -> 827
    //   800: aload 16
    //   802: aload_2
    //   803: getfield 1420	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   806: getfield 1425	SummaryCard/TNearbyGodInfo:strJumpUrl	Ljava/lang/String;
    //   809: putfield 1428	com/tencent/mobileqq/data/NearbyPeopleCard:strGodJumpUrl	Ljava/lang/String;
    //   812: aload 16
    //   814: aload_2
    //   815: getfield 1420	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   818: getfield 1431	SummaryCard/TNearbyGodInfo:iIsGodFlag	I
    //   821: putfield 1432	com/tencent/mobileqq/data/NearbyPeopleCard:iIsGodFlag	I
    //   824: goto +42 -> 866
    //   827: invokestatic 657	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   830: ifeq +36 -> 866
    //   833: new 167	java/lang/StringBuilder
    //   836: dup
    //   837: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   840: astore_3
    //   841: aload_3
    //   842: ldc_w 1434
    //   845: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload_3
    //   850: aconst_null
    //   851: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: ldc_w 661
    //   858: iconst_2
    //   859: aload_3
    //   860: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 1010	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: aload_2
    //   867: getfield 1440	SummaryCard/RespSummaryCard:vCommLabel	[B
    //   870: astore 18
    //   872: ldc 176
    //   874: astore_3
    //   875: aload 18
    //   877: ifnull +201 -> 1078
    //   880: aload 16
    //   882: new 595	java/util/ArrayList
    //   885: dup
    //   886: invokespecial 596	java/util/ArrayList:<init>	()V
    //   889: putfield 600	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   892: new 602	appoint/define/appoint_define$CommonLabel
    //   895: dup
    //   896: invokespecial 603	appoint/define/appoint_define$CommonLabel:<init>	()V
    //   899: astore 19
    //   901: aload 19
    //   903: aload 18
    //   905: invokevirtual 607	appoint/define/appoint_define$CommonLabel:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   908: pop
    //   909: aload 19
    //   911: getfield 611	appoint/define/appoint_define$CommonLabel:rpt_interst_name	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   914: invokevirtual 616	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   917: astore 18
    //   919: aload 19
    //   921: getfield 619	appoint/define/appoint_define$CommonLabel:rpt_interst_type	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   924: invokevirtual 616	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   927: astore 20
    //   929: new 621	org/json/JSONArray
    //   932: dup
    //   933: invokespecial 622	org/json/JSONArray:<init>	()V
    //   936: astore 19
    //   938: aload 18
    //   940: invokeinterface 627 1 0
    //   945: aload 20
    //   947: invokeinterface 627 1 0
    //   952: if_icmpne +65 -> 1017
    //   955: iconst_0
    //   956: istore 6
    //   958: iload 6
    //   960: aload 18
    //   962: invokeinterface 627 1 0
    //   967: if_icmpge +50 -> 1017
    //   970: aload 18
    //   972: iload 6
    //   974: invokeinterface 630 2 0
    //   979: checkcast 58	com/tencent/mobileqq/pb/ByteStringMicro
    //   982: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   985: astore 20
    //   987: aload 16
    //   989: getfield 600	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   992: aload 20
    //   994: invokeinterface 637 2 0
    //   999: pop
    //   1000: aload 19
    //   1002: aload 20
    //   1004: invokevirtual 641	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1007: pop
    //   1008: iload 6
    //   1010: iconst_1
    //   1011: iadd
    //   1012: istore 6
    //   1014: goto -56 -> 958
    //   1017: aload 16
    //   1019: aload 19
    //   1021: invokevirtual 642	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1024: putfield 645	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1027: goto +51 -> 1078
    //   1030: astore 18
    //   1032: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1035: ifeq +43 -> 1078
    //   1038: new 167	java/lang/StringBuilder
    //   1041: dup
    //   1042: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   1045: astore 19
    //   1047: aload 19
    //   1049: ldc_w 651
    //   1052: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: pop
    //   1056: aload 19
    //   1058: aload 18
    //   1060: invokevirtual 654	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1063: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: ldc 176
    //   1069: iconst_2
    //   1070: aload 19
    //   1072: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1078: invokestatic 657	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1081: ifeq +44 -> 1125
    //   1084: new 167	java/lang/StringBuilder
    //   1087: dup
    //   1088: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   1091: astore 18
    //   1093: aload 18
    //   1095: ldc_w 659
    //   1098: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aload 18
    //   1104: aload 17
    //   1106: getfield 1388	SummaryCard/DateCard:uSchoolId	J
    //   1109: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1112: pop
    //   1113: ldc_w 661
    //   1116: iconst_4
    //   1117: aload 18
    //   1119: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1122: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1125: aload 16
    //   1127: aload_2
    //   1128: getfield 1443	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1131: putfield 1444	com/tencent/mobileqq/data/NearbyPeopleCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1134: aload 16
    //   1136: aload_2
    //   1137: getfield 1448	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1140: putfield 1449	com/tencent/mobileqq/data/NearbyPeopleCard:bHaveVotedCnt	S
    //   1143: aload 16
    //   1145: aload_2
    //   1146: getfield 1452	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1149: putfield 1453	com/tencent/mobileqq/data/NearbyPeopleCard:bAvailVoteCnt	S
    //   1152: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1155: ifeq +80 -> 1235
    //   1158: new 167	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   1165: astore 18
    //   1167: aload 18
    //   1169: ldc_w 1455
    //   1172: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: pop
    //   1176: aload 18
    //   1178: aload_2
    //   1179: getfield 1443	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1182: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload 18
    //   1188: ldc_w 1457
    //   1191: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: pop
    //   1195: aload 18
    //   1197: aload_2
    //   1198: getfield 1448	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1201: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload 18
    //   1207: ldc_w 1459
    //   1210: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: pop
    //   1214: aload 18
    //   1216: aload_2
    //   1217: getfield 1452	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1220: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1223: pop
    //   1224: ldc 176
    //   1226: iconst_2
    //   1227: aload 18
    //   1229: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1232: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1235: aload_2
    //   1236: getfield 1463	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1239: ifnull +54 -> 1293
    //   1242: aload 16
    //   1244: aload_2
    //   1245: getfield 1463	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1248: getfield 1468	SummaryCard/PanSocialInfo:uCharm	J
    //   1251: putfield 1471	com/tencent/mobileqq/data/NearbyPeopleCard:charm	J
    //   1254: aload 16
    //   1256: aload_2
    //   1257: getfield 1463	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1260: getfield 1474	SummaryCard/PanSocialInfo:uCharmLevel	J
    //   1263: l2i
    //   1264: putfield 1083	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   1267: aload 16
    //   1269: aload_2
    //   1270: getfield 1463	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1273: getfield 1477	SummaryCard/PanSocialInfo:uNextLevelCharm	J
    //   1276: l2i
    //   1277: putfield 1480	com/tencent/mobileqq/data/NearbyPeopleCard:nextThreshold	I
    //   1280: aload 16
    //   1282: aload_2
    //   1283: getfield 1463	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1286: getfield 1483	SummaryCard/PanSocialInfo:uCurLevelCharm	J
    //   1289: l2i
    //   1290: putfield 1486	com/tencent/mobileqq/data/NearbyPeopleCard:curThreshold	I
    //   1293: iload 5
    //   1295: ifeq +29 -> 1324
    //   1298: aload 16
    //   1300: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1303: aload_0
    //   1304: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1307: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1310: invokevirtual 1273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1313: ifeq +6 -> 1319
    //   1316: goto +8 -> 1324
    //   1319: iconst_0
    //   1320: istore_1
    //   1321: goto +5 -> 1326
    //   1324: iconst_1
    //   1325: istore_1
    //   1326: aload 16
    //   1328: aload 17
    //   1330: getfield 1489	SummaryCard/DateCard:vFaces	[B
    //   1333: aload_2
    //   1334: getfield 1493	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   1337: iload_1
    //   1338: invokevirtual 671	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1341: pop
    //   1342: aload 16
    //   1344: aload_2
    //   1345: getfield 1497	SummaryCard/RespSummaryCard:stQiqiVideoInfo	LSummaryCard/QiqiVideoInfo;
    //   1348: getfield 1502	SummaryCard/QiqiVideoInfo:uRoomid	J
    //   1351: putfield 1503	com/tencent/mobileqq/data/NearbyPeopleCard:uRoomid	J
    //   1354: aload_2
    //   1355: getfield 1506	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1358: ifne +12 -> 1370
    //   1361: aload 16
    //   1363: iconst_1
    //   1364: putfield 1509	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1367: goto +9 -> 1376
    //   1370: aload 16
    //   1372: iconst_0
    //   1373: putfield 1509	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1376: aload 4
    //   1378: ifnull +13 -> 1391
    //   1381: aload 16
    //   1383: aload 4
    //   1385: getfield 1514	SummaryCard/RespHead:vCookies	[B
    //   1388: putfield 1515	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   1391: aload 16
    //   1393: getfield 674	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1396: ldc2_w 675
    //   1399: land
    //   1400: lconst_0
    //   1401: lcmp
    //   1402: ifeq +12 -> 1414
    //   1405: aload 16
    //   1407: iconst_1
    //   1408: putfield 679	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1411: goto +9 -> 1420
    //   1414: aload 16
    //   1416: iconst_0
    //   1417: putfield 679	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1420: aload 16
    //   1422: getfield 674	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1425: ldc2_w 680
    //   1428: land
    //   1429: lconst_0
    //   1430: lcmp
    //   1431: ifeq +12 -> 1443
    //   1434: aload 16
    //   1436: iconst_1
    //   1437: putfield 684	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1440: goto +9 -> 1449
    //   1443: aload 16
    //   1445: iconst_0
    //   1446: putfield 684	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1449: aload 16
    //   1451: invokevirtual 687	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1454: istore_1
    //   1455: ldc_w 564
    //   1458: astore 23
    //   1460: iload_1
    //   1461: ifne +168 -> 1629
    //   1464: aload 16
    //   1466: ldc_w 564
    //   1469: putfield 690	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1472: aload 16
    //   1474: ldc_w 564
    //   1477: putfield 693	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1480: aload 16
    //   1482: ldc_w 564
    //   1485: putfield 696	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1488: aload_2
    //   1489: getfield 1519	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1492: astore 4
    //   1494: aload 4
    //   1496: ifnull +133 -> 1629
    //   1499: aload 4
    //   1501: getfield 1524	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1504: ifnull +125 -> 1629
    //   1507: aload 4
    //   1509: getfield 1524	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1512: invokevirtual 1525	java/util/ArrayList:size	()I
    //   1515: ifle +114 -> 1629
    //   1518: iconst_0
    //   1519: istore 6
    //   1521: iload 6
    //   1523: aload 4
    //   1525: getfield 1524	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1528: invokevirtual 1525	java/util/ArrayList:size	()I
    //   1531: if_icmpge +98 -> 1629
    //   1534: iload 6
    //   1536: ifne +27 -> 1563
    //   1539: aload 16
    //   1541: aload 4
    //   1543: getfield 1524	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1546: iload 6
    //   1548: invokevirtual 1526	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1551: checkcast 1528	SummaryCard/PhotoInfo
    //   1554: getfield 1531	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1557: putfield 690	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1560: goto +60 -> 1620
    //   1563: iload 6
    //   1565: iconst_1
    //   1566: if_icmpne +27 -> 1593
    //   1569: aload 16
    //   1571: aload 4
    //   1573: getfield 1524	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1576: iload 6
    //   1578: invokevirtual 1526	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1581: checkcast 1528	SummaryCard/PhotoInfo
    //   1584: getfield 1531	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1587: putfield 693	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1590: goto +30 -> 1620
    //   1593: iload 6
    //   1595: iconst_2
    //   1596: if_icmpne +24 -> 1620
    //   1599: aload 16
    //   1601: aload 4
    //   1603: getfield 1524	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1606: iload 6
    //   1608: invokevirtual 1526	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1611: checkcast 1528	SummaryCard/PhotoInfo
    //   1614: getfield 1531	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1617: putfield 696	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1620: iload 6
    //   1622: iconst_1
    //   1623: iadd
    //   1624: istore 6
    //   1626: goto -105 -> 1521
    //   1629: aload_2
    //   1630: getfield 1463	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1633: astore 4
    //   1635: aload 4
    //   1637: ifnull +38 -> 1675
    //   1640: aload 4
    //   1642: getfield 1534	SummaryCard/PanSocialInfo:uCharmRank	J
    //   1645: lconst_1
    //   1646: lcmp
    //   1647: ifne +12 -> 1659
    //   1650: aload 16
    //   1652: iconst_1
    //   1653: putfield 1537	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1656: goto +9 -> 1665
    //   1659: aload 16
    //   1661: iconst_0
    //   1662: putfield 1537	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1665: aload 16
    //   1667: aload 4
    //   1669: getfield 1540	SummaryCard/PanSocialInfo:strLevelType	Ljava/lang/String;
    //   1672: putfield 1541	com/tencent/mobileqq/data/NearbyPeopleCard:strLevelType	Ljava/lang/String;
    //   1675: aload_2
    //   1676: getfield 1544	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1679: ifnull +29 -> 1708
    //   1682: aload 16
    //   1684: aload_0
    //   1685: aload_2
    //   1686: getfield 1544	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1689: ldc_w 1546
    //   1692: new 1548	GameCenter/RespLastGameInfo
    //   1695: dup
    //   1696: invokespecial 1549	GameCenter/RespLastGameInfo:<init>	()V
    //   1699: invokevirtual 1553	com/tencent/mobileqq/nearby/business/NearbyCardHandler:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1702: checkcast 1548	GameCenter/RespLastGameInfo
    //   1705: invokevirtual 1557	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1708: aload_2
    //   1709: getfield 1463	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1712: astore 4
    //   1714: aload 4
    //   1716: ifnull +14 -> 1730
    //   1719: aload 16
    //   1721: aload 4
    //   1723: getfield 1560	SummaryCard/PanSocialInfo:uChatflag	J
    //   1726: l2i
    //   1727: putfield 1563	com/tencent/mobileqq/data/NearbyPeopleCard:sayHelloFlag	I
    //   1730: new 595	java/util/ArrayList
    //   1733: dup
    //   1734: invokespecial 596	java/util/ArrayList:<init>	()V
    //   1737: astore 29
    //   1739: aload 23
    //   1741: astore 18
    //   1743: aload 15
    //   1745: astore 22
    //   1747: iload 12
    //   1749: istore 11
    //   1751: iload 5
    //   1753: istore 6
    //   1755: aload 16
    //   1757: astore 20
    //   1759: aload_2
    //   1760: astore 21
    //   1762: aload 27
    //   1764: astore 19
    //   1766: aload_3
    //   1767: astore 17
    //   1769: aload_2
    //   1770: getfield 1566	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1773: ifnull +1759 -> 3532
    //   1776: aload 23
    //   1778: astore 18
    //   1780: aload 15
    //   1782: astore 22
    //   1784: iload 12
    //   1786: istore 11
    //   1788: iload 5
    //   1790: istore 6
    //   1792: aload 16
    //   1794: astore 20
    //   1796: aload_2
    //   1797: astore 21
    //   1799: aload 27
    //   1801: astore 19
    //   1803: aload_3
    //   1804: astore 17
    //   1806: aload_2
    //   1807: getfield 1566	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1810: invokevirtual 1525	java/util/ArrayList:size	()I
    //   1813: ifle +1719 -> 3532
    //   1816: iconst_0
    //   1817: istore 8
    //   1819: aload_3
    //   1820: astore 4
    //   1822: aload 16
    //   1824: astore_3
    //   1825: iload 12
    //   1827: istore_1
    //   1828: aload 23
    //   1830: astore 16
    //   1832: aload 16
    //   1834: astore 18
    //   1836: aload 15
    //   1838: astore 22
    //   1840: iload_1
    //   1841: istore 11
    //   1843: iload 5
    //   1845: istore 6
    //   1847: aload_3
    //   1848: astore 20
    //   1850: aload_2
    //   1851: astore 21
    //   1853: aload 27
    //   1855: astore 19
    //   1857: aload 4
    //   1859: astore 17
    //   1861: iload 8
    //   1863: aload_2
    //   1864: getfield 1566	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1867: invokevirtual 1525	java/util/ArrayList:size	()I
    //   1870: if_icmpge +1662 -> 3532
    //   1873: aload_2
    //   1874: getfield 1566	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1877: iload 8
    //   1879: invokevirtual 1526	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1882: checkcast 1567	[B
    //   1885: astore 18
    //   1887: aload 18
    //   1889: ifnonnull +9 -> 1898
    //   1892: iconst_0
    //   1893: istore 6
    //   1895: goto +8 -> 1903
    //   1898: aload 18
    //   1900: arraylength
    //   1901: istore 6
    //   1903: iload 6
    //   1905: bipush 10
    //   1907: if_icmpgt +6 -> 1913
    //   1910: goto +1569 -> 3479
    //   1913: aload 18
    //   1915: iconst_1
    //   1916: invokestatic 1573	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   1919: l2i
    //   1920: istore 7
    //   1922: aload 18
    //   1924: iconst_5
    //   1925: invokestatic 1573	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   1928: pop2
    //   1929: iload 7
    //   1931: ifle +1548 -> 3479
    //   1934: bipush 9
    //   1936: iload 7
    //   1938: iadd
    //   1939: iload 6
    //   1941: if_icmplt +6 -> 1947
    //   1944: goto +1535 -> 3479
    //   1947: iload 7
    //   1949: newarray byte
    //   1951: astore 17
    //   1953: aload 17
    //   1955: iconst_0
    //   1956: aload 18
    //   1958: bipush 9
    //   1960: iload 7
    //   1962: invokestatic 1577	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   1965: new 1579	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   1968: dup
    //   1969: invokespecial 1580	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   1972: astore 30
    //   1974: aload 30
    //   1976: aload 17
    //   1978: invokevirtual 1581	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1981: pop
    //   1982: aload 30
    //   1984: getfield 1584	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1987: invokevirtual 445	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1990: istore 10
    //   1992: new 1586	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry
    //   1995: dup
    //   1996: invokespecial 1587	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:<init>	()V
    //   1999: astore 24
    //   2001: iload 10
    //   2003: ifne +5234 -> 7237
    //   2006: aload 24
    //   2008: aload 30
    //   2010: getfield 1591	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2013: getfield 1596	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2016: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2019: putfield 1598	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:strName	Ljava/lang/String;
    //   2022: aload 24
    //   2024: aload 30
    //   2026: getfield 1591	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2029: getfield 1601	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2032: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2035: putfield 1603	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:strServiceUrl	Ljava/lang/String;
    //   2038: aload 24
    //   2040: aload 30
    //   2042: getfield 1606	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2045: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2048: putfield 1609	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:serviceType	I
    //   2051: new 595	java/util/ArrayList
    //   2054: dup
    //   2055: invokespecial 596	java/util/ArrayList:<init>	()V
    //   2058: astore 31
    //   2060: iconst_0
    //   2061: istore 7
    //   2063: aload 4
    //   2065: astore 17
    //   2067: aload 16
    //   2069: astore 4
    //   2071: iload 7
    //   2073: aload 30
    //   2075: getfield 1591	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2078: getfield 1612	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2081: invokevirtual 1613	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2084: if_icmpge +873 -> 2957
    //   2087: aload 30
    //   2089: getfield 1591	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2092: getfield 1612	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2095: iload 7
    //   2097: invokevirtual 1616	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2100: checkcast 1618	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   2103: astore 23
    //   2105: new 1620	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem
    //   2108: dup
    //   2109: invokespecial 1621	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:<init>	()V
    //   2112: astore 25
    //   2114: aload 25
    //   2116: aload 23
    //   2118: getfield 1624	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2121: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2124: putfield 1626	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strTitle	Ljava/lang/String;
    //   2127: aload 25
    //   2129: aload 23
    //   2131: getfield 1629	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2134: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2137: putfield 1631	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strCoverUrl	Ljava/lang/String;
    //   2140: aload 25
    //   2142: aload 23
    //   2144: getfield 1634	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2147: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2150: putfield 1636	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strJmpUrl	Ljava/lang/String;
    //   2153: aload 25
    //   2155: aload 23
    //   2157: getfield 1639	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2160: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2163: putfield 1641	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strSubInfo	Ljava/lang/String;
    //   2166: aload 25
    //   2168: aload 23
    //   2170: getfield 1644	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2173: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2176: putfield 1646	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strDesc	Ljava/lang/String;
    //   2179: aload 25
    //   2181: aload 23
    //   2183: getfield 1649	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2186: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2189: putfield 1651	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strTitleIconUrl	Ljava/lang/String;
    //   2192: aload 23
    //   2194: getfield 1654	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2197: astore 19
    //   2199: aload 4
    //   2201: astore 21
    //   2203: iload 5
    //   2205: istore 6
    //   2207: aload_3
    //   2208: astore 18
    //   2210: aload_2
    //   2211: astore 16
    //   2213: aload 25
    //   2215: aload 19
    //   2217: invokevirtual 277	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2220: putfield 1657	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:groupCode	J
    //   2223: iload 5
    //   2225: istore 6
    //   2227: aload_3
    //   2228: astore 18
    //   2230: aload_2
    //   2231: astore 16
    //   2233: aload 25
    //   2235: aload 24
    //   2237: getfield 1609	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:serviceType	I
    //   2240: putfield 1658	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:serviceType	I
    //   2243: iload 5
    //   2245: istore 6
    //   2247: aload_3
    //   2248: astore 18
    //   2250: aload_2
    //   2251: astore 16
    //   2253: aload 23
    //   2255: getfield 1661	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2258: invokevirtual 1613	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2261: ifle +4897 -> 7158
    //   2264: iload 5
    //   2266: istore 6
    //   2268: aload_3
    //   2269: astore 18
    //   2271: aload_2
    //   2272: astore 16
    //   2274: new 595	java/util/ArrayList
    //   2277: dup
    //   2278: invokespecial 596	java/util/ArrayList:<init>	()V
    //   2281: astore 26
    //   2283: iconst_0
    //   2284: istore 9
    //   2286: iload 5
    //   2288: istore 6
    //   2290: aload_3
    //   2291: astore 18
    //   2293: aload_2
    //   2294: astore 16
    //   2296: iload 9
    //   2298: aload 23
    //   2300: getfield 1661	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2303: invokevirtual 1613	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2306: if_icmpge +556 -> 2862
    //   2309: iload 5
    //   2311: istore 6
    //   2313: aload_3
    //   2314: astore 18
    //   2316: aload_2
    //   2317: astore 16
    //   2319: aload 23
    //   2321: getfield 1661	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2324: iload 9
    //   2326: invokevirtual 1616	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2329: checkcast 1663	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   2332: astore 32
    //   2334: iload 5
    //   2336: istore 6
    //   2338: aload_3
    //   2339: astore 18
    //   2341: aload_2
    //   2342: astore 16
    //   2344: new 1665	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel
    //   2347: dup
    //   2348: invokespecial 1666	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:<init>	()V
    //   2351: astore 33
    //   2353: iload 5
    //   2355: istore 6
    //   2357: aload 33
    //   2359: aload 32
    //   2361: getfield 1669	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2364: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2367: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2370: putfield 1672	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:strWording	Ljava/lang/String;
    //   2373: aload 32
    //   2375: getfield 1675	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2378: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2381: istore 5
    //   2383: aload_3
    //   2384: astore 20
    //   2386: aload_2
    //   2387: astore 22
    //   2389: iload 5
    //   2391: i2l
    //   2392: lstore 13
    //   2394: aload 15
    //   2396: astore 19
    //   2398: aload 17
    //   2400: astore 18
    //   2402: aload 21
    //   2404: astore 16
    //   2406: iload 6
    //   2408: istore 5
    //   2410: aload 22
    //   2412: astore_3
    //   2413: aload 20
    //   2415: astore_2
    //   2416: aload 33
    //   2418: lload 13
    //   2420: putfield 1678	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:type	J
    //   2423: aload 15
    //   2425: astore 19
    //   2427: aload 17
    //   2429: astore 18
    //   2431: aload 21
    //   2433: astore 16
    //   2435: iload 6
    //   2437: istore 5
    //   2439: aload 22
    //   2441: astore_3
    //   2442: aload 20
    //   2444: astore_2
    //   2445: aload 33
    //   2447: aload 32
    //   2449: getfield 1681	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2452: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2455: i2l
    //   2456: putfield 1684	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:attr	J
    //   2459: aload 15
    //   2461: astore 19
    //   2463: aload 17
    //   2465: astore 18
    //   2467: aload 21
    //   2469: astore 16
    //   2471: iload 6
    //   2473: istore 5
    //   2475: aload 22
    //   2477: astore_3
    //   2478: aload 20
    //   2480: astore_2
    //   2481: new 1686	com/tencent/mobileqq/profilecard/entity/ProfileColor
    //   2484: dup
    //   2485: invokespecial 1687	com/tencent/mobileqq/profilecard/entity/ProfileColor:<init>	()V
    //   2488: astore 34
    //   2490: aload 15
    //   2492: astore 19
    //   2494: aload 17
    //   2496: astore 18
    //   2498: aload 21
    //   2500: astore 16
    //   2502: iload 6
    //   2504: istore 5
    //   2506: aload 22
    //   2508: astore_3
    //   2509: aload 20
    //   2511: astore_2
    //   2512: aload 34
    //   2514: aload 32
    //   2516: getfield 1691	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2519: getfield 1696	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2522: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2525: i2l
    //   2526: putfield 1699	com/tencent/mobileqq/profilecard/entity/ProfileColor:red	J
    //   2529: aload 15
    //   2531: astore 19
    //   2533: aload 17
    //   2535: astore 18
    //   2537: aload 21
    //   2539: astore 16
    //   2541: iload 6
    //   2543: istore 5
    //   2545: aload 22
    //   2547: astore_3
    //   2548: aload 20
    //   2550: astore_2
    //   2551: aload 34
    //   2553: aload 32
    //   2555: getfield 1691	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2558: getfield 1702	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2561: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2564: i2l
    //   2565: putfield 1705	com/tencent/mobileqq/profilecard/entity/ProfileColor:green	J
    //   2568: aload 15
    //   2570: astore 19
    //   2572: aload 17
    //   2574: astore 18
    //   2576: aload 21
    //   2578: astore 16
    //   2580: iload 6
    //   2582: istore 5
    //   2584: aload 22
    //   2586: astore_3
    //   2587: aload 20
    //   2589: astore_2
    //   2590: aload 34
    //   2592: aload 32
    //   2594: getfield 1691	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2597: getfield 1708	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2600: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2603: i2l
    //   2604: putfield 1711	com/tencent/mobileqq/profilecard/entity/ProfileColor:blue	J
    //   2607: aload 15
    //   2609: astore 19
    //   2611: aload 17
    //   2613: astore 18
    //   2615: aload 21
    //   2617: astore 16
    //   2619: iload 6
    //   2621: istore 5
    //   2623: aload 22
    //   2625: astore_3
    //   2626: aload 20
    //   2628: astore_2
    //   2629: aload 33
    //   2631: aload 34
    //   2633: putfield 1715	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:edgingColor	Lcom/tencent/mobileqq/profilecard/entity/ProfileColor;
    //   2636: aload 15
    //   2638: astore 19
    //   2640: aload 17
    //   2642: astore 18
    //   2644: aload 21
    //   2646: astore 16
    //   2648: iload 6
    //   2650: istore 5
    //   2652: aload 22
    //   2654: astore_3
    //   2655: aload 20
    //   2657: astore_2
    //   2658: new 1686	com/tencent/mobileqq/profilecard/entity/ProfileColor
    //   2661: dup
    //   2662: invokespecial 1687	com/tencent/mobileqq/profilecard/entity/ProfileColor:<init>	()V
    //   2665: astore 34
    //   2667: aload 15
    //   2669: astore 19
    //   2671: aload 17
    //   2673: astore 18
    //   2675: aload 21
    //   2677: astore 16
    //   2679: iload 6
    //   2681: istore 5
    //   2683: aload 22
    //   2685: astore_3
    //   2686: aload 20
    //   2688: astore_2
    //   2689: aload 34
    //   2691: aload 32
    //   2693: getfield 1718	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2696: getfield 1696	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2699: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2702: i2l
    //   2703: putfield 1699	com/tencent/mobileqq/profilecard/entity/ProfileColor:red	J
    //   2706: aload 15
    //   2708: astore 19
    //   2710: aload 17
    //   2712: astore 18
    //   2714: aload 21
    //   2716: astore 16
    //   2718: iload 6
    //   2720: istore 5
    //   2722: aload 22
    //   2724: astore_3
    //   2725: aload 20
    //   2727: astore_2
    //   2728: aload 34
    //   2730: aload 32
    //   2732: getfield 1718	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2735: getfield 1702	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2738: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2741: i2l
    //   2742: putfield 1705	com/tencent/mobileqq/profilecard/entity/ProfileColor:green	J
    //   2745: aload 15
    //   2747: astore 19
    //   2749: aload 17
    //   2751: astore 18
    //   2753: aload 21
    //   2755: astore 16
    //   2757: iload 6
    //   2759: istore 5
    //   2761: aload 22
    //   2763: astore_3
    //   2764: aload 20
    //   2766: astore_2
    //   2767: aload 34
    //   2769: aload 32
    //   2771: getfield 1718	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2774: getfield 1708	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2777: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2780: i2l
    //   2781: putfield 1711	com/tencent/mobileqq/profilecard/entity/ProfileColor:blue	J
    //   2784: aload 15
    //   2786: astore 19
    //   2788: aload 17
    //   2790: astore 18
    //   2792: aload 21
    //   2794: astore 16
    //   2796: iload 6
    //   2798: istore 5
    //   2800: aload 22
    //   2802: astore_3
    //   2803: aload 20
    //   2805: astore_2
    //   2806: aload 33
    //   2808: aload 34
    //   2810: putfield 1721	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:textColor	Lcom/tencent/mobileqq/profilecard/entity/ProfileColor;
    //   2813: aload 15
    //   2815: astore 19
    //   2817: aload 17
    //   2819: astore 18
    //   2821: aload 21
    //   2823: astore 16
    //   2825: iload 6
    //   2827: istore 5
    //   2829: aload 22
    //   2831: astore_3
    //   2832: aload 20
    //   2834: astore_2
    //   2835: aload 26
    //   2837: aload 33
    //   2839: invokevirtual 1722	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2842: pop
    //   2843: iload 9
    //   2845: iconst_1
    //   2846: iadd
    //   2847: istore 9
    //   2849: iload 6
    //   2851: istore 5
    //   2853: aload 22
    //   2855: astore_2
    //   2856: aload 20
    //   2858: astore_3
    //   2859: goto -573 -> 2286
    //   2862: iload 5
    //   2864: istore 6
    //   2866: aload_3
    //   2867: astore 20
    //   2869: aload_2
    //   2870: astore 4
    //   2872: aload 15
    //   2874: astore 19
    //   2876: aload 17
    //   2878: astore 18
    //   2880: aload 21
    //   2882: astore 16
    //   2884: iload 6
    //   2886: istore 5
    //   2888: aload 4
    //   2890: astore_3
    //   2891: aload 20
    //   2893: astore_2
    //   2894: aload 25
    //   2896: aload 26
    //   2898: putfield 1725	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:labels	Ljava/util/ArrayList;
    //   2901: goto +3 -> 2904
    //   2904: aload 15
    //   2906: astore 19
    //   2908: aload 17
    //   2910: astore 18
    //   2912: aload 21
    //   2914: astore 16
    //   2916: iload 6
    //   2918: istore 5
    //   2920: aload 4
    //   2922: astore_3
    //   2923: aload 20
    //   2925: astore_2
    //   2926: aload 31
    //   2928: aload 25
    //   2930: invokevirtual 1722	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2933: pop
    //   2934: iload 7
    //   2936: iconst_1
    //   2937: iadd
    //   2938: istore 7
    //   2940: iload 6
    //   2942: istore 5
    //   2944: aload 4
    //   2946: astore_2
    //   2947: aload 20
    //   2949: astore_3
    //   2950: aload 21
    //   2952: astore 4
    //   2954: goto -883 -> 2071
    //   2957: iload 5
    //   2959: istore 7
    //   2961: aload_3
    //   2962: astore 26
    //   2964: aload_2
    //   2965: astore 25
    //   2967: aload 15
    //   2969: astore 19
    //   2971: aload 17
    //   2973: astore 18
    //   2975: aload 4
    //   2977: astore 16
    //   2979: iload 7
    //   2981: istore 5
    //   2983: aload 25
    //   2985: astore_3
    //   2986: aload 26
    //   2988: astore_2
    //   2989: aload 24
    //   2991: aload 31
    //   2993: putfield 1728	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:sProfileSummaryHobbiesItem	Ljava/util/ArrayList;
    //   2996: aload 15
    //   2998: astore 20
    //   3000: aload 17
    //   3002: astore 22
    //   3004: aload 4
    //   3006: astore 23
    //   3008: goto +3 -> 3011
    //   3011: aload 20
    //   3013: astore 19
    //   3015: aload 22
    //   3017: astore 18
    //   3019: aload 23
    //   3021: astore 16
    //   3023: iload 7
    //   3025: istore 5
    //   3027: aload 25
    //   3029: astore_3
    //   3030: aload 26
    //   3032: astore_2
    //   3033: aload 29
    //   3035: aload 24
    //   3037: invokeinterface 637 2 0
    //   3042: pop
    //   3043: aload 20
    //   3045: astore 19
    //   3047: aload 22
    //   3049: astore 18
    //   3051: aload 23
    //   3053: astore 16
    //   3055: iload 7
    //   3057: istore 5
    //   3059: aload 25
    //   3061: astore_3
    //   3062: aload 26
    //   3064: astore_2
    //   3065: aload 20
    //   3067: astore 24
    //   3069: aload 22
    //   3071: astore 21
    //   3073: aload 23
    //   3075: astore 17
    //   3077: iload 7
    //   3079: istore 6
    //   3081: aload 25
    //   3083: astore 15
    //   3085: aload 26
    //   3087: astore 4
    //   3089: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3092: ifeq +409 -> 3501
    //   3095: aload 20
    //   3097: astore 19
    //   3099: aload 22
    //   3101: astore 18
    //   3103: aload 23
    //   3105: astore 16
    //   3107: iload 7
    //   3109: istore 5
    //   3111: aload 25
    //   3113: astore_3
    //   3114: aload 26
    //   3116: astore_2
    //   3117: new 167	java/lang/StringBuilder
    //   3120: dup
    //   3121: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   3124: astore 4
    //   3126: aload 20
    //   3128: astore 19
    //   3130: aload 22
    //   3132: astore 18
    //   3134: aload 23
    //   3136: astore 16
    //   3138: iload 7
    //   3140: istore 5
    //   3142: aload 25
    //   3144: astore_3
    //   3145: aload 26
    //   3147: astore_2
    //   3148: aload 4
    //   3150: ldc_w 1730
    //   3153: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3156: pop
    //   3157: aload 20
    //   3159: astore 19
    //   3161: aload 22
    //   3163: astore 18
    //   3165: aload 23
    //   3167: astore 16
    //   3169: iload 7
    //   3171: istore 5
    //   3173: aload 25
    //   3175: astore_3
    //   3176: aload 26
    //   3178: astore_2
    //   3179: aload 4
    //   3181: aload 30
    //   3183: getfield 1606	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3186: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3189: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3192: pop
    //   3193: aload 20
    //   3195: astore 19
    //   3197: aload 22
    //   3199: astore 18
    //   3201: aload 23
    //   3203: astore 16
    //   3205: iload 7
    //   3207: istore 5
    //   3209: aload 25
    //   3211: astore_3
    //   3212: aload 26
    //   3214: astore_2
    //   3215: aload 4
    //   3217: ldc_w 1732
    //   3220: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3223: pop
    //   3224: aload 20
    //   3226: astore 19
    //   3228: aload 22
    //   3230: astore 18
    //   3232: aload 23
    //   3234: astore 16
    //   3236: iload 7
    //   3238: istore 5
    //   3240: aload 25
    //   3242: astore_3
    //   3243: aload 26
    //   3245: astore_2
    //   3246: aload 4
    //   3248: iload 10
    //   3250: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3253: pop
    //   3254: aload 20
    //   3256: astore 19
    //   3258: aload 22
    //   3260: astore 18
    //   3262: aload 23
    //   3264: astore 16
    //   3266: iload 7
    //   3268: istore 5
    //   3270: aload 25
    //   3272: astore_3
    //   3273: aload 26
    //   3275: astore_2
    //   3276: aload 4
    //   3278: ldc_w 1734
    //   3281: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3284: pop
    //   3285: aload 20
    //   3287: astore 19
    //   3289: aload 22
    //   3291: astore 18
    //   3293: aload 23
    //   3295: astore 16
    //   3297: iload 7
    //   3299: istore 5
    //   3301: aload 25
    //   3303: astore_3
    //   3304: aload 26
    //   3306: astore_2
    //   3307: aload 4
    //   3309: aload 30
    //   3311: getfield 1737	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3314: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3317: pop
    //   3318: aload 20
    //   3320: astore 19
    //   3322: aload 22
    //   3324: astore 18
    //   3326: aload 23
    //   3328: astore 16
    //   3330: iload 7
    //   3332: istore 5
    //   3334: aload 25
    //   3336: astore_3
    //   3337: aload 26
    //   3339: astore_2
    //   3340: ldc_w 661
    //   3343: iconst_2
    //   3344: aload 4
    //   3346: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3349: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3352: aload 20
    //   3354: astore 24
    //   3356: aload 22
    //   3358: astore 21
    //   3360: aload 23
    //   3362: astore 17
    //   3364: iload 7
    //   3366: istore 6
    //   3368: aload 25
    //   3370: astore 15
    //   3372: aload 26
    //   3374: astore 4
    //   3376: goto +125 -> 3501
    //   3379: astore 20
    //   3381: goto +33 -> 3414
    //   3384: astore 18
    //   3386: aload 4
    //   3388: astore 17
    //   3390: aload 18
    //   3392: astore 4
    //   3394: aload_2
    //   3395: astore 18
    //   3397: aload_3
    //   3398: astore_2
    //   3399: aload 18
    //   3401: astore_3
    //   3402: aload 17
    //   3404: astore 18
    //   3406: aload 15
    //   3408: astore 19
    //   3410: aload 4
    //   3412: astore 20
    //   3414: aload 19
    //   3416: astore 24
    //   3418: aload 18
    //   3420: astore 21
    //   3422: aload 16
    //   3424: astore 17
    //   3426: iload 5
    //   3428: istore 6
    //   3430: aload_3
    //   3431: astore 15
    //   3433: aload_2
    //   3434: astore 4
    //   3436: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3439: ifeq +62 -> 3501
    //   3442: ldc_w 661
    //   3445: iconst_2
    //   3446: aload 20
    //   3448: invokevirtual 729	java/lang/Exception:toString	()Ljava/lang/String;
    //   3451: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3454: aload 19
    //   3456: astore 24
    //   3458: aload 18
    //   3460: astore 21
    //   3462: aload 16
    //   3464: astore 17
    //   3466: iload 5
    //   3468: istore 6
    //   3470: aload_3
    //   3471: astore 15
    //   3473: aload_2
    //   3474: astore 4
    //   3476: goto +25 -> 3501
    //   3479: aload 15
    //   3481: astore 24
    //   3483: aload 4
    //   3485: astore 21
    //   3487: aload_3
    //   3488: astore 4
    //   3490: aload_2
    //   3491: astore 15
    //   3493: iload 5
    //   3495: istore 6
    //   3497: aload 16
    //   3499: astore 17
    //   3501: iload 8
    //   3503: iconst_1
    //   3504: iadd
    //   3505: istore 8
    //   3507: aload 17
    //   3509: astore 16
    //   3511: iload 6
    //   3513: istore 5
    //   3515: aload 15
    //   3517: astore_2
    //   3518: aload 4
    //   3520: astore_3
    //   3521: aload 24
    //   3523: astore 15
    //   3525: aload 21
    //   3527: astore 4
    //   3529: goto -1697 -> 1832
    //   3532: aload 18
    //   3534: astore_2
    //   3535: new 595	java/util/ArrayList
    //   3538: dup
    //   3539: invokespecial 596	java/util/ArrayList:<init>	()V
    //   3542: astore 4
    //   3544: aload_2
    //   3545: astore_3
    //   3546: aload 21
    //   3548: getfield 1740	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3551: ifnull +410 -> 3961
    //   3554: aload_2
    //   3555: astore_3
    //   3556: aload 21
    //   3558: getfield 1740	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3561: invokevirtual 1525	java/util/ArrayList:size	()I
    //   3564: ifle +397 -> 3961
    //   3567: iconst_0
    //   3568: istore 5
    //   3570: aload_2
    //   3571: astore_3
    //   3572: iload 5
    //   3574: aload 21
    //   3576: getfield 1740	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3579: invokevirtual 1525	java/util/ArrayList:size	()I
    //   3582: if_icmpge +379 -> 3961
    //   3585: aload 21
    //   3587: getfield 1740	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3590: iload 5
    //   3592: invokevirtual 1526	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3595: checkcast 1567	[B
    //   3598: astore_3
    //   3599: aload_3
    //   3600: ifnonnull +9 -> 3609
    //   3603: iconst_0
    //   3604: istore 7
    //   3606: goto +7 -> 3613
    //   3609: aload_3
    //   3610: arraylength
    //   3611: istore 7
    //   3613: iload 7
    //   3615: bipush 10
    //   3617: if_icmpgt +6 -> 3623
    //   3620: goto +332 -> 3952
    //   3623: aload_3
    //   3624: iconst_1
    //   3625: invokestatic 1573	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   3628: l2i
    //   3629: istore 8
    //   3631: aload_3
    //   3632: iconst_5
    //   3633: invokestatic 1573	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   3636: pop2
    //   3637: iload 8
    //   3639: ifle +313 -> 3952
    //   3642: bipush 9
    //   3644: iload 8
    //   3646: iadd
    //   3647: iload 7
    //   3649: if_icmplt +6 -> 3655
    //   3652: goto +300 -> 3952
    //   3655: iload 8
    //   3657: newarray byte
    //   3659: astore 15
    //   3661: aload 15
    //   3663: iconst_0
    //   3664: aload_3
    //   3665: bipush 9
    //   3667: iload 8
    //   3669: invokestatic 1577	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   3672: new 1579	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   3675: dup
    //   3676: invokespecial 1580	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   3679: astore_3
    //   3680: aload_3
    //   3681: aload 15
    //   3683: invokevirtual 1581	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3686: pop
    //   3687: aload_3
    //   3688: getfield 1584	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3691: invokevirtual 445	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3694: istore 7
    //   3696: iload 7
    //   3698: ifne +141 -> 3839
    //   3701: new 1742	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry
    //   3704: dup
    //   3705: invokespecial 1743	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:<init>	()V
    //   3708: astore 15
    //   3710: aload 15
    //   3712: aload_3
    //   3713: getfield 1606	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3716: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3719: putfield 1746	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:nBusiEntryType	I
    //   3722: aload_3
    //   3723: getfield 1750	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3726: ifnull +66 -> 3792
    //   3729: aload 15
    //   3731: aload_3
    //   3732: getfield 1750	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3735: getfield 1755	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3738: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3741: putfield 1758	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strLogoUrl	Ljava/lang/String;
    //   3744: aload 15
    //   3746: aload_3
    //   3747: getfield 1750	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3750: getfield 1761	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3753: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3756: putfield 1762	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strTitle	Ljava/lang/String;
    //   3759: aload 15
    //   3761: aload_3
    //   3762: getfield 1750	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3765: getfield 1765	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3768: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3771: putfield 1768	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strContent	Ljava/lang/String;
    //   3774: aload 15
    //   3776: aload_3
    //   3777: getfield 1750	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3780: getfield 1771	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3783: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3786: putfield 1772	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strJumpUrl	Ljava/lang/String;
    //   3789: goto +29 -> 3818
    //   3792: aload_2
    //   3793: astore_3
    //   3794: aload 15
    //   3796: aload_3
    //   3797: putfield 1758	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strLogoUrl	Ljava/lang/String;
    //   3800: aload 15
    //   3802: aload_3
    //   3803: putfield 1762	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strTitle	Ljava/lang/String;
    //   3806: aload 15
    //   3808: aload_3
    //   3809: putfield 1768	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strContent	Ljava/lang/String;
    //   3812: aload 15
    //   3814: aload_3
    //   3815: putfield 1772	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strJumpUrl	Ljava/lang/String;
    //   3818: aload 15
    //   3820: invokevirtual 1775	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:isEmpty	()Z
    //   3823: ifne +129 -> 3952
    //   3826: aload 4
    //   3828: aload 15
    //   3830: invokeinterface 637 2 0
    //   3835: pop
    //   3836: goto +116 -> 3952
    //   3839: invokestatic 657	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3842: ifeq +110 -> 3952
    //   3845: new 167	java/lang/StringBuilder
    //   3848: dup
    //   3849: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   3852: astore 15
    //   3854: aload 15
    //   3856: ldc_w 1777
    //   3859: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3862: pop
    //   3863: aload 15
    //   3865: aload_3
    //   3866: getfield 1606	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3869: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3872: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3875: pop
    //   3876: aload 15
    //   3878: ldc_w 1779
    //   3881: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3884: pop
    //   3885: aload 15
    //   3887: iload 7
    //   3889: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3892: pop
    //   3893: aload 15
    //   3895: ldc_w 1779
    //   3898: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3901: pop
    //   3902: aload 15
    //   3904: aload_3
    //   3905: getfield 1737	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3908: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3911: pop
    //   3912: ldc_w 661
    //   3915: iconst_4
    //   3916: aload 15
    //   3918: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3921: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3924: goto +28 -> 3952
    //   3927: astore_3
    //   3928: goto +4 -> 3932
    //   3931: astore_3
    //   3932: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3935: ifeq +17 -> 3952
    //   3938: ldc_w 661
    //   3941: iconst_2
    //   3942: aload_3
    //   3943: invokevirtual 729	java/lang/Exception:toString	()Ljava/lang/String;
    //   3946: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3949: goto +3 -> 3952
    //   3952: iload 5
    //   3954: iconst_1
    //   3955: iadd
    //   3956: istore 5
    //   3958: goto -388 -> 3570
    //   3961: aload 20
    //   3963: aload 4
    //   3965: invokevirtual 1783	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   3968: aload 21
    //   3970: getfield 1787	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3973: ifnonnull +22 -> 3995
    //   3976: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3979: ifeq +82 -> 4061
    //   3982: ldc_w 661
    //   3985: iconst_2
    //   3986: ldc_w 731
    //   3989: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3992: goto +69 -> 4061
    //   3995: aload 21
    //   3997: getfield 1787	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   4000: getfield 1792	SummaryCard/InterestTagInfo:uFlag	J
    //   4003: lstore 13
    //   4005: new 710	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   4008: dup
    //   4009: invokespecial 711	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   4012: astore_2
    //   4013: aload_2
    //   4014: aload 21
    //   4016: getfield 1787	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   4019: getfield 1793	SummaryCard/InterestTagInfo:vGiftInfo	[B
    //   4022: invokevirtual 715	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4025: pop
    //   4026: aload 20
    //   4028: lload 13
    //   4030: aload_2
    //   4031: getfield 719	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4034: invokevirtual 722	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4037: invokevirtual 726	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   4040: goto +21 -> 4061
    //   4043: astore_2
    //   4044: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4047: ifeq +14 -> 4061
    //   4050: ldc_w 728
    //   4053: iconst_2
    //   4054: aload_2
    //   4055: invokevirtual 729	java/lang/Exception:toString	()Ljava/lang/String;
    //   4058: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4061: aload 21
    //   4063: getfield 1796	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   4066: ifnull +243 -> 4309
    //   4069: new 1798	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody
    //   4072: dup
    //   4073: invokespecial 1799	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:<init>	()V
    //   4076: astore_2
    //   4077: aload_2
    //   4078: aload 21
    //   4080: getfield 1796	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   4083: invokevirtual 1800	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4086: pop
    //   4087: goto +23 -> 4110
    //   4090: astore 4
    //   4092: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4095: ifeq +15 -> 4110
    //   4098: ldc_w 661
    //   4101: iconst_2
    //   4102: aload 4
    //   4104: invokevirtual 729	java/lang/Exception:toString	()Ljava/lang/String;
    //   4107: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4110: aload_2
    //   4111: getfield 1803	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:rpt_msg_wifi_poi_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4114: invokevirtual 722	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4117: astore_2
    //   4118: new 595	java/util/ArrayList
    //   4121: dup
    //   4122: invokespecial 596	java/util/ArrayList:<init>	()V
    //   4125: astore 4
    //   4127: aload_2
    //   4128: ifnull +66 -> 4194
    //   4131: aload_2
    //   4132: invokeinterface 1203 1 0
    //   4137: astore_2
    //   4138: aload_2
    //   4139: invokeinterface 1208 1 0
    //   4144: ifeq +50 -> 4194
    //   4147: aload_2
    //   4148: invokeinterface 1212 1 0
    //   4153: checkcast 1805	tencent/im/oidb/hotchat/Common$WifiPOIInfo
    //   4156: astore 15
    //   4158: aload 15
    //   4160: getfield 1808	tencent/im/oidb/hotchat/Common$WifiPOIInfo:uint32_wifi_poi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4163: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4166: iconst_1
    //   4167: if_icmpne +8 -> 4175
    //   4170: iconst_1
    //   4171: istore_1
    //   4172: goto +5 -> 4177
    //   4175: iconst_0
    //   4176: istore_1
    //   4177: aload 4
    //   4179: aload 15
    //   4181: iload_1
    //   4182: invokestatic 1814	com/tencent/mobileqq/data/HotChatInfo:createHotChat	(Ltencent/im/oidb/hotchat/Common$WifiPOIInfo;Z)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   4185: invokeinterface 637 2 0
    //   4190: pop
    //   4191: goto -53 -> 4138
    //   4194: aload 4
    //   4196: invokeinterface 627 1 0
    //   4201: ifle +47 -> 4248
    //   4204: iconst_0
    //   4205: istore 5
    //   4207: iload 5
    //   4209: aload 4
    //   4211: invokeinterface 627 1 0
    //   4216: if_icmpge +32 -> 4248
    //   4219: aload 4
    //   4221: iload 5
    //   4223: invokeinterface 630 2 0
    //   4228: checkcast 1810	com/tencent/mobileqq/data/HotChatInfo
    //   4231: astore_2
    //   4232: aload_2
    //   4233: ifnull +6 -> 4239
    //   4236: goto +14 -> 4250
    //   4239: iload 5
    //   4241: iconst_1
    //   4242: iadd
    //   4243: istore 5
    //   4245: goto -38 -> 4207
    //   4248: aconst_null
    //   4249: astore_2
    //   4250: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4253: ifeq +43 -> 4296
    //   4256: new 167	java/lang/StringBuilder
    //   4259: dup
    //   4260: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   4263: astore 4
    //   4265: aload 4
    //   4267: ldc_w 1816
    //   4270: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4273: pop
    //   4274: aload 4
    //   4276: aload_2
    //   4277: invokevirtual 1437	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4280: pop
    //   4281: ldc_w 661
    //   4284: iconst_2
    //   4285: aload 4
    //   4287: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4290: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4293: goto +3 -> 4296
    //   4296: aload_2
    //   4297: ifnull +28 -> 4325
    //   4300: aload 20
    //   4302: aload_2
    //   4303: invokevirtual 1820	com/tencent/mobileqq/data/NearbyPeopleCard:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   4306: goto +19 -> 4325
    //   4309: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4312: ifeq +13 -> 4325
    //   4315: ldc_w 661
    //   4318: iconst_2
    //   4319: ldc_w 1822
    //   4322: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4325: aload 20
    //   4327: getfield 504	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   4330: ifnull +1223 -> 5553
    //   4333: new 777	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   4336: dup
    //   4337: invokespecial 778	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   4340: astore 4
    //   4342: aload 4
    //   4344: aload 20
    //   4346: getfield 504	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   4349: invokevirtual 779	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4352: pop
    //   4353: iload 6
    //   4355: istore 5
    //   4357: iload 5
    //   4359: bipush 51
    //   4361: if_icmpne +84 -> 4445
    //   4364: aload 4
    //   4366: getfield 782	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4369: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4372: iconst_1
    //   4373: if_icmpne +2889 -> 7262
    //   4376: iconst_1
    //   4377: istore_1
    //   4378: goto +3 -> 4381
    //   4381: aload 20
    //   4383: iload_1
    //   4384: putfield 362	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   4387: aload 4
    //   4389: getfield 785	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4392: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4395: iconst_1
    //   4396: if_icmpne +2871 -> 7267
    //   4399: iconst_1
    //   4400: istore_1
    //   4401: goto +3 -> 4404
    //   4404: aload 20
    //   4406: iload_1
    //   4407: putfield 349	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   4410: aload 20
    //   4412: aload 4
    //   4414: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4417: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4420: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4423: putfield 374	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   4426: aload 20
    //   4428: aload 4
    //   4430: getfield 791	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4433: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4436: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4439: putfield 368	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   4442: goto +91 -> 4533
    //   4445: aload 20
    //   4447: aload 4
    //   4449: getfield 782	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4452: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4455: putfield 356	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4458: aload 20
    //   4460: getfield 356	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4463: iconst_1
    //   4464: if_icmpne +2808 -> 7272
    //   4467: iconst_1
    //   4468: istore_1
    //   4469: goto +3 -> 4472
    //   4472: aload 20
    //   4474: iload_1
    //   4475: putfield 352	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   4478: aload 4
    //   4480: getfield 785	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4483: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4486: iconst_1
    //   4487: if_icmpne +2790 -> 7277
    //   4490: iconst_1
    //   4491: istore_1
    //   4492: goto +3 -> 4495
    //   4495: aload 20
    //   4497: iload_1
    //   4498: putfield 346	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   4501: aload 20
    //   4503: aload 4
    //   4505: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4508: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4511: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4514: putfield 371	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   4517: aload 20
    //   4519: aload 4
    //   4521: getfield 791	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4524: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4527: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4530: putfield 365	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   4533: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4536: ifeq +105 -> 4641
    //   4539: new 167	java/lang/StringBuilder
    //   4542: dup
    //   4543: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   4546: astore_2
    //   4547: aload_2
    //   4548: ldc_w 793
    //   4551: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4554: pop
    //   4555: aload_2
    //   4556: iload 5
    //   4558: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4561: pop
    //   4562: aload_2
    //   4563: ldc_w 795
    //   4566: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4569: pop
    //   4570: aload_2
    //   4571: aload 4
    //   4573: getfield 782	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4576: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4579: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4582: pop
    //   4583: aload_2
    //   4584: ldc_w 797
    //   4587: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4590: pop
    //   4591: aload_2
    //   4592: aload 4
    //   4594: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4597: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4600: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4603: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4606: pop
    //   4607: aload_2
    //   4608: ldc_w 799
    //   4611: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4614: pop
    //   4615: aload_2
    //   4616: aload_0
    //   4617: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4620: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4623: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4626: pop
    //   4627: ldc_w 801
    //   4630: iconst_2
    //   4631: aload_2
    //   4632: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4635: invokestatic 804	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4638: goto +2644 -> 7282
    //   4641: new 167	java/lang/StringBuilder
    //   4644: dup
    //   4645: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   4648: astore_2
    //   4649: aload_2
    //   4650: ldc_w 793
    //   4653: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4656: pop
    //   4657: aload_2
    //   4658: iload 5
    //   4660: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4663: pop
    //   4664: aload_2
    //   4665: ldc_w 795
    //   4668: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4671: pop
    //   4672: aload_2
    //   4673: aload 4
    //   4675: getfield 782	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4678: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4681: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4684: pop
    //   4685: aload_2
    //   4686: ldc_w 797
    //   4689: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4692: pop
    //   4693: aload_2
    //   4694: aload 4
    //   4696: getfield 788	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4699: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4702: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4705: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4708: pop
    //   4709: ldc_w 801
    //   4712: iconst_1
    //   4713: aload_2
    //   4714: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4717: invokestatic 804	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4720: goto +2562 -> 7282
    //   4723: astore_2
    //   4724: goto +4 -> 4728
    //   4727: astore_2
    //   4728: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4731: ifeq +2551 -> 7282
    //   4734: new 167	java/lang/StringBuilder
    //   4737: dup
    //   4738: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   4741: astore 15
    //   4743: aload 15
    //   4745: ldc_w 806
    //   4748: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4751: pop
    //   4752: aload 15
    //   4754: aload_2
    //   4755: invokevirtual 729	java/lang/Exception:toString	()Ljava/lang/String;
    //   4758: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4761: pop
    //   4762: aload 15
    //   4764: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4767: astore_2
    //   4768: aload 17
    //   4770: iconst_2
    //   4771: aload_2
    //   4772: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4775: goto +3 -> 4778
    //   4778: aload 17
    //   4780: astore_2
    //   4781: aload 20
    //   4783: aload 4
    //   4785: getfield 809	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4788: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4791: putfield 359	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   4794: aload 4
    //   4796: getfield 813	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4799: invokevirtual 816	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   4802: ifeq +147 -> 4949
    //   4805: aload 20
    //   4807: aload 4
    //   4809: getfield 813	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4812: invokevirtual 817	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4815: checkcast 815	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4818: getfield 820	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4821: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4824: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4827: putfield 392	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   4830: aload 20
    //   4832: aload 4
    //   4834: getfield 813	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4837: invokevirtual 817	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4840: checkcast 815	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4843: getfield 823	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4846: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4849: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4852: putfield 389	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   4855: aload 20
    //   4857: aload 4
    //   4859: getfield 813	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4862: invokevirtual 817	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4865: checkcast 815	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4868: getfield 826	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4871: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4874: putfield 386	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   4877: aload 20
    //   4879: aload 4
    //   4881: getfield 813	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4884: invokevirtual 817	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4887: checkcast 815	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4890: getfield 829	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4893: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4896: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4899: putfield 377	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   4902: aload 20
    //   4904: aload 4
    //   4906: getfield 813	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4909: invokevirtual 817	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4912: checkcast 815	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4915: getfield 832	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4918: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4921: putfield 380	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   4924: aload 20
    //   4926: aload 4
    //   4928: getfield 813	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   4931: invokevirtual 817	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4934: checkcast 815	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   4937: getfield 835	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4940: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4943: putfield 383	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   4946: goto +39 -> 4985
    //   4949: aload 20
    //   4951: aload_3
    //   4952: putfield 392	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   4955: aload 20
    //   4957: aload_3
    //   4958: putfield 389	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   4961: aload 20
    //   4963: iconst_0
    //   4964: putfield 386	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   4967: aload 20
    //   4969: aload_3
    //   4970: putfield 377	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   4973: aload 20
    //   4975: iconst_0
    //   4976: putfield 380	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   4979: aload 20
    //   4981: iconst_0
    //   4982: putfield 383	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   4985: aload 4
    //   4987: getfield 838	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4990: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4993: iconst_1
    //   4994: if_icmpne +2291 -> 7285
    //   4997: iconst_1
    //   4998: istore_1
    //   4999: goto +3 -> 5002
    //   5002: aload 20
    //   5004: iload_1
    //   5005: putfield 841	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   5008: aload 20
    //   5010: aload 4
    //   5012: getfield 844	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5015: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5018: putfield 847	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   5021: aload 20
    //   5023: aload 4
    //   5025: getfield 850	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5028: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5031: putfield 853	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   5034: aload 20
    //   5036: aload 4
    //   5038: getfield 856	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5041: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5044: putfield 859	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   5047: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5050: ifeq +130 -> 5180
    //   5053: new 167	java/lang/StringBuilder
    //   5056: dup
    //   5057: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   5060: astore_3
    //   5061: aload_3
    //   5062: ldc_w 861
    //   5065: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5068: pop
    //   5069: aload_3
    //   5070: aload 20
    //   5072: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5075: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5078: pop
    //   5079: aload_3
    //   5080: ldc_w 863
    //   5083: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5086: pop
    //   5087: aload_3
    //   5088: aload 20
    //   5090: getfield 841	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   5093: invokevirtual 866	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5096: pop
    //   5097: aload_3
    //   5098: ldc_w 868
    //   5101: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5104: pop
    //   5105: aload_3
    //   5106: aload 20
    //   5108: invokevirtual 871	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   5111: invokevirtual 866	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5114: pop
    //   5115: aload_3
    //   5116: ldc_w 873
    //   5119: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5122: pop
    //   5123: aload_3
    //   5124: aload 20
    //   5126: getfield 847	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   5129: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5132: pop
    //   5133: aload_3
    //   5134: ldc_w 875
    //   5137: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5140: pop
    //   5141: aload_3
    //   5142: aload 20
    //   5144: getfield 859	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   5147: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5150: pop
    //   5151: aload_3
    //   5152: ldc_w 877
    //   5155: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5158: pop
    //   5159: aload_3
    //   5160: aload 20
    //   5162: getfield 853	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   5165: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5168: pop
    //   5169: ldc_w 879
    //   5172: iconst_2
    //   5173: aload_3
    //   5174: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5177: invokestatic 804	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5180: aload 4
    //   5182: getfield 895	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5185: invokevirtual 898	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:has	()Z
    //   5188: ifeq +324 -> 5512
    //   5191: aload 20
    //   5193: aload 4
    //   5195: getfield 895	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5198: getfield 901	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5201: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5204: putfield 904	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   5207: aload 20
    //   5209: aload 4
    //   5211: getfield 895	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5214: getfield 907	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_left_btn	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5217: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5220: putfield 910	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   5223: aload 20
    //   5225: aload 4
    //   5227: getfield 895	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5230: getfield 913	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5233: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5236: putfield 916	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   5239: aload 20
    //   5241: aload 4
    //   5243: getfield 895	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5246: getfield 919	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_not_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5249: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5252: putfield 922	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   5255: aload 20
    //   5257: aload 4
    //   5259: getfield 895	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5262: getfield 925	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:android_app_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5265: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5268: putfield 928	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   5271: aload 20
    //   5273: aload 4
    //   5275: getfield 895	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5278: getfield 931	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:jump_uri	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5281: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5284: putfield 934	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   5287: aload 20
    //   5289: aload 4
    //   5291: getfield 895	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   5294: getfield 937	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:app_download_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5297: invokevirtual 288	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5300: putfield 940	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   5303: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5306: ifeq +247 -> 5553
    //   5309: new 167	java/lang/StringBuilder
    //   5312: dup
    //   5313: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   5316: astore_3
    //   5317: aload_3
    //   5318: ldc_w 954
    //   5321: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5324: pop
    //   5325: aload_3
    //   5326: ldc_w 956
    //   5329: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5332: pop
    //   5333: aload_3
    //   5334: aload 20
    //   5336: getfield 904	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   5339: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5342: pop
    //   5343: aload_3
    //   5344: aload 22
    //   5346: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5349: pop
    //   5350: aload_3
    //   5351: ldc_w 960
    //   5354: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5357: pop
    //   5358: aload_3
    //   5359: aload 20
    //   5361: getfield 910	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   5364: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5367: pop
    //   5368: aload_3
    //   5369: aload 22
    //   5371: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5374: pop
    //   5375: aload_3
    //   5376: ldc_w 962
    //   5379: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5382: pop
    //   5383: aload_3
    //   5384: aload 20
    //   5386: getfield 916	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   5389: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5392: pop
    //   5393: aload_3
    //   5394: aload 22
    //   5396: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5399: pop
    //   5400: aload_3
    //   5401: ldc_w 964
    //   5404: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5407: pop
    //   5408: aload_3
    //   5409: aload 20
    //   5411: getfield 922	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   5414: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5417: pop
    //   5418: aload_3
    //   5419: aload 22
    //   5421: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5424: pop
    //   5425: aload_3
    //   5426: ldc_w 966
    //   5429: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5432: pop
    //   5433: aload_3
    //   5434: aload 20
    //   5436: getfield 928	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   5439: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5442: pop
    //   5443: aload_3
    //   5444: aload 22
    //   5446: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5449: pop
    //   5450: aload_3
    //   5451: ldc_w 968
    //   5454: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5457: pop
    //   5458: aload_3
    //   5459: aload 20
    //   5461: getfield 934	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   5464: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5467: pop
    //   5468: aload_3
    //   5469: aload 22
    //   5471: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5474: pop
    //   5475: aload_3
    //   5476: ldc_w 970
    //   5479: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5482: pop
    //   5483: aload_3
    //   5484: aload 20
    //   5486: getfield 940	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   5489: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5492: pop
    //   5493: aload_3
    //   5494: aload 22
    //   5496: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5499: pop
    //   5500: aload_2
    //   5501: iconst_2
    //   5502: aload_3
    //   5503: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5506: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5509: goto +44 -> 5553
    //   5512: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5515: ifeq +38 -> 5553
    //   5518: aload_2
    //   5519: iconst_2
    //   5520: ldc_w 976
    //   5523: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5526: goto +27 -> 5553
    //   5529: goto +6 -> 5535
    //   5532: goto +3 -> 5535
    //   5535: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5538: ifeq +15 -> 5553
    //   5541: aload 17
    //   5543: iconst_2
    //   5544: ldc_w 978
    //   5547: invokestatic 804	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5550: goto +3 -> 5553
    //   5553: aload_0
    //   5554: astore_3
    //   5555: aload 21
    //   5557: getfield 1826	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   5560: ifnull +29 -> 5589
    //   5563: aload 20
    //   5565: aload 21
    //   5567: getfield 1826	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   5570: getfield 1831	SummaryCard/GiftInfo:uOpenFlag	J
    //   5573: putfield 747	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   5576: aload 20
    //   5578: aload 21
    //   5580: getfield 1826	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   5583: getfield 1832	SummaryCard/GiftInfo:vGiftInfo	[B
    //   5586: putfield 751	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   5589: aload 21
    //   5591: getfield 1835	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   5594: ifnull +234 -> 5828
    //   5597: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5600: ifeq +12 -> 5612
    //   5603: aload 17
    //   5605: iconst_2
    //   5606: ldc_w 1837
    //   5609: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5612: new 1839	tencent/im/group/group_member_info$RspGroupCardGetStory
    //   5615: dup
    //   5616: invokespecial 1840	tencent/im/group/group_member_info$RspGroupCardGetStory:<init>	()V
    //   5619: astore_2
    //   5620: aload_2
    //   5621: aload 21
    //   5623: getfield 1835	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   5626: invokevirtual 1841	tencent/im/group/group_member_info$RspGroupCardGetStory:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5629: pop
    //   5630: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5633: ifeq +102 -> 5735
    //   5636: new 167	java/lang/StringBuilder
    //   5639: dup
    //   5640: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   5643: astore 4
    //   5645: aload 4
    //   5647: ldc_w 1843
    //   5650: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5653: pop
    //   5654: aload 4
    //   5656: aload_2
    //   5657: getfield 1844	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5660: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5663: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5666: pop
    //   5667: aload 17
    //   5669: iconst_2
    //   5670: aload 4
    //   5672: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5675: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5678: aload_2
    //   5679: getfield 1847	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5682: invokevirtual 1000	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5685: ifeq +50 -> 5735
    //   5688: new 167	java/lang/StringBuilder
    //   5691: dup
    //   5692: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   5695: astore 4
    //   5697: aload 4
    //   5699: ldc_w 1849
    //   5702: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5705: pop
    //   5706: aload 4
    //   5708: aload_2
    //   5709: getfield 1847	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5712: invokevirtual 722	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5715: invokeinterface 627 1 0
    //   5720: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5723: pop
    //   5724: aload 17
    //   5726: iconst_2
    //   5727: aload 4
    //   5729: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5732: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5735: aload_2
    //   5736: getfield 1844	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5739: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5742: iconst_1
    //   5743: if_icmpne +1547 -> 7290
    //   5746: iconst_1
    //   5747: istore_1
    //   5748: goto +3 -> 5751
    //   5751: aload 20
    //   5753: iload_1
    //   5754: putfield 1852	com/tencent/mobileqq/data/NearbyPeopleCard:mHasStory	Z
    //   5757: aload_2
    //   5758: getfield 1847	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5761: invokevirtual 1000	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5764: ifeq +64 -> 5828
    //   5767: aload 20
    //   5769: aload_2
    //   5770: getfield 1847	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5773: invokevirtual 722	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5776: invokevirtual 1855	com/tencent/mobileqq/data/NearbyPeopleCard:addQQStoryList	(Ljava/util/List;)V
    //   5779: goto +49 -> 5828
    //   5782: astore_2
    //   5783: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5786: ifeq +42 -> 5828
    //   5789: new 167	java/lang/StringBuilder
    //   5792: dup
    //   5793: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   5796: astore 4
    //   5798: aload 4
    //   5800: ldc_w 1857
    //   5803: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5806: pop
    //   5807: aload 4
    //   5809: aload_2
    //   5810: invokevirtual 1858	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   5813: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5816: pop
    //   5817: aload 17
    //   5819: iconst_2
    //   5820: aload 4
    //   5822: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5825: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5828: aload 21
    //   5830: getfield 1861	SummaryCard/RespSummaryCard:vNearbyTaskInfo	[B
    //   5833: astore_2
    //   5834: aload_2
    //   5835: ifnull +48 -> 5883
    //   5838: new 1863	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody
    //   5841: dup
    //   5842: invokespecial 1864	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:<init>	()V
    //   5845: astore 4
    //   5847: aload 4
    //   5849: aload_2
    //   5850: invokevirtual 1865	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5853: pop
    //   5854: aload 20
    //   5856: aload 4
    //   5858: getfield 1868	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_finish_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5861: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5864: putfield 1871	com/tencent/mobileqq/data/NearbyPeopleCard:taskFinished	I
    //   5867: aload 20
    //   5869: aload 4
    //   5871: getfield 1874	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_all_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5874: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5877: putfield 1877	com/tencent/mobileqq/data/NearbyPeopleCard:taskTotal	I
    //   5880: goto +3 -> 5883
    //   5883: aload 21
    //   5885: getfield 1880	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   5888: astore_2
    //   5889: aload_2
    //   5890: ifnull +396 -> 6286
    //   5893: aload 20
    //   5895: new 595	java/util/ArrayList
    //   5898: dup
    //   5899: invokespecial 596	java/util/ArrayList:<init>	()V
    //   5902: putfield 1883	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   5905: new 1885	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData
    //   5908: dup
    //   5909: invokespecial 1886	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:<init>	()V
    //   5912: astore 4
    //   5914: aload 4
    //   5916: aload_2
    //   5917: invokevirtual 1887	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5920: pop
    //   5921: aload 4
    //   5923: getfield 1890	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:rpt_msg_now_haiwan	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5926: invokevirtual 722	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5929: astore_2
    //   5930: aload_2
    //   5931: ifnull +355 -> 6286
    //   5934: new 621	org/json/JSONArray
    //   5937: dup
    //   5938: invokespecial 622	org/json/JSONArray:<init>	()V
    //   5941: astore 4
    //   5943: iconst_0
    //   5944: istore 5
    //   5946: iload 5
    //   5948: aload_2
    //   5949: invokeinterface 627 1 0
    //   5954: if_icmpge +273 -> 6227
    //   5957: new 1892	org/json/JSONObject
    //   5960: dup
    //   5961: invokespecial 1893	org/json/JSONObject:<init>	()V
    //   5964: astore 15
    //   5966: new 1895	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem
    //   5969: dup
    //   5970: invokespecial 1896	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:<init>	()V
    //   5973: astore 16
    //   5975: aload 16
    //   5977: aload_2
    //   5978: iload 5
    //   5980: invokeinterface 630 2 0
    //   5985: checkcast 1898	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   5988: getfield 1901	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5991: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5994: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5997: putfield 1903	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   6000: aload 16
    //   6002: getfield 1903	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   6005: invokestatic 1906	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6008: ifne +17 -> 6025
    //   6011: aload 15
    //   6013: ldc_w 1907
    //   6016: aload 16
    //   6018: getfield 1903	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   6021: invokevirtual 1910	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6024: pop
    //   6025: aload 16
    //   6027: aload_2
    //   6028: iload 5
    //   6030: invokeinterface 630 2 0
    //   6035: checkcast 1898	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   6038: getfield 1913	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6041: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6044: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6047: putfield 1916	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   6050: aload 16
    //   6052: getfield 1916	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   6055: invokestatic 1906	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6058: ifne +17 -> 6075
    //   6061: aload 15
    //   6063: ldc_w 1917
    //   6066: aload 16
    //   6068: getfield 1916	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   6071: invokevirtual 1910	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6074: pop
    //   6075: aload 16
    //   6077: aload_2
    //   6078: iload 5
    //   6080: invokeinterface 630 2 0
    //   6085: checkcast 1898	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   6088: getfield 1920	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6091: invokevirtual 429	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6094: invokevirtual 633	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6097: putfield 1922	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   6100: aload 16
    //   6102: getfield 1922	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   6105: invokestatic 1906	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6108: ifne +17 -> 6125
    //   6111: aload 15
    //   6113: ldc_w 1923
    //   6116: aload 16
    //   6118: getfield 1922	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   6121: invokevirtual 1910	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   6124: pop
    //   6125: aload 16
    //   6127: aload_2
    //   6128: iload 5
    //   6130: invokeinterface 630 2 0
    //   6135: checkcast 1898	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   6138: getfield 1926	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6141: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6144: putfield 1929	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   6147: aload 15
    //   6149: ldc_w 1930
    //   6152: aload 16
    //   6154: getfield 1929	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   6157: invokevirtual 1933	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   6160: pop
    //   6161: aload 16
    //   6163: aload_2
    //   6164: iload 5
    //   6166: invokeinterface 630 2 0
    //   6171: checkcast 1898	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   6174: getfield 1936	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6177: invokevirtual 411	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6180: putfield 1938	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   6183: aload 15
    //   6185: ldc_w 1939
    //   6188: aload 16
    //   6190: getfield 1938	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   6193: invokevirtual 1933	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   6196: pop
    //   6197: aload 20
    //   6199: getfield 1883	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   6202: aload 16
    //   6204: invokeinterface 637 2 0
    //   6209: pop
    //   6210: aload 4
    //   6212: aload 15
    //   6214: invokevirtual 641	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   6217: pop
    //   6218: iload 5
    //   6220: iconst_1
    //   6221: iadd
    //   6222: istore 5
    //   6224: goto -278 -> 5946
    //   6227: aload 20
    //   6229: aload 4
    //   6231: invokevirtual 642	org/json/JSONArray:toString	()Ljava/lang/String;
    //   6234: putfield 1942	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanInfo	Ljava/lang/String;
    //   6237: goto +49 -> 6286
    //   6240: astore_2
    //   6241: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6244: ifeq +42 -> 6286
    //   6247: new 167	java/lang/StringBuilder
    //   6250: dup
    //   6251: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   6254: astore 4
    //   6256: aload 4
    //   6258: ldc_w 1944
    //   6261: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6264: pop
    //   6265: aload 4
    //   6267: aload_2
    //   6268: invokevirtual 654	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6271: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6274: pop
    //   6275: aload 17
    //   6277: iconst_2
    //   6278: aload 4
    //   6280: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6283: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6286: aload 20
    //   6288: aload 21
    //   6290: getfield 1880	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   6293: putfield 984	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   6296: new 986	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   6299: dup
    //   6300: invokespecial 987	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   6303: astore 4
    //   6305: aload 4
    //   6307: aload 21
    //   6309: getfield 1880	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   6312: invokevirtual 988	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6315: pop
    //   6316: aload 4
    //   6318: astore_2
    //   6319: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6322: ifeq +138 -> 6460
    //   6325: new 167	java/lang/StringBuilder
    //   6328: dup
    //   6329: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   6332: astore_2
    //   6333: aload_2
    //   6334: ldc_w 990
    //   6337: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6340: pop
    //   6341: aload_2
    //   6342: aload 4
    //   6344: getfield 993	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6347: invokevirtual 994	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   6350: invokevirtual 866	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6353: pop
    //   6354: aload_2
    //   6355: ldc_w 996
    //   6358: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6361: pop
    //   6362: aload_2
    //   6363: aload 4
    //   6365: getfield 999	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   6368: invokevirtual 1000	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   6371: invokevirtual 866	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6374: pop
    //   6375: aload_2
    //   6376: ldc_w 1002
    //   6379: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6382: pop
    //   6383: aload_2
    //   6384: aload 4
    //   6386: getfield 1005	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   6389: invokevirtual 1000	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   6392: invokevirtual 866	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6395: pop
    //   6396: aload 17
    //   6398: iconst_2
    //   6399: aload_2
    //   6400: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6403: invokestatic 804	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6406: aload 4
    //   6408: astore_2
    //   6409: goto +51 -> 6460
    //   6412: astore_2
    //   6413: invokestatic 649	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6416: ifeq +42 -> 6458
    //   6419: new 167	java/lang/StringBuilder
    //   6422: dup
    //   6423: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   6426: astore 4
    //   6428: aload 4
    //   6430: ldc_w 1007
    //   6433: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6436: pop
    //   6437: aload 4
    //   6439: aload_2
    //   6440: invokevirtual 729	java/lang/Exception:toString	()Ljava/lang/String;
    //   6443: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6446: pop
    //   6447: aload 17
    //   6449: iconst_2
    //   6450: aload 4
    //   6452: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6455: invokestatic 1010	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   6458: aconst_null
    //   6459: astore_2
    //   6460: aload 20
    //   6462: aload_2
    //   6463: putfield 1014	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   6466: aload_3
    //   6467: bipush 51
    //   6469: iconst_1
    //   6470: aload 20
    //   6472: iload 11
    //   6474: invokevirtual 1018	com/tencent/mobileqq/nearby/business/NearbyCardHandler:notifyUI	(IZLjava/lang/Object;Z)V
    //   6477: aload_3
    //   6478: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6481: getstatic 1023	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   6484: invokevirtual 1027	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6487: checkcast 1029	com/tencent/mobileqq/nearby/NearbyCardManager
    //   6490: astore_2
    //   6491: iload 6
    //   6493: bipush 51
    //   6495: if_icmpne +18 -> 6513
    //   6498: aload_2
    //   6499: aload 20
    //   6501: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6504: invokestatic 1034	android/os/SystemClock:elapsedRealtime	()J
    //   6507: invokevirtual 1037	com/tencent/mobileqq/nearby/NearbyCardManager:b	(Ljava/lang/String;J)V
    //   6510: goto +18 -> 6528
    //   6513: aload_2
    //   6514: aload 20
    //   6516: getfield 416	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   6519: invokestatic 328	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6522: invokestatic 1034	android/os/SystemClock:elapsedRealtime	()J
    //   6525: invokevirtual 1039	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Ljava/lang/String;J)V
    //   6528: invokestatic 657	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6531: ifeq +56 -> 6587
    //   6534: new 167	java/lang/StringBuilder
    //   6537: dup
    //   6538: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   6541: astore_2
    //   6542: aload_2
    //   6543: ldc_w 1041
    //   6546: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6549: pop
    //   6550: aload_2
    //   6551: aload 20
    //   6553: getfield 416	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   6556: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6559: pop
    //   6560: aload_2
    //   6561: ldc_w 1043
    //   6564: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6567: pop
    //   6568: aload_2
    //   6569: invokestatic 1034	android/os/SystemClock:elapsedRealtime	()J
    //   6572: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6575: pop
    //   6576: ldc_w 1045
    //   6579: iconst_4
    //   6580: aload_2
    //   6581: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6584: invokestatic 664	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   6587: aload_3
    //   6588: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6591: getstatic 1048	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   6594: invokevirtual 1027	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6597: checkcast 1050	com/tencent/mobileqq/app/FriendsManager
    //   6600: astore_2
    //   6601: invokestatic 1948	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   6604: ifeq +55 -> 6659
    //   6607: aload 17
    //   6609: iconst_5
    //   6610: anewarray 1178	java/lang/Object
    //   6613: dup
    //   6614: iconst_0
    //   6615: ldc_w 1950
    //   6618: aastore
    //   6619: dup
    //   6620: iconst_1
    //   6621: iload 6
    //   6623: invokestatic 1186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6626: aastore
    //   6627: dup
    //   6628: iconst_2
    //   6629: aload 20
    //   6631: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6634: aastore
    //   6635: dup
    //   6636: iconst_3
    //   6637: aload_3
    //   6638: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6641: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6644: aastore
    //   6645: dup
    //   6646: iconst_4
    //   6647: aload 21
    //   6649: getfield 1265	SummaryCard/RespSummaryCard:lUIN	J
    //   6652: invokestatic 137	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6655: aastore
    //   6656: invokestatic 1953	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   6659: iload 6
    //   6661: ifeq +21 -> 6682
    //   6664: aload 20
    //   6666: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6669: aload_3
    //   6670: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6673: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6676: invokevirtual 1273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6679: ifeq +92 -> 6771
    //   6682: aload_2
    //   6683: aload 20
    //   6685: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6688: invokevirtual 1053	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   6691: astore 4
    //   6693: aload 4
    //   6695: aload 20
    //   6697: getfield 771	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   6700: putfield 1058	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   6703: aload 4
    //   6705: aload 20
    //   6707: getfield 765	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   6710: i2l
    //   6711: putfield 1061	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   6714: aload_3
    //   6715: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6718: invokevirtual 1064	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   6721: aload 4
    //   6723: getfield 1061	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   6726: aload 4
    //   6728: getfield 1058	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   6731: invokestatic 1069	com/tencent/mobileqq/nearby/api/NearbySPUtil:a	(Ljava/lang/String;JI)Z
    //   6734: pop
    //   6735: aload_2
    //   6736: aload 4
    //   6738: invokevirtual 1072	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   6741: pop
    //   6742: aload_3
    //   6743: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6746: invokevirtual 1064	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   6749: ldc_w 1074
    //   6752: aload 20
    //   6754: getfield 486	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   6757: invokestatic 1077	com/tencent/mobileqq/nearby/api/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   6760: pop
    //   6761: goto +10 -> 6771
    //   6764: astore 4
    //   6766: aload 4
    //   6768: invokevirtual 1080	java/lang/Exception:printStackTrace	()V
    //   6771: aload_3
    //   6772: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6775: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6778: aload 20
    //   6780: getfield 406	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   6783: invokevirtual 1273	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6786: ifeq +32 -> 6818
    //   6789: aload 20
    //   6791: getfield 1083	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   6794: ifle +24 -> 6818
    //   6797: aload_3
    //   6798: getfield 27	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6801: getstatic 1086	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   6804: invokevirtual 1027	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6807: checkcast 1088	com/tencent/mobileqq/app/HotChatManager
    //   6810: aload 20
    //   6812: getfield 1083	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   6815: invokevirtual 1090	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   6818: aload_2
    //   6819: aload 20
    //   6821: invokevirtual 1093	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   6824: aload 20
    //   6826: invokevirtual 339	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   6829: sipush 1000
    //   6832: if_icmpne +187 -> 7019
    //   6835: aload 19
    //   6837: iconst_0
    //   6838: ldc_w 323
    //   6841: invokevirtual 1098	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   6844: aconst_null
    //   6845: aconst_null
    //   6846: aconst_null
    //   6847: aconst_null
    //   6848: aconst_null
    //   6849: aconst_null
    //   6850: aconst_null
    //   6851: invokevirtual 1102	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   6854: astore_2
    //   6855: aload_2
    //   6856: ifnull +444 -> 7300
    //   6859: aload_2
    //   6860: invokeinterface 1107 1 0
    //   6865: istore 5
    //   6867: aload_2
    //   6868: invokeinterface 1110 1 0
    //   6873: pop
    //   6874: iload 5
    //   6876: sipush 200
    //   6879: if_icmple +421 -> 7300
    //   6882: iload 5
    //   6884: bipush 100
    //   6886: if_icmple +19 -> 6905
    //   6889: aload_2
    //   6890: invokeinterface 1113 1 0
    //   6895: pop
    //   6896: iload 5
    //   6898: iconst_1
    //   6899: isub
    //   6900: istore 5
    //   6902: goto -20 -> 6882
    //   6905: aload_2
    //   6906: aload_2
    //   6907: ldc_w 1115
    //   6910: invokeinterface 1118 2 0
    //   6915: invokeinterface 1121 2 0
    //   6920: istore 5
    //   6922: new 167	java/lang/StringBuilder
    //   6925: dup
    //   6926: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   6929: astore_3
    //   6930: aload_3
    //   6931: ldc_w 1123
    //   6934: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6937: pop
    //   6938: aload_3
    //   6939: ldc_w 323
    //   6942: invokevirtual 1098	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   6945: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6948: pop
    //   6949: aload_3
    //   6950: ldc_w 1125
    //   6953: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6956: pop
    //   6957: aload_3
    //   6958: ldc_w 1115
    //   6961: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6964: pop
    //   6965: aload_3
    //   6966: ldc_w 1127
    //   6969: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6972: pop
    //   6973: aload_3
    //   6974: iload 5
    //   6976: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6979: pop
    //   6980: aload_3
    //   6981: ldc_w 1129
    //   6984: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6987: pop
    //   6988: aload_3
    //   6989: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6992: astore 4
    //   6994: aload_2
    //   6995: astore_3
    //   6996: aload 19
    //   6998: aload 4
    //   7000: invokevirtual 1132	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   7003: pop
    //   7004: goto +3 -> 7007
    //   7007: aload_2
    //   7008: astore_3
    //   7009: aload 19
    //   7011: aload 20
    //   7013: invokevirtual 1136	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   7016: goto +35 -> 7051
    //   7019: aload 20
    //   7021: invokevirtual 339	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   7024: sipush 1001
    //   7027: if_icmpeq +14 -> 7041
    //   7030: aload 20
    //   7032: invokevirtual 339	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   7035: sipush 1002
    //   7038: if_icmpne +11 -> 7049
    //   7041: aload 19
    //   7043: aload 20
    //   7045: invokevirtual 1140	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   7048: pop
    //   7049: aconst_null
    //   7050: astore_2
    //   7051: aload_2
    //   7052: astore_3
    //   7053: aload 28
    //   7055: invokevirtual 1143	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   7058: aload_2
    //   7059: ifnull +9 -> 7068
    //   7062: aload_2
    //   7063: invokeinterface 1146 1 0
    //   7068: aload 28
    //   7070: invokevirtual 1149	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   7073: aload 19
    //   7075: invokevirtual 1150	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   7078: return
    //   7079: astore 4
    //   7081: aload_3
    //   7082: astore_2
    //   7083: goto +12 -> 7095
    //   7086: astore 4
    //   7088: goto +5 -> 7093
    //   7091: astore 4
    //   7093: aconst_null
    //   7094: astore_2
    //   7095: aload_2
    //   7096: ifnull +9 -> 7105
    //   7099: aload_2
    //   7100: invokeinterface 1146 1 0
    //   7105: aload 28
    //   7107: invokevirtual 1149	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   7110: aload 19
    //   7112: invokevirtual 1150	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   7115: aload 4
    //   7117: athrow
    //   7118: aload_0
    //   7119: bipush 51
    //   7121: iconst_0
    //   7122: aconst_null
    //   7123: iload 12
    //   7125: invokevirtual 1018	com/tencent/mobileqq/nearby/business/NearbyCardHandler:notifyUI	(IZLjava/lang/Object;Z)V
    //   7128: return
    //   7129: astore_2
    //   7130: goto -1595 -> 5535
    //   7133: astore_2
    //   7134: goto -1602 -> 5532
    //   7137: astore_2
    //   7138: goto -1606 -> 5532
    //   7141: astore_2
    //   7142: goto -1613 -> 5529
    //   7145: astore_2
    //   7146: goto -1263 -> 5883
    //   7149: astore 20
    //   7151: iload 6
    //   7153: istore 5
    //   7155: goto +33 -> 7188
    //   7158: iload 5
    //   7160: istore 6
    //   7162: aload_2
    //   7163: astore 4
    //   7165: aload_3
    //   7166: astore 20
    //   7168: goto -4264 -> 2904
    //   7171: astore 20
    //   7173: iload 6
    //   7175: istore 5
    //   7177: aload 18
    //   7179: astore_3
    //   7180: aload 16
    //   7182: astore_2
    //   7183: goto +5 -> 7188
    //   7186: astore 20
    //   7188: aload 4
    //   7190: astore 16
    //   7192: aload_3
    //   7193: astore 4
    //   7195: aload 15
    //   7197: astore 19
    //   7199: aload 17
    //   7201: astore 18
    //   7203: aload_2
    //   7204: astore_3
    //   7205: aload 4
    //   7207: astore_2
    //   7208: goto -3794 -> 3414
    //   7211: astore 18
    //   7213: aload 4
    //   7215: astore 16
    //   7217: aload 18
    //   7219: astore 4
    //   7221: goto -3827 -> 3394
    //   7224: astore 18
    //   7226: aload 4
    //   7228: astore 16
    //   7230: aload 18
    //   7232: astore 4
    //   7234: goto -3840 -> 3394
    //   7237: aload 15
    //   7239: astore 20
    //   7241: aload 4
    //   7243: astore 22
    //   7245: aload 16
    //   7247: astore 23
    //   7249: iload 5
    //   7251: istore 7
    //   7253: aload_2
    //   7254: astore 25
    //   7256: aload_3
    //   7257: astore 26
    //   7259: goto -4248 -> 3011
    //   7262: iconst_0
    //   7263: istore_1
    //   7264: goto -2883 -> 4381
    //   7267: iconst_0
    //   7268: istore_1
    //   7269: goto -2865 -> 4404
    //   7272: iconst_0
    //   7273: istore_1
    //   7274: goto -2802 -> 4472
    //   7277: iconst_0
    //   7278: istore_1
    //   7279: goto -2784 -> 4495
    //   7282: goto -2504 -> 4778
    //   7285: iconst_0
    //   7286: istore_1
    //   7287: goto -2285 -> 5002
    //   7290: iconst_0
    //   7291: istore_1
    //   7292: goto -1541 -> 5751
    //   7295: astore 4
    //   7297: goto -202 -> 7095
    //   7300: goto -293 -> 7007
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	7303	0	this	NearbyCardHandler
    //   0	7303	1	paramBoolean	boolean
    //   0	7303	2	paramObject	Object
    //   0	7303	3	paramBundle	Bundle
    //   0	7303	4	paramRespHead	SummaryCard.RespHead
    //   21	7229	5	i	int
    //   956	6218	6	j	int
    //   1920	5332	7	k	int
    //   1817	1851	8	m	int
    //   2284	564	9	n	int
    //   1990	1259	10	i1	int
    //   1749	4724	11	bool1	boolean
    //   12	7112	12	bool2	boolean
    //   64	3965	13	l	long
    //   3	7235	15	localObject1	Object
    //   89	7157	16	localObject2	Object
    //   95	7105	17	localObject3	Object
    //   870	101	18	localObject4	Object
    //   1030	29	18	localException1	Exception
    //   1091	2234	18	localObject5	Object
    //   3384	7	18	localException2	Exception
    //   3395	3807	18	localObject6	Object
    //   7211	7	18	localException3	Exception
    //   7224	7	18	localException4	Exception
    //   899	6299	19	localObject7	Object
    //   927	2426	20	localObject8	Object
    //   3379	1	20	localException5	Exception
    //   3412	3632	20	localRespHead	SummaryCard.RespHead
    //   7149	1	20	localException6	Exception
    //   7166	1	20	localBundle	Bundle
    //   7171	1	20	localException7	Exception
    //   7186	1	20	localException8	Exception
    //   7239	1	20	localObject9	Object
    //   1760	4888	21	localObject10	Object
    //   1745	5499	22	localObject11	Object
    //   1458	5790	23	localObject12	Object
    //   1999	1523	24	localObject13	Object
    //   2112	5143	25	localObject14	Object
    //   2281	4977	26	localObject15	Object
    //   42	1812	27	localEntityManager	EntityManager
    //   49	7057	28	localEntityTransaction	EntityTransaction
    //   1737	1297	29	localArrayList1	ArrayList
    //   1972	1338	30	localcomm	com.tencent.pb.profilecard.SummaryCardBusiEntry.comm
    //   2058	934	31	localArrayList2	ArrayList
    //   2332	438	32	localLabel	com.tencent.pb.profilecard.SummaryCardBusiEntry.Label
    //   2351	487	33	localProfileGroupLabel	com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel
    //   2488	321	34	localProfileColor	com.tencent.mobileqq.profilecard.entity.ProfileColor
    // Exception table:
    //   from	to	target	type
    //   901	955	1030	java/lang/Exception
    //   958	1008	1030	java/lang/Exception
    //   1017	1027	1030	java/lang/Exception
    //   2416	2423	3379	java/lang/Exception
    //   2445	2459	3379	java/lang/Exception
    //   2481	2490	3379	java/lang/Exception
    //   2512	2529	3379	java/lang/Exception
    //   2551	2568	3379	java/lang/Exception
    //   2590	2607	3379	java/lang/Exception
    //   2629	2636	3379	java/lang/Exception
    //   2658	2667	3379	java/lang/Exception
    //   2689	2706	3379	java/lang/Exception
    //   2728	2745	3379	java/lang/Exception
    //   2767	2784	3379	java/lang/Exception
    //   2806	2813	3379	java/lang/Exception
    //   2835	2843	3379	java/lang/Exception
    //   2894	2901	3379	java/lang/Exception
    //   2926	2934	3379	java/lang/Exception
    //   2989	2996	3379	java/lang/Exception
    //   3033	3043	3379	java/lang/Exception
    //   3089	3095	3379	java/lang/Exception
    //   3117	3126	3379	java/lang/Exception
    //   3148	3157	3379	java/lang/Exception
    //   3179	3193	3379	java/lang/Exception
    //   3215	3224	3379	java/lang/Exception
    //   3246	3254	3379	java/lang/Exception
    //   3276	3285	3379	java/lang/Exception
    //   3307	3318	3379	java/lang/Exception
    //   3340	3352	3379	java/lang/Exception
    //   1974	2001	3384	java/lang/Exception
    //   2006	2060	3384	java/lang/Exception
    //   3794	3818	3927	java/lang/Exception
    //   3818	3836	3927	java/lang/Exception
    //   3839	3924	3927	java/lang/Exception
    //   3680	3696	3931	java/lang/Exception
    //   3701	3789	3931	java/lang/Exception
    //   4005	4040	4043	java/lang/Exception
    //   4077	4087	4090	java/lang/Exception
    //   4615	4638	4723	java/lang/Exception
    //   4641	4720	4723	java/lang/Exception
    //   4533	4615	4727	java/lang/Exception
    //   5597	5612	5782	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5612	5735	5782	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5735	5746	5782	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5751	5779	5782	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5914	5930	6240	java/lang/Exception
    //   5934	5943	6240	java/lang/Exception
    //   5946	6025	6240	java/lang/Exception
    //   6025	6075	6240	java/lang/Exception
    //   6075	6125	6240	java/lang/Exception
    //   6125	6218	6240	java/lang/Exception
    //   6227	6237	6240	java/lang/Exception
    //   6296	6316	6412	java/lang/Exception
    //   6319	6406	6412	java/lang/Exception
    //   6742	6761	6764	java/lang/Exception
    //   6996	7004	7079	finally
    //   7009	7016	7079	finally
    //   7053	7058	7079	finally
    //   7019	7041	7086	finally
    //   7041	7049	7086	finally
    //   6824	6855	7091	finally
    //   4342	4353	7129	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4364	4376	7133	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4381	4399	7133	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4404	4442	7133	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4445	4467	7133	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4472	4490	7133	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4495	4533	7133	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4533	4615	7133	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4615	4638	7137	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4641	4720	7137	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4728	4768	7137	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4768	4775	7141	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4781	4946	7141	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4949	4985	7141	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4985	4997	7141	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5002	5180	7141	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5180	5509	7141	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5512	5526	7141	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5847	5880	7145	java/lang/Exception
    //   2357	2383	7149	java/lang/Exception
    //   2213	2223	7171	java/lang/Exception
    //   2233	2243	7171	java/lang/Exception
    //   2253	2264	7171	java/lang/Exception
    //   2274	2283	7171	java/lang/Exception
    //   2296	2309	7171	java/lang/Exception
    //   2319	2334	7171	java/lang/Exception
    //   2344	2353	7171	java/lang/Exception
    //   2114	2199	7186	java/lang/Exception
    //   2105	2114	7211	java/lang/Exception
    //   2071	2105	7224	java/lang/Exception
    //   6859	6874	7295	finally
    //   6889	6896	7295	finally
    //   6905	6994	7295	finally
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
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
          paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("dating_pref");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
    notifyUI(1, false, new Object[] { localObject2, localObject2, null, null, "", localObject2, localObject2, HardCodeUtil.a(2131707151) });
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
      label431:
      boolean bool2;
      if (i == 0)
      {
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localEntityManager = paramFromServiceMsg.getEntityManagerFactory(paramFromServiceMsg.getAccount()).createEntityManager();
        Object localObject2 = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
        paramFromServiceMsg = (FromServiceMsg)localObject2;
        if (localObject2 == null)
        {
          localObject2 = new NearbyPeopleCard();
          ((NearbyPeopleCard)localObject2).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(1));
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
              break label431;
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
          localNearbyCardManager = (NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
          if (localNearbyCardManager != null) {
            localNearbyCardManager.b(paramFromServiceMsg.gender);
          }
        }
        if (paramToServiceMsg.extraData.containsKey("birthday"))
        {
          paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
          paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
          paramFromServiceMsg.constellation = ((byte)paramToServiceMsg.extraData.getInt("key_constellation"));
          localNearbyCardManager = (NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
          if (localNearbyCardManager != null) {
            localNearbyCardManager.a(paramFromServiceMsg.age);
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
            NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "self_school_name", paramFromServiceMsg.college);
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
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "actEditNearbyProfile", bool2, l2 - l3, 0L, paramFromServiceMsg, "");
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
            NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(j));
          }
          if (paramFromServiceMsg.uint32_config_time.has())
          {
            j = paramFromServiceMsg.uint32_config_time.get();
            NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(j));
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
          NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramToServiceMsg.getUin(), paramObject, localObject, localCharmEvent, paramFromServiceMsg);
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
            AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
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
            AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
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
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "actGetNearbySummaryCard", bool1, l3 - l2, 0L, paramToServiceMsg, "");
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
            NearbyCardManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", bool, 0L, 0L, paramFromServiceMsg, "", false);
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
      localObject1 = StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
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
        localObject1 = paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
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
        VoteUtil.a(paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2, j);
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
    int i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_seq.set(i);
    i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_time.set(i);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1670);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x686.ReqBody)localObject1).toByteArray()));
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.f());
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
    Object localObject3 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
    ((oidb_0x8e7.ExtParam)localObject3).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f().getBytes()));
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
        if (localPicInfo.jdField_a_of_type_Int >= 0)
        {
          localObject1 = new UpdatePhotoList.RichHead();
          ((UpdatePhotoList.RichHead)localObject1).uint32_headid.set(localPicInfo.jdField_a_of_type_Int);
          paramArrayOfObject = (Object[])localObject1;
          if (!TextUtils.isEmpty(localPicInfo.f))
          {
            ((UpdatePhotoList.RichHead)localObject1).str_video_id.set(localPicInfo.f);
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
      i = j;
      if (paramBundle.containsKey("hometown"))
      {
        j += 2;
        localObject2 = new byte[12];
        localObject1 = paramBundle.getStringArray("hometown");
        i = 0;
        while (i < 3)
        {
          PkgTools.copyData((byte[])localObject2, i * 4, PkgTools.intToBytes2(ConditionSearchManager.a(localObject1[i])), 4);
          i += 1;
        }
        localReqBody.bytes_hometown.set(ByteStringMicro.copyFrom((byte[])localObject2));
        i = ConditionSearchManager.a(localObject1[3]);
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
          PkgTools.copyData((byte[])localObject2, i * 4, PkgTools.intToBytes2(ConditionSearchManager.a(localObject1[i])), 4);
          i += 1;
        }
        localReqBody.bytes_location.set(ByteStringMicro.copyFrom((byte[])localObject2));
        i = ConditionSearchManager.a(localObject1[3]);
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
      Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
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
      new CsTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(13569).b(1).a(new NearbyCardHandler.4(this)).a(new NearbyCardHandler.3(this)).a(((nearby_ice_break.IceReq)localObject).toByteArray());
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
    long l1 = a(paramString1);
    long l2 = a(paramString2);
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
      Object localObject2 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      ((oidb_0x8e6.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f().getBytes()));
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
        localVoteInfo.uint64_uin.set(localLikeItem.jdField_a_of_type_Long);
        localVoteInfo.uint32_free_vote_count.set(localLikeItem.jdField_a_of_type_Int);
        localVoteInfo.uint32_pay_vote_count.set(localLikeItem.jdField_b_of_type_Int);
        localVoteInfo.uint32_source.set(localLikeItem.d);
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
        localLimitInfo.jdField_a_of_type_JavaLangString = localRspBody.bytes_recharge_url.get().toStringUtf8();
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.jdField_b_of_type_JavaLangString = localRspBody.bytes_update_url.get().toStringUtf8();
        paramFromServiceMsg = paramToServiceMsg;
        if (!localRspBody.msg_zan_limit.has()) {
          break label658;
        }
        paramFromServiceMsg = paramToServiceMsg;
        Object localObject = (oidb_0x8e7.ZanLimitInfo)localRspBody.msg_zan_limit.get();
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.jdField_a_of_type_Int = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_level.get());
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.c = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_can_free_zan_user_limit.get());
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.d = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_total_limit.get());
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.jdField_b_of_type_Int = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_price.get());
        paramFromServiceMsg = paramToServiceMsg;
        localLimitInfo.f = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_user.get());
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
          localLikeItem.jdField_a_of_type_Long = l;
          paramToServiceMsg = paramFromServiceMsg;
          localLikeItem.jdField_a_of_type_Int = ((int)paramObject.uint64_free_zan.get());
          paramToServiceMsg = paramFromServiceMsg;
          localLikeItem.jdField_b_of_type_Int = ((int)paramObject.uint64_pay_zan.get());
          paramToServiceMsg = paramFromServiceMsg;
          localLikeItem.c = ((int)paramObject.uint64_pay_stock.get());
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
          localLimitInfo.jdField_a_of_type_JavaLangObject = localRspBody.msg_warn.get();
        }
        paramToServiceMsg = paramObject;
        if (localRspBody.msg_stock_rsp.has())
        {
          paramToServiceMsg = paramObject;
          localLimitInfo.e = ((oidb_0x8e7.StockRsp)localRspBody.msg_stock_rsp.get()).int32_total.get();
        }
        paramToServiceMsg = paramObject;
        ((INearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(localLimitInfo, localArrayList, j);
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
      paramObject = (INearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
      paramToServiceMsg = paramToServiceMsg.rpt_vote_result.get();
      int i1 = paramToServiceMsg.size();
      int k = 0;
      while (k < i1)
      {
        Object localObject = (oidb_0x8e6.VoteResult)paramToServiceMsg.get(k);
        INearbyLikeLimitManager.LikeResultItem localLikeResultItem = new INearbyLikeLimitManager.LikeResultItem();
        localLikeResultItem.jdField_a_of_type_Int = ((oidb_0x8e6.VoteResult)localObject).uint32_ret.get();
        localLikeResultItem.jdField_a_of_type_JavaLangString = ((oidb_0x8e6.VoteResult)localObject).bytes_err_msg.get().toStringUtf8();
        localLikeResultItem.jdField_a_of_type_Long = ((oidb_0x8e6.VoteResult)localObject).uint64_uin.get();
        localLikeResultItem.jdField_b_of_type_Int = ((oidb_0x8e6.VoteResult)localObject).uint32_succ_free_vote_count.get();
        localLikeResultItem.c = ((oidb_0x8e6.VoteResult)localObject).uint32_succ_pay_vote_count.get();
        localLikeResultItem.d = ((oidb_0x8e6.VoteResult)localObject).uint32_vote_count.get();
        localLikeResultItem.e = ((int)((oidb_0x8e6.VoteResult)localObject).uint64_pay_stock.get());
        paramFromServiceMsg.add(localLikeResultItem);
        int i2 = localLikeResultItem.jdField_b_of_type_Int + localLikeResultItem.c;
        if (localLikeResultItem.jdField_a_of_type_Int == 0) {
          if ((localLikeResultItem.jdField_a_of_type_Long > 0L) && (i2 > 0))
          {
            VoteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localLikeResultItem.jdField_a_of_type_Long, i2);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
            NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject).find(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(localLikeResultItem.jdField_a_of_type_Long) });
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
        ((StringBuilder)localObject).append(localLikeResultItem.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqSummaryCard");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c8_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c5_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c9_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c9_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c7_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x682");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x686");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_4");
      this.jdField_a_of_type_JavaUtilSet.add("SQQzoneSvc.getCover");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8b4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_6");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_7");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqFavorite");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8e6_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8e7_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xb5b");
    }
    return this.jdField_a_of_type_JavaUtilSet;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.business.NearbyCardHandler
 * JD-Core Version:    0.7.0.1
 */