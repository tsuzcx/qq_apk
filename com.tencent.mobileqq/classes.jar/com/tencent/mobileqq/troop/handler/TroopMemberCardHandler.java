package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCard.CustomEntry;
import com.tencent.mobileqq.data.troop.TroopMemberCard.GBarInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard.StoryInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.config.TroopMemberCardHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetTroopAppointRemarkResp;
import friendlist.ModifyGroupCardResp;
import friendlist.stUinInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group.group_member_info.CustomEntry;
import tencent.im.group.group_member_info.GBarInfo;
import tencent.im.group.group_member_info.InfoCardVideoInfo;
import tencent.im.group.group_member_info.MemberGameInfo;
import tencent.im.group.group_member_info.MemberInfo;
import tencent.im.group.group_member_info.ReqBody;
import tencent.im.group.group_member_info.RspBody;
import tencent.im.group.group_member_info.RspGroupCardGetStory;
import tencent.im.group.group_member_info.TeamEntry;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class TroopMemberCardHandler
  extends TroopBaseHandler
  implements ITroopMemberCardHandler
{
  private AppInterface a;
  protected Set<String> a;
  
  public TroopMemberCardHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    TroopMemberCardHandlerProcessorConfig.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      try
      {
        troop_honor.GroupUserCardHonor localGroupUserCardHonor = new troop_honor.GroupUserCardHonor();
        localGroupUserCardHonor.mergeFrom(paramArrayOfByte);
        if (localGroupUserCardHonor.level.has())
        {
          int i = localGroupUserCardHonor.level.get();
          return i;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberCardHandler", 2, "parseRspToNewRealLevel exception");
        }
        paramArrayOfByte.printStackTrace();
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberCardHandler", 2, "data error");
    }
    return 0;
  }
  
  private void a(long paramLong, TroopMemberCard paramTroopMemberCard)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    ITroopMemberInfoService localITroopMemberInfoService = (ITroopMemberInfoService)this.appRuntime.getRuntimeService(ITroopMemberInfoService.class, "");
    if ((localITroopInfoService != null) && (localITroopMemberInfoService != null))
    {
      int i = -100;
      if (paramTroopMemberCard.titleId > 0) {
        i = paramTroopMemberCard.titleId;
      }
      if (paramTroopMemberCard.mUniqueTitle == null) {
        paramTroopMemberCard.mUniqueTitle = "";
      }
      String str = String.valueOf(paramTroopMemberCard.memberUin);
      Object localObject = localITroopInfoService.getTroopInfo(String.valueOf(paramLong));
      if ((paramTroopMemberCard.memberRole == 3) && (localObject != null) && (paramTroopMemberCard.memberUin != 0L) && (!str.equals(((TroopInfo)localObject).troopowneruin)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleGetTroopMemberCard change troopOwner:");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(", oldOwner=");
          localStringBuilder.append(((TroopInfo)localObject).troopowneruin);
          localStringBuilder.append(", newOwner=");
          localStringBuilder.append(str);
          QLog.d("TroopMemberCardHandler", 2, localStringBuilder.toString());
        }
        ((TroopInfo)localObject).troopowneruin = str;
        localITroopInfoService.saveTroopInfo((TroopInfo)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetTroopMemberCard memberRole:");
        ((StringBuilder)localObject).append(paramTroopMemberCard.memberRole);
        ((StringBuilder)localObject).append(",memberUin: ");
        ((StringBuilder)localObject).append(str);
        QLog.d("TroopMemberCardHandler", 2, ((StringBuilder)localObject).toString());
      }
      if (paramTroopMemberCard.memberRole != 0)
      {
        localObject = localITroopMemberInfoService.getTroopMember(String.valueOf(paramLong), str);
        int j = 1;
        if (localObject == null)
        {
          localObject = new TroopMemberInfo();
          ((TroopMemberInfo)localObject).troopuin = String.valueOf(paramLong);
          ((TroopMemberInfo)localObject).memberuin = str;
          ((TroopMemberInfo)localObject).isTroopFollowed = false;
          bool1 = true;
        }
        else
        {
          bool1 = false;
        }
        boolean bool2 = a(paramTroopMemberCard, (TroopMemberInfo)localObject, bool1);
        boolean bool1 = a(paramTroopMemberCard, i, (TroopMemberInfo)localObject, bool2);
        if ((paramTroopMemberCard.honorList != null) && ((!paramTroopMemberCard.honorList.equals(((TroopMemberInfo)localObject).honorList)) || (paramTroopMemberCard.honorRichTag != ((TroopMemberInfo)localObject).mHonorRichFlag)))
        {
          ((TroopMemberInfo)localObject).honorList = paramTroopMemberCard.honorList;
          ((TroopMemberInfo)localObject).mHonorRichFlag = paramTroopMemberCard.honorRichTag;
          bool1 = true;
          i = j;
        }
        else
        {
          i = 0;
        }
        if (bool1) {
          localITroopMemberInfoService.saveTroopMember((TroopMemberInfo)localObject, bool2);
        }
        if ((i != 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount())) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount().equals(str)))
        {
          paramTroopMemberCard = localITroopInfoService.getTroopInfo(((TroopMemberInfo)localObject).troopuin);
          if ((paramTroopMemberCard != null) && ((!((TroopMemberInfo)localObject).honorList.equals(paramTroopMemberCard.myHonorList)) || (((TroopMemberInfo)localObject).mHonorRichFlag != paramTroopMemberCard.myHonorRichFlag)))
          {
            paramTroopMemberCard.myHonorList = ((TroopMemberInfo)localObject).honorList;
            paramTroopMemberCard.myHonorRichFlag = ((TroopMemberInfo)localObject).mHonorRichFlag;
            localITroopInfoService.saveTroopInfo(paramTroopMemberCard);
          }
        }
      }
    }
  }
  
  private void a(long paramLong, TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo.msg_team_entry.has())
    {
      paramTroopMemberCard.mOrgIds.clear();
      Object localObject1 = ((group_member_info.TeamEntry)paramMemberInfo.msg_team_entry.get()).rpt_uint64_depid.get().iterator();
      long l;
      while (((Iterator)localObject1).hasNext())
      {
        l = ((Long)((Iterator)localObject1).next()).longValue();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append(l);
        localObject2 = ((StringBuilder)localObject2).toString();
        if (!paramTroopMemberCard.mOrgIds.contains(localObject2)) {
          paramTroopMemberCard.mOrgIds.add(localObject2);
        }
      }
      paramTroopMemberCard.mCurrAccountOrgIds.clear();
      paramMemberInfo = ((group_member_info.TeamEntry)paramMemberInfo.msg_team_entry.get()).rpt_uint64_self_depid.get().iterator();
      while (paramMemberInfo.hasNext())
      {
        l = ((Long)paramMemberInfo.next()).longValue();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(l);
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!paramTroopMemberCard.mCurrAccountOrgIds.contains(localObject1)) {
          paramTroopMemberCard.mCurrAccountOrgIds.add(localObject1);
        }
      }
    }
  }
  
  private void a(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo.uint32_group_honor_bit.has())
    {
      paramTroopMemberCard.honorRichTag = ((byte)paramMemberInfo.uint32_group_honor_bit.get());
      if (QLog.isColorLevel())
      {
        paramTroopMemberCard = new StringBuilder();
        paramTroopMemberCard.append("honor_rich_card,");
        paramTroopMemberCard.append(paramMemberInfo.uint32_group_honor_bit.get());
        QLog.d("TroopMemberCardHandler", 2, paramTroopMemberCard.toString());
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetTroopAppointRemarkResp paramGetTroopAppointRemarkResp)
  {
    if (paramFromServiceMsg == null)
    {
      notifyUI(TroopObserver.TYPE_GET_TROOPMEMEBER_CARD_LIST, false, null);
      return;
    }
    if (paramGetTroopAppointRemarkResp == null) {
      return;
    }
    try
    {
      if (paramGetTroopAppointRemarkResp.result != 0)
      {
        notifyUI(TroopObserver.TYPE_GET_TROOPMEMEBER_CARD_LIST, false, null);
        return;
      }
      paramFromServiceMsg = paramGetTroopAppointRemarkResp.vecTroopRemark;
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = TroopMemberCardHandlerProcessorConfig.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramGetTroopAppointRemarkResp.GroupCode), paramFromServiceMsg);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.length > 0) && (QLog.isColorLevel()))
        {
          paramGetTroopAppointRemarkResp = new StringBuilder();
          paramGetTroopAppointRemarkResp.append("bRet = ");
          paramGetTroopAppointRemarkResp.append(paramFromServiceMsg[1]);
          QLog.d("handlerGetTroopMemberCardInfoList", 2, paramGetTroopAppointRemarkResp.toString());
        }
        notifyUI(TroopObserver.TYPE_GET_TROOPMEMEBER_CARD_LIST, true, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
      notifyUI(TroopObserver.TYPE_GET_TROOPMEMEBER_CARD_LIST, false, null);
    }
  }
  
  private void a(group_member_info.RspBody paramRspBody, long paramLong, TroopMemberCard paramTroopMemberCard)
  {
    paramRspBody = (group_member_info.MemberInfo)paramRspBody.msg_meminfo.get();
    paramTroopMemberCard.result = paramRspBody.uint32_result.get();
    paramTroopMemberCard.isAllowModCard = paramRspBody.bool_is_allow_mod_card.get();
    paramTroopMemberCard.memberUin = paramRspBody.uint64_uin.get();
    paramTroopMemberCard.isFriend = paramRspBody.bool_is_friend.get();
    paramTroopMemberCard.credit = paramRspBody.uint32_credit.get();
    b(paramTroopMemberCard, paramRspBody);
    paramTroopMemberCard.sex = -1;
    if (paramRspBody.uint32_sex.has()) {
      paramTroopMemberCard.sex = paramRspBody.uint32_sex.get();
    }
    paramTroopMemberCard.location = "";
    if (paramRspBody.str_location.has()) {
      paramTroopMemberCard.location = paramRspBody.str_location.get().toStringUtf8();
    }
    paramTroopMemberCard.age = paramRspBody.uint32_age.get();
    paramTroopMemberCard.nick = "";
    paramTroopMemberCard.remark = "";
    paramTroopMemberCard.card = "";
    if (paramRspBody.str_nick.has()) {
      paramTroopMemberCard.nick = paramRspBody.str_nick.get().toStringUtf8();
    }
    if (paramRspBody.str_remark.has()) {
      paramTroopMemberCard.remark = paramRspBody.str_remark.get().toStringUtf8();
    }
    paramTroopMemberCard.levelName = paramRspBody.str_lev.get().toStringUtf8();
    if ((paramRspBody.medal_id.has()) && (paramRspBody.medal_id.get() > 0)) {
      paramTroopMemberCard.titleId = paramRspBody.medal_id.get();
    }
    if (paramRspBody.uint32_level.has()) {
      paramTroopMemberCard.realLevel = paramRspBody.uint32_level.get();
    }
    if (paramRspBody.bytes_group_honor.has()) {
      paramTroopMemberCard.newRealLevel = a(paramRspBody.bytes_group_honor.get().toByteArray());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGetTroopMemberCard, troopUin=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(", memberUin=");
      ((StringBuilder)localObject1).append(paramTroopMemberCard.memberUin);
      ((StringBuilder)localObject1).append(", titleId=");
      ((StringBuilder)localObject1).append(paramTroopMemberCard.titleId);
      QLog.d("TroopMemberCardHandler", 2, ((StringBuilder)localObject1).toString());
    }
    paramTroopMemberCard.memberRole = -1;
    if (paramRspBody.uint32_role.has()) {
      paramTroopMemberCard.memberRole = paramRspBody.uint32_role.get();
    }
    paramTroopMemberCard.joinTime = paramRspBody.uint64_join.get();
    paramTroopMemberCard.lastSpeak = paramRspBody.uint64_last_speak.get();
    paramTroopMemberCard.isVip = paramRspBody.bool_is_vip.get();
    paramTroopMemberCard.isYearVip = paramRspBody.bool_is_year_vip.get();
    paramTroopMemberCard.isSuperVip = paramRspBody.bool_is_super_vip.get();
    paramTroopMemberCard.isSuperQQ = paramRspBody.bool_is_super_qq.get();
    paramTroopMemberCard.vipLevel = paramRspBody.uint32_vip_lev.get();
    paramTroopMemberCard.gbarTitle = paramRspBody.str_gbar_title.get().toStringUtf8();
    paramTroopMemberCard.gbarLinkUrl = paramRspBody.str_gbar_url.get().toStringUtf8();
    paramTroopMemberCard.gbarCount = paramRspBody.uint32_gbar_cnt.get();
    paramTroopMemberCard.gbarList = new ArrayList();
    if ((paramRspBody.uint32_special_title_expire_time.has()) && ((paramRspBody.uint32_special_title_expire_time.get() == -1) || (paramRspBody.uint32_special_title_expire_time.get() - NetConnInfoCenter.getServerTime() > 0L)))
    {
      if (paramRspBody.bytes_special_title.has()) {
        paramTroopMemberCard.mUniqueTitle = paramRspBody.bytes_special_title.get().toStringUtf8();
      }
      paramTroopMemberCard.mUniqueTitleExpire = paramRspBody.uint32_special_title_expire_time.get();
    }
    Object localObject1 = paramRspBody.rpt_msg_gbar_concerned.get();
    int k = 0;
    int i;
    if (localObject1 != null) {
      i = ((List)localObject1).size();
    } else {
      i = 0;
    }
    int j = 0;
    Object localObject2;
    Object localObject3;
    while (j < i)
    {
      localObject2 = (group_member_info.GBarInfo)((List)localObject1).get(j);
      localObject3 = new TroopMemberCard.GBarInfo();
      ((TroopMemberCard.GBarInfo)localObject3).gbarId = ((group_member_info.GBarInfo)localObject2).uint32_gbar_id.get();
      ((TroopMemberCard.GBarInfo)localObject3).level = ((group_member_info.GBarInfo)localObject2).uint32_uin_lev.get();
      ((TroopMemberCard.GBarInfo)localObject3).headUrl = ((group_member_info.GBarInfo)localObject2).str_head_portrait.get().toStringUtf8();
      ((TroopMemberCard.GBarInfo)localObject3).name = ((group_member_info.GBarInfo)localObject2).bytes_gbar_name.get().toStringUtf8();
      paramTroopMemberCard.gbarList.add(localObject3);
      j += 1;
    }
    paramTroopMemberCard.customEntryList = new ArrayList();
    localObject1 = paramRspBody.rpt_msg_custom_enties.get();
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      j = k;
    }
    else
    {
      i = 0;
      j = k;
    }
    while (j < i)
    {
      localObject2 = (group_member_info.CustomEntry)((List)localObject1).get(j);
      localObject3 = new TroopMemberCard.CustomEntry();
      ((TroopMemberCard.CustomEntry)localObject3).label = ((group_member_info.CustomEntry)localObject2).str_name.get().toStringUtf8();
      ((TroopMemberCard.CustomEntry)localObject3).info = ((group_member_info.CustomEntry)localObject2).str_value.get().toStringUtf8();
      ((TroopMemberCard.CustomEntry)localObject3).linkUrl = ((group_member_info.CustomEntry)localObject2).str_url.get().toStringUtf8();
      ((TroopMemberCard.CustomEntry)localObject3).isClickable = ((group_member_info.CustomEntry)localObject2).bool_clicked.get();
      ((TroopMemberCard.CustomEntry)localObject3).reportId = ((group_member_info.CustomEntry)localObject2).uint64_report_id.get();
      paramTroopMemberCard.customEntryList.add(localObject3);
      j += 1;
    }
    c(paramTroopMemberCard, paramRspBody);
    if (paramRspBody.bytes_phone_num.has()) {
      paramTroopMemberCard.phoneNumber = paramRspBody.bytes_phone_num.get().toStringUtf8();
    }
    a(paramLong, paramTroopMemberCard, paramRspBody);
    if (paramRspBody.bytes_job.has()) {
      paramTroopMemberCard.mPosition = paramRspBody.bytes_job.get().toStringUtf8();
    }
    d(paramTroopMemberCard, paramRspBody);
    e(paramTroopMemberCard, paramRspBody);
    TroopMemberCardHandlerProcessorConfig.a(paramTroopMemberCard, paramLong, paramRspBody);
    a(paramTroopMemberCard, paramRspBody);
    a(paramLong, paramTroopMemberCard);
  }
  
  private boolean a(TroopMemberCard paramTroopMemberCard, int paramInt, TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramInt > 0)
    {
      bool = paramBoolean;
      if (paramInt != paramTroopMemberInfo.level)
      {
        paramTroopMemberInfo.level = paramInt;
        bool = true;
      }
    }
    paramBoolean = bool;
    if (paramTroopMemberCard.nick != null)
    {
      paramBoolean = bool;
      if (!paramTroopMemberCard.nick.equals(paramTroopMemberInfo.friendnick))
      {
        paramTroopMemberInfo.friendnick = paramTroopMemberCard.nick;
        paramBoolean = true;
      }
    }
    bool = paramBoolean;
    if (paramTroopMemberCard.mUniqueTitle != null)
    {
      bool = paramBoolean;
      if (!paramTroopMemberCard.mUniqueTitle.equals(paramTroopMemberInfo.mUniqueTitle))
      {
        paramTroopMemberInfo.mUniqueTitle = paramTroopMemberCard.mUniqueTitle;
        bool = true;
      }
    }
    if (paramTroopMemberCard.realLevel != paramTroopMemberInfo.realLevel)
    {
      paramTroopMemberInfo.realLevel = paramTroopMemberCard.realLevel;
      bool = true;
    }
    if (paramTroopMemberCard.newRealLevel != paramTroopMemberInfo.newRealLevel)
    {
      paramTroopMemberInfo.newRealLevel = paramTroopMemberCard.newRealLevel;
      bool = true;
    }
    if (paramTroopMemberCard.joinTime != paramTroopMemberInfo.join_time)
    {
      paramTroopMemberInfo.join_time = paramTroopMemberCard.joinTime;
      bool = true;
    }
    if (paramTroopMemberCard.lastSpeak != paramTroopMemberInfo.last_active_time)
    {
      paramTroopMemberInfo.last_active_time = paramTroopMemberCard.lastSpeak;
      bool = true;
    }
    if (paramTroopMemberCard.colorCardId != paramTroopMemberInfo.troopColorNickId)
    {
      paramTroopMemberInfo.troopColorNickId = paramTroopMemberCard.colorCardId;
      bool = true;
    }
    return bool;
  }
  
  private boolean a(TroopMemberCard paramTroopMemberCard, TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    String str = paramTroopMemberInfo.troopnick;
    TroopMemberCardHandlerProcessorConfig.a(paramTroopMemberInfo, paramTroopMemberCard);
    boolean bool = paramBoolean;
    if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick))
    {
      bool = paramBoolean;
      if (!paramTroopMemberInfo.equals(str)) {
        bool = true;
      }
    }
    return bool;
  }
  
  private void b(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo.uint32_concern_type.has())
    {
      int i = paramMemberInfo.uint32_concern_type.get();
      if (i == 0)
      {
        paramTroopMemberCard.isConcerned = false;
        paramTroopMemberCard.mIsShield = false;
        return;
      }
      if (i == 1)
      {
        paramTroopMemberCard.isConcerned = true;
        paramTroopMemberCard.mIsShield = false;
        return;
      }
      if (i == 2)
      {
        paramTroopMemberCard.isConcerned = false;
        paramTroopMemberCard.mIsShield = true;
      }
    }
    else
    {
      paramTroopMemberCard.isConcerned = paramMemberInfo.bool_is_concerned.get();
    }
  }
  
  private void c(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if ((paramMemberInfo.bool_location_shared.has()) && (paramMemberInfo.bool_location_shared.get() == true) && (paramMemberInfo.uint64_distance.has()))
    {
      paramTroopMemberCard.distance = paramMemberInfo.uint64_distance.get();
      return;
    }
    if ((paramMemberInfo.bool_location_shared.has()) && (!paramMemberInfo.bool_location_shared.get()))
    {
      paramTroopMemberCard.distance = -1001L;
      return;
    }
    paramTroopMemberCard.distance = -100L;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      notifyUI(TroopObserver.TYPE_MODIFY_TROOPMEMEBER_CARD, false, null);
      return;
    }
    if (paramObject == null)
    {
      notifyUI(TroopObserver.TYPE_MODIFY_TROOPMEMEBER_CARD, false, null);
      return;
    }
    if (paramToServiceMsg == null)
    {
      notifyUI(TroopObserver.TYPE_MODIFY_TROOPMEMEBER_CARD, false, null);
      return;
    }
    paramFromServiceMsg = (ModifyGroupCardResp)paramObject;
    if (paramFromServiceMsg.result != 0)
    {
      paramToServiceMsg = paramFromServiceMsg.ErrorString;
      notifyUI(TroopObserver.TYPE_MODIFY_TROOPMEMEBER_CARD, false, new Object[] { null, paramToServiceMsg });
      return;
    }
    paramFromServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecUinInfo");
    long l = paramToServiceMsg.extraData.getLong("dwGroupCode");
    paramToServiceMsg.extraData.getLong("dwZero");
    paramToServiceMsg.extraData.getLong("dwNewSeq");
    paramToServiceMsg = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).modifyTroopMemberCardInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(l), paramFromServiceMsg);
    notifyUI(TroopObserver.TYPE_MODIFY_TROOPMEMEBER_CARD, true, new Object[] { paramToServiceMsg, "" });
  }
  
  private void d(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo.qqstory_infocard.has())
    {
      paramMemberInfo = (group_member_info.RspGroupCardGetStory)paramMemberInfo.qqstory_infocard.get();
      boolean bool = paramMemberInfo.flag.has();
      int i = 0;
      if (bool)
      {
        int j = paramMemberInfo.flag.get();
        bool = true;
        if (j != 1) {
          bool = false;
        }
        paramTroopMemberCard.mHasStory = bool;
      }
      if (paramMemberInfo.video_info.has())
      {
        paramMemberInfo = paramMemberInfo.video_info.get();
        if (paramMemberInfo.size() > 0)
        {
          paramTroopMemberCard.mStoryInfoList = new ArrayList();
          while (i < paramMemberInfo.size())
          {
            group_member_info.InfoCardVideoInfo localInfoCardVideoInfo = (group_member_info.InfoCardVideoInfo)paramMemberInfo.get(i);
            if (localInfoCardVideoInfo.cover.has())
            {
              TroopMemberCard.StoryInfo localStoryInfo = new TroopMemberCard.StoryInfo();
              localStoryInfo.mCoverUrl = localInfoCardVideoInfo.cover.get().toStringUtf8();
              paramTroopMemberCard.mStoryInfoList.add(localStoryInfo);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  private void e(TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo.msg_game_info.has())
    {
      Object localObject = (group_member_info.MemberGameInfo)paramMemberInfo.msg_game_info.get();
      paramMemberInfo = new TroopMemberCard.MemberGameInfo();
      paramMemberInfo.gameName = ((group_member_info.MemberGameInfo)localObject).str_game_name.get();
      paramMemberInfo.levelName = ((group_member_info.MemberGameInfo)localObject).str_level_name.get();
      paramMemberInfo.levelIcon = ((group_member_info.MemberGameInfo)localObject).str_level_icon.get();
      paramMemberInfo.gameFontColor = ((group_member_info.MemberGameInfo)localObject).str_game_font_color.get();
      paramMemberInfo.gameBackGroundColor = ((group_member_info.MemberGameInfo)localObject).str_game_background_color.get();
      paramMemberInfo.gameUrl = ((group_member_info.MemberGameInfo)localObject).str_game_url.get();
      localObject = ((group_member_info.MemberGameInfo)localObject).str_desc_info.get();
      paramMemberInfo.descInfo = new ArrayList();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramMemberInfo.descInfo.addAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberCardHandler", 2, new Object[] { "desc=", ((List)localObject).get(0) });
        }
      }
      paramTroopMemberCard.mMemberGameInfo = paramMemberInfo;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberCardHandler", 2, new Object[] { "gameInfo, gameName=", paramMemberInfo.gameName, ", levelName=", paramMemberInfo.levelName, ", gameUrl=", paramMemberInfo.gameUrl, ", levelIcon=", paramMemberInfo.levelIcon, ", gameFontColor=", paramMemberInfo.gameFontColor, ", gameBackGroundColor=", paramMemberInfo.gameBackGroundColor });
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("TroopMemberCardHandler", 2, "has no game info");
    }
  }
  
  protected String a()
  {
    return "TroopMemberCardHandler";
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a(paramLong1, paramLong2, false);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "group_member_card.get_group_member_card_info");
    group_member_info.ReqBody localReqBody = new group_member_info.ReqBody();
    localReqBody.uint64_group_code.set(paramLong1);
    localReqBody.uint64_uin.set(paramLong2);
    localReqBody.bool_new_client.set(true);
    localReqBody.uint32_client_type.set(1);
    localReqBody.uint32_rich_card_name_ver.set(1);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).extraData.putBoolean("once", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FriendListHandler.getTroopMemberCard, memberUin: ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" troopCode: ");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("TroopMemberCardHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject != null)
    {
      a(paramFromServiceMsg, (GetTroopAppointRemarkResp)paramObject);
      return;
    }
    notifyUI(TroopObserver.TYPE_GET_TROOPMEMEBER_CARD_LIST, false, null);
  }
  
  public void a(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      if (paramArrayList != null)
      {
        if (paramArrayList.size() == 0) {
          return;
        }
        ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetTroopAppointRemarkReq");
        localToServiceMsg.extraData.putString("GroupUin", paramString1);
        localToServiceMsg.extraData.putString("GroupCode", paramString2);
        localToServiceMsg.extraData.putByte("cRichInfo", (byte)2);
        localToServiceMsg.extraData.putSerializable("vecUinList", paramArrayList);
        send(localToServiceMsg);
      }
    }
  }
  
  public void a(String paramString, ArrayList<TroopMemberCardInfo> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    if ((paramString != null) && (paramArrayList != null))
    {
      if (paramArrayList1 == null) {
        return;
      }
      if (paramArrayList.size() != paramArrayList1.size()) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramArrayList.size())
      {
        TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
        int j = ((Integer)paramArrayList1.get(i)).intValue();
        stUinInfo localstUinInfo = new stUinInfo();
        localstUinInfo.cGender = localTroopMemberCardInfo.sex;
        localstUinInfo.dwuin = Long.parseLong(localTroopMemberCardInfo.memberuin);
        localstUinInfo.sEmail = localTroopMemberCardInfo.email;
        localstUinInfo.sName = localTroopMemberCardInfo.name;
        localstUinInfo.sPhone = localTroopMemberCardInfo.tel;
        localstUinInfo.sRemark = localTroopMemberCardInfo.memo;
        localstUinInfo.dwFlag = j;
        localArrayList.add(localstUinInfo);
        i += 1;
      }
      paramArrayList = createToServiceMsg("friendlist.ModifyGroupCardReq");
      paramArrayList.extraData.putLong("dwZero", 0L);
      paramArrayList.extraData.putLong("dwGroupCode", Long.parseLong(paramString));
      paramArrayList.extraData.putSerializable("vecUinInfo", localArrayList);
      paramArrayList.extraData.putLong("dwNewSeq", 0L);
      send(paramArrayList);
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberCardHandler", 2, "handleGetTroopMemberCard : data==null");
      }
      notifyUI(TroopObserver.TYPE_GET_TROOP_MEMBER_CARD, false, null);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetTroopMemberCard : resp.isSuccess=");
      localStringBuilder.append(paramFromServiceMsg.isSuccess());
      QLog.d("TroopMemberCardHandler", 2, localStringBuilder.toString());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      notifyUI(TroopObserver.TYPE_GET_TROOP_MEMBER_CARD, false, null);
      return;
    }
    paramFromServiceMsg = new group_member_info.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      long l = paramFromServiceMsg.uint64_group_code.get();
      int i = paramFromServiceMsg.uint32_self_role.get();
      paramObject = new TroopMemberCard();
      paramObject.result = -1;
      if (paramFromServiceMsg.uint32_group_type.has()) {
        paramObject.mGroupType = paramFromServiceMsg.uint32_group_type.get();
      }
      if (paramFromServiceMsg.msg_meminfo.has()) {
        a(paramFromServiceMsg, l, paramObject);
      }
      boolean bool = paramToServiceMsg.extraData.getBoolean("once", false);
      notifyUI(TroopObserver.TYPE_GET_TROOP_MEMBER_CARD, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), paramObject, Boolean.valueOf(bool) });
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive: handleGetTroopMemberCard mergeFrom:");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.d("TroopMemberCardHandler", 2, paramFromServiceMsg.toString());
      }
      notifyUI(TroopObserver.TYPE_GET_TROOP_MEMBER_CARD, false, null);
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.ModifyGroupCardReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetTroopAppointRemarkReq");
      this.jdField_a_of_type_JavaUtilSet.add("group_member_card.get_group_member_card_info");
    }
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopMemberCardHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopMemberCardHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("friendlist.ModifyGroupCardReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("friendlist.GetTroopAppointRemarkReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("group_member_card.get_group_member_card_info".equals(paramFromServiceMsg.getServiceCmd())) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberCardHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopMemberCardHandler
 * JD-Core Version:    0.7.0.1
 */