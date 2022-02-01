package com.tencent.mobileqq.confess;

import android.os.Bundle;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
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
import tencent.im.oidb.cmd0xbc3.oidb_0xbc3.RspBody;

public class ConfessHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public ConfessHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject;
    String str;
    int j;
    int k;
    int m;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      localObject = paramToServiceMsg.extraData;
      str = "";
      localObject = ((Bundle)localObject).getString("frdUin", "");
      j = paramToServiceMsg.extraData.getInt("shieldHours", 0);
      k = paramToServiceMsg.extraData.getInt("uinType", 0);
      m = paramToServiceMsg.extraData.getInt("topicId", 0);
    }
    try
    {
      paramToServiceMsg = (ConfessInfo)paramToServiceMsg.extraData.getSerializable("confessInfo");
    }
    catch (Exception paramToServiceMsg)
    {
      label82:
      oidb_0xb67.RspBody localRspBody;
      int n;
      int i;
      break label82;
    }
    paramToServiceMsg = null;
    localRspBody = new oidb_0xb67.RspBody();
    n = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (n == 0)
    {
      if (localRspBody.uint32_result.has()) {
        i = localRspBody.uint32_result.get();
      } else {
        i = 0;
      }
      paramFromServiceMsg = str;
      if (localRspBody.bytes_err_msg.has()) {
        paramFromServiceMsg = localRspBody.bytes_err_msg.get().toStringUtf8();
      }
      if (i == 0)
      {
        if (j == -1) {
          ConfessMsgUtil.a(this.a, (String)localObject, ConfessConfig.e, k, m, paramToServiceMsg);
        } else {
          ConfessMsgUtil.a(this.a, (String)localObject, k, m, paramToServiceMsg);
        }
        notifyUI(3, true, new Object[] { localObject, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), null, paramToServiceMsg });
      }
      else
      {
        notifyUI(3, false, new Object[] { localObject, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), paramFromServiceMsg, null });
      }
      if (QLog.isColorLevel()) {
        QLog.i("ConfessHandler", 2, String.format("handleSetShieldFlag result:%d rspResult:%d frdUin:%s hours:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i), localObject, Integer.valueOf(j) }));
      }
    }
    else
    {
      paramToServiceMsg = "";
      paramFromServiceMsg = localRspBody.bytes_err_msg.get().toStringUtf8();
      if (QLog.isColorLevel())
      {
        if (paramFromServiceMsg != null) {
          paramToServiceMsg = paramFromServiceMsg;
        }
        QLog.i("ConfessHandler", 2, String.format("handleSetShieldFlag failed result:%d msg:%s", new Object[] { Integer.valueOf(n), paramToServiceMsg }));
      }
      notifyUI(3, false, new Object[] { localObject, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), paramFromServiceMsg, null });
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, ConfessConfig paramConfessConfig)
  {
    long l1 = MessageCache.c();
    long l2 = ConfessConfig.b(paramQQAppInterface, "redpoint_box_show");
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.i("ConfessHandler", 2, String.format("onNeedShowBoxRedPoint oldRedPointTs:%d", new Object[] { Long.valueOf(l2) }));
    }
    ConfessConfig.a(paramQQAppInterface, "redpoint_box_show", l1);
    ConfessMsgUtil.a(paramQQAppInterface, false, true);
    paramQQAppInterface.getMessageFacade().a().m(AppConstants.CONFESS_UIN, 1032);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getProxyManager().g();
    RecentUser localRecentUser1 = localRecentUserProxy.c(AppConstants.CONFESS_UIN, 1032);
    if (localRecentUser1 == null) {
      localRecentUser1 = new RecentUser(AppConstants.CONFESS_UIN, 1032);
    }
    RecentUser localRecentUser2;
    for (localRecentUser1.lastmsgtime = l1;; localRecentUser1.lastmsgtime = l1)
    {
      i = 1;
      localRecentUser2 = localRecentUser1;
      break;
      localRecentUser2 = localRecentUser1;
      if (localRecentUser1.lastmsgtime >= l1) {
        break;
      }
    }
    if (i != 0)
    {
      localRecentUserProxy.b(localRecentUser2);
      paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
    }
    notifyUI(4, true, paramConfessConfig);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      long l1 = paramToServiceMsg.extraData.getLong("fromUin", 0L);
      long l2 = paramToServiceMsg.extraData.getLong("toUin", 0L);
      int i = paramToServiceMsg.extraData.getInt("topicId", 0);
      int j = paramToServiceMsg.extraData.getInt("type", 0);
      boolean bool = paramToServiceMsg.extraData.getBoolean("isConfessor", false);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetHolmesProgress fUin:");
        paramToServiceMsg.append(l1);
        paramToServiceMsg.append(" tUin:");
        paramToServiceMsg.append(l2);
        paramToServiceMsg.append(" topicid:");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append(" type:");
        paramToServiceMsg.append(j);
        paramToServiceMsg.append(" isConfessor:");
        paramToServiceMsg.append(bool);
        QLog.i("ConfessHandler", 2, paramToServiceMsg.toString());
      }
      paramToServiceMsg = new oidb_0xbc3.RspBody();
      int k = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (k == 0)
      {
        if ((paramToServiceMsg.uint32_cur_count.has()) && (paramToServiceMsg.uint32_total_count.has()))
        {
          k = paramToServiceMsg.uint32_cur_count.get();
          int m = paramToServiceMsg.uint32_total_count.get();
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetHolmesProgress curCount:");
            paramToServiceMsg.append(k);
            paramToServiceMsg.append(" totalCount:");
            paramToServiceMsg.append(m);
            QLog.i("ConfessHandler", 2, paramToServiceMsg.toString());
          }
          notifyUI(8, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ConfessHandler", 2, "handleGetHolmesProgress failed no msg");
        }
        notifyUI(8, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(bool) });
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetHolmesProgress failed result:");
        paramToServiceMsg.append(k);
        QLog.i("ConfessHandler", 2, paramToServiceMsg.toString());
      }
      notifyUI(8, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(bool) });
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, ConfessConfig paramConfessConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, "onNeedShowLebaRedPoint");
    }
    ConfessConfig.a(paramQQAppInterface, "redpoint_leba_show", MessageCache.c());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(QQAppInterface paramQQAppInterface, ConfessConfig paramConfessConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, String.format("onGetNewConfig boxEntry:%d contactEntry:%d", new Object[] { Integer.valueOf(paramConfessConfig.z), Integer.valueOf(paramConfessConfig.A) }));
    }
    if (paramConfessConfig.z == 2) {
      b(paramQQAppInterface, paramConfessConfig);
    }
    if (paramConfessConfig.A == 2) {
      c(paramQQAppInterface, paramConfessConfig);
    }
  }
  
  public void a(FrdConfessInfo paramFrdConfessInfo)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((QQAppInterface)localObject).getProxyManager().g().c(AppConstants.CONFESS_UIN, 1032) != null)
    {
      localObject = this.a.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
    }
    notifyUI(2, true, paramFrdConfessInfo);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo, int paramInt3)
  {
    if (paramConfessInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessHandler", 2, String.format("setSetShieldFlag frdUin:%s uinType:%d topicId:%d hours:%d confessinfo:%s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramConfessInfo.toString() }));
    }
    long l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString);
      l1 = l2;
      boolean bool = Friends.isValidUin(l2);
      if (bool) {
        break label111;
      }
      return;
    }
    catch (Exception localException)
    {
      long l2;
      label88:
      Object localObject;
      break label88;
    }
    l2 = l1;
    if (QLog.isColorLevel())
    {
      QLog.i("ConfessHandler", 2, "setSetShieldFlag parseUin error return");
      l2 = l1;
    }
    label111:
    if (paramInt3 == -1) {
      localObject = "0X80091A3";
    } else {
      localObject = "0X80091A2";
    }
    ReportController.b(this.a, "dc00898", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    localObject = new oidb_0xb67.ReqBody();
    ((oidb_0xb67.ReqBody)localObject).uint64_shield_uin.set(l2);
    ((oidb_0xb67.ReqBody)localObject).int64_expire_time.set(paramInt3);
    localObject = makeOIDBPkg("OidbSvc.cmd0xb67", 2919, 1, ((oidb_0xb67.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("frdUin", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("uinType", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("topicId", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("shieldHours", paramInt3);
    ((ToServiceMsg)localObject).extraData.putSerializable("confessInfo", paramConfessInfo);
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(FrdConfessInfo paramFrdConfessInfo)
  {
    if (this.a == null) {
      return;
    }
    if ((paramFrdConfessInfo != null) && (paramFrdConfessInfo.c()))
    {
      RecentUserProxy localRecentUserProxy = this.a.getProxyManager().g();
      RecentUser localRecentUser = localRecentUserProxy.c(AppConstants.CONFESS_UIN, 1032);
      int i = 0;
      if (localRecentUser == null)
      {
        localRecentUser = new RecentUser();
        localRecentUser.uin = AppConstants.CONFESS_UIN;
        localRecentUser.setType(1032);
        localRecentUser.lastmsgtime = paramFrdConfessInfo.c;
      }
      Object localObject;
      for (paramFrdConfessInfo = localRecentUser;; paramFrdConfessInfo = localRecentUser)
      {
        i = 1;
        localObject = paramFrdConfessInfo;
        break;
        localObject = localRecentUser;
        if (localRecentUser.lastmsgtime >= paramFrdConfessInfo.c) {
          break;
        }
        localRecentUser.lastmsgtime = paramFrdConfessInfo.c;
      }
      if (i != 0)
      {
        localRecentUserProxy.b((RecentUser)localObject);
        paramFrdConfessInfo = this.a.getHandler(Conversation.class);
        if (paramFrdConfessInfo != null) {
          paramFrdConfessInfo.sendEmptyMessage(1009);
        }
      }
    }
    notifyUI(1, true, null);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.cmd0xb67");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ConfessObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.cmd0xb67".equals(str))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.cmd0xbc3".equals(str)) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessHandler
 * JD-Core Version:    0.7.0.1
 */