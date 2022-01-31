package com.tencent.mobileqq.teamwork;

import ahyk;
import ahyl;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.pb.teamwork.TimDocSSOMsg.GetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.GetPadRightInfoRspBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.LoginInfo;
import com.tencent.pb.teamwork.TimDocSSOMsg.SetPadRightInfoReqBody;
import com.tencent.pb.teamwork.TimDocSSOMsg.SetPadRightInfoRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

public class TeamWorkHandler
  extends BusinessHandler
{
  private static String jdField_a_of_type_JavaLangString = "key_type_list";
  private volatile int jdField_a_of_type_Int;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  public boolean a;
  private volatile int b;
  public boolean b;
  
  public TeamWorkHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.c(), "tencent_docs_config_enable_assistant", false);
    this.jdField_b_of_type_Boolean = SharedPreUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.c(), "tencent_docs_config_preload_tool_process", false);
  }
  
  private String a(ReSendCmd paramReSendCmd)
  {
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    if (localTicketManager != null)
    {
      paramReSendCmd = localTicketManager.GetSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 16L, new ahyl(this, localTicketManager, paramReSendCmd));
      if ((paramReSendCmd != null) && (paramReSendCmd._sig != null))
      {
        paramReSendCmd = new String(paramReSendCmd._sig);
        QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey with promise success! ");
        return paramReSendCmd;
      }
      QLog.i("TeamWorkHandler", 1, "getSkeyFromServerAndRetry get skey from server now! ");
    }
    for (;;)
    {
      return null;
      QLog.e("TeamWorkHandler", 1, "getSkeyFromServerAndRetry,ticketmanager is null");
    }
  }
  
  private String a(ReSendCmd paramReSendCmd, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    if (localObject != null)
    {
      String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      ahyk localahyk = new ahyk(this, (TicketManager)localObject, paramReSendCmd);
      localObject = ((TicketManager)localObject).GetPskey(str, 16L, new String[] { "docs.qq.com" }, localahyk);
      if ((localObject != null) && (((Ticket)localObject)._pskey_map != null) && (((Ticket)localObject)._pskey_map.get("docs.qq.com") != null))
      {
        QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey with promise success! isImediately Resend: " + paramBoolean);
        localObject = new String((byte[])((Ticket)localObject)._pskey_map.get("docs.qq.com"));
        if (paramBoolean)
        {
          a(paramReSendCmd);
          return localObject;
        }
      }
      else
      {
        QLog.i("TeamWorkHandler", 1, "getPskeyFromServerAndRetry get pskey from server now!");
      }
    }
    else
    {
      for (;;)
      {
        return null;
        QLog.e("TeamWorkHandler", 1, "getPskeyFromServerAndRetry,ticketmanager is null");
      }
    }
    return localObject;
  }
  
  private void a(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null)
    {
      QLog.i("TeamWorkHandler", 1, " reTrySendCmd retry cmd：" + paramReSendCmd.jdField_a_of_type_Int);
      if (paramReSendCmd.jdField_a_of_type_Int == 9) {
        a(paramReSendCmd.d, paramReSendCmd.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private boolean a(ReSendCmd paramReSendCmd)
  {
    if (paramReSendCmd != null)
    {
      int i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramReSendCmd.jdField_a_of_type_Int, 0);
      QLog.i("TeamWorkHandler", 1, " handleResponseTry retry cmd：" + paramReSendCmd.jdField_a_of_type_Int + ", retryCount: " + i);
      if ((paramReSendCmd != null) && (i < 3))
      {
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramReSendCmd.jdField_a_of_type_Int, i + 1);
        String str = a(paramReSendCmd, true);
        if ((!TextUtils.isEmpty(str)) && (str.length() > 0)) {
          QLog.i("TeamWorkHandler", 1, " handleResponseTry retry to get pskey from SDK success,cmd: " + paramReSendCmd.jdField_a_of_type_Int);
        }
        return true;
      }
    }
    return false;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute(jdField_a_of_type_JavaLangString)).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleSetPadRightsInfo ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    if (!bool) {
      paramToServiceMsg = "";
    }
    for (;;)
    {
      if (!bool) {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo faied code: " + paramFromServiceMsg.getResultCode());
      }
      a(6, bool, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
      return;
      paramToServiceMsg = new TimDocSSOMsg.SetPadRightInfoRspBody();
      int j;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        j = paramToServiceMsg.uint32_retcode.get();
        if (j == 0) {
          break label241;
        }
        QLog.e("TeamWorkHandler", 1, "error handleSetPadRightsInfo  url : " + "" + ",retCode: " + j);
        paramToServiceMsg = "";
        bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.i("TeamWorkHandler", 1, " handleSetPadRightsInfo exception: " + paramToServiceMsg.toString());
        paramToServiceMsg = "";
        bool = false;
      }
      continue;
      label241:
      paramToServiceMsg = paramToServiceMsg.bytes_pad_url.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkHandler", 2, " handleSetPadRightsInfo url : " + paramToServiceMsg + ",retCode: " + j);
      }
      bool = true;
    }
  }
  
  TimDocSSOMsg.LoginInfo a(String paramString, ReSendCmd paramReSendCmd)
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    if (localObject != null)
    {
      String str2 = ((TicketManager)localObject).getPskey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "docs.qq.com");
      String str1 = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
      if (!TextUtils.isEmpty(str2))
      {
        localObject = new TimDocSSOMsg.LoginInfo();
        ((TimDocSSOMsg.LoginInfo)localObject).bytes_pskey.set(ByteStringMicro.copyFromUtf8(str2));
        this.jdField_a_of_type_Int = 0;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(str1))
        {
          this.jdField_b_of_type_Int = 0;
          if (localObject != null) {
            ((TimDocSSOMsg.LoginInfo)localObject).bytes_skey.set(ByteStringMicro.copyFromUtf8(str1));
          }
        }
        label317:
        label319:
        do
        {
          do
          {
            return localObject;
            QLog.i("TeamWorkHandler", 1, paramString + " pSkey is null, try to get pskey from server,reTryGetPskeyCount " + this.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_Int < 3) && (paramReSendCmd != null))
            {
              this.jdField_a_of_type_Int += 1;
              str2 = a(paramReSendCmd, false);
              if (TextUtils.isEmpty(str2)) {
                break label336;
              }
              this.jdField_a_of_type_Int = 0;
              localObject = new TimDocSSOMsg.LoginInfo();
              ((TimDocSSOMsg.LoginInfo)localObject).bytes_pskey.set(ByteStringMicro.copyFromUtf8(str2));
              break;
            }
            this.jdField_a_of_type_Int = 0;
            localObject = new TimDocSSOMsg.LoginInfo();
            break;
            QLog.i("TeamWorkHandler", 1, paramString + " skey is null,try to get skey from server, reTryGetSkeyCount: " + this.jdField_b_of_type_Int);
            if ((this.jdField_b_of_type_Int >= 3) || (paramReSendCmd == null)) {
              break label319;
            }
            this.jdField_b_of_type_Int += 1;
            paramString = a(paramReSendCmd);
            if (TextUtils.isEmpty(paramString)) {
              break label317;
            }
            this.jdField_b_of_type_Int = 0;
          } while (localObject == null);
          ((TimDocSSOMsg.LoginInfo)localObject).bytes_skey.set(ByteStringMicro.copyFromUtf8(paramString));
          return localObject;
          return null;
          this.jdField_a_of_type_Int = 0;
        } while (localObject != null);
        return new TimDocSSOMsg.LoginInfo();
        label336:
        localObject = null;
      }
    }
    return null;
  }
  
  protected Class a()
  {
    return TeamWorkObserver.class;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
      a(5, false, new Object[] { "", Integer.valueOf(paramInt) });
    }
    do
    {
      return;
      TimDocSSOMsg.GetPadRightInfoReqBody localGetPadRightInfoReqBody = new TimDocSSOMsg.GetPadRightInfoReqBody();
      localGetPadRightInfoReqBody.uint32_appid.set(2);
      localGetPadRightInfoReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
      ReSendCmd localReSendCmd = new ReSendCmd();
      localReSendCmd.jdField_a_of_type_Int = 9;
      localReSendCmd.d = paramInt;
      localReSendCmd.jdField_a_of_type_JavaLangString = paramString;
      Object localObject = a("send GetPadRightInfoReqBody", localReSendCmd);
      if (localObject == null)
      {
        QLog.e("TeamWorkHandler", 1, "---- GetPadRightInfoReqBody -- loginInfo is null ---");
        return;
      }
      localGetPadRightInfoReqBody.msg_login_info.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "TimDocSvc.GetPadRightInfo");
      ((ToServiceMsg)localObject).putWupBuffer(localGetPadRightInfoReqBody.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).addAttribute(jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
      ((ToServiceMsg)localObject).extraData.putParcelable("key_resend_cmd", localReSendCmd);
      super.b((ToServiceMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send GetPadRightInfoReqBody,padUrl: " + paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, List paramList)
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
      a(6, false, new Object[] { "", Integer.valueOf(paramInt2) });
    }
    do
    {
      return;
      TimDocSSOMsg.SetPadRightInfoReqBody localSetPadRightInfoReqBody = new TimDocSSOMsg.SetPadRightInfoReqBody();
      localSetPadRightInfoReqBody.bytes_pad_url.set(ByteStringMicro.copyFromUtf8(paramString));
      TimDocSSOMsg.LoginInfo localLoginInfo = a("send setPadRightsInfo", null);
      if (localLoginInfo != null) {
        localSetPadRightInfoReqBody.msg_login_info.set(localLoginInfo);
      }
      localSetPadRightInfoReqBody.uint32_appid.set(2);
      localSetPadRightInfoReqBody.uint32_pad_right.set(paramInt1);
      if ((paramList != null) && (paramList.size() > 0)) {
        localSetPadRightInfoReqBody.rpt_msg_uin_right_info.set(paramList);
      }
      paramList = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "TimDocSvc.SetPadRightInfo");
      paramList.addAttribute(jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt2));
      paramList.putWupBuffer(localSetPadRightInfoReqBody.toByteArray());
      paramList.setTimeout(30000L);
      super.b(paramList);
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkHandler", 2, "send setPadRightsInfo,padUrl: " + paramString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("TimDocSvc.GetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"TimDocSvc.SetPadRightInfo".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    int i = ((Integer)paramToServiceMsg.getAttribute(jdField_a_of_type_JavaLangString)).intValue();
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkHandler", 2, " handleGetPadRightsInfo ,resultCode: " + paramFromServiceMsg.getResultCode());
    }
    if (!bool) {
      paramToServiceMsg = "";
    }
    label120:
    TimDocSSOMsg.GetPadRightInfoRspBody localGetPadRightInfoRspBody;
    for (;;)
    {
      if (!bool) {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo faied code: " + paramFromServiceMsg.getResultCode());
      }
      a(5, bool, new Object[] { paramToServiceMsg, Integer.valueOf(i) });
      return;
      localGetPadRightInfoRspBody = new TimDocSSOMsg.GetPadRightInfoRspBody();
      try
      {
        localGetPadRightInfoRspBody.mergeFrom((byte[])paramObject);
        int j = localGetPadRightInfoRspBody.uint32_retcode.get();
        if (j == 0) {
          break label272;
        }
        QLog.e("TeamWorkHandler", 1, "error handleGetPadRightsInfo url : " + "" + ",retCode: " + j);
        if ((j == 200011) && (a((ReSendCmd)paramToServiceMsg.extraData.getParcelable("key_resend_cmd")))) {
          break label120;
        }
        paramToServiceMsg = "";
        bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.i("TeamWorkHandler", 1, " handleGetPadRightsInfo exception: " + paramToServiceMsg.toString());
        paramToServiceMsg = "";
        bool = false;
      }
      continue;
      label272:
      paramToServiceMsg = localGetPadRightInfoRspBody.bytes_pad_url.get().toStringUtf8();
      if (localGetPadRightInfoRspBody.uint32_pad_right.has()) {
        break;
      }
      QLog.e("TeamWorkHandler", 1, "error handleGetPadRightsInfo url : " + paramToServiceMsg + ",has not padrights filed ");
      bool = false;
    }
    i = localGetPadRightInfoRspBody.uint32_pad_right.get();
    paramFromServiceMsg = localGetPadRightInfoRspBody.rpt_msg_uin_right_info.get();
    if (0 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TeamWorkHandler", 2, "pad is not exxisted ,but in other list find : " + false);
      }
      a(7, true, new Object[] { paramToServiceMsg, Integer.valueOf(i), paramFromServiceMsg });
      return;
    }
    if ((i == 1) || (i == 2)) {
      throw new NullPointerException();
    }
    new ArrayList();
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkHandler
 * JD-Core Version:    0.7.0.1
 */