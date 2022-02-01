package com.tencent.mobileqq.phonecontact;

import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewerGuidePlugin.PhoneInfo;
import com.tencent.biz.webviewplugin.NewerGuidePlugin.RecommendedListResp;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xbf2.PhoneAddrBook;
import tencent.im.oidb.cmd0xbf2.ReqBody;
import tencent.im.oidb.cmd0xbf2.RspBody;
import tencent.im.oidb.oidb_0xbe8.PopupResult;
import tencent.im.oidb.oidb_0xbe8.ReqBody;
import tencent.im.oidb.oidb_0xbe8.RspBody;

public class ContactBindHandler
  extends BusinessHandler
{
  public ContactBindHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xbe8.RspBody localRspBody = new oidb_0xbe8.RspBody();
    int i = paramToServiceMsg.extraData.getInt("op_code");
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("ContactBindHandler", 2, String.format("handleShowBindPhonePage reqOpCode=%s result=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    long l;
    if (j == 0)
    {
      l = 0L;
      if (localRspBody.uint64_uin.has()) {
        l = localRspBody.uint64_uin.get();
      }
      if (!localRspBody.enum_op_code.has()) {
        break label303;
      }
    }
    label303:
    for (i = localRspBody.enum_op_code.get();; i = 0)
    {
      if (localRspBody.uint32_rsp_of_popup_flag.has()) {}
      for (j = localRspBody.uint32_rsp_of_popup_flag.get();; j = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactBindHandler", 2, String.format("handleShowBindPhonePage resUin=%s resOpCode=%s resFlag=%s", new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) }));
        }
        if (i == 2) {
          if (j == 1) {
            notifyUI(1, true, null);
          }
        }
        do
        {
          do
          {
            return;
            notifyUI(1, false, null);
            return;
            if (i == 4)
            {
              if (paramFromServiceMsg.isSuccess())
              {
                notifyUI(2, true, null);
                return;
              }
              notifyUI(2, false, null);
              return;
            }
          } while (i != 11);
          if (paramFromServiceMsg.isSuccess())
          {
            notifyUI(4, true, null);
            return;
          }
          notifyUI(4, false, null);
          return;
          if (i == 1)
          {
            notifyUI(1, false, null);
            return;
          }
        } while (i != 3);
        notifyUI(2, false, null);
        return;
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new NewerGuidePlugin.RecommendedListResp();
    try
    {
      Object localObject = new cmd0xbf2.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ContactBindHandler", 2, String.format("handleGetRecommendedList result=%s", new Object[] { Integer.valueOf(i) }));
      }
      paramToServiceMsg.jdField_a_of_type_Int = i;
      if (i != 0) {
        break label241;
      }
      paramToServiceMsg.b = ((cmd0xbf2.RspBody)localObject).uint32_end.get();
      paramToServiceMsg.jdField_a_of_type_Long = ((cmd0xbf2.RspBody)localObject).uint32_next_index.get();
      paramFromServiceMsg = ((cmd0xbf2.RspBody)localObject).phoneAddrBook.get();
      if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()))
      {
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (cmd0xbf2.PhoneAddrBook)paramFromServiceMsg.next();
          localObject = new NewerGuidePlugin.PhoneInfo();
          ((NewerGuidePlugin.PhoneInfo)localObject).a = paramObject.str_phone.get();
          ((NewerGuidePlugin.PhoneInfo)localObject).b = paramObject.str_nick.get();
          ((NewerGuidePlugin.PhoneInfo)localObject).c = paramObject.str_long_nick.get();
          ((NewerGuidePlugin.PhoneInfo)localObject).d = paramObject.str_head_url.get();
          paramToServiceMsg.jdField_a_of_type_JavaUtilList.add(localObject);
        }
      }
      notifyUI(3, true, paramToServiceMsg);
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.e("ContactBindHandler", 1, "handleGetRecommendedList fail.", paramFromServiceMsg);
      paramToServiceMsg.jdField_a_of_type_Int = -1;
      notifyUI(3, false, paramToServiceMsg);
      return;
    }
    return;
    label241:
    notifyUI(3, false, paramToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactBindHandler", 2, String.format("getRecommendedList uin=%s startIndex=%s num=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    try
    {
      Object localObject = new cmd0xbf2.ReqBody();
      ((cmd0xbf2.ReqBody)localObject).uint64_uin.set(paramLong);
      ((cmd0xbf2.ReqBody)localObject).uint64_start_index.set(paramInt1);
      ((cmd0xbf2.ReqBody)localObject).uint64_num.set(paramInt2);
      localObject = makeOIDBPkg("OidbSvc.0xbf2", 3058, 0, ((cmd0xbf2.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ContactBindHandler", 1, "getRecommendedList fail.", localThrowable);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactBindHandler", 2, String.format("queryShowBindPhonePage uin=%s", new Object[] { paramString }));
    }
    try
    {
      oidb_0xbe8.ReqBody localReqBody = new oidb_0xbe8.ReqBody();
      localReqBody.uint64_uin.set(Long.valueOf(paramString).longValue());
      localReqBody.enum_op_code.set(1);
      localReqBody.uint32_req_of_popup_flag.set(1);
      paramString = makeOIDBPkg("OidbSvc.0xbe8", 3048, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("op_code", 1);
      paramString.setTimeout(10000L);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ContactBindHandler", 1, "queryShowBindPhonePage fail.", paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactBindHandler", 2, String.format("reportCommonGuideWebOpen uin=%s type=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    try
    {
      oidb_0xbe8.ReqBody localReqBody = new oidb_0xbe8.ReqBody();
      localReqBody.uint64_uin.set(Long.valueOf(paramString).longValue());
      localReqBody.enum_op_code.set(10);
      paramString = new oidb_0xbe8.PopupResult();
      paramString.uint32_popup_result.set(0);
      paramString.uint32_popup_fieldid.set(paramInt);
      localReqBody.rpt_msg_popup_result.add(paramString);
      paramString = makeOIDBPkg("OidbSvc.0xbe8", 3048, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("op_code", 10);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ContactBindHandler", 1, "reportCommonGuideShowState fail.", paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ContactBindHandler", 2, String.format("setShowBindPhonePageResult uin=%s success=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      oidb_0xbe8.ReqBody localReqBody = new oidb_0xbe8.ReqBody();
      localReqBody.uint64_uin.set(Long.valueOf(paramString).longValue());
      localReqBody.enum_op_code.set(3);
      paramString = localReqBody.uint32_rst_of_popup_flag;
      if (paramBoolean) {
        i = 1;
      }
      paramString.set(i);
      paramString = makeOIDBPkg("OidbSvc.0xbe8", 3048, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("op_code", 3);
      paramString.setTimeout(10000L);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ContactBindHandler", 1, "setShowBindPhonePageResult fail.", paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactBindHandler", 2, String.format("reportContactsGuidePopWindowState uin=%s", new Object[] { paramString }));
    }
    try
    {
      oidb_0xbe8.ReqBody localReqBody = new oidb_0xbe8.ReqBody();
      localReqBody.uint64_uin.set(Long.valueOf(paramString).longValue());
      localReqBody.enum_op_code.set(8);
      localReqBody.uint32_mqq808_welcomepage_flag.set(1);
      paramString = makeOIDBPkg("OidbSvc.0xbe8", 3048, 0, localReqBody.toByteArray());
      paramString.extraData.putInt("op_code", 8);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ContactBindHandler", 1, "queryShowBindPhonePage fail.", paramString);
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xbe8");
      this.allowCmdSet.add("OidbSvc.0xbf2");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return ContactBindObserver2.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {}
    do
    {
      return;
      if ("OidbSvc.0xbe8".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xbf2".equals(str));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.ContactBindHandler
 * JD-Core Version:    0.7.0.1
 */