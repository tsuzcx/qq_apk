package com.tencent.mobileqq.troop.robot.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotHandler;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0xce5.Oidb_0xce5.ReqBody;
import tencent.im.oidb.cmd0xce5.Oidb_0xce5.RobotInfo;
import tencent.im.oidb.cmd0xce5.Oidb_0xce5.RspBody;

public class TroopRobotHandler
  extends TroopBaseHandler
  implements ITroopRobotHandler
{
  public TroopRobotHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTroopRobot troopuin:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(" robotUin:");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(" status:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("TroopRobotHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Oidb_0xce5.ReqBody();
    ((Oidb_0xce5.ReqBody)localObject).group_id.set(paramLong1);
    Oidb_0xce5.RobotInfo localRobotInfo = new Oidb_0xce5.RobotInfo();
    localRobotInfo.status.set(paramInt);
    localRobotInfo.robot_uin.set(paramLong2);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(localRobotInfo);
    ((Oidb_0xce5.ReqBody)localObject).robot_info.set(localArrayList);
    localObject = makeOIDBPkg("OidbSvc.0xce5_1", 3301, 1, ((Oidb_0xce5.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).addAttribute("troopuin", Long.valueOf(paramLong1));
    ((ToServiceMsg)localObject).addAttribute("robotuin", Long.valueOf(paramLong2));
    ((ToServiceMsg)localObject).addAttribute("status", Integer.valueOf(paramInt));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      long l = ((Long)paramToServiceMsg.getAttribute("troopuin", Long.valueOf(0L))).longValue();
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetAllRobotList troopuin:");
        paramToServiceMsg.append(l);
        QLog.i("TroopRobotHandler", 2, paramToServiceMsg.toString());
      }
      paramToServiceMsg = new Oidb_0xce5.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramArrayOfByte, paramToServiceMsg);
      if (i == 0)
      {
        paramFromServiceMsg = new ArrayList(10);
        if (paramToServiceMsg.robot_info.has())
        {
          paramArrayOfByte = paramToServiceMsg.robot_info.get().iterator();
          while (paramArrayOfByte.hasNext()) {
            paramFromServiceMsg.add(TroopRobotInfo.a((Oidb_0xce5.RobotInfo)paramArrayOfByte.next()));
          }
        }
        int j = paramToServiceMsg.max_robot_num.get();
        paramToServiceMsg = (ITroopRobotService)this.appRuntime.getRuntimeService(ITroopRobotService.class, "all");
        paramToServiceMsg.onGetAllRobot(l, paramFromServiceMsg, j);
        notifyUI(TroopRobotObserver.b, true, new Object[] { Integer.valueOf(i), Long.valueOf(l), paramToServiceMsg.getTroopRobotData(l) });
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetAllRobotList failed result:");
        paramToServiceMsg.append(i);
        QLog.i("TroopRobotHandler", 2, paramToServiceMsg.toString());
      }
      notifyUI(TroopRobotObserver.b, false, new Object[] { Integer.valueOf(i), Long.valueOf(l), null });
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      long l1 = ((Long)paramToServiceMsg.getAttribute("troopuin", Long.valueOf(0L))).longValue();
      long l2 = ((Long)paramToServiceMsg.getAttribute("robotuin", Long.valueOf(0L))).longValue();
      int i = ((Integer)paramToServiceMsg.getAttribute("status", Integer.valueOf(0))).intValue();
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleSetRobot troopuin:");
        paramToServiceMsg.append(l1);
        paramToServiceMsg.append(" robotuin:");
        paramToServiceMsg.append(l2);
        paramToServiceMsg.append(" status:");
        paramToServiceMsg.append(i);
        QLog.i("TroopRobotHandler", 2, paramToServiceMsg.toString());
      }
      int j = parseOIDBPkg(paramFromServiceMsg, paramArrayOfByte, new Oidb_0xce5.RspBody());
      if (j == 0)
      {
        ((ITroopRobotService)this.appRuntime.getRuntimeService(ITroopRobotService.class, "all")).onSetTroopRobot(l1, l2, i);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleSetRobot failed result:");
          paramToServiceMsg.append(j);
          QLog.i("TroopRobotHandler", 2, paramToServiceMsg.toString());
        }
        if ((j == 10024) || (j == 10025))
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopRobotHandler", 2, "handleSetRobot get robotList");
          }
          a(l1);
        }
      }
      int k = TroopRobotObserver.c;
      boolean bool;
      if (j == 0) {
        bool = true;
      } else {
        bool = false;
      }
      notifyUI(k, bool, new Object[] { Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
    }
  }
  
  private void b(String paramString)
  {
    paramString = new TroopRobotHandler.1(this, paramString);
    this.appRuntime.addDefaultObservers(paramString);
  }
  
  protected String a()
  {
    return "TroopRobotHandler";
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAllRobotList troopuin:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("TroopRobotHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Oidb_0xce5.ReqBody();
    ((Oidb_0xce5.ReqBody)localObject).group_id.set(paramLong);
    localObject = makeOIDBPkg("OidbSvc.0xce5_0", 3301, 0, ((Oidb_0xce5.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).addAttribute("troopuin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a(paramLong1, paramLong2, 1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      long l = ((Long)paramToServiceMsg.getAttribute("troopuin", Long.valueOf(0L))).longValue();
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleAddedRobotList troopuin:");
        paramToServiceMsg.append(l);
        QLog.i("TroopRobotHandler", 2, paramToServiceMsg.toString());
      }
      paramToServiceMsg = new Oidb_0xce5.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        paramFromServiceMsg = new ArrayList(10);
        if (paramToServiceMsg.robot_info.has())
        {
          paramToServiceMsg = paramToServiceMsg.robot_info.get().iterator();
          while (paramToServiceMsg.hasNext()) {
            paramFromServiceMsg.add(TroopRobotInfo.a((Oidb_0xce5.RobotInfo)paramToServiceMsg.next()));
          }
        }
        ((ITroopRobotService)this.appRuntime.getRuntimeService(ITroopRobotService.class, "all")).onGetAddedRobot(l, paramFromServiceMsg);
        notifyUI(TroopRobotObserver.d, true, new Object[] { Integer.valueOf(i), Long.valueOf(l), paramFromServiceMsg });
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleAddedRobotList failed result:");
        paramToServiceMsg.append(i);
        QLog.i("TroopRobotHandler", 2, paramToServiceMsg.toString());
      }
      notifyUI(TroopRobotObserver.d, false, new Object[] { Integer.valueOf(i), Long.valueOf(l), null });
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopRobotPrivilege ");
      ((StringBuilder)localObject).append(paramString);
      QLog.w("TroopRobotHandler", 2, ((StringBuilder)localObject).toString());
    }
    b(paramString);
    Object localObject = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject).uint32_app_privilege_flag.set(0);
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.appRuntime.getBusinessHandler(TroopInfoHandler.class.getName());
    try
    {
      localITroopInfoHandler.a(Long.valueOf(Long.parseLong(paramString)), (oidb_0x88d.GroupInfo)localObject, "SUBCMD_GET_TROOP_ROBOT_PRIVILEGE");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRobotMemberChangeFromWeb : troopUin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" robotUin:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" robotName:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" isAdd:");
      localStringBuilder.append(paramBoolean);
      QLog.d("TroopRobotHandlerRobotMemberChange", 2, localStringBuilder.toString());
    }
    notifyUI(TroopRobotObserver.e, true, new Object[] { paramBoolean, paramString1, paramString2, paramString3 });
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAddedRobotList troopuin:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("TroopRobotHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Oidb_0xce5.ReqBody();
    ((Oidb_0xce5.ReqBody)localObject).group_id.set(paramLong);
    localObject = makeOIDBPkg("OidbSvc.0xce5_3", 3301, 3, ((Oidb_0xce5.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).addAttribute("troopuin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getRobotRedList ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("TroopRobotHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Oidb_0xce5.ReqBody();
    ((Oidb_0xce5.ReqBody)localObject).group_id.set(paramLong);
    localObject = makeOIDBPkg("OidbSvc.0xce5_6", 3301, 6, ((Oidb_0xce5.ReqBody)localObject).toByteArray(), 30000L);
    ((ToServiceMsg)localObject).extraData.putString("troopUin", String.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xce5_0");
      this.allowCmdSet.add("OidbSvc.0xce5_1");
      this.allowCmdSet.add("OidbSvc.0xce5_3");
      this.allowCmdSet.add("OidbSvc.0xce5_6");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopRobotObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopRobotHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopRobotHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0xce5_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
      if ("OidbSvc.0xce5_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
        return;
      }
      if ("OidbSvc.0xce5_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xce5_6".equals(paramFromServiceMsg.getServiceCmd())) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopRobotHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.impl.TroopRobotHandler
 * JD-Core Version:    0.7.0.1
 */