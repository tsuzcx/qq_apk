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
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.friendlist.FriendListHandlerUtil;
import com.tencent.mobileqq.config.business.qvip.QVipProfileFootPrintConfig;
import com.tencent.mobileqq.config.business.qvip.QVipProfileFootPrintProcessor;
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
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.NearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.lifeachivement.LifeAchivementData;
import com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileLifeAchievementInfo;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.ProfileAnonymousAnswerInfo;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppInfo;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils;
import com.tencent.mobileqq.profilesetting.ProfileSettingUtils.Companion;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasMonitorDT;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.CommonReq;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountReq;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountRsp;
import com.tencent.pb.profilecard.VaProfileGate.CommTaskInfo;
import com.tencent.pb.profilecard.VaProfileGate.GetGiftListReq;
import com.tencent.pb.profilecard.VaProfileGate.GetVipCareReq;
import com.tencent.pb.profilecard.VaProfileGate.OidbFlagInfo;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoReq;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoRsp;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeInfo;
import com.tencent.pb.profilecard.VaProfileGate.QidInfoItem;
import com.tencent.pb.profilecard.VaProfileGate.VaProfileGateReq;
import com.tencent.pb.profilecard.VaProfileGate.VaProfileGateRsp;
import com.tencent.pb.profilecard.VipMusicBox.GetProfileMusicBoxInfoReq;
import com.tencent.qphone.base.util.QLog;
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
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.LifeAchievementItem;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.ReqBody;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.RspBody;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.Quest;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.ReqBody;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.RspBody;

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
  
  private void handleGetAnonymousInfo(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    boolean bool = false;
    paramSparseArray = (BusinessRespBuffer)paramSparseArray.get(19);
    if (QLog.isColorLevel()) {
      QLog.d("TempProfileBusinessProcessor", 2, "handleGetAnonymousInfo start vvResp = " + paramSparseArray);
    }
    if ((paramSparseArray != null) && (paramSparseArray.buffer != null)) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = new oidb_0xec4.RspBody();
        ((oidb_0xec4.RspBody)localObject).mergeFrom(paramSparseArray.buffer);
        paramSparseArray = new ProfileAnonymousAnswerInfo();
        paramSparseArray.mTotalQuestionCount = ((oidb_0xec4.RspBody)localObject).uint32_total_quest_num.get();
        paramSparseArray.mHasFetchOver = ((oidb_0xec4.RspBody)localObject).bool_is_fetch_over.get();
        if (!((oidb_0xec4.RspBody)localObject).uint32_ret.has()) {
          break label270;
        }
        i = ((oidb_0xec4.RspBody)localObject).uint32_ret.get();
      }
      catch (Exception paramCard)
      {
        Object localObject;
        long l;
        AnonymousQuestion localAnonymousQuestion;
        QLog.e("TempProfileBusinessProcessor", 1, "handleGetAnonymousInfo fail.", paramCard);
      }
      paramSparseArray.needForbidEntry = bool;
      paramSparseArray.mAnsweredQuestionCount = ((oidb_0xec4.RspBody)localObject).uint32_answered_quest_num.get();
      if (((oidb_0xec4.RspBody)localObject).msg_quest.has())
      {
        l = Long.parseLong(paramCard.uin);
        ArrayList localArrayList = new ArrayList();
        localObject = ((oidb_0xec4.RspBody)localObject).msg_quest.get().iterator();
        if (((Iterator)localObject).hasNext())
        {
          localAnonymousQuestion = AnonymousQuestion.convertQuest((oidb_0xec4.Quest)((Iterator)localObject).next(), l);
          if ((localAnonymousQuestion == null) || (TextUtils.isEmpty(localAnonymousQuestion.mQuest)) || (TextUtils.isEmpty(localAnonymousQuestion.mAnswer))) {
            continue;
          }
          localArrayList.add(localAnonymousQuestion);
          continue;
          return;
          label270:
          i = -1;
        }
        else
        {
          paramSparseArray.mAnonymousQuestions.addAll(localArrayList);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          int j = paramSparseArray.mTotalQuestionCount;
          int k = paramSparseArray.mAnsweredQuestionCount;
          QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetAnonymousInfo total=%s fetchOver=%s questionSize=%s retCode=%s needForbidEntry=%b answeredCount=%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(paramSparseArray.mHasFetchOver), Integer.valueOf(paramSparseArray.mAnonymousQuestions.size()), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(k) }));
        }
        paramCard.putBusinessInfo(paramSparseArray);
        return;
      }
      if (i == 10001) {
        bool = true;
      }
    }
  }
  
  private void handleGetLifeAchievementInfo(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "handleGetLifeAchievementInfo vvRespList=" + paramSparseArray);
    }
    Object localObject = (BusinessRespBuffer)paramSparseArray.get(18);
    if ((localObject != null) && (((BusinessRespBuffer)localObject).buffer != null)) {
      paramSparseArray = new oidb_0xe5b.RspBody();
    }
    try
    {
      paramSparseArray.mergeFrom(((BusinessRespBuffer)localObject).buffer);
      localObject = new ProfileLifeAchievementInfo();
      ((ProfileLifeAchievementInfo)localObject).lifeAchievementTotalCount = paramSparseArray.uint32_achievement_totalcount.get();
      ((ProfileLifeAchievementInfo)localObject).lifeAchievementOpenId = paramSparseArray.str_achievement_openid.get();
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo totalCount=%s openId=%s", new Object[] { Integer.valueOf(((ProfileLifeAchievementInfo)localObject).lifeAchievementTotalCount), ((ProfileLifeAchievementInfo)localObject).lifeAchievementOpenId }));
      }
      ((ProfileLifeAchievementInfo)localObject).lifeAchievementList = new ArrayList();
      if (paramSparseArray.rpt_life_ach_item != null) {
        while (i < paramSparseArray.rpt_life_ach_item.size())
        {
          LifeAchivementData localLifeAchivementData = new LifeAchivementData();
          localLifeAchivementData.jdField_b_of_type_Int = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).uint32_achievement_id.get();
          localLifeAchivementData.jdField_a_of_type_JavaLangString = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).str_achievement_title.get();
          localLifeAchivementData.jdField_b_of_type_JavaLangString = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).str_achievement_icon.get();
          localLifeAchivementData.jdField_a_of_type_Boolean = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).bool_has_praised.get();
          localLifeAchivementData.c = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).uint32_praise_num.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.SummaryCard", 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo id=%s title=%s iconUrl=%s hasPraised=%s praiseNum=%s", new Object[] { Integer.valueOf(localLifeAchivementData.jdField_b_of_type_Int), localLifeAchivementData.jdField_a_of_type_JavaLangString, localLifeAchivementData.jdField_b_of_type_JavaLangString, Boolean.valueOf(localLifeAchivementData.jdField_a_of_type_Boolean), Integer.valueOf(localLifeAchivementData.c) }));
          }
          ((ProfileLifeAchievementInfo)localObject).lifeAchievementList.add(localLifeAchivementData);
          i += 1;
        }
      }
      paramCard.putBusinessInfo((IProfileBusinessInfo)localObject);
      return;
    }
    catch (Exception paramCard)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TempProfileBusinessProcessor", 2, "handleGetLifeAchievementInfo onResponse fail." + paramCard);
    }
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
    int n;
    int i1;
    int j;
    int i;
    label192:
    int k;
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
      MedalID localMedalID;
      if (paramRespSummaryCard.stMedalWallInfo.iOpenFlag == 1)
      {
        bool = true;
        paramCard.medalSwitchDisable = bool;
        n = paramRespSummaryCard.stMedalWallInfo.iNewCount;
        i1 = paramRespSummaryCard.stMedalWallInfo.iUpgradeCount;
        paramRespSummaryCard = paramRespSummaryCard.stMedalWallInfo.strPromptParams;
        if (((n <= 0) && (i1 <= 0)) || (TextUtils.isEmpty(paramRespSummaryCard)) || (!Utils.a(paramCard.uin, this.appRuntime.getAccount()))) {
          break label418;
        }
        localObject = ((MedalWallMng)this.appRuntime.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(paramRespSummaryCard);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label310;
        }
        localObject = ((ArrayList)localObject).iterator();
        j = 0;
        i = 0;
        do
        {
          m = j;
          k = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localMedalID = (MedalID)((Iterator)localObject).next();
        } while (localMedalID == null);
        if ((localMedalID.jdField_b_of_type_Int != 1) && (localMedalID.jdField_b_of_type_Int != 255)) {
          break label277;
        }
        k = j;
        j = i + 1;
      }
      for (i = k;; i = k)
      {
        k = j;
        j = i;
        i = k;
        break label192;
        bool = false;
        break;
        label277:
        if ((localMedalID.jdField_b_of_type_Int != 2) && (localMedalID.jdField_b_of_type_Int != 3)) {
          break label405;
        }
        k = j + 1;
        j = i;
      }
      label310:
      int m = 0;
      k = 0;
      i = m;
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "summary card server[%d, %d] compute[%d, %d]", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(m) }));
        j = k;
        i = m;
      }
    }
    for (;;)
    {
      paramCard.iNewCount = j;
      paramCard.iUpgradeCount = i;
      paramCard.strPromptParams = paramRespSummaryCard;
      return;
      label405:
      k = i;
      i = j;
      j = k;
      break;
      label418:
      i = i1;
      j = n;
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
      localStringBuilder.append(str1).append("-");
      localStringBuilder.append(str2).append("-");
      localStringBuilder.append(str3).append("-");
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
      paramString = (NearbyCardManager)this.appRuntime.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if (paramString != null)
      {
        paramString.b(paramRespSummaryCard.bSex);
        paramString.a(paramRespSummaryCard.bAge);
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
    String str1;
    if (paramRespSummaryCard.mapQzoneEx != null)
    {
      str1 = paramRespSummaryCard.strRemark;
      if (TextUtils.isEmpty(paramRespSummaryCard.strRemark)) {
        str1 = (String)paramRespSummaryCard.mapQzoneEx.get("real_name");
      }
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = str1;
        if (paramCard.strQzoneHeader != null)
        {
          str2 = str1;
          if (paramCard.strQzoneHeader.length() > 10)
          {
            str2 = str1;
            if (str1 != null)
            {
              str2 = str1;
              if (str1.length() > 5) {
                str2 = str1.substring(0, 5) + "...";
              }
            }
          }
        }
        paramCard.strQzoneHeader = (str2 + paramCard.strQzoneHeader);
      }
      str1 = (String)paramRespSummaryCard.mapQzoneEx.get("enlarge_qzone");
      if (TextUtils.isEmpty(str1)) {
        break label312;
      }
    }
    for (;;)
    {
      try
      {
        paramCard.enlargeQzonePic = Integer.parseInt(str1);
        str1 = (String)paramRespSummaryCard.mapQzoneEx.get("show_publish_button");
        if (TextUtils.isEmpty(str1)) {
          break label346;
        }
        try
        {
          if (Integer.parseInt(str1) != 1) {
            break label320;
          }
          bool = true;
          paramCard.showPublishButton = bool;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          boolean bool;
          QLog.w("TempProfileBusinessProcessor", 1, "show_publish_button is not a integer:", localNumberFormatException2);
          paramCard.showPublishButton = false;
          continue;
        }
        paramCard.vQzoneCoverInfo = paramRespSummaryCard.vQzoneCoverInfo;
        if (!paramCard.isPhotoUseCache())
        {
          paramCard.qzonePhotoList.clear();
          paramRespSummaryCard = paramRespSummaryCard.oLatestPhotos;
          if ((paramRespSummaryCard != null) && (paramRespSummaryCard.vPhotos != null)) {
            paramCard.addQZonePhotoList(paramRespSummaryCard);
          }
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        QLog.w("TempProfileBusinessProcessor", 1, "strEnlargQzone is not a integer:", localNumberFormatException1);
        continue;
      }
      label312:
      paramCard.enlargeQzonePic = 0;
      continue;
      label320:
      bool = false;
      continue;
      label346:
      paramCard.showPublishButton = false;
    }
  }
  
  private void handleGetSummaryCardForTemplate(RespSummaryCard paramRespSummaryCard, String paramString, Card paramCard, long paramLong)
  {
    HashMap localHashMap;
    if ((0x20 & paramLong) != 0L)
    {
      localHashMap = new HashMap();
      if (paramRespSummaryCard.vRespTemplateInfo == null) {
        break label243;
      }
      paramRespSummaryCard = (SSummaryCardRsp)Packet.decodePacket(paramRespSummaryCard.vRespTemplateInfo, "rsp", new SSummaryCardRsp());
      updateCardTemplate(paramCard, paramString, paramRespSummaryCard);
      if ((paramRespSummaryCard != null) && (!TextUtils.isEmpty(paramRespSummaryCard.urlprefix)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TempProfileBusinessProcessor", 2, "handleGetSummaryCard: defaultCardUrlPrefix=" + paramRespSummaryCard.urlprefix + " defId=" + paramRespSummaryCard.profileid);
        }
        ProfileCardManager.jdField_a_of_type_JavaLangString = paramRespSummaryCard.urlprefix;
      }
      if ((paramRespSummaryCard != null) && (paramRespSummaryCard.stRecom != null))
      {
        paramLong = paramRespSummaryCard.stRecom.iRecomCard;
        paramString = ProfileCardManager.jdField_a_of_type_JavaLangString + paramRespSummaryCard.stRecom.strRecomUrl;
        paramRespSummaryCard = paramRespSummaryCard.stRecom.strDesc;
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramRespSummaryCard))) {
          BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0).edit().putLong("recommend_id", paramLong).putString("recommend_url", paramString).putString("recommend_desc", paramRespSummaryCard).commit();
        }
      }
    }
    return;
    label243:
    localHashMap.put("param_FailCode", "-100");
    StatisticCollector.getInstance(this.appRuntime.getApplication()).collectPerformance(paramString, "profileCardGet", false, 0L, 0L, null, "", false);
  }
  
  private void handleGetSummaryCardForUdcInner(String paramString, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    boolean bool2 = true;
    Friends localFriends = ((FriendsManager)this.appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(paramString);
    int i;
    if ((paramString.equals(this.appRuntime.getAccount())) && (paramUdcUinData.int32_history_num_flag.has()))
    {
      i = paramUdcUinData.int32_history_num_flag.get();
      SharedPreUtils.F(this.appRuntime.getApplication(), this.appRuntime.getAccount(), i);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "history_num_flag= " + i);
      }
    }
    long l;
    if (paramUdcUinData.uint64_game_appid.has())
    {
      l = paramUdcUinData.uint64_game_appid.get();
      paramCard.namePlateOfKingGameId = l;
      localFriends.namePlateOfKingGameId = l;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingGameId= " + l);
      }
    }
    if (paramUdcUinData.uint64_game_last_login_time.has())
    {
      l = paramUdcUinData.uint64_game_last_login_time.get();
      paramCard.namePlateOfKingLoginTime = l;
      localFriends.namePlateOfKingLoginTime = l;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingLoginTime= " + l);
      }
    }
    if (paramUdcUinData.uint32_plate_of_king_dan.has())
    {
      i = paramUdcUinData.uint32_plate_of_king_dan.get();
      paramCard.namePlateOfKingDan = i;
      localFriends.namePlateOfKingDan = i;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingDan= " + i);
      }
    }
    if (paramUdcUinData.uint32_plate_of_king_dan_display_switch.has())
    {
      i = paramUdcUinData.uint32_plate_of_king_dan_display_switch.get();
      if (i != 1) {
        break label604;
      }
      bool1 = true;
      paramCard.namePlateOfKingDanDisplatSwitch = bool1;
      if (i != 1) {
        break label610;
      }
    }
    label604:
    label610:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localFriends.namePlateOfKingDanDisplatSwitch = bool1;
      if ((!TextUtils.isEmpty(paramString)) && (this.appRuntime.getAccount().equals(paramString))) {
        this.appRuntime.getApplication().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.appRuntime.getAccount(), localFriends.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingDanDisplatSwitch= " + i);
      }
      if (paramUdcUinData.uint32_suspend_effect_id.has())
      {
        i = paramUdcUinData.uint32_suspend_effect_id.get();
        if (i >= 0) {
          ((SVIPHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString, i);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, "uin " + paramString + " colorScreenid= " + i);
        }
      }
      if (paramUdcUinData.uint32_vas_face_id.has())
      {
        i = paramUdcUinData.uint32_vas_face_id.get();
        ((VasExtensionManager)this.appRuntime.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.b(paramString, i);
      }
      return;
      bool1 = false;
      break;
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
    if (paramUdcUinData.uint32_extend_friend_card_shown.has())
    {
      if (paramUdcUinData.uint32_extend_friend_card_shown.get() == 0)
      {
        bool = true;
        paramCard.isShowCard = bool;
      }
    }
    else
    {
      if (paramUdcUinData.uint32_stranger_vote_switch.has())
      {
        if (paramUdcUinData.uint32_stranger_vote_switch.get() != 0) {
          break label672;
        }
        bool = true;
        label110:
        paramCard.strangerVoteOpen = bool;
        if (paramString.equals(this.appRuntime.getAccount())) {
          ((NearByGeneralManager)this.appRuntime.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b(paramCard.strangerVoteOpen);
        }
      }
      if (paramUdcUinData.uint32_school_status_flag.has())
      {
        i = paramUdcUinData.uint32_school_status_flag.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, "uin " + paramString + " uint32_school_status_flag=" + i);
        }
        paramCard.newSchoolStatusFlagForGuide = i;
      }
      if (paramUdcUinData.uint32_flag_is_pretty_group_owner.has())
      {
        if (paramUdcUinData.uint32_flag_is_pretty_group_owner.get() != 1) {
          break label678;
        }
        bool = true;
        label243:
        paramCard.isPrettyGroupOwner = bool;
        QLog.e("vip_pretty.", 1, "uin " + paramString + " is pretty troop owner:" + paramCard.isPrettyGroupOwner);
      }
      if (paramUdcUinData.uint32_flag_hide_pretty_group_owner_identity.has())
      {
        if (paramUdcUinData.uint32_flag_hide_pretty_group_owner_identity.get() != 1) {
          break label684;
        }
        bool = true;
        label313:
        paramCard.isHidePrettyGroutIdentity = bool;
        QLog.e("vip_pretty.", 1, "uin " + paramString + " is pretty hide troop owner identity:" + paramCard.isHidePrettyGroutIdentity);
      }
      if (paramUdcUinData.uint32_profile_sticky_note_switch.has())
      {
        i = paramUdcUinData.uint32_profile_sticky_note_switch.get();
        paramCard.switchStickyNote = ((short)i);
        if (QLog.isColorLevel()) {
          QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetSummaryCard uin=%s sticky_note_switch=%s", new Object[] { paramString, Integer.valueOf(i) }));
        }
      }
      if (paramUdcUinData.uint32_flag_school_verified.has()) {
        if (paramUdcUinData.uint32_flag_school_verified.get() != 1) {
          break label690;
        }
      }
    }
    label672:
    label678:
    label684:
    label690:
    for (boolean bool = true;; bool = false)
    {
      paramCard.schoolVerifiedFlag = bool;
      if (QLog.isColorLevel()) {
        QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetSummaryCard uin=%s schoolVerifiedFlag=%s", new Object[] { paramString, Boolean.valueOf(paramCard.schoolVerifiedFlag) }));
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
      return;
      bool = false;
      break;
      bool = false;
      break label110;
      bool = false;
      break label243;
      bool = false;
      break label313;
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
    label174:
    EntityManager localEntityManager;
    if (!setCardHotValue(paramCard, paramSparseArray))
    {
      if (paramRespSummaryCard.i0x6d4Success == 0)
      {
        paramCard.lVoteCount = paramRespSummaryCard.iVoteCount;
        paramCard.iVoteIncrement = paramRespSummaryCard.iLastestVoteCount;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TempProfileBusinessProcessor", 2, String.format("handleGetSummaryCard lVoteCount=%d iVoteIncrement=%d", new Object[] { Long.valueOf(paramCard.lVoteCount), Integer.valueOf(paramCard.iVoteIncrement) }));
      }
      if (paramRespSummaryCard.i0x6d4Success == 0)
      {
        paramCard.strVoteLimitedNotice = paramRespSummaryCard.strVoteLimitedNotice;
        paramCard.bHaveVotedCnt = paramRespSummaryCard.bHaveVotedCnt;
        paramCard.bAvailVoteCnt = paramRespSummaryCard.bAvailVoteCnt;
        if (paramCard.bHaveVotedCnt <= 0) {
          break label336;
        }
        paramCard.bVoted = 1;
        if (paramString.equals(this.appRuntime.getAccount()))
        {
          paramCard.setLastPraiseInfoList(paramRespSummaryCard.vPraiseList);
          NearbySPUtil.a(this.appRuntime.getAccount(), paramCard.lVoteCount, paramCard.iVoteIncrement);
          localEntityManager = this.appRuntime.getEntityManagerFactory().createEntityManager();
          paramSparseArray = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
          paramRespHead = paramSparseArray;
          if (paramSparseArray == null) {
            paramRespHead = new NearbyPeopleCard();
          }
          paramRespHead.likeCount = ((int)paramCard.lVoteCount);
          paramRespHead.likeCountInc = paramCard.iVoteIncrement;
          paramRespHead.praiseList = paramRespSummaryCard.vPraiseList;
          if (paramRespHead.getStatus() != 1000) {
            break label345;
          }
          localEntityManager.persistOrReplace(paramRespHead);
        }
      }
    }
    for (;;)
    {
      localEntityManager.close();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TempProfileBusinessProcessor", 2, "handleGetSummaryCard hot value cover vote.");
      break;
      label336:
      paramCard.bVoted = 0;
      break label174;
      label345:
      if ((paramRespHead.getStatus() == 1001) || (paramRespHead.getStatus() == 1002)) {
        localEntityManager.update(paramRespHead);
      }
    }
  }
  
  private boolean handleMiniAppPlayingInfo(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray, long paramLong1, long paramLong2)
  {
    int j = 0;
    ProfileMiniAppInfo localProfileMiniAppInfo = new ProfileMiniAppInfo();
    Object localObject1 = (BusinessRespBuffer)paramSparseArray.get(17);
    if ((localObject1 != null) && (((BusinessRespBuffer)localObject1).buffer != null)) {
      if (paramLong1 != paramLong2) {
        break label413;
      }
    }
    label413:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramSparseArray = new INTERFACE.StGetUserAppListRsp();
        try
        {
          paramSparseArray.mergeFrom(((BusinessRespBuffer)localObject1).buffer);
          if (paramSparseArray != null)
          {
            Object localObject2 = paramSparseArray.userAppList.get();
            if ((localObject2 == null) || (((List)localObject2).size() < 1))
            {
              localProfileMiniAppInfo.isShowMiniPlaying = false;
              return true;
            }
            localObject1 = new ArrayList();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add(((INTERFACE.StUserAppInfo)((Iterator)localObject2).next()).appInfo.get());
            }
          }
          localProfileMiniAppInfo.isShowMiniPlaying = true;
        }
        catch (Exception paramSparseArray)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TempProfileBusinessProcessor", 2, "onResponse fail." + paramSparseArray);
          }
        }
      }
      for (;;)
      {
        paramCard.putBusinessInfo(localProfileMiniAppInfo);
        return true;
        localProfileMiniAppInfo.miniAppInfoArrayList = ((ArrayList)localObject1);
        if ((paramSparseArray.extInfo != null) && (paramSparseArray.extInfo.mapInfo != null))
        {
          i = j;
          while (i < paramSparseArray.extInfo.mapInfo.size())
          {
            localObject1 = (COMM.Entry)paramSparseArray.extInfo.mapInfo.get(i);
            if ("jumpUrl".equals(((COMM.Entry)localObject1).key.get())) {
              localProfileMiniAppInfo.tabJumpUrl = ((COMM.Entry)localObject1).value.get();
            }
            i += 1;
          }
          continue;
          paramSparseArray = new MISC.StGetFriendPlayListV2Rsp();
          try
          {
            paramSparseArray.mergeFrom(((BusinessRespBuffer)localObject1).buffer);
            if (paramSparseArray == null) {
              continue;
            }
            localProfileMiniAppInfo.appPlayingInfos = paramSparseArray.appPlayingInfos.get();
            if ((localProfileMiniAppInfo.appPlayingInfos != null) && (localProfileMiniAppInfo.appPlayingInfos.size() >= 1)) {
              break label377;
            }
            localProfileMiniAppInfo.isShowMiniPlaying = false;
            return true;
          }
          catch (InvalidProtocolBufferMicroException paramSparseArray)
          {
            paramSparseArray.printStackTrace();
          }
          continue;
          label377:
          localProfileMiniAppInfo.guestJumpUrl = paramSparseArray.moreJumpLink.get();
          localProfileMiniAppInfo.guestAppTotal = paramSparseArray.total.get();
          continue;
          localProfileMiniAppInfo.isShowMiniPlaying = false;
        }
      }
    }
  }
  
  /* Error */
  private boolean handleVaProfileGate(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: bipush 16
    //   3: invokevirtual 143	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   6: checkcast 145	com/tencent/mobileqq/profilecard/entity/BusinessRespBuffer
    //   9: astore 5
    //   11: aload 5
    //   13: ifnull +964 -> 977
    //   16: aload 5
    //   18: getfield 175	com/tencent/mobileqq/profilecard/entity/BusinessRespBuffer:buffer	[B
    //   21: ifnull +956 -> 977
    //   24: new 1305	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp
    //   27: dup
    //   28: invokespecial 1306	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:<init>	()V
    //   31: astore_2
    //   32: aload_2
    //   33: aload 5
    //   35: getfield 175	com/tencent/mobileqq/profilecard/entity/BusinessRespBuffer:buffer	[B
    //   38: invokevirtual 1307	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: pop
    //   42: aload_2
    //   43: getfield 1311	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:iRetCode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   46: invokevirtual 1314	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   49: ifne +872 -> 921
    //   52: aload_2
    //   53: getfield 1317	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:lhLogoLv	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   56: invokevirtual 1318	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   59: ifeq +14 -> 73
    //   62: aload_1
    //   63: aload_2
    //   64: getfield 1317	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:lhLogoLv	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   67: invokevirtual 1314	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   70: putfield 1321	com/tencent/mobileqq/data/Card:lhLevel	I
    //   73: aload_0
    //   74: aload_1
    //   75: aload_2
    //   76: invokespecial 1325	com/tencent/mobileqq/profilecard/processor/TempProfileBusinessProcessor:parseQidInfo	(Lcom/tencent/mobileqq/data/Card;Lcom/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp;)V
    //   79: aload_2
    //   80: getfield 1329	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:stPrivilegeRsp	Lcom/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp;
    //   83: astore 5
    //   85: aload_2
    //   86: getfield 1333	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:stGiftRsp	Lcom/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp;
    //   89: astore 6
    //   91: iconst_0
    //   92: istore_3
    //   93: iload_3
    //   94: aload_2
    //   95: getfield 1334	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_task_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   98: invokevirtual 370	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   101: if_icmpge +37 -> 138
    //   104: aload_2
    //   105: getfield 1334	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_task_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   108: iload_3
    //   109: invokevirtual 376	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   112: checkcast 62	com/tencent/pb/profilecard/VaProfileGate$CommTaskInfo
    //   115: astore 7
    //   117: iconst_4
    //   118: aload 7
    //   120: getfield 66	com/tencent/pb/profilecard/VaProfileGate$CommTaskInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: if_icmpne +863 -> 989
    //   129: aload 7
    //   131: aload_1
    //   132: invokestatic 1339	com/tencent/mobileqq/profile/musicbox/ProfileMusicBox:a	(Lcom/tencent/pb/profilecard/VaProfileGate$CommTaskInfo;Lcom/tencent/mobileqq/data/Card;)V
    //   135: goto +854 -> 989
    //   138: aload_1
    //   139: aload 6
    //   141: getfield 1344	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   144: invokevirtual 348	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   147: putfield 1347	com/tencent/mobileqq/data/Card:presentDesc	Ljava/lang/String;
    //   150: aload_1
    //   151: aload 6
    //   153: getfield 1350	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:custom_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   156: invokevirtual 348	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   159: putfield 1353	com/tencent/mobileqq/data/Card:presentCustourl	Ljava/lang/String;
    //   162: aload_1
    //   163: aload 6
    //   165: getfield 1356	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:is_on	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   168: invokevirtual 203	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   171: putfield 1359	com/tencent/mobileqq/data/Card:presentSwitch	Z
    //   174: aload_1
    //   175: aload 6
    //   177: getfield 1363	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:gift_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   180: invokevirtual 1366	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   183: putfield 1369	com/tencent/mobileqq/data/Card:presentUrl	Ljava/util/List;
    //   186: aload 6
    //   188: getfield 1356	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:is_on	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   191: invokevirtual 203	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   194: ifeq +151 -> 345
    //   197: aload_0
    //   198: getfield 525	com/tencent/mobileqq/profilecard/processor/TempProfileBusinessProcessor:appRuntime	Lmqq/app/AppRuntime;
    //   201: ldc_w 884
    //   204: ldc_w 884
    //   207: ldc_w 884
    //   210: ldc_w 1371
    //   213: ldc_w 1371
    //   216: iconst_0
    //   217: iconst_0
    //   218: ldc_w 884
    //   221: ldc_w 884
    //   224: ldc_w 884
    //   227: ldc_w 884
    //   230: invokestatic 1376	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_1
    //   234: getfield 1369	com/tencent/mobileqq/data/Card:presentUrl	Ljava/util/List;
    //   237: invokeinterface 307 1 0
    //   242: ifle +172 -> 414
    //   245: aload_1
    //   246: iconst_1
    //   247: putfield 1379	com/tencent/mobileqq/data/Card:showPresent	Z
    //   250: aload_0
    //   251: aload_1
    //   252: aload_2
    //   253: aload 5
    //   255: invokespecial 1383	com/tencent/mobileqq/profilecard/processor/TempProfileBusinessProcessor:parseIPrivilegeInfo	(Lcom/tencent/mobileqq/data/Card;Lcom/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp;Lcom/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp;)V
    //   258: aload_2
    //   259: getfield 1384	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_oidb_flag	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   262: invokevirtual 226	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   265: ifeq +512 -> 777
    //   268: aload_2
    //   269: getfield 1384	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_oidb_flag	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   272: invokevirtual 239	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   275: astore 6
    //   277: iconst_0
    //   278: istore_3
    //   279: iload_3
    //   280: aload 6
    //   282: invokeinterface 307 1 0
    //   287: if_icmpge +490 -> 777
    //   290: aload 6
    //   292: iload_3
    //   293: invokeinterface 1385 2 0
    //   298: checkcast 23	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo
    //   301: astore 7
    //   303: aload 7
    //   305: getfield 28	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   308: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   311: ldc 29
    //   313: if_icmpne +142 -> 455
    //   316: aload 7
    //   318: getfield 1388	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   321: invokevirtual 1391	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   324: invokevirtual 1394	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   327: astore 7
    //   329: aload_1
    //   330: aload 7
    //   332: invokestatic 729	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   335: putfield 1397	com/tencent/mobileqq/data/Card:mQQLevelType	I
    //   338: iload_3
    //   339: iconst_1
    //   340: iadd
    //   341: istore_3
    //   342: goto -63 -> 279
    //   345: aload_0
    //   346: getfield 525	com/tencent/mobileqq/profilecard/processor/TempProfileBusinessProcessor:appRuntime	Lmqq/app/AppRuntime;
    //   349: ldc_w 884
    //   352: ldc_w 884
    //   355: ldc_w 884
    //   358: ldc_w 1399
    //   361: ldc_w 1399
    //   364: iconst_0
    //   365: iconst_0
    //   366: ldc_w 884
    //   369: ldc_w 884
    //   372: ldc_w 884
    //   375: ldc_w 884
    //   378: invokestatic 1376	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   381: goto -148 -> 233
    //   384: astore_1
    //   385: ldc_w 1401
    //   388: iconst_1
    //   389: new 153	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 1403
    //   399: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_1
    //   403: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: iconst_0
    //   413: ireturn
    //   414: aload_1
    //   415: iconst_0
    //   416: putfield 1379	com/tencent/mobileqq/data/Card:showPresent	Z
    //   419: goto -169 -> 250
    //   422: astore 8
    //   424: ldc_w 1401
    //   427: iconst_2
    //   428: new 153	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   435: ldc_w 1405
    //   438: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 7
    //   443: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: goto -114 -> 338
    //   455: aload 7
    //   457: getfield 28	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   460: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   463: ldc 40
    //   465: if_icmpne +61 -> 526
    //   468: aload 7
    //   470: getfield 1388	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   473: invokevirtual 1391	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   476: invokevirtual 1394	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   479: astore 7
    //   481: aload_1
    //   482: aload 7
    //   484: invokestatic 1411	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   487: putfield 1414	com/tencent/mobileqq/data/Card:switchMusicBox	S
    //   490: goto -152 -> 338
    //   493: astore 8
    //   495: ldc_w 1401
    //   498: iconst_2
    //   499: new 153	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   506: ldc_w 1416
    //   509: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 7
    //   514: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: goto -185 -> 338
    //   526: aload 7
    //   528: getfield 28	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   531: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   534: ldc 41
    //   536: if_icmpne +61 -> 597
    //   539: aload 7
    //   541: getfield 1388	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   544: invokevirtual 1391	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   547: invokevirtual 1394	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   550: astore 7
    //   552: aload_1
    //   553: aload 7
    //   555: invokestatic 1411	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   558: putfield 1419	com/tencent/mobileqq/data/Card:nameplateVipType	I
    //   561: goto -223 -> 338
    //   564: astore 8
    //   566: ldc_w 1401
    //   569: iconst_2
    //   570: new 153	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 1421
    //   580: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 7
    //   585: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: goto -256 -> 338
    //   597: aload 7
    //   599: getfield 28	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   602: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   605: ldc 42
    //   607: if_icmpne +61 -> 668
    //   610: aload 7
    //   612: getfield 1388	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   615: invokevirtual 1391	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   618: invokevirtual 1394	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   621: astore 7
    //   623: aload_1
    //   624: aload 7
    //   626: invokestatic 1411	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   629: putfield 1424	com/tencent/mobileqq/data/Card:grayNameplateFlag	I
    //   632: goto -294 -> 338
    //   635: astore 8
    //   637: ldc_w 1401
    //   640: iconst_2
    //   641: new 153	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   648: ldc_w 1426
    //   651: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload 7
    //   656: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: goto -327 -> 338
    //   668: aload 7
    //   670: getfield 28	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   673: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   676: istore 4
    //   678: iload 4
    //   680: sipush 27375
    //   683: if_icmpne -345 -> 338
    //   686: new 1428	gxh_message/Dialogue
    //   689: dup
    //   690: invokespecial 1429	gxh_message/Dialogue:<init>	()V
    //   693: astore 8
    //   695: aload 8
    //   697: aload 7
    //   699: getfield 1388	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   702: invokevirtual 1391	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   705: invokevirtual 1430	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   708: invokevirtual 1431	gxh_message/Dialogue:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   711: pop
    //   712: aload 8
    //   714: getfield 1434	gxh_message/Dialogue:short_nameplate_itemid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   717: invokevirtual 1318	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   720: ifeq +276 -> 996
    //   723: aload 8
    //   725: getfield 1434	gxh_message/Dialogue:short_nameplate_itemid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   728: invokevirtual 1314	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   731: istore 4
    //   733: aload_1
    //   734: iload 4
    //   736: putfield 1437	com/tencent/mobileqq/data/Card:nameplateExtId	I
    //   739: goto -401 -> 338
    //   742: astore 7
    //   744: ldc 9
    //   746: iconst_1
    //   747: new 153	java/lang/StringBuilder
    //   750: dup
    //   751: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   754: ldc_w 1439
    //   757: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: aload 7
    //   762: invokevirtual 1442	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   765: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: goto -436 -> 338
    //   777: aload_2
    //   778: getfield 1445	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:st_vip_care	Lcom/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp;
    //   781: invokevirtual 1448	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:has	()Z
    //   784: ifeq +65 -> 849
    //   787: aload_2
    //   788: getfield 1445	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:st_vip_care	Lcom/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp;
    //   791: invokevirtual 1449	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   794: checkcast 1447	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp
    //   797: astore 6
    //   799: aload 6
    //   801: getfield 1452	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:uint32_buss	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   804: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   807: istore_3
    //   808: aload 6
    //   810: getfield 1455	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:uint32_notice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   813: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   816: istore 4
    //   818: iload_3
    //   819: ifeq +30 -> 849
    //   822: iload 4
    //   824: ifeq +25 -> 849
    //   827: aload_0
    //   828: getfield 525	com/tencent/mobileqq/profilecard/processor/TempProfileBusinessProcessor:appRuntime	Lmqq/app/AppRuntime;
    //   831: getstatic 997	com/tencent/mobileqq/app/QQManagerFactory:VAS_EXTENSION_MANAGER	I
    //   834: invokevirtual 544	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   837: checkcast 999	com/tencent/mobileqq/vas/VasExtensionManager
    //   840: iload_3
    //   841: iconst_4
    //   842: ishl
    //   843: iload 4
    //   845: ior
    //   846: invokevirtual 1456	com/tencent/mobileqq/vas/VasExtensionManager:a	(I)V
    //   849: aload_2
    //   850: getfield 1460	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:qq_value	Lcom/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem;
    //   853: invokevirtual 1463	com/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem:has	()Z
    //   856: ifeq +20 -> 876
    //   859: invokestatic 1468	com/tencent/mobileqq/vas/qqvaluecard/QQValueInfoManage:a	()Lcom/tencent/mobileqq/vas/qqvaluecard/QQValueInfoManage;
    //   862: aload_1
    //   863: getfield 230	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   866: aload_2
    //   867: getfield 1460	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:qq_value	Lcom/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem;
    //   870: invokevirtual 1469	com/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   873: invokevirtual 1472	com/tencent/mobileqq/vas/qqvaluecard/QQValueInfoManage:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   876: aload_2
    //   877: getfield 1329	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:stPrivilegeRsp	Lcom/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp;
    //   880: invokevirtual 1475	com/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp:has	()Z
    //   883: ifne +15 -> 898
    //   886: ldc_w 1401
    //   889: iconst_1
    //   890: ldc_w 1477
    //   893: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   896: iconst_0
    //   897: ireturn
    //   898: aload 5
    //   900: getfield 1480	com/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp:uIsGrayUsr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   903: invokevirtual 191	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   906: ifne +69 -> 975
    //   909: ldc_w 1401
    //   912: iconst_1
    //   913: ldc_w 1482
    //   916: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   919: iconst_0
    //   920: ireturn
    //   921: ldc_w 1401
    //   924: iconst_1
    //   925: new 153	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   932: ldc_w 1484
    //   935: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload_2
    //   939: getfield 1311	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:iRetCode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   942: invokevirtual 1314	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   945: invokevirtual 808	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   948: ldc_w 1486
    //   951: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: aload_2
    //   955: getfield 1489	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:sRetMsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   958: invokevirtual 1391	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   961: invokevirtual 1394	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   964: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   973: iconst_0
    //   974: ireturn
    //   975: iconst_1
    //   976: ireturn
    //   977: ldc_w 1401
    //   980: iconst_1
    //   981: ldc_w 1491
    //   984: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: iconst_0
    //   988: ireturn
    //   989: iload_3
    //   990: iconst_1
    //   991: iadd
    //   992: istore_3
    //   993: goto -900 -> 93
    //   996: iconst_0
    //   997: istore 4
    //   999: goto -266 -> 733
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1002	0	this	TempProfileBusinessProcessor
    //   0	1002	1	paramCard	Card
    //   0	1002	2	paramSparseArray	SparseArray<BusinessRespBuffer>
    //   92	901	3	i	int
    //   676	322	4	j	int
    //   9	890	5	localObject1	Object
    //   89	720	6	localObject2	Object
    //   115	583	7	localObject3	Object
    //   742	19	7	localException	Exception
    //   422	1	8	localNumberFormatException1	NumberFormatException
    //   493	1	8	localNumberFormatException2	NumberFormatException
    //   564	1	8	localNumberFormatException3	NumberFormatException
    //   635	1	8	localNumberFormatException4	NumberFormatException
    //   693	31	8	localDialogue	gxh_message.Dialogue
    // Exception table:
    //   from	to	target	type
    //   32	73	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   73	91	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   93	135	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   138	233	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   233	250	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   250	277	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   279	329	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   329	338	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   345	381	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   414	419	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   424	452	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   455	481	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   481	490	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   495	523	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   526	552	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   552	561	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   566	594	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   597	623	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   623	632	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   637	665	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   668	678	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   686	733	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   733	739	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   744	774	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   777	818	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   827	849	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   849	876	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   876	896	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   898	919	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   921	973	384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   329	338	422	java/lang/NumberFormatException
    //   481	490	493	java/lang/NumberFormatException
    //   552	561	564	java/lang/NumberFormatException
    //   623	632	635	java/lang/NumberFormatException
    //   686	733	742	java/lang/Exception
    //   733	739	742	java/lang/Exception
  }
  
  private void notifyContactChange(Friends paramFriends)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.appRuntime.getManager(QQManagerFactory.CONTACT_MANAGER);
    if ((localPhoneContactManager != null) && (localPhoneContactManager.a(paramFriends.uin) != null)) {
      localPhoneContactManager.f();
    }
  }
  
  private void parseIPrivilegeInfo(Card paramCard, VaProfileGate.VaProfileGateRsp paramVaProfileGateRsp, VaProfileGate.PrivilegeBaseInfoRsp paramPrivilegeBaseInfoRsp)
  {
    if ((paramVaProfileGateRsp.stPrivilegeRsp.has()) && (paramPrivilegeBaseInfoRsp.uIsGrayUsr.get() != 0))
    {
      paramCard.privilegePromptStr = paramPrivilegeBaseInfoRsp.strMsg.get().toStringUtf8();
      paramCard.privilegeJumpUrl = paramPrivilegeBaseInfoRsp.strJumpUrl.get().toStringUtf8();
      paramVaProfileGateRsp = new ArrayList();
      int i = 0;
      while (i < paramPrivilegeBaseInfoRsp.vOpenPriv.size())
      {
        localObject = (VaProfileGate.PrivilegeInfo)paramPrivilegeBaseInfoRsp.vOpenPriv.get(i);
        paramVaProfileGateRsp.add(new PrivilegeInfo(((VaProfileGate.PrivilegeInfo)localObject).iType.get(), ((VaProfileGate.PrivilegeInfo)localObject).iSort.get(), ((VaProfileGate.PrivilegeInfo)localObject).iFeeType.get(), ((VaProfileGate.PrivilegeInfo)localObject).iLevel.get(), ((VaProfileGate.PrivilegeInfo)localObject).iFlag.get(), ((VaProfileGate.PrivilegeInfo)localObject).strIconUrl.get().toStringUtf8(), ((VaProfileGate.PrivilegeInfo)localObject).strDeluxeIconUrl.get().toStringUtf8(), ((VaProfileGate.PrivilegeInfo)localObject).strJumpUrl.get().toStringUtf8(), ((VaProfileGate.PrivilegeInfo)localObject).iIsBig.get(), ((VaProfileGate.PrivilegeInfo)localObject).iIsRemind.get(), ((VaProfileGate.PrivilegeInfo)localObject).iRemindTime.get(), ((VaProfileGate.PrivilegeInfo)localObject).strTipsIconUrl.get(), ((VaProfileGate.PrivilegeInfo)localObject).iTipsTimes.get()));
        i += 1;
      }
      Object localObject = new ArrayList();
      i = 0;
      while (i < paramPrivilegeBaseInfoRsp.vClosePriv.size())
      {
        VaProfileGate.PrivilegeInfo localPrivilegeInfo = (VaProfileGate.PrivilegeInfo)paramPrivilegeBaseInfoRsp.vClosePriv.get(i);
        ((ArrayList)localObject).add(new PrivilegeInfo(localPrivilegeInfo.iType.get(), localPrivilegeInfo.iSort.get(), localPrivilegeInfo.iFeeType.get(), localPrivilegeInfo.iLevel.get(), localPrivilegeInfo.iFlag.get(), localPrivilegeInfo.strIconUrl.get().toStringUtf8(), localPrivilegeInfo.strDeluxeIconUrl.get().toStringUtf8(), localPrivilegeInfo.strJumpUrl.get().toStringUtf8(), localPrivilegeInfo.iIsBig.get(), localPrivilegeInfo.iIsRemind.get(), localPrivilegeInfo.iRemindTime.get(), localPrivilegeInfo.strTipsIconUrl.get(), localPrivilegeInfo.iTipsTimes.get()));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.TempProfileBusinessProcessor", 1, "save privilege open list=" + paramVaProfileGateRsp.size() + " close list=" + ((ArrayList)localObject).size());
      }
      paramCard.savePrivilegeOpenedInfo(paramVaProfileGateRsp);
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
    Friends localFriends = localFriendsManager.d(paramString);
    localFriends.name = paramCard.strNick;
    localFriends.remark = paramCard.strReMark;
    byte b;
    if ((1L & paramLong) != 0L)
    {
      paramString = paramCard.strShowName;
      localFriends.alias = paramString;
      if (paramCard.shGender != 0) {
        break label127;
      }
      b = 1;
    }
    for (;;)
    {
      localFriends.gender = b;
      localFriends.age = paramCard.age;
      updateVipInfo(paramRespSummaryCard, paramCard, localFriends);
      updateSpecialFlag(paramCard, paramLong, localFriends);
      localFriendsManager.a(localFriends);
      notifyContactChange(localFriends);
      return;
      paramString = localFriends.alias;
      break;
      label127:
      if (paramCard.shGender == 1) {
        b = 2;
      } else {
        b = 0;
      }
    }
  }
  
  private void updateRichSign(RespSummaryCard paramRespSummaryCard, String paramString, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if (((0x4 & paramLong) != 0L) && (paramExtensionInfo.richTime != paramRespSummaryCard.uSignModifyTime))
    {
      ExtensionRichStatus.a(paramExtensionInfo, paramRespSummaryCard.vRichSign, paramRespSummaryCard.uSignModifyTime);
      ((FriendListHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getRichStatus(new String[] { paramString });
      if (QLog.isColorLevel()) {
        QLog.d("TempProfileBusinessProcessor", 2, "insertSignMsgIfNeeded from cardHandler uin = " + paramString + " result = " + paramExtensionInfo.isAdded2C2C);
      }
    }
  }
  
  private void updateSpecialFlag(Card paramCard, long paramLong, Friends paramFriends)
  {
    if ((0x8 & paramLong) != 0L) {
      if ((paramCard.lUserFlag & 1L) == 0L) {
        break label85;
      }
    }
    label85:
    for (paramFriends.cSpecialFlag = ((byte)(paramFriends.cSpecialFlag | 0x1));; paramFriends.cSpecialFlag = ((byte)(paramFriends.cSpecialFlag & 0xFFFFFFFE)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TempProfileBusinessProcessor", 2, "cardhandler uin=" + paramFriends.uin + ", cSpecialFlag=" + paramFriends.cSpecialFlag);
      }
      return;
    }
  }
  
  private void updateTroopInfo(long paramLong, int paramInt, RespSummaryCard paramRespSummaryCard, String paramString)
  {
    TroopManager localTroopManager;
    if (paramLong > 0L)
    {
      localTroopManager = (TroopManager)this.appRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((paramInt != 2) && (paramInt != 5) && (paramInt != 7)) {
        break label192;
      }
      paramString = localTroopManager.b(String.valueOf(paramLong));
      if (paramString != null)
      {
        if (paramString.troopname == null) {
          break label164;
        }
        if (!paramString.troopname.equals(paramRespSummaryCard.strGroupName))
        {
          paramString.troopname = paramRespSummaryCard.strGroupName;
          localTroopManager.b(paramString);
        }
      }
    }
    Object localObject;
    label164:
    label192:
    do
    {
      do
      {
        for (;;)
        {
          localObject = ColorNickManager.b(paramRespSummaryCard.strGroupNick.getBytes());
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = paramRespSummaryCard.strGroupNick;
          }
          localTroopManager.a(String.valueOf(paramLong), String.valueOf(paramRespSummaryCard.lUIN), paramString, -100, paramRespSummaryCard.strNick, null, -100, -100, -100, -100L, -100L);
          return;
          if (paramRespSummaryCard.strGroupName != null)
          {
            paramString.troopname = paramRespSummaryCard.strGroupName;
            localTroopManager.b(paramString);
          }
        }
      } while (paramInt != 4);
      localObject = (DiscussionManager)this.appRuntime.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      paramString = ((DiscussionManager)localObject).a(String.valueOf(paramLong), paramString);
    } while (paramString == null);
    paramString.memberName = paramRespSummaryCard.strNick;
    if ((paramRespSummaryCard.strAutoRemark != null) && (paramRespSummaryCard.strAutoRemark.length() > 0) && (!paramRespSummaryCard.strAutoRemark.equals(paramString.inteRemark)))
    {
      paramString.inteRemark = paramRespSummaryCard.strAutoRemark;
      if (!paramRespSummaryCard.strAutoRemark.equals(paramRespSummaryCard.strNick)) {
        break label317;
      }
    }
    label317:
    for (paramString.inteRemarkSource = 129L;; paramString.inteRemarkSource = 128L)
    {
      ((DiscussionManager)localObject).a(paramString);
      return;
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
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TempProfileBusinessProcessor", 2, paramBundle.toString());
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
    handleGetLifeAchievementInfo(paramCard, paramSparseArray);
    handleGetAnonymousInfo(paramCard, paramSparseArray);
  }
  
  public void onRequestProfileCard(Bundle paramBundle, ArrayList<BusinessReqBuffer> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    long l1 = paramBundle.getLong("selfUin", 0L);
    long l2 = paramBundle.getLong("targetUin", 0L);
    Object localObject = new SSummaryCardQueryReq(1, l1, l2, "8.5.5", paramBundle.getInt("comeFromType", 0), 109L);
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
    if ((paramBundle != null) && (paramBundle.a()))
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
    paramBundle = new oidb_0xe5b.ReqBody();
    paramBundle.uint64_uin.set(l2);
    paramBundle.uint32_max_count.set(10);
    paramBundle.bool_req_achievement_content.set(false);
    paramArrayList.add(new BusinessReqBuffer(18, paramBundle.toByteArray()));
    paramBundle = new oidb_0xec4.ReqBody();
    paramBundle.uint64_uin.set(l2);
    paramBundle.uint64_quest_num.set(10L);
    paramBundle.uint32_fetch_type.set(1);
    paramArrayList.add(new BusinessReqBuffer(19, paramBundle.toByteArray()));
    if (l1 == l2) {
      paramArrayList.add(new BusinessReqBuffer(17, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getGetUserAppListRequestBusiBuf(l1, 5L)));
    }
    for (;;)
    {
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
      return;
      paramArrayList.add(new BusinessReqBuffer(17, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getGetFriendPlayListV2RequestBusiBuf(String.valueOf(l2), 1)));
    }
  }
  
  public boolean setCardHotValue(Card paramCard, SparseArray<BusinessRespBuffer> paramSparseArray)
  {
    Object localObject = QVipProfileFootPrintProcessor.a();
    if ((localObject != null) && (((QVipProfileFootPrintConfig)localObject).a()) && (!((QVipProfileFootPrintConfig)localObject).b()))
    {
      localObject = (BusinessRespBuffer)paramSparseArray.get(15);
      if ((localObject != null) && (((BusinessRespBuffer)localObject).buffer != null))
      {
        paramSparseArray = new SummaryCardBusiEntry.VisitorCountRsp();
        try
        {
          paramSparseArray.mergeFrom(((BusinessRespBuffer)localObject).buffer);
          if (paramSparseArray.hotValue.get() > 0)
          {
            paramCard.lVoteCount = paramSparseArray.hotValue.get();
            paramCard.iVoteIncrement = paramSparseArray.redValue.get();
            return true;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
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
      if (paramSSummaryCardRsp.res < 0)
      {
        QLog.e("DIYProfileTemplate.protocol/SummaryCard", 1, "getSummaryCard template error! res =" + paramSSummaryCardRsp.res);
        VasMonitorHandler.a(this.appRuntime, "individual_v2_personalcard_get_fail", "" + paramSSummaryCardRsp.res, "personalcard get template = null", null, 0.0F);
        VasMonitorDT.a("individual_v2_personalcard_get_fail", "" + paramSSummaryCardRsp.res);
        return;
      }
      if (!QLog.isColorLevel()) {}
      for (;;)
      {
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
        Object localObject;
        if (paramSSummaryCardRsp.stDiyComplicated == null)
        {
          localObject = "";
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
              if (localObject.length < 4) {}
            }
          }
        }
        try
        {
          paramCard.diyTextLocX = Float.parseFloat(localObject[0]);
          paramCard.diyTextLocY = Float.parseFloat(localObject[1]);
          paramCard.diyTextWidth = Float.parseFloat(localObject[2]);
          paramCard.diyTextHeight = Float.parseFloat(localObject[3]);
          localHashMap.put("param_FailCode", "0");
          localHashMap.put("param_templateRet", String.valueOf(paramSSummaryCardRsp.res));
          if (QLog.isColorLevel()) {
            QLog.i("protocol/SummaryCard", 2, "updateCardTemplate templateInfo-->" + paramCard.getProfileCardDesc());
          }
          StatisticCollector.getInstance(this.appRuntime.getApplication()).collectPerformance(paramString, "profileCardGet", true, 0L, 0L, localHashMap, "", false);
          return;
          QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, "updateCardTemplate res=" + paramSSummaryCardRsp.res + " styleid=" + paramSSummaryCardRsp.styleid + " bgid=" + paramSSummaryCardRsp.bgid + " strDrawerCardUrl=" + paramSSummaryCardRsp.strDrawerCard);
          if ((paramSSummaryCardRsp.stDiyComplicated != null) && (paramSSummaryCardRsp.stDiyComplicated.detail != null) && (paramSSummaryCardRsp.stDiyComplicated.detail.length() > 850))
          {
            QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, "stDiyComplicated(1)=" + paramSSummaryCardRsp.stDiyComplicated.detail.substring(0, 840));
            QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, "stDiyComplicated(2)=" + paramSSummaryCardRsp.stDiyComplicated.detail.substring(830, paramSSummaryCardRsp.stDiyComplicated.detail.length() - 1));
          }
          else
          {
            QLog.w("DIYProfileTemplate.protocol/SummaryCard", 1, "stDiyComplicated=" + paramSSummaryCardRsp.stDiyComplicated);
            continue;
            localObject = paramSSummaryCardRsp.stDiyComplicated.detail;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("Card", 1, "set card with diy text response:", localException);
          }
        }
      }
    }
    QLog.i("protocol/SummaryCard", 1, "updateCardTemplate templateInfo is null");
    VasMonitorHandler.a(this.appRuntime, "individual_v2_personalcard_get_fail", "personalcard_get_template_null", "personalcard get template = null", null, 0.0F);
    VasMonitorDT.a("individual_v2_personalcard_get_fail", "personalcard_get_template_null");
    localHashMap.put("param_FailCode", "-101");
    localHashMap.put("param_templateRet", "0");
    StatisticCollector.getInstance(this.appRuntime.getApplication()).collectPerformance(paramString, "profileCardGet", false, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.TempProfileBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */