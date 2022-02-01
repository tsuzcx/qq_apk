package com.tencent.mobileqq.service.message;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.GVideoHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.TroopStatusUtil;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.troop.troopmemberlevel.api.ITroopMemberLevelHandler;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.NamePlateVipTpye;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import gxh_message.Dialogue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.oidb.cmd0x787.oidb_0x787.MsgNeedField;

public class TroopHotChatTopicHandler
  extends BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler
{
  private AppInterface a;
  
  public TroopHotChatTopicHandler(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<im_msg_body.Elem> paramList, byte paramByte, String paramString)
  {
    super(paramArrayList, paramPBDecodeContext, paramBoolean, paramMsgHead, paramLong1, paramLong2, paramLong3, paramLong4, paramList, paramByte, paramString);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private int a(int paramInt, long paramLong, generalflags.ResvAttr paramResvAttr)
  {
    int i = paramInt;
    if (paramResvAttr.uint32_title_id.has())
    {
      int j = paramResvAttr.uint32_title_id.get();
      if (j > 0) {
        paramInt = j;
      }
      i = paramInt;
      if (QLog.isColorLevel())
      {
        paramResvAttr = new StringBuilder();
        paramResvAttr.append("decodeSinglePbMsg_GroupDis, titleId=");
        paramResvAttr.append(j);
        paramResvAttr.append(", troopUin=");
        paramResvAttr.append(paramLong);
        paramResvAttr.append(", sender=");
        paramResvAttr.append(this.jdField_a_of_type_Long);
        paramResvAttr.append(", msgTime=");
        paramResvAttr.append(this.jdField_c_of_type_Long);
        paramResvAttr.append(", isSaveDb=");
        paramResvAttr.append(this.jdField_a_of_type_Boolean);
        QLog.d("TroopRankConfig", 2, paramResvAttr.toString());
        i = paramInt;
      }
    }
    return i;
  }
  
  private int a(int paramInt, long paramLong, im_msg_body.Elem paramElem)
  {
    int i = paramInt;
    if (paramElem.general_flags.bytes_pb_reserve.has())
    {
      generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
      localResvAttr.mergeFrom(paramElem.general_flags.bytes_pb_reserve.get().toByteArray());
      if (localResvAttr.uint32_rich_card_name_ver.has()) {
        localResvAttr.uint32_rich_card_name_ver.get();
      }
      if (localResvAttr.uint32_nearby_charm_level.has()) {
        i = localResvAttr.uint32_nearby_charm_level.get();
      } else {
        i = -100;
      }
      int j;
      if (localResvAttr.uint32_global_group_level.has()) {
        j = localResvAttr.uint32_global_group_level.get();
      } else {
        j = -100;
      }
      boolean bool = localResvAttr.uint32_vip_type.has();
      int m = 0;
      int k;
      if (bool) {
        k = localResvAttr.uint32_vip_type.get();
      } else {
        k = 0;
      }
      this.jdField_a_of_type_Int = k;
      if (localResvAttr.uint32_vip_level.has()) {
        k = localResvAttr.uint32_vip_level.get();
      } else {
        k = 0;
      }
      this.jdField_b_of_type_Int = VipUtils.c(k);
      if (localResvAttr.uint32_user_bigclub_flag.has()) {
        this.jdField_c_of_type_Int = localResvAttr.uint32_user_bigclub_flag.get();
      }
      if (localResvAttr.uint32_user_bigclub_level.has()) {
        this.jdField_d_of_type_Int = localResvAttr.uint32_user_bigclub_level.get();
      }
      if (localResvAttr.uint32_nameplate.has()) {
        this.e = localResvAttr.uint32_nameplate.get();
      }
      if (localResvAttr.bytes_user_vip_info.has())
      {
        paramElem = new Dialogue();
        paramElem.mergeFrom(localResvAttr.bytes_user_vip_info.get().toByteArray());
        k = m;
        if (paramElem.short_nameplate_itemid.has()) {
          k = paramElem.short_nameplate_itemid.get();
        }
        this.f = k;
        this.i = paramElem.diyfontid.get();
      }
      a(paramLong, localResvAttr);
      a(localResvAttr);
      if (QLog.isColorLevel())
      {
        paramElem = new StringBuilder();
        paramElem.append("isHideBigClub=");
        paramElem.append(this.g);
        QLog.d("kaiyan", 2, paramElem.toString());
      }
      paramInt = a(paramInt, paramLong, localResvAttr);
      paramElem = a(paramLong, i, j, localResvAttr);
      a(this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext, paramLong, localResvAttr, paramElem);
      if (localResvAttr.bytes_hudong_mark.has()) {
        paramElem = localResvAttr.bytes_hudong_mark.get().toByteArray();
      } else {
        paramElem = null;
      }
      String str = TroopHonorUtils.a(paramElem);
      ((ITroopHonorService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopHonorService.class, "")).updateTroopMemberHonor(String.valueOf(paramLong), String.valueOf(this.jdField_a_of_type_Long), str, (byte)localResvAttr.uint32_group_rich_flag.get(), this.jdField_c_of_type_Long);
      this.h = TroopMemberLevelUtils.a(paramElem);
      i = paramInt;
    }
    return i;
  }
  
  private int a(int paramInt, im_msg_body.Elem paramElem)
  {
    if (paramElem.general_flags.uint32_glamour_level.has()) {
      paramInt = paramElem.general_flags.uint32_glamour_level.get();
    }
    return paramInt;
  }
  
  @Nullable
  private TroopManager a(long paramLong, int paramInt1, int paramInt2, generalflags.ResvAttr paramResvAttr)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext.f == 1) && (paramResvAttr.uint32_group_member_flag_ex2.has()))
    {
      i = paramResvAttr.uint32_group_member_flag_ex2.get();
      TroopStatusUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong, i);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext.f == 1) && (paramResvAttr.uint32_group_ringtone_id.has()) && (paramResvAttr.uint32_group_ringtone_id.get() > 0))
    {
      i = paramResvAttr.uint32_group_ringtone_id.get();
      TroopStatusUtil.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong, i);
    }
    paramResvAttr = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramResvAttr != null)
    {
      long l = this.jdField_a_of_type_Long;
      ((IBizTroopMemberInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).saveTroopMemberHotChatGlamourLevel(String.valueOf(paramLong), String.valueOf(l), paramInt1, paramInt2);
    }
    return paramResvAttr;
  }
  
  private IConversationFacade a()
  {
    return (IConversationFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IConversationFacade.class, "");
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_b_of_type_Boolean) {
      ((HotChatManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramLong);
    }
  }
  
  private void a(long paramLong, String paramString, TroopManager paramTroopManager, TroopInfo paramTroopInfo)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramTroopInfo == null))
    {
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder();
        paramTroopInfo.append("decodeSinglePbMsg_GroupDis: troopUin=");
        paramTroopInfo.append(paramLong);
        paramTroopInfo.append(", memberUin=");
        paramTroopInfo.append(this.jdField_a_of_type_Long);
        paramTroopInfo.append(" troopinfo is null, getGroupInfoReq ");
        QLog.d("TroopHotChatTopicHandler", 2, paramTroopInfo.toString());
      }
      paramTroopInfo = new TroopInfo();
      paramTroopInfo.troopuin = paramString;
      paramTroopManager.b(paramTroopInfo);
      ((TroopInfoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(paramString);
    }
  }
  
  private void a(long paramLong, generalflags.ResvAttr paramResvAttr)
  {
    Object localObject1;
    Object localObject2;
    if (paramResvAttr.uint32_kings_honor_level.has())
    {
      localObject1 = (ITroopGameCardService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopGameCardService.class, "");
      if (localObject1 != null)
      {
        localObject2 = new MemberGradeLevelInfo();
        ((MemberGradeLevelInfo)localObject2).memberuin = String.valueOf(this.jdField_a_of_type_Long);
        ((MemberGradeLevelInfo)localObject2).gradeLevel = (paramResvAttr.uint32_kings_honor_level.get() * 10000);
        ((ITroopGameCardService)localObject1).saveMemberGradeLevelInfo((MemberGradeLevelInfo)localObject2);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("TroopHotChatTopicHandler", 2, "kings_honor_level is null");
    }
    if ((paramResvAttr.uint32_group_info_flag_ex4.has()) || (paramResvAttr.bytes_group_msg_busi_buf.has()))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramResvAttr.uint32_group_info_flag_ex4.has())
      {
        localObject2 = ((TroopManager)localObject1).c(String.valueOf(paramLong));
        ((TroopInfo)localObject2).groupFlagExt4 |= paramResvAttr.uint32_group_info_flag_ex4.get();
        ((TroopManager)localObject1).b((TroopInfo)localObject2);
      }
      if (paramResvAttr.bytes_group_msg_busi_buf.has())
      {
        localObject2 = new oidb_0x787.MsgNeedField();
        try
        {
          ((oidb_0x787.MsgNeedField)localObject2).mergeFrom(paramResvAttr.bytes_group_msg_busi_buf.get().toByteArray());
          if (((oidb_0x787.MsgNeedField)localObject2).uint32_cmduin_flagex3_grocery.has())
          {
            ((TroopManager)localObject1).b(String.valueOf(paramLong), String.valueOf(this.jdField_a_of_type_Long), ((oidb_0x787.MsgNeedField)localObject2).uint32_cmduin_flagex3_grocery.get());
            return;
          }
        }
        catch (Exception paramResvAttr)
        {
          paramResvAttr.printStackTrace();
        }
      }
    }
  }
  
  private void a(long paramLong1, boolean paramBoolean, long paramLong2, im_msg_body.Elem paramElem)
  {
    if (paramBoolean)
    {
      int i = paramElem.extra_info.uint32_flags.get();
      if (QLog.isColorLevel())
      {
        paramElem = new StringBuilder();
        paramElem.append("elem.extra_info.uint32_flags:");
        paramElem.append(i);
        paramElem.append("|groupCode:");
        paramElem.append(paramLong2);
        paramElem.append("fromUin:");
        paramElem.append(paramLong1);
        QLog.d("TroopHotChatTopicHandler", 2, paramElem.toString());
      }
      if ((i & 0x10) == 16)
      {
        paramElem = (HotChatManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramLong2);
        ((StringBuilder)localObject).append("");
        paramElem = paramElem.a(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramLong1);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        if ((paramElem != null) && (!paramElem.adminUins.contains(localObject))) {
          paramElem.adminUins.add(localObject);
        }
      }
    }
  }
  
  private void a(PBDecodeContext paramPBDecodeContext, long paramLong, generalflags.ResvAttr paramResvAttr, TroopManager paramTroopManager)
  {
    if ((paramPBDecodeContext.f == 1) && (paramResvAttr.uint32_custom_featureid.has()) && (paramTroopManager != null) && (paramResvAttr.uint32_custom_featureid.get() == 19713))
    {
      if (QLog.isColorLevel())
      {
        paramPBDecodeContext = new StringBuilder();
        paramPBDecodeContext.append("decodeSinglePbMsg_GroupDis, hasPrivateTroopFlag, troopUin=");
        paramPBDecodeContext.append(paramLong);
        QLog.d(".troop.qidian_private_troop", 2, paramPBDecodeContext.toString());
      }
      paramPBDecodeContext = paramTroopManager.b(String.valueOf(paramLong));
      if ((paramPBDecodeContext != null) && (!paramPBDecodeContext.isQidianPrivateTroop()))
      {
        paramPBDecodeContext.setQidianPrivateTroopFlag();
        paramTroopManager.b(paramPBDecodeContext);
        if (QLog.isColorLevel())
        {
          paramPBDecodeContext = new StringBuilder();
          paramPBDecodeContext.append("set privateTroop flag, troopUin=");
          paramPBDecodeContext.append(paramLong);
          QLog.d(".troop.qidian_private_troop", 2, paramPBDecodeContext.toString());
        }
      }
    }
  }
  
  private void a(PBDecodeContext paramPBDecodeContext, long paramLong, im_msg_body.Elem paramElem)
  {
    if ((paramPBDecodeContext.f == 1) && (paramElem.general_flags.uint64_group_rank_seq.has()))
    {
      paramPBDecodeContext = String.valueOf(paramLong);
      boolean bool = a().isSyncMsgFinish();
      if (bool)
      {
        TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramPBDecodeContext);
        if (localTroopInfo != null)
        {
          paramLong = paramElem.general_flags.uint64_group_rank_seq.get();
          if (QLog.isColorLevel())
          {
            paramElem = new StringBuilder();
            paramElem.append("onNewMsg: troopUin=");
            paramElem.append(paramPBDecodeContext);
            paramElem.append(", serverRankSeq=");
            paramElem.append(paramLong);
            paramElem.append(", localRankSeq=");
            paramElem.append(localTroopInfo.dwGroupLevelSeq);
            paramElem.append(", isSyncMsgFinish=");
            paramElem.append(bool);
            QLog.d("Q.getTroopMemberLevelInfo", 2, paramElem.toString());
          }
          if (paramLong > localTroopInfo.dwGroupLevelSeq) {
            ((ITroopMemberLevelHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LEVEL_HANDLER)).a(paramPBDecodeContext, false);
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        paramElem = new StringBuilder();
        paramElem.append("onNewMsg: troopUin=");
        paramElem.append(paramPBDecodeContext);
        paramElem.append(", isSyncMsgFinish=");
        paramElem.append(bool);
        QLog.d("Q.getTroopMemberLevelInfo", 2, paramElem.toString());
      }
    }
  }
  
  private void a(String paramString, TroopBindPublicAccountMgr paramTroopBindPublicAccountMgr)
  {
    if (paramTroopBindPublicAccountMgr.b(paramString))
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int i = 0;
      int k = j - 1;
      while (k >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        j = i;
        if (TroopBindPublicAccountMgr.a(localMessageRecord)) {
          if ((TextUtils.isEmpty(localMessageRecord.msg)) && (localMessageRecord.msgData == null))
          {
            j = i;
          }
          else
          {
            j = i;
            if (i == 0)
            {
              paramTroopBindPublicAccountMgr.a(paramString, localMessageRecord.uniseq);
              j = 1;
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("decodePBAccountMSg:");
              localStringBuilder.append(paramString);
              localStringBuilder.append(",");
              localStringBuilder.append(localMessageRecord.uniseq);
              localStringBuilder.append(",");
              localStringBuilder.append(localMessageRecord.shmsgseq);
              QLog.d("TroopBindPublicAccountMgr.redDot", 2, localStringBuilder.toString());
            }
            paramTroopBindPublicAccountMgr.c(paramString);
          }
        }
        k -= 1;
        i = j;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
    {
      paramString2 = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
      if (!paramString2.a(paramString1))
      {
        a(paramString1, paramString2);
        if (a().getTroopMask(paramString1) == 3)
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("Shield troop recv msg:");
            paramString2.append(paramString1);
            QLog.d(".troop.closeRcvMsgTmp", 2, paramString2.toString());
          }
          ((ITroopSettingHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER)).a(paramString1, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0, 0);
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((MessageRecord)paramArrayList.next()).isOpenTroopMessage = true;
      }
      paramArrayList = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((paramArrayList != null) && (!paramArrayList.e(paramString)))
      {
        paramArrayList = (GVideoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.GVIDEO_HANDLER);
        if (paramArrayList != null) {
          paramArrayList.a(paramString, false);
        }
      }
    }
  }
  
  private void a(generalflags.ResvAttr paramResvAttr)
  {
    if ((this.jdField_c_of_type_Int != 0) && (paramResvAttr.uint32_nameplate_vip_type.has()) && (paramResvAttr.uint32_gray_name_plate.has()))
    {
      int i = paramResvAttr.uint32_nameplate_vip_type.get();
      VipUtils.VipIconUtils.NamePlateVipTpye localNamePlateVipTpye = VipUtils.VipIconUtils.NamePlateVipTpye.a(i);
      if ((VipUtils.VipIconUtils.a(i)) && (!localNamePlateVipTpye.b())) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramResvAttr.uint32_gray_name_plate.get() != 0) || (i != 0)) {
        this.g = 1;
      }
      if ((this.jdField_c_of_type_Int == 3) && (!localNamePlateVipTpye.c())) {
        this.jdField_c_of_type_Int = 1;
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, double paramDouble, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3, int paramInt5, int paramInt6)
  {
    if ((!paramBoolean) || (this.jdField_b_of_type_Boolean))
    {
      if (paramInt1 != -100) {
        ((IBizTroopMemberInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).saveTroopMemberGlamourLevel(paramString1, paramString2, paramInt1);
      }
      boolean bool = this.jdField_a_of_type_Boolean;
      paramBoolean = true;
      if (bool)
      {
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramInt5 != 1)
        {
          if (paramInt5 != 2) {
            localTroopManager.a(paramString1, paramString2, paramString3, paramInt3, null, null, paramByte1, paramByte2, paramInt2, this.jdField_b_of_type_Long, this.jdField_a_of_type_Byte, 0L, paramDouble, null, -100, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.g, paramInt6);
          } else {
            localTroopManager.a(paramString1, paramString2, "", paramInt3, paramString3, null, paramByte1, paramByte2, paramInt2, this.jdField_b_of_type_Long, this.jdField_a_of_type_Byte, 0L, paramDouble, null, -100, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.g, paramInt6);
          }
        }
        else {
          localTroopManager.a(paramString1, paramString2, paramString3, paramInt3, null, null, paramByte1, paramByte2, paramInt2, this.jdField_b_of_type_Long, this.jdField_a_of_type_Byte, 0L, paramDouble, null, -100, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.g, paramInt6);
        }
        localTroopManager.a(paramString1, paramString2, this.jdField_a_of_type_JavaLangString, paramInt4, this.h);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = new TroopMemberInfo();
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.newRealLevel = this.h;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin = paramString2;
      if (paramInt5 != 2)
      {
        paramString1 = ColorNickManager.b(paramString3);
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopColorNick = paramString3;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick = paramString1;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopColorNickId = paramInt6;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick = "";
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick = paramString3;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopColorNickId = paramInt6;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.level = paramInt3;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.realLevel = paramInt4;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.sex = paramByte2;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.age = paramByte1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.distance = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.msgseq = this.jdField_b_of_type_Long;
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
      if (this.jdField_a_of_type_Byte != 1) {
        paramBoolean = false;
      }
      paramString1.isTroopFollowed = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.distanceToSelf = paramDouble;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
    }
  }
  
  private boolean a(im_msg_body.Elem paramElem)
  {
    if (QLog.isColorLevel())
    {
      String str = null;
      if (((im_msg_body.PubGroup)paramElem.pub_group.get()).bytes_nickname.has()) {
        str = ((im_msg_body.PubGroup)paramElem.pub_group.get()).bytes_nickname.get().toStringUtf8();
      }
      paramElem = new StringBuilder();
      paramElem.append("decodeSinglePbMsg_GroupDis,receive  pub_group,bytes_nickname = ");
      paramElem.append(str);
      QLog.d("TroopHotChatTopicHandler", 2, paramElem.toString());
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean, im_msg_body.Elem paramElem)
  {
    boolean bool = paramBoolean;
    if (paramElem.general_flags.uint32_group_type.has())
    {
      int i = paramElem.general_flags.uint32_group_type.get();
      bool = true;
      if (i != 1)
      {
        if (i == 2) {
          this.jdField_b_of_type_Boolean = true;
        }
      }
      else if (paramElem.general_flags.uint32_to_uin_flag.has()) {
        if (paramElem.general_flags.uint32_to_uin_flag.get() == 2) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
      }
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        paramElem = new StringBuilder();
        paramElem.append("decodeSinglePbMsg_GroupDis,receive general_flags.uint32_group_type, isPubGroupVisitor = ");
        paramElem.append(paramBoolean);
        paramElem.append(", isHotChatMsg = ");
        paramElem.append(this.jdField_b_of_type_Boolean);
        QLog.d("TroopHotChatTopicHandler", 2, paramElem.toString());
        bool = paramBoolean;
      }
    }
    return bool;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHotChatTopicHandler", 2, "handleBusiness");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext.f != 1) && (this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext.f != 1026)) {
      return;
    }
    long l = 0L;
    msg_comm.GroupInfo localGroupInfo = (msg_comm.GroupInfo)this.jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead.group_info.get();
    if (localGroupInfo != null) {
      l = localGroupInfo.group_code.get();
    }
    double d1;
    boolean bool2;
    int i;
    int j;
    boolean bool1;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      d1 = -100.0D;
      bool2 = false;
      i = -1;
      j = -100;
      bool1 = false;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
        if (((im_msg_body.Elem)localObject2).general_flags.has())
        {
          bool2 = a(bool2, (im_msg_body.Elem)localObject2);
          j = a(j, (im_msg_body.Elem)localObject2);
          try
          {
            k = a(i, l, (im_msg_body.Elem)localObject2);
            i = k;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
          a(this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext, l, (im_msg_body.Elem)localObject2);
        }
        else
        {
          double d2;
          boolean bool3;
          if ((((im_msg_body.Elem)localObject2).extra_info.has()) && (((im_msg_body.Elem)localObject2).extra_info.uint32_flags.has()))
          {
            a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Boolean, l, (im_msg_body.Elem)localObject2);
            d2 = d1;
            bool3 = bool1;
          }
          else if (((im_msg_body.Elem)localObject2).pub_group.has())
          {
            bool3 = a((im_msg_body.Elem)localObject2);
            d2 = d1;
          }
          else
          {
            d2 = d1;
            bool3 = bool1;
            if (((im_msg_body.Elem)localObject2).elem_flags2.has())
            {
              d2 = d1;
              bool3 = bool1;
              if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint32_longtitude.has())
              {
                d2 = d1;
                bool3 = bool1;
                if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint32_latitude.has())
                {
                  if (this.jdField_d_of_type_Long != this.jdField_a_of_type_Long) {
                    break label376;
                  }
                  bool3 = bool1;
                  d2 = d1;
                }
              }
            }
          }
          for (;;)
          {
            d1 = d2;
            bool1 = bool3;
            break;
            label376:
            d2 = -1001.0D;
            bool3 = bool1;
          }
        }
      }
    }
    else
    {
      d1 = -100.0D;
      bool2 = false;
      i = -1;
      j = -100;
      bool1 = false;
    }
    Object localObject1 = String.valueOf(l);
    Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject3 = ((TroopManager)localObject2).b((String)localObject1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeSinglePbMsg_GroupDis: troopUin=");
      localStringBuilder.append(l);
      localStringBuilder.append(", memberUin=");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("，isHotChatMsg = ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(",ti = ");
      localStringBuilder.append(localObject3);
      QLog.d("TroopHotChatTopicHandler", 2, localStringBuilder.toString());
    }
    a(l, (String)localObject1, (TroopManager)localObject2, (TroopInfo)localObject3);
    localObject2 = String.valueOf(this.jdField_a_of_type_Long);
    int k = localGroupInfo.group_level.get();
    localObject3 = ColorNickManager.a(localGroupInfo.group_card.get());
    int m = ColorNickManager.a(localGroupInfo.group_card.get().toByteArray());
    int n = localGroupInfo.group_card_type.get();
    a(l);
    a(this.jdField_a_of_type_JavaUtilArrayList, bool2, (String)localObject1);
    a(bool1, j, (byte)0, (byte)1, 100, d1, i, (String)localObject1, (String)localObject2, k, (String)localObject3, n, m);
    a((String)localObject1, (String)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.TroopHotChatTopicHandler
 * JD-Core Version:    0.7.0.1
 */