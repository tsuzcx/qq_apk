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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<oidb_0xea3.BackMsg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private long jdField_b_of_type_Long;
  private List<Long> jdField_b_of_type_JavaUtilList;
  
  public Oidb0xea3Sender(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void a(oidb_0xea3.RspBody paramRspBody)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleTroopImportantMsg_suc troopUin:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    QLog.i("Oidb0xea3Sender", 2, ((StringBuilder)localObject).toString());
    localObject = (TroopShortcutBarHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    if (localObject == null) {
      return;
    }
    if (paramRspBody.back_group_msg.has()) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramRspBody.back_group_msg.get());
    }
    ((TroopShortcutBarHandler)localObject).notifyUI(4, true, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList });
    b();
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = this.jdField_a_of_type_JavaUtilList;
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
      localObject1 = this.jdField_b_of_type_JavaUtilList;
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
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append(",retryCount");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.i("Oidb0xea3Sender", 2, ((StringBuilder)localObject).toString());
    if (paramRspBody.back_group_msg.has())
    {
      paramRspBody = paramRspBody.back_group_msg.get().iterator();
      while (paramRspBody.hasNext())
      {
        localObject = (oidb_0xea3.BackMsg)paramRspBody.next();
        if ((((oidb_0xea3.BackMsg)localObject).msg.has()) && (((oidb_0xea3.BackMsg)localObject).addition_seq.has()))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(((oidb_0xea3.BackMsg)localObject).addition_seq.get()));
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
      }
    }
    a();
  }
  
  public void a()
  {
    TroopShortcutBarHandler localTroopShortcutBarHandler = (TroopShortcutBarHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    if (localTroopShortcutBarHandler == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTroopImportantMsgInternal troopUin:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append(",msgSeqs: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.toString());
    ((StringBuilder)localObject).append(",retryCount");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.i("Oidb0xea3Sender", 2, ((StringBuilder)localObject).toString());
    localObject = new oidb_0xea3.ReqBody();
    ((oidb_0xea3.ReqBody)localObject).group_code.set(this.jdField_a_of_type_Long);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      ((oidb_0xea3.ReqBody)localObject).msg_seq.add(localLong);
    }
    localObject = localTroopShortcutBarHandler.makeOIDBPkg("OidbSvcTcp.0xea3", 3747, 1, ((oidb_0xea3.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).extraData.putLong("sendSeq", this.jdField_b_of_type_Long);
    localTroopShortcutBarHandler.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, ArrayList<Long> paramArrayList)
  {
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_Long = paramLong1;
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public boolean a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((TroopShortcutBarHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE) == null) {
      return true;
    }
    oidb_0xea3.RspBody localRspBody = new oidb_0xea3.RspBody();
    int i = TroopShortcutBarHandler.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i == 0)
    {
      if ((this.jdField_b_of_type_JavaUtilList == null) && (localRspBody.return_unchange_seq.has())) {
        this.jdField_b_of_type_JavaUtilList = localRspBody.return_unchange_seq.get();
      }
      a(localRspBody);
      return true;
    }
    if ((i >= 1900) && (i <= 2900))
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleTroopImportantMsg troopUin:");
      paramFromServiceMsg.append(this.jdField_a_of_type_Long);
      paramFromServiceMsg.append(",result: ");
      paramFromServiceMsg.append(i);
      QLog.e("Oidb0xea3Sender", 2, paramFromServiceMsg.toString());
      if ((this.jdField_b_of_type_JavaUtilList == null) && (localRspBody.return_unchange_seq.has())) {
        this.jdField_b_of_type_JavaUtilList = localRspBody.return_unchange_seq.get();
      }
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= 3)
      {
        a(localRspBody);
        return true;
      }
      b(localRspBody);
      return false;
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleTroopImportantMsg troopUin:");
    paramFromServiceMsg.append(this.jdField_a_of_type_Long);
    paramFromServiceMsg.append(",result: ");
    paramFromServiceMsg.append(i);
    QLog.e("Oidb0xea3Sender", 2, paramFromServiceMsg.toString());
    a(localRspBody);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.Oidb0xea3Sender
 * JD-Core Version:    0.7.0.1
 */