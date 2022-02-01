package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3.GetQCallUinReq;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3.GetQCallUinRsp;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3.ReqBody;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QCallCardHandler
  extends BusinessHandler
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QCallCardHandler.OnGetQCallCardListener jdField_a_of_type_ComTencentMobileqqQcallQCallCardHandler$OnGetQCallCardListener = null;
  protected Set<String> a;
  
  public QCallCardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramFromServiceMsg.isSuccess())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCallCardHandler", 2, "handlerGetQcallCard  failed res.isSuccess() == false");
      }
      notifyUI(1, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (Exception paramFromServiceMsg)
    {
      QLog.w("QCallCardHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      QLog.w("QCallCardHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
    }
    int j = -1;
    int i = j;
    if (paramToServiceMsg != null)
    {
      i = j;
      if (paramToServiceMsg.uint32_result.has())
      {
        j = paramToServiceMsg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle oidb_0x5e3_1|OIDBSSOPke.result=");
          paramFromServiceMsg.append(j);
          QLog.i("QCallCardHandler", 2, paramFromServiceMsg.toString());
          i = j;
        }
      }
    }
    if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      paramToServiceMsg = new oidb_0x5e3.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg);
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.w("QCallCardHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.w("QCallCardHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
      }
      paramFromServiceMsg = paramToServiceMsg.rpt_uint64_not_exist_qcall_uins.get();
      QCallCardInfo localQCallCardInfo;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handlerGetQcallCard  is out of date qid:");
          paramObject.append(UinUtils.a(((Long)paramFromServiceMsg.get(0)).longValue()));
          QLog.i("QCallCardHandler", 2, paramObject.toString());
        }
        paramObject = (QCallCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QCALLCARD_MANAGER);
        localQCallCardInfo = paramObject.a(UinUtils.a(((Long)paramFromServiceMsg.get(0)).longValue()));
        if (localQCallCardInfo != null)
        {
          localQCallCardInfo.in_use_flag = 1;
          paramObject.a(localQCallCardInfo);
          notifyUI(1, true, null);
        }
        else
        {
          localQCallCardInfo = new QCallCardInfo();
          localQCallCardInfo.uin = UinUtils.a(((Long)paramFromServiceMsg.get(0)).longValue());
          localQCallCardInfo.in_use_flag = 1;
          paramObject.a(localQCallCardInfo);
          notifyUI(1, true, null);
        }
      }
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_get_qcall_uin_rsps.get();
      paramToServiceMsg = new ArrayList();
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (oidb_0x5e3.GetQCallUinRsp)paramFromServiceMsg.next();
        localQCallCardInfo = new QCallCardInfo();
        localQCallCardInfo.uin = UinUtils.a(paramObject.uint64_uin.get());
        localQCallCardInfo.nickname = paramObject.bytes_nick.get().toStringUtf8();
        localQCallCardInfo.gender = paramObject.uint32_gender.get();
        localQCallCardInfo.birthday = paramObject.uint32_birthday.get();
        localQCallCardInfo.remark = paramObject.bytes_remark.get().toStringUtf8();
        localQCallCardInfo.netstatus = paramObject.uint32_netstatus.get();
        localQCallCardInfo.qq = UinUtils.a(paramObject.uint32_qq.get());
        localQCallCardInfo.phonenum = paramObject.bytes_new_gsm.get().toStringUtf8();
        localQCallCardInfo.phone_mask = paramObject.uint32_mask_gsm.get();
        localQCallCardInfo.freeStatus = paramObject.uint32_is_call_free.get();
        localQCallCardInfo.pstn_freeStatus = paramObject.uint32_pstn.get();
        localQCallCardInfo.autoRemark = paramObject.bytes_qq_auto_remark.get().toStringUtf8();
        localQCallCardInfo.qqUin2 = UinUtils.a(paramObject.uint64_contact_qq.get());
        if (paramObject.uint32_is_ever_pstn.has()) {
          localQCallCardInfo.is_ever_pstn = paramObject.uint32_is_ever_pstn.get();
        }
        if (paramObject.uint32_vip_all_free_time.has()) {
          localQCallCardInfo.vip_all_free_time = paramObject.uint32_vip_all_free_time.get();
        }
        if (paramObject.uint32_profile_card_type.has()) {
          localQCallCardInfo.card_type = paramObject.uint32_profile_card_type.get();
        }
        if (paramObject.uint32_bind_qq_netstatus.has()) {
          localQCallCardInfo.qid_qq_status = paramObject.uint32_bind_qq_netstatus.get();
        }
        if (paramObject.uint32_contact_qq_netstatus.has()) {
          localQCallCardInfo.contact_qq_status = paramObject.uint32_contact_qq_netstatus.get();
        }
        localQCallCardInfo.vip_left_free_time = paramObject.uint32_vip_left_free_time.get();
        localQCallCardInfo.normal_all_free_time = paramObject.uint32_normal_all_free_time.get();
        localQCallCardInfo.normal_left_free_time = paramObject.uint32_normal_left_free_time.get();
        localQCallCardInfo.used_free_time = paramObject.uint32_used_free_time.get();
        localQCallCardInfo.identity = paramObject.uint32_identity.get();
        localQCallCardInfo.isPopup = paramObject.uint32_if_pop_up.get();
        paramToServiceMsg.add(localQCallCardInfo);
      }
      if (paramToServiceMsg.size() == 0)
      {
        QLog.i("QCallCardHandler", 1, "handlerGetQcallCard  failed cardQCalls.size() == 0");
        notifyUI(1, false, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QCallCardHandler", 2, "handlerGetQcallCard  success");
      }
      ((QCallCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QCALLCARD_MANAGER)).a((QCallCardInfo)paramToServiceMsg.get(0));
      notifyUI(1, true, Integer.valueOf(i));
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqQcallQCallCardHandler$OnGetQCallCardListener;
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(((QCallCardInfo)paramToServiceMsg.get(0)).nickname);
      }
    }
    else
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("failed  result=");
      paramToServiceMsg.append(i);
      QLog.i("QCallCardHandler", 1, paramToServiceMsg.toString());
      notifyUI(1, false, Integer.valueOf(i));
    }
  }
  
  public void a(QCallCardHandler.OnGetQCallCardListener paramOnGetQCallCardListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallCardHandler$OnGetQCallCardListener = paramOnGetQCallCardListener;
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getQcallCardSimpleInfo uin: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QCallCardHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (!StringUtil.c(paramString))
    {
      QLog.d("QCallCardHandler", 2, "Uin getQcallCardSimpleInfo uin is unValid!!!");
      return;
    }
    try
    {
      long l = UinUtils.a(paramString);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      paramString = new oidb_0x5e3.GetQCallUinReq();
      paramString.rpt_uint64_uins.set((List)localObject);
      paramString.uint32_req_nick.set(1);
      paramString.uint32_req_gender.set(1);
      paramString.uint32_req_birthday.set(1);
      localObject = new oidb_0x5e3.ReqBody();
      ((oidb_0x5e3.ReqBody)localObject).rpt_msg_get_qcall_uin_req.set(paramString);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1507);
      paramString.uint32_service_type.set(1);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5e3.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg("QcallOidbSvc.0x5e3_1");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException paramString)
    {
      label208:
      break label208;
    }
    QLog.d("QCallCardHandler", 2, "Uin getQcallCardSimpleInfo uin String to long NumberFormatException!!!");
  }
  
  public Set<String> getCommandList()
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("QcallOidbSvc.0x5e3_1");
    }
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QCallCardObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("QCallCardHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.i("QCallCardHandler", 2, String.format("onReceive FromServiceMsg(cmd=%s,resultCode=%d)", new Object[] { str, Integer.valueOf(i) }));
    }
    if (str.equals("QcallOidbSvc.0x5e3_1")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallCardHandler
 * JD-Core Version:    0.7.0.1
 */