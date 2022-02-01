package com.tencent.mobileqq.teamwork.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.ReSendCmd;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.teamwork.TimDocSSOMsg.GetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.GetPadRightInfoRspBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.LoginInfo;
import com.tencent.pb.teamwork.TimDocSSOMsg.SetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.SetPadRightInfoRspBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupGetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupGetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupSetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.GroupSetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab.ReqBody;
import tencent.im.oidb.cmd0xbab.cmd0xbab.RspBody;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserGetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserGetRsp;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserSetReq;
import tencent.im.oidb.cmd0xbab.cmd0xbab.UserSetRsp;

public class TeamWorkHandlerImpl
  extends BusinessHandler
  implements ITeamWorkHandler
{
  private static final int UIN_TYPE_DOC_UID = 1;
  private static final int UIN_TYPE_FRIEND = 0;
  private static final int UIN_TYPE_GROUP = 3;
  private static final int UIN_TYPE_QUN = 2;
  private AppInterface app;
  private boolean enableTencentDocsAssistant = false;
  private boolean preloadToolProcess = false;
  private volatile int reTryGetPskeyCount = 0;
  private volatile int reTryGetSkeyCount = 0;
  
  public TeamWorkHandlerImpl(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.app = paramAppInterface;
    this.enableTencentDocsAssistant = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getCommonConfigBooleanValue(paramAppInterface.getApp(), paramAppInterface.getCurrentUin(), "tencent_docs_config_enable_assistant", false);
    this.preloadToolProcess = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getCommonConfigBooleanValue(paramAppInterface.getApp(), paramAppInterface.getCurrentUin(), "tencent_docs_config_preload_tool_process", false);
  }
  
  public static String getClassName()
  {
    return TeamWorkHandlerImpl.class.getName();
  }
  
  private String getPskeyFromServerAndRetry(ReSendCmd paramReSendCmd, boolean paramBoolean)
  {
    Object localObject1 = (TicketManager)this.app.getManager(2);
    if (localObject1 != null)
    {
      Object localObject2 = this.app.getCurrentAccountUin();
      TeamWorkHandlerImpl.1 local1 = new TeamWorkHandlerImpl.1(this, (TicketManager)localObject1, paramReSendCmd);
      localObject1 = ((TicketManager)localObject1).getPskey((String)localObject2, 16L, new String[] { "docs.qq.com" }, local1);
      if ((localObject1 != null) && (((Ticket)localObject1)._pskey_map != null) && (((Ticket)localObject1)._pskey_map.get("docs.qq.com") != null))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getPskeyFromServerAndRetry get pskey with promise success! isImediately Resend: ");
        ((StringBuilder)localObject2).append(paramBoolean);
        QLog.i("TeamWorkHandlerImpl", 1, ((StringBuilder)localObject2).toString());
        localObject1 = new String((byte[])((Ticket)localObject1)._pskey_map.get("docs.qq.com"));
        if (paramBoolean) {
          reTrySendCmd(paramReSendCmd);
        }
        return localObject1;
      }
      QLog.i("TeamWorkHandlerImpl", 1, "getPskeyFromServerAndRetry get pskey from server now!");
      return null;
    }
    QLog.e("TeamWorkHandlerImpl", 1, "getPskeyFromServerAndRetry,ticketmanager is null");
    return null;
  }
  
  private String getSkeyFromServerAndRetry(ReSendCmd paramReSendCmd)
  {
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    if (localTicketManager != null)
    {
      paramReSendCmd = localTicketManager.getSkey(this.app.getCurrentAccountUin(), 16L, new TeamWorkHandlerImpl.2(this, localTicketManager, paramReSendCmd));
      if ((paramReSendCmd != null) && (paramReSendCmd._sig != null))
      {
        paramReSendCmd = new String(paramReSendCmd._sig);
        QLog.i("TeamWorkHandlerImpl", 1, "getSkeyFromServerAndRetry get skey with promise success! ");
        return paramReSendCmd;
      }
      QLog.i("TeamWorkHandlerImpl", 1, "getSkeyFromServerAndRetry get skey from server now! ");
      return null;
    }
    QLog.e("TeamWorkHandlerImpl", 1, "getSkeyFromServerAndRetry,ticketmanager is null");
    return null;
  }
  
  private void handleGetGroupAuthDocsGrayTips(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
        long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
        paramToServiceMsg = new cmd0xbab.RspBody();
        int k = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (k == 0)
        {
          paramFromServiceMsg = (cmd0xbab.GroupGetRsp)paramToServiceMsg.group_get_rsp.get();
          int i = paramFromServiceMsg.policy.get();
          paramToServiceMsg = paramFromServiceMsg.user_list.get();
          int n = paramFromServiceMsg.total_members.get();
          int i1 = paramFromServiceMsg.privilege_members.get();
          int i2 = paramFromServiceMsg.privilege_flag.get();
          int i3 = paramFromServiceMsg.member_number.get();
          int m = paramFromServiceMsg.exp_remain_time.get();
          int j = paramFromServiceMsg.exp_set_time.get();
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("TeamWorkHandlerImpl");
          paramFromServiceMsg.append(TeamWorkConstants.i);
          paramFromServiceMsg = paramFromServiceMsg.toString();
          paramObject = new StringBuilder();
          paramObject.append(" handleGetGroupAuthDocsGrayTips  | policy = ");
          paramObject.append(i);
          paramObject.append(" userInfoList.size() = ");
          paramObject.append(paramToServiceMsg.size());
          paramObject.append(" totalMembers = ");
          paramObject.append(n);
          paramObject.append(" privilegeMembers = ");
          paramObject.append(i1);
          paramObject.append(" privilege = ");
          paramObject.append(i2);
          paramObject.append(" memberNum = ");
          paramObject.append(i3);
          paramObject.append(" remainTime = ");
          paramObject.append(m);
          paramObject.append(" setTime = ");
          paramObject.append(j);
          paramObject.append(" docsGrayTipsInfo.policy = ");
          paramObject.append(localDocsGrayTipsInfo.m);
          paramObject.append(" docsGrayTipsInfo.privilege = ");
          paramObject.append(localDocsGrayTipsInfo.n);
          QLog.i(paramFromServiceMsg, 1, paramObject.toString());
          if ((Integer.valueOf(localDocsGrayTipsInfo.n).intValue() == i2) && (Integer.valueOf(localDocsGrayTipsInfo.m).intValue() == i))
          {
            i = j;
            if (j != 0)
            {
              i = j;
              if (m == 0) {
                i = 0;
              }
            }
            setGroupAuthDocsGrayTips(localDocsGrayTipsInfo, i, l);
            paramToServiceMsg = "";
            bool = true;
          }
          else
          {
            paramToServiceMsg = this.app.getApp().getString(2131719549);
            break label605;
          }
        }
        else
        {
          paramToServiceMsg = localDocsGrayTipsInfo.k;
          break label605;
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("TeamWorkHandlerImpl");
        paramFromServiceMsg.append(TeamWorkConstants.i);
        paramFromServiceMsg = paramFromServiceMsg.toString();
        paramObject = new StringBuilder();
        paramObject.append(" handleGetGroupAuthDocsGrayTips. result = ");
        paramObject.append(k);
        paramObject.append(", isSuccess = ");
        paramObject.append(bool);
        QLog.i(paramFromServiceMsg, 1, paramObject.toString());
        if (!bool)
        {
          notifyUI(10, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("TeamWorkHandlerImpl");
        paramFromServiceMsg.append(TeamWorkConstants.i);
        paramFromServiceMsg = paramFromServiceMsg.toString();
        paramObject = new StringBuilder();
        paramObject.append(" handleGetGroupAuthDocsGrayTips exception = ");
        paramObject.append(paramToServiceMsg.toString());
        QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      }
      return;
      label605:
      boolean bool = false;
    }
  }
  
  private void handleGetUserAuthDocsGrayTips(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
        long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
        cmd0xbab.RspBody localRspBody = new cmd0xbab.RspBody();
        int k = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
        paramToServiceMsg = "";
        if (k == 0)
        {
          paramFromServiceMsg = (cmd0xbab.UserGetRsp)localRspBody.user_get_rsp.get();
          int i = paramFromServiceMsg.policy.get();
          int n = paramFromServiceMsg.privilege_flag.get();
          int i1 = paramFromServiceMsg.member_number.get();
          int m = paramFromServiceMsg.exp_remain_time.get();
          int j = paramFromServiceMsg.exp_set_time.get();
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("TeamWorkHandlerImpl");
          paramFromServiceMsg.append(TeamWorkConstants.i);
          paramFromServiceMsg = paramFromServiceMsg.toString();
          paramObject = new StringBuilder();
          paramObject.append(" handleGetUserAuthDocsGrayTips  | policy=");
          paramObject.append(i);
          paramObject.append(" privilege =");
          paramObject.append(n);
          paramObject.append(" memberNum = ");
          paramObject.append(i1);
          paramObject.append(" remainTime = ");
          paramObject.append(m);
          paramObject.append(" setTime= ");
          paramObject.append(j);
          QLog.i(paramFromServiceMsg, 2, paramObject.toString());
          if ((Integer.valueOf(localDocsGrayTipsInfo.n).intValue() == n) && (Integer.valueOf(localDocsGrayTipsInfo.m).intValue() == i))
          {
            i = j;
            if (j != 0)
            {
              i = j;
              if (m == 0) {
                i = 0;
              }
            }
            setUserAuthDocsGrayTips(localDocsGrayTipsInfo, i, l);
            bool = true;
          }
          else
          {
            paramToServiceMsg = this.app.getApp().getString(2131719549);
            break label489;
          }
        }
        else
        {
          paramToServiceMsg = localDocsGrayTipsInfo.k;
          break label489;
        }
        if (!bool) {
          notifyUI(8, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("TeamWorkHandlerImpl");
          paramToServiceMsg.append(TeamWorkConstants.i);
          paramToServiceMsg = paramToServiceMsg.toString();
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(" handleGetUserAuthDocsGrayTips ,result: ");
          paramFromServiceMsg.append(k);
          QLog.i(paramToServiceMsg, 2, paramFromServiceMsg.toString());
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("TeamWorkHandlerImpl");
        paramFromServiceMsg.append(TeamWorkConstants.i);
        paramFromServiceMsg = paramFromServiceMsg.toString();
        paramObject = new StringBuilder();
        paramObject.append(" handleGetUserAuthDocsGrayTips exception = ");
        paramObject.append(paramToServiceMsg.toString());
        QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      }
      return;
      label489:
      boolean bool = false;
    }
  }
  
  private boolean handleResponseTry(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null)
    {
      int i = responseReTryCount.get(paramReSendCmd.jdField_a_of_type_Int, 0);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" handleResponseTry retry cmd：");
      ((StringBuilder)localObject).append(paramReSendCmd.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", retryCount: ");
      ((StringBuilder)localObject).append(i);
      QLog.i("TeamWorkHandlerImpl", 1, ((StringBuilder)localObject).toString());
      if ((paramReSendCmd != null) && (i < 3))
      {
        responseReTryCount.put(paramReSendCmd.jdField_a_of_type_Int, i + 1);
        localObject = getPskeyFromServerAndRetry(paramReSendCmd, true);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 0))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" handleResponseTry retry to get pskey from SDK success,cmd: ");
          ((StringBuilder)localObject).append(paramReSendCmd.jdField_a_of_type_Int);
          QLog.i("TeamWorkHandlerImpl", 1, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    return false;
  }
  
  private void handleSetGroupAuthDocsGrayTips(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
        long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
        paramToServiceMsg = new cmd0xbab.RspBody();
        int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i == 0)
        {
          paramToServiceMsg = (cmd0xbab.GroupSetRsp)paramToServiceMsg.group_set_rsp.get();
          paramToServiceMsg = localDocsGrayTipsInfo.j;
          if ("1".equals(localDocsGrayTipsInfo.d))
          {
            ReportController.b(null, "CliOper", "", "", "0X8009550", "0X8009550", 1, 0, "", "", "", "");
            break label330;
          }
          if (!"2".equals(localDocsGrayTipsInfo.d)) {
            break label330;
          }
          ReportController.b(null, "CliOper", "", "", "0X8009552", "0X8009552", 1, 0, "", "", "", "");
          break label330;
        }
        paramToServiceMsg = localDocsGrayTipsInfo.k;
        bool = false;
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("TeamWorkHandlerImpl");
        paramFromServiceMsg.append(TeamWorkConstants.i);
        paramFromServiceMsg = paramFromServiceMsg.toString();
        paramObject = new StringBuilder();
        paramObject.append(" handleSetGroupAuthDocsGrayTips. result = ");
        paramObject.append(i);
        QLog.i(paramFromServiceMsg, 1, paramObject.toString());
        try
        {
          notifyUI(11, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
          return;
        }
        catch (Exception paramToServiceMsg) {}
        paramFromServiceMsg = new StringBuilder();
      }
      catch (Exception paramToServiceMsg) {}
      paramFromServiceMsg.append("TeamWorkHandlerImpl");
      paramFromServiceMsg.append(TeamWorkConstants.i);
      paramFromServiceMsg = paramFromServiceMsg.toString();
      paramObject = new StringBuilder();
      paramObject.append(" handleSetGroupAuthDocsGrayTips  exception = ");
      paramObject.append(paramToServiceMsg.toString());
      QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      return;
      label330:
      boolean bool = true;
    }
  }
  
  private void handleSetPadRightsInfo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute("key_type_list")).intValue();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append(" handleSetPadRightsInfo ,resultCode: ");
      paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
      QLog.i("TeamWorkHandlerImpl", 2, paramToServiceMsg.toString());
    }
    paramToServiceMsg = "";
    if (bool)
    {
      Object localObject = new TimDocSSOMsg.SetPadRightInfoRspBody();
      try
      {
        ((TimDocSSOMsg.SetPadRightInfoRspBody)localObject).mergeFrom((byte[])paramObject);
        int j = ((TimDocSSOMsg.SetPadRightInfoRspBody)localObject).uint32_retcode.get();
        if (j != 0)
        {
          paramObject = new StringBuilder();
          paramObject.append("error handleSetPadRightsInfo  url : ");
          paramObject.append("");
          paramObject.append(",retCode: ");
          paramObject.append(j);
          QLog.e("TeamWorkHandlerImpl", 1, paramObject.toString());
        }
        else
        {
          paramToServiceMsg = ((TimDocSSOMsg.SetPadRightInfoRspBody)localObject).bytes_pad_url.get().toStringUtf8();
          if (QLog.isColorLevel())
          {
            paramObject = new StringBuilder();
            paramObject.append(" handleSetPadRightsInfo url : ");
            paramObject.append(paramToServiceMsg);
            paramObject.append(",retCode: ");
            paramObject.append(j);
            QLog.i("TeamWorkHandlerImpl", 2, paramObject.toString());
          }
          bool = true;
        }
      }
      catch (Exception paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" handleSetPadRightsInfo exception: ");
        ((StringBuilder)localObject).append(paramObject.toString());
        QLog.i("TeamWorkHandlerImpl", 1, ((StringBuilder)localObject).toString());
        bool = false;
      }
    }
    if (!bool)
    {
      paramObject = new StringBuilder();
      paramObject.append(" handleGetPadRightsInfo faied code: ");
      paramObject.append(paramFromServiceMsg.getResultCode());
      QLog.i("TeamWorkHandlerImpl", 1, paramObject.toString());
    }
    notifyUI(6, bool, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
  }
  
  private void handleSetUserAuthDocsGrayTips(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramToServiceMsg.getAttribute("data");
        long l = ((Long)paramToServiceMsg.getAttribute("seq")).longValue();
        paramToServiceMsg = new cmd0xbab.RspBody();
        int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i == 0)
        {
          paramToServiceMsg = (cmd0xbab.UserSetRsp)paramToServiceMsg.user_set_rsp.get();
          paramToServiceMsg = localDocsGrayTipsInfo.j;
          if ("1".equals(localDocsGrayTipsInfo.d))
          {
            ReportController.b(null, "CliOper", "", "", "0X8009550", "0X8009550", 0, 0, "", "", "", "");
            break label336;
          }
          if (!"2".equals(localDocsGrayTipsInfo.d)) {
            break label336;
          }
          ReportController.b(null, "CliOper", "", "", "0X8009552", "0X8009552", 0, 0, "", "", "", "");
          break label336;
        }
        paramToServiceMsg = localDocsGrayTipsInfo.k;
        bool = false;
        try
        {
          notifyUI(9, bool, new Object[] { localDocsGrayTipsInfo, paramToServiceMsg, Long.valueOf(l) });
          if (!QLog.isColorLevel()) {
            break label335;
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("TeamWorkHandlerImpl");
          paramToServiceMsg.append(TeamWorkConstants.i);
          paramToServiceMsg = paramToServiceMsg.toString();
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(" handleSetUserAuthDocsGrayTips ,result: ");
          paramFromServiceMsg.append(i);
          QLog.i(paramToServiceMsg, 2, paramFromServiceMsg.toString());
          return;
        }
        catch (Exception paramToServiceMsg) {}
        paramFromServiceMsg = new StringBuilder();
      }
      catch (Exception paramToServiceMsg) {}
      paramFromServiceMsg.append("TeamWorkHandlerImpl");
      paramFromServiceMsg.append(TeamWorkConstants.i);
      paramFromServiceMsg = paramFromServiceMsg.toString();
      paramObject = new StringBuilder();
      paramObject.append(" handleSetUserAuthDocsGrayTips  exception = ");
      paramObject.append(paramToServiceMsg.toString());
      QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      label335:
      return;
      label336:
      boolean bool = true;
    }
  }
  
  private void reTrySendCmd(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" reTrySendCmd retry cmd：");
      localStringBuilder.append(paramReSendCmd.jdField_a_of_type_Int);
      QLog.i("TeamWorkHandlerImpl", 1, localStringBuilder.toString());
      if (paramReSendCmd.jdField_a_of_type_Int == 9) {
        getPadRightsInfo(paramReSendCmd.d, paramReSendCmd.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public String convertCryptoUinToTrueUin(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("xsrf=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("&uin=");
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vfwebqq=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(";TOK=");
      localStringBuilder.append(paramString3);
      paramString2 = localStringBuilder.toString();
      paramString3 = (ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class);
      try
      {
        paramString1 = paramString3.sendHttpsPost(paramString1, this.app.getCurrentAccountUin(), "https://docs.qq.com/cgi-bin/online_docs/tool_decryptuin", "docs.qq.com", paramString2, null, false);
        if (TextUtils.isEmpty(paramString1)) {
          return null;
        }
        paramString2 = new JSONObject(paramString1);
        int i = paramString2.optInt("cgicode", -1);
        paramString1 = paramString2.optString("msg");
        if (i == 0) {
          return paramString2.optString("uin");
        }
        paramString2 = new StringBuilder();
        paramString2.append("no result, cgicode: ");
        paramString2.append(i);
        paramString2.append(" msg: ");
        paramString2.append(paramString1);
        QLog.w("TeamWorkHandlerImpl", 1, paramString2.toString());
        return null;
      }
      catch (JSONException paramString1) {}
      QLog.e("TeamWorkHandlerImpl", 1, paramString1.getLocalizedMessage(), paramString1);
    }
    catch (JSONException paramString1) {}
    return null;
  }
  
  public JSONObject delRecentFilesByHttp(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      String str = UUID.randomUUID().toString().replaceAll("-", "");
      StringBuilder localStringBuilder1 = new StringBuilder("https://docs.qq.com/docsqqfile/recentfilesdel");
      localStringBuilder1.append('?');
      localStringBuilder1.append("t=");
      localStringBuilder1.append(System.currentTimeMillis());
      localStringBuilder1.append("&xsrf=");
      localStringBuilder1.append(str);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("TOK=");
      localStringBuilder2.append(str);
      str = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(paramJSONObject, this.app.getCurrentAccountUin(), localStringBuilder1.toString(), "docs.qq.com", localStringBuilder2.toString());
      paramJSONObject = localObject2;
      if (str == null) {
        break label242;
      }
      paramJSONObject = new JSONObject(str);
      try
      {
        if ((paramJSONObject.optInt("retcode", -1) != 0) && (QLog.isColorLevel()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("delRecentFilesByHttp failed result");
          ((StringBuilder)localObject1).append(str);
          QLog.e("TeamWorkHandlerImpl", 2, ((StringBuilder)localObject1).toString());
        }
      }
      catch (JSONException localJSONException1)
      {
        localObject1 = paramJSONObject;
      }
      paramJSONObject = (JSONObject)localObject1;
    }
    catch (JSONException localJSONException2) {}
    if (QLog.isColorLevel())
    {
      QLog.e("TeamWorkHandlerImpl", 2, localJSONException2, new Object[0]);
      paramJSONObject = (JSONObject)localObject1;
    }
    label242:
    localObject1 = paramJSONObject;
    if (paramJSONObject == null)
    {
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("retcode", -1);
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkHandlerImpl", 2, ((JSONObject)localObject1).toString());
    }
    return localObject1;
  }
  
  public boolean getEnableTencentDocsAssistant()
  {
    return this.enableTencentDocsAssistant;
  }
  
  public void getGroupAuthDocsGrayTips(DocsGrayTipsInfo paramDocsGrayTipsInfo, long paramLong)
  {
    try
    {
      if (!NetworkUtil.isNetSupport(MobileQQ.getContext()))
      {
        localObject1 = MobileQQ.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.l)) {
          paramDocsGrayTipsInfo = this.app.getApp().getString(2131694424);
        } else {
          paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.l;
        }
        QQToast.a((Context)localObject1, paramDocsGrayTipsInfo, 0).a();
        return;
      }
      localObject1 = new cmd0xbab.GroupGetReq();
      ((cmd0xbab.GroupGetReq)localObject1).group_code.set(Long.parseLong(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString));
      ((cmd0xbab.GroupGetReq)localObject1).doc_url.set(paramDocsGrayTipsInfo.b);
      localObject2 = new cmd0xbab.ReqBody();
      ((cmd0xbab.ReqBody)localObject2).group_get_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xbab_3", 2987, 3, ((cmd0xbab.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject1).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TeamWorkHandlerImpl");
      ((StringBuilder)localObject1).append(TeamWorkConstants.i);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get group auth | uin = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" docUrl = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.b);
      ((StringBuilder)localObject2).append(", msgSeq = ");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TeamWorkHandlerImpl");
      ((StringBuilder)localObject1).append(TeamWorkConstants.i);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get group auth exception = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.toString());
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  TimDocSSOMsg.LoginInfo getLoginInfo(String paramString, ReSendCmd paramReSendCmd)
  {
    Object localObject1 = (TicketManager)this.app.getManager(2);
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      String str = ((TicketManager)localObject1).getPskey(this.app.getCurrentAccountUin(), "docs.qq.com");
      localObject2 = ((TicketManager)localObject1).getSkey(this.app.getAccount());
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = new TimDocSSOMsg.LoginInfo();
        ((TimDocSSOMsg.LoginInfo)localObject1).bytes_pskey.set(ByteStringMicro.copyFromUtf8(str));
        this.reTryGetPskeyCount = 0;
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" pSkey is null, try to get pskey from server,reTryGetPskeyCount ");
        ((StringBuilder)localObject1).append(this.reTryGetPskeyCount);
        QLog.i("TeamWorkHandlerImpl", 1, ((StringBuilder)localObject1).toString());
        if ((this.reTryGetPskeyCount < 3) && (paramReSendCmd != null))
        {
          this.reTryGetPskeyCount += 1;
          str = getPskeyFromServerAndRetry(paramReSendCmd, false);
          if (!TextUtils.isEmpty(str))
          {
            this.reTryGetPskeyCount = 0;
            localObject1 = new TimDocSSOMsg.LoginInfo();
            ((TimDocSSOMsg.LoginInfo)localObject1).bytes_pskey.set(ByteStringMicro.copyFromUtf8(str));
          }
          else
          {
            localObject1 = null;
          }
        }
        else
        {
          this.reTryGetPskeyCount = 0;
          localObject1 = new TimDocSSOMsg.LoginInfo();
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        this.reTryGetSkeyCount = 0;
        if (localObject1 != null) {
          ((TimDocSSOMsg.LoginInfo)localObject1).bytes_skey.set(ByteStringMicro.copyFromUtf8((String)localObject2));
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" skey is null,try to get skey from server, reTryGetSkeyCount: ");
        ((StringBuilder)localObject2).append(this.reTryGetSkeyCount);
        QLog.i("TeamWorkHandlerImpl", 1, ((StringBuilder)localObject2).toString());
        if ((this.reTryGetSkeyCount < 3) && (paramReSendCmd != null))
        {
          this.reTryGetSkeyCount += 1;
          paramString = getSkeyFromServerAndRetry(paramReSendCmd);
          localObject2 = localObject3;
          if (TextUtils.isEmpty(paramString)) {
            break label376;
          }
          this.reTryGetSkeyCount = 0;
          if (localObject1 != null) {
            ((TimDocSSOMsg.LoginInfo)localObject1).bytes_skey.set(ByteStringMicro.copyFromUtf8(paramString));
          }
        }
        else
        {
          this.reTryGetPskeyCount = 0;
          if (localObject1 == null) {
            return new TimDocSSOMsg.LoginInfo();
          }
        }
      }
      localObject2 = localObject1;
    }
    label376:
    return localObject2;
  }
  
  public void getPadRightsInfo(int paramInt, String paramString)
  {
    if (!NetworkUtil.isNetSupport(MobileQQ.getContext()))
    {
      notifyUI(5, false, new Object[] { "", Integer.valueOf(paramInt) });
      return;
    }
    Object localObject1 = new TimDocSSOMsg.GetPadRightInfoReqBody();
    ((TimDocSSOMsg.GetPadRightInfoReqBody)localObject1).uint32_appid.set(2);
    ((TimDocSSOMsg.GetPadRightInfoReqBody)localObject1).bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
    ReSendCmd localReSendCmd = new ReSendCmd();
    localReSendCmd.jdField_a_of_type_Int = 9;
    localReSendCmd.d = paramInt;
    localReSendCmd.jdField_a_of_type_JavaLangString = paramString;
    Object localObject2 = getLoginInfo("send GetPadRightInfoReqBody", localReSendCmd);
    if (localObject2 == null)
    {
      QLog.e("TeamWorkHandlerImpl", 1, "---- GetPadRightInfoReqBody -- loginInfo is null ---");
      return;
    }
    ((TimDocSSOMsg.GetPadRightInfoReqBody)localObject1).msg_login_info.set((MessageMicro)localObject2);
    localObject2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.GetPadRightInfo");
    ((ToServiceMsg)localObject2).putWupBuffer(((TimDocSSOMsg.GetPadRightInfoReqBody)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    ((ToServiceMsg)localObject2).addAttribute("key_type_list", Integer.valueOf(paramInt));
    ((ToServiceMsg)localObject2).extraData.putParcelable("key_resend_cmd", localReSendCmd);
    super.sendPbReq((ToServiceMsg)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("send GetPadRightInfoReqBody,padUrl: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("TeamWorkHandlerImpl", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public boolean getPreloadToolProcess()
  {
    return this.preloadToolProcess;
  }
  
  public JSONObject getRecentFilesByHttp(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      String str = UUID.randomUUID().toString().replaceAll("-", "");
      StringBuilder localStringBuilder = new StringBuilder("https://docs.qq.com/docsqqfile/recentfiles");
      localStringBuilder.append('?');
      localStringBuilder.append("t=");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("&xsrf=");
      localStringBuilder.append(str);
      if (!TextUtils.isEmpty(paramString))
      {
        localStringBuilder.append("&to_uin=");
        localStringBuilder.append(paramString);
      }
      paramString = new StringBuilder();
      paramString.append("TOK=");
      paramString.append(str);
      str = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(this.app.getCurrentAccountUin(), localStringBuilder.toString(), "docs.qq.com", paramString.toString());
      paramString = localObject2;
      if (TextUtils.isEmpty(str)) {
        break label257;
      }
      paramString = new JSONObject(str);
      try
      {
        if ((paramString.optInt("retcode", -1) != 0) && (QLog.isColorLevel()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getRecentFilesByHttp failed result");
          ((StringBuilder)localObject1).append(str);
          QLog.e("TeamWorkHandlerImpl", 2, ((StringBuilder)localObject1).toString());
        }
      }
      catch (JSONException localJSONException1)
      {
        localObject1 = paramString;
      }
      paramString = (String)localObject1;
    }
    catch (JSONException localJSONException2) {}
    if (QLog.isColorLevel())
    {
      QLog.e("TeamWorkHandlerImpl", 2, localJSONException2, new Object[0]);
      paramString = (String)localObject1;
    }
    label257:
    localObject1 = paramString;
    if (paramString == null)
    {
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("retcode", -1);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkHandlerImpl", 2, ((JSONObject)localObject1).toString());
    }
    return localObject1;
  }
  
  public JSONObject getTemplateListByHttp()
  {
    Object localObject1 = null;
    try
    {
      String str = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(this.app.getCurrentAccountUin(), "https://docs.qq.com/cgi-bin/template/template_list", "docs.qq.com");
      if (str == null) {
        break label137;
      }
      localObject2 = new JSONObject(str);
      localObject1 = localObject2;
      try
      {
        if (((JSONObject)localObject2).optInt("retcode", -1) == 0) {
          break label137;
        }
        ((JSONObject)localObject2).put("retcode", -1);
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break label137;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("failed result");
        ((StringBuilder)localObject1).append(str);
        QLog.e("TeamWorkHandlerImpl", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException2) {}
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException3)
    {
      localObject2 = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("TeamWorkHandlerImpl", 2, localJSONException3, new Object[0]);
      localObject1 = localObject2;
    }
    label137:
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("retcode", -1);
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkHandlerImpl", 2, ((JSONObject)localObject2).toString());
    }
    return localObject2;
  }
  
  public void getUserAuthDocsGrayTips(DocsGrayTipsInfo paramDocsGrayTipsInfo, long paramLong)
  {
    try
    {
      if (!NetworkUtil.isNetSupport(MobileQQ.getContext()))
      {
        localObject1 = MobileQQ.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.l)) {
          paramDocsGrayTipsInfo = this.app.getApp().getString(2131694424);
        } else {
          paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.l;
        }
        QQToast.a((Context)localObject1, paramDocsGrayTipsInfo, 0).a();
        return;
      }
      localObject1 = new cmd0xbab.UserGetReq();
      ((cmd0xbab.UserGetReq)localObject1).uin.set(Long.parseLong(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString));
      ((cmd0xbab.UserGetReq)localObject1).doc_url.set(paramDocsGrayTipsInfo.b);
      localObject2 = new cmd0xbab.ReqBody();
      ((cmd0xbab.ReqBody)localObject2).user_get_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xbab_1", 2987, 1, ((cmd0xbab.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject1).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TeamWorkHandlerImpl");
      ((StringBuilder)localObject1).append(TeamWorkConstants.i);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get user auth | uin = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" docUrl = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.b);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TeamWorkHandlerImpl");
      ((StringBuilder)localObject1).append(TeamWorkConstants.i);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get user auth exception = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.toString());
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void handleGetPadRightsInfo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute("key_type_list")).intValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" handleGetPadRightsInfo ,resultCode: ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      QLog.i("TeamWorkHandlerImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = "";
    if (!bool)
    {
      paramObject = localObject;
    }
    else
    {
      TimDocSSOMsg.GetPadRightInfoRspBody localGetPadRightInfoRspBody = new TimDocSSOMsg.GetPadRightInfoRspBody();
      try
      {
        localGetPadRightInfoRspBody.mergeFrom((byte[])paramObject);
        int j = localGetPadRightInfoRspBody.uint32_retcode.get();
        if (j != 0)
        {
          paramObject = new StringBuilder();
          paramObject.append("error handleGetPadRightsInfo url : ");
          paramObject.append("");
          paramObject.append(",retCode: ");
          paramObject.append(j);
          QLog.e("TeamWorkHandlerImpl", 1, paramObject.toString());
          paramObject = localObject;
          if (j == 200011)
          {
            paramObject = localObject;
            if (!handleResponseTry((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd"))) {}
          }
        }
        else
        {
          paramObject = localGetPadRightInfoRspBody.bytes_pad_url.get().toStringUtf8();
          if (!localGetPadRightInfoRspBody.uint32_pad_right.has())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("error handleGetPadRightsInfo url : ");
            paramToServiceMsg.append(paramObject);
            paramToServiceMsg.append(",has not padrights filed ");
            QLog.e("TeamWorkHandlerImpl", 1, paramToServiceMsg.toString());
          }
          else
          {
            i = localGetPadRightInfoRspBody.uint32_pad_right.get();
            paramToServiceMsg = localGetPadRightInfoRspBody.rpt_msg_uin_right_info.get();
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("pad is not exxisted ,but in other list find : ");
              paramFromServiceMsg.append(false);
              QLog.w("TeamWorkHandlerImpl", 2, paramFromServiceMsg.toString());
            }
            notifyUI(7, true, new Object[] { paramObject, Integer.valueOf(i), paramToServiceMsg });
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append(" handleGetPadRightsInfo exception: ");
        paramObject.append(paramToServiceMsg.toString());
        QLog.i("TeamWorkHandlerImpl", 1, paramObject.toString());
        paramObject = localObject;
        bool = false;
      }
    }
    if (!bool)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append(" handleGetPadRightsInfo faied code: ");
      paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
      QLog.i("TeamWorkHandlerImpl", 1, paramToServiceMsg.toString());
    }
    notifyUI(5, bool, new Object[] { paramObject, Integer.valueOf(i) });
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TeamWorkObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("TimDocSvc.GetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      handleGetPadRightsInfo(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("TimDocSvc.SetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      handleSetPadRightsInfo(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xbab_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      handleGetUserAuthDocsGrayTips(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xbab_2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      handleSetUserAuthDocsGrayTips(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xbab_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      handleGetGroupAuthDocsGrayTips(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xbab_4".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      handleSetGroupAuthDocsGrayTips(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void setEnableTencentDocsAssistant(boolean paramBoolean)
  {
    this.enableTencentDocsAssistant = paramBoolean;
  }
  
  public void setGroupAuthDocsGrayTips(DocsGrayTipsInfo paramDocsGrayTipsInfo, int paramInt, long paramLong)
  {
    try
    {
      boolean bool2 = NetworkUtil.isNetSupport(MobileQQ.getContext());
      boolean bool1 = false;
      if (!bool2)
      {
        localObject1 = MobileQQ.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.l)) {
          paramDocsGrayTipsInfo = this.app.getApp().getString(2131694424);
        } else {
          paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.l;
        }
        QQToast.a((Context)localObject1, paramDocsGrayTipsInfo, 0).a();
        return;
      }
      localObject1 = new cmd0xbab.GroupSetReq();
      ((cmd0xbab.GroupSetReq)localObject1).group_code.set(Long.parseLong(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString));
      ((cmd0xbab.GroupSetReq)localObject1).doc_url.set(paramDocsGrayTipsInfo.b);
      ((cmd0xbab.GroupSetReq)localObject1).policy.set(Integer.valueOf(paramDocsGrayTipsInfo.h).intValue());
      localObject2 = ((cmd0xbab.GroupSetReq)localObject1).only;
      if (Integer.valueOf(paramDocsGrayTipsInfo.i).intValue() == 1) {
        bool1 = true;
      }
      ((PBBoolField)localObject2).set(bool1);
      ((cmd0xbab.GroupSetReq)localObject1).privilege_flag.set(Integer.valueOf(paramDocsGrayTipsInfo.g).intValue());
      ((cmd0xbab.GroupSetReq)localObject1).exp_set_time.set(paramInt);
      localObject2 = new cmd0xbab.ReqBody();
      ((cmd0xbab.ReqBody)localObject2).group_set_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xbab_4", 2987, 4, ((cmd0xbab.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject1).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TeamWorkHandlerImpl");
      ((StringBuilder)localObject1).append(TeamWorkConstants.i);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set group auth | uin = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" docUrl = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.b);
      ((StringBuilder)localObject2).append(" setploicy = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.h);
      ((StringBuilder)localObject2).append(" setonly= ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.i);
      ((StringBuilder)localObject2).append(" setprivilege=");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.g);
      ((StringBuilder)localObject2).append(" bNeedtime = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.r);
      ((StringBuilder)localObject2).append(" settime=");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TeamWorkHandlerImpl");
      ((StringBuilder)localObject1).append(TeamWorkConstants.i);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set group auth exception = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.toString());
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void setPadRightsInfo(int paramInt1, String paramString, int paramInt2, List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    if (!NetworkUtil.isNetSupport(MobileQQ.getContext()))
    {
      notifyUI(6, false, new Object[] { "", Integer.valueOf(paramInt2) });
      return;
    }
    TimDocSSOMsg.SetPadRightInfoReqBody localSetPadRightInfoReqBody = new TimDocSSOMsg.SetPadRightInfoReqBody();
    localSetPadRightInfoReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
    TimDocSSOMsg.LoginInfo localLoginInfo = getLoginInfo("send setPadRightsInfo", null);
    if (localLoginInfo != null) {
      localSetPadRightInfoReqBody.msg_login_info.set(localLoginInfo);
    }
    localSetPadRightInfoReqBody.uint32_appid.set(2);
    localSetPadRightInfoReqBody.uint32_pad_right.set(paramInt1);
    if ((paramList != null) && (paramList.size() > 0)) {
      localSetPadRightInfoReqBody.rpt_msg_uin_right_info.set(paramList);
    }
    paramList = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "TimDocSvc.SetPadRightInfo");
    paramList.addAttribute("key_type_list", Integer.valueOf(paramInt2));
    paramList.putWupBuffer(localSetPadRightInfoReqBody.toByteArray());
    paramList.setTimeout(30000L);
    super.sendPbReq(paramList);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("send setPadRightsInfo,padUrl: ");
      paramList.append(paramString);
      QLog.i("TeamWorkHandlerImpl", 2, paramList.toString());
    }
  }
  
  public void setPreloadToolProcess(boolean paramBoolean)
  {
    this.preloadToolProcess = paramBoolean;
  }
  
  public void setUserAuthDocsGrayTips(DocsGrayTipsInfo paramDocsGrayTipsInfo, int paramInt, long paramLong)
  {
    try
    {
      boolean bool2 = NetworkUtil.isNetSupport(MobileQQ.getContext());
      boolean bool1 = false;
      if (!bool2)
      {
        localObject1 = MobileQQ.getContext();
        if (TextUtils.isEmpty(paramDocsGrayTipsInfo.l)) {
          paramDocsGrayTipsInfo = this.app.getApp().getString(2131694424);
        } else {
          paramDocsGrayTipsInfo = paramDocsGrayTipsInfo.l;
        }
        QQToast.a((Context)localObject1, paramDocsGrayTipsInfo, 0).a();
        return;
      }
      localObject1 = new cmd0xbab.UserSetReq();
      ((cmd0xbab.UserSetReq)localObject1).uin.set(Long.parseLong(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString));
      ((cmd0xbab.UserSetReq)localObject1).doc_url.set(paramDocsGrayTipsInfo.b);
      ((cmd0xbab.UserSetReq)localObject1).policy.set(Integer.valueOf(paramDocsGrayTipsInfo.h).intValue());
      localObject2 = ((cmd0xbab.UserSetReq)localObject1).only;
      if (Integer.valueOf(paramDocsGrayTipsInfo.i).intValue() == 1) {
        bool1 = true;
      }
      ((PBBoolField)localObject2).set(bool1);
      ((cmd0xbab.UserSetReq)localObject1).privilege_flag.set(Integer.valueOf(paramDocsGrayTipsInfo.g).intValue());
      ((cmd0xbab.UserSetReq)localObject1).exp_set_time.set(paramInt);
      localObject2 = new cmd0xbab.ReqBody();
      ((cmd0xbab.ReqBody)localObject2).user_set_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xbab_2", 2987, 2, ((cmd0xbab.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("data", paramDocsGrayTipsInfo);
      ((ToServiceMsg)localObject1).addAttribute("seq", Long.valueOf(paramLong));
      sendPbReq((ToServiceMsg)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TeamWorkHandlerImpl");
      ((StringBuilder)localObject1).append(TeamWorkConstants.i);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set user auth | uin = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" docUrl = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.b);
      ((StringBuilder)localObject2).append(" setploicy = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.h);
      ((StringBuilder)localObject2).append(" setonly= ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.i);
      ((StringBuilder)localObject2).append(" setprivilege=");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.g);
      ((StringBuilder)localObject2).append(" bNeedtime = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.r);
      ((StringBuilder)localObject2).append(" settime=");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception paramDocsGrayTipsInfo)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TeamWorkHandlerImpl");
      ((StringBuilder)localObject1).append(TeamWorkConstants.i);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set user auth exception = ");
      ((StringBuilder)localObject2).append(paramDocsGrayTipsInfo.toString());
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkHandlerImpl
 * JD-Core Version:    0.7.0.1
 */