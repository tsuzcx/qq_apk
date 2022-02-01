package com.tencent.mobileqq.troop.shortcutbar;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.Oidb0xea3Sender;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import tencent.im.oidb.cmd0xe0e.Oidb_0xe0e.ReqBody;
import tencent.im.oidb.cmd0xe0e.Oidb_0xe0e.RspBody;
import tencent.im.oidb.cmd0xe82.cmd0xe82.App;
import tencent.im.oidb.cmd0xe82.cmd0xe82.ClientInfo;
import tencent.im.oidb.cmd0xe82.cmd0xe82.ReqBody;
import tencent.im.oidb.cmd0xe82.cmd0xe82.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopShortcutBarHandler
  extends BusinessHandler
{
  public AtomicLong a = new AtomicLong(0L);
  private ConcurrentHashMap<Long, Oidb0xea3Sender> b = new ConcurrentHashMap();
  private TroopShortcutBarManager c;
  private QQAppInterface d;
  
  public TroopShortcutBarHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.d = paramQQAppInterface;
    this.c = ((TroopShortcutBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0xe82.RspBody localRspBody = new cmd0xe82.RspBody();
    long l1 = ((Long)paramToServiceMsg.getAttribute("troopcode", Long.valueOf(0L))).longValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("redpoint", Integer.valueOf(0))).intValue();
    paramToServiceMsg = paramToServiceMsg.getAttribute("extData", null);
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool;
    if (j == 0)
    {
      int k = localRspBody.cache_ts.get();
      int m = localRspBody.disabled.get();
      int n = localRspBody.group_disabled.get();
      int i1 = localRspBody.redpoint_cache_ts.get();
      long l2 = localRspBody.switch_ts.get();
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetTroopAIOShortcutBar group_disabled: ");
        paramFromServiceMsg.append(n);
        paramFromServiceMsg.append("disabled：");
        paramFromServiceMsg.append(m);
        paramFromServiceMsg.append("troopcode:");
        paramFromServiceMsg.append(l1);
        QLog.i("TroopShortcutBar", 2, paramFromServiceMsg.toString());
      }
      paramFromServiceMsg = new ArrayList();
      if (localRspBody.app.has())
      {
        paramObject = localRspBody.app.get().iterator();
        while (paramObject.hasNext()) {
          paramFromServiceMsg.add(TroopShortcutBarApp.a((cmd0xe82.App)paramObject.next()));
        }
      }
      paramFromServiceMsg = new TroopShortcutBarInfo(l1, k, m, n, i1, l2, paramFromServiceMsg);
      paramObject = (TroopShortcutBarManager)this.d.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramObject.a(Long.valueOf(l1), paramFromServiceMsg, bool, paramToServiceMsg);
      paramToServiceMsg = new StringBuilder();
      if (!paramFromServiceMsg.d().isEmpty())
      {
        i = 0;
        while (i < paramFromServiceMsg.d().size() - 1)
        {
          paramToServiceMsg.append(((TroopShortcutBarApp)paramFromServiceMsg.d().get(i)).d());
          paramToServiceMsg.append("|");
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("TroopShortcutBarHandler handleGetTroopAIOShortcutBar appList:");
          paramFromServiceMsg.append(paramToServiceMsg);
          paramFromServiceMsg.append("troopCode: ");
          paramFromServiceMsg.append(l1);
          QLog.i("TroopShortcutBar", 2, paramFromServiceMsg.toString());
        }
      }
    }
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    }
    notifyUI(1, bool, new Object[] { Long.valueOf(l1) });
  }
  
  private boolean a(long paramLong)
  {
    TroopShortcutBarInfo localTroopShortcutBarInfo = this.c.a(Long.valueOf(paramLong));
    if (localTroopShortcutBarInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopShortcutBar", 2, new Object[] { "checkPullRedPoint return true", " info is null" });
      }
      return true;
    }
    if ((localTroopShortcutBarInfo.d().size() > 0) && (System.currentTimeMillis() > localTroopShortcutBarInfo.e()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopShortcutBar", 2, "checkPullRedPoint return true");
      }
      return true;
    }
    return false;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0xe0e.RspBody localRspBody = new Oidb_0xe0e.RspBody();
    long l = ((Long)paramToServiceMsg.getAttribute("troopcode", Long.valueOf(0L))).longValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("disabled", Integer.valueOf(0))).intValue();
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("bisadmin", Boolean.valueOf(false))).booleanValue();
    int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (j == 0)
    {
      ((TroopShortcutBarManager)this.d.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(l, i, bool);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleSetTotalSwitch troopCode: ");
        paramToServiceMsg.append(l);
        paramToServiceMsg.append("disabled：");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append("bIsAdmin:");
        paramToServiceMsg.append(bool);
        QLog.i("TroopShortcutBar", 2, paramToServiceMsg.toString());
      }
    }
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    }
    notifyUI(2, bool, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("sendSeq", 0L);
    if ((this.b.containsKey(Long.valueOf(l))) && (((Oidb0xea3Sender)this.b.get(Long.valueOf(l))).a(paramFromServiceMsg, paramObject))) {
      this.b.remove(Long.valueOf(l));
    }
  }
  
  public void a(long paramLong, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TroopShortcutBarHandler getTroopAIOShortCutBar troopCode:");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(",troopType: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("TroopShortcutBar", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new cmd0xe82.ReqBody();
    ((cmd0xe82.ReqBody)localObject1).group_id.set(paramLong);
    ((cmd0xe82.ReqBody)localObject1).group_type.set(paramInt);
    if (StudyModeManager.h()) {
      ((cmd0xe82.ReqBody)localObject1).mode.set(1);
    }
    if (a(paramLong)) {
      ((cmd0xe82.ReqBody)localObject1).redpoint.set(1);
    }
    Object localObject2 = new cmd0xe82.ClientInfo();
    ((cmd0xe82.ClientInfo)localObject2).platform.set(2);
    ((cmd0xe82.ClientInfo)localObject2).version.set("8.8.17");
    ((cmd0xe82.ReqBody)localObject1).client.set((MessageMicro)localObject2);
    localObject2 = makeOIDBPkg("OidbSvc.0xe82", 3714, 1, ((cmd0xe82.ReqBody)localObject1).toByteArray(), 30000L);
    ((ToServiceMsg)localObject2).addAttribute("troopcode", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject2).addAttribute("trooptype", Integer.valueOf(paramInt));
    ((ToServiceMsg)localObject2).addAttribute("extData", paramObject);
    if (StudyModeManager.h()) {
      ((ToServiceMsg)localObject2).addAttribute("mode", Integer.valueOf(1));
    }
    if ((((cmd0xe82.ReqBody)localObject1).redpoint.has()) && (((cmd0xe82.ReqBody)localObject1).redpoint.get() == 1)) {
      ((ToServiceMsg)localObject2).addAttribute("redpoint", Integer.valueOf(1));
    }
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTotalSwitch troopCode: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("disabled：");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("TroopShortcutBar", 2, ((StringBuilder)localObject).toString());
    }
    if (((TroopShortcutBarManager)this.d.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(paramLong)) == null) {
      return;
    }
    Object localObject = new Oidb_0xe0e.ReqBody();
    ((Oidb_0xe0e.ReqBody)localObject).group_id.set(paramLong);
    ((Oidb_0xe0e.ReqBody)localObject).disabled.set(paramInt);
    localObject = makeOIDBPkg("OidbSvc.0xe0e", 3598, 1, ((Oidb_0xe0e.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).addAttribute("troopcode", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("disabled", Integer.valueOf(paramInt));
    ((ToServiceMsg)localObject).addAttribute("bisadmin", Boolean.valueOf(paramBoolean));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    long l = this.a.getAndIncrement();
    Oidb0xea3Sender localOidb0xea3Sender = new Oidb0xea3Sender(this.d);
    this.b.put(Long.valueOf(l), localOidb0xea3Sender);
    localOidb0xea3Sender.a(paramLong, l, paramArrayList);
    localOidb0xea3Sender.a();
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopShortcutBarObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TroopShortcutBarHandler onReceive resultCode:");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
        ((StringBuilder)localObject).append("errMsg: ");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getBusinessFailMsg());
        ((StringBuilder)localObject).append("serivceCmd: ");
        ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
        QLog.i("TroopShortcutBar", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramToServiceMsg.getServiceCmd();
      try
      {
        int i = ((oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject)).uint32_result.get();
        if ((i != 0) && (QLog.isColorLevel()))
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TroopShortcutBarHandler onReceive return Error result:");
          localStringBuilder1.append(i);
          localStringBuilder1.append("cmd：");
          localStringBuilder1.append(paramToServiceMsg.getServiceCmd());
          QLog.i("TroopShortcutBar", 2, localStringBuilder1.toString());
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("TroopShortcutBarHandler onReceive exception: ");
          localStringBuilder2.append(localInvalidProtocolBufferMicroException.getMessage());
          localStringBuilder2.append("cmd：");
          localStringBuilder2.append(paramToServiceMsg.getServiceCmd());
          QLog.i("TroopShortcutBar", 2, localStringBuilder2.toString());
        }
      }
      if ("OidbSvc.0xe82".equals(localObject))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe0e".equals(localObject))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvcTcp.0xea3".equals(localObject)) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    QLog.i("TroopShortcutBar", 2, "TroopShortcutBarHandler onReceive res == null || req == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler
 * JD-Core Version:    0.7.0.1
 */