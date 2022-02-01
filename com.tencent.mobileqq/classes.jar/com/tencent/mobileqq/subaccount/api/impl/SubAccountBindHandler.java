package com.tencent.mobileqq.subaccount.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.ISubAccountServlet;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.LoginSig;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.ReqBody;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.RspBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1.ReqBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1.RspBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.ReqBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@KeepClassConstructor
public class SubAccountBindHandler
  extends BusinessHandler
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  String jdField_a_of_type_JavaLangString = "OidbSvc.0x7a0_0";
  String b;
  String c = "OidbSvc.0x7a2_0";
  
  SubAccountBindHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_b_of_type_JavaLangString = "OidbSvc.0x7a1_0";
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  @Nullable
  private oidb_sso.OIDBSSOPkg a(int paramInt1, byte[] paramArrayOfByte, SubAccountBackProtocData paramSubAccountBackProtocData, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    if (paramInt1 != 1000) {
      return null;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramArrayOfByte = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getPkg InvalidProtocolBufferMicroException");
      }
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = localOIDBSSOPkg;
    }
    if ((paramArrayOfByte.uint32_result.has()) && (paramArrayOfByte.uint32_result.get() == 0))
    {
      if ((paramArrayOfByte.bytes_bodybuffer.has()) && (paramArrayOfByte.bytes_bodybuffer.get() != null)) {
        return paramArrayOfByte;
      }
      a("12008", paramString4, paramString2, paramString3, false);
      paramSubAccountBackProtocData.jdField_a_of_type_Int = 1000;
      notifyUI(paramInt2, false, paramSubAccountBackProtocData);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getPkg !pkg.bytes_bodybuffer.has() || pkg.bytes_bodybuffer.get() == null");
      }
      return null;
    }
    a("12008", paramString1, paramString2, paramString3, false);
    paramSubAccountBackProtocData.jdField_a_of_type_Int = 1001;
    notifyUI(paramInt2, false, paramSubAccountBackProtocData);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getPkg !pkg.uint32_result.has() || pkg.uint32_result.get() != 0");
    }
    return null;
  }
  
  private void a(SubAccountBackProtocData paramSubAccountBackProtocData, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (paramInt1 == 1000) {
      return;
    }
    if ((paramInt1 != 1002) && (paramInt1 != 1013))
    {
      a("12012", paramString2, paramString3, paramString1, false);
      paramSubAccountBackProtocData.jdField_a_of_type_Int = 1000;
      if (QLog.isColorLevel()) {
        QLog.e("SUB_ACCOUNT", 2, "handlerRspFailed ERROR_TYPE_UNKNOWN last");
      }
    }
    else
    {
      a("12010", "timeout", paramString3, paramString1, false);
      paramSubAccountBackProtocData.jdField_a_of_type_Int = 1007;
      if (QLog.isColorLevel()) {
        QLog.e("SUB_ACCOUNT", 2, "handlerRspFailed ERROR_TYPE_SERVER_TIMEOUT");
      }
    }
    notifyUI(paramInt2, false, paramSubAccountBackProtocData);
  }
  
  private void a(SubAccountBackProtocData paramSubAccountBackProtocData, ISubAccountService paramISubAccountService)
  {
    paramISubAccountService.updateSubAccountInfo(paramSubAccountBackProtocData);
    ArrayList localArrayList = paramSubAccountBackProtocData.a();
    Object localObject1;
    Object localObject2;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handlerGetBindSubAccount() hint is new,msg num=1, subUin=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = (IConversationFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IConversationFacade.class, "");
        i = 1 - ((IConversationFacade)localObject2).getUnreadCount((String)localObject1, 7000);
        if (i != 0) {
          ((IConversationFacade)localObject2).increaseUnread((String)localObject1, 7000, i);
        }
      }
    }
    Iterator localIterator = paramSubAccountBackProtocData.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      boolean bool1 = localArrayList.contains(localObject1);
      boolean bool2 = ((Boolean)SubAccountControllUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject1).second).booleanValue();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handlerGetBindSubAccount() subUin=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" isLogin = ");
        ((StringBuilder)localObject2).append(bool2);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool2)
      {
        paramISubAccountService.setStatus((String)localObject1, 1);
        localObject2 = SubAccountBackProtocData.a(paramSubAccountBackProtocData);
        ((SubAccountBackProtocData)localObject2).c = ((String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        ((AppInterface)localObject1).getSubAccountKey(((AppInterface)localObject1).getAccount(), ((SubAccountBackProtocData)localObject2).c, new SubAccountBindHandler.1(this, (SubAccountBackProtocData)localObject2, paramISubAccountService, bool1));
        i = 0;
      }
      else
      {
        if (paramISubAccountService.setStatus((String)localObject1, 2))
        {
          localObject2 = (IConversationFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IConversationFacade.class, "");
          int j = 1 - ((IConversationFacade)localObject2).getUnreadCount((String)localObject1, 7000);
          if (j != 0)
          {
            ((IConversationFacade)localObject2).increaseUnread((String)localObject1, 7000, j);
            ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, localObject1 });
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handlerGetBindSubAccount() hint need to verify,msg num=1, subUin=");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount, has subaccount but islogin is false");
        }
        paramISubAccountService.updateA2((String)localObject1, null, bool1);
      }
    }
    if (i != 0) {
      notifyUI(2, true, paramSubAccountBackProtocData);
    }
  }
  
  private void a(SubAccountBackProtocData paramSubAccountBackProtocData, oidb_0x7a2.RspBody paramRspBody)
  {
    a("12009", "success_0", "SubBind", "actSBGetbindProtol", true);
    ISubAccountService localISubAccountService = (ISubAccountService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ISubAccountService.class, "");
    Object localObject = localISubAccountService.getAllSubUin();
    paramSubAccountBackProtocData.jdField_a_of_type_Int = 0;
    paramSubAccountBackProtocData.a(paramRspBody, (ArrayList)localObject);
    localObject = paramSubAccountBackProtocData.b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      paramRspBody = (ISubAccountControlService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramRspBody.addHintPair((String)((Iterator)localObject).next(), 1);
      }
    }
    if (paramSubAccountBackProtocData.c())
    {
      a(paramSubAccountBackProtocData, localISubAccountService);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount, not has subaccount");
    }
    paramSubAccountBackProtocData.jdField_a_of_type_Int = 1008;
    SubAccountControllUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "sub.uin.all");
    notifyUI(2, true, paramSubAccountBackProtocData);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, SubAccountBackProtocData paramSubAccountBackProtocData, int paramInt)
  {
    if (paramInt == 1000) {
      return;
    }
    if (paramInt == 2901)
    {
      paramInt = paramToServiceMsg.extraData.getInt("fastResendCount", 0);
      paramSubAccountBackProtocData = paramToServiceMsg.extraData.getByteArray("request_ByteArray");
      paramToServiceMsg = createToServiceMsg(this.c);
      int i = paramInt + 1;
      if (i < 3)
      {
        paramToServiceMsg.setEnableFastResend(true);
        paramToServiceMsg.extraData.putInt("fastResendCount", i);
        paramToServiceMsg.extraData.putByteArray("request_ByteArray", paramSubAccountBackProtocData);
      }
      paramToServiceMsg.putWupBuffer(paramSubAccountBackProtocData);
      if (QLog.isColorLevel())
      {
        paramSubAccountBackProtocData = new StringBuilder();
        paramSubAccountBackProtocData.append("handlerGetBindSubAccount() result==2901, resend count=");
        paramSubAccountBackProtocData.append(paramInt);
        paramSubAccountBackProtocData.append(" setFastResend=");
        paramSubAccountBackProtocData.append(paramToServiceMsg.isFastResendEnabled());
        QLog.d("SUB_ACCOUNT", 2, paramSubAccountBackProtocData.toString());
      }
      sendPbReq(paramToServiceMsg);
      return;
    }
    paramSubAccountBackProtocData.jdField_b_of_type_Boolean = true;
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("result_");
    paramToServiceMsg.append(paramInt);
    a(paramSubAccountBackProtocData, paramInt, "actSBGetbindProtol", paramToServiceMsg.toString(), "SubBind", 2);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handlerBindSubAccount() time = ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    Object localObject3;
    if (paramToServiceMsg != null)
    {
      localObject1 = paramToServiceMsg.getUin();
      localObject2 = paramToServiceMsg.extraData.getString("subAccount");
      localObject3 = paramToServiceMsg.extraData.getString("fromWhere");
    }
    else
    {
      localSubAccountBackProtocData = null;
      localObject1 = localSubAccountBackProtocData;
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = localSubAccountBackProtocData;
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    try
    {
      if (a(paramToServiceMsg, paramFromServiceMsg, localSubAccountBackProtocData, 0, "", "")) {
        return;
      }
      int i = paramFromServiceMsg.getResultCode();
      localSubAccountBackProtocData.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localSubAccountBackProtocData.c = ((String)localObject2);
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("fali_end_rs_");
      paramFromServiceMsg.append(i);
      a(localSubAccountBackProtocData, i, "actSBDBindProtol", paramFromServiceMsg.toString(), "bindhandle", 0);
      paramFromServiceMsg = a(i, (byte[])paramObject, localSubAccountBackProtocData, "uint32_not_rs", "bindhandle", "actSBDBindProtol", 0, "body_buff_not");
      if (paramFromServiceMsg == null) {
        return;
      }
      paramObject = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      paramFromServiceMsg = new oidb_0x7a0.RspBody();
      try
      {
        paramObject = (oidb_0x7a0.RspBody)paramFromServiceMsg.mergeFrom(paramObject);
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() oidb_0x7a0 parseFrom byte InvalidProtocolBufferMicroException");
        }
        paramObject.printStackTrace();
      }
      i = paramFromServiceMsg.uint32_result.get();
      localSubAccountBackProtocData.jdField_b_of_type_Int = i;
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handlerBindSubAccount() rspResult = ");
        paramObject.append(i);
        QLog.d("SUB_ACCOUNT", 2, paramObject.toString());
      }
      a(paramToServiceMsg, (String)localObject1, (String)localObject2, (String)localObject3, localSubAccountBackProtocData, paramFromServiceMsg, i);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      a("12013", "exception", "bindhandle", "actSBDBindProtol", false);
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handlerBindSubAccount() last exception errormsg = ");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.d("SUB_ACCOUNT", 2, paramFromServiceMsg.toString());
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString1, String paramString2, String paramString3, SubAccountBackProtocData paramSubAccountBackProtocData, oidb_0x7a0.RspBody paramRspBody, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 0)
    {
      a("12009", "sucess_0", "bindhandle", "actSBDBindProtol", true);
      paramSubAccountBackProtocData.jdField_a_of_type_Int = 0;
      paramString1 = (ISubAccountService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ISubAccountService.class, "");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
      if (paramString1 != null)
      {
        paramString1.updateSubAccountInfo(paramSubAccountBackProtocData);
        paramString1.setStatus(paramString2, 1);
        paramString1.updateA2(paramString2, paramToServiceMsg, true);
      }
      SubAccountControllUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (byte)1, paramString2);
      SubAccountControllUtil.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false, paramString2);
      SubAccountControllUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString2, false);
      if (!((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
        ((ISubAccountServlet)QRoute.api(ISubAccountServlet.class)).fetchOneTroopNewMsg(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString2);
      }
      bool1 = bool2;
      if (((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getAccountManagerName().equals(paramString3))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8004003", "0X8004003", 0, 0, "", "", "", "");
        bool1 = bool2;
      }
    }
    else
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("Bind_fail_rsp_");
      paramToServiceMsg.append(paramInt);
      paramToServiceMsg = paramToServiceMsg.toString();
      if ((paramInt != 1000) && (paramInt != 1001)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      a("12011", paramToServiceMsg, "bindhandle", "actSBDBindProtol", bool1);
      paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString = paramRspBody.str_errmsg.get();
      if (paramInt != 1000)
      {
        if (paramInt != 1001)
        {
          if (a(paramInt))
          {
            paramToServiceMsg = String.valueOf(paramRspBody.uint64_err_uin.get());
            if ((paramString2 != null) && (paramToServiceMsg.equalsIgnoreCase(paramString2)))
            {
              paramSubAccountBackProtocData.jdField_a_of_type_Int = 1004;
              this.jdField_a_of_type_ComTencentCommonAppAppInterface.updateSubAccountLogin(paramSubAccountBackProtocData.c, false);
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_SUBACCOUNT_A2_ERROR");
              }
            }
            else if ((paramString1 != null) && (paramString1.equalsIgnoreCase(paramToServiceMsg)))
            {
              paramSubAccountBackProtocData.jdField_a_of_type_Int = 1005;
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_MAINACCOUNT_A2_ERROR");
              }
            }
            else
            {
              paramSubAccountBackProtocData.jdField_a_of_type_Int = 1000;
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_UNKNOW");
              }
            }
          }
          else if (paramInt == 1221)
          {
            paramSubAccountBackProtocData.jdField_a_of_type_Int = 1011;
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_EQLIP_LOCK_FAIL");
            }
          }
          else
          {
            paramSubAccountBackProtocData.jdField_a_of_type_Int = 1000;
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_UNKNOW");
            }
          }
        }
        else
        {
          paramSubAccountBackProtocData.jdField_a_of_type_Int = 1003;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_SUB_HADBIND_ANOTHER");
          }
        }
      }
      else
      {
        paramSubAccountBackProtocData.jdField_a_of_type_Int = 1002;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_MAIN_HADBIND_ANOTHER");
        }
      }
      bool1 = false;
    }
    notifyUI(0, bool1, paramSubAccountBackProtocData);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramString1);
    localHashMap.put("fail_step", paramString2);
    localHashMap.put("fail_location", paramString3);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramString4, paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 1200) || (paramInt == 1214) || (paramInt == 1215) || (paramInt == 1218) || (paramInt == 1232) || (paramInt == 1233) || (paramInt == 1240) || (paramInt == 1241) || (paramInt == 1242);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SubAccountBackProtocData paramSubAccountBackProtocData, int paramInt, String paramString1, String paramString2)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null)) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString1)) {
      a("12007", "req_null", paramString2, paramString1, false);
    }
    paramSubAccountBackProtocData.jdField_a_of_type_Int = 1000;
    notifyUI(paramInt, false, paramSubAccountBackProtocData);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerRespEmpty: req == null || resp == null");
    }
    return true;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() start");
    }
    Object localObject;
    String str;
    if (paramToServiceMsg != null)
    {
      localObject = paramToServiceMsg.extraData.getString("subAccount");
      str = paramToServiceMsg.getUin();
    }
    else
    {
      str = null;
      localObject = str;
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    for (;;)
    {
      try
      {
        if (a(paramToServiceMsg, paramFromServiceMsg, localSubAccountBackProtocData, 1, "actSBUnbindProtol", "SubBind")) {
          return;
        }
        int i = paramFromServiceMsg.getResultCode();
        localSubAccountBackProtocData.jdField_b_of_type_JavaLangString = str;
        localSubAccountBackProtocData.c = ((String)localObject);
        a(localSubAccountBackProtocData, i, "actSBUnbindProtol", "error", "SubBind", 1);
        paramToServiceMsg = a(i, (byte[])paramObject, localSubAccountBackProtocData, "pkg32rs_null", "SubBind", "actSBUnbindProtol", 1, "bytebody_null");
        if (paramToServiceMsg == null) {
          return;
        }
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0x7a1.RspBody();
        try
        {
          paramFromServiceMsg = (oidb_0x7a1.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
          paramToServiceMsg = paramFromServiceMsg;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() oidb_0x7a1 parseFrom byte InvalidProtocolBufferMicroException");
          }
          paramFromServiceMsg.printStackTrace();
        }
        i = paramToServiceMsg.uint32_result.get();
        localSubAccountBackProtocData.jdField_b_of_type_Int = i;
        localSubAccountBackProtocData.jdField_a_of_type_JavaLangString = paramToServiceMsg.str_errmsg.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handlerUnBindSubAccount()  rspResult = ");
          paramFromServiceMsg.append(i);
          QLog.d("SUB_ACCOUNT", 2, paramFromServiceMsg.toString());
        }
        boolean bool1 = false;
        if ((i != 0) && (i != 1000) && (i != 1001))
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("rspResult_");
          paramFromServiceMsg.append(i);
          a("12011", paramFromServiceMsg.toString(), "SubBind", "actSBUnbindProtol", false);
          boolean bool2 = a(i);
          if (bool2)
          {
            paramToServiceMsg = String.valueOf(paramToServiceMsg.uint64_err_uin.get());
            if ((localObject != null) && (paramToServiceMsg.equalsIgnoreCase((String)localObject)))
            {
              if (QLog.isColorLevel()) {
                QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: server error happen subaccount a2 error? not it is not happan");
              }
            }
            else if ((str != null) && (str.equalsIgnoreCase(paramToServiceMsg)))
            {
              localSubAccountBackProtocData.jdField_a_of_type_Int = 1005;
              if (QLog.isColorLevel()) {
                QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_MAINACCOUNT_A2_ERROR");
              }
            }
            else
            {
              localSubAccountBackProtocData.jdField_a_of_type_Int = 1000;
              if (QLog.isColorLevel()) {
                QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
              }
            }
          }
          else
          {
            localSubAccountBackProtocData.jdField_a_of_type_Int = 1000;
            if (QLog.isColorLevel()) {
              QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
            }
          }
        }
        else
        {
          a("12009", "rspResult_0", "SubBind", "actSBUnbindProtol", true);
          localSubAccountBackProtocData.jdField_a_of_type_Int = 0;
          SubAccountControllUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject);
          bool1 = true;
          notifyUI(1, bool1, localSubAccountBackProtocData);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        a("12013", "exception", "SubBind", "actSBUnbindProtol", false);
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handlerUnBindSubAccount:   error e = ");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("SUB_ACCOUNT", 2, paramFromServiceMsg.toString());
        }
        return;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount:");
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    try
    {
      if (a(paramToServiceMsg, paramFromServiceMsg, localSubAccountBackProtocData, 2, "actSBGetbindProtol", "SubBind")) {
        return;
      }
      int i = paramFromServiceMsg.getResultCode();
      localSubAccountBackProtocData.jdField_b_of_type_JavaLangString = paramToServiceMsg.getUin();
      a(paramToServiceMsg, localSubAccountBackProtocData, i);
      paramToServiceMsg = a(i, (byte[])paramObject, localSubAccountBackProtocData, "pkguint32_null", "SubBind", "actSBGetbindProtol", 2, "bytebody_null");
      if (paramToServiceMsg == null) {
        return;
      }
      paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      paramToServiceMsg = new oidb_0x7a2.RspBody();
      try
      {
        paramFromServiceMsg = (oidb_0x7a2.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: parseFrom byte InvalidProtocolBufferMicroException ");
        }
        paramFromServiceMsg.printStackTrace();
      }
      i = paramToServiceMsg.uint32_result.get();
      localSubAccountBackProtocData.jdField_b_of_type_Int = i;
      localSubAccountBackProtocData.jdField_a_of_type_JavaLangString = paramToServiceMsg.str_errmsg.get();
      if (i == 0)
      {
        a(localSubAccountBackProtocData, paramToServiceMsg);
        return;
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("rspResult_");
      paramToServiceMsg.append(i);
      a("12011", paramToServiceMsg.toString(), "SubBind", "actSBGetbindProtol", false);
      if (a(i))
      {
        localSubAccountBackProtocData.jdField_a_of_type_Int = 1005;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handlerGetBindSubAccount: get main account a2 error rspResult = ");
          paramToServiceMsg.append(i);
          QLog.d("SUB_ACCOUNT", 2, paramToServiceMsg.toString());
        }
      }
      else
      {
        localSubAccountBackProtocData.jdField_a_of_type_Int = 1000;
        localSubAccountBackProtocData.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handlerGetBindSubAccount: get main account error rspResult = ");
          paramToServiceMsg.append(i);
          QLog.d("SUB_ACCOUNT", 2, paramToServiceMsg.toString());
        }
      }
      notifyUI(2, false, localSubAccountBackProtocData);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      a("12013", "exception", "SubBind", "actSBGetbindProtol", false);
      paramToServiceMsg.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handlerGetBindSubAccount: exception happen e = ");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.e("SUB_ACCOUNT", 2, paramFromServiceMsg.toString());
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getBindSubAccount: start");
    }
    Object localObject1 = new oidb_0x7a2.ReqBody();
    ((oidb_0x7a2.ReqBody)localObject1).uint32_flag.set(1);
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1954);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a2.ReqBody)localObject1).toByteArray()));
    localObject1 = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
    localObject2 = createToServiceMsg(this.c);
    ((ToServiceMsg)localObject2).setEnableFastResend(true);
    ((ToServiceMsg)localObject2).extraData.putInt("fastResendCount", 0);
    ((ToServiceMsg)localObject2).extraData.putByteArray("request_ByteArray", (byte[])localObject1);
    ((ToServiceMsg)localObject2).putWupBuffer((byte[])localObject1);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unBindSubAccount: start");
    }
    Object localObject1 = new oidb_0x7a1.ReqBody();
    ((oidb_0x7a1.ReqBody)localObject1).uint32_flag.set(1);
    Object localObject2 = DeviceInfoUtil.a();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((oidb_0x7a1.ReqBody)localObject1).str_imei.set((String)localObject2);
    }
    ((oidb_0x7a1.ReqBody)localObject1).uint64_bind_uin.set(Long.parseLong(paramString));
    ((oidb_0x7a1.ReqBody)localObject1).uint32_clt_appid.set(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAppid());
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1953);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a1.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg(this.jdField_b_of_type_JavaLangString);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("subAccount", paramString);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindSubAccount() start");
    }
    oidb_0x7a0.LoginSig localLoginSig = new oidb_0x7a0.LoginSig();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString2 != null) {
      try
      {
        localObject1 = PkgTools.hexToBytes(paramString2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = localObject3;
      }
    }
    if (localObject2 != null) {
      localLoginSig.bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject2));
    }
    localLoginSig.uint32_type.set(8);
    localLoginSig.uint32_appid.set(16);
    Object localObject2 = new oidb_0x7a0.ReqBody();
    ((oidb_0x7a0.ReqBody)localObject2).uint32_flag.set(1);
    ((oidb_0x7a0.ReqBody)localObject2).msg_bind_uin_sig.set(localLoginSig);
    localObject3 = DeviceInfoUtil.a();
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      ((oidb_0x7a0.ReqBody)localObject2).str_imei.set((String)localObject3);
    }
    ((oidb_0x7a0.ReqBody)localObject2).uint64_bind_uin.set(Long.parseLong(paramString1));
    ((oidb_0x7a0.ReqBody)localObject2).uint32_clt_appid.set(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAppid());
    localObject3 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1952);
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a0.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg(this.jdField_a_of_type_JavaLangString);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject3).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putString("subAccount", paramString1);
    ((ToServiceMsg)localObject2).extraData.putString("subaccount_a2", paramString2);
    if (paramString3 != null) {
      ((ToServiceMsg)localObject2).extraData.putString("fromWhere", paramString3);
    }
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public Set<String> getPushCommandList()
  {
    HashSet localHashSet = new HashSet(8);
    localHashSet.add(this.jdField_b_of_type_JavaLangString);
    localHashSet.add(this.c);
    localHashSet.add(this.jdField_a_of_type_JavaLangString);
    return localHashSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return SubAccountBindObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str != null)
    {
      if (str.length() == 0) {
        return;
      }
      if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (this.c.equalsIgnoreCase(str)) {
        try
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        catch (VerifyError paramToServiceMsg)
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handlerGetBindSubAccount VerifyError: ");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.e("SUB_ACCOUNT", 2, paramFromServiceMsg.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.impl.SubAccountBindHandler
 * JD-Core Version:    0.7.0.1
 */