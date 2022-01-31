package com.tencent.mobileqq.confess;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb67.oidb_0xb67.ReqBody;
import tencent.im.oidb.cmd0xb67.oidb_0xb67.RspBody;

public class ConfessHandler
  extends BusinessHandler
{
  public ConfessHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(QQAppInterface paramQQAppInterface, ConfessConfig paramConfessConfig)
  {
    int i = 0;
    long l1 = MessageCache.a();
    long l2 = ConfessConfig.a(paramQQAppInterface, "redpoint_box_show");
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, String.format("onNeedShowBoxRedPoint oldRedPointTs:%d", new Object[] { Long.valueOf(l2) }));
    }
    ConfessConfig.a(paramQQAppInterface, "redpoint_box_show", l1);
    ConfessMsgUtil.a(paramQQAppInterface, false, true);
    paramQQAppInterface.a().a().d(AppConstants.aF, 1032);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.aF, 1032);
    if (localRecentUser == null)
    {
      paramQQAppInterface = new RecentUser();
      paramQQAppInterface.uin = AppConstants.aF;
      paramQQAppInterface.type = 1032;
      paramQQAppInterface.lastmsgtime = l1;
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localRecentUserProxy.a(paramQQAppInterface);
        paramQQAppInterface = this.a.getHandler(Conversation.class);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.sendEmptyMessage(1009);
        }
      }
      a(4, true, paramConfessConfig);
      return;
      paramQQAppInterface = localRecentUser;
      if (localRecentUser.lastmsgtime < l1)
      {
        localRecentUser.lastmsgtime = l1;
        i = 1;
        paramQQAppInterface = localRecentUser;
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    for (;;)
    {
      return;
      String str = paramToServiceMsg.extraData.getString("frdUin", "");
      int j = paramToServiceMsg.extraData.getInt("shieldHours", 0);
      int k = paramToServiceMsg.extraData.getInt("uinType", 0);
      int m = paramToServiceMsg.extraData.getInt("topicId", 0);
      oidb_0xb67.RspBody localRspBody = null;
      try
      {
        paramToServiceMsg = (ConfessInfo)paramToServiceMsg.extraData.getSerializable("confessInfo");
        localRspBody = new oidb_0xb67.RspBody();
        int n = a(paramFromServiceMsg, paramObject, localRspBody);
        if (n == 0)
        {
          int i;
          if (localRspBody.uint32_result.has())
          {
            i = localRspBody.uint32_result.get();
            label118:
            if (!localRspBody.bytes_err_msg.has()) {
              break label273;
            }
            paramFromServiceMsg = localRspBody.bytes_err_msg.get().toStringUtf8();
            label141:
            if (i != 0) {
              break label296;
            }
            if (j != -1) {
              break label279;
            }
            ConfessMsgUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str, "已永久屏蔽对方的坦白说消息", k, m, paramToServiceMsg);
            label168:
            a(3, true, new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), null, paramToServiceMsg });
          }
          while (QLog.isColorLevel())
          {
            QLog.i("ConfessHandler", 2, String.format("handleSetShieldFlag result:%d rspResult:%d frdUin:%s hours:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), str, Integer.valueOf(j) }));
            return;
            i = 0;
            break label118;
            label273:
            paramFromServiceMsg = "";
            break label141;
            label279:
            ConfessMsgUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str, k, m, paramToServiceMsg);
            break label168;
            label296:
            a(3, false, new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), paramFromServiceMsg, null });
          }
        }
        paramFromServiceMsg = localRspBody.bytes_err_msg.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          if (paramFromServiceMsg != null) {
            break label448;
          }
        }
        label448:
        for (paramToServiceMsg = "";; paramToServiceMsg = paramFromServiceMsg)
        {
          QLog.i("ConfessHandler", 2, String.format("handleSetShieldFlag failed result:%d msg:%s", new Object[] { Integer.valueOf(n), paramToServiceMsg }));
          a(3, false, new Object[] { str, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), paramFromServiceMsg, null });
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          paramToServiceMsg = localRspBody;
        }
      }
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, ConfessConfig paramConfessConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, "onNeedShowContactRedPoint");
    }
    paramConfessConfig.c();
    ConfessConfig.a(paramQQAppInterface, "redpoint_contact_show", MessageCache.a());
    ((ConfessHandler)this.a.getBusinessHandler(125)).a(6, true, null);
  }
  
  protected Class a()
  {
    return ConfessObserver.class;
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfessConfig paramConfessConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, String.format("onGetNewConfig boxEntry:%d contactEntry:%d", new Object[] { Integer.valueOf(paramConfessConfig.g), Integer.valueOf(paramConfessConfig.h) }));
    }
    if (paramConfessConfig.g == 2) {
      b(paramQQAppInterface, paramConfessConfig);
    }
    if (paramConfessConfig.h == 2) {
      c(paramQQAppInterface, paramConfessConfig);
    }
  }
  
  public void a(FrdConfessInfo paramFrdConfessInfo)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(AppConstants.aF, 1032) != null)
    {
      MqqHandler localMqqHandler = this.a.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
    }
    a(2, true, paramFrdConfessInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.cmd0xb67".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo, int paramInt3)
  {
    if (paramConfessInfo == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ConfessHandler", 2, String.format("setSetShieldFlag frdUin:%s uinType:%d topicId:%d hours:%d confessinfo:%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramConfessInfo.toString() }));
      }
      long l1 = 0L;
      try
      {
        l2 = Long.parseLong(paramString);
        l1 = l2;
        boolean bool = Friends.isValidUin(l2);
        if (!bool) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          if (QLog.isColorLevel()) {
            QLog.i("ConfessHandler", 2, "setSetShieldFlag parseUin error return");
          }
          long l2 = l1;
          continue;
          String str = "0X80091A2";
        }
      }
    }
    if (paramInt3 == -1)
    {
      localObject = "0X80091A3";
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      localObject = new oidb_0xb67.ReqBody();
      ((oidb_0xb67.ReqBody)localObject).uint64_shield_uin.set(l2);
      ((oidb_0xb67.ReqBody)localObject).int64_expire_time.set(paramInt3);
      localObject = a("OidbSvc.cmd0xb67", 2919, 1, ((oidb_0xb67.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("frdUin", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("uinType", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("topicId", paramInt2);
      ((ToServiceMsg)localObject).extraData.putInt("shieldHours", paramInt3);
      ((ToServiceMsg)localObject).extraData.putSerializable("confessInfo", paramConfessInfo);
      super.b((ToServiceMsg)localObject);
      return;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.cmd0xb67");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b(FrdConfessInfo paramFrdConfessInfo)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser2;
    int i;
    RecentUser localRecentUser1;
    if ((paramFrdConfessInfo != null) && (paramFrdConfessInfo.a()))
    {
      localRecentUserProxy = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser2 = localRecentUserProxy.b(AppConstants.aF, 1032);
      i = 0;
      if (localRecentUser2 != null) {
        break label123;
      }
      localRecentUser1 = new RecentUser();
      localRecentUser1.uin = AppConstants.aF;
      localRecentUser1.type = 1032;
      localRecentUser1.lastmsgtime = paramFrdConfessInfo.a;
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localRecentUserProxy.a(localRecentUser1);
        paramFrdConfessInfo = this.a.getHandler(Conversation.class);
        if (paramFrdConfessInfo != null) {
          paramFrdConfessInfo.sendEmptyMessage(1009);
        }
      }
      a(1, true, null);
      return;
      label123:
      localRecentUser1 = localRecentUser2;
      if (localRecentUser2.lastmsgtime < paramFrdConfessInfo.a)
      {
        localRecentUser2.lastmsgtime = paramFrdConfessInfo.a;
        i = 1;
        localRecentUser1 = localRecentUser2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessHandler
 * JD-Core Version:    0.7.0.1
 */