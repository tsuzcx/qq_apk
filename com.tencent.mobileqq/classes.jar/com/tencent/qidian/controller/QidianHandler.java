package com.tencent.qidian.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qidian.proto.mobileqq_qidian.CRMMsgHead;
import com.tencent.qidian.proto.mobileqq_qidian.CheckMpqqRefuseFlagReq;
import com.tencent.qidian.proto.mobileqq_qidian.CheckMpqqRefuseFlagRsp;
import com.tencent.qidian.proto.mobileqq_qidian.ClickEManReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.ClickEManRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.ClickReplyCmdActionReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.ClickReplyCmdActionRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.CloseSessionReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.CloseSessionRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.CorpInfo;
import com.tencent.qidian.proto.mobileqq_qidian.CorpReportInfo;
import com.tencent.qidian.proto.mobileqq_qidian.ExtReportInfo;
import com.tencent.qidian.proto.mobileqq_qidian.ExternalInfo;
import com.tencent.qidian.proto.mobileqq_qidian.GetCorpUinDetailInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetCorpUinDetailInfoRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetCustomerTransferInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetCustomerTransferInfoRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetNavigationMenuConfigRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetQiDianGroupInfoReq;
import com.tencent.qidian.proto.mobileqq_qidian.GetQiDianGroupInfoRsp;
import com.tencent.qidian.proto.mobileqq_qidian.GetUserDetailInfoReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.GetUserDetailInfoRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.InternalInfo;
import com.tencent.qidian.proto.mobileqq_qidian.NotRecvQdGroupMsgReq;
import com.tencent.qidian.proto.mobileqq_qidian.NotRecvQdGroupMsgRsp;
import com.tencent.qidian.proto.mobileqq_qidian.QidianWpaAddFriendReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.QidianWpaAddFriendRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.ReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.ReqCorpUinWpaReq;
import com.tencent.qidian.proto.mobileqq_qidian.ReqCorpUinWpaRsp;
import com.tencent.qidian.proto.mobileqq_qidian.RetInfo;
import com.tencent.qidian.proto.mobileqq_qidian.RspBody;
import com.tencent.qidian.proto.mobileqq_qidian.VerifyWpaUinAndKeyReq;
import com.tencent.qidian.proto.mobileqq_qidian.VerifyWpaUinAndKeyRsp;
import com.tencent.qidian.proto.mobileqq_qidian.WpaAssignKfextReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.WpaAssignKfextRspBody;
import com.tencent.qidian.proto.mobileqq_qidian.WpaSigtToSigMsgReqBody;
import com.tencent.qidian.proto.mobileqq_qidian.WpaSigtToSigMsgRspBody;
import com.tencent.qidian.util.QidianUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x7e7.Oidb_0x7e7.ReqBody;
import tencent.im.oidb.cmd0x7e7.Oidb_0x7e7.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92.MsgBody.S2CPushEmanMsgToC;
import tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CUserGetCouponForCEventPush;

public class QidianHandler
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.qidian.controller.QidianHandler";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QidianHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private mobileqq_qidian.CRMMsgHead a(String paramString1, int paramInt, String paramString2)
  {
    mobileqq_qidian.CRMMsgHead localCRMMsgHead = new mobileqq_qidian.CRMMsgHead();
    localCRMMsgHead.uint32_crm_sub_cmd.set(paramInt);
    localCRMMsgHead.uint32_crm_sub_cmd.setHasFlag(true);
    long l;
    if (!TextUtils.isEmpty(paramString1))
    {
      l = Long.valueOf(paramString1).longValue();
      localCRMMsgHead.uint64_kf_uin.set(l);
      localCRMMsgHead.uint64_kf_uin.setHasFlag(true);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      l = Long.valueOf(paramString2).longValue();
      localCRMMsgHead.uint64_ext_uin.set(l);
      localCRMMsgHead.uint64_ext_uin.setHasFlag(true);
    }
    localCRMMsgHead.uint32_terminal_type.set(2);
    localCRMMsgHead.uint32_terminal_version.set(QidianUtils.a("8.7.0"));
    return localCRMMsgHead;
  }
  
  private mobileqq_qidian.ReqBody a(String paramString1, int paramInt, String paramString2)
  {
    mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
    paramString1 = a(paramString1, paramInt, paramString2);
    localReqBody.msg_crm_common_head.set(paramString1);
    localReqBody.msg_crm_common_head.setHasFlag(true);
    localReqBody.uint32_sub_cmd.set(paramInt);
    localReqBody.uint32_sub_cmd.setHasFlag(true);
    return localReqBody;
  }
  
  private void a(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo);
  }
  
  private void a(QidianExternalInfo paramQidianExternalInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(paramQidianExternalInfo, paramQidianProfileUiInfo);
  }
  
  private void a(mobileqq_qidian.ReqBody paramReqBody, String paramString, Map<String, String> paramMap)
  {
    ToServiceMsg localToServiceMsg = super.createToServiceMsg(paramString);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localToServiceMsg.extraData.putString(str, (String)paramMap.get(str));
      }
    }
    localToServiceMsg.putWupBuffer(paramReqBody.toByteArray());
    super.sendPbReq(localToServiceMsg);
    paramReqBody = com.tencent.mobileqq.app.AppConstants.NET_TYPE_NAME[NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext())];
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Qidian", "", paramString, paramString, 0, 0, "", "", paramReqBody, "");
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    String str = com.tencent.mobileqq.app.AppConstants.NET_TYPE_NAME[NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext())];
    long l = paramToServiceMsg.extraData.getLong("startTime");
    l = System.currentTimeMillis() - l;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append(paramString);
      paramFromServiceMsg.append("_success");
      paramFromServiceMsg = paramFromServiceMsg.toString();
      paramObject = new StringBuilder();
      paramObject.append(paramString);
      paramObject.append("_success");
      ReportController.b(paramToServiceMsg, "P_CliOper", "Qidian", "", paramFromServiceMsg, paramObject.toString(), 0, 0, String.valueOf((int)l), "", str, "");
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = jdField_a_of_type_JavaLangString;
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleAssignExt success, delta is ");
        paramFromServiceMsg.append(l);
        QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
      }
      return bool;
    }
    paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramObject = new StringBuilder();
    paramObject.append(paramString);
    paramObject.append("_fail");
    paramObject = paramObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_fail");
    ReportController.b(paramFromServiceMsg, "P_CliOper", "Qidian", "", paramObject, localStringBuilder.toString(), 0, 0, String.valueOf((int)l), "", str, paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = jdField_a_of_type_JavaLangString;
      paramObject = new StringBuilder();
      paramObject.append("handleGetAccountType failed, fail message: ");
      paramObject.append(paramToServiceMsg);
      QLog.d(paramFromServiceMsg, 2, paramObject.toString());
    }
    return bool;
  }
  
  private void b(SubMsgType0x92.MsgBody paramMsgBody)
  {
    paramMsgBody = (SubMsgType0x92.MsgBody.S2CPushEmanMsgToC)paramMsgBody.msg_Push_Eman_Msg.get();
    if (paramMsgBody != null)
    {
      long l = paramMsgBody.uint64_uin.get();
      if (paramMsgBody.str_xml.has())
      {
        paramMsgBody = paramMsgBody.str_xml.get();
        ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l, paramMsgBody);
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    paramFromServiceMsg = new HashMap();
    paramFromServiceMsg.put("key_sigt", paramToServiceMsg.extraData.get("key_sigt"));
    paramFromServiceMsg.put("uin", paramToServiceMsg.extraData.get("uin"));
    paramFromServiceMsg.put("key_return_root", paramToServiceMsg.extraData.get("key_return_root"));
    if (i != 0) {}
    for (;;)
    {
      try
      {
        mobileqq_qidian.RspBody localRspBody = new mobileqq_qidian.RspBody();
        localRspBody.mergeFrom((byte[])paramObject);
        if (localRspBody.msg_req_corpuin_wpa_rsp.has())
        {
          if (localRspBody.msg_req_corpuin_wpa_rsp.msg_ret.uint32_ret_code.get() != 0) {
            break label299;
          }
          i = 1;
          if (i != 0)
          {
            i = localRspBody.msg_req_corpuin_wpa_rsp.uint32_aio_type.get();
            if (localRspBody.msg_req_corpuin_wpa_rsp.bytes_sigmsg.has())
            {
              paramToServiceMsg = paramToServiceMsg.extraData.get("uin");
              if (paramToServiceMsg != null) {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(String.valueOf(paramToServiceMsg), localRspBody.msg_req_corpuin_wpa_rsp.bytes_sigmsg.get().toByteArray());
              }
            }
            paramFromServiceMsg.put("key_aio_type", Integer.valueOf(i));
            notifyUI(1007, true, paramFromServiceMsg);
            return;
          }
          notifyUI(1007, false, paramFromServiceMsg);
          return;
        }
        notifyUI(1007, false, paramFromServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleCorpUinWpaReport ", paramToServiceMsg);
        }
        notifyUI(1007, false, paramFromServiceMsg);
        return;
      }
      notifyUI(1007, false, paramFromServiceMsg);
      return;
      label299:
      i = 0;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          break label164;
        }
        i = 1;
        if (i != 0)
        {
          paramFromServiceMsg = new mobileqq_qidian.RspBody();
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg.msg_not_recv_qd_group_msg_rsp.has())
          {
            paramFromServiceMsg = (mobileqq_qidian.NotRecvQdGroupMsgRsp)paramFromServiceMsg.msg_not_recv_qd_group_msg_rsp.get();
            i = paramFromServiceMsg.msg_ret.uint32_ret_code.get();
            paramFromServiceMsg = paramFromServiceMsg.msg_ret.str_error_msg.get();
            paramObject = new HashMap();
            paramObject.put("ret_code", Integer.valueOf(i));
            paramObject.put("ret_msg", paramFromServiceMsg);
            if (i == 0)
            {
              ThreadManager.executeOnSubThread(new QidianHandler.1(this, paramToServiceMsg, paramObject));
              return;
            }
            notifyUI(1005, false, paramObject);
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleBlockBulkMsg ", paramToServiceMsg);
        }
      }
      return;
      label164:
      int i = 0;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new mobileqq_qidian.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.has()) {
          break label304;
        }
        if (paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.int32_result.get() != 0) {
          break label305;
        }
        i = 1;
        if (i != 0)
        {
          paramObject = paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.bytes_sigmsg_ext.get().toByteArray();
          long l = paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.uint64_kfext_uin.get();
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("uin", String.valueOf(l));
          paramFromServiceMsg.put("sigmsg", paramObject);
          paramToServiceMsg = paramToServiceMsg.extraData;
          if ((paramToServiceMsg != null) && (!paramToServiceMsg.isEmpty()))
          {
            paramObject = paramToServiceMsg.keySet().iterator();
            if (paramObject.hasNext())
            {
              String str = (String)paramObject.next();
              paramFromServiceMsg.put(str, paramToServiceMsg.get(str));
              continue;
            }
          }
          notifyUI(1010, true, paramFromServiceMsg);
          return;
        }
        notifyUI(1010, false, null);
        if (!QLog.isColorLevel()) {
          break label304;
        }
        paramToServiceMsg = jdField_a_of_type_JavaLangString;
        paramObject = new StringBuilder();
        paramObject.append("handleGetSigmsgBySigt ");
        paramObject.append(paramFromServiceMsg.msg_wpa_sigt_to_sigmsg_rsp.str_err_msg.get());
        QLog.d(paramToServiceMsg, 2, paramObject.toString());
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetSigmsgBySigt ", paramToServiceMsg);
        }
        notifyUI(1010, false, null);
        return;
      }
      notifyUI(1010, false, null);
      label304:
      return;
      label305:
      i = 0;
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      try
      {
        paramToServiceMsg = new mobileqq_qidian.RspBody();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramToServiceMsg.msg_qidian_wpa_addfriend_rsp.has()) {
          return;
        }
        i = paramToServiceMsg.msg_close_session_rsp.msg_ret.uint32_ret_code.get();
        if (i == 0)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetWebImAddFriend errorCode = 0");
          return;
        }
        paramToServiceMsg = paramToServiceMsg.msg_close_session_rsp.msg_ret.str_error_msg.get();
        if (!QLog.isColorLevel()) {
          return;
        }
        paramFromServiceMsg = jdField_a_of_type_JavaLangString;
        paramObject = new StringBuilder();
        paramObject.append("handleGetWebImAddFriend errorCode: ");
        paramObject.append(i);
        paramObject.append(" , errorMsg: ");
        paramObject.append(paramToServiceMsg);
        QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetWebImAddFriend ", paramToServiceMsg);
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetWebImAddFriend is Success = false");
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (paramObject != null)
      {
        try
        {
          paramFromServiceMsg = new mobileqq_qidian.RspBody();
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          if (!paramFromServiceMsg.msg_get_qidian_group_info_rsp.has()) {
            return;
          }
          paramFromServiceMsg = (mobileqq_qidian.GetQiDianGroupInfoRsp)paramFromServiceMsg.msg_get_qidian_group_info_rsp.get();
          paramObject = (mobileqq_qidian.RetInfo)paramFromServiceMsg.msg_ret.get();
          if (paramObject.uint32_ret_code.get() == 0)
          {
            paramObject = new HashMap();
            paramFromServiceMsg = paramFromServiceMsg.bytes_wpalink.get().toStringUtf8();
            paramObject.put("uin", (String)paramToServiceMsg.extraData.get("uin"));
            paramObject.put("url", paramFromServiceMsg);
            notifyUI(1018, true, paramObject);
            return;
          }
          paramToServiceMsg = paramObject.str_error_msg.get();
          if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramToServiceMsg)))
          {
            paramFromServiceMsg = jdField_a_of_type_JavaLangString;
            paramObject = new StringBuilder();
            paramObject.append("handleQidianGroupInfo error is ");
            paramObject.append(paramToServiceMsg);
            QLog.d(paramFromServiceMsg, 2, paramObject.toString());
          }
          notifyUI(1018, false, null);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = jdField_a_of_type_JavaLangString;
            paramObject = new StringBuilder();
            paramObject.append("handleQidianGroupInfo throw exception is ");
            paramObject.append(paramToServiceMsg.toString());
            QLog.d(paramFromServiceMsg, 2, paramObject.toString());
          }
          notifyUI(1018, false, null);
          return;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleQidianGroupInfo data is null");
        }
        notifyUI(1018, false, null);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleQidianGroupInfo res is fail");
      }
      notifyUI(1018, false, null);
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("QidianSsoProto.getUserDetailInfo");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).toString();
    localObject1 = a("", 4, String.valueOf(paramLong));
    ((mobileqq_qidian.ReqBody)localObject1).msg_crm_common_head.uint32_ver_no.set(1);
    Object localObject2 = new mobileqq_qidian.GetUserDetailInfoReqBody();
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject2).uint32_req_type.set(2);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject2).uint32_mobile_client.set(1);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject2).uint64_uin.set(paramLong);
    ((mobileqq_qidian.ReqBody)localObject1).msg_get_user_detail_info_req.set((MessageMicro)localObject2);
    ((mobileqq_qidian.ReqBody)localObject1).msg_get_user_detail_info_req.setHasFlag(true);
    localObject2 = new HashMap(1);
    ((Map)localObject2).put("uin", String.valueOf(paramLong));
    ((Map)localObject2).put("req_type", String.valueOf(2));
    a((mobileqq_qidian.ReqBody)localObject1, "QidianSsoProto.getUserDetailInfo", (Map)localObject2);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    mobileqq_qidian.ReqBody localReqBody = a("", 1005, String.valueOf(paramLong2));
    Object localObject = new mobileqq_qidian.GetCustomerTransferInfoReqBody();
    ((mobileqq_qidian.GetCustomerTransferInfoReqBody)localObject).uint64_qq_uin.set(paramLong1);
    ((mobileqq_qidian.GetCustomerTransferInfoReqBody)localObject).uint64_kfext_uin.set(paramLong2);
    ((mobileqq_qidian.GetCustomerTransferInfoReqBody)localObject).uint32_mobile_client.set(1);
    ((mobileqq_qidian.GetCustomerTransferInfoReqBody)localObject).uint32_ver_no.set(CrmUtils.a("8.7.0"));
    localReqBody.msg_get_customer_transfer_info_req.set((MessageMicro)localObject);
    localReqBody.msg_get_customer_transfer_info_req.setHasFlag(true);
    localObject = new HashMap(1);
    ((Map)localObject).put("kfext", String.valueOf(paramLong2));
    a(localReqBody, "QidianSsoProto.getCustomerTransferInfo", (Map)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ranKey", paramToServiceMsg.extraData.get("ranKey"));
    for (;;)
    {
      try
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject, "qidian_wpa_assign");
        if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
        {
          i = 1;
          if (i != 0)
          {
            paramFromServiceMsg = new mobileqq_qidian.RspBody();
            paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if (paramFromServiceMsg.msg_wpa_assign_kfext_rsp.has())
            {
              if (paramFromServiceMsg.msg_wpa_assign_kfext_rsp.int32_result.get() != 0) {
                break label333;
              }
              i = 1;
              if (i != 0)
              {
                paramObject = String.valueOf(paramFromServiceMsg.msg_wpa_assign_kfext_rsp.uint64_ext_uin.get());
                String str = HexUtil.bytes2HexStr(paramFromServiceMsg.msg_wpa_assign_kfext_rsp.bytes_sigT_ext.get().toByteArray());
                i = paramFromServiceMsg.msg_wpa_assign_kfext_rsp.uint32_aio_type.get();
                if ((paramFromServiceMsg.msg_wpa_assign_kfext_rsp.bytes_sigmsg.has()) && (paramObject != null)) {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramObject, paramFromServiceMsg.msg_wpa_assign_kfext_rsp.bytes_sigmsg.get().toByteArray());
                }
                localHashMap.put("key_ext_uin", paramObject);
                localHashMap.put("key_sigt", str);
                localHashMap.put("key_aio_type", Integer.valueOf(i));
                localHashMap.put("key_return_root", paramToServiceMsg.extraData.get("key_return_root"));
                notifyUI(1004, true, localHashMap);
                return;
              }
              notifyUI(1004, false, localHashMap);
              return;
            }
            notifyUI(1004, false, localHashMap);
            return;
          }
          notifyUI(1004, false, localHashMap);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleAssignExt ", paramToServiceMsg);
        }
        notifyUI(1004, false, localHashMap);
        return;
      }
      int i = 0;
      continue;
      label333:
      i = 0;
    }
  }
  
  public void a(String paramString)
  {
    new Bundle().putString("k", paramString);
    StringBuilder localStringBuilder = new StringBuilder("http://qm.qq.com/cgi-bin/qm/qr");
    localStringBuilder.append("?");
    localStringBuilder.append("k=");
    localStringBuilder.append(paramString);
    short s = (short)localStringBuilder.toString().getBytes().length;
    paramString = new byte[s + 14];
    PkgTools.word2Byte(paramString, 0, (short)2);
    PkgTools.word2Byte(paramString, 2, (short)1);
    PkgTools.word2Byte(paramString, 4, (short)4);
    PkgTools.dWord2Byte(paramString, 6, 1);
    PkgTools.word2Byte(paramString, 10, (short)5);
    PkgTools.word2Byte(paramString, 12, s);
    PkgTools.copyData(paramString, 14, localStringBuilder.toString().getBytes(), s);
    sendPbReq(makeOIDBPkg("OidbSvc.0x782", 1922, 0, paramString));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "decodeQidianPrivateTroopUin");
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new Oidb_0x7e7.ReqBody();
    ((Oidb_0x7e7.ReqBody)localObject).cmd_id.set(paramInt1);
    ((Oidb_0x7e7.ReqBody)localObject).platform.set(2);
    ((Oidb_0x7e7.ReqBody)localObject).timestamp.set(System.currentTimeMillis() / 1000L);
    ((Oidb_0x7e7.ReqBody)localObject).env.set(paramInt2);
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        paramString = new JSONObject();
      } else {
        paramString = new JSONObject(paramString);
      }
      paramString.put("qq_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Oidb_0x7e7.ReqBody)localObject).json_string.set(ByteStringMicro.copyFromUtf8(paramString.toString()));
      long l;
      if (paramString.has("kfuin"))
      {
        l = Long.valueOf(paramString.getString("kfuin")).longValue();
        ((Oidb_0x7e7.ReqBody)localObject).corp_uin.set(l);
      }
      if (paramString.has("kfext"))
      {
        l = Long.valueOf(paramString.getString("kfext")).longValue();
        ((Oidb_0x7e7.ReqBody)localObject).user_uin.set(l);
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "reportWPA json error  ", paramString);
      }
    }
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2023);
    paramString.uint32_service_type.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x7e7.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x7e7_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
    Object localObject1 = ((MessageCache)localObject2).d(paramString);
    localObject2 = ((MessageCache)localObject2).e(paramString);
    int i;
    if ((localObject1 != null) && (localObject2 != null)) {
      i = 3;
    } else if (localObject1 != null) {
      i = 2;
    } else if (localObject2 != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(paramString)) {
      j = 4;
    } else {
      j = 0;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(i);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("");
    ((StringBuilder)localObject4).append(paramLong);
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    ReportController.b((AppRuntime)localObject1, "dc00899", "Qidian", paramString, "0X8006DEC", "SigCheck", j, 2, (String)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString());
  }
  
  public void a(String paramString1, int paramInt1, boolean paramBoolean, double paramDouble1, double paramDouble2, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    mobileqq_qidian.ReqBody localReqBody = a(paramString2, 3, "");
    mobileqq_qidian.ClickReplyCmdActionReqBody localClickReplyCmdActionReqBody = new mobileqq_qidian.ClickReplyCmdActionReqBody();
    localClickReplyCmdActionReqBody.str_key.set(paramString1);
    localClickReplyCmdActionReqBody.uint32_type.set(paramInt1);
    if (paramBoolean)
    {
      localClickReplyCmdActionReqBody.bool_is_need_lbs.set(paramBoolean);
      localClickReplyCmdActionReqBody.double_latitude.set(paramDouble1);
      localClickReplyCmdActionReqBody.double_longitude.set(paramDouble2);
    }
    localClickReplyCmdActionReqBody.uint32_src_type.set(paramInt2);
    localClickReplyCmdActionReqBody.str_menu_title.set(paramString5);
    localClickReplyCmdActionReqBody.uint32_terminal_type.set(1001);
    localClickReplyCmdActionReqBody.uint32_pubno.set(AppSetting.a());
    localReqBody.msg_click_reply_cmd_action_req.set(localClickReplyCmdActionReqBody);
    localReqBody.msg_click_reply_cmd_action_req.setHasFlag(true);
    paramString1 = new HashMap(1);
    paramString1.put("master_uin", paramString2);
    a(localReqBody, "QidianSsoProto.clickReplyCmd", paramString1);
    if (paramInt1 == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Qidian", paramString4, "0X800849E", "ClickCard", paramInt2, 1, paramString3, "1", null, null);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
    Object localObject1 = ((MessageCache)localObject2).d(paramString);
    localObject2 = ((MessageCache)localObject2).e(paramString);
    int i;
    if ((localObject1 != null) && (localObject2 != null)) {
      i = 3;
    } else if (localObject1 != null) {
      i = 2;
    } else if (localObject2 != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(paramString)) {
      j = 4;
    } else {
      j = 0;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(i);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(paramLong);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    ReportController.b((AppRuntime)localObject1, "dc00899", "Qidian", paramString, "0X8006DEC", "SigCheck", j, 1, "", (String)localObject2, (String)localObject3, localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2, 1003, null);
    mobileqq_qidian.CheckMpqqRefuseFlagReq localCheckMpqqRefuseFlagReq = new mobileqq_qidian.CheckMpqqRefuseFlagReq();
    localCheckMpqqRefuseFlagReq.uint64_mpqq_uin.set(Long.parseLong(paramString1));
    localCheckMpqqRefuseFlagReq.uint64_qq_uin.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    paramString2.msg_check_mpqq_refuse_flag_req.set(localCheckMpqqRefuseFlagReq);
    paramString2.msg_check_mpqq_refuse_flag_req.setHasFlag(true);
    a(paramString2, "QidianSsoProto.getShieldStatus", null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    paramString3 = a(paramString2, 1010, paramString3);
    mobileqq_qidian.ClickEManReqBody localClickEManReqBody = new mobileqq_qidian.ClickEManReqBody();
    localClickEManReqBody.str_key.set(paramString1);
    paramString3.msg_click_eman_req.set(localClickEManReqBody);
    paramString1 = new HashMap(1);
    paramString1.put("master_uin", paramString2);
    a(paramString3, "QidianSsoProto.emanClickReport", paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    try
    {
      Oidb_0x7e7.ReqBody localReqBody = new Oidb_0x7e7.ReqBody();
      localReqBody.cmd_id.set(paramInt1);
      localReqBody.platform.set(2);
      localReqBody.timestamp.set(System.currentTimeMillis() / 1000L);
      localReqBody.env.set(paramInt2);
      if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isDigitsOnly(paramString2))) {
        localReqBody.user_uin.set(Long.parseLong(paramString2));
      }
      if ((!TextUtils.isEmpty(paramString3)) && (TextUtils.isDigitsOnly(paramString3))) {
        localReqBody.corp_uin.set(Long.parseLong(paramString3));
      }
      if (!TextUtils.isEmpty(paramString1)) {
        localReqBody.json_string.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2023);
      paramString1.uint32_service_type.set(0);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramString2 = createToServiceMsg("OidbSvc.0x7e7_0");
      paramString2.putWupBuffer(paramString1.toByteArray());
      sendPbReq(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = jdField_a_of_type_JavaLangString;
        paramString3 = new StringBuilder();
        paramString3.append("qidianUnifiedReport ");
        paramString3.append(paramString1.getMessage());
        QLog.e(paramString2, 2, paramString3.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (TextUtils.isDigitsOnly(paramString1)) && (TextUtils.isDigitsOnly(paramString2)))
    {
      if (!TextUtils.isDigitsOnly(paramString3)) {
        return;
      }
      try
      {
        mobileqq_qidian.ReqBody localReqBody = a(paramString2, 1004, paramString1);
        mobileqq_qidian.NotRecvQdGroupMsgReq localNotRecvQdGroupMsgReq = new mobileqq_qidian.NotRecvQdGroupMsgReq();
        localNotRecvQdGroupMsgReq.uint64_extuin.set(Long.parseLong(paramString1));
        localNotRecvQdGroupMsgReq.uint64_kfuin.set(Long.parseLong(paramString2));
        localNotRecvQdGroupMsgReq.uint64_taskid.set(Long.parseLong(paramString3));
        localReqBody.msg_not_recv_qd_group_msg_req.set(localNotRecvQdGroupMsgReq);
        localReqBody.msg_not_recv_qd_group_msg_req.setHasFlag(true);
        paramString2 = createToServiceMsg("QidianSsoProto.blockBulkMsg");
        paramString2.extraData.putLong("startTime", System.currentTimeMillis());
        paramString2.extraData.putString("extUin", paramString1);
        paramString2.extraData.putLong("uinseq", paramLong);
        paramString2.extraData.putInt("uinType", paramInt);
        paramString2.putWupBuffer(localReqBody.toByteArray());
        super.sendPbReq(paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "blockQdBulkMsg ", paramString1);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString2 = a(paramString2, 1002, null);
    mobileqq_qidian.VerifyWpaUinAndKeyReq localVerifyWpaUinAndKeyReq = new mobileqq_qidian.VerifyWpaUinAndKeyReq();
    localVerifyWpaUinAndKeyReq.str_key.set(paramString3);
    localVerifyWpaUinAndKeyReq.uint64_dst_uin.set(Long.parseLong(paramString1));
    if (paramString5 != null) {
      localVerifyWpaUinAndKeyReq.str_json_info.set(paramString5);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localVerifyWpaUinAndKeyReq.str_rkey.set(paramString4);
    }
    localVerifyWpaUinAndKeyReq.uint32_terminal_type.set(2);
    localVerifyWpaUinAndKeyReq.uint32_terminal_version.set(ApkUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()));
    paramString2.msg_verify_wpa_uin_and_key_req.set(localVerifyWpaUinAndKeyReq);
    paramString2.msg_verify_wpa_uin_and_key_req.setHasFlag(true);
    a(paramString2, "QidianSsoProto.verifyWpaAndKey", null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
      try
      {
        mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
        paramString1 = a(paramString1, 1008, "");
        localReqBody.msg_crm_common_head.set(paramString1);
        localReqBody.uint32_sub_cmd.set(1008);
        paramString1 = new mobileqq_qidian.ReqCorpUinWpaReq();
        byte[] arrayOfByte = HexUtil.hexStr2Bytes(paramString2);
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
          paramString1.bytes_sigt.set(ByteStringMicro.copyFrom(arrayOfByte));
        }
        paramString1.uint64_qquin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        paramString1.uint64_touin.set(Long.parseLong(paramString3));
        paramString1.uint32_assign_type.set(Integer.parseInt(paramString4));
        paramString1.uint64_assign_id.set(Long.parseLong(paramString5));
        localReqBody.msg_req_corpuin_wpa_req.set(paramString1);
        paramString1 = new HashMap();
        paramString1.put("key_return_root", paramString6);
        paramString1.put("key_sigt", paramString2);
        paramString1.put("uin", paramString3);
        a(localReqBody, "QidianSsoProto.corpUinWpaReport", paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "corpUinWpaReport ", paramString1);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
    paramString1 = a(paramString1, 1, "");
    localReqBody.msg_crm_common_head.set(paramString1);
    localReqBody.msg_crm_common_head.setHasFlag(true);
    paramString1 = new mobileqq_qidian.WpaAssignKfextReqBody();
    paramString1.uint32_wpa_type.set(Integer.valueOf(paramString2).intValue());
    paramString1.uint32_wpa_type.setHasFlag(true);
    paramString2 = HexUtil.hexStr2Bytes(paramString3);
    paramString1.bytes_sigT_kf.set(ByteStringMicro.copyFrom(paramString2));
    paramString1.bytes_sigT_kf.setHasFlag(true);
    paramString1.uint64_assign_id.set(Long.valueOf(paramString4).longValue());
    paramString1.uint64_assign_id.setHasFlag(true);
    paramString1.uint64_customer_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
    paramString1.uint64_customer_uin.setHasFlag(true);
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString1.str_rkey.set(paramString5);
      paramString1.str_rkey.setHasFlag(true);
    }
    localReqBody.msg_wpa_assign_kfext_req.set(paramString1);
    localReqBody.msg_wpa_assign_kfext_req.setHasFlag(true);
    paramString1 = super.createToServiceMsg("QidianSsoProto.WpaAssignKfext");
    paramString1.extraData.putLong("startTime", System.currentTimeMillis());
    paramString1.extraData.putString("key_return_root", paramString6);
    paramString1.extraData.putInt("ranKey", paramInt);
    paramString1.putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq(paramString1);
    paramString1 = com.tencent.mobileqq.app.AppConstants.NET_TYPE_NAME[NetworkUtil.getSystemNetwork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext())];
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Qidian", "", "qidian_wpa_assign", "qidian_wpa_assign", 0, 0, "", "", paramString1, "");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    paramString3 = a(String.valueOf(paramString3), 1012, paramString4);
    if (paramBoolean) {
      paramString3.msg_crm_common_head.uint64_kfaccount.set(Long.valueOf(paramString5).longValue());
    }
    paramString4 = new mobileqq_qidian.QidianWpaAddFriendReqBody();
    paramString4.str_visitID.set(paramString1);
    paramString4.uint64_customer_uin.set(Long.valueOf(paramString2).longValue());
    paramString3.msg_qidian_wpa_addfriend_req.set(paramString4);
    paramString3.msg_qidian_wpa_addfriend_req.setHasFlag(true);
    a(paramString3, "QidianSsoProto.webimAddFriend", null);
  }
  
  public void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        mobileqq_qidian.ReqBody localReqBody = new mobileqq_qidian.ReqBody();
        Object localObject = a("", 2, paramString1);
        localReqBody.msg_crm_common_head.set((MessageMicro)localObject);
        localReqBody.uint32_sub_cmd.set(2);
        localObject = new mobileqq_qidian.WpaSigtToSigMsgReqBody();
        paramString2 = HexUtil.hexStr2Bytes(paramString2);
        if ((paramString2 != null) && (paramString2.length > 0)) {
          ((mobileqq_qidian.WpaSigtToSigMsgReqBody)localObject).bytes_sigT_ext.set(ByteStringMicro.copyFrom(paramString2));
        }
        ((mobileqq_qidian.WpaSigtToSigMsgReqBody)localObject).uint64_kfext_uin.set(Long.parseLong(paramString1));
        localReqBody.msg_wpa_sigt_to_sigmsg_req.set((MessageMicro)localObject);
        if (paramHashMap != null)
        {
          a(localReqBody, "QidianSsoProto.WpaGenSigMsg", paramHashMap);
          return;
        }
        a(localReqBody, "QidianSsoProto.WpaGenSigMsg", null);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getSigmsgBySigt ", paramString1);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    mobileqq_qidian.ReqBody localReqBody = a(paramString1, 1011, paramString2);
    mobileqq_qidian.CloseSessionReqBody localCloseSessionReqBody = new mobileqq_qidian.CloseSessionReqBody();
    long l;
    if (paramBoolean)
    {
      paramString2 = new mobileqq_qidian.CorpReportInfo();
      if (!TextUtils.isEmpty(paramString1))
      {
        l = Long.valueOf(paramString1).longValue();
        paramString2.uint64_kfuin.set(l);
      }
      localCloseSessionReqBody.msg_corp_report_info.set(paramString2);
    }
    else
    {
      paramString1 = new mobileqq_qidian.ExtReportInfo();
      if (!TextUtils.isEmpty(paramString2))
      {
        l = Long.valueOf(paramString2).longValue();
        paramString1.uint64_ext_uin.set(l);
      }
      localCloseSessionReqBody.msg_ext_report_info.set(paramString1);
    }
    int i = (int)NetConnInfoCenter.getServerTime();
    localCloseSessionReqBody.uint32_close_session_time.set(i);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localCloseSessionReqBody.uint64_cqq_uin.set(Long.valueOf(paramString1).longValue());
    localReqBody.msg_close_session_req.set(localCloseSessionReqBody);
    a(localReqBody, "QidianSsoProto.closeAIOSessionReport", null);
  }
  
  public void a(SubMsgType0x92.MsgBody paramMsgBody)
  {
    int i = paramMsgBody.uint32_sub_cmd.get();
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleQidianSCPushMsg, subcmd =  ");
      localStringBuilder.append(i);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (i != 100) {
      return;
    }
    b(paramMsgBody);
  }
  
  public void a(Submsgtype0xe5.MsgBody paramMsgBody)
  {
    if (paramMsgBody.uint32_sub_cmd.get() != 10) {
      return;
    }
    long l = paramMsgBody.msg_s2c_user_get_coupon_for_c_event_push.uint64_kfext.get();
    paramMsgBody = paramMsgBody.msg_s2c_user_get_coupon_for_c_event_push.str_tips_content.get();
    AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), paramMsgBody, 0, false, false);
  }
  
  public void b(long paramLong)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("QidianSsoProto.getUserDetailInfo");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).toString();
    localObject1 = a("", 4, String.valueOf(paramLong));
    Object localObject2 = new mobileqq_qidian.GetUserDetailInfoReqBody();
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject2).uint32_req_type.set(3);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject2).uint32_mobile_client.set(1);
    ((mobileqq_qidian.GetUserDetailInfoReqBody)localObject2).uint64_uin.set(paramLong);
    ((mobileqq_qidian.ReqBody)localObject1).msg_get_user_detail_info_req.set((MessageMicro)localObject2);
    ((mobileqq_qidian.ReqBody)localObject1).msg_get_user_detail_info_req.setHasFlag(true);
    localObject2 = new HashMap(1);
    ((Map)localObject2).put("uin", String.valueOf(paramLong));
    ((Map)localObject2).put("req_type", String.valueOf(3));
    a((mobileqq_qidian.ReqBody)localObject1, "QidianSsoProto.getUserDetailInfo", (Map)localObject2);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new mobileqq_qidian.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg.msg_close_session_rsp.has()) && (paramToServiceMsg.msg_close_session_rsp.msg_ret.has()))
      {
        int i = paramToServiceMsg.msg_close_session_rsp.msg_ret.uint32_ret_code.get();
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = jdField_a_of_type_JavaLangString;
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleCloseAIOSessionReport errorCode: ");
            paramFromServiceMsg.append(i);
            QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
          }
        }
        else
        {
          paramToServiceMsg = paramToServiceMsg.msg_close_session_rsp.msg_ret.str_error_msg.get();
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = jdField_a_of_type_JavaLangString;
            paramObject = new StringBuilder();
            paramObject.append("handleCloseAIOSessionReport errorCode: ");
            paramObject.append(i);
            paramObject.append(" , errorMsg: ");
            paramObject.append(paramToServiceMsg);
            QLog.d(paramFromServiceMsg, 2, paramObject.toString());
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleCloseAIOSessionReport no response");
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = jdField_a_of_type_JavaLangString;
        paramObject = new StringBuilder();
        paramObject.append("handleCloseAIOSessionReport exception: ");
        paramObject.append(paramToServiceMsg.getMessage());
        QLog.d(paramFromServiceMsg, 2, paramObject.toString());
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    mobileqq_qidian.ReqBody localReqBody = a("", 1018, paramString2);
    mobileqq_qidian.GetQiDianGroupInfoReq localGetQiDianGroupInfoReq = new mobileqq_qidian.GetQiDianGroupInfoReq();
    localGetQiDianGroupInfoReq.uint32_groupcode.set(Integer.valueOf(paramString1).intValue());
    localGetQiDianGroupInfoReq.uint64_groupowner.set(Long.valueOf(paramString2).longValue());
    localReqBody.msg_get_qidian_group_info_req.set(localGetQiDianGroupInfoReq);
    localReqBody.msg_get_qidian_group_info_req.setHasFlag(true);
    paramString2 = new HashMap();
    paramString2.put("uin", paramString1);
    a(localReqBody, "QidianSsoProto.getQidianGroupInfo", paramString2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getQidianGroupInfoReq");
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString4 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      if (paramString4 == null) {
        paramString4 = null;
      } else {
        paramString4 = paramString4.getStweb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      if ((paramString4 != null) && (paramString4.length() != 0))
      {
        paramString4 = String.format(paramString5, new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString4 });
        break label149;
      }
      new QQToastNotifier(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(2131693334, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299168), 0, 1);
    }
    else
    {
      if (!TextUtils.isEmpty(paramString4)) {
        break label149;
      }
    }
    paramString4 = "";
    label149:
    paramString5 = new StringBuilder();
    paramString5.append(paramString2);
    paramString5.append(paramString3);
    paramString5 = new UniteGrayTipParam(paramString1, paramString1, paramString5.toString(), 0, -5020, 1245187, MessageCache.a());
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 1);
    localBundle.putString("key_action_DATA", paramString4);
    localBundle.putString("key_a_action_DATA", paramString4);
    paramString4 = new StringBuilder();
    paramString4.append(paramString2);
    paramString4.append(paramString3);
    int i = paramString4.toString().lastIndexOf(paramString3);
    if (i >= 0) {
      paramString5.a(i, paramString3.length() + i, localBundle);
    }
    paramString2 = new MessageForUniteGrayTip();
    paramString2.hasRead = 0;
    paramString2.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString5);
    UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2);
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getBaseContext();
    paramString3 = new StringBuilder();
    paramString3.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramString3.append("_customer_transfer_sharepreference");
    paramString2 = paramString2.getSharedPreferences(paramString3.toString(), 0).edit();
    paramString3 = new StringBuilder();
    paramString3.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramString3.append("_");
    paramString3.append(paramString1);
    paramString2.putBoolean(paramString3.toString(), true);
    paramString2.commit();
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getQidianMasterDetailReq uin: ");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = a(String.valueOf(paramLong), 1009, "");
    Object localObject2 = new mobileqq_qidian.GetCorpUinDetailInfoReqBody();
    ((mobileqq_qidian.GetCorpUinDetailInfoReqBody)localObject2).uint64_uin.set(paramLong);
    ((mobileqq_qidian.GetCorpUinDetailInfoReqBody)localObject2).uint32_req_type.set(0);
    ((mobileqq_qidian.ReqBody)localObject1).msg_get_corpuin_detail_info_req_body.set((MessageMicro)localObject2);
    ((mobileqq_qidian.ReqBody)localObject1).msg_get_corpuin_detail_info_req_body.setHasFlag(true);
    localObject2 = new HashMap(1);
    ((Map)localObject2).put("uin", String.valueOf(paramLong));
    ((Map)localObject2).put("req_type", String.valueOf(0));
    a((mobileqq_qidian.ReqBody)localObject1, "QidianSsoProto.fetchCorpDetailInfo", (Map)localObject2);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.clickReplyCmd");
    if (bool)
    {
      paramFromServiceMsg = new mobileqq_qidian.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.msg_click_reply_cmd_action_rsp.has())
        {
          int i = paramFromServiceMsg.msg_click_reply_cmd_action_rsp.msg_ret.uint32_ret_code.get();
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = jdField_a_of_type_JavaLangString;
            paramObject = new StringBuilder();
            paramObject.append("handleClickReplyCmd errorCode: ");
            paramObject.append(i);
            QLog.d(paramFromServiceMsg, 2, paramObject.toString());
          }
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("result", Integer.valueOf(i));
          paramFromServiceMsg.put("master_uin", paramToServiceMsg.extraData.get("master_uin"));
          super.notifyUI(1008, bool, paramFromServiceMsg);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleClickReplyCmd no msg_click_reply_cmd_action_rsp");
        }
        super.notifyUI(1008, bool, null);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = jdField_a_of_type_JavaLangString;
          paramObject = new StringBuilder();
          paramObject.append("handleClickReplyCmd exception: ");
          paramObject.append(paramToServiceMsg.getMessage());
          QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        }
        super.notifyUI(1008, bool, null);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = jdField_a_of_type_JavaLangString;
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleClickReplyCmd isSuccess: ");
      paramFromServiceMsg.append(bool);
      QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
    }
    super.notifyUI(1008, bool, null);
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getQidianMasterSimpleInfo uin: ");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = a(String.valueOf(paramLong), 1009, "");
    Object localObject2 = new mobileqq_qidian.GetCorpUinDetailInfoReqBody();
    ((mobileqq_qidian.GetCorpUinDetailInfoReqBody)localObject2).uint64_uin.set(paramLong);
    ((mobileqq_qidian.GetCorpUinDetailInfoReqBody)localObject2).uint32_req_type.set(2);
    ((mobileqq_qidian.ReqBody)localObject1).msg_get_corpuin_detail_info_req_body.set((MessageMicro)localObject2);
    ((mobileqq_qidian.ReqBody)localObject1).msg_get_corpuin_detail_info_req_body.setHasFlag(true);
    localObject2 = new HashMap(1);
    ((Map)localObject2).put("uin", String.valueOf(paramLong));
    ((Map)localObject2).put("req_type", String.valueOf(2));
    a((mobileqq_qidian.ReqBody)localObject1, "QidianSsoProto.fetchCorpDetailInfo", (Map)localObject2);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new mobileqq_qidian.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg.msg_click_eman_rsp.has()) && (paramToServiceMsg.msg_click_eman_rsp.msg_ret.has()))
      {
        int i = paramToServiceMsg.msg_click_eman_rsp.msg_ret.uint32_ret_code.get();
        if ((i == 0) && (paramToServiceMsg.msg_click_eman_rsp.str_msg.has()))
        {
          paramToServiceMsg = StructMsgFactory.a(paramToServiceMsg.msg_click_eman_rsp.str_msg.get().getBytes(), 0);
          if ((paramToServiceMsg != null) && (((BaseActivity.sTopActivity instanceof SplashActivity)) || ((BaseActivity.sTopActivity instanceof ChatActivity))))
          {
            paramFromServiceMsg = BaseActivity.sTopActivity;
            if (paramFromServiceMsg.getChatFragment() == null) {
              return;
            }
            ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg.getChatFragment().a.a, paramToServiceMsg);
          }
        }
        else
        {
          paramToServiceMsg = paramToServiceMsg.msg_click_eman_rsp.msg_ret.str_error_msg.get();
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = jdField_a_of_type_JavaLangString;
            paramObject = new StringBuilder();
            paramObject.append("handleEmanClickReport errorCode: ");
            paramObject.append(i);
            paramObject.append(" , errorMsg: ");
            paramObject.append(paramToServiceMsg);
            QLog.d(paramFromServiceMsg, 2, paramObject.toString());
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleEmanClickReport no response");
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = jdField_a_of_type_JavaLangString;
        paramObject = new StringBuilder();
        paramObject.append("handleEmanClickReport exception: ");
        paramObject.append(paramToServiceMsg.getMessage());
        QLog.d(paramFromServiceMsg, 2, paramObject.toString());
      }
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.verifyWpaAndKey");
    if (bool2) {
      paramToServiceMsg = new mobileqq_qidian.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_verify_wpa_uin_and_key_rsp.has())
        {
          paramToServiceMsg = (mobileqq_qidian.VerifyWpaUinAndKeyRsp)paramToServiceMsg.msg_verify_wpa_uin_and_key_rsp.get();
          if (paramToServiceMsg.int32_result.get() != 0) {
            break label330;
          }
          bool1 = true;
          if (bool1)
          {
            paramFromServiceMsg = new HashMap();
            paramObject = paramToServiceMsg.str_welcome_word.get();
            int i = paramToServiceMsg.uint32_is_valid.get();
            paramFromServiceMsg.put("welcome", paramObject);
            paramFromServiceMsg.put("result", Integer.valueOf(i));
            super.notifyUI(1002, bool2, paramFromServiceMsg);
            return;
          }
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = jdField_a_of_type_JavaLangString;
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleVerifyWpaAndKey uint32_ret_code: ");
            paramFromServiceMsg.append(bool1);
            QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
          }
          super.notifyUI(1002, bool2, null);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleVerifyWpaAndKey no msg_verify_wpa_uin_and_key_rsp");
        }
        super.notifyUI(1002, bool2, null);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = jdField_a_of_type_JavaLangString;
          paramObject = new StringBuilder();
          paramObject.append("handleVerifyWpaAndKey exception: ");
          paramObject.append(paramToServiceMsg.getMessage());
          QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        }
        super.notifyUI(1002, bool2, null);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = jdField_a_of_type_JavaLangString;
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleVerifyWpaAndKey isSuccess: ");
        paramFromServiceMsg.append(bool2);
        QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
      }
      super.notifyUI(1002, bool2, null);
      return;
      label330:
      boolean bool1 = false;
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.getShieldStatus");
    if (bool3) {
      paramToServiceMsg = new mobileqq_qidian.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_check_mpqq_refuse_flag_rsp.has())
        {
          paramToServiceMsg = (mobileqq_qidian.CheckMpqqRefuseFlagRsp)paramToServiceMsg.msg_check_mpqq_refuse_flag_rsp.get();
          int i = paramToServiceMsg.int32_result.get();
          boolean bool2 = false;
          if (i != 0) {
            break label328;
          }
          bool1 = true;
          if (bool1)
          {
            paramFromServiceMsg = new HashMap();
            bool1 = bool2;
            if (paramToServiceMsg.uint32_is_refuse.get() == 1) {
              bool1 = true;
            }
            paramFromServiceMsg.put("result", Boolean.valueOf(bool1));
            super.notifyUI(1003, true, paramFromServiceMsg);
            return;
          }
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = jdField_a_of_type_JavaLangString;
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleGetShieldStatus uint32_ret_code: ");
            paramFromServiceMsg.append(bool1);
            QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
          }
          super.notifyUI(1003, bool3, null);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetShieldStatus no msg_verify_wpa_uin_and_key_rsp");
        }
        super.notifyUI(1003, bool3, null);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = jdField_a_of_type_JavaLangString;
          paramObject = new StringBuilder();
          paramObject.append("handleGetShieldStatus exception: ");
          paramObject.append(paramToServiceMsg.getMessage());
          QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        }
        super.notifyUI(1003, bool3, null);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = jdField_a_of_type_JavaLangString;
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetShieldStatus isSuccess: ");
        paramFromServiceMsg.append(bool3);
        QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
      }
      super.notifyUI(1003, bool3, null);
      return;
      label328:
      boolean bool1 = false;
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.getUserDetailInfo");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
    Object localObject1;
    boolean bool1;
    label128:
    label222:
    QidianProfileUiInfo localQidianProfileUiInfo;
    if (bool2)
    {
      localObject1 = new mobileqq_qidian.RspBody();
      try
      {
        ((mobileqq_qidian.RspBody)localObject1).mergeFrom((byte[])paramObject);
        localHashMap = new HashMap();
        if (((mobileqq_qidian.RspBody)localObject1).msg_subcmd_get_user_detail_info_rsp_body.has())
        {
          localObject2 = (mobileqq_qidian.GetUserDetailInfoRspBody)((mobileqq_qidian.RspBody)localObject1).msg_subcmd_get_user_detail_info_rsp_body.get();
          if (((mobileqq_qidian.GetUserDetailInfoRspBody)localObject2).msg_ret.uint32_ret_code.get() != 0) {
            break label780;
          }
          bool1 = true;
          if (bool1) {
            paramToServiceMsg = paramToServiceMsg.extraData.getString("req_type");
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        HashMap localHashMap;
        Object localObject2;
        int i;
        label273:
        label327:
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = jdField_a_of_type_JavaLangString;
          paramObject = new StringBuilder();
          paramObject.append("handleGetUserDetailInfo exception: ");
          paramObject.append(paramToServiceMsg.getMessage());
          QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        }
        super.notifyUI(1001, bool2, null);
        return;
      }
    }
    else
    {
      try
      {
        i = Integer.parseInt(paramToServiceMsg);
      }
      catch (Exception paramToServiceMsg)
      {
        break label128;
      }
      i = 2;
      bool1 = ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject2).msg_external_info.has();
      if (!bool1) {
        break label789;
      }
      paramFromServiceMsg = new QidianExternalInfo();
      paramFromServiceMsg.from((mobileqq_qidian.ExternalInfo)((mobileqq_qidian.GetUserDetailInfoRspBody)localObject2).msg_external_info.get());
      localHashMap.put("external", paramFromServiceMsg);
      paramToServiceMsg = paramFromServiceMsg.uin;
      if (TextUtils.isEmpty(paramToServiceMsg)) {
        break label786;
      }
      ((QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).a(new BmqqAccountType(String.valueOf(paramToServiceMsg), 1));
      break label786;
      bool1 = ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject2).msg_internal_info.has();
      if (!bool1) {
        break label798;
      }
      paramObject = new QidianInternalInfo();
      paramObject.from((mobileqq_qidian.InternalInfo)((mobileqq_qidian.GetUserDetailInfoRspBody)localObject2).msg_internal_info.get());
      localHashMap.put("internal", paramObject);
      bool1 = ((mobileqq_qidian.GetUserDetailInfoRspBody)localObject2).msg_corp_info.has();
      if (!bool1) {
        break label803;
      }
      localObject1 = new QidianCorpInfo();
      ((QidianCorpInfo)localObject1).from((mobileqq_qidian.CorpInfo)((mobileqq_qidian.GetUserDetailInfoRspBody)localObject2).msg_corp_info.get());
      localHashMap.put("corp", localObject1);
      bool1 = TextUtils.isEmpty(paramToServiceMsg);
      if ((bool1) || (!((mobileqq_qidian.GetUserDetailInfoRspBody)localObject2).rpt_msg_config_group_info.has())) {
        break label809;
      }
      localQidianProfileUiInfo = new QidianProfileUiInfo();
      localQidianProfileUiInfo.from(paramToServiceMsg, (mobileqq_qidian.GetUserDetailInfoRspBody)localObject2);
      localHashMap.put("ConfigGroupInfo", localQidianProfileUiInfo);
    }
    for (;;)
    {
      if (i == 3)
      {
        QidianManager localQidianManager = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        localObject2 = localQidianManager.a(paramToServiceMsg);
        if (localObject2 != null) {
          ((QidianExternalInfo)localObject2).update(paramFromServiceMsg);
        }
        QidianInternalInfo localQidianInternalInfo = localQidianManager.a(paramToServiceMsg);
        if (localQidianInternalInfo != null) {
          localQidianInternalInfo.update(paramObject);
        }
        ((QidianCorpInfo)localObject1).corpUin = paramFromServiceMsg.masterUin;
        QidianCorpInfo localQidianCorpInfo = localQidianManager.a(((QidianCorpInfo)localObject1).corpUin);
        if (localQidianCorpInfo != null) {
          localQidianCorpInfo.update((QidianCorpInfo)localObject1);
        }
        paramToServiceMsg = localQidianManager.a(paramToServiceMsg);
        if ((localObject2 != null) && (localQidianInternalInfo != null) && (localQidianCorpInfo != null) && (paramToServiceMsg != null))
        {
          localHashMap.put("external", localObject2);
          localHashMap.put("internal", localQidianInternalInfo);
          localHashMap.put("corp", localQidianCorpInfo);
          localHashMap.put("ConfigGroupInfo", paramToServiceMsg);
          a(paramFromServiceMsg, paramObject, (QidianCorpInfo)localObject1, localQidianProfileUiInfo);
          super.notifyUI(1001, true, localHashMap);
        }
      }
      else
      {
        a(paramFromServiceMsg, paramObject, (QidianCorpInfo)localObject1, localQidianProfileUiInfo);
        super.notifyUI(1001, true, localHashMap);
        return;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = jdField_a_of_type_JavaLangString;
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetUserDetailInfo uint32_ret_code: ");
          paramFromServiceMsg.append(bool1);
          QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
        }
        super.notifyUI(1001, bool2, null);
        return;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserDetailInfo no msg_subcmd_get_user_detail_info_rsp_body");
        }
        super.notifyUI(1001, bool2, null);
        return;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = jdField_a_of_type_JavaLangString;
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetUserDetailInfo isSuccess: ");
          paramFromServiceMsg.append(bool2);
          QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
        }
        super.notifyUI(1001, bool2, null);
      }
      return;
      label780:
      bool1 = false;
      break;
      label786:
      break label222;
      label789:
      paramObject = null;
      paramToServiceMsg = paramFromServiceMsg;
      paramFromServiceMsg = paramObject;
      break label222;
      label798:
      paramObject = null;
      break label273;
      label803:
      localObject1 = null;
      break label327;
      label809:
      localQidianProfileUiInfo = null;
    }
  }
  
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {
          break label124;
        }
        i = 1;
        if (i != 0)
        {
          paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramFromServiceMsg = new Oidb_0x7e7.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramFromServiceMsg.ret_code.has()) {
            paramFromServiceMsg.ret_code.get();
          }
          if (paramFromServiceMsg.ret_msg.has())
          {
            paramFromServiceMsg.ret_msg.get().toString();
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleReportWPA ", paramToServiceMsg);
        }
      }
      return;
      label124:
      int i = 0;
    }
  }
  
  public void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.getCustomerTransferInfo");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("kfext");
    if (bool)
    {
      paramFromServiceMsg = new mobileqq_qidian.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.msg_get_customer_transfer_info_rsp.has())
        {
          paramFromServiceMsg = (mobileqq_qidian.GetCustomerTransferInfoRspBody)paramFromServiceMsg.msg_get_customer_transfer_info_rsp.get();
          if (paramFromServiceMsg.msg_ret.uint32_ret_code.get() == 0)
          {
            b(paramToServiceMsg, paramFromServiceMsg.str_transfer_info.get(), paramFromServiceMsg.str_link_info.get(), paramFromServiceMsg.str_link_url.get(), paramFromServiceMsg.str_pt_url.get());
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetCustomerTransferInfo ", paramToServiceMsg);
        }
      }
    }
  }
  
  public void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetNavigationConfig");
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new mobileqq_qidian.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_get_navigation_menu_config_rsp_body.has())
        {
          paramToServiceMsg = (mobileqq_qidian.GetNavigationMenuConfigRspBody)paramToServiceMsg.msg_get_navigation_menu_config_rsp_body.get();
          if (paramToServiceMsg.msg_ret.uint32_ret_code.get() == 0)
          {
            paramFromServiceMsg = new QidianHandler.NavigationMenuConfig();
            paramFromServiceMsg.jdField_a_of_type_Int = paramToServiceMsg.int32_is_show.get();
            paramFromServiceMsg.jdField_b_of_type_Int = paramToServiceMsg.uint32_ver_no.get();
            paramFromServiceMsg.jdField_a_of_type_Long = paramToServiceMsg.uint64_puin.get();
            paramFromServiceMsg.jdField_b_of_type_Long = paramToServiceMsg.uint64_kf_uin.get();
            paramFromServiceMsg.c = paramToServiceMsg.uint32_is_show_graytip.get();
            notifyUI(1006, true, paramFromServiceMsg);
            return;
          }
          notifyUI(1006, false, null);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetNavigationConfig error return");
          return;
        }
        notifyUI(1006, false, null);
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetNavigationConfig without body");
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        notifyUI(1006, false, null);
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetNavigationConfig ", paramToServiceMsg);
    }
    else
    {
      notifyUI(1006, false, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetNavigationConfig-false");
      }
    }
  }
  
  public void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = a(paramToServiceMsg, paramFromServiceMsg, paramObject, "QidianSsoProto.fetchCorpDetailInfo");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
    int i;
    if (bool)
    {
      Object localObject = new mobileqq_qidian.RspBody();
      try
      {
        ((mobileqq_qidian.RspBody)localObject).mergeFrom((byte[])paramObject);
        localHashMap = new HashMap();
        if (((mobileqq_qidian.RspBody)localObject).msg_get_corpuin_detail_info_rsp_body.has())
        {
          localGetCorpUinDetailInfoRspBody = (mobileqq_qidian.GetCorpUinDetailInfoRspBody)((mobileqq_qidian.RspBody)localObject).msg_get_corpuin_detail_info_rsp_body.get();
          if (localGetCorpUinDetailInfoRspBody.int32_ret.get() != 0) {
            break label543;
          }
          i = 1;
          if (i != 0) {
            paramToServiceMsg = paramToServiceMsg.extraData.getString("req_type");
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        HashMap localHashMap;
        mobileqq_qidian.GetCorpUinDetailInfoRspBody localGetCorpUinDetailInfoRspBody;
        label125:
        QidianManager localQidianManager;
        QidianExternalInfo localQidianExternalInfo;
        String str;
        label325:
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = jdField_a_of_type_JavaLangString;
          paramObject = new StringBuilder();
          paramObject.append("handleGetQidianMasterDetailInfo exception: ");
          paramObject.append(paramToServiceMsg.getMessage());
          QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        }
        super.notifyUI(1009, false, null);
        return;
      }
    }
    else
    {
      try
      {
        i = Integer.parseInt(paramToServiceMsg);
      }
      catch (Exception paramToServiceMsg)
      {
        break label125;
      }
      i = 0;
      if (!localGetCorpUinDetailInfoRspBody.msg_external_info.has()) {
        break label549;
      }
      localObject = new QidianExternalInfo();
      paramToServiceMsg = (mobileqq_qidian.ExternalInfo)localGetCorpUinDetailInfoRspBody.msg_external_info.get();
      ((QidianExternalInfo)localObject).from(paramToServiceMsg);
      localQidianManager = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
      localQidianExternalInfo = localQidianManager.a(paramFromServiceMsg);
      if (localQidianExternalInfo != null)
      {
        if (i == 2)
        {
          localQidianExternalInfo.isShowVideoCall = ((QidianExternalInfo)localObject).isShowVideoCall;
        }
        else if (i == 0)
        {
          if (!paramToServiceMsg.uint32_videoshow.has()) {
            ((QidianExternalInfo)localObject).isShowVideoCall = localQidianExternalInfo.isShowVideoCall;
          }
          localQidianExternalInfo.update((QidianExternalInfo)localObject);
        }
        localHashMap.put("external", localQidianExternalInfo);
      }
      else
      {
        localHashMap.put("external", localObject);
      }
      str = ((QidianExternalInfo)localObject).uin;
      paramToServiceMsg = localQidianExternalInfo;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramObject = str;
      if (!TextUtils.isEmpty(str))
      {
        localQidianManager.a(new BmqqAccountType(String.valueOf(str), 6));
        paramToServiceMsg = localQidianExternalInfo;
        paramFromServiceMsg = (FromServiceMsg)localObject;
        paramObject = str;
      }
      if ((TextUtils.isEmpty(paramObject)) || (!localGetCorpUinDetailInfoRspBody.rpt_msg_config_group_info.has())) {
        break label558;
      }
      localObject = new QidianProfileUiInfo();
      ((QidianProfileUiInfo)localObject).from(paramObject, localGetCorpUinDetailInfoRspBody);
      localHashMap.put("ConfigGroupInfo", localObject);
      paramObject = localObject;
    }
    for (;;)
    {
      if (paramToServiceMsg != null) {
        a(paramToServiceMsg, paramObject);
      } else {
        a(paramFromServiceMsg, paramObject);
      }
      super.notifyUI(1009, true, localHashMap);
      return;
      super.notifyUI(1009, false, null);
      return;
      super.notifyUI(1009, false, null);
      return;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = jdField_a_of_type_JavaLangString;
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetQidianMasterDetailInfo isSuccess: ");
        paramFromServiceMsg.append(bool);
        QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
      }
      super.notifyUI(1009, bool, null);
      return;
      label543:
      i = 0;
      break;
      label549:
      paramObject = paramFromServiceMsg;
      paramToServiceMsg = null;
      paramFromServiceMsg = paramToServiceMsg;
      break label325;
      label558:
      paramObject = null;
    }
  }
  
  public void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (paramObject != null)
      {
        try
        {
          paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.get() == 0))
          {
            if ((!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
              return;
            }
            paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
            int i = paramFromServiceMsg[0];
            if (i == 0)
            {
              PkgTools.getShortData(paramFromServiceMsg, 1);
              PkgTools.getShortData(paramFromServiceMsg, 3);
              i = PkgTools.getShortData(paramFromServiceMsg, 5);
              paramToServiceMsg = new byte[i];
              PkgTools.getBytesData(paramFromServiceMsg, 7, paramToServiceMsg, i);
              paramToServiceMsg = PkgTools.getUTFString(paramToServiceMsg, 0, i);
              i = 7 + i;
              PkgTools.getShortData(paramFromServiceMsg, i);
              i += 2;
              int j = PkgTools.getShortData(paramFromServiceMsg, i);
              paramObject = new byte[j];
              PkgTools.getBytesData(paramFromServiceMsg, i + 2, paramObject, j);
              paramFromServiceMsg = PkgTools.getUTFString(paramObject, 0, j);
              paramObject = new HashMap();
              paramObject.put("plain_text", paramToServiceMsg);
              paramObject.put("cipher_text", paramFromServiceMsg);
              notifyUI(1019, true, paramObject);
              return;
            }
            paramToServiceMsg = jdField_a_of_type_JavaLangString;
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleQidianPrivateTroopUin result is ");
            paramFromServiceMsg.append(i);
            QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
            notifyUI(1019, false, null);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleQidianPrivateTroopUin pkg is null");
          }
          notifyUI(1019, false, null);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = jdField_a_of_type_JavaLangString;
            paramObject = new StringBuilder();
            paramObject.append("handleQidianPrivateTroopUin throw exception is ");
            paramObject.append(paramToServiceMsg.toString());
            QLog.d(paramFromServiceMsg, 2, paramObject.toString());
          }
          notifyUI(1019, false, null);
          return;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleQidianPrivateTroopUin data is null");
        }
        notifyUI(1019, false, null);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleQidianPrivateTroopUin res is fail");
      }
      notifyUI(1019, false, null);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QidianBusinessObserverBase.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive cmd: ");
      localStringBuilder.append(str1);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.WpaAssignKfext"))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.clickReplyCmd"))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.getUserDetailInfo"))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.verifyWpaAndKey"))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.getShieldStatus"))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("OidbSvc.0x7e7_0"))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.blockBulkMsg"))
    {
      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.getCustomerTransferInfo"))
    {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.getNavigationConfig"))
    {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.corpUinWpaReport"))
    {
      m(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.emanClickReport"))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equals("QidianSsoProto.fetchCorpDetailInfo"))
    {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.closeAIOSessionReport"))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.WpaGenSigMsg"))
    {
      o(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.webimAddFriend"))
    {
      p(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("QidianSsoProto.getQidianGroupInfo"))
    {
      q(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (str1.equalsIgnoreCase("OidbSvc.0x782")) {
      l(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianHandler
 * JD-Core Version:    0.7.0.1
 */