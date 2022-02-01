package com.tencent.mobileqq.profilecard.processor;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Rsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import QQService.EVIPSPEC;
import QQService.PrivilegeBaseInfo;
import QQService.PrivilegeInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SummaryCard.AlbumInfo;
import SummaryCard.DateCard;
import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import SummaryCard.TMedalWallInfo;
import SummaryCardTaf.SSummaryCardQueryReq;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.STRecommendInfo;
import SummaryCardTaf.SUserLabel;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.friendlist.FriendListHandlerUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.nearby.INearByGeneralManager;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBox;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppInfo;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileFootPrintConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileFootPrintProcessor;
import com.tencent.mobileqq.vas.qqvaluecard.QQValueInfoManage;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.CommonReq;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountReq;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountRsp;
import com.tencent.pb.profilecard.VaProfileGate.CommTaskInfo;
import com.tencent.pb.profilecard.VaProfileGate.GetGiftListReq;
import com.tencent.pb.profilecard.VaProfileGate.GetGiftListRsp;
import com.tencent.pb.profilecard.VaProfileGate.GetVipCareReq;
import com.tencent.pb.profilecard.VaProfileGate.GetVipCareRsp;
import com.tencent.pb.profilecard.VaProfileGate.OidbFlagInfo;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoReq;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoRsp;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeInfo;
import com.tencent.pb.profilecard.VaProfileGate.QQValueInfoItem;
import com.tencent.pb.profilecard.VaProfileGate.QidInfoItem;
import com.tencent.pb.profilecard.VaProfileGate.VaProfileGateReq;
import com.tencent.pb.profilecard.VaProfileGate.VaProfileGateRsp;
import com.tencent.pb.profilecard.VipMusicBox.GetProfileMusicBoxInfoReq;
import com.tencent.qphone.base.util.QLog;
import gxh_message.Dialogue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

@KeepClassConstructor
public class TempProfileBusinessProcessor
  extends AbsProfileBusinessProcessor
{
  private static final String TAG = "TempProfileBusinessProcessor";
  
  public TempProfileBusinessProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private VaProfileGate.VaProfileGateReq buildVaProfileGateReq(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new VaProfileGate.OidbFlagInfo();
    ((VaProfileGate.OidbFlagInfo)localObject1).uint32_fieled.set(42334);
    localArrayList.add(localObject1);
    localObject1 = new VaProfileGate.OidbFlagInfo();
    ((VaProfileGate.OidbFlagInfo)localObject1).uint32_fieled.set(42340);
    localArrayList.add(localObject1);
    localObject1 = new VaProfileGate.OidbFlagInfo();
    ((VaProfileGate.OidbFlagInfo)localObject1).uint32_fieled.set(42344);
    localArrayList.add(localObject1);
    localObject1 = new VaProfileGate.OidbFlagInfo();
    ((VaProfileGate.OidbFlagInfo)localObject1).uint32_fieled.set(42354);
    localArrayList.add(localObject1);
    localObject1 = new VaProfileGate.OidbFlagInfo();
    ((VaProfileGate.OidbFlagInfo)localObject1).uint32_fieled.set(27375);
    localArrayList.add(localObject1);
    localObject1 = new VaProfileGate.GetVipCareReq();
    ((VaProfileGate.GetVipCareReq)localObject1).uint64_uin.set(paramLong);
    Object localObject2 = new VipMusicBox.GetProfileMusicBoxInfoReq();
    ((VipMusicBox.GetProfileMusicBoxInfoReq)localObject2).uin.set(paramLong);
    VaProfileGate.CommTaskInfo localCommTaskInfo = new VaProfileGate.CommTaskInfo();
    localCommTaskInfo.uint32_appid.set(4);
    localCommTaskInfo.bytes_task_data.set(ByteStringMicro.copyFrom(((VipMusicBox.GetProfileMusicBoxInfoReq)localObject2).toByteArray()));
    localObject2 = new VaProfileGate.PrivilegeBaseInfoReq();
    ((VaProfileGate.PrivilegeBaseInfoReq)localObject2).uReqUin.set(paramLong);
    VaProfileGate.GetGiftListReq localGetGiftListReq = new VaProfileGate.GetGiftListReq();
    localGetGiftListReq.uin.set((int)paramLong);
    VaProfileGate.VaProfileGateReq localVaProfileGateReq = new VaProfileGate.VaProfileGateReq();
    localVaProfileGateReq.uCmd.set(3);
    localVaProfileGateReq.rpt_oidb_flag.set(localArrayList);
    localVaProfileGateReq.st_vip_care.set((MessageMicro)localObject1);
    localVaProfileGateReq.rpt_task_item.add(localCommTaskInfo);
    localVaProfileGateReq.stPrivilegeReq.set((MessageMicro)localObject2);
    localVaProfileGateReq.stGiftReq.set(localGetGiftListReq);
    return localVaProfileGateReq;
  }
  
  private void handleGetSummaryCardForBaseInfoPrivacy(QQAppInterface paramQQAppInterface, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint32_profile_sex_visible.has()) {
      ProfileSettingUtils.a.a(41611, paramUdcUinData.uint32_profile_sex_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_age_visible.has()) {
      ProfileSettingUtils.a.a(41610, paramUdcUinData.uint32_profile_age_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_birthday_visible.has()) {
      ProfileSettingUtils.a.a(41607, paramUdcUinData.uint32_profile_birthday_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_constellation_visible.has()) {
      ProfileSettingUtils.a.a(41609, paramUdcUinData.uint32_profile_constellation_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_profession_visible.has()) {
      ProfileSettingUtils.a.a(41618, paramUdcUinData.uint32_profile_profession_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_college_visible.has()) {
      ProfileSettingUtils.a.a(41619, paramUdcUinData.uint32_profile_college_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_location_visible.has()) {
      ProfileSettingUtils.a.a(41614, paramUdcUinData.uint32_profile_location_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_hometown_visible.has()) {
      ProfileSettingUtils.a.a(41613, paramUdcUinData.uint32_profile_hometown_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_email_visible.has()) {
      ProfileSettingUtils.a.a(41622, paramUdcUinData.uint32_profile_email_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_personal_note_visible.has()) {
      ProfileSettingUtils.a.a(41623, paramUdcUinData.uint32_profile_personal_note_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_company_visible.has()) {
      ProfileSettingUtils.a.a(40272, paramUdcUinData.uint32_profile_company_visible.get(), paramCard, paramQQAppInterface);
    }
  }
  
  private void handleGetSummaryCardForBusinessSwitch(QQAppInterface paramQQAppInterface, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint32_profile_anonymous_answer_switch.has()) {
      ProfileSettingUtils.a.a(42425, paramUdcUinData.uint32_profile_anonymous_answer_switch.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_show_idol_switch.has()) {
      ProfileSettingUtils.a.a(42488, paramUdcUinData.uint32_profile_show_idol_switch.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_wz_game_card_switch.has()) {
      ProfileSettingUtils.a.a(42505, paramUdcUinData.uint32_profile_wz_game_card_switch.get(), paramCard, paramQQAppInterface);
    }
  }
  
  private void handleGetSummaryCardForMedalWall(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    if (paramRespSummaryCard.stMedalWallInfo != null)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        paramRespSummaryCard.stMedalWallInfo.display((StringBuilder)localObject, 0);
        QLog.d("MedalWallMng", 2, new Object[] { "from summary card medal wall info: ", ((StringBuilder)localObject).toString() });
      }
      paramCard.iMedalCount = paramRespSummaryCard.stMedalWallInfo.iMedalCount;
      boolean bool;
      if (paramRespSummaryCard.stMedalWallInfo.iOpenFlag == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramCard.medalSwitchDisable = bool;
      int n = paramRespSummaryCard.stMedalWallInfo.iNewCount;
      int i1 = paramRespSummaryCard.stMedalWallInfo.iUpgradeCount;
      paramRespSummaryCard = paramRespSummaryCard.stMedalWallInfo.strPromptParams;
      int m;
      int i;
      if (n <= 0)
      {
        m = n;
        i = i1;
        if (i1 <= 0) {}
      }
      else
      {
        m = n;
        i = i1;
        if (!TextUtils.isEmpty(paramRespSummaryCard))
        {
          m = n;
          i = i1;
          if (Utils.a(paramCard.uin, this.appRuntime.getAccount()))
          {
            localObject = ((MedalWallMng)this.appRuntime.getManager(QQManagerFactory.MEDAL_WALL_MNG)).b(paramRespSummaryCard);
            if ((localObject != null) && (((ArrayList)localObject).size() > 0))
            {
              localObject = ((ArrayList)localObject).iterator();
              int k = 0;
              i = 0;
              for (;;)
              {
                m = k;
                j = i;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                MedalID localMedalID = (MedalID)((Iterator)localObject).next();
                if (localMedalID != null) {
                  if ((localMedalID.b != 1) && (localMedalID.b != 255))
                  {
                    if ((localMedalID.b == 2) || (localMedalID.b == 3)) {
                      i += 1;
                    }
                  }
                  else {
                    k += 1;
                  }
                }
              }
            }
            m = 0;
            int j = 0;
            if (QLog.isColorLevel()) {
              QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "summary card server[%d, %d] compute[%d, %d]", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(j) }));
            }
            i = j;
          }
        }
      }
      paramCard.iNewCount = m;
      paramCard.iUpgradeCount = i;
      paramCard.strPromptParams = paramRespSummaryCard;
    }
  }
  
  private void handleGetSummaryCardForMoreInfo(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    if (paramRespSummaryCard.stDateCard != null)
    {
      paramCard.constellation = paramRespSummaryCard.stDateCard.bConstellation;
      paramCard.strCompany = paramRespSummaryCard.stDateCard.strCompany;
      paramCard.iProfession = ((int)paramRespSummaryCard.stDateCard.uProfession);
      paramCard.strSchool = paramRespSummaryCard.stDateCard.strSchool;
      String str1 = ConditionSearchManager.a(paramRespSummaryCard.stDateCard.uHomeCountry);
      String str2 = ConditionSearchManager.a(paramRespSummaryCard.stDateCard.uHomeProvince);
      String str3 = ConditionSearchManager.a(paramRespSummaryCard.stDateCard.uHomeCity);
      paramRespSummaryCard = ConditionSearchManager.a(paramRespSummaryCard.stDateCard.uHomeZone);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append("-");
      localStringBuilder.append(str2);
      localStringBuilder.append("-");
      localStringBuilder.append(str3);
      localStringBuilder.append("-");
      localStringBuilder.append(paramRespSummaryCard);
      paramCard.strHometownCodes = localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramCard.strHometownCodes)) {
        ((ConditionSearchManager)this.appRuntime.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).a(paramCard);
      }
    }
  }
  
  private void handleGetSummaryCardForNearby(RespSummaryCard paramRespSummaryCard, String paramString)
  {
    if (paramString.equals(this.appRuntime.getAccount()))
    {
      paramString = (INearbyCardManager)this.appRuntime.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if (paramString != null)
      {
        paramString.c(paramRespSummaryCard.bSex);
        paramString.b(paramRespSummaryCard.bAge);
      }
    }
  }
  
  private void handleGetSummaryCardForPersonalityLabel(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    if (paramRespSummaryCard.vRespCustomLabelInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TempProfileBusinessProcessor", 2, "handleGetSummaryCard PersonalityLabel");
      }
      paramCard.putBusinessInfo(ProfilePersonalityLabelInfo.convertFromPbBytes(paramRespSummaryCard.vRespCustomLabelInfo));
    }
  }
  
  private void handleGetSummaryCardForPrivilege(RespSummaryCard paramRespSummaryCard, SparseArray<BusinessRespBuffer> paramSparseArray, Card paramCard)
  {
    if ((!handleVaProfileGate(paramCard, paramSparseArray)) && (paramRespSummaryCard.stPrivInfo != null))
    {
      paramRespSummaryCard = paramRespSummaryCard.stPrivInfo;
      paramCard.privilegePromptStr = paramRespSummaryCard.strMsg;
      paramCard.privilegeJumpUrl = paramRespSummaryCard.strJumpUrl;
      paramCard.savePrivilegeOpenedInfo(paramRespSummaryCard.vOpenPriv);
      paramCard.savePrivilegeClosedInfo(paramRespSummaryCard.vClosePriv);
    }
  }
  
  private void handleGetSummaryCardForQZone(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    paramCard.strQzoneFeedsDesc = paramRespSummaryCard.strQzoneFeedsDesc;
    paramCard.strSpaceName = paramRespSummaryCard.strSpaceName;
    paramCard.strQzoneHeader = paramRespSummaryCard.strQzoneHeader;
    String str2;
    if (paramRespSummaryCard.mapQzoneEx != null)
    {
      String str1 = (String)paramRespSummaryCard.mapQzoneEx.get("enlarge_qzone");
      if (!TextUtils.isEmpty(str1)) {
        try
        {
          paramCard.enlargeQzonePic = Integer.parseInt(str1);
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          QLog.w("TempProfileBusinessProcessor", 1, "strEnlargQzone is not a integer:", localNumberFormatException1);
        }
      } else {
        paramCard.enlargeQzonePic = 0;
      }
      str2 = (String)paramRespSummaryCard.mapQzoneEx.get("show_publish_button");
      if (TextUtils.isEmpty(str2)) {}
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(str2) != 1) {
          break label245;
        }
        bool = true;
        paramCard.showPublishButton = bool;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        QLog.w("TempProfileBusinessProcessor", 1, "show_publish_button is not a integer:", localNumberFormatException2);
        paramCard.showPublishButton = false;
      }
      paramCard.showPublishButton = false;
      paramCard.vQzoneCoverInfo = paramRespSummaryCard.vQzoneCoverInfo;
      if (!paramCard.isPhotoUseCache())
      {
        paramCard.qzonePhotoList.clear();
        paramRespSummaryCard = paramRespSummaryCard.oLatestPhotos;
        if ((paramRespSummaryCard != null) && (paramRespSummaryCard.vPhotos != null)) {
          try
          {
            paramCard.addQZonePhotoList(paramRespSummaryCard);
            return;
          }
          catch (OutOfMemoryError paramRespSummaryCard)
          {
            paramCard = new StringBuilder();
            paramCard.append("card.addQZonePhotoList(albumInfo)  OOM !");
            paramCard.append(paramRespSummaryCard.getMessage());
            QLog.e("TempProfileBusinessProcessor", 1, paramCard.toString());
          }
        }
      }
      return;
      label245:
      boolean bool = false;
    }
  }
  
  private void handleGetSummaryCardForTemplate(RespSummaryCard paramRespSummaryCard, String paramString, Card paramCard, long paramLong)
  {
    if ((paramLong & 0x20) != 0L)
    {
      HashMap localHashMap = new HashMap();
      if (paramRespSummaryCard.vRespTemplateInfo != null)
      {
        paramRespSummaryCard = (SSummaryCardRsp)Packet.decodePacket(paramRespSummaryCard.vRespTemplateInfo, "rsp", new SSummaryCardRsp());
        updateCardTemplate(paramCard, paramString, paramRespSummaryCard);
        if ((paramRespSummaryCard != null) && (!TextUtils.isEmpty(paramRespSummaryCard.urlprefix)))
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("handleGetSummaryCard: defaultCardUrlPrefix=");
            paramString.append(paramRespSummaryCard.urlprefix);
            paramString.append(" defId=");
            paramString.append(paramRespSummaryCard.profileid);
            QLog.d("TempProfileBusinessProcessor", 2, paramString.toString());
          }
          ProfileCardManager.c = paramRespSummaryCard.urlprefix;
        }
        if ((paramRespSummaryCard != null) && (paramRespSummaryCard.stRecom != null))
        {
          paramLong = paramRespSummaryCard.stRecom.iRecomCard;
          paramString = new StringBuilder();
          paramString.append(ProfileCardManager.c);
          paramString.append(paramRespSummaryCard.stRecom.strRecomUrl);
          paramString = paramString.toString();
          paramRespSummaryCard = paramRespSummaryCard.stRecom.strDesc;
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramRespSummaryCard))) {
            BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0).edit().putLong("recommend_id", paramLong).putString("recommend_url", paramString).putString("recommend_desc", paramRespSummaryCard).commit();
          }
        }
      }
      else
      {
        localHashMap.put("param_FailCode", "-100");
        StatisticCollector.getInstance(this.appRuntime.getApplication()).collectPerformance(paramString, "profileCardGet", false, 0L, 0L, null, "", false);
      }
    }
  }
  
  private void handleGetSummaryCardForUdcInner(String paramString, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    Friends localFriends = ((FriendsManager)this.appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    int i;
    StringBuilder localStringBuilder;
    if ((paramString.equals(this.appRuntime.getAccount())) && (paramUdcUinData.int32_history_num_flag.has()))
    {
      i = paramUdcUinData.int32_history_num_flag.get();
      SharedPreUtils.F(this.appRuntime.getApplication(), this.appRuntime.getAccount(), i);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("history_num_flag= ");
        localStringBuilder.append(i);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
    }
    long l;
    if (paramUdcUinData.uint64_game_appid.has())
    {
      l = paramUdcUinData.uint64_game_appid.get();
      paramCard.namePlateOfKingGameId = l;
      localFriends.namePlateOfKingGameId = l;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("namePlateOfKingGameId= ");
        localStringBuilder.append(l);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
    }
    if (paramUdcUinData.uint64_game_last_login_time.has())
    {
      l = paramUdcUinData.uint64_game_last_login_time.get();
      paramCard.namePlateOfKingLoginTime = l;
      localFriends.namePlateOfKingLoginTime = l;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("namePlateOfKingLoginTime= ");
        localStringBuilder.append(l);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
    }
    if (paramUdcUinData.uint32_plate_of_king_dan.has())
    {
      i = paramUdcUinData.uint32_plate_of_king_dan.get();
      paramCard.namePlateOfKingDan = i;
      localFriends.namePlateOfKingDan = i;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("namePlateOfKingDan= ");
        localStringBuilder.append(i);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
    }
    if (paramUdcUinData.uint32_plate_of_king_dan_display_switch.has())
    {
      i = paramUdcUinData.uint32_plate_of_king_dan_display_switch.get();
      boolean bool2 = true;
      boolean bool1;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramCard.namePlateOfKingDanDisplatSwitch = bool1;
      if (i == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localFriends.namePlateOfKingDanDisplatSwitch = bool1;
      if ((!TextUtils.isEmpty(paramString)) && (this.appRuntime.getAccount().equals(paramString)))
      {
        paramCard = this.appRuntime.getApplication().getSharedPreferences("sp_plate_of_king", 0).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("plate_of_king_display_switch_");
        localStringBuilder.append(this.appRuntime.getAccount());
        paramCard.putBoolean(localStringBuilder.toString(), localFriends.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (QLog.isColorLevel())
      {
        paramCard = new StringBuilder();
        paramCard.append("namePlateOfKingDanDisplatSwitch= ");
        paramCard.append(i);
        QLog.i("Q.profilecard.SummaryCard", 2, paramCard.toString());
      }
    }
    if (paramUdcUinData.uint32_suspend_effect_id.has())
    {
      i = paramUdcUinData.uint32_suspend_effect_id.get();
      if (i >= 0) {
        ((ISVIPHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString, i);
      }
      if (QLog.isColorLevel())
      {
        paramCard = new StringBuilder();
        paramCard.append("uin ");
        paramCard.append(paramString);
        paramCard.append(" colorScreenid= ");
        paramCard.append(i);
        QLog.i("Q.profilecard.SummaryCard", 2, paramCard.toString());
      }
    }
    if (paramUdcUinData.uint32_vas_face_id.has())
    {
      i = paramUdcUinData.uint32_vas_face_id.get();
      ((VasExtensionManager)this.appRuntime.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).c.b(paramString, i);
    }
  }
  
  private void handleGetSummaryCardForUdcInner2(String paramString, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    int i;
    if (paramUdcUinData.uint32_extend_friend_flag.has())
    {
      i = paramUdcUinData.uint32_extend_friend_flag.get();
      paramCard.extendFriendFlag = i;
      SharedPreUtils.a(this.appRuntime.getAccount(), "extend_friend_config_785").edit().putInt("sp_extend_friend_flag", i).apply();
    }
    boolean bool;
    if (paramUdcUinData.uint32_extend_friend_card_shown.has())
    {
      if (paramUdcUinData.uint32_extend_friend_card_shown.get() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramCard.isShowCard = bool;
    }
    if (paramUdcUinData.uint32_stranger_vote_switch.has())
    {
      if (paramUdcUinData.uint32_stranger_vote_switch.get() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramCard.strangerVoteOpen = bool;
      if (paramString.equals(this.appRuntime.getAccount())) {
        ((INearByGeneralManager)this.appRuntime.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b(paramCard.strangerVoteOpen);
      }
    }
    StringBuilder localStringBuilder;
    if (paramUdcUinData.uint32_school_status_flag.has())
    {
      i = paramUdcUinData.uint32_school_status_flag.get();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" uint32_school_status_flag=");
        localStringBuilder.append(i);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
      paramCard.newSchoolStatusFlagForGuide = i;
    }
    if (paramUdcUinData.uint32_flag_is_pretty_group_owner.has())
    {
      if (paramUdcUinData.uint32_flag_is_pretty_group_owner.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramCard.isPrettyGroupOwner = bool;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" is pretty troop owner:");
      localStringBuilder.append(paramCard.isPrettyGroupOwner);
      QLog.e("vip_pretty.", 1, localStringBuilder.toString());
    }
    if (paramUdcUinData.uint32_flag_hide_pretty_group_owner_identity.has())
    {
      if (paramUdcUinData.uint32_flag_hide_pretty_group_owner_identity.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramCard.isHidePrettyGroutIdentity = bool;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" is pretty hide troop owner identity:");
      localStringBuilder.append(paramCard.isHidePrettyGroutIdentity);
      QLog.e("vip_pretty.", 1, localStringBuilder.toString());
    }
    if (paramUdcUinData.uint32_profile_sticky_note_switch.has())
    {
      i = paramUdcUinData.uint32_profile_sticky_note_switch.get();
      paramCard.switchStickyNote = ((short)i);
      if (QLog.isColorLevel()) {
        QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetSummaryCard uin=%s sticky_note_switch=%s", new Object[] { paramString, Integer.valueOf(i) }));
      }
    }
    if (paramUdcUinData.uint32_flag_school_verified.has())
    {
      if (paramUdcUinData.uint32_flag_school_verified.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramCard.schoolVerifiedFlag = bool;
      if (QLog.isColorLevel()) {
        QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetSummaryCard uin=%s schoolVerifiedFlag=%s", new Object[] { paramString, Boolean.valueOf(paramCard.schoolVerifiedFlag) }));
      }
    }
    if (paramUdcUinData.uint32_profile_qqcircle_switch.has())
    {
      i = paramUdcUinData.uint32_profile_qqcircle_switch.get();
      paramCard.switchQQCircle = ((short)i);
      if (QLog.isColorLevel()) {
        QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetSummaryCard uin=%s qqcircle_switch=%s", new Object[] { paramString, Integer.valueOf(i) }));
      }
    }
    if (paramUdcUinData.uint32_profile_life_achievement_switch.has())
    {
      i = paramUdcUinData.uint32_profile_life_achievement_switch.get();
      paramCard.switchLifeAchievement = ((short)i);
      if (QLog.isColorLevel()) {
        QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetSummaryCard uin=%s switch_life_achievement=%s", new Object[] { paramString, Integer.valueOf(i) }));
      }
    }
    if (paramUdcUinData.uint32_profile_weishi_switch.has())
    {
      i = paramUdcUinData.uint32_profile_weishi_switch.get();
      paramCard.switchWeiShi = ((short)i);
      if (QLog.isColorLevel()) {
        QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetSummaryCard uin=%s switchWeishi=%s", new Object[] { paramString, Integer.valueOf(i) }));
      }
    }
  }
  
  private void handleGetSummaryCardForVote(RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, SparseArray<BusinessRespBuffer> paramSparseArray, String paramString, Card paramCard)
  {
    if (paramRespHead != null) {
      paramCard.vCookies = paramRespHead.vCookies;
    }
    if (paramRespSummaryCard.i0x6d4Success != 0) {
      QLog.e("TempProfileBusinessProcessor", 1, String.format("handleGetSummaryCardForVote 0x6d4 fail. resultCode=%d", new Object[] { Integer.valueOf(paramRespSummaryCard.i0x6d4Success) }));
    }
    if (!setCardHotValue(paramCard, paramSparseArray))
    {
      if (paramRespSummaryCard.i0x6d4Success == 0)
      {
        paramCard.lVoteCount = paramRespSummaryCard.iVoteCount;
        paramCard.iVoteIncrement = paramRespSummaryCard.iLastestVoteCount;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("TempProfileBusinessProcessor", 2, "handleGetSummaryCard hot value cover vote.");
    }
    if (QLog.isColorLevel()) {
      QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetSummaryCard lVoteCount=%d iVoteIncrement=%d", new Object[] { Long.valueOf(paramCard.lVoteCount), Integer.valueOf(paramCard.iVoteIncrement) }));
    }
    if (paramRespSummaryCard.i0x6d4Success == 0)
    {
      paramCard.strVoteLimitedNotice = paramRespSummaryCard.strVoteLimitedNotice;
      paramCard.bHaveVotedCnt = paramRespSummaryCard.bHaveVotedCnt;
      paramCard.bAvailVoteCnt = paramRespSummaryCard.bAvailVoteCnt;
      if (paramCard.bHaveVotedCnt > 0) {
        paramCard.bVoted = 1;
      } else {
        paramCard.bVoted = 0;
      }
      if (paramString.equals(this.appRuntime.getAccount()))
      {
        paramCard.setLastPraiseInfoList(paramRespSummaryCard.vPraiseList);
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setVoteInfo(this.appRuntime.getAccount(), paramCard.lVoteCount, paramCard.iVoteIncrement);
        EntityManager localEntityManager = this.appRuntime.getEntityManagerFactory().createEntityManager();
        paramSparseArray = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
        paramRespHead = paramSparseArray;
        if (paramSparseArray == null) {
          paramRespHead = new NearbyPeopleCard();
        }
        paramRespHead.likeCount = ((int)paramCard.lVoteCount);
        paramRespHead.likeCountInc = paramCard.iVoteIncrement;
        paramRespHead.praiseList = paramRespSummaryCard.vPraiseList;
        if (paramRespHead.getStatus() == 1000) {
          localEntityManager.persistOrReplace(paramRespHead);
        } else if ((paramRespHead.getStatus() == 1001) || (paramRespHead.getStatus() == 1002)) {
          localEntityManager.update(paramRespHead);
        }
        localEntityManager.close();
      }
    }
  }
  
  private boolean handleMiniAppPlayingInfo(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray, long paramLong1, long paramLong2)
  {
    ProfileMiniAppInfo localProfileMiniAppInfo = new ProfileMiniAppInfo();
    Object localObject1 = (BusinessRespBuffer)paramSparseArray.get(17);
    int j = 0;
    int i;
    if ((localObject1 != null) && (((BusinessRespBuffer)localObject1).buffer != null))
    {
      if (paramLong1 == paramLong2) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        paramSparseArray = new INTERFACE.StGetUserAppListRsp();
      }
    }
    for (;;)
    {
      try
      {
        paramSparseArray.mergeFrom(((BusinessRespBuffer)localObject1).buffer);
        Object localObject2 = paramSparseArray.userAppList.get();
        if ((localObject2 != null) && (((List)localObject2).size() >= 1))
        {
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            ((ArrayList)localObject1).add(((INTERFACE.StUserAppInfo)((Iterator)localObject2).next()).appInfo.get());
            continue;
          }
          localProfileMiniAppInfo.miniAppInfoArrayList = ((ArrayList)localObject1);
          if ((paramSparseArray.extInfo == null) || (paramSparseArray.extInfo.mapInfo == null)) {
            break label398;
          }
          i = j;
          if (i >= paramSparseArray.extInfo.mapInfo.size()) {
            break label398;
          }
          localObject1 = (COMM.Entry)paramSparseArray.extInfo.mapInfo.get(i);
          if (!"jumpUrl".equals(((COMM.Entry)localObject1).key.get())) {
            break label421;
          }
          localProfileMiniAppInfo.tabJumpUrl = ((COMM.Entry)localObject1).value.get();
          break label421;
        }
        localProfileMiniAppInfo.isShowMiniPlaying = false;
        return true;
      }
      catch (Exception paramSparseArray)
      {
        if (!QLog.isColorLevel()) {
          break label398;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResponse fail.");
      ((StringBuilder)localObject1).append(paramSparseArray);
      QLog.d("TempProfileBusinessProcessor", 2, ((StringBuilder)localObject1).toString());
      break label398;
      paramSparseArray = new MISC.StGetFriendPlayListV2Rsp();
      try
      {
        paramSparseArray.mergeFrom(((BusinessRespBuffer)localObject1).buffer);
        localProfileMiniAppInfo.appPlayingInfos = paramSparseArray.appPlayingInfos.get();
        if ((localProfileMiniAppInfo.appPlayingInfos != null) && (localProfileMiniAppInfo.appPlayingInfos.size() >= 1))
        {
          localProfileMiniAppInfo.guestJumpUrl = paramSparseArray.moreJumpLink.get();
          localProfileMiniAppInfo.guestAppTotal = paramSparseArray.total.get();
        }
        else
        {
          localProfileMiniAppInfo.isShowMiniPlaying = false;
          return true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramSparseArray)
      {
        paramSparseArray.printStackTrace();
      }
      label398:
      localProfileMiniAppInfo.isShowMiniPlaying = true;
      break label413;
      localProfileMiniAppInfo.isShowMiniPlaying = false;
      label413:
      paramCard.putBusinessInfo(localProfileMiniAppInfo);
      return true;
      label421:
      i += 1;
    }
  }
  
  private boolean handleVaProfileGate(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    Object localObject1 = (BusinessRespBuffer)paramSparseArray.get(16);
    if ((localObject1 != null) && (((BusinessRespBuffer)localObject1).buffer != null)) {
      paramSparseArray = new VaProfileGate.VaProfileGateRsp();
    }
    for (;;)
    {
      int i;
      try
      {
        paramSparseArray.mergeFrom(((BusinessRespBuffer)localObject1).buffer);
        if (paramSparseArray.iRetCode.get() == 0)
        {
          if (paramSparseArray.lhLogoLv.has()) {
            paramCard.lhLevel = paramSparseArray.lhLogoLv.get();
          }
          parseQidInfo(paramCard, paramSparseArray);
          localObject1 = paramSparseArray.stPrivilegeRsp;
          localObject2 = paramSparseArray.stGiftRsp;
          i = 0;
          if (i < paramSparseArray.rpt_task_item.size())
          {
            localObject3 = (VaProfileGate.CommTaskInfo)paramSparseArray.rpt_task_item.get(i);
            if (4 != ((VaProfileGate.CommTaskInfo)localObject3).uint32_appid.get()) {
              break label1119;
            }
            ProfileMusicBox.a((VaProfileGate.CommTaskInfo)localObject3, paramCard);
            break label1119;
          }
          paramCard.presentDesc = ((VaProfileGate.GetGiftListRsp)localObject2).desc.get();
          paramCard.presentCustourl = ((VaProfileGate.GetGiftListRsp)localObject2).custom_url.get();
          paramCard.presentSwitch = ((VaProfileGate.GetGiftListRsp)localObject2).is_on.get();
          paramCard.presentUrl = ((VaProfileGate.GetGiftListRsp)localObject2).gift_url.get();
          if (((VaProfileGate.GetGiftListRsp)localObject2).is_on.get()) {
            ReportController.b(this.appRuntime, "", "", "", "0X800A1CA", "0X800A1CA", 0, 0, "", "", "", "");
          } else {
            ReportController.b(this.appRuntime, "", "", "", "0X800A1CB", "0X800A1CB", 0, 0, "", "", "", "");
          }
          if (paramCard.presentUrl.size() > 0) {
            paramCard.showPresent = true;
          } else {
            paramCard.showPresent = false;
          }
          parseIPrivilegeInfo(paramCard, paramSparseArray, (VaProfileGate.PrivilegeBaseInfoRsp)localObject1);
          if (paramSparseArray.rpt_oidb_flag.has())
          {
            localObject2 = paramSparseArray.rpt_oidb_flag.get();
            i = 0;
            if (i < ((List)localObject2).size())
            {
              localObject3 = (VaProfileGate.OidbFlagInfo)((List)localObject2).get(i);
              if (((VaProfileGate.OidbFlagInfo)localObject3).uint32_fieled.get() == 42334) {
                localObject3 = ((VaProfileGate.OidbFlagInfo)localObject3).byets_value.get().toStringUtf8();
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramCard)
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        paramSparseArray = new StringBuilder();
        paramSparseArray.append("rsp VASPROFILEGATE_SERVICE decode error:");
        paramSparseArray.append(paramCard);
        QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, paramSparseArray.toString());
        return false;
      }
      try
      {
        paramCard.mQQLevelType = Integer.parseInt((String)localObject3);
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        continue;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("rsp VASPROFILEGATE_SERVICE oidb FIELD_QQ_LEVEL_ICON_TYPE flag content error , valStr:");
      ((StringBuilder)localObject4).append((String)localObject3);
      QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 2, ((StringBuilder)localObject4).toString());
      break label1132;
      if (((VaProfileGate.OidbFlagInfo)localObject3).uint32_fieled.get() == 42340) {
        localObject3 = ((VaProfileGate.OidbFlagInfo)localObject3).byets_value.get().toStringUtf8();
      }
      try
      {
        paramCard.switchMusicBox = Short.parseShort((String)localObject3);
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        continue;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("rsp VASPROFILEGATE_SERVICE oidb FIELD_MUSICBOX_SWITCH flag content error , valStr:");
      ((StringBuilder)localObject4).append((String)localObject3);
      QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 2, ((StringBuilder)localObject4).toString());
      break label1132;
      int j = ((VaProfileGate.OidbFlagInfo)localObject3).uint32_fieled.get();
      if (j == 42344) {
        localObject3 = ((VaProfileGate.OidbFlagInfo)localObject3).byets_value.get().toStringUtf8();
      }
      try
      {
        paramCard.nameplateVipType = Short.parseShort((String)localObject3);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("handleVaProfileGate = ");
        ((StringBuilder)localObject4).append(paramCard.nameplateVipType);
        QLog.i("TempProfileBusinessProcessor", 1, ((StringBuilder)localObject4).toString());
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        continue;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("rsp VASPROFILEGATE_SERVICE oidb FIELD_NAMEPLATEVIPTYPE flag content error , valStr:");
      ((StringBuilder)localObject4).append((String)localObject3);
      QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 2, ((StringBuilder)localObject4).toString());
      break label1132;
      if (((VaProfileGate.OidbFlagInfo)localObject3).uint32_fieled.get() == 42354) {
        localObject3 = ((VaProfileGate.OidbFlagInfo)localObject3).byets_value.get().toStringUtf8();
      }
      try
      {
        paramCard.grayNameplateFlag = Short.parseShort((String)localObject3);
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        continue;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("rsp VASPROFILEGATE_SERVICE oidb FIELD_GRAYNAMEPLATE flag content error , valStr:");
      ((StringBuilder)localObject4).append((String)localObject3);
      QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 2, ((StringBuilder)localObject4).toString());
      break label1132;
      j = ((VaProfileGate.OidbFlagInfo)localObject3).uint32_fieled.get();
      if (j == 27375)
      {
        try
        {
          localObject4 = new Dialogue();
          ((Dialogue)localObject4).mergeFrom(((VaProfileGate.OidbFlagInfo)localObject3).byets_value.get().toByteArray());
          if (!((Dialogue)localObject4).nameplate_pendant_itemid.has()) {
            break label1126;
          }
          j = ((Dialogue)localObject4).nameplate_pendant_itemid.get();
          paramCard.nameplateExtId = j;
          paramCard.gameCardId = ((Dialogue)localObject4).game_nameplate.get();
        }
        catch (Exception localException)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("big_vip_ext,card_parse,error:");
          ((StringBuilder)localObject4).append(localException.getMessage());
          QLog.d("TempProfileBusinessProcessor", 1, ((StringBuilder)localObject4).toString());
        }
        if (paramSparseArray.st_vip_care.has())
        {
          localObject2 = (VaProfileGate.GetVipCareRsp)paramSparseArray.st_vip_care.get();
          i = ((VaProfileGate.GetVipCareRsp)localObject2).uint32_buss.get();
          j = ((VaProfileGate.GetVipCareRsp)localObject2).uint32_notice.get();
          if ((i != 0) && (j != 0)) {
            ((VasExtensionManager)this.appRuntime.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a(j | i << 4);
          }
        }
        if (paramSparseArray.qq_value.has()) {
          QQValueInfoManage.a().b(paramCard.uin, paramSparseArray.qq_value.get());
        }
        if (!paramSparseArray.stPrivilegeRsp.has())
        {
          QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "rsp VASPROFILEGATE_SERVICE decode priv rsp is null!");
          return false;
        }
        if (((VaProfileGate.PrivilegeBaseInfoRsp)localObject1).uIsGrayUsr.get() != 0) {
          break;
        }
        QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "rsp VASPROFILEGATE_SERVICE current user is not gray user.");
        return false;
        paramCard = new StringBuilder();
        paramCard.append("rsp VASPROFILEGATE_SERVICE failed:");
        paramCard.append(paramSparseArray.iRetCode.get());
        paramCard.append(" msg=");
        paramCard.append(paramSparseArray.sRetMsg.get().toStringUtf8());
        QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, paramCard.toString());
        return false;
        QLog.e("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "rsp VASPROFILEGATE_SERVICE is null!");
        return false;
        label1119:
        i += 1;
        continue;
        label1126:
        j = 0;
      }
      else
      {
        label1132:
        i += 1;
      }
    }
    return true;
  }
  
  private void notifyContactChange(Friends paramFriends)
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.appRuntime.getRuntimeService(IPhoneContactService.class, "");
    if ((localIPhoneContactService != null) && (localIPhoneContactService.queryPhoneContactByUin(paramFriends.uin) != null)) {
      localIPhoneContactService.notifyContactChanged();
    }
  }
  
  private void parseIPrivilegeInfo(Card paramCard, VaProfileGate.VaProfileGateRsp paramVaProfileGateRsp, VaProfileGate.PrivilegeBaseInfoRsp paramPrivilegeBaseInfoRsp)
  {
    Object localObject = paramPrivilegeBaseInfoRsp;
    if ((paramVaProfileGateRsp.stPrivilegeRsp.has()) && (((VaProfileGate.PrivilegeBaseInfoRsp)localObject).uIsGrayUsr.get() != 0))
    {
      paramCard.privilegePromptStr = ((VaProfileGate.PrivilegeBaseInfoRsp)localObject).strMsg.get().toStringUtf8();
      paramCard.privilegeJumpUrl = ((VaProfileGate.PrivilegeBaseInfoRsp)localObject).strJumpUrl.get().toStringUtf8();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < ((VaProfileGate.PrivilegeBaseInfoRsp)localObject).vOpenPriv.size())
      {
        paramVaProfileGateRsp = (VaProfileGate.PrivilegeInfo)((VaProfileGate.PrivilegeBaseInfoRsp)localObject).vOpenPriv.get(i);
        localArrayList.add(new PrivilegeInfo(paramVaProfileGateRsp.iType.get(), paramVaProfileGateRsp.iSort.get(), paramVaProfileGateRsp.iFeeType.get(), paramVaProfileGateRsp.iLevel.get(), paramVaProfileGateRsp.iFlag.get(), paramVaProfileGateRsp.strIconUrl.get().toStringUtf8(), paramVaProfileGateRsp.strDeluxeIconUrl.get().toStringUtf8(), paramVaProfileGateRsp.strJumpUrl.get().toStringUtf8(), paramVaProfileGateRsp.iIsBig.get(), paramVaProfileGateRsp.iIsRemind.get(), paramVaProfileGateRsp.iRemindTime.get(), paramVaProfileGateRsp.strTipsIconUrl.get(), paramVaProfileGateRsp.iTipsTimes.get()));
        i += 1;
      }
      localObject = new ArrayList();
      i = 0;
      for (;;)
      {
        paramVaProfileGateRsp = paramPrivilegeBaseInfoRsp;
        if (i >= paramVaProfileGateRsp.vClosePriv.size()) {
          break;
        }
        paramVaProfileGateRsp = (VaProfileGate.PrivilegeInfo)paramVaProfileGateRsp.vClosePriv.get(i);
        ((ArrayList)localObject).add(new PrivilegeInfo(paramVaProfileGateRsp.iType.get(), paramVaProfileGateRsp.iSort.get(), paramVaProfileGateRsp.iFeeType.get(), paramVaProfileGateRsp.iLevel.get(), paramVaProfileGateRsp.iFlag.get(), paramVaProfileGateRsp.strIconUrl.get().toStringUtf8(), paramVaProfileGateRsp.strDeluxeIconUrl.get().toStringUtf8(), paramVaProfileGateRsp.strJumpUrl.get().toStringUtf8(), paramVaProfileGateRsp.iIsBig.get(), paramVaProfileGateRsp.iIsRemind.get(), paramVaProfileGateRsp.iRemindTime.get(), paramVaProfileGateRsp.strTipsIconUrl.get(), paramVaProfileGateRsp.iTipsTimes.get()));
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramVaProfileGateRsp = new StringBuilder();
        paramVaProfileGateRsp.append("save privilege open list=");
        paramVaProfileGateRsp.append(localArrayList.size());
        paramVaProfileGateRsp.append(" close list=");
        paramVaProfileGateRsp.append(((ArrayList)localObject).size());
        QLog.d("DIYProfileTemplate.TempProfileBusinessProcessor", 1, paramVaProfileGateRsp.toString());
      }
      paramCard.savePrivilegeOpenedInfo(localArrayList);
      paramCard.savePrivilegeClosedInfo((List)localObject);
    }
  }
  
  private void parseQidInfo(Card paramCard, VaProfileGate.VaProfileGateRsp paramVaProfileGateRsp)
  {
    if (paramVaProfileGateRsp.qid_info.has())
    {
      paramVaProfileGateRsp = (VaProfileGate.QidInfoItem)paramVaProfileGateRsp.qid_info.get();
      if (paramVaProfileGateRsp.qid.has()) {
        paramCard.qid = paramVaProfileGateRsp.qid.get();
      }
      if (paramVaProfileGateRsp.color.has()) {
        paramCard.qidColor = paramVaProfileGateRsp.color.get();
      }
      if (paramVaProfileGateRsp.logo_url.has()) {
        paramCard.qidLogoUrl = paramVaProfileGateRsp.logo_url.get();
      }
      if (paramVaProfileGateRsp.url.has()) {
        paramCard.qidBgUrl = paramVaProfileGateRsp.url.get();
      }
    }
  }
  
  private void updateFriendInfo(RespSummaryCard paramRespSummaryCard, String paramString, Card paramCard, long paramLong)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Friends localFriends = localFriendsManager.e(paramString);
    localFriends.name = paramCard.strNick;
    localFriends.remark = paramCard.strReMark;
    if ((1L & paramLong) != 0L) {
      paramString = paramCard.strShowName;
    } else {
      paramString = localFriends.alias;
    }
    localFriends.alias = paramString;
    int i = paramCard.shGender;
    byte b = 1;
    if (i != 0) {
      if (paramCard.shGender == 1) {
        b = 2;
      } else {
        b = 0;
      }
    }
    localFriends.gender = b;
    localFriends.age = paramCard.age;
    updateVipInfo(paramRespSummaryCard, paramCard, localFriends);
    updateSpecialFlag(paramCard, paramLong, localFriends);
    localFriendsManager.b(localFriends);
    notifyContactChange(localFriends);
  }
  
  private void updateRichSign(RespSummaryCard paramRespSummaryCard, String paramString, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if (((paramLong & 0x4) != 0L) && (paramExtensionInfo.richTime != paramRespSummaryCard.uSignModifyTime))
    {
      ExtensionRichStatus.a(paramExtensionInfo, paramRespSummaryCard.vRichSign, paramRespSummaryCard.uSignModifyTime);
      ((FriendListHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getRichStatus(new String[] { paramString });
      if (QLog.isColorLevel())
      {
        paramRespSummaryCard = new StringBuilder();
        paramRespSummaryCard.append("insertSignMsgIfNeeded from cardHandler uin = ");
        paramRespSummaryCard.append(paramString);
        paramRespSummaryCard.append(" result = ");
        paramRespSummaryCard.append(paramExtensionInfo.isAdded2C2C);
        QLog.d("TempProfileBusinessProcessor", 2, paramRespSummaryCard.toString());
      }
    }
  }
  
  private void updateSpecialFlag(Card paramCard, long paramLong, Friends paramFriends)
  {
    if ((paramLong & 0x8) != 0L)
    {
      if ((paramCard.lUserFlag & 1L) != 0L) {
        paramFriends.cSpecialFlag = ((byte)(paramFriends.cSpecialFlag | 0x1));
      } else {
        paramFriends.cSpecialFlag = ((byte)(paramFriends.cSpecialFlag & 0xFFFFFFFE));
      }
      if (QLog.isColorLevel())
      {
        paramCard = new StringBuilder();
        paramCard.append("cardhandler uin=");
        paramCard.append(paramFriends.uin);
        paramCard.append(", cSpecialFlag=");
        paramCard.append(paramFriends.cSpecialFlag);
        QLog.i("TempProfileBusinessProcessor", 2, paramCard.toString());
      }
    }
  }
  
  private void updateTroopInfo(long paramLong, int paramInt, RespSummaryCard paramRespSummaryCard, String paramString)
  {
    if (paramLong > 0L)
    {
      TroopManager localTroopManager = (TroopManager)this.appRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject;
      if ((paramInt != 2) && (paramInt != 5) && (paramInt != 7))
      {
        if (paramInt == 4)
        {
          localObject = (DiscussionManager)this.appRuntime.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          paramString = ((DiscussionManager)localObject).b(String.valueOf(paramLong), paramString);
          if (paramString != null)
          {
            paramString.memberName = paramRespSummaryCard.strNick;
            if ((paramRespSummaryCard.strAutoRemark != null) && (paramRespSummaryCard.strAutoRemark.length() > 0) && (!paramRespSummaryCard.strAutoRemark.equals(paramString.inteRemark)))
            {
              paramString.inteRemark = paramRespSummaryCard.strAutoRemark;
              if (paramRespSummaryCard.strAutoRemark.equals(paramRespSummaryCard.strNick)) {
                paramString.inteRemarkSource = 129L;
              } else {
                paramString.inteRemarkSource = 128L;
              }
            }
            ((DiscussionManager)localObject).a(paramString);
          }
        }
      }
      else
      {
        paramString = localTroopManager.f(String.valueOf(paramLong));
        if (paramString != null)
        {
          if (paramString.troopname != null)
          {
            if (!paramString.troopname.equals(paramRespSummaryCard.strGroupName))
            {
              paramString.troopname = paramRespSummaryCard.strGroupName;
              localTroopManager.b(paramString);
            }
          }
          else if (paramRespSummaryCard.strGroupName != null)
          {
            paramString.troopname = paramRespSummaryCard.strGroupName;
            localTroopManager.b(paramString);
          }
          localObject = ColorNickManager.b(paramRespSummaryCard.strGroupNick.getBytes());
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = paramRespSummaryCard.strGroupNick;
          }
          localTroopManager.a(String.valueOf(paramLong), String.valueOf(paramRespSummaryCard.lUIN), paramString, -100, paramRespSummaryCard.strNick, null, -100, -100, -100, -100L, -100L);
        }
      }
    }
  }
  
  private void updateVipInfo(RespSummaryCard paramRespSummaryCard, Card paramCard, Friends paramFriends)
  {
    if (paramRespSummaryCard.stVipInfo != null)
    {
      paramFriends.qqVipInfo = FriendListHandlerUtil.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_QQVIP.value(), paramFriends.qqVipInfo);
      paramFriends.superQqInfo = FriendListHandlerUtil.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), paramFriends.superQqInfo);
      paramFriends.superVipInfo = FriendListHandlerUtil.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), paramFriends.superVipInfo);
      paramFriends.bigClubInfo = FriendListHandlerUtil.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_BIGCLUB.value(), paramFriends.bigClubInfo);
      Object localObject;
      if ((paramCard != null) && (paramFriends.bigClubInfo == 0))
      {
        localObject = paramCard.getPrivilegeOpenInfo();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)((Iterator)localObject).next();
            if (localPrivilegeInfo.iType == 113)
            {
              int i = localPrivilegeInfo.iIsBig;
              int j = localPrivilegeInfo.iLevel;
              if ((i > 0) && (j > 0)) {
                paramFriends.bigClubInfo = ((short)j | (i << 8 | 0x1) << 16);
              }
            }
          }
        }
      }
      paramFriends.hollywoodVipInfo = FriendListHandlerUtil.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD.value(), paramFriends.hollywoodVipInfo);
      if ((paramRespSummaryCard.stVipInfo != null) && (paramRespSummaryCard.stVipInfo.mOpenInfo != null))
      {
        localObject = (VipOpenInfo)paramRespSummaryCard.stVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
        if (localObject != null)
        {
          paramFriends.superVipTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
          paramFriends.bigClubTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
        }
        paramRespSummaryCard = (VipOpenInfo)paramRespSummaryCard.stVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
        if (paramRespSummaryCard != null)
        {
          paramFriends.superVipTemplateId = ((int)paramRespSummaryCard.lNameplateId);
          paramFriends.bigClubTemplateId = ((int)paramRespSummaryCard.lNameplateId);
        }
        if (paramCard != null)
        {
          paramFriends.nameplateVipType = paramCard.nameplateVipType;
          paramFriends.grayNameplateFlag = paramCard.grayNameplateFlag;
        }
      }
    }
  }
  
  public void onProcessProfile0x5eb(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    try
    {
      paramBundle = String.valueOf(paramBundle.getLong("targetUin"));
      handleGetSummaryCardForUdcInner(paramBundle, paramCard, paramUdcUinData);
      handleGetSummaryCardForUdcInner2(paramBundle, paramCard, paramUdcUinData);
      if ((this.appRuntime instanceof QQAppInterface))
      {
        handleGetSummaryCardForBaseInfoPrivacy((QQAppInterface)this.appRuntime, paramCard, paramUdcUinData);
        handleGetSummaryCardForBusinessSwitch((QQAppInterface)this.appRuntime, paramCard, paramUdcUinData);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TempProfileBusinessProcessor", 2, paramBundle.toString());
      }
    }
  }
  
  public void onProcessProfileCard(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard)
  {
    long l1 = paramBundle.getLong("targetUin");
    int i = paramBundle.getInt("comeFromType");
    long l2 = paramBundle.getLong("getControl");
    long l3 = paramBundle.getLong("troopCode");
    String str = String.valueOf(l1);
    handleGetSummaryCardForNearby(paramRespSummaryCard, str);
    handleGetSummaryCardForQZone(paramRespSummaryCard, paramCard);
    handleGetSummaryCardForTemplate(paramRespSummaryCard, str, paramCard, l2);
    handleGetSummaryCardForPersonalityLabel(paramRespSummaryCard, paramCard);
    handleGetSummaryCardForMedalWall(paramRespSummaryCard, paramCard);
    paramRespHead = ((IFriendExtensionService)this.appRuntime.getRuntimeService(IFriendExtensionService.class, "all")).getExtensionInfo(str);
    paramBundle = paramRespHead;
    if (paramRespHead == null)
    {
      paramBundle = new ExtensionInfo();
      paramBundle.uin = str;
    }
    paramBundle.pendantId = paramRespSummaryCard.ulFaceAddonId;
    paramBundle.timestamp = System.currentTimeMillis();
    updateRichSign(paramRespSummaryCard, str, l2, paramBundle);
    ((FriendsManager)this.appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramBundle);
    updateFriendInfo(paramRespSummaryCard, str, paramCard, l2);
    updateTroopInfo(l3, i, paramRespSummaryCard, str);
    handleGetSummaryCardForMoreInfo(paramRespSummaryCard, paramCard);
  }
  
  public void onProcessProfileService(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    long l1 = paramBundle.getLong("selfUin");
    long l2 = paramBundle.getLong("targetUin");
    handleGetSummaryCardForVote(paramRespHead, paramRespSummaryCard, paramSparseArray, String.valueOf(l2), paramCard);
    handleGetSummaryCardForPrivilege(paramRespSummaryCard, paramSparseArray, paramCard);
    handleMiniAppPlayingInfo(paramCard, paramSparseArray, l2, l1);
  }
  
  public void onRequestProfileCard(Bundle paramBundle, ArrayList<BusinessReqBuffer> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    long l1 = paramBundle.getLong("selfUin", 0L);
    long l2 = paramBundle.getLong("targetUin", 0L);
    Object localObject = new SSummaryCardQueryReq(1, l1, l2, "8.8.17", paramBundle.getInt("comeFromType", 0), 109L);
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    localUniPacket.setFuncName("query");
    localUniPacket.setServantName("MCardSvc");
    localUniPacket.put("req", localObject);
    paramBundle.putByteArray("reqTemplate", localUniPacket.encode());
    localObject = (TicketManager)this.appRuntime.getManager(2);
    if (localObject != null) {
      paramBundle.putString("loginSig", ((TicketManager)localObject).getA2(String.valueOf(l1)));
    }
    paramBundle = QVipProfileFootPrintProcessor.a();
    if ((paramBundle != null) && (paramBundle.b()))
    {
      paramBundle = new SummaryCardBusiEntry.VisitorCountReq();
      paramBundle.operuin.set((int)l1);
      paramBundle.requireuin.set((int)l2);
      paramBundle.mod.set(0);
      paramBundle.reportFlag.set(1);
      localObject = new SummaryCardBusiEntry.CommonReq();
      ((SummaryCardBusiEntry.CommonReq)localObject).vcReq.set(paramBundle);
      ((SummaryCardBusiEntry.CommonReq)localObject).serviceCmd.set("profileVisitor.getVisitorCnt");
      paramArrayList.add(new BusinessReqBuffer(15, ((SummaryCardBusiEntry.CommonReq)localObject).toByteArray()));
    }
    paramArrayList.add(new BusinessReqBuffer(16, buildVaProfileGateReq(l2).toByteArray()));
    if (l1 == l2) {
      paramArrayList.add(new BusinessReqBuffer(17, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getGetUserAppListRequestBusiBuf(l1, 5L)));
    } else {
      paramArrayList.add(new BusinessReqBuffer(17, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getGetFriendPlayListV2RequestBusiBuf(String.valueOf(l2), 1)));
    }
    if (l1 == l2)
    {
      paramArrayList1.add(Integer.valueOf(42104));
      paramArrayList1.add(Integer.valueOf(41611));
      paramArrayList1.add(Integer.valueOf(41610));
      paramArrayList1.add(Integer.valueOf(41607));
      paramArrayList1.add(Integer.valueOf(41609));
      paramArrayList1.add(Integer.valueOf(41618));
      paramArrayList1.add(Integer.valueOf(41619));
      paramArrayList1.add(Integer.valueOf(41614));
      paramArrayList1.add(Integer.valueOf(41613));
      paramArrayList1.add(Integer.valueOf(41622));
      paramArrayList1.add(Integer.valueOf(41623));
      paramArrayList1.add(Integer.valueOf(40272));
    }
    paramArrayList1.add(Integer.valueOf(27225));
    paramArrayList1.add(Integer.valueOf(27224));
    paramArrayList1.add(Integer.valueOf(42122));
    paramArrayList1.add(Integer.valueOf(42121));
    paramArrayList1.add(Integer.valueOf(42167));
    paramArrayList1.add(Integer.valueOf(42172));
    paramArrayList1.add(Integer.valueOf(40324));
    paramArrayList1.add(Integer.valueOf(42284));
    paramArrayList1.add(Integer.valueOf(42326));
    paramArrayList1.add(Integer.valueOf(42325));
    paramArrayList1.add(Integer.valueOf(42356));
    paramArrayList1.add(Integer.valueOf(42363));
    paramArrayList1.add(Integer.valueOf(42361));
    paramArrayList1.add(Integer.valueOf(42367));
    paramArrayList1.add(Integer.valueOf(42377));
    paramArrayList1.add(Integer.valueOf(42425));
    paramArrayList1.add(Integer.valueOf(42505));
    paramArrayList1.add(Integer.valueOf(42488));
  }
  
  public boolean setCardHotValue(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    Object localObject = QVipProfileFootPrintProcessor.a();
    if ((localObject != null) && (((QVipProfileFootPrintConfig)localObject).b()) && (!((QVipProfileFootPrintConfig)localObject).c()))
    {
      localObject = (BusinessRespBuffer)paramSparseArray.get(15);
      if ((localObject != null) && (((BusinessRespBuffer)localObject).buffer != null))
      {
        paramSparseArray = new SummaryCardBusiEntry.VisitorCountRsp();
        try
        {
          paramSparseArray.mergeFrom(((BusinessRespBuffer)localObject).buffer);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (paramSparseArray.hotValue.get() > 0)
        {
          paramCard.lVoteCount = paramSparseArray.hotValue.get();
          paramCard.iVoteIncrement = paramSparseArray.redValue.get();
          return true;
        }
      }
    }
    return false;
  }
  
  public void updateCardTemplate(Card paramCard, String paramString, SSummaryCardRsp paramSSummaryCardRsp)
  {
    HashMap localHashMap = new HashMap();
    if (paramSSummaryCardRsp != null)
    {
      int i = paramSSummaryCardRsp.res;
      Object localObject = "";
      if (i < 0)
      {
        paramCard = new StringBuilder();
        paramCard.append("getSummaryCard template error! res =");
        paramCard.append(paramSSummaryCardRsp.res);
        QLog.e("DIYProfileTemplate.protocol/SummaryCard", 1, paramCard.toString());
        paramCard = this.appRuntime;
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(paramSSummaryCardRsp.res);
        VasMonitorHandler.a(paramCard, "individual_v2_personalcard_get_fail", paramString.toString(), "personalcard get template = null", null, 0.0F);
        paramCard = new StringBuilder();
        paramCard.append("");
        paramCard.append(paramSSummaryCardRsp.res);
        VasMonitorDT.a("individual_v2_personalcard_get_fail", paramCard.toString());
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateCardTemplate res=");
        localStringBuilder.append(paramSSummaryCardRsp.res);
        localStringBuilder.append(" styleid=");
        localStringBuilder.append(paramSSummaryCardRsp.styleid);
        localStringBuilder.append(" bgid=");
        localStringBuilder.append(paramSSummaryCardRsp.bgid);
        localStringBuilder.append(" strDrawerCardUrl=");
        localStringBuilder.append(paramSSummaryCardRsp.strDrawerCard);
        QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, localStringBuilder.toString());
        if ((paramSSummaryCardRsp.stDiyComplicated != null) && (paramSSummaryCardRsp.stDiyComplicated.detail != null) && (paramSSummaryCardRsp.stDiyComplicated.detail.length() > 850))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stDiyComplicated(1)=");
          localStringBuilder.append(paramSSummaryCardRsp.stDiyComplicated.detail.substring(0, 840));
          QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stDiyComplicated(2)=");
          localStringBuilder.append(paramSSummaryCardRsp.stDiyComplicated.detail.substring(830, paramSSummaryCardRsp.stDiyComplicated.detail.length() - 1));
          QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stDiyComplicated=");
          localStringBuilder.append(paramSSummaryCardRsp.stDiyComplicated);
          QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, localStringBuilder.toString());
        }
      }
      paramCard.templateRet = paramSSummaryCardRsp.res;
      paramCard.lCurrentStyleId = paramSSummaryCardRsp.styleid;
      paramCard.backgroundUrl = paramSSummaryCardRsp.bgurl;
      paramCard.lCurrentBgId = paramSSummaryCardRsp.bgid;
      paramCard.backgroundColor = paramSSummaryCardRsp.color;
      paramCard.dynamicCardFlag = paramSSummaryCardRsp.dynamicCardFlag;
      paramCard.strZipUrl = paramSSummaryCardRsp.strZipUrl;
      paramCard.strActiveUrl = paramSSummaryCardRsp.strActiveCardUrl;
      paramCard.strDrawerCardUrl = paramSSummaryCardRsp.strDrawerCard;
      paramCard.strWzryHeroUrl = paramSSummaryCardRsp.strWzryHeroUrl;
      paramCard.strExtInfo = paramSSummaryCardRsp.extInfo;
      paramCard.cardType = paramSSummaryCardRsp.cardType;
      paramCard.diyDefaultText = paramSSummaryCardRsp.strDiyDefaultText;
      paramCard.defaultCardId = paramSSummaryCardRsp.profileid;
      if (paramSSummaryCardRsp.stDiyComplicated != null) {
        localObject = paramSSummaryCardRsp.stDiyComplicated.detail;
      }
      paramCard.diyComplicatedInfo = ((String)localObject);
      paramCard.cardId = paramSSummaryCardRsp.cardid;
      localObject = paramSSummaryCardRsp.bgtype;
      if (localObject != null) {
        paramCard.setBgType(localObject);
      }
      if ((paramSSummaryCardRsp.label != null) && (paramSSummaryCardRsp.label.label != null)) {
        paramCard.setLabelList(paramSSummaryCardRsp.label.label);
      }
      paramCard.setWzryHonorInfo(paramSSummaryCardRsp.wzryInfo);
      if (paramSSummaryCardRsp.stDiyText != null)
      {
        paramCard.diyTextFontId = paramSSummaryCardRsp.stDiyText.iFontId;
        paramCard.diyText = paramSSummaryCardRsp.stDiyText.strText;
        paramCard.diyTextScale = paramSSummaryCardRsp.stDiyText.fScaling;
        paramCard.diyTextDegree = paramSSummaryCardRsp.stDiyText.fRotationAngle;
        paramCard.diyTextTransparency = paramSSummaryCardRsp.stDiyText.fTransparency;
        if (!TextUtils.isEmpty(paramSSummaryCardRsp.stDiyText.strPoint))
        {
          localObject = paramSSummaryCardRsp.stDiyText.strPoint.split("_");
          if (localObject.length >= 4) {
            try
            {
              paramCard.diyTextLocX = Float.parseFloat(localObject[0]);
              paramCard.diyTextLocY = Float.parseFloat(localObject[1]);
              paramCard.diyTextWidth = Float.parseFloat(localObject[2]);
              paramCard.diyTextHeight = Float.parseFloat(localObject[3]);
            }
            catch (Exception localException)
            {
              QLog.e("Card", 1, "set card with diy text response:", localException);
            }
          }
        }
      }
      localHashMap.put("param_FailCode", "0");
      localHashMap.put("param_templateRet", String.valueOf(paramSSummaryCardRsp.res));
      if (QLog.isColorLevel())
      {
        paramSSummaryCardRsp = new StringBuilder();
        paramSSummaryCardRsp.append("updateCardTemplate templateInfo-->");
        paramSSummaryCardRsp.append(paramCard.getProfileCardDesc());
        QLog.i("protocol/SummaryCard", 2, paramSSummaryCardRsp.toString());
      }
      StatisticCollector.getInstance(this.appRuntime.getApplication()).collectPerformance(paramString, "profileCardGet", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    QLog.i("protocol/SummaryCard", 1, "updateCardTemplate templateInfo is null");
    VasMonitorHandler.a(this.appRuntime, "individual_v2_personalcard_get_fail", "personalcard_get_template_null", "personalcard get template = null", null, 0.0F);
    VasMonitorDT.a("individual_v2_personalcard_get_fail", "personalcard_get_template_null");
    localHashMap.put("param_FailCode", "-101");
    localHashMap.put("param_templateRet", "0");
    StatisticCollector.getInstance(this.appRuntime.getApplication()).collectPerformance(paramString, "profileCardGet", false, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.TempProfileBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */