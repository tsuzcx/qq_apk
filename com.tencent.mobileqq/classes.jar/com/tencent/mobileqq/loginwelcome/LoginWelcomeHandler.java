package com.tencent.mobileqq.loginwelcome;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.BindContactInfo;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_808;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_808_web;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_common;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_common_web;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.ReqBody;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class LoginWelcomeHandler
  extends BusinessHandler
{
  public LoginWelcomeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool4 = paramFromServiceMsg.isSuccess();
    boolean bool3 = false;
    boolean bool2 = false;
    paramFromServiceMsg = null;
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = bool3;
    paramToServiceMsg = localObject2;
    if (bool4) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramObject = new oidb_0x59f.RspBody();
          paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramObject.uint32_is_first_login.has()) && (paramObject.uint32_is_first_login.get() == 1))
          {
            paramToServiceMsg = new Object[4];
            try
            {
              if (!paramObject.str_reg_mobile.has()) {
                break label372;
              }
              paramFromServiceMsg = paramObject.str_reg_mobile.get();
              paramToServiceMsg[0] = paramFromServiceMsg;
              if (!paramObject.msg_contact_bind_info.has()) {
                break label377;
              }
              paramFromServiceMsg = paramObject.msg_contact_bind_info.get();
              paramToServiceMsg[1] = paramFromServiceMsg;
              if (!paramObject.uint32_gray_flag.has()) {
                break label382;
              }
              i = paramObject.uint32_gray_flag.get();
              paramToServiceMsg[2] = Integer.valueOf(i);
              paramFromServiceMsg = localObject1;
              if (paramObject.str_guide_url.has()) {
                paramFromServiceMsg = paramObject.str_guide_url.get();
              }
              paramToServiceMsg[3] = paramFromServiceMsg;
              bool1 = true;
            }
            catch (Throwable paramObject)
            {
              paramFromServiceMsg = paramToServiceMsg;
              continue;
            }
          }
          else
          {
            paramToServiceMsg = null;
            bool1 = bool2;
          }
        }
        else
        {
          paramObject = new StringBuilder();
          paramObject.append(" sso failed: ");
          paramObject.append(paramToServiceMsg.uint32_result.get());
          QLog.e("LoginWelcomeManager", 1, paramObject.toString());
          bool1 = bool3;
          paramToServiceMsg = localObject2;
        }
      }
      catch (Throwable paramObject)
      {
        bool1 = bool3;
        paramToServiceMsg = paramFromServiceMsg;
        if (QLog.isColorLevel())
        {
          QLog.d("LoginWelcomeManager", 2, "handleGetIsFirstLogin failed", paramObject);
          paramToServiceMsg = paramFromServiceMsg;
          bool1 = bool3;
        }
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetIsFirstLogin, result ");
        paramFromServiceMsg.append(bool1);
        QLog.d("LoginWelcomeManager", 2, paramFromServiceMsg.toString());
      }
      notifyUI(558, bool1, paramToServiceMsg, true);
      return;
      label372:
      paramFromServiceMsg = null;
      continue;
      label377:
      paramFromServiceMsg = null;
      continue;
      label382:
      int i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = makeOIDBPkg("OidbSvc.0x59f", 1439, 1, new oidb_0x59f.ReqBody().toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("isFirst", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestGuide [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("LoginWelcomeHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = paramFromServiceMsg.isSuccess();
    LoginWelcomeManager.CommonGuideInfo localCommonGuideInfo = null;
    paramFromServiceMsg = null;
    Object localObject = null;
    boolean bool2 = false;
    paramToServiceMsg = paramFromServiceMsg;
    boolean bool1 = bool2;
    if (bool3) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          oidb_0x59f.RspBody localRspBody = new oidb_0x59f.RspBody();
          localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramObject = new LoginWelcomeManager.ContactsGuideInfo();
          if ((!localRspBody.uint32_addrlist_entrance_flag.has()) || (localRspBody.uint32_addrlist_entrance_flag.get() == 0)) {
            break label861;
          }
          bool1 = true;
          paramObject.jdField_b_of_type_Boolean = bool1;
          if (!localRspBody.msg_guidelines808.has()) {
            break label867;
          }
          paramToServiceMsg = (oidb_0x59f.Guidelines_808)localRspBody.msg_guidelines808.get();
          if (paramToServiceMsg != null)
          {
            if ((!paramToServiceMsg.uint32_welcomepage_flag.has()) || (paramToServiceMsg.uint32_welcomepage_flag.get() == 0)) {
              break label872;
            }
            bool1 = true;
            paramObject.jdField_a_of_type_Boolean = bool1;
            if (!paramToServiceMsg.msg_guidelines_web.has()) {
              break label878;
            }
            paramToServiceMsg = (oidb_0x59f.Guidelines_808_web)paramToServiceMsg.msg_guidelines_web.get();
            if (paramToServiceMsg != null)
            {
              if (!paramToServiceMsg.str_web_url.has()) {
                break label883;
              }
              paramFromServiceMsg = paramToServiceMsg.str_web_url.get();
              if (!TextUtils.isEmpty(paramFromServiceMsg)) {
                paramObject.jdField_a_of_type_JavaLangString = paramFromServiceMsg;
              }
              if (!paramToServiceMsg.uint32_friends_recomm_flag.has()) {
                break label890;
              }
              i = paramToServiceMsg.uint32_friends_recomm_flag.get();
              paramObject.jdField_a_of_type_Int = i;
              if (!paramToServiceMsg.uint32_groups_recomm_flag.has()) {
                break label896;
              }
              i = paramToServiceMsg.uint32_groups_recomm_flag.get();
              paramObject.jdField_b_of_type_Int = i;
            }
          }
          paramToServiceMsg = new Object[3];
          paramToServiceMsg[0] = paramObject;
          try
          {
            localCommonGuideInfo = new LoginWelcomeManager.CommonGuideInfo();
            if (!localRspBody.msg_guidelines813.has()) {
              break label902;
            }
            paramFromServiceMsg = (oidb_0x59f.Guidelines_common)localRspBody.msg_guidelines813.get();
            if (paramFromServiceMsg != null)
            {
              if (!paramFromServiceMsg.msg_guidelines_web.has()) {
                break label907;
              }
              paramFromServiceMsg = (oidb_0x59f.Guidelines_common_web)paramFromServiceMsg.msg_guidelines_web.get();
              if (paramFromServiceMsg != null)
              {
                paramObject = localObject;
                if (paramFromServiceMsg.str_web_url.has()) {
                  paramObject = paramFromServiceMsg.str_web_url.get();
                }
                localCommonGuideInfo.jdField_a_of_type_JavaLangString = paramObject;
                if ((paramFromServiceMsg.uint32_groups_recomm_flag.has()) && (paramFromServiceMsg.uint32_groups_recomm_flag.get() == 1)) {
                  localCommonGuideInfo.jdField_a_of_type_Int = 1;
                } else if ((paramFromServiceMsg.uint32_set_gender.has()) && (paramFromServiceMsg.uint32_set_gender.get() == 1)) {
                  localCommonGuideInfo.jdField_a_of_type_Int = 2;
                } else if ((paramFromServiceMsg.uint32_set_birthday.has()) && (paramFromServiceMsg.uint32_set_birthday.get() == 1)) {
                  localCommonGuideInfo.jdField_a_of_type_Int = 3;
                } else if ((paramFromServiceMsg.uint32_set_head.has()) && (paramFromServiceMsg.uint32_set_head.get() == 1)) {
                  localCommonGuideInfo.jdField_a_of_type_Int = 4;
                } else if ((paramFromServiceMsg.uint32_set_school.has()) && (paramFromServiceMsg.uint32_set_school.get() == 1)) {
                  localCommonGuideInfo.jdField_a_of_type_Int = 5;
                } else if ((paramFromServiceMsg.uint32_set_region.has()) && (paramFromServiceMsg.uint32_set_region.get() == 1)) {
                  localCommonGuideInfo.jdField_a_of_type_Int = 6;
                } else if ((paramFromServiceMsg.uint32_set_company.has()) && (paramFromServiceMsg.uint32_set_company.get() == 1)) {
                  localCommonGuideInfo.jdField_a_of_type_Int = 7;
                } else {
                  localCommonGuideInfo.jdField_a_of_type_Int = 0;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("LoginWelcomeManager", 2, String.format("813 guide :type %s, url %s", new Object[] { Integer.valueOf(localCommonGuideInfo.jdField_a_of_type_Int), localCommonGuideInfo.jdField_a_of_type_JavaLangString }));
            }
            paramToServiceMsg[1] = localCommonGuideInfo;
            if ((localRspBody.uint32_need_not_req_nexttime.has()) && (localRspBody.uint32_need_not_req_nexttime.get() == 1)) {
              paramToServiceMsg[2] = Boolean.FALSE;
            } else {
              paramToServiceMsg[2] = Boolean.TRUE;
            }
            bool1 = true;
          }
          catch (Throwable paramObject)
          {
            paramFromServiceMsg = paramToServiceMsg;
            continue;
          }
        }
        else
        {
          paramObject = new StringBuilder();
          paramObject.append("handleRequestGuide sso failed: ");
          paramObject.append(paramToServiceMsg.uint32_result.get());
          QLog.e("LoginWelcomeManager", 1, paramObject.toString());
          paramToServiceMsg = paramFromServiceMsg;
          bool1 = bool2;
        }
      }
      catch (Throwable paramObject)
      {
        paramFromServiceMsg = localCommonGuideInfo;
        paramToServiceMsg = paramFromServiceMsg;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("LoginWelcomeManager", 2, "handleRequestGuide failed", paramObject);
          bool1 = bool2;
          paramToServiceMsg = paramFromServiceMsg;
        }
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleRequestGuide, result ");
        paramFromServiceMsg.append(bool1);
        QLog.d("LoginWelcomeManager", 2, paramFromServiceMsg.toString());
      }
      notifyUI(559, bool1, paramToServiceMsg, true);
      return;
      label861:
      bool1 = false;
      continue;
      label867:
      paramToServiceMsg = null;
      continue;
      label872:
      bool1 = false;
      continue;
      label878:
      paramToServiceMsg = null;
      continue;
      label883:
      paramFromServiceMsg = "";
      continue;
      label890:
      int i = 0;
      continue;
      label896:
      i = 0;
      continue;
      label902:
      paramFromServiceMsg = null;
      continue;
      label907:
      paramFromServiceMsg = null;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return LoginWelcomeManager.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.getServiceCmd().equals("OidbSvc.0x59f"))
    {
      if (paramToServiceMsg.extraData.getBoolean("isFirst")) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeHandler
 * JD-Core Version:    0.7.0.1
 */