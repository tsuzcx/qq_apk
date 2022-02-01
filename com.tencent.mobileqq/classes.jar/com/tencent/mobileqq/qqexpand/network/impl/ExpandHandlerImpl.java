package com.tencent.mobileqq.qqexpand.network.impl;

import QC.ExtendFriend;
import QC.UniBusinessItem;
import QC.UniSetExtFriendReq;
import QC.UniSetExtFriendRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo;
import com.tencent.mobileqq.qqexpand.bean.chat.SchoolInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo.LabelInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo.SchoolInfo;
import com.tencent.mobileqq.qqexpand.bean.match.ExtendFriendLocationInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.match.PersonalTag;
import com.tencent.mobileqq.qqexpand.bean.match.TagInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.match.MatchNotifyInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.adv.extfriend.api.IVasAdExtendFriendApi;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.GPS;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.LBSInfo;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.ReqBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.ReqBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.labelInfo;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.schoolInfo;
import com.tencent.pb.personal.PersonalInfo.ReqBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.ReqBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.RspBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.SchoolInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import tencent.im.oidb.cmd0xcb5.cmd0xcb5.ReqBody;
import tencent.im.oidb.cmd0xcb5.cmd0xcb5.RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.ReqBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.GPS;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.LBSInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchUinData;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.ProfileTagInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.ReqBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.TagInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03.schoolInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.OnlineInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.ReqBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.RspBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09.reqItem;
import tencent.im.oidb.cmd0xe52.oidb_0xe52.RspBody;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.GPS;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.LBSInfo;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.ReqBody;
import tencent.im.oidb.cmd0xe67.oidb_0xe67.RspBody;
import tencent.im.oidb.cmd0xeae.oidb_0xeae.ReqBody;
import tencent.im.oidb.cmd0xeae.oidb_0xeae.RspBody;
import tencent.im.oidb.oidb_0xe51.ReqBody;
import tencent.im.oidb.oidb_0xe51.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x128.submsgtype0x128.MsgBody;

public class ExpandHandlerImpl
  extends BusinessHandler
  implements IExpandHandler
{
  public static AtomicInteger a;
  private final AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public ExpandHandlerImpl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
  }
  
  private int a(int paramInt)
  {
    int i = 11;
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("un known op type");
      localStringBuilder.append(paramInt);
      QLog.e("ExpandHandlerImpl", 2, localStringBuilder.toString());
      return 11;
    case 7: 
      return 25;
    case 6: 
      return 24;
    case 5: 
      return 15;
    case 4: 
      return 14;
    case 3: 
      return 13;
    case 2: 
      i = 12;
    }
    return i;
  }
  
  private long a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "unknown";
    }
    try
    {
      long l = Long.parseLong(paramString1);
      return l;
    }
    catch (NumberFormatException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append(str);
      paramString2.append(" parse err ");
      paramString2.append(paramString1.toString());
      QLog.e("ExpandHandlerImpl", 2, paramString2.toString());
    }
    return 0L;
  }
  
  private Card a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExpandHandlerImpl", 1, "saveExtendFriendInfo uin is null");
      return null;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localFriendsManager.b(paramString1);
    localCard.declaration = paramString2;
    localCard.voiceUrl = paramString3;
    if (paramInt1 != 0) {
      localCard.popularity = paramInt1;
    }
    localCard.updateTime = paramLong;
    localCard.extendFriendVoiceDuration = paramInt2;
    localFriendsManager.a(localCard);
    QLog.e("ExpandHandlerImpl", 1, new Object[] { "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d", paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    return localCard;
  }
  
  private Card a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString4, String paramString5, long paramLong2, int paramInt6, int paramInt7)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExpandHandlerImpl", 1, "saveExtendFriendInfo uin is null");
      return null;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localFriendsManager.b(paramString1);
    localCard.declaration = paramString2;
    localCard.voiceUrl = paramString3;
    localCard.fontId = paramInt3;
    localCard.fontType = paramInt4;
    localCard.clothesId = paramInt5;
    if (paramInt1 != 0) {
      localCard.popularity = paramInt1;
    }
    localCard.updateTime = paramLong1;
    localCard.extendFriendVoiceDuration = paramInt2;
    if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5)))
    {
      localCard.schoolName = paramString5;
      localCard.schoolId = paramString4;
      localCard.authState = paramLong2;
      localCard.idx = paramInt6;
      localCard.category = paramInt7;
    }
    else
    {
      localCard.schoolName = "";
      localCard.schoolId = "";
      localCard.authState = -1L;
      localCard.idx = -1;
      localCard.category = -1;
    }
    localFriendsManager.a(localCard);
    QLog.e("ExpandHandlerImpl", 1, new Object[] { "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d schoolId=%s schoolName=%s authState=%d idx=%d category=%d", paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString4, paramString5, Long.valueOf(paramLong2), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7) });
    return localCard;
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, oidb_0xdb1.RspBody paramRspBody)
  {
    int i = (int)paramRspBody.uint64_black_times.get();
    int j = (int)paramRspBody.uint64_be_blacked_times.get();
    long l = paramRspBody.uint64_left_punish_time.get();
    String str1 = paramRspBody.str_black_times_tips.get();
    String str2 = paramRspBody.str_black_times_used_up_tips.get();
    String str3 = paramRspBody.str_black_times_used_up_title.get();
    String str4 = paramRspBody.str_be_black_tips.get();
    String str5 = paramRspBody.str_punish_tips.get();
    boolean bool;
    if (paramRspBody.uint32_show_gray_tips.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
    a(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l), str1, str2, str3, str4, str5, Boolean.valueOf(bool) }, paramFromServiceMsg);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, oidb_0xe03.RspBody paramRspBody)
  {
    int i = (int)paramRspBody.uint64_black_times.get();
    int j = (int)paramRspBody.uint64_be_blacked_times.get();
    long l = paramRspBody.uint64_left_punish_time.get();
    String str1 = paramRspBody.str_black_times_tips.get();
    String str2 = paramRspBody.str_black_times_used_up_tips.get();
    String str3 = paramRspBody.str_black_times_used_up_title.get();
    String str4 = paramRspBody.str_be_black_tips.get();
    boolean bool;
    if (paramRspBody.uint32_show_gray_tips.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
    a(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l), str1, str2, str3, str4, null, Boolean.valueOf(bool) }, paramFromServiceMsg);
  }
  
  private void a(oidb_0xe03.MatchUinData paramMatchUinData, ChatFriendInfo paramChatFriendInfo)
  {
    if ((paramMatchUinData != null) && (paramChatFriendInfo != null))
    {
      boolean bool = paramMatchUinData.uint32_age.has();
      String str = "";
      if (bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramMatchUinData.uint32_age.get());
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      paramChatFriendInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
      if (paramMatchUinData.bytes_constellation.has()) {
        localObject1 = paramMatchUinData.bytes_constellation.get().toStringUtf8();
      } else {
        localObject1 = "";
      }
      paramChatFriendInfo.jdField_c_of_type_JavaLangString = ((String)localObject1);
      if (paramMatchUinData.bytes_city.has()) {
        localObject1 = paramMatchUinData.bytes_city.get().toStringUtf8();
      } else {
        localObject1 = "";
      }
      paramChatFriendInfo.d = ((String)localObject1);
      if (paramMatchUinData.bytes_school.has()) {
        localObject1 = paramMatchUinData.bytes_school.get().toStringUtf8();
      } else {
        localObject1 = "";
      }
      paramChatFriendInfo.e = ((String)localObject1);
      if (paramMatchUinData.bytes_company.has()) {
        localObject1 = paramMatchUinData.bytes_company.get().toStringUtf8();
      } else {
        localObject1 = "";
      }
      paramChatFriendInfo.jdField_f_of_type_JavaLangString = ((String)localObject1);
      if (paramMatchUinData.bytes_declaration.has()) {
        localObject1 = paramMatchUinData.bytes_declaration.get().toStringUtf8();
      } else {
        localObject1 = "";
      }
      paramChatFriendInfo.jdField_g_of_type_JavaLangString = ((String)localObject1);
      if (paramMatchUinData.bytes_voice_url.has()) {
        localObject1 = paramMatchUinData.bytes_voice_url.get().toStringUtf8();
      } else {
        localObject1 = "";
      }
      paramChatFriendInfo.h = ((String)localObject1);
      bool = paramMatchUinData.uint32_voice_duration.has();
      int j = 0;
      if (bool) {
        i = paramMatchUinData.uint32_voice_duration.get();
      } else {
        i = 0;
      }
      paramChatFriendInfo.jdField_b_of_type_Int = i;
      if (paramMatchUinData.bytes_long_nick.has()) {
        localObject1 = paramMatchUinData.bytes_long_nick.get().toByteArray();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        paramChatFriendInfo.i = RichStatus.parseStatus((byte[])localObject1).getPlainText();
      }
      if (paramMatchUinData.uint32_sex.has())
      {
        paramChatFriendInfo.jdField_a_of_type_Int = paramMatchUinData.uint32_sex.get();
      }
      else
      {
        paramChatFriendInfo.jdField_a_of_type_Int = 0;
        QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, "mGender  is null. set 0  ");
      }
      long l;
      if (paramMatchUinData.uint32_popularity.has()) {
        l = paramMatchUinData.uint32_popularity.get();
      } else {
        l = 0L;
      }
      paramChatFriendInfo.jdField_a_of_type_Long = l;
      Object localObject1 = new ArrayList();
      Object localObject2;
      Object localObject3;
      if (paramMatchUinData.rpt_school_info.has())
      {
        i = 0;
        while (i < paramMatchUinData.rpt_school_info.size())
        {
          if (((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).str_school_name.has())
          {
            localObject2 = new SchoolInfo(((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).str_school_id.get(), ((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).str_school_name.get(), ((oidb_0xe03.schoolInfo)paramMatchUinData.rpt_school_info.get(i)).uint64_state.get());
            ((ArrayList)localObject1).add(localObject2);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("schoolInfo. ");
              ((StringBuilder)localObject3).append(((SchoolInfo)localObject2).toString());
              QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject3).toString());
            }
          }
          i += 1;
        }
      }
      paramChatFriendInfo.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      localObject1 = new ArrayList();
      if (paramMatchUinData.rpt_tag.has())
      {
        i = j;
        while (i < paramMatchUinData.rpt_tag.size())
        {
          if (((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).bytes_tag.has())
          {
            j = ((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).uint32_same_flag.get();
            localObject2 = ((oidb_0xe03.ProfileTagInfo)paramMatchUinData.rpt_tag.get(i)).bytes_tag.get().toStringUtf8();
            localObject3 = new PersonalTag();
            ((PersonalTag)localObject3).jdField_a_of_type_Int = j;
            ((PersonalTag)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((ArrayList)localObject1).add(localObject3);
          }
          i += 1;
        }
      }
      paramChatFriendInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
      bool = paramMatchUinData.uint32_distance.has();
      j = -1;
      if (bool) {
        i = paramMatchUinData.uint32_distance.get();
      } else {
        i = -1;
      }
      paramChatFriendInfo.jdField_f_of_type_Int = i;
      int i = j;
      if (paramMatchUinData.uint32_match_pool.has()) {
        i = paramMatchUinData.uint32_match_pool.get();
      }
      paramChatFriendInfo.jdField_g_of_type_Int = i;
      if (paramMatchUinData.str_from_city_name.has()) {
        localObject1 = paramMatchUinData.str_from_city_name.get();
      } else {
        localObject1 = "";
      }
      paramChatFriendInfo.j = ((String)localObject1);
      localObject1 = str;
      if (paramMatchUinData.str_to_city_name.has()) {
        localObject1 = paramMatchUinData.str_to_city_name.get();
      }
      paramChatFriendInfo.k = ((String)localObject1);
      if (QLog.isColorLevel())
      {
        paramMatchUinData = new StringBuilder();
        paramMatchUinData.append("ChatFriendInfo. ");
        paramMatchUinData.append(paramChatFriendInfo.toString());
        QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, paramMatchUinData.toString());
      }
      return;
    }
    QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, "msg_match_uin_data || info is null. ");
  }
  
  private void a(Object[] paramArrayOfObject, String paramString)
  {
    if (((paramArrayOfObject instanceof Object[])) && (paramArrayOfObject.length == 9))
    {
      int i = ((Integer)paramArrayOfObject[0]).intValue();
      int j = ((Integer)paramArrayOfObject[1]).intValue();
      long l = ((Long)paramArrayOfObject[2]).longValue();
      String str1 = (String)paramArrayOfObject[3];
      String str2 = (String)paramArrayOfObject[4];
      String str3 = (String)paramArrayOfObject[5];
      String str4 = (String)paramArrayOfObject[6];
      String str5 = (String)paramArrayOfObject[7];
      boolean bool = ((Boolean)paramArrayOfObject[8]).booleanValue();
      paramArrayOfObject = ColdPalaceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramArrayOfObject.a(i);
      paramArrayOfObject.b(j);
      paramArrayOfObject.a(l, NetConnInfoCenter.getServerTime());
      paramArrayOfObject.a(bool);
      paramArrayOfObject.a(0, str1);
      paramArrayOfObject.a(2, str2);
      paramArrayOfObject.a(1, str3);
      paramArrayOfObject.a(3, str4);
      if (str5 != null) {
        paramArrayOfObject.a(4, str5);
      }
      paramArrayOfObject = new StringBuilder("onGetColdPalaceData");
      paramArrayOfObject.append(" ");
      paramArrayOfObject.append("from");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(paramString);
      paramArrayOfObject.append("[\n");
      paramArrayOfObject.append("showGrayTipEntry");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(bool);
      paramArrayOfObject.append("|");
      paramArrayOfObject.append("\n");
      paramArrayOfObject.append("skillTimesLeft");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(i);
      paramArrayOfObject.append("|");
      paramArrayOfObject.append("\n");
      paramArrayOfObject.append("meInColdPalaceTimes");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(j);
      paramArrayOfObject.append("|");
      paramArrayOfObject.append("\n");
      paramArrayOfObject.append("punishLeftTime");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(l);
      paramArrayOfObject.append("|");
      paramArrayOfObject.append("\n");
      paramArrayOfObject.append("strSkillUseTip");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(str1);
      paramArrayOfObject.append("|");
      paramArrayOfObject.append("\n");
      paramArrayOfObject.append("strSkillUseupTip");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(str2);
      paramArrayOfObject.append("|");
      paramArrayOfObject.append("\n");
      paramArrayOfObject.append("strSkillUseupTitle");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(str3);
      paramArrayOfObject.append("|");
      paramArrayOfObject.append("\n");
      paramArrayOfObject.append("strMeInColdPalaceTip");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(str4);
      paramArrayOfObject.append("|");
      paramArrayOfObject.append("\n");
      paramArrayOfObject.append("strForbbidenExtendTip");
      paramArrayOfObject.append("=");
      paramArrayOfObject.append(str5);
      paramArrayOfObject.append("|");
      paramArrayOfObject.append("\n");
      paramArrayOfObject.append("]");
      if (QLog.isColorLevel()) {
        QLog.i("ExpandHandlerImpl", 2, paramArrayOfObject.toString());
      }
      notifyUI(28, true, new Object[0]);
    }
  }
  
  private boolean a(List<Long> paramList1, int paramInt1, int paramInt2, List<Long> paramList2, int paramInt3)
  {
    int i;
    if (paramList1 == null) {
      i = 0;
    } else {
      i = paramList1.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExpandHandlerImpl", 2, String.format("getExtendFriendOnlineState reqListSize=%s startIndex=%s count=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    Object localObject2;
    Object localObject1;
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = null;
      if (localObject2 == null) {
        break label413;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    }
    catch (Exception paramList1) {}
    paramInt2 = Math.min(i - paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("ExpandHandlerImpl", 2, String.format("getExtendFriendOnlineState fixed count=%s", new Object[] { Integer.valueOf(paramInt2) }));
    }
    oidb_0xe09.ReqBody localReqBody = new oidb_0xe09.ReqBody();
    Iterator localIterator = paramList1.subList(paramInt1, paramInt1 + paramInt2).iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        Object localObject4 = ((MessageCache)localObject1).b(String.valueOf(localLong), (String)localObject2);
        Object localObject3 = localObject4;
        if (localObject4 == null) {
          localObject3 = ((MessageCache)localObject1).a(String.valueOf(localLong), (String)localObject2, false);
        }
        if (localObject3 != null)
        {
          localObject4 = new oidb_0xe09.reqItem();
          ((oidb_0xe09.reqItem)localObject4).uint64_uin.set(localLong.longValue());
          ((oidb_0xe09.reqItem)localObject4).bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject3));
          localReqBody.rpt_item.add((MessageMicro)localObject4);
        }
        else
        {
          QLog.w("ExpandHandlerImpl", 1, String.format("getExtendFriendOnlineState get match chat sig fail. uin=%s", new Object[] { localLong }));
        }
      }
      else
      {
        localObject1 = makeOIDBPkg("OidbSvc.0xe09", 3593, 1, localReqBody.toByteArray());
        ((ToServiceMsg)localObject1).addAttribute("reqList", paramList1);
        ((ToServiceMsg)localObject1).addAttribute("startIndex", Integer.valueOf(paramInt1));
        ((ToServiceMsg)localObject1).addAttribute("count", Integer.valueOf(paramInt2));
        ((ToServiceMsg)localObject1).addAttribute("resultList", paramList2);
        ((ToServiceMsg)localObject1).addAttribute("reqTag", Integer.valueOf(paramInt3));
        sendPbReq((ToServiceMsg)localObject1);
        return true;
        for (;;)
        {
          try
          {
            QLog.e("ExpandHandlerImpl", 1, "getExtendFriendOnlineState invalid param.");
            return false;
          }
          catch (Exception paramList1) {}
          QLog.e("ExpandHandlerImpl", 1, "getExtendFriendOnlineState fail.", paramList1);
          return true;
          label413:
          localObject2 = null;
          if ((i != 0) && (paramInt1 < i) && (paramInt2 > 0)) {
            if (localObject1 != null) {
              break;
            }
          }
        }
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new EditExtendFriendInfo.RspBody());
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleUpdateExtendFriendCampusSchoolInfo,result = ");
      paramFromServiceMsg.append(i);
      QLog.d("ExpandHandlerImpl", 2, paramFromServiceMsg.toString());
    }
    boolean bool2 = true;
    boolean bool1;
    if (i == 0)
    {
      paramFromServiceMsg = (IExpandManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      bool1 = bool2;
      if (paramFromServiceMsg != null)
      {
        i = paramToServiceMsg.extraData.getInt("idx", 0);
        paramObject = paramToServiceMsg.extraData.getString("school_name", "");
        String str = paramToServiceMsg.extraData.getString("school_id", "");
        int j = paramToServiceMsg.extraData.getInt("school_category", 0);
        paramFromServiceMsg.a(paramToServiceMsg.extraData.getInt("school_certi_status", 0), 1);
        paramFromServiceMsg.a(i, paramObject, str, j);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    notifyUI(22, bool1, null);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xe52.RspBody());
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleCertificateConfirmSchool,result = ");
      paramToServiceMsg.append(i);
      QLog.d("ExpandHandlerImpl", 2, paramToServiceMsg.toString());
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xdb1.RspBody localRspBody = new oidb_0xdb1.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ExpandHandlerImpl", 2, new Object[] { "handleGetCampusCertificateStatusResponse. result = ", Integer.valueOf(i) });
    }
    boolean bool;
    if (i == 0)
    {
      paramObject = (ExpandManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramObject != null) {
        paramObject.a(paramToServiceMsg, paramFromServiceMsg, localRspBody);
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    notifyUI(20, bool, new Object[] { Integer.valueOf(1) });
    if (i == 0) {
      a(paramFromServiceMsg, localRspBody);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      Object localObject = new oidb_0xe09.RspBody();
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (i == 0)
      {
        paramObject = new ArrayList();
        try
        {
          if (((oidb_0xe09.RspBody)localObject).rpt_online_info.has())
          {
            paramFromServiceMsg = ((oidb_0xe09.RspBody)localObject).rpt_online_info.get().iterator();
            while (paramFromServiceMsg.hasNext())
            {
              localObject = (oidb_0xe09.OnlineInfo)paramFromServiceMsg.next();
              if (((oidb_0xe09.OnlineInfo)localObject).uint64_friend_uin.has()) {
                paramObject.add(Long.valueOf(((oidb_0xe09.OnlineInfo)localObject).uint64_friend_uin.get()));
              }
            }
          }
          paramFromServiceMsg = paramObject;
          if (!QLog.isColorLevel()) {
            break label196;
          }
          QLog.d("ExpandHandlerImpl", 2, String.format("handleGetExtendFriendOnlineState size=%s", new Object[] { Integer.valueOf(paramObject.size()) }));
          paramFromServiceMsg = paramObject;
        }
        catch (Exception localException1)
        {
          paramFromServiceMsg = paramObject;
          break label185;
        }
      }
      else
      {
        QLog.e("ExpandHandlerImpl", 1, String.format("handleGetExtendFriendOnlineState result=%s", new Object[] { Integer.valueOf(i) }));
        paramFromServiceMsg = null;
      }
    }
    catch (Exception localException2)
    {
      paramFromServiceMsg = null;
      label185:
      QLog.e("ExpandHandlerImpl", 1, "handleGetExtendFriendOnlineState fail.", localException2);
    }
    label196:
    ArrayList localArrayList;
    if (paramToServiceMsg != null) {
      try
      {
        localArrayList = (ArrayList)paramToServiceMsg.getAttribute("reqList");
        k = ((Integer)paramToServiceMsg.getAttribute("startIndex")).intValue();
        j = ((Integer)paramToServiceMsg.getAttribute("count")).intValue();
        localInteger = (Integer)paramToServiceMsg.getAttribute("reqTag");
        paramObject = (ArrayList)paramToServiceMsg.getAttribute("resultList");
        paramToServiceMsg = paramObject;
        if (paramObject == null) {
          paramToServiceMsg = new ArrayList();
        }
        if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty())) {
          paramToServiceMsg.addAll(paramFromServiceMsg);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        int k;
        int j;
        Integer localInteger;
        QLog.e("ExpandHandlerImpl", 1, "handleGetExtendFriendOnlineState fail.", paramToServiceMsg);
        notifyUI(19, false, null);
      }
    }
    for (int i = localArrayList.size();; i = 0)
    {
      k += j;
      if (k < i)
      {
        a(localArrayList, k, j, paramToServiceMsg, localInteger.intValue());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExpandHandlerImpl", 2, String.format("handleGetExtendFriendOnlineState request finished. resultList=%s", new Object[] { paramToServiceMsg }));
      }
      notifyUI(19, true, new Object[] { paramToServiceMsg, localInteger, localArrayList });
      return;
      return;
      if (localArrayList != null) {
        break;
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      Object localObject = new oidb_0xe51.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      paramObject = paramToServiceMsg.extraData.getString("selfUin");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("friendUin");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("friendNick");
      if (i == 0)
      {
        localObject = ((oidb_0xe51.RspBody)localObject).bytes_sig.get().toByteArray();
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache() != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramFromServiceMsg, paramObject, (byte[])localObject, false);
          if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImpl", 2, "handleGetSigByOxb4cCode() success -> addMatchChatSessionKey");
          }
          notifyUI(21, true, new Object[] { paramFromServiceMsg, paramToServiceMsg });
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetSigByOxb4cCode() fail result=");
          paramToServiceMsg.append(i);
          QLog.d("ExpandHandlerImpl", 2, paramToServiceMsg.toString());
        }
        notifyUI(21, false, new Object[] { paramFromServiceMsg, Integer.valueOf(i) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("ExpandHandlerImpl", 1, "handleGetSigByOxb4cCode() fail.", paramToServiceMsg);
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    label206:
    label213:
    for (;;)
    {
      try
      {
        oidb_0xe67.RspBody localRspBody = new oidb_0xe67.RspBody();
        int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
        paramToServiceMsg = paramToServiceMsg.extraData;
        int i = -1;
        int k = paramToServiceMsg.getInt("uint32_action", -1);
        if (localRspBody.uint32_flare_switch.has()) {
          i = localRspBody.uint32_flare_switch.get();
        }
        if ((k != 1) || (i != 1)) {
          break label213;
        }
        try
        {
          if (!((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).b()) {
            break label206;
          }
          paramToServiceMsg = "1";
          ReportController.b(null, "dc00898", "", "", "0X800AE9B", "0X800AE9B", 0, 0, "", paramToServiceMsg, "", "");
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleExtendFriendEnterAndQuit  result=");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append("[0is exit] type:");
          paramToServiceMsg.append(k);
          paramToServiceMsg.append(" signalSwitch:");
          paramToServiceMsg.append(i);
          QLog.i("ExpandHandlerImpl", 2, paramToServiceMsg.toString());
          return;
        }
        catch (Exception paramToServiceMsg) {}
        QLog.e("ExpandHandlerImpl", 1, "handleExtendFriendEnterAndQuitReport() fail.", paramToServiceMsg);
      }
      catch (Exception paramToServiceMsg) {}
      return;
      paramToServiceMsg = "2";
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("uin", "");
    int i = paramToServiceMsg.extraData.getInt("uinType", 0);
    Object localObject = new oidb_0xeae.RspBody();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("uin");
    paramToServiceMsg.append("=");
    paramToServiceMsg.append(str);
    paramToServiceMsg.append("|");
    paramToServiceMsg.append("uinType");
    paramToServiceMsg.append("=");
    paramToServiceMsg.append(i);
    paramToServiceMsg.append("|");
    paramToServiceMsg.append("result");
    paramToServiceMsg.append("=");
    paramToServiceMsg.append(j);
    paramToServiceMsg.append("|");
    if ((j != 0) && (j != 33))
    {
      notifyUI(26, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(false) });
    }
    else
    {
      int k = (int)((oidb_0xeae.RspBody)localObject).uint64_black_times.get();
      paramFromServiceMsg = ((oidb_0xeae.RspBody)localObject).str_black_times_used_up_title.get();
      paramObject = ((oidb_0xeae.RspBody)localObject).str_black_times_used_up_tips.get();
      localObject = ((oidb_0xeae.RspBody)localObject).str_black_times_tips.get();
      ColdPalaceHelper localColdPalaceHelper = ColdPalaceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localColdPalaceHelper.a(1, paramFromServiceMsg);
      localColdPalaceHelper.a(2, paramObject);
      localColdPalaceHelper.a(0, (String)localObject);
      localColdPalaceHelper.a(k);
      boolean bool1;
      if (j == 33) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramToServiceMsg.append("isUsedUp");
      paramToServiceMsg.append("=");
      paramToServiceMsg.append(bool1);
      paramToServiceMsg.append("|");
      paramToServiceMsg.append("skillTimesLeft");
      paramToServiceMsg.append("=");
      paramToServiceMsg.append(k);
      paramToServiceMsg.append("|");
      paramToServiceMsg.append("skillUseUpTitle");
      paramToServiceMsg.append("=");
      paramToServiceMsg.append(paramFromServiceMsg);
      paramToServiceMsg.append("|");
      paramToServiceMsg.append("skillUseUpWording");
      paramToServiceMsg.append("=");
      paramToServiceMsg.append(paramObject);
      paramToServiceMsg.append("|");
      paramToServiceMsg.append("skillUseTip");
      paramToServiceMsg.append("=");
      paramToServiceMsg.append((String)localObject);
      paramToServiceMsg.append("|");
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.MATCH_CHAT_UIN, i, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      boolean bool2;
      if (j == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      notifyUI(26, bool2, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool1) });
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleThrowToColdPalace,");
      paramFromServiceMsg.append(paramToServiceMsg.toString());
      QLog.d("ExpandHandlerImpl", 1, paramFromServiceMsg.toString());
    }
  }
  
  public int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    QLog.i("ExpandHandlerImpl", 1, String.format("getExtendFriendInfo uin=%s", new Object[] { paramString }));
    int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    try
    {
      localObject = new GetExtendFriendInfo.ReqBody();
      ((GetExtendFriendInfo.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString));
      localObject = makeOIDBPkg("OidbSvc.0xb51", 2897, 0, ((GetExtendFriendInfo.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      ((ToServiceMsg)localObject).extraData.putBoolean("onlyStrangerInfo", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putInt("getStrangerInfoSeq", i);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return i;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getExtendFriendInfo exception:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("ExpandHandlerImpl", 1, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public void a()
  {
    if (!MatchChatMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ExpandHandlerImpl", 2, "calcMatchChatBoxUnreadCount isMatchChatRedPointSwitchOn false");
      }
      return;
    }
    b();
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    int j = 0;
    int i = j;
    if (paramMessageRecord != null)
    {
      i = j;
      if ((paramMessageRecord instanceof MessageForLimitChatConfirm))
      {
        paramMessageRecord = (MessageForLimitChatConfirm)paramMessageRecord;
        Object localObject;
        if (paramMessageRecord != null)
        {
          localObject = new MatchNotifyInfo();
          ((MatchNotifyInfo)localObject).jdField_a_of_type_Boolean = paramMessageRecord.bEnterMsg;
          ((MatchNotifyInfo)localObject).jdField_a_of_type_Int = paramMessageRecord.leaveChatType;
          ((MatchNotifyInfo)localObject).jdField_a_of_type_Long = paramMessageRecord.timeStamp;
          ((MatchNotifyInfo)localObject).jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
          ((MatchNotifyInfo)localObject).jdField_b_of_type_JavaLangString = paramMessageRecord.SenderNickName;
          ((MatchNotifyInfo)localObject).d = paramMessageRecord.c2cExpiredTime;
          ((MatchNotifyInfo)localObject).jdField_b_of_type_Int = paramMessageRecord.leftChatTime;
          ((MatchNotifyInfo)localObject).jdField_c_of_type_JavaLangString = paramMessageRecord.tipsWording;
          ((MatchNotifyInfo)localObject).jdField_c_of_type_Int = paramMessageRecord.matchExpiredTime;
          ((MatchNotifyInfo)localObject).jdField_b_of_type_Long = paramMessageRecord.readyTs;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("HandleC2CConfirmOrCancelMsg  info：");
          localStringBuilder.append(((MatchNotifyInfo)localObject).toString());
          QLog.i("ExpandHandlerImplExtendFriendLimitChat", 2, localStringBuilder.toString());
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (!MessageRecordInfo.b(paramMessageRecord.issend))
        {
          long l1 = paramMessageRecord.time;
          try
          {
            long l2 = Long.valueOf(paramMessageRecord.frienduin).longValue();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("HandleC2CConfirmMsg,uin: %s,  id: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
            }
            if (l1 != -1L)
            {
              if (l1 == 0L) {
                return;
              }
              if (l2 == -1L) {
                return;
              }
              localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(l2);
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)l1);
              paramMessageRecord = new msg_svc.PbC2CReadedReportReq();
              paramMessageRecord.pair_info.add((MessageMicro)localObject);
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a();
              if (localObject != null) {
                paramMessageRecord.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
              }
              localObject = new msg_svc.PbMsgReadedReportReq();
              ((msg_svc.PbMsgReadedReportReq)localObject).c2c_read_report.set(paramMessageRecord);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a("c2c_processor").a((msg_svc.PbMsgReadedReportReq)localObject);
            }
            else
            {
              return;
            }
          }
          catch (NumberFormatException paramMessageRecord)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.HandleC2CConfirmMsg sendReadConfirm_PB", 2, paramMessageRecord, new Object[0]);
            }
            return;
          }
        }
      }
    }
    if (i == 0) {
      QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, "HandleC2CConfirmMsg failed");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
      paramObject = paramToServiceMsg.extraData.getString("declaration");
      String str = paramToServiceMsg.extraData.getString("url");
      int i = paramToServiceMsg.extraData.getInt("duration");
      a(paramFromServiceMsg, paramObject, str, 0, NetConnInfoCenter.getServerTimeMillis(), i);
      paramToServiceMsg = "success";
      bool = true;
    }
    else
    {
      paramToServiceMsg = paramFromServiceMsg.getStringForLog();
      bool = false;
    }
    QLog.i("ExpandHandlerImpl", 1, String.format("handleEditExtendFriendInfo %s", new Object[] { paramToServiceMsg }));
    notifyUI(1, bool, null);
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof EditExtendFriendInfo.SchoolInfo))
    {
      QLog.e("ExpandHandlerImpl", 2, "updateExtendFriendCampusSchoolInfo info not instance of SchoolInfo");
      return;
    }
    EditExtendFriendInfo.SchoolInfo localSchoolInfo = (EditExtendFriendInfo.SchoolInfo)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandHandlerImpl", 2, "updateExtendFriendCampusSchoolInfo ");
    }
    for (;;)
    {
      try
      {
        paramObject = new EditExtendFriendInfo.ReqBody();
        paramObject.msg_school_info.set(localSchoolInfo);
        ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0xb4b_6", 2891, 6, paramObject.toByteArray());
        boolean bool = localSchoolInfo.uint32_idx.has();
        int j = 0;
        if (bool)
        {
          i = localSchoolInfo.uint32_idx.get();
          localToServiceMsg.extraData.putInt("idx", i);
          bool = localSchoolInfo.str_school_name.has();
          localObject = "";
          if (!bool) {
            break label368;
          }
          paramObject = localSchoolInfo.str_school_name.get();
          localToServiceMsg.extraData.putString("school_name", paramObject);
          if (localSchoolInfo.str_school_id.has()) {
            localObject = localSchoolInfo.str_school_id.get();
          }
          localToServiceMsg.extraData.putString("school_id", (String)localObject);
          if (!localSchoolInfo.uint32_category.has()) {
            break label374;
          }
          i = localSchoolInfo.uint32_category.get();
          localToServiceMsg.extraData.putInt("school_category", i);
          i = j;
          if (localSchoolInfo.uint32_verified.has()) {
            i = localSchoolInfo.uint32_verified.get();
          }
          localToServiceMsg.extraData.putInt("school_certi_status", i);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateExtendFriendCampusSchoolInfo ,schoolName = ");
            ((StringBuilder)localObject).append(paramObject);
            ((StringBuilder)localObject).append(",verify status = ");
            ((StringBuilder)localObject).append(i);
            QLog.d("ExpandHandlerImpl", 2, ((StringBuilder)localObject).toString());
          }
          sendPbReq(localToServiceMsg);
          return;
        }
      }
      catch (NumberFormatException paramObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateExtendFriendCampusSchoolInfo. error = ");
        ((StringBuilder)localObject).append(paramObject);
        QLog.d("ExpandHandlerImpl", 1, ((StringBuilder)localObject).toString());
        return;
      }
      int i = 0;
      continue;
      label368:
      paramObject = "";
      continue;
      label374:
      i = 0;
    }
  }
  
  public void a(Object paramObject, long paramLong)
  {
    boolean bool1;
    if (paramLong == 296L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((paramObject instanceof submsgtype0x128.MsgBody)) {
      paramObject = (submsgtype0x128.MsgBody)paramObject;
    } else {
      paramObject = null;
    }
    if (paramObject != null)
    {
      Object localObject2 = new MatchInfo();
      ((MatchInfo)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      ((MatchInfo)localObject2).jdField_a_of_type_ArrayOfByte = paramObject.bytes_sig.get().toByteArray();
      boolean bool2 = paramObject.uint64_match_uin.has();
      String str = "0";
      if (bool2) {
        localObject1 = String.valueOf(paramObject.uint64_match_uin.get());
      } else {
        localObject1 = "0";
      }
      ((MatchInfo)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
      if (paramObject.bytes_tips_wording.has()) {
        localObject1 = paramObject.bytes_tips_wording.get().toStringUtf8();
      } else {
        localObject1 = "";
      }
      ((MatchInfo)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
      if (paramObject.uint64_time_stamp.has()) {
        paramLong = paramObject.uint64_time_stamp.get();
      } else {
        paramLong = 0L;
      }
      ((MatchInfo)localObject2).jdField_a_of_type_Long = paramLong;
      int i;
      if (paramObject.uint32_match_expired_time.has()) {
        i = paramObject.uint32_match_expired_time.get();
      } else {
        i = 0;
      }
      ((MatchInfo)localObject2).jdField_a_of_type_Int = i;
      if (paramObject.bytes_nick.has()) {
        localObject1 = paramObject.bytes_nick.get().toStringUtf8();
      } else {
        localObject1 = "";
      }
      ((MatchInfo)localObject2).d = ((String)localObject1);
      if ((paramObject.msg_tag.has()) && (paramObject.msg_tag.uint32_tag_id.has()))
      {
        ((MatchInfo)localObject2).jdField_b_of_type_Int = paramObject.msg_tag.uint32_tag_id.get();
        if (paramObject.msg_tag.bytes_tag.has()) {
          localObject1 = paramObject.msg_tag.bytes_tag.get().toStringUtf8();
        } else {
          localObject1 = "";
        }
        ((MatchInfo)localObject2).jdField_f_of_type_JavaLangString = ((String)localObject1);
      }
      else
      {
        ((MatchInfo)localObject2).jdField_b_of_type_Int = 1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("msg_tag id empty in push bUnlimitMatchPush：");
        ((StringBuilder)localObject1).append(bool1);
        QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramObject.msg_match_uin_data.has())
      {
        ((MatchInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo = new ChatFriendInfo();
        ((MatchInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_a_of_type_JavaLangString = ((MatchInfo)localObject2).jdField_b_of_type_JavaLangString;
        a(paramObject.msg_match_uin_data, ((MatchInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("msg_match_uin_data in push bUnlimitMatchPush：");
        ((StringBuilder)localObject1).append(bool1);
        QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject1).toString());
      }
      if (((MatchInfo)localObject2).jdField_b_of_type_Int != 10000)
      {
        localObject2 = (ExtendFriendLimitChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        localObject1 = str;
        if (paramObject.uint64_match_uin.has()) {
          localObject1 = String.valueOf(paramObject.uint64_match_uin.get());
        }
        paramObject = paramObject.bytes_sig.get().toByteArray();
        if (paramObject != null)
        {
          ((ExtendFriendLimitChatManager)localObject2).a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramObject);
          return;
        }
        paramObject = new StringBuilder();
        paramObject.append("signature is null in push , matchUin = ");
        paramObject.append((String)localObject1);
        QLog.e("ExpandHandlerImplExtendFriendLimitChat", 1, paramObject.toString());
        return;
      }
      if (paramObject.string_report_id.has()) {
        paramObject = paramObject.string_report_id.get();
      } else {
        paramObject = "";
      }
      Object localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject))
      {
        paramObject = new StringBuilder();
        paramObject.append("string_report_id EMPTY bUnlimitMatchPush：");
        paramObject.append(bool1);
        QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, paramObject.toString());
        localObject1 = "0";
      }
      ((MatchInfo)localObject2).e = ((String)localObject1);
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append(localObject2);
        paramObject.append("bUnlimitMatchPush：");
        paramObject.append(bool1);
        QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, new Object[] { "handleGetUnlimitMatchOfflinePush push matchInfo = ", paramObject.toString() });
      }
      paramObject = (ExtendFriendLimitChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
      if (paramObject != null) {
        paramObject.a();
      }
      if (bool1)
      {
        notifyUI(16, true, new Object[] { localObject2 });
        return;
      }
      ((ExpandManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a((MatchInfo)localObject2);
      notifyUI(23, true, new Object[] { ((MatchInfo)localObject2).jdField_b_of_type_JavaLangString });
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("handleGetUnlimitMatchOfflinePush failed bUnlimitMatchPush ：");
    paramObject.append(bool1);
    QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, paramObject.toString());
    if (bool1)
    {
      notifyUI(16, false, null);
      return;
    }
    notifyUI(23, false, new Object[] { null });
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportUser, uin: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ExpandHandlerImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ExpandHandlerImpl", 1, "reportUser, uin is empty!");
      return;
    }
    try
    {
      localObject = new cmd0xcb5.ReqBody();
      ((cmd0xcb5.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
      ((cmd0xcb5.ReqBody)localObject).uint32_report_type.set(0);
      ((cmd0xcb5.ReqBody)localObject).str_report_conent.set("");
      ((cmd0xcb5.ReqBody)localObject).uint64_report_time.set(NetConnInfoCenter.getServerTimeMillis());
      sendPbReq(makeOIDBPkg("OidbSvc.0xcb5", 3253, 0, ((cmd0xcb5.ReqBody)localObject).toByteArray()));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("ExpandHandlerImpl", 1, "reportUser exception:", paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QLog.i("ExpandHandlerImpl", 1, String.format("reqThrowToColdPalace uin=%s uinType=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    try
    {
      localObject = new oidb_0xeae.ReqBody();
      ((oidb_0xeae.ReqBody)localObject).uint64_black_uin.set(Long.parseLong(paramString));
      localObject = makeOIDBPkg("OidbSvc.0xeae", 3758, 1, ((oidb_0xeae.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("uinType", paramInt);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqThrowToColdPalace exception:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("ExpandHandlerImpl", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i("ExpandHandlerImpl", 1, String.format("editExtendFriendInfo uin=%s, declaration=%s, url=%s, duration=%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt1) }));
    if (!NetworkState.isNetworkConnected(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131694422, 0).a();
      notifyUI(1, false, null);
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramInt4 = 0;
      paramInt2 = 0;
    }
    ((IJce)QRoute.api(IJce.class)).build("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.UniSetExtFriend").request("UniSetExtFriend", new UniSetExtFriendReq(IJce.Util.a(), new UniBusinessItem(304, paramInt4, ""), new ExtendFriend(paramInt2)), new UniSetExtFriendRsp(), new ExpandHandlerImpl.1(this, paramString1, paramInt4, paramInt2), true);
    try
    {
      Object localObject = new EditExtendFriendInfo.ReqBody();
      ((EditExtendFriendInfo.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_declaration.set(ByteStringMicro.copyFromUtf8(paramString2));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramString3));
      ((EditExtendFriendInfo.ReqBody)localObject).uint32_voice_duration.set(paramInt1);
      localObject = makeOIDBPkg("OidbSvc.0xb4b", 2891, 0, ((EditExtendFriendInfo.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("declaration", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("url", paramString3);
      ((ToServiceMsg)localObject).extraData.putInt("duration", paramInt1);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("editExtendFriendInfo exception:");
      paramString2.append(paramString1.getMessage());
      QLog.e("ExpandHandlerImpl", 1, paramString2.toString());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSigBy0xb4cCode() friendUin= ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(" selfUin= ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" _0xb4cCode =");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.d("ExpandHandlerImpl", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new oidb_0xe51.ReqBody();
      ((oidb_0xe51.ReqBody)localObject).uint64_from_uin.set(Long.parseLong(paramString1));
      ((oidb_0xe51.ReqBody)localObject).uint64_to_uin.set(Long.parseLong(paramString2));
      ((oidb_0xe51.ReqBody)localObject).bytes_code.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xe51", 3665, 1, ((oidb_0xe51.ReqBody)localObject).toByteArray());
      paramArrayOfByte.extraData.putString("selfUin", paramString1);
      paramArrayOfByte.extraData.putString("friendUin", paramString2);
      paramArrayOfByte.extraData.putString("friendNick", paramString3);
      sendPbReq(paramArrayOfByte);
      return;
    }
    catch (Exception paramString1)
    {
      notifyUI(21, false, new Object[] { paramString2, Integer.valueOf(-1) });
      QLog.e("ExpandHandlerImpl", 1, "getSigBy0xb4cCode() fail.", paramString1);
    }
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, long paramLong, String paramString3, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("ExpandHandlerImpl", 2, String.format("getSquareStrangerList uin=%s reqCookies=%s reqCount=%s searchKey=%s ts=%d isConfigTag:%b", new Object[] { paramString1, paramArrayOfByte, Integer.valueOf(paramInt), paramString2, Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      localReqBody = new ExtendFriendSquareInfo.ReqBody();
      localReqBody.uint64_uin.set(Long.parseLong(paramString1));
      if (paramArrayOfByte == null) {
        break label445;
      }
      localReqBody.bytes_req_page_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    catch (Exception paramString1)
    {
      ExtendFriendSquareInfo.ReqBody localReqBody;
      SosoLbsInfo localSosoLbsInfo;
      ExtendFriendSquareInfo.LBSInfo localLBSInfo;
      ExtendFriendSquareInfo.GPS localGPS;
      QLog.e("ExpandHandlerImpl", 1, "getSquareStrangerList fail.", paramString1);
    }
    paramString1 = paramString2.trim();
    label112:
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString3.equals(paramString1))) {
      localReqBody.str_keyword.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    localReqBody.uint32_req_num.set(paramInt);
    paramArrayOfByte = ((IVasAdExtendFriendApi)QRoute.api(IVasAdExtendFriendApi.class)).getDeviceInfoByteArray();
    localReqBody.bytes_req_buff.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = makeOIDBPkg("OidbSvc.0xb4c", 2892, 0, localReqBody.toByteArray());
    paramArrayOfByte.setTimeout(10000L);
    paramArrayOfByte.extraData.putLong("reqTs", paramLong);
    if (!TextUtils.isEmpty(paramString2)) {
      paramArrayOfByte.extraData.putString("searchKey", paramString2);
    }
    localSosoLbsInfo = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getCanUsedLbsInfoCache(3600000L, false, 0, true);
    if (localSosoLbsInfo != null)
    {
      localLBSInfo = new ExtendFriendSquareInfo.LBSInfo();
      localGPS = new ExtendFriendSquareInfo.GPS();
      if (localSosoLbsInfo.mLocation != null)
      {
        localGPS.int32_lon.set((int)(localSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
        localGPS.int32_lat.set((int)(localSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
        localGPS.int32_type.set(1);
      }
      localLBSInfo.msg_gps.set(localGPS);
      localReqBody.msg_lbs_info.set(localLBSInfo);
    }
    sendPbReq(paramArrayOfByte);
    paramInt = i;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramInt = i;
      if (paramString3.equals(paramString1)) {
        paramInt = 1;
      }
    }
    if (paramInt == 0)
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!paramBoolean) {
        break label455;
      }
      paramInt = 1;
    }
    for (;;)
    {
      ReportController.b(paramString1, "dc00898", "", "", "0X8009423", "0X8009423", paramInt, 0, "", "", paramString2, "");
      return;
      return;
      label445:
      if (paramString2 != null) {
        break;
      }
      paramString1 = null;
      break label112;
      label455:
      paramInt = 2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "requestLimitChatSettingOnPlusPanel+voiceMatch");
    }
    try
    {
      ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0xdb1", 3505, 1, new oidb_0xdb1.ReqBody().toByteArray());
      localToServiceMsg.extraData.putBoolean("request_from_login", paramBoolean);
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestLimitChatSettingOnPlusPanel. error = ");
      localStringBuilder.append(localNumberFormatException);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    try
    {
      Object localObject1 = new oidb_0xe67.ReqBody();
      ((oidb_0xe67.ReqBody)localObject1).uint32_action.set(0);
      localObject2 = (IExpandManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localObject2 != null)
      {
        localObject2 = ((IExpandManager)localObject2).a();
        if (localObject2 != null)
        {
          oidb_0xe67.LBSInfo localLBSInfo = new oidb_0xe67.LBSInfo();
          oidb_0xe67.GPS localGPS = new oidb_0xe67.GPS();
          localGPS.int32_lon.set(((ExtendFriendLocationInfo)localObject2).jdField_b_of_type_Int);
          localGPS.int32_lat.set(((ExtendFriendLocationInfo)localObject2).jdField_a_of_type_Int);
          localGPS.int32_alt.set(((ExtendFriendLocationInfo)localObject2).jdField_c_of_type_Int);
          localGPS.int32_type.set(((ExtendFriendLocationInfo)localObject2).d);
          localLBSInfo.msg_gps.set(localGPS);
          ((oidb_0xe67.ReqBody)localObject1).msg_lbs_info.set(localLBSInfo);
          QLog.d("ExpandHandlerImpl", 1, "QuitExtendFriend. with msg_lbs_info info ");
        }
      }
      localObject1 = makeOIDBPkg("OidbSvc.0xe67", 3687, 1, ((oidb_0xe67.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("uint32_action", 0);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QuitExtendFriend. error = ");
      ((StringBuilder)localObject2).append(localNumberFormatException);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject2).toString());
    }
    return false;
  }
  
  public boolean a(int paramInt, ExtendFriendLocationInfo paramExtendFriendLocationInfo)
  {
    Object localObject1 = paramExtendFriendLocationInfo;
    if (paramExtendFriendLocationInfo == null) {
      localObject1 = ((ExpandManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    }
    paramExtendFriendLocationInfo = new StringBuilder();
    paramExtendFriendLocationInfo.append("openSignalBomb  Match.   Type= ");
    paramExtendFriendLocationInfo.append(paramInt);
    QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, paramExtendFriendLocationInfo.toString());
    try
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      paramExtendFriendLocationInfo = new oidb_0xe03.ReqBody();
      paramExtendFriendLocationInfo.uint64_uin.set(a((String)localObject2, "openSignalBomb"));
      paramExtendFriendLocationInfo.enum_matchopcode.set(6);
      paramExtendFriendLocationInfo.uint32_tag_id.set(0);
      paramExtendFriendLocationInfo.uint32_sex.set(paramInt);
      if (((IExpandManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER) != null) && (localObject1 != null))
      {
        localObject2 = new oidb_0xe03.LBSInfo();
        oidb_0xe03.GPS localGPS = new oidb_0xe03.GPS();
        localGPS.int32_lon.set(((ExtendFriendLocationInfo)localObject1).jdField_b_of_type_Int);
        localGPS.int32_lat.set(((ExtendFriendLocationInfo)localObject1).jdField_a_of_type_Int);
        localGPS.int32_alt.set(((ExtendFriendLocationInfo)localObject1).jdField_c_of_type_Int);
        localGPS.int32_type.set(((ExtendFriendLocationInfo)localObject1).d);
        ((oidb_0xe03.LBSInfo)localObject2).msg_gps.set(localGPS);
        paramExtendFriendLocationInfo.msg_lbs_info.set((MessageMicro)localObject2);
        QLog.d("ExpandHandlerImpl", 1, "openSignalBomb. with msg_lbs_info info ");
      }
      paramExtendFriendLocationInfo = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, paramExtendFriendLocationInfo.toByteArray());
      paramExtendFriendLocationInfo.extraData.putInt("match_op", 6);
      sendPbReq(paramExtendFriendLocationInfo);
      return true;
    }
    catch (NumberFormatException paramExtendFriendLocationInfo)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("openSignalBomb. error = ");
      ((StringBuilder)localObject1).append(paramExtendFriendLocationInfo);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  public boolean a(ExtendFriendLocationInfo paramExtendFriendLocationInfo)
  {
    try
    {
      localObject = new oidb_0xe67.ReqBody();
      ((oidb_0xe67.ReqBody)localObject).uint32_action.set(1);
      if (paramExtendFriendLocationInfo != null)
      {
        oidb_0xe67.LBSInfo localLBSInfo = new oidb_0xe67.LBSInfo();
        oidb_0xe67.GPS localGPS = new oidb_0xe67.GPS();
        localGPS.int32_lon.set(paramExtendFriendLocationInfo.jdField_b_of_type_Int);
        localGPS.int32_lat.set(paramExtendFriendLocationInfo.jdField_a_of_type_Int);
        localGPS.int32_alt.set(paramExtendFriendLocationInfo.jdField_c_of_type_Int);
        localGPS.int32_type.set(paramExtendFriendLocationInfo.d);
        localLBSInfo.msg_gps.set(localGPS);
        ((oidb_0xe67.ReqBody)localObject).msg_lbs_info.set(localLBSInfo);
        QLog.i("ExpandHandlerImpl", 1, "EnterExtendFriend. with msg_lbs_info info ");
      }
      paramExtendFriendLocationInfo = makeOIDBPkg("OidbSvc.0xe67", 3687, 1, ((oidb_0xe67.ReqBody)localObject).toByteArray());
      paramExtendFriendLocationInfo.extraData.putInt("uint32_action", 1);
      sendPbReq(paramExtendFriendLocationInfo);
      return true;
    }
    catch (NumberFormatException paramExtendFriendLocationInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EnterExtendFriend. error = ");
      ((StringBuilder)localObject).append(paramExtendFriendLocationInfo);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancleUnlimitMatch. uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new oidb_0xe03.ReqBody();
      ((oidb_0xe03.ReqBody)localObject).uint64_uin.set(a(paramString, "cancleUnlimitMatch"));
      ((oidb_0xe03.ReqBody)localObject).enum_matchopcode.set(2);
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, ((oidb_0xe03.ReqBody)localObject).toByteArray());
      paramString.extraData.putInt("match_op", 2);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestMatch. error = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("request Unlimit Match. uin = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" Type= ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" tag:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
    try
    {
      localObject = new oidb_0xe03.ReqBody();
      ((oidb_0xe03.ReqBody)localObject).uint64_uin.set(a(paramString, "requestUnlimitMatch"));
      ((oidb_0xe03.ReqBody)localObject).enum_matchopcode.set(1);
      ((oidb_0xe03.ReqBody)localObject).uint32_tag_id.set(paramInt2);
      ((oidb_0xe03.ReqBody)localObject).uint32_sex.set(paramInt1);
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, ((oidb_0xe03.ReqBody)localObject).toByteArray());
      paramString.extraData.putInt("match_op", 1);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestMatch. error = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUnlimitMatchUserInfo. uin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" matchUin:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" uinType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new oidb_0xe03.ReqBody();
      ((oidb_0xe03.ReqBody)localObject).uint64_uin.set(a(paramString1, "getUnlimitMatchUserInfo"));
      ((oidb_0xe03.ReqBody)localObject).uint64_match_uin.set(a(paramString2, "getUnlimitMatchUserInfo"));
      ((oidb_0xe03.ReqBody)localObject).enum_matchopcode.set(5);
      paramString1 = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, ((oidb_0xe03.ReqBody)localObject).toByteArray());
      paramString1.extraData.putInt("match_op", 5);
      paramString1.extraData.putString("match_uin", paramString2);
      paramString1.extraData.putInt("uin_type", paramInt);
      sendPbReq(paramString1);
      return true;
    }
    catch (NumberFormatException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("requestMatch. error = ");
      paramString2.append(paramString1);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, paramString2.toString());
    }
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setUnlimitMatchStatus. uin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" bopen: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new oidb_0xe03.ReqBody();
      ((oidb_0xe03.ReqBody)localObject).uint64_uin.set(a(paramString, "setUnlimitMatchStatus"));
      if (paramBoolean) {
        ((oidb_0xe03.ReqBody)localObject).uint32_switch.set(1);
      } else {
        ((oidb_0xe03.ReqBody)localObject).uint32_switch.set(0);
      }
      ((oidb_0xe03.ReqBody)localObject).enum_matchopcode.set(4);
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, ((oidb_0xe03.ReqBody)localObject).toByteArray());
      paramString.extraData.putInt("match_op", 4);
      paramString.extraData.putBoolean("open", paramBoolean);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestMatch. error = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean a(List<Long> paramList)
  {
    return a(paramList, 0);
  }
  
  public boolean a(List<Long> paramList, int paramInt)
  {
    if (paramList != null) {
      return a(paramList, 0, 50, null, paramInt);
    }
    return false;
  }
  
  public void b()
  {
    notifyUI(17, true, Integer.valueOf(MatchChatMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 1575	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody
    //   3: dup
    //   4: invokespecial 1576	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:<init>	()V
    //   7: astore 23
    //   9: aload_2
    //   10: aload_3
    //   11: aload 23
    //   13: invokestatic 649	com/tencent/mobileqq/qqexpand/network/impl/ExpandHandlerImpl:parseOIDBPkg	(Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;Lcom/tencent/mobileqq/pb/MessageMicro;)I
    //   16: istore 4
    //   18: aload_1
    //   19: getfield 663	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 1351
    //   25: lconst_0
    //   26: invokevirtual 1580	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   29: lstore 9
    //   31: aload_1
    //   32: getfield 663	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   35: ldc_w 1357
    //   38: aconst_null
    //   39: invokevirtual 676	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_1
    //   43: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +39 -> 85
    //   49: ldc 45
    //   51: iconst_2
    //   52: ldc_w 1582
    //   55: iconst_3
    //   56: anewarray 121	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: iload 4
    //   63: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_1
    //   70: aastore
    //   71: dup
    //   72: iconst_2
    //   73: lload 9
    //   75: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   78: aastore
    //   79: invokestatic 528	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: iload 4
    //   87: ifne +2342 -> 2429
    //   90: aload 23
    //   92: getfield 1585	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:uint32_over	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   95: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   98: iconst_1
    //   99: if_icmpne +2367 -> 2466
    //   102: iconst_1
    //   103: istore 15
    //   105: goto +3 -> 108
    //   108: aload 23
    //   110: getfield 1588	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:bytes_rsp_page_cookies	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: invokevirtual 311	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   119: astore 21
    //   121: aload 23
    //   123: getfield 1591	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:uint32_is_profile_complete	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: iconst_1
    //   130: if_icmpne +2342 -> 2472
    //   133: iconst_1
    //   134: istore 17
    //   136: goto +3 -> 139
    //   139: aload 23
    //   141: getfield 1594	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:uint32_is_show_card	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   144: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   147: iconst_1
    //   148: if_icmpne +2330 -> 2478
    //   151: iconst_1
    //   152: istore 18
    //   154: goto +3 -> 157
    //   157: aload 23
    //   159: getfield 1597	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:uint32_friend_max_votes	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   162: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   165: istore 4
    //   167: aload 23
    //   169: getfield 1600	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:rpt_msg_stranger_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   172: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   175: astore 20
    //   177: new 339	java/util/ArrayList
    //   180: dup
    //   181: invokespecial 340	java/util/ArrayList:<init>	()V
    //   184: astore 22
    //   186: iload 15
    //   188: istore 16
    //   190: lload 9
    //   192: lstore 11
    //   194: aload_1
    //   195: astore 19
    //   197: iload 4
    //   199: istore 5
    //   201: aload 20
    //   203: ifnull +1626 -> 1829
    //   206: iload 15
    //   208: istore 16
    //   210: lload 9
    //   212: lstore 11
    //   214: aload_1
    //   215: astore 19
    //   217: iload 4
    //   219: istore 5
    //   221: lload 9
    //   223: lstore 13
    //   225: aload_1
    //   226: astore_3
    //   227: aload 20
    //   229: invokeinterface 522 1 0
    //   234: ifle +1595 -> 1829
    //   237: lload 9
    //   239: lstore 13
    //   241: aload_1
    //   242: astore_3
    //   243: aload 20
    //   245: invokeinterface 554 1 0
    //   250: astore 20
    //   252: iload 15
    //   254: istore 16
    //   256: lload 9
    //   258: lstore 11
    //   260: aload_1
    //   261: astore 19
    //   263: iload 4
    //   265: istore 5
    //   267: lload 9
    //   269: lstore 13
    //   271: aload_1
    //   272: astore_3
    //   273: aload 20
    //   275: invokeinterface 559 1 0
    //   280: ifeq +1549 -> 1829
    //   283: lload 9
    //   285: lstore 13
    //   287: aload_1
    //   288: astore_3
    //   289: aload 20
    //   291: invokeinterface 563 1 0
    //   296: checkcast 1602	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo
    //   299: astore 24
    //   301: lload 9
    //   303: lstore 13
    //   305: aload_1
    //   306: astore_3
    //   307: new 1604	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo
    //   310: dup
    //   311: invokespecial 1605	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:<init>	()V
    //   314: astore 25
    //   316: lload 9
    //   318: lstore 13
    //   320: aload_1
    //   321: astore_3
    //   322: aload 25
    //   324: aload 24
    //   326: getfield 1606	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   329: invokevirtual 179	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   332: invokestatic 1094	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   335: putfield 1609	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mUin	Ljava/lang/String;
    //   338: lload 9
    //   340: lstore 13
    //   342: aload_1
    //   343: astore_3
    //   344: aload 25
    //   346: aload 24
    //   348: getfield 1610	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:bytes_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   351: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   354: invokevirtual 267	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   357: putfield 1613	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mNickName	Ljava/lang/String;
    //   360: lload 9
    //   362: lstore 13
    //   364: aload_1
    //   365: astore_3
    //   366: aload 25
    //   368: aload 24
    //   370: getfield 1616	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   373: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   376: putfield 1619	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mGender	I
    //   379: lload 9
    //   381: lstore 13
    //   383: aload_1
    //   384: astore_3
    //   385: aload 24
    //   387: getfield 1622	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_is_my_like	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   390: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   393: istore 5
    //   395: iload 5
    //   397: iconst_1
    //   398: if_icmpne +9 -> 407
    //   401: iconst_1
    //   402: istore 16
    //   404: goto +6 -> 410
    //   407: iconst_0
    //   408: istore 16
    //   410: aload 25
    //   412: iload 16
    //   414: putfield 1625	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mLiked	Z
    //   417: aload 25
    //   419: aload 24
    //   421: getfield 1628	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_my_left_like_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   424: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   427: putfield 1631	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mAvailLikeCount	I
    //   430: aload 24
    //   432: getfield 1634	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_addfri_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   435: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   438: iconst_1
    //   439: if_icmpne +2045 -> 2484
    //   442: iconst_1
    //   443: istore 16
    //   445: goto +3 -> 448
    //   448: aload 25
    //   450: iload 16
    //   452: putfield 1637	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mAddFriendVerified	Z
    //   455: aload 25
    //   457: aload 24
    //   459: getfield 1638	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_popularity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   462: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   465: putfield 1641	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mPopularity	I
    //   468: aload 25
    //   470: aload 24
    //   472: getfield 1642	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:bytes_declaration	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   475: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   478: invokevirtual 267	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   481: putfield 1645	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mDeclaration	Ljava/lang/String;
    //   484: aload 25
    //   486: aload 24
    //   488: getfield 1646	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:bytes_voice_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   491: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   494: invokevirtual 267	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   497: putfield 1649	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mVoiceUrl	Ljava/lang/String;
    //   500: aload 25
    //   502: aload 24
    //   504: getfield 1650	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_voice_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   507: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   510: putfield 1653	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mVoiceDuration	I
    //   513: aload 24
    //   515: getfield 1656	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_vote_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   518: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   521: ifne +1969 -> 2490
    //   524: iconst_1
    //   525: istore 16
    //   527: goto +3 -> 530
    //   530: aload 25
    //   532: iload 16
    //   534: putfield 1659	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mbAllowStrangerVote	Z
    //   537: aload 25
    //   539: aload 24
    //   541: getfield 1662	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:str_recom_trace	Lcom/tencent/mobileqq/pb/PBStringField;
    //   544: invokevirtual 193	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   547: putfield 1665	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mStrRecomTrace	Ljava/lang/String;
    //   550: aload 25
    //   552: aload 24
    //   554: getfield 1668	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:bytes_voice_code	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   557: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   560: invokevirtual 311	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   563: putfield 1671	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:voiceCode	[B
    //   566: new 1673	com/tencent/pb/personal/PersonalInfo$ReqBody
    //   569: dup
    //   570: invokespecial 1674	com/tencent/pb/personal/PersonalInfo$ReqBody:<init>	()V
    //   573: astore_3
    //   574: aload_3
    //   575: aload 24
    //   577: getfield 1677	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:bytes_personalization	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   580: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   583: invokevirtual 311	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   586: invokevirtual 1681	com/tencent/pb/personal/PersonalInfo$ReqBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   589: pop
    //   590: aload 25
    //   592: aload_3
    //   593: getfield 1684	com/tencent/pb/personal/PersonalInfo$ReqBody:fontid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   596: invokevirtual 1685	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   599: putfield 1686	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:fontId	I
    //   602: aload 25
    //   604: aload_3
    //   605: getfield 1689	com/tencent/pb/personal/PersonalInfo$ReqBody:fonttype	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   608: invokevirtual 1685	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   611: putfield 1690	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:fontType	I
    //   614: aload 25
    //   616: aload_3
    //   617: getfield 1693	com/tencent/pb/personal/PersonalInfo$ReqBody:itemid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   620: invokevirtual 1685	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   623: putfield 1694	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:clothesId	I
    //   626: aload 25
    //   628: getfield 1645	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mDeclaration	Ljava/lang/String;
    //   631: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   634: istore 16
    //   636: iload 16
    //   638: ifne +60 -> 698
    //   641: aload 25
    //   643: getfield 1645	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mDeclaration	Ljava/lang/String;
    //   646: astore_3
    //   647: lload 9
    //   649: lstore 13
    //   651: aload_1
    //   652: astore 19
    //   654: lload 13
    //   656: lstore 11
    //   658: aload 25
    //   660: aload_3
    //   661: bipush 10
    //   663: bipush 32
    //   665: invokevirtual 1698	java/lang/String:replace	(CC)Ljava/lang/String;
    //   668: putfield 1645	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mDeclaration	Ljava/lang/String;
    //   671: aload_1
    //   672: astore 19
    //   674: lload 13
    //   676: lstore 11
    //   678: aload 25
    //   680: aload 25
    //   682: getfield 1645	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mDeclaration	Ljava/lang/String;
    //   685: invokevirtual 1329	java/lang/String:trim	()Ljava/lang/String;
    //   688: putfield 1645	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mDeclaration	Ljava/lang/String;
    //   691: goto +7 -> 698
    //   694: astore_3
    //   695: goto +1689 -> 2384
    //   698: aload_1
    //   699: astore_3
    //   700: lload 9
    //   702: lstore 11
    //   704: aload 24
    //   706: getfield 1701	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_show_vip_info_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   709: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   712: ifne +1784 -> 2496
    //   715: iconst_1
    //   716: istore 16
    //   718: goto +3 -> 721
    //   721: aload_1
    //   722: astore_3
    //   723: lload 9
    //   725: lstore 11
    //   727: aload 25
    //   729: iload 16
    //   731: putfield 1704	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mVipHide	Z
    //   734: aload_1
    //   735: astore_3
    //   736: lload 9
    //   738: lstore 11
    //   740: aload 24
    //   742: getfield 1707	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_bigvip_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   745: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   748: ifne +1754 -> 2502
    //   751: iconst_1
    //   752: istore 16
    //   754: goto +3 -> 757
    //   757: aload_1
    //   758: astore_3
    //   759: lload 9
    //   761: lstore 11
    //   763: aload 25
    //   765: iload 16
    //   767: putfield 1710	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mBigVipHide	Z
    //   770: aload_1
    //   771: astore_3
    //   772: lload 9
    //   774: lstore 11
    //   776: aload 25
    //   778: aload 24
    //   780: getfield 1713	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_bigvip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   783: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   786: putfield 1716	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mBigVipLevel	I
    //   789: aload_1
    //   790: astore_3
    //   791: lload 9
    //   793: lstore 11
    //   795: aload 25
    //   797: aload 24
    //   799: getfield 1719	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_vip_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   802: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   805: putfield 1722	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mVipType	I
    //   808: aload_1
    //   809: astore_3
    //   810: lload 9
    //   812: lstore 11
    //   814: aload 25
    //   816: aload 24
    //   818: getfield 1725	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_svip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   821: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   824: putfield 1728	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mVipLevel	I
    //   827: aload_1
    //   828: astore_3
    //   829: lload 9
    //   831: lstore 11
    //   833: aload 25
    //   835: aload 24
    //   837: getfield 1731	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_vipicon_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   840: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   843: putfield 1734	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mTemplateId	I
    //   846: aload_1
    //   847: astore_3
    //   848: lload 9
    //   850: lstore 11
    //   852: aload 24
    //   854: getfield 1737	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:bytes_ad_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   857: invokevirtual 259	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   860: istore 16
    //   862: iload 16
    //   864: ifeq +31 -> 895
    //   867: aload_1
    //   868: astore 19
    //   870: lload 9
    //   872: lstore 11
    //   874: aload 24
    //   876: getfield 1737	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:bytes_ad_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   879: invokevirtual 262	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   882: invokevirtual 311	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   885: invokestatic 1743	com/tencent/mobileqq/vas/adv/common/data/AlumBasicData:createFrombyte	([B)Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;
    //   888: astore_3
    //   889: aload_3
    //   890: astore 19
    //   892: goto +6 -> 898
    //   895: aconst_null
    //   896: astore 19
    //   898: aload_1
    //   899: astore_3
    //   900: lload 9
    //   902: lstore 11
    //   904: aload 25
    //   906: aload 19
    //   908: putfield 1747	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mAlumbasicdata	Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;
    //   911: aload_1
    //   912: astore_3
    //   913: lload 9
    //   915: lstore 11
    //   917: aload 25
    //   919: aload 24
    //   921: getfield 1748	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   924: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   927: putfield 1751	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mAge	I
    //   930: aload_1
    //   931: astore_3
    //   932: lload 9
    //   934: lstore 11
    //   936: aload 25
    //   938: new 339	java/util/ArrayList
    //   941: dup
    //   942: invokespecial 340	java/util/ArrayList:<init>	()V
    //   945: putfield 1755	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mLabelInfos	Ljava/util/List;
    //   948: aload_1
    //   949: astore_3
    //   950: lload 9
    //   952: lstore 11
    //   954: aload 24
    //   956: getfield 1758	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_label_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   959: invokevirtual 347	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   962: istore 16
    //   964: iload 4
    //   966: istore 5
    //   968: iload 16
    //   970: ifeq +198 -> 1168
    //   973: iconst_0
    //   974: istore 6
    //   976: iload 4
    //   978: istore 5
    //   980: aload_1
    //   981: astore 19
    //   983: lload 9
    //   985: lstore 11
    //   987: iload 6
    //   989: aload 24
    //   991: getfield 1758	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_label_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   994: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   997: invokeinterface 522 1 0
    //   1002: if_icmpge +166 -> 1168
    //   1005: aload_1
    //   1006: astore 19
    //   1008: lload 9
    //   1010: lstore 11
    //   1012: new 1760	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$LabelInfo
    //   1015: dup
    //   1016: invokespecial 1761	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$LabelInfo:<init>	()V
    //   1019: astore 26
    //   1021: aload_1
    //   1022: astore 19
    //   1024: lload 9
    //   1026: lstore 11
    //   1028: aload 26
    //   1030: aload 24
    //   1032: getfield 1758	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_label_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1035: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1038: iload 6
    //   1040: invokeinterface 1764 2 0
    //   1045: checkcast 1766	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$labelInfo
    //   1048: getfield 1769	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$labelInfo:uint64_label_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1051: invokevirtual 179	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1054: putfield 1770	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$LabelInfo:jdField_a_of_type_Long	J
    //   1057: aload_1
    //   1058: astore 19
    //   1060: lload 9
    //   1062: lstore 11
    //   1064: aload 24
    //   1066: getfield 1758	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_label_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1069: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1072: iload 6
    //   1074: invokeinterface 1764 2 0
    //   1079: checkcast 1766	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$labelInfo
    //   1082: getfield 1773	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$labelInfo:str_label_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1085: invokevirtual 359	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1088: ifeq +1420 -> 2508
    //   1091: aload_1
    //   1092: astore 19
    //   1094: lload 9
    //   1096: lstore 11
    //   1098: aload 24
    //   1100: getfield 1758	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_label_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1103: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1106: iload 6
    //   1108: invokeinterface 1764 2 0
    //   1113: checkcast 1766	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$labelInfo
    //   1116: getfield 1773	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$labelInfo:str_label_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1119: invokevirtual 193	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1122: astore_3
    //   1123: goto +3 -> 1126
    //   1126: aload_1
    //   1127: astore 19
    //   1129: lload 9
    //   1131: lstore 11
    //   1133: aload 26
    //   1135: aload_3
    //   1136: putfield 1774	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$LabelInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1139: aload_1
    //   1140: astore 19
    //   1142: lload 9
    //   1144: lstore 11
    //   1146: aload 25
    //   1148: getfield 1755	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mLabelInfos	Ljava/util/List;
    //   1151: aload 26
    //   1153: invokeinterface 1775 2 0
    //   1158: pop
    //   1159: iload 6
    //   1161: iconst_1
    //   1162: iadd
    //   1163: istore 6
    //   1165: goto -189 -> 976
    //   1168: aload_1
    //   1169: astore_3
    //   1170: lload 9
    //   1172: lstore 11
    //   1174: aload 25
    //   1176: new 339	java/util/ArrayList
    //   1179: dup
    //   1180: invokespecial 340	java/util/ArrayList:<init>	()V
    //   1183: putfield 1778	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mSchoolInfos	Ljava/util/List;
    //   1186: iload 15
    //   1188: istore 16
    //   1190: aload_1
    //   1191: astore_3
    //   1192: lload 9
    //   1194: lstore 11
    //   1196: aload 24
    //   1198: getfield 1779	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_school_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1201: invokevirtual 347	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   1204: ifeq +381 -> 1585
    //   1207: iconst_0
    //   1208: istore 4
    //   1210: iload 15
    //   1212: istore 16
    //   1214: aload_1
    //   1215: astore_3
    //   1216: lload 9
    //   1218: lstore 11
    //   1220: iload 4
    //   1222: aload 24
    //   1224: getfield 1779	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_school_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1227: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1230: invokeinterface 522 1 0
    //   1235: if_icmpge +350 -> 1585
    //   1238: aload_1
    //   1239: astore_3
    //   1240: lload 9
    //   1242: lstore 11
    //   1244: new 1781	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$SchoolInfo
    //   1247: dup
    //   1248: invokespecial 1782	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$SchoolInfo:<init>	()V
    //   1251: astore 26
    //   1253: aload_1
    //   1254: astore_3
    //   1255: lload 9
    //   1257: lstore 11
    //   1259: aload 26
    //   1261: aload 24
    //   1263: getfield 1779	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_school_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1266: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1269: iload 4
    //   1271: invokeinterface 1764 2 0
    //   1276: checkcast 1784	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$schoolInfo
    //   1279: getfield 1785	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$schoolInfo:str_school_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1282: invokevirtual 193	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1285: putfield 1786	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$SchoolInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1288: aload_1
    //   1289: astore_3
    //   1290: lload 9
    //   1292: lstore 11
    //   1294: aload 26
    //   1296: aload 24
    //   1298: getfield 1779	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_school_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1301: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1304: iload 4
    //   1306: invokeinterface 1764 2 0
    //   1311: checkcast 1784	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$schoolInfo
    //   1314: getfield 1787	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$schoolInfo:uint64_state	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1317: invokevirtual 179	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1320: putfield 1788	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$SchoolInfo:jdField_a_of_type_Long	J
    //   1323: aload_1
    //   1324: astore_3
    //   1325: lload 9
    //   1327: lstore 11
    //   1329: aload 24
    //   1331: getfield 1779	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_school_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1334: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1337: iload 4
    //   1339: invokeinterface 1764 2 0
    //   1344: checkcast 1784	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$schoolInfo
    //   1347: getfield 1789	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$schoolInfo:str_school_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1350: invokevirtual 359	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1353: istore 16
    //   1355: iload 16
    //   1357: ifeq +41 -> 1398
    //   1360: aload_1
    //   1361: astore 19
    //   1363: lload 9
    //   1365: lstore 11
    //   1367: aload 24
    //   1369: getfield 1779	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:rpt_school_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1372: invokevirtual 714	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1375: iload 4
    //   1377: invokeinterface 1764 2 0
    //   1382: checkcast 1784	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$schoolInfo
    //   1385: getfield 1789	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$schoolInfo:str_school_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1388: invokevirtual 193	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1391: astore_3
    //   1392: aload_3
    //   1393: astore 19
    //   1395: goto +6 -> 1401
    //   1398: aconst_null
    //   1399: astore 19
    //   1401: aload_1
    //   1402: astore_3
    //   1403: lload 9
    //   1405: lstore 11
    //   1407: aload 26
    //   1409: aload 19
    //   1411: putfield 1790	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$SchoolInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1414: aload_1
    //   1415: astore_3
    //   1416: lload 9
    //   1418: lstore 11
    //   1420: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1423: ifeq +1090 -> 2513
    //   1426: aload_1
    //   1427: astore_3
    //   1428: lload 9
    //   1430: lstore 11
    //   1432: new 32	java/lang/StringBuilder
    //   1435: dup
    //   1436: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   1439: astore 19
    //   1441: aload_1
    //   1442: astore_3
    //   1443: lload 9
    //   1445: lstore 11
    //   1447: aload 19
    //   1449: ldc_w 1792
    //   1452: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: pop
    //   1456: aload_1
    //   1457: astore_3
    //   1458: lload 9
    //   1460: lstore 11
    //   1462: aload 19
    //   1464: aload 26
    //   1466: getfield 1786	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$SchoolInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1469: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: pop
    //   1473: aload_1
    //   1474: astore_3
    //   1475: lload 9
    //   1477: lstore 11
    //   1479: aload 19
    //   1481: ldc_w 1794
    //   1484: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1487: pop
    //   1488: aload_1
    //   1489: astore_3
    //   1490: lload 9
    //   1492: lstore 11
    //   1494: aload 19
    //   1496: aload 26
    //   1498: getfield 1790	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$SchoolInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1501: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: aload_1
    //   1506: astore_3
    //   1507: lload 9
    //   1509: lstore 11
    //   1511: aload 19
    //   1513: ldc_w 1796
    //   1516: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: pop
    //   1520: aload_1
    //   1521: astore_3
    //   1522: lload 9
    //   1524: lstore 11
    //   1526: aload 19
    //   1528: aload 26
    //   1530: getfield 1788	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo$SchoolInfo:jdField_a_of_type_Long	J
    //   1533: invokevirtual 498	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1536: pop
    //   1537: aload_1
    //   1538: astore_3
    //   1539: lload 9
    //   1541: lstore 11
    //   1543: ldc 45
    //   1545: iconst_2
    //   1546: aload 19
    //   1548: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1551: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1554: goto +3 -> 1557
    //   1557: aload_1
    //   1558: astore_3
    //   1559: lload 9
    //   1561: lstore 11
    //   1563: aload 25
    //   1565: getfield 1778	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mSchoolInfos	Ljava/util/List;
    //   1568: aload 26
    //   1570: invokeinterface 1775 2 0
    //   1575: pop
    //   1576: iload 4
    //   1578: iconst_1
    //   1579: iadd
    //   1580: istore 4
    //   1582: goto -372 -> 1210
    //   1585: aload_1
    //   1586: astore_3
    //   1587: lload 9
    //   1589: lstore 11
    //   1591: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1594: ifeq +137 -> 1731
    //   1597: aload_1
    //   1598: astore_3
    //   1599: lload 9
    //   1601: lstore 11
    //   1603: new 32	java/lang/StringBuilder
    //   1606: dup
    //   1607: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   1610: astore 19
    //   1612: aload_1
    //   1613: astore_3
    //   1614: lload 9
    //   1616: lstore 11
    //   1618: aload 19
    //   1620: ldc_w 1798
    //   1623: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1626: pop
    //   1627: aload_1
    //   1628: astore_3
    //   1629: lload 9
    //   1631: lstore 11
    //   1633: aload 19
    //   1635: aload 25
    //   1637: getfield 1609	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mUin	Ljava/lang/String;
    //   1640: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: pop
    //   1644: aload_1
    //   1645: astore_3
    //   1646: lload 9
    //   1648: lstore 11
    //   1650: aload 19
    //   1652: ldc_w 474
    //   1655: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: pop
    //   1659: aload_1
    //   1660: astore_3
    //   1661: lload 9
    //   1663: lstore 11
    //   1665: aload 19
    //   1667: aload 24
    //   1669: getfield 1719	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_vip_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1672: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1675: invokevirtual 43	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1678: pop
    //   1679: aload_1
    //   1680: astore_3
    //   1681: lload 9
    //   1683: lstore 11
    //   1685: aload 19
    //   1687: ldc_w 474
    //   1690: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1693: pop
    //   1694: aload_1
    //   1695: astore_3
    //   1696: lload 9
    //   1698: lstore 11
    //   1700: aload 19
    //   1702: aload 24
    //   1704: getfield 1725	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$StrangerInfo:uint32_svip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1707: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1710: invokevirtual 43	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1713: pop
    //   1714: aload_1
    //   1715: astore_3
    //   1716: lload 9
    //   1718: lstore 11
    //   1720: ldc 45
    //   1722: iconst_2
    //   1723: aload 19
    //   1725: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1728: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1731: aload_1
    //   1732: astore_3
    //   1733: lload 9
    //   1735: lstore 11
    //   1737: aload 25
    //   1739: getfield 1613	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mNickName	Ljava/lang/String;
    //   1742: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1745: ifeq +65 -> 1810
    //   1748: aload_1
    //   1749: astore_3
    //   1750: lload 9
    //   1752: lstore 11
    //   1754: aload 25
    //   1756: getfield 1747	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mAlumbasicdata	Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;
    //   1759: ifnull +6 -> 1765
    //   1762: goto +48 -> 1810
    //   1765: aload_1
    //   1766: astore_3
    //   1767: lload 9
    //   1769: lstore 11
    //   1771: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1774: ifeq +742 -> 2516
    //   1777: aload_1
    //   1778: astore_3
    //   1779: lload 9
    //   1781: lstore 11
    //   1783: ldc 45
    //   1785: iconst_2
    //   1786: ldc_w 1800
    //   1789: iconst_1
    //   1790: anewarray 121	java/lang/Object
    //   1793: dup
    //   1794: iconst_0
    //   1795: aload 25
    //   1797: getfield 1609	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mUin	Ljava/lang/String;
    //   1800: aastore
    //   1801: invokestatic 528	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1804: invokestatic 605	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1807: goto +709 -> 2516
    //   1810: aload_1
    //   1811: astore_3
    //   1812: lload 9
    //   1814: lstore 11
    //   1816: aload 22
    //   1818: aload 25
    //   1820: invokeinterface 1775 2 0
    //   1825: pop
    //   1826: goto +690 -> 2516
    //   1829: lload 11
    //   1831: lstore 9
    //   1833: aload 19
    //   1835: astore_1
    //   1836: aload_1
    //   1837: astore_3
    //   1838: lload 9
    //   1840: lstore 11
    //   1842: new 1802	com/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo
    //   1845: dup
    //   1846: invokespecial 1803	com/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo:<init>	()V
    //   1849: astore 20
    //   1851: aload_1
    //   1852: astore_3
    //   1853: lload 9
    //   1855: lstore 11
    //   1857: aload 20
    //   1859: aload 23
    //   1861: getfield 1806	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:uint32_match_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1864: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1867: putfield 1807	com/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo:jdField_a_of_type_Int	I
    //   1870: aload_1
    //   1871: astore_3
    //   1872: lload 9
    //   1874: lstore 11
    //   1876: aload 20
    //   1878: aload 23
    //   1880: getfield 1810	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:uint32_match_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1883: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1886: putfield 1811	com/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo:jdField_b_of_type_Int	I
    //   1889: aload_1
    //   1890: astore_3
    //   1891: lload 9
    //   1893: lstore 11
    //   1895: aload 20
    //   1897: aload 23
    //   1899: getfield 1814	com/tencent/pb/extendfriend/ExtendFriendSquareInfo$RspBody:uint32_online_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1902: invokevirtual 214	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1905: putfield 1815	com/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo:jdField_c_of_type_Int	I
    //   1908: aload_1
    //   1909: astore_3
    //   1910: lload 9
    //   1912: lstore 11
    //   1914: new 339	java/util/ArrayList
    //   1917: dup
    //   1918: invokespecial 340	java/util/ArrayList:<init>	()V
    //   1921: astore 19
    //   1923: aload_1
    //   1924: astore_3
    //   1925: lload 9
    //   1927: lstore 11
    //   1929: aload 22
    //   1931: invokeinterface 522 1 0
    //   1936: istore 8
    //   1938: iload 8
    //   1940: bipush 12
    //   1942: if_icmpgt +22 -> 1964
    //   1945: aload_1
    //   1946: astore_3
    //   1947: lload 9
    //   1949: lstore 11
    //   1951: aload 19
    //   1953: aload 22
    //   1955: invokeinterface 737 2 0
    //   1960: pop
    //   1961: goto +597 -> 2558
    //   1964: aload_1
    //   1965: astore_3
    //   1966: lload 9
    //   1968: lstore 11
    //   1970: new 1817	java/util/Random
    //   1973: dup
    //   1974: invokespecial 1818	java/util/Random:<init>	()V
    //   1977: astore 23
    //   1979: iconst_0
    //   1980: istore 4
    //   1982: bipush 12
    //   1984: istore 6
    //   1986: iload 4
    //   1988: iload 8
    //   1990: if_icmpge +568 -> 2558
    //   1993: aload_1
    //   1994: astore_3
    //   1995: lload 9
    //   1997: lstore 11
    //   1999: iload 6
    //   2001: istore 7
    //   2003: aload 23
    //   2005: iload 8
    //   2007: iload 4
    //   2009: isub
    //   2010: invokevirtual 1821	java/util/Random:nextInt	(I)I
    //   2013: iload 6
    //   2015: if_icmpge +530 -> 2545
    //   2018: aload_1
    //   2019: astore_3
    //   2020: lload 9
    //   2022: lstore 11
    //   2024: aload 19
    //   2026: aload 22
    //   2028: iload 4
    //   2030: invokeinterface 1764 2 0
    //   2035: invokeinterface 1775 2 0
    //   2040: pop
    //   2041: iload 6
    //   2043: iconst_1
    //   2044: isub
    //   2045: istore 7
    //   2047: goto +498 -> 2545
    //   2050: aload_1
    //   2051: astore_3
    //   2052: lload 9
    //   2054: lstore 11
    //   2056: iload 4
    //   2058: aload 19
    //   2060: invokeinterface 522 1 0
    //   2065: if_icmpge +44 -> 2109
    //   2068: aload_1
    //   2069: astore_3
    //   2070: lload 9
    //   2072: lstore 11
    //   2074: aload 20
    //   2076: getfield 1823	com/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2079: aload 19
    //   2081: iload 4
    //   2083: invokeinterface 1764 2 0
    //   2088: checkcast 1604	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo
    //   2091: getfield 1609	com/tencent/mobileqq/qqexpand/bean/feed/StrangerInfo:mUin	Ljava/lang/String;
    //   2094: invokeinterface 1775 2 0
    //   2099: pop
    //   2100: iload 4
    //   2102: iconst_1
    //   2103: iadd
    //   2104: istore 4
    //   2106: goto -56 -> 2050
    //   2109: aload_0
    //   2110: astore_3
    //   2111: aload_1
    //   2112: astore 19
    //   2114: lload 9
    //   2116: lstore 11
    //   2118: aload_3
    //   2119: getfield 27	com/tencent/mobileqq/qqexpand/network/impl/ExpandHandlerImpl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2122: ifnull +29 -> 2151
    //   2125: aload_1
    //   2126: astore 19
    //   2128: lload 9
    //   2130: lstore 11
    //   2132: aload_3
    //   2133: getfield 27	com/tencent/mobileqq/qqexpand/network/impl/ExpandHandlerImpl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2136: getstatic 1143	com/tencent/mobileqq/app/QQManagerFactory:EXTEND_FRIEND_LIMIT_CHAT_MANAGER	I
    //   2139: invokevirtual 91	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2142: checkcast 1145	com/tencent/mobileqq/qqexpand/manager/ExtendFriendLimitChatManager
    //   2145: iconst_1
    //   2146: aload 20
    //   2148: invokevirtual 1826	com/tencent/mobileqq/qqexpand/manager/ExtendFriendLimitChatManager:a	(ZLcom/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo;)V
    //   2151: aload_1
    //   2152: astore 19
    //   2154: lload 9
    //   2156: lstore 11
    //   2158: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2161: ifeq +114 -> 2275
    //   2164: aload_1
    //   2165: astore 19
    //   2167: lload 9
    //   2169: lstore 11
    //   2171: ldc_w 330
    //   2174: iconst_2
    //   2175: ldc_w 1828
    //   2178: bipush 9
    //   2180: anewarray 121	java/lang/Object
    //   2183: dup
    //   2184: iconst_0
    //   2185: iload 16
    //   2187: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2190: aastore
    //   2191: dup
    //   2192: iconst_1
    //   2193: aload 21
    //   2195: aastore
    //   2196: dup
    //   2197: iconst_2
    //   2198: iload 17
    //   2200: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2203: aastore
    //   2204: dup
    //   2205: iconst_3
    //   2206: iload 18
    //   2208: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2211: aastore
    //   2212: dup
    //   2213: iconst_4
    //   2214: iload 5
    //   2216: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2219: aastore
    //   2220: dup
    //   2221: iconst_5
    //   2222: aload 22
    //   2224: invokeinterface 522 1 0
    //   2229: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2232: aastore
    //   2233: dup
    //   2234: bipush 6
    //   2236: aload 20
    //   2238: getfield 1807	com/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo:jdField_a_of_type_Int	I
    //   2241: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2244: aastore
    //   2245: dup
    //   2246: bipush 7
    //   2248: aload 20
    //   2250: getfield 1811	com/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo:jdField_b_of_type_Int	I
    //   2253: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2256: aastore
    //   2257: dup
    //   2258: bipush 8
    //   2260: aload 20
    //   2262: getfield 1815	com/tencent/mobileqq/qqexpand/bean/match/MatchFeedInfo:jdField_c_of_type_Int	I
    //   2265: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2268: aastore
    //   2269: invokestatic 528	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2272: invokestatic 382	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2275: aload_1
    //   2276: astore 19
    //   2278: lload 9
    //   2280: lstore 11
    //   2282: aload_3
    //   2283: iconst_2
    //   2284: iconst_1
    //   2285: bipush 9
    //   2287: anewarray 121	java/lang/Object
    //   2290: dup
    //   2291: iconst_0
    //   2292: lload 9
    //   2294: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2297: aastore
    //   2298: dup
    //   2299: iconst_1
    //   2300: aload_1
    //   2301: aastore
    //   2302: dup
    //   2303: iconst_2
    //   2304: iload 16
    //   2306: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2309: aastore
    //   2310: dup
    //   2311: iconst_3
    //   2312: aload 21
    //   2314: aastore
    //   2315: dup
    //   2316: iconst_4
    //   2317: iload 17
    //   2319: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2322: aastore
    //   2323: dup
    //   2324: iconst_5
    //   2325: iload 18
    //   2327: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2330: aastore
    //   2331: dup
    //   2332: bipush 6
    //   2334: iload 5
    //   2336: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2339: aastore
    //   2340: dup
    //   2341: bipush 7
    //   2343: aload 22
    //   2345: aastore
    //   2346: dup
    //   2347: bipush 8
    //   2349: aload 20
    //   2351: aastore
    //   2352: invokevirtual 516	com/tencent/mobileqq/qqexpand/network/impl/ExpandHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   2355: goto +96 -> 2451
    //   2358: astore_3
    //   2359: aload 19
    //   2361: astore_1
    //   2362: lload 11
    //   2364: lstore 9
    //   2366: goto +18 -> 2384
    //   2369: astore 19
    //   2371: lload 11
    //   2373: lstore 9
    //   2375: aload_3
    //   2376: astore_1
    //   2377: aload 19
    //   2379: astore_3
    //   2380: goto +4 -> 2384
    //   2383: astore_3
    //   2384: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2387: ifeq +17 -> 2404
    //   2390: ldc 45
    //   2392: iconst_2
    //   2393: aload_3
    //   2394: invokevirtual 875	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2397: aload_3
    //   2398: invokestatic 1830	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2401: goto +3 -> 2404
    //   2404: aload_0
    //   2405: iconst_2
    //   2406: iconst_0
    //   2407: iconst_2
    //   2408: anewarray 121	java/lang/Object
    //   2411: dup
    //   2412: iconst_0
    //   2413: lload 9
    //   2415: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2418: aastore
    //   2419: dup
    //   2420: iconst_1
    //   2421: aload_1
    //   2422: aastore
    //   2423: invokevirtual 516	com/tencent/mobileqq/qqexpand/network/impl/ExpandHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   2426: goto +25 -> 2451
    //   2429: aload_0
    //   2430: iconst_2
    //   2431: iconst_0
    //   2432: iconst_2
    //   2433: anewarray 121	java/lang/Object
    //   2436: dup
    //   2437: iconst_0
    //   2438: lload 9
    //   2440: invokestatic 132	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2443: aastore
    //   2444: dup
    //   2445: iconst_1
    //   2446: aload_1
    //   2447: aastore
    //   2448: invokevirtual 516	com/tencent/mobileqq/qqexpand/network/impl/ExpandHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   2451: invokestatic 1835	com/tencent/mobileqq/extendfriend/utils/ExtendFriendReport:a	()Lcom/tencent/mobileqq/extendfriend/utils/ExtendFriendReport;
    //   2454: aload_2
    //   2455: invokevirtual 1838	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   2458: aload_2
    //   2459: invokevirtual 1015	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   2462: invokevirtual 1841	com/tencent/mobileqq/extendfriend/utils/ExtendFriendReport:c	(ZI)V
    //   2465: return
    //   2466: iconst_0
    //   2467: istore 15
    //   2469: goto -2361 -> 108
    //   2472: iconst_0
    //   2473: istore 17
    //   2475: goto -2336 -> 139
    //   2478: iconst_0
    //   2479: istore 18
    //   2481: goto -2324 -> 157
    //   2484: iconst_0
    //   2485: istore 16
    //   2487: goto -2039 -> 448
    //   2490: iconst_0
    //   2491: istore 16
    //   2493: goto -1963 -> 530
    //   2496: iconst_0
    //   2497: istore 16
    //   2499: goto -1778 -> 721
    //   2502: iconst_0
    //   2503: istore 16
    //   2505: goto -1748 -> 757
    //   2508: aconst_null
    //   2509: astore_3
    //   2510: goto -1384 -> 1126
    //   2513: goto -956 -> 1557
    //   2516: iload 16
    //   2518: istore 15
    //   2520: iload 5
    //   2522: istore 4
    //   2524: goto -2272 -> 252
    //   2527: astore_3
    //   2528: goto -148 -> 2380
    //   2531: astore 19
    //   2533: lload 13
    //   2535: lstore 9
    //   2537: aload_3
    //   2538: astore_1
    //   2539: aload 19
    //   2541: astore_3
    //   2542: goto -162 -> 2380
    //   2545: iload 4
    //   2547: iconst_1
    //   2548: iadd
    //   2549: istore 4
    //   2551: iload 7
    //   2553: istore 6
    //   2555: goto -569 -> 1986
    //   2558: iconst_0
    //   2559: istore 4
    //   2561: goto -511 -> 2050
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2564	0	this	ExpandHandlerImpl
    //   0	2564	1	paramToServiceMsg	ToServiceMsg
    //   0	2564	2	paramFromServiceMsg	FromServiceMsg
    //   0	2564	3	paramObject	Object
    //   16	2544	4	i	int
    //   199	2322	5	j	int
    //   974	1580	6	k	int
    //   2001	551	7	m	int
    //   1936	74	8	n	int
    //   29	2507	9	l1	long
    //   192	2180	11	l2	long
    //   223	2311	13	l3	long
    //   103	2416	15	bool1	boolean
    //   188	2329	16	bool2	boolean
    //   134	2340	17	bool3	boolean
    //   152	2328	18	bool4	boolean
    //   195	2165	19	localObject1	Object
    //   2369	9	19	localException1	Exception
    //   2531	9	19	localException2	Exception
    //   175	2175	20	localObject2	Object
    //   119	2194	21	arrayOfByte	byte[]
    //   184	2160	22	localArrayList	ArrayList
    //   7	1997	23	localObject3	Object
    //   299	1404	24	localStrangerInfo	com.tencent.pb.extendfriend.ExtendFriendSquareInfo.StrangerInfo
    //   314	1505	25	localStrangerInfo1	StrangerInfo
    //   1019	550	26	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   641	647	694	java/lang/Exception
    //   658	671	2358	java/lang/Exception
    //   678	691	2358	java/lang/Exception
    //   874	889	2358	java/lang/Exception
    //   987	1005	2358	java/lang/Exception
    //   1012	1021	2358	java/lang/Exception
    //   1028	1057	2358	java/lang/Exception
    //   1064	1091	2358	java/lang/Exception
    //   1098	1123	2358	java/lang/Exception
    //   1133	1139	2358	java/lang/Exception
    //   1146	1159	2358	java/lang/Exception
    //   1367	1392	2358	java/lang/Exception
    //   2118	2125	2358	java/lang/Exception
    //   2132	2151	2358	java/lang/Exception
    //   2158	2164	2358	java/lang/Exception
    //   2171	2275	2358	java/lang/Exception
    //   2282	2355	2358	java/lang/Exception
    //   704	715	2369	java/lang/Exception
    //   727	734	2369	java/lang/Exception
    //   740	751	2369	java/lang/Exception
    //   763	770	2369	java/lang/Exception
    //   776	789	2369	java/lang/Exception
    //   795	808	2369	java/lang/Exception
    //   814	827	2369	java/lang/Exception
    //   833	846	2369	java/lang/Exception
    //   852	862	2369	java/lang/Exception
    //   904	911	2369	java/lang/Exception
    //   917	930	2369	java/lang/Exception
    //   936	948	2369	java/lang/Exception
    //   954	964	2369	java/lang/Exception
    //   1174	1186	2369	java/lang/Exception
    //   1196	1207	2369	java/lang/Exception
    //   1220	1238	2369	java/lang/Exception
    //   1244	1253	2369	java/lang/Exception
    //   1259	1288	2369	java/lang/Exception
    //   1294	1323	2369	java/lang/Exception
    //   1329	1355	2369	java/lang/Exception
    //   1407	1414	2369	java/lang/Exception
    //   1420	1426	2369	java/lang/Exception
    //   1432	1441	2369	java/lang/Exception
    //   1447	1456	2369	java/lang/Exception
    //   1462	1473	2369	java/lang/Exception
    //   1479	1488	2369	java/lang/Exception
    //   1494	1505	2369	java/lang/Exception
    //   1511	1520	2369	java/lang/Exception
    //   1526	1537	2369	java/lang/Exception
    //   1543	1554	2369	java/lang/Exception
    //   1563	1576	2369	java/lang/Exception
    //   1591	1597	2369	java/lang/Exception
    //   1603	1612	2369	java/lang/Exception
    //   1618	1627	2369	java/lang/Exception
    //   1633	1644	2369	java/lang/Exception
    //   1650	1659	2369	java/lang/Exception
    //   1665	1679	2369	java/lang/Exception
    //   1685	1694	2369	java/lang/Exception
    //   1700	1714	2369	java/lang/Exception
    //   1720	1731	2369	java/lang/Exception
    //   1737	1748	2369	java/lang/Exception
    //   1754	1762	2369	java/lang/Exception
    //   1771	1777	2369	java/lang/Exception
    //   1783	1807	2369	java/lang/Exception
    //   1816	1826	2369	java/lang/Exception
    //   1842	1851	2369	java/lang/Exception
    //   1857	1870	2369	java/lang/Exception
    //   1876	1889	2369	java/lang/Exception
    //   1895	1908	2369	java/lang/Exception
    //   1914	1923	2369	java/lang/Exception
    //   1929	1938	2369	java/lang/Exception
    //   1951	1961	2369	java/lang/Exception
    //   1970	1979	2369	java/lang/Exception
    //   2003	2018	2369	java/lang/Exception
    //   2024	2041	2369	java/lang/Exception
    //   2056	2068	2369	java/lang/Exception
    //   2074	2100	2369	java/lang/Exception
    //   90	102	2383	java/lang/Exception
    //   108	133	2383	java/lang/Exception
    //   139	151	2383	java/lang/Exception
    //   157	186	2383	java/lang/Exception
    //   410	442	2527	java/lang/Exception
    //   448	524	2527	java/lang/Exception
    //   530	636	2527	java/lang/Exception
    //   227	237	2531	java/lang/Exception
    //   243	252	2531	java/lang/Exception
    //   273	283	2531	java/lang/Exception
    //   289	301	2531	java/lang/Exception
    //   307	316	2531	java/lang/Exception
    //   322	338	2531	java/lang/Exception
    //   344	360	2531	java/lang/Exception
    //   366	379	2531	java/lang/Exception
    //   385	395	2531	java/lang/Exception
  }
  
  public boolean b(String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getUnlimitMatchBaseInfo. uin = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new oidb_0xe03.ReqBody();
      ((oidb_0xe03.ReqBody)localObject1).uint64_uin.set(a(paramString, "getUnlimitMatchBaseInfo"));
      ((oidb_0xe03.ReqBody)localObject1).enum_matchopcode.set(3);
      ((oidb_0xe03.ReqBody)localObject1).uint64_client_version.set(833L);
      paramString = (ExpandManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramString != null)
      {
        Object localObject2 = paramString.a();
        if (localObject2 != null)
        {
          paramString = new oidb_0xe03.GPS();
          paramString.int32_lon.set(((ExtendFriendLocationInfo)localObject2).jdField_b_of_type_Int);
          paramString.int32_lat.set(((ExtendFriendLocationInfo)localObject2).jdField_a_of_type_Int);
          paramString.int32_alt.set(((ExtendFriendLocationInfo)localObject2).jdField_c_of_type_Int);
          paramString.int32_type.set(((ExtendFriendLocationInfo)localObject2).d);
          localObject2 = new oidb_0xe03.LBSInfo();
          ((oidb_0xe03.LBSInfo)localObject2).msg_gps.set(paramString);
          ((oidb_0xe03.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
          QLog.d("ExpandHandlerImpl", 1, "getUnlimitMatchBaseInfo. with msg_lbs_info info ");
        }
      }
      paramString = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, ((oidb_0xe03.ReqBody)localObject1).toByteArray());
      paramString.extraData.putInt("match_op", 3);
      sendPbReq(paramString);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("requestMatch. error = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    QLog.i("ExpandHandlerImpl", 1, String.format("handleGetExtendFriendInfo resultCode=%d", new Object[] { Integer.valueOf(i) }));
    Object localObject2 = null;
    String str1 = null;
    Object localObject1 = null;
    if (i == 1000) {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label1296;
        }
        bool1 = true;
        paramObject = new StringBuilder();
        paramObject.append("handleGetExtendFriendInfo isSuccess=");
        paramObject.append(bool1);
        QLog.i("ExpandHandlerImpl", 1, paramObject.toString());
        if ((bool1) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
        {
          GetExtendFriendInfo.RspBody localRspBody = new GetExtendFriendInfo.RspBody();
          localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          String str3 = paramToServiceMsg.extraData.getString("uin");
          if ((localRspBody.uint64_uin.has()) && (String.valueOf(localRspBody.uint64_uin.get()).equals(str3)))
          {
            bool2 = localRspBody.bytes_declaration.has();
            if (bool2)
            {
              try
              {
                paramObject = localRspBody.bytes_declaration.get().toStringUtf8();
              }
              catch (InvalidProtocolBufferMicroException paramObject)
              {
                paramFromServiceMsg = null;
              }
              continue;
            }
            else
            {
              paramObject = null;
            }
            bool2 = localRspBody.bytes_voice_url.has();
            if (bool2) {
              localObject1 = localRspBody.bytes_voice_url.get().toStringUtf8();
            } else {
              localObject1 = null;
            }
            bool2 = localRspBody.uint32_popularity.has();
            if (bool2) {
              i = localRspBody.uint32_popularity.get();
            } else {
              i = 0;
            }
            bool2 = localRspBody.uint64_update_time.has();
            long l1;
            if (bool2) {
              l1 = localRspBody.uint64_update_time.get();
            } else {
              l1 = 0L;
            }
            bool2 = localRspBody.uint32_voice_duration.has();
            int j;
            if (bool2) {
              j = localRspBody.uint32_voice_duration.get();
            } else {
              j = 0;
            }
            paramFromServiceMsg = new PersonalInfo.ReqBody();
            paramFromServiceMsg.mergeFrom(localRspBody.bytes_personalization.get().toByteArray());
            int n = paramFromServiceMsg.fontid.get();
            int i1 = paramFromServiceMsg.fonttype.get();
            int i2 = paramFromServiceMsg.itemid.get();
            bool2 = localRspBody.rpt_school_info.has();
            String str2;
            long l2;
            int m;
            int k;
            if ((bool2) && (((GetExtendFriendInfo.schoolInfo)localRspBody.rpt_school_info.get().get(0)).has()))
            {
              paramFromServiceMsg = (GetExtendFriendInfo.schoolInfo)localRspBody.rpt_school_info.get().get(0);
              str2 = paramFromServiceMsg.str_school_id.get();
              str1 = paramFromServiceMsg.str_school_name.get();
              l2 = paramFromServiceMsg.uint64_state.get();
              m = paramFromServiceMsg.uint32_idx.get();
              k = paramFromServiceMsg.uint32_category.get();
            }
            else
            {
              str1 = null;
              str2 = str1;
              l2 = -1L;
              m = -1;
              k = -1;
            }
            try
            {
              Card localCard = a(str3, paramObject, (String)localObject1, i, l1, j, n, i1, i2, str2, str1, l2, m, k);
              paramFromServiceMsg = new StrangerInfo();
              try
              {
                paramFromServiceMsg.mUin = str3;
                paramFromServiceMsg.mDeclaration = paramObject;
                paramFromServiceMsg.mVoiceUrl = ((String)localObject1);
                paramFromServiceMsg.mPopularity = i;
                paramFromServiceMsg.mVoiceDuration = j;
                paramFromServiceMsg.mGender = localRspBody.uint32_gender.get();
                paramFromServiceMsg.mNickName = localRspBody.str_nick.get();
                if (localRspBody.uint32_show_vip_info_flag.get() != 0) {
                  break label1302;
                }
                bool2 = true;
                paramFromServiceMsg.mVipHide = bool2;
                if (localRspBody.uint32_bigvip_open.get() != 0) {
                  break label1308;
                }
                bool2 = true;
                paramFromServiceMsg.mBigVipHide = bool2;
                paramFromServiceMsg.mBigVipLevel = localRspBody.uint32_bigvip_level.get();
                paramFromServiceMsg.mVipType = localRspBody.uint32_vip_flag.get();
                paramFromServiceMsg.mVipLevel = localRspBody.uint32_svip_level.get();
                paramFromServiceMsg.mTemplateId = localRspBody.uint32_vipicon_id.get();
                if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)))
                {
                  paramFromServiceMsg.mSchoolInfos = new ArrayList();
                  paramObject = new StrangerInfo.SchoolInfo();
                  paramObject.jdField_b_of_type_JavaLangString = str1;
                  paramObject.jdField_a_of_type_JavaLangString = str2;
                  paramObject.jdField_a_of_type_Long = l2;
                }
                paramFromServiceMsg.mLabelInfos = new ArrayList();
                if (localRspBody.rpt_label_info.has())
                {
                  i = 0;
                  if (i < localRspBody.rpt_label_info.get().size())
                  {
                    localObject1 = new StrangerInfo.LabelInfo();
                    ((StrangerInfo.LabelInfo)localObject1).jdField_a_of_type_Long = ((GetExtendFriendInfo.labelInfo)localRspBody.rpt_label_info.get().get(i)).uint64_label_id.get();
                    if (!((GetExtendFriendInfo.labelInfo)localRspBody.rpt_label_info.get().get(i)).str_label_name.has()) {
                      break label1314;
                    }
                    paramObject = ((GetExtendFriendInfo.labelInfo)localRspBody.rpt_label_info.get().get(i)).str_label_name.get();
                    ((StrangerInfo.LabelInfo)localObject1).jdField_a_of_type_JavaLangString = paramObject;
                    paramFromServiceMsg.mLabelInfos.add(localObject1);
                    i += 1;
                    continue;
                  }
                }
                if (QLog.isColorLevel())
                {
                  paramObject = new StringBuilder();
                  paramObject.append("handleGetExtendFriendInfo: ");
                  paramObject.append(paramFromServiceMsg.mUin);
                  paramObject.append(" ");
                  paramObject.append(localRspBody.uint32_show_vip_info_flag.get());
                  paramObject.append(" ");
                  paramObject.append(localRspBody.uint32_vip_flag.get());
                  paramObject.append(" ");
                  paramObject.append(localRspBody.uint32_svip_level.get());
                  paramObject = paramObject.toString();
                  try
                  {
                    QLog.d("ExpandHandlerImpl", 2, paramObject);
                  }
                  catch (InvalidProtocolBufferMicroException paramObject)
                  {
                    continue;
                  }
                }
                paramObject = paramFromServiceMsg;
                paramFromServiceMsg = localCard;
              }
              catch (InvalidProtocolBufferMicroException paramObject) {}
            }
            catch (InvalidProtocolBufferMicroException paramObject)
            {
              continue;
            }
          }
        }
        paramFromServiceMsg = null;
        paramObject = localObject1;
        localObject1 = paramFromServiceMsg;
        paramFromServiceMsg = paramObject;
        paramObject = localObject1;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramFromServiceMsg = null;
        paramObject.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleGetExtendFriendInfo exception:");
        ((StringBuilder)localObject1).append(paramObject.getMessage());
        QLog.e("ExpandHandlerImpl", 1, ((StringBuilder)localObject1).toString());
        bool1 = false;
        paramObject = localObject2;
      }
      localObject1 = paramFromServiceMsg;
      paramFromServiceMsg = paramObject;
      paramObject = localObject1;
      break label1189;
      QLog.e("ExpandHandlerImpl", 1, String.format("handleGetExtendFriendInfo errMsg=%s", new Object[] { paramFromServiceMsg.getStringForLog() }));
      paramFromServiceMsg = null;
      boolean bool1 = false;
      paramObject = str1;
      label1189:
      if (!paramToServiceMsg.extraData.getBoolean("onlyStrangerInfo", false))
      {
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramFromServiceMsg == null) {
            bool2 = false;
          }
        }
        notifyUI(3, bool2, new Object[] { paramFromServiceMsg, Integer.valueOf(paramToServiceMsg.extraData.getInt("getStrangerInfoSeq", 0)) });
        bool1 = bool2;
      }
      notifyUI(9, bool1, new Object[] { paramObject, Integer.valueOf(paramToServiceMsg.extraData.getInt("getStrangerInfoSeq", 0)) });
      return;
      label1296:
      bool1 = false;
      continue;
      label1302:
      boolean bool2 = false;
      continue;
      label1308:
      bool2 = false;
      continue;
      label1314:
      paramObject = null;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new cmd0xcb5.RspBody());
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleReportUserResponse, result = ");
        paramToServiceMsg.append(i);
        QLog.d("ExpandHandlerImpl", 2, paramToServiceMsg.toString());
      }
      return;
    }
    QLog.d("ExpandHandlerImpl", 1, "handleReportUserResponse error!");
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xdb1.RspBody localRspBody = new oidb_0xdb1.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ExpandHandlerImplexpand.enter.", 2, new Object[] { "handlePlusSettingResponse. result = ", Integer.valueOf(i) });
    }
    boolean bool1;
    if (paramToServiceMsg != null) {
      bool1 = paramToServiceMsg.extraData.getBoolean("request_from_login", false);
    } else {
      bool1 = false;
    }
    paramToServiceMsg = "";
    if (i == 0)
    {
      long l1;
      if (localRspBody.uint64_allow_kuolie.has()) {
        l1 = localRspBody.uint64_allow_kuolie.get();
      } else {
        l1 = 0L;
      }
      if (localRspBody.uint32_match_count.has()) {
        i = localRspBody.uint32_match_count.get();
      } else {
        i = -1;
      }
      if (localRspBody.str_func_name.has()) {
        paramToServiceMsg = localRspBody.str_func_name.get();
      }
      boolean bool2 = localRspBody.uint64_expire_time.has();
      long l3 = -1L;
      long l2;
      if (bool2) {
        l2 = localRspBody.uint64_expire_time.get();
      } else {
        l2 = -1L;
      }
      int j;
      if (localRspBody.uint32_left_chat_time.has()) {
        j = localRspBody.uint32_left_chat_time.get();
      } else {
        j = -1;
      }
      if (l1 != 0L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramObject != null) {
        if (bool1)
        {
          ExpandChatUtil.a(paramObject, bool2, j, i, paramToServiceMsg, l2);
          if (bool2)
          {
            notifyUI(18, true, null);
            QLog.i("ExpandHandlerImplexpand.enter.", 1, " refresh entry");
            ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
        else
        {
          QLog.d("ExpandHandlerImplexpand.enter.", 2, "handlePlusSettingResponse.  by voicematch not notify");
        }
      }
      if (localRspBody.uint64_voice_match_flag.has()) {
        l3 = localRspBody.uint64_voice_match_flag.get();
      }
      boolean bool3;
      if (l3 == 1L) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      ExtendFriendLimitChatManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Boolean.valueOf(bool3));
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handlePlusSettingResponse. lShow = ");
        paramObject.append(l1);
        paramObject.append(" leftCount = ");
        paramObject.append(i);
        paramObject.append(" funcName = ");
        paramObject.append(paramToServiceMsg);
        paramObject.append(" expireTime=");
        paramObject.append(l2);
        paramObject.append(" chatTime:");
        paramObject.append(j);
        paramObject.append(" voiceMatch: ");
        paramObject.append(l3);
        paramObject.append(" FromLogginStep ");
        paramObject.append(bool1);
        QLog.d("ExpandHandlerImplexpand.enter.", 2, paramObject.toString());
      }
      notifyUI(10, true, new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), paramToServiceMsg, Long.valueOf(l2), Integer.valueOf(j) });
      a(paramFromServiceMsg, localRspBody);
      return;
    }
    notifyUI(10, false, new Object[] { Boolean.valueOf(false), Integer.valueOf(-1), "", Integer.valueOf(-1), Integer.valueOf(-1) });
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handlePlusSettingResponse.  false result：");
      paramToServiceMsg.append(i);
      QLog.d("ExpandHandlerImplexpand.enter.", 2, paramToServiceMsg.toString());
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("ExpandHandlerImpl", 2, " handleUnLimitResponse request null");
      return;
    }
    String str = paramToServiceMsg.getUin();
    Object localObject1 = getCurrentAccountUin();
    int i = paramToServiceMsg.extraData.getInt("match_op");
    int j = a(i);
    if (!TextUtils.equals((CharSequence)localObject1, str))
    {
      QLog.e("ExpandHandlerImpl", 2, " handleUnLimitResponse Wrong uin");
      return;
    }
    boolean bool1 = false;
    if (paramFromServiceMsg == null)
    {
      notifyUI(j, false, null);
      return;
    }
    oidb_0xe03.RspBody localRspBody = new oidb_0xe03.RspBody();
    j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handleMatchResponse. uin = ");
      paramObject.append(str);
      paramObject.append(" match_op = ");
      paramObject.append(i);
      paramObject.append(" result = ");
      paramObject.append(j);
      QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, paramObject.toString());
    }
    if (localRspBody.enum_matchopcode.has()) {
      i = localRspBody.enum_matchopcode.get();
    }
    int m = a(i);
    if (j == 0)
    {
      localObject1 = "";
      int k;
      Object localObject2;
      long l1;
      if ((m != 11) && (m != 15)) {
        if (m == 12)
        {
          if (localRspBody.enum_matchopretcode.has()) {
            j = localRspBody.enum_matchopretcode.get();
          } else {
            j = -1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse TYPE_CANCLE_UNLIMIT_MATCH. uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j) });
          }
          if (j == 0) {
            bool1 = true;
          }
          notifyUI(12, bool1, null);
        }
        else if (m == 13)
        {
          if (localRspBody.uint32_switch.has()) {
            j = localRspBody.uint32_switch.get();
          } else {
            j = 0;
          }
          paramObject = new ArrayList();
          if (localRspBody.rpt_tag.has())
          {
            k = 0;
            while (k < localRspBody.rpt_tag.size())
            {
              localObject1 = new TagInfo();
              localObject2 = (oidb_0xe03.TagInfo)localRspBody.rpt_tag.get(k);
              ((TagInfo)localObject1).jdField_a_of_type_Int = ((oidb_0xe03.TagInfo)localObject2).uint32_tag_id.get();
              if (((oidb_0xe03.TagInfo)localObject2).bytes_tag.has()) {
                paramToServiceMsg = ((oidb_0xe03.TagInfo)localObject2).bytes_tag.get().toStringUtf8();
              } else {
                paramToServiceMsg = "";
              }
              ((TagInfo)localObject1).jdField_a_of_type_JavaLangString = paramToServiceMsg;
              if (((oidb_0xe03.TagInfo)localObject2).uint32_hot_flag.has()) {
                m = ((oidb_0xe03.TagInfo)localObject2).uint32_hot_flag.get();
              } else {
                m = 0;
              }
              ((TagInfo)localObject1).jdField_b_of_type_Int = m;
              paramObject.add(localObject1);
              k += 1;
            }
          }
          if (localRspBody.uint32_count.has()) {
            k = localRspBody.uint32_count.get();
          } else {
            k = 1212432;
          }
          paramToServiceMsg = new ArrayList();
          if (localRspBody.uint64_uin_list.has())
          {
            m = 0;
            while (m < localRspBody.uint64_uin_list.size())
            {
              paramToServiceMsg.add(((Long)localRspBody.uint64_uin_list.get(m)).toString());
              m += 1;
            }
          }
          if (j != 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (localRspBody.uint64_voice_match_flag.has()) {
            l1 = localRspBody.uint64_voice_match_flag.get();
          } else {
            l1 = -1L;
          }
          long l2;
          if (localRspBody.uint32_flare_switch.has()) {
            l2 = localRspBody.uint32_flare_switch.get();
          } else {
            l2 = -1L;
          }
          boolean bool2;
          if (l1 == 1L) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          boolean bool3;
          if (l2 == 1L) {
            bool3 = true;
          } else {
            bool3 = false;
          }
          notifyUI(13, true, new Object[] { paramObject, Boolean.valueOf(bool1), Integer.valueOf(k), paramToServiceMsg, Boolean.valueOf(bool3) });
          ExtendFriendLimitChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Boolean.valueOf(bool1));
          ExtendFriendLimitChatManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Boolean.valueOf(bool2));
          ExtendFriendLimitChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(" tagList  :");
            ((StringBuilder)localObject1).append(paramObject.toString());
            ((StringBuilder)localObject1).append(" 勿扰 switch:");
            ((StringBuilder)localObject1).append(bool1);
            ((StringBuilder)localObject1).append(" voiceMatchF: ");
            ((StringBuilder)localObject1).append(l1);
            ((StringBuilder)localObject1).append(" bSingalBombFlagOpen");
            ((StringBuilder)localObject1).append(l2);
            ((StringBuilder)localObject1).append(" uinList size");
            ((StringBuilder)localObject1).append(paramToServiceMsg.size());
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_GET_UNLIMIT_TAG uin = ", str, ", match_op = ", ((StringBuilder)localObject1).toString() });
          }
        }
        else if (m == 14)
        {
          bool1 = paramToServiceMsg.extraData.getBoolean("open", false);
          if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_SET_UNLIMIT_SWITCH uin = ", str, ", open = ", Boolean.valueOf(bool1) });
          }
          ExtendFriendLimitChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Boolean.valueOf(bool1));
          notifyUI(14, true, null);
        }
        else
        {
          if (m != 15) {
            break label1092;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_GET_UNLIMIT_FRIEND_INFO uin = ", str, ", match_op = ", Integer.valueOf(i) });
          }
        }
      }
      for (;;)
      {
        break;
        label1092:
        if (m == 24)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_OPEN_SIGNAL_BOMB    match_op = ", Integer.valueOf(i) });
          }
        }
        else if (m == 25)
        {
          ((IExpandManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).g();
          if (QLog.isColorLevel())
          {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, new Object[] { "handleMatchResponse. TYPE_CLOSE_SIGNAL_BOMB   match_op = ", Integer.valueOf(i) });
            continue;
            int n = paramToServiceMsg.extraData.getInt("uin_type", 1044);
            if (localRspBody.enum_matchopretcode.has()) {
              j = localRspBody.enum_matchopretcode.get();
            } else {
              j = -1;
            }
            if (localRspBody.bytes_match_fail_wording.has()) {
              paramObject = localRspBody.bytes_match_fail_wording.get().toStringUtf8();
            } else {
              paramObject = "";
            }
            paramToServiceMsg = (ExpandManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.a(localRspBody);
            }
            if (localRspBody.msg_match_info.has())
            {
              oidb_0xe03.MatchInfo localMatchInfo = (oidb_0xe03.MatchInfo)localRspBody.msg_match_info.get();
              localObject2 = new MatchInfo();
              ((MatchInfo)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(localRspBody.uint64_uin.get());
              ((MatchInfo)localObject2).jdField_a_of_type_ArrayOfByte = localMatchInfo.bytes_sig.get().toByteArray();
              if (localMatchInfo.uint64_match_uin.has()) {
                paramToServiceMsg = String.valueOf(localMatchInfo.uint64_match_uin.get());
              } else {
                paramToServiceMsg = "0";
              }
              ((MatchInfo)localObject2).jdField_b_of_type_JavaLangString = paramToServiceMsg;
              if (localMatchInfo.bytes_tips_wording.has()) {
                paramToServiceMsg = localMatchInfo.bytes_tips_wording.get().toStringUtf8();
              } else {
                paramToServiceMsg = "";
              }
              ((MatchInfo)localObject2).jdField_c_of_type_JavaLangString = paramToServiceMsg;
              if (localMatchInfo.uint64_time_stamp.has()) {
                l1 = localMatchInfo.uint64_time_stamp.get();
              } else {
                l1 = -1L;
              }
              ((MatchInfo)localObject2).jdField_a_of_type_Long = l1;
              if (localMatchInfo.uint32_match_expired_time.has()) {
                k = localMatchInfo.uint32_match_expired_time.get();
              } else {
                k = 30;
              }
              ((MatchInfo)localObject2).jdField_a_of_type_Int = k;
              if (localMatchInfo.bytes_nick.has()) {
                paramToServiceMsg = localMatchInfo.bytes_nick.get().toStringUtf8();
              } else {
                paramToServiceMsg = "";
              }
              ((MatchInfo)localObject2).d = paramToServiceMsg;
              paramToServiceMsg = (ToServiceMsg)localObject1;
              if (localMatchInfo.string_report_id.has()) {
                paramToServiceMsg = localMatchInfo.string_report_id.get();
              }
              localObject1 = paramToServiceMsg;
              if (TextUtils.isEmpty(paramToServiceMsg))
              {
                QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "string_report_id EMPTY");
                localObject1 = "0";
              }
              ((MatchInfo)localObject2).e = ((String)localObject1);
              if (localRspBody.msg_match_info.msg_tag.has())
              {
                if (localRspBody.msg_match_info.msg_tag.uint32_tag_id.has()) {
                  ((MatchInfo)localObject2).jdField_b_of_type_Int = localRspBody.msg_match_info.msg_tag.uint32_tag_id.get();
                } else {
                  QLog.e("ExpandHandlerImpl", 2, "msg_tag pi pei zhu ti  ID IS NULL");
                }
                if (localRspBody.msg_match_info.msg_tag.bytes_tag.has()) {
                  ((MatchInfo)localObject2).jdField_f_of_type_JavaLangString = localRspBody.msg_match_info.msg_tag.bytes_tag.get().toStringUtf8();
                }
              }
              else
              {
                QLog.e("ExpandHandlerImpl", 2, "msg_tag pi pei zhu ti   not has");
              }
              if (localRspBody.msg_match_info.msg_match_uin_data.has())
              {
                if (((MatchInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo == null)
                {
                  ((MatchInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo = new ChatFriendInfo();
                  ((MatchInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_a_of_type_JavaLangString = ((MatchInfo)localObject2).jdField_b_of_type_JavaLangString;
                }
                a(localRspBody.msg_match_info.msg_match_uin_data, ((MatchInfo)localObject2).jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo);
              }
              else
              {
                QLog.e("ExpandHandlerImpl", 2, "msg_match_uin_data  not has");
              }
              if (QLog.isColorLevel())
              {
                paramToServiceMsg = new StringBuilder();
                paramToServiceMsg.append("handleMatchResponse type =");
                paramToServiceMsg.append(m);
                QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, new Object[] { paramToServiceMsg.toString(), " uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " matchInfo = ", ((MatchInfo)localObject2).toString(), " errMsg = ", paramObject });
              }
              notifyUI(m, true, new Object[] { Integer.valueOf(j), localObject2, Integer.valueOf(n), paramObject });
            }
            else
            {
              if (QLog.isColorLevel())
              {
                paramToServiceMsg = new StringBuilder();
                paramToServiceMsg.append("handleMatchResponse type =");
                paramToServiceMsg.append(m);
                QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, new Object[] { paramToServiceMsg.toString(), " uin = ", str, ", match_op = ", Integer.valueOf(i), " retCode = ", Integer.valueOf(j), " errMsg = ", paramObject });
              }
              notifyUI(m, true, new Object[] { Integer.valueOf(j), null, Integer.valueOf(n), paramObject });
            }
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 5)) {
        a(paramFromServiceMsg, localRspBody);
      }
    }
    else
    {
      notifyUI(m, false, null);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleMatchResponse. TYPE_UPDATE_MATCH_INFO false result：");
        paramToServiceMsg.append(j);
        QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xb4b");
      this.allowCmdSet.add("OidbSvc.0xb4b_6");
      this.allowCmdSet.add("OidbSvc.0xb4c");
      this.allowCmdSet.add("OidbSvc.0xb51");
      this.allowCmdSet.add("OidbSvc.0xcb5");
      this.allowCmdSet.add("OidbSvc.0xdb1");
      this.allowCmdSet.add("OidbSvc.0xdb1_2");
      this.allowCmdSet.add("OidbSvc.0xe52_3");
      this.allowCmdSet.add("OidbSvc.0xe03");
      this.allowCmdSet.add("OidbSvc.0xe09");
      this.allowCmdSet.add("OidbSvc.0xe51");
      this.allowCmdSet.add("OidbSvc.0xe67");
      this.allowCmdSet.add("OidbSvc.0xeae");
      this.allowCmdSet.add("OidbSvc.0xeaf");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ExpandObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ("OidbSvc.0xb4b".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xb4c".equals(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xb51".equals(paramFromServiceMsg.getServiceCmd()))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xcb5".equals(paramFromServiceMsg.getServiceCmd()))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xdb1".equals(paramFromServiceMsg.getServiceCmd()))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xdb1_2".equals(paramFromServiceMsg.getServiceCmd()))
    {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xe52_3".equals(paramFromServiceMsg.getServiceCmd()))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xb4b_6".equals(paramFromServiceMsg.getServiceCmd()))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xe03".equals(paramFromServiceMsg.getServiceCmd()))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xe09".equals(paramFromServiceMsg.getServiceCmd()))
    {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xe51".equals(paramFromServiceMsg.getServiceCmd()))
    {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xe67".equals(paramFromServiceMsg.getServiceCmd()))
    {
      l(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xeae".equals(paramFromServiceMsg.getServiceCmd()))
    {
      m(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    "OidbSvc.0xeaf".equals(paramFromServiceMsg.getServiceCmd());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl
 * JD-Core Version:    0.7.0.1
 */