package com.tencent.mobileqq.filemanager.fileassistant.top;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x587.oidb_0x587.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FileAssistTopHandler
  extends BusinessHandler
{
  public QQAppInterface a;
  private boolean a;
  
  protected FileAssistTopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    oidb_0x5eb.RspBody localRspBody;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("FileAssistTopHandler<FileAssistant>", 1, "handleGetFileAssistTop  isSuccess: " + bool1);
      }
      if (bool1)
      {
        paramToServiceMsg = (byte[])paramObject;
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        localRspBody = new oidb_0x5eb.RspBody();
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          try
          {
            localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            QLog.d("FileAssistTopHandler<FileAssistant>", 1, "handleGetFileAssistTop() :" + localRspBody.rpt_msg_uin_data.size() + "，result:" + paramToServiceMsg.uint32_result.get());
            paramToServiceMsg = localRspBody.rpt_msg_uin_data.get().iterator();
            if (!paramToServiceMsg.hasNext()) {
              break label293;
            }
            paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramToServiceMsg.next();
            paramFromServiceMsg.uint64_uin.get();
            if (!paramFromServiceMsg.uint32_file_assist_top.has()) {
              continue;
            }
            if (paramFromServiceMsg.uint32_file_assist_top.get() != 1) {
              break label287;
            }
            bool2 = true;
            this.jdField_a_of_type_Boolean = bool2;
            QLog.i("FileAssistTopHandler<FileAssistant>", 1, "handleGetFileAssistTop  isTop:" + this.jdField_a_of_type_Boolean);
            notifyUI(1, bool1, Boolean.valueOf(this.jdField_a_of_type_Boolean));
            continue;
            bool1 = false;
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            boolean bool2;
            break label275;
          }
          paramObject = paramObject;
          paramToServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
        }
        label275:
        QLog.d("FileAssistTopHandler<FileAssistant>", 1, "handleSetFileAssistTop()  e =", paramFromServiceMsg);
        continue;
        label287:
        bool2 = false;
      }
    }
    label293:
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      boolean bool3 = ((Boolean)paramToServiceMsg.getAttribute("file_assist_top")).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("FileAssistTopHandler<FileAssistant>", 2, new Object[] { "handleSetFileAssistTop() isTop = ", Boolean.valueOf(bool3), " isSuccess = ", Boolean.valueOf(bool1) });
      }
      if (bool1)
      {
        paramFromServiceMsg = (byte[])paramObject;
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
    }
    else
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          QLog.d("FileAssistTopHandler<FileAssistant>", 1, "handleSetFileAssistTop()  e =", paramFromServiceMsg);
        }
      }
      bool1 = bool2;
      if (paramToServiceMsg.uint32_result.has())
      {
        bool1 = bool2;
        if (paramToServiceMsg.uint32_result.get() == 0) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (!bool1) {
        QLog.e("FileAssistTopHandler<FileAssistant>", 1, "handleSetFileAssistTop retult false!");
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("FileAssistTopHandler<FileAssistant>", 1, "setFileAssistTop app null!");
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    Object localObject1 = new oidb_0x587.ReqBody();
    try
    {
      long l = Long.parseLong((String)localObject2);
      ((oidb_0x587.ReqBody)localObject1).rpt_uint64_uins.add(Long.valueOf(l));
      localObject2 = ((oidb_0x587.ReqBody)localObject1).uint32_file_assist_top;
      if (paramBoolean) {
        i = 1;
      }
      ((PBUInt32Field)localObject2).set(i);
      localObject1 = makeOIDBPkg("OidbSvc.oidb_0x587_fst", 1415, 74, ((oidb_0x587.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("file_assist_top", Boolean.valueOf(paramBoolean));
      if (QLog.isColorLevel()) {
        QLog.d("FileAssistTopHandler<FileAssistant>", 2, new Object[] { "setFileAssistTop() setTop =", Boolean.valueOf(paramBoolean) });
      }
      sendPbReq((ToServiceMsg)localObject1);
      b(paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FileAssistTopHandler<FileAssistant>", 1, "setFileAssistTop()  e =", localException);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileAssistTopHandler<FileAssistant>", 1, " onPush()  isTop: " + paramBoolean);
    }
    String str = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy();
    RecentUser localRecentUser = localRecentUserProxy.b(str, 0);
    Object localObject = localRecentUser;
    if (localRecentUser == null) {
      localObject = new RecentUser(str, 0);
    }
    if (paramBoolean) {}
    for (((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);; ((RecentUser)localObject).showUpTime = 0L)
    {
      localRecentUserProxy.b((RecentUser)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      notifyUI(1, true, Boolean.valueOf(paramBoolean));
      return;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.oidb_0x587_fst");
      this.allowCmdSet.add("OidbSvc.0x5eb_fst");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      QLog.d("FileAssistTopHandler<FileAssistant>", 4, new Object[] { "onReceive() req.cmd = ", paramToServiceMsg.getServiceCmd() });
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("FileAssistTopHandler<FileAssistant>", 1, "onReceive() req.cmd = " + paramToServiceMsg.getServiceCmd());
      }
      if ("OidbSvc.oidb_0x587_fst".equals(paramToServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x5eb_fst".equals(paramToServiceMsg.getServiceCmd()));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.top.FileAssistTopHandler
 * JD-Core Version:    0.7.0.1
 */