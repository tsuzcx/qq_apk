package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.ReqBody;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.RspBody;

public class Oidb0xea3Sender
{
  private AppInterface a;
  private long b;
  private int c;
  private long d;
  private ArrayList<Long> e = new ArrayList();
  private List<oidb_0xea3.BackMsg> f = new ArrayList();
  private List<Long> g;
  
  public Oidb0xea3Sender(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.b = 0L;
    this.c = 0;
    this.d = 0L;
  }
  
  private void a(oidb_0xea3.RspBody paramRspBody)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleTroopImportantMsg_suc troopUin:");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("Oidb0xea3Sender", 2, ((StringBuilder)localObject).toString());
    localObject = (TroopShortcutBarHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    if (localObject == null) {
      return;
    }
    if (paramRspBody.back_group_msg.has()) {
      this.f.addAll(paramRspBody.back_group_msg.get());
    }
    ((TroopShortcutBarHandler)localObject).notifyUI(4, true, new Object[] { Long.valueOf(this.b), this.f, this.g });
    b();
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = this.f;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(Long.valueOf(((oidb_0xea3.BackMsg)((Iterator)localObject2).next()).addition_seq.get()));
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("msgSeqs:");
      ((StringBuilder)localObject2).append(((ArrayList)localObject1).toString());
      ((StringBuilder)localObject2).append(" mRspUnchangeSeqs:");
      localObject1 = this.g;
      if (localObject1 == null) {
        localObject1 = "[]";
      } else {
        localObject1 = localObject1.toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("Oidb0xea3Sender", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void b(oidb_0xea3.RspBody paramRspBody)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleTroopImportantMsg_tryNex troopUin:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",retryCount");
    ((StringBuilder)localObject).append(this.c);
    QLog.i("Oidb0xea3Sender", 2, ((StringBuilder)localObject).toString());
    if (paramRspBody.back_group_msg.has())
    {
      paramRspBody = paramRspBody.back_group_msg.get().iterator();
      while (paramRspBody.hasNext())
      {
        localObject = (oidb_0xea3.BackMsg)paramRspBody.next();
        if ((((oidb_0xea3.BackMsg)localObject).msg.has()) && (((oidb_0xea3.BackMsg)localObject).addition_seq.has()))
        {
          this.e.add(Long.valueOf(((oidb_0xea3.BackMsg)localObject).addition_seq.get()));
          this.f.add(localObject);
        }
      }
    }
    a();
  }
  
  public void a()
  {
    TroopShortcutBarHandler localTroopShortcutBarHandler = (TroopShortcutBarHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    if (localTroopShortcutBarHandler == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTroopImportantMsgInternal troopUin:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(",msgSeqs: ");
    ((StringBuilder)localObject).append(this.e.toString());
    ((StringBuilder)localObject).append(",retryCount");
    ((StringBuilder)localObject).append(this.c);
    QLog.i("Oidb0xea3Sender", 2, ((StringBuilder)localObject).toString());
    localObject = new oidb_0xea3.ReqBody();
    ((oidb_0xea3.ReqBody)localObject).group_code.set(this.b);
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      ((oidb_0xea3.ReqBody)localObject).msg_seq.add(localLong);
    }
    localObject = localTroopShortcutBarHandler.makeOIDBPkg("OidbSvcTcp.0xea3", 3747, 1, ((oidb_0xea3.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).extraData.putLong("sendSeq", this.d);
    localTroopShortcutBarHandler.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList)
  {
    this.d = paramLong2;
    this.b = paramLong1;
    if (paramArrayList != null)
    {
      this.e.clear();
      this.e.addAll(paramArrayList);
    }
  }
  
  public boolean a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((TroopShortcutBarHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE) == null) {
      return true;
    }
    oidb_0xea3.RspBody localRspBody = new oidb_0xea3.RspBody();
    int i = TroopShortcutBarHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i == 0)
    {
      if ((this.g == null) && (localRspBody.return_unchange_seq.has())) {
        this.g = localRspBody.return_unchange_seq.get();
      }
      a(localRspBody);
      return true;
    }
    if ((i >= 1900) && (i <= 2900))
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleTroopImportantMsg troopUin:");
      paramFromServiceMsg.append(this.b);
      paramFromServiceMsg.append(",result: ");
      paramFromServiceMsg.append(i);
      QLog.e("Oidb0xea3Sender", 2, paramFromServiceMsg.toString());
      if ((this.g == null) && (localRspBody.return_unchange_seq.has())) {
        this.g = localRspBody.return_unchange_seq.get();
      }
      this.c += 1;
      if (this.c >= 3)
      {
        a(localRspBody);
        return true;
      }
      b(localRspBody);
      return false;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleTroopImportantMsg troopUin:");
    paramFromServiceMsg.append(this.b);
    paramFromServiceMsg.append(",result: ");
    paramFromServiceMsg.append(i);
    QLog.e("Oidb0xea3Sender", 2, paramFromServiceMsg.toString());
    a(localRspBody);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.Oidb0xea3Sender
 * JD-Core Version:    0.7.0.1
 */