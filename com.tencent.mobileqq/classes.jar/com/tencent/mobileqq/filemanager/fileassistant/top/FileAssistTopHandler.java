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
  private boolean b = false;
  
  protected FileAssistTopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetFileAssistTop  isSuccess: ");
      paramToServiceMsg.append(bool1);
      QLog.i("FileAssistTopHandler<FileAssistant>", 1, paramToServiceMsg.toString());
    }
    if (bool1)
    {
      paramToServiceMsg = (byte[])paramObject;
      paramObject = new oidb_sso.OIDBSSOPkg();
      oidb_0x5eb.RspBody localRspBody = new oidb_0x5eb.RspBody();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramToServiceMsg);
        try
        {
          localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
        QLog.d("FileAssistTopHandler<FileAssistant>", 1, "handleSetFileAssistTop()  e =", paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramToServiceMsg = paramObject;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetFileAssistTop() :");
      paramFromServiceMsg.append(localRspBody.rpt_msg_uin_data.size());
      paramFromServiceMsg.append("，result:");
      paramFromServiceMsg.append(paramToServiceMsg.uint32_result.get());
      QLog.d("FileAssistTopHandler<FileAssistant>", 1, paramFromServiceMsg.toString());
      paramToServiceMsg = localRspBody.rpt_msg_uin_data.get().iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramToServiceMsg.next();
        paramFromServiceMsg.uint64_uin.get();
        if (paramFromServiceMsg.uint32_file_assist_top.has())
        {
          boolean bool2;
          if (paramFromServiceMsg.uint32_file_assist_top.get() == 1) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          this.b = bool2;
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetFileAssistTop  isTop:");
          paramFromServiceMsg.append(this.b);
          QLog.i("FileAssistTopHandler<FileAssistant>", 1, paramFromServiceMsg.toString());
          notifyUI(1, bool1, Boolean.valueOf(this.b));
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = ((Boolean)paramToServiceMsg.getAttribute("file_assist_top")).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("FileAssistTopHandler<FileAssistant>", 2, new Object[] { "handleSetFileAssistTop() isTop = ", Boolean.valueOf(bool2), " isSuccess = ", Boolean.valueOf(bool1) });
    }
    bool2 = bool1;
    if (bool1)
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.d("FileAssistTopHandler<FileAssistant>", 1, "handleSetFileAssistTop()  e =", paramFromServiceMsg);
      }
      if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    if (!bool2) {
      QLog.e("FileAssistTopHandler<FileAssistant>", 1, "handleSetFileAssistTop retult false!");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      QLog.e("FileAssistTopHandler<FileAssistant>", 1, "setFileAssistTop app null!");
      return;
    }
    Object localObject2 = ((QQAppInterface)localObject1).getCurrentUin();
    localObject1 = new oidb_0x587.ReqBody();
    for (;;)
    {
      try
      {
        long l = Long.parseLong((String)localObject2);
        ((oidb_0x587.ReqBody)localObject1).rpt_uint64_uins.add(Long.valueOf(l));
        localObject2 = ((oidb_0x587.ReqBody)localObject1).uint32_file_assist_top;
        if (paramBoolean)
        {
          i = 1;
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
      }
      catch (Exception localException)
      {
        QLog.d("FileAssistTopHandler<FileAssistant>", 1, "setFileAssistTop()  e =", localException);
        return;
      }
      int i = 0;
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onPush()  isTop: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("FileAssistTopHandler<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    String str = QFileAssistantUtils.b(this.a);
    RecentUserProxy localRecentUserProxy = this.a.getRecentUserProxy();
    RecentUser localRecentUser = localRecentUserProxy.c(str, 0);
    Object localObject = localRecentUser;
    if (localRecentUser == null) {
      localObject = new RecentUser(str, 0);
    }
    if (paramBoolean) {
      ((RecentUser)localObject).showUpTime = (System.currentTimeMillis() / 1000L);
    } else {
      ((RecentUser)localObject).showUpTime = 0L;
    }
    localRecentUserProxy.b((RecentUser)localObject);
    localObject = this.a.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1009);
    }
    this.b = paramBoolean;
    notifyUI(1, true, Boolean.valueOf(paramBoolean));
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      QLog.d("FileAssistTopHandler<FileAssistant>", 4, new Object[] { "onReceive() req.cmd = ", paramToServiceMsg.getServiceCmd() });
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive() req.cmd = ");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      QLog.i("FileAssistTopHandler<FileAssistant>", 1, localStringBuilder.toString());
    }
    if ("OidbSvc.oidb_0x587_fst".equals(paramToServiceMsg.getServiceCmd()))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x5eb_fst".equals(paramToServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.top.FileAssistTopHandler
 * JD-Core Version:    0.7.0.1
 */